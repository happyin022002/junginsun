<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4009.jsp
*@FileTitle : Outstanding Inquiry by Customer & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.11 최성환
* 1.0 Creation
* -----------------------------------------------------------
2013.04.24 임창빈 [CHM-201324212] [DMT] OTS Inquiry 관련 보완 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strRhq_of = "";
    String strUsr_em = "";
    Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.InvoiceIssueCollectionMgt");
    
    String mailContents =    "<br>"
                            +"Attached to this e-mail is a Demurrage / Detention Statement from SM Line. <br>" 
                            +"If you have any difficulties or questions pertaining to the statement, <br>"
                            +"please contact our local branch office. <br>"
                            +"<br>"
                            +"SM Line Corporation <br>" 
                            +"<br>"
                            +"www.smlines.com <br>"  
                            +"<br>";
    
    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strRhq_of = account.getRhq_ofc_cd();
        strUsr_em = account.getUsr_eml();
       
        event = (EesDmt4009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Outstanding Inquiry by Customer & Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();

    }
    
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="tab_order" value="0">
<input type="hidden" name="isof">
<input type="hidden" name="ctof">
<input type="hidden" name="tftp">
<input type="hidden" name="arif">
<input type="hidden" name="coll">
<input type="hidden" name="cutp">
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="chk_payer">
<input type="hidden" name="chk_payer2">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="usr_trf_tp2">

<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>">

<input type="hidden" name="ofc_cd">

<input type="hidden" name="invno">
<input type="hidden" name="sheetp">

<input type="hidden" name="eml_exist_flg">

<!-- 메일이나 팩스전송 전 sheet set 존재여부 판단 조회쿼리용 -->
<input type="hidden" name="issoff" value="<%=strUsr_of%>">
<input type="hidden" name="trftpp">
<input type="hidden" name="shttpp" value="O">

<!-- 메일이나 팩스전송 -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_doc_tp"         > <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add" value="<%= strUsr_em %>"> <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="offcd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="mailctnt" value="<%= mailContents %>">
<input type="hidden" name="chk_srep_flg" value = "N">
<input type="hidden" name="chk_srep_flg2" value = "N">

<input type="hidden" name="paycMail">
<input type="hidden" name="paynMail">
<input type="hidden" name="tarfMail">
<input type="hidden" name="h_usr_off" value="<%=strUsr_of%>">
<input type="hidden" name="shd_rhq_cd">

<input type="hidden" name="usr_role_cd" value="DMT01,DMT02,DMT03,DMT04,DMT06,DMT10,DMT20,DMT30">
<input type="hidden" name="role_auth">
<input type="hidden" name="role_permit">
<input type="hidden" name="usr_id" 		value="<%= strUsr_id %>">
<input type="hidden" name="ots_flg">

