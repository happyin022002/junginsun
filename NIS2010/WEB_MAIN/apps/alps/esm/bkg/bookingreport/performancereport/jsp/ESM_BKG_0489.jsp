<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0489.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.15 강동윤
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0489Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0489Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String srNo 		= JSPUtil.getNullNoTrim(request.getParameter("sr_no"));
	String faxLogRefNo 	= JSPUtil.getNullNoTrim(request.getParameter("fax_log_ref_no"));
	String bkgSrKndCd   = JSPUtil.getNullNoTrim(request.getParameter("bkg_sr_knd_cd"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0489Event)request.getAttribute("Event");
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
<title>BKG Match & Transfer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		var formObj = document.form;
		formObj.sr_no.value 			= "<%= srNo %>";
		formObj.fax_log_ref_no.value 	= "<%= faxLogRefNo %>";
		formObj.sr_knd_cd.value 		= "<%= bkgSrKndCd %>";
		
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" >
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="fax_log_ref_no">
<input type="hidden" name="sr_knd_cd">
<input type="hidden" name="fax_ip">
<input type="hidden" name="usr_grp_cd">
<input type="hidden" name="dpcs_wrk_prt_cd">
<input type="hidden" name="dpcs_wrk_svr_cd">
<input type="hidden" name="chk_bkg_no">
<input type="hidden" name="sr_amd_seq">
<input type="hidden" name="sr_amd_rsn_tp_cd">
<input type="hidden" name="sr_mtch_sts_cd">
<input type="hidden" name="downloadLocation">
<input type="hidden" name="downloadFileName">
<input type="hidden" name="isFilePath">
<input type="hidden" name="img_file_nm">
<input type="hidden" name="img_file_path_ctnt">
<input type="hidden" name="rcv_ofc_cd">
<input type="hidden" name="vvd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="fax_svr_ofc_cd">


<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;BKG Match & Transfer</td></tr>
		</table>
	<!-- : ( Title ) (E) -->

	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">SI No.</td>
					<td width="150"><input type="text" name="sr_no" style="width:110" value="" dataformat="engupnum" maxlength="12" readonly ></td>
					<td width="90">SI Sender</td>
					<td width="150"><input type="text" name="sndr_fax_no" style="width:100" value="" readonly></td>
					<td width="90">Time Received</td>
					<td width="160"><input type="text" name="rcv_dt" style="width:115" value="" readonly>&nbsp;</td>
					<td width="60">Transferer</td>
					<td><input type="text" name="transferer" style="width:180" value="" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Total Page(s)</td>
					<td width="150"><input type="text" name="tot_pg_knt"  dataformat="int" style="width:110" value="" readonly></td>
					<td width="90">Page(s)</td>
					<td width="400"><input type="text" name="img_pg_no" style="ime-mode:disabled"  dataformat="dashfloat"  style="width:100" value="" class="input1">&nbsp;<input type="text" style="width:100" value=" Eg. (1 or 1-3)" class="input2" readonly></td>
					<td width="160"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_match">Matching  Complete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					<td>&nbsp;</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
					
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="90">BKG No.</td>
								<td width="140"><input type="text" name="bkg_no" style="width:110" value="" class="input1" style="ime-mode:disabled" dataformat="uppernum" maxlength="13"></td>
								<td width="120"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_chk_bkg">Check  Booking</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="120"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_open_bkg">Open  Booking</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="90">Urgent</td>
								<td width="150"><select name="sr_urg_cd" style="width:100;" class="input1" caption="Urgency" required>
							<!--<option value=""></option>
							-->
							<option value="N" selected>Normal</option>
							<option value="U">Urgent</option>
							<option value="V">VIP</option>
							</select></td>
								<td width="60">SI Kind</td>
								<td width="150">
									<script language="javascript">ComComboObject("sr_amd_tp_cd",2,100,1,1,1);</script><!--
									
										<select name="sr_amd_tp_cd" style="width:100;" class="input1" onChange="javascript:setAmend();" caption="SI Kind" required>
										<option value="" selected></option>						
										<option value="N">New</option>
										<option value="A">Amend</option>
										<option value="B">B/L Confirm</option>
										<option value="T">Addition</option>
										</select>
										
								--></td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
							    <td width="90"><input type="checkbox" name="sr_split" value="" class="trans">Split</td>
							    <td width="150"><input type="text" name="bl_split_no"  dataformat="int" style="width:30" value="" >&nbsp;/&nbsp;<input type="text" name="bl_split_ttl_knt"  dataformat="int" style="width:30" value="" ></td>
 
								<td width="60">Due Date</td>
								<td><input type="text" name="sr_due_dt"  style="width:75"  value="" dataformat="ymd" maxlength="10" size="10" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
								<td>&nbsp;</td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
							    <td width="150">Customer Addr(E-Mail)</td>
							    <td width="50"><input type="text" class="" name="sr_customer_eml"   style="width:200" value="" > </td>
  
							</tr>
						</table>					
						<table width="100%" class="grid"> 
								<tr>
								<td class="tr2_head" width="90">Message</td>
								<td align="center"><textarea name="diff_rmk" style="width:100%;height:90" ></textarea></td>
								</tr>
						</table> 
							<!--grid (S)-->
							
						<table width="0%"  id="mainTable"> 
							<tr>
								<td width="0%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 						

						<!--grid (E)-->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
		      			 	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_add"> Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							</table>
							</td>
							</tr>
						</table>
						<table class="height_10"><tr><td colspan="8"></td></tr></table>
				    	<!-- Button_Sub (E) -->
					
					</td>
					<td width="19">&nbsp;</td>
					<td width="480" valign="top">
							<table class="search" border="0">
								<tr><td class="title_h"></td>
								<td class="title_s">Amend Reason : Select the Reason(s) which causes SI Re-Transmission
</td></tr>
							</table>
					
						<table class="search_sm" border="0" style="width:480;"> 
						<tr class="h23">
							<td width="50" rowspan="6" valign="top">Carrier</td>
							<td width="170" class="stm"><input type="checkbox" name="sr_amd_rsn" value="C_I1" class="trans">Mis-Typing</td>
							<td width="60" rowspan="6" valign="top">Merchant</td>
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="M_DM" class="trans">Data Missing</td>
						</tr>
						<tr class="h23">
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="C_I2" class="trans">Wrong Data Input</td>
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="M_UF" class="trans">Unclear Fax</td>
						</tr>
						<tr class="h23">
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="C_R1" class="trans">Mis-Rating(S/C)</td>							
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="M_BL" class="trans">B/L Data Change</td>
						</tr>
						<tr class="h23">
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="C_R2" class="trans">Mis-Rating(RFA)</td>
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="M_CD" class="trans">COD</td>
						</tr>
						<tr class="h23">
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="C_F1" class="trans">Sales</td>
							<td width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="M_SP" class="trans">Split/Combine</td>
						</tr>
						<tr class="h23">
							<td colspan="2" width="150" class="stm"><input type="checkbox" name="sr_amd_rsn" value="C_F2" class="trans">F/OFC Error</td>							
						</tr>
						</table>
					
					</td>
				</tr>
				</table>
				
				
				
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 			
			
			<!-- Grid (E) -->
				
				
				</td></tr>
			</table>
			
    <table class="height_5"><tr><td></td></tr></table>
	
		</td></tr>
			</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_open">Open SR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transfer">Transfer to DC</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>											
				<td class="btn1_line"></td>	
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>