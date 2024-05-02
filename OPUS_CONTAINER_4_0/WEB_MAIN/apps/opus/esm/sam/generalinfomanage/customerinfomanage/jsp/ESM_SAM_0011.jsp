<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0011.jsp
*@FileTitle  : Customer Performance Group Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSam0011Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수

    String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

        event = (EsmSam0011Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<head>
<title>Customer Performance Group Code Inquiry</title>


<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }    
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" id="ibflag" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_DownExcel_up" id="btn_DownExcel_up" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Direct D/L</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="130" />				
				<col width="80" />				
				<col width="130" />				
				<col width="80" />				
				<col width="130" />				
				<col width=90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Group Name</th>
					<td><input type="text" style="width:130px;ime-mode:disabled;text-align:left" class="input" name="cust_grp_nm" dataformat="excepthan" maxlength="50" id="cust_grp_nm" /></td>
					<th>Match Rule</th>
					<td><!-- 
					--><select name="match_rule" id="match_rule" style="width:110px;" ><!-- 
						--><option value="I" >Include</option><!-- 
						--><option value="A">Exact</option><!-- 
						--><option value="D">Start With</option><!-- 
					--></select><!-- 
					--></td>
					<th>Group Code</th>
					<td><input type="text" name="cust_grp_id" style="width:150px;text-align:center;ime-mode:disabled" value="" dataformat="excepthan" maxlength="20" id="cust_grp_id" otherchar="-" /></td>
					<th>Abbreviation</th>
					<td><input type="text" style="width:130px;ime-mode:disabled;text-align:center" class="input" name="cust_grp_abbr_nm" dataformat="engup" maxlength="20" id="cust_grp_abbr_nm" otherchar=" &amp;-,." /></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_DownExcel_down" id="btn_DownExcel_down" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>			
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>