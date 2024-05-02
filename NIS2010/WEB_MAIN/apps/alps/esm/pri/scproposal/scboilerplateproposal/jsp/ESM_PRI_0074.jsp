<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0074.jsp
*@FileTitle : S/C Boiler Plate Creation - Excel Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.06 서호열
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.event.EsmPri0074Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0074Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//부모창에서 넘어온 파라미터
	String sPropNo		= "";
	String sAmdtSeq		= "";
	String mBlplSeq		= "";
	String mDpSeq		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCBoilerPlateProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0074Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sPropNo = request.getParameter("sPropNo");
		sAmdtSeq = request.getParameter("sAmdtSeq");
		mBlplSeq = request.getParameter("mBlplSeq");
		mDpSeq = request.getParameter("mDpSeq");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Boiler Plate Creation - Excel Import</title>
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
<input type="hidden" name="propNo"   value="<%=sPropNo %>">
<input type="hidden" name="amdtSeq"  value="<%=sAmdtSeq %>">
<input type="hidden" name="blplSeq"  value="<%=mBlplSeq %>">
<input type="hidden" name="dpSeq" 	 value="<%=mDpSeq %>">

<table width="1000" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Boiler Plate Excel Import</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       	<tr><td class="bg">

				<!--grid(S)-->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid(E)-->

		</td></tr>
		</table>
		<!-- 1 (E) -->

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;">
    <tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
            <td style="display:none">
            <table width="100%" border="0" cellpadding="0" cellspacing="0"
                class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                </tr>
            </table></td>
	    
    	    <td>
	    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_openfile">Open&nbsp;File</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_check">Check</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			    
			<td class="btn1_line"></td>
			<td>
			<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td></tr>
			</table></td>
			
			<td class="btn1_line"></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_close">Close</td>
				<td class="btn1_right"></td></tr>
			</table></td>
		</tr>
	    </table>
    </td></tr>
	</table>
   	<!--Button (E) -->

</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>