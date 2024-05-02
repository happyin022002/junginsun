<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_COA_0022.jsp
*@FileTitle : MTY Reposition Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.12.07 송호진
* 1.0 Creation
=========================================================
* History
* 2012.12.13 송호진 [CHM-201221879] [COA] Manual Cost Set up 화면 로직 수정 ( 파일 신규 생성 )
* 2013.02.19 서미진 [CHM-201323054] Creation Date 기준 MT Invoicing AMT 컬럼 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.event.EsmCoa0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.CostSetUp");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0022Event)request.getAttribute("Event");
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
<title>MTY Reposition Cost Detail</title>
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
<input type="hidden" name="f_cost_yrmon" value="<%=JSPUtil.getNull(request.getParameter("cost_yrmon"))%>" >
<input type="hidden" name="f_yrtype" value="M" >
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="930" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	    <table width="100%" border="0" >
	    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; MTY Reposition Cost Detail</td></tr>        
	    </table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;" >
		
	       	<tr><td class="btn1_bg" >

				<table border="0" cellpadding="0" cellspacing="0" align="right">
				<tr>
					<!-- Repeat Pattern -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<!-- 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" id="btn_downexcel" name="btn_create">Create</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" id="btn_save" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					 -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_down_excel" name="btn_down_excel">Down Excel</td>
	                      <td class="btn1_right"></td>
	                    </tr>
	                  	</table>
                  	</td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" cellpadding="0" >
		<tr><td class="bg">
				<!-- : ( Year ) (S) -->
				<table border="0">
				<tr class="h23">
					<td width="10%">YYYY-MM</td>
					<td width="15%"><input type="text" class="input2" name="f_yearweek" style="width:70;text-align:center" value="" maxlength="7" readonly > </td>
	                <td width="150" class='sm'><div id='div_period'></div></td>
	                <td width="200"></td>
	                <td width="330"><input type="text" class="input2" name="f_mty_repo_cre_dt" style="text-align:Right;padding-top:50px;width:300;border:0px;background-color:#F3F2F8;padding-top:3px;" readOnly></td>
				
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- **************** Tab BG Box - 'A' (OutSide) (S) ********************* -->
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<table width="100%" id="mainTable">
					<tr><td>
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (E) -->




</td></tr>
</table>
<!-- Outer Table (E)-->

<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>