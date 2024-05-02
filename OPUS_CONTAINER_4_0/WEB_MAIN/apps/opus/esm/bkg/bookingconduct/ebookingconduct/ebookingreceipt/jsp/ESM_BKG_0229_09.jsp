<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_09.jsp
 *@FileTitle : e-Booking & SI Process Detail(AWKWARD)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/11
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022909Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%!
    public String getCntrTpszCombo(String name, String style, String css, String script, String selectedValue, String firstOption, List<OpusCntrTpszVO> cntrList){
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
	EsmBkg022909Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	List<BkgComboVO> wgt_cd = null;
	List<OpusAkVO> opusAkList = null;
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

		// getting data from server when load the initial screen 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<OpusCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstAkVO akVO = (ExternalRqstAkVO) eventResponse.getCustomData("externalRqstAkVO");
		opusAkList = akVO.getOpusAkVO();
		xterAkList = akVO.getBkgXterAwkCgoVO();

		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}

//	String cntrTpsz_cdStr=" |";
//	String cntrTpsz_idStr=" |";
	StringBuffer cntrTpsz_cdStr=new StringBuffer(" |");
	StringBuffer cntrTpsz_idStr=new StringBuffer(" |");
	for(int i=0;i<cntr_tpsz.size();i++) {
		OpusCntrTpszVO vo = cntr_tpsz.get(i);
		cntrTpsz_cdStr.append(vo.getCntrNo()+"|");
		cntrTpsz_idStr.append(vo.getCntrTpszCd()+"|");		
//		cntrTpsz_cdStr = cntrTpsz_cdStr + vo.getCntrNo() + "|";
//		cntrTpsz_idStr = cntrTpsz_idStr + vo.getCntrTpszCd() + "|";
	}

//	String wgt_cdStr=" |";
//	String wgt_nmStr=" |";
	StringBuffer wgt_cdStr=new StringBuffer(" |");
	StringBuffer wgt_nmStr=new StringBuffer(" |");
	for(int i=0;i<wgt_cd.size();i++) {
		BkgComboVO vo = wgt_cd.get(i);
		wgt_cdStr.append(vo.getVal()+"|");
		wgt_nmStr.append(vo.getName()+"|");		
//		wgt_cdStr = wgt_cdStr + vo.getVal() + "|";
//		wgt_nmStr = wgt_nmStr + vo.getName() + "|";
	}
%>


<script type="text/javascript">
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
<style type="text/css">
	.specialCls {
		float: right;
	}
	.specialCls:after {
		display: block;
		content: " ";
		clear: both;
	}
</style>


