/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTViewAdapter.java
*@FileTitle : Manual Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.10.19 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByChargeVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * NIS2010-DMTInvoiceMgt Business Logic ServiceCommand - NIS2010-DMTInvoiceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sung Hoon-Lee
 * @see DMTViewAdapter
 * @since J2EE 1.6
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
			
		String cboVal = null;

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms = initRealColNames(vo);
								
		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}
		
		sbufXML.append("<DATA TOTAL='" + totCnt +"'>\n");
		
		for (int i=0; i < realCnt ; i++) {
			Map<String, String> colValues = vos.get(i).getColumnValues();

			if (vo instanceof DmtInvRtVO)
				sbufXML.append("	<TR HIDDEN=\"TRUE\">\n");
			else
				sbufXML.append("	<TR>\n");
			
			int colCnt = realColNms.length;
			for (int j = 0 ; j < colCnt ; j++) {
				cboVal = colValues.get(realColNms[j]);
				sbufXML.append("		<TD><![CDATA[").append(JSPUtil.getNull(cboVal)).append("]]></TD>\n");	
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

		if (obj instanceof DmtInvDtlVO || obj instanceof ManualKeyByChargeVO) {
			return new String[]{	"ibflag",	   "Seq",		 "cntr_no",		"cntr_tpsz_cd",	   "fm_mvmt_dt",
					"to_mvmt_dt",  "ft_cmnc_dt", "ft_end_dt",	"ft_dys",          "bzc_curr_cd",
					"dmdt_inv_no", "cre_ofc_cd", "inv_dtl_seq", "sys_area_grp_id", "cntr_cyc_no", "dmdt_trf_cd", "dmdt_chg_loc_div_cd", "chg_seq"};
		}
		else if (obj instanceof DmtInvRtVO) {
			return new String[]{	"ibflag",			"ft_ovr_dys",		"ft_und_dys",	"inv_rt_amt",		"rt_ovr_dys",
									"rt_ovr_chg_amt",	"bzc_trf_curr_cd",	"dmdt_inv_no",	"cre_ofc_cd",		"inv_dtl_seq",
									"inv_rt_seq"	};
		}
		
		return new String[] {""};
	}	
}
