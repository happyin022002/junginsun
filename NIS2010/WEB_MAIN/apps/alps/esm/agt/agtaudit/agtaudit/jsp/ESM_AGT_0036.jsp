<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_036.jsp
*@FileTitle : Agent Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-14
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-14 Junghyung_kim
* 1.0 
* 2009-09-28 : Ho-Jin Lee Alps 전환
========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event.EsmAgt0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
EsmAgt0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;						//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";

String aproNo = "";
Logger log = Logger.getLogger("com.hanjin.apps.AGTAudit.AGTAudit");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strUsr_id =	account.getUsr_id();
	strUsr_nm = account.getUsr_nm();
	
	event = (EsmAgt0036Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);


	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

}catch(Exception e) {
	out.println(e.toString());
}

%>

<html>
<head>
<title>Agent Commission Audit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function init_sheet(){
		var scnId = window.dialogArguments["scnId"];
   		var arOfc = window.dialogArguments["arOfc"];;
   		var sbOfc = window.dialogArguments["sbOfc"];
   		var saDate = window.dialogArguments["saDate"];
   		var sheet = window.dialogArguments["sheet"];

   		var stsCd = window.dialogArguments["stsCd"];
//   		var frDate = window.dialogArguments["frDate"];
		var frDate = window.dialogArguments["from_date"];
//   		var toDate = window.dialogArguments["toDate"];
		var toDate = window.dialogArguments["to_date"];
   		var expType = window.dialogArguments["expType"];
   		
   		var bkg_no = window.dialogArguments["bkg_no"];
   		var io_bnd_cd = window.dialogArguments["io_bnd_cd"];
   		var ac_seq = window.dialogArguments["acSeq"];
   		
	
   		if(stsCd == null){ stsCd = ""; }
   		if(frDate == null){ frDate = ""; }
   		if(toDate == null){ toDate = ""; }
   		if(expType == null){ expType = ""; }

   		form.scn_id.value = scnId;
//   		form.arOfc.value = arOfc;
		form.ar_ofc_cd.value = arOfc;
//   		form.sbOfc.value = sbOfc;
		form.agn_cd.value = sbOfc;
   		form.saDate.value = saDate;
   		form.sheet.value = sheet;

   		form.sts_cd.value = stsCd;
   		form.from_date.value = frDate;
   		form.to_date.value = toDate;
   		form.exp_type.value = expType;
   		
   		form.bkg_no.value = bkg_no;
   		form.io_bnd_cd.value = io_bnd_cd;
   		form.ac_seq.value = ac_seq;
   	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:init_sheet();setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- (ESM_AGT_010, ESM_AGT_016) 화면에서 넘어온 파라미터를 Hidden -->
<input type="hidden" name="scn_id">	<!-- Commission 종류 -->
<!-- <input type="hidden" name="arOfc"> -->	<!-- A/R Office Code -->
<input type="hidden" name="ar_ofc_cd">
<!--<input type="hidden" name="sbOfc">-->	<!-- Subject Office Code -->
<input type="hidden" name="agn_cd">
<input type="hidden" name="saDate">	<!-- S/A Date -->
<input type="hidden" name="sheet">	<!--  -->
<input type="hidden" name="arr_val">
<input type="hidden" name="sts_cd">	<!-- Status -->
<input type="hidden" name="from_date">	<!-- fromDt -->
<input type="hidden" name="to_date">	<!-- toDt -->
<input type="hidden" name="exp_type">	<!-- Other Commission 일때 General(512691) or General Exception(512692,512693) -->

<input type="hidden" name="bkg_no">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="ac_tp_cd">
<input type="hidden" name="ac_seq">
<!-- : ( Button : pop ) (E) -->
<!-- div id="div1" STYLE="visibility:hidden;"-->
<table width="100%" id="mainTable" >
	<tr>
		<td ><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>
<!-- /div-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Agent Commission Audit</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr>
		       		<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" id="btn_confirm" name="btn_confirm">Confirm</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" width="100%"">
							<tr class="h23">
								<td width="65">Audit No.</td>
								<td><input type="text" style="width:100;" class="input1" readOnly="true" value="<%= aproNo %>" name="s_apro_no"></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable" >
							<tr>
								<td ><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
   	    		<tr>
   	    			<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
