<%/*=========================================================
*Copyright(c) 2012 CyberLogitec 
*@FileName : EES_MNR_0265.jsp
*@FileTitle : Write off ApprovalRoute Manager Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05	 
*@LastModifier : 한종희	 
*@LastVersion : 1.0 
* 2013.09.05 한종희 
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.event.EesMnr0265Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
					   
<% 					
	EesMnr0265Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= ""; 
	String strUsr_nm		= "";   
	String rhqOfcCd         = ""; 
	String currOfcCd        = "";
	String strRhq_ofc_cd    = "";
	String currOfcEngNm     = ""; 
	Logger log = Logger.getLogger("com.hanjin.apps.generalmanage.approvalmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0265Event)request.getAttribute("Event");
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
<title>Write Off Approval Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	var usrId     = "<%=strUsr_id.trim()%>";
	var currOfcUS = "";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">   
<input type="hidden" name="pagerows">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
				
		<!-- 1 (E) -->
		<!-- 3 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable">
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<td width="30%" valign="top">
					<table class="search_" border="0" style="width:400;"> 
						<tr class="h23">
							<td width="100">Working Type</td>
							<td class="stm">
								<input type="radio" name="working_type" value="P" class="trans" checked>Only PIC Update
								<input type="radio" name="working_type" value="A" class="trans"  >Office Level Add/Del
						</tr>
					</table> 
				</td>
				<td width="30%" valign="top">
						<table class="search_" border="0" style="width:300;">
							<tr class="h23">
								<td width="95" style="text-align:left">Office</td>	
								<td width="" style="padding-left:2"> 
								<script language="javascript">ComComboObject('ofc_cd', 2, 80, 0, 1, '', 0, '');</script>
								</td>
							</tr>
						</table>	
					</td>
				</table>		
			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 2 (E) -->



			<!--  Button_Sub (S) -->
					<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
								</table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownLoad">Down Load</td>
							<td class="btn2_right"></td>
							</tr>
								</table>
							</td>

							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>
		
	
</td>
</tr>
</table>
<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>

</form>
</body>
</html>