<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2039.jsp
*@FileTitle : RFA Proposal Creation - Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2039Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmPri2039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_srep      = "";
	String strProp_no 		= "";
	String strAmdt_seq 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAReport.RFAReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_srep = account.getSrep_cd();
		strProp_no 	= StringUtil.xssFilter(request.getParameter("prop_no"));
		strAmdt_seq 	= StringUtil.xssFilter(request.getParameter("amdt_seq"));
		event = (EsmPri2039Event)request.getAttribute("Event");
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
<title>RFA Proposal Creation - Draft</title>
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
<input type="hidden" name="usr_srep_cd" value="<%=strUsr_srep%>">
<input type="hidden" name="prop_no" value="<%=strProp_no%>">
<input type="hidden" name="amdt_seq"  value="<%=strAmdt_seq%>">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Print</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
	<!--Page Title, Historical (E)-->
	<!-- Hidden sheet for Transaction (S) -->
	<script language="javascript">ComSheetObject('sheet1');</script>
	<!-- Hidden sheet for Transaction (E) -->		
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="20"></td>
					<td width="55">RFA No.</td>
					<td width="160"><input type="text" style="width:110;" name="rfa_no" readonly=true class="input2">
									<input type="text" style="width:40;" name="amdt_seq_t" readonly=true class="input2"></td> 
					<td width="80">Proposal No.</td>
					<td width="100"><input type="text" caption="Proposal No" name="prop_no_t" style="width:80;" readonly=true class="input2"></td>
					<td width="400">
					<table class="search_sm2" border="0" style="width:450;"> 
					<tr class="h23">
						<td width="30"></td>
						<td width="100">Type</td>
					    <td width="" class="stm">
							  <input type="radio" value="1" name="ret_tp_rdo" class="trans" checked>All Items&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" value="2" name="ret_tp_rdo" class="trans">Amended Items&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					</table></td> 					
					<td width=""></td>
					
					</tr>
					<tr class="h23">
					<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_search">Search</td>
						<td class="btn1_right">
					</tr></table></td>
					</tr>				
				</table>
				<!--  biz_1   (E) -->
			</td>
		</tr>
	</table>
	
	<table class="height_8"><tr><td></td></tr></table>
		
		
	<table class="search"> 
       	<tr><td class="bg">		
				<!-- Grid  (S) -->
					<table width="100%" height="600" class="grid"> 
						<tr class="tr_head">
							<td width="100%"><script language="javascript">comRdObject('report1');</script></td>
						</tr>		
					</table> 
				<!-- Grid (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right">
				</table></td>
				<td class="btn1_line"></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</table></td>				
				</tr>
		</table></td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	
	
	
	
	
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>