<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0102.jsp
*@FileTitle  : Container TP/SZ Grouping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsetup.acmsetup.event.EsmAcm0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0002Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMSetup.ACMSetup");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0002Event)request.getAttribute("Event");
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

<script type="text/javascript">
  var sFunc = '<%=JSPUtil.getParameter(request, "func")%>';
  var iSheetIdx = '<%=JSPUtil.getParameter(request, "sheetIdx")%>';
  var iRow = '<%=JSPUtil.getParameter(request, "row")%>';
  var iCol = '<%=JSPUtil.getParameter(request, "col")%>';


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
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Container TP/SZ Selection</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_clear" id="btn_clear">Clear</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_select"  	id="btn_select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>	
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
            	<tr>
                	<th><input type="radio" class="trans" name="grp_idv_div" id="grp_idv_div" onclick="processButtonClick();" /><label for="grp_idv_div" style="color: #532fc3" onclick="processButtonClick();">By Container Group</label></th>
                	<td></td>
              	</tr>
            </table>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="gray_tit mar_btm_8">User Set List</h3>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
            	<tr>
                	<th><input type="radio" class="trans" name="grp_idv_div" id="grp_idv_div_1" onclick="processButtonClick();"/><label for="grp_idv_div_1" onclick="processButtonClick();" style="color: #532fc3">By Individual TP/SZ</label></th>
                	<td></td>
              	</tr>
            </table>
            <table  class="mar_btm_8 mar_top_12">
            	<colgroup>
            		<col width="90">
            		<col width="*">
            	</colgroup>
            	<tr>
                	<th>Selected TP/SZ</th>
                	<td></td>
              	</tr>
             </table>
             <table>
              	<tr>
                	<td><textarea name="slct_tpsz" id="slct_tpsz" style="width:100%; height:34px; resize: none;" class="input2" readonly><%=JSPUtil.getParameter(request, "cntr_tpsz_cd")%></textarea></td>
              	</tr>
            </table>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="gray_tit mar_btm_12 mar_top_12">Container TP/SZ Code</h3>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
<!-- 개발자 작업 끝 -->
</form>