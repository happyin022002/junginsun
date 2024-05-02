<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0237.jsp
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
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0237Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0237Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strCustCntCd ="";
	String strCustSeq="";
	String strBkgOfcCd="";
	String strTabIdx="";
	String strOpenMode="";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCustCntCd = StringUtil.xssFilter(request.getParameter("cust_cnt_cd"));
		strCustSeq = StringUtil.xssFilter(request.getParameter("cust_seq"));
		strBkgOfcCd = StringUtil.xssFilter(request.getParameter("bkg_ofc_cd"));
		strTabIdx = StringUtil.xssFilter(request.getParameter("tab_idx"));
		strOpenMode = StringUtil.xssFilter(request.getParameter("open_mode"));
		
		event = (EsmBkg0237Event) request.getAttribute("Event");
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
<title>Customer Check Point</title>
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
<input type="hidden" name="tab_idx" value=<%=strTabIdx%>>

<!-- 개발자 작업	-->
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
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Customer Check Point</td>
        </tr>
      </table>
      <!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->            
            
            <table class="search" border="0" style="width: 979;">
              <tr class="h23">
              
                <td width="65">Customer</td>
                <td width="270">
                  	<input type="text" name="cust_cnt_cd" style="width: 25;" maxlength="2" class="input1" dataformat="engup" value="<%=strCustCntCd%>">
					<input type="text" name="cust_seq" maxlength=6 style="width: 55;" class="input1" dataformat="engupnum"  value="<%=strCustSeq%>">
					<input type="text" name="cust_nm" style="width: 133;" class="input2" readOnly tabindex="-1">
					<img src="img/btns_search.gif" name="btn_custPop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                
                <td width="60">BKG OFC</td>
                <td width="68"><input type="text" name="bkg_ofc_cd" maxlength=6 style="width: 70;" class="input1" dataformat="engupnum" value="<%="".equals(strBkgOfcCd)?strOfc_cd:strBkgOfcCd%>"></td>
                
                
                <td>&nbsp;<input type="checkbox" value="Y" name="delt_flg" class="trans" tabindex="6">&nbsp;include Del</td>
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
<% if (!"R".equals(strOpenMode)){ %>                      
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet1">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet1">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet1">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet1">Down Excel</td>
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
<% if (!"R".equals(strOpenMode)){ %>                      
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet2">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet2">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet2">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                            <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet2">Down Excel</td>
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
<% if (!"R".equals(strOpenMode)){ %>                      
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet3">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet3">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet3">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet3">Down Excel</td>
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
<% if (!"R".equals(strOpenMode)){ %>                      
                       	<td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet4">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet4">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet4">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet4">Down Excel</td>
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
<% if (!"R".equals(strOpenMode)){ %>                      
                       	<td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet5">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet5">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet5">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                           <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet5">Down Excel</td>
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
<% if (!"R".equals(strOpenMode)){ %>                      
                        <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet6">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet6">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet6">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet6">Down Excel</td>
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
	
	 <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg">

              <!-- Grid-6 (S) -->
              <table width="100%" class="search" id="mainTable">
                <tr><td width="100%"><script language="javascript">ComSheetObject("sheet7");</script></td></tr>
              </table>
              <!-- Grid-6 (E) -->

              <!-- Grid_button-6 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
                      <tr>
<% if (!"R".equals(strOpenMode)){ %>                      
                       	<td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowAdd_sheet7">Row&nbsp;Add</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_RowDel_sheet7">Row&nbsp;Delete</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_Save_sheet7">Save</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table></td>
<%} %>                          
                          <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="btn_DownExcel_sheet7">Down Excel</td>
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
<script language="javascript">ComSheetObject("sheet8");</script>
<script language="javascript">ComSheetObject("sheet9");</script>
<script language="javascript">ComSheetObject("sheet10");</script>
<script language="javascript">ComSheetObject("sheet11");</script>
<script language="javascript">ComSheetObject("sheet12");</script>
<script language="javascript">ComSheetObject("sheet13");</script>
<script language="javascript">ComSheetObject("sheet14");</script>
<script language="javascript">ComSheetObject("sheet15");</script>
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message">
</form>
</body>
</html>