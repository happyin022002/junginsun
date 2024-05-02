<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_DOD_0009.jsp
*@FileTitle : DOD Collection Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-14
*@LastModifier : Lee Young du
*@LastVersion : 1.0
* 1.0 최초 생성  
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@page import="com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0009Event"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event.EesDod0004Event"%> <!-- Edit Point  -->
<%
	EesDod0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String loginOfcCd = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		loginOfcCd = account.getOfc_cd();
		
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc	= account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		
		event = (EesDod0009Event)request.getAttribute("Event");
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
<title>Collection Summary by Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var loginOfcCd = "<%=loginOfcCd%>";
	
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
<input type="hidden" name="backendjob_key" />

<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">

<input type="hidden" name="from">
<input type="hidden" name="to">

<input type="hidden" name="dod_cntr_tp_cd"> 
<input type="hidden" name="s_curr_cd"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">DOD Collection Summary by Office</span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
							
							<!-- Edit Point  -->	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_detail" id="btn_detail">Detail</td><td class="btn1_right"></td></tr></table></td>	
								
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
				
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
						<table class="search_in" border="0">
							<tr class="h23">
								<!-- Edit Point  -->
								<td width="60">TRO Date</td>
								<td width="400">
									
								<select style="width:140;" class="input1" name="period">
									<option value="D" selected>Date(YYYY-MM-DD)</option>
									<option value="M" >Month(YYYY-MM)</option>
									<option value="W">Week(YYYY-WW) </option>
								</select>
								
								
								<input type="text" style="width:80;text-align:Center" class="input1" value="" name="froms" caption="FM" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
								<input type="text" style="width:80;text-align:Center" class="input1" value="" name="tos" required dataformat="ymd" caption="TO" maxlength="8">&nbsp;
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarto" >
								
								</td>
																
																		
															
								<td width="50">
									
								
								
								</td>
								
								<!-- Edit Point  -->
								<td width="120">Return Location</td>
								<td width="180"><input name="s_rtn_loc" type="text" dataformat="engup" style="width:80;text-align:Center" maxlength="5" class="input" value="">
												
							</tr>								
							<tr class="h23">
								<td width="120">DOD Office</td>
									
								<td class="stm">
								<input type="radio" name="ofc_flg" value="R" class="trans" checked>&nbsp;RHQ&nbsp;&nbsp;
								<input type="radio" name="ofc_flg" value="O" class="trans">&nbsp;Office&nbsp;&nbsp;
								
								<script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script>
								<input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">&nbsp;Incl. Sub Office
								
								</td>
									
								<td width="50">
																
								</td>
								
								<td width="85">A/R I/F</td>
										<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_ar_if_yn',1,80,0,0);</script>
								</td>
								
																
							</tr>								
							<tr class="h23">
								<td width="120">Currency</td>
									<td class="stm" width="">
									<input type="radio" value="U" class="trans" checked name="curr_cd">USD&nbsp;&nbsp;&nbsp;
									<input type="radio" value="E" class="trans" name="curr_cd">EUR&nbsp;&nbsp;&nbsp;
									<input type="radio" value="L" class="trans" name="curr_cd">Local</td>
								</td>
								
								<td></td>
								
								<td width="120">CNTR Type</td>
										<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_cntr_tp',1,80,0,0);</script>
								</td>
							
							</tr>	
							<tr class="h23">
								<td width="100">INV CUST</td>
									<td width="400">
									<input type="text" name="s_cust_cd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled;" class="input" value=""  dataformat="uppernum">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_customer" width="19" height="20" alt="" border="0" align="absmiddle">
									<input type="text" name="s_cust_nm" style="width:180;text-align:left;" class="input2" value="" readonly>
									</td>
								</td>
								
							</tr>	
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->			

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" cellSpacing="0" cellPadding="0" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
				</table>
					<!-- : ( POR ) (E) -->

    </td></tr>


<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>