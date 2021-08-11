package com.test.bean;

public class Child extends Parent {
    public static void main(String[] args){
        String s = "abcdefghig";
        int num = 3;
        zprint(s,3);


    }
    public static void zprint(String s,int num){
        StringBuffer[] result = new StringBuffer[num] ;
        for(int ia = 0;ia<num;ia++){
            result[ia] = new StringBuffer("");
        }
        result[0].append(s.charAt(0));
        int index = 0;
        boolean down = true;
        for(int ib=1;ib<s.length();ib++){
            if(down){
                result[++index].append(s.charAt(ib));

            }else {
                result[--index].append(s.charAt(ib));
            }
            if(ib%(num-1)==0){
                if(down){
                    down = false;
                }else {
                    down = true;
                }
            }
        }
        for(int ic = 0;ic<num;ic++){
            System.out.print(result[ic].toString());
        }

    }
}
