/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsPrd0032DefaultView.java
 *@FileTitle : EsPrd0032DefaultView
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009/07/29
 *@LastModifier : waiterj
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
 * 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
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
public class EsPrd0032DefaultView extends ViewAdapter{

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
	 * Remark에 대한 화면 분할 처리를 한다.
	 * @param rmk
	 * @param isNote
	 * @return
	 */
	private String checkRemark( String rmk, boolean isNote ) {
		// Space Shortage|Customer Request|Port Skip|VSL Phase Out|Customs Problem|Clerical Error
		if (rmk == null || rmk.equals("")){
			return "";
		}
		
		boolean bCategorized = chkRmkCategorized(rmk);
		
		if (isNote) {
			if (bCategorized) {
				return "";
			} else {
				return rmk;
			}
		} else { // RMK
			if (bCategorized) {
				return rmk;
			} else {
				return PrdConstants.PRD_USRRMK_OTHERS;
			}
		}
	}
	
	/**
	 * Remark가 Category내에 있는지 확인
	 * @param rmk
	 * @return
	 */
	private boolean chkRmkCategorized(String rmk) {
		if (PrdConstants.PRD_USRRMK_SPACE.equals(rmk) 
				|| PrdConstants.PRD_USRRMK_CUSTOMER.equals(rmk) 
				|| PrdConstants.PRD_USRRMK_PORTSKIP.equals(rmk)
				|| PrdConstants.PRD_USRRMK_VSLOUT.equals(rmk) 
				|| PrdConstants.PRD_USRRMK_ADDCALL.equals(rmk) 
				|| PrdConstants.PRD_USRRMK_CUSTOMS.equals(rmk) 
				|| PrdConstants.PRD_USRRMK_CLERICAL.equals(rmk)) {
			return true;
		} else {
			return false;
		}
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
		boolean noteEdit = false;

		try{
			serverException = (Exception) request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
			event = (Event) request.getAttribute("Event");
//			EsdPrd0032Event e = (EsdPrd0032Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){

				if(event.getFormCommand().isCommand(FormCommand.SEARCH) || event.getFormCommand().isCommand(FormCommand.COMMAND01)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						if(JSPUtil.getNull(colValues.get("tg_exist")).equals("Y")){
							xmlString.append("<TR EDIT= 'FALSE'>");
							noteEdit = false;
						}else{
							xmlString.append("<TR EDIT= 'TRUE'>");
							if (!JSPUtil.getNull(colValues.get("rmk")).equals("") && !chkRmkCategorized(colValues.get("rmk"))) {
								noteEdit = true;
							} else {
								noteEdit = false;
							}
						}


						xmlString.append("<TD>R</TD>");

						xmlString.append("<TD></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("upd_ind_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + checkRemark(JSPUtil.getNull(colValues.get("rmk")), false) + "]]></TD>");
						xmlString.append("<TD").append(noteEdit?" EDIT='TRUE' ":"").append("><![CDATA[" + checkRemark(JSPUtil.getNull(colValues.get("rmk")), true) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("prio")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("org_loc_cd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp1")) + "]]></TD>");//aaaaa
						
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp2")) + "]]></TD>");//bbbbbbb
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp3")) + "]]></TD>");//ccccccc
						
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("lane4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("svc_tp4")) + "]]></TD>");//ccccccc
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dest_loc_cd")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tot_tt")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fmt_tot_st")) + "]]></TD>");
//						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("bkg_ind")) + "]]></TD>");
//						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("bkg_cnt")) + "]]></TD>");



						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tot_tt")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tot_st")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod1")) + "]]></TD>"); //
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod2")) + "]]></TD>"); //
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod3")) + "]]></TD>"); //
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod4")) + "]]></TD>"); //
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("dir4")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_flg4")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tt4")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st1")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st2")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("st3")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("ts_ind")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod1etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol2etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod2etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol3etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pod3etb")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("pol4etb")) + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("link_count")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("fdr_usd")) + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + JSPUtil.getNull(colValues.get("tg_exist")) + "]]></TD>");
						xmlString.append("</TR>");
					}

					xmlString.append("</DATA>");
					xmlString.append("</SHEET>");

					for(int i = rsVoList.size() - 1; i >= 0; i--){
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
		return xmlString.toString();

	}
}
