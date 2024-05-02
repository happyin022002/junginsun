<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0110.jsp
*@FileTitle : Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.5
* 2008-09-11 O Wan-Ki 1.0 최초 생성
* 2009-04-21 O Wan-Ki 1.1 N200904160080, Invoice Creation 폼 변경 (주소선택기능추가)
* 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-07-09 O Wan-Ki 1.3 N200907020250, 인도세금포맷 동적변경기능 추가
* 2009-08-12 O Wan-Ki 1.4 ALPS 최초생성
* 2009-09-14 Park Sung-Jin 1.5 ALPS Migration 작업
* 2010-10-22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완 -  currency combo 사이즈 변경
* 2015-06-17 김현화 [CHM-201536392]PKGBB GST 계산시 에러 수정 요청
* 2015.08.22 Kim Hyun Hwa [CHM-201537151]그룹사 표준 코드 시행 프로그램 수정
* 2015.11.12 Kim Hyun Hwa [CHM-201538882]인도지역 Swachh Bharat Cess(SBC) 신설 관련 TPB Invoice 수정
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	
	EsdTpb0110Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null; 	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;
	//Map<String,String> rowSet = new HashMap<String,String>();
	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;
	//* 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
	Map<String,String> rowSetIndiaTaxInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.InvoiceManage");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String s_dao_n3pty_no = "";
	String pop_yn = "";
	
	String s_length_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_length_n3pty_bil_tp_cd")).trim();
	int s_length_n3pty_bil_tp_cd_int = 1; //Sheet Maxinum 갯수
	try {
		s_length_n3pty_bil_tp_cd_int = Integer.parseInt(s_length_n3pty_bil_tp_cd);
	} catch (Exception e) {
		s_length_n3pty_bil_tp_cd_int = 1;
		out.println(e.toString());
	}

	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	String indiaTaxForm = JSPUtil.getNull(request.getParameter("indiaTaxForm"));//* 2009-07-09 O Wan-Ki
	
	s_dao_n3pty_no = JSPUtil.getNull(request.getParameter("s_dao_n3pty_no"));
	pop_yn = JSPUtil.getNull(request.getParameter("pop_yn"));
	
	//* 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
	String ida_tax_seq = "";
	String expn_tax = "";
	String edu_tax = "";
	String high_edu_tax = "";
	String tax_rgst_no = "";
	String svc_cate_rmk = "";
	String pmnt_acct_no = "";
	String locl_tax_rt = ""; //2015-11-12  SBC 추가
	String n2nd_locl_tax_rt  = ""; //2016-06-01 적용 KKC 추가

	String [] user_auth = null;
	
	//log.debug("s_length_n3pty_bil_tp_cd_int====>"+s_length_n3pty_bil_tp_cd_int);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		//* 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
		user_auth = account.getUserAuth();
		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌  TPB 자체적으로 가져오도록 변경한다.

		event = (EsdTpb0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if( !indiaTaxForm.equals("Y")&&!indiaTaxForm.equals("N")&&cnt_cd.equals("IN") ){
			indiaTaxForm = "Y";
		}

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				rowSet = eventResponse.getETCData();
				
				if (rowSet != null) {
					rowCount = eventResponse.getDataCntList().size();
				} // end if
				
				rowSetOtsGrpInfo = eventResponse.getETCData();

				if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					s_length_n3pty_bil_tp_cd_int = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
				}
				
				//* 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
				rowSetIndiaTaxInfo = eventResponse.getETCData();
				if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					ida_tax_seq = eventResponse.getETCData("ida_tax_seq");
					expn_tax = eventResponse.getETCData("expn_tax");
					edu_tax = eventResponse.getETCData("edu_tax");
					high_edu_tax = eventResponse.getETCData("high_edu_tax");
					tax_rgst_no = eventResponse.getETCData("tax_rgst_no");
					svc_cate_rmk = eventResponse.getETCData("svc_cate_rmk");
					pmnt_acct_no = eventResponse.getETCData("pmnt_acct_no");
					//locl_tax_rt = eventResponse.getETCData("locl_tax_rt"); //2015-11-12 SBC 추가
				}
			} // end if
		} // end else
			
		

	}catch(Exception e) {
		out.println(e.toString());
	}

	//if (event != null) {
	//	if (event.getAttribute("s_dao_n3pty_no") != null) {
	//		s_dao_n3pty_no = event.getAttribute("s_dao_n3pty_no").toString();
	//	}
	//}

	

	String[] officeInfo = com.hanjin.apps.alps.esd.tpb.common.TPBUtils
			.getHandleOfficeLevel(ofc_cd); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	// String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd = JSPUtil.getNull(officeInfo[2]); // RHQ Code

