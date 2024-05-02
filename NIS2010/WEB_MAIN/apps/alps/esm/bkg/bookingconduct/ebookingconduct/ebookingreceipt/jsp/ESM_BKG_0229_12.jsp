<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_12.jsp
*@FileTitle : e-Booking & SI Process Detail(Break Bulk)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : KJY
*@LastVersion : 1.0
* 2013.05.20 KJY
* 1.0 Creation
===============================================================================
 History

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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022912Event"%>
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
	EsmBkg022912Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	List<AlpsBbVO> alpsBbList = null;
	List<BkgXterBbCgoVO> xterBbList = null;
	String sXml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022912Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<AlpsCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstBbVO bbVO = (ExternalRqstBbVO) eventResponse.getCustomData("externalRqstBbVO");
		alpsBbList = bbVO.getAlpsBbVO();
		xterBbList = bbVO.getBkgXterBbCgoVO();

		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}

/*	
	String cntrTpsz_cdStr=" |";
	String cntrTpsz_idStr=" |";
	for(int i=0;i<cntr_tpsz.size();i++) {
		AlpsCntrTpszVO vo = cntr_tpsz.get(i);
		cntrTpsz_cdStr = cntrTpsz_cdStr + vo.getCntrNo() + "|";
		cntrTpsz_idStr = cntrTpsz_idStr + vo.getCntrTpszCd() + "|";
	}
*/	

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
<input type="hidden" name="ak_nis" value="<%=(alpsBbList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="ak_esvc" value="<%=(xterBbList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
	<tr>
		<td valign="top">
     		<table class="search" id="mainTable" style="width:958;height:600;">
				<tr>
					<td class="bg" valign="top">
<!--향후 버튼 삭제 >
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
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
</table>
<향후 버튼 삭제 -->
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
													<td width="">&nbsp;<input type="text" name="bkg_no2" style="width:114;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readonly="readonly"></td>
												</tr>
											</table>
<%
	int seq = 0;
	String htmlClass="";
	String htmlReadOnly="";
	for (int i=0;i<alpsBbList.size();i++) {
		seq = i+1;
		AlpsBbVO alpsBbVO = (AlpsBbVO) alpsBbList.get(i);

		htmlClass=( "Approved".equals(alpsBbVO.getStatus()) || "Rejected".equals(alpsBbVO.getStatus()) || "Requested".equals(alpsBbVO.getStatus()))?"input2":"input";
		htmlReadOnly=( "Approved".equals(alpsBbVO.getStatus()) || "Rejected".equals(alpsBbVO.getStatus()) || "Requested".equals(alpsBbVO.getStatus()))?"readOnly":"";
%>
											<div id="table_<%=seq%>">
											<table id="table<%=seq%>" class="search" border="0">
												<input type="hidden" name="bb_cgo_seq__<%=seq%>" value="<%=alpsBbVO.getBbCgoSeq()%>">
												<tr class="h23">
													<td width="30" valign="top"><input type="text" name="cntr_seq__<%=seq%>" style="width:25;text-align:center;" class="input" value="<%=seq%>" readonly="readonly"></td>
													<td width="50">Length</td>
													<td width="" class="stm"><input type="text" name="dim_len__<%=seq%>" style="width:80;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=alpsBbVO.getDimLen()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
													<td width="70">Width</td>
													<td width="" class="stm"><input type="text" name="dim_wdt__<%=seq%>" style="width:110;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=alpsBbVO.getDimWdt()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="50">Height</td>
													<td width="" class="stm"><input type="text" name="dim_hgt__<%=seq%>" style="width:80;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=alpsBbVO.getDimHgt()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
													<td width="50">Package</td>
													<td width="170"><input type="text" name="pck_qty__<%=seq%>" style="width:65;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=alpsBbVO.getPckQty()%>" <%=htmlReadOnly%>>
														<input type="text" name="pck_tp_cd__<%=seq%>" caption="Package Type Code" maxlength="2" style="width:35;" dataformat="eng" class="<%=htmlClass%>" value="<%=alpsBbVO.getPckTpCd()%>" <%=htmlReadOnly%>>&nbsp;<a href="javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__<%=seq%>.value, '<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="85">Gross WGT</td>
													<td width="150" ><input type="text" name="grs_wgt__<%=seq%>" style="width:90;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=alpsBbVO.getGrsWgt()%>" <%=htmlReadOnly%>>&nbsp;
<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
													<input type="text" name="wgt_ut_cd__<%=seq%>" style="width:47;" class="<%=htmlClass%>" value="<%=alpsBbVO.getWgtUtCd()%>" <%=htmlReadOnly%>>
<%	} else {	%>
													<%=HTMLUtil.getComboString("wgt_ut_cd__"+seq, "width:45;", htmlClass, "",alpsBbVO.getWgtUtCd(), "", wgt_cd)%>
<%	}	%>
													</td>
													
													<td width="50">Status</td>
													<td width=""><input type="text" name="status__<%=seq%>" style="width:80;color:blue" class="input2" value="<%=alpsBbVO.getStatus()%>" readonly="readonly"></td>													
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="85">Disch.side</td>
													<td width="160">
											 		 <select name="cgo_dchg_sd_cd__<%=seq%>" style="width:80;" class="<%=htmlClass%>">
											   		 	<option value="" <%=("".equals(alpsBbVO.getCgoDchgSdCd()))?"selected":""%>></option>
											    		<option value="S" <%=("S".equals(alpsBbVO.getCgoDchgSdCd()))?"selected":""%>>Sea(barge)</option>
											    		<option value="L" <%=("L".equals(alpsBbVO.getCgoDchgSdCd()))?"selected":""%>>Land</option>
											 		 </select>
													</td>
												</tr>
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="80">Remark(s)</td>
													<td colspan="2"><textarea name="diff_rmk__<%=seq%>" dataformat="etc" class="<%=htmlClass%>" style="width:98%;height:40;" <%=htmlReadOnly%>><%=alpsBbVO.getDiffRmk()%></textarea></td>
													<td width="85">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
<%
	if ( "Approved".equals(alpsBbVO.getStatus()) || "Rejected".equals(alpsBbVO.getStatus()) || "Requested".equals(alpsBbVO.getStatus()) ) {
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
												</tr>
											</table>

<%
	int seq2 = 0;
	for (int i=0;i<xterBbList.size();i++) {
		seq2 = i+1;
		BkgXterBbCgoVO xterBbVO = (BkgXterBbCgoVO) xterBbList.get(i);
%>

											<table class="search" border="0">
												<input type="hidden" name="bb_cgo_seq__<%=seq2%>" value="<%=xterBbVO.getBbCgoSeq()%>">
												<tr class="h23">
												    <td width="30" valign="top"><input type="text" name="cntr_seq__<%=seq2%>" style="width:25;text-align:center;" class="input" value="<%=seq2%>" readonly="readonly"></td>
													<td width="80"> Length</td>
													<td width="140" class="stm"><input type="text" name="dim_len__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterBbVO.getDimLen()%>" readonly="readonly">&nbsp;CM</td>
													<td width="70">Width</td>
													<td width="110" class="stm"><input type="text" name="dim_wdt__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterBbVO.getDimWdt()%>" readonly="readonly">&nbsp;CM</td>
													<td width=""></td>
												</tr>
												<tr class="h23">
													<td width="" valign="top">&nbsp;</td>
													<td width=""> Height</td>
													<td width="" class="stm"><input type="text" name="dim_hgt__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterBbVO.getDimHgt()%>" readonly="readonly">&nbsp;CM</td>
													<td width="">Package</td>
													<td width=""><input type="text" name="pck_qty__<%=seq2%>" style="width:80;text-align:right" class="input2" value="<%=xterBbVO.getPckQty()%>" readonly="readonly">&nbsp;<input type="text" name="pck_tp_cd__<%=seq2%>" style="width:45;" class="input2" value="<%=xterBbVO.getPckTpCd()%>" readonly="readonly"></td>
													<td width=""></td>
												</tr>
												<tr class="h23">
													<td width="" valign="top">&nbsp;</td>
													<td width="">Gross WGT</td>
													<td width=""><input type="text" name="grs_wgt__<%=seq2%>" style="width:90;text-align:right" class="input2" value="<%=xterBbVO.getGrsWgt()%>" readonly="readonly">&nbsp;<input type="text" name="wgt_ut_cd__<%=seq2%>" style="width:47;" class="input2" value="<%=xterBbVO.getGrsWgtUtCd()%>" readonly="readonly"></td>
													<td width="" colspan="3"></td>
												</tr>												
												<tr class="h23">
													<td width="30" valign="top">&nbsp;</td>
													<td width="85">Disch.side</td>
													<td width="160">&nbsp;<input type="text" name="cgo_dchg_sd_cd__<%=seq2%>" style="width:80;" class="input2" value="<%=xterBbVO.getCgoDchgSdCd()%>" readonly="readonly"></td>
												</tr>
												<tr class="h23">
													<td width="" valign="top">&nbsp;</td>
													<td width="">Remark(s)</td>
													<td width="210" colspan="3"><textarea name="diff_rmk__<%=seq2%>" style="width:100%;height:40;" class="textarea2" readonly="readonly"><%=xterBbVO.getDiffRmk()%></textarea></td>
													<td width=""></td>
												</tr>
												<tr class="height_10"><td colspan="6"></td></tr>
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
</form>
</body>
</html>