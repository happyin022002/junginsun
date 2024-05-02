/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTViewAdapter.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.19 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * NIS2010-DMTExceptionMgt Business Logic ServiceCommand - NIS2010-DMTExceptionMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sung Hoon-Lee
 * @see DMTViewAdapter
 * @since J2EE 1.4
 */

public class DMTViewAdapter extends ViewAdapter {

	/* (non-Javadoc)
	 * @see com.hanjin.framework.core.controller.ViewAdapter#makeDataTag(java.util.List, java.lang.String)
	 */
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();
			
		String cboText = null;
		String cboCode = null;
		String cboVal = null;
		String cntCd = null;

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
				
				cboVal = colValues.get(realColNms[j]);
				
				if (realColNms[j].equals("cvrg_cnt_cd")) {
					cboCode = colValues.get("cvrg_cnt_all_cd");
					cboText = colValues.get("cvrg_cnt_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
				}				
				else if (realColNms[j].equals("cvrg_rgn_cd")) {
					cboCode = colValues.get("cvrg_rgn_all_cd");
					cboText = colValues.get("cvrg_rgn_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
					
					cntCd = colValues.get("cvrg_cnt_cd");
					if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
						cboVal = colValues.get("cvrg_ste_cd");
					}
				}
				else if (realColNms[j].equals("org_dest_cnt_cd")) {
					cboCode = colValues.get("org_dest_cnt_all_cd");
					cboText = colValues.get("org_dest_cnt_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
				}
				else if (realColNms[j].equals("org_dest_rgn_cd")) {
					cboCode = colValues.get("org_dest_rgn_all_cd");
					cboText = colValues.get("org_dest_rgn_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
					
					cntCd = colValues.get("org_dest_cnt_cd");
					if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
						cboVal = colValues.get("org_dest_ste_cd");
					}
				}
				else if (realColNms[j].equals("fnl_dest_cnt_cd")) {
					cboCode = colValues.get("fnl_dest_cnt_all_cd");
					cboText = colValues.get("fnl_dest_cnt_all_nm");	
					if (cboText != null) cboText = cboText.replaceAll("'", "");
				}
				else if (realColNms[j].equals("fnl_dest_rgn_cd")) {
					cboCode = colValues.get("fnl_dest_rgn_all_cd");
					cboText = colValues.get("fnl_dest_rgn_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
					
					cntCd = colValues.get("fnl_dest_cnt_cd");
					if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
						cboVal = colValues.get("fnl_dest_ste_cd");
					}					
				}
				else {
					cboCode = "";
					cboText = "";
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

		if (obj instanceof BeforeExceptionVO) {
			return new String[]{"ibflag","Seq","dmdt_trf_cd","eff_dt","exp_dt",
								"dmdt_cntr_cgo_tp_cd","cvrg_cnt_cd","cvrg_rgn_cd","cvrg_loc_cd","ft_use_flg",
								"add_dys","ttl_dys","xcld_sat_flg","xcld_sun_flg","xcld_hol_flg","org_dest_multi",
								"org_dest_conti_cd","org_dest_cnt_cd","org_dest_rgn_cd","org_dest_loc_cd",
								"fnl_dest_cnt_cd","fnl_dest_rgn_cd","fnl_dest_loc_cd","cust_cd","cust_nm",
								"expt_trf_rmk","rfa_expt_dar_no","rfa_expt_mapg_seq","rfa_expt_ver_seq",
								"rfa_rqst_dtl_seq","cvrg_cmb_seq","view_cvrg_cmb_seq","curr_org_dest_multi",
								"curr_cd","full_expt_trf_rmk","cvrg_conti_cd","fnl_dest_conti_cd",
								"dmdt_expt_rqst_sts_cd", "rqst_ofc_cd","rt_chk_flg","rt_chk","new_flg"};
		}
		else if (obj instanceof RFAExceptionCoverageVO) {
			return new String[]{"ibflag","Seq","org_dest_conti_cd","org_dest_cnt_cd","org_dest_rgn_cd",
								"org_dest_loc_cd","cvrg_conti_cd","cvrg_cnt_cd","cvrg_rgn_cd","cvrg_loc_cd",
								"rfa_expt_dar_no","rfa_expt_mapg_seq","rfa_expt_ver_seq","rfa_rqst_dtl_seq",
								"cvrg_cmb_seq","new_flg"};
								
		}
		else if (obj instanceof RFAExceptionRateAdjustVO) {
			return new String[]{"ibflag","ft_ovr_dys","ft_und_dys","cntr_20ft_rt_amt","cntr_40ft_rt_amt",
								"cntr_hc_rt_amt","cntr_45ft_rt_amt","cntr_r9_rt_amt","rfa_expt_dar_no","rfa_expt_mapg_seq",
								"rfa_expt_ver_seq","rfa_rqst_dtl_seq","cvrg_cmb_seq","rfa_expt_rt_seq","new_flg"};
		}
		else if (obj instanceof RFAProgressVO) {
			return new String[]{"ibflag","Seq","dmdt_expt_rqst_sts_desc","prog_dt","prog_ofc_cd",
								"prog_usr_nm","prog_rmk"};
		}		
		return new String[] {""};
	}	
}
