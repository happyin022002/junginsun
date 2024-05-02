<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_01.jsp
*@FileTitle : In-bound C/S Screen US
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066801Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066801Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgtSC.CsScreenBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg066801Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen US</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var strUsr_id    = "<%=strUsr_id%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();" onKeyDown="enterKeySearch();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type='hidden' name ='mainPage' value="<%=JSPUtil.getNull(request.getParameter("mainPage"))%>">
<!-- 개발자 작업	-->
<input type='hidden' name ='h_cntr_no' value = "">
<input type='hidden' name ='h_po_no' value = "">
<input type='hidden' name ='h_split' value = "">
<input type='hidden' name ='h_hbl_no' value = "">
<input type='hidden' name ='xmlData' value = "">
<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='h_mov_cntr_no' value = "">
<input type='hidden' name ='h_mrd_id' value = "">
<input type='hidden' name ='h_local_lang_flg' value = "">
<!-- Ivoce Bil_Amt Total-->
<input type='hidden' name ='invTotBilAmt'>
<input type='hidden' name ='h_old_bl_no' value = "">
<input type='hidden' name ='h_old_bkg_no' value = "">
<!-- RD 부분  -->
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<!-- 
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="">
-->
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value=""> 
<input type="hidden" name="com_mrdBodyTitle" value="">
<!--DEM.DET 팝업 호출 파라메터 2009-12-08-->
<input type='hidden' name ="demDtlXmlData">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_inquiry">B/L Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">B/L&nbsp;Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BkgMain">BKG Main</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_charge">Charge</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_customer">Customer Master</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->		
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">B/L No.</td>
                    <td width="135"><script language="javascript">ComComboObject('combo_bl_no', 1, 125, 0);</script></td>
					<td width="50">BKG No.</td>
					<td width="104">
						<input type="text" name = "bkg_no" caption="BKG No." maxlength="13" style="width:100;" class="input" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>" dataformat="eng" style="ime-mode:disabled" onChange="conditionReset();"></td>
					<td width="70"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_split" style="color:red">SPLIT</td>
						<td class="btn2_right"></td>
						</tr>
				</table></td>
					<td align="right">
						<table class="search_sm2" border="0" style="width:97%;"> 
						<tr class="h23">
							<td width="90">Container No.</td>
							<td width="125"><input type="text" name = "cntr_no" caption="Container No." style="width:100;" class="input" value="" dataformat="eng" maxlength="11" style="ime-mode:disabled" ></td>
							<td width="55">P/O No.</td>
							<td width="100"><input type="text" name = "po_no" style="width:80;" class="input" value="" dataformat="eng1" style="ime-mode:disabled" ></td>
							<td width="70">H.B/L No.</td>
							<td width=""><input type="text" name = "hbl_no" style="width:100;" class="input" value="" dataformat="eng" style="ime-mode:disabled" ></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->
		
	
	
	
