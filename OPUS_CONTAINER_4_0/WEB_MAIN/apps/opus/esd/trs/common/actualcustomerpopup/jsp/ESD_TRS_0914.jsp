<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0914.jsp
*@FileTitle  : Other SO(Detail Input Pop up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;	
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String sContiCd		= JSPUtil.getNull(request.getParameter("conti_cd"));
	String sDorLocCd 	= JSPUtil.getNull(request.getParameter("act_loc"));
	String sDorZnCd		= JSPUtil.getNull(request.getParameter("zone_cd"));
	String sBoundCd		= JSPUtil.getNull(request.getParameter("bound_cd"));
	String sDorNodCd	= sDorLocCd + sDorZnCd;
	String sDorNodeMaxLength	= "7";
	
	String sTxtLocation	= "Door Node";
	String sTxtCustCode	= "Customer Code";
	String sTxtCustName	= "Factory Name";
	if( "A".equals(sContiCd) || "M".equals(sContiCd) ) {
		sDorNodCd		=  sDorLocCd + sDorZnCd;
		sDorNodeMaxLength	= "7";
	}
	String act_cust_cd 	= JSPUtil.getNull(request.getParameter("act_cust_cd"));
	act_cust_cd			= "0".equals(act_cust_cd) ? "" : act_cust_cd;
	String fctry_nm 	= JSPUtil.getNull(request.getParameter("fctry_nm")	);
	String row 			= JSPUtil.getNull(request.getParameter("row"));

%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="iPage" id="iPage" />
	<input type="hidden" name="ACT_CUST_CNT_CD" id="ACT_CUST_CNT_CD" />
	<input type="hidden" name="ACT_CUST_SEQ" id="ACT_CUST_SEQ" />
	<input type="hidden" name="USA_TRSP_ACT_CUST_NO" id="USA_TRSP_ACT_CUST_NO" />
	<input type="hidden" name="INIT_FLAG" value="Y" id="INIT_FLAG" />
	<input type="hidden" name="CONTI_CD" value="<%=sContiCd%>" id="CONTI_CD" />
	<input type="hidden" name="BOUND_CD" value="<%=sBoundCd%>" id="BOUND_CD" />
	<input type="hidden" name="ROW" value="<%=row%>" id="ROW" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Actual Customer Help</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_ok" 	id="btn_ok">OK</button><!--  
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!--  
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
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th><%=sTxtLocation%></th>
					<td><input type="text" align="center" style="width:80px;" name="dor_nod_cd" value="<%=sDorNodCd%>" maxlength="<%=sDorNodeMaxLength%>" id="dor_nod_cd" dataformat="engup"/> </td>
					<th><%=sTxtCustCode%></th>
					<td><input type="text" style="width:80px;" name="act_cust_cd" value="<%=act_cust_cd%>" maxlength="8" id="act_cust_cd" dataformat="engup"/> </td>
					<th><%=sTxtCustName%></th>
					<td><input type="text" style="width:200px;" name="fctry_nm" value="<%=fctry_nm%>" onkeyup="enterCheck(this)" maxlength="50" id="fctry_nm" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>	
	<table id="subTable" style="table-layout:fixed"></table>
	<div class="opus_design_grid clear" id="subTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>	
</div>	
</form>