<%/*=========================================================
     *Copyright(c) 2016 CyberLogitec
     *@FileName : CPS_GEM_0036.jsp
     *@FileTitle :  [CPS_GEM_0036] CSR No. Reference
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2016.06.10
     *@LastModifier : 채창호
     *@LastVersion : 1.0
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0036Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    CpsGem0036Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String ofc_cd ="";
	String usrAuthTpCd = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.gem.gemconsultationslip.basic.GEMConsultationSlipBC");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofc_cd    = account.getOfc_cd();
        usrAuthTpCd = account.getUsr_auth_tp_cd();
        event = (CpsGem0036Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
 %>
<head>
<title>CSR No. Reference</title>
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

<body CLASS="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="auth_flg">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="subs_ofc_cd">
<input type="hidden" name="hpln_yr">
<input type="hidden" name="hpln_mon">
<input type="hidden" name="pln_yr">
<input type="hidden" name="pln_mon">
<input type="hidden" name="login_ofc_cd">
<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR No. Reference</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="80">Input Date</td>
                    <td width="200"><input type="text" name="period_stdt" style="width:70;ime-mode:disabled" value="" class="input1"  maxlength="8" dataformat="ymd" >&nbsp;~&nbsp;<input type="text" name="period_eddt" style="width:70;ime-mode:disabled" value="" class="input1" maxlength="8" dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>
                    
                    <td width="190"> <input type="checkbox" value="" class="trans" checked disabled>BU 
					<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HO');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO 
					<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HQ');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ
				    </td>
                    <td width="350">
                    <select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl3">
						</select>&nbsp;</td>
                    </td>
                </tr> 
                </table>                
                <!--  biz_1   (E) -->
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid  (S) -->
                <table width="100%" id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->   
            
        </td></tr></table>
        <!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
        
        <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Select">Select</td>
                    <td class="btn1_right"></td>
                </tr></table></td>  
               <td class="btn1_line"></td>     
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>                
            </tr>
        </table>
        <!--Button (E) -->
    
		</td>
		
		</tr>
		</table>
		
</td>
</tr>
</table>		
<!-- : ( Button : pop ) (E) -->


 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>