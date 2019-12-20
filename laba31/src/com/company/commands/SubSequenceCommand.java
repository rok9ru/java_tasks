package com.company.commands;

public class SubSequenceCommand extends AbstractCommand {
    protected int start;
    protected int end;
    public SubSequenceCommand(int start, int end){
        this.end = end;
        this.start = start;
    }
    @Override
    public void apply(StringBuilder s) {
        s.subSequence(start, end);
    }

    @Override
    public String toString() {
        return "SubSequenceCommand{" +
                "start=" + start +
                ", end=" + end +
                "} ";
    }
}
