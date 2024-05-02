<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0278.jsp
*@FileTitle : Group & Multi B/L Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>


<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.core.config.SubSystemConfigFactory" %>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0278Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg0278Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");
    String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/";     
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	
	if (separator !=null) fileDir.append(separator);
	
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg0278Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (null != serverException) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
      //Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (1 <= errMessage.length) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">

<!-- Start  -->

<input type="hidden" name="comboCd" >
<input type="hidden" name="sheet_bl_no_row_chk">
<input type="hidden" name="master_bl_no">
<input type="hidden" name="booking_rcv_term_cd">
<input type="hidden" name="booking_de_term_cd">
<input type="hidden" name="org_sconti_cd">
<input type="hidden" name="desc_sconti_cd">
<input type="hidden" name="org_svc_mod_cd">
<input type="hidden" name="desc_inlnd_svc_mod_cd">
<input type="hidden" name="cust_tp_cd">
<input type="hidden" name="bkg_cgo_tp_cd">
<input type="hidden" name="bkg_sts_cd">
<input type="hidden" name="adv_shtg_cd">
<input type="hidden" name="revenue">
<input type="hidden" name="query_sort">
<input type="hidden" name="rect_top">
<input type="hidden" name="rect_left">
<input type="hidden" name="obl_iss_date">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">
<input type="hidden" name="rd_domain" id="rd_domain" value="<%=CFG_FILEOPEN_LOGURL_BASE%>"/>

