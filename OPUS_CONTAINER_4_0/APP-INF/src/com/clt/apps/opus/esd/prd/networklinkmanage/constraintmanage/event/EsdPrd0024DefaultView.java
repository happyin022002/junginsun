/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0024DefaultView.java
 *@FileTitle : PRD constraint 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-07-07
 *@LastModifier : noh seung bae
 *@LastVersion : 1.0
 * 2009-07-07
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.utility.CheckUtilities;

/**
 * 
 * @author jungsunyoung
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class EsdPrd0024DefaultView extends ViewAdapter {

	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();

		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject) vos.get(0);
		String[] realColNms = getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);

		if (vo.getMaxRows() > 0) {
			totCnt = vo.getMaxRows();
		}

		sbufXML.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + "☜☞" + "' TOTAL='" + totCnt + "'>\n");

		for (int i = 0; i < realCnt; i++) {
			Map<String, String> colValues = ((AbstractValueObject) vos.get(i)).getColumnValues();

			sbufXML.append("\t<TR><![CDATA[");
			int colCnt = realColNms.length;

			for (int j = 0; j < colCnt - 1; j++) {
				sbufXML.append(getNull((String) colValues.get(realColNms[j])) + "☜☞");
			}
			sbufXML.append(getNull((String) colValues.get(realColNms[(colCnt - 1)])) + "]]></TR>\n");
		}
		sbufXML.append("</DATA>\n");

		return sbufXML.toString();
	}

	/**
	 * 
	 * @param rs
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		StringBuilder sb = new StringBuilder();
		if (rs.isPivot()) {
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}
		String[] realColNms = getColHeader(rs);
		try {
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + "☜☞" + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			int colCount = realColNms.length;
			while (rs.next()) {
				sb.append("\t<TR><![CDATA[");
				for (int j = 1; j < colCount; j++) {
					sb.append(getNull(rs.getObject(j)) + "☜☞");
				}
				sb.append(getNull(rs.getObject(colCount)) + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		} catch (Exception ex) {
			this.log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param rs
	 * @return
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		return "";

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		StringBuffer xmlString = new StringBuffer();
		ErrorHandler errorHandler = null;
		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			event = (Event) request.getAttribute("Event");
			EsdPrd0024Event e = (EsdPrd0024Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (serverException != null) {
				errorHandler = new ErrorHandler(serverException);
			}

			if (eventResponse != null) {
				if (event.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");
					for (int i = 0; i < rsVoList.size(); i++) {
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						xmlString.append("<TR>");
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("port_pnt_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("nod_cnst_itm_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("vsl_slan_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("spcl_cgo_cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_sz_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cmdt_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cmdt_nm")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_use_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("nod_cnst_rmk")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("eff_fm_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("eff_to_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_ofc_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_usr_id")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("nod_cnst_itm_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pctl_cnst_itm_nm")) + "]]></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("s_nod_cnst_seq")) + "]]></TD>");

						xmlString.append("</TR>");
					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
					int size = rsVoList.size();
					for (int i = size - 1; i >= 0; i--) {
						rsVoList.remove(i);
					}

				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");
					for (int i = 0; i < rsVoList.size(); i++) {
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();

						xmlString.append("<TR>");
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_org_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_dest_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("trsp_mod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_cnst_itm_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("spcl_cgo_cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_sz_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cmdt_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cmdt_nm")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_use_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_cnst_rmk")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("eff_fm_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("eff_to_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_ofc_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_usr_id")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_cnst_itm_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pctl_cnst_itm_nm")) + "]]></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("s_lnk_cnst_seq")) + "]]></TD>");
						xmlString.append("</TR>");
					}

					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");

					int size = rsVoList.size();
					for (int i = size - 1; i >= 0; i--) {
						rsVoList.remove(i);
					}

				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					for (int i = 0; i < rsVoList.size(); i++) {
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						xmlString.append("<TR>");
						xmlString.append("<TD></TD>");
						if (JSPUtil.getNull(colValues.get("DELT_FLG")).equals("Y")) { // Delete 경우 - Status 강제로 지정.
							xmlString.append("<TD EDIT=\"FALSE\"></TD>");
							xmlString.append("<TD>D</TD>");
						} else {
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
						}
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("trnk_lane_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("por_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("por_node")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol_nod")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n1st_lane_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n1st_ts_port_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n2nd_lane_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n2nd_ts_port_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n3rd_lane_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod_nod")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("del_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("del_node")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("spcl_cgo_cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_sz_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_use_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_cnst_rmk")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_ofc_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_usr_id")) + "]]></TD>");
						if (JSPUtil.getNull(colValues.get("delt_flg")).equals("Y")) {
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_dt")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ofc_cd")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_usr_id")) + "]]></TD>");
						} else {
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
						}
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_cnst_seq")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("delt_flg")) + "]]></TD>");

						xmlString.append("</TR>");
					}

					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
					int size = rsVoList.size();
					for (int i = size - 1; i >= 0; i--) {
						rsVoList.remove(i);
					}
				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH10)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");
					for (int i = 0; i < rsVoList.size(); i++) {
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						xmlString.append("<TR>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD>0</TD>");
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("port_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("hub_loc_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("io_bnd_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cnst_lane_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("spcl_cgo_cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cntr_sz_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_use_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("hub_loc_cnst_rmk")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_ofc_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_usr_id")) + "]]></TD>");
						xmlString.append("</TR>");
					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");

					int size = rsVoList.size();
					for (int i = size - 1; i >= 0; i--) {
						rsVoList.remove(i);
					}

				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH11)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();

					String row = e.getRow();
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY='rowCount'>" + rsVoList.size() + "</ETC>");
					xmlString.append("</ETC-DATA>");
					xmlString.append("<DATA>");
					xmlString.append("<TR ROW=\"" + row + "\">"); // 가 꼭 필요함.

					if (rsVoList.size() > 0) {
						Map<String, String> colValues = rsVoList.get(0).getColumnValues();
						xmlString.append("<TD COL=\"s_commodity_code\"><![CDATA[" + JSPUtil.getNull(colValues.get("cmdt_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"s_commodity_name\"><![CDATA[" + JSPUtil.getNull(colValues.get("cmdt_nm")) + "]]></TD>");
					} else {
						xmlString.append("<TD COL='s_commodity_code'><![CDATA[]]></TD>");
						xmlString.append("<TD COL='s_commodity_name'><![CDATA[]]></TD>");
					}
					xmlString.append("</TR>");
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH12) || event.getFormCommand().isCommand(FormCommand.SEARCH13)) {
					if (eventResponse.getRsVoList().size() > 0) {
						xmlString.append("<SHEET>");
						xmlString.append(makeDataTag(eventResponse.getRs(), ""));
						xmlString.append("</SHEET>");
					} else {
						xmlString.append("<SHEET>\n");
						xmlString.append("<DATA  TOTAL='0'>\n");
						xmlString.append("</DATA>\n");
						xmlString.append("</SHEET>");
					}
				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH14)) {
					if (eventResponse.getRsVoList().size() > 0) {
						xmlString.append("<SHEET>");
						xmlString.append(makeDataTag(eventResponse.getRs(), ""));
						xmlString.append("</SHEET>");
					} else {
						xmlString.append("<SHEET>\n");
						xmlString.append("<DATA  TOTAL='0'>\n");
						xmlString.append("</DATA>\n");
						xmlString.append("</SHEET>");
					}
				} else {
					xmlString.append("<RESULT><TR-ALL>OK</TR-ALL></RESULT>");
				}
			} else {
				if (errorHandler != null) {
					String strErrMsg = errorHandler.loadPopupMessage();
					if (event.getFormCommand().isCommand(FormCommand.MULTI04)) {
						strErrMsg = CheckUtilities.isNullReplacement(errorHandler.getDebugMessage(), strErrMsg);
						xmlString.append("<ERROR>");
						xmlString.append("<CODE>-1</CODE>");
						xmlString.append("<MESSAGE><![CDATA[").append(strErrMsg).append("]]></MESSAGE>");
						xmlString.append("</ERROR>");
					} else {
						xmlString.append("<ERROR>");
						xmlString.append("<MESSAGE><![CDATA[").append(strErrMsg).append("]]></MESSAGE>");
						xmlString.append("</ERROR>");
					}
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
		}
		return xmlString.toString();
	}
}
