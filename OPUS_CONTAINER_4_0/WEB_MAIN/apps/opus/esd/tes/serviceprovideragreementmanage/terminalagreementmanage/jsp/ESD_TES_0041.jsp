<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0041.jsp
*@FileTitle : China Special Feeder
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0041Event"%>
<%
	EsdTes0041Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;	//DB ResultSet 리스트의 건수
	String screenName		= "";
	
	try {

		event = (EsdTes0041Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			GeneralEventResponse eventResponse = (GeneralEventResponse) request
			.getAttribute("EventResponse");
			Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	screenName = screen.getName();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
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
<input type="hidden" name="search_cd">
<input type="hidden" name="chk_pol_cd">
<input type="hidden" name="chk_pod_cd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry wFit">		
	<table>
		<tr class="h23">
			<th width="1px" class="input2">POL</th>
			<td width="200px">
				<input type="text" style="width:130px; ime-mode:disabled" name="pol_cd" class="input" dataformat="engup" maxlength="5"><!-- 
				--><button type="button" class="input_seach_btn" name="btn_polpopup"></button>
			</td>
			<th width="40px" class="input2">POD</th>
			<td width="*">
				<input type="text" style="width:130px; ime-mode:disabled" name="pod_cd" class="input" dataformat="engup" maxlength="5"><!-- 
				--><button type="button" class="input_seach_btn" name="btn_podpopup"></button>
			</td>
		</tr>
	</table>
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">	
	<div class="opus_design_btn">
	   <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
	   <button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
	</div>
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 시트영역 -->
</div>
</form>
