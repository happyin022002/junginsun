<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1104.jsp
*@FileTitle : Europe Advanced Manifest - Arrival Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2010-09-07
*@LastModifier : 계기훈
*@LastVersion : 1.0
* 2010-09-07 계기훈
* 1.0 Creation
*--------------------------------------------------------
* History
* 2013.05.13 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
* 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
* 2015.12.02 [CHM-201538926]	[ENS] WAND1543N 항차 / POFE calling seq 적용 로직 테스트
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1104Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount	 = 0;				//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>esm_bkg_1104</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.form_vvd.focus();
	}

</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">
<input type="hidden" name="p_vvd_cd">
<input type="hidden" name="vvd">
<input type="hidden" name="cvy_ref_no">
<input type="hidden" name="form_cstms_port_cd">
<input type="hidden" name="cstms_yd_cd">
<input type="hidden" name="form_cvy_ref_no_hidden">
<input type="hidden" name="form_ibflag">
<input type="hidden" name="eur_edi_msg_tp_id" value = "ARN">
<input type="hidden" name="form_an_edi_svc_flg">
<input type="hidden" name="form_init_eta_dt_old">
<input type="hidden" name="init_eta_dt_modi_flg" value="N">
<input type="hidden" name="cstms_port_clpt_ind_seq">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<!-- 1 (S) -->
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg">
					<!--  biz_1  (S) -->
						<div id="ensView" style="display:none">
						<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="129">Type</td>
							<td width="">
								<script language="javascript">ComComboObject('p_type', 1, 110, 1, '');</script>
							</td>
							<td width="800"></td>
						</tr>
						</table>
							</div>
						<!-- ENS start-->
						<div id="ensView" style="display:inline">
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="120">VVD CODE</td>
									<td width="170">
										<input type="text" style="width:80" class="input1" name="form_vvd" dataformat="engnumup" maxlength="9" fullfill caption="VVD" >
									</td>
									<td width="120">CRN No.</td>
									<td width="100">
										<input type="text" style="width:80" class="input" name="form_cvy_ref_no" dataformat="engnumup" maxlength="50" caption="CRN No." >
									</td>
									<td width="180">POFE(Port of 1st Entry)</td>
									<td width="" >
										<script language="javascript">ComComboObject('cstms_port_cd', 1, 90, 1, 0, false);</script>
										<input type="text" style="width:60" class="input2" readOnly="true" name="form_cstms_yd_cd" dataformat="engup" maxlength="10" caption="Yard">
									</td>								
								</tr> 
							</table>
						</div>
						<!-- ENS end -->
		
						<!-- Finland start -->
						<!-- <div id="fiView" style="display:inline">
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="120">VVD CODE</td>
									<td width="170">
										<input type="text" style="width:80" class="input1" name="form_fi_vvd" dataformat="engnumup" maxlength="9" fullfill caption="VVD" >
									</td>
									<td width="120">CRN No.</td>
									<td width="100">
										<input type="text" style="width:80" class="input" name="form_fi_cvy_ref_no" dataformat="engnumup" maxlength="50" caption="CRN No." >
									</td>
									<td width="140">POD</td>
									<td width="">
										<input type="text" style="width:60" class="input2" readOnly="true" name="form_fi_cstms_yd_cd" value="FIKTK" dataformat="engup" maxlength="5">
									</td>								
								</tr> 
							</table>
						</div>-->
						<!-- Finland end -->
						
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="120">Vessel Name</td>
								<td width="170" >
									<input type="text" style="width:160" class="input2" readOnly="true" name="form_vsl_eng_nm" maxlength="50">
								</td>
								<td width="120">Lloyd No.(IMO)</td>
								<td width="100">
									<input type="text" style="width:80" class="input2" readOnly="true" name="form_lloyd_no" dataformat="eng" maxlength="20">
								</td>
								<td width="80">Vessel Flag</td>
								<td width="">
									<input type="text" style="width:200" class="input2" readOnly="true" name="form_piclb_desc" dataformat="eng" maxlength="100">
								</td>
								<td width="60">Operator</td>
								<td width="" >
									<input type="text" style="width:40" class="input2" readOnly="true" name="form_crr_cd" dataformat="eng" maxlength="10">
								</td>									
							</tr> 
							
							<!-- ENS start-->
							<tr class="h23" id="ensEtaView">
								<td width="">ENS ETA</td>
								<td width="">
									<input type="text" style="width:120" class="input2" name="form_init_eta_dt" id="form_init_eta_dt" caption="Estimated Time of Arrival">
									<input type="checkbox" value="" class="trans" name="modify_ens_eta" id="modify_ens_eta" disabled="true">
								</td>
								<td width="">ETA</td>
								<td width="">
									<input type="text" style="width:120" class="input2" readOnly="true" name="form_eta_dt" caption="Estimated Time of Arrival">
								</td>
								<td width="">ETD</td>
								<td width="" colspan=3>
									<input type="text" style="width:120" class="input2" readOnly="true" name="form_etd_dt" caption="Estimated Departure Date">
								</td>
							</tr>
							<!-- ENS end -->
			
							<!-- Finland start -->
							<!--<tr class="h23" id="fiEtaView">
								<td width="">ETA</td>
								<td width="">
									<input type="text" style="width:120" class="input2" readOnly="true" name="form_fi_eta_dt" caption="Estimated Time of Arrival">
								</td>
								<td width="">ETD</td>
								<td width="" colspan=3>
									<input type="text" style="width:120" class="input2" readOnly="true" name="form_fi_etd_dt" caption="Estimated Departure Date">
								</td>
							</tr>-->
							<!-- Finland end -->
											
							<tr class="h23">	
								<td width="">First Office</td>
								<td>
									<input type="text" style="width:80" class="input2" readOnly="true" name="form_n1st_port_ofc_cd" dataformat="eng" maxlength="10" caption="First Port Office Code">
								</td>
								<td width="">Calling Terminal</td>
								<td colspan=3>
									<input type="text" style="width:80" class="input2" readOnly="true" name="form_tml_cd" dataformat="engup" maxlength="15" caption="Terminal Code">
									<input type="text" style="width:240" class="input2" readOnly="true" name="form_tml_nm" dataformat="engup" maxlength="50" caption="Terminal Name">
								</td>
							</tr> 
							<tr class="h23">
								<td width="">Last Calling Port</td>
								<td width="" >
									<input type="text" style="width:80" class="input" name="form_lst_clpt_cd" dataformat="engup" maxlength="5">
								</td>
								<td width="">Next Calling Port</td>
								<td width="">
									<input type="text" style="width:80" class="input" name="form_nxt_clpt_cd" dataformat="engup" maxlength="5">
								</td>
							</tr> 
							<tr class="h23">
								<td width="">Cert. Reg No.</td>
								<td width="" >
									<input type="text" style="width:80" class="input2" name="form_rgst_no" dataformat="eng" maxlength="15">
								</td>
								<td width="">Cert. Reg Date</td>
								<td width="">
									<input type="text" style="width:100" class="input2" name="form_rgst_dt" dataformat="ymd" maxlength="10">
								</td>
								<td width="">Cert. Reg Location</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_rgst_port_cd" dataformat="engup" maxlength="5">
								</td>
							</tr> 
							<tr class="h23">	
								<td width="">Gross Ton</td>
								<td>
									<input type="text" style="width:80" class="input2" name="form_grs_rgst_tong_wgt" dataformat="num" maxlength="15">
								</td>
								<td width="">Net Ton</td>
								<td colspan=5>
									<input type="text" style="width:80" class="input2" name="form_net_rgst_tong_wgt" dataformat="num" maxlength="15">
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>	
<!-- 1 (E) -->

