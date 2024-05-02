<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName   : VOP_SCG_1005.jsp
 *@FileTitle  : SAVE DG Restriction by Port
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/12
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg1005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg1005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";


	
	String strPort_cd               =  "";
	String strPort_cd_nm            =  "";
	String strImdg_clss_cd          =  "";
	String strImdg_clss_cd_desc     =  "";
	String strImdg_un_no            =  "";
	String strImdg_un_no_seq        =  "";	
	String strOpt                   = "";
	String strImdg_port_rstr_seq    = "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.PortRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1005Event)request.getAttribute("Event");
		
		strPort_cd               =  event.getAttribute("port_cd"          ).toString();
		strPort_cd_nm            =  event.getAttribute("port_cd_nm"       ).toString();
		strImdg_clss_cd          =  event.getAttribute("imdg_clss_cd"     ).toString();
		strImdg_clss_cd_desc     =  event.getAttribute("imdg_clss_cd_desc").toString();
		strImdg_un_no            =  event.getAttribute("imdg_un_no"       ).toString();
		strImdg_un_no_seq        =  event.getAttribute("imdg_un_no_seq"   ).toString();
		strOpt                   =  event.getAttribute("optClass"         ).toString();
		strImdg_port_rstr_seq    =  event.getAttribute("imdg_port_rstr_seq" ).toString();
		 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

/*		
		strPort_cd               =  "CNCHG";
		strPort_cd_nm            =  "strPort_cd_nm";
		strImdg_clss_cd          =  "5";
		strImdg_clss_cd_desc     =  "strImdg_clss_cd_desc";
		strImdg_un_no            =  "1045";
		strImdg_un_no_seq        =  "1";		
		strOpt = "unno";*/
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
<input type="hidden" name="strOpt" value = "<%=strOpt %>">
<input type="hidden" name="imdg_port_rstr_seq" value = "<%=strImdg_port_rstr_seq %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>SAVE DG Restriction by Port</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowAdd" id="btn_rowAdd">Row Add</button><!-- 
			--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search"> 
	       		<tr>
	       			<td>
			
						<table class="search" border="0" style="width:580px;"> 
						<tr class="h23">
							<td width="320px">Port&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:60px;" class="input2" name='port_cd' readonly value="<%=strPort_cd %>">&nbsp;<input type="text"  readonly style="width:120px;" class="input2" name='port_cd_nm' value="<%=strPort_cd_nm %>"></td>
							<td>Class&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:114;" align='center'  readonly class="input2" name='imdg_clss_cd'  value="<%=strImdg_clss_cd %>"></td>
						</tr>
						<tr class="h23">
							<td width="">&nbsp;</td>
							<td style="padding-left:1">UN No./Seq.&nbsp;&nbsp;<input type="text" style="width:44px;"  readonly class="input2" name="imdg_un_no" value="<%=strImdg_un_no %>">&nbsp;<input type="text" style="width:44px;"  readonly class="input2" name='imdg_un_no_seq' value="<%= strImdg_un_no_seq  %>"></td></tr>
						</table> 
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</div>
<!-- popup_contens_area(E) -->
	
</form>