<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1018.jsp
*@FileTitle  : MTY BKG Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1018Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RepoPlanManage.CntrRepoExecutionPlanEstablish");
	
	String user_id              = "";
	
	String optionStr = "000001: :ALL";
	
	// from loc select box
	String frLocSelectBox = JSPUtil.getCodeCombo("fromstatus","","onChange='javascript:frLocChange(document.form.fromstatus.options[document.form.fromstatus.selectedIndex].value)' style='width:55;'","CD00259",0,"");

	// to loc select box
	String toLocSelectBox = JSPUtil.getCodeCombo("tostatus",  "","onChange='javascript:toLocChange(document.form.tostatus.options[document.form.tostatus.selectedIndex].value)'     style='width:55;'","CD00259",0,"");

	// TP/SZ select 박스
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:53;'","CD00263",0,optionStr);

  
	// Duration 종료일 (Hidden - 오늘날짜)
    String tempToPeriod = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
    // Duration 시작일 (Hidden - 1주일 이전날짜)
    String tempFmPeriod = DateTime.addDays(tempToPeriod, -6, "yyyy-MM-dd");
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		

		event = (EesEqr1018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		EesEqr1018ConditionVO conditionVO = new EesEqr1018ConditionVO();
		conditionVO = event.getEesEqr1018ConditionVO();

		user_id = event.getSignOnUserAccount().getUsr_id();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<script type="text/javascript">
	// Reason(검색정보)
	<%= JSPUtil.getIBCodeCombo("reason",  "01", "CD00261", 0, "")%>         // CD00369
	// Reason(sheet에서 선택값)
	<%= JSPUtil.getIBCodeCombo("reason_sheet",  "01", "CD00261", 0, " ")%>  // " " 는 선택값 없는 경우를 대비한 소스()
	// Item ( ALL )
	<%= JSPUtil.getIBCodeCombo("item",    "01", "CD00253", 0, "")%>
	// Item (Truck, Rail, Water)
	<%= JSPUtil.getIBCodeCombo("item_inland",    "01", "CD00566", 0, "")%>
	// Item ( On Hire & Off Hire )
	<%= JSPUtil.getIBCodeCombo("item_hire",    "01", "CD00241", 0, "")%>
	// Item (Truck, Water) - SHUTTLE 에서 사용
	// CSR NO : N200905180100 (ECC internal mode에서 'Rail' 추가) Modified by Lee Byoung Hun
	//<%= JSPUtil.getIBCodeCombo("item_shuttle",    "01", "CD01062", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("item_shuttle",    "01", "CD00566", 0, "")%>

	// Purpose
	<%= JSPUtil.getIBCodeCombo("purpose", "01", "CD00269", 0, " ")%> // " " 는 선택값 없는 경우를 대비한 소스()
	
	// Type Size
    <%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
    <%= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
    <%= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
    <%= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE CD00753
    <%= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE CD00754
   
	// ------- type 변수선언 -------------- START
	var consTpsz      = replaceAll(tpszallText, "|", ",");
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
	var consTpszOt    = replaceAll(tpszotText,  "|", ",");
	var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
	// ------- type 변수선언 -------------- END

</script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
		tpszChange('');
	}
</script>



<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="tpszall" > <!-- full type size (매우, )-->

<!-- 개발자 작업	-->
<input type="hidden"  name="iPage">
<input type="hidden" name="localDate">               <!--  local pc 의 오늘날짜 -->
<input type="hidden" name="position_row1" value="1"> <!-- 입력.수정시 row 위치를 기억한후 재조회시 포커스를 맞춘다 -->
<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 

<!-- USER LEVEL, ACTION, LOCATION -->
<input  type="hidden" name="user_id"              value="<%= user_id %>">

<!-- VVD 검색시 사용 -->
<input type="hidden" name="vvdSearchCol" value="">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
		</div>
		<!-- opus_design_btn(E) -->	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->


