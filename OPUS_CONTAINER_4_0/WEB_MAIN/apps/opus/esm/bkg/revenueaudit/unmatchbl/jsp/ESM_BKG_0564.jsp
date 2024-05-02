<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_0564.jsp
*@FileTitle : Mismatch B/L Status Report
*@author : CLT
*@version : 1.0
*@since : 2014.04.24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0564Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmBkg0564Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    String[] rhqs = null;
    String[] contractTypes = null;
    String[] ratingTypes = null;
    
	Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0564Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Rating Type 
        ratingTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ratingType"), false , "|", "\t", "getCode", "getName");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
    var ratingTypeComboValue = "|<%=ratingTypes[0]%>";
    var ratingTypeComboText = "|<%=ratingTypes[1]%>";

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
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	    --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--  
	    --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>	    
   </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->

<div class="wrap_search">
<div class="opus_design_inquiry wFit">		
		<table>
			<colgroup>
		  		<col width="90px"></col>
		  		<col width="170px"></col>
		  		<col width="85px"></col>
		  		<col width="170px"></col>
		  		<col width="130px"></col>
		  		<col width="*"></col>
		  	</colgroup> 			
			<tbody>
			<tr>
				<th>RHQ</th>
				<td><script type="text/javascript"> ComComboObject('rct_rhq_cd', 1, 110, 0, 0, 0, false);</script></td>
				<th>Office</th>
				<td><script type="text/javascript"> ComComboObject('bkg_ofc_cd', 1, 110, 0, 0, 0, false);</script></td>
				<th>Audit Date(Initial)</th>
				<td>
					<nobr>
						<input name="rt_aply_dt_from" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="From Date" maxlength="10" dataformat="ymd"><!--
						--><button type="button" class="calendar" name="btns_calendar1" id="btns_calendar1"></button>
						~
						<input name="rt_aply_dt_to" type="text" style="width:75px;text-align:center;"  value="" class="input1" caption="To Date" maxlength="10" dataformat="ymd"><!--
                        --><button type="button" class="calendar" name="btns_calendar2" id="btns_calendar2"></button>
					</nobr>
				</td>
			</tr> 
			<tr>
				<th>Contract Type</th>
				<td><script type="text/javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 110, 0, 0, 0, false);</script></td>
				<th>Rating Type</th>
				<td><script type="text/javascript"> ComComboObject('auto_rat_flg', 1, 110, 0, 0, 0, false);</script></td>
			</tr> 
			</tbody>
		</table>
</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
		
<div class="wrap_result">
<div class="opus_design_grid">		
	<!-- Hidden sheet for Transaction (S) -->
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	<!-- Hidden sheet for Transaction (E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- 시트영역 -->

</form>