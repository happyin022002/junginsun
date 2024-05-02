<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_07.jsp
*@FileTitle : e-Booking & SI Process Detail(REEFER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.24 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.12.14 정선용 [CHM-201114900-01]	RF E-BKG Vent 단위 및 Remark 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022907Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%!
    public String getCntrTpszCombo(String name, String style, String css, String script, String selectedValue, String firstOption, List<AlpsCntrTpszVO> cntrList){
        StringBuffer html = new StringBuffer("");
        int len = cntrList==null ? 0 : cntrList.size();
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"\"") + ">\n");
        html.append("<option value=\""+firstOption+"\" "+((firstOption.equals(selectedValue))? "selected" : "")+">"+firstOption+"</option>\n");
        for(int i=0;i<len;i++){
            AlpsCntrTpszVO vo = cntrList.get(i);
            html.append("<option value=\""+vo.getCntrNo()+"\" "+((vo.getCntrNo().equals(selectedValue))? "selected" : "")+" id=\""+vo.getCntrTpszCd()+"\">"+vo.getCntrNo()+"</option>\n");
        }
        html.append("</select>\n");
        return html.toString();
    }
%>
<%
	EsmBkg022907Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	List<AlpsCntrTpszVO> cntr_tpsz = null;
	List<AlpsRfVO> nisRfList = null;
	List<BkgXterRfCgoVO> xterRfList = null;
	String sXml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022907Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<AlpsCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstRfVO rfVO = (ExternalRqstRfVO) eventResponse.getCustomData("externalRqstRfVO");
		nisRfList = rfVO.getNisRfVO();
		xterRfList = rfVO.getBkgXterRfCgoVO();

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
	String cntrTpsz_cdStr=" |";
	String cntrTpsz_idStr=" |";
	for(int i=0;i<cntr_tpsz.size();i++) {
		AlpsCntrTpszVO vo = cntr_tpsz.get(i);
		//cntrTpsz_cdStr = cntrTpsz_cdStr + vo.getCntrNo() + "|";
		StringBuffer tmpBufferCd = new StringBuffer(cntrTpsz_cdStr).append(vo.getCntrNo()).append("|");
		cntrTpsz_cdStr = tmpBufferCd.toString();		
		
		//cntrTpsz_idStr = cntrTpsz_idStr + vo.getCntrTpszCd() + "|";
		StringBuffer tmpBufferId = new StringBuffer(cntrTpsz_idStr).append(vo.getCntrTpszCd()).append("|");
		cntrTpsz_idStr = tmpBufferId.toString();	
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(REEFER)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		loadCntrTpsz("<%=cntrTpsz_cdStr%>","<%=cntrTpsz_idStr%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cntr_no">
<input type="hidden" name="cmdt_cd">
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="rf_nis" value="<%=(nisRfList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="rf_esvc" value="<%=(xterRfList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="maxXterSeq" value="<%=xterRfList.size()%>">
<input type="hidden" name="maxBkgSeq" value="<%=nisRfList.size()%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
	<tr>
		<td valign="top">
	     	<table class="search" id="mainTable" style="width:958;height:600;">
		       	<tr>
		       		<td class="bg" valign="top">
<!--향후 버튼 삭제 -->
<!-- <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_upload" id="btn_upload">Upload</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table> -->
<!--향후 버튼 삭제 -->
<script language="javascript">ComSheetObject('sheet1');</script>
						<table class="search" border="0" style="width:958;">
							<tr class="h23">
								<td width="480" valign="top">
									<table class="search" border="0">
										<tr>
											<td width="240">
												<table class="search" border="0">
													<tr><td class="title_h"></td>
														<td class="title_s">Booking Data ALPS</td></tr>
													<tr><td class="height_5"></td></tr>
												</table>
											</td>
											<td  width="240" align="right">
												<table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td>
													<td class="btn2" name="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
													<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table class="search_ssm" border="0" style="width:480;">
									<tr class="h23">
										<td>
											<table class="search" border="0">
												<tr class="h23">
													<td width="30"></td>
													<td width="80">Booking No.</td>
													<td width="">&nbsp;
														<input type="text" name="bkg_no2" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readonly="readonly"></td>
												</tr>
											</table>
<%
	int seq = 0;
	String tempMeas1 = "+";
	String tempMeas2 = "+";
	float cdoTemp = 0;
	float fdoTemp = 0;
	String htmlClass=null;
	String htmlReadOnly=null;
	String htmlDisabled=null;
	for (int i=0;i<nisRfList.size();i++) {
		seq = i+1;
		AlpsRfVO nisRfVO = (AlpsRfVO) nisRfList.get(i);
		if ( nisRfVO.getCdoTemp().indexOf("-") != -1 ) {
			tempMeas1 = "-";
			cdoTemp = Float.valueOf(nisRfVO.getCdoTemp().substring(1, nisRfVO.getCdoTemp().length()));
		} else {
			tempMeas1 = "+";
			cdoTemp = Float.valueOf(nisRfVO.getCdoTemp());
		}
		if ( nisRfVO.getFdoTemp().indexOf("-") != -1 ) {
			tempMeas2 = "-";
			fdoTemp = Float.valueOf(nisRfVO.getFdoTemp().substring(1, nisRfVO.getFdoTemp().length()));
		} else {
			tempMeas2 = "+";
			fdoTemp = Float.valueOf(nisRfVO.getFdoTemp());
		}
		htmlClass=( "Approved".equals(nisRfVO.getStatus()) || "Rejected".equals(nisRfVO.getStatus()) || "Requested".equals(nisRfVO.getStatus()))?"input2":"input";
		htmlReadOnly=( "Approved".equals(nisRfVO.getStatus()) || "Rejected".equals(nisRfVO.getStatus()) || "Requested".equals(nisRfVO.getStatus()))?"readOnly":"";
		htmlDisabled=( "Approved".equals(nisRfVO.getStatus()) || "Rejected".equals(nisRfVO.getStatus()) || "Requested".equals(nisRfVO.getStatus()))?"disabled":"";
%>
											<div id="table_<%=seq%>">
											<table id="table<%=seq%>" class="search" border="0">
												<tr class="h23">
													<td width="30" valign="top" rowspan="5">
													<input type="hidden" name="cntr_no_cmpr__<%=seq%>" value="<%=nisRfVO.getCntrNo()%><%=nisRfVO.getRcSeq()%>">
													<input type="text" name="cntr_seq__<%=seq%>" style="width:25;text-align:center;" class="input" value="<%=seq%>" readOnly="readonly">
													<input type="hidden" name="rc_seq__<%=seq%>" value="<%=nisRfVO.getRcSeq()%>">
													</td>
													<td width="80">CNTR No.</td>
													<td width="180">&nbsp;
<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
													<input type="text" name="cntr_no__<%=seq%>" style="width:105;" maxlength="11" dataformat="etc" class="<%=htmlClass%>" value="<%=nisRfVO.getCntrNo()%>" <%=htmlReadOnly%>>
<%	} else { 	%>
													<%=getCntrTpszCombo("cntr_no__"+String.valueOf(seq).toString(), "width:105;", htmlClass, "changeCntrNo(this,'"+seq+"')", nisRfVO.getCntrNo(), "", cntr_tpsz)%>
<%	}	%>													
													<input type="text" name="cntr_tpsz_cd__<%=seq%>" style="width:40;" maxlength="2" dataformat="etc" class="<%=htmlClass%>" value="<%=nisRfVO.getCntrTpszCd()%>" <%=htmlReadOnly%>>
													</td>
													<td width="60">Status</td>
													<td width="" colspan="2"><input type="text" name="status__<%=seq%>" style="width:95;" class="input2" value="<%=nisRfVO.getStatus()%>" readOnly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="80">Commodity</td>
													<td colspan="4">&nbsp;&nbsp;<input type="text" name="cmdt_cd__<%=seq%>" caption="Commodity" style="width:90;" maxlength="10" dataformat="etc" class="<%=htmlClass%>" onChange="javascript:changeCmdtDesc(this);" value="<%=nisRfVO.getCmdtCd()%>" <%=htmlReadOnly%>>
													<%
	if ( "Approved".equals(nisRfVO.getStatus()) || "Rejected".equals(nisRfVO.getStatus()) ) {
%>
<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
<%
} else {
%>
<a href="javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__<%=seq%>.value, '<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a>
<%
}
%>
<input type="text" name="cmdt_desc__<%=seq%>" maxlength="4000" style="width:190;" class="<%=htmlClass%>" dataformat="etc" value="<%=nisRfVO.getCmdtDesc()%>" <%=htmlReadOnly%>></td>
												</tr>
												<tr class="h23">
													<td>Temperature</td>
													<td width="180" class="stm">&nbsp;
													  <select name="temperature1__<%=seq%>" class="<%=htmlClass%>" style="width:33;text-align:center;" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlDisabled%>>
													    <option value="-" <%=("-".equals(tempMeas1))?"selected":""%>>-</option>
													    <option value="+" <%=("+".equals(tempMeas1))?"selected":""%>>+</option>
													  </select>
													  <input type="text" name="cdo_temp__<%=seq%>" dataformat="float" pointcount="1" maxlength="4" style="width:33;text-align:right;display:" class="<%=htmlClass%>" value="<%=cdoTemp%>" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlReadOnly%>>&nbsp;C
													  <select name="temperature2__<%=seq%>" class="<%=htmlClass%>" style="width:33;text-align:center;" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlDisabled%>>
													    <option value="-" <%=("-".equals(tempMeas2))?"selected":""%>>-</option>
													    <option value="+" <%=("+".equals(tempMeas2))?"selected":""%>>+</option>
													  </select>
													  <input type="text" name="fdo_temp__<%=seq%>" dataformat="float" pointcount="1" maxlength="4" style="width:33;text-align:right;display:" class="<%=htmlClass%>" value="<%=fdoTemp%>" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlReadOnly%>>&nbsp;F
													</td>
													<td width="60">Genset</td>
													<td width="100" colspan="2">
													  <select name="pwr_spl_cbl_flg__<%=seq%>" class="<%=htmlClass%>" style="width:72;text-align:center;" <%=htmlDisabled%>>
													    <option value="Y" <%=("Y".equals(nisRfVO.getPwrSplCblFlg()))?"selected":""%>>Yes</option>
													    <option value="N" <%=("N".equals(nisRfVO.getPwrSplCblFlg()))?"selected":""%>>No</option>
													  </select>
													</td>
												</tr>
												<tr class="h23">
													<td>Ventilation</td>
													<td colspan="4" class="stm">&nbsp;
														<input type="text" name="vent_rto__<%=seq%>" style="width:40;text-align:right;" maxlength="3" dataformat="int" class="<%=htmlClass%>" value="<%=nisRfVO.getVentRto()%>" <%=htmlReadOnly%>>&nbsp;
														<select name="cntr_vent_tp_cd__<%=seq%>" style="width:80;" class="input1">
															<option value="P" <%=("P".equals(nisRfVO.getCntrVentTpCd()))?"selected":""%>>% Open</option>
															<option value="C" <%=("C".equals(nisRfVO.getCntrVentTpCd()))?"selected":""%>>CMH</option>
														</select></td>
												</tr>
												<tr class="h23">
													<td>Nature</td>
													<td width="150">&nbsp;
													  <select name="clng_tp_cd__<%=seq%>" class="<%=htmlClass%>" style="width:105;text-align:center;" <%=htmlDisabled%>>
													    <option value="C" <%=("C".equals(nisRfVO.getClngTpCd()))?"selected":""%>>Chilled</option>
													    <option value="F" <%=("F".equals(nisRfVO.getClngTpCd()))?"selected":""%>>Frozen</option>
													    <option value="S" <%=("S".equals(nisRfVO.getClngTpCd()))?"selected":""%>>Fresh</option>
													  </select>
													</td>
													<td width="60">Humidity</td>
													<td width="50" class="stm"><input type="text" name="humid_no__<%=seq%>" caption="Humidity" style="width:35;text-align:right;" maxlength="3" dataformat="int" maxnum="100" pointcount="1" class="<%=htmlClass%>" value="<%=nisRfVO.getHumidNo()%>" <%=htmlReadOnly%>>%</td>
													<td valign="bottom">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr><td class="btn2_left"></td>
<%
	if ( "Approved".equals(nisRfVO.getStatus()) || "Rejected".equals(nisRfVO.getStatus()) || "Requested".equals(nisRfVO.getStatus()) ) {
%>
									<td class="btn2" name="btn_delete<%=seq%>">Delete</td>
<script>ComBtnDisable("btn_delete<%=seq%>")</script>
<%
	} else {
%>
														<a href="javascript:btn_delete('table<%=seq%>','<%=seq%>');"><td class="btn2" name="btn_delete<%=seq%>">Delete</td></a>
<%
	}
%>
														<td class="btn2_right"></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr class="h23">
													<td>&nbsp;</td>
													<td>Remark(s)</td>
													<td colspan="3" class="stm">&nbsp;<textarea name="diff_rmk__<%=seq%>" style="width:300;height:40" class="textarea"  ><%=nisRfVO.getDiffRmk() %></textarea></td>
												</tr>	
												<tr class="height_10"><td colspan="8"></td></tr>
											</table>
											</div>
<%
	}
%>
<span id="INS_TABLES"></span>
</form>
											</td>
										</tr>
									</table>
								</td>
								<td width="12">&nbsp;</td>
								<td width="479" valign="top">
<form name="form2">
									<table class="search" border="0">
										<tr>
											<td width="240"><table class="search" border="0">
													<tr><td class="title_h"></td>
														<td class="title_s">From e- Service</td></tr>
													<tr><td class="height_5"></td></tr>
												</table>
											</td>
											<td  width="240" align="right"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_datacopytoalps">Data&nbsp;Copy&nbsp;to&nbsp;ALPS</td>
												<td class="btn2_right"></td>
												</tr>
												</table>
											</td>
											</tr>
									</table>
									<table class="search_ssm1" border="0" style="width:479;" height="100%">
										<tr class="h23"><td valign="top">
											<table class="search" border="0">
												<tr class="h23">
													<td width="30"></td>
													<td width="82">Request No.</td>
													<td width="370">&nbsp;<input type="text" name="rqst_no2" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly="readonly"></td>
												</tr>
											</table>
<%
	int seq2 = 0;
	String tempMeas21 = "+";
	String cntrVentTpCd = "";
	String cntrVentTpCdAlpsCopy = "";
	String cntrVentTpCdView = "";
	Float cdoTemp2 = null;
	for (int i=0;i<xterRfList.size();i++) {
		seq2 = i+1;
		BkgXterRfCgoVO xterRfVO = (BkgXterRfCgoVO) xterRfList.get(i);
		if (xterRfVO.getMinTemp() != null && !"".equals(xterRfVO.getMinTemp())) {
			if ( xterRfVO.getMinTemp().indexOf("-") != -1 ) {
				tempMeas21 = "-";
				cdoTemp2 = Float.valueOf(xterRfVO.getMinTemp().substring(1, xterRfVO.getMinTemp().length()));
			
			} else {
				tempMeas21 = "+";
				cdoTemp2 = Float.valueOf(xterRfVO.getMinTemp());
			}
		}
		cntrVentTpCd = JSPUtil.getNull(xterRfVO.getCntrVentTpCd());
		cntrVentTpCdAlpsCopy = (cntrVentTpCd.equals("C")? "C":"P");
		//cntrVentTpCd = (null==xterRfVO.getCntrVentTpCd()? "P":xterRfVO.getCntrVentTpCd());
%>
											<table class="search" border="0">
												<tr class="h23">
												<input type="hidden" name="cntr_no_cmpr__<%=seq2%>" style="width:88;" class="input" value="<%=xterRfVO.getCntrNo()%><%=xterRfVO.getRcSeq()%>">
													<td width="30" valign="top" rowspan="5"><input type="text" name="cntr_seq__<%=seq2%>" style="width:25;text-align:center;" class="input" value="<%=seq2%>" readOnly="readonly"></td>
													<td width="80">CNTR No.</td>
													<td width="365" colspan="3">&nbsp;
													<input type="text" name="cntr_no__<%=seq2%>" style="width:105;" class="input2" value="<%=xterRfVO.getCntrNo()%>" readOnly="readonly">
													<input type="hidden" name="rc_seq__<%=seq2%>" style="width:55;" class="input2" value="<%=xterRfVO.getRcSeq()%>" readOnly="readonly">
													<input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:55;" class="input2" value="<%=xterRfVO.getCntrTpszCd()%>" readOnly="readonly">
													</td>
												</tr>
												<tr class="h23">
													<td>Commodity</td>
													<td colspan="3">&nbsp;
													  <input type="text" name="cmdt_cd__<%=seq2%>" style="width:130;" class="input2" value="<%=xterRfVO.getCmdtCd()%>" readOnly="readonly">
													  <input type="text" name="cmdt_desc__<%=seq2%>" style="width:180;" class="input2" value="<%=xterRfVO.getCmdtDesc()%>" readOnly="readonly">
													</td>
												</tr>
												<tr class="h23">
													<td>Temperature</td>
													<td width="200">&nbsp;
													  <input type="text" name="temperature1__<%=seq2%>" style="width:40;" class="input2" value="<%=tempMeas21%>" readOnly="readonly">&nbsp;
													  <input type="text" name="min_temp__<%=seq2%>" style="width:40;text-align:right;" class="input2" value="<%=cdoTemp2==null?"":cdoTemp2%>" readOnly="readonly">&nbsp;
													  <input type="text" name="min_temp_ut_cd__<%=seq2%>" style="width:42;" class="input2" value="<%=xterRfVO.getMinTempUtCd()%>" readOnly="readonly">
													</td>
													<td width="60">Genset</td>
													<td width="130"><input type="text" name="pwr_spl_cbl_flg__<%=seq2%>" style="width:74;" class="input2" value="<%=xterRfVO.getPwrSplCblFlg()%>" readOnly="readonly"></td>
												</tr>
												<tr class="h23">
													<td>Ventilation</td>
													<td colspan="3" class="stm">&nbsp;
														<input type="text" name="vent_rto__<%=seq2%>" style="width:40;text-align:right;" class="input2" value="<%=xterRfVO.getVentRto()%>" readOnly="readonly">&nbsp;
														<input type="hidden" name="cntr_vent_tp_cd__<%=seq2%>" style="width:55;" class="input2" value="<%=cntrVentTpCd%>" readOnly="readonly">
														<input type="hidden" name="ventilation_alpscopy__<%=seq2%>" style="width:55;" class="input2" value="<%=cntrVentTpCdAlpsCopy%>" readOnly="readonly">
<%

	if("C".equals(cntrVentTpCd) || "P".equals(cntrVentTpCd)){
		cntrVentTpCdView = cntrVentTpCd.equals("C")? "CMH":"% Open";
	} else {
		cntrVentTpCdView = cntrVentTpCd;
	}

%>														
														<input type="text" name="ventilation_view__<%=seq2%>" style="width:55;" class="input2" value="<%=cntrVentTpCdView%>" readOnly="readonly">
													</td>
												</tr>
												<tr class="h23">
													<td>Nature</td>
													<td width="200">&nbsp;
														<input type="text" name="clng_tp_cd__<%=seq2%>" style="width:130;" class="input2" value="<%=xterRfVO.getClngTpCd()%>" readOnly="readonly"></td>
													<td width="60">Humidity</td>
													<td width="130" class="stm">&nbsp;<input type="text" name="humid_no__<%=seq2%>" style="width:35;text-align:right;" class="input2" value="<%=xterRfVO.getHumidNo()%>" readOnly="readonly">%</td>
												</tr>
												<tr class="h23">
													<td>&nbsp;</td>
													<td>Remark(s)</td>
													<td colspan="3" class="stm">&nbsp;<textarea name="diff_rmk__<%=seq2%>" style="width:300;height:40" class="textarea2"  readOnly><%=xterRfVO.getDiffRmk() %></textarea></td>
												</tr>												
												<tr class="height_10"><td colspan="8"></td></tr>
											</table>
<%
	}
%>
										</td></tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>	
</body>
</html>