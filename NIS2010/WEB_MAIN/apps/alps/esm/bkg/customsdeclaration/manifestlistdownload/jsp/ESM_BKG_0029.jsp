<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0029.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0029Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	boolean isCA_Usr 		= false;
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		if ("ESM_BKG_0029_2".equals( StringUtil.xssFilter(request.getParameter("pgmNo"))))
		{
			isCA_Usr = true;
			strCnt_cd = "CA";
		}
		event = (EsmBkg0029Event)request.getAttribute("Event");
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
<title>B/L Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage('<%=isCA_Usr%>', '<%=strUsr_id%>');
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="B/L Inquiry">
<input type="hidden" name="com_mrdBodyTitle" value="B/L Inquiry">
<input type="hidden" name="com_mrdDisableToolbar">
<%
	String sBlNo = StringUtil.xssFilter(request.getParameter("bl_no"));
	String vvd = StringUtil.xssFilter(request.getParameter("vvd"));
	String pod = StringUtil.xssFilter(request.getParameter("pod"));
	String eta = StringUtil.xssFilter(request.getParameter("eta"));
	String type = StringUtil.xssFilter(request.getParameter("type"));
%>
<input type="hidden" name="tab_no" value="1">
<input type="hidden" name="type" value="<%=type%>">
<input type="hidden" name="cust_tp">
<input type="hidden" name="cust_seq" caption="Country Seq.">
<input type="hidden" name="cust_cnt_cd" caption="Country Code">
<input type="hidden" name="frm_pod_nod_cd">
<!-- 개발자 작업	-->

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="65">B/L No.</td>
					<td width="130" valign="middle">
						<input type="text" style="width:100;ime-mode:disabled" class="input" 
						name="bl_no" maxlength="12" dataformat="eng" minlength="12" caption="B/L No." required value="<%=sBlNo%>">
					<td width="40">Filer</td>
					<td width="30">	
						<input type="text" style="width:20;" class="input2" ReadOnly name="frm_cstms_file_tp_cd">
					</td>
					<td width="90" align="center"><span id="frm_mf_sts_cd"></span></td>
					<td width="40" align="right">Type</td>
					<td width="170">&nbsp;&nbsp;<script language="javascript">ComComboObject('frm_trsp_tp_id', 2, 130, 1, 0, 1);</script></td>
                    <td width="80">Empty<input type="checkbox" value="1" class="trans" name="frm_full_mty_cd"></td> 	
					<td width="40">Stage</td>
					<td width="160">
						<input type="text" style="width:35;" class="input2" ReadOnly name="frm_cstms_mf_tp_cd">
						&nbsp;<script language="javascript">ComComboObject('frm_cstms_trsm_sts_cd', 1, 70, 1, 0, 1);</script>
						</td>
                    <td width="15">F:</td>
                    <td width="40"><input type="text" style="width:20;" class="input2" ReadOnly name="frm_frt_clt_flg"></td>
                    <td width="15">O:</td>
                    <td width="*"><input type="text" style="width:20;" class="input2" ReadOnly name="frm_obl_rdem_flg"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="65">M.B/L No.</td>
					<td width="130"><input type="text" style="width:100;" class="input2" ReadOnly name="frm_m_bl_no"></td>
					<td width="40">T.BDR</td>
					<td width="30">	
						<input type="text" style="width:20;" class="input2" ReadOnly name="frm_t_bdr_flg">
					</td>
					<td width="130" align="right">CGO Control No.</td>
					<td width="*">&nbsp;&nbsp;<input type="text" style="width:130;" class="input2" ReadOnly name="frm_ccn_no"></td>
					<td></td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="120"><input type="text" style="width:90;" class="input2" ReadOnly name="frm_vvd_cd" value="<%=vvd%>" required></td>
					<td width="30">POR</td>
					<td width="90">
						<input type="text" style="width:60;ime-mode:disabled" class="input2" ReadOnly name="frm_por_cd" 
							maxlength="5" dataformat="engup" minlength="5" caption="POR" required></td>
					<td width="30">POL</td>
					<td width="90"><input type="text" style="width:60;" class="input2" ReadOnly name="frm_pol_cd"
							maxlength="5" dataformat="engup" minlength="5" caption="POL" required></td>
					<td width="30">POD</td>
					<td width="90"><input type="text" style="width:60;" class="input2" ReadOnly name="frm_pod_cd" value="<%=pod%>" required></td>
					<td width="30">ETA</td>
					<td width="180"><input type="text" style="width:130;" class="input2" ReadOnly name="frm_vps_eta_dt" value="<%=eta%>" required></td>
					<td width="30">DEL</td>
					<td width=""><input type="text" style="width:70;" class="input" name="frm_del_cd"
							maxlength="5" dataformat="engupnum" minlength="5" caption="DEL" required></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="30">Q'ty</td>
					<td width="120">
						<input type="text" style="width:50;text-align:right" class="input" name="frm_pck_qty"
							maxlength="12" dataformat="float" caption="Q'ty" required>
						<input type="text" style="width:36;" class="input" name="frm_ams_pck_tp_cd"
							maxlength="5" dataformat="engup" caption="Q'ty Unit"></td>
					<td width="30">WGT</td>
					<td width="120">
						<input type="text" style="width:105;text-align:right;" class="input" name="frm_cgo_wgt"
							maxlength="22" dataformat="float" caption="WGT" required></td>
					<td width="90">
						<script language="javascript">ComComboObject('frm_wgt_ut_cd', 1, 60, 1, 3);</script>
					</td>
					<td width="30">HUB</td>
					<td width="90"><input type="text" style="width:60;" class="input" name="frm_hub_loc_cd"
							maxlength="5" dataformat="engupnum" minlength="5" caption="HUB"></td>
					<td width="120">Location of Goods</td>
					<td width=""><input type="text" style="width:200;" class="input" name="frm_ibd_loc_gds_desc"
							maxlength="100" dataformat="etc" caption="Location of Goods"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_8"><tr><td></td></tr></table>

