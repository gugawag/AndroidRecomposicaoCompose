package com.example.recomposicao

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recomposicao.ui.theme.RecomposicaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecomposicaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var cliques by remember { mutableIntStateOf(0) }
                    var cliques3 by remember { mutableIntStateOf(0) }
                    val onclick = {
                        cliques += 1
                        if (cliques == 3) {
                            cliques3 += 1
                        }
                    }
                    Contador(
                        qCliques = cliques,
                        onclick
                    )

                    NaoAlterado(cliques3)
                    Alterado(cliques3)
                }
            }
        }
    }
}

@Composable
fun Contador(qCliques: Int, onClick: () -> Unit) {
    Log.d("Main", "Passou pelo Contador")
    Column {
        Button(onClick = onClick) {
            Log.d("Main", "Passou pelo Botao")
            Text(text = "Clicou $qCliques vezes")
        }
        Button(onClick = {}) {
            Log.d("Main", "Passou pelo Botao2")
            Text(text = "Botao2")
        }


    }

}

@Composable
fun NaoAlterado(cliques: Int) {
    Log.d("Main", "Passou pelo NaoAlterado.")
}

@Composable
fun Alterado(cliques: Int) {
    Log.d("Main", "Passou pelo NaoAlterado. $cliques")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecomposicaoTheme {
//        Contador("Android")
    }
}