<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BSA_0122.jsp
*@FileTitle  : Other Carrier's Slot Swap Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0024Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String cobCrr		= "";
	String sXml = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.BSAManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
		if (eventResponse != null) {
			cobCrr = "|"+JSPUtil.getNull(retVo.getStrTemp());
		} // end if
		//sXml 	     = JSPUtil.getNull(request.getParameter("sXml"))== null?"": JSPUtil.getNull(request.getParameter("sXml"));
		

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
		loadPage("<%=cobCrr%>");
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name = "pBsa_seq">
<input type="hidden" name = "pBsa_fm_dt">
<input type="hidden" name = "pBsa_to_dt">
<input type="hidden" name = "pVsl_capa">
<input type="hidden" name = "pBsa_op_cd">
<input type="hidden" name = "pBsa_op_jb_cd">
<input type="hidden" name = "sRow">
<!--  input type="hidden" name = "chgValueRowNo" -->
<input type="hidden" name = "sXml" value="<%= sXml %>">


<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Other Carrier's Slot Swap Information</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:570;">
				<tr class="h23">
					<th width="50px">Period</th>
					<td width="190px"><input type="text" dataformat="ymd"  style="width:75px;text-align:center" name="fm_dt" readOnly> ~
									<input type="text" dataformat="ymd"  style="width:75px;text-align:center" name="to_dt" readOnly>
					</td>
					<th width="40px">Trade</th>
					<td width="50px"><input type="text" style="width:35px;text-align:center" name="pTrd_cd" readOnly></td>
					<th width="40px">RLane</th>
					<td width="60px"><input type="text" style="width:45px;text-align:center" name="pRlane_cd" readOnly></td>
					<th width="25px">Dir</th>
					<td width="40px"><input type="text" style="width:20px;text-align:center" name="pDir_cd" readOnly></td>
					<th width="30px">OPR</th>
					<td width=""><input type="text" style="width:30px;text-align:center" name="pVop_cd" readOnly></td>
				</tr>
			</table>
		</div>
	</div>
		<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
<!-- OUTER - POPUP (E)nd -->

<script language="javascript">
<!--
	with(document.form) {
	<%
	if(event != null){
	%> 
	document.form.pBsa_seq.value	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_seq"))     == null? "": JSPUtil.getNull(request.getParameter("pBsa_seq")     )%>";
	document.form.pTrd_cd.value		 = "<%= JSPUtil.getNull(request.getParameter("pTrd_cd"))      == null? "": JSPUtil.getNull(request.getParameter("pTrd_cd")      )%>";
	document.form.pRlane_cd.value	 = "<%= JSPUtil.getNull(request.getParameter("pRlane_cd"))    == null? "": JSPUtil.getNull(request.getParameter("pRlane_cd")    )%>";
	document.form.pDir_cd.value		 = "<%= JSPUtil.getNull(request.getParameter("pDir_cd"))      == null? "": JSPUtil.getNull(request.getParameter("pDir_cd")      )%>";
	document.form.pVop_cd.value		 = "<%= JSPUtil.getNull(request.getParameter("pVop_cd"))      == null? "": JSPUtil.getNull(request.getParameter("pVop_cd")      )%>";
	document.form.pVsl_capa.value	 = "<%= JSPUtil.getNull(request.getParameter("pVsl_capa"))    == null? "": JSPUtil.getNull(request.getParameter("pVsl_capa")    )%>";
	document.form.pBsa_op_cd.value	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_op_cd"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_op_cd")   )%>";
	document.form.pBsa_op_jb_cd.value= "<%= JSPUtil.getNull(request.getParameter("pBsa_op_jb_cd"))== null? "": JSPUtil.getNull(request.getParameter("pBsa_op_jb_cd"))%>";
	document.form.pBsa_fm_dt.value	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_fm_dt"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_fm_dt")   )%>";
	document.form.pBsa_to_dt.value 	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_to_dt"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_to_dt")   )%>";
	document.form.fm_dt.value	 	 = "<%= JSPUtil.getNull(request.getParameter("pBsa_fm_dt"))   == null? "": JSPUtil.getNull(request.getParameter("pBsa_fm_dt")   )%>";
	document.form.to_dt.value 	     = "<%= JSPUtil.getNull(request.getParameter("pBsa_to_dt"))   == null || JSPUtil.getNull(request.getParameter("pBsa_to_dt")).equals("99991231")?"": JSPUtil.getNull(request.getParameter("pBsa_to_dt"))%>";
	document.form.sRow.value 	     = "<%= JSPUtil.getNull(request.getParameter("sRow"))         == null? "": JSPUtil.getNull(request.getParameter("sRow")         )%>";
	<%
	}
	%>
	ComAddSeparator (document.form.fm_dt);
	ComAddSeparator (document.form.to_dt);
	}

-->
</script>