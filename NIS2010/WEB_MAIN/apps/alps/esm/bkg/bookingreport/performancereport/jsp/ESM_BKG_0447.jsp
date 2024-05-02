<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0447.jsp
*@FileTitle : SR FAX  Recving List - EMLContents 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.14 김기종
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0447Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0447Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0447Event)request.getAttribute("Event");
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
<title>SI Receiving List - EML Contents</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="fax_log_ref_no" value="<%=JSPUtil.getParameter(request, "fax_log_ref_no")%>">
<input type="hidden" name="sr_knd_cd" value="<%=JSPUtil.getParameter(request, "sr_knd_cd")%>">
<input type="hidden" name="conv_pdf_flg" value="<%=JSPUtil.getParameter(request, "conv_pdf_flg")%>">
<input type="hidden" name="cre_usr_id" value="<%=strUsr_id %>">


<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=("Y".equals(JSPUtil.getParameter(request, "conv_pdf_flg")))? "Convert":""%>  Email Contents</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		
							
				<!--  biz_1   (E) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Grid ) (S) -->
						<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="">Subject.</td>
							<td>
								<input type="text" name ='eml_subj_ctnt' style="width:25%;" class="input2" value="<%=JSPUtil.getParameter(request, "")%>">
								<input type="text" name ='eml_org_subj_ctnt' style="width:74%;"  class="input2" value="<%=JSPUtil.getParameter(request, "")%>">
							</td>
						</tr>  
						<tr class="h23">
							<td width="90">Booking No.</td>
							<td><input type="text" name ='bkg_no' style="width:110;" class="input2" value="<%=JSPUtil.getParameter(request, "bkg_no")%>"></td>
						</tr> 
						<tr class="h23">
							<td width="90">SI No.</td>
							<td><input type="text" name ='sr_no' style="width:110;" class="input2" value="<%=JSPUtil.getParameter(request, "sr_no")%>"></td>
						</tr> 
						
						</table>
						<table width="100%" class="grid2">
							<tr>
								<td class="tr2_head" width="60">Contents</td>
								<td align="left">
								<div id='eml_mn_ctnt'
									style="padding: 5 10 5 10; width: 647px; height: 150px; border-right: #000000 1px; border-top: #000000 1px; z-index: 1; visibility: visible; overflow: auto; border-left: #000000 1px; border-bottom: #000000 1px;">
								</div>
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="90">Attach File.</td>
						</tr> 
						</table>
						<!-- Grid_1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>	
						
						<!-- Grid_1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>	
						
					</tr>
				</table>
		
		</td></tr></table>
		<!--biz page (E)--> 

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_Print">Print</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<!--td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Rotate">Rotate</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td-->
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				
			</tr>
		</table></td>	
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0">
</iframe>
</body>
</html>