<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0091.jsp
*@FileTitle  : Agreement No. Selection 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0091Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesLse0091Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0091Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String strMultiChk = (request.getParameter("multi_chk") == null)? "": request.getParameter("multi_chk");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="multi_chk" id="multi_chk" value="<%=strMultiChk %>" />
<input type="hidden" name="h_agmt_act_flg" id="h_agmt_act_flg" value="<%= StringUtil.xssFilter(request.getParameter("h_agmt_act_flg")) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Agreement No. Selection</span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_OK"  	id="btn_OK">Ok</button><!-- 
				--><button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button> 
			</div>
	</div>
</div>
	
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
			<tbody>
			
	              <tr>
	                <th width="90">Agreement No.</th>
	                <td  width="120"><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:35px;text-align:center;" class="input2" value="HHO" readonly id="agmt_cty_cd" /><input type="text" name="agmt_seq" caption="AGMT No." style="width:50px;text-align:center;" class="input" maxlength="6" dataformat="num" id="agmt_seq" /> </td>
	                <th width="70">Active Flag</th>
	                <td width="80">
	                	<select name="agmt_act_flg" id="agmt_act_flg"  caption="Active Flag" style="width:75px;">
							<option value="" selected>ALL</option> 
							<option value="A">Active</option> 
							<option value="I">Inactive</option> 
						</select>
					</td>
	                <th width="30">Office</th>
	                <td width="60"><input type="text" name="ofc_cd" caption="Office" style="width:46px;ime-mode:disabled;" class="input" maxlength="6" dataformat="engup" id="ofc_cd" /><button type="button" id="btn_Office" name="btn_Office" class="input_seach_btn"></button></td>
	                <th width="90">Lease Term</th>
	                <td><script type="text/javascript">ComComboObject('combo1', 1, 50, 0);</script></td>
	              </tr>
	              
	              <tr>
	                <th>Old AGMT No.</th>
					<td><input type="text" name="old_agmt_no" caption="Old AGMT No." style="width:102px;ime-mode:disabled;" class="input" value="" maxlength="20" dataformat="excepthan" id="old_agmt_no" /></td>
					
	                <th>Contract No.</th>
	                <td><input type="text" name="ref_no" caption="Contract No." style="width:104px;ime-mode:disabled;" class="input" maxlength="20" dataformat="excepthan" id="ref_no" /> </td>
	                <th>Lessor Name</th>
	                <td><input type="text" name="vndr_lgl_eng_nm" caption="Lessor Name" style="width:100px;ime-mode:disabled;" class="input" !dataformat="eng" id="vndr_lgl_eng_nm" /> </td>
	                <th>Lessor ABBR</th>
	                <td><input type="text" name="vndr_abbr_nm" caption="Lessor ABBR" style="width:100px;ime-mode:disabled;" class="input" !dataformat="eng" id="vndr_abbr_nm" /> </td>
	              </tr>
	              </tbody>
	            </table>
	     </div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid">
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
