<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6023.jsp
*@FileTitle : PRS- Cost Detail - Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.07 송민석
* 1.0 Creation
=========================================================
* History
* 2011-08-04 서미진 [선처리 후 CSR] COA architecture 위반 수정에 따른 에러 수정
* 2013-08-05 송호진 [CHM-201325819] 7월 PRS 배치작업 요청 - Pre CM/OP Simulation 조회 시 BackEndJob 조회 방식 적용 
=========================================================*/	
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event.EsmPri6023Event"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6023Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCRateProposal");
	String tri_prop_no		= null;
	String prop_no		= null;
	String amdt_seq		= null;
	String svc_scp_cd		= null;
	String qttn_no		= null;
	String qttn_ver_no		= null;
	String gen_spcl_rt_tp_cd		= null;
	String cmdt_hdr_seq		= null;
	String rout_seq		= null;
	String rt_seq		= null;
	String cost_tp = null;
	
	String f_g_rev			= null;
	String f_por_cd			= null;
	String f_pol_cd			= null;
	String f_pod_cd			= null;
	String f_del_cd			= null;
	String f_r_term			= null;
	String f_d_term			= null;
	String f_cntr_tpsz_cd		= null;
	String f_qty			= null;
	String f_agmt_sgn_ofc_cd= null;
	String f_sls_ofc_cd		= null;
	String f_bkg_ofc_cd		= null;
	String f_void_qty		= null;
	String popup_type = null;
	
	String rout_cs_no = null;
	String rout_cs_src_dt = null;
	
	String userId  = "";
    String ofc_cd  = "";
    String ofc_lvl = "";
    String strOfc_cd = "";
	
	//String revenue			= null; //       <-- Rate tab-Grid의 quotation + surcharge
	String cargo			= null; //	      <-- Rate tab-Grid의 Cargo
	//String per				= null; //	      <-- Rate tab-Grid의 Per Type
	//String contract_ofc		= null; //  <-- 메인화면의 Request Office
	    Utils utils = new Utils();
	try {
	 
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
 
		
		userId = account.getUsr_id();
        //ofc_cd = utils.getUserOffice2(strOfc_cd);
        //ofc_lvl = utils.getUserLevel(strOfc_cd);
	    //N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
	  	//ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
	  	//ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
 
		f_g_rev			= JSPUtil.getParameter(request,"revenue","0");
		f_por_cd		= JSPUtil.getParameter(request,"f_por_cd");
		f_pol_cd		= JSPUtil.getParameter(request,"f_pol_cd");
		f_pod_cd		= JSPUtil.getParameter(request,"f_pod_cd");
		f_del_cd		= JSPUtil.getParameter(request,"f_del_cd");
		f_r_term		= JSPUtil.getParameter(request,"f_r_term");
		f_d_term		= JSPUtil.getParameter(request,"f_d_term");
		f_cntr_tpsz_cd		= JSPUtil.getParameter(request,"per");
		f_qty			= "1";
		f_agmt_sgn_ofc_cd	= JSPUtil.getParameter(request,"contract_ofc");
		f_sls_ofc_cd		= JSPUtil.getParameter(request,"f_sls_ofc_cd");
		f_bkg_ofc_cd		= JSPUtil.getParameter(request,"f_bkg_ofc_cd");
		f_void_qty		= JSPUtil.getParameter(request,"f_void_qty");
 
		cargo		= JSPUtil.getParameter(request,"cargo");
		tri_prop_no		= JSPUtil.getParameter(request,"tri_prop_no");
		prop_no		= JSPUtil.getParameter(request,"prop_no");
		amdt_seq		= JSPUtil.getParameter(request,"amdt_seq");
		svc_scp_cd		= JSPUtil.getParameter(request,"svc_scp_cd");
		qttn_no		= JSPUtil.getParameter(request,"qttn_no");
		qttn_ver_no		= JSPUtil.getParameter(request,"qttn_ver_no");
		gen_spcl_rt_tp_cd		= JSPUtil.getParameter(request,"gen_spcl_rt_tp_cd");
		cmdt_hdr_seq		= JSPUtil.getParameter(request,"cmdt_hdr_seq");
		rout_seq		= JSPUtil.getParameter(request,"rout_seq");
		rt_seq		= JSPUtil.getParameter(request,"rt_seq");
		cost_tp		= JSPUtil.getParameter(request,"cost_tp");
		popup_type =  JSPUtil.getParameter(request,"popup_type");
		
		rout_cs_no =  JSPUtil.getParameter(request,"rout_cs_no");
		rout_cs_src_dt =  JSPUtil.getParameter(request,"rout_cs_src_dt");

 
		event = (EsmPri6023Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		


		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ofc_cd = eventResponse.getETCData("ofc_cd");
		ofc_lvl = eventResponse.getETCData("ofc_lvl");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>PRS- Cost Detail - Pre CM/OP Simulation</title>
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
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

<input type="hidden" name="f_user_id"  value="<%=userId%>">
<input type="hidden" name="f_ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="f_ofc_lvl" value="<%=ofc_lvl%>">

<input type="hidden" name="qttn_no" value="<%=qttn_no%>">
<input type="hidden" name="qttn_ver_no" value="<%=qttn_ver_no%>">
<input type="hidden" name="prop_no" value="<%=prop_no%>">
<input type="hidden" name="tri_prop_no" value="<%=tri_prop_no%>">
<input type="hidden" name="amdt_seq" value="<%=amdt_seq%>">
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=gen_spcl_rt_tp_cd%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=cmdt_hdr_seq%>">
<input type="hidden" name="rout_seq"  value="<%=rout_seq%>">
<input type="hidden" name="rt_seq" value="<%=rt_seq%>">
<input type="hidden" name="cost_tp" value="<%=cost_tp%>">
<input type="hidden" name="cargo" value="<%=cargo %>">
<input type="hidden" name="f_spcl_dg" value="<%=(cargo.equals("DG") ? "Y":"")%>"  >
<input type="hidden" name="f_spcl_rf" value="<%=(cargo.equals("RF") ? "Y":"") %>" >
<input type="hidden" name="f_spcl_ak" value="<%=(cargo.equals("AK") ? "Y":"") %>" >
<input type="hidden" name="f_spcl_bb" value="<%=(cargo.equals("BB") ? "Y":"") %>" >
<input type="hidden" name="f_spcl_soc" value="" >
<input type="hidden" name="f_pc_creation" value="N">
<input type="hidden" name="f_pctl_no" value="">
<input type="hidden" name="pctl_no" value="">
<input type="hidden" name="f_cob_profit_vw" value="R"> <!--  office profit :R, trade profit:P -->
<input type="hidden" name="f_cob_profit_lv" value="<%=cost_tp%>">
<input type="hidden" name="popup_type" value="<%=popup_type%>">
<input type="hidden" name="rout_cs_no" value="<%=rout_cs_no%>">
<input type="hidden" name="rout_cs_src_dt" value="<%=rout_cs_src_dt%>">

<input type="hidden" name="por_cd" value="">
<input type="hidden" name="pol_cd" value="">
<input type="hidden" name="pod_cd" value="">
<input type="hidden" name="del_cd" value="">
<input type="hidden" name="bkg_rcv_term_cd" value="">
<input type="hidden" name="bkg_de_term_cd" value="">
<input type="hidden" name="bkg_ofc_cd" value="">
<input type="hidden" name="ctrt_ofc_cd" value="">
<input type="hidden" name="ob_sls_ofc_cd" value="">
<input type="hidden" name="rat_ut_cd" value="">
<input type="hidden" name="prc_cgo_tp_cd" value="">
<input type="hidden" name="teu_frt_rev" value="">
<input type="hidden" name="backendjob_key">
 
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Pre CM/OP Simulation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<!-- biz_1  (S) -->
			
				<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="90">Profit  View</td>
					<td width="120"><input type="hidden"  value="R" name="cobProfitVw"><input type="text" style="width:80;text-align:center;" class="input2" value=" Office Profit" name="cobProfitVw_text"  readonly></td>
					<td width="80">Profit Level </td>
					<td width=""><input type="hidden" class="input2" value="<%=cost_tp %>" name="cobProfitLv2"  readonly><input type="text" style="width:80;text-align:center;" class="input2" value="<%=(cost_tp.equals("C")?"CM":"OP") %>" name="cobProfitLv2_text"  readonly></td>
 				</tr>
				<tr class="h23">
					<td width="">Revenue</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input2" value="<%=f_g_rev %>" name="f_g_rev"  readonly></td>
					<td width="">SPCL CGO</td>
					<td width="">
						<input type="checkbox" class="trans" name="tmp_spcl_dg" value="Y"  disabled  <%=(cargo.equals("DG") ? "checked":"") %>>DG&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="tmp_spcl_rf" value="Y" disabled <%=(cargo.equals("RF") ? "checked":"") %>>RF&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="tmp_spcl_ak" value="Y" disabled <%=(cargo.equals("AK") ? "checked":"") %>>AK&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="tmp_spcl_bb" value="Y" disabled <%=(cargo.equals("BB") ? "checked":"") %>>BB&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="tmp_spcl_soc" value="Y" disabled  >S.O.C&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="tmp_spcl_revmt" value="Y" disabled  >Revenue MT
					</td>
 				</tr>
				</table>
				
				<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="90">POR</td>
					<td width="120"><input type="text" style="width:80;text-align:center;" class="input1" value="<%=f_por_cd %>"  name="f_por_cd" dataformat="engup" maxlength="5"></td>
					<td width="80">POL</td>
					<td width="120"><input type="text" style="width:80;text-align:center;" class="input" value="<%=f_pol_cd %>" name="f_pol_cd" dataformat="engup" maxlength="5"></td>
					<td width="80">POD</td>
					<td width="120"><input type="text" style="width:80;text-align:center;" class="input" value="<%=f_pod_cd %>" name="f_pod_cd" dataformat="engup" maxlength="5"></td>
					<td width="65">DEL</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input1" value="<%=f_del_cd %>" name="f_del_cd" dataformat="engup" maxlength="5"></td>
 				</tr>
				<tr class="h23">
					<td>R Term</td>
					<td style="padding-left:2;"><script language=javascript>ComComboObject('f_r_term', 1, 82, 0, 1, 0, false);</script></td>
					<td>D Term</td>
					<td style="padding-left:2;"><script language=javascript>ComComboObject('f_d_term', 1, 82, 0, 1, 0, false);</script></td>
					<td>TP/SZ</td>
					<td><input type="text" style="width:80;text-align:center;" class="input2" value="<%=f_cntr_tpsz_cd %>" name="f_cntr_tpsz_cd"  readonly></td>
					<td>Q'ty</td>
					<td><input type="text" style="width:80;text-align:center;" class="input2" value="<%= f_qty%>" name="f_qty" readonly></td>
 				</tr>
				<tr class="h23">
					<td>Contract OFC</td>
					<td><input type="text" style="width:80;text-align:center;" class="input2" value="<%=f_agmt_sgn_ofc_cd %>" name="f_agmt_sgn_ofc_cd" readonly></td>
					<td>Loading OFC</td>
					<td><input type="text" style="width:80;text-align:center;" class="input1" value="<%=f_sls_ofc_cd %>" name="f_sls_ofc_cd"  dataformat="engup" maxlength="5"></td>
					<td>Booking OFC</td>
					<td><input type="text" style="width:80;text-align:center;" class="input1" value="<%=f_bkg_ofc_cd %>" name="f_bkg_ofc_cd"  dataformat="engup" maxlength="5"></td>
					<td>Void (TEU)</td>
					<td><input type="text" style="width:80;text-align:center;" class="input" value="<%=f_void_qty %>" name="f_void_qty" dataformat="int" ></td>
 				</tr>
				</table>
				<!-- biz_1  (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 
				<!-- table class="line_bluedot"><tr><td colspan="8"></td></tr></table-->
				
				
				<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Cost Detail Inquiry</td></tr>
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
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_CostDetail">Cost Detail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->

<div style="display:none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</table>
			</td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>