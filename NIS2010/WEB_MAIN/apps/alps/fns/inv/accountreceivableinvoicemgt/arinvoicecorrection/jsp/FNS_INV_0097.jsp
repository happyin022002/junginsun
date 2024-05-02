<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0097.jsp
*@FileTitle : Invoice Letter Wording Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.03 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0097Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0097Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (FnsInv0097Event)request.getAttribute("Event");
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
<title>Invoice Letter Wording Entry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
	
	<table class="search"> 
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td style="width:285;">
						<table class="search_sm2" border="0" style="width:240;"> 
							<tr class="h23">
								<td width="100"><input name="search_option" type="radio" class="trans" value="V" checked onClick="javascript:changeSearchOption(this.value);">&nbsp;By VVD</td>   
								<td width=""><input name="search_option" type="radio" class="trans" value="C" onClick="javascript:changeSearchOption(this.value);">&nbsp;By Customer</td>   
					
							</tr>
						</table>

					</td>
					<td width="40">Office</td>   
					<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;VVD</td>   
					<td width="200" style="padding-left:1"><input name="vvd" type="text" style="width:101;" class="input1" maxlength="9" minlength="9" value="" dataformat="engup"></td>
					<td width="40">Port</td>   
					<td width=""><input name="port_cd" type="text" style="width:100;" class="input1" maxlength="5" minlength="5" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;Customer</td>   
					<td width=""><input name="cust_cnt_cd" type="text" style="width:25;" value="" class="input" maxlength="2" dataformat="engup">&nbsp;-&nbsp;<input name="cust_seq" type="text" style="width:50;" value="" class="input" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:370;" value="" class="input2" value="" readonly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
						
				<table border="0" style="width:979;"> 
				<tr class="h23">
					<td width="64">&nbsp;&nbsp;Subject</td>   
					<td width=""><input name="subject" type="text" style="width:100%;" class="input" value=""></td>
				</tr>
				</table>	
						
				<table border="0" style="width:979; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="60"></td>   
					<td width=""></td>
					<td width="60">Highlight</td>   
				</tr>	
				
				<tr class="h23">
					<td width="" class="tr2_head">Text1</td>   
					<td width=""><textarea name="text1" style="width:100%;height:85;"></textarea></td>
					<td width="" align="center"><input name="high_light1" type="checkbox" value="Y" class="trans"></td> 
				</tr>
				
				<tr class="h23">
					<td width="" class="tr2_head">Text2</td>   
					<td width=""><textarea name="text2" style="width:100%;height:85;"></textarea></td>
					<td width="" align="center"><input name="high_light2" type="checkbox" value="Y" class="trans"></td> 
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">Text3</td>   
					<td width=""><textarea name="text3" style="width:100%;height:85;"></textarea></td>
					<td width="" align="center"><input name="high_light3" type="checkbox" value="Y" class="trans"></td> 
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">Text4</td>   
					<td width=""><textarea name="text4" style="width:100%;height:85;"></textarea></td>
					<td width="" align="center"><input name="high_light4" type="checkbox" value="Y" class="trans"></td> 
				</tr>
				</table>	
				
				<!-- biz_1  (E) -->
		</td></tr>
		</table>
				
	<!--biz page (S)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>
<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!------- Print용 Hidden RD Object Start -------->
<table>
<tr>
	<td height="1" width="1">
		<script language="javascript">comRdObject('report1');</script>
	</td>
</tr>
</table>
<!------- Print용 Hidden RD Object End -------->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>