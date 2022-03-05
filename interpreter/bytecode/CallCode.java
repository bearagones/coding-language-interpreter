package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    String label;
    int address;
    int value;

    // Call ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    // Call ByteCode jumps to the specified label
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getProgramCounter());
        this.address = vm.getProgramCounter();
        this.value = vm.peek();
    }

    @Override
    public String toString() {
        return "CALL " + this.label;
    }
}
