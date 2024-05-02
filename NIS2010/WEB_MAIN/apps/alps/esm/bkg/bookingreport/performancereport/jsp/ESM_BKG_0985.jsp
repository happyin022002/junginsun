
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0985.jsp
	 *@FileTitle :  0985 Queue Detail Return Pop Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 * 2013.04.16 김진주 [CHM-201324119] [BKG] 통합로그 Error 복구
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
<%@ page import="org.apache.log4j.Logger"%>

<%
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_eml = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

	} catch (Exception e) {
		out.println(e.toString());
	}
  String bkg_no   = JSPUtil.getParameter(request,"bkg_no"); 
  String sr_kind  = JSPUtil.getParameter(request,"sr_kind"); 
  String sr_no    = JSPUtil.getParameter(request,"sr_no"); 
  String sr_his_seq    = JSPUtil.getParameter(request,"sr_his_seq"); 
  String pnd_flg  = JSPUtil.getParameter(request,"pnd_flg"); 
  String src_cd   = JSPUtil.getParameter(request,"src_cd"); 
  String sr_crnt_info_cd = JSPUtil.getParameter(request,"sr_crnt_info_cd"); 
  String sr_crnt_sts_cd  = JSPUtil.getParameter(request,"sr_crnt_sts_cd"); 
  String ui_id           = JSPUtil.getParameter(request,"ui_id"); 
  String grp_cd           = JSPUtil.getParameter(request,"grp_cd"); 
  String message = JSPUtil.getParameter(request, "message");
  String wrkStTm = JSPUtil.getParameter(request, "wrk_st_tm");
%>	
<html>
<head>
<title> DPCS : Return Message </title>
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

