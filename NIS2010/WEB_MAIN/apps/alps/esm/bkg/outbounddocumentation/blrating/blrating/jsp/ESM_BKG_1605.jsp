<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1605.jsp
*@FileTitle : Group & Multi B/L Rating
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1605Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1605Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    //String blNo = "";
    
    String[] svcScpCds = null;
    String[] contractTypes = null;  
    String[] chargeFlgs = null;
    
    Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg1605Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // Contract Type => 0256 참조
//        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");       
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Audit by CNTR Qty Discrepancy</title>
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

<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">

	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td>
							<table class="search" border="0" style="width:970;"> 
							<tr class="h23">
								<td width="65">
									<input type="radio" name="search_type" value="VVD" class="trans" checked>T/VVD&nbsp;
								</td>
								<td width="">
									<input type="text" class="input1" style="width:75;text-align:center;ime-mode:disabled" name="t_vvd" dataformat=uppernum caption="T/VVD" maxlength="9">
									<img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_vvd">
								</td>
								<td width="45" ><input type="radio" name="search_type" value="ETD" class="trans">ETD</td>
								<td width="45"><input type="radio" name="search_type" value="CRD" class="trans">CRD</td>
								<td width="">
								    <input type="text" style="width:70;text-align:center;" class="input1" value="" caption="From Date" name="fm_dt" dataformat="ymd" maxLength="10" minlength="8">
								    <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
								    ~
								    <input type="text" style="width:70;text-align:center;" class="input1" value="" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10" minlength="8">
								    <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="" align="center">Rating</td>
								<td width=""><script language="javascript"> ComComboObject('rat_flg', 1, 45, 0, 0, 0, false);</script></td>
								<td width="" align="center">Result</td>
								<td width=""><script language="javascript"> ComComboObject('grp_rat_rslt_cd', 1, 45, 0, 0, 0, false);</script></td>
								<td width="" align="center">SC Note</td>
								<td width=""><script language="javascript"> ComComboObject('sc_note', 1, 45, 0, 0, 0, false);</script></td>
								<td width="" align="center">Self CHK</td>
								<td width=""><script language="javascript"> ComComboObject('grp_rat_chk_flg', 1, 45, 0, 0, 0, false);</script></td>
								<td width="" align="center">CNTR CFM</td>
								<td width=""><script language="javascript"> ComComboObject('cntr_cfm_sts_cd', 1, 45, 0, 0, 0, false);</script></td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="170">
						<input type="radio" name="bkg_ctrt_tp_cd" class="trans" value="S" checked>&nbsp;S/C&nbsp
						<input type="radio" name="bkg_ctrt_tp_cd" value="R" class="trans">&nbsp;RFA&nbsp;
						<input type="radio" name="bkg_ctrt_tp_cd" value="T" class="trans">&nbsp;TAA</td>
						<td width="110"><input type="text" name="ctrt_no" style="width:90;" maxlength="12" dataformat="uppernum" value="" class="input"></td>
						
						<td width="65">Customer</td>
						<td width="">
							<select style="width:70;" class="input" name="bkg_cust_tp_cd">
							<option value="" ></option>
							<option value="S">Shipper</option>
							<option value="F">Forwarder</option>
							<option value="C">Consignee</option>
							</select>
							<input type="text" style="width:25;text-align:center;ime-mode:disabled;" class="input" name="cust_cnt_cd" dataformat="engup" maxlength="2">
							<input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" name="cust_seq" dataformat="uppernum" maxlength="6">
						</td>
						<!-- <td width="95"><nobr>Contract Type</nobr></td>
						<td width="65"><script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script></td>
						<td width="80"><nobr>Contract No.</nobr></td>
						<td width="113"><input input type="text" class="input" value="" style="width:105;text-align:center;ime-mode:disabled" name="ctrt_no" dataformat=uppernum caption="Contract No" maxlength="12"></td> -->
						<td width="40" align="center"><nobr>POR</nobr></td>
						<td width="75"><input  type="text" class="input" value="" style="width:65;text-align:center;ime-mode:disabled" name="por_cd" dataformat=engup caption="POR" maxlength="5"></td>
						<td width="40" align="center"><nobr>POL</nobr></td>
						<td width="75"><input  type="text" class="input" value="" style="width:65;text-align:center;ime-mode:disabled" name="pol_cd" dataformat=engup caption="POL" maxlength="5"></td>
						<td width="40" align="center"><nobr>POD</nobr></td>
						<td width="75"><input  type="text" class="input" value="" style="width:65;text-align:center;ime-mode:disabled" name="pod_cd" dataformat=engup caption="POD" maxlength="5"></td>
						<td width="40" align="center"><nobr>DEL</nobr></td>
						<td width="75"><input  type="text" class="input" value="" style="width:65;text-align:center;ime-mode:disabled" name="del_cd" dataformat=engup caption="DEL" maxlength="5"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70" align="center">BKG OFC</td>
						<td width="65"><input type="text" class="input" value="" style="width:55;text-align:center;ime-mode:disabled" name="bkg_ofc_cd" dataformat="engup" caption="BKG Office" maxlength="6"></td>
						<td width="60" align="center">BKG STF</td>
						<td width="74"><input type="text" class="input" value="" style="width:65;text-align:center;ime-mode:disabled" name="doc_usr_id"  caption="BKG Staff" maxlength="20"></td>
						<td width="50" align="center">C.OFC</td>
						<td width="70"><input type="text" class="input" value="" style="width:60;text-align:center;ime-mode:disabled" name="ctrt_ofc_cd" dataformat=engup caption="Contract Office" maxlength="6"></td>
						<td width="40"class="sm">Sub<input type="checkbox" class="trans" name="ctrt_ofc_cd_sub" value="N" onClick="javascript:changeCtrtOfcCdSub(this)"></td>
						<td width="50" align="center">C.REP</td>
						<td width="65"><input type="text" class="input" value="" style="width:55;text-align:center;ime-mode:disabled" name="ctrt_srep_cd" dataformat="uppernum" caption="Contract Rep" maxlength="5"></td>
						<td width="50" align="center">L.OFC</td>
						<td width="70"><input type="text" class="input" value="" style="width:60;text-align:center;ime-mode:disabled" name="ob_sls_ofc_cd" dataformat=engup caption="Loading Office" maxlength="6"></td>
						<td width="40" class="sm">Sub<input type="checkbox" class="trans" name="ob_sls_ofc_cd_sub" value="N" onClick="javascript:changeObSlsOfcCdSub(this)"></td>
						<td width="50" align="center">L.REP</td>
						<td width="65"><input type="text" class="input" value="" style="width:55;text-align:center;ime-mode:disabled" name="ob_srep_cd" dataformat="uppernum" caption="Loading Rep" maxlength="5"></td>
						<td width="60" align="center">BKG No.</td>
						<td width="100"><input type="text" class="input" value="" style="width:90;text-align:center;ime-mode:disabled" name="bkg_no" dataformat="uppernum"  caption="BKG Number" maxlength="14"></td>
						
					</tr>
				</table>
	</td>
	</tr>
	</table>
							
				<!--  biz_1   (E) -->	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
	<!-- Grid BG Box  (S) -->
    	<table class="search" id="mainTable"> 
      	<tr><td class="bg">
      	<!--  Button_Sub (S) -->
		
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
		
	     ※ Please update surcharge adjustment in charge screen if there is any exception.<br>
                   ※ Please make sure all things have been completely checked by ticking Self Check. Otherwise, B/L release would be blocked. 

		</td></tr>
	</table>
	<!-- Grid BG Box  (E) -->
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
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
			
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_autorating">Auto-rating</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
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

	
	
	
</form>
</body>
</html>
