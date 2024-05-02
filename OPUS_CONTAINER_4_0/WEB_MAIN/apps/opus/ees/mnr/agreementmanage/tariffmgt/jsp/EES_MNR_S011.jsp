<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S011.jsp
*@FileTitle  : SPP MNR Local Tariff Creation and Verify
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnrS011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strOfc_cd 	= account.getOfc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();


		event = (EesMnrS011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var strVndrSeq	= "<%=strVndr_seq%>";
    var strVndrNm	= "<%=strVndr_nm%>";
	var currOfcCd 	= "<%=strOfc_cd.trim() %>";
	var usrId     	= "<%=strUsr_id.trim()%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display: none;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(S) -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="mnr_meas_ut_cd" id="mnr_meas_ut_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="eq_knd_nm" id="eq_knd_nm" />
<input type="hidden" name="mnr_trf_knd_cd" id="mnr_trf_knd_cd" />
<input type="hidden" name="mnr_trf_sts_cd" id="mnr_trf_sts_cd" />
<input type="hidden" name="pre_trf_no" id="pre_trf_no" />
<input type="hidden" name="hdn_user_id" value="<%=strUsr_id%>" id="hdn_user_id" />
<input type="hidden" name="std_trf_no" id="std_trf_no" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button><!--
		 --><button type="button" class="btn_normal" name="btn_Request" 	id="btn_Request">Request</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Copy" 	id="btn_Copy">Copy</button>
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

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="200">
				<col width="90">
				<col width="280">
				<col width="40">
				<col width="130">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Tariff No.</th>
					<td><input type="text" name="search_trf_no" style="width:130px;text-align:center" class="input1" required dataformat="engup" otherchar="()-" maxlength="20" id="search_trf_no" /><!-- 
					 --><button type="button" id="trf_no_popup" name="trf_no_popup" class="input_seach_btn"></button><!-- 
					 --><input type="hidden" name="trf_no" class="input2" readonly id="trf_no" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>Eff. from</th>
					<td><input type="text" name="eff_dt" style="width:80px;text-align:center" class="input1" dataformat="ymd" maxlength="10" size="10" id="eff_dt" /><!-- 
					 --><button type="button" id="eff_dt_cal" name="eff_dt_cal" class="calendar ir"></button></td>
					<th>S/Provider Code</th>
					<td><input type="text" name="vndr_seq" style="width:50px;text-align:center" class="input2" dataformat="num" readonly="readonly" id="vndr_seq" /><!-- 
					 --><input type="text" name="vndr_nm" style="width:178px;" class="input2" readonly="readonly" id="vndr_nm" /></td>
					<th>Currency</th>
					<td><script type="text/javascript">ComComboObject('combo4', 1, 80, 1, 0);</script></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('combo1', 1, 140, 1, 0);</script></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="55">
				<col width="200">
				<col width="90">
				<col width="100">
				<col width="40">
				<col width="110">
				<col width="40">
				<col width="110">
				<col width="40">
				<col width="*">
			</colgroup>
			</tbody>
				<tr>
					<th>EQ Type </th>
					<td><script type="text/javascript">ComComboObject('combo2', 1, 103, 1, 0);</script></td>
					<th>Unit Of Measure</th>
					<td><script type="text/javascript">ComComboObject('combo3', 1, 52, 1, 0);</script></td>
					<th>Tariff Office</th>
					<td><input type="text" name="rqst_ofc_cd" style="width:60px;text-align:center" class="input2" value="<%=strOfc_cd%>" readonly="readonly" id="rqst_ofc_cd" /></td>
					<th>Cre. Date</th>
					<td><input type="text" name="cre_dt" style="width:80px;text-align:center" class="input2" readonly="readonly" id="cre_dt" /></td>
					<th>Cre. User</th>
					<td><input type="text" name="cre_usr_id" style="width:140px;text-align:center" class="input2" value="<%=strUsr_id%>" readonly="readonly" id="cre_usr_id" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t1LoadExcel" id="btn_t1LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1DownExcel" 	id="btn_t1DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t2LoadExcel" id="btn_t2LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t2DownExcel" 	id="btn_t2DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t3LoadExcel" id="btn_t3LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t3DownExcel" 	id="btn_t3DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t4LoadExcel" id="btn_t4LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t4DownExcel" 	id="btn_t4DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t1LoadExcel" id="btn_t1LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1DownExcel" 	id="btn_t1DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t1LoadExcel" id="btn_t1LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t1DownExcel" 	id="btn_t1DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t6sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t2LoadExcel" id="btn_t2LoadExcel">Load Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t2DownExcel" 	id="btn_t2DownExcel">Down Excel</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_data wAuto">
		<table class="gird_2">
			<colgroup>
				<col width="100">
				<col width="*">
			</colgroup>
			<tr>
				<th>Remark(s)</th>  
				<td><textarea name="mnr_trf_rmk" id="mnr_trf_rmk" wrap="off" style="width:100%;height:60px;resize:none;" maxLength="4000"></textarea></td>  
			</tr>
		</table>
	</div>
</div>
</form>