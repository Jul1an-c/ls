package expotec1;

public class Expotec1 {

    public static void main(String[] args) {
       FormLogin F1 = new FormLogin();
        F1.setVisible(false);

        FormAdmin FA = new FormAdmin();
        FA.setVisible(false);

        FormUsuario FU = new FormUsuario();
        FU.setVisible(false);

        FormRegistroUsuarios RG = new FormRegistroUsuarios();
        RG.setVisible(true);
        
        DatosUsuario Tb = new DatosUsuario();
        Tb.setVisible(false);
        
        PagoDeMensualidades PG = new PagoDeMensualidades();
        PG.setVisible(true);
        
        Factura FC = new Factura();
        FC.setVisible(false);
        
        FormSecretaria FS = new FormSecretaria();
        FS.setVisible(false);

        ControlSecretarios CS = new ControlSecretarios();
        CS.setVisible(false);
        
        Graficas gf = new Graficas();
        gf.setVisible(false);
        

    }

}
