<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0008.jsp
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
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.event.EsmAcm0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0008Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
    event = (EsmAcm0008Event)request.getAttribute("Event");
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


<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="vvd_cd" id="vvd_cd" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<input type="hidden" name="bkg_no_array" id="bkg_no_array" />
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
		--><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">Detail</button><!-- 
		--><button type="button" class="btn_normal" name="btn_audit" id="btn_audit">Audit</button><!-- 
		--><button type="button" class="btn_normal" name="btn_reject" id="btn_reject">Request Reject</button><!-- 
		--><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Audit Cancel</button><!-- 
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
<div class="wrap_search">
	<div class= "opus_design_inquiry wFit ">
	<table>
			<colgroup>
				<col width="80px"/>
				<col width="80px"/>
				<col width="80px" />
				<col width="100px" />
				<col width="80px"/>
				<col width="160px"/>
				<col width="150px"/>
				<col width="70px" />
				<col width="*" />

			</colgroup>
		<tbody>
			 <tr>
                 <th>Office</th>
                 <td>
                 	<select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:75px;" tabindex="1"></select>
				 </td>
                 <th>Sub Office</th>
                 <td>
                 	<select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:75px;" tabindex="2"></select>
                 </td>
                 <th>Commission Status</th>
                 <td colspan="2"><%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:135px;'", "CD03039", 0, "")%></td>
                 <th>Date</th>
                 <td>
                   <%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:150px;'", "CD03025", 0, "")%><!--
                    --><input name="date_fm" type="text" dataformat="ymd" maxlength="8" required="" caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5" id="date_fm" /> ~ <!-- 
                    --><input name="date_to" type="text" dataformat="ymd" maxlength="8" required="" caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6" id="date_to" /><!-- 
                    --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
                  </td>
               </tr>
    		   <tr>
     				<th title="Vessel Voyage Direction">VVD</th>

                    <!-- Memo Sheet (S) -->
                     <td colspan="2" id="memo_sheet1_td">
                       <div id="memo_sheet1_div">
                             <script type="text/javascript">ComSheetObject("memo_sheet1");</script>
                       </div>
                     </td>
                     <td>
						<button type="button" class="btn_etc" name="btn2_vvd_cd" id="btn2_vvd_cd" >Multi VVD</button>
					</td>
                            <!-- Memo Sheet (E) -->
                     <th>B/L No</th>
                            <!-- Memo Sheet (S) -->

                     <td id="memo_sheet2_td" style="width:135px;" >
                              <div id="memo_sheet2_div">
                                    <script type="text/javascript">ComSheetObject("memo_sheet2");</script>
                              </div>
                     </td>
                     <td><button type="button" class="btn_etc" name="btn2_bl_no" id="btn2_bl_no" >Multi B/L No</button></td>
                            <!-- Memo Sheet (E) -->
							
                     <th>Audit No</th>
		             <td>
		                      <input name="aud_no" type="text" dataformat="engup" maxlength="20" style="width:100px;" tabindex="7" id="aud_no" />
		             </td>
                </tr>
                <tr>
                     <th>Select</th>
                     <td colspan="7">
                              <input name="slct_start"  type="text" dataformat="num" maxlength="5" style="width:40px;" tabindex="9" id="slct_start" />~<!-- 
                              --> <input name="slct_end"    type="text" dataformat="num" maxlength="5" style="width:40px;" tabindex="10" id="slct_end" /><!-- 
		                      --><button type="button" class="btn_etc" name="btn2_check" id="btn2_check" >Check</button><!-- 
		                      --><button type="button" class="btn_etc" name="btn2_uncheck" id="btn2_uncheck" >Uncheck</button>
                      </td>
                    
                             
                </tr>
</table>
</div>
</div>
<div class="wrap_result">
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" >
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
</form>
