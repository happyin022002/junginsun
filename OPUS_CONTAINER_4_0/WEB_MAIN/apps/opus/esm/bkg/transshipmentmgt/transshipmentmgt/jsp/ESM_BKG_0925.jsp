<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0925.jsp
 *@FileTitle  : T/S List by 1st VSL & 2nd VSL T/S Summary 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/04
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0925Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0925Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strLoc_cd ="";
	String strLoc_yd_cd ="";
	String strSearch_kind_cd ="";
	String strDisc_load_cd ="";
	String strVps_etd_dt = "";
	String strVvd ="";
	String strPol_cd ="";
	String strPod_cd ="";
	String strDur_from ="";
	String strDur_to ="";
	String strOp_cd ="";
	String strSpecial ="";

	TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO = null;
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");
   
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0925Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		tSListBy1st2ndVVDListInputVO = event.getTSListBy1st2ndVVDListInputVO();
		strLoc_cd = tSListBy1st2ndVVDListInputVO.getLocCd();
		strLoc_yd_cd =tSListBy1st2ndVVDListInputVO.getLocYdCd();
		strSearch_kind_cd =tSListBy1st2ndVVDListInputVO.getSearchKindCd();
		strDisc_load_cd = tSListBy1st2ndVVDListInputVO.getDiscLoadCd();
		strVps_etd_dt = tSListBy1st2ndVVDListInputVO.getVpsEtdDt();
		strVvd = tSListBy1st2ndVVDListInputVO.getVvd();
		strPol_cd = tSListBy1st2ndVVDListInputVO.getPolCd();
		strPod_cd = tSListBy1st2ndVVDListInputVO.getPodCd();
		strDur_from = tSListBy1st2ndVVDListInputVO.getDurFrom();
		strDur_to = tSListBy1st2ndVVDListInputVO.getDurTo();
		strOp_cd = tSListBy1st2ndVVDListInputVO.getOpCd();
		strSpecial = tSListBy1st2ndVVDListInputVO.getSpecial();

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
<input type="hidden" name="loc_cd" value="<%=strLoc_cd%>" id="loc_cd" />
<input type="hidden" name="loc_yd_cd" value="<%=strLoc_yd_cd%>" id="loc_yd_cd" />
<input type="hidden" name="search_kind_cd" value="<%=strSearch_kind_cd%>" id="search_kind_cd" />
<input type="hidden" name="disc_load_cd" value="<%=strDisc_load_cd%>" id="disc_load_cd" />
<input type="hidden" name="vps_etd_dt" value="<%=strVps_etd_dt%>" id="vps_etd_dt" />
<input type="hidden" name="vvd" value="<%=strVvd%>" id="vvd" />
<input type="hidden" name="pol_cd" value="<%=strPol_cd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=strPod_cd%>" id="pod_cd" />
<input type="hidden" name="dur_from" value="<%=strDur_from%>" id="dur_from" />
<input type="hidden" name="dur_to" value="<%=strDur_to%>" id="dur_to" />
<input type="hidden" name="op_cd" value="<%=strOp_cd%>" id="op_cd" />
<input type="hidden" name="special" value="<%=strSpecial%>" id="special" />


<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>T/S List by 1st VSL & 2nd VSL - T/S Summary</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		  --><button type="button" class="btn_accent" name="btn_DownExcel"  id="btn_DownExcel">Down Excel</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div style="width:100%;text-align:center"><script type="text/javascript">ComComboObject('selSort', 2, 80, 1, 0, 1)</script></div>
		<div class="opus_design_grid" style= "display: none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>