<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1006.jsp
*@FileTitle : On-Hire Balance Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1006Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            
    String strErrMsg = "";                        
    int rowCount     = 0;                        //DB ResultSet 

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String levelCd = "";
    String ofcCd = "";
    
    String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";  
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();

        event = (EesEqr1006Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //levelCd   = eventResponse.getETCData("level_cd");
    }catch(Exception e) {
        out.println(e.toString());
    }
   
    String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");        
    
    String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70px;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
    
    String currYear = DateTime.getFormatDate(new java.util.Date(), "yyyy");
    
%>
<script language="javascript">
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

<% if (popMode.equals("Y")) { %>

<form name="form">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>&nbsp;On-Hire Balance Status</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<% } else { %>

<form name="form">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_Retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->    
<% } %>    

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">
<input type="hidden" name="curr_year" value="<%=currYear %>">

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table style="width:979px;"> 
            <tr>
                <th width="30px" class="align_left">Year</th>
                <td width="100px">
                    <script language="javascript">ComComboObject('years' , 1, 90, 1, 1 )</script>
                
                <th width="70px" class="align_left">Lease Term</th>
                <td width="70px">
                    <select style="width:65px;" name="eq_lstm_cd" class="input" ><!-- LOC_TYPE_CODE -->
                        <option value="" selected>ALL</option>
                        <option value="LT">LT</option>
                        <option value="ST">ST</option>
                        <option value="OW">OW</option>
                        <!-- loc_cd -->
                    </select> 
                </td>
                
                <th width="80px" class="align_left">Lease Period</th>
                <td width="70px">
                    <select style="width:65px;" name="lse_prd_seq" class="input" ><!-- LOC_TYPE_CODE -->
                        <option value="" selected>ALL</option>
                        <option value="1">1st</option>
                        <option value="2">2nd</option>
                        <option value="3">3rd</option>
                        <option value="4">4th</option>
                        <option value="5">5th</option>
                        <option value="6">6th</option>
                        <option value="7">7th</option>
                        <option value="8">8th</option>
                        <option value="9">9th</option>
                        <option value="10">10th</option>

                        <!-- loc_cd -->
                    </select> 
                </td>
                
                <th width="30px" class="align_left">RCC</th>
                <td width="90px">
                    <script language="javascript">ComComboObject('rcc_cd' , 1, 80, 1 )</script>
                </td>    
                
                <th width="30px" class="align_left">LCC</th>
                <td width="90px">
                    <script language="javascript">ComComboObject('lcc_cd' , 1, 80, 1 )</script>
                </td>             
                <th width="35px" class="align_left">TP/SZ</th>
                <td width="90px"><%= cntrTpsz %></td>
                <td width="150px">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 150, 1 )</script></td>
            </tr>
        </table>
	</div>
</div>
 
 <div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
	   		<button type="button" class="btn_normal" name="btn_rowadd">Row&nbsp;Add</button>
	   		<button type="button" class="btn_normal" name="btn_rowdel">Row&nbsp;Del</button>
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>   
 
</form>
