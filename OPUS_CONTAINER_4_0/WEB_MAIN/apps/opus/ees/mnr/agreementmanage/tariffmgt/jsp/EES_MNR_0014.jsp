<%/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_MNR_0014.jsp
 *@FileTitle  : MNR Standard Tariff Creation and Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/20
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EesMnr0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var currOfcCd = "<%=strOfc_cd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	
	function loading_st(){ 
		ComOpenWait(true);
	} 
	function loading_ed(){
		ComOpenWait(false);
	} 
	loading_st(); 
	window.onload = setupPage; 	

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="mnr_meas_ut_cd" 	id="mnr_meas_ut_cd">						<!-- Unit Of Mass -->
<input type="hidden" name="curr_cd" 		id="curr_cd">							<!-- Currency -->
<input type="hidden" name="eq_knd_cd" 		id="eq_knd_cd">							<!-- EQUIPMENT 종류 구분 -->
<input type="hidden" name="eq_knd_nm" 		id="eq_knd_nm">							<!-- EQUIPMENT 종류 구분명 -->
<input type="hidden" name="mnr_trf_knd_cd" 	id="mnr_trf_knd_cd">						<!-- Tariff 종류 표시 -->
<input type="hidden" name="vndr_seq" 		id="vndr_seq">							<!-- Vendor Sequence -->
<input type="hidden" name="mnr_trf_sts_cd" 	id="mnr_trf_sts_cd">						<!-- Tariff Status Code -->
<input type="hidden" name="pre_trf_no" 		id="pre_trf_no">							<!-- trf_no 생성용인자 -->
<input type="hidden" name="hdn_user_id" 	id="hdn_user_id" value="<%=strUsr_id%>">	<!-- Hidden UserId -->
<input type="hidden" name="pagerows" 		id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New"  			id="btn_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!--
	--><button type="button" class="btn_normal" name="btn_Delete"			id="btn_Delete">Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_Confirm" 		id="btn_Confirm">Confirm</button><!--
	--><button type="button" class="btn_normal" name="btn_Copy" 			id="btn_Copy">Copy</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="70"/>
				<col width="180"/>
				<col width="80"/>
				<col width="120"/>
				<col width="90"/>
				<col width="100"/>
				<col width="100"/>
				<col width="110" />
				<col width="40" />
				<col width="*" />
		    </colgroup>
			<tr>
				<th>Tariff No.</th>
				<td><!--
				--><input type="text" name="search_trf_no" 	id="search_trf_no" 		style="width:135px;text-align:center" class="input1" required dataformat="engup" otherchar="()-" maxlength="20"><!--
				--><button type="button" class="input_seach_btn" name="trf_no_popup" id="trf_no_popup"></button><!--
				--><input type="hidden" name="trf_no" id="trf_no" class="input2" readOnly="true">
				</td>
				<th>Tariff Office</th>
				<td><!--
				--><input type="text" name="rqst_ofc_cd" 		id="rqst_ofc_cd" 		style="width:75px;" class="input2" readonly="readonly">
				</td>
				<th>Creation User</th>
				<td><!--
				--><input type="text" name="cre_usr_id" 		id="cre_usr_id" 		style="width:80px;text-align:center" class="input2" readonly="readonly">
				</td>
				<th>Creation  Date</th>
				<td><!--
				--><input type="text" name="cre_dt" 			id="cre_dt" 			style="width:80px;text-align:center" class="input2" readonly="readonly">
				</td>
				<th>Status</th>
				<td><!--
				--><script type="text/javascript">ComComboObject('combo1', 1, 145, 1, 0);</script>
				</td>				
			</tr>
			<tr>
				<th>EQ Type </th>
				<td><!--
				--><script type="text/javascript">ComComboObject('combo2', 1, 135, 1, 0);</script>
				</td>
				<th>Eff. from </th>
				<td><!--
				--><input type="text" name="eff_dt" style="width:75px;text-align:center" class="input1" dataformat="ymd" maxlength="10"><!--
				--><button type="button" class="calendar ir" name="eff_dt_cal" id="eff_dt_cal"></button>
				</td>
				<th>Currency</th>
				<td><!--
				--><script type="text/javascript">ComComboObject('combo3', 1, 80, 1, 0);</script>
				</td>
				<th>Unit Of Measure</th>
				<td colspan="2"><!--
				--><script type="text/javascript">ComComboObject('combo4', 1, 68, 1, 0);</script>
				</td>
			</tr> 
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:inline;">
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_t1RowAdd" 		id="btn_t1RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_t1Delete"  		id="btn_t1Delete">Row Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_t1RowCopy" 		id="btn_t1RowCopy">Row Copy</button><!--
	--><button type="button" class="btn_normal" name="btn_t1LoadExcel" 	id="btn_t1LoadExcel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_t1DownExcel" 	id="btn_t1DownExcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_t2RowAdd" 		id="btn_t2RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_t2Delete"  		id="btn_t2Delete">Row Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_t2RowCopy" 		id="btn_t2RowCopy">Row Copy</button><!--
	--><button type="button" class="btn_normal" name="btn_t2LoadExcel" 	id="btn_t2LoadExcel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_t2DownExcel" 	id="btn_t2DownExcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_t3RowAdd" 		id="btn_t3RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_t3Delete"  		id="btn_t3Delete">Row Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_t3RowCopy" 		id="btn_t3RowCopy">Row Copy</button><!--
	--><button type="button" class="btn_normal" name="btn_t3LoadExcel" 	id="btn_t3LoadExcel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_t3DownExcel" 	id="btn_t3DownExcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_t4RowAdd" 		id="btn_t4RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_t4Delete"  		id="btn_t4Delete">Row Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_t4RowCopy" 		id="btn_t4RowCopy">Row Copy</button><!--
	--><button type="button" class="btn_normal" name="btn_t4LoadExcel" 	id="btn_t4LoadExcel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_t4DownExcel" 	id="btn_t4DownExcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t4sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_t5RowAdd" 		id="btn_t5RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_t5Delete"  		id="btn_t5Delete">Row Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_t5RowCopy" 		id="btn_t5RowCopy">Row Copy</button><!--
	--><button type="button" class="btn_normal" name="btn_t5LoadExcel" 	id="btn_t5LoadExcel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_t5DownExcel" 	id="btn_t5DownExcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t5sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_t6RowAdd" 		id="btn_t6RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_t6Delete"  		id="btn_t6Delete">Row Delete</button><!--
	--><button type="button" class="btn_normal" name="btn_t6RowCopy" 		id="btn_t6RowCopy">Row Copy</button><!--
	--><button type="button" class="btn_normal" name="btn_t6LoadExcel" 	id="btn_t6LoadExcel">Load Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_t6DownExcel" 	id="btn_t6DownExcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('t6sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_inquiry(S) -->
<div class="opus_design_grid">
	<div class="opus_design_data">
		<table style="width:100%; border:1px" class="grid_2">
			<tbody>
				<colgroup>
					<col width="110"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th class="tr2_head" style="border:1px solid #B8D6F6; font-weight: bold; text-align: center;">Remark(s)</th>  
					<td style="border:1px solid #B8D6F6;padding:3px 3px 3px 3px;"><!--
						--><textarea name="mnr_trf_rmk" id="mnr_trf_rmk" wrap="off" style="width:99%;height:60px;resize:none;"></textarea>
					</td>  
				</tr> 
			</tbody>
		</table>
	</div>
</div>
</div>
<!-- opus_design_inquiry(E) -->
</form>