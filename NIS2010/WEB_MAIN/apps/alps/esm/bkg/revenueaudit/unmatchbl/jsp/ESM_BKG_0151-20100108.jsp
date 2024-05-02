<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0151.jsp
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0151Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg0151Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    //String blNo = "";
    
    String[] rhqs = null;
    String[] offices = null;
    String[] contractTypes = null;
    String[] svcScpCds = null;
    String[] repChgCds = null;
    String[] rTerms = null;
    String[] dTerms = null;
    String[] cargoTypes = null;
    String[] bkgStatuCds = null;
    String[] chargeFlgs = null;
    String[] splitFlgs = null;
    
    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg0151Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // S/C No Combo Data 생성
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // office
        offices = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("office"));
        if(null == offices){
        	offices = new String[] {"", ""};
        }
        // Contract Type => 0256 참조
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // rep charge
        repChgCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("repChgCd"));
        // r term Combo Data 생성
        rTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rTerm"), false , "|", "\t", "getCode", "getName");
        // d term Combo Data 생성
        dTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dTerm"), false , "|", "\t", "getCode", "getName");
        // cargo type term Combo Data 생성
        cargoTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
        // BKG Status Combo Data 생성
        bkgStatuCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("bkgStatuCd"), true , "|", "\t", "getCode", "getName");
        // Charge Status Combo Data 생성
        chargeFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chargeFlg"), true , "|", "\t", "getCode", "getName");
        // Split Status Combo Data 생성
        splitFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("splitFlg"), true , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Charge Filtering</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var officeComboValue = "|<%=offices[0]%>";
    
    if(officeComboValue == "|"){
        officeComboValue = "";
    }
    
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var repChgCdComboValue = "|<%=repChgCds[0]%>";
    var repChgCdComboText = "|<%=repChgCds[1]%>";

    var rTermComboValue = "|<%=rTerms[0]%>";
    var rTermComboText = "|<%=rTerms[1]%>";

    var dTermComboValue = "|<%=dTerms[0]%>";
    var dTermComboText = "|<%=dTerms[1]%>";

    var cargoTypeComboValue = "|<%=cargoTypes[0]%>";
    var cargoTypeComboText = "|<%=cargoTypes[1]%>";
    
    var bkgStatuCdComboValue = "|<%=bkgStatuCds[0]%>";
    var bkgStatuCdComboText = "|<%=bkgStatuCds[1]%>";

    var chargeFlgComboValue = "|<%=chargeFlgs[0]%>";
    var chargeFlgComboText = "|<%=chargeFlgs[1]%>";

    var splitFlgComboValue = "|<%=splitFlgs[0]%>";
    var splitFlgComboText = "|<%=splitFlgs[1]%>";
    
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
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" name ="search_date" value="BOOKING">
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">

 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
    
    
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0; padding-bottom:2;"> 
        <tr><td class="btn1_bg">
        
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td></tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="50">RHQ</td>
                    <td width="100"><script language="javascript">ComComboObject('bkg_rhq_cd', 1, 70, 0, 1, 0, false);</script></td>
                    <td width="45">Office</td>
                    <td width="110"><script language="javascript">ComComboObject('bkg_ofc_cd', 1, 70, 0, 0, 0, false);</script></td>
                    <td width="475">
                   		<table class="search_sm2" border="0" style="width:380;"> 
               			<tr class="h23">
                   			<td width="30">Date</td>
                   			<td class="stm"><nobr><input type="radio" class="trans" name="rdo_date" value="BOOKING" checked>Booking<input type="radio" class="trans" name="rdo_date" value="APPLICATION">Application</nobr></td> 
                    		<td width="">
                    		  <nobr>
                       			<input type="text" style="width:75;text-align:center;" class="input1" caption="From Date" name="from_dt" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
                      	 		~
                       			<input type="text" style="width:75;text-align:center;" class="input1" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
                       		  </nobr>
                   		    </td>
                    	</tr> 
               			</table> 
               		</td>
                    <td width="100"><nobr>Contract Type</nobr></td>
                    <td width="80"><script language="javascript">ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script></td>               		
                    <td width="90"><nobr>Contract No.</nobr></td>
                    <td width="" align="right"><input type="text" class="input" name="rfa_sc_no" style="width:110;text-align:center;ime-mode:disabled" caption="Contract No." dataformat="uppernum" maxLength="11"></td>
                    </tr> 
                </table>                
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="50">Scope</td>
                    <td width="100"><script language="javascript">ComComboObject('svc_scp_cd', 2, 90, 0, 0, 0, false);</script></td>
                    <td width="42">POR</td>
                    <td width="80"><input type="text" name="por_cd" style="width:50;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5"> <img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_por_cd"></td>
                    <td width="30">POL</td>
                    <td width="80"><input type="text" name="pol_cd" style="width:50;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5"> <img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pol_cd"></td>
                    <td width="30">POD</td>
                    <td width="80"><input type="text" name="pod_cd" style="width:50;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5"> <img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pod_cd"></td>
                    <td width="30">DEL</td>
                    <td width="90"><input type="text" name="del_cd" style="width:50;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5"> <img class="cursor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_del_cd"></td>
                    <td width="80">Rep. Charge</td>
                    <td width="130"><script language="javascript">ComComboObject('rep_chg_cd', 2, 90, 0, 0, 0, false);</script></td>
                    <td width="47">Charge</td>
                    <td width="" ><script language="javascript">ComComboObject('chg_cd', 2, 110, 0, 1, 0, false);</script></td>
                    </tr> 
                </table>    
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="48">T/VVD</td>
                    <td width="120"><nobr><input type="text" class="input" style="width:90;text-align:center;ime-mode:disabled" name="vvd" dataformat=uppernum caption="T/VVD" maxlength="9"> <img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_com_ens_ob2"></nobr></td>
                    <td width="64">R/D Term</td>
                    <td width="170">
                       <nobr><script language="javascript">ComComboObject('rcv_term_cd', 1, 70, 0, 0, 0, false);</script>&nbsp;<script language="javascript">ComComboObject('de_term_cd', 1, 70, 0, 0, 0, false);</script></nobr>
                    </td>               
                    <td width="77">Cargo Type</td>
                    <td width="130"><script language="javascript">ComComboObject('cargo_type', 2, 90, 0, 0, 0, false);</script></td>   
                        
                    <td>
                        <table class="search_sm2" border="0" style="width:100%;"> 
                            <tr class="h23">
                                <td ><nobr>Bill Type</nobr></td>
                                <td class="stm"><input type="checkbox" class="trans" name="bill_type_all"  value="ALL" checked>ALL&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_n" value="N" checked>Normal&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_m" value="M" checked>Master&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_c" value="C" checked>Covered&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_b" value="B" checked>Co-Biz</td>
                    
                            </tr> 
                        </table>    
                    </td>   
                    </tr> 
                </table>    
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="90">BKG Status</td>
                    <td width="77"><script language="javascript">ComComboObject('bkg_sts_cd', 2, 72, 0, 0, 0, false);</script></td>
                    <td width="110">Charge Status</td>
                    <td width="125"><script language="javascript">ComComboObject('charge_flg', 2, 98, 0, 0, 0, false);</script></td>
                    <td width="77">Split Status</td>
                    <td width="120"><script language="javascript">ComComboObject('split_flg', 2, 90, 0, 0, 0, false);</script></td>
                    <td width="*">&nbsp;</td>                    
                </tr> 
                </table>                
                
                <!--  biz_1   (E) -->
            
        </td></tr></table>
        <table class="height_8"><tr><td></td></tr></table>  
        <table class="search" id="mainTable"> 
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
        <!--biz page (E)-->

    </td></tr>
        </table>
    
    <table class="height_10"><tr><td colspan="8"></td></tr></table>
    
<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
    
</form>

</body>
</html>
