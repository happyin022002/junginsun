<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1096.jsp
*@FileTitle  : Email(Edit)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1096Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String calllFunc = "";
	try {
		calllFunc  = JSPUtil.getParameter(request, "func");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript" type="text/javascript" src="/opuscntr/syscommon/common/fckeditor/ckeditor.js"></script>
<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>
</head>

<form name="form"> 
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Customer Notification</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Send" id="btn_Send">Send Email</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="60px" />
				<col width="100%" />
			</colgroup>
			<tbody>
				<tr>
					<th>Contents</th>
					<td><textarea class="ckeditor" name="edt_contents" id="edt_contents" style="width:99%;height:200;"></textarea></td>
				</tr>    

			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- popup_contens_area(E) -->
</form>
