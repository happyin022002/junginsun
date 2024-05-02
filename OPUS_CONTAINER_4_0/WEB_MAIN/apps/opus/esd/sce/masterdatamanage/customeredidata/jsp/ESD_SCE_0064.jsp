<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0064.jsp
*@FileTitle  : EDI Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%


	String dist = JSPUtil.getNull(request.getParameter("dist"));

%>

<script>
	function setupPage()
	{
		
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="dist" value="<%=dist%>" id="dist" />

<!-- page_title_area(S) -->
<div class="layer_popup_title"> 
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">Multi Input</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">Ok</button><!--  
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents"> 
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Multi Value</th>
					<td></td>
				</tr>
				<tr>
                	<td colspan="2">
                     	<textarea name="multi_value" style="width:100%; height:200px; text-transform:uppercase;"  value=""></textarea>
                     	<br>
                     	Please insert 'enter' after each value
                	</td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</div>	
</form>