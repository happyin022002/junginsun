<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0114.jsp
*@FileTitle  : Missing List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                               //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0114");

    try {
        //ADD ----------------------------------------------------------------------------------------- START
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //ADD ----------------------------------------------------------------------------------------- END

    }catch(Exception e) {
        log.error("ESM_COA_0114 Exception : "+e.toString());
    }

    String strType     = JSPUtil.getNull(request.getParameter("f_strtype"));
    if (strType.equals("")) {
        strType = "1";
    }
%>
<script type="text/javascript">
    function setupPage() {
        loadPage();
    }
</script>
<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_stryear" value="<%=JSPUtil.getNull(request.getParameter("f_stryear")) %>" id="f_stryear" />
<input type="hidden" name="f_strfmmonth" value="<%=JSPUtil.getNull(request.getParameter("f_strfmmonth")) %>" id="f_strfmmonth" />
<input type="hidden" name="f_strtomonth" value="<%=JSPUtil.getNull(request.getParameter("f_strtomonth")) %>" id="f_strtomonth" />
<input type="hidden" name="f_strfmweek" value="<%=JSPUtil.getNull(request.getParameter("f_strfmweek")) %>" id="f_strfmweek" />
<input type="hidden" name="f_strtoweek" value="<%=JSPUtil.getNull(request.getParameter("f_strtoweek")) %>" id="f_strtoweek" />
<input type="hidden" name="f_strchkprd" value="<%=JSPUtil.getNull(request.getParameter("f_strchkprd")) %>" id="f_strchkprd" />
<input type="hidden" name="f_strtrade" value="<%=JSPUtil.getNull(request.getParameter("f_strtrade")) %>" id="f_strtrade" />
<input type="hidden" name="f_strlane" value="<%=JSPUtil.getNull(request.getParameter("f_strlane")) %>" id="f_strlane" />
<input type="hidden" name="f_strvessel" value="<%=JSPUtil.getNull(request.getParameter("f_strvessel")) %>" id="f_strvessel" />
<input type="hidden" name="f_strvoyage" value="<%=JSPUtil.getNull(request.getParameter("f_strvoyage")) %>" id="f_strvoyage" />
<input type="hidden" name="f_strdir" value="<%=JSPUtil.getNull(request.getParameter("f_strdir")) %>" id="f_strdir" />
<input type="hidden" name="f_strtype" value="<%=strType%>" id="f_strtype" />
<input type="hidden" name="f_strprcnm" value="<%=JSPUtil.getNull(request.getParameter("f_strprcnm")) %>" id="f_strprcnm" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">Missing List</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_accent" type="button" name="btn_Close" id="btn_Close">Close</button></div>
	<!-- opus_design_btn (E) -->

</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="200" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Cost Item</th>
	                <td><script type="text/javascript">ComComboObject('f_cobcost',1, 180 , 0 )</script></td>
	                <td><div id="div_bsazrflg"><input type="checkbox" name="f_chk_bsazrflg" value="N" checked="true" class="trans" id="f_chk_bsazrflg" onClick="chgBsazrflg();"/>Exclusion BSA Flag</div></td>
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

<script type="text/javascript">
<!--
    with(document.form) {       
        if (f_strtype.value == "3") { //Company SalesSlot Cht-out Missing 일때
            f_cobcost.disabled = true;
        }   }
-->
</script>
