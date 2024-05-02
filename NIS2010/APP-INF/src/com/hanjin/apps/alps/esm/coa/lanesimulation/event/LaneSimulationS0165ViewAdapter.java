/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationS0165ViewAdapter.java
*@FileTitle : File Mgmt
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import java.util.List;
import java.util.Map;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0165 SEARCHLIST01 에 대한 ViewAdapter<br>
 * - ESM_COA_0165_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulationS0165ViewAdapter extends DefaultViewAdapter {
    public LaneSimulationS0165ViewAdapter(){
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
					strBuilder.append("<TR>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("slan_cd"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("simulation_no"))+"</TD>");
					strBuilder.append("<TD></TD>");
					if( !JSPUtil.getNull((String)colValues.get("num")).equals("1") && JSPUtil.getNull((String)colValues.get("report")).equals("001") ){
						strBuilder.append("<TD EDIT='false'>" + "</TD>");	
					}else{
						strBuilder.append("<TD EDIT='true'>" + "</TD>");
					}
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("sim_rpt_no"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("sim_rmk"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("sim_dt"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)colValues.get("sim_no"))+"</TD>");
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
