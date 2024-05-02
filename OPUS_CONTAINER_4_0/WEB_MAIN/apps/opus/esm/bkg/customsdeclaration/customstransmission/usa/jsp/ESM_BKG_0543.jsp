<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0543.jsp
*@FileTitle  : Vessel Departure Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0543Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0543Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	//int rowCount	 = 0;						//count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvd_cd= "";
	String pod_cd= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		vvd_cd= request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
		pod_cd= request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0543Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="form1_vvd_cd" value="<%=StringUtil.xssFilter(vvd_cd)%>">
<input type="hidden" name="form1_pod_cd" value="<%=StringUtil.xssFilter(pod_cd)%>">
<input type="hidden" name="transmit_cd" value="HI"> 

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	         
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit</button>			
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
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>	        
			<tr>					
				<td>
					<table>
						<colgroup>
				            <col width="80">
				            <col width="110">
				            <col width="30">
				            <col width="110">
				            <col width="30">
				            <col width="125">
				            <col width="85">
				            <col width="60">
				            <col width="*">
				        </colgroup>
			        	<tbody>
			        		<tr>
			        			<th title="Vessel Voyage Direction">VVD</th>
			        			<td>
			        				<input type="text" name="vvd" style="width:80px;" class="input1" value="" dataformat="engup" maxlength="9" required>
			        			</td>
			        			<th title="Port of Loading">POL</th>
			        			<td>
			        				<input type="text" name="pol_cd" style="width:60px;" class="input1" value="" dataformat="engup" maxlength="5" required>
			        			</td>
			        			<th title="Port of Discharging">POD</th>
			        			<td>
			        				<input type="text" name="pod_cd" style="width:60px;" class="input1" value="" dataformat="engup" maxlength="5" required>
			        			</td>
			        			<th>M.B/L Count</th>
			        			<td>
			        				<input type="text" name="bl_count" style="width:60px;" class="input" value="" dataformat="int">
			        			</td>
			        			<td></td>
			        		</tr>			        		
			        	</tbody>						
					</table>					
				</td>
			</tr>			
			<tr>			
      			<td><table class="line_bluedot"><tr><td colspan="8"></td></tr></table></td>
       		</tr>
			<tr>
				<td>
					<table>
						<colgroup>
				            <col width="80">
				            <col width="220">
				            <col width="60">
				            <col width="180">
				            <col width="30">
				            <col width="80">				            
				            <col width="*">
				        </colgroup>
			        	<tbody>
			        		<tr>
			        			<th>Name</th>
			        			<td>
			        				<input type="text" name="name" style="width:175px;" class="input2" value=""  readonly>
			        			</td>
			        			<th>ATD/ETD</th>
			        			<td>
			        				<input type="text" name="atd" style="width:80px;" class="input2" value=""  readonly><!--
			        				--><input type="text" name="atd_time" style="width:45px;" class="input2" value=""  readonly>
			        			</td>
			        			<th>ETA</th>
			        			<td>
			        				<input type="text" name="eta" style="width:80px;" class="input2" value=""  readonly><!--
			        				--><input type="text" name="eta_time" style="width:45px;" class="input2" value=""  readonly>
			        			</td>
			        			<td></td>	        			
			        		</tr>			        		
			        	</tbody>
					</table>
				</td>
			</tr>			
			<tr>
       			<td><table class="line_bluedot"><tr><td colspan="8"></td></tr></table></td>
			</tr>
			<tr>
				<td>
					<table>
						<colgroup>
				            <col width="80">
				            <col width="203">
				            <col width="80">
				            <col width="205">				            				            
				            <col width="*">
				        </colgroup>
			        	<tbody>
			        		<tr>
			        			<th>MI Transmit</th>
			        			<td>
			        				<input type="text" name="mi_transmit" style="width:80px;" class="input2"  value=""  readonly><!--
			        				--><input type="text" name="mi_transmit_time" style="width:45px;" class="input2" value=""  readonly>
			        			</td>
			        			<th>HI Transmit</th>
			        			<td>
			        				<input type="text" name="hi_transmit" style="width:80px;" class="input2"  value=""  readonly><!--
			        				--><input type="text" name="hi_transmit_time" style="width:45px;" class="input2" value=""  readonly><!--
									--><input type="text" name="snd_usr_id" style="width:80px;" class="input2"  value=""  readonly>
			        			</td>			        				        			
			        			<td></td>
			        		</tr>
			        	</tbody>
					</table>
				</td>
			</tr>			
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" style="display:none">			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) --> 
</div>
</form>    
