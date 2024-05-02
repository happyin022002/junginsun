/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0060DefaultView.java
 *@FileTitle : EsdPrd0060DefaultView
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009/07/29
 *@LastModifier : waiterj
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.apps.opus.esd.prd.common.PrdConstants;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * 
 * @author kim kwi-jin 2009/07/29 수정
 * @see
 * @since J2EE 1.4
 */
public class EsdPrd0060DefaultView extends ViewAdapter {

	/**
	 * 
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		return "";
	}

	/**
	 * 
	 * @param rs
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(DBRowSet rs, String prefix) {
		return "";
	}

	/**
	 * 
	 * @param rs
	 * @return
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		return "";
	}

	protected String nvl(Object object) {
		return object == null ? "" : object.toString();
	}

	// PMG 수석님 소스
	/**
	 * Remark에 대한 화면 분할 처리를 한다.
	 * 
	 * @param rmk
	 * @param isNote
	 * @return
	 */
	private String checkRemark(String rmk, boolean isNote) {
		if (rmk == null || rmk.equals("")) {
			return "";
		}

		boolean bCategorized = chkRmkCategorized(rmk);

		if (isNote) {
			if (bCategorized) {
				return "";
			} else {
				return rmk;
			}
		} else { // RMK
			if (bCategorized) {
				return rmk;
			} else {
				return PrdConstants.PRD_USRRMK_OTHERS;
			}
		}
	}

	/**
	 * Remark가 Category내에 있는지 확인
	 * 
	 * @param rmk
	 * @return
	 */
	private boolean chkRmkCategorized(String rmk) {
		if (PrdConstants.PRD_USRRMK_SPACE.equals(rmk) || PrdConstants.PRD_USRRMK_CUSTOMER.equals(rmk) || PrdConstants.PRD_USRRMK_PORTSKIP.equals(rmk) || PrdConstants.PRD_USRRMK_VSLOUT.equals(rmk) || PrdConstants.PRD_USRRMK_CUSTOMS.equals(rmk) || PrdConstants.PRD_USRRMK_CLERICAL.equals(rmk)) {
			return true;
		} else {
			return false;
		}
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
		String strErrMsg = ""; // 에러메세지
		boolean noteEdit = false;
		try {

			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			event = (Event) request.getAttribute("Event");
			EsdPrd0060Event e = (EsdPrd0060Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
			if (serverException == null) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.MULTI)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();

					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					if (rsVoList != null) {
						for (int i = 0; i < rsVoList.size(); i++) {
							Map<String, String> colValues = rsVoList.get(i).getColumnValues();
							if (!JSPUtil.getNull(colValues.get("rmk")).equals("") && !chkRmkCategorized(colValues.get("rmk"))) {
								noteEdit = true;
							} else {
								noteEdit = false;
							}

							xmlString.append("<TR>");
							xmlString.append("<TD></TD>");
							if (JSPUtil.getNull(colValues.get("tg_exist")).equals("Y")) {
								xmlString.append("<TD EDIT= 'TRUE'></TD>");
							} else {
								xmlString.append("<TD EDIT= 'FALSE'></TD>");
							}
							if (JSPUtil.getNull(colValues.get("tg_exist")).equals("Y")) {
								xmlString.append("<TD EDIT= 'FALSE'></TD>");
							} else {
								xmlString.append("<TD EDIT= 'TRUE'></TD>");
							}

							xmlString.append("<TD>R</TD>");
							xmlString.append("<TD EDIT= 'FALSE'><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ind_cd")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + checkRemark(JSPUtil.getNull(colValues.get("rmk")), false) + "]]></TD>");
							xmlString.append("<TD ").append(noteEdit ? "EDIT='TRUE'" : "EDIT='FALSE'").append(" ><![CDATA[" + checkRemark(JSPUtil.getNull(colValues.get("rmk")), true) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("prio")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("org_loc_cd")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane4")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir4")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp4")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dest_loc_cd")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tot_tt")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tot_st")) + "]]></TD>");

							// HIDDEN
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tot_tt_st")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("link_valid_flg")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("c_date")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("c_user")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_usd")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_seq")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tot_tt")) + "]]></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt4")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tot_st")) + "]]></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st3")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod1")) + "]]></TD>"); //
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg1")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod2")) + "]]></TD>"); //
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg2")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod3")) + "]]></TD>"); //
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg3")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod4")) + "]]></TD>"); //
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir4")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg4")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ts_ind")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod1etb")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2etb")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod2etb")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3etb")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod3etb")) + "]]></TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4etb")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("link_count")) + "]]></TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ind_cd")) + "]]></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("<TD></TD>");
							xmlString.append("</TR>");

						}
					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");

				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {

					HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");
					if (etc_data != null && etc_data.size() > 0) {
						Iterator<String> it = etc_data.keySet().iterator();
						while (it.hasNext()) {
							String key = (String) it.next();
							xmlString.append("<ETC KEY='" + key + "'><![CDATA[" + this.nvl(etc_data.get(key)) + "]]></ETC>");
						}
					}
					// Pivot 관련 ETC-DATA생성
					xmlString.append(getPivotETCData(eventResponse));
					xmlString.append("</ETC-DATA>");
					xmlString.append("</SHEET>");

				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL=\"").append("0").append("\">");
					xmlString.append("</DATA>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"prio\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("prio"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pol1\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pol1"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pol2\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pol2"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pol3\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pol3"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pol4\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pol4"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pod1\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pod1"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pod2\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pod2"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pod3\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pod3"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"pod4\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pod4"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"dir1\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("dir1"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"dir2\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("dir2"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"dir3\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("dir3"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"dir4\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("dir4"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fdr_flg1\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fdr_flg1"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fdr_flg2\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fdr_flg2"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fdr_flg3\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fdr_flg3"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fdr_flg4\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fdr_flg4"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"svc_tp1\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("svc_tp1"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"svc_tp2\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("svc_tp2"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"svc_tp3\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("svc_tp3"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"svc_tp4\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("svc_tp4"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fmt_tot_tt\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fmt_tot_tt"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fmt_tot_st\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fmt_tot_st"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fmt_tt\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fmt_tt"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"link_valid_flg\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("link_valid_flg"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"fdr_usd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("fdr_usd"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"link_cnt\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("link_cnt"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"upd_ind_cd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("upd_ind_cd"))).append("]]></ETC>");

					xmlString.append("</ETC-DATA >");
					xmlString.append("</SHEET>");
				} else {
					xmlString.append("<RESULT><TR-ALL>OK</TR-ALL></RESULT>");
				}

			} else {
				xmlString.append("<ERROR>");
				xmlString.append("<MESSAGE> <![CDATA[");
				xmlString.append(strErrMsg);
				xmlString.append("]]></MESSAGE>");
				xmlString.append("</ERROR>");
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();
	}
}
