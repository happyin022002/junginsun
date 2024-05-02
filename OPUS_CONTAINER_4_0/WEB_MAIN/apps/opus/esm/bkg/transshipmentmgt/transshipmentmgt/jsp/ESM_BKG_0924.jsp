<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0924.jsp
*@FileTitle : Yard Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0924Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>

<%
	EsmBkg0924Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB ResultSet

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    TSRemainListInputVO tSRemainListInputVO = null;
	String strLoc_cd = "";
	String strLoc_Yd_cd =""; 
    String strVps_etb_dt = "";
	String strVps_etd_dt = "";
	String strCnmv_sts_cds = "";
    String strCntr_tpsz_cds = "";
	String strVps_eta_dt = "";
	String strNext_vvd = "";
	String strYmd="";

	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0924Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        tSRemainListInputVO = event.getTSRemainListInputVO();
		strLoc_cd=tSRemainListInputVO.getLocCd(); 
		strLoc_Yd_cd = tSRemainListInputVO.getLocYdCd();
		strVps_etb_dt = tSRemainListInputVO.getVpsEtbDt();
		strVps_etd_dt = tSRemainListInputVO.getVpsEtdDt();
		strCnmv_sts_cds = tSRemainListInputVO.getCnmvStsCds();
		strCntr_tpsz_cds = tSRemainListInputVO.getCntrTpszCds();
		strVps_eta_dt = tSRemainListInputVO.getVpsEtaDt();
		strNext_vvd = tSRemainListInputVO.getNextVvd();

		Date curDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		strYmd=cal.get(Calendar.YEAR)+"-"+((String.valueOf(cal.get(Calendar.MONTH)+1)).length()<2 ? "0"+(cal.get(Calendar.MONTH)+1):cal.get(Calendar.MONTH)+1 ) +"-"+cal.get(Calendar.DATE);

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="loc_cd" value="<%=strLoc_cd%>" id="loc_cd" />
<input type="hidden" name="loc_yd_cd" value="<%=strLoc_Yd_cd%>" id="loc_yd_cd" />
<input type="hidden" name="vps_etb_dt" value="<%=strVps_etb_dt%>" id="vps_etb_dt" />
<input type="hidden" name="vps_etd_dt" value="<%=strVps_etd_dt%>" id="vps_etd_dt" />
<input type="hidden" name="cnmv_sts_cds" value="<%=strCnmv_sts_cds%>" id="cnmv_sts_cds" />
<input type="hidden" name="cntr_tpsz_cds" value="<%=strCntr_tpsz_cds%>" id="cntr_tpsz_cds" />
<input type="hidden" name="vps_eta_dt" value="<%=strVps_eta_dt%>" id="vps_eta_dt" />
<input type="hidden" name="next_vvd" value="<%=strNext_vvd%>" id="next_vvd" />

 <div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>T/S Remain Status by Location_Yard Summary</span></h2>
			
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table> 
				<tbody>
					<tr>
						<th width="40">Date : </th>
						<td><%=strYmd%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>