<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0997.jsp
*@FileTitle  : COD Comfirm Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0997Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.table.BkgCodVvdVO"%>

<%
	EsmBkg0997Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";  
	String strAsList = "";
	String strAsCode = "";
	String strAsText = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo = "";
	String strCodRqstSeq = "";
	StringBuffer strParamVvd= new StringBuffer();
	String strCodCntrNo ="";
	String strCodDg = "";
	String strCodBb = "";
	String strCodAk = "";
	String strCodRf = "";

	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.CODCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strAsList=JSPUtil.getIBCodeCombo("", "", "CD01637", 0, "");
		
		if(strAsList != null && strAsList.length() > 8) {
			strAsCode = strAsList.substring(strAsList.indexOf("Code = \"")+8, strAsList.lastIndexOf("\""));
			strAsText = strAsList.substring(strAsList.indexOf("Text = \"")+8, strAsList.indexOf("\";"));  
		}

		event = (EsmBkg0997Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		for(int i=0;i<event.getBkgCodVvdVOs().length;i++){
			strParamVvd.append("&codVslCd="+event.getBkgCodVvdVOs()[i].getVslCd());
			strParamVvd.append("&codPodClptIndSeq="+event.getBkgCodVvdVOs()[i].getPodClptIndSeq()); 
			strParamVvd.append("&codSkdVoyNo="+event.getBkgCodVvdVOs()[i].getSkdVoyNo()); 
			strParamVvd.append("&codVslSeq="+event.getBkgCodVvdVOs()[i].getVslSeq()); 
			strParamVvd.append("&codSkdDirCd="+event.getBkgCodVvdVOs()[i].getSkdDirCd());
			strParamVvd.append("&codBkgNo="+event.getBkgCodVvdVOs()[i].getBkgNo());
			strParamVvd.append("&codCodRqstSeq="+event.getBkgCodVvdVOs()[i].getCodRqstSeq());
			strParamVvd.append("&codSlanCd="+event.getBkgCodVvdVOs()[i].getSlanCd());
			strParamVvd.append("&codPolYdCd="+event.getBkgCodVvdVOs()[i].getPolYdCd());
			strParamVvd.append("&codPolClptIndSeq="+event.getBkgCodVvdVOs()[i].getPolClptIndSeq());
			strParamVvd.append("&codVslPrePstCd="+event.getBkgCodVvdVOs()[i].getVslPrePstCd());
			strParamVvd.append("&codPodYdCd="+event.getBkgCodVvdVOs()[i].getPodYdCd());
			strParamVvd.append("&codVvdOpCd="+event.getBkgCodVvdVOs()[i].getVvdOpCd()); 
		}
		
		strCodCntrNo = event.getCodCntrNo();
		strCodDg = event.getCodDg();
		strCodBb = event.getCodBb();
		strCodAk = event.getCodAk();
		strCodRf = event.getCodRf();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
  
		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
        strCodRqstSeq =JSPUtil.getNull(event.getCodRqstSeq());
		 
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
		loadPage("<%=strAsCode%>","<%=strAsText%>");
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=strBkgNo%>">
<input type="hidden" name="cod_rqst_seq" value="<%=strCodRqstSeq%>">
<input type="hidden" name="splitcount" value="2">
<input type="hidden" name="lastSplitNo">
<input type="hidden" name="memoSplitNo">
<input type="hidden" name="custSplitNo">
<input type="hidden" name="qtySplitNo">
<input type="hidden" name="cntrSplitNo">
<input type="hidden" name="dgCntrSplitNo">
<input type="hidden" name="rfCntrSplitNo">
<input type="hidden" name="akCntrSplitNo">
<input type="hidden" name="bbCntrSplitNo">
<input type="hidden" name="troSplitNo">
<input type="hidden" name="bkgsplitno">
<input type="hidden" name="codflag" value="Y">
<input type="hidden" name="bl_no">
<input type="hidden" name="tvvd">
<input type="hidden" name="por_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="stwg_cd">
<input type="hidden" name="rail_blk_cd">
<input type="hidden" name="fd_grd_flg">
<input type="hidden" name="hngr_flg">
<input type="hidden" name="hot_de_flg">
<input type="hidden" name="prct_flg">
<input type="hidden" name="stop_off_loc_cd">
<input type="hidden" name="spcl_hide_flg">
<input type="hidden" name="remark">
<input type="hidden" name="dg">
<input type="hidden" name="rf">
<input type="hidden" name="ak">
<input type="hidden" name="bb">
<input type="hidden" name="pctl_no">
<input type="hidden" name="rtn_route">
<input type="hidden" name="bdr_flag">
<input type="hidden" name="tro_flg">
<input type="hidden" name="splitFlg">
<input type="hidden" name="bkgStsCd"> 
<input type="hidden" name="paramVvd" value="<%=strParamVvd%>"> 
<input type="hidden" name="codCntrNo" value="<%=strCodCntrNo%>"> 
<input type="hidden" name="codDg" value="<%=strCodDg%>"> 
<input type="hidden" name="codBb" value="<%=strCodBb%>"> 
<input type="hidden" name="codAk" value="<%=strCodAk%>"> 
<input type="hidden" name="codRf" value="<%=strCodRf%>">  
 <!-- CA Reason hidden -->
<input type="hidden" name="ca_rsn_cd">
<input type="hidden" name="ca_remark">
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>COD Confirm</span></h2>
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tr>
				<td width="">Original Booking will be split and the selected container(s) will be moved to below BKG. Do you want to continue?
				</td></tr>
				<tr>
				<th height="5px">
				</th></tr>
			</table>
			<!-- box(S) -->		
			<table class="grid_2"> 
				<tr>
					<th width=""  colspan="4">Type of Split</th>
				</tr>
				<tr align="center">
					<td width=""  width="90"><input type="radio" value="C" class="trans" name="splitreason" checked></td>
					<td width="" class="noinput2" width="200"><input type="text" style="width:130;text-align:center" value=" Customer" class="noinput2" ></td>
					<td width=""  width="90"><input type="radio" value="M" class="trans" name="splitreason"></td>
					<td width="" class="noinput2" width="" ><input type="text" style="width:130;text-align:center" value=" Memo B/L" class="noinput2"></td>
				</tr>
			</table>	
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
		<script language="javascript">ComSheetObject('sheet2');</script><br/>
		<script language="javascript">ComSheetObject('sheet3');</script>
		<script language="javascript">ComSheetObject('sheet4');</script>
		<script language="javascript">ComSheetObject('sheet5');</script>
		<script language="javascript">ComSheetObject('sheet6');</script>
	</div>	
</div>


</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>