/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0014DefaultView.java
 *@FileTitle : EsdPrd0014DefaultView
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009/07/29
 *@LastModifier : waiterj
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
 * histroy
 * 2010.10.21 채창호 [CHM-201006410-01] : HQ Link Management Logic 변경 요청
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

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
public class EsdPrd0014DefaultView extends ViewAdapter {

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
		} else {
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
		String strErrMsg = "";
		boolean noteEdit = false;
		String routeFlag = "";
		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			event = (Event) request.getAttribute("Event");
			EsdPrd0014Event e = (EsdPrd0014Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
			if (eventResponse != null) {
				if (event.getFormCommand().isCommand(FormCommand.SEARCH) || event.getFormCommand().isCommand(FormCommand.MULTI)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					for (int i = 0; i < rsVoList.size(); i++) {

						Map<String, String> colValues = rsVoList.get(i).getColumnValues();

						StringBuffer sbStyle = new StringBuffer();
						routeFlag = JSPUtil.getNull(colValues.get("upd_ind_cd"));
						if ("V".equals(routeFlag)) {
							sbStyle.append(" BGCOLOR='255, 255, 204'");
						} else if ("T".equals(routeFlag)) {
							sbStyle.append(" BGCOLOR='255, 204, 204'");
						} else if ("A".equals(routeFlag)) {
							sbStyle.append(" BGCOLOR='204, 204, 255'");
						} else if ("G".equals(routeFlag)) {
							sbStyle.append(" BGCOLOR='150, 190, 255'");
						} else if ("N".equals(routeFlag)) {
							sbStyle.append(" BGCOLOR='150, 255, 150'");
						}
						if (e.getSearchConditionVO().getIDelFlag().equals("Y")) {
							xmlString.append("<TR edit='FALSE'").append(sbStyle.toString()).append(">");
						} else {
							xmlString.append("<TR").append(sbStyle.toString()).append(">");
							if (!JSPUtil.getNull(colValues.get("rmk")).equals("") && !chkRmkCategorized(colValues.get("rmk"))) {
								noteEdit = true;
							} else {
								noteEdit = false;
							}
						}
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
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
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tztm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_st_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("prio")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ind_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + checkRemark(JSPUtil.getNull(colValues.get("rmk")), false) + "]]></TD>");
						xmlString.append("<TD").append(noteEdit ? " EDIT='TRUE' " : "").append("><![CDATA[" + checkRemark(JSPUtil.getNull(colValues.get("rmk")), true) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("f_used")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("c_date")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("c_user")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("u_date")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("u_user")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_seq")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tztm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st_hrs")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir2")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n1st_tztm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n2nd_tztm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n3rd_tztm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n4th_tztm_hrs")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n1st_stay_tm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n2nd_stay_tm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("n3rd_stay_tm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ts_ind_cd")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod1etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2etb")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod2etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod3etb")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_cnt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ind_cd")) + "]]></TD>");

						xmlString.append("</TR>");

					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
					int size = rsVoList.size();
					for (int i = size - 1; i >= 0; i--) {
						rsVoList.remove(i);
					}
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
		return xmlString.toString();
	}
}
