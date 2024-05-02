<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0080.jsp
*@FileTitle : Product Catalog
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.07.29 정선용
* 1.0 Creation
* history
* 2010.12.22  채창호  [CHM-201007734] [PRD & SCEM] IRG상 BKG&Temp Flag 적용방법 변경 관련하여, Alert Message 처리 요청사항
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0080Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String xml = "";   
	String ldd ="";
	String pc_ldd ="";
	String mt_pu_dt ="";
	String m_rt ="";
	String calllFunc  = "";
	String est_arr_dt  = "";
	String map_seq  = "";
	String cnst_flg  = "";
	String pod_cd  = "";
	String ttl_expn_amt  = "";
	String sum_bkg_qty  = "";
	String sum_ctp_sz  = "";
	
	String pre_n1st_pol_dc = "";
	String post_n1st_pol_dc = "";
	String pre_n1st_pod_dc = "";
	String post_n1st_pod_dc = "";
	String pre_n2nd_pol_dc = "";
	String post_n2nd_pol_dc = "";
	String pre_n2nd_pod_dc = "";
	String post_n2nd_pod_dc = "";
	String pre_n3rd_pol_dc = "";
	String post_n3rd_pol_dc = "";
	String pre_n3rd_pod_dc = "";
	String post_n3rd_pod_dc = "";
	String pre_n4th_pol_dc = "";
	String post_n4th_pol_dc = "";
	String pre_n4th_pod_dc = "";
	String post_n4th_pod_dc = "";

	String n1st_pol_dc_seq = "";
	String n1st_pod_dc_seq = "";
	String n2nd_pol_dc_seq = "";
	String n2nd_pod_dc_seq = "";
	String n3rd_pol_dc_seq = "";
	String n3rd_pod_dc_seq = "";
	String n4th_pol_dc_seq = "";
	String n4th_pod_dc_seq = "";
	
	String obTrspMode = "";
	String ibTrspMode = "";

	//Logger log = Logger.getLogger("com.hanjin.apps.ProductCatalogManage.ProductCatalogManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdPrd0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage().replaceAll("\n", "").replaceAll("\r", "<||>");
			//System.out.println("\n @@@@@@strErrMsg:" + strErrMsg);
		} else {
			// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			
			calllFunc  = JSPUtil.getParameter(request, "func");
			
			DefaultViewAdapter adapter = new DefaultViewAdapter();   
			xml = adapter.makeXML(request, response).replaceAll("\"", "&quot;");

			ldd = JSPUtil.getNull(eventResponse.getETCData("ldd")); // bkg으로 입력받은 ldd
			est_arr_dt = JSPUtil.getNull(eventResponse.getETCData("arr_dt"));
			pod_cd = JSPUtil.getNull(eventResponse.getETCData("pod_cd"));
			ttl_expn_amt = JSPUtil.getNull(eventResponse.getETCData("ttl_expn_amt"));

			pc_ldd = JSPUtil.getNull(eventResponse.getETCData("pc_ldd")); //pc dtl의 loadding due date 
			mt_pu_dt = JSPUtil.getNull(eventResponse.getETCData("mt_pu_dt"));
			map_seq = JSPUtil.getNull(eventResponse.getETCData("map_seq"));
			cnst_flg = JSPUtil.getNull(eventResponse.getETCData("cnst_flg"));
			sum_bkg_qty = JSPUtil.getNull(eventResponse.getETCData("sum_bkg_qty"));
			sum_ctp_sz = JSPUtil.getNull(eventResponse.getETCData("sum_ctp_sz"));
	 
			m_rt = JSPUtil.getParameter(request, "m_rt") ;
			
			if(!m_rt.equals("")) {
				mt_pu_dt = m_rt;
			}
			
			obTrspMode = JSPUtil.getNull(JSPUtil.getParameter(request, "org_trns_mode"));
			obTrspMode = "AL".equals(obTrspMode)?"":obTrspMode;
			ibTrspMode = JSPUtil.getNull(JSPUtil.getParameter(request, "dest_trns_mode"));
			ibTrspMode = "AL".equals(ibTrspMode)?"":ibTrspMode;
			//System.out.println("\n@@@@@@calllFunc:" + calllFunc);
			//System.out.println("\n@@@@@@ ldd:" + ldd);
			//System.out.println("\n@@@@@@ pc ldd:" + pc_ldd);
			//System.out.println("\n@@@@@@pod:" + request.getParameter("pod"));
			//System.out.println("\n@@@@@@m_rt :" + m_rt );
			//System.out.println("\n@@@@@@cnst_flg :" + cnst_flg );
			//System.out.println("\n@@@@@@pod_cd :" + pod_cd );
			//System.out.println("\n@@@@@@ttl_expn_amt :" + ttl_expn_amt );
			//System.out.println("\n@@@@@@map_seq :" + map_seq );
			//System.out.println("\n@@@@@@ event.getPrdCreateParamVO().getBkgRcvT() :" +event.getPrdCreateParamVO().getBkgRcvT());
			//System.out.println("\n@@@@@@ event.getPrdCreateParamVO().getBkgDelT() :" +event.getPrdCreateParamVO().getBkgDelT());

			//System.out.println("\n@@@@@@ ---------------------------------------"  );
			
		} 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Product Catalog</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">

	function setupPage(){
		var errMessage = '<%=strErrMsg%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="sXml" value="">
<input type="hidden" name="f_cmd" value="<%=JSPUtil.getParameter(request, "f_cmd") %>">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="valChk" value="">


<!-- maininfoVo -->
<input type="hidden" name="pc_mode" value="<%=JSPUtil.getParameter(request, "pc_mode") %>">   
<input type="hidden" name="rcv_t" value="<%=JSPUtil.getParameter(request, "rcv_t") %>">
<input type="hidden" name="del_t" value="<%=JSPUtil.getParameter(request, "del_t") %>">
<input type="hidden" name="por"   value="<%=JSPUtil.getParameter(request, "por") %>">
<input type="hidden" name="por_n" value="<%=JSPUtil.getParameter(request, "por_n") %>">
<input type="hidden" name="pol"   value="<%=JSPUtil.getParameter(request, "pol") %>">
<input type="hidden" name="pol_n" value="<%=JSPUtil.getParameter(request, "pol_n") %>">
<input type="hidden" name="pod" value="<%=JSPUtil.getParameter(request, "pod") %>">
<input type="hidden" name="pod_n" value="<%=JSPUtil.getParameter(request, "pod_n") %>">
<input type="hidden" name="del" value="<%=JSPUtil.getParameter(request, "del") %>">
<input type="hidden" name="del_n" value="<%=JSPUtil.getParameter(request, "del_n") %>">
<input type="hidden" name="t_vvd" value="<%=JSPUtil.getParameter(request, "t_vvd") %>">
<input type="hidden" name="pod1" value="<%=JSPUtil.getParameter(request, "pod1") %>">
<input type="hidden" name="pod1_n" value="<%=JSPUtil.getParameter(request, "pod1_n") %>">
<input type="hidden" name="pol1" value="<%=JSPUtil.getParameter(request, "pol1") %>">
<input type="hidden" name="pol1_n" value="<%=JSPUtil.getParameter(request, "pol1_n") %>">
<input type="hidden" name="vvd1" value="<%=JSPUtil.getParameter(request, "vvd1") %>">
<input type="hidden" name="lane1" value="<%=JSPUtil.getParameter(request, "lane1") %>">
<input type="hidden" name="pod2" value="<%=JSPUtil.getParameter(request, "pod2") %>">
<input type="hidden" name="pod2_n" value="<%=JSPUtil.getParameter(request, "pod2_n") %>">
<input type="hidden" name="pol2" value="<%=JSPUtil.getParameter(request, "pol2") %>">
<input type="hidden" name="pol2_n" value="<%=JSPUtil.getParameter(request, "pol2_n") %>">
<input type="hidden" name="vvd2" value="<%=JSPUtil.getParameter(request, "vvd2") %>">
<input type="hidden" name="lane2" value="<%=JSPUtil.getParameter(request, "lane2") %>">
<input type="hidden" name="pod3" value="<%=JSPUtil.getParameter(request, "pod3") %>">
<input type="hidden" name="pod3_n" value="<%=JSPUtil.getParameter(request, "pod3_n") %>">
<input type="hidden" name="pol3" value="<%=JSPUtil.getParameter(request, "pol3") %>">
<input type="hidden" name="pol3_n" value="<%=JSPUtil.getParameter(request, "pol3_n") %>">
<input type="hidden" name="vvd3" value="<%=JSPUtil.getParameter(request, "vvd3") %>">
<input type="hidden" name="lane3" value="<%=JSPUtil.getParameter(request, "lane3") %>">
<input type="hidden" name="pod4" value="<%=JSPUtil.getParameter(request, "pod4") %>">
<input type="hidden" name="pod4_n" value="<%=JSPUtil.getParameter(request, "pod4_n") %>">
<input type="hidden" name="pol4" value="<%=JSPUtil.getParameter(request, "pol4") %>">
<input type="hidden" name="pol4_n" value="<%=JSPUtil.getParameter(request, "pol4_n") %>">
<input type="hidden" name="vvd4" value="<%=JSPUtil.getParameter(request, "vvd4") %>">
<input type="hidden" name="lane4" value="<%=JSPUtil.getParameter(request, "lane4") %>">
<input type="hidden" name="ld_dt" value="<%=JSPUtil.getParameter(request, "ld_dt") %>">

<input type="hidden" name="dr_dt" value="<%=JSPUtil.getParameter(request, "dr_dt") %>">
<input type="hidden" name="m_pu" value="<%=JSPUtil.getParameter(request, "m_pu") %>">
<input type="hidden" name="f_rt" value="<%=JSPUtil.getParameter(request, "f_rt") %>">
<input type="hidden" name="cgo_tp" value="<%=JSPUtil.getParameter(request, "cgo_tp") %>">
<input type="hidden" name="pm_f" value="<%=JSPUtil.getParameter(request, "pm_f") %>">
<input type="hidden" name="dg_f" value="<%=JSPUtil.getParameter(request, "dg_f") %>">
<input type="hidden" name="rf_f" value="<%=JSPUtil.getParameter(request, "rf_f") %>">
<input type="hidden" name="ak_f" value="<%=JSPUtil.getParameter(request, "ak_f") %>">
<input type="hidden" name="bb_f" value="<%=JSPUtil.getParameter(request, "bb_f") %>">
<input type="hidden" name="rd_f" value="<%=JSPUtil.getParameter(request, "rd_f") %>">
<input type="hidden" name="soc_f" value="<%=JSPUtil.getParameter(request, "soc_f") %>">
<input type="hidden" name="com" value="<%=JSPUtil.getParameter(request, "com") %>">
<input type="hidden" name="rep_com" value="<%=JSPUtil.getParameter(request, "rep_com") %>">
<input type="hidden" name="bkg_ofc" value="<%=JSPUtil.getParameter(request, "bkg_ofc") %>">
<input type="hidden" name="org_sal_ofc" value="<%=JSPUtil.getParameter(request, "org_sal_ofc") %>">
<input type="hidden" name="rfa" value="<%=JSPUtil.getParameter(request, "rfa") %>">
<input type="hidden" name="sc" value="<%=JSPUtil.getParameter(request, "sc") %>">
<input type="hidden" name="rfa_ofc" value="<%=JSPUtil.getParameter(request, "rfa_ofc") %>">
<input type="hidden" name="sc_ofc" value="<%=JSPUtil.getParameter(request, "sc_ofc") %>">
<input type="hidden" name="shpr" value="<%=JSPUtil.getParameter(request, "shpr") %>">
<input type="hidden" name="cngn" value="<%=JSPUtil.getParameter(request, "cngn") %>">
<input type="hidden" name="wgt" value="<%=JSPUtil.getParameter(request, "wgt") %>">
<input type="hidden" name="wgt_un" value="<%=JSPUtil.getParameter(request, "wgt_un") %>">
<input type="hidden" name="hg_f" value="<%=JSPUtil.getParameter(request, "hg_f") %>">
<input type="hidden" name="sub_f" value="<%=JSPUtil.getParameter(request, "sub_f") %>">
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no") %>">
<input type="hidden" name="imdg" value="<%=JSPUtil.getParameter(request, "imdg") %>">
<input type="hidden" name="hitchment" value="<%=JSPUtil.getParameter(request, "hitchment") %>">
<input type="hidden" name="com_bkg_no" value="<%=JSPUtil.getParameter(request, "com_bkg_no") %>">
<input type="hidden" name="copy_cnt" value="<%=JSPUtil.getParameter(request, "copy_cnt") %>">
<input type="hidden" name="no_cost" value="<%=JSPUtil.getParameter(request, "no_cost") %>">
<input type="hidden" name="flex_hgt_flg" value="<%=JSPUtil.getParameter(request, "flex_hgt_flg") %>">
<input type="hidden" name="ida_hlg_tp_cd" value="<%=JSPUtil.getParameter(request, "ida_hlg_tp_cd") %>">

<!-- maininfoVo end-->
<!-- QuantityVO start-->
<%

PrdQuantityVO[] prdQuantityVO = event.getPrdQuantityVOs();
for (int i = 0; i < prdQuantityVO.length; i++) {

%>
<input type="hidden" name="c_tpsz" value="<%=prdQuantityVO[i].getCTpsz() %>">
<input type="hidden" name="c_qty" value="<%=prdQuantityVO[i].getCQty() %>">
<!-- QuantityVO end-->
<% 
}
%>
<input type="hidden" name="pctl_no" >
<input type="hidden"  name="m_pu_dt" >
<input type="hidden" name="map_seq" value="<%=map_seq %>">
<input type="hidden"  name="mt_pkup_dt" value="<%=JSPUtil.getParameter(request, "mt_pkup_dt") %>">
<input type="hidden" name="cnst_flg" value="<%=cnst_flg %>">

<input type="hidden" name="return_str" >
<input type="hidden" name="sum_bkg_qty" value="<%=sum_bkg_qty %>">
<input type="hidden" name="sum_ctp_sz" value="<%=sum_ctp_sz %>">
<input type="hidden" name="bkg_rcv_t" value="<%=event.getPrdCreateParamVO().getBkgRcvT() %>">
<input type="hidden" name="bkg_del_t" value="<%=event.getPrdCreateParamVO().getBkgDelT() %>">

<!-- input type="hidden" name="pol1_dc_flg" >
<input type="hidden" name="pod1_dc_flg" >
<input type="hidden" name="pol2_dc_flg" >
<input type="hidden" name="pod2_dc_flg" >
<input type="hidden" name="pol3_dc_flg" >
<input type="hidden" name="pod3_dc_flg" >
<input type="hidden" name="pol4_dc_flg" >
<input type="hidden" name="pod4_dc_flg"  -->

<input type="hidden" name="pre_n1st_pol_dc" >
<input type="hidden" name="post_n1st_pol_dc" >
<input type="hidden" name="pre_n1st_pod_dc" >
<input type="hidden" name="post_n1st_pod_dc" >
<input type="hidden" name="pre_n2nd_pol_dc" >
<input type="hidden" name="post_n2nd_pol_dc" >
<input type="hidden" name="pre_n2nd_pod_dc" >
<input type="hidden" name="post_n2nd_pod_dc" >
<input type="hidden" name="pre_n3rd_pol_dc" >
<input type="hidden" name="post_n3rd_pol_dc" >
<input type="hidden" name="pre_n3rd_pod_dc" >
<input type="hidden" name="post_n3rd_pod_dc" >
<input type="hidden" name="pre_n4th_pol_dc" >
<input type="hidden" name="post_n4th_pol_dc" >
<input type="hidden" name="pre_n4th_pod_dc" >
<input type="hidden" name="post_n4th_pod_dc" >

<input type="hidden" name="n1st_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol1_c") %>">
<input type="hidden" name="n1st_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod1_c") %>">
<input type="hidden" name="n2nd_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol2_c") %>">
<input type="hidden" name="n2nd_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod2_c") %>">
<input type="hidden" name="n3rd_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol3_c") %>">
<input type="hidden" name="n3rd_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod3_c") %>">
<input type="hidden" name="n4th_pol_dc_seq" value="<%=JSPUtil.getParameter(request, "pol4_c") %>">
<input type="hidden" name="n4th_pod_dc_seq" value="<%=JSPUtil.getParameter(request, "pod4_c") %>">


