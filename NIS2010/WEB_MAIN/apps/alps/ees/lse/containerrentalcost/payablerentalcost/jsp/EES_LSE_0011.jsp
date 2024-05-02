<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0011.jsp
*@FileTitle : Operational Lease Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.09 노정용
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsrId	    = "";
	String strUsrNm	    = "";
	String strUsrOfcCd  = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsrId     = account.getUsr_id();
		strUsrNm     = account.getUsr_nm();
		strUsrOfcCd  = account.getOfc_cd();

		event = (EesLse0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Operational Lease Payable Invoice Creation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="usr_id"     value="<%= strUsrId %>">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsrOfcCd %>">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="gen_pay_term_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
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
			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg">
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">Lessor</td>
								<td width="250" colspan="3" style="padding-left:2">
 									<script language="javascript">ComComboObject('vndr_seq', 2, 80, 0, 1, 1);</script>
								</td>
								<td width="113">Payment Period</td>
								<td width="">
									<input type="text"  name="bil_fm_dt"   caption="Payment Period" style="width:80;text-align:center;" value="" maxlength="8" dataformat="ymd" class="input1" !cofield="pay_to_prd"   required>
									<img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
									&nbsp;~&nbsp;
									<input type="text"  name="bil_to_dt"   caption="Payment Period" style="width:80;text-align:center;" value="" maxlength="8" dataformat="ymd" class="input1" !cofield="pay_from_prd" required>
									<img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr> 
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
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
														<td class="btn2" name="btn_RowAdd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowDelete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_SoCreate">Save</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- Button_Sub (E) -->	
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="70"">Total Q'ty</td>
								<td width="220">
									<input type="text" name="lse_op_qty" style="width:80;text-align:right;" value="" class="input2" dataformat="int" readonly>
								</td>
								<td width="90">Total Amount</td>
								<td width="">
									<input type="text" name="pay_amt" style="width:105;text-align:right;" value="" class="input2" dataformat="float" readonly>
								</td>
							</tr>
						</table>
							</td>
							</tr>
						</table>
						
						<table class="height_8"><tr><td></td></tr></table>
						<table class="search" id="mainTable"> 
       					<tr><td class="bg">
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="70">RCV Date</td>
								<td width="230">
									<input type="text" name="inv_rcv_dt" style="width:80;text-align:center;" class="input1" maxlength="8" dataformat="ymd" value="">
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="80">Issue Date<!-- / Effective Date--></td>
								<td width="230">
									<input type="text" name="inv_iss_dt" style="width:80;text-align:center;" class="input1" maxlength="8" dataformat="ymd" value="">
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar4" width="19" height="20" border="0" align="absmiddle">
									<!--/
									<input type="text" name="inv_eff_dt" style="width:80;text-align:center;" class="input2" value="" readonly>-->
								</td>
								<td width="80">Invoice OFC.</td>
								<td width="115">
									<input type="text" name="inv_ofc_cd"  style="width:70;text-align:center" class="input2" value="" readonly>
								</td>
								<td width="70">Cost OFC.</td>
								<td width="">
									<input type="text" name="cost_ofc_cd" style="width:70;text-align:center" class="input1" maxlength="6" dataformat="engup" value="">
									<img src="img/btns_search.gif" name="btn_Office" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>
							<tr class="h23">
								<td width="70">Currency</td>
								<td width="230">
									<input type="text" name="curr_cd" caption="Currency" style="width:80;text-align:center;" class="input1" value="" maxlength="3" dataformat="engup">
									<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="80">INV Amt</td>
								<td width="230">
									<input type="text"   name="inv_amt" style="width:80;text-align:right" class="input2" value="" readonly>
									<input type="hidden" name="cr_amt"  style="width:80;text-align:right" class="input2" value="" readonly>
								</td>
								<td width="70">Pay Term</td>
								<td width="" colspan="3">
									<input type="text" name="vndr_term_nm" style="width:70" class="input2" value="" readonly>
								</td>
								<!-- 
								<td width="80">Credit Amt</td>
								<td width="115" colspan="3">
									<input type="text" name="cr_amt" style="width:80;text-align:right" class="input2" value="" readonly>
								</td>
								 -->
							</tr>
						</table>
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="70">Remark</td>
								<td width=""><textarea name="inv_rmk" style="width:100%;ime-mode:disabled" rows="3"></textarea></td>
							</tr>
						</table>
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
                            							<td class="btn2" name="btn_InvoiceCreation">Invoice Creation</td>
                            							<td class="btn2_right"></td>
                            						</tr>
                            					</table>
                            				</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
                		<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_10"><tr><td></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>