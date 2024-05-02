      <%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0183.js
*@FileTitle  : Avg RPB 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.event.EsmCoa0183Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0183Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String curYrMon			= "";
	String colsYrMon		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0183Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		curYrMon = eventResponse.getETCData("YRMON");
		colsYrMon = eventResponse.getETCData("COL_YRMON");
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
<form name="form" id="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="tab_item" id="tab_item">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Creation"  	id="btn_Creation">Creation</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 			
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
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
	<!-- 	<div class="opus_design_data sm mar_top_8 mar_btm_8">	 -->	
			<table>		
				<colgroup>
					<col width="110px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>YYYY-MM</th>
					<td><input type="text" class="input1" name="f_rpb_yrmon" id="f_rpb_yrmon" style="width:60px" maxlength="7" dataformat="ym"
                 					onKeyPress="ComKeyOnlyNumber(window)" onChange="setPeriod(this);"
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" value="<%=curYrMon%>" ></td>
                	<td><div id='div_period' name='div_period'></div></td>
					<th id="combo_f_trd_cd" name="combo_f_trd_cd">Trade&nbsp;<script type="text/javascript">ComComboObject('f_trd_cd', 1, 70, 1)</script></th>		
					
					 <th id="combo_f_rlane_cd" name="combo_f_rlane_cd">Lane&nbsp;
                		<script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 0)</script>
               		 </th>			
					<th id="combo_f_ioc_cd" name="combo_f_ioc_cd">IOC&nbsp;<script type="text/javascript">ComComboObject('f_ioc_cd', 1, 70, 0)</script> </th>
					<th id="f_bkg_por_cd" name="combo_f_bkg_por_cd">POR&nbsp;<input type="text" class="input" name="f_bkg_por_cd" id="f_bkg_por_cd" style="width:60px" maxlength="5" dataformat="engup"></th>
                	<th id="f_bkg_del_cd" name="combo_f_bkg_del_cd" >DEL&nbsp;<input type="text" class="input" name="f_bkg_del_cd" id="f_bkg_del_cd" style="width:60px" maxlength="5" dataformat="engup"></th>
                
                	<th id="f_bkg_por_scc_cd" name="f_bkg_por_scc_cd">POR SCC&nbsp;<input type="text" class="input" name="f_bkg_por_scc_cd" id="f_bkg_por_scc_cd" style="width:60px" maxlength="5" dataformat="engup"></th>
                	<th id="f_bkg_del_scc_cd"  name="f_bkg_del_scc_cd">DEL SCC&nbsp;<input type="text" class="input" name="f_bkg_del_scc_cd" id="f_bkg_del_scc_cd" style="width:60px" maxlength="5" dataformat="engup"></th>
                
                	<th id="combo_f_dir_cd" name="combo_f_dir_cd">Direction&nbsp;
                		<script type="text/javascript">ComComboObject('f_dir_cd', 1, 70, 0)</script>
                	</th>
                	<th id="combo_f_cntr_tpsz_cd" name="combo_f_cntr_tpsz_cd">Type/Size&nbsp; 
                		<script type="text/javascript">ComComboObject('f_cntr_tpsz_cd', 1, 70, 0)</script>
               	 	</th>
				</tr>			
			</table>
		<!-- </div> -->
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div name="tabLayer" id="tabLayer" style="display:inline;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<div class="opus_design_data">
			<table>
				<tr><td height="18"><img src="/opuscntr/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
				<tr><td style="padding-left:11;" class="sm"><!-- 20150730.MOD -->
				<img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
				Customer RPB is created automatically after 2 P.M on every Friday by Batch.<br><!-- 20150817.MOD -->
				<img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
				Route RPB, SCC, Lane, Trade RPB need to be created by user, for each month. </td></tr>
			</table>
		</div>
	</div>
	
	<div name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
	
	<div name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>
	
	<div name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
	</div>
	
	<div name="tabLayer" id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
	</div>
</div>
<!-- 개발자 작업  끝 -->
</form>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             