<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0047.jsp
*@FileTitle : Terminal invoice CSR Creation -계산서
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
* @History
*   N200903030070 2009-03-04 : CSR IF Inquriy Downexcel 버튼 추가
* 2014.11.04 10만불비용결재 관련 수정- 항목명 변경 cost_ofc_cd를 inv_ofc_cd로 변경하고 새로 cost_ofc_cd 추가함.
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event"%>
<%
	EsdTrs0047Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";		 	//에러메세지
	String ofc_cd = "";
	String userId = "";
	String usr_nm = "";
	String usr_eml = "";
	String sToDay 			= DateTime.getFormatString	("yyyyMMdd")	;
	String sFromDay			= DateTime.addDays			(sToDay, -30)	;

	String sFormatToDay		= "";
	String sFormatFromDay	= "";

	if(sToDay.length()   == 8)	sFormatToDay 	= sToDay.substring	(0,4) + "-" + sToDay.substring	(4,6) + "-" + sToDay.substring	(6,8);
	if(sFromDay.length() == 8)	sFormatFromDay	= sFromDay.substring(0,4) + "-" + sFromDay.substring(4,6) + "-" + sFromDay.substring(6,8);

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd();
	   userId=account.getUsr_id();
	   usr_nm=account.getUsr_nm();
	   usr_eml=account.getUsr_eml();

		event = (EsdTrs0047Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	String csrNo = JSPUtil.getParameter(request,"CSR_NO".trim(),"");
	String ifSts = JSPUtil.getParameter(request,"STS".trim(),"");
%>
<html>
<head>
<title>Transportion CRS Interface Status Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="csr_no">
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="cost_apro_step">
<input type="hidden" name="login_apro_step">

<input type="hidden" name="cost_ofc_cd">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">

<input type="hidden" name="vndr_seq">
<input type="hidden" name="inv_knt">
<input type="hidden" name="curr_cd">   
<input type="hidden" name="total_amt">
<input type="hidden" name="max_iss_dt">
<input type="hidden" name="max_rcv_dt">
<input type="hidden" name="payment_due_dt">

<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="usr_eml" value="<%=usr_eml%>">
<input type="hidden" name="usr_nm" value="<%=usr_nm%>">
<input type="hidden" name="if_sts" value="<%=ifSts%>">
<input type="hidden" name="csr_tp_cd">

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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<table class="search_in" border="0">
								<tr class="h23">
									<td width="86">Invoice Office</td>
									<td width="82"><input name="inv_ofc_cd" type="text" maxlength=6 style="width:60" class="input2" value="<%=ofc_cd%>" readonly></td>
									<td width="32">Date</td>
									<td width="339" class="sm">
										<select style="width:140;" name='dt_status'>
										<option value="RA">Requesting Approval</option>
										<option value="CC">CSR Creation</option>
										<option value="AR">Approval Requested</option>
										<option value="AV">Approved</option>
										<option value="IU">I/F Status Updated</option>
										</select>
										<input name="fm_eff_dt" type="text" style="width:71" maxlength=10 value="<%=sFormatFromDay%>"  onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp="javascript:isNum(this);">&nbsp;~&nbsp;<input name="to_eff_dt" type="text" style="width:71" maxlength=10 value="<%=sFormatToDay%>"  onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp="javascript:isNum(this);"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>

									<td width="65">I/F Status</td>
									<td width="157">
										<select style="width:140;" name='if_status'>
										<option value="AL" selected>All</option>
										<option value="RA">Requesting Approval</option>
										<option value="DA">Disapproved</option>
										<option value="AR">Approval Requested</option>
										<option value="IE">I/F Error</option>
										<option value="RJ">A/P Rejected</option>
										<option value="SC">I/F Success</option>
										</select></td>
									</tr>	
									<tr class="h23"><td width="85">Apro Type</td>
									<td width="95">
									<select style="width:60;" name='apro_tp_cd'>
										<option value="" selected>All</option>
										<option value="AL">ALPS</option>
										<option value="GW">G/W</option>
									</select>
									</td>	
									<td width="49">CSR No.</td>
									<td align="left"><input name="mult_csr_no" type="text" style="width:143" value="<%=csrNo%>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multisearch"></td>
								</tr>
							</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->
					
				<!-- 3만불 이하  Approval Step 지정 -->
					<div id="btng_apro_step" style="visibility:hidden;">	
					
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr><td width="10%" class="sm" align="left">
							<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();">Cost Office&nbsp;&nbsp;&nbsp;
							<input type="radio" name="ofc_tp" class="trans" checked Onclick="ofcChange();">&nbsp;Log-in Office
						</td></tr>
					</table>						
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="94">Approval Step</td>
							<td><input name="apro_step" type="text" style="width:853" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, "TRS") %>"> <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btng_search"></td>
						</tr>
					</table>
					</div>
				<!-- 3만불 이하  Approval Step 지정 -->
					
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<!--
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_editapprovalstep" name="btng_editapprovalstep">Edit Approval Step</td><td class="btn2_right"></td></tr></table></td>
                            -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_viewapprovalstep" name="btng_viewapprovalstep">View Approval Step</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_agreement" id="btng_agreement">Agmt Files</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_csrformat" name="btng_csrformat">CSR Format</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invoicelistinquiry" name="btng_invoicelistinquiry">Invoice List Inquiry</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_approvalrequest" name="btng_approvalrequest">Approval Request</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_csrcancel" name="btng_csrcancel">CSR Cancel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>
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
<form name="form1" method="post">
</form>

<iframe frameborder=0 width=0 name="iframe" scrolling="no" frameborder="0" width="0" height="0"></iframe>

</body>
</html>
<DIV style="display:none">
					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->

					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->
</DIV>