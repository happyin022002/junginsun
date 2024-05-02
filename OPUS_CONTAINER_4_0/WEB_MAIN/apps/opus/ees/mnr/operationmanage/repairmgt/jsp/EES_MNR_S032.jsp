<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S032.jsp
*@FileTitle  : Repair Result creatioln by W/O
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS032Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

EesMnrS032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		  strOfc_cd = account.getOfc_cd(); 
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();

		event = (EesMnrS032Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {   
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_gubuns" id="f_gubuns" />
<input type="hidden" name="mnr_grp_tp_cd" value="RPR" id="mnr_grp_tp_cd" />
<input type="hidden" name="mnr_wo_tp_cd" value="EST" id="mnr_wo_tp_cd" />

<input type="hidden" name="agmt_ofc_cty_cd" value="" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" value="" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" value="" id="agmt_ver_no" />

<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>	
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrive" id="btn_retrive" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_clear" id="btn_clear" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60" />				
				<col width="120" />				
				<col width="80" />				
				<col width="80" />				
				<col width="100" />	
				<col width="170" />			
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('combo_eq_knd_cd',2, 100 , 1, 1,0,false,0);</script><input type="hidden" name="eq_knd_cd" id="eq_knd_cd" /></td>
					<th>W/O Issue Date</th>
					<td colspan="2"><input type="text" style="width:80px;text-align:center" class="input1" name="fromcal" dataformat="ymd" required  id="fromcal" />~&nbsp;<!-- 
					 --><input type="text" style="width:80px;text-align:center" class="input1" name="tocal" id="tocal" dataformat="ymd" required ><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
					<th>Repair Completion Status</th>
					<td><script type="text/javascript">ComComboObject('combo_rpr_rslt_sts',2, 100 , 1, 0,0,false,0);</script><input type="hidden" name="rpr_rslt_sts" id="rpr_rslt_sts" /></td>

				</tr>
				<tr>     
					<th>EQ No.</th>
					<td><input name="eq_no" type="text" style="width:100px;text-align:center;" class="input" dataformat="engup" value="" id="eq_no" /> </td>
					<th>EST No.</th>
					<td><input name="rqst_ref_no" type="text" style="width:80px;text-align:center;" class="input" dataformat="engup" value="" id="rqst_ref_no" /> </td>
					<th>W/O No.</th>
					<td colspan="2"><input name="mnr_ord_seq" type="text" style="width:132px;" class="input" dataformat="engup" value="" id="mnr_ord_seq" /> </td>

				</tr>  
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="260" />				
				<col width="127" />					
				<col width="*" />				
		   </colgroup> 
			<tbody>
		   		<tr>
		   			<th>Service Provider</th>
					<td><input type="text" name="vndr_seq" caption="Service Provider" style="width:60px;text-align:left;" class="input2" dataformat="num" value="<%=strVndr_seq %>" readonly id="vndr_seq" /><input type="text" name="vndr_nm" caption="Service Provider" style="width:192px;" class="input2" value="<%=strVndr_nm%>" readonly id="vndr_nm" /> </td>
					<th>C.Office</th>
					<td><input name="cost_ofc_cd" type="text" style="width:70px;text-align:center;" class="input2" dataformat="engup" value="<%=strOfc_cd %>" readonly id="cost_ofc_cd" /> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_downExcel" id="btn_downExcel" type="button">Down Excel</button><!--
			--><button class="btn_normal" name="btn_loadExcel" id="btn_loadExcel" type="button">Load Excel</button><!--
			--><button class="btn_normal" name="btn_Detail" id="btn_Detail" type="button">Detail(s)</button><!--
			--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

<%@include file="/bizcommon/include/common_alps.jsp" %>