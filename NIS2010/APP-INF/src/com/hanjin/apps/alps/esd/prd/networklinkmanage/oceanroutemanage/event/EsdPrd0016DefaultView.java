/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0016DefaultView.java
 *@FileTitle : EsdPrd0016DefaultView
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
public class EsdPrd0016DefaultView extends ViewAdapter{

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
//			EsdPrd0016Event e = (EsdPrd0016Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){
				if(event.getFormCommand().isCommand(FormCommand.SEARCH) || event.getFormCommand().isCommand(FormCommand.MODIFY)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();

					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					String upd_ind = null;
					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						if("U".equals(JSPUtil.getNull(colValues.get("upd_ind_cd")))){
							upd_ind = "Active";		//Upadated
						}else if("I".equals(JSPUtil.getNull(colValues.get("upd_ind_cd")))){
							upd_ind = "Active";		//Created
						}else if("D".equals(JSPUtil.getNull(colValues.get("upd_ind_cd")))){
							upd_ind = "Deleted";
						}else{
							upd_ind = "inActive";
						}
						xmlString.append("<TR>");
						//1
						xmlString.append("<TD></TD>");
						//2
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						//3-
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("vsl_slan_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pf_svc_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_dur_dys")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("slan_stnd_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("prod_ocn_rout_use_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pctl_svc_mod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + upd_ind + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pf_skd_rmk")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ind_cd")) + "]]></TD>");
						xmlString.append("</TR>");
					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
					int size = rsVoList.size();
					for(int i = size - 1; i >= 0; i--){
						rsVoList.remove(i);
					}
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
		//log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();
	}
}
