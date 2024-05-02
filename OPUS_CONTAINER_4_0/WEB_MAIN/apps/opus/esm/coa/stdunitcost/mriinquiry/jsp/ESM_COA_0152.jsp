<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_COA_0152.jsp
*@FileTitle  : Unit Price management for MRI Freight revenue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException = null; //Error from server
	String strErrMsg = ""; //Error message
	int rowCount = 0; //Count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String xml = "";
	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.MRIInquiry");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		var formObj = document.form;

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}
</script>
</head>


<form method="post" name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<!-- hidden form's iframe -->
<iframe height="0" width="0" name="frmHidden"></iframe>
<!-- hidden form's iframe -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_LoadExcel"  		id="btn_LoadExcel">Load Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50">
					<col width="50">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="*">
			    </colgroup>
			    	<tr >
						<th>YYYY-MM</th>
						<td colspan="7"><input type="text" name="f_rev_yrmon" class="input1" style="width:70px;" value="" maxlength="6" dataformat="ym" id="f_rev_yrmon" /> </td>
					</tr>
					<tr>
						<th>Trade <input type="radio" class="trans" name="istrade" value="YES" id="istrade" /> </th>
						<th> Lane <input type="radio" class="trans" name="istrade" value="NO" checked></th>
						<th>Trade</th>
						<td>
							<script type="text/javascript">ComComboObject('f_trd_cd',1, 110 , 0 )</script>
						</td>
						<th>Lane</th>
						<td>
							<script type="text/javascript">ComComboObject('f_rlane_cd',1, 110 , 0 )</script>
						</td>
						<th>Dir.</th>
						<td>
							<script type="text/javascript">ComComboObject('f_dir_cd',1, 110 , 0 )</script>
						</td>
					</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<!-- SJH.20141211.MOD -->
		<table width="100%">
			<tbody>
				<colgroup>
					<col width="150">
					<col width="*">
					<col width="250">
			    </colgroup>
		    	<tr >
					<td><h3 class="title_design">MRI Inquiry</h3></td>
					<td></td>
					<td><div class="opus_design_btn">
							<button type="button" class="btn_accent" name="btng_RowAdd" 	id="btng_RowAdd">Row Add</button><!-- 
						 --><button type="button" class="btn_normal" name="btn_rowdelete" 	id="btn_rowdelete">Row Delete</button><!-- 
						 --><button type="button" class="btn_normal" name="btng_Save" 		id="btng_Save">Save</button>
						</div>
					</td>
				</tr>
		    	<tr >
					<td></td>
					<td></td>
					<td align="right">(TEU)</td>
				</tr>		
			</tbody>
		</table>	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>

<!-- Developer DIV END -->