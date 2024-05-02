<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0044.jsp
*@FileTitle  : Car Location Message (Pop)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0044Event" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0044Event  event = null;    
		Exception serverException   = null;            			//Setting error at server side.
		String rCntrNo = JSPUtil.getNull(request.getParameter("cntr_no"));
		String tpszCd = JSPUtil.getNull(request.getParameter("tpsz_cd"));
		String strErrMsg = "";                                  //Error Message
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowSize = 50 ;
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();
    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	      }else{
	        	event = (EsdSce0044Event)request.getAttribute("Event");
	      }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>

<script type="text/javascript">
    function setupPage(){
        loadPage();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
</script>



<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="r_cntr_no" name="r_cntr_no" value="<%=rCntrNo%>" type="hidden" />
<input id="row_size" name="row_size" value="<%=rowSize%>" type="hidden" />

<div class="page_title_area clear">
	<h2 class="page_title">
		<span>Car Location Message</span>
	</h2>
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
		  <tbody>
	        <colgroup>
				<col width="40" />		
				<col width="*" />				
		   </colgroup>
		   <tr>
				<th>Container No.</th>
				<td><input id="cntr_no" name="cntr_no" class="input" style="width:90px;" readonly value="<%=rCntrNo%>" type="text" /><input id="cntr_tpsz_cd" name="cntr_tpsz_cd" class="input" style="width:30px;" readonly value="<%=tpszCd%>" type="text" /></td>
		   </tr>
		  </tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
</div>
</form>