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
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 *
 * @author kim kwi-jin 2009/07/29 수정 
 * @see
 * @since J2EE 1.4
 */
public class EsdPrd0035DefaultView extends ViewAdapter{

	/**
	 *
	 * @param vos
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix){

		return "";
	}

	/**
	 * 
	 * @param rs
	 * @param prefix
	 * @return
	 */
	protected String makeDataTag(DBRowSet rs, String prefix){

		return "";
	}

	/**
	 *
	 * @param rs
	 * @return
	 */
	protected String makePivotDataTag(DBRowSet rs){
		return "";

	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public String makeXML(HttpServletRequest request, HttpServletResponse response){
		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		StringBuffer xmlString = new StringBuffer();
		String strErrMsg = "";								//에러메세지

		try{

			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");


			event = (Event) request.getAttribute("Event");
//			EsdPrd0035Event e = (EsdPrd0035Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				//strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				strErrMsg = "There is no relevant data";
			}

			if(eventResponse != null){
				if(event.getFormCommand().isCommand(FormCommand.SEARCH11)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");


					if(rsVoList != null && rsVoList.size() > 0){
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

					}else{
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
				}else{
					xmlString.append("<RESULT><TR-ALL>OK</TR-ALL></RESULT>");
				}
			}else{
				xmlString.append("<ERROR>");
				xmlString.append("<MESSAGE> <![CDATA[");
				xmlString.append(strErrMsg);
				xmlString.append("]]></MESSAGE>");
				xmlString.append("</ERROR>");
			}
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);

			String errStr = "There is no relevant data";
			//strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			strXML = getErrorXML(errStr, false);
			xmlString.append(strXML);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();

	}
}
