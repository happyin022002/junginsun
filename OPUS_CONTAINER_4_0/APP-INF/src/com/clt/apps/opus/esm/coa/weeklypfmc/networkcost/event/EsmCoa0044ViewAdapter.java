/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmXxx0000ViewAdapter_List.java
*@FileTitle : EsmXxx0000ViewAdapter_List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0044 에 대한 ViewAdapter<br>
 * - ESM_COA_0044HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조 
 * @since J2EE 1.6
 */
public class EsmCoa0044ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0044ViewAdapter(){
    	super();
    }
    
	/**
	 * View Adapter 생성시 자동으로 호출된다.<br>
	 *  - List 데이타에 대해서 XML을 구현한 문자열을 구현하여 준다.<br>
	 * 
	 * @param List<AbstractValueObject> list
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
	    
	    //로직----------------------------------------

	    //----------------------------------------------
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
                    
                    strBuilder.append("<TR>");
            		strBuilder.append("  <TD>1</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("subsum_code"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("skd_voy_no"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("conti_nm"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("loc_cd"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_dbl_call_seq"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("clpt_seq"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("aply_voy_rto"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("pndlm_rto"))+"</TD>");					//20160129.ADD
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_01"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_02"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("port_dys"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("sea_dys"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("ttl_tz_dys"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_13"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_03"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_04"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_05"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_06"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_07"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_08"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_09"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_10"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_11"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_12"))+"</TD>");
            		strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_14"))+"</TD>");			
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
