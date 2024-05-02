<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0067.jsp
*@FileTitle  : Vessel SKD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0067Event"%>
<%

	Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.jsp.EsdSce0067");

    EsdSce0067Event  event = null;                //PDTO(Data Transfer Object including Parameters)

    Exception serverException   = null;            //error from server
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //error message
    int rowCount     = 0;                                  //count of DB resultSET list
    String edi_grp_cd = JSPUtil.getNull(request.getParameter("edi_grp_cd"));
    String diff = JSPUtil.getNull(request.getParameter("diff"));

    log.info("\n ESD_SCE_0067.jsp:"+edi_grp_cd);



        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if( serverException == null ) {
			log.info("serverException null");
		} else {
			log.info("serverException not null");

		}
//
//			log.info("serverException 1");
//
//        out.println("step 1");
        if (serverException != null && serverException.getMessage() != null ) {
		    strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="edi_grp_cd" value="<%=edi_grp_cd%>" id="edi_grp_cd" />
<input type="hidden" name="diff" value="<%=diff%>" id="diff" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">EDI Status</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">Ok</button><!--  
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>


 <%@include file="../jsp/common.jsp"%>