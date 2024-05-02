/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0118ViewAdapter.java
*@FileTitle : EsmSpc0118ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.14 Seung-Man KIM
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_BSA_0059 에 대한 ViewAdapter<br>
 * - ESM_BSA_0059HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0118ViewAdapter extends DefaultViewAdapter {
	
    public EsmSpc0118ViewAdapter(){
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
	    //String realColNms[] = getColHeader(vo);
	      
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
	            	HashMap<String, String> colValues = ((AbstractValueObject)list.get(i)).getColumnValues();          	

                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD>R</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("pgm_no"))+"</TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("rpt_fom_desc"))+"]]></TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dp_seq"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("col_nm"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("rpt_fom_no"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dp_nm"))+"</TD>");
                    strBuilder.append("</TR>");   
	            }
	            //-------------------------------------------------------------------------------------------------
            } catch(Exception e){
            	log.error("err "+e.toString(),e);
            }
	    }
	    strBuilder.append("</DATA>");  
	    return strBuilder.toString();
    }       
}
