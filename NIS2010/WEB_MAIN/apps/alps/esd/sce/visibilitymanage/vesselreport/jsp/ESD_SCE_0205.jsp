<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0205.jsp
*@FileTitle : US INLAND REPORT
*Open Issues : 
*Change history :
*@LastModifyDate : 2010-03-01
*@LastModifier : yongincho  
*@LastVersion : 1.0
* 2010-03-01 yongincho 
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>


	


<% 
response.setContentType("application/x-msdownload");
response.setHeader("Content-Disposition", "attachment;filename=aaa.xls;");
%>


<style>
<!--table
	{mso-displayed-decimal-separator:"\.";
	mso-displayed-thousand-separator:"\,";}
@page
	{margin:1.0in .75in 1.0in .75in;
	mso-header-margin:.5in;
	mso-footer-margin:.5in;}
tr
	{mso-height-source:auto;
	mso-ruby-visibility:none;}
col
	{mso-width-source:auto;
	mso-ruby-visibility:none;}
br
	{mso-data-placement:same-cell;}
.style0
	{mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	white-space:nowrap;
	mso-rotate:0;
	mso-background-source:auto;
	mso-pattern:auto;
	color:windowtext;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	border:none;
	mso-protection:locked visible;
	mso-style-name:표준;
	mso-style-id:0;}
td
	{mso-style-parent:style0;
	padding-top:1px;
	padding-right:1px;
	padding-left:1px;
	mso-ignore:padding;
	color:windowtext;
	font-size:11.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	mso-number-format:General;
	text-align:general;
	vertical-align:middle;
	border:none;
	mso-background-source:auto;
	mso-pattern:auto;
	mso-protection:locked visible;
	white-space:nowrap;
	mso-rotate:0;}
.xl24
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	border:.0pt solid windowtext;
	background:white;
	mso-pattern:auto none;}
.xl25
	{mso-style-parent:style0;
	mso-number-format:"\@";
	text-align:center;
	border:.5pt solid windowtext;
	background:silver;
	mso-pattern:auto none;
	white-space:normal;}
.xl26
	{mso-style-parent:style0;
	mso-number-format:"\@";
}
.xl27
	{mso-style-parent:style0;
	mso-number-format:"\#\,\#\#0\.00_ ";
	border:.5pt solid windowtext;}
.xl28
	{mso-style-parent:style0;
	mso-number-format:General;
}
ruby
	{ruby-align:left;}
rt
	{color:windowtext;
	font-size:8.0pt;
	font-weight:400;
	font-style:normal;
	text-decoration:none;
	font-family:돋움, monospace;
	mso-font-charset:129;
	mso-char-type:none;
	display:none;}
-->
</style>








<%

	EsdSce0056Event event = null;
	EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //서버에서 발생한 에러
	DBRowSet rowSet = null;							   //DB ResultSet
	String strErrMsg = "";								//에러메세지
	int rowCount	 = 0;								 //DB ResultSet 리스트의 건수




	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	

		}else{
			event = (EsdSce0056Event)request.getAttribute("Event");
			eventResponse = (EventResponse)request.getAttribute("EventResponse");

			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	StringBuffer aa = new StringBuffer();
	int i=0; 




	


   aa.append("<TABLE>");


 

out.print(aa.toString());


   while(rowSet.next()){
   i++;

	aa = new StringBuffer();

    aa.append("<tr>");


     aa.append("<td>"+i+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_no")+"</td>");
     aa.append("<td>"+rowSet.getString("bl_no")+"</td>");
     aa.append("<td>"+rowSet.getString("unmatch_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_pod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_del_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("cop_pod_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("cop_del_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("cntr_no")+"</td>");
     aa.append("<td>"+rowSet.getString("tpsz")+"</td>");
     aa.append("<td>"+rowSet.getString("mvmt_sts")+"</td>");
     aa.append("<td>"+rowSet.getString("mvmt_yd")+"</td>");
     aa.append("<td>"+rowSet.getString("mvmt_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("dup_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("vvd")+"</td>");
     aa.append("<td>"+rowSet.getString("lane")+"</td>");
     aa.append("<td>"+rowSet.getString("eta")+"</td>");
     aa.append("<td>"+rowSet.getString("spe")+"</td>");
     aa.append("<td>"+rowSet.getString("rail_dest")+"</td>");
     aa.append("<td>"+rowSet.getString("cstms_loc_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("eq_ctrl_ofc_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("term")+"</td>");
     aa.append("<td>"+rowSet.getString("add_trsp")+"</td>");
     aa.append("<td>"+rowSet.getString("rl_so_pln_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("rl_so_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("rl_wo_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("ts_so_pln_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("ts_so_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("ts_wo_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("tc_so_pln_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("tc_so_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("tc_wo_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_so_pln_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_so_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_wo_flg")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_wo_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_fm")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_to")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_sp")+"</td>");
     aa.append("<td>"+rowSet.getString("dr_sp_nm")+"</td>");
     aa.append("<td>"+rowSet.getString("cop_sts_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("from")+"</td>");
     aa.append("<td>"+rowSet.getString("guide")+"</td>");
     aa.append("<td>"+rowSet.getString("pkup_yd_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("pkup_aval_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("pkup_free_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("f")+"</td>");
     aa.append("<td>"+rowSet.getString("o")+"</td>");
     aa.append("<td>"+rowSet.getString("c")+"</td>");
     aa.append("<td>"+rowSet.getString("dspo_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("pkup_no")+"</td>");
     aa.append("<td>"+rowSet.getString("pkup_ofc_cd")+"</td>");
     aa.append("<td>"+rowSet.getString("pkup_end")+"</td>");
     aa.append("<td>"+rowSet.getString("sc_no")+"</td>");
     aa.append("<td>"+rowSet.getString("cnee_nm")+"</td>");
     aa.append("<td>"+rowSet.getString("cnee_addr")+"</td>");
     aa.append("<td>"+rowSet.getString("shpr_nm")+"</td>");
     aa.append("<td>"+rowSet.getString("shpr_addr")+"</td>");
     aa.append("<td>"+rowSet.getString("ntfy_nm")+"</td>");
     aa.append("<td>"+rowSet.getString("ntfy_addr")+"</td>");
     aa.append("<td>"+rowSet.getString("filer")+"</td>");
     aa.append("<td>"+rowSet.getString("it_no")+"</td>");
     aa.append("<td>"+rowSet.getString("it_date")+"</td>");
     aa.append("<td>"+rowSet.getString("po_no")+"</td>");
     aa.append("<td>"+rowSet.getString("seal_no")+"</td>");
     aa.append("<td>"+rowSet.getString("cntr_wgt")+"</td>");
     aa.append("<td>"+rowSet.getString("clm_crnt_sts")+"</td>"); 
     aa.append("<td>"+rowSet.getString("clm_loc")+"</td>");
     aa.append("<td>"+rowSet.getString("clm_state")+"</td>");
     aa.append("<td>"+rowSet.getString("clm_dt")+"</td>");
     aa.append("<td>"+rowSet.getString("bkg_cntr_rmk")+"</td>");
     
    aa.append("</tr>");

out.print(aa.toString());


   }

   
   out.print("</TABLE>");



%> 

