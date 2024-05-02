<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0235.jsp
*@FileTitle  : MNR Release Order Transmission
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0235Event" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0235Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";

	String dispNo			= "";
	String userNm			= "";
	String mnrPrnrCntCd		= "";
	String mnrPrnrSeq		= "";
	String faxNo			= "";
	String mnrPrnrEml		= "";

	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm();
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();

		event = (EesMnr0235Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		if(request.getParameter("disp_no")!=null && !request.getParameter("disp_no").equals("")) {
			dispNo = StringUtil.xssFilter(request.getParameter("disp_no"));
		}
		if(request.getParameter("user_nm")!=null && !request.getParameter("user_nm").equals("")) {
			userNm = StringUtil.xssFilter(request.getParameter("user_nm"));
		}
		if(request.getParameter("mnr_prnr_cnt_cd")!=null && !request.getParameter("mnr_prnr_cnt_cd").equals("")) {
			mnrPrnrCntCd = StringUtil.xssFilter(request.getParameter("mnr_prnr_cnt_cd"));
		}
		if(request.getParameter("mnr_prnr_seq")!=null && !request.getParameter("mnr_prnr_seq").equals("")) {
			mnrPrnrSeq = StringUtil.xssFilter(request.getParameter("mnr_prnr_seq"));
		}
		if(request.getParameter("fax_no")!=null && !request.getParameter("fax_no").equals("")) {
			faxNo = StringUtil.xssFilter(request.getParameter("fax_no"));
		}
		if(request.getParameter("mnr_prnr_eml")!=null && !request.getParameter("mnr_prnr_eml").equals("")) {
			mnrPrnrEml = StringUtil.xssFilter(request.getParameter("mnr_prnr_eml"));
		}


	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";

    var dispNo			= "<%=dispNo%>";
    var userNm			= "<%=strUsr_nm%>";
    var mnrPrnrCntCd	= "<%=mnrPrnrCntCd%>";
    var mnrPrnrSeq		= "<%=mnrPrnrSeq%>";
    var faxNo			= "<%=faxNo%>";
    var mnrPrnrEml		= "<%=mnrPrnrEml%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<div style="display:none">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="disp_no" value="<%= dispNo%>" id="disp_no" />
<input type="hidden" name="user_nm" value="<%= userNm%>" id="user_nm" />
<input type="hidden" name="mnr_prnr_cnt_cd" value="<%= mnrPrnrCntCd%>" id="mnr_prnr_cnt_cd" />
<input type="hidden" name="mnr_prnr_seq" value="<%= mnrPrnrSeq%>" id="mnr_prnr_seq" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>MNR Release Order Transmission</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_DOCSend" id="btn_DOCSend">Doc Send</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Print"  	id="btn_Print">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search" style="height:8%!important">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Transmission Type</th>
						<td><script type="text/javascript">ComComboObject('trsm_mod_cd', 1, 60, 1, 1)</script><!-- 
						 --><input id="iFax_no" type="text" name="fax_no" style="width:170px" class="input1" dataformat="num" maxLength="20"><!-- 
						  --><input id="iMnr_prnr_eml" type="text" name="mnr_prnr_eml" style="width:200px" class="input1" maxLength="200"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result" style="position:relative;top:8%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>