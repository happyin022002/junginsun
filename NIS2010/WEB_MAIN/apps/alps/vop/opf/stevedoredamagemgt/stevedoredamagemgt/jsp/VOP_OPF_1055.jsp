<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1055.jsp
*@FileTitle : Stevedore Damage Detail - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1053Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopOpf1053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String office_cd		= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String mailContent = "[Concerned Office]"
        + "<br> -MOC:pusmoc@hanjin.com"
        + "<br> -PLF:chartering@hanjin.com"
        + "<br> -LIL:flyminie@hanjin.com"
        + "<br> -MFS:hsjin@hanjin.com"
        + "<p> ";
	
	String sdmsNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	office_cd = account.getOfc_cd();
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (VopOpf1053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		sdmsNo = StringUtil.xssFilter(request.getParameter("stv_dmg_no"));
		//Test!!!!!!!!!!!!!!!!
		//sdmsNo = "HNOS0900101";

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
<title>Stevedore Damage Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=strUsr_id%>', '<%=strUsr_nm%>', '<%=office_cd%>');
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" name="com_mrdSaveDialogFileName" value="StevedoreDamageDetail">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdTitle" value="Stevedore Damage Detail">
<input type="hidden" name="com_mrdBodyTitle" value="Stevedore Damage Detail">

<!-- 개발자 작업	-->

<input type="hidden" name="com_rdSubSysCd" value="OPF">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">
<input type="hidden" name="com_fromName" value="">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>">
<input type="hidden" name="com_blindCarbonCopy">
<input type="hidden" name="com_subject" value="Re:SDMS Application">
<input type="hidden" name="com_fileKey">
<input type="hidden" name="com_content">
<input type="hidden" name="default_content" value="<%=mailContent%>">
<input type="hidden" name="com_templateMrd" value="VOP_OPF_1153.mrd">
<input type="hidden" name="com_templateMrdArguments">
<input type="hidden" name="com_templateMrdDescription" value="UI_OPF_1153.mrd 파일이 첨부되었습니다.">
<input type="hidden" name="stv_dmg_no" value="<%=sdmsNo %>">
<input type="hidden" name="office_cd" value="<%=office_cd%>">

<!-- hidden Grid (S)-->
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet1');</script>
	<script language="javascript">ComSheetObject('sheet2');</script>
	<script language="javascript">ComSheetObject('sheet3');</script>
	<script language="javascript">ComSheetObject('sheet4');</script>
	<script language="javascript">ComSheetObject('sheet5');</script>
    <script language="javascript">ComSheetObject('sheet6');</script>
    
    <script language="javascript">ComSheetObject('sheet7');</script>
    <script language="javascript">ComSheetObject('sheet8');</script>
    <script language="javascript">ComSheetObject('sheet9');</script>
    
    <script language="javascript">ComSheetObject('sheet10');</script>
    <script language="javascript">ComSheetObject('sheet11');</script>
    <script language="javascript">ComSheetObject('sheet12');</script>
    <script language="javascript">ComSheetObject('sheet13');</script>

    <script language="javascript">ComSheetObject('sheet14');</script>
    <script language="javascript">ComSheetObject('sheet15');</script>
    
    <script language="javascript">ComSheetObject('sheet20');</script>
    <script language="javascript">ComSheetObject('sheet21');</script>
    
    <script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>', 400,300);</script>
</div>
<!-- hidden Grid (E)-->

<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Stevedore Damage Detail - Inquiry </td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">
 
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:959;">
				<tr class="h23">
					<td width="70">VVD CD</td>
					<td width="150"><input type="text" name="vsl_cd" style="width:40;text-align:center;" class="input2" readonly>&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;" class="input2" readonly>&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;" class="input2" readonly></td>
					<td width="40">Port</td>
					<td width="100"><input type="text" name="vps_port_cd" style="width:60;text-align:center;" class="input2" readonly></td>
					
					<td width="90">Damage Date</td>
					<td width="120"><input type="text" style="width:75;" maxlength="8" class="input2" dataformat="ymd" caption="Damage Date" name="stv_dmg_evnt_dt" readonly>&nbsp;</td>
					<!-- <img src="img/btns_calendar.gif" name="btn_stv_dmg_evnt_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					 -->
					<td width="35">Lane</td>
					<td width="60"><input type="text" style="width:40;text-align:center;" class="input2" name="slan_cd" readonly></td>
				
					<td width="110">Vessel Category</td>
					<td width=""><script language="javascript">ComComboObject('vsl_oshp_cntr_blk_tp_cd',1,150,1,1,1);</script></td>					
					</tr>
				</table>
				<table class="search" border="0" style="width:959;">
				<tr class="h23">
					<td width="70">SDMS No.</td>
					<td width="595"><input type="text" name="stv_dmg_no_temp" style="width:113;" class="input2" value="<%=sdmsNo.substring(0,4)+'-'+sdmsNo.substring(4)%>" readonly></td>
					<td width="110">Damage Category</td>
					<td width=""><script language="javascript">ComComboObject('stv_dmg_prt_cate_cd',1,150,1,1,1);</script></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr></table>
		<!-- 1 (E) -->

		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
		<!-- Tab (E) -->


<!-- (TAB) [ Damage ] (S) -->
<div id="tabLayer" style="display:inline">

		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:400" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="130">Claim Handling Office</td>
					<td width="150"><input type="text" name="clm_hndl_ofc_cd" caption="Claim Handling Office" style="width:70;ime-mode:disabled;text-align:center;" maxlength="6" class="input1" required></td>
					<td width="30">PIC</td>
					<td width="210">
					<table width="100%" border="0">
					<tr>
						<td width="150" style="padding-left:2;padding-top:2;">
						<script language="javascript">ComSheetObject('sheet0');</script>
						</td>
					</tr>
					</table>
					</td>
					<td width="40">Part</td>
					<td width="210"> <script language="javascript">ComComboObject('stv_dmg_prt_cd',2,150,1,1,1);</script></td>
					<td width="60">Damage</td>
					<td align="right"> <script language="javascript">ComComboObject('stv_dmg_tp_cd',2,120,1,0,1);</script></td>
				</tr> 
				<tr class="h23">
					<td>Location / Size / Qty</td>
					<td colspan="7" align="right"><input type="text" style="width:100%;ime-mode:disabled;" class="input" name="stv_dmg_loc_desc" maxlength="500"></td>
				</tr> 
				<tr class="h23">
					<td>Supporting</td>
					<td colspan="7" style="padding-left:2;">
					
							<!-- supporting (S) -->
				    		<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_SDR">SDR</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="145" class="stm">
									<input type="text" name="stv_dmg_rpt_atch_knt" style="width:45; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Picture">Picture</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="183" class="stm">
									<input type="text" name="stv_dmg_pict_atch_knt" style="width:45; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Document">Document</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="140" class="stm">
									<input type="text" name="stv_dmg_doc_atch_knt" style="width:45; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								</tr>
							</table>
							<!-- supporting (S) -->
					
					</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr><td colspan="8" height="3"></td></tr>
				<tr class="h23">
					<td width="150">Related Damage</td>
					<td width="380" style="padding-left:2">
					
						<table border="0" style="width:330;" class="search_sm2"> 
							<tr class="h23">
								<td width="" class="stm" style="font-size:12;">
									<input type="checkbox" class="trans" name="cntr_dmg_flg" value="Y">&nbsp;Damage on Container&nbsp;&nbsp;
									<input type="checkbox" class="trans" name="cgo_dmg_flg" value="Y">&nbsp;Damage on Cargo</td></tr>
						</table>
						
					</td>
					<td width="61">CNTR No.</td>
					<td><input type="text" style="width:135;" class="input" maxlength="14" name="cntr_no"></td>
				</tr> 
				<tr><td colspan="8" height="3"></td></tr>
				</table>				
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="150">Time Loss (Hours)</td>
					<td width="115"><input type="text" style="width:50;" class="input2" name="time_loss_hours" readonly></td>
					<td width="80">From (GMT)</td>
					<td width="184"><input type="text" style="width:135;" class="input" name="fm_tm_lss_dt" caption="From Loss Hour" maxlength="12" dataformat="ymdhm" fullfill></td>
					<td width="62" style="padding-left:2">To (GMT)</td>
					<td><input type="text" style="width:135;" class="input" name="to_tm_lss_dt" caption="To Loss Hour" maxlength="12" dataformat="ymdhm" fullfill></td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="149">Remark(s)</td>
					<td colspan="5"><textarea style="width:100%; height:45;ime-mode:disabled;" name="stv_dmg_rmk"></textarea></td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:959;"> 
				<tr><td colspan="8" class="line_bluedot"></td></tr>
				<tr class="h23">
					<td width="150">Requirement</td>
					<td width="340">
					
						<table border="0" style="width:300;" class="search_sm2"> 
							<tr class="h23">
								<td width="" class="stm" style="font-size:12;">
									<input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="R" checked>&nbsp;Repair&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="S">&nbsp;Supply&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="Q">&nbsp;Quotation</td></tr>
						</table>
						
					</td>
					<td width="75">Voyage No.</td>
					<td width="112"><input type="text" style="width:53;ime-mode:disabled;" maxlength="5" fullfill class="input" name="req_skd_voy_dir" caption="Voyage No"><input type="text" style="width:0;" name="noname"></td>
					<td width="35">Port</td>
					<td width="112">
						<div id="comboReqPortCd" style="display:none;"><script language="javascript">ComComboObject('combo_req_port_cd', 3, 70, 1,1,0);</script></div>
						<div id="inputReqPortCd" style="display:inline;"><input type="text" style="width:53;ime-mode:disabled;text-align:center;" maxlength="5" fullfill class="input" name="req_port_cd" caption="Voyage No"></div>
					</td>
					<td width="30">ETA</td>
					<td align="right"><input type="text" style="width:75;" maxlength="8" class="input" dataformat="ymd" caption="ETA Date" name="req_eta_dt">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td colspan="2"></td>
					<td>Reason</td>
					<td colspan="5" style="padding-left:2">
						<script language="javascript">ComComboObject('stv_dmg_qttn_rsn_desc',2,100,1,1,0);</script>&nbsp;<input type="text" style="width:283;" class="input2" maxlength="500" name="req_reason_desc" readOnly>
					</td>
				</tr> 
				<tr><td colspan="8" class="line_bluedot"></td></tr>
				<tr class="h23">
					<td>Responsible Party</td>
					<!-- <td><table border="0" style="width:300;" class="search_sm2"> 
							<tr class="h23">
								<td width="" class="stm">
									<input type="radio" class="trans" name="stv_dmg_respb_pty_kwn_cd" value="Y" checked>&nbsp;Known&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="stv_dmg_respb_pty_kwn_cd" value="N">&nbsp;Unknown</td></tr>
						</table>						
					</td>
					-->
					<td style="padding-left:2;"><script language="javascript">ComComboObject('stv_dmg_respb_pty_kwn_cd',1,300,1,1,1);</script></td>
					<td>Details</td>
					<td colspan="5" align="right"><input type="text" style="width:100%;ime-mode:disabled;" maxlength="500" class="input" name="stv_dmg_respb_desc_dtl" caption="Details"></td>
				</tr> 
				<tr class="h23">
					<td colspan="2"></td>
					<td>Reason</td>
					<td colspan="5" style="padding-left:2">
						<script language="javascript">ComComboObject('stv_dmg_respb_desc',2,100,1,1,0);</script>&nbsp;<input type="text" style="width:283;" class="input2" maxlength="500" name="res_reason_desc" readOnly>
					</td>
				</tr> 
				<tr><td colspan="8" class="line_bluedot"></td></tr>
				</table>				
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
      			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>&nbsp;&nbsp;</td>
						<td align="right">
							<input type="text" name="dmg_auth_sts_cd" style="width:50;font-weight:bold;text-align:center;" class="input2" maxlength="1" value="X" readonly>
							<input type="text" name="auth_usr_id" style="width:70;font-weight:bold;" class="input2" maxlength="20" readonly>
							<input type="text" name="auth_dt" style="width:85;font-weight:bold;" class="input2" readonly></td>
						<td width="100" align="center">		
				<!--  biz_1   (E) -->
						</td>
					</tr>
					</table>
					
					<table class="search" border="0" style="width:959;">
					<tr class="h23">
						<td width="150">Update DT/ID</td>
						<td colspan="5"><input type="text" name="dmg_upd_dt" style="width:80;" class="input2" readonly>&nbsp;<input type="text" name="dmg_upd_usr_id" style="width:100;" class="input2" readonly></td>
					</tr>
					</table>
						
				</td></tr>
				</table>
   				<!-- Button_Sub (E) -->
			
		</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->
		
</div>
<!-- (TAB) [ Damage ] (E) -->


<!-- (TAB) [ Repair ] (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:400" valign="top">
			
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td><table border="0" style="width:100%;" class="search_sm2"> 
							<tr class="h23">
								<td style="font-size:12;" align="center">
									<input type="radio" name="stv_dmg_rpr_proc_sts_cd" value="Q" class="trans" checked>&nbsp;Quotation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_rpr_proc_sts_cd" value="O" class="trans">&nbsp;Ordered&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_rpr_proc_sts_cd" value="R" class="trans">&nbsp;Repairing&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_rpr_proc_sts_cd" value="C" class="trans">&nbsp;Completed
								</td>
							</tr>
						</table>	
					</td>
				</tr>
				</table>	
				<table style="height:20;"><tr><td></td></tr></table>
							
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Repair Cost</td>
					<td width="30" class="stm">USD</td>
					<td width="160"><input type="text" name="rpr_cost_usd_amt_total" value="0" dataformat="float" pointcount="2" caption="USD Amount" style="width:90; text-align:right;" class="input2" readonly></td>
					<td width="70" class="stm">Repair Seq.</td>
					<td width="120"><input type="text" name="stv_dmg_rpr_seq" style="width:60; text-align:right;" class="input2" readonly>&nbsp;<img src="img/btns_back.gif" name="rpr_seq_prev" style="cursor:hand;" width="18" height="19" border="0" align="absmiddle">&nbsp;<img src="img/btns_next.gif" name="rpr_seq_next" style="cursor:hand;" width="18" height="19" border="0" align="absmiddle"></td>
					<td width="60" class="stm">Max Seq.</td>
					<td width="80"><input type="text" name="stv_dmg_rpr_seq_total" style="width:60; text-align:right;" class="input2" readonly></td>
					<td><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
						</table></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Quotation</td>
					<td width="30" class="stm">USD</td>
					<td width="160"><input type="text" name="qttn_cost_usd_amt" caption="USD Amount" style="width:90; text-align:right;" maxlength="18" class="input2" ></td>
					<td width="70" class="stm">Local</td>
					<td width="" style="padding-left:2">
						<script language="javascript">ComComboObject('qttn_locl_curr_cd',1,70,1,1);</script>&nbsp;<input type="text" name="qttn_cost_locl_amt" dataformat="float" pointcount="2" caption="Local Amount" style="width:90; text-align:right;" maxlength="18" class="input1"></td>
					</tr> 
				</table>
				<table class="line_bluedot" style="width:959;"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="130">Port</td>
					<td width="195"><input type="text" name="rpr_port_cd" caption="Port Code" style="width:98;" maxlength="5" class="input1">&nbsp;</td>
					<td width="35">Date</td>
					<td width="265"><input type="text" name="rpr_dt" dataformat="ymd" caption="Repair Date" style="width:80;" maxlength="8" class="input1">&nbsp;</td>
					<td width="53">Vendor</td>
					<td align="right"><input type="text" name="rpr_vndr_nm" caption="Vendor Name" style="width:282;" maxlength="100" class="input1"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="220">Unsettled Inter-Office Account No.</td>
					<td width="275"><input type="text" name="ustl_acct_no" caption="Unsettled Inter-Office Account No" style="width:218;" maxlength="20" class="input1"></td>
					<td width="180">Running Repair Account No.</td>
					<td><input type="text" name="run_rpr_acct_no" caption="Running Repair Account No" style="width:282;" maxlength="20" class="input"></td>
				</tr> 
				</table>

				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Repair Cost</td>
					<td width="40" class="stm">USD</td>
					<td><input type="text" name="rpr_cost_usd_amt" dataformat="float" pointcount="2" style="width:75; text-align:right;" maxlength="18" class="input1"></td>
				</tr> 
				</table>
				<table style="width:959;" class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="130">Supporting</td>
					<td style="padding-left:2;">
					
							<!-- supporting (S) -->
				    		<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2Result">Result</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="145" class="stm">
									<input type="text" name="rpr_rslt_rpt_atch_knt" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2Invoice">Invoice</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="145" class="stm">
									<input type="text" name="rpr_inv_atch_knt" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2PIC">PIC</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="145" class="stm">
									<input type="text" name="rpr_pict_atch_knt" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t2Document">Document</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td class="stm">
									<input type="text" name="rpr_doc_atch_knt" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								</tr>
							</table>
							<!-- supporting (S) -->
					
					</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="129">Remark(s)</td>
					<td><textarea name="rpr_rmk" style="width:100%; height:45;" maxlength="1000"></textarea></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="130">Update DT/ID</td>
					<td colspan="5"><input type="text" name="rpr_upd_dt" style="width:80;" class="input2" readonly>&nbsp;<input type="text" name="rpr_upd_usr_id" style="width:100;" class="input2" readonly></td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)--> 

</div>
<!-- (TAB) [ Repair ] (E) -->


<!-- (TAB) [ Compensation ] (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:400" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="100%"><table border="0" style="width:100%;" class="search_sm2" align="center"> 
							<tr class="h23">
								<td width="18%">
									<input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="R" class="trans" checked>&nbsp;Ready&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="C" class="trans">&nbsp;Claimed</td>
								<td width="64%" align="center">
									<input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="N" class="trans">&nbsp;Noticed&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="A" class="trans">&nbsp;Accepted&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="J" class="trans">&nbsp;Rejected&nbsp;&nbsp;
									<input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="P" class="trans">&nbsp;Completed</td>
								<td><input type="radio" name="stv_dmg_cmpn_proc_sts_cd" value="E" class="trans">&nbsp;Cancellation</td></tr>
						</table>
					</td>
				</tr>
				</table>
				<table style="height:20;"><tr><td></td></tr></table>		
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Claim Handling</td>
					<td width="59" class="stm">Office</td>
					<td width="160"><input type="text" name="clm_hndl_ofc_cd_cmpn" style="width:90;" class="input2" readonly></td>
					<td width="20" class="stm">ID</td>
					<td width="149"><input type="text" name="clm_hndl_usr_id" style="width:90;" class="input2" readonly></td>
					<td width="40" class="stm">Name</td>
					<td><input type="text" name="clm_hndl_usr_name" style="width:170;" class="input2" readonly></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Responsible Party</td>
					<td width="60" class="stm">Company</td>
					<td width="330"><input type="text" name="stv_dmg_respb_pty_co_nm" caption="Company" style="width:270;" maxlength="200" class="input1"></td>
					<td width="40" class="stm">Name</td>
					<td width="260"><input type="text" name="stv_dmg_respb_pty_pic_nm" caption="Name" style="width:170;" maxlength="200" class="input1"></td>
					<td width="35" class="stm">Title</td>
					<td align="right"><input type="text" name="stv_dmg_respb_pty_pic_tit_nm" caption="Title" style="width:100;" maxlength="200" class="input1"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Compensation</td>
					<td width="60" class="stm">Date</td>
					<td width="158"><input type="text" name="stv_dmg_cmpn_dt" style="width:90;" maxlength="8" dataformat="ymd" caption="Compensation Date" class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btn_stv_dmg_cmpn_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="40" class="stm">Local</td>
					<td width="243">
						<script language="javascript">ComComboObject('cmpn_curr_cd',1,74,1,1);</script>&nbsp;<input type="text" name="cmpn_cost_locl_amt" dataformat="float" pointcount="2" caption="Local Amount" style="width:94; text-align:right;" maxlength="18" class="input1"></td>
					<td width="30" class="stm">USD</td>
					<td width="104"><input type="text" name="cmpn_cost_usd_amt" dataformat="float" pointcount="2" caption="USD Amount" style="width:70; text-align:right;" maxlength="18" class="input2" readonly></td>
					<td width="90" class="stm">Inter-Office No.</td>
					<td align="right"><input type="text" name="cmpn_acct_no" style="width:100;" maxlength="20" class="input1"></td>
				</tr> 
				</table>


				<table class="line_bluedot" style="width:959;"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="129">Remark(s)</td>
					<td><textarea name="cmpn_rmk" style="width:100%; height:45;"></textarea></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="130">Update DT/ID</td>
					<td colspan="5"><input type="text" name="cmpn_upd_dt" style="width:80;" class="input2" readonly>&nbsp;<input type="text" name="cmpn_upd_usr_id" style="width:100;" class="input2" readonly></td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)--> 

</div>
<!-- (TAB) [ Compensation ] (E) -->


<!-- (TAB) [ Settlement ] (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:400" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Ship Owner</td>
					<td width="85" class="stm">Company</td>
					<td><input type="text" name="shp_ownr_co_nm" style="width:170;" maxlength="200" class="input2" readonly></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="220">Unsettled Inter-Office Account No.</td>
					<td width="265"><input type="text" name="ustl_acct_no_stl" style="width:170;" maxlength="20" class="input2" readonly></td>
					<td width="180">Running Repair Account No.</td>
					<td><input type="text" name="run_rpr_acct_no_stl" style="width:292;" maxlength="20" class="input2" readonly></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Billing</td>
					<td width="85" class="stm">Invoice No.</td>
					<td><input type="text" name="bil_inv_no" style="width:170;" maxlength="20" class="input2" readonly></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="135">Payment</td>
					<td width="85" class="stm">Date</td>
					<td width="167"><input type="text" name="pay_dt" dataformat="ymd" caption="Payment Date" style="width:90;" maxlength="8" class="input2" readonly></td>
					<td width="37" class="stm">Local</td>
					<td width="210">
						<input type="text" name="pay_curr_cd" style="width:70; text-align:right;" maxlength="3" class="input">&nbsp;<input type="text" name="pay_locl_amt" dataformat="float" pointcount="2" caption="Local Amount" style="width:90; text-align:right;" maxlength="18" class="input"></td>
					<td width="30" class="stm">USD</td>
					<td width="" colspan="3"><input type="text" name="pay_usd_amt" dataformat="float" pointcount="2" caption="USD Amount" style="width:70; text-align:right;" maxlength="18" class="input2" readonly></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="150">Supporting</td>
					<td style="padding-left:2;">
					
							<!-- supporting (S) -->
				    		<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t4Invoice">Invoice</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="117" class="stm">
									<input type="text" name="stl_inv_atch_knt" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_t4Document">Document</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td class="stm">
									<input type="text" name="stl_doc_atch_knt" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								</tr>
							</table>
							<!-- supporting (S) -->
					
					</td>
				</tr> 
				</table>

				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="129">Remark(s)</td>
					<td><textarea name="stl_rmk" style="width:100%; height:45;" maxlength="500" class="input2" readonly></textarea></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:959;"> 
				<tr class="h23">
					<td width="130">Update DT/ID</td>
					<td colspan="5"><input type="text" name="stl_upd_dt" style="width:80;" class="input2" readonly>&nbsp;<input type="text" name="stl_upd_usr_id" style="width:100;" class="input2" readonly></td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)--> 

</div>
<!-- (TAB) [ Settlement ] (E) -->

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
<!-- 			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right">
					</tr></table></td>
					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right">
					</tr></table></td>
-->					
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right">
					</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Mail">Mail</td>
					<td class="btn1_right">
					</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
					</tr></table></td>

			</tr>
		</table></td>

			</tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>