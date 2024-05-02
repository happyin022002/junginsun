<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0045.jsp
     *@FileTitle : [CPS_CNI_0045] Invoice Creation
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    CpsCni0045Event event = null;
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
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.codemgt.CodeMgtSC");
    SignOnUserAccount account = null;
    
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0045Event) request.getAttribute("Event");
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
    // 카고 클레임
    String cgoClmNo = CniUtil.getCargoClaimNo(account);
    if (cgoClmNo == null || cgoClmNo.trim().length() == 0) {
        cgoClmNo = "";
    }        
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
%>



<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.event.CpsCni0045Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%><html>
<head>
<title>Invoice Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<!-- 개발자 작업 -->
<input type="hidden" name="cgo_clm_pay_no">
<input type="hidden" name="clm_cost_tp_cd">
<input type="hidden" name="inv_sts_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
<td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->
    
    
    <!--biz page (S)-->
        <!--Button (S) -->
        
        <!--Button (E) -->
        
        <!--biz page (S)-->
        
<table class="search"> 
    <tr><td class="bg"> 
            
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="60">Claim  No.</td>
                <td width="160">
                <input type="text" style="width:90;text-align: center;ime-mode: disabled" caption="Claim  No." dataformat="engup" name="cgo_clm_no" maxlength="10" required fullfill value="<%=cgoClmNo%>" class="input1">&nbsp;<input type="text" style="width:30;text-align: center;" name="clm_area_cd" readonly="readonly" class="input2">
                </td>
                <td width="40">HOFC</td>
                <td width="100"><input type="text" style="width:80;text-align: center;" name="hdlr_ofc_cd" readonly="readonly" class="input2"></td>
                <td width="50">Handler</td>
                <td width="120"><input type="text" style="width:100;text-align: center;"  name="hdlr_usr_id" readonly="readonly" class="input2"></td>
                <td width="50">Status</td>
                <td width="120"><input type="text" name="cgo_clm_sts_nm"
                            style="width: 100;text-align:center" value="" class="input2" readonly="readonly">                            
                <td width="40">Class</td>
                <td width=""><input type="text" style="width:60;" name="cgo_clm_div_nm" readonly="readonly" class="input2"></td>
            </tr>
            </table> 
 </td></tr>
 </table>

    
<table class="height_8"><tr><td></td></tr></table>        
 <table class="search">
  <tr><td class="bg">             
            <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Invoice Processing Status</td></tr>
             </table>
            <!-- Grid  (S) -->
            <table width="100%"  class="search"  border="0" id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid  (E) -->
 </td>
 </tr>
 </table>
 
