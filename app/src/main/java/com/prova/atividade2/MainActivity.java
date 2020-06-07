package com.prova.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.prova.modelo.Sac;
import com.prova.modelo.SacAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtValor;
    private EditText edtNumero;
    private EditText edtTaxa;
    private TextView txtAmortizacao;
    private ListView lvTabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = findViewById(R.id.edtValorBem);
        edtNumero = findViewById(R.id.edtNPrestacao);
        edtTaxa = findViewById(R.id.edtTaxa);
        txtAmortizacao = findViewById(R.id.txtAmortizacao);
        lvTabela = findViewById(R.id.lvTabela);

    }

    public void Calcular(View view) {
        Double valor = 0.0;
        Double taxa = 0.0;
        Double prestacao = 0.0;
        Double amortizacao = 0.0;
        Double juros = 0.0;
        int numero = 0;
        boolean validador = true;

        if (!edtValor.getText().toString().isEmpty()){
            valor = Double.parseDouble(edtValor.getText().toString());
        }else {
            edtValor.setError("Preencha o campo!");
            validador = false;
        }
        if (!edtNumero.getText().toString().isEmpty()){
            numero = Integer.parseInt(edtNumero.getText().toString());
        }else {
            edtNumero.setError("Preencha o campo!");
            validador = false;
        }
        if (!edtTaxa.getText().toString().isEmpty()){
            taxa = Double.parseDouble(edtTaxa.getText().toString());
        }else {
            edtTaxa.setError("Preencha o campo!");
            validador = false;
        }

        if (validador){
            amortizacao = valor/numero;
            txtAmortizacao.setText("Amortização: R$ "+String.format("%.2f",amortizacao));
            ArrayAdapter adapter = new SacAdapter(this, preencherDados(amortizacao, numero, valor, taxa));
            lvTabela.setAdapter(adapter);
        }else {
            lvTabela.setAdapter(null);
            Toast.makeText(this, "Preencha os Campos obrigatorios!", Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<Sac> preencherDados(Double amortizacao, int numero, Double valor, Double taxa) {
        ArrayList<Sac> dados = new ArrayList<>();
        int n;
        Sac temp;
        double vetJuros[] = new double[numero+1];
        double vetPrest[] = new double[numero+1];
        double vetSaldo[] = new double[numero+1];
        vetSaldo[0] = valor;
        vetJuros[0] = 0;
        vetPrest[0] = 0;
        for (n = 1; n <= numero; n++){
            vetJuros[n] = taxa*vetSaldo[n-1];
            vetPrest[n] = amortizacao+vetJuros[n];
            vetSaldo[n] = vetSaldo[n-1] - amortizacao;
            temp = new Sac(Double.valueOf(n), vetSaldo[n], amortizacao, vetJuros[n], vetPrest[n]);
            dados.add(temp);
        }
        return dados;
    }

}
