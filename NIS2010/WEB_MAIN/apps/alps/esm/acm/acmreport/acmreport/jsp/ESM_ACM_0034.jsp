<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0034.jsp
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.17 김봉균
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event.EsmAcm0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0034Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0034Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Agent Commission Request</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="csr_no"><!-- Multi CSR No. -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_detail">CSR Detail</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->


      <!-- biz page (S) -->
      <table class="search">
		<tr>
		  <td class="bg">
		    <table class="search_in" border="0">
			  <tr class="h23">
			    <td width="3%">Date</td>
				<td width="44%">
				  <table border="0" style="height: 15; width: 90%;">
				    <tr>
					  <td width="205" style="padding-left: 1; height:30;">
					  	<table class="Grid2">
                          <tr>
                            <td class="tr2_head" style="font-size: 12px;">
                              <input type="radio" name="date_div" class="trans" value="C" checked>Creation
                              <input type="radio" name="date_div" class="trans" value="A">Approval
                              <input type="radio" name="date_div" class="trans" value="G">G/L
                            </td>
                          </tr>
                        </table>
					  </td>
					  <td>
                        <input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">&nbsp;~
		                <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6">
		                <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
					</tr>
				  </table>
				</td>
				<td width="5%">Office</td>
				<td width="15%"><select name="ar_ofc_cd" required caption="Office" class="input1" style="width:100px;" tabindex="1"></select></td>
				<td width="8%">Sub Office</td>
				<td width="15%">
				  <div id="div_sbOfcCd"><select name="agn_cd" required caption="Sub Office" class="input1" style="width:100px;" tabindex="2"></select></div>
				</td>
			  </tr>
			  <tr class="h23">

				<td width="7%">CSR No</td>
				<td width="30%">
				  <table border="0" style="height: 15; width: 62%;">
					<tr>
                      <td height="25" id="memo_sheet1_td">
                        <div id="memo_sheet1_div">
                          <table width="150">
                            <tr>
                              <td><script language="javascript">ComSheetObject("memo_sheet1");</script></td>
                            </tr>
                          </table>
                        </div>
                      </td>
					  <td>
						<table border="0" cellpadding="0" cellspacing="0" class="button" align="right">
						  <td class="btn2_left"></td>
						  <td class="btn2" name="btn2_csr_no">Multi CSR No.</td>
						  <td class="btn2_right"></td>
						</table>
					  </td>
					</tr>
				  </table>
				</td>

				<td width="3%">R.VVD</td>
				<td width="15%"><input type="text" name="rev_vvd_cd" style="width: 100; ime-mode: disabled;" maxlength="10" dataformat="engup"></td>
				<td width="5%">Status</td>
				<td width="27%"><select style="width: 100;" name="sts_cd" >
				  <option value="1" selected>Created</option>
				  <option value="2">Approved</option>
				  <option value="3">Paid</option>
				  <option value="4">Cancelled</option>
				  </select>
				</td>
			  </tr>
			</table>
		  </td>
		</tr>
      </table>


      <table class="height_8"><tr><td></td></tr></table>


      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%" id="mainTable1">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->

			<table class="line_bluedot"><tr><td></td></tr></table>

	   	    <table class="height_10">
			  <tr>
			    <td></td>
			  </tr>
		    </table>

			<table class="search" border="0">
			  <tr class="h23">
			    <td width="70" valign="top"><div style="margin-top:4px">USD Total</div></td>
			    <td width="180" valign="top"><input type="text" name="usd_total" style="width:150px; height:20;" class="input2" readOnly></td>
			    <td>
	            <!-- biz_3 (S) -->
	            <!-- Grid (S) -->
				  <table width="282" id="mainTable2">
				    <tr>
				      <td><script language="javascript">ComSheetObject('sheet2');</script></td>
				    </tr>
				  </table>
	            <!-- Grid (E) -->
	            <!-- biz_3 (E) -->
	            </td>
	          </tr>
	        </table>

          </td>
        </tr>
      </table>

      <!-- biz page (E) -->


    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>