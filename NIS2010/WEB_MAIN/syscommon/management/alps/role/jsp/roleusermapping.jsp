<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_009.jsp 
*@FileTitle : 사용자 매핑
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
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSys009Event"%>
<%
	ComSys009Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
    String strErrCode = "";
	
	try {
		event = (ComSys009Event)request.getAttribute("Event");
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
<title>사용자 매핑</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_menu.css" rel="stylesheet" type="text/css">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:loadPage();">
<form name="form">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="ofc_cd">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
  
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Role User Mapping</td></tr>
        </table>

        <!-- : ( Title ) (E) -->
            
        <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:684;"> 
                <tr class="h23">
					           <td width="80">Role Code</td>
					           <td width="150"><input type="text" style="width:70;" class="input" required fullfill name="role_cd" maxlength="4" style="ime-mode:disabled" readOnly></td>
					           <td width="75">Role Name</td>
					           <td width="">&nbsp;<input type="text" style="width:150;" class="input" value="" name="role_nm" maxlength="30"  readOnly></td>
					           <td>&nbsp;
					           <input type="checkbox" name="showAll" class="trans" onClick="chkBox(this.checked)">Show mapped role only
									
									</td>
					          
									
							
					       	 </tr>
	       					</table>
        <!-- : ( Scenario ID ) (E) -->
        
      </tr>
    </table>
    <!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->  

    <table class="height_15"><tr><td></td></tr></table>

    <!-- TABLE '#D' : ( Tab BG Box ) (S) -->
      <table class="search" border="0" width="580"> 
        <tr><td class="bg_b1">
        
        <table class="height_10"><tr><td></td></tr></table>
        
        <table class="search" border="0" width="580">
          <tr>
          <td width="100%" valign="top">
              <table class="search" border="0">
                <tr><td class="title_h"></td>
                  <td class="title_s">Office List</td></tr>
                <tr><td class="height_5"></td></tr>
              </table>
              <table width="100%" id="mainTable">
                  <tr><td>
                       <script language="javascript">ComSheetObject('sheet1');</script>
                  </td></tr>
              </table>
          </td>
          </tr>
        </table>
        
        </td>
        <td class="bg_b1">
        
        <table class="height_10"><tr><td></td></tr></table>
        
        <table class="search" border="0" width="580">
          <tr>
          <td width="100%" valign="top">
              <table class="search" border="0">
                <tr><td class="title_h"></td>
                  <td class="title_s">User List</td></tr>
                <tr><td class="height_5"></td></tr>
              </table>
              <table width="100%" id="mainTable">
                  <tr><td>
                       <script language="javascript">ComSheetObject('sheet2');</script>
                  </td></tr>
              </table>
          </td>
          </tr>
        </table>
        
        </td></tr>
      </table>
      <!-- TABLE '#D' : ( Tab BG Box ) (E) -->
    <table class="height_5"><tr><td></td></tr></table>
      
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
				</tr></table></td>
	        </tr>
	    	</table>
	    <!--Button (E) -->
	    </td></tr>
		</table>
	<!-- : ( Button : pop ) (E) -->
	</td></tr>
	</table>
	
</td></tr>
</table>

</form>
</body>
</html>
<SCRIPT LANGUAGE="javascript">
<!--
	  with(document.form) {
  		<%
  		if(event != null){ 
  			String role_cd = event.getRoleCd();
        String role_nm = event.getRoleNm();
  		%>
  		eval("role_cd" ).value = "<%= role_cd	 %>";
      eval("role_nm" ).value = unescape("<%= role_nm  %>");
  		<% } %>
	  }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
