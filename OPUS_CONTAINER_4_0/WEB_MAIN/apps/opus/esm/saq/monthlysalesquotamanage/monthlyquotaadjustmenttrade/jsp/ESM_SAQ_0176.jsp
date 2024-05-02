<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0176.jsp
*@FileTitle  : Monthly Quota Adjustment - Excel Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0176Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0176Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSaq0176Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="gline_ver_no" value="<%=gline_ver_no%>" id="gline_ver_no" />
<input type="hidden" name="mqta_step_cd" value="<%=mqta_step_cd%>" id="mqta_step_cd" />
<input type="hidden" name="bse_yr" value="<%=bse_yr%>" id="bse_yr" />
<input type="hidden" name="bse_qtr_cd" value="<%=bse_qtr_cd%>" id="bse_qtr_cd" />
<input type="hidden" name="trd_cd" value="<%=trd_cd%>" id="trd_cd" />
<input type="hidden" name="dir_cd" value="<%=dir_cd%>" id="dir_cd" />
<input type="hidden" name="mqta_ver_no" value="<%=mqta_ver_no%>" id="mqta_ver_no" />
<input type="hidden" name="unit" value="<%=unit%>" id="unit" />
<input type="hidden" name="inclPortFlag" value="<%=inclPortFlag%>" id="inclPortFlag" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Excel Import/Export</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel"  	id="btn_DownExcel">Template Download</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_excelupload" 	id="btn_excelupload">Load Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('rhqAdjSheet');</script>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_data">
			<table>
    		    <tr>
      		    	<td>
      		    		<div>
      		    			<textarea name="msg" id="msg" cols="185" rows="5" readonly style="text-align:left;background-color:#cccccc;color:#ff0000;"></textarea>
      		    		</div>      		    		
				   </td>
			   </tr>
			</table>
		</div>
		<div class="opus_design_grid" id="hiddenLayer2" style="display:none">
			<script type="text/javascript">ComSheetObject('rhqAdjSheet_campare');</script>
		</div>
	</div>
</div>
</form>