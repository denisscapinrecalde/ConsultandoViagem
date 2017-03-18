package br.com.provider.client.denis.consultandoviagem;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String AUTHORITY = "br.com.denis.boaviagem.provider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    public static final String VIAGEM_PATH = "viagem";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, VIAGEM_PATH);

    private TextView retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retorno = (TextView) findViewById(R.id.retorno);
    }


    public void pesquisarViagens(View view) {
        ContentResolver contentResolver = getContentResolver();
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;
        Cursor cursor = contentResolver.query(CONTENT_URI, projection,selection, selectionArgs, sortOrder);
        String mensagem = "";
        while (cursor.moveToNext()) {
            mensagem += "Viagem: " + cursor.getString(1)+"\n";
        }
        retorno.setText(mensagem);
    }
}
