<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1511.jsp
*@FileTitle : ESM_BKG_1511
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier :신규정
*@LastVersion : 1.0
* 2015.04.07 신규정
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.event.EsmBkg1512Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1512Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
		Logger log = Logger.getLogger("com.hanjin.apps.Customsdeclaration.Manifestlistdownload");
	
	String callGubun = "";
	String dType = "";
	String vvdCd = "";
	String portCd = "";
	String blNo = "";
	String cntrNo = "";
	String cntrCgoSeq = "";
	String berthCd = "";
	String berthNm = "";
	String bkgNo = "";

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
	   
		event = (EsmBkg1512Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// 부모창에서 넘오온 파라메터 셋팅
		callGubun 	= (request.getParameter("callGubun") == null) ? "" : request.getParameter("callGubun");
		dType 		= (request.getParameter("d_type") == null) ? "" : request.getParameter("d_type");
		vvdCd 		= (request.getParameter("vvd_cd") == null) ? "" : request.getParameter("vvd_cd");
		portCd 		= (request.getParameter("port_cd") == null) ? "" : request.getParameter("port_cd");
		blNo 		= (request.getParameter("bl_no") == null) ? "" : request.getParameter("bl_no");
		cntrNo 		= (request.getParameter("cntr_no") == null) ? "false" : request.getParameter("cntr_no");
		cntrCgoSeq 	= (request.getParameter("cntr_cgo_seq") == null) ? "false" : request.getParameter("cntr_cgo_seq");
		berthCd 	= (request.getParameter("berth_cd") == null) ? "" : request.getParameter("berth_cd");
		berthNm 	= (request.getParameter("berth_nm") == null) ? "" : request.getParameter("berth_nm");
		bkgNo 		= (request.getParameter("bkg_no") == null) ? "" : request.getParameter("bkg_no");
		
// 		if("".equals(callGubun)) {
// 			if(strOfc_cd.startsWith("ANR")) {
// 				callGubun = "ESM_BKG_0965";
// 			} else {
// 				callGubun = "ESM_BKG_0966";
// 			}
// 		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=dType%>');
	}
	function endPage() {
		closePage();
	}
</script>
</head>


<body  onLoad="setupPage();" onbeforeunload="endPage();">  
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofcCd" value="<%=strOfc_cd %>">

<input type="hidden" name="call_gubun" value="<%=callGubun%>">
<input type="hidden" name="d_type" value="<%=dType%>">
<input type="hidden" name="vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="port_cd" value="<%=portCd%>">
<input type="hidden" name="bl_no" value="<%=blNo%>">
<input type="hidden" name="frm_bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="p_cntr_no" value="<%=cntrNo%>">
<input type="hidden" name="p_cntr_cgo_seq" value="<%=cntrCgoSeq%>">
<input type="hidden" name="p_berth_cd" value="<%=berthCd%>">
<input type="hidden" name="p_berth_nm" value="<%=berthNm%>">

<input type="hidden" name="save_type" value="">

<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_args" value="email;">

<input type="hidden" name="trans_type">

<input type="hidden" name="page_save_yn" value="N">