<body class="popup_bg" onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="sr_knd_cd"      value="<%=sr_kind%>">
	<input type="hidden" name="sr_no"      value="<%=sr_no%>">
	<input type="hidden" name="sr_his_seq"      value="<%=sr_his_seq%>">
	<input type="hidden" name="bkg_no"      value="<%=bkg_no%>">
	<input type="hidden" name="pnd_flg"      value="<%=pnd_flg%>">
	<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="src_cd"      value="<%=src_cd%>">
	<input type="hidden" name="grp_cd"      value="<%=grp_cd%>">	
	<input type="hidden" name="wrk_st_tm"      value="<%=wrkStTm%>">	
	<input type="hidden" name="fo_rcv_eml" >
	<input type="hidden" name="strUsr_eml" value="<%=strUsr_eml%>">	
	
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="./img/icon_title_dot.gif"
					align="absmiddle">&nbsp;DPCS : Return Mail & Message</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				
				
				<table width="100%" class="search_sm"> 
				<tr class="h23">
					<td width="75"></td>
					<td class="stm" colspan ="3">
						 (For multiple input, type " ; " between each email address)
					</td>
					</tr>	
				<tr class="h23">
					<td width="75">&nbsp;&nbsp;To.</td>
					<td class="stm" colspan ="3">
						<input type="text" name="rtn_to_usr_eml" style="width:100%;" class="input" value="" caption="Email Address" maxlength="200">
					</td>
					</tr>	
				<tr class="h23">
					<td width="75">&nbsp;&nbsp;Return to</td>
					<td class="stm" colspan ="3">
						<input type="radio" value="S" class="trans" name="ui_grp_cd" onClick="javascript:setRtnTo(this.value);">FO&nbsp;<span id="fnt_ofc_eml"></span> 
		                <input type="radio" value="I" class="trans" name="ui_grp_cd" onClick="javascript:setRtnTo(this.value);">Inputer&nbsp;<span id="inputer_eml"></span> 
		                <input type="radio" value="R" class="trans" name="ui_grp_cd" onClick="javascript:setRtnTo(this.value);">Rater&nbsp;<span id="rater_eml"></span>
		                <input type="radio" value="P" class="trans" name="ui_grp_cd" onClick="javascript:setRtnTo(this.value);">S.REP&nbsp;<span id="srep_eml"></span>  
		                <input type="radio" value="C" class="trans" name="ui_grp_cd" onClick="javascript:setRtnTo(this.value);">Customer&nbsp;<span id="cust_eml"></span> </td>
		                
					</tr>
				<tr class="h23">
					<td width="75">&nbsp;&nbsp;Subject</td>
					<td class="stm" colspan ="3">
						<input type="text" name="eml_subj_ctnt" style="width:100%;" class="input" value="" caption="Email Subject" maxlength="200" required>
					</td>
				</tr>
				<tr class="h23">
					<td width="75">&nbsp;&nbsp;From.</td>
					<td class="stm" >
						<input type="text" name="rtn_from" style="width:100%;" class="input2" value="<%=strUsr_eml%>" caption="Email Address" maxlength="200" readonly>
					</td>
					<td lass="stm">&nbsp;&nbsp;FO Mail
					<input type="checkbox" value="Y" name="fo_incl_eml_flg" onClick="javascript:setRtnFrom(this);" class="trans">
						<span id="fnt_from_eml"></span>
					</td>
					<!--<td   class="stm">
						<input type="checkbox" value="Y" name="fo_incl_eml_flg" onClick="javascript:setRtnFrom(this);" class="trans">
						<span id="fnt_from_eml"></span>
					</td>
					--></tr>	
				<tr class="h23">
					<td width="75">&nbsp;&nbsp;Send Time</td>
					<td  class="stm" >
						<input type="text" name="st_dt" style="width:100%" class="input2" value="" caption="Send Time"  readonly>
					</td>
					<td colspan ="2">&nbsp;&nbsp;Do you use mail ?&nbsp;
						<input type="radio" name="eml_cpy_to_cust_flg" value="Y" class="trans" checked>Yes&nbsp;<input type="radio" name="eml_cpy_to_cust_flg" value="N" class="trans">No
					</td>
					</tr>	
				</table> 
				
				<table class="height_2"><tr><td></td></tr></table>
				<table width="100%" class="search_sm"> 
				<tr class="h23">
					<td width="">Why?- Select the reason</td>
				</tr>
				</table>	
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="49%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
						<td width="2%"></td>
						<td width="49%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				
				<table class="height_2"><tr><td></td></tr></table>
				<table width="100%" class="search_sm"> 
				<tr class="h23">
					<td colspan="4">&nbsp;&nbsp;Correction Job Screen - Select job screen to be corrected </td>
				</tr>
				<tr>
					<td width="17%"><input type="checkbox" value="Y" name="rsn_bkg_mn_flg" class="trans">BKG  Main</td>
					<td width="17%"><input type="checkbox" value="Y" name="rsn_cust_info_flg" class="trans">Customer</td>
					<td width="20%"><input type="checkbox" value="Y" name="rsn_frt_chg_flg" class="trans">FRT & Charge</td>
					<td width="20%"><input type="checkbox" value="Y" name="rsn_cntr_flg" class="trans">Container</td>
					<td width="%">  <input type="checkbox" value="Y" name="rsn_cntr_mf_flg" class="trans">Container Manifest</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="Y" name="rsn_dcgo_flg" class="trans">Danger</td>
					<td><input type="checkbox" value="Y" name="rsn_awk_cgo_flg" class="trans">Awkward</td>
					<td><input type="checkbox" value="Y" name="rsn_rc_flg" class="trans">Reefer</td>
					<td><input type="checkbox" value="Y" name="rsn_bb_cgo_flg" class="trans">B/Bulk</td>
					<td><input type="checkbox" value="Y" name="rsn_rly_port_flg" class="trans">RLY VVD & Port</td>
				</tr>
				<tr>
					<td><input type="checkbox" value="Y" name="rsn_new_bkg_flg" class="trans">New  BKG</td>
					<td><input type="checkbox" value="Y" name="rsn_split_flg" class="trans">BKG  Split</td>
					<td><input type="checkbox" value="Y" name="rsn_bl_info_flg" class="trans">B/L  Issue</td>
					<td><input type="checkbox" value="Y" name="rsn_hbl_flg" class="trans">NVO House B/L</td>
					<td><input type="checkbox" value="Y" name="cust_verif_flg" class="trans">Customer Verification</td>
				</tr>
				</table> 
				<!-- : ( Grid ) (S) -->
				<table width="100%" class="grid2"> 
				<tr>
					<td class="tr2_head" width="60">Message</td>
					<td align="center">
						<textarea name="message" style="width:100%;height:130"></textarea>
					</td>
					</tr>
				</table> 
				
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>


		<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td id="div_return">
											<table width="100%" border="0" cellpadding="0" cellspacing="0"
												class="button">
												<tr>
													<td class="btn1_left" id="btn_return_l"></td>
													<td class="btn1" name="btn_return" id="btn_return_c">Return</td>
													<td class="btn1_right" id="btn_return_r"></td>
												</tr>
											</table>
											</td>	
											<td class="btn1_line"></td>									
											<td>
													<table width="72" border="0" cellpadding="0" cellspacing="0"
														class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_Close">Close</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
											</td>
										</tr>
									</table>
							<!--Button (E) --></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>					
		<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>

</body>
</html>
