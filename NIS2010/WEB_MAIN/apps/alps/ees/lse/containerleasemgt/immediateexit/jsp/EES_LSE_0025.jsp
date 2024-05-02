<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0025.jsp
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.event.EesLse0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPgm_no		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strPgm_no = (String)request.getAttribute("UI_NUMBER");

		event = (EesLse0025Event)request.getAttribute("Event");
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
<title>Immediate Exit Creation</title>
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
<input type="hidden" name="cntr_no_list">

<!-- 개발자 작업	-->
<input type="hidden" name="pgm_no" value="<%= strPgm_no %>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	</td></tr>



	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

	<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80">AGMT No.</td>
					<td width="180"><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:60;text-align:center;" class="input2" value="HHO" readonly>&nbsp;<input type="text" caption="AGMT No." name="agmt_seq" style="width:60" class="input1" value="" maxlength="6" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="85">Contract No.</td>
					<td width="150"><input type="text" name="ctrt_no" style="width:130" class="input2" readonly></td>
					<td width="91">Ref. No.</td>
					<td width="200"><input type="text" name="ref_no" style="width:178" class="input2" readonly></td>
					<td width="70">Lease Term</td>
					<td width=""><input type="text" name="lstm_cd" style="width:35" class="input2" readonly></td>

				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80">Lessor</td>
					<td width="416"><input type="text" name="vndr_seq" style="width:60" class="input2" readonly>&nbsp;<input type="text" name="vndr_nm" style="width:331" class="input2" readonly></td>
					<td width="90">Effective Date</td>
					<td width="200"><input type="text" name="eff_dt" style="width:80;text-align:center;" class="input2" readonly>&nbsp;~&nbsp;<input type="text" name="exp_dt" style="width:80;text-align:center;" class="input2" readonly></td>
					<td width="55">Free Day</td>
					<td width=""><input type="text" name="free_dys" style="width:50;text-align:right" class="input2" readonly></td>
				</tr>
				</table>

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80">AGMT Office</td>
					<td width="180"><input type="text" name="ofc_cd" style="width:60" class="input2" readonly></td>
					<td width="32">LOC</td>
					<td width="50">
						<select name="loc_tp">
							<option value="">ALL</option>
							<option value="1">RCC</option>
							<option value="2">LCC</option>
							<option value="4">SCC</option>
							<option value="5">Yard</option>
	                    </select>
					</td>
					<td width="145"><input type="text" name="loc_cd" style="width:70;text-align:center;" class="input2" value="" maxlength="7" dataformat="engup" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="95"><input type="checkbox" name="chk_cntr" value="Y" class="trans">&nbsp;CNTR No.</td>
					<td width=""><input type="text" name="cntr_no" style="width:120" class="input2" value="" maxlength="14" dataformat="engup" readonly></td>

				</tr>
				</table>
				<!--  biz_1  (E) -->

<!-- : ( Search Options ) (E) -->







			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg" style="height:408;" valign="top">

			<!-- Grid  (S) -->
			<table width="100%"  id="sheetTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				    <tr>
				        <td>
				            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					          <tr>
					              <td class="btn2_left"></td>
					              <td class="btn2" name="btn_loadexcel">Load Excel</td>
					              <td class="btn2_right"></td>
					          </tr>
					        </table>
					    </td>				        
				        <td>
				            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					          <tr>
					              <td class="btn2_left"></td>
					              <td class="btn2" name="btn_downExcel">Down Excel</td>
					              <td class="btn2_right"></td>
					          </tr>
					        </table>
					    </td>
					</tr>
			    </table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    </td></tr>
		</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrive">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>