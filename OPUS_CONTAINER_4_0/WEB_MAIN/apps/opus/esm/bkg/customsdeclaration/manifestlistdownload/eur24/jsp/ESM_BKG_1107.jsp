<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_1107.jsp
 *@FileTitle: Europe Advanced Manifest : B/L Inquiry - customer Information
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/24
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1107Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%	EsmBkg1107Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
    String strOfc_cd   = "";
	
	String strPgmNo     = "";
	String prtPgmNo	= "";
	String strBlNo      = "";
	String strTransMode = "";       
	String title_type	= "";
	String ata_chk_flg	= "Y";	
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Customstransmission");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
        strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        prtPgmNo = JSPUtil.getNull(request.getParameter("parentPgmNo"));
        codeList = HttpUtil.makeXML(request,response);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		//showErrMessage(errMessage);	
	} // end if
	
    $('<button type="button" class="btn_normal" name="btn_MrnDelete"  		id="btn_MrnDelete"	style="display:none">MRN Delete</button>').appendTo("#btnArea");	
    $('<button type="button" class="btn_normal" name="btn_MrnReactivate"  	id="btn_MrnReactivate"	style="display:none">MRN Reactivate</button>').appendTo("#btnArea");	
	$('<button type="button" class="btn_accent" name="btn_Retrieve"			id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
    $('<button type="button" class="btn_normal" name="btn_New"  			id="btn_New">New</button>').appendTo("#btnArea");		
    $('<button type="button" class="btn_normal" name="btn_Save"  			id="btn_Save">Save</button>').appendTo("#btnArea");		
    $('<button type="button" class="btn_normal" name="btn_Transmit"  		id="btn_Transmit">Transmit Manifest</button>').appendTo("#btnArea");
		
	loadPage();
	

    $('#btn_Transmit').after($('#btn_Close'));
}
</script>


<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" value=""/>
<input type="hidden" name="pagerows" id="pagerows" value=""/>
<input type="hidden" name="cstms_port_cd" id="cstms_port_cd" value="" />
<input type="hidden" name="code_list" value="<%=codeList%>" id="code_list"value="" />
<input type="hidden" name="cust_type" id="cust_type"value="" />
<input type="hidden" name="mk_desc" id="mk_desc" value=""/>
<input type="hidden" name="gds_desc" id="gds_desc" value=""/>
<input type="hidden" name="func" id="func" value=""/>
<input type="hidden" name="cn_flg" value="Y" id="cn_flg" value=""/>
<input type="hidden" name="eur_flg" value="Y" id="eur_flg" value=""/>
<input type="hidden" name="s_ibflag" id="s_ibflag" value=""/>
<input type="hidden" name="f_ibflag" id="f_ibflag" value=""/>
<input type="hidden" name="n_ibflag" id="n_ibflag" value=""/>
<input type="hidden" name="c_ibflag" id="c_ibflag" value=""/>
<input type="hidden" name="eu_stf_flg" id="eu_stf_flg" value=""/>
<input type="hidden" name="cstms_yd_cd" id="cstms_yd_cd" value=""/>
<input type="hidden" name="pol_cd" id="pol_cd" value=""/>
<input type="hidden" name="kts_send_dt" >
<input type="hidden" name="rcv_mvmt_ref_no" >
<input type="hidden" name="strPgmNo"  value="<%=strPgmNo%>">
<input type="hidden" name="prtPgmNo"  value="<%=prtPgmNo%>">
<input type="hidden" name="trsm_blck_flg">
<input type="hidden" name="mrn_flg">


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>

