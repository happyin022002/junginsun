<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0026.jsp
*@FileTitle  : Inquire/Edit Step-up/Down by Port
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0026Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
	EsmBsa0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String headSet = "";
	String pageRows  = "100";
	String flag = "N";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.BSAManage");
    String xml = "";
    
    try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// Handling in case of calling in ESM_BSA_021
		flag = JSPUtil.getNull(request.getParameter("flag"));
	    flag = (flag=="") ? "N" : flag;

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
    }catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
    function setupPage() {
        loadPage();
        document.form.txtSDate.focus();
    }
</script>

<!-- 2014.11.19 김용습 - iframe을 div로 감싸서 div의 display를 none으로 설정하지 않으면 타이틀 아래 불필요한 하얀 여백이 생겨서, 해당 작업합니다 -->
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<!-- <form method="post" name="form" onSubmit="return false;" onKeyDown="keyEnter_loc();"> -->
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="param1" id="param1" />
<input type="hidden" name="param2" id="param2" />
<input type="hidden" name="param3" id="param3" />
<input type="hidden" name="param4" id="param4" />
<input type="hidden" name="param5" id="param5" />
<input type="hidden" name="param6" id="param6" />
<input type="hidden" name="param7" id="param7" />
<input type="hidden" name="param8" id="param8" />
<input type="hidden" name="flag" value="<%= flag %>" id="flag" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="carrierCd" value="" id="carrierCd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><!-- <button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button>	 -->		
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
				<col width="50" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
                <th style="text-indent:7;">Period</th>
                <td><input class="input1" type="text" name="txtSDate" id="txtSDate" dataformat="ymd" style="width:75px;text-align:center;" ><!-- 
                 --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~ <!-- 
                  --><input type="text" name="txtEDate" id="txtEDate" style="width:75px;text-align:center;" dataformat="ymd"><!-- 
                 --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
                <th>(ETD of 1st Port)</th>
                <th>Trade</th>
                <td><script type="text/javascript">ComComboObject('cobTrade', 1, 60 , 0 )</script></td>
                <th>Lane</th>
                <td><div id="div_rLane"><script type="text/javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div></td>
                <th>Dir.</th>
                <td><script type="text/javascript">ComComboObject('cobDir', 1, 60 , 0 )</script></td>
              </tr>
		</tbody>
	</table>
	<table><tr class="line_bluedot"><td ></td></tr></table>
	<table>
		<tbody>
			<colgroup>
				<col width="350" />
				<col width="*" />
			</colgroup>
			<tr>
                <td><div id="div_bsaKind"></div></td>
                <td></td>
              </tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%;" >
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 80%">
			<table>
				<tbody>
					<colgroup>	
						<col width="260" />
						<col width="120" />
						<col width="*" />
					</colgroup>
					<tr>
		                <td>
		                	<!-- 2014.12.26 김용습 - BSA, Weight Limit 라디오 버튼을 보여주는 부분 js에 구현 되어 있었으나 js에서 막고 jsp에 구현 -->
		                	<div id="div_ui_port">
			                	<input type="radio" name="rdoType" value="007" text="BSA" class="trans"checked>BSA</input>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoType" value="016" text="Weight Limit" class="trans">Weight Limit</input>&nbsp;&nbsp;&nbsp;
		                   	</div>
		                </td>
		                <td>
		                	<div id="div_carrier" style="display:inline">  Carrier <!-- 
		                 		--><script type="text/javascript">ComComboObject('cobCarrier', 1, 60 , 0 )</script>
		                 	</div>
		                 </td>
		                <td></td>
		            </tr>
				</tbody>
			</table>
		</div>
		<!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		
		
		<div class="layout_vertical_2" style="width: 20% ;" >
		<div class="opus_design_grid" style="display:inline">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn" >
		<table><tr><td>
				    	<div id="div_zoom_in" style="display:inline; ">
					    		<button type="button" class="btn_down" name="bu_zoom_in" id="bu_zoom_in" style="margin-right:-3px;padding:0px"></button>
					    	</div>
					    	
					    	</td> 
			 	<td><div id="div_zoom_out" style="display:none;">
					    		<button type="button" class="btn_up" name="bu_zoom_out" id="bu_zoom_out" style="margin:0px;padding:0px"></button>
					    	</div></td></tr></table>
		</div>
		</div>	
	</div>
		</div>
		<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->

<!-- opus_design_inquiry(E) -->

<div id="tabLayer1" style="display:inline">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%">
	
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 69%">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable1">
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btng_save1" 	style="display:none" id="btng_save1" style="display:none">Save</button><!-- 
			 		--><button type="button" class="btn_normal" name="btng_reset" id="btng_reset">Reset</button><!--
					--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button>			
				</div>
				<!-- opus_design_btn(E) -->
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->	
		</div>
		<!-- layout_vertical_2(E) -->
		
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 2%">
			<div style="height:300px"></div>
		</div>
		<!-- layout_vertical_2(E) -->
		
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 29%">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable2">
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn" >
					<button type="button" class="btn_normal" name="btng_portadd" 		id="btng_portadd">Port Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btng_save2" 			id="btng_save2">Save</button><!-- 
			 		--><button type="button" class="btn_normal" name="btng_creation" 			id="btng_creation">Creation</button><!--
					--><button class="btn_normal" type="button" name="btn_downexcel2" id="btn_downexcel2">Down Excel</button>		
				</div>
				<!-- opus_design_btn(E) -->
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->	
		</div>
		<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>


<div id="tabLayer2" style="display:inline">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 69%">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable1">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_save3" 	style="display:none" id="btng_save3" style="display:none">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_reset" 			id="btng_reset">Reset</button><!--
			 --><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button>			
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	</div>
	<!-- layout_vertical_2(E) -->
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 2%">
	<div style="height:300px"></div>
	</div>
	<!-- layout_vertical_2(E) -->
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 29%">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable2">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" >
			<button type="button" class="btn_normal" name="btng_portadd" 		id="btng_portadd">Port Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_save2" 			id="btng_save2">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_creation" 			id="btng_creation">Creation</button><!--
			 --><button class="btn_normal" type="button" name="btn_downexcel2" id="btn_downexcel2">Down Excel</button>		
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	</div>
	<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>
</div>
<!-- opus_design_grid(S) -->

<!-- <div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div> -->

<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
				
</form>

