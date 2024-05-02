<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3005.jsp
*@FileTitle : Tariff Fomula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3005Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	
	String[] srchTrfCd = null;		    //TARIFF CODE
	String[] ruleApplChgTpCd = null;	//TYPE
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgUsaSvcModCd = null;    	//US SVC MODE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] convRatUtCd = null;		//PER TYPE(in S/C)
	String[] convPrcCgoTpCd = null;		//CARGO TYPE(in S/C)
	String[] bkgRcvTermCd = null;		//RECEIVING TERM
	String[] bkgDeTermCd = null;		//DELIVERY TERM
	//String[] ruleCd = null;			//NOTE CONVERSION RULE CODE 
	//String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	
	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TRINoteConversionProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		//COMMBO LIST		
		srchTrfCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRCH_TRF_CD"));
		ruleApplChgTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgUsaSvcModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_USA_SVC_MOD_CD"), false);       
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
        convRatUtCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_RAT_UT_CD"), false);      
        convPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_CGO_TP_CD"), false);  
        bkgRcvTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RCV_TERM_CD"), false);  
        bkgDeTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DE_TERM_CD"), false);  
        //ruleCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        //chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Fomula Rule Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var srchTrfCdComboValue = "<%=srchTrfCd[0]%>";
    var srchTrfCdComboText = "<%=srchTrfCd[1]%>";
    
    var ruleApplChgTpCdComboValue = " |<%=ruleApplChgTpCd[0]%>";
    var ruleApplChgTpCdComboText = " |<%=ruleApplChgTpCd[1]%>";
 
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
    var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
        
    var rtOpCdComboValue = "<%=rtOpCd[0]%>";   
    var rtOpCdComboText = "<%=rtOpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgUsaSvcModCdComboValue = " |<%=bkgUsaSvcModCd[0]%>";   
    var bkgUsaSvcModCdComboText = " |<%=bkgUsaSvcModCd[1]%>";
    
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
       
    var convRatUtCdComboValue = " |<%=convRatUtCd[0]%>";   
    var convRatUtCdComboText = " |<%=convRatUtCd[1]%>";
 
    var convPrcCgoTpCdComboValue = " |<%=convPrcCgoTpCd[0]%>";
    var convPrcCgoTpCdComboText = " |<%=convPrcCgoTpCd[1]%>";

    var bkgRcvTermCdComboValue = " |<%=bkgRcvTermCd[0]%>";
    var bkgRcvTermCdComboText = " |<%=bkgRcvTermCd[1]%>";
    
    var bkgDeTermCdComboValue = " |<%=bkgDeTermCd[0]%>";
    var bkgDeTermCdComboText = " |<%=bkgDeTermCd[1]%>";
               
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">
<input type="hidden" name="tri_prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="note_conv_mapg_id">
<input type="hidden" name="cfm_flg">
<input type="hidden" name="cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;">
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirmcancel">Confirm Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td>
		</tr>
		</table>

    <!--Button (E) -->
	<table class="height_2"><tr><td colspan="8"></td></tr></table>
	<!--biz page (S)-->
	<table class="search">
       	<tr><td class="bg">
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Tariff Code</td>
					<td width="62"><script language="javascript">ComComboObject("srch_trf_cd", 2, 80, 0, 1, 0, false);</script></td>
					<td width="320" style="padding-bottom:1"><input type="text" name="srch_trf_nm" style="width:293;text-align:center;" class="input2" value=""></td>
					<td width="60">Duration</td>
					<td width="290"><script language="javascript">ComComboObject("note_seq", 3, 90, 0, 1, 2, true);</script>&nbsp;~&nbsp;<input name="eff_dt" 
					type="hidden" value="" class="input1" caption="Effective Date" required="true"><input name="eff_dt_hidden" type="hidden" value="" class="input1"><input type="text" name="exp_dt" 
					style="width:80;text-align:center;" class="" value="" caption="Expire Date" maxlength="10" dataformat="ymd" ><input type="hidden" name="exp_dt_hidden" style="width:80;text-align:center;">
					<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">Confirmation</td>
					<td width=""><input name="cfm_flg_nm" type="text" style="width:70;text-align:center;" class="input2" value="" readonly="true" caption="Confirmation"></td>
					
				</tr></table>								
	</td></tr></table>
				
	<table class="height_8"><tr><td></td></tr></table>
			
	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				<table width="100%" class="button">
	       					<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0"><tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr>
								</table></td><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_rowcopy">Row Copy</td>
								<td class="btn2_right"></td></tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_rowdelete">Delete</td>
								<td class="btn2_right"></td></tr>
								</table></td>
							</tr></table>
						</td></tr>
						</table>
				
				
			</td>	
			</tr></table>
    
    	<table class="height_10"><tr><td></td></tr></table>
		
</td></tr>
</table> 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>