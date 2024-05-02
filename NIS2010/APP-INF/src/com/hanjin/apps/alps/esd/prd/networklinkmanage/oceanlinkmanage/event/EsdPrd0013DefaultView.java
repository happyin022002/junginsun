/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsdPrd0013DefaultView.java
 *@FileTitle : EsdPrd0013DefaultView
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009/07/29
 *@LastModifier : waiterj
 *@LastVersion : 1.0
 * 2009/07/29 waiterj
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event;

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
* @author 9009630
* @see
* @since J2EE 1.4
*/
public class EsdPrd0013DefaultView extends ViewAdapter{

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
//			EsdPrd0013Event e = (EsdPrd0013Event) event;
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if(serverException != null){
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			if(eventResponse != null){
				if(event.getFormCommand().isCommand(FormCommand.SEARCH) || event.getFormCommand().isCommand(FormCommand.MULTI)){
					List<AbstractValueObject> rsVoList = eventResponse.getRsVoList();
					xmlString.append("<SHEET>");
					xmlString.append("<DATA TOTAL='");
					xmlString.append(rsVoList.size());
					xmlString.append("'>");

					for(int i = 0; i < rsVoList.size(); i++){
						Map<String, String> colValues = rsVoList.get(i).getColumnValues();
						String vsl_slan_cd = JSPUtil.getNull(colValues.get("vsl_slan_cd"));
						String lnk_org_loc_cd = JSPUtil.getNull(colValues.get("fromloc"));
						String lnk_dest_loc_cd = JSPUtil.getNull(colValues.get("toloc"));
						String tztm_hrs = JSPUtil.getNull(colValues.get("tztm_hrs"));
						String fdr_freq_knt = JSPUtil.getNull(colValues.get("fdr_freq_knt"));
						String pctl_io_bnd_cd = JSPUtil.getNull(colValues.get("pctl_io_bnd_cd"));
						String dir_cd = JSPUtil.getNull(colValues.get("skd_dir_cd"));
						String vndr_seq = JSPUtil.getNull(colValues.get("vndr_seq"));
						String vndr_nm = JSPUtil.getNull(colValues.get("vndrnm"));
						String sun_flg = JSPUtil.getNull(colValues.get("sun_st_flg"));
						String mon_flg = JSPUtil.getNull(colValues.get("mon_st_flg"));
						String tue_flg = JSPUtil.getNull(colValues.get("tue_st_flg"));
						String wed_flg = JSPUtil.getNull(colValues.get("wed_st_flg"));
						String thu_flg = JSPUtil.getNull(colValues.get("thu_st_flg"));
						String fri_flg = JSPUtil.getNull(colValues.get("fri_st_flg"));
						String sat_flg = JSPUtil.getNull(colValues.get("sat_st_flg"));
						xmlString.append("<TR>");
						xmlString.append("<TD>R</TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD></TD>");
						xmlString.append("<TD><![CDATA[" + vsl_slan_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + lnk_org_loc_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + lnk_dest_loc_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + tztm_hrs + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + fdr_freq_knt + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + pctl_io_bnd_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + dir_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + vndr_seq + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + vndr_nm + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + sun_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + mon_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + tue_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + wed_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + thu_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + fri_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + sat_flg + "]]></TD>");

						xmlString.append("<TD><![CDATA[" + vsl_slan_cd + "]]></TD>"); //HIDDEN
						xmlString.append("<TD><![CDATA[" + lnk_org_loc_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + lnk_dest_loc_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + tztm_hrs + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + fdr_freq_knt + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + pctl_io_bnd_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + dir_cd + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + vndr_seq + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + vndr_nm + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + sun_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + mon_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + tue_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + wed_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + thu_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + fri_flg + "]]></TD>");
						xmlString.append("<TD><![CDATA[" + sat_flg + "]]></TD>");
						xmlString.append("<TD></TD>");
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
		return xmlString.toString();
	}
}
