/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0047ViewAdapter.java
*@FileTitle : EsmMas0047ViewAdapter
*Open Issues :
*Change history :
* 2013.05.06 김수정 [CHM-201324486][MAS] TS Allocation상 WK, Month Display 기능 추가
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ESM_MAS_0047 에 대한 ViewAdapter<br>
 * - ESM_MAS_0047HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0047ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0047ViewAdapter(){
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
	            	
					String m_vvd_cd = JSPUtil.getNull((String)colValues.get("m_vsl_cd"))
	                				 + JSPUtil.getNull((String)colValues.get("m_skd_voy_no"))
	                				 + JSPUtil.getNull((String)colValues.get("m_dir_cd"));

                    strBuilder.append("<TR>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_cost_yrmon"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_cost_wk"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_trd_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_rlane_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_ioc_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+m_vvd_cd+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_ts_uc_amt"))+"</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_hjs_sls_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_cost_yrmon"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_cost_wk"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_trd_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_rlane_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_ioc_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_vvd_cd"))+"</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_locl_ts_sts_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_ts_qty"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("aloc_cm"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_ts_rto"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_fx_cost_dtrb_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_cml_bse_cost_amt"))+"</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_bsa_bse_cost_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_ts_ctrb_bse_cost_amt"))+"</TD>");
                    
                    
                    strBuilder.append("</TR>\n");                  
                    
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
