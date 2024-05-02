<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0351.jsp
*@FileTitle : LCL List & I/B B/L File
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0351Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0351Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cn_no= "";	  
	String vvd_no= ""; 
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cn_no = request.getParameter("crn_no")==null?"":request.getParameter("crn_no");
	   	vvd_no = request.getParameter("vvd_no")==null?"":request.getParameter("vvd_no");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<script language="javascript">
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
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="cn_no" value="<%=StringUtil.xssFilter(cn_no)%>">
<input type="hidden" name="vvd_no" value="<%=StringUtil.xssFilter(vvd_no)%>">
<input type="hidden" name="pg_no" value="esm0351">
    
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
   
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_Print"   id="btn_Print">Print I/B B/L File</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
	
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
	    <table>
	         <colgroup>
	            <col width="30px" />
	            <col width="180px" />
	            <col width="30px" />
	            <col width="160px" />
	            <col width="36px" />
	            <col width="160px" />
	            <col width="36px" />
	            <col width="120px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>CRN</th>
					<td><input name="frm_crn_number"  dataformat="engup" style="ime-mode: disabled" maxlength="14" type="text" style="width:120;" class="input1" value=""></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input name="vvd_number" type="text" style="width:100;" class="input" dataformat="engup" style="ime-mode: disabled" maxlength="9"  value=""></td>
					<th title="Port of Loading">POL</th>
					<td><input name="pol_cd" style="ime-mode: disabled"  maxlength="5" type="text" style="width:100;" class="input" value="" dataformat="engup" ></td>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod_cd" type="text" style="width:100;" class="input2" value="NLRTM" readonly></td>
					<td></td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">	    
	    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>