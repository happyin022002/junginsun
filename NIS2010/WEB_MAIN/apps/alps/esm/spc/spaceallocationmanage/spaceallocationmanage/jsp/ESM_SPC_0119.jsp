<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0119.jsp
*@FileTitle : Control Option Register Office 선택 Popup 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : Kim Sung Wook
*@LastVersion : 1.0
* 2015.03.02 
* 1.0 Creation
*  2015.03.02 Control Option Register Office 선택 Popup 화면
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0119Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0119Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String trd_cd = request.getParameter("trd_cd");
	trd_cd = JSPUtil.replaceForHTML( trd_cd );
	
	String sub_trd_cd = request.getParameter("sub_trd_cd");
	sub_trd_cd = JSPUtil.replaceForHTML( sub_trd_cd );
	
	String rlane_cd = request.getParameter("rlane_cd");
	rlane_cd = JSPUtil.replaceForHTML( rlane_cd );
	
	String dir_cd = request.getParameter("dir_cd");
	dir_cd = JSPUtil.replaceForHTML( dir_cd );
	
	String aloc_ctrl_tp_cd = request.getParameter("aloc_ctrl_tp_cd");
	aloc_ctrl_tp_cd = JSPUtil.replaceForHTML( aloc_ctrl_tp_cd );
	
	String ctrl_loc_acct_cd = request.getParameter("ctrl_loc_acct_cd");
	ctrl_loc_acct_cd = JSPUtil.replaceForHTML( ctrl_loc_acct_cd );
	
	String ofc_cd = request.getParameter("ofc_cd");
	ofc_cd = JSPUtil.replaceForHTML( ofc_cd );
	
	String sheetType = request.getParameter("sheet");
	sheetType = JSPUtil.replaceForHTML( sheetType );
	
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0119Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
// 		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Import Control Option Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

var trd_cd = "<%=trd_cd%>";
var sub_trd_cd = "<%=sub_trd_cd%>";
var rlane_cd = "<%=rlane_cd%>";
var dir_cd = "<%=dir_cd%>";
var aloc_ctrl_tp_cd = "<%=aloc_ctrl_tp_cd%>";
var ctrl_loc_acct_cd = "<%=ctrl_loc_acct_cd%>";
var ofc_cd = "<%=ofc_cd%>";
var sheetType = "<%=sheetType%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="is_upload"  value="Y">

<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td height="10"></tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Office List</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
       		<table  border="0" class="search">
				<tr><td>
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
		           </td></tr>
		           <tr><td>
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
							<tr><td class="btn1_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_ok_all_frame">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok_all" id="btn_ok_all">Apply All</td><td class="btn1_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table>
										</td>
									</tr></table>
				
							</td></tr>
						</table>
					</td></tr>
		         </table>
			</td></tr>
			
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		

<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>