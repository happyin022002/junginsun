<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0292_02.jsp
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029202Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg029202Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (EsmBkg029202Event)request.getAttribute("Event");
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
<title>Inbound C/S Screen(Cargo Release)</title>
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

<!-- 개발자 작업	-->
<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
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
<input type='hidden' name ="blInfo_do_split_flg">
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

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
<!--TAB Cargo Release (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">

			<!--  biz_1  
			<table border="0" style="width:979; background-color:white;" class="grid2">
				<tr class="tr2_head">
					<td width="6%">POR</td>
					<td width="6%">POL</td>
					<td width="6%">POD</td>
					<td width="6%">	DEL</td>
					<td width="7%">	DEL Term</td>
					<td width="13%">Arrival Vessel</td>
					<td width="9%">ETA</td>
					<td width="" colspan="2">PKG</td>
					<td width="" colspan="2">WGT</td>
					<td width="" colspan="2">MEA</td>
					<td width="12%">Discharging CY</td>
					<td width="4%">Partial</td>
					<td width="" nowrap>SOC</td>
				</tr>
				<tr class="input2" align="center">
					<td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_por_cd"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_pol_cd"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_pod_cd"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_del_cd"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_de_term_cd"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_arrival_vessel"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_vps_eta_dt"></td>
			        <td width="6%"><input type="text" style="width: 100%; text-align: right" class="noinput2" readonly="true" name="blInfo_pck_qty"></td>
			        <td width="4%"><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_pck_tp_cd"></td>
			        <td width="7%"><input type="text" style="width: 100%; text-align: right" class="noinput2" readonly="true" name="blInfo_act_wgt"></td>
			        <td width="4%"><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_wgt_ut_cd"></td>
			        <td width="7%"><input type="text" style="width: 100%; text-align: right" class="noinput2" readonly="true" name="blInfo_meas_qty"></td>
			        <td width="4%"><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_meas_ut_cd"></td>
			        <td><input type="text" style="width:100%;" class="noinput2" readonly="true" name="blInfo_dsch_loc"></td>
			        <td><input type="text" style="width:50;color:red; font-weight:bold;text-align: center" class="noinput2" readonly="true" name="blInfo_cntr_prt_flg"></td>
			        <td><input type="text" style="width: 100%; text-align: center" class="noinput2" readonly="true" name="blInfo_soc_flg"></td>					
				</tr>
				</table>
			
			<table class="height_5"><tr><td></td></tr></table>
			
			<table border="0" style="width:979; background-color:white;" class="grid2">
			<tr class="h23" align="center">
				<td width="70" class="tr2_head" nowrap>Consignee</td>
				<td width="210" class="noinput2"><input type="text" name="blInfo_ccust_nm" style="width:100%;text-align:left;" class="noinput2" readonly="true"></td>	
				<td width="" class="noinput2"><input type="text" name="blInfo_ccust_addr"  style="width:100%;text-align:left;" class="noinput2" readonly="true"></td>	
			</tr>
			<tr class="h23" align="center">
				<td width="" class="tr2_head" nowrap>Notify</td>
				<td width="" class="noinput2"><input type="text" name="blInfo_ncust_nm"   style="width:100%;text-align:left;" class="noinput2" readonly="true"></td>	
				<td width="" class="noinput2"><input type="text" name="blInfo_ncust_addr" style="width:100%;text-align:left;" class="noinput2" readonly="true"></td>	
			</tr>
			</table> 
			 biz_1   (E) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="979">
					<table class="search" border="0" style="width:270;"> 
					<tr class="h23">
						<td width="144">
						<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">D/O No. Split By CNTR</td></tr>
						</table></td>
						<td class="stm">
							<input type="radio" onclick="setSplitFlag('N');" class="trans" value="N" name="split_flg" disabled>No&nbsp;&nbsp;
							<input type="radio" onclick="setSplitFlag('Y');" class="trans" value="Y" name="split_flg" disabled>Yes
						
					</tr>
					</table> 
					</td>					
						
			</tr>
			</table> 
			
			
			<!--  biz_2  (S) -->
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<!--EU D/O Release 기본 정보-->
							<script language="javascript">ComSheetObject('blInfo');</script>
							<script language="javascript">ComSheetObject('euDoRlseStsCntr');</script>
							<script language="javascript">ComSheetObject('euDoRlseStsBl');</script>
						</td>
					</tr>
				</table>
			<!-- Grid  (E) -->
			
			
			
				<!--  biz_2   (E) -->

			<table class="height_5"><tr><td></td></tr></table>

			<!--  biz_3  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="545">
					<!--  biz_3 _1 (S) -->
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="196">
                                <table class="search" border="0">
                                <tr><td class="title_h"></td>
                                    <td class="title_s">Bill of Lading Status</td></tr>
                                </table>
                            </td>
							<td width="30"><input type="text" name="blInfo_obl_rdem_flg" style="width:25; color:blue; font-weight:bold;text-align:center;" class="input2" readonly="true">
							<td width="30" align='right'>No</td>
							<td width="140"><input type="text" name="blInfo_obl_cpy_knt" style="width:25;color:black;text-align:center; font-weight:bold;" class="input2" readonly="true"></td>
							<td width="40">
                                <table class="search" border="0">
                                <tr><td class="title_h"></td>
                                    <td class="title_s">TPB</td></tr>
                                </table>
                            </td>
							<td width="20"><img src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon"></td>
							<td width="50"><input type="text" style="width:20;;text-align:center;" name='tpb_cd' class="input2" readonly="true">&nbsp;<img class="cursor" name="btn_tpb" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="">
		                        <input type="text" name='hold_flag' style="width:50;;text-align:center;" class="input2_1" readonly="true"><input type="hidden" name='blInfo_do_hld_flg'>
							</td>
						</tr>
						</table> 
						<table class="height_2"><tr><td></td></tr></table>

						 <table class="search_sm" border="0" style="width:100%">
                        <tr class="h23">
                            <td width="110">B/L Issue</td>
                            <td width="40"><input type="text" name="blInfo_bl_tp_cd" style="width:89%;text-align:center;" class="input2" readOnly></td>
                            <td width="25">OFC</td>
                            <td width="140">
                                <input type="text" name="blInfo_obl_iss_ofc_cd" style="width:60;" class="input2" readOnly>
                                <input type="text" name="blInfo_obl_iss_usr_id" style="width:70;" class="input2" readOnly></td>
                            <td width="20">DT</td>
                            <td width="205">
                                <input type="text" name="blInfo_obl_iss_dt" style="width:110;" class="input2" readOnly><input type="text" style="width:20;text-align:center;" value="" class="noinput2" readOnly></td>
                       	   </tr>
                       	    <tr class="h23">
                            <td class="">B/L Receive</td>
                            <td class=""><input type="text" name="blInfo_obl_rdem_knt" style="width:89%;text-align:center;" class="input2" readonly="true"></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_obl_rdem_ofc_cd" style="width:60;text-align:center;" class="input2" readonly="true">
                                <input type="text" name="blInfo_obl_rdem_usr_id" style="width:70;text-align:center;" class="input2" readonly="true"></td>
                            <td class="">DT</td>
                            <td class="">
                                <input type="text" name="blInfo_obl_rdem_dt" style="width:110;text-align:center;" class="input2" readonly="true">
                                <input type="text" name="bl_surr_rmk_flg" style="width:60;text-align:center;" class="noinput2" readonly="true">&nbsp;<img id="div_btn_bl_surr_flg" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_bl_surr_rmk"></td>
                        </tr>
							
						 <tr class="h23">
                            <td class="">Other DOC RCV</td>
                            <td class="">
                                <input type="text" name="blInfo_bl_otr_doc_rcv_cd" style="width:89%;" class="input2" value="" readonly="true">
                            </td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_otr_doc_rcv_ofc_cd" style="width:60;" class="input2" readonly="true">
                                <input type="text" name="blInfo_otr_doc_rcv_usr_id" style="width:70;" class="input2" readonly="true"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_otr_doc_rcv_dt" style="width:110;" class="input2" readonly="true">
                                <input type="text" name="blInfo_otr_doc_cgor_flg" style="width:83;text-align:center;" class="input2" value="" readonly="true">
                            </td>
                        </tr>
						<tr class="h23">
                            <td class="">Inbond DOC RCV</td>
                            <td class="">
                                <input type="text" name="blInfo_ibd_doc_rcv_flg" style="width:89%;" class="input2" value="" readonly="true">
                            </td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_ibd_doc_rcv_ofc_cd" style="width:60;" class="input2" value="" readonly="true">
                                <input type="text" name="blInfo_ibd_doc_rcv_usr_id" style="width:70;" class="input2" value="" readonly="true"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_ibd_doc_rcv_dt" style="width:110;" class="input2" value="" readonly="true">
                                <input type="text" style="width:20;" class="noinput2" value="" readonly="true"></td>
                        </tr> 
							
						</table>
					<!--  biz_3 _1 (E) -->
					</td>
					<td width="10">&nbsp;</td>
					<td width="424">
					<!--  biz_3 _2 (S) -->
			            <table class="search" border="0" style="width:100%;">
			            <tr class="h23">
			                <td width="160">
                                <table class="search" border="0">
                                <tr><td class="title_h"></td>
                                    <td class="title_s">Freight Received Status</td></tr>
                                </table>
                            </td>
			                <td width="">
			                    <input type="text" style="width:20;text-align:center;" class="input2_1"name='blInfo_tot_ots_sts_cd'>
			                    <select style="width:150;font-weight:bold;" class="input2" name='t3_tot_ots_amt'></select>
			                </td>
			                <td align="right">
			                    <table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
			                    <tr>
			                        <td class="btn2_left"></td>
			                        <td class="btn2" name="btn_erp">ERP</td>
			                        <td class="btn2_right"></td>
			                    </tr>
			                    </table>
			                </td>
			            </tr>
			            <tr><td height="3"></td></tr>
			            </table>
						 <table class="search_sm" border="0" style="width:100%">
                        <tr class="h23">
                           		 <td>PPD1</td>
                            	<td width="60" class="" align="left"><input type="text" name="blInfo_ppt_sts_cd" style="width:27;text-align:center;" class="input2" readonly="true"></td>
                            	<td>OFC</td>
                            	<td>
                                <input type="text" name="blInfo_ppt_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readOnly>
                                <input type="text" name="blInfo_ppt_rcv_usr_id" style="width:70;text-align:left;" class="input2" readOnly></td>
                           		 <td width="20" class="">DT</td>
                           		 <td width=""  class="" nowrap><input type="text" name="blInfo_ppt_rcv_dt" style="width:125;text-align:center;" class="input2" readOnly></td>
                        	</tr>
                        	<tr class="h23">
                            <td class="">CCT1</td>
                            <td class="" align="left"><input type="text" name="blInfo_cct_sts_cd" style="width:27;text-align:center;color:red;" class="input2" readonly="true">&nbsp;<img id="div_btn_cct" src="img/btns_search.gif" name="btn_cct" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                            <td class="">OFC</td>
                            <td class="">
                               <input type="text" name="blInfo_cct_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readonly="true">
                                <input type="text" name="blInfo_cct_rcv_usr_id" style="width:70;text-align:left;" class="input2" readonly="true"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_cct_rcv_dt" style="width:125;text-align:center;" class="input2" readonly="true"></td>
                           </tr>
							<tr class="h23">
                            <td class="">PPD2</td>
                            <td width="40" class="" align="left"><input type="text" name="blInfo_n3pty_ppt_sts_cd" style="width:27;text-align:center;" class="input2" readonly="true"></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_n3pty_ppt_rcv_ofc_cd" style="width:60;text-align:left;" class="input2" readonly="true">
                                <input type="text" name="blInfo_n3pty_ppt_rcv_usr_id" style="width:70;text-align:left;" class="input2" readonly="true"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_n3pty_ppt_rcv_dt" style="width:125;text-align:center;" class="input2" readonly="true"></td>
                           </tr>
							<tr class="h23">
                            <td class="">CCT2</td>
                            <td class=""><input type="text" name="blInfo_n3pty_cct_sts_cd" style="width:27;text-align:center;color:red;" class="input2" readonly="true">&nbsp;<img id="div_btn_third_cct" src="img/btns_search.gif" name="btn_third_cct" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                            <td class="">OFC</td>
                            <td class="">
                                <input type="text" name="blInfo_n3pty_cct_rcv_ofc_cd" style="width:60;text-align:center;" class="input2" readonly="true">
                                <input type="text" name="blInfo_n3pty_cct_rcv_usr_id" style="width:70;text-align:center;" class="input2" readonly="true"></td>
                            <td class="">DT</td>
                            <td class=""><input type="text" name="blInfo_n3pty_cct_rcv_dt" style="width:125;" class="input2" readonly="true"></td>
                           </tr>
							
						</table>
					<!--  biz_3 _2 (E) -->
					</td></tr>
				</table>

                <!-- *********************** WEB OB/L 체크 추가 ************************ -->
                <table class="search" border="0">
                        <tr>
                        <td>
                        	<table border='0'>
			                        <tr class="h23" id="web_print">
			                            <td width="150">
											<table border="0" width="100%">
												<tr>
													<td class="title_h"></td>
													<td class="title_s" width="135">Web OB/L Serial No.</td>
												</tr>
											</table>
										</td>
										<td width="107" align="center" id="obl_inter_ser_no"></td>
                                        <td width="90" align="center" id="obl_inter_ser_no_chk_title" height="30"></td>
			                            <td width="20" align="center" >ID</td>
			                            <td width="100"><input type="text" name="obl_inter_ser_no_chk_usr_id" style="width:80;" class="input2" readOnly></td>
			                            <td width="20" align="center" >DT</td>
			                            <td width="130"><input type="text" name="obl_inter_ser_no_chk_dt" style="width:120;" class="input2" readOnly></td>
			                        </tr>                        	
                        	</table>
                        </td>
                        </tr>
                </table>
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <!-- *********************** WEB OB/L 체크 추가 END ************************ -->
				
				<!--  biz_3   (E) -->
				<table class="height_8"><tr><td></td></tr></table>
			
			
			    <table class="search" border="0" style="width:979">
			    <tr class="h23">
			    	<td width="210">
                        <table class="search" border="0">
                        <tr><td class="title_h"></td>
                            <td class="title_s">Demurrage Status/Outstanding</td></tr>
                        </table>
                    </td>
                     <td width="200">
                        <input type="text" name='demur_sts' style="width:25; color:red; font-weight:bold;" class="input2" readonly="true">&nbsp;
                        <select style="width:160;font-weight:bold;" class="input2" name='t3_tot_bil_amt'></select>
                    </td>
			        <td width="170">
                        <table class="search_sm2" border="0" style="width:160">
                        <tr class="h23">
                            <td width="">Demurrage Type&nbsp;
                            <input type="text" name='demur_type' style="width:35;" class="input2" readonly="true"></td>
                        </tr>
                        </table>
                    </td>
                    <td width="">
                        <table class="search_sm2" border="0" style="width:100%">
                        <tr class="h23">
                            <td width="">Expect Delivery Date</td>
                            <td width=""><input type="text" name='exp_del_dt' style="width:75;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd" minlength="8" maxlength="8" required="true">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='img_exp_del_dt'>&nbsp;&nbsp;</td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			           			<tr><td class="btn2_left"></td>
			         		       <td class="btn2" name="btn_dem_retrieve">Retrieve</td>
			               		<td class="btn2_right"></td>
			           			</tr>
			          		  </table>
                            </td>
                        </tr>
                        </table>
					</td>
					<td width="70" align="right">
                        <table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btn_dmdt">DMDT</td>
                            <td class="btn2_right"></td>
                         </tr>
                         </table>
                    </td>
			          
			    </tr>
			    </table>
			
			
			<table class="height_2"><tr><td></td></tr></table>
			<!--  biz_4   (E) -->
			
			    <!-- Grid  (S) -->
			    <table width="100%"  id="mainTable">
			    <tr>
			        <td width="100%">
			            <!--Demurrage-->
			            <script language="javascript">ComSheetObject('demInfo');</script>
                        <script language="javascript">ComSheetObject('demDtl');</script>			            
						<!--Total Billable Amount-->
						<script language="javascript">ComSheetObject('totBlbAmt');</script>
			        </td>
			    </tr>
			    </table>
			    <!-- Grid (E) -->
			    <table class="height_5"><tr><td colspan="8"></td></tr></table>
			     <table class="search" border="0" style="width:979">
                 <tr class="h23"><td width="49%">
			    
			   <table border="0" style="width:100%; background-color: white;" class="grid2">
                        <tr class="h23" align="center">
                            <td width="100%" class="tr2_head">O/B Remark(s)</td>
                        </tr>
                        <tr class="h23" align="center">
                            <td width="" class="noinput2"><textarea style="width: 100%; height:18" name='blInfo_obl_iss_rmk' class="noinput2" readonly></textarea></td>
                        </tr>
                        </table>
				</td>
				<td width="2%"></td>
				<td width="49%">
			    
			    <table border="0" style="width:100%;" class="grid2"> 
					<tr>
						<td width="410" class="tr2_head">Hold / Internal  Remark(s)</td>
						<td align="center"><table width="67" border="0" cellpadding="0" cellspacing="0" class="button">
                      		  <tr><td class="btn2_left" style="border;0 !important; padding:0 !important;"></td>
                            <td class="btn2" name="btn_save" style="border;0 !important; padding:0 !important;">Save</td>
                            <td class="btn2_right" style="border;0 !important; padding:0 !important;"></td>
                 </table></td>
					</tr>
					<tr class="h23" align="center">
						<td width="" colspan="2"><textarea style="width:100%; height:20" name='blInfo_inter_rmk' onKeyDown="fncTextareaMaxLine(this.value)"></textarea></td>
					</tr>
					</table>
				</td></tr>
			</table>
			
	<!-- Grid BG Box  (S) -->	
	</td>
			</tr>
			</table>
</div>
<!--TAB Cargo Release (E) -->
	</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>