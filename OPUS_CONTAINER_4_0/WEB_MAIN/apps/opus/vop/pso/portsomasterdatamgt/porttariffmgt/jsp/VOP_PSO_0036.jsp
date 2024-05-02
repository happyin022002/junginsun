<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0036.jsp
*@FileTitle  : Port Tariff 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0036Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");
	//from VOP_PSO_0036 
	String movedFrom = request.getParameter("moved_from") == null ? "" : request.getParameter("moved_from");
	String movedParams = request.getParameter("moved_params") == null ? "" : request.getParameter("moved_params");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopPso0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="yd_cd" name="yd_cd" value="" type="hidden" />
<input id="vndr_seq" name="vndr_seq" value="" type="hidden" />
<input id="lgs_cost_cd" name="lgs_cost_cd" value="" type="hidden" />
<input id="eff_dt" name="eff_dt" value="" type="hidden" />
<input id="combo1" name="combo1" value="" type="hidden" />
<input id="combo3" name="combo3" value="" type="hidden" />
<input id="combo5" name="combo5" value="" type="hidden" />
<input id="from_date" name="from_date" value="" type="hidden" />
<input id="to_date" name="to_date" value="" type="hidden" />
<input id="desc" name="desc" value="" type="hidden" />
<input id="moved_from" name="moved_from" value="<%=movedFrom%>" type="hidden" />
<input id="moved_params" name="moved_params" value="<%=movedParams%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn1_Tariff_Update" id="btn1_Tariff_Update">Tariff Update</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="10px" />
					<col width="30px" />
					<col width="190px" />
					<col width="30px" />
					<col width="100px" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Port</th>
					<td><input name="port_cd" id="port_cd" type="text" dataformat="engup" style="width: 50px; text-align:left;" class="input1" value="" size="5" maxlength="5"/><button type="button" class="input_seach_btn" name="btn_port_cd" id="btn_port_cd"></button><script type="text/javascript">ComComboObject('combo',2,60,0,3);</script></td>
					<th>Year</th>
					<td><input id="year" name="year" dataformat="yyyy" maxlength="4" style="width: 45px; text-align:center;" class="input1" value="" type="text" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width: 30%">
	        <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 1%;">
	       <table><tr><td>&nbsp;</td></tr></table>
	    </div>
	    
	    <div class="layout_vertical_2"  style="width: 69%;">
	        <!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry" >
				<table>
					<tbody>
						<colgroup>
							<col width="10%" />
							<col width="20%" />
							<col width="5%" />
							<col width="10%" />
							<col width="10%" />
							<col width="45%" />
						</colgroup>
						<tr>
							<th>Effective Date</th>
							<td><script type="text/javascript">ComComboObject('combo2',1,170,1,3);</script></td>
							<th>Ver</th>
							<td><script type="text/javascript">ComComboObject('comboVer',1,60,1,3);</script></td>
							<th>Updated By</th>
							<td><input id="updated_by" name="updated_by" style="width: 70px; text-align:center;" value="" class="input2" readonly type="text" /><!-- 
							 --><input id="updated_date" name="updated_date" style="width: 130px; text-align:center;" value="" class="input2" readonly type="text" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<table style="width:99%;">
				<tr>
					<td><h3 class="title_design">Base</h3></td>
					<td><div style="text-align: right;"><!-- 
						--><span style="font-weight: bold"><input id="cpls_flg" name="cpls_flg" value="" class="trans" disabled="" type="checkbox"/> Compulsory </span><!-- 
						--></div></td>
	        	</tr>
			</table>
			<!-- opus_design_inquiry(E) -->
			<div id="myDiv0211" style="display:inline;">
				<!-- opus_design_grid(S) -->
		         <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		        
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		        	<h3 class="title_design">Surcharge</h3>
		        	<br/>
					<script type="text/javascript">ComSheetObject('sheet3');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		        
		        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		        
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		        	<h3 class="title_design">Discount</h3>
		        	<br/>
					<script type="text/javascript">ComSheetObject('sheet4');</script>
		        </div>
	        </div>
	        <!-- opus_design_grid(E) -->
	
			<!-- DIV : VOP_PSO_0212.do -->
			<div id="myDiv0212" style="display: none;">
				<div class="layout_wrap">
					<div class="layout_vertical_2" style="width: 49%">
				        <!-- opus_design_grid(S) -->
				        <div class="opus_design_grid">
							<script type="text/javascript">ComSheetObject('sheet5');</script>
				        </div>
				        <!-- <table class="height_10"><tr><td></td></table> -->
				        <!-- opus_design_grid(E) -->
				        <span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 10px;">*Formula</span>
				        <div id="foml_desc" style="width: 99%; height: 100px; border: double 1px; overflow-y: auto; overflow-x: hidden; padding: 2px; border-color: #5B8A9E; background-color:#FFFFFF;"></div>
				        
				        <span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 10px;">*Condition</span>
				        <div id="cond_desc" style="width: 99%; height: 100px; border: double 1px; overflow-y: auto; overflow-x: hidden; padding: 2px; border-color: #5B8A9E; background-color:#FFFFFF;"></div>
				        
				    </div>
				    <div class="layout_vertical_2" style="width: 1%">
				    	<table><tr><td>&nbsp;</td></tr></table>
				    </div>
				    <div class="layout_vertical_2" style="width: 50%">
				        <!-- opus_design_grid(S) -->
				        <div class="opus_design_grid">
							<script type="text/javascript">ComSheetObject('sheet6');</script>
				        </div>
				        <!-- <table class="height_10"><tr><td></td></tr></table> -->
				        <br>
				        <div class="opus_design_grid">
							<script type="text/javascript">ComSheetObject('sheet7');</script>
				        </div>
				        <!-- opus_design_grid(E) -->
				    </div>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			        
				<!-- Surcharge -->
				<div class="opus_design_grid">
					<h3 class="title_design">Surcharge</h3>
			       	<br/>
					<script type="text/javascript">ComSheetObject('sheet8');</script>
				</div>
			        
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			        
				<!-- Discount -->
				<div class="opus_design_grid">
					<h3 class="title_design">Discount</h3>
			       	<br/>
					<script type="text/javascript">ComSheetObject('sheet9');</script>
				</div>
				<div id="div_base_dummy" style="display:none">
					<div class="opus_design_grid">
					<h3 class="title_design">Base Dummy</h3>
						<script type="text/javascript">ComSheetObject('sheet10');</script>
					</div>
				</div>
				
				</div>
				
			</div>
	
		</div>
	</div>
	<!-- layout_wrap (E) -->
</div>
</form>