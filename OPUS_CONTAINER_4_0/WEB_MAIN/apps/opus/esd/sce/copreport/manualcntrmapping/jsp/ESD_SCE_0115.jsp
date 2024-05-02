<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CESD_SCE_0115.jsp
*@FileTitle  : Manual Container Mapping 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@page import="com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.event.EsdSce0115Event"%>
<%@page import="com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.event.EsdSce0115EventResponse"%>
<%
	EsdSce0115Event			event			= null; //PDTO(Data Transfer Object including Parameters)
	EsdSce0115EventResponse	eventResponse	= null;	//RDTO(Data Transfer Object including DB ResultSet)
    Exception					serverException = null;	//

	String strErrMsg = "";                             	//

    try {
        event = (EsdSce0115Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            eventResponse = (EsdSce0115EventResponse)request.getAttribute("EventResponse");
        } // end else
    }catch(Exception e) {
    	out.println(e.getMessage()) ;
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="txtmapgofccd">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="dbtn_retrieve" id="dbtn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="dbtn_new" id="dbtn_new">New</button><!--
		 --><button type="button" class="btn_normal" name="dbtn_save" id="dbtn_save">Save</button>
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <tbody>
				<tr>
					<td><h3 class="title_design">Container UnMapping</h3></td>
				</tr>
				<tr>
					<td width="40">
						<input type="radio" name ="selection" id="selection" value ="bkg_no" class="trans" checked><label for="selection">BKG_No.</label>
						<input type="text" name="bkg_no" id="bkg_no" class="input" style="width:120px; text-transform:uppercase;" onBlur='javascript:this.value=this.value.toUpperCase();'>
					</td>
					<td width="40">
						<input type="radio" name ="selection" id="selection"value ="cntr_no" class="trans"><label for="selection">Container No.</label>
						<input name="cntr_no_txt" type="text" class="input" style="width:100px; text-transform:uppercase;" maxlength="11" onKeyUp="this.value=this.value.toUpperCase()" onBlur='javascript:this.value=this.value.toUpperCase();'>
					</td>
					<td width="">
						<table class="search" style="width:100%;">
							<tr class="h23">
								<td align="center" width="160">
									<input type="radio" name ="selection" id="selection" value ="bkgcrt_dt" class="trans"><label for="selection">Booking Create Date</label>
								</td>
								<td width="75" >
									<input name="bkgcrt_fm_dt" type="text" class="input" style="width:70px; text-transform:uppercase;"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;
								</td>
								<td width="70" >
									<input  maxlength="10"  name="bkgcrt_to_dt" type="text" class="input" style="width:70px; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
								</td>
								<td width="" >
									<button type="button" class="calendar ir" name="btn_bkg_calendar" id="btn_bkg_calendar"></button>								
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<h3 class="title_design pad_btm_8">COP-HDR Mapping</h3><br/>
		    <script type="text/javascript">ComSheetObject('sheet2');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
		<!-- page(E) -->
	</div>
</form>