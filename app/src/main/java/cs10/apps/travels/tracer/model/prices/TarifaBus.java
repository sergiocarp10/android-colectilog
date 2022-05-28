package cs10.apps.travels.tracer.model.prices;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import cs10.apps.travels.tracer.model.Parada;

@Entity(primaryKeys = {"line","inicio", "fin"}, foreignKeys = {
        @ForeignKey(entity = Parada.class, parentColumns = "nombre", childColumns = "inicio"),
        @ForeignKey(entity = Parada.class, parentColumns = "nombre", childColumns = "fin")
})
public class TarifaBus {

    @NonNull
    private String inicio = "", fin = "";

    private int line;
    private double costo;

    @NonNull
    public String getInicio() {
        return inicio;
    }

    public void setInicio(@NonNull String inicio) {
        this.inicio = inicio;
    }

    @NonNull
    public String getFin() {
        return fin;
    }

    public void setFin(@NonNull String fin) {
        this.fin = fin;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
