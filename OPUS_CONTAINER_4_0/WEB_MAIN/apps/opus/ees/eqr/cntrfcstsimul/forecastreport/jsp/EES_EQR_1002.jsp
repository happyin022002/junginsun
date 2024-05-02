<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1002.jsp
*@FileTitle : History Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String fcastYrwk = "";
	String levelCd = "";
	String ofcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd	  = account.getOfc_cd();


		event = (EesEqr1002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		fcastYrwk = eventResponse.getETCData("fcast_yrwk");
		levelCd   = eventResponse.getETCData("level_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");	
    
	String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
	
%>
<script language="javascript">
	parent.window.moveTo(0,0);
	parent.window.resizeTo("1600","900");
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">

<input type="hidden" name="loc_grp_cd" value="L">
<!-- 개발자 작업	-->

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979px;"> 
			<tr>
            <th width="40px" class="align_left">Period</th>
			<td width="80px"> 
                      <select name="period" style="width:80px;" class="input1">
                      <option value="W" >yyyyww</option>
                      <option value="M" >yyyymm</option>
                      </select>
                  </td>
                  <td width="140px">
                     <input name="fmdate" value="" type="text" class="input1" style="width:60px;ime-mode:disabled;" maxlength="6" dataformat="num" onkeyup="moveTabNormal(this,todate);">&nbsp;~
                     <input name="todate" value="" type="text" class="input1" style="width:60px;ime-mode:disabled;" maxlength="6" dataformat="num"> 
                  </td>
                  <td width="12px"></td>
			<th width="30px" class="align_left">RCC</th>
			<td width="97px">
			<select style="width:80px;" class="input1" id="loc_cd" name="loc_cd">
				<option value="" selected>All</option>
				<option value="CNSHA">CNSHA</option>
				<option value="HKHKG">HKHKG</option>
				<option value="TWTPE">TWTPE</option>
				<option value="KRSEL">KRSEL</option>
				<option value="JPTYO">JPTYO</option>
				<option value="SGSIN">SGSIN</option>							
				</select>
			</td>			
			<td width="500px">
				<table border="0" style="width:500px;" class="search_sm2"> 
				<tr>									
					<td width="15px">
						<input type="radio" name="div_flag" value="1" class="trans" OnClick="changeInputStatus();" checked>
					</td>					
					<th width="73px"  class="align_left">Location by</th>
					<td width="110px">
						<select style="width:120px;" id="loc_type_code" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="RE">RCC (by ECC)</option>
							<option value="LE" selected>LCC (by ECC)</option>
							<option value="LS">LCC (by SCC)</option>
							<option value="ES">ECC (by SCC)</option>
							<!-- loc_cd -->
						</select> 
					</td>
					<td width="80px">	
						<input type="text" class="input2" name="sub_loc_cd" id="sub_loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" maxlength="5" fulfill style="width:50px;" value="" readOnly>&nbsp;<!-- USNYC -->
						<button type="button" class="input_seach_btn" name="btn_loc_cd"></button>
					</td>					
					<td width="15px">
						<input type="radio" name="div_flag" value="2" class="trans" OnClick="changeInputStatus();">
					</td>
					<th width="50px" class="align_left">Location</th>
					<td width="50px"><%= locSelectBox %></td> <!-- loc_tp_cd_second -->
					<td width="80px">
						<input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" style="width:60px;" class="input2" id="loc_cd_second"  name="loc_cd_second" value=""> 
						<button type="button" class="input_seach_btn" name="btn_loc_cd_second" ></button>
					</td>
				</tr>
			    </table>
			</td>
			</tr> 
		</table>
		<table class="search" style=""> 
            <tr>
                <th width="44px" class="align_left">TP/SZ</th>
                <td width="85px"><%= cntrTpsz %></td>
                <td colspan=8>&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 278, 1 )</script></td>
            </tr>
        </table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
