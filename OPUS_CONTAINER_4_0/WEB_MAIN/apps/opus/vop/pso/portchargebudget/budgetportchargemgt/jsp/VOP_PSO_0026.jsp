<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0026.jsp
*@FileTitle  : Budget vs Actual
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String statusCd = JSPUtil.getCodeCombo("status", "01", "style='width:175px'", "CD02355", 0, "000030:ALL:ALL");
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="vvd" id="vvd" value="" />
<!-- Field for BackEndJob -->
<input type="hidden" name="key" id="key" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button"><span id="title"></span></button>
		</h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--  
			 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail" style="display:none">Detail</button>
		</div>
		<!-- opus_design_btn(E) -->
		
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<!-- wrap_search_tab(S) -->
	<div class="wrap_search">	
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table border="1">
				<colgroup>					
					<col width="60px" /> <!-- Date text -->
					<col width="140px" /> <!-- Date cond -->
					<col width="80px" /> <!-- Date from -->
					<col width="95px" /> <!-- Date to / btn -->
					<col width="60px" /> <!-- CTRL H/Q text -->
					<col width="155px" /> <!-- CTRL H/Q combo 1, combo2-->
					<col width="60px" /> <!-- Service Provider text -->
					<col width="150px" /> <!-- sp cond2 -->
					<col width="75px" /> <!-- sp cond3 -->
					<col width="175px" /> <!-- Status text -->
					<col width="*" />
				</colgroup>
					<tbody>
					<tr>					
						<th>Date</th>
						<td colspan="3"><!-- 
							 --><select name="date_type" id="date_type" style="width:140px;" class="input1"><!-- 
								 --><option value="CR" selected="selected">Invoice Created DT</option><!-- 
								 --><option value="IS">Invoice Issue DT</option><!-- 
								 --><option value="VVD">VVD ETD</option>									
							</select><!--		
							--><input type="text" name="from_date" id="from_date" dataformat="ymd" style="width:80px;text-align:center;" class="input1" value="" maxlength="10"><!--
							--><input type="text" name="to_date"  id="to_date" dataformat="ymd" style="width:80px;text-align:center;" class="input1" value="" maxlength="10"><!--
							--><button type="button" class="calendar" id="btn_period" name="btn_period"></button>							
						</td>
						<th>CTRL H/Q</th>
						<td><script type="text/javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script><!--
							--><script type="text/javascript">ComComboObject('sls_ofc_cd',1,70,1,0);</script>
						</td>
						<th>Service Provider</th>
						<td><input type="text" name="vndr_seq" id="vndr_seq" style="width:55px; text-align: center" class="input" value="" dataformat="num" maxlength="6"><!--
							--><button type="button" class="input_seach_btn" id="btns_VendorSeq" name="btns_VendorSeq"></button><!--							
							--><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="width:125px; text-align: left" class="input2" value="" readonly>
						</td>
						<th>Status</th>
						<td><%=statusCd%></td>
						<td></td>
					</tr>
					<tr>
						<th>Account</th>
						<td><script type="text/javascript">ComComboObject('combo1',2,85,0);</script></td>
						<th>Lane</th>
						<td><input name="vsl_slan_cd" id="vsl_slan_cd" dataformat="engup" maxlength="3" type="text" style="width:80px;text-align:center;" class="input" value=""><!--
							--><button type="button" class="input_seach_btn" id="btn_lane_search" name="btn_lane_search"></button>							
						</td>						
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vsl_cd" id="vsl_cd" dataformat="engup" style="width:45px;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="4"><!--
							--><input type="text" name="skd_voy_no" id="skd_voy_no" dataformat="num" style="width:38px;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="4"><!--
							--><input type="text" name="skd_dir_cd" id="skd_dir_cd" dataformat="enguponly" style="width:34px;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="1"><!--
							--><button type="button" class="input_seach_btn" id="btn_vvd_search" name="btn_vvd_search"></button>							
						</td>
						<th>Port</th>
						<td><input name="port_cd" id="port_cd" type="text" dataformat="engup" style="width:55px;text-align:center;" class="input" value="" size="5" maxlength="5" ><!--
							--><button type="button" class="input_seach_btn" id="btn_port_cd" name="btn_port_cd"></button><!--
							--><script type="text/javascript">ComComboObject('term_code',2, 60, 1);</script>
						</td>
						<th>Vessel Class</th>
						<td><script type="text/javascript">ComComboObject('cntr_vsl_clss_capa',1,85,0);</script></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>

</form>
