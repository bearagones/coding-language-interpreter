package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int value;
    String id;

    // Lit ByteCode has 1 or 2 args -> a value and (if present) an id of the value
    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
        }
    }

    // Lit ByteCode pushes only 1 value on top of the runtime stack
    @Override
    public void execute(VirtualMachine vm) {
        if (id.equals("")) {
            vm.push(value);
        } else {
            vm.push(0);
        }
    }
    
    @Override
    public String toString() {
        String base = "LIT " + value;
        if (id != null) {
            base += " int " + id;
        }
        return base;
    }
}
