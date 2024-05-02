
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0359.jsp
*@FileTitle : MI Transmit History  for IE
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0359Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0359Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vsl_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCommon.BookingUtil");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0359Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//vsl_cd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		
		//log.debug("vsl_cd"+vsl_cd);
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
	   <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	   --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button><!--
	   --><button type="button" class="btn_normal" name="btn_BL_Inquiry" id="btn_BL_Inquiry">Manifest(B/L)</button>
   </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">		
		<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:900px;"> 
		<tr class="h23">
			<!-- <td class="sm" width="400px">  
				<table class="search_sm2" border="0" style="width:95%;"> 
				<tr class="h23">-->
				<!-- <td width="160px">
						<input type="radio" id="trunk" name="trunkfirst" value="T" class="trans" checked><label for="trunk">Trunk</label>
						<input type="radio" id="first" name="trunkfirst" value="S" class="trans"><label for="first">First</label>
					</td>  -->
				    <th width="35px" class="stm">VVD</th>
				    <td width="100px"><input type="text" name="vvd" style="width:80px;" class="input1" dataformat="engup" maxlength="9" fullfill required></td>
				    <th width="26px" class="stm">POL</th>
				    <td width="80px"><input type="text" name="pol" style="width:50px;" class="input" dataformat="engup" maxlength="5" fullfill ></td>
				    <th width="26px" class="stm">ETA</th>
				    <td width="150px"><input type="text" name="eta" style="width:110px;" class="input2" value="" readonly></td>
			<!--  </tr>
			  </table>
			 </td>  -->
			<th width="26px">POD</th>
			<td width="70px"><input type="text" name="pod" style="width:50px;" class="input" dataformat="engup" maxlength="5"></td>
			<th width="50px">B.OFC</th>
			<td width="70px"><input type="text" name="bofc" style="width:50px;" class="input" dataformat="enguponly" maxlength="5"></td>
			<th width="55px">MF STS</th>
			<td width="110px" align="right">
			    <%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("blmi", "US", "MANI_STS_CD","", "style='width:100;'")%></td>
				<script>ComAddBeginComboItem(form.blmi,"All","")
	                             ComSetObjValue(form.blmi,'' );</script> 					
		</tr>
		</table>
		<table class="search" border="0" style="width:900px;"> 
		<tr class="h23">
			<td width="500px" align="right">Run Time</td>
			<td width="120px"><input type="text" name="runtime" style="width:110px;" class="input" value="" readonly></td>
			<td width="80px">
				<table class="search_sm2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td class="sm">
						<input type="radio" id="all" name="allerror" value="ALL" class="trans" checked><label for="all">All</label>
						<input type="radio" id="error" name="allerror" value="ERR" class="trans"><label for="error">Error</label>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--  biz_1   (E) -->
	</div>
	<!-- 검색영역 -->
</div>

<div class="wrap_result">
	<!-- 시트영역 -->
	<!-- opus_tab_btn(E) -->
	<div class="opus_design_tab">
			<script language="javascript">ComTabObject('tab1')</script>
	</div>
	
	<!--TAB Manifest Status (S) -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid">	
			<div class="opus_design_btn">
			   <button type="button" class="btn_normal" name="btn_Print1" id="btn_Print1">Print</button>
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- Grid BG Box  (S) -->
		
		<div class="opus_design_inquiry">
	     	<table>
	     		<tbody>
					<tr>
						<td width="131"><input type="text" name="manifestTotal" style="width:120px;" class="input" value=" Manifest TTL [ ]" readonly></td>
						<td width="20">=</td>
						<td width="130"><input type="text" name="sentByMiCount" style="width:120px;" class="input" value=" Sent by MI [ ]" readonly></td>
						<td width="20">+</td>
						<td><input type="text" name="addedByAiCount" style="width:120px;" class="input" value=" Added by AI [ ]" readonly></td>
					</tr>
					<tr>
						<td colspan="4"><input type="text" name="targetTotal" style="width:120px;" class="input" value=" Target   TTL [ ]" readonly></td>
						<td><input type="text" name="unManifestCount" style="width:120px;color:#ff0000;" class="input" value=" Un-Manifest [ ]" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	
	<!--TAB B/L to be deleted (S) -->
	<div id="tabLayer" style="display:none">
		<div class="opus_design_grid">	
			<div class="opus_design_btn">
			   <button type="button" class="btn_normal" name="btn_Print2" id="btn_Print2">Print</button>
			</div>
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
<!-- 시트영역 -->
</div>
</form>

