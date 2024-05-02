<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0361_01.jsp
*@FileTitle : Export / Import Information (USA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.06.10 최도순
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2010.11.29 김진승 [CHM-201006689-01] Tax ID 남미 3개국 신규 추가
* 2011.05.17 최도순 [CHM-201110713-01] 미주 T&E,IE화물구분표시 및 관련정보 조회기능 개발(*PKGSC로 미주업무 이행관련)
* 2012.08.03 이재위 [CHM-201219301] Split 01-[M&D Export&Import Information] Israel VAT ID추가
* 2012.10.16 이재위 [CHM-201220434] [M&D Export/Import Information] Lebanon의 VAT ID추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%

	EsmBkg036101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.outboundblmgt.bldocumentation");

	/*
	*/
	String bkg_no = "";
	String io_bnd_cd = "";
	String pol_cd = "";
	String pod_cd = "";
	String go_cnt_cd = "";
	String pkg_qty = "";
	String wgt_qty = "";
	String pkg_tp = "";
	String wgt_tp = "";

	String popUpTpCd   = "";
    String xter_sndr_id  = "";
    String xter_rqst_no  = "";
    String xter_rqst_seq = "";

	List<XptImpLicVO> xptImpLicVO = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg036101Event)request.getAttribute("Event");
		bkg_no       = event.getBkgNo();
		io_bnd_cd    = event.getIoBndCd();

		pol_cd		 = event.getPolCd();
		pod_cd       = event.getPodCd();
		go_cnt_cd    = (event.getGoCntCd()==null ||event.getGoCntCd().length()==0) ? "" : event.getGoCntCd();
		pkg_qty		 = (event.getPkgQty()==null ||event.getPkgQty().length()==0) ? "0" : event.getPkgQty();
		wgt_qty		 = (event.getWgtQty()==null ||event.getWgtQty().length()==0) ? "0" : event.getWgtQty();
		pkg_tp		 = event.getPkgTp();
		wgt_tp       = event.getWgtTp();

		popUpTpCd       = event.getPopUpTpCd();
		xter_sndr_id    = event.getXterSndrId();
		xter_rqst_no    = event.getXterRqstNo();
		xter_rqst_seq   = event.getXterRqstSeq();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xptImpLicVO = (List<XptImpLicVO>) eventResponse.getCustomData("xptImpLicVO");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Export / Import Information (USA)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="_self">

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


<body class="popup_bg" onLoad="setupPage();">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Export / Import Information
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0">
       	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- Tab (E) -->
		<!-- : ( Search Options ) (S) -->
		<!--biz page (S)-->


