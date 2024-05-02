<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4107.jsp
*@FileTitle : DEM/DET Fax Send(Fax/Email 송부시 송부대상을 선택하는 기능(pop-up))
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
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
	String s_cust_seq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
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
		s_cust_seq		= JSPUtil.getParameter(request,"cntc_seq");
		
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
<title>DEM/DET Fax Send</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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


<body class="popup_bg" onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="s_ofc_cd"	value="<%=s_ofc_cd %>">
<input type="hidden" name="s_cust_cd"	value="<%=s_cust_cd %>">
<input type="hidden" name="s_bkg_no"	value="<%=s_bkg_no %>">
<input type="hidden" name="s_pod_cd"	value="<%=s_pod_cd %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="s_cust_gubun"	value="<%=s_cust_gubun %>">
<input type="hidden" name="jspno"		value="<%=jspno %>">
<input type="hidden" name="s_attn"		value="<%=s_attn %>">
<input type="hidden" name="s_telno"		value="<%=s_telno %>">
<input type="hidden" name="s_faxno"		value="<%=s_faxno %>">
<input type="hidden" name="s_email"		value="<%=s_email %>">
<input type="hidden" name="s_cust_seq"	value="<%=s_cust_seq %>">
<input type="hidden" name="dmdt_payr_cntc_pnt_nm">
<input type="hidden" name="dmdt_payr_phn_no">
<input type="hidden" name="dmdt_payr_fax_no">
<input type="hidden" name="dmdt_payr_n1st_eml">

<!-- EMAIL, FAX SENDING -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add"   > <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="rd_fxeml_doc_tp"> <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="invno">
<input type="hidden" name="payc">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Fax Send
			</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
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
				<!-- : ( Button : Grid ) (S) -->
			
			
				<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
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
								<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_fax">Fax Send</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								<td class="btn1_line"></td>
								<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td></tr>
						</table>
					</td></tr>
				</table>
    <!--Button (E) -->
			</td></tr>
		</table>
<!-- : ( Button : pop ) (E) -->

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>	
<!-- RD OBJECT -->		
                    <table width="100%" height="1" id="mainTable"> 
                        <tr>
                            <td width="100%">
<script language='javascript'>comRdObject('invPreview',0,0);</script>
                            </td>
                        </tr>
                    </table>
			
</form>			
</body>
</html>

