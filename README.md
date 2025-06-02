# 🔐 AES Encryption and Decryption Application (JavaFX)

A simple JavaFX application that allows users to encrypt and decrypt text using the Advanced Encryption Standard (AES) algorithm.
The GUI features two tabs: one for encryption and one for decryption.

---

## 📋 Features

- Encrypt and decrypt text using AES (ECB mode with PKCS5 padding)
- 16-character secret key requirement with real-time validation
- Random key generation button
- Simple tabbed UI (Encrypt / Decrypt)
- Color-coded key input field (green = valid, yellow = invalid)

---

## 🚀 Prerequisites
To run this application, ensure the following are installed:

Java Development Kit (JDK) 8 or higher
- [Download JDK](https://www.oracle.com/in/java/technologies/downloads/#jdk24-windows).

JavaFX SDK (if not bundled with your JDK)
- [Download JavaFX](https://gluonhq.com/products/javafx/).

Visual Studio Code (Recommended IDE)
- [Download VS Code](https://code.visualstudio.com/).

---

## 📁 Project Structure

```plaintext

RootFolder
      ├──.vscode/
      |        ├── launch.json                # VS Code launch configuration
      |        └── settings.json              # VS Code JavaFX SDK reference
      |
      └── AESFXEncrypt-JavaFX-AES-Encryption-Decryption-Tool/
          ├── src
          |   └── AESFXTool/
          |       └── AESFXEncrypt.java       # Main application file
          |
          └── README.md                       # Project documentation 
        

```

---

## ⚙️ Setup Instructions for Visual Studio Code

### ✅ Add JavaFX SDK JARs

1. Open your project in VS Code.
2. Go to the "Java Projects" section in the Explorer panel.
3. Right-click "Referenced Libraries".
4. Select "Add JARs",then navigate to your local JavaFX SDK directory
5. Select all .jar files and click OK.

This step ensures your project recognizes the JavaFX classes at both compile-time and run-time.

### ✅ Configure settings.json

```plaintext

{
  "java.project.referencedLibraries": [
    "lib/**/*.jar",
    "/path/to/javafx-sdk/lib/*.jar"
  ]
}

```
Replace "/path/to/javafx-sdk/lib" with the actual path where JavaFX is installed.

---

### ✅ Configure launch.json

```plaintext

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
Again, replace /path/to/javafx-sdk/lib with your actual JavaFX SDK path.

---

## ▶️ How to Run

1. Open Project in Visual Studio Code.
2. Click the Run button or run via Run > Start Debugging.

---

## 💡 Usage

### 🔒 Encryption

1. Go to Encrypt tab.
2. Enter a 16-character secret key or click "Generate Key".
3. Enter the text to encrypt.
4. Click "Encrypt" → the encrypted output appears below.

### 🔓 Decryption

1. Go to Decrypt tab.
2. Enter the same 16-character key used for encryption.
3. Enter the encrypted text.
4. Click "Decrypt" → the decrypted sentence will be displayed.

---

## ⚠️Notes

- Secret Key must be exactly 16 characters.
- Encryption Mode: AES/ECB/PKCS5Padding 
          <p>*Note: ECB is not recommended for sensitive data. Consider switching to CBC with IV for better security.</p>
- The key field changes color:
    <p>🟩 Green = valid (16 chars)

    🟨 Yellow = invalid </p>

- Basic error handling is provided for invalid input.

---

## 📚 References

- [JavaFX Documentation](https://openjfx.io/).
- [AES in Java - Oracle Crypto Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#AES).
- [Base64 Encoding/Decoding](https://docs.oracle.com/javase/8/docs/api/java/util/Base64.html).
- [SecureRandom Class](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html).

---

## 🙋‍♂️ Author
Prathmesh Deshkar <br>
🔗 [My Profile](https://github.com/Prathmesh-D)

---