<input type="hidden" name="chk_ctrt_cust">
<input type="hidden" name="chk_ctrt_no">
<input type="hidden" name="chk_payr_info">
<input type="hidden" name="chk_usd">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--top menu (S)-->
    <!--top menu (E)-->
    </td></tr>
    
    
    
    
    
    
    
    
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    
    <!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
	<!-- Tab (E) -->    
    
    <!-- Tab1 (S) -->
    <div id="tabLayer" style="display:inline">
    <table class="search">
            <tr><td class="bg">
               
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="80">Issue Office</td>
                        <td width="250" class="stm" style="padding-left:2;">
                            <script language="javascript">ComComboObject('combo2',2,80,0,1)</script>
                            &nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;
                            <input type="checkbox" name="chk_sub_ofc" value="Y" class="trans" onClick="doInclSubOfc(0)">Incl. Sub Office
                        </td>
                        <td width="80">Tariff Type </td>
                        <td width="270">
                            <script language="javascript">ComComboObject('combo1',2,220,1,1)</script>
                            &nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
                        </td>
				        <td width="120" class="stm">Group by</td>
				        <td width="" >				            
				            <select style="width:100;" class="input" name="cntrinvno">
				            <option value="0" selected>INV No</option>                
				            <option value="1">CNTR No.</option>
				        </select>
				        </td>                        
                    </tr>                
                    <tr class="h23">
                        <td width="80">Issued Date</td>
                        <td width="250">
                            <input type="text" style="width:80;" class="input1" value="" name="frdt" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;<input type="text" style="width:80;" class="input1" value="" name="todt" required dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
                        </td>
                        <td width="80">A/R I/F</td>
                        <td width="270"><script language="javascript">ComComboObject('combo5',2,220,1,1)</script>
                        &nbsp;<% if( strRhq_of.equals("NYCRA") || strRhq_of.equals("SELHO") ) { %><img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"><% } %>
                        </td>
                        <td width="120">ERP Col STS</td>
                        <td width="">
                            <script language="javascript">ComComboObject('combo3',2,180,1,1)</script>
                        </td>
                    </tr>
                </table>
                <!--  biz_1  (E) -->
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="80">Payer</td>
                        <td width="540">
	                        <table border="0" cellpadding="0" cellspacing="0">
	                        <tr><td>
							<input type="text" name="payc" style="width:80;" dataformat="engup" class="input" caption="Payer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >&nbsp;
							</td>
							<td><img src="img/btns_search.gif" name="btns_payer_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="payn" style="width:433;" class="input2" readOnly>
							</td></tr></table>  
                        </td>
                        
                        <td width="10">
                        <input type="checkbox" name="chk_srep" value="N" class="trans" onClick="checkSrepFlag(0)">
                        </td>
						<td width="80">Local S/Rep.</td>
						<td><input type="text" name="ob_srep_cd" style="width:47;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input2" value="" dataformat="engup" maxlength=5 tabindex=52></td>
						
						<td width="180" class="stm" id="purge_text" name="purge_text">
						    Incl. Purged&nbsp;
				            <select style="width:105;" class="input" name="prg_ex_in_cd">
				            <option value="EX" selected>Excl. Purged</option>                
				            <option value="IN">Incl. Purged</option>
				            <option value="ON">Only Purged</option>
				        	</select>
				        </td>  
						
                    </tr> 
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="82">Customer </td>
                        <td width="490">
                        <script language="javascript">ComComboObject('combo4', 1, 80 , 1)</script>
                        &nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="cuno" style="width:70;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >&nbsp;<img src="img/btns_search.gif" name="btns_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="cude" style="width:240;" class="input2" readOnly>

                        </td>
                        <td width="50">S/C No.</td>
                        <td width="140"><input type="text" style="width:100;;" class="input" value="" name="scno" dataformat="engup" maxlength="9"></td>
                        <td width="50">RFA No.</td>
                        <td width=""><input type="text" style="width:100;;" class="input" value="" name="rfan" dataformat="engup" maxlength="11"></td>
                    
                    </tr>
                    </table>
                <!-- Grid  (S) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table>
                    
                <!-- Grid  (e) -->
                
                
            </td></tr>
        </table>
        </div>
	<!-- : ( Search Options ) (E) -->
    <!-- Tab1 (E) -->     
                    
	<!-- Tab2 (S) -->
    <div id="tabLayer" style="display:none">
    <table class="search">
            <tr><td class="bg">
               
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="94">Contract OFC</td>
                        
                        <td width="250" class="stm" style="padding-left:2;" colspan="3" >
                            <script language="javascript">ComComboObject('combo6',2,80,0,1)</script>
                            &nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;
                            <input type="checkbox" name="chk_sub_ofc2" value="Y" class="trans" onClick="doInclSubOfc(1)">Incl. Sub Office
                        </td>
                        <td width="80">Tariff Type </td>
                        <td width="270">
                            <script language="javascript">ComComboObject('combo7',2,220,1,1)</script>
                            &nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
                        </td>
				        <td width="120">A/R I/F</td>
				        <td width="" >				            
				            <script language="javascript">ComComboObject('combo8',2,150,1,1)</script>
                        &nbsp;<% if( strRhq_of.equals("NYCRA") || strRhq_of.equals("SELHO") ) { %><img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"><% } %>
				        </td>                        
                    </tr>                
                    <tr class="h23">
                        <td width="94">Issued RHQ</td>
                        <td width="90" class="stm" style="padding-left:2;">
                            <script language="javascript">ComComboObject('combo12',1,80,1)</script>
                        </td>
                        <td width="90">Issued OFC</td>
                        <td width="90" class="stm" style="padding-left:2;">
                            <script language="javascript">ComComboObject('combo9',2,80,0,1)</script>
                        </td>
                        <td width="80">Issued Date</td>
                        <td width="270"><input type="text" style="width:80;" class="input1" value="20080101" name="frdt2" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;<input type="text" style="width:80;" class="input1" value="" name="todt2" required dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto2"  id="btns_calendarfm" >
                        </td>
                        <td width="120">ERP Col STS</td>
                        <td width="">
                            <script language="javascript">ComComboObject('combo10',2,180,1,1)</script>
                        </td>
                    </tr>
                </table>
                <!--  biz_1  (E) -->
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="90">G-Customer</td>
                        <td width="100">G-
	                        <input type="text" name="grop_cust" style="width:65;" dataformat="engup" class="input" caption="grop_cust" maxlength="10" minlength="10" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" > 
                        </td>
                        <td width="120">Contract Customer</td>
                        <td width="262">
	                        <input type="text" name="ctrt_cust" style="width:80;" dataformat="engup" class="input" caption="ctrt_cust" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" > 
	                        <img src="img/btns_search.gif" name="btns_c_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">
	                        <input type="text" name="c_cust_nm" style="width:149;" class="input2" readOnly>
                        </td>
                        
                        <td width="10">
                        <input type="checkbox" name="chk_srep2" value="N" class="trans" onClick="checkSrepFlag(1)">
                        </td>
						<td width="110">Contract S/Rep.</td>
						<td><input type="text" name="ob_srep_cd2" style="width:47;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input2" value="" dataformat="engup" maxlength=5 tabindex=52></td>
						
						<td width="180" class="stm" id="purge_text" name="purge_text2">
						    Incl. Purged&nbsp;
				            <select style="width:105;" class="input" name="prg_ex_in_cd2">
				            <option value="EX" selected>Excl. Purged</option>                
				            <option value="IN">Incl. Purged</option>
				            <option value="ON">Only Purged</option>
				        	</select>
				        </td>  
						
                    </tr> 
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="92">Customer </td>
                        <td width="480">
                        <script language="javascript">ComComboObject('combo11', 1, 80 , 1)</script>
                        &nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="cuno2" style="width:70;" dataformat="engup" class="input" caption="Customer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >&nbsp;<img src="img/btns_search.gif" name="btns_cust_cd2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="cude2" style="width:272;" class="input2" readOnly>
                        </td>
                        <td class="stm">
                        	<input type="checkbox" name="chk_c_cust" value="N" class="trans" onClick=""> Contract Cust&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        	<input type="checkbox" name="chk_c_no" value="N" class="trans" onClick=""> Contract nbr&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        	<input type="checkbox" name="chk_payr" value="N" class="trans" onClick=""> Payer
                        </td>                   
                    </tr>
                    </table>
                <table class="search" border="0" style="width:979;">
                    <tr class="h23">
                        <td width="90">Payer</td>
                        <td width="120">
	                        <input type="text" name="payc2" style="width:80;" dataformat="engup" class="input" caption="Payer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" >
							<img src="img/btns_search.gif" name="btns_payer_cd2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"><input type="hidden" name="payn2" style="width:0;" class="input2" readOnly>
                        </td>
                    	<td width="55">S/C No.</td>
                    	<td width="145"><input name="scno2" type="text" style="width:110;ime-mode:disabled" class="input" dataformat="engup">
                    	<img src="img/btns_multisearch.gif"	name="btns_multisearch5" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('scno2')"></td>
                    	<td width="55">RFA No.</td>
                    	<td width="145"><input name="rfan2" type="text" style="width:110;ime-mode:disabled" class="input" dataformat="engup">
                    	<img src="img/btns_multisearch.gif"	name="btns_multisearch5" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('rfan2')"></td>
                    	<td width="55">TAA No.</td>
                    	<td width="145"><input name="taano" type="text" style="width:110;ime-mode:disabled" class="input" dataformat="engup">
                    	<img src="img/btns_multisearch.gif"	name="btns_multisearch5" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('taano')"></td>                    	
                        <td class="stm">                        	
							<input type="radio" name="curr_flg" value="U" class="trans" checked>&nbsp;USD&nbsp;&nbsp;
							<input type="radio" name="curr_flg" value="L" class="trans">&nbsp;Local</td>
                        </td>
                    </tr>
                </table>   
                <!-- Grid  (S) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet2');</script>
                            </td>
                        </tr>
                    </table>
                    
                <!-- Grid  (e) -->
                
                
            </td></tr>
        </table>
        </div>
	<!-- : ( Search Options ) (E) -->
    <!-- Tab2 (E) -->
            
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_detail">Detail</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_fax_send">Fax Send</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_email_send">Email Send</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table>
    </td></tr>
</table>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>
<!-- Copyright (S) -->

<!-- Copyright(E)-->
<!-- 개발자 작업  끝-->
</form>
</body>
</html>