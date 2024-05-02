/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationS01ViewAdapter.java
*@FileTitle : Sub trace info Retrieve
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
* 1.1 2010-05-03 윤진영  port clss capa 삭제
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchVesselInfoVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0051 SEARCH02 에 대한 ViewAdapter<br>
 * - ESM_COA_0051_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */


public class LaneSimulationS01ViewAdapter extends DefaultViewAdapter {
    public LaneSimulationS01ViewAdapter(){
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
    	try{
    		SearchVesselInfoVO  retVo = (SearchVesselInfoVO)list.get(0);
    		if(retVo.getProcgb().equals("single")) {
    			Map colValues = ((AbstractValueObject)list.get(0)).getColumnValues();
    			//to_do
    			//sub_trade  리턴
    			strBuilder.append("<TR ROW='"+JSPUtil.getNull((String)colValues.get("srow"))+"'>");
                strBuilder.append("<TD COL='sub_trd_cd' DATA-TYPE='dtCombo' COMBO-TEXT='"+JSPUtil.getNull((String)colValues.get("trade_cd"))+"' COMBO-CODE='"+JSPUtil.getNull((String)colValues.get("trade_cd"))+"'></TD>");
                strBuilder.append("</TR>");
    		}
    		else {
    			String vsl_clss_capa  = "";
//    		    String port_clss_capa = "";
    			String vop_cd         = "";
    			String vop_flg        = "";
    			String vsl_oshp_cd    = "";
    			String stnd_ldb_capa  = "";
    			String mdm_vsl_yn     = "N";     // N :변경가능 , Y :변경불가
    			String vsl_flg        = "Y";     // Y : 신규VESSEL , N: 기존 VESSEL
				Map colValues = ((AbstractValueObject)list.get(0)).getColumnValues();
    			if(totCnt > 0) {
    				vsl_flg        = "N";
    				vsl_clss_capa  = JSPUtil.getNull((String)colValues.get("vsl_clss_capa"));
//    				port_clss_capa = JSPUtil.getNull((String)colValues.get("port_clss_capa"));
    				vsl_oshp_cd    = JSPUtil.getNull((String)colValues.get("vsl_oshp_cd"));
    				vop_cd         = JSPUtil.getNull((String)colValues.get("vop_cd"));
    				stnd_ldb_capa  = JSPUtil.getNull((String)colValues.get("stnd_ldb_capa"));
    				mdm_vsl_yn     = JSPUtil.getNull((String)colValues.get("mdm_vsl_yn"));
    				if(vop_cd.equals("HJS"))  vop_flg = "1";
    				else vop_flg = "0";
    			}
    			strBuilder.append("<TR ROW='"+JSPUtil.getNull((String)colValues.get("srow"))+"'>");
            	strBuilder.append("	<TD COL='vsl_flg'>"+vsl_flg+"</TD>");
            	strBuilder.append("	<TD COL='vsl_clss_capa'>"+vsl_clss_capa+"</TD>");
//            	strBuilder.append("	<TD COL='port_clss_capa'>"+port_clss_capa+"</TD>"); 
            	strBuilder.append("	<TD COL='vsl_oshp_cd'>"+vsl_oshp_cd+"</TD>"); 
            	strBuilder.append("	<TD COL='vop_cd'>"+vop_cd+"</TD>"); 
            	strBuilder.append("	<TD COL='vop_flg'>"+vop_flg+"</TD>"); 
            	strBuilder.append("	<TD COL='vsl_capa'>"+stnd_ldb_capa+"</TD>"); 
            	strBuilder.append("	<TD COL='bsa_capa'>"+stnd_ldb_capa+"</TD>"); 
            	strBuilder.append("	<TD COL='mdm_vsl_yn'>"+mdm_vsl_yn+"</TD>"); 
            	strBuilder.append("</TR>");
    		}
    	} catch(Exception e){
			log.error("err "+e.toString(),e);
        }
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }    

}
