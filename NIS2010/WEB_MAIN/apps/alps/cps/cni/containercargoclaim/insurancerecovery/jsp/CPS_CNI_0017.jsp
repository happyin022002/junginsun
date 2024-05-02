<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0017.jsp
     *@FileTitle : [CPS_CNI_0017] Insurance Recovery by VVD
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.event.CpsCni0017Event"%>
<%
	CpsCni0017Event event = null;
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
        
        event = (CpsCni0017Event) request.getAttribute("Event");
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


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%><html>
<head>
<title>Insurance Recovery by Case</title>
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
<input type="hidden" name="insur_clm_pty_no">
<input type="hidden" name="cgo_clm_sts_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->
    
    
        <!--Button (S) -->
        
        <!--Button (E) -->
        
        <!--biz page (S)-->
        
<table class="search" id="mainTable"> 
    <tr><td class="bg"> 
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="60">Claim  No.</td>
                <td width="145"><input type="text" style="width:80;text-align: center;ime-mode: disabled" caption="Claim  No." name="cgo_clm_no" value="<%=cgoClmNo%>" maxlength="10" required fullfill class="input1">&nbsp;<input type="text" style="width:20;text-align: center;" name="clm_area_cd" readonly="readonly" class="input2"></td>
                <td width="45" title="Handling Office">HOFC</td>
                <td width="135"><input type="text" style="width:100;text-align: center;" name="hdlr_ofc_cd" readonly="readonly" class="input2"></td>
                <td width="65">Handler</td>
                <td width="130"><input type="text" style="width:80;text-align: center;"  name="hdlr_usr_id" readonly="readonly"  class="input2">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="54">DOU</td>
                <td width=""><input type="text" style="width:76;text-align: center;"  name="upd_dt" readonly="readonly"  class="input2"></td>
            </tr>
            </table> 
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2_3" name="btn1_VVD">VVD</td>
                    <td class="btn2_right"></td>
                    </tr>
                </table></td>
                <td width="145"><input type="text" style="width:80;text-align: center;" name="trnk_ref_vvd_no" readonly="readonly" class="input2"></td>
                <td width="45">Status</td>
                <td width="135"><input type="text" style="width:100;text-align: center;" name="cgo_clm_sts_nm" readonly="readonly" class="input2"></td>
                <td width="65"><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></td>
                <td width="130"><input type="text" style="width:40;text-align: center;" name="hpd" readonly="readonly" class="input2">&nbsp;&nbsp;/&nbsp;&nbsp;<input type="text" style="width:40;text-align: center;" name="nhp" readonly="readonly" class="input2"></td>
                <td width="54" title="Type Of Settlement">TOS</td>
                <td width="115"><input type="text" style="width:76;text-align: center;" name="cgo_clm_stl_tp_cd" readonly="readonly" class="input2"></td>
                <td width="40" title="Date Of Close">DOC</td>
                <td width=""><input type="text" style="width:100;text-align: center;" name="cs_clz_dt" readonly="readonly" class="input2"></td>
                </tr>
            </table> 
            
            
            <table class="line_bluedot"><tr><td></td></tr></table>
            
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="100" title="Type of Cargo Claim">TOC</td>
                <td width="70"><input type="text" style="width:40;text-align: center;" name="cgo_clm_tp_cd" readonly="readonly" class="input2"></td>
                <td width="44" title="Cause of Damage / Loss">CODL</td>
                <td width="65"><input type="text" style="width:40;text-align: center;" name="mjr_clm_dmg_lss_cd" readonly="readonly" class="input2"></td>
                <td width="110" title="No 3rd Liable Party">3rd Liable Party</td>
                <td width="70"><input type="text" style="width:35;text-align: center;" name="n3rd_labl_pty_cd" readonly="readonly" class="input2"></td>
                <td width="40" title="Place of Incident">POI</td>
                <td width="100"><input type="text" style="width:80;text-align: center;" name="inci_plc_tp_cd" readonly="readonly" class="input2"></td>
                <td width="35" title="Date of Incident">DOI</td>
                <td width="110"><input type="text" style="width:76;text-align: center;" name="inci_occr_dt" readonly="readonly" class="input2"></td>
                <td width="45">Cargo</td>
                <td width="190"><input type="text" style="width:100;" name="clm_cgo_tp_cd" readonly="readonly"  class="input2"></td>
                </tr></table> 
            
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="100">Claim Amount</td>
                <td width="285"><input type="text" style="width:110;text-align: right;" name="clmt_locl_amt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:40;text-align: center;" name="clmt_locl_curr_cd" readonly="readonly" class="input2"></td>
                <td width="65" title="Date of Formal Claim">DOF</td>
                <td width="130"><input type="text" style="width:80;text-align: center;" name="fmal_clm_rcv_dt" readonly="readonly" class="input2"></td>
                <td width="54">R.O.E</td>
                <td width="" class="stm"><input type="text" style="width:76;text-align: right;" name="clmt_locl_xch_rt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:146;text-align: right;" name="clmt_usd_amt" readonly="readonly" class="input2">&nbsp;USD</td>
                
            </tr>
            </table> 
            
        </td>
            </tr>
            </table> 
            
            <table class="height_8"><tr><td></td></tr></table>
        
        <table class="search" id="mainTable"> 
    <tr><td class="bg"> 
    
    <!-- Grid  (S) -->
    
    <!-- Grid  (E) -->
    
        <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="150">Insurer</td>
                <td width="558"><input type="text" style="width:130;text-align: center;" name="insur_clm_pty_abbr_nm" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:416;" name="insur_pty_nm" readonly="readonly" class="input2"></td>
                <td width=""><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2_3" name="btn1_FileUpload">File&nbsp;Upload</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                
                </tr>
            </table> 
        <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="150">Settled Amount</td>
                <td width="210"><input type="text" style="width:130;text-align: right;" name="cgo_clm_stl_locl_amt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:40;text-align: center;" name="cgo_clm_stl_locl_curr_cd" readonly="readonly" class="input2"></td>
                <td width="60" title="Date of Settlement">DOS</td>
                <td width="160"><input type="text" style="width:80;text-align: center;" name="cgo_clm_stl_dt" readonly="readonly" class="input2"></td>
                <td width="40">R.O.E</td>
                <td width="" class="stm"><input type="text" style="width:80;text-align: right;" name="cgo_clm_stl_xch_rt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:180;text-align: right;" name="cgo_clm_stl_usd_amt" readonly="readonly" class="input2">&nbsp;USD</td>
                </tr>
                <tr class="h23">
                <td width="">LP Recovered Amount</td>
                <td width=""><input type="text" style="width:130;text-align: right;" name="labl_pty_rcvr_locl_amt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:40;text-align: center;" name="labl_pty_rcvr_locl_curr_cd" readonly="readonly" class="input2"></td>
                <td width="" title="LP Date of Receipt">LP DOR</td>
                <td width=""><input type="text" style="width:80;text-align: center;" name="labl_pty_rcvr_dt" readonly="readonly" class="input2"></td>
                <td width="">R.O.E</td>
                <td width="" class="stm"><input type="text" style="width:80;text-align: right;" name="labl_pty_rcvr_locl_xch_rt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:180;text-align: right;" name="labl_pty_rcvr_usd_amt" readonly="readonly" class="input2">&nbsp;USD</td>
                </tr>
            </table> 
            
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="150">INS Claimed Amount</td>
                <td width="210"><input type="text" style="width:130;text-align: right;" name="insur_dmnd_amt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:40;text-align: center;" name="insur_dmnd_curr_cd" readonly="readonly" class="input2"></td>
                <td width="60" title="INS Date of Formal Claim">INS DOF</td>
                <td width="160"><input type="text" style="width:80;text-align: center;" name="insur_fmal_clm_dt" readonly="readonly" class="input2"></td>
                <td width="40">R.O.E</td>
                <td width="" class="stm"><input type="text" style="width:80;text-align: right;" name="insur_xch_rt" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:180;text-align: right;" name="insur_dmnd_usd_amt" readonly="readonly" class="input2">&nbsp;USD</td>
            </tr>
            <tr class="h23">
                <td width="150">Recoverable Amount</td>
                <td width="210"></td>
                <td width="60"></td>
                <td width="160"></td>
                <td width="40"></td>
                <td width="" class="stm" style="padding-left:84"><input type="text" style="width:180;text-align: right;" name="rcvr_usd_amt" readonly="readonly" class="input2">&nbsp;USD</td>
            </tr>
            <tr class="h23">
                <td width="">INS DOR Amount</td>
                <td width=""></td>
                <td width="" title="INS Date of Receipt">INS DOR</td>
                <td width="" colspan="2"><input type="text" style="width:80;text-align: center;ime-mode: disabled" name="insur_rcvr_dt" caption="INS DOR" dataformat="ymd" required maxlength="8" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="" class="stm" style="padding-left:84"><input type="text" style="width:180;text-align: right;ime-mode: disabled" name="insur_rcvr_usd_amt" class="input1" required dataformat="float" caption="INS DOR Amount" maxlength="13">&nbsp;USD</td>
                </tr>
            </table> 
            <table class="height_8"><tr><td></td></tr></table>
            <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Development</td></tr>
                </table>
            <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                
                <tr>
                    <td><textarea style="width:100%" rows="12" name="insur_rmk" maxlength="4000"></textarea></td>
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
                    <td class="btn1" name="btn1_Recovery_Cancel">Recovery&nbsp;Cancel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Case_Close">Case&nbsp;Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Recovery_Open">Recovery Open</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Payment">Payment</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
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
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>
</html>