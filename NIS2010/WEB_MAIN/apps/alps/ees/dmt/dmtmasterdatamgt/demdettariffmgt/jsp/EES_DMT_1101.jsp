<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1101.jsp
*@FileTitle : Copy Basic Tariff
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1101Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EesDmt1101Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetTariffMgt");

	String dmdt_trf_cd = "";
	String dmdt_trf_nm = "";
	String cvrg_conti_cd = "";
	String cvrg_cnt_cd = "";
	String cvrg_rgn_cd = "";
	String cvrg_ste_cd = "";
	String cvrg_loc_cd = "";
	String cvrg_yd_cd = "";
	String dmdt_de_term_cd = "";
	String dmdt_de_term_nm = "";
	String org_dest_conti_cd = "";
	String org_dest_cnt_cd = "";
	String org_dest_rgn_cd = "";
	String org_dest_ste_cd = "";
	String org_dest_loc_cd = "";
	String svr_id = "";
	String trf_seq = "";
	String trf_grp_seq = "";
	String dmdt_bzc_trf_grp_nm = "";
	String ui_code = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesDmt1101Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		dmdt_trf_cd 	= JSPUtil.getParameter(request, "dmdt_trf_cd");
		dmdt_trf_nm 	= JSPUtil.getParameter(request, "dmdt_trf_nm");
		cvrg_conti_cd 	= JSPUtil.getParameter(request, "cvrg_conti_cd");
		cvrg_cnt_cd 	= JSPUtil.getParameter(request, "cvrg_cnt_cd");
		cvrg_rgn_cd 	= JSPUtil.getParameter(request, "cvrg_rgn_cd");
		cvrg_ste_cd 	= JSPUtil.getParameter(request, "cvrg_ste_cd");
		cvrg_loc_cd 	= JSPUtil.getParameter(request, "cvrg_loc_cd");
		cvrg_yd_cd 		= JSPUtil.getParameter(request, "cvrg_yd_cd");
		dmdt_de_term_cd	= JSPUtil.getParameter(request, "dmdt_de_term_cd");	// Dem/det Delivery Term Code
		dmdt_de_term_nm	= JSPUtil.getParameter(request, "dmdt_de_term_nm");	// Dem/det Delivery Term Name
		
		org_dest_conti_cd = JSPUtil.getParameter(request,"org_dest_conti_cd");
		org_dest_cnt_cd = JSPUtil.getParameter(request,"org_dest_cnt_cd");
		org_dest_rgn_cd = JSPUtil.getParameter(request,"org_dest_rgn_cd");
		org_dest_ste_cd = JSPUtil.getParameter(request,"org_dest_ste_cd");
		org_dest_loc_cd = JSPUtil.getParameter(request,"org_dest_loc_cd");
		svr_id 			= JSPUtil.getParameter(request, "svr_id");
		trf_seq 		= JSPUtil.getParameter(request, "trf_seq");
		trf_grp_seq 	= JSPUtil.getParameter(request, "trf_grp_seq");
		dmdt_bzc_trf_grp_nm = JSPUtil.getParameter(request,"dmdt_bzc_trf_grp_nm");
		ui_code			= JSPUtil.getParameter(request,"ui_code");
		
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Copy Basic Tariff</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_dmdt_de_term_cd" , "", "CD03257", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="conti_cd"> 
<input type="hidden" name="cnt_cd"> 
<input type="hidden" name="rgn_cd"> 
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="dmdt_de_term_cd" value="<%=dmdt_de_term_cd%>">
<input type="hidden" name="cvrg_rgn_cd" value="<%=cvrg_rgn_cd%>"> 
<input type="hidden" name="cvrg_ste_cd" value="<%=cvrg_ste_cd%>"> 
<input type="hidden" name="org_dest_rgn_cd" value="<%=org_dest_rgn_cd%>">
<input type="hidden" name="org_dest_ste_cd"	value="<%=org_dest_ste_cd%>">

<input type="hidden" name="to_dmdt_de_term_cd"> 
<input type="hidden" name="to_org_dest_conti_cd"> 
<input type="hidden" name="to_cvrg_rgn_cd">
<input type="hidden" name="to_cvrg_ste_cd">
<input type="hidden" name="to_org_dest_cnt_cd"> 
<input type="hidden" name="to_org_dest_rgn_cd"> 
<input type="hidden" name="to_org_dest_ste_cd"> 
<input type="hidden" name="to_org_dest_loc_cd"> <!-- 개발자 작업	-->
<input type="hidden" name="ui_code" value="<%=ui_code %>">

