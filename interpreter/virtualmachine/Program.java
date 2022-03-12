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

    public void addCode(ByteCode bc) {
        this.program.add(bc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        labelList = new HashMap<>();

        // First for-loop iterates through the program arraylist to keep track of the LabelCodes and their labels
        for (int i = 0; i < program.size(); i++) {
            if (program.get(i) instanceof LabelCode) {
                LabelCode labelCode = (LabelCode) program.get(i);
                labelList.put(labelCode.getLabel(), i);
            }
        }

        // Second for-loop looks for an instance of CallCode/ReturnCode/GotoCode/FalseBranchCode
        // and finds the matching label value our of the ones in the HashMap
        for (ByteCode byteCode : program) {
            if (byteCode instanceof CallCode) {
                CallCode callCode = (CallCode) byteCode;
                if (labelList.containsKey(callCode.getLabel())) {
                    String[] function = callCode.getLabel().split("<");
                    callCode.setId(function[0]);
                    callCode.setAddress(labelList.get(callCode.getLabel()));
                }
            }
            if (byteCode instanceof ReturnCode) {
                ReturnCode returnCode = (ReturnCode) byteCode;
                if (labelList.containsKey(returnCode.getLabel())) {
                    String[] function = returnCode.getLabel().split("<");
                    returnCode.setId(function[0]);
                    returnCode.setAddress(labelList.get(returnCode.getLabel()));
                }
            }
            if (byteCode instanceof GotoCode) {
                GotoCode gotoCode = (GotoCode) byteCode;
                if (labelList.containsKey(gotoCode.getLabel())) {
                    gotoCode.setLabel(labelList.get(gotoCode.getLabel()));
                }
            }
            if (byteCode instanceof FalseBranchCode) {
                FalseBranchCode falseBranchCode = (FalseBranchCode) byteCode;
                if (labelList.containsKey(falseBranchCode.getLabel())) {
                    falseBranchCode.setLabel(labelList.get(falseBranchCode.getLabel()));
                }
            }
        }
    }
}
