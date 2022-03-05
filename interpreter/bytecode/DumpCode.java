package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String dumpStatus;

    // Dump ByteCode has 1 arg -> "ON" or "OFF"
    @Override
    public void init(ArrayList<String> args) {
        this.dumpStatus = args.get(0);
    }

    // Dump ByteCode requests to turn dumping ON or OFF
    @Override
    public void execute(VirtualMachine vm) {
        switch (this.dumpStatus) {
            case "ON" -> vm.dumpOn();
            case "OFF" -> vm.dumpOff();
        }
    }
}
