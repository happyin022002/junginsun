<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ess_mnr_0145.jsp
*@FileTitle : EQ Component Code Grouping by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.11 김완규
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%  
    //부모창에서 파라메터 받아오기
    String eqCmpoCd	  	= "";
    String eqCmpoNm	  	= "";
    String eqCmpoDesc	= "";
    String strMnrOfficeLevel = "";
    if(request.getParameter("eqCmpoCd")!=null) {
    	eqCmpoCd 	= JSPUtil.getParameter(request, "eqCmpoCd");
    	eqCmpoNm 	= JSPUtil.getParameter(request, "eqCmpoNm");
    	eqCmpoDesc	= request.getParameter("eqCmpoDesc");
    	strMnrOfficeLevel = request.getParameter("strMnrOfficeLevel");
    }
    
	EesMnr0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAccess_System		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strAccess_System = account.getAccess_system();
	   
		event = (EesMnr0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>EQ Component Grouping by Location & Damage Type</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var strMnrOfficeLevel = "<%=strMnrOfficeLevel.trim() %>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">
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
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   EQ Component Grouping by Location & Damage Type</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="120">Component Code</td>
					<td width="70"><input type="text" name="eq_cmpo_cd" style="width:60;text-align:center;" class="input2" value="<%= eqCmpoCd%>" readonly></td>
					<td><input type="text" name="eq_cmpo_desc" style="width:450;" class="input2" value="<%= eqCmpoNm%>" readonly></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->


		</td></tr>
		</table>
		<!-- 1 (E) -->

		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">

			<!-- Grid 1,2,3 (S) -->
			<table class="search">
			<tr>
				<td valign="top" width="34%">
					<!-- Title -->
					<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s">Grouping By Location</td></tr>
					</table>
					<!-- Title -->	
					<!-- Grid - 1 (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>	
						</tr>
					</table>
					<!-- Grid - 1 (E) -->
				</td>
				
				<td valign="top" width="33%" style="padding-left:10px;">
					<!-- Title -->	
					<table class="search" border="0">	
					<tr><td class="title_h"></td>
						<td class="title_s">Grouping By Damage Type</td></tr>
					</table>	
					<!-- Title -->	

					<!-- Grid - 2 (S) -->	
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					<!-- Grid - 2 (E) -->
				</td>	
									
				<td valign="top" width="33%" style="padding-left:10px;">
					<!-- Title -->
					<table class="search" border="0">	
					<tr><td class="title_h"></td>		
						<td class="title_s">Grouping By Repair Type</td></tr>
					</table>
					<!-- Title -->

					<!-- Grid - 1 (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
				<!-- Grid - 1 (E) -->
				</td>
				</tr>
			</table>
			<!-- Grid 1,2,3 (E) -->

		</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->
		
<table class="height_5"><tr><td></td></tr></table>
		
</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" border=0>
<tr><td height="71" class="popup">

    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       	<tr>
	       	   <td class="btn3_bg" align="right">
				    <table border="0" cellpadding="0" cellspacing="0">
				      <tr>
				      	<%if(strAccess_System.equals("ALP")){ %>
				         <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right">
						    </tr></table></td>
					     <td class="btn1_line"></td>
					   <%}%>
					     <td class="btn3_bg">
				          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right">
					      </tr></table>
						 </td>
					</tr>
				</table></td>
					</tr>
				</table>
    	<!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>