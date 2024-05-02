<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9160.jsp
*@FileTitle  : Agreement Terminal Rate List Excel Load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9160Event"%>
<%

	String sub_trd_cd = JSPUtil.getNull(request.getParameter("sub_trd_cd"));
	String sub_trd_txt = JSPUtil.getNull(request.getParameter("sub_trd_txt"));
	
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("vol_ut_cd", "01", "CD00177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("io_bnd_code", "01", "CD00890", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("ioc_code", "01", "CD00887", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("thc_tp_code", "01", "CD00161", 0, "1::")%>
	<%= JSPUtil.getIBCodeCombo("tml_ovt_shft_code", "01", "CD00170", 0, "1::")%>
	
    function setupPage(){
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="sub_trd_cd" id="sub_trd_cd" value="<%=sub_trd_cd %>" />
<input type="hidden" name="sub_trd_txt" id="sub_trd_txt" value="<%=sub_trd_txt %>" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Terminal Rate Excel Upload</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_verify"  	id="btn_verify">Verify</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
		<!-- opus_design_grid(S) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>

<Script type="text/javascript">

</script>

<!-- <script type="text/javascript" for="sheet" event="OnChange(Row,Col,Value)">
	var total_rate = "";
	for(i = 30 ;i < 55; i++){
		total_rate  = total_rate + "#" + sheetObjects[0].GetCellValue(Row, i);
	}
alert(total_rate);
	if (Col >29 || Col < 55){
		SetCellValue(Row,"3ts_rt",total_rate);
	}

	if(Col == 27) {
		SetCellValue(Row, "3to_tr_vol_val", GetCellValue(Row, "3to_tr_vol_val").toUpperCase());
		if(GetCellValue(Row, "3to_tr_vol_val") != "MAX"){
			if(!ComIsNumber(GetCellValue(Row, "3to_tr_vol_val"))){
				SetCellValue(Row, "3to_tr_vol_val","");
			}
		}
	}
</script> -->