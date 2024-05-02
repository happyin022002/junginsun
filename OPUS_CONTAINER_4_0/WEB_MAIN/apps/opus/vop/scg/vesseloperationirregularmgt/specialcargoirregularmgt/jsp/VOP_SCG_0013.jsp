<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0013.jsp
*@FileTitle  :  SPCL CGO Irregular Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
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
<%@ page import="com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
	VopScg0013Event  event 	= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg 		= "";				//error message
	int rowCount	 		= 0;				//count of DB resultSET list

	String successFlag 		= "";
	String codeList  		= "";
	String pageRows  		= "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationIrregularMgt.SpecialCargoIrregularMgt");

	String vsl_cd           = "";
	String skd_voy_no       = "";
	String skd_dir_cd       = "";
	String spcl_cgo_irr_seq = "";
	String authYn           = "";
	
	//Pre Condition
	String pop_mode     = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopScg0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vsl_cd           = request.getParameter("vsl_cd")==null?"":request.getParameter("vsl_cd");
		skd_voy_no       = request.getParameter("skd_voy_no");
		skd_dir_cd       = request.getParameter("skd_dir_cd");
		spcl_cgo_irr_seq = request.getParameter("spcl_cgo_irr_seq");
		
		//:2015-05-26:by TOP:://authYn           = request.getParameter("ofc_cd")==null?"":request.getParameter("ofc_cd");
		//:2015-05-26:by TOP:://authYn           = authYn.equals(strOfc_cd)?"Y":"N";
		authYn			= "N";
		
		//Pre Condition - 
		pop_mode     	 = request.getParameter("pop_mode")==null?"N":request.getParameter("pop_mode");
		pop_mode		 = StringUtil.xssFilter(pop_mode);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	var userId = '<%=strUsr_id%>';
	var curDate = '<%=DateTime.getFormatDate(new java.util.Date(),"yyyy-MM-dd")%>';

	//Initial retrieve condition
	var preConds = {
		vsl_cd            : "<%=StringUtil.xssFilter(vsl_cd)%>",
		skd_voy_no        : "<%=StringUtil.xssFilter(skd_voy_no)%>",
		skd_dir_cd        : "<%=StringUtil.xssFilter(skd_dir_cd)%>",
		spcl_cgo_irr_seq  : "<%=StringUtil.xssFilter(spcl_cgo_irr_seq)%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		var preCondition = new Array();

		preCondition[0] = ["vsl_cd","<%=StringUtil.xssFilter(vsl_cd)%>"];    
		preCondition[1] = ["skd_voy_no","<%=StringUtil.xssFilter(skd_voy_no)%>"]; 
		preCondition[2] = ["skd_dir_cd","<%=StringUtil.xssFilter(skd_dir_cd)%>"]; 
		preCondition[3] = ["spcl_cgo_irr_seq","<%=StringUtil.xssFilter(spcl_cgo_irr_seq)%>"];  

		if(preCondition[0][1] != '') {		

			//show close button
			document.all.btn_Close.style.display = "";

			//deactivate button
			var authYn = "<%=StringUtil.xssFilter(authYn)%>";
			
			//:2015-05-26:by TOP:://if(authYn == 'N') {
			//:2015-05-26:by TOP:://	ComBtnDisable("btn_RowAdd");
			//:2015-05-26:by TOP:://	ComBtnDisable("btn_RowInsert");
			//:2015-05-26:by TOP:://	ComBtnDisable("btn_RowCopy");
			//:2015-05-26:by TOP:://	ComBtnDisable("btn_Delete");
			//:2015-05-26:by TOP:://	ComBtnDisable("btn_Delete2");
			//:2015-05-26:by TOP:://	ComBtnDisable("btn_Save");
			//:2015-05-26:by TOP:://}

			//Set title of page
			//:2015-05-26:by TOP:://var titleStr = "SPCL CGO Irregular Inquiry";
			//:2015-05-26:by TOP:://if(authYn == 'Y') titleStr = "SPCL CGO Irregular Creation";
			
			//:2015-05-26:by TOP:://try {
			//:2015-05-26:by TOP:://	var appName = navigator.appName;
			//:2015-05-26:by TOP::// 	if (appName.indexOf("Netscape") == -1) {
			//:2015-05-26:by TOP:://  		document.all.navigation.innerHTML = "";
			//:2015-05-26:by TOP:://  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			//:2015-05-26:by TOP:://  		document.title = titleStr;
			//:2015-05-26:by TOP::// 	} else {
			//:2015-05-26:by TOP:://  		document.getElementById("navigation").innerHTML = "";
			//:2015-05-26:by TOP:://  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			//:2015-05-26:by TOP:://  		document.title = titleStr;
			//:2015-05-26:by TOP::// 	}

			 	/* document.getElementById("mainTbl1").className   = "popup";
			 	document.getElementById("mainTbl2").cellPadding = "10";
			 	document.getElementById("topLine").className    = "top"; */
			 	
			//:2015-05-26:by TOP:://}catch(err) {
			//:2015-05-26:by TOP::// 	ComShowMessage(err);
			//:2015-05-26:by TOP:://}
			
		}

		loadPage(preCondition);
	}

	<%=ConstantMgr.getCompanyCodeToJS()%>
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<input type="hidden" name="set_vsl_cd" id="set_vsl_cd" />
<input type="hidden" name="set_skd_voy_no" id="set_skd_voy_no" />
<input type="hidden" name="set_skd_dir_cd" id="set_skd_dir_cd" />
<input type="hidden" name="set_irr_occr_dt" id="set_irr_occr_dt" />
<input type="hidden" name="set_cgo_opr_cd" id="set_cgo_opr_cd" />
<input type="hidden" name="set_bkg_no" id="set_bkg_no" />
<input type="hidden" name="set_bkg_no_split" id="set_bkg_no_split" />
<input type="hidden" name="set_bl_no" id="set_bl_no" />
<input type="hidden" name="set_cntr_no" id="set_cntr_no" />
<input type="hidden" name="set_spcl_cgo_cate_cd" id="set_spcl_cgo_cate_cd" />
<input type="hidden" name="spcl_cgo_irr_seq" value="" id="spcl_cgo_irr_seq" />
<input type="hidden" name="dcgo_flg" id="dcgo_flg" />
<input type="hidden" name="rc_flg" id="rc_flg" />
<input type="hidden" name="awk_cgo_flg" id="awk_cgo_flg" />
<input type="hidden" name="bb_cgo_flg" id="bb_cgo_flg" />
<input type="hidden" name="pagerows" id="pagerows" />

