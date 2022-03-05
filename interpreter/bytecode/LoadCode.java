package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    int offset;
    String id;

    // Load ByteCode has 1 or 2 args -> a value and (if present) an id of the value
    @Override
    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
        }
    }

    // Load ByteCode moves values from offset to the top of the stack 
    @Override
    public void execute(VirtualMachine vm) {
        vm.push(vm.load(offset));
    }

    @Override
    public String toString() {
        String base = "LIT " + this.offset;
        if (this.id != null) {
            base += " int " + this.id;
        }
        return base;
    }
}
