<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_10.jsp
 *@FileTitle : e-Booking & SI Process Detail(HBL 1)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.15 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022910Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg022910Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;

	List<BkgComboVO> wgt_cd = null;
	List<BkgComboVO> meas_cd = null;
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022910Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
		
		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");
		meas_cd = (List<BkgComboVO>) eventResponse.getCustomData("meas_cd");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(HBL 1)</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="xter_si_no" value="<%=StringUtil.xssFilter(request.getParameter("xter_si_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>"> 
<input type="hidden" name="hbl1_nis" value=""> 
<input type="hidden" name="hbl1_esvc" value=""> 
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>"> 
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-left: 0;">
	<tr>
		<td valign="top"><!--biz page (S)--> <!-- Grid BG Box  (S) -->
		<table class="search" id="mainTable" style="width: 958; height: 600;">
			<tr>
				<td class="bg" valign="top">

				<table class="search" border="0" style="width: 958;">
					<tr class="h23">
						<td width="480" valign="top"><!--  biz_1  (S) -->
						<table class="search" border="0">
							<tr>
								<td width="240">
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Booking Data ALPS</td>
									</tr>
									<tr>
										<td class="height_5"></td>
									</tr>
								</table>
								</td>
								<td width="240" align="right">
								<table width="150" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						<table class="search_ssm" border="0" style="width: 480;">
							<tr class="h23">
								<td>
								<table class="search" border="0">
									<tr class="h23">
										<td width="73">Seq.
											<select name="alps_seq" style="width: 40;" onChange="javascript:change_seq('sheet1', this)" onClick="javascript:click_seq(this)">
											&nbsp;
											</select>
										</td>
										<td width="30" class="stm">of <span id="alps_seq_tot"></span></td>
										<td width="80">Booking No.</td>
										<td width=""><input type="text" name="bkg_no" style="width: 105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="100">Request No.</td>
										<td><input type="text" name="xter_si_no1" dataformat="engup" style="width: 120;" class="input" value=""></td>
									</tr>
									<tr class="h23">
										<td>House B/L No.</td>
										<td><input type="text" name="hbl_no" dataformat="engup" style="width: 120;" class="input" value=""></td>
									</tr>
									<tr class="h23">
										<td rowspan="2" valign="top">Actual Shipper</td>
										<td align="right"><textarea type="text" name="shpr_nm" dataformat="engup" style="width: 367;" class="input" rows="2" value=""></textarea></td>
									</tr>
									<tr class="h23">
										<td align="right"><textarea type="text" name="shpr_addr" dataformat="engup" style="width: 367;" class="input" rows="2" value=""></textarea></td>
									</tr>
									<tr class="h23">
										<td rowspan="2" valign="top">Actual<br>Consignee</td>
										<td align="right"><textarea type="text" name="cnee_nm" dataformat="engup" style="width: 367;" class="input" rows="2" value=""></textarea></td>
									</tr>
									<tr class="h23">
										<td align="right"><textarea type="text" name="cnee_addr" dataformat="engup" style="width: 367;" class="input" rows="2" value=""></textarea></td>
									</tr>
									<tr class="h23">
										<td rowspan="2" valign="top">Actual Notify</td>
										<td align="right"><textarea type="text" name="noti_nm" dataformat="engup" style="width: 367;" class="input" rows="2" value=""></textarea></td>
									</tr>
									<tr class="h23">
										<td align="right"><textarea type="text" name="noti_addr" dataformat="engup" style="width: 367;" class="input" rows="2" value=""></textarea></td>
									</tr>
									<tr class="h23">
										<td>Weight</td>
										<td>
											<input type="text" name="hbl_wgt" dataformat="float" pointcount="3" caption="Weight" style="width: 100; text-align: right;" class="input" value="">
											<!-- <input type="text" name="wgt_ut_cd" style="width: 60; text-align: center;" class="input" value=""> -->
											<script language="javascript">ComComboObject('wgt_ut_cd', 1, 55, 1, 0, 1)</script>
											</td>
									</tr>
									<tr class="h23">
										<td>Package</td>
										<td>
											<input type="text" name="pck_qty" dataformat="int" caption="Package" style="width: 100; text-align: right;" class="input" value="">
											<input type="text" align="right" dataformat="engup" name="pck_tp_cd" style="width: 32; text-align: right;" class="input" value="">
											<img src="img/btns_search.gif" name="btn_package" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>
									</tr>
									<tr class="h23">
										<td>Measure</td>
										<td>
											<input type="text" name="cmdt_meas_qty" dataformat="float" pointcount="3" caption="Measure" style="width: 100; text-align: right;" class="input" value="">
											<!-- <input type="text" name="cmdt_meas_ut_cd" style="width: 60; text-align: center;" class="input" value=""> -->
											<script language="javascript">ComComboObject('cmdt_meas_ut_cd', 1, 55, 1, 0, 1)</script>
										</td>
									</tr>
									<tr class="h23">
										<td valign="top">Mark & NOS</td>
										<td align="right"><textarea dataformat="engup" cols="69" rows="3" name="bl_mk_desc"></textarea></td>
									</tr>
									<tr class="h23">
										<td valign="top">Description</td>
										<td align="right"><textarea dataformat="engup" cols="69" rows="3" name="bl_gds_desc"></textarea></td>
									</tr>
								</table>


								</td>
							</tr>
						</table>
						<!--  biz_1  (E) --></td>
						<td width="12">&nbsp;</td>
						<td width="479" valign="top"><!--  biz_2  (S) -->
						<table class="search" border="0">
							<tr>
								<td width="240">
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">From e- Service</td>
									</tr>
									<tr>
										<td class="height_5"></td>
									</tr>
								</table>
								</td>
								<td width="240" align="right">
								<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_datacopytoalps">Data&nbsp;Copy&nbsp;to&nbsp;ALPS</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						<table class="search_ssm1" border="0" style="width: 479;"
							height="100%">
							<tr class="h23">
								<td valign="top">
								<table class="search" border="0">
									<tr class="h23">
										<td width="73">Seq. 
											<select name="xter_seq" style="width: 40;" onChange="javascript:change_seq('sheet2', this)">
											&nbsp;
											</select>
										</td>
										<td width="390" class="stm">of <span id="xter_seq_tot"></span></td>
									</tr>
								</table>
								<table class="search" border="0">
									<tr class="h23">
										<td width="100">Request No.</td>
										<td><input type="text" name="xter_si_no2" style="width: 120;" class="input2" value="" readOnly></td>
									</tr>
									<tr class="h23">
										<td>House B/L No.</td>
										<td><input type="text" name="hbl_no2" style="width: 120;" class="input2" value="" readOnly></td>
									</tr>
									<tr class="h23">
										<td rowspan="2" valign="top">Actual Shipper</td>
										<td align="right"><textarea type="text" name="shpr_nm2" style="width: 367;" rows="2" class="textarea2" value="" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td align="right"><textarea type="text" name="shpr_addr2" style="width: 367;" rows="2" class="textarea2" value="" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td rowspan="2" valign="top">Actual<br>Consignee</td>
										<td align="right"><textarea type="text" name="cnee_nm2" style="width: 367;" rows="2" class="textarea2" value="" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td align="right"><textarea type="text" name="cnee_addr2" style="width: 367;" rows="2" class="textarea2" value="" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td rowspan="2" valign="top">Actual Notify</td>
										<td align="right"><textarea type="text" name="noti_nm2" style="width: 367;" rows="2" class="textarea2" value="" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td align="right"><textarea type="text" name="noti_addr2" style="width: 367;" rows="2" class="textarea2" value="" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td>Weight</td>
										<td>
											<input type="text" name="hbl_wgt2" style="width: 100; text-align: right;" class="input2" value="" readOnly>
											&nbsp;
											<input type="text" name="wgt_ut_cd2" style="width: 55; text-align: right;" class="input2" value="" readOnly>
										</td>
									</tr>
									<tr class="h23">
										<td>Package</td>
										<td>
											<input type="text" name="pck_qty2" style="width: 100; text-align: right;" class="input2" value="" readOnly>
											&nbsp;
											<input type="text" name="pck_tp_cd2" style="width: 55; text-align: right;" class="input2" value="" readOnly>											
										</td>
									</tr>
									<tr class="h23">
										<td>Measure</td>
										<td>
											<input type="text" name="cmdt_meas_qty2" style="width: 100; text-align: right;" class="input2" value="" readOnly>
											&nbsp;
											<input type="text" name="cmdt_meas_ut_cd2" style="width: 55; text-align: right;" class="input2" value="" readOnly></td>
									</tr>
									<tr class="h23">
										<td valign="top">Mark & NOS</td>
										<td align="right"><textarea cols="69" rows="3" class="textarea2" name="bl_mk_desc2" readOnly></textarea></td>
									</tr>
									<tr class="h23">
										<td valign="top">Description</td>
										<td align="right"><textarea cols="69" rows="3" class="textarea2" name="bl_gds_desc2" readOnly></textarea></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						<!--  biz_2  (E) -->
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (S) -->
		<!-- <table width="980" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_upload">Upload</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>  -->
		</td>
	</tr>
</table>
<!--Button (E) --> <!-- Grid BG Box  (S) -->

<table width="100%" id="mainTable">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>
<!--biz page (E)-->
</form>
</body>
</html>