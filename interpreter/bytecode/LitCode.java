package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int value;
    String id;

    // Lit ByteCode has 1 or 2 args -> a value and (if present) an id of the value
    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    // Lit ByteCode pushes only 1 value on top of the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        vm.push(value);
    }

    @Override
    public String toString() {
        String base = "LIT " + this.value + " ";
        if (this.id != null) {
            base += this.id + "\t int " + this.id;
        }
        return base;
    }
}
