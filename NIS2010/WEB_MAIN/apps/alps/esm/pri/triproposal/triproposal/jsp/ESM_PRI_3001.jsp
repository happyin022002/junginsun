<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3001.jsp
*@FileTitle : TRI Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.11.13 박성수
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event.EsmPri3001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strSRepCd = "";
	String strOfcCd = "";
	String strRhqOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TRIProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strSRepCd = account.getSrep_cd();
		strOfcCd = account.getOfc_cd();
		strRhqOfcCd = account.getRhq_ofc_cd();

		event = (EsmPri3001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRI Creation & Amendment</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="srch_trf_pfx_cd">
<input type="hidden" name="srch_trf_no">
<input type="hidden" name="ibflag">
<input type="hidden" name="trf_pfx_cd">
<input type="hidden" name="trf_no">
<input type="hidden" name="prop_sts_cd">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="is_req_usr">
<input type="hidden" name="is_apro_usr">
<input type="hidden" name="srep_cd" value="<%=strSRepCd%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="ofc_cd" value="<%=strOfcCd%>">
<input type="hidden" name="rhq_ofc_cd" value="<%=strRhqOfcCd%>">
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve_s">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new_s">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_grical_s">GRI Cal.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_request_s">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_rcancel_s">R.Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_approve_s">Approve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_acancel_s">A.Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_publish_s">Publish</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<!-- 			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send_s">Send to Descartes</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
-->				
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel_s">Down Excel</td>
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
					<td width="70">Tariff Code</td>
					<td width="433" style="padding-left:2px;"><script language="javascript">ComComboObject("srch_trf_cd", 2, 90, 0, 1, 0, false);</script>
					&nbsp;<input name="srch_trf_nm" type="text" style="width:321;" class="input2" value="" readonly caption="Tariff Code"></td>
					<td width="136">Proposal No.</td>
					<td width="133"><input name="srch_tri_prop_no" type="text" style="width:110;text-align:center;" class="input" value="" dataformat="engup" maxlength="9" fullfill caption="Proposal No."></td>	
					<!-- input name="srch_cmdt_nm" type="text" style="width:222;" class="input2" value="" readonly></td -->
					<td width="91">Access Date</td>
					<td width=""><input type="text" name="srch_acc_dt" style="width:80;text-align:center;" class="input" caption="Access Date" maxlength="10" dataformat="ymd">&nbsp;<img name="srch_btn_acc_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">Origin</td>
					<td width="65"><input name="srch_org_rout_pnt_loc_nm" type="text" style="width:50;text-align:center;" class="input" value="" dataformat="uppernum" maxlength="5" fullfill caption="Origin"></td>
					<td width="58">Origin Via</td>
					<td width="64"><input name="srch_org_rout_via_port_nm" type="text" style="width:50;text-align:center;" class="input" value="" dataformat="uppernum" maxlength="5" fullfill caption="Origin Via."></td>
					<td width="54">Dest. Via</td>
					<td width="64"><input name="srch_dest_rout_via_port_nm" type="text" style="width:50;text-align:center;" class="input" value="" dataformat="uppernum" maxlength="5" fullfill caption="Dest Via."></td>
					<td width="70">Destination</td>
					<td width="65"><input name="srch_dest_rout_pnt_loc_nm" type="text" style="width:50;text-align:center;" class="input" value="" dataformat="uppernum" maxlength="5" fullfill caption="Destination"></td>
					<td width="130">Tariff Rate Item(TRI)</td>
					<td width="126"><input name="srch_tri_no" type="text" style="width:110;text-align:center;" class="input" value="" dataformat="eng" maxlength="15" caption="Tariff Rate Item"></td>
					<td width="105">Commodity Code</td>
					<td width="89"><input name="srch_cmdt_cd" type="text" style="width:60;text-align:center;" class="input" value="" dataformat="int" maxlength="6" fullfill caption="Commodity Code">&nbsp;<img name="srch_btn_srch_cmdt" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;</td>
					
					
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Approval Office</td>
					<td width="76"><script language="javascript">ComComboObject('srch_tri_apro_ofc_cd', 2, 67, 0, 0);</script></td>
					<td width="95">Request Office</td>
					<td width="70"><input name="srch_tri_rqst_ofc_cd" type="text" style="width:60;text-align:center;" class="input" value="" dataformat="engup" maxlength="5" fullfill caption="Approval Office"></td>
					<td width="48">Status</td>
					<td width="110"><script language="javascript">ComComboObject('srch_prop_sts_cd', 1, 75, 1, 0);</script></td>
					
					<td width="155"><input name="srch_is_gri_appl" value="Y" type="checkbox" class="trans">GRI Cal. Applying list</td>
					<td width="110"><input type="text" name="srch_gri_eff_dt" style="width:80;text-align:center;" class="input" caption="GRI Effective Date" maxlength="10" dataformat="ymd">&nbsp;<img name="srch_btn_grieffdt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td align="right"><table width="145" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_conversion">Tariff Formula Rule</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					
				</tr></table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				
				
			</td>	
			</tr></table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search">
       			<tr><td class="bg">
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">TRI No.</td>
					<td width="150"><input name="tri_no" type="text" style="width:130;text-align:center;" class="input2" value="" maxlength="15" caption="TRI No." required readonly></td>
					<td width="80">Proposal No.</td>
					<td width="110"><input name="tri_prop_no" type="text" style="width:80;text-align:center;" class="input2" value="" maxlength="9" fullfill required caption="Proposal No." readonly></td>
					<td width="70">Commodity</td>
					<td width="250">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						<td><input name="cmdt_cd" type="text" style="width:70;text-align:center;" class="input1" value="" dataformat="int" maxlength="6" fullfill required caption="Commodity">&nbsp;</td>
						<td><table border="0" cellpadding="0" cellspacing="0"><tr><td style="border: #E8EFF9 0px solid;"><img name="btn_srch_cmdt" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr></table></td>
						<td>&nbsp;<input name="cmdt_nm" type="text" style="width:222;" class="input2" value="" readonly>
						</td>
						</tr>
						</table>
					</td>
					<td align="right"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_taalist">Related TAA List</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr></table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Route</td></tr>
				</table>
				
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td width="25%">
						<table class="search" border="0" width="100%" style="border: #E8EFF9 1px solid;"> 
							<tr><td  align="center" style="border: #E8EFF9 0px solid;"><b>Origin</b></td>
							<td width="20" align="right" style="border: #E8EFF9 0px solid;"><table border="0" cellpadding="0" cellspacing="0"><tr><td style="border: #E8EFF9 0px solid;"><img src="img/btns_search.gif" name="btn_srch_org_pnt" width="19" height="20" alt="" border="0" align="right" class="cursor"></td></tr></table></td>
							</tr>
						</table>
					</td>
					<td width="25%">
						<table class="search" border="0" width="100%"> 
							<tr><td  align="center" style="border: #E8EFF9 1px solid;"><b>Origin Via</b></td>
							<td width="20" align="right" style="border: #E8EFF9 0px solid;"><table border="0" cellpadding="0" cellspacing="0"><tr><td style="border: #E8EFF9 0px solid;"><img src="img/btns_search.gif" name="btn_srch_org_via" width="19" height="20" alt="" border="0" align="right" class="cursor"></td></tr></table></td>
							</tr>
						</table>
					</td>
					<td width="25%">
						<table class="search" border="0" width="100%"> 
							<tr><td  align="center" style="border: #E8EFF9 1px solid;"><b>Destination Via</b></td>
							<td width="20" align="right" style="border: #E8EFF9 0px solid;"><table border="0" cellpadding="0" cellspacing="0"><tr><td style="border: #E8EFF9 0px solid;"><img src="img/btns_search.gif" name="btn_srch_dest_via" width="19" height="20" alt="" border="0" align="right" class="cursor"></td></tr></table></td>
							</tr>
						</table>
					</td>
					<td width="25%">
						<table class="search" border="0" width="100%"> 
							<tr><td  align="center" style="border: #E8EFF9 1px solid;"><b>Destination</b></td>
							<td width="20" align="right" style="border: #E8EFF9 0px solid;"><table border="0" cellpadding="0" cellspacing="0"><tr><td style="border: #E8EFF9 0px solid;"><img src="img/btns_search.gif" name="btn_srch_dest_pnt" width="19" height="20" alt="" border="0" align="right" class="cursor"></td></tr></table></td>
							</tr>
						</table>
					</td></tr>
		            <tr>
		                <td class="input"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td></tr></table></div></td>
		                <td class="input"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
		                <td class="input"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
		                <td class="input"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
		            </tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td width="150" class="title_s">Rate</td>
					<td>
						<table class="search" border="0" style="width:320;background-color: #E9E9E9;"> 
						<tr class="h23">
							<td width="110">&nbsp;PRS Cost Level</td>
							<td width="" class="stm">
							<input name="rdoPRSCostLevel" value="CM" type="radio" class="trans">BKG CM(RA)&nbsp;&nbsp;&nbsp;
							<input name="rdoPRSCostLevel" value="OP" type="radio" class="trans">BKG OP(RA)
							</td>
						</tr></table>
				
					</td>
					
					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				<table width="100%" class="button">
	       			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_calculate" id="btn_calculate">Calculate</td>
						<td class="btn2_right"></td></tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_schgdetail">Schg. Detail</td>
						<td class="btn2_right"></td></tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_costdetail">Cost Detail</td>
						<td class="btn2_right"></td></tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
		<!-- : ( Search Options ) (S) -->
 	
<!-- : ( Search Options ) (E) -->
		
</td></tr>
</table> 
	
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
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
					<td class="btn1" name="btn_request">Request</td>
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
					<td class="btn1" name="btn_coffer">C/offer</td>
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
					<td class="btn1" name="btn_assign">TRI No. Assign</td>
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
					<td class="btn1" name="btn_copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
			</tr>
			</table>
		</td>
		</tr>
		</table>

    <!--Button (E) -->
    
</td></tr>
</table> 


<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
<script language="javascript">ComSheetObject('sheet6');</script>
<script language="javascript">ComSheetObject('sheet7');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>