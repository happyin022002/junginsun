<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0010.jsp
*@FileTitle : Cost Code Inquiry
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
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0010Event"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO" %>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBC"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBCImpl"%>
<%@ page import="com.hanjin.framework.component.util.log4j.StringUtils"%>

<%
	EsdLea0010Event  	event 				= null;					//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException   	= null;			//서버에서 발생한 에러
	String 				strErrMsg 			= "";						//에러메세지
	int 				rowCount	 		= 0;						//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.accrualbatchexecuteresult");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event 			= (EsdLea0010Event)request.getAttribute("Event");
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
<title>Cost Code Inquiry</title>
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
<form	method="post"	name="form"			>
<input	type="hidden"	name="f_cmd"		>
<input	type="hidden"	name="iPage"		>

<input	type="hidden"	name="cost_kind"		>
<input	type="hidden"	name="sel_mn_cost_tp_cd">

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
					<td>Cost Code</td>
					<td><input type="text" style="width:120;" name="frm_cost_cd" maxlength="6" desc="Cost Code" onKeyUp="upper(this);lea_comm_isAlphaMessage(this,6);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)"></td>
					<td>Acct. Code</td>
					<td><input type="text" style="width:120;" name="frm_acct_cd" maxlength="6" desc="Acct. Code" onKeyUp="lea_comm_isNumberMessage(this,6);" onKeyDown="lea_com_enterKeyEvent('lea_enterRetrieve')" onClick="lea_com_select(this)"></td>
				</tr>
				<tr class="h23">
					<td width="80">Cost Type I</td>
					<td width="220"><script language="javascript">ComComboObject('mn_cost_tp_cd'	, 2, 122 , 1)</script></td>				
					<td width="85">Cost Type II</td>
					<td width="220"><script language="javascript">ComComboObject('sub_cost_tp_cd'	, 2, 122 , 1)</script></td>
					<td width="87">Accrual Type</td>
					<td>			<script language="javascript">ComComboObject('frm_accl_type_cd'	, 2, 122 , 1)</script></td>
				</tr>
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