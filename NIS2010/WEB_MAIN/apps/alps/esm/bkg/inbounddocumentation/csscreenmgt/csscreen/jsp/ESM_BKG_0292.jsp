<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292.jsp
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0292Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0292Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (EsmBkg0292Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type='hidden' name ='mainPage' value="<%=JSPUtil.getNull(request.getParameter("mainPage"))%>">
<!-- 개발자 작업	-->
<input type='hidden' name ='h_cntr_no' value = "">
<input type='hidden' name ='h_po_no' value = "">
<input type='hidden' name ='hdn_bl_no' value = "">
<input type='hidden' name ='xmlData' value = "">
<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='h_split' value = "">
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

<!-- TPB Status -->
<input type='hidden' name ='tpb_status'>
<input type='hidden' name ="oaXmlData">
<input type='hidden' name ="refInfo_do_split_flg">
<!-- D/O의 진행 상태 코드 -->
<input type='hidden' name ='rlse_sts_cd'>
<!--최종 D/O의 진행 상태 코드 -->
<input type='hidden' name ='last_rlse_sts_cd'>
<!-- DO 번호-->
<input type='hidden' name ='h_do_no'>
<!---D/O EVENT에서 변경되기 전의 값 -->
<input type='hidden' name ='pre_ctnt'>
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
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_History">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLPreview">B/L&nbsp;Preview</td>
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
					<td width="55">B/L No.</td>
                    <td width="170"><script language="javascript">ComComboObject('combo_bl_no', 1, 125, 0);</script></td>
					<td width="55">BKG No.</td>
					<td width="104"><input type="text" name = "bkg_no" caption="BKG No." maxlength="13" style="width:100;" class="input" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>" dataformat="eng" style="ime-mode:disabled" onChange="conditionReset();"></td>
					<td width="130"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_split" id='split' style="color:red">SPLIT</td>
						<td class="btn2_right"></td>
						</tr>
				</table></td>
						<td align="right">
							<table class="search_sm2" border="0" style="width:390;"> 
							<tr class="h23">
								<td width="95">&nbsp; Container No.</td>
								<td width="130"><input type="text" name = "cntr_no" caption="Container No." style="width:100;" class="input" value="" dataformat="eng" maxlength="11" style="ime-mode:disabled" ></td>
								<td width="50">P/O No.</td>
								<td width=""><input type="text" name = "po_no" caption="Po No." style="width:100;" class="input" value="" dataformat="eng1" style="ime-mode:disabled" ></td>
				
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
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->


<!--TAB B/L Info(S) -->

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
								<td width="288" class=""><input type="text" name = "frm_t1sheet1_arrival_vvd_nm" style="width:166;" class="input2" value="" readonly="true"></td>
								<td width="63" class="">Partial</td>
								<td width="76" class=""><input type="text" name = "frm_t1sheet1_partial" style="width:51;" class="input2" value="" readonly="true"></td>
								<td width="80" class="">T/S Route</td>
								<td width="" class=""><img class="cursor" name="btn_ts_route" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" ></td>
							
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">ETA</td>
								<td width="147" class=""><input type="text" name = "frm_t1sheet1_vps_eta_dt" style="width:125;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">ATA</td>
								<td width="149" class=""><input type="text" name = "frm_t1sheet1_vps_etb_dt" style="width:116;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">Lane</td>
								<td width="59" class=""><input type="text" name = "frm_t1sheet1_slan_cd" style="width:43;" class="input2" value="" readonly="true"></td>
								<td width="63" class="">RCV Term</td>
								<td width="76" class=""><input type="text" name = "frm_t1sheet1_rcv_term_cd" style="width:51;" class="input2" value="" readonly="true"></td>
								<td width="78" class="">DEL Term</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_de_term_cd" style="width:20;" class="input2" value="" readonly="true"></td>
							
							</tr>
						</table>
						
						
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">POR</td>
								<td width="66" class=""><input type="text" name = "frm_t1sheet1_por_cd" style="width:56;" class="input2" value="" readonly="true"></td>
								<td width="27" class="">POL</td>
								<td width="80" class=""><input type="text" name = "frm_t1sheet1_pol_cd" style="width:60;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">POD</td>
								<td width="212" class=""><input type="text" name = "frm_t1sheet1_pod_cd" style="width:56;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_pod_yd_cd" style="width:30;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_pod_nm" style="width:102px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">DEL</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_del_cd" style="width:50px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_del_yd_cd" style="width:30px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_del_nm" style="width:120px;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
							</tr>
						</table>
						
						</td></tr></table>
					<!--  biz_2_1  (E) -->
					
					</td>
					<td width="19"></td>
					<td width="260" valign="top">
					
					<!--  biz_2_2  (S) -->
					
						<!--grid(s)-->
						<!-- Grid  (S) -->
							<table width="100%" id="mainTable"> 
								<tr>
									<td width="100%"> 
										<script language="javascript">ComSheetObject('t1sheet1');</script>										
										<script language="javascript">ComSheetObject('t1sheet2');</script>
									</td>
								</tr>
							</table>
						<!-- Grid (E) -->
						<!--grid(E)-->
					<!--  biz_2_2  (E) -->
				</td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="587" valign="top">
						<table class="search_sm" border="0" style="width:100%;"> 
							<tr class="h23"><td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="30" class="">&nbsp;PKG</td>
								<td width="58" class=""><input type="text" name = "frm_t1sheet1_pck_qty" style="width:56;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
								<td width="45" class=""><input type="text" name = "frm_t1sheet1_pck_tp_cd" style="width:25;" class="input2" value="" readonly="true"></td>
								<td width="30" class="">WGT</td>
								<td width="72" class=""><input type="text" name = "frm_t1sheet1_act_wgt" style="width:70;text-align:right;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>
								<td width="38" class=""><input type="text" name = "frm_t1sheet1_wgt_ut_cd" style="width:35;" class="input2" value="" readonly="true"></td>
								<td width="90" class="" align="right">Contract No.</td>
								<td width="" class=""><input type="text" name = "frm_t1sheet1_sc_no" style="width:188;" class="input2" value="" readonly="true">&nbsp;<img class="cursor" name="btn_contract_no" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							
							</tr>
							<tr class="h23">
								<td class="" colspan="4">&nbsp;Customs Description</td>
								<td class="" colspan="4"><input type="text" name = "frm_t1sheet1_cstms_desc" style="width:100%;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="input2" value="" readonly="true"></td>	
							</tr>
						</table>
						<table height="15"><tr><td></td></tr></table>
						<table border="0" background-color:white;" class="grid2" width="100%"> 
								<tr><td width="70" class="tr2_head">Shipper</td>
									<td width="62" class="noinput2"><input type="text" name = "frm_t1sheet1_shp_cust_cd" style="width:60;" class="noinput2" value="" readonly="true"> </td> 
									<td width="" class="noinput2"><input type="text" name = "frm_t1sheet1_shp_cust_nm" style="width:430;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"></td></tr>
								<tr><td width="70" class="tr2_head">Consignee</td>
									<td width="60" class="noinput2" ><input type="text" name = "frm_t1sheet1_csg_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"></td> 
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_csg_cust_nm" style="width:410;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"><img class="cursor" name="btn_consignee" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
								<tr><td width="70" class="tr2_head">Notify</td>
									<td width="60" class="noinput2" ><input type="text" name = "frm_t1sheet1_noy_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"></td> 
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_noy_cust_nm" style="width:410;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"><img class="cursor" name="btn_notify" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
								<tr><td width="70" class="tr2_head">A.Notify</td>
									<td width="60" class="noinput2" ><input type="text" name = "frm_t1sheet1_aoy_cust_cd" style="width:62;" class="noinput2" value="" readonly="true"></td> 
									<td width="" class="noinput2" ><input type="text" name = "frm_t1sheet1_aoy_cust_nm" style="width:410;overflow:hidden;text-overflow:ellipsis;font-weight:normal;" class="noinput2" value="" readonly="true"><img class="cursor" name="btn_a_notify" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
							</table>	
						</td></tr>
					</table>
						</td>
						<td width="15"></td>
						<td width=""  valign="top">
						<table class="search_sm" border="0" style="width:100%;"> 
							<tr class="h23"><td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="115">&nbsp;BKG STS </td>
								<td width="60"><input type="text" name = "frm_t1sheet1_bkg_sts_cd" style="width:30;" class="input2" value="" readonly="true"></td>
								<td width="80">BDR<input type="checkbox" name = "frm_t1sheet1_bdr_flg" value="" class="trans" disabled></td>
								<td width="" >C/A<input type="checkbox" value="" name = "frm_t1sheet1_corr_flg" class="trans" disabled><img class="cursor" name="btn_corr_flg"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="115">&nbsp;Customs Ref. No.</td>
								<td><input type="text" name = "frm_t1sheet1_cust_ref_no" style="width:132;" class="input2" value="" readonly="true">
								<input type="text" name = "frm_t1sheet1_cust_ref_nm" style="width:110;" class="input2" value="" readonly="true"></td>	
							</tr>
						</table>
						<table height="5"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="70" class="">&nbsp;FRT</td>
								<td width="45" class="" ><input type="text" name = "frm_t1sheet1_frt_flg" style="width:42;" class="input2" value="" readonly="true"></td> 
								<td width="142" class="" ><input type="text" name = "frm_t1sheet1_frt_dt" style="width:109;" class="input2" value="" readonly="true"></td> 
								<td width="40" class="">Office</td>
								<td width="" class="" ><input type="text" name = "frm_t1sheet1_frt_ofc_cd" style="width:64;" class="input2" value="" readonly="true"></td> 
							</tr>
							<tr class="h23">
								<td class="">&nbsp;B/L</td>
								<td class="" ><input type="text" name = "frm_t1sheet1_obl_rdem_flg" style="width:42;" class="input2" value="" readonly="true"></td> 
								<td class="" ><input type="text" name = "frm_t1sheet1_obl_rdem_dt" style="width:109;" class="input2" value="" readonly="true"></td> 
								<td class="">Office</td>
								<td width="" class="" ><input type="text" name = "frm_t1sheet1_obl_rdem_ofc_cd" style="width:64;" class="input2" value="" readonly="true"></td> 
							</tr>
						</table>
							
						<table height="10"><tr><td></td></tr></table>
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
				</td></tr>
					</table>
				<!--  biz_2  (E) -->
				<table height="10"><tr><td></td></tr></table>
				<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet3');</script>
										<script language="javascript">ComSheetObject('t1sheet4');</script>
										<script language="javascript">ComSheetObject('t1sheet6');</script>										
										<script language="javascript">ComSheetObject('t1sheet7');</script>										
									</td>
								</tr>
							</table>
			<!-- Grid (E) -->
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
</div>

<!--TAB B/L Info(E) -->


<!--TAB Movement (S) -->

<div id="tabLayer" style="display:none">
		<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t1frame" style="width:100%;height:430;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	
</div>

<!--TAB Movement (E) -->



<!--TAB Cargo Release (S) -->

<div id="tabLayer" style="display:none">
	<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t2frame" style="width:100%;height:480;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
		
</div>
<!--TAB Cargo Release (E) -->


<!--TAB S/O Info (S) -->
<div id="tabLayer" style="display:none">  
	<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t3frame" style="width:100%;height:430;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	
</div>
<!--TAB S/O Info (E) --> 


<!--TAB A/N & Invoice (S) -->
<div id="tabLayer" style="display:none">  
	<!-- Grid BG Box  (S) -->
   	<table class="search" id="mainTable">
	   	<tr>
	   		<td>
				<iframe name="t4frame" style="width:100%;height:500;" scrolling="no" frameborder='no' border='0' framespacing='0' src="about:blank"></iframe>
			</td>
		</tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	

</div>
<!--TAB A/N & Invoice (E) --> 

<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
</td></tr>
</table>

<!-- Grid  (S) -->
<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
<!-- Grid (E) -->

<!-- 개발자 작업  끝 -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
</body>
</html>