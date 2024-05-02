<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0031.jsp
*@FileTitle : Terminal invoice CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2007-01-09 kimjin
* 1.0 최초 생성
* N200905040013 2009-05-11: Office Change 개념의 모듈적용 요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl"%>
<%
	EsdTrs0031Event  event 		= null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;		//서버에서 발생한 에러
	String strErrMsg 			= "";		//에러메세지
	String cnt_cd 				= "";
	String ofc_cd  				= "";

//	String[] arrChinaSpeOffice	= {"SZPBB", "CANBS"};
	String[] arrChinaSpeOffice	= {"SZPSC", "CANSO"};
	String	 sBranchIndicator	= "N";

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	    ofc_cd	= account.getOfc_cd();
	    cnt_cd 	= account.getCnt_cd();

	    //N200905040013 2009-05-11: Office Change 개념의 모듈적용
	    CSRIssueTransferSlipManageBCImpl csrBC = new CSRIssueTransferSlipManageBCImpl();
	    cnt_cd						= csrBC.searchOfficeChangedCntCd(ofc_cd);
	    
	    for(int i=0; i<arrChinaSpeOffice.length; i++)
	    {
	    	if(arrChinaSpeOffice[i].equals(ofc_cd)){
	    		sBranchIndicator	= "Y";
	    		break;
	    	}
	    }

		event = (EsdTrs0031Event)request.getAttribute("Event");

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
<title>Transportion invoice CSR Creation - Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
//		document.form.cost_ofc_cd.focus();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form  method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

		</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="12%">Invoice Office</td>
							<td width="13%"><input class="input1" name="cost_ofc_cd" type="text" maxlength="6" style="width:100" value="<%=ofc_cd%>" readonly ></td>
							<td width="12%">Confirmed Date</td>
							<td width="13%"><input name="inv_cfm_dt" type="text" maxlength="10" style="width:80" value="" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp="javascript:isNum(this);"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1" onkeypress=""></td>
							<td width="8%">Interface</td>
							<td width="15%" class="sm" align="left"><input type="radio" name="asanogb" value="A/P" class="trans" checked onkeypress="enter();">&nbsp;To A/P&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="asanogb" value="ASA" class="trans" onkeypress="enter();">&nbsp;To ASA</td>

							<% if("Y".equals(sBranchIndicator)) { %>
							<td width="7%">Payment</td>
							<td class="sm" align="left"><input type="radio" name="paymenttype" value="BRANCH" class="trans" checked onkeypress="enter();">&nbsp;By Branch&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="paymenttype" value="RHQ" class="trans" onkeypress="enter();">&nbsp;By RHQ</td>
							<% }else{ %>
							<td width="7%"></td>
							<td class="sm" align="left"></td>
							
							<% } %>

						</tr>
						<tr class="h23">
							<td>Payment Service Provider</td>
							<td colspan="7"><input name="combo_svc_provider" type="text" maxlength="6" style="width:100" value="" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btng_provider"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="svc_provider" type="text" style="width:405" readOnly class="input2"></td>
						</tr>
					</table>
					<!-- : ( Week ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_detail" name="btng_detail">Detail</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button : Sub ) (E) -->

					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->



</form>

<form action="ESD_TRS_0032.do" name="form1"		>
	<input type="hidden" name="form_inv_cfm_dt"		> 
	<input type="hidden" name="vndr_seq"		>
	<input type="hidden" name="vndr_seq_name"	>
	<input type="hidden" name="curr_cd"			>
	<input type="hidden" name="gen_pay_term_cd"	>
	<input type="hidden" name="pay_term_tp_cd"	>
	<input type="hidden" name="payment_due_dt"	>
	<input type="hidden" name="asanogb"			>
	<input type="hidden" name="paymenttype"		>
	<input type="hidden" name="cost_office_cd"	>
	<input type="hidden" name="conti_cd"	>
	<input type="hidden" name="pgmNo"	>

	<input type="hidden" name="invoice_office_cd" value="<%=ofc_cd%>">
</form>

</body>
</html>