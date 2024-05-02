<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0123.jsp
*@FileTitle  : Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
	//SJH.20141222.ADD : 인자값..
    Exception serverException = null;
    String strErrMsg = "";
    
    String f_vsl_cd = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.jsp.ESM_COA_0123");
    try {
    	f_vsl_cd = JSPUtil.getNull(request.getParameter("f_vsl_cd"));
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } //end of if
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<script type="text/javascript">
    function setupPage() {
        loadPage();
        btn_Retrieve.focus();
    }
</script>

<form method="post" name="form" id="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Vessel Information</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Downexcel</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
	<colgroup>
		<col width="50"/>
		<col width="100"/>
		<col width="50"/>
		<col width="*" />
	</colgroup>
		<tbody>
	 	<tr>
           <th>Vessel</th>
           <td><input type="text" name="f_vsl_cd" id="f_vsl_cd" style="width:80px;text-align:center;" maxlength="4" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');"onFocus="this.select();" value="<%=f_vsl_cd%>"><!-- SJH.20141222.ADD --></td>
           <th>Carrier</th>
           <td><input type="text" name="f_crr_cd" id="f_crr_cd" style="width:80px; text-align:center;" maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');"onFocus="this.select();" ></td>
		</tr>
  	</tbody>
</table>
</div>
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
</form>
<script type="text/javascript">
<!--
    with(document.form) {
    }
-->
</script>
