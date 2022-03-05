package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    int programCounter;
    int temp;
    String label;

    // Return ByteCode has 0 or 1 arg -> either nothing or a label
    @Override
    public void init(ArrayList<String> args) {
        if (args.size() > 0) {
            this.label = args.get(0);
        }
    }

    // Return ByteCode returns from functions and puts them in the correct position in the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        this.programCounter = vm.getReturnAddress();
        this.temp = vm.pop();

        while (vm.stackSize() > vm.peek()) {
             vm.pop();
        }

        vm.pop();
        vm.push(this.temp);
        vm.setProgramCounter(this.programCounter);
    }

    @Override
    public String toString() {
        if (this.label != null) {
            return "RETURN " + this.label;
        } else {
            return "RETURN";
        }
    }
}