<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Copy Basic Tariff</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 884;">
					<tr class="h23">
						<td width="70">Tariff Type</td>
						<td width="435"><input type="text" name="dmdt_trf_cd" style="width: 96;" class="input2" readonly value="<%=dmdt_trf_cd%>">&nbsp;<input type="text" name="dmdt_trf_nm" style="width: 308;" class="input2" readonly value="<%=dmdt_trf_nm%>"></td>
						<td width="70">User Office</td>
						<td width="80">&nbsp;<input type="text" name="ofc_cd" style="width: 65;" class="input2" readonly value="<%=strOfc_cd%>"></td>
						<td width="70">User Name</td>
						<td>&nbsp;<input type="text" name="usr_nm" style="width: 150;" class="input2" readonly value="<%=strUsr_nm%>"></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">From</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 884;">
					<tr class="h23">
						<td width="70">Coverage</td>
						<td width="120" class="stm">Continent&nbsp;<input type="text" name="cvrg_conti_cd" style="width: 40;" class="input2" readonly value="<%=cvrg_conti_cd%>"></td>
						<td width="120" class="stm">Country&nbsp;<input type="text" name="cvrg_cnt_cd" style="width: 50;" class="input2" readonly value="<%=cvrg_cnt_cd%>"></td>
						<td width="42" class="stm"><%if (cvrg_cnt_cd.equals("CA") || cvrg_cnt_cd.equals("US")) {%>State<%} else {%>Region<%}%></td>
						<td width="78">&nbsp;<input type="text" name="cvrg_rgn_ste_cd" style="width: 60;" class="input2" readonly value=""></td>
						<td width="120" class="stm">Location&nbsp;<input type="text" name="cvrg_loc_cd" style="width: 60;" class="input2" readonly value="<%=cvrg_loc_cd%>"></td>
						<td width="105" class="stm">Yard&nbsp;<input type="text" name="cvrg_yd_cd" style="width: 65;" class="input2" readonly value="<%=cvrg_yd_cd%>"></td>
						<td class="stm">BKG Term&nbsp;<input type="text" name="dmdt_de_term_nm" style="width: 65;" class="input2" readonly value="<%=dmdt_de_term_nm%>"></td>
					</tr>
					<tr class="h23">
						<td><%if (dmdt_trf_cd.equals("DMOF") || dmdt_trf_cd.equals("DTOC")|| dmdt_trf_cd.equals("CTOC")) {%>Destination<%} else {%>Origin<%}%></td>
						<td width="120" class="stm">Continent&nbsp;<input type="text" name="org_dest_conti_cd" style="width: 40;" class="input2" readonly value="<%=org_dest_conti_cd%>"></td>
						<td width="120" class="stm">Country&nbsp;<input type="text"	name="org_dest_cnt_cd" style="width: 50;" class="input2" readonly value="<%=org_dest_cnt_cd%>"></td>
						<td width="42" class="stm"><%if (org_dest_cnt_cd.equals("CA") || org_dest_cnt_cd.equals("US")) {%>State<%} else {%>Region<%}%></td>
						<td width="78">&nbsp;<input type="text" name="org_dest_rgn_ste_cd" style="width: 60;" class="input2" readonly></td>
						<td width="120" class="stm">Location&nbsp;<input type="text" name="org_dest_loc_cd" style="width: 60;" class="input2" readonly value="<%=org_dest_loc_cd%>"></td>
						<td class="stm"></td>
					</tr>
				</table>
				<!--  biz_2   (E) -->
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<!--  biz_3  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">To</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 884;">
					<tr class="h23">
						<td width="70">Coverage</td>
						<td width="120" class="stm">Continent&nbsp;<input type="text" name="to_cvrg_conti_cd" style="width: 40;" class="input2" readonly value="<%=cvrg_conti_cd%>"></td>
						<td width="120" class="stm">Country&nbsp;<input type="text"	name="to_cvrg_cnt_cd" style="width: 50;" class="input2" readonly value="<%=cvrg_cnt_cd%>"></td>
						<td width="42" class="stm"><%if(cvrg_cnt_cd.equals("CA")||cvrg_cnt_cd.equals("US")){%>State<%}else{%>Region<%}%></td>
						<td width="78">&nbsp;<input type="text" name="to_cvrg_rgn_ste_cd" style="width: 60;" class="input2" readonly value=""></td>
						<td width="120" class="stm">Location&nbsp;<input type="text" name="to_cvrg_loc_cd" style="width: 60;" class="input2" readonly value="<%=cvrg_loc_cd%>"></td>
						<td width="105" class="stm">Yard&nbsp;<input type="text" name="to_cvrg_yd_cd" style="width: 65;" class="input2" readonly value="<%=cvrg_yd_cd%>"></td>
						<td             class="stm">BKG Term&nbsp;<script language="javascript">ComComboObject('combo1', 2, 60, 1, 1, 0, true);</script>
						
					</tr>
					<tr class="h23">
						<td><%if (dmdt_trf_cd.equals("DMOF") || dmdt_trf_cd.equals("DTOC") || dmdt_trf_cd.equals("CTOC")) {%>Destination<%} else {%>Origin<%}%>
						</td>
						<td width="120" class="stm">Continent&nbsp;<script language="javascript">ComComboObject('combo2', 2, 40 , 0, 1, 0, true)</script></td>
						<td width="120" class="stm">Country&nbsp;<script language="javascript">ComComboObject('combo3', 2, 50 , 0, 0, 0, true)</script></td>
						<td width="42" class="stm"><span id="Region">Region</span></td>
						<td width="78">&nbsp;<script language="javascript">ComComboObject('combo4', 2, 60 , 0, 0, true)</script></td>
						<td width="120" class="stm">Location&nbsp;<input type="text" name="to_org_dest_location" caption="Location" maxlength="5" fullfill class="input" value="" dataformat="engup" style="width: 60; ime-mode: disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"	OnKeyUp="checkLocation(this)"></td>
					</tr>
				</table>

				<!--  biz_3   (E) --></td>
			</tr>
		</table>
        <table class="height_5">
    <tr>
        <td></td>
    </tr>
</table>
		<!-- : ( Search Options ) (E) --></td>
	</tr>
</table>



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right">
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
<!-- : ( Button : pop ) (E) --> 
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet1');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
</form>
</body>
</html>
