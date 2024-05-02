<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0015.jsp
*@FileTitle : Customer Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.21 한동훈
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0015Event)request.getAttribute("Event");
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
<title>Customer Report by Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="ofc2">
<input type="hidden" name="creSelOfc">
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
					<td width="130">&nbsp;&nbsp;Office</td>     
					<td align='left'>
						<!--
						<select name="ofc" style="width:70;"class="input1">&nbsp;
						<option value="SELBB" selected>HAMBB</option>
						<option value="2"></option>
						-->
						<script language="javascript">ComComboObject('ofc', 1, 100, 0, 1, 0);</script>
					</td>										
				</tr>
				</table>	
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130">&nbsp;&nbsp;Option</td>   
					<td align='left'><input type="radio" name="cust_flag" value="C" class="trans" onClick="fn_custFlag();" checked>Credit Customer
&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="cust_flag" value="S" class="trans" onClick="fn_custFlag();">Sales Customer
&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
				</table>	
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>				 				
				 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130">&nbsp;&nbsp;Release Control</td>     
					<td align='left'>
						<input type="radio" name="cust_rlse_ctrl_flg" value="" class="trans" checked>ALL
			&nbsp;&nbsp;<input type="radio" name="cust_rlse_ctrl_flg" value="Y" class="trans">Y
			&nbsp;&nbsp;<input type="radio" name="cust_rlse_ctrl_flg" value="N" class="trans">N
					</td>  
				</tr>
				</table>	   
					
					
		</td></tr>
		</table>
		
	

			</td></tr>
		</table>
	
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>


<!-- Grid  (S) -->
<div style="display:none">
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 	
</div>
<!-- Grid (E) -->



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>