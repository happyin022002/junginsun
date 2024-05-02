<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0078.jsp
*@FileTitle : W/O Remark(By Office Cost / Trans Mode and IN / OUT Bound by W / O to manage information in the remarks applied to a common screen)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event"%>
<%
	EsdTrs0078Event  event = null;	
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	SignOnUserAccount account = null;
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String costModeCd   = JSPUtil.getCodeCombo("f_trsp_cost_mod_cd", "01", "style='width:160'", "CD00744", 0, "000020:ALL:ALL");
	String transModeCd  = JSPUtil.getCodeCombo("f_trsp_crr_mod_cd" , "01", "style='width:120'", "CD00283", 0, "000010:ALL:ALL");
	String boundCd      = JSPUtil.getCodeCombo("f_trsp_bnd_cd"     , "01", "style='width:90'" , "CD00591", 0, "000030:ALL:ALL");

%>
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_trsp_cost_mod_cd", "", "CD00744", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_trsp_crr_mod_cd" , "", "CD00283", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_trsp_bnd_cd"     , "", "CD00591", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_cre_usr_id" value="<%=account.getUsr_id()%>">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->		
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
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
	<div class="opus_design_inquiry wFit" id="showMin">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="40" />
	            <col width="120" />
	            <col width="40" />
	            <col width="180" />
	            <col width="60" />
	            <col width="80" />
	            <col width="40" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Office</th>
					<td><input type='text' name='f_usr_ofc_cd' style='width:90px' value='<%=account.getOfc_cd()%>' disabled></td>
					<th>Cost Mode</th>
					<td><%=costModeCd%></td>
					<th>Trans Mode</th>
					<td><%=transModeCd%></td>
					<th>Bound</th>
				    <td><%=boundCd%></td>
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
	    
	    <!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button>
				<button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
			</div>
		<!-- opus_grid_btn(E) -->
			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>
