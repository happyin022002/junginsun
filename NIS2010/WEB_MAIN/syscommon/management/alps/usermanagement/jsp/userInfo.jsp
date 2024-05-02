<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : userInfo.jsp
*@FileTitle : 사용자 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009-09-03 정인선
* 1.0 최초 생성
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.syscommon.management.alps.user.vo.ComUserInfoVO"%>
<%@ page import="java.util.List"%>

<%
	SignOnUserAccount account = null;
	ComUserInfoVO comuser = new ComUserInfoVO();
	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	Object obj = (Object)eventResponse.getCustomData("ComUserInfoVO");
	List<ComUserInfoVO> rsVoList = (List<ComUserInfoVO>)obj;	
%>


<html>
<head>
<title>User Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript" type="text/javascript" src="syscommon/management/alps/usermanagement/script/officeChange.js"></script>
<body> 
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Ocean Route Creation - Auto Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<!-- : ( Grid ) (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr>
						<td width="30%" class="tr2_head">Name</td>
						<td width=""><input type="text" style="width:100%;" class="noinput" name="UsrNm" readonly></td>
					</tr>
					<tr>
						<td width="" class="tr2_head">Id</td>
						<td width=""><input type="text" style="width:100%;" class="noinput"  name="UsrId" readonly></td>
					</tr>
					<tr>
						<td width="" class="tr2_head">Dept.</td>
						<td width=""><input type="text" style="width:100%;" class="noinput" name="OfcKrnNm" readonly></td>
					</tr>
					<tr>
						<td width="" class="tr2_head">Office</td>
						<td width=""><input type="text" style="width:100%;" class="noinput" name="OfcCd" readonly></td>
					</tr>
					<tr>
						<td width="" class="tr2_head">SALES REP. CODE</td>
						<td width=""><input type="text" style="width:100%;" class="noinput" name="SrepCd" readonly></td>
					</tr>
					<tr>
						<td width="" class="tr2_head">Fax</td>
						<td width=""><input type="text" style="width:100%;" class="noinput" name="FaxNo" readonly></td>
					</tr>
					<tr>
						<td width="" class="tr2_head">E-mail</td>
						<td width=""><input type="text" style="width:100%;" class="noinput" name="UsrEml" readonly></td>
					</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				
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
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td></tr>
			</table>

		</td></tr>
	</table>
</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			
</body>
<SCRIPT LANGUAGE="javascript">
<!--
		<%
		if ( rsVoList.size() > 0){ 
			comuser = rsVoList.get(0);
			String usrId = comuser.getUsrId();
			String usrNm = comuser.getUsrNm();
			String ofcKrnNm = comuser.getOfcKrnNm();
			String ofcCd = comuser.getOfcCd();
			String srepCd = comuser.getSrepCd();
			String faxNo = comuser.getFaxNo();
			String usrEml = comuser.getUsrEml();
		%>
		eval("UsrId").value = "<%= usrId %>";
	    eval("UsrNm").value = "<%= usrNm %>";
	    eval("OfcKrnNm").value = "<%= ofcKrnNm %>";
	    eval("OfcCd").value = "<%= ofcCd %>";
	    eval("SrepCd").value = "<%= srepCd %>";
	    eval("FaxNo").valuee = "<%= faxNo %>";
	    eval("UsrEml").value = "<%= usrEml %>";
		<% } else {%>
			alert('User information is not.');
			self.close();
		<%}%>
-->
</SCRIPT>
</html>
