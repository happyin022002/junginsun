<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName   : ESM_COA_4001.jsp
*@FileTitle  : Slot Internal Pricing
*@author     : SJH
*@version    : 1.0
*@since      : 2014/10/02
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
	String strErrMsg    = "";                               //Error message
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_4001");
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
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Downexcel" 	id="btn_Downexcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_loadexcel"  	id="btn_loadexcel">Load Excel</button>	
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
					<col width="100">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="100">
					<col width="150">
					<col width="100">
					<col width="*">
			    </colgroup>
			    	<tr >
						<th>Effective Month</th>
						<td><input type="text" name="f_fm_mon"  class="input1" style="width:60;text-align:center;" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);" id="f_fm_mon" /></td>
						<th>Service Lane</th>
						<td>
							<script type="text/javascript">ComComboObject('f_selslane',1, 110 , 0 )</script>
						</td>						
						<th>Trade</th>
						<td>
							<script type="text/javascript">ComComboObject('f_trd_cd',1, 110 , 0 )</script>
						</td>
						<th>Sub Trade</th>
						<td>
							<script type="text/javascript">ComComboObject('f_sub_trd_cd',1, 110 , 0 )</script>
						</td>						
					</tr>
					<tr>
						<th>From Country/Port</th>
						<td><!-- SJH.20141105.MOD -->
							<input type="text" style="width:80" name="f_from" value="" maxlength="5" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" >
					        <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search3" onClick="openLocationCode('getF_from');">
						</td>
						<td colspan="2"> ~
							<input type="text" style="width:80" name="f_to" value="" maxlength="5" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" >
					        <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search4" onClick="openLocationCode('getF_to');">
						</td>
						<th>Cargo Type</th>
						<td>
							<script language="javascript">ComComboObject('f_type_cd',1, 110 , 0 )</script>
						</td>
						<td colspan="2"></td>
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
					<col width="240">
			    </colgroup>
		    	<tr >
					<td align=right>(USD)</td>
					<td><div class="opus_design_btn">
							<button type="button" class="btn_accent" name="btn_Rowadd"  id="btn_Rowadd">Row Add</button>
							<button type="button" class="btn_normal" name="btn_Rowcopy" id="btn_Rowcopy">Row Copy</button>
							<button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button>
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