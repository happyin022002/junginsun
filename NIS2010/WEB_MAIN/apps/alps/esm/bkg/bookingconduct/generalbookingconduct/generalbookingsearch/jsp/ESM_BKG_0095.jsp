<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0095.jsp
*@FileTitle : Booking Fax & EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
*---------------------------------------------------------
* History
* 2010-11-23 전성진 [CHM-201007312] FXTBB BKG Receipt 문구수정 
* 2011.02.10 김영철 [CHM-201108777-01] 영국 Booking관련 하드코딩 문구 수정 ( Remark 문장 수정 )
* 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로 BPM호출
* 2011.07.28 정선용 [CHM-201112600] BKG receipt clause 하드코딩 문구 워딩추가 (영국 BKG)
* 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
* 2013.05.27 최문환 [CHM-201324826] BKG receipt 리마크 하드코딩 제거 요청 (POL 영국일 경우)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0095Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0095Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//서버에서 발생한 에러
	String strErrMsg = "";					//에러메세지
	int rowCount = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

    String bkgNo = "";
	String polCd = "";
	String docType = "";
	String signFlag = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");
	String receiptType = null;
	String sXml = "";
	String dpcs_sr_no = "";
	String dpcs_sr_knd_cd = "";
	String strUserHomerFileSeparator = "";
	String opener_pgm ="";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		
		event = (EsmBkg0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		opener_pgm  = JSPUtil.getParameter(request, "opener_pgm");
		bkgNo = event.getBkgBlNoVO().getBkgNo();
		polCd = event.getPolCd();
		docType = event.getDocType();
		signFlag = event.getSignFlag();
		dpcs_sr_no = event.getDpcsSrNo();
		dpcs_sr_knd_cd = event.getDpcsSrKndCd();
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		receiptType = (String) eventResponse.getCustomData("receipt_type");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
		
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
	    strUserHomerFileSeparator = strTemp1 + strTemp2;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Fax & EDI</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="receipt_type" value="<%=receiptType%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="docType" value="<%=docType%>">
<input type="hidden" name="signFlag" value="<%=signFlag%>">
<input type="hidden" name="dpcs_sr_no" value="<%=dpcs_sr_no%>">
<input type="hidden" name="dpcs_sr_knd_cd" value="<%=dpcs_sr_knd_cd%>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="inter_rmk">
<!-- 개발자 작업	-->
<input type="hidden" name="opener_pgm" value="<%=opener_pgm%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPrintPaperSize">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_isBatch" value="N">
<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml">
<input type="hidden" name="edt_cc_eml">
<input type="hidden" name="edt_from_eml">
<input type="hidden" name="edt_subject">
<input type="hidden" name="edt_contents">
<input type="hidden" name="com_fileKey"> 
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="900" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Fax/EDI</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">								
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Fax / E-mail </td></tr>
				</table>											
				<!-- Grid  (S) -->
				<table class="" border="0" width="100%">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->						
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RemarkTemplate">Remark Template</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Remark">Remark(s)</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
					 	<td class="btn2" name="btn_EditVVD">Edit VVD</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Preview">Preview</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr id="btn_FaxSend1"><td class="btn2_left"></td>
						<td class="btn2" name="btn_FaxSend">Fax</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Email">E-mail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>							
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_EmailEdit">E-mail (Edit)</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->			
			</td></tr>
		</table>			
		<!-- 1 (E) -->
		<!-- 2 (S) -->
		<table class="height_2"><tr><td></td></tr></table> 	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">								
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">EDI</td></tr>
				</table>											
				<!-- Grid  (S) -->
				<table  border="0" width="100%">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->							
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>		
				 <%if (polCd.equals("SGSIN")) {%>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">	
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Yard">Yard Assign by CNTR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				 <%}else{%>
						<td style="visibility:hidden;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">	
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Yard">Yard Assign by CNTR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				 <%} %>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_EDITransmission">EDI Transmission</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>									
					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>			
		<!-- 2 (E) -->

<table class="height_5"><tr><td></td></tr></table>

<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="font:15px;position:absolute;left:10px;"> 
	<tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
</table><br>

	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr></table></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
			</td></tr>
		</table>
    <!--Button (E) -->	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- Grid  (S) -->
<table width="0"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 				
<!-- Grid (E) -->			
</form>
</body>
</html>
