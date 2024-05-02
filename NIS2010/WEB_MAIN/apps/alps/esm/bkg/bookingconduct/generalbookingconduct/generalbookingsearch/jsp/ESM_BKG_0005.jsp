<%
	/*=========================================================
	 *Copyright(c) 2011 CyberLogitec
	 *@FileName : esm_bkg_0005.jsp
	 *@FileTitle : Customer Advisory History
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2011.06.29
	 *@LastModifier : 이인영
	 *@LastVersion : 1.0
	 * 2011.06.29 이인영
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0005Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    EsmBkg0005Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount = 0; 							//DB ResultSet 리스트의 건수

    String pageRows = "100";
    
    String strUsr_id = "";
    String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";
	
    /* Param Argument */
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String parVvd     = JSPUtil.getParameter(request, "vvd");
    String parEDirCd  = JSPUtil.getParameter(request, "e_dir_cd");
    String parWDirCd  = JSPUtil.getParameter(request, "w_dir_cd");
    String parSDirCd  = JSPUtil.getParameter(request, "s_dir_cd");
    String parNDirCd  = JSPUtil.getParameter(request, "n_dir_cd");
    String parPolCd   = JSPUtil.getParameter(request, "pol_cd");
    String parPodCd   = JSPUtil.getParameter(request, "pod_cd");
    String parDelCd   = JSPUtil.getParameter(request, "del_cd");
    String parCustCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
    String parCustSeq = JSPUtil.getParameter(request, "cust_seq");
    String parBkgCustTpCd = JSPUtil.getParameter(request, "bkg_cust_tp_cd");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

        event = (EsmBkg0005Event)request.getAttribute("Event");
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
<title>Customer Advisory History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
var parVvd    = "<%=parVvd %>";
var parEDirCd = "<%=parEDirCd %>";
var parWDirCd = "<%=parWDirCd %>";
var parSDirCd = "<%=parSDirCd %>";
var parNDirCd = "<%=parNDirCd %>";
var parPolCd  = "<%=parPolCd %>";
var parPodCd  = "<%=parPodCd %>";
var parDelCd  	= "<%=parDelCd %>";
var parCustCntCd  = "<%=parCustCntCd %>";
var parCustSeq  = "<%=parCustSeq %>";
var parBkgCustTpCd  = "<%=parBkgCustTpCd %>";

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
<input type="hidden" name="pagerows" value="<%=pageRows%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
    
    <!--Page Title, Historical (S)-->
    <%@include file="/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
      <!--Page Title, Historical (E)-->
      
            <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downExcel">Down  Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->
      
      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="71" height="22">&nbsp;VVD</td>
                <td width="250"><input type="text" style="width:65;" class="input1" name="vvd" value="" maxlength="8"
                					caption="VVD"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill>&nbsp;
                					<input type="checkbox" name="e_dir_cd" style="border-style:none" value="E"> E
									<input type="checkbox" name="w_dir_cd" style="border-style:none" value="W"> W
									<input type="checkbox" name="s_dir_cd" style="border-style:none" value="S"> S
									<input type="checkbox" name="n_dir_cd" style="border-style:none" value="N"> N</option>                					
                </td>
                <td width="120">POL</td>
                <td width="80"><input type="text" style="width:50;" class="input" name="pol_cd" value="" maxlength="5"
                					caption="POD"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
                <td width="59">POD</td>
                <td width="100"><input type="text" style="width:50;" class="input" name="pod_cd" value="" maxlength="5"
                					caption="POD"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
                <td width="59">DEL</td>
                <td width="100"><input type="text" style="width:50;" class="input" name="del_cd" value="" maxlength="5"
                					caption="DEL"
                					style="ime-mode:disabled"
                					onKeyPress="ComKeyOnlyAlphabet('uppernum');"
                					fullfill></td>
              </tr>
              <tr class="h23">
                <td width="71">&nbsp;Customer</td>
                <td width="250">
                	<input type="text" style="width: 30;"
	                     class="input" value="" name="cust_cnt_cd"
	                     caption="Customer Code" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"
						 size="2" maxlength="2" />&nbsp;<input type="text" style="width: 50;"
	                     class="input" value="" name="cust_seq" caption="Customer Code"
	                     maxlength="6" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this)" />
                  <input type="text" style="width:120;" class="input2" value="" name="cust_nm"></td>
                <td width="120">Customer Type</td>
                <td width="80"><select name="bkg_cust_tp_cd" style="width:100;" class="input" disabled>
                    <option value="A" selected>All</option>
                    <option value="S">Shipper</option>
                    <option value="C">Consignee</option>
                    <option value="S">Notify</option>
                    <option value="T">Contract</option>
                  </select></td>
                <td width="100">Sent Office</td>
                <td width="129"><input type="text" style="width:100;" class="input" value="" name="snt_ofc_cd" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="5"></td>
                
                <td width="100">Source Type</td>
                <td  width="85">
                	<script language="javascript">ComComboObject('src_dat_tp_cd', 1, 85, 1, 0);</script>
                </td>
                
              </tr>
            </table>
       </table>

		<table class="height_8"><tr><td></td></tr></table>
	          
        <!-- Tab (S) -->
        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" >
            <tr>
            	<td width="100%">
                    <script language="javascript">ComTabObject('tab1')</script>
                </td>
            </tr>
        </table>
        <!-- Tab (E) -->
        
        <table class="search"><tr>   
            
            <!-- Grid  (S) -->
       		<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
					
            <!-- Grid (E) --></td>
            <table width="100%"  id="mainTable" style="display:none">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
        </tr>
      </table>
      <!-- Tab BG Box(E) -->
      <!--biz page (E)-->
  </tr>
</table>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
