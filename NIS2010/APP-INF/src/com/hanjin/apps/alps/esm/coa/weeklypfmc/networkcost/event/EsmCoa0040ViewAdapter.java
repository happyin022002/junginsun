/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0040ViewAdapter.java
*@FileTitle : EsmCoa0040ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0040 에 대한 ViewAdapter<br>
 * - ESM_COA_0040HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0040ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0040ViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - List 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param List list
	 * @param String prefix
	 * @return String
	 * @exception EventException
	 */	      
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	int totCnt  = list.size();  
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    
	    StringBuilder strBuilder = new StringBuilder();
	    String ibFlag     = "";
	    String rowBgColor = "";
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map<String, String> colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
	            	ibFlag = JSPUtil.getNull((String)colValues.get("flag"));
	            	if (ibFlag.equals("I")) rowBgColor	= " BGCOLOR=\"255,255,255\"";
	            	else rowBgColor= "";

                    strBuilder.append("<TR>");
                    //strBuilder.append("  <TD>R</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("flag"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("cost_wk"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("slan_cd"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("hul_bnd_cd"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("port_clss_capa"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("vsl_clss_capa"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("clss_capa"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("port"))+"</TD>");
                    strBuilder.append("  <TD"+rowBgColor+">"+JSPUtil.getNull((String)colValues.get("cy"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("locl_curr_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("h_locl_curr_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("locl_port_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("locl_cnl_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("port_usd_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cnl_usd_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("tml_cd"))+"</TD>");
                    strBuilder.append("</TR>");   
	            }
	            //-------------------------------------------------------------------------------------------------
            } catch(Exception e){
                log.error("err " + e.toString(), e);
            }
	    }
	    
	    strBuilder.append("</DATA>");  
	    
	    return strBuilder.toString();
    }     
}
