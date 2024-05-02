<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_9000.jsp
*@FileTitle  : BKG Cost Re-calculation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                               //에러메세지

    String strOfc_cd		= "";

    Logger log = Logger.getLogger("com.clt.apps.Common");

    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd =	account.getOfc_cd();

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        log.error("Exception : " + e.toString());
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

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input name="f_ofc_cd" type="hidden" value="<%=strOfc_cd%>" id="f_ofc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_Apply" 			id="btn_Apply">Apply</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>				
				<col width="50"/>
				<col width="80"/>
				<col width="50"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr class="h23">
                  <th>Duration</th>
                  <td><input type="text" name="f_fm_date" class="input1" style="width:80px;" maxlength="9" onkeypress="ComKeyOnlyNumber(window)" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDateDash(this);" id="f_fm_date" /><span class = "dash">~</span><input type="text" name="f_to_date" class="input1" style="width:80px;" maxlength="9" onkeypress="ComKeyOnlyNumber(window)" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDateDash(this , 4);" id="f_to_date" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
                  <th>Status</th>
                  <td><script type="text/javascript">ComComboObject('f_status',1, 100 , 0 )</script></td>                  
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <input type="text" name="f_rownum" class="input" maxlength="4" style="width:40px; float:left" style="height:17" >
			<button type="button" class="btn_accent" name="btng_RowAdd" 				id="btng_RowAdd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_RowDel" 			id="btng_RowDel">Delete</button><!-- 		
			 --><button type="button" class="btn_normal" name="btng_DownExcel" 			id="btng_DownExcel">Down Excel</button><!-- 		
			 --><button type="button" class="btn_normal" name="btng_LoadExcel" 			id="btng_LoadExcel">Load Excel</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>