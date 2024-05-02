<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0948.jsp
*@FileTitle  : Hold Mail/Alert Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0948Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0948Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	String strCnt_cd        = "";
    String code = "";
    String value = "";
    String main_page ="";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.HoldNotice");
	
	try {
		main_page = JSPUtil.getNull(request.getParameter("mainPage"));
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		strCnt_cd = account.getCnt_cd();
	   
	   
		event = (EsmBkg0948Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
var evtCode = "<%=code %>|";
var evtValue = "<%=value %>|";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">

<input type="hidden" name="user_id" 	id="user_id"  	value="<%=strUsr_id %>">
<input type="hidden" name="user_eml" 	id="user_eml" 	value="<%=strUsr_eml %>">
<input type="hidden" name="cnt_cd" 		id="cnt_cd"  	value="US">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn1_Retrieve" 	id="btn1_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn1_Save"  		id="btn1_Save">Save</button><!--
	--><%if(!"true".equals(main_page)){ %><!--
	--><button type="button" class="btn_normal" name="btn_Close"		id="btn_Close">Close</button><!--
	--><%} %>	
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
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
		 		<col width="110"/>
				<col width="*" />
		    </colgroup>
		    <tr>
                <th style="text-align:left;">Customs Location</th> 
                <td>
                    <input type="text" name="loc_cd" id="loc_cd" class="input1" style="width:53px;ime-mode:disabled;" value="" caption="Customs Location" maxlength="5" minlength="5" dataformat="engup" required="" fullfill="fullfill"/>
                </td>                                             
            </tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn" style="text-align: right;">
		<button type="button" class="btn_accent" name="btn2_Add" 	id="btn2_Add">Row Add</button>
		<button type="button" class="btn_accent" name="btn2_Delete"	id="btn2_Delete">Row Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
<!-- opus_design_grid(E) -->
</div>
</form>