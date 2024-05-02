/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0005RowSearchView.java
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

/**
 * 
 * @author 9009630 2009/07/29 수정
 * @see
 * @since J2EE 1.4
 */
public class EsdPrd0005RowSearchView extends ViewAdapter {

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
			EsdPrd0005Event e = (EsdPrd0005Event) event;
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();

			}
			if (eventResponse != null) {
				List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
				strErrMsg = "When you create Inland Route, there are no existed the each link for relevant routes.";
				if (serverException == null) {
					if (rsVoList != null && rsVoList.size() > 0) {
						for (int i = 0; i < rsVoList.size(); i++) {
							Map<String, String> colValues = rsVoList.get(i).getColumnValues();

							xmlString.append("<?xml version=\"1.0\"  ?>");
							xmlString.append("<SHEET>");
							xmlString.append("<ETC-DATA>");
							xmlString.append("<ETC KEY=\"rowCount\">").append(JSPUtil.getNull(rsVoList.size())).append("</ETC>");

							xmlString.append("</ETC-DATA>");
							xmlString.append("<DATA>");

							xmlString.append("<TR ROW=\"").append(e.getRowSearchInlandRouteManageVO().getRow()).append("\">");
							xmlString.append("<TD COL=\"vndr_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_seq"))).append("]]></TD>");
							xmlString.append("<TD COL=\"vndr_name\"><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_name"))).append("]]></TD>");
							xmlString.append("<TD COL=\"tztm_hrs\"><![CDATA[").append(JSPUtil.getNull(colValues.get("fmt_tztm_hrs"))).append("]]></TD>");
							xmlString.append("<TD COL=\"lnk_dist\"><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dist"))).append("]]></TD>");
							xmlString.append("<TD COL=\"dist_ut_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dist_ut_cd"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rail_crr_tp_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rail_crr_tp_cd"))).append("]]></TD>");
							xmlString.append("</TR>");

							xmlString.append("</DATA>");
							xmlString.append("</SHEET>");
						}
					} else {
						xmlString.append("<ERROR>");
						xmlString.append("<ETC-DATA>");
						xmlString.append("<ETC KEY=\"rowCount\">0</ETC>");
						xmlString.append("</ETC-DATA>");
						xmlString.append("<MESSAGE> <![CDATA[").append(strErrMsg).append("]]> </MESSAGE>");
						xmlString.append("</ERROR>");
					}
				}

			} else {
				xmlString.append("<ERROR>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"rowCount\">0</ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("<MESSAGE> <![CDATA[");
				xmlString.append(strErrMsg);
				xmlString.append("]]></MESSAGE>");
				xmlString.append("</ERROR>");
			}

		} catch (Exception ex) {
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
			log.error(ex.getMessage(), ex);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();
	}
}
