/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0152GSViewAdapter.java
*@FileTitle : MRI Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : 장영석
*@LastVersion : 1.1
* 2009.09.14 장영석
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * EsmMas0152GS 에 대한 ViewAdapter<br>
 *  EsmMas0152GSViewAdapter 작성<br>
 *
 * @author 장영석
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0152GSViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0152GSViewAdapter(){
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
	    try{
		    strBuilder.append("<DATA TOTAL='"+totCnt+"'>");
		    if(totCnt > 0){
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
	            	String rlane_cd = String.valueOf(colValues.get("rlane_cd")); 
            		strBuilder.append("\n<TR>");
            		strBuilder.append("<TD></TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("rev_yrmon"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
					if(rlane_cd.equals("")){
						strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
					}else {
						strBuilder.append("\n <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\"|"+ rlane_cd +"\" COMBO-CODE=\"|"+ rlane_cd +"\">" +JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");						
					}
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("trd_ttl_amt"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("trd_ttl_qty"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("etc_ut_rev_amt"))+"</TD>");
					strBuilder.append("\n</TR>");  	
	            }
	            strBuilder.append("\n</DATA>");    
		    }
	    } catch(Exception e){
	    	log.error("err " + e.toString(), e);
	    }
 
		return strBuilder.toString();
    }
}

