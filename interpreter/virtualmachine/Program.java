package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer> labelList;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void addCode(ByteCode code) {
        this.program.add(code);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        labelList = new HashMap<>();

        for (int i = 0; i < program.size(); i++) {
            ByteCode placeholder = this.getCode(i);
            if (placeholder instanceof LabelCode && !labelList.containsKey(((LabelCode) placeholder).getLabel())) {
                labelList.put(((LabelCode) placeholder).getLabel(), i);
            }
        }

        for (int i = 0; i < program.size(); i++) {
            ByteCode placeholder = this.getCode(i);

            if (placeholder instanceof CallCode && labelList.containsKey(((CallCode) placeholder).getLabel())) {
                String[] function = ((CallCode) placeholder).getLabel().split("<");
                ((CallCode) placeholder).setId(function[0]);
                ((CallCode) placeholder).setAddress(labelList.get(((CallCode) placeholder).getLabel()));
            }
            else if (placeholder instanceof ReturnCode && !((ReturnCode) placeholder).getLabel().equals("") && labelList.containsKey(((ReturnCode) placeholder).getLabel())) {
                String[] function = ((ReturnCode) placeholder).getLabel().split("<");
                ((ReturnCode) placeholder).setId(function[0]);
                ((ReturnCode) placeholder).setAddress(labelList.get(((ReturnCode) placeholder).getLabel()));
            }
            else if (placeholder instanceof GotoCode && labelList.containsKey(((GotoCode) placeholder).getLabel())) {
                ((GotoCode) placeholder).setLabel(labelList.get(((GotoCode) placeholder).getLabel()));
            }
            else if (placeholder instanceof FalseBranchCode && labelList.containsKey(((FalseBranchCode) placeholder).getLabel())) {
                ((FalseBranchCode) placeholder).setLabel(labelList.get(((FalseBranchCode) placeholder).getLabel()));
            }
        }
    }
}
