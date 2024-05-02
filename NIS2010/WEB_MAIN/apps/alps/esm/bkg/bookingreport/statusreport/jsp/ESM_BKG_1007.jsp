
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_1007.jsp
	 *@FileTitle : Queue Detail Return Reason 
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1007Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1007Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1007Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	  String bkg_no   = JSPUtil.getParameter(request,"bkg_no"); 
	  String sr_kind  = JSPUtil.getParameter(request,"sr_kind"); 
	  String sr_no    = JSPUtil.getParameter(request,"sr_no"); 
	  String pnd_flg  = JSPUtil.getParameter(request,"pnd_flg"); 
	  String src_cd   = JSPUtil.getParameter(request,"src_cd"); 
	  String sr_crnt_info_cd = JSPUtil.getParameter(request,"sr_crnt_info_cd"); 
	  String sr_crnt_sts_cd  = JSPUtil.getParameter(request,"sr_crnt_sts_cd"); 
	  String ui_id           = JSPUtil.getParameter(request,"ui_id"); 
	  String grp_cd           = JSPUtil.getParameter(request,"grp_cd"); 
	  String sr_his_seq           = JSPUtil.getParameter(request,"sr_his_seq"); 
	  String message = JSPUtil.getParameter(request, "message");
%>
<html>
<head>
<title>DPCS: Return Reason</title>
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

<body onLoad="setupPage();">
<div id="debug"></div>
<!-- OUTER - POPUP (S)tart -->
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="sr_knd_cd"      value="<%=sr_kind%>">
	<input type="hidden" name="sr_no"      value="<%=sr_no%>">
	<input type="hidden" name="bkg_no"      value="<%=bkg_no%>">
	<input type="hidden" name="pnd_flg"      value="<%=pnd_flg%>">
	<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="src_cd"      value="<%=src_cd%>">
	<input type="hidden" name="grp_cd"      value="<%=grp_cd%>">	
	<input type="hidden" name="sr_his_seq"      value="<%=sr_his_seq%>">	

<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Return  Reason

</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
						<table class="search"> 
       		<tr><td class="bg">
			
						<table class="search_sm" border="0" style="width:679;"> 
						<tr class="h23">
							<td width="100"><input type="checkbox" value="" class="trans" name="rsn_bkg_mn_flg">&nbsp;&nbsp;BKG Main</td>
							<td width="140"><input type="checkbox" value="" class="trans" name="rsn_cust_info_flg">&nbsp;&nbsp;Customer</td>
							<td width="130"><input type="checkbox" value="" class="trans" name="rsn_frt_chg_flg">&nbsp;&nbsp;FRT & Charge</td>
							<td width="110"><input type="checkbox" value="" class="trans" name="rsn_cntr_flg">&nbsp;&nbsp;Container</td>
							<td width=""><input    type="checkbox" value="" class="trans" name="rsn_cntr_mf_flg">&nbsp;&nbsp;Container Manifest</td>
						</tr>
						<tr class="h23">
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_dcgo_flg">&nbsp;&nbsp;Danger</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_awk_cgo_flg">&nbsp;&nbsp;Awkward</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_rc_flg">&nbsp;&nbsp;Reefer</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_bb_cgo_flg">&nbsp;&nbsp;B/Bulk</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_rly_port_flg">&nbsp;&nbsp;RLY VVD & Port</td>
						</tr>
						<tr class="h23">
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_new_bkg_flg">&nbsp;&nbsp;New BKG</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_split_flg">&nbsp;&nbsp;BKG Split</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_bl_info_flg">&nbsp;&nbsp;B/L Issue</td>
							<td width=""><input type="checkbox" value="" class="trans" name="rsn_hbl_flg">&nbsp;&nbsp;NVO House B/L</td>
							<td width=""><input type="checkbox" value="" class="trans" name="cust_verif_flg">&nbsp;&nbsp;Customer Verification</td>
						</tr>
						</table>
								
							</td></tr>
						</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
<td height="30" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
				<tr>
					<td class="btn3_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
		<!--Button (E) -->
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
	</form>

<div style="display:none">
<table width="100%"  id="mainTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
</div>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>