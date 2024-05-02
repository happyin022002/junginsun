<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0570.jsp
*@FileTitle  : B/L Inquery 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0570Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0570Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String blNo				= "";
	String tabId			= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		blNo  = JSPUtil.getNull(request.getParameter("bl_no"));
		int tabno = Integer.parseInt(JSPUtil.getNull(request.getParameter("tab")));
		tabId = Integer.toString(tabno-1);
		
		event = (EsmBkg0570Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
		if ('<%= blNo %>' != ''){

			document.form.bl_no.value = '<%= blNo %>';
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			
			tabObjects[0].SetSelectedIndex('<%= tabId %>');

		}else{
		
			//document.form.bl_no.value = 'KWAA05385205';
		}
	}
</script>

<form name="form">
<input type="hidden"  id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>BKG Correction Report By CA Issue/BKG Date</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
	<!-- page_title_area(E) -->
	
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry">
				<table>
					<tbody>
							<tr>
								<th style="width:30px;text-align: left;">B/L No.</th>
								<td style="width:100px;"><input type="text" name="bl_no" dataformat="engup" maxlength="12" style="width:100px;" class="input1" value=""><input type="text" style="width:25px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">C/A No.</th>
								<td style="width:100px;"><input type="text" name="corr_no" style="width:100px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">Customs Ref. No.</th>
								<td style="width:80px;"><input type="text" name="cust_ref_no" style="width:80px;" class="input2" value="" readonly><input type="text" style="width:35px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">Empty&nbsp;<input type="checkbox" name="empty" class="input2" style="border:0;" readonly></th>
								<th style="width:30px;text-align: left;">Freight </th>
								<td style="width:35px;"><input type="text" name="frt_term_cd"style="width:35px; text-align:center;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">O_B/L </th>
								<td style="width:35px;"><input type="text" name="obl_iss_flg" style="width:35px; text-align:center;" class="input2" value="" readonly></td>
								<td></td>
							</tr>
							<tr class="line_bluedot"><td colspan="12"></td></tr>
					</tbody>
				</table>
				
					<table>
						<tbody>
							<tr>
								<th style="width:30px; text-align: left;">VVD</th>
								<td style="width:230px;padding-left:10px;"><input type="text" name="vvd" id="vvd" style="width:100px;" class="input2" value="" readonly><input type="text" name="vsl_eng_nm" style="width:140px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">POD</th>
								<td style="width:60px;"><input type="text" name="pod_cd" id="pod_cd" style="width:60px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">ETA</th>
								<td style="width:110px;"><input type="text" name="eta" id="eta" style="width:110px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">POL</th>
								<td style="width:60px;"><input type="text" name="pol_cd" id="pol_cd" style="width:60px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">POR</th>
								<td style="width:60px;"><input type="text" name="por_cd" id="por_cd" style="width:60px;" class="input2" value="" readonly></td>
								<th style="width:30px;text-align: left;">DEL</th>
								<td style="width:60px;"><input type="text" id="del_cd" name="del_cd" style="width:60px;" class="input2" value="" readonly></td>
								<td></td>
							</tr>
								<tr>
								<th style="text-align: left;">Q,ty</th>
								<td style="padding-left:10px;"><input type="text" name="pck_qty" style="width:100px; text-align:right;"  value="" readonly><input type="text" name="pck_tp_cd" style="width:35px;" class="input2" value="" readonly></td>
								<th style="text-align: left;">WGT</th>
								<td><input type="text" name="act_wgt" style="width:110px; text-align:right;" value="" readonly><input type="text" name="wgt_ut_cd" style="width:35px;" class="input2" value="" readonly></td>
								<th style="text-align: left;">MEA</th>
								<td colspan="3"><input type="text" name="meas_qty" style="width:110px; text-align:right;" value="" readonly><input type="text" name="meas_ut_cd" style="width:35px;" class="input2" value="" readonly></td>
								<th style="text-align: left;">Description</th>
								<td colspan="3"><input type="text" name="cus_desc" style="width:180px;" class="input2" length ='20' value="" readonly></td>
								<td></td>
							</tr>
					</tbody>
				</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->


