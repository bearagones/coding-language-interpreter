package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int value;

    // Pop ByteCode has 1 arg -> # of values to remove from runtime stack
    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
    }

    // Pop ByteCode removes the number of values from the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 1; i < value; i++) {
            vm.pop();
        }
    }

    // Prints out "POP " + some integer
    @Override
    public String toString() {
        return "POP " + value;
    }
}