<table class="height_8"><tr><td></td></tr></table>        
 <table class="search">
        <tr><td class="bg">             
            <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Invoice Detail</td></tr>
                </table>
    
    <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="82">Invoice No.</td>
                <td width="240"><input type="text" style="width:110;text-align: center;" required readonly="readonly" name="inv_no" class="input2"></td>
                <td width="100">Inv. Date</td>
                <td width="110"><input type="text" style="width:80;text-align: center;" required readonly="readonly" name="inv_dt" class="input2">                
                <td width="30">Type</td>
                <td width="100"><input type="text" style="width:80;text-align: center;" required readonly="readonly" name="clm_cost_tp_nm" class="input2"></td>
                <td width="60">A/C Code</td>
                <td width="80"><input type="text" style="width:60;text-align:center;;" required readonly="readonly" name="acct_cd" class="input2"></td>
                <td width="70">Inv. Office</td>
                <td width=""><input type="text" style="width:80;text-align: center;" required readonly="readonly" name="inv_ofc_cd" class="input2"></td>
            </tr>
            <tr class="h23">
                <td width="">S/Provider</td>
                <td width=""><input type="text" style="width:70;text-align: center;" required readonly="readonly" name="clm_pty_abbr_nm" class="input2">
                <input type="text" style="width:140;" class="input2" readonly="readonly" name="pty_nm"></td>
                <td width="">Cost Office</td>
                <td width=""><input type="text" readonly="readonly" name="cost_ofc_cd" style="width:80;text-align: center;" class="input2"></td>
                <td width="">VVD</td>
                <td width=""><input type="text" name="trnk_ref_vvd_no" required readonly="readonly"" style="width:80;text-align: center;" class="input2"></td>
                <td width="">Lane</td>
                <td width=""><input type="text" required readonly="readonly" name="slan_cd" style="width:60;text-align:center;" name="slan_cd" class="input2"></td>
                <td width="">Rcvd Date</td>
                <td width=""><input type="text" required readonly="readonly" name="pay_dt" style="width:80;text-align: center;" class="input2">                
            </tr></table> 
            
        <table class="search" border="0" style="width:979;"> 
        <tr class="h23"><td>            
            <table class="search" border="0" style="width:100%;"> 
            <tr class="h23">
                <td width="82">Payment/P</td>
                <td width="240"><input type="text" required readonly="readonly" name="vndr_seq" style="width:70;text-align: center;" class="input2">                
                <input type="text" style="width:140;" readonly="readonly" name="vndr_lgl_eng_nm" class="input2"></td>
                <td width="100">C.Control Office</td>
                <td width=""><input type="text"  readonly="readonly" name="ap_ctrl_ofc_cd" tyle="width:80;text-align: center;" class="input2"></td>
                
            </tr></table> 
            <table class="search" border="0" style="width:100%;"> 
            <tr class="h23">
                <td width="82">Invoice AMT</td>
                <td width="240"><input type="text" readonly="readonly" name="locl_curr_cd" style="width:70;text-align:center;" class="input2">
                <input type="text" required readonly="readonly" style="width:140;text-align:right;" name="inv_amt" class="input2"></td>
                <td width="100">Net Inv. AMT</td>
                <td width=""><input type="text" readonly="readonly" name="inv_net_amt" dataformat="float" style="width:80;text-align:right;" class="input2"></td>
                
            </tr></table> 
            </td>
            <td width="">
            <table border="0" style="width:420; background-color:white;" class="grid2"> 
                <tr><td width="70" class="tr2_head">Description</td>
                <td width=""><textarea name="cost_desc" readonly="readonly" style="width:100%;height:40" class="input2 "></textarea></td>
                </tr>
                </table>
        </td>
        </tr>
        </table> 
        
        <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="85"></td>
                <td width="73">V.A. Tax</td>
                <td width="161"><input type="text" dataformat="float" name="inv_vat_amt" style="width:150;text-align:right;" class="input"></td>
                <td width="102">W.H. Tax</td>
                <td width="100"><input type="text" readonly="readonly" name="whld_tax_amt"  style="width:80;text-align:right;" class="input2"></td>
                <td width="105">Invoice Reg No.</td>
                <td width="165"><input type="text"  readonly="readonly" name="inv_rgst_no" style="width:140;text-align: center;" class="input2"></td>
                <td width="70">Reg Date</td>
                <td width=""><input type="text" readonly="readonly" name="cre_dt" style="width:80;text-align: center;"  class="input2">
                </td>
            
            </tr>
        </table> 
        <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="85"></td>
                <td width="73">AP GL Date</td>
                <td width="131"><input type="text" readonly="readonly" name="inv_eff_dt" style="width:80;text-align: center;" class="input2"></td>
                <td width="102">Payment Terms</td>
                <td width="130"><input type="text" readonly="readonly" name="vndr_term_nm" style="width:110;text-align: left;" class="input2"></td>
                
                <td width="105">Invoice Reg Seq.</td>
                <td width=""><input type="text"  readonly="readonly" name="inv_rgst_seq" style="width:140;text-align: center;" class="input2"></td>
            </tr>
        </table> 
            
            
            
    </td>
    </tr>
    </table>
            <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Down_Excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>       
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                    class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1_2" name="btn1_Handling_Costs">Handling&nbsp;Costs</td>
                        <td class="btn1_right"></td>
                    </tr>
                </table>
                </td>         
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->

    <!--biz page (E)-->
    
</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>

</body>
</html>