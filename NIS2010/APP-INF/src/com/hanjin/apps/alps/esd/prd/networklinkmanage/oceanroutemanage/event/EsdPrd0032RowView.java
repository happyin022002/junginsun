/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0032RowView.java
 *@FileTitle : EsdPrd0032RowView
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

/**
 *
 * @author kim kwi-jin 2009/07/29 수정
 * @see
 * @since J2EE 1.4
 */
public class EsdPrd0032RowView extends ViewAdapter{

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
		String strErrMsg = "";					//에러메세지

		try{
			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");


			event = (Event) request.getAttribute("Event");
			EsdPrd0032Event e = (EsdPrd0032Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();


			xmlString.append("<?xml version=\"1.0\"  ?>");
			xmlString.append("<SHEET>");
			xmlString.append("<ETC-DATA>");
			xmlString.append("<ETC KEY=\"rowCount\">").append(rsVoList.size()).append("</ETC>");
			xmlString.append("</ETC-DATA>");
			xmlString.append("<DATA>");

			if(rsVoList != null && rsVoList.size() > 0){
				for(int i = 0; i < rsVoList.size(); i++){
					Map<String, String> colValues = rsVoList.get(0).getColumnValues();
					xmlString.append("<TR ROW=\"").append(e.getRow()).append("\">");
					xmlString.append("<TD COL=\"sDoubtFlg\"><![CDATA[").append(JSPUtil.getNull(colValues.get("upd_ind_cd"))).append("]]></TD>");
					xmlString.append("</TR>");
				}

			}else{
				xmlString.append("<TR ROW=\"").append(e.getRow()).append("\">");
				xmlString.append("<TD COL=\"sDoubtFlg\"></TD>");
				xmlString.append("</TR>");
			}
			xmlString.append("</DATA>");
			xmlString.append("</SHEET>");

		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);

		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();
	}
}
