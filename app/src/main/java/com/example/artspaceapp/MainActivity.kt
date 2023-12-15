package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    ArtSpaceComponents()
}

@Composable
fun ArtSpacePage(
    painter: Painter,
    description: String,
    locate: String,
    modifier: Modifier = Modifier,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, bottom = 60.dp)
                .height(300.dp)
                .fillMaxWidth()
                .border(width = 5.dp, brush = SolidColor(Color.LightGray), shape = RoundedCornerShape(0.dp))
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(bottom = 100.dp)
                .fillMaxWidth()
                .background(color = Color.LightGray)
        ) {
            Text(
                text = description,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                text = locate,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = onPreviousButtonClick,
                modifier = Modifier.size(width = 120.dp, height = 40.dp)
            ) {
                Text(text = stringResource(id = R.string.previous_btn))
            }
            Button(
                onClick = onNextButtonClick,
                modifier = Modifier.size(width = 120.dp, height = 40.dp)
            ) {
                Text(text = stringResource(id = R.string.next_btn))
            }
        }
    }
}

@Composable
fun ArtSpaceComponents() {

    var value by remember { mutableStateOf(1) }
    val maxValue = 5
    val minValue = 1

    when (value) {
        1 -> ArtSpacePage(
            painter = painterResource(id = R.drawable.kremlin),
            description = stringResource(id = R.string.description_kremlin),
            locate = stringResource(id = R.string.locate_kremlin),
            onNextButtonClick = { value++ },
            onPreviousButtonClick = { value = maxValue }
        )
        2 -> ArtSpacePage(
            painter = painterResource(id = R.drawable.ost_tower),
            description = stringResource(id = R.string.description_ost_tower),
            locate = stringResource(id = R.string.locate_ost_tower),
            onNextButtonClick = { value++ },
            onPreviousButtonClick = { value-- }
        )
        3 -> ArtSpacePage(
            painter = painterResource(id = R.drawable.cathedral_kremlin),
            description = stringResource(id = R.string.description_cathedral),
            locate = stringResource(id = R.string.locate_cathedral),
            onNextButtonClick = { value++ },
            onPreviousButtonClick = { value-- }
        )
        4 -> ArtSpacePage(
            painter = painterResource(id = R.drawable.hermitage),
            description = stringResource(id = R.string.description_hermitage),
            locate = stringResource(id = R.string.locate_hermitage),
            onNextButtonClick = { value++ },
            onPreviousButtonClick = { value-- }
        )
        5 -> ArtSpacePage(
            painter = painterResource(id = R.drawable.kazan_kremlin),
            description = stringResource(id = R.string.description_kazan_kremlin),
            locate = stringResource(id = R.string.locate_kazan_kremlin),
            onNextButtonClick = { value = minValue },
            onPreviousButtonClick = { value-- }
            )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}