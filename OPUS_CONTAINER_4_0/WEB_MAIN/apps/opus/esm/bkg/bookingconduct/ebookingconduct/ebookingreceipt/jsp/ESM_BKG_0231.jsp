<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0231.jsp
*@FileTitle  : e-Booking & SI Process - Copy Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0231Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0231Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	// Main에서 Parameter 받기
	String callFunc = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0231Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		callFunc  = JSPUtil.getParameter(request, "func");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = '<%=strErrMsg%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cust_opus" value="<%=StringUtil.xssFilter(request.getParameter("cust_opus")) %>" id="cust_opus" />
<input type="hidden" name="cust_esvc" value="<%=StringUtil.xssFilter(request.getParameter("cust_esvc")) %>" id="cust_esvc" />
<input type="hidden" name="cntr_opus" value="<%=StringUtil.xssFilter(request.getParameter("cntr_opus")) %>" id="cntr_opus" />
<input type="hidden" name="cntr_esvc" value="<%=StringUtil.xssFilter(request.getParameter("cntr_esvc")) %>" id="cntr_esvc" />
<input type="hidden" name="mnd_opus" value="<%=StringUtil.xssFilter(request.getParameter("mnd_opus")) %>" id="mnd_opus" />
<input type="hidden" name="mnd_esvc" value="<%=StringUtil.xssFilter(request.getParameter("mnd_esvc")) %>" id="mnd_esvc" />
<input type="hidden" name="cm_opus" value="<%=StringUtil.xssFilter(request.getParameter("cm_opus")) %>" id="cm_opus" />
<input type="hidden" name="cm_esvc" value="<%=StringUtil.xssFilter(request.getParameter("cm_esvc")) %>" id="cm_esvc" />
<input type="hidden" name="tro_opus" value="<%=StringUtil.xssFilter(request.getParameter("tro_opus")) %>" id="tro_opus" />
<input type="hidden" name="tro_esvc" value="<%=StringUtil.xssFilter(request.getParameter("tro_esvc")) %>" id="tro_esvc" />
<input type="hidden" name="rf_opus" value="<%=StringUtil.xssFilter(request.getParameter("rf_opus")) %>" id="rf_opus" />
<input type="hidden" name="rf_esvc" value="<%=StringUtil.xssFilter(request.getParameter("rf_esvc")) %>" id="rf_esvc" />
<input type="hidden" name="dg_opus" value="<%=StringUtil.xssFilter(request.getParameter("dg_opus")) %>" id="dg_opus" />
<input type="hidden" name="dg_esvc" value="<%=StringUtil.xssFilter(request.getParameter("dg_esvc")) %>" id="dg_esvc" />
<input type="hidden" name="ak_opus" value="<%=StringUtil.xssFilter(request.getParameter("ak_opus")) %>" id="ak_opus" />
<input type="hidden" name="ak_esvc" value="<%=StringUtil.xssFilter(request.getParameter("ak_esvc")) %>" id="ak_esvc" />
<input type="hidden" name="hbl1_opus" value="<%=StringUtil.xssFilter(request.getParameter("hbl1_opus")) %>" id="hbl1_opus" />
<input type="hidden" name="hbl1_esvc" value="<%=StringUtil.xssFilter(request.getParameter("hbl1_esvc")) %>" id="hbl1_esvc" />
<input type="hidden" name="hbl2_opus" value="<%=StringUtil.xssFilter(request.getParameter("hbl2_opus")) %>" id="hbl2_opus" />
<input type="hidden" name="hbl2_esvc" value="<%=StringUtil.xssFilter(request.getParameter("hbl2_esvc")) %>" id="hbl2_esvc" />
<input type="hidden" name="callFunc" value="<%=callFunc%>" id="callFunc" />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>e-Booking Upload Copy</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_ok" 				id="btn_ok">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_uncheckall" 		id="btn_uncheckall">Uncheck All</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_checkall" 		id="btn_checkall" style="display:none">Check All</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<div class="wrap_result">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" name="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</div>
</form>