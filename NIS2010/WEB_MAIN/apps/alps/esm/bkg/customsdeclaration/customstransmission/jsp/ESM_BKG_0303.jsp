<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0303.jsp
*@FileTitle : ESM_BKG_0303
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.26 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0303Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0303Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsTransmission");

	String vvdCd 		= "";
	String polCd 		= "";
	String podCd 		= "";
	String emptyCheck 	= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EsmBkg0303Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// 부모창에서 넘오온 파라메터 셋팅
		vvdCd 		= (request.getParameter("vvd_cd") == null) 		? "" : request.getParameter("vvd_cd");
		polCd 		= (request.getParameter("pol_cd") == null) 		? "" : request.getParameter("pol_cd");
		podCd 		= (request.getParameter("pod_cd") == null) 		? "" : request.getParameter("pod_cd");
		emptyCheck 	= (request.getParameter("empty_check") == null) ? "" : request.getParameter("empty_check");
		
		
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
<input type="hidden" name="process_type" value="3">
<input type="hidden" name="empty_check" value="<%=emptyCheck%>">
 

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  TP Request (EDI)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">VVD</td>
					<td width="140">
						<input type="text" style="width:100;" class="input2" name="vvd_cd" value="<%=vvdCd%>" 
							required dataformat="eng" maxlength="9" fullfill caption="VVD">
					</td>
					<td width="30">POL</td>
					<td width="100">
						<input type="text" style="width:60;" class="input" name="pol_cd" value="<%=polCd%>" 
							dataformat="eng" maxlength="5" caption="POL">
					</td>
					<td width="30">POD</td>
					<td>
						<input type="text" style="width:60;" class="input" name="pod_cd" value="<%=podCd%>"
							required dataformat="eng" caption="POD" fullfill maxlength="5">
					</td>
				</tr>
				<tr class="h23">
					<td>Sender</td>
					<td colspan="5"><input type="text" style="width:360;" class="input" name="sender"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="105">TP Fee Payment</td>
					<td class="stm">
						<input type="text" style="width:175;" class="input" name="tp_fee" value="">
					</td>
				</tr> 
				<tr><td height="5"></td></tr>
				</table>				
				<!--  biz_1   (E) -->
				
				<!--biz page 2 (S)-->
				<table width="100%" id="mainTable" style="display:none">
				    <tr>
				        <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				    </tr> 
				
				</table>
				<!--biz page 2 (E)-->
				
			

		</td></tr></table>
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
					<td class="btn1" name="btn_download">EDI Download</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
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

		