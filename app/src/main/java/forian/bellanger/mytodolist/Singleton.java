package forian.bellanger.mytodolist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by bellangf on 15/01/2018.
 */
public final class Singleton {
    private static volatile Singleton unTodo = null;

    private ArrayList<String> contenuTodo = new ArrayList<>();

    private Singleton() {

        super();
    }


    public final static Singleton getInstance() {
        if (Singleton.unTodo == null) {
            synchronized (Singleton.class) {
                if (Singleton.unTodo == null)
                    Singleton.unTodo = new Singleton();
            }
        }
        return Singleton.unTodo;

    }

    public void addTodo(String todoAjouter) {
        contenuTodo.add(todoAjouter);
    }
    public ArrayList<String> getAllTodo()
    {
        return contenuTodo;
    }
    public void emptyTodo()
    {
        contenuTodo.clear();
    }


}
