/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0040DefaultView.java
 *@FileTitle : EsdPrd0040DefaultView
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
import com.hanjin.framework.component.message.ErrorHandler;
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
public class EsdPrd0040DefaultView extends ViewAdapter{

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
//			EsdPrd0040Event e = (EsdPrd0040Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				//strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				strErrMsg = "There is no relevant data";
			}

			if(eventResponse != null){
				if(event.getFormCommand().isCommand(FormCommand.SEARCH)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					if(rsVoList != null){

						for(int i = 0; i < rsVoList.size(); i++){

							xmlString.append("<TR>");

							xmlString.append("<TD>R</TD>");

							xmlString.append("<TD></TD>");
							Map<String, String> colValues = rsVoList.get(i).getColumnValues();

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("polx")) + "]]> </TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("podx")) + "]]> </TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lanex")) + "]]> </TD>");//aaaaa
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tpx")) + "]]> </TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ttx")) + "]]> </TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dirx")) + "]]> </TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flgx")) + "]]> </TD>");

							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("polxetb")) + "]]> </TD>");
							xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("podxetb")) + "]]> </TD>");

							xmlString.append("</TR>");
						}
					}

					xmlString.append("</DATA>");
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
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();

	}
}
