<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0037.jsp
*@FileTitle  : Excludefrom TPR Save
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>

<%
	VopOpf0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strOpenerReson	= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	String vsl_cd			=	request.getParameter("vsl_cd");
	String skd_voy_no		=	request.getParameter("skd_voy_no");
	String skd_dir_cd		=	request.getParameter("skd_dir_cd");
	String clpt_ind_seq		=	request.getParameter("clpt_ind_seq");
	String port_cd			=	request.getParameter("port_cd");

	String authbtn          =   request.getParameter("authbtn")==null?"":request.getParameter("authbtn");
	String sTitle        =   "Creation";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopOpf0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        if(!authbtn.equals("")){
            sTitle = "Inquiry";
        }
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	// today date
	String strCurdate = DateTime.getFormatDate(new Date(), "yyyy-MM-dd HH:mm");
%>

<script type="text/javascript">

    function setupPage(){  

	    loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vsl_cd" value="<%=StringUtil.xssFilter(vsl_cd)%>" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" value="<%=StringUtil.xssFilter(skd_voy_no)%>" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" value="<%=StringUtil.xssFilter(skd_dir_cd)%>" id="skd_dir_cd" />
<input type="hidden" name="clpt_ind_seq" value="<%=StringUtil.xssFilter(clpt_ind_seq)%>" id="clpt_ind_seq" />
<input type="hidden" name="port_cd" value="<%=StringUtil.xssFilter(port_cd)%>" id="port_cd" />
<input type="hidden" name="status1" value="<%=StringUtil.xssFilter(authbtn)%>" id="status1" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Reason Selection for Excluding from TPR (<%=sTitle %>)</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Close" 		id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="70">
				<col width="100">
				<col width="70">
				<col width="70">
				<col width="*">				
			</colgroup>
			<tbody>
				<tr>
					<th>ID</th>
					<td><input type="text" style="width:66px;" class="input2" value=" <%=strUsr_id%>" readonly /> </td>
					<th>Office Code</th>
					<td><input type="text" style="width:66px;" class="input2" value=" <%=strOfc_cd%>" readonly /> </td>
					<th>Date</th>
					<td><input type="text" style="width:117px;" class="input2" value=" <%=strCurdate%>" readonly /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
</div>

<div class="wrap_result">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="btn_save_table">
			<button type="button" class="btn_accent" name="btn_Save" 		id="btn_Save">Save</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- opus_design_btn(E) -->		
		<table class = "grid2">
			<colgroup>
				<col width="60"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<th>Remark(s)</th>
					<td><textarea cols="" rows="5" style="resize:none;width:100%" name="tml_prod_rpt_rsn_rmk"></textarea></td>
				</tr>
			</tbody>
		</table>	
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>