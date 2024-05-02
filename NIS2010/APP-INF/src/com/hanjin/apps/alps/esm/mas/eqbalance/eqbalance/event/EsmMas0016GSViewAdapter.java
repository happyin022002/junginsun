/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0016GSViewAdapter.java
*@FileTitle : EQ repo 회송 기여도 Credit setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장영석
*@LastVersion : 1.12
* 2009.10.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Prototype 에 대한 ViewAdapter<br>
 * - PrototypeHTMLAction에서 작성<br>
 *
 * @author 장영석
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0016GSViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0016GSViewAdapter(){
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
    protected String makeDataTag(List list, String prefix) {
    	StringBuilder strBuilder = new StringBuilder();

    	int totCnt  = list.size();  
    	
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	      
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
 
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();


	            
	            	if(i == 0){
	            		strBuilder.append("\n<tr BGCOLOR='222, 244, 230'>");
	            		strBuilder.append("\n	<td EDIT=\"FALSE\"></td>");						
	            		strBuilder.append("\n	<td>R</td>");
	            		strBuilder.append("\n	<td DATA-ALIGN='daCenter' EDIT='TRUE' DATA-TYPE='dtCheckBox'>" +JSPUtil.getNull((String)colValues.get("imbal_all_aply_flg"))+ "</td>	");
	            		strBuilder.append("\n	<td></td>");
	            		strBuilder.append("\n	<td></td>");
	            		strBuilder.append("\n	<td DATA-ALIGN='daCenter' EDIT='TRUE' DATA-TYPE='dtCheckBox'>" +JSPUtil.getNull((String)colValues.get("opb_all_aply_flg"))+ "</td>		");
	            		strBuilder.append("\n	<td></td>");
	            		strBuilder.append("\n	<td></td>");											
	            		strBuilder.append("\n	<td DATA-ALIGN='daCenter' EDIT='TRUE' DATA-TYPE='dtCheckBox'>" +JSPUtil.getNull((String)colValues.get("mb_all_aply_flg")) + "</td>		");
	            		strBuilder.append("\n	<td></td>");
	            		strBuilder.append("\n	<td></td>");
	            		strBuilder.append("\n	<td></td>");
	            		strBuilder.append("\n</tr>");
	            	} else {
	            	
	            		strBuilder.append("\n<TR>");
	            		strBuilder.append("\n    <TD></TD>");
	            		strBuilder.append("\n    <TD>R</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("imbal_all_aply_flg"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("imbal_fm_rto"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("imbal_to_rto"))+"</TD>");	            		

	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("opb_all_aply_flg"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("opb_fm_amt"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("opb_to_amt"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("mb_all_aply_flg"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("mb_fm_rto"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("mb_to_rto"))+"</TD>");
	            		strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("eq_repo_cr_lvl"))+"</TD>");
	            		strBuilder.append("\n</TR>  ");          		
            																																	
	            	}	       
	                
	            }
            } catch(Exception e){
    			log.error("err "+e.toString(),e);
            }
	    }
	    
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }    

}

