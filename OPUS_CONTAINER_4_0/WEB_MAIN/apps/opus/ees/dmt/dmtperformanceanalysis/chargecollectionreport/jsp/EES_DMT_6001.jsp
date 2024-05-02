<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_6001.jsp
*@FileTitle  : Current Collection Status by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6001Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt6001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.ChargeCollectionReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc	= account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt6001Event)request.getAttribute("Event");
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

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Developer's task	-->
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="dmdt_cntr_tp_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="start_dt">
<input type="hidden" name="end_dt">
<input type="hidden" name="head_office"			value="<%=ConstantMgr.getHeadOfficeCode()%>"><!-- HEAD OFFICE -->

	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--			
			--><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize">Minimize</button><!--
			--><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--
			--><button type="button" class="btn_normal" name="btn_DetailA" id="btn_DetailA" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()">Detail(A)</button><!--
			--><button type="button" class="btn_normal" name="btn_DetailB" id="btn_DetailB" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()">Detail(B)</button><!--
			--><button type="button" class="btn_normal" name="btn_DetailC" id="btn_DetailC" onmouseover="obj_mouseover()" onmouseout="obj_mouseout()">Detail(C)</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
	<!--Page Title, Historical (E)-->
	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit" id="sch_cond_div">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="650px" />
		            <col width="320px" />				            	            
		            <col width="" />
				</colgroup>
				<tbody>
					<tr>
						<td>
							<table>
								<colgroup>
						            <col width="120px" />
						            <col width="530px" />				            	            
						            <col width="" />
								</colgroup>
								<tbody>
									<tr>
										<th class="sm">To MVMT Date&nbsp;&nbsp;</th>
										<td class="sm" style="padding-top:5px !important">
											<input type="radio" name="dt_flg" id="dt_flg_1" value="M" class="trans" checked onclick="dt_flg_click()"><!--
											--><label for="dt_flg_1">Month</label>
											<input type="text" name="to_mvmt_mon" id="to_mvmt_mon" maxlength="6" dataformat="ym" style="width:65px" class="input1" value=""><!--
											--><input type="radio" name="dt_flg" id="dt_flg_2" value="P" class="trans" onclick="dt_flg_click()"><!--
											--><label for="dt_flg_2">Period</label><!--
											--><input type="text" name="fm_dt" id="fm_dt" dataformat="ymd" style="width:80px" class="input1">~&nbsp;<!--
											--><input type="text" name="to_dt" id="to_dt" dataformat="ymd" style="width:80px" class="input1"><!--										
											--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
										</td>
										<td></td>
									</tr>
									<tr>
										<th class="sm">DEM/DET Office&nbsp;&nbsp;</th>
										<td class="sm">
											<input type="radio" name="ofc_flg" id="ofc_flg_1" value="R" class="trans" checked onclick="ofc_flg_click()"><!--
											--><label for="ofc_flg_1">RHQ</label><!--
											--><input type="radio" name="ofc_flg" id="ofc_flg_2" value="O" class="trans" onclick="ofc_flg_click()"><!--
											--><label for="ofc_flg_2">Office</label><!--  -->
											<script type="text/javascript">ComComboObject('office', 1 ,80 , 0 , 1 , 0, true);</script><!--  										
											--><button type="button" class="multiple_inq ir" name="" id=""></button><!--
											--><input type="checkbox" name="chk_sub_ofc" id="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans"><!--
											--><label for="chk_sub_ofc">Incl. Sub Office</label>
										</td>
										<td></td>
									</tr>
									<tr>
										<th class="sm">Currency&nbsp;&nbsp;</th>
										<td class="sm">
											<input type="radio" name="curr_flg" id="curr_flg_1" value="U" class="trans" checked><!-- 
											--><label for="curr_flg_1">USD</label><!--											
											--><input type="radio" name="curr_flg" id="curr_flg_2" value="L" class="trans"><!--
											--><label for="curr_flg_2">Local</label>	
										</td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</td>
						<td>
							<table>
								<colgroup>
						            <col width="90px" />
						            <col width="230px" />				           	            
						            <col width="" />
								</colgroup>
								<tbody>
									<tr>
										<th>Tariff Type&nbsp;&nbsp;</th>
										<td>
											<script type="text/javascript">ComComboObject('tariff_type', 1, 130, 1, 1, 0, false);</script><!--  										
											 --><button type="button" class="multiple_inq ir" name="" id=""></button>
										</td>
										<td></td>
									</tr>
									<tr>
										<th>Group by&nbsp;&nbsp;</th>
										<td>
											<select name="grp_flg" id="grp_flg" style="width:130px;">
												<option value="O" selected>Office</option>
												<option value="R">RHQ</option>
											</select>
										</td>
										<td></td>
									</tr>
									<tr>
										<th>CNTR Type&nbsp;&nbsp;</th>
										<td>
											<script type="text/javascript">ComComboObject('cntr_type', 1, 130, 1, 0, 0, false);</script>
										</td>
										<td></td>
									</tr>							
								</tbody>
							</table>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">			    
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

</form>