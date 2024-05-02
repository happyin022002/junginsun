<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0038.jsp
*@FileTitle : Lot No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.17 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0038Event)request.getAttribute("Event");
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
<title>Lot No Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cntr_tpsz_cd">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Lot No Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:596;"> 
				<tr class="h23">
					<td>CNTR No</td>
					<td><input type="text" style="width:100;" class="input" value="" name="cntr_no" maxlength="10" dataformat="engup"></td>
				</tr>
				<tr class="h23">
					<td width="90">Delivery Year</td>
					<td width="180"><input type="text" style="width:100;" class="input" value="" name="de_yrmon" maxlength="4" dataformat="int"></td>
					<td width="50">TP/SZ</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('combo1', 1, 90, 1);</script></td>
				</tr>
				</table>				
				</td> 
			</tr></table>
			<table class="height_10"><tr><td></td></tr></table>
			
			<table class="search"> 
       		<tr><td class="bg">	
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- : ( Grid ) (E) -->	
			<!--  Button_Sub (S) -->
								<table width="100%" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_retrieve">Retrieve</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_new">New</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
											
									</table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
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
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ok">OK</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@ include file="/bizcommon/include/common_nis2010.jsp"%>