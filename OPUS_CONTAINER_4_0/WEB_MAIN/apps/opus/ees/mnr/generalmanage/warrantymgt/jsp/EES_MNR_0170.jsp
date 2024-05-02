<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0170.jsp
*@FileTitle  : Reefer Unit Warranty Period
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/%>
   
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.event.EesMnr0170Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
  	          
<%
	EesMnr0170Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	
	String strUsr_id		= "";     
	String strUsr_nm		= "";    
	   
	try {  
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id(); 
		strUsr_nm = account.getUsr_nm(); 
	   
		event = (EesMnr0170Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 		
		if (serverException != null) { 
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}   
		
	}catch(Exception e) {
		out.println(e.toString()); 
	} 
%>
 
<script type="text/javascript">  
	function setupPage(){ 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage); 
		} // end if
		loadPage();
	}
</script> 
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">        
 
 <!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
	   --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>	<!--  
	  --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" id="mainTable">
		<table>
			<colgroup>
				<col width="125px">
				<col width="*">
			</colgroup> 
       		<tr>
				<th>Manufacturing Year</th>
				<td> 
				  <input required fulfill name="fm_lot_pln_yr" id="fm_lot_pln_yr" maxlength="4" type="text" style="width:50px;text-align:center;" class="input1" value="" dataformat="yyyy" cofield="to_lot_pln_yr"><!-- 
				  --><button type="button" class="calendar ir" name="dpc_yr_cal1" id="dpc_yr_cal1"></button>
				  ~
				  <input required fulfill name="to_lot_pln_yr" id="to_lot_pln_yr" maxlength="4" type="text" style="width:50px;text-align:center;" class="input1" value="" dataformat="yyyy" cofield="fm_lot_pln_yr"><!-- 
				  --><button type="button" class="calendar ir" name="dpc_yr_cal2" id="dpc_yr_cal2"></button>			    
				</td>         
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_RowDel"  	id="btn_RowDel">Row Delete</button>	
		</div>
		<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->	
</div>	
</form>