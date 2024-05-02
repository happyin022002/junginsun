<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7001.jsp
*@FileTitle : IHC Tariff Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation
* 2013.02.04 전윤주 [CHM-201322884] confirm staff-team, Creation staff-team 보이도록 변경  
* 2013.03.04 전윤주 [CHM-201323352] confirm staff, Creation staff name이 보이도록 form 크기 수정
* 2013.04.17 전윤주 [CHM-201324375] Inland Tariff 기능 병합
                     (버튼 이름 동적으로 변경 confirm -> publish, Amend Type 추가)
* 2015.03.18 전지예 [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri7001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");

	String[] prcTrspModCd = null;
	String[] termCd = null;
	String[] srcInfoCd = null;
	String[] ihcTrfAmdtTpCd = null;		//Amend Type
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    
		event = (EsmPri7001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");	

		prcTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
		termCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
		srcInfoCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		ihcTrfAmdtTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("IHC_TRF_AMDT_TP_CD"));
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>   
<title>IHC Tariff Creation & Amendment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";

	var termCdValue = " |<%=termCd[0]%>";
	var termCdText = " |<%=termCd[1]%>";

	var srcInfoCdValue = " |<%=srcInfoCd[0]%>";
	var srcInfoCdText = " |<%=srcInfoCd[1]%>";

	var ihcTrfAmdtTpCdValue = "|<%=ihcTrfAmdtTpCd[0]%>";
	var ihcTrfAmdtTpCdText = "|<%=ihcTrfAmdtTpCd[1]%>";

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="prog_ofc_cd" value="<%=strUsr_ofc%>" >
<input type="hidden" name="fic_prop_sts_cd">
<input type="hidden" name="ihc_trf_no">
<input type="hidden" name="exp_dt">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="in_svc_scp_cd" value="<%= JSPUtil.getParameter(request, "in_svc_scp_cd") %>" >
<input type="hidden" name="in_cnt_cd" value="<%= JSPUtil.getParameter(request, "in_cnt_cd") %>" >
<input type="hidden" name="in_rhq_cd" value="<%= JSPUtil.getParameter(request, "in_rhq_cd") %>" >
<input type="hidden" name="in_org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "in_org_dest_tp_cd") %>" >
<input type="hidden" name="menu_rhq_cd" value="<%=StringUtil.xssFilter(request.getParameter("rhq_cd"))%>">
<input type="hidden" name="etc2">
<input type="hidden" name="etc1">
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_amend">Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm" id="btn_confirm_txt">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_spcl_cgo_trf" id="btn_spcl_cgo_trf">DG,overweight</td>
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
				<table class="Search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="60">In/Out</td>
					<td width="110"><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 90, 1, 1, 0, false);</script></td>	
					<td width="70">Country</td>
					<td width="111"><input type="text" style="width:70;text-align:center;" class="input1" dataformat="engup" name="cost_cnt_cd" maxlength="2" onfocus="this.oldvalue = this.value;"><img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_country"></td>
					<td width="110">Service Scope</td>
					<td width="80"><script language="javascript">ComComboObject('svc_scp_combo', 2, 60, 0, 1, 0, false);</script></td>																	
					<td width="80">Tariff No.</td>
					<td width="117"><input type="text" style="width:100;text-align:center;" class="input2" name="ihc_trf_no_view" readonly></td>
					<td width="75">AMD No.</td>
					<td width="50"><input type="text" style="width:40;text-align:center;" class="input2" dataformat="int" name="amdt_seq" readonly ></td>
					<td width="70">AMD Type</td>					
					<td width="40"><script language="javascript">ComComboObject("ihc_trf_amdt_tp_cd", 2, 40, 0, 0, 0, false);</script></td>
 				</tr>
 				</table>

				<table class="Search" border="0" style="width: 979;">  				
				<tr class="h23">
					<td width="100">Creation Date</td>
					<td width="175"><input type="text" style="width:155;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" readonly></td>
					<td width="">Effective Date</td>
					<td width="170"><input type="text" style="width:130;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="eff_dt" readonly><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_calendar"></td>
					<td width="165">Confirm(Publish) Date</td>
					<td width=""><input type="text" style="width:155;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cfm_dt" readonly></td>				
				</tr>

				<tr class="h23">
					<td width="">Confirm(Publish) Staff/Team</td>
					<td width=""><input type="text" style="width:155;text-align:center;" class="input2" name="cfm_usr" readonly></td>
					<td width="">Creation Staff/Team</td>
					<td width=""><input type="text" style="width:130;text-align:center;" class="input2" name="cre_usr" readonly></td>
					<td width="">Status</td>
					<td width=""><input type="text" style="width:155;text-align:center;" class="input2" name="fic_prop_sts_nm" readonly></td>					
				</tr>
				</table>
				<!--  biz_1   (E) --> 
				
				<div id="flagLayer1" style="display:none">   
				<table>
					<tr>
					    <td width="">RHQ_CD</td>
						<td width=""><script language="javascript">ComComboObject('rhq_cd', 1, 80, 1, 0, 0, false);</script></td>
					</tr>	
				</table>
				</div>					
				
				</td></tr>
			</table>
					
		<!--biz page (E)-->

		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
    	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
      		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) -->
	
		<!-- iFrame (S) -->
           <div id="tabLayer" style="display:none">
           <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="450" src="about:blank"></iframe>
           </div>
           <div id="tabLayer" style="display:none">
           <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="450" src="about:blank"></iframe>
           </div>
		<!-- iFrame (E) --> 
		
		<table class="height_8"><tr><td colspan="8"></td></tr></table>       	
	</td></tr>
</table>		
<div id="flagLayer1" style="display:none">  
	<table width="979"  id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td>
		</tr>
	</table>
</div> 
		
</form>
</body>
</html>