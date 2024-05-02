<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0028.jsp
*@FileTitle  : Agent Commission Audit
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
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.facommaudit.event.EsmAcm0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0028Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0028Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업 -->


<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd%>"/>
<input type="hidden" name="vvd_cd" id="vvd_cd" />
<input type="hidden" name="bl_no" id="bl_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_calculate" id="btn_re_calculate">Re-Calculate</button><!--  
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
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
			<colgroup>
				<col width="50"/>
				<col width="100"/>
				<col width="140"/>
				<col width="50"/>
				<col width="50"/>
				<col width="100"/>
				<col width="74"/>
				<col width="*"/>
			</colgroup>
	 		 <tr>
               	<th><input type="radio" name="ofc_option" id="ofc_option" value="A" class="trans" checked="" id="ofc_option" /> AR Office</th>
				<th><input type="radio" name="ofc_option" id="ofc_option" class="trans" value="S" id="ofc_option" /> Sales Office</th>
				<td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:75px;" tabindex="1"></select></td>
				<th><input type="radio" name="date_div" id="date_div" class="trans" value="C" checked>BKG Creation</th>
                <th><input type="radio" name="date_div" id="date_div" class="trans" value="E">ETD</th>
                <td><input name="date_fm" id="date_fm" type="text" dataformat="ymd" required caption="From Date" cofield="date_to" class="input1" style="width:80px;" tabindex="5">~ <!-- 
                --><input name="date_to" id="date_to" type="text" dataformat="ymd" required caption="To Date" cofield="date_fm" class="input1" style="width:80px;" tabindex="6"><!--
          	 	--><button type="button" class="calendar"  name="btn_calendar" id="btn_calendar"></button><!-- 
                --></td>
               	<th>Cur</th>
               	<td>
                	<select name="curr_cd" id="curr_cd" style="width: 60px;">
						<option value="" selected>All</option>
						<option value="USD">USD</option>
						<option value="EUR">EUR</option>
				 	</select>
			     </td>
			</tr>
			</tbody>
   		</table>
					
		<table>
		<tbody>
		    <colgroup>
				<col width="40"/>
				<col width="134"/>
				<col width="60"/>
				<col width="202"/>
				<col width="100"/>
				<col width="170"/>
				<col width="134"/>
				<col width="*"/>
			</colgroup>
			<tr>	
	  			<th title="Vessel Voyage Direction">VVD</th>
	            <td id="memo_sheet1_td"><div id="memo_sheet1_div"><script type="text/javascript">ComSheetObject("memo_sheet1");</script></div></td>
	            <td><button type="button" class="btn_etc" name="btn2_vvd_cd"  id="btn2_vvd_cd">Multi VVD</button></td>
				<th>F/Forwarder</th>
				<td><input type="text" name="ff_cnt_seq" id="ff_cnt_seq" dataformat="engup" style="width: 80px; ime-mode: disabled;" maxlength="8" id="ff_cnt_seq" /><button type="button" id="btn_forwarder" name="btn_forwarder" class="input_seach_btn"></button></td>
	            <th>B/L No</th>
	            <td id="memo_sheet2_td"><div id="memo_sheet2_div"><script type="text/javascript">ComSheetObject("memo_sheet2");</script></div></td>
	            <td><button class="btn_etc" type="button" id="btn2_bl_no"  	name="btn2_bl_no" >Multi B/L No</button></td>
	       </tr>
	       
		</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear">
<!-- 		<div class="opus_design_btn"> -->
<!-- 		<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Row Copy</button> -->
<!-- 		</div> -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>