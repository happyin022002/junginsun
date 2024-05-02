<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2021.jsp
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.06.10 김창식
* 1.0 Creation
*--------------------------------------------------
* History
* 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
* 2013.09.04 한종희 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발 Script Error 긴급 복구
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EesCgm2021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	String csrGwUrl = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		//2013-09-04 2013-07-09 조경완 Rold Code 하드코딩 대체 Script Error Recovery by J.H. HAN 
		strOfc_cd = account.getOfc_cd();


		event = (EesCgm2021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		//2013-07-09 조경완 Rold Code 하드코딩 대체 
		// if("SELCOE".equals(strOfc_cd)||"NYCNA".equals(strOfc_cd)||"ATLSC".equals(strOfc_cd)||"PHXSC".equals(strOfc_cd)){
		// 2015 조직코드개편 Chang-Young Kim
		if("SELCON".equals(strOfc_cd)||"NYCRA".equals(strOfc_cd)||"ATLSA".equals(strOfc_cd)||"PHXSA".equals(strOfc_cd)){
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
<input type="hidden" name ="action_flag">
<input type="hidden" name ="intg_cd_id">
<input type="hidden" name="ofc_cd">

<input type="hidden" name ="eq_knd_cd">
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
		
		<!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up,-->
     		
		<!-- Tab  (E) -->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Agreement No.</td>
					<td width="160"><input type="text" name="agmt_no" dataformat="engup" maxlength="9" style="width:100;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_agmtno" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>
					<td width="50">Version</td>
					<td width="90" style="padding-left:2"><script language="javascript">ComComboObject('agmt_ver_no', 1, 60, 1, 0, 0, false);</script></td>
					<td width="50">Ref. No.</td>
					<td width="140"><input type="text" name="agmt_ref_no" dataformat="engup" maxlength="15" style="width:105;ime-mode:disabled" class="input2" value=""></td>
					<td width="130">Agreement Office</td>
					<td width=""><input type="text" name="agmt_iss_ofc_cd" dataformat="engup" maxlength="6" style="width:80;" class="input1" value="">&nbsp;<img name="btns_office" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
				<tr class="h23">
					<td width="95">G/W Contract</td>
					<td colspan="5"><input type="text" name="gw_uq_doc_tit_nm" style="width:457;" class="input2" value="" readonly>&nbsp;<img name="btns_gwUqDoc" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>
					<td width="60">
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
					<td width="95">Lease Term</td>
					<td width="244" style="padding-left:2"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 100, 0, 1, 0, false);</script></td>
						
					<td width="106">Agreement Date</td>
					<td width="140"><input type="text" name="agmt_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_agmtDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="130">Agreement Eff. Date</td>
					<td width=""><input type="text" name="agmt_eff_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_agmt_effDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="agmt_exp_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_agmt_expDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="95">Lessor</td>
					<td width="492"><input type="text" name="vndr_seq" dataformat="int" maxlength="6" style="width:100;ime-mode:disabled" class="input1" value="">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:328;ime-mode:disabled" class="input2" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="130">Rate Eff. Date</td>
					<td width=""><input type="text" name="eff_dt" dataformat="ymd" maxlength="8" style="width:80;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_Calendar_effDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="exp_dt" dataformat="ymd" readonly maxlength="8" style="width:80;ime-mode:disabled" class="input2" value="">&nbsp;<!--img name="btns_Calendar_expDt" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					</tr> 
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="95">Payment Term</td>
					<td width="198" class="sm"><input type="text" name="pay_term_dys" dataformat="int" maxlength="5" style="width:70;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;&nbsp;days</td>
					<td width="155">On-hire Handling Charge</td>
					<td width="138"><input type="text" name="onh_hndl_rt_amt" maxlength="18" dataformat="float" pointcount="2" caption="On-Hire Handling Charge" style="width:79;text-align:right;ime-mode:disabled" class="input" value=""></td>
					<td width="160">Off-hire Handling Charge</td>
					<td width=""><input type="text" name="offh_hndl_rt_amt" maxlength="18" dataformat="float" pointcount="2" caption="Off-Hire Handling Charge" style="width:75;text-align:right;ime-mode:disabled" class="input" value=""></td>
					</tr> 
				</table>
		
		<!-- Tab BG Box  (S) -->
			
		</td>
		</tr>
	</table>		
		
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
	
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 

<!--TAB Rental (S) -->
<div id="tabLayer" style="display:none">
	
	
     <table class="search"> 
      <tr><td class="bg">
				
				<!-- Grid  (S) -->
				<!-- Grid (E) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Rental Rate (USD)</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
			<table border="0" style="width:517; background-color:white;" class="grid2"> 
				<tr class="tr2_head"><td width="25%">Type</td>
					<td width="38%">During Build-up Period</td> 
					<td>During Fixed Period</td> 
				</tr>
				<tr><td class="tr2_head2">CLG</td>
					<td class="align_r"><input type="text" maxnum="999999999999999.99" name="mgst_bldp_rt_amt_clg" dataformat="float" pointcount="2" caption="During Build-up Period" style="width:100%;text-align:right;ime-mode:disabled"></td> 
					<td class="align_r"><input type="text" maxnum="999999999999999.99" name="mgst_lse_fx_rt_amt_clg" dataformat="float" pointcount="2" caption="During Fixed Period" style="width:100%;text-align:right;ime-mode:disabled"></td> 
					</tr>
				<tr><td class="tr2_head2">UMG</td>
					<td class="align_r"><input type="text" maxnum="999999999999999.99" name="mgst_bldp_rt_amt_umg" dataformat="float" pointcount="2" caption="During Build-up Period" style="width:100%;text-align:right;ime-mode:disabled"></td>
					<td class="align_r"><input type="text" maxnum="999999999999999.99" name="mgst_lse_fx_rt_amt_umg" dataformat="float" pointcount="2" caption="During Fixed Period" style="width:100%;text-align:right;ime-mode:disabled"></td>  
					</tr>
				</table>
			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				</td>
				</tr>
			</table>
	<!-- Tab BG Box  (S) -->	
	

</div>
<!--TAB Rental (E) --> 		
		
<!--TAB Depr (S) -->
<div id="tabLayer" style="display:inline">


     <table class="search"> 
      <tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="140">Monthly Depreciation</td>
					<td width="160"class="sm"><input type="text" name="mon_dpc_rt_amt" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Monthly Depreciation" style="width:100;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;&nbsp;%</td>
					<td width="115">Max. Depreciation</td>
					<td width="160" class="sm"><input type="text" name="max_dpc_rt_amt" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Max. Depreciation" style="width:100;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;&nbsp;%</td>
					<td width="88">Initial Factor</td>
					<td width=""class="sm"><input type="text" name="init_dpc_rt_amt" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Initial Factor" style="width:100;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;&nbsp;%</td>
					</tr> 
				</table>
				<!-- Grid  (S) -->
				<!-- Grid (E) -->
			<table border="0" style="width:517; background-color:white;" class="grid2"> 
				<tr class="tr2_head"><td width="25%">Type</td>
					<td>Initial Value(USD)</td> 
				</tr>
				<tr><td class="tr2_head2">CLG</td>
					<td class="align_r"><input type="text" name="onh_init_val_amt_clg" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Initial Value" style="width:100%;text-align:right;ime-mode:disabled"></td> 
					</tr>
				<tr><td class="tr2_head2">UMG</td>
					<td class="align_r"><input type="text" name="onh_init_val_amt_umg" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Initial Value" style="width:100%;text-align:right;ime-mode:disabled"></td> 
					</tr>
				</table>
			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				</td>
				</tr>
			</table>
	<!-- Tab BG Box  (S) -->


</div>
<!--TAB Depr (E) --> 		
		
		
<!--TAB Surcharge (S) -->
<div id="tabLayer" style="display:none">
	
	
     <table class="search"> 
      <tr><td class="bg">
				
				<!-- Grid  (S) -->
				<!-- Grid (E) -->
			<table border="0" style="width:517; background-color:white;" class="grid2"> 
				<tr class="tr2_head"><td width="25%">Type</td>
					<td width="38%">Post Trip Charge (POTC)	</td> 
					<td>Pre Trip Charge (PRTC)</td> 
				</tr>
				
				<tr><td class="tr2_head2">CLG</td>
					<td class="align_r"><input type="text" name="mgst_potc_scg_rt_amt_clg" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Post Trip Charge" style="width:100%;text-align:right;ime-mode:disabled"></td> 
					<td class="align_r"><input type="text" name="mgst_prtc_scg_rt_amt_clg" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Pre Trip Charge" style="width:100%;text-align:right;ime-mode:disabled"></td> 
					</tr>
				<tr><td class="tr2_head2">UMG</td>
					<td class="align_r"><input type="text" name="mgst_potc_scg_rt_amt_umg" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Post Trip Charge" style="width:100%;text-align:right;ime-mode:disabled"></td>
					<td class="align_r"><input type="text" name="mgst_prtc_scg_rt_amt_umg" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Pre Trip Charge" style="width:100%;text-align:right;ime-mode:disabled"></td>  
					</tr>
				</table>
			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				</td>
				</tr>
			</table>
	<!-- Tab BG Box  (S) -->	
	

</div>
<!--TAB Surcharge (E) -->  
		
				<table class="height_8"><tr><td colspan="8"></td></tr></table>
			 <table class="search"> 
      <tr><td class="bg">	
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head"><td width="125">Remark(s)</td>
				<td class=""><textarea name="diff_rmk" rows="6" style="width:100%;ime-mode:disabled"></textarea></td> 
				</tr>
				
				</table>
	</td>
				</tr>
			</table>		
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				</td>
				</tr>
			</table>
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
    <!--Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>

<!-- hidden 처리 (S)-->
<div id="mainTable" style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- hidden 처리 (E)-->

</html>