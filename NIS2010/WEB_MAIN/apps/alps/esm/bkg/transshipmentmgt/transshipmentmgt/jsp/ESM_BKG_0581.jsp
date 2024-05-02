<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0581.jsp
*@FileTitle : OOP Code Match with Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.19 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0581Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0581Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0581Event)request.getAttribute("Event");
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
<title>OOP Code Match with Vessel</title>
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

<body  onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="49">Carrier</td>
					<td width="135"><input name="crr_cd" type="text" size="10" dataformat="engup" maxlength="4">&nbsp;<img name="btn_carrier_cd" id="btn_carrier_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="46">Vessel</td>
					<td width="135"><input type="text" style="width:88;" class="input" value="" name="vsl_cd" dataformat="engup" maxlength="4"></td>
					<td width="68">VSL Name</td>
					<td width=""><input type="text" style="width:250;" class="input" value="" name="vsl_eng_nm" maxlength="50"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
						
			
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable" border="0"> 
       	<tr><td class="bg">
				
				<!-- Grid_frame (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr>
					<td width="550" valign="top">
						<!-- Grid_2  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
						<!-- Grid_2 (E) -->
					</td>
					<td width="19">&nbsp;</td>
					<td width="410" valign="top">
						<!-- Grid_1  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
						<!-- Grid_1 (E) -->
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_rowAdd">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
			
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_delete">Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
			
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_save2">Save</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
										
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
						
						
					</td>					
					</tr>
					</table>
					<!-- Grid_frame (E) -->
					
			
			</td></tr>
		</table>
		<!-- Grid BG Box  (E) -->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	   
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	<!--biz page (E)-->
	
	</td></tr>
		</table> 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>