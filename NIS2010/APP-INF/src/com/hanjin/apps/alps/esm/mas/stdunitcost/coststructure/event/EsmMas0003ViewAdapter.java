/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0003ViewAdapter.java
*@FileTitle : EsmMas0003ViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.23 김기식
* 1.0 Creation
* =======================================================
* History : 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2012.06.22 황태진  Ticket No 	CHM-201218281-01 ' 오류 처리  
* [TMO][MAS/TRS] 구주 HJL 운송 Commission Fee 추정로직 변경
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.DefaultViewAdapter;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;

/**
 * ESM_MAS_0003 에 대한 ViewAdapter<br>
 * - ESM_MAS_0003HTMLAction에서 작성<br>
 *
 * @author 김기식
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0003ViewAdapter extends DefaultViewAdapter {
	
    public EsmMas0003ViewAdapter(){
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
    	log.debug("########### EsmMas0003ViewAdapter2.makeDataTag() ########### [START]");
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
			stndCdMap = commonBc.getCodeCombo("stnd_cost_nm", "masCode", "", "code");
			stndTxtMap = commonBc.getCodeCombo("stnd_cost_nm", "masCode", "", "name");
			
			if(rowSet != null){
				while (rowSet.next()) {		
					//standard cost code
					stndCd = (String)stndCdMap.get(JSPUtil.getNull(rowSet.getString("sgrp_cost_cd")));
					stndTxt = (String)stndTxtMap.get(JSPUtil.getNull(rowSet.getString("sgrp_cost_cd")));
					
					stndCd = JSPUtil.getNull(stndCd);
					stndTxt =JSPUtil.getNull(stndTxt).replaceAll("&", "&amp;");
					stndTxt =JSPUtil.getNull(stndTxt).replaceAll("'", "&apos;");
					stndTxt =JSPUtil.getNull(stndTxt).replaceAll("<", "&lt;");
					stndTxt =JSPUtil.getNull(stndTxt).replaceAll(">", "&gt;");
					stndTxt =JSPUtil.getNull(stndTxt).replaceAll("\"", "&quot;");
					strBuilder.append("\n<TR>");
					strBuilder.append("\n<TD><![CDATA[" + JSPUtil.getNull(rowSet.getString("delt_flg"))+"]]></TD>");
					strBuilder.append("\n<TD></TD>");
					strBuilder.append("\n<TD></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("sgrp_cost_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("sgrp_cost_cd"))+"]]></TD>");
					strBuilder.append("\n<TD DATA-TYPE='dtCombo' COMBO-TEXT='"+ stndTxt +"' COMBO-CODE='"+ stndCd +"'><![CDATA["+JSPUtil.getNull(rowSet.getString("stnd_cost_cd"))+"]]></TD>");	
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("stnd_cost_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("mas_cost_src_prt_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_src_sys_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_src_mon"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("mas_cost_src_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("mas_cost_src_cd_nm"))+"]]></TD>");
					strBuilder.append("\n<TD DATA-TYPE='dtCombo' COMBO-TEXT='|Average|Contract' COMBO-CODE='|A|C'>"+JSPUtil.getNull(rowSet.getString("cost_ass_bse_cd"))+"</TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_ut_amt_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("full_mty_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_vol_cd"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("cost_vol_cd1"))+"]]></TD>");
					
					if(hdCdArr != null){
						for(int k=0; k<hdCdArr.length; k++){
							strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString(hdCdArr[k]))+"]]></TD>");
						}
					}
					
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_dg_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_rf_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_awk_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("spcl_cgo_bb_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("bkg_rev_mcgo_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("bkg_full_soc_cgo_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("bkg_mcgo_flg"))+"]]></TD>");

					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("inlnd_expn_use_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("inlnd_tml_expn_calc_flg"))+"]]></TD>");
					strBuilder.append("\n<TD><![CDATA["+JSPUtil.getNull(rowSet.getString("ocn_fdr_expn_use_flg"))+"]]></TD>");

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
            
	    log.debug("########### EsmMas0003ViewAdapter2.makeDataTag() ########### [START]");
	    
	    return strBuilder.toString();
    }      
    
}