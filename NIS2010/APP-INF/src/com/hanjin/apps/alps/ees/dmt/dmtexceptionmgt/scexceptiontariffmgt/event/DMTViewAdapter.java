/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTViewAdapter.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.27 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
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
				
				if (realColNms[j].equals("rgn_cd")) {
					cboCode = colValues.get("rgn_all_cd");
					cboText = colValues.get("rgn_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
					
					cntCd = colValues.get("cnt_cd");
					if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
						cboVal = colValues.get("ste_cd");
					}
				}
				else if (realColNms[j].equals("sc_expt_fm_cnt_cd")) {
					cboCode = colValues.get("sc_expt_fm_cnt_all_cd");
					cboText = colValues.get("sc_expt_fm_cnt_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
				}
				else if (realColNms[j].equals("sc_expt_fm_rgn_cd")) {
					cboCode = colValues.get("sc_expt_fm_rgn_all_cd");
					cboText = colValues.get("sc_expt_fm_rgn_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
					
					cntCd = colValues.get("sc_expt_fm_cnt_cd");
					if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
						cboVal = colValues.get("sc_expt_fm_ste_cd");
					}
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
				
				if (cboText.length() > 0) {
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

		if (obj instanceof SCExceptionVO) {
			return new String[]{"ibflag","Seq","dmdt_trf_cd","eff_dt","exp_dt","dmdt_cntr_cgo_tp_cd",
								"cvrg_multi","cnt_cd","rgn_cd","loc_cd","ft_flg","ft_tir","ft_add_dys",
								"ft_tot_dys","xcld_sat_flg","xcld_sun_flg","xcld_hol_flg",
								"sc_expt_fm_conti_cd","sc_expt_fm_cnt_cd","sc_expt_fm_rgn_cd",
								"sc_expt_fm_loc_cd","fnl_dest_cnt_cd","fnl_dest_rgn_cd",
								"fnl_dest_loc_cd","rcv_de_term_cd","expt_trf_rmk","prop_no","sc_expt_ver_seq",
								"sc_expt_grp_seq","cvrg_seq","curr_cvrg_multi","curr_cd","full_expt_trf_rmk",
								"rt_chk_flg","rt_chk","new_flg"};
		}
		else if (obj instanceof SCExceptionCoverageVO) {
			return new String[]{"ibflag","Seq","cnt_cd","rgn_cd","loc_cd","prop_no","sc_expt_ver_seq",
								"sc_expt_grp_seq","cvrg_seq","new_flg"};
		}
		else if (obj instanceof SCExceptionFreeTimeVO) {
			return new String[]{"ibflag","cntr_fm_qty","cntr_to_qty","ft_dys","prop_no","sc_expt_ver_seq",
								"sc_expt_grp_seq","ft_seq","new_flg"};
		}
		else if (obj instanceof SCExceptionRateAdjustVO) {
			return new String[]{"ibflag","ft_fm_dys","ft_to_dys","cntr_20ft_rt_amt","cntr_40ft_rt_amt",
					"cntr_hc_rt_amt","cntr_45ft_rt_amt","cntr_r9_rt_amt","prop_no",
					"sc_expt_ver_seq","sc_expt_grp_seq","rt_seq","new_flg"};
		}
		else if (obj instanceof SCExceptionCustomerVO) {
			return new String[]{"ibflag","cust_cd","cust_nm","prop_no","sc_expt_ver_seq",
					"sc_expt_grp_seq", "act_cust_flg","new_flg"};
		}
		else if (obj instanceof SCExceptionCommodityVO) {
			return new String[]{"ibflag","cmdt_cd","cmdt_nm","prop_no","sc_expt_ver_seq",
			"sc_expt_grp_seq","new_flg"};
		}		
		return new String[] {""};
	}
}
