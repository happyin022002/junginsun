<%
/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : ESM_BKG_1502.jsp
*@FileTitle : B/L Inquiry(Japan 24HR)
*Open Issues :
*Change history :
	2014.07.30 Hannah Lee [CHM-201431024] JAFR NACCS AMR 데이터중 Origin Port 변경시 처리를 위한 화면 개선 요청
	2017.08.08 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.08.08
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2013.07.05 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1502Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1502Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //서버에서 발생한 에러
	String strErrMsg = "";               //에러메세지
	int rowCount = 0;                    //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String blNo = "";
	String tCmrKind = "";
	String polSplitNo = "";
	String podSplitNo = "";
	String popMode = "";

	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1502Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		blNo = JSPUtil.getParameter(request, "bl_no");
		tCmrKind = JSPUtil.getParameter(request, "t_cmr_kind");
		polSplitNo = JSPUtil.getParameter(request, "pol_split_no");
		podSplitNo = JSPUtil.getParameter(request, "pod_split_no");
		// popup으로 호출하는지를 구분하는 flag
		popMode = JSPUtil.getParameter(request, "pop_mode");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry(Japan 24HR)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var tCmrKind = "<%=tCmrKind%>";
	var polSplitNo = "<%=polSplitNo%>";
	var podSplitNo = "<%=podSplitNo%>";

	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>


