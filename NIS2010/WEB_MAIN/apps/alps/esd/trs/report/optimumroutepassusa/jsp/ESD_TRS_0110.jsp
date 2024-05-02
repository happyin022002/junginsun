<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0110.jsp
*@FileTitle : BKG Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.event.EsdTrs0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	EsdTrs0110Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";

	String strBnd_cd = request.getParameter("bnd_cd");
	String strInput_office = request.getParameter("input_office");
	String strSelOpTp = request.getParameter("sel_op_tp");
	String strBkgNo = request.getParameter("bkg_no");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsdTrs0110Event)request.getAttribute("Event");
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
<title>BKG Detail</title>
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
<input type="hidden" name="load_flg" value="N">
<input type="hidden" name="exl_flg" value="N">

<input type="hidden" name="bnd_cd" value="<%=strBnd_cd%>">
<input type="hidden" name="input_office" value="<%=strInput_office%>">
<input type="hidden" name="sel_op_tp" value="<%=strSelOpTp %>">
<input type="hidden" name="bkg_no" value="<%=strBkgNo %>">

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;BKG Detail
	</td></tr>
	</table>
	<!-- : ( Title ) (E) -->

    <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
    <tr><td class="btn1_bg">
        <table border="0" cellpadding="0" cellspacing="0">
        <tr>
                
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_down_excel">Down Excel</td>
                <td class="btn1_right"></td>
                </tr>
            </table></td>
        </tr>
        </table>
    </td></tr>
    </table>
    <!--Button (E) -->

	<!-- : ( Search Options ) (S) -->

	<table class="height_8"><tr><td></td></tr></table>
	
		
	<table class="search"> 
      <tr><td class="bg">
		<!-- : ( Grid ) (S) -->
		<table width="100%" id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 				
		<!-- : ( Grid ) (E) -->	
		</td>
		</tr>
	</table> 
	<table class="height_10"><tr><td></td></tr></table>

	</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="74" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td width="">
			<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_close">Close</td>
				<td class="btn1_right"></td></tr>
			</table>
			</td>	
			</tr>
		</table>
		</td></tr>
	</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>