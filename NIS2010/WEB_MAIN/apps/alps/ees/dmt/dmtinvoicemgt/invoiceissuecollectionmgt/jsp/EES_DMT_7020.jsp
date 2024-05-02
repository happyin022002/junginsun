<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DMT_7020.jsp
*@FileTitle : DEM/DET Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2009.10.19 김기태
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt7020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		event = (EesDmt7020Event)request.getAttribute("Event");
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
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="dmdt_payr_nm">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="sys_area_grp_id">
<input type="hidden" name="s_ofc_cd"	value="<%=strUsr_ofc %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="s_cust_gubun"	value="<%=s_cust_gubun %>">
<input type="hidden" name="success_yn">
<input type="hidden" name="jspno"		value="<%=jspno %>">

<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>"><!-- invoice 저장 권한 코드 -->
<input type="hidden" name="pgm_no" value="<%=event.getProgramNo() %>"><!-- Program No 구분 -->
<input type="hidden" name="intg_cd_id" >
<input type="hidden" name="snd_cyc_cd" >
<input type="hidden" name="sp_yn" >
<input type="hidden" name="eml_exist_flg" >
<input type="hidden" name="ots_email_flg" >


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<table class="height_8"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">       		
       			<table border="0" cellpadding="0" cellspacing="0">
	       			<tr class="h23">
	       				<td width="120">SVR ID&nbsp;&nbsp;<script language="javascript">ComComboObject('svr_id',1,60,1);</script></td>
						<td width="165">Payer Type&nbsp;&nbsp;<script language="javascript">ComComboObject('payer_type',1,80,1);</script></td>
	       				<td width="175">Payer Code&nbsp;&nbsp;<input type="text" id = "payr_cd" name="payr_cd" style="width:65;" dataformat="engup" class="input" caption="Payer" maxlength="8" minlength="8" style="236;" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_cust_cd" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="215">Sending Cycle&nbsp;&nbsp;<script language="javascript">ComComboObject('sending_cycle',1,90,1);</script>&nbsp;<img src="img/btns_multisearch.gif" width="17" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width="175">Email Address Exist&nbsp;&nbsp;<script language="javascript">ComComboObject('email',1,40,1);</script></td>
						<td width=""><input type="checkbox" name="otsEmailFlg" class="trans" >OTS email address</td>
	       			</tr>
       			</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- : ( Grid ) (S) -->
				
					<!--Grid (S)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
					<!--Grid (E)-->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
	<tr><td class="btn1_bg">
    	<table border="0" cellpadding="0" cellspacing="0">
		<tr>           
           <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
               <tr><td class="btn1_left"></td>
               <td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
               <td class="btn1" name="btn_detail">Detail</td>
               <td class="btn1_right"></td>
               </tr>
               </table>
           <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
               <tr><td class="btn1_left"></td>
               <td class="btn1" name="btn_down_excel">Down Excel</td>
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
