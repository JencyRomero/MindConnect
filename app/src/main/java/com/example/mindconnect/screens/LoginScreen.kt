package com.example.mindconnect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindconnect.R

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCBCAE5)) // Fondo lila
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "MindConnect",
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4A4A6A),
                modifier = Modifier.padding(top = 60.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.head_flowers),
                contentDescription = "Mind illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )

            Column(
                modifier = Modifier.padding(bottom = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    onClick = { onLoginClick() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7CB342)
                    ),
                    modifier = Modifier
                        .width(220.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(
                        text = "Iniciar sesión",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                ClickableText(
                    text = AnnotatedString("Olvidó su clave"),
                    onClick = { onForgotPasswordClick() },
                    style = LocalTextStyle.current.copy(
                        color = Color(0xFF8B8B9E),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { onRegisterClick() },
                    modifier = Modifier
                        .width(220.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF7986CB)
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        width = 1.5.dp
                    )
                ) {
                    Text(
                        text = "Registrarse",
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
