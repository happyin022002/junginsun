<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0450.jsp
*@FileTitle : Transmit History
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 
Exception serverException   = null;			//error from the server
String strErrMsg = "";						//error messege
int rowCount	 = 0;						//the number of DB ResultSet List

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String from_vvd_number       = "";
String from_pod_cd           = "";
  
Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	 
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();
	
	from_vvd_number = request.getParameter("from_vvd_number")==null?"":request.getParameter("from_vvd_number");
	from_pod_cd = request.getParameter("from_pod_cd")==null?"":request.getParameter("from_pod_cd");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}						 

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
		loadPage();
	}
</script>


<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mt_flag">
<input type="hidden" name="bkg_no">
<input type="hidden" name="msg_type">
<input type="hidden" name="from_vvd_number" value ="<%=StringUtil.xssFilter(from_vvd_number)%>">
<input type="hidden" name="from_pod_cd" value ="<%=StringUtil.xssFilter(from_pod_cd)%>">
<input type="hidden" name="sheet_vvd_number">
<input type="hidden" name="sheet_pol_cd">
<input type="hidden" name="sheet_pod_cd">
<input type="hidden" name="sheet_bl_no">
<input type="hidden" name="sheet_msg_snd_dt">
<input type="hidden" name="date_gubun" value="1">

	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		
	<!-- page_title(E) -->
	
	    
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_view"   id="btn_view">View Sent File</button>
				<button type="button" class="btn_normal" name="btn_history"   id="btn_history">History</button>
				<button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
				<button type="button" class="btn_normal" name="btn_print"   id="btn_print">Print</button>
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
	            <col width="60px" />
	            <col width="130px" />
	            <col width="100px" />
	            <col width="100px" />
	            <col width="100px" />
	            <col width="100px" />
	            <col width="100px" />
	            <col width="100px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th class="sm"><input type="radio" name="gubun" value="1" class="trans" checked>VVD</th>
					<td class="sm">
						<input name="vvd_number"  style="ime-mode: disabled; width:90px" dataformat="engup" 
						maxlength="9"  type="text" value="" class="input1">
					</td>
					<th class="sm"><input type="radio"  name="gubun" value="2" class="trans">Sent Date&nbsp;</th>
					<td class="sm">
						<input type="text" style="width: 80px; ime-mode: disabled" class="input1" 
							value="<%=JSPUtil.replace(DateTime.getDateString(),".","-")%>"
							dataformat="ymd" maxlength="10" name="vps_eta_start_dt" caption="ETA" cofield="vps_eta_end_dt" disabled>&nbsp;																 
						<input type="text" dataformat="hm" maxlength="5" name="fromtime" maxlength="5" class="input1" style="width:40px" 
							value="00:00" disabled>&nbsp;								 
						<input type="text" style="width: 80px; ime-mode: disabled" class="input1"  
							value="<%=JSPUtil.replace(DateTime.getDateString(),".","-")%>" dataformat="ymd" maxlength="10" name="vps_eta_end_dt" 
							caption="ETA" cofield="vps_eta_start_dt" disabled>&nbsp;
						<input type="text" dataformat="hm" maxlength="5" name="totime" class="input1" style="width:40px" value="23:59" disabled>&nbsp;
						<button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
					<th title="Port of Loading">POL</th>
					<td>
						<input type="text" name="pol_cd" style="width:70px; ime-mode: disabled;" class="input"
                        dataformat="engup" maxlength="5" fullfill caption="POL">
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" name="pod_cd" style="width:70px; ime-mode: disabled;" class="input"
                        dataformat="engup" maxlength="5" fullfill caption="POD">
					</td>
					<td></td>
				</tr>
				<tr>
					<th>MSG Type</th>
					<td>
						<select style="width:90px;" name = "sel_msg_type">						 
						<option value="" selected>All</option>
						<option value="1">Cancel</option>
						<option value="9">Original</option>
						<option value="5">Replace</option>
						</select>
					</td>
					<th>User ID</th>
					<td>
						<input name ="user_id" type="text" dataformat="engup"  style="width:120px; ime-mode: disabled" value="">
					</td>
					<th>B/L No.</th>
					<td>
						<input name ="bl_no" dataformat="engup"  type="text" style="width:112px; ime-mode: disabled" maxlength="12"  value="">
					</td>
					<td></td>
					<td></td>
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
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<div style="display:none">
		<script language="javascript">ComSheetObject('sheet2');</script>
		</div>		
		<div style="display:none">
		<script language="javascript">ComSheetObject('sheet3');</script>
		</div>		
	</div>
	<!-- opus_design_grid(E) -->
</div>	
	
</form>
