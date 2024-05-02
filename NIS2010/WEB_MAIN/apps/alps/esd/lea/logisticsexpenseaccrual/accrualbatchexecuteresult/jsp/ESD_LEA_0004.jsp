<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0004.jsp
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
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
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");

	String nowYYMM 			= "";
	String revYYMM 	= "";
	String param_name = null;


	nowYYMM = DateTime.addMonths(JSPUtil.getKST("yyyy-MM"),-1,"yyyy-MM");
	revYYMM = nowYYMM;
	
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
	param_name = (String)enums.nextElement();
	}

	String exe_yrmon		 = request.getParameter("exe_yrmon"		)!=null&&!request.getParameter("exe_yrmon"	).equals("")?request.getParameter("exe_yrmon" ):nowYYMM;
	String rev_yrmon		 = request.getParameter("rev_yrmon"		)!=null&&!request.getParameter("rev_yrmon"	).equals("")?request.getParameter("rev_yrmon" ):revYYMM;
	String acct_cd		 	 = request.getParameter("acct_cd"		)!=null&&!request.getParameter("acct_cd"	).equals("")?request.getParameter("acct_cd" 	):"ALL";
	String rev_vvd_no		 = request.getParameter("rev_vvd_no"	)!=null&&!request.getParameter("rev_vvd_no"	).equals("")?request.getParameter("rev_vvd_no"):"ALL";
	String bkg_no		 	 = request.getParameter("bkg_no"		)!=null&&!request.getParameter("bkg_no"		).equals("")?request.getParameter("bkg_no" 		):"";
	String open_div		 	 = request.getParameter("open_div"		)!=null&&!request.getParameter("open_div"		).equals("")?request.getParameter("open_div" 	):"";
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0004Event)request.getAttribute("Event");
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
<title>Accrual Result by Booking</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="winopen_div" value="<%=open_div%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Accrual Result by Booking</td></tr>
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
					<td width="190"><input type="text" class="input1" style="width:55;" name="frm_exe_yrmon" value="<%=exe_yrmon%>" valid="1" desc= "Exe. Year-Month"  onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')"></td>
					<td width="120">Rev. Year-Month</td>
					<td width="150"><input type="text" class="input1" style="width:55;" name="frm_rev_yrmon" value="<%=rev_yrmon%>" valid="1" desc= "Rev. Year-Month" onKeyUp="lea_comm_isNumberMessage(this,6);"  onBlur="lea_com_convertYymm(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')"></td>
					<td width="67">Acct. Code</td>
					<td width="160"><input type="text" style="width:55;" name="frm_acct_cd" value="<%=acct_cd%>" desc= "Acc. Code" maxlength="6" onKeyUp="lea_comm_isNumberMessage(this,6);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btns_acct_search" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="63">Rev. VVD</td>
					<td><input type="text" style="width:85;" desc="Rev. VVD" name="frm_vvd_no" value="<%=rev_vvd_no%>" dataformat="engup" maxlength="10" onKeyUp="lea_comm_isAlphaNumMessage(this,10);upper(this);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btns_rev_vvd_search" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>


				<tr class="h23">
					<td>Booking No.</td>
					<td><input type="text" style="width:130;" name="frm_bkg_no"  desc="BKG No." value="<%=bkg_no%>" dataformat="engup" maxlength="13" onKeyUp="lea_comm_isAlphaNumMessage(this,13);upper(this);"></td>
					<td>Cost Diff. Filtering</td>
					<td colspan="4" class="sm">&nbsp;&nbsp;
						<input type="radio" class="trans" name="frm_diff_div" value="A" checked>Amount&nbsp;&nbsp;<input type="text" style="width:30;" name="frm_cost_diff_amt" value="0" onKeyUp="lea_com_isNumDash(this);lea_selectRadio(this,document.form.frm_cost_diff_per);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" class="trans"  name="frm_diff_div" value="P" >Percent&nbsp;&nbsp;<input type="text" style="width:30;" name="frm_cost_diff_per" value="0" onKeyUp="isNumberMessage(this);lea_selectRadio(this,document.form.frm_cost_diff_amt);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')">&nbsp;%</td></tr>
				</table>

				<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">


				<!-- : ( Seq. ) (S) -->
				<table width="100%" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>
				</table>
				<!-- : ( Seq. ) (E) -->


				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_detailbycontainer" name="btng_detailbycontainer">Detail By Container</td><td class="btn2_right"></td></tr></table></td>

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