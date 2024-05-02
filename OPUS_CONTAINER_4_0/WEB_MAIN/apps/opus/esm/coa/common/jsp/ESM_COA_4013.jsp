<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4013.jsp 
*@FileTitle  : Creation Operation Days popup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/07/20 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.common.event.EsmCoa4013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa4013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	//사용 변수
//	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));

	Logger log = Logger.getLogger("com.clt.apps.EQBalance.EQBalance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa4013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
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

<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

	<!-- layer_popup_title(S) -->
	<div class="layer_popup_title">
	    <div class="page_title_area clear">
	        <!-- page_title(S) -->
	        <h2 class="page_title"><span>Creation Operation Days</span></h2>
	        <!-- page_title(E) -->
	        
	       <!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Creation</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
	    </div>
	</div>
	<div class="layer_popup_contents" style="overflow:hidden">
		<!-- layer_popup_title(E) -->	
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="40" />
						<col width="50" />
						<col width="40" />
						<col width="25" />					
						<col width="*" />
					</colgroup>
					<tbody>
				        <tr>
				        	<td colspan="5"><b>Period(YYYY_WW)</b></td>
				        </tr>
				        <tr>
				        	<td><b>From</b></td>
				        	<td><input type="text" class="input1" name="f_fm_wk" id="f_fm_wk" dataformat="yw" style="width:60px" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onChange="" onBlur="addDash(this , 4);"  onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
			                <td align="center"><b>~</b></td>
			                <td><b>To</b></td>
			                <td align="left"><input type="text" class="input1" name="f_to_wk" id="f_to_wk" dataformat="yw" style="width:60px" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onChange="" onBlur="addDash(this , 4);" onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
				        </tr>
					</tbody>
				</table>
			</div>
		</div>	
		<!-- opus_design_grid(S) -->
		<div class="wrap_result">
			<div class="opus_design_grid clear" id="mainTable" >
					<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>