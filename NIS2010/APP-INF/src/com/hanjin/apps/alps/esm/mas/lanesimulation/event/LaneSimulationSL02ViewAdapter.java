/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationSL02ViewAdapter.java
*@FileTitle : Vessel Register Retrieve Detail
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 윤진영
*@LastVersion : 1.12
* 2009.10.05 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import java.util.List;
import java.util.Map;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0051 SEARCHLIST02 에 대한 ViewAdapter<br>
 * - ESM_MAS_0051_HTMLAction에서 작성<br>
 *
 * @author 윤진영
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class LaneSimulationSL02ViewAdapter extends DefaultViewAdapter {
    public LaneSimulationSL02ViewAdapter(){
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
					if(JSPUtil.getNull((String)colValues.get("sim_div_cd")).equals("2")){
						  strBuilder.append("<TR>");
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>");
						  strBuilder.append("	<TD>"+JSPUtil.getNull((String)colValues.get("flag"))+"</TD>");
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>");
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false' COLOR='236,231,247'>XXXX</TD>");  //VSL CD
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //VSL FLAG
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //VSL CLSS CAPA
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //VSL OSHP CD
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false' BOLD='true'>Slot Cost2</TD>"); //VOP FLAG
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false' BOLD='true' DATA-ALIGN='daLeft'>(USD2)</TD>"); //BOUND
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //VOP CD	//VOP FLAG
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //VSL CAPA
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //BSA CAPA
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false' CALCU-LOGIC=''></TD>"); //fnl_hjs_bsa_capa
						  strBuilder.append("	<TD DATA-FORMAT ='dfNone' EDIT='false'></TD>"); //ldf_rto
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa1"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa2"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa3"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa4"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa5"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD DATA-FORMAT ='dfNone' EDIT='true' CALCU-LOGIC=''>"+Float.parseFloat(JSPUtil.getNull((String)colValues.get("hjs_bfr_bsa_capa")))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa1"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa2"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa3"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa4"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa5"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa1"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa2"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa3"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa4"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa5"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sim_div_cd"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sect_no"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
					      strBuilder.append("</TR>");
					}else if(JSPUtil.getNull((String)colValues.get("sim_div_cd")).equals("1")){
						  strBuilder.append("  <TR>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("flag"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_flg"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_clss_capa"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_oshp_cd"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vop_cd"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vop_flg"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("skd_dir_cd"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_capa"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("bsa_capa"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("fnl_hjs_bsa_capa"))+"</TD>");
						  strBuilder.append("      <TD>"+Float.parseFloat(JSPUtil.getNull((String)colValues.get("ldf_rto")))*100 +"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa1"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa2"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa3"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa4"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("otr_crr_bsa_capa5"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("hjs_bfr_bsa_capa"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa1"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa2"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa3"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa4"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_lse_capa5"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa1"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa2"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa3"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa4"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sub_chtr_capa5"))+"</TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD></TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sim_div_cd"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("sect_no"))+"</TD>");
						  strBuilder.append("      <TD>"+JSPUtil.getNull((String)colValues.get("vsl_chg"))+"</TD>");
						  strBuilder.append("  </TR>");	            
					}
				}
	        } catch(Exception e){
				log.error("err "+e.toString(),e);
	        }
		}
	    
	    strBuilder.append("</DATA>");
	    return strBuilder.toString();
    }    
}
