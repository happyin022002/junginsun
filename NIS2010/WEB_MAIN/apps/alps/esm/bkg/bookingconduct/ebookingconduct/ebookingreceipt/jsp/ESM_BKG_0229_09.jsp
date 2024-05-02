<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_09.jsp
*@FileTitle : e-Booking & SI Process Detail(AWKWARD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.29 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.11.08 김영철 [CHM-201006978-01] AK 화면의 Commodity 입력 포맷을 RF와 동일하게 수정하고 BKG 메인의 Commoidty 코드가 자동 I/F 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022909Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
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
	EsmBkg022909Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	List<BkgComboVO> wgt_cd = null;
	List<AlpsAkVO> alpsAkList = null;
	List<BkgXterAwkCgoVO> xterAkList = null;
	String sXml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022909Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<AlpsCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstAkVO akVO = (ExternalRqstAkVO) eventResponse.getCustomData("externalRqstAkVO");
		alpsAkList = akVO.getNisAkVO();
		xterAkList = akVO.getBkgXterAwkCgoVO();

		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");

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

	String wgt_cdStr=" |";
	String wgt_nmStr=" |";
	for(int i=0;i<wgt_cd.size();i++) {
		BkgComboVO vo = wgt_cd.get(i);
		//wgt_cdStr = wgt_cdStr + vo.getVal() + "|";
		StringBuffer tmpBufferWcd = new StringBuffer(wgt_cdStr).append(vo.getVal()).append("|");
		wgt_cdStr = tmpBufferWcd.toString();	
		
		//wgt_nmStr = wgt_nmStr + vo.getName() + "|";
		StringBuffer tmpBufferWnm = new StringBuffer(wgt_nmStr).append(vo.getName()).append("|");
		wgt_nmStr = tmpBufferWnm.toString();	
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(AWKWARD)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		loadCntrTpsz("<%=cntrTpsz_cdStr%>","<%=cntrTpsz_idStr%>");
		loadComboData("<%=wgt_cdStr%>","<%=wgt_nmStr%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cntr_no">
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="ak_nis" value="<%=(alpsAkList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="ak_esvc" value="<%=(xterAkList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="ridr_tp_cd" value ="A" >
<!-- Awkward Critera 관련 -->
<input type="hidden" name="ovr_fwrd_len" value ="" >
<input type="hidden" name="ovr_bkwd_len" value ="" >
<input type="hidden" name="ovr_hgt" value ="" >
<input type="hidden" name="ovr_lf_len" value ="" >
<input type="hidden" name="ovr_rt_len" value ="" >
<input type="hidden" name="ovr_void_slt_qty" value ="" >
<input type="hidden" name="inGauge" value ="" >


<!-- alps 쪽 A/K Rider 버튼 클릭시 -->
<div id="akRider" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:60px; margin-left:20px; height:150px; width:450px;">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:430;"> 
				<tr class="h23">

				</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('div1sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	
			</td>
		</tr>
	</table>
</div>
<div id="akRider2" style="position:absolute; visibility:hidden; z-index:1; margin-top:60px; margin-left:500px; height:150px; width:450px;">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:430;"> 
				<tr class="h23">
					</tr>
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('div2sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->	

			</td>
		</tr>
	</table>
</div>

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
													<td width="">&nbsp;<input type="text" name="bkg_no2" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readonly="readonly"></td>
													 <td colspan="2" align="right">
														<table width="100"  border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn2_left"></td>
															<td class="btn2" name="btn_akRider">A/K Rider</td>
															<td class="btn2_right"></td>
															</tr>
														</table>
												    </td>			
												</tr>
											</table>
<%
	int seq = 0;
	String htmlClass=null;
	String htmlReadOnly=null;
	for (int i=0;i<alpsAkList.size();i++) {
		seq = i+1;
		AlpsAkVO alpsAkVO = (AlpsAkVO) alpsAkList.get(i);

		htmlClass=( "Approved".equals(alpsAkVO.getStatus()) || "Rejected".equals(alpsAkVO.getStatus()) || "Requested".equals(alpsAkVO.getStatus()))?"input2":"input";
		htmlReadOnly=( "Approved".equals(alpsAkVO.getStatus()) || "Rejected".equals(alpsAkVO.getStatus()) || "Requested".equals(alpsAkVO.getStatus()))?"readOnly":"";
%>
											<div id="table_<%=seq%>">
											<table id="table<%=seq%>" class="search" border="0">
												<input type="hidden" name="awk_cgo_seq__<%=seq%>" value="<%=alpsAkVO.getAwkCgoSeq()%>">
												<tr class="h23">
													<td width="30" valign="top"><input type="text" name="cntr_seq__<%=seq%>" style="width:25;text-align:center;" class="input" value="<%=seq%>" readonly="readonly"></td>
													<td width="90">CNTR No.</td>
													<td width="180">
<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
								  					<input type="text" name="cntr_no__<%=seq%>" style="width:105;" class="<%=htmlClass%>" value="<%=alpsAkVO.getCntrNo()%>" <%=htmlReadOnly%>>
<%	} else {	%>
								  					<%=getCntrTpszCombo("cntr_no__"+String.valueOf(seq).toString(), "width:105;", htmlClass, "changeCntrNo(this,'"+seq+"')", alpsAkVO.getCntrNo(), "", cntr_tpsz)%>
<%	}	%>
								 					<input type="text" name="cntr_tpsz_cd__<%=seq%>" style="width:35;" maxlength="2" dataformat="etc" class="<%=htmlClass%>" value="<%=alpsAkVO.getCntrTpszCd()%>" readonly="readonly">
													</td>
													<td width="50">Status</td>
													<td width=""><input type="text" name="status__<%=seq%>" style="width:80;color:blue" class="input2" value="<%=alpsAkVO.getStatus()%>" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top"></td>
													<td width="80">Commodity</td>
													<td colspan="4"><input type="text" name="cmdt_cd__<%=seq%>" caption="Commodity" style="width:90;" maxlength="8" dataformat="etc" class="<%=htmlClass%>" value="<%=alpsAkVO.getCmdtCd()%>" <%=htmlReadOnly%>>
													<%
if ( "Approved".equals(alpsAkVO.getStatus()) || "Rejected".equals(alpsAkVO.getStatus()) ) {
%>
<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
<%
} else {
%>
<a href="javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__<%=seq%>.value, '<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a>
<%
}
%>
													<input type="text" name="cmdt_desc__<%=seq%>" maxlength="4000" style="width:190;" class="input2" value="<%=alpsAkVO.getCmdtNm()%>" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top"></td>
													<td width="50">Length</td>
													<td width="" class="stm"><input type="text" name="ttl_dim_len__<%=seq%>" style="width:80;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=alpsAkVO.getTtlDimLen()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
													<td width="80">Width</td>
													<td width="180" class="stm"><input type="text" name="ttl_dim_wdt__<%=seq%>" style="width:110;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=alpsAkVO.getTtlDimWdt()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="50">Height</td>
													<td width="" class="stm"><input type="text" name="ttl_dim_hgt__<%=seq%>" style="width:80;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=alpsAkVO.getTtlDimHgt()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
													<td width="50">Package</td>
													<td width="170"><input type="text" name="pck_qty__<%=seq%>" style="width:65;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=alpsAkVO.getPckQty()%>" <%=htmlReadOnly%>>
														<input type="text" name="pck_tp_cd__<%=seq%>" caption="Package Type Code" maxlength="2" style="width:35;" dataformat="eng" class="<%=htmlClass%>" value="<%=alpsAkVO.getPckTpCd()%>" <%=htmlReadOnly%>>&nbsp;<a href="javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__<%=seq%>.value, '<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="85">Gross WGT</td>
													<td width="150"><input type="text" name="grs_wgt__<%=seq%>" style="width:90;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=alpsAkVO.getGrsWgt()%>" <%=htmlReadOnly%>>&nbsp;
<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
													<input type="text" name="wgt_ut_cd__<%=seq%>" style="width:47;" class="<%=htmlClass%>" value="<%=alpsAkVO.getWgtUtCd()%>" <%=htmlReadOnly%>>
<%	} else {	%>
													<%=HTMLUtil.getComboString("wgt_ut_cd__"+seq, "width:45;", htmlClass, "",alpsAkVO.getWgtUtCd(), "", wgt_cd)%>
<%	}	%>
													</td>
													<td width="80">Net WGT</td>
													<td width="" colspan="3"><input type="text" name="net_wgt__<%=seq%>" style="width:90;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=alpsAkVO.getNetWgt()%>" <%=htmlReadOnly%>>&nbsp;
<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
													<input type="text" name="wgt_ut_cd2__<%=seq%>" style="width:47;" class="<%=htmlClass%>" value="<%=alpsAkVO.getWgtUtCd2()%>" <%=htmlReadOnly%>>
<%	} else {	%>
													<%=HTMLUtil.getComboString("wgt_ut_cd2__"+seq, "width:45;", htmlClass, "",alpsAkVO.getWgtUtCd2(), "", wgt_cd)%>
<%	}	%>
													</td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="80">Remark(s)</td>
													<td colspan="2"><textarea name="stwg_rqst_desc__<%=seq%>" dataformat="etc" class="<%=htmlClass%>" style="width:98%;height:40;" <%=htmlReadOnly%>><%=alpsAkVO.getStwgRqstDesc()%></textarea></td>
													<td width="85">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
<%
	if ( "Approved".equals(alpsAkVO.getStatus()) || "Rejected".equals(alpsAkVO.getStatus()) || "Requested".equals(alpsAkVO.getStatus()) ) {
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
											</table></td>
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
													<td width="80">Request No.</td>
													<td width="">&nbsp;<input type="text" name="rqst_no2" style="width:114;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readonly="readonly"></td>
													<td colspan="2" align="right">
														<table width="100"  border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn2_left"></td>
															<td class="btn2" name="btn_akRider2">A/K Rider</td>
															<td class="btn2_right"></td>
															</tr>
														</table>
												    </td>		
												</tr>
											</table>
<%
	int seq2 = 0;
	for (int i=0;i<xterAkList.size();i++) {
		seq2 = i+1;
		BkgXterAwkCgoVO xterAkVO = (BkgXterAwkCgoVO) xterAkList.get(i);
%>
											<table class="search" border="0">
												<input type="hidden" name="awk_cgo_seq__<%=seq2%>" value="<%=xterAkVO.getAwkCgoSeq()%>">
												<tr class="h23">
													<td width="30" valign="top"><input type="text" name="cntr_seq__<%=seq2%>" style="width:25;text-align:center;" class="input" value="<%=seq2%>" readonly="readonly"></td>
													<td width="80">CNTR No.</td>
													<td width="" colspan="3"><input type="text" name="cntr_no__<%=seq2%>" style="width:105;" class="input2" value="<%=xterAkVO.getCntrNo()%>" readonly="readonly">&nbsp;<input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:35;" class="input2" value="<%=xterAkVO.getCntrTpszCd()%>" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top"></td>
													<td>Commodity</td>
													<td colspan="3">
													  <input type="text" name="cmdt_cd__<%=seq2%>" style="width:130;" class="input2" value="" readOnly="readonly">
													  <input type="text" name="cmdt_desc__<%=seq2%>" style="width:180;" class="input2" value="<%=xterAkVO.getCmdtCd()%>" readOnly="readonly">
													</td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top"></td>
													<td width="50"> Length</td>
													<td width="" class="stm"><input type="text" name="ttl_dim_len__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterAkVO.getTtlDimLen()%>" readonly="readonly">&nbsp;CM</td>
													<td width="80">Width</td>
													<td width="180" class="stm"><input type="text" name="ttl_dim_wdt__<%=seq2%>" style="width:110;text-align:right" class="input2" value="<%=xterAkVO.getTtlDimWdt()%>" readonly="readonly">&nbsp;CM</td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="50"> Height</td>
													<td width="" class="stm"><input type="text" name="ttl_dim_hgt__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterAkVO.getTtlDimHgt()%>" readonly="readonly">&nbsp;CM</td>
													<td width="50">Package</td>
													<td width=""><input type="text" name="pck_qty__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterAkVO.getPckQty()%>" readonly="readonly">&nbsp;<input type="text" name="pck_tp_cd__<%=seq2%>" style="width:45;" class="input2" value="<%=xterAkVO.getPckTpCd()%>" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="85">Gross WGT</td>
													<td width="150"><input type="text" name="grs_wgt__<%=seq2%>" style="width:90;text-align:right" class="input2" value="<%=xterAkVO.getGrsWgt()%>" readonly="readonly">&nbsp;<input type="text" name="wgt_ut_cd1__<%=seq2%>" style="width:47;" class="input2" value="<%=xterAkVO.getWgtUtCd1()%>" readonly="readonly"></td>
													<td width="85">Net WGT</td>
													<td width="" colspan="3"><input type="text" name="net_wgt__<%=seq2%>" style="width:90;text-align:right" class="input2" value="<%=xterAkVO.getNetWgt()%>" readonly="readonly">&nbsp;<input type="text" name="wgt_ut_cd2__<%=seq2%>" style="width:47;" class="input2" value="<%=xterAkVO.getWgtUtCd2()%>" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="85">Remark(s)</td>
													<td colspan="2"><textarea name="stwg_rqst_desc__<%=seq2%>" style="width:100%;height:40;" class="textarea2" readonly="readonly"><%=xterAkVO.getStwgRqstDesc()%></textarea></td>
													<td width="85"></td>
												</tr>
												<tr class="height_10"><td colspan="8"></td></tr>
											</table>
<%
	}
%> 
											</td>
										</tr>
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
<div id="awkCriteria" style="display:none">
<script language="javascript">ComSheetObject('awk_criteria');</script>
</div>
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>