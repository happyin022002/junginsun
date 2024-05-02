<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0111.jsp
*@FileTitle : Invoice Revision
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-05
*@LastModifier : Sun, CHOI
*@LastVersion : 1.6
* 2008-09-12 O Wan-Ki 1.0 최초 생성 
* 2009-03-13 O Wan-Ki 1.1 N200903090210, Invoice Revision 가능여부 판단기능 구현.
* 2009-04-27 O Wan-Ki 1.2 N200904160080, 주소영역 save 가능여부 판단기능 추가.
* 2009-05-26 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-07-31 O Wan-Ki 1.4 N200907020250, 인도 동적인보이스 Revision 적용
* 2009-10-12 Park Sung-Jin 1.5 ALPS Migration 작업
* 2010-03-05 Sun, CHOI 1.6 TPB Invoice Inquiry -> TPB Invoice Revise/Cancel 호출하는 방법 보완
* 2015-06-17 KIM HYUN-HWA[CHM-201536392]PKGBB GST 계산시 에러 수정
* 2015.08.22 Kim Hyun Hwa [CHM-201537151]그룹사 표준 코드 시행 프로그램 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl"%>

<%
	response.setHeader("expires", "-1"); 
	response.setHeader("pragma", "no-cache"); 
	response.setHeader("cache-control", "no-cache");
