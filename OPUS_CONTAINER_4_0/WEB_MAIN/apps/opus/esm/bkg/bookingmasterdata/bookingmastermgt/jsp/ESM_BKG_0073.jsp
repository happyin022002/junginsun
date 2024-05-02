<%
/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_0073.jsp
*@FileTitle  : BDR Time Table 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
 ========================================================= */
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0073Event"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0073Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	
	
	String screenName = "";
	String sLandOptCheck = "";
	String sVvdOptCheck = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0073Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	  	screenName = screen.getName();

	  if (screenName.indexOf("_1") > 0){
		  sLandOptCheck = "disabled";
		  sVvdOptCheck = "checked";
	  }else{
		  sVvdOptCheck = "disabled";
		  sLandOptCheck = "checked";
	  }
	  if (screenName.indexOf("Q") > 0){
		  sLandOptCheck = "checked";
		  sVvdOptCheck = "";
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
		$('.searchTb2').css("display", "none");
		loadPage();
	}
</script>

<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd">
	<input type="hidden" name="pagerows" id="pagerows">
	<!-- Developer Work	-->

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><% if (screenName.indexOf("Q") < 0){ %><!--  
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_Creation" id="btn_Creation">Creation</button><!--  
			--><% } %><!--  
			--></div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>

	<!-- page_title_area(E) -->
	
	<!-- opus_design_inquiry(S) -->
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table id="searchTb" class="searchTb">
			<% if (screenName.indexOf("_1") > 0){ %>
				<colgroup>
					<col width="50px">
					<col width="50px">
					<col width="60px">
					<col width="50px">
					<col width="60px">
					<col width="50px">
					<col width="60px">
					<col width="50px">
					<col width="70px">
					<col width="50px">
					<col width="50px">
					<col width="*">
				</colgroup>
			<% } else if (screenName.indexOf("Q") > 0) {%>

			<% }else{ %>
				<colgroup>
					<col width="50px">
					<col width="50px">
					<col width="70px">
					<col width="50px">
					<col width="80px">
					<col width="50px">
					<col width="70px">
					<col width="*">
				</colgroup>
			<% } %>
			<tr>
				<th>Option</th>
				<td class="sm"><!--  
				--><input type="radio" name="opt_sel_bdr" id="opt_sel_bdr" value="Lane" class="trans" onClick="checkOption()" <%=sLandOptCheck %>><label for="opt_sel_bdr">Lane</label><!--  
				--><input type="radio" name="opt_sel_bdr" id="opt_sel_bdr1" value="VVD" class="trans" onClick="checkOption()" <%=sVvdOptCheck %>><label for="opt_sel_bdr1">VVD</label><!--  
				--></td>
				<th class="searchTb1">Lane</th>
				<td class="searchTb1"><!--  
				--><script type="text/javascript">ComComboObject('cb_slan_cd', 1, 60, 0,1,0,true);</script><!--  
				--><script type="text/javascript">
					function cb_slan_cd_OnChange(){
						getPortList();
					}
					function cb_slan_cd_OnBlur(){
						checkKeyInCombo(cb_slan_cd);
					}
					</script></td>
				<th class="searchTb1">Bound</th>
				<td class="searchTb1"><!--  
				--><script type="text/javascript">ComComboObject('cb_skd_dir_cd', 1, 50, 0,1,0,true);</script><!--  
				--><script type="text/javascript">
					function cb_skd_dir_cd_OnBlur(){
						checkKeyInCombo(cb_skd_dir_cd);
					}
					</script></td>
				<th class="searchTb1">POL</th>
				<td class="searchTb1"><!--  
				--><script type="text/javascript">ComComboObject('cb_pol_cd',  1, 70,true,'');</script><!--  
				--><script type="text/javascript">
					function cb_pol_cd_OnBlur(){
						checkKeyInCombo(cb_pol_cd);
					}
					</script></td>
				<th class="searchTb2">VVD</th>
				<td class="searchTb2"><!--  
				--><input type="text" name="vvd" id="vvd" style="width:77px;ime-mode:disabled;" class="input" value=""  dataformat="engup" caption="VVD" maxlength="9"  fullfill onchange="getVvdPortList()"><!--  
				--><button type="button" name="btn_com_ens_ob2_pop" id="btn_com_ens_ob2_pop" class="input_seach_btn"></button></td>
				<th class="searchTb2">POL</th>
				<td class="searchTb2"><!--  
				--><script type="text/javascript">ComComboObject('pol_cd', 3, 70, 0,0,0,true);</script><!--  
				--><script type="text/javascript">
					function pol_cd_OnChange(){
						selVvdPortVal();
					}
					function pol_cd_OnBlur(){
						checkKeyInCombo(pol_cd);
					}
					</script></td>
				<th class="searchTb2">POD</th>
				<td class="searchTb2"><!--  
				--><script type="text/javascript">ComComboObject('pod_cd', 1, 70, 0,0,0,true);</script><!--  
				--><script type="text/javascript">
					function pod_cd_OnBlur(){
						checkKeyInCombo(pod_cd);
					}
					</script></td>
				<th class="searchTb2">LANE</th>
				<td class="searchTb2"><input type="text" name="slan_cd" id="slan_cd" style="width:40px;"style="ime-mode:disabled;" class="input2" value="" dataformat="engup" caption="LANE" maxlength="3"  fullfill readonly></td>
				<th  class="searchTb2" style="margin-left: 50px;">ETD</th>
				<td class="searchTb2"><input type="text" name="etd_cd" id="etd_cd"   style="width:130px;" class="input2" value="" readonly></td>
			</tr>
		</table>
	</div>
	<!-- <table class="line_bluedot"><tr><td colspan="8"></td></tr></table> -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<!--  Button_Sub (S) -->
			<div class="opus_design_btn" id="rowButtonTable"><!--  
			-->
			<!-- Check if index not contain Q && _1 then add button. -->
				<% if (screenName.indexOf("Q") < 0 && screenName.indexOf("_1") < 0){ %><!--  
				--><button type="button" class="btn_accent" name="btn_RowAdd1" id="btn_RowAdd1">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn_DeleteRow1" id="btn_DeleteRow1">Delete Row</button><!--  
				--><% } %>
			</div>
		<!--  Button_Sub (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
		<div class="opus_design_grid" id="mainTable" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>