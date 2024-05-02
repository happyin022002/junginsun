﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0112.jsp
*@FileTitle : Invoice Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.2
* 2008-09-12 O Wan-Ki 1.0 최초 생성
* 2009-10-05 Park Sung-Jin 1.1 ALPS Migration 작업
* 2010-03-17 Sun, CHOI 1.2 TPB Invoice Preview POPUP 으로 변경
=========================================================*/ 
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EsdTpb0112Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	
	
	List<SearchInvoiceStatusVO> list = null;
	SearchInvoiceStatusVO vo = null;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.InvoiceManage");
	
	String s_dao_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_dao_n3pty_bil_tp_cd"));
	String s_n3pty_inv_no = JSPUtil.getNull( request.getParameter("s_n3pty_inv_no") );
	String s_lnk_n3pty_inv_no = JSPUtil.getNull( request.getParameter("s_lnk_n3pty_inv_no") );
	if(!s_lnk_n3pty_inv_no.equals("")){
		s_n3pty_inv_no = s_lnk_n3pty_inv_no;
	}
	String s_bil_loc = ""; // JSPUtil.getNull( request.getParameter("s_bil_loc") ); 
	String s_his_seq = JSPUtil.getNull( request.getParameter("s_n3pty_inv_his_seq") ); 
	String s_final_flg = JSPUtil.getNull( request.getParameter("s_final_flg") ); //이전 화면에서 받은 값

	// String s_n3pty_inv_his_seq = request.getParameter("s_n3pty_inv_his_seq"); 
	// String s_n3pty_inv_rmd = request.getParameter("s_n3pty_inv_rmd"); 
	
	 String s_inv_his_seq = StringUtil.xssFilter(request.getParameter("s_n3pty_inv_his_seq")); 
	 String s_inv_rmd = StringUtil.xssFilter(request.getParameter("s_n3pty_inv_rmd_cd")); 
	 String s_snd_edi = StringUtil.xssFilter(request.getParameter("snd_edi_cd"));
	
	String s_clt_agn_flg = ""; //Collection Agency 여부
	String s_n3pty_inv_sts_cd = ""; //ERP I/F 여부
	// String s_n3pty_inv_rmd_yn = ""; //Invoice Version Final(수정가능한지) 여부
	String s_erp_yn = "";
	String s_final_invoice = ""; //Final Version 여부, DB에서 조회한 값

	String s_erp_visible_flag = ""; //ERP I/F 버튼 visable/invisible
	String s_issue_visible_flag = ""; //Issue 버튼 visable/invisible
	String s_inquiryOnly_yn = "";
		
	String s_issue_yn = "";
	String s_erpif_yn = "";
	

	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		s_erp_visible_flag = JSPUtil.getNull((String)event.getAttribute("erp_visible_flag"));
		s_issue_visible_flag = JSPUtil.getNull((String)event.getAttribute("issue_visible_flag"));
		s_inquiryOnly_yn = JSPUtil.getNull(request.getParameter("s_inquiryOnly_yn"));

		//log.debug("s_issue_visible_flag==>"+s_issue_visible_flag);
		//log.debug("s_issue_visible_flag==>"+s_issue_visible_flag);
		
		list = (List<SearchInvoiceStatusVO>)eventResponse.getRsVoList();
		
		if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
			s_clt_agn_flg = eventResponse.getETCData("s_clt_agn_flg");
			s_n3pty_inv_sts_cd = eventResponse.getETCData("s_n3pty_inv_sts_cd");
			s_issue_yn = eventResponse.getETCData("s_issue_yn");
			//log.debug("s_issue_yn==>"+s_issue_yn);
			//log.debug("s_issue_yn==>"+s_issue_yn);
			s_erpif_yn = eventResponse.getETCData("s_erpif_yn");
			s_bil_loc = eventResponse.getETCData("s_bil_loc");
			
			if(!s_clt_agn_flg.equals("N")){
				s_erp_yn = "_clt_agn_flg";
			}else{
				if(!s_n3pty_inv_sts_cd.equals("N")){
					s_erp_yn = "_n3pty_inv_sts_cd";
				}else{
					s_erp_yn = s_n3pty_inv_sts_cd;
				}
			}
		}
		if ( s_inquiryOnly_yn.equals("Y") ){
			s_issue_yn = "N";
			s_erpif_yn = "N";
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script> 
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase 
	}
	
	var emailRnArr = new Array();
	var emailCntcInfoArr = new Array();
	var emailValidYnArr = new Array();
	var faxnoRnArr = new Array();
	var faxnoCntcInfoArr = new Array();
	var faxnoValidYnArr = new Array();
	var j = 0;
	var k = 0;

