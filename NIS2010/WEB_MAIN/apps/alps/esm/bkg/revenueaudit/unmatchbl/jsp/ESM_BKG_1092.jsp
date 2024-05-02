<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1092.jsp
*@FileTitle : Audit by Commodity And Route
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.29 류선우
* 1.0 Creation
=========================================================
History
2011.01.14 이정수 [CHM-201007610] RAS 기능 보완 및 Logic 보완 6
=========================================================	
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1092Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1092Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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
    
    String[] rhqs = null;
    String[] gsos = null;
    String[] offices = null;
    String[] contractTypes = null;
    String[] cargoTypes = null;
    String[] usaSvcModCds = null;
    String[] svcScpCds = null;
    String[] rTerms = null;
    String[] dTerms = null;

    String[] bkgStatuCds = null;
    String[] splitFlgs = null;
    String[] chargeFlgs = null;
    String[] ratingTypes = null;

    String[] ratUtCds = null;

    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        event = (EsmBkg1092Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // RHQ
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // GSO
        gsos = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("gso"));
        // Office
        offices = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("office"));
        if(null == offices){
            offices = new String[] {"", ""};
        }
        // Contract Type
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
        // cargo type term Combo Data 생성
        cargoTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoType"), true , "|", "\t", "getCode", "getName");
		// USA Service Mode Code
		usaSvcModCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usaSvcModCd"), false , "|", "\t", "getCode", "getName");
        
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // r term Combo Data 생성
        rTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rTerm"), false , "|", "\t", "getCode", "getName");
        // d term Combo Data 생성
        dTerms = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dTerm"), false , "|", "\t", "getCode", "getName");

        // BKG Status Combo Data 생성
        bkgStatuCds = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("bkgStatuCd"), true , "|", "\t", "getCode", "getName");
        // Split Status Combo Data 생성
        splitFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("splitFlg"), true , "|", "\t", "getCode", "getName");
        // Charge Status Combo Data 생성
        chargeFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chargeFlg"), true , "|", "\t", "getCode", "getName");
        // Rating Type 
        ratingTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ratingType"), false , "|", "\t", "getCode", "getName");

		// Rating Unit
		ratUtCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"));
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Audit by Commodity And Route</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var gsoComboValue = "|<%=gsos[0]%>";

    var officeComboValue = "|<%=offices[0]%>";
    
    if(officeComboValue == "|"){
        officeComboValue = "";
    }
    
    var contractTypeComboValue = "<%=contractTypes[0]%>";
    var contractTypeComboText = "<%=contractTypes[1]%>";

    var cargoTypeComboValue = "|<%=cargoTypes[0]%>";
    var cargoTypeComboText = "|<%=cargoTypes[1]%>";

    var usaSvcModCdComboValue = "|<%=usaSvcModCds[0]%>";
    var usaSvcModCdComboText = "|<%=usaSvcModCds[1]%>";
    
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";

    var ratingTypeComboValue = "|<%=ratingTypes[0]%>";
    var ratingTypeComboText = "|<%=ratingTypes[1]%>";
    
    var rTermComboValue = "|<%=rTerms[0]%>";
    var rTermComboText = "|<%=rTerms[1]%>";

    var dTermComboValue = "|<%=dTerms[0]%>";
    var dTermComboText = "|<%=dTerms[1]%>";

    
    var bkgStatuCdComboValue = "|<%=bkgStatuCds[0]%>";
    var bkgStatuCdComboText = "|<%=bkgStatuCds[1]%>";

    var chargeFlgComboValue = "|<%=chargeFlgs[0]%>";
    var chargeFlgComboText = "|<%=chargeFlgs[1]%>";

    var splitFlgComboValue = "|<%=splitFlgs[0]%>";
    var splitFlgComboText = "|<%=splitFlgs[1]%>";

    var ratUtCdComboValue = "<%=ratUtCds[0]%>";
    var ratUtCdComboText = "<%=ratUtCds[1]%>";
 
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        }
        loadPage();
    }
</script>
</head>
<link href="/css/nis2010_menu.css" rel="stylesheet" type="text/css">
<link href="/css/nis2010_contents.css" rel="stylesheet" type="text/css">


