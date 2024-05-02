<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0151.jsp
*@FileTitle  : M&R Disposal Candidate Selection 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0151Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0151Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm();
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		event = (EesMnr0151Event)request.getAttribute("Event");
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
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>
<script type="text/javascript">
//<![CDATA[
	self.onerror = function() { return false; }
//]]>
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="f_gubuns" name="f_gubuns" type="hidden" />
<input id="cost_ofc_cd" name="cost_ofc_cd" type="hidden" />
<input id="self_ofc_cd" name="self_ofc_cd" value="<%=currOfcCd%>" type="hidden" />
<input id="mnr_grp_tp_cd" name="mnr_grp_tp_cd" value="RPR" type="hidden" />
<input id="mnr_wo_tp_cd" name="mnr_wo_tp_cd" value="RFS" type="hidden" />
<input id="sel_type" name="sel_type" value="S" type="hidden" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="125" />
            <col width="100" />
            <col width="110" />
            <col width="100" />
            <col width="85" />
            <col width="50" />
            <col width="200" />
            <col width="350" />
            <col width="80" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th>Selection Type</th>
				<td><script type="text/javascript">ComComboObject('combo_select_cd',1, 120 , 1, 1,0,false,0);</script>
				<input type="hidden" name="select_cd"></td>
				<th>EQ KIND</th>
				<td><script type="text/javascript">ComComboObject('combo_eq_knd_cd',1, 100, 1, 1,0,false,0);</script>
				<input type="hidden" name="eq_knd_cd"></td>
				<th>EQ TP/SZ </th>
				<td><script type="text/javascript">ComComboObject('combo_eq_tpsz_cd', 2, 120 ,0)</script>
				<input type="hidden" name="eq_tpsz_cd"></td>
				<th><div id="dateTitle"> EQ Manufactured Year</div></th>
				<td><div id="dateHtml"><input type="text" maxlength=4 style="width:40px;text-align:center;" class="input" name="fryear" dataformat="int" required fullfill><!--
			 --><button type="button" class="calendar ir" name="btn_fryear" id="btn_fryear"></button> ~ <input type="text" maxlength=4 style="width:40px;text-align:center;" class="input" name="toyear" dataformat="int" required fullfill><!--
			 --><button type="button" class="calendar ir" name="btn_toyear" id="btn_toyear"></button>
				</div></td>
				<th>EQ No.</th>
				<td><input name="rqst_eq_no" type="text" style="width:90px" class="input" dataformat="engup" disabled=true value=""><button type="button" class="multiple_inq" name="eq_no_multi1" id="eq_no_multi1"></button>
				</td>
			</tr>
			<tr id="locTpCdCombo" style="display:none;">
<!-- 				<th >RU Label Type</th> -->
<!-- 				<td > -->
<!-- 					<script type="text/javascript">ComComboObject('ru_lable_type', 1, 91, 1);</script> -->
<!-- 				</td> -->
<!-- 				<th >RU Label Value</th> -->
<!-- 				<td>  -->
<!-- 					<script type="text/javascript">ComComboObject('rstr_usg_lbl', 1, 140, 1 );</script> -->
<!-- 				</td> -->
				<th>RU Label</th>
				<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
				<td colspan="5">&nbsp;</td>
				
			</tr>
			
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<h3 class="title_design" id="sheet_title">Disposal Candidate Selection by Serial Range</h3>
	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
		<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
		<button type="button" class="btn_normal" name="btn_rowdel" id="btn_rowdel">Row Del</button>
	</div>
	<!-- opus_grid_btn(E) -->

	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    
    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet2');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    
    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet4');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    
    <script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->



</form>
<%-- <%@include file="/bizcommon/include/common_opus.jsp" %> --%>