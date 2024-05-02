<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_bkg_0365.jsp
*@FileTitle  : Mark & Description Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0365Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0365Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.bookingmaterdata.usersetupmgt");

	String returnObj = "";
	String tmpltTpCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0365Event)request.getAttribute("Event");
		returnObj = event.getReturnObject();
		tmpltTpCd = event.getTmpltTpCd();
		tmpltTpCd = (tmpltTpCd==null || "".equals(tmpltTpCd)) ? "M" : tmpltTpCd;

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		//e.printStackTrace();
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	cur_usr_id = '<%=strUsr_id%>';
	cur_ofc_cd = '<%=strOfc_cd%>';
	returnObject = null;
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();

<%
	if(returnObj!=null && returnObj.length()>0){
%>
		returnObject = opener.document.form.<%=returnObj%>;
<%
	}
%>
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Developer Work	-->
<input type="hidden" name="tmplt_tp_cd" id="tmplt_tp_cd" value="<%=tmpltTpCd%>">
<input type="hidden" name="bkg_no" id="bkg_no" value="<%=event.getBkgNo()%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Mark & Description Template</span></h2>
		
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
		--></div>
	</div>
	
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="70"/>
					<col width="90"/>
					<col width="150"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>
							<input type="radio" name="marks_type"  id="exID01" value="M" class="trans"  <%if("M".equals(tmpltTpCd)) out.print("checked");%>><label for="exID01">Marks</label>
						</th>
						<th>
							<input type="radio" name="marks_type"  id="exID02" value="D" class="trans"  <%if("D".equals(tmpltTpCd)) out.print("checked");%>><label for="exID02">Description</label> 
						</th>
						<th>
							<input type="radio" name="marks_type" id="exID03" value="T" class="trans"  <%if("T".equals(tmpltTpCd)) out.print("checked");%>><label for="exID03">Total PKG/CNTR in Word</label>
						</th>
						<td align="right">
							<button type="button" class="btn_etc" name="btn_office" id="btn_office" style="width:100px;text-align:center;">Office</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">	
			<div class="opus_design_grid">
			<div class="opus_design_btn">
			 	<button type="button" class="btn_normal" name="btn_rowAdd" id="btn_rowAdd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
