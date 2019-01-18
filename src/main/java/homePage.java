import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homePage {


    public JPanel getAppView() {
        return appView;
    }

    public void setAppView(JPanel appView) {
        this.appView = appView;
    }

    private JPanel appView;
    private JLabel LabelImg;
    private JButton btnHome;

    public identification getIdentification() {
        return identification;
    }

    public void setIdentification(identification identification) {
        this.identification = identification;
    }

    private identification identification;


    public homePage() {

        $$$setupUI$$$();
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("App Java");
                frame.setContentPane(new identification().getAppIdnetification());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("App Java");
        frame.setContentPane(new homePage().appView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        appView = new JPanel();
        appView.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        appView.setAlignmentX(0.0f);
        appView.setAlignmentY(0.0f);
        appView.setBackground(new Color(-1));
        appView.setForeground(new Color(-1));
        appView.setMinimumSize(new Dimension(450, 650));
        appView.setPreferredSize(new Dimension(650, 850));
        final JToolBar toolBar1 = new JToolBar();
        toolBar1.setAlignmentX(0.0f);
        toolBar1.setAlignmentY(0.0f);
        toolBar1.setBackground(new Color(-13132095));
        toolBar1.setBorderPainted(false);
        toolBar1.setFloatable(true);
        appView.add(toolBar1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(650, 30), new Dimension(650, 50), new Dimension(650, 50), 0, false));
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
        LabelImg = new JLabel();
        LabelImg.setAlignmentY(0.0f);
        LabelImg.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        LabelImg.setText("Label");
        LabelImg.setVisible(true);
        appView.add(LabelImg, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnHome = new JButton();
        btnHome.setBackground(new Color(-13132095));
        btnHome.setBorderPainted(true);
        btnHome.setContentAreaFilled(false);
        Font btnHomeFont = this.$$$getFont$$$("Roboto", -1, 14, btnHome.getFont());
        if (btnHomeFont != null) btnHome.setFont(btnHomeFont);
        btnHome.setForeground(new Color(-16120557));
        btnHome.setHideActionText(true);
        btnHome.setOpaque(false);
        btnHome.setText("Accès à l'identification");
        appView.add(btnHome, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return appView;
    }

}