%>
<html>
<head>
<title>Invoice Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00582", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase 
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">
<input type="hidden" name="load_num" value="0">
<input type="hidden" name="s_dao_n3pty_no" value="<%=s_dao_n3pty_no%>">
<input type="hidden" name="s_dao_n3pty_bil_tp_cd">
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd%>">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_sum_inv_amt">
<input type="hidden" name="s_phn_no">
<input type="hidden" name="s_inv_rmk1">
<input type="hidden" name="s_inv_rmk2">
<input type="hidden" name="s_sheet_set_count">
<input type="hidden" name="s_bil_loc">
<input type="hidden" name="s_his_seq">
<input type="hidden" name="s_vndr_cust_eml">
<input type="hidden" name="s_vat_xch_rt">
<input type="hidden" name="s_from_curr_cd">
<input type="hidden" name="s_n3pty_inv_his_seq" value="">
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="pop_yn" value="<%=pop_yn%>">

<% //* 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] %>
<input type="hidden" name="s_ida_tax_seq" value="<%=ida_tax_seq%>">
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="expn_tax" value="<%=expn_tax %>">
<input type="hidden" name="edu_tax" value="<%=edu_tax %>">
<input type="hidden" name="high_edu_tax" value="<%=high_edu_tax %>">
<input type="hidden" name="tax_rgst_no" value="<%=tax_rgst_no %>">
<input type="hidden" name="svc_cate_rmk" value="<%=svc_cate_rmk %>">
<input type="hidden" name="pmnt_acct_no" value="<%=pmnt_acct_no %>">

<input type="hidden" name="prcs_cnt">
<input type="hidden" name="locl_tax_rt" value="<%=locl_tax_rt%>">
<input type="hidden" name="n2nd_locl_tax_rt" value="<%=n2nd_locl_tax_rt%>">

<input type="hidden" name="s_inv_dtl_add_amt">

<!-- <input type="hidden" name="s_n3pty_inv_no"> -->
<!-- <input type="hidden" name="s_vndr_cust_addr"> -->
<!-- <input type="hidden" name="s_vndr_cust_nm"> -->

<%=JSPUtil.getIncludeString(request)%>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
				<!-- CSS for 'RIGHT' frame --> <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Service Management > 3rd Party Billing > TPB Process > Invoice Creation</td></tr>
					<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Invoice Creation</td></tr>
				</table>
