<%--
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0020.jsp
*@FileTitle  : Available Off Hire Q'ty List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0023Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.lsecommon.event.EesLseComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0023Event  event      = null;		    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
    DBRowSet rowSet             = null;
	String strErrMsg            = "";			//error message
	int rowCount	            = 0;			//count of DB resultSET list

	String pageRows           = "100";	
	String strEqLocTpCd       = "";
    String strLocCd           = "";
    String strEqLocTpNm       = "";
	SignOnUserAccount account = null;
	String returnval          = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returnrow          = ((request.getParameter("returnrow")==null )?"":request.getParameter("returnrow"));
    Logger log                = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesLse0023Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
  
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		strEqLocTpCd = JSPUtil.getNull(request.getParameter("eq_loc_tp_cd"));
		strEqLocTpNm = JSPUtil.getNull(request.getParameter("eq_loc_tp_nm"));
		strLocCd = JSPUtil.getNull(request.getParameter("loc_cd"));

		//getting data from server when load the initial screen
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
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">   
<input type="hidden" name="pagerows" id="pagerows">      
<input type="hidden" name="eq_loc_tp_cd" id="eq_loc_tp_cd" value="<%=strEqLocTpCd%>"> 
<input type="hidden" name="eq_loc_tp_nm" id="eq_loc_tp_nm" value="<%=strEqLocTpNm%>"> 
<input type="hidden" name="loc_cd" id="loc_cd" value="<%=strLocCd%>"> 
<input type="hidden" name="returnval"  id="returnval" value="<%=returnval%>" />     
<input type="hidden" name="returnrow"  id="returnrow" value="<%=returnrow%>" />                    
<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
     <h2 class="page_title">Place Selection</h2> 
    <!-- page_title(E) -->
    <!-- opus_design_btn (S) -->
     <div class="opus_design_btn"><!-- 
            --><button class="btn_normal" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--  
            --><button class="btn_normal" name="btn_rowdelete" id="btn_rowdelete" type="button">Row Delete</button><!--  
            --><button class="btn_normal" name="btn_select" id="btn_select" type="button">Select</button><!--  
            --><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
     </div>
      <!-- page_location(S) -->
</div>
<!-- page_title_area(E) --> 
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    
    <!-- opus_design_inquiry(E) -->
</div>  
<div class="wrap_result">
<!-- opus_design_grid(S) -->
    <div class="opus_design_grid" id="mainTable">
       
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>    
    <!-- opus_design_grid(E) -->
</div>
</form>