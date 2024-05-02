<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1105.jsp
*@FileTitle : Europe Advanced Manifest - Diversion Request
*Open Issues :
*Change history :
*@LastModifyDate : 2010-09-07
*@LastModifier : 계기훈
*@LastVersion : 1.0
* 2010-09-07 계기훈
* 1.0 Creation
* 1.1 2015.12.02 [CHM-201538926]	[ENS] WAND1543N 항차 / POFE calling seq 적용 로직 테스트
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1105Event  event = null;		//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (EsmBkg1105Event)request.getAttribute("Event");
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
<title>esm_bkg_1105</title>
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
<input type="hidden" name="cvy_ref_no">							
<input type="hidden" name="form_cvy_ref_no_hidden">
<input type="hidden"  name="vvd">
<input type="hidden" name="cstms_port_cd">
<input type="hidden" name="cstms_yd_cd">
<input type="hidden" name="p_vvd_cd">
<input type="hidden" name="form_ibflag">
<input type="hidden" name="form_rvis_n1st_clpt_cd_old">
<input type="hidden" name="rvis_n1st_clpt_cd">
<input type="hidden" name="eur_edi_msg_tp_id" value = "DIV">
<input type="hidden" name="rvis_cstms_yd_cd">
<input type="hidden" name="form_rvis_cstms_yd_cd">
<input type="hidden" name="dvs_rqst_smt_flg">
<input type="hidden" name="form_dvs_edi_svc_flg">
<input type="hidden" name="form_dvs_rqst_edi_svc_flg">
<input type="hidden" name="cstms_port_clpt_ind_seq">

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
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">VVD CODE</td>
					<td width="120">
						<input type="text" style="width:80" class="input1" name="form_vvd"  required dataformat="engnumup" maxlength="9" fullfill caption="VVD" >
					</td>
					<td width="70">CRN No.</td>
					<td width="120">
						<input type="text" style="width:80" class="input1" name="form_cvy_ref_no"  dataformat="engnumup" maxlength="50"  caption="CRN No." >

					</td>
					<td width="180">POFE(Port of 1st Entry)</td>
					<td width="" >
						<script language="javascript">ComComboObject('form_first_eu_port', 1, 90, 1, 0);</script>&nbsp;
						<input type="text" style="width:60" class="input2" readOnly="true" name="form_cstms_yd_cd" dataformat="engupnum" maxlength="7" caption="Yard">
					</td>
				</tr> 
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="160">Vessel Name</td>
					<td width="170" >
						<input type="text" style="width:160" class="input2" readOnly="true" name="form_vsl_eng_nm" maxlength="50">
					</td>
					<td width="140">Lloyd No.(IMO)</td>
					<td width="100">
						<input type="text" style="width:80" class="input2" readOnly="true" name="form_lloyd_no" dataformat="eng" maxlength="20">
					</td>
					<td width="80">Vessel Flag</td>
					<td width="" colspan=3>
						<input type="text" style="width:200" class="input2" readOnly="true" name="form_piclb_desc" dataformat="eng" maxlength="100">
					</td>
					<td width="60">Operator</td>
					<td width="" colspan=3>
						<input type="text" style="width:40" class="input2" readOnly="true" name="form_crr_cd" dataformat="eng" maxlength="10">
					</td>					
				</tr> 
				<tr class="h23">
					<td width="">Original Country & Port</td>
					<td width="" >
						<input type="text" style="width:80" class="input2"  readOnly="true" name="form_cstms_port_cd" dataformat="engup" maxlength="10">
					</td>
					<td width="">Original First Office</td>
					<td width="">
						<input type="text" style="width:80" class="input2" readOnly="true" name="form_n1st_port_ofc_cd" dataformat="eng" maxlength="10">
					</td>
					<td width="">ENS ETA</td>
					<td width="">
						<input type="text" style="width:120" class="input2" readOnly="true" name="form_init_eta_dt" caption="Estimated Time of Arrival">
					</td>
				</tr>
				<tr class="h23">
					<td width="">New Country & Port</td>
					<td width="" >
						<input type="text" style="width:80" class="input" name="form_rvis_n1st_clpt_cd"  dataformat="engup" maxlength="5" required>&nbsp;
						<script language="javascript">ComComboObject('form_tml_cd', 1, 90, 2, 0);</script>
					</td>
					<td width="">New First Office</td>
					<td>
						<input type="text" style="width:80" class="input2" name="form_n1st_port_ofc_cd_new" dataformat="eng" maxlength="10" readonly>
					</td>				
					<td width="">ETA</td>
					<td width="">
						<input type="text" style="width:120" class="input2" readOnly="true" name="form_eta_dt" caption="Estimated Time of Arrival">
					</td>
				</tr>
				<tr class="h23">
					<td width="">Last Calling Port</td>
					<td width="" >
						<input type="text" style="width:80" class="input2" name="form_lst_clpt_cd" dataformat="engup" maxlength="5">
					</td>
					<td width="">Next Calling Port</td>
					<td width="" colspan=3>
						<input type="text" style="width:80" class="input2" name="form_nxt_clpt_cd" dataformat="engup" maxlength="5">
					</td>
				</tr> 
				<tr class="h23">
					<td width=""  colspan=2>
						D/R submitted by Other Operator
						&nbsp;
						<input type="checkbox" style="width:20" class="input" name="form_dvs_rqst_smt_flg" >
					</td>
				</tr> 				
			</table>
				<!--  biz_1   (E) -->
		</td></tr>
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
								<td width="145">Updated Date</td>
								<td width="210">
									<input type="text" style="width:110" class="input2" name="form_upd_dt"  dataformat="eng">
								</td>
								<td width="30">By</td>
								<td width=""  colspan=5>
									<input type="text" style="width:80" class="input2" name="form_upd_usr_id"  dataformat="eng" maxlength="10">
									<input type="text" style="width:80" class="input2" name="form_upd_ofc_cd"  dataformat="eng" maxlength="10">
								</td>
							</tr>
							<tr class="h23">
								<td width="145">(GMT)</td>
								<td width="210" colspan=8>
									<input type="text" style="width:110" class="input2" name="form_upd_dt_gmt"  dataformat="eng">
								</td>
							</tr> 										
							<tr class="h23">
								<td width="145">EDI Transmission Date</td>
								<td width="210">
									<input type="text" style="width:110" class="input2" name="form_snd_dt"  dataformat="eng">
								</td>
								<td width="30">By</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_snd_usr_id"  dataformat="eng" maxlength="10">
									<input type="text" style="width:80" class="input2" name="form_snd_ofc_cd"  dataformat="eng" maxlength="10">
								</td>
								<td width="">EDI ACK</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_ack"  dataformat="eng" maxlength="10">
								</td>
								<td width="">
									<input type="text" style="width:110" class="input2" name="form_edi_rcv_dt"  dataformat="eng">
									<img src="img/btns_search.gif" name='btn_viewMsg' width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr> 
							<tr class="h23">
								<td width="145">(GMT)</td>
								<td width="210">
									<input type="text" style="width:110" class="input2" name="form_snd_dt_gmt"  dataformat="eng">
								</td>
								<td width="30"></td>
								<td width=""></td>
								<td width="">(GMT)</td>
								<td width=""></td>
								<td width="">
									<input type="text" style="width:110" class="input2" name="form_edi_rcv_dt_gmt"  dataformat="eng">
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
	</td></tr>
		</table>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="10" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg">	
<!--  biz_1  (S) -->
						<table class="search" border="0" > 
							<tr class="h23">
								<td>
									* In case Operator is not SML, Transmit button becomes disabled instead of transmit EDI, you should click on D/R submitted by Other Operator and click "Save" button to prevent origin office not to send ENS EDI after D/R EDI is submitted by other operator.
									<br>* Transmit button will become activated from 3 days before ETA of new port.
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
									* POFE ETA time is inserted as 12:00 when the vessel operator code is HPL/UAC/MSK (Hard-Coding).
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->					
					</td>
				</tr>
			</table>						
		</td></tr>
		</table>
    	<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
