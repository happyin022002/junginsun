/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationSL01ViewAdapter.java
*@FileTitle : Vessel Register Retrieve
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
*  =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0051 SEARCHLIST01 에 대한 ViewAdapter<br>
 * - ESM_COA_0051_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulationSL01ViewAdapter extends DefaultViewAdapter {
    public LaneSimulationSL01ViewAdapter(){
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
    	CommonBC commonBC = new CommonBCImpl();
    	int totCnt  = list.size();  
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	    String subTrade = "";  
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }  
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();
	            	subTrade =  commonBC.getIbCodeCombo("subTrade", "subTrade", JSPUtil.getNull((String)colValues.get("trd_cd")), "code");
	                strBuilder.append("<TR>");
	                strBuilder.append("	   <TD>R</TD>");
	                strBuilder.append("	   <TD></TD>");
	                strBuilder.append("	   <TD>Sec."+JSPUtil.getNull((String)colValues.get("sect_no")).replaceAll("0","")+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("slan_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
	                strBuilder.append("    <TD DATA-TYPE='dtCombo' COMBO-TEXT='"+subTrade+"' COMBO-CODE='"+subTrade+"'>"+JSPUtil.getNull((String)colValues.get("sub_trd_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("skd_dir_cd"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("freq_no"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("sect_no"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("vsl_cnt"))+"</TD>");
	                strBuilder.append("    <TD>"+JSPUtil.getNull((String)colValues.get("extd_lane_flg"))+"</TD>");
	                strBuilder.append("</TR>");    
	            }
            } catch(Exception e){
    			log.error("err "+e.toString(),e);
            }
	    }
	    
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }    
}
