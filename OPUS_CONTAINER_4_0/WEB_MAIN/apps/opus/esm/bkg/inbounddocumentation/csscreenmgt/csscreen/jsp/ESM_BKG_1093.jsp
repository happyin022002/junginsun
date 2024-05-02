<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESK_BKG_1093.jsp
*@FileTitle : Inbound C/S USA_Instruction Pop-up
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg1093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1093Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    // Param : bl_no, bl_tp_cd, bkg_no, bkg_split_no, cntr_no  
	String blNo       = "";
    String blTpCd     = "";
	String bkgNo      = "";
	String cntrNo     = "";
    String blTpCdClass = "input2";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgt.CsScreen");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	   
	   
		event = (EsmBkg1093Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        if(event != null) {       		
            bkgNo      = event.getBkgNo();
        }
		
	} catch(Exception e) {
		out.println(e.toString());
	}	
%>


<script language="javascript">
    var strUsr_id    = "<%=strUsr_id%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
            
        with(document.form){
            eval("bkg_no").value       = "<%=bkgNo%>";
        }
            
        loadPage();
    }
</script>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type="hidden" name="bkg_no"/>
<input type="hidden" name="instr_rmk_seq" value ="" />

<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Inbound C/S USA_Instruction </span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close"	id="btn_close">Close</button>
			
	    </div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
	<div class="opus_design_inquiry">
		<div id="div1" name="div1"></div>
		
		<table class="search" border="0" style="width:;"> 
			<tr class="h23">
				<td width="670px"><input type="text" name="instr_rmk" maxlength="150" style="width:670px" value="" class="input"></td>
				<td class="align_left"><button type="button" class="btn_etc" name="btn_save"	id="btn_save">Save</button></td>
			</tr>
		</table>
	</div>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>		

</div>
</form>
