<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0035.jsp
*@FileTitle  : OceanRoute Manual Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0035Event"%>
<%
	EsdPrd0035Event  event = null;		

	Exception serverException   = null;	
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	try {
		event = (EsdPrd0035Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String pol_cont_cd = JSPUtil.getNull(event.getPolContCd());
	String pod_cont_cd = JSPUtil.getNull(event.getPodContCd());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="pol_cont_cd" value="<%=pol_cont_cd%>" id="pol_cont_cd" />
<input type="hidden" name="pod_cont_cd" value="<%=pod_cont_cd%>" id="pod_cont_cd" />

<div class="page_title_area clear">
	<h2 class="page_title"><span>Ocean Route Creation - Manual Creation</span></h2>
    <div class="opus_design_btn">
		    	<button type="button" class="btn_accent" name="btn_ok" id="btn_ok">Ok</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
    </div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" >		
		 <div class="opus_design_btn">
				<button class="btn_normal" type="button"  sname="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
			 --><button class="btn_normal" type="button"  name="btng_rowcopy" id="btng_rowcopy">Row Copy</button><!-- 
			 --><button class="btn_normal" type="button"  name="btng_rowdel" id="btng_rowdel">Row Del</button>
		</div>		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>