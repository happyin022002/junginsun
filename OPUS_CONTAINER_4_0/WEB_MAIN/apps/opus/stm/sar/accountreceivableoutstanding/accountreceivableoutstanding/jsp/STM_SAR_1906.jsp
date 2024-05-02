<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_1006.jsp // 수정
*@FileTitle  : Payment Request Letter by Customer by customer Popup
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
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1006Event"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSar1006Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String cust_code = "";
	String eml_seq = "";
	String email = "";
	String fax = "";
	String ots_smry_cd = "";
	String ar_ofc_cd = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC"); //수정

	try {
		event = (StmSar1006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		cust_code = StringUtil.xssFilter(request.getParameter("cust_code"));
		cust_code = cust_code==null?"":cust_code;

		eml_seq = StringUtil.xssFilter(request.getParameter("eml_seq"));
		eml_seq = eml_seq==null?"":eml_seq;

		email = StringUtil.xssFilter(request.getParameter("email"));
		email = email==null?"":email;

		fax = StringUtil.xssFilter(request.getParameter("fax"));
		fax = fax==null?"":fax;

		ots_smry_cd = StringUtil.xssFilter(request.getParameter("ots_smry_cd"));
		ots_smry_cd = ots_smry_cd==null?"":ots_smry_cd;

		ar_ofc_cd = StringUtil.xssFilter(request.getParameter("ar_ofc_cd"));
		ar_ofc_cd = ar_ofc_cd==null?"":ar_ofc_cd;
		
		/* 
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다. 
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다. 
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
    function setupPage(){
        loadPage();     
    }
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<input type="hidden" name="eml_seq" value="<%=eml_seq%>" id="eml_seq" />
<input type="hidden" name="cust_code" value="<%=cust_code%>" id="cust_code" />
<input type="hidden" name="fax" value="<%=fax%>" id="fax" />
<input type="hidden" name="email" value="<%=email%>" id="email" />
<input type="hidden" name="ots_smry_cd" value="<%=ots_smry_cd%>" id="ots_smry_cd" />
<input type="hidden" name="ar_ofc_cd" id="ar_ofc_cd" value="<%=ar_ofc_cd%>"/>
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Payment Request Letter by Customer</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btng_print" id="btng_print">Print</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_RD">
				<script type='text/javascript'>rdViewerObject();</script>
			</div>
		</div>
	</div>
</div>
</form>

