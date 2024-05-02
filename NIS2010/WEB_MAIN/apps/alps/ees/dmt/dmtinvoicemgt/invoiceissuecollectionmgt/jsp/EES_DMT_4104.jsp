<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4104.jsp
*@FileTitle : DEM/DET Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.19 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F 버튼 권한 부여
	int i_cnt = 0;
	
	//Parameter
	String s_ofc_cd = "";
	String s_cust_cd = "";
	String s_bkg_no = "";
	String s_pod_cd = "";
	String s_cust_gubun = "";
	String jspno = "";
	String s_attn = "";
	String s_telno = "";
	String s_faxno = "";
	String s_email = "";
	String svrId = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		//권한부여 체크 추가(2010.04.08)-- 로그인 User의 Role이 DMT01, DMT02, DMT03, DMT04가 아닐 경우
		//							   "You have no authority to XXXX!" alert 창을 띄우며 막음
		/**************************************
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");
				
				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}
		
		log.debug("[USER_AUTH]"+sb.toString());
		******************************************/
		
		event = (EesDmt4104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		s_ofc_cd		= JSPUtil.getParameter(request,"s_ofc_cd");
		s_cust_cd		= JSPUtil.getParameter(request,"s_cust_cd");
		s_bkg_no		= JSPUtil.getParameter(request,"s_bkg_no");
		s_pod_cd		= JSPUtil.getParameter(request,"s_pod_cd");
		jspno			= JSPUtil.getParameter(request,"jspno");
		s_attn			= JSPUtil.getParameter(request,"attn");
		s_telno			= JSPUtil.getParameter(request,"telno");
		s_faxno			= JSPUtil.getParameter(request,"faxno");
		s_email			= JSPUtil.getParameter(request,"email");
		svrId			= JSPUtil.getParameter(request,"svr_id");
		sec_invoice = eventResponse.getETCData("ROLE_AUTH_FLAG"); // 화면별 사용자 Role 권한 Flag 반환
		log.debug("\n[USER_AUTH] = "+ sec_invoice);
		
		//VENDOR
		if(s_cust_cd.length() == 6) {
			s_cust_cd	= "00" + s_cust_cd;
			s_cust_gubun = "1";
		}else{
			s_cust_gubun = "2";
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DEM/DET Payer Info & Fax/E-mail</title>
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


<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="dmdt_payr_nm"> 
<input type="hidden" name="svr_id"	value="<%=svrId %>">
<input type="hidden" name="s_ofc_cd"	value="<%=s_ofc_cd %>">
<input type="hidden" name="s_cust_cd"	value="<%=s_cust_cd %>">
<input type="hidden" name="s_bkg_no"	value="<%=s_bkg_no %>">
<input type="hidden" name="s_pod_cd"	value="<%=s_pod_cd %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="s_cust_gubun"	value="<%=s_cust_gubun %>">
<input type="hidden" name="success_yn">
<input type="hidden" name="jspno"		value="<%=jspno %>">
<input type="hidden" name="s_attn"		value="<%=s_attn %>">
<input type="hidden" name="s_telno"		value="<%=s_telno %>">
<input type="hidden" name="s_faxno"		value="<%=s_faxno %>">
<input type="hidden" name="s_email"		value="<%=s_email %>">

<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>"><!-- invoice 저장 권한 코드 -->

<input type="hidden" name="ots_snd_flg">
<input type="hidden" name="intg_cd_id">

<input type="hidden" name="snd_cyc_cd">
<input type="hidden" name="ots_sh_grp_cd">
<input type="hidden" name="snd_cntr_list_flg">
<input type="hidden" name="snd_inv_flg">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;DEM/DET Payer Info & Fax/E-mail
			</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<!-- : ( Grid ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Invoice Sheet</td></tr>
				</table>
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="20%">Customer Code</td>
					<td class="input2" width="10%"><input type="text" name="cust_cd" style="width:100%" value="" class="noinput2" readonly></td>
					<td class="tr2_head" width="15%">VAT No.</td>
					<td class="input2" width="25%"><input type="text" name="cust_rgst_no" style="width:100%" value="" class="noinput2" readonly></td>
					<td class="tr2_head" width="15%">TAX INV Issue</td>
					<td class="input2"><input type="text" name="iss_div_nm" style="width:100%" value="" class="noinput2" readonly></td>
				</tr>
				<tr><td class="tr2_head" width="15%"> Name</td>
					<td class="input" colspan="5">
					<script language="javascript">ComComboObject('payer_name',3,377,0,0,2,true);</script>
					</td>
				</tr>
				<tr><td class="tr2_head" width="15%" rowspan="2">Address</td>
					<td class="input" colspan="5"><script language="javascript">ComComboObject('payer_addr',3,377,1,0,4,false);</script>
					</td>
				</tr>	
				<tr>
					<td class="input" colspan="5"><textarea name="dmdt_payr_addr" cols="" rows="4" style="width:100%"></textarea>
					</td>
				</tr>		
				<tr><td class="tr2_head" width="15%">ATTN</td>
					<td class="input2" colspan="5"><input name="dmdt_payr_cntc_pnt_nm" type="text" style="width:100%" value="" class="noinput2" readonly></td>
				</tr>
				<tr><td class="tr2_head" width="15%">Tel.</td>
					<td class="input2" colspan="5"><input name="dmdt_payr_phn_no" type="text" style="width:100%" value=" " class="noinput2" readonly></td>
				</tr>
				<tr><td class="tr2_head" width="15%">Fax</td>
					<td class="input2" colspan="5"><input name="dmdt_payr_fax_no" type="text" style="width:100%" value=" " class="noinput2" readonly></td>
				</tr>
				<tr><td class="tr2_head" width="15%">E-mail</td>
					<td class="input2" colspan="5"><input name="dmdt_payr_n1st_eml" type="text" style="width:100%" value=" " class="noinput2" readonly></td>
				</tr>
				</table> 
				<table class="height_10"><tr><td></td></tr></table>
				
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Fax/E-mail</td></tr>
				</table>
				
					<!--Grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
					<!--Grid (E)-->
				<!--  Button_Sub (S) -->
		<%if(!jspno.equals("EES_DMT_7021")) { %>
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<!-- 
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowcopy">Row Copy</td>
						<td class="btn2_right"></td>
 						</tr>
						</table></td>
-->						
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowdel">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
		<%} %>			
	    	<!-- Button_Sub (E) -->
	    	
	    	<table class="height_10"><tr><td></td></tr></table>
	    	
	    	<!-- : ( OTS Sending Option ) (S) -->
	    	
	    	<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Auto Sending Option (* USA and Canada Only)</td></tr>
			</table>
			
			<table border="0" style="width:100%; class="search"> 
				<tr class="h23">
					<td width="100">Sending Cycle</td>
					<td width="160"><script language="javascript">ComComboObject('sending_cycle',1,130,1);</script></td>
					<td width="80">OTS Sheet</td>
					<td class="stm" style="text-align: left;">
						Group by&nbsp;&nbsp;<script language="javascript">ComComboObject('ots_sheet_group',1,90,1);</script>&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="with_cntr">&nbsp;With CNTR List
<!-- 						&nbsp;&nbsp;|&nbsp;&nbsp; -->
<!-- 						<input type="checkbox" class="trans" name="with_inv">&nbsp;With Invoice</td> -->
				</tr>
			</table>
			
			<!-- : ( OTS Sending Option ) (E) -->
			
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    <%if(!jspno.equals("EES_DMT_7021")) { %>
				<td width="" id="save_btn_border">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn2_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
 				<td class="btn1_line"></td>
 			<%} %>
				<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn2_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table> 
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet2');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
			
</form>			
</body>
</html>
