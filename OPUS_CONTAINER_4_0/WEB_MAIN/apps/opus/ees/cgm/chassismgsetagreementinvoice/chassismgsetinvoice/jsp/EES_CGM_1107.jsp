<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1107.jsp
*@FileTitle  : Chassis Estimate Expense
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1107Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1107Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EesCgm1107Event)request.getAttribute("Event");
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
                // 1107 Permission 'CGM01','CGM02'
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn_Calculation" id="btn_Calculation" type="button">Calculation</button><!--
	--><button class="btn_normal" name="btn1_Report" id="btn1_Report" type="button">Report</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="10px" />
				<col width="70px" />
				<col width="150px" />
				<col width="30px" />
				<col width="120px" />
				<col width="30px" />
				<col width="350px" />
				<col width="150px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td></td>
					<th>Execute Month</th>
				    <td><input type="text" name="period_eddt" style="width:60px;" value="" class="input1" maxlength="7" dataformat="ym" id="period_eddt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>		
                    <th>DIV </th>
                    <td><script type="text/javascript">ComComboObject('div', 1, 70, 0, 0, 0, false);</script></td>
                    <th>Cost Month</th>
                    <td><input type="text" name="rev_month" style="width:60px;" value="" class="input" maxlength="7" dataformat="ym" id="rev_month" /><button type="button" id="btn_calendarRevMonth" name="btn_calendarRevMonth" class="calendar ir"></button></td>                    
                    <td class="sm"><input type="radio" name="doc_type" value="" class="trans" checked="" id="doc_type" /> Detailed      <input type="radio" name="doc_type" value="" class="trans" id="doc_type" /> Summary</td>
                    <td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_area(E) -->
<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		<button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">DownExcel</button><!--
	--></div>
	</div>
	<div class="opus_design_grid" id="detailLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="summaryLayer" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
