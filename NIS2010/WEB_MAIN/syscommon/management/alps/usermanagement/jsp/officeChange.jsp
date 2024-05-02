<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_COM_SYS_015.jsp
*@FileTitle : 오피스 체인지
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-19
*@LastModifier : SeongWook LEE
*@LastVersion : 1.0


=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.user.event.UiComSys015Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>

<%
	UiComSys015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
  	String strErrCode = "";							  //DB ResultSet 리스트의 건수
	String authTypes = "";
	String admin_page = "";
	
	SignOnUserAccount account = null;
  
	try {
	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    event = (UiComSys015Event)request.getAttribute("Event");		
	    admin_page = (String)event.getAdmin_page();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		    ErrorHandler errHndlr = new ErrorHandler(serverException);
				strErrMsg = errHndlr.loadPopupMessage();
				strErrCode = errHndlr.getCode();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
     		authTypes = eventResponse.getETCData("authTypes");
		} // end else
	}catch(Exception e) {
	    out.println(e.getMessage());
	}
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<% if(event.getFormCommand().isCommand(FormCommand.MODIFY)) { %>
<script language="javascript">

// 2011.04 14 Hyunsu 
//opener.top.signature('On');
self.close();

</script>
<% } else {%>
<script language="javascript">

  var authTypes = "<%=authTypes%>";
  var temp = authTypes.split(":");
  var texts = temp[0].split("|");
  var values = temp[1].split("|");

  function setupPage(){
  	
    var errMessage = "<%=strErrMsg%>";
    var errCode = "<%=strErrCode%>";
         
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    if(errCode=="COM10004"){
    	opener.top.signature('On');
    	self.close();
    }else{
      //setAuthType();
      //setSubSystemCode('ENIS');
      loadPage();
    }
  }

  function setAuthType() {
      var selectObject = document.form.auth_type;
      
      if (selectObject.options[0]==null) {
        addOption(selectObject,"","");
        for(i=0;i<texts.length;i++){
          addOption(selectObject,texts[i],values[i]);
        }
      }
  }
  
  function addOption(selectObject,optionText,optionValue) {
      var optionObject = new Option(optionText,optionValue);
      var optionRank = selectObject.options.length;
      selectObject.options[optionRank]=optionObject;
  }

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">

<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="admin_page" value="<%=admin_page%>">
<input type="hidden" name="default_ofc_cd">
<input type="hidden" name="cng_ofc_cd">
<input type="hidden" name="cng_ofc_flg">
<input type="hidden" name="login_ofc_cd" value="<%= account.getOfc_cd() %>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search" > 
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="6%">User ID</td>
					<td width="25"><input type="text" name="usr_id" style="width:100" value=""></td>
					<td width="9%">User Name</td>
					<td width="25%"><input type="text" name="usr_nm" style="width:100" value=""></td>
          <td width="12%">&nbsp;</td>
          <td width="33%">&nbsp;</td></tr> 
				</table>
				<!-- : ( Scenario ID ) (E) -->
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->	
		
			
		<table class="height_10"><tr><td></td></tr></table>


		
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		
			<table class="search" border="0" width="979"> 
				<tr><td class="bg">
				
				<table class="height_10"><tr><td></td></tr></table>
				
				<!-- : ( Grid ) (S) -->
    			<table width="100%" id="mainTable">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet1');</script>
                    </td></tr>
                </table>
				<!-- : ( Grid ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
<%
	
	if(!"Y".equals(admin_page)) {
// 2011.03.02 류현수 Hyunsu 
//		if ( event.getUsr_id().equals(account.getUsr_id()) || account.getUsr_auth_tp_cd().equals("A") ) {
		if ( event.getUsr_id().equals(account.getUsr_id()) ) {

%>	
			<table width="100%" class="sbutton"> 
	       	<tr>
	       	<td> To set a default login office and login to it at the same time, check a default login office and click ‘Select’ button. </td>
	       	<td class="align">
	
			    <table class="sbutton"> 
			    <tr>
				<td>
			    	<table border="0" cellpadding="0" cellspacing="0"><tr>
			    		
						<td> <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_select">Select</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<%
		}
	} else {
%>
			<table width="100%" class="sbutton"> 
	       	<tr>
	       	<td class="align">
	
			    <table class="sbutton"> 
			    <tr>
				<td>
			    	<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><input type="text" name="addrows" size="3" value="1"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<% 
	}
%>
					</tr>
				</table>
				</td>
          </tr>
				</table>
	    
			</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->
				<table class="height_10"><tr><td></td></tr></table>
							
							
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
	
</td></tr>
</table> 
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><%if("Y".equals(admin_page)&&account.getUsr_auth_tp_cd().equals("A")) { %>
       		<td class="btn">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
       		</td></tr>
       		</table>
			</td><%} %>
       		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
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
<!-- OUTER - POPUP (E)nd -->

</form>
</body>
<SCRIPT LANGUAGE="javascript">
<!--
	  /* 
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
	  */
		<%
		if ( !admin_page.equals("Y")){ 
			String usr_id = event.getUsr_id(); 
			String usr_nm = event.getUsr_nm();
		%>
		document.form.usr_id.value = "<%= usr_id.equals("ALL") ? "" : usr_id %>";
	    document.form.usr_nm.value = "<%= usr_nm.equals("ALL") ? "" : usr_nm	 %>";
	    document.form.usr_id.readOnly = true;
	    document.form.usr_nm.readOnly = true;

		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//sheetObjects[0].DoSearch4Post("searchUserManagementOfcCng.do", FormQueryString(document.form));
		<% } %>
	if (document.getElementById("title").innerHTML == 'null') {
		document.getElementById("title").innerHTML = '&nbsp; Office Change';
		document.title = 'Office Change';
	}
	  setupPage();

-->
</SCRIPT>
</html>
<% } %>
