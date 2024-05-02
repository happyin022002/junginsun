<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0134.jsp
*@FileTitle : retrieving for ECC info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0115Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0115Event  event = null;						//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;					//error from server
	String strErrMsg = "";								//error message
	int rowCount	 = 0;								//count of DB resultSET list

    String optionStr = "000001: :ALL";
	String actionSelectBox = JSPUtil.getCodeCombo("status","","onChange='javascript:locChange(document.form.status.options[document.form.status.selectedIndex].value)' style='width:55;'","CD00242",0,optionStr);

	String userId   = "";
	String userName = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId    = account.getUsr_id();
	   	userName  = account.getUsr_nm();

		event = (EesEqr0115Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	// showing Base select box data
	<%= JSPUtil.getIBCodeCombo("box", "01", "CD00164", 0, "")%>
	// showing Yearly select box data
	<%= JSPUtil.getIBCodeCombo("yearly", "01", "CD00239", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();

	}

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" name="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_eqorg" id="btn_eqorg">Eq Org</button><!--
	    --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry">
		<!-- : ( Scenario ID ) (S) -->
		<table>
		<tr>
			<th width="70px"><%//<img class="nostar">%>Location</th>
			 <td width="500px">
				<%= actionSelectBox %><!--
				 --><input type="text" name="location" style="width:332px;ime-mode:disabled;" dataformat='engup' otherchar=","><!--				
				 --><button type="button" class="input_seach_btn" name="loc_btn"></button>
			</td>
			<th  width="120px">Update By / DT</th>
			<td  width="100px"><input type="text" style="width:84px" name="userid" value="" class="input2" readOnly> /</td>
			<td width="*"><input type="text" name="date" class="input2" style="width:70px" value="" readOnly></td>
		</tr>
		</table>
		<!-- : ( Scenario ID ) (E) -->		
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>  
		<script language="javascript">ComSheetObject('sheet2');</script>  
	</div>	
</div>

</form>
