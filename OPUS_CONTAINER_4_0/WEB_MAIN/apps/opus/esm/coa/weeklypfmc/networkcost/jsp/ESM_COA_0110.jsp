<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0110.jsp
*@FileTitle  : Create Networkcost & Slot Charter In & Out
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
*            : SJH.20150106.MOD : coaPeriod1, VVD
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%
    Exception serverException = null;	//Error from server
    String strErrMsg = "";              //Error message
    String xml = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0110");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

    } catch(Exception e) {
        log.error(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_chkprevcre" value="N" id="f_chkprevcre" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Creation" 		id="btn_Creation">Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button>	
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
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
					<col width="51"/>
					<col width="180"/>
					<col width="60"/>
					<col width="150"/>
					<col width="70"/>
					<col width="100"/>
					<col width="52"/>
					<col width="*"/>
			    </colgroup>
			<tbody>
				<tr>
                	<td colspan="8"><script type="text/javascript">coaPeriod1("1","");</script></td>
             	</tr>
				<tr>
	                <th>Trade</th>
	                <td><script type="text/javascript">ComComboObject('f_cobtrade',1, 100 , 0 )</script></td>
	                <th>Lane</th>
	                <td><div id="div_rLane"><script type="text/javascript">ComComboObject('f_coblane',1, 100 , 0 )</script></div></td>
	                <th>Direction</th>
	                <td><script type="text/javascript">ComComboObject('cobDir',1, 100 , 0 )</script></td>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" name="f_vessel" id="f_vessel" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                        <input type="text" name="f_voyage" id="f_voyage" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" >
                        <input type="text" name="f_dir" id="f_dir" style="width:30px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);">
	                </td>
              </tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	
	<div id="tabLayer" style="display:inline" id="mainTable1">
		<div class="opus_design_grid clear">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="t1btng_missingstatus" 		id="t1btng_missingstatus">Missing Status</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- opus_design_btn(E) -->
		</div>
	</div>
	<div id="tabLayer" style="display:none" id="mainTable2">
		<div class="opus_design_grid clear">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="t2btng_missingstatus" 		id="t2btng_missingstatus">Missing Status</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<!-- opus_design_btn(E) -->
		</div>
	</div>
<!-- opus_tab_btn(E) -->
</div>

</form>