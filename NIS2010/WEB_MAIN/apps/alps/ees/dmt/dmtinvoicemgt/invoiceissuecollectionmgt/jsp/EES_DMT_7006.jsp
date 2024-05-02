<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7006.jsp
*@FileTitle : Fax/E-mail Sending History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.14 mun jung cheol
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt7006Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EesDmt7006Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_lc        = "";
    String jspno = "";
    String invoice = "";
    String selectOpt = "";
    String payerCd = "";
    String selectType = "";
    String popupYn = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
    
    String bodyProp = "";
	String tableProp = "";
	String tdProp = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_lc = account.getCnt_cd();

        jspno      = JSPUtil.getParameter( request , "jspno"      , "EES_DMT_7006" );
        invoice    = JSPUtil.getParameter( request , "invoice"    , ""             );
        selectOpt  = JSPUtil.getParameter( request , "selectOpt"  , "1"            );
        payerCd    = JSPUtil.getParameter( request , "payerCd"    , ""             );
        selectType = JSPUtil.getParameter( request , "selectType" , ""             );
        
        
        if (jspno.equals("EES_DMT_7006")) {
    		//Main 화면일 경우
    		tableProp 	= "cellpadding='0' cellspacing='0' style='padding-top:2;padding-left:5;'";
    		tdProp		= "btn1_bg";
    		popupYn     = "N";
    	}
    	else {
    		//PopUp 화면일 경우
    		bodyProp	= "class='popup_bg'";
    		tableProp	= "class='popup' cellpadding='5'";
    		tdProp		= "btn3_bg";
    		popupYn     = "Y";
    	}

        event = (EesDmt7006Event)request.getAttribute("Event");
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
<title>Fax/Email Sending History</title>
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
<body  <%=bodyProp%> onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sndoffc">
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="sndrnmm">
<input type="hidden" name="tempuser">
<input type="hidden" name="seloptt">

<input type="hidden" name="h_jspno"      value= "<%= jspno      %>">
<input type="hidden" name="h_invoice"    value= "<%= invoice    %>">
<input type="hidden" name="h_selectOpt"  value= "<%= selectOpt  %>">
<input type="hidden" name="h_payerCd"    value= "<%= payerCd    %>">
<input type="hidden" name="h_selectType" value= "<%= selectType %>">
<input type="hidden" name="popup_yn"     value= "<%= popupYn    %>">

<table width="100%" border="0" <%=tableProp%> >
    <tr><td class="top"></td></tr>
    <tr><td valign="top">
    
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><% if ( jspno.equals("EES_DMT_7006") ) { %><img src="img/icon_history_dot.gif" align="absmiddle"><% } %><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><% if ( jspno.equals("EES_DMT_7006") ) { %><span id="title"></span> <% }else{ %> Fax/E-mail Sending History<% } %></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    
    
     <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_minimize">Minimize</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    
<div id="sch_cond_div" style=display:block;>    
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search_sm2" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="155"><input type="radio" value="0" class="trans" name="selectOpt" checked>&nbsp;&nbsp;Date</td>
                    <td width="70" class="stm">Sent  Date</td>
                    <td width="240" class="stm">
                        <input type="text" name="sndfrdt" maxlength="8" dataformat="ymd" style="width:80" class="input1">&nbsp;~
                        <input type="text" name="sndtodt" maxlength="8" dataformat="ymd" style="width:80" class="input1" cofield="sndfrdt">
                        <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
                    </td>
                    <td width="70"  class="stm">Sent  Office</td>
                    <td width="130">
                        <script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script>&nbsp;<img src="img/btns_multisearch.gif" name="btns_sntoff" width="19" height="20" border="0" align="absmiddle" >
                    </td> 
                    <td width="68"  class="stm">Sender ID</td>
                    <td width="">
                        <input type="text" style="width:100;" value="" class="input" name="sndrcdd">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_sender_cd" width="19" height="20" border="0" align="absmiddle">
                    </td>
                    </tr>
                <tr class="h23">
                    <td width="155"><input type="radio" value="1" class="trans" name="selectOpt">&nbsp;&nbsp;Invoice</td>
                    <td width="70" class="stm">Invoice No.</td>
                    <td width="" colspan="5">
                        <input type="text" style="width:388;" dataformat="engup" value="" class="input2" name="invoice" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" readOnly >&nbsp;<img src="img/btns_multisearch.gif" name="btns_inv_no" width="19" height="20" border="0" align="absmiddle" class="cursor" >
                    </td>
                    </tr>
                <tr class="h23">
                    <td width="155"><input type="radio" value="2" class="trans" name="selectOpt">&nbsp;&nbsp;Demand / OTS</td>
                    <td width=" 70" class="stm">Payer</td>
                    <td width="" colspan="5">
                        <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                        <td><input type="text" name="payercd" style="width:80;" dataformat="engup" class="input2" caption="Payer" maxlength="8" minlength="8" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"  readOnly >&nbsp;</td>
                        <td>                        
                        <img src="img/btns_search.gif" name="btns_payer_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                        <input type="text" name="payernm" style="width:303;" class="input2" readOnly>
                        </td>
                        <td width="25"> </td>
                    <td width="70" class="stm">Sheet Type</td>
                    <td width="">
                        <select style="width:100;" name="shttppp">&nbsp;
                            <option value="A" selected> </option>
                            <option value="D"         >Demand Note</option>
                            <option value="G"         >Group Demand</option>
                            <option value="O"         >OTS Invoice</option>
                        </select>
                    </td>                        
                        </tr>
                        </table>
                    </td>
                    </tr>
                </table>
                <!--  biz_1   (E) -->
                
                </td></tr>
            </table>
</div>            
            <table class="height_8"><tr><td></td></tr></table>
    <table class="search"> 
        <tr><td class="bg">
        <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>            
            <!-- Grid (E) -->
            
        </td></tr>
    </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    
    
   
    </td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->


<% if (!jspno.equals("EES_DMT_7006")) { %>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
				</tr></table>
			</td>
		</tr>
		</table>
		</td></tr>
	</table>
<!-- : ( Button : pop ) (E) -->

</td></tr>
</table>
<% } %>


</form>
</body>
</html>