<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_904.jsp
*@FileTitle : Total Amount PopUp 화면 - Marine Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-16 parkyeonjin
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
	String param_name = null;
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}

	String tml_inv_tp_cd = request.getParameter("tml_inv_tp_cd")!=null&&!request.getParameter("tml_inv_tp_cd"		).equals("")?request.getParameter("tml_inv_tp_cd" 		):"";

%>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_inv_tp_cd" value="<%=tml_inv_tp_cd%>">

<div class="layer_popup_title">
<div class="page_title_area clear">
	<h2 class="page_title">Total Amount</h2>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
	</div>
</div>
</div>

<div class="layer_popup_contents">
<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</div>

</form>
