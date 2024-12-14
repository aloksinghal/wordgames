package org.example.solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DfsSolver {
    public static boolean[] findAnswer(int[] parent, String s) {
        boolean[] results = new boolean[parent.length];
        Map<Integer,String> calcDfs = new HashMap<>();
        Map<Integer, List<Integer>> childMap = new HashMap<>();
        for (int i = 0; i < parent.length;i++) {
            int iparent = parent[i];
            List<Integer> children = childMap.getOrDefault(iparent, new ArrayList<>());
            children.add(i);
            childMap.put(iparent,children);
        }
        System.out.println(childMap);
        for (int i=0; i< parent.length; i++) {
            if (isPalindrome(dfs(i,parent,"",s,calcDfs, childMap ))) {
                results[i] = true;
            } else {
                results[i] = false;
            }
        }
        return results;
    }

    public static String dfs(int nodeNumber,int[] parent, String dfsStr, String inputStr, Map<Integer,String> calcDfs, Map<Integer, List<Integer>> chMap) {
        if (calcDfs.containsKey(nodeNumber) && dfsStr.length()==0) {
            return calcDfs.get(nodeNumber);
        }
        boolean memo = false;
        if (dfsStr.length() == 0) {
            memo = true;
        }
        List<Integer> childList = chMap.getOrDefault(nodeNumber,new ArrayList<>());
        for (Integer child : childList) {
            dfsStr = dfs(child, parent,dfsStr, inputStr, calcDfs, chMap);
        }
        dfsStr =  dfsStr + inputStr.charAt(nodeNumber);
        if (memo) {
            calcDfs.put(nodeNumber,dfsStr);
        }

        return dfsStr;
    }

    public static boolean isPalindrome(String s) {
        System.out.println(s);
        if (s.length()==0 || s.length()==1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
