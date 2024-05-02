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
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event"%>
<%@ page import="com.clt.framework.core.layer.event.EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>

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
%>
<TABLE>
<%
	while(rowSet!=null&&rowSet.next()){
		i++;
%>
	<tr>
		<td><%=i%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("bkg_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("bl_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("unmatch_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("bkg_pod_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("bkg_del_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cop_pod_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cop_del_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cntr_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("tpsz"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("mvmt_sts"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("mvmt_yd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("mvmt_dt"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dup_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("vvd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("lane"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("eta"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("spe"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("rail_dest"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cstms_loc_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("eq_ctrl_ofc_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("term"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("add_trsp"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("rl_so_pln_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("rl_so_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("rl_wo_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("ts_so_pln_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("ts_so_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("ts_wo_flg"))%></td>
		<%--<td><%=JSPUtil.getNull(rowSet.getString("tc_so_pln_flg"))</td>--%>
		<%--<td><%=JSPUtil.getNull(rowSet.getString("tc_so_flg"))%></td>--%>
		<%--<td><%=JSPUtil.getNull(rowSet.getString("tc_wo_flg"))%></td>--%>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_so_pln_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_so_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_wo_flg"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_wo_dt"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_fm"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_to"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_sp"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dr_sp_nm"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cop_sts_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("frm"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("guide"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("pkup_yd_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("pkup_aval_dt"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("pkup_free_dt"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("f"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("o"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("c"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("dspo_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("pkup_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("pkup_ofc_cd"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("pkup_end"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("sc_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cnee_nm"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cnee_addr"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("shpr_nm"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("shpr_addr"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("ntfy_nm"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("ntfy_addr"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("filer"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("it_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("it_date"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("po_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("seal_no"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("cntr_wgt"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("clm_crnt_sts"))%></td> 
		<td><%=JSPUtil.getNull(rowSet.getString("clm_loc"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("clm_state"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("clm_dt"))%></td>
		<td><%=JSPUtil.getNull(rowSet.getString("bkg_cntr_rmk"))%></td>
	</tr>
<%  } %>

