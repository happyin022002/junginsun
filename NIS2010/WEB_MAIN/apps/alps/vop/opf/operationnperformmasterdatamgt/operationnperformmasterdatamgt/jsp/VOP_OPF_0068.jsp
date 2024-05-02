<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0068.jsp
*@FileTitle : TPR Target Ports Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.19 장석현
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
<%@ page import="com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0068Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0068Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationNPerformMasterDataMgt.OperationNPerformMasterDataMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (VopOpf0068Event)request.getAttribute("Event");
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
<title>TPR Target Ports Register</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=strOfc_cd%>');
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="conti_cd" value="">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TPR Target Port Creation </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
	
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="48">RHQ</td>
					<td><script language="javascript">ComComboObject('rhq');</script></td>
					<!-- 
						<select style="width:120;" name="conti_cd" onchange="javascript:doActionIBSheet(sheetObjects, document.form, IBSEARCH);">
						<option value="" selected>All</option>
						<option value="NYCNA">NYCNA</option>
						<option value="HAMUR">HAMUR</option>
						<option value="SHAAS">SHAAS</option>
						<option value="SINWA">SINWA</option></select>					
					-->

				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
			</td></tr>
		</table>
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
			<!-- Grid BG Box  (S) -->
	     	<table class="search" id="mainTable"> 
	       	<tr><td class="bg">
	

				<!-- : Grid - 1,2 (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr><td valign="top" width="48%">
						
					<!-- : Grid - 1 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
					<!-- : Grid - 1 (E) -->				
			
				</td> 
				
				<td width="45" valign="middle" align="center" style="padding-left:5"style="padding-right:5"><img src="img/btns_add.gif" width="26" height="26" alt="" border="0" name="btn_Add"><br><br><img src="img/btns_del.gif" width="26" height="26" alt="" border="0" name="btn_Delete"></td> 

				<td valign="top" width="45%">
				
					<!-- : Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
					<!-- : Grid - 2 (E) -->	

					
				</td></tr>
				</table>
				<!-- : Grid - 1,2 (E) -->

				
				</td></tr>
			</table>
			<!-- Grid BG Box  (S) -->
			
			<table class="height_5"><tr><td></td></tr></table>
	
				</td></tr>
			</table>	
			
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			    <td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
			    <td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

		<!--biz page (E)-->
	
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>