<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0229_07.jsp
*@FileTitle  : e-Booking & SI Process Detail(REEFER)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022907Event"%>
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
	EsmBkg022907Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	List<OpusCntrTpszVO> cntr_tpsz = null;
	List<OpusRfVO> opusRfList = null;
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

		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		cntr_tpsz = (List<OpusCntrTpszVO>) eventResponse.getCustomData("cntr_tpsz");
		ExternalRqstRfVO rfVO = (ExternalRqstRfVO) eventResponse.getCustomData("externalRqstRfVO");
		opusRfList = rfVO.getOpusRfVO();
		xterRfList = rfVO.getBkgXterRfCgoVO();

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
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		loadCntrTpsz("<%=cntrTpsz_cdStr%>","<%=cntrTpsz_idStr%>");
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


<div class="layout_wrap">
	<div class="layout_vertical_2 pad_rgt_8" >
		<form name="form" id="form">
			<input type="hidden" name="f_cmd" id="f_cmd" />
			<input type="hidden" name="pagerows" id="pagerows" />
			<input type="hidden" name="cntr_no" id="cntr_no" />
			<input type="hidden" name="cmdt_cd" id="cmdt_cd" />
			<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no")) %>" id="bkg_no" />
			<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no")) %>" id="rqst_no" />
			<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
			<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
			<input type="hidden" name="rf_opus" value="<%=(opusRfList.size() > 0)?" y":"n" %>" id="rf_opus" />
			<input type="hidden" name="rf_esvc" value="<%=(xterRfList.size() > 0)?" y":"n" %>" id="rf_esvc" />
			<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />
			<!-- wrap_search (S) -->
			<div class="wrap_search bg">
				<div class="opus_design_grid">
					<h3 class="title_design">Booking Data OPUS</h3>
					<div class="specialCls">
						<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet1');</script>
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
						String tempMeas1 = "+";
						String tempMeas2 = "+";
						float cdoTemp = 0;
						float fdoTemp = 0;
						String htmlClass=null;
						String htmlReadOnly=null;
						String htmlDisabled=null;
						for (int i=0;i<opusRfList.size();i++) {
							seq = i+1;
							OpusRfVO opusRfVO = (OpusRfVO) opusRfList.get(i);
							if(opusRfVO.getCdoTemp() != null && !opusRfVO.getCdoTemp().equals("")){
								if ( opusRfVO.getCdoTemp().indexOf("-") != -1 ) {
									tempMeas1 = "-";
									cdoTemp = Float.valueOf(opusRfVO.getCdoTemp().substring(1, opusRfVO.getCdoTemp().length()));
								} else {
									tempMeas1 = "+";
									cdoTemp = Float.valueOf(opusRfVO.getCdoTemp());
								}
							}
							if(opusRfVO.getFdoTemp() != null && !opusRfVO.getFdoTemp().equals("")){
								if ( opusRfVO.getFdoTemp().indexOf("-") != -1 ) {
									tempMeas2 = "-";
									fdoTemp = Float.valueOf(opusRfVO.getFdoTemp().substring(1, opusRfVO.getFdoTemp().length()));
								} else {
									tempMeas2 = "+";
									fdoTemp = Float.valueOf(opusRfVO.getFdoTemp());
								}
							}
							htmlClass=( "Approved".equals(opusRfVO.getStatus()) || "Rejected".equals(opusRfVO.getStatus()) || "Requested".equals(opusRfVO.getStatus()))?"input2":"input";
							htmlReadOnly=( "Approved".equals(opusRfVO.getStatus()) || "Rejected".equals(opusRfVO.getStatus()) || "Requested".equals(opusRfVO.getStatus()))?"readOnly":"";
							htmlDisabled=( "Approved".equals(opusRfVO.getStatus()) || "Rejected".equals(opusRfVO.getStatus()) || "Requested".equals(opusRfVO.getStatus()))?"disabled":"";
					%>
					<div id="table_<%=seq%>">
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
									<td><!--
									--><input type="hidden" name="cntr_no_cmpr__<%=seq%>" value="<%=opusRfVO.getCntrNo()%><%=opusRfVO.getRcSeq()%>"><!--
									--><input type="text" name="cntr_seq__<%=seq%>" style="width:25px;text-align:center;" class="input" value="<%=seq%>" readOnly="readonly"><!--
									--><input type="hidden" name="rc_seq__<%=seq%>" value="<%=opusRfVO.getRcSeq()%>"></td>
									<th>CNTR No.</th>
									<td>
									<%	if ( "readOnly".equals(htmlReadOnly) ) {	%><!--
									--><input type="text" name="cntr_no__<%=seq%>" style="width:105px;" maxlength="11" dataformat="engup" class="<%=htmlClass%>" value="<%=opusRfVO.getCntrNo()%>" <%=htmlReadOnly%>>
									<%	} else { 	%>
									<%=getCntrTpszCombo("cntr_no__"+String.valueOf(seq).toString(), "width:105px;", htmlClass, "changeCntrNo(this,'"+seq+"')", opusRfVO.getCntrNo(), "", cntr_tpsz)%>
									<%	}	%><!--
									--><input type="text" required caption="Cntr Type Size" name="cntr_tpsz_cd__<%=seq%>" style="width:40px;" maxlength="2" dataformat="engup" class="<%=htmlClass%>" value="<%=opusRfVO.getCntrTpszCd()%>" <%=htmlReadOnly%>>
									</td>
									<th>Status</th>
									<td ><input type="text" name="status__<%=seq%>" style="width:95px;" class="input2" value="<%=opusRfVO.getStatus()%>" readOnly="readonly"></td>
								</tr>
								<tr>
									<td></td>
									<th>Commodity</th>
									<td colspan="3"><input type="text" name="cmdt_cd__<%=seq%>" caption="Commodity" style="width:90px;" maxlength="10" dataformat="engup" class="<%=htmlClass%>" onChange="javascript:changeCmdtDesc(this);" value="<%=opusRfVO.getCmdtCd()%>" <%=htmlReadOnly%>>
									<%
									if ( "Approved".equals(opusRfVO.getStatus()) || "Rejected".equals(opusRfVO.getStatus()) ) {
									%><!--
									--><button type="button" class="input_seach_btn"></button>
									<%
									} else {
									%><!--
									--><button type="button" class="input_seach_btn" onclick="javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__<%=seq%>.value, '<%=seq%>');"></button>
									<%
									}
									%><!--
									--><input type="text" name="cmdt_desc__<%=seq%>" maxlength="4000" style="width:190px;" class="<%=htmlClass%>" dataformat="engup" value="<%=opusRfVO.getCmdtDesc()%>" <%=htmlReadOnly%>></td>
								</tr>
								<tr>
									<td></td>
									<th>Temperature</th>
									<td>
									  <select name="temperature1__<%=seq%>" id="temperature1__<%=seq%>" class="<%=htmlClass%>" style="width:40px;text-align:center;" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlDisabled%>>
										<option value="-" <%=("-".equals(tempMeas1))?"selected":""%>>-</option>
										<option value="+" <%=("+".equals(tempMeas1))?"selected":""%>>+</option>
									  </select><!--
									  --><input type="text" required caption="Temperature" name="cdo_temp__<%=seq%>" dataformat="float" pointcount="1" maxlength="4" style="width:40px;text-align:right;" class="<%=htmlClass%>" value="<%=cdoTemp%>" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlReadOnly%>>&nbsp;C<!--
									  --><select name="temperature2__<%=seq%>" class="<%=htmlClass%>" style="width:40px;text-align:center;" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlDisabled%>>
										<option value="-" <%=("-".equals(tempMeas2))?"selected":""%>>-</option>
										<option value="+" <%=("+".equals(tempMeas2))?"selected":""%>>+</option>
									  </select><!--
									  --><input type="text" required caption="Temperature" name="fdo_temp__<%=seq%>" dataformat="float" pointcount="1" maxlength="4" style="width:40px;text-align:right;display:" class="<%=htmlClass%>" value="<%=fdoTemp%>" onChange="javascript:changeTemperature(this,'<%=seq%>')" <%=htmlReadOnly%>>&nbsp;F
									</td>
									<th>Genset</th>
									<td>
									  <select name="pwr_spl_cbl_flg__<%=seq%>" id="pwr_spl_cbl_flg__<%=seq%>" class="<%=htmlClass%>" style="width:72px;text-align:center;" <%=htmlDisabled%>>
										<option value="Y" <%=("Y".equals(opusRfVO.getPwrSplCblFlg()))?"selected":""%>>Yes</option>
										<option value="N" <%=("N".equals(opusRfVO.getPwrSplCblFlg()))?"selected":""%>>No</option>
									  </select>
									</td>
								</tr>
								<tr>
									<td></td>
									<th>Ventilation</th>
									<td colspan="3"><input type="text" name="vent_rto__<%=seq%>" caption="Ventilation" style="width:40px;text-align:right;" maxlength="3" dataformat="num" class="<%=htmlClass%>" value="<%=opusRfVO.getVentRto()%>" <%=htmlReadOnly%>><!-- 
								 	--><select name="cntr_vent_tp_cd__<%=seq%>" id="cntr_vent_tp_cd__<%=seq%>" class="<%=htmlClass%>" style="width:80px;text-align:center;" <%=htmlDisabled%>>
								 			<option value="P" <%=("P".equals(opusRfVO.getCntrVentTpCd()))?"selected":""%>>% Open</option>
								 			<option value="C" <%=("C".equals(opusRfVO.getCntrVentTpCd()))?"selected":""%>>CMH</option>
								 		</select>
								 	</td>
								</tr>
								<tr>
									<td></td>
									<th>Nature</th>
									<td>
										<%-- <script type="text/javascript">
											ComComboObject("clng_tp_cd__<%=seq%>", 1, 105, 1, <%="input".equals(htmlClass)?0:3%>, 0);
										</script><
										<input type="hidden" name="initComboName" value="clng_tp_cd__<%=seq%>">
										<input type="hidden" name="initComboCode" value="<%=opusRfVO.getClngTpCd()%>">
										<input type="hidden" name="initComboEnable" value="<%="input".equals(htmlClass)?1:0%>"> --%>
										
										
										<select name="clng_tp_cd__<%=seq%>" class="<%=htmlClass%>" style="width:105;text-align:center;" <%=htmlDisabled%>>
													    <option value="C" <%=("C".equals(opusRfVO.getClngTpCd()))?"selected":""%>>Chilled</option>
													    <option value="F" <%=("F".equals(opusRfVO.getClngTpCd()))?"selected":""%>>Frozen</option>
													    <option value="S" <%=("S".equals(opusRfVO.getClngTpCd()))?"selected":""%>>Fresh</option>
													  </select>
									</td>
									<th>Humidity</th>
									<td><input type="text" name="humid_no__<%=seq%>" caption="Humidity" style="width:35px;text-align:right;" maxlength="3" dataformat="num" maxnum="100" pointcount="1" class="<%=htmlClass%>" value="<%=opusRfVO.getHumidNo()%>" <%=htmlReadOnly%>>%
									</td>
								</tr>
								<tr>
									<td></td>
									<th>Remark(s)</th>
									<td colspan="2"><textarea name="diff_rmk__<%=seq%>" id="diff_rmk__<%=seq%>" class="<%=htmlClass%>" style="width:320px;height:40px;" <%=htmlReadOnly%> dataformat="engup"><%=opusRfVO.getDiffRmk()%></textarea>
									</td>
									<td>
									<%
									if ( "Approved".equals(opusRfVO.getStatus()) || "Rejected".equals(opusRfVO.getStatus()) || "Requested".equals(opusRfVO.getStatus()) ) {
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
					<% } %>
					<span id="INS_TABLES"></span>
				</div>
				<!-- opus_design_inquiry (E) -->
			</div>
			<!-- wrap_search (E) -->
			
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
			<div class="opus_design_grid" style="display:none">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<div class="wrap_search bg">
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
					String tempMeas21 = "+";
					float cdoTemp2 = 0;
					for (int i=0;i<xterRfList.size();i++) {
						seq2 = i+1;
						BkgXterRfCgoVO xterRfVO = (BkgXterRfCgoVO) xterRfList.get(i);
						
						String cntrVentCd = xterRfVO.getCntrVentCd();
						String  cntrVentText = "";
						if(cntrVentCd.equals("C")){
							cntrVentText = "CMH";
						}else if(cntrVentCd.equals("M")){
							cntrVentText = "<font color='red'>cfm</font>";
						}else{
							cntrVentText = "% open";
						}
						
						if ( xterRfVO.getMinTemp().indexOf("-") != -1 ) {
							tempMeas21 = "-";
							cdoTemp2 = Float.valueOf(xterRfVO.getMinTemp().substring(1, xterRfVO.getMinTemp().length()));
						} else {
							tempMeas21 = "+";
							cdoTemp2 = Float.valueOf(xterRfVO.getMinTemp());
						}
					%>
					<input type="hidden" name="cntr_no_cmpr__<%=seq2%>" style="width:88px;" class="input" value="<%=xterRfVO.getCntrNo()%><%=xterRfVO.getRcSeq()%>">				
					<table>
						<colgroup>
							<col width="30" />
							<col width="90" />
							<col width="180" />
							<col width="50" />
							<col width="*" />
						</colgroup>
						<tr>
							<td><input type="text" name="cntr_seq__<%=seq2%>" style="width:25px;text-align:center;" class="input" value="<%=seq2%>" readOnly="readonly"></td>
							<th>CNTR No.</th>
							<td colspan="3"><!--
							--><input type="text" name="cntr_no__<%=seq2%>" style="width:105px;" class="input2" value="<%=xterRfVO.getCntrNo()%>" readOnly="readonly"><!--
							--><input type="hidden" name="rc_seq__<%=seq2%>" style="width:55px;" class="input2" value="<%=xterRfVO.getRcSeq()%>" readOnly="readonly"><!--
							--><input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:55px;" class="input2" value="<%=xterRfVO.getCntrTpszCd()%>" readOnly="readonly">
							</td>
						</tr>
						<tr>
							<td></td>
							<th>Commodity</th>
							<td colspan="3"><!--
							--><input type="text" name="cmdt_cd__<%=seq2%>" style="width:130px;" class="input2" value="<%=xterRfVO.getCmdtCd()%>" readOnly="readonly"><!--
							--><input type="text" name="cmdt_desc__<%=seq2%>" style="width:180px;" class="input2" value="<%=xterRfVO.getCmdtDesc()%>" readOnly="readonly">
							</td>
						</tr>
						<tr>
							<td></td>
							<th>Temperature</th>
							<td><!--
							--><input type="text" name="temperature1__<%=seq2%>" style="width:40px;" class="input2" value="<%=tempMeas21%>" readOnly="readonly"><!--
							--><input type="text" name="min_temp__<%=seq2%>" style="width:40px;text-align:right;" class="input2" value="<%=cdoTemp2%>" readOnly="readonly"><!--
							--><input type="text" name="min_temp_ut_cd__<%=seq2%>" style="width:42px;" class="input2" value="<%=xterRfVO.getMinTempUtCd()%>" readOnly="readonly">
							</td>
							<th>Genset</th>
							<td><input type="text" name="pwr_spl_cbl_flg__<%=seq2%>" style="width:74px;" class="input2" value="<%=xterRfVO.getPwrSplCblFlg()%>" readOnly="readonly"></td>
						</tr>
						<tr>
							<td></td>
							<th>Ventilation</th>
							<td colspan="3"><!--
							--><input type="text" name="vent_rto__<%=seq2%>" style="width:40px;text-align:right;" class="input2" value="<%=xterRfVO.getVentRto()%>" readOnly="readonly">&nbsp;<%=cntrVentText%><input type="hidden" name="cntr_vent_tp_cd__<%=seq2%>" style="width:40px;text-align:right;" class="input2" value="<%=xterRfVO.getCntrVentCd()%>" readOnly="readonly"></td>
						</tr>
						<tr>
							<td></td>
							<th>Nature</th>
							<td><input type="text" name="clng_tp_cd__<%=seq2%>" style="width:130px;" class="input2" value="<%=xterRfVO.getClngTpCd()%>" readOnly="readonly"></td>
							<th>Humidity</th>
							<td><input type="text" name="humid_no__<%=seq2%>" style="width:35px;text-align:right;" class="input2" value="<%=xterRfVO.getHumidNo()%>" readOnly="readonly">%</td>
						</tr>
						<tr>
							<td></td>
							<th>Remark(s)</th>
							<td colspan="3"><textarea name="diff_rmk__<%=seq2%>" id="diff_rmk__<%=seq2%>" style="width:320px;height:40px; resize:none" class="textarea2" readonly="readonly"><%=xterRfVO.getDiffRmk()%></textarea></td>
						</tr>
					</table>
					<% } %>
				</div>
				<!-- opus_design_inquiry (E) -->
			</div>
		</form>
	</div>
</div>
<!-- layout_wrap(E) -->