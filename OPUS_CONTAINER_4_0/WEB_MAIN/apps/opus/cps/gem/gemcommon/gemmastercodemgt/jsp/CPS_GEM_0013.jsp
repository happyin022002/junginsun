<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0013.jsp
	 *@FileTitle : Expense Matrix per Office
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.07
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.05.07 최정미
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0013Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0013Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Expense Matrix per Office</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="hdn_ofc_cd">
<input type="hidden" name="sch_expn_group">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="155">
							<input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;
							<input type="checkbox" value="N" class="trans" name="sch_hohq_gbn"  onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl')">HO&nbsp;
							<input type="checkbox" value="Y" class="trans" name="sch_hohq_gbn"  onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl')">HQ
						</td>
						<td width="295" align="left">
							<select style="width: 75;" class="input" name="sch_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');"></select>&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');"></select>&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl3" onchange="focusOut();" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','3','document.form.sch_lvl');"></select>&nbsp;
						</td>
						<td nowrap="nowrap">
						<table class="search_sm2" border="0" style="width: 98%;">
							<tr class="h23">
								<td>
									<input type="radio" value="Y" class="trans" name="sch_office_gbn" onclick="isOfficeGubun(this.value);">Office&nbsp;
									<input type="radio" value="N" class="trans" name="sch_office_gbn" onclick="isOfficeGubun(this.value);">Expense&nbsp;
									<input type="text" style="width: 70; text-align: center" class="input" name="sch_office_code" disabled="disabled" maxlength="6" style="ime-mode:disabled">
								</td>
							</tr>
						</table>
						</td>
						<td nowrap="nowrap">Expense Group</td>
						<td nowrap="nowrap"><script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script></td>
						<td nowrap="nowrap">
						<table class="search_sm2" border="0" style="width: 98%;">
							<tr class="h23">
								<td>
									<input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;&nbsp;
									<input type="radio" value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
								</td>								
							</tr>
						</table>
						</td>
						<!-- 
						<td nowrap="nowrap" align="right">Deleted Data<input type="checkbox" value="Y" class="trans" name="sch_delt_flg" onclick="isDeltFlg(this);"></td>
						-->
					</tr>
				</table>			
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_1  (E) -->

				<!-- Grid  (S) -->
				<table class="search" border="0">
					<tr class="h23">
						<td width="48%" valign="top">
						<!-- Grid1  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- Grid1 (E) -->
						</td>
						<td width="4%">&nbsp;</td>
						<td width="48%" valign="top">
						<!-- Grid2  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- Grid2 (E) -->
						</td>
					</tr>
				</table>
				
				
				<table class="search" border="0">
					<tr class="h23">
						<td align="right">Expense Code Inquiry&nbsp;<img src="img/btns_search.gif" name="btn_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand"></td>
					</tr>
				</table>
				<!-- Grid (E) -->
				</td>
			</tr>
		</table>
		
		<!-- Grid BG Box  (S) --> 
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
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
					</tr>
				</table>
				</td>
			</tr>
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