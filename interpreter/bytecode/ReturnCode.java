package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    int programCounter;
    int temp;
    String label;
    private int address;
    private String id;

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
        temp = vm.peek();
        vm.popFrame();
        vm.push(temp);
        vm.setProgramCounter(vm.popReturnAddress());
    }

    @Override
    public String toString() {
        if (this.label != null) {
            return "RETURN " + this.label;
        } else {
            return "RETURN";
        }
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }
}
