<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4031.jsp
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.location.event.EsmPri4026Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri4026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.Location");
	
	String groupCmd = "";
	String propNo = "";
	String svcScpCd = "";
	String amdtSeq = "";
	String grpLocSeq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	   
		event = (EsmPri4026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		RsltGrpLocListVO rsltGrpLocListVO = event.getRsltGrpLocListVO();
		
		if(rsltGrpLocListVO != null) {
			groupCmd = rsltGrpLocListVO.getGroupCmd();
			propNo = rsltGrpLocListVO.getPropNo();
			svcScpCd = rsltGrpLocListVO.getSvcScpCd();
			amdtSeq = rsltGrpLocListVO.getAmdtSeq();
			grpLocSeq = rsltGrpLocListVO.getGrpLocSeq();
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="group_cmd" value="<%=StringUtil.xssFilter(request.getParameter("group_cmd"))%>"> 
<input type="hidden" name="location_cmd" value="LTCR">
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" >
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="cre_ofc_cd" value="<%=StringUtil.xssFilter(request.getParameter("cre_ofc_cd"))%>" >
<input type="hidden" name="grp_loc_seq" >
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(request.getParameter("gline_seq"))%>">
<input type="hidden" name="loc_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("loc_tp_cd"))%>">
<input type="hidden" name="org_dest_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_cd"))%>">
<input type="hidden" name="qttn_no" value="<%=StringUtil.xssFilter(request.getParameter("qttn_no"))%>">
<input type="hidden" name="qttn_ver_no" value="<%=StringUtil.xssFilter(request.getParameter("qttn_ver_no"))%>">
<input type="hidden" name="chg_cd" value="<%=StringUtil.xssFilter(request.getParameter("chg_cd"))%>">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	   
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<div style="display:block" id="btn1">
				<button type="button" class="btn_accent" name="btn_t1Retrieve" id="btn_t1Retrieve">Retrieve</button> 
				<button type="button" class="btn_accent" name="btn_t1New" id="btn_t1New">New</button>
			</div>
			
			<div style="display:none" id="btn2">
				<button type="button" class="btn_accent" name="btn_t2Retrieve" id="btn_t2Retrieve">Retrieve</button> 
				<button type="button" class="btn_accent" name="btn_t2New" id="btn_t2New">New</button>
			</div>
			
			<div style="display:none" id="btn3">
				<button type="button" class="btn_accent" name="btn_t3Retrieve" id="btn_t3Retrieve">Retrieve</button> 
			 	<button type="button" class="btn_accent" name="btn_t3New" id="btn_t3New">New</button>
			</div>
			
			<div style="display:none" id="btn4">
				<button type="button" class="btn_accent" name="btn_t4Retrieve" id="btn_t4Retrieve">Retrieve</button> 
			 	<button type="button" class="btn_accent" name="btn_t4New" id="btn_t4New">New</button>
			</div>
			
			<div style="display:none" id="btn5">
				<button type="button" class="btn_accent" name="btn_t5Retrieve" id="btn_t5Retrieve">Retrieve</button> 
			 	<button type="button" class="btn_accent" name="btn_t5New" id="btn_t5New">New</button>
			</div>
			
		</div>
		
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
	            <col width="50px" />
	            <col width="520px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th class="sm">Type</th>
				    <td class="sm" style="padding-left:15px;">
				    <input name="radio_type" id="radio_type1" type="radio" value="1" class="trans" checked="true"> 
				     <label for="radio_type1">Location</label>
					<div id="hiddenLayer" style="display:none">
					<input type="radio" name="radio_type" id="radio_type2" value="2" class="trans" > 
					 <label for="radio_type2">Location Group</label>
					</div>
					<input type="radio" name="radio_type" id="radio_type3" value="3" class="trans"> 
					 <label for="radio_type3">State</label>
					<input type="radio" name="radio_type" id="radio_type4" value="4" class="trans"> 
					 <label for="radio_type4">Region</label>
					<input type="radio" name="radio_type" id="radio_type5" value="5" class="trans"> 
					 <label for="radio_type5">Country</label>
					</td>
					<td ></td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <!-- opus_design_inquiry(E) -->
		<div id="radioSearchLayer1" style="display:block">
			<table>
	        <colgroup>
	            <col width="50px" />
	            <col width="100px" />
	            <col width="60px" />
	            <col width="350px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Code</th>
				    <td><input name="loc_cd" id="loc_cd" type="text" style="width:70px;" maxlength="5" minlength="2" class="input" value="" style="ime-mode:disabled" dataformat="engup"></td>
					<th>Description</th>
				    <td><input name="loc_nm" type="text" style="width:350px;" maxlength="30" class="input" value="<%=request.getParameter("loc_def_nm")==null?"":request.getParameter("loc_def_nm")%>" style="ime-mode:disabled" ></td>
				    <td></td>
				</tr>
			</tbody>
			</table>
		</div>
	
	
		<!-- opus_design_inquiry(E) -->
		<div id="radioSearchLayer2" style="display:none">
			<table>
	        <colgroup>
	            <col width="40px" />
	            <col width="300px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Code</th>
				    <td>
				    <script language="javascript">ComComboObject('combo_grp_loc_cd', 2, 70, 0, 1, 0, false);</script>
						&nbsp;<input type="text" name="combo_grp_loc_nm" style="width:200px;" class="input"  value="" disabled="true"></td>
				    <td></td>
				</tr>
			</tbody>
			</table>
		</div>
		
		<!-- opus_design_inquiry(E) -->
		<div id="radioSearchLayer3" style="display:none">
			<table>
	        <colgroup>
	            <col width="105px" />
	            <col width="300px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				
				<tr class="h23">
					<th>Country Code</th>
				   	<td><script language="javascript">ComComboObject("combo_cnt_cd", 2, 70, 0, 1, 0, false);</script> 
						 <input type="text" name="combo_cnt_nm" style="width:150px;" class="input" value="" disabled="true"></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>State</th>
				    <td><input type="text" name="ste_cd" id="ste_cd" style="width:70px;" maxlength="2" minlength="1" class="input" value="" style="ime-mode:disabled" dataformat="engup"> 
				    	 <input type="text" name="ste_nm" maxlength="30" style="width:150px;" class="input" value="" style="ime-mode:disabled"></td>
				    <td></td>
				</tr>
			</tbody>
			</table>
		</div>
		
		
		<!-- opus_design_inquiry(E) -->
		<div id="radioSearchLayer4" style="display:none">
			<table>
	        <colgroup>
	            <col width="105px" />
	            <col width="300px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Country Code</th>
				   	<td><script language="javascript">ComComboObject("combo2_cnt_cd", 2, 70, 0, 1, 0, false);</script> 
						 <input type="text" name="combo2_cnt_nm" style="width:150px;" class="input" value="" disabled="true"></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>Region</th>
				    <td><input type="text" name="rgn_cd" id="rgn_cd" style="width:70px;" maxlength="3" minlength="2" class="input" value="" style="ime-mode:disabled" dataformat="engup"> 
				    	 <input type="text" name="rgn_nm" maxlength="30" style="width:150px;" class="input" value="" style="ime-mode:disabled"></td>
				    <td></td>
				</tr>
				
			</tbody>
			</table>
		</div>
		
		
		<!-- opus_design_inquiry(E) -->
		<div id="radioSearchLayer5" style="display:none">
			<table>
	        <colgroup>
	            <col width="50px" />
	            <col width="100px" />
	            <col width="60px" />
	            <col width="350px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Code</th>
				    <td><input name="cnt_cd" id="cnt_cd" type="text" style="width:70px;ime-mode:disabled" maxlength="2" class="input" value="" dataformat="engup"></td>
					<th>Description</th>
				    <td><input name="cnt_nm" type="text" style="width:350px;ime-mode:disabled" maxlength="30" class="input" value="" ></td>
				    <td></td>
				</tr>
			</tbody>
			</table>
		</div>
		
	</div>
	
</div>

<div class="wrap_result">


	<!-- Raido Tab [ Location ] (S) -->
<div id="radioLayer1" style="display:block">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	
	<!-- opus_design_grid(E) -->
</div>

	<!-- Raido Tab [ Location ] (S) -->
<div id="radioLayer2" >
	<!-- opus_design_grid(S) -->
	
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	
</div>


	<!-- Raido Tab [ Location ] (S) -->
<div id="radioLayer3" >
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>



	<!-- Raido Tab [ Location ] (S) -->
<div id="radioLayer4" >
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet4');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>



	<!-- Raido Tab [ Location ] (S) -->
<div id="radioLayer5" >
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet5');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>

</div>
</form>