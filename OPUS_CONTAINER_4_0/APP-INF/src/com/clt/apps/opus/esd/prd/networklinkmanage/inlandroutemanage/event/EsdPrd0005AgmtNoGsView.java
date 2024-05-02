/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0005AgmtNoGsView.java
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
public class EsdPrd0005AgmtNoGsView extends ViewAdapter {

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

		Exception serverException = null; // 서버에서 발생한 에러
		GeneralEventResponse eventResponse = null;

		String strErrMsg = ""; // 에러메세지
		int rowCount = 0; // DB ResultSet 리스트의 건수
		String strXML = "";
		String trs_vndr_seq = "";
		StringBuffer xmlString = new StringBuffer();

		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			event = (Event) request.getAttribute("Event");
			EsdPrd0005Event e = (EsdPrd0005Event) event;
			if (serverException != null) {
				strErrMsg = "There is no relevant data";
			}
			if (serverException == null) {
				List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
				xmlString.append("<?xml version=\"1.0\"?>");
				xmlString.append("<SHEET>");
				xmlString.append("<DATA>");
				if (rsVoList != null && rsVoList.size() > 0) {
					rowCount = rsVoList.size();
					for (int i = 0; i < rowCount; i++) {
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						trs_vndr_seq = JSPUtil.getNull(colValues.get("vndr_seq"));
						xmlString.append("<TR ROW='").append(JSPUtil.getNull(e.getGetReferenceNoVO().getRow())).append("'>");
						xmlString.append("<TD COL=\"refe_no\"><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_ref_no"))).append("]]></TD>");
						xmlString.append("</TR>");
					}
				} else {
					xmlString.append("<TR ROW='").append(JSPUtil.getNull(e.getGetReferenceNoVO().getRow())).append("'>");
					xmlString.append("<TD COL=\"refe_no\"></TD>");
					xmlString.append("</TR>");
				}
				xmlString.append("</DATA>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"rowCount\">").append(rowCount).append("</ETC>");
				xmlString.append("<ETC KEY=\"trs_vndr_seq\">").append(trs_vndr_seq).append("</ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("</SHEET>");
			} else {
				xmlString.append("<?xml version=\"1.0\"  ?>");
				xmlString.append("<SHEET>");
				xmlString.append("<DATA></DATA>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"rowCount\">").append(rowCount).append("</ETC>");
				xmlString.append("<ETC KEY=\"trs_vndr_seq\">").append(trs_vndr_seq).append("</ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("<MESSAGE><![CDATA[").append(strErrMsg).append("]]></MESSAGE>");
				xmlString.append("</SHEET>");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();

	}
}
