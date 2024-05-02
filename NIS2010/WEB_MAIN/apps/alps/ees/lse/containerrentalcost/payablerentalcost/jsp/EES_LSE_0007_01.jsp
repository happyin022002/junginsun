<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0007_01.jsp
*@FileTitle : Container Rental Charge Creation Audit & Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.30 노정용
* 1.0 Creation
=========================================================
* 2011.03.15 남궁진호 [CHM-201109440-01] btn_t4DownExcel 오타 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007PopEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0007PopEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String func         = "";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strVndrSeq   = "";
	String strVndrNm    = "";
	String strCostYrmon	= "";
	String strInvNo     = "";
	String strChgSeq    = "";
	String strAgmtCtyCd = "";
	String strAgmtSeq   = "";
	String strInvYn     = ""; // Invoice Creation 완료 여부
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		func         = JSPUtil.getNull(request.getParameter("func"));
		strVndrSeq   = JSPUtil.getNull(request.getParameter("vndr_seq"));
		strVndrNm    = JSPUtil.getNull(request.getParameter("vndr_nm"));
		strCostYrmon = JSPUtil.getNull(request.getParameter("chg_cost_yrmon"));
		strInvNo     = JSPUtil.getNull(request.getParameter("inv_no"));
		strChgSeq    = JSPUtil.getNull(request.getParameter("chg_seq"));
		strAgmtCtyCd = JSPUtil.getNull(request.getParameter("agmt_cty_cd"));
		strAgmtSeq   = JSPUtil.getNull(request.getParameter("agmt_seq"));
		strInvYn     = JSPUtil.getNull(request.getParameter("inv_yn"));
		if ( strInvYn.equals("") ) {
			strInvYn = "N";
		}

		event = (EesLse0007PopEvent)request.getAttribute("Event");
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
<title>Container Rental Charge Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="backendjob_key">
<input type="hidden" name="func"        value="<%= func %>">
<input type="hidden" name="inv_no"      value="<%= strInvNo %>">
<input type="hidden" name="chg_seq"     value="<%= strChgSeq %>">
<input type="hidden" name="agmt_cty_cd" value="<%= strAgmtCtyCd %>">
<input type="hidden" name="agmt_seq"    value="<%= strAgmtSeq %>">
<table width="900" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Payable Charge Audit Result & Payable Amount Confirm</td></tr>
			</table>
			<!-- : ( Title ) (E) -->

			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="55">Lessor</td>
								<td width="450">
									<input type="text" class="input2" value="<%= strVndrSeq %>" readonly style="width:60;text-align:center;" dataformat="int">
									<input type="text" class="input2" value="<%= strVndrNm %>"  readonly style="width:350">
								</td>
								<td width="86">Cost Month</td>
								<td width="">
									<input type="text" name="chg_cost_yrmon" class="input2" value="<%= strCostYrmon %>" readonly style="width:80;text-align:center;" dataformat="ym">
								</td>
							</tr> 
						</table>
					</td>
				</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->
			<!--TAB Coincidence (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search" id="mainTable"> 
					<tr>
						<td class="bg">									
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
<% if ( !strInvYn.equals("Y") ) { %>
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
															<td class="btn2" name="btn_t1RowAdd">Row Add</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1RowDelete">Row Delete</td>
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
<% } %>
				    		<table class="height_5"><tr><td></td></tr></table>
				    		<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="90">Payable AMT</td>
									<td width="150">
										<input type="text" name="t1pAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="36">AMT</td>
									<td width="150">
										<input type="text" name="t1Amt"  style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="76">Credit AMT</td>
									<td width="">
										<input type="text" name="t1cAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
								</tr> 
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!--TAB Coincidence (E) -->
			<!--TAB Discrepancy (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" id="mainTable"> 
					<tr>
						<td class="bg">									
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
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
<% if ( !strInvYn.equals("Y") ) { %>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2Move">Move Coincidence</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
<% } %>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2DownExcel">Down Excel</td>
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
				    		<table class="height_5"><tr><td></td></tr></table>
				    		<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="90">Payable AMT</td>
									<td width="150">
										<input type="text" name="t2pAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="36">AMT</td>
									<td width="150">
										<input type="text" name="t2Amt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="76">Credit AMT</td>
									<td width="">
										<input type="text" name="t2cAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
								</tr> 
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!--TAB Discrepancy (E) -->
			<!--TAB Charge Only (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" id="mainTable"> 
					<tr>
						<td class="bg">									
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t3sheet1');</script>
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
<% if ( !strInvYn.equals("Y") ) { %>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t3Move">Move Coincidence</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
<% } %>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t3DownExcel">Down Excel</td>
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
					    	<table class="height_5"><tr><td></td></tr></table>
					    	<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="90">Payable AMT</td>
									<td width="150">
										<input type="text" name="t3pAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="36">AMT</td>
									<td width="150">
										<input type="text" name="t3Amt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="76">Credit AMT</td>
									<td width="">
										<input type="text" name="t3cAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
								</tr> 
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!--TAB Charge Only (E) -->
			<!--TAB Invoice Only (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" id="mainTable"> 
					<tr>
						<td class="bg">									
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t4sheet1');</script>
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
<% if ( !strInvYn.equals("Y") ) { %>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t4Move">Move Coincidence</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
<% } %>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t4DownExcel">Down Excel</td>
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
							<table class="height_5"><tr><td></td></tr></table>
					    	<table class="search" border="0" style="width:100%;"> 
								<tr class="h23">
									<td width="90">Payable AMT</td>
									<td width="150">
										<input type="text" name="t4pAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="36">AMT</td>
									<td width="150">
										<input type="text" name="t4Amt" style="width:100;text-align:right" value="" class="input2">
									</td>
									<td width="76">Credit AMT</td>
									<td width="">
										<input type="text" name="t4cAmt" style="width:100;text-align:right" value="" class="input2">
									</td>
								</tr> 
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!--TAB Invoice Only (E) -->
			<!--biz page (E)-->
			<table class="height_5"><tr><td></td></tr></table>
			<!-- : ( Button : pop ) (S) -->
			<table width="100%" class="sbutton">
				<tr>
					<td !height="71" class="popup">
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
			       			<tr>
			       				<td class="btn3_bg">
					    			<table border="0" cellpadding="0" cellspacing="0">
					    				<tr>
<% if ( !strInvYn.equals("Y") ) { %>
					    					<td width="">
					    						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Reject">Reject</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
					    					<td width="">
					    						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Confirm">Confirm</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
<% } %>
											<td width="">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Close">Close</td>
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
			<!-- : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>