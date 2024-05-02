
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0649.jsp
	 *@FileTitle : Cancel Issue Release
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.20
	 *@LastModifier : 이진서
	 *@LastVersion : 1.0
	 * 2009.07.20 이진서
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0649Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0649Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");
	boolean isPopUp = ("Y".equals(JSPUtil.getParameter(request, "isPopUp")) )?true:false;;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg0649Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cancel Issue & Release</title>
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
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<!-- 개발자 작업	--> 
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'>
<input type="hidden" name="isPopUp" value='<%=JSPUtil.getParameter(request, "isPopUp")%>'>
<input type="hidden" name="frm_sheet1_bl_tp_cd">
<input type="hidden" name="frm_sheet1_obl_iss_knt">
<input type="hidden" name="frm_sheet2_his_seq">
<input type="hidden" name="frm_sheet2_riss_flg">

<input type="hidden" name="frm_sheet1_do_yn" 			value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_flg_do")%>'> 
<input type="hidden" name="frm_sheet1_bl_issue_no" 		value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_bl_issue_no")%>'>
<input type="hidden" name="frm_sheet1_obl_released_flg" value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_released")%>'> 
<input type="hidden" name="frm_sheet1_obl_iss_flg" 		value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_issued")%>'> 
<input type="hidden" name="frm_sheet1_obl_srnd_flg" 	value='<%=JSPUtil.getParameter(request, "frm_t11sheet1_surrender")%>'>
<input type="hidden" name="setupfocoblflag" value="N">

<!-- OUTER - POPUP (S)tart
<table width="400" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td> -->
		
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		
			<!--Page Title, Historical (S)-->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="title">
					<tr>
						<td class="history"><img src="img/icon_history_dot.gif"
							align="absmiddle"><span id="navigation"></span></td>
					</tr>
					<tr>
						<td class="title"><img src="img/icon_title_dot.gif"
							align="absmiddle">&nbsp;Cancel Issue & Release</td>
					</tr>
				</table>
		<!--Page Title, Historical (E)-->	
	 <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 397;">
					<tr class="h23">
						<td width="50">BKG No.</td>
						<td width="160"><input type="text" style="width: 130;" dataformat="uppernum"  maxlength="13" name="frm_sheet1_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" class="input1" ></td>
						<td width="50">B/L No.</td>
						<td><input type="text" style="width: 130;" dataformat="uppernum"  maxlength="13" name="frm_sheet1_bl_no" value="<%=JSPUtil.getParameter(request, "bl_no")%>" class="input"></td>
					</tr>
					<tr class="h23">
						<td width="">Shipper</td>
						<td colspan="3">
						<input type="text" style="width: 70;" name="frm_sheet1_shipper_code" value="" class="input2"  readonly>
						<input type="text" style="width: 267;" name="frm_sheet1_shipper_name" value="" class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="49">Reason</td>
						<td style="padding-left:3">
							<script language="javascript">ComComboObject('bl_riss_rsn_cd', 1, 342, 1);</script>
							<input type="hidden" name="frm_sheet2_bl_riss_rsn_cd">
						</td>
					</tr>
				</table>

				<table class="height_5">
					<tr class="h23">
						<td>B/L Collection</td>
					</tr>
				</table>				
				<!-- Grid  (S) -->
				<div style="display:none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
				<div style="display:none;"><script language="javascript">ComSheetObject('sheet2');</script></div>
				<table width="100%" id="mainTable">
					<tr>
						<td width="397"><script language="javascript">ComSheetObject('sheet3');</script></td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table width="397" class="grid2" id="mainTable">
					<tr>
						<td width="60" class="tr2_head2">Remark(s)</td>
						<td><textarea style="width: 100%;" rows="3" name="frm_sheet2_riss_rsn"></textarea></td>
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--></td>
	</tr>
</table>


<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
					<tr>
						<td class="btn1_bg">
						
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
									<td class="btn1_line"></td>					
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
								
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Confirm">Confirm</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						
						<%if(isPopUp){%>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<%}%>	
												
						</tr>
					</table>

				</td>
					</tr>
				</table>
		<!--Button (E) --> 
	
	
	<!-- : ( Button : pop ) (S) 
<table class="height_5"><tr><td></td></tr></table>

<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="900" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
							<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
		
		Button (E) -->	
		

		</td>
	</tr>
</table>

</form> 
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
</body>
</html>