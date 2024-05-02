<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName   : ESM_COA_4010.jsp
*@FileTitle  : Crosscheck between COA vs BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2015/06/20
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
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_4010");
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
     --><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
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
					<col width="150">
					<col width="250">
					<col width="100">
					<col width="*">
			    </colgroup>
			    	<tr >
						<th><input type="radio" class="trans" name="conditionType" id="conditionType1" value="0" onClick="changeConditionType(this.value);" checked><!--
                        --><label for="conditionType1">Target Period</label></th>
						<td><input class="input1" type="text" name="f_from" id="f_from" style="width:75px;text-align:center;" maxlength="8" autocomplete="off" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value=""><!--
                        --><span class = "dash">~</span><!--
                        --><input class="input1" type="text" name="f_to" id="f_to" style="width:75px;text-align:center;" maxlength="8" autocomplete="off" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value=""><!--
                        --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
						<th><input type="radio" name="conditionType" id="conditionType2" class="trans" value="1" onClick="changeConditionType(this.value);"><!--
                        --><label for="conditionType2">T.VVD</label></th>
						<td><input type="text" name="f_vsl_cd" id="f_vsl_cd" class="input1" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);"><!--
                        --><input type="text" name="f_skd_voy_no" id="f_skd_voy_no" class="input1" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" ><!--
                        --><input type="text" name="f_dir_cd" id="f_dir_cd" class="input" style="width:35px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);"></td>						
					</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
    <div class="opus_design_btn" >
        <div id="div_zoom_in" style="display:inline" class="grid_option_right mar_btm_4">
            <button type="button" class="btn_down" name="bu_zoom_in" title="Zoom in(+)"></button>
        </div>
        <div id="div_zoom_out" style="display:none" class="grid_option_right mar_btm_4">
            <button type="button" class="btn_up" name="bu_zoom_out"  title="Zoom out(-)" ></button>
        </div>
          </div>
        <script type="text/javascript">ComSheetObject('sheet1');</script> 
        <font>&nbsp;* MT - PRD generation error because of no MT pickup or return yard registered in MDA.</font><br>
		<font>&nbsp;* T/T - PRD generation error because of no Transit Time.</font><br>
		<font>&nbsp;* CMDT - Commodity name in BKG has not been registered in MDA.</font><br>
		<font>&nbsp;* VVD - No Target VVD registered in COA.</font><br>
		<font>&nbsp;* ST - BKG status mismatch against COA. </font><br>
		<font>&nbsp;* OTH - Other error reasons which are not groupped as default.</font><br>
    </div>
    <!-- opus_design_grid(E) -->
</div>
</form>

<!-- Developer DIV END -->