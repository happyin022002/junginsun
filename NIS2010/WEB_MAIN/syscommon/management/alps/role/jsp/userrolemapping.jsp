<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : UI_COM_SYS_008.jsp
*@FileTitle : 역할 매핑
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
<%@ page import="com.hanjin.syscommon.management.alps.role.event.ComSys008Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	ComSys008Event  event = null;
	GeneralEventResponse eventResponse = null;
	DBRowSet rowSet	  = null;
	int rowCount	 = 0;
	Exception serverException   = null;			//서버에서 발생한 에러
	
	String strErrMsg = "";								 //에러메세지
	String strErrCode = "";
	String parent_pgm_no = JSPUtil.getParameter(request, "parent_pgm_no");
	
	boolean showButton = true;
	
	if(!"".equals(parent_pgm_no)){
		if("COM_SEC_0001".equals(parent_pgm_no)){
			showButton = false;
		}
	}
	
	String login_usr_auth_tp_cd = "";
	String usr_auth_tp_cd = "";
	String usr_role_adm_mtch = "";
	boolean kukuMenu = false;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	login_usr_auth_tp_cd  = account.getUsr_auth_tp_cd();

	   	if(account.getOfc_cd().equalsIgnoreCase("SELXWP") || account.getOfc_cd().equalsIgnoreCase("SELXWO")){
	   		kukuMenu = true;
	   	}
	   	
		event = (ComSys008Event)request.getAttribute("Event");		
		
		if(event != null){ 
	    	usr_role_adm_mtch = event.getUsrRoleAdmMtch();
	    	usr_auth_tp_cd = event.getUsrAuthTpCd();
		}
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		    ErrorHandler errHndlr = new ErrorHandler(serverException);
				strErrMsg = errHndlr.loadPopupMessage();
				strErrCode = errHndlr.getCode();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		}// end else
	}catch(Exception e) {
	    out.println(e.getMessage());
	}
%>

<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%><html>
<head>
<title>User Role Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/alps_menu.css" rel="stylesheet" type="text/css">
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    var errCode = "<%=strErrCode%>";
    if (errMessage.length >= 1) {
        ComShowMessage(errMessage);
    } // end if
    if(errCode=="COM10004"){
    	opener.top.signature('On');
    	self.close();
    }else{
        loadPage();
    }
  }
 
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">  
<input type="hidden" name="login_usr_auth_tp_cd" value="<%=login_usr_auth_tp_cd%>">  
<input type="hidden" name="usr_auth_tp_cd" value="<%=usr_auth_tp_cd%>">  
<input type="hidden" name="usr_role_adm_mtch" value="<%=usr_role_adm_mtch%>">
<input type="hidden" name="admin_page" value="<%=JSPUtil.getParameter(request, "admin_page")%>">
<input type="hidden" name="parent_pgm_no" value="<%=parent_pgm_no%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
   <!-- : ( Title ) (S) -->
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<% if("Y".equals(usr_role_adm_mtch)) { %>
       <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Manage Role Mapping</td></tr>
<% } else { %>
       <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> User Role Mapping</td></tr>
<% } %>
   </table>
		<!-- : ( Title ) (E) -->
		

      <table class="search"> 
          <tr><td class="bg">
              <!--  biz_1  (S) -->
              <table class="search" border="0" style="width:100%;"> 
              	<tr class="h23">
		           <td width="80">User ID</td>
		           <td width="150"><input type="text" style="width:70;" class="input" required fullfill name="usr_id" maxlength="4" style="ime-mode:disabled" readOnly></td>
		           <td width="75">User Name</td>
		           <td width="">&nbsp;<input type="text" style="width:150;" class="input" value="" name="usr_nm" maxlength="30"  readOnly></td>
		           <td width="75">99 Menu</td>
			       <td width="">
			           	<select id="view_flg" name="view_flg">
			           		<option value="Y">Y</option>
			           		<option value="N">N</option>
			           	</select>
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
									<td class="title_s">Role List</td></tr>
								<tr><td class="height_5"></td></tr>
							</table>
							
							<!-- : ( Grid ) (S) -->
                			<table width="100%" id="mainTable">
                                <tr><td>
                                     <script language="javascript">ComSheetObject('sheet1');</script>
                                </td></tr>
                            </table>
							<!-- : ( Grid ) (E) -->
     			</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
	
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><% if ( !login_usr_auth_tp_cd.equals("R") ) { %>
<% if(showButton){ %>
                <td id="tdSave"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
<% } %>
            	<% } %>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<% if(kukuMenu){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_viewflg">99MenuSave</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<%} %>
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
    with(document.form)
    {
    <%
    if(event != null){ 
    	String usrId   = event.getUsrId();
      String usrNm   = event.getUsrNm();
      
    %>
    eval("usr_id" ).value = "<%= usrId   %>";
    eval("usr_nm" ).value = unescape("<%= usrNm   %>");
    <% } %>
     }
-->
</SCRIPT>