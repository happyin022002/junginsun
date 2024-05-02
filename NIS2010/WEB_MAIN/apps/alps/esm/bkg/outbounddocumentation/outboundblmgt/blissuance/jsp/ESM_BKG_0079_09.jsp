
<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0649.jsp
 *@FileTitle : Cancel Issue Release
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.07.20 이진서
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2012.10.18 이재위 [CHM-201220612] [BKG] BL Issue화면- shipper의 A/R고객정보 팝업 연결
 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
 2012.11.16 김보배 [CHM-201221290] [BKG] B/L Issue 화면에 B/L HOLD 기능 추가 & B/L Status Report 기능 보완 (NSC #2 & #3)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg007909Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");
	EsmBkg007909Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String isInquiry = "N";	
	
	String sXml = null;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg007909Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<form name="frm">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>"> 
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>"> 
<!-- 개발자 작업	--> 
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'> 
<input type="hidden" name="frm_t11sheet1_doc_proc_modyflg">
<input type="hidden" name="frm_t11sheet1_doc_proc_type"> 
<input type="hidden" name="frm_t11sheet1_doc_proc_seq"> 
<input type="hidden" name="frm_t11sheet1_doc_request_flag"> 
<input type="hidden" name="frm_t11sheet1_auth_flag"> 
<input type="hidden" name="frm_t11sheet1_internet_auth">
<input type="hidden" name="frm_t11sheet1_tpb_indicator"> 
<input type="hidden" name="frm_t11sheet1_tpb_status">
<input type="hidden" name="frm_t11sheet1_black_customer_flag"> 
<input type="hidden" name="frm_t11sheet1_flg_rate"> 
<input type="hidden" name="frm_t11sheet1_flg_md"> 
<input type="hidden" name="frm_t11sheet1_flg_ppd">
<input type="hidden" name="frm_t11sheet1_trd_flg_ppd"> 
<input type="hidden" name="frm_t11sheet1_flg_to_order"> 
<input type="hidden" name="frm_t11sheet1_flg_do"> 
<input type="hidden" name="frm_t11sheet1_cgo_rcv_dt">
<input type="hidden" name="frm_t11sheet1_pod_nod_cd">
<input type="hidden" name="frm_t11sheet1_del_nod_cd">
<input type="hidden" name="frm_t11sheet1_wbl_eml">
<input type="hidden" name="frm_t11sheet1_wbl_rt_tp_cd">
<input type="hidden" name="frm_t11sheet1_img_flg">
<input type="hidden" name="old_pod_name">
<input type="hidden" name="old_del_name">
<input type="hidden" name="vessel_direction"> 
<input type="hidden" name="pre_carriage_by"> 
<input type='hidden' name="oaXmlData"> 
<!-- TPB Status --> 
<input type='hidden' name='tpb_status'> 
<input type='hidden' name='chg_ready'> 
<input type='hidden' name='mk_ready'> 
<input type='hidden' name='chg_ppd_ind'> 
<input type='hidden' name='chg_ppd_third_ind'> 
<input type='hidden' name='cust_cnt'> 
<input type='hidden' name='cntr_cnt'> 
<input type='hidden' name='rate_cnt'> 
<input type='hidden' name='mnd_cnt'> 
<input type="hidden" name="setupfocoblflag" value="N">
<input type="hidden" name="frm_t11sheet1_cust_to_ord_flg"> 
<input type='hidden' name='buttonType'> 
<input type="hidden" name="caflag" value="">
<input type="hidden" name="bdrflag" value="">
<input type="hidden" name="ca_exist_flg" value="">
<input type="hidden" class="noinput" name="modify_flag" value="N">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="lbpFlg" value="N">
<input type="hidden" name="old_bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'>

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPrintPaperSize">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_isBatch" value="N">
<!--biz page (S)-->

<input type="hidden" name="hrdCdgId" value="BL_ISS_VAL">
<input type="hidden" name="attrCtnt1" value="">
<input type="hidden" name="attrCtnt2" value="">
<input type="hidden" name="attrCtnt3" value="">

<table class="search" id="mainTable" style="width: 998;">
	<tr>
		<td class="bg"><!--  biz-1 (S) -->
		<table class="search" border="0" style="width: 979;">
			<tr class="h23">
				<td width="80">Booking No.</td>
				<td width="160">
				
					<input type='text' style='width: 110;' class='input1' dataformat="uppernum"  maxlength="13" name='frm_t11sheet1_bkg_no' value='<%=JSPUtil.getParameter(request, "bkg_no")%>'>
					<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					<!-- 
					<img name="pop_bkg_no" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
					<div id="span_bkg_no" name="span_bkg_no" style="position:absolute;z-index:999;display:none;"></div>
					 -->
				</td>
				<td width="55">B/L No.</td>
				<td width="240">
				
					<input type='text' style='width: 110;' dataformat="uppernum"  maxlength="12"  name='frm_t11sheet1_bl_no' value='' class='input1'> <img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_OrgBlPop">
					<!-- 
					<img name="pop_bl_no" class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
					<div id="span_bl_no" name=""span_bl_no"" style="position:absolute;z-index:999;display:none;"></div>
					 -->
				</td>
				<td width="40">T/VVD</td>
				<td width="115"><input type="text" style="width: 80;" name="frm_t11sheet1_tvvd" value=""  class="input2" readonly></td>
				<td width="40">Status</td>
				<td width="60"><input type="text" style="width: 20;" name="frm_t11sheet1_bkg_sts" value=""  class="input2" readonly></td>
				<td width="">BDR&nbsp;
				
				<input type="checkbox" name="check_bdr" value="" class="trans" disabled>
					<input type="hidden" name="frm_t11sheet1_bdr">
					
				</td>
			</tr>
		</table>
		<table class="search" border="0" style="width: 979;">
			<tr class="h23">
				<td width="80">SHPR Name</td>
				<td width="160"><input type="text" style="width: 111;" name="frm_t11sheet1_shpr_name" value=""  class="input" readonly>
				<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="pop_shpr"></td>
				<td width="55">Address</td>
				<td width="240"><input type="text" style="width: 220;" name="frm_t11sheet1_shpr_address" value="" class="input" readonly></td>
				<td width="80">F/FWD Name</td>
				<td><input type="text" style="width: 300;" name ='f_fwd_name' value="" class="input" readonly></td>
				<input type='hidden' name ='frm_t11sheet1_shpr_cnt_cd'>
				<input type='hidden' name ='frm_t11sheet1_shpr_seq'>
				<input type='hidden' name ='frm_t11sheet1_f_fwd_name'>
				<input type='hidden' name ='frm_t11sheet1_f_fwd_address'>
			</tr>
		</table>

		<!--  biz-1 (E) -->

		<table class="line_bluedot">
			<tr>
				<td></td>
			</tr>
		</table>


		<!--  biz-3 (S) -->
		<table class="search" border="0" style="width: 979;">
			<tr>
				<td width="480" align="" valign="top">
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">VESSEL</td>
					</tr>
				</table>
				<!--  biz-2 (S) -->
				<table class="search" border="0" style="width: 480;">
					<tr class="h23">
						<td width="160" align="">Vessel Voyage Direction</td>
						<td width="" style="padding-left: 2">
							<script language="javascript">ComComboObject('select_vessel_direction', 1, 317, 2, 0, 1, false);</script>
							<input type="hidden" name="frm_t11sheet1_vessel_direction">
						</td>
					</tr>
					<tr class="h23">
						<td width="" align="">Pre-Carriage By</td>
						<td align="" style="padding-left: 2">
							<script language="javascript">ComComboObject('select_pre_carriage_by', 1, 317, 2, 0, 1, true);</script>
							<input type="hidden" name="frm_t11sheet1_pre_carriage_by">
						</td>
					</tr>

				</table>

				<!--  biz-3_1 (S) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">ROUTE</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 480;">
					<tr class="h23">
						<td width="30">POR</td>
						<td width="60"><input type="text" style="width: 58;" dataformat="uppernum"  name="frm_t11sheet1_por_code" value="" class="input2" readonly></td>
						<td width=""><input type="text" style="width: 370;" dataformat="etc" name="frm_t11sheet1_por_name" value="" class="input" maxlength="25"></td>
					</tr>
					<tr class="h23">
						<td width="">POL</td>
						
						<td width=""><input type="text" style="width: 58;" dataformat="uppernum" name="frm_t11sheet1_pol_code" value="" class="input" ></td>						
						<td width=""><input type="text" style="width: 347;"dataformat="etc" name="frm_t11sheet1_pol_name" value="" class="input" maxlength="25">
						<img class="cursor" name="pop_pol" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
						
					</tr>
					<tr class="h23">
						<td width="">POD</td>
						
						<td width=""><input type="text" style="width: 58;" dataformat="uppernum" name="frm_t11sheet1_pod_code" value="" class="input"></td>
						<td width=""><input type="text" style="width: 347;" dataformat="etc" name="frm_t11sheet1_pod_name" value="" class="input" maxlength="25">
						<img class="cursor" name="pop_pod" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
						
					</tr>
					<tr class="h23">
						<td width="">DEL</td>
						
						<td width=""><input type="text" style="width: 58;" dataformat="uppernum" name="frm_t11sheet1_del_code" value="" class="input2" readonly></td>
						<td width=""><input type="text" style="width: 370;" dataformat="etc" name="frm_t11sheet1_del_name" value="" class="input" maxlength="25"></td>
						
					</tr>
					<tr class="h23">
						<td width="" colspan="2">Move Type</td>
						
						<td width=""><input type="text" style="width: 370;" name="frm_t11sheet1_move_type" value="" class="input" maxlength="25"></td>
						
					</tr>
					<tr class="h23">
						<td width="" colspan="2">Final Dest.</td>
						
						<td width=""><input type="text" style="width: 370;" name="frm_t11sheet1_final_dest" value="" class="input" maxlength="25"></td>
						
					</tr>
					 <tr class="h23"><td style="height:77"></td></tr>
				</table>
				
				<!--  biz-3_1 (E) --> <!--  biz-3_1_1 (S) -->
				<table class="height_5" >
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">FREIGHT RECEIVE</td>
					</tr>
				</table>
				<table border="0" style="width: 480;">
					<tr>
						<td>
						<table border="0" style="width: 355; background-color: white;" class="grid2">
							<tr class="tr2_head">
								<td width="65">Term</td>
								<td width="40">RCV</td>
								<td width="60">Office</td>
								<td width="90">By</td>
								<td width="">Date</td>

							</tr>
							<tr>
								<td width="" class="tr2_head2">PPD (Org.)</td>
								<td width="" class="input">
								
								<script language="javascript">ComComboObject('ppd_confirm', 2, 40, 1)</script>
									<input type="hidden" name="frm_t11sheet1_ppd_confirm">
								
								</td>
								<td width="" class="input"><input type="text" style="width: 55;" name="frm_t11sheet1_ppd_rcv_user_office" value=""   class="noinput" dataformat="uppernum" maxlength="6" onChange="javascript:fnOfcCdCheck(this);"></td>
								<td width="" class="input2"><input type="text" style="width: 80;" name="frm_t11sheet1_ppd_rcv_user_id" value=""   class="noinput2" readonly></td>
								<td width="" class="input2"><input type="text" style="width: 72;" name="frm_t11sheet1_ppd_rcv_dt" value=""   class="noinput2" readonly></td>


							</tr>
							<tr>
								<td width="" class="tr2_head2">PPD (3rd)</td>
								<td width="" class="input">
								
								<script language="javascript">ComComboObject('trd_ppd_confirm', 2, 40, 1)</script>
									<input type="hidden" name="frm_t11sheet1_trd_ppd_confirm">
								
								</td>
								<td width="" class="input"><input type="text" style="width: 55;" name="frm_t11sheet1_trd_ppd_rcv_user_office" value="" class="noinput" dataformat="uppernum" maxlength="6" onChange="javascript:fnOfcCdCheck(this);"></td>
								<td width="" class="input2"><input type="text" style="width: 80;" name="frm_t11sheet1_trd_ppd_rcv_user_id" value="" class="noinput2" readonly></td>
								<td width="" class="input2"><input type="text" style="width: 72;" name="frm_t11sheet1_trd_ppd_rcv_dt" value="" class="noinput2" readonly></td>

							</tr>
							<tr>
								<td width="" class="tr2_head2">CCT (Dest.)</td>
								<td width="" class="input">
								
								<script language="javascript">ComComboObject('cct_confirm', 2, 40, 1)</script>
									<input type="hidden" name="frm_t11sheet1_cct_confirm">								
									
								</td>
								<td width="" class="input"><input type="text" style="width: 65;" name="frm_t11sheet1_cct_rcv_user_office" value="" class="noinput" dataformat="uppernum" maxlength="6" onChange="javascript:fnOfcCdCheck(this);"></td>
								<td width="" class="input2"><input type="text" style="width: 80;" name="frm_t11sheet1_cct_rcv_user_id" value="" class="noinput2" readonly></td>
								<td width="" class="input2"><input type="text" style="width: 72;" name="frm_t11sheet1_cct_rcv_dt" value="" class="noinput2" readonly></td>

							</tr>
							<tr>
								<td width="" class="tr2_head2">CCT (3rd)</td>
								<td width="" class="input">
								
								<script language="javascript">ComComboObject('trd_cct_confirm', 2, 40, 1)</script>
									<input type="hidden" name="frm_t11sheet1_trd_cct_confirm">								
								
								</td>
								<td width="" class="input"><input type="text" style="width: 65;" name="frm_t11sheet1_trd_cct_rcv_user_office" value="" class="noinput" dataformat="uppernum" maxlength="6" onChange="javascript:fnOfcCdCheck(this);"></td>
								<td width="" class="input2"><input type="text" style="width: 80;" name="frm_t11sheet1_trd_cct_rcv_user_id" value="" class="noinput2" readonly></td>
								<td width="" class="input2"><input type="text" style="width: 72;" name="frm_t11sheet1_trd_cct_rcv_dt" value="" class="noinput2" readonly></td>

							</tr>
						</table>

						</td>
						<td width="10"></td>
						<td>
						<table border="0" style="width: 115; background-color: white; " class="grid2">
							<tr class="tr2_head">
								<td width="" colspan="2">ERP Status</td>
							</tr>
							<tr style="background-color: white; color:#313131; text-align:center; font-weight:bold;">
								<td width="" class="input" style="border: white 0px; border-left: #A6C3CB 1px solid;"><input type="text" style="width: 55;" name="frm_t11sheet1_ppd_office" value="" class="noinput" readonly></td>
								<td width="" class="input" style="border: white 0px; border-right: #A6C3CB 1px solid;"><input type="text" style="width: 20;" name="frm_t11sheet1_ppd_rcv" value="" class="noinput" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="pop_ppd" width="19" height="20" border="0" align="absmiddle"></td>
			
							</tr>
							<tr style="background-color: white; color:#313131; text-align:center; font-weight:bold;">
								<td width="" class="input" style="border: white 0px; border-left: #A6C3CB 1px solid;"><input type="text" style="width: 55;" name="frm_t11sheet1_trd_ppd_office" value=""  class="noinput" readonly></td>
								<td width="" class="input" style="border: white 0px; border-right: #A6C3CB 1px solid;"><input type="text" style="width: 20;" name="frm_t11sheet1_trd_ppd_rcv" value=""  class="noinput" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="pop_trd_ppd" width="19" height="20" border="0" align="absmiddle"></td>

							</tr>
							<tr style="background-color: white; color:#313131; text-align:center; font-weight:bold;">
								<td width="" class="input" style="border: white 0px; border-left: #A6C3CB 1px solid;"><input type="text" style="width: 55;" name="frm_t11sheet1_cct_office" value=""  class="noinput" readonly></td>
								<td width="" class="input" style="border: white 0px; border-right: #A6C3CB 1px solid;"><input type="text" style="width: 20;" name="frm_t11sheet1_cct_rcv" value=""  class="noinput" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="pop_cct" width="19" height="20" border="0" align="absmiddle"></td>

							</tr>
							<tr style="background-color: white; color:#313131; text-align:center; font-weight:bold;">
								<td width="" class="input" style="border: white 0px; border-left: #A6C3CB 1px solid; border-bottom: #A6C3CB 1px solid;"><input type="text" style="width: 55;" name="frm_t11sheet1_trd_cct_office" value=""  class="noinput" readonly></td>
								<td width="" class="input" style="border: white 0px; border-right: #A6C3CB 1px solid; border-bottom: #A6C3CB 1px solid;"><input type="text" style="width: 20;" name="frm_t11sheet1_trd_cct_rcv" value=""  class="noinput" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="pop_trd_cct" width="19" height="20" border="0" align="absmiddle"></td>

							</tr>
						</table>
						</td>
						
					</tr>
					<tr>
						<td colspan="3" style="padding:4, 0, 0, 2">
						<table border="0" style="width: 480;">
							<tr>
								<td width="170">
								<b>3rd Party Billing&nbsp;</b>
								<img src="img/btng_icon_g.gif" width="13" height="13" alt="" border="0" align="absmiddle" id="tpb_icon">
								<input type="text" class="input2" style="width: 20; text-align: center" name='tpb_cd' id='tpb_cd' value="" readonly>
								<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="pop_tpb">
								</td>
								<td>
									<table width="160" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_t103rdBLReq" id=btn_t103rdBLReq>3rd Party B/L Request</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td width="142">
								<b>B/L Certificate&nbsp;</b>
								<img src="img/btng_icon_g.gif" width="13" height="13" alt="" border="0" align="absmiddle" id="bl_certi_icon">
								<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="pop_bl_certi">
								</td>
							</tr>
							<tr>
							</tr>
						</table>
				</td>
				</tr>

				</table>
				<!--  biz-3_1_1 (E) --></td>
				<td width="19"></td>
				<td width="480" align="" valign="top"><!--  biz-3_2 (S) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">B/L DATA COMPLETE</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 480;">
					<tr class="h23">
						<td width="40">
							<input type="checkbox" name="bl_ready_checkbox" value="Y" class="trans" onclick='fnBlReadyCheckbox(this)'>&nbsp;At</td>
							<input type="hidden" name="frm_t11sheet1_bl_ready_checkbox"/>
						<td width="55">
							<input type="text" style="width: 50" name="frm_t11sheet1_bl_ready_office" value="" dataformat="uppernum" maxlength="8" class="input"></td>
						<td width="15">By</td>
						<td width="130">
							<input type="text" style="width: 115" name="frm_t11sheet1_bl_ready_by" value="" dataformat="etc" maxlength="8" class="input"></td>
						<td width="25">Date</td>
						<td width="126">
							<input type="text" style="width: 80" name="frm_t11sheet1_bl_ready_date" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" class="input">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="pop_bl_ready_date"></td>
						<td width="25">Type</td>
						<td width="" style="padding-left: 2">
						
							<script language="javascript">ComComboObject('bl_ready_type', 2, 35, 1)</script>
							<input type="hidden" name="frm_t11sheet1_bl_ready_type"/>
						
						</td>
					</tr>
				</table>


				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">B/L CONFIRM BY SHIPPER</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 480;">
					<tr class="h23">
						<td width="40">
							<input type="checkbox" name="bl_proofbyshipper_checkbox" value="Y" class="trans" onclick='fnBlProofbyshipperCheckbox(this)'>&nbsp;At</td>
							<input type="hidden" name="frm_t11sheet1_bl_proofbyshipper_checkbox"/>
							
						<td width="55"><input type="text" style="width: 50" name="frm_t11sheet1_bl_proofbyshipper_office" value="" dataformat="uppernum" maxlength="8" class="input"></td>
						
						<td width="15">By</td>
						<td width="130">
							<input type="text" style="width: 115" name="frm_t11sheet1_bl_proofbyshipper_by" value=""  dataformat="etc" maxlength="8" class="input"></td>
						<td width="25">Date</td>
						<td width="117">
							<input type="text" style="width: 80" name="frm_t11sheet1_bl_proofbyshipper_date" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" class="input">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="pop_bl_proofbyshipper_date">
						</td>
						<td>
						<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t11Doc_Requirement" id="btn_t11Doc_Requirement">Doc Req.</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
					</tr>

				</table>


				<!--  biz-3_2 (E) --> <!--  biz-3_3 (S) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">ON BOARD</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 480;">
					<tr class="h23">
						<td width="40">Type</td>
						<td width="50">
							<script language="javascript">ComComboObject('on_board_type', 2, 35, 1)</script>
							<input type="hidden" name="frm_t11sheet1_on_board_type">
						</td>
						<td width="40">
							<input type="checkbox" name="date_set_checkbox" value="Y" class="trans" onclick='fnDateSetCheckbox(this)'>&nbsp;Date</td>
							<input type="hidden" name="frm_t11sheet1_date_set_checkbox"/>
						<td width="114">
							<input type="text" style="width: 75"  name="frm_t11sheet1_on_board_date" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" class="input">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="pop_on_board_date">
						</td>
						<td width="26">ETD</td>
						<td width="80"><input type="text" style="width: 75" name="frm_t11sheet1_pol_etd_dt" value="" class="input2" readonly></td>
						<td><!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_t11TS_Route">T/S Route</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

									</tr>
								</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) --></td>

					</tr>
				</table>
				<!--  biz-3_3 (E) --> <!--  biz-4 (S) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">B/L ISSUE</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 480;">
					<tr class="h23">
						<td width="">
						<table class="search" border="0">
							<tr class="h23">
								<td width="55">B/L Type</td>
								<td width="25" onMouseOver='fngBkgToolTipView("frm_t11sheet1_bl_issuebl_type");' onMouseMove='fngBkgToolTipMove();' onMouseOut='fngBkgToolTipHide();'>
									<input type="text" style="width:20;cursor: hand;" name="frm_t11sheet1_bl_issuebl_type" value="" class="input2" readonly>
								</td>
								<td width="10">No.</td>
								<td width="25"><input type="text" style="width: 20" name="frm_t11sheet1_bl_issue_no" value="" dataformat="int" maxlength="1" style="ime-mode:disabled" class="input"></td>
								<td width="75">B/L Hold<input type="checkbox" name="bl_hld_flg" value="Y" class="trans" onclick='fnBlHldFlgCheckbox(this)'>
											   <input type="hidden" name="frm_t11sheet1_bl_hld_flg"/></td>
								<td width="60" class="input">
									<script language="javascript">ComComboObject('bl_hld_rsn_cd', 2, 50, 1)</script>
									<input type="hidden" name="frm_t11sheet1_bl_hld_rsn_cd"/>
								</td>
								<td width="20">Date</td>
								<td width="80">
								<input type="text" style="width: 72" name="frm_t11sheet1_bl_hld_dt" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" class="input2" readonly>
								</td>
								<td width="10">By</td>
								<td width="80">
								<input type="text" style="width:75" name="frm_t11sheet1_bl_hld_usr_id" style="ime-mode:disabled" value="" class="input2" readonly>
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width: 480;">
							<tr class="h23">
								<td width="110"><input type="checkbox" name="IssuerSet_checkbox" value="Y" class="trans" onclick='fnIssuerSetCheckbox(this)' class="trans">
								At&nbsp;
								<input type="text" style="width: 55" name="frm_t11sheet1_bl_issue_at" dataformat="uppernum"  maxlength="8" value="" class="input">
								</td>
								<td width="120">By&nbsp;&nbsp;&nbsp;<input type="text" style="width: 80" name="frm_t11sheet1_bl_issue_by" dataformat="etc"  maxlength="8" value="" class="input"></td>
								
								<td width="30">Date</td>
								<td width="110">
									<input type="text" style="width:75" name="frm_t11sheet1_bl_issue_date" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" class="input">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="pop_bl_issue_date">
								</td>
			
								<td width=""><!--  Button_Sub (S) -->
								<table width="95" class="button">
									<tr>
										<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_t11Issue">Issue</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
												</td>

											</tr>
										</table>
										</td>
									</tr>
								</table>
								<!-- Button_Sub (E) --></td>
							</tr>
						</table>
						<table class="search" border="0" style="width: 480;">
							<tr class="h23">
								<td width="90">Issued&nbsp;&nbsp;<input type="text" style="width: 30" name="frm_t11sheet1_issued" id="frm_t11sheet1_issued" value="" class="input2" readonly></td>
								<td width="150">O.B/L Printed&nbsp;&nbsp;<input type="text" style="width: 30;" name="frm_t11sheet1_obl_prn_flg" value="" class="input2" readonly></td>
								<td width="">Released&nbsp;&nbsp;<input type="text" style="width: 30;" name="frm_t11sheet1_released" id="frm_t11sheet1_released" value="" class="input2" readonly></td>
								<td width="200" colspan="7" align="right" style="color: red"><span id="web_print_approved"/></td>
							</tr>
						</table>
						<table class="search" border="0" style="width: 480;">
							<tr class="h23">
								<td width="100%">OB/L Serial No.&nbsp;&nbsp;<script language="javascript">ComComboObject('obl_inter_ser_no',3, 200, 1);</script></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--  biz-4 (E) --> <!--  biz-5 (S) -->

				<table class="search" border="0" style="width: 480;">
					<tr class="h23">
						<td valign="top">
						<table class="height_5">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">O.B/L RECEIVE</td>
							</tr>
						</table>
						<table class="search_sm" border="0" style="width: 235;">
							<tr class="h23">
								<td width="31">Type</td>
								<td width="35" onMouseOver='fngBkgToolTipView("frm_t11sheet1_o_blreceive_type");' onMouseMove='fngBkgToolTipMove();' onMouseOut='fngBkgToolTipHide();'>
									<input type="text" style="width: 20" style="width:20;cursor: hand;" name="frm_t11sheet1_o_blreceive_type" value="" class="input2" readonly></td>
								<td width="15">No</td>
								<td width="35"><input type="text" style="width: 20" name="frm_t11sheet1_o_blreceive_no" value="" class="input2" readonly></td>
								<td width="32">Date</td>
								<td width=""><input type="text" style="width: 70" name="frm_t11sheet1_o_blreceive_date" value="" class="input2"  readonly></td>
							</tr>
							<tr class="h23">
								<td width="" colspan="4">At&nbsp;<input type="text" style="width: 85" name="frm_t11sheet1_o_blreceive_at" value="" class="input2" readonly></td>
								<td width="" colspan="2">By&nbsp;<input type="text" style="width: 85" name="frm_t11sheet1_o_blreceive_by" value="" class="input2" readonly></td>
							</tr>
							<tr class="h23">
								<td width="" colspan="6">Surrender&nbsp;<input type="text" style="width: 38" name="frm_t11sheet1_surrender" value="" class="input2" readonly></td>
							</tr>
						</table>
						</td>
						<td width="10"></td>
						<td valign="top">
						<table class="height_5">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">D/O ISSUE</td>
							</tr>
						</table>

						<table class="search_sm" border="0" style="width: 235;">
							<tr class="h23">
								<td width="15">No</td>
								<td width="105"><input type="text" style="width: 95" name="frm_t11sheet1_do_issue_no" value="" class="input2" readonly></td>
								<td width="30">Date</td>
								<td width=""><input type="text" style="width: 100%" name="frm_t11sheet1_do_issue_date" value="" class="input2" readonly></td>
							</tr>
							<tr class="h23">
								<td width="15">At</td>
								<td width="105"><input type="text" style="width: 95" name="frm_t11sheet1_do_issue_at" value="" class="input2" readonly></td>
								<td width="30">By</td>
								<td width=""><input type="text" style="width: 100%" name="frm_t11sheet1_do_issue_by" value="" class="input2" readonly></td>
							</tr>
							<tr class="h23">
								<td>&nbsp;</td>
							</tr>
						</table>
						
						
						</td>
					</tr>
				</table>
				
				<table class="height_5">
							<tr>
								<td></td>
							</tr>
				</table>
				<table class="search_sm" border="0" style="width: 480;">
					<tr class="h23">
						<td>
						<table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_t11sheet1_obl_iss_rmk" id="btn_t11sheet1_obl_iss_rmk">Remark(s)</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="385"><textarea name="frm_t11sheet1_obl_iss_rmk" onKeyDown="fncTextareaMaxLine(this.value)" style="width: 99%; height: 40"></textarea></td>
					</tr>

				</table>
				<!--  biz-5 (E) --></td>
			</tr>

		</table>
		<!--  biz-3 (E) -->
		<table class="height_10">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>

	</td>
	</tr>
