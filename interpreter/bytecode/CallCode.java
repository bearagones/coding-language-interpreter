package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private String label;
    private String id;
    private int address;
    private ArrayList<Integer> values;

    // Call ByteCode has 1 arg -> label to jump to
    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    // Call ByteCode jumps to the specified label
    @Override
    public void execute(VirtualMachine vm) {
        values = vm.frameElements();
        vm.save();
        vm.jumpTo(address);
    }

    @Override
    public String toString() {
        String base = "CALL " + label + "\t" + id + "(";
        for (int i = 0; i < values.size(); i++) {
            if (i == values.size() - 1) {
                base += values.get(i);
            } else {
                base += values.get(i) + ",";
            }
        }
        return base + ")";
    }

    public void setAddress(int label) {
        this.address = label;
    }

    public String getLabel() {
        return label;
    }

    public void setId(String id) {
        this.id = id;
    }
}
