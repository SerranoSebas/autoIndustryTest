# autoIndustryTest
Prueba sistema de inventario para el sector automotriz

1. Se adjunta codigo fuente de la solucion

2. Imagenes de evidencia con ejecucion de pruebas funcionales:

- Para empezar las pruebas funcionales se añaden los usuarios con los cargos definidos (Asesor  de  ventas,  administrador  y  soporte) 

  ![image](https://user-images.githubusercontent.com/40243918/185826018-aab7cfe4-674b-475f-a65f-8cf971cd8b17.png)
  
- (Consumo REST a API)

  ![image](https://user-images.githubusercontent.com/40243918/185826476-c9086a57-ebc3-4940-96f1-e65a746841c5.png)
  ![image](https://user-images.githubusercontent.com/40243918/185826760-9f118b56-454d-4051-9640-97123cec0e95.png)

- Se ingresa a la aplicacion y se evidencia que no hay registros en lista de inventario.

  ![image](https://user-images.githubusercontent.com/40243918/185826878-fe99b9e9-ce5b-4ec7-8d02-5acdadbd560a.png)
  
- Se presiona el boton registrar mercancia para abrir pantalla con formulario y campos de registro de mercancia (Se evidencian los usuarios previamente insertados)

  ![image](https://user-images.githubusercontent.com/40243918/185827144-1807851b-6448-4b2d-bbb8-cfcf583b6d6d.png)

 - Se validan campos de formulario: 
 
   ![image](https://user-images.githubusercontent.com/40243918/185827306-3e2f3a2f-13bd-4f5a-b7f6-68af3b3424d2.png)
   ![image](https://user-images.githubusercontent.com/40243918/185827366-8ad3d454-434c-4cac-9a0e-bdeeb5a0a4d7.png)
   ![image](https://user-images.githubusercontent.com/40243918/185827437-2a812f30-40c9-4388-8b74-a6467397f28b.png)
   ![image](https://user-images.githubusercontent.com/40243918/185827469-c79a1652-d559-41c0-8078-2ee9457bb19e.png)
   ![image](https://user-images.githubusercontent.com/40243918/185827510-8969b93c-6d08-4208-9308-ab12a4f90691.png)
   ![image](https://user-images.githubusercontent.com/40243918/185827557-48ce2efb-9543-4640-b3ff-58f2b9af3f06.png)

- Se presiona el boton guardar y se evidencia que se crea el registro:

  ![image](https://user-images.githubusercontent.com/40243918/185827727-e0e1d375-a47c-4557-9210-f209999600f6.png)

- Se valida producto previamente creado:

  ![image](https://user-images.githubusercontent.com/40243918/185827781-4ecd3cf9-5eb2-458a-964b-8c565a0752ef.png)
 
- Se selecciona el boton de amarillo con icono de modificar (El icono se utiliza en muchos aplicativos para representar la modificacion). 
  Se cambia la referencia del aceite y su cantidad...
  
  ![image](https://user-images.githubusercontent.com/40243918/185828264-209500df-f185-49da-a6c2-9c5f89ba8d6f.png)
  
- Se presiona el boton guardar y se evidencia que se modifica el registro

  ![image](https://user-images.githubusercontent.com/40243918/185828327-99856760-8481-4faf-8764-c71d42cc3c3a.png)

- Se selecciona el boton de eliminar producto

  ![image](https://user-images.githubusercontent.com/40243918/185828615-ce9e4dcf-ce0d-4e5b-b4fc-14f1d3806c0c.png)
  
- Se evidencia validacion de sesion con el campo desplegable de usuarios, se selecciona un usuario del campo y se intenta borrar nuevamente

  ![image](https://user-images.githubusercontent.com/40243918/185828744-b6fc4863-f875-415d-a37c-52513ec0c01f.png)
  ![image](https://user-images.githubusercontent.com/40243918/185828767-dc33189b-c2e3-47fe-9593-90b2d53e6e08.png)

- Se realiza prueba del filtro -  (nombre de producto: Sirena) :

  ![image](https://user-images.githubusercontent.com/40243918/185829044-e5462235-6923-4c98-92a6-ba17a6da8f78.png)
  ![image](https://user-images.githubusercontent.com/40243918/185829078-4aa637f3-14ce-40ae-a389-95f7530be6be.png)

3. Se adjuntan archivos scripts de base de datos o estructura de datos utilizada para la prueba en la carpeta Database

