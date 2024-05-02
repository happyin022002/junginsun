<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_116.jsp
*@FileTitle : retrieving & modifying Link info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0116Event"%>
<%
	EesEqr0116Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list

	// from loc select box
    String optionStr = "000001: :ALL";
	String frLocSelectBox = JSPUtil.getCodeCombo("fromStatus","","onChange='javascript:frLocChange(document.form.fromStatus.options[document.form.fromStatus.selectedIndex].value)' style='width:55;'","CD00242",0,optionStr);

	// to loc select box
	String toLocSelectBox = JSPUtil.getCodeCombo("toStatus","","onChange='javascript:toLocChange(document.form.toStatus.options[document.form.toStatus.selectedIndex].value)' style='width:55;'","CD00242",0,optionStr);

	// mode select box
	String modeSelectBox = JSPUtil.getCodeCombo("mode", "", "style='width:72%;'", "CD00566", 0, optionStr);

	String userId   = "";
	String userName = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId    = account.getUsr_id();
	   	//userAuth=account.getAuth();
	   	userName  = account.getUsr_nm();
		
		event = (EesEqr0116Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			/*
			eventResponse = (EES_EQR_116EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if

			*/
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    // COMBO DATA for SHEET1
	<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00566", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("combo02", "01", "CD00164", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("combo03", "01", "CD00164", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
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
		<table border="0">
		<tr>
			<th width="111px"><%//<img class="nostar">%>From Location</th>
			<td width="400px">
				<%= frLocSelectBox %><!--
				 --><input type="text" name="fromLocation" value="" style="width:280px;ime-mode:disabled;" dataformat='engup' otherchar=","><!--				
				--><button type="button" class="input_seach_btn" name="frloc_btn"></button>
			</td>
			<th width="102px">To Location</th>
			<td width="*">
				<%= toLocSelectBox %><!--
				--><input type="text" name="toLocation" value="" style="width:280px;ime-mode:disabled;" dataformat='engup' otherchar=","><!--
				--><button type="button" class="input_seach_btn" name="toloc_btn"></button>				
			</td>
		</tr>
		</table>
		<table border="0">
		<tr>
			<th width="111px"><%//<img class="nostar">%>Transit Days</th><!--
		 --><td width="135px" class="stm"><input name="transitTime" type="text" style="width:59px;ime-mode:disabled;" maxlength=5 dataformat="num"></td><!--
		 --><th width="47px">Mode</th><!--
		 --><td width="218px">
				<%= modeSelectBox %>
			</td><!--
			 --><th width="95px">Update By / DT</th><!--
			 --><td width=""><input type="text" name="userid" value="" class="input2" style="width:84px" readOnly> / <input type="text" name="date" value="" class="input2" style="width:70px" readOnly></td>
		</tr>
		</table>		
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

<!-- checkEccCode check framework -->
<iframe frameborder=0 width=0 name="iframe" scrolling="no" frameborder="0" width="0" height="0"></iframe>

</form>
