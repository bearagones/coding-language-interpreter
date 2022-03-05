package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int numValue;

    // Pop ByteCode has 1 arg -> # of values to remove from runtime stack
    @Override
    public void init(ArrayList<String> args) {
        this.numValue = Integer.parseInt(args.get(0));
    }

    // Pop ByteCode removes the number of values from the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 1; i < this.numValue; i++) {
            vm.pop();
        }
    }

    @Override
    public String toString() {
        return "POP " + this.numValue;
    }
}
