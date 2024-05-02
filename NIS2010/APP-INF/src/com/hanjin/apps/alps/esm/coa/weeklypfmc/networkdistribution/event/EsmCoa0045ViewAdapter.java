/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0045ViewAdapter.java
*@FileTitle : EsmCoa0045ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
* 2013.08.12 최성민 [CHM-201326152] [COA] HJS Sales / Slot Cht out 화면 R.Month와 Week 정보 추가

=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_COA_0045 에 대한 ViewAdapter<br>
 * - ESM_COA_0045HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0045ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0045ViewAdapter(){
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

	    //----------------------------------------------
	    
	    strBuilder.append("<DATA TOTAL=\""+totCnt+"\">");
	    if(totCnt > 0){
	    	try{
	    		
	    		//로직-------------------------------------------------------------------------------------------------            
	            for(int i=0; i<totCnt; i++){
	            	Map colValues = ((AbstractValueObject)list.get(i)).getColumnValues();          	

                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cost_yrmon"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("cost_wk"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("trd_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("rlane_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("skd_voy_no"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("dir_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("hul_bnd_cd"))+"</TD>");
  
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vop_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_oshp_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("vsl_capa"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_capa"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("bsa_op_nm"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("op_lane_tp_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("fnl_hjs_bsa_capa"))+"</TD>");
 
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("co_bsa_capa"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("hjs_bsa_rto"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("chtr_bsa_rto"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("ts_uc_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("spc_income"))+"</TD>");
 
                    strBuilder.append("  <TD>0</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_01"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_02"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_03"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_04"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_05"))+"</TD>");
 
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_06"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_07"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_08"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_09"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_10"))+"</TD>");
 
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_11"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_12"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_1_13"))+"</TD>");
  
                    strBuilder.append("  <TD>0</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_01"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_02"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_03"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_04"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_05"))+"</TD>");
  
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_06"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_07"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_08"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_09"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_10"))+"</TD>");
  
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_11"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_12"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_2_13"))+"</TD>");
  
                    strBuilder.append("  <TD>0</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_01"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_02"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_03"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_04"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_05"))+"</TD>");
  
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_06"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_07"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_08"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_09"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_10"))+"</TD>");
  
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_11"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_12"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("amt_3_13"))+"</TD>");
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
