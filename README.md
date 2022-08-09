# Android App - Travel Tracer
Esta es una aplicación de uso personal para registrar viajes tanto en colectivo como en trenes. Me permite tener un seguimiento más al día del saldo en la Sube y obtener estadísticas de cuáles son las líneas en la que más gasto, por si tengo que ajustar jajaja

## Surgimiento
Este proyecto nació como una necesidad de poner en práctica el lenguaje SQL que me encontraba aprendiendo en la materia "Bases de Datos", y también para aprender un poco de Kotlin, ya que estoy muy aferrado a Java y Android lo está dejando de lado xd

## Motivación
Si bien existen grandes monstruos como Moovit y Google Maps, que tienen toda la info del mundo, a veces resulta mejor tener algo más "gasolero" que no te consuma todos los datos apenas lo abrís y que se ajuste más a los resultados que uno personalmente espera.

## Implementación
Adjuntos algunas capturas de como va la app (que nunca se subirá a Play Store por obvias razones)...
- Actualizado al 8 de agosto de 2022

![splash screen](https://southcentralus1-mediap.svc.ms/transform/thumbnail?provider=spo&inputFormat=jpg&cs=fFNQTw&docid=https%3A%2F%2Faluingunlpeduar-my.sharepoint.com%3A443%2F_api%2Fv2.0%2Fdrives%2Fb!0JVGA0c1kE-iojkcJno6Oi1HXZcLtvNJu6dEL2C_icrvdWvVZ3L6TqXplIo_84Ek%2Fitems%2F01OGNQHUXZO5TA34VUIJE2AHE4QE4H6SBA%3Fversion%3DPublished&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvYWx1aW5ndW5scGVkdWFyLW15LnNoYXJlcG9pbnQuY29tQDdlYzc1MzYwLTRmNDMtNDM5Ni04ZjI3LTM1MGZhNzlkNDBjYiIsImlzcyI6IjAwMDAwMDAzLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMCIsIm5iZiI6IjE2NTk5OTI0MDAiLCJleHAiOiIxNjYwMDE0MDAwIiwiZW5kcG9pbnR1cmwiOiJaekgyMVV2Q3VoZzVxWVdUMlVHWmFndzhDY2tIcXBTN3pRZUJQRWtmZDZzPSIsImVuZHBvaW50dXJsTGVuZ3RoIjoiMTI1IiwiaXNsb29wYmFjayI6IlRydWUiLCJ2ZXIiOiJoYXNoZWRwcm9vZnRva2VuIiwic2l0ZWlkIjoiTURNME5qazFaREF0TXpVME55MDBaamt3TFdFeVlUSXRNemt4WXpJMk4yRXpZVE5oIiwic2lnbmluX3N0YXRlIjoiW1wia21zaVwiXSIsIm5hbWVpZCI6IjAjLmZ8bWVtYmVyc2hpcHxzZXJnaW8uY2FsZGVyb25AYWx1LmluZy51bmxwLmVkdS5hciIsIm5paSI6Im1pY3Jvc29mdC5zaGFyZXBvaW50IiwiaXN1c2VyIjoidHJ1ZSIsImNhY2hla2V5IjoiMGguZnxtZW1iZXJzaGlwfDEwMDMyMDAxZjRmNGI5NDVAbGl2ZS5jb20iLCJzaWQiOiJjOTIyZjEyZi0yY2RmLTQ0MmUtYjEzNy1iMzI0ZTgwNjZmYzUiLCJ0dCI6IjAiLCJ1c2VQZXJzaXN0ZW50Q29va2llIjoiMyIsImlwYWRkciI6IjE4MS40Ni4xMzYuMTQifQ.b2R0aCt2YU1ZcXQ3WmNYaFVHb003Rk8zVUVHandjaHNmanNzbDh4Z3dyQT0&cTag=%22c%3A%7B0D6677F9-B4F2-4942-A01C-9C81387F4820%7D%2C2%22&encodeFailures=1&width=1366&height=617&srcWidth=&srcHeight=) ![home](https://southcentralus1-mediap.svc.ms/transform/thumbnail?provider=spo&inputFormat=jpg&cs=fFNQTw&docid=https%3A%2F%2Faluingunlpeduar-my.sharepoint.com%3A443%2F_api%2Fv2.0%2Fdrives%2Fb!0JVGA0c1kE-iojkcJno6Oi1HXZcLtvNJu6dEL2C_icrvdWvVZ3L6TqXplIo_84Ek%2Fitems%2F01OGNQHUS4TNDAJHS47NFIH4537RUMZUGK%3Fversion%3DPublished&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvYWx1aW5ndW5scGVkdWFyLW15LnNoYXJlcG9pbnQuY29tQDdlYzc1MzYwLTRmNDMtNDM5Ni04ZjI3LTM1MGZhNzlkNDBjYiIsImlzcyI6IjAwMDAwMDAzLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMCIsIm5iZiI6IjE2NTk5OTI0MDAiLCJleHAiOiIxNjYwMDE0MDAwIiwiZW5kcG9pbnR1cmwiOiJaekgyMVV2Q3VoZzVxWVdUMlVHWmFndzhDY2tIcXBTN3pRZUJQRWtmZDZzPSIsImVuZHBvaW50dXJsTGVuZ3RoIjoiMTI1IiwiaXNsb29wYmFjayI6IlRydWUiLCJ2ZXIiOiJoYXNoZWRwcm9vZnRva2VuIiwic2l0ZWlkIjoiTURNME5qazFaREF0TXpVME55MDBaamt3TFdFeVlUSXRNemt4WXpJMk4yRXpZVE5oIiwic2lnbmluX3N0YXRlIjoiW1wia21zaVwiXSIsIm5hbWVpZCI6IjAjLmZ8bWVtYmVyc2hpcHxzZXJnaW8uY2FsZGVyb25AYWx1LmluZy51bmxwLmVkdS5hciIsIm5paSI6Im1pY3Jvc29mdC5zaGFyZXBvaW50IiwiaXN1c2VyIjoidHJ1ZSIsImNhY2hla2V5IjoiMGguZnxtZW1iZXJzaGlwfDEwMDMyMDAxZjRmNGI5NDVAbGl2ZS5jb20iLCJzaWQiOiJjOTIyZjEyZi0yY2RmLTQ0MmUtYjEzNy1iMzI0ZTgwNjZmYzUiLCJ0dCI6IjAiLCJ1c2VQZXJzaXN0ZW50Q29va2llIjoiMyIsImlwYWRkciI6IjE4MS40Ni4xMzYuMTQifQ.b2R0aCt2YU1ZcXQ3WmNYaFVHb003Rk8zVUVHandjaHNmanNzbDh4Z3dyQT0&cTag=%22c%3A%7B04469B5C-5C9E-4AFB-83F3-BBFC68CCD0CA%7D%2C2%22&encodeFailures=1&width=1366&height=617&srcWidth=&srcHeight=) 

![stats](https://southcentralus1-mediap.svc.ms/transform/thumbnail?provider=spo&inputFormat=jpg&cs=fFNQTw&docid=https%3A%2F%2Faluingunlpeduar-my.sharepoint.com%3A443%2F_api%2Fv2.0%2Fdrives%2Fb!0JVGA0c1kE-iojkcJno6Oi1HXZcLtvNJu6dEL2C_icrvdWvVZ3L6TqXplIo_84Ek%2Fitems%2F01OGNQHUVSHGDJGZSQEJH3WNO6CYC3MVQH%3Fversion%3DPublished&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvYWx1aW5ndW5scGVkdWFyLW15LnNoYXJlcG9pbnQuY29tQDdlYzc1MzYwLTRmNDMtNDM5Ni04ZjI3LTM1MGZhNzlkNDBjYiIsImlzcyI6IjAwMDAwMDAzLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMCIsIm5iZiI6IjE2NTk5OTI0MDAiLCJleHAiOiIxNjYwMDE0MDAwIiwiZW5kcG9pbnR1cmwiOiJaekgyMVV2Q3VoZzVxWVdUMlVHWmFndzhDY2tIcXBTN3pRZUJQRWtmZDZzPSIsImVuZHBvaW50dXJsTGVuZ3RoIjoiMTI1IiwiaXNsb29wYmFjayI6IlRydWUiLCJ2ZXIiOiJoYXNoZWRwcm9vZnRva2VuIiwic2l0ZWlkIjoiTURNME5qazFaREF0TXpVME55MDBaamt3TFdFeVlUSXRNemt4WXpJMk4yRXpZVE5oIiwic2lnbmluX3N0YXRlIjoiW1wia21zaVwiXSIsIm5hbWVpZCI6IjAjLmZ8bWVtYmVyc2hpcHxzZXJnaW8uY2FsZGVyb25AYWx1LmluZy51bmxwLmVkdS5hciIsIm5paSI6Im1pY3Jvc29mdC5zaGFyZXBvaW50IiwiaXN1c2VyIjoidHJ1ZSIsImNhY2hla2V5IjoiMGguZnxtZW1iZXJzaGlwfDEwMDMyMDAxZjRmNGI5NDVAbGl2ZS5jb20iLCJzaWQiOiJjOTIyZjEyZi0yY2RmLTQ0MmUtYjEzNy1iMzI0ZTgwNjZmYzUiLCJ0dCI6IjAiLCJ1c2VQZXJzaXN0ZW50Q29va2llIjoiMyIsImlwYWRkciI6IjE4MS40Ni4xMzYuMTQifQ.b2R0aCt2YU1ZcXQ3WmNYaFVHb003Rk8zVUVHandjaHNmanNzbDh4Z3dyQT0&cTag=%22c%3A%7B938639B2-5066-4F22-BB35-DE1605B65607%7D%2C2%22&encodeFailures=1&width=1366&height=617&srcWidth=&srcHeight=) ![create train travel](https://raw.githubusercontent.com/sergiocarp10/android-travel-tracer/master/screenshots/Screenshot_20220808-204009_Travel%20Tracer.jpg)
