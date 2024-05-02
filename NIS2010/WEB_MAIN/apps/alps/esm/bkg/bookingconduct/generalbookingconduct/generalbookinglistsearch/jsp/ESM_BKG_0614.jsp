<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0614.jsp
*@FileTitle : Work With Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20  
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.20 전용진
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
* 2012.08.20 조정민 [CHM-201219641] Workwith Booking Inquiry 기능 추가 개발 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0614Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0614Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String isInquiry = "N";	

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String sXml				= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingListSearch");

	List<BkgComboVO> bkg_sts_cd = null;
	List<BkgComboVO> bkg_cust_tp_cd = null;
	List<BkgComboVO> cust_ref_no = null;
	List<BkgComboVO> bkg_via_cd = null;
	List<BkgComboVO> si_via_cd = null;
	List<BkgComboVO> conti_cd = null;
	List<BkgComboVO> rtro_knd_cd = null;
	
	List<BkgComboVO> eq_tp_sz_cd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmBkg0614Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
		bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");
		cust_ref_no = (List<BkgComboVO>) eventResponse.getCustomData("cust_ref_no");
		//bkg_via_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_via_cd");
		//si_via_cd = (List<BkgComboVO>) eventResponse.getCustomData("si_via_cd");
		conti_cd = (List<BkgComboVO>) eventResponse.getCustomData("conti_cd");
		//rtro_knd_cd = (List<BkgComboVO>) eventResponse.getCustomData("rtro_knd_cd"); 

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Work With Booking</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userOfc_cd = "<%=strOfc_cd%>";
	var userId = "<%=strUsr_id%>";

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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="mst_bkg_no">
<input type="hidden" name="sXml" value="<%=sXml %>">
<input type="hidden" name="ca_rsn_cd"       value=""  style="width:30;"><!-- CA ReasonCd : 초기화 -->
<input type="hidden" name="ca_remark"       value=""  style="width:30;"><!-- CA Remark   : 초기화  -->
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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">Date</td>
						<td width="140" class="sm">(<input type="radio" name="date_gbn" value="Y" class="trans" checked>Booking&nbsp;<input type="radio" name="date_gbn" value="N" class="trans">On Board)</td>
						<td width="185">
					  		<input type="text" style="width:70" class="input1" name="bkg_from_dt" maxlength="10" caption="Booking Creation DT" dataformat="ymd">~<input type="text" style="width:70"  class="input1" name="bkg_to_dt" maxlength="10" caption="Booking Creation DT" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
						</td>
						<td width="25">VVD</td>
						<td width="90"><input type="text" name="vvd" style="ime-mode:disabled;width:75;" maxlength="9" dataformat="engupnum" value="" class="input1"></td>
						<td width="25">POL</td>
						<td width="85"><input type="text" name="pol_cd" style="width:45;" maxlength="5" dataformat="etc" value="" class="input">&nbsp;<input type="text" name="pol_yd_cd" maxlength="2" dataformat="etc" style="width:25;" value="" class="input"></td>
						<td width="25">POD</td>
						<td width="85"><input type="text" name="pod_cd" style="width:45;" maxlength="5" dataformat="etc" value="" class="input">&nbsp;<input type="text" name="pod_yd_cd" maxlength="2" dataformat="etc" style="width:25;" value="" class="input"></td>
						<td width="25">POR</td>
						<td width="55"><input type="text" name="por_cd" style="width:45;" maxlength="5" dataformat="etc" value="" class="input"></td>
						<td width="25">DEL</td>
						<td width="55"><input type="text" name="del_cd" style="width:45;" maxlength="5" dataformat="etc" value="" class="input"></td>
						<td width="60">DEL Cont</td>
						<td width="">
						<%=HTMLUtil.getComboString("dlv_ctnt_cd", "width:80;", "", "","","All", conti_cd)%>
						</td>
						</tr>
				</table>  
				<table class="height_2"><tr><td></td></tr></table>	
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="76">BKG STS</td>
						<td width="130" style="padding-left:2">
						<%=HTMLUtil.getComboString("bkg_sts_cd", "width:100;", "", "","","All", bkg_sts_cd)%>
						</td>
						<td width="59">BKG OFC</td>
						<td width="65"><input type="text" name="bkg_ofc_cd" style="width:50;" maxlength="6" dataformat="etc" value="" class="input"></td>
						<td width="55">BKG STF</td>
						<td width="90"><input type="text" name="bkg_stf_cd" style="width:75;" maxlength="20" value="" class="input"></td>
						<td width="60">Sales OFC</td>
						<td width="80"><input type="text" name="sls_ofc_cd" style="width:60;" maxlength="6" dataformat="etc" value="" class="input"></td>
						<td width="65">Sales Rep.</td>
						<td width="60"><input type="text" name="srep_cd" style="width:50;" maxlength="5" dataformat="etc" value="" class="input"></td>
						<td class="stm"><input type="checkbox" name="dcgo_flg" value="Y" class="trans">DG
										<input type="checkbox" name="rf_flg" value="Y" class="trans">RF
										<input type="checkbox" name="awk_cgo_flg" value="Y" class="trans">AK
										<input type="checkbox" name="bb_cgo_flg" value="Y" class="trans">BB
										<input type="checkbox" name="rd_cgo_flg" value="Y" class="trans">RD
										<input type="checkbox" name="hngr_flg" value="Y" class="trans">HG</td>
						</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="77">Booking No.</td>
						<td width="130"><input type="text" name="bkg_no" style="ime-mode:disabled;width:100;" maxlength="13" dataformat="engupnum" value="" class="input1">&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
						<td width="60">Customer</td>
						<td width="315">
						<%=HTMLUtil.getComboString("bkg_cust_tp_cd", "width:85;", "", "","","", bkg_cust_tp_cd)%>
							<input type="text" name="cust_cnt_cd" style="width:25;" maxlength="2" dataformat="etc" value="" class="input">&nbsp;<input type="text" name="cust_seq" style="width:50;" maxlength="6" dataformat="etc" value="" class="input">&nbsp;<input type="text" name="cust_nm" style="width:90;" maxlength="50" dataformat="etc" value="" class="input">
							<img src="img/btns_search.gif" name="btn_ComEns041Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width="110">Customer Ref No.</td>
						<td width="">
						<%=HTMLUtil.getComboString("cust_ref_tp_cd", "width:160;", "", "","","All", cust_ref_no)%>
							<input type="text" name="cust_ref_no" style="width:120;" maxlength="50" dataformat="etc" value="" class="input"></td>
					</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="148"><input type="radio" name="sc_rfa_gbn" class="trans" value="S" checked>&nbsp;S/C<input type="radio" name="sc_rfa_gbn" value="R" class="trans">&nbsp;RFA<input type="radio" name="sc_rfa_gbn" value="T" class="trans">&nbsp;TAA</td>
						<td width="90"><input type="text" name="sc_rfa_no" style="width:85;" maxlength="11" dataformat="engupnum" value="" class="input"></td>
						<td width="20">BDR</td>
						<td width="60" style="padding-left:2">
						  <select style="width:53;" name="bdr_flg">
							<option value="" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
							</select></td>
						<td width="20">S/I</td>
						<td width="60">
						  <select style="width:52;" name="si_cd">
							<option value="" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
							</select></td>
						<td width="48">BKG Via</td>
						<td width="115">
							<script language="javascript" >ComComboObject('bkg_via_cd', 1, 110, 1, 0, 2)</script>
						<!-- %=HTMLUtil.getComboString("bkg_via_cd", "width:110;", "", "","","All", bkg_via_cd)%-->
						</td>
						<td width="48">S/I Via</td>
						<td width="115">
							<script language="javascript" >ComComboObject('si_via_cd', 1, 110, 1, 0, 2)</script>
						<!-- %=HTMLUtil.getComboString("si_via_cd", "width:110;", "", "","","All", si_via_cd)%-->
						</td>
						<td width="100">Display T/S Port</td>
						<td width=""><input type="checkbox" name="ts_port" class="trans" onClick="javascript:showTsPortInfo();"></td>
						<td width="57">E/Q Type</td>
						<td width="63">
							<script language="javascript" >ComComboObject('eq_tp_sz_cd', 1, 60, 1, 0, 2)</script>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="85">No Rate STS</td>
						<td width="120" style="padding-left:2">
						  <select style="width:91;" name="non_rt_sts_cd">
							<option value="" selected>All</option>
							<option value="F">Firm</option>
							<option value="R">No Rate</option>
							</select></td>
						<td width="85">Standby STS</td>	
						<td width="112" style="padding-left:2">
						  <select style="width:104;" name="aloc_sts_cd">
							<option value="" selected>All</option>
							<option value="F">F-Firm</option>
							<option value="S">S-Standby</option>
							</select></td>	
						<td width="100">Spot Guide RFA</td>
						<td width="30"><input type="checkbox" name="spot_guide_flg" value="G" class="trans"></td>
						<td width="140">OFT Change after PCT</td>
						<td width="125">
							<script language="javascript" >ComComboObject('rtro_knd_cd', 1, 120, 1, 0, 2)</script>
						<!-- %=HTMLUtil.getComboString("rtro_knd_cd", "width:120;", "", "","","All", rtro_knd_cd)%-->
						</td>
						<td width="182"></td>
						</tr>
				</table>
				<!--  biz_1   (E) -->		

		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	

		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	

			<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_2 (E) -->	
			<!--  Button_Sub (S) -->
				<table width="100%" class="button" border="0"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_BKGCopy">BKG Copy</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_BLCopy">B/L Copy</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Split">Split</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Combine">Combine</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_BLPrint">B/L Print</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
					</tr>
					</table>
					
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
					

			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
</form>
</body>
</html>