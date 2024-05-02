<%
/*
========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0040.jsp
*@FileTitle  : Vendor 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0040Event"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String isRequest		= "";
	String isCheck			= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.commoncode.partner");
	String mainPage 		= "";
    mainPage = request.getParameter("main_page");
	// 승인처리용 정보
	String rqstNo		= JSPUtil.getParameter(request, "rqst_no");
	String vndrSeq		= JSPUtil.getParameter(request, "vndr_seq");
	String procTpCd		= JSPUtil.getParameter(request, "proc_tp_cd");
	String custCd		= JSPUtil.getParameter(request, "cust_cd");
	String rqstUsrChk	= JSPUtil.getParameter(request, "rqst_usr_chk");
	String rqstOfcCd	= JSPUtil.getParameter(request, "rqst_ofc_cd");
	String isApprove	= JSPUtil.getParameter(request, "is_approve");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (BcmCcd0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		Screen screen = (Screen)request.getAttribute(WebKeys.CURRENT_SCREEN);
		if(screen.getName().indexOf("Q") >= 0) {
			isRequest = "Y";
		} else {
			isRequest = "N";
		}
		
		if(screen.getName().indexOf("P") >= 0) {
			isCheck = "Y";
		} else {
			isCheck = "N";
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html style="height:auto">
<head>
<title>Vendor</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var G_MDAA_CHK;
	var G_AHTU_TP_CD;
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
<input type="hidden" name="saveflag" value="N" id="saveflag" />
<input type="hidden" name="mst_dat_subj_cd" value="VNDR" id="mst_dat_subj_cd" />
<%-- <input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" /> --%>
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<input type="hidden" name="old_modi_vndr_cd" value="" id="old_modi_vndr_cd" />
<input type="hidden" name="edi_if_flg" id="edi_if_flg" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />
<input type="hidden" name="isRequest" value="<%=isRequest %>" />
<input type="hidden" name="isApprove" value="<%=isApprove %>" />
<input type="hidden" name="isCheck" value="<%=isCheck %>" />
<input type="hidden" name="lgsFlg" value="N">

<%-- <%if (!("true").equals(mainPage)){%>
<div class="layer_popup_contents">
<div class="layer_popup_title">
<%} %>	 --%>

<table width="100%" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- Page Title, Historical (S) -->
			<table width="100%" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history">
						<img src="img/icon_history_dot.gif" align="absmiddle">
						<span id="navigation"></span>
					</td>
				</tr>
				<tr>
					<td class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">
<%if(isRequest.equals("Y")) { %>
						<span id="title">
							&nbsp; Vendor Request	
						</span>
<%} else {%>
						<span id="title">
							&nbsp; Vendor
						</span>
<%} %> 
					</td>
				</tr>
			</table>
			<!-- Page Title, Historical (E) -->

<!-- 		<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_CheckDup" id="btn_CheckDup" style="display:none">Check Duplicate</button>
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" style="display:none">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_Save" id="btn_Save" style="display:none">Save</button>
				<button type="button" class="btn_normal" name="btn_Create" id="btn_Create" style="display:none">Create</button>
				<button type="button" class="btn_normal" name="btn_New" id="btn_New" style="display:none">New</button>
				<button type="button" class="btn_normal" name="btn_Request" id="btn_Request" style="display:none">Request</button>
				<button type="button" class="btn_normal" name="btn_Close" id="btn_Close" style="display:none">Close</button>
			</div> -->
			
			<table width="100%" class="search" id="leftTable">
				<tr>
					<td width="120">
					</td>
				</tr>
			</table>

		<!-- biz page (S) -->

			<!-- biz_1 (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="120" align="right">
									Vendor Code
								</td>
								<td width="180">
									<input id="vndr_cnt_cd" style="width: 30px;  margin-left:4px; ime-mode:disabled; text-align:center;" class="input1" name="vndr_cnt_cd" value="" readonly="" maxlength="2" dataformat="engup" type="text"  />
									<input type="text" style="width: 100px; text-align:center;" class="input1" name="vndr_seq" id="vndr_seq" value="<%=vndrSeq %>" maxlength="6" dataformat="int">
									<!-- <button name="btn_vndr_cd_pop"  type="button" class="input_seach_btn"></button> -->									
									<img src="img/btns_search.gif" name="btn_vndr_cd_pop" id="btn_vndr_cd_pop" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
									<input type="hidden" value="" name="new_vndr_seq" id="new_vndr_seq">
								</td>
								<td width="90" align="right">
									Legacy Code
								</td>
								<td width="">
									<input type="text" style="width:150px; margin-left:4px; text-align:center;" class="input2" dataformat="engup" id="modi_vndr_cd" name="modi_vndr_cd" maxlength="30" readOnly>
								</td>
								<td width="100" align="right">
									Request No
								</td>
								<td width="130">
									<input type="text" style="width: 100px; margin-left:4px; text-align:center;" class="input" name="rqst_no" id="rqst_no" value="<%=rqstNo %>" maxlength="6" dataformat="int">
								</td>
								<td width="95" align="right">
									Request Status
								</td>
								<td>
									<input type="text" style="width: 100px; margin-left:4px; text-align:center;" class="input2" name="mst_rqst_sts_cd" id="mst_rqst_sts_cd" value="" maxlength="6" readonly>
								</td>
								<td>
								</td>
							</tr>	
						</table>	
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>		
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="120" align="right">Vendor Name</td>
								<td width="350"><input id="vndr_lgl_eng_nm" style="width: 330px; ime-mode:disabled;text-align:left;" class="input1" value="" name="vndr_lgl_eng_nm" maxlength="100" dataformat="etc" otherchar="()_\-,. &()'" type="text" /> </td>
								<td width="130" align="right">Vendor Name(Local)</td>
								<td width="350"><input id="vndr_locl_lang_nm" style="width: 330px; text-align:left;" class="input" value="" name="vndr_locl_lang_nm" maxlength="100" type="text" /> </td>
							</tr>
						</table>	
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="120" align="right">Abbreviation Name</td>
								<td width="150"><input id="vndr_abbr_nm" style="width: 90px; text-align:left; margin-left:4px;" class="input" value="" name="vndr_abbr_nm" maxlength="50" type="text" /> </td>
								<td width="720" align="right">
									<table class="search_sm2" >
										<tr>
											<td>
												<table class="saerch">
													<tr class="h23">
														<td style="padding-left:10px; padding-right:10px;">
														Vendor Type
														</td>
													</tr>
												</table>
											</td>
											<td>
												<table>
													<tr>
														<td>	
															<label></label>
															<input id="lgs_flg" name="lgs_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Logistics<label></label>
															<input id="blk_flg" name="blk_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Bulk <label></label>
															<input id="procu_flg" name="procu_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Procurement<label></label>
															<input id="finc_flg" name="finc_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Finance<label></label>
															<input id="team_flg" name="team_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Team<label></label>
															<input id="inter_co_flg" name="inter_co_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Subsidiary Company<label></label>
															<input id="otr_flg" name="otr_flg" value="N" class="trans" onclick="javascript:obj_change()" type="checkbox" />  Others  
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>	
							</tr>
						</table>
						<table class="search" style="width:979;">	
							<tr class="h23">
								<td width="120" align="right">Location</td>
								<td width="170">
									<input id="loc_cd" style="width: 70px;  margin-left:4px; ime-mode:disabled; text-align:center;" class="input1" value="" name="loc_cd" maxlength="5" dataformat="engup" type="text" />
									<!-- <button class="input_seach_btn" name="btn_com_ens_051_loc_cd" id="btn_com_ens_051_loc_cd" type="button"></button> -->								
									<img src="img/btns_search.gif" name="btn_com_ens_051_loc_cd" id="btn_com_ens_051_loc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
								</td>
								<td width="90" align="right">Control Office</td>
								<td width="100">
									<input id="ofc_cd" style="width: 70px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input1" value="" name="ofc_cd" maxlength="6" dataformat="engupnum" type="text" />
									<img src="img/btns_search.gif" name="btn_com_ens_071_ofc_cd" id="btn_com_ens_071_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
									<!-- <button class="input_seach_btn" name="btn_com_ens_071_ofc_cd" id="btn_com_ens_071_ofc_cd" type="button"></button> -->
								</td>
								<td width="130" align="right">Tax Payer ID</td>
								<td><input id="tax_id" style="width: 160px; margin-left:4px; ime-mode:disabled; text-align:left;" class="input" value="" name="tax_id" maxlength="20" dataformat="etc" type="text" /> </td>
								<td>Register No.</td>
								<td><input id="rgst_no" style="width: 100px; ime-mode:disabled; text-align:left;" class="input" value="" name="rgst_no" maxlength="20" dataformat="engnum" type="text" /></td>
							</tr>
						</table>
						<table class="search" style="width:979;">	
							<tr class="h23">
								<td width="120" align="right">Payment Term</td>
								<td width="120" style="padding-left:6px;">
									<script type="text/javascript">ComComboObject('gen_pay_term_cd', 1, 110, 1, 1 ,0 ,false)</script>
								</td>
								<td width="135" align="right">Payment Term Type</td>
								<td width="100" style="padding-left:6px;">
									<script type="text/javascript">ComComboObject('pay_term_tp_cd', 1, 90, 1, 1 ,0 ,false)</script>
								</td>
								<td width="124" align="right">Payment Method</td>
								<td style="padding-left:6px;"><script type="text/javascript">ComComboObject('pay_mzd_cd', 1, 130, 1, 1 ,0 ,false)</script></td>
								<td width="110" align="right">Parent Vendor</td>
								<td>
									<input id="prnt_vndr_seq" style="width: 80px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input" value="" name="prnt_vndr_seq" maxlength="6" dataformat="int" type="text" />
									<img src="img/btns_search.gif" name="btn_com_ens_0c1_prnt_vndr_cd" id="btn_com_ens_0c1_prnt_vndr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
									<!-- <button class="input_seach_btn" name="btn_com_ens_0c1_prnt_vndr_cd" id="btn_com_ens_0c1_prnt_vndr_cd" type="button"></button> -->
								</td>
							</tr>	
						</table>
						<table class="search" style="width:979;">	
							<tr class="h23">
								<td width="120" align="right">Invoice Currency</td>
								<td width="160">
									<input id="inv_curr_cd" style="width: 70px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input1" value="" name="inv_curr_cd" maxlength="3" dataformat="engup" type="text" />
									<img src="img/btns_search.gif" name="btn_com_ens_n13_inv_curr_cd" id="btn_com_ens_n13_inv_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
									<!-- <button class="input_seach_btn" name="btn_com_ens_n13_inv_curr_cd" id="btn_com_ens_n13_inv_curr_cd" type="button"></button></td> -->
								<td width="100" align="right">Contact Person</td>
								<td width="100"><input id="cntc_pson_nm" style="width: 90px; margin-left:4px; text-align:left;" class="input" value="" name="cntc_pson_nm" maxlength="50" type="text" /> </td>
								<td width="495"></td>
								<td width="130" align="right" style="display:none;">Bank Exist Flag</td>
			                    <td style="display:none;">
			                        <select style="width:40px; margin-left:4px;" name="bank_acct_flg" class="input" id="bank_acct_flg" disabled>
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
			                    </td>
							</tr>	
						</table>
						<table class="line_bluedot">
							<tr>
								<td colspan="6"></td>
							</tr>
						</table>
						<table class="search" style="width:979;">							
							<tr class="h23">
								<td width="120" align="right">Address(ENG)</td>
								<td><input id="eng_addr" style="width: 600px; margin-left:4px; ime-mode:disabled;text-align:left;" class="input1" value="" name="eng_addr" maxlength="200" dataformat="etc" type="text" /> </td>
								<td width="60">Zip Code</td>
								<td><input id="zip_cd" style="width: 120px; ime-mode:disabled;text-align:left;" class="input" value="" name="zip_cd" maxlength="10" dataformat="etc" type="text" /> </td>
							</tr>	
						</table>
						<table class="search" border="0" style="width:979;">							
							<tr class="h23">
								<td width="120" align="right">Address(Local)</td>
								<td><input id="locl_lang_addr" style="width: 841px; margin-left:4px; text-align:left;" class="input" value="" name="locl_lang_addr" maxlength="200" type="text" /></td>
							</tr>	
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="120" align="right">CEO Name</td>
								<td><input id="ceo_nm" style="width: 250px; margin-left:4px; text-align:left;" class="input" value="" name="ceo_nm" maxlength="50" type="text" /></td>
								<td width="120" align="right">Business Category</td>
								<td><input id="bzct_nm" style="width: 170px; margin-left:4px; text-align:left;" class="input" value="" name="bzct_nm" maxlength="50" type="text" /></td>
								<td width="100" align="right">Business Type</td>
								<td><input id="bztp_nm" style="width: 150px; margin-left:4px; text-align:left;" class="input" value="" name="bztp_nm" maxlength="100" type="text" /></td>
							</tr>	
						</table>
						<table class="line_bluedot">
							<tr>
								<td colspan="6"></td>
							</tr>
						</table>
						<table>
							<tr id="lgs_view" name="lgs_view">
								<td>
									<table class="search">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Logistics</td>
										</tr>
									</table>
									<table class="search" style="width:979;">
										<tr class="h23">
											<td width="120" align="right">SCAC(USA Only)</td>
											<td><input id="usa_edi_cd" style="width: 90px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input" value="" name="usa_edi_cd" maxlength="4" dataformat="engup" type="text" /> </td>
											<td width="80" align="right">Service Area</td>
											<td><input id="svc_scp_cd_nm" style="width: 80px; margin-left:4px; ime-mode:disabled; text-align:left;" class="input" value="" name="svc_scp_cd_nm" maxlength="50" dataformat="etc" type="text" /> </td>
											<td width="90" align="right">SVC Frequency</td>
											<td><input id="svc_prd_tp_nm" style="width: 90px; margin-left:4px; ime-mode:disabled; text-align:left;" class="input" value="" name="svc_prd_tp_nm" dataformat="etc" maxlength="20" type="text" /> </td>
											<td width="95" align="right">SVC Frequency Remark</td>
											<td><input id="svc_prd_rmk" style="width: 280px; margin-left:4px; ime-mode: disabled; text-align:left;" class="input" value="" name="svc_prd_rmk" maxlength="100" type="text" /> </td>
										</tr>
									</table>
									<table class="search" style="width:979;">								
										<tr class="h23">
											<td width="112" align="right">DG CGO Handling</td>
											<td style="width:70px; padding-left:4px">
												<select style="width:60px" name="dcgo_hndl_flg">
													<option value="Y">Y</option>
													<option value="N" selected>N</option>
												</select>
												<!-- <script type="text/javascript">ComComboObject('dcgo_hndl_flg', 1, 60, 1  , 0 ,0 ,false)</script> -->
											</td>
											<td width="144" align="right">MTY R/R Order EDI Use</td>
											<td style="width:70px; padding-left:4px">
												<select style="width:60px" name="mty_rro_edi_use_flg">
													<option value="Y">Y</option>
													<option value="N" selected>N</option>
												</select>								
												<!-- <script type="text/javascript">ComComboObject('mty_rro_edi_use_flg', 1, 60, 1, 0 ,0 ,false)</script> -->
											</td>
											<td width="100" align="right">W/O Attach File</td>
											<td style="width:70px; padding-left:4px;">
												<select style="width:60px" name="wo_atch_file_flg">
													<option value="Y">Y</option>
													<option value="N" selected>N</option>
												</select>									
												<!-- <script type="text/javascript">ComComboObject('wo_atch_file_flg', 1, 80, 1, 0, 0 ,false)</script> -->
											</td>
											<td width="85" align="right">W/O EDI Use</td>
											<td style="width:70px; padding-left:4px;">
												<select style="width:60px" name="wo_edi_use_flg">
													<option value="Y">Y</option>
													<option value="N" selected>N</option>
												</select>									
												<!-- <script type="text/javascript">ComComboObject('wo_edi_use_flg', 1, 60, 1, 0, 0 ,false)</script> -->
											</td>
											<td width="100" align="right">Invoice EDI Use</td>
											<td style="width:70px; padding-left:4px;">
												<select style="width:60px" name="inv_edi_use_flg">
													<option value="Y">Y</option>
													<option value="N" selected>N</option>
												</select>									
												<!-- <script type="text/javascript">ComComboObject('inv_edi_use_flg', 1, 58, 1, 0, 0 ,false)</script> -->
											</td>
										</tr>
									</table>
									<table class="search" style="width:979;">								
										<tr class="h23">
											<td width="120" align="right">TPB Customer Code</td>
											<td><input id="rfnd_psdo_cust_cd" style="width: 130px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input2" name="rfnd_psdo_cust_cd" value="" readonly maxlength="8" dataformat="engup" type="text" /></td>
											<td style="width:260px"><input id="tpb_flg" name="tpb_flg" value="Y" class="trans" onclick="obj_change()" type="checkbox" />
											Create TPB Customer for ERP</td>
											<td style="width:450px;"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr id="blk_view" name="blk_view">
								<td>	
									<table class="line_bluedot">
										<tr>
											<td></td>
										</tr>
									</table>		
									<table class="search">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Bulk</td>
										</tr>
									</table>
									<table class="search" style="width:979;">
										<tr class="h23">
											<td width="120" align="right" style="padding-right:5px;">Bulk Classfication</td>
											<td><script type="text/javascript">ComComboObject('blk_vndr_svc_cd', 1, 90, 1, 0, 0, false)</script>
										</tr>
									</table>
								</td>
							</tr>
							<tr id="team_view" name="team_view">
								<td>
									<table class="line_bluedot">
										<tr>
											<td></td>
										</tr>
									</table>		
									<table class="search">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Team</td>
										</tr>
									</table>
									<table class="search" style="width:979;">
										<tr class="h23">
											<td width="120" align="right" style="padding-right:3px;">Organization Code</td>
											<td><input id="vndr_ofc_cd" style="width: 100px; ime-mode:disabled; text-align:center;" class="input" value="" name="vndr_ofc_cd" maxlength="6" dataformat="engup" type="text" />
											<img src="img/btns_search.gif" name="btn_com_ens_071_vndr_ofc_cd" id="btn_com_ens_071_vndr_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr id="inter_co_view" name="inter_co_view">
								<td>
									<table class="line_bluedot">
										<tr>
											<td></td>
										</tr>
									</table>		
									<table class="search">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Subsidiary Company</td>
										</tr>
									</table>			
									<table class="search" style="width:979;">
										<tr class="h23">			
											<td width="125">Subsidiary Company</td>
											<td><script type="text/javascript">ComComboObject('subs_co_cd', 1, 260, 1, 0 ,0 ,false)</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>		
<% if(isRequest.equals("Y")) {%>
						<div style="display:none;">
<%} %>	
							<table class="line_bluedot">
								<tr>
									<td></td>
								</tr>
							</table>		
							<table class="search">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Check Delivery</td>
								</tr>
							</table>	
							<table class="search" style="width:979;">							
								<tr class="h23">
									<td width="120" align="right">Address1(Local)</td>
									<td><input id="chk_de_addr1" style="width: 845px; margin-left:4px; text-align:left;" class="input" value="" name="chk_de_addr1" maxlength="200" type="text" readOnly/> </td>
								</tr>	
							</table>
							<table class="search" style="width:979;">							
								<tr class="h23">
									<td width="120" align="right">Address2(Local)</td>
									<td><input id="chk_de_addr2" style="width: 845px; margin-left:4px; text-align:left;" class="input" value="" name="chk_de_addr2" maxlength="200" type="text" readOnly/> </td>
								</tr>	
							</table>	
							<table class="search" style="width:979;">						
								<tr class="h23">
									<td width="120" align="right">Address3(Local)</td>
									<td><input id="chk_de_addr3" style="width: 845px; margin-left:4px; text-align:left;" class="input" value="" name="chk_de_addr3" maxlength="200" type="text" readOnly/> </td>
								</tr>
							</table>
							<table class="search" style="width:979;">
								<tr class="h23">
									<td width="120" align="right">Country Code</td>
									<td>
										<input id="chk_de_cnt_cd" style="width: 60px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input" value="" name="chk_de_cnt_cd" maxlength="2" dataformat="engup" type="text" readOnly/>
										<img src="img/btns_search.gif"  name="btn_chk_de_cnt_cd" id="btn_chk_de_cnt_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
										<!-- <button class="input_seach_btn" name="btn_chk_de_cnt_cd" id="btn_chk_de_cnt_cd" type="button"></button>-->
									</td> 
									<td width="90" align="right">State Code</td>
									<td>
										<input id="chk_de_ste_cd" style="width: 60px; margin-left:4px; ime-mode:disabled; text-align:center;" class="input" value="" name="chk_de_ste_cd" maxlength="3" dataformat="engupnum" type="text" readOnly/>
										<img src="img/btns_search.gif" name="btn_chk_de_ste_cd" id="btn_chk_de_ste_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >
										<!--<button class="input_seach_btn" name="btn_chk_de_ste_cd" id="btn_chk_de_ste_cd" type="button"></button>-->
									</td>
									<td width="90" align="right">City Name</td>
									<td><input id="chk_de_cty_nm" style="width: 130px; margin-left:4px; ime-mode:disabled; text-align:left;" class="input" value="" name="chk_de_cty_nm" maxlength="50" type="text" readOnly/></td>
									<td width="90" align="right">Zip Code</td>
									<td><input id="chk_de_zip_cd" style="width: 90px; margin-left:4px; ime-mode:disabled; text-align:left;" class="input" value="" name="chk_de_zip_cd" dataformat="etc" maxlength="10" type="text" readOnly/></td>
									<td width="120" align="right">Address Use Flag</td>
									<td style="margin-left:6px;">
										<select style="width:55px" name="lu_delt_flg" disabled>
											<option value=""></option>
											<option value="Y">Y</option>
											<option value="N">N</option>
										</select>								
										<!-- <script type="text/javascript">ComComboObject('lu_delt_flg', 1, 55, 1, 0 ,0 ,false)</script> -->
									</td>
								</tr>		
							</table>	
<% if(isRequest.equals("Y")) {%>						
						</div>	
<% } %>					
					</td>				
				</tr>
			</table>
			<!-- biz_1 (E) -->	
			<table class="height_8">
				<tr>
					<td></td>
				</tr>
			</table>
<%if(isRequest.equals("Y") || isCheck.equals("Y")) { %>			
		<div style="display:none;">
<%} %>
			<!-- Grid BG Box (S) -->
			<table class="search" id="mainTable2" name="mainTable2">
				<tr>
					<td class="bg">
						<table class="search" >
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Vendor Contact Point</td>
							</tr>
						</table>
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1_1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<!-- Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowadd_sheet1_1" id="btn_rowadd_sheet1_1">Row Add</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>	
											<td id="btn_rowdelete_set1_1">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowdelete_sheet1_2" id="btn_rowdelete_sheet1_2">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>
										</tr>										
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->

						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1_2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<!-- Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowadd_sheet1_2" id="btn_rowadd_sheet1_2">Row Add</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>	
											<td id="btn_rowdelete_set1_2">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowdelete_sheet1_2" id="btn_rowdelete_sheet1_2">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>
										</tr>										
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!-- Grid BG Box (E) -->
			
			<table class="height_8">
				<tr>
					<td></td>
				</tr>
			</table>
			
			<!-- Grid BG Box (S) -->
			<table class="search" id="mainTable3">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Vendor Classification</td>
							</tr>
						</table>
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowadd_sheet2" id="btn_rowadd_sheet2">Row Add</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>	
											<td id="btn_rowdelete_set2">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowdelete_sheet2" id="btn_rowdelete_sheet2">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>
										</tr>										
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!-- Grid BG Box (E) -->
			<table class="height_8">
				<tr>
					<td></td>
				</tr>
			</table>
			<!-- biz_2 (S) -->
			<table class="search" id="mainTable4">
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="80">Delete Flag</td>
								<td>
									<select style="width:60px" name="delt_flg" onChange="delt_flg_OnChange();">
										<option value="Y">Y</option>
										<option value="N" selected>N</option>
									</select>									
									<!-- <script type="text/javascript">ComComboObject('delt_flg', 1, 40, 1, 0,0 ,false)</script> -->
								</td>
								<td width="100" align="right">Create User</td>
					            <td><input type="text" style="width:60px; margin-left:4px; text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td width="130" align="right">Create Date/Time</td>
					            <td><input type="text" style="width:118px; margin-left:4px; text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td width="130" align="right">Last Update User</td>
					            <td><input type="text" style="width:60px; margin-left:4px; text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="160" align="right">Last Update Date/Time</td>
					            <td><input type="text" style="width:118px; margin-left:4px; text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>
							</tr>
						</table>
						<table style="display: none"> 
							<colgroup>
									<col width="80"/>
									<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th>INPUT Flag</th>
									<td><input id="input_flg" name="input_flg" style="width: 500px;" class="input1" value="" type="text" /> </td>
								</tr>	
							</tbody>
						</table>
					</td>
				</tr>	
			</table>					
			<!-- biz_2 (E) -->
<%if(isRequest.equals("Y") || isCheck.equals("Y")) { %>
		</div>
<% } %>						
		<!-- biz page (E) -->			
		<!--Button (S) -->
<%if(isApprove.equals("Y")) { %>
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10; display:none;">
<%} else { %>
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<%} %>		
	       		<tr>
	       			<td class="btn1_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			   				 <tr>
<%if(isRequest.equals("Y")) { %>
								<td style="display:none;">		
<%} else { %>
	 	   						<td>			 
<%} %>			    
				    				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_History" id="btn_History">History</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Save1">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
<%if(isRequest.equals("Y") && isApprove.equals("")){ %>					
								<td id="btn_Create1">
<%} else { %>
								<td id="btn_Create1" style="display:none;">
<%} %>		
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Create" id="btn_Create">Create</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
<%if(isRequest.equals("Y")){ %>							
								<td id="btn_Request1">
<%} else { %>
								<td id="btn_Request1" style="display:none;">	
<%} %>		
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Request" id="btn_Request">Approval Request</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
					<!-- <td id="btn_Request1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Request">MDM Request</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td> -->
								<td width="20" id="bottom_space"></td>
<%if(isApprove.equals("N")) { %>
								<td style="display:none;">
<%} else {%>
								<td>
<%} %>					
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New" id="btn_New">New</td>
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
		</td>
	</tr>
</table>
<!-- 개발자 작업 끝 -->
<%-- <%if (!("true").equals(mainPage)){%>
</div>
</div>
<%} %> --%>
<!-- wrap_result (E) -->
</form>
</body>
</html>