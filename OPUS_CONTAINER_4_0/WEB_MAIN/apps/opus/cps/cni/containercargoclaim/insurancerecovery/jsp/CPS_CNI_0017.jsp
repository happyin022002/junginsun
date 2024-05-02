<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0017.jsp
*@FileTitle  : [CPS_GEM_0017] Insurance Recovery by Case
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.event.CpsCni0017Event"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0017Event event = null;
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

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.codemgt.CodeMgtSC");
    String xml = HttpUtil.makeXML(request,response);
    SignOnUserAccount account = null;
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0017Event) request.getAttribute("Event");
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


    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------
    // 카고 클레임
    String cgoClmNo = CniUtil.getCargoClaimNo(account);
    if (cgoClmNo == null || cgoClmNo.trim().length() == 0) {
    	cgoClmNo = "";
    }

    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();

%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%><html>

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
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" readonly="readonly"/>
<!-- 개발자 작업 -->
<input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" />
<input type="hidden" name="cgo_clm_sts_cd" id="cgo_clm_sts_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn1_New"  	id="btn1_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button><!--
	--><button type="button" class="btn_normal" name="btn1_Recovery_Cancel"  	id="btn1_Recovery_Cancel">Recovery Cancel</button><!--
	--><button type="button" class="btn_normal" name="btn1_Case_Close" id="btn1_Case_Close">Case Close</button><!--
	--><button type="button" class="btn_normal" name="btn1_Recovery_Open"  	id="btn1_Recovery_Open">Recovery Open</button><!--
	--><button type="button" class="btn_normal" name="btn1_Payment" id="btn1_Payment">Payment</button><!--
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="145">
				<col width="45">
				<col width="135">
				<col width="65">
				<col width="130">
				<col width="55">
				<col width="55">
				<col width="63">
				<col width="*">
			</colgroup>
			<tr>
                <th>Claim  No.</th>
                <td><input type="text" style="width:85px;text-align: center;ime-mode: disabled" dataformat="engup" caption="Claim  No." name="cgo_clm_no" value="<%=cgoClmNo%>" maxlength="10" required="" fullfill="" class="input1" id="cgo_clm_no" /><!--
                --><input type="text" style="width:20px;text-align: center;" name="clm_area_cd" readonly="readonly" class="input2" id="clm_area_cd" /></td>
                <th title="Handling Office">HOFC</th>
                <td><input type="text" style="width:100px;text-align: center;" name="hdlr_ofc_cd" readonly="readonly" class="input2" id="hdlr_ofc_cd" /></td>
                <th>Handler</th>
                <td><input type="text" style="width:80px;text-align: center;" name="hdlr_usr_id" readonly="readonly" class="input2" id="hdlr_usr_id" /><button type="button" id="btn1_Handler" name="btn1_Handler" class="input_seach_btn"></button></td>
                <th title="Date Of Updated">DOU</th>
                <td><input type="text" style="width:76px;text-align: center;" name="upd_dt" readonly="readonly" class="input2" id="upd_dt" /></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><button type="button" class="btn_etc" name="btn1_VVD" id="btn1_VVD">VVD</button></td>
                <td><input type="text" style="width:85px;text-align: center;" name="trnk_ref_vvd_no" readonly="readonly" class="input2" id="trnk_ref_vvd_no" /> </td>
                <th>Status</th>
                <td><input type="text" style="width:100px;text-align: center;" name="cgo_clm_sts_nm" readonly="readonly" class="input2" id="cgo_clm_sts_nm" /> </td>
                <th><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></th>
                <td><input type="text" style="width:40px;text-align: center;" name="hpd" readonly="readonly" class="input2" id="hpd" /> /  <input type="text" style="width:40px;text-align: center;" name="nhp" readonly="readonly" class="input2" id="nhp" /> </td>
                <th title="Type Of Settlement">TOS</th>
                <td><input type="text" style="width:76px;text-align: center;" name="cgo_clm_stl_tp_cd" readonly="readonly" class="input2" id="cgo_clm_stl_tp_cd" /> </td>
                <th title="Date Of Close">DOC</th>
                <td><input type="text" style="width:80px;text-align: center;" name="cs_clz_dt" readonly="readonly" class="input2" id="cs_clz_dt" /> </td>
             </tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="85">
				<col width="120">
				<col width="35">
				<col width="35">
				<col width="20">
				<col width="80">
				<col width="55">
				<col width="95">
				<col width="90">
				<col width="65">
				<col width="63">
				<col width="*">
			</colgroup>
			<tr>
                <th title="Type of Cargo Claim">TOC</th>
                <td><input type="text" style="width:40px;text-align: center;" name="cgo_clm_tp_cd" readonly="readonly" class="input2" id="cgo_clm_tp_cd" /></td>
                <th title="Cause of Damage / Loss">CODL 1</th>
                <td><input type="text" style="width:35px;text-align: center;" name="mjr_clm_dmg_lss_cd" readonly="readonly" class="input2" id="mjr_clm_dmg_lss_cd" /></td>
                <th title="Cause of Damage / Loss">2</th>
                <td><input type="text" style="width:35px;text-align: center;" name="minr_clm_dmg_lss_cd" readonly="readonly" class="input2" id="minr_clm_dmg_lss_cd" /></td>
                <th title="Place of Incident">POI</th>
                <td><input type="text" style="width:80px;text-align: center;" name="inci_plc_tp_cd" readonly="readonly" class="input2" id="inci_plc_tp_cd" /></td>
                <th title="Date of Incident">DOI</th>
                <td><input type="text" style="width:76px;text-align: center;" name="inci_occr_dt" readonly="readonly" class="input2" id="inci_occr_dt" /></td>
                <th>Cargo</th>
                <td><input type="text" style="width:80px;%;" name="clm_cgo_tp_cd" readonly="readonly" class="input2" id="clm_cgo_tp_cd" /></td>
            </tr>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="330">
				<col width="35">
				<col width="148">
				<col width="20">
				<col width="35">
				<col width="20">
				<col width="*">
			</colgroup>
			<tr>
                <th>Claim Amount</th>
                <td><input type="text" style="width:110px;text-align: right;" name="clmt_locl_amt" readonly="readonly" class="input2" id="clmt_locl_amt" /><input type="text" style="width:40px;text-align: center;" name="clmt_locl_curr_cd" readonly="readonly" class="input2" id="clmt_locl_curr_cd" /> </td>
                <th title="Date of Formal Claim">DOF</th>
                <td><input type="text" style="width:80px;text-align: center;" name="fmal_clm_rcv_dt" readonly="readonly" class="input2" id="fmal_clm_rcv_dt" /></td>
                <th title="Rate of Exchange">R.O.E</th>
                <td><input type="text" style="width:76px;text-align: right;" name="clmt_locl_xch_rt" readonly="readonly" class="input2" id="clmt_locl_xch_rt" /><input type="text" style="width:146px;text-align: right;" name="clmt_usd_amt" readonly="readonly" class="input2" id="clmt_usd_amt" /></td>
                <td>USD</td>
                <td>&nbsp;</td>

            </tr>
		</table>
	</div>


	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="134">
				<col width="550">
				<col width="*">
			</colgroup>
			<tr>
                <th>Insurer</th>
                <td><input type="text" style="width:130px;text-align: center;" name="insur_clm_pty_abbr_nm" readonly="readonly" class="input2" id="insur_clm_pty_abbr_nm" /><input type="text" style="width:416px;" name="insur_pty_nm" readonly="readonly" class="input2" id="insur_pty_nm" /></td>
                <td><button type="button" class="btn_etc" name="btn1_FileUpload" id="btn1_FileUpload">File Upload</button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="130">
				<col width="110">
				<col width="90">
				<col width="80">
				<col width="110">
				<col width="110">
				<col width="30">
				<col width="*">
			</colgroup>
			<tr>
                <th>Settled Amount</th>
                <td><input type="text" style="width:130px;text-align: right;" name="cgo_clm_stl_locl_amt" readonly="readonly" class="input2" id="cgo_clm_stl_locl_amt" /><input type="text" style="width:40px;text-align: center;" name="cgo_clm_stl_locl_curr_cd" readonly="readonly" class="input2" id="cgo_clm_stl_locl_curr_cd" /></td>
                <th title="Date of Settlement">DOS</th>
                <td><input type="text" style="width:80px;text-align: center;" name="cgo_clm_stl_dt" readonly="readonly" class="input2" id="cgo_clm_stl_dt" /></td>
                <th title="Rate of Exchange">R.O.E</th>
                <td><input type="text" style="width:80px;text-align: right;" name="cgo_clm_stl_xch_rt" readonly="readonly" class="input2" id="cgo_clm_stl_xch_rt" /><input type="text" style="width:180px;text-align: right;" name="cgo_clm_stl_usd_amt" readonly="readonly" class="input2" id="cgo_clm_stl_usd_amt" /></td>
                <td>USD</td>
                <td>&nbsp;</td>
             </tr>
             <tr>
                <th>LP Recovered Amount</th>
                <td><input type="text" style="width:130px;text-align: right;" name="labl_pty_rcvr_locl_amt" readonly="readonly" class="input2" id="labl_pty_rcvr_locl_amt" /><input type="text" style="width:40px;text-align: center;" name="labl_pty_rcvr_locl_curr_cd" readonly="readonly" class="input2" id="labl_pty_rcvr_locl_curr_cd" /> </td>
                <th title="LP Date of Receipt">LP DOR</th>
                <td><input type="text" style="width:80px;text-align: center;" name="labl_pty_rcvr_dt" readonly="readonly" class="input2" id="labl_pty_rcvr_dt" /></td>
                <th title="Rate of Exchange">R.O.E</th>
                <td><input type="text" style="width:80px;text-align: right;" name="labl_pty_rcvr_locl_xch_rt" readonly="readonly" class="input2" id="labl_pty_rcvr_locl_xch_rt" /><input type="text" style="width:180px;text-align: right;" name="labl_pty_rcvr_usd_amt" readonly="readonly" class="input2" id="labl_pty_rcvr_usd_amt" /></td>
                <td>USD</td>
                <td>&nbsp;</td>
             </tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="135">
				<col width="110">
				<col width="90">
				<col width="80">
				<col width="80">
				<col width="54">
				<col width="120">
				<col width="30">
				<col width="*">
			</colgroup>
			<tr>
                <th>INS Claimed Amount</th>
                <td><input type="text" style="width:130px;text-align: right;" name="insur_dmnd_amt" readonly="readonly" class="input2" id="insur_dmnd_amt" /><input type="text" style="width:40px;text-align: center;" name="insur_dmnd_curr_cd" readonly="readonly" class="input2" id="insur_dmnd_curr_cd" /> </td>
                <th title="INS Date of Formal Claim">INS DOF</th>
                <td><input type="text" style="width:80px;text-align: center;" name="insur_fmal_clm_dt" readonly="readonly" class="input2" id="insur_fmal_clm_dt" /></td>
                <th title="Rate of Exchange">R.O.E</th>
                <td colspan="2"><input type="text" style="width:80px;text-align: right;" name="insur_xch_rt" readonly="readonly" class="input2" id="insur_xch_rt" /><input type="text" style="width:180px;text-align: right;" name="insur_dmnd_usd_amt" readonly="readonly" class="input2" id="insur_dmnd_usd_amt" /></td>
                <td>USD</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <th>Recoverable Amount</th>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <th><input type="text" style="width:180px;text-align: right;" name="rcvr_usd_amt" readonly="readonly" class="input2" id="rcvr_usd_amt" /></th>
                <td>USD</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <th>INS DOR Amount</th>
                <td></td>
                <th title="INS Date of Receipt">INS DOR</th>
                <td><input type="text" style="width:80px;text-align: center;ime-mode: disabled" name="insur_rcvr_dt" caption="INS DOR" dataformat="ymd" required="" maxlength="10" class="input1" id="insur_rcvr_dt" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <th><input type="text" style="width:180px;text-align: right;ime-mode: disabled" name="insur_rcvr_usd_amt" class="input1" required dataformat="float" caption="INS DOR Amount" maxlength="13" id="insur_rcvr_usd_amt" /></th>
                <td>USD</td>
                <td>&nbsp;</td>
            </tr>
		</table>
	</div>

<div class="wrap_result">
	<table>
		<colgroup>
			<col width="120">
			<col width="*">
		</colgroup>
     	<tr>
     		<th class="title_design pad_btm_8">Development</th>
         	<td>&nbsp;</td>
         </tr>
     </table>
	<div class="opus_design_data">
		<table>
            <tr>
                <td><textarea style="width:100%;resize:none;" rows="12" name="insur_rmk" maxlength="4000"></textarea></td>
            </tr>
        </table>
	</div>
</div>

</div>

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>