<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1040.jsp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1040Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesEqr1040Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String locGrpCd = "";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String week = "";
    String title = "";
    String dp_seq = ""; // 1003화면의 sheet 구분(2,3,4,5,6)
    String row    = ""; // 1003화면의 1040를 오픈한 row 구분
    String mainpage = "";
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EesEqr1040Event)request.getAttribute("Event");
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        mainpage = request.getParameter("mainPage");

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        title = "Planned Repo In";
        week  = (String)event.getAttribute("fcast_yrwk");
        dp_seq  = (String)event.getAttribute("dp_seq");
        row  = (String)event.getAttribute("row");
        
        if("E".equals(event.getAttribute("loc_grp_cd"))){
            locGrpCd = "ECC";
        }else if("L".equals(event.getAttribute("loc_grp_cd"))){
            locGrpCd = "LCC";
        }else if("S".equals(event.getAttribute("loc_grp_cd"))){
            locGrpCd = "SCC";
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
	function setupPage(){
	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	        showErrMessage(errMessage);
	    } // end if
	    loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="loc_grp_cd" value="<%=event.getAttribute(" loc_grp_cd")%>" id="loc_grp_cd" />
<input type="hidden" name="loc_cd" value="<%=event.getAttribute(" loc_cd")%>" id="loc_cd" />
<input type="hidden" name="fcast_yrwk" value="<%=event.getAttribute(" fcast_yrwk")%>" id="fcast_yrwk" />
<input type="hidden" name="repo_pln_yrwk" value="<%=event.getAttribute(" repo_pln_yrwk")%>" id="repo_pln_yrwk" />
<input type="hidden" name="level_cd" value="<%=event.getAttribute(" level_cd")%>" id="level_cd" />
<input type="hidden" name="wk_st_dt" value="<%=event.getPlannedRepoInVO().getWkStDt()%>" id="wk_st_dt" />
<input type="hidden" name="tpsz_flag" value="<%=StringUtil.xssFilter(request.getParameter(" tpsz_flag"))%>" id="tpsz_flag" />

<input type="hidden" name="dp_seq" value="<%= dp_seq %>" id="dp_seq" />
<input type="hidden" name="row" value="<%= row %>" id="row" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span><%=title%></span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		<%if(!"true".equals(mainpage)){ %>
			<button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button>
		<%} %>
	</div>
	<!-- opus_design_btn(E) -->
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" style="text-align: center;">
		<table>
			<colgroup>
				<col width="400">
				<col width="400">
				<col width="400">
				<col width="400">
			</colgroup>
			<tbody>
				<tr>
                    <th>Wk<%= week.substring(4) %> disc vol. (<%=event.getPlannedRepoInVO().getWkStDt() %>~<%=event.getPlannedRepoInVO().getWkEndDt() %>)</th>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                	<th><%= locGrpCd %></th>
                    <th>:</th>
                    <th><%=event.getAttribute("loc_cd") %></th>
                    <td></td>
                </tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<h3 class="title_design">Discharging Plan List</h3>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>