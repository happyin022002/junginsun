<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0749.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event.EsmBkg0748Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String sVvd = (request.getParameter("vvd")==null) ? "" : request.getParameter("vvd");
	String sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
	String sTypeRail = (request.getParameter("type_rail")==null) ? "" : request.getParameter("type_rail");
	// Inbound / Outbound 메뉴가 다르기 때문
	String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
	if ("".equals(sBound)) {
		if (sPgmNo.length() == 12) {
			sBound = "I";
		} else {
			sBound = "O";
		}
	}
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String strUsr_nm = account.getUsr_nm();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var strUsr_nm    = "<%=strUsr_nm%>";
	function setupPage(){
		<%if (!"".equals(sVvd)) { %>
			loadPage(true);
		<% } else { %>
			loadPage(false);
		<% } %>
	}
</script>
</head>
<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="US Wharfage Send (LGB) Preveiw">
<input type="hidden" name="com_mrdBodyTitle" value="US Wharfage Send (LGB) Preveiw">
<input type="hidden" name="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdPrintPaperSize" value="4">

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> 

<table class="search">
	<tr>
		<td class="bg"><!--  biz_1  (S) -->
		<table class="search" border="0" style="width: 979;">
			<tr class="h23">
				<td width="30">VVD</td>
				<td width="150"><input type="text" style="width:100;ime-mode:disabled" class="input1" required
					name="vvd" caption="VVD" maxlength="9" dataformat="eng" minlength="9" value="<%=sVvd%>"></td>
				<td width="33">Port</td>
				<td width="150"><input type="text" style="width:100;" class="input2" name="port" value="USLGB" readOnly></td>
				<td width="160">Bound
					<select style="width:100;" class="input1" name="bound">
					<option value="I" <%if("I".equals(sBound)) out.println("selected");%>>IMPORT</option>
					<option value="O" <%if("O".equals(sBound)) out.println("selected");%>>EXPORT</option>
					</select></td>
				<td width="" align="right">
					<input type="checkbox" value="R" class="trans" name="type_rail"
					<%if("R".equals(sTypeRail)) out.println("checked");%>>&nbsp;Type : Rail Include</td>
			</tr>
		</table>

		<table class="line_bluedot">
			<tr>
				<td></td>
			</tr>
		</table>
		<table width="100%" class="grid2">
			<tr class="tr2_head">
				<td width="10%">Vessel</td>
				<td width="10%">Voy #</td>
				<td width="10%">Departure</td>
				<td width="10%">Arrival</td>
				<td width="10%">Ship Line</td>
				<td width="10%">Bill To</td>
				<td width="10%">Pier/Berth</td>
				<td width="10%">Last Update</td>
			</tr>

			<tr>
				<td align="center">
					<input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_vsl_nm" dataformat="etc" maxlength="50" caption="Vessel"></td>
				<td align="center">
					<input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_vsl_voy_dir_no" dataformat="etc" maxlength="10" caption="Voy #"></td>
				<td align="center">
					<input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_dep_dt" dataformat="ymd" maxlength="10" caption="Departure"></td>
				<td align="center">
					<input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_arr_dt" dataformat="ymd" maxlength="10" caption="Arrival"></td>
				<td align="center">
					<input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_bil_snd_pty_nm" dataformat="etc" maxlength="100" caption="Ship Line"></td>					
					<!-- <script language="javascript">ComComboObject('frm_bil_snd_pty_nm', 1, 80);</script> -->
				<td align="center">
					<!-- <input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_bil_rcv_pty_nm" dataformat="etc" maxlength="100" caption="Bill To"></td> -->
					 <script language="javascript">ComComboObject('frm_bil_rcv_pty_nm', 1, 80);</script>				
				<td align="center">
					<!--  <input type="text" class="noinput" style="text-align:center;ime-mode:disabled"
					 name="frm_brth_desc" dataformat="etc" maxlength="100" caption="Pier/Berth"></td> -->
					 <script language="javascript">ComComboObject('frm_brth_desc', 1, 90);</script>				
				<td align="center" bgcolor="#ffffff">
					<input type="text" class="noinput" style="text-align:center;width:80"
					 name="frm_locl_upd_dt" ReadOnly></td>
			</tr>
		</table>

		<!--  biz_1   (E) -->

		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->

		<table class="search" border="0" width="100%" >
			<tr class="h23">
				<td width="49%" valign="top"><!--Grid (s)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table border="0" style="width: 100%; background-color:" class="grid">
					<tr>
						<td width="78" class="tr_head">MTS</td>
						<td width="160" class="noinput2">
							<input type="text" class="noinput2" style="width:100%;text-align:right" ReadOnly name="frm_mts"></td>
						<td width="78" class="tr_head" >TEU</td>
						<td class="noinput2">
							<input type="text" class="noinput2" style="width:100%;text-align:right" ReadOnly name="frm_teu"></td>
					</TR>
				</table>
				</td>
				<!--Grid (E)-->
				<td width="1%">&nbsp;</td>
				<td width="50%" valign="top"><!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>

		<table class="height_8"><tr><td></td></tr></table>

		<table class="search" border="0" width="100%" >
			<tr class="h23">
				<td width="49%" valign="top">

					<table border="0" style="width: 100%; background-color:" class="grid2">
						<tr>
							<td width="" class="tr2_head">Note</td>
						</tr>
						<tr>
							<td style="height:47px"><textarea style="width:100%;ime-mode:disabled" rows="2" name="frm_snd_rmk" dataformat="etc" ></textarea></td>
						</tr>
					</table>

				</td>
				<td width="1%">&nbsp;</td>
				<td width="50%" valign="top">

					<table border="0" style="width: 100%; background-color: white;"	class="grid2">
						<tr>
							<td width="50%" class="tr2_head">Wharfage Charge</td>
							<td class="input2" align="right">
								<input type="text" class="noinput2" style="text-align:right;ime-mode:disabled;width:100%"
						 			name="frm_sum_amt" readOnly></td>
						</tr>
						<tr>
							<td width="" class="tr2_head">Deduction</td>
							<td align="right">
								<input type="text" class="noinput" style="text-align:right;ime-mode:disabled;width:100%"
						 			name="frm_ddct_amt" dataformat="float" maxlength="10"></td>
						</tr>
						<tr>
							<td width="" class="tr2_head">Total Charge</td>
							<td class="input2" align="right">
								<input type="text" class="noinput2" style="text-align:right;ime-mode:disabled;width:100%"
						 			name="frm_tot_amt" readOnly></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<table class="height_8"><tr><td></td></tr></table>

		<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_RowAddHis">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
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
<script language="javascript">ComSheetObject('sheet5');</script>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Exception">Exception</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Rate">Rate</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Berth">Berth</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_WhfSetup">WhfSetup</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Preview">Preview</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Send">Send</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_SendWith">Send with Excpt & T/S B/Ls</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
		</td>
	</tr>
</table>

<%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_BOTTOM.jsp" %> 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>