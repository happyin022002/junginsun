<%--
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0978.jsp
*@FileTitle  : CNTR Substitute
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/30
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String callFunc = JSPUtil.getParameter(request, "func");
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="func" value="<%=callFunc%>" id="callFunc" />

 <div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Container Substitute</span></h2>

		<div class="opus_design_btn"><!--
			--><button type="button" class="btn_normal" name="btn_Substitute" id="btn_Substitute">Substitute</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- <!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="opus_design_btn">
		<table>
			<tbody>
				<tr>
					<td width="*">&nbsp;</td>
					<th width="25%">Container Count :</th>
					<td width="15%"><input type="text" name="cntr_cnt" id="cntr_cnt" style="width: 50px;" dataformat="int"></td>
					<td width="40%"><button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry">
		<div class="opus_design_grid">
			<script type="text/javascript">
				   ComSheetObject('sheet1');
			</script>
		</div>
	</div>
</div>
</form>


