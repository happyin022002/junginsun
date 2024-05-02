<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_PSO_0211.jsp
*@FileTitle  : Tariff Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
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
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0211Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopPso0211Event event = null; //PDTO(Data Transfer Object including Parameters)
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
	String strYardCd = "";
	String strAcctCd = "";
	String strAcctNm = "";
	String strCostCd = "";
	String strCostNm = "";
	String strVndrSeq = "";
	String strVndrNm = "";

	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");

	String sType 	= StringUtil.xssFilter(request.getParameter("type")) == null 	? "B" 		: StringUtil.xssFilter(request.getParameter("type"));
	//String caller 	= StringUtil.xssFilter(request.getParameter("caller")) == null  ? "POPUP" 	: StringUtil.xssFilter(request.getParameter("caller")); //POPUP, IFRAME

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();

		event = (VopPso0211Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		strPortCd 	= StringUtil.xssFilter(request.getParameter("port_cd"));
		strYardCd 	= StringUtil.xssFilter(request.getParameter("yd_cd"));
		strAcctCd 	= StringUtil.xssFilter(request.getParameter("acct_cd"));
		strAcctNm 	= StringUtil.xssFilter(request.getParameter("acct_nm"));
		strCostCd 	= StringUtil.xssFilter(request.getParameter("cost_cd"));
		strCostNm 	= StringUtil.xssFilter(request.getParameter("cost_nm"));
		strVndrSeq 	= StringUtil.xssFilter(request.getParameter("vndr_seq"));
		strVndrNm 	= StringUtil.xssFilter(request.getParameter("vndr_nm"));

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="types" value="<%=sType%>"> 
<input	type="hidden" name="sXml"> 
<input type="hidden" id="ydCd" name="ydCd" value="<%=strYardCd%>"> 
<input type="hidden" id="yd_chg_no" name="yd_chg_no" value=""> 
<input type="hidden" id="param_acct_cd" name="param_acct_cd"	value="<%=strAcctCd%>"> 
<input type="hidden" id="param_acct_nm" name="param_acct_nm"	value="<%=strAcctNm%>"> 
<input type="hidden" id="cost_cd" name="cost_cd"	value="<%=strCostCd%>"> 
<input type="hidden" id="cost_nm" name="cost_nm"	value="<%=strCostNm%>"> 
<%--<input type="hidden" id="caller" name="caller"	value="<%=caller%>">--%>
<input type="hidden" id="yd_cd" name="yd_cd">	
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Copy From</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="60px">Terminal</th>
						<td width="120px" style="padding-left:3px"><!-- 
						  --><input id="port_cd" name="port_cd" type="text" style="width: 67px; margin-left: -2px; text-align: center;" class="input" value="<%=strPortCd%>" dataformat="engup"><!-- 
						  --><script language="javascript">ComComboObject('com_yd_cd',2, 50, 0);</script></td>
						<th width="110px">Service Provider</th>
						<td width=""><script language="javascript">ComComboObject('com_vendor',2, 152, 1);</script><!-- 
						 --><input type="text" id="vndr_seq" name="vndr_seq" value="<%=strVndrSeq%>" style="width: 100px; display:none;" class="input2" readonly><!-- 
						 --><input type="text" id="vndr_nm" name="vndr_nm" value="<%=strVndrNm%>" style="width: 50%;" class="input2" readonly></td>
					</tr>
					<tr>
						<th>Year</th>
						<td style="padding-left:3px"><input id="year" name="year" dataformat="yyyy" type="text" style="width: 120px; margin-left: -2px; text-align: center;" class="input1" value="" maxlength="4"></td>
						<th id="acct_or_cost_caption">Account Code</th>
						<td><script language="javascript">ComComboObject('acct_or_cost_cd',2, 102, 0, 0);</script>&nbsp;<input type="text" id="acct_or_cost_nm" name="acct_or_cost_nm" style="width: 250px; text-align: left" class="input2" value="" readonly></td>
					</tr>
					<tr>
						<th>Version</th>
						<td><script language="javascript">ComComboObject('ver',2, 120, 1);</script></td>
						<th>Effective Date</th>
						<td><input type="text" id="eff_date" name="eff_date" style="width: 150px;" class="input2" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
						<td width="100px"><input type="checkbox" id="cBase" name="cBase" value="" class="trans" checked disabled>&nbsp;Base</td>
						<td width="130px"><input type="checkbox" id="cSur" name="cSur" value="" class="trans" disabled>&nbsp;Surcharge</td>
						<td width="*"><input type="checkbox" id="cDis" name="cDis" value="" class="trans" disabled>&nbsp;Discount</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div id="div_base" class="opus_design_inquiry">
			<table> 
				<tbody>
					<tr>
						<td style="width:100%;"><h3 class="title_design">Base</h3></td>
						<td>Compulsory&nbsp;&nbsp;<input type="checkbox" name="cpls_flg" value="" class="trans" disabled></td>
					</tr>
				</tbody>
			</table>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<div id="div_surcharge" class="opus_design_inquiry" style="display: none;">
			<table> 
				<tbody>
					<tr>
						<td><h3 class="title_design">Surcharge</h3></td>
					</tr>
				</tbody>
			</table>
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
		<div id="div_discount" class="opus_design_inquiry" style="display: none;">
			<table> 
				<tbody>
					<tr>
						<td><h3 class="title_design">Discount</h3></td>
					</tr>
				</tbody>
			</table>
			<script language="javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>

</form>

