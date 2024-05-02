<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3514.jsp
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3514Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3514Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRqstOfcCd		= "";
	String trfPfxCd 		= "";
	String trfNo 			= "";
	String trfInlndSeq 		= "";
	String amdtSeq 			= "";
	
	String[] trfRuleStsCd = null;		    //Status
	String[] aproOfcCd = null;		    	//Approval Office
	String[] tariffCd = null;		    	//Tariff Code
	String[] trfInlndAmdtTCd = null;		//Amend Type
	String[] inlndRtTermCd = null;		  	//Term
	String[] prcRrspModCd = null;		  	//Trans. Mode
	String[] inlndRtLmtWgtUtCd = null;		//Weght Unit
	String[] prcCgoTpCd = null;		    	//Type
	String[] srcInfoCd = null;		    	//Source
	String[] currCd = null;		    		//Currency
		
	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.InlandRates");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRqstOfcCd = account.getOfc_cd();


		event = (EsmPri3514Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST	
		trfRuleStsCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_STS_CD"), false);
		aproOfcCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"));
		tariffCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
	
		trfInlndAmdtTCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_INLND_AMDT_TP_CD"));
		inlndRtTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_TERM_CD"), false);
		prcRrspModCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_INLND_RT_TRSP_MOD_CD"), false);
		inlndRtLmtWgtUtCd	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_LMT_WGT_UT_CD"));
		prcCgoTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"), false);
		srcInfoCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
		        
		trfPfxCd 		= JSPUtil.getNull(request.getParameter("trfPfxCd"));
		trfNo 			= JSPUtil.getNull(request.getParameter("trfNo"));
		trfInlndSeq		= JSPUtil.getNull(request.getParameter("trfInlndSeq"));
		amdtSeq			= JSPUtil.getNull(request.getParameter("amdtSeq"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inland Rates Creation &amp; Amendment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var trfRuleStsCdComboValue = "|<%=trfRuleStsCd[0]%>";
	var trfRuleStsCdComboText = "|<%=trfRuleStsCd[1]%>";
	
	var aproOfcCdComboValue = "<%=aproOfcCd[0]%>";
	var aproOfcCdComboText = "<%=aproOfcCd[1]%>";
	
	var tariffCdComboValue = "<%=tariffCd[0]%>";
	var tariffCdComboText = "<%=tariffCd[1]%>";

	var trfInlndAmdtTCdComboValue = "|<%=trfInlndAmdtTCd[0]%>";
	var trfInlndAmdtTCdComboText = "|<%=trfInlndAmdtTCd[1]%>";

	var inlndRtTermCdComboValue = " |<%=inlndRtTermCd[0]%>";
	var inlndRtTermCdComboText = " |<%=inlndRtTermCd[1]%>";

	var prcRrspModCdComboValue = " |<%=prcRrspModCd[0]%>";
	var prcRrspModCdComboText = " |<%=prcRrspModCd[1]%>";

	var inlndRtLmtWgtUtCdComboValue = " |<%=inlndRtLmtWgtUtCd[0]%>";
	var inlndRtLmtWgtUtCdComboText = " |<%=inlndRtLmtWgtUtCd[1]%>";

	var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";

	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
	var srcInfoCdComboText = "<%=srcInfoCd[1]%>";

	var currCdComboValue = " |<%=currCd[0]%>";
	var currCdComboText = " |<%=currCd[1]%>";
	
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
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">
<input type="hidden" name="trf_inlnd_seq" value="<%=trfInlndSeq%>">
<input type="hidden" name="ofc_cd" value="<%=strRqstOfcCd%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<!-- 개발자 작업	-->
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
					<td class="btn1" name="btn_amend">Amend</td>
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
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_approve">Approve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_publish">Publish</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadexcel">Load Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet1');</script> 
		<!-- Hidden sheet for Transaction (E) -->
		<table class="search"> 
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
				
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="120">Tariff Code</td>
				<td width="130" style="padding-left:2;"><script language="javascript">ComComboObject("tariff_cd", 2, 110, 0, 1, 0, false);</script></td>
				<td width="85">Tariff Name</td>
				<td width=""><input type="text" name="trf_nm" style="width:640;" class="input2" value="" readonly></td>
				</tr>	
			</table>
				
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="120">Inland Rates Name</td>
				<td width="425" style="padding-left:2;"><script language="javascript">ComComboObject("inlnd_cd", 1, 400, 0, 1, 0, true);</script></td>
				<td width="80">Amend Type</td>
				<td width="65" style="padding-left:2;"><script language="javascript">ComComboObject("trf_inlnd_amdt_tp_cd", 2, 50, 0, 0, 0, false);</script></td>
				<td width="70">Amend No.</td>
				<td width="78"><input type="text" name="amdt_seq" maxlength="20" style="width:60;text-align:center;" class="input2" value="" readonly></td>
				<td width="45">Status</td>
				<td width=""><input type="text" name="trf_inlnd_sts_nm" style="width:90;text-align:center;" class="input2" value="" readonly></td>				
				</tr>	
			</table>
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<table class="search" border="0">
			       <tr><td class="title_h"></td>
				   <td class="title_s">Publishing Information </td></tr>
			</table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="95">Creation Date</td>
				<td width="110"><input type="text" name="cre_dt" maxlength="10" dataformat="ymd" style="width:100; text-align:center;" class="input2" readonly></td>
				<td width="90">Effective Date</td>
				<td width="140"><input type="text" name="eff_dt" maxlength="10" dataformat="ymd" style="width:100; text-align:center;" class="input1" value="" required caption="Effective Date">
				<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor"></td>
				<td width="100">Expiration Date</td>
				<td width="140"><input type="text" name="exp_dt" maxlength="10" dataformat="ymd" style="width:100; text-align:center;" class="input" value="">
				<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td>
				<td width="85">Publish Date</td>
				<td width=""><input type="text" name="pub_dt" maxlength="10" dataformat="ymd" style="width:130; text-align:center;" class="input2" value="" readonly></td>
			</tr>	
			<tr class="h23">
				<td width="">Request Office</td>
				<td width=""><input type="text" name="rqst_ofc_cd" style="width:100; text-align:center;" class="input2" value="" readonly></td>
				<td width="">Creation Staff</td>
				<td width=""><input type="text" name="cre_usr_id" style="width:100; text-align:center;" class="input2" value="" readonly></td>
				<td width="">Approval Office</td>
				<td width="" style="padding-left:2;"><script language="javascript">ComComboObject('apro_ofc_cd', 2, 100, 0, 1);</script></td>
				<td width="">Attached File</td>
				<td width="">
					<table width="100%" border="0"> 
					<tr>
						<td width="160" style="padding-left:2;padding-top:2;">
						<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
						<td width="">
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg" style="padding-top:1;">
							<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="display:none;" id="btn_fileadd">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_fileadd">Add</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="display:none;" id="btn_filedelete">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_filedelete">Del.</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
							</table>
						</td></tr>
						</table>
						</td>
					</tr>
					</table>
				
				
				</td>				
			</tr>
			
			</table>
						
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;">
		       <tr><td class="title_h"></td>
			   <td width="400" class="title_s">Location Information (by Inland Name)</td>
			   
			   <td>
				   <table class="search" border="0"> 
					<tr class="h23">
						<td width="200"><input type="checkbox" name="search_view_yn" value="Y" class="trans">View Amend Delete</td>
						</tr>	
					</table>
			   </td>			   
			   
			   <td>
				   <table class="search" border="0"> 
					<tr class="h23">
						<td width="100">Search Location</td>
						<td width="190"><input type="text" name="search_row" maxlength="50" style="width:190;" class="input"  dataformat="" value="" ></td>
						</tr>	
					</table>
			   </td>
			   <td>
			   	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
			       	<tr><td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    <tr>		
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_rowsearch">Search</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
						</table>
					</td></tr>
					</table>					
				</td>
			   </tr>
		    </table>
		    
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td>			  	
			  	<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<!--
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="display:none;" id="btn_check">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_check">Check</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowdelete">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowamend">Amend</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_amendcancel">Amend Cancel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				</td>
				</tr>	
			</table>
			<!--  biz_2  (E) -->
			</td></tr>
		</table>
	<!--biz page (E)-->
	</td></tr>
</table>
		
<table class="height_10"><tr><td colspan="8"></td></tr></table>

<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>


<div style="disply:block;">
<table>
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet4');</script>
		</td>
	</tr>
</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>