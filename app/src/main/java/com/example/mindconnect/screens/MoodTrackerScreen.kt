package com.example.mindconnect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoodTrackerScreen() {
    var selectedMood by remember { mutableStateOf<String?>(null) }
    var selectedTab by remember { mutableStateOf("Estado de ánimo") }
    var notes by remember { mutableStateOf("") }

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
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp, brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFCCCCCC))),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Cerrar sesión",
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TabButton("Estado de ánimo", selectedTab == "Estado de ánimo") {
                    selectedTab = "Estado de ánimo"
                }
                TabButton("Chat", selectedTab == "Chat") {
                    selectedTab = "Chat"
                }
                TabButton("Ejercicios", selectedTab == "Ejercicios") {
                    selectedTab = "Ejercicios"
                }
                TabButton("Recordatorios", selectedTab == "Recordatorios") {
                    selectedTab = "Recordatorios"
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "¿Cómo te sientes hoy?",
                        fontSize = 16.sp,
                        color = Color(0xFF3D4A5C),
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        MoodEmoji("😢", "Muy\ntriste", selectedMood == "Muy triste") {
                            selectedMood = "Muy triste"
                        }
                        MoodEmoji("😟", "Triste", selectedMood == "Triste") {
                            selectedMood = "Triste"
                        }
                        MoodEmoji("😊", "Tranquilo", selectedMood == "Tranquilo") {
                            selectedMood = "Tranquilo"
                        }
                        MoodEmoji("😄", "Normal", selectedMood == "Normal") {
                            selectedMood = "Normal"
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        MoodEmoji("😀", "Feliz", selectedMood == "Feliz") {
                            selectedMood = "Feliz"
                        }
                        MoodEmoji("😰", "Ansioso", selectedMood == "Ansioso") {
                            selectedMood = "Ansioso"
                        }
                        MoodEmoji("😡", "Enojado", selectedMood == "Enojado") {
                            selectedMood = "Enojado"
                        }
                        Spacer(modifier = Modifier.width(50.dp))
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Notas adicionales (opcional)",
                        fontSize = 13.sp,
                        color = Color(0xFF4A4A6A),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = notes,
                        onValueChange = { notes = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFCCCCCC),
                            unfocusedBorderColor = Color(0xFFE0E0E0),
                            focusedTextColor = Color(0xFF4A4A4A),
                            unfocusedTextColor = Color(0xFF4A4A4A)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5B6FD6)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Guardar estado de ánimo",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TabButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(40.dp),
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
fun MoodEmoji(
    emoji: String,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(if (isSelected) Color(0xFFE8F0FF) else Color.Transparent)
                .border(
                    width = if (isSelected) 2.5.dp else 0.dp,
                    color = if (isSelected) Color(0xFF5B6FD6) else Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = emoji,
                fontSize = 34.sp
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = Color(0xFF6A6A7A),
            textAlign = TextAlign.Center,
            lineHeight = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoodTrackerScreenPreview() {
    MoodTrackerScreen()
}