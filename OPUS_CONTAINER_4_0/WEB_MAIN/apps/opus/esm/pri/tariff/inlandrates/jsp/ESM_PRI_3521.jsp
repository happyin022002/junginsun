<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3521.jsp
*@FileTitle : Inland Rates Amend Request
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
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3521Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3521Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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


		event = (EsmPri3521Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
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

        document.getElementById("title").innerHTML = "Inland Rates Amend Request";
        $('#btn_ok').after($('#btn_Close'));
        
		loadPage();
	}
</script>



<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

	<!-- layer_popup_title(S) -->
	 <div class="layer_popup_title">
	    <!-- page_title_area(S) -->
	    <div class="page_title_area clear">
	        <!-- page_title(S) -->
	        <h2 class="page_title"><span id="title"></span></h2>
	        <!-- page_title(E) -->
	            
	        <!-- opus_design_btn(S) -->
	        <div class="opus_design_btn">
	            <button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button>
				<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
	        </div>
	        <!-- opus_design_btn(E) --> 
	    </div>
	    <!-- page_title_area(E) -->
	</div>
	<!-- layer_popup_title(E) -->


	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
		<div class="wrap_search" >
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
			    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <table>
			         <colgroup>
			            <col width="60px" />
			            <col width="*" />
			        </colgroup> 
					<tbody>
						<tr>
							<th>Tariff Code</th>
							<td>
								<input type="text" style="width:200;text-align:center" name="tariff_cd" readonly value="" class="input2">
							</td>
						</tr>
						<tr>
							<th>Inland Rates Name</th>
							<td>
								<input type="text" style="width:200;text-align:center" name="inland_nm" readonly value="" class="input2">
							</td>
						</tr>
					</tbody>
				</table>
			    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		
		<div class="wrap_result" >
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  id="mainTable">
			    
			    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet1');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
			<!-- opus_design_grid(E) -->
		</div>
			
	</div>
	<!-- popup_contens_area(E) -->
</form>