<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_confirm_t">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_erpInterface_t" style="display:none;">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_erpInterface" id="btn_erpInterface">ERP Interface</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_revisiondetail_t" style="display:none;">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_revisiondetail" id="btn_revisiondetail">Revision Detail</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_preview_t">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_preview" id="btn_preview">Preview</td><td class="btn1_right"></td></tr></table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_close_t" style="display:none;">
									<tr><td class="btn1_line"></td><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>	
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Year ) (S) -->
						<table class="search" border="0" bordercolor="red">
							<tr class="h23">
								<td width="80">Invoice No.</td>
								<td width="190"><input name="s_n3pty_inv_no" type="text" class="input" style="width: 95; . background-color: #EEEEEE;" value="" readonly> <input type="text" class="input" style="width: 33; . background-color: #EEEEEE;" name="s_n3pty_inv_rmd_cd" value="" readonly></td>
								<td width="70"><img class="nostar">Currency</td>
								<td width="130">
									<select class="input1" style="width:95;" name="s_curr_cd" caption="Currency" onchange='changeCurrency(this.value)'>
									</select>
								</td>

								<%//* 2009-07-09 O Wan-Ki 1.3 N200907020250, 인도세금포맷 동적변경기능 추가
									if(cnt_cd.equals("IN")){
								%>
								<td width="55">SVC Tax</td>
								<td width="25"><input type="checkbox" class="trans" name="indiaTaxForm" <%if(indiaTaxForm.equals("Y")){%>checked value="Y"<%}%> onclick="onclick_indiaTaxForm_checkbox();">
								</td>
								<%}else{ %>
									<input type="hidden" name="indiaTaxForm" value="<%=indiaTaxForm %>">
								<%} %>

								<td width="160"></td>
								<td width="120" align="right">Fax Number</td>
								<td width="">&nbsp;&nbsp;&nbsp;<input type="text" style="width: 90;" name="s_fax_no" maxlength="20" readonly></td>
								<!-- <td width="" <%if(cnt_cd.equals("IN")){//* 2009-06-07 O Wan-Ki 1.2 %>style="display:none"<%}%>>&nbsp;&nbsp;VAT</td>  -->
								<td width="" <%if(cnt_cd.equals("IN")){//* 2009-06-07 O Wan-Ki 1.2 %>style="display:none"<%}%>><input type="checkbox" name="s_vat_xch_rt_chk" class="trans" onclick="amtReCalculate();" value="Y" style="display:none"></td>

							</tr>
						</table>
						<!-- : ( Year ) (E) --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->

				<table class="height_10">
					<tr>
						<td></td>
					</tr>
				</table>


				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Year ) (S) --> <!-- 2009-04-21, N200904160080 에 의한 주석처리.
							<table border="0" class="grid2">
					      			<tr class="tr2_head">
					      				<td width="450">Bill To</td>
					      				<td width="130">Code</td>
					      				<td width="130">Reference</td>
									<td width="132">Due Date</td>
					      				<td width="113">VAT No.</td></tr>

					      			<tr>
					      				<td class="stm" align='center'>
					      					<input name="s_usr_inp_ctnt1" type="text" class="" style="width:445"><br>
					      					<input name="s_vndr_cust_nm" type="text" class="noinput" style="width:445" readonly><br>
					      					<input name="s_vndr_cust_addr" type="text" class="" style="width:445" maxlength='100'><br>
					      					City : <input name="s_cty_nm" type="text" class="" style="width:193" maxlength='50'>
					      					&nbsp; State : <input name="s_ste_cd" type="text" class="" style="width:45" maxlength='3'>
					      					&nbsp; Zip : <input name="s_zip_cd" type="text" class="" style="width:80" maxlength='10'><br>
					      					<input name="s_usr_inp_ctnt2" type="text" class="" style="width:445" maxlength='100'>
										</td>
					      				<td align='center'><input name="s_trd_party_code_detail" type="text" class="noinput" style="width:95" readonly></td>
					      				<td align='center'><textarea name="s_vndr_cust_ref_rmk" class=""  style="width:100%;height=100;overflow-y:auto;overflow-x:auto" onblur="tpb_chkLenByByte(this,500,'Reference')"></textarea></td>
										<td><input name="s_rcv_due_dt" type="text" class="noinput" style="width:70" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					      				<td align='center'><textarea name="s_rgst_no" class=""  style="width:100%;height:100;overflow-y:auto;overflow-x:auto" onblur="tpb_chkLenByByte(this,20,'VAT No.')"></textarea></td>
					      			</tr>
			       			</table>
       			--> <!-- * 2009-04-21 O Wan-Ki 1.1 N200904160080, Invoice Creation 폼 변경 (주소선택기능추가)-->
						<table border="0" class="grid2">
							<tr>
								<td>


								<table border="0">
									<tr>
										<td class="tr2_head" width="">Bill to</td>
									</tr>
									<tr>
										<td>

										<table border="0" class="grid2" width="700">
											<tr>
												<td align="right" style="width: 90">Attention&nbsp;</td>
												<td><input name="s_usr_inp_ctnt1" type="text" class="" style="width: 600; font-size: 8pt"></td>
											</tr>
											<tr>
												<td align="right">Company&nbsp;</td>
												<td><input name="s_trd_party_code_detail" type="text" class="tr3_head" style="width: 100" readonly> <input name="s_vndr_cust_nm" type="text" class="noinput" style="width: 385; font-size: 8pt" readonly></td>
											</tr>
											<tr>
												<td align="right"><input type="radio" name="s_rch" class="noinput" value="addr1" checked>&nbsp;Address 1.</td>
												<td><input name="s_vndr_cust_addr" type="text" class="" style="width: 600; font-size: 8pt" maxlength='200'>
												</td>
											</tr>
											<tr>
												<td align="right"><input type="radio" name="s_rch" class="noinput" value="addr2">&nbsp;Address 2.</td>
												<td><input name="s_vndr_cust_addr2" type="text" class="" style="width: 600; font-size: 8pt" maxlength='100'>
												</td>
											</tr>
											<tr>
												<td align="right">City&nbsp;</td>
												<td><input name="s_cty_nm" type="text" class="" style="width: 375" maxlength='50'><!-- city name 50 -->
												    &nbsp;&nbsp;State : <input name="s_ste_cd" type="text" class="" style="width: 50" maxlength='3'><!-- state code 3 -->
												    &nbsp;&nbsp; Zip : <input name="s_zip_cd" type="text" class="" style="width: 90" maxlength='10'><!-- zip code 10 -->
												</td>
											</tr>
											<tr>
												<td align="right"></td>
												<td align="right"><input name="s_usr_inp_ctnt2" type="text" class="" style="width: 600; font-size: 8pt"></td>
											</tr>
										</table>

										</td>
									</tr>
									<tr id='tr_ida_form' name='tr_ida_form' style="display:none">
										<td>
											<table>
												<tr>
													<td>State Name : <input class="noinput" name="ida_ste_nm" type="text" style="width:160">
														&nbsp;&nbsp; GSTIN/UIN : <input class="noinput" name="ida_gst_rgst_no" type="text" style="width:130">
														&nbsp;&nbsp; GST Registration : <input class="noinput" name="ida_gst_rgst_no_flg" type="text" style="width:60">
														&nbsp;&nbsp; SEZ Unit : <input class="noinput" name="ida_spcl_ecn_zn_ut_flg" type="text" style="width:25">
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>


								</td>
								<td>


								<table border=0 class="grid2" width="270" height="100%">
									<tr>
										<td class="tr2_head" align="center" style="width: 70">Reference</td>
										<td><textarea name="s_vndr_cust_ref_rmk" class="" style="width: 100%; height: 60; overflow-y: auto; overflow-x: auto" onblur="tpb_chkLenByByte(this,50,'Reference')"></textarea></td>
									</tr>
									<tr>
										<td class="tr2_head" align="center">Due Date</td>
								<% if(cnt_cd.equals("US") || cnt_cd.equals("CA") || cnt_cd.equals("MX")){%>
										<td><input name="s_rcv_due_dt" type="text" class="noinput" style="width: 70" maxlength="10" value="<%=DateTime.addDays(currentDay, 7, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
								<%} else{%>										
										<td><input name="s_rcv_due_dt" type="text" class="noinput" style="width: 70" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
								<%} %>		
										</td> 
									</tr>
									<tr>
										<td class="tr2_head" align="center">VAT No.</td>
										<td><textarea name="s_rgst_no" class="" style="width: 100%; height: 60; overflow-y: auto; overflow-x: auto" onblur="tpb_chkLenByByte(this,20,'VAT No.')"></textarea></td>
									</tr>
								</table>


								</td>
							</tr>
						</table>
						<!-- * 2009-04-21 O Wan-Ki 1.1 N200904160080, Invoice Creation 폼 변경 (주소선택기능추가)-->



						<!-- : ( Year ) (E) --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->
 <%
 	for (int i = 0; i < s_length_n3pty_bil_tp_cd_int; i++) {
 %>

				<!-- TABLE '#D' : ( Tab ) (S) -->
				<table>
					<tr>
						<td height="10"></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
				
				<table class="tab">
		           	<tr><td><script language="javascript">ComTabObject('tab<%=i+1%>')</script></td></tr>
				</table>
				
				<!-- TABLE '#D' : ( Tab ) (E) -->
				
				<table class="search">
					<tr>
						<td height="1" bgcolor="#8385D9"></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Tab ) (E) --> <!-- TABLE '#D' : ( Grid ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">

						<table class="height_10">
							<tr>
								<td></td>
							</tr>
						</table>

						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet<%=i+1%>');</script>
								</td>
							</tr>
						</table>
						<!-- : ( POR ) (E) --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Grid ) (E) -->


				<%
					}
				%> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="height_10"><tr><td></td></tr></table>

				<% if(!(cnt_cd.equals("IN")&&indiaTaxForm.equals("Y"))){//* 2009-06-07 %>
				<table class="search" style="width: 300">
					<tr>
						<td class="bg">
						<table border="0" class="grid2" style="width: 450">
							<tr>
								<td width="35%" class="tr2_head" align="left"><img
									class="nostar">Net Amount</td>
								<td class="stm">&nbsp;<input name="s_net_amt" type="text"
									class="noinput" style="width: 95%; text-align: right" readonly></td>
							</tr>
							<%if(ofc_cd.equals("PKGSC")){ %>
							<tr>
								<td class="tr2_head" align="left"><img class="nostar">Administration&nbsp;Charge</td>
								<td class="stm">&nbsp;<input name="s_add_amt" type="text"
									class="input" style="width: 95%; text-align: right"
									onclick="this.select()"
									onblur="tpb_otherAmountReCalculate(this);calculateGst();"></td>
							</tr>
							<tr>
								<td class="tr2_head" align="left"><img class="nostar">Discount&nbsp;Amount</td>
									<td class="stm">&nbsp;<input name="s_ddct_amt" type="text"
									class="input" style="width: 95%; text-align: right"
									onclick="this.select()"
									onblur="tpb_otherAmountReCalculate(this);calculateGst();"></td>
							</tr>
							<tr>
								<td class="tr2_head" align="left"><img class="nostar">GST&nbsp;Amount</td>
									<td class="stm">&nbsp;<input name="s_vat_amt" type="text"
									class="noinput" style="width: 95%; text-align: right"
									onclick="this.select()"
									onblur="amtReCalculate()" readonly></td>
							</tr>
                	      <%}else{%>
							<tr>
								<td class="tr2_head" align="left"><img class="nostar">Administration&nbsp;Charge</td>
								<td class="stm">&nbsp;<input name="s_add_amt" type="text"
									class="input" style="width: 95%; text-align: right"
									onclick="this.select()"
									onblur="tpb_otherAmountReCalculate(this);"></td>
							</tr>
							<tr>	
								<td class="tr2_head" align="left"><img class="nostar">Deducted&nbsp;Amount</td>
								<td class="stm">&nbsp;<input name="s_ddct_amt" type="text"
									class="input" style="width: 95%; text-align: right"
									onclick="this.select()"
									onblur="tpb_otherAmountReCalculate(this);"></td>
							</tr>
							<tr>
								<td class="tr2_head" align="left"><img class="nostar">VAT&nbsp;Amount</td>
								<td class="stm">&nbsp;<input name="s_vat_amt" type="text"
									class="noinput" style="width: 95%; text-align: right"
									onclick="this.select()"
									onblur="amtReCalculate()" readonly></td>
							</tr>
	                     <%}%>
							<tr>
								<td class="tr2_head" align="left"><img class="nostar">Total&nbsp;Amount</td>
								<td class="stm">&nbsp;<input name="s_total_amt" type="text"
									class="noinput" style="width: 95%; text-align: right" readonly></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<%}else{ // ########### India Case ############%>
				<table class="search">
					<tr>
						<td class="bg" width="30%" valign="top">
						<B>[ Expense ]</B>
						<table border="0" class="grid2" width="100%">
							<tr>
								<td class="stm" align="left" width="50%">Net Amount</td>
								<td class="stm">&nbsp;<input name="s_net_amt" type="text"
									class="noinput" style="text-align: right; width:96%" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left">Administration Charge</td>
								<td class="stm">&nbsp;<input name="s_add_amt" type="text"
									class="input" style="text-align: right;width:96%" onclick="this.select();"
									onblur="tpb_otherAmountReCalculate(this);calculateForIndiaInvoice();"></td>
							</tr>
							<tr>
								<td class="stm" align="left">Deducted Amount</td>
								<td class="stm">&nbsp;<input name="s_ddct_amt" type="text"
									class="input" style="text-align: right;width:96%" onclick="this.select();"
									onblur="tpb_otherAmountReCalculate(this);calculateForIndiaInvoice();"></td>
							</tr>
							<tr style="display:none">
								<td class="stm" align="left">VAT Amount</td>
								<td class="stm">&nbsp;<input name="s_vat_amt" type="text" style="width:96%"
									class="noinput" style="text-align: right; width:96%"
									onclick="this.select()"
									onblur="amtReCalculate()" readonly>
									<input name="s_locl_tax_amt" type="text" style="width:96%"
									class="noinput" style="text-align: right; width:96%"
									onclick="this.select()"
									onblur="amtReCalculate()" readonly>
									<input name="s_n2nd_locl_tax_amt" type="text" style="width:96%" readonly>
								</td>
							</tr>
							<tr>
								<td class="stm" align="left">Total Amount</td>
								<td class="stm">&nbsp;<input name="s_total_amt" type="text"
									class="noinput" style="text-align: right; width:96%" readonly></td>
							</tr>
						</table>
						</td>

						<td width="1%"></td>

						<td class="bg" valign="top" width="35%">
						<B>[ Tax ]</B>
						<table border="0" class="grid2" width="100%">
							<tr>
								<td class="stm" align="left" width="35%">CGST</td>
								<td class="stm" width="25%"><input class="noinput" type="text" name="ida_cgst_rto" style="width:80%; text-align:right" readonly>%</td>
								<td class="stm" width="40%"><input class="noinput" type="text" name="ida_cgst_amt" style="width:96%; text-align:right" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">SGST</td>
								<td class="stm" width="25%"><input class="noinput" type="text" name="ida_sgst_rto" style="width:80%; text-align:right" readonly>%</td>
								<td class="stm" width="40%"><input class="noinput" type="text" name="ida_sgst_amt" style="width:96%; text-align:right" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">UGST</td>
								<td class="stm" width="25%"><input class="noinput" type="text" name="ida_ugst_rto" style="width:80%; text-align:right" readonly>%</td>
								<td class="stm" width="40%"><input class="noinput" type="text" name="ida_ugst_amt" style="width:96%; text-align:right" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">IGST</td>
								<td class="stm" width="25%"><input class="noinput" type="text" name="ida_igst_rto" style="width:80%; text-align:right" readonly>%</td>
								<td class="stm" width="40%"><input class="noinput" type="text" name="ida_igst_amt" style="width:96%; text-align:right" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">GST Total</td>
								<td class="stm" width="25%"><input class="noinput" type="text" name="ida_tot_gst_rto" style="width:80%; text-align:right" readonly>%</td>
								<td class="stm" width="40%"><input class="noinput" type="text" name="ida_tot_gst_amt" style="width:96%; text-align:right" readonly></td>
							</tr>
						</table>
						
						<br>
						
						<table border="0" class="grid2" width="100%">
							<tr>
								<td class="stm" align="left" width="35%">GSTIN/UIN</td>
								<td class="stm" width="65%"><input name="ida_ofc_gst_rgst_no" type="text" class="noinput" style="text-align: left; width:96%" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">PAN No.</td>
								<td class="stm" width="65%"><input name="ida_pan_no" type="text" class="noinput" style="text-align: left; width:96%" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">Bank Account No.</td>
								<td class="stm" width="65%"><input name="ida_bank_acct_no" type="text" class="noinput" style="text-align: left; width:96%" readonly></td>
							</tr>
							<tr>
								<td class="stm" align="left" width="35%">IFSC Code</td>
								<td class="stm" width="65%"><input name="ida_ifsc_cd" type="text" class="noinput" style="text-align: left; width:96%" readonly></td>
							</tr>
						</table>
						</td>

						<td width="1%"></td>

						<td class="bg" valign="top" width="30%">
						<B>[ Invoice Amount ]</B>
						<table border="0" class="grid2" width="100%">
							<tr>
								<td class="stm" align="left" width="50%">Expense</td>
								<td class="stm" width="50%">
									<input name="lst_expense" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
							<tr style="display:none">
								<td class="stm" align="left">TVA</td>
								<td class="stm">
									<input name="lst_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
														<tr>
								<td class="stm" align="left">Tax</td>
								<td class="stm">
									<input name="tot_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
							<tr>
								<td class="stm" align="left">Invoice Total</td>
								<td class="stm">
									<input name="lst_invoice_total" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>

						</table>
						</td>
					</tr>
				</table>
				<%} %>

				<table class="height_10"><tr><td></td></tr></table>

				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Year ) (S) -->
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Descriptions</td>
							</tr>
							<tr>
								<td class="height_5"></td>
							</tr>
						</table>
						<table border="0" class="search_in">

							<tr>
								<td><!-- <input name="s_inv_desc" type="text" class="input" style="width:720;background-color:F3F2F8; border: #F3F2F8"> -->
								<textarea name="s_inv_desc" class="input"
									style="width: 977; height =35; overflow-y: auto; overflow-x: auto; background-color: #FFFFFF; border: #F3F2F8"
									<%if(cnt_cd.equals("FR")){ %>
									onblur="tpb_chkLenByByte(this,500,'Descriptions')" 
									<%} else{ %>
									onblur="tpb_chkLenByByte(this,1000,'Descriptions')"
									<%} %>>
								</textarea>
								</td>
							</tr>

						</table>
						<!-- : ( Year ) (E) --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