<!-- 개발자 작업 -->
<% if ("Y".equals(popMode)) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup"  border="0" cellpadding="0">
  <tr><td class="top"></td></tr>

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px;">
<% } %>


	<tr>
		<td valign="top">


			<!-- Page Title, Historical (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- Page Title, Historical (E) -->


<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type="hidden" name="onchange_flag">
<input type="hidden" name="pod_cd">
<input type="hidden" name="org_bl_no">
<input type="hidden" name="pod_div">
<input type="hidden" name="rvis_cntr_cust_tp_cd">
<input type="hidden" name="del_trasmit_flag">


			<!-- biz page (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td colspan="10">
										<table border="0">
											<tr class="h23">
												<td width="60">B/L No.</td>
												<td><input type="text" name="bl_no" <% if ("Y".equals(popMode)) { %>value="<%=blNo%>" class="input2" style="width:120;" readOnly<% } else { %>class="input1" dataformat="eng" maxlength="12" required caption="B/L No." style="width:120; ime-mode:disabled;"<% } %>></td>
												<td style="padding-left:19px;">T/Status&nbsp;
													<select name="t_cmr_kind" id="t_status" onchange="frmObj_OnChange"<% if ("Y".equals(popMode)) { %> class="input2" disabled<% } else { %> class="input" caption="T/Status"<% } %> style="width:90">
														<option value="" selected></option>
														<option value="9">AMR(Reg)</option>
														<option value="2">CMR(Add)</option>
														<option value="5">CMR(Cor)</option>
														<option value="1">CMR(Del)</option>
													</select></td>
				 								<td id="del" style="display:none; padding-left:19px">Deletion Code&nbsp;
													<select id="del_cd" name="del_cd" caption="Deletion Code" onchange="frmObj_OnChange">
														<option value="" selected></option>
														<option value="1">1.Cancellation of loading</option>
														<option value="3">3.Change of B/L number</option>
														<option value="4">4.Misregistration</option>
														<option value="5">5.Other reasom</option>
													</select> 
												</td>
												<td id="del_reason" style="display: none;padding-left:10px">
															Reason for Deletion<textarea name="del_reason" id="del_text" caption="Reason for Deletion" style="ime-mode:disabled;" rows="1" cols='35' dataformat="etc" maxlength="200"></textarea>
												</td>
											</tr>												
									</table>
								</td>
							</tr>												
					</table>

					<table class="search" border="0" style="width:979;">
							<tr>
								<td colspan="10"><table class="line_bluedot"><tr><td></td></tr></table></td>
							</tr>
							<tr class="h23">
								<td>VVD</td>
								<td colspan="2"><input type="text" name="vvd" style="width:120;" class="input2" readOnly></td>
								<td colspan="3">Vessel Name&nbsp;
									<input type="text" name="vsl_eng_nm" style="width:180;" class="input2" readOnly></td>
								<td align="right">Filer Type&nbsp;</td>
								<td><select name="mst_bl" class="input" style="width:70">
										<option value="B" selected>Simple</option>
										<option value="N">Console</option>
									</select></td>
								<td align="right" style="visibility:hidden;">CMDT CD&nbsp;</td>
								<td style="visibility:hidden;"><input type="text" name="cmdt_cd" style="width:60;" class="input" maxlength="6" dataformat="engupnum"></td>
							</tr>
							<tr class="h23">
								<td width="80">V/POL&nbsp;</td>
								<td width="112"><input type="text" name="pol_cd" style="width:60;" class="input" maxlength="5" dataformat="engup">
									<select name="pol_split_no"<% if ("Y".equals(popMode)) { %> class="input2" disabled<% } else { %> class="input"<% } %> style="width:35px;">
										<option value="" selected></option>
<% for (int k=1; k<10; k++) { %>
										<option value="<%=k%>"><%=k%></option>
<% } %>
									</select></td>
								<td width="80" align="right">POD&nbsp;</td>
								<td width="112"><input type="text" style="width:20px; ime-mode:disabled; text-align:center; border-right-style:none;" class="input2" name="pod_prefix" maxlength="2" value="JP"><input type="text" style="width:40px; ime-mode:disabled; border-left-style:none;" class="input" name="pod_postfix" maxlength="3" dataformat="engup">
									<select name="pod_split_no"<% if ("Y".equals(popMode)) { %> class="input2" disabled<% } else { %> class="input"<% } %> style="width:35px;">
										<option value="" selected></option>
<% for (int k=1; k<10; k++) { %>
										<option value="<%=k%>"><%=k%></option>
<% } %>
									</select></td>
								<td width="80" align="right">DEL&nbsp;</td>
								<td width="100"><input type="text" name="bkg_del_cd" style="width:60;" class="input" maxlength="5" dataformat="engup"></td>
								<td width="80" align="right">R/D Term&nbsp;</td>
								<td colspan="3"><input type="text" name="rcv_term_cd" style="width:23;" class="input" dataformat="engup"> /
									<input type="text" name="de_term_cd" style="width:23;" class="input" dataformat="engup"></td>
							</tr>
							<tr class="h23">
								<td>Package</td>
								<td><input type="text" name="pck_qty" style="width:60; text-align:right;" class="input" dataformat="float" maxlength="15">
									<input type="text" name="pck_tp_cd" style="width:35;" class="input"></td>
								<td align="right">Weight&nbsp;</td>
								<td><input type="text" name="grs_wgt" style="width:60; text-align:right;" class="input" dataformat="float" maxlength="23">
									<select name="wgt_ut_cd" class="input" style="width:50">
										<option value="KGS" selected>KGS</option>
										<option value="LBS">LBS</option>
									</select></td>
								<td align="right">Measure&nbsp;</td>
								<td><input type="text" name="meas_qty" style="width:60; text-align:right;" class="input" dataformat="float" maxlength="15">
									<select name="meas_ut_cd" class="input" style="width:50">
										<option value="CBM" selected>CBM</option>
										<option value="CBF">CBF</option>
									</select></td>
								<td align="right">IMDG&nbsp;</td>
								<td><input type="text" name="imdg_clss_cd" style="width:60;" class="input" maxlength="3" dataformat="engupnum"></td>
								<td align="right">UN No.&nbsp;</td>
								<td><input type="text" name="imdg_un_no" style="width:60;" class="input" maxlength="4" dataformat="engupnum"></td>
							</tr>

						</table>
					</td>
				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>

			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject("tab1")</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->


			<!-- biz_2 (S) -->
			<!-- Tab_Layer_1 (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search">
					<tr>
						<td class="bg">
							<table class="search" border="0">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Customer Information</td>
								</tr>
								<tr>
									<td class="height_5"></td>
								</tr>
							</table>
							<table  border="0" cellpadding="0" cellspacing="0" style="width:650;">
								<tr class="h23">
									<td width="75">Shipper</td>
									<td><input type="text" style="width:40; ime-mode:disabled;" dataformat="engup" name="shpr_cnt_cd" caption="Shipper Country Code" maxlength="2"></td>
									<td style="visibility:hidden;">
										<input type="text" dataformat="int" style="width:100; ime-mode:disabled; text-align:right" name="shpr_seq" maxlength="6">
										<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" name="btn_shpr" align="absmiddle"></td>
									<td align="right" style="visibility:hidden;">Tel.&nbsp;
										<input type="text" style="width:100; ime-mode:disabled;" dataformat="dashfloat" maxlength="20" name=""></td>
									<td align="right" style="visibility:hidden;">Fax&nbsp;
										<input type="text" style="width:180; ime-mode:disabled;" dataformat="dashfloat" maxlength="20" name="shpr_fax_no"></td>
								</tr>
							</table>
							<table class="grid2" border="0" style="width:985;">
								<tr class="tr2_head">
									<td width="70">Name</td>
									<td width="320"><textarea style="width:100%; ime-mode:disabled;" rows="3" dataformat="etc" maxlength="500" name="shpr_nm" caption="Shipper Name"></textarea></td>
									<td width="70">Address</td>
									<td width="330"><textarea style="width:100%; ime-mode:disabled;" rows="3" dataformat="etc" maxlength="500" name="shpr_addr" caption="Shipper Address"></textarea></td>
									<td width="70">Tel</td>
									<td width="110"><input type="text" style="width:100%; ime-mode:disabled;" dataformat="commafloat" maxlength="14" name="shpr_phn_no" caption="Shipper Tel"></td>
								</tr>
							</table>
							<table class="height_8"><tr><td></td></tr></table>
							<table  border="0" cellpadding="0" cellspacing="0" style="width:650;">
								<tr class="h23">
									<td width="75">Consignee</td>
									<td><input type="text" style="width:40; ime-mode:disabled;" dataformat="engup" name="cnee_cnt_cd" caption="Consignee Country Code" maxlength="2"></td>
									<td style="visibility:hidden;">
										<input type="text" dataformat="int" style="width:100; ime-mode:disabled; text-align:right" name="cnee_seq" maxlength="6">
										<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" name="btn_cnee" align="absmiddle"></td>
									<td align="right" style="visibility:hidden;">Tel.&nbsp;
										<input type="text" style="width:100; ime-mode:disabled;" dataformat="dashfloat" maxlength="20" name=""></td>
									<td align="right" style="visibility:hidden;">Fax&nbsp;
										<input type="text" style="width:172; ime-mode:disabled;" dataformat="dashfloat" maxlength="20" name="cnee_fax_no"></td>
								</tr>
							</table>
							<table class="grid2" border="0" style="width:985;">
								<tr class="tr2_head">
									<td width="70">Name</td>
									<td width="320"><textarea style="width:100%; ime-mode:disabled;" rows="3" dataformat="etc" maxlength="500" name="cnee_nm" caption="Consignee Name"></textarea></td>
									<td width="70">Address</td>
									<td width="330"><textarea style="width:100%; ime-mode:disabled;" rows="3" dataformat="etc" maxlength="500" name="cnee_addr" caption="Consignee Address"></textarea></td>
									<td width="70">Tel</td>
									<td width="110"><input type="text" style="width:100%; ime-mode:disabled;" dataformat="commafloat" maxlength="14" name="cnee_phn_no" caption="Consignee Tel"></td>
									
								</tr>
							</table>
							<table class="height_8"><tr><td></td></tr></table>
							<table  border="0" cellpadding="0" cellspacing="0" style="width:650;">
								<tr class="h23">
									<td width="75">&nbsp;&nbsp;Notify</td>
									<td><input type="text" style="width:40; ime-mode:disabled;" dataformat="engup" name="ntfy_cnt_cd" caption="Notify Country Code" maxlength="2"></td>
									<td style="visibility:hidden;">
										<input type="text" dataformat="int" style="width:100; text-align:right; ime-mode:disabled;" name="ntfy_seq" maxlength="6">
										<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" name="btn_ntfy" align="absmiddle"></td>
									<td align="right" style="visibility:hidden;">Tel.&nbsp;
										<input type="text" style="width:100; ime-mode:disabled;" dataformat="dashfloat" maxlength="20" name=""></td>
									<td align="right" style="visibility:hidden;">Fax&nbsp;
										<input type="text" style="width:172; ime-mode:disabled;" dataformat="dashfloat" maxlength="20" name="ntfy_fax_no"></td>
								</tr>
							</table>
							<table class="grid2" border="0" style="width:985;">
								<tr class="tr2_head">
									<td width="70">Name</td>
									<td width="320"><textarea style="width:100%; ime-mode:disabled;" rows="3" dataformat="etc" maxlength="500" name="ntfy_nm" caption="Notify Name"></textarea></td>
									<td width="70">Address</td>
									<td width="330"><textarea style="width:100%; ime-mode:disabled;" rows="3" dataformat="etc" maxlength="500" name="ntfy_addr" caption="Notify Address"></textarea></td>
									<td width="70">Tel</td>
									<td width="110"><input type="text" style="width:100%; ime-mode:disabled;" dataformat="commafloat" maxlength="14" name="ntfy_phn_no" caption="Notify Tel"></td>
								</tr>
							</table>
					</td></tr>
				</table>
			</div>
			<!-- Tab_Layer_1 (E) -->


			<!-- Tab_Layer_2 (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg" valign="top">
							<!-- Tab_2_Grid (S) -->
							<table width="100%" id="tab2MainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject("tab2sheet1");</script></td>
								</tr>
							</table>
							<!-- Tab_2_Grid (S) -->
							<!-- Tab_2_button (S) -->
							<table width="100%" class="button">
								<tr>
									<td class="btn2_bg">
										<table  border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="tab2btn_rowadd">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="tab2btn_delete">Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!-- Tab_2_button (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- Tab_Layer_2 (E) -->


			<!-- Tab_Layer_3 (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg">
							<table class="search" border="0">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Mark & Description</td></tr>
								<tr>
									<td class="height_5"></td>
								</tr>
							</table>
							<table class="search" border="0" style="width:979;">
								<tr class="h23">
								<td>HS CD&nbsp;
									<input type="text" style="width:100;" name="cmdt_hs_cd" dataformat="engupnum" maxlength="10"></td>
									<td>L/TS using CD&nbsp;
										<select name="jp_cstms_trns_cd" class="input" style="width:60;">
											<option value="" selected></option>
											<option value="TRS">TRS</option>
											<option value="TRT">TRT</option>
											<option value="REV">REV</option>
											<option value="POS">POS</option>
										</select></td>
									<td>L/TS using Period&nbsp;
										<input type="text" style="width:72" dataformat="num3" maxlength="15" name="lmt_no"></td>
									<td style="visibility:hidden;">CY Operator CD&nbsp;
										<input type="text" style="width:96" dataformat="engupnum" maxlength="5" name="cy_opr_id"></td>
								</tr>
							</table>
							<table class="height_5"><tr><td></td></tr></table>
							<table class="search" border="0" style="width:979;">
								<tr>
									<td width="477">
										<table class="grid2" width="100%">
											<tr class="tr2_head">
												<td>Marks & No.</td>
											</tr>
											<tr>
												<td><textarea style="width:100%;" rows="11" name="diff_rmk" dataformat="etc"></textarea></td>
											</tr>
										</table>
									</td>
									<td width="25"></td>
									<td width="477">
										<table class="grid2" width="100%">
											<tr class="tr2_head">
												<td>Description</td>
											</tr>
											<tr>
												<td><textarea style="width:100%;" rows="11" name="bl_desc" dataformat="etc"></textarea></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!-- Tab_3_Grid (Hidden) (S) -->
							<table width="100%" id="tab3MainTable">
							<tr>
							<td width="100%"><script language="javascript">ComSheetObject("tab3sheet1");</script></td>
							</tr>
							</table>
							<!-- Tab_3_Grid (Hidden) (S) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- Tab_Layer_3 (E) -->
			<!-- biz_2 (E) -->
			<!-- biz page (E) -->

			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
<% if ("".equals(popMode)) { %>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
<% } %>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_save">Save</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
<% if ("".equals(popMode)) { %>
<!-- 								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_transmit">Transmit</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td> -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new_transmit">Transmit</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
<% } %>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- Button (E) -->


		</td>
	</tr>
</table>


<% if ("Y".equals(popMode)) { %>

<!-- Button : POP (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="72">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Button : POP (E) -->

<% } %>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
