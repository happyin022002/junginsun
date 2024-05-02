<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0122.jsp
*@FileTitle  : MOT Surcharge Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0122Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>



<%
	EsmPri0122Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			//에러메세지
	int rowCount	 			= 0;			//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id 			= "";
	String strUsr_nm 			= "";
	String strUsr_ofc 			= "";
	String strUsrSrepCd 		= "";
	
	String[] currCd 			= null;			//CURRENCY 
	String[] chgCd 			    = null;			//CHARGE
	String[] socFlg 			= null;
	String[] cgoTpCd 			= null;
	String[] cntrTpCd 			= null;
	String[] laneCd 			= null;
	String[] payTermCd 			= null;
	
	Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();


		event = (EsmPri0122Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		currCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
		chgCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHG_CD"));
		
		socFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("SOC_FLG"), false,"|","\t","getCode","getName");
		cgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("CGO_TP_CD"), true,"|","\t","getCode","getName");
		cntrTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("CNTR_TP_CD"), true,"|","\t","getCode","getName");
		laneCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("LANE_CD"), true,"|","\t","getCode","getName");
		payTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("PAY_TERM_CD"), false,"|","\t","getCode","getName");



	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

	var currCdValue = " |<%=currCd[0]%>";
	var currCdText = " |<%=currCd[1]%>"; 
	var chgCdComboValue = " |<%=chgCd[0]%>";
    var chgCdComboText = " |<%=chgCd[1]%>";
    var socFlgValue = " |<%=socFlg[0]%>";
    var socFlgText = " |<%=socFlg[1]%>";
    var cgoTpCdValue = " |<%=cgoTpCd[0]%>";
    var cgoTpCdText = " |<%=cgoTpCd[1]%>";
    var cntrTpCdValue = " |<%=cntrTpCd[0]%>";
    var cntrTpCdText = " |<%=cntrTpCd[1]%>";
    var laneCdValue = " |<%=laneCd[0]%>";
    var laneCdText = " |<%=laneCd[1]%>";
    var payTermCdValue = " |<%=payTermCd[0]%>";
    var payTermCdText = " |<%=payTermCd[1]%>";


	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="strusr_id" name="strusr_id" value="<%=strUsr_id %>">
<input type="hidden" id="cfm_flg" name="cfm_flg" >

    
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button class="btn_accent"  type="button" 	id="btn_retrieve"		name="btn_retrieve"		>Retrieve</button><!-- -->
		<button class="btn_normal"  type="button" 	id="btn_new"			name="btn_new"		>New</button><!-- -->
		<button class="btn_normal"  type="button" 	id="btn_save"			name="btn_save"			>Save</button>
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
    
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
             <colgroup>
                <col width="60"  />
                <col width="400" />
                <col width="100"  />
                <col width="130" />
                <col width="*" />
            </colgroup> 
            <tbody>
                <tr>
                    <th>Charge</th>
                    <td><script type="text/javascript">ComComboObject('chg_cd', 2, 60, 0, 1, 0, false);</script><input name="chg_nm" id="chg_nm" type="text" style="width:398px;" class="input2" value="" readonly caption="Charge"></td>
                    <th>Access Date</th>
                    <td>
                    	<input  dataformat="ymd" class="input" 		type="text" 	id="acc_dt" 		name="acc_dt" 			  maxlength="10" style="width: 80px; text-align: center;" caption="Access Date"><!-- -->
                    	<button class="calendar ir" type="button" 	id="btns_calendar1" name="btns_calendar1" ></button>
                    </td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal"  id="btn_copy" name="btn_copy"	>Row Copy</button><!-- -->
			<button type="button" class="btn_normal"  id="btn_add" 	name="btn_add"	>Row Add</button><!-- -->
			<button type="button" class="btn_normal"  id="btn_del" 	name="btn_del"	>Delete</button>
        </div>
        <!-- opus_design_btn(E) -->
        
        <script type="text/javascript">ComSheetObject('sheet1');</script>

    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>