<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0001.jsp
*@FileTitle  : Default Setting 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortSOMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();

		event = (VopPso0001Event)request.getAttribute("Event");
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
		usrOfcCd = "<%=strUsr_Ofc_cd%>";//UserOfcCD
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
<input type="hidden" name="ofc_cd">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
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

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="layout_wrap">
		
		<div class="layout_vertical_3 pad_rgt_8" style="width:30%">
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button>
					<button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet1');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
	    </div>
	    
	    <div class="layout_vertical_3 pad_rgt_8" style="width:70%">
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_Add2" id="btn_Add2">Row Add</button>
					<button type="button" class="btn_normal" name="btn_Del2" id="btn_Del2">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet2');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
	    </div>
	    
	    
	</div>

<!-- opus_design_grid(E) -->

<!-- opus_design_inquiry(S) -->

<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="90" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
                <th>Charge  Type</th>
				<td width="">
					<select name="charge_type" style="width:130px;" onChange="doSearch()" >
						<option value="0" selected>Port Charge</option>
						<option value="1">Port Service charge</option>
						<option value="2">Canal Transit Fee</option>
						<option value="3">Other</option>
					</select>
				</td>
            </tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>

<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->

	<div class="layout_wrap">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet3');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>