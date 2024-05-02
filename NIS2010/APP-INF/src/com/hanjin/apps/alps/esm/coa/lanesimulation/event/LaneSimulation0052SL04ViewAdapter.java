/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulation0052SL04ViewAdapter.java
*@FileTitle : VOLUMN INFO RETREIVE
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
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ESM_COA_0052 SEARCHLIST04 에 대한 ViewAdapter<br>
 * - ESM_COA_0052_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */


public class LaneSimulation0052SL04ViewAdapter extends DefaultViewAdapter {
    public LaneSimulation0052SL04ViewAdapter(){
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
	            	strBuilder.append("    <TR>");
	            	strBuilder.append("        <TD>R</TD>");
	            	strBuilder.append("        <TD>Sec."+ JSPUtil.getNull((String)colValues.get("sect_no")).replaceAll("0","") +"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("sect_no"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("ioc_cd"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("skd_dir_cd"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("bsa_capa"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("lod_ttl_qty"))+"</TD>");
	            	if(JSPUtil.getNull((String)colValues.get("ldf_rto")).equals("")){ 
	            	strBuilder.append("        <TD></TD>");
	            	}else{
	            	strBuilder.append("        <TD>"+ JSPUtil.getNull((String)colValues.get("ldf_rto")) +"</TD>");
	            	}
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("grs_rpb_rev"))+"</TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("grs_ttl_rev"))+"</TD>");
	            	strBuilder.append("        <TD></TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("port_dys"))+"</TD>");
	            	strBuilder.append("        <TD></TD>");
	            	strBuilder.append("        <TD>"+JSPUtil.getNull((String)colValues.get("sim_no"))+"</TD>");
	            	strBuilder.append("    </TR>");
	            }
            } catch(Exception e){
    			log.error("err "+e.toString(),e);
            }
	    }
	    
//	    strBuilder.append("<ETC-DATA>");	
//	    strBuilder.append("<ETC KEY='name'>khlee</ETC>");	
//	    strBuilder.append("<ETC KEY='age'>30</ETC>");	
//	    strBuilder.append("</ETC-DATA>");		    
	    
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }    
}
