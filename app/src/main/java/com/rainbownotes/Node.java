package com.rainbownotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by lucasmullerm on 6/9/15.
 * Class for the node of the notes graph
 */
public class Node {

    private String title;
    private String text;
    private long id;
    private List<Node> children;

    private static Random random;


    public Node(String title, String text) {
        this.title = title;
        this.text = text;
        this.children = new LinkedList<>();
        this.id = createId();
    }

    public Node(String title) {
       this(title, "");
    }


    private static long createId() {
        //ToDo: fazer um id decente!
        if (random == null) random = new Random();
        return random.nextLong();
    }


    public String getText() { return text; }

    public String getTitle() { return title; }

    public List<Node> getChildren() { return children; }

    public long getId() { return id; }

    public void setText(String text) { this.text = text; }

    public void setTitle(String title) { this.title = title; }

    public void addChildren(Node ... child) {
        children.addAll(Arrays.asList(child));
    }

    public static Node createTest() {
        Node root = new Node("Root", "Minhas notas");

        Node urgente = new Node("Urgente");
        Node ita = new Node("ITA");
        root.addChildren(urgente, ita);

        Node ces22 = new Node("CES-22");
        Node ctc20 = new Node("CTC-20");
        ita.addChildren(ces22, ctc20);

        Node boot = new Node("Projeto Boot", "Terminar.");
        Node anima = new Node("Projeto Anima", "Uso da Biblioteca javafx.");
        Node web = new Node("Projeto Web");
        ces22.addChildren(boot, anima, web);

        Node atividade4 = new Node("Atividade 4", "Fazer atividade 4");
        Node aula4 = new Node("Aula 4", "Grafos.\nÁrvode de custo mínimo.\nKruskal.");
        ctc20.addChildren(atividade4, aula4);

        Node app = new Node("Aplicativo", "Android.\nInterface.\nFuncionalidades.");
        Node servidor = new Node("Servidor", "python ou node.js.\nParse.\nSincronização utilizando http.");
        web.addChildren(app, servidor);

        return root;
    }


}
