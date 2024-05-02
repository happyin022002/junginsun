<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1051.jsp
*@FileTitle : Empty Bkg Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1051Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesEqr1051Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

    String bkgno = "";
    String vvd   = "";
    String polcd = "";
    String podcd = "";

	try {

		event = (EesEqr1051Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		EesEqr1051ConditionVO conditionVO = event.getEesEqr1051ConditionVO();
		
		bkgno	= conditionVO.getBkgno();
		vvd     = conditionVO.getVvd();
		polcd   = conditionVO.getPolcd();
		podcd   = conditionVO.getPodcd();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}

</script>

<form method="post" name="form">
<input  type="hidden" name="f_cmd">
<input  type="hidden" name="iPage">
<input  type="hidden" name="bkgno" value="<%=bkgno%>">
<input  type="hidden" name="vvd"   value="<%=vvd%>">
<input  type="hidden" name="polcd" value="<%=polcd%>">
<input  type="hidden" name="podcd" value="<%=podcd%>">
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;Container Information</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table style="width:100%;">
				<tr>
					<th width="200px" class="align_left">Bkg No : <%=bkgno%></th>
					<th class="align_left">VVD : <%=vvd%></th>
				</tr>		
			</table>	
		</div>
	</div>
  
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
