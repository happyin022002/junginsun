<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0108.jsp
*@FileTitle  : S/C Performance Summary 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%
String scNo = "";
String scNo1 = "";
String scNo2 = "";
String srcAddr = "ESM_PRI_0108_01.do";

scNo = JSPUtil.getNull(request.getParameter("cond_sc_no"));

if (scNo != null && scNo !="" && scNo.length() >= 3){
	scNo1 = scNo.substring(0,3);
	scNo2 = scNo.substring(3,scNo.length());
	srcAddr = "ESM_PRI_0108_02.do";
}
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script> 

<form name="form">
<input type="hidden" name="sc_no1" value="<%= scNo1%>">
<input type="hidden" name="sc_no2" value="<%= scNo2%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_bl_list" id="btn_bl_list">B/L List</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
			<colgroup>
				<col width="60" />
				<col width="120" />
				<col width="" />
			</colgroup>
			<tr style="height:33px">
				<th>Type</th>
				<td class="sm" style="width:120px;">
					<input type="radio" class="trans" name="rdoSummaryType" id="rdoSummaryType1" value="S" checked><label for="rdoSummaryType1">Summary</label>
					<input type="radio" class="trans" name="rdoSummaryType" id="rdoSummaryType2" value="D"><label for="rdoSummaryType2">Details by S/C</label>
				</td>
				<td></td>
			</tr>		
		</table>
	</div>
</div>
		
<div style="display:inline;">
	<iframe name="subframe" id="subframe" frameborder="0" scrolling="no" width="100%" height="580" src="<%=srcAddr%>"></iframe>
</div>
<!-- page(E) -->

</form>