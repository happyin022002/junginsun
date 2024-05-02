<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0273.jsp
*@FileTitle : Onsite Inspection Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event.EesMnr0273Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0273Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0273Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용  -->       
<script language="javascript">   
	function setupPage(){    
		var errMessage = "<%=strErrMsg%>";
		
		parent.window.moveTo(0,0);
		var screen_width = (window.screen.width)-100;
		var screen_height = (window.screen.height)-30;
		parent.window.resizeTo(screen_width,screen_height);
		
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
<input type="hidden" name="key_value">  
<input type="hidden" name="insp_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>">
<input type="hidden" name="vndr_seq_for_save">
<input type="hidden" name="vndr_lgl_eng_nm_for_save">
<input type="hidden" name="yd_cd_for_save">
<input type="hidden" name="fld_insp_dt_for_save">
<input type="hidden" name="file_seq">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table> 
		<!--Page Title, Historical (E)-->        

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:1179;">
				<tr class="h23">
					
					<td width="70">S/Provider</td>
					<td width="350"><input type="text" style="width:60;" class="input1" name="vndr_seq" value="" required maxlength="6" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" class="cursor" alt="" border="0" align="absmiddle" id="btn_popup" name="btn_vndr">&nbsp;<input type="text" style="width:200;" class="input2" readOnly name="vndr_lgl_eng_nm" ></td>
					<td width="28">Yard</td>
				    <td colspan="110"><input type="text" style="width:60;" class="input1" name="yd_cd" value="" required fullfill type="text"  dataformat="engup" maxlength="7">&nbsp;<img src="img/btns_search.gif" width="19" height="20" class="cursor" alt="" border="0" align="absmiddle" id="btn_popup" name="btn_yd"></td>
					<td width="70">Inspection&nbsp;Date</td>
					<td width="120"><input type="text" style="width:80;" class="input1" name="fld_insp_dt" required dataformat="ymd" maxlength="8">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="calendar"></td>
					<td width="130">Inspection&nbsp;Result&nbsp;History</td>
					<td width="100"><script language="javascript">ComComboObject('aud_rslt_his',2, 80 ,1,0,1)</script></td>
					<td width="80">Inspector:&nbsp;</td> 
					<td width="30">SCO</td>
					<td width="30"><input type="checkbox" name="brnc_insp_flg" style="border:0;"></td>
					<td width="30">SSZ</td>
					<td width="30"><input type="checkbox" name="hdbrn_insp_flg" style="border:0;"></td>
					</tr>
				<tr class="h23"></tr>
				</table>
				<!--  biz_1   (E) -->
   
		</td></tr></table>
		<!-- 1 (E) -->


		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">

			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">  On-site Inspection Result</td></tr>
			</table>

			<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid - 2 (E) -->
		<table class="height_8"><tr><td></td></tr></table>
		
		<table class="search" border="0">
			<tr class="h23">
				<td width="400">
					<!-- Grid - 2 (S) -->
					<table width="350"  id="mainTable">
						<tr>
							<td width="350">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					<!-- Grid - 2 (E) -->
					<!--  Button_Sub (S) -->
					<table width="350" class="button" >
	       				<tr>
							<td class="btn2_bg"> 
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_RowAdd">Row Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_RowDel">Row Delete</td>
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
	    	

			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->



	</td></tr>
		</table>  

<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>