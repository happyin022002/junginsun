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
<%@ page import="com.hanjin.syscommon.management.alps.user.event.UserManagementEvent"%>
<%@ page import="com.hanjin.syscommon.management.alps.user.vo.ComUserVO"%>

<%
	UserManagementEvent  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
 	String strErrCode = "";
	String authCode = "R";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	authCode = account.getUsr_auth_tp_cd();

	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		    ErrorHandler errHndlr = new ErrorHandler(serverException);
				strErrMsg = errHndlr.loadPopupMessage();
				strErrCode = errHndlr.getCode();
		}else{
			event = (UserManagementEvent)request.getAttribute("Event");
		}
	}catch(Exception e) {
	    out.println(e.getMessage());
	}
%>
<html>
<head>
<title>User Program Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    var errCode = "<%=strErrCode%>";
    if (errMessage.length >= 1) {
      ComShowErrMessage(errMessage);
    } // end if
    if(errCode=="COM10004"){
    	opener.top.signature('On');
    	self.close();
    }else{
      //setSubSystemCode('ENIS');
      loadPage();
    }
  }

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="pgm_no_form">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="usr_auth_tp_cd">
<input type="hidden" name="login_usr_auth_tp_cd" value="<%=authCode%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
  
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> User Program Mapping</td></tr>
        </table>

        <!-- : ( Title ) (E) -->
            
        <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:484;"> 
                <tr class="h23">
					           <td width="80">User ID</td>
					           <td width="150"><input type="text" style="width:70;" class="input" required fullfill name="usr_id" maxlength="20" style="ime-mode:disabled" readOnly></td>
					           <td width="75">User Name</td>
					           <td width="">&nbsp;<input type="text" style="width:150;" class="input" value="" name="usr_nm" maxlength="100"  readOnly></td> 
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
                  <td class="title_s">Menu List</td></tr>
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
                  <td class="title_s">Program List</td></tr>
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


<table class="height_10"><tr><td></td></tr></table> 
  
  
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><% if ( !authCode.equals("R") ) { %>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right">
                </tr></table></td><% } %>
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
	String usrId = "";
	String usrNm = "";
	String ofcCd = "";
	String usrAuthTpCd = "";
    
	if(event != null){
		ComUserVO comuservo = new ComUserVO();
		comuservo = event.getComUserVO();
 				
        if(comuservo!=null){
			usrId = comuservo.getUsrId();
			usrNm = comuservo.getUsrNm();
			ofcCd = comuservo.getOfcCd();
			usrAuthTpCd = comuservo.getUsrAuthTpCd();
		}
	}
%>
  		eval("usr_id" ).value = "<%= usrId	 %>";
        eval("usr_nm" ).value = unescape("<%= usrNm  %>");
        eval("ofc_cd" ).value = "<%= ofcCd  %>";
        eval("usr_auth_tp_cd" ).value = "<%= usrAuthTpCd  %>";
	  }
-->
</SCRIPT>