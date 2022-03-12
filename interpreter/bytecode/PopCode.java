package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int numValue;
    int temp = 0;

    // Pop ByteCode has 1 arg -> # of values to remove from runtime stack
    @Override
    public void init(ArrayList<String> args) {
        this.numValue = Integer.parseInt(args.get(0));
    }

    // Pop ByteCode removes the number of values from the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.frameSize() < numValue) {
            numValue = vm.frameSize();
        }
        while (temp < this.numValue) {
            vm.pop();
            temp++;
        }
    }

    @Override
    public String toString() {
        return "POP " + this.numValue;
    }
}