<%	
	for(int i=0; list!=null && i<list.size(); i++){
	vo = list.get(i);
		if ( vo.getInforowcount().equals("E")) { %>
				emailRnArr      [j] = "<%= vo.getRn() %>";
				emailCntcInfoArr[j] = "<%= vo.getCntcInfo()%>";
				emailValidYnArr [j] = "<%= vo.getCntcInfoValidyn().equals("Y")?"Yes":"No"%>";
				//alert(emailCntcInfoArr[j]);
				j++;
	<%  }else if ( vo.getInforowcount().equals("F")) { %>
				faxnoRnArr      [k] = "<%= vo.getRn( )%>"; 
				faxnoCntcInfoArr[k] = "<%= vo.getCntcInfo()%>"; 
				faxnoValidYnArr [k] = "<%= vo.getCntcInfoValidyn().equals("Y")?"Yes":"No"%>";
				//alert(faxnoCntcInfoArr[k]);
				k++;
	<%  }
	}%> 
/*	
//===============================================================================================	
// TEST 시 사용	
				emailRnArr      [j] = "2";
				emailCntcInfoArr[j] = "spbogus@itsmt.co.kr";
				emailValidYnArr [j] = "Yes";
				j++;
				emailRnArr      [j] = "3";
				emailCntcInfoArr[j] = "sunnyday40@cyberlogitec.com";
				emailValidYnArr [j] = "Yes";
				j++;
				emailRnArr      [j] = "4";
				emailCntcInfoArr[j] = "starpose@cyberlogitec.com";
				emailValidYnArr [j] = "Yes";
				j++;
				faxnoRnArr      [k] = "2";
				faxnoCntcInfoArr[k] = "0263502050";
				faxnoValidYnArr [k] = "Yes";
				k++;
//===============================================================================================
*/
/*
//===============================================================================================	
// TEST 시 사용	
				emailRnArr      [j] = "2";
				emailCntcInfoArr[j] = "bychang@hanjin.com";
				emailValidYnArr [j] = "Yes";
				j++;
				faxnoRnArr      [k] = "2";
				faxnoCntcInfoArr[k] = "0222873441";
				faxnoValidYnArr [k] = "Yes";
				k++;
//===============================================================================================
*/
</script>
</head>
 
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="iPage">
<input type="hidden" name="s_dao_n3pty_bil_tp_cd" value="<%=s_dao_n3pty_bil_tp_cd%>">
<input type="hidden" name="s_n3pty_inv_if_tp_nm">
<input type="hidden" name="s_his_seq" value="<%=s_his_seq%>">
<input type="hidden" name="s_final_flg" value="<%=s_final_flg%>">
<input type="hidden" name="s_final_invoice" value="<%=s_final_invoice%>">
<input type="hidden" name="s_contact_info" value="">
<input type="hidden" name="s_n3pty_inv_his_seq" value="<%=s_inv_his_seq%>">
<input type="hidden" name="s_n3pty_inv_rmd_cd" value="<%=s_inv_rmd%>">
<input type="hidden" name="snd_edi_cd" value="<%=s_snd_edi%>">

