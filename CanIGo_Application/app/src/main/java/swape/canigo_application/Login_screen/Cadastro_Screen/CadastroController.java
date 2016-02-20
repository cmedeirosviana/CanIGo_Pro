package swape.canigo_application.Login_screen.Cadastro_Screen;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CadastroController implements Serializable{

    Map<String, Boolean> map = new HashMap<String,Boolean>();

    public  Map<String, Boolean> CheckArray( String nome, Boolean checked)
    {
       map.put(nome,checked);

        return map;

    }
}
