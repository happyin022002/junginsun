<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0042.jsp
*@FileTitle  : Total S/Days (Detail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCim0042Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<script type="text/javascript">
    function setupPage(){  
	    loadPage();
    }
</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="loc_type_code" value="<%=event.getFlaggingSDaysOptionVO().getLocTypeCode() %>" id="loc_type_code" />
<input type="hidden" name="loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getLocCd() %>" id="loc_cd" />
<input type="hidden" name="loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getCntrTpszCd() %>" id="loc_cd" />
<input type="hidden" name="dmg_flg" value="<%=event.getFlaggingSDaysOptionVO().getDmgFlg() %>" id="dmg_flg" />
<input type="hidden" name="over_stay_days" value="<%=event.getFlaggingSDaysOptionVO().getOverStayDays() %>" id="over_stay_days" />
<input type="hidden" name="cnmv_sts_cd" value="<%=event.getFlaggingSDaysOptionVO().getCnmvStsCd() %>" id="cnmv_sts_cd" />
<input type="hidden" name="uclm_ls_div_cd" value="<%=event.getFlaggingSDaysOptionVO().getUclmLsDivCd() %>" id="uclm_ls_div_cd" />
<input type="hidden" name="full_flg" value="<%=event.getFlaggingSDaysOptionVO().getFullFlg() %>" id="full_flg" />
<input type="hidden" name="lstm_cd" value="<%=event.getFlaggingSDaysOptionVO().getLstmCd() %>" id="lstm_cd" />
<input type="hidden" name="soc_cd" value="<%=event.getFlaggingSDaysOptionVO().getSocCd() %>" id="soc_cd" />
<input type="hidden" name="sub_cntr_tpsz_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubCntrTpszCd() %>" id="sub_cntr_tpsz_cd" />
<input type="hidden" name="sub_loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubLocCd() %>" id="sub_loc_cd" />
<input type="hidden" name="sub_cnmv_sts_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubCnmvStsCd() %>" id="sub_cnmv_sts_cd" />
<input type="hidden" name="mvmt_status_cd" value="<%=event.getFlaggingSDaysOptionVO().getMvmtStatusCd() %>" id="mvmt_status_cd" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Total S/Days (Detail)</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>