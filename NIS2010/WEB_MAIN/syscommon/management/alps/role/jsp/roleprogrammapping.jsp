<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_010.jsp
*@FileTitle : 프로그램 매핑
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
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSys010Event"%>

<%
	ComSys010Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	
	String strErrMsg = "";								 //에러메세지
    String strErrCode = "";
	String parent_pgm_no = JSPUtil.getParameter(request, "parent_pgm_no");
	
	boolean showButton = true;
	
	if(!"".equals(parent_pgm_no)){
		if("COM_SEC_0002".equals(parent_pgm_no) || "COM_SEC_0003".equals(parent_pgm_no)){
			showButton = false;
		}
	}

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		    ErrorHandler errHndlr = new ErrorHandler(serverException);
				strErrMsg = errHndlr.loadPopupMessage();
				strErrCode = errHndlr.getCode();
		}else{
			event = (ComSys010Event)request.getAttribute("Event");
		}
	}catch(Exception e) {
	    out.println(e.getMessage());
	}
%>
<html>
<head>
<title>프로그램 매핑</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_menu.css" rel="stylesheet" type="text/css">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">

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
<input type="hidden" name="pgm_no_form">
<input type="hidden" name="parent_pgm_no" value="<%=parent_pgm_no%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
  
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Program Mapping</td></tr>
        </table>

        <!-- : ( Title ) (E) -->
            
        <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:484;"> 
                <tr class="h23">
					           <td width="80">Role Code</td>
					           <td width="150"><input type="text" style="width:70;" class="input" required fullfill name="role_cd" maxlength="4" style="ime-mode:disabled" readOnly></td>
					           <td width="75">Role Name</td>
					           <td width="">&nbsp;<input type="text" style="width:150;" class="input" value="" name="role_nm" maxlength="30"  readOnly></td> 
					       	 </tr>
	       					</table>
	       					
        <!-- : ( Scenario ID ) (E) -->
        
      </tr>
    </table>
    <!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->  
 

    <table class="height_15"><tr><td></td></tr></table>

    <!-- TABLE '#D' : ( Tab BG Box ) (S) -->
      <table class="search" border="0"> 
        <tr><td class="bg_b1">
        
        <table class="height_10"><tr><td></td></tr></table>
        
        <table class="search" border="0">
          <tr>
          <td valign="top">
              <table class="search" border="0">
                <tr><td class="title_h"></td>
                  <td class="title_s">Menu List</td></tr>
                <tr><td class="height_10"></td></tr>
                <tr><td></td></tr>
              </table>
              <table class="search" border="0">
							<tr>
								<td>
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!--  <input type="checkbox" name="showAll0" class="trans" onClick="chkBox('0',this.checked)">
									Show mapped menu only-->
									<!-- <a href="javascript:chkBox2('S', true);">Show All Offices</a>-->
								</td>
							</tr>
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
        
        <table class="search" border="0">
          <tr>
          <td valign="top">
              <table class="search" border="0">
                <tr><td class="title_h"></td>
                  <td class="title_s">Program List</td></tr>
                <tr><td class="height_5"></td></tr>
              </table>
              
              <table class="search" border="0">
                <tr>
                	<td>
                		<input type="checkbox" name="showAll1" class="trans" onClick="chkBox('1',this.checked)">
                		Show mapped program only
                		<!-- <a href="javascript:chkBox2('S', true);">Show All Offices</a>-->
                	</td>
                </tr>
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


<table class="height_10"><tr><td></td></tr></table> 
  
  
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
<% if(showButton){ %> 
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right">
                </tr></table></td>
<% } %>
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
    <!--Button (E) -->
  </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->      
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