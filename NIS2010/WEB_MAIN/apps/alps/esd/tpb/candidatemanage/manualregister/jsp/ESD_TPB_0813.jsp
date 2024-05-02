<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0813.jsp
*@FileTitle : Select Staff
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.06 박성진
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0813Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0813Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CandidateManage.ManualRegister");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0813Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Select Staff</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00961", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase 
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="bodyright">

			<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->
			
			<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->
			
			
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"></td></tr>
					<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Select Staff</td></tr>
			</table>
			<!--Page Title, Historical (E)--> 

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
			       <tr><td class="btn1_bg">
			             <table border="0" cellpadding="0" cellspacing="0">
			                 <tr><td>
			                       <!—Apply Button (S) -->
			                         <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                            <tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_retrieve">Retrieve</td>
										<td class="btn1_right"></td>
										</tr></table>
			                       <!—Apply Button (E) -->
			                  </td>
			                  <td>
			                       <!—Apply Button (S) -->
			                         <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                            <tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_downexcel">Down Excel</td>
										<td class="btn1_right"></td>
										</tr></table>
			                       <!—Apply Button (E) -->
			                  </td></tr>
			                </table>
			           </td></tr>
			</table>
						
			<!-- TABLE '#D' : ( Button : Main ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search"> 
			<tr><td class="bg">
					<!-- biz_1  (S) -->
					<table class="search" border="0" style="width:430;">
					<tr class="h23">
						<td width="120"><img class="nostar">RHQ <select style="width:80;" name="s_if_rhq_cd">
							<option value="" selected>ALL</option>
							</select>
						</td>
						<td width="150">TPB Office <select style="width:80;" name="s_if_ofc_cd">
							<option value="" selected>ALL</option>
							</select>
						</td>
						<td width="120">Office <input type="text" style="width:80;" name="s_ofc_cd" maxlength="11">
						</td>
					</tr>
					</table>
					<!-- biz_1  (E) -->
									
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) --> 	
			
			<table class="height_10"><tr><td></td></tr></table>
			
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search"> 
				<tr><td class="bg">
			
					
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
						<tr><td>
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
					<!-- : ( POR ) (E) -->
					
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) --> 	

		</td></tr>
	</table>

</td></tr>


</table>

<!--  Button_Sub (S) -->
<table width="100%" class="sbutton"> 
   <tr><td height="71" class="popup">
           <table border="0" cellpadding="0" cellspacing="0">
                <tr><td>                      
                 <!—Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn1_left"></td>
							   <td class="btn1" name="btn_ok">O K</td>
							   <td class="btn1_right"></td>
							  </tr>
                       </table>
                 <!—Row Add   Button (E) -->
              </td>
              <td>                      
                 <!—Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn1_left"></td>
							   <td class="btn1" name="btn_close">Close</td>
							   <td class="btn1_right"></td>
							  </tr>
                       </table>
                 <!—Row Add   Button (E) -->
              </td></tr>
           </table>
    </td></tr>
</table>
<!-- Button_Sub (E) -->
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>