/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LSEUtil.java
*@FileTitle : ETC LSEUtil Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.lsecommon;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.event.EventException;


/**
 * LseCommon Business Logic ServiceCommand - handling business transaction LseCommon
 *
 * @author 
 * @see ...
 * @since J2EE 1.4
 */

public class LSEUtil {
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	public static String[] getValueObject2StringArray(List<?> comboData ) {
		return getValueObject2StringArray(comboData,true ,"|","\t","getCd","getNm"); 
	}
	
	public static String[] getValueObject2StringArray(List<?> comboData ,boolean isIncludeCd) {
		return getValueObject2StringArray(comboData,isIncludeCd ,"|","\t","getCd","getNm"); 
	}
	
	public static String[] getValueObject2StringArray(List<?> comboData,boolean isIncludeCd,String rowSep,String colSep ) {
		return getValueObject2StringArray(comboData,isIncludeCd ,rowSep,colSep,"getCd","getNm"); 
	}
 
    public static String[] getValueObject2StringArray(List<?> comboData,boolean isIncludeCd,String rowSep,String colSep,String methodNmOfCd,String methodNmOfNm){
        StringBuffer code = new StringBuffer();
        StringBuffer text = new StringBuffer();
        String[] rtnV = {"",""};
        try{
        
            if (comboData.size() > 0) {
                Class<?> tmp1 = null;
                Method mtd1 = null;
                Method mtd2 = null;
                String strNm = null;
                String strCd = null;
                for (int i = 0; i < comboData.size(); i++) {
                    tmp1 = comboData.get(i).getClass();
                    mtd1 = tmp1.getMethod(methodNmOfNm, new Class[0]);
                    strNm = (String)mtd1.invoke(comboData.get(i), new Object[0]);
                    mtd2 = tmp1.getMethod(methodNmOfCd, new Class[0]);
                    strCd = (String)mtd2.invoke(comboData.get(i), new Object[0]);
                    if( strNm == null ) strNm = "";
                    if( strCd == null ) strCd = "";
                    if (i != 0) {
                        text.append(rowSep);
                        code.append(rowSep);
                    }
                    if( isIncludeCd == true)
                        text.append(strCd).append(colSep).append(strNm);
                    else
                        text.append(strNm);
                    code.append(strCd);
                }
            }
            rtnV[0] = code.toString();
            rtnV[1] = text.toString();        
        }catch(Exception e){
            return null;
        }
        return rtnV;
    }
    
	public static String getNvl(String str, String replaceStr) {
		if (str == null || str.trim().length() == 0)
			return replaceStr;
		return str;
	}
	
	
	/**
	 * Retrieving  Charge Type Code<br>
	 * 
	 * @param ctnt String
	 * @param specText String
	 * @param excludeText String
	 * @return boolean
	 */	
	public static boolean checkSpecificText(String ctnt, String specText, String excludeText ){
		int cnt = 1;
		int findIdx  = 0;
		String notStr = null;
		boolean flg = false;
		if(excludeText == null ){
			excludeText = "";
		}

		
		for(int i =0 ; i < cnt ; i++ ){
			findIdx  = 0;
			while(findIdx >= 0 ){
				findIdx = ctnt.indexOf(specText,findIdx );
				if( findIdx >= 0 ){
					if( excludeText.length() == 0){
						flg = true;
						break;
					}else{
						if( findIdx >= excludeText.length() ){
							notStr = ctnt.substring(findIdx-excludeText.length(),findIdx );
//							if( notStr != null && excludeText.equals(notStr )  ){
//
//							}else{
//								flg = true;
//								break;
//							}
                            if(!(notStr != null && excludeText.equals(notStr))){
                                flg = true;
                                break;
                            }
						}
					}
					findIdx++;
					
				}
				
			}
		}
		return flg;
	} 	

}
