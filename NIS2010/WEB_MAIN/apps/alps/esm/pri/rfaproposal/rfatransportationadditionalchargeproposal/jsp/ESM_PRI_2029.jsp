<%@page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	/*=========================================================
	 *Copyright(c) 2012 CyberLogitec
	 *@FileName : ESM_PRI_2029.jsp
	 *@FileTitle : Tariff Route Search Pop-Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate :
	 *@LastModifier : 
	 *@LastVersion : 
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2029Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri2029Event event = null;
	Exception serverException = null;
	String strErrMsg = "";
	int rowCount = 0;

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String org_dest_tp_cd = "";
	String org_dest_tp_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFATransportationAdditionalChargeProposal");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2029Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		org_dest_tp_cd = JSPUtil.getParameter(request, "org_dest_tp_cd");
		org_dest_tp_nm = "O".equals(org_dest_tp_cd) ? "Origin" : "Destination";
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Route Search Pop-Up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="eff_dt" value="<%=JSPUtil.getParameter(request, "effDt") %>" required="required" readonly="readonly" caption="Eff Date" minlength="8" maxlength="8" >
<input type="hidden" name="org_dest_tp_cd" value="<%=org_dest_tp_cd %>" required="required" readonly="readonly" caption="Bound" minlength="1" maxlength="1" >

<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Tariff Route Search Pop-Up</td>
			</tr>
		</table>
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="">Service Scope</td>
					<td width=""><input type="text" name="svc_scp_cd" value="<%=JSPUtil.getParameter(request, "svcScpCd") %>" style="width:100;text-align:left;ime-mode:disabled" class="input1" required="required" readonly="readonly" caption="Service Scope" minlength="3" maxlength="3" onKeyPress="ComKeyOnlyAlphabet('upper')">
					</td>
					<td width="">Bound</td>
					<td width=""><input type="text" id="org_dest_tp_nm" value="<%= org_dest_tp_nm %>" style="width:100;text-align:left;ime-mode:disabled" class="input1" readonly="readonly">
					</td>
					<td width="">Point</td>
					<td width="">
						<nobr>
	                    	<input type="text" name="pnt_loc_cd" style="width:100;text-align:left;ime-mode:disabled" class="input1" required="required" caption="Point" minlength="2" onKeyPress="ComKeyOnlyAlphabet('upper','44')"  onpaste="DoPaste()"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pnt_loc_cd">
	                    </nobr>
					</td>
					<td width="">Base Port</td>
					<td width="">
						<nobr>
	                    	<input type="text" name="bse_port_loc_cd" style="width:100;text-align:left;ime-mode:disabled" class="input" caption="Base Port" minlength="5" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper')"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bse_port_loc_cd">
	                    </nobr>					
					</td>
					<td width="">SVC Type</td>
					<td width=""><script language="javascript">ComComboObject("svc_tp_cd", 1, 100, 0, 0, 0, false);</script></td>
					<td width="" colspan="2"></td>
					<!-- 
					<td width="">Country</td>
					<td width="">
						<nobr>
	                    	<input type="text" name="cnt_cd" id="cnt_cd" style="width:100;text-align:left;ime-mode:disabled" class="input" caption="Country" minlength="2" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('upper')" ><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_ctryPopup" name="btn_ctryPopup">
	                    </nobr>					
					</td>
					 -->					
				</tr>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>	       	
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!--  biz_1   (E) -->
	</td></tr>
</table>
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    		<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</td>
			</tr>
		</table>
	</td></tr>
</table>
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>