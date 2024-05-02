<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0029.jsp
*@FileTitle : Delay&Skip Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String header = "";
	Logger log = Logger.getLogger("com.clt.apps.ActualScheduleManagement.OnTimeResultAnalysis");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//HEADER info
		header = eventResponse.getETCData("header");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="headerVal" value="<%=header%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="grp_flg_cd">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" id="btn_Retrieve" name="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" id="btn_VVDRMKs" name="btn_VVDRMKs">VVD & Remark(s)</button><!--
	    --><button type="button" class="btn_normal" id="btn_DelayRSN" name="btn_DelayRSN">Delay Reason</button><!--
	    --><button type="button" class="btn_normal" id="btn_GroupRegister" name="btn_GroupRegister">Group Registration</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table> 
			<tr class="h23">
				<th width="75px" class="align_left">Period</th>
				<td width="230px">
					<input type="text" name="act_inp_fm_dt" caption="start month" maxlength="6" size="10" cofield="act_inp_fm_dt" style="width:60px;text-align:center;"  value="" readonly="readonly"><button type="button" class="calendar" name="btns_calendar_s" ></button>&nbsp;~&nbsp;
					<input type="text" name="act_inp_to_dt" caption="end month" maxlength="6" size="10" cofield="act_inp_to_dt" style="width:60px;text-align:center;"  value="" readonly="readonly"><button type="button" class="calendar" name="btns_calendar_e" ></button>
				</td>
				<td width="210px">
					<table class="search_sm2" border="0" style="width:180px;"> 
					<tr class="h23">
						<th><input type="radio" name="lane_grp" class="trans" value="I" checked="checked">Individual &nbsp;&nbsp;&nbsp;<input type="radio" name="lane_grp" class="trans" value="G">Group</th>
					</tr>	
					</table>
				</td>
				<th width="80px" class="align_left">Lane Code</th>
				<td width="*"><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input" maxlength="3" dataformat="engup" value=""><button type="button" class="input_seach_btn" name="btns_search"></button><!-- 
					--><script language="javascript">ComComboObject('lane_grp_nm',1,70,1,1);</script>
					</td>
			</tr>	
		</table>
		<table> 
			<tr class="h23">
				<th width="75px" class="align_left">Vessel Code</th>
				<td width="230px"><input type="text" style="width:60px;ime-mode:disabled;text-align:center" name="vsl_cd" class="input" maxlength="4" dataformat="engup" value=""><button type="button" class="input_seach_btn" name="btns_search2"></button></td>
				<th width="35px" class="align_left">Port</th>
				<td width="170px"><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="vps_port_cd" class="input" maxlength="5" dataformat="engup" value=""><button type="button" class="input_seach_btn" name="btns_search3"></button></td>		
			
				<th width="80px" class="align_left">Carrier Code</th>
				<td width="*"><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="crr_cd" class="input" maxlength="3" dataformat="engup" value=""><button type="button" class="input_seach_btn" name="btns_search4"></button></td>
			</tr>	
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<script language="javascript">ComTabObject('tab1');</script>
	</div>
	<!--TAB Delay Status (S) -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="260px">
					<table class="search_sm2" border="0" style="width:220px;"> 
						<tr class="h23">
							<th width="*" class="align_left"><input type="radio" name="ie_flg" class="trans" value="I" checked="checked">Inclusive&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="ie_flg" value="" class="trans" value="E">Exclusive</th> 
						</tr>
					</table>
				</td>
				<th width="50px" class="align_left">Group</th>
				<td width="*">
					<select style="width:100px;" class="input1" name="grp_flg" onChange="delayChange();">
						<option value="P" selected="selected">Port</option>
						<option value="V">VSL</option>
						<option value="L">Lane</option>
					</select>
				</td>
			</tr>	
			</table>
		</div>
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t1downexcel" id="btn_t1downexcel">Down Excel</button>
			</div>
			<script language="javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<!--TAB Delay Status (E) -->
	<!--TAB Skip Status (S) -->
	<div id="tabLayer" style="display:none">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="340px">
						<table class="search_sm2" border="0" style="width:300px;"> 
							<tr class="h23">
								<th width="40px" class="align_left">SKIP</th>
								<td width="" class="stm"><input type="radio" name="port_skp_tp_cd" value="A" class="trans" checked="checked">All&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="port_skp_tp_cd" value="I" class="trans">Intended&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="port_skp_tp_cd" value="F" class="trans">Force Majeure</td> 
							</tr>
						</table>
					</td>
					<th width="50px" class="align_left">Group</th>
					<td width="*"><select style="width:100;" class="input1" name="grp_flg" onChange="skipChange();">
						<option value="P" selected="selected">Port(Skip)</option>
						<option value="V">VSL</option>
						<option value="L">Lane</option>
						<option value="R">Port(Reason)</option>
						</select></td>
				</tr>	
			</table>
		</div>
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t2downexcel" id="btn_t2downexcel">Down Excel</button>
			</div>
			<script language="javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
	<!--TAB Skip Status (E) -->
	<!--TAB Skip Change Status (S) -->
	<div id="tabLayer" style="display:none">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">					
					<th width="50px" class="align_left">Group</th>
					<td width=""><select style="width:100px;" class="input1" name="grp_flg" onChange="skipChangeStatus();">
						<option value="P" selected="selected">Port</option>
						<option value="V">VSL</option>
						<option value="L">Lane</option>
						</select>
					</td>
				</tr>	
			</table>
		</div>
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t3downexcel" id="btn_t3downexcel">Down Excel</button>
			</div>
			<script language="javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>
</div>

</form>
