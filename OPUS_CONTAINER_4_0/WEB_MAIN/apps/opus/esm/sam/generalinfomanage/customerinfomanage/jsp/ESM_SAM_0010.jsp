<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0010.jsp
*@FileTitle  : Customer Code grouping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsrSrepCd 	= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralInfoManage.CustomerInfoManage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		log.info("*	strUsr_id	:"+strUsr_id+"*	strUsr_nm	:"+strUsr_nm+"*	strOfc_cd	:"+strOfc_cd+"*	strUsrSrepCd:"+strUsrSrepCd);
		event = (EsmSam0010Event)request.getAttribute("Event");
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

<head>
<title>Customer Code grouping</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" value="I" id="ibflag" />
<input type="hidden" name="usr_id" value="<%= strUsr_id %>" id="usr_id" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Group_Code_Assign" id="btn_Group_Code_Assign" type="button">Group Code Assign</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Excel" id="btn_Excel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Direct D/L</button><!--
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
				<col width="100" />				
				<col width="120" />				
				<col width="100" />				
				<col width="120" />			
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Customer Name</th>
		   			<!-- 2014.07.31 김용습 - dataformat을 engname에서 excepthan으로 변경 -->
					<td><input type="text" style="width:130px;ime-mode:disabled;text-align:Left" class="input" name="cust_lgl_eng_nm" dataformat="excepthan" maxlength="50" id="cust_lgl_eng_nm" /></td>
					<th>Match Rule</th>
					<td><!-- 
					--><select name="match_rule" id="match_rule" style="width:110px;"><!-- 
						--><option value="I" >Include</option><!-- 
						--><option value="A">Exact</option><!-- 
						--><option value="D">Start With</option><!-- 
					--></select><!-- 
					--></td>
					<th>Sales Office</th>
					<td><!-- 
					--><input type="text" name="ofc_cd" style="width:80px;ime-mode:disabled;text-align:center" class="input" value="<%//=strOfc_cd%>" onkeyup="" dataformat="engup" maxlength="6" id="ofc_cd" /><!-- 
					--><button type="button" id="btn_Sales_Office" name="btn_Sales_Office" class="input_seach_btn"></button><!-- 
					--></td>
		   		</tr>
		   		<tr>
		   			<th>Abbreviation</th>
						<td><input type="text" style="width:130px;ime-mode:disabled;text-align:center" class="input" name="cust_abbr_nm" dataformat="engup" maxlength="20" id="cust_abbr_nm" otherchar=" &amp;-,." /> </td>
						<td></td>
						<td></td>
						<th>Location</th>
						<td><input type="text" name="cust_cnt_cd" style="width:80px;text-align:center;ime-mode:disabled" class="input" value="<%//=strOfc_cd%>" onkeyup="" dataformat="engup" maxlength="5" id="cust_cnt_cd" /> </td>
						<td></td>
		   		</tr>
		   		<tr>
		   			<th>Group Code</th>		
		   				<!-- 2014.07.31 김용습 - 하이픈이 들어가지 않아 데이터 포맷 변경(engup -> excepthan) -->   				
						<td><input type="text" style="width:130px;ime-mode:disabled;text-align:center" class="input" name="cust_grp_id" dataformat="excepthan" maxlength="20" value="<%//=strOfc_cd%>" id="cust_grp_id" otherchar=" &amp;-,." /><!-- 
						--><button type="button" id="btn_Group_Code" name="btn_Group_Code" class="input_seach_btn"></button></td>
						<td></td>
						<td></td>
						<!-- 2014.07.31 김용습 - 버튼 이름 수정(Rep뒤에 . 추가) -->
						<th>Sales Rep.</th>
						<td><!-- 
						--><input type="text" style="width:100px; text-align: center;" name="srep_cd" dataformat="engup" maxlength="5" onkeyup="" value="<%//=strUsrSrepCd%>" class="input" id="srep_cd" /><!-- 
						--><button type="button" id="btn_Srep_Cd_Pop" name="btn_Srep_Cd_Pop" class="input_seach_btn"></button><!-- 
						--></td>
		   		</tr>
		   		<tr>
		   			<!-- 2014.07.30 김용습 - 달력 스타일 바꿈 -->
		   			<!-- <th>Creation Date</th>
					<td>
					<input type="text" style="width:70px;ime-mode:disabled;text-align:right" class="input" name="str_cre_dt" dataformat="ymd" maxlength="8" size="10" id="str_cre_dt" />
					<button type="button" id="btn_Calendar1" name="btn_Calendar1" class="calendar ir"></button>
					~&nbsp;<input type="text" style="width:70px;ime-mode:disabled;text-align:right" class="input" name="end_cre_dt" dataformat="ymd" maxlength="8" size="10" id="end_cre_dt" />
					<button type="button" id="btn_Calendar2" name="btn_Calendar2" class="calendar ir"></button>
					</td> -->					
					<th>Creation Date</th>
			          <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" name="str_cre_dt" dataformat="ymd" maxlength="8" size="10" id="str_cre_dt" />~ <!-- 
			               --><input type="text" style="width:80px;ime-mode:disabled;" class="input" name="end_cre_dt" dataformat="ymd" maxlength="8" size="10" id="end_cre_dt" /><!-- 
			               --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button>
			          </td>
					
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
<form name='formSave'>
	<input type="hidden" name="f_cmd" value="" id="f_cmd" />
</form>