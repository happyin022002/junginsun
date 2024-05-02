/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0141Event.java
*@FileTitle : Link별 표준단가 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 장영석
*@LastVersion : 1.1
* 2009.09.01 장영석
* 1.0 Creation
* 2011.12.30 최윤성 [CHM-201115391-01] [COA] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - avgLvlChk 필드 추가
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * EsmCoa0141GS 에 대한 ViewAdapter<br>
 *  EsmCoa0141GSViewAdapter 작성<br>
 *
 * @author 장영석
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0141GSViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0141GSViewAdapter(){
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
	            	String lvl = String.valueOf(colValues.get("lvl"));  
	            	
					strBuilder.append("\n<TR LEVEL='"+String.valueOf(lvl)+"'");
					if(lvl.equals("1")) strBuilder.append(" EXPAND='TRUE' SUM='FALSE'");
					
					strBuilder.append(">");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("nod_cd"))+"</TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("grp"))+"]]></TD>");
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("tree_col"))+"]]></TD>");				
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("wtr_rcv_term_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("wtr_de_term_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("amt"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("avg_lvl_chk"))+"</TD>");
					strBuilder.append("\n</TR>"); 
	            }
		    }
		    strBuilder.append("\n</DATA>");
		    
        } catch(Exception e){
            log.error("err " + e.toString(), e);
        }
	    
	    return strBuilder.toString();
    }    
}