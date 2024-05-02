<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0106.jsp
*@FileTitle  : Allocation Results
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07.15
* SJH.20150106.MOD : coaPeriod1, VVD
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;	//Error from server
    String strErrMsg = "";              //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0042");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String prevWeek = "";
    //prevWeek =eventResponse.getETCData("prevWk");
%>
<html>
<head>
<title>Allocation Results </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Applytopl" 	id="btn_Applytopl">Apply to P/L</button><!-- 
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
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="800" />
				<col width="*" />
			</colgroup>
			<tr class="h22">
                <td width="600"><script type="text/javascript">coaPeriod1("1","");</script></td>
                <td align="right"></td>
            </tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="*" />
			</colgroup>
			<tr><td class="line_bluedot"></td></tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
                <th>Trade</th>
                <td><script type="text/javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script></td>
                <th>Lane</th>
                <td><div id="div_rLane"><script type="text/javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script></div></td>
                <th>IOC</th>
                <td><script type="text/javascript">ComComboObject('f_selioc',1, 100 , 0 )</script></td>
                <th title="Vessel Voyage Direction">VVD</th>
                <td><input type="text" name="f_vsl_cd" id="f_vsl_cd" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                    <input type="text" name="f_skd_voy_no" id="f_skd_voy_no" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" >
                    <input type="text" name="f_dir_cd" id="f_dir_cd" style="width:30px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);"></td>                    
                </td>
                <th>Cost</th>
                <td><script type="text/javascript">ComComboObject('f_selcost',1, 180 , 1 )</script></td>
              </tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>

