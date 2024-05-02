<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_3009.jsp
*@FileTitle  : Office Transfer History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeOfficeTransferMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();
		//if(strRhq_ofc_cd.equals("SELHO")) strRhq_ofc_cd = "SHAAS";

		event = (EesDmt3009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_ofc_cd"	value="<%=strUsr_ofc%>">
<input type="hidden" name="rhq_ofc_cd"	value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="fm_ofc_cd">
<input type="hidden" name="to_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="fm_rhq"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="to_rhq"		value="<%=strRhq_ofc_cd%>">


	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_ByBKG" id="btn_ByBKG">by BKG</button><!--
			--><button type="button" class="btn_normal" name="btn_ByCNTR" id="btn_ByCNTR">by CNTR</button><!--		
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
	<!--Page Title, Historical (E)-->
	
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="70px" />
		            <col width="70px" />
		            <col width="225px" />
		            <col width="70px" />
		            <col width="146px" />
		            <col width="80px" />
		            <col width="150px" />
		            <col width="60px" />
		            <col width="130px" />
		            <col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><input type="radio" name="cond_type" id="cond_type1" value="date" class="trans" checked OnClick="condType_click()"><strong>&nbsp;&nbsp;&nbsp;DATE</strong></td>

						<th>O/T Date</th>
						<td>
							<input type="text" name="fm_cre_dt" dataformat="ymd"  caption="O/T From Date" style="width:80px;" class="input1">~&nbsp;<!--
							--><input type="text" name="to_cre_dt" dataformat="ymd"  caption="O/T To Date"   style="width:80px;" class="input1"><!--						
							--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
						</td>
						<th>From Office</th>
						<td>
							<script type="text/javascript">ComComboObject('fm_ofc', 1, 70, 0, 0, 0, true);</script>
						</td>
						<th>To Office</th>
						<td>
							<script type="text/javascript">ComComboObject('to_ofc', 1, 70, 0, 0, 0, true);</script>
						</td>
						<th>Tariff</th>
						<td>
							<script type="text/javascript">ComComboObject('tariff_type', 2, 70, 1, 0);</script><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch" id="btns_multisearch"></button>					
						</td>
						<td>						
						</td>
					</tr>
					<tr>
						<td><input type="radio" name="cond_type" id="cond_type2" value="cntr" class="trans" checked OnClick="condType_click()"><strong>&nbsp;&nbsp;&nbsp;CNTR</strong></td>

						<th>BKG No.</th>
						<td>
							<input type="text" name="bkg_no" dataformat="engup" style="width:100px;" class="input"><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch1" id="btns_multisearch1" onClick="doProcessPopup('m_bkg_no')"></button>						
						</td>
						<th>B/L No.</th>
						<td>
							<input type="text" name="bl_no" dataformat="engup" style="width:110px;" class="input"><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch2" id="btns_multisearch2" onClick="doProcessPopup('m_bl_no')"></button>
						</td>
						<th>CNTR No.</th>
						<td colspan="3">
							<input type="text" name="cntr_no" dataformat="engup" style="width:110px;" class="input"><!--
							--><button type="button" class="multiple_inq" name="btns_multisearch3" id="btns_multisearch3" onClick="doProcessPopup('m_cntr_no')"></button>											
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- wrap_search(E) -->
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->

</form>