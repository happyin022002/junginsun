<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0556.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0556Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0556Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0556Event)request.getAttribute("Event");
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
<title>Ancs ACI: Vessel Arrival Manifest (A6)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="port_cd">

<!-- 개발자 작업	-->
<%
	String vvd     = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String portCd     = (request.getParameter("port_cd") == null)? "":request.getParameter("port_cd");
%>


<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp;Wharfage Commission Invoice (화물입항료 대납경비 청구서)</span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search">
       			<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="grid2" border="0" style="width:979;">
				<tr class="h23">
					<td width="80" class="tr2_head">
						<select name="whf_ntc_flg" style="width:100%;"><option value="Y">허가 일자</option>
																	   <option value="N" selected>납기 일자</option>
						</select>														   
					</td>
					<td width="210" class="sm">
					<input type="text"
						style="width: 75; ime-mode: disabled" class="input1" value=""
						dataformat="ymd" maxlength="10" name="whf_ntc_dt1" dataformat="eng" caption="ETA" cofield="whf_ntc_dt2" >
					&nbsp;~&nbsp; <input type="text"
						style="width: 75; ime-mode: disabled" class="input1" value=""
						dataformat="ymd" maxlength="10" name="whf_ntc_dt2" dataformat="eng" caption="ETA" cofield="whf_ntc_dt1">
					<img src="img/btns_calendar.gif" width="19" height="20" alt=""
						border="0" align="absmiddle" class="cursor" name="btn_calendar">
					</td>
					<td width="100" class="tr2_head">수출/입</td>
					<td width="150" class="stm">
						<input type="radio" value="A" class="trans" checked="checked" name="whf_bnd_cd">전체&nbsp;
                        <input type="radio" value="I" class="trans" name="whf_bnd_cd">수입&nbsp;
                        <input type="radio" value="O" class="trans" name="whf_bnd_cd">수출</td>
					<td width="60" class="tr2_head">항만</td>
					<td width="" class="stm" colspan="3" border="0">
						<table border="0" class="noinput" >
						<tr><td >
						<input type="radio" value="A" class="trans" checked="checked" name="port_nm">전체&nbsp;
						<input type="radio" value="감천항" class="trans" name="port_nm">감천항&nbsp;
						<input type="radio" value="북항" class="trans" name="port_nm">북항&nbsp;
						<input type="radio" value="인천항" class="trans" name="port_nm">인천항&nbsp;
						<input type="radio" value="광양항" class="trans" name="port_nm">광양항&nbsp;
						<input type="radio" value="신항" class="trans" name="port_nm">신항&nbsp;
						</td></tr>
						<tr><td>
						<input type="radio" value="울산항" class="trans" name="port_nm">울산항
						<input type="radio" value="평택항" class="trans" name="port_nm">평택항
						</td></tr>
						</table>
					</td>
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">청구월</td>
					<td width="" class="stm"><input type="text" style="width:100%" name="demand_month" maxlength="20" dataformat="ennum" class="input" ></td>
					<td width="" class="tr2_head">투자비보전(정산월)</td>
					<td width="" class="stm"><input type="text" style="width:100%" name="calculate_month" maxlength="6" dataformat="ennum" class="input" ></td>
					<td width="" class="tr2_head">대표자</td>
					<td width="40" class="stm"><input type="text" style="width:130" name="represent" maxlength="14" dataformat="ennum" class="input" ></td>
					<td width="" class="tr2_head">전화번호</td>
					<td width="50" class="stm"><input type="text" style="width:150" name="phone_num" maxlength="20" dataformat="ennum" class="input" ></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				</td></tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
     			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
					<tr>
						<td width="100%">
							<script language="javascript">ComTabObject('tab1')</script>
						</td>
					</tr>
				</table>
			<!-- Tab (E) -->


			<table class="search">
       			<tr><td class="bg">
		<div id="tabLayer" style="display:inline">
			<table id="rdTable" width="980" height="379">
				<tr>
					<td><script language="javascript">
					comRdObject('report1');
					//comRdObjectPopup("report1");
					</script></td>
				</tr>
			</table>
		</div>
		<div id="tabLayer" style="display:none">
			<!-- grid (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td><!--
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					--></tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>

				</td></tr>
			</table>

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>