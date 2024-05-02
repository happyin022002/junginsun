<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1073.jsp
*@FileTitle  : MT Inventory Simulation by Yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1073Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1073Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String levelCd = "";
    String ofcCd = "";

    String currYrwk = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();
        currYrwk  = DateTime.getFormatDate(new java.util.Date(), "yyyyww");

        event = (EesEqr1073Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        levelCd   = JSPUtil.getNull(eventResponse.getETCData("level_cd"));
    }catch(Exception e) {
        out.println(e.toString());
    }

    String optionStr2 = "000000: :ALL";
	String cntrTpsz = JSPUtil.getCodeCombo("cntrTpsz","","onChange='javascript:tpszChange(document.form.cntrTpsz.options[document.form.cntrTpsz.selectedIndex].value)' style='width:55;'","CD00263",0,optionStr2);
%>
<script type="text/javascript">
    //parent.window.moveTo(0,0);
    //parent.window.resizeTo("1600","900");
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="level_cd" value="<%= levelCd %>" id="level_cd" />
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>" id="ofc_cd" />

<input type="hidden" name="curr_yrwk" value="<%= currYrwk %>" id="curr_yrwk" />
<input type="hidden" name="rcc_cd" value="" id="rcc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">MT Inventory Simulation by Yard</button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_Bkg" id="btn_Bkg" type="button">BKG for OP Ref.</button><!--
	--><button class="btn_normal" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_downExcel" id="btn_downExcel" type="button">Down Excel</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="230" />				
				<col width="30" />				
				<col width="35" />				
				<col width="55" />				
				<col width="110" />				
				<col width="30" />				
				<col width="190" />				
				<col width="120" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
				 	<th>Location by</th>
                    <td><select style="width:115px;" name="loc_type_code" id="loc_type_code" class="input" ><!-- LOC_TYPE_CODE --><!--
                        --><!-- <option value="1" selected>ALL (by RCC)</option> --><!--
                        --><option value="2">RCC (by Country)</option><!--
                        --><option value="3">RCC (by LCC)</option><option value="4">LCC (by ECC)</option><option value="5" selected>LCC (by SCC)</option><option value="6">ECC (by SCC)</option><option value="7">SCC (by Yard)</option></select><!--
                        --><input type="text" class="input" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill="" value="" id="loc_cd" /><!--
                        --><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
                    <td></td>
                    <th>TP/SZ</th>
                    <td><%= cntrTpsz %></td>
                    <td><script type="text/javascript">ComComboObject('tpsztype' , 1, 100, 1 )</script></td>
                    <td></td>
                    <td><input type="checkbox" name="show_history" id="show_history" class="trans" OnClick="showHistory();" >Past 3 weeks history&nbsp;&nbsp;</td>
                    <td><input type="checkbox" name="show_detail" id="show_detail" class="trans" OnClick="showDetail();" >Show Detail&nbsp;&nbsp;</td>
                    <td></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>