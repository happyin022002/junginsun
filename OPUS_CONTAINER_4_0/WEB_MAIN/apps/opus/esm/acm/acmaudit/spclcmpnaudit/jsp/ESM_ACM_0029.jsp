<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0029.jsp
*@FileTitle  : Special Compensation Audit
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
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.event.EsmAcm0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0029Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMRequest.AGNCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0029Event)request.getAttribute("Event");
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
<!-- 개발자 작업 -->


<input type="hidden" name="vvd_cd" id="vvd_cd"><!-- Multi VVD -->
<input type="hidden" name="bl_no" id="bl_no"><!-- Multi B/L No -->
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
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
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
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
			<colgroup>
				<col width="130">
				<col width="100">
				<col width="85">
				<col width="85">
				<col width="135">
				<col width="103">
				<col width="120">
				<col width="*">
			</colgroup>
				<tr>
                      <th>Office</th>
                      <td><select name="ar_ofc_cd" id="ar_ofc_cd" onchange="frmObj_OnChange()" required caption="Office" class="input1" style="width:75px;" tabindex="1"></select></td>
                      <th title="Vessel Voyage Direction">VVD</th>
                      <td><%=JSPUtil.getCodeCombo("vvd_div", "", "tabindex='4' style='width:75px; font-weight:bold; color:#313131;'", "CD03024", 0, "")%></td>
                       <!-- Memo Sheet (S) -->
                       <td id="memo_sheet1_td">
                         <span id="memo_sheet1_div">
                               <script type="text/javascript">ComSheetObject("memo_sheet1");</script>
                         </span>
                       </td>
                       <!-- Memo Sheet (E) -->
						<td><button type="button" class="btn_etc" name="btn2_vvd_cd" id="btn2_vvd_cd" >Multi VVD</button></td>
						<th>Date</th>
                       	<td><%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:110px;'", "CD03053", 0, "")%><!-- 
                        	 --><input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">~  <!-- 
                        	 --><input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6"><!-- 
                        	 --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
                      </td>
                    </tr>
               </tbody>
		</table>        
	  <table>
		<tbody>
			<colgroup>
				<col width="130">
				<col width="140">
				<col width="130">
				<col width="135">
				<col width="103">
				<col width="120">
				<col width="*">
			</colgroup>
	                <tr>
                      <th>Agreement Customer</th>
                      <td><input type="text" name="spcl_cnt_cust_seq" style="width:100px;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8" tabindex="7"><!-- 
                      	 --><input type="hidden" name="spcl_cnt_cust_seqName" id="spcl_cnt_cust_seqName"><!--
                      	 --><button type="button" name="btn_popup" id="btn_popup" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
                      </td>
                      <th>B/L No</th>
                      <!-- Memo Sheet (S) -->
                      <td id="memo_sheet2_td">
                        <span id="memo_sheet2_div"><script type="text/javascript">ComSheetObject("memo_sheet2");</script></span>
                      </td>
                      <!-- Memo Sheet (E) -->
				      <td><button type="button" class="btn_etc" name="btn2_bl_no" id="btn2_bl_no" >Multi B/L No</button></td>
					  <th>Interface Status</th>
					  <td><%=JSPUtil.getCodeCombo("if_opt", "", "tabindex='10' style='width:110px;'", "CD03055", 0, "")%></td>
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