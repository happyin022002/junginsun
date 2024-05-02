<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0163.jsp
*@FileTitle  : Customized Conditions
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.event.EsmSaq0163Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0163Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BasicDataManage.MonthlyCustomizedCondition");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0163Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cond_sts_cd" id="cond_sts_cd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- Outer Table (S)-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="1px"/>
					<col width="120px"/>
					<col width="55px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Year</th>
					<td><select class="input1" name="bse_yr" id="bse_yr" style="width:60px;"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_qtr_cd" id="bse_qtr_cd" style="width:60px;"></select></td>
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
	<!-- opus_tab_btn(E) -->
	<!-- opus_design_grid(S) -->
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn mar_btm_4">
			<table style="width:100%" >
				<tbody>
					<colgroup>
						<col width="*"/>
						<col width="50px"/>
						<col width="70px"/>
						<col width="140px"/>
						<col width="50px"/>
						<col width="110px"/>
						<col width="125px"/>
			    	</colgroup>
					<tr>
						<td>
							<button type="button" class="btn_normal" name="btng_row_add"  id="btng_row_add">Row Add</button>
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_save"  id="btng_save">Save</button>
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_confirm"  id="btng_confirm">Confirm</button>
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_cancelconfirmation"  id="btng_cancelconfirmation">Cancel Confirmation</button>
						</td>
						<th>
							Status
						</th>
						<td>
							<input type="text" class="input1" style="width:100px; text-align:center;cursor:default;" unselectable="on" name="status_value" id="status_value" />
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_createinitialdata"  id="btng_createinitialdata">Create Initial Data</button>
						</td>
					</tr>
				</tbody>
			</table>
			 </div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
    <div id="tabLayer" style="display:inline">	
		<div class="opus_design_grid" >
			<div class="opus_design_btn mar_btm_4">
			<table>
				<tbody>
					<colgroup>
						<col width="*"/>
						<col width="50px"/>
						<col width="70px"/>
						<col width="140px"/>
						<col width="50px"/>
						<col width="110px"/>
						<col width="125px"/>
			    	</colgroup>
					<tr>
						<td>
							<button type="button" class="btn_normal" name="btng_rowadd"  id="btng_rowadd">Row Add</button>
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_saveB"  id="btng_saveB">Save</button>
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_confirm_"  id="btng_confirm_">Confirm</button>
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_cancelconfirmationB"  id="btng_cancelconfirmationB">Cancel Confirmation</button>
						</td>
						<th>
							Status
						</th>
						<td>
							<input type="text" class="input1" style="width:100px; text-align:center;cursor:default;" unselectable="on" name="status_value" id="status_value" />
						</td>
						<td>
							<button type="button" class="btn_normal" name="btng_createinitialdataB"  id="btng_createinitialdataB">Create Initial Data</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>