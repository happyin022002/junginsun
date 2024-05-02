<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0068.jsp
*@FileTitle  : TPR Target Ports Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0068Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0068Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationNPerformMasterDataMgt.OperationNPerformMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopOpf0068Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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

		loadPage('<%=strOfc_cd%>');
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="conti_cd" value="" id="conti_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">TPR Target Port Creation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button><!--  
	-->	</div>
	<!-- opus_design_btn(E) -->
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="30px;">
				<col width="70px;">
				<col width="*">
			</colgroup>
			<tr>
				<th>RHQ</th>
				<td><script type="text/javascript">ComComboObject('rhq');</script></td>
				<td>&nbsp;</td>					
			</tr> 
		</table>
	</div>
</div>
<div class="wrap_result bg">
	<div class="layout_wrap" style="width: ">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 46%">
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	    <!-- layout_vertical_2(E) -->
	    <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 8%;margin-top: 120px;">
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_etc" name="btn_Add" id="btn_Add" style="width: 40px;margin-bottom: 10px;margin-left: 3px;">Add.</button><!--  
			--><button type="button" class="btn_etc" name="btn_Delete"  	id="btn_Delete" style="width: 40px;margin-left: 3px;">Del.</button><!--  
			--></div>
			<!-- opus_design_btn(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
	     		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 46%">
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
</div>
</form>