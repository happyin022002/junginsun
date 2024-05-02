<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0516.jsp
*@FileTitle : Voyage Performance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.event.VopVsk0516Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	VopVsk0516Event event = null;
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.depositinvoice.depositinvoice");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0516Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
		
	String curr_dt = JSPUtil.getKST("yyyy-MM-dd");
%>
<html>
<head>
<title>Voyage Performance</title>
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
<script language="javascript" for="cntr_dzn_capa" Event="OnChange(Index_Code, Text)">
</script>

</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->

<input type="hidden" name="vsl_flg">
<input type="hidden" name="todate" value="<%=curr_dt%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	

			<!-- biz page (S) -->
			<table class="search" border="0" height="40" style="width:100%;">
				<tr class="h23">
					<td class="bg" width="100%" valign="top">		              
						<table class="height_5"><tr><td></td></tr></table>
						<table border="0" width="100%">
							<tr class="h23" align="center">
								<td width="140" rowspan="3">
									<table class="search_sm2" style="width:130;">
										<tr class="h23">
											<td>Monitoring&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="page_chk" value="monitor" class="trans" checked disabletype="no"></td>
										</tr>
										<tr class="h23">
											<td>Performance&nbsp;&nbsp;<input type="radio" name="page_chk" value="performance" class="trans" disabletype="no" disabled></td>
										</tr>
									</table>
								</td>  	
								<td width="120" align="right">Signal Index&nbsp;&nbsp;</td>
								<td width="180" align="left">
									<table class="search_sm2" border="0" style="width:140;">
										<tr class="h23">
											<td width="140"><img src="/hanjin/img/btng_icon_r.gif" width="15" height="15" border="0" align="absmiddle" ><input type="checkbox" name="signal_idx_red" value="RED" class="trans" checked disabletype="no">
											&nbsp;<img src="/hanjin/img/btng_icon_y.gif" width="15" height="15" border="0" align="absmiddle" ><input type="checkbox" name="signal_idx_yellow" value="YELLOW" class="trans" checked disabletype="no">
											&nbsp;<img src="/hanjin/img/btng_icon_green.gif" width="15" height="15" border="0" align="absmiddle" ><input type="checkbox" name="signal_idx_green" value="GREEN" class="trans" checked disabletype="no"></td>
										</tr>
									</table>
								</td>
								<td align="right">Lane&nbsp;&nbsp;</td>
								<td width="140" align="left">
									<input type="text" style="width:50;text-align:center;ime-mode:disabled;" name="vsl_slan_cd" class="input" maxlength="3" dataformat="engup" disabletype="no">
									<img src="img/btns_search.gif" name="btns_search"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle" disabletype="no">
									

								</td>
								<td align="right">Class&nbsp;&nbsp;</td>
								<td align="left">
									<script language="javascript">ComComboObject('cntr_dzn_capa',1,150,1,0);</script>
								</td>
							</tr>
							<tr class="h23">
								<td align="right">Date&nbsp;&nbsp;</td>   
								<td>
									<input name="curr_dt" type="text" dataformat="ymd" maxlength="8" caption="From Date"  class="input1" style="ime-mode:disabled; width:90px; text-align:center;" value="<%=curr_dt%>" disabletype="no">
									<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
								</td>
								<td align="right">VVD&nbsp;&nbsp;</td>
								<td>
									<input type="text" style="width:90;text-align:center;ime-mode:disabled;" name="vvd" class="input1" maxlength="9" dataformat="engup" disabletype="no" value="">
									<img src="img/btns_search.gif" name="btn_vvd_search"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle" disabletype="no">
								</td>
								<td align="right">Port to Port&nbsp;&nbsp;</td>
								<td><script language="javascript">ComComboObject('vsl_port',1,150,1,0);</script></td>
							</tr>
						</table>
					</td>
					<td width="57" valign="top"></td>
				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>


			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_2 (S) -->
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr class="h23"> 
								<td>
									<table class="search_sm2" border="0" style="width:700;">
										<tr class="h23">
											<td width="90"><input name="sel_schedule" style="border:none;" type="checkbox" value="Y">&nbsp;Schedule</td>
											<td width="100"><input name="sel_navi" style="border:none;" type="checkbox" value="Y">&nbsp;Navigation</td>
											<td width="110"><input name="sel_consum" style="border:none;" type="checkbox" value="Y">&nbsp;Consumption</td>
											<td width="110"><input name="sel_draft" style="border:none;" type="checkbox" value="Y">&nbsp;Condition</td>
											<td width="135"><input name="sel_cargo" style="border:none;" type="checkbox" value="Y">&nbsp;Cargo Operation</td>
										</tr>
									</table>
								</td>
							</tr>		
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!-- biz_2 (E) -->						
						
					</td>
				</tr>
			</table>
			<!-- biz page (E) -->


			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
											<td class="btn1_left">
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right">											
											<td class="btn1_left">
											<td class="btn1" name="btn_DownExcel">Down Excel</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>					
				</tr>
			</table>
			<!-- Button (E) -->


		</td>
	</tr>
</table>

<!-- table class="height_5"><tr><td></td></tr></table -->

<!-- 개발자 작업 끝 -->
</form>
</body>
</html>