<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
    <td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp; Dangerous Cargo Detail(s) Inquiry</td>
			</tr>
		</table>
	<!--Page Title, Historical (E)-->	

		<!-- : ( Search Options ) (S) -->
 
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<%
					if(callGubun.equals("ESM_BKG_0965")) {
				%>
				
					<td width="500">
						<table class="search_sm2" border="0" style="width:495;"> 
							<tr class="h23">
								<td width="80">&nbsp;Declaration </td>
								<td width="" class="stm">
									<input type="checkbox" name="d_type1" value="D" class="trans" disabled="true">Discharging
									<input type="checkbox" name="d_type1" value="T" class="trans" disabled="true">Transit
									<input type="checkbox" name="d_type1" value="L" class="trans" disabled="true">Loading
									<input type="checkbox" name="d_type1" value="P" class="trans" disabled="true">Pre-carriage
									<input type="checkbox" name="d_type1" value="O" class="trans" disabled="true">On-Carriage
								</td>
							</tr>
						</table>
					</td>

				<%
					} else {
				%>

					<td width="305">
						<table class="search_sm2" border="0" style="width:300;"> 
							<tr class="h23">
								<td width="80">&nbsp;Declaration </td>
								<td width="" class="stm">
									<input type="radio" value="D" class="trans" name="d_type1" disabled="true">Import
									<input type="radio" value="T" class="trans" name="d_type1" disabled="true">Transit
									<input type="radio" value="L" class="trans" name="d_type1" disabled="true">Export	
								</td>	
								
							</tr>
						</table>
					</td> 
				<%
					}
				%>					
					 
					<td width="380" valign="middle">
						<table class="search_sm2" border="0" style="width:;"> 
							<tr class="h23">
								<td width="165">B/L No.
									<input type="text" style="width:100;" class="input2" name="bl_no" maxlength="12" value="<%=blNo%>" readOnly="true"></td> 
								<td width="">Container No.
									<script language="javascript">ComComboObject('cntr_list', 1, 110, 1);</script></td> 
							</tr>
						</table>
					</td>
					<td valign="middle">
						<img name="btn1_back" class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle">
						<img name="btn1_next" class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle">
						<input type="text" style="width:50;text-align:center" name="dis_cntr_cgo_seq" readOnly="true">
						<input type="hidden" name="cntr_cgo_seq">
						<input type="hidden" name="cntr_no">
					</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<!-- 			<table class="search" border="0" style="width:;">  -->
<!-- 				<tr class="h23"> -->
<!-- 					<td width="80">Sent Status</td>  -->
<!-- 					<td width="200"> -->
<!-- 						<input type="text" style="width:180; font-weight:bold;color: #ffffff;" class="input2" name="frm_ack_rcv_sts_cd" readOnly></td> -->
<!-- 					<td width="150">Acknowledge Remark(s)</td> -->
<!-- 					<td width=""><input type="text" style="width:100%;" class="input2" name="frm_cstms_err_msg" readOnly></td> -->
<!-- 					<td width=""><script language="javascript">ComComboObject('rcv_err_list', 2, 300, 1, 3, 1);</script></td> -->
					
