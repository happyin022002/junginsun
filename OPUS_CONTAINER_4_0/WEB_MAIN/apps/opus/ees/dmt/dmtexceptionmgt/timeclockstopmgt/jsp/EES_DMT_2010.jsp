<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2010.jsp
*@FileTitle  : Time Clock Stop Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event.EesDmt2010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	//EES_DMT_2011 Calls on the screen as a pop-up parameters used in 
	String  clk_stop_no     = request.getParameter("parm") == null ? "" : (String)request.getParameter("parm");
	String  popup     		= request.getParameter("parm2") == null ? "" : (String)request.getParameter("parm2");

	EesDmt2010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_ofc_cd 	= "";
	
	String todate = DateTime.getDateString().replace(".","-");
	//out.println("[todate]"+todate);
	//Logger log = Logger.getLogger("com.clt.apps.DMTExceptionMgt.TimeClockStopMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 		=	account.getUsr_id();
		strUsr_nm 		= account.getUsr_nm().trim();
		strOfc_cd 		= account.getOfc_cd().trim();
		strRhq_ofc_cd 	= account.getRhq_ofc_cd();
		
	   
	   
		event = (EesDmt2010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="clk_stop_ofc_cd">
<input type="hidden" name="clk_stop_yd_cd">
<input type="hidden" name="all_yd_flg">
<input type="hidden" name="popup" value="<%=popup %>">
<input type="hidden" name="s_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="s_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="s_cre_dt" value="<%=todate %>">
<input type="hidden" name="rhq_ofc_cd" value="<%=strRhq_ofc_cd %>">
<input type="hidden" name="button_mode">
<input type="hidden" name="auth_yn">

<input type="hidden" name="backendjob_key"> <!-- BackEndJob -->

				
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->		
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Cancel" id="btn_Cancel">Cancel</button>
		</div>
		<!-- opus_design_btn(E) -->
		
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table> 
	        <colgroup>
	            <col width="95px" />
	            <col width="253px" />
	            <col width="99px" />
	            <col width="90px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Clock Stop No. </th>
					<td><input type="text" name="clk_stop_no" id="clk_stop_no" style="width:120px;text-align:left" class="input" value="<%=clk_stop_no %>"></td>
					<th>Status</th>
					<td><input type="text" name="cxl_flg" id="cxl_flg" style="width:80px;text-align:left" class="input2" readonly></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		 <table>
	        <colgroup>
	            <col width="95px" />
	            <col width="560px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Tariff Type</th>
					<td>
						<script language="javascript">ComComboObject('combo1', 2, 80 , 0, 1)</script>&nbsp;<input type="text" name="dmdt_trf_nm" id="dmdt_trf_nm" style="width:560px;text-align:left" class="input2" readonly>
					</td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>Office</th>
					<td>
						<script language="javascript">ComComboObject('combo2', 2, 80 , 0, 1)</script>&nbsp;<input type="text" name="clk_stop_ofc_nm" id="clk_stop_ofc_nm" style="width:560;text-align:left" class="input2" readonly>
					</td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>Yard</th>
					<td>
						<script language="javascript">ComComboObject('combo3', 2, 80 , 0, 1)</script>&nbsp;<input type="text" name="clk_stop_yd_nm" id="clk_stop_yd_nm" style="width:560;text-align:left" class="input2" readonly>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		 <table>
	        <colgroup>
	            <col width="95px" />
	            <col width="260px" />
	            <col width="93px" />
	            <col width="40px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Stop Period</th>
					<td>
					<input type="text" style="width:80px;" class="input1" name="clk_stop_fm_dt" id="clk_stop_fm_dt" dataformat="ymd"  caption="From Date">&nbsp;~
					<input type="text" style="width:80px;" class="input1" name="clk_stop_to_dt" id="clk_stop_to_dt" dataformat="ymd"  caption="To Date" ><!--
					--><button type="button" class="calendar" name="btns_calendar"></button>
					</td>
					<th>Stop Days</th>
					<td><input type="text" name="stop_days" id="stop_days" style="width:40px;" class="input2" readonly></td>
					<td></td>
				</tr>
				
			</tbody>
		</table>
		
		<div class="line_bluedot"></div>
		<table>
	        <colgroup>
	            <col width="95" />
	            <col width="150" />
	            <col width="40" />
	            <col width="84" />
	            <col width="79" />
	            <col width="300" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Date</th>
					<td><input type="text" name="upd_dt" id="upd_dt" value="" style="width:80px;" class="input2" readonly></td>
					<th>Office</th>
					<td><input type="text" name="upd_ofc_cd" id="upd_ofc_cd" value="<%=strOfc_cd %>" style="width:60px;" class="input2" readonly></td>
					<th>Name</th>
					<td><input type="text" name="upd_usr_id" id="upd_usr_id" value="<%=strUsr_nm %>" style="width:284px;" class="input2" readonly></td>
					<td></td>
				</tr>
				
			</tbody>
		</table>
		
		<table>
	        <colgroup>
	            <col width="95px" />
	            <col width="80%" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th class="tr2_head" >Remark(s)</th>
					<td class="input"><textarea name="clk_stop_rmk" id="clk_stop_rmk" style="width:100%;height:90px;ime-mode:disabled;" onKeyPress="DmtComKeyOnlyAlphabet('upperall')"></textarea></td>
					<td></td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="topdeck" style="position:absolute;visibility:hidden;z-index:200;">
	    			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</form>
<!-- Developer's task end -->