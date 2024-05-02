<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2206.jsp
*@FileTitle  : M.G.Set Estimate Expense
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2206Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
    EesCgm2206Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String ofc_cd  			= "";
    String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply

    Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofc_cd = account.getOfc_cd();

        event = (EesCgm2206Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //chungpa 20100304 transaction role apply start
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for(int i=0; i< curv.length; i++)
        {
            //System.out.println("chungpa priority>>>>" + curv[i].getUsrRoleCd());
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            }else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 2206 Permission 'CGM01','CGM02'
                if( curv[i].getUsrRoleCd().equals("CGM01")
                    || curv[i].getUsrRoleCd().equals("CGM02")
                    //|| curv[i].getUsrRoleCd().equals("CGM03")
                    //|| curv[i].getUsrRoleCd().equals("CGM04")
                    //|| curv[i].getUsrRoleCd().equals("CGM05")
                    //|| curv[i].getUsrRoleCd().equals("CGM99")
                )
                {
                    tRole = "Authenticated";
                    break;
                }
            }else
            {
                tRole = "Not Authenticated";
            }
        }
        //chungpa 20100304 transaction role apply end
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<head>
<title>M.G.Set Estimate Expense</title>


<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        document.form.ofc_cd.value = "<%=ofc_cd%>";		
        loadPage();
    }
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Calculation" id="btn_Calculation" type="button">Calculation</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="200" />
				<col width="110" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Execute Month</th>
                    <td><input type="text" name="period_eddt" style="width:60px;" value="" class="input1" maxlength="7" dataformat="ym" id="period_eddt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>                   
                    <th>Cost Month</th>
                    <td><input type="text" name="rev_month" style="width:60px;" value="" class="input" maxlength="7" dataformat="ym" id="rev_month" /><button type="button" id="btn_calendarRevMonth" name="btn_calendarRevMonth" class="calendar ir"></button></td>  
                    <th class="sm pad_rgt_4 pad_left_4"><input type="radio" name="doc_type" value="" class="trans" checked id="doc_type" onclick="doc_type_change();" /> Detailed&nbsp;&nbsp;&nbsp;<input type="radio" name="doc_type" value="" class="trans" id="doc_type" onclick="doc_type_change();" /> Summary</th>
                    <td></td> 
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<div id="detailLayer" name="detailLayer">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div id="summaryLayer" name="summaryLayer">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>