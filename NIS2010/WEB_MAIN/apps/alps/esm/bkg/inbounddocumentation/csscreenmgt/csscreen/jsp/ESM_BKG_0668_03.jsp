<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_03.jsp
*@FileTitle : In-bound C/S Screen US
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066803Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066803Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgtSC.CsScreenBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg066803Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen US</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var strUsr_id    = "<%=strUsr_id%>";

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

<!-- 개발자 작업	-->
<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' name ='h_mov_cntr_no' value = "">
<input type='hidden' name ='xmlData' value = "">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<!--TAB Movement (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr> <td class="bg">
					
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				
				<!-- Tab ) (S) -->
	     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
	       		<tr><td width="100%">
							<script language="javascript">ComTabObject('t3tab1')</script>
							<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
						</td></tr>
				</table>
				<!-- Tab ) (E) --> 
				
				<!--TAB  (S) -->
				<div id="t3tabLayer" style="display:inline">				
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t3sheet1_1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
				</div>
				<!--TAB  (E) --> 		
							
							
							
				<!--TAB  (S) -->
				<div id="t3tabLayer" style="display:none">
				
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1_2');</script>
								<script language="javascript">ComSheetObject('t3sheet1_3');</script>
								
								<!--  Button_Sub (S) -->
								<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>	
										<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="btn_Cop">Go to COP</td>
													<td class="btn2_right"></td>
												</tr>
												</table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="btn_Movement">Go to Movement</td>
													<td class="btn2_right"></td>
												</tr>
											</table></td></tr>
									</table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->

							</td>
						</tr>
					</table>
					<!-- Grid (E) -->							
				
				</div>
				<!--TAB  (E) --> 									
							
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

</div>
<!--TAB Movement (E) --> 	


<!-- ************************************************************************************************** -->


<!--TAB  (S) -->
<div id="tabLayer" style="display:none">


<!--TAB  (E) --> 	


<!-- ************************************************************************************************** -->
	
	<!--biz page (E)-->
			
</div>

<!-- 개발자 작업  끝 -->
</table>
</form>
</body>
</html>