<!--TAB Export (S) -->
<div id="tabLayer" style="display:inline">
<form name="form" style="margin:0px;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="io_bnd_cd" value="O">
<input type="hidden" name="exp_io_bnd_cd" value="O">
<input type="hidden" name="exp_xpt_imp_seq" value="1">
<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">
<input type="hidden" name="exp_vin_ctnt">
<input type="hidden" name="exp_old_vin_ctnt">

		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:484;">
				<tr class="h23">

								<td width="60">Country</td>
								<td width=""><select style="width:280;" name="exp_cnt_cd" onChange="javascript:goCtnCd(this);">
								<option value="BR" >BRAZIL</option>
								<option value="CA" >CANADA</option>
								<option value="CO" >COLOMBIA</option>
								<option value="EC" >ECUADOR</option>
								<option value="IN" >INDIA</option>
								<option value="ID" >INDONESIA</option>
								<option value="IL" >ISRAEL</option>
								<option value="KR" >KOREA</option>
								<option value="LB" >LEBANON</option>
								<option value="MX" >MEXICO</option>
								<option value="PE" >PERU</option>
								<option value="TR" >TURKEY</option>
								<option value="US" selected>USA</option>
								<option value="TG" >TOGO</option>
								<option value="NG" >NIGERIA</option>
								</select>
								</td>

				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Automated Export System Internal Transaction Number (for USA)</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0">
				<tr class="h23">
					<td width="80">Booking No.</td>
					<td width=""><input type="text" name="exp_bkg_no" style="width:110;" class="input2" value="<%=bkg_no%>" readOnly></td>
					</tr>
				</table>

				<table class="search" border="0">
				<tr class="h23">
					<td width="150"><input type="checkbox" value="AE" class="trans" name="exp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">AES (AES ITN)</td>
					<td width="420" colspan="4" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt" readOnly>&nbsp;<input type="text" style="width:183;" class="input" size="15" value="" name="exp_aes_inlnd_trns_no" dataformat="aesno" maxlength="15">&nbsp;Consol<input type="checkbox" value="Y" class="trans" name="aes_tp_prn_flg"></td>
					</tr>
					<tr class="h23">
					<td width="150"><input type="checkbox" value="PA" class="trans" name="exp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">PTA (Post Agent)</td>
					<td width="90"style="padding-left:2"><input type="text" style="width:91;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="exp_aes_pta_no1" dataformat="int"></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="exp_aes_pta_no2" dataformat="int"></td>
					<td width="140"><input type="text" style="width:72;" class="input" name="exp_aes_pta_dt" dataformat="mdy" maxlength="8" ></td>
					</tr>
					<tr class="h23">
					<td width=""><input type="checkbox" value="PU" class="trans" name="exp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">PTU (Post USPPI)</td>
					<td width=""style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt" readOnly></td>
					<td width=""><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="exp_aes_ptu_no" dataformat="int"></td>
					<td width="" colspan="2"><input type="text" style="width:72;" class="input" name="exp_aes_ptu_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
					</tr>
					<tr class="h23">
					<td width=""><input type="checkbox" value="DN" class="trans" name="exp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">Down(AES Down)</td>
					<td width=""style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt" readOnly></td>
					<td width=""><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="exp_aes_dwn_no" dataformat="int"></td>
					<td width="" colspan="2"><input type="text" style="width:72;" class="input" name="exp_aes_dwn_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
					</tr>
					<tr class="h23">
					<td width=""><input type="checkbox" value="EX" class="trans" name="exp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">Exception</td>
					<td width="" colspan="4" style="padding-left:4"><script language="javascript">ComComboObject("exp_aes_expt_id", 1, 278, 1);</script></td>
					</tr>
					<tr class="smt">
					<td width="" align="right">(Manual Input)&nbsp;&nbsp;</td>
					<td width="" colspan="4"><textarea cols="10" rows="2" style="width:375;" class="" name="exp_aes_expt_ctnt" maxlength="30" onblur="javascript:checkSpace(this);"></textarea></td>
					</tr>
				</table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Entry Class & IN-Bond Nbr. Info"</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				
				<table class="search" border="0">
					<tr class="h23">
				    <td width="100" align="right">  Entry Class: &nbsp;&nbsp;</td>
					<td width="80"><input type="checkbox" value="TE" class="trans" name="exp_entr_clss_tp_cd" onclick="radioChkCtrl('1')">T&E(62)</td>
					<td width="80"><input type="checkbox" value="IE" class="trans" name="exp_entr_clss_tp_cd" onclick="radioChkCtrl('2')">I.E(63)</td>
					<td width="220" align="right">
					</tr>
					<tr class="h23">
					<td width="120" align="right"> &nbsp;&nbsp;In-Bond Nbr &nbsp;&nbsp;</td>
					<td width="" colspan="3"><textarea cols="10" rows="2" style="width:375;" class="" name="exp_entr_clss_rmk" maxlength="100"></textarea></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<table class="search" border="0">
				<tr class="h23">
					<tr class="h23"> 
					<td width="50">Vehicle</td>
					<td width="45"><input type="text" style="width:25;" class="input2" name="exp_veh_cmdt_flg" dataformat="engup"></td>
					<td width="48">VIN No.</td>
					<td width="23"><input type="checkbox" value="Y" class="trans" name="vin_exist_flg" disabled></td>
					<td width="30"><img name="btn_vinNo" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="" class="stm"><input type="checkbox" name="exp_vin_no_cpy_desc_flg" class="trans" value="Y" onClick="javascript:copyToDesc(this);">Copy to Description </td>
					</tr>

				</table>
			</td></tr>
		</table>

<table class="height_5"><tr><td></td></tr></table>

		<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" style="position:absolute;margin:10px 10px 10px -10px;width:600px">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       		<tr><td class="btn3_bg" >
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table></td></tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
	<!-- : ( Button : pop ) (E) -->
</form>
</div>
<!--TAB Export (E) -->

<!--TAB Import (E) -->
<div id="tabLayer" style="display:none">
<form name="form2" style="margin:0px;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="io_bnd_cd" value="I">
<input type="hidden" name="imp_io_bnd_cd" value="I">
<input type="hidden" name="imp_xpt_imp_seq" value="1">
<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">

