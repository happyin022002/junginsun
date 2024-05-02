/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0035DefaultView.java
 *@FileTitle : EsdPrd0035DefaultView
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009/07/29
 *@LastModifier : waiterj
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
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
public class EsdPrd0035DefaultView extends ViewAdapter {

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
	 * makeXML
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		StringBuffer xmlString = new StringBuffer();
		String strErrMsg = "";
		try {
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");
			event = (Event) request.getAttribute("Event");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (serverException != null) {
				strErrMsg = serverException.getMessage();
			}

			if (eventResponse != null) {
				if (event.getFormCommand().isCommand(FormCommand.SEARCH11)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");

					if (rsVoList != null && rsVoList.size() > 0) {
						Map<String, String> colValues = rsVoList.get(0).getColumnValues();
						xmlString.append("<ETC KEY='rowCnt'>" + rsVoList.size() + "</ETC>");
						xmlString.append("<ETC KEY='polx'>" + JSPUtil.getNull(colValues.get("polx")) + "</ETC>");
						xmlString.append("<ETC KEY='podx'>" + JSPUtil.getNull(colValues.get("podx")) + "</ETC>");
						xmlString.append("<ETC KEY='lanex'>" + JSPUtil.getNull(colValues.get("lanex")) + "</ETC>");
						xmlString.append("<ETC KEY='svc_tpx'>" + JSPUtil.getNull(colValues.get("svc_tpx")) + "</ETC>");
						xmlString.append("<ETC KEY='ttx'>" + JSPUtil.getNull(colValues.get("ttx")) + "</ETC>");
						xmlString.append("<ETC KEY='dirx'>" + JSPUtil.getNull(colValues.get("dirx")) + "</ETC>");
						xmlString.append("<ETC KEY='fdr_flgx'>" + JSPUtil.getNull(colValues.get("fdr_flgx")) + "</ETC>");
						xmlString.append("<ETC KEY='polxetb'>" + JSPUtil.getNull(colValues.get("polxetb")) + "</ETC>");
						xmlString.append("<ETC KEY='podxetb'>" + JSPUtil.getNull(colValues.get("podxetb")) + "</ETC>");
					} else {
						xmlString.append("<ETC KEY='rowCnt'>" + 0 + "</ETC>");
						xmlString.append("<ETC KEY='polx'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='podx'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='lanex'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='svc_tpx'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='ttx'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='dirx'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='fdr_flgx'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='polxetb'>" + "" + "</ETC>");
						xmlString.append("<ETC KEY='podxetb'>" + "" + "</ETC>");
					}
					xmlString.append("</ETC-DATA>");
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
			String errStr = "There is no relevant data";
			strXML = getErrorXML(errStr, false);
			xmlString.append(strXML);
			log.error(ex.getMessage(), ex);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();

	}
}
