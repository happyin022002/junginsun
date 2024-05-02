<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4016.jsp
*@FileTitle  : Upload Excel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.surcharge.event.EsmPri4016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>

<%
	EsmPri4016Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Surcharge.Surcharge");
	String svcScpCd		= JSPUtil.getNull(request.getParameter("svc_scp_cd"));
	String chgCd		= JSPUtil.getNull(request.getParameter("chg_cd"));
	String fltPctTpCd	= JSPUtil.getNull(request.getParameter("flt_pct_tp_cd"));
	String pctBseCd		= JSPUtil.getNull(request.getParameter("pct_bse_cd"));
	String[] scgImdgClssCd = null;
	String[] orgTrspModCd = null;
	String[] destTrspModCd = null;
	String[] usaSvcModCd = null;
	String[] prcRcvTermCd = null;
	String[] prcDeTermCd = null;
	String[] prcHngrBarTpCd = null;
	String[] payTermCd = null;
	String[] ratUtCd = null;
	String[] prcCgoTpCd = null;
	String[] currCd = null;
	String[] dirCallFlg = null;
	String[] socFlg = null;
	String[] ioGaCd = null;
	String[] subTrdCd = null;
	String[] cnlTzCd = null;
	String templateKey = null;
	String[] bkgEsvcTpCd = null;    	//B/I
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri4016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		scgImdgClssCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scgImdgClssCd"),true,"|","\t","getCode","getName");
		orgTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgTrspModCd"), false,"|","\t","getCode","getName");
		destTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("destTrspModCd"), false,"|","\t","getCode","getName");
		usaSvcModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usaSvcModCd"), false,"|","\t","getCode","getName");
		prcRcvTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcRcvTermCd"), false,"|","\t","getCode","getName");
		prcDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcDeTermCd"), false,"|","\t","getCode","getName");
		prcHngrBarTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcHngrBarTpCd"), false,"|","\t","getCode","getName");
		payTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("payTermCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false,"|","\t");
		dirCallFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dirCallFlg"), false,"|","\t","getCode","getName");
		socFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("socFlg"), false,"|","\t","getCode","getName");
		ioGaCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ioGaCd"), false,"|","\t","getCode","getName");
		subTrdCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("subTrdCd"), true,"|","\t");
		cnlTzCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cnlTzCd"), false,"|","\t","getCode","getName");
		bkgEsvcTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false,"|","\t","getCode","getName");
		templateKey = (String)eventResponse.getCustomData("templateKey");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var scgImdgClssCdComboValue = "<%=scgImdgClssCd[0]%>";
	var scgImdgClssCdComboText = "<%=scgImdgClssCd[1]%>";
	var orgTrspModCdValue = " |<%=orgTrspModCd[0]%>";
	var orgTrspModCdText = " |<%=orgTrspModCd[1]%>";
	var destTrspModCdValue = " |<%=destTrspModCd[0]%>";
	var destTrspModCdText = " |<%=destTrspModCd[1]%>";
	var usaSvcModCdValue = " |<%=usaSvcModCd[0]%>";
	var usaSvcModCdText = " |<%=usaSvcModCd[1]%>";
	var prcRcvTermCdValue = " |<%=prcRcvTermCd[0]%>";
	var prcRcvTermCdText = " |<%=prcRcvTermCd[1]%>";
	var prcDeTermCdValue = " |<%=prcDeTermCd[0]%>";
	var prcDeTermCdText = " |<%=prcDeTermCd[1]%>";
	var prcHngrBarTpCdValue = " |<%=prcHngrBarTpCd[0]%>";
	var prcHngrBarTpCdText = " |<%=prcHngrBarTpCd[1]%>";
	var payTermCdValue = " |<%=payTermCd[0]%>";
	var payTermCdText = " |<%=payTermCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	var scgImdgClssCdValue = " |<%=scgImdgClssCd[0]%>";
	var scgImdgClssCdText = " |<%=scgImdgClssCd[1]%>";
	var currCdValue = " |<%=currCd[0]%>";
	var currCdText = " |<%=currCd[1]%>";
	var dirCallFlgValue = "<%=dirCallFlg[0]%>";
	var dirCallFlgText = "<%=dirCallFlg[1]%>";
	var socFlgValue = "<%=socFlg[0]%>";
	var socFlgText = "<%=socFlg[1]%>";
	var ioGaCdValue = "<%=ioGaCd[0]%>";
	var ioGaCdText = "<%=ioGaCd[1]%>";
	var subTrdCdValue = " |<%=subTrdCd[0]%>";
	var subTrdCdText = " |<%=subTrdCd[1]%>";
	var cnlTzCdValue = " |<%=cnlTzCd[0]%>";
    var cnlTzCdText = " |<%=cnlTzCd[1]%>";
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cd" name="cd" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" value="<%=svcScpCd%>" type="hidden" />
<input id="chg_cd" name="chg_cd" value="<%=chgCd%>" type="hidden" />
<input id="flt_pct_tp_cd" name="flt_pct_tp_cd" value="<%=fltPctTpCd%>" type="hidden" />
<input id="pct_bse_cd" name="pct_bse_cd" value="<%=pctBseCd%>" type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Surcharge Creation - Load Excel</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_openfile" name="btn_openfile" class="btn_normal">Open File</button>
		<button type="button" id="btn_check" name="btn_check" class="btn_normal">Check</button>
		<button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button>
		<button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
    <div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
    <div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
</div>
</form>
<form name="downform" id="downform" action="/opuscntr/FileDownload" method="post" target="downifm">
	 <input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>