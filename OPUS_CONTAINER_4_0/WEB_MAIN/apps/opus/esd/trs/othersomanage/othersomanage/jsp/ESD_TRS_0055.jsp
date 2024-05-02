<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0055.jsp
*@FileTitle : Other SO Correction
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.othersomanage.othersomanage.event.EsdTrs0018Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
	EsdTrs0018Event  event 		= null;
	Exception serverException   = null;			
	String strErrMsg 			= "";			
	SignOnUserAccount account = null;
	try {  
		event = (EsdTrs0018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, -30);
	beforeOneMonth = beforeOneMonth.substring(0,4) + "-" + beforeOneMonth.substring(4,6)+ "-" + beforeOneMonth.substring(6,8);  //saving the month
	String today_1 = DateTime.getFormatString("yyyy-MM-dd");

	String costModeCd   = JSPUtil.getCodeCombo("trs_cost_md_cd", "01", "style='width:145' OnChange='resetSearchCondition(this)'", "CD00744", 0, "000020::");
	String transModeCd  = JSPUtil.getCodeCombo("trs_md_cd", "01", "style='width:96' OnChange='resetSearchCondition(this)'", "CD00283", 0, "000010::");
%>
<script language="javascript">
var today = '<%=today%>';
var beforeOneMonth = '<%=beforeOneMonth%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
		setKindEnabled();
	}
</script>
</head>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="TRSP_SO_VNDR_NO">
<input type="hidden" name="TRSP_SO_TP_CD" value='O'>
<input type="hidden" name="TRSP_SO_STS_CD">
<input type="hidden" name="TRSP_SO_EQ_KIND">
<input type="hidden" name="EQ_KND_CD">
<input type="hidden" name="CGO_TYP_CD">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		 
   
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reset"      id="btn_reset">Reset</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="MiniLayer">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="180px" />
	            <col width="278px" />
	            <col width="102px" />
	            <col width="166px" />
	            <col width="77px" />
	            <col width="107px" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Service Order Creation Date</th>
					<td><input type="text" style="width:85px;" name='fmdate' value="<%=beforeOneMonth%>" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this); getDateBetween(this);" dataformat="ymd">~&nbsp;<!-- 
						 --><input name="todate" type="text" style="width:85px;" value="<%=today_1%>" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);" dataformat="ymd"><!-- 
						 --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>

					<th>Cost Mode</th>
					<td><%=costModeCd%></td>
					<th>Trans Mode</th>
					<td><%=transModeCd%></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>From</th>
					<td ><input type="text" style="width:52px;" name='search_fm_loc' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength=5 dataformat="engup"><!-- 
					 --><script language="javascript">ComComboObject('search_fm_yard', 1, 46, 0);</script><!-- 
					--><button type="button" class="input_seach_btn" name="btn_fm_node" id="btn_fm_node"></button></td>
					<th>Via</th>
					<td><input type="text" style="width:63px;" name='search_via_loc' onFocus='fun_Focus(this)' onChange='getComboList(this)' onKeyup='enterCheck(this)' maxlength=5 dataformat="engup"><!-- 
					 --><script language="javascript">ComComboObject('search_via_yard', 1, 46, 0);</script><button type="button" class="input_seach_btn" name="btn_via_node" id="btn_via_node"></button></td>
					<th>To</th>
					<td><input type="text" style="width:52px;" name='search_to_loc' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength=5 dataformat="engup"><!-- 
					 --><script language="javascript">ComComboObject('search_to_yard', 1, 46, 0);</script><button type="button" class="input_seach_btn" name="btn_to_node" id="btn_to_node"></button></td>
					<th>Door</th>
					<td><input type="text" style="width:52px;" name='search_dr_loc' onChange='getComboList(this)' onFocus='fun_Focus(this)' onKeyup='enterCheck(this)' maxlength=5 dataformat="engup"><!-- 
					 --><script language="javascript">ComComboObject('search_dr_yard', 1, 42, 0);</script><button type="button" class="input_seach_btn" name="btn_dr_node" id="btn_dr_node"></button></td>
				</tr>
				<tr>
					<th>Equipment No.</th>
					<td colspan="2" class="sm"   style="height:15; width:208; background-color: #E9E9E9;" style="padding-left:10;" width="208px">
                     <input type="radio" name='eq_kind' value="container" class="trans" onClick='setEqKindRadio(this);checkDigit();'  checked>&nbsp;Container&nbsp;&nbsp;&nbsp;
                     <input type="radio" name='eq_kind' value="chassis" class="trans" onClick='setEqKindRadio(this);'>&nbsp;Chassis&nbsp;&nbsp;&nbsp;
                     <input type="radio" name='eq_kind' value="genset" class="trans" onClick='setEqKindRadio(this);'>&nbsp;Genset
                     <input type="text" style="width:122;" name='eq_no' onChange='checkDigit(this)' dataformat="engup"><button type="button" class="multiple_inq ir" name='btn_eq_no' id='btn_eq_no'></button>
                     </td>
					<td></td>
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
	    <!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btng_sodelete" id="btng_sodelete">S/O Delete</button>
			<button type="button" class="btn_accent" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
			<button type="button" class="btn_accent" name="btng_socorrection" id="btng_socorrection">S/O Correction</button>
			<button type="button" class="btn_accent" name="btng_woissue" id="btng_woissue">W/O Issue</button>
		</div>
		<!-- opus_design_btn(E) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <script language="javascript">ComSheetObject('sheet2');</script>
	    <script language="javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>


<form name='woForm' method='POST'>
	<input type='hidden' name='trsp_so_ofc_cty_cd'>
	<input type='hidden' name='trsp_so_seq'>
	<input type='hidden' name='eq_mode'>
	<input type="hidden" name="sysCommUiTitle" value="Issue">
	<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
	<input type="hidden" name="pgmNo" value="">
	<input type="hidden" name="parentPgmNo" value="">
</form>