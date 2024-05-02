/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationS0166ViewAdapter.java
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
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchBSAbyVVDListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0166 SEARCHLIST01 에 대한 ViewAdapter<br>
 * - ESM_COA_0166_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulationS0166ViewAdapter extends DefaultViewAdapter {
    public LaneSimulationS0166ViewAdapter(){
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

    	SearchBSAbyVVDListVO vo = (SearchBSAbyVVDListVO)list.get(0);    	
    	DBRowSet rowSet = vo.getRowSet();  
    	StringBuilder strBuilder = new StringBuilder();

    	String v_chk_flg = "";
    	
    	int totCnt = rowSet.getRowCount();
 
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
            
	            while(rowSet.next()){
					v_chk_flg = JSPUtil.getNull((String)rowSet.getString("chk_flag"));
					if(v_chk_flg.equals("Y")){
						strBuilder.append("\n<TR EDIT='FALSE'>");
					}else{
						strBuilder.append("\n<TR EDIT='TRUE'>");
					}
					strBuilder.append("<TD></TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("vsl_cd"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("dir_cd"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("vsl_oshp_cd"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("vop_cd"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("vsl_clss_capa"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_capa"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("vsl_capa"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("fnl_hjs_bsa_capa"))+"</TD>");

					
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_001_01"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_001_01"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_001_02"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_001_02"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_001_03"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_001_03"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_001_04"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_001_04"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_001_05"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_001_05"))+"</TD>");
					
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_002_01"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_002_01"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_002_02"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_002_02"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_002_03"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_002_03"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_002_04"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_002_04"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_002_05"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_002_05"))+"</TD>");
					
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_003_01"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_003_01"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_003_02"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_003_02"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_003_03"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_003_03"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_003_04"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_003_04"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("bsa_003_05"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("amt_003_05"))+"</TD>");
					strBuilder.append("<TD>" +JSPUtil.getNull((String)rowSet.getString("vsl_flg"))+"</TD>");
					
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
