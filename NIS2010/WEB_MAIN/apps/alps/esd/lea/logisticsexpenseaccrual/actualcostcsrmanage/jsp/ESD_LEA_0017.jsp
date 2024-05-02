<%
/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0017.jsp
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history : 2015.06.11 
*@LastModifyDate : 2015.06.11 
*@LastModifier : KIM HYUN-HWA
*@LastVersion : 1.0
**********************************************************************************
* 2015.11.11 김현화 [CHM-201538864]블라디보스톡 Combo Box 추가 관련- VVOIA RHQ 추가
=================================================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBC"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBCImpl"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.log4j.StringUtils"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EsdLea0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "3000";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.ActualCostCSRManage");

	
	String strUsr_rhq_ofc_cd = "";  
	String strUsr_ofc_cd = ""; 
	String nowYYMM = "";
	String exeFromYYMM = "";
	String exeToYYMM = "";
	String src_ctnt = "";
	
	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM"); //Exe Year Month
	
	exeFromYYMM = nowYYMM;
	exeToYYMM 	= nowYYMM;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_rhq_ofc_cd = account.getRhq_ofc_cd();
		strUsr_ofc_cd = account.getOfc_cd();


		event = (EsdLea0017Event)request.getAttribute("Event");
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
<title>CSR I/F Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/hanjin/js/CoFormControl.js"></script>

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
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="usr_rhq_ofc_cd" value="<%=strUsr_rhq_ofc_cd%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="ofc_type">
<input type="hidden" name="acct_rhq_ofc_cd">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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

									<!-- : ( Condition ) (S) -->
									<table class="search_in" border="0">
									<tr class="h23">
										<td width="80">G/L Month </td>
				                        <td width="130" ><input type="text" class="input1" style="width:55" name="gl_mon_from" valid="1" desc= "Exe Year-Month" value="<%=exeFromYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)">
											<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"><!-- &nbsp; ~ &nbsp; 
												<input type="text" class="input1" style="width:55" name="gl_mon_to" valid="1" desc= "Exe Year-Month" value="<%=exeToYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">--></td>
										<td width="50">Source</td>
										<td width="110"><select name="f_sys_id" desc="Source" style="width:75;" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
											<option value="" selected>ALL</option>
											<option value="TRS">TRS</option>
											<option value="TES">TES</option>
											</select></td>
									   <td width="50">RHQ</td>
									   <td width="110">
											<SELECT style='width:70' name="f_rhq_cd" onChange="changeRhqCd();" class="input1">
											<!--<OPTION value="">ALL</OPTION>  -->
											<OPTION value="HAMRU">HAMRU</OPTION>
					                        <OPTION value="NYCRA">NYCRA</OPTION>
					                        <OPTION value="SHARC">SHARC</OPTION>
					                        <OPTION value="SINRS">SINRS</OPTION>
											<OPTION value="SELIB">SELIB</OPTION>
											<OPTION value="TYOIB">TYOIB</OPTION>
											<OPTION value="VVOIA">VVOIA</OPTION>
											</SELECT>
										</td>
										<td width="100">&nbsp;&nbsp;&nbsp;Control&nbsp;Office</td>
										<td width=""><SELECT style='width:75' name="f_ctrl_ofc_cd" class="input"></SELECT></td>
									</tr>
									<tr class="h23">
                                        <td>Cost&nbsp;Code</td>
							            <td><input type="text" style="width:80;" name="f_coa_cost_src_cd" maxlength="6" desc="Cost Code" onKeyUp="upper(this);lea_comm_isAlphaMessage(this,6);" onClick="lea_com_select(this)"></td>
							            <td>CSR No.</td>
							            <td colspan = 3 ><input type="text" name="f_csr_no" style="width:192;" onKeyUp="lea_comm_isAlphaNumMessage(this,50);upper(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');" onClick="lea_com_select(this)"></td>
							            <td colspan = 2 style="padding-left:5;"><input type="checkbox" name="f_acbm_flag" class="trans" value="Y" checked onChange="setflag();">&nbsp;Only&nbsp;ACBM&nbsp;Cost</td>
					
							        </tr>
									</table>
									<!-- : (  Condition ) (E) -->
									
									
							</td></tr>
						</table>
						<!-- TABLE '#D' : ( Search Options ) (E) -->


						<table class="height_10"><tr><td></td></tr></table>


						<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
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
						<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>