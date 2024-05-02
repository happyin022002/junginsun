<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0120.jsp
*@FileTitle : MNR PFMC by VNDR/Manufacturer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	
	Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="curr_cd">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd%>">
<!-- Developer's task	-->

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button>
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

<div class="wrap_search">
	<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="112px" />
			<col width="380px" />
			<col width="20px" />
			<col width="20px" />
			<col width="20px" />			
			<col width="" />
		</colgroup> 
		<tbody>
			<tr class="h23">
				<th>Period</th>
				<td>
					<script language="javascript">ComComboObject('report_period_type',2, 100 , 1,1)</script> 
						<input required type="text" name="fm_dt" id="fm_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="to_dt" value="" class="input1">   
                              	~ <input required type="text" name="to_dt" id="to_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="fm_dt" class="input1"><!--  
                              	--><button type="button" class="calendar ir" name="btn_calendar"></button>
				</td>
				<th>Service Provider</th>
				<td>
					<input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:57;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!--  
                    --><button type="button" class="input_seach_btn" name="btn_provider_popup"></button><input type="text" name="vndr_lgl_eng_nm" caption="Service Provider" style="width:200;" class="input2" value="" readonly>
				</td>
				<th>USD Only&nbsp;</th>
				<td>
					<input name="check_usd_only" type="checkbox" class="trans">
				</td>
			</tr>
			<tr class="h23">
				<th>EQ Type</th>
				<td>
					<!-- <script language="javascript">ComComboObject("eq_type",2, 100, 1, 0, 2,false,1);</script> -->
					<script language="javascript">ComComboObject("eq_type",2, 100, 1, 0);</script>
				</td>
				<th>TP/SZ</th>
				<td>
					<script language="javascript">ComComboObject('tp_sz_cd', 2, 100 ,0);</script>
				</td>				
			</tr>
		</table>
		<table>
		<colgroup>
			<col width="100px" />
			<col width="399px" />
			<col width="20px" />
			<col width="128px" />
			<col width="20px" />
			<col width="120px" />
			<col width="20px" />			
			<col width="" />
		</colgroup>			
				<tr class="h23">
					<th>FQA Creation Date</th>
				<td>
					<input  type="text" name="fqa_fm_dt" id="fqa_fm_dt" dataformat="ymd"  maxlength="10"  size="11"  cofield="fqa_to_dt" value="" class="input">  
                              	~ <input  type="text" name="fqa_to_dt" id="fqa_to_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="fqa_fm_dt" class="input"><!--  
                    --><button type="button" class="calendar ir" name="btn_calendar1"></button>
				</td>
				
				<th>Regional HQ</th>
				<td>
					<script language="javascript">ComComboObject('rhq',2, 100, 0, 0);</script>
				</td>
				<th>Office</th>
				<td>
					<script language="javascript">ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script>
				</td>
				<th>Yard</th>
				<td>
					<input type="text" style="width:60px;" class="input" name="yd_cd" value=""  fullfill type="text"  dataformat="engup" maxlength="7"><!--  
                    --><button type="button" class="input_seach_btn" name="btn_yd" id="btn_popup"></button>
				</td>
				</tr>
		</tbody>
	</table>
</div>
<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
				
			<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				<script language="javascript">ComSheetObject('sheet1');</script>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	<!-- opus_design_grid(E) -->
			</div>
		
		<!--biz page (E)-->
<!-- Developer's task	-->
</form>