<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0036.jsp
*@FileTitle  : FF Compensation CSR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.event.EsmAcm0036Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0036Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String aproStep = "";
  String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMRequest.AGNCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0036Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    aproStep =  com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd,"ACM");
    inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd".trim(), "");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="aproSeqKey" id="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd)%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_calculate" id="btn_calculate">Calculate</button><!-- 
	 --></div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_grid wFit">
		<table>
			<tr>
	            <th width="50">Office</th>
	            <td width="80"> <select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:75px;" tabindex="1"></select></td>
	            <th width="80">Sub Office</th>
	            <td width="80"><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:75px;" tabindex="2"></select></td>
                <th width="70">BKG No.</th>
                <td width="135" height="24" id="memo_sheet1_td"><div id="memo_sheet1_div">
                	<script type="text/javascript">ComSheetObject("memo_sheet1");</script></div>
                </td>
                <td width="120"><button type="button" class="btn_etc" name="btn2_bkg_no" id="btn2_bkg_no" >Multi BKG_NO</button></td>
             	<th width="80">Calculate Condition</th>
             	<td width="5"></td>
             	<td>
                   	<input type="checkbox" checked value="Y" name="chk_comm_cmpn" id="chk_comm_cmpn"><label for ="chk_comm_cmpn">Agent Comm & Special Comp.</label><!-- 
                   --><input type="checkbox" value="Y" name="chk_fac" id="chk_fac"><label for ="chk_fac">FAC</label><!-- 
                   --><input type="checkbox" value="Y" name="chk_cmpn" id="chk_cmpn"><label for ="chk_cmpn">F/F Comp.</label><!-- 
                   --><input type="checkbox" value="Y" name="chk_all" id="chk_all"><label for ="chk_all">All</label>
            	</td>
           	</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<h3 class="title_design">Booking List</h3>
	<div class="opus_design_grid clear"  >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<h3 class="title_design">Calculation Result</h3>
	<div class="opus_design_grid clear"  >
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>