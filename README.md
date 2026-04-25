# AESFX — JavaFX Encryption Tool

<div align="center">

**Encrypt. Decrypt. Understand AES.**

*A lightweight desktop app for AES-based text encryption with a clean JavaFX interface.*

<br>

![java](https://img.shields.io/badge/backend-Java-000000?style=for-the-badge)
![ui](https://img.shields.io/badge/ui-JavaFX-000000?style=for-the-badge)
![encryption](https://img.shields.io/badge/encryption-AES%20(ECB%20%7C%20PKCS5)-000000?style=for-the-badge)

</div>

---

## What this is

AESFX is a simple desktop application built using JavaFX that lets you encrypt and decrypt text using the AES algorithm.

It’s designed to be:
- easy to use  
- visually clear  
- useful for learning and demos  

No unnecessary complexity. Just encryption, done right.

---

## Core capabilities

<table>
<tr>
<td width="33%" valign="top">

**Encryption**  
`AES / ECB / PKCS5Padding`  

Encrypt plain text into ciphertext using a 16-byte key.

</td>

<td width="33%" valign="top">

**Validation**  
`Real-time feedback`  

Key input is validated instantly with visual indicators.

</td>

<td width="33%" valign="top">

**UI Simplicity**  
`JavaFX Tabs`  

Clean separation between Encrypt and Decrypt workflows.

</td>
</tr>
</table>

---

## What makes it useful

- Instant encryption/decryption without setup friction  
- Built-in key generator  
- Clear visual feedback for valid/invalid input  
- Ideal for crypto demos, viva, and learning AES basics  

> This is not a production security tool — it's a focused implementation for understanding AES.

---

## How it works

<table width="100%">
<tr>
<td width="50%" valign="top" style="padding: 16px; border: 1px solid #d0d7de; border-radius: 10px;">

### Encrypt

- Enter a 16-character key  
- Type your plaintext  
- Click **Encrypt**  
- Get ciphertext instantly  

</td>

<td width="4%"></td>

<td width="50%" valign="top" style="padding: 16px; border: 1px solid #d0d7de; border-radius: 10px;">

### Decrypt

- Use the same key  
- Paste encrypted text  
- Click **Decrypt**  
- Recover original message  

</td>
</tr>
</table>

---

## Key behavior

- Key must be **exactly 16 characters (128-bit)**  
- Field color feedback:
  - 🟩 Valid key  
  - 🟨 Invalid key  

---

## ⚠️ Important note

AES is used in **ECB mode**, which has known weaknesses.

> ECB does not hide patterns and is not suitable for sensitive or real-world secure systems.

If extending this project, consider:
- AES/CBC with IV  
- AES/GCM (recommended)

### Project structure
<br>

```
RootFolder/
│
├── .vscode/
│ ├── launch.json
│ └── settings.json
│
└── AESFXEncrypt-JavaFX-AES-Tool/
├── src/
│ └── AESFXTool/
│ └── AESFXEncrypt.java
│
└── README.md
```

<br/>

---

## Setup (VS Code)

### 1. Add JavaFX SDK

- Open project in VS Code  
- Go to **Java Projects → Referenced Libraries**  
- Add all `.jar` files from JavaFX SDK  

---

### 2. Configure `settings.json`

```
{
"java.project.referencedLibraries": [
"lib/**/.jar",
"/path/to/javafx-sdk/lib/.jar"
]
}
```


---

### 3. Configure `launch.json`
```
{
"version": "0.2.0",
"configurations": [
{
"type": "java",
"name": "Launch",
"request": "launch",
"mainClass": "AESFXEncrypt",
"vmArgs": "--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml"
}
]
}
```


Replace `/path/to/javafx-sdk/lib` with your actual JavaFX SDK path.

---

## Run the application

- Open project  
- Click **Run** or press **F5**  

---

## Tech stack

- Java (JDK 8+)  
- JavaFX  
- AES (javax.crypto)  
- Base64 encoding  

---

## Possible upgrades

- Switch to AES-GCM  
- Add IV handling (CBC mode)  
- File encryption support  
- Password-based key derivation (PBKDF2)  
- Save/load encrypted data  

---

## 🙋‍♂️ Author

**Prathmesh Deshkar**  
🔗 https://github.com/Prathmesh-D  