<div class= "wrap_search_tab">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="170"/>
					<col width="95"/>  
					<col width="100"/>
					<col width="80"/>
					<col width="120"/>
					<col width="50"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" id="bl_no" style="width:110px; ime-mode: disabled;" class="input1" value="<%=strBlNo%>" dataformat="engup" maxlength="12" <%="".equals(strBlNo) ? "required" : "readonly"%> caption="B/L No."></td>
                    <th>Type</th>
					<td ><%=JSPUtil.getCodeCombo("type_cd", "", "style='width:100;'", "CD02257", 0, "")%></td>
					<th>Status</th>
					<td><input type="text" name="msg_func_id" style="width:100px;" class="input2" readonly="" id="msg_func_id" /></td>
					<th>MRN</th>
					<td><input type="text" name="mvmt_ref_no" style="width:150px;" class="input2" readonly="" id="mvmt_ref_no" /></td>
				</tr>
				
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<table>
			<tbody>
				<colgroup>
			     <col width="80">
			     <col width="150">
			     <col width="100">
			     <col width="220">
			     <col width="120">
			     <col width="*">
	           </colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><script type="text/javascript">ComComboObject('vvd', 2, 150, 0, 0,0);</script></td>
					<th>Vessel Name</th>
					<td><input type="text" name="vsl_eng_nm" style="width:200px;" class="input2" readonly id="vsl_eng_nm" /> </td>
					<th>IMO(Lloyd) Code</th>
					<td><input type="text" name="lloyd_no" style="width:80px;" class="input2" readonly id="lloyd_no" /> </td>
				</tr>
				
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
				<col width="80">
				<col width="70">
				<col width="55">
				<col width="70">
				<col width="55">
				<col width="70">
				<col width="55">
				<col width="70">
				<col width="100">
				<col width="*">
		    </colgroup>
				<tr>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="por_cd" style="width:60px;" class="input" maxlength="5" id="por_cd" dataformat="engup"/> </td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="bkg_pol_cd" style="width:60px;" class="input" maxlength="5" id="bkg_pol_cd" dataformat="engup"/> </td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="bkg_pod_cd" style="width:60px;" class="input" maxlength="5" id="bkg_pod_cd" dataformat="engup"/> </td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" style="width:60px;" class="input" maxlength="5" id="del_cd" dataformat="engup"/> </td>
					<th>R/D Term</th>
					<td><input type="text" name="rcv_term_cd" style="width:25px;" class="input2" readonly="" id="rcv_term_cd" />/ <!-- 
						 --><input type="text" name="de_term_cd" style="width:25px;" class="input2" readonly="" id="de_term_cd" />
					</td>
				</tr>
				
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
				 <col width="80">
				 <col width="200">
				 <col width="50">
				 <col width="240">
				 <col width="50">
				 <col width="*">
		        </colgroup>
				<tr>
					<th>Package</th>
					<td><input type="text" name="pck_qty" style="width:105px; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Package" id="pck_qty" /><!-- 
						 --><input type="text" name="pck_tp_cd" style="width:35px;" class="input" id="pck_tp_cd" dataformat="engup"/>	</td>
					<th>Weight</th>
					<td><input type="text" name="act_wgt" style="width:100px; text-align:right;" class="input" dataformat="float" maxlength="23" caption="Weight" id="act_wgt" /><!-- 
					 --><%=JSPUtil.getCodeCombo("wgt_ut_cd", "", "	 style='width:80;'", "CD00775", 0, "")%></td>
					<th>Measure</th>
					<td><input type="text" name="meas_qty" style="width:100px; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Measure" id="meas_qty" /><!-- 
						 --><%=JSPUtil.getCodeCombo("meas_ut_cd", "", "	 style='width:80;'", "CD01116", 0, "")%></td>	
				</tr>
				
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Cargo Desc.</th>
					<td><input type="text" name="cstms_desc" style="width:480px;" class="input" id="cstms_desc" dataformat="engupetc"/></td>
				</tr>
				
			</tbody>
		</table>
	</div>
