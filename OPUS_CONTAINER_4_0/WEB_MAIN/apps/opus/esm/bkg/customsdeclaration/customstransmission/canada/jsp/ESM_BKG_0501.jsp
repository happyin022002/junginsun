<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0501.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="cnt_cd" value="<%=StringUtil.xssFilter(request.getParameter("cnt_cd"))%>">
<input type="hidden" name="io_bnd_cd" value="<%=StringUtil.xssFilter(request.getParameter("io_bnd_cd"))%>">
<input type="hidden" name="snd_dt" value="<%=StringUtil.xssFilter(request.getParameter("snd_dt"))%>">
<input type="hidden" name="his_seq" value="<%=StringUtil.xssFilter(request.getParameter("his_seq"))%>">
<input type="hidden" name="stwg_snd_id" value="<%=StringUtil.xssFilter(request.getParameter("stwg_snd_id"))%>">
<input type="hidden" name="snd_date" value="<%=StringUtil.xssFilter(request.getParameter("snd_date"))%>">
<input type="hidden" name="trsm_msg_tp_id" value="<%=StringUtil.xssFilter(request.getParameter("trsm_msg_tp_id"))%>">

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Canada ACI: Sent File</span></h2>
			<!-- page_title(E) -->

			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_normal" name="btn_Excel" id="btn_Excel">Down Excel</button><!--
				 --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!--
				 --><button type="button" class="btn_normal" name="btn_Close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
	<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->

	<div class="wrap_result">
	<div class="layer_popup_contents">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	</div>
</form>
