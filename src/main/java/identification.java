import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.util.IOUtils;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;

public class identification {
    private JButton btnIdentifier;

    public JPanel getAppIdnetification() {
        return appIdnetification;
    }

    public void setAppIdnetification(JPanel appIdnetification) {
        this.appIdnetification = appIdnetification;
    }

    private JPanel appIdnetification;


    public identification() {


        getAppIdnetification();
        btnIdentifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Choix du matériel");
                frame.setContentPane(new choixMateriel().getChoixMateriel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void takePicture(int i) {
        String name;
        if (i == 1) {
            name = "temp/photo1.jpg";
        } else {
            name = "temp/photo2.jpg";
        }
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        BufferedImage image = webcam.getImage();
        try {
            ImageIO.write(image, "jpg", new File(name));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Photo OK  ");
    }

    public static void rekognition() throws Exception {
        AWSCredentials credentials;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (/Users/userid/.aws/credentials), and is in valid format.", e);
        }

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        compareFace(rekognitionClient, "photo1.jpg", "photo2.jpg");

    }

    private static void compareFace(AmazonRekognition rekognitionClient, String photo1, String photo2) throws IOException {
        Image source = getImageUtil(photo1);
        Image target = getImageUtil(photo2);
        Float similarityThreshold = 70F;
        CompareFacesResult compareFacesResult = callCompareFaces(source,
                target,
                similarityThreshold,
                rekognitionClient);

        List<CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
        if (faceDetails.size() > 0) {
            System.out.println("Face [" + photo1 + "] matches with [" + photo2 + "]");
        } else {
            System.out.println("Face [" + photo1 + "] doesn't matches with [" + photo2 + "]\n");
        }
        for (CompareFacesMatch match : faceDetails) {
            ComparedFace face = match.getFace();
            BoundingBox position = face.getBoundingBox();
            System.out.println("Face at " + position.getLeft().toString()
                    + " " + position.getTop()
                    + " matches with " + face.getConfidence().toString()
                    + "% confidence.\n");
        }
    }

    private static CompareFacesResult callCompareFaces(Image sourceImage, Image targetImage,
                                                       Float similarityThreshold, AmazonRekognition amazonRekognition) {

        CompareFacesRequest compareFacesRequest = new CompareFacesRequest()
                .withSourceImage(sourceImage)
                .withTargetImage(targetImage)
                .withSimilarityThreshold(similarityThreshold);
        return amazonRekognition.compareFaces(compareFacesRequest);
    }

    private static Image getImageUtil(String key) throws IOException {
        ByteBuffer imageBytes;
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\temp\\" + key))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        return new Image().withBytes(imageBytes);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        appIdnetification = new JPanel();
        appIdnetification.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        appIdnetification.setBackground(new Color(-1));
        appIdnetification.setFocusable(true);
        appIdnetification.setMinimumSize(new Dimension(650, 850));
        appIdnetification.setPreferredSize(new Dimension(650, 850));
        btnIdentifier = new JButton();
        btnIdentifier.setBackground(new Color(-13132095));
        Font btnIdentifierFont = this.$$$getFont$$$("Roboto", -1, 20, btnIdentifier.getFont());
        if (btnIdentifierFont != null) btnIdentifier.setFont(btnIdentifierFont);
        btnIdentifier.setForeground(new Color(-16120557));
        btnIdentifier.setHideActionText(true);
        btnIdentifier.setText("S'identifier");
        btnIdentifier.putClientProperty("hideActionText", Boolean.FALSE);
        appIdnetification.add(btnIdentifier, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-2696997));
        panel1.setForeground(new Color(-1));
        appIdnetification.add(panel1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 400), new Dimension(-1, 400), new Dimension(-1, 400), 0, false));
        final JToolBar toolBar1 = new JToolBar();
        toolBar1.setAlignmentX(0.0f);
        toolBar1.setAlignmentY(0.0f);
        toolBar1.setBackground(new Color(-13132095));
        toolBar1.setBorderPainted(false);
        toolBar1.setFloatable(true);
        appIdnetification.add(toolBar1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(650, 30), new Dimension(650, 50), new Dimension(650, 50), 0, false));
        final JLabel label1 = new JLabel();
        label1.setAlignmentX(0.5f);
        label1.setAlignmentY(0.5f);
        Font label1Font = this.$$$getFont$$$("Roboto", -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("Page d'identification");
        toolBar1.add(label1);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return appIdnetification;
    }

}
