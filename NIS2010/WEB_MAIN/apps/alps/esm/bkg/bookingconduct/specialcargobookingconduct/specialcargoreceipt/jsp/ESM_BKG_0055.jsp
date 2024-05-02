<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0055.jsp
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2012.10.15 조정민 [CHM-201220509] [Special Cargo Application] Email기능 추가 - RF,AK (DG기존재)
 2013.12.05 신규정 [CHM-201327524] AK APPLICATION 화면에 E-MAIL 1, 2 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%> 
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
 


<%
	EsmBkg0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	String bkgNo = "";
	String screenName = "";
	
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0055Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
				
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Awakward Cargo Application</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_awk_cgo_seq" value="">
<input type="hidden" name="temp_cntr_no" value="">
<input type="hidden" name="cntr_tpsz_cd" value="">
<input type="hidden" name="vessel_nm">

<input type="hidden" name="temp_grs_wgt" value="">
<input type="hidden" name="temp_net_wgt" value="">
<input type="hidden" name="title_id" value="awk">
<input type="hidden" name="button" value="N">

<input type="hidden" name="com_content" value="">
<!-- 개발자 작업	-->

<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	

		<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">BKG No.</td>
					<td width="130"><input name="bkg_no" type="text" style="width:96;" class="input1" value="<%=bkgNo%>" maxlength="13">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="170" colspan="6">B/L No.&nbsp;<input name="bl_no" type="text" style="width:90;" class="input" value="" maxlength="12"></td> 
					<td  valign="top">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="">Requested by/Date</td>
							<td width=""><input name="rqst_usr_id" type="text" style="width:97;" class="input2" value="" readOnly></td>
							<td width=""><input name="rqst_dt" type="text" style="width:115;" class="input2" value=""  readOnly></td>
							<td width="" class="sm"><input name="rqst_gdt" type="text" style="width:115;" class="input2" value="" readonly> (GMT)</td>
							<td width=""align="right" colspan="4">Approval &nbsp;<input name="auth_cd" type="text" style="width:20;" class="input2_1" value="" readOnly>&nbsp;<img name="btn_approval" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				
						
						</table>
						
					</td>
				</tr></table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">T/VVD</td>
					<td width="130"><input name="tvvd" type="text" style="width:90;"  class="input2" value="" readOnly></td>
					<td width="27">POL</td>
					<td width="80"><input name="pol_cd" type="text" style="width:45;" class="input2" value="" readOnly>&nbsp;<input name="pol_nod_cd" type="text" style="width:25;" class="input2" value="" readOnly></td>
					<td width="72" align="left"><table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_pol_cd">Info.</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
					<td width="27">POD</td>
					<td width="80"><input name="pod_cd" type="text" style="width:45;" class="input2" value="" readOnly>&nbsp;<input name="pod_nod_cd" type="text" style="width:25;" class="input2" value="" readOnly></td>
					<td width="" align="left"><table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_pod_cd">Info.</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>			
								
				</tr>
				</table>
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				
			<!--  biz_3  (S) -->
						<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="165">Application Total Package</td>
							<td width="115"><input name="package_sum" type="text" style="width:60;text-align:right;" class="input2" value="" readOnly>&nbsp;<input name="pck_tp_cd"type="text" style="width:25;" class="input2" value="" readOnly></td>
							<td width="157">Application Total Weight</td>
							<td width=""><input name="weight_sum" type="text" style="width:90;text-align:right;" class="input2" value="" readOnly>&nbsp;<input name="wgt_ut_cd" type="text" style="width:38;" class="input2" value="" readOnly></td>
							</tr>
						</table>
						<!--  biz_3   (E) -->
		<!--biz page-1 (E)-->
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
	
	<table class="search" border="0" style="width:979;"> 
	<tr class="h23">
	<td width="290">
		<!-- biz 2,3 - frame (S) -->
		<table class="search"> 
       		<tr><td width="280" valign="top" style="padding-right:10">
	

			<table class="search_sm2"> 
       			<tr><td width="280" valign="top">
				<!-- biz 2 - frame (S) -->
									
						<!-- biz_2-1  (S) -->
					<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
						<!-- biz_2-1 (E) -->
					<table class="height_8"><tr><td colspan="8"></td></tr></table>	
						
						
						<!-- biz_2-2  (S) -->
					<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					<!--Grid (S)-->
					<table width="0"  id="mainTable">
						<tr>
							<td width="0">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					
					<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					
					
					<!--Grid (S)-->
					<table width="0"  id="mainTable">
						<tr>
							<td width="0">
								<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					
					<!--Grid (S)-->
					<table width="0"  id="mainTable">
						<tr>
							<td width="0">
								<script language="javascript">ComSheetObject('sheet6');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					
						<!-- biz_2-2 (E) -->
						<!--  Button_Sub (S) -->
						<table width="270" class="button">
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="add_button">Row Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="del_button">Row Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_Copy">Copy</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>		
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
						
					
				<!-- biz 2 - frame (E) -->
				</td></tr>
			</table>
			</td>
		<td width=" "valign="top">
		
			
				<!-- biz 3 - frame (S) -->
				<!--  biz_3  (S) -->
						
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
							<td width="534">Cargo Detail for Container Sequence&nbsp;&nbsp;<input name="frm_seq" type="text" style="width:30;" class="input2" value="" readOnly></td>
							<td width="95">Awkward Term</td>
							<td width=""><select name="rcv_term_cd" style="width:35;" class="input">							
							<option value="Y">Y</option>
							<option value="D">D</option>
							<option value="S">S</option>
							<option value="T">T</option>							
							<option value="I">I</option>							
						</select>&nbsp;<select name="de_term_cd" style="width:35;" class="input">						
						<option value="Y">Y</option>
						<option value="D">D</option>
						<option value="S">S</option>
						<option value="T">T</option>							
						<option value="O">O</option>
						</select></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="54">Package</td>
							<td width="160"><input name="frm_pck_qty" type="text" style="width:60;text-align:right;" class="input1" value="" maxlength="7">&nbsp;<input name="frm_pck_tp_cd" type="text" style="width:25;" class="input1" value="" maxlength="2">&nbsp;<img name="pck_button" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="88">Gross Weight</td>
							<td width="175"><input name="frm_grs_wgt" type="text" style="width:90;text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11">&nbsp;<select name="wgt_ut_cd1" style="width:56;" class="input1"><option value="KGS">KGS</option><option value="LBS">LBS</option></select></td> 
							<td width="77">Net Weight</td>
							<td style="padding-left:1;"><input name="frm_net_wgt" type="text" style="width:88;text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11">&nbsp;<input type="text" name="wgt_ut_cd2" style="width:56;" class="input2" readOnly></td> </tr>
						</table>
						
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="74">Commodity</td>
							<td width="404"><input name="cmdt_cd" type="text" style="width:65;" class="input1" value="" maxlength="6">&nbsp;<input name="cmdt_nm" type="text" style="width:203;" class="input2" value="" readOnly>&nbsp;<img name="cmdt_button" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="115">DG container S/N</td>
							<td width="" style="padding-left:0;"><input name="frm_cntr_cgo_seq" type="text" style="width:88;" class="input2" value="" readOnly>&nbsp;<img name="dg_container_seq" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
						</table>

						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="378" rowspan="5">
							
								<!-- dimention info(s) -->
								<table border="0" style="width:378; background-color:white;" class="grid2"> 
								<tr class="tr2_head">
									<td colspan="6">Dimension Information (unit : cm)</td>
									<td rowspan="3" colspan="2" align="left" style="background-color:#f3f2f8; border-right:1px solid #f3f2f8; border-top:1px solid #f3f2f8; padding-left:3;">
										<br>
										<br>
										<br style="font-size:1px;">
										<input name="und_deck_top_flg" type="checkbox" class="trans">&nbsp;UD-Top
										<br style="font-size:1px;">
										<input name="inGauge" type="checkbox" class="trans" disabled>&nbsp;In-Gauge										
										
										
										</td></tr>
								<tr class="tr2_head2">
									<td width=""></td>
									<td width="" colspan="2">Length</td> 									
									<td width="" colspan="2">Width</td>
									<td width="">Height</td> </tr>
								<tr><td class="tr2_head2">Total Dimension </td>
									<td colspan="2" class="input1" align="right">
										<input name="ttl_dim_len" type="text" style="width:100%;text-align:right;border:0" class="input1" value="">
									</td>									
									<td class="input1" align="right" colspan="2">
										<input name="ttl_dim_wdt" type="text" style="width:100%;text-align:right;border:0" class="input1" value="" >
									</td>
									<td class="input1" align="right">
										<input name="ttl_dim_hgt" type="text" style="width:34;text-align:right;border:0" class="input1" value="" >
									</td> </tr>
								<tr class="tr2_head2">
									<td width="" rowspan="2" width="%">Over Dimension </td>
									<td width="">Front</td> 
									<td width="">Rear</td> 									
									<td width="">Right</td> 
									<td width="">Left</td>
									<td width="">Height</td> 
									<td width="" colspan="2">Void Space</td></tr>
								<tr><td width="31" align="right">
													<input name="ovr_fwrd_len" type="text" style="width:100%;text-align:right;border:0"  class="input" value="" dataformat="num" maxlength="6" style="ime-mode:disabled"></td> 
									<td width="31">	<input name="ovr_bkwd_len" type="text" style="width:100%;text-align:right;border:0" class="input" value="" dataformat="num" maxlength="6" style="ime-mode:disabled"></td>									
									<td width="31">	<input name="ovr_rt_len" type="text" style="width:100%;text-align:right;border:0" class="input" value="" dataformat="num" maxlength="6" style="ime-mode:disabled"></td> 
									<td width="31">	<input name="ovr_lf_len" type="text" style="width:100%;text-align:right;border:0" class="input" value="" dataformat="num" maxlength="6" style="ime-mode:disabled"></td> 
									<td width="31">	<input name="ovr_hgt" type="text" style="width:100%;text-align:right;border:0" class="input" value="" dataformat="num" maxlength="6" style="ime-mode:disabled"></td>  									
									<td width="31">	<input name="ovr_void_slt_qty" type="text" style="width:100%;text-align:right;border:1" class="input" value=""  dataformat="num" maxlength="6" style="ime-mode:disabled"></td>
									<td width="" align="center" class="tr2_head2">FEU</td>
									</tr>
								</table>
								<!--  Button_Sub (S) -->
						<table width="378" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="criteria_button">Criteria</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
			
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" id="details_button" name="details_button">Details</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>

								
										
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
								<!-- dimention info(s) -->
							
							</td>
							<td align="right">Corner Post Status&nbsp;</td>
							<td  align="right" style="padding-left:2;"><select name="crn_pst_sts_cd" style="width:135;">
							<option value="" ></option>
							<option value="1" >1 Feet Extension</option>
							<option value="2" >2 Feet Extension</option>
							<option value="3" >3 Feet Extension</option>
							<option value="4" >4 Feet Extension</option>
							<option value="5" id = "feet_5">5 Feet Extension</option>
							<option value="E">Erect-No Extension</option>
							<option value="F">FOLDING</option> 
							</select></td></tr>
						<tr class="h23">
							<td width="" align="right">Over Height after Extension</td>
							<td align="right"><input name="frm_xtd_ovr_qty" type="text" style="width:135;" class="input" value="" ></td></tr>
						
						<tr class="h23">
							<td align="right">Post Lock Pin&nbsp;</td>
							<td align="right" style="padding-left:1;"><select name="pst_lck_pin_flg" style="width:135;"><option value=""></option><option value="Y">Engage</option><option value="N" >No</option></select></td></tr>
						<tr class="h23">
							<td align="right">Gravity Center</td>
							<td align="right"><input name="frm_grav_ctr_desc" type="text" style="width:135;" class="input" value="" maxlength="50"></td></tr>
						<tr class="h23">
							<td colspan="2" align="right">Approval Ref. No.&nbsp;<input name="aply_no" type="text" style="width:180;" class="input" value="" readonly></td></tr>	
							
							
					
						</table>
						<!--  biz_3   (E) -->
						
						<table width="709" class="search" > 
						<tr class="h23">
							<td width="120">Stowage Request</td>
							<td><input name="stwg_cd" type="text" style="width:150" class="input2" value="" readOnly></td>
							<td width="180">&nbsp;&nbsp;&nbsp;Stowage Request(remark)</td>
							<td><input name="frm_stwg_rqst_desc" type="text" style="width:240" class="input" value=""></td>
							</tr>
							<tr class="h23">
							<td width="120">Internal E-mail 1</td>
							<td><input name="awk_cgo_rqst_grp_eml1" type="text" style="width:150" class="input" value=""></td>
							<td width=180">&nbsp;&nbsp;&nbsp;Internal E-mail 2</td>
							<td><input name="awk_cgo_rqst_grp_eml2"  type="text" style="width:240" class="input" value=""></td>
						</tr>
						</table>
						<!--  Button_Sub (S) -->
						<table width="689" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" id="btn_Remark" name="btn_Remark">Remark(s)</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
			
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" id="btn_RequestCancel" name="btn_RequestCancel">Request&nbsp;Cancel</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>

								
										
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
				
						
					</td></tr>
		</table>	
					
				<!-- biz 3 - frame (E) -->
				
			</td></tr>
		</table>		
				
				
			</td></tr>
		</table>
		<!-- biz 2,3 - frame (E) -->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_attach" id="btn_attach">Attach File</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Request" id="btn_Request">Request</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_email">E-mail</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
			
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->	
		
			
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
	
</form>
</body>
</html>
