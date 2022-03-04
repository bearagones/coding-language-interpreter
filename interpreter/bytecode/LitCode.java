package interpreter.bytecode;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int value;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
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
