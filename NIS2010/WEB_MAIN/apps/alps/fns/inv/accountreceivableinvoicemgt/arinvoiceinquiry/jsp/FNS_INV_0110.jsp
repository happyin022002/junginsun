<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0110.jsp
*@FileTitle : (DXBSC) INV B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2010.02.19 최우석
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0110Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	String arOfcCd2 = request.getParameter("ar_ofc_cd2")==null?"":request.getParameter("ar_ofc_cd2");
	String blNos = request.getParameter("bl_nos")==null?"":request.getParameter("bl_nos");
	String fromDt = request.getParameter("from_dt")==null?"":request.getParameter("from_dt");
	String toDt = request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String dtOption = request.getParameter("dt_option")==null?"":request.getParameter("dt_option");
	String userId = request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String custCntCd = request.getParameter("cust_cnt_cd")==null?"":request.getParameter("cust_cnt_cd");
	String custSeq = request.getParameter("cust_seq")==null?"":request.getParameter("cust_seq");
	String ifUserId = request.getParameter("if_user_id")==null?"":request.getParameter("if_user_id");
	String vvd = request.getParameter("vvd")==null?"":request.getParameter("vvd");
	String port = request.getParameter("port")==null?"":request.getParameter("port");
	String scp = request.getParameter("scp")==null?"":request.getParameter("scp");
	String bnd = request.getParameter("bnd")==null?"":request.getParameter("bnd");
	String revType = request.getParameter("rev_type")==null?"":request.getParameter("rev_type");
	String invDupFlg = request.getParameter("inv_dup_flg")==null?"":request.getParameter("inv_dup_flg");
	String otsSmryCd = request.getParameter("ots_smry_cd")==null?"MULTI":request.getParameter("ots_smry_cd");	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0110Event)request.getAttribute("Event");
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
<title>(DXBSC) INV B/L List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>-->

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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="ar_ofc_cd2" value="<%=arOfcCd2%>">
<input type="hidden" name="bl_nos" value="<%=blNos%>">
<input type="hidden" name="from_dt" value="<%=fromDt%>">
<input type="hidden" name="to_dt" value="<%=toDt%>">
<input type="hidden" name="dt_option" value="<%=dtOption%>">
<input type="hidden" name="user_id" value="<%=userId%>">
<input type="hidden" name="cust_cnt_cd" value="<%=custCntCd%>">
<input type="hidden" name="cust_seq" value="<%=custSeq%>">
<input type="hidden" name="if_user_id" value="<%=ifUserId%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="port" value="<%=port%>">
<input type="hidden" name="scp" value="<%=scp%>">
<input type="hidden" name="bnd" value="<%=bnd%>">
<input type="hidden" name="rev_type" value="<%=revType%>">
<input type="hidden" name="inv_dup_flg" value="<%=invDupFlg%>">
<input type="hidden" name="ots_smry_cd" value="<%=otsSmryCd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;(DXBSC)INV B/L List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
					<tr><td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_paperissue">Issue</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>