<% if (pop_mode.equals("Y")) { %>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>SPCL CGO Irregular Creation</span></h2>
		
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_New" 		id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Delete2" 	id="btn_Delete2">Delete</button>
		<button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close" style="display:none">Close</button>
		</div>
	</div>
</div>	

<% }else{%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_New" 		id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Delete2" 	id="btn_Delete2">Delete</button>
		<button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close" style="display:none">Close</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>

<% }%>	

<% if (pop_mode.equals("Y")) { %><div class="layer_popup_contents"><%}%>
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100" />
					<col width="320" />
					<col width="100" />
					<col width="345" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>VVD CD</th>
						<td><input name="vsl_cd" required  type="text" style="width:55px;" class="input1" value="" caption="Vessel Code" maxlength="4" dataformat="engup" id="vsl_cd" /><!--  
							 --><input name="skd_voy_no" required  type="text" style="width:40px;" class="input1" value="" caption="Schedule Voyage Number" maxlength="4" dataformat="num" id="skd_voy_no" /><!--
							 --><input name="skd_dir_cd" required  type="text" style="width:20px;" class="input1" value="" caption="Schedule Direction Code" maxlength="1" dataformat="engup" id="skd_dir_cd" /><!--
							 --><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button><!--
							 --><input name="vsl_eng_nm" type="text" style="width:150px;" class="input2" value="" readonly="" id="vsl_eng_nm" /></td>
						<th>Lane</th>
						<td><input name="vsl_slan_cd" type="text" style="width:40px;" class="input2" value="" readonly id="vsl_slan_cd" /><!-- 
										 --><input name="vsl_slan_nm" type="text" style="width:233px;" class="input2" value="" readonly="" id="vsl_slan_nm" /> </td>
						<th>Irregular Occurred</th>
						<td><input name="irr_occr_dt" required="" type="text" style="width:80px;" class="input1" dataformat="ymd" caption="Irregular Occurred Date" maxlength="8" size="10" value="" id="irr_occr_dt" /><!--
						   --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
					</tr>
					<tr>
						<th>Vessel Operator</th>
						<td><input name="vsl_opr_tp_cd" required="" type="text" style="width:40px;" class="input1" value="" caption="Vessel Operator" maxlength="4" dataformat="engup" id="vsl_opr_tp_cd" /><!-- 
						 --><button type="button" id="btn_vslopr" name="btn_vslopr" class="input_seach_btn"></button><!-- 
						 --><input name="vsl_opr_tp_nm" type="text" style="width:228px;" class="input2" value="" readonly="readonly" id="vsl_opr_tp_nm" /></td>
						<th>Cargo Operator</th>
						<td colspan="3"><input name="cgo_opr_cd" required="" type="text" style="width:40px;" class="input1" value="" caption="Cargo Operator" maxlength="3" dataformat="engup" id="cgo_opr_cd" /><!--  
						  --><button type="button" id="btn_carrier" name="btn_carrier" class="input_seach_btn"></button><!-- 
						 --><input name="cgo_opr_nm" type="text" style="width:205px;" class="input2" value="" readonly="readonly" id="cgo_opr_nm" /></td>
					</tr>
			</table>
			</div>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<div class= "opus_design_inquiry wFit">			
				<table>
					<colgroup>
						<col width="100" />
						<col width="200" />
						<col width="*" />
					</colgroup>
					<tr>
						<th class="wrap_search_tab">Option</th>
						<td class="wrap_search_tab"><input name="spcl_cgo_cate_cd" type="radio" value="DG" class="trans" id="spcl_cgo_cate_cd" /> Dangerous Goods &nbsp;<input name="spcl_cgo_cate_cd" type="radio" value="AC" class="trans" id="spcl_cgo_cate_cd" /> Awkward Cargo &nbsp;</td>
						<td></td>
					</tr>
				</table>
				<table>
					<colgroup>
						<col width="100" />
						<col width="100" />
						<col width="118" />
						<col width="480" />
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						
						<tr>
							<th>Subject</th>
							<td colspan="5"><input name="irr_subj_nm" type="text" style="width:625px;" class="input" value="" caption="Subject" maxlength="500" id="irr_subj_nm" /> </td>
						</tr>
						<tr>
							<th>Place</th>
							<td>
								<%=JSPUtil.getCodeCombo("spcl_cgo_irr_plc_cd", "S", "", "CD02118", 0, " ")%>
							</td>
							<th>Place Details</th>
							<td><input name="irr_plc_desc" type="text" style="width:405px;" class="input" value="" caption="Place Details" maxlength="500" id="irr_plc_desc" /> </td>
						</tr>
						<tr >
							<th>Irregulars Type</th>
							<td colspan="3">
								<script type="text/javascript">ComComboObject('spcl_cgo_irr_tp_cd', 3, 400, 1, 1);</script>
							</td>
							<th>Update By</th>
							<td><input name="upd_usr_id" type="text" style="width:90px;text-align:center" class="input2" value="" readonly="readonly" id="upd_usr_id" /> <!-- 
								  --><input name="upd_dt" id="upd_dt" type="text" style="width:90px;text-align:center" class="input2" value="" readonly="readonly"></td>
						</tr>
					</tbody>
				</table>
			</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="150" />
				<col width="50" />
				<col width="150" />
				<col width="200" />
				<col width="80" />
				<col width="50" />
				<col width="80" />
				<col width="50" />
				<col width="80" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>BKG Ref. No.</th>
					<td><input name="bkg_no" type="text" style="width:130px;" class="input" value="" caption="BKG No." maxlength="13" dataformat="engup" id="bkg_no" /></td>
					<th>B/L No.</th>
					<td><input name="bl_no" type="text" style="width:120px;" class="input" value="" caption="B/L No." maxlength="12" dataformat="engup" id="bl_no" /></td>
					<th title="Place of Receipt">POR</th>
					<td><input name="por_cd" type="text" style="width:50px;" class="input2" value="" caption="POR" readonly="readonly" dataformat="engup" id="por_cd" /></td>
					<th title="Port of Loading">POL</th>
					<td><input name="pol_cd" type="text" style="width:50px;" class="input2" value="" caption="POL" readonly="readonly" dataformat="engup" id="pol_cd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod_cd" type="text" style="width:50px;" class="input2" value="" caption="POD" readonly="readonly" dataformat="engup" id="pod_cd" /></td>
					<th>Delivery</th>
					<td><input name="del_cd" type="text" style="width:50px;" class="input2" value="" caption="Delivery" readonly="readonly" dataformat="engup" id="del_cd" /></td>
				</tr>
				<tr>
					<td colspan="4"></td>
					<th>SHPR</th>
					<td colspan="7"><input name="s_cust_nm" type="text" style="width:440px;" class="input2" value="" caption="SHPR" readonly="readonly" id="s_cust_nm" /></td>
				</tr>
				<tr>
					<td colspan="4"></td>
					<th>FWDR</th>
					<td colspan="7"><input name="f_cust_nm" type="text" style="width:440px;" class="input2" value="" caption="FWDR" readonly="readonly" id="f_cust_nm" /></td>
				</tr>
				<tr>
					<td colspan="4"></td>
					<th>CNEE</th>
					<td colspan="7"><input name="c_cust_nm" type="text" style="width:440px;" class="input2" value="" caption="CNEE" readonly="readonly" id="c_cust_nm" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" 		id="btn_RowAdd">Row&nbsp;Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RowInsert" 			id="btn_RowInsert">Row&nbsp;Insert</button><!--	
				 --><button type="button" class="btn_normal" name="btn_RowCopy" 			id="btn_RowCopy">Row&nbsp;Copy</button><!--
				 --><button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Row Delete</button>			
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="200" />
					<col width="*" />
				</colgroup>
				<tr><td colspan="2"><h3 class="title_design" style="margin-bottom:0px;">Irregulars Summary</h3></td></tr>
				<tr>
					<td colspan="2"><textarea name="irr_smry_rmk" id="irr_smry_rmk" style="width:100%; resize:none;" rows="5" caption="Irregulars Summary"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" height="5"></td>
				</tr>
				<tr><td colspan="2"><h3 class="title_design" style="margin-bottom:0px;">Reason</h3></td></tr>
				<tr>
					<td colspan="2"><textarea name="irr_rsn_rmk" id="irr_rsn_rmk" style="width:100% ;resize:none; " rows="3" caption="Reason"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" height="5"></td>
				</tr>
				<tr><td colspan="2"><h3 class="title_design" style="margin-bottom:0px;">Countermeasure to prevent a recurrence</h3></td></tr>
				<tr>
					<td colspan="2"><textarea name="cmsr_desc" id="cmsr_desc" style="width:100% ;resize:none;" rows="3" caption="Countermeasure to prevent a recurrence"></textarea></td>
				</tr>
				<tr>
					<th>Supporting Documents or Pictures</th>
					<td><button type="button" style="display:none" id="btn_file" name="btn_file" class="input_seach_btn"></button>
						<input name="file_cnt" type="text" style="width:40px;" class="input2" value="0" caption="Supporting Documents or Pictures" id="file_cnt" /> (s)
					 	<button type="button" class="btn_accent" name="btn_FileAdd" 		id="btn_FileAdd">File Add</button>
					 	<button type="button" class="btn_normal" name="btn_FileDelete" 		id="btn_FileDelete">File Delete</button>	
					 	&nbsp;<font color='blue'><b>(Max attached file size : 5M)</b></font>	
					 </td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div style="display:none">
			<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
		</div>
	</div>
<% if (pop_mode.equals("Y")) { %></div><%}%>
</form>