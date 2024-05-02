<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_0840.jsp
*@FileTitle : Canada Customs Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
        $('<button type="button" class="btn_accent" name="btn_Print"	id="btn_Print">Print</button>').appendTo(".opus_design_btn");
        $('#btn_Print').after($('#btn_Close'));
		loadPage();
	}
</script>

<div class="layer_popup_title">	
	<div class="page_title_area clear">
	   	<h2 class="page_title"><span>ACI Report_Print</span></h2>
	    <div class="opus_design_btn" id="btnArea">
			<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
	    </div>
	</div>
</div>

	<div class="layer_popup_contents">
		
		<div class="wrap_result">
			<div class="opus_design_RD"> 
				<script language="javascript">rdViewerObject('report1');</script>
			</div>
		</div>
	</div>
