<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0902.jsp
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.07.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.28 전재홍
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
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0902Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0902Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.lea.LogisticsExpenseAccrual.AccrualBatchExecuteResult");
	
	String param_name 			= null;
	String nowYYMM 				= "";
	String revFromYYMM 			= "";
	String revYYMM 				= "";

	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}
	
	String exe_yrmon		 = request.getParameter("exe_yrmon"		)!=null&&!request.getParameter("exe_yrmon"	).equals("")?request.getParameter("exe_yrmon" ):nowYYMM;                                                                                                            
	String rev_yrmon		 = request.getParameter("rev_yrmon"		)!=null&&!request.getParameter("rev_yrmon"	).equals("")?request.getParameter("rev_yrmon" ):exe_yrmon;                                                                                                

	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");
	revFromYYMM = nowYYMM.substring(0,4) + "-01";                         //Revenue Year Month(From)
	revYYMM = exe_yrmon.substring(0,4) + "-01";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0902Event)request.getAttribute("Event");
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
<title>Rev.VVD Inquiry (Pop-up)</title>
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
<!-- form name="form"-->
<!-- input type="hidden" name="f_cmd"-->
<!-- input type="hidden" name="pagerows"-->
<!-- 개발자 작업	-->
<form   method="post" name ="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="frm_dup_select">


<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Rev. VVD Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr class="h23">
					<td width="110">Exe. Year-Month</td>
					<td width="130"><input type="text" class="input1" style="width:60;" name="frm_exe_yrmon" desc="Exe. Year - Month" value="<%=exe_yrmon%>"  onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);lea_com_setRevToYymm(this, document.form.frm_rev_yrmon_from,document.form.frm_rev_yrmon_to);" onKeyDown="lea_setRevToYymm(this,document.form.frm_rev_yrmon_to);lea_com_enterKeyEvent('lea_enterRetrieve')"></td>
					<td width="112">Rev. Year-Month</td>
					<td class="sm">
						<input type="text" class="input1" style="width:60;" name="frm_rev_yrmon_from" desc="Rev. Year - Month" value="<%=revYYMM%>"  onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')">
						&nbsp;~&nbsp;
						<input type="text" class="input1" style="width:60;" name="frm_rev_yrmon_to" value="<%=rev_yrmon%>"  onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')"></td></tr>
				</table>
				<!-- : ( Year ) (E) -->


				<table class="line_bluedot"><tr><td></td></tr></table>


				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>
				</table>
				<!-- : ( Speed ) (E) -->


				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_select" name="btng_select">Select</td><td class="btn2_right"></td></tr></table></td>
<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_duplicatedvvd" name="btng_duplicatedvvd">Duplicated VVD</td><td class="btn2_right"></td></tr></table></td>
 -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->





<div id="hidden_sheets1" style="display:none">
			<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable">
								<tr><td>
									 <script language="javascript">ComSheetObject('hidden_sheet1');</script>
								</td></tr>
							</table>
</div>




		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	   <tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		    </table>

	      </td></tr>
       </table>
</td></tr>
</table>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

