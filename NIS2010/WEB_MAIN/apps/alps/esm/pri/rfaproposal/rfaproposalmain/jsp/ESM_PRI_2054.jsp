<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2054.jsp
*@FileTitle : RFA Proposal & Amendment Status By Office
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.01.05 최성환
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri2054Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String strRhq_ofc       = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();
        strRhq_ofc = account.getRhq_ofc_cd();


        event = (EsmPri2054Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>RFA Proposal Creation - Request Received and Sent</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>">
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_rhq_ofc_cd" value="<%=strRhq_ofc%>">
<!-- 개발자 작업 -->
<!--  Office Code Validation 체크를 위한 정의 -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->
<input type="hidden" id="searchParam" name="eff_dt">
<input type="hidden" id="searchParam" name="exp_dt">
<input type="hidden" id="searchParam" name="dt_type">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0"  style="padding-top: 2; padding-left: 5;">
    <tr>
        <td valign="top"><!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="title">
            <tr>
                <td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
            </tr>
            <tr>
                <td class="title"><img src="img/icon_title_dot.gif"  align="absmiddle"><span id="title"></span></td>
            </tr>
        </table>
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
					                    <td class="btn1_right">
				                	</tr>
				                </table>
			                </td>
			                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_new">New</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
							</td>
			                <td class="btn1_line"></td>
			            	<td>
			            		<table border="0" cellpadding="0" cellspacing="0">
			                    	<tr>
			                    		<td class="btn1_left"></td>
			                    		<td class="btn1" name="btn_downexcel">Down Excel</td>
			                    		<td class="btn1_right">
			                		</tr>
			                	</table>
			                </td>
			            </tr>
			        </table>
		       </td>
            </tr>
        </table>
        <!--Button (E) -->

        <!--biz page - 1 (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">

                <!--  biz  (S) -->
                <!-- 1번째 조건 -->
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    
                    <!-- DATE -->
                    <td class="search_sm2">
                        <table class="search_sm2" border="0" style="width:600;">
	                        <tr class="h23">
	                        	<td width="125"><input type="radio" name="rdoDate" value="1" class="trans" checked>Requested Date</td>
	                            <td width="110"><input type="radio" name="rdoDate" value="2" class="trans" >Approval Date</td>
	                            <td width="75"> <input type="radio" name="rdoDate" value="3" class="trans" >EFF Date</td>
	                            <td width="210">
	                                <input type="text" class="input1" style="width:70;text-align:center;" name="eff_date_from" cofield="eff_date_to" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
	                                ~
	                                <input type="text" class="input1" style="width:70;text-align:center;" name="eff_date_to" cofield="eff_date_from" dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
	                            </td>
	                        </tr>
                        </table>
                    </td>
                    
                    <td width="120">Approval Office</td>
                   	<td width="100">
                   		<nobr>
	                       <input type="text" name="prop_apro_ofc_cd" style="width:70;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> 
	                       <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetPropAproOfc">
	                    </nobr>
                   	</td>
                   	<td width="50"> Staff</td>
	                <td width="120"><input type="text" name="prop_apro_staff_cd" style="width:100;text-align:left;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="30"></td>  
                   	                    
                </tr>
                </table>
                
                <!-- 2번째 조건 -->
                <table class="search" border="0" style="width:100%;">
	                <tr class="h23">
		                <td width="80">&nbsp;&nbsp;RFA No.</td>
	                    <td width="130"><input type="text" class="input" style="width:99;text-align:center;ime-mode:disabled" name="rfa_no" dataformat="uppernum" maxLength="11"></td>
	                    
	                    <td width="100">&nbsp;&nbsp;Proposal No.</td>
	                    <td width="130"><input type="text" class="input" style="width:99;text-align:center;ime-mode:disabled" name="prop_no" dataformat="uppernum" maxLength="11"></td>
	                    
	                    <td width="100">&nbsp;&nbsp;RFA Status</td>
	                    <td width="100">
							<select name="prop_sts_cd" class="input" style="width:85;">
								<option value="" selected></option>
								<option value="Q">Requested</option>
								<option value="A">Approved</option>
								<option value="R">Returned</option>
							</select>
	                    <!-- <input type="text" class="input" style="width:100;text-align:center;ime-mode:disabled" name="prop_sts_cd" dataformat="engup" maxLength="1"> -->
	                    </td>
	                    
	                	<td width="120">Request Office</td>
	                	<td width="100">
		                	<nobr>
	                       	<input type="text" name="prop_ofc_cd" style="width:70;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> 
	                       	<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetPropOfc">
	                       	</nobr>
	                   	</td> 
	                   <td width="80">Sales Rep.</td>
                    	<td width="110"><input type="text" name="prop_srep_cd" style="width:80;text-align:center;ime-mode:disabled" class="input" dataformat="uppernum" maxLength="5"></td>
	                </tr>
                </table>
                
                <!-- 3번째 조건 -->
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                	<td width="80">&nbsp;&nbsp;Customer</td>
                    <td width="400">
                       <input type="text" class="input" style="width:30;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" caption="Customer Code"> 
                       <input type="text" class="input" style="width:55;text-align:center;ime-mode:disabled;" dataformat="int" name="ctrt_cust_seq" maxlength="6" caption="Customer Code">
                       <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_cust">
                       <input type="text" style="width:200;text-align:left;" class="input2"  name="ctrt_pty_nm"  readonly=true>
                    </td>
                   	<td width="110"></td>
                   	<td width="440"></td>         
                   	<td width="0"></td>
	                <td width="0"></td>
                </tr>
                </table>
                <!--  biz   (E) -->

            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <!-- Grid  (S) -->
                <table width="100%" class="search"  id="mainTable">
                    <tr>
                        <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
            <!-- Grid (E) -->

            </td></tr>
        </table>
        <!--biz page - 2 (E)-->

</td></tr></table>

<div style="display: none"><!-- search customer name  -->
<script language="javascript">ComSheetObject('sheet2');</script>
</div>

</form>
</body>
</html>