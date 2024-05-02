<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0008_01.jsp
	 *@FileTitle : Expense Office Maintenance - Office Code
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
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem000801Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem000801Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem000801Event)request.getAttribute("Event");
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
<title>Expense Office Maintenance - Office Code</title>
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
<input type="hidden" name="sch_sumup_office">

<!-- Search (S) -->
<table class="search">
	<tr>
		<td class="bg">
		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width: 100%">
			<tr class="h23">
				<td width="42%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td width="15%">
							<input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;
							<input type="checkbox" value="N" class="trans" name="sch_hohq_gbn" id="sch_hohq_gbn1" onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');">HO&nbsp;
							<input type="checkbox" value="Y" class="trans" name="sch_hohq_gbn" id="sch_hohq_gbn2" onclick="setHOHQ(this,'document.form.sch_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');">HQ
						</td>
						<td width="" align="left">
							<table border="0">
								<tr>
									<td><select style="width: 75;" class="input" name="sch_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');"></select></td>
									<td><select style="width: 75;" class="input" name="sch_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');"></select></td>
									<td><select style="width: 75;" class="input" name="sch_lvl3" onchange="focusOut();" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','3','document.form.sch_lvl');"></select></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</td>				
				<td width="30%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td><input type="radio" value="Y" class="trans" name="sch_office_gbn" onclick="isOfficeGubun(this.value);">Office</td>
						<td><input type="radio" value="C" class="trans" name="sch_office_gbn" onclick="isOfficeGubun(this.value);">Center</td>
						<td><input type="radio" value="N" class="trans" name="sch_office_gbn" onclick="isOfficeGubun(this.value);">Parent</td>						
						<td><input type="text" style="width: 70; text-align: center; " class="input" name="sch_office_code" disabled="disabled" maxlength="6" style="ime-mode:disabled"></td>
					</tr>
				</table>
				</td>
				<td width="8%">Office Level</td>
				<td width="9%">
					<select style="width: 75;" class="input" name="sch_office_lvl" onchange="comFocusChange('document.form.sch_com_div');focusOut();">
						<option value="" selected></option>
						<option value="1">LEVEL1</option>
						<option value="2">LEVEL2</option>
						<option value="3">LEVEL3</option>
						<option value="4">LEVEL4</option>
					</select>
				</td>
				<td width="5%">COM</td>
				<td width="8%">
					<select style="width: 85;" class="input" name="sch_com_div" onchange="comFocusChange('document.form.sch_app_div_gbn[0]');focusOut();">
						<option value="" selected></option>
						<option value="O">Own</option>
						<option value="S">Subsidiary</option>
						<option value="E">Etc</option>
					</select>
				</td>
			</tr>
			<tr><td height="3"></td></tr>
			<tr class="h23">
				<td width="42%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td width="90">Approval DIV</td>
						<td class="stm">
							<input type="checkbox" value="0" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn0" onclick="comAllCheckGubun(this);">All&nbsp;&nbsp;
							<input type="checkbox" value="1" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn1" onclick="comAllCheckGubun(this);">RQST&nbsp;
							<input type="checkbox" value="2" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn2" onclick="comAllCheckGubun(this);">RHQ |BU&nbsp;
							<input type="checkbox" value="3" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn3" onclick="comAllCheckGubun(this);">TIC &nbsp;
							<input type="checkbox" value="4" class="trans" name="sch_app_div_gbn" id="sch_app_div_gbn4" onclick="comAllCheckGubun(this);">COM
						</td>
					</tr>
				</table>
				</td>
				<td width="30%">
				<table class="search_sm2" border="0" style="width: 93%">
					<tr class="h23">
						<td width="30%">&nbsp;&nbsp;&nbsp;Sum UP</td>
						<td width="" class="stm">
							<input type="radio" value="" class="trans" name="sch_sumup_gbn" onclick="isSumupGubun(this);" checked>All&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Y" class="trans" name="sch_sumup_gbn" onclick="isSumupGubun(this);">Office&nbsp;&nbsp;&nbsp;
							<!-- <select style="width: 80;" class="input" name="sch_sumup_office" disabled></select>-->
							<script language="javascript">ComComboObject("combo1", 1, 70, 1, 0, 0, true);</script>
						</td>
					</tr>
				</table>
				</td>
				<td width="" colspan="2">&nbsp;</td>
				<td width="13%" align="right" colspan="2">Deleted Data<input type="checkbox" value="Y" class="trans" name="sch_delt_flg" onclick="isDeltFlg(this);"></td>
			</tr>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!--  biz_1  (E) -->

		<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
			</tr>
		</table>
		<!-- Grid (E) -->
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