package com.example.mindconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Exercise(
    val title: String,
    val description: String
)

@Composable
fun ExercisesScreen() {
    var selectedTab by remember { mutableStateOf("Ejercicios") }

    val exercises = listOf(
        Exercise(
            "Ejercicios de Relajación",
            "Tómate unos minutos para cuidar tu bienestar mental"
        ),
        Exercise(
            "Respiración 4-7-8",
            "Técnica de respiración para reducir la ansiedad"
        ),
        Exercise(
            "Meditación de 5 minutos",
            "Meditación guiada para principiantes"
        ),
        Exercise(
            "Relajación muscular",
            "Libera la tensión de todo tu cuerpo"
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD5D4F0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón cerrar sesión arriba a la derecha
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .height(36.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF6A6A7A),
                        containerColor = Color.White
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        width = 1.dp,
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFCCCCCC))
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Cerrar sesión",
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Título
            Text(
                text = "MindConnect",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3D4A5C),
                letterSpacing = 0.5.sp
            )

            Text(
                text = "Tu espacio seguro para el bienestar mental",
                fontSize = 14.sp,
                color = Color(0xFF6A6A8A),
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Mensaje azul
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD4E4F7)
                ),
                border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF2A3A5A))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "💙",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Text(
                        text = "Tu bienestar mental es una prioridad, no un lujo.",
                        fontSize = 14.sp,
                        color = Color(0xFF1A1A2A),
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ExerciseTabButton("Estado de ánimo", selectedTab == "Estado de ánimo") {
                    selectedTab = "Estado de ánimo"
                }
                ExerciseTabButton("Chat", selectedTab == "Chat") {
                    selectedTab = "Chat"
                }
                ExerciseTabButton("Ejercicios", selectedTab == "Ejercicios") {
                    selectedTab = "Ejercicios"
                }
                ExerciseTabButton("Recordatorios", selectedTab == "Recordatorios") {
                    selectedTab = "Recordatorios"
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Card de Ejercicios
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(exercises.size) { index ->
                        ExerciseCard(exercises[index])
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Recordatorio
            Text(
                text = "Recuerda: Si experimentas una crisis de salud mental.",
                fontSize = 11.sp,
                color = Color(0xFF6A6A7A),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Row(
                modifier = Modifier.padding(top = 4.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "📞 Línea de Crisis: 106 | 🏥 En emergencias: 911",
                    fontSize = 11.sp,
                    color = Color(0xFF6A6A7A)
                )
            }
        }
    }
}

@Composable
fun ExerciseTabButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFF5B6FD6) else Color.Transparent,
            contentColor = if (isSelected) Color.White else Color(0xFF5A5A6A)
        ),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        border = if (!isSelected) androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF9A9AAA)) else null,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = if (isSelected) 2.dp else 0.dp
        )
    ) {
        if (text == "Ejercicios") {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp)
            )
        }
        if (text == "Recordatorios") {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp)
            )
        }
        Text(
            text = text,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ExerciseCard(exercise: Exercise) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F8FA)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = exercise.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3D4A5C)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = exercise.description,
                fontSize = 13.sp,
                color = Color(0xFF6A6A7A),
                lineHeight = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExercisesScreenPreview() {
    ExercisesScreen()
}