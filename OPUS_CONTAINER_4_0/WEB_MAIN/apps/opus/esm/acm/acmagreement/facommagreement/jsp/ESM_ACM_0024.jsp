<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0024.jsp
*@FileTitle  : FAC Agreement Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmagreement.facommagreement.event.EsmAcm0024Event"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0024Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String cntCd = "";
  String ofcCd = "";
  String ar_ofc_cd = "LONHQ";
  String modYn = "N";

  String strUsr_id = "";
  String strUsr_nm = "";

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    cntCd = JSPUtil.getNull(account.getCnt_cd());
    ofcCd = JSPUtil.getNull(account.getOfc_cd());
    //strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0024Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }

  //수정가능여부를 설정한다.
  if(ar_ofc_cd.equals(ofcCd)) modYn = "Y";

%>
<script type="text/javascript">
  // 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("proTp", "", "CD00888", 0, "")%>
<%=JSPUtil.getIBCodeCombo("facDivCd", "", "CD00993", 0, "")%>
<%=JSPUtil.getIBCodeCombo("facTp", "", "CD00788", 0, "")%>
<%=JSPUtil.getIBCodeCombo("bkgRcvTermCd", "", "CD00764", 0, "")%>
<%=JSPUtil.getIBCodeCombo("bkgDeTermCd", "", "CD00765", 0, "")%>

  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }

</script>
<div style="height:0px">
<iframe height="0" width="0" name="frmHidden"></iframe></div>
<form name = "hiddenF" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cust_cd" id="cust_cd" />
<input type="hidden" name="sheetId" id="sheetId" />
<input type="hidden" name="row" id="row" />
<input type="hidden" name="colNm1" id="colNm1" />
<input type="hidden" name="colNm2" id="colNm2" />
<input type="hidden" name="newRow" id="newRow" />
<input type="hidden" name="fac_ofc_cd" id="fac_ofc_cd" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->
<input type="hidden" name="rowNum" id="rowNum" />
<input type="hidden" name="colNum" id="colNum" />
<input name="ofc_cd" type="hidden" value="<%=ofcCd%>" id="ofc_cd" />
<input type="hidden" name="cntCd" value="<%=cntCd%>" id="cntCd" />
<input type="hidden" name="ff_cnt_cd" id="ff_cnt_cd" />
<input type="hidden" name="newRow" id="newRow" />
<input type="hidden" name="recipients_eml" id="recipients_eml" />
<input type="hidden" name="recipients_name" id="recipients_name" />
<input type="hidden" name="cnt" id="cnt" />
<input type="hidden" name="mod" value="<%= modYn %>" id="mod" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_request" 	id="btn_request">Request</button><!-- 
		 
		<%
		  if ( ar_ofc_cd.equals(ofcCd) ) {
		  	ar_ofc_cd = "LONHQ";
		%>
				
		--><button type="button" class="btn_normal" name="btn_approve"  id="btn_approve">Approve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_reject" 	id="btn_reject">Reject</button>
         <%
          }
         %>
		 
		 <!-- 
		 --><button type="button" class="btn_normal" name="btn_uploadexcel" id="btn_uploadexcel">Load Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel"	id="btn_downexcel">Down Excel</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="200">
				<col width="40">
				<col width="*">
			</colgroup>
			<tr>
                <th>Office</th>
                <td><select name="ar_ofc_cd" id="ar_ofc_cd" style="width:100px;" caption="Office" class="input1" required ></select></td>
                <th>Status</th>
                <td>
                  <select name="fac_sts_cd" id="fac_sts_cd" style="width:100px;" onChange="javascript:change_sts()" ><!-- 
                   --><OPTION value="">All</OPTION><!-- 
                   --><OPTION value="RS">New</OPTION><!-- 
				   --><OPTION value="RR">Requested</OPTION><!-- 
			       --><OPTION value="RE">Rejected</OPTION><!-- 
			       --><OPTION value="PS">Approved</OPTION><!-- 
				   --></select>
                </td>
              </tr>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_copy"  	id="btn_copy">Row Copy</button><!-- 
		 --></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	
</form>