package com.company.commands;

public class SubstringCommand extends AbstractCommand {
    protected int start;
    protected int end;
    protected boolean mode = false;
    public SubstringCommand(int start, int end){
        this.end = end;
        this.start = start;
    }

    public SubstringCommand(int start){
        this.mode = true;
        this.start = start;
    }
    @Override
    public void apply(StringBuilder s) {
        if(mode)
            s.substring(start);
        else
            s.substring(start, end);
    }

    @Override
    public String toString() {
        return "SubstringCommand{" +
                "start=" + start +
                ", end=" + end +
                ", mode=" + mode +
                '}';
    }
}
