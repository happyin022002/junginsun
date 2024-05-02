<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8001.jsp
*@FileTitle : Awkward & Break Bulk Cargo Quotation List
*Open Issues :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Service Scope 조회 조건 및 결과Grid 상에 추가
* 2014.03.20 송호진 [CHM-201429287] POR, DEL 조회 조건 및 결과 리스트 항목 추가. POR, POL 지정시 Break Bulk 는 조회 되지 않도록 함
* 2014.09.11 송호진 [CHM-201431718] SCQ System 기능 추가 개발 요청 - Actual Customer란
* 2015.01.20 송호진 [CHM-201432778] SCQ AWK/BB Cargo application에서 Approval Office 선택에 대한 제한 설정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event.EsmPri8001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri8001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	
	String[] prcScqAproOfcCd = null;
	Logger log = Logger.getLogger("com.hanjin.apps.specialcargo.specialcargo");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_office_cd =	account.getOfc_cd();


		event = (EsmPri8001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		prcScqAproOfcCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("PRC_SCQ_APRO_OFC_CD"), true);

	}catch(Exception e) {
		out.println(e.toString());
	}
		
	// Duration 종료일 (Hidden - 오늘날짜)
	String tempToPeriod = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	// Duration 시작일 (Hidden - 1개월 이전날짜)
	String tempFmPeriod = DateTime.addMonths(tempToPeriod, -1, "yyyy-MM-dd");
	
	// Duration 종료일 (request가 없다면 toPeriod)
	String toPeriod = (request.getParameter("toPeriod") == null)? tempToPeriod: request.getParameter("toPeriod");
	// Duration 시작일 (request가 없다면 fmPeriod)
	String fmPeriod = (request.getParameter("fmPeriod") == null)? tempFmPeriod: request.getParameter("fmPeriod");
	
%>
<html>
<head>
<title>Awkward & Break Bulk Cargo Proposal List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var prcScqAproOfcCdValue = " |<%=prcScqAproOfcCd[0]%>";
	var prcScqAproOfcCdText = " |<%=prcScqAproOfcCd[1]%>";
	
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
<table border="0" cellpadding="0" cellspacing="0" style="padding: 5 0 0 2;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
<!-- Page Title, Historical (E) -->


<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input name="etc1" type="hidden" value="<%=strUsr_office_cd %>">
<input name="qttn_ofc_cd_hidden" type="hidden" value="<%=strUsr_office_cd %>">

<input type="hidden" name="pagerows">
<input type="hidden" name="temp_date1" value="<%=tempToPeriod%>">
<input type="hidden" name="temp_date2" value="<%=tempFmPeriod%>">

