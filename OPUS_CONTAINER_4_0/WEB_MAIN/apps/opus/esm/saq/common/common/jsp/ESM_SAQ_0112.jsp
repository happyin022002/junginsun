<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0112.jsp
*@FileTitle  : Regional Group Vs. Trade Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.common.common.event.EsmSaq0112Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0112Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd 	    = "";

	String rhq_cd_arg      = null;
	String rgn_ofc_cd_arg  = null;
	String ctrt_sls_cd     = JSPUtil.getParameter(request, "ctrt_sls_cd".trim(), "");

	if ( ctrt_sls_cd.equals("SLS") ){
		rhq_cd_arg     = "sls_rhq_cd";
		rgn_ofc_cd_arg = "sls_rgn_ofc_cd";
	} else {
		rhq_cd_arg     = "ctrt_rhq_cd";
		rgn_ofc_cd_arg = "ctrt_rgn_ofc_cd";
	}

	String gline_ver_no    = JSPUtil.getParameter(request, "gline_ver_no".trim(), "");
	String mqta_step_cd    = JSPUtil.getParameter(request, "mqta_step_cd".trim(), "");
	String bse_yr          = JSPUtil.getParameter(request, "bse_yr".trim(), "");
	String bse_qtr_cd      = JSPUtil.getParameter(request, "bse_qtr_cd".trim(), "");
	String trd_cd          = JSPUtil.getParameter(request, "trd_cd".trim(), "");
	String dir_cd          = JSPUtil.getParameter(request, "dir_cd".trim(), "");
	String mqta_ver_no     = JSPUtil.getParameter(request, "mqta_ver_no".trim(), "");
	String rlane_cd        = JSPUtil.getParameter(request, "rlane_cd".trim(), "");
	String sprt_grp_cd     = JSPUtil.getParameter(request, "sprt_grp_cd".trim(), "");
	String bsa_grp_cd      = JSPUtil.getParameter(request, "bsa_grp_cd".trim(), "");
	String bse_mon         = JSPUtil.getParameter(request, "bse_mon".trim(), "");
	String rhq_cd          = JSPUtil.getParameter(request, rhq_cd_arg.trim(), "");
	String rgn_ofc_cd      = JSPUtil.getParameter(request, rgn_ofc_cd_arg.trim(), "");
	String pol_cd          = JSPUtil.getParameter(request, "pol_cd".trim(), "");
	String pod_cd          = JSPUtil.getParameter(request, "pod_cd".trim(), "");
	String cre_ofc_cd      = JSPUtil.getParameter(request, "cre_ofc_cd".trim(), "");
	String saq_sts_cd      = JSPUtil.getParameter(request, "saq_sts_cd".trim(), "");

	Logger log = Logger.getLogger("com.clt.apps.common.common");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (EsmSaq0112Event)request.getAttribute("Event");
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

<body  onLoad="setupPage();">
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
<input type="hidden" name="rlane_cd" value="<%=rlane_cd%>" id="rlane_cd" />
<input type="hidden" name="sprt_grp_cd" value="<%=sprt_grp_cd%>" id="sprt_grp_cd" />
<input type="hidden" name="bsa_grp_cd" value="<%=bsa_grp_cd%>" id="bsa_grp_cd" />
<input type="hidden" name="rhq_cd" value="<%=rhq_cd%>" id="rhq_cd" />
<input type="hidden" name="bse_mon" value="<%=bse_mon%>" id="bse_mon" />

<input type="hidden" name="rgn_ofc_cd" value="<%=rgn_ofc_cd%>" id="rgn_ofc_cd" />
<input type="hidden" name="pol_cd" value="<%=pol_cd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd%>" id="pod_cd" />
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd%>" id="cre_ofc_cd" />
<input type="hidden" name="saq_sts_cd" value="<%=saq_sts_cd%>" id="saq_sts_cd" />

	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<div id="REMARKS" sheetName='trdGrpAdjSheet' colName='remarks' >
				<table class="grid_2 auto" style="width:400px;">
					<colgroup>
						<col width="70" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th style="text-align:center;"><strong>Subject</strong></th>
							<td><input type="text" id="subject" class="noinput" style="width:100%; height:21px;" /> </td>
						</tr>
						<tr>
							<th style="text-align:center;"><strong>Content</strong></th>
							<td>
								<div>
									<textarea id="contents" class="noinput" style="width:100%;resize:none; height:100px;"></textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table style="width:400px;border-collapse: collapse; border:1px solid #A3A4C7;background-color:#ffffff;">
					<tr><td><DIV style="OVERFLOW-Y: scroll; OVERFLOW-X: auto; WIDTH: 100%; HEIGHT:130px;boder:1px;" id="remark"  ></DIV></td></tr>
				</table>
			</div>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div id="gridDIV"  style="display:inline;">
			<div class="opus_design_grid clear" id="mainTable" >
					<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>