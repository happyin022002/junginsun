<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2018.jsp
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2018Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt");
		
	String darNo 	= request.getParameter("dar_no") 	!= null ? (String)request.getParameter("dar_no") 	: "" ;	
	String caller 	= request.getParameter("caller") 	!= null ? (String)request.getParameter("caller") 	: "" ;
	String sheetId 	= request.getParameter("sheetId") 	!= null ? (String)request.getParameter("sheetId") 	: "" ;
	String rqst_flg 	= request.getParameter("rqst_flg") 	!= null ? (String)request.getParameter("rqst_flg") 	: "" ;
	
	String bodyTag	= null;
	String tableTag	= null;

	if (darNo.length() > 0 && caller.length() > 0) {
		//PopUp 화면일 경우
		bodyTag		= "<body class=\"popup_bg\" onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" class=\"popup\" cellpadding=\"5\" border=\"0\">";
	}
	else {
		//Main 화면일 경우
		bodyTag		= "<body onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding-top:2;padding-left:5;\">";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		
		event = (EesDmt2018Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request - After Booking Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="dar_no">
<input type="hidden" name="apvl_no">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="tariff">
<input type="hidden" name="is_cntr">
<input type="hidden" name="pod">
<input type="hidden" name="pol">
<input type="hidden" name="del">
<input type="hidden" name="por">
<!-- Charge Detail per BKG 정보 조회시 After Booking 에서 읽어올  
	 것인지 Charge Calculation 에서 읽어올 것인지를 구분해 주는 변수 -->
<input type="hidden" name="is_aft_bkg_cntr">
<!-- Request 호출시 사용되는 변수 -->
<input type="hidden" name="aft_expt_dar_no">
<input type="hidden" name="aft_expt_adj_seq">
<input type="hidden" name="dmdt_expt_rqst_sts_cd">
<input type="hidden" name="prog_rmk">
<!-- 서버모듈 호출 후 응답받은 결과를 임시 저장하기 위해서 사용하는 변수 -->
<input type="hidden" name="result">
<input type="hidden" name="result2">
<input type="hidden" name="result3">
<!-- Local Currency 조회를 위해 사용되는 변수 -->
<input type="hidden" name="cnt_cd">
<!-- PreCalc -->
<input type="hidden" name="preCalcFlg">
<input type="hidden" name="freeTimeFlg">
<input type="hidden" name="intg_cd_id">

<input type="hidden" name="rqst_flg" value="<%= rqst_flg %>">
<input type="hidden" name="role_auth">
<input type="hidden" name="usr_id" 		value="<%= strUsr_id %>">
<input type="hidden" name="usr_role_cd">
<input type="hidden" name="apvl_role_cd">
<input type="hidden" name="pgm_no" 		value="EES_DMT_2018">

<input type="hidden" name="apvl_ofc_cd">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_ofc %>">
<input type="hidden" name="apvl_path_cd">
<input type="hidden" name="apvl_end_flg">
<input type="hidden" name="aft_bkg_path_cd">

<input type="hidden" name="end_ofc_cd">
<input type="hidden" name="end_path_cd">
<input type="hidden" name="end_role_sts_cd">

<input type="hidden" name="caller"  value="<%= caller %>">
<input type="hidden" name="sheetId" value="<%= sheetId %>">
<input type="hidden" name="popup_flag">
<input type="hidden" name="popup_upd_dt">

<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="cust_cd">
<input type="hidden" name="cust_nm">
<input type="hidden" name="dmdt_expt_rqst_sts_desc">

<input type="hidden" name="ex_rate">
<input type="hidden" name="aftBkgAproCd">

<!-- BackEndJob -->
<input type="hidden" name="job_key"> 

<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"  id='kkk'>
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	
	<% if (!"2006".equals(caller)) { %>	 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<% } else { %>		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> DEM/DET Adjustment Request - After Booking Approval(New)</td></tr>
		</table>			
	<% } %>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">DAR No. </td>
						<td width="140"><input type="text" name="darNo" style="width:120;ime-mode:disabled" value="<%=darNo%>" class="input" dataformat="engup" maxlength="15"></td>
						<td width="60">APVL No.</td>
						<td width="160"><input type="text" name="apvlNo" style="width:120;;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
						<td width="60">Status</td>
						<td width="160"><input type="text" name="status" style="width:145;" class="input2"></td>
						<td width="60">&nbsp;</td>
						<td width="230">&nbsp;</td>
						<td width="30">&nbsp;</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">S/C No. </td>
						<td width="140"><input type="text" name="scNo" style="width:80;" class="input2" readOnly></td>
						<td width="60">RFA No.</td>
						<td width="160"><input type="text" name="rfaNo" style="width:120;" class="input2" readOnly></td>
						<td width="60">TAA No.</td>
						<td width="160"><input type="text" name="taaNo" style="width:145;" class="input2" readOnly></td>
						<td width="60">Customer</td>
						<td width="230"><input type="text" name="custCd" style="width:70;" class="input2">&nbsp;<input type="text" name="custNm" style="width:150;" class="input2" readOnly></td>
						<td width="30">
							<table class="search" border="0" id="grte_lte_flg" style="display:none" > 
								<tr class="h23">
								<td onmousemove="obdmtmsgmove()" onmouseover='obdmtmsgset("Guarantee Letter");return true;'  onmouseout="obdmtmsghide();return true;">
									&nbsp;<a href="javascript:guarantee_letter_inquiry()"><font color="red">(G)</font></a>
								</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				
				<!--  biz_1 ( E) -->
		</td></tr>
	</table>			
		
	<table class="height_8"><tr><td></td></tr></table>		
	
	<table class="search"> 
       		<tr ><td class="bg">
				
			<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid  (E) -->
			<!--  Button_Sub (S) -->
			
			<table width="100%" class="button"> 
	       	<tr>
	       		<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AddBkgReq">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DelBkgReq">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td>		
			</tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
				<!-- Grid  (E) 
			<table class="height_8"><tr><td></td></tr></table>
			-->
		
		<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="160">
							<table class="search" border="0">
								<tr><td class="title_h"></td>
									<td class="title_s">Charge Detail per BKG</td></tr>
							</table>
							<table class="height_5"><tr><td></td></tr></table>
						</td>
						
						<td width="70">CNTR Q'ty</td>
						<td width="45"><input type="text" name="cntrQty" style="width:40;text-align:right;" class="input2" readOnly></td>
						<td width="110">Final Billable AMT</td>
						<td width="45"><input type="text" name="totalCurr" style="width:40;text-align:center;" class="input2" readOnly></td>
						<td width="100"><input type="text" name="totalBillAmt" id="totalBillAmt" style="width:90;text-align:right;" class="input2" readOnly></td>	
						<td width="85"><input type="text" name="billExRate" id="billExRate" style="width:80;text-align:center;" class="input2" readOnly></td>		
						<td width="25">USD</td>				
						<td width="80"><input type="text" name="totalBillAmtUsd" id="totalBillAmtUsd" style="width:75;text-align:right;" class="input2" readOnly></td>
						<td>&nbsp;</td>
						<td width="180"><table width="180" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_PreCalc" id="btn_PreCalc">D/C AMT or Ratio Pre Cal.</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
						<td width="70"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Reset">Reset</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
					</tr>
					<tr class="h23">
						<td width="160">&nbsp;</td>
						
						<td width="70">&nbsp;</td>
						<td width="45">&nbsp;</td>
						<td width="110">DC Amount</td>
						<td width="45"><input type="text" name="dcCurr" style="width:40;text-align:center;" class="input2" readOnly></td>
						<td width="100"><input type="text" name="totalDCAmt" id="totalDCAmt" style="width:90;text-align:right;" class="input2" readOnly></td>	
						<td width="85"><input type="text" name="dcExRate" id="dcExRate" style="width:80;text-align:center;" class="input2" readOnly></td>		
						<td width="25">USD</td>				
						<td width="80"><input type="text" name="totalDCAmtUsd" id="totalDCAmtUsd" style="width:75;text-align:right;" class="input2"readOnly></td>
						<td>&nbsp;</td>
						<td width="180">&nbsp;</td>
						<td width="74">&nbsp;</td>
					</tr>
				</table>
		
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) 
			<table class="height_8"><tr><td></td></tr></table>
			-->
			
			<table class="search">
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;BKG</td>
						<td width="55"><input type="text" name="bkgCntTot" style="width:40;text-align:right;" class="input2" readOnly></td>
					<td width="65">CNTR Q'ty</td>
						<td width="55"><input type="text" name="cntrQtyTot" style="width:40;text-align:right;" class="input2" readOnly></td>
					<td width="80">Billable Total</td>
						<td width="30"><input type="text" name="bilCurrTot" style="width:30;text-align:center;" class="input2"  value="USD" readOnly></td>
						<td width="100"><input type="text" name="bilTot" id="bilTot" style="width:90;text-align:right;" class="input2" readOnly></td>
					<td width="50">DC AMT</td>
						<td width="30"><input type="text" name="dcCurrTot" style="width:30;text-align:center;" class="input2"  value="USD" readOnly></td>
						<td width="100"><input type="text" name="dcAmtTot" id="dcAmtTot" style="width:90;text-align:right;" class="input2" readOnly></td>
					<td width="160">Final billable AMT after DC</td>
						<td width="30"><input type="text" name="finalCurrTot" style="width:30;text-align:center;" class="input2"  value="USD" readOnly></td>
						<td width="100"><input type="text" name="finalBilAmtTot" id="finalBilAmtTot" style="width:90;text-align:right;" class="input2"readOnly></td>
					<td width="">&nbsp;</td>
				</tr> 
			</table>
			<table class="search">
				<tr class="h23">
					<td class="title_s" width="205"><input type="checkbox" name="applFlg" class="trans" onClick="approvalFlg()">Evidence update status</td>
				</tr> 
			</table>
			
				<table class="search" id="approval_flg" style="display:none" > 
				<tr><td>
					<table class="search" border="0" style="width:979;" > 
						<tr class="h23">
							<td width="226">					
								<table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">Evidence</td></tr>
								</table>
							</td>
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="220"><font color="red">*</font>Reason of D/C Request </td>
							<td width="40"><input type="text" name="rsn_dc_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="220"><font color="red">*</font>Reason of Clearance Delay</td>
							<td width="40"><input type="text" name="rsn_cle_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="220"><font color="red">*</font>Customer's Request Letter</td>
							<td width="50"><input type="text" name="cust_rqst_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="200">Actual Cost(for all BKG)</td>
							<td width=""><input type="text" name="act_cost_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
						</tr>
						<tr class="h23">
							<td width="220">&nbsp;&nbsp;Cargo invoice OLD </td>
							<td width="40"><input type="text" name="cgo_inv_old_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="220"><font color="red">*</font>Cargo invoice NEW</td>
							<td width="40"><input type="text" name="cgo_inv_new_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="220"><font color="red">*</font>Expected Clearance Date (STS L)</td>
							<td width="50"><input type="text" name="high_low_flg" style="width:20;text-align:center;" class="input2" readOnly>
										   <input type="text" name="exp_cle_flg" style="width:20;text-align:center;" class="input2" readOnly>
							</td>
							<td width="200">Other Attachment If Needed</td>
							<td width=""><input type="text" name="oth_att_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
						</tr>
					</table>
		
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="254">					
								<table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">DMT PFMC</td></tr>
								</table>
							</td>
							<td width="215"><font color="red">*</font>DMT PFMC</td>
							<td width="40"><input type="text" name="dmt_pfmc_flg" style="width:20;text-align:center;" class="input2" readOnly></td>	
							<td width="460"><font color="red">*</font>Customer's Sales Performance Load/CM/CMPB</td>
							<td width=""><input type="text" name="cust_sal_pfmc_flg" style="width:20;text-align:center;" class="input2" readOnly></td>	
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="213">					
								<table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s"><font color="red">*</font>Full History</td></tr>
								</table>
							</td>
							<td width=""><input type="text" name="full_his_flg" style="width:20;text-align:center;" class="input2" readOnly></td>	
						</tr>
					</table>
		
					<table class="search" border="0"  style="width:979;">
						<tr class="h23">
							<td width="200">					
								<table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s"><font color="red">*</font>Additional Evidence Reason</td></tr>
								</table>
							</td>	
						</tr>
					</table>
					<table class="search" border="0"  style="width:979;""> 
						<tr class="h23">
							<td width="160" id="rsnCd" >Rsn.Code</td>
							<td width="90" ><input type="text" name="rsn_cd" style="width:70;text-align:center;" class="input2" readOnly></td>
							<td width="190"> Attached File </td>
							<td width="40"><input type="text" name="att_file_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="200">&nbsp;&nbsp;Reason Detail Remark</td>
							<td width="40"><input type="text" name="rsn_dtl_rmk_flg" style="width:20;text-align:center;" class="input2" readOnly></td>
							<td width="210"></td>
							<td width=""></td>
						</tr>
					</table>
				</td>
				</tr>
				</table>
			
		
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
					<!-- Grid  (S) -->
					
					<!-- Tab (S) -->
						<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
							<tr>
								<td width="100%">
									<script language="javascript">ComTabObject('tab1')</script>
								</td>
							</tr>
						</table>
					<!-- Tab (E) -->
						<div id="tabLayer" style="display:inline">		
							<table class="search" id="mainTable" > 
								<tr>
									<td width="100%">
									<script language="javascript">ComSheetObject('sheet20');</script>
									</td>
								</tr>
							</table>
						</div>						
						
						<div id="tabLayer" style="display:none">	
							<table class="search" id="mainTable" > 
								<tr>
									<td width="100%">
									<script language="javascript">ComSheetObject('sheet21');</script>
									</td>
								</tr>
							</table>
						</div>
						
				<!-- Grid  (E) -->
					</td>
					<td width="19"></td>
					<td width="480" valign="top">
						<table class="search">
							<tr class="h23"><td width="140">&nbsp;Reason for Request</td>
						    <td width="350"><script language="javascript">ComComboObject('dmdt_expt_rqst_rsn_cd',2,350,0,0,0);</script></td></tr> 
						</table>
						<table class="search">
							<tr class="h23"><td class="title_s" width="205"><input type="checkbox" name="chkComment" class="trans" onClick="checkComment()">Comment </td>
							</tr> 
						</table>
						<table width="100%" class="search"> 
							<tr class="h23">
								<td width="%"><textarea name="comment" dataformat="engup3" style="width:480;height:57;" class="input1"></textarea></td>
							</tr>
						</table>
					
					</td>
				</tr>
			</table>
			
    
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<% if ("Y".equals(rqst_flg)) { %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_T_Save">T.Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>			
				<% } %>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Detail" id="btn_Detail">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<% if ("Y".equals(rqst_flg)) { %>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
				<% } %>
								
				<% if (!"Y".equals(rqst_flg) ) { %>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_appl" style="display:inline">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Approval">Approval</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_comfirm" style="display:none">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Approval">Confirm</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_CounterOffer">Counter Offer</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Reject">Reject</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>						
				<% } %>
				
				<% if (!"".equals(darNo) ) { %>
					<td class="btn1_line"></td> 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right">
						</tr>
						</table>
					</td>					
				<% } %>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
		<table class="search" id="approval_no_flg" style="display:none" > 
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</td></tr>
</table>
	</td></tr>
</table>

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<div id="obDmt" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	

</form>
</body>
</html>