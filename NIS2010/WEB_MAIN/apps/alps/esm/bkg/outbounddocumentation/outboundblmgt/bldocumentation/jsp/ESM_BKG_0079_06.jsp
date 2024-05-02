<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0079_06.jsp
 *@FileTitle : Marks & Number/Description of Goods
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.01
 *@LastModifier : 최 선 
 *@LastVersion : 1.2
 * 2009.04.28 김영출
 * 1.0 Creation
 *----------------------------------------------------------
 * History
 * 2010.09.13 이일민 1.1 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * 2010.12.01 최 선     1.2 [CHM-201007417] PO & Other No (General) Incoterms Column Add, Validation 
 * 2012.10.15 김기택 [CHM-201218571-01] [BKG] C/A 항목 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007906Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>

<%

	EsmBkg007906Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strOfc_cd  = "";
	String isInquiry = "N";	
	Logger log = Logger.getLogger("com.hanjin.apps.outboundblmgt.bldocumentation");

	/*
	*/
	String bkg_no = "";
	String bl_no = "";
	String bl_tp_cd = "";

	List<BkgComboVO> frt_terms = null;
	List<BkgComboVO> wgt_units = null;
	List<BkgComboVO> meas_units = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmBkg007906Event)request.getAttribute("Event");
		bl_no        = event.getBlNo();
		bl_tp_cd     = event.getBlTpCd();
		bkg_no  = JSPUtil.getParameter(request, "bkg_no");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        frt_terms = (List<BkgComboVO>) eventResponse.getCustomData("frt_terms");
        wgt_units = (List<BkgComboVO>) eventResponse.getCustomData("wgt_units");
        meas_units = (List<BkgComboVO>) eventResponse.getCustomData("meas_units");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Marks & Number/Description of Goods</title>
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
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="strOfc_cd" value="<%= strOfc_cd%>">
<input type="hidden" name="dirty_flag">
<input type="hidden" name="bdr_flg">
<input type="hidden" name="corr_flg">
<input type="hidden" name="ca_exist_flg">
<input type="hidden" name="bkg_sts_cd">
<input type="hidden" name="cstms_clr_cd">
<input type="hidden" name="pck_nm">
<input type="hidden" name="cntr_desc">
<input type="hidden" name="rc_flg">
<input type="hidden" name="xpt_imp_seq">
<input type="hidden" name="po_cust_flag">
<input type="hidden" name="po_ref_flag">
<input type="hidden" name="po_ref_dtl_flag">
<input type="hidden" name="obl_iss_flg">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="bl_tp_cd">
<input type="hidden" name="img_flg">
<input type="hidden" name="r_po_other_mdt_itm">
<input type="hidden" name="bkg_ref_tp_ml_cd">
<input type="hidden" name="shpr_cd">
<input type="hidden" name="cust_flg">
<input type="hidden" name="nl_cmdt_flg">
<input type="hidden" name="old_bkg_no" value="<%= bkg_no%>">

