<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0017.jsp
*@FileTitle  : SDMS - Windows
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmFms0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String fletCtrtNo 	= StringUtil.xssFilter(request.getParameter("flet_ctrt_no"));
	String vslCd 		= StringUtil.xssFilter(request.getParameter("vsl_cd"));
	String vslEngNm 	= StringUtil.xssFilter(request.getParameter("vsl_eng_nm"));
	String ownrNm 		= StringUtil.xssFilter(request.getParameter("ownr_nm"));
	String custCntcd 	= StringUtil.xssFilter(request.getParameter("cust_cnt_cd"));
	String custSeq 		= StringUtil.xssFilter(request.getParameter("cust_seq"));
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="slp_ofc_cd" value="<%=strOfc_cd%>" id="slp_ofc_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="inv_no" id="inv_no" />
<input type="hidden" name="direction" id="direction" />
<input type="hidden" name="rev_yrmon" id="rev_yrmon" />
<input type="hidden" name="ownr_nm" value="<%=ownrNm%>" id="ownr_nm" />
<input type="hidden" name="cust_cnt_cd" value="<%=custCntcd%>" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" value="<%=custSeq%>" id="cust_seq" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Stevedore Damage Management System</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
			 <button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
				 --><button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
	    </div>
		 <!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				 <table> 
		           <colgroup>
		                <col width="80"> 
		                <col width="100">
		                <col width="110">
		                <col width="60"> 
		                <col width="100">
		                <col width="*">
		            </colgroup>
		            <tbody>
		               	<tr>
							<th>Contract No.</th>
							<td><input type="text" style="width:120px;text-align:center;" class="input2" name="flet_ctrt_no" id="flet_ctrt_no" value="<%=fletCtrtNo%>" readonly></td>
							<th>Vessel Code</th>
							<td>
								<input type="text" style="width:54px;text-align:center;" class="input2" name="vsl_cd" id="vsl_cd" value="<%=vslCd%>" readonly><!-- 
								 --><input type="text" style="width:140px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" value=" <%=vslEngNm%>" readonly></td> 
							<th>INV Status</th>   
							<td><select style="width:60px;" name="app_flg" id="app_flg">
									<option value="N" selected>No</option>
									<option value="A">All</option>
									<option value="Y">Yes</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
		                <col width="80"> 
		                <col width="*">
		            </colgroup>
					<tbody>
						<tr>
							<th>Period</th>
							<td>
								    <input type="text" style="width:80px;text-align:center;" class="input" name="from_pay_dt" id="from_pay_dt" dataformat="ymd"><!-- 
								 --><button type="button" class="calendar" name="from_dt_cal" id="from_dt_cal" ></button>~ <!--
								 --><input type="text" style="width:80px;text-align:center;" class="input" name="to_pay_dt" id="to_pay_dt" dataformat="ymd"><!-- 
								 --><button type="button" class="calendar" name="to_dt_cal" id="to_dt_cal" ></button>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
		
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >	
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>			