<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0330.js
*@FileTitle : 
*Open Issues :
*Change history :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0330");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Average U/C_Vessel Pooling</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_yrtype" value="M" >
<input type="hidden" name="f_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="f_cobcost">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>               
                <td>
                  <table id="t_btn_save" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_save" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table id="t_btn_month_copy" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_month_copy" name="btn_month_copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_down_excel" name="btn_down_excel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button_L (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="68">YYYY-MM</td>
                <td width="62"><input type="text" class="input1" style="width:56" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                <td width="190" class="sm"><div id="div_period"></div></td>
                <td width="40">Class</td>
				<td width="" style="padding-left: 5;">
					<script language="javascript">ComComboObject('f_selclass',1, 100 , 0 )</script>
				</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>

      <!-- Tab ) (S) -->
      <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr>
          <td width="100%">
            <script language="javascript">ComTabObject('tab1')</script>
          </td>
        </tr>
      </table>
<%
for (int sheetNo = 1; sheetNo <= 11; sheetNo++) {
	if(sheetNo == 1) {
%>
      <div id="tabLayer" style="display:inline">
      	<table class="search" border="0">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr>
              	<td class="gray" width="">&nbsp;</td>
                <td class="gray" width="90"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:setVSLRegister()" class="purple">VSL register</a></td>
                <td class="gray" width="90"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:setCostDetail()" class="purple">Cost detail</a></td>
              </tr>
              <tr><td height="3"></td></tr>
            </table>
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject("t"+<%=sheetNo%>+"sheet1");</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
<%
	}else if(sheetNo == 11){
%>
	<div id="tabLayer" style="display: none">
	  	<table class="search" border="0">
        <tr>
          <td class="bg">
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="30">From</td>
                <td width="58"><input type="text" class="input1" style="width:56" name="f_fmyearmonth" maxlength="6" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber('uppernum')"></td>
                <td width="30">&nbsp;~&nbsp;&nbsp;&nbsp;To</td>
                <td width="58"><input type="text" class="input1" style="width:56" name="f_toyearmonth" maxlength="6" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber('uppernum')"></td>
                <td width="60"></td><td width="60"></td><td width="60"></td><td width="60"></td>
                <td width="60"></td><td width="60"></td><td width="60"></td><td width="60"></td> 
                <td width="60"></td><td width="60"></td><td width="60"></td>
              </tr>
            </table>
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject("t"+"11"+"sheet1");</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>  
<%
	}else{
%>
      <div id="tabLayer" style="display: none">
      	<table class="search" border="0">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr>
              	<td class="gray" width="">&nbsp;</td>
                <td class="gray" width="90"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:setVSLRegister()" class="purple">VSL register</a></td>
                <td class="gray" width="90"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:setCostDetail()" class="purple">Cost detail</a></td>
              </tr>
              <tr><td height="3"></td></tr>
            </table>
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject("t"+<%=sheetNo%>+"sheet1");</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
<%
	}
%>
        
<%
}
%>	  
      <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
