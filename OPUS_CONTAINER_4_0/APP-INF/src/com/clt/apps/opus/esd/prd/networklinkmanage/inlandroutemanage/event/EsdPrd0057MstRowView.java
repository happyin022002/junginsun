/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0057MstRowView.java
 *@FileTitle : Inland Route Management USA Master Row 조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.03.03
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.03 김귀진
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

/**
 * 
 * @author 9009630 2009/07/29 수정
 * @see
 * @since J2EE 1.4
 */
public class EsdPrd0057MstRowView extends ViewAdapter {

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
		String strXML = "";
		Exception serverException = null; // 서버에서 발생한 에러
		GeneralEventResponse eventResponse = null;
		String strErrMsg = ""; // 에러메세지
		StringBuffer xmlString = new StringBuffer();

		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			event = (Event) request.getAttribute("Event");
			EsdPrd0057Event e = (EsdPrd0057Event) event;
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if (eventResponse != null) {
				List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
				strErrMsg = eventResponse.getETCData("strErrMsg");
				if (serverException == null) {
					if (rsVoList != null && rsVoList.size() > 0) {
						for (int i = 0; i < rsVoList.size(); i++) {
							Map<String, String> colValues = rsVoList.get(i).getColumnValues();
							xmlString.append("<?xml version=\"1.0\"  ?>");
							xmlString.append("<SHEET>");
							xmlString.append("<ETC-DATA>");
							xmlString.append("<ETC KEY=\"strErrMsg\">").append(JSPUtil.getNull(strErrMsg)).append("</ETC>");
							xmlString.append("</ETC-DATA>");
							xmlString.append("<DATA>");

							xmlString.append("<TR ROW=\"").append(e.getInlandRouteMsUSVO().getISelRow()).append("\">");
							xmlString.append("<TD COL=\"ibflag\">R</TD>");

							xmlString.append("<TD COL=\"inlnd_rout_bkg_flg\"><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg"))).append("]]></TD>");
							xmlString.append("<TD COL=\"ori_loc\"><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc"))).append("]]></TD>");
							xmlString.append("<TD COL=\"ori_loc_type\"><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc_type"))).append(">]]></TD>");
							xmlString.append("<TD COL=\"dest_loc\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc"))).append("]]></TD>");
							xmlString.append("<TD COL=\"dest_loc_type\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc_type"))).append("]]></TD>");
							xmlString.append("<TD COL=\"route\"><![CDATA[").append(JSPUtil.getNull(colValues.get("route"))).append("]]></TD>");
							xmlString.append("<TD COL=\"prio_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("prio_seq"))).append("]]></TD>");
							xmlString.append("<TD COL=\"curr_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("curr_cd"))).append("]]></TD>");
							xmlString.append("<TD COL=\"ttl_cost\"><![CDATA[").append(JSPUtil.getNull(colValues.get("ttl_cost"))).append("]]></TD>");
							xmlString.append("<TD COL=\"tot_tt\"><![CDATA[").append(JSPUtil.getNull(colValues.get("tot_tt"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rout_org_nod_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_org_nod_cd"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rout_dest_nod_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_dest_nod_cd"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rout_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_seq"))).append("]]></TD>");
							xmlString.append("<TD COL=\"hub_search_gb\"><![CDATA[").append(JSPUtil.getNull(colValues.get("hub_search_gb"))).append("]]></TD>");
							xmlString.append("<TD COL=\"front_gb\"><![CDATA[").append(JSPUtil.getNull(colValues.get("front_gb"))).append("]]></TD>");
							xmlString.append("<TD COL=\"undefine_nod\"><![CDATA[").append(JSPUtil.getNull(colValues.get("undefine_nod"))).append("]]></TD>");
							xmlString.append("<TD COL=\"group_gubun\">1</TD>");
							xmlString.append("<TD COL=\"ori_prio_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("prio_seq"))).append("]]></TD>");
							xmlString.append("</TR>");
						}
					} else {
						xmlString.append("<?xml version=\"1.0\"  ?>");
						xmlString.append("<SHEET>");
						xmlString.append("<ETC-DATA>");
						xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[").append(JSPUtil.getNull(strErrMsg)).append("]]></ETC>");
						xmlString.append("</ETC-DATA>");
						xmlString.append("<DATA>");
						xmlString.append("<TR ROW=\"").append(e.getInlandRouteMsUSVO().getISelRow()).append("\">");
						xmlString.append("<TD COL=\"vndr_seq\"></TD>");
						xmlString.append("<TD COL=\"tztm_hrs\"></TD>");
						xmlString.append("<TD COL=\"lnk_dist\"></TD>");
						xmlString.append("<TD COL=\"dist_ut_cd\"></TD>");
						xmlString.append("<TD COL=\"rail_crr_tp_cd\"></TD>");
						xmlString.append("</TR>");

					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
				} else {

					xmlString.append("<?xml version=\"1.0\"  ?>");
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[").append(JSPUtil.getNull(strErrMsg)).append("]]></ETC>");
					xmlString.append("</ETC-DATA>");
					xmlString.append("<DATA>");
					xmlString.append("<TR ROW=\"0\">");
					xmlString.append("<TD COL=\"ibflag\"></TD>");
					xmlString.append("<TD COL=\"inlnd_rout_bkg_flg\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"ori_loc\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"ori_loc_type\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"dest_loc\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"dest_loc_type\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"route\"><![CDATA[]]></TD>");

					xmlString.append("<TD COL=\"prio_seq\"><![CDATA[]]></TD>");

					xmlString.append("<TD COL=\"curr_cd\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"ttl_cost\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"tot_tt\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"rout_org_nod_cd\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"rout_dest_nod_cd\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"rout_seq\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"hub_search_gb\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"front_gb\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"undefine_nod\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"group_gubun\"></TD>");
					xmlString.append("<TD COL=\"ori_prio_seq\"><![CDATA[]]></TD>");
					xmlString.append("</TR>");
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
				}
			} else {
				xmlString.append("<?xml version=\"1.0\"  ?>");
				xmlString.append("<SHEET>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[").append(strErrMsg).append("]]></ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("<DATA>");
				xmlString.append("</DATA>");
				xmlString.append("</SHEET>");
			}
		} catch (Exception ex) {
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
			log.error(ex.getMessage(), ex);
		}
		return xmlString.toString();
	}
}
