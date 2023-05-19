package com.example.attendance.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.attendance.ui.theme.AttendanceTheme
import com.example.attendance.R
import com.example.attendance.ui.components.TopBarContent

@Composable
fun LoginScreen() {
    Row(Modifier.fillMaxSize()) {
        LoginScreenContent()
    }
}

@Composable
private fun LoginScreenContent() {
    Scaffold(
        topBar = {
            TopBarContent(
                title = stringResource(id = R.string.login_title)
            )
        }
    ) {
        LoginContent()
    }
}

@Composable
private fun LoginContent() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(
                text = stringResource(id = R.string.login_email)
            ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RectangleShape
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(
                text = stringResource(id = R.string.login_password)
            ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RectangleShape
        )
        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .width(200.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = stringResource(id = R.string.login_title),
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(
    name = "Full Preview",
    showSystemUi = true
)
@Composable
private fun PreviewLoginScreen() {
    AttendanceTheme {
        LoginScreen()
    }
}