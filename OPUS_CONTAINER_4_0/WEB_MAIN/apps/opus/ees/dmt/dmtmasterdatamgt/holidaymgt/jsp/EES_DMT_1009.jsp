<%--
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1009.jsp
*@FileTitle  : SB45 Ruling Exceptions
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/25
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//server exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.DMTMasterDataMgtSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt1009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("dem_det_tp_cd",         "", "CD30098", 0, "")%>

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
<input type="hidden" name="cnt_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="retry">
<input type="hidden" name="io_bnd_cd" value="A">
<input type="hidden" name="dem_det_tp_cd">
<input type="hidden" name="dmdt_calc_tp_cd">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="val_curr" value="Y">
<input type="hidden" name="val_tobe" value="Y">
<input type="hidden" name="result">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear" >
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
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

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="70px" />
            <col width="120px" />
            <col width="70px" />
            <col width="70px" />
            <col width="70px" />
            <col width="70px" />
            <col width="*" />
        </colgroup>
        <tbody>
			<tr>
				<th>Country</th>
				<td><script type="text/javascript">ComComboObject('combo1', 2, 60, 0);</script></td>
				<th>Location</th>
				<td>
					<input type="text" class="input" id="location" name="location" value="" maxlength="5" dataformat="engup" OnKeyUp="checkLocation1(this)">
				</td>
				<th>Yard</th>
				<td><input type="text" id="yd_cd1" name="yd_cd1" style="width:60px;" class="input" value="" dataformat="engup" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkYard1(this)" ></td>
				<td><script type="text/javascript">ComComboObject('combo5', 1, 50 , 0, 0, 0, true)</script></td>
			</tr>
			<tr>
				<th>Bound</th>
				<td colspan="6"><select id="bound" name="bound" onChange="checkBound(this)">
				    	<option value="A">ALL</option>
				    	<option value="O">OB</option>
				    	<option value="I">IB</option>
				    </select></td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="t1btng_rowadd" id="t1btng_rowadd">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="t1btng_rowcopy" id="t1btng_rowcopy">Row Copy</button><!-- 
		--><button type="button" class="btn_normal" name="t1btng_save" id="t1btng_save">Save</button>
	</div>
	<!-- opus_grid_btn(E) -->

	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->
</div>
</form>