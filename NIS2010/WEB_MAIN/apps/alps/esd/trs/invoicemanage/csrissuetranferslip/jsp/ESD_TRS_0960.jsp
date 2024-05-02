<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0960.jsp
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-09
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-01-09 chkong
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event"%>
<%
	EsdTrs0960Event  			event 				= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException   	= null;		//서버에서 발생한 에러
	DBRowSet 					rowSet	  			= null;		//DB ResultSet
	String 						strErrMsg 			= "";		//에러메세지
	int 						rowCount	 		= 0;		//DB ResultSet 리스트의 건수

	String csr_no  	= "";
	String mode		= "";

	csr_no 			 								= JSPUtil.getParameter(request, "csr_no".trim(), "");
	mode 			 								= JSPUtil.getParameter(request, "mode".trim()  , "");
	
	try {

	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0960Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Transportion invoice CSR Creation - Detail</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden"	name="mode"	value="<%=mode%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Invoice List Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options, Grid ) (S) -->
     	<table class="search">
			<tr><td class="bg">

					<!-- : ( Search Options ) (S) -->
					<table class="search" border="0">
						<tr class="h23">
							<td width="90">CSR No.</td>
							<td width="213"><input name="csr_no" type="text" style="width:196;" value="<%=csr_no %>"></td>
							<td width="158">Payment Service Provider</td>
							<td><input name="vndr_no" type="text" style="width:75;" value="">&nbsp;<input name="vndr_nm" type="text" style="width:221;" value=""></td>
						</tr>
					</table>
					<table class="search" border="0">
						<tr class="h23">
							<td width="90">No. of Invoice</td>
							<td width="45"><input name="inv_cnt" type="text" style="width:30;" value=""></td>
							<td width="111">Invoice Currency</td>
							<td width="55"><input name="csr_curr_cd" type="text" style="width:40;" value=""></td>
							<td width="70">Total AMT</td>
							<td width="95"><input name="csr_amt" type="text" style="width:80;" value=""></td>
							<td width="57">ASA No.</td>
							<td width="90"><input name="asa_no" type="text" style="width:75;" value=""></td>
							<td width="70">Cost Office</td>
							<td align="right"><input name="cost_ofc" type="text" style="width:75;" value=""></td>
						</tr>
					</table>
					<table class="search" border="0">
						<tr class="h23">
							<td width="90">Issue DT</td>
							<td width="85"><input name="max_iss_dt" type="text" style="width:75;" value="" ></td>
							<td width="71">Receive DT</td>
							<td width="120"><input name="max_rcv_dt" type="text" style="width:75;" value="" ></td>
							<td width="95">Payment Term</td>
							<td width="117"><input name="vndr_term_nm" type="text" style="width:75;" value=""></td>
							<td width="105">Payment Due DT</td>
							<td align="right"><input name="payment_due_dt" type="text" style="width:75;" value=""></td>
						</tr>
					</table>
					<!-- : ( Search Options ) (E) -->

					<table class="line_bluedot"><tr><td></td></tr></table>


					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->

					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->

							<!--  2007.10.08 - common 에서 호출되는 경우도 Detail button 활성화되도록 조건 삭제
							< % if( "trs".equals(mode) ) { %>
							< % } %>  -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_detailinquiry" name="btng_detailinquiry">Detail Inquiry</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


				</td>
			</tr>
		</table>
		<!-- : ( Search Options, Grid ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
			</tr>
			</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->



</form>
<form name='AuditForm' method='POST'>
<input type='hidden' name='inv_no'>
<input type='hidden' name='inv_vndr_seq'>
<input type='hidden' name='editflag'>
<input type='hidden' name='mode'>
<input type='hidden' name='mode_tab'>
<input type="hidden" name="pgmNo" >
</form>
</body>
</html>
