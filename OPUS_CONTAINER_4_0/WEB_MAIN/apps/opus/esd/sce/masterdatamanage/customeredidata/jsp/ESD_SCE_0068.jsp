<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0068.jsp
*@FileTitle  : Inquiry Vessel SKD(Common Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0068Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0068EventResponse"%>

<%
    EsdSce0068Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    EsdSce0068EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;            //Error On Server Side.
	DBRowSet rowSet      = null;                               //DB ResultSet
	String strErrMsg = "";                                 //Error Message
	int rowCount     = 0;                                  //DB ResultSet List Count
	String tp_id = JSPUtil.getNull(request.getParameter("tp_id"));

	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null && serverException.getMessage() != null ) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (EsdSce0068Event)request.getAttribute("Event");
            eventResponse = (EsdSce0068EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
        } // end else
	} catch(Exception e){
		out.println(e.toString());
	}

%>
<script type="text/javascript">

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }

</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="tp_id" value="<%=tp_id%>" id="tp_id" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Customer Select</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_ok" id="btn_ok">Ok</button><!--
		--><button class="btn_normal" type="button" name="btn_close" id="btn_close" >Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t1sheet');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->


</form>
