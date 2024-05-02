<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_VSK_0058.jsp
*@FileTitle  : VSL SKD Update (CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0058Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0058Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd"           id="f_cmd" />
<input type="hidden" name="pagerows"        id="pagerows" />
<input type="hidden" name="loc_cd"          id="loc_cd" />
<input type="hidden" name="rtv_flg"         id="rtv_flg" />
<input type="hidden" name="bound" value="1" id="bound" />
<input type="hidden" name="vps_port_cd"     id="vps_port_cd" />
<input type="hidden" name="vps_etb_dt"      id="vps_etb_dt" />
<input type="hidden" name="vsl_svc_tp_cd"   id="vsl_svc_tp_cd" />
<input type="hidden" name="act_arr_dt"      id="act_arr_dt" >
<input type="hidden" name="pre_port_cd"     id="pre_port_cd" >
<input type="hidden" name="pre_etd_dt"      id="pre_etd_dt" >

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>									
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="85" />				
				<col width="160" />				
				<col width="75" />				
				<col width="90" />				
				<col width="90" />				
				<col width="90" />				
				<col width="91" />				
				<col width="*" />				
		   </colgroup>
		   <tbody>
		   		<tr>
					<th width="30px">VVD</th>   
					<td >
						<input type="text" name="vsl_cd" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="engup" value="" class="input1" value="" maxlength="4" onfocus="this.select();"><!-- 
				 	 --><input type="text" name="skd_voy_no" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="num" value="" class="input1" value="" maxlength="4" onfocus="this.select();"><!--
					 --><input type="text" name="skd_dir_cd" style="width:20px;text-align:center;ime-mode:disabled;" dataformat="enguponly" value="" class="input1" value="" maxlength="1" onfocus="this.select();"><!--
					  --><button type="button" class="input_seach_btn" name="btn_vvd"></button></td>
					<th width="70px">Lane Code</th>   
					<td ><input type="text" name="vsl_slan_cd" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="engup" class="input2" value="" maxlength="3" readonly="readonly"></td>
					
					<th width="70px">P/F SKD Type</th>
					<td width = "50px"><input type="text" name="pf_skd_tp_cd" style="width:50px;text-align:center;" class="input2" value="" readonly="readonly" id="pf_skd_tp_cd" /> </td>
					<th>Created Date</th>
					<td><input type="text" id="cre_dt"     name="cre_dt"     style="width:130px;" class="input2" value="" readonly="readonly" />
					    <input type="text" id="cre_usr_id" name="cre_usr_id" style="width:90px;"  class="input2" value="" readonly="readonly" />
					</td>
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<th>Updated Date</th>
					<td><input type="text" id="upd_dt"     name="upd_dt"     style="width:130px;" class="input2" value="" readonly="readonly"  />
					    <input type="text" id="upd_usr_id" name="upd_usr_id" style="width:90px;"  class="input2" value="" readonly="readonly"  /> 
					</td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="85" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Remark(s)</th>
					<td><textarea style="ime-mode:disabled;width:825px; height:50px;resize:none" name="skd_rmk" id="skd_rmk"></textarea></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable" >	
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_add_call" id="btn_add_call">Add Call</button><!--
		 --><button type="button" class="btn_normal" name="btn_add_call_cancel" id="btn_add_call_cancel">Add Call Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_skip_call" id="btn_skip_call">Skip Call</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_skip_call_cancel" id="btn_skip_call_cancel">Skip Call Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reverse_call" id="btn_reverse_call">Reverse Call</button>								
    </div>									
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
</div>
<!-- opus_design_grid(E) -->
</div>

</form>