<!-- layout_wrap (S) -->
<div class="layout_wrap">
	<div class="layout_vertical_2 pad_rgt_8" >
		<form name="form">
			<input type="hidden" name="f_cmd" id="f_cmd" />
			<input type="hidden" name="pagerows" id="pagerows" />
			<input type="hidden" name="cntr_no" id="cntr_no" />
			<input type="hidden" name="cmdt_cd" id="cmdt_cd" />
			<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no")) %>" id="bkg_no" />
			<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no")) %>" id="rqst_no" />
			<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
			<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
			<input type="hidden" name="ak_opus" value="<%=(opusAkList.size() > 0)?" y":"n" %>" id="ak_opus" />
			<input type="hidden" name="ak_esvc" value="<%=(xterAkList.size() > 0)?" y":"n" %>" id="ak_esvc" />
			<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />
			<div class="wrap_search sm">
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
							</tr>
						</tbody>
					</table>
					<%
						int seq = 0;
						String htmlClass=null;
						String htmlReadOnly=null;
						for (int i=0;i<opusAkList.size();i++) {
							seq = i+1;
							OpusAkVO opusAkVO = (OpusAkVO) opusAkList.get(i);
					
							htmlClass=( "Approved".equals(opusAkVO.getStatus()) || "Rejected".equals(opusAkVO.getStatus()) || "Requested".equals(opusAkVO.getStatus()))?"input2":"input";
							htmlReadOnly=( "Approved".equals(opusAkVO.getStatus()) || "Rejected".equals(opusAkVO.getStatus()) || "Requested".equals(opusAkVO.getStatus()))?"readOnly":"";
					%>
					<div id="table_<%=seq%>">
						<input type="hidden" name="awk_cgo_seq__<%=seq%>" value="<%=opusAkVO.getAwkCgoSeq()%>">
						<table id="table<%=seq%>" class="pad_btm_8">
							<colgroup>
								<col width="30" />
								<col width="90" />
								<col width="180" />
								<col width="50" />
								<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<td><input type="text" name="cntr_seq__<%=seq%>" style="width:25px;text-align:center;" class="input" value="<%=seq%>" readonly="readonly" id="cntr_seq__<%=seq%>" /></td>
									<th>CNTR No.</th>
									<td>
									<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
				  					<input type="text" name="cntr_no__<%=seq%>" id="cntr_no__<%=seq%>" style="width:105px;" class="<%=htmlClass%>" value="<%=opusAkVO.getCntrNo()%>" <%=htmlReadOnly%>>
									<%	} else {	%>
				  					<%=getCntrTpszCombo("cntr_no__"+String.valueOf(seq).toString(), "width:105px;", htmlClass, "changeCntrNo(this,'"+seq+"')", opusAkVO.getCntrNo(), "", cntr_tpsz)%>
									<%	}	%><!--
									--><input type="text" required caption="Cntr Type Size" name="cntr_tpsz_cd__<%=seq%>" style="width:35px;" maxlength="2" dataformat="engup" class="<%=htmlClass%>" value="<%=opusAkVO.getCntrTpszCd()%>" id="cntr_tpsz_cd__<%=seq%>" />
									</td>
									<th>Status</th>
									<td><input type="text" name="status__<%=seq%>" style="width:80px;color:blue" class="input2" value="<%=opusAkVO.getStatus()%>" readonly="readonly" id="status__<%=seq%>" /> </td>
								</tr>
								<tr>
									<td></td>
									<th>Commodity</th>
									<td colspan="4"><input type="text" name="cmdt_cd__<%=seq%>" caption="Commodity" style="width:90px;" maxlength="8" dataformat="engup" onChange="javascript:changeCmdtDesc(this);" class="<%=htmlClass%>" value="<%=opusAkVO.getCmdtCd()%>"  <%=htmlReadOnly%> id="cmdt_cd__<%=seq%>" />
									<%
									if ( "Approved".equals(opusAkVO.getStatus()) || "Rejected".equals(opusAkVO.getStatus()) ) {
									%>
									<button type="button" class="input_seach_btn"></button>
									<%
									} else {
									%>
									<a href="javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__<%=seq%>.value, '<%=seq%>');"><button type="button" class="input_seach_btn"></button></a>
									<%
									}
									%>
									<input type="text" name="cmdt_desc__<%=seq%>" maxlength="4000" style="width:190px;" class="input2" value="<%=opusAkVO.getCmdtNm()%>" readonly="readonly" id="cmdt_desc__<%=seq%>" /></td>
								</tr>
								<tr>
									<td></td>
									<td>Length</td>
									<td><input type="text" name="ttl_dim_len__<%=seq%>" style="width:80px;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=opusAkVO.getTtlDimLen()%>" <%=htmlReadOnly%> id="ttl_dim_len__<%=seq%>" />&nbsp;CM</td>
									<td>Width</td>
									<td><input type="text" name="ttl_dim_wdt__<%=seq%>" style="width:110px;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=opusAkVO.getTtlDimWdt()%>"  <%=htmlReadOnly%> id="ttl_dim_wdt__<%=seq%>" />&nbsp;CM</td>
								</tr>
								<tr>
									<td></td>
									<td>Height</td>
									<td><input type="text" name="ttl_dim_hgt__<%=seq%>" style="width:80px;text-align:right" maxlength="7" dataformat="float" class="<%=htmlClass%>" value="<%=opusAkVO.getTtlDimHgt()%>" <%=htmlReadOnly%>>&nbsp;CM</td>
									<td>Package</td>
									<td><input type="text" name="pck_qty__<%=seq%>" style="width:65px;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=opusAkVO.getPckQty()%>" <%=htmlReadOnly%>><!--
									--><input type="text" name="pck_tp_cd__<%=seq%>" caption="Package Type Code" maxlength="2" style="width:35px;" dataformat="eng" class="<%=htmlClass%>" value="<%=opusAkVO.getPckTpCd()%>" <%=htmlReadOnly%>>&nbsp;<!--
									--><a href="javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__<%=seq%>.value, '<%=seq%>');"><!--
									--><button type="button" class="input_seach_btn"></button></a></td>
								</tr>
								<tr>
									<td></td>
									<td>Gross WGT</td>
									<td><input type="text" name="grs_wgt__<%=seq%>" style="width:90px;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=opusAkVO.getGrsWgt()%>" <%=htmlReadOnly%>>&nbsp;
									<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
									<input type="text" name="wgt_ut_cd__<%=seq%>" id="wgt_ut_cd__<%=seq%>" style="width:55px;" class="<%=htmlClass%>" value="<%=opusAkVO.getWgtUtCd()%>" <%=htmlReadOnly%>>
									<%	} else {	%>
									<%=HTMLUtil.getComboString("wgt_ut_cd__"+seq, "width:55px;", htmlClass, "",opusAkVO.getWgtUtCd(), "", wgt_cd)%>
									<%	}	%>
									</td>
									<td>Net WGT</td>
									<td colspan="3"><input type="text" name="net_wgt__<%=seq%>" style="width:90px;text-align:right" maxlength="12" dataformat="float" class="<%=htmlClass%>" value="<%=opusAkVO.getNetWgt()%>" <%=htmlReadOnly%>>&nbsp;
									<%	if ( "readOnly".equals(htmlReadOnly) ) {	%>
									<input type="text" name="wgt_ut_cd2__<%=seq%>" style="width:55px;" class="<%=htmlClass%>" value="<%=opusAkVO.getWgtUtCd2()%>" <%=htmlReadOnly%>>
									<%	} else {	%>
									<%=HTMLUtil.getComboString("wgt_ut_cd2__"+seq, "width:55px;", htmlClass, "",opusAkVO.getWgtUtCd2(), "", wgt_cd)%>
									<%	}	%>
									</td>
								</tr>
								<tr>
									<td></td>
									<td>Remark(s)</td>
									<td colspan="2"><textarea name="stwg_rqst_desc__<%=seq%>" dataformat="engup" class="<%=htmlClass%>" style="width:98%;height:40;" <%=htmlReadOnly%>><%=opusAkVO.getStwgRqstDesc()%></textarea></td>
									<td>
									<%
										if ( "Approved".equals(opusAkVO.getStatus()) || "Rejected".equals(opusAkVO.getStatus()) || "Requested".equals(opusAkVO.getStatus()) ) {
									%><!--
									--><button class="btn_etc" name="btn_delete<%=seq%>" id="btn_delete<%=seq%>" type="button">Delete</button>
										<script>ComBtnDisable("btn_delete<%=seq%>")</script>
									<%
										} else {
									%><!--
									--><button onclick="javascript:btn_delete('table<%=seq%>','<%=seq%>');" class="btn_etc" name="btn_delete<%=seq%>" id="btn_delete<%=seq%>" type="button">Delete</button>
									<%
										}
									%>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<%}%>
					<span id="INS_TABLES"></span>
		    	</div>
		    	<!-- opus_design_inquiry (E) -->
			</div>
			
			<!-- wrap_result (S) -->
			<div class="wrap_result" style="display:none">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
			<!-- wrap_result (E) -->
		</form>
	</div>
	<div class="layout_vertical_2" >
		<form name="form2">
			<div class="wrap_search sm">
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
						<tbody>
							<tr>
								<th>Request No.</th>
								<td><input type="text" name="rqst_no2" id="rqst_no2" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
							</tr>
						</tbody>
					</table>
					<%
						int seq2 = 0;
						for (int i=0;i<xterAkList.size();i++) {
							seq2 = i+1;
							BkgXterAwkCgoVO xterAkVO = (BkgXterAwkCgoVO) xterAkList.get(i);
					%>
					<input type="hidden" name="awk_cgo_seq__<%=seq2%>" value="<%=xterAkVO.getAwkCgoSeq()%>">
					<table class="pad_btm_8">
						<colgroup>
							<col width="30" />
							<col width="80" />
							<col width="140" />
							<col width="50" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<td><input type="text" name="cntr_seq__<%=seq2%>" style="width:25px;text-align:center;" class="input" value="<%=seq2%>" readonly="readonly" id="cntr_seq__<%=seq2%>" /></td>
								<th>CNTR No.</th>
								<td><input type="text" name="cntr_no__<%=seq2%>" style="width:105px;" class="input2" value="<%=xterAkVO.getCntrNo()%>" readonly="readonly" id="cntr_no__<%=seq2%>" /><!--
								--><input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:35px;" class="input2" value="<%=xterAkVO.getCntrTpszCd()%>" readonly="readonly" id="cntr_tpsz_cd__<%=seq2%>" /></td>
							</tr>
							<tr>
								<td></td>
								<th>Commodity</th>
								<td colspan="3"><input type="text" name="cmdt_cd__<%=seq2%>" style="width:130px;" class="input2" value="" readonly="readonly" id="cmdt_cd__<%=seq2%>" /><!--
								--><input type="text" name="cmdt_desc__<%=seq2%>" style="width:180px;" class="input2" value="<%=xterAkVO.getCmdtCd()%>" readonly="readonly" id="cmdt_desc__<%=seq2%>" /></td>
							</tr>
							<tr>
								<td></td>
								<th>Length</th>
								<td><input type="text" name="ttl_dim_len__<%=seq2%>" style="width:80px;text-align:right" class="input2" value="<%=xterAkVO.getTtlDimLen()%>" readonly="readonly" id="ttl_dim_len__<%=seq2%>" />  CM</td>
								<th>Width</th>
								<td><input type="text" name="ttl_dim_wdt__<%=seq2%>" style="width:110px;text-align:right" class="input2" value="<%=xterAkVO.getTtlDimWdt()%>" readonly="readonly" id="ttl_dim_wdt__<%=seq2%>" />  CM</td>
							</tr>
							<tr>
								<td></td>
								<th>Height</th>
								<td><input type="text" name="ttl_dim_hgt__<%=seq2%>" style="width:80px;text-align:right" class="input2" value="<%=xterAkVO.getTtlDimHgt()%>" readonly="readonly" id="ttl_dim_hgt__<%=seq2%>" />  CM</td>
								<th>Package</th>
								<td><input type="text" name="pck_qty__<%=seq2%>" style="width:80px;text-align:right" class="input2" value="<%=xterAkVO.getPckQty()%>" readonly="readonly" id="pck_qty__<%=seq2%>" /><!--
								--><input type="text" name="pck_tp_cd__<%=seq2%>" style="width:45px;" class="input2" value="<%=xterAkVO.getPckTpCd()%>" readonly="readonly" id="pck_tp_cd__<%=seq2%>" /></td>
							</tr>
							<tr>
								<td></td>
								<th>Gross WGT</th>
								<td><input type="text" name="grs_wgt__<%=seq2%>" style="width:90px;text-align:right" class="input2" value="<%=xterAkVO.getGrsWgt()%>" readonly="readonly" id="grs_wgt__<%=seq2%>" /><!--
								--><input type="text" name="wgt_ut_cd1__<%=seq2%>" style="width:47px;" class="input2" value="<%=xterAkVO.getWgtUtCd1()%>" readonly="readonly" id="wgt_ut_cd1__<%=seq2%>" /></td>
								<th>Net WGT</th>
								<td><input type="text" name="net_wgt__<%=seq2%>" style="width:90px;text-align:right" class="input2" value="<%=xterAkVO.getNetWgt()%>" readonly="readonly" id="net_wgt__<%=seq2%>" /><!--
								--><input type="text" name="wgt_ut_cd2__<%=seq2%>" style="width:47px;" class="input2" value="<%=xterAkVO.getWgtUtCd2()%>" readonly="readonly" id="wgt_ut_cd2__<%=seq2%>" /></td>
							</tr>
							<tr>
								<td></td>
								<th>Remark(s)</th>
								<td colspan="2"><textarea name="stwg_rqst_desc__<%=seq2%>" style="width:100%;height:40px;resize:none" class="textarea2" readonly="readonly"><%=xterAkVO.getStwgRqstDesc()%></textarea></td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<%}%>
		    	</div>
		    	<!-- opus_design_inquiry (E) -->
			</div>
		</form>
	</div>
</div>
<!-- layout_wrap (E) -->