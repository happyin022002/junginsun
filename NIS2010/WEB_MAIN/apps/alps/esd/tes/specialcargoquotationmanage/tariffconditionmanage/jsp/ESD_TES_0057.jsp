<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0057.jsp
*@FileTitle : Tariff Condition List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.06
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event.EsdTes0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTes0057Event)request.getAttribute("Event");
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
<% 
String tml_awk_cgo_trf_tp_cd = JSPUtil.getNull(request.getParameter("tml_awk_cgo_trf_tp_cd"));
String ui_id = JSPUtil.getNull(request.getParameter("ui_id"));	

%>
<html>
<head>
<title>Tariff Condition List</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="tml_awk_cgo_cond_tp_cd" value="<%= tml_awk_cgo_trf_tp_cd%>">
<input type="hidden" name="tml_awk_cgo_trf_tp_cd" value="<%= tml_awk_cgo_trf_tp_cd%>">
<input type="hidden" name="ui_id" value="<%= ui_id%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Tariff Condition Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg">	
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:600;"> 
							<tr class="h23">
								<td width="35">Type </td>
								<td width="100" class="stm">
									<select name="tml_awk_cgo_cond_tp_nm" style="width:80" tabindex="3" onChange="obj_change()" >
										<option value="" ></option>
										<option value="C">Common</option>
										<option value="B">Basic</option>
										<option value="T">T/S</option>
										<option value="A">Add-On</option>
										<option value="S">Shuttle</option>
										<option value="F">Feeder</option>
									</select>
								</td>
								<td width="25">ID</td>
								<td width="60"><input type="text" name="cond_no" style="width:40;text-align:center;ime-mode:disabled;" class="input" onKeyPress="ComKeyOnlyNumber(this)"></td>
								<td width="70">Tariff Condition</td>					
								<td width="120"><input type="text" name="cond_desc" style="width:100;text-align:left;ime-mode:disabled;" class="input"></td>
								<td width="190"></td>
							</tr> 
						</table>				
				
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>			
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_OK">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>