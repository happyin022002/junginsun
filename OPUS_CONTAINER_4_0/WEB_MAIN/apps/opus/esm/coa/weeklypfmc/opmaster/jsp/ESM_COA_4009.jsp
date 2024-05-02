<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName   : ESM_COA_4009.jsp
*@FileTitle  : Omission Port Management
*@author     : CLT
*@version    : 1.0
*@since      : 2015/05/20
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%> 
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	Exception serverException   = null;         //Error from server
	String strErrMsg    = "";                   //Error message
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_4009");
	String xml = "";
	try {
	    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
	    if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }
	    
	    xml = HttpUtil.makeXML(request,response); 
	    xml = xml.replaceAll("\"", "'");
	    
	}catch(Exception e) {
	    log.error("Exception : " + e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
	    var errMessage = "<%=strErrMsg%>";
	    var formObj = document.form;
	
	    if (errMessage.length >= 1) {
	        ComShowMessage(errMessage);
	    } // end if
	
	    loadPage();
	}
</script>
</head>

<form method="post" name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_cbotrade" id="f_cbotrade" />		<!-- SJH.20150105.ADD -->

<!-- hidden form's iframe -->
<iframe height="0" width="0" name="frmHidden"></iframe>
<!-- hidden form's iframe -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
     --><button type="button" class="btn_accent" name="btn_Save" 	    id="btn_Save">Save</button><!--
     --><button type="button" class="btn_normal" name="btn_Downexcel" 	id="btn_Downexcel">Down Excel</button>		
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50">
					<col width="*">
			    </colgroup>
			    	<tr >
						<th>Period</th>
						<td><input type="text" style="width:80px;" class="input1" name="f_sdate" value="" maxlength="10" dataformat="ymd" id="f_sdate" /></td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<!-- SJH.20141211.MOD -->
		<table width="100%">
			<tbody>
				<colgroup>
					<col width="*">
					<col width="150">
			    </colgroup>
		    	<tr >
					<td align=right></td>
					<td><div class="opus_design_btn">
							<button type="button" class="btn_accent" name="btn_Rowadd"  id="btn_Rowadd">Row Add</button>
							<div id="div_zoom_in" style="display:inline"><button type="button" class="btn_down mar_left_4" id="bu_zoom_in" name="bu_zoom_in" title="Zoom In (+)"></button></div>
					        <div id="div_zoom_out" style="display:none"><button type="button" class="btn_down mar_left_4" id="bu_zoom_out" name="bu_zoom_out" title="Zoom In (-)"></button></div>
						</div>
					</td>
				</tr>		
			</tbody>
		</table>		   		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>

<!-- Developer DIV END -->