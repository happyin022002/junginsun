<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0059.jsp
*@FileTitle : MCS Letter Information Text Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.24 함대성
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event.FnsJoo0059Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0059Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationLetter");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsJoo0059Event)request.getAttribute("Event");
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
<title>MCS Letter Information Text Creation</title>
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
<input type="hidden" name="userIdSave" value="<%=strUsr_id %>">
<input type="hidden" name="user_nm_his" value="<%=strUsr_nm %>">
<input type="hidden" name="jo_ltr_tp_cd" value="M">
<input type="hidden" name="copy" value="">
<input type="hidden" name="jo_ltr_tmplt_seq" value ="">
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
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Office</td>
						<td width="130"><input type="text" style="width:100" class="input" name="ofc_cd" value="<%=strOfc_cd %>" disabled></td>
	                    <td width="110">Creation User NM</td>
	                    <td width="290"><script language="javascript">ComComboObject('user_id', 2, 100, 0, 1, 0, false);</script>
	                    &nbsp;<input name="user_nm" type="text" style="width:160;"  value="" class="input2" readonly="readonly" caption="User Name">
	                    </td>						
						<td width="55">Text No.</td>
						<td width="130"><script language="javascript">ComComboObject('jo_tmplt_no',1,80,0,0);</script></td>
						<td width="">&nbsp;</td> 
					</tr>
				</table>
			
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90" valign="top">Address</td>
					<td  colspan="3"><textarea style="width:820;ime-mode:disabled" rows="2" readonly class='textarea2' name="ofc_addr" dataformat="etc" disabled></textarea></td>
				</tr>
				<tr class="h23">
					<td width="90" valign="top">Text Detail - 1</td>
					<td width="" colspan="3"><textarea style="width:820;" name="n1st_stmt_ctnt" rows="5" dataformat="etc" style='IME-MODE: disabled'></textarea></td>
				</tr> 
				<tr class="h23">
					<td width="90" valign="top">Text Detail - 2</td>
					<td width="" colspan="3"><textarea style="width:820;" name="n2nd_stmt_ctnt" rows="5" dataformat="etc" style='IME-MODE: disabled'></textarea></td>
				</tr> 
				<tr class="h23">
					<td width="90" valign="top">Attachment</td>
					<td width="420" valign="top"><textarea style="width:390;" name="n3rd_stmt_ctnt" rows="8" dataformat="etc" style='IME-MODE: disabled'></textarea></td>
					<td width="90" valign="top">Signature</td>
					<td width=""><textarea style="width:310;" name="lbl_sig_stmt_ctnt" rows="8" class='textarea2' readonly></textarea></td>
				</tr> 
                <tr class="h23">
                    <td width="90" valign="top">Greeting</td>
                    <td width="" colspan="3"><textarea style="width:820;" name="n4th_stmt_ctnt" rows="5" dataformat="etc" style='IME-MODE: disabled'></textarea></td>
                </tr> 
				</table>
			<!--  biz_1   (E) -->
			</td></tr>
            <table width="0"  id="mainTable"> 
                <tr>
                    <td width="0">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>    
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>