<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName  : ESM_SAQ_0179.jsp
*@FileTitle  : Office Verify
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0179Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0179Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;  	//error from server
	String strErrMsg = "";					//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaCreation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0179Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
  var sFunc = '<%=JSPUtil.getParameter(request, "func")%>';
  var iSheetIdx = '<%=JSPUtil.getParameter(request, "sheetIdx")%>';
  var iRow = '<%=JSPUtil.getParameter(request, "row")%>';
  var iCol = '<%=JSPUtil.getParameter(request, "col")%>';

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
<input type="hidden" name="mqta_mdl_ver_no">
<input type="hidden" name="trd_cd">
<input type="hidden" name="rq_year" value='<%=JSPUtil.getParameter(request, "year")%>' >
<input type="hidden" name="rq_bse_qtr_cd" value='<%=JSPUtil.getParameter(request, "bse_qtr_cd")%>'>
<input type="hidden" name="rq_trade" value='<%=JSPUtil.getParameter(request, "trade")%>'>
<input type="hidden" name="rq_bound" value='<%=JSPUtil.getParameter(request, "bound")%>'>
<input type="hidden" name="rq_search_lane" value='<%=JSPUtil.getParameter(request, "search_lane")%>'>

<!-- 개발자 작업 -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title" id="popup_title" name="popup_title"><span>Office Verify</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--			
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<!-- <div class="location">
			<span id="navigation"></span>
		</div> -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry">
			<table>
				<colgroup>
					<col width="35px" />					
					<col width="110px" />
					<col width="55px" />
					<col width="110px" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>						
						<th>Year</th>
						<td><select class="input1" id="year" name="year" style="width:60px;"></select></td>
						<th>Quarter</th>
						<td><select class="input1" id="bse_qtr_cd" name="qtr_cd" style="width:60px;"></select></td>
						<td></td>
						<!--<th>Trade</th>-->
						<!--<td><script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script></td>-->
						<!--<th>Bound</th>-->
						<!--<td><select class="input" id="bound" name="bound" style="width:60px;"></select></td>-->
					</tr>
				</tbody>
			</table>			
		</div>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowdel" id="btn_rowdel">Delete</button>				
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>			
<!-- 개발자 작업 끝 -->
</div>
</form>