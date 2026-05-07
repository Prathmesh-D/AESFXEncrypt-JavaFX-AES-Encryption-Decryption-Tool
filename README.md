<div align="center">
<pre>
 █████╗ ███████╗███████╗███████╗██╗  ██╗
██╔══██╗██╔════╝██╔════╝██╔════╝╚██╗██╔╝
███████║█████╗  ███████╗█████╗   ╚███╔╝ 
██╔══██║██╔══╝  ╚════██║██╔══╝   ██╔██╗ 
██║  ██║███████╗███████║██║     ██╔╝ ██╗
╚═╝  ╚═╝╚══════╝╚══════╝╚═╝     ╚═╝  ╚═╝
</pre>
</div>

<div align="center">

---

[![Typing SVG](https://readme-typing-svg.demolab.com?font=Fira+Code&weight=700&size=22&pause=1200&color=F0F0F0&center=true&vCenter=true&width=600&lines=AES+encryption+%2B+JavaFX+desktop+UI;Research-backed+cryptographic+implementation;Encrypt+%26+decrypt+text+in+one+click;Java+%7C+JavaFX+%7C+javax.crypto)](https://git.io/typing-svg)

---

*A lightweight JavaFX desktop app for AES text encryption and decryption — built as the implementation counterpart to published research on AES-192.*

</div>

<div align="center">

![encryption](https://img.shields.io/badge/encryption-AES--128%20%7C%20ECB%20%7C%20PKCS5-000000?style=for-the-badge&logoColor=white)
![ui](https://img.shields.io/badge/ui-JavaFX-000000?style=for-the-badge&logo=java&logoColor=white)
![language](https://img.shields.io/badge/language-Java-000000?style=for-the-badge&logo=openjdk&logoColor=white)
![research](https://img.shields.io/badge/research-IJSRD_Published-000000?style=for-the-badge&logoColor=white)

</div>

---

<table>
<tr>
<td width="25%" valign="top">

**Encryption**
`AES-128 / ECB`

Encrypt plain text into ciphertext using a 16-byte key via `javax.crypto`

</td>
<td width="25%" valign="top">

**Decryption**
`Symmetric`

Same key decrypts the ciphertext back, clean tab-separated workflow

</td>
<td width="25%" valign="top">

**Validation**
`Real-time`

Key input validated instantly with visual color feedback, green / yellow

</td>
<td width="25%" valign="top">

**Research-backed**
`IJSRD Published`

Built alongside a published paper on Modified AES-192 — Vol. 12, Issue 4

</td>
</tr>
</table>

> **What makes this different from a toy project**
> - Directly implements concepts from a peer-reviewed research paper on AES
> - Built-in key generator, no manual key crafting needed
> - Clear ECB mode warning built in, intellectually honest about limitations
> - Designed as an educational and demonstration tool, not a black box

<br/>

---

### What it does

<table width="100%">
  <tr>
    <td width="50%" valign="top">
      <h3>🔒 Encrypt text</h3>
      Enter a 16-character key, type your plaintext, click Encrypt. Get Base64-encoded ciphertext instantly. No setup, no config.
    </td>
    <td width="4%"></td>
    <td width="50%" valign="top">
      <h3>🔓 Decrypt text</h3>
      Use the same key, paste the ciphertext, click Decrypt. Recover the original message in one step.
    </td>
  </tr>
  <tr><td colspan="3" height="10"></td></tr>
  <tr>
    <td width="50%" valign="top">
      <h3>🔑 Key validation</h3>
      Key field changes color in real time, green for valid 16-char key, yellow for invalid. No silent failures.
    </td>
    <td width="4%"></td>
    <td width="50%" valign="top">
      <h3>🎲 Key generator</h3>
      Don't want to think of a key? Hit generate. Gets you a valid 128-bit key instantly.
    </td>
  </tr>
</table>

<br/>

---

### ⚠️ Important -- ECB mode

This tool uses **AES in ECB mode**, which does not hide patterns in repeated data and is not suitable for real-world secure systems.

> If extending this project, consider: **AES/GCM** (recommended) or AES/CBC with IV handling.
>
> For a production-grade AES-256-GCM implementation, see [Sentra →](https://github.com/Prathmesh-D/Sentra)

---

### Research connection

This tool is the practical implementation companion to:

| Paper | Journal | Year |
|-------|---------|------|
| Assessing the Impact of Increased MixColumns on AES Encryption Security and Performance | IJSRD — Vol. 12, Issue 4 | 2023 |

The research evaluated security-performance trade-offs of a modified AES-192 using entropy, avalanche effect, and execution time analysis. This tool demonstrates the baseline AES implementation from which that research extended.

---

### Setup (VS Code)

**1. Add JavaFX SDK**

- Open project in VS Code
- Go to **Java Projects → Referenced Libraries**
- Add all `.jar` files from your JavaFX SDK folder

**2. Configure `settings.json`**

```json
{
  "java.project.referencedLibraries": [
    "lib/**/*.jar",
    "/path/to/javafx-sdk/lib/*.jar"
  ]
}
```

**3. Configure `launch.json`**

```json
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

Replace `/path/to/javafx-sdk/lib` with your actual JavaFX SDK path, then hit **Run** or press **F5**.

---

### Project structure

```
AESFXEncrypt/
│
├── .vscode/
│   ├── launch.json          ⚙️  Run config with JavaFX vm args
│   └── settings.json        ⚙️  Referenced libraries
│
└── AESFXEncrypt-JavaFX-AES-Tool/
    └── src/
        └── AESFXTool/
            └── AESFXEncrypt.java   🔐 Core app — UI + AES logic
```

---

### Tech stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-007396?style=flat-square&logo=java&logoColor=white)
![javax.crypto](https://img.shields.io/badge/javax.crypto-AES--128-555555?style=flat-square)
![Base64](https://img.shields.io/badge/Encoding-Base64-555555?style=flat-square)

---

### Possible upgrades

- [ ] Switch to AES-GCM (authenticated encryption)
- [ ] Add IV handling for CBC mode
- [ ] File encryption support
- [ ] Password-based key derivation (PBKDF2)
- [ ] Save / load encrypted data to disk

---

<div align="center">

<img src="https://github.com/Prathmesh-D.png" width="52" height="52" style="border-radius:50%;" alt="Prathmesh Deshkar" />

Built by **[Prathmesh Deshkar](https://github.com/Prathmesh-D)**

*If it was useful or interesting, a star is always appreciated.*

[![Star on GitHub](https://img.shields.io/github/stars/Prathmesh-D/AESFXEncrypt-JavaFX-AES-Encryption-Decryption-Tool?style=for-the-badge&color=0f0f0f&labelColor=f0f0f0&label=★%20Star%20on%20GitHub)](https://github.com/Prathmesh-D/AESFXEncrypt-JavaFX-AES-Encryption-Decryption-Tool/stargazers)

---
</div>
