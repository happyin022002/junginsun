<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0017.jsp
*@FileTitle : ESM_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.24 김승민
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0017Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0017Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvdCd = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		vvdCd = StringUtil.xssFilter(request.getParameter("vvdCd"));

		event = (EsmBkg0017Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0017</title>
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
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 
<input type="hidden" name="error_yn"> 
<!-- 개발자 작업	-->
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>

		<!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="82"><input type="text" style="width: 80;"
							class="input1" maxlength="9" value="<%=vvdCd %>" name="vvd_cd" dataformat="uppernum" style="ime-mode:disabled"></td>
						<td width="100" class="sm"><input type="text" style="width: 60;"
							class="input2" value=" " name="slan_cd" readonly></td>
						<td width="136">ETA at Panama Canal</td>
						<td width="150"><input type="text" style="width: 130;"
							class="input2" value=" " name="vps_eta_dt" readonly></td>
						<td width="66">Prior Port</td>
						<td width="100"><input type="text" style="width: 60;"
							class="input2" value=" " name="pod_cd" readonly></td>
						<td width="75">Next Port</td>
						<td width=""><input type="text" style="width: 60;"
							class="input2" value=" " name="pol_cd" readonly></td>
						<td width="" rowspan="2">
						<table border="0" class="search_sm2" style="width:90%">
						<tr><td>
						<input type="radio" name="error_yn_temp" checked class="trans" onclick="checkTransmit('1')">All
						</td></tr>
						<tr><td><input type="radio" name="error_yn_temp" class="trans" onclick="checkTransmit('2')">Error
						</td></tr>
						</table>
						</td>
					</tr>
					<tr class="h23">
						<td>Ship ID No.</td>
						<td colspan="2"><input type="text" style="width: 142;;"
							class="input2" value=" " name="shp_id_no" readonly></td>
						<td>Visit No.</td>
						<td><input type="text" style="width: 130;"
							class="input2" value=" " name="vst_no" readonly></td>
						<td>MVMT Seq.</td>
						<td><input type="text" style="width: 60;"
							class="input2" value=" " name="mvmt_seq" readonly></td>
						<td>VSL Operator</td>
						<td><input type="text"
							style="width: 60;" class="input2" value=" " name="pnm_vsl_opr_cd" readonly></td>

					</tr>
					<tr class="h23">
						<td>Origin</td>
						<td colspan="2"><input type="text" style="width: 142;"
							class="input2" value=" " name="pnm_org_cd_temp" readonly>
							<input type="hidden" name="pnm_org_cd">
						</td>					
						<td>Destination</td>
						<td colspan="3"><input type="text" style="width: 276"
							class="input2" value=" " name="pnm_dest_cd_temp" readonly>
							<input type="hidden" name="pnm_dest_cd">
						<td>Sent Time</td>
						<td colspan="2"><input type="text" style="width: 130;"
							class="input2" value=" " name="edi_snd_dt" readonly>
							<input type="text" name="edi_snd_seq" style="width: 20;" class="input2" readonly>
						</td>						
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width=100%>
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!--TAB General Cargo Info (S) -->
		<div id="tabLayer" style="display: inline"><!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--></div>
		<!--TAB General Cargo Info (E) --> <!--TAB Empty Container Info (S) -->
		<div id="tabLayer" style="display: none"><!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!--biz page (E)--></div>
		<!--TAB Empty Container Info (E) --> <!--TAB Harzadous Cargo Info (S) -->
		<div id="tabLayer" style="display: none"><!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
	    <table width="100%" id="mainTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
	        </tr>
	    </table>		
		<!--biz page (E)--></div>
		<!--TAB Harzadous Cargo Info (E) --> <!--Button (S) --> <!--Button (E) -->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td style="font-size: 8pt; font-family: Tahoma, Arial;"
							width="200" align="right"><input type="radio" value="All"
							class="trans" name="error_type" checked>&nbsp;Send All&nbsp;&nbsp;&nbsp;<input
							type="radio" value="Err" class="trans" name="error_type">&nbsp;Exclude Error
						Data&nbsp;&nbsp;&nbsp;</td>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_transmit">Transmit</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %></form>
</body>
</html>