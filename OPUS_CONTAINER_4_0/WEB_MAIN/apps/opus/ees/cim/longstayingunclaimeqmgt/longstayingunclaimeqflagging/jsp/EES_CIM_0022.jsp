<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0022.jsp
*@FileTitle  : L/S & U/C Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesCim0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String popup_mode = "";
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");
	String cntrTpszCd = "";
	String cnmvStsCd = "";
	String fullFlg = "";
	String locTypeCode = "";
	String locCd = "";
	popup_mode = JSPUtil.getParameter(request, "popup_mode".trim(), "");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0022Event)request.getAttribute("Event");
		cntrTpszCd = event.getFlaggingSDaysOptionVO().getCntrTpszCd();
		cnmvStsCd = event.getFlaggingSDaysOptionVO().getCnmvStsCd();
		fullFlg = event.getFlaggingSDaysOptionVO().getFullFlg();
		locTypeCode = event.getFlaggingSDaysOptionVO().getLocTypeCode();
		locCd = event.getFlaggingSDaysOptionVO().getLocCd();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//MVMT Status multi combo 
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }
	    
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    function setupPage(){  
	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>","<%=cntrTpszCd%>","<%=cnmvStsCd%>","<%=fullFlg%>","<%=locTypeCode%>","<%=locCd%>");
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<input type="hidden" name="param_full_flg" value="" id="param_full_flg" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />


<%if(popup_mode.equals("Y")){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>L/S & U/C Creation</span></h2>
		
		<div class="opus_design_btn">
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
				--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
				--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
				--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
				--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
			</div>
		</div>
	</div>
</div>
<%}else{%>
<!--page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
				--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
				--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
				--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button>
				</div>
			<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<%}%>

<%if(popup_mode.equals("Y")){%><div class="layer_popup_contents"><%}%>
	<!-- wrap_area(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
<!-- 2014.11.28 민정호 -->					
					<col width="50px" />
					<col width="50px" />
<!-- 2014.11.28 민정호 -->					
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><select style="width:80px;" name="loc_type_code" id="loc_type_code" class="input"><option value="1">LCC</option><option value="2">ECC</option><option value="3">SCC</option></select></td>
						<td><input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" required="loc_cd"  value="" id="loc_cd" /><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
						<th>F/M</th>
						<td><select name="full_flg" id="full_flg" style="width:100px;" class="input"><option value="Y">Full</option><option value="N">MTY</option></select></td>
						<th>TP/SZ</th>
						<td><script type="text/javascript">ComComboObject('combo_cntr_tpsz_cd', 1, 85, 1);</script></td>
						<td><select name="bkg_cust_tp_cd" style="width:100px;" class="input"><option value="S" selected>SHPR No.</option><option value="C">CNEE No.</option><option value="N">NTFY No.</option></select><input type="text" name="cust_cd" style="width:76px;" class="input2" readonly dataformat="engup" value="" id="cust_cd" /><button type="button" id="search_cust_cd" name="search_cust_cd" class="input_seach_btn"></button></td>
						<th>CMDT</th>
						<td><input type="text" name="rep_cmdt_nm" style="width:100px;" class="input2" readonly dataformat="engup" value="" id="rep_cmdt_nm" /><button type="button" id="search_rep_cmdt_cd" name="search_rep_cmdt_cd" class="input_seach_btn"></button><input type="hidden" name="rep_cmdt_cd" id="rep_cmdt_cd" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Staying Day</th>
						<td><input type="text" name="over_stay_days" style="width:38px; text-align:right;" dataformat="num" class="input1" required="over_stay_days" value="" id="over_stay_days" />   or over</td>
						<th>Flag Status</th>
						<td><select name="uclm_ls_div_cd" style="width:100px;" class="input"><option value="P" selected>Pending</option><option value="C">Completed</option><option value=""> All</option></select></td>
						<th>MVMT Status</th>
						<td><script type="text/javascript">ComComboObject('combo_cnmv_sts_cd', 1, 85, 1);</script></td>
						<td><select name="bkg_bl_type_code" id="bkg_bl_type_code" style="width:100px;" class="input"><option value="BKG" selected>BKG No.</option><option value="BL">B/L No.</option><option value="CNTR">CNTR No.</option></select><input type="text" class="input" name="bkg_bl_type_cd" dataformat="engup" style="width:105px;" value="" id="bkg_bl_type_cd" /></td>
						<th>User ID</th>
						<td><input type="text" name="upd_usr_id" id="upd_usr_id" style="width:100px; ime-mode:disabled;" ></td>
					</tr>
				</tbody>
			</table>
		<!-- opus_design_inquiry(E) -->
		</div>
	</div>
	<!-- wrap_area(E) -->
	
	<!-- result_area(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_movement" id="btn_movement" type="button">Movement</button><!--
				--><button class="btn_normal" name="btn_SelectAll" id="btn_SelectAll" type="button">Select All</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- result_area(E) -->
<%if(popup_mode.equals("Y")){%></div><%}%>
</form>
