<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_024.jsp
*@FileTitle  : SPC Control J/O Slot Creation/Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0024Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
    EsmBsa0024Event  event = null;                      //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;                 //error from server
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.bsa.bsamanage.ESM_BSA_0024");
    String strErrMsg    = "";                           //error message
    String jHeader      = "";
    String sHeader      = "";
    String cobTrade     = "";
    String cobLane      = "";
    String cobDir       = "";
    String trd_cd       = "";
    String rlane_cd     = "";
    String cobOpJob     = "";
    String opJob		= "";

    String userId   = "";
    String userName = "";
    String xml = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmBsa0024Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");

                jHeader = JSPUtil.getNull(retVo.getStrTemp());
                sHeader = JSPUtil.getNull(retVo.getStrTemp2());
                opJob = retVo.getStrTemp3();

                trd_cd   = JSPUtil.getNull(request.getParameter("selTrade"))==null? "": JSPUtil.getNull(request.getParameter("selTrade"));
                rlane_cd = JSPUtil.getNull(request.getParameter("selRlane"))==null? "": JSPUtil.getNull(request.getParameter("selRlane"));
           } // end if
        } // end else
        //추가----------------------------------------------------------------------------------------- END
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>

    function setupPage(){
        var jHeader = "<%=jHeader%>";
        var sHeader = "<%=sHeader%>";
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage(jHeader, sHeader);

        //document.getElementById("txtSDate").value = "2009-08-01";
        //document.getElementById("txtEDate").value = "2009-08-31";
    }
</script>

<!-- 2014.11.19 김용습 - iframe을 div로 감싸서 div의 display를 none으로 설정하지 않으면 타이틀 아래 불필요한 하얀 여백이 생겨서, 해당 작업합니다 -->
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<!-- <form method="post" name="form" onKeyDown="ComKeyEnter();"> -->
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="jHeader" value="<%=jHeader%>" id="jHeader" />
<input type="hidden" name="sHeader" value="<%=sHeader%>" id="sHeader" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<input type="hidden" name="param1" id="param1" />
<input type="hidden" name="param2" id="param2" />
<input type="hidden" name="param3" id="param3" />
<input type="hidden" name="param4" id="param4" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	 --><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	 --><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />				
				<col width="270" />				
				<col width="100" />				
				<col width="70" />				
				<col width="80" />				
				<col width="70" />				
				<col width="80" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Period</th>
	                <td><!-- 
	                --><input class="input1" type="text" name="txtSDate" id="txtSDate" style="width:75px;text-align:center;" maxlength="8" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value=""><!-- 
	                --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~&nbsp;<!-- 
	                --><input  type="text" name="txtEDate" id="txtEDate" style="width:75px;text-align:center;" maxlength="8"
	                          onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-'); this.select();" value="" ><!-- 
	                --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button><!-- 
	                --></td>
	                <th>(ETD of 1st Port)</th>
	                <th>Trade</th>
	                <td><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
	                <th>Lane</th>
	                <td><script type="text/javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></td>
	                <th>Dir.</th>
	                <td><script type="text/javascript">ComComboObject('cobDir', 1, 60 , 0 )</script></td>
		   		</tr>
		   </tbody>
		</table>
		</div>
	 	<table><tr><td class="line_bluedot"></td></tr></table>
	 	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="300" />
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<td id="div_bsaKind" style="font-weight: bold"></td>
		   			<td><strong>Carriers with BSA only&nbsp;</strong><input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans mar_left_4"></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="rdoLayer1">
		<div id="div_opjob" style="float:left; font-weight: bold"></div>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn" style="margin-bottom:5px"><button type="button" class="btn_down mar_btm_2" id="btn_zoom_in_1" name="btn_zoom_in_1" title="Zoom In (+)"></button></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="rdoLayer2" style="display:none">
		<div id="div_opjob2" style="float:left; font-weight: bold"></div>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn" style="margin-bottom:5px"><button type="button" class="btn_down mar_btm_2" id="btn_zoom_in_2" name="btn_zoom_in_2" title="Zoom In (+)"></button></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>


<script type="text/javascript">
<!--
	var opJob = "<%=opJob%>";
	var arrOpJob = opJob.split("|$$|");
      /*
        getting the Infomation, which the user input, from event except ibsheet and showing it on the screen
      */
    with(document.form) {
        <% if(event != null) {%>
        txtSDate.value 	= "<%= JSPUtil.getNull(request.getParameter("txtFMDate"))==null? "": JSPUtil.getNull(request.getParameter("txtFMDate")) %>";
		txtEDate.value 	= "<%= JSPUtil.getNull(request.getParameter("txtToDate"))==null? "": JSPUtil.getNull(request.getParameter("txtToDate")) %>";
		cobTrade.value  = "<%= JSPUtil.getNull(request.getParameter("selTrade"))==null? "": JSPUtil.getNull(request.getParameter("selTrade"))  %>";
		cobLane.value  	= "<%= JSPUtil.getNull(request.getParameter("selRlane"))==null? "": JSPUtil.getNull(request.getParameter("selRlane"))  %>";
		cobDir.value    = "<%= JSPUtil.getNull(request.getParameter("selDir"))==null? "": JSPUtil.getNull(request.getParameter("selDir"))    %>";
		<% } %>

        var rdoStr1 = "";
        var rdoStr2 = "";
        var rdoCode = arrOpJob[0].split("|");
        var rdoName = arrOpJob[1].split("|");

        for(i=0; i<rdoName.length-1; i++){
            rdoStr1 += "<input type='radio' value='"+rdoCode[i]+"' class='trans' name='rdoOp_jb_cd' id='rdoOp_jb_cd' onClick=\"chgBsaOpJb('"+rdoCode[i]+"','"+rdoName[i]+"');\">&nbsp;"+rdoName[i]+"&nbsp;&nbsp;&nbsp;&nbsp;";
            rdoStr2 += "<input type='radio' value='"+rdoCode[i]+"' class='trans' name='rdoOp_jb_cd2' id='rdoOp_jb_cd2' onClick=\"chgBsaOpJb('"+rdoCode[i]+"','"+rdoName[i]+"');\">&nbsp;"+rdoName[i]+"&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        div_opjob.innerHTML = rdoStr1;
        div_opjob2.innerHTML = rdoStr2;
        rdoOp_jb_cd[0].checked=true;
        rdoOp_jb_cd2[0].checked=true;
    }
-->
</script>