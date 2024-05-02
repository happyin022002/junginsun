/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0005MstRowView.java
 *@FileTitle : ROUTE INQUIRY
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.07.29 김귀진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

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
* @author 9009630 2009/07/29 수정
* @see
* @since J2EE 1.4
*/
public class EsdPrd0005MstRowView extends ViewAdapter{

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
		String strXML = "";
		Exception serverException = null;            		//서버에서 발생한 에러
		GeneralEventResponse eventResponse = null;

//		DBRowSet rowSet = null;                         //DB ResultSet
		String strErrMsg = "";                           //에러메세지
//		int rowCount = 0;                            //DB ResultSet 리스트의 건수
//		String sRow = "";									//데이터를 입력할 Row
		int maxPrioSeq = 0;
		String comboData = "";
		StringBuffer xmlString = new StringBuffer();

		try{
			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			event = (Event) request.getAttribute("Event");
			EsdPrd0005Event e = (EsdPrd0005Event) event;
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();

			}

			if(eventResponse != null){
				List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
				strErrMsg = eventResponse.getETCData("strErrMsg");
				if(serverException == null){
					if(rsVoList != null && rsVoList.size() > 0){
						for(int i = 0; i < rsVoList.size(); i++){
							Map<String, String> colValues = rsVoList.get(i).getColumnValues();
							maxPrioSeq = Integer.parseInt(JSPUtil.getNull(colValues.get("prio_seq")).equals("") ? "0" : colValues.get("prio_seq"));


							xmlString.append("<?xml version=\"1.0\"  ?>");
							xmlString.append("<SHEET>");
							xmlString.append("<ETC-DATA>");
							xmlString.append("<ETC KEY=\"prio_seq_combo\">").append(JSPUtil.getNull(comboData)).append("</ETC>");
							xmlString.append("<ETC KEY=\"maxPrioSeq\">").append(JSPUtil.getNull(maxPrioSeq)).append("</ETC>");
							xmlString.append("<ETC KEY=\"strErrMsg\">").append(JSPUtil.getNull(strErrMsg)).append("</ETC>");
							xmlString.append("</ETC-DATA>");
							xmlString.append("<DATA>");

							xmlString.append("<TR ROW=\"").append(e.getInlandRouteMsUSVO().getISelRow()).append("\">");
							xmlString.append("<TD COL=\"ibflag\">R</TD>");

							xmlString.append("<TD COL=\"inlnd_rout_bkg_flg\"><![CDATA[").append(JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg"))).append("]]></TD>");
							xmlString.append("<TD COL=\"ori_loc\"><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc"))).append("]]></TD>");
							xmlString.append("<TD COL=\"ori_loc_type\"><![CDATA[").append(JSPUtil.getNull(colValues.get("org_loc_type"))).append(">]]></TD>");
							xmlString.append("<TD COL=\"dest_loc\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc"))).append("]]></TD>");
							xmlString.append("<TD COL=\"dest_loc_type\"><![CDATA[").append(JSPUtil.getNull(colValues.get("dest_loc_type"))).append("]]></TD>");
							xmlString.append("<TD COL=\"route\"><![CDATA[").append(JSPUtil.getNull(colValues.get("route"))).append("]]></TD>");

							xmlString.append("<TD COL=\"prio_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("prio_seq"))).append("]]></TD>");

							xmlString.append("<TD COL=\"tot_tt\"><![CDATA[").append(JSPUtil.getNull(colValues.get("tot_tt"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rout_org_nod_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_org_nod_cd"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rout_dest_nod_cd\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_dest_nod_cd"))).append("]]></TD>");
							xmlString.append("<TD COL=\"rout_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("rout_seq"))).append("]]></TD>");
							xmlString.append("<TD COL=\"hub_search_gb\"><![CDATA[").append(JSPUtil.getNull(colValues.get("hub_search_gb"))).append("]]></TD>");
							xmlString.append("<TD COL=\"front_gb\"><![CDATA[").append(JSPUtil.getNull(colValues.get("front_gb"))).append("]]></TD>");
							xmlString.append("<TD COL=\"undefine_nod\"><![CDATA[").append(JSPUtil.getNull(colValues.get("undefine_nod"))).append("]]></TD>");
							xmlString.append("<TD COL=\"group_gubun\">1</TD>");
							xmlString.append("<TD COL=\"ori_prio_seq\"><![CDATA[").append(JSPUtil.getNull(colValues.get("prio_seq"))).append("]]></TD>");
							xmlString.append("</TR>");



						}

					}else{
						xmlString.append("<?xml version=\"1.0\"  ?>");
						xmlString.append("<SHEET>");
						xmlString.append("<ETC-DATA>");
						xmlString.append("<ETC KEY=\"prio_seq_combo\"><![CDATA[").append(JSPUtil.getNull(comboData)).append("]]></ETC>");
						xmlString.append("<ETC KEY=\"maxPrioSeq\"><![CDATA[").append(JSPUtil.getNull(maxPrioSeq)).append("]]></ETC>");
						xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[").append(JSPUtil.getNull(strErrMsg)).append("]]></ETC>");
						xmlString.append("</ETC-DATA>");
						xmlString.append("<DATA>");
						xmlString.append("<TR ROW=\"").append(e.getInlandRouteMsUSVO().getISelRow()).append("\">");
						xmlString.append("<TD COL=\"vndr_seq\"></TD>");
						xmlString.append("<TD COL=\"tztm_hrs\"></TD>");
						xmlString.append("<TD COL=\"lnk_dist\"></TD>");
						xmlString.append("<TD COL=\"dist_ut_cd\"></TD>");
						xmlString.append("<TD COL=\"rail_crr_tp_cd\"></TD>");
						xmlString.append("</TR>");

					}
					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");
				}else{

					xmlString.append("<?xml version=\"1.0\"  ?>");
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"prio_seq_combo\"><![CDATA[").append(JSPUtil.getNull(comboData)).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"maxPrioSeq\"><![CDATA[").append(JSPUtil.getNull(maxPrioSeq)).append("]]></ETC>");
					xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[").append(JSPUtil.getNull(strErrMsg)).append("]]></ETC>");
					xmlString.append("</ETC-DATA>");
					xmlString.append("<DATA>");
					xmlString.append("<TR ROW=\"0\">");
					xmlString.append("<TD COL=\"ibflag\"></TD>");
					xmlString.append("<TD COL=\"inlnd_rout_bkg_flg\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"ori_loc\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"ori_loc_type\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"dest_loc\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"dest_loc_type\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"route\"><![CDATA[]]></TD>");

					xmlString.append("<TD COL=\"prio_seq\"><![CDATA[]]></TD>");

					xmlString.append("<TD COL=\"tot_tt\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"rout_org_nod_cd\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"rout_dest_nod_cd\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"rout_seq\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"hub_search_gb\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"front_gb\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"undefine_nod\"><![CDATA[]]></TD>");
					xmlString.append("<TD COL=\"group_gubun\"></TD>");
					xmlString.append("<TD COL=\"ori_prio_seq\"><![CDATA[]]></TD>");
					xmlString.append("</TR>");
					xmlString.append("</DATA>");

					xmlString.append("</SHEET>");
				}

			}else{
				xmlString.append("<?xml version=\"1.0\"  ?>");
				xmlString.append("<SHEET>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"prio_seq_combo\"><![CDATA[]]></ETC>");
				xmlString.append("<ETC KEY=\"maxPrioSeq\"><![CDATA[]]></ETC>");
				xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[").append(strErrMsg).append("]]></ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("<DATA>");
				xmlString.append("</DATA>");
				xmlString.append("</SHEET>");
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
