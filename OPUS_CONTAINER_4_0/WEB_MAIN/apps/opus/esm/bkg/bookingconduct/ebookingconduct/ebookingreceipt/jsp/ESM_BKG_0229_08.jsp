<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_08.jsp
 *@FileTitle : e-Booking & SI Process Detail(DANGER)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022908Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%!
    public String getCntrTpszCombo(String name, String style, String css, String script, String selectedValue, String firstOption, List<OpusCntrTpszVO> cntrList)
	{
        StringBuffer html = new StringBuffer("");
        int len = cntrList==null ? 0 : cntrList.size();
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"\"") + ">\n");
        html.append("<option value=\""+firstOption+"\" "+((firstOption.equals(selectedValue))? "selected" : "")+">"+firstOption+"</option>\n");
        for(int i=0;i<len;i++){
        	OpusCntrTpszVO vo = cntrList.get(i);
            html.append("<option value=\""+vo.getCntrNo()+"\" "+((vo.getCntrNo().equals(selectedValue))? "selected" : "")+" id=\""+vo.getCntrTpszCd()+"\">"+vo.getCntrNo()+"</option>\n");
        }
        html.append("</select>\n");
        return html.toString();
    }
%>
<%
	EsmBkg022908Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	List<OpusCntrTpszVO> cntr_tpsz = null;
	List<OpusDgVO> opusDgList = null;
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

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<OpusCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstDgVO dgVO = (ExternalRqstDgVO) eventResponse.getCustomData("externalRqstDgVO");
		opusDgList = dgVO.getOpusDgVO();
		xterDgList = dgVO.getBkgXterDgCgoVO();

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
	
//	String cntrTpsz_cdStr=" |";
//	String cntrTpsz_idStr=" |";
	StringBuffer cntrTpsz_cdStr=new StringBuffer(" |");
	StringBuffer cntrTpsz_idStr=new StringBuffer(" |");
	for(int i=0; i<cntr_tpsz.size(); i++) {
		OpusCntrTpszVO vo = cntr_tpsz.get(i);
		cntrTpsz_cdStr.append(vo.getCntrNo()+"|");
		cntrTpsz_idStr.append(vo.getCntrTpszCd()+"|");		
//		cntrTpsz_cdStr = cntrTpsz_cdStr + vo.getCntrNo()+"|";
//		cntrTpsz_idStr = cntrTpsz_idStr + vo.getCntrTpszCd()+"|";
	}
%>
<script type="text/javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		loadCntrTpsz("<%=cntrTpsz_cdStr%>","<%=cntrTpsz_idStr%>");
	}
</script>
<style type="text/css">
	.specialCls {float: right;}
	.specialCls:after {display: block;content: " ";	clear: both;}
</style>



<!-- layout_wrap (S) -->
<div class="layout_wrap">
	<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="cntr_no" id="cntr_no" />
	<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no")) %>" id="bkg_no" />
	<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no")) %>" id="rqst_no" />
	<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
	<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
	<input type="hidden" name="dg_opus" value="<%=(opusDgList.size() > 0)?" y":"n" %>" id="dg_opus" />
	<input type="hidden" name="dg_esvc" value="<%=(xterDgList.size() > 0)?" y":"n" %>" id="dg_esvc" />
	<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />


<!--// 2015.01.15. NYK3.0 현행화(ALPS) opus 쪽 D/G Rider 버튼 클릭시 start-->
<div id="dgRider" style="position:absolute; visibility:hidden; z-index:1; margin-top:80px; margin-left:50px; height:150px; width:450px;">
	<table>
		<tr>
			<td width="430px">
				<div class="opus_design_grid" id="mainTable" name="mainTable">
						<script type="text/javascript">ComSheetObject('div1sheet1');</script>
				</div>		
			</td>
		</tr>
	</table>
</div>

