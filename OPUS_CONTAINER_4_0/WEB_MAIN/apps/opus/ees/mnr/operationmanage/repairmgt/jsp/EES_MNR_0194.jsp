<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0211.jsp
*@FileTitle  : Tire Purchase W/O Inquiry - Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0194Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0194Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		event = (EesMnr0194Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {   
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="retfld" id="retfld" />
<input type="hidden" name="cost_ofc_cd" id="cost_ofc_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<span>Recent Reefer Parts Supply Information</span>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn1_Retrieve" name="btn1_Retrieve" class="btn_accent">Retrieve</button><!--  
			--><button type="button" id="btn1_New" name="btn1_New" class="btn_normal">New</button><!--  
			--><button type="button" id="btn1_Close" name="btn1_Close" class="btn_normal">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50"/>
					<col width="200"/>
					<col width="45"/>
					<col width="50"/>
					<col width="200"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Vessel</th>
					<td><input type="text" name="vsl_cd" style="width: 85px;" value="" class="input" dataformat="engup" id="vsl_cd" /><input name="vsl_eng_nm" type="text" style="width:150px;" value="" class="input2" id="vsl_eng_nm" /> </td>
					<td></td>
					<th>W/O Issue Date</th>
					<td><input type="text" style="width: 80px; text-align:center" class="input1" name="fromcal" maxlength="10"  dataformat="ymd" required="" id="fromcal" /><input type="text" style="width: 80px; text-align:center" class="input1" name="tocal" maxlength=10  dataformat="ymd" required  ><button type="button" class="input_seach_btn" name="btn_calendar" id="btn_calendar"></button></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>			