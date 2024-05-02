<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0903.jsp
*@FileTitle  : Customer Performance Group Code Inquiry
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
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0903Event"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSam0903Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수

    String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsrSrepCd 	= "";
	String reqCustGrpId 	= "";	// 부모 페이지의 파라 미터 . 
	String reqOfcCd 		= "";	// 부모 페이지의 파라 미터 . 
	Logger log = Logger.getLogger("com.clt.apps.GeneralInfoManage.CustomerInfoManage");
	try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		log.info("*	strUsr_id	:"+strUsr_id+"*	strUsr_nm	:"+strUsr_nm+"*	strOfc_cd	:"+strOfc_cd+"*	strUsrSrepCd:"+strUsrSrepCd+"*	reqCustGrpId:"+reqCustGrpId);
		reqCustGrpId 	= request.getParameter("cust_grp_id")==null?"":request.getParameter("cust_grp_id");
		reqOfcCd 		= request.getParameter("ofc_cd")==null?"":request.getParameter("ofc_cd");

        event = (EsmSam0903Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="reqOfcCd" value="<%=StringUtil.xssFilter(reqOfcCd)%>" id="reqOfcCd" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Customer Performance Group Code Inquiry</span></h2>
		
		<div class="opus_design_btn">
		 	<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--
		 --><button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80">
					<col width="220">
					<col width="80">
					<col width="130">
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Group Name</th>
						<!-- 2014.07.31 김용습 - 띄어쓰기 입력되지 않아 dataformat 변경(engup -> excepthan) -->
						<td><input type="text" style="width:200px;ime-mode:disabled;text-align:center" class="input1" name="cust_grp_nm" dataformat="excepthan" maxlength="20" id="cust_grp_nm" /> </td>
						<th>Match Rule</th>
						<td><!-- 
							 --><select name="match_rule" id="match_rule" style="width:110px;" ><!-- 
								 --><option value="I" >Include</option><!-- 
								 --><option value="A">Exact</option><!-- 
								 --><option value="D">Start With</option><!-- 
							 --></select>
						</td>
						<th>Group Code</th>
						<!-- 2014.07.31 김용습 - 하이픈이 입력되지 않아 dataformat 변경(engup -> excepthan) -->
						<td><input type="text" name="cust_grp_id" style="width:80px;text-align:center;ime-mode:disabled" class="" value="<%=StringUtil.xssFilter(reqCustGrpId)%>" dataformat="excepthan" maxlength="50" id="cust_grp_id" otherchar=" &amp;-,." /></td>
					<tr>
						<th>Abbreviation</th>
						<td><input type="text" style="width:130px;ime-mode:disabled;text-align:center" class="input" name="cust_grp_abbr_nm" dataformat="engup" maxlength="20" id="cust_grp_abbr_nm" /></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
