<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0008_02.jsp
	 *@FileTitle : Expense Office Maintenance - Expense Matrix per Office
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.27
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.05.27 최정미
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
<%@ page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem000802Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem000802Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem000802Event)request.getAttribute("Event");
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
<title>Expense Office Maintenance - Expense Matrix per Office</title>
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
<input type="hidden" name="sch_expn_group">
<input type="hidden" name="hdn_ofc_cd">
<input type="hidden" name="hdn_sls_ofc_flg">

<!-- Search (S) -->
<table class="search">
	<tr>
		<td class="bg">				
		<!--  biz_2  (S) -->
		<table class="search" border="0" style="width: 100%;">
			<tr class="h23">
				<td width="45%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td width="15%">
							<input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;
							<input type="checkbox" value="N" class="trans" name="sch_hohq_gbn"  onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl')">HO&nbsp;
							<input type="checkbox" value="Y" class="trans" name="sch_hohq_gbn"  onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl')">HQ
						</td>
						<td width="" align="left">
							<select style="width: 75;" class="input" name="sch_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');"></select>&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');"></select>&nbsp;
							<select style="width: 75;" class="input" name="sch_lvl3" onchange="focusOut();" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','3','document.form.sch_lvl');"></select>&nbsp;
						</td>
					</tr>
				</table>
				</td>
				<td width="2%"></td>
				<td width="20%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td>
							<input type="radio" value="Y" class="trans" name="sch_office_gbn" id="sch_office_gbn1" onclick="isOfficeGubun(this.value);">Office&nbsp;
							<input type="radio" value="N" class="trans" name="sch_office_gbn" id="sch_office_gbn2" onclick="isOfficeGubun(this.value);">Expense&nbsp;
							<input type="text" style="width: 70; text-align: center" class="input" name="sch_office_code" disabled="disabled" maxlength="6" style="ime-mode:disabled">
						</td>
					</tr>
				</table>
				</td>
				<td width="2%"></td>
				<td width="20%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td nowrap="nowrap">Expense Group</td>
						<td nowrap="nowrap"><script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script></td>
					</tr>
				</table>
				</td>				
				<td width="">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td>
							<input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;&nbsp;
							<input type="radio" value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
						</td>								
					</tr>
				</table>
				</td>				
			</tr>
			<tr><td colspan="6" height="3"></td></tr>
			<tr class="h23">
				<td colspan="5">Expense Matrix Copy&nbsp;<img src="img/btns_search.gif" name="matrix_copy_btn" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand;"></td>
				<td nowrap="nowrap" align="right">Deleted Data<input type="checkbox" value="Y" class="trans" name="sch_delt_flg" onclick="isDeltFlg(this);"></td>
			</tr>
		</table>
		<table class="line_bluedot">
			<tr>
				<td colspan="6"></td>
			</tr>
		</table>	
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
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) -->
				</td>
			</tr>
		</table>		
		<!--  biz_2   (E) -->		
		</td>
	</tr>
</table>
<!-- Search (E) --> 

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
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>