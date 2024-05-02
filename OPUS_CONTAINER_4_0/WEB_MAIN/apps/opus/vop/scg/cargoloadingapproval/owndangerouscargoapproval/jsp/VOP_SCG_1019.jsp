<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_1019.jsp
*@FileTitle  : Application Request & Approval Status - SS
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
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
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg1019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strScgFlg = request.getParameter("scg_flg")==null?"SS":request.getParameter("scg_flg");
	String strBkgNo = request.getParameter("bkg_no");
	String strVslCd = request.getParameter("vsl_cd");
	String strSkdVoyNo = request.getParameter("skd_voy_no");
	String strSkdDirCd = request.getParameter("skd_dir_cd");
	
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1019Event)request.getAttribute("Event");
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
<title>Application Request & Approval Status - SS</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<input type="hidden" id="scg_flg" name="scg_flg" value="<%=StringUtil.xssFilter(strScgFlg) %>">
<input type="hidden" id="vsl_cd" name="vsl_cd" value="<%=StringUtil.xssFilter(strVslCd) %>">
<input type="hidden" id="skd_voy_no" name="skd_voy_no" value="<%=StringUtil.xssFilter(strSkdVoyNo) %>">
<input type="hidden" id="skd_dir_cd" name="skd_dir_cd" value="<%=StringUtil.xssFilter(strSkdDirCd) %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Application Request & Approval Status - Special Stowage</span></h2>
		
		<div id="btnView1" class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>	
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="60">BKG No.</th>
						<td width="790"><input type="text" name="booking_no" style="width:100px;" class="input2" readonly value="<%=StringUtil.xssFilter(strBkgNo) %>"></td>
						<td id="bkgStsDesc"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>