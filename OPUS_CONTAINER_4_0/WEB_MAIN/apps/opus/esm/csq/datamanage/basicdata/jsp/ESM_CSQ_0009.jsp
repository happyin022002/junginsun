<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0009.jsp
*@FileTitle  : Basic Data Creation Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");

	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.clt.apps.datamanage.basicdata");

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var curTitle = "Basic Data Creation";
	var curDescription = "Basic Data Creation";
	var p_bse_tp_cd = "<%=p_bse_tp_cd%>";

    function setupPage(){
		var errMessage = "";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_fm_wk" id="f_fm_wk" />
<input type="hidden" name="f_to_wk" id="f_to_wk" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Creation" id="btn_Creation" type="button">Creation</button><!-- 
				 --><button class="btn_accent" name="btn_Close" id="btn_Close" type="button">Close</button>
			</div>
			<!-- opus_design_btn (E) -->
		</div>
		<!-- opus_design_btn (E) -->
		
		<!-- page_location(S) -->
		<div class="location"><span id="navigation"></span></div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
	    <!-- opus_design_inquiry(S) -->
	    <div class="opus_design_inquiry wFit">
	    	<h3 class="title_design2">Establishing Target</h3>       
	        <table>
	            <colgroup>
	                <col width="65" />
	                <col width="40" />
	                <col width="60" />
	                <col width="60" />
	                <col width="60" />
	                <col width="*" />
	            </colgroup>
	            <tbody>
	                <tr>
	                   <th class="sm pad_left_8" style="text-align:left;"><input type="radio" class="trans" name="f_bse_tp_cd" value="Y" id="f_bse_tp_cd1" /><label for="f_bse_tp_cd1">Yearly</label></th>
	                   <th class="sm pad_left_8" style="text-align:left;"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd2" class="trans" value="Q" checked="checked"><label for="f_bse_tp_cd2">Quarterly</label></th> 
	                   <th>Year</th> 
	                   <td><input type="text" style="text-align:center;" class="input2" size="4" name="f_bse_yr" value="<%=p_bse_yr%>" readonly id="f_bse_yr" /></td>
	                   <th><div id="div_qtr">Quarter</div></th> 
	                   <td><input type="text" style="text-align:center;" class="input2" size="3" name="f_bse_qtr_cd" value="<%=p_bse_qtr_cd%>" readonly id="f_bse_qtr_cd" /></td>
	                   <td><div id="div_period"></div></td>          
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <!-- opus_design_inquiry(E) -->
	</div>  
	
	<div class="wrap_search">
	    <!-- opus_design_inquiry(S) -->
	    <div class="opus_design_inquiry wFit">   
	   		<h3 class="title_design2">End Week</h3>    
	        <table>
	            <colgroup>
	                <col width="40" />
	                <col width="60" />
	                <col width="50" />
	                <col width="50" />
	                <col width="70" />
	                <col width="50" />
	                <col width="*" />
	            </colgroup>
	            <tbody>
	                <tr> 
	                   <th>Year</th> 
	                   <td><input type="text" style="text-align:center;" class="input1" size="4" maxlength="4" name="f_year" onchange="period_OnChange();" id="f_year" /> </td>
	                   <th>Week</th> 
	                   <td><input type="text" style="text-align:center;" class="input1" size="2" maxlength="2" name="f_week" onchange="period_OnChange();" id="f_week" /> </td>     
	                   <th>Duration</th> 
	                   <td><input type="text" style="text-align:center;" class="input1" size="2" maxlength="2" name="f_duration" onchange="period_OnChange();" id="f_duration" /> </td>
	                   <td><div id="div_period2"></div></td>
	                </tr>
	                <tr>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>