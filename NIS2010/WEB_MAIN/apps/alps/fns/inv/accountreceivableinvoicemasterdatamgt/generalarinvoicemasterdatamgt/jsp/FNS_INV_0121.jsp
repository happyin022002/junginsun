<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0121.jsp
*@FileTitle : Revenue & Processing VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 1.0 Creation
* 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0121Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0121Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.GeneralARInvoiceMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0121Event)request.getAttribute("Event");
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
<title>Revenue & Progressing VVD Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="option_value">
<input type="hidden" name="yrmon_fm">
<input type="hidden" name="yrmon_to">
<input type="hidden" name="del_cd">
<input type="hidden" name="s_vvd_cd">
<input type="hidden" name="s_slan_cd">
<input type="hidden" name="s_rlane_cd">
<input type="hidden" name="s_estm_bc_div_cd">
<input type="hidden" name="s_estm_vvd_tp_cd">
<input type="hidden" name="code">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
    <td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		
		<div id="showREV" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="35">Option</td>
							<td width="155"><select name="r_option_value" style="width:100;" class="input1" onchange="changeOption()">
								<option value="REV" selected>Revenue</option>
								<option value="PRD">Progressing</option>
								</select>
							</td>
							
							<!-- Option Value = Revenue  -->
							<td width="38">Month</td>
							<td width="241"><input type="text" style="width:55;" class="input1" name="r_yrmon_fm" maxlength="7" dataformat="ym"  >
								<img src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" align="absmiddle" style="cursor:hand">&nbsp;~&nbsp;
								<input type="text" style="width:55;" class="input1" name="r_yrmon_to" maxlength="7" dataformat="ym">
								<img src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" align="absmiddle" style="cursor:hand"></td>
							<td width="56">DEL</td>
							<td width="428"><select name="r_del_cd" style="width:100;" class="input1">
								<option value="N" selected>No</option>
								<option value="Y">Yes</option>
								<option value="ALL">ALL</option>
								</select>
							</td>
						</tr>
						<tr class="h23">
							<td width="35">VVD</td>
							<td width="155"><input type="text" id="r_s_vvd_cd" name="r_s_vvd_cd" maxlength="10" style="width:98;" dataformat="engup" class="input"></td>
							<td width="38">S/LANE</td>
							<td width="241"><input type="text" id="r_s_slan_cd" name="r_s_slan_cd" maxlength="3" style="width:100;" dataformat="engup" class="input" value=""></td>
							<td width="56">R/LANE</td>
							<td width="428"><input type="text" id="r_s_rlane_cd" name="r_s_rlane_cd" maxlength="5" style="width:98;" dataformat="engup" class="input" value=""></td>
						</tr>
					</table>
					<table class="line_bluedot">
						<tr>
							<td colspan="8"></td>
						</tr>
					</table>
            <!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            	</td>
			</tr>
		</table>
		</div>

		<div id="showPRD" style="display: none">

		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="35">Option</td>
							<td width="155"><select name="p_option_value" style="width:100;" class="input1" onchange="changeOption()">
								<option value="REV">Revenue</option>
								<option value="PRD">Progressing</option>
								</select>
							</td>
							<!-- Option Value = Revenue  -->
							<td width="38">Month</td>
							<td width="241"><input type="text" style="width:55;" class="input1" name="p_yrmon_fm" maxlength="7" dataformat="ym"  >
								<img src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" align="absmiddle" style="cursor:hand">&nbsp;~&nbsp;
								<input type="text" style="width:55;" class="input1" name="p_yrmon_to" maxlength="7" dataformat="ym">
								<img src="img/btns_calendar.gif" name="btns_calendar4" width="19" height="20" align="absmiddle" style="cursor:hand"></td>
							<td width="56">Type</td>
							<td width="428"><!-- <select name="p_s_estm_bc_div_cd" style="width:100;" class="input1">
								<option value="ALL" selected>ALL</option>
								<option value="C">Container</option>
								<option value="B">Bulk</option>
								</select> -->
								<script language="javascript">ComComboObject('bc_div_cd',2,100,1,1,0,true);</script>
							</td>
						</tr>
						<tr class="h23">
							<td width="35">VVD</td>
							<td width="155"><input type="text" id="p_s_vvd_cd" name="p_s_vvd_cd" maxlength="10" style="width:98;" dataformat="engup" class="input"></td>
							<td width="38">Type</td>
							<td width="241"><!-- <select name="p_s_estm_vvd_tp_cd" style="width:100;" class="input1">
								<option value="ALL" selected>ALL</option>
								<option value="RV">RV</option>
								<option value="BV">BV</option>
								<option value="PV">PV</option>
								</select> -->
								<script language="javascript">ComComboObject('vvd_tp',2,100,1,1,0,true);</script>
							</td>
							<td width="56">R/LANE</td>
							<td width="428"><input type="text" id="p_s_rlane_cd" name="p_s_rlane_cd" maxlength="5" style="width:98;" dataformat="engup" class="input" value=""></td>
						</tr>
					</table>
					<table class="line_bluedot">
						<tr>
							<td colspan="8"></td>
						</tr>
					</table>
            <!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
            <!-- Grid (E) -->
            <!--  Button_Sub (S) -->
            	</td>
			</tr>
		</table>
		</div>
		
		
		<!-- Tab BG Box(E) -->
		<!--biz page (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
			<tr>
				<td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
				            		<td class="btn1_left"></td>
									<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" id="btn_New" name="btn_New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">DownExcel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
      	</table>
      <!--Button (E) -->
	</td>
</tr>
</table>
</body>
</html>
