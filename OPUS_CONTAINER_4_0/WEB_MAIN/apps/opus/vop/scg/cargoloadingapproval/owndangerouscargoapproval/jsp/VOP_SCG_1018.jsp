<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_1018.jsp
*@FileTitle  : Application Request & Approval Status - Reefer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg1018Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strScgFlg = request.getParameter("scg_flg");
	String strBkgNo = request.getParameter("bkg_no");
	String strVslCd = request.getParameter("vsl_cd");
	String strSkdVoyNo = request.getParameter("skd_voy_no");
	String strSkdDirCd = request.getParameter("skd_dir_cd");
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Application Request & Approval Status - Reefer</title>


<script type="text/javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="scg_flg" value="<%=StringUtil.xssFilter(strScgFlg) %>" id="scg_flg" />
<input type="hidden" name="vsl_cd" value="<%=StringUtil.xssFilter(strVslCd) %>" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" value="<%=StringUtil.xssFilter(strSkdVoyNo) %>" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" value="<%=StringUtil.xssFilter(strSkdDirCd) %>" id="skd_dir_cd" />



<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Application Request & Approval Status - Reefer</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_Save"  		id="btn_Save">Save</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>BKG No.</th>
					<td><input type="text" name="booking_no" style="width:100px;" class="input2" readonly value="<%=StringUtil.xssFilter(strBkgNo) %>" id="booking_no" /></td>
					<td  id="bkgStsDesc" name="bkgStsDesc" ></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_grid clear">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_tab_btn(E) -->
</div>
</form>