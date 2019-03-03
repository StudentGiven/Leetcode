import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        // String local = null;
        // String domain = null;
        // int atIndex = 0;
        for (String email : emails) {
            int atIndex = email.indexOf("@");
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.","");
            set.add(local + domain);
        }
        System.out.println(set);
        return set.size();
    }
}

