import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESFXEncrypt extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("AES Encryption and Decryption");

        TabPane tabPane = new TabPane();
        Tab encryptTab = new Tab("Encrypt");
        encryptTab.setContent(createEncryptPanel());
        Tab decryptTab = new Tab("Decrypt");
        decryptTab.setContent(createDecryptPanel());

        tabPane.getTabs().addAll(encryptTab, decryptTab);
        root.setCenter(tabPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Encrypt Pane Tab.
    private GridPane createEncryptPanel() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        Label keyLabel = new Label("Enter the secret key (must be 16 characters):");
        TextField keyField = new TextField();
        keyField.setPrefWidth(300);
        HBox keyBox = new HBox(keyLabel, keyField);
        keyBox.setAlignment(Pos.CENTER_LEFT);
        keyBox.setSpacing(10);

        Button generateKeyButton = new Button("Generate Key");

        Label sentenceLabel = new Label("Enter the sentence to be encrypted:");
        TextField sentenceField = new TextField();
        sentenceField.setPrefWidth(300);
        HBox sentenceBox = new HBox(sentenceLabel, sentenceField);
        sentenceBox.setAlignment(Pos.CENTER_LEFT);
        sentenceBox.setSpacing(10);

        Button encryptButton = new Button("Encrypt");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        gridPane.add(keyBox, 0, 0);
        gridPane.add(generateKeyButton, 1, 0);
        gridPane.add(sentenceBox, 0, 1);
        gridPane.add(encryptButton, 0, 2);
        gridPane.add(resultArea, 0, 3, 2, 1);

        // Generate Button Action.
        generateKeyButton.setOnAction(e -> keyField.setText(generateRandomKey()));

        // Encrypt Button Action.
        encryptButton.setOnAction(e -> {
            String key = keyField.getText();
            String sentence = sentenceField.getText();
            try {
                if (key.length() != 16) {
                    throw new IllegalArgumentException("AES key must be 16 characters long.");
                }
                String encryptedSentence = encrypt(sentence, key);
                resultArea.setText("Encrypted Sentence: " + encryptedSentence);
            } catch (Exception ex) {
                resultArea.setText("An error occurred: " + ex.getMessage());
            }
        });

        // Add event listener to change background color of keyField to green when it contains 16 characters
        keyField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 16) {
                keyField.setStyle("-fx-background-color: #7CFC00;");
            } else {
                keyField.setStyle("-fx-background-color: #FFFF00;");
            }
        });

        return gridPane;
    }

    // Decrypt Pane Tab.
    private GridPane createDecryptPanel() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        Label keyLabel = new Label("Enter the secret key (must be 16 characters):");
        TextField keyField = new TextField();
        keyField.setPrefWidth(300);
        HBox keyBox = new HBox(keyLabel, keyField);
        keyBox.setAlignment(Pos.CENTER_LEFT);
        keyBox.setSpacing(10);

        Label encryptedSentenceLabel = new Label("Enter the encrypted sentence:");
        TextField encryptedSentenceField = new TextField();
        encryptedSentenceField.setPrefWidth(300);
        HBox encryptedSentenceBox = new HBox(encryptedSentenceLabel, encryptedSentenceField);
        encryptedSentenceBox.setAlignment(Pos.CENTER_LEFT);
        encryptedSentenceBox.setSpacing(10);

        Button decryptButton = new Button("Decrypt");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        gridPane.add(keyBox, 0, 0);
        gridPane.add(encryptedSentenceBox, 0, 1);
        gridPane.add(decryptButton, 0, 2);
        gridPane.add(resultArea, 0, 3, 2, 1);

        // Decrypt Button Action.
        decryptButton.setOnAction(e -> {
            String key = keyField.getText();
            String encryptedSentence = encryptedSentenceField.getText();
            try {
                if (key.length() != 16) {
                    throw new IllegalArgumentException("AES key must be 16 characters long.");
                }
                String decryptedSentence = decrypt(encryptedSentence, key);
                if (decryptedSentence != null) {
                    resultArea.setText("Decrypted Sentence: " + decryptedSentence);
                } else {
                    resultArea.setText("Invalid Key. Decryption failed.");
                }
            } catch (Exception ex) {
                resultArea.setText("An error occurred: " + ex.getMessage());
            }
        });

        return gridPane;
    }

    // Encrypt Class.
    public static String encrypt(String sentence, String key) throws Exception {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(sentence.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt Class.
    public static String decrypt(String encryptedSentence, String key) {
        try {
            byte[] keyBytes = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedSentence));
            return new String(original);
        } catch (Exception e) {
            return null;
        }
    }

    // Random Key Generation.
    public static String generateRandomKey() {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[16];
        random.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes).substring(0, 16);
    } 

    public static void main(String[] args) {
        launch(args);
    }
}
