package com.company.commands;

public class InsertCommand extends AbstractCommand{
    protected String val;
    protected int offset;
    public InsertCommand(int offset, String v){
        val = v;
        this.offset = offset;
    }

    @Override
    public void apply(StringBuilder s) {
        s.insert(offset, this.val);
    }

    @Override
    public String toString() {
        return "InsertCommand{" +
                "val='" + val + '\'' +
                ", offset=" + offset +
                '}';
    }
}
