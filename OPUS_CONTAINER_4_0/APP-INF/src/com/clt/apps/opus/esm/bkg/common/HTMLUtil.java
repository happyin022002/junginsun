/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : HTMLUtil.java
 *@FileTitle : HTMLUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.08
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.07.08 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.common;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.bizcommon.util.code.BizCodeInfo;

/**
 * HTML Utility<br>
 * 
 * @author Kim Min Jeong
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public final class HTMLUtil {
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(BizCodeInfo.class);
	
    private HTMLUtil(){
        
    }
    
    /**
     * 
     * @param name combo name
     * @param style style
     * @param selectedValue init selected value
     * @param comboList BkgComboVOs
     * @return
     */
    public static String getComboString(String name, String style, String selectedValue, List<BkgComboVO> comboList){
        return getComboString(name, style, null, null, selectedValue, comboList);
    }
    
    /**
     * 
     * @param name combo name
     * @param style style
     * @param css css class name
     * @param selectedValue init selected value
     * @param comboList BkgComboVOs
     * @return
     */
    public static String getComboString(String name, String style, String css, String selectedValue, List<BkgComboVO> comboList){
        return getComboString(name, style, css, null, selectedValue, comboList);
    }
    
    /**
     * HTML Code
     * 
     * @param name combo name
     * @param style style
     * @param css css class name
     * @param script onChange event
     * @param selectedValue init selected value
     * @param comboList BkgComboVOs
     * @return HTML String
     */
    public static String getComboString(String name, String style, String css, String script, String selectedValue, List<BkgComboVO> comboList){
        StringBuffer html = new StringBuffer("");
        int len = comboList==null ? 0 : comboList.size();
        
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"()\"") + ">\n");
        for(int i=0;i<len;i++){
            BkgComboVO vo = comboList.get(i);
            html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"</option>\n");
        }
        html.append("</select>\n");
        return html.toString();
    }
    /**
     * HTML Code
     * 
     * @param name combo name
     * @param style style
     * @param css css class name
     * @param script onChange event
     * @param selectedValue init selected value
     * @param comboList BkgComboVOs
     * @return HTML String
     */
    public static String getComboString(String name, String style, String css, String script, String selectedValue, String firstOption, List<BkgComboVO> comboList){
        StringBuffer html = new StringBuffer("");
        int len = comboList==null ? 0 : comboList.size();
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"()\"") + ">\n");
        html.append("<option value=\""+firstOption+"\" "+((firstOption.equals(selectedValue))? "selected" : "")+">"+firstOption+"</option>\n");
        for(int i=0;i<len;i++){
            BkgComboVO vo = comboList.get(i);
            html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"</option>\n");
        }
        html.append("</select>\n");
        return html.toString();
    }
    
    /**
     * 
     * @param name combo name
     * @param comCode comCode
     * @param style style
     * @param css css class name
     * @param selectedValue init selected value
     * @param String dispCol
     * @return
     */
    public static String getBkgComboHtmlString(String name,String comCode, String style){
    	return getBkgComboHtmlString(name, comCode,style, "", "", "","","");
    }
    
    /**
     * 
     * @param name combo name
     * @param comCode comCode
     * @param style style
     * @param css css class name
     * @return
     */
    public static String getBkgComboHtmlString(String name,String comCode, String style, String css){
    	return getBkgComboHtmlString(name, comCode,style, css, "", "","","");
    }
    
    /**
     * 
     * @param name combo name
     * @param comCode comCode
     * @param style style
     * @param css css class name
     * @param script onChange event
     * @return
     */
    public static String getBkgComboHtmlString(String name,String comCode, String style, String css,String script){
    	return getBkgComboHtmlString(name, comCode,style, css, script, "","","");
    }
    
    /**
     * 
     * @param name combo name
     * @param comCode comCode
     * @param style style
     * @param css css class name
     * @param script onChange event
     * @param selectedValue init selected value
     * @return
     */
    public static String getBkgComboHtmlString(String name,String comCode, String style, String css,String script, String selectedValue){
    	return getBkgComboHtmlString(name, comCode,style, css, script, selectedValue,"","");
    }
    
    /**
     * 
     * @param name combo name
     * @param comCode comCode
     * @param style style
     * @param css css class name
     * @param script onChange event
     * @param selectedValue init selected value
     * @param String firstOption
     * @return
     */
    public static String getBkgComboHtmlString(String name,String comCode, String style, String css,  String script, String selectedValue,String firstOption){
        return getBkgComboHtmlString(name, comCode,style, css, script, selectedValue,firstOption,"");
    }
    
    /**
     * HTML Code
     * 
     * @param name combo name
     * @param comCode comCode
     * @param style style
     * @param css css class name
     * @param script onChange event
     * @param selectedValue init selected value
     * @param String firstOption
     * @param String dispCol
     * @return HTML String
     */
    public static String getBkgComboHtmlString(String name, String comCode,String style, String css, String script, String selectedValue,String firstOption,String dispCol){
    	
    	BookingUtil comboUtil = new BookingUtil();
    	StringBuffer html = new StringBuffer("");
    	try{
	    	List<BkgComboVO> comboList  = comboUtil.searchCombo(comCode);
	        int len = comboList==null ? 0 : comboList.size();
	        
	        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"()\"") + ">\n");
	        if (!firstOption.equals("")){
	        html.append("<option "+" "+((firstOption.equals(selectedValue))? "selected" : "")+">"+firstOption+"</option>\n");
	        }
	        
	        for(int i=0;i<len;i++){
	            BkgComboVO vo = comboList.get(i);
	            if (dispCol.equals("1")){
	            	html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getVal()+"</option>\n");
	            }else if (dispCol.equals("2")){
	            	html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"</option>\n");
	            }else if (dispCol.equals("3")){
	            	html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"["+vo.getVal()+"]"+"</option>\n");	
	            }else if (dispCol.equals("4")){
	            	html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getDesc()+"</option>\n");	
	            }else{
	            	html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getVal()+"</option>\n");
	            }
	        }
	        html.append("</select>\n");
        
    	} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
        return html.toString();
    }
}

