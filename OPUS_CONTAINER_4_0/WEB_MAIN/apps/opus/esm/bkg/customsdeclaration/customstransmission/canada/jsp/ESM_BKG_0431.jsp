<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0431.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0431Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0431Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String mainPage 		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		 
		event = (EsmBkg0431Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String strBlNo = (request.getParameter("bl_no") == null) ? "" : request.getParameter("bl_no");
	String strVvdNo = (request.getParameter("vvd_cd") == null) ? "" : request.getParameter("vvd_cd");
	
%>

<html>
<head>
<title>Receive History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=StringUtil.xssFilter(request.getParameter("f_cmd"))%>');
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post" id="form"'>
<input type="hidden" name="f_cmd" value="<%=StringUtil.xssFilter(request.getParameter("f_cmd"))%>">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
<%if(!mainPage.equals("true")){%>
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Receiving History</span></h2>
	<!-- page_title(E) -->
<%}else{%>
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
<%}%>

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" 				id="btn_new">New</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_viewReceiveFile"	id="btn_viewReceiveFile">View Received File</button><!-- 		
		--><button type="button" class="btn_normal" name="btn_viewMsg"			id="btn_viewMsg">View MSG</button><!-- 		
<%if(!mainPage.equals("true")){%>
		--><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button><!-- 		
<%}%>
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table>
		    <colgroup>
		    	<col width="140">
		    	<col width="510">
		    	<col width="*">
		    </colgroup>
					<tr>
						<td>
							<table class="search_sm2" border="0" width="">
								<tr class="h23">
									<td class="sm" align="center">MSG TYPE</td>
								</tr>
								<tr class="h23">
									<td class="sm" align="center">
										<select style="width:80px;" name="rcv_msg_tp_id">
										<option value="">All</option>
										<option value="997">997</option>
										<option value="824">824</option>
										<option value="BRC">Baplie Response</option>
										</select>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table class="" border="0" width="">
								<tr class="h23">
									<th title="Vessel Voyage Direction">VVD</th>
									<td><input type="text" style="width:90px;ime-mode:disabled" class="input" 
										name="vvd_cd" dataformat="engup" maxlength="9" caption="VVD" value="<%=StringUtil.xssFilter(strVvdNo)%>" fullfill ></td> 
									<th title="Port of Loading">POL</th>
									<td><input type="text" style="width:90px;ime-mode:disabled" class="input" 
										name="pol_cd" dataformat="engup" maxlength="5" caption="POL"></td>
									<th title="Port of Discharging">POD</th>
									<td><input type="text" style="width:90px;ime-mode:disabled" class="input" 
										name="pod_cd" dataformat="engup" maxlength="5" caption="POD"></td> 
								</tr>
								
								<tr class="h23">
									<th>B/L No.</th>
									<td><input type="text" style="width:120px;ime-mode:disabled" class="input" 
										name="bl_no" dataformat="eng" maxlength="12" caption="B/L No" value="<%=StringUtil.xssFilter(strBlNo)%>"></td>
									<th></th>
									<td></td>
									<th></th>
									<td></td> 
								</tr>
							</table>
						</td>
						<td>
							<table class="search_sm2" border="0" width="">
							
								<tr class="h23">
									<td class="sm" width="120px"><input type="checkbox" class="trans" name="rcv_dt_flg" value="true">&nbsp;Receive Date</td>
								</tr>								
								<tr class="h23">
									<td class="sm">
										<input type="text" style="width:80px;ime-mode:disabled"  maxlength="10"
											name="s_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="e_rcv_dt">
										<input type="text" style="width:40px;ime-mode:disabled"  maxlength="5" value="00:00"
											name="s_rcv_tm" class="input" dataformat="hm" caption="Receive Time">&nbsp;~&nbsp;
										<input type="text" style="width:80px;ime-mode:disabled"  maxlength="10"
											name="e_rcv_dt" class="input" dataformat="ymd" caption="Receive Date" cofield="s_rcv_dt">
										<input type="text" style="width:40px;ime-mode:disabled"  maxlength="5" value="23:59"
											name="e_rcv_tm" class="input" dataformat="hm" caption="Receive Time">
										<button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
									</td>
								</tr>								
							</table>
						</td>
					</tr>					
				</tbody>
			</table>
		    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_inquiry(E) -->
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
	<!-- popup_contens_area(E) -->
	
<!-- Developer Work End -->
</form>
</body>
</html>