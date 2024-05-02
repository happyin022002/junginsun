<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0127.jsp
*@FileTitle : Bad Customer Inquiry by Update Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : ������
*@LastVersion : 1.0
* 2009.05.27 ������
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=euc-kr" %>
<% 
request.setCharacterEncoding("euc-kr");
%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0127Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0127Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//�������� �߻��� ����
	String strErrMsg = "";						//�����޼���
	int rowCount	 = 0;						//DB ResultSet ����Ʈ�� �Ǽ�

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsInv0127Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// �ʱ�ȭ�� �ε��� �����κ��� ������ ������ �����ϴ� �����߰� ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bad Customer Inquiry by Update Date</title>
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
<!-- ������ �۾�	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="ofc_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
		
		<!--biz page (S)-->
		<table class="search"> 
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					
					<tr class="h23">
						<td width="50">RHQ</td>
						<td><script language="javascript">ComComboObject('ar_hd_qtr_ofc_cd', 1, 100, 1);</script></td>
						<td width="100" align = "right">As of Date</td>
						<td> 
							<input type="text" style="width: 75" value="" name="upd_dt"	onBlur="fn_ComGetMaskedValue('upd_dt');">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20"	border="0" align="absmiddle" name="btns_calendar">
						</td>
						<td width="100" align = "right">Kind</td>   
						<td><input type="radio" name="bad_cust_knd_cd" value="N" class="trans" onClick="fn_kindFlag();" checked>No use In Sales	</td>
					</tr>
					<tr class="h23">
						<td colspan = "5"></td>
						<td><input type="radio" name="bad_cust_knd_cd" value="F" class="trans" onClick="fn_kindFlag();">Financial Risk to release B/L and Cargo
						</td>
					</tr>	
					<tr class="h23">	
						<td width="70">Cust. Code</td>
						<td width="500" colspan = "5">
										<input type="text" style="ime-mode: disabled; width: 30" value="" class="input1" dataformat="engup" name="cust_cnt_cd" maxlength="2" onKeyUp="if(ComChkLen(this, 2)==2){ComSetNextFocus();}">
										<input type="text" style="width: 49" value="" name="cust_seq" dataformat="num" class="input1" onChange="fn_cust_nm();" maxlength="6">
										<input type="text" style="width: 400" value="" class="input2" name="cust_nm" readonly></td>
					</tr>
				</table>
				<!-- biz_1  (E) -->
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			</tr>
		</table>	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					
					
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
	</td>
</tr>
</table>

<!-- ������ �۾�  �� -->
</form>
</body>
</html>