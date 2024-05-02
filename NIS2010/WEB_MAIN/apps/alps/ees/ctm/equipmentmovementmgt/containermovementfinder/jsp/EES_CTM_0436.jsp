<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_CTM_0436.jsp
*@FileTitle : Movement Correction Monitoring 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.02.29 홍성필
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0436Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0436Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id    = "";
  String strUsr_nm    = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.LongTxContainerMovementFinder");

  try {
       SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();


    event = (EesCtm0436Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }

  // Duration 종료일(현재일)
  String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration 시작일(현재일 -7)
  String pDate1 = DateTime.addDays(pDate2, -7, "yyyy-MM-dd");
%>
<html>
<head>
<title>Movement Correction Monitoring </title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_cmd">
<!-- 개발자 작업 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_1  (S) -->
            <table class="search" border="0" width="100%"">
              <tr>
                <td width="35%">
                  <table class="search_sm" border="0" style="width:100%;">
                    <tr class="h23">
                      <td width="5"><input type="radio" name="divflag" value="1" class="trans" OnClick="classToggle();" checked></td>
                      <td width="70" class="stm"><B>Event Date</B></td>
                      <td><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="event_from_dt">&nbsp;~
                          <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="event_to_dt">
                          <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar01"></td>
                    </tr>
                    <tr>
					  <td><input type="radio" name="divflag" value="2" class="trans" OnClick="classToggle();" ></td>
					  <td class="stm"><B>Update Date</B></td>
					  <td><input type="text" style="width:80;ime-mode:disabled;" class="input" value="<%=pDate1%>" tabindex="1" name="upt_from_dt">&nbsp;~
                          <input type="text" style="width:80;ime-mode:disabled;" class="input" value="<%=pDate2%>" tabindex="2" name="upt_to_dt">
                          <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar02"></td>
                  </table>
                </td>
                <td width="65%">
				<table class="search" border="0" style="width:100%;">
					<tr class="h23">
						<td width="20%">
							&nbsp;&nbsp;RCC
							&nbsp;<script type="text/javascript">ComComboObject('rcc_cd', 1, 70, 0, 0, 2, 0, 7)</script>
						</td>
						<td width="20%">
							&nbsp;&nbsp;LCC
							&nbsp;<script type="text/javascript">ComComboObject('p_lcc_cd', 1, 70, 0, 0, 2, 0, 8)</script>
							<input type="hidden" name="lcc_cd" value="" />
						</td>
						<td width="60%">
							Yard
							&nbsp;<input type="text" maxlength="5" style="width:55;" class="input" tabindex="9" name="yard_cd1">
							&nbsp;<script type="text/javascript">ComComboObject('yard_cd2', 2, 45, 0, 0, 2, 0, 10)</script>
							<input type="hidden" name="org_yd_cd" value="" />
						</td>
					</tr>
					<tr class="h23">
						<td colspan="2">
							&nbsp;&nbsp;Evidence Attached&nbsp;
							<select name="atch_file_sav_id" tabindex="5">
								<option value="">ALL</option>
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>
						</td>
						<td>
							Correction Type&nbsp;
							<select name="correction_type" tabindex="5">
								<option value="">ALL</option>
								<option value="I">Insert</option>
								<option value="U">Update</option>
								<option value="D">Delete</option>
							</select>
						</td>
					</tr>
					<tr class="h23">
						<td colspan="2">
							&nbsp;&nbsp;<B>Correction Item</B>
							&nbsp;<select name="cnmv_his_col_nm" tabindex="3">
								<option value="">ALL</option>
								<option value="MVMT_STS_CD">Movement Status</option>
								<option value="ORG_YD_CD">Origin Yard</option>
								<option value="DEST_YD_CD">Return Yard</option>
								<option value="CNMV_EVNT_DT">Event Date</option>
								<option value="VVD">VVD Code</option>
								<option value="FCNTR_FLG">F/M</option>
								<option value="OB_CNTR_FLG">I/O</option>
								<option value="VNDR">Service Provider</option>
								<option value="MVMT_TRSP_MOD_CD">Mode</option>
								<option value="CNTR_SEAL_NO">Seal No.</option>
								<option value="WBL_NO">Waybill</option>
								<option value="PKUP_NO">Pick Up No.</option>
							</select>
						</td>
						<td>
							<B>Correction Reason</B>
							&nbsp;<%=JSPUtil.getCodeCombo("cnmv_corr_rsn", "", "style='width:250;' tabindex='3' ", "CD03488", 0, "000001: :ALL") %>
						</td>
					</tr>
				</table>
              </td>
              </tr>
              <tr><td colspan="10" class="height_2"></td></tr>
            </table>
            <!-- biz_1   (E) -->

            <table class="line_bluedot"><tr><td></td></tr></table>

            <!-- biz_2  (S) -->
<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
            
<!-- UI_ESM_SPC_022 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">
			<!-- Grid  (S) -->
            <table width="100%" class="search"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
</div>
<!-- UI_ESM_SPC_022 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">
			<!-- Grid  (S) -->
            <table width="100%" class="search"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('t2sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
</div>
<!-- UI_ESM_SPC_022 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">
			<!-- Grid  (S) -->
            <table width="100%" class="search"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('t3sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
</div>
<!-- UI_ESM_SPC_022_T1 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">
			<!-- Grid  (S) -->
            <table width="100%" class="search"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('t4sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
</div>
			
            
            <!-- biz_2   (E) -->
          </td>
        </tr>
      </table>
      <!-- biz page (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                      <td class="btn1" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downExcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- Button (E) -->
    </td>
  </tr>
</table>
<!-- 개발자 작업 끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0" id="hiddenFrame"></iframe>
</body>
</html>