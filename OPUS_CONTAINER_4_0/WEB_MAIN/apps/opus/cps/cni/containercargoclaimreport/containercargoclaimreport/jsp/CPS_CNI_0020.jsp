<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : cps_cni_0032.jsp
 *@FileTitle: [CPS_CNI_0020] Report-Settlement Analysis
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0020Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	String cookiesJSessionId="";
	Cookie[] cookies = request.getCookies();
	  if (cookies != null) {
	      for (int loop = 0; loop < cookies.length; loop++) {
	             if (cookies[loop].getName().equals("JSESSIONID")) {
	                     cookiesJSessionId=cookies[loop].getValue();
	              }
	      }
	}
	CpsCni0020Event event = null;
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
	String schFromStrGmt = "";
	String schToStrGmt = "";//조회조건의 to날짜(GMT)

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0020Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		schFromStrGmt = eventResponse.getETCData("schToDate").substring(0,4) + "-01" + "-01";
		schToStrGmt = eventResponse.getETCData("schToDate");

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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

<form name="form2" id="form2">
<input type="hidden" name="sXml" id="sXml" value="<%=xml.replace("\"","''")%>"></form>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" value="100">
<input type="hidden" name="page_no" id="page_no" value="1">
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
<!-- 조회조건  -->
<input type="hidden" name="schFromStrGmt" value="<%=schFromStrGmt%>" id="schFromStrGmt" />
<input type="hidden" name="schToStrGmt" value="<%=schToStrGmt%>" id="schToStrGmt" />
<input type="hidden" name="userId" value="<%=userId%>" id="userId" />
<input type="hidden" name="userOffice" value="<%=userOffice%>" id="userOffice" />
<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="" id="rd_title" />
<input type="hidden" name="rd_title_nm" value="" id="rd_title_nm" />
<input type="hidden" name="rd_report_by" value="" id="rd_report_by" />
<input type="hidden" name="clm_area_cd" value="" id="clm_area_cd" />
<input type="hidden" name="cgo_clm_sts_cd" value="" id="cgo_clm_sts_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn1_Down_Excel" id="btn1_Down_Excel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn1_Print" id="btn1_Print" type="button">Print</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit" style="margin-bottom:-3px">
		<table>
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="100"/>
					<col width="70"/>
					<col width="320"/>
					<col width="50"/>
					<col width="90"/>
					<col width="50"/>
					<col width="110"/>
					<col width="50"/>
					<col width="*"/>
			    </colgroup>
			    <tr>
					<th>Report by</th>
		 			<td><script type="text/javascript">ComComboObject("report_by", 1, 100, 1);</script></td> 
					<th>Period</th>
					<td><script type="text/javascript">ComComboObject("period", 2, 67, 1);</script><!-- 
						 	--><input type="text" name="from_period" style="width:80px;" value="" class="input1" required dataformat="ymd" caption="Period(From Date)"><!-- 
							--><button type="button" name="btns_from_period" id="btns_from_period" class="calendar ir" ></button>~&nbsp;<!-- 
						    --><input type="text" name="to_period" style="width:80px;" value="" class="input1" required dataformat="ymd" caption="Period(To Date)"><!-- 
						    --><button type="button" class="calendar ir" name="btns_to_period" id="btns_to_period"></button></td>
					<th>Area</th>
					<td ><script type="text/javascript">ComComboObject("area", 2, 67, 1);</script></td>
					<th>Status</th>
					<td ><script type="text/javascript">ComComboObject("combo_status", 2, 67, 1);</script></td>
					<th>Class</th>
					<td><script type="text/javascript">ComComboObject("vt", 2, 57, 1);</script></td>
				</tr>
				
			</tbody>
		</table>
		</div>
		
		
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="70"/>
					<col width="50"/>
					<col width="70"/>
					<col width="70"/>
					<col width="70"/>
					<col width="80"/>
					<col width="70"/>
					<col width="50"/>
					<col width="80"/>
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th title="Handling Office">HOFC</th>
					<td><input type="text" name="hdlr_ofc_cd" style="width:60px;text-align:center" value="" class="input" dataformat="engup" maxlength="6" caption="HOFC" id="hdlr_ofc_cd" /> </td>
					<th>Handler</th>
					<td><input type="text" name="hdlr_usr_id" style="width:60px;text-align:center" value="" class="input" dataformat="engup" maxlength="20" id="hdlr_usr_id" /> </td>
					<th>Manager</th>
					<td><input type="text" name="mgr_usr_id" style="width:65px;" value="" class="input" dataformat="engup" id="mgr_usr_id" /> </td>
					<th>LP HOFC</th>
					<td><input type="text" style="width:80px;text-align:center;" name="hndl_ofc_cd" value="" class="input" dataformat="engup" maxlength="6" caption="LP HOFC" id="hndl_ofc_cd" /><!-- 
						 --><button type="button" id="btns_hndl_ofc_cd" name="btns_hndl_ofc_cd" class="input_seach_btn"></button></td>
					<td><b>Liable Party</b><input type="hidden" name="labl_clm_pty_no" id="labl_clm_pty_no" /> </td>
					<td><input type="text" name="clm_liable_pty_abbr_nm" style="width:70px;" value="" class="input" dataformat="engup" maxlength="20" id="clm_liable_pty_abbr_nm" /><!-- 
						 --><button type="button" id="btn1_Liable_Party" name="btn1_Liable_Party" class="input_seach_btn"></button></td>
					<td><b>Surveyor</b><input type="hidden" name="svey_clm_pty_no" id="svey_clm_pty_no" /> </td>
					<td><input type="text" name="clm_surveyor_pty_abbr_nm" style="width:70px;" value="" class="input" dataformat="engup" maxlength="20" id="clm_surveyor_pty_abbr_nm" /><!-- 
						 --><button type="button" id="btn1_Surveyor" name="btn1_Surveyor" class="input_seach_btn"></button></td>
				</tr>
				<tr>
					<th title="Received Office">ROFC</th>
					<td><input type="text" name="fmal_clm_rcv_ofc_cd" style="width:60px;text-align:center;" value="" class="input" dataformat="engup" id="fmal_clm_rcv_ofc_cd" /> </td>
					<th>Claimant&nbsp;<input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no" /> </th>
					<td><input type="text" name="clmt_clm_pty_abbr_nm" style="width:60px;" value="" class="input" dataformat="engup" maxlength="20" id="clmt_clm_pty_abbr_nm" /><!-- 
						 --><button type="button" id="btn1_Claimant" name="btn1_Claimant" class="input_seach_btn"></button></td>
					<th>Claimant's Agent&nbsp;<input type="hidden" name="clmt_clm_agn_pty_no" id="clmt_clm_agn_pty_no" /> </th>
					<td><input type="text" name="clmt_clm_agn_pty_abbr_nm" style="width:65px;" value="" class="input" dataformat="engup" maxlength="20" id="clmt_clm_agn_pty_abbr_nm" /><!-- 
						 --><button type="button" id="btn1_Claimant_Agent" name="btn1_Claimant_Agent" class="input_seach_btn"></button></td>
					<th>Salvager&nbsp;<input type="hidden" name="slv_clm_pty_no" id="slv_clm_pty_no" /> </th>
					<td><input type="text" name="slv_clm_pty_abbr_nm" style="width:80px;" value="" class="input" dataformat="engup" maxlength="20" id="slv_clm_pty_abbr_nm" /><!-- 
					 	--><button type="button" id="btn1_Salvager" name="btn1_Salvager" class="input_seach_btn"></button></td>
					<th>Insurer&nbsp;<input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" /> </th>
					<td colspan="3"><input type="text" name="insur_clm_pty_abbr_nm" style="width:70px;" value="" class="input" dataformat="engup" maxlength="20" id="insur_clm_pty_abbr_nm" /><!-- 
						 --><button type="button" id="btn1_Insurer" name="btn1_Insurer" class="input_seach_btn"></button></td>
				</tr>
			    <tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="trnk_ref_vvd_no" style="width:60px;text-align:center;" value="" class="input" dataformat="engup" maxlength="20" id="trnk_ref_vvd_no" /> </td>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="por_cd" style="width:60px;text-align:center;" value="" class="input" dataformat="engup" maxlength="5" id="por_cd" /><!-- 
						 --><button type="button" id="btn1_POR" name="btn1_POR" class="input_seach_btn"></button></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" style="width:65px;text-align:center;" value="" class="input" dataformat="engup" maxlength="5" id="pol_cd" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" style="width:53px;text-align:center;" value="" class="input" dataformat="engup" maxlength="5" id="pod_cd" /> </td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" style="width:70px;text-align:center;" value="" class="input" dataformat="engup" maxlength="5" id="del_cd" /><!-- 
						 --><button type="button" id="btn1_DEL" name="btn1_DEL" class="input_seach_btn"></button></td>
					<th title="Feeder Voyage Direction">FVD</th>
					<td><input type="text" name="fvd" style="width:70px;text-align:center;" value="" class="input" dataformat="engup" maxlength="20" id="fvd" /> </td>
					<th title="Pre-Carriage Port of Transhipment">PRE_POT</th>
					<td><input type="text" name="n1st_pre_ts_loc_cd" style="width:50px;text-align:center;" value="" class="input" dataformat="engup" maxlength="5" id="n1st_pre_ts_loc_cd" /> </td>
					<th>POS_POT</th>
					<td><input type="text" name="n1st_pst_ts_loc_cd" style="width:100px;%;text-align:center;" value="" class="input" dataformat="engup" maxlength="5" id="n1st_pst_ts_loc_cd" /> </td>
				</tr>
				
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="40"/>
					<col width="50"/>
					<col width="30"/>
					<col width="60"/>
					<col width="30"/>
					<col width="50"/>
					<col width="30"/>
					<col width="230"/>
					<col width="48"/>
					<col width="60"/>
					<col width="50"/>
					<col width="50"/>
					<col width="30"/>
					<col width="100"/>
					<col width="50"/>
					<col width="*"/>
			    </colgroup>
			    <tr>
					<th title="Carriage Term">CT</th>
					<td><script type="text/javascript">ComComboObject("crr_term_cd", 2, 45, 1);</script></td>
					<th title="Place of Incident">POI</th>
					<td ><script type="text/javascript">ComComboObject("inci_plc_tp_cd", 2, 60, 1);</script></td>
					<th>Lane</th>
					<td><input type="text" name="slan_cd" style="width:50px;text-align:center;" value="" class="input" dataformat="engup" maxlength="3" id="slan_cd" /> </td>
					<th>Cargo</th>
					<td><input type="text" name="clm_cgo_tp_cd" style="width:30px;text-align:center;" value="" class="input" dataformat="engup" maxlength="6" id="clm_cgo_tp_cd" /><!-- 
						 --><button type="button" id="btn1_Cargo" name="btn1_Cargo" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="clm_cgo_tp_nm" style="width:160px;" value="" class="input2" readonly="readonly" id="clm_cgo_tp_nm" /> </td>
					<th title="Type of Claim">TOC</th>
					<td><script type="text/javascript">ComComboObject("cgo_clm_tp_cd", 2, 60, 1);</script></td>
					<th title="Cause of Damage or Loss">CODL 1</th>
					<td><input type="text" name="mjr_clm_dmg_lss_cd" style="width:70px;text-align:center;" value="" class="input" dataformat="engup" maxlength="6" id="mjr_clm_dmg_lss_cd" /><!-- 
						 --><button type="button" id="btn1_CODL1" name="btn1_CODL1" class="input_seach_btn"></button></td>
					<th title="Cause of Damage / Loss">2</th>
					<td><input type="text" name="minr_clm_dmg_lss_cd" style="width:50px;text-align:center;" value="" class="input" dataformat="engup" maxlength="6" id="minr_clm_dmg_lss_cd" /><!-- 
						 --><button type="button" id="btn1_CODL2" name="btn1_CODL2" class="input_seach_btn"></button></td>
					<th>Litigation</th>
					<td><select style="width:40px;" name="lit"  id="lit"> 
					    <option value="" selected></option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
				</tr>
				
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="40"/>
					<col width="96"/>
					<col width="70"/>
					<col width="211"/>
					<col width="122"/>
					<col width="150"/>
					<col width="85"/>
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th title="Type Of Settlement">TOS</th>
					<td><script type="text/javascript">ComComboObject("cgo_clm_stl_tp_cd", 2, 60, 1);</script></td>
					<th>Claim Amount</th>
					<td><input type="text" name="from_clmt_usd_amt" style="width:110px;text-align:right" value="" dataformat="float" class="input" id="from_clmt_usd_amt" />~&nbsp;<!-- 
						 --><input type="text" name="to_clmt_usd_amt" style="width:104px;text-align:right" dataformat="float" value="" class="input" id="to_clmt_usd_amt" /> </td>
					<th>Settled Amount</th>
					<td><input type="text" name="from_cgo_clm_stl_usd_amt" style="width:110px;text-align:right" value="" dataformat="float" class="input" id="from_cgo_clm_stl_usd_amt" />~&nbsp;<!-- 
						 --><input type="text" name="to_cgo_clm_stl_usd_amt" style="width:110px;text-align:right" dataformat="float" value="" class="input" id="to_cgo_clm_stl_usd_amt" /> </td>
					<th>INC No.</th>
					<td><input type="text" name="cgo_clm_inci_no" style="width:103px;" value="" class="input" dataformat="engup" maxlength="11" id="cgo_clm_inci_no" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" >			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
</div>
<!-- opus_design_grid(E) -->

</form>


