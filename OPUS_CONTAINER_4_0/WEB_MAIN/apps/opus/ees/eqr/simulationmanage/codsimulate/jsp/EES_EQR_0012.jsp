<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0012.jsp
*@FileTitle  : Change POD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event.EesEqr0012Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SimulationManage.CodSimulate");
	String userId ="";
	String userName = "";
	String currnetTime = JSPUtil.getKSTDateTime();

	String yyyyww     = "";
	String seq        = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        userId=account.getUsr_id();
        userName = account.getUsr_nm();
		event = (EesEqr0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr0012ConditionVO conditionVO = new EesEqr0012ConditionVO();
		conditionVO = event.getEesEqr0012ConditionVO();
		yyyyww		= conditionVO.getYyyyww();
		seq			= conditionVO.getSeq();
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	String optionStr = "000000: :ALL";
	String fmType    = JSPUtil.getCodeCombo("fmType", "", "OnChange='displayType()' width='55'", "CD00242", 0, optionStr);
	String toType    = JSPUtil.getCodeCombo("toType", "", "OnChange='displayType()' width='55'", "CD00242", 0, optionStr);
	//String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","onChange='javascript:tpszChange(document.form.cntrTpsz.options[document.form.cntrTpsz.selectedIndex].value)' style='width:55;'","CD00263",0,optionStr);
	String cntrTpsz = JSPUtil.getCodeCombo("cntrTpsz","","onChange='javascript:tpszChange(document.form.cntrTpsz.options[document.form.cntrTpsz.selectedIndex].value)' style='width:55;'","CD01527",0,optionStr);
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
%>

<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "EQR")%>

//company code 가져오기 //
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00264", 0, "")%>
//-------------------//
<%//= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00244", 0, "")%> // ALL TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00753", 0, "")%> // OT  TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00754", 0, "")%> // FR  TYPE SIZE

<%//= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
<%//= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE CD00753
<%//= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE CD00754
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszall", "", "", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszdry", "", "D", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszspc", "", "S", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszrb", "", "R", "", "", "")%>

	// ------- type 변수선언 -------------- START
	var consTpsz      = replaceAll(tpszallText, "|", ",");
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	var consTpszSpc   = replaceAll(tpszspcText, "|", ",");
	var consTpszZrb   = replaceAll(tpszrbText, "|", ",");
	//var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
	//var consTpszOt    = replaceAll(tpszotText,  "|", ",");
	//var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
	// ------- type 변수선언 -------------- END

  function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
		displayType();
		tpszChange(document.form.cntrTpsz.options[document.form.cntrTpsz.selectedIndex].value);
		
		goSearchRepoid("Loading");		
	}
</script>
<form method="post" name="form" id="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />

<!-- repo_rmk_result -->
<input type="hidden" name="repo_rmk_result" id="repo_rmk_result" />


<!-- IFrame value S -->
<input type="hidden" name="st_year" id="st_year" />
<input type="hidden" name="st_month" id="st_month" />
<input type="hidden" name="st_weekly" id="st_weekly" />
<input type="hidden" name="end_year" id="end_year" />
<input type="hidden" name="end_month" id="end_month" />
<input type="hidden" name="end_weekly" id="end_weekly" />

<input type="hidden" name="perfix_month" id="perfix_month" />
<input type="hidden" name="title_month" id="title_month" />
<input type="hidden" name="perfix_weekly" id="perfix_weekly" />
<input type="hidden" name="title_weekly" id="title_weekly" />
<input type="hidden" name="monthly_count" id="monthly_count" />
<input type="hidden" name="status_type" id="status_type" />
<input type="hidden" name="max_weekly" id="max_weekly" />
<input type="hidden" name="max_plnYrWk" id="max_plnYrWk" />
<input type="hidden" name="max_plnYr" id="max_plnYr" />

<input type="hidden" name="scnr_id" id="scnr_id" />
<input type="hidden" name="repo_pln_id" id="repo_pln_id" />
<input type="hidden" name="dtrb_flg" id="dtrb_flg" />
<input type="hidden" name="fromToPlnId" id="fromToPlnId" />
<input type="hidden" name="repo_pln_id_title" id="repo_pln_id_title" />
<input type="hidden" name="maxWkStr" id="maxWkStr" />
<!-- IFrame value E -->

