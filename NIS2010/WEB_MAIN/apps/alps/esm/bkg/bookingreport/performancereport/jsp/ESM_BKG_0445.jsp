<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0445.jsp
*@FileTitle : SI Split Candidate
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.18
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.05.18 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0445Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0445Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0445Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
	String bkg_no   			= JSPUtil.getNull(JSPUtil.getParameter(request,"bkg_no"));
  	String sr_kind  			= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_kind"));
  	String sr_no    			= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_no"));
  	
  	String xter_sndr_id    		= JSPUtil.getNull(JSPUtil.getParameter(request,"xter_sndr_id"));
  	String xter_rqst_no    		= JSPUtil.getNull(JSPUtil.getParameter(request,"xter_rqst_no"));
  	String xter_rqst_seq    	= JSPUtil.getNull(JSPUtil.getParameter(request,"xter_rqst_seq"));
  	String openerPgmNo			= JSPUtil.getNull(JSPUtil.getParameter(request, "openerPgmNo"));
	String mrdSaveDialogDir = "";
	
	String strTemp1 = System.getProperty("user.home");	
	if (strTemp1 != null) {
	} else {
		strTemp1 = "";
	}
	String strTemp2 = System.getProperty("file.separator");
	if (strTemp2 != null) {
	} else {
		strTemp2 = "";
	}	
	mrdSaveDialogDir = strTemp1 + strTemp2;
	
%>
<html>
<head>
<title>S/I Split Candidate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="bkg_no"      		value="<%=bkg_no%>">
<input type="hidden" name="sr_no"      			value="<%=sr_no%>">
<input type="hidden" name="sr_kind"      		value="<%=sr_kind%>">
<input type="hidden" name="xter_sndr_id"      	value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no"      	value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq"      	value="<%=xter_rqst_seq%>">
<input type="hidden" name="openerPgmNo" 		value="<%=openerPgmNo%>">
<input type="hidden" name="splitActionflag" 	value="false">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=mrdSaveDialogDir%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_zoomIn">

<input type="hidden" name="pgmNo" value="ESM_BKG_0445">
<input type="hidden" name="popUpFlag" value="Y">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  S/I Split Candidate</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
							
				<!--  biz_1   (E) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Grid ) (S) -->
						
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">1.Original Booking & Split Master - Select Split Master Booking</td></tr>
							</table>
							
						<!-- Grid_1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>	
						
						<table class="height_8"><tr><td></td></tr></table>	
				
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">2.Split Candidate List</td></tr>
						</table>
						
						<!-- Grid_1 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>	
						</td>
						<!-- Grid_1 (S) -->
					</tr>
				</table>
				<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5px;">
			<tr>
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_CancelCandidate" id="btn_CancelCandidate">Cancel&nbsp;Split&nbsp;Candidate</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						
				<td class="btn1_bg">
		
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Duplicate" id="btn_Duplicate">Check Dup. CNTR</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Split" id="btn_Split">Go to Split BKG</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						</tr>
				</table>
				</td>
		
			</tr>
		</table>
		</td></tr></table>
		<!--biz page (E)-->
		
		
		
<!--Button (E) -->
	
<!-- : ( Button : pop ) (E) -->
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top:5; padding-bottom:10;">
			<tr>
				<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>