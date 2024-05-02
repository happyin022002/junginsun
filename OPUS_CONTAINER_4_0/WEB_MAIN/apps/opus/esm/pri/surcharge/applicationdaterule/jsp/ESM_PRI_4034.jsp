<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4034.jsp
*@FileTitle  : Route Location Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.event.EsmPri4034Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4034Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String screenName		= "";

	Logger log = Logger.getLogger("com.clt.apps.Surcharge.AppliationDateRule");
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmPri4034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var formObj = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		ComSetObjValue(formObj.screenName,"<%=screenName%>");
		loadPage();
	}
</script>

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="chk_scp_cd">
<input type="hidden" name="chk_org_cd">
<input type="hidden" name="chk_conv_cd">
<input type="hidden" name="chk_location">
<input type="hidden" name="chk_flg">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">
<!-- Developer's task	-->   
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
		--><button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="50"/>
				<col width="120"/>
				<col width="80px"/>
				<col width="120px"/>
				<col width="180px"/>
				<col width="*" />
			</colgroup>
				<tr class="h23">
					<th>Scope</th>
					<td>
						<script language="javascript">ComComboObject('scp_cd',0,80,0,0);</script>	
					</td>
					<th>Original  Location</th>
					<td>
						<input type="text" style="width:70px; ime-mode:disabled" name="frm_org_loc_cd" id="frm_org_loc_cd"  class="input" dataformat="engup" maxlength="5"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_orgpopup" id="btn_orgpopup"></button>
					</td>
					<th>Conversion Location</th>
					<td >
						<input type="text" style="width:70px; ime-mode:disabled" name="frm_conv_loc_cd" id="frm_conv_loc_cd"  class="input" dataformat="engup" maxlength="5"><button type="button" class="input_seach_btn" name="btn_convpopup" id="btn_convpopup"></button>
					</td>
				</tr>
		</tbody>
	</table>
</div>
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button>
			<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row&nbsp;Delete</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>