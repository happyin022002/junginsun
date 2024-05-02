/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulation0052SL01ViewAdapter.java
*@FileTitle : TML INFO RETREIVE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
* =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0052 SEARCHLIST01 에 대한 ViewAdapter<br>
 * - ESM_MAS_0052_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulation0052SL01ViewAdapter extends DefaultViewAdapter {
    public LaneSimulation0052SL01ViewAdapter(){
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
		String sts_flg  = "";
		String yard_cd  = "";
		StringBuffer yard_cd2 = new StringBuffer();
		String yard_nm  = "";
		StringBuffer yard_nm2 = new StringBuffer();
		HashMap hm_yard_cd = null;
		HashMap hm_yard_nm = null;
		String v_port_cd = "";
    	AbstractValueObject vo = (AbstractValueObject)list.get(0);
	    int totCnt  = list.size();
	    if(vo.getMaxRows() > 0){
	      	totCnt = vo.getMaxRows();
	    }

	    try{   	
    		strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
    		if(totCnt > 0){
	            for(int i=0; i<totCnt; i++){

	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();

	            	sts_flg = JSPUtil.getNull((String)colValues.get("sts_cd"));
		            v_port_cd = JSPUtil.getNull((String)colValues.get("port_cd"));
		            
		            hm_yard_cd = commonBC.getCodeCombo("yard", "YARD2", v_port_cd, "code");
		            hm_yard_nm = commonBC.getCodeCombo("yard", "YARD2", v_port_cd, "name");
		            
		            strBuilder.append("\n    <TR>");
	            	strBuilder.append("\n      <TD></TD>");				
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("sts_cd"))+"</TD>");
	                strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("slan_cd"))+"</TD>");
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("skd_dir_cd"))+"</TD>");				
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("port_cd"))+"</TD>");
	            	
	            	if(!hm_yard_cd.isEmpty()) {
	            		yard_cd = "";
	            		Iterator iterator = hm_yard_cd.entrySet().iterator();
	            		 while(iterator.hasNext()) {
	            			 Entry entry = (Entry)iterator.next();
	            			 yard_cd2 = yard_cd2.append(entry.getValue());
               		     }
	            	}
	            	yard_cd2 = yard_cd2.append("|XX");
	            	yard_cd = yard_cd2.toString();
        			yard_cd = yard_cd.replace("\"", "'");
	            	if(!hm_yard_nm.isEmpty()) {
	            		yard_nm = "";
	            		Iterator iterator = hm_yard_nm.entrySet().iterator();
	            		 while(iterator.hasNext()) {
	            			 Entry entry = (Entry)iterator.next();
	            			 yard_nm2 = yard_nm2.append(entry.getValue());
               		     }
	            	}
	            	yard_nm2 = yard_nm2.append("|XX\tNew Termial");
	            	yard_nm = yard_nm2.toString();
	            	yard_nm = yard_nm.replace("\"", "'");
        			
	            	if(sts_flg.equals("I")){
            			if(hm_yard_cd.get(JSPUtil.getNull((String)colValues.get("port_cd"))) == null){
	            			yard_cd = "XX";
	            			yard_nm = "XX\tNew Termial";
            		    }
            			strBuilder.append("\n      <TD></TD>");
            		} else {
            			strBuilder.append("\n      <TD DATA-TYPE='dtCombo' COMBO-TEXT=\""+ yard_nm +"\" COMBO-CODE='"+ yard_cd +"'>" + JSPUtil.getNull((String)colValues.get("port_yd")) + "</TD>");				
            		}
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("tmnl_name"))+"</TD>");
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("turn_port_flg"))+"</TD>");				
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("port_dys"))+"</TD>");				
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("sea_dys"))+"</TD>");				
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("port_usd_amt"))+"</TD>"); //port charge
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("etb_dy_no"))+"</TD>");	//ETB - no	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("etb_dy_cd"))+"</TD>");	//ETB - day	 
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("etb_tm_hrmnt"))+"</TD>");	//ETB - time	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("etd_dy_no"))+"</TD>");	//ETD - no	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("etd_dy_cd"))+"</TD>");	//ETD - day	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("etd_tm_hrmnt"))+"</TD>");	//ETD - time	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("lnk_dist"))+"</TD>");	//Distance	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("mnvr_in_hrs"))+"</TD>");	//Manu - in	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("mnvr_out_hrs"))+"</TD>");	//Manu - out	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("lnk_spd"))+"</TD>");	//sea speed	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("tztm_hrs"))+"</TD>");	//sea time	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("sea_buf_hrs"))+"</TD>");	//sea buffer	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("act_wrk_hrs"))+"</TD>");	//working hour	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("port_buf_hrs"))+"</TD>");	//port buffer	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("ib_ipcgo_qty"))+"</TD>");	//IPC in	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("ib_ocn_cgo_qty"))+"</TD>");	//IPC out	
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("ob_ipcgo_qty"))+"</TD>");	//Ocean in 
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("ob_ocn_cgo_qty"))+"</TD>");	//Ocean out
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("crn_knt"))+"</TD>");	//Terminal Productivity KNT
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("tml_prod_qty"))+"</TD>");	//Terminal Productivity tml_prod_qty
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_dbl_call_seq"))+"</TD>");
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("port_seq"))+"</TD>");	
            		strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("zd"))+"</TD>");
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("vol_cnt"))+"</TD>");
	            	strBuilder.append("\n      <TD>"+JSPUtil.getNull((String)colValues.get("stnd_svc_spd"))+"</TD>");
	            	strBuilder.append("\n    </TR>");
	            }
    		}
        } catch(Exception e){
			log.error("err "+e.toString(),e);
        }    		
	    
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }    
}
