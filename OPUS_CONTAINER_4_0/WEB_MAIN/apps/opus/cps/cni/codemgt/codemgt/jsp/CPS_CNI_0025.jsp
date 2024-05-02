<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0025.jsp
*@FileTitle  : [CPS_CNI_0025] Main Code-Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0025Event"%>
<%
	CpsCni0025Event event = null;
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
        
        event = (CpsCni0025Event) request.getAttribute("Event");
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
    // claim party no    
    String clmPtyNo = JSPUtil.getParameter(request , "clm_pty_no" , "");
    
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

<form id="form" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />



<!-- 개발자 작업 -->
<input type="hidden" name="clm_pty_no" id="clm_pty_no" value="<%=clmPtyNo%>" />
<!-- Mdm code hidden key -->
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="prnt_clm_pty_no" id="prnt_clm_pty_no" />
<input type="hidden" name="clm_pty_clr_no" id="clm_pty_clr_no" />
<input type="hidden" name="usr_id" id="usr_id"  value="<%=userId%>" readonly="readonly"/>
<input type="hidden" name="usr_roles" id="usr_roles" value="<%=roles%>" readonly="readonly"/>
<input type="hidden" name="usr_area"  id="usr_area" value="<%=area%>" readonly="readonly"/>
<input type="hidden" name="usr_office"  id="usr_office" value="<%=ofcCd%>"  readonly="readonly"/>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="35">
				<col width="110">
				<col width="50">
				<col width="180">
				<col width="65">
				<col width="80">
				<col width="60">
				<col width="70">
				<col width="73">
				<col width="10">
				<col width="100">
				<col width="*">
			</colgroup>
            <tr>
                <td><button type="button" class="btn_etc" name="btn1_Code" id="btn1_Code">Code</button></td>
                <td><input name="clm_pty_abbr_nm" type="text" style="width:142px;" readonly="readonly" value="" class="input2" id="clm_pty_abbr_nm" /> </td>
                <th>Delete</th>
                <td><input type="radio" name="delt_flg" value="N" checked="checked" class="trans" id="delt_flg" /><label for="delt_flg"> No</label><input type="radio" name="delt_flg" value="Y" class="trans" id="delt_flg" /><label for="delt_flg">Yes</label></td>
                <th>Register</th>
                <td><input type="text" name="cre_usr_id" style="width:80px;text-align: center;" readonly="readonly" value="<%=userId%>" class="input2" id="cre_usr_id" /> </td>
                <th>RGOFC</th>
                <td><input type="text" name="cre_ofc_cd" style="width:80px;text-align: center;" readonly="readonly" value="<%=userOffice%>" class="input2" id="cre_ofc_cd" /> </td>
                <th>Area</th>
                <td><input type="text" name="clm_area_cd" style="width:63px;text-align: center;" readonly="readonly" value="<%=userArea%>" class="input2" id="clm_area_cd" /> </td>
                <th>Update</th>
                <td><input type="text" name="upd_dt" style="width:80px;text-align: center;" readonly="readonly" value="" class="input2" id="upd_dt" /> </td>
            </tr>
 			</tbody>
     	</table>
      	<table>
		<tbody>
			<colgroup>
				<col width="121">
				<col width="80">
				<col width="112">
				<col width="480">
				<col width="80">
				<col width="*">
			</colgroup>       
            <tr>
                <th>Same Code Mapping</th>
                <td ><input type="text" name="clm_pty_clr_cd" style="width:78px;text-align: center;" readonly="readonly" value="" class="input2" id="clm_pty_clr_cd" /><!-- 
                 --><button type="button" id="btns_same_code" name="btns_same_code" class="input_seach_btn"></button>
                </td>                
                <th>Customer Mapping</th>
                <td><input type="text" name="cnt_cd" style="width:25px;text-align: center;" readonly="readonly" value="" class="input2" id="cnt_cd" /><!-- 
                 --><input type="text" name="cust_seq" style="width:80px;text-align: center;" readonly="readonly" value="" class="input2" id="cust_seq" /><!-- 
                 --><button type="button" id="btns_mdm_code" name="btns_mdm_code" class="input_seach_btn"></button><!-- 
                 --><input type="text" name="cust_nm" style="width:279px;text-align: left;" readonly="readonly" value="" class="input2" id="cust_nm" /> </td>
                <th>Refund/Vndr Code</th>
                <td><input type="text" name="tpb_cd" style="width:80px;text-align: center;" readonly="readonly" value="" class="input2" id="tpb_cd" /> </td>

            </tr>           
			</tbody>
     	</table>
     	</div>
     	<table class="line_bluedot"><tr><td></td></tr></table>
     	<div class= "opus_design_inquiry wFit">
        <table class="search">
		<tbody>
			<colgroup>
				<col width="45">
				<col width="80">
				<col width="112">
				<col width="110">
				<col width="80">
				<col width="*">
			</colgroup>  
            <tr>
                <th>Name</th>
                <td><input type="text" name="pty_nm" required="" caption="Name" style="width:300px;" value="" class="input1" maxlength="200" id="pty_nm" /> </td>
                <th>Location</th>
                <td><input type="text" name="loc_cd" required="" caption="Location" style="width:50px;text-align: center;" value="" readonly="readonly" class="input1" maxlength="5" id="loc_cd" /><!-- 
                 --><button type="button" id="btns_location" name="btns_location" class="input_seach_btn"></button></td>
                <th>Principal</th>
                <td><input type="text" name="prnt_clm_pty_abbr_nm" caption="Principal" style="width:110px;text-align: center;" value="" readonly="readonly" class="input2" id="prnt_clm_pty_abbr_nm" /><button type="button" id="btns_principal" name="btns_principal" class="input_seach_btn"></button></td>
            </tr>
            <tr>
                <th>Tel.</th>
                <td><input type="text" name="intl_phn_no" required="" caption="Tel" style="width:30px;ime-mode:disabled;text-align: center;" value="" class="input1" maxlength="4" dataformat="num" id="intl_phn_no" /><input type="text" name="phn_no" required="" caption="Tel" style="width:110px;ime-mode:disabled;" value="" class="input1" maxlength="50" id="phn_no" /></td>
                <th>Fax</th>
                <td><input type="text" name="intl_fax_no" style="width:30px;ime-mode:disabled;text-align: center;" value="" class="input" maxlength="4" dataformat="num" id="intl_fax_no" /><input type="text" name="fax_no" style="width:110px;ime-mode:disabled;" value="" class="input" maxlength="50" id="fax_no" /></td>
                <th>Address</th>
                <td><input type="text" name="pty_addr" style="width:380px;" value="" class="input" maxlength="100" id="pty_addr" /> </td>
            </tr>
            <tr>
                <th>E-Mail</th>
                <td><input name="pty_eml" type="text" style="width:300px;ime-mode:disabled;" value="" class="input" maxlength="200" id="pty_eml" /> </td>
                <th>ZIP/Postal</th>
                <td><input type="text" name="zip_cd_ctnt" style="width:144px;text-align: left;ime-mode:disabled;" value="" class="input" maxlength="100" id="zip_cd_ctnt" /> </td>
            </table> 
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table> 
		
     	<div class= "opus_design_inquiry wFit">
            
           <h3 style="margin-bottom:0" class="title_design">Comment</h3>
			<table> 
			<tr>
			 <td><textarea style=" resize:none;width:100%" rows="4" name="pty_rmk" id="pty_rmk" caption="Comment" maxlength="4000"></textarea></td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>          
	
            
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn2_Row_Add" id="btn2_Row_Add">Row&nbsp;Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn2_Row_Copy" id="btn2_Row_Copy">Row Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn2_Row_Delete" id="btn2_Row_Delete">Row&nbsp;Delete</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>         
</div>
</form>            
 