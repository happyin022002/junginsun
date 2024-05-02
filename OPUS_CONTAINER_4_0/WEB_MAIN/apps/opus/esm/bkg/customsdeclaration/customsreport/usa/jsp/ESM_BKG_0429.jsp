<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0429.jsp
*@FileTitle  : US AMS: Received File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0429Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0429Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//error from server
	String strErrMsg 			= "";	//error message
	int rowCount	 			= 0;	//count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strCnt_cd    = "";

	String msgTpId 	   = "";
	String vvd   	   = "";
	String polCd 	   = "";
	String podCd 	   = "";
	String blNo 	   = "";
	String batchNo 	   = "";

	String cntCd       = "";
	String ioBndCd     = "";
	String rcvDate     = "";
	String rcvSeq      = "";
	String rcvDt	   = "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsReport");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0429Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		msgTpId = JSPUtil.getParameter(request, "msg_tp_id");
		vvd   = JSPUtil.getParameter(request, "vvd2");
		polCd = JSPUtil.getParameter(request, "pol");
		podCd = JSPUtil.getParameter(request, "pod");
		blNo = JSPUtil.getParameter(request, "blNo");
		batchNo = JSPUtil.getParameter(request, "batchNo");

		cntCd    = JSPUtil.getParameter(request, "cnt_cd");
		ioBndCd  = JSPUtil.getParameter(request, "io_bnd_cd");
		rcvSeq   = JSPUtil.getParameter(request, "rcv_seq");
		rcvDate  = JSPUtil.getParameter(request, "rcv_date");
		if(!"".equals(rcvDate)){
			  rcvDate  = rcvDate.replace("-","").replace(":","").substring(0);
			  rcvDt    = rcvDate.substring(0,4)+"-"+rcvDate.substring(4,6)+"-"+rcvDate.substring(6,8)+" "+
						 rcvDate.substring(8,10)+":"+rcvDate.substring(10,12)+":"+rcvDate.substring(12);
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<script language="javascript">
	var strCntCd = "<%=strCnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rcv_msg_tp_id" value="<%=msgTpId%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%=podCd%>">
<input type="hidden" name="bl_no" value="<%=blNo%>">
<input type="hidden" name="batch_no" value="<%=batchNo%>">
<input type="hidden" name="rcv_dt" value="<%=rcvDt%>">
<input type="hidden" name="cnt_cd" value="<%=cntCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="rcv_date" value="<%=rcvDate%>">
<input type="hidden" name="rcv_seq" value="<%=rcvSeq%>">

<!-- start	-->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>US AMS: Received File</span></h2>

		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
