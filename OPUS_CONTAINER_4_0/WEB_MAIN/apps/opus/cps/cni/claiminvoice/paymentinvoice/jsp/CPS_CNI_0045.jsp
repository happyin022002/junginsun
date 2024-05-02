<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0045.jsp
*@FileTitle  : [CPS_CNI_0045] Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
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

<%
    CpsCni0045Event event = null;
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
    SignOnUserAccount account = null;

    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0045Event) request.getAttribute("Event");
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



<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.event.CpsCni0045Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%><html>
<head>
<title>Invoice Creation</title>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
    }
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" />
<!-- 개발자 작업 -->
<input type="hidden" name="cgo_clm_pay_no" id="cgo_clm_pay_no" />
<input type="hidden" name="clm_cost_tp_cd" id="clm_cost_tp_cd" />
<input type="hidden" name="inv_sts_cd" id="inv_sts_cd" />

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
		--><button class="btn_normal" name="btn1_Down_Excel" id="btn1_Down_Excel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn1_Handling_Costs" id="btn1_Handling_Costs" type="button">Handling Costs</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="120" />				
				<col width="70" />				
				<col width="100" />				
				<col width="70" />	
				<col width="100" />				
				<col width="70" />		
				<col width="100" />	
				<col width="70" />			
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Claim  No.</th>
	                <td><input type="text" style="width:90px;text-align: center;ime-mode: disabled" caption="Claim  No." dataformat="engup" name="cgo_clm_no" maxlength="10" value="<%=cgoClmNo%>" class="input1" id="cgo_clm_no" fullfill required/><!-- 
	                 --><input type="text" style="width:30px;text-align: center;" name="clm_area_cd" id="clm_area_cd" readonly="readonly" class="input2"></td>
	                <th title="Handling Office">HOFC</th>
	                <td><input type="text" style="width:80px;text-align: center;" name="hdlr_ofc_cd" readonly="readonly" class="input2" id="hdlr_ofc_cd" /> </td>
	                <th>Handler</th>
	                <td><input type="text" style="width:100px;text-align: center;" name="hdlr_usr_id" readonly="readonly" class="input2" id="hdlr_usr_id" /> </td>
	                <th>Status</th>
	                <td><input type="text" name="cgo_clm_sts_nm" id="cgo_clm_sts_nm" style="width: 100;text-align:center" value="" class="input2" readonly="readonly"></td>
	                <th>Class</th>
	                <td><input type="text" style="width:60px;" name="cgo_clm_div_nm" readonly="readonly" class="input2" id="cgo_clm_div_nm" /> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_grid(S) -->	
	
	<div class="opus_design_grid">	
		<h3 class="title_design mar_top_12">Invoice Processing Status</h3>	 
		<table><tr><td height="10"></td></tr></table>  
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
    <div class="line_bluedot"></div>
	<div class="opus_design_inquiry">
		<h3 class="title_design mar_top_12">Invoice Detail</h3>
		<table class="height_8"><tr><td></td></tr></table>  
		<table>
			<colgroup>
				<col width="80" />				
				<col width="230" />				
				<col width="100" />				
				<col width="155" />		
				<col width="110" />				
				<col width="140" />				
				<col width="100" />				
				<col width="90" />		
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>	   			
	                <th>Invoice No.</th>
	                <td><input type="text" style="width:110px;text-align: center;" readonly="readonly" name="inv_no" class="input2" id="inv_no" /> </td>
	                <th>Inv. Date</th>
	                <td><input type="text" style="width:80px;text-align: center;" readonly="readonly" name="inv_dt" class="input2" id="inv_dt" />                 </td>
	                <th>Type</th>
	                <td><input type="text" style="width:80px;text-align: center;"   readonly="readonly" name="clm_cost_tp_nm" class="input2" id="clm_cost_tp_nm" /> </td>
	                <th>A/C Code</th>
	                <td><input type="text" style="width:60px;text-align:center;;"   readonly="readonly" name="acct_cd" class="input2" id="acct_cd" /> </td>
	                <th>Inv. Office</th>
	                <td><input type="text" style="width:80px;text-align: center;"   readonly="readonly" name="inv_ofc_cd" class="input2" id="inv_ofc_cd" /> </td>
	            </tr>
	            <tr>
	                <th>S/Provider</th>
	                <td><input type="text" style="width:70px;text-align: center;"   readonly="readonly" name="clm_pty_abbr_nm" class="input2" id="clm_pty_abbr_nm" /><!-- 
	                  --><input type="text" style="width:140px;" class="input2" readonly="readonly" name="pty_nm" id="pty_nm" /> </td>	               
	                <th>Cost Office</th>
	                <td><input type="text" readonly="readonly" name="cost_ofc_cd" style="width:80px;text-align: center;" class="input2" id="cost_ofc_cd" /> </td>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" name="trnk_ref_vvd_no"   readonly="readonly"  style="width:80px;text-align: center;" class="input2" id="trnk_ref_vvd_no" /> </td>
	                <th>Lane</th>
	                <td><input type="text"   readonly="readonly" name="slan_cd" style="width:60px;text-align:center;" class="input2" id="slan_cd" /> </td>
	                <th>Rcvd Date</th>
	                <td><input type="text"   readonly="readonly" name="pay_dt" style="width:80px;text-align: center;" class="input2" id="pay_dt" />                 </td>
	            </tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="80" />				
				<col width="230" />				
				<col width="100" />				
				<col width="155" />		
				<col width="110" />				
				<col width="350" />							
				<col width="*" />			
		   </colgroup> 
		   <tbody>
		   		<tr>
		   		   <th>Payment/P</th>
	                <td><input type="text"   readonly="readonly" name="vndr_seq" style="width:70px;text-align: center;" class="input2" id="vndr_seq" /><!-- 
	                 --><input type="text" style="width:140px;" readonly="readonly" name="vndr_lgl_eng_nm" class="input2" id="vndr_lgl_eng_nm" /></td>
	                <th>C.Control Office</th>
	                <td><input type="text" readonly="readonly" name="ap_ctrl_ofc_cd" tyle="width:80;text-align: center;" class="input2" id="ap_ctrl_ofc_cd" /> </td>
		   			<th rowspan="2" style="border:1px solid #B8D6F6" class="sm">Description</th>
		            <td rowspan="2" style="border:1px solid #B8D6F6">&nbsp;<textarea name="cost_desc" id="cost_desc" readonly="readonly" style="width:99%;height:50px;resize:none;" class="input2 "></textarea>&nbsp;&nbsp;</td>
		            <td rowspan="2">&nbsp;</td>	
		   		</tr>
		   		<tr>
                <th>Invoice AMT</th>
                <td><input type="text" readonly="readonly" name="locl_curr_cd" style="width:70px;text-align:center;" class="input2" id="locl_curr_cd" /><!-- 
                 --><input type="text"   readonly="readonly" style="width:140px;text-align:right;" name="inv_amt" class="input2" id="inv_amt" /></td>
                <th>Net Inv. AMT</th>
                <td><input type="text" readonly="readonly" name="inv_net_amt" dataformat="float" style="width:80px;text-align:right;" class="input2" id="inv_net_amt" /> </td>	
            </tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="80" />				
				<col width="230" />				
				<col width="100" />				
				<col width="155" />		
				<col width="110" />				
				<col width="100" />		
				<col width="90" />									
				<col width="*" />					
		   </colgroup> 
		   <tbody>
		   		<tr>
	                <th>V.A. Tax</th>
	                <td><input type="text" dataformat="float" name="inv_vat_amt" style="width:150px;text-align:right;" class="input" id="inv_vat_amt" /> </td>
	                <th>W.H. Tax</th>
	                <td><input type="text" readonly="readonly" name="whld_tax_amt" style="width:80px;text-align:right;" class="input2" id="whld_tax_amt" /> </td>
	                <th>Invoice Reg No.</th>
	                <td><input type="text" readonly="readonly" name="inv_rgst_no" style="width:140px;text-align: center;" class="input2" id="inv_rgst_no" /> </td>
	                <th>Reg Date</th>
	                <td><input type="text" readonly="readonly" name="cre_dt" style="width:80px;text-align: center;" class="input2" id="cre_dt" /> </td>
		   		</tr>

		   		<tr>
		   		
	                <th>AP GL Date</th>
	                <td><input type="text" readonly="readonly" name="inv_eff_dt" style="width:80px;text-align: center;" class="input2" id="inv_eff_dt" /> </td>
	                <th>Payment Terms</th>
	                <td><input type="text" readonly="readonly" name="vndr_term_nm" style="width:110px;text-align: left;" class="input2" id="vndr_term_nm" /> </td>
	                <th>Invoice Reg Seq.</th>
	                <td colspan="3"><input type="text" readonly="readonly" name="inv_rgst_seq" style="width:140px;text-align: center;" class="input2" id="inv_rgst_seq" /> </td>
		   		</tr>
		   </tbody>
		</table>
		
	</div>
</div>

</form>