<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0010.jsp
*@FileTitle  : [CPS_CNI_0010] Contract of Carriage-Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0010Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0010Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0;

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
	String userCgoClmNo = "";
	String reqCgoClmNo = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
    SignOnUserAccount account = null;

    try
    {

		reqCgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

		//session start
		if(!reqCgoClmNo.equals("")){//req 있으면 req claimNo 로 세팅.
			userCgoClmNo = reqCgoClmNo;
		}else{//req 없으면 session 에 있는지 체크.
			if(!CniUtil.getCargoClaimNo(account).equals("")){//session 에 있으면 session 값으로 세팅
				userCgoClmNo = CniUtil.getCargoClaimNo(account);
			}
		}

		userCgoClmNo = CniUtil.getCargoClaimNo(account);
		//session end

        event = (CpsCni0010Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();     

%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>

<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cgo_clm_ref_bl_no" id="cgo_clm_ref_bl_no" />
<input type="hidden" name="bkg_no" id="bkg_no" />
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="" id="rd_title" />
<input type="hidden" name="rd_title_nm" value="" id="rd_title_nm" />
<input type="hidden" name="rd_report_by" value="" id="rd_report_by" />
<input type="hidden" name="usr_id" id="usr_id" value="<%=userId%>" readonly="readonly" />
<input type="hidden" name="usr_roles" id="usr_roles" value="<%=roles%>" readonly="readonly" />
<input type="hidden" name="usr_area" id="usr_area" value="<%=area%>" readonly="readonly" />
<input type="hidden" name="usr_office" id="usr_office" value="<%=ofcCd%>" readonly="readonly" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn1_Save" id="btn1_Save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70"/>
				<col width="120"/>
				<col width="70"/>
				<col width="100"/>
				<col width="70"/>
				<col width="100"/>
				<col width="85"/>
				<col width="100"/>
				<col width="90"/>
				<col width="110"/>
				<col width="150"/>
				<col width="*" />				
			</colgroup> 
			<tr>
				<th>Claim No.</th>
				<td><input type="text" style="width:85px;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required maxlength="10" caption="Claim  No" dataformat="engup" class="input1" id="cgo_clm_no" /><input type="text" style="width:20px;" name="clm_area_cd" value="" class="input2" readonly id="clm_area_cd" /></td>
				<th title="Handling Office">HOFC</th>
				<td><input type="text" style="width:50px;text-align:center" name="hdlr_ofc_cd" value="" class="input2" readonly id="hdlr_ofc_cd" /></td>
				<th>Handler</th>
				<td><input type="text" style="width:75px;text-align:center" name="hdlr_usr_id" value="" class="input2" readonly id="hdlr_usr_id" /><button type="button" id="btn1_Handler" name="btn1_Handler" class="input_seach_btn"></button></td>
				<th title="Date Of Updated">DOU</th>
				<td><input type="text" style="width:76px;text-align:center" name="upd_dt" value="" class="input2" readonly id="upd_dt" /></td>
				<th>Incident No.</th>
				<td><input type="text" style="width:95px;text-align:center" name="cgo_clm_inci_no" value="" class="input2" readonly id="cgo_clm_inci_no" /></td>
				<th>VOC No.</th>
				<td><input type="text" style="width:100px;text-align:center" name="crm_voc_no" value="" class="input2" readonly id="crm_voc_no" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="70"/>
				<col width="120"/>
				<col width="70"/>
				<col width="100"/>
				<col width="70"/>
				<col width="112"/>
				<col width="85"/>
				<col width="100"/>
				<col width="90"/>
				<col width="110"/>
				<col width="150"/>
				<col width="*" />				
			</colgroup> 
			<tr>
				<th>Status</th>
				<td><input type="text" style="width:110px;text-align:center" name="clm_misc_nm" value="" class="input2" readonly id="clm_misc_nm" /><input type="hidden" name="clm_misc_cd" value="" id="clm_misc_cd" /></td>
				<th><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></th>
				<td><input type="text" style="width:40px;text-align:center" name="hpc" value="" class="input2" readonly id="hpc" />/ <input type="text" style="width:40px;" name="nhp" value="" class="input2" readonly id="nhp" /></td>
				<th title="Type Of Settlement">TOS</th>
				<td><input type="text" style="width:45px;text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2" readonly id="cgo_clm_stl_tp_cd" /></td>
				<th title="Date Of Close">DOC</th>
				<td><input type="text" style="width:76px;text-align:center" name="cs_clz_dt" value="" class="input2" readonly id="cs_clz_dt" /></td>
				<th title="Time Barred Date">DOTB</th>
				<td><input type="text" style="width:90px;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly id="clm_tm_bar_dt" /></td>
				<th>Summons Served Date</th>
				<td><input type="text" style="width:90px;text-align:center" name="smns_sve_dt" value="" class="input2" readonly id="smns_sve_dt" /></td>
			</tr>
		</table>

		<table class="line_bluedot"><tr><td></td></tr></table>

		<table>
			<colgroup>
				<col width="70"/>
				<col width="468"/>
				<col width="90"/>
				<col width="*" />				
			</colgroup>  
			<tr>
				<th>Claimant</th>
				<td><input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no" style="width:0px" ><input type="text" style="width:70px;text-align:center" name="clm_pty_abbr_nm" value="" class="input2" readonly id="clm_pty_abbr_nm" /><input type="text" style="width:282px;" name="pty_nm" value="" class="input2" readonly id="pty_nm" /><input type="text" style="width:20px;" name="clmt_clm_tp_cd" value="" class="input2" readonly id="clmt_clm_tp_cd" /></td>
				<th><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></th>
				<td><input type="text" style="width:75px;text-align:center" name="fmal_clm_rcv_ofc_cd" value="" class="input2" readonly id="fmal_clm_rcv_ofc_cd" />/ <input type="text" style="width:80px;text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly id="fmal_clm_rcv_dt" /></td>
			</tr>
		</table> 
		<table>
			<colgroup>
				<col width="70"/>
				<col width="50"/>
				<col width="30"/>
				<col width="50"/>
				<col width="30"/>
				<col width="50"/>
				<col width="30"/>
				<col width="50"/>
				<col width="30"/>
				<col width="100"/>
				<col width="90"/>
				<col width="*"/>				
			</colgroup> 
			<tr>
				<th title="Type of Cargo Claim">TOC</th>
				<td><input type="text" style="width:70px;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly id="cgo_clm_tp_cd" /></td>
				<th title="Cause of Damage / Loss">CODL 1</th>
				<td><input type="text" style="width:40px;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly id="mjr_clm_dmg_lss_cd" /></td>
				<th title="Cause of Damage / Loss">2</th>
				<td><input type="text" style="width:40px;text-align:center" name="minr_clm_dmg_lss_cd" value="" class="input2" readonly id="minr_clm_dmg_lss_cd" /></td>
				<th title="Place of Incident">POI</th>
				<td><input type="text" style="width:40px;text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly id="inci_plc_tp_cd" /></td>
				<th title="Date of Incident">DOI</th>
				<td><input type="text" style="width:75px;text-align:center" name="inci_occr_dt" value="" class="input2" readonly id="inci_occr_dt" /></td>
				<th>Claim Amount</th>
				<td><input type="text" style="width:130px;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly id="clmt_usd_amt" />   USD</td>
			</tr>
		</table> 
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  name="tabLayer" id="tabLayer">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry ">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
				<div class="layout_vertical_2" style="width:60%">
					<div class="layout_wrap sm">						
						<div class="layout_vertical_2">
							<h3 class="title_design">B / L</h3>
								<div class="opus_design_grid">
								<div class="opus_design_btn">
									<button type="button" class="btn_normal" name="btn_BLGet" 		id="btn_BLGet">B/L Get</button>
								    <button type="button" class="btn_normal" name="btn_BLPreview" id="btn_BLPreview">B/L View</button>
								</div></div>
									
							<div class="opus_design_grid">
								<div class="opus_design_btn">
									<button type="button" class="btn_accent" name="btn2_RowAdd" 		id="btn2_RowAdd">Row Add</button>
									<button type="button" class="btn_normal" name="btn2_RowDelete" 			id="btn2_RowDelete">Row Delete</button>		
								</div>
								<script type="text/javascript">ComSheetObject('sheet1');</script>
							</div>
						</div>						
						<div class="layout_vertical_2">
							<table> 
								<colgroup>
									<col width="100"/>
									<col width="100"/>
									<col width="90"/>
									<col width="*"/>				
								</colgroup> 
								<tr>
									<th>Trunk VVD</th>
									<td><input type="text" style="width:100px;" name="trnk_ref_vvd_no" value="" class="input1" required caption="Trunk VVD" id="trnk_ref_vvd_no" /></td>
									<td><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_07" 	id="btn2_Upload_07">File Upload</button></div></td>
									<td></td>
								</tr>
							</table>
							<table> 
								<colgroup>
									<col width="100"/>
									<col width="60"/>
									<col width="50"/>
									<col width="*"/>				
								</colgroup> 
								<tr>
									<th>Lane</th>
									<td><input type="text" style="width:50px;text-align:center" name="slan_cd" value="" class="input2" readonly id="slan_cd" /></td>
									<th>Term</th>
									<td><input type="text" style="width:50px;text-align:center" name="crr_term_cd" value="" class="input2" readonly id="crr_term_cd" /></td>
								</tr>
							</table> 
							<table> 
								<colgroup>
									<col width="100"/>									
									<col width="*"/>				
								</colgroup> 
								<tr>
									<th>POR / DOR</th>
									<td><input type="text" style="width:100px;text-align:center" name="por_cd" value="" class="input2" readonly id="por_cd" /><button type="button" id="btns_por_cd" name="btns_por_cd" class="input_seach_btn"></button>/ <input type="text" style="width:75px;text-align:center" name="rct_dt" dataformat="ymd" maxlength="10" value="" class="input1" required caption="DOR" id="rct_dt" /><button type="button" id="btns_rct_dt" name="btns_rct_dt" class="calendar ir"></button></td>
								</tr>
								<tr>
									<th>POL / <span title="Date of Loading">DOL</span></th>
									<td><input type="text" style="width:100px;text-align:center" name="pol_cd" value="" class="input2" readonly id="pol_cd" /><button type="button" id="btns_pol_cd" name="btns_pol_cd" class="input_seach_btn"></button>/ <input type="text" style="width:100px;text-align:center" name="lodg_dt" value="" class="input2" readonly id="lodg_dt" /></td>
								</tr>
								<tr>
									<th>POD / DOD</th>
									<td><input type="text" style="width:100px;text-align:center" name="pod_cd" value="" class="input2" readonly id="pod_cd"/><button type="button" id="btns_pod_cd" name="btns_pod_cd" class="input_seach_btn"></button>/ <input type="text" style="width:75px;text-align:center" name="dchg_dt" value="" class="input" dataformat="ymd" maxlength="10" caption="DOD" id="dchg_dt" /><button type="button" id="btns_dchg_dt" name="btns_dchg_dt" class="calendar ir"></button></td>
								</tr>
								<tr>
									<th><span title="Place of Delivery">DEL</span>&nbsp; / <span title="Date of Delivery">DDL</span></th>
									<td><input type="text" style="width:100px;text-align:center" name="del_cd" value="" class="input2" readonly id="del_cd" /><button type="button" id="btns_del_cd" name="btns_del_cd" class="input_seach_btn"></button>/ <input type="text" style="width:100px;text-align:center" name="de_dt" value="" class="input2" readonly id="de_dt" /></td>
								</tr>
							</table> 
						</div>
					</div>
					<div class="sm">
					<table> 
						<tr>
							<th>Shipper</th>
							<td><input type="text" style="width:640px;" name="shpr_nm" value="" class="input1" required caption="Shipper" id="shpr_nm" /></td>
						</tr>
						<tr>
							<th>Consignee</th>
							<td><input type="text" style="width:640px;" name="cnee_nm" value="" class="input1" required caption="Consignee" id="cnee_nm" /></td>
						</tr>
						<tr>
							<th>Notify</th>
							<td><input type="text" style="width:640px;" name="ntfy_nm" value="" class="input1" required caption="Notify" id="ntfy_nm" /></td>
						</tr>
					</table>
					</div>
				</div>
				<div class="layout_vertical_2 sm mar_left_8" style="width:39%">
					<table>
						<tr>
							<td><h3 class="title_design">CNTR</h3></td>
							<td><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn_Movement" 		id="btn_Movement">Movement History</button></div></td>
						</tr>
					</table>

					<div class="opus_design_grid mar_btm_12">
						<!-- opus_design_btn (S) -->
						<div class="opus_design_btn">
							<button type="button" id="btn2_RowAdd2" name="btn2_RowAdd2" class="btn_accent">Row&nbsp;Add</button><!--
							--><button type="button" id="btn2_RowDelete2" name="btn2_RowDelete2" class="btn_normal">Row&nbsp;Delete</button><!--
							--><button type="button" id="btn2_RowCopy2" name="btn2_RowCopy2" class="btn_normal">Row Copy</button><!--
							--></div>
						<!-- opus_design_btn (E) -->
						<script type="text/javascript">ComSheetObject('sheet2');</script>
					</div>

					<table> 
						<colgroup>
							<col width="110"/>
							<col width="*"/>				
						</colgroup>
						<tr>
							<th>Cargo & Quantity</th>
							<td><input type="text" style="width:40px;text-align:center" name="clm_cgo_tp_cd" value="" class="input2" readonly id="clm_cgo_tp_cd" /><input type="text" style="width:170px;" name="cgo_qlty_desc" value="" class="input2" readonly caption="Cargo &amp; Quantity" id="cgo_qlty_desc" /></td>
						</tr>
					</table>
					<table>
						<colgroup>
							<col width="110"/>
							<col width="*"/>				
						</colgroup>
						<tr>
							<th>Freight</th>
							<td><input type="text" style="width:140px;text-align:right" name="clm_ofrt_amt" value="" class="input1" dataformat="singledFloat" required caption="Freight" id="clm_ofrt_amt" />   USD</td>
						</tr>
					</table>
					<table style="margin-bottom:10px;">
						<colgroup>
							<col width="110"/>
							<col width="85"/>
							<col width="70"/>
							<col width="*"/>				
						</colgroup>
						<tr>
							<th>Payment Term </th>
							<td><script type="text/javascript">ComComboObject("clm_ofrt_term_cd", 2, 60, 1);</script></td>
							<th>Paid or not </th>
							<td><script type="text/javascript">ComComboObject("clm_ofrt_flg", 2, 60, 1);</script></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- layout_wrap(E) -->
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<div class="opus_design_inquiry ">
			<div class="sm pad_8">
			<table> 
				<colgroup>
					<col width="100"/>
					<col width="150"/>
					<col width="170"/>
					<col width="175"/>
					<col width="170"/>
					<col width="175"/>
					<col width="170"/>
					<col width="*"/>				
				</colgroup>
				<tr>
					<th><h3 class="title_design">Pre-VVD</h3></th>
					<th>Pre-VVD1</th>
					<td><input type="text" style="width:80px;text-align:center" name="n1st_pre_ref_vvd_no" value="" class="input" caption="Pre-VVD1" id="n1st_pre_ref_vvd_no" /><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_01" id="btn2_Upload_01">File Upload</button></div></td>
					<th>Pre-VVD2</th>
					<td><input type="text" style="width:80px;text-align:center" name="n2nd_pre_ref_vvd_no" value="" class="input" caption="Pre-VVD2" id="n2nd_pre_ref_vvd_no" /><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_02" id="btn2_Upload_02">File Upload</button></div></td>
					<th>Pre-VVD3</th>
					<td><input type="text" style="width:80px;text-align:center" name="n3rd_pre_ref_vvd_no" value="" class="input" caption="Pre-VVD3" id="n3rd_pre_ref_vvd_no" /><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_03" id="btn2_Upload_03">File Upload</button></div></td>
					<td></td>
				</tr>
			</table>
   			<table>
				<colgroup>
					<col width="100"/>
					<col width="150"/>
					<col width="170"/>
					<col width="150"/>
					<col width="170"/>
					<col width="150"/>
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>&nbsp;</th>
					<th>Pre-POT1/Pre-DOT1</th>
					<td><input type="text" style="width:45px;text-align:center" name="n1st_pre_ts_loc_cd" value="" class="input" caption="Pre-POT1" maxlength="5" id="n1st_pre_ts_loc_cd" /><button type="button" id="btns_n1st_pre_ts_loc_cd" name="btns_n1st_pre_ts_loc_cd" class="input_seach_btn"></button>/ <input type="text" style="width:75px;text-align:center" name="n1st_pre_ts_dt" dataformat="ymd" maxlength="10" value="" class="input" caption="Pre-DOT1" id="n1st_pre_ts_dt" /><button type="button" id="btns_n1st_pre_ts_dt" name="btns_n1st_pre_ts_dt" class="calendar ir"></button></td>
					<th>Pre-POT2/Pre-DOT2</th>
					<td><input type="text" style="width:45px;text-align:center" name="n2nd_pre_ts_loc_cd" value="" class="input" caption="Pre-POT2" maxlength="5" id="n2nd_pre_ts_loc_cd" /><button type="button" id="btns_n2nd_pre_ts_loc_cd" name="btns_n2nd_pre_ts_loc_cd" class="input_seach_btn"></button>/ <input type="text" style="width:75px;text-align:center" name="n2nd_pre_ts_dt" dataformat="ymd" maxlength="10" value="" class="input" caption="Pre-DOT2" id="n2nd_pre_ts_dt" /><button type="button" id="btns_n2nd_pre_ts_dt" name="btns_n2nd_pre_ts_dt" class="calendar ir"></button></td>
					<th>Pre-POT3/Pre-DOT3</th>
					<td><input type="text" style="width:45px;text-align:center" name="n3rd_pre_ts_loc_cd" value="" class="input" caption="Pre-POT3" maxlength="5" id="n3rd_pre_ts_loc_cd" /><button type="button" id="btns_n3rd_pre_ts_loc_cd" name="btns_n3rd_pre_ts_loc_cd" class="input_seach_btn"></button>/ <input type="text" style="width:75px;text-align:center" name="n3rd_pre_ts_dt" dataformat="ymd" maxlength="10" value="" class="input" caption="Pre-DOT3" id="n3rd_pre_ts_dt" /><button type="button" id="btns_n3rd_pre_ts_dt" name="btns_n3rd_pre_ts_dt" class="calendar ir"></button></td>
				</tr>
			</table>
			</div>
			<div class="sm pad_8 mar_top_8">
   			<table>
   				<colgroup>
					<col width="100"/>
					<col width="150"/>
					<col width="170"/>
					<col width="175"/>
					<col width="170"/>
					<col width="175"/>
					<col width="170"/>
					<col width="*"/>				
				</colgroup>
				<tr>
					<th><h3 class="title_design">On-VVD</h3></th>
					<th>On-VVD1</th>
					<td><input type="text" style="width:80px;text-align:center" name="n1st_pst_ref_vvd_no" value="" class="input" caption="On-VVD1" id="n1st_pst_ref_vvd_no" /><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_04" id="btn2_Upload_04">File Upload</button></div></td>
					<th>On-VVD2</th>
					<td><input type="text" style="width:80px;text-align:center" name="n2nd_pst_ref_vvd_no" value="" class="input" caption="On-VVD2" id="n2nd_pst_ref_vvd_no" /><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_05" id="btn2_Upload_05">File Upload</button></div></td>
					<th>On-VVD3</th>
					<td><input type="text" style="width:80px;text-align:center" name="n3rd_pst_ref_vvd_no" value="" class="input" caption="On-VVD3" id="n3rd_pst_ref_vvd_no" /><div class="opus_design_btn"><button type="button" class="btn_normal" name="btn2_Upload_06" id="btn2_Upload_06">File Upload</button></div></td>
					<td></td>
				</tr>
			</table>
   			<table>
				<colgroup>
					<col width="100"/>
					<col width="150"/>
					<col width="170"/>
					<col width="150"/>
					<col width="170"/>
					<col width="150"/>
					<col width="*"/>				
				</colgroup>
				<tr>
					<th>&nbsp;</th>
					<th>On-POT1 / On-DOT1</th>
					<td><input type="text" style="width:45px;text-align:center" name="n1st_pst_ts_loc_cd" value="" class="input" caption="On-POT1" maxlength="5" id="n1st_pst_ts_loc_cd" /><button type="button" id="btns_n1st_pst_ts_loc_cd" name="btns_n1st_pst_ts_loc_cd" class="input_seach_btn"></button>/	<input type="text" style="width:75px;text-align:center" name="n1st_pst_ts_dt" dataformat="ymd" maxlength="10" value="" class="input" caption="On-DOT1" id="n1st_pst_ts_dt" /><button type="button" id="btns_n1st_pst_ts_dt" name="btns_n1st_pst_ts_dt" class="calendar ir"></button></td>
					<th>On-POT2 / On-DOT2</th>
					<td><input type="text" style="width:45px;text-align:center" name="n2nd_pst_ts_loc_cd" value="" class="input" caption="On-POT2" maxlength="5" id="n2nd_pst_ts_loc_cd" /><button type="button" id="btns_n2nd_pst_ts_loc_cd" name="btns_n2nd_pst_ts_loc_cd" class="input_seach_btn"></button>/ <input type="text" style="width:75px;text-align:center" name="n2nd_pst_ts_dt" dataformat="ymd" maxlength="10" value="" class="input" caption="On-DOT2" id="n2nd_pst_ts_dt" /><button type="button" id="btns_n2nd_pst_ts_dt" name="btns_n2nd_pst_ts_dt" class="calendar ir"></button></td>
					<th>On-POT3 / On-DOT3</th>
					<td><input type="text" style="width:45px;text-align:center" name="n3rd_pst_ts_loc_cd" value="" class="input" caption="On-POT3" maxlength="5" id="n3rd_pst_ts_loc_cd" /><button type="button" id="btns_n3rd_pst_ts_loc_cd" name="btns_n3rd_pst_ts_loc_cd" class="input_seach_btn"></button>/	<input type="text" style="width:75px;text-align:center" name="n3rd_pst_ts_dt" dataformat="ymd" maxlength="10" value="" class="input" caption="On-DOT3" id="n3rd_pst_ts_dt" /><button type="button" id="btns_n3rd_pst_ts_dt" name="btns_n3rd_pst_ts_dt" class="calendar ir"></button></td>
				</tr>
			</table>
		</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;" >
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	
	<!-- opus_design_grid(E) -->
</div>
</form>