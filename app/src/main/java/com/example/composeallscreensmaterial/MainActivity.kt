package com.example.composeallscreensmaterial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.composeallscreensmaterial.ui.theme.AppTheme
import com.example.composeallscreensmaterial.ui.theme.ComposeAllScreensMaterialTheme
import com.example.composeallscreensmaterial.ui.theme.Orientation
import com.example.composeallscreensmaterial.ui.theme.rememberWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowSizeClass()

            ComposeAllScreensMaterialTheme(window) {

                //Portrait UI
                if (AppTheme.orientation == Orientation.Portrait) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.solid_black),
                                contentDescription = "mood",
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(
                                            bottomEnd = AppTheme.dimensions.medium,
                                            bottomStart = AppTheme.dimensions.medium
                                        )
                                    )
                                    .fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                            Text(
                                "Welcome, User!",
                                style = MaterialTheme.typography.h4,
                                color = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.large)
                        ) {
                            Text(
                                text = "This Application support all screen sizes and landscape mode",
                                style = MaterialTheme.typography.h6,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tincidunt nunc ipsum tempor purus vitae id. Morbi in vestibulum nec varius. Et diam cursus quis sed purus nam.",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.Center
                            )

                        }
                        Button(
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Black,
                                contentColor = Color.White
                            ), modifier = Modifier
                                .fillMaxWidth()
                                .padding(AppTheme.dimensions.mediumLarge),
                            shape = CircleShape
                        ) {
                            Text(
                                text = "Let's go",
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(AppTheme.dimensions.medium)
                            )
                        }
                    }
                } else {
                    //Landscape UI
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.solid_black),
                                contentDescription = "black_background",
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(
                                            topEnd = AppTheme.dimensions.medium,
                                            bottomEnd = AppTheme.dimensions.medium
                                        )
                                    )
                                    .fillMaxSize(),
                                contentScale = ContentScale.FillHeight
                            )

                            Text(
                                "Welcome, User!",
                                style = MaterialTheme.typography.h4,
                                color = Color.White
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(2f)
                                .padding(AppTheme.dimensions.mediumLarge),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "This Application support all screen sizes and landscape mode",
                                    style = MaterialTheme.typography.h6,
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    modifier = Modifier.padding(top = 10.dp), //declaring manual values for dimensions
                                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tincidunt nunc ipsum tempor purus vitae id. Morbi in vestibulum nec varius. Et diam cursus quis sed purus nam.",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Button(
                                onClick = {

                                },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Black,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(AppTheme.dimensions.mediumLarge),
                                shape = CircleShape,
                            ) {
                                Text(
                                    text = "Let's go",
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(AppTheme.dimensions.medium)
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
