<%
/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0012.jsp
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.lea.common.codeutil.basic.CodeUtilBC"%>
<%@ page import="com.clt.apps.opus.esd.lea.common.codeutil.basic.CodeUtilBCImpl"%>
<%@ page import="com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event.EsdLea0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.log4j.StringUtils"%>

<%
	EsdLea0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LogisticsExpenseAccrual.ActualCostCSRManage");

	CodeUtilBC codeUtil = new CodeUtilBCImpl(); 	//Combo BOX
	
	String inv_ofc_cd = "";  //Invoice Office code
	String nowYYMMDD = "";
	String beforeYYMMDD = "";
	String st_if_dt="";
	String end_if_dt = "";
	String src_ctnt = "";
	String if_flg = "";
	String lea_flg = "";
	
	nowYYMMDD = StringUtils.replace(JSPUtil.getKSTDate(),"/","-");
	beforeYYMMDD = DateTime.addDays(nowYYMMDD,-6,"yyyy-MM-dd");
	st_if_dt  	= StringUtils.hasText((String)request.getParameter("frm_st_if_dt")) ? (String)request.getParameter("frm_st_if_dt" ) : beforeYYMMDD;                                                                                                            
	end_if_dt  = StringUtils.hasText((String)request.getParameter("frm_end_if_dt")) ? (String)request.getParameter("frm_end_if_dt" ) : nowYYMMDD;   
	src_ctnt 	= StringUtils.hasText((String)request.getParameter("frm_src_ctnt")) ? (String)request.getParameter("frm_src_ctnt") : "ALL";
	if_flg 	= StringUtils.hasText((String)request.getParameter("frm_if_flg")) ? (String)request.getParameter("frm_if_flg") : "Y";
	lea_flg    = StringUtils.hasText((String)request.getParameter("frm_lea_flg")) ? (String)request.getParameter("frm_lea_flg") : "Y";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CSR I/F Inquiry</title>
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

									<!-- : ( Year ) (S) -->
									<table class="search_in" border="0">
									<tr class="h23">
										<td width="70">Inv. Office</td>
										<td width="160"><%=codeUtil.getCodeCombo("frm_inv_ofc_cd","mdm_organization","distinct ap_ofc_cd a","ap_ofc_cd b", "ap_ofc_cd is not null and delt_flg = 'N'","a","style='width:80;', class='input1'","0: : ")%></td>
											
										<td width="125">ERP Interface Date</td>
										<td width="300" class="stm">
											<input type="text" name="frm_st_if_dt" desc="ERP I/F Date" value="<%=st_if_dt%>" class="input1" style="width:75;" onKeyUp="lea_comm_isNumberMessage(this,8);" onBlur="lea_convertYymmdd(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
											&nbsp;~&nbsp;
											<input type="text" name="frm_end_if_dt" desc="ERP I/F Date" class="input1" style="width:75;" value="<%=end_if_dt%>"  onBlur="lea_convertYymmdd(this);" onKeyUp="lea_comm_isNumberMessage(this,8);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">&nbsp;<img class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
										<td width="92">Source</td>
										<td><select name="frm_src_ctnt" desc="Source" style="width:75;" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
											<option value="ALL" <%=("ALL".equals(src_ctnt.trim())) ? "selected" : ""%>>ALL</option>
											<option value="TRS" <%=("TRS".equals(src_ctnt.trim())) ? "selected" : ""%>>TRS</option>
											<option value="TES" <%=("TES".equals(src_ctnt.trim())) ? "selected" : ""%>>TES</option>
											</select></td>
									</tr>
									<tr class="h23">
										<td></td>
										<td></td>
										<td>ERP Interface</td>
										<td><select name="frm_if_flg" desc="ERP I/F Status" style="width:75;" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
											<option value="ALL" <%=("ALL".equals(if_flg.trim())) ? "selected" : ""%>>ALL</option>
											<option value="Y" <%=("Y".equals(if_flg.trim())) ? "selected" : ""%>>Y</option>
											<option value="N" <%=("N".equals(if_flg.trim())) ? "selected" : ""%>>N</option>
											</select></td>
										<td>LEA Interface</td>
										<td><select name="frm_lea_flg" desc="LEA I/F Status" style="width:75;" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');">
											<option value="ALL" <%=("ALL".equals(lea_flg.trim())) ? "selected" : ""%>>ALL</option>
											<option value="Y" <%=("Y".equals(lea_flg.trim())) ? "selected" : ""%>>Y</option>
											<option value="N" <%=("N".equals(lea_flg.trim())) ? "selected" : ""%>>N</option>
											</select></td></tr>
									</table>
									<!-- : ( Year ) (E) -->
									
									
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
												<tr><td class="btn2_left"></td><td class="btn2" id="btng_csrmonitoring" name="btng_csrmonitoring">CSR Monitoring</td><td class="btn2_right"></td></tr></table></td>

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

</form>
</body>
</html>