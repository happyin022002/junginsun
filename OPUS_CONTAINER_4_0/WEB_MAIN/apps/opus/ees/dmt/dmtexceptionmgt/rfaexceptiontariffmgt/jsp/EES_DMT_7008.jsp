<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7008.jsp
*@FileTitle  : Approval Authority Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt7008Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EesDmt7008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	String rhqOfcList = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		rhqOfcList = account.getRhq_ofc_cd();

		event = (EesDmt7008Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//rhqOfcList = OfficeCodeMgr.getOfficeCodeList("000004","COM");//RHQ_OFC_LIST

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
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_id">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=rhqOfcList%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="105" />
            <col width="120" />
            <col width="70" />
            <col width="120" />
            <col width="120" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr>
				<th>Approval Office</th>
				<td>
				<!-- 
					<select name="ar_hd_qtr_ofc_cd" style="width:70;" class="input1">
						<option value="" selected>All</option>
						<%--
								String rhqOfc = "";
								for(int i = 0 ; i < rhqOfcList.size() ; i++) {
									rhqOfc = (String)rhqOfcList.get(i);
							--%>
							<option value="<%--=rhqOfc --%>"><%--=rhqOfc --%></option>
							<%--
								}
							--%>
					</select>
 				-->
 				<script type="text/javascript">ComComboObject('ar_hd_qtr_ofc_cd', 1 ,80 , 0 , 1 , 0, true);</script>					
				</td>			
				<th>User Office</th>
				<td>
					<input type="text" name="ofc_cd" dataformat="engup" maxlength="6" style="width:55;ime-mode:disabled;" class="input" value="" ><!--
					--><button type="button" class="input_seach_btn" onClick="openPopup('ofc_cd')"></button>
				</td>
				<th>User Name </th>
				<td>
					<input type="text" name="usr_nm" maxlength="30" style="width:200;" class="input" value="" ><!--  
					--><button type="button" class="input_seach_btn" onClick="openPopup('usr_nm')"></button>
				</td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!--TAB Before Booking (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('t1sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!--TAB Before Booking (E) --> 

<!--TAB After Booking (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('t2sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!--TAB After Booking (E) -->
<!-- page(E) -->

</form>