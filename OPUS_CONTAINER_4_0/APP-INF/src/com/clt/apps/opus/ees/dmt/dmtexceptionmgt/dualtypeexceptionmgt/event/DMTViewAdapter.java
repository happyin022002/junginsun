/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTViewAdapter.java
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.20 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * OPUS-DMTExceptionMgt Business Logic ServiceCommand - OPUS-DMTExceptionMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sung Hoon-Lee
 * @see DMTViewAdapter
 * @since J2EE 1.6
 */

public class DMTViewAdapter extends ViewAdapter {

	/* (non-Javadoc)
	 * @see com.clt.framework.core.controller.ViewAdapter#makeDataTag(java.util.List, java.lang.String)
	 */
	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		String cboText = null;
		String cboCode = null;
		
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms = initRealColNames(vo);
		
		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
		
		for (int i = 0;  i < realCnt ; i++) {
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
			sbufXML.append("	<TR>\n");
			
			int colCnt = realColNms.length;
			for (int j = 0 ; j < colCnt ; j++) {
				
				//Region or State 콤보필드에 선택될 값을 포함한 콤보필드의 모든 데이터를 생성해준다.
				//(상위조건에 따라 하위필드값이 다르게 나타나야 하는 콤보필드에 해당됨) 
				if (realColNms[j].equals("cvrg_rgn_ste_cd")) {
					cboCode = colValues.get("cvrg_rgn_ste_all_cd");
					cboText = colValues.get("cvrg_rgn_ste_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
				}
				else if (realColNms[j].equals("dmdt_cntr_cgo_tp_cd")) {
					cboCode = colValues.get("dmdt_cntr_cgo_tp_all_cd");
					cboText = colValues.get("dmdt_cntr_cgo_tp_all_nm");
					if (cboText != null) cboText = cboText.replaceAll("'", "");
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

				sbufXML.append(JSPUtil.getNull(colValues.get(realColNms[j])));
				sbufXML.append("]]></TD>\n");
	        }
			sbufXML.append("	</TR>\n");
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}
	
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] initRealColNames(Object obj) {
		String[] colNames = null;
		
		if (obj instanceof DualTypeCustomerVO) {
			colNames = new String[]{"ibflag","Seq","del_chk","dul_expt_delt_desc","cust_cd","cust_nm",
								"dmdt_ctrt_expt_tp_cd","dul_expt_eff_dt","dul_expt_exp_dt","io_bnd_cd",
								"cvrg_cnt_cd","cvrg_rgn_ste_cd","cvrg_loc_cd","dmdt_cntr_cgo_tp_cd",
								"dul_expt_rmk","upd_ofc_cd","upd_usr_nm","upd_dt","cust_expt_seq"};
		}
		else if (obj instanceof SCOrDARListVO) {
			colNames = new String[]{"Seq","sc_no","rfa_no","prop_no","dar_no","ver","apvl_no","status","eff_dt","exp_dt",
								"io_bnd_cd","cnt_cd","rgn_cd","loc_cd","dmdt_cntr_cgo_tp_cd","loc_tp"};			
		}
		
		return colNames;
	}	
}
