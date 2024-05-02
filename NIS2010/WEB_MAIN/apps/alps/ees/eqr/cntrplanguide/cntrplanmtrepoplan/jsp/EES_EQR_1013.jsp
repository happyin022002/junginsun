<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1013.jsp
*@FileTitle : Mty Repo Plan.
*Open Issues :
*Change history :
*@LastModifyDate : 2013.6.27
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.event.EesEqr1013Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<% 
	EesEqr1013Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String strLcl_dt 		= "";
	String optionStr 		= "000001: :ALL";
	String mainPage 		= "";  //GUIDELINE CREATION/INQUERY화면 구분자 TRUE : GUIDELINE CREATION, FALSE : GUIDELINE INQUERY
	String strRHQ		 	= "";
	String strEtaFmDt 		= "";
	String strEtaToDt 		= "";
	String strFmWk 			= "";
	String strToWk 			= "";
	String strRccCd 		= "";
	String strOfcTpCd 		= "";
	String strPlnRsnHdrCode 		= "";
	String strPlnRsnHdrText 		= "";
	String strPlnRsnSubCode 		= "";
	String strPlnRsnSubText 		= "";
	String strLoginOfcConticCd		= ""; 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	JSPUtil.getNull(account.getUsr_id());
		strUsr_nm = JSPUtil.getNull(account.getUsr_nm());
		strOfc_cd = JSPUtil.getNull(account.getOfc_cd());
		strRHQ    = JSPUtil.getNull(account.getRhq_ofc_cd());
		 
		
		event = (EesEqr1013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		mainPage = JSPUtil.getParameter(request, "mainPage".trim(), "");

		EesEqr1013ConditionVO conditionVO = new EesEqr1013ConditionVO();
		conditionVO = event.getEesEqr1013ConditionVO();
		
		strEtaFmDt 	= JSPUtil.getNull(conditionVO.getEtaFmDt());
		strEtaToDt 	= JSPUtil.getNull(conditionVO.getEtaToDt());
		strFmWk 	= JSPUtil.getNull(conditionVO.getFmWk());
		strToWk 	= JSPUtil.getNull(conditionVO.getToWk());
		strRccCd 	= JSPUtil.getNull(conditionVO.getRccCd());
		strOfcTpCd  = JSPUtil.getNull(conditionVO.getOfcTpCd());
		strPlnRsnHdrText = JSPUtil.getNull(conditionVO.getPlnRsnHdrText());
		strPlnRsnHdrCode = JSPUtil.getNull(conditionVO.getPlnRsnHdrCode());
		strPlnRsnSubText = JSPUtil.getNull(conditionVO.getPlnRsnSubText());
		strPlnRsnSubCode = JSPUtil.getNull(conditionVO.getPlnRsnSubCode());
		strLoginOfcConticCd  = JSPUtil.getNull(conditionVO.getLoginOfcConticCd());
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	// TP/SZ select 박스
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:53;'","CD00263",0,optionStr);
	
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");
	
%>
<html>
<head>
<title>MT Repo PLAN</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    parent.window.moveTo(0,0);
    parent.window.resizeTo("1600","900");

	<%= JSPUtil.getIBCodeCombo("glinetp", "01", "CD03221", 0, "")%> // EQUIPMENT GUIDELINE TYPE CODE

 // -- 쉰PM왈 -> Cntr Tpsz 콤보 하드코딩으로 변경 -- // 	
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
	
	/*
    var consTpsz      = replaceAll(tpszallText, "|", ",");
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = replaceAll(tpszdryText, "|", ",");
    var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
    var consTpszOt    = replaceAll(tpszotText,  "|", ",");
    var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
    */
    
 	var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,S2,S4,F2,F4,F5,A2,A4,A5";
    var consTpszArr   = ['D2','D4','D5','D7','R2','R5','R9','O2','O4','S2','S4','F2','F4','F5','A2','A4','A5']; //consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4,A5";    
// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //


	var pln_rsn_hdr_code = "<%=JSPUtil.getNull(strPlnRsnHdrCode)%>";
	var pln_rsn_hdr_text = "<%=JSPUtil.getNull(strPlnRsnHdrText)%>";
	var pln_rsn_sub_code = "<%=JSPUtil.getNull(strPlnRsnSubCode)%>";
	var pln_rsn_sub_text = "<%=JSPUtil.getNull(strPlnRsnSubText)%>";
	var login_ofc_conti_cd = "<%=JSPUtil.getNull(strLoginOfcConticCd)%>";
	var isMainPage = "<%=mainPage%>"=='true'?true:false; 

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=mainPage%>");
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="tpszall" 			value="">
	<input type="hidden" name="tpcnt" 				value="">
	<input type="hidden" name="all_cntr_tpsz_cd" 	value="">
	<input type="hidden" name="rhq" 				value="<%=strRHQ%>">
	<input type="hidden" name="usr_id" 				value="<%=strUsr_id%>">
	<input type="hidden" name="h_ofc_tp_cd" 		value="<%=strOfcTpCd%>">	
	<input type="hidden" name="h_ofc_cd" 			value="<%=strOfc_cd%>">	
	<input type="hidden" name="h_eta_fm_dt" 		value="<%=strEtaFmDt%>">	
	<input type="hidden" name="h_eta_to_dt" 		value="<%=strEtaToDt%>">
	<input type="hidden" name="h_fm_wk" 			value="<%=strFmWk%>">
	<input type="hidden" name="h_to_wk" 			value="<%=strToWk%>">
	<input type="hidden" name="h_rcc_cd" 			value="<%=strRccCd%>">
	<input type="hidden" name="mainPage" 			value="<%=mainPage%>">
	<input type="hidden" name="cntr_tpsz_cd" 		value="" >
	<input type="hidden" name="pln_rsn_hdr_cd" 		value="" >
	
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
		        <table class="search" style="width:979;">
					<tr>
		                <td class="bg">
		                    <table class="search_in" border="0" style="width:979;">
								<tr class="h23">
									<td width="55"><input type="radio" name="s_dt_tp_cd" class="trans" value="E" OnClick="chg_dt_tp();" checked>ETA </td>
									<td width="200">
										<input type="text" name="s_eff_st_dt" class="input1" style="width:75" dataformat="ymd" maxlength="8" onKeyPress="form_keypress();" onFocus="form_focus();"  onBlur="form_blur();"> 
										~ 
										<input type="text" name="s_eff_end_dt" class="input1" style="width:75" dataformat="ymd" maxlength="8" onKeyPress= "form_keypress();" onFocus="form_focus();"  onBlur="form_blur();">
										<img name="btns_calendar_eff_dt" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" >
									</td>
									<td width="40">Trade</td>
									<td width="95">
										<script language="JavaScript">ComComboObject('trade', 2, 85, 0, 0);</script>
									</td>
									<td width="70">Sub Trade</td>
									<td width="125">
										<script language="JavaScript">ComComboObject('subtrade', 4, 115, 0, 0);</script>
									</td>
									<td width="35">Lane</td>
									<td width="115">
										<!-- script language="JavaScript">ComComboObject('lane', 4, 97, 0, 0);</script -->
										<script language="JavaScript">ComComboObject('lane', 2, 97, 0, 0);</script>
									</td>
		                            <td width="45" >TP/SZ</td>
									<td width="199"><%=tyszSelectBox%>&nbsp;
										<script language="javascript">ComComboObject('tpsztype', 1, 135, 0 )</script>
									</td>
								</tr>
							</table>		
							<table class="search_in" border="0" style="width:979;">
								<tr class="h23">
									<td width="55"><input type="radio" name="s_dt_tp_cd" class="trans" value="F" OnClick="chg_dt_tp();">FCBF</td>
									<td width="200">
										<input type="text" name="s_fcbf_st_dt" class="input1" style="width:75" dataformat="ymd" maxlength="8" onKeyPress= "form_keypress();" onFocus="form_focus();"  onBlur="form_blur();"> 
										~ 
										<input type="text" name="s_fcbf_end_dt" class="input1" style="width:75" dataformat="ymd" maxlength="8" onKeyPress= "form_keypress();" onFocus="form_focus();"  onBlur="form_blur();">
										<img name="btns_calendar_fcbf_dt" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" >
									</td>
									<td width="35">RCC</td>
									<td width="100">
										<select class="input" name="rcc_cd" style="width:87;" OnChange="javascript:rcc_cd_onchange();">
											<option value="" selected>All</option>
											<option value="CNSHA">CNSHA</option>
											<option value="CNHKG">CNHKG</option>
											<option value="TWTPE">TWTPE</option>
											<option value="KRSEL">KRSEL</option>
											<option value="JPTYO">JPTYO</option>
											<option value="SGSIN">SGSIN</option>		
											<option value="DEHAM">DEHAM</option>
											<option value="USNYC">USNYC</option>
										</select>
									</td>
		                            <td width="60">Location</td>
		                            <td width="135"><%=locSelectBox%>
		                                <input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" style="width:50;" class="input2" name="loc_cd_second" value="" onKeyPress= "form_keypress();"> 
		                                <img src="img/btns_search.gif" name="btn_loc_cd_second" width="19" height="20" border="0" align="absmiddle" class="cursor">
		                            </td>
									<td width="33">VVD</td>
									<td width="102">
		                                <input type="text" dataformat="engup" size="9" maxlength="9" caption="VVD" style="width:97;" class="input1" name="s_vvd_cd" value="" onKeyPress= "form_keypress();"> 
		                                <!-- img src="img/btns_search.gif" name="btn" width="19" height="20" border="0" align="absmiddle" class="cursor"-->
									</td>
									<td width="15">or</td>
									<td width="135" colspan="2">
										<script language="javascript">ComComboObject('vvdrslt', 1, 120, 1, 1)</script>
									<td width="109">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_vvd_result" id="btn_vvd_result">VVD Search</td>
												<td class="btn1_right"></td>
											</tr>
										</table>										
									</td>							
								</tr>
		                    </table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
	        	<table class="height_10"><tr><td></td></tr></table>
				<!-- TABLE '#D' : ( Search ) (S) -->
		        <table class="search" border="0" style="width:979;">
					<tr>
		                <td class="bg">
		                    <table class="search_in" border="0" style="width:979;">
								<tr class="h23">
									<td width="150" align="absmiddle">Plan Selection</td>								
									<td width="829" class="sm">&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_plan_sel_WT" class="trans" value="" onClick='setPlanSelCond();'>Weight&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_plan_sel_MP" class="trans" value="" onClick='setPlanSelCond();' checked>MT Loading Plan&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_plan_sel_GL" class="trans" value="" onClick='setPlanSelCond();'>Guideline&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_plan_sel_MB" class="trans" value="" onClick='setPlanSelCond();'>MT Booking&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_plan_sel_PN" class="trans" value="PN" onClick='setPlanSelCondPOD(this.value);'>POD(Except Null Data)&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_plan_sel_PA" class="trans" value="PA" onClick='setPlanSelCondPOD(this.value);'>POD(All)&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
							</table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:100%;">
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
				<table class="height_10"><tr><td></td></tr></table>
				<table class="height_10"><tr><td></td></tr></table>
				<table class="height_10"><tr><td></td></tr></table>
				<table class="height_10"><tr><td></td></tr></table>
				<!-- TABLE '#D' : ( Search ) (S) -->
		        <table class="search" border="0" style="width:979;">
					<tr>
		                <td class="bg">
		                    <table class="search_in" border="0" style="width:979;">
								<tr class="h23">
									<td width="150" align="absmiddle">Information Selection</td>								
									<td width="745" class="sm">&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_info_sel_WT" class="trans" value="" onClick='setInfoSelCond();' checked>Weight&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_info_sel_OB" class="trans" value="" onClick='setInfoSelCond();'>On-board&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_info_sel_FE" class="trans" value="" onClick='setInfoSelCond();'>Full Export&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_info_sel_EI" class="trans" value="" onClick='setInfoSelCond();'>Full Import&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="cbx_info_sel_OT" class="trans" value="" onClick='setInfoSelCond();'>Others&nbsp;&nbsp;&nbsp;
									</td>
									<td class="btn1_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_info_sel" id="btn_info_sel">Retrieve</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>									
								</tr>
							</table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
	        	<table class="height_10" style="width:100%;"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;">
					<tr>
						<td class="bg">
							<!-- : ( Grid ) (S) -->
							<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		        	        <table width="979" id="mainTable" >
		        				<tr>
		        					<td>
			        				   <script language="javascript">ComSheetObject('sheet2');</script>
			        				</td>
			        			</tr>
		        			</table>
							<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
				<table class="height_10" style="width:100%;"><tr><td></td></tr></table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>