/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0029ViewAdapter.java
*@FileTitle : EsmCoa0029ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0029 에 대한 ViewAdapter<br>
 * - ESM_COA_0029HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0029ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0029ViewAdapter(){
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
	    CommonBC commonBc = new CommonBCImpl();
		String vTrade = " | ";
		String vSLane = " | ";
		String vRLane = " | ";
		HashMap subTrd = null;
		HashMap sLane  = null;
		HashMap rLane  = null;
		
		try{
    		subTrd = commonBc.getCodeCombo("sub_trd_cd", "subTrade", "", "code");
    		sLane  = commonBc.getCodeCombo("slan_cd", "sLane2", "", "code");
    		rLane  = commonBc.getCodeCombo("rlane_cd", "rLane2", "", "code");				
		}catch(Exception e){
			log.error("err " + e.toString(), e);
		}
	    //----------------------------------------------
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{

	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();     
	            	
					if(subTrd != null) vTrade = "|" + subTrd.get(JSPUtil.getNull((String)colValues.get("trd_cd")));
					if(sLane != null)  vSLane = "|" + sLane.get(JSPUtil.getNull((String)colValues.get("trd_cd")));
					if(rLane != null)  vRLane = "|" + rLane.get(JSPUtil.getNull((String)colValues.get("trd_cd")));	
					
                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD></TD>");
                    strBuilder.append("  <TD></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("bsa_zr_flg"))+"]]></TD>");
                    strBuilder.append("  <TD>R</TD>");
                    strBuilder.append("  <TD></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("sls_yrmon"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("cost_wk"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("trd_cd"))+"]]></TD>");
                    strBuilder.append("  <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ vTrade +"\" COMBO-CODE=\""+ vTrade +"\"><![CDATA["+JSPUtil.getNull((String)colValues.get("sub_trd_cd"))+"]]></TD>");
                    strBuilder.append("  <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ vSLane +"\" COMBO-CODE=\""+ vSLane +"\"><![CDATA["+JSPUtil.getNull((String)colValues.get("slan_cd"))+"]]></TD>");
                    strBuilder.append("  <TD DATA-TYPE=\"dtCombo\" COMBO-TEXT=\""+ vRLane +"\" COMBO-CODE=\""+ vRLane +"\"><![CDATA["+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_lane_tp_cd"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("skd_voy_no"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("dir_cd"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lst_lodg_port_cd"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("lst_lodg_port_etd_dt"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("n1st_lodg_port_etd_dt"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("wky_tgt_flg"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("wky_mnl_flg"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("mon_tgt_flg"))+"]]></TD>");
                    strBuilder.append("  <TD><![CDATA["+JSPUtil.getNull((String)colValues.get("delt_flg"))+"]]></TD>");
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
