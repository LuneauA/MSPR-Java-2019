import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class choixMateriel {

    private JPanel choixMateriel;
    private JComboBox cbCoupeVent;
    private JButton validerButton;
    private JComboBox cbMousqueton;
    private JComboBox cbGant;
    private JComboBox cbCeinture;
    private JComboBox cbDetecteur;
    private JComboBox cbBrassard;
    private JComboBox cbLampe;
    private JComboBox cbBandeau;
    private JComboBox cbGilet;
    private JComboBox cbChemise;
    private JComboBox cbTalkie;
    private JComboBox cbKit;
    private JComboBox cbTaser;
    private JComboBox cbBlouson;

    public static void main(String[] args) {
    }

    private JSONArray getData() {
        JSONArray result = null;
        try {
            URL url = new URL("http://localhost:8080/api/materiels");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                sb.append(output);
            }
            try {
                JSONObject json = new JSONObject(sb.toString());
                JSONObject base = json.getJSONObject("_embedded");
                JSONArray materiels = base.getJSONArray("materiels");

                result = materiels;

                /*
                for (int i = 0; i < materiels.length(); ++i) {
                    JSONObject mat = materiels.getJSONObject(i);
                    int stock = mat.getInt("stock");
                    String lib = mat.getString("libelle");
                    System.out.println(lib + ", stock de : " + stock);
                    cbMousqueton.addItem(stock);
                }
                */
                //System.out.println(materiels.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public JPanel getChoixMateriel() {
        return choixMateriel;
    }

    public void setChoixMateriel(JPanel choixMateriel) {
        this.choixMateriel = choixMateriel;
    }

    public choixMateriel() {
        List<JComboBox> list = new ArrayList<JComboBox>();
        JSONArray materiels = getData();
        Integer nbMat = 0;
        list.add(cbMousqueton);
        list.add(cbGant);
        list.add(cbBrassard);
        list.add(cbCeinture);
        list.add(cbDetecteur);
        list.add(cbTalkie);
        list.add(cbLampe);
        list.add(cbBandeau);
        list.add(cbGilet);
        list.add(cbChemise);
        list.add(cbBlouson);
        list.add(cbCoupeVent);
        list.add(cbKit);
        list.add(cbTaser);

        for (JComboBox item : list) {
            try {
                JSONObject mat = materiels.getJSONObject(nbMat);
                int stock = mat.getInt("stock");
                for (int i = 0; i <= stock; ++i) {
                    item.addItem(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            nbMat++;
        }
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
        choixMateriel = new JPanel();
        choixMateriel.setLayout(new GridLayoutManager(16, 6, new Insets(0, 0, 0, 0), -1, -1));
        choixMateriel.setBackground(new Color(-1));
        choixMateriel.setMinimumSize(new Dimension(650, 850));
        choixMateriel.setPreferredSize(new Dimension(650, 850));
        final JToolBar toolBar1 = new JToolBar();
        toolBar1.setAlignmentX(0.0f);
        toolBar1.setAlignmentY(0.0f);
        toolBar1.setBackground(new Color(-13132095));
        toolBar1.setBorderPainted(false);
        toolBar1.setFloatable(true);
        choixMateriel.add(toolBar1, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(650, 30), new Dimension(650, 50), new Dimension(650, 50), 0, false));
        final JLabel label1 = new JLabel();
        label1.setAlignmentX(0.5f);
        label1.setAlignmentY(0.5f);
        Font label1Font = this.$$$getFont$$$("Roboto", -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("Choix du matériel");
        toolBar1.add(label1);
        final Spacer spacer1 = new Spacer();
        choixMateriel.add(spacer1, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbCoupeVent = new JComboBox();
        cbCoupeVent.setBackground(new Color(-13132095));
        cbCoupeVent.setEditable(false);
        choixMateriel.add(cbCoupeVent, new GridConstraints(14, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer2 = new Spacer();
        choixMateriel.add(spacer2, new GridConstraints(14, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbBlouson = new JComboBox();
        cbBlouson.setBackground(new Color(-13132095));
        cbBlouson.setEditable(false);
        choixMateriel.add(cbBlouson, new GridConstraints(13, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer3 = new Spacer();
        choixMateriel.add(spacer3, new GridConstraints(13, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbTaser = new JComboBox();
        cbTaser.setBackground(new Color(-13132095));
        cbTaser.setEditable(false);
        choixMateriel.add(cbTaser, new GridConstraints(12, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer4 = new Spacer();
        choixMateriel.add(spacer4, new GridConstraints(12, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbKit = new JComboBox();
        cbKit.setBackground(new Color(-13132095));
        cbKit.setEditable(false);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        cbKit.setModel(defaultComboBoxModel1);
        choixMateriel.add(cbKit, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer5 = new Spacer();
        choixMateriel.add(spacer5, new GridConstraints(11, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbTalkie = new JComboBox();
        cbTalkie.setBackground(new Color(-13132095));
        cbTalkie.setEditable(false);
        choixMateriel.add(cbTalkie, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer6 = new Spacer();
        choixMateriel.add(spacer6, new GridConstraints(10, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbChemise = new JComboBox();
        cbChemise.setBackground(new Color(-13132095));
        cbChemise.setEditable(false);
        choixMateriel.add(cbChemise, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer7 = new Spacer();
        choixMateriel.add(spacer7, new GridConstraints(9, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbGilet = new JComboBox();
        cbGilet.setBackground(new Color(-13132095));
        cbGilet.setEditable(false);
        choixMateriel.add(cbGilet, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer8 = new Spacer();
        choixMateriel.add(spacer8, new GridConstraints(8, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbBandeau = new JComboBox();
        cbBandeau.setBackground(new Color(-13132095));
        cbBandeau.setEditable(false);
        choixMateriel.add(cbBandeau, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer9 = new Spacer();
        choixMateriel.add(spacer9, new GridConstraints(7, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbLampe = new JComboBox();
        cbLampe.setBackground(new Color(-13132095));
        cbLampe.setEditable(false);
        choixMateriel.add(cbLampe, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer10 = new Spacer();
        choixMateriel.add(spacer10, new GridConstraints(6, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbBrassard = new JComboBox();
        cbBrassard.setBackground(new Color(-13132095));
        cbBrassard.setEditable(false);
        choixMateriel.add(cbBrassard, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer11 = new Spacer();
        choixMateriel.add(spacer11, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbDetecteur = new JComboBox();
        cbDetecteur.setBackground(new Color(-13132095));
        cbDetecteur.setEditable(false);
        choixMateriel.add(cbDetecteur, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer12 = new Spacer();
        choixMateriel.add(spacer12, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbCeinture = new JComboBox();
        cbCeinture.setBackground(new Color(-13132095));
        cbCeinture.setEditable(false);
        choixMateriel.add(cbCeinture, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer13 = new Spacer();
        choixMateriel.add(spacer13, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbGant = new JComboBox();
        cbGant.setBackground(new Color(-13132095));
        cbGant.setEditable(false);
        choixMateriel.add(cbGant, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer14 = new Spacer();
        choixMateriel.add(spacer14, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        cbMousqueton = new JComboBox();
        cbMousqueton.setBackground(new Color(-1));
        cbMousqueton.setEditable(false);
        cbMousqueton.setForeground(new Color(-16777216));
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        cbMousqueton.setModel(defaultComboBoxModel2);
        choixMateriel.add(cbMousqueton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 20), null, 0, false));
        final Spacer spacer15 = new Spacer();
        choixMateriel.add(spacer15, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        validerButton = new JButton();
        validerButton.setBackground(new Color(-1));
        validerButton.setForeground(new Color(-13132095));
        validerButton.setText("Valider");
        choixMateriel.add(validerButton, new GridConstraints(15, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer16 = new Spacer();
        choixMateriel.add(spacer16, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Mousquetons");
        choixMateriel.add(label2, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Gants d'intervention");
        choixMateriel.add(label3, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Ceintures de sécurité tactique");
        choixMateriel.add(label4, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Détecteurs de métaux");
        choixMateriel.add(label5, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Brassards de sécurité");
        choixMateriel.add(label6, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Lampes torche");
        choixMateriel.add(label7, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Bandeaux « Agents cynophiles » ");
        choixMateriel.add(label8, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Gilets pare-balles");
        choixMateriel.add(label9, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Chemises manches courtes");
        choixMateriel.add(label10, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Talkies walkies");
        choixMateriel.add(label11, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Kits oreillettes");
        choixMateriel.add(label12, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Tasers");
        choixMateriel.add(label13, new GridConstraints(12, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("Blousons");
        choixMateriel.add(label14, new GridConstraints(13, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("Coupe-vents");
        choixMateriel.add(label15, new GridConstraints(14, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return choixMateriel;
    }
}

