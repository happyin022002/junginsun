<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4012.jsp
*@FileTitle : Outstanding Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 문중철
*@LastVersion : 1.0 
* 2009.09.09 문중철
* 1.0 최초 생성 
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EES_DMT_4011HTMLAction"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4011Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strUsr_em = "";

    String tTftp2 = "";
    String tSheetp = "";
    String tIsof = "";
    String tPayc = "";
    String tBkgNo = "";
    String invno = "";
    String attyn = "";
    
    String mailContents =    "<br>"
                            +"Attached to this e-mail is a Demurrage / Detention Statement from SM Line. <br>" 
                            +"If you have any difficulties or questions pertaining to the statement, <br>"
                            +"please contact our local branch office. <br>"
                            +"<br>"
                            +"SM Line Corporation <br>" 
                            +"<br>"
                            +"www.smlines.com <br>"  
                            +"<br>";
    

    Logger log = Logger.getLogger("com.hanjin.apps.eqtransportplannperform.eqtransportplannperform");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_em = account.getUsr_eml();
        event = (EesDmt4011Event)request.getAttribute("Event");
        tIsof = (String)request.getParameter("isof");
        tTftp2 = (String)request.getParameter("tftp2");
        tSheetp = (String)request.getParameter("sheetp");        
        tBkgNo = (String)request.getParameter("bkgno");
        tPayc = (String)request.getParameter("payc");
        invno = (String)request.getParameter("invno");
        attyn = (String)request.getParameter("attyn");
        
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
<title>Outstanding Issue Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();     
    }
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<input type="hidden" name="h_usr_off" value="<%=strUsr_of%>">
<input type="hidden" name="invno">
<input type="hidden" name="tftp2">
<input type="hidden" name="creof">
<input type="hidden" name="sheetp" value="<%=tSheetp%>">
<input type="hidden" name="isof" value="<%=tIsof%>">
<input type="hidden" name="payc" value="<%=tPayc%>">
<input type="hidden" name="bkgno" value="<%=tBkgNo%>">

<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
<input type="hidden" name="rd_fxeml_file_name2"     > <!-- attch fax name //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_doc_tp"         > <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_rd_param2"      > <!-- RD REPORT PARAMETER (FAX ATTACH)//-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add" value="<%= strUsr_em %>"> <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="offcd" value="<%=tIsof%>">
<input type="hidden" name="mailctnt" value="<%= mailContents %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Outstanding Issue Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
    
    <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search"> 
       		<tr><td class="bg">
          
            <!-- : ( Seq. ) (S) -->
            <table border="1" style="width:880;" height="545" class="grid" >
            <tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
            <!-- : ( Seq. ) (E) -->

          
        </td></tr>
    </table>
    <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

<!-- OUTER - POPUP (E)nd -->


   
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:880;"> 
                    <tr class="h23">
                        <td width="70">Attention<td>
                        <td width="190"><input type="text" style="width:154;" class="input2" name="atn_val" value="" readOnly><td>
                        <td width="25">Tel.<td>
                        <td width="190"><input type="text" style="width:150;" class="input2" name="tel_val" value="" readOnly><td>
                        <td width="25">Fax<td>
                        <td width="190"><input type="text" style="width:150;" class="input2" name="fax_val" value="" readOnly><td>
                        <td width="40">E-mail<td>
                        <td width=""   ><input type="text" style="width:180;" class="input2" name="eml_val" value="" readOnly><td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:880;"> 
                    <tr class="h23">
                        <td width="70">OTS Sheet<td>
                        <td width="60" class="stm">Group by<td>
                        <td width="130">
                        <select style="width:92;" class="input" name="cntrinvno2" disabled>
                        <option value="0" selected>INV No.</option>                        
                        <option value="1">CNTR No.</option>
                        </select>
                        <td>
                        <td width="120">CNTR Rate Detail(s)<td>
                        <td width="" class="stm"><input type="checkbox" value="" class="trans" name="attachYN" disabled <%if(attyn.equals("Y")){ %>checked<% } %> title="Attach CNTR Rate Detail(s) to OTS Invoice Sheet">&nbsp;Attach<td>
                        
                    </tr>
                </table>
                
                
                    </td></tr>
                </table>
                
                
                
                
    <table class="height_5"><tr><td></td></tr></table>
   
    </td></tr>
</table>

    	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				 <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_OTS_Print" style="color:black;">OTS Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_fax_send" style="color:black;">Fax Send</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_email_send" style="color:black;">Email Send</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close" style="color:black;">Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>


<table width="100%"  id="mainTable" style=display:none;> 
    <tr>
        <td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet1');</script> <!-- hidden 처리 (E)-->
        </td>
    </tr>
</table> 
</form>
</body>
</html>
<!--                 
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Fax_Email" style="color:black;">Payer  Info + Fax/Email</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_remark" style="color:black;">Remark</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Sheet_Set" style="color:black;">Sheet Set</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Sheet_Option" style="color:black;">Sheet Option</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
 -->  
