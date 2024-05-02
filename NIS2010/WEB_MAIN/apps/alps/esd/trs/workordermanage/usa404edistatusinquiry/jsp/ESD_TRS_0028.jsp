<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0028.jsp
*@FileTitle : USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-28 kim_sang_geun
* 1.0 최초 생성
* N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
2013.04.03 조인영 [CHM-201323907] USA Rail 404 EDI 권한 추가 요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event"%>
<%
	SignOnUserAccount account = null;
	EsdTrs0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, -14);

	String selStatus = ""; //SO STATUS CODE
	String selEdiKind = ""; //Edi Kind
	String selFullEmpty = ""; //Full/Empty
	String selBnd = ""; //BND
	String selLimInq = ""; //Limit Inquery
	String selThrough = ""; //Through
	String selRailRoad = ""; //Rail Road
	String userId  = ""; //USER ID

	String s_bkg_no = request.getParameter("s_bkg_no")==null?"":request.getParameter("s_bkg_no");
	String s_cntr_no = request.getParameter("s_cntr_no")==null?"":request.getParameter("s_cntr_no");

	String optionStr = "000020:ALL:ALL";
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		selStatus = JSPUtil.getCodeCombo("sel_status", "01", "style=width:90", "CD00908", 0, optionStr);
		selEdiKind = JSPUtil.getCodeCombo("sel_edi_kind", "01", "style=width:132", "CD00868", 0, optionStr);
		selFullEmpty = JSPUtil.getCodeCombo("sel_full_empty", "01", "style=width:138", "CD00136", 0, optionStr);
		selBnd = JSPUtil.getCodeCombo("sel_bnd", "01", "style=width:56", "CD00592", 0, optionStr);
		selLimInq = JSPUtil.getCodeCombo("sel_Limit_inq", "01", "style=width:173", "CD00922", 0, optionStr);
		selThrough = JSPUtil.getCodeCombo("rad_through", "01", "style=width:79 onChange= 'onChange_through(this);'", "CD00934", 0, optionStr);
		selRailRoad = JSPUtil.getCodeCombo("sel_railroad", "01", "style=width:474 ", "CD00930", 0, optionStr);
		
		event = (EsdTrs0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>USA 404 EDI Status Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var s_bkg_no = '<%=s_bkg_no.toString()%>';
	var s_cntr_no = '<%=s_cntr_no.toString()%>';
</script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
<%--
/*
 * * N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
 */
--%>
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("auto_xpt_sys_cd", "01", "CD00850", 0, "")%>
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="hid_rad_date">
<input type="hidden" name="hid_rad_vendor">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



        <div id="MiniLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<table class="search_in" border="0">
						<tr class="h23">

							<td width="74">Date</td>
							<td class="stm" width="689">

								<table border="0" style="height:15; width:502;background-color: #E9E9E9;">
								<tr><td width="301" class="sm" style="padding-left:10;">
										<input type="radio" class="trans" name="rad_date" value="DS" checked>Service Order Create
										<input type="radio" class="trans" name="rad_date" value="DB">EDI Send
										<input type="radio" class="trans" name="rad_date" value="DC">Cancel Request</td>
									<td class="sm"><input name="frm_plandate" type="text" class="input1" style="width:75" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);  getDateBetween(this);">&nbsp;~&nbsp;<input name="to_plandate" type="text" class="input1" style="width:75" value="<%=today%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
								</tr>
								</table>

							</td>
							<td><input type="checkbox" name="edi_history" value="H" class="trans">&nbsp;Incl. Historical Data</td>

						</tr>
					</table>
					<table height="2"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">

							<td width="72">Status</td>
							<td width="150"><%=selStatus%></td>
							<td width="100">Full / Empty</td>
							<td width="164"><%=selFullEmpty%></td>
							<td width="50">Bound</td>
							<td width="90"><%=selBnd%> </td>
							<td width="60">Through</td>
							<td width="103"><%=selThrough%></td>
							<td width="116">Booking Attached</td>
							<td><select name="sel_Bkgatch" style="width:51;">
									<option value="ALL" selected>ALL</option>
									<option value="Y">Y</option>
									<option value="N">N</option>
								</select></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">

							<td width="72">Rail Origin</td>
							<td width="47"><input name="frm_node" type="text" style="width:43;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
							<td width="103"><script language="javascript">ComComboObject('frm_yard', 1, 66, 0)</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
							<td width="100">Rail Destination</td>
							<td width="49"><input name="to_node" type="text" style="width:45;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
							<td width="115"><script language="javascript">ComComboObject('to_yard', 1, 70, 0)</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tonode"></td>
							<td width="106">Limit of Inquiry</td>
							<td><%=selLimInq%></td>

						</tr>
					</table>


					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="72">EDI Kind</td>
							<td width="150"><%=selEdiKind%> </td>
							<td width="102">Service Provider</td>
							<td>

								<table border="0" style="height:15; width:100%; background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" width="148" style="padding-left:10;">
                                			<input type="radio" class="trans" name="rad_vendor" value="V1" checked onClick="javascript:do_railroad('W');">Rail Road&nbsp;&nbsp;&nbsp;
											<input type="radio" class="trans" name="rad_vendor" value="V2" onClick="javascript:do_railroad('R');">WRS</td>

			                             <td>
											<div id="SV" style="display:none">
												<table class="search" border="0">
													<tr><td width="200"><input name="combo_svc_provider" type="text" style="width:108;" value="" maxlength="6" onBlur="vender_blur();"></td>
													<td><input type="text" name="trsp_so_vndr_no" style="width:364;" readonly value="" class="input2"><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vender"></td></tr>
												</table>
											</div>
											<div id="SV" style="display:inline">
												<table class="search" border="0" >
													<tr><td"><%=selRailRoad%></td></tr>
												</table>
											</div>

									    </td>
									</tr>
                               	</table>

                            </td>
						</tr>
					</table>

					<table height="2"><tr><td></td></tr></table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="72">T.VVD</td>
							<td width="151"><input name="trunk_vvd" type="text" style="width:90" onKeyup="javascript:doSearchEnter();"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multivvd"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_tvvd"></td>
							<td width="99">Booking No.</td>
							<td width="164"><input name="bkg_no" type="text" style="width:92;" onKeyup="javascript:doSearchEnter();"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibkg"></td>
							<td width="48">B/L No.</td>
							<td width="198"><input name="bill_no" type="text" style="width:120;" onKeyup="javascript:doSearchEnter();"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibl"></td>
							<td width="87">Container No.</td>
							<td align="right"><input name="cntr_no" type="text" style="width:133;" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
	    </div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							
							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cancelreqreject" name="btng_cancelreqreject">Cancel REQ Reject</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cancellationedisend" name="btng_cancellationedisend">Cancellation EDI Send</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_404edisend" name="btng_404edisend">404 EDI Send</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<!-- N200905150040 2009-05-20 [TRS]USA RAIL YARD --><!--정보저장화면개발-->
										<% if( "21702005".equals(userId) || "21609019".equals(userId)
												|| "2000134".equals(userId) || "1110180".equals(userId) || "0310102".equals(userId)){ %>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng" name="btng">Rail Yard EDI Info Creation&Correction</td><td class="btn2_right"></td></tr></table></td>
							<% } %>


							<%
								if( "PHXSA".equals(account.getOfc_cd()) ){
							%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_frustrate" name="btng_frustrate">Frustrate</td><td class="btn2_right"></td></tr></table></td>
							<%
								}
							%>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_confirmationmsg" name="btng_confirmationmsg">Confirmation MSG Send</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
<script language="javascript">
	document.form.combo_svc_provider.style.visibility = "hidden";
	document.form.trsp_so_vndr_no.style.visibility = "hidden";
	document.form.btns_vender.style.visibility = "hidden";
	document.form.sel_railroad.style.visibility = "visible";
</script>