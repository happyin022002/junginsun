<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_09.jsp
*@FileTitle  : Inbound Cargo Release Order for POD Office(US)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0909Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0909Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//error from server
	String strErrMsg = "";				//error message
	int rowCount = 0;					//DB ResultSet List count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_email = "";
	String strOfc_cd = "";
	
	String reqBlNo = JSPUtil.getParameter(request, "bl_no");

	Logger log = Logger
			.getLogger("com.clt.apps.InboundBLMgt.CargoReleaseOrder");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0909Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var reqBlNo = "<%=reqBlNo%>";
	
    function setupPage(){  
	    loadPage();
    }
</script>
</head>
  
<form name="form">
	<input name="f_cmd" type="hidden" /> 
	<input type="hidden" name="pagerows" value="<%=pageRows%>"> 
	<input type="hidden" name="keys" value="">
	<input type="hidden" name="bkg_no" value=""> <!-- Selected BKG_NO -->
	<input type="hidden" name="req_pod_cd" value=""> <!-- Selected POD_CD -->
<!-- TPB Status -->
<input type='hidden' id ='tpb_status' name ='tpb_status'>	

<input type="hidden" style="width: 110; color: blue; weight: bold" class="input2" name="curr_bl_no" readOnly>
<input type="hidden" style="width: 45; color: red;" class="input2" name="do_hld_flg" value="" readOnly>


	<div class="page_title_area clear" style="display:none">
		
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span>Inbound Cargo Release Order for POD Office(US)</span></button></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_Transmit"    id="btn_Transmit">Transmit</button>
			
			<button type="button" class="btn_normal" name="btn_Hold"    id="btn_Hold">Hold</button>
			<button type="button" class="btn_normal" name="btn_History"    id="btn_History">History</button>
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		
		
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;display:none" >
					<tr class="h23">
						<td width="125">Latest Update Date</td>
						<td width="340"><input type="text" style="width: 75"
							dataformat="ymd" minlength="8" maxlength="8" value=""
							class="input1" caption="Duration Start Date" name="start_date"
							style="width:100;ime-mode:disabled"
							onKeyPress="ComKeyOnlyNumber(this);">&nbsp;<input
							type="text" style="width: 44" class="input1" name="start_time"
							dataformat="hm" minlength="4" maxlength="4" value=""
							onKeyPress="ComKeyOnlyNumber(this);">&nbsp;&nbsp;~&nbsp;<input
							type="text" style="width: 75" dataformat="ymd" minlength="8"
							maxlength="8" value="" class="input1" caption="Duration End Date"
							name="end_date" style="width:100;ime-mode:disabled"
							onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)">&nbsp;<input
							type="text" style="width: 44" class="input1" name="end_time"
							dataformat="hm" minlength="4" maxlength="4" value=""
							onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)">&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btn_end_date"></td>
						<td width="45">Freight</td>
						<td width="70"><select style="width: 50;" class="input1"
							name="frt_clt_flg">

							<option value="">All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select></td>
						<td width="50">B/L</td>
						<td width="70"><select style="width: 50;" class="input1"
							name="obl_rdem_flg">
							<option value="">All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select></td>
						<td width="45">Customs</td>
						<td width="70"><select style="width: 50;" class="input1"
							name="cstms_clr_cd">
							<option value="">All</option>
							<option value="Y">Y</option>
							<option value="J">J</option>
							<option value="N">N</option>
						</select></td>
						<td width="45">Release</td>
						<td width=""><select style="width: 50;" class="input1"
							name="mrn_tml_edi_snd_cd">
							<option value="">All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;display:none">
					<tr class="h23">
						<td width="25">VVD</td>
						<td width="100"><input type="text" style="width:90px"
							class="input" name="vvd" value="" maxlength="9" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
						<td width="25">POD</td>
						<td width="80"><input type="text" style="width: 60"
							class="input" name="pod_cd" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper');"></td>
						<td width="25">DEL</td>
						<td width="88"><input type="text" style="width: 60"
							class="input" name="del_cd" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper');"></td>
						<td width="25">HUB</td>
						<td width="97"><input type="text" style="width: 67"
							class="input" name="hub_loc_cd" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper');"></td>
						<td width="50">B/L No.</td>
						<td width=""><input type="text" style="width: 95;"
							class="input1" value="" name="bl_no" caption="B/L No."
							maxlength="12" style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyDown="ComKeyEnter(this)"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
	<div class="wrap_result">
			<script type="text/javascript">ComSheetObject('master');</script>
	</div>
	<div class="wrap_result">		
		<div class="layout_wrap">
			<div class="layout_flex_fixed" style="width:50%">
	 			<table class="sm" border="0" width="98%">
	 			<colgroup>
					<col width="130px" />
					<col width="70px" />
					<col width="110px" />
					<col width="260px" />
					<col width="" />
				</colgroup>
				<tr>
				<th>Freight Receive</th>
					<td><input type="text" style="width: 50px; color: red;" class="input2" id="info_frt_clt_flg" name="info_frt_clt_flg" readOnly></td>
					<td>
					</td>
				<th>Outstanding<!-- 
					--><select style="width:165px;font-weight:bold;" class="input2_1" id='tot_ots_amt' name='tot_ots_amt'></select></th>
				<td>
					</td>						
				</tr>
				<tr>
					<th>Customs Clearance</th>
					<td><input type="text" style="width: 50px; color: red;" class="input2"  id="info_cstms_clr_cd" name="info_cstms_clr_cd" readOnly></td>
					<td width="" colspan="3"></td>
				</tr>
				<tr>
					<th>Demurrage Status</th>
					<td><input type="text" style="width: 50px; color: red;" class="input2" id="dem_status" name="dem_status" readOnly></td>
					<th>Type<!--
						--><input type="text" style="width: 40px;"class="input2" id="demur_type" name="demur_type" readOnly></th>
					<th>Outstanding<!--
						--><select style="width:165px;font-weight:bold;" class="input2" id='tot_bil_amt' name='tot_bil_amt'></select>
					</th>
					<td align="left"><button type="button" class="btn_etc" name="btn_dmdt" id="btn_dmdt" style="width:70px;text-align:center;">DMDT</button></td>
				</tr>
				<tr>
					<th>TPB Status</th>
					<td colspan="4"><img class="cursor" src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon"> <!-- 
						 --><input type="text" style="width:20px;text-align:center;" id='tpb_cd' name='tpb_cd' class="input2" readOnly><!-- 
						 --><button type="button" name="btn_tpb" id="btn_tpb" class="input_seach_btn"></button>
					</td>
				</tr>	
				</table>
				</div>
				<div class="layout_flex_fixed" style="width:50%">
			
					<div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('container');</script>
					</div>
					
					<div class="opus_design_grid" style="display: none">
						<script type="text/javascript">ComSheetObject('bkg_do_ref');</script>
						<script type="text/javascript">ComSheetObject('bkg_cgo_rlse');</script>
						<script type="text/javascript">ComSheetObject('otsRcvInfo');</script>
						<script type="text/javascript">ComSheetObject('sheet_bl_status');</script>
						
					</div>
					
					<table border="0" style="width:100%; background-color: white;" class="grid2">
						<tr class="h23" align="center">
							<th class="align_center">O/B Remark(s)</th>
						</tr>
						<tr>
							<td class="noinput2">
								<textarea style="width: 100%; height:18px" name="obl_iss_rmk" class="noinput2" readOnly></textarea>
							</td>
						</tr>
					</table>
	 	</div>
	</div>
	
	<div class="opus_design_inquiry">
	<table><tr>
	<th width="130"><h3 class="title_design">Bill of Lading Status</h3></th>
	<td width="*"></td>
	</tr></table>
	 <div class="layout_vertical_2 pad_rgt_12" style="width:50%">
			<table class="sm" border="0" width="98%">
	        <colgroup>
				<col width="110px" />
				<col width="60px" />
				<col width="25px" />
				<col width="60px" />
				<col width="20px" />
				<col width="60px" />
				<col width="20px" />
				<col width="80px" />
				<col width="20px" />
				<col width="" />
			</colgroup>
	        <tr>
				<th class="title_s">B/L Issue</th>
	            <td>
	            	<input type="text" name="bl_status" style="width:50px; text-align: center" class="input2" readOnly>
	            </td>
	            <th>No.</th>
	            <td>
	            	<input type="text" name="bl_cpy_knt" style="width:44px;" class="input2" readOnly>
	            </td>
	            <th>OFC</th>
	            <td>
	            	<input type="text" name="bl_rlse_ofc_cd" style="width:60px;" class="input2" readOnly>
	            </td>
	            <th>ID</th>
	            <td>
	            	<input type="text" name="bl_rlse_usr_id" style="width:80px;" class="input2" readOnly>
	            </td>
	            <th>DT</th>
	            <td>
	            	<input type="text" name="bl_rlse_dt" style="width:120px;" class="input2" readOnly>
	            </td>
	        </tr>
	        <tr>
				<th class="title_s">B/L Receive</th>
				<td>								
					<input type="text" style="width: 50px; color: red;" class="input2" value="" name="info_obl_rdem_flg" readOnly>
					<input type="hidden" style="width: 20px; color: blue;" class="input2" name="obl_ttl_knt" value="">
				</td>
	             <th>No.</th>
	             <td>
	             	<input type="text" name="obl_rdem_knt" style="width:44px;" class="input2" readOnly>
	             </td>
	             <th>OFC</th>
	             <td>
	             	<input type="text" name="obl_rdem_ofc_cd" style="width:60px;" class="input2" readOnly>
	             </td>
	             <th>ID</th>
	             <td>
	             	<input type="text" name="obl_rdem_usr_id" style="width:80px;" class="input2" readOnly>
	             </td>
	             <th>DT</th>
	             <td>
	             	<input type="text" name="obl_rdem_dt" style="width:120px;" class="input2" readOnly><!-- 
	             	 --><button type="button" name="btn_srnd" id="btn_srnd" class="input_seach_btn"></button>                            
	             </td>
	         </tr>
              <tr>
                  <td colspan="2"></td>
                  <th>No.</th>
                  <td>
                  	<input type="text" name="bl_ibd" style="width:44px;" class="input2" readOnly>
                  </td>
                  <th>OFC</th>
                  <td>
                  	<input type="text" name="bl_ibd_ofc_cd" style="width:60px;" class="input2" readOnly>
                  </td>
                  <th>ID</th>
                  <td>
                  	<input type="text" name="bl_ibd_usr_id" style="width:80px;" class="input2" readOnly>
                  </td>
                  <th>DT</th>
                  <td>
                  	<input type="text" name="bl_ibd_dt" style="width:120px;" class="input2" readOnly>
                  </td>
              </tr>
              <tr class="h23">
				  <th class="title_s">Other Doc RCV</th>
                  <td colspan="2"></td>
                  <td>
                  	<input type="text" style="width: 50px; color: red;" class="input2" value="" name="bl_otr_doc_rcv_cd" readOnly>
                  </td>
                  <th>OFC</th>
                  <td>
                  	<input type="text" name="otr_doc_rcv_ofc_cd" style="width:60px;" class="input2" readOnly>
                  </td>
                  <th>ID</th>
                  <td>
                  	<input type="text" name="otr_doc_rcv_usr_id" style="width:80px;" class="input2" readOnly>
                  </td>
                  <th>DT</th>
                  <td>
                  	<input type="text" name="otr_doc_rcv_dt" style="width:120px;" class="input2" readOnly>
                  </td>
              </tr>
	          </table>
          	</div>
          	 <div class="layout_vertical_2 pad_rgt_12" style="width:50%">
					<table border="0" style="width:100%; background-color: white;" class="grid2">
					<tr align="center">
						<th width="90%" class="align_center">
							Hold / Internal Remark(s)
						</th>
						<td>
							<button type="button" class="btn_etc" name="btn_Save" id="btn_Save" style="width:70px;text-align:center;">Save</button>
						</td>
					</tr>
					<tr class="h23" align="center">
						<td width="" colspan="2"><textarea style="width: 100%; height: 78px" name="inter_rmk"></textarea></td>
					</tr>
				</table>
			
        </div>
		<!--biz page (E)--> 
	</div>
</div>
</form>
