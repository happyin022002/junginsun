<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1008.jsp
*@FileTitle : Empty Repo Guideline Creation.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event.EesEqr1008Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO"%>
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
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:80px;'","CD00263",0,optionStr);
%>

<script type="text/javascript">
    <%= JSPUtil.getIBCodeCombo("glinetp", "01", "CD03221", 0, "")%> // EQUIPMENT GUIDELINE TYPE CODE
   
 // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- // 	
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|S2|S4|F2|F4|F5|A2|A4"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|O4|O5|S2|S4"; // OT  TYPE SIZE CD00753
    var tpszotCode  = "O2|O4|O5|S2|S4";
    var tpszfrText  = "F2|F4|F5|A2|A4"; // FR  TYPE SIZE CD00754
    var tpszfrCode  = "F2|F4|F5|A2|A4";	
	
//    var consTpsz      = replaceAll(tpszallText, "|", ",");
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,O4,O5,S2,S4";
    var consTpszFr    = "F2,F4,F5,A2,A4";
// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=main_page%>");
	}
</script>

<form name="form" >
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="tpszall" value="" id="tpszall" />
	<input type="hidden" name="tpcnt" value="" id="tpcnt" />
	<input type="hidden" name="cntr_tpsz_cd" value="" id="cntr_tpsz_cd" />
	<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">
	<input type="hidden" name="h_eta_dt" id="h_eta_dt" value="<%=strLcl_dt%>">
	<input type="hidden" name="main_page" id="main_page" value="<%=main_page%>">
	<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- btn_div -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		    --><button type="button" class="btn_normal" name="btn_email" id="btn_email">Send Mail</button><!--
		    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		    --><button type="button" class="btn_normal" name="btn_guideline_add" id="btn_guideline_add">Guideline New</button><!--
		    --><button type="button" class="btn_normal" name="btn_guideline_amend" id="btn_guideline_amend">Guideline Amend</button><!--
		    --><button type="button" class="btn_normal" name="btn_guideline_del" id="btn_guideline_del">Guideline Del</button><!--
		    --><button type="button" class="btn_normal" name="btn_pod_add" id="btn_pod_add">POD Add</button><!--
		    --><button type="button" class="btn_normal" name="btn_pod_del" id="btn_pod_del">POD Del</button>
		</div>
	   <!-- page_location(S) -->
	   <div class="location">
			<span id="navigation"></span>
	   </div>
	</div>

	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
		            <col width="60">
		            <col width="80">
		            <col width="90">
		            <col width="200">
		            <col width="60">
		            <col width="80">
		            <col width="90">
		            <col width="90">
		            <col width="60">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th><input type="radio" name="s_dt_tp_cd" id="s_dt_tp_cd" class="trans" checked OnClick="chg_dt_tp();" value="1"><label for="s_dt_tp_cd">Latest</label></th>
						<td><input type="text"  name="s_eta_dt"  id="s_eta_dt"   class="input1" style="width:80px;" value="<%=strLcl_dt %>" onFocus="form_focus();" onBlur="form_blur();"></td>
						<th><input type="radio" name="s_dt_tp_cd" id="s_dt_tp_cd" class="trans" OnClick="chg_dt_tp();" value="2"><label for="s_dt_tp_cd">Duration</label></th>
						<td>
							<input type="text" name="s_eff_st_dt" id="s_eff_st_dt" class="input" style="width:80px" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();">~ <!-- 
							 --><input type="text" name="s_eff_end_dt" id="s_eff_end_dt" class="input" style="width:80px" dataformat="ymd" maxlength="8" onFocus="form_focus();"  onBlur="form_blur();"><!-- 				
							 --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button> 
						</td>
						<th>Trade</th>
						<td>
							<script type="text/javascript">ComComboObject("trade", 2, 80, 0, 0);</script>
						</td>
						<th>Sub Trade</th>
						<td>
							<script type="text/javascript">ComComboObject("subtrade", 4,90, 0, 0);</script>
						</td>
						<th>Lane</th>
						<td>
							<script type="text/javascript">ComComboObject("lane", 5, 80, 0, 0);</script><!-- 
							 --><input type="text" class="input" name="lane_direct" id="lane_direct" size="3" maxlength="3" fulfill size="3" style="width:60px;" value="" ><!-- 				
							 --><button type="button" class="input_seach_btn" name="btn_Lane" id="btn_Lane"></button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
		            <col width="67">
		            <col width="398">
		            <col width="50">
		            <col width="125">
		            <col width="52">
		            <col width="105">
		            <col width="52">
		            <col width="80">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>TP/SZ</th>
						<td><%= tyszSelectBox %><script type="text/javascript">ComComboObject('tpsztype' , 1, 261, 1 )</script></td>
						<th>Status</th>
						<td>
							<select name="s_cfm_flg" id="s_cfm_flg" style="width:80px">
							<% if (main_page!=null && main_page.trim().toUpperCase().equals("TRUE")){ %>
								<option value="">ALL</option>
		                    	<option value="N">SAVE</option>
		                        <option value="Y">CONFRIM</option>
							<% } else {%>
								<option value="Y">CONFRIM</option>
							<% }%>					                        
		                    </select>
						</td>
						<th>RCC</th>
						<td><select class="input" name="s_loc_cd" id="s_loc_cd"  style="width:90px">
								<option value="" selected>ALL</option>
								<option value="USNYC">USNYC</option>
								<option value="DEHAM">DEHAM</option>
								<option value="SGSIN">SGSIN</option>						
							</select>
						</td>
						<th>LCC</th>
						<td><input type="text" class="input" name="s_sub_loc_cd" id="s_sub_loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" onBlur="form_blur();" style="width:80px;" value="" ></td>
						<td></td>
					</tr>
				</tbody>
	        </table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
</form>