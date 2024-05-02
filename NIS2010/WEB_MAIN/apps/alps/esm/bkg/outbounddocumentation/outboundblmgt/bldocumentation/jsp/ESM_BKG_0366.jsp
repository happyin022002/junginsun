<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_366.jsp
*@FileTitle : Marks And Number/Description of Goods
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.22 김영출
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0366Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>

<%
    EsmBkg0366Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String isInquiry = "N";	
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentationBL");

	String bkgNo      = "";
	String blNo       = "";
	String blTpCd     = "";
	String bkg_no     = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0366Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
		blTpCd     = event.getBlTpCd();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		
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
<title>NVOCC House B/L</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="dirty_flag">
<input type="hidden" name="bkg_sts_cd">
<input type="hidden" name="bdr_flg">
<input type="hidden" name="corr_flg">
<input type="hidden" name="ca_flg">
<input type="hidden" name="ca_exist_flg">
<input type="hidden" name="cnd_flg">
<input type="hidden" name="org_bl_no">
<input type="hidden" name="org_cntr_mf_no">
<input type="hidden" name="default_wgt_ut_cd">
<input type="hidden" name="default_meas_ut_cd">
<input type="hidden" name="hts_flg">
<input type="hidden" name="bkg_mk_desc">
<input type="hidden" name="bkg_cstms_desc">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="obl_iss_flg">
<input type="hidden" name="bl_tp_cd" value="<%=blTpCd%>">
<input type="hidden" name="old_bkg_no" value="<%= bkgNo%>">