<!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
  	              <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
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
                  </table></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_open">Open</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_newapplication">New&nbsp;Application</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_download">Download</td>
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
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
<!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_1 (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="100" align="left">Request Office&nbsp;</td>
                <td width="120"><input type="text" maxlength="6" onKeyPress="ComKeyOnlyAlphabet('upper')" name="rqst_ofc_cd" style="width:90;text-align:center;" class="input" value="<%=strUsr_office_cd %>" required >              
                	            <img class="cursor" src="img/btns_search.gif" name="btn_ofc_hierarchy" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="100" align="right">Sales Rep.&nbsp;</td>
                <td width="220"><script language="javascript">ComComboObject('rqst_srep_cd', 2, 70, 0, 0, 0, false);</script>&nbsp;
	                            <input type="text" name="qttn_srep_nm" style="width:140;" class="input2" value="" readonly></td>
                <td width="120"></td>    
                <td width="100" align="right">Period&nbsp;</td>
                <td width="219"><input type="text" style="width:80;ime-mode:disabled;text-align:center;" class="input1" value="<%=fmPeriod%>" tabindex="3" maxlength="10" dataformat="ymd" name="fmperiod">&nbsp;~
                                <input type="text" style="width:80;ime-mode:disabled;text-align:center;" class="input1" value="<%=toPeriod%>" tabindex="4" maxlength="10" dataformat="ymd" name="toperiod">
                                <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar1"></td>              
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>
      
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
      
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_2 (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="80" align="left" >Request No.</td>
                <td width="110" align="right" ><input type="text" style="width:110;text-align:center;" class="input" value="" maxlength="15" onKeyPress="ComKeyOnlyAlphabet('uppernum')" name="scq_rqst_no"></td>
                <td width="40" align="center" >Type</td>
                <td width="80" align="right" ><select style="width:85;" class="input" name="tp_cd" tabindex="1">                
                                <option value=""></option>
                                <option value="" selected>ALL</option>
                                <option value="AK">Awkward</option>
                                <option value="BB">Break Bulk </option>
                                </select></td>    
                <td width="60" align="center">A.Cust</td>
                <td width="70" align="right"><input type="text" style="width:70;text-align:center;" class="input" value="" maxlength="200" onKeyPress="ComKeyOnlyAlphabet('uppernum')" name="act_cust_nm"></td>
                <td width="75" align="center">Customer</td>
                <td width="120" align="right">
                				<input type="text" style="width:26;text-align:center;" class="input" value="" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('upper')" name="cust_cnt_cd">
                                <input type="text" style="width:60;text-align:center;" class="input" value="" maxlength="6" onKeyPress="ComKeyOnlyNumber(this)" name="cust_seq">
                                <img class="cursor" src="img/btns_search.gif" name="btn_customer" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="80" align="center">Commodity</td>
                <td width="120"><input type="text" style="width:90;text-align:center;" class="input" value="" maxlength="6" onKeyPress="ComKeyOnlyNumber(this)" name="cmdt_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_cmdt_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="80" align="right">SVC Scope&nbsp;</td>
                <td width="70"><script language="javascript">ComComboObject('svc_scp_cd', 2, 68, 1, 0);</script></td>
              </tr>
            </table>
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
              
                <td width="30" align="left">POR&nbsp;</td>
                <td width="60"><input type="text" style="width:60;text-align:center;" class="input" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')" name="por_cd"></td>
                <td width="20"><img class="cursor" src="img/btns_search.gif" name="btn_por_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="30" align="center">POL</td>
                <td width="60"><input type="text" style="width:60;text-align:center;" class="input" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')" name="pol_cd"></td>
                <td width="20"><img class="cursor" src="img/btns_search.gif" name="btn_pol_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="30" align="center">POD</td>
                <td width="60"><input type="text" style="width:60;text-align:center;" class="input" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')" name="pod_cd"></td>
                <td width="20"><img class="cursor" src="img/btns_search.gif" name="btn_pod_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="30" align="center">DEL</td>
                <td width="60"><input type="text" style="width:60;text-align:center;" class="input" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')" name="del_cd"></td>
                <td width="20"><img class="cursor" src="img/btns_search.gif" name="btn_del_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="75" align="center">APRO OFC</td>
                <td width="120" align="right"><script language="javascript">ComComboObject('apro_ofc_cd', 2, 100, 0, 0);</script>
                				<!--  input type="text" style="width:90;text-align:center;" class="input" value="" maxlength="6" onKeyPress="ComKeyOnlyAlphabet('upper')" name="apro_ofc_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_apro_cd" width="19" height="20" border="0" align="absmiddle" -->
                				</td> 				 
                <td width="80" align="right">Status&nbsp;</td>
                <td width="120"><select style="width:113;" class="input" name="sts_cd" tabindex="1">
                                <option value=""></option>                                	  
                                <option value="" selected>ALL</option>
                                <option value="Temporary">Temporary</option>
                                <option value="Processing">Processing</option>
                                <option value="Requested">Requested</option>
                                <option value="Request Canceled">Request Canceled</option>
                                <option value="Counter Offer">Counter Offer</option>
                                <option value="Approved">Approved</option>
                                <option value="Rejected">Rejected</option>
                                <option value="Pending">Pending</option>
                                </select></td>
                <td width="80" align="right">Delt&nbsp;</td>
                <td width="70"><select style="width:68;" class="input" name="delt_flg" tabindex="1">
                                <option value="">ALL</option>
                                <option value="Y">Y</option>
                                <option value="N" selected>N</option>
                                </select></td>
              </tr>
            </table>
            <!-- biz_2 (E) -->
            <table class="height_8"><tr><td colspan="8"></td></tr></table>

            <!-- List (S) -->
            <table width="100%"  border="0" id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- List (E) -->
            <table class="height_8"><tr><td colspan="8"></td></tr></table>


            <div style="height:180px">
            <!-- Awkward (S) -->
            <div id="akSheet" style="display:none">
            <table width="100%"  border="0" id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            </div>
            <!-- Awkward (E) -->
            <!-- Break Bulk (S) -->
            <div id="bbSheet" style="display:none">
            <table width="100%"  border="0" id="mainTable">
              <tr>
                <td width="40%">
                  <script language="javascript">ComSheetObject('sheet3');</script>
                </td>
                <td width="1%"></td>
                <td width="20%">
                  <script language="javascript">ComSheetObject('sheet4');</script>
                </td>
                <td width="1%"></td>
                <td width="40%">
                  <script language="javascript">ComSheetObject('sheet5');</script>
                </td>
              </tr>
            </table>
            </div>
            </div>
            <!-- Break Bulk (E) -->
            
          </td>
        </tr>
      </table>
</td>
        </tr>
      </table>
      

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>