<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0001.jsp
*@FileTitle  : P/F SKD Settlement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<input type="hidden" name="port_cd" 		id="port_cd">
<input type="hidden" name="min_max_spd" 	id="min_max_spd">
<input type="hidden" name="port_name" 		id="port_name">
<input type="hidden" name="zd" 				id="zd">
<input type="hidden" name="port_info_cnt" 	id="port_info_cnt">
<input type="hidden" name="curr_pos" 		id="curr_pos">
<input type="hidden" name="first_port_cd" 	id="first_port_cd">
<input type="hidden" name="second_port_cd" 	id="second_port_cd">
<input type="hidden" name="third_port_cd" 	id="third_port_cd">
<input type="hidden" name="data_pos" 		id="data_pos">
<input type="hidden" name="yd_cd" 			id="yd_cd">
<input type="hidden" name="currPos" 		id="currPos">
<input type="hidden" name="new_sim_data" 	id="new_sim_data">
<input type="hidden" name="loc_cd"		    id="loc_cd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New"  			id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_MCalculation"	id="btn_MCalculation">M/Calculation</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_EOTP" 			id="btn_EOTP">EOTP</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Settlement" 		id="btn_Settlement">Settlement</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_BerthWindow" 	id="btn_BerthWindow">Berth Window</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
	<!-- opus_design_inquiry(S) -->
		<table>
			<tbody>
				<colgroup>
					<col width="90"/>
					<col width="180"/>
					<col width="110"/>
					<col width="83"/>
					<col width="83"/>
					<col width="*" />
			    </colgroup>
				<tr>
					<th>Simulation No.</th>
					<td><input type="text" name="sim_dt" 		id="sim_dt" style="width:70px;" class="input1" value="" maxlength="8" dataformat="int" tabIndex="1"><input type="text" name="sim_no" 		id="sim_no" style="width:35px;text-align:right" class="input1" value="" maxlength="3" dataformat="num" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();"><button type="button" class="input_seach_btn" name="btns_search03" id="btns_search03"></button></td>
					<th>Lane Code</th>
					<td><input type="text" name="vsl_slan_cd" 	id="vsl_slan_cd" style="width:50px;ime-mode:disabled;text-align:center" class="input" maxlength="3" dataformat="engup"  value="" tabIndex="3"><button type="button" class="input_seach_btn" name="btns_search"></button></td>
					<th>Standard IND</th>
					<td><select name="slan_stnd_flg" id="slan_stnd_flg" style="width:61px;" class="input" tabIndex="4">
							<option value="Y">Y</option>
							<option value="N" selected="selected">N</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="90"/>
					<col width="180"/>
					<col width="110"/>
					<col width="290"/>
					<col width="50"/>
					<col width="80" />
					<col width="50" />
			    </colgroup>
				<tr>
					<th>P/F SKD Type</th>
					<td><input type="text" name="pf_svc_tp_cd" id="pf_svc_tp_cd" style="width:40px;ime-mode:disabled;text-align:center" class="input" dataformat="engup" value="" maxlength="4" tabIndex="5"><button type="button" class="input_seach_btn" name="btns_search02"></button>
					</td>
					<th>Vessel Class</th>
					<td><input type="text" name="n1st_vsl_clss_cd" 	id="n1st_vsl_clss_cd" 	style="width:50px;text-align:center" 	class="input2" dataformat="num" value="" readonly="readonly"><!-- 
						 --><input type="text" name="n1st_vsl_clss_knt" id="n1st_vsl_clss_knt" 	style="width:20px;text-align:right" 	class="input2" value="" readonly="readonly"><!-- 
						 --><input type="text" name="n2nd_vsl_clss_cd" 	id="n2nd_vsl_clss_cd" 	style="width:50px;text-align:center" 	class="input2" dataformat="num" value="" readonly="readonly"><!-- 
						 --><input type="text" name="n2nd_vsl_clss_knt" id="n2nd_vsl_clss_knt" 	style="width:20px;text-align:right" 	class="input2" value="" readonly="readonly"><!-- 
						 --><input type="text" name="n3rd_vsl_clss_cd" 	id="n3rd_vsl_clss_cd" 	style="width:50px;text-align:center" 	class="input2" dataformat="num" value="" readonly="readonly"><!-- 
						 --><input type="text" name="n3rd_vsl_clss_knt" id="n3rd_vsl_clss_knt" 	style="width:20px;text-align:right" 	class="input2" value="" readonly="readonly">
					</td>				
					<th>Duration</th>
					<td><input type="text" name="svc_dur_dys" 		id="svc_dur_dys" 		style="width:40px;text-align:right" 	class="input2" value="" readonly="readonly"></td>
					<th>Frequency</th>
					<td><input type="text" name="brth_itval_dys" 	id="brth_itval_dys" 	style="width:37px;text-align:right"  	class="input2" maxlength="2" value="" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="90"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Remark(s)</th>
					<td><input type="text" name="pf_skd_rmk" id="pf_skd_rmk" style="width:98%;ime-mode:disabled" class="input" value=""  maxlength="4000"  tabIndex="6"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_RowAdd" 		id="btn_RowAdd">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_RowInsert" 	id="btn_RowInsert">Row Insert</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_RowDelete" 	id="btn_RowDelete">Row Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="110"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="110"/>
					<col width="80" />
					<col width="20" /><!-- space -->
					<col width="40"/>
					<col width="110"/>
					<col width="50"/>
					<col width="150"/>
					<col width="50"/>
					<col width="60" />
			    </colgroup>
			    <tr>
					<th>Maximum Speed</th>
					<td><input type="text" style="width:99%;text-align:right" class="noinput" name="max_spd" 		id="max_spd" value="" ReadOnly="readonly"></td> 
					<th>Sea Buffer Ratio</th>
					<td><input type="text" style="width:99%;text-align:right" class="noinput" name="sea_buf_rat" 	id="sea_buf_rat" value="" ReadOnly="readonly"></td>
					<th>P/F Speed Ratio</th>
					<td><input type="text" style="width:99%;text-align:right" class="noinput" name="pf_spd_rat" 	id="pf_spd_rat" value="" ReadOnly="readonly"></td>
					<td></td>
					<th>L/F</th>
					<td><input type="text" style="width:99%;text-align:right;" name="lf" 	id="lf" 	class="noinput" value="" readOnly="readonly"></td> 
					<th>G.REV</th>
					<td><input type="text" style="width:99%;text-align:right;" name="rev" 	id="rev" 	class="noinput" value="" readOnly="readonly"></td> 
					<th>EOTP1</th>
					<td><input type="text" style="width:99%;text-align:right;" name="eotp1" id="eotp1" 	class="noinput" value="" readOnly="readonly"></td>
				</tr>
				<tr>
					<th>Total Buffer Ratio</th>
					<td><input type="text" style="width:99%;text-align:right" class="noinput" name="tot_buf_rat" 	id="tot_buf_rat" value="" ReadOnly="readonly"></td>
					<th>Port Buffer Ratio</th>
					<td><input type="text" style="width:99%;text-align:right" class="noinput" name="port_buf_rat" 	id="port_buf_rat" value="" ReadOnly="readonly"></td>
					<th>Buffer Speed Ratio</th>
					<td><input type="text" style="width:99%;text-align:right" class="noinput" name="buf_spd_rat" 	id="buf_spd_rat" value="" ReadOnly="readonly"></td>
					<td></td>
					<th>RPB</th>
					<td><input type="text" style="width:99%;text-align:right;" name="rpb" 	id="rpb" class="noinput" value="" readOnly="readonly"></td>
					<th>OP</th>
					<td><input type="text" style="width:99%;text-align:right;" name="op" 	id="op" class="noinput" value="" readOnly="readonly"></td>
					<th>EOTP2</th>
					<td><input type="text" style="width:99%;text-align:right;" name="eotp2" id="eotp2" class="noinput" value="" readOnly="readonly"></td>
				</tr>
			</tbody>
		</table>
	</div>	
</div>
<!-- opus_design_grid(E) -->
</div>
</form>