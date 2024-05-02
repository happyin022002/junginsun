<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_05.jsp
*@FileTitle : e-Booking & SI Process Detail(C/M)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.17 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022905Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022905ViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg022905Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");
	String sXml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022905Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		EsmBkg022905ViewAdapter adapter = new EsmBkg022905ViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(C/M)</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="cm_nis" value="">
<input type="hidden" name="cm_esvc" value="">
<input type="hidden" name="stwg_cd" value="">
<!-- Origin 이 브라질 일 경우 Weight 이 1000 이하 경우에 대한 Validation 확인 유무   -->
<input type="hidden" name="br_wgt_chk_flg" value="N">


<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
	<tr><td valign="top">	
		<!--biz page (S)-->		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable" style="width:958;height:600;">
       		<tr><td class="bg" valign="top">			
				<table class="search" border="0" style="width:958;"> 
				<tr class="h23">
					<td width="480" valign="top">
					<!--  biz_1  (S) -->
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
								<tr><td class="title_h"></td>
									<td class="title_s">Booking Data ALPS</td></tr>
								<tr><td class="height_5"></td></tr>
							</table></td>
							<td  width="240" align="right"><table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					<table class="search_ssm" border="0" style="width:480;">
					<tr class="h23"><td>
						<table class="search" border="0">
							<tr class="h23">
								<td width="80">Booking No.</td>
								<td><input type="text" name="bkg_no" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
								<td colspan="2" align="right">
									<table width="145"  border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_copyfromcntr">Copy from CNTR</td>
										<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>	
								</td>
							</tr>
						</table> 
					</td></tr>
					</table>
					<!--  biz_1  (E) -->
					</td>
					<td width="12">&nbsp;</td>
					<td width="479" valign="top">
					<!--  biz_2  (S) -->
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
								<tr><td class="title_h"></td>
									<td class="title_s">From e- Service</td></tr>
								<tr><td class="height_5"></td></tr>
							</table></td>
							<td  width="240" align="right"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_datacopytoalps">Data&nbsp;Copy&nbsp;to&nbsp;ALPS</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					<table class="search_ssm1" border="0" style="width:479;">
					<tr class="h23"><td valign="top">
						<table class="search" border="0">
							<tr class="h23">
								<td width="80">Request No.</td>
								<td width="400" colspan="3"><input type="text" name="rqst_no" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
							</tr>
						</table>

						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>	
								</td>
							</tr>
						</table> 		
					</td></tr>
					</table>
					<!--  biz_2  (E) -->			
					<!-- Grid BG Box  (S) -->
					<!--biz page (E)-->
					</td>
			</tr>
			</table>
			<!--Button (S) -->
			<!-- <table width="980" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr><td class="btn1_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_upload">Upload</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
					</table></td>
				</tr>
			</table> -->
			</td></tr>
		</table>
			    <!--Button (E) -->
	</td></tr>

<table width="500"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 
</table>
</form>		
		
</body>
</html>