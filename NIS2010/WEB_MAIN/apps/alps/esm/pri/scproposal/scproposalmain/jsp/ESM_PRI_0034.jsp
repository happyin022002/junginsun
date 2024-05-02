<%
/*===============================================================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0034.jsp
 *@FileTitle : S/C Download Record Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.01.10
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 
 * 1.0 Creation 
 ===============================================================================================
 * History
 * 2018.01.10 최초생성 송민석 
===============================================================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0034Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSpMnVO"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri0034Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strUsrSrepCd = "";
	String strUsr_emal = "";
	String propNo = null;
	String searchFlg = null;
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		strUsr_emal = account.getUsr_eml();
		event = (EsmPri0034Event) request.getAttribute("Event");

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..		
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
			
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Download Record</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		ComShowMessage(errMessage);
	} // end if
	loadPage();
}


<%=JSPUtil.getIBCodeCombo("s_print_event_tp_cd", "", "CD03454", 0, "")%>   // sp print event type code
<%=JSPUtil.getIBCodeCombo("s_scrn_prog_cd", "", "CD03561", 0, "")%>   // sp screen program code
<%=JSPUtil.getIBCodeCombo("s_cust_tp_cd", "", "CD01714", 0, "")%>   // Cutomer Type Code

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="prop_no">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel" id="btn_new">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<!-- 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_opensc" id="btn_opensc">Open S/C</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_amdhistory" id="btn_amdhistory" >AMD History</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					 -->
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		
<!--biz page (S)-->
		<table class="search">
						<tr>
							<td class="bg">
								<!-- biz_1  (S) -->
								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
									
							<td width="" valign="top">
								<table class="search_sm2" border="0" style="width:860;"> 
									<tr class="h23">
										<td width="150"><nobr><input type="radio" name="rdoDate" value="2" class="trans" checked>Log Time By</nobr></td>
										<td width="100"><script language="javascript">ComComboObject('s_cur_tp_cd',1,100,1,1,0);</script>
										<td width="10"></td>
										<td width="180">
								    <nobr>
								    <input type="text" class="input1" style="width:71;text-align:center" caption="Screen Open From Date" name="scrn_date_from" cofield="scrn_date_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								    ~
								    <input type="text" class="input1" style="width:71;text-align:center" caption="Screen Open To Date" name="scrn_date_to" cofield="scrn_date_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								    </nobr>
										</td>
									<td width = "50"></td>
									<td width="200"><input type="radio" name="rdoDate" value="1" class="trans">S/C Effective Date</td>
									<td width="180">
								    	<nobr>
								   		<input type="text" class="input" style="width:71;text-align:center" caption="S/C Effective From Date" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar3" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								   		 ~
								   	 	<input type="text" class="input" style="width:71;text-align:center" caption="S/C Effective To Date" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar4" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								   	 	</nobr>
								</td>
							</tr> 
						</table>
					</td>
										<td width="109"></td>
									</tr>
								</table>


								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
									
										<td width="25"></td>
										<td width="60">S/C No.</td>
										<td width="100" style="padding-left: 1;">
										<input type="text" style="width: 100; text-align: center;" name="sc_no" maxlength="9" class="input" dataformat="engup">
										</td>
										
										<td width="72"></td>
										
										<td width="60">Amd No.</td>
										<td width="100" style="padding-left: 1;">
										<input type="text" class="input" style="width: 100;" size="20" maxlength="3"  name="amdt_seq" dataformat="int">
										</td>
										
										<td width="49"></td>
										
										<td width="80">Login OFC</td>
										<td width="130"><input type="text" name="lgin_ofc" style="width:84;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6">
										<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget1"></td>
										

										<td width="30"></td>
										<td width="120">S/C Contract OFC</td>
										<td width="130"><input type="text" name="prop_ofc_cd" style="width:84;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6">
										<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"></td>
										<td width="23"></td>
									</tr>
								</table>

								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="25"></td>
										<td width="100">Customer Name</td>
										<td width="100" style="padding-left: 1;">
										<input type="text" name="cust_nm" style="width:100;text-align:left;" class="input" maxlength="100" dataformat="engup">
										</td>

										<td width="30"></td>
										<td width="100">Customer Type</td>
										<td width="100"><script language="javascript">ComComboObject('s_cust_tp_cd',1,100,1,0,0);</script>

										<td width="63"></td>
										<td width="60">Screen</td>
										<td width="200"><script language="javascript">ComComboObject('s_scrn_prog_cd',1,200,1,0,0);</script>
										</td>
										<td width="201"></td>
									</tr>
							
								</table>
					</table>
					
						<table class="height_10"><tr><td></td></tr></table>
						<!-- : ( Seq. ) (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>
	</table>

<!-- 개발자 작업  끝 -->


</form>
</body>
</html>