<!-- 제목 -->
<div class="page_title_area clear">
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<div class="opus_design_btn">
		<button type="button" style="display:none" class="btn_accent"  name="tb1_btn_Retrieve" id="tb1_btn_Retrieve">Retrieve</button><!--
	 --><button type="button" style="display:none" class="btn_normal" name="tb1_btn_New" id="tb1_btn_New">New</button><!--
	 --><button type="button" style="display:none" class="btn_normal" name="tb2_btn_DownExcel" id="tb2_btn_DownExcel">B/L List Down Excel</button><!--
	 --><button type="button" style="display:none" class="btn_normal" name="tb2_btn_Back" id="tb2_btn_Back">Back</button>
	</div>
		
   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_result">
	<div class="opus_design_tab sm"><script language="javascript">ComTabObject('tab1')</script></div>
	<!-- TAB Search (E) -->
	<div id="tabLayer" style="display:inline">		
		<div class="opus_design_inquiry wFit">
			<table>
				<tr>
					<td valign="top">
						<table>
	                   		<tr>
								<th class="align_left">VVD</th>
								<td><input type="text" name="vvd" style="width:80px;" class="input1" value="" required maxlength="9" dataformat="engup"></td>
								<th><label for="vsl_pre_pst_cd">Trunk only</label><input type="checkbox" id="vsl_pre_pst_cd" name="vsl_pre_pst_cd"  value="Y"></th>
							</tr>
	                        <tr>
								<th class="align_left">POL</th>
								<td colspan="3"><input type="text" name="vvd_pol_cd" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup">(
									<input type="checkbox" id="vvd_pol_local" name="vvd_pol_local" value="Y" class="trans" ><label for="vvd_pol_local">Local</label>
									<input type="checkbox" id="vvd_pol_ts" name="vvd_pol_ts" value="Y"  class="trans"><label for="vvd_pol_ts">T/S</label>)
								</td>
							</tr>
							<tr>
								<th class="align_left">POD</th>
								<td colspan="3"><input type="text" name="vvd_pod_cd" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup">(
									<input type="checkbox" id="vvd_pod_local" name="vvd_pod_local" value="Y" ><label for="vvd_pod_local">Local</label>
									<input type="checkbox" id="vvd_pod_ts" name="vvd_pod_ts" value="Y" ><label for="vvd_pod_ts">T/S</label>)
								</td>
	                        </tr>
	                        <tr>
								<th width="97" class="align_left">Pre VVD</th>
								<td width="100"><input type="text" name="vvd_pre_vvd" style="width:90px;" class="input" value="" maxlength="9" dataformat="engup"></td>
								<th width="50" class="align_left">Pre POL</th>
								<td><input type="text" name="vvd_pre_pol" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup"></td>
	                        </tr>
	                        <tr>
								<th class="align_left">Post VVD</th>
								<td><input type="text" name="vvd_post_vvd" style="width:90px;" class="input" value="" maxlength="9" dataformat="engup"></td>
								<th class="align_left">Post POD</th>
								<td><input type="text" name="vvd_post_pod" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup"></td>
							</tr>
                        </table>
                        <table>
							<tr>
								<th width="60" class="align_left">Booking Route</th>
								<td colspan="3"><input type="text" name="booking_por_cd" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup"><input type="text" name="booking_pol_cd" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup"><input type="text" name="booking_pod_cd" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup"><input type="text" name="booking_del_cd" style="width:60px;" class="input" value=""" maxlength="5" dataformat="engup"></td>
							</tr>
							<tr height="30"><td colspan="3"></td></tr>
	                        <tr>   
								<th class="align_left">R/D Term</th>
								<td colspan="3">
									<script language="javascript">ComComboObject('tb1_Mbooking_rcv_term_cd', 1, 80, 0);</script>
									<script language="javascript">ComComboObject('tb1_Mbooking_de_term_cd', 1, 80, 0);</script>
								</td>
							</tr>
							<tr>
								<th class="align_left">EQ Control Office</th>
								<td class="stm" width="116px">
									<input type="checkbox" id="eq_por_cd" name="eq_por_cd" value="Y" ><label for="eq_por_cd">POR</label>
									<input type="checkbox" id="eq_del_cd" name="eq_del_cd" value="Y" ><label for="eq_del_cd">DEL</label>
								</td>
								<td><input type="text" name="eq_ctrl_ofc_cd" style="width:60px;" class="input" value="" maxlength="6" dataformat="enguponly"></td>
							</tr>
							<tr height="30"><td colspan="3"></td></tr>
						</table>
						<table>
							<tr>
								<th width="40" class="align_left">B/L (
									<input type="radio" id="release" name="obl_iss_chk" value="R"  checked><label for="release">Release</label>
									<input type="radio" id="issue" name="obl_iss_chk" value="I" ><label for="issue">Issue</label>) Date
								</th>
								<td><input type="text" name="obl_iss_from_dt" style="width:81px;" class="input1" value="" maxlength="10" dataformat="ymd" caption="B/L Release sdate">~<input type="text" name="obl_iss_to_dt" style="width:82px;" class="input1" value="" maxlength="10" dataformat="ymd" caption="B/L Release edate"><button type="button" name="tb1_btn_calendar" class="calendar"></button></td>
							</tr>
						</table>
						<table>
							<tr>
								<th class="align_left">B/L No.</th>
								<td valign="top" name="td_bl_no" id="td_bl_no" width="123px">
									<div id="bl_input" style="display:block;">
										<input type="text" name="input_bl_no" id="input_bl_no" style="width:121px;" class="input1" value="" maxlength="12" dataformat="engup">
									</div>
									<div id="bl_sheet" name="bl_sheet" style="display:none;width:123px;height:150px;position:absolute;left:100px;top:315px;">
										<script language="javascript">ComSheetObject('t1sheet1');</script>
									</div>
								</td>
								<td colspan="2">	                                  	
									<button type="button" class="btn_etc" id="tb1_btn_input_bl_no" name="tb1_btn_input_bl_no">Multi B/L No.</button>		                               		
								</td>
							</tr>
							<tr>
								<th width="100" class="align_left">Booking Office</th>
								<td width="60" ><input type="text" name="bkg_ofc_cd" style="width:60px;" class="input" value="" maxlength="6" dataformat="enguponly"></td>
								<th width="100" class="align_left">Booking Staff</th>
								<td><input type="text" name="doc_usr_cd" style="width:170px;" class="input" value="" maxlength="20" dataformat="exceptengdn"></td>
							</tr>
							<tr>	
								<th class="align_left">Sales Office</th>
								<td><input type="text" name="ob_sls_ofc_cd" style="width:60px;" class="input" value="" maxlength="6" dataformat="enguponly"></td>
								<th class="align_left">Sales Rep.</th>
								<td><input type="text" name="ob_srep_cd" style="width:60px;" class="input" value="" maxlength="5" dataformat="engup"></td>
							</tr>
							<tr>	
								<th class="align_left">B/L Office</th>
								<td><input type="text" name="obl_iss_ofc_cd" style="width:60px;" class="input" value="" maxlength="6" dataformat="enguponly"></td>
								<th class="align_left">B/L Staff</th>
								<td><input type="text" name="obl_iss_usr_id" style="width:170px;" class="input" value="" maxlength="20" dataformat="exceptengdn"></td>
							</tr>
						</table>
					</td>
				
					<!-- 오른쪽  그리기 -->
					<td>
						<table border="0">
						<tr>
							<th width="110px" class="align_left">Rep. Commodity </th>
							<td width="95px"><input type="text" name="rep_cmdt_cd" style="width:42px;" class="input" value="" maxlength="4" dataformat="engup"><button type="button" name="tb1_btn_rep_cmdt_cd" id="btn_rep_cmdt_cd"  class="input_seach_btn"></button></td>
							<th width="130px" class="align_left">Commodity</th>
							<td width="*"><input type="text" name="cmdt_cd" style="width:60px;" class="input" value="" maxlength="6" dataformat="engup"><input type="text" name="cmdt_nm" style="width:60px;" class="input" value="" maxlength="200px" dataformat="enguponly"><button type="button" name="tb1_btn_cmdt_cd" id="btn_cmdt_cd" class="input_seach_btn"></button></td>
						</tr>
						<tr >
							<th width="110px" class="align_left">S/O No.</th>
							<td width=""><input type="text" name="twn_so_no" style="width:42px;" class="input" value="" maxlength="4" dataformat="enguponly"></td>
							<th width="" class="align_left">Regional Booking No.</th>
							<td width=""><input type="text" name="cust_ref_no" style="width:139px;" class="input" value="" maxlength="50" dataformat="enguponly"></td>
						</tr>
						</table>
						<table><tr><td colspan="8"></td></tr></table>
						<table border="0" style="width:100%;">
						<tr class="sm">
							<th width="170px">
								<input type="radio" id="sc" name="sc_rfa_chk" value="sc"  checked><label for="sc">S/C</label>
								<input type="radio" id="rfa" name="sc_rfa_chk" value="rfa" ><label for="rfa">RFA</label>
								<input type="radio" id="taa" name="sc_rfa_chk" value="taa" ><label for="taa">TAA</label>
							</th>
							<td width=""><input type="text" name="sc_rfa_no" style="width:170px;" class="input" value="" maxlength="20" dataformat="enguponly"><button type="button" name="tb1_btn_sc_rfa_no" id="btn_sc_rfa_no"  class="input_seach_btn"></button></td>
						</tr>
						</table>
						<table><tr><td colspan="8"></td></tr></table>
						<table class="search" border="0">
						<tr>
							<th width="60px" class="align_left">S.Route</th>
							<td width="180px">
								<script language="javascript">ComComboObject('tb1_Morg_sconti_cd', 1, 60, 1);</script>
								<script language="javascript">ComComboObject('tb1_Mdesc_sconti_cd', 1, 60, 1);</script>
							</td>
							<th width="60px" class="align_left">S.Mode</th>
							<td width="180px">
								<script language="javascript">ComComboObject('tb1_Morg_svc_mod_cd', 1, 60, 1);</script>
								<script language="javascript">ComComboObject('tb1_Mdesc_inlnd_svc_mod_cd', 1, 60, 1);</script>
							</td>
						</tr>
						</table>
						<table><tr><td colspan="8"></td></tr></table>
						<table border="0">
						<tr>
							<td width="478px" colspan="7">
							<table class="search" border="0">
						<tr>
							<td ></td>
							<td><h3 class="title_design">Customer</h3></td>
						</tr>
						</table>
						</td>
						</tr>
						<tr>
							<td width="72px"><input type="checkbox" id="cust_tp_cd_s" name="cust_tp_cd_s" value="Y"><label for="cust_tp_cd_s">Shipper</label></td>
							<td width="60px"><input type="checkbox" id="cust_tp_cd_c" name="cust_tp_cd_c" value="Y"><label for="cust_tp_cd_c">Consignee</label></td>
							<td width="60px"><input type="checkbox" id="cust_tp_cd_n" name="cust_tp_cd_n" value="Y"><label for="cust_tp_cd_n">Notify</label></td>
							<td width="60px"><input type="checkbox" id="cust_tp_cd_f" name="cust_tp_cd_f" value="Y"><label for="cust_tp_cd_f">Forwarder</label></td>
							<td width="100px"><input type="checkbox" id="cust_tp_cd_a" name="cust_tp_cd_a" value="Y"><label for="cust_tp_cd_a">Also Notify</label></td>
						</tr>
						<tr>
							<td width="" colspan="5"><input type="text" name="cust_cnt_cd" style="width:25px;" class="input" value="" maxlength="2" dataformat="enguponly"><input type="text" name="cust_seq" style="width:55px;" class="input" value="" maxlength="6" dataformat="int"><input type="text" name="cust_nm" style="width:330px;" class="input" value="" dataformat="enguponly"><button type="button" name="tb1_btn_cust_cd" id="btn_cust_cd" class="input_seach_btn"></button></td>
						</tr>
						</table>
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						<table class="search_sm" border="0">
						<tr>
							<td width="478px" colspan="7">
								<table class="search" border="0">
									<tr>
										<td></td>
										<td><h3 class="title_design">Special Cargo</h3></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="72px"><input type="checkbox" id="dcgo_flg" name="dcgo_flg" value="Y"><label for="dcgo_flg">Danger</label></td>
							<td width="65px"><input type="checkbox" id="rc_flg" name="rc_flg" value="Y"><label for="rc_flg">Reefer</label></td>
							<td width="60px"><input type="checkbox" id="awk_cgo_flg" name="awk_cgo_flg" value="Y"><label for="awk_cgo_flg">Awkward</label></td>
							<td width="*" colspan="2"><input type="checkbox" id="bb_cgo_flg" name="bb_cgo_flg" value="Y"><label for="bb_cgo_flg">Break Bulk</label></td>
                        </tr>
                        <tr>
                            <td width="*"><input type="checkbox" id="hngr_flg" name="hngr_flg" value="Y"><label for="hngr_flg">Hanger</label></td>
                            <td width="*"><input type="checkbox" id="shpr_ownr_cntr_flg" name="shpr_ownr_cntr_flg" value="Y"><label for="shpr_ownr_cntr_flg">S.O.C</label></td>
                            <td width="*"><input type="checkbox" id="eq_subst_flg" name="eq_subst_flg" value="Y"><label for="eq_subst_flg">EQ Sub</label></td>
                            <td width="90px"><input type="checkbox" id="rd_cgo_flg" name="rd_cgo_flg" value="Y"><label for="rd_cgo_flg">Reefer Dry</label></td>
                            <td width="*"><input type="checkbox" id="rail_blk_cd" name="rail_blk_cd" value="Y"><label for="rail_blk_cd">Rail Bulk</label></td>
                        </tr>
                        <tr>
                            <td width=""><input type="checkbox" id="stwg_cd" name="stwg_cd" value="Y"><label for="stwg_cd">Stowage</label></td>
                            <td width=""><input type="checkbox" id="hog_de_flg" name="hog_de_flg" value="Y"><label for="hog_de_flg">Hot(Premier)</label></td>
                            <td width=""><input type="checkbox" id="prct_flg" name="prct_flg" value="Y"><label for="prct_flg">Pre-caution</label></td>
                            <td width=""><input type="checkbox" id="fd_grd_flg" name="fd_grd_flg" value="Y"><label for="fd_grd_flg">Food Grade</label></td>
                            <td width=""><input type="checkbox" id="spcl_hide_flg" name="spcl_hide_flg" value="Y"><label for="spcl_hide_flg">Hide</label></td>
                        </tr>
                        </table>
                        <table class="height_5"><tr><td colspan="8"></td></tr></table>
                        <table border="0" width="478px">
                        <tr>
                            <th width="95px" class="align_left">Cargo Type</th>
                            <td width="">
	                            <input type="checkbox" id="bkg_cgo_tp_cd_f" name="bkg_cgo_tp_cd_f" value="F"><label for="bkg_cgo_tp_cd_f">Full</label>
	                            <input type="checkbox" id="bkg_cgo_tp_cd_p" name="bkg_cgo_tp_cd_p" value="P"><label for="bkg_cgo_tp_cd_p">Empty (for EQ reposition)</label>
	                            <input type="checkbox" id="bkg_cgo_tp_cd_r" name="bkg_cgo_tp_cd_r" value="R"><label for="bkg_cgo_tp_cd_r">Revenue Empty</label>
                            </td>
                        </tr>
                        </table>
                        <table><tr><td colspan="8"></td></tr></table>
                        <table border="0" width="478px">
                        <tr>
                            <th width="95px" class="align_left">Booking Status</th>
	                        <td width="*">
								<input type="checkbox" id="bkg_sts_cd_f" name="bkg_sts_cd_f" value="F"><label for="bkg_sts_cd_f">F-Firm</label>
								<input type="checkbox" id="bkg_sts_cd_w" name="bkg_sts_cd_w" value="W"><label for="bkg_sts_cd_w">W-Waiting(</label>
								<input type="checkbox" id="bkg_rsn_spcl_cgo_flg" name="bkg_rsn_spcl_cgo_flg" value="Y" disabled><label for="bkg_rsn_spcl_cgo_flg">Non approval of special cargo</label>
								<input type="checkbox" id="wt_rsn_hld_flg" name="wt_rsn_hld_flg"value="Y" disabled><label for="wt_rsn_hld_flg">Holding )</label>
							</td>
                        </tr>
                        </table>
                        <table><tr><td colspan="8"></td></tr></table>
                        <table class="search" border="0" width="478px">
                        <tr>
                        	<td width="47%">
							<table border="0" width="100%">
								<tr>
								<th width="96px" class="align_left">Memo B/L Type</th>
									<td width="">
										<input type="checkbox" id="adv_shtg_cd_a" name="adv_shtg_cd_a" value="A"><label for="adv_shtg_cd_a">ahead</label>
										<input type="checkbox" id="adv_shtg_cd_s" name="adv_shtg_cd_s" value="S"><label for="adv_shtg_cd_s">short</label>
									</td>
								</tr>
							</table>
							</td>
							<td width="1%"></td>
							<td width="50%">
								<table border="0" width="100%">
									<tr>
										<th width="60" class="align_left">Revenue</th>
										<td width="">
											<input type="checkbox" id="revenue_r" name="revenue_r" value="F|B|R"><label for="revenue_r">Revenue</label>
											<input type="checkbox" id="revenue_n" name="revenue_n" value="P"><label for="revenue_n">Non-Revenue</label>
										</td>
									</tr>
								</table>
							</td>
							</tr>
						</table>
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						<table border="0" width="478px">
							<tr>
								<td width="48%">
									<table border="0" width="100%">
										<tr>
										<th width="95px" class="align_left">ITN</th>
										<td width="">
											<input type="checkbox" id="aes_itn_y" name="aes_itn_y" value="Y"><label for="aes_itn_y">Yes</label>
											<input type="checkbox" id="aes_itn_n" name="aes_itn_n" value="Y"><label for="aes_itn_n">No</label>
										</td>
										</tr>
									</table>
								</td>
								<td width="1%"></td>
								<td>
									<table border="0" width="100%">
										<tr>
											<th width="100%" class="align_left"><input type="checkbox" id="stop_cargo" name="stop_cargo" value="Y"><label for="stop_cargo">Stop Cargo</label></th>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</tbody>
			</table>
		</div>
	</div>

    <!-- TAB Search (E) -->
        <!-- TAB Result (S) -->
    <div id="tabLayer" style="display:none">
    	<div class="opus_design_grid">
	   		<div class="opus_design_btn">
			   <button type="button" class="btn_normal"  name="tb2_btn_BLPreview" id="tb2_btn_BLPreview">B/L Preview</button>
			   <button type="button" class="btn_normal" name="tb2_btn_BLPrint" id="tb2_btn_BLPrint">B/L Print</button>
			   <button type="button" class="btn_normal" name="tb2_btn_Manifest" id="tb2_btn_Manifest">Manifest(US)</button>
			   <button type="button" class="btn_normal" name="tb2_btn_dovn" id="tb2_btn_dovn">D/O(VN)</button>
			   <button type="button" class="btn_normal" name="tb2_btn_Sort" id="tb2_btn_Sort">Sort</button>
			</div>
			<script language="javascript">ComSheetObject('t2sheet1');</script>
			<script language="javascript">ComSheetObject('t2sheet2');</script>
		</div>
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:979px;">
              <tr>
                <th width="80px" class="align_left">Booking Q'ty</th>
                <td width="120px"><input type="text" name="bookingCnt" style="width:88px;text-align:right;" class="input" value="" readonly></td>
                <th width="60px" class="align_left">B/L Q'ty</th>
                <td width="120px"><input type="text" name="bldocCnt" style="width:88px;text-align:right;" class="input" value=""readonly></td>
                <th width="85px" class="align_left">Weight(TON)</th>
                <td width="120px"><input type="text" name="weightTon" style="width:88px;text-align:right;" class="input" value="" readonly></td>
                <th width="50px" class="align_left">Measure</th>
                <td width="*"><input type="text" name="Measure" style="width:88px;text-align:right;" class="input" value="" readonly></td>
              </tr>
            </table>
		</div>		
    </div>
    <!-- TAB Result (E) -->
    <div class="wrap_result">
		<div class="opus_design_RD rd_hidden">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
</div>

</form>
<form name="form2" method="POST">
<input type="hidden" name="bkg_no">

</form>

