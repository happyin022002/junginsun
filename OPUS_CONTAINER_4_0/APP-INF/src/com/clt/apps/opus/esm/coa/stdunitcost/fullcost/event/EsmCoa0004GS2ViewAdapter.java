/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0004GSViewAdapter.java
*@FileTitle : Node Cost (PA/RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.07.24 박수훈  New FrameWork 적용[0004]
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.layer.event.EventException;

/**
 * EsmCoa0004GS2 에 대한 ViewAdapter<br>
 *  EsmCoa0004GS2ViewAdapter 작성<br>
 *
 * @author 박수훈
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0004GS2ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0004GS2ViewAdapter(){
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
					if(lvl.equals("1")){
						strBuilder.append(" EXPAND='TRUE' SUM='FALSE'");
					}
					strBuilder.append(">");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("grp"))+"</TD>");
//					if(lvl.equals("1")){
//						strBuilder.append("    <TD><![CDATA[" +JSPUtil.getNull((String)colValues.get("stnd_cost_nm"))+ "]]</TD>");
//					} else {
//						strBuilder.append("    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("coa_cost_src_cd_nm"))+"]]</TD>");
//					}
					strBuilder.append("\n    <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("cost_nm"))+"]]></TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("cost_ass_bse_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("locl_curr_cd"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("cost"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("spcl"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("loc_type"))+"</TD>");
					strBuilder.append("\n    <TD>"+JSPUtil.getNull((String)colValues.get("lvl"))+"</TD>");
					strBuilder.append("\n</TR>");  	
	            }
		    }
		    strBuilder.append("\n</DATA>");
		    
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        }
	    
	    return strBuilder.toString();
    }    
}