<!-- 개발자 작업	-->


	<!--biz page (S)-->
		<table class="search" style="width:979;">
       <tr><td class="bg">
       
       	<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t8sheet1');</script>
					</td>
				</tr>
			</table>
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t8sheet2');</script>
					</td>
				</tr>
			</table>
			
			<!--  biz_1  (S) -->
			<table class="search" border="0">
				<tr class="h23">
					<td width="90">Booking No.</td>
					<td width="150"><input type="text" id="bkg_no" name="bkg_no" class="input" value="<%=bkg_no%>" maxlength="13" style="ime-mode:disabled;width:110px;" dataformat="engupnum">
					<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="50">B/L No.</td>
					<td width="150"><input type="text" name="bl_no" maxlength=13 class="input" value="<%//=bl_no%>" style="ime-mode:disabled;width:110px;" dataformat="engupnum"></td>
					<td width="40">T/VVD</td>
				    <td width="121"><input type="text" name="t_vvd" size="14" class="input2" readOnly><input type="hidden" name="vsl_cd"><input type="hidden" name="skd_voy_no"><input type="hidden" name="skd_dir_cd"></td>
					<td width="38">Route</td>
					<td width="206"><input type="text" name="por_cd" class="input2" readOnly style="ime-mode:disabled;width:45;" dataformat="engupnum">&nbsp;<input type="text" name="pol_cd" class="input2" readOnly style="ime-mode:disabled;width:45;" dataformat="engupnum">&nbsp;<input type="text" name="pod_cd" class="input2" readOnly style="ime-mode:disabled;width:45;" dataformat="engupnum">&nbsp;<input type="text" name="del_cd" class="input2" readOnly style="ime-mode:disabled;width:45;" dataformat="engupnum"></td>
					<td width="60">R/D Term</td>
					<td width=""><input type="text" name="rcv_term_cd" class="input2" readOnly style="ime-mode:disabled;width:20;" dataformat="engupnum">&nbsp;<input type="text" name="de_term_cd" class="input2" readOnly style="ime-mode:disabled;width:20;" dataformat="engupnum"></td>
				</tr>
			</table>	
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Commodity</td>
					<td width="665"><input name="cmdt_cd" type="text" class="input2" readOnly style="width:68;" dataformat="engupnum">&nbsp;<input name="rep_cmdt_cd" type="text" class="input2" readOnly style="width:50;" dataformat="engupnum">&nbsp;<input name="cmdt_desc" type="text" class="input2" readOnly style="ime-mode:disabled;width:518;" dataformat="engupnumspc"></td>
					<td width="">FRT Term &nbsp; <%=HTMLUtil.getComboString("frt_term_cd", "width:90;", "input1", "P", frt_terms)%></td>
					
					<input type="hidden" name="frt_term_prn_flg">
					<td class="stm" align="right">(Print<input type="checkbox" name="frt_term_prn_flg_chkbox" class="trans" value="Y" checked >)</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Total Package</td>
					<td width="145"><input name="pck_qty" type="text" class="input1" dataformat="int" maxlength="7" style="width:70; text-align:right;">&nbsp;<input name="pck_tp_cd" type="text" class="input1" style="ime-mode:disabled;width:30;" dataformat="engup" maxlength="2">&nbsp;<img name="btn_find_package" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Total Weight</td>
					<td width="155"><input name="act_wgt" type="text" class="input1" dataformat="float" maxlength="13" pointcount="3" style="width:93; text-align:right;">&nbsp;<%=HTMLUtil.getComboString("wgt_ut_cd", "width:45;", "input1", "", wgt_units)%><!--select name="wgt_ut_cd" class="input1" style="width:45;"><option value="KGS">KGS</option><option value="LBS">LBS</option></select--></td>
					<td width="85" class="stm">(Print<input type="checkbox" name="act_wgt_prn_flg" class="trans" value="Y" checked >)</td>
					<td width="90">Total Measure</td>
					<td width=""><input name="meas_qty" type="text" class="input" dataformat="float" maxlength="9" pointcount="3" style="width:78; text-align:right;">&nbsp;<%=HTMLUtil.getComboString("meas_ut_cd", "width:50;", "input", "", meas_units)%><!--select name="meas_ut_cd" class="input1" style="width:50;"><option value="CBM">CBM</option><option value="0CBF">CBF</option></select--></td>
					<td width="180" align="right"><table width="170" border="0" cellpadding="0" cellspacing="0" class="button">
											  <tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_t8ExportImportInfo">Export & Import Info.</td>
												<td class="btn2_right"></td>
											  </tr></table>
				    </td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="130">Customs Description</td>
					<td width=""><input name="cstms_desc" type="text" class="input1" style="ime-mode:disabled;width:645;" dataformat="engupnumspc"></td>
					<td width="180" align="right"><table width="170" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_t8POOtherNo">P/O & Other No.</td>
											<td class="btn2_right"></td>
											</tr></table>
					</td>
				</tr>
			</table>
			<!--  biz_1   (E) -->

			<table class="line_bluedot"><tr><td></td></tr></table>

			<!--  biz_2  (S) -->
			<table class="search_sm" border="0" style="width:979;">
				<tr class="h23">
					<td valign="top" width="310">
						<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr class="tr2_head">
							<td width="110">Marks & Numbers</td>
						  <td class="sm">Template&nbsp;
								<select name="mk_word_template" style="width:98;">
								<option value="0" selected>Select Template</option>
								</select><img name="find_tmplt_m" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
							<tr>
							  <td colspan="2" class="input2"><textarea name="mk_desc" cols="23" rows="14" style="font-family:Courier New;font-size:14px;text-indent:0px;overflow-x:hidden;overflow-y:scroll;word-break:keep-all;" dataformat="engupnumspc" wrap="hard"></textarea></td>
							</tr>
						</table>
					</td>
					<td  valign="top" width="20"></td>
					<td  valign="top" width="649">
						<table width="100%" border="0" style="background-color:white;" class="grid2">
						<tr class="tr2_head">
							<td colspan="2">Description of Goods</td>
							<td width="51%" class="sm" align="right">Template&nbsp;
							    <select name="dg_word_template" style="width:120;">
								<option value="0" selected>Select Template</option>
								</select>&nbsp;<img name="find_tmplt_d" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
						<tr class="tr2_head">
							<td>No. of PKG/CNTR</td>
							<td colspan="2" class="input2" readOnly><input type="text" name="pck_cmdt_desc" class="input" style="ime-mode:disabled;width:100%;" dataformat="engupnumspc"></td>
						</tr>
						<tr class="tr2_head">
							<td align="center">
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left" style="border:0; padding:0;"></td>
								<td class="btn2" style="border:0; padding:0;" name="btn_copy">Copy</td>
								<td class="btn2_right" style="border:0; padding:0;"></td></tr>
								</table>
							</td>
							<td colspan="2" class="input2" readOnly><input type="text" name="cntr_cmdt_desc" class="input" style="ime-mode:disabled;width:100%;" dataformat="engupnumspc"></td>
						</tr>
						<tr>
						    <td width="18%" class="input2" align="center">&nbsp;&nbsp;&nbsp;</td>
							<td colspan="2" class="input2">
							<table>
							<tr>
								<td width=395>
								<textarea name="dg_cmdt_desc" cols="49" rows="10" style="font-family:Courier New;font-size:14px;text-indent:0px;overflow-x:hidden;overflow-y:scroll; url('img/img_rider_line_10.jpg') repeat-x;word-break:keep-all;" dataformat="engupnumspc" wrap="hard"></textarea>
								</td>
								<td valign="bottom">
								<table class="search_sm" border="0">
									<tr rowspan=2>
										<td width=70 align="center" style="border:1px solid #E9E9E9;"><div style="display:none" id="display_yn1">Auto-Clause Display</div>
										</td>
										<td width=20 border="0" style="border:1px solid #E9E9E9;"><div style="display:none" id="display_yn2"><input type="checkbox" name="display_chk" class="trans" value="Y"></div></td>

									</tr>
								</table>
								</td></tr></table></td>
						</tr>
						<tr class="tr2_head">
							 <td >Clause Lock</td>
							<td valign="top" colspan="2" class="sm">
								<table width="100%" class="grid2"> 
									<tr><td width="100%">
										<script language="javascript">ComSheetObject('t8sheet3');</script>
									</td></tr>
								</table>							       		
								<table border="0" cellpadding="0" cellspacing="0" width="100%" class="grid2">
									<tr>
									<td style="float:left;border:0; padding:0;width:500px">This clause lock is reserved for WEB SI auto upload project.</td>
									<td  style="border:0; padding:0;"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_Clz_Add">Add</td>
										<td class="btn2_right" style="border:0; padding:0;"></td>
										</tr>
									</table></td>
									<td  style="border:0; padding:0;"><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left" style="border:0; padding:0;"></td>
										<td class="btn2" style="border:0; padding:0;" name="btn_Clz_Delete">Delete</td>
										<td class="btn2_right" style="border:0; padding:0;"></td>
										</tr>
									</table></td>
									</tr>
								</table>
				       		</td>
		       			</tr>
					</table>
					</td>
				</tr>
			</table>

			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="200">Total No. of PKG/CNTR in Word</td>
					<td width="550"><input name="ttl_pck_desc" type="text" class="input" style="ime-mode:disabled;width:540;" dataformat="engupnumspc" maxlength="57"></td>
					<td width="" align="right">Template&nbsp;
						<select name="tp_word_template" style="width:132;">
							<option value="0" selected>Select Template</option>
						</select>&nbsp;<img name="find_tmplt_t" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
			<!--  biz_2  (E) -->

			</td>
		</tr>
	</table>
	<!--biz page (E)-->
<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       	<tr><td class="btn1_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8Retrieve" id="btn_t8Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8New" id="btn_t8New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">

							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8Save" id="btn_t8Save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8CopyfromDG">Copy from DG</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8CopyfromCM">Copy from C/M</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8CopyfromHouseBL">Copy from House B/L</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8BLRider" id="btn_t8BLRider">Attachment</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<!--  
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t8NVOHouseBL">NVOCC House B/L</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						-->
					  </tr>
					</table>
				</td></tr>
			</table>
		    <!--Button (E) -->


<!-- 개발자 작업  끝 -->
<iframe id="descRequest" name="descRequest" src="about:blank" width="100%" height="200" onload="descSend()" width="0" height="0" style="display:none"></iframe>

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING="5" CELLSPACING="0" BORDER="0"/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder="0" marginHeight="0' marginWidth="0" width="115" height="82"  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING="0" scrolling="no"/></IFRAME>
</div>
</form>
</body>
</html>