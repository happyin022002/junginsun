<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0072.js
*@FileTitle  : Block Stowage Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.event.EsdPrd0072Event"%>
<%
	EsdPrd0072Event  event 		= null; 
    Exception serverException   = null;
    DBRowSet rowSet     	 	= null;  
    String strErrMsg 			= "";
    int rowCount    	 		= 0;
    try {
        event = (EsdPrd0072Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
	    loadPage();
    }
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40px" />
				<col width="100px" />
				<col width="40px" />
				<col width="100px" />
				<col width="40px" />
				<col width="100px" />
				<col width="40px" />
				<col width="100px" />
				<col width="40px" />
				<col width="100px" />
				<col width="*" />
			</colgroup>				
			<tbody>
				<tr class="h23">
					<th>Port</th>
					<td><input class="input1" 	type="text" name="port_code" id="port_code" value="" maxlength="5" style="width: 60px;text-align:center" dataformat="engup" style="text-align:center" required caption="Port"><!-- 
						 --><button class="input_seach_btn" name="btn_port_code" id="btn_port_code" type="button"></button>
					</td>
                    <th>Lane</th>
                    <td><input class="input1" 	type="text" name="lane_code" id="lane_code" value="" maxlength="3" style="width: 60px;text-align:center"  dataformat="engup" style="text-align:center" required caption="Lane"><!-- 
                    	 --><button class="input_seach_btn" name="btn_lane_code" id="btn_lane_code" type="button"></button>
                    </td>
					<th>Hub</th>
                    <td><input class="input" 	type="text" name="hub_code" id="hub_code" value="" maxlength="5" style="width: 60px;text-align:center" dataformat="engup" style="text-align:center"></td>                    
                    <th>BS Code</th>
					<td><input class="input" 	type="text" name="bs_code"  id="bs_code" value="" maxlength="3" style="width: 60px;text-align:center"  dataformat="engup" style="text-align:center"></td>
					<th>DEST</th>
					<td><input class="input" 	type="text" name="dest" id="dest" value="" maxlength="5" style="width: 60px;text-align:center"  dataformat="engup" style="text-align:center"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>	

<div class="wrap_result" >
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>

