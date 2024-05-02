<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0140.jsp
*@FileTitle : Email(Edit)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* --------------------------------------------------------
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0140Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.io.FileUtils"%>
<%@ page import="com.hanjin.framework.component.util.CheckUtils"%>
<%
    FnsInv0140Event event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount = 0;                       //DB ResultSet 리스트의 건수
    String successFlag = "";
    String codeList = "";
    String pageRows = "100";
    String edtToEml = null;
    String edtSubject = null;
    String edtFromEml = null;
    Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (FnsInv0140Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        edtToEml = JSPUtil.getParameter(request, "edt_to_eml", "");
        edtSubject = JSPUtil.getParameter(request, "edt_subject", "");
        edtFromEml = account.getUsr_eml();
        
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Email (Edit)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="/hanjin/syscommon/common/fckeditor/ckeditor.js"></script>
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

<form name="form" enctype="multipart/form-data"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="edt_contents">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Email (Edit)</td>
		<td width ="100" class="title_s" align="right" bgcolor="#E9E9E9">
					<div id='options' style="padding:5 10 5 10;width:100%;font-size:10px;height:11px;" >
					</div>
					</td>
		
		</tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
			
			
			<table class="grid2" border="0" style="width:100%;"> 
			<tr>
				<td class="tr2_head" width="60">To</td>
				<td width=""><input type="text" name="edt_to_eml" style="width:99%;text-align:left;" class="input" value="<%=edtToEml %>"></td>
			</tr>  
			<tr>
				<td class="tr2_head">CC</td>
				<td width=""><input type="text" name="edt_cc_eml" style="width:99%;text-align:left;" class="input" value=""></td>
			</tr> 
			<tr>
				<td class="tr2_head">From</td>
				<td width=""><input type="text" name="edt_from_eml" style="width:99%;text-align:left;" class="input" value="<%=edtFromEml%>"></td>
			</tr>  
			<tr>
				<td class="tr2_head">Subject</td>
				<td width=""><input type="text" name="edt_subject" style="width:99%;text-align:left;" class="input" value="<%=edtSubject%>"></td>
			</tr>			
			<tr>
				<td class="tr2_head">Contents</td>
				<td width=""><textarea class="ckeditor" name="edt_contents" id="edt_contents" style="width:99%;height:220;">We’ve attached the BLs, so please check and send the remittance by due date</textarea> <!-- Grid  (E) --></td>
			</tr>    
			</table>
				
		</td></tr></table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>

<!--Grid (S)-->
<table width="0" id="mainTable" style="display:hidden"> 
	<tr>
		<td width="0">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 
<!--Grid (E)-->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table border="0" cellpadding="0" cellspacing="0">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Send">Send Email</td>
				<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>	
			<td><table border="0" cellpadding="0" cellspacing="0">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
				</tr></table></td>
		    </tr>
		    </table></td>
		</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

		
</form>
</body>
</html>