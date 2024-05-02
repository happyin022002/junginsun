<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1025.jsp
*@FileTitle : Loading Trend by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11 
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.07.11 SHIN DONG IL
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1026Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO"%>


<%
	EesEqr1026Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String strFmWk 			= "";
	String strToWk 			= "";
	String strRccCd 		= "";
	String strOfcTpCd 		= "";
	String optionStr 		= "000001: :ALL|000002:N:NONE";
	String mainPage 		= "";  //GUIDELINE CREATION/INQUERY화면 구분자 TRUE : GUIDELINE CREATION, FALSE : GUIDELINE INQUERY

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesEqr1026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr1026ConditionVO conditionVO = new EesEqr1026ConditionVO();
		conditionVO = event.getEesEqr1026ConditionVO();
		
		strFmWk 	= conditionVO.getFmWk();
		strToWk 	= conditionVO.getToWk();
		strRccCd 	= conditionVO.getRccCd();
		strOfcTpCd  = conditionVO.getOfcTpCd();
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	// TP/SZ Select 박스
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:60;'","CD00263",0,optionStr);
	// Location Type Code Select 박스
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd","","onChange='javascript:locTpcdChange(document.form.loc_tp_cd.options[document.form.loc_tp_cd.selectedIndex].value)' ","CD03052",0,"000001: :ALL");

%>
<html>
<head>
<title>Loading Trend by Lane</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
 // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- // 	
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|S2|S4|F2|F4|F5|A2|A4|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|S2|S4"; // OT  TYPE SIZE CD00753
    var tpszotCode  = "O2|O4|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4|A5"; // FR  TYPE SIZE CD00754
    var tpszfrCode  = "F2|F4|F5|A2|A4|A5";	
	
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4,A5";
// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		parent.window.moveTo(0,0);
		var screen_width = window.screen.width
		var screen_height = (window.screen.height)-30;
		parent.window.resizeTo(screen_width,screen_height);
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="cntr_tpsz_cd" 	value="">
	<input type="hidden" name="h_ofc_tp_cd" 	value="<%=strOfcTpCd%>">	
	<input type="hidden" name="h_ofc_cd" 		value="<%=strOfc_cd%>">	
	<input type="hidden" name="h_fm_wk" 		value="<%=strFmWk%>">
	<input type="hidden" name="h_to_wk" 		value="<%=strToWk%>">
	<input type="hidden" name="h_rcc_cd" 		value="<%=strRccCd%>">
	<input type="hidden" name="usr_id" 			value="<%=strUsr_id%>">
	
	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
		<tr>
			<td valign="top">
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
		        <table class="search" border="0"  width="100%">
					<tr>
		                <td class="bg">
		                    <table class="search" border="0" style="width:1000;">
								<tr class="h23" width="100%" >
									<td width="50">Week</td>
									<td width="130">
										<input type="text" name="fm_wk" class="input1" style="width:50" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();"> 
										~ 
										<input type="text" name="to_wk" class="input1" style="width:50" dataformat="yw" maxlength="6" onFocus="form_focus();"  onBlur="form_blur();" onKeyPress= "form_keypress();">
									</td>
									<td width="85">Trade</td>
									<td width="210">
										<script language="JavaScript">ComComboObject("trade", 2, 200, 0, 0);</script>
									</td>
									<td width="70">Sub Trade</td>
									<td width="195">
										<script language="JavaScript">ComComboObject("subtrade", 4,186, 0, 0);</script>
									</td>
									<td width="40">Lane</td>
									<td>
										<!-- script language="JavaScript">ComComboObject("lane", 4,180, 0, 0);</script -->
										<script language="JavaScript">ComComboObject("lane", 2, 188, 0, 0);</script><!-- 정길수 부장님 작업용 -->										
									</td>
								</tr>
								<tr class="h23">
									<td>VVD</td>
									<td>
										<input type="text" name="vvd_cd" class="input" style="width:118"  maxlength="9" onFocus="form_focus();"  onChange="form_blur();" onKeyPress= "form_keypress();">
									</td>
									<td>POD Location</td>
									<td>
										<select class="input" name="rcc_cd" onChange="change_rcc()">
											<option value="" selected>ALL</option>
											<option value="CNSHA">CNSHA</option>
											<option value="CNHKG">CNHKG</option>
											<option value="TWTPE">TWTPE</option>
											<option value="KRSEL">KRSEL</option>
											<option value="JPTYO">JPTYO</option>
											<option value="SGSIN">SGSIN</option>
											<option value="DEHAM">DEHAM</option>
											<option value="USNYC">USNYC</option>												
										</select>
										<%= locSelectBox %>
										<input type="text" class="input" name="loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" onBlur="form_blur();" onKeyPress= "form_keypress();" style="width:53;" value="" >
										<img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle" disabled>
									</td>
									<td>TP/SZ</td>
									<td colspan="3"><%= tyszSelectBox %>&nbsp;
										<script language="javascript">ComComboObject('tpsztype' , 1,120, 1 )</script>
									</td>

								</tr>
		                    </table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
	        	<table class="height_5"><tr><td></td></tr></table>
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
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>