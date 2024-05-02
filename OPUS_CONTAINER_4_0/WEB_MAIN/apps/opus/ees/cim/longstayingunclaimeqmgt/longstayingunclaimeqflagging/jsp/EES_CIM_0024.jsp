<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0024.js
*@FileTitle  : L/S Flag Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//MVMT Status multi combo
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

    function setupPage(){  

	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>



<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<input type="hidden" name="tot_cntr_tpsz_cd" value="" id="tot_cntr_tpsz_cd" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down&nbsp;Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="120" />
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td><select style="width:80px;" name="loc_type_code" id="loc_type_code" class="input" ><!-- LOC_TYPE_CODE --><option value="1" selected>LCC</option><option value="2">RCC</option><option value="3">ECC</option><option value="4">SCC</option><option value="5">Yard</option><!-- loc_cd --></select><!-- 
					 --><input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="7" maxlength="7" required="loc_cd" value="" id="loc_cd" /><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
					<th>F/M</th>
					<td><select name="full_flg" style="width:70px;" class="input"><option value="" selected></option><option value="Y">Full</option><option value="N">MTY</option></select></td>
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('combo_cntr_tpsz_cd', 1, 70, 1);</script></td>
					<td></td>
				</tr> 
				<tr>
					<td><b style="padding-right:15px">Staying Day</b><input type="text" name="over_stay_days" style="width:40px; text-align:right;" dataformat="num" maxlength="5" class="input1" required="over_stay_days" value="" id="over_stay_days" /> or over</td>
					<th>MVMT Status</th>
					<td><script type="text/javascript">ComComboObject('combo_cnmv_sts_cd', 1, 70, 1);</script></td>
					<th>Lease Term</th>
					<td><script type="text/javascript">ComComboObject('combo_lstm_cd', 1, 70, 1);</script></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
