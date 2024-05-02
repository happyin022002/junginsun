<%
	/*=========================================================
	 *Copyright(c) 2011 CyberLogitec
	 *@FileName : fns_joo_0101.jsp
	 *@FileTitle : Ratio POP UP화면
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2015.02.04
	 *@LastModifier : 민정호
	 *@LastVersion : 1.0
	 * 2015.02.04 민정호
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0090Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	FnsJoo0090Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	String slaneCd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsJoo0090Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		slaneCd = request.getParameter("slane_cd");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Sub-Allocation and Ratio</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"><!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sub-Allocation and Ratio</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 797;">
					<tr class="h23">
						<td width="35">Lane</td>
						<td width="100"><input type="text" style="width:50;text-align:center;ime-mode:disabled" class="input" required dataformat="uppernum"  maxlength="3" name="slane_cd" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="srch_rlane_cd" width="19" height="20" border="0" align="absmiddle"></td>
	                    <td width="35">Dir.&nbsp;</td>
	                    <td><script language="javascript">ComComboObject("skd_dir_cd", 1, 60, 0, 0);</script></td>					
				</table>
				</td>
			</tr>
		</table>
		<table class="height_5">
			<tr><td></td></tr>
		</table>
		<!-- Tab BG Box  (S) -->
		<table class="search">
			<tr><td class="bg"><!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
	            <!--  Button_Sub (S) -->
	            <table width="100%" class="button"> 
	            <tr><td class="btn1_bg">
	                <table border="0" cellpadding="0" cellspacing="0"><tr>  
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_Row_Add">Row Add</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_Row_Delete">Row Delete</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_Save">Save</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td> 	                                                                       
	                    </tr></table>
	            </td></tr>
	            </table>
	            <!-- Button_Sub (E) -->								
				</td></tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>
		</td></tr>
		</table> 		
		<!-- Tab BG Box  (S) --> <!-- : ( Button : pop ) (S) -->
		<table width="100%" class="button">
			<tr><td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">					
					<td>
					<table class="height_5"><tr><td></td></tr></table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" >
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table class="height_5"><tr><td></td></tr></table>					
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" >
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>															
					<table class="height_5"><tr><td></td></tr></table>					
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" >
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right"></td>
						</tr>
					</table>					
					</td>
				</table>				
			</tr></td>
		</table>		
	</tr></td>
</table>
</form>
</body>
</html>