<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_08.jsp
*@FileTitle : e-Booking & SI Process Detail(DANGER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.25 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.01.04 김영철 [] eBooking DG Tab 화면 오류 수정
 2011.01.21 김영철 [] eBooking DG Tab 화면 오류 수정 ( Flash Point에 마이너스 값이 수동으로 입력시 입력되지 않아 수정함. )
 2011.10.05  정선용 [CHM-201113554-01]	[ALPS] E-BKG UNNO Seq 항목 추가 요청
 2011.11.14  정선용 [CHM-201114020-01]	(BASF) Dagerous Cargo MIG 로직 요청
 2011.12.06 정선용 [CHM-201114705-01]_BASF_Flat File 추가(Emergency Contact )
 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022908Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%!
    public String getCntrTpszCombo(String name, String style, String css, String script, String selectedValue, String firstOption, List<AlpsCntrTpszVO> cntrList)
	{
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
	EsmBkg022908Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	List<AlpsDgVO> nisDgList = null;
	List<BkgXterDgCgoVO> xterDgList = null;
	String sXml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022908Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<AlpsCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstDgVO dgVO = (ExternalRqstDgVO) eventResponse.getCustomData("externalRqstDgVO");
		nisDgList = dgVO.getNisDgVO();
		xterDgList = dgVO.getBkgXterDgCgoVO();

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String cntrTpsz_cdStr=" |";
	String cntrTpsz_idStr=" |";
	for(int i=0; i<cntr_tpsz.size(); i++) {
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
<title>e-Booking & SI Process Detail(DANGER)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage() {
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
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="dg_nis" value="<%=(nisDgList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="dg_esvc" value="<%=(xterDgList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="ridr_tp_cd" value ="D" >
<!-- alps 쪽 D/G Rider 버튼 클릭시 -->
<div id="dgRider" style="position:absolute; visibility:hidden; z-index:1" style="margin-top:60px; margin-left:20px; height:150px; width:450px;">	
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
<div id="dgRider2" style="position:absolute; visibility:hidden; z-index:1; margin-top:60px; margin-left:500px; height:150px; width:450px;">	
	<table cellspacing="1" cellpadding="0" bgcolor="#AAAAAA">
		<tr bgcolor="#D9E0EA">
			<td>
				<table class="search" border="0" style="width:430;"> 
				<tr class="h23">
					<!-- td width="">
						<input type="radio" name='r_ridr_tp_cd2' value="D" class="trans" onClick="fn_ridr_Tp_Change(this)" disabled checked>&nbsp;D/G Rider&nbsp;&nbsp;&nbsp;
						<input type="radio" name='r_ridr_tp_cd2' value="A" class="trans" onClick="fn_ridr_Tp_Change(this)" disabled>&nbsp;Awkward Rider&nbsp;&nbsp;&nbsp;
						<input type="radio" name='r_ridr_tp_cd2' value="B" class="trans" onClick="fn_ridr_Tp_Change(this)" disabled>&nbsp;Break Bulk Rider&nbsp;&nbsp;&nbsp;
					</td-->
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

<table width="100%" border="1" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
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
							<td class="btn1" name="btn_Upload" id="btn_Upload">Upload</td>
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
													<td width="">&nbsp;<input type="text" name="bkg_no2" style="width:114;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readonly="readonly"></td>
						                            <td colspan="2" align="right">
														<table width="100"  border="0" cellpadding="0" cellspacing="0" class="button">
															<tr><td class="btn2_left"></td>
															<td class="btn2" name="btn_dgRider">D/G Rider</td>
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
	String htmlDisabled=null;
	for (int i=0;i<nisDgList.size();i++) {
		seq = i+1;
		AlpsDgVO nisDgVO = (AlpsDgVO) nisDgList.get(i);
		htmlClass=( "Approved".equals(nisDgVO.getStatus()) || "Rejected".equals(nisDgVO.getStatus()) || "Requested".equals(nisDgVO.getStatus()))?"input2":"input";
		htmlReadOnly=( "Approved".equals(nisDgVO.getStatus()) || "Rejected".equals(nisDgVO.getStatus()) || "Requested".equals(nisDgVO.getStatus()))?"readOnly":"";
		htmlDisabled=( "Approved".equals(nisDgVO.getStatus()) || "Rejected".equals(nisDgVO.getStatus()) || "Requested".equals(nisDgVO.getStatus()))?"disabled":"";
%>
											<div id="table_<%=seq%>">
											<table id="table<%=seq%>" class="search" border="0">
												<input type="hidden" id="cntr_no_cmpr__<%=seq%>" name="cntr_no_cmpr__<%=seq%>" value="<%=getZeroLpad(nisDgVO.getDgCntrSeq())%><%=getZeroLpad(nisDgVO.getCntrCgoSeq())%><%=getZeroCnLpad(nisDgVO.getCntrNo())%>">
												<input type="hidden" name="dcgo_seq__<%=seq%>" value="<%=nisDgVO.getDcgoSeq()%>">

												<tr class="h23">
													<td width="30" valign="top"><input type="text" name="cntr_seq__<%=seq%>" style="width:25;text-align:center;" class="<%=htmlClass%>" value="<%=nisDgVO.getDgCntrSeq()%>" readonly="readonly"></td>
													<td>
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="60" colspan="2">CNTR No.</td>
															<td width="" colspan="2">&nbsp;
<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
															<input type="text" name="cntr_no__<%=seq%>" style="width:105;" maxlength="11" dataformat="etc" class="<%=htmlClass%>" value="<%=nisDgVO.getCntrNo()%>" <%=htmlReadOnly%>>
<% 	} else {	%>
															<%=getCntrTpszCombo("cntr_no__"+String.valueOf(seq).toString(), "width:105;", htmlClass, "changeCntrNo(this,'"+seq+"')", nisDgVO.getCntrNo(), "", cntr_tpsz)%>
<% 	} 	%>
													  		<input type="text" name="cntr_tpsz_cd__<%=seq%>" style="width:40;" maxlength="2" dataformat="etc" class="<%=htmlClass%>" value="<%=nisDgVO.getCntrTpszCd()%>" <%=htmlReadOnly%>></td>
															<td width="">
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														  			<tr>
														    			<td class="btn2_left"></td>
														   			 <a href="javascript:btn_Restriction('<%=seq%>');"><td class="btn2">Restriction</td></a>
														    			<td class="btn2_right"></td>
																		<td class="btn2_left"></td>
														    			<a href="javascript:btn_PreChecking('<%=seq%>');"><td class="btn2">Pre Checking</td></a>
														    			<td class="btn2_right"></td>
														 			 </tr>
										        				</table>
															</td>
														</tr>
														</table>
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="27">Seq.</td>
															<td width="40">&nbsp;<input type="text" name="cntr_cgo_seq__<%=seq%>" style="width:25;text-align:center;" class="<%=htmlClass%>" value="<%=nisDgVO.getCntrCgoSeq()%>" readonly="readonly"></td>
															<td width="48">UN No.</td>
															<td width="100"><input type="text" caption="UN No." name="imdg_un_no__<%=seq%>" style="width:40;" maxlength="4" dataformat="yy" class="<%=htmlClass%>" value="<%=nisDgVO.getImdgUnNo()%>" <%=htmlReadOnly%>>
															&nbsp;<input name="imdg_un_no_seq__<%=seq%>" value="<%=nisDgVO.getImdgUnNoSeq()%>" type="text" style="width:20;" class="input2"  readonly>
<%
	if ( "Approved".equals(nisDgVO.getStatus()) || "Rejected".equals(nisDgVO.getStatus())  || "Requested".equals(nisDgVO.getStatus())) {
%>	<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
<%
	} else {
%>
<a href="javascript:comBkgCallPop0204_position('<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a>
<%
	}
%>
															</td>
															<td width="75">&nbsp;IMDG Class</td>
															<td width="60">&nbsp;<input type="text" name="imdg_clss_cd__<%=seq%>" style="width:29;" maxlength="3" class="input2" value="<%=nisDgVO.getImdgClssCd()%>" readonly="readonly">&nbsp;<input name="imdg_comp_grp_cd__<%=seq%>" type="text" style="width:20;" class="input2"  value="<%=nisDgVO.getImdgCompGrpCd()%>" maxlength="1" readonly></td>
															<td width="">Status&nbsp;<input type="text" name="status__<%=seq%>" style="width:55;color:blue" class="input2" value="<%=nisDgVO.getStatus()%>" readonly="readonly"></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="140">Proper Shipping Name</td>
															<td width=""><input type="text" name="prp_shp_nm__<%=seq%>" style="width:298px;" class="<%=htmlClass%>" value="<%=nisDgVO.getPrpShpNm()%>" <%=htmlReadOnly%> dataformat="etc"></td>
														</tr>
														<tr class="h23">
															<td>HAZ. Contents</td>
															<td><textarea name="hzd_desc__<%=seq%>" class="<%=htmlClass%>" style="width:298px;height:40;" <%=htmlReadOnly%> dataformat="etc"><%=nisDgVO.getHzdDesc()%></textarea></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="">Flash Point</td>
															<td width="" class="stm"><input type="text" name="flsh_pnt_cdo_temp__<%=seq%>" style="width:50;text-align:right" maxlength="7" onBlur="makeComma(this.value)" dataformat="signedfloat" class="<%=htmlClass%>" value="<%=nisDgVO.getFlshPntCdoTemp()%>" <%=htmlReadOnly%>>&nbsp;C&nbsp;&nbsp;</td>
															<td width="">&nbsp;&nbsp;Packing Group</td>
															<td width="" class="stm"><input type="text" name="imdg_pck_grp_cd__<%=seq%>" style="width:30;" maxlength="1" class="input2" value="<%=nisDgVO.getImdgPckGrpCd()%>" readonly="readonly">&nbsp;&nbsp;</td>
															<td width="">Marine Pollutant</td>
															<td width="">
													 		 <select name="mrn_polut_flg__<%=seq%>" class="<%=htmlClass%>" style="width:60;" <%=htmlDisabled%>>
													    		<option value="Y" <%=("Y".equals(nisDgVO.getMrnPolutFlg()))?"selected":""%>>Yes</option>
													    		<option value="N" <%=("N".equals(nisDgVO.getMrnPolutFlg()))?"selected":""%>>No</option>
													 		 </select>
															</td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="85">Gross Weight</td>
															<td width="160" class="stm"><input type="text" name="grs_wgt__<%=seq%>" maxlength="12" dataformat="float" pointcount="3" caption="Gross Weight" style="width:80;text-align:right" onBlur="makeComma(this.value)" class="<%=htmlClass%>" value="<%=nisDgVO.getGrsWgt()%>" <%=htmlReadOnly%>>&nbsp;<input type="text" name="wgt_ut_cd__<%=seq%>" style="width:40;" class="input2" value="<%=nisDgVO.getWgtUtCd()%>" readonly="readonly"></td>
															<td width="70">Net Weight</td>
															<td width="" class="stm" colspan="2"><input type="text" name="net_wgt__<%=seq%>" maxlength="12" dataformat="float" pointcount="3" caption="Net Weight" style="width:80;text-align:right" onBlur="makeComma(this.value)" class="<%=htmlClass%>" value="<%=nisDgVO.getNetWgt()%>" <%=htmlReadOnly%>>&nbsp;<input type="text" style="width:40;" class="input2" value="<%=nisDgVO.getWgtUtCd()%>" readonly="readonly"></td>
														</tr>
														</table>
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="140">Package quantity</td>
															<td class="stm"><input type="text" name="out_imdg_pck_qty1__<%=seq%>" maxlength="12" dataformat="float" pointcount="3" caption="Package quantity" style="width:80;text-align:right" onBlur="makeComma(this.value)" class="<%=htmlClass%>" value="<%=nisDgVO.getOutImdgPckQty1()%>" <%=htmlReadOnly%>></td>															
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="140">Emergency Contact</td>
															<td width=""><input type="text" name="emer_cntc_phn_no_ctnt__<%=seq%>" style="width:298;" maxlength="100" dataformat="etc" class="<%=htmlClass%>" value="<%=nisDgVO.getEmerCntcPhnNoCtnt()%>" <%=htmlReadOnly%>></td>
														</tr>
														<tr class="h23">
															<td width="140">Contact Person</td>
															<td width=""><input type="text" name="emer_cntc_pson_nm__<%=seq%>" style="width:298;" maxlength="100" dataformat="etc" class="<%=htmlClass%>" value="<%=nisDgVO.getEmerCntcPsonNm()%>" <%=htmlReadOnly%>></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="85">Cargo Status</td>
															<td width="160">
													 		 <select name="dcgo_sts_cd__<%=seq%>" style="width:80;" class="<%=htmlClass%>" <%=htmlDisabled%>>
													   		 	<option value="G" <%=("G".equals(nisDgVO.getDcgoStsCd()))?"selected":""%>>Gas</option>
													    		<option value="L" <%=("L".equals(nisDgVO.getDcgoStsCd()))?"selected":""%>>Liquid</option>
													    		<option value="P" <%=("P".equals(nisDgVO.getDcgoStsCd()))?"selected":""%>>Paste</option>
													    		<option value="S" <%=("S".equals(nisDgVO.getDcgoStsCd()))?"selected":""%>>Sold</option>
													 		 </select>
															</td>
															<td width="75">Limited Q'ty</td>
															<td width="">
													 		 <select name="imdg_lmt_qty_flg__<%=seq%>" style="width:73;" class="<%=htmlClass%>" <%=htmlDisabled%>>
													    		<option value="Y" <%=("Y".equals(nisDgVO.getImdgLmtQtyFlg()))?"selected":""%>>Yes</option>
													   		 <option value="N" <%=("N".equals(nisDgVO.getImdgLmtQtyFlg()))?"selected":""%>>No</option>
													  		</select>
															</td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="68" valign="top">Remark(s)</td>
															<td width="250"><textarea name="spcl_stwg_rqst_desc__<%=seq%>" class="<%=htmlClass%>" style="width:250;height:40;" <%=htmlReadOnly%> dataformat="etc"><%=nisDgVO.getSpclStwgRqstDesc()%></textarea></td>
															<td width="85">
																<!-- table><tr class="h23" bgcolor="<%=("Y".equals(nisDgVO.getDgRider()))?"#fff270":""%>"><td width="">D/G Rider&nbsp;</td>
																<td><a href="javascript:comBkgCallPop0207_position('D', '<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a><br></td>
																</tr></table-->
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																	<tr>
													    				<td class="btn2_left"></td>
<%
	if ( "Approved".equals(nisDgVO.getStatus()) || "Rejected".equals(nisDgVO.getStatus()) || "Requested".equals(nisDgVO.getStatus()) ) {
		
%>
								    <td class="btn2" name="btn_delete<%=seq%>">Delete</td>
<script>ComBtnDisable("btn_delete<%=seq%>")</script>
<%
	} else {
%>
															<a href="javascript:btn_delete('table<%=seq%>','<%=seq%>');"><td class="btn2">Delete</td></a>
<%
	}
%>
																		<td class="btn2_right"></td>
																	</tr>
																</table></td>
															</tr>
														</table>
													</td>													
											</table>
											<table><tr><td class="height_10"></td></tr></table>
											</div>
<%
	}
%>
<!-- DIV 위치 -->
<%--// Data Copy용--%>
<span id="INS_TABLES">
</span>
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
															<td class="btn2" name="btn_dgRider2">D/G Rider</td>
															<td class="btn2_right"></td>
															</tr>
														</table>
												    </td>													
												</tr>
											</table>
<%
	int seq2 = 0;
	for (int i=0;i<xterDgList.size();i++) {
		seq2 = i+1;
		BkgXterDgCgoVO xterDgVO = (BkgXterDgCgoVO) xterDgList.get(i);
%>
											<table class="search" border="0">
												<!-- input type="text" name="cntr_no_cmpr__<%=seq2%>" style="width:88;" class="input" value="<%=xterDgVO.getCntrNo()%><%=xterDgVO.getCntrCgoSeq()%>"-->
												<input type="hidden" name="cntr_no_cmpr__<%=seq2%>" style="width:88;" class="input" value="<%=getZeroLpad(xterDgVO.getDgCntrSeq())%><%=getZeroLpad(xterDgVO.getCntrCgoSeq())%><%=getZeroCnLpad(xterDgVO.getCntrNo())%>">
												<input type="hidden" name="dcgo_seq__<%=seq2%>" value="<%=xterDgVO.getDcgoSeq()%>">
												<tr class="h23">
													<td width="30" valign="top"><input type="text" name="cntr_seq__<%=seq2%>" style="width:25;text-align:center;" class="input" value="<%=xterDgVO.getDgCntrSeq()%>" readonly="readonly"></td>
													<td>
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="80">CNTR No.</td>
															<td width="">&nbsp;<input type="text" name="cntr_no__<%=seq2%>" style="width:88;" class="input2" value="<%=xterDgVO.getCntrNo()%>" readonly="readonly">&nbsp;<input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:55;" class="input2" value="<%=xterDgVO.getCntrTpszCd()%>" readonly="readonly"></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="27">Seq.</td>
															<td width="40">&nbsp;<input type="text" name="cntr_cgo_seq__<%=seq2%>" style="width:25;" class="input2" value="<%=xterDgVO.getCntrCgoSeq()%>" readonly="readonly"></td>
															<td width="48">UN No.</td>
															<td width="100">&nbsp;<input type="text" name="imdg_un_no__<%=seq2%>" style="width:50;" class="input2" value="<%=xterDgVO.getImdgUnNo()%>" readonly="readonly">
															&nbsp;<input name="imdg_un_no_seq__<%=seq2%>" value="<%=xterDgVO.getImdgUnNoSeq()%>" type="text" style="width:20;" class="input2" value="" readonly></td>
															<td width="70">IMDG Class</td>
															<td width=""><input type="text" name="imdg_clss_cd__<%=seq2%>" style="width:29;" class="input2" value="<%=xterDgVO.getImdgClssCd()%>" readonly="readonly">&nbsp;<input name="imdg_comp_grp_cd__<%=seq2%>" value="<%=xterDgVO.getImdgCompGrpCd()%>" type="text" style="width:20;" class="input2" value="" maxlength="1" readonly></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="140">Proper Shipping Name</td>
															<td width=""><input type="text" name="prp_shp_nm__<%=seq2%>" style="width:298px;" class="input2" value="<%=xterDgVO.getPrpShpNm()%>" readonly="readonly"></td>
														</tr>
														<tr class="h23">
															<td>HAZ. Contents</td>
															<td width=""><textarea name="hzd_desc__<%=seq2%>" style="width:298px;height:40;" class="textarea2" readonly="readonly"><%=xterDgVO.getHzdDesc()%></textarea></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="">Flash Point</td>
															<td width="" class="stm"><input type="text" name="flsh_pnt_cdo_temp__<%=seq2%>" maxlength="7" pointcount="2" style="width:30;text-align:right" class="input2" value="<%=xterDgVO.getFlshPntCdoTemp()%>" readonly="readonly">&nbsp;C&nbsp;&nbsp;</td>
															<td width="">&nbsp;Packing Group</td>
															<td width="" class="stm"><input type="text" name="imdg_pck_grp_cd__<%=seq2%>" style="width:40;" class="input2" value="<%=xterDgVO.getImdgPckGrpCd()%>" readonly="readonly">&nbsp;&nbsp;</td>
															<td width="">Marine Pollutant</td>
															<td width=""><input type="text" name="mrn_polut_flg__<%=seq2%>" style="width:60;" class="input2" value="<%=xterDgVO.getMrnPolutFlg()%>" readonly="readonly"></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="85">Gross Weight</td>
															<td width="160" class="stm" colspan="2"><input type="text" name="grs_wgt__<%=seq2%>" maxlength="12" pointcount="3" style="width:80;text-align:right" class="input2" value="<%=xterDgVO.getGrsWgt()%>" readonly="readonly">&nbsp;<input type="text" name="wgt_ut_cd__<%=seq2%>" style="width:40;" class="input2" value="<%=xterDgVO.getWgtUtCd()%>" readonly="readonly"></td>
															<td width="70">Net Weight</td>
															<td width="" class="stm" colspan="2"><input type="text" name="net_wgt__<%=seq2%>" maxlength="12" pointcount="3" style="width:80;text-align:right" class="input2" value="<%=xterDgVO.getNetWgt()%>" readonly="readonly">&nbsp;<input type="text" style="width:40;" class="input2" value="<%=xterDgVO.getWgtUtCd()%>" readonly="readonly"></td>
														</tr>
														</table>
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="140">Package quantity</td>
															<td class="stm"><input type="text" name="out_imdg_pck_qty1__<%=seq2%>" maxlength="12" pointcount="3" style="width:80;text-align:right" class="input2" value="<%=xterDgVO.getOutImdgPckQty1()%>" readonly="readonly"></td>															
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="140">Emergency Contact</td>
															<td width=""><input type="text" name="emer_cntc_phn_no_ctnt__<%=seq2%>" style="width:298;" class="input2" value="<%=xterDgVO.getEmerCntcPhnNoCtnt()%>" readonly="readonly"></td>
														</tr>
														<tr class="h23">
															<td width="140">Contact Person</td>
															<td width=""><input type="text" name="emer_cntc_pson_nm__<%=seq2%>" style="width:298;" class="input2" value="<%=xterDgVO.getEmerCntcPsonNm()%>" readonly="readonly"></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="85">Cargo Status</td>
															<td width="160">&nbsp;<input type="text" name="dcgo_sts_cd__<%=seq2%>" style="width:80;" class="input2" value="<%=xterDgVO.getDcgoStsCd()%>" readonly="readonly"></td>
															<td width="75">Limited Q'ty</td>
															<td width=""><input type="text" name="imdg_lmt_qty_flg__<%=seq2%>" style="width:73;" class="input2" value="<%=xterDgVO.getImdgLmtQtyFlg()%>" readonly="readonly"></td>
														</tr>
														</table>
														
														<table class="search" border="0" width="100%">
														<tr class="h23">
															<td width="81" valign="top">Remark(s)</td>
															<td width="250"><textarea name="spcl_stwg_rqst_desc__<%=seq2%>" style="width:250;height:40;" class="textarea2" readonly="readonly"><%=xterDgVO.getSpclStwgRqstDesc()%></textarea></td>
															<td width="85" colspan="2">
																<!-- table><tr class="h23"><td width="">D/G Rider&nbsp;</td>
																<td><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"><br></td>
																</tr></table-->
															</td>
														</tr>
														</table>
														
														
													</td>
												</tr>
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
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>
<%!

		public String getZeroLpad(String src) {
			String lpadStr = "";
			if ( src != null && src.length() > 0 ) {
				int lpadCount = 2 - src.length();
				for (int i=0;i<lpadCount;i++) {
					//lpadStr = lpadStr + "0";	
					StringBuffer tmpBuffer = new StringBuffer(lpadStr).append("0");
					lpadStr = tmpBuffer.toString();
				}
			} else src = "";
			return lpadStr+src;
		}

		public String getZeroCnLpad(String src) {
			String lpadStr = "";
			if ( src != null && src.length() > 0 ) {
				int lpadCount = 12 - src.length();
				for (int i=0;i<lpadCount;i++) {
					//lpadStr = lpadStr + "0";	
					StringBuffer tmpBuffer = new StringBuffer(lpadStr).append("0");
					lpadStr = tmpBuffer.toString();
				}
			} else src = "";
			return lpadStr+src;
		}
%>