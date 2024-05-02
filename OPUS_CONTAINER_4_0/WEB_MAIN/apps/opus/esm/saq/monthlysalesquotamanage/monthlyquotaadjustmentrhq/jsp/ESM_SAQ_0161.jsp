<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0161.jsp
*@FileTitle  : Monthly Quota Adjustment - Excel Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0161Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0161Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String gline_ver_no = JSPUtil.getParameter(request, "glineVerNo"   , "");
	String mqta_step_cd = JSPUtil.getParameter(request, "mQtaStepCd"   , "");
	String bse_yr 		= JSPUtil.getParameter(request, "year"         , "");
	String bse_qtr_cd 	= JSPUtil.getParameter(request, "bse_quarter"  , "");
	String trd_cd 		= JSPUtil.getParameter(request, "trade"	       , "");
	String dir_cd 		= JSPUtil.getParameter(request, "bound"        , "");
	String mqta_ver_no 	= JSPUtil.getParameter(request, "mQtaVerNo"    , "");
	String unit     	= JSPUtil.getParameter(request, "unit"         , "");
	String inclPortFlag = JSPUtil.getParameter(request, "inclPortFlag" , "");
	
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaAdjustmentRHQ");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0161Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" id="gline_ver_no" name="gline_ver_no" value="<%=gline_ver_no%>">
<input type="hidden" id="mqta_step_cd" name="mqta_step_cd" value="<%=mqta_step_cd%>">
<input type="hidden" id="bse_yr"       name="bse_yr" value="<%=bse_yr%>">
<input type="hidden" id="bse_qtr_cd"   name="bse_qtr_cd" value="<%=bse_qtr_cd%>">
<input type="hidden" id="trd_cd"       name="trd_cd" value="<%=trd_cd%>">
<input type="hidden" id="dir_cd"       name="dir_cd" value="<%=dir_cd%>">
<input type="hidden" id="mqta_ver_no"  name="mqta_ver_no" value="<%=mqta_ver_no%>">
<input type="hidden" id="unit"         name="unit" value="<%=unit%>">
<input type="hidden" id="inclPortFlag" name="inclPortFlag" value="<%=inclPortFlag%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Excel Import/Export</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Template Download</button><!--
			--><button type="button" class="btn_normal" name="btn_excelupload" id="btn_excelupload">Load Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('rhqAdjSheet');</script>
		</div>
		<div class="opus_design_data">
			<table> 
					<tr>
						<td>
							<div>
								<textarea name="msg" border="0" cols="185" rows="5" readonly style="text-align:left;background-color:#cccccc;color:#ff0000;"></textarea>
							</div>							
						</td>
					</tr>
			</table>
		</div>
		<div class="opus_design_grid" id="hiddenLayer2" style="display:none">
			<script language="javascript">ComSheetObject('rhqAdjSheet_campare');</script>
		</div>
	</div>
	
</div>

</form>