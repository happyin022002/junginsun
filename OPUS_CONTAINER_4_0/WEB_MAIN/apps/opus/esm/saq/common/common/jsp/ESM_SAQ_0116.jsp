<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0116.jsp
*@FileTitle  : Quarterly Quota>Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.common.common.event.EsmSaq0116Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0116Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Common.Common");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0116Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}

	String bse_yr = JSPUtil.getParameter(request, "bse_yr", "");
	String bse_qtr_cd = JSPUtil.getParameter(request, "bse_qtr_cd", "");
	String gline_ver_no = JSPUtil.getParameter(request, "gline_ver_no", "");
	String trd_cd = JSPUtil.getParameter(request, "trd_cd", "");
	String dir_cd = JSPUtil.getParameter(request, "dir_cd", "");
	String rlane_cd = JSPUtil.getParameter(request, "rlane_cd", "");
	String sprt_grp_cd = JSPUtil.getParameter(request, "sprt_grp_cd", "");
	String bsa_grp_cd = JSPUtil.getParameter(request, "bsa_grp_cd", "");
	String bse_mon = JSPUtil.getParameter(request, "bse_mon", "");
	String tbl_gbn = JSPUtil.getParameter(request, "tbl_gbn", "");

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bse_yr" value="<%=bse_yr%>" id="bse_yr" />
<input type="hidden" name="bse_qtr_cd" value="<%=bse_qtr_cd%>" id="bse_qtr_cd" />
<input type="hidden" name="gline_ver_no" value="<%=gline_ver_no%>" id="gline_ver_no" />
<input type="hidden" name="trd_cd" value="<%=trd_cd%>" id="trd_cd" />
<input type="hidden" name="dir_cd" value="<%=dir_cd%>" id="dir_cd" />
<input type="hidden" name="rlane_cd" value="<%=rlane_cd%>" id="rlane_cd" />
<input type="hidden" name="sprt_grp_cd" value="<%=sprt_grp_cd%>" id="sprt_grp_cd" />
<input type="hidden" name="bsa_grp_cd" value="<%=bsa_grp_cd%>" id="bsa_grp_cd" />
<input type="hidden" name="bse_mon" value="<%=bse_mon%>" id="bse_mon" />
<input type="hidden" name="tbl_gbn" value="<%=tbl_gbn%>" id="tbl_gbn" />

<div class="layer_popup_title">	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class= "wrap_result">
		<div class= "opus_design_inquiry ">
			<table>
				<colgroup>
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>VVD Group</th>
						<td><!--필수입력표시--><%=rlane_cd + "-" + sprt_grp_cd + "-" +  bsa_grp_cd%></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_grid(S) -->	
		<div class="opus_design_grid " id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>		
</div>	
</form>