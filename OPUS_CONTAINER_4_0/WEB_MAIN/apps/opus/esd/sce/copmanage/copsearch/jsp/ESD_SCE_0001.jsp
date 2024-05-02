<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved..
*@FileName   : ESD_SCE_0001_T.jsp
*@FileTitle  :  COP Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22 

=========================================================*/
%>

<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0001Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl();
	
	EsdSce0001Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	int rowCount	 = 0;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String userId		= "";
	String userNm		= "";
	COPInquiryVO inqVO = null;
	
	try {
	 		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId =	account.getUsr_id();
			userNm = account.getUsr_nm();

			event = (EsdSce0001Event)request.getAttribute("Event");
			inqVO = event.getConditionVO();		
			if(inqVO == null){
				inqVO = new COPInquiryVO();
			}
 
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
		loadPage();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
</script>
	<!-- TABLE '#D' : ( Button : Main ) (S) -->		
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cust_cnt_seq" id="cust_cnt_seq" />
<input type="hidden" name="cust_tp_cd" id="cust_tp_cd" />
<input type="hidden" name="pagerows" id="pagerows" value="<%=pageRows%>" />
<input type="hidden" name="page_no" value="1" id="page_no" />
<input type="hidden" name="cust_tp_cd" id="cust_tp_cd" />									
<%String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));%>

<% if("false".equals(mainPage)){  %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="title"></span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
</div>
<%}else{ %>
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>			
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<%} %>

<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry (S) -->
<div class= "opus_design_inquiry wFit">
	<table class="search_in">
		<colgroup>
			<col width="95px">
			<col width="170px">
			<col width="70px">
			<col width="160px">
			<col width="110px">
			<col width="165px">
			<col width="20px">
			<col width="*">
		</colgroup>
			<tr class="h23">
				<th>Booking No.</th>
				<td><input name="bkg_no" id="bkg_no" type="text" style="width:120px; text-transform:uppercase;" maxlength="13"   value="" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
				<th>B/L No.</th>
				<td><input name="bl_no" id="bl_no" type="text" style="width:110px ; text-transform:uppercase;" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
				<th>Container No.</th>
				<td><input name="cntr_no" id="cntr_no" type="text" value="<%=inqVO.getCntrNo()%>" style="width:100px ; text-transform:uppercase;" maxlength="11" Onkeydown="onEnterKey(this)" onBlur='javascript:this.value=this.value.toUpperCase();'>
				    <input name="cntr_no_nonbit" id="cntr_no_nonbit" type="hidden" value ="<%=inqVO.getCntrNo()%>" style="width:100px ; text-transform:uppercase;" maxlength="11" Onkeydown="onEnterKey(this)"   
						   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')"  onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')"><!--			
					    --><input id ="cntr_no_split" type="hidden" style="width:22px" maxlength="2" readonly></td>
				<th>Booking Date</th>
				<td>
					<input type="text" style="width:78px; text-transform:uppercase;" name="bkg_cre_dt1" id="bkg_cre_dt1"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >
					-
					<input type="text" style="width:78px" name="bkg_cre_dt2" id="bkg_cre_dt2"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" ><!-- 
					--><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>				
<!-- 				<img name="btns_calendar1" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td> -->
				</td>
			</tr>
		</table>
		<table class="search_in">
			<colgroup>
				<col width="96px">
				<col width="170px">
				<col width="70px">
				<col width="160px">
				<col width="110px">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>S/O No.</th>
				<td><input name="so_no" id="so_no" type="text" style="width:120px; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
				<th>COP No.</th>
				<td><input name="cop_no" id="cop_no" type="text" style="width:110px; text-transform:uppercase;" maxlength="14"  Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
				<th>Reference No.</th>
				<td><input name="ref_no" id="ref_no" type="text" style="width:100px; text-transform:uppercase;" maxlength="50" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>

			</tr> 
	</table>
</div>
<!-- opus_design_inquiry (E) -->
<input type="hidden" name="row_size" id="row_size" value="<%=pageRows%>">
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_mastersave" id="btn_mastersave">M / S</button><!--
		--><button type="button" class="btn_normal" name="btn_statuschange" id="btn_statuschange">Status Change</button><!--
		--><button type="button" class="btn_normal" name="btn_bkginfo" id="btn_bkginfo">BKG Info</button><!--
		--><button type="button" class="btn_normal" name="btn_copchange" id="btn_copchange">COP Change</button><!--
		--><button type="button" class="btn_normal" name="btn_history" id="btn_history">COP History</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
	<!-- opus_design_btn(e) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>	
<div id="new_form_div"></div>
