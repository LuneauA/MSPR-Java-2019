import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.BoundingBox;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.ComparedFace;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.util.IOUtils;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;

public class FacialRecognition {


  /* public static void main(String[] args) {
        JFrame window = new JFrame("Page d'accueil");

        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panelWebCam = new WebcamPanel(webcam);
        panelWebCam.setFPSDisplayed(true);
        panelWebCam.setDisplayDebugInfo(true);
        panelWebCam.setImageSizeDisplayed(true);
        panelWebCam.setMirrored(true);


        /* JButton buttonTakePicture1 = new JButton("Prendre une photo");
         buttonTakePicture1.addActionListener(e -> takePicture(1));
         JButton buttonTakePicture2 = new JButton("Prendre une deuxième photo");
         buttonTakePicture2.addActionListener(e -> takePicture(2));
        JButton buttonRekognition = new JButton("Reconnaissance");
        buttonRekognition.addActionListener(e -> {
            try {
                rekognition();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

         JPanel bottomPanel = new JPanel();
         bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(buttonTakePicture1);
        bottomPanel.add(buttonTakePicture2);
        bottomPanel.add(buttonRekognition);*/
       //window.add(panelWebCam);
        //window.add(bottomPanel,BorderLayout.SOUTH);


      /* window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }*/


 /*  private static void takePicture(int i) {
        String name;
        if(i==1){name="temp/photo1.jpg";}else{name="temp/photo2.jpg";}
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

    private static void rekognition() throws Exception{
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
        for (CompareFacesMatch match: faceDetails){
            ComparedFace face= match.getFace();
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
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir")+"\\temp\\"+key))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        return new Image().withBytes(imageBytes);
    }*/

}
