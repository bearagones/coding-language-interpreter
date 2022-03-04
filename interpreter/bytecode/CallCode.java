package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    String value;

    @Override
    public void init(ArrayList<String> args) {
        this.value = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getProgramCounter());
        vm.setProgramCounter(Integer.parseInt());
    }

    @Override
    public String toString() {
        return "CALL " + value;
    }
}
