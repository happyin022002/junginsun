<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1145.jsp
*@FileTitle  : Invoice File Import(Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1145Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1145Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.PoolChassisHistory");
	String chss_pool_co_cd  = "";
	String pool_mgmt_co_nm	= "";
	String mvmt_dt		    = "";
	String strOfc_cd        = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		chss_pool_co_cd = StringUtil.xssFilter(request.getParameter("chss_pool_co_cd"));
		pool_mgmt_co_nm = StringUtil.xssFilter(request.getParameter("pool_mgmt_co_nm"));
		mvmt_dt         = StringUtil.xssFilter(request.getParameter("mvmt_dt"));

		event = (EesCgm1145Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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
</head>



<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="save_chk" value="<%=strOfc_cd %>">

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Invoice File Import</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save"	id="btn_save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_close"	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table> 
			<tr>
				<th width="35">
					Pool
				</th>
				<td width="120">
					<input type="text" style="width:60px;text-align:center" class="input2" name="chss_pool_cd" value="<%=chss_pool_co_cd %>">
				</td>
				<th width="45">
					MGMT
				</th>
				<td width="320">
					<input type="text" style="width:270px;text-align:left" class="input2" name="pool_mgmt_co_nm" value="<%=pool_mgmt_co_nm %>">
				</td>
				<th width="50">
					Month
				</th>
				<td width="">
					<input type="text" style="width:60px;text-align:center" class="input2"  name="cost_yrmon" value="<%=mvmt_dt %>">
				</td>
			</tr>
		</table>
	</div>
	</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowadd"	id="btn_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_delete"	id="btn_delete">Row Delete</button>
		</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div style="display:none">
	<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>
