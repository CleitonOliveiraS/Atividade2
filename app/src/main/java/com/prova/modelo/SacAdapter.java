package com.prova.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.prova.atividade2.R;

import java.util.ArrayList;

public class SacAdapter extends ArrayAdapter<Sac> {

    private Context context;
    private ArrayList<Sac> sacs;

    public SacAdapter(Context context, ArrayList<Sac> sacs) {
        super(context, R.layout.linha, sacs);
        this.context = context;
        this.sacs = sacs;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Sac sac = sacs.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linhaView = inflater.inflate(R.layout.linha, parent, false);

        TextView numeroParcelas = linhaView.findViewById(R.id.numeroParcelas);
        TextView saldoDevedor = linhaView.findViewById(R.id.saldoDevedor);
        TextView amortizacao = linhaView.findViewById(R.id.amortizacao);
        TextView juros = linhaView.findViewById(R.id.juros);
        TextView prestacao = linhaView.findViewById(R.id.prestacao);

        numeroParcelas.setText(String.format("%d",sac.getNumeroParcela().intValue()));
        saldoDevedor.setText(String.format("%.2f",sac.getSaldoDevedor()));
        amortizacao.setText(String.format("%.2f",sac.getAmortizacao()));
        juros.setText(String.format("%.2f",sac.getJuros()));
        prestacao.setText(String.format("%.2f",sac.getPrestacao()));

        if (position % 2 == 0){
            linhaView.setBackground(ContextCompat.getDrawable(context, R.drawable.borda_linha));
        }

        return linhaView;
    }
}
