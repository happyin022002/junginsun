<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0023.jsp
*@FileTitle  : Add Carriers
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0023Event"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
    String bsa_op_cd = JSPUtil.getNull(request.getParameter("bsa_op_cd"));
    String bsa_op_nm = "";
    String xml = "";
    
    xml = HttpUtil.makeXML(request,response); 
    xml = xml.replaceAll("\"", "'");
%>


<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
    function setupPage() {
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="bsa_op_cd" id="bsa_op_cd" value = "<%=bsa_op_cd %>">
<input type="hidden" name="crr_cd" id="crr_cd">
<input type="hidden" name="sXml" id="sXml"   value="<%=xml%>"> 
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Add Carriers</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
<!-- 	<div class="location">	
		<span id="navigation"></span>
	</div> -->
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="*" />				
			</colgroup> 
		 	<tr>
                <td>Operation :</td>
                <td><input type="text" style="width:150px" name="bsa_op_nm" id="bsa_op_nm" readOnly></td>
            </tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_add" 			id="btn_add">Add Carrier</button>		
			<button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</div>
</form>
