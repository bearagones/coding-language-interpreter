package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    int value;
    int offset;
    int stored;
    String id;

    // Store ByteCode has 1 or 2 args -> offset value and (if present) variable
    @Override
    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
        }
    }

    // Store ByteCode moves values from the top of the stack to the offset
    @Override
    public void execute(VirtualMachine vm) {
        this.value = vm.peek();
        stored = vm.store(this.offset);
    }

    @Override
    public String toString() {
        String base = "STORE " + this.offset;
        if (this.id != null) {
            base += " " + this.id + "\t" + this.id + " = " + this.stored;
        }
        return base;
    }
}
