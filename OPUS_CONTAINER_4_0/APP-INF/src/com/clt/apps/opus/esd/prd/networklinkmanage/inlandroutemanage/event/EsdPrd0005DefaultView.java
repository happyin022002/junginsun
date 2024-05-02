/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0005DefaultView.java
 *@FileTitle : ROUTE INQUIRY
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.07.29 김귀진
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event;

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

/**
 * 
 * @author 9009630 2009/07/29 수정
 * @see
 * @since J2EE 1.4
 */
public class EsdPrd0005DefaultView extends ViewAdapter {

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
		int rowCount = 0;
		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			event = (Event) request.getAttribute("Event");
			EsdPrd0005Event e = (EsdPrd0005Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if (eventResponse != null) {
				if (event.getFormCommand().isCommand(FormCommand.MULTI01)) { // detail 저장XML인 경우
					xmlString.append("<RESULT>");
					xmlString.append("<TR-ALL>OK</TR-ALL>");
					xmlString.append("<Message><![CDATA[ OK]]> </Message>");
					xmlString.append("</RESULT>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"prio_seq_combo\">").append(eventResponse.getETCData("prio_seq_combo")).append("</ETC>");
					xmlString.append("</ETC-DATA>");
				} else {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					rowCount = rsVoList == null ? 0 : rsVoList.size();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL=\"").append(rowCount).append("\">");
					if (event.getFormCommand().isCommand(FormCommand.SEARCHLIST) || event.getFormCommand().isCommand(FormCommand.SEARCHLIST01) || event.getFormCommand().isCommand(FormCommand.MULTI)) {
						if (rsVoList != null) {
							for (int i = 0; i < rsVoList.size(); i++) {
								Map<String, String> colValues = rsVoList.get(i).getColumnValues();
								xmlString.append("<TR>");
								if (e.getSearchConditionVO().getIDelFlg().equals("Y")) {
									xmlString.append("<TD EDIT=\"FALSE\"></TD>");
								} else {
									xmlString.append("<TD></TD>");
								}
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg"))).append("]]></TD>");
								xmlString.append("<TD></TD>");
								xmlString.append("<TD></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("prio_seq"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_org_nod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_dest_nod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("route"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_tmp_flg"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_incl_sttl_flg"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("curr_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ttl_cost"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tot_tt"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cre_usr_id"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cre_ofc_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("cre_dt"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_usr_id"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_dt"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_usr_id"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_dt"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_rmk"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_seq"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("hub_search_gb"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("front_gb"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("undefine_nod"))).append("]]></TD>");
								xmlString.append("<TD>1</TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("prio_seq"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc_type"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc_type"))).append("]]></TD>");
								xmlString.append("</TR>");
							}
						}
					} else if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
						if (rsVoList != null) {
							for (int i = 0; i < rsVoList.size(); i++) {
								Map<String, String> colValues = rsVoList.get(i).getColumnValues();

								if (e.getSearchConditionVO().getIHubSearchGb().equals("Y")) {
									if (e.getSearchConditionVO().getIFrontGb().equals("F") && i == 0) {
										xmlString.append("<TR>");
										xmlString.append("<TD>R</TD>");
										xmlString.append("<TD>I</TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIUndefineNod()).substring(0, 5)).append("]]></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIUndefineNod()).substring(5)).append("]]></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIRoutOrgNodCd()).substring(0, 5)).append("]]></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIRoutOrgNodCd()).substring(5)).append("]]></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getISelrow())).append("]]></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("</TR>");
									}
								}
								xmlString.append("<TR>");
								xmlString.append("<TD>R</TD>");
								if (e.getSearchConditionVO().getIHubSearchGb().equals("Y")) {
									xmlString.append("<TD>I</TD>");
								} else {
									xmlString.append("<TD></TD>");
								}
								xmlString.append("<TD></TD>");
								xmlString.append("<TD></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_org_loc"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_org_type"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dest_loc"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dest_type"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("trsp_mod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_seq"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_abbr_nm"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fmt_tztm_hrs"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_no"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_ref_no"))).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_cmb_flg")).equals("Y") ? JSPUtil.getNull(colValues.get("inlnd_rout_cmb_flg")) : "").append("]]></TD>");
								xmlString.append("<TD EDIT=\"").append(JSPUtil.getNull(colValues.get("fc")).equals("T") ? "TRUE" : "FALSE").append("\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rail_crr_tp_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_junc_nm"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("curr_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("agree_rate"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("exp_to_dt"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_org_nod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dest_nod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("trsp_mod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_org_nod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_dest_nod_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_seq"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_dtl_seq"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getISelrow())).append("]]></TD>");

								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_seq"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_no"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_cmb_flg")).equals("Y") ? JSPUtil.getNull(colValues.get("inlnd_rout_cmb_flg")) : "").append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("rail_crr_tp_cd"))).append("]]></TD>");
								xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_junc_nm"))).append("]]></TD>");
								xmlString.append("</TR>");

								if (e.getSearchConditionVO().getIHubSearchGb().equals("Y")) {
									if (e.getSearchConditionVO().getIFrontGb().equals("B") && (i + 1 == rsVoList.size())) {
										xmlString.append("<TR>");
										xmlString.append("<TD>R</TD>");
										xmlString.append("<TD>I</TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIRoutDestNodCd()).substring(0, 5)).append("]]></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIRoutDestNodCd()).substring(5)).append("]]></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIUndefineNod()).substring(0, 5)).append("]]></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getIUndefineNod()).substring(5)).append("]]></TD>");

										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(e.getSearchConditionVO().getISelrow())).append("]]></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("<TD></TD>");
										xmlString.append("</TR>");
									}
								}
							}
						}
					}
					xmlString.append("</DATA>");
					xmlString.append("<ETC-DATA>");

					if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
						if (rsVoList != null && rsVoList.size() > 0) {
							Map<String, String> colValues = rsVoList.get(0).getColumnValues();
							xmlString.append("<ETC KEY=\"i_inv\"><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_inv_bil_patt_cd"))).append("]]></ETC>");
							xmlString.append("<ETC KEY=\"i_rout_pln_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_pln_cd"))).append("]]></ETC>");
							xmlString.append("<ETC KEY=\"i_route_rmk\"><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_rmk"))).append("]]></ETC>");
							xmlString.append("<ETC KEY=\"disable_bkg_flg\"><![CDATA[").append(JSPUtil.getNull(colValues.get("cc"))).append("]]></ETC>");
							xmlString.append("<ETC KEY=\"i_bkg_flg\"><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg")).equals("Y") ? JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg")) : "").append("]]></ETC>");
							xmlString.append("<ETC KEY=\"i_mcntr_rout_flg\"><![CDATA[").append(JSPUtil.getNull(colValues.get("mcntr_rout_flg")).equals("Y") ? JSPUtil.getNull(colValues.get("mcntr_rout_flg")) : "").append("]]></ETC>");
						}

					} else if (event.getFormCommand().isCommand(FormCommand.SEARCHLIST) || event.getFormCommand().isCommand(FormCommand.SEARCHLIST01) || event.getFormCommand().isCommand(FormCommand.MULTI)) {
						xmlString.append("<ETC KEY=\"prio_seq_combo\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("prio_seq_combo"))).append("]]></ETC>");
						xmlString.append("<ETC KEY=\"maxPrioSeq\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("maxPrioSeq"))).append("]]></ETC>");
					} else if (event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
						xmlString.append("<ETC KEY=\"cnt_cd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("cnt_cd"))).append("]]></ETC>");
					}

					xmlString.append("</ETC-DATA >");
					xmlString.append("</SHEET>");
					if(rsVoList != null) {
						for (int i = rowCount - 1; i >= 0; i--) {
							rsVoList.remove(i);
						}
					}
				}
			} else {
				xmlString.append("<ERROR>");
				xmlString.append("<MESSAGE> <![CDATA[");
				xmlString.append(strErrMsg);
				xmlString.append("]]></MESSAGE>");
				xmlString.append("</ERROR>");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);

			xmlString.append(strXML);
		}
		return xmlString.toString();
	}
}
