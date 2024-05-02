<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_0010.jsp
*@FileTitle  : Period Closing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%-- <%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0010Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    //StmSco0010Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error occurred from server
	String strErrMsg = "";						//Error Message
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String[] applCd = null;

	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		//event = (StmSco0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		     	
		
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	 
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="90"/>
			<col width="150"/>
			<col width="80"/>
			<col width="*" />
		</colgroup>
		<tbody>
 		<tr>
			<th>Effective Date</th>
			<td>
			<input type="text" style="width:100px;text-align:center;" class="input1" name="eff_yr_mon" maxlength="6" dataformat="ym" caption="Effective Year Month" id="eff_yr_mon" /><button type="button" id="eff_yrmon_cal" name="eff_yrmon_cal" class="calendar ir"></button></td>
			<th>Application</th>
			<td><select name="prd_appl_cd" id="prd_appl_cd" style="width:100px;"class="input">
				<option value="" selected>ALL</option>
         		<option value="AP">AP</option>
         		<option value="AR">AR</option>							            							          
        	</select></td>
   		</tr>                 
    </table>
 </div>
</div>                   
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
	</div>
	<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
</form>