<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_02c.jsp
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues : ESM_BKG_0079 화면의 TRO-C tab 화면
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.09.29 이일민 스크립트오류수정
 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
 2012.09.12 조정민 [CHM-201219535] [BKG] EUR TRO 화면 로직추가 (Optimum status 표기)
 2012.10.04 조정민 [CHM-201220238] [BKG] [EUR TRO] ADD,Copy CNTR에 Optimum조회추가 & 금액읽어오는 로직 & 버튼색깔 보완
 2012.10.29 조정민 [CHM-201220788] [EUR TRO] Manifested Amount Hiding, Speical Instruction 공간확대
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902cEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg007902cEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
    String bkgNo   = "";	
    String ioBndCd = ""; 
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.TransferOrderIssue");
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	try {

        event = (EsmBkg007902cEvent)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		if (event != null) {
		    bkgNo   = event.getBkgNo(); 
		    ioBndCd = event.getBoundCd(); 
		}	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRO(Transportation Request Order) for Inland Haulage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.input2_2		{  height: 20px; border: #7896B1 1px solid; font-family: Tahoma,Arial,dotum,gulim; font-size: 12px; color: #606060; text-indent: 2px;  background-color:#E8E7EC; font-weight:bold;}
</style>


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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- 아래 hidden 확인할 것 : 0317 -->
<input type="hidden" name="io_bnd_cd"         value="<%=ioBndCd%>"><!-- all popup use -->
<input type="hidden" name="conti_cd"          value=""><!-- 대륙코드 : Booking정보 -->
<input type="hidden" name="oldBkgNo"          value=""><!-- 조회된 bkg_no : 체크/저장용 -->
<input type="hidden" name="oldBlNo"           value=""><!-- 조회된 bl_no : 체크/저장용 -->
<input type="hidden" name="eml"               value="">
<input type="hidden" name="fax_no"            value="">
<input type="hidden" name="cmdt"              value="">
<input type="hidden" name="receiver"          value="">
<input type="hidden" name="other"             value="">
<input type="hidden" name="cust_ntc"          value="">
<input type="hidden" name="slct_cntr"         value="">
<input type="hidden" name="pcInqFlag"         value="N">
<input type="hidden" name="routeModifyFlag"   value="N">
<input type="hidden" name="bdrFlag"           value="">
<input type="hidden" name="obDoorArrDt"       value="">
<input type="hidden" name="ibDoorArrDt"       value="">
<input type="hidden" name="curr_tro_seq"      value="">
<input type="hidden" name="curr_tro_sub_seq"  value="">
<input type="hidden" name="ca_flg"            value=""><!-- C/A Flag --> 
<input type="hidden" name="f_del_flg"         value="">
<input type="hidden" name="post_flg"          value=""><!-- 저장후속 처리구분 Flag -->
<input type="hidden" name="max_tro_seq_old"   value="0"><!-- SeqSeq버튼사용구분 화면제어용 -->
<input type="hidden" name="eur_trns_tp_cd"    value="">
<!-- header : default setting용 --> 
<input type="hidden" name="por_nod_cd"        value="">
<input type="hidden" name="return_cy"         value="">
<input type="hidden" name="pickup_cy"         value="">
<input type="hidden" name="cmdt_cd"           value="">
<input type="hidden" name="cmdt_nm"           value="">
<input type="hidden" name="bkg_rep_cmdt_cd"   value="">
<input type="hidden" name="bkg_rep_cmdt_nm"   value="">
<input type="hidden" name="act_wgt"           value="">
<input type="hidden" name="wgt_ut_cd"         value="">
<input type="hidden" name="fd_grd_flg"        value="">
<input type="hidden" name="spcl_hide_flg"     value="">
<input type="hidden" name="etb_dt"            value="">
<input type="hidden" name="rtn_dt"            value="">
<input type="hidden" name="rtn_dt_hhmi"       value="">
<input type="hidden" name="pkup_dt"           value="">
<input type="hidden" name="pkup_dt_hhmi"      value="">
<input type="hidden" name="aloc_sts_cd"      value="">
<input type="hidden" class="noinput" name="modify_flag" value="N">
<input type="hidden" name="optm_flag" value="N">
<input type="hidden" name="bse_port_loc_cd"       value="">
<input type="hidden" name="pnt_loc_cd"           value="">
<input type="hidden" name="trsp_mode_cd"      value="">
<input type="hidden" name="rf_flag"       value="">
<input type="hidden" name="awk_flag"           value="">
<input type="hidden" name="dg_flag"      value="">
<input type="hidden" name="chk_trsp_mod_cd"      value="">
<input type="hidden" name="manifest_flag"      value="">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
		<!--biz page (S)-->
		<table class="search"  style="width:998;"> 
   		<tr><td class="bg">	

			<!--  biz_1 (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Bkg No.</td>
					<td width="140"><input type="text" name="bkg_no" style="width:115;" value="<%=bkgNo%>" class="input" fullfill maxlength="13" style="ime-mode:disabled" dataformat="uppernum" tabindex=2>
								    <img name="btn_splitPop" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1>
					</td>
					<td width="50">B/L No.</td>
					<td width="120"><input type="text" name="bl_no"     style="width:115;" value="" class="input" maxlength="13" style="ime-mode:disabled" dataformat="uppernum" tabindex=4>
					                <!--input type="text" name="bl_tp_cd"  style="width:30;" value="" class="input2" maxlength="1" style="ime-mode:disabled" dataformat="uppernum" readonly-->
					</td>
					<td width="50">Bound</td>
					<td width="60"><input type="text" name="io_bnd_cd_disp" value="" style="width:40;color:#6666ff;" class="input2" readonly tabindex=-1></td>
					<td width="38">Status</td>
					<td width="85"><input type="text" name="bkg_sts_cd" style="width:25;" value="" class="input2" readonly tabindex=-1>&nbsp;
								   <input type="text" name="non_rt_sts_cd" style="width:25;" value="" class="input2" readonly tabindex=-1></td>
					<td rowspan="4" valign="top" width="222">
						<!-- Total Volume (S) -->						
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Total Volume</td></tr>
							<tr><td class="height_5"></td></tr>
						</table>
					
						<table border="0"> 
							<tr class="tr2_head">
								<td width="222">
									<script language="javascript">ComSheetObject('t2csheet5');</script>
								</td>
							</tr>
						</table>
						<!-- Total Volume (E) -->
					
					</td>
				</tr>
				<tr class="h23">
					<td>T/VVD</td>
					<td><input type="text" name="vsl_cd"     style="width:50;" value="" class="input2" readonly tabindex=-1>
					    <input type="text" name="skd_voy_no" style="width:50;" value="" class="input2" readonly tabindex=-1>
					    <input type="text" name="skd_dir_cd" style="width:30;" value="" class="input2" readonly tabindex=-1></td>
					<td>Route</td>
					<td colspan="3"><input type="text" name="por_cd" style="width:50;" value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="pol_code" style="width:50;" value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="pod_cd" style="width:50;" value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="del_cd" style="width:50;" value="" class="input2" readonly tabindex=-1></td>
					<td><span name="cyHeader" id="cyHeader">Return CY</span></td>
					<td><input type="text" name="cy1" style="width:60;" value="" class="input2" readonly tabindex=-1>
					    <input type="text" name="cy2" style="width:30;" value="" class="input2" readonly tabindex=-1></td>
				</tr>
				<tr class="h23">
					<td colspan="8">
						<table class="search" border="0">
							<tr class="h23">
                                <td width="20">
								    <input type="checkbox" name="dcgo_flg" class="trans" disabled tabindex=-1>
								</td>
								<td width="85">
								    <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Danger" id="btn_Danger">Danger</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								<td class="stm" width="55"><input type="checkbox" name="hcdg" value="" class="trans" disabled=true tabindex=-1>HCDG </td>
								
								<td width="20">
								    <input type="checkbox" name="rc_flag" class="trans" disabled tabindex=-1>
								</td>
								<td width="85">
								    <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Reefer" id="btn_Reefer">Reefer</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>

								<td width="20">
								    <input type="checkbox" name="awk_cgo_flg" class="trans" disabled tabindex=-1>
								</td>
								<td width="138">
								    <table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						                <tr>
						                    <td class="btn2_left"></td>
						                    <td class="btn2" name="btn_Awkward" id="btn_Awkward">Awkward</td>
						                    <td class="btn2_right"></td>
						                </tr>
						            </table>
						        </td>
								
								<td width="138">Cargo Type &nbsp;
								                <input type="text" name="bkg_cgo_tp_cd" value="" style="width:23;" class="input2" readonly tabindex=-1></td>
								<td width="75">R/D Term</td>
								<td width=""><input type="text" name="term" value="" style="width:23;" class="input2" readonly tabindex=-1></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr class="h23">
					<td>Customer</td>
					<td colspan="7"><input type="text" name="cust_cnt_cd" style="width:30;"  value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="cust_seq"    style="width:70;"  value="" class="input2" readonly tabindex=-1>
					                <input type="text" name="cust_nm"     style="width:480;" value="" class="input2" readonly tabindex=-1></td>
				</tr>
			</table>
			<!--  biz_1   (E) -->	
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!--  biz_2 (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">CNTR Seq.</td>
					<td width="100">
						<!-- TRO seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('tro_seq', 1, 50, 1);</script>
						<!-- TRO seq : 콤보출력 End-------------->
						<input type="text" name="tro_seq_maxcnt" style="width:30;" class="input2" readonly tabindex=-1></td>
						
					<td width="25">Sub</td>
					<td width="50"><input type="text" name="rqst_sub_seq" value="" style="width:40;" class="input" tabindex=10></td>
					
					<td width="60">CNTR No.</td>
					<td width="120">
					<script language="javascript">ComComboObject('cntr_no_sel', 1, 110, 1);</script>
					<input type="hidden" style="width:86;" name="cntr_no" class="input" maxlength="11" style="ime-mode:disabled" dataformat="uppernum" tabindex=12></td>
					
					<td width="40">TP/SZ</td>
					<td width="50"><input type="text" name="cntr_tpsz_cd" value="" style="width:28;" class="input1" maxlength="2" style="ime-mode:disabled" dataformat="uppernum" tabindex=14></td>
					<td width="65">
					    <table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
						    <tr>
						        <td class="btn2_left"></td>
						        <td class="btn2" name="btn_t2cMulti" id="btn_t2cMulti">Multi</td>
						        <td class="btn2_right"></td>
						    </tr>
						</table></td>
						
					<td width="60">D/G Seq.</td>
					<td width="80">
					    <!-- D/G seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('dcgo_seq', 2, 70, 1);</script>
						<!-- D/G seq : 콤보출력 End-------------->					    
					</td>
					<td width="60">R/F Seq.</td>
					<td width="80">
					    <!-- R/F seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('rc_seq', 2, 70, 1);</script>
						<!-- R/F seq : 콤보출력 End-------------->
					</td>
					<td width="60">A/K Seq.</td>
					<td width="" align="right">
		                <!-- A/K Seq : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('awk_cgo_seq', 1, 70, 1);</script>
						<!-- A/K Seq  : 콤보출력 End--------------> 
					</td>
				</tr>
				</table>
					
				<table class="search" border="0" style="width:715;"> 
				<tr class="h23">
					<td width="74">Haulage</td>
					<td width="71"> 
						<!-- Haulage : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('hlg_tp_cd', 1, 50, 1);</script>
						<!-- Haulage  : 콤보출력 End--------------> 
					</td>
					<td width="101">Cargo Weight</td>
					<td width="164"><input type="text" name="cgo_wgt"    style="width:105;text-align:right" value="" class="input1" maxlength="7" pointcount="3" dataformat="float" tabindex=16>
					                <input type="text" name="cgo_wgt_tp" style="width:30;" value="KG" class="input2" readonly tabindex=-1></td>
					<td width="40">Mode</td>
					<td width="110"> 
						<!-- TransMode : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('bkg_trsp_mzd_cd', 2, 90, 1, 1, 1);</script>
						<!-- TransMode  : 콤보출력 End--------------> 
					</td>
					<td width="69">Optimum</td>
					<td width="81">
						<!-- Optimum : 콤보출력 Start ----------->
						<script language="javascript">ComComboObject('optm_sts_cd', 1, 60, 1);</script>
						<!-- Optimum : 콤보출력 End-------------->	
					
					<!--  <input type="text" name="optm_sts_cd"   style="width:70;" value="" class="input2" readonly tabindex=-1>-->
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="69">Return CY</td>
					<td width="81"><input type="text" name="cntr_rtn_yd_cd"   style="width:70;" value="" class="input1" maxlength="7" dataformat="uppernum" style="ime-mode:disabled" tabindex=20></td>
					<td width="80">Return Date</td>
					<td width=""><input type="text"  name="cntr_rtn_dt"      style="width:79;" value="" class="input1" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="Return Date" tabindex=22>
					             <img class="cursor" name="btns_calendar"    src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1>
					             <input type="text"  name="cntr_rtn_dt_hhmi" style="width:46;" value="" class="input1" maxlength="5" dataformat="hm" style="ime-mode:disabled" caption="Return Date(hour)" tabindex=24></td>
					<td width="53">P/Up CY</td>
					<td width="100"><input type="text" name="cntr_pkup_yd_cd" style="width:71;" value="" class="input" maxlength="7" dataformat="uppernum" style="ime-mode:disabled" tabindex=18></td>
					<td width="70">P/Up Date</td>
					<td width="160"><input type="text"  name="cntr_pkup_dt"      style="width:79;" value="" class="input" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="P/Up Date" tabindex=32>
					                <img class="cursor" name="btns_calendar_2"   src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1>
					                <input type="text"  name="cntr_pkup_dt_hhmi" style="width:46;" value="" class="input" maxlength="5" dataformat="hm" style="ime-mode:disabled" caption="P/Up Date(hour)" tabindex=34></td>
					<td width="60"><span name="canceled" id="canceled" tabindex=-1></span></td> 
					<td width="">
					    <table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						    <tr><td class="btn2_left"></td>
						        <td class="btn2" name="btn_t2cT1Revenue" id="btn_t2cT1Revenue">T1 Revenue</td>
						        <td class="btn2_right"></td>
						    </tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="72">Commodity</td>
					<td width="73" align ="left" ><input type="text" name="tro_cmdt_cd" style="width:60;" value="" class="input1" maxlength="6" dataformat="uppernum" style="ime-mode:disabled" tabindex=26></td>
					<td width="102">Rep. Commodity</td>
					<td width="400"><input type="text"  name="rep_cmdt_cd"       style="width:50;"  value="" class="input1" maxlength="4" dataformat="uppernum" style="ime-mode:disabled" tabindex=28>
					                <input type="text"  name="rep_cmdt_nm"       style="width:300;"  value="" class="input1" maxlength="4000" tabindex=30>
					                <img class="cursor" name="btns_repCommodity" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
					<td width="212"></td>
					<td width="100">
					    <div id="DIV_btn_t2cDropOff" style="display:none;">
					    <table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						    <tr><td class="btn2_left"></td>
						        <td class="btn2" name="btn_t2cDropOff" id="btn_t2cDropOff">Drop Off</td>
						        <td class="btn2_right"></td>
						    </tr>
						</table>
						</div>
					</td>
					<td width="">&nbsp;
					</td>

				</tr>	
				</table>			
			<!--  biz_2   (E) -->
			
			<!--  biz_2   (S) -->									
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Grid (S) -->
			<table width="979" class="search_sm" border="0"> 
			<tr>
				<td width="750">				
					<table width="750" class="search"> 
						<tr class="h23">
							<td width="40">Type</td>
							<td width="98">
								<!-- Door Type : 콤보출력 Start ----------->
								<script language="javascript">ComComboObject('dor_addr_tp_cd', 1, 78, 1);</script>
								<!-- Door Type : 콤보출력 End-------------->
						    </td>
							<td width="100">Location/Zone</td>
							<td width="192"><input type="text" name="dor_loc_cd" caption="Locaction Code" style="width:50;" class="input1" maxlength="5" dataformat="uppernum" fullfill tabindex=36>
							                <input type="text" name="zn_cd"      style="width:25;" class="input1" maxlength="2" tabindex=38>
							                <img class="cursor" name="btns_popLocation" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
							<td width="65">Load Ref.</td>
							<td width="130"><input type="text" name="lod_ref_no" style="width:100;" value="" class="input" maxlength="50" tabindex=40></td>
							<td width="20">Zip</td>
							<td width=""><input type="text" name="dor_pst_no" style="width:100;" value="" class="input1" caption="Zip" maxlength="10" dataformat="engupspecial" style="ime-mode:disabled" tabindex=42></td>
						</tr>
					</table>
					<table class="height_2"><tr><td colspan="8"></td></tr></table>
					<table width="750" class="search"> 
						<tr class="h23">
							<td width="370">							
								<table width="370" class="grid2">
									<tr>
										<td class="tr2_head" width="80">Company</td>
										<td name="td_dor_addr_1" class=""><input type="text" name="dor_addr_1" style="width:295;" value="" class="input1" maxlength="50" style="ime-mode:disabled" tabindex=50></td>
									</tr>
									<tr>
									    <td class="tr2_head" width="80" rowspan="3">Address</td>
										<td name="td_dor_addr_2" class=""><input type="text" name="dor_addr_2" style="width:295;" value="" class="input1" maxlength="50" style="ime-mode:disabled" tabindex=52></td>
									</tr>
									<tr>
										<td name="td_dor_addr_3" class=""><input type="text" name="dor_addr_3" style="width:295;" value="" class="input" maxlength="50" style="ime-mode:disabled" tabindex=54></td>
									</tr>
									<tr>
										<td name="td_dor_addr_4" class=""><input type="text" name="dor_addr_4" style="width:295;" value="" class="input2" readonly maxlength="50" style="ime-mode:disabled" tabindex=56></td>
									</tr>
								</table>
							</td>
							<td width="60" valign="top">&nbsp;<img name="btns_Address" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1></td>
							<td width="320">
								<table width="320" class="search"> 
									<tr class="h23">
										<td width="108">Door Arrival Date</td>
											<td width=""><input type="text"  name="arr_dt"          style="width:80;" value="" class="input1" maxlength="10" dataformat="ymd" style="ime-mode:disabled" caption="Door Arrival Date" tabindex=58>
											             <img class="cursor" name="btns_calendar_3" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" tabindex=-1>
											             <input type="text"  name="arr_dt_hhmi"     style="width:45;" value="" class="input1" maxlength="5" dataformat="hm" style="ime-mode:disabled" caption="Door Arrival Date(hour)" tabindex=60></td>
									</tr>	
								</table> 
							
								<table class="height_2"><tr><td colspan="8"></td></tr></table>
								<table width="320" class="grid2">
									<tr>
										<td class="tr2_head" width="110">Contact Name</td>
										<td class=""><input type="text" name="cntc_pson_nm" style="width:205;" value="" class="input" maxlength="50" dataformat="engupspecial" tabindex=62></td>
									</tr>
									<tr>
										<td class="tr2_head" width="80">Tel.</td>
										<td class=""><input type="text" name="cntc_phn_no" style="width:205;" value="" class="input" maxlength="20" dataformat="tel" tabindex=64></td>
									</tr>
									<tr>
										<td class="tr2_head" width="80">E-Mail</td>
										<td class=""><input type="text" name="cntc_eml" style="width:205;" value="" class="input" maxlength="200" tabindex=66></td>
									</tr>
								</table> 
							</td>
						</tr>	
					</table> 
					
				</td>
				<td width="15"></td>
				<td width="200">
					<table width="200" class="search">
						<tr class="h23">
							<td width="" colspan="3" align="center">Multi Stop</td>
						</tr>	
						<tr class="h23">
							<td width="" colspan="3" align="center">
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									    <td class="btn2" name="btn_t2cAdd" id="btn_t2cAdd">Add</td>
									    <td class="btn2_right"></td>
									</tr>
								</table>
							</td>
						</tr>	
						<tr class="h23">
							<td width="" colspan="3" align="center">
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2cDelete" id="btn_t2cDelete">Delete</td>
									<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
						</tr>
						
						<tr class="h23">
							<td width="" colspan="3" align="center">
							    <input type="text"   name="tro_sub_seq_currcnt" style="width:25;" value="" class="input2" readonly tabindex=-1>
							    &nbsp;of&nbsp;
							    <input type="text"   name="tro_sub_seq_maxcnt"  style="width:25;" value="" class="input2" readonly tabindex=-1>
							</td>
						</tr>
						
						<tr class="h23">
							<td width="98" align="right">
								<table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2cPrevious" id="btn_t2cPrevious">Previous</td>
									<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td width="4" align="center">
							</td>
							<td width="98" align="left">
								<table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2cNext" id="btn_t2cNext">Next</td>
									<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
						</tr>		
						</table> 
				</td>
			</tr>						
			</table> 
			<!-- Grid (E) -->		
			<!--  biz_3   (E) -->
			<table class="height_2"><tr><td colspan="8"></td></tr></table>
			<!--  biz_4   (S) -->
			<table width="979" class="grid2">
				<tr>
					<td class="tr2_head" width="82">Special<br>Instruction</td>
					<td class="22" width="453"><textarea name="spcl_instr_rmk" id="spcl_instr_rmk" cols="70" maxlength="4000" style="width:453;" tabindex=70 onkeyup="validateSpecialInstruction(this);" ></textarea></td>
					<td class="tr2_head" width="133">Internal Remark for<br>Non-optimum Route</td>
					<td class=""><textarea name="not_optm_rsn" id="not_optm_rsn" cols="65" style="width:288;" maxlength="4000" tabindex=70 onkeyup="validateSpecialInstruction(this);" ></textarea></td>
				</tr>
			</table> 
			<table width="979" class="search" border="0">
				<tr class="h23">
					<td width="115">TRO Confirmation </td>
					<td width="180"><input type="text" name="cfm_flg"    style="width:160" value="" class="input2" readonly tabindex=-1></td>
					<td width="70">Date/Time</td>
					<td width="160"><input type="text" name="cfm_dt"     style="width;120" value="" class="input2" readonly tabindex=-1></td>
					<td width="40">Office</td>
					<td width="160"><input type="text" name="cfm_ofc_cd" style="width;100" value="" class="input2" readonly tabindex=-1></td>
					<td width="30">User</td>
					<td class=""><input    type="text" name="cfm_usr_id" id="cfm_usr_id" style="width;100" value="" class="input2" readonly 
					                       onMouseOver="drs(document.form.cfm_usr_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1>
					             <input type="hidden" name="cfm_usr_nm" style="width;100" value="" class="input2" readonly tabindex=-1></td>
				</tr>
				<tr class="h23">
					<td width="115">S/O No.</td>
					<td width="180"><input type="text" name="so_no"     style="width:160" value="" class="input2" readonly tabindex=-1></td>
					<td width="70">Date/Time</td>
					<td width="160"><input type="text" name="so_dt"     style="width;120" value="" class="input2" readonly tabindex=-1></td>
					<td width="40">Office</td>
					<td width="160"><input type="text" name="so_ofc_cd" style="width;100" value="" class="input2" readonly tabindex=-1></td>
					<td width="30">User</td>
					<td class=""><input    type="text" name="so_usr_id" style="width;100" value="" class="input2" readonly
					                       onMouseOver="drs(document.form.so_usr_nm.value); return true;" onMouseOut="nd(); return true;" tabindex=-1>
					             <input type="hidden" name="so_usr_nm" style="width;100" value="" class="input2" readonly tabindex=-1></td>
				</tr>
			</table> 
			
		<!--  biz_4   (E) -->
			</td></tr>
		</table>
		<!--biz page (E)-->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
       	<tr><td class="btn1_bg">		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cRetrieve" id="btn_t2cRetrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cSave" id="btn_t2cSave">Save All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cSaveSeq" id="btn_t2cSaveSeq">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cConfirm" id="btn_t2cConfirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cCancelFrustrate" id="btn_t2cCancelFrustrate">Cancel / Frustrate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cTROCopy" id="btn_t2cTROCopy">TRO Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cTRONotice" id="btn_t2cTRONotice">TRO Notice</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cAddCNTR" id="btn_t2cAddCNTR">Add CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td width="30" align="center">
				   <input type="text" name="tro_copy_cnt" value="" style="width:20; height:18; font-size:8pt; text-align:center;" class="input" maxlength="2" dataformat="int" tabindex=-1>
				</td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_t2cCopyCNTR" id="btn_t2cCopyCNTR">Copy CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

<input type="hidden" name="cntr_prt_flg"     style="width:104;" value="">
<input type="hidden" name="t1_doc_flg"       style="width:104;" value="">
<input type="hidden" name="cstms_clr_no"     style="width:104;" value="">
<input type="hidden" name="all_in_rt_cd"     style="width:104;" value="">
<input type="hidden" name="curr_cd"          style="width:104;" value="">
<input type="hidden" name="trns_rev_amt"     style="width:104;" value="">
<input type="hidden" name="cxl_flg"          style="width:104;" value="">
<input type="hidden" name="vat_flg"          style="width:104;" value="">
<input type="hidden" name="tro_sub_seq"      style="width:25;"  value="">	
<input type="hidden" name="cntr_tpsz_cd_old" style="width:25;"  value="">
<input type="hidden" name="hlg_tp_cd_old"    style="width:25;"  value="">
<input type="hidden" name="new_row_flg"      style="width:104;" value="">
<input type="hidden" name="non_trns_rev_amt" style="width:104;" value="">	
<input type="hidden" name="add_rev_amt" 	 style="width:104;" value="">
<input type="hidden" name="add_rev_chg_cd" 	 style="width:104;" value="">
<input type="hidden" name="add_rev_amt2" 	 style="width:104;" value="">
<input type="hidden" name="add_rev_chg_cd2"  style="width:104;" value="">
<input type="hidden" name="add_rev_amt3" 	 style="width:104;" value="">
<input type="hidden" name="add_rev_chg_cd3"  style="width:104;" value="">
<input type="hidden" name="add_rev_rmk" 	 style="width:104;" value="">
<input type="hidden" name="org_trns_mod_cd"  style="width:104;" value="">
<input type="hidden" name="dest_trns_mod_cd" style="width:104;" value="">
<input type="hidden" name="arb_rev_flg" style="width:104;" value="N">
<!-- hidden grid : Start ---------------------->
<table id="mainTable" width="960">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2csheet2');</script>
		</td>
	</tr>
</table>
<table id="mainTable" width="1">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2csheet3');</script>
		</td>
	</tr>
</table>
<table id="mainTable" width="1">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2csheet4');</script>
		</td>
	</tr>
</table>
<table id="mainTable" width="1">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('t2cmsgsheet1');</script>
		</td>
	</tr>
</table>
<!-- hidden grid : End ------------------------>	

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>

<!--20090805 도움말용------------->
<DIV ID='overDiv' STYLE='position:absolute; z-index:90; width:350; visibility:hidden' tabindex=-1>
</DIV>
<!------------------------------->

<script language="javascript">
	//도움말 시작---------------------------->
	  var x = 0;
	  var y = 0;
	  var snow = 0;
	  var sw = 0;
	  var cnt = 0;
	  var dir = 1;
	  var offsetx = -80; //3;
	  var offsety = 10; //-20;
	  var width  = 40;
	  var height = 70;
	
	  over = overDiv.style;
	  document.onmousemove = mouseMove;
	
	  function drs(text, title) { dts(1,text); }
	
	  function nd() {
	    if ( cnt >= 1 ) { sw = 0 };
	    if ( sw == 0 ) { snow = 0; hideObject(over); }
	    else { cnt++; }
	  }
	
	  function dts(d,text) {
		if (text=="")
		{
	        return false;
		}
	    txt = "<TABLE WIDTH=200 STYLE=\"border:1 #e9e9e9 solid\" CELLPADDING=5 CELLSPACING=0 BORDER=0><TR><TD BGCOLOR=#ffffff><font STYLE=\"font-size:11px;color:#333399\">"+text+"</font></TD></TR></TABLE>"; 
	    layerWrite(txt);
	    dir = d;
	    disp();
	  }
	
	  function disp() {
	    if (snow == 0) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	      showObject(over);
	      snow = 1;
	    }
	  }
	
	  function mouseMove(e) {
	    x=event.x + document.body.scrollLeft+10
	    y=event.y + document.body.scrollTop
	    if (x+width-document.body.scrollLeft > document.body.clientWidth)  x=x-width-25;
	    if (y+height-document.body.scrollTop > document.body.clientHeight) y=y-height;
	
	    if (snow) {
	      if (dir == 2) { moveTo(over,x+offsetx-(width/2),y+offsety); } // Center
	      if (dir == 1) { moveTo(over,x+offsetx,y+offsety); }           // Right
	      if (dir == 0) { moveTo(over,x-offsetx-width,y+offsety); }     // Left
	    }
	  }
	
	  function cClick() { hideObject(over); sw=0; }
	  function layerWrite(txt) { document.all["overDiv"].innerHTML = txt }
	  function showObject(obj) { obj.visibility = "visible" }
	  function hideObject(obj) { obj.visibility = "hidden" }
	  function moveTo(obj,xL,yL) { obj.left = xL; obj.top = yL; }
	//<-------------------------------도움말 끝
</script>		

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
          if(event != null) 
          { 
              String currTroSeq    = (event.getCurrTroSeq()   ==null)?"":event.getCurrTroSeq();
              String currTroSubSeq = (event.getCurrTroSubSeq()==null)?"":event.getCurrTroSubSeq();
        %>
              eval("curr_tro_seq").value     = "<%=currTroSeq%>";
              eval("curr_tro_sub_seq").value = "<%=currTroSubSeq%>";
        <%   
          }
        %>
      }
-->
</SCRIPT>