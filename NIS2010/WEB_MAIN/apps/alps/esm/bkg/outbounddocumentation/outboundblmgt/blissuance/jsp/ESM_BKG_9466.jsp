<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_9466.jsp
*@FileTitle : B/L Certificate 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
*----------------------------------------------------------
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9466Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %> 
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9466Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String popNm = "";
	String ridrTpCd = "";
	String blNo = "";
	String pageRows  = "100";
	String strUserHomerFileSeparator = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoRider");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

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
		event = (EsmBkg9466Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		blNo = StringUtil.xssFilter(JSPUtil.getParameter(request, "bl_no"));
		if(blNo.length()>12){
			blNo = blNo.substring(0,12); 
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Certificate</title>
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
<input type="hidden" name="ridr_tp_cd" value="K">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="blNoList">
<input type="hidden" name="seqList">
<input type="hidden" name="divFlg">
<input type="hidden" name="ui_id" value="ESM_BKG_9466">
<input type="hidden" name="bl_no" value="<%=blNo%>">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  B/L Certificate Attachment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" >
		    <tr>
		    	<td width="100%">
		            <script language="javascript">ComTabObject('tab1')</script>
		        </td>
		    </tr>
		</table>
		<!-- Tab (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">Booking No.</td>
					<td><input type="text" name ='bkg_no' style="width:110;" class="input2" value="<%=StringUtil.xssFilter(JSPUtil.getParameter(request, "bkg_no"))%>"></td>
				</tr> 
				</table>
				
				
<!-- 				<table class="search_sm2" border="0" style="width:230;">  -->
<!-- 				<tr class="h23"> -->
<!-- 					<td width="45">Type</td> -->
<!-- 					<td class="stm"> -->
<!-- 						<input type="radio" name='ridr_tp_cd' value="G" class="trans" onClick="fn_ridr_Tp_Change(this)" checked>General &nbsp;&nbsp; -->
<!-- 						<input type="radio" name='ridr_tp_cd' value="C" class="trans" onClick="fn_ridr_Tp_Change(this)" >Certificate -->
<!-- 					</td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
							
				<!--  biz_1   (E) -->
			<div id="tabLayer" style="display:inline">		
            <!-- Grid  (S) -->
       		<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			</div>
			<div id="tabLayer" style="display:none">
            <table width="100%">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			</div>
		</td></tr></table>

		<!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><div id="DIV_BNT1" style="display:block;">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_upload" name="btn_upload">File Upload</td>
					<td class="btn1_right"></td>	
				</tr></table></div></td>
				<td><div id="DIV_BNT2" style="display:block;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_delete" name="btn_delete">File Delete</td>
					<td class="btn1_right"></td>	
				</tr></table></div></td>	
				<td><div id="DIV_BNT3" style="display:block;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_save" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></div></td>

				<td><div id="DIV_BNT4" style="display:block;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Print" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></div></td>

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
			
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>