</table>
<!-- grid box (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 0;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11Retrieve" id="btn_t11Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11New" id="btn_t11New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11Save" id="btn_t11Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11OBLRelease">O.B/L Release</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td>
							<div id="DIV_btn_t11InternetAUTH" style="display:block;">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_t11InternetAUTH">Internet Auth</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
							</div>
							<div id="DIV_btn_t11CancelAUTH" style="display:none;">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_t11CancelAUTH">Cancel Auth</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
							</div>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11SWBRelease">SWB Release</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11CancelRelease" id="btn_t11CancelRelease">Issue/Release Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>


						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11OBLSurrender">O.B/L Surrender</td>
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
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 2;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11BLPrint">B/L Print</a></td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11SWBEmail">SWB E-mail</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_t11ISSNOTE" id="btn_t11ISSNOTE">B/L Issue Note</td>
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


<div id="helpbox" style="border-width: 0px; border-style: none; width: 0px; height: 0px; position: absolute; left: 0px; top: 0px; z-index: 1;"></div>
<div style="display: none;"><script language="javascript">ComSheetObject('t11sheet1');</script></div>
<div style="display: none;"><script language="javascript">ComSheetObject('otsRcvInfo');</script></div>
<div style="display: none;"><script language="javascript">ComSheetObject('otsRcvPop');</script></div>
<div style="display: none;"><script language="javascript">ComSheetObject('lbpInfo');</script></div>
<!-- 개발자 작업  끝 -->
<input type="hidden" name="org_bl_no" >
<div id="orgBlNo" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>

</form>
</body>
</html>