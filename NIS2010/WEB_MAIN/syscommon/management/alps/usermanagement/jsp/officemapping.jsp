<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_SYS_013.jsp
*@FileTitle : 사용자 조직 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-10
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2007-01-10 SeongWook Kim
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
<%@ page import="com.hanjin.syscommon.management.alps.user.event.UserManagementEvent"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
  	String strErrCode = "";
  	UserManagementEvent event = null;

	try {
		event = (UserManagementEvent)request.getAttribute("Event");
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
<title>사용자 조직 조회</title>
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
      gotoMainPage();
    }else{
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
  
<%
  /**
   * 팝업window에서 필수입력 사항
   * 팝업window에서 opener로 값을 리턴하기 위한 자바스크립트 공통함수 settingData를 생성
   * settingData는 opener의 폼 element에 값을 리턴하는 경우에 사용
   * settingDataIBSheet는 opener의 IBSheet에 값을 리턴하는 경우에 사용
   * settingData함수 사용예는 CodePopupJSP.js의 sheet1_OnDblClick 함수를 참조하세요
   */
//    if(sheetObj.equals("")){
//      out.println(JSPUtil.getPopupSettingData(returnObjectIndexs,formName));
//    } else {
//      out.println(JSPUtil.getPopupSettingDataIBSheet(returnObjectIndexs,0,sheetObj,sRow));
 //			 }
%>
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="rhq" value="<%=event.getVO("rhq")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
   <!-- : ( Title ) (S) -->
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
       <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
       <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Office Mapping</td></tr>
   </table>
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
        <!-- 
		<table class="search"> 
			<tr>
				<td class="bg_a">

				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="20%"><img class="star">HQ Office Code</td>
					<td width="20%"><input type="text" name="hq_ofc_cd" style="width:100" value="" readonly></td>
          <td width="20%"><img class="star">HQ Office Name</td>
          <td width="40%"><input type="text" name="hq_ofc_nm" style="width:200" value="" readonly></td></tr> 
				</table>
				
			</tr>
		</table>
         -->
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
							
							<!-- : ( Grid ) (S) -->
                			<table width="100%" id="mainTable">
                                <tr><td><div id="ibsheet">
                                     <script language="javascript">ComSheetObject('sheet1');</script></div>
                                </td></tr>
                            </table>
							<!-- : ( Grid ) (E) -->
							
					</td>
					</tr>
				
				</table>
				
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
			
	
</td></tr>
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
                    <td class="btn1" name="btn_confirm">Confirm</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
                
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
    //if(event != null){ 
    	//String usr_id   = event.getUsr_id();
      //String usr_nm   = event.getUsr_nm();
    %>
    //eval("usr_id" ).value = "<--%= usr_id   %-->";
    //eval("usr_nm" ).value = "<--%= usr_nm   %-->";
    <% //} %>
     }
-->
</SCRIPT>
<%@ include file="/bizcommon/include/common_alps.jsp" %>