<!-- Outer Table (E)-->
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
<div id='div_processing' name='div_processing'
	style='position: absolute; left: 0; top: 0; z-index: 100; display: none; width: 100%; height: 100%'>
<table border='0' bordercolor='red' cellpadding='0' cellspacing='0'
	width='100%' height='100%'>
	<!-- <tr><td align='center'><img src="/hanjin/img/alps/processing.gif"></td></tr>  -->
	<tr>
		<td align='center' height='10'>&nbsp;</td>
	</tr>
	<tr>
		<td align='center' height='100'><img
			src="/hanjin/img/alps/processing.gif"></td>
	</tr>
	<tr>
		<td align='center' height='*'>&nbsp;</td>
	</tr>
</table>
</div>

    </td></tr>
</table>
</form>
<div style="display:none">
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet0');</script>
		</td>
	</tr>
</table>
</div>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!-- 
	  /* 
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다. 
	  */
<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
	function sheet<%=i+1%>_OnPopupClick(sheetObj,Row,Col,Value){
		var colName = sheetObj.ColSaveName(Col);
		if(colName == "occr_dt" || colName == "damage_dt" 
			|| colName == "lst_free_dt" || colName == "pkup_dt"){
			 var cal = new ComCalendarGrid();
			 cal.select(sheetObj, Row,Col,'yyyy-MM-dd');
			 			
		}
		if(colName == "new_vsl_cd"){
			var param = '?sdate='+form.sdate.value+'&edate='+form.edate.value;
			ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',true, false, Row, Col);
		}
		
	}
	function sheet<%=i+1%>_OnSearchEnd(sheetObj,errMsg){
		if ( document.all.cnt_cd.value == 'IN' )
		{
			sheetObj.ColHidden("vat_dtl_chk") = true;
			sheetObj.ColHidden("vat_dtl_amt") = true;
		}
		
		for ( var i = 1; i <= sheetObj.RowCount; i++ ){
			var eqNo = sheetObj.CellValue(i, "eq_no");
			var tpbExpnTpCd = sheetObj.CellValue(i, "n3pty_expn_tp_cd");
			var tpbIfTpCd = sheetObj.CellValue(i, "n3pty_if_tp_cd");
			var estmSeqNo = sheetObj.CellValue(i, "estm_seq_no"); 
			var estmRvisNo = sheetObj.CellValue(i, "estm_rvis_no");
  			if(eqNo != null && eqNo !="" && tpbExpnTpCd == "MNR" && tpbIfTpCd == "S"){
  				sheetObj.CellFontUnderline(i, "eq_no") = true;
  			}

			//Currency Code에 따른 소수점 자리수 반올림 구하기
  			var invAmt = sheetObj.CellValue(i, "inv_dtl_amt");
  			var prcsCnt = document.all.prcs_cnt.value;
  			var amtPrcs = 1;
  			
  			if( prcsCnt >= 3 ) prcsCnt = 2;
  			
  			for(var j=0;j<prcsCnt;j++)
  			{
  				amtPrcs = amtPrcs * 10;
  			}
  			var fltAmt = Math.round(invAmt * amtPrcs) / amtPrcs;
  			sheetObj.CellValue2(i, "inv_dtl_amt") = fltAmt;

  		}
		// 2015.08.22 조직변경
		if(document.form.s_ofc_cd.value ==     "ATLSC" //"ATLBB"
  			|| document.form.s_ofc_cd.value == "ATLSA" //"ATLSC"
  			|| document.form.s_ofc_cd.value == "CHISC" //"CHIBB"
  			|| document.form.s_ofc_cd.value == "HOUSC" //"HOUBB"
  			|| document.form.s_ofc_cd.value == "ILMBS"          
  			|| document.form.s_ofc_cd.value == "LGBSC" //"LGBBB"
  			|| document.form.s_ofc_cd.value == "NYCSC" //"NYCBB"
  			|| document.form.s_ofc_cd.value == "ORFSO" //"ORFBS"
  			|| document.form.s_ofc_cd.value == "PDXSO" //"PDXBS"
  			|| document.form.s_ofc_cd.value == "PHXSA" //"PHXSC"
  			|| document.form.s_ofc_cd.value == "SAVSO" //"SAVBS"
  			|| document.form.s_ofc_cd.value == "SEASC" //"SEABB"
  			){
  			for(var i=1;i<sheetObj.Rows;i++){

  				sheetObj.CellEditable(i,"vat_dtl_chk") = false;
  			}
  		}
	}
	function sheet<%=i+1%>_OnClick(sheetObj,Row,Col,Value){
		var colName = sheetObj.ColSaveName(Col);
		if(colName == "eq_no"){
			var param;
  			var theURL;
  			var winName;
  			var features;
			var eqNo = sheetObj.CellValue(Row, "eq_no");
			var tpbExpnTpCd = sheetObj.CellValue(Row, "n3pty_expn_tp_cd");
			var tpbIfTpCd = sheetObj.CellValue(Row, "n3pty_if_tp_cd");
			var estmSeqNo = sheetObj.CellValue(Row, "estm_seq_no"); 
			var estmRvisNo = sheetObj.CellValue(Row, "estm_rvis_no");
			var eqKndCd = sheetObj.CellValue(Row, "eq_knd_cd")

			if(eqNo != null && eqNo !="" && tpbExpnTpCd == "MNR" && tpbIfTpCd == "S"){
				//param = "?pgmNo=EES_MNR_0192&rqst_eq_no=HJCU8304358&rpr_rqst_seq=1&rpr_rqst_ver_no=3&eq_knd_cd=U";
				param = "?pgmNo=EES_MNR_0192&rqst_eq_no="+eqNo+"&rpr_rqst_seq="+estmSeqNo+"&rpr_rqst_ver_no="+estmRvisNo+"&eq_knd_cd="+eqKndCd;
				ComOpenPopup('/hanjin/EES_MNR_0192.do'+param, 1024, 768, '', '0,0', false);
			}
		}
	}

	function sheet<%=i+1%>_OnChange(sheetObj,Row,Col,Value){
		_sheet_onchange( sheetObj,Row,Col,Value );
		var colName = sheetObj.ColSaveName(Col);
		
		if( colName == "inv_dtl_amt" || colName == "vat_dtl_amt" || colName == "vat_dtl_chk" || colName == "inv_dtl_add_amt")
		{
			var prcsCnt = document.all.prcs_cnt.value;
  			var amtPrcs = 1;
  			if( prcsCnt >= 3 ) prcsCnt = 2;
  			for(var j=0;j<prcsCnt;j++)
  			{
  				amtPrcs = amtPrcs * 10;
  			}
  			
	  			
			if(colName == "inv_dtl_amt"){
	
				//Currency Code에 따른 소수점 자리수 반올림 구하기
				var invAmt = sheetObj.CellValue(Row, "inv_dtl_amt");
	  			
	  			var fltAmt = Math.round(invAmt * amtPrcs) / amtPrcs;
	  			sheetObj.CellValue2(Row, "inv_dtl_amt") = fltAmt;
			
			
				//Auto Update 아닐 경우 금액 비교
				if( sheetObj.CellValue(Row, "so_if_seq") == 0 ){
					if(parseFloat(sheetObj.CellValue(Row, "ots_amt")) < parseFloat(sheetObj.CellValue(Row, colName))){
						/** 2009-06-07 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
						 *  Invoice 의 증액가능을 위한 주석처리.  
						ComShowCodeMessage("TPB90032","Invoice AMT","Original AMT"); // 이하
						sheetObj.CellValue2(Row, colName) = sheetObj.CellValue(Row, "original_inv_dtl_amt");
						return;
						 */
					} else if ( parseFloat(sheetObj.CellValue(Row, colName)) <= 0 ) { // 초과
						ComShowCodeMessage("TPB90035","Invoice AMT","0.00");
						sheetObj.CellValue2(Row, colName) = sheetObj.CellValue(Row, "original_inv_dtl_amt");
						return;
					}
				}

				var vatXchRt = document.all.s_vat_xch_rt.value;
				var vatChk = sheetObj.CellValue(Row, "vat_dtl_chk");
			
				if( vatChk == 1 )
				{
					sheetObj.CellValue2(Row, "vat_dtl_amt") = Math.round((invAmt * (vatXchRt / 100)) * amtPrcs) / amtPrcs;
				}
			}
			
			if(colName == "vat_dtl_amt")
			{
				var vatAmt = sheetObj.CellValue(Row, "vat_dtl_amt");
	  			var fltAmt = Math.round(vatAmt * amtPrcs) / amtPrcs;
	  			sheetObj.CellValue2(Row, "vat_dtl_amt") = fltAmt;
	  		}
	  		
	  		//Detail VAT 적용 ( 2010-06-04  SELCOL 장병용 부장 요청으로 VAT 적용 로직 변경 )
			if( colName == "vat_dtl_chk" )
			{
/*
				if ( sheetObj.CheckAll("vat_dtl_chk") == 1 )
				{
					sheetObj.CellEditable(Row, "vat_dtl_chk") = false;
				}

				else if ( sheetObj.CheckAll("vat_dtl_chk") == 0 )
				{
					for ( var idx = 1; idx <= sheetObj.RowCount; idx++ )
					{
						sheetObj.CellEditable(idx, "vat_dtl_chk") = true;
						sheetObj.CellValue(idx, "vat_dtl_chk") = 0;
					}
				}
*/
			
				var vatXchRt = document.all.s_vat_xch_rt.value;
				var inv_amt = sheetObj.CellValue(Row, "inv_dtl_amt")
			
				if( Value == 1 )
				{
					sheetObj.CellValue2(Row, "vat_dtl_amt") = Math.round((inv_amt * (vatXchRt / 100)) * amtPrcs) / amtPrcs;
					sheetObj.CellEditable(Row, "vat_dtl_amt") = true;
				}
				else
				{
					sheetObj.CellValue2(Row, "vat_dtl_amt") = 0;
					sheetObj.CellEditable(Row, "vat_dtl_amt") = false;
				}
			}
    		if(colName == "inv_dtl_add_amt"){
    			if ( parseFloat(sheetObj.CellValue(Row, colName)) < 0 ) { // 초과
					ComShowCodeMessage("TPB90035","Add AMT","0.00");
					sheetObj.CellValue2(Row, colName) = 0.00;
					return;
				}
    			invDtlAddamtReCalculate();
    			tpb_otherAmountReCalculate(this);
    			if( document.form.cnt_cd.value == "IN" && document.form.indiaTaxForm.value == "Y"){
        			calculateForIndiaInvoice();
        		}
    		}else {
    			amtReCalculate();
    		}
			//amtReCalculate();
			//[CHM-201536392]PKGSC(PKGBB) GST 계산시 에러 수정 요청
			if (document.form.s_ofc_cd.value == "PKGSC" ){
			     calculateGst();
			}
			
    		if( document.form.cnt_cd.value == "IN" && document.form.indiaTaxForm.value == "Y"){
    			calculateForIndiaInvoice();
    		}

		}
		//Outstanding Amount 의 Auto Upate check
		//tpb_chgColor_ots_amt(sheetObj, 44, 27, Row);

		
		//Sheet의 Terminal Name, ATD 값 가져오기
		if( colName == "yd_cd" ){
			document.form.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("ESD_TPB_0110GS.do", tpbFrmQryStr(document.form) + "&yd_cd="+sheetObj.CellValue(Row, "yd_cd") + "&vvd_cd="+sheetObj.CellValue(Row, "vvd_cd"));
			sheetObj.CellValue2(Row, "atd") = ComGetEtcData(sXml, "atd");
			sheetObj.CellValue2(Row, "yd_nm") = ComGetEtcData(sXml, "yd_nm");
		}
	}
	
	function sheet<%=i+1%>_OnMouseDown(Button, Shift, X, Y){
		var curCol = sheetObjects[<%=i%>].MouseCol;
		var curRow = sheetObjects[<%=i%>].MouseRow;
		var colName = sheetObjects[<%=i%>].ColSaveName(curCol);

		if ( colName == "vat_dtl_chk" && curRow == 0 && sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 1 )
		{
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 0;
			
			for( var idx = sheetObjects[<%=i%>].HeaderRows; idx <= sheetObjects[<%=i%>].LastRow; idx++ ){
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = true;
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 0;
			}
		}
		else if ( colName == "vat_dtl_chk" && curRow == 0 && sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 0 )
		{
			for( var idx = sheetObjects[<%=i%>].HeaderRows; idx <= sheetObjects[<%=i%>].LastRow; idx++ ){
				sheetObjects[<%=i%>].CellValue(idx, "vat_dtl_chk") = 1;
				sheetObjects[<%=i%>].CellEditable(idx, "vat_dtl_chk") = false;
			}
			
			sheetObjects[<%=i%>].CheckAll("vat_dtl_chk") == 1;
		}
	}

<%}%>
-->
</SCRIPT> 
