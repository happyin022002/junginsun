<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0019.jsp
	 *@FileTitle : Detail_Yearly Expense
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.17
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.04.17 최정미
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
<%@ page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0019Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0019Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	String strPopup = request.getParameter("popup") == null ? "N" : request.getParameter("popup");
	String getYear = request.getParameter("popYear");
	String getLang = request.getParameter("popLang");
	String getBuCd = request.getParameter("popBuCd");
	String getOfcCd = request.getParameter("popOfcCd");
	String getExpnCd = request.getParameter("popExpnCd");
	String usrAuthTpCd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		usrAuthTpCd = account.getUsr_auth_tp_cd();
		event = (CpsGem0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>

<%@page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO"%><html>
<head>
<title>Detail_Yearly Expense</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
function setupPage(year){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	
	loadPage(year);
}
</script>
</head>

<body onLoad="setupPage('<%=DateTime.getYear()%>');">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="sch_expense_from">
<input type="hidden" name="sch_expense_to">
<input type="hidden" name="sch_expense_group">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="auth_flg">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_tic_cd">
<!-- 이전화면에서getParam -->
<input type="hidden" name="popup" value="<%=strPopup %>">
<input type="hidden" name="popYear" value="<%=getYear %>">
<input type="hidden" name="popLang" value="<%=getLang %>">
<input type="hidden" name="popBuCd" value="<%=getBuCd %>">
<input type="hidden" name="popOfcCd" value="<%=getOfcCd %>">
<input type="hidden" name="popExpnCd" value="<%=getExpnCd %>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<%if("Y".equals(strPopup)) { %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Detail _ Yearly Expense (After/Before Closing)</td></tr>
		</table>
		<%} else { %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<%} %>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->

		<table class="search">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr>
						<td width="" align="right">
						<table class="search" border="0"
							style="width: 110; background-color: #E9E9E9;">
							<tr class="h23">
								<td>
									<input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;
									<input type="radio" value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Mandatory Condition</td>
					</tr>
				</table>

				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>


				<table class="grid2" border="0" width="979">
					<tr class="tr2_head">
						<td width="25%">Year</td>
						<td width="25%">Condition</td>
						<td width="25%">Target</td>
						<td width="25%">CUR</td>
					</tr>
					<tr>
						<td style="padding: 5 0 5 10" class="stm" valign="top" align="center"><br>&nbsp;
							<input type="text" style="width:50; text-align: center" class="input1" name="sch_yrmon" maxlength="4" required fullfill minnum="1900" maxnum="2050" caption="Year">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="sch_yrmon_cal" width="19" height="20" alt="" border="0" align="absmiddle">
						</td>
						<td style="padding: 5 0 5 10" width="" class="stm" valign="top">&nbsp;
							<input type="radio" value="Y" name="sch_condition" class="trans" onclick="isCondition(this);" checked>Yearly Expense<br><br>&nbsp;&nbsp;
							<input type="radio" value="R" name="sch_condition" class="trans" onclick="isCondition(this);">Request expense of Initial
						</td>
						<td style="padding: 5 0 5 10" width="" class="stm" valign="top">&nbsp;
							<input type="radio" value="EI" name="sch_target" class="trans" onclick="isTargetChange(this.name, this.value);">Initial (Summarized)<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="ED" name="sch_target" class="trans" onclick="isTargetChange(this.name, this.value);">Detail for RQST NO<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="EA" name="sch_target" class="trans">Additional<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="ET" name="sch_target" class="trans">Transfer<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="PE" name="sch_target" class="trans" checked>Final
						</td>
						<td style="padding: 5 0 5 10" width="" class="stm" valign="top">&nbsp;
							<input type="radio" value="LCL" name="sch_cur" class="trans" checked>LCL<br><br>&nbsp;&nbsp;
							<input type="radio" value="USD" name="sch_cur" class="trans">USD<br><br>&nbsp;&nbsp;
							<input type="radio" value="KRW" name="sch_cur" class="trans">KRW
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Optional Condition</td>
					</tr>
				</table>
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr class="h23">
						<td width="450" class="stm">
							<input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;
							<input type="checkbox" value="N" class="trans" name="sch_hohq_gbn"  onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl')">HO&nbsp;
							<input type="checkbox" value="Y" class="trans" name="sch_hohq_gbn"  onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl')">HQ&nbsp;&nbsp;&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');"></select>&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');"></select>&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl3" onchange="focusOut();" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','3','document.form.sch_lvl');"></select>&nbsp;
						</td>
						<td width="40">Office</td>
            			<td width="100">
                   		<input type="text" style="width:70;text-align: center;ime-mode:disabled;" class="input" name="ofc_expn_cd" maxlength="6" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
               			</td>											
						<td width="45">Expense&nbsp;</td>
						<td class="stm"><script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script>&nbsp;~&nbsp;<script language="javascript">ComComboObject("combo2", 2, 70, 0, 0, 0, true);</script></td>
					</tr>
				</table>
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="grid2" border="0" width="979">
					<tr class="tr2_head">
						<td width="16%">Expense Group</td>
						<td width="16%">TIC</td>
						<td width="17%">Salary</td>
						<td width="17%">Company</td>
						<td width="17%">Level</td>
						<td width="17%">Status</td>
					</tr>
					<tr>
						<td style="padding: 5 0 5 10" class="stm" valign="top" align="center"><br>&nbsp;
							<script language="javascript">ComComboObject("combo3", 2, 70, 1, 0, 0, true);</script>
						</td>
						<td style="padding: 5 0 5 10" class="stm" valign="top" align="center"><br>&nbsp;
							<select style="width: 70;" class="input" name="sch_tic_cd" onchange="comFocusChange('document.form.sch_slay_flg[0]');focusOut();"></select>
						</td>
						<td style="padding: 5 0 5 10" class="stm" valign="top">&nbsp;
							<input type="radio" value="" name="sch_slay_flg" class="trans" checked>All<br><br>&nbsp;&nbsp;
							<input type="radio" value="Y" name="sch_slay_flg" class="trans">Yes<br><br>&nbsp;&nbsp;
							<input type="radio" value="N" name="sch_slay_flg" class="trans">No
						</td>
						<td style="padding: 5 0 5 10;" class="stm" valign="top">&nbsp;
							<input type="radio" value="" name="sch_com_div" class="trans" checked>All<br><br>&nbsp;&nbsp;
							<input type="radio" value="O" name="sch_com_div" class="trans">Own<br><br>&nbsp;&nbsp;
							<input type="radio" value="S" name="sch_com_div" class="trans">Subsidiary
						</td>
						<td style="padding: 5 0 5 10" class="stm" valign="top">&nbsp;
							<input type="radio" value="" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn0">All<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="RQ" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn1">RQST<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="HQ" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn2">RHQ/BU<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="TC" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn3">TIC<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="CO" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn4">COM
						</td>
						<td style="padding: 5 0 5 10" class="stm" valign="top">&nbsp;
							<input type="radio" value="" class="trans" name="sch_status" id="sch_status0">All<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="RQ" class="trans" name="sch_status" id="sch_status1">Request<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="AD" class="trans" name="sch_status" id="sch_status2">Adjustment<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="RJ" class="trans" name="sch_status" id="sch_status3">Reject<br>
							<img src="/img/tm.gif" width="1" height="5" alt="" border="0"><br>&nbsp;&nbsp;
							<input type="radio" value="AP" class="trans" name="sch_status" id="sch_status4">Approval
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		
		<!-- Grid BG Box  (S) --> 
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
                <td align="left" width=""><span id="sp_commit" style="display: none;"><input type="checkbox" class="trans" name="chk_commit" value="Y" checked="checked">Committee</span></td>			
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- 
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Popup">Popup</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						-->
						<%if("Y".equals(strPopup)) { %>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<%} %>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<table width="100%" id="mainTable" style="display: none">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
					<tr>
						<td><script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
					<tr>
						<td><script language="javascript">ComSheetObject('sheet3');</script></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr><td height="53""></td></tr>
		</table>
		<!--Button (E) --> 
		<!--biz page (E)-->
		</td>
	</tr>	
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>