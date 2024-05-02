<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0412.jsp
*@FileTitle : BKG container update Irr.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0412Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0412Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_ofc = null;
	try {
		event = (EesCtm0412Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_ofc = account.getOfc_cd();
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
	  String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	  String strStartdate = DateTime.addMonths(strEnddate, -6, "yyyy-MM-dd");

%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 제목 -->
<div class="page_title_area clear">
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
	<div class="opus_design_inquiry">		
		<table class="search" border="0" style="width:979px;">
			<tr class="h23">
				<th width="30px">LCC</th>
				<td width="90px"><input type="text" style="width:50px;ime-mode:disabled;" class="input1" maxlength="5" name="p_office" tabindex="1" dataformat="engup"></td>
				<th width="30px">Yard</th>
				<td width="150px" style="padding-top:1;">
					<input type="text" style="width:55px;text-align:center;ime-mode:disabled;" class="input" maxlength="5" name="p_yard1" tabindex="2" dataformat="engup"><!--
				    --><script type="text/javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 0, 0, 3)</script>
				</td>
				<th width="55px">Duration</th>
				<td width="250px">
					<input type="text" style="width:75px;ime-mode:disabled;" class="input1" maxlength="8" value="<%=strStartdate%>"  tabindex="4" name="p_date1">~&nbsp;<!--
					--><input type="text" style="width:75px;ime-mode:disabled;" class="input1" maxlength="8" value="<%=strEnddate%>" tabindex="5" name="p_date2"><!--
					--><button type="button" id="btn_Calendar2" name="btn_Calendar2" class="calendar ir"></button>
				</td>
				<th width="55px">Irr. Type</th>
				<td width="150px">
					<select style="width:100px;ime-mode:disabled;" class="input" name="p_irrtype" disabled>
					<option value="">All</option>
					<option value="A" selected>Attach </option>
					<option value="C">Detach </option>
					</select>
				</td>
				<th width="50px">Settled</th>
				<td>
					<select style="width:65px;ime-mode:disabled;" class="input" tabindex="6" name="p_settled">
					<option value="" >All</option>
					<option value="N" selected> N</option>
					<option value="Y"> Y</option>
					</select>
				</td>
			</tr>
		</table>
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 시트영역 -->

</form>
