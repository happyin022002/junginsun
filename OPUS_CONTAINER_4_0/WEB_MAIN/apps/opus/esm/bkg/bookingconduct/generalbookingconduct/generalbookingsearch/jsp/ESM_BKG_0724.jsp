<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0724.jsp
*@FileTitle : Roll Over Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.14 최영희
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0724Event"%>
                 
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0724Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAsList = "";
	String strAsCode = "";
	String strAsText = "";
	String strBkgNo = "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch"); 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		 
		strAsList=JSPUtil.getIBCodeCombo("", "", "CD01571", 0, "");
		if(strAsList != null && strAsList.length() > 8) {
			strAsCode = strAsList.substring(strAsList.indexOf("Code = \"")+8, strAsList.lastIndexOf("\""));
			strAsText = strAsList.substring(strAsList.indexOf("Text = \"")+8, strAsList.indexOf("\";"));  
		}
        
		event = (EsmBkg0724Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		document.title="Roll-over Information";
		loadPage("<%=strAsCode%>","<%=strAsText%>");
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="modifyFlag">
<input type="hidden" name="param">
<input type="hidden" name="sys_app" value="BKG">
<input type="hidden" name="mrd" value="ESM_BKG_0816.mrd"> 

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Roll-over Information</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_data" style="width:520px;margin-bottom:25px">   <!-- no TAB  -->
			<table class="grid_2"> 
				<colgroup>
					<col width="110" />
					<col width="110" />
					<col width="90" />
					<col width="65" />
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<th>B/L No.</th>		
						<th>VVD CD</th>		
						<th>POL</th>
						<th>ETB</th>
						<th>ETD</th>				
					</tr> 
					
					<tr>
						<td><input type="text" style="width:100px;" class="noinput2" name="bkg_no" value="<%=strBkgNo%>" readonly id="bkg_no" /></td>
						<td><input type="text" style="width:100px;" class="noinput2" name="bl_no" readOnly></td>
						<td><input type="text" style="width:85px;" class="noinput2" name="vvd" readonly id="vvd" /></td>
						<td><input type="text" style="width:60px;" class="noinput2" name="pol" readonly id="pol" /></td>
						<td><input type="text" style="width:120px;" class="noinput2" name="etb" readonly id="etb" /></td>
						<td><input type="text" style="width:120px;" class="noinput2" name="etd" readonly id="etd" /></td>					
					</tr> 
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid" >
			<table>
			<tr><td align="right">In case the reason of roll-over is "Carrier Schedule Change", Demurrage charge will be exempted.</td></tr>
			</table>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</form>
