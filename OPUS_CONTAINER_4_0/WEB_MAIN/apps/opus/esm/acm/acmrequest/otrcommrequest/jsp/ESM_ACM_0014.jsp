<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_ACM_0014.jsp
*@FileTitle  : Other Commission Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.event.EsmAcm0014Event"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0014Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";
  String yyyyMMDD = JSPUtil.getKST("yyyy-MM-dd");
  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMRequest.OTRCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();

    event = (EsmAcm0014Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
  // 공통코드 combo string 추출
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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>" id="ofc_cd" />
<!-- 개발자 작업 -->

<input type="hidden" name="hid_add_row" id="hid_add_row" />
<input type="hidden" name="frm_vndr_seq" id="frm_vndr_seq" />
<input type="hidden" name="frm_vndr_lgl_eng_nm" id="frm_vndr_lgl_eng_nm" />
<input type="hidden" name="frm_ar_ofc_cd" id="frm_ar_ofc_cd" />
<input type="hidden" name="frm_ac_occr_info_cd" id="frm_ac_occr_info_cd" />
<input type="hidden" name="frm_ap_ctr_cd" id="frm_ap_ctr_cd" />
<input type="hidden" name="frm_curr_cd" id="frm_curr_cd" />
<input type="hidden" name="frm_aply_dt" id="frm_aply_dt" />
<input type="hidden" name="hid_vndr_seq" id="hid_vndr_seq" />
<input type="hidden" name="hid_ac_occr_info_cd" id="hid_ac_occr_info_cd" />
<input type="hidden" name="hid_curr_cd" id="hid_curr_cd" />
<input type="hidden" name="hid_ap_ctr_cd" id="hid_ap_ctr_cd" />
<input type="hidden" name="hid_pay_xch_rt" id="hid_pay_xch_rt" />
<input type="hidden" name="to_date" value="<%=yyyyMMDD%>" id="to_date" />
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
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button><!-- 
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
				<col width="30"/>
				<col width="145"/>
				<col width="50"/>
				<col width="145"/>
				<col width="50"/>
				<col width="*" />
			</colgroup>
			<tr>
                <th>Office</th>
                 <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:85px;" tabindex="1"></select></td>
                 <th>Sub Office</th>
                 <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:85px;" tabindex="2"></select></td>
                 <th>Subject Month</th>
                  <td><input name="comm_yrmon" id="comm_yrmon" type="text" dataformat="ym" maxlength="6" required caption="Subject Month" class="input1" style="width:55px;" tabindex="3"></td>
              </tr>
		</tbody>		
	</table>
</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable" >
		<div class="opus_design_btn">		
				<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>