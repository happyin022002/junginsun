<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0902.jsp
*@FileTitle  :  Customer PFMC Group Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0902Event"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSam0902Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    String main_page = "";

    String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsrSrepCd 	= "";
	String reqCustGrpId 	= "";	// 부모 페이지의 파라 미터 .
	Logger log = Logger.getLogger("com.clt.apps.GeneralInfoManage.CustomerInfoManage");
    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();

		reqCustGrpId = request.getParameter("cust_grp_id")==null?"":request.getParameter("cust_grp_id");

		log.info("*	strUsr_id	:"+strUsr_id+"*	strUsr_nm	:"+strUsr_nm+"*	strOfc_cd	:"+strOfc_cd+"*	strUsrSrepCd:"+strUsrSrepCd+"*	reqCustGrpId:"+reqCustGrpId);

        event = (EsmSam0902Event)request.getAttribute("Event");

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
	$(".btn_gnb_hide").css("display","none");
	$(".util_bar").css("display","none");
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        // InitTab();
        loadPage();
    }
</script>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<%if(main_page.equals("true")){ %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<%} else { %>
		<h2 class="page_title"><span>Customer Group Assign</span></h2>
	<%} %>	
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Apply" id="btn_Apply">Apply</button><!-- 
		 --><%if(!main_page.equals("true")){ %><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button><!-- 
		 --><%} %>
	</div>
	<!-- opus_design_btn(E) -->
	<%if(main_page.equals("true")){ %>
		<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	<%}%>
	<!-- page_location(S) -->
</div>
<form name="form">
<%if(main_page.equals("true")){ %>
	<input type="hidden" name="f_cmd" id="f_cmd" />
<%} else { %>
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="reqCustGrpId" value="<%=strOfc_cd%>" id="reqCustGrpId" />
	<input type="hidden" name="parentOfcCd" value="" id="parentOfcCd" />
<%} %>
	<!-- page_title_area(E) -->
</div>	
	
	
	
<div class="layer_popup_contents" style="background: white">
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="180">
				<col width="120">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Customer Group Code</th>
					<!-- 2014.07.31 김용습 - 하이픈이 들어가지 않아 dataformat을 engup에서 excepthan으로 변경 -->
					<td><input type="text" name="cust_grp_id" style="width:150px;text-align:center;ime-mode:disabled" class="" value="<%=StringUtil.xssFilter(reqCustGrpId)%>" dataformat="excepthan" maxlength="30" id="cust_grp_id" /><!--  
					--><button type="button" name="btn_Group_Code" id="btn_Group_Code" class="input_seach_btn"></button></td>
					<td><span id="cust_grp_nm" name="cust_grp_nm"></span></td>
					<td>&nbsp;</td>
				<tr>
					<th>Abbreviation</th>
					<td><input type="text" name="cust_abbr_nm" style="width:150px;text-align:center;ime-mode:disabled" class="input2" value=""  maxlength="6" readonly id="cust_abbr_nm" /> </td>
					<th>Overwrite&nbsp;<input type="checkbox" name="overwrite" style="border-style:none" value="Y" id="overwrite" /></th>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sheetHide" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
<!-- opus_design_grid(E) -->
</div>
</form>		
					