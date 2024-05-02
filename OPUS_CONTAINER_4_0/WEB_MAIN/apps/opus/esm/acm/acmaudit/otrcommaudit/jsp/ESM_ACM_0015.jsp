<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_ACM_0015.jsp
*@FileTitle  : Other Commission Audit
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
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.otrcommaudit.event.EsmAcm0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0015Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
  Logger log = Logger.getLogger("com.clt.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0015Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	aproStep =  com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd,"ACM");
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script type="text/javascript">
  // 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("ofcChr", "", "CD03015", 0, "")%>
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("xchRtDivLvl", "", "CD03020", 0, "")%>
<%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: :ALL")%>

  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->

<input name="ofc_cd" type="hidden" value="<%=strOfc_cd%>" id="ofc_cd" />
<input name="aud_no" type="hidden" id="aud_no" />
<input name="vvd_cd" type="hidden" id="vvd_cd" />
<input name="bl_no" type="hidden" id="bl_no" />
<input type="hidden" name="h_csrNo" id="h_csrNo" />
<input type="hidden" name="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>" id="aproSeqKey" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="bkg_no_array" id="bkg_no_array" />
<input type="hidden" name="doAction" id="doAction" value="" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_audit" id="btn_audit">Audit</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reject" id="btn_reject">Reject</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_audit_cancel" id="btn_audit_cancel">Audit Cancel</button><!-- 
		   --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="60"/>
					<col width="120"/>
					<col width="50"/>
					<col width="120"/>
					<col width="50"/>
					<col width="160"/>
					<col width="80"/>
					<col width="*" />
				</colgroup>
					<tr>
	                    <th>Office</th>
	                    <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:80px;" tabindex="1"></select></td>
	                    <th>Sub Office</th>
	                    <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:80px;" tabindex="2"></select></td>
	                    <th>Status</th>
	                    <td><%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:135px;'", "CD03027", 0, "")%></td>
	                    <th>Subject Month</th>
	                    <td><input name="comm_yrmon" id="comm_yrmon" type="text" dataformat="ym" maxlength="6" required caption="Subject Month" class="input1" style="width:55px;" tabindex="3"></td>
	                 </tr>
			</tbody>		
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear"  >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