<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg">	
<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="145">EDI Transmission Date</td>
								<td width="210">
									<input type="text" style="width:200" class="input2" name="form_snd_dt"  dataformat="eng">
								</td>
								<td width="30">By</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_snd_usr_id"  dataformat="eng" maxlength="10">
									<input type="text" style="width:80" class="input2" name="form_snd_ofc_cd"  dataformat="eng" maxlength="10">
								</td>
								<td width="">EDI ACK</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_ack"  dataformat="eng" maxlength="10">
									<input type="text" style="width:80" class="input2" name="form_result"  dataformat="eng" maxlength="10">
									<img src="img/btns_search.gif" name='btn_viewMsg' width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>								
							</tr> 
						</table>
<!--  biz_1   (E) -->					
					</td>
				</tr>
			</table>
<!-- 2 (E) -->		
<!--biz page (E)-->
<!--biz page 2 (S)-->
			<table width="100%" id="mainTable" style="display:none">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
			</table>
<!--biz page 2 (E)-->
		</td>
	</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="10" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	<tr>
		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="b_MrnDelete" style="display:none">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_MrnDelete">All MRN Delete</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_transmit">Transmit</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg">	
<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td>
									* Transmit button becomes disabled in case Operator is not SML or the customs of First EU Port does not require A/N EDI.
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->					
					</td>
				</tr>
			</table>	
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg">	
<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td>
									* POFE ETA time is inserted as 12:00 when the vessel operator code is HPL/UAC/MSK/EGL (Hard-Coding).
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->					
					</td>
				</tr>
			</table>		
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"style="display:none"> 
				<tr>
					<td class="bg">	
<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="145">FlatFile</td>
							</tr> 
							<tr class="h23">
								<td>
									<textarea name="flatfile" cols="600" rows="20"  wrap="hard" style="width: 100%; background-color: #FBFBFB; border: 1 solid #AEAEAE;"  style="overflow:hidden; ime-mode:disabled;"></textarea>
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->					
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>