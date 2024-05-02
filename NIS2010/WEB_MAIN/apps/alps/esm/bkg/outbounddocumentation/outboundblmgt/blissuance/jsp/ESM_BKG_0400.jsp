
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0400Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0400Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		event = (EsmBkg0400Event) request.getAttribute("Event");
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
<title>O.B/L Surrender Information</title>
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

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>"> 
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>"> 
<!-- 개발자 작업	--> 
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'> 
<input type="hidden" name="application_date">
<input type="hidden" name="frm_sheet1_obl_srnd_flg">
<input type="hidden" name="frm_sheet1_obl_iss_knt">
<input type="hidden" name="frm_sheet1_obl_rlse_flg">
<input type="hidden" name="frm_sheet1_bl_tp_cd">
<input type="hidden" name="frm_sheet1_cust_to_ord_flg">
<input type="hidden" name="frm_sheet1_del_cd">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="setupfocoblflag" value="N">
<input type="hidden" name="inquery_only" value='<%=JSPUtil.getParameter(request, "inquery_only")%>'> 
<!-- OUTER - POPUP (S)tart -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TITLE.jsp"%>		

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">	

		
		<!-- : ( Search Options ) (S) --> <!--biz page-1 (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 584;">
					<tr class="h23">
						<td width="77">Booking No.</td>
						<td width="274"><input type='text' style='width: 110;' dataformat="uppernum" maxlength="13" name='frm_sheet1_bkg_no' value='<%=JSPUtil.getParameter(request, "bkg_no")%>' class='input1'> 
						<img name="pop_bkg_no" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
						<div id="span_bkg_no" name="span_bkg_no" style="position:absolute;z-index:999;display:none;"></div>
						
						</td>
						<td width="85">B/L No.</td>
						<td ><input type='text' style='width: 110;' dataformat="uppernum" maxlength="13" name='frm_sheet1_bl_no' value='<%=JSPUtil.getParameter(request, "bl_no")%>' class='input1'>
						<img name="pop_bl_no" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
						<div id="span_bl_no" name=""span_bl_no"" style="position:absolute;z-index:999;display:none;"></div>
				
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%" class="search">
					<tr class="h23">
						<td width="77">Office</td>
						<td width="120"><input type="text" style="width: 80;" class="input2" value="" name="frm_sheet1_obl_rdem_ofc_cd" readonly></td>
						<td width="33">Date</td>
						<td width="120"><input type="text" style="width: 80;" maxlength="10" dataformat="ymd" style="ime-mode:disabled" class="input" value="" name="frm_sheet1_obl_rdem_dt"></td>
						<td width="85">No. of O.B/L</td>
						<td width="120"><input type="text" style="width: 80;" maxlength="3" dataformat="int" value="" name="frm_sheet1_obl_rdem_knt" class="input"></td>
						<td width="43">Issuer</td>
						<td width=""><input type="text" style="width: 80;" class="input2" value="" name="frm_sheet1_obl_rdem_usr_id" readonly></td>
					</tr>
				</table>
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table width="100%" class="search">
					<tr class="h23">
						<td width="75">Remark(s)</td>
						<td><textarea style="width: 100%; height: 70;" name="frm_sheet1_diff_rmk"></textarea></td>
					</tr>
				</table>

				<!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_ClauseSetup">Clause Setup</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_Preview">Preview</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_Print">Print</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_FaxEmail">Fax/E-mail</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) --></td>
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
								<td class="btn1_right">
							</tr>
						</table>
						</td>
									<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
									<td class="btn1_line"></td>
									<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Cancel">Cancel</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						
						<%if(isPopUp){%>
						<td class="btn1_line"></td>
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
								<td class="btn1_right">
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
<!-- : ( Button : pop ) (E) -->

<div style="display: none;" id="mainTable"><script language="javascript">ComSheetObject('sheet1');</script></div>
<script language="javascript">comRdObject('report1');</script>

<div style="display: none;">
</div>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>

<!-- 개발자 작업  끝 --></form>
</body>
</html>