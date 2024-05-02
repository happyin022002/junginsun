<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0300.jsp
*@FileTitle : ESM_BKG_0300
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.17 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0296Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
/*	   
		event = (EsmBkg0296Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
*/		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// 부모창에서 넘오온 파라메터 셋팅
		vvdCd = (request.getParameter("vvd_cd") == null) ? "" : request.getParameter("vvd_cd");
		polCd = (request.getParameter("pol_cd") == null) ? "" : request.getParameter("pol_cd");
		podCd = (request.getParameter("pod_cd") == null) ? "" : request.getParameter("pod_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
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


<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  Manifest Generation _ Form Setting</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<!-- <table class="search" border="0" style="width:979;"> --> 
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="120">Office</td>
					<td style="padding-left:1;">
						<input type="text" style="width:80;" class="input" name="ofc_cd" value="<%=strOfc_cd%>"
							required dataformat="eng" maxlength="6" caption="Office">
					</td>
				</tr>
				<tr class="line_bluedot"><td colspan="2"></td></tr>
				<tr class="h23">
					<td>Agent</td>
					<td><textarea style="width:99%; height:50;" name="form1_hdr_ctnt"></textarea></td>
				</tr>
				<tr class="h23">
					<td>Footer</td>
					<td><textarea style="width:99%; height:50;" name="form1_ftr_ctnt"></textarea></td>
				</tr>
				<tr class="h23">
					<td>TP Permit Address</td>
					<td><textarea style="width:99%; height:50;" name="form1_decl_addr"></textarea></td>
				</tr>
				<tr class="h23">
					<td>TP Body</td>
					<td><textarea style="width:99%; height:50;" name="form1_bod_ctnt"></textarea></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
			    <!--biz page 2 (S)-->
			    <table width="100%" id="mainTable" style="display:none">
			        <tr>
			            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)-->
				
				
			</td></tr>
		</table>
		<!--biz page (E)-->
		
	
	

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
