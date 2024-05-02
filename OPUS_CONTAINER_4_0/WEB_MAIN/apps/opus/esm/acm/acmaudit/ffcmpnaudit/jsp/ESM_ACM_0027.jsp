<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0027.jsp
*@FileTitle  : FF Compensation Audit
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
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.event.EsmAcm0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0027Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
    event = (EsmAcm0027Event)request.getAttribute("Event");
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
  // 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("ofcChr", "", "CD03015", 0, "")%>
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("xchRtDivLvl", "", "CD03020", 0, "")%>
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

<input name="ofc_cd" type="hidden"  id="ofc_cd"  value="<%=strOfc_cd%>"/>
<input name="aud_no" type="hidden" id="aud_no" />
<input name="vvd_cd" type="hidden" id="vvd_cd" />
<input name="bl_no" type="hidden" id="bl_no" />
<input type="hidden" name="h_csrNo" id="h_csrNo" />
<input type="hidden" name="aproSeqKey" id="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>" />
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
		  --><button type="button" class="btn_normal" name="btn_re_calculate" id="btn_re_calculate">Re-Calculate</button><!--  
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
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="45">
				<col width="165">
				<col width="230">
				<col width="290">
				<col width="30">
				<col width="*">
			</colgroup>
			    <tr>
			    	 <th>Office</th>
			    	 <td><script type="text/javascript">ComComboObject('f_ap_ofc_cd',1, 100 , 0 )</script></td>
                     <td><input type="radio" name="date_option" id="date_option" class="trans" value="E" checked>&nbsp;&nbsp;<b>ETD</b>&nbsp;&nbsp;&nbsp;&nbsp;<!--
                     --><input type="radio" name="date_option" id="date_option" class="trans" value="C">&nbsp;&nbsp;<b>BKG Creation</b>&nbsp;&nbsp;&nbsp;&nbsp;<!--
                     --><input type="radio" name="date_option" id="date_option" value="I" class="trans">&nbsp;&nbsp;<b>Interface</b></td>
                     <td><input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:80px;" tabindex="5">~ <!--
                     --><input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:80px;" tabindex="6"><!--
                     --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
          			 <th>Interface Option</th>
          			 <td><%=JSPUtil.getCodeCombo("if_opt", "", "tabindex='4' style='width:110px;'", "CD03055", 1, "")%>&nbsp;</td>
          			 <td></td>
                 </tr>
           </tbody>
        </table>
      	<table>
			<tbody>
                 <tr>
                     <th width="40" title="Vessel Voyage Direction">VVD</th>
                     <!-- Memo Sheet (S) -->
                     <td width="150" id="memo_sheet1_td">
                     <div id="memo_sheet1_div">
                     	<script type="text/javascript">ComSheetObject("memo_sheet1");</script>
                     </div>
					</td>
					<td width="80">
						<button type="button" class="btn_etc" name="btn2_vvd_cd" id="btn2_vvd_cd" >Multi VVD</button>
					</td>
                     <th width="170">Freight Forwarder</th>
                     <td width="101"><input type="text" name="search_brog_cnt_cust_seq" id="search_brog_cnt_cust_seq" style="width:100px;ime-mode:disabled;" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><!--
                     --><input type="hidden" name="search_brog_cnt_cust_seqName" id="search_brog_cnt_cust_seqName"><!--
                     --><button type="button" id="btn_popup" name="btn_popup" class="input_seach_btn"></button></td>
                     <th width="100">B/L No</th>
                     <!-- Memo Sheet (S) -->
                     <td width="150" id="memo_sheet2_td">
                     	<div id="memo_sheet2_div">
                     		<script type="text/javascript">ComSheetObject("memo_sheet2");</script>
                     	</div>
                     </td>
                     <td>
                     	<button type="button" class="btn_etc" name="btn2_bl_no" id="btn2_bl_no" >Multi B/L No</button>
                     </td>
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