<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1043.jsp
*@FileTitle  : OP/MG Forecast Log 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String repoPlnWrwk 	= ""; 
	String repoPlnWrwkView = ""; // 화면표현
	String inpYrwk      = "";
	String fcastYrwk 	= "";
	String fcastYrwkView= "";    // 화면표현
	String locGrpCd 	= "";
	String locCd    	= "";
	String tpCD         = "";
	String title 		= "";
	String locLevel     = "";
	String searchFlag   = "";
	String mainpage 	= "";


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EesEqr1043Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		mainpage 	= request.getParameter("mainPage");
		repoPlnWrwk = (String)event.getAttribute("repo_pln_yrwk");
		if(!repoPlnWrwk.equals("")) repoPlnWrwkView = repoPlnWrwk.substring(0, 4) + "-" + repoPlnWrwk.substring(4, 6);

		inpYrwk     = (String)event.getAttribute("inp_yrwk");
		fcastYrwk 	= (String)event.getAttribute("fcast_yrwk");
		if(!fcastYrwk.equals("")) fcastYrwkView = fcastYrwk.substring(4, 6);
		locGrpCd 	= (String)event.getAttribute("loc_grp_cd");
		locCd    	= (String)event.getAttribute("loc_cd");
		tpCD        = (String)event.getAttribute("tp_cd");	
		searchFlag  = (String)event.getAttribute("search_flag");

		if("1".equals(tpCD)) title = "MG Input History";
		else				 title = "OP Input History";		

		if("E".equals(locGrpCd)){
			locLevel = "ECC";
		}else if("L".equals(locGrpCd)){
			locLevel = "LCC";
		}else if("S".equals(locGrpCd)){
			locLevel = "SCC";
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="loc_cd" value="<%=locCd%>" id="loc_cd" />
<input type="hidden" name="inp_yrwk" value="<%=inpYrwk%>" id="inp_yrwk" />
<input type="hidden" name="fcast_yrwk" value="<%=fcastYrwk%>" id="fcast_yrwk" />
<input type="hidden" name="repo_pln_yrwk" value="<%=repoPlnWrwk%>" id="repo_pln_yrwk" />
<input type="hidden" name="loc_grp_cd" value="<%=locGrpCd%>" id="loc_grp_cd" />
<input type="hidden" name="tp_cd" value="<%=tpCD%>" id="tp_cd" />
<input type="hidden" name="search_flag" value="<%=searchFlag%>" id="search_flag" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span><%=title%></span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		<%if(!"true".equals(mainpage)){ %>
			<button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button>
		<%} %>
	</div>
	<!-- opus_design_btn(E) -->
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" style="text-align: center;">
		<table>
			<colgroup>
				<col width="*">
				<col width="400">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td>&nbsp;</td>
					<th>Balance Report ID : <%=repoPlnWrwkView %>, &nbsp;Week : <%=fcastYrwkView %> </th>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<table class="mar_btm_8">
		<colgroup>
			<col width="120">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th><%=locLevel %> : <%=locCd %></th>
				<td>&nbsp;</td>
			</tr>
		</tbody>
	</table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>