<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3006.jsp
*@FileTitle  : Tariff Formula Rule Inquiry 
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
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3006Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//server error
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	
	String[] srchTrfCd = null;		    //TARIFF CODE
	String[] ruleApplChgTpCd = null;	//TYPE
	String[] rtApplTpCd = null;		    //APLICATION
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgUsaSvcModCd = null;    	//US SVC MODE
	String[] bkgRcvTermCd = null;		//RECEIVING TERM
	String[] bkgDeTermCd = null;		//DELIVERY TERM
	
	String trfCd = null;
	
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRINoteConversionProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		trfCd = JSPUtil.getNull(request.getParameter("trf_cd"));
		
		//COMMBO LIST		
		srchTrfCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRCH_TRF_CD"));
		ruleApplChgTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgUsaSvcModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_USA_SVC_MOD_CD"), false);  
        bkgRcvTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RCV_TERM_CD"), false);  
        bkgDeTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DE_TERM_CD"), false);  

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">

	var srchTrfCdComboValue = "<%=srchTrfCd[0]%>";
    var srchTrfCdComboText = "<%=srchTrfCd[1]%>";

    var ruleApplChgTpCdComboValue = " |<%=ruleApplChgTpCd[0]%>";
    var ruleApplChgTpCdComboText = " |<%=ruleApplChgTpCd[1]%>";
 
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgUsaSvcModCdComboValue = " |<%=bkgUsaSvcModCd[0]%>";   
    var bkgUsaSvcModCdComboText = " |<%=bkgUsaSvcModCd[1]%>";
    
    var bkgRcvTermCdComboValue = " |<%=bkgRcvTermCd[0]%>";
    var bkgRcvTermCdComboText = " |<%=bkgRcvTermCd[1]%>";
    
    var bkgDeTermCdComboValue = " |<%=bkgDeTermCd[0]%>";
    var bkgDeTermCdComboText = " |<%=bkgDeTermCd[1]%>";
               
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

<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">
<input type="hidden" name="tri_prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="note_conv_mapg_id">
<input type="hidden" name="cfm_flg">
<input type="hidden" name="cd">
<input type="hidden" name="trf_cd" value="<%=trfCd%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="75" />
            <col width="62" />
            <col width="320" />
            <col width="60" />
            <col width="290" />
            <col width="80" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr class="h23">
				<th>Tariff Code</th>
				<td><script language="javascript">ComComboObject("srch_trf_cd", 2, 100, 0, 1, 0, false);</script></td>
				<td style="padding-bottom:1"><input type="text" name="srch_trf_nm" style="width:293px;" class="input2" value="" readonly></td>
				<th>Duration</th>
				<td>
					<script language="javascript">ComComboObject("note_seq",2, 90, 0, 1,0, true);</script>&nbsp;~&nbsp;
					<input name="eff_dt" type="hidden" value="" class="input1" caption="Effective Date" required="true">
					<input name="eff_dt_hidden" type="hidden" value="" class="input1">
					<input type="text" name="exp_dt" style="width:80;text-align:center;" class="" value="" caption="Expire Date" maxlength="10" dataformat="ymd" >
				</td>
				<th width="80">Confirmation</th>
				<td width="">
					<input name="cfm_flg_nm" type="text" style="width:70;text-align:center;" class="input2" value="" readonly="true" caption="Confirmation">
				</td>
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
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->
 
</form>