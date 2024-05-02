<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_03.jsp
*@FileTitle  : e-Booking & SI Process Detail(CONTAINER) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022903Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO" %>
<%@ page import="com.clt.syscommon.common.table.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
	EsmBkg022903Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");

	List<BkgComboVO> wgt_cd 			= null;
	List<BkgComboVO> meas_cd 			= null;
	List<BkgComboVO> rcv_term_cd		= null;
	List<BkgComboVO> de_term_cd		= null;
	List<ContainerVO> opusCntrList = null;
	List<BkgCntrSealNoVO> opusCntrSealNoList = null;
	List<XterCntrVO> xterCntrList = null;
	List<BkgXterCntrSealNoVO> xterCntrSealNoList = null;
	String sXml = null;

	String wgt_cd_list = "";
	String wgt_nm_list = "";
	String meas_cd_list = "";
	String meas_nm_list = "";
	String rcv_term_cd_list = "";
	String de_term_cd_list =  "";

	String fnl_cfm_flg = ""; 
	String evnt_usr_id = "";
	String evnt_dt = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg022903Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

		ExternalRqstCntrVO rqstCnrtVo = (ExternalRqstCntrVO) eventResponse.getCustomData("externalRqstCntrVO");
		CntrInfoOutVO bkgCntrVO  = (CntrInfoOutVO) eventResponse.getCustomData("bkgCntrVO");
		opusCntrList = bkgCntrVO.getCntrs();
		opusCntrSealNoList = bkgCntrVO.getCntrSealNos();

		xterCntrList = rqstCnrtVo.getXterCntrVO();
		if(xterCntrList == null) xterCntrList = new ArrayList<XterCntrVO>();
		xterCntrSealNoList = rqstCnrtVo.getBkgXterCntrSealNoVO();
		if(xterCntrSealNoList == null) xterCntrSealNoList = new ArrayList<BkgXterCntrSealNoVO>();
		
		wgt_cd 			= (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");
		meas_cd 		= (List<BkgComboVO>) eventResponse.getCustomData("meas_cd");
		rcv_term_cd    	= (List<BkgComboVO>) eventResponse.getCustomData("rcv_term_cd");
		de_term_cd    	= (List<BkgComboVO>) eventResponse.getCustomData("de_term_cd");
		fnl_cfm_flg     = eventResponse.getETCData("fnl_cfm_flg");
		evnt_usr_id     = eventResponse.getETCData("evnt_usr_id");
		evnt_dt     	= eventResponse.getETCData("evnt_dt");
		for(int i=0;i<wgt_cd.size();i++){
			if ( i == 0 ) {
				wgt_cd_list = ((BkgComboVO )wgt_cd.get(i)).getVal();
				wgt_nm_list = ((BkgComboVO )wgt_cd.get(i)).getName();
			} else {
				wgt_cd_list = wgt_cd_list + "|" + ((BkgComboVO )wgt_cd.get(i)).getVal();
				wgt_nm_list = wgt_nm_list + "|" + ((BkgComboVO )wgt_cd.get(i)).getName();
			}			
		}
		for(int i=0;i<meas_cd.size();i++){
			if ( i == 0 ) {
				meas_cd_list = ((BkgComboVO )meas_cd.get(i)).getVal();
				meas_nm_list = ((BkgComboVO )meas_cd.get(i)).getName();
			} else {
				meas_cd_list = meas_cd_list + "|" + ((BkgComboVO )meas_cd.get(i)).getVal();
				meas_nm_list = meas_nm_list + "|" + ((BkgComboVO )meas_cd.get(i)).getName();
			}			
		}
		for(int i=0;i<rcv_term_cd.size();i++){
			if ( i == 0 ) {
				rcv_term_cd_list = ((BkgComboVO )rcv_term_cd.get(i)).getVal();
			} else {
				rcv_term_cd_list = rcv_term_cd_list + "|" + ((BkgComboVO )rcv_term_cd.get(i)).getVal();
			}			
		}
		for(int i=0;i<de_term_cd.size();i++){
			if ( i == 0 ) {
				de_term_cd_list = ((BkgComboVO )de_term_cd.get(i)).getVal();
			} else {
				de_term_cd_list = de_term_cd_list + "|" + ((BkgComboVO )de_term_cd.get(i)).getVal();
			}			
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		wgt_cd_list = 	"<%=wgt_cd_list%>";
		wgt_nm_list = 	"<%=wgt_nm_list%>";
		meas_cd_list =  "<%=meas_cd_list%>";
		meas_nm_list =  "<%=meas_nm_list%>";
		rcv_term_cd_list = 	"<%=rcv_term_cd_list%>";
		de_term_cd_list =  "<%=de_term_cd_list%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
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

.select-editable {
	position: relative;
/* 	background-color: white; */
/* 	border: solid grey 1px; */
	width: 120px;
	height: 18px;
}

.select-editable select {
	position: absolute;
	top: 0px;
	left: 0px;
	font-size: 14px;
/* 	border: none; */
	width: 120px;
/* 	margin: 0; */
}

.select-editable input {
	position: absolute;
	top: 1px;
	left: 1px;
	width: 113px;
	height:23px;
/* 	border-right-style:none; */
/* 	padding: 1px; */
/* 	font-size: 12px; */
 	border: none;  
}

.select-editable select:focus, .select-editable input:focus {
	outline: none;
}
</style>

<!-- layout_wrap (S) -->
<div class="layout_wrap">
	<div class="layout_vertical_2 pad_rgt_8" >
		<form name="form">
			<input type="hidden" name="f_cmd" id="f_cmd" />
			<input type="hidden" name="pagerows" id="pagerows" />
			<input type="hidden" name="cntr_no" id="cntr_no" />
			<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no")) %>" id="bkg_no" />
			<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no")) %>" id="rqst_no" />
			<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
			<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
			<input type="hidden" name="cntr_opus" value="<%%>" id="cntr_opus" />
			<input type="hidden" name="cntr_esvc" value="<%=(xterCntrList.size() > 0)?" y":"n" %>" id="cntr_esvc" />
			<!-- CNTR Flag	-->
			<input type="hidden" name="dirty_flag" value="Y" id="dirty_flag" />
			<input type="hidden" name="bdr_flg" value="N" id="bdr_flg" />
			<input type="hidden" name="fnl_cfm_flg" value="<%=fnl_cfm_flg%>" id="fnl_cfm_flg" />
			<input type="hidden" name="modify_fnl_cfm_flg" id="modify_fnl_cfm_flg" />
			<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">	
			<div class="wrap_search sm">
				<div class="opus_design_grid">
					<h3 class="title_design">Booking Data OPUS</h3>
					<div class="specialCls">
						<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
					</div>
				</div>
				<!-- opus_design_inquiry (S) -->
				<div id="INS_TABLES" class="opus_design_inquiry">
			    	<table>
						<colgroup>
							<col width="80">
							<col width="120">
							<col width="80">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Booking No.</th>
								<td><input type="text" name="bkg_no2" id="bkg_no2" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
								<th>Final Confirm</th>
								<td><input type="text" name="evnt_usr_id2" style="width:80px;" class="input2" value="<%=evnt_usr_id==null?"":evnt_usr_id%>" id="evnt_usr_id2" readonly="readonly"/><!--
								--><input type="text" name="evnt_dt2" style="width:70px;" class="input2" value="<%=evnt_dt==null?"":evnt_dt%>" id="evnt_dt2" readonly="readonly"/></td>
							</tr>
						</tbody>
					</table>
					<%
						int seq = 0;
						for (int i=0;i<opusCntrList.size();i++) {
							seq = i+1;
							ContainerVO opusCntr = (ContainerVO) opusCntrList.get(i);
					%>
					<div id="table_<%=seq%>">
						<table id="table<%=seq%>">
							<colgroup>
								<col width="60" />
								<col width="140" />
								<col width="70" />
								<col width="100" />
								<col width="50" />
								<col width="*" />
							</colgroup>	
							<tbody>
								<tr>
									<td><input type="hidden" name="table<%=seq%>" value="table<%=seq%>" id="table<%=seq%>" /></td>
									<td><input type="hidden" name="cntr_no_hidden__<%=seq%>" value="<%=opusCntr.getCntrNo()%>1" id="cntr_no_hidden__<%=seq%>" /></td>
									<td><input type="hidden" name="ibflag__<%=seq%>" value="U" id="ibflag__<%=seq%>" /></td>
								</tr>
								<tr>
									<th><input type="text" name="cntr_seq__<%=seq%>" style="width: 25px; text-align:center;" class="input" value="<%=seq%>" readonly id="cntr_seq__<%=seq%>" />CNTR No.</th>
									<td><input type="text" name="cntr_no__<%=seq%>" style="width: 95px;" maxlength="14" dataformat="engup" id="cntr_no__<%=seq%>" class=<%=("Y".equals(fnl_cfm_flg))?"input2":"input" %> value="<%=opusCntr.getCntrNo()%>" onChange="javascript:changeCntrTpszCd(this);"><input type="text" name="cntr_tpsz_cd__<%=seq%>" style="width: 30px;" maxlength="4" dataformat="engup" class=<%=("Y".equals(fnl_cfm_flg))?"input2":"input" %> value="<%=opusCntr.getCntrTpszCd()%>"></td>
									<th>Seal No.</th>
									<td>
									<div class="select-editable">
									<select name="cntr_seal_no__<%=seq%>" id="cntr_seal_no__<%=seq%>" onchange="javascript:sealNoChange(this,<%=seq%>)" style="width: 138px;"> 
									<%
										for (int j=0; j<opusCntrSealNoList.size(); j++) {
											BkgCntrSealNoVO opusCntrSealNo = (BkgCntrSealNoVO) opusCntrSealNoList.get(j);
											if ( opusCntrSealNo.getCntrNo().equals(opusCntr.getCntrNo()) ) {
									%>
											<option value="<%=replaceNull(opusCntrSealNo.getCntrSealNo())%>"><%=replaceNull(opusCntrSealNo.getCntrSealNo())%></option>
									<%
											}
										}
									%>
									</select>
									<input type="text" class="input" id="seal_no_text_<%=seq%>" name="seal_no_text_<%=seq%>" onchange='javascript:sealNoCheck(this,<%=seq%>);' />
									<script type="text/javascript"> document.form.seal_no_text_<%=seq%>.value = document.form.cntr_seal_no__<%=seq%>.value; </script>
									</div>
									</td>
									<th>P <input type="checkbox" value="" class="trans" name="cntr_prt_flg__<%=seq%>" value="<%=opusCntr.getCntrPrtFlg()%>" <%=("Y".equals(opusCntr.getCntrPrtFlg()))?"checked":""%> <%=("Y".equals(fnl_cfm_flg))?"disabled":""%>></th>
									<td></td>
								</tr>
								<tr>
									<th>Package</th>
									<td><input type="text" name="pck_qty__<%=seq%>" id="pck_qty__<%=seq%>" style="width:65px;text-align:right" maxlength="12" dataformat="num" class="input" value="<%=opusCntr.getPckQty()%>" id="pck_qty__<%=seq%>" />
									<input type="text" name="pck_tp_cd__<%=seq%>" id="pck_tp_cd__<%=seq%>" style="width:27px;" dataformat="engup" class="input" value="<%=opusCntr.getPckTpCd()%>">
									<a href="javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__<%=seq%>.value, '<%=seq%>');"><button type="button" class="input_seach_btn"></button></a></td>
									<th>Weight</th>
									<td>
										<input type="text" name="cntr_wgt__<%=seq%>" style="width:70px;text-align:right" maxlength="18" dataformat="float" pointcount="3" class="input" value="<%=opusCntr.getCntrWgt()%>" id="cntr_wgt__<%=seq%>" />
										<%=HTMLUtil.getComboString("wgt_cd__"+seq, "width:60px;", "", "",opusCntr.getWgtUtCd(), "", wgt_cd)%>
									</td>
									<th>VGM</th>
									<td>
										<input type="text" name="vgm_wgt__<%=seq%>" style="width:70px;text-align:right" class="input2" value="<%=opusCntr.getVgmWgt()%>" readOnly><!--
										--><input type="text" name="vgm_wgt_ut_cd__<%=seq%>" style="width:44px;" class="input2" value="<%=opusCntr.getVgmWgtUtCd()%>" readOnly>
									</td>
								</tr>
								<tr>
									<th>Measure</th>
									<td><input type="text" name="meas_qty__<%=seq%>" style="width:65px;text-align:right" maxlength="12" dataformat="float" pointcount="3" class="input" value="<%=opusCntr.getMeasQty()%>" id="meas_qty__<%=seq%>" /><%=HTMLUtil.getComboString("meas_cd__"+seq, "width:70px;", "", "",opusCntr.getMeasUtCd(), "", meas_cd)%></td>
									<th>R/D Term</th>
									<td><%=HTMLUtil.getComboString("rcv_term_cd__"+seq, "width:51px;", "", "",opusCntr.getRcvTermCd(), "", rcv_term_cd)%><%=HTMLUtil.getComboString("de_term_cd__"+seq, "width:51px;", "", "",opusCntr.getDeTermCd(), "", de_term_cd)%></td>
									<td colspan="2">
										<div class="specialCls">
												<%
													if ( "Y".equals(fnl_cfm_flg) ) {
												%>
														<button onclick="btn_deleteTable('table_<%=seq%>','<%=seq%>')" style="cursor: pointer;" type="button" class="btn_etc" name="btn_delete<%=seq%>" id="btn_delete<%=seq%>">Delete</button>
														<script>ComBtnDisable("btn_delete<%=seq%>")</script>
												<%
													} else {
												%>
															<button onclick="btn_deleteTable('table<%=seq%>','<%=seq%>')" style="cursor: pointer;" type="button" class="btn_etc" name="btn_delete<%=seq%>" id="btn_delete<%=seq%>">Delete</button>
												<%
													}
												%>
										</div>
									</td>
								</tr>
								<tr>
									<td><input type="hidden" name="po_no__<%=seq%>" style="width:115px;" maxlength="20" dataformat="engup" class="input" value="<%=opusCntr.getPoNo()%>" id="po_no__<%=seq%>" /> </td>
								</tr>
								<tr class="height_10"><td colspan="8"></td></tr>
							</tbody>
						</table>
					</div>
					<%
						}
					%>
		    	</div>
		    	<!-- opus_design_inquiry (E) -->
			</div>
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
						for (int i=0;i<xterCntrList.size();i++) {
							seq2 = i+1;
							XterCntrVO xterCntr = (XterCntrVO) xterCntrList.get(i);
							String vgmWgt = xterCntr.getVgmWgt()==""? "0" : xterCntr.getVgmWgt();
					%>
					<script type="text/javascript">
						var vgmWgt = "<%=vgmWgt%>";
						if(vgmWgt == 0 || vgmWgt == '0'){
							vgmCheckData += '<%=xterCntr.getCntrNo()%>' + "=N,";
						}else{
							vgmCheckData += '<%=xterCntr.getCntrNo()%>' + "=Y,";
						}
					</script>
					<input type="hidden" name="cntr_no_hidden__<%=seq2%>" value="<%=xterCntr.getCntrNo()%><%=xterCntr.getCntrSeq()%>">
					<table>
						<colgroup>
							<col width="30" />
							<col width="60" />
							<col width="140" />
							<col width="70" />
							<col width="100" />
							<col width="50" />
							<col width="*" />
						</colgroup>		
						<tbody>
							<tr>
								<td><input type="text" name="cntr_seq__<%=seq2%>" style="width:25px;" class="input2" value="<%=seq2%>" readOnly></td>
								<th>CNTR No.</th>
								<td><input type="text" name="cntr_no__<%=seq2%>" style="width:90px;" class="input2" value="<%=xterCntr.getCntrNo()%>" readOnly><!--
								--><input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:26px;" class="input2" value="<%=xterCntr.getCntrTpszCd()%>" readOnly></td>
								<th>Seal No.</th>
								<td>
								<select name="cntr_seal_no__<%=seq2%>" class="input2" style="width:118px;">
								<%
									for (int j=0;j<xterCntrSealNoList.size();j++) {
										BkgXterCntrSealNoVO xterCntrSealNo = (BkgXterCntrSealNoVO) xterCntrSealNoList.get(j);
										if ( xterCntrSealNo.getCntrNo().equals(xterCntr.getCntrNo()) ) {
								%>
									<option value="<%=replaceNull(xterCntrSealNo.getXterCntrSealNo())%>"><%=replaceNull(xterCntrSealNo.getXterCntrSealNo())%></option>
								<%
										}
									}
								%>
								</select>
								</td>
								<th><label for="prt_flg__<%=seq2%>"><strong>P</strong></label><input type="checkbox" name="prt_flg__<%=seq2%>" id="prt_flg__<%=seq2%>" value="<%=xterCntr.getPrtFlg()%>" <%=("Y".equals(xterCntr.getPrtFlg()))?"checked":""%> class="trans" disabled></th>
							</tr>
							<tr>
								<td></td>
								<th>Package</th>
								<td><input type="text" name="pck_qty__<%=seq2%>" style="width:65px;text-align:right" class="input2" value="<%=xterCntr.getPckQty()%>" readOnly><!--
								--><input type="text" name="pck_tp_cd__<%=seq2%>" style="width:51px;" class="input2" value="<%=xterCntr.getPckTpCd()%>" readOnly></td>
								<th>Weight</th>
								<td><input type="text" name="cntr_wgt__<%=seq2%>" style="width:70px;text-align:right" class="input2" value="<%=xterCntr.getCntrWgt()%>" readOnly><!--
								--><input type="text" name="wgt_cd__<%=seq2%>" style="width:44px;" class="input2" value="<%=xterCntr.getWgtUtCd()%>" readOnly>
								</td>
								<th>VGM</th>
								<td><input type="text" name="vgm_wgt__<%=seq2%>" style="width:70px;text-align:right" class="input2" value="<%=vgmWgt%>" readOnly><!--
								--><input type="text" name="vgm_wgt_ut_cd__<%=seq2%>" style="width:44px;" class="input2" value="<%=xterCntr.getVgmWgtUtCd()%>" readOnly>
								</td>
							</tr>
							<tr>
								<td></td>
								<th>Measure</th>
								<td><input type="text" name="meas_qty__<%=seq2%>" style="width:65px;text-align:right" class="input2" value="<%=xterCntr.getMeasQty()%>" readOnly><!--
								--><input type="text" name="meas_cd__<%=seq2%>" style="width:51px;" class="input2" value="<%=xterCntr.getMeasUtCd()%>" readOnly>
								</td>
								<th>R/D Term</th>
								<td><input type="text" name="rcv_term_cd__<%=seq2%>" style="width:70px;" class="input2" value="" readOnly><!--
								--><input type="text" name="de_term_cd__<%=seq2%>" style="width:44px;" class="input2" value="" readOnly></td>
							</tr>
							<tr>								
								<td colspan="5"><input type="hidden" name="po_no__<%=seq2%>" style="width:117px;" class="input2" value="<%=xterCntr.getPoNo()%>" readOnly></td>
							</tr>
						</tbody>
					</table>
					<%
						}
					%>
		    	</div>
		    	<!-- opus_design_inquiry (E) -->
			</div>
		</form>
	</div>
</div>
<!-- layout_wrap (E) -->

<!-- wrap_result (S) -->
<div class="wrap_result" style="display:none">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- wrap_result (E) -->

<%!public String replaceNull(String str) {
		return (str == null || str.trim().length() == 0 || "null".equals(str)) ? ""
				: str;
}%>