<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0164.js
*@FileTitle  : LaneSimulation >> Step1 >> Non Operating Expense (POPUP)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null; 
    String strErrMsg    = "";           
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.lanesimulation.ESM_COA_0164");
    
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } // end else
    }catch(Exception e) {
        log.error("ESM_COA_0164 Exception : "+e.toString());
        out.println(e.toString());
    }

%>
<script type="text/javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        document.form.f_cost_yrmon.focus();
    }

-->
</script>
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Non Operating Expense</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button>><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="10" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr class="h23">
              <td>YYYY-MM  <input type="text" name="f_cost_yrmon" class="input1" style="width:70px;" value="" maxlength="7" onkeypress="ComKeyOnlyNumber(window)" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDash(this , 4);" id="f_cost_yrmon" /></td>
              <th>[Unit : USD 1]&nbsp;&nbsp;[CUR : USD]</th>
           	</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>

