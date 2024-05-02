<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0514.js
*@FileTitle  : Vessel Arrival Transmit (HI)
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0514Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0514Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //Error message
	
	String strUsr_id = "";
	String strUsr_nm = "";
	String vvd_cd= "";
	String pod_cd= "";
	String pgmNo = "";
	
	try {
		vvd_cd= request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
		pod_cd= request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		pgmNo = request.getParameter("pgmNo")==null?"":request.getParameter("pgmNo");
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0514Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		//Add logic information data from the server when loading the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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
<input type="hidden" name="form1_vvd_cd" value="<%=StringUtil.xssFilter(vvd_cd)%>">
<input type="hidden" name="form1_pod_cd" value="<%=StringUtil.xssFilter(pod_cd)%>">
<input type="hidden" name="page_no" value="<%=StringUtil.xssFilter(pgmNo)%>">
<input type="hidden" name="transmit_cd" value="HI"> 


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">		
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_TransToUSCS" id="btn_TransToUSCS">Transmit</button>		
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
		<table id="mainTable">  
       		<tr>
	       		<td>
					<table> 
					<colgroup>
                      <col width="40" />
                      <col width="200" />
                      <col width="40" />
                      <col width="200" />
                      <col width="50" />
                      <col width="*" />
                    </colgroup>
					
					<tr>
						<th>VVD</th>
						<td><input type="text" name="vvd" style="width:80px;" class="input1" value="" dataformat="engup" maxlength="9" required caption = "VVD"></td>
						<th>POD</th>
						<td><input type="text" name="pod_cd" style="width:60px;" class="input1" value="" dataformat="engup" maxlength="5" required caption = "POD"></td> 
						<th>B/L Count</th>
						<td><input type="text" name="bl_count" style="width:60px;" class="input" value="" dataformat="int"></td> 
					</tr>
					</table>
					
					<div class="line_bluedot"></div>
					
					<table class="search" border="0"> 
					<colgroup>
					  <col width="40" />
                      <col width="200" />
                      <col width="40" />
                      <col width="*" />

                    </colgroup>
					<tr class="h23">
						<th>Name</th>						
						<td><input type="text" name="name" style="width:150px;" class="input2" value=""  readonly></td>
						<th>ETA</th>
						<td><input type="text" name="eta" style="width:80px;" class="input" value="" dataformat="ymd">&nbsp;<input type="text" name="eta_time" style="width:45px;" class="input" value="" dataformat="hm"></td>
					</tr>
					</table>							
				</td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	    
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script></td>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

	 