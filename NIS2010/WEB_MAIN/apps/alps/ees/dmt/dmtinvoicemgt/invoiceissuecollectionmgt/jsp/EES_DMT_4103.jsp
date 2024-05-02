<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4103.jsp
*@FileTitle : Sheet Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.28 문중철
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4103Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_of = "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F 버튼 권한 부여
	int i_cnt = 0;
    
    String tIsof = "";
    String tJspno = "";
    String tTftp = "";
    String invoice_issue = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		//권한부여 체크 추가(2010.04.08)-- 로그인 User의 Role이 DMT01, DMT02, DMT03, DMT04가 아닐 경우
		//							   "You have no authority to XXXX!" alert 창을 띄우며 막음
		/******************************************************
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");
				
				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}
		
		log.debug("[USER_AUTH]"+sb.toString());
		******************************************************/
		
        event = (EesDmt4103Event)request.getAttribute("Event");
        tIsof = (String)request.getParameter("issoff");
        tJspno = (String)request.getParameter("jspno");
        tTftp = (String)request.getParameter("tftp");
        invoice_issue   = JSPUtil.getParameter(request,"invoice_issue","1");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        sec_invoice = eventResponse.getETCData("ROLE_AUTH_FLAG"); // 화면별 사용자 Role 권한 Flag 반환
        log.debug("\n[USER_AUTH] = "+ sec_invoice);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Sheet Option</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

</head>

<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="tIsof"  value="<%=tIsof %>">
<input type="hidden" name="tJspno" value="<%=tJspno%>">
<input type="hidden" name="tTftp" value="<%=tTftp%>">
<input type="hidden" name="invoice_issue" value="<%=invoice_issue%>">
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>">

<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>"><!-- invoice 저장 권한 코드 -->

<input type="hidden" name="selectRowNumUp" value="2">
<input type="hidden" name="selectRowNumDw" value="2">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sheet Option</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
                
        <table class="search" border="0" style="width:579;"> 
               <tr class="h23">
               <td width="80">Issue Office</td>
               <td width=""><input type="text" style="width:70;text-align:center;" class="input2" value="<% if ( invoice_issue.equals("2") ) { %><%=tIsof%><% } else { %><%=strUsr_of%><% } %>" name="isof" readOnly></td>
               </tr>
        </table> 
            <table class="height_8"><tr><td></td></tr></table>  
            <table class="search" border="0">
                    <tr class="h23"><td class="title_h"></td>
                    <td class="title_s">Payer</td>
                    </tr>
            </table>
                <!-- Payer  (S) -->
                <table width="100%" class="grid2"> 
                <tr>
                    <td width="18%" class="tr2_head">“To” Location</td>
                    <td width="32%" class="stm">
                        <select style="width:90;" class="input" name="toloca">
                            <option value="L" selected>Left</option>
                            <option value="R">Right</option>
                        </select>&nbsp;in Sheet
                    </td>
                    <td width="18%" class="tr2_head">Cust. Ref.</td>
                    <td width="" class="stm">
                        <select style="width:90;" class="input" name="cusref">
                            <option value="Y" selected>Include</option>
                            <option value="N">Exclude</option>
                        </select>&nbsp;in Sheet
                    </td>
                </tr>
                <tr>
                    <td width="" class="tr2_head">Tel. & Fax</td>
                    <td width="" class="stm">
                        <select style="width:90;" class="input" name="telfax">
                            <option value="Y" selected>Include</option>
                            <option value="N">Exclude</option>
                        </select>&nbsp;in Sheet
                    </td>
                    <td width="" class="tr2_head">Cust. VAT No.</td>
                    <td width="" class="stm">
                        <select style="width:90;" class="input" name="cusvat">
                            <option value="Y">Include</option>
                            <option value="N" selected>Exclude</option>
                        </select>&nbsp;in Sheet
                    </td>
                </tr>
                </table> 
                <!-- Payer  (e) -->
            <table class="height_8"><tr><td></td></tr></table>  
            <table class="search" border="0">
                    <tr class="h23"><td class="title_h"></td>
                    <td class="title_s">Credit Term</td>
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
                <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_rowadd01">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_rowdel01">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
            <table class="height_8"><tr><td></td></tr></table>  
            <table class="search" border="0">
                <tr class="h23">
                    <td class="title_h"></td>
                    <td class="title_s">Amount</td>
                </tr>
            </table>
            <!-- Tax  (S) -->
            <table width="100%" class="grid2"> 
                <tr>
                    <td width="18%" class="tr2_head">D/C by AMT or %</td>
                    <td width="" colspan="2" class="stm">
                        <select style="width:85;" class="input" name="dcamtr">
                        <option value="Y">Include</option>
                        <option value="N" selected>Exclude</option>
                        </select>&nbsp;in Sheet</td>
                    <td colspan="2" style="background-color:#F3F2F8;"></td>
                </tr>            
                <tr>
                    <td width="18%" class="tr2_head">Tax Rate</td>
                    <td width="10%" class="stm"><input type="text" style="width:100%;text-align:right" class="noinput" value="0" name="taxrto" dataformat="int" maxlength="2"></td>
                    <td width="15%" class="stm"><input type="text" style="width:100%;text-align:right" class="noinput" value=" %" readOnly></td>
                    <td width="27%" class="tr2_head">Tax Rate & VAT Amount</td>
                    <td width="" class="stm">
                        <select style="width:90;" class="input" name="rtovat">
                            <option value="Y" selected>Include</option>
                            <option value="N">Exclude</option>
                        </select>&nbsp;in Sheet
                    </td>
                </tr>
            </table> 
            <!-- Tax  (e) -->
                
        <table class="height_8"><tr><td></td></tr></table>  
            <table class="search" border="0">
                    <tr class="h23"><td class="title_h"></td>
                    <td class="title_s">&nbsp;Customized Title</td>
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
                <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_rowadd02">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_rowdel02">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
            
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
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
                <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
            </tr>
            </table>
        </td>
            <td class="btn1_line"></td>
        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
 </td></tr>
</table>
</form>         
</body>
</html>

