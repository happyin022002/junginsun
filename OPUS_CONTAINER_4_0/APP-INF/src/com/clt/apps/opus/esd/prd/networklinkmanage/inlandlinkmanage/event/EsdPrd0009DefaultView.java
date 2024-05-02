/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0009DefaultView.java
 *@FileTitle : Inland Link 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-19 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.event;

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
 * @author jungsunyong
 * @see EsdPrd0009Event , ESD_PRD_009EventResponse 참조
 * @since J2EE 1.4
 */
public class EsdPrd0009DefaultView extends ViewAdapter{

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
	@SuppressWarnings("unchecked")
	@Override
	public String makeXML(HttpServletRequest request, HttpServletResponse response){

		Event event = null;
		GeneralEventResponse eventResponse = null;
		Exception serverException = null;
		String strXML = "";
		StringBuffer xmlString = new StringBuffer();
		String strErrMsg = "";								//에러메세지

		try{
			serverException = (Exception) request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT      ");


			event = (Event) request.getAttribute("Event");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){
				if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");
					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						xmlString.append("<TR>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_type"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_type"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("trsp_mod_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_seq"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_name"))).append("]]></TD>");
						xmlString.append("<TD EDIT='").append(JSPUtil.getNull(colValues.get("fc")).equals("T") ? "TRUE" : "FALSE").append("'><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_no"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_ref_no"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fmt_tztm_hrs"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dist"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dist_ut_cd"))).append("]]></TD>");
						xmlString.append("<TD EDIT='").append(JSPUtil.getNull(colValues.get("fc")).equals("T") ? "TRUE" : "FALSE").append("'><![CDATA[").append(JSPUtil.getNull(colValues.get("rail_crr_tp_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_org_nod_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dest_nod_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tztm_hrs"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fc"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_cnt_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_is_door"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_is_door"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("unmatch"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[]]></TD>");
						xmlString.append("<TD><![CDATA[]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fc"))).append("]]></TD>");
						xmlString.append("</TR>");
					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
					int size = rsVoList.size();
					for(int i = size - 1; i >= 0; i--){
						rsVoList.remove(i);
					}
				}else if(event.getFormCommand().isCommand(FormCommand.MULTI)) {
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");
					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						xmlString.append("<TR>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("ibflag"))).append("]]></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_type"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_type"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("trsp_mod_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_seq"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_name"))).append("]]></TD>");
						xmlString.append("<TD EDIT='").append(JSPUtil.getNull(colValues.get("fc")).equals("T") ? "TRUE" : "FALSE").append("'><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_no"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("agmt_ref_no"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fmt_tztm_hrs"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dist"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dist_ut_cd"))).append("]]></TD>");
						xmlString.append("<TD EDIT='").append(JSPUtil.getNull(colValues.get("fc")).equals("T") ? "TRUE" : "FALSE").append("'><![CDATA[").append(JSPUtil.getNull(colValues.get("rail_crr_tp_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_org_nod_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("lnk_dest_nod_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("tztm_hrs"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fc"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("vndr_cnt_cd"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("org_is_door"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_is_door"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("unmatch"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("result"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("s_result"))).append("]]></TD>");
						xmlString.append("<TD><![CDATA[").append(JSPUtil.getNull(colValues.get("fc"))).append("]]></TD>");
						xmlString.append("</TR>");
					}
					xmlString.append("</DATA>");					
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"pseudoCd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("pseudoCd"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"blankCd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("blankCd"))).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"invalidVendorCd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("invalidVendorCd"))).append("]]></ETC>");
					xmlString.append("</ETC-DATA>");
					xmlString.append("</SHEET>");
				} else  {
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
