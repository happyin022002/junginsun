/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CountryCode.java
 *@FileTitle : CountryCode
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.common;

import java.util.ArrayList;

/**
 * HblSeq<br>
 * 
 * @author 김영출
 * @see BLDocumentationBLBCImpl.searchMaxMfNo() 참조
 * @since J2EE 1.4
 */
public final class HblSeq {

    /** arrSeq */
    private static ArrayList<String> arrSeq = new ArrayList<String>();
    private static int arrSize = 0;
    
    static {
        /*
        // prefix
        int[] hblPrefix = new int[26];
        int stt1 = 'H';
        for(int i=0;i<26;i++){
            hblPrefix[i] = stt1+i > 90 ? (stt1+i)-26: stt1+i;
        }
        // postfix
        int[] alphanum = new int[36];
        int stt2 = 65;
        for(int i=0;i<36;i++){
            alphanum[i] = (i<10) ? i : (stt2++);
        }
        //
        for(int h=0;h<26;h++){
            //if(hblPrefix[h] == 'I' || hblPrefix[h] == 'O') continue;
            for(int i=0;i<36;i++){
                //if(alphanum[i] == 'I' || alphanum[i] == 'O') continue;
                for(int j=0;j<10;j++){
                    if(alphanum[i] == 0 && j == 0) continue;
                    //if(alphanum[j] == 'I' || alphanum[j] == 'O') continue;
                    //arrSeq.add(String.valueOf(((alphanum[i]<10)?alphanum[i]:((char)alphanum[i]))+ "" + ((alphanum[j]<10)?alphanum[j]:((char)alphanum[j]))));
                    arrSeq.add((char)hblPrefix[h] + "" + ((alphanum[i]<10)?alphanum[i]:String.valueOf((char)alphanum[i]))+ "" + j);
                }
            }            
        }
        */
        // prefix
        char[] hblPrefix = new char[8];
        char stt1 = 'A';
        for(int i=0;i<hblPrefix.length;i++){
//            hblPrefix[i] = ((stt1+i) > 90) ? (char)((stt1+i)-26): (char)(stt1+i);
        	hblPrefix[i] = (char)(stt1 + i);
        }
        for(int h=0;h<hblPrefix.length;h++){
//            if(hblPrefix[h] == 'I' || hblPrefix[h] == 'O') continue;
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    if(i == 0 && j == 0) continue;
                    arrSeq.add(hblPrefix[h] + "" + i + "" + j);
                }
            }            
        }        
        char[] alphas = new char[26];
        int stt2 = 'A';
        for(int i=0;i<alphas.length;i++){
            alphas[i] = (char)(stt2++);
        }
        for(int h=0;h<hblPrefix.length;h++){
//            if(hblPrefix[h] == 'I' || hblPrefix[h] == 'O') continue;
            for(int i=0;i<alphas.length;i++){
                if(alphas[i] == 'I' || alphas[i] == 'O') continue;
                for(int j=0;j<10;j++){
                    if(j == 0) continue;
                    arrSeq.add(hblPrefix[h] + "" + alphas[i] + "" + j);
                }
            }            
        }
        arrSize = arrSeq.size();
        // print out
//        System.out.println("* Seq. size : " + arrSize);
//        for(int i=0;i<arrSize;i++){
//            System.out.println(i + ". " + arrSeq.get(i));
//        }
    }

    /**
     * get Maximum HBL Seq.
     *
     * @author KimYoungchul
     * @param tail
     * @return String
     */
    public static String getHblSeq(String tail){
        if(tail == null || tail.length() != 3){
            return null;
        }
        String maxSeq = null;
        for(int i=0;i<arrSize;i++){
            if(tail.equals(arrSeq.get(i))){
                if((i+1) < arrSize) {
                    maxSeq = arrSeq.get(i+1);
                }else{
                    throw new RuntimeException("HBL Seq. Number exceeds maximum.");
                }
                break;
            }
        }
        if(maxSeq == null){
            maxSeq = arrSeq.get(0);
        }
        //System.out.println("#################### " + tail + " -> " + maxSeq);
        return maxSeq;
    }

    /**
     * for test
     *
     * @author KimYoungchul
     * @param args
     */
    public static void main(String[] args){
//        System.out.println("-> " + HblSeq.getHblSeq("H01"));
//        System.out.println("-> " + HblSeq.getHblSeq("H10"));
//        System.out.println("-> " + HblSeq.getHblSeq("Z32"));
    }
}