<!--table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top"-->

	<!--Page Title, Historical (S)-->
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Sales > FMS > Agreement Inquiry</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; NVOCC House B/L Information</td></tr>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		</table-->
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search" style="width:998;">
       	<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="75">Booking No.</td>
					<td width="165"><input name="bkg_no" maxlength=13 value="<%=bkgNo%>" type="text" style="ime-mode:disabled;width:110;" dataformat="engupnum" class="input1">
					<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="48">B/L No.</td>
					<td width="185"><input type="text" name="bl_no" maxlength=13 value="<%=blNo%>" style="ime-mode:disabled;width:110;" dataformat="engupnum" class="input"></td>
					<td width="40">Route</td>
					<td width="225"><input type="text" name="por_cd" style="ime-mode:disabled;width:48;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="pol_cd" style="ime-mode:disabled;width:48;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="pod_cd" style="ime-mode:disabled;width:48;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="del_cd" style="ime-mode:disabled;width:48;" dataformat="engupnum" class="input2" readOnly></td>
					<td width="105">Master B/L Filer</td>
					<td class="">US&nbsp;<input type="text" name="usa_cstms_file_cd" style="ime-mode:disabled;width:23;" dataformat="engupnum" class="input2" readOnly>&nbsp;
					             CA&nbsp;<input type="text" name="cnd_cstms_file_cd" style="ime-mode:disabled;width:23;" dataformat="engupnum" class="input2" readOnly></td>
				 </tr>
				</table>

				<!--  biz_1   (E) -->

		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="69">H.B/L Seq.</td>
					<td width="83"><select name="hbl_seq" style="width:45;"><option value="0" selected>0</option></select>&nbsp;<input type="text" name="hbl_ttl_knt" style="ime-mode:disabled;width:28;" dataformat="int" class="input2" readOnly></td>
					<td width="101">Manifest File No.</td>
					<td width="108"><input type="text" name="cntr_mf_no" style="ime-mode:disabled;width:100px;" dataformat="engupnum" class="input2" readOnly></td>
					<td width="60">Split&nbsp;<img name="btn_split" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="89">House B/L No.</td>
					<td width="128"><input type="text" name="hbl_no" maxlength=30 style="ime-mode:disabled;width:120px;" dataformat="engupnum" class="input"></td>
					<td width="25">IEC</td>
					<td width="110"><input type="text" name="ida_iec_no" style="ime-mode:disabled;width:100px;" dataformat="engupnum" class="input" maxlength="11"></td>
					<td width="60">ACI Type</td>
					<td width="100"><select name="hbl_mf_tp_cd" style="width:100px;">
						<option></option>
						<option value="23">23:In-Transit</option>
						<option value="24">24:Import</option>
					</select></td>
				 </tr>
				</table>

				<!--  biz_1  (E) -->

				<table class="search_sm2" border="0" style="width:979;">
				<tr class="h23">

				<!--  biz_2  (S) -->

				<td valign="top" style="width:485;">
					<table class="grid2" border="0" style="width:470;">
						<tr class="h23">
							<td width="90" class="tr_head2" rowspan="2">Actual<br>Shipper</td>
							<td colspan="5" style="background-color:#E9E9E9;"><textarea name="shpr_nm" rows="3" cols="35"  style="ime-mode:disabled;font-family:Courier New; font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea1"></textarea></td>
						</tr>
						<tr class="h23">
							<td colspan="5" style="background-color:#E9E9E9;"><textarea name="shpr_addr" rows="3" cols="35"  style="ime-mode:disabled;font-family:Courier New; font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea1"></textarea></td>
						</tr>
						<tr class="h23">
							<td width="90" class="tr_head2">City / State</td>
							<td width="157"><input type="text" name="shpr_cty_nm" maxlength=50 style="ime-mode:disabled;width:120;" dataformat="engupnumspc" class="input">&nbsp;<input type="text" name="shpr_ste_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input" maxlength="2"></td>
							<td width="45" class="tr_head2">Country</td>
							<td width="30"><input type="text" name="shpr_cnt_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input" maxlength="2"></td>
							<td width="55" class="tr_head2">ZIP Code</td>
							<td width=""><input type="text" name="shpr_zip_cd" style="ime-mode:disabled;width:70;" dataformat="engupnumspc" class="input" maxlength="10"></td></tr>
					</table>
					<table class="height_8"><tr><td></td></tr></table>

					<table class="grid2" border="0" style="width:470;">
						<tr class="h23"width="100%">
							<td width="90" class="tr_head2" rowspan="2">Actual<br>Consignee</td>
							<td colspan="5" style="background-color:#E9E9E9;"><textarea name="cnee_nm" rows="3" cols="35"  style="ime-mode:disabled;font-family:Courier New; font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea1"></textarea></td>
						</tr>
						<tr class="h23">
							<td colspan="5" style="background-color:#E9E9E9;"><textarea name="cnee_addr" rows="3" cols="35"  style="ime-mode:disabled;font-family:Courier New; font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea1"></textarea></td>
						</tr>
						<tr class="h23">
							<td width="90" class="tr_head2">City / State</td>
							<td width="157" style="padding-left:1"><input type="text" name="cnee_cty_nm" maxlength=50 style="ime-mode:disabled;width:120;" dataformat="engupnumspc" class="input">&nbsp;<input type="text" name="cnee_ste_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input" maxlength="2"></td>
							<td width="45" class="tr_head2">Country</td>
							<td width="30"><input type="text" name="cnee_cnt_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input" maxlength="2"></td>
							<td width="55" class="tr_head2">ZIP Code</td>
							<td width=""><input type="text" name="cnee_zip_cd" style="ime-mode:disabled;width:70;" dataformat="engupnumspc" class="input" maxlength="10"></td></tr>
					</table>
				</td>
				<td  valign="top">
				<table class="grid2" border="0" style="width:485;">
						<tr class="h23">
							<td width="90" class="tr_head2" rowspan="2">Actual<br>Notify</td>
							<td colspan="5" style="background-color:#E9E9E9;"><textarea name="noti_nm" rows="3" cols="35"  style="ime-mode:disabled;font-family:Courier New; font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea"></textarea></td>
						</tr>
						<tr class="h23">
							<td colspan="5" style="background-color:#E9E9E9;"><textarea name="noti_addr" rows="3" cols="35" style="ime-mode:disabled;font-family:Courier New; font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea"></textarea></td>
						</tr>
						<tr class="h23">
							<td width="90" class="tr_head2">City / State</td>
							<td width="157" style="padding-left:1"><input type="text" name="noti_cty_nm" maxlength=50 style="ime-mode:disabled;width:120;" dataformat="engupnumspc" class="input">&nbsp;<input type="text" name="noti_ste_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input" maxlength="2"></td>
							<td width="45" class="tr_head2">Country</td>
							<td width="30"><input type="text" name="noti_cnt_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input" maxlength="2"></td>
							<td width="55" class="tr_head2">ZIP Code</td>
							<td width=""><input type="text" name="noti_zip_cd" style="ime-mode:disabled;width:80;" dataformat="engupnumspc" class="input" maxlength="10"></td></tr>
					</table>
					<table class="height_8"><tr><td></td></tr></table>

					<table class="search" border="0" style="width:485;">
						<tr class="h23">
							<td width="172">
								<table width="100%" class="grid2" border="0">
								<tr class="tr2_head_l">
									<td width="212">Mark & NOS</td>
								</tr>
								<tr class="">
									<td width=""><textarea name="bl_mk_desc"  rows="5" style="ime-mode:disabled;width:100%;font-family:Courier New; font-size:12px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea"></textarea></td>
								</tr>
								</table>
							</td>
							<td width="10">&nbsp;</td>
							<td width="">
								<table width="100%" class="grid2" border="0">
								<tr class="tr2_head_l">
									<td width="212">Description</td>
								</tr>
								<tr class="">
									<td width=""><textarea name="bl_gds_desc"  rows="5" style="ime-mode:disabled;width:100%;font-family:Courier New; font-size:12px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engupnumspc" wrap="hard" class="textarea"></textarea></td>
								</tr>
								</table>
							</td>
						</tr>
					</table>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
	       				<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_hbl_tmplt">House B/L Template</td>
								<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
					</td></tr>
					</table>
	    				<!-- Button_Sub (E) -->

				</td>
				</tr>
				</table>

				<!--  biz_2  (E) -->
				<!--  biz_3 (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="95">Total Package</td>
					<td width="180"><input type="text" name="pck_qty" style="width:80px;text-align:right;" dataformat="int" maxlength="7" class="input1">&nbsp;<input type="text" name="pck_tp_cd" style="ime-mode:disabled;width:28;" dataformat="engup" maxlength="2" class="input1">&nbsp;<img name="btn_PCKPop" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Total Weight</td>
					<td width="160"><input type="text" name="hbl_wgt" style="width:68px;text-align:right;" dataformat="float" maxlength="13" pointcount="3" class="input1">&nbsp;<select name="wgt_ut_cd" style="width:66;" class="input1"><option value="KGS">KGS</option><option value="LBS">LBS</option></select></td>
					<td width="95">Total Measure</td>
					<td width=""><input type="text" name="cmdt_meas_qty" style="width:48px;text-align:right;" dataformat="float" maxlength="9" pointcount="3" class="input">&nbsp;<select name="cmdt_meas_ut_cd" style="width:69;"><option value="CBM">CBM</option><option value="CBF">CBF</option></select></td>
				 </tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
				<td width="250" valign="top">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				</td>
				<td width="4" valign="top"></td>
				<td width="725" valign="top">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				</td></tr>
			</table>
	
		<!--  Button_Sub (S) -->
		<table width="100%" class="button" border="0">
		<tr><td class="btn2_bg" style="padding-bottom:10;">
			<table border="0" cellpadding="0" cellspacing="0">
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t9CopyMnd">Copy from M&amp;D</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>					
			</table>
		</td></tr>
		</table>
		<!-- Button_Sub (E) -->

		<table width="100%" class="total" border="0" style="border-top:#a28792 1px solid">
			<tr>
				<td align="right">
					<table border="0">
						<tr class="h23">
							<td>Container Total :</td>
							<td width=20>&nbsp;</td>
							<td>Package</td>
							<td width="110"><input type="text" name="cm_pck_qty" style="width:90px;text-align:right;" class="input2" readOnly></td>
							<td>Weight</td>
							<td width="150"><input type="text" name="cm_wgt_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
							<td>Measure</td>
							<td width="150"><input type="text" name="cm_meas_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
						 </tr>
					</table>				
				</td>
			 </tr>
			<tr>
				<td align="right">
					<table border="0">
						<tr class="h23">
							<td>House B/L Total :</td>
							<td width=20>&nbsp;</td>
							<td>Package</td>
							<td width="110"><input type="text" name="bk_pck_qty" style="width:90px;text-align:right;" class="input2" readOnly></td>
							<td>Weight</td>
							<td width="150"><input type="text" name="bk_wgt_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
							<td>Measure</td>
							<td width="150"><input type="text" name="bk_meas_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
						 </tr>
					</table>				
				</td>
			 </tr>
		</table>
		<!--  biz_3  (S) -->
	
		<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->

		</td>
	</tr>
	</table>

	<!--biz 2page (E)-->
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

	<!--Button (S) -->
	<table width="998" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_addHBl">Add H.B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_deleteHBl">Delete H.B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copyHBl">Copy H.B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copyCM">Copy C/M</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_amsFileNoAssign">Manifest File No. Assign</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->

	<!--/td></tr>
</table-->

<!-- 개발자 작업  끝 -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none"/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0" marginWidth="0" width="115" height="82" style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"></IFRAME>
</form>
<form name="form2">
<input type="hidden" name="func">
<input type="hidden" name="mk_desc">
<input type="hidden" name="gds_desc">
</form>
</body>
</html>