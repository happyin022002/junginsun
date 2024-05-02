<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_006.jsp
*@FileTitle : 사용자, 역할, 프로그램
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSys006Event"%>
<%
	ComSys006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
  	String strErrCode = "";
	
	try {
		event = (ComSys006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		    ErrorHandler errHndlr = new ErrorHandler(serverException);
				strErrMsg = errHndlr.loadPopupMessage();
				strErrCode = errHndlr.getCode();
		}
	}catch(Exception e) {
	    out.println(e.getMessage());
	}
%>
<html>
<head>
<title>사용자, 역할, 프로그램</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_menu.css" rel="stylesheet" type="text/css">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    var errCode = "<%=strErrCode%>";
    if (errMessage.length >= 1) {
      ComFuncErrMsg(errMessage);
    } // end if
    if(errCode=="COM10004"){
      gotoMainPage();
    }else{
      //setSubSystemCode('ENIS');
      loadPage();
    }
  }

  function gotoMainPage() {
    try {
      if(opener != null){
          if (opener.document != null) {
            opener.top.location.href = "SignOn.do";
            self.window.close();
          }
      }
      //프레임셋에서 탑프레임으로 로그인화면 출력
      //2007.01.23 김성욱
      if(window.top.frames != null && window.top.frames.length>0){
        window.top.location.href = "SignOn.do";
      }else{
        document.location.href = "SignOn.do";
      }
    } catch (e) {
      
    }
  }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
	
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" width="100%"> 
				<tr class="h23">
					<td>User ID</td>
					<td><input type="text" name="usr_id" style="width:100" value=""></td>
					<td>User Role ID</td>
					<td><input type="text" name="usr_role_cd" style="width:100" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');"></td>
					<td>Program ID</td>
					<td><input type="text" name="pgm_no" style="width:100" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum','95');"></td></tr> 
				<tr class="h23">
					<td>User Name</td>
					<td><input type="text" name="usr_nm" style="width:100" value=""></td>
					<td>User Role Name</td>
					<td><input type="text" name="usr_role_nm" style="width:100" value=""></td>
					<td>Program Name</td>
					<td><input type="text" name="pgm_nm" style="width:100" value=""></td></tr> 
				</table>
				<!-- : ( Scenario ID ) (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							
				<!-- : ( Grid ) (S) -->
    			<table width="100%" id="mainTable">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet');</script>
                    </td></tr>
                </table>
				<!-- : ( Grid ) (E) -->
							
							
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
	
</td></tr>
</table> 
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				</td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	
	
	</td></tr>
		</table>

</form>
</body>
</html>