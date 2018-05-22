// 811. Subdomain Visit Count

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<String> ();
        if (cpdomains == null || cpdomains.length == 0) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer> ();
        StringBuilder sb = new StringBuilder();
        for (String s : cpdomains) {
            String[] count_domain = s.split(" ");
            String[] domain = count_domain[1].split("\\.");
            
            sb.setLength(0);
            for (int i = domain.length - 1; i >= 0; i--) {
                if (sb.length() > 0) {
                    sb.insert(0, ".");
                }
                sb.insert(0, domain[i]);
                String str = sb.toString();
                if (!map.containsKey(str)) {
                    map.put(str, Integer.valueOf(count_domain[0]));
                } else {
                    int tmp = map.get(str);
                    map.put(str, tmp + Integer.valueOf(count_domain[0]));
                }
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.setLength(0);
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            result.add(sb.toString());
        }
        
        return result;
    }
}


class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
}
