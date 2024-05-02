<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1062.jsp
*@FileTitle  : Forecast Accuracy Review (By Week)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1062Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1062Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String optionStr = "000000: :ALL";
	String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr);
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");		
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
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

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" id="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="search_flag" id="search_flag" />
<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class="opus_design_inquiry wFit" id="mainTable">
		<table>
			<colgroup>
				<col width="10">
	            <col width="70">
	            <col width="190">
	            <col width="100">
	            <col width="60">
	            <col width="70">
	            <col width="50">
	            <col width="90">
	            <col width="50">
	            <col width="50">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td><input type="radio" name="div_flag" id="div_flag" value="1" class="trans" OnClick="ChangeInputStatus(1);" checked></td>
					<th>Location By</th>
					<td><select style="width:100px;" name="loc_tp_cd" id="loc_tp_cd" class="input">
							<option value="E" selected>ECC(by SCC)</option>
							<option value="L">LCC(by ECC)</option>
							<option value="S">LCC(by SCC)</option>
							<option value="R">RCC(by LCC)</option>
						</select><!-- 
						 --><input type="text" dataformat="engup" size="5" maxlength="5" caption="Location By CD"  style="width:50px;" class="input1" name="loc_cd" id="loc_cd" value=""><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_loc_cd" id="btn_loc_cd"></button></td>
					<th><input type="radio" name="div_flag" id="div_flag" value="2" class="trans" OnClick="ChangeInputStatus(2);">&nbsp;Location</th>
					<td>
						   <%= locSelectBox %><!-- loc_tp_cd_second --><!-- 
					    --><input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" style="width:50px;" class="input1" name="loc_cd_second" id="loc_cd_second" value=""><!--  
						--><button type="button" class="input_seach_btn" name="btn_loc_cd_second" id="btn_loc_cd_second"></button>
					</td>
					<th>Week</th>
					<td><input type="text" style="width:60px" required maxlength="7" caption="Week From" dataformat="yw" class="input1" name="fm_week" id="fm_week" value="">~&nbsp;<!-- 
						 --><input type="text" style="width:60px" caption="Week To" required maxlength="7" dataformat="yw"  class="input1" name="to_week" id="to_week" value="">
					</td>
					<th>Forecast</th> 
					<td><select style="width:80px;" class="input" name="bound" id="bound">
						<option value="O" selected>OP</option>
						<option value="I">MG</option>
						<option value="A">ALL</option>
						</select>
					</td>
				    <td><button class="btn_etc"  name="btn_t1detail" type="button">Evaluation Rule</button></td>
				    <td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
	            <col width="85">
	            <col width="100">
	            <col width="*">
			</colgroup>
			<tbody>
			<tr>
				<th>TP/SZ</th>
				<td><%= cntrTpsz %></td>
				<td><script type="text/javascript">ComComboObject('tpsztype' , 1, 280, 1 )</script></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<div  id="tabLayer">
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
			<div class="opus_design_grid" id="mainTable">
				<h3 class="title_design mar_btm_8">Accuracy Ranking</h3>
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			</div>
		</div>
		<div id="tabLayer" style="display:none">
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
			            <col width="40">
			            <col width="60">
			            <col width="60">
			            <col width="70">
			            <col width="70">
		             	<col width="70">
			            <col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th><input type="radio" name="view_flag"  id="view_flag" checked value="" class="trans">&nbsp;All</th>
							<th><input type="radio" name="view_flag" id="view_flag" value="1" class="trans">&nbsp;FCST</th>
							<th><input type="radio" name="view_flag" id="view_flag" value="2" class="trans">&nbsp;PFMC</th>
							<th><input type="radio" name="view_flag" id="view_flag" value="3" class="trans">&nbsp;Diff.Vol</th>
							<th><input type="radio" name="view_flag" id="view_flag" value="4" class="trans">&nbsp;Diff.(%)</th>
							<th><input type="radio" name="view_flag" id="view_flag" value="5" class="trans">&nbsp;Evaluation</th>
							<td></td>
						</tr>
				</table>
			</div>
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('t1sheet2');</script>
			</div>
		</div>
</div>
</form>