<!--TAB B/L Info (S) -->
<div id="tabLayer" style="display:inline">	
		
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
		
			<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="700" valign="top">
	<!--  biz_2_1  (S) -->
						<table class="search_sm" border="0" style="width:100%;"> 
							<tr class="h23"><td width="100%" style=" padding-right:0;">
						
						<table class="search" border="0" style="width:100%;">  
							<tr class="h23">
								<td width="75" class="">Arrival VVD</td>
								<td width="82" class=""><input type="text" name = "frm_t1sheet1_arrival_vvd" style="width:80;" class="input2" value="" readonly="true"></td>
								<td width="186" class=""><input type="text" name = "frm_t1sheet1_arrival_vvd_nm" style="width:170;" class="input2" value="" readonly="true"></td>
								<td width="56">BKG STS </td>
								<td width="46" ><input type="text" name = "frm_t1sheet1_bkg_sts_cd" style="width:22;" class="input2" value="" readonly></td>
								<td width="64" class="">Partial</td>
								<td width="76" class=""><input type="text" name = "frm_t1sheet1_partial" style="width:50;" class="input2" value="" readonly="true"></td>
								<td width="80" class="">T/S Route</td>
								<td width="" class=""><img class="cursor" name="btn_ts_route" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" ></td>
							
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">ETA</td>
								<td width="147" class=""><input type="text" name = "frm_t1sheet1_vps_eta_dt" style="width:125;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">ATA</td>
								<td width="135" class=""><input type="text" name = "frm_t1sheet1_vps_etb_dt" style="width:120;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">Lane</td>
								<td width="73" class=""><input type="text" name = "frm_t1sheet1_slan_cd" style="width:49;" class="input2" value="" readonly="true"></td>
								<td width="64" class="">RCV Term</td>
								<td width="76" class=""><input type="text" name = "frm_t1sheet1_rcv_term_cd" style="width:50;" class="input2" value="" readonly="true"></td>
								<td width="78" class="">DEL Term</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_de_term_cd" style="width:20;" class="input2" value="" readonly="true"></td>
							
							</tr>
						</table>
						
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">POR</td>
								<td width="66" class=""><input type="text" name = "frm_t1sheet1_por_cd" style="width:56;" class="input2" value="" readonly="true"></td>
								<td width="25" class="">POL</td>
								<td width="70" class=""><input type="text" name = "frm_t1sheet1_pol_cd" style="width:60;" class="input2" value="" readonly="true"></td>
								<td width="25" class="">POD</td>
								<td width="228" class=""><input type="text" name = "frm_t1sheet1_pod_cd" style="width:56;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_pod_yd_cd" style="width:30;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_pod_nm" style="width:110px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">DEL</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_del_cd" style="width:50px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_del_yd_cd" style="width:30px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_del_nm" style="width:120px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
							</tr>
						</table>

						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">FTZ</td>
								<td width="30" class=""><input type="text" name = "frm_t1sheet1_free_trd_zn_flg" style="width:20;" class="input2" value="" readonly="true"></td>
								<td width="100" class="">Direct Delivery</td>
								<td width="76" class=""><input type="text" name = "frm_t1sheet1_dir_de_flg" style="width:36;" class="input2" value="" readonly="true"></td>
								<td width="" class="" colspan="6"></td>
							</tr>
						</table>
						</td></tr></table>
					<!--  biz_2_1  (E) -->
					</td>
					<td width="19"></td>
					<td width="260" valign="top">
					<!--  biz_2_2  (S) -->
					<!--grid(s)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet1');</script>										
										<script language="javascript">ComSheetObject('t1sheet3');</script>
									</td>
								</tr>
							</table>
						<!--grid(E)-->
					<!--  biz_2_2  (E) -->
						</td>
					</tr>
				</table>
				<!--  biz_2  (E) -->
			<table class="height_5"><tr><td colspan="8"></td></tr></table>
				<!--  biz_3 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="547" valign="top"> 
						<!--  biz_3_1 (S) -->
						<table class="search_sm"" border="0" style="width:100%;"> 
						<tr><td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">&nbsp;PKG</td>
								<td width="58" class=""><input type="text" name = "frm_t1sheet1_pck_qty" style="width:56;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
								<td width="45" class=""><input type="text" name = "frm_t1sheet1_pck_tp_cd" style="width:25;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">WGT</td>
								<td width="72" class=""><input type="text" name = "frm_t1sheet1_act_wgt" style="width:70;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
								<td width="38" class=""><input type="text" name = "frm_t1sheet1_wgt_ut_cd" style="width:35;" class="input2" value="" readonly="true"></td>
								<td width="90" class="" align="right">Contract No.</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_sc_no" style="width:148;" class="input2" value="" readonly="true">&nbsp;<img class="cursor" name="btn_contract_no" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							
							</tr>
							<tr class="h23">
								<td class="" colspan="4">&nbsp;Customs Description</td>
								<td class="" colspan="4"><input type="text" name = "frm_t1sheet1_cstms_desc" style="width:100%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>	
							</tr>
						</table>
						
						<table height="12"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:100%;">
							<tr><td class="title_h"></td>
								<td class="title_s"width="330">Customer Information</td>
								<td>
                                	<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
			           				<tr><td class="btn2_left"></td>
			         		       		<td class="btn2" name="btn_instruction"> Instruction</td>
			               				<td class="btn2_right"></td>
			           				</tr>
			          		  		</table>
                            	</td>
                            	<td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			           				<tr><td class="btn2_left"></td>
			         		       		<td class="btn2" name="btn_pu_history"> P/U History</td>
			               				<td class="btn2_right"></td>
			           				</tr>
			          		  		</table>
                            	</td>
								</tr>
							<tr><td class="height_5"></td></tr>
						</table>
						
						
						
						<table border="0" background-color:white;" class="grid2" width="100%"> 
								<tr><td width="70" class="tr2_head">Shipper</td>
									<td width="62" class="noinput2"><input type="text" name = "frm_t1sheet1_shp_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"> </td> 
									<td width="" class="noinput2"><input type="text" name = "frm_t1sheet1_shp_cust_nm" style="width:388;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"></td></tr>
								<tr><td width="" class="tr2_head">Consignee</td>
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_csg_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"></td> 
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_csg_cust_nm" style="width:368;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"><img class="cursor" name="btn_consignee" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
								<tr><td width="" class="tr2_head">Notify</td>
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_noy_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"></td> 
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_noy_cust_nm" style="width:368;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"><img class="cursor" name="btn_notify" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
								<tr><td width="" class="tr2_head">A.Notify</td>
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_aoy_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"></td> 
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_aoy_cust_nm" style="width:368;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"><img class="cursor" name="btn_a_notify" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
							</table>	
						</td></tr>
					</table>
							
					<!--  biz_3_1  (E) -->
						
						
						</td>
						<td width="15">&nbsp;</td>
						<td width="" valign="top">
						<!--  biz_3_2 (S) -->
						<table class="search_sm"" border="0" style="width:100%;"> 
							<tr><td>
							
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="70" >BDR&nbsp;<input type="checkbox" name = "frm_t1sheet1_bdr_flg" value="" class="trans" disabled></td>
								<td width="100" >C/A<input type="checkbox" value="" name = "frm_t1sheet1_corr_flg" class="trans" disabled><img class="cursor"  name="btn_corr_flg" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="30" class="">Filer</td>
								<td width="62" class=""><input type="text" name = "frm_t1sheet1_cstms_file_tp_cd" style="width:30;" class="input2" value="" readonly></td>
								<td width="53" class="">CUS LOC</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_cstms_loc_cd" style="width:80;" class="input2" value="" readonly></td>
								
							</tr>
						
							<tr class="h23">
								<td width="">MIB No.</td>
								<td class=""><input type="text" name = "frm_t1sheet1_ibd_trsp_no" style="width:100;" class="input2" value="" readonly></td>
								<td width="" colspan="2" align="right">IT Date</td>
								<td class="" colspan="2"><input type="text" name = "frm_t1sheet1_ibd_trsp_iss_dt" style="width:133;" class="input2" value="" readonly></td>
								</tr></table>
							<table height="5"><tr><td></td></tr></table>	
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="70" class="">FRT</td>
								<td width="39" class=""><input type="text" name = "frm_t1sheet1_frt_clt_flg"  style="width:35;" class="input2" value="" readonly></td>
								<td width="144" class=""><input type="text" name = "frm_t1sheet1_frt_clt_lst_dt"   style="width:140;" class="input2" value="" readonly></td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_frt_clt_ofc_cd"  style="width:100%;" class="input2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="" class=""  colspan="3">Collection OFC.</td>
								<td width="" class="" colspan="1"><input type="text" name = "frm_t1sheet1_coll_ofc_cd"  style="width:100%;" class="input2" value="" readonly></td>
							</tr>														
							<tr class="h23">
								<td width="" class="">B/L</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_us_obl_rdem_flg"  style="width:35;" class="input2" value="" readonly></td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_obl_rdem_dt"  style="width:140;" class="input2" value="" readonly></td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_obl_rdem_ofc_cd"  style="width:100%;" class="input2" value="" readonly></td>
							</tr>
							<tr class="h23">
								<td width="" class="">Customs</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_cstms_clr_cd" style="width:35;" class="input2" value="" readonly></td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_cstms_clr_lst_dt" style="width:140;" class="input2" value="" readonly></td>
								<td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			           				<tr><td class="btn2_left"></td>
			         		       		<td class="btn2" name="btn_c_flag">C flag / CNTR</td>
			               				<td class="btn2_right"></td>
			           				</tr>
			          		  		</table>
                            	</td>
							</tr>
						</table>
							
						<table height="5"><tr><td></td></tr></table>
						<table border="0"  class="grid2" style="width:100%;"> 
							<tr class="h23">
								<td  width="170" class="tr2_head">Outstanding Amouts</td>
								<td width="" class="noinput2">
									<select style="width:100%;font-weight:bold;" class="input2" name = "tot_ots_amt"></select></td> 
							</tr>
							<tr class="h23">
								<td  width="170" class="tr2_head">Outstanding Demurrage</td>
								<td width="" class="noinput2">
									<select style="width:100%;font-weight:bold;" class="input2" name = "tot_bil_amt"></select></td> 
							</tr>
							</table>	
							
							
							</td></tr>
						</table>
						<!--grid(E)-->
					<!--  biz_3_2 (E) -->
						
						
						
						</td>
					</tr>
				</table>
				<!--  biz_3  (E) -->
				<table class="height_8"><tr><td colspan="8"></td></tr></table>
				
				
				
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('t1tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
				

				
								<!--TAB US (S) -->
								<div id="t1tabLayer" style="display:inline">				
												
													
									<!-- Containers(total) (S) -->
									<table width="100%" class="grid2"> 
									<tr class="tr2_head3" align="center">
										<td width="34"><input type="text" name = "frm_t1sheet1_1_cntr_cnt" style="width:33; height: 20px; border: #E8E7EC 1px solid;  background-color:#F7E1EC; text-align:center;" value="" readonly></td>
										<td width="92"><strong>Container(s)</strong></td>
										<td width="536"></td>
										<td width="92"><input type="text" name = "frm_t1sheet1_1_wgt_sum" style="width:92; height: 20px; border: #E8E7EC 1px solid;  background-color:#F7E1EC; text-align:right;" value="" readonly></td>
										<td width="48"><input type="text" name = "frm_t1sheet1_1_pkg_sum" style="width:48; height: 20px; border: #E8E7EC 1px solid;  background-color:#F7E1EC; text-align:right;" value="" readonly></td>
										<td></td>
									</tr>
									</table>
								
									<!-- Containers(total) (E) -->
												
									<!-- Grid  (S) -->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t1sheet1_1');</script>
											</td>
										</tr>
									</table>
									<!-- Grid (E) -->
											
								</div>
								<!--TAB US (E) --> 			
											
											
								<!--TAB General (S) -->
								<div id="t1tabLayer" style="display:none">

												<!-- Grid  (S) -->
												<table width="100%"  id="mainTable"> 
													<tr>
														<td width="100%">
															<script language="javascript">ComSheetObject('t1sheet1_2');</script>
															<script language="javascript">ComSheetObject('t1sheet1_3');</script>
															<script language="javascript">ComSheetObject('t1sheet5');</script>
															<script language="javascript">ComSheetObject('t1sheet6');</script>
														</td>
													</tr>
												</table>
											<!-- Grid (E) -->
								
								</div>
								<!--TAB General (E) -->
			
			
				
			</td></tr>
				</table>
			<!-- Grid BG Box  (S) -->
			<!--biz page (E)-->
			
</div>
<!--TAB B/L Info (E) --> 





<!--TAB Cargo Release (S) -->
<div id="tabLayer" style="display:none">		

		<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t2frame" style="width:100%;height:430;" scrolling="no" frameborder='no' border='0' framespacing='0'></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	
</div>
<!--TAB Cargo Release (E) --> 	

<!-- ************************************************************************************************** -->

<!--TAB Movement (S) -->
<div id="tabLayer" style="display:none">
		<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t3frame" style="width:100%;height:430;" scrolling="no"frameborder='no' border='0' framespacing='0'></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->


	
</div>
<!--TAB Movement (E) --> 	


<!-- ************************************************************************************************** -->

<!--TAB Customs Result  (S) -->
<div id="tabLayer" style="display:none">
	
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t4frame" style="width:100%;height:430;" scrolling="no"frameborder='no' border='0' framespacing='0'></iframe>
			</td>
		</tr>
	</table>

	
</div>
<!--TAB Customs Result (E) --> 	


<!-- ************************************************************************************************** -->

<!--TAB S/O Info (S) -->
<div id="tabLayer" style="display:none">

	<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t5frame" style="width:100%;height:430;" scrolling="no" frameborder='no' border='0' framespacing='0'></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (e) -->

	
</div>
<!--TAB S/O Info  (E) --> 	


<!-- ************************************************************************************************** -->


<!--TAB Notice (S) -->
<div id="tabLayer" style="display:none">


	<!-- Grid BG Box (S)-->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t6frame" style="width:100%;height:530;" scrolling="no"frameborder='no' border='0' framespacing='0'></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box (E)-->

	
</div>
<!--TAB Notice (E) --> 	


<!-- ************************************************************************************************** -->


<!--TAB Pickup -->
<div id="tabLayer" style="display:none">

	<!-- Grid BG Box (S)-->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t7frame" style="width:100%;height:600;" scrolling="no" frameborder='no' border='0' framespacing='0'></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG B	ox (E)-->

	
</div>
<!--TAB Customer Insert info (E) --> 	


<!-- ************************************************************************************************** -->


<!--TAB  (S) -->
<div id="tabLayer" style="display:none">


<!--TAB  (E) --> 	


<!-- ************************************************************************************************** -->
	
	<!--biz page (E)-->
				<!-- Grid  (S) -->
							<table width="979"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
			<!-- Grid (E) -->
			
</div>

<!-- 개발자 작업  끝 -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
</body>
</html>