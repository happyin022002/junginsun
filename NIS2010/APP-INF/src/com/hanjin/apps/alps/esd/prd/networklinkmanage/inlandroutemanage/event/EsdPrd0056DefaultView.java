/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0056DefaultView.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.03.03
 *@LastModifier : 김귀진
 *@LastVersion : 1.0
 * 2009.08.03 김귀진
 * 1.0 Creation
 * 2012.10.17 김진승 [CHM-201220713][PRD] O5 CNTR 추가로 인한 PRD 상 변경사항
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
import com.hanjin.framework.support.controller.html.FormCommand;

/**
*
* @author 9009630 2009/07/29 수정
* @see
* @since J2EE 1.4
*/
public class EsdPrd0056DefaultView extends ViewAdapter{

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
			EsdPrd0056Event e = (EsdPrd0056Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){
				if(event.getFormCommand().isCommand(FormCommand.MULTI)){	//저장XML인 경우
					xmlString.append("<RESULT><TR-ALL>OK</TR-ALL></RESULT>");
				}else if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST)){	//조회XML인 경우



					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						xmlString.append("<TR>");
						if(e.getSearchConditionVO().getIDelFlg().equals("Y")){
							xmlString.append("<TD EDIT=\"FALSE\"></TD>");
						}else{
							xmlString.append("<TD></TD>");
						}

						String wrs_mty_cmdt_cd = JSPUtil.getNull(colValues.get("wrs_mty_cmdt_cd")).equals("MN") ? "Y" : "";
						String editable = JSPUtil.getNull(colValues.get("wrs_mty_cmdt_cd")).equals("MN") ? "TRUE" : "FALSE";
						xmlString.append("<TD><![CDATA[" + wrs_mty_cmdt_cd + "]]></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("org_loc")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("org_loc_type")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dest_loc")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dest_loc_type")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_inv_bil_patt_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_pln_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rail_crr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_junc_nm")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_usr_id")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("cre_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_usr_id")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_usr_id")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_dt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[ ]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_rmk")) + "]]></TD>");

						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("d2_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("d4_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("d5_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("d7_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("o2_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("o4_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("o5_flg")) + "]]></TD>"); // added in 2012.10.17
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("a2_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("a4_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("a5_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("r2_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("r5_flg")) + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("r8_flg")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_org_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_dest_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_seq")) + "]]></TD>");
						xmlString.append("</TR>");
					}


					xmlString.append("</DATA>");
					xmlString.append("<RESULT>");
					xmlString.append("<TR-ALL>OK</TR-ALL>");
					xmlString.append("<Message><![CDATA[ OK]]> </Message>");
					xmlString.append("</RESULT>");
					xmlString.append("</SHEET>");

				}else if(event.getFormCommand().isCommand(FormCommand.SEARCH)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");


					String i_inv = "";
					String i_rout_pln_cd = "";
					String i_mcntr_rout_flg = "";
					String i_route_rmk = "";
					String i_wrs_fl_cd = "";
					String i_wrs_mt_cd = "";
					String i_bkg_flg = "";
					String wrs_chk = "";


					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						String inlnd_rout_cmb_flg = JSPUtil.getNull(colValues.get("inlnd_rout_cmb_flg"));
						String editable = JSPUtil.getNull(colValues.get("fc")).equals("T") ? "TRUE" : "FALSE";

						if(i == 0){
							i_inv = JSPUtil.getNull(colValues.get("inlnd_rout_inv_bil_patt_cd"));
							i_rout_pln_cd = JSPUtil.getNull(colValues.get("rout_pln_cd"));

							i_mcntr_rout_flg = JSPUtil.getNull(colValues.get("mcntr_rout_flg")).equals("Y") ? JSPUtil.getNull(colValues.get("mcntr_rout_flg")) : "";
							i_wrs_fl_cd = JSPUtil.getNull(colValues.get("wrs_full_cmdt_cd"));
							i_wrs_mt_cd = JSPUtil.getNull(colValues.get("wrs_mty_cmdt_cd"));

							wrs_chk = JSPUtil.getNull(colValues.get("wrs_mty_cmdt_cd")).equals("MN") ? "Y" : "";

							i_bkg_flg = JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg")).equals("Y") ? JSPUtil.getNull(colValues.get("inlnd_rout_bkg_flg")) : "";
							i_route_rmk = JSPUtil.getNull(colValues.get("inlnd_rout_rmk"));
						}





						xmlString.append("<TR>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_org_loc")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_org_type")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_dest_loc")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_dest_type")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("trsp_mod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("vndr_seq")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("vndr_abbr_nm")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tztm_hrs")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("agmt_no")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("agmt_ref_no")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + inlnd_rout_cmb_flg + "]]></TD>");
						xmlString.append("<TD EDIT=\"" + editable + "\"><![CDATA[" + JSPUtil.getNull(colValues.get("rail_crr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_junc_nm")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_org_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lnk_dest_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("trsp_mod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_org_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_dest_nod_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_seq")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rout_dtl_seq")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(e.getInlandRouteDetVO().getISelrow()) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("vndr_seq")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("agmt_no")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + inlnd_rout_cmb_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("rail_crr_tp_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("inlnd_rout_junc_nm")) + "]]></TD>");
						xmlString.append("</TR>");



					}
					xmlString.append("</DATA>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"i_inv\"><![CDATA[" + i_inv + "]]></ETC>");
					xmlString.append("<ETC KEY=\"i_rout_pln_cd\"><![CDATA[" + i_rout_pln_cd + "]]></ETC>");
					xmlString.append("<ETC KEY=\"i_wrs_fl_cd\"><![CDATA[" + i_wrs_fl_cd + "]]></ETC>");
					xmlString.append("<ETC KEY=\"i_wrs_mt_cd\"><![CDATA[" + i_wrs_mt_cd + "]]></ETC>");
					xmlString.append("<ETC KEY=\"wrs_chk\"><![CDATA[" + wrs_chk + "]]></ETC>");
					xmlString.append("<ETC KEY=\"i_bkg_flg\"><![CDATA[" + i_bkg_flg + "]]></ETC>");
					xmlString.append("<ETC KEY=\"i_mcntr_rout_flg\"><![CDATA[" + i_mcntr_rout_flg + "]]></ETC>");
					xmlString.append("<ETC KEY=\"i_route_rmk\"><![CDATA[" + i_route_rmk + "]]></ETC>");
					xmlString.append("</ETC-DATA >");
					xmlString.append("</SHEET>");
					int size = rsVoList.size();
					for(int i = size - 1; i >= 0; i--){
						rsVoList.remove(i);
					}
				}
				else if(event.getFormCommand().isCommand(FormCommand.SEARCH01)){
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL=\"").append("0").append("\">");
					xmlString.append("</DATA>");
					xmlString.append("<ETC-DATA>");
					xmlString.append("<ETC KEY=\"cnt_cd\"><![CDATA[").append(JSPUtil.getNull(eventResponse.getETCData("cnt_cd"))).append("]]></ETC>");
					xmlString.append("</ETC-DATA >");
					xmlString.append("</SHEET>");
				}



			}else{
				xmlString.append("<ERROR>");
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