<!-- Tab (S) -->
<table class="tab" border="0" cellpadding="0" cellspacing="0" width="900">
	<tr>
		<td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
		</td>
	</tr>
</table>
<!-- Tab (E) -->

<!-- (TAB) Customer (S) -->
<div id="tabLayer" style="display:inline">
<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="480">
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="70" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Shipper</td>
								<td colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="frm_cust_cnt_cd1"
										maxlength="2" dataformat="engup" caption="Shipper Country Code">&nbsp;
									<input type="text" style="width:60;text-align:right;" class="input"  name="frm_cust_seq1"
										maxlength="6" dataformat="eng" caption="Shipper Sequence">&nbsp;
									<img class="cursor" name="btn_cust_s" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="frm_cust_nm1"
										maxlength="500" dataformat="etc" caption="Shipper Name"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="3"><textarea rows="3" name="frm_cust_addr1"
										maxlength="500" dataformat="etc" caption="Shipper Address"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td class="tr_head2">City/State</td>
								<td width="170">
									<input type="text" style="width:135;" class="input" name="frm_cust_cty_nm1"
										maxlength="500" dataformat="etc" caption="Shipper City">
									<input type="text" style="width:25;" class="input" name="frm_cust_ste_cd1"
										maxlength="2" dataformat="eng" caption="Shipper State"></td>
						 		<td width="70" class="tr_head2">Country/Zip</td>
								<td width="120">
									<input type="text" style="width:25;" class="input" name="frm_cstms_decl_cnt_cd1"
										maxlength="2" dataformat="eng" caption="Shipper Country">
									<input type="text" style="width:87;" class="input" name="frm_cust_zip_id1"
										maxlength="10" dataformat="etc" caption="Shipper Zip"></td>
							</tr>
						</table>
						
						<table class="height_8"><tr><td></td></tr></table>
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="70" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Consignee</td>
								<td colspan="2" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="frm_cust_cnt_cd2"
										maxlength="2" dataformat="engup" caption="Consignee Country Code">&nbsp;
									<input type="text" style="width:60;text-align:right;" class="input" name="frm_cust_seq2"
										maxlength="6" dataformat="eng" caption="Consignee Sequence">
									<img class="cursor" name="btn_cust_c" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="120" align="right" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">B/L type&nbsp;
									<input type="text" style="width:30;" class="input2" name="frm_to_ord_flg" readonly="readonly"></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="frm_cust_nm2"
										maxlength="500" dataformat="etc" caption="Consignee Name"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="3"><textarea rows="3" name="frm_cust_addr2"
										maxlength="500" dataformat="etc" caption="Consignee Address"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td width="70" class="tr_head2">City/State</td>
								<td width="170">
									<input type="text" style="width:135;" class="input" name="frm_cust_cty_nm2"
										maxlength="500" dataformat="etc" caption="Consignee City">
									<input type="text" style="width:25;" class="input" name="frm_cust_ste_cd2"
										maxlength="2" dataformat="eng" caption="Consignee State"></td>
						 		<td width="70" class="tr_head2">Country/Zip</td>
								<td width="120">
									<input type="text" style="width:25;" class="input" name="frm_cstms_decl_cnt_cd2"
										maxlength="2" dataformat="eng" caption="Consignee Country">
									<input type="text" style="width:87;" class="input" name="frm_cust_zip_id2"
										maxlength="10" dataformat="etc" caption="Consignee Zip"></td>
							</tr>
						</table>
						</td> 
						<td width="20"></td>
						<td width="480">
							<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="70" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Notify</td>
								<td colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="frm_cust_cnt_cd3"
										maxlength="2" dataformat="engup" caption="Notify Country Code">
									<input type="text" style="width:60;text-align:right;" class="input" name="frm_cust_seq3"
										maxlength="6" dataformat="eng" caption="Notify Sequence">
									<img class="cursor" name="btn_cust_n" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="frm_cust_nm3"
										maxlength="500" dataformat="etc" caption="Notify Name"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="3"><textarea rows="3" name="frm_cust_addr3"
										maxlength="500" dataformat="etc" caption="Notify Address"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td class="tr_head2">City/State</td>
								<td width="170">
									<input type="text" style="width:135;" class="input" name="frm_cust_cty_nm3"
										maxlength="500" dataformat="etc" caption="Notify City">
									<input type="text" style="width:25;" class="input" name="frm_cust_ste_cd3"
										maxlength="2" dataformat="eng" caption="Notify State"></td>
						 		<td width="70" class="tr_head2">Country/Zip</td>
								<td width="120">
									<input type="text" style="width:25;" class="input" name="frm_cstms_decl_cnt_cd3"
										maxlength="2" dataformat="eng" caption="Notify Country">
									<input type="text" style="width:87;" class="input" name="frm_cust_zip_id3"
										maxlength="10" dataformat="etc" caption="Notify Zip"></td>
							</tr>
						</table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td colspan="4" style="background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-left:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">Delivery Address&nbsp;&nbsp;
								<input type="text" style="width:50;" class="input" name="frm_in_tz_yd_cd1"
										maxlength="5" dataformat="eng" caption="Yard Code">&nbsp;
								<input type="text" style="width:25;" class="input" name="frm_in_tz_yd_cd2"
										maxlength="2" dataformat="eng" caption="Yard Code">&nbsp;
								<img class="cursor" name="btn_cust_d" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td width="70" class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="frm_in_tz_yd_nm"
										maxlength="500" dataformat="etc" caption="Yard Name"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="3"><textarea rows="3" name="frm_in_tz_yd_addr"
										maxlength="500" dataformat="etc" caption="Yard Address"
										style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" 
										class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td width="70" class="tr_head2">City/State</td>
								<td width="170">
									<input type="text" style="width:135;" class="input" name="frm_in_tz_yd_cty_nm"
										maxlength="500" dataformat="etc" caption="Yard City">
									<input type="text" style="width:25;" class="input" name="frm_in_tz_yd_ste_cd"
										maxlength="2" dataformat="eng" caption="Yard State"></td>
						 		<td width="70" class="tr_head2">Country/Zip</td>
								<td width="120">
									<input type="text" style="width:25;" class="input" name="frm_in_tz_yd_cnt_cd"
										maxlength="2" dataformat="eng" caption="Yard Country">
									<input type="text" style="width:87;" class="input" name="frm_in_tz_yd_zip_id"
										maxlength="10" dataformat="etc" caption="Yard Zip"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:940;">
				 <tr class="h23">
				 	<td width="75">Remark(s)</td>
				 	<td ><input type="text" style="width:100%;" class="input" name="frm_diff_rmk"
				 		maxlength="4000" dataformat="etc" caption="Remark"></td>
				 </tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Search Options ) (E) -->
</div>
<!-- (TAB) Customer (E) -->

<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
<script language="javascript">ComSheetObject('sheet2');</script>
</div>

<!-- (TAB) Customer Result (S) -->
<div id="tabLayer" style="display:none">
<table class="search">
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<!-- (TAB) Customer Result (E) -->

<!-- (TAB) H/BL List (S) -->
<div id="tabLayer" style="display:none">
<table class="search">
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<!-- (TAB) H/BL List (E) -->

<div style="display:none">
<script language="javascript">ComSheetObject('sheet5');</script>
</div>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn">
			<table>
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Delete">Delete</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Reactivate">Reactivate</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Print">Print</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
		</td>
		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Container">Container</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_CM">C/M</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ViewMsg">View MSG</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Transmit">Transmit</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Terminal">Terminal EDI</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
		</td>
	</tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

</form>
</body>
</html>