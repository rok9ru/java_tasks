package com.company;

import com.company.commands.*;

import java.util.ArrayList;

public class MyStringBuilder {


    ArrayList<AbstractCommand> commands = null;

    public MyStringBuilder(String str) {
        commands = new ArrayList<AbstractCommand>();
        this.append(str);
    }

    public MyStringBuilder undo() {
        if (commands.size() > 0)
            commands.remove(commands.size() - 1);
        return this;
    }

    public MyStringBuilder add(AbstractCommand command) {
        commands.add(command);
        return this;
    }

    public MyStringBuilder append(String s) {
        commands.add(new AppendCommand(s));
        return this;
    }

    public MyStringBuilder prepend(String s) {
        commands.add(new AppendCommand(s));
        return this;
    }

    public MyStringBuilder append(int i) {
        commands.add(new AppendCommand(String.valueOf(i)));
        return this;
    }

    public MyStringBuilder append(float i) {
        commands.add(new AppendCommand(String.valueOf(i)));
        return this;
    }

    public int size() {
        return this.build().length();
    }

    public MyStringBuilder reverse() {
        commands.add(new ReversCommand());
        return this;
    }

    public MyStringBuilder insert(int offset, String b) {
        commands.add(new InsertCommand(offset, b));
        return this;
    }

    //TODO
    public MyStringBuilder trimToSize(int size) {
        //strBuilder.trimToSize();
        return this;
    }

    public void printList() {
        for (AbstractCommand command : commands) {
            System.out.println(command);
        }

    }

    //TODO
    public MyStringBuilder substring(int start, int end) {
        this.add(new SubSequenceCommand(start, end));
        return this;
    }

    private StringBuilder build() {
        StringBuilder str = new StringBuilder();

        for (AbstractCommand command : commands) {
            command.apply(str);
        }

        return str;
    }

    public String toString() {
        return this.build().toString();
    }

}
