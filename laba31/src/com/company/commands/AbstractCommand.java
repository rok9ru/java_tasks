package com.company.commands;

public abstract class AbstractCommand {
    abstract public void apply(StringBuilder s);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
