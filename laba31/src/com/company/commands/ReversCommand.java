package com.company.commands;

public class ReversCommand extends AbstractCommand {
    @Override
    public void apply(StringBuilder s) {
        s.reverse();
    }
}