<div id="dgRider2" style="position:absolute; visibility:hidden; z-index:1; margin-top:80px; margin-left:680px; height:150px; width:450px;">
	<table>
		<tr>
			<td width="430px">
				<div class="opus_design_grid" id="mainTable" name="mainTable">		
						<script type="text/javascript">ComSheetObject('div2sheet1');</script>
				</div>		
			</td>
		</tr>
	</table>
</div>	
<!--// 2015.01.15. NYK3.0 현행화(ALPS) opus 쪽 D/G Rider 버튼 클릭시 end -->
		<div id="div_left" class="layout_vertical_2 pad_rgt_8" >
			<div class="wrap_search">
				<div class="opus_design_grid">
					<h3 class="title_design">Booking Data OPUS</h3>
					<div class="specialCls">
						<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
					</div>
				</div>
	    		<!-- opus_design_inquiry (S) -->
				<div class="opus_design_inquiry">
			    	<table>
						<colgroup>
							<col width="80">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Booking No.</th>
								<td><input type="text" name="bkg_no2" id="bkg_no2" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
								<!-- // 2015.01.15. NYK3.0 현행화(ALPS) start -->
								<td align="right"><button type="button" name="btn_dgRider" id="btn_dgRider" class="btn_etc" >D/G Rider</button></td>	
								<!-- // 2015.01.15. NYK3.0 현행화(ALPS) end -->
							</tr>
						</tbody>
					</table>
					<%
					int seq = 0;
					String htmlClass=null;
					String htmlReadOnly=null;
					String htmlDisabled=null;
					for (int i=0;i<opusDgList.size();i++) {
						seq = i+1;
						OpusDgVO opusDgVO = (OpusDgVO) opusDgList.get(i);
						htmlClass=( "Approved".equals(opusDgVO.getStatus()) || "Rejected".equals(opusDgVO.getStatus()) || "Requested".equals(opusDgVO.getStatus()))?"input2":"input";
						htmlReadOnly=( "Approved".equals(opusDgVO.getStatus()) || "Rejected".equals(opusDgVO.getStatus()) || "Requested".equals(opusDgVO.getStatus()))?"readOnly":"";
						htmlDisabled=( "Approved".equals(opusDgVO.getStatus()) || "Rejected".equals(opusDgVO.getStatus()) || "Requested".equals(opusDgVO.getStatus()))?"disabled":"";
					%>
					<div id="table_<%=seq%>" >
						<input type="hidden" name="cntr_no_cmpr__<%=seq%>" value="<%=opusDgVO.getCntrNo()%><%=opusDgVO.getCntrCgoSeq()%>">
						<input type="hidden" name="dcgo_seq__<%=seq%>" value="<%=opusDgVO.getDcgoSeq()%>">
						<input type="hidden" name="imdg_segr_grp_no__<%=seq%>" value="">
						<%--
						<input type="hidden" name="imdg_un_no_seq__<%=seq%>" value="<%=opusDgVO.getImdgUnNoSeq()%>">
						 --%>
						<table id="table<%=seq%>" class="search" border="0" style="width:600px;">
							<colgroup>
								<col width="30" />
								<col width="60" />
								<col width="" />
								<col width="*" />
							</colgroup>
							<tr>
								<td><input type="text" name="cntr_seq__<%=seq%>" id="cntr_seq__<%=seq%>" style="width:25px;text-align:center;" class="<%=htmlClass%>" value="<%=opusDgVO.getDgCntrSeq()%>" readonly="readonly"></td>
								<th>CNTR No.</th>
								<td>
								<%	if ( "readOnly".equals(htmlReadOnly) ) {%>
									<input type="text" name="cntr_no__<%=seq%>" id="cntr_no__<%=seq%>" style="width:105px;" maxlength="11" dataformat="engup" class="<%=htmlClass%>" value="<%=opusDgVO.getCntrNo()%>" <%=htmlReadOnly%>>
								<% 	} else {	%>
									<%=getCntrTpszCombo("cntr_no__"+String.valueOf(seq).toString(), "width:105px;", htmlClass, "changeCntrNo(this,'"+seq+"')", opusDgVO.getCntrNo(), "", cntr_tpsz)%>
								<% 	} 	%>
									<input type="text" required caption="Cntr Type Size" name="cntr_tpsz_cd__<%=seq%>" id="cntr_tpsz_cd__<%=seq%>" style="width:40px;" maxlength="2" dataformat="engup" class="<%=htmlClass%>" value="<%=opusDgVO.getCntrTpszCd()%>" <%=htmlReadOnly%>>
									<strong>Status</strong><input type="text" name="status__<%=seq%>" id="status__<%=seq%>" style="width:55px;color:blue" class="input2" value="<%=opusDgVO.getStatus()%>" readonly="readonly">
									
								</td>
								<td> <button type="button" class="btn_etc" onclick="btn_Restriction('<%=seq%>');">Restriction</button></td>
							</tr>		    			
									
							<tr>
								<td></td>
								<th>Seq.</th>
								<td colspan="2"><input type="text" name="cntr_cgo_seq__<%=seq%>" id="cntr_cgo_seq__<%=seq%>" style="width:25px;text-align:center;" class="<%=htmlClass%>" value="<%=opusDgVO.getCntrCgoSeq()%>" readonly="readonly">
									<strong>UN No.</strong>
									<input type="text" required caption="UN No." dataformat='num' name="imdg_un_no__<%=seq%>" id="imdg_un_no__<%=seq%>" style="width:40px;" maxlength="4" class="<%=htmlClass%>" value="<%=opusDgVO.getImdgUnNo()%>" <%=htmlReadOnly%> onblur="comBkgCallPop0204_position(<%=seq%>);" />
									&nbsp;<input name="imdg_un_no_seq__<%=seq%>" value="<%=opusDgVO.getImdgUnNoSeq()%>" type="text" style="width:40px;" class="input2"  readonly>
<%if ( "Approved".equals(opusDgVO.getStatus()) || "Rejected".equals(opusDgVO.getStatus())  || "Requested".equals(opusDgVO.getStatus())) {%>	
									<button class="input_seach_btn" type="button"></button>
<%} else {%>
									<button class="input_seach_btn" type="button" onclick="comBkgCallPop0204_position('<%=seq%>');"></button>
<%}%>
									<strong>IMDG Class</strong><input type="text" name="imdg_clss_cd__<%=seq%>" id="imdg_clss_cd__<%=seq%>" style="width:40px;" maxlength="3" class="input2" value="<%=opusDgVO.getImdgClssCd()%>" readonly="readonly">
									&nbsp;<input name="imdg_comp_grp_cd__<%=seq%>" type="text" style="width:20px;" class="input2"  value="<%=opusDgVO.getImdgCompGrpCd()%>" maxlength="1" readonly>
									<input type="hidden" name="imdg_amdt_no__<%=seq%>" style="width:5px;" value="<%=opusDgVO.getImdgAmdtNo()%>" >
									
									
									</td>
							</tr>
							<tr>
								<td></td>
								<th>Proper Shipping Name</th>
								<td colspan="2"><input type="text" name="prp_shp_nm__<%=seq%>" id="prp_shp_nm__<%=seq%>" style="width:298px;" class="<%=htmlClass%>" value="<%=opusDgVO.getPrpShpNm()%>" <%=htmlReadOnly%> dataformat="engup"></td>
							</tr>
							<tr>
								<td></td>
								<th>HAZ. Contents</th>
								<td colspan="2"> <textarea name="hzd_desc__<%=seq%>" id="hzd_desc__<%=seq%>" class="<%=htmlClass%>" style="width:298px;height:40px;" <%=htmlReadOnly%> dataformat="engup"><%=opusDgVO.getHzdDesc()%></textarea></td>
							</tr>
							<tr>
								<td></td>
								<th>Flash Point</th>
								<td colspan="2"><input type="text" name="flsh_pnt_cdo_temp__<%=seq%>" id="flsh_pnt_cdo_temp__<%=seq%>" style="width:50px;text-align:right" maxlength="7" onBlur="makeComma(this.value)" dataformat="float" pointcount="2"  class="<%=htmlClass%>" value="<%=opusDgVO.getFlshPntCdoTemp()%>" <%=htmlReadOnly%>>&nbsp;C&nbsp;&nbsp;
								<strong>Packing Group</strong> <input type="text" name="imdg_pck_grp_cd__<%=seq%>" id="imdg_pck_grp_cd__<%=seq%>" style="width:30px;" maxlength="1" class="input2" value="<%=opusDgVO.getImdgPckGrpCd()%>" readonly="readonly">&nbsp;&nbsp;
								<strong>Marine Pollutant
						 		 <select name="mrn_polut_flg__<%=seq%>" id="mrn_polut_flg__<%=seq%>" class="<%=htmlClass%>" style="width:60px;" <%=htmlDisabled%>>
						    		<option value="Y" <%=("Y".equals(opusDgVO.getMrnPolutFlg()))?"selected":""%>>Yes</option>
						    		<option value="N" <%=("N".equals(opusDgVO.getMrnPolutFlg()))?"selected":""%>>No</option>
						 		 </select>
								</td>
							</tr>
							<tr>
								<td></td>
								<th>Gross Weight</th>
								<td colspan="2"><input type="text" name="grs_wgt__<%=seq%>" id="grs_wgt__<%=seq%>" maxlength="12" dataformat="float" pointcount="3" caption="Gross Weight" style="width:80px;text-align:right" onBlur="makeComma(this.value)" class="<%=htmlClass%>" value="<%=opusDgVO.getGrsWgt()%>" <%=htmlReadOnly%>><input type="text" name="wgt_ut_cd__<%=seq%>" id="wgt_ut_cd__<%=seq%>" style="width:40px;" class="input2" value="<%=opusDgVO.getWgtUtCd()%>" readonly="readonly">
								<strong>Net Weight</strong> <input type="text" name="net_wgt__<%=seq%>" id="net_wgt__<%=seq%>" maxlength="12" dataformat="float" pointcount="3" caption="Net Weight" style="width:80px;text-align:right" onBlur="makeComma(this.value)" class="<%=htmlClass%>" value="<%=opusDgVO.getNetWgt()%>" <%=htmlReadOnly%>><input type="text" style="width:40px;" class="input2" value="<%=opusDgVO.getWgtUtCd()%>" readonly="readonly"></td>
							</tr>
							<tr>
								<td></td>
								<th>Emergency Contact</th>
								<td colspan="2"><input type="text" name="emer_cntc_phn_no_ctnt__<%=seq%>" id="emer_cntc_phn_no_ctnt__<%=seq%>" style="width:200px;" maxlength="100" dataformat="engup" class="<%=htmlClass%>" value="<%=opusDgVO.getEmerCntcPhnNoCtnt()%>" <%=htmlReadOnly%>>
									<strong>Contact Person</strong> <input type="text" name="emer_cntc_pnt_ctnt__<%=seq%>" id="emer_cntc_pnt_ctnt__<%=seq%>" style="width:200px;" maxlength="100" dataformat="engup" class="<%=htmlClass%>" value="<%=opusDgVO.getEmerCntcPntCtnt()%>" <%=htmlReadOnly%>>
								</td>
							</tr>
							<tr>
								<td></td>
								<th>Cargo Status</th>
								<td colspan="2">								 							
									<select name="dcgo_sts_cd__<%=seq%>" style="width:80;" class="<%=htmlClass%>" <%=htmlDisabled%>>
							   		 	<option value=""></option>
							   		 	<option value="G" <%=("G".equals(opusDgVO.getDcgoStsCd()))?"selected":""%>>Gas</option>
							    		<option value="L" <%=("L".equals(opusDgVO.getDcgoStsCd()))?"selected":""%>>Liquid</option>
							    		<option value="P" <%=("P".equals(opusDgVO.getDcgoStsCd()))?"selected":""%>>Paste</option>
							    		<option value="S" <%=("S".equals(opusDgVO.getDcgoStsCd()))?"selected":""%>>Sold</option>
							 		 </select>
								 <strong>Limited Q'ty</strong>
						 			<select name="imdg_lmt_qty_flg__<%=seq%>" id="imdg_lmt_qty_flg__<%=seq%>" style="width:73px;" class="<%=htmlClass%>" <%=htmlDisabled%>>
						    			<option value="Y" <%=("Y".equals(opusDgVO.getImdgLmtQtyFlg()))?"selected":""%>>Yes</option>
						   		 		<option value="N" <%=("N".equals(opusDgVO.getImdgLmtQtyFlg()))?"selected":""%>>No</option>
					  				</select>
								</td>
							</tr>
							<tr>
								<td></td>
								<th>Remark(s)</th>
								<td><textarea name="spcl_stwg_rqst_desc__<%=seq%>" id="spcl_stwg_rqst_desc__<%=seq%>" class="<%=htmlClass%>" style="width:250px;height:40px;" <%=htmlReadOnly%> dataformat="engup"><%=opusDgVO.getSpclStwgRqstDesc()%></textarea></td>
			    				<td>
			    					<!-- 
								 --><%	if ( "Approved".equals(opusDgVO.getStatus()) || "Rejected".equals(opusDgVO.getStatus()) || "Requested".equals(opusDgVO.getStatus()) ) {%><!-- 
  									 --><button type="button" class="btn_etc" name="btn_delete<%=seq%>" id="btn_delete<%=seq%>">Delete</button><!-- 
									 --><script>ComBtnDisable("btn_delete<%=seq%>")</script><!-- 
								 --><%} else {%><!-- 
									 --><button type="button" class="btn_etc" onclick="btn_delete('table<%=seq%>','<%=seq%>');">Delete</button><!-- 
								 --><% } %><!-- 
								 --></td>
							</tr>
						</table>
					</div>
					<% } %>
					<span id="INS_TABLES"></span>
		    	</div>
		    	<!-- opus_design_inquiry (E) -->
		    	
		    	<!-- wrap_result (S) -->
				<div class="wrap_result" style="display:none">
					<div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('sheet1');</script>
					</div>
				</div>
				<!-- wrap_result (E) -->
			</div>
		</div>
	</form>
	<form name="form2">
		<div id="div_right" class="layout_vertical_2" >
			<div class="wrap_search">
				<div class="opus_design_grid">
					<h3 class="title_design">From e- Service</h3>
					<div class="specialCls">
						<button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button>
					</div>
				</div>
				<!-- opus_design_inquiry (S) -->
				<div class="opus_design_inquiry">
			    	<table>
			    		<colgroup>
							<col width="80">
							<col width="*">
						</colgroup>
						<tr>
							<th>Request No.</th>
							<td><input type="text" name="rqst_no2" id="rqst_no2" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readonly="readonly"></td>
							<!--// 2015.01.15. NYK3.0 현행화(ALPS) -->
                            <td align="right"><button type="button" name="btn_dgRider2" id="btn_dgRider2" class="btn_etc" >D/G Rider</button></td>									
						    <!--// 2015.01.15. NYK3.0 현행화(ALPS) -->				
						</tr>
					</table>
					<%
					int seq2 = 0;
					for (int i=0;i<xterDgList.size();i++) {
						seq2 = i+1;
						BkgXterDgCgoVO xterDgVO = (BkgXterDgCgoVO) xterDgList.get(i);
					%>
					<input type="hidden" name="cntr_no_cmpr__<%=seq2%>" style="width:88px;" class="input" value="<%=xterDgVO.getCntrNo()%><%=xterDgVO.getCntrCgoSeq()%>">
					<!--// 2015.01.15. NYK3.0 현행화(ALPS) -->
					<input type="hidden" name="dcgo_seq__<%=seq2%>" value="<%=xterDgVO.getDcgoSeq()%>">
					<!--// 2015.01.15. NYK3.0 현행화(ALPS) -->
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="*" />
						</colgroup>
						<tr>
							<td><input type="text" name="cntr_seq__<%=seq2%>" id="cntr_seq__<%=seq2%>" style="width:25px;text-align:center;" class="input" value="<%=seq2%>" readonly="readonly"></td>
							<th>CNTR No.</th>
							<td><input type="text" name="cntr_no__<%=seq2%>" id="cntr_no__<%=seq2%>" style="width:88px;" class="input2" value="<%=xterDgVO.getCntrNo()%>" readonly="readonly">&nbsp;<input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:55;" class="input2" value="<%=xterDgVO.getCntrTpszCd()%>" readonly="readonly"></td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="25" />
							<col width="50" />
							<col width="100" />
							<col width="70" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Seq.</th>
							<td><input type="text" name="cntr_cgo_seq__<%=seq2%>" id="cntr_cgo_seq__<%=seq2%>" style="width:25px;" class="input2" value="<%=xterDgVO.getCntrCgoSeq()%>" readonly="readonly"></td>
							<th>UN No.</th>
							<td><input type="text" name="imdg_un_no__<%=seq2%>" id="imdg_un_no__<%=seq2%>" style="width:40px;" class="input2" value="<%=xterDgVO.getImdgUnNo()%>" readonly="readonly">
							&nbsp;<!--// 2015.01.15. NYK3.0 현행화(ALPS) --><input name="imdg_un_no_seq__<%=seq2%>" value="<%=xterDgVO.getImdgUnNoSeq()%>" type="text" style="width:40px;" class="input2" value="" readonly><!--// 2015.01.15. NYK3.0 현행화(ALPS) --></td>
							<th>IMDG Class</th>
							<td><input type="text" name="imdg_clss_cd__<%=seq2%>" id="imdg_clss_cd__<%=seq2%>" style="width:40px;" class="input2" value="<%=xterDgVO.getImdgClssCd()%>" readonly="readonly">&nbsp;<!--// 2015.01.15. NYK3.0 현행화(ALPS) --><input name="imdg_comp_grp_cd__<%=seq2%>" value="<%=xterDgVO.getImdgCompGrpCd()%>" type="text" style="width:20px;" class="input2" value="" maxlength="1" readonly><!--// 2015.01.15. NYK3.0 현행화(ALPS) -->
							<input type="hidden" name="imdg_amdt_no__<%=seq2%>" value="">
							</td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Proper Shipping Name</th>
							<td><input type="text" name="prp_shp_nm__<%=seq2%>" id="prp_shp_nm__<%=seq2%>" style="width:298px;" class="input2" value="<%=xterDgVO.getPrpShpNm()%>" readonly="readonly"></td>
						</tr>
						<tr>
							<td></td>
							<th>HAZ. Contents</th>
							<td><textarea name="hzd_desc__<%=seq2%>" id="hzd_desc__<%=seq2%>" style="width:298px;height:40px;" class="textarea2" readonly="readonly"><%=xterDgVO.getHzdDesc()%></textarea></td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="70" />
							<col width="170" />
							<col width="50" />
							<col width="100" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Flash Point</th>
							<td class="sm"><input type="text" name="flsh_pnt_cdo_temp__<%=seq2%>" id="flsh_pnt_cdo_temp__<%=seq2%>" maxlength="7" pointcount="2" style="width:50px;text-align:right" class="input2" value="<%=xterDgVO.getFlshPntCdoTemp()%>" readonly="readonly"> C  </td>
							<th>Packing Group</th>
							<td class="sm"><input type="text" name="imdg_pck_grp_cd__<%=seq2%>" id="imdg_pck_grp_cd__<%=seq2%>" style="width:40px;" class="input2" value="<%=xterDgVO.getImdgPckGrpCd()%>" readonly="readonly"></td>
							<th>Marine Pollutant</th>
							<td><input type="text" name="mrn_polut_flg__<%=seq2%>" id="mrn_polut_flg__<%=seq2%>" style="width:60px;" class="input2" value="<%=xterDgVO.getMrnPolutFlg()%>" readonly="readonly"></td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="130" />
							<col width="100" />
							<col width="130" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Gross Weight</th>
							<td class="sm"><input type="text" name="grs_wgt__<%=seq2%>" id="grs_wgt__<%=seq2%>" maxlength="12" pointcount="3" style="width:80px;text-align:right" class="input2" value="<%=xterDgVO.getGrsWgt()%>" readonly="readonly"><input type="text" name="wgt_ut_cd__<%=seq2%>" id="wgt_ut_cd__<%=seq2%>" style="width:40px;" class="input2" value="<%=xterDgVO.getWgtUtCd()%>" readonly="readonly"></td>
							<th>Net Weight</th>
							<td class="sm"><input type="text" name="net_wgt__<%=seq2%>" id="net_wgt__<%=seq2%>" maxlength="12" pointcount="3" style="width:80px;text-align:right" class="input2" value="<%=xterDgVO.getNetWgt()%>" readonly="readonly"><input type="text" style="width:40px;" class="input2" value="<%=xterDgVO.getWgtUtCd()%>" readonly="readonly"></td>
							<td></td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Emergency Contact</th>
							<td><input type="text" name="emer_cntc_phn_no_ctnt__<%=seq2%>" id="emer_cntc_phn_no_ctnt__<%=seq2%>" style="width:200px;" class="input2" value="<%=xterDgVO.getEmerCntcPhnNoCtnt()%>" readonly="readonly">
								<strong>Contact Person</strong> 
								<input type="text" name="emer_cntc_pnt_ctnt__<%=seq2%>" id="emer_cntc_pnt_ctnt__<%=seq2%>" style="width:200px;" class="input2" value="<%=xterDgVO.getEmerCntcPntCtnt()%>" readonly="readonly">
							</td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="80" />
							<col width="70" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Cargo Status</th>
							<td><input type="text" name="dcgo_sts_cd__<%=seq2%>" id="dcgo_sts_cd__<%=seq2%>" style="width:80px;" class="input2" value="<%=xterDgVO.getDcgoStsCd()%>" readonly="readonly"></td>
							<th>Limited Q'ty</th>
							<td><input type="text" name="imdg_lmt_qty_flg__<%=seq2%>" id="imdg_lmt_qty_flg__<%=seq2%>" style="width:73px;" class="input2" value="<%=xterDgVO.getImdgLmtQtyFlg()%>" readonly="readonly"></td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="135" />
							<col width="*" />
						</colgroup>
						<tr>
							<td></td>
							<th>Remark(s)</th>
							<td><textarea name="spcl_stwg_rqst_desc__<%=seq2%>" id="spcl_stwg_rqst_desc__<%=seq2%>" style="width:250px;height:40px; resize:none" class="textarea2" readonly="readonly"><%=xterDgVO.getSpclStwgRqstDesc()%></textarea></td>
							<td></td>
						</tr>
					</table>
					<% } %>
	    		</div>
		    	<!-- opus_design_inquiry (E) -->
			</div>
		</div>
	</form>	
</div>
<!-- layout_wrap (E) -->
<!-- // 2015.01.15. NYK3.0 현행화(ALPS) start-->	
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
<!-- // 2015.01.15. NYK3.0 현행화(ALPS) end-->	
	