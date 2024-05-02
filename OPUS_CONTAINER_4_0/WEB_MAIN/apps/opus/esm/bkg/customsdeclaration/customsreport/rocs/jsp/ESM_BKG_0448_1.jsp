<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0448_1.jsp
*@FileTitle : Rocs Receive History Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.24 임재택
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Rocs Receive History Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body class="popup_bg" onload="setupPage();">
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Rocs Receive History Report</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>		
	</div>
</div>

<div class="layer_popup_contents">
	
	<div class="wrap_result">
		<div class="opus_design_RD"> 
			<script language="javascript">rdViewerObject('csrPrevie');</script>
		</div>
	</div>
</div>