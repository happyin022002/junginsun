<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0002.jsp
*@FileTitle : Accrual Result by Account Code
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.09
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.09 전재홍
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
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String nowYYMM 			= "";
	String revFromYYMM 		= "";
	String revToYYMM 		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM"); //Execute Year Month
		//revFromYYMM = DateTime.getYear()+"-01";
		revFromYYMM = nowYYMM.substring(0,4) + "-01";                         //Revenue Year Month(From)
		revToYYMM 	= nowYYMM;          
		
	  	  if(Integer.parseInt(nowYYMM.substring(5,7))==4){
	  			revFromYYMM = (Integer.parseInt(nowYYMM.substring(0,4))-1+"-")+"12";
		  }else if(Integer.parseInt(nowYYMM.substring(5,7))==3){
			  revFromYYMM = (Integer.parseInt(nowYYMM.substring(0,4))-1+"-")+"11";
		  }else if(Integer.parseInt(nowYYMM.substring(5,7))==2){
			  revFromYYMM = (Integer.parseInt(nowYYMM.substring(0,4))-1+"-")+"10";
		  }else if(Integer.parseInt(nowYYMM.substring(5,7))==1){
			  revFromYYMM = (Integer.parseInt(nowYYMM.substring(0,4))-1+"-")+"09";
		  }
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Accrual Result By Account Code</title>
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
<input type="hidden" name="frm_confirm_div">
<input type="hidden" name="frm_mnl_inp_flg">
<input type="hidden" name="frm_cond_cfm_flg">
<input type="hidden" name="frm_erp_if_flg">
<input type="hidden" name="erp_if_dt">
<input type="hidden" name="frm_mail_div" value="B">

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
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Exe. Year-Month</td>
					<td width="160"><input type="text" style="width:60;" class="input1" name="frm_exe_yrmon"  valid="1" desc= "Exe. Year-Month" value="<%=nowYYMM%>" onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);lea_com_setRevToYymm(this,document.form.frm_rev_yrmon_from, document.form.frm_rev_yrmon_to);" onKeyDown="lea_setRevToYymm(this,document.form.frm_rev_yrmon_to);lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)"></td>
					<td width="112">Rev. Year-Month</td>
					<td width="250" class="stm"><input type="text" name="frm_rev_yrmon_from" class="input1" style="width:60;" valid="1" desc= "From Rev. Year-Month" value="<%=revFromYYMM%>"  onKeyUp="lea_comm_isNumberMessage(this,6);" onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp; ~ &nbsp;
												<input type="text" name="frm_rev_yrmon_to" class="input1" style="width:60;" valid="1" desc= "To Rev. Year-Month"  value="<%=revToYYMM%>"  onKeyUp="lea_comm_isNumberMessage(this,6);"  onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve');" onClick="lea_com_select(this)">
												<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="60">Accrual</td>
					<td>
								<table border="0" style="height:22; width:150; background-color: #E9E9E9;">
								<tr><td class="sm" style="padding-left:10;">
										<input type="checkbox" name="f_acct_type_a" class="trans" value="1" checked onChange="lea_setCookieAcclType();">Auto&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="f_acct_type_m" class="trans" value="1" checked onChange="lea_setCookieAcclType();">Manual&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<!--input type="checkbox" name="f_acct_type_t" class="trans"	value="1" checked onChange="lea_setCookieAcclType();">Transfer--></td>
								</tr>
							</table>
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td><script language="javascript">ComTabObject('tab1')</script>
       	<!--img src="/hanjin/img/sub_tab.gif" alt="" width="755" height="23" border="0"--></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
<div id="tabLayer" style="display:inline">


				<!-- : ( Seq. ) (S) -->
				<table width="100%" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>
				</table>
				<!-- : ( Seq. ) (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg" width="250"><input type="text" class="transgray" name="gl_accl_if_confirm_text" value="" style="width:100%;" readonly>
			       		</td>
			       		<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="t1btng_confirm" name="t1btng_confirm">Confirm</td><td class="btn2_right"></td></tr></table></td>
	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="t1btng_downexcel" name="t1btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
					</tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
</div>




<div id="tabLayer" style="display:none">


				<!-- : ( Seq. ) (S) -->
					<table width="100%" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet2');</script>
				       </td></tr>
				</table>
				<!-- : ( Seq. ) (E) -->


				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg"><td class="btn2_bg" width="250"><input type="text" class="transgray" name="gl_accl_if_confirm_text2" value="" style="width:100%;" readonly>
			       		</td>
			       		<td  class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="t2btng_save" name="t2btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="t2btng_downexcel" name="t2btng_downexcel" > Down Excel</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
</div>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

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


<div id="hidden_sheets1" style="display:none">
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