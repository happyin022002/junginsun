<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0084.jsp
*@FileTitle : BSA INPUT
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2011.03.03 원종규
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0084Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0084Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0084Event)request.getAttribute("Event");
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
<title>BSA Creation</title>
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
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;BSA Creation
	</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50"><img class="nostar">Trade</td>
					<td width="70" style="padding-left:2px;">
						<script language="JavaScript">ComComboObject("trd_cd", 2, 60, 0, 1);</script>
					</td>
					<td width="75"><img class="nostar">Sub Trade</td>
					<td width="70" style="padding-left:3">
						<script language="JavaScript">ComComboObject("sub_trd_cd", 3, 50, 0, 0);</script>
					</td>
					<td width="65"><img class="nostar">VVD CD</td>
					<td width="150">
						<input name="vsl_cd" type="text" style="width:40;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_voy_no" type="text" style="width:40;" class="input1" value="" caption="VVD CD" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">&nbsp;<input name="skd_dir_cd" type="text" style="width:20;" class="input1" value="" caption="VVD CD" fullfill required maxlength="1" dataformat="engup" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_vvd">&nbsp;<input name="vsl_eng_nm" type="hidden" style="width:150;" class="input2" value="" readonly="readonly"><input type="text" style="width:0;" name="noname" readOnly>
					</td>
					<td width="78"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				 
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="t1btn_RowAdd">Row add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="t1btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td class="btn1_line"></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table>
				</td>
			</tr>
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