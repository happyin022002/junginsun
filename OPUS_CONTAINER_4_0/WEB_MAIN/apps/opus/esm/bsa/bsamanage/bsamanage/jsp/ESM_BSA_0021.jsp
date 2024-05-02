<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_021.jsp
*@FileTitle  : Inquire/Edit BSA Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0021Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 

<%
    //DBRowSet rowSet = null;
    DBRowSet[] rowSet = new DBRowSet[2];
    EsmBsa0021Event event = null;
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.bsa.ESM_BSA_0021");
    String strErrMsg = "";
    String xml = "";

    //String bsa_op_jb_cd1 = "";									//SJH.20150507.소스품질      
    //String bsa_op_jb_nm1 = "";
    //String crr_cd1 = "";
    //String bsa_op_jb_cd2 = "";
    //String bsa_op_jb_nm2 = "";
    //String crr_cd2 = "";
    StringBuffer bsa_op_jb_cd1 = new StringBuffer();				//SJH.20150507.소스품질      		
    StringBuffer bsa_op_jb_nm1 = new StringBuffer();
    StringBuffer crr_cd1 = new StringBuffer();
    StringBuffer bsa_op_jb_cd2 = new StringBuffer();
    StringBuffer bsa_op_jb_nm2 = new StringBuffer();
    StringBuffer crr_cd2 = new StringBuffer();     

	String userId   = "";
	String userName = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmBsa0021Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	CommonBsaRsVO vo = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
            	CommonBsaRsVO[] vos = vo.getCommonBsaRsVOArray();

                rowSet[0] = vos[0].getDbRowset();
                rowSet[1] = vos[1].getDbRowset();

                if (rowSet != null) {
                    while (rowSet[0].next()) {
                        //bsa_op_jb_cd1 = bsa_op_jb_cd1 + "|" + JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_cd"));
                        //bsa_op_jb_nm1 = bsa_op_jb_nm1 + "|" + JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_nm"));
                        //crr_cd1       = crr_cd1       + "|" + JSPUtil.getNull(rowSet[0].getString("crr_cd"));
                        bsa_op_jb_cd1.append("|").append(JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_cd")));			//SJH.20150507.소스품질
                    	bsa_op_jb_nm1.append("|").append(JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_nm")));
                    	crr_cd1.append("|").append(JSPUtil.getNull(rowSet[0].getString("crr_cd")));
                    } //end of while

                    while (rowSet[1].next()) {
                        //bsa_op_jb_cd2 = bsa_op_jb_cd2 + "|" + JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_cd"));
                        //bsa_op_jb_nm2 = bsa_op_jb_nm2 + "|" + JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_nm"));
                        //crr_cd2       = crr_cd2       + "|" + JSPUtil.getNull(rowSet[1].getString("crr_cd"));
                    	bsa_op_jb_cd2.append("|").append(JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_cd")));			//SJH.20150507.소스품질
                    	bsa_op_jb_nm2.append("|").append(JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_nm")));
                    	crr_cd2.append("|").append(JSPUtil.getNull(rowSet[1].getString("crr_cd")));  
                    } //end of while

                } //end of if
            } // end if
        } // end else
        //----------------------------------------------------------------------------------------- END

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>


<head>
<title>Inquire/Edit BSA Table</title>

<script type="text/javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage("<%=bsa_op_jb_nm1%>","<%=crr_cd1%>","<%=bsa_op_jb_nm2%>","<%=crr_cd2%>");
        //document.form.txtSDate.focus();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<!-- <form method="post" name="form" onSubmit="return false;" onKeyDown="keyEnter_loc();"> -->
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="param1" id="param1" />
<input type="hidden" name="param2" id="param2" />
<input type="hidden" name="param3" id="param3" />
<input type="hidden" name="param4" id="param4" />
<input type="hidden" name="param5" id="param5" />
<input type="hidden" name="param6" id="param6" />
<input type="hidden" name="param7" id="param7" />
<input type="hidden" name="param8" id="param8" />


<input type="hidden" name="bsa_op_jb_cd" value="<%=bsa_op_jb_cd1%>" id="bsa_op_jb_cd" />
<input type="hidden" name="bsa_op_jb_nm1" value="<%=bsa_op_jb_nm1%>" id="bsa_op_jb_nm1" />
<input type="hidden" name="jHeader" value="<%=crr_cd1%>" id="jHeader" />
<input type="hidden" name="bsa_op_jb_cd2" value="<%=bsa_op_jb_cd2%>" id="bsa_op_jb_cd2" />
<input type="hidden" name="bsa_op_jb_nm2" value="<%=bsa_op_jb_nm2%>" id="bsa_op_jb_nm2" />
<input type="hidden" name="sHeader" value="<%=crr_cd2%>" id="sHeader" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

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
				<col width="50" />				
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
	                --><input class="input1" type="text" name="txtSDate" id="txtSDate" style="width:75px;text-align:center;" maxlength="8" autocomplete="off" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value=""><!-- 
	                --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~&nbsp;<!-- 
	                --><input  type="text" name="txtEDate" id="txtEDate" style="width:75px;text-align:center;" maxlength="8" autocomplete="off"
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
	<div class="opus_design_grid">
		<div id="div_ui_jo" style="float:left; font-weight: bold"></div>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btng_rowadd" id="btng_rowadd" type="button">Row Copy</button><!--
			--><button class="btn_normal" name="btng_rowdel" id="btng_rowdel" type="button">Row Clear</button><!--
			--><button class="btn_normal" name="btng_creation" id="btng_creation" type="button">Creation</button><!--
			--><button class="btn_normal" name="btng_crrinfo" id="btng_crrinfo" type="button">CRR Info.</button><!--
			--><button class="btn_normal" name="btng_addcrrrgst" id="btng_addcarrgst" type="button">Add Carrier</button><!--
			--><button class="btn_normal" name="btng_stepupdownbyport" id="btng_stepupdownbyport" type="button">Step Up / Down by Port</button><!--
			--><button class="btn_normal" name="btng_skdinquiry" id="btng_skdinquiry" type="button">SKD Inquiry</button><!--
			--><button type="button" class="btn_down mar_left_4" id="btn_zoom_in" name="btn_zoom_in" title="Zoom In (+)"></button></div>
		<!-- opus_design_btn (E) -->
		<div id="tabLayer1">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div id="tabLayer2">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>	
	
	<!-- opus_design_grid(E) -->
	<b><font>* Initial Slots = Initial slot allocation among joint operating carriers(JO), Initial slots chartered from other carriers(SC)</font><br>
	<font color='#050099'>* Basic Leased = Slots leased to other carriers</font><br>
	<font color='#8041D9'>* Basic Chartered = Slots chartered from other carriers</font><br>
	<font color='#99004C'>* Additional Leased = Additional slots leased to other carriers</font><br>
	<font color='#22741C'>* Additional Chartered = Additional slots chartered from other carriers</font><br></b>
	</div>
</div>

</form>