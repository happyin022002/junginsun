<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0032.jsp
*@FileTitle  : Repair Result creatioln by W/O
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0032Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		
		event = (EesMnr0032Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    	   
	}catch(Exception e) {   
		out.println(e.toString());
	}
%>

<title>M&R Extra Expense W/O Creation</title>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<!-- <body  onLoad="setupPage();">  -->
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="f_gubuns" id="f_gubuns">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" id="mnr_wo_tp_cd" value="EST">

<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" id ="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" value="">
<input type="hidden" name="cost_ofc_cd" id="cost_ofc_cd" value="">

<!-- RD  --> 
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value="">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" value="">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_clear" id="btn_clear">New</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
<!-- 		<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button> -->
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<div class= "wrap_search">	
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="55px"/>
				<col width="100px"/>
				<col width="110px"/>
				<col width="150px"/>
				<col width="170px"/>
				<col width="*" />
			</colgroup>
				<tr class="h23">					
				  <th>EQ Type</th> 
					<td><script type="text/javascript">ComComboObject('eq_knd_cd',2, 100 , 1, 1,0,false,1);</script></td>  							 
					<th>W/O Issue Date</th>
					<td>	  					
						<input required type="text" name="fromcal" id="fromcal" dataformat="ymd"    caption="from date"        maxlength="10"  size="10"  cofield="tocal" value="" class="input1">   
	                              	~ <input required type="text" name="tocal" id="tocal" dataformat="ymd"    caption="to date"     maxlength="10"  size="10"  cofield="fromcal" class="input1">
	                              	<button type="button" name="btn_calendar" id="btn_calendar" class="calendar ir"></button>
					</td>
					<th>Repair Completion Status</th><!-- comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab-->

					<td><script type="text/javascript">ComComboObject('rpr_rslt_sts',2, 100 , 1, 0,0,false,1);</script></td>
				</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>

				<col width="55px"/>
				<col width="100px"/>
				<col width="110px"/>
				<col width="237px"/>
				<col width="170px"/>
				<col width="15px"/>
				<col width="*" />
			</colgroup>
				<tr>
					<th>EQ No.</th>
					<td><input type="text" style="width:100px" name="eq_no" id="eq_no" value=""  maxlength="14"  dataformat="engup"></td>
					<th>W/O No.</th>
					<td><input type="text" style="width:102px;"  value="" name="mnr_ord_seq" id="mnr_ord_seq"  maxlength="15" dataformat="engup"><!-- 
					--><button type="button" class="input_seach_btn" name="btn_WONo" id="btn_WONo"></button>
					</td>
					<th>Estimate No.</th>
					<td><input type="text" style="width:100px" name="rqst_ref_no" id="rqst_ref_no" value="" maxlength="20"  dataformat="engup" otherchar="-"></td>
					<th>Service Provider</th>
					<td><input  tabindex="3" type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:55px;text-align:left;" value="" dataformat="num" maxlength="6"><!-- 
					--><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr" ></button><!-- 
					--><input type="text" name="vndr_nm" id="vndr_nm" caption="Service Provider" style="width:180px;" class="input2" value="" readonly>
					</td>
				</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
			<button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail(s)</button>
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
			
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>