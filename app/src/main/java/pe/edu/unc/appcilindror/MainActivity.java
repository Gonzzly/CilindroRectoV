package pe.edu.unc.appcilindror;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtRadio,txtAltura;
    TextView lbVolumen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //inicializar los objetos (visuales)
        txtRadio = findViewById(R.id.txtRadio);
        txtAltura = findViewById(R.id.txtAltura);
        lbVolumen = findViewById(R.id.lbVolumen);
        lbVolumen.setText("");


    }
    public void CalcularVolumen(View boton){
        if (validar())
            return;
        //leer los datos de los editex
        double radio = Double.valueOf(txtRadio.getText().toString());
        double altura = Double.valueOf(txtAltura.getText().toString());
        int volumen= (int)(Math.PI*Math.pow(radio,2)*altura);
        lbVolumen.setText("Respuesta: "+volumen+"");

    }

    private boolean validar() {
        if (txtRadio.getText().toString().trim().isEmpty()){
            txtRadio.setError("Campo Obligatorio para el radio de la base");
            txtRadio.requestFocus();
            return true;
        }
        //Sirve para validar
        if (txtAltura.getText().toString().trim().isEmpty()){
            //setError para
            txtAltura.setError("Campo Obligatorio para el radio de la base");
            txtAltura.requestFocus();
            return true;
        }
        return  false;
    }

}