/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0012DefaultView.java
 *@FileTitle : EsdPrd0012DefaultView
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.22
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
=========================================================*/
/*
 * 2010.10.22 진마리아 CHM-201006410-01 HQ Link Management Logic 변경 요청
 */
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event;

import java.util.HashMap;
import java.util.Iterator;
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
* @author 9009630
* @see
* @since J2EE 1.4
*/
public class EsdPrd0012DefaultView extends ViewAdapter{

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
	 * @param object
	 * @return
	 */
    protected String nvl(Object object) {
        return object == null ? "" : object.toString();
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
//			EsdPrd0012Event e = (EsdPrd0012Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){

				//if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST) ){
				List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
				xmlString.append("<SHEET>");

		        HashMap<String, String> etc_data = (HashMap<String, String>) eventResponse.getETCData();
		        if(etc_data != null && etc_data.size() > 0) {
		            Iterator<String> it = etc_data.keySet().iterator();
			        xmlString.append("<ETC-DATA>");
		            while(it.hasNext()) {
		                String key = (String) it.next();
		                xmlString.append("<ETC KEY='" + key + "'><![CDATA[" + this.nvl(etc_data.get(key)) + "]]></ETC>");
		            }
			        // Pivot 관련 ETC-DATA생성
			        xmlString.append(getPivotETCData(eventResponse));
			        xmlString.append("</ETC-DATA>");
		        }
				
				xmlString.append("<DATA TOTAL='");
				xmlString.append(rsVoList.size());
				xmlString.append("'>");
				for(int i = 0; i < rsVoList.size(); i++){
					Map<String, String> colValues = rsVoList.get(i).getColumnValues();
					xmlString.append("<TR>");
					xmlString.append("<TD>R</TD>");
					xmlString.append("<TD></TD>");
					xmlString.append("<TD></TD>");
					xmlString.append("<TD></TD>");
					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_seq")) + "]]></TD>");
					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("vsl_slan_cd")) + "]]></TD>"); //PK
					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("skd_dir_cd")) + "]]></TD>");
					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fm_port_cd")) + "]]></TD>"); //PK

					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("fm_port_etb_dy_cd")) + "]]></TD>");

					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("fm_port_etd_dy_cd")) + "]]></TD>");
					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("to_port_cd")) + "]]></TD>"); //PK

					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("to_port_etb_dy_cd")) + "]]></TD>");

					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("to_port_etd_dy_cd")) + "]]></TD>");

					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tztm_hrs")) + "]]></TD>");
					//xmlString.append("<TD><![CDATA["+JSPUtil.getNull(colValues.get("upd_ind_cd"))+"]]></TD>");
//					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ocn_rout_rmk")) + "]]></TD>");

					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ts_ind_cd")) + "]]></TD>");

					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")) + "]]></TD>");
					
					xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("source")) + "]]></TD>");
					if(!JSPUtil.getNull(colValues.get("ocn_lnk_mnl_flg")).equals("Y")){
						xmlString.append("<TD EDIT= 'FALSE'>");
					}else{
						xmlString.append("<TD EDIT= 'TRUE'>");
					}
					xmlString.append("<![CDATA[" + JSPUtil.getNull(colValues.get("lnk_rmk")) + "]]></TD>");
					
					xmlString.append("</TR>");
				}


				xmlString.append("</DATA>");
				xmlString.append("</SHEET>");
				int size = rsVoList.size();
				for(int i = size - 1; i >= 0; i--){
					rsVoList.remove(i);
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
			//log.error("★여기들어왔나?" + ex.getMessage(), ex);
			//ex.printStackTrace();
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);

			xmlString.append(strXML);
		}
		//log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();

	}
}
