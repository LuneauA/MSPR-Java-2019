import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