<input type="hidden" name="n1st_pol_clpt_ind_seq" value="">
<input type="hidden" name="n1st_pod_clpt_ind_seq" value="">
<input type="hidden" name="n2nd_pol_clpt_ind_seq" value="">
<input type="hidden" name="n2nd_pod_clpt_ind_seq" value="">
<input type="hidden" name="n3rd_pol_clpt_ind_seq" value="">
<input type="hidden" name="n3rd_pod_clpt_ind_seq" value="">
<input type="hidden" name="n4th_pol_clpt_ind_seq" value="">
<input type="hidden" name="n4th_pod_clpt_ind_seq" value="">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><% if(true){ %> Product Catalog<%}else{ %><span id="title"></span><%} %></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table width="100%">
				       		<tr>
				       			<td>
								<table class="search" border="0" style="width:725;">
								<tr class="h23">
									<td width="120">Ocean Route : POL</td>
									<td width="80"><input type="" name="" class="input2" value="<%=JSPUtil.getParameter(request, "pol")%>" style="width:60" readonly></td>
									<td>
										<table border="0" style="height:20; width:500; background-color: #E9E9E9;">
			                           					 <tr class="h23">
			                           					 	<td width="" align="center">* Yellow box is trunk lane &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Sorted by Flag -> Cost -> Priority</td>
			                           					 </tr>
		                                				</table>
									</td>
								</tr></table>
							</td>
						       	<td>
								<table border="0" style="height:20; width:250; background-color: #E9E9E9;">
	                           					 <tr class="h23">
	                           					 	<td width="140" align="center">Sailing Due Date</td>
	                           					 	<td><input name="fm_ld_dt" type="text" maxlength="8" style="width:70;" value="<%=ldd %>" dataformat="ymd"> <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_LddCalendar">
										</td>
									</tr>
                                				</table>
							</td>
						</tr>
					</table>

					<table class="height_5"><tr><td></td></tr></table>

					<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table width="100%">
				       		<tr>
				       			<td>
								<table class="search_in" border="0">
								<tr class="h23">
									<td width="15"></td>
									<td width="220">Origin Inland Route(POR ~ POL) :</td>
									<td width=""><input type="" name="" class="input2" value="<%=JSPUtil.getParameter(request, "por") %>" style="width:60" readonly> ~ <input type="" name="" class="input2" value="<%=JSPUtil.getParameter(request, "pol") %>" style="width:60" readonly></td>
								</tr>
								</table>
								<table class="search_in" border="0">
								<tr>
									<td width="280">
										<table border="0" style="height:20; width:250; background-color: #E9E9E9;">
		                           					 <tr class="h23">
		                           					 	<td width="140" align="center">Empty Pick Up Date</td>
		                           					 	<td><input name="fm_empty_dt" type="text" maxlength="8" style="width:70;" value="" dataformat="ymd" > <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_EmptyCalendar'>
											</td>
										</tr>
	                                					</table>
                                					</td>
                                					<td>
										<table border="0" style="height:20; width:700; background-color: #E9E9E9;">
			                           					 <tr>
			                           					 	<td width="" align="Left">*EQ Inventory information is subject to local situation. For accurate information, Please contact your local operation department directly</td>
			                           					 </tr>
		                                				</table>
									</td>
                                				</tr>
                                				</table>
							</td>
						</tr>
					</table>

					<table class="height_5"><tr><td></td></tr></table>

					<table width="978">
						<tr>
							<td width="484">
								<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<div style=""> &nbsp;</div>
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid (E) -->

							</td>
							<td>
								<table width="10"><tr><td></td></tr></table>
							</td>
							<td width="484">
								<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<div id="sheet3Title" style="color:#3333ff; font-size: 11px;">&nbsp;</div>
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid (E) -->

							</td>
						</tr>
					</table>

					<table class="height_5"><tr><td></td></tr></table>

					<table>
						<tr class="h23">
							<td width="90">Trans Mode</td>
							<td class="stm"> 
								<input type="radio" name='ob_trsp_mode' value="" class="trans" <%="".equals(obTrspMode)?"checked":"" %> onClick="javascript:chk_ob_trsp_mode(this);" >&nbsp;Standard mode &nbsp;&nbsp;&nbsp;
				                        	<!-- input type="radio" name='ob_trsp_mode' value="W" class="trans" onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;via Barge or Feeder&nbsp;&nbsp;&nbsp;
				                        	<input type="radio" name='ob_trsp_mode' value="R" class="trans" onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;via Rail&nbsp;&nbsp;&nbsp;
				                        	<input type="radio" name='ob_trsp_mode' value="T" class="trans" onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;Truck only (or all motor)
				                        	-->
				                        	<!-- NEW  -->
				                        	<input type="radio" name='ob_trsp_mode' value="WD" class="trans" <%="WD".equals(obTrspMode)?"checked":"" %> onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;Water Direct
				                        	<input type="radio" name='ob_trsp_mode' value="RD" class="trans" <%="RD".equals(obTrspMode)?"checked":"" %> onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;Rail Direct
				                        	<input type="radio" name='ob_trsp_mode' value="TD" class="trans" <%="TD".equals(obTrspMode)?"checked":"" %> onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;Truck Direct
				                        	<input type="radio" name='ob_trsp_mode' value="TR" class="trans" <%="TR".equals(obTrspMode)?"checked":"" %> onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;Truck + Rail
				                        	<input type="radio" name='ob_trsp_mode' value="TW" class="trans" <%="TW".equals(obTrspMode)?"checked":"" %> onClick="javascript:chk_ob_trsp_mode(this);">&nbsp;Truck + Water
				                        </td>
						</tr>
					</table>
					<!-- Grid : Week (E) -->





				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table width="100%">
				       		<tr>
				       			<td>
								<table class="search" border="0" style="width:700;">
								<tr class="h23">
									<td width="250">Destination Inland Route (POD ~ DEL):</td>
									<td width=""><input type="" name="d_pod_cd" class="input2" value="<%=pod_cd %>" style="width:60" readonly> ~ <input type="" name="" class="input2" value="<%=JSPUtil.getParameter(request, "del") %>" style="width:60" readonly></td>
								</tr></table>
							</td>
						       	<td>
								<table border="0" style="height:20; width:270; background-color: #E9E9E9;">
	                           					 <tr class="h23">
	                           					 	<td width="160" align="center">Estimated Arrival Date</td>
	                           					 	<td><input name="arr_dt" type="text" maxlength="8" style="width:70;" class="input2" value="<%=est_arr_dt %>" dataformat="ymd" readonly>  
										</td>
									</tr>
                                				</table>
							</td>
						</tr>
					</table>

					<table class="height_5"><tr><td></td></tr></table>


					<table>
						<tr class="h23">
							<td width="90">Trans Mode</td>
							<td class="stm">
 								<input type="radio" name='ib_trsp_mode' value="" class="trans" <%="".equals(ibTrspMode)?"checked":"" %> onClick="javascript:chk_ib_trsp_mode(this);" >&nbsp;Standard mode &nbsp;&nbsp;&nbsp;
				                        	<!-- input type="radio" name='node_div' value="5" class="trans">&nbsp;via Barge or Feeder&nbsp;&nbsp;&nbsp;
				                        	<input type="radio" name='node_div' value="7" class="trans">&nbsp;via Rail&nbsp;&nbsp;&nbsp;
				                        	<input type="radio" name='node_div' value="7" class="trans">&nbsp;Truck only (or all motor)
				                        	 -->
				                        	<!-- NEW  -->
				                        	<input type="radio" name='ib_trsp_mode' value="WD" class="trans" <%="WD".equals(ibTrspMode)?"checked":"" %> onClick="javascript:chk_ib_trsp_mode(this);">&nbsp;Water Direct
				                        	<input type="radio" name='ib_trsp_mode' value="RD" class="trans" <%="RD".equals(ibTrspMode)?"checked":"" %> onClick="javascript:chk_ib_trsp_mode(this);">&nbsp;Rail Direct
				                        	<input type="radio" name='ib_trsp_mode' value="TD" class="trans" <%="TD".equals(ibTrspMode)?"checked":"" %> onClick="javascript:chk_ib_trsp_mode(this);">&nbsp;Truck Direct
				                        	<input type="radio" name='ib_trsp_mode' value="TR" class="trans" <%="TR".equals(ibTrspMode)?"checked":"" %> onClick="javascript:chk_ib_trsp_mode(this);">&nbsp;Truck + Rail
				                        	<input type="radio" name='ib_trsp_mode' value="TW" class="trans" <%="TW".equals(ibTrspMode)?"checked":"" %> onClick="javascript:chk_ib_trsp_mode(this);">&nbsp;Truck + Water
				                        	
				                        </td>
						</tr>
					</table>
					<!-- Grid : Week (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->



		<table class="search" border="0">
			<tr class="h23">
				<td width="102">Total Cost(USD)</td>
				<td width="120"><input name="ttl_expn_amt" value="<%=ttl_expn_amt %>" class="input2" type="text" style="width:70;" readonly ></td>
				<td width="115">Total Transit(Day)</td>
				<td width=""><input name="transit_dt" class="input2" type="text" style="width:70;" readonly ></td>
				<td>
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_fullroute" id="btng_fullroute">Full Route</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_constraints" id="btng_constraints">Constraints</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>

				</td>
			</tr>
		</table>

    </td></tr>
</table>
<!-- Outer Table (E)-->

					<table class="height_10"><tr><td></td></tr></table>


					<table width="100%" class="sbutton">
							<tr><td height="71" class="popup">

								<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
						       		<tr><td class="btn3_bg">
								    <table border="0" cellpadding="0" cellspacing="0">
								    <tr>

										<!-- Repeat Pattern -->

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_select" id="btn_select" >Select</td><td class="btn1_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr>
									<tr>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="search" style="height:20; width:435; background-color: #E9E9E9;">
										<tr>
										<td align="center">In case there is "No Service" in Constraints, "Select" button becomes disable.&nbsp;<br>For detail information, please click "Constraints" button in red.
										</td>
										</tr>
										</table>
									</tr>
									</table>
								</table>

							</td></tr>
					</table>
		
 
<!-- 개발자 작업  끝 -->
</form>
<span id="prd_form"></span>
</body>
</html>