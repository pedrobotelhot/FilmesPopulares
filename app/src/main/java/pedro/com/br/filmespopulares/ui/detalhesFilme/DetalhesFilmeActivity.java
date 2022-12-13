package pedro.com.br.filmespopulares.ui.detalhesFilme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pedro.com.br.filmespopulares.R;
import pedro.com.br.filmespopulares.data.model.Filme;

public class DetalhesFilmeActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        TextView textTituloFilme = findViewById(R.id.text_titulo_filme);
        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);
        textTituloFilme.setText(filme.getTitulo());
    }
}