<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1202.jsp
*@FileTitle : Notification User Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.26 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1202Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1202Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt1202Event)request.getAttribute("Event");
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
<title>Basic Tariff Detail(s) Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_dmdt_de_term_cd" , "", "CD03257", 0, "")%>

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
<input type="hidden" name="pagerows">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">

<input type="hidden" name="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd">
<input type="hidden" name="dmdt_de_term_cd">
<input type="hidden" name="dmdt_de_term_nm">
<input type="hidden" name="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd">
<input type="hidden" name="org_dest_loc_cd">
<input type="hidden" name="dmdt_trf_cd_list">
<input type="hidden" name="dmdt_cntr_cgo_list">

<input type="hidden" name="code1" value="CD02053"><!-- DEM/DET CONTAINER CARGO TYPE CODE -->
<input type="hidden" name="code2" value="CD01963"><!-- DEM/DET CARGO TYPE CODE -->

<input type="hidden" name="srch_apro_usr_id">
<input type="hidden" name="srch_apro_path_cd" value="V.P">

<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<table class="search"> 
       		<tr><td class="bg">
				<div id="showMin" style="display: inline"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Coverage</td>
					<td width="60" class="stm">Continent</td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('combo1', 2, 60 , 0, 1, 0, true)</script></td>
					<td width="55" class="stm">Country</td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('combo2', 2, 60 , 0, 1, 0, true)</script></td>
					<td width="45" class="stm"><span id="Region">Region</span></td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('combo3', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="55" class="stm">Location</td>
					<td width="80">&nbsp;<input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60;" class="input" value="" dataformat="engup" style="ime-mode:disabled" OnKeyUp= "checkLocation1(this)" onKeyPress="ComKeyOnlyAlphabet('upper')"></td>
					<td width="30" class="stm">Yard</td>
					<td width="135">&nbsp;<input type="text" id="yd_cd1" name="yd_cd1" style="width:60;" class="input" value="" dataformat="engup" maxlength="5"  style="ime-mode:disabled" OnKeyUp="checkYard1(this)" onKeyPress="ComKeyOnlyAlphabet('upper')" >&nbsp;<script language="javascript">ComComboObject('combo4', 2, 50 , 0, 0, 0, true)</script></td>	
					<td             class="stm">BKG Term&nbsp;<script language="javascript">ComComboObject('combo5', 2, 60, 1, 1, 0, true);</script></td></tr>
					</tr> 
					<tr class="h23">
					<td width="">&nbsp;&nbsp;Origin/Dest.</td>
					<td width="60" class="stm">Continent</td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('combo6', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="55" class="stm">Country</td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('combo7', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="45" class="stm"><span id="Region2">Region</span></td>
					<td width="80">&nbsp;<script language="javascript">ComComboObject('combo8', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="55" class="stm">Location</td>
					<td width="80">&nbsp;<input type="text" id="org_dest_loction" name="org_dest_location"  caption="Location" maxlength="5" fullfill style="width:60;" class="input" value="" dataformat="engup" style="ime-mode:disabled" OnKeyUp= "checkLocation2(this)" onKeyPress="ComKeyOnlyAlphabet('upper')"></td>
					</tr>
					</table> 
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="75">&nbsp;&nbsp;Tariff Type</td>
						<td width="320" > &nbsp;<script language="javascript">ComComboObject('combo9', 2, 264 , 0, 1)</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width="130">&nbsp;Exist&nbsp;
							<select name="exist" style="width:75;" class="input" >
								<option value="A" selected>All</option>
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>
						</td>
						<td width="">&nbsp;&nbsp;PIC TEAM&nbsp;
							<select name="exp_ofc_cd" style="width:80;" class="input" >
								<option value="All" selected>All</option>
								<option value="HAMRUS">HAMRUS</option>
								<option value="NYCRAS">NYCRAS</option>
								<option value="SELCMA">SELCMA</option>
								<option value="SELCMB">SELCMB</option>
								<option value="SELCMU">SELCMU</option>
								<option value="SELCMI">SELCMI</option>
								<option value="SHARCS">SHARCS</option>
								<option value="SINRSS">SINRSS</option>
							</select>
						</td>
					</tr>
					</table> 
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="130">&nbsp;&nbsp;CNTR & Cargo Type</td>
						<td width="" colspan="5">&nbsp;<script language="javascript">ComComboObject('combo10', 2, 362 , 0)</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					</tr>
					</table> 
					
					<table class="search_sm2" border="0" style="width:520;">
					
					<tr class="h23">
						<td width="70">&nbsp;Validity</td>
						<td width="100" class="stm"><input type="checkbox" name="validity1" value="Y" class="trans" checked>&nbsp;Current</td>
						<td width="900" class="stm"><input type="checkbox" name="validity2" value="Y" class="trans" checked>&nbsp;To-be</td>
					</tr>
				    </table>
				<!--  biz_1  (E) --></div>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>					
					<!-- Grid (E) -->

				
		
<!-- : ( Search Options ) (E) -->
 
			
			
					
					<!--  Button_Sub (S) -->
					
	    			<!-- Button_Sub (E) -->
					<!-- biz_4 (E) -->
					
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_user_update" name="btn_user_update">User Update</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
   
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>