<script language="javascript" src="/js/CoCommon.js"></script>
<script language="javascript" src="/js/CoCalendar.js"></script>
<script language="javascript" src="/js/CoObject.js"></script>
<script language="javascript" src="/js/IBSheetInfo.js"></script>
<script language="javascript" src="../script/UI_BKG_1092.js"></script>


<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="search_date" value="ETD">
<input type="hidden" name="charge_type" value="RATED">
<input type="hidden" name="charge_condition" value="AND">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">RHQ</td>
					<td width="90"><script language="javascript">ComComboObject('bkg_rhq_cd', 1, 75, 0, 1, 0, false);</script></td>
					<td width="40">GSO</td>
					<td width="90"><script language="javascript">ComComboObject('bkg_gso_cd', 1, 75, 0, 0, 0, false);</script></td>
					<td width="50">Office</td>
					<td width="90"><script language="javascript">ComComboObject('bkg_ofc_cd', 1, 75, 0, 0, 0, false);</script></td>
					<td width="435">
						<table class="search_sm2" border="0" style="420"> 
							<tr class="h23">
								<td width="32">&nbsp;&nbsp;Date</td>
								<td width="160" class="stm"><input type="radio" value="BKG" class="trans" name="r_date">BKG&nbsp;&nbsp;&nbsp;<input type="radio" value="APPL" class="trans" name="r_date">Appl.&nbsp;&nbsp;&nbsp;<input type="radio" value="ETD" class="trans" name="r_date" checked>ETD</td>
								<td width=""><input type="text" style="width:72;text-align:center;" class="input1" name="from_dt" caption="From Date" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:72;text-align:center;" class="input1" name="to_dt" caption="To Date" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							</tr>
						</table>
					
					</td>
					
					<td width="50">B/L No.</td>
					<td width=""><input type="text" style="width:90;text-align:center;ime-mode:disabled" class="input" name="bl_no" caption="B/L No" dataformat=uppernum maxlength="12"></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Contract </td>
					<td width="76"><script language="javascript">ComComboObject('bkg_ctrt_tp_cd', 1, 70, 0, 1, 0, false);</script></td>
					<td width="127"><input type="text" style="width:83;text-align:center;ime-mode:disabled" class="input1" name="ctrt_no" caption="Contract No." dataformat="uppernum" maxLength="11">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="ctrt_popup"></td>
					
					<td width="50">T/VVD</td>
					<td width="136"><input type="text" style="width:90;text-align:center;ime-mode:disabled" class="input" name="vvd" caption="T/VVD" dataformat=uppernum maxlength="9"> <img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="vvd_popup"></td>
					<td width="84">Commodity</td>
					<td width="110"><input type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1" name="cmdt_cd" dataformat="uppernum" maxLength="6">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="cmdt_popup"></td>
					<td width="74">Cargo Type</td>
					<td width="85"><script language="javascript">ComComboObject('cargo_type', 2, 70, 0, 0, 0, false);</script></td>
					<td width="108">USA SVC Mode</td>
					<td width="80"><script language="javascript">ComComboObject('usa_svc_mod_cd', 1, 70, 0, 0, 0, false);</script></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Scope</td>
					<td width="60"><script language="javascript">ComComboObject('svc_scp_cd', 2, 55, 0, 0, 0, false);</script></td>
					<td width="28">POR</td>
					<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="por_cd" dataformat="engupnum" maxlength="5"></td>
					<td width="25">POL</td>
					<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="pol_cd" dataformat="engupnum" maxlength="5"></td>
					<td width="25">POD</td>
					<td width="66"><input type="text" style="width:52;text-align:center;ime-mode:disabled;" class="input" name="pod_cd" dataformat="engupnum" maxlength="5"></td>
					<td width="25">DEL</td>
					<td width="66"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" name="del_cd" dataformat="engupnum" maxlength="5"></td>
					<td width="62">R/D Term</td>
                    <td width="65"><script language="javascript">ComComboObject('rcv_term_cd', 1, 60, 0, 0, 0, false);</script></td>      
                    <td width="75"><script language="javascript">ComComboObject('de_term_cd', 1, 60, 0, 0, 0, false);</script></td> 
					<td width="58">Customer</td>
					<td width="">
							<select style="width:70;" class="input1" name="bkg_cust_tp_cd">
							<option value="S" >Shipper</option>
							<option value="C">Consignee</option>
							<option value="N">Notify</option>
							</select>
							<input type="text" style="width:25;text-align:center;ime-mode:disabled;" class="input" name="cust_cnt_cd" dataformat="engup" maxlength="2">
							<input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" name="cust_seq" dataformat="uppernum" maxlength="6">
							<input type="text" style="width:88;text-align:left;ime-mode:disabled;" class="input" name="cust_nm" dataformat="uppernum" maxlength="20"></td>
				
				</tr>	
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">BDR Status</td>
					<td width="96"><script language="javascript">ComComboObject('bdr_flg', 1, 62, 0, 0, 0, false);</script></td>
					<td width="71">BKG Status</td>
					<td width="117"><script language="javascript">ComComboObject('bkg_sts_cd', 2, 82, 0, 0, 0, false);</script></td>
					<td width="73">Split Status</td>
					<td width="120"><script language="javascript">ComComboObject('split_flg', 2, 82, 0, 0, 0, false);</script></td>  
					<td width="88">Charge Status</td>
                    <td width="120"><script language="javascript">ComComboObject('charge_flg', 2, 82, 0, 0, 0, false);</script></td>
					<td width="78">Rating Type</td>
					<td width=""><script language="javascript"> ComComboObject('auto_rat_flg', 1, 130, 0, 0, 0, false);</script></td>
				</tr>	
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Charge</td>
					
					<td class="stm" width="80">
						<table>						
                      	<tr><td><font size='2'>
                      	<input type="radio" class="trans" name="chg_tp" value="RATED" checked>Rated 
                      	</font></td></tr>
                       	<tr><td><font size='2'>
                       	<input type="radio" class="trans" name="chg_tp" value="NOTRATED">Not Rated 
                       	</font></td></tr>                       
                       	</table>
                    </td>
                    <td width="190">
                    <table class="search_sm2" border="0" style="width:180;"> 
                        <tr class="h23">
					<td width="65"><script language="javascript">ComComboObject('chg_cd', 2, 60, 0, 0, 0, false);</script></td>
					
					<td class="stm" width="50">
						<table>						
                      	<tr><td><font size='2'>
                      	<input type="radio" class="trans" name="chg_cond" value="AND" checked>And
                      	</font></td></tr>
                      	<tr><td><font size='2'>
                       	<input type="radio" class="trans" name="chg_cond" value="OR">Or
                       	</font></td></tr>                       
                       	</table>
                    </td>
					<td width="65"><script language="javascript">ComComboObject('chg_cd1', 2, 60, 0, 0, 0, false);</script></td>
                    </tr>
                    </table>
                    </td>
					<td width="60">Currency</td>
					<td width="75"><input type="text" style="width:60;text-align:center;ime-mode:disabled;" class="input" name="curr_cd" dataformat="engup" maxlength="3"></td>
					<td width="60">Per Type</td>
					<td width="65"><script language="javascript"> ComComboObject('rat_ut_cd', 1, 60, 0, 0, 0, false);</script></td>
					<td>	
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="60">&nbsp;&nbsp;Bill Type</td>
                                <td width="" class="stm"><input type="checkbox" class="trans" name="bill_type_all"  value="ALL" checked>ALL&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_n" value="N" checked>Normal&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_m" value="M" checked>Master&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_c" value="C" checked>Covered&nbsp;&nbsp;<input type="checkbox" class="trans" name="bill_type_b" value="B" checked>Co-Biz</td>
								</tr>
						</table>
					</td>	
				
				</tr>	
				</table>
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable"> 
       	<tr><td class="bg">
       	<!--  Button_Sub (S) -->
			<table width="100%"> 
	       	<tr><td class="btn2_bg" align="right">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
						<tr class="h23"><td>B/L Count&nbsp;&nbsp;</td></tr>
						</table></td>
						<td><input type="text" style="width:60;text-align:right" class="input" value="" name="bl_cnt" readonly></td>
									                            <td width="30" align="right" valign="bottom" style="padding-right:2;">
									        <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
											<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
											</div>
											<div id="div_zoom_out" style="display:none">
											<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
											</div>
										</td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
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
	<!-- Grid BG Box  (E) -->
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	<!--biz page (E)-->
	
	</td></tr>
		</table>

<div style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
</div>

</form>
</body>
</html>
