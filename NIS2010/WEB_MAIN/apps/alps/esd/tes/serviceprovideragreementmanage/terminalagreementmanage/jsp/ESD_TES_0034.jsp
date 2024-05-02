<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0034.jsp
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성

*@LastModifyDate : 2009.08.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.24 yOng hO lEE
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0034Event"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EsdTes0034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한	에러

	String strErrMsg			= "";			//에러메세지
	int rowCount	 			= 0;			//DB ResultSet 리스트의 건수

	String userId				= "";
	String ofc_cd				= "";

	String tml_agmt_crr_flg 	= "";
	String tml_agmt_ofc_cty_cd 	= "";
	String tml_agmt_ver_no 		= "";

	String yd_cd 				= "";
	String yd_cd_name 			= "";
	String vndr_seq 			= "";
	String vndr_seq_name 		= "";
	String eff_fm_dt 			= "";
	String eff_to_dt 			= "";
	String auto_xtd_flg 		= "";
	String ctrt_ofc_cd 			= "";
	String cre_usr_id 			= "";
	String cre_dt 				= "";
	String upd_usr_id 			= "";
	String upd_dt 				= "";
	String inquiryFlg 			= "";
	// 비용지급 전표 결재 기능 - 3차 GW LINK - (4347-09-24)
	String csrGwUrl				= "";

	String referer = JSPUtil.getNull(request.getHeader("REFERER"));
	String templateKey = null;
	
	if(referer.equals("ESD_TES_0039.do"))
	{
 		tml_agmt_crr_flg  = "Y";
	}

	tml_agmt_ofc_cty_cd	= JSPUtil.getParameter(request, "tml_agmt_ofc_cty_cd".trim(), "");
	tml_agmt_ver_no		= JSPUtil.getParameter(request, "tml_agmt_ver_no 	".trim(), "");
	inquiryFlg			= JSPUtil.getParameter(request, "inquiryFlg 		".trim(), "");
	yd_cd				= JSPUtil.getParameter(request, "yd_cd 				".trim(), "");
	yd_cd_name			= JSPUtil.getParameter(request, "yd_cd_name         ".trim(), "");
	vndr_seq			= JSPUtil.getParameter(request, "vndr_seq 			".trim(), "");
	vndr_seq_name		= JSPUtil.getParameter(request, "vndr_seq_name      ".trim(), "");
	eff_fm_dt			= JSPUtil.getParameter(request, "eff_fm_dt 		    ".trim(), "");
	eff_to_dt			= JSPUtil.getParameter(request, "eff_to_dt 		    ".trim(), "");
	auto_xtd_flg		= JSPUtil.getParameter(request, "auto_xtd_flg 	    ".trim(), "");
	ctrt_ofc_cd			= JSPUtil.getParameter(request, "ctrt_ofc_cd 	    ".trim(), "");
	cre_usr_id			= JSPUtil.getParameter(request, "cre_usr_id 		".trim(), "");
	cre_dt				= JSPUtil.getParameter(request, "cre_dt 			".trim(), "");
	upd_usr_id			= JSPUtil.getParameter(request, "upd_usr_id 		".trim(), "");
	upd_dt				= JSPUtil.getParameter(request, "upd_dt 			".trim(), "");

	try {

		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId	= account.getUsr_id();
		ofc_cd	= account.getOfc_cd();

		event = (EsdTes0034Event)request.getAttribute("Event");
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		// Excel Template File Key
		//templateKey = (String)eventResponse.getCustomData("templateKey");

		// 비용지급 전표 결재 기능 - 3차 GW LINK - (4347-09-24)
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	String actionVolUOMBox 	= JSPUtil.getCodeCombo("tml_agmt_vol_ut_cd", "01", "onChange='selectVolUOM();'", "CD00177", 0, "1::");
	/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 (CAHD 2015-06-25) null값 제거  */
	/* 
	String actionBoundBox 	= JSPUtil.getCodeCombo("io_bnd_cd", "01", "", "CD00890", 0, "1::");
	String actionIOBox 		= JSPUtil.getCodeCombo("ioc_cd", "01", "", "CD00887", 0, "1::");
 	*/	
	String actionBoundBox 	= JSPUtil.getCodeCombo("io_bnd_cd", "01", "", "CD00890", 0, "");
	String actionIOBox 		= JSPUtil.getCodeCombo("ioc_cd", "01", "", "CD00887", 0, "");
	String srAgmtTypeBox 	= JSPUtil.getCodeCombo("tml_sto_agmt_tp_cd", "01", "", "CD00169", 0, "");
%>
<html>
<head>
<title>Terminal Agreement Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("vol_ut_cd", "01", "CD00177", 0, "")%>
	/* CHM-201536510 IO, IPCOcean, Mode, Lane에서 Null(Blank)값 삭제 요청 (CAHD 2015-06-25) null값 제거  */
	<%//= JSPUtil.getIBCodeCombo("io_bnd_cd", "01", "CD00890", 0, "1::")%>
	<%//= JSPUtil.getIBCodeCombo("ioc_cd", "01", "CD00887", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_cd", "01", "CD00890", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("ioc_cd", "01", "CD00887", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("thc_tp_cd", "01", "CD00161", 2, "1::")%>
	<%= JSPUtil.getIBCodeCombo("tml_sto_agmt_tp_cd_cd", "01", "CD00169", 0, "")%>
	var agmt_no = '<%=JSPUtil.getNull(tml_agmt_ofc_cty_cd)%>';
	var agmt_ver_no = '<%=JSPUtil.getNull(tml_agmt_ver_no)%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
//### =========================================================================
//### 탭을 사용하는 화면인 경우 추가한다.
		 //InitTab();
//### =========================================================================
		initFormValue();
		initFormDisabled();
		loadPage();

	<%if(!tml_agmt_ofc_cty_cd.equals("") && !tml_agmt_ver_no.equals("")){%>
	//		detailRetrieve('<%=tml_agmt_ofc_cty_cd%>','<%=tml_agmt_ver_no%>');
	<%}%>
	}
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage()">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="loop_value">
<input type="hidden" name="tml_agmt_sts_cd">
<input type="hidden" name="tml_agmt_tp_cd">
<input type="hidden" name="lgs_cost_cd">
<input type="hidden" name="tml_agmt_vol_ut_cd">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="curr_cd">
<input type="hidden" name="select_tab">
<input type="hidden" name="sheet_prefix">
<input type="hidden" name="regAgmtFlg">
<input type="hidden" name="regAgmtHDRFlg">
<input type="hidden" name="initFormDTLFlg">
<input type="hidden" name="agmtHDRCreAdjFlg">
<input type="hidden" name="command_h">
<input type="hidden" name="is_valid_yd_cd">
<input type="hidden" name="yd_cd_hidden">
<input type="hidden" name="yd_cd_deltflg">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">
<input type="hidden" name="input_list_verify_flg">
<input type="hidden" name="thrpFlg">
<input type="hidden" name="vfsArray">
<input type="hidden" name="fileImportFlg">
<input type="hidden" name="lane_cdString">
<input type="hidden" name="copy_tml_agmt_ofc_cty_cd">
<input type="hidden" name="agmt_confirm_flg">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="upd_usr_id" value="<%=userId%>">
<input type="hidden" name="inquiryFlg" value="<%=inquiryFlg%>">
<input type="hidden" name="pop_cost_cd">
<input type="hidden" name="pop_sheetObj">
<input type="hidden" name="pop_row">
<input type="hidden" name="pop_agmt_rmk">
<input type="hidden" name="pop_mode">
<input type="hidden" name="acct_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="rhq_ofc_cd" value="">
<!-- // 비용지급 전표 결재 기능 - 3차 GW LINK - (4347-09-24) -->
<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_delete" id="btn_delete">Delete</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_volcaam" id="btn_volcaam">Vol.Acc.M</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn1_Attach_File" id="btn1_Attach_File">Excel Form</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




	<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="110"><img class="nostar">Agreement No.</td>
					<td width="140">&nbsp;<input type="text" name="tml_agmt_ofc_cty_cd" maxlength="8" style="width:130" class="input1" value="" onKeyUp='isApNum2(this);' onKeyDown='chkInput(this);' readOnly></td>
					<td width="140"><img class="nostar">Agreement Version</td>
					<td width="120"><input type="text" name="tml_agmt_ver_no" style="width:110" class="input1" readOnly></td>
					<td width="140"><img class="nostar">GW Contract Link</td>
					<td width=""><input type="text" id="agmt_doc_desc" name="agmt_doc_desc" style="width:180" class="input1" readOnly OnClick="ContractView()">
					<input type="hidden" id="agmt_doc_no" name="agmt_doc_no" style="width:200">
					&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_contractlink" id="btn_contractlink"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_contractsave" id="btn_contractsave">SAVE</td><td class="btn2_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btn_contractdelete" id="btn_contractdelete">DEL</td><td class="btn2_right"></td></tr></table></td>
				</tr>

				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information  ) (S) -->
		<table class="search">
        		<tr><td class="bg">
        		<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="110"><img class="nostar">Yard</td>
						<td width="400">&nbsp;<input class="input1" type="text" name="yd_cd" value="" maxlength="7" style="width:70" onKeyUp='isApNum2(this);' onKeyDown='chkInput(this);' onBlur='validateYardCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yard">&nbsp;<input class="input1" type="text" name="yd_cd_name" style="width:203" readonly></td>
						<td width="140"><img class="nostar">Service Provider</td>
						<td>&nbsp;<input class="input1" type="text" name="vndr_seq"  value="" maxlength="6" style="width:70" onKeyUp='isNum(this);' onKeyDown='chkInput(this);' onBlur='validateVendorCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr">&nbsp;<input class="input1" type="text" name="vndr_seq_name" style="width:201" readonly></td>
					</tr>
					<tr class="h23">
					   	<td colspan="2" width="510">
					   	<table border="0">
					   	<tr class="h23">
							<td width="110"><img class="nostar">Contract Office</td>
							<td width="100">&nbsp;<input class="input1" type="text" name="ctrt_ofc_cd" value="<%=ofc_cd%>" maxlength="6" style="width:92" onKeyUp='isApNum2(this);' onKeyDown='chkInput(this)'></td>
							<td width="100">&nbsp;&nbsp;Creation Office</td>
							<td width="200">&nbsp;&nbsp;&nbsp;<input class="input1" type="text" name="cre_ofc_cd" value="<%=ofc_cd%>" maxlength="6" style="width:92" readonly></td>
					   	</tr>
					   	</table>	
					   	</td> 
						
						
						<td width="140"><img class="nostar">Effective Date </td>
						<td >&nbsp;<input class="input1" type="text" style="width:70" name="eff_fm_dt" value="" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, this.form.eff_to_dt, 10);' onKeyDown='chkInput(this);'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input class="input1" type="text" style="width:70" name="eff_to_dt" value="" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='chkInput(this);' onBlur='validateDateObj(this);'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					</tr>
					<tr>
						<td colspan="2" width="510">
						<table border="0">
							<tr class="h23">
								<td width="110"><img class="nostar">Auto Extention</td>
								<td>
									<table class="sm" border="0" style="height:20; width:93; background-color: #E9E9E9;">
										<tr>
											<td  class="noinput1" width="100"><input type="radio" name="auto_xtd_flg" value="Y" class="trans" >Yes&nbsp;&nbsp;<input type="radio" name="auto_xtd_flg" value="N" class="trans" >No</td>
										</tr>
									</table>
								</td>
								<td width="100">&nbsp;&nbsp;<img class="nostar">Version Up</td>
								<td class="stm" width="200">&nbsp;&nbsp;&nbsp;<input type="radio" name="amend_flg" value="Y" class="trans" disabled>Yes&nbsp;&nbsp;<input type="radio" name="amend_flg" value="N" class="trans" disabled>No</td>
									
							</tr>
							</table>
							</td>
							<td width="140"><img class="nostar">AGMT Approval Date </td>
							<td >&nbsp;<input class="input1" type="text" style="width:70" name="agmt_apro_dt" value="" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, this.form.agmt_apro_dt, 10);' onKeyDown='chkInput(this);'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar3"></td>
									

					</tr>
					<tr>
						<td colspan="4">
							<table border="0">
								<tr class="h23">
									<td width="110"><img class="nostar">Remark</td>
									<td width="400">&nbsp;<input type="text" name="agmt_rmk" style="width:230" value="" ></td>
									<%--
									// AGMT Confirm Date Mandatory Check - 4347.07.22 
									// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : YSY B 4347-08-27) 
									--%>
									<td style="display:none;">&nbsp;<input class="input1" type="hidden" style="width:70" name="agmt_cfm_dt" value="" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");tes_moveFocus(this, this.form.agmt_cfm_dt, 10);' onKeyDown='chkInput(this);' !OnFocus="ComShowCodeMessage('TES10130')">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar4"></td>
									<td width="252"><img class="nostar">AGMT Confirm (Manager Level) </td>
									<td width="145">
										<SELECT name="agmt_cfm_flg" id="agmt_cfm_flg"  style="width:80" OnChange="checkAgmtConfirm(this)">
											<OPTION  value=""> </OPTION>
											<OPTION  value="N">N</OPTION>
											<OPTION  value="Y">Y</OPTION>
										</SELECT>
									</td>
									
								</tr>
							</table>
						</td>
					</tr>					
				</table>
				<!-- : ( Week ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->



		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

<!-- ESD_TES_034 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




		    <table class="search_in" border="0">
		    	<tr><td class="bg">
				 	<table class="search" border="0">
		    			<tr class="h23">
		    				<td width="80">Cost Code</td>
						<td width="150" style="padding-left:2;"><script language="javascript">ComComboObject('lgs_cost_cd_t', 2, 90 , 1, 1)</script>
						</td>
						<td width="80">Auto Calc.</td>
						<td width="150" class="stm">
							<input type="radio" name="auto_calc_flg" value="Y" class="trans" disabled>Yes&nbsp;&nbsp;
							<input type="radio" name="auto_calc_flg" value="N" class="trans" disabled>No</td>
						<td width="307" class="bt">
							<div align="right">
								<table class="button" border="0" width="100%">
									<tr><td class="btn2_bg" class="align">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_registertpcc" id="t1btng_registertpcc">Register TP CC</td>
												<td class="btn2_right"></td>
												</tr></table></td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_save" id="t1btng_save">Save</td>
												<td class="btn2_right"></td>
												</tr></table></td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td></tr>
								</table>
							</div>
						</td>
					</tr>
		    			<tr class="h23">
		    				<td width="">Vol. UOM</td>
		    				<td width=""><%=actionVolUOMBox%></td>
		    				<td width="">Currency</td>
			    			<td width=""><script language="javascript">ComComboObject('curr_cd_t',1, 90 , 0 )</script></td>
			    			<td width="" class="bt">&nbsp;</td>
		    			</tr>
					</table>

				</td></tr>
			</table>


			<table class="height_10"><tr><td></td></tr></table>

			<table class="search_in" border="0">
				<tr>
					<td width="239" class="bg" valign="top">


				 	<table class="search" border="0">
		    				<tr class="h23">
							<td width="80" valign="middle">Bound</td>
							<td width="157" colspan="2"><%=actionBoundBox%></td>
						</tr>
						<tr class="h23">
							<td valign="middle">IPC/Ocean</td>
							<td colspan="2"><%=actionIOBox%></td>
						</tr>
					</table>

						<div id="modeLayer" style="display:inline">
							<table class="search" border="0">
								<tr class="h23">
									<td width="81" valign="middle">Mode</td>
									<td colspan="2"><select name="">
									<option value="" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
									</select></td>
								</tr>
							</table>
						</div>
						<div id="modeLayer" style="display:none">
							<table class="search" border="0">
							<tr class="h23">
								<td width="81"  valign="middle">Mode</td>
								<td colspan="2"><select name="tml_trns_mod_cd">
								<!-- <option value=""></option> -->
								<option value="S">Same</option>
								<option value="T">Truck</option>
								<option value="R">Rail</option>
								<option value="B">Barge</option>
								<option value="F">Feeder</option>
								<option value="V">Mother</option>
								<option value="O">Other</option>
								</select></td>
							</tr>
							</table>
						</div>
						<div id="modeLayer" style="display:none">
							<table class="search" border="0">
							<tr class="h23">
								<td width="81"  valign="middle">Mode</td>
								<td colspan="2"><select name="tml_trns_mod_cd">
								<!-- <option value=""></option> -->
								<option value="S">Same</option>
								<option value="T">Truck</option>
								<option value="R">Rail</option>
								<option value="B">Barge</option>
								<option value="F">Feeder</option>
								<option value="V">Mother</option>
								<option value="O">Other</option>
								</select></td>
							</tr>
							</table>
						</div>


						<table class="search" border="0" width="299">
							<tr class="h23"><td class="height_5"></td></tr>

							<tr class="h23">
								<td valign="top" colspan="3">
									<table class="grid" border="0" width="299">
			    						<tr class="h23">
											<td width="90" class="tr2_head" rowspan="2">Applied Date</td>
											<td width="200"><input name="tml_dy_aply_tp_cd" type="radio" value="S" class="trans" onclick="javascript:selectAplySame();"> Same<br>&nbsp;<input type="radio" name="tml_dy_aply_tp_cd" value="P" class="trans" onclick="javascript:selectAplySep();"> Separate</td>
									</tr>
									<tr class="h23">
											<td><input type="checkbox" name="wkdy_flg" value="Y" class="trans">WD&nbsp;<input type="checkbox" name="sat_flg" value="Y" class="trans">SA&nbsp;<input type="checkbox" name="sun_flg" value="Y" class="trans">SU&nbsp;<input type="checkbox" name="hol_flg" value="Y" class="trans">HO</td>
									</tr>
									</table>

								</td>
							</tr>

							<tr class="h23"><td class="height_5"></td></tr>

							<tr class="h23">
								<td width="36">Lane</td>
								<td colspan="2"><script language="javascript">ComComboObject('lane_cd',1, 90 , 0 )</script></td>
							</tr>

							<tr class="h23"><td class="height_5"></td></tr>

							<tr class="h23">
								<td valign="top" colspan="3">
									<table class="grid" border="0" width="299">
				    						<tr class="h23">
												<td width="90" class="tr2_head" rowspan="2">DG Class</td>
												<td width="200"><!-- <input type="radio" name="dcgo_aply_tp_cd" value="N" class="trans" onclick="javascript:selectDGNone('');">None<br>-->
												<input type="radio" name="dcgo_aply_tp_cd" value="A" class="trans" onclick="javascript:selectDGSame('');">Same &nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 9px;"><input type="radio" name="dcgo_same" value="Y" class="trans" disabled onclick="javascript:same_dg('')">DG&nbsp;&nbsp;<input type="radio" name="dcgo_same" value="N" class="trans" disabled onclick="javascript:same_nodg('')">NODG</font><br>
												&nbsp;<input type="radio" name="dcgo_aply_tp_cd" value="S" class="trans" onclick="javascript:selectDGSep('');">Separate</td>
										</tr>
				    						<tr class="h23">
											<td><input type="checkbox" name="dcgo_n1st_clss_flg" value="Y" class="trans">1&nbsp;&nbsp;<input type="checkbox" name="dcgo_n2nd_clss_flg" value="Y" class="trans">2&nbsp;<input type="checkbox" name="dcgo_n3rd_clss_flg" value="Y" class="trans">3&nbsp;<input type="checkbox" name="dcgo_n4th_clss_flg" value="Y" class="trans">4&nbsp;<input type="checkbox" name="dcgo_n5th_clss_flg" value="Y" class="trans">5<br>
												&nbsp;<input type="checkbox" name="dcgo_n6th_clss_flg" value="Y" class="trans">6&nbsp;&nbsp;<input type="checkbox" name="dcgo_n7th_clss_flg" value="Y" class="trans">7&nbsp;<input type="checkbox" name="dcgo_n8th_clss_flg" value="Y" class="trans">8&nbsp;<input type="checkbox" name="dcgo_n9th_clss_flg" value="Y" class="trans">9&nbsp;<input type="checkbox" name="dcgo_none_clss_flg" value="Y" class="trans">No</td>
										</tr>
									</table>

								</td>
							</tr>

					</table>

					</td>





					<td width="10"></td>





					<td class="bg" valign="top">


				 	<table class="search" border="0" width="299">
		    			<tr class="h23">
							<td width="220">No of Volume Tier&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="cnt1" type="text" style="text-align:center;" class="input" style="width:18" value="1"></td>
							<td>

								<!-- : ( Button : Sub ) (S) -->
								<table class="button" border="0">
									<tr><td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_retreive1" id="t1btng_retreive1">Retreive1</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td></tr>
								</table>
								<!-- : ( Button : Sub ) (E) -->
							</td>
						</tr>
					</table>

					<table class="height_5"><tr><td></td></tr></table>
					<!--grid(No of Volume Tier) start-->
					<table width="299" id="mainTable">
						<tr><td>
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td></tr>
					</table>

					<!--grid end-->

					<table class="height_10"><tr><td></td></tr></table>

				 	 	<table class="search" border="0">

						<tr class="h23">
							<td width="220">No of Overtime Shift&nbsp;<input name="cnt2" type="text" style="text-align:center;" class="input" style="width:18" value="3">
							<td>

							<!-- : ( Button : Sub ) (S) -->
								<table class="button" border="0">
									<tr><td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_retreive2" id="t1btng_retreive2">Retreive2</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td></tr>
								</table>
								<!-- : ( Button : Sub ) (E) -->

							</td>
						</tr>

					</table>

					<table class="height_5"><tr><td></td></tr></table>

					<!--grid(No of Overtime Shift) start-->
					<table width="299" id="mainTable">
						<tr><td>
							<script language="javascript">ComSheetObject('t1sheet2');</script>
						</td></tr>
		            </table>


					<!--grid end-->
					</td>





					<td width="10"></td>





					<td class="bg" valign="top">

					<table class="search" border="0">
						<tr class="h23">
						<td>Terminal Handling Charge</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>

					<!--grid start-->
					<!--
					<table class="grid" border="0">
		    				<tr class="h23">
							<td width="239"><input type="radio" name="thc_tp_cd" value="G" class="trans">Gate I/O&nbsp;&nbsp;<br>&nbsp;<input type="radio" name="thc_tp_cd" value="L" class="trans">Lift On/Off&nbsp;&nbsp;<br>&nbsp;<input type="radio" name="thc_tp_cd" value="T" class="trans">Throughput</td>
						</tr>

					</table>
					-->
					<table class="grid" border="0"  width="299">
		    				<tr class="h23">
							<td  width="" class="stm"><input type="radio" name="thc_tp_cd" value="T" class="trans" onClick="checkTHC(1)">&nbsp;<b>Throughput</b><br>
							&nbsp;<input type="radio" name="thc_tp_cd_flg" value="S" class="trans" onClick="checkTHC(2)">&nbsp;<b>Separate</b>&nbsp;<input type="radio" name="thc_tp_cd" value="G" class="trans">&nbsp;Gate I/O&nbsp;<input type="radio" name="thc_tp_cd" value="L" class="trans">&nbsp;Lift On/Off</td>
						</tr>

					</table>
					<!--grid end-->
				 	<table class="height_10"><tr><td></td></tr></table>

					<table class="search" border="0">
						<tr class="h23">
						<td>Same Rate Apply to</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>

					<!--grid start-->
					<table class="grid" border="0"  width="299">
		    				<tr class="h23">
							<td width="90" class="tr2_head"  rowspan="3">CNTR<br>Type / Size</td>
							<td width="200"><input type="radio" name="cntr_ts" value="A" class="trans" onclick="javascript:selectTSAll(0)">&nbsp;All<br>
							&nbsp;<input type="radio" name="cntr_ts" value="TS" class="trans" onclick="javascript:selectTS(0)">&nbsp;By Type / Size</td>
						</tr>
						<tr class="h23">
							<td width="200" style="padding-left:1;">
							&nbsp;&nbsp;&nbsp;Type&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('cntr_type_t',1, 90 , 0 )</script></td>
						</tr>
						<tr class="h23">
							<td width="200">
							&nbsp;&nbsp;&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('cntr_size_t',1, 90 , 0 )</script></td>
						</tr>
					</table>
					<!--grid end-->
					<table class="height_5"><tr><td></td></tr></table>


					<table class="search" border="0">
		    			<tr class="h23">
							<td align="right">Rate&nbsp;<input name="agmt_rate" type="text" style="text-align:center;" class="input" maxlength="18" style="width:70" onKeyUp='tes_isMon(this,"Y");' onKeyDown='chkInput(this); tes_isMon(this,"Y");' onBlur="tes_chkAmtFmtObj(this);">&nbsp;</td>
						</tr>
					</table>
					<table class="height_10"><tr><td></td></tr></table>
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton"  width="299">
	       				<tr><td class="align">

							<!-- : ( Button : Sub ) (S) -->
	       						<table class="button" border="0" width="100%">
								<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_agmtcopy" id="t1btng_agmtcopy">AGMT Copy</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_new" id="t1btng_new">New</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t1btng_apply" id="t1btng_apply">Apply</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>
							<!-- : ( Button : Sub ) (E) -->

						</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->



					</td>
				</tr>
			</table>




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

</div>

<!-- UI_ESD_TES_035 : THIS IS 2st TAB -->
<div id="tabLayer" >

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10">
						<tr>

							<td></td>
							</tr>
						</table>
					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t2sheet1');</script>
                        </td></tr>

		            </table>


					<!-- : ( Grid : Week ) (E) -->

					<!-- : ( Button : Sub ) (S) -->

	       						<table class="button" border="0" width="100%">
								<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_new" id="t2btng_new">New</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_rowadd" id="t2btng_rowadd">Row Add</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_delete" id="t2btng_delete">Delete</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_save" id="t2btng_save">Save</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_downexcel" id="t2btng_downexcel">Down Excel</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_loadexcel" id="t2btng_loadexcel">Load Excel</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_verify" id="t2btng_verify">Verify</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t2btng_registeragree" id="t2btng_registeragree">Register Agreement</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>
					<!-- : ( Button : Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</div>

<!-- UI_ESD_TES_036 : THIS IS 3st TAB -->
<div id="tabLayer" >

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">



		    <table class="search_in" border="0">
		    	<tr><td class="bg">

				 	<table class="search" border="0">
		    				<tr class="h23">
							<td width="80">Cost Code</td>
							<td width="140" style="padding-left:2;"><script language="javascript">ComComboObject('lgs_cost_cd_s', 2, 90 , 0, 1 )</script></td>
							<td width="110">SR AGMT Type</td>
							<td width="200"><%=srAgmtTypeBox%></td>
							<td width="110">Commence Time</td>
							<td width="60"><input name="cmnc_hrmnt" type="text" maxlength="5"  style="text-align:center;" class="input" style="width:60" value="" onKeyUp='tes_cmnctime(this,"Y");' onKeyDown='chkInput(this);' onBlur="isValidHHMM(this)"></td>
							<td align="right">
								<table class="button" border="0" width="100%">
									<tr><td class="btn2_bg" class="align">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_save" id="t3btng_save">Save</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td></tr>
								</table>

							</td>
						</tr>
						<tr class="h23">

							<td width="">Vol. UOM</td>
							<td width=""><%=actionVolUOMBox%></td>
							<td width="">Currency</td>
							<td width="" style="padding-left:2;"><script language="javascript">ComComboObject('curr_cd_s',1, 90 , 0 )</script></td>
							</tr>
					</table>

				</td></tr>
			</table>


			<table class="height_10"><tr><td></td></tr></table>


    <div id="srLayer" style="display:inline">


			<table class="search_in" border="0">
				<tr>
					<td width="239" class="bg" valign="top">


					<table class="search" border="0">
						<tr><td class="title_s"><input type="radio" name="storage_gb" value="FD" class="trans" onclick="freeDays();">&nbsp;Free Days</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>
					<table class="search" border="0">
		    			<tr class="h23">
							<td width="80">Bound</td>
							<td><%=actionBoundBox%></td>
						</tr>
					</table>
				 	<table class="search" border="0">

						<tr class="h23"><td class="height_5"></td></tr>
						<tr class="h23">
							<td valign="top" colspan="3">
								<table class="grid" border="0" width="299">
		    						<tr class="h23">
										<td width="90" class="tr2_head" rowspan="2">DG Class</td>
										<td width="200"><!-- <input type="radio" name="dcgo_aply_tp_cd_FD" value="N" class="trans" onclick="javascript:selectDGNone('_FD');">None<br> -->
										<input type="radio" name="dcgo_aply_tp_cd_FD" value="A" class="trans" onclick="javascript:selectDGSame('_FD');">Same &nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 9px;"><input type="radio" name="dcgo_same_FD" value="Y" class="trans" disabled onclick="javascript:same_dg('_FD')">DG&nbsp;&nbsp;<input type="radio" name="dcgo_same_FD" value="N" class="trans" disabled onclick="javascript:same_nodg('_FD')">NODG</font><br>
										&nbsp;<input type="radio" name="dcgo_aply_tp_cd_FD" value="S" class="trans" onclick="javascript:selectDGSep('_FD');">Separate</td>

								</tr>
		    						<tr class="h23">
										<td><input type="checkbox" name="dcgo_n1st_clss_flg_FD" value="Y" class="trans">1&nbsp;&nbsp;<input type="checkbox" name="dcgo_n2nd_clss_flg_FD" value="Y" class="trans">2&nbsp;<input type="checkbox" name="dcgo_n3rd_clss_flg_FD" value="Y" class="trans">3&nbsp;<input type="checkbox" name="dcgo_n4th_clss_flg_FD" value="Y" class="trans">4&nbsp;<input type="checkbox" name="dcgo_n5th_clss_flg_FD" value="Y" class="trans">5<br>
							&nbsp;<input type="checkbox" name="dcgo_n6th_clss_flg_FD" value="Y" class="trans">6&nbsp;&nbsp;<input type="checkbox" name="dcgo_n7th_clss_flg_FD" value="Y" class="trans">7&nbsp;<input type="checkbox" name="dcgo_n8th_clss_flg_FD" value="Y" class="trans">8&nbsp;<input type="checkbox" name="dcgo_n9th_clss_flg_FD" value="Y" class="trans">9&nbsp;<input type="checkbox" name="dcgo_none_clss_flg_FD" value="Y" class="trans">No</td>
								</tr>
								</table>

							</td>
						</tr>
						<tr class="h23"><td class="height_10"></td></tr>
						<tr class="h23">
							<td valign="top" colspan="3">
								<table class="grid" border="0" width="299">
		    						<tr class="h23">
										<td width="90" class="tr2_head">Exclude Date</td>
										<td width="200">
											<input type="checkbox" name="sat_flg_FD" value="Y" class="trans">SA&nbsp;<input type="checkbox" name="sun_flg_FD" value="Y" class="trans">SU&nbsp;<input type="checkbox" name="hol_flg_FD" value="Y" class="trans">HO</td>
									</tr>
								</table>

							</td>
						</tr>
					</table>
					<table class="height_5"><tr><td></td></tr></table>
					<table class="search" border="0">
		    			<tr class="h23">
							<td width="100">Days</td>
							<td><input name="ft_dys" type="text" maxlength="3" style="text-align:center;" class="input" style="width:170" value="" onKeyUp='isNum(this);' onKeyDown='chkInput(this);isNum(this);'></td>
						</tr>
					</table>

					</td>





					<td width="10"><br></td>





					<td class="bg" valign="top">


					<table class="search" border="0">
						<tr><td class="title_s"><input type="radio"  name="storage_gb" value="R" class="trans" onclick="rate();">&nbsp;Rate</td></tr>
					</table>
					<table class="search" border="0">
					<tr class="h23"><td class="height_5"></td></tr>
						<tr class="h23">
							<td valign="top" colspan="3">
								<table class="grid" border="0" width="299">
		    						<tr class="h23">
										<td width="75" class="tr2_head" rowspan="2">DG Class</td>
										<td width="164"><!-- <input type="radio" name="dcgo_aply_tp_cd_R" value="N" class="trans" onclick="javascript:selectDGNone('_R');">None<br> -->
										<input type="radio" name="dcgo_aply_tp_cd_R" value="A" class="trans" onclick="javascript:selectDGSame('_R');">Same &nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 9px;"><input type="radio" name="dcgo_same_R" value="Y" class="trans" disabled onclick="javascript:same_dg('_R')">DG&nbsp;&nbsp;<input type="radio" name="dcgo_same_R" value="N" class="trans" disabled onclick="javascript:same_nodg('_R')">NODG</font><br>
										&nbsp;<input type="radio" name="dcgo_aply_tp_cd_R" value="S" class="trans" onclick="javascript:selectDGSep('_R');">Separate</td>

								</tr>
		    						<tr class="h23">
										<td><input type="checkbox" name="dcgo_n1st_clss_flg_R" value="Y" class="trans">1&nbsp;&nbsp;<input type="checkbox" name="dcgo_n2nd_clss_flg_R" value="Y" class="trans">2&nbsp;<input type="checkbox" name="dcgo_n3rd_clss_flg_R" value="Y" class="trans">3&nbsp;<input type="checkbox" name="dcgo_n4th_clss_flg_R" value="Y" class="trans">4&nbsp;<input type="checkbox" name="dcgo_n5th_clss_flg_R" value="Y" class="trans">5<br>
							&nbsp;<input type="checkbox" name="dcgo_n6th_clss_flg_R" value="Y" class="trans">6&nbsp;&nbsp;<input type="checkbox" name="dcgo_n7th_clss_flg_R" value="Y" class="trans">7&nbsp;<input type="checkbox" name="dcgo_n8th_clss_flg_R" value="Y" class="trans">8&nbsp;<input type="checkbox" name="dcgo_n9th_clss_flg_R" value="Y" class="trans">9&nbsp;<input type="checkbox" name="dcgo_none_clss_flg_R" value="Y" class="trans">No</td>
								</tr>
								</table>

							</td>
						</tr>
						<tr class="h23"><td class="height_10"></td></tr>
					</table>

				 	<table class="search" border="0">
		    			<tr class="h23">
							<td width="210">No of Tier Days&nbsp;<input name="cnt3" type="text" style="text-align:center;" class="input" style="width:30" value="0"></td>
							<td width="69" align="right">


								<table class="button" border="0" width="100%">
									<tr><td class="btn2_bg" class="align">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_retreive" id="t3btng_retreive">Retreive</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</td></tr>
								</table>

							</td>
						</tr>
					</table>

					<table class="height_5"><tr><td></td></tr></table>
					<!--grid(Storage Tab : No of Tier Days) start-->
					<table width="299" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t3sheet1');</script>
                        </td></tr>
		            </table>


					<!--grid end-->
					<table class="height_5"><tr><td></td></tr></table>
					<table class="search" border="0">
		    			<tr class="h23">
							<td width="60">Rate</td>
							<td><input name="agmt_ut_rt" maxlength="18" type="text" style="text-align:center;" class="input" style="width:170" value="" onKeyUp='tes_isMon(this,"Y");' onKeyDown='chkInput(this); tes_isMon(this,"Y");' onBlur="tes_chkAmtFmtObj(this);"></td>
						</tr>
					</table>

					</td>



					<td width="10"></td>



					<td class="bg" valign="top">


					<table class="search" border="0">
					<tr class="h23">
							<td width="80">Bound</td>
							<td><%=actionBoundBox%></td>
						</tr>
					</table>

					<table class="search" border="0">
						<tr class="h23">
						<td>Same Rate & Date Apply to</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>
					<!--grid start-->
					<table class="grid" border="0" width="299">
		    				<tr class="h23">
							<td width="90" class="tr2_head"  rowspan="3">CNTR<br>Type / Size</td>
							<td width="200"><input type="radio" name="cntr_ts" value="A" class="trans" onclick="javascript:selectTSAll(1)">All<br>
							&nbsp;<input type="radio" name="cntr_ts" value="TS" class="trans" onclick="javascript:selectTS(1)">By Type / Size</td>
						</tr>
						<tr class="h23">
							<td width="200" style="padding-left:4;">
							&nbsp;&nbsp;&nbsp;Type&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('cntr_type_s',1, 90 , 0 )</script></td>
						</tr>
						<tr class="h23">
							<td width="200">
							&nbsp;&nbsp;&nbsp;Size&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('cntr_size_s',1, 90 , 0 )</script></td>
						</tr>
					</table>
					<!--grid end-->
					<table class="height_10"><tr><td></td></tr></table>
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
	       				<tr><td class="align">


	       					<table class="button" border="0" width="100%">
							<tr><td class="btn2_bg" class="align">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_agmtcopy" id="t3btng_agmtcopy">AGMT Copy</td>
										<td class="btn2_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_new1" id="t3btng_new1">New</td>
										<td class="btn2_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_apply1" id="t3btng_apply1">Apply</td>
										<td class="btn2_right"></td></tr></table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td></tr>
						</table>

						</td></tr>
					</table>

					<table class="height_10"><tr><td></td></tr></table>





					</td>
				</tr>
			</table>
    </div>

    <div id="srLayer" style="display:none">

    	  <table class="search_in" border="0">
		    	<tr><td class="bg">

					<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Free Pool & Rate</td></tr>
						<tr><td class="height_5"></td></tr>
					</table>
				 	<table class="search" border="0">

		    			<tr class="h23">
		    				<td width="70">Cal. Period</td>
						<td width="150" class="stm"><input type="radio" name="fp_calc_prd_cd" value="D" class="trans">Daily&nbsp;<input type="radio" name="fp_calc_prd_cd" value="M" class="trans">Monthly</td>
						<td width="45">FP TEU</td>
						<td width="115"><input name="fp_teu_qty" type="text" maxlength="6" style="text-align:center;" class="input" style="width:80" value="" onKeyUp='isNum(this);' onKeyDown='chkInput(this);isNum(this);'></td>
						<td width="30">Rate</td>
						<td width="100"><input name="agmt_ut_rt_fp" maxlength="18" type="text" style="text-align:center;" class="input" style="width:80" value="" onKeyUp='tes_isMon(this,"Y");' onKeyDown='chkInput(this); tes_isMon(this,"Y");' onBlur="tes_chkAmtFmtObj(this);"></td><!--

						<td width="225" class="bt" align="right"><img class="cursor" src="/hanjin/img/button/btng_agmtcopy.gif" width="79" height="19" border="0" name="t3btng_agmtcopy2">&nbsp;<img class="cursor" src="/hanjin/img/button/btng_new.gif" width="65" height="19" border="0" name="t3btng_new2">&nbsp;<img class="cursor" src="/hanjin/img/button/btng_apply.gif" width="65" height="19" border="0" name="t3btng_apply2"></td>
						--></tr>
					</table>

					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
	       				<tr><td class="align">


	       					<table class="button" border="0" width="100%">
							<tr><td class="btn2_bg" class="align">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_agmtcopy2" id="t3btng_agmtcopy2">AGMT Copy</td>
										<td class="btn2_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_new2" id="t3btng_new2">New</td>
										<td class="btn2_right"></td></tr></table>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="t3btng_apply2" id="t3btng_apply2">Apply</td>
										<td class="btn2_right"></td></tr></table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td></tr>
						</table>

						</td></tr>
					</table>
				</td></tr>
			</table>

    </div>
	    	<!-- : ( Button : Sub ) (E) -->





			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</div>

<!-- UI_ESD_TES_037 : THIS IS 4st TAB -->
<div id="tabLayer" >

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<!-- : ( Grid : Storage Rate List ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t4sheet1');</script>
                        </td></tr>
		            </table>


					<!-- : ( Grid : Week ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
					<table class="button" border="0" width="100%">
								<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_new" id="t4btng_new">New</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_rowadd" id="t4btng_rowadd">Row Add</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_delete" id="t4btng_delete">Delete</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_save" id="t4btng_save">Save</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_downexcel" id="t4btng_downexcel">Down Excel</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_loadexcel" id="t4btng_loadexcel">Load Excel</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_verify" id="t4btng_verify">Verify</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="t4btng_registeragree" id="t4btng_registeragree">Register Agreement</td>
											<td class="btn2_right"></td></tr></table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>
					<!-- : ( Button : Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</div>







</td></tr>
</table>
<!-- Outer Table (E)-->

</form>

<script language="javascript">

    document.form.tml_sto_agmt_tp_cd.onchange = processChange;
</script>

<form name="downform" action="/hanjin/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%--=templateKey--%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
</body>
</html>

<Script Language="javascript" for="t1sheet1" event="OnChange(Row,Col,Value)">
	CellValue(Row,3) = CellValue(Row,3).toUpperCase();

	if(CellValue(Row,3)!="MAX"){

		if(!ComIsNumber(CellValue(Row,3))){
			//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
		}
	}
</Script>


<Script Language="javascript" for="t3sheet1" event="OnChange(Row,Col,Value)">
	CellValue(Row,3) = CellValue(Row,3).toUpperCase();
	if(CellValue(Row,3) != "MAX"){

		if(!ComIsNumber(CellValue(Row,3))){
			//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
		}
	}
</Script>

<!-- 
<Script Language="javascript" for="t2sheet1" event="OnChange(Row,Col,Value)">
	var total_rate = "";
	for(i= 32 ;i< 62;i++){
		total_rate  = total_rate+"#"+sheetObjects[2].CellValue(Row, i);
	}
	if (Col >31 || Col < 62){
		CellValue2(Row,"3ts_rt") = total_rate;
	}
	if(Col==28){
		CellValue(Row,"3to_tr_vol_val") = CellValue(Row,"3to_tr_vol_val").toUpperCase();
		if(CellValue(Row,"3to_tr_vol_val")!="MAX"){
			if(!ComIsNumber(CellValue(Row,"3to_tr_vol_val"))){
				//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
				CellValue2(Row,"3to_tr_vol_val")="";
			}
		}
	}
	if(CellValue(Row,"3curr_cd")== "KRW" || CellValue(Row,"3curr_cd")=="JPY"){
		currRateModRow('terminal',Row, dfInteger);
	}else{
		currRateModRow('terminal',Row, dfFloat);
	}
	/**
	if(Col==2){
		if(sheetObjects[2].CellValue(Row, Col)=="TPNDFL" || sheetObjects[2].CellValue(Row, Col)=="SVLDFL" || sheetObjects[2].CellValue(Row, Col)=="TMNDFL"){
			CellComboItem(Row, "3tml_trns_mod_cd", "Same|Truck|Rail|Barge", "S|T|R|B");
		}else if(sheetObjects[2].CellValue(Row, Col)=="TPNDTS" || sheetObjects[2].CellValue(Row, Col)=="SVLDTS" || sheetObjects[2].CellValue(Row, Col)=="TMNDFL"){
			CellComboItem(Row, "3tml_trns_mod_cd", "Same|Feeder|Vessel", "S|F|V");
		}else{
		   	CellComboItem(Row, "3tml_trns_mod_cd", "", "");
		}
	}
	**/
	if(Col==2){
		if( CellValue(Row,"3lgs_cost_cd")=="TMNDRF" || CellValue(Row,"3lgs_cost_cd")=="TMNDRM" ) {
			CellComboItem( Row , "3tml_trns_mod_cd", " |Rail", " |R");
		} else {
			CellComboItem( Row , "3tml_trns_mod_cd", " |Same|Truck|Rail|Barge|Feeder|Mother|Other", " |S|T|R|B|F|V|O");		
		}
	}

</Script>
-->
  <!--

  <Script Language="javascript" for="t4sheet1" event="OnChange(Row,Col,Value)">
   		var total_rate = "";
   		var daysTotalRate = 0;
   		var rateTotalRate = 0;

   		if(sheetObjects[4].CellValue(Row, "5ft_dys")=="F"){
	   		for(i= 42 ;i< 67;i++){
	   			total_rate  = total_rate+"#"+sheetObjects[4].CellValue(Row, i);
	   			daysTotalRate = parseInt(sheetObjects[4].CellValue(Row, i))+daysTotalRate;
	   		}

	      if (Col >41 || Col < 67){
	          CellValue2(Row,"5ts_rt") = total_rate;
	      }
	    }

   		if(sheetObjects[4].CellValue(Row, "5ft_dys")=="" || sheetObjects[4].CellValue(Row, "5ft_dys")==undefined){
	   		for(i= 67 ;i< 92;i++){
	   			total_rate  = total_rate+"#"+sheetObjects[4].CellValue(Row, i);
	   			rateTotalRate = parseInt(sheetObjects[4].CellValue(Row, i))+rateTotalRate;
	   		}

	      if (Col >66 || Col < 92){
	          CellValue2(Row,"5ts_rt") = total_rate;
	      }
	    }

 			if(CellValue(Row,"5curr_cd")=="KRW" || CellValue(Row,"5curr_cd")=="JPY" ){
 					currRateModRow('storage',Row, dfInteger);
 			}else{
 					currRateModRow('storage',Row, dfFloat);
 			}

	    if(Col==39){
		 		  CellValue(Row,"5to_tr_dys") = CellValue(Row,"5to_tr_dys").toUpperCase();
		 		  if(CellValue(Row,"5to_tr_dys")!="MAX"){
		 		  		if(!ComIsNumber(CellValue(Row,"5to_tr_vol_val"))){
									//ComShowMessage("숫자와 MAX만 입력 가능합니다. 다시 확인하세요.");
									CellValue2(Row,"5to_tr_dys")="";
		 		  		}
		 		  }
 			}
  </Script>

-->
<DIV style="display:none">
<table class="height_5"><tr><td></td></tr></table>
<table width="100%" id="mainTable">
	<tr><td>
		<script language="javascript">ComSheetObject('t1sheet3');</script>
	</td></tr>
</table>
<table class="height_10"><tr><td></td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
<--  sheetObjects[6] ( t1sheet4 ) -->
<table width="100%" id="mainTable">
	<tr><td>
		<script language="javascript">ComSheetObject('t1sheet4');</script>
	</td></tr>
</table>
<table class="height_10"><tr><td></td></tr></table>

<table width="100%" id="mainTable">
	<tr><td>
		<script language="javascript">ComSheetObject('t1sheet5');</script>
	</td></tr>
</table>
</DIV>