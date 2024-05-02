<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1020.jsp
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.05.26 김창식
* 1.0 Creation
*--------------------------------------------------
* History
* 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
* 2014-09-25 Chang Young Kim 10만불 비용지급 결재건 3차 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EesCgm1020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  		= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	String csrGwUrl = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();


		event = (EesCgm1020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
		//2013-07-09 조경완 Rold Code 하드코딩 대체 
		//if("SELCOE".equals(ofc_cd)||"NYCNA".equals(ofc_cd)||"ATLSC".equals(ofc_cd)||"PHXSC".equals(ofc_cd)||"SINWA".equals(ofc_cd)){
		// 2015 조직코드개편 Chang-Young Kim
		if("SELCON".equals(ofc_cd)||"NYCRA".equals(ofc_cd)||"ATLSA".equals(ofc_cd)||"PHXSA".equals(ofc_cd)||"SINRS".equals(ofc_cd)){
			tRole = "Authenticated";
		}else{
			tRole = "Not Authenticated";
		}
		
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lease Agreement Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
		
		
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Form Hidden -->
<input type="hidden" name="action_flag">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="ofc_cd">

<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq">
<input type="hidden" name="lst_ver_flg">

<!--  Previous Data -->
<input type="hidden" name="pre_eff_dt">
<input type="hidden" name="pre_exp_dt">

<input type="hidden" name="pre_agmt_exp_dt">
<input type="hidden" name="trole" value="<%=tRole%>">

<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">
<input type="hidden" name="gw_uq_doc_no">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		
		<!-- : ( Search Options ) (S) -->
		
			<table class="search"> 
			<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Agreement No.</td>
					<td width="148" style="padding-left:2">
						<input type="text" name="agmt_no" dataformat="engup" maxlength="9" style="width:80;ime-mode:disabled" class="input" value="">&nbsp;
						<img name="btns_agmtno" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1">
					</td>
					<td width="50">Version</td>
					<td width="90"><script language="javascript">ComComboObject('agmt_ver_no', 1, 40, 1, 0, 0, false);</script><!--input type="text" name="agmt_ver_no" style="width:30;ime-mode:disabled" class="input2" value=""--></td>
					<td width="50">Ref. No.</td>
					<td width="150"><input type="text" name="agmt_ref_no" dataformat="engup" maxlength="15" style="width:115;ime-mode:disabled" class="input1" value=""></td>
					<td width="60">Currency</td>
					<td width=133><input type="text" name="curr_cd" readonly style="width:60;text-align:center;ime-mode:disabled" class="input2" value="">&nbsp;<img name="btns_curr_cd" id="btns_curr_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>	
					<td width="110">Agreement Office</td>
					<td width=""><input type="text" name="agmt_iss_ofc_cd" dataformat="engup" readonly style="width:80;text-align:center;ime-mode:disabled" class="input2" value=""></td>
				</tr>
				<tr class="h23">
					<td width="100">G/W Contract</td>
					<td style="padding-left:2" colspan="5"><input type="text" name="gw_uq_doc_tit_nm" style="width:453;" class="input2" value="" readonly>&nbsp;<img name="btns_gwUqDoc" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="btn_gwDelete">Delete</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
					</td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="78">Lease Term</td>
					<td width="140" style="padding-left:2"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 40, 0, 1, 0, false);</script></td>
					
					<td width="108">Agreement Date</td>
					<td width="140"><input type="text" name="agmt_dt" dataformat="ymd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_agmtDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="127">Agreement Eff. Date</td>
					<td width=""><input type="text" name="agmt_eff_dt" dataformat="ymd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_agmt_effDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="agmt_exp_dt" dataformat="ymd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_agmt_expDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					
					</tr></table> 
			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="48">Lessor</td>
					<td width="420"><input type="text" name="vndr_seq" dataformat="int" maxlength="6" style="width:70;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup2">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:288;ime-mode:disabled" class="input2" value=""></td>
					
					<td width="127">Rate Eff. Date</td>
					<td width=""><input type="text" name="eff_dt" dataformat="ymd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_effDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="exp_dt" dataformat="ymd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled"  readonly  class="input2" value="">&nbsp;<!--img name="btns_Calendar_expDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td>
						<div id="poolLayer" style="visibility:hidden">
						<table class="search" border="0">
						<tr class="h23">
							<td width="37">Pool</td>
							<td><script language="javascript">ComComboObject('chss_pool_cd', 1, 85, 1, 1, 0, false);</script></td>
						</tr>
						</table>
						</div>
					</td>
						
				</tr> 
				</table>
				<!--  biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
					<td width="350" valign="top">
					<!--  biz_2  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Rental Rate Type</td></tr>
					</table>
					<table class="search_sm2" border="0" style="width:330;"> 
						<tr class="h23">
							<td colspan="3"><input type="radio" value="F" name="eq_rntl_tp_cd" class="trans" checked>Fixed&nbsp;&nbsp;&nbsp;<input type="radio" name="eq_rntl_tp_cd" value="U" class="trans">Tier(Unit/Day)&nbsp;&nbsp;&nbsp;<input type="radio" name="eq_rntl_tp_cd" value="D" class="trans">Tier(Used Days)</td>
						</tr> 
						<tr class="h23">
							<td width="95">&nbsp;Payment Term</td>
							<td width="197" class="sm"><input type="text" name="pay_term_dys" dataformat="int" maxlength="5" style="width:60;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;&nbsp;days</td>
							<td>&nbsp;</td>
						</tr> 
					</table>
					<!--  biz_2   (E) -->
					</td>
					<td width="30">&nbsp;&nbsp;&nbsp;</td>
					<td width="" valign="top">
					<!--  biz_3  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Damage Protection Plan(USD)</td></tr>
					</table>
					<table class="search_sm2" border="0" style="width:600;"> 
						<tr class="h23">
							<td width="130"><input type="radio" name="dpp_tp_cd" value="G" class="trans" checked>General DPP</td>
							<td width="120" class="stm">Rate</td>
							<td width=""><input type="text" name="dpp_rt_amt" dataformat="float" style="width:60;text-align:right;ime-mode:disabled" class="input" value=""></td>
							<td width="" class="stm">Coverage Amt.</td>
							<td><input type="text" name="dpp_cvrg_amt" dataformat="float" style="width:60;text-align:right;ime-mode:disabled" class="input" value=""></td>
						</tr> 
						<tr class="h23">
							<td><input type="radio" name="dpp_tp_cd" value="L" class="trans">Lumpsum DPP</td>
							<td width="" class="stm">Lumpsum Amt.</td>
							<td><input type="text" name="lmsm_amt" dataformat="float" style="width:60;text-align:right;ime-mode:disabled" class="input2" value=""></td>
						</tr>  
					</table>
					<!--  biz_3   (E) -->
					</td></tr>
				</table>
				<table class="search" border="0">
					<tr><td colspan="6" class="line_bluedot"></td></tr>
					<tr class="h23">
						<td colspan="3">
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="155">&nbsp;On-hire Handling Charge</td>
							<td width="230"><input type="text" name="onh_hndl_rt_amt" dataformat="float" maxlength="18" style="width:60;text-align:right;ime-mode:disabled" class="input" value=""></td>
							<td width="155">Off-hire Handling Charge</td>
							<td><input type="text" name="offh_hndl_rt_amt" dataformat="float" maxlength="18" style="width:60;text-align:right;ime-mode:disabled" class="input" value=""></td>
						</tr> 
					</table>
						</td>
					</tr>
				
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_4  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Drop Off Limit</td></tr>
				</table>
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
						<td width="350">
						<table class="search_sm2" border="0"  style="width:330;">
								<tr class="h23">
									<td width="65">&nbsp;&nbsp;Period</td>
									<td class="stm"><input type="radio" name="drp_off_lmt_prd_cd" value="M" class="trans" checked>Per Month&nbsp;&nbsp;&nbsp;<input type="radio" name="drp_off_lmt_prd_cd" value="Y" class="trans">Per Year</td>
								</tr>
						</table>
					
					</td>
					<td width="30">&nbsp;&nbsp;&nbsp;</td>
					<td width="">
						<table class="search_sm2" border="0"  style="width:400;">
								<tr class="h23">
									<td width="280"><input type="radio" name="drp_off_lmt_tp_cd" value="F" class="trans" checked>Fixed Quantity&nbsp;&nbsp;&nbsp;<input type="radio" name="drp_off_lmt_tp_cd" value="R" class="trans">Guaranteed Portion</td>
									<td width="" class="stm">
										<div id="qtyLayer">
										<table border="0"><tr><td>
											<input type="text" name="drp_off_lmt_qty" dataformat="float" style="width:80;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;
										</td></tr></table>
										</div>
										<div id="rtoLayer" style="display:none">
										<table border="0"><tr><td>
											<input type="text" name="drp_off_lmt_rto" dataformat="float" style="width:80;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;%
										</td></tr></table>
										</div>
									</td>
								</tr>
						</table>
					
					</td>
					</tr>
				</table>
				<!--  biz_4   (E) -->
				
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 

