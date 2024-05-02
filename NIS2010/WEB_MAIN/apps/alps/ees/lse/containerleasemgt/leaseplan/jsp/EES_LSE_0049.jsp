<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0049.jsp
*@FileTitle : Long Term Lease CNTR Delivery Plan & Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0049Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0049Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.containerleasemgt.leaseplan");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EesLse0049Event)request.getAttribute("Event");
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
<title>Long Term Lease CNTR Delivery Plan</title>
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
						<!--  biz  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="65">Plan Year</td>
								<td width="310">
									<input type="text" name="pln_yr" caption="Plan Year" style="width:40;text-align:center;" class="input1" value="" dataformat="int" maxlength="4" required fullfill>&nbsp;<script language="javascript">ComComboObject('de_mon', 1, 200, 0);</script>
								</td>
								<td width="80">Delivery LOC</td>
								<td width="80">
									<input type="text" name="loc_cd" caption="Delivery LOC." style="width:50;text-align:center;" class="input" dataformat="engup" maxlength="5" fullfill>
									<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td>
									<table border="0" style="width:180;" style="background-color: #E9E9E9;"> 
										<tr class="h23">
											<td class="stm" align="center">
												<input type="radio" name="loc_tp" value="RCC" class="trans">&nbsp;RCC&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="loc_tp" value="LCC" class="trans" checked>&nbsp;LCC&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="loc_tp" value="SCC" class="trans">&nbsp;SCC&nbsp;&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>			
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="65">AGMT No.</td>
								<td width="310">
									<input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40;text-align:center;" class="input2" value="HHO" readonly>
									<input type="text" name="agmt_seq" caption="AGMT No." style="width:50;text-align:center;" class="input" maxlength="6" dataformat="int">
									<img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								
								<td width="80">Lease Term</td>
								<td width="100">
									<input type="text" name="lstm_cd" caption="Lease Term" style="width:50;text-align:center;" class="input2" value="" readonly>
								</td>
								<td width="45">TP/SZ</td>
								<td style="padding-left:1;">
									<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 243, 0);</script>
									<!--<input type="checkbox" name="chk_cntr_tpsz_cd" class="trans">-->
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="65">Lessor</td>
								<td width="">
									<input type="text" name="mft_vndr_seq" caption="Lessor" style="width:50;text-align:center;" class="input" maxlength="6" dataformat="int">
									<img src="img/btns_search.gif" width="19" name="btns_search3" height="20" alt="" border="0" align="absmiddle" class="cursor">
									<input type="text" name="mft_vndr_nm" caption="Lessor" style="width:363" class="input2" value="" readonly>
								</td>
								
							</tr>
						</table>
						<!--  biz (E) -->
					</td>
				</tr>
			</table>	

			<table class="height_8"><tr><td></td></tr></table>	

			<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg">	
						<!-- Grid  (S) -->
						<table width="100%" id="sheetTable">
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
														<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
			<!-- <table class="line_bluedot"><tr><td></td></tr></table> -->
			<table class="height_8"><tr><td></td></tr></table>	
			<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg">	
						<!-- Title --> 
						<table class="search" border="0">
							<tr><td class="title_h"></td> 
								<td class="title_s">CNTR Detail</td></tr>
						</table> 
						<!-- Title -->  

						<!-- Grid  (S) -->
						<table width="100%"  id="sheetTable2">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
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
														<td class="btn2" name="btn_DownExcel2">Down Excel</td>
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
			<!--biz page (E)-->
		</td>
	</tr>
</table>
	<table class="height_10"><tr><td></td></tr></table>	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>