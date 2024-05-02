<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0955.jsp
*@FileTitle : Booking History (B/L Data)
*Open Issues : ESM_BKG_0955 화면
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
* 1.0 Creation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0955Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0955Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
/*	
	int rowCount	   = 0;						//DB ResultSet 리스트의 건수	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
*/	
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
*/ 
		event = (EsmBkg0955Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking History - Detail View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sheet_idx">
<input type="hidden" name="sheet_row">
<input type="hidden" name="his_seq">
<input type="hidden" name="his_dtl_seq">
<!-- popup_title_area(S) -->
	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Booking History - Detail View</span></h2>
		<!-- page_title(E) -->			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_print" id="btn_print">Print</button><!-- 
		   --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	</div>
	<!-- page_title_area(E) -->
<!-- popup_title_area(E) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="55" />
					<col width="120" />
					<col width="55" />
					<col width="120" />
					<col width="55" />
					<col width="120" />
					<col width="55" />
					<col width="120" />
				</colgroup>
				<tbody>
					<tr>
						<td width="55">Booking No.</td>
						<td width="120"><input type="text" style="width:100;" value="" class="input2" name="bkg_no" readonly></td>
						<td width="55">B/L No.</td>
						<td width="120"><input type="text" style="width:100;" value="" class="input2" name="bl_no" readonly></td>
					</tr>
					<tr>
						<td width="55">Item</td>
						<td width="120"><input type="text" style="width:100;" value="" class="input2" name="his_cate_nm" readonly></td>
						<td width="55">User Name</td>
						<td width="120"><input type="text" style="width:100;" value="" class="input2" name="cre_usr_id" readonly></td>
						<td width="55">Office</td>
						<td width="120"><input type="text" style="width:50;" value="" class="input2" name="office" readonly></td>
						<td width="55">Date</td>
						<td width="120"><input type="text" style="width:122;" value="" class="input2" name="cre_dt" readonly></td>
					</tr> 					
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		            <table width="100%" class="grid2" id="mainTable"> 
					<tr class="tr2_head">
					<td width="">Now Read</td>
					<td width="">Previous</td>
					</tr>
					<tr align="center">
					<td><textarea cols="65" rows="11" class="textarea2" name="crnt_ctnt" readonly></textarea></td>
					<td><textarea cols="65" rows="11" class="textarea2" name="pre_ctnt"  readonly></textarea></td>
					</tr>
					</table> 
		        </div>
		        <!-- opus_design_grid(E) -->
		</div>
	</div>
	</div>
	<!-- RD (S) -->
<table>
    <tr>
      <td height="1" width="1">
          <script language="javascript">rdViewerObject('report1');</script>
      </td>
   </tr>	
</table>
<!-- RD (E) -->
</form>
</html>

<SCRIPT language="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
        if(event != null){         	
            String bkgNo     = event.getBkgBlNoVO().getBkgNo();
            String blNo      = event.getBkgBlNoVO().getBlNo();
            String sheetIdx  = event.getSheetIdx();
            String sheetRow  = event.getSheetRow();
        %>
        	var opener = window.dialogArguments;
            eval("bkg_no").value      = '<%=bkgNo%>';
            eval("bl_no").value       = '<%=blNo%>';
            eval("sheet_idx").value   = '<%=sheetIdx%>';  
            eval("sheet_row").value   = '<%=sheetRow%>';  
        <% } %>
       }
-->
</SCRIPT>
