<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0214.jsp
*@FileTitle  : Invoice Summary Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0214Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopPso0214Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_Ofc_cd = "";

	String strPortCd = "";
//	String strCsrNo = "";
//	String strInvNo = "";
//	String strStatus = "";
	String strVvd = "";
	String strAcctCd = "";
	String strVndrSeq = "";
	String strIssCtyCd = "";
	String strSoSeq = "";
	String strCostCd = "";

	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();

		event = (VopPso0214Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strPortCd 	= StringUtil.xssFilter(request.getParameter("port_cd"));
		strVvd  	= StringUtil.xssFilter(request.getParameter("vvd"));
		strAcctCd  	= StringUtil.xssFilter(request.getParameter("acct_cd"));
		strVndrSeq  = StringUtil.xssFilter(request.getParameter("vndr_seq"));
		strIssCtyCd = StringUtil.xssFilter(request.getParameter("iss_cty_cd"));
		strSoSeq  	= StringUtil.xssFilter(request.getParameter("so_seq"));
		strCostCd 	= StringUtil.xssFilter(request.getParameter("cost_cd"));

	} catch (Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iss_cty_cd" value="<%=strIssCtyCd%>" id="iss_cty_cd" />
<input type="hidden" name="so_seq" value="<%=strSoSeq%>" id="so_seq" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Invoice Summary Detail</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80" />
					<col width="80" />
					<col width="40" />
					<col width="160" />
					<col width="70" />
					<col width="100" />
					<col width="70" />
					<col width="100" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Terminal Code</th>
						<td><input name="port_cd" type="text" style="width: 70px; margin-left: -2px; text-align: center;" class="input2" value="<%=strPortCd%>" readonly id="port_cd" /> </td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input name="vvd" type="text" style="width: 150px; margin-left: -2px; text-align: center;" class="input2" value="<%=strVvd%>" readonly id="vvd" /> </td>
						<th>Account Code</th>
						<td><input name="acct_cd" type="text" style="width: 100px; margin-left: -2px; text-align: center;" class="input2" value="<%=strAcctCd%>" readonly id="acct_cd" /> </td>
						<th>Cost Code</th>
						<td><input name="cost_cd" type="text" style="width: 100px; margin-left: -2px; text-align: center;" class="input2" value="<%=strCostCd%>" readonly id="cost_cd" /> </td>
						<th>S/P No.</th>
						<td><input name="vndr_seq" type="text" style="width: 155px; margin-left: -2px; text-align: center;" class="input2" value="<%=strVndrSeq%>" readonly id="vndr_seq" /> </td></tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
 </form>