<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4101.jsp
*@FileTitle : Sheet Setting Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.01 문중철
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4101Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F 버튼 권한 부여
	int i_cnt = 0;
    
    String tIssoff = "";
    String tJspno = "";
    String tTftp2 = "";
    String tSheetp = "";
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
		/***********************************
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
		**********************************/
		
        event = (EesDmt4101Event)request.getAttribute("Event");
        tJspno = (String)request.getParameter("jspno");
        invoice_issue   = JSPUtil.getParameter(request,"invoice_issue","1");
        
        if ( tJspno.equals("EES_DMT_4018") || tJspno.equals("EES_DMT_4012") || tJspno.equals("EES_DMT_3108") || tJspno.equals("EES_DMT_3109") || tJspno.equals("EES_DMT_3007") ) {
            tIssoff = strUsr_of;
        } else {
            if ( invoice_issue.equals("1") ) {
                tIssoff = strUsr_of;
            } else {
                tIssoff = (String)request.getParameter("issoff");
            }
        }
        
        tTftp2 = (String)request.getParameter("tftp2");
        tSheetp = (String)request.getParameter("sheetp");
        
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
<title>Sheet Setting Screen</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="copyFlag" value="N">

<input type="hidden" name="tJspno" value="<%=tJspno%>">
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>">
<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>"><!-- invoice 저장 권한 코드 -->


<input type="hidden" name="hOfad01">
<input type="hidden" name="hOfad02">
<input type="hidden" name="hOfad03">
<input type="hidden" name="hHead01">
<input type="hidden" name="hHead02">
<input type="hidden" name="hHead03">
<input type="hidden" name="hHead04">
<input type="hidden" name="hHead05">
<input type="hidden" name="hHead06">
<input type="hidden" name="hHead07">
<input type="hidden" name="hHead08">
<input type="hidden" name="hHead09">
<input type="hidden" name="hHead10">
<input type="hidden" name="hFoot01">
<input type="hidden" name="hFoot02">
<input type="hidden" name="hFoot03">
<input type="hidden" name="hFoot04">
<input type="hidden" name="hFoot05">
<input type="hidden" name="hFoot06">
<input type="hidden" name="hFoot07">
<input type="hidden" name="hFoot08">
<input type="hidden" name="hFoot09">
<input type="hidden" name="hFoot10">
<input type="hidden" name="hFoot11">
<input type="hidden" name="hFoot12">
<input type="hidden" name="hFoot13">
<input type="hidden" name="hFoot14">

<input type="hidden" name="tftp2" value="<%= tTftp2 %>">
<input type="hidden" name="trftpp">
<input type="hidden" name="sheetp" value="<%=tSheetp%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sheet Setting Screen</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
                <table class="search" border="0" style="width:566;"> 
                <tr class="h23">
                    <td width="88">Sheet Type</td>
                    <td width="150">
                        <select style="width:120;" name="shttpp">&nbsp;
                            <option value="I" selected>Invoice</option>
                            <option value="D"         >Demand Note</option>
                            <option value="G"         >Group Demand</option>
                            <option value="O"         >OTS Invoice</option>
                        </select>
                    </td>
                    <td width="40">Office</td>
                    <td width="100"><input type="text" style="width:60;" class="input2" value="<%=tIssoff%>" name="issoff" readOnly></td>
                    <td width="88">Tariff Type</td>
                    <td width=""><script language="javascript">ComComboObject('combo1',2,80,1,1)</script></td>
                </tr>
                </table>
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                
                <!-- : ( Grid ) (S) -->
                    <!-- : ( Grid ) (E) --> 
                <table width="100%" class="grid2" style="padding: 0 0 0 0"> 
                <tr class="tr2_head">
                    <td width="100%" colspan="2">Office Address</td></tr>
                <tr class="input1">
                    <td width="6%"><input type="text" style="width:100%;" class="noinput1" value=" 1"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="ofad01" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 2"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="ofad02" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 3"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="ofad03" maxlength="85" required></td>
                </tr>
                <tr class="tr2_head">
                    <td width="" colspan="2">Header</td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 1"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head01" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 2"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head02" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 3"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head03" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 4"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head04" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 5"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head05" maxlength="85" required></td>
                </tr>
                </table>
<div id = "div_view01" style = "display:'none'" >
                <table width="100%" class="grid2">
                <tr class="input1">
                    <td width="6%"><input type="text" style="width:100%;" class="noinput1" value=" 6"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head06" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 7"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head07" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 8"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head08" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 9"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head09" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value="10"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head10" maxlength="85" required></td>
                </tr>
                </table>
</div>
<div id = "div_view02" style = "display:''" >
                <table width="100%" class="grid2">
                <tr class="tr2_head">
                    <td width="" colspan="2">Footer</td></tr>
                <tr class="input1">
                    <td width="6%"><input type="text" style="width:100%;" class="noinput1" value=" 1"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot01" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 2"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot02" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 3"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot03" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 4"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot04" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 5"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot05" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 6"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot06" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 7"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot07" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 8"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot08" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 9"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot09" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 10"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot10" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 11"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot11" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 12"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot12" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 13"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot13" maxlength="85" required></td>
                </tr>
                <tr class="input1">
                    <td width=""><input type="text" style="width:100%;" class="noinput1" value=" 14"></td>
                    <td width=""><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot14" maxlength="85" required></td>
                </tr>
                </table>
</div>

            
                <!-- : ( Button : Grid ) (S) -->
                <!--  Button_Sub (S) -->
            
            <!-- Button_Sub (E) -->
            <!-- : ( Button : Grid ) (E) -->    
            
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
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
            </tr>
            </table>
        </td>
            <td class="btn1_line"></td>
        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_copy" title="Click Copy and then select the Sheet Type, Office, Tariff Type you will copy this sheet set to">Copy</td>
                    <td class="btn1_right"></td>
            </tr>
            </table>
        </td>
        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
            </tr>
            </table>
        </td>
        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_del">Delete</td>
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
         </td></tr>
</table>
    <!--Button (E) -->
       <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1',0,0);</script>
                            </td>
                        </tr>
                    </table>
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


                 
</form>         
</body>
</html>