<!-- 검색영역 -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
		  		<col width="10px"></col>
		  		<col width="50px"></col>	  		
		  		<col width="55px"></col>
		  		<col width="150px"></col>
		  		<col width="60px"></col>
		  		<col width="150px"></col>	  		
		  		<col width="20px"></col>
		  		<col width="40px"></col>
		  		<col width="100px"></col>
		  		<col width="20px"></col>
		  		<col width="40px"></col>
		  		<col width="*"></col>
		  	</colgroup>
			<tbody>			
				<tr>
					<td><input type="radio" name="divflag" value="1" class="trans" OnClick="classToggle();" checked></td> 											
					<th class="stm"><B>Period</B> </th>
					<td>
						<select name="divdate" onchange="classToggle();" style="width:55px;">
							<option value="F" selected>From</option>
							<option value="T">To</option>
						</select>
					</td>
					<td ><input type="text" style="width:75px;" name="fromdate" value="<%=tempFmPeriod%>"  dataformat="ymd" maxlength="8" >&nbsp;~&nbsp;
						 <input type="text" style="width:75px;" name="todate"   value="<%=tempToPeriod%>"  dataformat="ymd" maxlength="8" >
						 <button type="button" class="calendar"  name="btns_calendarto"  id="btns_calendarto"></button> 
					</td>
					<th>From Loc</th>
					<td>
						<%= frLocSelectBox %>
						<input type="text" style="width:60px;ime-mode:disabled;" name="fromlocation" id="fromlocation" maxlength=7 dataformat='engup'>
						<button type="button" class="input_seach_btn" name="frloc_btn" id="frloc_btn"></button>
					</td>
					<td>&nbsp;</td>			
					<th>Item</th>
					<td><script type="text/javascript">ComComboObject('itemname' , 1, 90, 1 )</script></td>
					
					<td>&nbsp;</td>					
					<th>Lane</th>
					<td >
						<input name="lane" type="text" style="width:105px;ime-mode:disabled;" value="" maxlength="3" dataformat='engup'>		
					</td>			
					<td></td>
				</tr>	
				
				
				
				<tr>
					<td><input type="radio" name="divflag" value="2" class="trans" OnClick="classToggle();" ></td> 	
					<td class="stm"><B>VVD</B></td>
					<td colspan=2>
						<input name="vvdname" type="text" style="width:173px;ime-mode:disabled;" value="" maxlength="9" dataformat='engup'>
					</td>
					<th>To Loc</th>
					<td>
						<%= toLocSelectBox %>
						<input type="text" style="width:60px;ime-mode:disabled;" name="tolocation" id="tolocation"  maxlength=7 dataformat='engup'>
						<button type="button" class="input_seach_btn" name="toloc_btn" id="toloc_btn"></button>
					</td>																							
					<td>&nbsp;</td>						
					<th>TP/SZ</th>
					<td colspan=4>
						<table class="search" border="0">
							<tr>
								<td width="13%"><%= tyszSelectBox %></td>
								<td style="padding-left:2"><script type="text/javascript">ComComboObject('tpsztype' , 1, 192, 0 )</script></td>
							</tr>
						</table>	
					
					</td>
					<td></td>
				</tr>				
			</tbody>
		</table>
		
		
		
	</div>
</div>

<!-- opus_grid_design_btn(S) -->
<!-- data_area(S) -->
<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80" />
					<col width="600" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td align="left">Data Selection: &nbsp;<input type="radio" name="dataselect" value="1" class="trans" checked onclick="javascript:dataSelectionPlanBKG(1)" >&nbsp;ALL
		                <input type="radio" name="dataselect"  value="4" class="trans" onclick = "javascript:dataSelectionPlanBKG(4)">&nbsp;ALL(Except cancel)
		                <input type="radio" name="dataselect"  value="2" class="trans" onclick = "javascript:dataSelectionPlanBKG(2)">&nbsp;Plan
		                <input type="radio" name="dataselect"  value="3" class="trans" onclick = "javascript:dataSelectionPlanBKG(3)">&nbsp;REPO BKG
							</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- data_area(E) -->
	

<!-- data_area(E) -->
<!-- opus_grid_btn(S) -->
<!-- 검색영역 -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="t1btng_rowaddnoplan" id="t1btng_rowaddnoplan">VL Add(No Plan)</button>
				<button type="button" class="btn_normal" name="t1btng_rowadd" id="t1btng_rowadd">VL Add</button>
				<button type="button" class="btn_normal" name="t1btng_vdsplit" id="t1btng_vdsplit">VL Split</button>
				<button type="button" class="btn_normal" name="t1btng_vdsplitmulti" id="t1btng_vdsplitmulti">VL Split(Multi)</button>
				<button type="button" class="btn_normal" name="t1btng_repobkg" id="t1btng_repobkg">Repo. BKG Cre.</button>
				<button type="button" class="btn_normal" name="t1btng_gobkgupdate" id="t1btng_gobkgupdate">Mty Bkg Update</button>
			</div>
			<!-- opus_grid_btn(E) -->
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		<!-- opus_grid_design_btn(E) -->
	</div>
</div>
	<!-- opus_design_grid(E) -->
	<iframe frameborder="0" width="0"  name="iframe1018_vvdexist" scrolling="no" frameborder="0" width="0" height="0"></iframe>
<!-- 개발자 작업  끝 -->
</form>