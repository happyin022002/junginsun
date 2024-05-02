<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_011.jsp
*@FileTitle : 프로그램별 역할 매핑
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
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSys011Event"%>
<%
	ComSys011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
  String strErrCode = "";
	
	try {
	   
		event = (ComSys011Event)request.getAttribute("Event");
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
<title>Role Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/hanjin/script/wait.js"></script>
<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    var errCode = "<%=strErrCode%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
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
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">  

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Role Mapping</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg_b1">

				<table class="height_10"><tr><td></td></tr></table>

					<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="15%">&nbsp;Program No</td>
							<td width="20%"><input name="pgm_no" type="text" style="width:100"   readOnly></td>
							<td width="15%">&nbsp;Program Name</td>
							<td><input name="pgm_nm" type="text" style="width:300"  readOnly>&nbsp;</td>
						</tr>
					</table>
				<table class="height_10">
							<tr>
								<td>
									<input type="checkbox" name="showAll" class="trans" onClick="chkBox(this.checked)">
									Show mapped role only
									<!-- <a href="javascript:chkBox2('S', true);">Show All Offices</a>-->
								</td>
							</tr>
							</table>
				
				
				<table class="search" border="0" width="580">
					<tr>
					<td width="100%" valign="top">
							<!-- : ( Grid ) (S) -->
                			<table width="100%" id="mainTable">
                                <tr><td>
                                     <script language="javascript">ComSheetObject('sheet1');</script>
                                </td></tr>
                            </table>
							<!-- : ( Grid ) (E) -->
	
					</td></tr>
				</table>
			</td>
		</tr>
	</table> 
	</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
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
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
    with(document.form)
    {
    <%
    if(event != null){ 
    	String pgm_no   = event.getProg_id();
      String pgm_nm   = event.getProg_nm();
    %>
    eval("pgm_no" ).value = "<%= pgm_no   %>";
    eval("pgm_nm" ).value = "<%= pgm_nm   %>";
    <% } %>
     }
-->
</SCRIPT>