<!-- 				</tr> -->
<!-- 			</table> -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
				
			
				<table width="100%" class="grid2"> 
				<tr>
					<td class="tr2_head" width="20%">Container No.</td>
					<td width="22%">
						<input type="text" style="width:90; ime-mode: disabled" class="input2" name="frm_cntr_no" readOnly>
						<input type="text" style="width:50; ime-mode: disabled" class="input2" name="frm_cntr_tpsz_cd" readOnly>
						<input type="text" style="width:50; ime-mode: disabled" class="input2" name="frm_cntr_tpsz_iso_cd" readOnly></td>
					<td class="tr2_head" width="25%">Marine Pollutant</td>
					<td style="padding-left:2">
					<% if(strCnt_cd.equals("GB")) { %>
						<select style="width:200;" name="frm_dcgo_mrn_polut_cd">
							<option value="N" selected="true">No</option>
							<option value="Y">Yes</option>
							<option value="P">Pollutant</option>
							<option value="PP">severe pollutant</option>
						</select>
					<% } else { %>					
						<select style="width:200;" name="frm_dcgo_mrn_polut_cd">
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</select>
					<% } %>
					</td>
				</tr>
				<tr>
					<td class="tr2_head">Class/Sub1/Sub2/Sub3/Sub4</td>
					<td><input type="text" style="width:37; ime-mode: disabled" name="frm_imdg_clss_cd" class="input" dataformat="float">
					<input type="text" style="width:37; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd1" class="input" dataformat="float">
					<input type="text" style="width:37; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd2" class="input" dataformat="float">
					<input type="text" style="width:37; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd3" class="input" dataformat="float">
					<input type="text" style="width:37; ime-mode: disabled" name="frm_imdg_subs_rsk_lbl_cd4" class="input" dataformat="float">
					
					
					</td>
					<td class="tr2_head">Limited quantity</td>
					<td style="padding-left:2">
					<select style="width:200; ime-mode: disabled" name="frm_imdg_lmt_qty_flg">
						<option value="Y">Yes</option>
						<option value="N" selected="true">No</option>
					</select></td>
				</tr>
				<tr>
					<!-- 
					<td class="tr2_head">Page</td>
					<td><input type="text" style="width:197; ime-mode: disabled" name="frm_emer_rspn_gid_no" class="input"></td>
					 -->
					<td class="tr2_head">Net Explosive Weight / KG</td>
					<td><input type="text" style="width:197; ime-mode: disabled" name="frm_net_explo_wgt" class="input"></td>
					<td class="tr2_head">High Consequence dangerous goods</td>
					<td style="padding-left:2"><select style="width:200;" name="frm_hcdg_flg">
						<option value="Y">Yes</option>
						<option value="N" selected="true">No</option>
					</select></td>
				</tr>
				<tr>
					<td class="tr2_head">UN No.	  </td>
					<td><input type="text" style="width:120; ime-mode: disabled" name="frm_imdg_un_no" class="input2" dataformat="yy">&nbsp;
						<input name="frm_imdg_un_no_seq" type="text" style="width:20;" class="input2" value="" readonly>&nbsp;
						<input name="frm_imdg_comp_grp_cd" type="text" style="width:20;" class="input2" value="" readonly>&nbsp;
						<img name="btn_popup4" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td class="tr2_head">Outer Package Qty / Code</td>
					<td>
						<input type="text" style="width:178; ime-mode: disabled" name="frm_out_imdg_pck_qty1" class="input" value="" dataformat="signedfloat">
						<input type="text" style="width:179; ime-mode: disabled" name="frm_out_imdg_pck_cd1" class="input">
					</td>
				</tr>
				<tr>
					<td class="tr2_head">Flash Point </td>
					<td>
						<input type="text" style="width:197; ime-mode: disabled" name="frm_flsh_pnt_cdo_temp" class="input" dataformat="signedfloat" caption="Flash Point">
					</td>
					<td class="tr2_head">Outer Package Description</td>
					<td><input type="text" style="width:360; ime-mode: disabled" name="frm_eur_outr_pck_desc" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Packing Group	   </td>
					<td>
						<select style="width:197; ime-mode: disabled" name="frm_imdg_pck_grp_cd">
							<option value=""></option>
							<option value="1">I</option>
							<option value="2">II</option>
							<option value="3">III</option>
							<option value="N">N</option>
						</select>					
						<!-- <input type="text" style="width:197;" name="frm_imdg_pck_grp_cd" class="input">-->
					</td>
					<td class="tr2_head">Inner Package Qty / Code</td>
					<td>
						<input type="text" style="width:178; ime-mode: disabled" name="frm_in_imdg_pck_qty1" class="input" value="" dataformat="signedfloat">
						<input type="text" style="width:179; ime-mode: disabled" name="frm_in_imdg_pck_cd1" class="input">
					</td>
				</tr>
				<tr>
					<td class="tr2_head">EMS No.</td>
					<td><input type="text" style="width:197; ime-mode: disabled" name="frm_ems_no" class="input"></td>
					<td class="tr2_head">Inner Package Description</td>
					<td><input type="text" style="width:360; ime-mode: disabled" name="frm_eur_inr_pck_desc" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Net Weight	</td>
					<td><input type="text" style="width:197;ime-mode: disabled" name="frm_net_wgt" class="input" dataformat="signedfloat"></td>
					<td class="tr2_head">Mfag</td>
					<td><input type="text" style="width:200;ime-mode: disabled" name="frm_mfag_no" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Gross Weight</td>
					<td><input type="text" style="width:197;ime-mode: disabled" name="frm_grs_wgt" class="input" dataformat="signedfloat"></td>
					<td class="tr2_head">Cell Position</td>
					<td><input type="text" style="width:200;ime-mode: disabled" name="frm_cell_psn_no" class="input" dataformat="eng" maxlength="7" fullfill caption="Cell Position"></td>
				</tr>
				<tr>
					<td class="tr2_head">Package</td>
					<td colspan="3"><input type="text" style="width:100%;ime-mode: disabled" name="frm_eur_pck_desc" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Substance</td>
					<td colspan="3"><input type="text" style="width:100%;ime-mode: disabled" name="frm_prp_shp_nm" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Hazardous Contents </td>
					<td colspan="3"><input type="text" style="width:100%;ime-mode: disabled" name="frm_hzd_desc" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Berth</td>
					<td colspan="3"><input type="text" style="width:100;ime-mode: disabled" name="frm_brth_yd_cd" class="input" dataformat="eng" maxlength="7" caption="Berth">
					<input type="text" style="width:275;ime-mode: disabled" name="frm_brth_yd_nm" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Extended Stay Permit</td>
					<td colspan="3"><input type="text" style="width:70%;ime-mode: disabled" name="frm_xtd_stay_prmt_no" class="input"></td>
				</tr>
				<tr>
					<td class="tr2_head">Additional Remark(s)</td>
					<td colspan="3"><input type="text" style="width:100%;ime-mode: disabled" name="frm_diff_rmk" class="input"></td>
				</tr>
				
			<%
				if(callGubun.equals("ESM_BKG_0965")) {
			%>
				
				<tr>
					<td class="tr2_head">Forwarder Name</td>
					<td colspan="3">
						<input type="text" style="width:100;ime-mode: disabled" name="frm_anr_fwrd_id" class="input" dataformat="engup" maxlength="6" caption="Forwarder Code">
						<input type="text" style="width:400;ime-mode: disabled" name="frm_fwrd_nm" id="frm_fwrd_nm" class="input">
						<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_popup1">
					</td>
				</tr>
				<tr>
					<!-- <td class="tr2_head">On-Carriage Date<br> (YYYY-MM-DD)</td> -->
					<td class="tr2_head"><div id="layoutView1" style="width:150px;">On-Carriage Date<br> (YYYY-MM-DD)</div></td>
					<td colspan="3">
						<input type="text" style="width:100;text-align:center;" name="frm_crr_dt" class="input2"
						dataformat="ymd" maxlength="10" caption="On-Carriage Date">
						<!-- <img src="img/btns_calendar.gif" width="19" height="20" alt=""	border="0" align="absmiddle" class="cursor" name="btn_calendar"> -->
					</td>
				</tr>
				
				<tr>
					<td class="tr2_head">Belgian Codes for Type<br> of special UN numbers</td>
					<td colspan="3" style="padding-left:2">
					<!-- <select style="width:200;" name="frm_imdg_un_no_desc"> -->
					<select style="width:200;" name="frm_anr_spcl_tp_id">
						<option value=""></option>
						<option value="AMN">AMN: Ammonum Nitrate</option>
						<option value="SPR">SPR: Explosives</option>
						<option value="ZTG">ZTG: Very Toxic Gases</option>
					</select>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_popup2"></td>
				</tr>
				<tr>
					<td class="tr2_head">Carriage Type </td>
					<td style="padding-left:2">
						<select style="width:200;" name="frm_anr_crr_tp_cd">
							<option value=""></option>
							<option value="X">TBN</option>
							<option value="T">Road</option>
							<option value="R">Rail</option>
							<option value="B">Barge</option>
							<option value="V">Marintime</option>
						</select>
					</td>
					<td class="tr2_head">SSR for Feeder transshipment</td>
					<td>
						<input type="text" style="width:100%;ime-mode: disabled" name="frm_fdr_svc_rqst_no" class="input" 
						dataformat="eng" maxlength="14" caption="SSR for Feeder transshipment">
					</td>
				</tr>
				<tr>
					<td class="tr2_head">Feeder VVD</td>
					<td><input type="text" style="width:197;ime-mode: disabled" name="frm_fdr_vvd_id" class="input" dataformat="engupnum" maxlength="9" caption="Feeder VVD"></td>
					<!-- <td class="tr2_head">Feeder Name / Lloyd No</td> -->
					<td class="tr2_head"><div id="layoutView" style="width:150px;">Feeder Name / Lloyd No</div></td>
					<td>
						<input type="text" style="width:62%;ime-mode: disabled" name="frm_fdr_vsl_nm" class="input" readOnly caption="Feeder Name" >
						<input type="text" style="width:30%;ime-mode: disabled" name="frm_fdr_vsl_lloyd_no" class="input" readOnly maxlength="7" caption="Lloyd No"> 
						<!--&nbsp;<div id="layoutView3" style="display:inline"><script language="javascript">ComComboObject('feeder_lloyd_list', 2, 20, 1, 3, 0);</script></div> -->
						&nbsp;<div id="layoutView3" style="display:inline"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_popup3"></div>
					</td>
				
				</tr>
				
			<% } %>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td>
</tr>
</table>
 
		<div style="display:none">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save(CNTR)">Save (CNTR)</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save(BKG)">Save (BKG)</td>
					<td class="btn1_right">
				</tr></table></td>

				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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
	

</body>
</html>

