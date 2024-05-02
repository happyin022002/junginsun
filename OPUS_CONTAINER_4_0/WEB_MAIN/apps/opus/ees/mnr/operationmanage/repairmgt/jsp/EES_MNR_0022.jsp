<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_MNR_0022.jsp
*@FileTitle  : Estimate Group Auditing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();

		event = (EesMnr0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!--Use a common at MNR  -->
<script type="text/javascript">
    var selfOfcCd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Variable for written estimates and inspection divide -->
<input type="hidden" name="rqst_type" id="rqst_type" value="rqst_aud">
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" value="ALL">
<input type="hidden" name="apro_ofc_cd" id="apro_ofc_cd" value="<%=strOfc_cd%>">
<!-- Developer's task	-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn_Reject" id="btn_Reject">Reject</button><!--
	--><button type="button" class="btn_normal" name="btn_Approval" id="btn_Approval">Approval</button>
	</div>
<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(S) -->
</div>
<!-- page_location(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="40"/>
					<col width="150"/>
					<col width="80"/>
					<col width="200"/>
					<col width="60"/>
					<col width="140"/>
					<col width="70"/>
					<col width="*" />
				</colgroup>
					<tr>
						<th>EQ Type</th>
						<td><script  type="text/javascript">ComComboObject('combo1', 1, 130, 1, 1,0,false,0);</script></td>
						<th>Request Period</th>
						<td><!--
						--><input required type="text" name="fm_rqst_dt" id="fm_rqst_dt" dataformat="ymd"  caption="from date"  maxlength="10"  size="10"  cofield="to_rqst_dt" value=""><!--
						-->~ <input required type="text" name="to_rqst_dt" id="to_rqst_dt" dataformat="ymd"    caption="to date"   maxlength="10"  size="10"  cofield="fm_rqst_dt"><!--
						--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
						</td>
						<th>EQ No.</th>
						<td><!--
						--><input name="rqst_eq_no" id="rqst_eq_no" type="text" style="width:98px" class="input" dataformat="engup" value=""><!--
						--><button type="button" class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi"></button>
						</td>
						<th>Cost Code</th> 
						<td>
						<script  type="text/javascript">ComComboObject('cost_cd',3, 200, 1, 0,2);</script>
						</td>
					</tr>
				</tbody>		
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail(s)</button><!--
		--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>