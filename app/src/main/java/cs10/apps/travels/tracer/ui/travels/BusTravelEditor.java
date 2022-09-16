package cs10.apps.travels.tracer.ui.travels;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;

import cs10.apps.travels.tracer.R;
import cs10.apps.travels.tracer.Utils;
import cs10.apps.travels.tracer.databinding.ActivityTravelCreatorBinding;
import cs10.apps.travels.tracer.databinding.ContentTravelCreatorBinding;
import cs10.apps.travels.tracer.model.Parada;
import cs10.apps.travels.tracer.model.Viaje;

public class BusTravelEditor extends CommonTravelEditor {
    private ContentTravelCreatorBinding content;
    private AdapterView.OnItemSelectedListener onStartPlaceSelected, onEndPlaceSelected;
    private int startIndex, endIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTravelCreatorBinding binding = ActivityTravelCreatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        content = binding.contentTravelCreator;
        onStartPlaceSelected = new OnStartPlaceSelected();
        onEndPlaceSelected = new OnEndPlaceSelected();

        super.prepare(db -> db.paradasDao().getAll(), content.redSubeHeader);
        super.setFabBehavior(binding.fab);

        Utils.loadBusBanner(binding.appbarImage);
        binding.fabStop.setVisibility(View.GONE);
        binding.toolbarLayout.setTitle(getString(R.string.edit_travel));
    }

    @Override
    public void setSpinners() {
        content.selectorStartPlace.setAdapter(startAdapter);
        content.selectorEndPlace.setAdapter(endAdapter);
        content.selectorStartPlace.setOnItemSelectedListener(onStartPlaceSelected);
        content.selectorEndPlace.setOnItemSelectedListener(onEndPlaceSelected);
    }

    @Override
    public void retrieve() {
        if (viaje.getLinea() != null) content.etLine.setText(String.valueOf(viaje.getLinea()));
        if (viaje.getRamal() != null) content.etRamal.setText(viaje.getRamal());
        if (viaje.getCosto() != 0) content.etPrice.setText(String.valueOf(viaje.getCosto()));
        if (viaje.getEndHour() != null && viaje.getEndMinute() != null)
            content.etEndHour.setText(Utils.hourFormat(viaje.getEndHour(), viaje.getEndMinute()));

        // mandatory
        content.etDate.setText(Utils.dateFormat(viaje.getDay(), viaje.getMonth(), viaje.getYear()));
        content.etStartHour.setText(Utils.hourFormat(viaje.getStartHour(), viaje.getStartMinute()));

        startIndex = getPosFor(viaje.getNombrePdaInicio());
        endIndex = getPosFor(viaje.getNombrePdaFin());

        content.selectorStartPlace.setSelection(startIndex);
        content.selectorEndPlace.setSelection(endIndex);
    }

    private int getPosFor(String stopName){
        int i=0;

        for (Parada p : getParadas()){
            if (p.getNombre().equals(stopName)) return i;
            i++;
        }

        return 0;
    }

    @Override
    public int onCheckEntries(@NonNull Viaje viaje){
        if (getParadas().isEmpty()) return 6;

        String line = content.etLine.getText().toString().trim();
        String ramal = content.etRamal.getText().toString().trim();
        String date = content.etDate.getText().toString().trim();
        String startHour = content.etStartHour.getText().toString().trim();
        String endHour = content.etEndHour.getText().toString().trim();
        String price = content.etPrice.getText().toString().trim();
        Parada startPlace = getParadas().get(startIndex);
        Parada endPlace = getParadas().get(endIndex);

        if (date.isEmpty() || startHour.isEmpty()) return 1;
        if (startPlace.equals(endPlace)) return 2;

        String[] hourParams = startHour.split(":");
        if (hourParams.length != 2){
            content.etStartHour.setError("Ingrese una hora válida");
            return 3;
        }

        String[] dateParams = date.split("/");
        if (dateParams.length != 3){
            content.etDate.setError("Ingrese una fecha válida");
            return 4;
        }

        // end hour and minute
        if (endHour.isEmpty()){
            viaje.setEndHour(null);
            viaje.setEndMinute(null);
        } else {
            String[] endHourParams = endHour.split(":");
            if (endHourParams.length != 2){
                content.etEndHour.setError("Ingrese una hora válida");
                return 3;
            }

            try {
                viaje.setEndHour(Integer.parseInt(endHourParams[0]));
                viaje.setEndMinute(Integer.parseInt(endHourParams[1]));
            } catch (NumberFormatException e){
                e.printStackTrace();
                return 5;
            }
        }

        try {
            viaje.setStartHour(Integer.parseInt(hourParams[0]));
            viaje.setStartMinute(Integer.parseInt(hourParams[1]));
            viaje.setDay(Integer.parseInt(dateParams[0]));
            viaje.setMonth(Integer.parseInt(dateParams[1]));
            viaje.setYear(Integer.parseInt(dateParams[2]));
            viaje.setNombrePdaInicio(startPlace.getNombre());
            viaje.setNombrePdaFin(endPlace.getNombre());
            Utils.setWeekDay(viaje);
            if (!ramal.isEmpty()) viaje.setRamal(ramal);
            if (!price.isEmpty()) viaje.setCosto(Double.parseDouble(price));
            if (line.isEmpty()){
                viaje.setTipo(1);
                viaje.setLinea(null);
            } else {
                viaje.setTipo(0);
                viaje.setLinea(Integer.parseInt(line));
            }
        } catch (Exception e){
            e.printStackTrace();
            return 5;
        }

        return 0;
    }

    private class OnStartPlaceSelected implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            startIndex = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    private class OnEndPlaceSelected implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            endIndex = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}