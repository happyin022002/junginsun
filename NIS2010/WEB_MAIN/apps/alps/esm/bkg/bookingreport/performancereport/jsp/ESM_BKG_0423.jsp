<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0423.jsp
 *@FileTitle : Queue Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.30
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2011.05.30 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0423Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0423Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0423Event) request.getAttribute("Event");
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
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
<input type="hidden" name="f_cmd">


<!-- 개발자 작업	-->
<input type="hidden" name="grp_cd">
<input type="hidden" name="tmp_dura_from_dt">
<input type="hidden" name="tmp_dura_to_dt">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="usr_ofc_cd" value=<%=strOfc_cd%>>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
  <tr>
    <td valign="top">

      <!--Page Title, Historical (S)-->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
      </table>
      <!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
				<td width="60" align="left">Doc OFC</td>
				<td width="90"><script language="javascript">ComComboObject('dpcs_ofc_cd', 1, 85, '');</script></td>
                <td width="22"><input type="radio" class="trans" name="chk_key" value="DT" checked></td>
                <td width="50">Period </td>
                <td width="200">&nbsp;<input type="text" style="width:70" maxlength="10" dataformat="ymd" name="dura_from_dt" value="<%= DateTime.addDays(JSPUtil.getKST("yyyy-MM-dd"), -1, "yyyy-MM-dd") %>" class="input1">&nbsp;~&nbsp;<input type="text" style="width:70"  maxlength="10" dataformat="ymd" name="dura_to_dt" value="<%=JSPUtil.getKST("yyyy-MM-dd") %>" class="input1">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_dura_date"></td>
                
                <td width="22"><input type="radio" class="trans" name="chk_key" value="VVD"></td>
                <td width="40">VVD</td>
                <td width="90"><input type="text" style="width:80;ime-mode:disabled" name="vvd_cd" maxlength="9" fullfill dataformat="engupnum" class="input" caption="VVD"></td>
                
                <td width="22"><input type="radio" class="trans" name="chk_key" value="BKG"></td>
                <td width="50">BKG No.</td>
                <td width="130"><input type="text" style="width:120;ime-mode:disabled" name="bkg_no" maxlength="13" dataformat="engupnum" class="input" caption="BKG NO"></td>
                <td width="80"></td>
                <td>Set Search&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name="btn_SRCH_SET" align="absmiddle">
                  <input type="checkbox" value="Y" name="set_slct_flg" class="trans" tabindex="6"></td>
              </tr>
            </table>
            <table class="search" border="0" style="width:979;">
              <tr class="h23">              	
                <td width="60">Region </td>
                <td width="90"><script language="javascript">ComComboObject("rgnCdCombo", 2, 85, 1, 0, 1);</script></td>
                <td width="30">STS</td>
                <td width="85"><script language="javascript">ComComboObject("sts", 2, 80, 1, 0, 1);</script></td>
                <td width="30">SRC</td>
                <td width="70"><script language="javascript">ComComboObject("src_cd", 2, 65, 1, 0, 1);</script></td>                
                <td width="35">Kind</td>
                <td width="85"><script language="javascript">ComComboObject("sr_amd_tp_cd", 1, 75, 1, 0, 1);</script></td>
                
                
                <td width="40">Input</td>
                <td width="55"><script language="javascript">ComComboObject("input", 1, 50, 1, 0, 1);</script></td>
                <td width="35">Rate</td>
                <td width="55"><script language="javascript">ComComboObject("rate", 1, 50, 1, 0, 1);</script></td>
                <td width="20">QA</td>
                <td width="55"><script language="javascript">ComComboObject("qa", 1, 50, 1, 0, 1);</script></td>
                <td width="60">BL Proof</td>
                <td width="55"><script language="javascript">ComComboObject("fax", 1, 50, 1, 0, 1);</script></td>
                <td width="60">RTN OFC</td>
                <td><input type="text" style="width:60;ime-mode:disabled" name="return_to" maxlength="6" dataformat="engup" class="input"></td>
              </tr>
            </table>
            <table class="search" border="0" style="width: 979;">
              <tr class="h23">              
                <td width="60">BKG OFC</td>
                <td width="68"><input type="text" style="width:60;ime-mode:disabled"  name="bkg_ofc_cd" maxlength="6" dataformat="engup" class="input"></td>
                
                <td width="40">Lane</td>
                <td width="55"><script language="javascript">ComComboObject("slan_cd", 2, 50, 0, 0, 0);</script></td>
                
              	<td width="30">POL</td>
                <td width="70"><input type="text" style="width:60;ime-mode:disabled" name="pol_cd" maxlength="5" dataformat="engupnum" class="input" caption="POL"></td>
                <td width="30">POD</td>
                <td width="70"><input type="text" style="width:60;ime-mode:disabled" name="pod_cd" maxlength="5" dataformat="engupnum" class="input"></td>
                
                <td width="65">Customer</td>
                <td width="270"><script language="javascript">ComComboObject("bkg_cust_tp_cd", 1, 45, 1, 0, 1);</script>
                  <input type="text" style="width: 25;" class="input" dataformat="engup" maxlength="2" name="cust_cnt_cd" tabindex="41">
                  <input type="text" style="width: 50;" class="input" dataformat="int" maxlength="6" name="cust_seq" tabindex="42">
                  <input type="text" style="width: 135;" class="input" dataformat="etc" maxlength="500" name="cust_nm" tabindex="43"></td>
                <td width="65">Sales Rep</td>
                <td width="60"><input type="text" style="width:50;ime-mode:disabled" name="srep_cd" maxlength="6" dataformat="engupnum" class="input"></td>
                
                <td>SPLIT BKG&nbsp;<input type="checkbox" value="Y" name="split_only_flg" class="trans" tabindex="6"></td>
                <td></td>
              </tr>
            </table>
            <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td></td></tr></table>


      <!-- Tab (S) -->
      <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr><td width="100%"><script language="javascript">ComTabObject("tab1")</script></td></tr>
      </table>
      <!-- Tab (E) -->


      <div id="tabLayer" style="display:inline">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-1 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td></tr>
              </table>
              <!-- Grid-1 (E) -->

              <!-- Grid_button-1 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet1">Down&nbsp;Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!-- Grid_button-1 (E) -->

            </td>
          </tr>
        </table>
      </div>


      <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-2 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td></tr>
              </table>
              <!-- Grid-2 (E) -->

              <!-- Grid_button-2 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet2">Down&nbsp;Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!-- Grid_button-2 (E) -->

            </td>
          </tr>
        </table>
      </div>


      <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-3 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet3");</script></td></tr>
              </table>
              <!-- Grid-3 (E) -->

              <!-- Grid_button-3 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet3">Down&nbsp;Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!-- Grid_button-3 (E) -->

            </td>
          </tr>
        </table>
      </div>


      <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-4 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet4");</script></td></tr>
              </table>
              <!-- Grid-4 (E) -->

              <!-- Grid_button-4 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet4">Down&nbsp;Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!-- Grid_button-4 (E) -->

            </td>
          </tr>
        </table>
      </div>


      <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-5 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet5");</script></td></tr>
              </table>
              <!-- Grid-5 (E) -->

              <!-- Grid_button-5 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet5">Down&nbsp;Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!-- Grid_button-5 (E) -->

            </td>
          </tr>
        </table>
      </div>


      <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-6 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet6");</script></td></tr>
              </table>
              <!-- Grid-6 (E) -->

              <!-- Grid_button-6 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet6">Down&nbsp;Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!-- Grid_button-6 (E) -->

            </td>
          </tr>
        </table>
      </div>


    </td>
  </tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; ">
  <tr>
    <td class="btn1_bg">
      <table border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_New">New</td>
                <td class="btn1_right"></td>
              </tr>
            </table></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->


</form>
<form name="form2" method="POST">
	<input type="hidden" name="message">
</form>
</body>
</html>