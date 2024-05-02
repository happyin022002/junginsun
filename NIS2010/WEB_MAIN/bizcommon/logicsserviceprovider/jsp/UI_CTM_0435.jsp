<!-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_CTM_0435.jsp
*@FileTitle : Lane 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-04-22
*@LastModifier : KyungMin Woo
*@LastVersion : 1.0
* 2009-04-22 
* 1.0 최초 생성
========================================================= -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.logicsserviceprovider.event.UiCtm0435Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	UiCtm0435Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_ofc = null;	
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	Logger log = Logger.getLogger("com.hanjin.apps.BizCommon.logicsserviceprovider");

	// p_sp_type 값 가져오기.
	String p_sp_type = request.getParameter("p_sp_type");
	if(p_sp_type == null){
		p_sp_type = "";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strUsr_ofc = account.getOfc_cd();	   
		event = (UiCtm0435Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		log.error(e.toString());
	}


%>

<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css">

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

<body class="popup_bg" onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd" value="1">
<input type="hidden" name="mode" value="">
<input type="hidden" name="pagerows" value="">
<input	type="hidden" name="depth">
<input	type="hidden" name="chkDepth">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Service Provider Inquiry</td></tr>
		</table>
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table border="0" style="width:580;">
				<tr class="h23">
					<td width="170">
						<table class="grid2" border="0" style="width:150;">
							<tr><td class="tr2_head" width="90">Country</td>
							<td><input type="text" name="p_country" dataformat="engup" style="width:58;ime-mode:disabled" class="input" value="<%=(request.getParameter("p_country") == null)? "" : request.getParameter("p_country")%>"></td>
							</tr>
							<tr><td class="tr2_head" width="90">Control Office</td>
							<td><input type="text"  name="p_ofc_cd" dataformat="engup" style="width:58;ime-mode:disabled" class="input" value="<%=(request.getParameter("p_ofc_cd") == null)? "" : request.getParameter("p_ofc_cd")%>"></td>
							</tr>
							
						</table>
					
					
					</td>
					<td width="170">
						<table class="grid2" border="0" style="width:150;">
							<tr><td class="tr2_head" width="90">S/P Code</td>
							<td><input type="text" name="p_print_vndr_seq" dataformat="engup" style="width:58;ime-mode:disabled" class="input" value="<%=(request.getParameter("p_print_vndr_seq") == null)? "" : request.getParameter("p_print_vndr_seq")%>"></td>
							</tr>
							<tr><td class="tr2_head" width="90">Parent Code</td>
							<td><input type="text" name="p_vndr_seq" dataformat="engup" style="width:58;ime-mode:disabled" class="input" value="<%=(request.getParameter("p_vndr_seq") == null)? "" : request.getParameter("p_vndr_seq")%>"></td>
							</tr>
							
						</table>
					
					
					</td>
					<td width="" align="right">
						<table class="grid2" border="0" style="width:230;">
							<tr><td class="tr2_head" width="60">S/P Name</td>
							<td><input type="text" name="p_vndr_nm" dataformat="engup" style="width:155;" class="input" value="<%=(request.getParameter("p_vndr_nm") == null)? "" : request.getParameter("p_vndr_nm")%>"></td>
							</tr>
							<tr><td class="tr2_head" width="">S/P Type</td>
							<td><input type="radio" name="p_sp_type" dataformat="engup" value="Y" class="trans"  <%if(p_sp_type.equals("Y")) out.print("checked"); %> >Logistics&nbsp;&nbsp;&nbsp;<input type="radio" name="p_sp_type" value="" class="trans" <%if(p_sp_type.equals("N")) out.print("checked"); %> >All</td>
							</tr>
							
						</table>
					
					
					</td>
				</tr>
			</table>
			
			
			
				<!-- : ( Grid ) (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 				
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_ok">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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

<%@ include file="/bizcommon/include/common_alps.jsp"%>