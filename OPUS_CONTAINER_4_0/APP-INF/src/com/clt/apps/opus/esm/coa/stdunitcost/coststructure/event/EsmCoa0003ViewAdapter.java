/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0003ViewAdapter.java
*@FileTitle : EsmCoa0003ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
* =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.DefaultViewAdapter;
import com.clt.framework.core.layer.event.EventException;

/**
 * ESM_COA_0003 에 대한 ViewAdapter<br>
 * - ESM_COA_0003HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0003ViewAdapter extends DefaultViewAdapter {
	
    public EsmCoa0003ViewAdapter(){
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
    protected String makeDataTag(List<AbstractValueObject> list, String prefix) {
    	log.debug("########### EsmCoa0003ViewAdapter2.makeDataTag() ########### [START]");
    	CommonBC commonBc = new CommonBCImpl();
    	StringBuilder strBuilder = new StringBuilder();
        DBRowSet rowSet = null;
        int rowCount	= 0;	 //DB ResultSet 리스트의 건수
        String[] hdCdArr = null;
        //standard cost code
    	String stndCd = "";
    	String stndTxt = "";
    	HashMap stndCdMap = null;
    	HashMap stndTxtMap = null;
		
		CostStructureSoCodeRtnVO listVo = (CostStructureSoCodeRtnVO)list.get(0);
        
        rowSet = listVo.getRowSet();
        hdCdArr = listVo.getHeaderCode().replace('|', ',').split(",");
		if(rowSet != null){
			 rowCount = rowSet.getRowCount();
		}
		
    	try{
			strBuilder.append("      <DATA TOTAL=\""+rowCount+"\">");	
			
			//standard cost code map
			stndCdMap = commonBc.getCodeCombo("stnd_cost_nm", "coaCode", "", "code");
			stndTxtMap = commonBc.getCodeCombo("stnd_cost_nm", "coaCode", "", "name");
			
			if(rowSet != null){
				while (rowSet.next()) {		
					//standard cost code
					stndCd = (String)stndCdMap.get(JSPUtil.getNull(rowSet.getString("sgrp_cost_cd")));
					stndTxt = (String)stndTxtMap.get(JSPUtil.getNull(rowSet.getString("sgrp_cost_cd")));
					
					stndCd = JSPUtil.getNull(stndCd);
					stndTxt = JSPUtil.getNull(stndTxt).replaceAll("&", "&amp;");
					
					strBuilder.append("\n<TR>");
					strBuilder.append("\n<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("delt_flg"))+"]]></TD>");
					strBuilder.append("<TD></TD>");
					strBuilder.append("<TD></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("sgrp_cost_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("sgrp_cost_cd"))+"]]></TD>");
					strBuilder.append("<TD DATA-TYPE='dtCombo' COMBO-TEXT='"+ stndTxt +"' COMBO-CODE='"+ stndCd +"'><![CDATA["+JSPUtil.getNull(rowSet.getString("stnd_cost_nm"))+"]]></TD>");	
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("stnd_cost_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("coa_cost_src_prt_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_src_sys_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_src_mon"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("coa_cost_src_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("coa_cost_src_cd_nm"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_ass_bse_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_ut_amt_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("full_mty_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_vol_cd"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_vol_cd1"))+"]]></TD>");
					
					if(hdCdArr != null){
						for(int k=0; k<hdCdArr.length; k++){
							strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(hdCdArr[k]))+"]]></TD>");
						}
					}
					
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_dg_flg"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_rf_flg"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_awk_flg"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_bb_flg"))+"]]></TD>");
					//SJH.20140722 MOD
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("bkg_rev_mcgo_flg"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("bkg_full_soc_cgo_flg"))+"]]></TD>");
					strBuilder.append("<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("bkg_mcgo_flg"))+"]]></TD>");
					strBuilder.append("\n</TR>"); 
	    		}
			}	
						    
		    strBuilder.append("      </DATA>");    
        }
        catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
        catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage());
        }
            
	    log.debug("########### EsmCoa0003ViewAdapter2.makeDataTag() ########### [START]");
	    
	    return strBuilder.toString();
    }      
    
}