<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0213.jsp
*@FileTitle : Expense Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0213Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0213Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sdt = "";
	String edt = "";
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	String ydCd = "";
	String revYrmon = "";
	String psoBztpCd ="";
	String exeYrmon ="";
	String clptIndSeq ="";
	String hideVrtlPortFlg ="";
	
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0213Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sdt 		= StringUtil.xssFilter(request.getParameter("sdt"));
		edt 		= StringUtil.xssFilter(request.getParameter("edt"));
		vslCd 		= StringUtil.xssFilter(request.getParameter("vslCd"));
		skdVoyNo 	= StringUtil.xssFilter(request.getParameter("skdVoyNo"));
		skdDirCd 	= StringUtil.xssFilter(request.getParameter("skdDirCd"));
		ydCd 		= StringUtil.xssFilter(request.getParameter("ydCd"));
		revYrmon 	= StringUtil.xssFilter(request.getParameter("revYrmon"));
		psoBztpCd 	= StringUtil.xssFilter(request.getParameter("psoBztpCd"));
		exeYrmon 	= StringUtil.xssFilter(request.getParameter("exeYrmon"));
		clptIndSeq 	= StringUtil.xssFilter(request.getParameter("clptIndSeq"));
		hideVrtlPortFlg 	= StringUtil.xssFilter(request.getParameter("hideVrtlPortFlg"));

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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd" value="<%=vslCd %>">
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo %>">
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd %>">
<input type="hidden" name="yd_cd" value="<%=ydCd %>">
<input type="hidden" name="rev_yrmon" value="<%=revYrmon %>">
<input type="hidden" name="pso_bztp_cd" value="<%=psoBztpCd %>">
<input type="hidden" name="exe_yrmon" value="<%=exeYrmon %>">
<input type="hidden" name="clpt_ind_seq" value="<%=clptIndSeq %>">
<input type="hidden" name="hide_vrtl_port_flg" value="<%=hideVrtlPortFlg %>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Expense Detail</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
<div class="wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="10%" />
				<col width="15%" />
				<col width="15%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Revenue Month</th>
					<td><input readonly name="sdt" type="text" style="width:60px;text-align:center;" class="input2" value="<%=sdt %>">&nbsp;~&nbsp;<input readonly name="edt" type="text" style="width:60px;text-align:center;" class="input2" value="<%=edt %>"></td>
					<td>
						<table>
							<tr>
								<td>
									<input name="match_flag" id="match_flag_all" type="radio" value="all" checked><label for="match_flag_all">All</label>
									<input name="match_flag" id="match_flag_match" type="radio" value="match"><label for="match_flag_match">Calculated</label>
									<input name="match_flag" id="match_flag_unmatch" type="radio" value="unmatch"><label for="match_flag_unmatch">0 Value</label>
								</td>
							</tr>
						</table>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</div>
<!-- popup_contens_area(E) -->
</form>