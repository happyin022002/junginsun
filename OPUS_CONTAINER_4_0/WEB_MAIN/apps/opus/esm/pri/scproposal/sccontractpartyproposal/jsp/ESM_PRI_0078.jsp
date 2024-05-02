<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0078.jsp
*@FileTitle  : Contract Parties Information Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri0078Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0078Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCContractPartyProposal");
	
	String propNo = "";	
	String amdtSeq = "";
	
	String sCustCntCd = "";
	String sCustSeq = "";
	String sCustNm ="";

	String scNo1 = "";
	String scNo2 = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;	
    String[] prcCtrtPtyTpCd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		sCustCntCd = request.getParameter("sCustCntCd");		
		sCustSeq = request.getParameter("sCustSeq");		
		sCustNm = request.getParameter("sCustNm");		
		scNo1 = request.getParameter("sSc_No1");
		scNo2 = request.getParameter("sSc_No2");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");
		prcCtrtPtyTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCtrtPtyTpCd"), false ,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>";  
    var prcCtrtPtyTpCdValue = "<%=prcCtrtPtyTpCd[0]%>";
    var prcCtrtPtyTpCdText = "<%=prcCtrtPtyTpCd[1]%>"; 
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" />
<input type="hidden" name="cd" id="cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Contract Parties Information Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Close" 		id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents" style="overflow:hidden">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60"/>
					<col width="100"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="100"/>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>S/C No.</th>
						<td><input type="text" name="sc_no1" style="width:30px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(scNo1)%>" id="sc_no1" /> 
						    <input type="text" name="sc_no2" style="width:55px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(scNo2)%>" id="sc_no2" /></td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" style="width:40px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(amdtSeq) %>" id="amdt_seq" /></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:85px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" /></td>
						<th>Customer</th>
						<td><input type="text" name="cust_cd" style="width:30px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(sCustCntCd) %>" id="cust_cd" />
						    <input type="text" name="cust_seq" style="width:50px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(sCustSeq) %>" id="cust_seq" />
						    <input type="text" name="cust_nm" style="width:218px;" class="input2" value="<%=StringUtil.xssFilter(sCustNm) %>" id="cust_nm" /></td>
					</tr>
					</table>	
					</div>
					<table class="line_bluedot"><tr><td></td></tr></table>
						<div class= "opus_design_inquiry wFit">
					<table>
						<tr style="height:30px">
						<th class="sm" style="width:80px">Contract Party</th>
						<td style="width:200px" id="prcCtrtPtyTpCd" name="prcCtrtPtyTpCd" class="sm pad_left_8">
							<div id="div_prcCtrtPtyTpCd" name="div_prcCtrtPtyTpCd"></div>
						</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>