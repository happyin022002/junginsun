/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0047ViewAdapter.java
*@FileTitle : EsmCoa0047ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event;

import java.util.List;
import java.util.Map;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0047 에 대한 ViewAdapter<br>
 * - ESM_COA_0047HTMLAction에서 작성<br>
 *
 * @author 김기대
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0047ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0047ViewAdapter(){
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
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_trd_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_rlane_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_ioc_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+m_vvd_cd+"</TD>");
                    //strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_ts_uc_amt"))+"</TD>");                    
                    //SJH.20141028.ADD
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("org_co_sls_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("slt_inter_prc_amt"))+"</TD>");                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("m_co_sls_amt"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_trd_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_rlane_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_ioc_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_vvd_cd"))+"</TD>");
                    
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_locl_ts_sts_cd"))+"</TD>");
                    strBuilder.append("  <TD>"+JSPUtil.getNull((String)colValues.get("d_ts_qty"))+"</TD>");
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
