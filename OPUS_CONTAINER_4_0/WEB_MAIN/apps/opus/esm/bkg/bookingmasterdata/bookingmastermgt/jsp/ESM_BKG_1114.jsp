<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1114.jsp
*@FileTitle  : ZIP Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1114Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1114Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmBkg1114Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//log.debug("====================================");
	//	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//	screenName = screen.getName();
	//	log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	//set condition initial values
  	String zipCodeFunc       = JSPUtil.getNull(request.getParameter("func"));
  	String zipCode   		 = JSPUtil.getNull(request.getParameter("zip_cd"));
  	String cntCd			 = JSPUtil.getNull(request.getParameter("cnt_cd"));
  	String mainPage 		 = JSPUtil.getNull(request.getParameter("mainPage"));
%>
<script type="text/javascript">

<%
	if(!zipCodeFunc.equals("")) {
%>
	if(!opener)
	opener = window.dialogArguments;
	
	if (!opener)  opener=window.opener;  //이 코드 추가할것
	if (!opener) opener=parent; //이 코드 추가할것 
	var callbackMethod = opener.<%= zipCodeFunc%>;
<%
	} else{
%>
	var callbackMethod = null; 
<%
	}
%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		ComSetObjValue(document.form.screenName,"<%=screenName%>");  
		loadPage();
		
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="screenName" id="screenName" />
<!-- Developer Work	-->
<input type="hidden" name="sheet1_user_id" value="<%= strUsr_id %>" id="sheet1_user_id" />
<input type="hidden" name="sheet1_ofc_cd" value="<%= strOfc_cd %>" id="sheet1_ofc_cd" />
<input type="hidden" name="sheet1_cnt_cd" value="<%= cntCd %>" id="sheet1_cnt_cd" />

 
<%
	if(mainPage.equals("true")){
%> 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
<!-- page_title(S) -->
<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->

<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_New" 	 	id="btn_New">New</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_Save" 	  	id="btn_Save">Save</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_down_excel" 	id="btn_down_excel">Down Excel</button>			
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

<%
	} else {
%>
	<!-- popup_title_area(S) -->
	 <div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Zip Code Inquiry</span></h2>
			<!-- page_title(E) -->
					
			 <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		        <button type="button" class="btn_accent" name="btn_Retrieve"   id="btn_Retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_New" 	   id="btn_New">New</button><!-- 				
				 --><button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Select"	   id="btn_Select">Select</button><!-- 
	        	 --><button type="button" class="btn_normal" name="btn_close"  	   id="btn_close">Close</button>	        	
		    </div>
		    <!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->
	
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents" style="overflow:hidden;">
<%
	}
%>
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="65" />
	            <col width="200" />
	            <col width="140" />
	            <col width="300" />	            
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Country</th>
					<td><script type="text/javascript" >ComComboObject('cnt_cd', 1, 170, 1,1)</script></td>
					<td colspan="2"><input type="checkbox" name="delt_flg" value="Y" class="trans">&nbsp;&nbsp;Including Deleted Code</td>
					<td></td>
				</tr>
				<tr>
					<th>ZIP Code</th>
					<td><input type="text" name="zip_cd" style="width:100px;" class="input" value="<%=zipCode%>" dataformat="engup"></td>
					<th>Street / P.O Box (Address)</th>
					<td><input type="text" name="zip_dtl_addr" style="width:300px;" class="input" value="" dataformat="engup"></td>
					<td></td>
				</tr>
				<tr>
					<th>City</th>
					<td><input type="text" name="cty_nm"  style="width:100px;" class="input" value="" dataformat="engup"></td>
					<th>State</th>
					<td><input type="text" name="ste_nm"style="width:200px;" class="input" value="" dataformat="engup"></td>
					<td></td>					
				</tr>
			</tbody>
		</table>
	</div>
</div>	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
	<%
	if(mainPage.equals("true")){
	%>				
		<!-- opus_grid_btn(S) -->
         <div class="opus_design_btn">
             <button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!-- 
              --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
              --><button type="button" class="btn_normal" name="btn_Load_Excel" id="btn_Load_Excel">Excel Import</button>
         </div>
         <!-- opus_grid_btn(E) -->
	<%
	}
	%>				            
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>	
	
	<%
	if(!mainPage.equals("true")){
	%>	
		<script>
		if(typeof(document.getElementById("title")) != "undefined"){
			document.getElementById("title").innerHTML = curTitle;
			document.body.className ="popup_bg";
		}
		</script>	
	</div>	
	<%
	}
	%>
	
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>