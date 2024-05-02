<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1070.jsp
 *@FileTitle : China: Manifest Transmission(CNYIT)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.16
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.11.16 이수빈
 * 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1070Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1070Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
    String strCnt_cd   = "";
    String strOff_cd   = "";
	
	String strPgmNo    = "";
	String strTransMode = "";
    String strLocNm    = "";
    boolean saveCsvFlg  = false;  // Save CSV 버튼 활성화여부
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.Customstransmission");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOff_cd = account.getOfc_cd();

		event = (EsmBkg1070Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>China: Manifest Transmission</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd.substring(0,2)%>">
<input type="hidden" name="eta_flg">
<input type="hidden" name="etd_flg">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23"> 
                    <td width="60">VVD</td> 
                    <td width="195"><input type="text" name="vvd" style="width:80; ime-mode: disabled;" class="input1"
                                        dataformat="eng" maxlength="9" required fullfill caption="VVD"></td> 
                    <td width="60">POL</td> 
                    <td width="170"><input type="text" name="loc_cd" style="width:60; ime-mode: disabled;" class="input1" value="CNYIT"
                                        dataformat="engupnum" maxlength="5" required fullfill caption="POL"></td>
                    <td width="80">B/L TYPE</td> 
                    <td width=""><select style="width:71;" name="bl_type" class="input1">
                        <option value="A" selected>All</option>
                        <option value="N">Original</option>
                        <option value="S">Replace</option>
                        <option value="C">Cancel</option>
                        </select></td> 
                    <td width="80">ZONE</td> 
                    <td width=""><select style="width:71;" name="zone" class="input1">
                        <option value="A" selected>All</option>
                        <option value="I">IPT</option>
                        <option value="O">OCN</option>
                        </select></td> 
                </tr>
                </table>    
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>  
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23"> 
                    <td width="60">Call Sign</td>
                    <td width="195"><input type="text" name="call_sgn_no" style="width:150;" class="input" disabled></td> 
                    <td width="60">Pre. Port</td> 
                    <td width="170"><input type="text" name="pre_port" style="width:60;" class="input" disabled></td> 
                    <td width="80">Next Port</td>
                    <td width="150"><input type="text" name="nxt_port" style="width:60;" class="input" disabled></td> 
                    <td width="80">Send Date</td>
                    <td width=""><input type="text" name="snd_date" style="width:120;" class="input" disabled></td> 
                    </tr>
                </table>
                <table class="search" border="0"  style="width:979;"> 
                <tr class="h23"> 
                    <td width="60">ETA</td>
                    <td width="195"><input type="text" name="vps_eta_dt" style="width:150;" class="input" disabled></td> 
                    <td width="60">ETD</td>
                    <td width="170"><input type="text" name="vps_etd_dt" style="width:150;" class="input" disabled></td> 
                    <td width="80">Vessel Name</td> 
                    <td width=""><input type="text" name="vsl_eng_nm" style="width:230;" class="input" disabled></td> 
                </tr>
                </table>            
                <!--  biz_1   (E) -->   
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>  
            
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr width = "100%">
                        <td width="100%" style="font size:11;">* Beijing Standard Time (GMT +08:00)</td>
                    </tr> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>            
                <!-- Grid (E) -->   
	            <table class="height_2"><tr><td></td></tr></table>          
	            <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="650"> </td>
                    <td width="70">B/L Count</td>
                    <td width="120"><input type="text" name="bl_cnt" style="width:80;text-align:right;" class="input2" readonly></td>
                    <td width="85">CNTR Count</td>
                    <td width=""><input type="text" name="cntr_cnt" style="width:80;text-align:right;" class="input2" readonly></td>
                </tr> 
                </table>    
                <!--  biz_1   (E) -->
            
            </td></tr>
        </table>
        <!--biz page (E)-->

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
                    <td class="btn1" name="btn_excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
	            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                <tr><td class="btn1_left"></td>
	                <td class="btn1" name="btn_Transmit">Transmit</td>
	                <td class="btn1_right"></td>
	                </tr>
	            </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->

</td></tr>
</table>
	
        <!--임시 (S)
        <table style="width:979;height:100">
            <tr><td>result : </td></tr>
            <tr>
                <td><textarea name="output" cols="100" rows="20"></textarea></td>
            </tr>
        </table>
        -->
        
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>