/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0056MstRowView.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.03.03
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.03 김귀진
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
public class EsdPrd0056MstRowView extends ViewAdapter{

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
		StringBuffer xmlString = new StringBuffer();

		try{
			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			event = (Event) request.getAttribute("Event");
			EsdPrd0056Event e = (EsdPrd0056Event) event;
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){
				List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
				strErrMsg = JSPUtil.getNull(eventResponse.getETCData("strErrMsg"));


				if(rsVoList != null && rsVoList.size() > 0){
					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						maxPrioSeq = Integer.parseInt(JSPUtil.getNull(colValues.get("prio_seq")).equals("") ? "0" : colValues.get("prio_seq"));

						String wrs_mty_cmdt_cd = JSPUtil.getNull(colValues.get("wrs_mty_cmdt_cd")).equals("MN") ? "Y" : "";

						xmlString.append("<?xml version=\"1.0\"?>");
						xmlString.append("<SHEET>");
						xmlString.append("<ETC-DATA>");
						xmlString.append("<ETC KEY=\"maxPrioSeq\">" + maxPrioSeq + "</ETC>");
						xmlString.append("<ETC KEY=\"strErrMsg\">" + strErrMsg + "</ETC>");
						xmlString.append("</ETC-DATA>");
						xmlString.append("<DATA>");
						xmlString.append("<TR ROW=\"" + e.getSearchConditionVO().getISelrow() + "\">");
						xmlString.append("<TD COL=\"wrs_chk\"><![CDATA[" + wrs_mty_cmdt_cd + "]]></TD>");
						xmlString.append("<TD COL=\"ibflag\"></TD>");

						xmlString.append("<TD COL=\"ori_loc\"><![CDATA[" + JSPUtil.getNull(colValues.get("org_loc")) + "]]></TD>");
						xmlString.append("<TD COL=\"ori_loc_type\"><![CDATA[" + JSPUtil.getNull(colValues.get("org_loc_type")) + "]]></TD>");
						xmlString.append("<TD COL=\"dest_loc\"><![CDATA[" + JSPUtil.getNull(colValues.get("dest_loc")) + "]]></TD>");
						xmlString.append("<TD COL=\"dest_loc_type\"><![CDATA[" + JSPUtil.getNull(colValues.get("dest_loc_type")) + "]]></TD>");
						xmlString.append("<TD COL=\"inv_bl_pt\"><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_inv_bil_patt_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"rout_pl\"><![CDATA[" + JSPUtil.getNull(colValues.get("rout_pln_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"c_tofc\"><![CDATA[" + JSPUtil.getNull(colValues.get("rail_crr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"junc\"><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_junc_nm")) + "]]></TD>");
						xmlString.append("<TD COL=\"cre_id\"><![CDATA[" + JSPUtil.getNull(colValues.get("cre_usr_id")) + "]]></TD>");
						xmlString.append("<TD COL=\"cre_ofc\"><![CDATA[" + JSPUtil.getNull(colValues.get("cre_ofc_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"cre_date\"><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD COL=\"constraint\"><![CDATA[]]></TD>");
						xmlString.append("<TD COL=\"remark\"><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_rmk")) + "]]></TD>");


						xmlString.append("<TD COL=\"rout_org_nod_cd\"><![CDATA[" + JSPUtil.getNull(colValues.get("rout_org_nod_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"rout_dest_nod_cd\"><![CDATA[" + JSPUtil.getNull(colValues.get("rout_dest_nod_cd")) + "]]></TD>");
						xmlString.append("<TD COL=\"rout_seq\"><![CDATA[" + JSPUtil.getNull(colValues.get("rout_seq")) + "]]></TD>");
						xmlString.append("</TR>");



					}
				}else{
					xmlString.append("<?xml version=\"1.0\"?>");
					xmlString.append("<SHEET>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"maxPrioSeq\">" + maxPrioSeq + "</ETC>");
					xmlString.append("<ETC KEY=\"strErrMsg\">" + strErrMsg + "</ETC>");
					xmlString.append("</ETC-DATA>");
					xmlString.append("<DATA>");
					xmlString.append("<TR ROW=\"" + e.getSearchConditionVO().getISelrow() + "\">");
					xmlString.append("<TD COL=\"vndr_seq\"></TD>");
					xmlString.append("<TD COL=\"lnk_dist\"></TD>");
					xmlString.append("<TD COL=\"rail_crr_tp_cd\"></TD>");
					xmlString.append("</TR>");

				}

				xmlString.append("</DATA>");
				xmlString.append("</SHEET>");

			}else{

				xmlString.append("<ERROR>");
				xmlString.append("<ETC-DATA>");
				xmlString.append("<ETC KEY=\"strErrMsg\"><![CDATA[" + strErrMsg + "]]></ETC>");
				xmlString.append("</ETC-DATA>");
				xmlString.append("<MESSAGE> <![CDATA[");
				xmlString.append(strErrMsg);
				xmlString.append("]]></MESSAGE>");
				xmlString.append("</ERROR>");


			}



		}catch(Exception ex){
			log.error("★여기들어왔나?" + ex.getMessage(), ex);
			strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), false);
			xmlString.append(strXML);
		}
		log.debug("★★:XML=====" + xmlString.toString());
		return xmlString.toString();


	}
}
