<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0026.jsp
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.29 한동훈
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0026Event)request.getAttribute("Event");
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
<title>Invoice Update by User ID</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ofc2">
<input type="hidden" name="svc_scp_cd" >
<input type="hidden" name="locl_curr_cd" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="40">VVD</td>	<!-- CMAN0008W	BEANR	HAMBB -->
					<td width="110"><input type="text" name="vvd" style="width:80;" style="ime-mode:disabled" dataformat="uppernum" class="input1" maxlength="9"></td>					
					<td width="66">S/A Date</td>
					<td width="100"><input type="text" name="sa_date" style="width:80;" class="input2" readonly></td>
					<td width="150">Ex. Rate (USD to LCL)</td>
					<td width="90"><input type="text" name="inv_xch_rt" style="width:60;" class="input2" readonly></td>
					<td width="80">POL</td>
					<td width="90"><input type="text" name="pol_cd" style="width:50;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5"></td>
					<td width="20">POD</td>
					<td width="90"><input type="text" name="pod_cd" style="width:50;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5"></td>
					<td width="50">Office</td>
					<td width="">
						<!--	
						<select name="ar_ofc_cd" style="width:67;" class="input1">
							<option value="0" selected>HAMBB</option>
							<option value="1"></option>
						</select>
						-->
						<script language="javascript">ComComboObject('ofc', 1, 100, 1);</script>
					</td>
					</tr>
					<tr class="h23">
					<td width="">Scope</td>
					<td width="" style="padding-left:2">
						<!--
						<select name=""svc_scp_cd style="width:81;" class="input">
						<option value="0" selected>All</option>
						<option value="1"></option>
						</select></td>
						-->
						<script language="javascript">ComComboObject('svc_scp_cd1', 1, 50, 2);</script>
					<td width="">Lane</td>
					<td width="">						
						<input type="text" name="slan_cd" style="width:60;" class="input" dataformat="uppernum" maxlength="3">
					</td>		
					<td width="">Bound</td>
					<td width=""><select name="io_bnd_cd" style="width:60;" class="input">
						<option value="A" selected>All</option>
						<option value="O">O/B</option>
						<option value="I">I/B</option>
						</select></td>
					<td width="">BKG Office</td>
					<td width=""><input type="text" name="bkg_ofc_cd" style="width:50;" class="input" style="ime-mode:disabled" dataformat="engup"></td>
					<td width="" colspan="4">Rev Source&nbsp;&nbsp;<select name="rev_tp_cd" style="width:65;" class="input">
						<option value="" selected>All</option>
						<option value="B">B/L</option>
						<option value="C">C/A </option>
						<option value="M">MRI</option>
						</select></td>
						<!-- 
					<td width="">Rev Source</td>
					<td width="" style="padding-left:2"><select name="rev_tp_cd" style="width:67;" class="input">
						<option value="" selected>All</option>
						<option value="B">B/L</option>
						<option value="C">C/A </option>
						<option value="M">MRI</option>
						</select></td>
						-->
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>


					<!--grid (S)-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
						
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!--grid (E)-->

		</td></tr>
		</table>



			</td></tr>
		</table>



	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>

    <!--Button (E) -->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>