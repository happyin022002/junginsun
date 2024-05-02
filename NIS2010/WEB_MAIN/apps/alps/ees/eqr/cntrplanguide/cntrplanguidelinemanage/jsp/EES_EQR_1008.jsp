<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1008.jsp
*@FileTitle : Empty Repo Guideline Creation.
*Open Issues :
*Change history :
*@LastModifyDate : 2013.5.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event.EesEqr1008Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 
	EesEqr1008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String strLcl_dt 		= "";
	String optionStr 		= "000001: :ALL";
	 String main_page 		= "";  //GUIDELINE CREATION/INQUERY화면 구분자 TRUE : GUIDELINE CREATION, FALSE : GUIDELINE INQUERY

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesEqr1008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		main_page = JSPUtil.getParameter(request, "mainPage".trim(), "");
		
		EesEqr1008ConditionVO conditionVO = new EesEqr1008ConditionVO();
		conditionVO = event.getEesEqr1008ConditionVO();
		strLcl_dt = conditionVO.getLclDt();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	// TP/SZ select 박스
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:70;'","CD00263",0,optionStr);
%>
<html>
<head>
<title>Mty Repo Guideline Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    <%= JSPUtil.getIBCodeCombo("glinetp", "01", "CD03221", 0, "")%> // EQUIPMENT GUIDELINE TYPE CODE
   
 // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- // 	
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|O5|S2|S4"; // OT  TYPE SIZE CD00753
    var tpszotCode  = "O2|O4|O5|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4|A5"; // FR  TYPE SIZE CD00754
    var tpszfrCode  = "F2|F4|F5|A2|A4|A5";	
	
//    var consTpsz      = replaceAll(tpszallText, "|", ",");
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,O5,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4,A5";
// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=main_page%>");
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input	type="hidden" name="f_cmd">
	<input type="hidden" name="tpszall" value="">
	<input type="hidden" name="tpcnt" value="">
	<input type="hidden" name="cntr_tpsz_cd" value="" >
	<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
	<input type="hidden" name="h_eta_dt" value="<%=strLcl_dt%>">
	<input type="hidden" name="main_page" value="<%=main_page%>">
	
	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
		<tr>
			<td>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr>
						<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
					</tr>
					<tr>
						<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
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
												<td class="btn1" name="btn_new" id="btn_new">New</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_save" id="btn_save">Save</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>	
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_email" id="btn_email">Send Mail</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>		
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
		    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
		        <!-- TABLE '#D' : ( Search ) (S) -->
		        <table class="search" border="0">
					<tr>
		                <td class="bg">
		                    <table class="search_in" border="0">
								<tr class="h23">
									<td width="65"><input type="radio" name="s_dt_tp_cd" class="trans" checked OnClick="chg_dt_tp();" value="1">Latest</td>
									<td width="70"><input type="text"  name="s_eta_dt"   class="input1" style="width:70;" value="<%=strLcl_dt %>" onFocus="form_focus();" onBlur="form_blur();"></td>
									<td width="80"><input type="radio" name="s_dt_tp_cd" class="trans" OnClick="chg_dt_tp();" value="2">Duration</td>
									<td width="215">
										<input type="text" name="s_eff_st_dt" class="input" style="width:80" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();"> 
										~ 
										<input type="text" name="s_eff_end_dt" class="input" style="width:80" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();">
										<img name="btns_calendar" id="btns_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" >
									</td>
									<td width="40">Trade</td>
									<td width="100">
										<script language="JavaScript">ComComboObject("trade", 2, 80, 0, 0);</script>
									</td>
									<td width="65">Sub Trade</td>
									<td class="input" width="110">
										<script language="JavaScript">ComComboObject("subtrade", 4,90, 0, 0);</script>
									</td>
									<td width="35">Lane</td>
									<td class="input">
										<!-- script language="JavaScript">ComComboObject("lane", 5, 80, 0, 0);</script -->
										<script language="JavaScript">ComComboObject("lane", 2, 80, 0, 0);</script><!-- 정길수 부장님 작업용 -->										
										&nbsp;<input type="text" class="input" name="lane_direct" onKeyUp="upperCase_Num()" size="3" maxlength="3" fulfill size="3" style="width:60;" value="" >
										<img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_Lane">
									</td>
								</tr>
								<tr class="h23">
									<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TP/SZ</td>
									<td ><%= tyszSelectBox %>&nbsp;</td>
									<td colspan="2">
										<script language="javascript">ComComboObject('tpsztype' , 1, 261, 1 )</script>
									</td>
									<td >Status</td>
									<td align ="left" >
										<select name="s_cfm_flg" style="width:80">
										<% if (main_page!=null && main_page.trim().toUpperCase().equals("TRUE")){ %>
											<option value="">ALL</option>
					                    	<option value="N">SAVE</option>
					                        <option value="Y">CONFRIM</option>
										<% } else {%>
											<option value="Y">CONFRIM</option>
										<% }%>					                        
					                    </select>
									</td>
									<td>RCC</td>
									<td>
										<select class="input" name="s_loc_cd"  style="width:90">
											<option value="" selected>ALL</option>
											<option value="USNYC">USNYC</option>
											<option value="DEHAM">DEHAM</option>
											<option value="SGSIN">SGSIN</option>						
										</select>
									</td>
									<td>LCC</td>
									<td>	
										<input type="text" class="input" name="s_sub_loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" onBlur="form_blur();" onKeyPress= "form_keypress();" style="width:80;" value="" >
									</td>
								</tr>
		                    </table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- : ( Grid ) (S) -->
							<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		        	        <table width="100%" id="mainTable" >
		        				<tr>
		        					<td>
			        				   <script language="javascript">ComSheetObject('sheet1');</script>
			        				</td>
			        			</tr>
		        			</table>
							<!-- : ( Grid ) (E) -->
		        			<!-- : Space (S) -->
		        			<table class="height_5">
		        				<tr>
		        					<td>
		        					</td>
		        				</tr>
		        			</table>
		        			<!-- : Space (E) -->
							<!-- TABLE '#D' : ( Button : Sub ) (S) -->
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr>
									<td class="btn1_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_guideline_add" id="btn_guideline_add">Guideline New</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_guideline_amend" id="btn_guideline_amend">Guideline Amend</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_guideline_del" id="btn_guideline_del">Guideline Del</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_pod_add" id="btn_pod_add">POD Add</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>								
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_pod_del" id="btn_pod_del">POD Del</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					    	<!-- TABLE '#D' : ( Button : Sub ) (E) -->
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>