</div>


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  style="display:none" >			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->
	
	<div id="tabLayer" style="display:inline">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:49%;">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_inquiry sm pad_8">
		        	<table style="width:100%">
						<tbody>
							<colgroup>
								<col width="80"/>
								<col width="200"/>
								<col width="90"/>
								<col width="30"/>
								<col width="70"/>
								<col width="*"/>
						    </colgroup>
							<tr>
								<th>Shipper</th>
								<td colspan="5"><!-- 
									 --> <input type="text" style="width:30px;" class="input" name="s_cust_cnt_cd" maxlength="2" required="" fullfill="" dataformat="engup" caption="Shipper Country Code" id="s_cust_cnt_cd" /><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input" name="s_cust_seq" maxlength="6" dataformat="engup" caption="Shipper Sequence" id="s_cust_seq" /><!-- 
									 --><button type="button" class="btn_down" name="pop_shipper" id="pop_shipper"></button>
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"> <textarea  rows="2" name="s_cust_nm" maxlength="500" dataformat="engupetc" caption="Shipper Name" style="width:50%;text-indent:0px;overflow-y:scroll;resize:none;overflow-x:hidden" class="textarea_img2" wrap="physical"></textarea> </td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"> <textarea  rows="3" name="s_cust_addr" maxlength="350" dataformat="engupetc" caption="Shipper Address" style="width:100%;text-indent:0px;overflow-y:scroll;resize:none;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="s_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Shipper City" id="s_cust_cty_nm" /></td>
						 		<th>Country</th>
								<td><input type="text" style="width:25px;" class="input" name="s_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Shipper Country" id="s_cstms_decl_cnt_cd" /></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="s_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Shipper Zip" id="s_cust_zip_id" /></td>
							</tr>
							<tr>
								<th>Street</th>
								<td><input type="text" name="s_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" id="s_eur_cstms_st_nm" /></td>
						 		<th>EORI#</th>
								<td colspan="3"> <!-- 
								 --><input type="text" name="s_eori_no" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="s_eori_no" /><!-- 
								 --><input type="hidden" name="s_eori_no_ori" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="s_eori_no_ori" />
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="opus_design_inquiry sm pad_8 mar_top_12">
					<table style="width:100%">
						<tbody>
							<colgroup>
								<col width="80"/>
								<col width="200"/>
								<col width="90"/>
								<col width="30"/>
								<col width="70"/>
								<col width="*"/>
						    </colgroup>
							<tr>
								<th>Consignee</th>
								<td colspan="5" ><!-- 
									 --> <input type="text" style="width:30px;" class="input" name="c_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Consignee Country Code" id="c_cust_cnt_cd" /><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input" name="c_cust_seq" maxlength="6" dataformat="engup" caption="Consignee Sequence" id="c_cust_seq" /><!-- 
									 --><button type="button" class="btn_down" name="pop_consignee" id="pop_consignee"></button>
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"> <textarea rows="2" name="c_cust_nm" maxlength="500" dataformat="engupetc" caption="Consignee Name" style="width:50%;text-indent:0px;overflow-y:scroll; resize:none; overflow-x:hidden" class="textarea_img2" wrap="physical"></textarea> </td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"> <textarea rows="3" name="c_cust_addr" maxlength="350" dataformat="engupetc" caption="Consignee Address" style="width:100%;text-indent:0px;overflow-y:scroll;resize:none;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="c_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Consignee City" id="c_cust_cty_nm" /></td>
						 		<th>Country</th>
								<td><input type="text" style="width:25px;" class="input" name="c_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Consignee Country" id="c_cstms_decl_cnt_cd" /></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="c_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Consignee Zip" id="c_cust_zip_id" /></td>
							</tr>
							<tr>
								<th>Street</th>
								<td><input type="text" name="c_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" id="c_eur_cstms_st_nm" /></td>
						 		<th>EORI#</th>
								<td colspan="3"> <!-- 
								  --><input type="text" name="c_eori_no" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="c_eori_no" /><!-- 
								  --><input type="hidden" name="c_eori_no_ori" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="c_eori_no_ori" />
								</td>
							</tr>
						</tbody>
					</table>
					
		               
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		     <div class="layout_vertical_2" style="width:30px;">
		     	<table><tr><td></td></tr></table>
		      </div>		    
		    <div class="layout_vertical_2" style="width:50%; float:right;">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_inquiry sm pad_8">
		            <table style="width:100%">
						<tbody>
							<colgroup>
								<col width="70"/>
								<col width="200"/>
								<col width="90"/>
								<col width="30"/>
								<col width="70"/>
								<col width="*"/>
						    </colgroup>
							<tr>
								<th>FWRD</th>
								<td colspan="5" ><!-- 
								 --> <input type="text" style="width:30px;" class="input" name="f_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Forwarder Country Code" id="f_cust_cnt_cd" /><!-- 
								 --><input type="text" style="width:60px;text-align:right;" class="input" name="f_cust_seq" maxlength="6" dataformat="engup" caption="Forwarder Sequence" id="f_cust_seq" /><!-- 
								 --><button type="button" class="btn_down" name="pop_fwrd" id="pop_fwrd"></button>
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"> <textarea rows="2" name="f_cust_nm" maxlength="500" dataformat="engupetc" caption="Forwarder Name" style="width:50%;text-indent:0px;overflow-y:scroll;resize:none;overflow-x:hidden" class="textarea_img2" wrap="physical"> </textarea></td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"> <textarea rows="3" name="f_cust_addr" maxlength="350" dataformat="engupetc" caption="Forwarder Address" style="width:100%;text-indent:0px;overflow-y:scroll;resize:none;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="f_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Forwarder City" id="f_cust_cty_nm" /></td>
						 		<th>Country</th>
								<td><input type="text" style="width:25px;" class="input" name="f_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Forwarder Country" id="f_cstms_decl_cnt_cd" /></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="f_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Forwarder Zip" id="f_cust_zip_id" /></td>
							</tr>
							<tr>
								<th>Street</th>
								<td><input type="text" name="f_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" id="f_eur_cstms_st_nm" /></td>
						 		<th>EORI#</th>
								<td colspan="3"> <!-- 
									 --><input type="text" name="f_eori_no" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="f_eori_no" /><!-- 
									 --><input type="hidden" name="f_eori_no_ori" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="f_eori_no_ori" />
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="opus_design_inquiry sm pad_8 mar_top_12">
					<table style="width:100%">
						<tbody>
							<colgroup>
								<col width="70"/>
								<col width="200"/>
								<col width="90"/>
								<col width="30"/>
								<col width="70"/>
								<col width="*"/>
						    </colgroup>
							<tr>
								<th>Notify</th>
								<td colspan="5"><!-- 
									 --> <input type="text" style="width:30px;" class="input" name="n_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Notify Country Code" id="n_cust_cnt_cd" /><!-- 
									 --><input type="text" style="width:60px;text-align:right;" class="input" name="n_cust_seq" maxlength="6" dataformat="engup" caption="Notify Sequence" id="n_cust_seq" /><!-- 
									 --><button type="button" class="btn_down" name="pop_notify" id="pop_notify"></button>		 
								</td>
							</tr>
							<tr>
								<th>Name</th>
								<td colspan="5"> <textarea rows="2" name="n_cust_nm" maxlength="500" dataformat="engupetc" caption="Notify Name" style="width:50%;text-indent:0px;overflow-y:scroll; resize:none; overflow-x:hidden" class="textarea_img2" wrap="physical"> </textarea></td>
							</tr>
							<tr>
								<th>Address</th>
								<td colspan="5"> <textarea rows="3" name="n_cust_addr" maxlength="350" dataformat="engupetc" caption="Notify Address" style="width:100%;text-indent:0px;overflow-y:scroll; resize:none; overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr>
						 		<th>City</th>
								<td><input type="text" style="width:135px;" class="input" name="n_cust_cty_nm" maxlength="500" dataformat="engupetc" caption="Notify City" id="n_cust_cty_nm" /></td>
						 		<th>Country</th>
								<td><input type="text" style="width:25px;" class="input" name="n_cstms_decl_cnt_cd" maxlength="2" dataformat="engup" caption="Notify Country" id="n_cstms_decl_cnt_cd" /></td>
						 		<th>Zip</th>
								<td><input type="text" style="width:87px;" class="input" name="n_cust_zip_id" maxlength="10" dataformat="engupetc" caption="Notify Zip" id="n_cust_zip_id" /></td>
							</tr>
							<tr>
								<th>Street</th>
								<td><input type="text" name="n_eur_cstms_st_nm" dataformat="engupetc" style="width:150px;" maxlength="50" class="input" id="n_eur_cstms_st_nm" /></td>
						 		<th>EORI#</th>
								<td colspan="3"> <!-- 
								 --><input type="text" name="n_eori_no" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="n_eori_no" /><!-- 
							     --><input type="hidden" name="n_eori_no_ori" dataformat="engupetc" style="width:80px;" maxlength="20" class="input" id="n_eori_no_ori" />
								</td>
							</tr>
						</tbody>
					</table>
		        
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
		<!-- layout_wrap(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  style="display:none">			
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	
	</div>
	
	<!-- (TAB) Container Info (S) -->
	<div id="tabLayer">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_RowAdd1" id="btn_RowAdd1" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_RowDel1" id="btn_RowDel1" type="button">Row Delete</button>
			</div>
			<!-- opus_design_btn (E) -->	
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_RowDel2" id="btn_RowDel2" type="button">Row Delete</button>
			</div>
			<!-- opus_design_btn (E) -->	
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
	<!-- (TAB) Container Info (E) -->
	
	<!-- (TAB) Danger Info.(S) -->
	<div id="tabLayer" style="display:none">	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_RowAdd3" id="btn_RowAdd3" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_RowDel3" id="btn_RowDel3" type="button">Row Delete</button>
			</div>
			<!-- opus_design_btn (E) -->	
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	
	<div class="opus_design_grid" style="display:none">
		<table> 
			<tr>
				<td width="145">FlatFile</td>
			</tr> 
			<tr>
				<td>
					<textarea name="flatfile"  id="flatfile" cols="600" rows="20"  wrap="hard" dataformat="engupetc"style="width: 100%; background-color: #FBFBFB; border: 1 solid #AEAEAE;overflow:hidden; ime-mode:disabled;" ></textarea>
				</td>
			</tr> 
		</table>
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->

</div>

<%if(!mainPage.equals("true")){	%></div><%}%>

</form>
