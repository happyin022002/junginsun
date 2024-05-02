<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_CSR_0023.jsp
*@FileTitle : Files Management
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.21 9014787
* 1.0 Creation
*----------------------------------------------------------
* History
* 2015.05.13 심성윤 [CHM-201535807] PSO 별도 파일 추가 탭 기능 개발 //sub_sys_cd 변수 추가
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.event.ComCsr0023Event"%>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0023Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String csrGwUrl = "";
	
	//Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoRider");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (ComCsr0023Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CSR Invoice Agreement Link</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(win){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
		
		//resizeWindow();
	}
	
	function resizeWindow(){
		//var wid = win.document.body.offsetWidth + 200; //1004
		//var hei = win.document.body.offsetHeight + 160; //534        //30 과 40은 넉넉하게 하려는 임의의 값임
		var wid = 1020;//1004;
		var hei = 580;	//534
		//self.resizeTo(wid,hei);
		try {
			window.resizeTo(wid,hei);

		} catch (ex) {
			//parent.window.resizeTo(wid,hei);
			//alert('resizeWindow :' + ex);
			setTimeout("resizeWindow()", 500);
		}
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage(this);">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">
<input type="hidden" name="csr_file_upld_tp_cd">
<input type="hidden" name="tab_enable" value="<%=JSPUtil.getParameter(request, "tabStatus")%>">
<input type="hidden" name="btn_readOnly" value="<%=JSPUtil.getParameter(request, "readOnly")%>">
<input type="hidden" name="invSubSysCd" value="<%=JSPUtil.getParameter(request, "invSubSysCd")%>">
<!-- 개발자 작업	-->




<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  CSR Invoice Agreement Link</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
    	
    	
    	<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="90">CSR No.</td>
					<!-- <td width="250" style="padding-left:1">&nbsp;<input class="input1" type="text" style="width:172" name="inv_no" maxlength="30"></td> -->
					<td><%=JSPUtil.getParameter(request, "csr_no") %><input name="csr_no" type="hidden" value="<%=JSPUtil.getParameter(request, "csr_no") %>"></td>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->
    	

		<!--biz page (S)-->
		<%-- <table class="search"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr class="h23">
						<td width="90">CSR No.</td>
						<td><%=JSPUtil.getParameter(request, "csr_no") %><input name="csr_no" type="hidden" style="width:196;" value="<%=JSPUtil.getParameter(request, "csr_no") %>"></td>
					</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->		

		</td></tr></table> --%>
		<!--biz page (E)-->
		
		
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
     	<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       		<tr>
       			<td class="bg">
       	
       				<table class="height_10"><tr><td></td></tr></table>

						<!-- COM_CSR_0023 : THIS IS 1st TAB -->
						<div id="tabLayer" style="display:inline">
							<!-- : ( Grid : Week ) (S) -->
							<table width="100%" id="mainTable">
								<tr><td>
									 <script language="javascript">ComSheetObject('sheet1');</script>
								</td></tr>
							</table>
							<!-- : ( Grid : Week ) (E) -->
						</div>




		<!-- UI_ESD_TES_0017 : THIS IS 2st TAB -->
		<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('sheet2');</script>
				</td></tr>
			</table>
		</div>
		</td></tr></table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td id="td_btn_upload" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_upload" name="btn_upload">Add Files</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
				<td id="td_btn_delete" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_delete" name="btn_delete">Delete Files</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				<td id="td_btn_save" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_save" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td class="btn1_line"></td> -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_excel" name="btn_excel">Excel Down</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
			</tr>
		</table></td>	
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0" id="hiddenFrame"></iframe>
</body>
<script language="javascript">
<!--
	var tab_enable = "<%=JSPUtil.getParameter(request, "tabStatus")%>";

	// tab 000 일경우에는 return false;
	// tab 001 일경우에는 3번째 tab 이 활성화
	if( tab_enable == "" || tab_enable.indexOf('1') == -1){
		//close
		alert('tabStatus Param is null');
		self.close();
	}
-->
</script>
</html>