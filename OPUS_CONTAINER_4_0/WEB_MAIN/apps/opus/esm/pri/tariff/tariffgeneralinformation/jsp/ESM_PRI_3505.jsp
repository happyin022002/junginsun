<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_3505.jsp
*@FileTitle  : Tariff General Information Publish
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3505Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3505Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffGeneralInformation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3505Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer performance	-->

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>Tariff General Information Publish</span></h2>
		    <div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">OK</button><!--
		       	--><button type="button" class="btn_normal" name="btn_Close"  id="btn_Close">Close</button>
		    </div>
		</div>
	</div>
	
	<div class="layer_popup_contents">
		<div class="wrap_result">
			<div class="opus_design_inquiry">
			    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <table style="search_sm2">
			        <colgroup>
			        	<col width="85" />
			            <col width="200" />
			            <col width="" />	            
			        </colgroup>
			        <tbody>
						<tr>
							<th>Tariff Code</th>
							<td>
								<input type="text" style="width:159px;" name="tariff_cd" readonly value="" class="input2">
							</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		
    		<div class="opus_design_grid" id="mainTable">
    			<script type="text/javascript">ComSheetObject('sheet1');</script>
    		</div>
    	</div>
	</div>

</form>