<input type="hidden" name="yyyywwOld" value="" id="yyyywwOld" />
<input type="hidden" name="seqOld" value="" id="seqOld" />
<input type="hidden" name="fmTypeBy_2Old" value="" id="fmTypeBy_2Old" />
<input type="hidden" name="toTypeBy_2Old" value="" id="toTypeBy_2Old" />
<input type="hidden" name="atTypeBy_2Old" value="" id="atTypeBy_2Old" />

<input type="hidden" name="typeBy_3Old" value="" id="typeBy_3Old" />
<input type="hidden" name="typeBy_4Old" value="" id="typeBy_4Old" />

<input type="hidden" name="scnrIdList" value="" id="scnrIdList" />
<input type="hidden" name="repoPlnIdList" value="" id="repoPlnIdList" />

<input type="hidden" name="userId" id="userId" />
<input type="hidden" name="userTime" id="userTime" />
<input type="hidden" name="repo_id_used" id="repo_id_used" />
<input type="hidden" name="chkUserid" value="<%=userId%>" id="chkUserid" />
<input type="hidden" name="checksave" id="checksave" />
<input type="hidden" name="currentDay" value="<%=currnetTime%>" id="currentDay" />
<input type="hidden" name="tpszallTypeAll" id="tpszallTypeAll" />
<input type="hidden" name="tpszCurrent" id="tpszCurrent" />
<input type="hidden" name="pre_repo_rmk" id="pre_repo_rmk"/>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<!-- button class="btn_accent" type="button" name="btn_eqraccess" id="btn_eqraccess">EQR Access</button>
		<button class="btn_normal" type="button" name="btn_bayplan" id="btn_bayplan">Bayplan</button>
		--><button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button class="btn_normal" type="button" name="btn_save" id="btn_save">Save</button><!--
		--><button class="btn_normal" type="button" name="btn_confirm" id="btn_confirm">Confirm</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_print" id="btn_print">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90" />
				<col width="180" />	
				<col width="700" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
			   		<th>Repo. Plan ID </th>
					<td class="sm"><!-- 
						 --><input type="text" style="width:45px;" value="REPO" class="noinput2" readonly>&nbsp;<!-- 
						 -->
						    <!-- input class="input1" type="text" style="width:50px;ime-mode:disabled;" value="<%=yyyyww%>" name ="yyyyww" id ="yyyyww" maxlength="6" onkeyup="onlyNumberInput(event);moveTab(this,seq)"-->
						    <input class="input1" type="text" style="width:50px;ime-mode:disabled;" value="<%=yyyyww%>" name ="yyyyww" id ="yyyyww" maxlength="6" dataformat="num"><!-- 
						 --><input type="text" style="width:20px" value="W" class="noinput2" readonly><!-- 
						 -->
						    <!-- input class="input1" type="text" style="width:30px;ime-mode:disabled;" value="<%=seq%>" name="seq" id="seq" maxlength="3" onkeyup="onlyNumberInput(event);moveTab(this,repo_rmk)" onBlur="goSearchRepoid();"-->
						    <input class="input1" type="text" style="width:35px;ime-mode:disabled;" value="<%=seq%>" name="seq" id="seq" maxlength="4" dataformat="num" onBlur="goSearchRepoid();"><!-- 
						 --><button type="button" id="btn_repolist" name="btn_repolist" class="input_seach_btn"></button></td>
				    <td class="sm"><textarea  name="repo_rmk" id="repo_rmk"  rows="1" style="width:553px; overflow:hidden; resize:none; height:23px;" class="input1" ></textarea>
				    <button class="btn_normal" type="button" name="btn_create" id="btn_create">Create</button>&nbsp;<!-- 
					--> <button class="btn_normal" type="button" name="btn_delete" id="btn_delete">Delete</button>
				    </td>
				    <td> </td>
				</tr>
				
		   </tbody>
		</table>
	</div>
	<table><tr><td  class="line_bluedot"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90" />	
				<col width="240"/>
				<col width="185" />
				<col width="90" />
				<col width="240" />
				<col width="*" />				
		   </colgroup> 
			<tbody>
				<tr>
					<th>From Location</th>
					<td><!-- 
						 --><%=fmType%><!-- 
						 --><input type="text" style="width:150px;ime-mode:disabled;" name="fmEccCd" id="fmEccCd" dataformat="engup"><!-- 
						 --><button type="button" id="fmloc_btn" name="fmloc_btn" class="input_seach_btn"></button></td>
		
		            <td><!-- 
						 --><input name="fmPlnYr" id="fmPlnYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4" dataformat="num"><!-- 
						 --><input name="fmPlnWk" id="fmPlnWk" type="text" style="width:22px;ime-mode:disabled;" maxlength="2" dataformat="num">~&nbsp;<!-- 
		                 --><input name="toPlnYr" id="toPlnYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4" dataformat="num"><!-- 
						 --><input name="toPlnWk" id="toPlnWk" type="text" style="width:22px;ime-mode:disabled;" maxlength="2" dataformat="num" onblur="maxValueCheck(fmPlnYr, fmPlnWk, toPlnYr,toPlnWk ,max_plnYrWk,'9',yyyyww);">
					</td>
					<th>To Location</th>
					<td><!-- 
						 --><%=toType%><!-- 
						 --><input name="toEccCd" id="toEccCd" type="text" style="width:150px;ime-mode:disabled;" dataformat="engup"><!-- 
						 --><button type="button" id="toloc_btn" name="toloc_btn" class="input_seach_btn"></button></td>
		
		             <td><input name="fmToPlnYr" id="fmToPlnYr" type="text" style="width:35px;ime-mode:disabled;" maxlength="4"    dataformat="num"><!-- 
						 --><input name="fmToPlnWk" id="fmToPlnWk" type="text" style="width:22px;ime-mode:disabled;" maxlength="2" dataformat="num" >~&nbsp;<!-- 
		                 --><input name="toToPlnYr" id="toToPlnYr"type="text" style="width:35px;ime-mode:disabled;" maxlength="4"  dataformat="num"><!-- 
						 --><input name="toToPlnWk" id="toToPlnWk"type="text" style="width:22px;ime-mode:disabled;" maxlength="2"  dataformat="num" onblur="maxValueCheck(fmToPlnYr, fmToPlnWk, toToPlnYr,toToPlnWk,max_plnYrWk,'9',yyyyww);">
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90" />	
				<col width="60"/>
				<col width="60" />
				<col width="125" />
				<col width="60" />
				<col width="20" />	
				<col width="130" />	
				<col width="55" />	
				<col width="160" />	
				<col width="40" />					
				<col width="*" />				
		   </colgroup>
			<tbody>
				<tr><td colspan="11" class="height_5"></td></tr>
				<tr>
					<th>Conti.</th>
					<td><select name="conti"id="conti" onChange="" style="width:55px;">
					  	<option value="" selected>ALL</option>
						<option value="A" >A</option>
						<option value="M" >M</option>
						<option value="E" >E</option>
						<option value="F" >F</option>
						</select></td>
					<th>Trade</th>
					<td><input name="trade" id="trade" type="text" style="width:85px;ime-mode:disabled;" dataformat="enguponly"><!-- 
						--><button type="button" id="btn_trade" name="btn_trade" class="input_seach_btn"></button></td>
					<th>TP/SZ</th>
					<td><%=cntrTpsz %></td>
					<td><script type="text/javascript">ComComboObject('cntrTpszCd' , 1 , 120, 1 )</script></td>
					<th>Lane</th>
					<td><input name="lane" id="lane" type="text" style="width:120px;ime-mode:disabled;" dataformat="engup"><!-- 
						 --><button type="button" id="btn_lane" name="btn_lane" class="input_seach_btn"></button></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input name="vvd" id="vvd"  type="text" style="width:120px;ime-mode:disabled;" dataformat="engup" ><!-- 
						 --><button type="button" id="btn_vvd" name="btn_vvd" class="input_seach_btn"></button></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab" style="display:none">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	
	<!-- UI_ESS_EQR_012 : THIS IS 1st TAB -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="t1btng_rowadd" id="t1btng_rowadd" type="button">Row Add</button><!-- 
			 --><button class="btn_accent" name="t1btng_rowdelete" id="t1btng_rowdelete" type="button">Row Delete</button>
			</div>

			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
		
	<!-- UI_ESS_EQR_098 : THIS IS 2st TAB -->
	<!-- div id="tabLayer" style="display:none">
		
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>		
		</div>
		
	</div-->
	
	<!-- UI_ESS_EQR_099 : THIS IS 3st TAB -->
	<!-- div id="tabLayer" style="display:none">

		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>		
		</div> 

	</div-->
	
</div>

<iframe frameborder=0 width=0 name="051iframe" scrolling="no" frameborder="0" width="0" height="0"></iframe>

<!-- ECC -->
<iframe frameborder=0 width=0 name="iframe" scrolling="no" frameborder="0" width="0" height="0"></iframe>
<iframe frameborder=0 width=0 name="iframe1" scrolling="no" frameborder="0" width="0" height="0"></iframe>
</form>
