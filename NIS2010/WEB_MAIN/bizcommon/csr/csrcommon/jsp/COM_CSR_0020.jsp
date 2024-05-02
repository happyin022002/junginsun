<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_CSR_0020.jsp
*@FileTitle : Approval Step & Comments
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.21 9014787
* 1.0 Creation
*----------------------------------------------------------
* History
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0020Event"%> 
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
	ComCsr0020Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	
    
	
	try {
		/*
		꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나 
		권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
		덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
		jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
		command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.
			 
		주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
			SignOnUserAccount 의 메서드를 확인 하십시오.
			getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠?   
	   */ 
	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 
	   
	   
		/* 
		일단 화면에서 USER가 입력한 정보를 다시 화면에서 사용해야 하는 경우 
		request에 담아 서버로 전송시켰다가 다시 그 request에서 받아야 한다고 했습니다.
		이때 유저가 작성한 자료는 event 에 서버로부터 전송된 자료는 eventResponse에 담기게 됩니다.
		이렇게 받은 정보는 jsp 맨 하단에 있는 java script로부터 폼의 value로 값을 전달하게 됩니다.
		본 jsp소스 맨 하단을 참조하십시오.
		*/
		event = (ComCsr0020Event)request.getAttribute("Event");
		/* 
			ErrorHandler를 통해서 받는 에러는 CO_ERRMESSAGE 테이블에 입력되어있는 
			개발자가 정의했거나 공통팀에서 결정한 정의가 되어진 에러메세지입니다 
			Command 에서 EventException으로 throw를 했거나 DAO에서 DAOException을 통해 
			jsp 까지 전달이 되게 됩니다. 해당 파일을 참조하십시오.
			jsp에서 최후에 에러가 display될때 onload시에 실행되는 ShowErrMessage 를 통해 showErrMessage();가 뜨게 됩니다.
			(주의) 이 에러메세지와 자바스크립트 에러를 혼동하지는 마십시오. 
				자바스크립트 에러는 서버로 전송하기전에 "주민등록번호가 잘못되었습니다" 라는 메세지이고 
				throw되는 메세지는 update 를 하려고 권한을 확인해보니까 없어서 
				"해당 권한이 없습니다" 라고 뿌리는 메세지입니다.
		*/
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		/* 
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다. 
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다. 
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Approval Step & Comments</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="apro_rqst_no">
<input type="hidden" name="btn_flag">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/ico_t1.gif" width="20" height="12">Approval Step & Comments</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">



			<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
	                                      <tr><td>
	                                             <script language="javascript">ComSheetObject('sheet1');</script>
	                                      </td></tr>
	                </table>
			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->



<table class="height_5"><tr><td></td></tr></table>


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
				<td id="td_btn_apro" style="display:none"><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_apro" id="btn_apro">Approve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
				<td id="td_btn_dapro" style="display:none"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_dapro" id="btn_dapro">Disapprove</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
				<td id="td_btn_save" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_save" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="td_btn_line" style="display:none" class="btn1_line"></td>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close" id="btn_close">Close</td>
					<td class="btn1_right"></td>
					
					<!-- <td class="btn1_left"></td>
					<td class="btn1" name="btn_EditMode">EditMode</td>
					<td class="btn1_right"></td> --> 
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
<SCRIPT LANGUAGE="javascript">
<!--
<%
	String apro_rqst_no   	= "";
	
	if(event != null){ 
		apro_rqst_no   = event.getApprovalComVO().getAproRqstNo();
	}
%>
	/* 
	ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
	 */
	with(document.form)
	{
		eval("apro_rqst_no" ).value = "<%=apro_rqst_no%>";
	}
	
	// btn_flag N 이 아닐경우 버튼을 보이도록 처리한다.
	var btn_flag = "<%=request.getParameter("btn_flag")%>";
	if(btn_flag == null || btn_flag != "N"){
		var target;

		if(btn_flag == null || btn_flag != "D"){
			target = document.getElementById('td_btn_apro');
			target.style.display = "block";
		}
		
		target = document.getElementById('td_btn_dapro');
		target.style.display = "block";
		
		target = document.getElementById('td_btn_save');
		target.style.display = "block";
		
		target = document.getElementById('td_btn_line');
		target.style.display = "block";

		var target_btn_flag = document.getElementById('btn_flag');
		// 플레그를 이용해서..comment 저장을 막는다.
		target_btn_flag.value = "Y";
	}
	
		
-->
</SCRIPT>