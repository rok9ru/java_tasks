package com.company.commands;

public class AppendCommand extends AbstractCommand {
    protected String val;
    protected boolean pre = false;
    public AppendCommand(String v){
        val = v;
    }

    public AppendCommand(String v, boolean pre){
        this.pre = pre;
        val = v;
    }

    @Override
    public String toString() {
        return "AppendCommand{" +
                "val='" + val + '\'' +
                '}';
    }

    @Override
    public void apply(StringBuilder s) {
        if(pre)
            s.insert(0, this.val);
        else
            s.append(this.val);
    }
}