<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:inline">
<div class="opus_design_grid clear">
	<table  class="bg" style="width:100%">
		<tbody>
			<tr class="h23">
				<th style="padding-left:10px;height:30px;text-align: left;">Shipper</th>
				<td colspan="7" style="padding-left: 10px; height:30px;" align="left"><input type="text" name="s_cnt_cd" id="s_cnt_cd" style="width:25px;" class="input2" value="" readonly><input type="text" name="s_seq" id="s_seq" style="width:80px;" class="input2" value="" readonly></td>
				<td></td>
			</tr>
			<tr class="h23">
				<td colspan="8"></td>
				<td></td>
			</tr>
			<tr class="sm">
				<th rowspan="2" style="width: 50px;padding-left:10px;text-align: left;" class="stm">Name</th>
				<td rowspan="2" style="width: 450px;"><textarea  name="s_nm" id="s_nm" style="width:405px; height:75px;resize:none;" class="textarea2" readonly></textarea></td>
				<th style="width: 50px;text-align: left;" class="stm" class="stm">Address</th>
				<td colspan="3" style="width: 405px;"><textarea name="s_addr" id="s_addr" style="width:405px; height:50px;resize:none;" class="textarea2" readonly></textarea></td>
				<td></td>
			</tr>
			<tr class="sm">
				<th style="width: 30px;text-align: left;" class="stm">Tel.</th>
				<td style="width: 150px;"><input type="text" name="s_tel"  id="s_tel" style="width:150px;" class="input2" value="" readonly></td>
				<th style="width: 30px;text-align: left;" class="stm">Fax</th>
				<td  style="width: 150px;" align="right"><input type="text" name="s_fax" id="s_fax"  style="width:150px;" class="input2" value="" readonly></td>
				<td colspan="2"></td>
			</tr>
			
			
			<tr class="h23">
				<th style="text-align: left;padding-left:10px;">Consignee</th>
				<td colspan="7" align="left" style="padding-left: 10px;"><input type="text" name="c_cnt_cd" id="c_cnt_cd" style="width:25px;" class="input2" value="" readonly><input type="text" name="c_seq" id="c_seq" style="width:80px;" class="input2" value="" readonly></td>
				<td></td>
			</tr>
			<tr class="sm">
				<th rowspan="2" style="width: 50px;text-align: left;padding-left:10px" class="stm">Name</th>
				<td rowspan="2" style="width: 450px;"><textarea  name="c_nm" id="c_nm" style="width:405px; height:75px;resize:none;" class="textarea2" readonly></textarea></td>
				<th style="width: 50px;text-align: left;" class="stm" class="stm">Address</th>
				<td colspan="3" style="width: 405px;"><textarea name="c_addr" id="c_addr" style="width:405px; height:50px;resize:none;" class="textarea2" readonly></textarea></td>
				<td></td>
			</tr>
			<tr class="sm">
				<th style="width: 30px;text-align: left;" class="stm">Tel.</th>
				<td style="width: 150px;"><input type="text" name="c_tel" id="c_tel" style="width:150px;" class="input2" value="" readonly></td>
				<th style="width: 30px;text-align: left;" class="stm">Fax</th>
				<td  style="width: 150px;" align="right"><input type="text" id="c_fax" name="c_fax" style="width:150px;" class="input2" value="" readonly></td>
				<td colspan="2"></td>
			</tr>
			
			
			<tr class="h23">
				<th style="text-align: left;padding-left:10px;" >Notify</th>
				<td colspan="7" align="left" style="padding-left: 10px;"><input type="text" name="n_cnt_cd" id="n_cnt_cd" style="width:25px;" class="input2" value="" readonly><input type="text" name="n_seq" id="n_seq" style="width:80px;" class="input2" value="" readonly></td>
				<td></td>
			</tr>
			<tr class="sm">
				<th rowspan="2" style="width: 50px;text-align: left;padding-left:10px" class="stm">Name</th>
				<td rowspan="2" style="width: 450px;"><textarea  name="n_nm" id="n_nm" style="width:405px; height:75px;resize:none;" class="textarea2" readonly></textarea></td>
				<th style="width: 50px;text-align: left;" class="stm" class="stm">Address</th>
				<td colspan="3" style="width: 405px;"><textarea name="n_addr" id="n_addr" style="width:405px; height:50px;resize:none;" class="textarea2" readonly></textarea></td>
				<td></td>
			</tr>
			<tr class="sm">
				<th style="width: 30px;text-align: left;" class="stm">Tel.</th>
				<td style="width: 150px;"><input type="text" name="n_tel" id="n_tel" style="width:150px;" class="input2" value="" readonly></td>
				<th style="width: 30px;text-align: left;" class="stm">Fax</th>
				<td  style="width: 150px;" align="right"><input type="text" name="n_fax" id="n_fax" style="width:150px;" class="input2" value="" readonly></td>
				<td colspan="2"></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<div id="tabLayer" style="display:none">
<div class="opus_design_grid clear">
	<table>
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="80"/>
			<col width="100"/>
			<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<th>Seq.</th>
				<td><select name="mk_seq" id="mk_seq" style="width:60px;" class="input2" onChange="javascript:changeMkSeq();"></select></td>
				<th>Local/TS</th>
				<td><input type="text" name="loc_ts" id="loc_ts" style="width:60px;" class="input2" value="" readonly></td>
				<td></td>
			</tr>		
		</tbody>
	</table>
	<table style="width:100%" class="bg">
		<tbody>
			<tr>
				<td style="width:30%;height:30px;" class="tr2_head">MARKS &amp; No.</td>
				<td style="width:70%;height:30px;" class="tr2_head">DESCRIPTION</td>
			</tr>					
			<tr>
				<td><textarea name="mk_desc" id="mk_desc" style="width:100%; height:200px;resize:none;" class="input2" readonly></textarea></td>
				<td><textarea name="cmdt_desc" id="cmdt_desc" style="width:99%; height:200px;resize:none;" class="input2" readonly></textarea></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<div id="tabLayer" style="display:none">
<div class="opus_design_grid clear">
	<script type="text/javascript">ComSheetObject('t3sheet4');</script>
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	<script type="text/javascript">ComSheetObject('t3sheet2');</script>
	<script type="text/javascript">ComSheetObject('t3sheet3');</script>
</div>
</div>
</div>
<!-- opus_design_grid(E) -->	
</form>
