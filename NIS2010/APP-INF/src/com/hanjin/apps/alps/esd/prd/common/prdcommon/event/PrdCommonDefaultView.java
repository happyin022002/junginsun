/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PrdCommonDefaultView.java
*@FileTitle : PRD 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-07
*@LastModifier : noh seung bae
*@LastVersion : 1.0
* 2009-07-07
* 1.0 최초 생성
* 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * 
 * @author 9009630
 * @see  
 * @since J2EE 1.5
 */
public class PrdCommonDefaultView extends ViewAdapter{

	String rowCount = "0"; //DB ResultSet 리스트의 건수
	String comData1 = "";
	String comData2 = "";
	String isDoor = "";

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
		String errMsg = "";
		StringBuffer xmlString = new StringBuffer();
		String strErrMsg = "";								//에러메세지


		try{

			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");


			event = (Event) request.getAttribute("Event");
//			PrdCommonEvent e = (PrdCommonEvent) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			rowCount = JSPUtil.getNull(eventResponse.getETCData("rowCount"), "0");
			comData1 = JSPUtil.getNull(eventResponse.getETCData("comData1"));
			comData2 = JSPUtil.getNull(eventResponse.getETCData("comData2"));
			isDoor = JSPUtil.getNull(eventResponse.getETCData("isDoor"));


			if(eventResponse != null){
				xmlString.append("<?xml version=\"1.0\"  ?>");
				xmlString.append("<SHEET>");
				xmlString.append("<DATA></DATA>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"rowCount\"><![CDATA[").append(rowCount).append("]]></ETC>");
				xmlString.append("<ETC KEY=\"comData1\"><![CDATA[").append(comData1).append("]]></ETC>");
				xmlString.append("<ETC KEY=\"comData2\"><![CDATA[").append(comData2).append("]]></ETC>");
				xmlString.append("<ETC KEY=\"isDoor\"><![CDATA[").append(isDoor).append("]]></ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("</SHEET>");
			}else{
				xmlString.append("<?xml version=\"1.0\"  ?>");
				xmlString.append("<SHEET>");
				xmlString.append("<DATA></DATA>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"rowCount\"><![CDATA[0]]></ETC>");
				xmlString.append("<ETC KEY=\"comData1\"><![CDATA[]]></ETC>");
				xmlString.append("<ETC KEY=\"comData2\"><![CDATA[]]></ETC>");
				xmlString.append("<ETC KEY=\"isDoor\"><![CDATA[]]></ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("</SHEET>");
			}
		}catch(Exception ex){

			log.error("err " + ex.toString(), ex);
			
			errMsg = "There is an improper data, Please check your input data";
			xmlString.append("<ERROR>");
			xmlString.append("<ETC-DATA>");
			xmlString.append("<ETC KEY=\"rowCount\"><![CDATA[").append(rowCount).append("]]></ETC>");
			xmlString.append("<ETC KEY=\"comData1\"><![CDATA[").append(comData1).append("]]></ETC>");
			xmlString.append("<ETC KEY=\"comData2\"><![CDATA[").append(comData2).append("]]></ETC>");
			xmlString.append("<ETC KEY=\"isDoor\"><![CDATA[<").append(isDoor).append("]]></ETC>");
			xmlString.append("</ETC-DATA>");
			xmlString.append("<MESSAGE> <![CDATA[").append(errMsg).append("]]> </MESSAGE>");
			xmlString.append("</ERROR>");

		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();
	}
}
