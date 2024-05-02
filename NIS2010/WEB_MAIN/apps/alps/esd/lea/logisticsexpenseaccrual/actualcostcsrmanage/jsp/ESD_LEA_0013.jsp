<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0013.jsp
*@FileTitle : CSR Monitoring Inquiry
*Open Issues :
*Change history : 2007.05 Kim Jung Jae 최초생성
*@LastModifyDate : 2014.12.18
*@LastModifier : 이용준
*@LastVersion : 1.2 

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.log4j.StringUtils"%>

<%@ page import="com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBC"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBCImpl"%>

<%
	EsdLea0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "3000";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.ActualCostCSRManage");
	
	CodeUtilBC codeUtil = new CodeUtilBCImpl(); 	//Combo BOX

	String inv_ofc_cd = "";  //Invoice Office code
	String nowYYMMDD = "";
	String beforeYYMMDD = "";
	String opt_st_dt = "";   //Option Start Date
	String opt_end_dt = "";  //Option End Date
	String csr_no = "";      //CSR No.
	String src_ctnt = "";    //Source(TRS, TES)
	String rslt_cd = "";	 //Result code
	String winopen_div = ""; //popUp Window
	String dt_div = "";	     //G/L Date, LEA I/F Date 구분

	//nowYYMMDD		= DateTime.addDays(StringUtils.replace(JSPUtil.getKSTDate(),"/","-"),-1,"yyyy-MM-dd");
	nowYYMMDD		= StringUtils.replace(JSPUtil.getKSTDate(),"/","-");//기준일자를 Today로 변경함.2014-12-23
	beforeYYMMDD	= DateTime.addDays(nowYYMMDD,-6,"yyyy-MM-dd"); //기준날짜포함 이전7일
	opt_st_dt		= StringUtils.hasText((String)request.getParameter("frm_opt_st_dt")) ? (String)request.getParameter("frm_opt_st_dt" ) : beforeYYMMDD;
	opt_end_dt		= StringUtils.hasText((String)request.getParameter("frm_opt_end_dt")) ? (String)request.getParameter("frm_opt_end_dt" ) : nowYYMMDD;
	csr_no			= StringUtils.hasText((String)request.getParameter("frm_csr_no")) ? (String)request.getParameter("frm_csr_no") : "";
	src_ctnt		= StringUtils.hasText((String)request.getParameter("frm_src_ctnt")) ? (String)request.getParameter("frm_src_ctnt") : "ALL";
	rslt_cd			= StringUtils.hasText((String)request.getParameter("frm_rslt_cd")) ? (String)request.getParameter("frm_rslt_cd") : "ALL"; //Not Match(Defalut)
	winopen_div		= StringUtils.hasText((String)request.getParameter("winopen_div")) ? (String)request.getParameter("winopen_div") : "";
	dt_div			= StringUtils.hasText((String)request.getParameter("dt_div")) ? (String)request.getParameter("dt_div") : "";

	try {
		
			
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		//popUpWindow 호출인 경우 Office code를 Parameter에서 받고 Menu 통한 호출인 경우는 Login User's Office Code를 할당
		if (winopen_div.equals("POP")) {
			inv_ofc_cd = StringUtils.hasText((String)request.getParameter("frm_inv_ofc_cd")) ? (String)request.getParameter("frm_inv_ofc_cd") : "";
		} else {
		   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			inv_ofc_cd = account.getOfc_cd();
		}


		event = (EsdLea0013Event)request.getAttribute("Event");
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
<title>CSR Monitoring Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		document.form.winopen_div.value = "<%=winopen_div%>";
		document.form.dt_div.value = "<%=dt_div%>";
		//document.form.frm_inv_ofc_cd.value = "<%=inv_ofc_cd%>"; //Login ID's Office
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="winopen_div" value="<%=winopen_div%>"> <!-- 화면 Open 구분. PopUp or Main -->
<input type="hidden" name="dt_div">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR Monitoring Inquiry</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
				<tr>
				<td class="bg">


					<!-- : ( Year ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="70">Inv. Office</td>
							<!-- <td width="160"><%=codeUtil.getCodeCombo("frm_inv_ofc_cd","mdm_organization","distinct ap_ofc_cd a","ap_ofc_cd b", "ap_ofc_cd is not null and delt_flg = 'N'","a","style='width:80;', class='input1'","0: : ")%></td>-->
							<td width="160"><%=codeUtil.getCodeCombo("frm_inv_ofc_cd","mdm_organization","distinct ofc_cd a", "", "delt_flg = 'N'","a","style='width:80;', class='input1'","0::ALL")%></td>
							<% if(dt_div.equals("GL")) { %>
							<td width="125">Guideline Date</td>
							<% } else { %>
							<td width="125">LEA Interface Date</td>
							<% } %>
							<td width="300" class="sm">
								<input type="text" name="frm_opt_st_dt" value="<%=opt_st_dt%>" class="input1" style="width:75;" onKeyUp="lea_comm_isNumberMessage(this,8);" onBlur="lea_convertYymmdd(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');" onClick="lea_com_select(this)">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
								&nbsp;~&nbsp;
								<input type="text" name="frm_opt_end_dt" value="<%=opt_end_dt%>" class="input1" style="width:75;" onKeyUp="lea_comm_isNumberMessage(this,8);" onBlur="lea_convertYymmdd(this);"  onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');" onClick="lea_com_select(this)">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>

							<td width="50">Source</td>
							<td><select name="frm_src_ctnt" desc="Source" style="width:100;" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
								<option value="ALL" <%=("ALL".equals(src_ctnt.trim())) ? "selected" : ""%>>ALL</option>
								<option value="TRS" <%=("TRS".equals(src_ctnt.trim())) ? "selected" : ""%>>TRS</option>
								<option value="TES" <%=("TES".equals(src_ctnt.trim())) ? "selected" : ""%>>TES</option>
								</select></td>
						</tr>
						<tr class="h23">
							<td></td>
							<td></td>
							<td>CSR No.</td>
							<td><input type="text" name="frm_csr_no" style="width:192;" value="<%=csr_no%>" onKeyUp="lea_comm_isAlphaNumMessage(this,50);upper(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');" onClick="lea_com_select(this)"></td>
							<td>Result</td>
							<td><select name="frm_rslt_cd" desc="Result" style="width:100;" onChange="notMatchSelected();" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
									<option value="ALL" selected>ALL</option>
									<option value="NM"  <%=("NM".equals(rslt_cd.trim())) ? "selected" : ""%>>Not Match</option>
									<option value="MA"  <%=("MA".equals(rslt_cd.trim())) ? "selected" : ""%>>Match</option>
									<option value="XX"  <%=("XX".equals(rslt_cd.trim())) ? "selected" : ""%>>Other</option>
								</select>
								&nbsp;
								<select name="frm_rslt_cd_not_match" desc="Result" style="width:100;" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
									<option value="ALL" selected>ALL</option>
									<option value="ND"  <%=("ND".equals(rslt_cd.trim())) ? "selected" : ""%>>Node</option>
									<option value="CD"  <%=("CD".equals(rslt_cd.trim())) ? "selected" : ""%>>Cost CD</option>
									<option value="AG"  <%=("AG".equals(rslt_cd.trim())) ? "selected" : ""%>>A/G</option>
									<option value="TS"  <%=("TS".equals(rslt_cd.trim())) ? "selected" : ""%>>TP/SZ</option>
									<option value="VV"  <%=("VV".equals(rslt_cd.trim())) ? "selected" : ""%>>VVD</option>
									<option value="BK"  <%=("BK".equals(rslt_cd.trim())) ? "selected" : ""%>>No BKG</option>
									<option value="NE"  <%=("NE".equals(rslt_cd.trim())) ? "selected" : ""%>>No Est</option>
									<option value="DI"  <%=("DI".equals(rslt_cd.trim())) ? "selected" : ""%>>Div</option>
								</select>
							</td>
						</tr>
					</table>
					<!-- : ( Year ) (E) -->

					</td>
				</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Grid Box ) (S) -->
		<table class="search">
				<tr>
				<td class="bg">


						<!-- Grid : Week (S) -->
						<table width="100%" id="mainTable">
							<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
						</table>
						<!-- Grid : Week (E) -->


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


<div id="hidden_sheets1" style="display:none">
	<!-- : ( Grid ) (S) -->
	<table width="100%"  id="mainTable">
		<tr><td>
			 <script language="javascript">ComSheetObject('hidden_sheet1');</script>
		</td></tr>
	</table>
</div>

<div id="hidden_sheets2" style="display:none">
	<!-- : ( Grid ) (S) -->
	<table width="100%"  id="mainTable">
		<tr><td>
			<script language="javascript">ComSheetObject('hidden_sheet2');</script>
		</td></tr>
	</table>
</div>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>