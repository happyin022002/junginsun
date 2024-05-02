<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0017.jsp
*@FileTitle : Marine Terminal Container List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-03
*@LastModifier : 
*@LastVersion : 1.0
* 2007-01-03
* 1.0 최초 생성

* 2011.08.17 [E-mail요청] [TES] special character, characterSet problem
* 2012.02.27 [CHM-201216241]미국 서부지역 조직 변경 관련 PHXSCG의 조회권한 확대 보완사항 테스트
* 2015-03-05 [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정
* 2015-04-09 [CHM-201534988] EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F
=========================================================*/
--%>

<%@page import="com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl"%>
<%@page import="com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0017Event"%>
<%
	EsdTes0017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String ofcCd = "";
	String inv_no	="";
	String vndr_seq	="";
	String flag	="";
	String eas_flag	= "";
	inv_no 		= JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq 	= JSPUtil.getNull(request.getParameter("vndr_seq"));
	flag 	= JSPUtil.getNull(request.getParameter("flag"));
	eas_flag	= JSPUtil.getNull(request.getParameter("s_eas_flg"));

	//ofc_cd 별로 권한제어시 추가
	String cre_ofc_cd 	= "";
	String ida_ofc_cd = "";
	String conti_cd = "";

	try {

	   	SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():""; //test용 값..
	   	cre_ofc_cd 		= account.getOfc_cd();
	    ida_ofc_cd = JSPUtil.getNull(new TESCommonBCImpl().getIndOfcCdChk(ofcCd));
	    conti_cd = JSPUtil.getNull(new TESInvoiceCommonBCImpl().searchContiCd(ofcCd));
		event 			= (EsdTes0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	/** [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정  */
	String pre_cond_inv_no 				= request.getParameter("pre_cond_inv_no")!=null&&!request.getParameter("pre_cond_inv_no").trim().equals("")?request.getParameter("pre_cond_inv_no"):"";
	String pre_cond_inv_date_type 		= request.getParameter("pre_cond_inv_date_type")!=null&&!request.getParameter("pre_cond_inv_date_type").trim().equals("")?request.getParameter("pre_cond_inv_date_type"):"";
	String pre_cond_fm_prd_dt 			= request.getParameter("pre_cond_fm_prd_dt")!=null&&!request.getParameter("pre_cond_fm_prd_dt").trim().equals("")?request.getParameter("pre_cond_fm_prd_dt"):"";
	String pre_cond_to_prd_dt 			= request.getParameter("pre_cond_to_prd_dt")!=null&&!request.getParameter("pre_cond_to_prd_dt").trim().equals("")?request.getParameter("pre_cond_to_prd_dt"):"";
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_cost_ofc_cd 			= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_inv_ofc_cd 			= request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_tml_inv_sts_cd 		= request.getParameter("pre_cond_tml_inv_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_sts_cd"):"";
	String pre_cond_csr_no 				= request.getParameter("pre_cond_csr_no")!=null&&!request.getParameter("pre_cond_csr_no").trim().equals("")?request.getParameter("pre_cond_csr_no"):"";
	String pre_cond_csr_status 			= request.getParameter("pre_cond_csr_status")!=null&&!request.getParameter("pre_cond_csr_status").trim().equals("")?request.getParameter("pre_cond_csr_status"):"";
	String pre_cond_tml_inv_rjct_sts_cd	= request.getParameter("pre_cond_tml_inv_rjct_sts_cd")!=null&&!request.getParameter("pre_cond_tml_inv_rjct_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_inv_rjct_sts_cd"):"";

%>
<html>
<head>
<title>Marine Terminal Container List 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var inv_no	= '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq	= '<%=JSPUtil.getNull(vndr_seq)%>';
	var flag		= '<%=JSPUtil.getNull(flag)%>';
	var eas_flag	= '<%=JSPUtil.getNull(eas_flag)%>';
	var ida_ofc_cd = '<%=JSPUtil.getNull(ida_ofc_cd)%>';
	var conti_cd = '<%=JSPUtil.getNull(conti_cd)%>';
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		// InitTab();

		
		// EAS에서 넘어온 경우 Button Display Hidden처리. (2015-06-15)
		if ( eas_flag == "Y") {
			objectDisplaySet('tblbtn', 'true');
		}

		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_so_ofc_cty_cd">
<input type="hidden" name="tml_so_seq">
<input type="hidden" name="is_inq" value="INQ">
<input type="hidden" name="cost_calc_mode" value="R">
<input type="hidden" name="hld_flg">
<input type="hidden" name="hld_rmk">
<input type="hidden" name="flag" value="<%=JSPUtil.getNull(flag)%>">

<!-- ofc_cd 별로 권한제어시 추가 -->
<input type="hidden" name="no_ofc_cd" value="">
<input type="hidden" name="act_tp" value="INV">
<input type="hidden" name="no_yd_cd" value="">
<input type="hidden" name="auth_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd %>">

<!-- 2011.08.12 박정일 special character, characterSet problem. //-->
<input type="hidden" name="inv_no_tmp" value= "<%=JSPUtil.getNull(inv_no)%>">

<!--  [CHM-201533697] TES에서 "뒤로"버튼 클릭시 이전 화면 검색 결과 유지되도록 설정 -->
<input name="pre_cond_inv_no" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_no)%>">
<input name="pre_cond_inv_date_type" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_date_type)%>">
<input name="pre_cond_fm_prd_dt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_fm_prd_dt)%>">
<input name="pre_cond_to_prd_dt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_to_prd_dt)%>">
<input name="pre_cond_yd_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_cost_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_inv_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_tml_inv_sts_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_inv_sts_cd)%>">
<input name="pre_cond_csr_no" type="hidden" value="<%=JSPUtil.getNull(pre_cond_csr_no)%>">
<input name="pre_cond_csr_status" type="hidden" value="<%=JSPUtil.getNull(pre_cond_csr_status)%>">
<input name="pre_cond_tml_inv_rjct_sts_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_inv_rjct_sts_cd)%>">

<!-- [CHM-201534988]EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F -->
<input type="hidden" name="edi_flg"	value="">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	     	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table id="tblbtn" name="tblbtn" width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><div id="PreInquiryCondLayer01" style="display:none">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_pre_inquiry_cond" id="btn_pre_inquiry_cond">To Inv. Summary</td><td class="btn1_right"></td></tr></table>
								</div>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     		<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">

					<td width="70"><img class="nostar">S/P Code</td>
					<td width="100" class="stm">
						<input class="input1" type="text" style="width:68" name="vndr_seq" value='' valid="1" desc= "VNDR Code" value='' maxlength=6 tabindex='1' onKeyUp='tes_isNum(this);' onKeyDown='tes_isNum(this);' onBlur='validateVndrSeq();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btn_vndr"></td>
									  <input type="hidden" name="vndr_seq_hidden" value=''>
									  <input type="hidden" name="is_valid_vndr_seq" value=''>

					<td width="75"><img class="nostar">S/P Name</td>
					<td width="90"><input type="text" style="width:115" value=""  name ="vndr_seq_name" valid="1" class="input2" readOnly ></td>
					<td width="62"><img class="nostar">INV No</td>
					<td width="100"><input class="input1" type="text" style="width:128" name="inv_no"  value='' maxlength=30 valid="1" tabindex='2' desc= "Inv. No." onKeyPress='enterCheck("retrieveEvent");' onBlur='validateInvDupChk();'></td>
									  <input type="hidden" name="inv_no_hidden" value=''>
									  <input type="hidden" name="is_dup_inv_no" value=''>
					<td width="100"><img class="nostar">Error INV No</td>
					<td width="110"><input type="text" style="width:93;" name="err_inv_no" maxlength="30" onKeyDown='tes_chkInput(this);' onBlur='validateErrInvNo();' readonly></td>
					<%--	Invoice 소급처리용 추가 ( 2009-06-16 )	--%>
					<td width="130">Retroactive INV&nbsp;<input type="checkbox" name="rtro_tml_inv_flg" value="Y" class="trans" disabled="disabled" ></td>
					<td width="110">Reverse CHG&nbsp;<input type="checkbox" name="ap_rvs_cng_flg" value="Y" class="trans" disabled="disabled" ></td>
				</tr>
				</table>
				<div id="IndiaLayer01" style="display:none">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="68"><img class="nostar">GST Reg.</td>
					<td width="75" class="stm"><input type="text" style="width:90" value=""  name ="ida_gst_rgst_ste" valid="1" class="input2" readonly ></td>
					<td width="35"><img class="nostar">GSTIN/UIN</td>
					<td width="90"><input type="text" style="width:115" value=""  name ="ida_gst_rgst_no" valid="1" class="input2" readonly ></td>
					<td width="60"><img class="nostar">State</td>
					<td width="132"><input class="input2" type="text" style="width:20" name="ida_ste_cd" valid="1" readOnly >&nbsp;<input class="input2" type="text" style="width:105" name="ida_ste_nm" valid="1" readonly ></td>
					<td width="98"><img class="nostar">Debit Note No</td>
					<td width="105"><input type="text" style="width:93;" name="dbt_note_no" maxlength="30" onKeyDown='tes_chkInput(this);' readonly></td>		
					<td width="130"></td>
					<td width="110"></td>
				</tr>
				</table>
				</div>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information  ) (S) -->
		<table class="search">
        	<tr><td class="bg">
        			<table border="0" class="grid2" background-color:white; >
        				<tr>
        					<td width="120" class="tr2_head">Cost Office</td>
        					<td width="127"><input name="cost_ofc_cd" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td width="110" class="tr2_head">Invoice Office</td>
						<td width="100"><input name="inv_ofc_cd" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td width="122" class="tr2_head">Yard Code</td>
        					<td width="100"><input name="yd_cd" type="text" class="noinput" style="width:80" value="" readonly></td>
						<td width="147" class="tr2_head">Yard Name</td>
        					<td width="113"><input name="yd_nm" type="text" class="noinput" style="width:80" value="" readonly></td>
        				</tr>
        				<tr>
        					<td class="tr2_head">Invoice Status</td>
        					<td><input name="tml_inv_sts_cd" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td class="tr2_head">Reject Status</td>
							<td><input name="tml_inv_rjct_sts_cd" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td class="tr2_head">Payment Status</td>
        					<td><input name="pay_flg" type="text" class="noinput" style="width:80" value="" readonly></td>
							<td class="tr2_head">Currency</td>
       					<td><input name="curr_cd" type="text" class="noinput" style="width:80" value="" readonly></td>
        				</tr>
						<tr>
        					<td class="tr2_head">Hold Status</td>
        					<td align="center">

        					<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						     <tr>

						     	<td class="btn2_left" style="padding:0; border:0;"></td>
						     	<td class="btn2" style="padding:0; border:0;" name="btns_remarks" id="btns_remarks">Remarks</td>
						     	<td class="btn2_right" style="padding:0; border:0;"></td>

						     </tr>
						</table>

        					</td>
        					<td class="tr2_head">Issued Date</td>
							<td><input name="iss_dt" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td class="tr2_head">Received Date</td>
        					<td><input name="rcv_dt" type="text" class="noinput" style="width:80" value="" readonly></td>
							<td class="tr2_head">Payment Due Date</td>
        					<td><input name="pay_due_dt" type="text" class="noinput" style="width:80" value="" readonly></td>
        				</tr>
						<tr>
        					<td class="tr2_head">Invoice Amount</td>
        					<td><input name="ttl_inv_amt" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td class="tr2_head">V.A.T</td>
							<td><input name="vat_amt" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td class="tr2_head">W.H.T</td>
        					<td><input name="whld_tax_amt" type="text" class="noinput" style="width:80" value="" readonly></td>
        					<td class="tr2_head">Accumulated Vol.</td>
        					<td><input name="pay_vol_qty" type="text" class="noinput" style="width:80" value="" readonly></td>
        				</tr>
        		</table>
			</td>
			<td <%if(ida_ofc_cd.equals("Y")){ %>class="bg"<%} %>> 
				<div id="IndiaLayer02" style="display:none">
				<table border="0" class="grid2" background-color:white;>
							<tr>
								<td class="tr2_head" style="width:55" align="center">CGST</td>
								<td><input class="noinput" type="text" style="text-align:right;width:60"  name="ida_cgst_amt"  valid="1" desc= "CGST AMT" readonly></td>
							</tr>
							<tr>
								<td class="tr2_head" style="width:55">SGST</td>
								<td><input class="noinput" type="text" style="text-align:right; width:60" name="ida_sgst_amt"  valid="1" desc= "SGST AMT" readonly></td>
							</tr>
							<tr>
								<td class="tr2_head" style="width:55">IGST</td>
								<td><input class="noinput" type="text" style="text-align:right; width:60" name="ida_igst_amt"  valid="1" desc= "IGST AMT" readonly></td>
							</tr>
							<tr>
								<td class="tr2_head" style="width:55">UGST</td>
								<td><input class=noinput type="text" style="text-align:right; width:60" name="ida_ugst_amt"  valid="1" desc= "UGST AMT" readonly></td>
							</tr>
					</table>
					</div>
				</td>
			</tr>	
		</table>
		<!-- TABLE '#D' : ( Search Options : Related COP Information) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="11%"><img class="nostar">VVD/BND/SEQ</td>
					<td width="22%">
						<script language="javascript">ComComboObject('vvd_bnd_combo', 3, 110, 1, 1)</script>
						&nbsp;<input type="hidden" name="vvd" style="width:100" value="" readonly>
						&nbsp;<input type="text" name="io_bnd_cd" style="width:20" value="" readonly>
						&nbsp;<input type="text" name="call_yd_ind_seq" style="width:20" value="" readonly>
							  <input type="hidden" name="clpt_ind_seq" value="">
					</td>
					<td width="3%">ATB</td>
					<td width="25%" class="stm">&nbsp;<input type="text" name="atb_dt" style="width:80" value="" readonly>
						<!-- &nbsp;<img src="/hanjin/img/button/btng_back.gif" width="18" height="19" alt="" border="0" align="absmiddle" name="btng_back">&nbsp;<img src="/hanjin/img/button/btng_next.gif" width="18" height="19" alt="" border="0" align="absmiddle" name="btng_next">&nbsp; -->
						<input type="text" name="page" style="width:40;text-align:center;" value="" readonly>
					</td>
					<td width="18%">Calculated AMT(VVD/TTL)</td>
					<td>&nbsp;<input type="text" name="vvd_inv_amt" style="width:80;text-align:right;" value="" readonly> / <input type="text" name="tot_inv_amt" style="width:80;text-align:right;" value="" readonly></td></tr>

				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->




		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) Coincidence / Discrepancy / Cost Calculation-->
     	<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




	<table class="height_10"><tr><td></td></tr></table>



		<!-- UI_ESD_TES_0017 : THIS IS 1st TAB -->
		<div id="tabLayer" style="display:inline">
			<!-- : ( Grid : Week ) (S) -->


			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('t1sheet1');</script>
				</td></tr>
			</table>
			<!-- : ( Grid : Week ) (E) -->
			<div id="SearchLayer01" style="display:inline">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>

			<!-- TABLE '#D' : ( Search Options :  ) (S) -->
			<!-- : ( Button :Top ) (S) -->
			<table width="100%" class="sbutton">
	       	<tr><td class="align">

			    <table class="sbutton">
			    <tr>
					<td class="bt"><img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" onClick="reSize();"></td></tr>
				</table>

			</td></tr>
			</table>
	    	<!-- : ( Button : Top ) (E) -->
	    	<div id="SearchLayer02" style="display:inline">
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="4%">Total</td>
					<td width="15%"><input type="text"  name="sht_01_ttl" style="width:80" readonly></td>
					<td width="3%">Full</td>
					<td width="14%"><input type="text" name="sht_01_full" style="width:80" readonly></td>
					<td width="5%">Empty</td>
					<td width="14%"><input type="text" name="sht_01_mt" style="width:80" readonly></td>
					<td width="13%">TS(Same Yard)</td>
					<td><input type="text" name="sht_01_ts_same_yard" style="width:80" readonly></td>

				</tr>
			</table>


			<table class="search_in" border="0">
				<tr class="h23">
					<td width="18">D2 </td><td width="40"><input type="text" name="sht_01_D2" style="width:32" readonly></td>
					<td width="18">D4 </td><td width="40"><input type="text" name="sht_01_D4" style="width:32" readonly></td>
					<td width="18">D5 </td><td width="40"><input type="text" name="sht_01_D5" style="width:32" readonly></td>
					<td width="18">D7 </td><td width="40"><input type="text" name="sht_01_D7" style="width:32" readonly></td>
					<td width="18">D8 </td><td width="40"><input type="text" name="sht_01_D8" style="width:32" readonly></td>
					<td width="18">D9 </td><td width="40"><input type="text" name="sht_01_D9" style="width:32" readonly></td>
					<td width="18">DW </td><td width="40"><input type="text" name="sht_01_DW" style="width:32" readonly></td>
					<td width="18">DX </td><td width="40"><input type="text" name="sht_01_DX" style="width:32" readonly></td>
					<td width="18">R2 </td><td width="40"><input type="text" name="sht_01_R2" style="width:32" readonly></td>
					<td width="18">R4 </td><td width="40"><input type="text" name="sht_01_R4" style="width:32" readonly></td>
					<td width="18">R5 </td><td width="40"><input type="text" name="sht_01_R5" style="width:32" readonly></td>
					<td width="18">R7 </td><td width="40"><input type="text" name="sht_01_R7" style="width:32" readonly></td>
					<td width="18">R8 </td><td width="40"><input type="text" name="sht_01_R8" style="width:32" readonly></td>
					<td width="18">R9 </td><td width="40"><input type="text" name="sht_01_R9" style="width:32" readonly></td>
					<td width="18">F2 </td><td width="40"><input type="text" name="sht_01_F2" style="width:32" readonly></td>
					<td width="18">F4 </td><td width="40"><input type="text" name="sht_01_F4" style="width:32" readonly></td>
					</tr>
				<tr class="h23">
					<td>F5</td><td><input type="text" name="sht_01_F5" style="width:32" readonly></td>
					<td>O2</td><td><input type="text" name="sht_01_O2" style="width:32" readonly></td>
					<td>O4</td><td><input type="text" name="sht_01_O4" style="width:32" readonly></td>
					<td>O5</td><td><input type="text" name="sht_01_O5" style="width:32" readonly></td>
					<td>O7</td><td><input type="text" name="sht_01_O7" style="width:32" readonly></td>
					<td>S2</td><td><input type="text" name="sht_01_S2" style="width:32" readonly></td>
					<td>S4</td><td><input type="text" name="sht_01_S4" style="width:32" readonly></td>
					<td>T2</td><td><input type="text" name="sht_01_T2" style="width:32" readonly></td>
					<td>T4</td><td><input type="text" name="sht_01_T4" style="width:32" readonly></td>
					<td>A2</td><td><input type="text" name="sht_01_A2" style="width:32" readonly></td>
					<td>A4</td><td><input type="text" name="sht_01_A4" style="width:32" readonly></td>
					<td>A5</td><td><input type="text" name="sht_01_A5" style="width:32" readonly></td>
					<td>P2</td><td><input type="text" name="sht_01_P2" style="width:32" readonly></td>
					<td>P4</td><td><input type="text" name="sht_01_P4" style="width:32" readonly></td>
					<!-- 
					<td>Z2</td><td><input type="text" name="sht_01_Z2" style="width:32" readonly></td>
					<td>Z4</td><td><input type="text" name="sht_01_Z4" style="width:32" readonly></td>
					-->
					<td>C2</td><td><input type="text" name="sht_01_C2" style="width:32" readonly></td>
					<td>C4</td><td><input type="text" name="sht_01_C4" style="width:32" readonly></td>
					</tr>
			</table>
			</div>
				<!-- : ( Week ) (E) -->
			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
							       	<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_totalamount" id="btng_totalamount">Total Amount</td>
												<td class="btn2_right"></td></tr></table>
										</td>

										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->
		</div>




		<!-- UI_ESD_TES_0017 : THIS IS 2st TAB -->
		<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('t2sheet1');</script>
				</td></tr>
			</table>

			<!-- : ( Grid : Week ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
							       	<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_totalamount" id="btng_totalamount">Total Amount</td>
												<td class="btn2_right"></td></tr></table>
										</td>

										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->
		</div>



		<!-- UI_ESD_TES_0017 : THIS IS 3st TAB -->
		<div id="tabLayer" style="display:none">


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('t3sheet1');</script>
				</td></tr>
			</table>

			<!-- : ( Grid : Week ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
				<table class="button" border="0" width="100%">
							       	<tr><td class="btn2_bg" class="align">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><div id="CostCodeDescShow" style="display:none">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_costcodedescshow" id="btng_costcodedescshow">Cost Code Desc. Show</td>
												<td class="btn2_right"></td></tr></table>
											</div>
										</td>
										<td><div id="CostCodeDescHide" style="display:none">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_costcodedeschide" id="btng_costcodedeschide">Cost Code Desc. Hide</td>
												<td class="btn2_right"></td></tr></table>
											</div>
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_totalamount" id="btng_totalamount">Total Amount</td>
												<td class="btn2_right"></td></tr></table>
										</td>

										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->
	</div>



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




<div id="hidden_sheets1" style="display:none;">
<script language="javascript">ComSheetObject('main_hidden');</script>
</div>
<div id="hidden_sheets3" style="display:none;">
<script language="javascript">ComSheetObject('vvd_hidden');</script>
</div><!--
accumulate_hidden : docObjects[5]
--><div id="hidden_sheets4" style="display:none;">
<script language="javascript">ComSheetObject('accm_hidden');</script>
</div>
<div id="hidden_sheets10" style="display:none;">
<script language="javascript">ComSheetObject('total_hidden');</script>
</div>


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>



</html>