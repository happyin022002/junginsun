/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTViewAdapter.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.18 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * NIS2010-DMTClosing Business Logic ServiceCommand - NIS2010-DMTClosing 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sung Hoon-Lee
 * @see DMTViewAdapter
 * @since J2EE 1.6
 */

public class DMTViewAdapterTSave extends ViewAdapter {

	/* (non-Javadoc)
	 * @see com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(java.util.List, java.lang.String)
	 */
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();
			
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms = initRealColNames(vo);
								
		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
		
		for (int i=0; i < realCnt ; i++) {
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR>\n");
			
			int colCnt = realColNms.length;
			for (int j = 0 ; j < colCnt ; j++) {
				
				String cboVal  = colValues.get(realColNms[j]);
				String cboText = "";
				String cboCode = "";
				
				if (realColNms[j].equals("curr_cd")) {
					cboCode = colValues.get("all_curr_cd");
					cboText = colValues.get("all_curr_nm");
					
					if (cboText != null && cboText.indexOf("'") != -1) {
						cboText = cboText.replaceAll("'", "");
					}
				}
				
				if (cboText != null && cboText.length() > 0) {
					sbufXML.append("		<TD COMBO-TEXT='").append(cboText).append("' COMBO-CODE='").append(cboCode);
					sbufXML.append("'><![CDATA[");
				} 
				else {
					sbufXML.append("		<TD><![CDATA[");	
				}
				
				sbufXML.append(JSPUtil.getNull(cboVal));
				sbufXML.append("]]></TD>\n");
	        }
			sbufXML.append("	</TR>\n");
		}
		sbufXML.append("</DATA>\n");

		return sbufXML.toString();	
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(com.hanjin.framework.component.rowset.DBRowSet, java.lang.String)
	 */
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] initRealColNames(Object obj) {
		
		if (obj instanceof AfterBKGListVO) {
			return new String[]{"ibflag",			"Seq",				"bkg_no",				"bl_no",			"aft_bkg_cm_amt",			"dmdt_trf_cd",
								"cntr_tp",			"dc_flg",			"curr_cd",				"dc_amt",			"dc_rto",			"dc_rto2",			
								"tvvd",				"por_cd",			"pol_cd",
								"pod_cd",			"del_cd",			"rd",					"dcgo_flg",			"rc_flg",
								"awk_cgo_flg",		"bb_cgo_flg",		"rd_cgo_flg",			"soc_flg",			"cmdt_cd",
								"cmdt_nm",			"each_cntr_flg",	"aft_expt_dar_no",		"aft_expt_adj_seq",	"rqst_ofc_cd",
								"xch_rt_lvl",		"xch_rt",			"cntr_qty",				"bil_ttl",			"dc_ttl",			"aft_dc_ttl", "child_search",   "ofc_cd"};
		}
		else if (obj instanceof ChargeBookingContainerVO) {
			return new String[]{"ibflag",			"Seq",				"dmdt_chg_sts_cd",		"dmdt_ar_if_cd",	"cntr_no",
								"cntr_tpsz_cd",		"ofc_cd",			"fm_mvmt_yd_cd",		"fm_mvmt_sts_cd",	"to_mvmt_sts_cd",	
								"fm_mvmt_dt",		"fm_mvmt_dt_time",	"to_mvmt_dt",		"to_mvmt_dt_time",	
								"chg_seq_desc",	    "ft_dys",	   		"fx_ft_ovr_dys",
								
								"cntr_chg_dc_flg",
								"curr_cd",			"cntr_chg_dc_amt",	"cntr_chg_dc_rto",      "cntr_chg_dc_rto2",	
								
								"bzc_trf_curr_cd",	"bil_amt",
								
								"rqst_curr_cd",	    "rqst_bil_amt",		"rqst_dc_amt",  		"rqst_bil_aft_dc_amt",   
								"apro_curr_cd",     "apro_bil_amt",		"apro_dc_amt",			"apro_bil_aft_dc_amt",								
								
								"bkg_no",            "bl_no",			"aft_expt_dar_no",	"aft_expt_adj_seq",		"aft_expt_cntr_seq",
								
								"sys_area_grp_id",	
								"cntr_cyc_no",		"dmdt_trf_cd",		"dmdt_chg_loc_div_cd",	"chg_seq",			"org_bil_amt",
								"hidden",			"ofc_rhq_cd",		"rqst_dc_amt",			"bil_aft_dc_amt"};
		}
		else if (obj instanceof CommentHistoryVO) {
			return new String[]{"ibflg",			"Seq",				"sts_desc",				"prog_dt",			"prog_ofc_cd",
								"prog_usr_nm",		"prog_rmk_flg",			"prog_rmk"};
		}	
		return new String[] {""};
	}	
}
