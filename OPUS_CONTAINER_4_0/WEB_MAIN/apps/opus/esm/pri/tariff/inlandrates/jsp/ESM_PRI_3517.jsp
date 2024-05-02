<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3517.jsp
*@FileTitle : Inland Rates Publish
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.02 
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
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3517Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3517Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Tariff.InlandRates");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3517Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
 
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Inland Rates Publish</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" id="btn_Save">OK</button>
			<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->



<!-- opus_design_inquiry(S) -->
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<div class="opus_design_inquiry">   <!-- no TAB  -->
			    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <table>
			         <colgroup>
			            <col width="100px" />
			            <col width="210px" />
			            <col width="" />
			        </colgroup> 
			        <tbody>
						<tr class="h23">
							<th>Tariff Code</th>
							<td>
								<input type="text" style="width:200px;" name="tariff_cd" readonly value="" class="input2">
							</td>
						</tr>
						<tr>
							<th>Inland Rates Name</th>
							<td>
								<input type="text" style="width:200px;" name="inland_nm" readonly value="" class="input2">
							</td>
							<td></td>
							
						</tr>
						
					</tbody>
				</table>
			    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
		</div>
		<div class="wrap_result">
			<div class="opus_design_grid" >
				<!-- opus_grid_design_btn(S) -->		
				<script type="text/javascript">ComSheetObject('sheet1');</script>		
			</div>
		</div>
	</div>
</form>