package com.yaorange.test;

import java.awt.*;
import javax.swing.*;
public class T extends JFrame{
	public T(){
		super("GridLayout");
		Container con = 		this.getContentPane();con.setLayout(new GridLayout(2, 3));
        con.add(new JButton("a"));
		con.add(new JButton("b"));
        con.add(new JButton("c"));
        con.add(new JButton("d"));
        con.add(new JButton("e"));
        con.add(new JButton("f"));
        setSize(200,80);
		setVisible(true);
    }
    public static void main(String agrs[]){
        new T();
    }
}
