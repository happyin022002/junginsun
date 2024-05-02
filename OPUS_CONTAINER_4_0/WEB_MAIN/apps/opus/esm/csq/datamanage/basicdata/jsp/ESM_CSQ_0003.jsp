<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0003.jsp
*@FileTitle  : Lane Direction Change
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.basicdata");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmCsq0003Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--  
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--  
		--><button class="btn_normal" name="btn_Copy" id="btn_Copy" type="button">Previous QTA Copy</button><!--  
		--><button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table class="search">
			<colgroup>
				<col width=90/>
				<col width=50/>
				<col width=120/>
				<col width=50/>
				<col width=120/>
				<col width="50"/>
				<col width="*" />				
			</colgroup> 
			<tr>
				<td class='sm pad_left_8'><input type="radio" class="trans" name="f_bse_tp_cd" id="f_bse_tp_cd_y" value="Y"><label for="f_bse_tp_cd_y"><strong>Yearly</strong></label></td>
				<th>Year</th>
				<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
				<th><div id="div_qtr">Quarter</div></th>
				<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 70, 1, 1)</script></td>
				<td colspan="2"><div id="div_period"></div></td>
			</tr>
			<tr>
				<td class='sm pad_left_8'><input type="radio" class="trans" name="f_bse_tp_cd" id="f_bse_tp_cd_q" value="Q" checked><label for="f_bse_tp_cd_q"><strong>Quarterly</strong></label></td>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 60, 1)</script></td>
				<th>R/Lane</th>
				<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 1 )</script></td>
				<th>Lane Bound</th>
				<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 60, 1 )</script></td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 개발자 작업  끝 -->

</form>