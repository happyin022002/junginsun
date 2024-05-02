<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0904.jsp
*@FileTitle : Container Export EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.09.29 이수빈
* 1.0 Creation
* 20110930 전성진 [CHM-201113593] Coparn 전송시 Fowarder code 값 크기 변경 (8 digit ->10 digit)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0904Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0904Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

    String bkgNo = "";
    String polCd = "";
    String prefix = "form_";
    String rcvId = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		bkgNo = JSPUtil.getNullNoTrim(request.getParameter("bkg_no"));
        polCd = JSPUtil.getNullNoTrim(request.getParameter("pol_cd"));
        rcvId = JSPUtil.getNullNoTrim(request.getParameter("rcv_Id"));

		event = (EsmBkg0904Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        codeList = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Export EDI</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="code_list" value="<%=codeList%>">
<input type="hidden" name="rcv_id" value="<%=rcvId%>">
<input type="hidden" name="<%=prefix%>cntr_type" value="">
<input type="hidden" name="<%=prefix%>grs_wgt" value="">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Container Export EDI</td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			
                <table class="grid2" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="100" class="tr2_head">Booking No.</td> 
                    <td width="130" class="noinput2" colspan="2"><input type="text" name="<%=prefix%>bkg_no" style="width:100" class="noinput2" value="<%=bkgNo%>" readonly></td>
                    <td width="110" class="tr2_head">Code Operation</td> 
                    <td width="<%=prefix%>code_opr" class="noinput1">
                        <script language="javascript">ComComboObject('form_code_opr', 1, 100, 1, 1);</script>
                    </td>
                </tr>
                <tr class="h23">
                    <td width="100" class="tr2_head">Terminal VVD</td> 
                    <td width="130" class="noinput" colspan="2"><input type="text" name="<%=prefix%>term_vvd" style="width:130;ime-mode:disabled;" class="noinput"
                                                                    dataformat="eng" maxlength="20" required caption="Terminal VVD"></td>
                    <td width="110" class="tr2_head">SML VVD    </td>   
                    <td width="" class="noinput2"><input type="text" name="<%=prefix%>hjs_vvd" style="width:100" class="noinput2" readonly></td>
                </tr>
                <tr class="h23">
                    <td width="100" class="tr2_head">Terminal POL   </td> 
                    <td width="130" class="noinput1" colspan="2"><input type="text" name="<%=prefix%>term_pol" style="width:100;ime-mode:disabled;" class="noinput1"
                                                                    dataformat="engupnum" maxlength="5" caption="Terminal POL"></td>
                    <td width="110" class="tr2_head">SML POL    </td>   
                    <td width="" class="noinput2"><input type="text" name="<%=prefix%>hjs_pol" style="width:100" class="noinput2" readonly></td>
                </tr>
                <tr class="h23">
                    <td width="100" class="tr2_head">Terminal POD   </td> 
                    <td width="130" class="noinput" colspan="2"><input type="text" name="<%=prefix%>term_pod" style="ime-mode:disabled;" class="noinput"
                                                                    dataformat="engupnum" maxlength="5" caption="Terminal POD"></td>
                    <td width="110" class="tr2_head">SML POD    </td>   
                    <td width="" class="noinput2"><input type="text" name="<%=prefix%>hjs_pod" style="width:100" class="noinput2" readonly></td>
                </tr>
                <tr class="h23">
                    <td width="100" class="tr2_head">Fw Agent Code</td> 
                    <td width="40" class="noinput1" ><input type="text" name="<%=prefix%>fwrd_agn_cd1" style="width:38;ime-mode:disabled;" class="noinput1" value="230" readonly></td>
                    <td width="90" class="noinput1" ><input type="text" name="<%=prefix%>fwrd_agn_cd" style="width:88;ime-mode:disabled;" class="noinput1"
                                                                     maxlength="10" required caption="Fw Agent Code"></td>
                    
                    <td width="110" class="tr2_head">TMNL Berth CD</td> 
                    <td width="" class="noinput1">
                        <select name="<%=prefix%>tmnl_brth_cd" style="width:100%;" class="noinput1">    
                        <option value="TNONOR">TNONOR</option>
                        <option value="TNOOCE">TNOOCE</option>
                        <option value="EUR">EUR</option>
                        <option value="TAW">TAW</option>
                        <option value="TPO">TPO</option>
                        <option value="TDF">TDF</option>
                        </select></td>
                </tr>
                <tr class="h23">
                    <td width="100" class="tr2_head">Haulage Mode</td> 
                    <td width="130" class="noinput1" colspan="2">
                        <script language="javascript">ComComboObject('form_haul_mode', 1, 130, 1, 1);</script>
                    </td>
                    <td width="110" class="tr2_head">Mode of Transport</td>     
                    <td width="" class="noinput1">
                        <select name="<%=prefix%>tran_mode" style="width:100%;" class="noinput1">    
                        <option value="B">Barge</option>
                        <option value="R">Rail</option>
                        <option value="T">Truck</option>
                        </select></td>
                </tr>
                </table>
                
                <table class="height_5"><tr><td></td></tr></table>
            
                <!--table class="grid2" border="0" style="width:230;"> 
                <tr class="tr2_head">
                    <td width="90" colspan="2">Type/Size</td> 
                    <td width="40">QTY</td>
                    <td width="100">Gross Weight</td>
                </tr>
                <tr class="h23">
                    <td width="30" class="noinput"><input type="text" name="<%=prefix%>cntr_type" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput"
                                                        dataformat="eng" maxlength="2" caption="Type" readonly></td>
                    <td width="60" class="noinput"><input type="text" name="<%=prefix%>cntr_size" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput"
                                                        dataformat="int" maxlength="2" caption="Size" readonly></td>
                    <td width="" class="noinput"><input type="text" name="<%=prefix%>cntr_qty" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput" readonly></td>
                    <td width="" class="noinput1"><input type="text" name="<%=prefix%>grs_wgt" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput1"
                                                        dataformat="float" maxlength="10" required caption="Gross Weight"></td>
                </tr>
                </table-->
                <table width="100%"  id="mainTable"> 
				    <tr>
				        <td width="100%">
				            <script language="javascript">ComSheetObject('sheet2');</script>
				        </td>
				    </tr>
				</table>  
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<table width="100%"  id="mainTable"> 
    <tr>
        <td width="100%">
            <script language="javascript">ComSheetObject('sheet1');</script>
        </td>
    </tr>
</table>  	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_EDI">EDI</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close" onclick="self.close()">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            </tr>
            </table>
	</td></tr>
    </table>	
</td></tr>
</table>	
<!-- : ( Button : pop ) (E) -->	


   
</form>			
</body>
</html>