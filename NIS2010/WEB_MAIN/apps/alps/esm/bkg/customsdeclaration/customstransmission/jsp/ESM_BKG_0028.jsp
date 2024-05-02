<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0028.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	String vvdCd = "";
	String polCd = "";
	String podCd = "";	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	String strCntCd			= "";
	String strCustoms		= "";
	String strPgmNo = request.getParameter("pgmNo");
	if ("ESM_BKG_0028_1".equals(strPgmNo) || "ESM_BKG_0028_2".equals(strPgmNo)) {
		strCustoms = strPgmNo.endsWith("_1") ? "Origin" : "US";
		strCntCd = "US";
	} else {
		strCustoms = strPgmNo.endsWith("_3") ? "Origin" : "CA";
		strCntCd = "CA";
	}
%>
<html>
<head>

<title>Amendment Manifest (AI)</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="customs" value="<%=strCustoms%>">
<input type="hidden" name="cnt_cd" value="<%=strCntCd%>">
<input type="hidden" name="bl_no" value="">
<input type="hidden" name="pgmNo" value="<%=strPgmNo%>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>
<!--Page Title, Historical (E)-->

<!--biz page (S)-->

<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;">		
			 	<tr class="h23">
					<td width="155" colspan="2"><input type="radio" class="trans" name="ai_gubun" id="ai_gubun" value="" checked>&nbsp;General AI</td>
					<td width="195" colspan="3"><input type="radio" class="trans" name="ai_gubun" id="ai_gubun" value="DAI" >&nbsp;Immediate Delete & AI</td>
					<td width="140">Status&nbsp;
						<select style="width:70;" name="status_gubun">
						<option value="A">Active</option>
						<option value="D">Delete</option>
						</select></td>					
					<td width="*"  colspan="4"></td> 
				</tr>
				<tr class="h23">
					<td width="75">AI Type</td>
					<td width="80">
						<select style="width:60;" name="ai_type" id="ai_type">
						<option value="">All</option>
						<option value="Add">Add</option>
						<option value="Update">Update</option>
						<option value="Delete">Delete</option>
						<option value="D/L">D/L</option>
						</select></td>
					<td width="45">VVD</td>
					<td width="100"><input type="text" style="width:90;ime-mode:disabled" class="input1" name="vvd_cd" dataformat="eng" maxlength="9" minlength="9" caption="VVD" value="<%=vvdCd%>"></td> 
					<td width="50">POL</td>
					<td width="100"><input type="text" style="width:60;ime-mode:disabled" class="input" name="pol_cd" dataformat="engup" maxlength="5" minlength="5" caption="POL"  value="<%=polCd%>"></td> 
					<td width="45">POD</td>
					<td width="80"><input type="text" style="width:60;ime-mode:disabled" class="input" 	name="pod_cd" dataformat="engup" maxlength="5" minlength="5" caption="POD"  value="<%=podCd%>"></td> 
					<td width="20"><input type="checkbox" name="snd_dt_flg" class="trans" value="true"></td>
					<td width="80">Send Date</td>
					<td colspan="3">
						<input type="text" style="width:90;ime-mode:disabled" class="input" maxlength="10"
							dataformat="ymd" name="s_snd_dt" caption="Send Date" cofield="e_snd_dt">
						~
						<input type="text" style="width:90;ime-mode:disabled" class="input" maxlength="10"
							dataformat="ymd" name="e_snd_dt" caption="Send Date" cofield="s_snd_dt">
						<img src="img/btns_calendar.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_calendar"></td> 
				</tr>
				<tr class="h23">
					<td>Cargo Type</td>
					<td>
						<select style="width:60;" name="full_mty_cd">
						<option value="F" selected>Full</option>
						<option value="M">Empty</option>
						<option value="">All</option></select></td>
					<td>B/OFC</td>
					<td><input type="text" style="width:60;ime-mode:disabled" class="input"
						name="bkg_ofc_cd" dataformat="engup" maxlength="6" caption="B/OFC"></td> 
					<td>B/Staff</td>
					<td><input type="text" style="width:90;ime-mode:disabled" class="input"
						name="doc_usr_id" dataformat="eng" maxlength="20" caption="B/Staff"></td>
					<td width="">L/Rep.</td>
					<td width=""><input type="text" style="width:60;ime-mode:disabled" class="input"
						name="ob_srep_cd" dataformat="eng" maxlength="5" caption="L/Rep."></td>
					<td width="20">&nbsp;</td> 
					<td>Booking No.</td>
					<td width="120"><input type="text" style="width:100;ime-mode:disabled" class="input"
						name="bkg_no" dataformat="eng" maxlength="13" minlength="11" caption="Booking No."></td>
					<td width="70">M.B/L No.</td>
					<td width="*"><input type="text" style="width:100;ime-mode:disabled" class="input"
						name="mbl_no" dataformat="eng" maxlength="12" minlength="12" caption="M.B/L No."></td>
				</tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>	
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><input type="text" style="width:500;" class="input3" name="action_desc" readOnly></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_StartAI">Start AI</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_DeleteAI">Delete & AI</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_BlInquiry">B/L Inquiry</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Print">Print</td>
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

<!-- 본문끝 -->
		</td>
	</tr>
</table>
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 