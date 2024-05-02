<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0014.jsp
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";


	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfcCd = "";

	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfcCd = account.getOfc_cd();
	    log.info(strOfcCd);
	   
		event = (FnsInv0014Event)request.getAttribute("Event");
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
<title>Customer Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
 	function fn_custType() {
   		if(form.cust_type[0].checked){  
   			form.cust_nm1.style.display ="";
   			form.cust_nm2.style.display ="none";
   			form.cust_nm1.value = "";
   			form.cust_nm1.focus();
   		} 
   		if(form.cust_type[1].checked){  
   			form.cust_nm1.style.display ="none";
   			form.cust_nm2.style.display ="";
   			form.cust_nm2.value = "";
   			form.cust_nm2.focus();
   		} 

	}

 	function fn_customerType() {
   		if(form.cr_flg[0].checked){  
   			form.credit_type[0].disabled=true;
   			form.credit_type[1].disabled=true;
   			form.credit_type[2].disabled=true;
   			form.credit_type[0].checked = true;
   		} 
   		if(form.cr_flg[1].checked){  
   			form.credit_type[0].disabled=false;
   			form.credit_type[1].disabled=false;
   			form.credit_type[2].disabled=false;
   		} 
   		if(form.cr_flg[2].checked){  
   			form.credit_type[0].disabled=true;
   			form.credit_type[1].disabled=true;
   			form.credit_type[2].disabled=true;
   			form.credit_type[0].checked = true;
   		} 

	}
	
	
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="strOfcCd" value="<%=strOfcCd %>">
<!-- input type="hidden" name="cr_clt_ofc_cd"-->


<!-- OUTER - POPUP (S)tart -->

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="775" rowspan="2">
						<table border="0" style="width: 720;" class="search_sm2">
							<tr class="h23">
								<td width="140">&nbsp;Cust. Cntry&nbsp;&nbsp;<input type="text"
									style="width: 30; vertical-align: middle; ime-mode: disabled;"
									class="input" style="display:" value="" name="cust_cnt_cd"
									dataformat="engup" maxlength="2"></td>
								<td width="170">Cust. Name&nbsp; <select name="cust_type"
									style="width: 90;" class="input1">
									<option value="CM" selected>Eng Name</option>
									<option value="LCL">Local Name</option>
								</select></td>
								<td rowspan="2"><input type="text"
									style="width: 280; vertical-align: middle;" class="input1"
									id="cust_nm" style="display:" value="" name="cust_nm"
									dataformat="engup">
									Include<input type="checkbox" value="Y" class="trans" name="chk_nm">	
								</td>
							</tr>
						</table>
						</td>
						<td width="75">Zip Code</td>
						<td><input type="text"
							style="width: 110; ime-mode: disabled;" class="input" value=""
							name="locl_zip_cd" maxlength="10" dataformat="num"></td>
					</tr>
					<tr class="h23">
						<td>Credit Office</td>
						<td>
						<input type="text"
							style="width: 110; vertical-align: middle; ime-mode: disabled;"
							class="input" id="cr_clt_ofc_cd" style="display:" value=""
							maxlength="6" name="cr_clt_ofc_cd" dataformat="engup"></td>
					</tr>
				</table>
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>

				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="50%">
						<table border="0" style="width: 95%;" class="search_sm2">
							<tr class="h23">
								<td width="75">&nbsp;Customer</td>
								<td class="stm"><input type="radio" class="trans"
									name="cr_flg" value="" checked onClick="fn_customerType();">All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="cr_flg" value="Y"
									onClick="fn_customerType();">Credit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="cr_flg" value="N"
									onClick="fn_customerType();">Non Credit&nbsp;</td>
							</tr>
						</table>
						</td>
						<td align="right">
						<table border="0" style="width: 95%;" class="search_sm2">
							<tr class="h23">
								<td width="100" align="right">&nbsp;Credit</td>
								<td class="stm">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="credit_type" value=""
									disabled="true" checked>All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="credit_type" value="I"
									disabled="true">In-bound&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" class="trans" name="credit_type" value="O"
									disabled="true">Out-bound&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!--biz page (E)-->
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0" align="right">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrive">Retrieve</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn3_bg">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn3_bg">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downExcel">Down Excel</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_print">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>

			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>