<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_2069
*@FileTitle  : TDR Details
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
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
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf2069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf2069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String rhq = request.getParameter("rhq");
	String port = request.getParameter("port");
	String yard = request.getParameter("yard");
	String lane = request.getParameter("lane");
	String group_by = request.getParameter("group_by");
	String from_date = request.getParameter("from_date");
	String to_date = request.getParameter("to_date");
	String tml_prod_rpt_rsn_cd = request.getParameter("tml_prod_rpt_rsn_cd");
	String carr_cd = request.getParameter("carr_cd");
	String target_lanes = request.getParameter("target_lanes");
	String target_ports = request.getParameter("target_ports");

	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf2069Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer Performance	-->
<input type="hidden" name="rhq" value="<%=StringUtil.xssFilter(rhq)%>">
<input type="hidden" name="loc_cd" value="<%=StringUtil.xssFilter(port)%>">
<input type="hidden" name="yd_cd" value="<%=StringUtil.xssFilter(yard)%>">
<input type="hidden" name="slan_cd" value="<%=StringUtil.xssFilter(lane)%>">
<input type="hidden" name="group_by" value="<%=StringUtil.xssFilter(group_by)%>">
<input type="hidden" name="from_date" value="<%=StringUtil.xssFilter(from_date)%>">
<input type="hidden" name="to_date" value="<%=StringUtil.xssFilter(to_date)%>">
<input type="hidden" name="tml_prod_rpt_rsn_cd" value="<%=StringUtil.xssFilter(tml_prod_rpt_rsn_cd)%>">
<input type="hidden" name="carr_cd" value="<%=StringUtil.xssFilter(carr_cd)%>">
<input type="hidden" name="target_lanes" value="<%=StringUtil.xssFilter(target_lanes)%>">
<input type="hidden" name="target_ports" value="<%=StringUtil.xssFilter(target_ports)%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TDR Details</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Excel" id="btn_Excel">DownExcel</button><!--
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>	
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>