%>
<%
	GeneralEventResponse eventResponse = null;
	EsdTpb0111Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	Map<String,String> rowSet = null;
	Map<String,String> rowSetOtsGrpInfo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.InvoiceManage");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	
	String s_length_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_length_n3pty_bil_tp_cd")).trim();
	int s_length_n3pty_bil_tp_cd_int = 1;    //Sheet Maxinum 갯수
	try {
		s_length_n3pty_bil_tp_cd_int = Integer.parseInt(s_length_n3pty_bil_tp_cd);
	}catch(Exception e) {
		s_length_n3pty_bil_tp_cd_int = 1;
	}

	String ida_tax_seq = JSPUtil.getNull(request.getParameter("s_ida_tax_seq"));

	String s_detail_n3pty_no = JSPUtil.getNull(request.getParameter("s_detail_n3pty_no"));
	String s_trd_party_code = JSPUtil.getNull(request.getParameter("s_trd_party_code"));
	String s_h_vndr_cust_div_cd = JSPUtil.getNull(request.getParameter("s_h_vndr_cust_div_cd"));
	String s_correction_yn = JSPUtil.getNull(request.getParameter("s_correction_yn"));
	String s_inquiryOnly_yn = JSPUtil.getNull(request.getParameter("s_inquiryOnly_yn"));
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");

	String s_n3pty_inv_no = JSPUtil.getNull(request.getParameter("s_n3pty_inv_no"));
	String s_n3pty_inv_rmd_cd = JSPUtil.getNull(request.getParameter("s_n3pty_inv_rmd_cd"));
	String s_n3pty_inv_his_seq = JSPUtil.getNull(request.getParameter("s_n3pty_inv_his_seq"));
	String s_n3pty_ofc_cd = JSPUtil.getNull(request.getParameter("s_n3pty_ofc_cd"));
	String s_cnt_cd = JSPUtil.getNull(request.getParameter("s_cnt_cd"));
	String pop_yn = JSPUtil.getNull(request.getParameter("pop_yn"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		ofc_cd = account.getOfc_cd();
		//cnt_cd = account.getCnt_cd();
		cnt_cd = JSPUtil.getNull(new CommonCodeBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌  TPB 자체적으로 가져오도록 변경한다.

		event = (EsdTpb0111Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

			// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				rowSet = eventResponse.getETCData();
				if(rowSet != null){
					rowCount = eventResponse.getDataCntList().size();
				} // end if
				rowSetOtsGrpInfo = eventResponse.getETCData();
	
				if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
					s_length_n3pty_bil_tp_cd_int = Integer.parseInt(rowSetOtsGrpInfo.get("length_n3pty_bil_tp_cd"));
				}
				//log.debug("s_length_n3pty_bil_tp_cd_int====>"+s_length_n3pty_bil_tp_cd_int);
			}
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	if ( s_n3pty_inv_no == null || s_n3pty_inv_no.trim().length() == 0 ) {
		s_length_n3pty_bil_tp_cd_int = 0;
		s_n3pty_inv_no  = "";
	}

	if ( s_n3pty_ofc_cd != null && s_n3pty_ofc_cd.trim().length() >  0 ) {
		ofc_cd = s_n3pty_ofc_cd;
	}
	
	if ( s_cnt_cd != null && s_cnt_cd.trim().length() >  0 ) {
		cnt_cd = s_cnt_cd;
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	
	if (officeInfo[2]!= null){
		rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
	}

	if (rhq_cd == null){
		rhq_cd  = "";
	}
	
	boolean isHAMURs = false;
	if ( rhq_cd!=null && rhq_cd.equals("HAMRU") ){  // HAMUR 조직변경
		isHAMURs = true;
	}

%>
<html>
<head>
<title>Invoice Revision</title>
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
<input type="hidden" name="s_dao_n3pty_bil_tp_cd">
<input type="hidden" name="s_trd_party_code" value="<%=s_trd_party_code%>">
<input type="hidden" name="s_h_vndr_cust_div_cd" value="<%=s_h_vndr_cust_div_cd%>">
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" value="<%=currentDay%>">
<input type="hidden" name="s_length_n3pty_bil_tp_cd" value="<%=s_length_n3pty_bil_tp_cd_int%>">
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
<input type="hidden" name="s_trd_party_nm">
<input type="hidden" name="s_sum_inv_amt">
<input type="hidden" name="s_phn_no">
<!-- <input type="hidden" name="s_vndr_cust_addr"> -->
<!-- <input type="hidden" name="s_vndr_cust_nm"> -->
<input type="hidden" name="s_inv_rmk1">
<input type="hidden" name="s_inv_rmk2">
<input type="hidden" name="s_bil_loc">
<input type="hidden" name="s_clt_agn_rmk">
<input type="hidden" name="s_his_seq">
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="s_cnt_cd" value="<%=cnt_cd%>">

<input type="hidden" name="s_detail_n3pty_no" value="<%=s_detail_n3pty_no%>">
<input type="hidden" name="s_detail_ots_sts_cd">
<input type="hidden" name="s_vndr_cust_eml">
<input type="hidden" name="s_final_flg">
<input type="hidden" name="s_vat_xch_rt">
<input type="hidden" name="s_france">
<input type="hidden" name="s_from_curr_cd">

<input type="hidden" name="s_n3pty_inv_his_seq" value="<%=s_n3pty_inv_his_seq%>">
<input type="hidden" name="s_same_version_yn" value="N">
<input type="hidden" name="s_inv_iss_rhq_cd" value="">
<input type="hidden" name="s_n3pty_inv_sts_cd" value="">
<input type="hidden" name="erpif_yn" value="N">

<input type="hidden" name="s_correction_yn" value="<%=s_correction_yn%>">
<input type="hidden" name="s_inquiryOnly_yn" value="<%=s_inquiryOnly_yn%>">
<input type="hidden" name="s_invoice_cancel_remark" value="">

<input type="hidden" name="prcs_cnt">
<input type="hidden" name="pop_yn" value="<%=pop_yn%>">



<!-- 2009-03-13 O Wan-Ki 1.1 N200903090210: Data Search 후, 수정여부를 판별할 수 있는 Original Value 저장-->
<input type="hidden" name="org_due_date">
<input type="hidden" name="org_adm_chrg">
<input type="hidden" name="org_ddct_amt">
<input type="hidden" name="org_tot_amt">
<input type="hidden" name="inv_amt_sts">
<input type="hidden" name="org_inv_desc">
<input type="hidden" name="org_clt_agn_flg">

<!--* 2009-04-27 O Wan-Ki 1.2 N200904160080, 주소영역 save 가능여부 판단기능 추가.-->
<input type="hidden" name="org_usr_inp_ctnt1"    >
<input type="hidden" name="org_vndr_cust_addr"   >
<input type="hidden" name="org_cty_nm"           >
<input type="hidden" name="org_ste_cd"           >
<input type="hidden" name="org_zip_cd"           >
<input type="hidden" name="org_usr_inp_ctnt2"    >
<input type="hidden" name="org_vndr_cust_ref_rmk">



<% //* 2009-05-18 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] %>
<input type="hidden" name="cnt_cd" value=<%=cnt_cd%>>
<input type="hidden" name="s_ida_tax_seq" value=<%=ida_tax_seq%>>
<!--<input type="text" name="expn_tax">-->
<!--<input type="text" name="edu_tax">-->
<!--<input type="text" name="high_edu_tax">-->
<!--<input type="text" name="rgst_no">-->
<!--<input type="text" name="svc_cate_rmk">-->
<!--<input type="text" name="pmnt_acct_no">-->
<input type="hidden" name="inv_iss_ofc_cd">
<input type="hidden" name="gst_amt">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<input type="hidden" name="s_inv_dtl_add_amt">

<%=JSPUtil.getIncludeString(request) %>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
	<!-- | -->	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	<!-- |______________________________________________ End Page Navigation & Title -->
		<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_retrieve_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" >Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_new_t">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"  style="display:none;"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_cancel_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_cancel" id="btn_cancel">Invoice Cancel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_save_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_erpInterface_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_erpInterface" id="btn_erpInterface">ERP Interface</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_settlement_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_settlement" id="btn_settlement">Settlement</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_preview_t" style="display:none;">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_preview" id="btn_preview">Preview</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_close_t" style="display:none;">
								<tr><td class="btn1_line"></td><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>	
							
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
					<tr>
						<td>
							<table border="0">
								<tr class="h23">
									<td width="80"><font color="red">TPB No.</font></td>
									<td><input type="text" name="s_n3pty_no" value="<%=s_detail_n3pty_no%>" maxlength="14"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table class="search_in" border="0">
					<tr>
						<td>
							<table border="0">
								<tr class="h23">
									<td width="80">Invoice No.</td>
									<td width="230"><input name="s_n3pty_inv_no" type="text" class="" style="width:122" value="<%=s_n3pty_inv_no%>" readonly> <input type="text" class="" style="width:33;" name="s_n3pty_inv_rmd_cd" value="<%=s_n3pty_inv_rmd_cd%>" readonly></td>
									<td width="70"><img class="nostar">Currency</td>
									<td width="265">
										<select class="input1" style="width:100;" name="s_curr_cd" required caption="Currency" onchange='changeCurrency(this.value)'>
										</select>
									</td>
									<td width="192" style="display:none">VAT&nbsp;
									<input <%if(cnt_cd.equals("IN")){//* 2009-05-28 O Wan-Ki 1.3 %>style="display:none"<%}%> type="checkbox" name="s_vat_xch_rt_chk" class="trans" style="display:none" onclick="amtReCalculate();" value="Y"></td><!-- Final Invoice&nbsp; -->
									<input type="checkbox" name="s_final_flg_checkbox" class="trans" onclick="tpb_set_final_invoice(this.checked);" style="display:none;"></td>
									<td width=""></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>


				<table class="search_in" border="0">
					<tr>
						<td>
							<table border="0">
								<tr class="h23">
								    <td width="80">Fax Number</td>
									<td width="230"><input type="text" class="input" style="width:122;" name="s_fax_no" maxlength="20" readonly></td>
									<td width="215"><img class="nostar">Collection Agency / Legal Action</td>
									<td width="120"><input type="checkbox" name="s_clt_agn_flg" value="Y" class="trans"></td>
									<td>
										<table width="100%">
											<tr><td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
													<!-- Repeat Pattern -->
														<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_caremarks_t">
														<tr><td class="btn2_left"></td><td class="btn2" name="btn_caremarks" id="btn_caremarks">C/L Remarks</td>
														<td class="btn2_right"></td></tr></table></td>
														<td width="90"></td>
														<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr><td class="btn2_left"></td><td class="btn2" name="btn_collectionactivity" id="btn_collectionactivity">Recovery Activity</td>
														<td class="btn2_right"></td></tr></table></td>
													<!-- Repeat Pattern -->


													</tr>
												</table>
											</td></tr>
										</table>


									</td>

								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table border="0" class="grid2">
	      				<tr class="tr2_head">
	      				<td width="450">Bill To</td>
	      				<td width="130">Code</td>
	      				<td width="130"><!-- Customer / Service Provider<br> -->Reference</td>
						<td width="132">Due Date</td>
	      				<td width="113">VAT No.</td>
	      			</tr>

      			<tr><!-- <td class="stm" width="170"><textarea name="s_addr" class="noinput"  style="width:100%;height=100;overflow-y:hidden;overflow-x:hidden" readonly></textarea></td> -->
      				<td class="stm" align='right'>
      					<input name="s_usr_inp_ctnt1" type="text" class="input" style="width:447" maxlength='100'><!-- 1 --><br>
      					<input name="s_vndr_cust_nm" type="text" class="input" style="width:447" readonly><!-- vendor / customer name --><br>
      					<input name="s_vndr_cust_addr" type="text" class="input" style="width:447" maxlength='200'><br>
      					City : <input name="s_cty_nm" type="text" class="input" style="width:193" maxlength='50'><!-- city name 50 -->
      					&nbsp; State : <input name="s_ste_cd" type="text" class="input" style="width:45" maxlength='3'><!-- state code 3 -->
      					&nbsp; Zip : <input name="s_zip_cd" type="text" class="input" style="width:80" maxlength='10'><!-- zip code 10 --><br>
      					<input name="s_usr_inp_ctnt2" type="text" class="input" style="width:447" maxlength='100'><br>
      					<div id='div_ida_gst_bil_to' name='div_ida_gst_bil_to' style="display:none">
						GSTIN/UIN : <input class="noinput" name="ida_gst_rgst_no" type="text" style="width:125" readonly>
						&nbsp;&nbsp; GST Registration : <input class="noinput" name="ida_gst_rgst_no_flg" type="text" style="width:30" readonly>
						&nbsp;&nbsp; SEZ Unit : <input class="noinput" name="ida_spcl_ecn_zn_ut_flg" type="text" style="width:30" readonly>
						</div>
					</td>
					<% if (s_correction_yn.equals("Y-IGNORE")){  /// Changed ... In 2008-11-12
						%><td>
							<%=TPBUtils.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:80;'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|", "C|V")%>
							&nbsp;<input type="text" style="width:70;" name="s_trd_party_val" maxlength="8">&nbsp;
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
						</td><%
					   } else {
					   	%><td><input name="s_trd_party_val" type="text" class="noinput" style="width:95" readonly><input type="hidden" name="s_vndr_cust_div_cd" value=""></td><%  //s_trd_party_code_detail
					   } %>

      				<td align='center'><!-- <input name="s_vndr_cust_ref_rmk" type="text" class="noinput" style="width:180">
      				 --><textarea name="s_vndr_cust_ref_rmk" class=""  style="width:100%;height=100;overflow-y:auto;overflow-x:auto" onblur="checkLength(this,50,'Reference')"></textarea></td>
					<% if(cnt_cd.equals("US") || cnt_cd.equals("CA") || cnt_cd.equals("MX")){%>      				 
						<td align='center'><input name="s_rcv_due_dt" type="text" class="noinput" style="width:70" maxlength="10" value="<%=DateTime.addDays(currentDay, 7, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
				    <% }else {%>
				        <td align='center'><input name="s_rcv_due_dt" type="text" class="noinput" style="width:70" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd" OnKeyDown="tpb_isNumD(this, 'Y');" onBlur="tpb_validateDateObj(this);"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
				    <% }%>						
      				<td align='center'><!-- <input name="s_rgst_no" type="text" class="noinput" style="width:90" maxlength="20">
      				 --><textarea name="s_rgst_no" class="<% if(!isHAMURs){out.print("noinput");}else{out.print("input");}%>"  style="width:100%;height=100;overflow-y:auto;overflow-x:auto" onblur="checkLength(this,20,'VAT No.')"<% if(!isHAMURs){out.print(" readonly");} %>></textarea></td></tr>

       			</table>
       			<!-- : ( Year ) (E) -->

			</td></tr>
		</table>
						<%/* %>
		       			<!-- * 2009-04-24 O Wan-Ki 1.2 N200904160080, Invoice Creation 폼 변경 (주소선택기능추가)-->
						<table border="0" class="grid2">
							<tr>
								<td>


								<table border="0">
									<tr>
										<td class="tr2_head" width="">Bill to</td>
									</tr>
									<tr>
										<td>

										<table border="0" class="grid2" width="">
											<tr>
												<td align="right" style="width: 90">Attention&nbsp;</td>
												<td><input name="s_usr_inp_ctnt1" type="text" class=""
													style="width: 440; font-size: 8pt"></td>
											</tr>
											<tr>
												<td align="right">Company&nbsp;</td>
												<td><!-- <input name="s_trd_party_code_detail" type="text" class="tr3_head" style="width: 50" readonly> -->
													<% if (s_correction_yn.equals("Y-IGNORE")){  /// Changed ... In 2008-11-12 %>
														<%=TPBUtils.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:50;'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|", "C|V")%>
														<input type="text" style="width:70;" name="s_trd_party_val" maxlength="8">&nbsp;
														<img class="cursor"
															src="/hanjin/img/button/btns_search.gif"
															width="19" height="20" border="0"
															align="absmiddle" name="btn_3rdParty">
													<%
												   } else {
												   	%><input name="s_trd_party_val" type="text" class="tr3_head" style="width:50" readonly>
												   	<% } //s_trd_party_code_detail%>
													<input name="s_vndr_cust_nm" type="text"
														class="noinput" style="width: 385; font-size: 8pt" readonly>
												</td>
											</tr>
											<tr>
												<td align="right"><input type="radio" name="s_rch"
													class="noinput" value="addr1" checked>&nbsp;Address 1.</td>
												<td><input name="s_vndr_cust_addr" type="text" class=""
													style="width: 440; font-size: 8pt" maxlength='200'>
												</td>
											</tr>
											<tr>
												<td align="right"><input type="radio" name="s_rch"
													class="noinput" value="addr2">&nbsp;Address 2.</td>
												<td><input name="s_vndr_cust_addr2" type="text"
													class="" style="width: 440; font-size: 8pt" maxlength='100'>
												</td>
											</tr>
											<tr>
												<td colspan="2" align="right">City : <input
													name="s_cty_nm" type="text" class="" style="width: 200"
													maxlength='50'><!-- city name 50 --> &nbsp;&nbsp;
												State : <input name="s_ste_cd" type="text" class=""
													style="width: 40" maxlength='3'><!-- state code 3 -->
												&nbsp;&nbsp; Zip : <input name="s_zip_cd" type="text"
													class="" style="width: 90" maxlength='10'><!-- zip code 10 -->
												</td>
											</tr>
											<tr>
												<td align="right" colspan="2"><input
													name="s_usr_inp_ctnt2" type="text" class=""
													style="width: 412; font-size: 8pt"></td>
											</tr>
										</table>

										</td>
									</tr>
								</table>


								</td>
								<td>


								<table border="0" class="grid2" width="" height="100%">
									<tr>
										<td class="tr2_head" align="right" style="width: 70">Reference&nbsp;</td>
										<td width="120"><textarea name="s_vndr_cust_ref_rmk" class="" style="width: 100%; height: 60; overflow-y: auto; overflow-x: auto" onblur="checkLength(this,50,'Reference')"></textarea></td>
									</tr>
									<tr>
										<td class="tr2_head" align="right">Due Date&nbsp;</td>
										<% if(cnt_cd.equals("US") || cnt_cd.equals("CA") || cnt_cd.equals("MX")){%>      				 										
										<td>&nbsp;<input name="s_rcv_due_dt" type="text" class="noinput" style="width:70" maxlength="10" value="<%=DateTime.addDays(currentDay, 7, "yyyy-MM-dd")%>" data_format="ymd">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
										</td> 
										<%}else { %>
										<td>&nbsp;<input name="s_rcv_due_dt" type="text" class="noinput" style="width:70" maxlength="10" value="<%=DateTime.addDays(currentDay, 15, "yyyy-MM-dd")%>" data_format="ymd">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
										</td>
										<%} %>
									</tr>
									<tr>
										<td class="tr2_head" align="right">VAT No.</td>
										<td><textarea name="s_rgst_no" class="<% if(!isHAMURs){out.print("noinput");}else{out.print("input");}%>"  style="width:100%;height=60;overflow-y:auto;overflow-x:auto" onblur="checkLength(this,20,'VAT No.')"<% if(!isHAMURs){out.print(" readonly");} %>></textarea></td>
									</tr>
								</table>


								</td>
							</tr>
						</table>
						<!-- * 2009-04-24 O Wan-Ki 1.2 N200904160080, Invoice Creation 폼 변경 (주소선택기능추가)-->
       					<%*/ %>





		<!-- TABLE '#D' : ( Search Options ) (E) -->

<% for(int i=0;i<s_length_n3pty_bil_tp_cd_int;i++){ %>
<div id="tabSheet1">
		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
				
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab<%=i+1%>')</script></td></tr>
		</table>
		
		<!-- TABLE '#D' : ( Tab ) (E) -->
		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet<%=i+1%>');</script>
		              </td></tr>
				</table>
				<!-- : ( POR ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
</div>
<% } %>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="height_10"><tr><td></td></tr></table>
		<% if(!cnt_cd.equals("IN")){//* 2009-05-26 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] %>
     	<table class="search" style="width: 300">
       	<tr><td class="bg">
				<table border="0" class="grid2" style="width:450">				
				 	<tr>
						<td width="35%" class="tr2_head" align="left"><img class="nostar"><font color="red">Confirmed Amount</font></td>
						<td class="stm">&nbsp;<input name="s_net_amt" type="text" class="noinput" style="width:95%;text-align:right" readonly></td>
					</tr>
				 <%if(ofc_cd.equals("PKGSC")){ %>	
					<tr>
						<td class="tr2_head" align="left"><img class="nostar"><font color="red">Administration Charge</font></td>
						<td class="stm">&nbsp;<input name="s_add_amt" type="text"  class="input" style="width:95%;text-align:right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);calculateGst();"></td>
					</tr>
					<tr>
						<td class="tr2_head" align="left"><img class="nostar"><font color="red">Discount Amount</font></td>
						<td class="stm">&nbsp;<input name="s_ddct_amt" type="text" class="input" style="width:95%;text-align:right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);calculateGst();"></td>
					</tr>
					<tr>
		  			  <td class="tr2_head" align="left"><img class="nostar"><font color="red">GST Amount</font></td>
		  		  
				  <%}else{ %>
				  	<tr>
						<td class="tr2_head" align="left"><img class="nostar"><font color="red">Administration Charge</font></td>
						<td class="stm">&nbsp;<input name="s_add_amt" type="text"  class="input" style="width:95%;text-align:right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);"></td>
					</tr>
					  <tr>
						<td class="tr2_head" align="left"><img class="nostar"><font color="red">Deducted Amount</font></td>
						<td class="stm">&nbsp;<input name="s_ddct_amt" type="text" class="input" style="width:95%;text-align:right" onclick="this.select()" onblur="tpb_otherAmountReCalculate(this);"></td>
					 </tr>
						<td class="tr2_head" align="left"><img class="nostar"><font color="red">VAT Amount</font></td>
				  <%}%>	
						<td class="stm">&nbsp;<input name="s_vat_amt" type="text"  class="noinput" style="width:95%;text-align:right" onclick="this.select()" onblur="amtReCalculate()" readonly></td>
					</tr>
					<tr>
						<td class="tr2_head" align="left"><img class="nostar"><font color="red">Total Amount</font></td>
						<td class="stm">&nbsp;<input name="s_total_amt" type="text" class="noinput" style="width:95%;text-align:right" readonly></td>
					</tr>
				</table>
			</td></tr>
		</table>
		<%}else{ // ########### India Case ############////* 2009-05-26 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]%>
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
									<input name="s_n2nd_locl_tax_amt" type="text" readonly></td>
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
						
						<div id='div_ida_svc_tax' name='div_ida_svc_tax' style="display:none">
						
						<table border="0" class="grid2" width="100%">
							<tr>
								<td class="stm" align="left" width="55%">Service Tax @<input class="noinput" type="text" name="expn_tax" style="width:25; text-align:center" readonly>%</td>
								<td class="stm" width="35%">
									<input name="tot_expn_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
							<tr>
								<td class="stm" align="left">Swachh Bharat Cess&nbsp;@&nbsp;<input class="noinput" type="text" name="locl_tax_rt" style="width:25; text-align:center" readonly>%</td>
								<td class="stm">
									<input name="tot_locl_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
							</td>
							</tr>
							<tr>
								<td class="stm" align="left">Krishi Kalyan Cess&nbsp;@&nbsp;<input class="noinput" type="text" name="n2nd_locl_tax_rt" style="width:25; text-align:center" readonly>%</td>
								<td class="stm">
									<input name="n2nd_locl_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
							<tr>
								<td class="stm" align="left">Education Cess @<input class="noinput" type="text" name="edu_tax" style="width:20; text-align:center" readonly>% of S. Tax</td>
								<td class="stm">
									<input name="tot_edu_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
							<tr>
								<td class="stm" align="left">Higher Edu Cess @<input class="noinput" type="text" name="high_edu_tax" style="width:20; text-align:center" readonly>% of S. Tax</td>
								<td class="stm">
									<input name="tot_high_edu_tax" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
							<tr>
								<td class="stm" align="left">Total Service Tax (Rs)</td>
								<td class="stm">
									<input name="tot_svc_tax" type="hidden" >
									<input name="tot_svc_tax2" type="text" class="noinput" style="text-align: right; width:96%" readonly>
								</td>
							</tr>
						</table>
						Service Tax Registration No. : <input class="noinput" type="text" name="tax_rgst_no" readonly style="width:238">
						<br>
						Service Category : <input class="noinput" type="text" name="svc_cate_rmk" readonly style="width:300">
						<br>
						PAN No. : <input class="noinput" type="text" name="pmnt_acct_no" readonly style="width:346">
						
						</div>
						
						<div id='div_ida_gst_tax' name='div_ida_gst_tax' style="display:inline">
						
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
						
						</div>
						</td>
						

						<td width="1%"></td>
						<td class="bg" valign="top" width="30%">
						<B>[ Invoice Amount ]</B>
						<table border="0" class="grid2" width="100%">
							<tr>
								<td class="stm" align="left" width="50%">Expense</td>
								<td class="stm" width="60%">
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
				
	<%}//* 2009-05-26 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] %>
		<br>
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Descriptions</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				<table border="0" class="input">

      			<tr><td><!-- <input name="s_inv_desc" type="text" class="input" style="width:720;background-color:F3F2F8; border: #F3F2F8"> -->
				<textarea name="s_inv_desc" class="input3"  style="width:977;height=35;overflow-y:auto;overflow-x:auto"
					<%if(cnt_cd.equals("FR")){ %>
					onblur="checkLength(this,500,'Descriptions')"
					<%} else{ %>
					onblur="checkLength(this,1000,'Descriptions')"
					<%} %>>
				</textarea>

				</td></tr>

       			</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

    </td></tr>
</table>
</form>
<div style="display: none">
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet0');</script>
		</td>
	</tr>
</table>
</div>
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
			ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD_sheet', '1,0,1,1,1,1,1,1',Row,Col);
		}
	}

	function sheet<%=i+1%>_OnChange(sheetObj,Row,Col,Value){
		_sheet_onchange( sheetObj,Row,Col,Value );
		var colName = sheetObj.ColSaveName(Col);

		//if(colName == "inv_dtl_amt" || colName == "delChkBox"){ // Del. 클릭시 처리; By Kim Jin-seung In 2007-06-20
		if( colName == "inv_dtl_amt" || colName == "vat_dtl_amt" || colName == "vat_dtl_chk" || colName == "inv_dtl_add_amt")
		{
			//Currency Code에 따른 소수점 자리수 반올림 구하기
			var prcsCnt = document.all.prcs_cnt.value;
  			var amtPrcs = 1;
  			if( prcsCnt >= 3 ) prcsCnt = 2;
  			for(var j=0;j<prcsCnt;j++)
  			{
  				amtPrcs = amtPrcs * 10;
  			}
	  			
			if( colName == "inv_dtl_amt" )
			{
				var invAmt = sheetObj.CellValue(Row, "inv_dtl_amt");
	  			var fltAmt = Math.round(invAmt * amtPrcs) / amtPrcs;
	  			sheetObj.CellValue2(Row, "inv_dtl_amt") = fltAmt;
	  			

				//Auto Update 아닐 경우 금액 비교
				if( sheetObj.CellValue(Row, "so_if_seq") == 0 ){
					if(parseFloat(sheetObj.CellValue(Row, "ots_amt")) < parseFloat(sheetObj.CellValue(Row, colName))){
						ComShowCodeMessage("TPB90032","Invoice AMT","Original AMT"); // 이하
						sheetObj.CellValue2(Row, colName) = sheetObj.CellValue(Row, "original_inv_dtl_amt");
						//return;
					} else if ( parseFloat(sheetObj.CellValue(Row, colName)) <= 0 ) { // 초과
						ComShowCodeMessage("TPB90035","Invoice AMT","0.00");
						sheetObj.CellValue2(Row, colName) = sheetObj.CellValue(Row, "original_inv_dtl_amt");
						//return;
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
    			if( document.form.cnt_cd.value == "IN" ){	
        			calculateForIndiaInvoice();
        		}
    		}else {
    			amtReCalculate();
    		}
			//amtReCalculate();
			// 2015.6.16 PKGSC(PKGBB) 및 인도 Tax 재계산로직 추가
			if (document.form.s_ofc_cd.value == "PKGSC" ){
			     calculateGst();
			}
			if( document.form.cnt_cd.value == "IN" ){	
    			calculateForIndiaInvoice();
    		}
		}

		//Outstanding Amount 의 Auto Update check
		//tpb_chgColor_ots_amt(sheetObj, 49, 30, Row);

		/* 2009-03-13 O Wan-Ki 1.2 N200903090210, Invoice Revision 가능여부 판단기능 구현. */
		/* sheetObj inv_amt_dtl 의 금액변화가 생기면 save 가능하게 한다. */
		if(sheetObj.RowStatus(Row) == 'U' ){
			document.form.inv_amt_sts.value = 'U';
		}
		
		//Sheet의 Terminal Name, ATD 값 가져오기
		if( colName == "yd_cd" ){
			document.form.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchXml("ESD_TPB_0111GS.do", tpbFrmQryStr(document.form) + "&yd_cd="+sheetObj.CellValue(Row, "yd_cd") + "&vvd_cd="+sheetObj.CellValue(Row, "vvd_cd"));
			sheetObj.CellValue2(Row, "atd") = ComGetEtcData(sXml, "atd");
			sheetObj.CellValue2(Row, "yd_nm") = ComGetEtcData(sXml, "yd_nm");
		}
	}
	
	function sheet<%=i+1%>_OnSearchEnd(sheetObj,errMsg){
		if ( document.all.cnt_cd.value == 'IN' )
		{
			sheetObj.ColHidden("vat_dtl_chk") = true;
			sheetObj.ColHidden("vat_dtl_amt") = true;
		}
		
		for ( var i = 1; i <= sheetObj.RowCount; i++ ){

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
  		
  		for ( var idx = 1; idx <= sheetObj.RowCount; idx++ )
  		{
  			if( sheetObj.CellValue(idx,"vat_dtl_chk") == 1 )
			{
				sheetObj.CellEditable(idx, "vat_dtl_amt") = true;
			}
			else
			{
				sheetObj.CellEditable(idx, "vat_dtl_amt") = false;
			}
		}
		// 2015.08.22 조직변경
  		if(document.form.s_ofc_cd.value == "ATLSC"     //"ATLBB"
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
  			for(var i=0;i<sheetObj.Rows;i++){

  				sheetObj.CellEditable(i,"vat_dtl_chk") = false;
  			}
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
	
<% } %>
-->
</SCRIPT>