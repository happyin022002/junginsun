<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0082.jsp
*@FileTitle : (Brazil) Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.11 최우석
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0082Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfcCd			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfcCd = account.getOfc_cd();

		event = (FnsInv0082Event)request.getAttribute("Event");
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
<title>(Brazil) Agent Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>-->

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
<input type="hidden" name="pagetype" value="E">
<input type="hidden" name="ar_ofc_cd">
<input type="hidden" name="searchYn">

<!-- 개발자 작업	-->
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
					<td width="800">
					<table border="0" style="width:300;"> 
						<tr class="h23">
							<td>&nbsp;</td>
						</tr>
					</table>
					</td>
					<td width="40">Office</td>   
					<td><script language="javascript">ComComboObject('combo_ar_ofc_cd', 1, 100, 1);</script></td></tr>
				</table>	
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--grid (S)-->
				<table width="100%" class="search"  id="mainTable" "> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!--grid (E)-->
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
      				<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_add">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_ins">Row&nbsp;Ins</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_del">Row&nbsp;Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</table>
					</td></tr>
				</table>
	   			<!-- Button_Sub (E) -->
	   			
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
				<td class="btn1" name="btn_retrive">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_downExcel">Down Excel</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
	</td></tr>
</table>
<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>