<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : ESM_FMS_0095.jsp
*@FileTitle : Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.18 손진환 
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
<%@ page import="com.hanjin.apps.alps.esm.fms.ownersaccount.event.EsmFms0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0095Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cost_ofc_cd      = "";
	String inv_sub_sys_cd	= "FMS";
	String currList			= "";
	String asa_no_list		= "";
	String so_if_cd 			= "";		// O : ASA, O가 아니면 AP
	String cnt_cd 			= "";		// 국가코드 국내 오피스인 경우만 Evidence Type  TAX 선택 가능하고 국외 오스피는 TAX 선택 못하게 처리
	Logger log = Logger.getLogger("com.hanjin.apps.OwnersAccount.OwnersAccount");

	String popup	= request.getParameter("popup")==null?"no":request.getParameter("popup");
	String s_csr_no	= request.getParameter("s_csr_no")==null?"":request.getParameter("s_csr_no");
	String s_flg	= request.getParameter("s_flg")==null?"":request.getParameter("s_flg");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cost_ofc_cd = account.getOfc_cd();

		event = (EsmFms0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		currList = eventResponse.getETCData("currList");
		asa_no_list = eventResponse.getETCData("asa_no");
		so_if_cd = eventResponse.getETCData("so_if_cd");		
		cnt_cd = eventResponse.getETCData("cnt_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Owner's Account</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var currList = "<%=currList%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
	var asa_no_list = "<%=asa_no_list%>";
	var so_if_cd = "<%=so_if_cd%>";		
</script>
</head>

<%if(popup.equals("yes")) { %>
<body class="popup_bg" onLoad="setupPage();"> 
<% } else { %>
<body  onLoad="setupPage();">
<% } %>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="popup" value="<%=popup%>">
<input type="hidden" name="s_flg" value="<%=s_flg%>">
<input type="hidden" name="s_csr_no" value="<%=s_csr_no%>">
<input type="hidden" name="vndr_deleted">
<input type="hidden" name="slp_tp_cd" value="07">
<input type="hidden" name="slp_func_cd">
<input type="hidden" name="slp_ofc_cd" value="<%= cost_ofc_cd %>">
<input type="hidden" name="slp_iss_dt">
<input type="hidden" name="cre_usr_id" value="<%= strUsr_id %>">
<input type="hidden" name="usr_nm" value="<%= strUsr_nm %>">
<input type="hidden" name="total_amt">
<input type="hidden" name="cost_ofc_cd" value="<%= cost_ofc_cd %>">
<input type="hidden" name="curr_cd">
<input type="hidden" name="payment_due_dt">
<input type="hidden" name="org_slp_tp_cd">
<input type="hidden" name="org_slp_func_cd"> 
<input type="hidden" name="org_slp_ofc_cd">
<input type="hidden" name="org_slp_iss_dt">
<input type="hidden" name="org_slp_ser_no">
<input type="hidden" name="csr_type">

<input type="hidden" name="evid_tp_cd_val">
<input type="hidden" name="usd_locl_xch_rt">
<!-- asa no list -->
<input type="hidden" name="asaListFlg">
<input type="hidden" name="asa_no">
<input type="hidden" name="cnt_cd" value="<%= cnt_cd %>">
<input type="hidden" name="org_vndr_seq">
<input type="hidden" name="so_if_cd" value="<%=so_if_cd%>">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Owner's Account">
<input type="hidden"   name="com_mrdBodyTitle" value="Owner's Account"">
<!-- 개발자 작업	-->

<!--Page Title, Historical (S)-->

<%if(popup.equals("yes")) { %>
	<table width="100%" class="popup" border="0" cellpadding="0">
		<tr>
			<td class="top"></td>
		</tr>
		<tr>
			<td valign="top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr>
						<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Owner's Account Entry</span></td>
					</tr>
				</table>
<% } else { %>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
		<tr>
			<td valign="top">
				<!--Page Title, Historical (S)-->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr>
						<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
					</tr>
					<tr>
						<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
					</tr>
				</table>
<% } %>
	</table>
	
<!--Page Title, Historical (E)--> 
				
				<!--biz page (S)-->
				<table class="search">
					<tr>
						<td class="bg">
							<!--  biz_1  (S) -->

							<table class="search" border="0" style="width: 979;">
								<tr class="h23">

									<td width="90">Office Code</td>
									<td width="90">
										<input type="text" value="<%= cost_ofc_cd %>" style="width: 70; text-align: center;" class="input2" name="ofc_cd" caption="Office Code" style="ime-mode:disabled" readonly>&nbsp;
									</td>
									<td width="70">Supplier</td>
									<td width="271">
										<input type="text" style="width: 70; text-align: center;" name="vndr_seq" required caption="Supplier" class="input1">&nbsp;
										<img src="img/btns_search.gif" name="btn_vndr_pop" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">
										<input type="text" style="width: 150; text-align: center;" class="input2" value="" name="vndr_name" readonly>
									</td>
									<td width="70">CSR No.</td>
									<td><input type="text" style="width: 150; text-align: center;" class="input2" value="" name="csr_no" readonly></td>
								</tr>
							</table>
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="70">Amount</td>
									<td width="60">
										<script language="javascript">ComComboObject('csr_curr_cd', 1, 60, 1)</script>
									</td>
									<td width="90">
										<!--  input type="text" name="curr_cd" value="" style="width: 60; text-align: center;" class="input1" -->
										<input type="text" name="csr_amt" required caption="Amount" style="width: 90; text-align: center;" class="input1" dataformat="float">
									</td>
									<td width="80">Invoice Date</td>
									<td width="100">
										<input type="text" name="oa_inv_dt" required caption="Invoice Date" style="width: 74; text-align: center;" class="input1" dataformat="ymd">
										<img class="cursor" name="oa_inv_dt_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
									</td>	
									<td width="70">G/L Date</td>
									<td width="100">
										<input type="text" name="eff_dt" required caption="G/L Date" style="width: 74; text-align: center;" class="input1" dataformat="ymd">
										<img class="cursor" name="eff_dt_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
									</td>
									<td width="70">Due Date</td>
									<td width="100">
										<input type="text" name="rqst_dt" required caption="Due Date" style="width: 74; text-align: center;" class="input1" dataformat="ymd">
										<img class="cursor" name="rqst_dt_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
									</td>
								</tr>
							</table>
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="90">Evidence Type </td>
									<td width="80" style="padding-left:2"><select style="width:78;" class="input1" name="evid_tp_cd" onchange="setButton(this.value);">
										</select></td>								
									<td width="80">DR Account</td>
									<td width="50">
										<input type="text" style="width: 50; text-align:center;" class="input2" value="962111" readonly>
									</td>
									<td width="230">
										<input type="text" style="width: 230; text-align:center;" class="input2" value="OWNERS ACCOUNT INTER-OFFICE ACCT" name="dr_desc" readonly>
									</td>
									<td width="80">CR Account</td>
									<td width="50">
										<input type="text" style="width: 50; text-align:center;" class="input2" value="210121" readonly>
									</td>
									<td width="230">
										<input type="text" style="width: 230; text-align:center;" class="input2" value="Trade payable- General overhead cost" name="cr_desc" readonly>
									</td>
								</tr>
							</table>
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="100">Slip Description</td>
									<td width="800">
										<input type="text" style="width: 750;" class="input1" value="" name="csr_desc" required caption="Slip Description" maxlength="100">
									</td>
								</tr>
							</table>
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="100">Internal Memo</td>
									<td width="800">
										<input type="text" style="width: 750;" class="input" value="" name="oa_inter_mm_desc" maxlength="100">
									</td>
								</tr>
							</table>
							<!--  biz_1   (E) -->
							<table class="line_bluedot">
								<tr>
									<td colspan="8"></td>
								</tr>
							</table> 							
							<!--  biz_2  (S) --> 						
							<!-- Grid  (S) -->
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
								</tr>
							</table> 
							<!-- Grid (E) -->
							<!-- Grid  (S) -->
								<table width="100%" id="mainTable" style="display:none;"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet2');</script>
										</td>
									</tr>
								</table>
							<!-- Grid (E) -->							
							<!-- Grid  (S) -->
								<table width="100%" id="mainTable" style="display:none;"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet3');</script>
										</td>
									</tr>
								</table>
							<!-- Grid (E) -->							
							<!-- Grid  (S) -->
								<table width="100%" id="mainTable" style="display:none;"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet4');</script>
										</td>
									</tr>
								</table>
							<!-- Grid (E) -->							
														
							<!--  Grid_button (S) -->
							<div id="grid_btn">
								<table width="100%" class="button"> 
			       					<tr>
			       						<td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_add">Row&nbsp;Add</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_copy">Row&nbsp;Copy</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_del">Row&nbsp;Delete</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</div>
		    				<!-- Grid_button (E) -->
    				
							<table class="line_bluedot">
								<tr>
									<td colspan="6"></td>
								</tr>
							</table>
							
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td align="left">
										<input type="text" style="width: 50; text-align: center" class="tr_head3" value="DR" readonly>&nbsp;
										<input type="text" style="width: 50; text-align: center" class="tr_head3" value="Total" readonly>&nbsp;
										<input type="text" name="dr_curr_cd" style="width: 50; text-align: center" class="tr_head3" value="EUR" readonly>&nbsp;
										<input type="text" name="dr_amt" style="width: 100; text-align: right;" class="tr_head3" value="0" readonly>&nbsp;&nbsp;
									</td>
									<td align="right">
										<input type="text" style="width: 50; text-align: center" class="tr_head3" value="CR" readonly>&nbsp;
										<input type="text" style="width: 50; text-align: center" class="tr_head3" value="Total" readonly>&nbsp;
										<input type="text" name="cr_curr_cd"style="width: 50; text-align: center" class="tr_head3" value="EUR" readonly>&nbsp;
										<input type="text" name="cr_amt" style="width: 100; text-align: right;" class="tr_head3" value="0" readonly>
									</td>
								</tr>
							</table>							
							<!-- Approval Step (S) -->
							<div id="apro_step_view">
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="160">ALPS Approval Step</td>
									<td colspan="5">
										<input name="apro_step" type="text" class="input2" readonly style="width:650;" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd)%>">&nbsp;
										<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='apro_step_btn'>
									</td>
									<td width="160" colspan="2">&nbsp;( Under USD 30,000 )</td>										
								</tr>
								<tr class="h23">
								</tr>
							</table>
							</div>
							<!-- Approval Step (E) -->
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
										<td width="50">Interface</td>
										<td width="200">																				
										<input type="radio" value="ap" name="asa_gubun"  id="asa_ap" class="trans" disabled>&nbsp;AP&nbsp;
										<input type="radio"  value="asa" name="asa_gubun" id="asa_asa" class="trans"  disabled>&nbsp;ASA&nbsp
										<input type="radio"  value="msa" name="asa_gubun" id="asa_msa" class="trans"  disabled>&nbsp;MSA
										</td>						
										<td width="70">  ASA No.</td>
										<td width="500"><script language="javascript">ComComboObject('asa_no_list',2,276,0,0)</script></td>
										<td width="">
											<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_asa_create">ASA&nbsp;Create</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>	
										<td width="">
										     <table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
											 <tr>
												    <td class="btn2_left"></td>
													<td class="btn2" name="btn_msa_create">MSA&nbsp;Create</td>
													<td class="btn2_right"></td>
											</tr>
										    </table>
									    </td>
									
								</tr>
							</table>
						</td>
					</tr>
				</table> 
				<!--biz page (E)--> 
				
				<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_new">New</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td class="btn1_line"></td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_save">Save</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_delete">Delete</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_submit">Submit</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_taxEvidence">Tax Evidence</td>
										<td class="btn1_right"></td>
										</tr>
									</table></td>									
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_print">Slip Print</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_approval">Approval Step & Comments</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>									
									<!-- 
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_test">Inqury Test</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									 -->									
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!--Button (E) -->
			</td>
		</tr>
	</table>
	<!------- Print용 Hidden RD Object Start -------->
	<table width="100%" id="rdTable">
		<tr>
			<td width="100%"><script language="javascript">comRdObject('Rd');</script></td>
		</tr>
	</table>
	<!------- Print용 Hidden RD Object End -------->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>