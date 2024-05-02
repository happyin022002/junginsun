<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0012.jsp
*@FileTitle  : Receipt Outstanding Search Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar0012Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	StmSar0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding");

	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");
	String sysStartDate = JSPUtil.getKST("yyyy-MM") + "-01";

	String rct_ofc_cd = StringUtil.xssFilter(request.getParameter("rct_ofc_cd"));
	if(rct_ofc_cd == null){
		rct_ofc_cd = "";
	}
	
	String local_chg_flag = (StringUtil.xssFilter(request.getParameter("local_chg_flag")) == null)? "" : StringUtil.xssFilter(request.getParameter("local_chg_flag"));
	String bound_type = (StringUtil.xssFilter(request.getParameter("bound_type")) == null)? "" : StringUtil.xssFilter(request.getParameter("bound_type"));
	String invoice_type = (StringUtil.xssFilter(request.getParameter("invoice_type")) == null)? "" : StringUtil.xssFilter(request.getParameter("invoice_type"));
	String rct_curr_cd = (StringUtil.xssFilter(request.getParameter("rct_curr_cd")) == null)? "" : StringUtil.xssFilter(request.getParameter("rct_curr_cd"));
	String ots_rct_tmp_seq = (StringUtil.xssFilter(request.getParameter("ots_rct_tmp_seq")) == null)? "" : StringUtil.xssFilter(request.getParameter("ots_rct_tmp_seq"));
	String rct_tp_cd = (StringUtil.xssFilter(request.getParameter("rct_tp_cd")) == null)? "" : StringUtil.xssFilter(request.getParameter("rct_tp_cd"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSar0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
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
<link href="css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="css/opus_menu.css" rel="stylesheet" type="text/css">

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rct_ofc_cd" value="<%=rct_ofc_cd%>" id="rct_ofc_cd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="rhq_cd" id="rhq_cd" />
<input type="hidden" name="ots_smry_cd" id="ots_smry_cd" />
<input type="hidden" name="ots_cd" id="ots_cd" />
<input type="hidden" name="rep_ots_ofc_cd" id="rep_ots_ofc_cd" />
<input type="hidden" name="local_chg_flag" value="<%=local_chg_flag%>" id="local_chg_flag" />
<input type="hidden" name="bound_type" value="<%=bound_type%>" id="bound_type" />
<input type="hidden" name="invoice_type" value="<%=invoice_type%>" id="invoice_type" />
<input type="hidden" name="rct_curr_cd" value="<%=rct_curr_cd%>" id="rct_curr_cd" />
<input type="hidden" name="ots_rct_tmp_seq" value="<%=ots_rct_tmp_seq%>" id="ots_rct_tmp_seq" />
<input type="hidden" name="rct_tp_cd" value="<%=rct_tp_cd%>" id="rct_tp_cd" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Receipt Outstanding Search</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_OK"  	id="btn_OK">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="81">
					<col width="100">
					<col width="90">
					<col width="110">
					<col width="80">
					<col width="60">
					<col width="70">
					<col width="90">
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Customer</th>
                      	<td colspan="7"><input type="text" style="width:30px;" class="input" name="bil_to_cust_cnt_cd" maxlength="2" dataformat="enguponly" id="bil_to_cust_cnt_cd" /><!--  
                      		--><input type="text" style="width:62px;" class="input" name="bil_to_cust_seq" maxlength="6" dataformat="num" id="bil_to_cust_seq" /><!-- 
                			--><button type="button" id="btns_cust" name="btns_cust" class="input_seach_btn"></button><!--  
                			--><input type="text" style="width:239px;" class="input2" name="cust_nm" id="cust_nm" readonly tabindex="-1">
                			<strong><label id="ofst_label" name="ofst_label" for="ofst_chk">Offset</label></strong><input type="checkbox" name="ofst_chk" class="trans" id="ofst_chk" /> </td>
                      	<th> Office</th>
                      	<td><script type="text/javascript">ComComboObject('ots_ofc_cd', 1, 80, 1, 1);</script></td>
					</tr>
					<tr>
						<th>V.V.D</th>
                      	<td colspan="9"><input type="text" style="width:80px;" class="input" name="vvd_cd1" maxlength="9" dataformat="engup" id="vvd_cd1" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd2" maxlength="9" dataformat="engup" id="vvd_cd2" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd3" maxlength="9" dataformat="engup" id="vvd_cd3" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd4" maxlength="9" dataformat="engup" id="vvd_cd4" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd5" maxlength="9" dataformat="engup" id="vvd_cd5" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd6" maxlength="9" dataformat="engup" id="vvd_cd6" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd7" maxlength="9" dataformat="engup" id="vvd_cd7" /></td>
					</tr>
					<tr>
						<th></th>
                      	<td colspan="9"><input type="text" style="width:80px;" class="input" name="vvd_cd8" maxlength="9" dataformat="engup" id="vvd_cd8" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd9" maxlength="9" dataformat="engup" id="vvd_cd9" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd10" maxlength="9" dataformat="engup" id="vvd_cd10" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd11" maxlength="9" dataformat="engup" id="vvd_cd11" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd12" maxlength="9" dataformat="engup" id="vvd_cd12" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd13" maxlength="9" dataformat="engup" id="vvd_cd13" /><!-- 
                         --><input type="text" style="width:80px;" class="input" name="vvd_cd14" maxlength="9" dataformat="engup" id="vvd_cd14" /></td>
					</tr>
					<tr>
						<th>Bound</th>
                      	<td><script type="text/javascript">ComComboObject('bkg_io_bnd_cd', 2, 80, 1, 0,1);</script></td>
                      	<th>As of Date</th>
                      	<td><input type="text" style="width:80px;" class="input" name="as_of_date" dataformat="ymd" maxlength="8" id="as_of_date" /><!-- 
                         --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
                      	<th>Over Due</th>
                      	<td><input type="text" style="width:50px;" class="input" name="over_due_fm" dataformat="num" maxlength="4" otherchar="-" id="over_due_fm" /><span class="dash">~</span><!-- 
                         --><input type="text" style="width:50px;" class="input" name="over_due_to" dataformat="num" maxlength="4" otherchar="-" id="over_due_to" /></td>
                      	<th>Charge</th>
                      	<td><script type="text/javascript">ComComboObject('chg_tp_cd', 1, 70, 1, 0);</script></td>
                      	<!-- <th>OTS Source</th>
                      	<td><script type="text/javascript">ComComboObject('ots_src_cd', 1, 80, 1, 0);</script></td> -->
					</tr>
					<tr>
						<th>I/F Date</th>
                      	<td colspan="3"><input type="text" style="width:80px;" class="input" name="if_from_dt" dataformat="ymd" maxlength="8" cofield="if_to_dt" caption="start date" id="if_from_dt" /><!-- 
                         --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>~&nbsp;<!-- 
                         --><input type="text" style="width:80px;" class="input" name="if_to_dt" dataformat="ymd" maxlength="8" cofield="if_from_dt" caption="end date" id="if_to_dt" /><!-- 
                         --><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button></td>
                      	<th>Transaction</th>
                      	<td><script type="text/javascript">ComComboObject('tj_src_nm', 1, 80, 1, 0);</script></td>                      	
                      	<th>Source</th>
                      	<td><script type="text/javascript">ComComboObject('ots_src_cd', 1, 80, 1, 0);</script></td>
                      	
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="110">
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th  id="bl_label" name="bl_label" >B/L No</th>
                      	<th  id="inv_label" name="inv_label" >Invoice No</th>
                      	<td><input type="text" style="width:109px;" class="input" name="bl_no1" maxlength="15" dataformat="engup" id="bl_no1" /><!-- 
                         --><input type="text" style="width:109px;" class="input" name="bl_no2" maxlength="15" dataformat="engup" id="bl_no2" /><!-- 
                         --><input type="text" style="width:109px;" class="input" name="bl_no3" maxlength="15" dataformat="engup" id="bl_no3" /><!-- 
                         --><input type="text" style="width:109px;" class="input" name="bl_no4" maxlength="15" dataformat="engup" id="bl_no4" /><!-- 
                         --><input type="text" style="width:109px;" class="input" name="bl_no5" maxlength="15" dataformat="engup" id="bl_no5" /><!-- 
                         --><input type="text" style="width:109px;" class="input" name="bl_no6" maxlength="15" dataformat="engup" id="bl_no6" /><!-- 
                         --><input type="text" style="width:109px;" class="input" name="bl_no7" maxlength="15" dataformat="engup" id="bl_no7" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>	
</div>
</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>