<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">

		<table class="search">
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:484;">
				<tr class="h23">

								<td width="60">Country</td>
								<td width=""><select style="width:280;" name="imp_cnt_cd" onChange="javascript:goCtnCd(this);">
								<option value="BR" >BRAZIL</option>
								<option value="CO" >COLOMBIA</option>
								<option value="EC" >ECUADOR</option>
								<option value="IN" >INDIA</option>
								<option value="ID" >INDONESIA</option>
								<option value="IL" >ISRAEL</option>
								<option value="LB" >LEBANON</option>
								<option value="MX" >MEXICO</option>
								<option value="PE" >PERU</option>
								<option value="TR" >TURKEY</option>
								<option value="TG" >TOGO</option>
								<option value="NG" >NIGERIA</option>
								</select>
								</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Automated Import System Internal Transaction Number (for USA)</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table class="search" border="0">
				<tr class="h23">
					<td width="80">Booking No.</td>
					<td width=""><input type="text" name="imp_bkg_no" style="width:110;" class="input2" value="<%=bkg_no%>" readonly></td>
					</tr>
				</table>

				<table class="search" border="0">
				<tr class="h23">
					<td width="150"><input type="checkbox" value="AE" class="trans" name="imp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;AES (AES ITN)</td>
					<td width="420" colspan="4" style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AES ITN" name="aes_inlnd_trns_pfx_ctnt" readOnly>&nbsp;<input type="text" style="width:183;" class="input" size="15" value="" name="imp_aes_inlnd_trns_no" dataformat="aesno" maxlength="15"></td>
					</tr>
					<tr class="h23">
					<td width="150"><input type="checkbox" value="PA" class="trans" name="imp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;PTA (Post Agent)</td>
					<td width="90"style="padding-left:2"><input type="text" style="width:91;" class="input2" value="AESPOST" name="aes_pta_pfx_ctnt" readOnly></td>
					<td width="90"><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="imp_aes_pta_no1" dataformat="int"></td>
					<td width="90"><input type="text" style="width:90;" class="input"  minlength="9" maxlength="11" name="imp_aes_pta_no2" dataformat="int"></td>
					<td width="140"><input type="text" style="width:72;" class="input"  name="imp_aes_pta_dt" dataformat="mdy" maxlength="8">&nbsp;</td>
					</tr>
					<tr class="h23">
					<td width=""><input type="checkbox" value="PU" class="trans" name="imp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;PTU (Post USPPI)</td>
					<td width=""style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESPOST" name="aes_ptu_pfx_ctnt" readOnly></td>
					<td width=""><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="imp_aes_ptu_no" dataformat="int"></td>
					<td width="" colspan="2"><input type="text" style="width:72;" class="input" name="imp_aes_ptu_dt" dataformat="mdy" maxlength="8"></td>
					</tr>
					<tr class="h23">
					<td width=""><input type="checkbox" value="DN" class="trans" name="imp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;Down (AES Down)</td>
					<td width=""style="padding-left:2"><input type="text" style="width:90;" class="input2" value="AESDOWN" name="aes_dwn_pfx_ctnt" readOnly></td>
					<td width=""><input type="text" style="width:90;" class="input" minlength="9" maxlength="11" name="imp_aes_dwn_no" dataformat="int"></td>
					<td width="" colspan="2"><input type="text" style="width:72;" class="input" name="imp_aes_dwn_dt" dataformat="mdy" maxlength="8"></td>
					</tr>
					<tr class="h23">
					<td width=""><input type="checkbox" value="EX" class="trans" name="imp_aes_tp_cd" onClick="javascript:radioBtnSet(this)">&nbsp;Exception</td>
					<td width="" colspan="4" style="padding-left:4"><script language="javascript">ComComboObject("imp_aes_expt_id", 1, 278, 1);</script></td>
					</tr>
					<tr class="smt">
					<td width="" align="right">(Manual Input)&nbsp;&nbsp;</td>
					<td width="" colspan="4"><textarea cols="10" rows="2" style="width:375;" class="" name="imp_aes_expt_ctnt" maxlength="30"></textarea></td>
					</tr>
				</table>

			</td></tr>
		</table>

<table class="height_5"><tr><td></td></tr></table>

		<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" style="position:absolute;margin:10px 10px 10px -10px;width:600px">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete2">Delete</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save2" id="btn_save2">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close2">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table></td></tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</div>
<!--TAB Import (E) -->

<!-- : ( Search Options ) (E) -->
</td></tr>
</table>



				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->


<form name="form3">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="get_io_bnd_cd" value="<%=io_bnd_cd%>">
<input type="hidden" name="pkg_qty" value="<%=pkg_qty%>">
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">
</form>
<form name="form4">
<input type="hidden" name="tabclosechk">
<input type="hidden" name="savechk">
</form>
<form name="urlForm"></form>
</body>
</html>
