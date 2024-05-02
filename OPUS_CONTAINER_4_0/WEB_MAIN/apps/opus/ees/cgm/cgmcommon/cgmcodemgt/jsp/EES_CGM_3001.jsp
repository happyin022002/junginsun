<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_3001.jsp
*@FileTitle  : Chassis pool company Manager (General Inventory Graphic)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil"%>
<%@ page import="com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm3001Event"%>

<%
	EesCgm3001Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; 
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
    String tRole = "";


	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm3001Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		UserRoleUtil uru = new UserRoleUtil();
		ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
		for(int i=0; i< curv.length; i++)
		{
			if(curv[i].getUsrRoleCd().equals("ENISADM"))
			{
			    tRole = "Authenticated";
			    break;
			}else if(curv[i].getUsrRoleCd().length() == 5)
			{
				// 1001 Permission 'CGM01'
				if( curv[i].getUsrRoleCd().equals("CGM01")
					//|| curv[i].getUsrRoleCd().equals("CGM02")
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
	} catch (Exception e) {
		out.println(e.toString());
	}
%>


<head>
<title>Chassis Pool Company Creation/Inquiry</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_knd_cd" value="Z" id="eq_knd_cd" />
<input type="hidden" name="eq_tpsz_cd" id="eq_tpsz_cd" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<div class="page_title_area clear">
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		    <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
		    <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>