<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_6001_01.jsp
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1021Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						//DB ResultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}   
%>
<script language="javascript">  
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if 
		loadPage(); 
	} 
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="week">
<input type="hidden" name="trade">
<input type="hidden" name="vvd">

<table class="grid2"> <!-- REMOVE "style:width" -->
    <tbody>
        <tr>
            <td width="200px">
            	<script language="javascript">ComSheetObject('sheet1');</script>
            </td>
            <td width="10px"></td>
            <td width="200px">
            	<script language="javascript">ComSheetObject('sheet2');</script>
            </td>
            <td width="10px"></td>
            <td width="200px">
            	<script language="javascript">ComSheetObject('sheet3');</script>
            </td>
            <td width="10px"></td>
            <td width="200px">
            	<script language="javascript">ComSheetObject('sheet4');</script>
            </td>
            <td width="10px"></td>
            <td width="200px">
            	<script language="javascript">ComSheetObject('sheet5');</script>
            </td>
            <td width="*"></td>
        </tr>
        <tr>
            <td align="center">
            	<b>Lane</b>&nbsp;<input type="text" name="lane1" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3">
            	&nbsp;<button type="button" class="btn_etc" name="btn_s1retrieve" id="btn_s1retrieve">Retrieve</button>
            </td>
            <td></td>
            <td align="center">
            	<b>Lane</b>&nbsp;<input type="text" name="lane2" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3">
            	&nbsp;<button type="button" class="btn_etc" name="btn_s2retrieve" id="btn_s2retrieve">Retrieve</button>
            </td>
            <td></td>
            <td align="center">
            	<b>Lane</b>&nbsp;<input type="text" name="lane3" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3">
            	&nbsp;<button type="button" class="btn_etc" name="btn_s3retrieve" id="btn_s3retrieve">Retrieve</button>
            </td>
            <td></td>
            <td align="center">
            	<b>Lane</b>&nbsp;<input type="text" name="lane4" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3">
            	&nbsp;<button type="button" class="btn_etc" name="btn_s4retrieve" id="btn_s4retrieve">Retrieve</button>
            </td>
            <td></td>
            <td align="center">
            	<b>Lane</b>&nbsp;<input type="text" name="lane5" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3">
            	&nbsp;<button type="button" class="btn_etc" name="btn_s5retrieve" id="btn_s5retrieve">Retrieve</button>
            </td>
            <td></td>
        </tr>
        
        
        <tr>
            <td>
            	<script language="javascript">ComSheetObject('sheet6');</script>
            </td>
            <td></td>
            <td>
            	<script language="javascript">ComSheetObject('sheet7');</script>
            </td>
            <td></td>
            <td>
            	<script language="javascript">ComSheetObject('sheet8');</script>
            </td>
            <td></td>
            <td>
            	<script language="javascript">ComSheetObject('sheet9');</script>
            </td>
            <td></td>
            <td>
            	<script language="javascript">ComSheetObject('sheet10');</script>
            </td>
            <td></td>
        </tr>
    </tbody>
</table>

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable"  style="display:none">
		<script language="javascript">ComSheetObject('vvdTotal');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	
	<div class="opus_design_grid" id="mainTable"  style="display:none">
		<script language="javascript">ComSheetObject('portTotal');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	
	
</form>