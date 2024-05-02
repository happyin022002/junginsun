
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0068.jsp
	 *@FileTitle : B/L(Manifest) Clearance Cross-Check List
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 * 2011.05.31 변종건 [CHM-201111165-01] BL Data Input Cross-check기능추가보완-Sailing Date 및 Multi-VVD Base검색조건 추가
	 * 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
	 * 2011.11.22 변종건 [CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
	 * 2013.05.31 김진주 [CHM-201324867] BL INPUT CROSS CHECK LIST - 조회조건 추가 : SOC
	 * 2014.03.06 조인영 [CHM-201429193] BL Data Input Cross Check 메뉴에 C.OFC, L.OFC의 sub 기능 추가
	 =========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0068Event"%>	
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0068Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	//String[] contiCd = null;
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0068Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// contiCd = RASUtil.getValueObject2StringArray((List<RsltContiListVO>)eventResponse.getCustomData("contiCd"), false, "|", "\t", "getContiCd", "getContiNm");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
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
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="curr_page"      value="1">
	<input type="hidden" name="rows_per_page"  value="50">

	<input type="hidden" name="mst_bkg_no">
	<input type="hidden" name="ca_rsn_cd">
	<input type="hidden" name="ca_remark">
    <input type="hidden" name="backendjob_key" value="">
	<input type="hidden" name="multi_vvd">
	<input type="hidden" name="dirty_flag">
	<input type="hidden" name="vvd_tmp">
	
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		<!--Page Title, Historical (S)-->
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="title">
					<tr>
						<td class="history"><img src="img/icon_history_dot.gif"
							align="absmiddle"><span id="navigation"></span></td>
					</tr>
					<tr>
						<td class="title"><img src="img/icon_title_dot.gif"
							align="absmiddle"><span id="title"></span></td>
					</tr>
				</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:999;"> 
					<tr class="h23">
						<td width="70">Multi-VVD</td>
						<td width="200" colspan="3" valign="top">
	                    	<table class="search" border="0">
	                        	<tr class="h23">
		                            <td valign="top" id="td_vvd_no" width="180">
		                               	<input type="text" name="vvd_sig" dataformat="engupnum" maxlength="9" class="input" style="width:80;" value="" onChange="javascript:insertItm(this);">&nbsp;
		                               	<script language="javascript">ComComboObject('p_vvd', 1, 100, 1);</script>
		                           	</td>
		                           	<td>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();">&nbsp;</td>

	                           	</tr>
	                        </table>
						</td>
						<td width="90">Template VVD</td>
						<td><select name="vvd_word_template" style="width:120;">
								<option value="0" selected>Select Template</option>
							</select>
							<img name="find_tmplt_m" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="320">
							<table class="search_sm2" border="0" style="width:310;"> 
								<tr class="h23">
									<td width="90">Special Cargo</td>
									<td class="stm"><input type="checkbox"  value="Y" name="p_dcgo_flg" class="trans">DG&nbsp;
									                <input type="checkbox"  value="Y" name="p_rc_flg" class="trans">RF&nbsp;
									                <input type="checkbox"  value="Y" name="p_awk_cgo_flg" class="trans">AK&nbsp;
									                <input type="checkbox"  value="Y" name="p_bb_cgo_flg" class="trans">BB&nbsp;
									                <input type="checkbox"  value="Y" name="p_soc_cgo_flg" class="trans">SOC</td>
								</tr>
							</table>
						
						
						</td>
						<td width="100">
							<input type="checkbox"  value="Y" name="p_si_ready_flg" class="trans">S/I ready
						</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:999;"> 
					<tr class="h23" width="900" border="0">
						<td width="25">POL</td>
						<td width="110">
							<input type="text" style="width:50" value="" name="p_pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">
						    <input type="text" style="width:25" value="" class="input" name="p_pol_yd_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
						</td>
						<td width="25">L/T</td>
						<td width="90"><select style="width:60;" class="input" name="p_pol_lt">
							<option value="">ALL</option>
							<option value="LC" Selected>Local</option>
							<option value="TS">T/S</option>
							</select></td>
						<td width="25">POR</td>
						<td width="80"><input type="text" style="width:50" value="" name="p_por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="40">A/POD</td>
						<td width="90"><input type="text" style="width:50" name="p_apod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="25">L/T</td>
						<td width="90"><select style="width:60;" class="input" name="p_apod_lt">
							<option value="">ALL</option>
							<option value="LC">Local</option>
							<option value="TS">T/S</option>
							</select></td>
						<td width="25">DEL</td>
						<td width="80"><input type="text" style="width:50" value="" class="input" name="p_del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" ></td>
						<td width="19">Zone</td>
						<td width="110" style="padding-left:3">
							<select style="width: 78;" class="input" name="p_zone_cd">
								<option value=""></option>
								<option value="OCN">Ocean</option>
								<option value="IPT">Inter Port</option>
							</select>
						</td>
						<td width="160">DEL Cont &nbsp;<script language="javascript">ComComboObject('p_del_conti', 1, 70, true, '');</script></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:999;">
					<tr class="h23">
						<td width="65">BKG OFC</td>
						<td width="95" class="sm"><input type="text" style="width: 45" value="" class="input" name="p_bkg_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled">
							<input type="checkbox" value="Y" class="trans" name="p_ofc_cd">Sub</td>
						<td width="55">BKG STF</td>
						<td width="70"><input type="text" style="width: 60" value=""	class="input" name="p_doc_usr_id" maxlength='20' dataformat='engnum' style="ime-mode:disabled"></td>
						<td width="30">BS</td>
						<td width="75">
						<script language="javascript">ComComboObject('blck_stwg_cd', 1, 70, 1);</script>						
						<td width="40">L.OFC</td>
						<td width="95" class="sm"><input type="text" style="width: 50" value=""	class="input" name="p_ob_sls_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled">
						<input type="checkbox" value="Y" class="trans" name="l_ofc_sub">Sub</td>
						<td width="30">L.REP</td>
						<td width="60"><input type="text" style="width: 50"	value="" class="input" name="p_ob_srep_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled"></td>
						<td width="30">C.OFC</td>
						<td width="95" class="sm"><input type="text" style="width: 50" value=""	class="input" name="p_ctrt_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled">
						<input type="checkbox" value="Y" class="trans" name="c_ofc_sub">Sub</td>
						<td width="30">C.REP</td>
						<td width="55"><input type="text" style="width: 50"	value="" class="input" name="p_ctrt_srep_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled"></td>
						<td width="70">BKG Status</td>
						<td width="75">
						<script language="javascript">ComComboObject('p_bkg_sts_cd', 1, 70, true, '');</script>
							<!--<select style="width: 60;" class="input" 	name="p_bkg_sts_cd">
							<option value="1"></option>
							<option value="2"></option>
							<option value="3"></option>
						</select>
						--></td>
					</tr>
				</table>	
				
				
				<table class="search" border="0" style="width:999;"> 
				<tr class="h23">
					<td width="70">Cargo Type</td>
					<td width="65"><script language="javascript">ComComboObject('p_cnmv_sts_cd', 1, 60, true, '');</script></td>
					<td width="120">E/Q Type&nbsp;<script language="javascript">ComComboObject('p_eq_type', 1, 50, true, '');</script></td>
					<td width="118">R/D &nbsp;<script language="javascript">ComComboObject('p_rcv_term_cd', 1, 39, true, '');</script>
							&nbsp;<script language="javascript">ComComboObject('p_de_term_cd', 1, 39, true, '');</script></td>
					<td width="73">BDR Status</td>
						<td width="46">
							<select style="width: 40;" class="input" name="p_bdr_flg">
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select>
						</td>
						<td width="80">S/I Received</td>
					<td width="50">
						<select style="width:40;" class="input" name="p_si_flg">
							<option value="" ></option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>
					<td width="50">B/L OFC</td>
					<td width=""><input type="text" style="width:50" value="" class="input" name="p_obl_iss_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>
					<td width="44">S/C No</td>
					<td width="105"><input type="text" style="width:100" value="" class="input" name="sc_no" dataformat='engupnum' style="ime-mode:disabled"></td>
				    <td width="26">VGM</td>
						<td width="82">
							<select style="width: 82;" class="input" name="vgm_flg">
							<option value="">ALL</option>
							<option value="Y">YES</option>
							<option value="I">INCOMPLETE</option>								
							<option value="N">NO</option>
							</select>
						</td>
				</tr>
				</table>	
				
				
				<table class="search" border="0" style="width:999;"> 
				<tr class="h23">
					
					<td width="60">Customer</td>
					<td width="300">
					<script language="javascript">ComComboObject('p_bkg_cust_tp_cd', 1, 50, true, '');</script>
						<input type="text" style="width:30" value="" class="input" name="p_cust_cnt_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled">
						<input type="text" style="width:50" value="" class="input" name="p_cust_seq" maxlength='6' dataformat='num' style="ime-mode:disabled">
						<input type="text" style="width:150" value="" class="input" name="p_cust_nm" maxlength='50' dataformat='custname' style="ime-mode:disabled"></td>
					<td width="60">No Good</td>
					<td width="160">
					<!-- comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab --> 
							<script language="javascript">ComComboObject('p_no_good', 1, 150, 1);</script>
					<td width="110">US Customs Type</td>
					<td width="80" style="padding-left:3">
						<select style="width: 70;" class="input" name="entr_clss_tp_cd">
							<option value="" selected>ALL</option>
							<option value="GE">General</option>
							<option value="IE">T&E/IE</option>
						</select>
					</td>
					<td width="110">
						<input type="checkbox"  value="Y" name="p_dpcs_flg" class="trans">Display DPCS
					</td>
					<td width=""><input type="checkbox" name="chk_dup_vvd"  value="D" class="trans">Dup. VVD</td>
				</tr>
				</table>	
				<!--  biz_1   (E) -->
				
				</td>
			</tr>
		</table>

			<table class="height_8"><tr><td></td></tr></table>
			
			
			
			<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
	       	<tr>
	      	 	<td class="bg">
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
								<div style="display:none">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</div>
							</td>
						</tr>
					<!-- <div style="display:none"> -->


					</table>

					<!-- Grid (E) -->
				
						
							<table width="100%" class="grid2"> 
							<tr>	<td width="32" class="tr_head3" rowspan="3" align="center"><strong>Total</strong></td>
								<td width="7%" class="tr2_head">No. of BKG</td>
								<td width="4%" class="noinput2"><input type="text" name="total_bkg" style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td width="7%" class="tr2_head">BKG Q'ty</td>
								<td width="6%" class="noinput2"><input type="text" name="total_bkg_f" style="width:100%;text-align:right" value="" class="noinput2"></td>
								<td width="6%" class="noinput2"><input type="text" name="total_bkg_t" style="width:100%;text-align:right" value="" class="noinput2"></td>
								<td width="7%" class="tr2_head">Dup BKG</td>
								<td width="4%" class="noinput2"><input type="text" name="dup_bkg" style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td width="9%" class="tr2_head">Non-CFM CNTR</td>
								<td width="4%" class="noinput2"><input type="text" name="total_cfm" style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td width="10%" class="tr2_head">Non-CM CNTR</td>
								<td width="4%" class="noinput2"><input type="text" name="total_cm" style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td width="9%" class="tr2_head">No Rated B/L</td>
								<td width="4%" class="noinput2"><input type="text" name="total_charge" style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td width="12%" class="tr2_head">Non-Issued B/L</td>
								<td width="%" class="noinput2"><input type="text" name="total_issue" style="width:100%;text-align:center" value="" class="noinput2"></td>
							</tr>
							<tr>
								<td class="tr2_head">No of B/L</td>
								<td class="noinput2"><input type="text" name="total_bl"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head">CNTR Q'ty</td>
								<td class="noinput2"><input type="text" name="total_ctrl_f"  style="width:100%;text-align:right" value="" class="noinput2"></td>
								<td class="noinput2"><input type="text" name="total_ctrl_t"  style="width:100%;text-align:right" value="" class="noinput2"></td>
								<td class="tr2_head">Dup CNTR</td>
								<td class="noinput2"><input type="text" name="dup_cntr"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head">Non-VL CNTR</td>
								<td class="noinput2"><input type="text" name="total_vl"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head">Non-M & D CNTR</td>
								<td class="noinput2"><input type="text" name="total_md"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head">No Approval</td>
								<td class="noinput2"><input type="text" name="total_apprval"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head">Non-Received S/R</td>
								<td class="noinput2"><input type="text" name="total_receiving"  style="width:100%;text-align:center" value="" class="noinput2"></td>
							</tr>
							<tr>
								<td class="tr2_head">No of CNTR</td>
								<td class="noinput2"><input type="text" name="total_cntr_cnt"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head">No of Vgm</td>
								<td class="noinput2"><input type="text" name="total_vgm_cnt"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="noinput2"></td>
								<td class="tr2_head">Non Vgm</td>
								<td class="noinput2"><input type="text" name="total_no_vgm_cnt"  style="width:100%;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head"></td>
								<td class="noinput2"></td>
								<td class="tr2_head"></td>
								<td class="noinput2"></td>
								<td class="tr2_head"></td>
								<td class="noinput2"></td>
								<td class="tr2_head"></td>
								<td class="noinput2"></td>
							</tr>

							</table> 
					        <br>
					        <div id="dpcs">
					        <table width="100%" class="grid2"> 
							<tr>
								<td class="tr2_head" style="width:70;">DPCS TTL</td>
								<td class="noinput2"><input type="text" name="dpcs_ttl"  style="width:30;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head" style="width:70;">Input</td>
								<td class="noinput2"><input type="text" name="dpcs_input" style="width:30;text-align:right" value="" class="noinput2"></td>								
								<td class="tr2_head" style="width:70;">Rate</td>
								<td class="noinput2"><input type="text" name="dpcs_rate"  style="width:30;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head" style="width:70;">QA</td>
								<td class="noinput2"><input type="text" name="dpcs_qa"  style="width:30;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head" style="width:70;">BL Proof</td>
								<td class="noinput2"><input type="text" name="dpcs_bl_proof"  style="width:30;text-align:center" value="" class="noinput2"></td>								
								<td class="tr2_head" style="width:70;">Status</td>
								<td class="tr2_head" style="width:70;">Complete</td>
								<td class="noinput2"><input type="text" name="status_complete"  style="width:30;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head" style="width:70;">Pending</td>
								<td class="noinput2"><input type="text" name="status_pending"  style="width:30;text-align:center" value="" class="noinput2"></td>
								<td class="tr2_head" style="width:70;">Open</td>
								<td class="noinput2"><input type="text" name="status_open"  style="width:30;text-align:center" value="" class="noinput2"></td>
							</tr>
							</table> 
							</div>
							
							<div id="empty_dpcs">
							<table class="search" border="0" style="width:100%"> 
							<tr><td>&nbsp;</td></tr>
							</table>
							</div>
				
							<table class="height_8"><tr><td></td></tr></table>	
	
							<table width="100%" class="button" border="0"> 
					       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_Combine">Combine</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
							</tr>
							</table>

					</td>
				</tr>
			</table>
			

						


		<!--biz page (E)-->
		
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
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
									<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
									<td class="btn1_line"></td>
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
									<td class="btn1_line"></td>
									<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
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
		
		
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->


</form>

	<!-- 레포트  팝업  -->
<form name="form2" method="post">
    <input type="hidden" name="rfn">
    <input type="hidden" name="mrd">
    <input type="hidden" name="rd_title">
    <input type="hidden" name="rp">
    <input type="hidden" name="rv">
</form>

</body>
</html>