<!--TAB Rental Rate (S) -->

<div id="tabLayer" style="display:Inline">

		<!-- Tab BG Box  (S) -->
     <table class="search"> 
       		<tr><td class="bg" style="height:160" valign="top">
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
				<div id="t3sheetLayer1" style="display:Inline">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>  
				</div>
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<div id="t3sheetLayer2" style="display:none">
					<!--table class="height_5"><tr><td></td></tr></table-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet2');</script>
							</td>
						</tr>
					</table>  
				</div>	
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<div id="t3sheetLayer3" style="display:none">
					<!--table class="height_5"><tr><td></td></tr></table-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet3');</script>
							</td>
						</tr>
					</table>  
				</div>	
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<div id="t3ButtonLayer" style="display:none">
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
			</div>
	    	<!-- Button_Sub (E) -->
		
	<!-- Tab BG Box  (S) -->
</td></tr>
</table> 

</div>

<!--TAB Rental Rate (E) --> 		
		
<!--TAB Depr. For Casualty Value (S) -->

<div id="tabLayer" style="display:none">
	
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg" style="height:160" valign="top">
			<!--  biz_5  (S) -->
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
					<td width="140">Monthly Depreciation</td>
					<td width="150" class="stm"><input type="text" name="mon_dpc_rt_amt" dataformat="float" style="width:70;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;%</td>
					<td width="120">Max. Depreciation</td>
					<td width="150" class="stm"><input type="text" name="max_dpc_rt_amt" dataformat="float" style="width:70;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;%</td>
					<td width="90">Initial Factor</td>
					<td class="stm"><input type="text" name="init_dpc_rt_amt" dataformat="float" style="width:70;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;%</td>
					</tr>  
				</table>
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	

</div>

<!--TAB Depr. For Casualty Value (E) --> 




<!--TAB Surcharge (S) -->

<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg" style="height:160" valign="top">
			<!--  biz_5  (S) -->
				<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Surcharge for Registration</td></tr>
				</table>
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
					<table width="50%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table> 
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="50%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
		
</div>

<!--TAB Surcharge (E) -->  







<!--TAB Remark (S) -->

<div id="tabLayer" style="display:none">


		<!-- Tab BG Box  (S) -->
     <table class="search"> 
       		<tr><td class="bg" style="height:160" valign="top">
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
			<table width="100%" class="search"> 
			<tr class="" align="center"><td><textarea name="diff_rmk" style="width:100%;height:130;ime-mode:disabled"></textarea></td>
			</tr>
			</table> 
			<!-- Grid (E) -->
			
		
	<!-- Tab BG Box  (S) -->
</td></tr>
</table> 


</div>

<!--TAB Remark (E) -->  



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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					<td class="btn1_line"></td>
					
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_VersionUp" id="btn_VersionUp">Version Up</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
				
<div id="hiddenLayer" style="display:none">
	<script language="javascript">ComSheetObject('sheet');</script>  
</div>	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>