<input type="hidden" name="s_clt_agn_flg" value="<%=s_clt_agn_flg%>">
<input type="hidden" name="s_n3pty_inv_sts_cd" value="<%=s_n3pty_inv_sts_cd%>">
<input type="hidden" name="s_issue_yn" value="<%=s_issue_yn%>">
<input type="hidden" name="s_erpif_yn" value="<%=s_erpif_yn%>">
<input type="hidden" name="s_inquiryOnly_yn" value="<%=s_inquiryOnly_yn%>">
<input type="hidden" name="s_bil_loc" value="<%=s_bil_loc%>">
<input type="hidden" name="receiver_id" value="">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Service Management > 3rd Party Billing > TPB Process > Invoice Preview</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Invoice Preview</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_print_only" id="btn_print_only">Print Only</td><td class="btn1_right"></td></tr></table></td> -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left" id="btn_print_only_left"></td><td class="btn1" name="btn_print_only" id="btn_print_only">Print Only</td><td class="btn1_right" id="btn_print_only_right"></td></tr></table></td>
								<% if(s_issue_yn.equals("Y")){ %>
								<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_issue_t">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_issue" id="btn_issue">Issue</td><td class="btn1_right"></td></tr></table></td> -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left" id="btn_issue_left"></td><td class="btn1" name="btn_issue" id="btn_issue">Issue</td><td class="btn1_right" id="btn_issue_right"></td></tr></table></td>
								<% } %>
								<% if(s_erpif_yn.equals("Y")){ %>
								<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_erpInterface_t" style="display:none;">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_erpInterface" id="btn_erpInterface">ERP Interface</td><td class="btn1_right"></td></tr></table></td> -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left" id="btn_erpif_left" style="display:none;"></td><td class="btn1" name="btn_erpif" id="btn_erpif" style="display:none;">ERP Interface</td><td class="btn1_right" id="btn_erpif_right" style="display:none;"></td></tr></table></td>
								<% } %>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Invoice No. ) (S) -->

<% if(s_issue_yn.equals("Y")){ %>
				<table class="search" border="0">
				<tr class="h23">
					<td width="80"><img class="nostar">Issue Type</td>
					<td width="97"><%=JSPUtil.getCodeCombo("s_n3pty_inv_if_tp_cd", "", "style='width:90', class='input1'  required caption='Issue Type'", "CD00869", 0, "001: :&lt;&lt;Select&gt;&gt;|")%></td>
					<td width="400"><div id = "comboset1"><script language="javascript">ComComboObject('combo1', 2, 300 , 0, 0, true, true )</script></div>
					<div id = "comboset2" style = "display:none;"><script language="javascript">ComComboObject('purpose',1, 300 , 1, true, true )</script></div></td>
					<td width="73">Invoice No.</td>
					<td width=""><input type="text" style="width:95;" name="s_n3pty_inv_no" value="<%=s_n3pty_inv_no%>" readonly> <input type="text" style="width:33;" name="s_n3pty_inv_rmd_cd" value="<%=s_inv_rmd%>" readonly></td>
				</tr>
				</table>
<% } else { %>
				<table class="search" border="0">
				<tr class="h23">
					<td width="75">Invoice No.</td>
					<td width=""><input type="text" style="width:95;" name="s_n3pty_inv_no" value="<%=s_n3pty_inv_no%>" readonly> <input type="text" style="width:33;" name="s_n3pty_inv_rmd_cd" value="<%=s_inv_rmd%>" readonly></td>
				</tr>
				</table>
<% } %>


				<!-- : ( Invoice No. ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<table width="100%" class="button">
       	<tr><td class="align">
			<table border=0>
				<tr>
					<td width =25></td>
					<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_first" id="btn_first">First</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_back" id="btn_back">Back</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_next" id="btn_next">Next</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_last" id="btn_last">Last</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_zoomIn" id="btn_zoomIn">Zoom In(+)</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_zoomOut" id="btn_zoomOut">Zoom Out(-)</td>
						<td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
				</tr>
			</table>
		</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search"><tr><td class="height_10"></td></tr></table>

				<!-- TABLE '#E' : ( Graph BG ) (S) -->
		     	<table class="search" border="0" style="width:100%;">
		       	<tr><td class="bg_b2" style="padding:0;" height="550">
					<script language="javascript">comRdObject('Rdviewer1');</script>

					<!-- <IFRAME marginWidth=0 marginHeight=0 src="UI_ESD_3PB_010_IN.html" frameBorder=0 width="100%" height="300" scrolling="auto"></IFRAME> -->

					<!--<br><br><p align="center"><b>SM LINE CORPORATION</b></p><br>-->
					</td></tr>
				</table>
				<!-- TABLE '#E' : ( Graph BG ) (E) -->

<div style="display: none">
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
</div>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>