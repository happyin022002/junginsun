<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0027.jsp
*@FileTitle  : [CPS_CNI_0025] Main Code-Vie
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
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

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    // claim party no    
    String clmPtyNo = JSPUtil.getParameter(request , "clm_pty_no" , "");
    
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%><html>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업 -->
<input type="hidden" name="clm_pty_no" id="clm_pty_no"  value="<%=clmPtyNo%>" />
<input type="hidden" name="popupYn"  id="popupYn" value="<%=popupYn%>" />
<input type="hidden" name="prnt_clm_pty_no" id="prnt_clm_pty_no" />
<input type="hidden" name="clm_pty_clr_no" id="clm_pty_clr_no" />
<!-- Mdm code hidden key -->
<input type="hidden" name="vndr_seq" id="vndr_seq">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<% if ("Y".equals(popupYn)) { %>
		<h2 class="page_title"><span>Main Code-View</span></h2>
	<% } else { %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New"  	id="btn1_New">New</button><!-- 
		 <% if ("Y".equals(popupYn)) {%>
		 --><button type="button" class="btn_normal" name="btn1_close" 	id="btn1_close">Close</button>
		 <% } %><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
	<% if (!"Y".equals(popupYn)) { %>
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	<% } %>
</div>
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<!-- layout_wrap(S) -->
	      <table>
	      	<colgroup>
				<col width="50">
				<col width="155">
				<col width="45">
				<col width="97">
				<col width="55">
				<col width="80">
				<col width="44">
				<col width="80">
				<col width="35">
				<col width="50">
				<col width="45">
				<col width="*">
			</colgroup>      
			<tbody>
	            <tr>
	                <td><button type="button" class="btn_etc" name="btn1_Code" id="btn1_Code">Code</button></td>
	                <td><input name="clm_pty_abbr_nm" type="text" style="width:142px;" readonly="readonly" value="" class="input1" id="clm_pty_abbr_nm" /> </td>
	                <th>Delete</th>
	                <td><input type="radio" name="delt_flg" value="N" checked="checked" class="trans" disabled="disabled" id="delt_flg" /><label for="delt_flg"> No</label><input type="radio" name="delt_flg" value="Y" class="trans" disabled="disabled" id="delt_flg" /><label for="delt_flg">Yes</label></td>
	                <th>Register</th>
	                <td><input type="text" name="cre_usr_id" style="width:80px;text-align: center;" readonly="readonly" class="input2" id="cre_usr_id" /> </td>
	                <th>RGOFC</th>
	                <td><input type="text" name="cre_ofc_cd" style="width:80px;text-align: center;" readonly="readonly" class="input2" id="cre_ofc_cd" /> </td>
	                <th>Area</th>
	                <td><input type="text" name="clm_area_cd" style="width:50px;text-align: center;" readonly="readonly" class="input2" id="clm_area_cd" /> </td>
	                <th>Update</th>
	                <td><input type="text" name="upd_dt" style="width:80px;text-align: center;" readonly="readonly" value="" class="input2" id="upd_dt" /> </td>
	            </tr>
	            </tbody>
	     	</table>
	      	<table>
			<tbody>
				<colgroup>
					<col width="121">
					<col width="95">
					<col width="112">
					<col width="110">
					<col width="80">
					<col width="*">
				</colgroup>       
	            <tr>
	                <th>Same Code Mapping</th>
	                <td><input type="text" name="clm_pty_clr_cd" style="width:79px;text-align: center;" readonly="readonly" value="" class="input2" id="clm_pty_clr_cd" /></td>                
	                <th>Customer Mapping</th>
	                <td><input type="text" name="cnt_cd" style="width:25px;text-align: center;" readonly="readonly" value="" class="input2" id="cnt_cd" /><input type="text" name="cust_seq" style="width:80px;text-align: center;" readonly="readonly" value="" class="input2" id="cust_seq" /><input type="text" name="cust_nm" style="width:275px;text-align: left;" readonly="readonly" value="" class="input2" id="cust_nm" /> </td>
	                <th>Refund/Vndr Code</th>
	                <td><input type="text" name="tpb_cd" style="width:80px;text-align: center;" readonly="readonly" value="" class="input2" id="tpb_cd" /> </td>
	            </tr>
	           </tbody>
	         </table>   
	         </div>
	         <table class="line_bluedot"><tr><td></td></tr></table>
	          <div class="opus_design_inquiry wFit">    
	        <table>
			<tbody>
				<colgroup>
					<col width="40">
					<col width="340">
					<col width="30">
					<col width="140">
					<col width="55">
					<col width="*">
				</colgroup>  
	            <tr>
	                <th>Name</th>
	                <td><input type="text" name="pty_nm" caption="Name" style="width:339px;" value="" readonly="readonly" class="input2" maxlength="200" id="pty_nm" dataformat="engup"  /> </td>
	                <th>Location</th>
	                <td><input type="text" name="loc_cd" caption="Location" style="width:50px;text-align: center;" value="" readonly="readonly" class="input2" maxlength="5" id="loc_cd" /> </td>
	                <th>Principal</th>
	                <td><input type="text" name="prnt_clm_pty_abbr_nm" caption="Principal" style="width:110px;text-align: center;" value="" readonly="readonly" class="input2" id="prnt_clm_pty_abbr_nm" /> </td>
	            </tr>
	            <tr>
	                <th>Tel.</th>
	                <td><input type="text" name="intl_phn_no" caption="Tel" style="width:30px;ime-mode:disabled;text-align: center;" value="" readonly="readonly" class="input2" maxlength="4" dataformat="number" id="intl_phn_no" /><input type="text" name="phn_no" caption="Tel" style="width:110px;ime-mode:disabled;" value="" readonly="readonly" class="input2" maxlength="50" id="phn_no" /></td>
	                <th>Fax</th>
	                <td><input type="text" name="intl_fax_no" style="width:30px;ime-mode:disabled;text-align: center;" value="" readonly="readonly" class="input2" maxlength="4" dataformat="number" id="intl_fax_no" /><input type="text" name="fax_no" style="width:110px;ime-mode:disabled;" value="" readonly="readonly" class="input2" maxlength="50" id="fax_no" /></td>
	                <th>Address</th>
	                <td><input type="text" dataformat="engup" name="pty_addr" style="width:300px;" value="" readonly="readonly" class="input2" maxlength="100" id="pty_addr" /> </td>
	            </tr>
	            <tr>
	                <th>E-Mail</th>
	                <td><input name="pty_eml" type="text" style="width:339px;ime-mode:disabled;" value="" readonly="readonly" class="input2" maxlength="200" id="pty_eml" /> </td>
	                <th>ZIP/Postal</th>
	                <td><input type="text" name="zip_cd_ctnt" style="width:144px;text-align: center;ime-mode:disabled;" value="" readonly="readonly" class="input2" maxlength="100" id="zip_cd_ctnt" /> </td>
	            </tr>
	           </tbody>
	       </table> 
	 </div>
 </div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<h3 class="title_design mar_btm_8">Comment</h3>
	<div class="opus_design_data">
		<table class="grid_2"> 
			<tr>
				<td><textarea style=" resize:none;width:100%" rows="4" name="pty_rmk" id="pty_rmk" caption="Comment" maxlength="4000" disabled="disabled"></textarea></td>
			</tr>
		</table>
	</div>
</div>
 	
</form>