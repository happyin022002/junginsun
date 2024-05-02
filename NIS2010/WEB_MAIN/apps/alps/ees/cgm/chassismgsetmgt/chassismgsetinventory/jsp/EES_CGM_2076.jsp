<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2076.jsp
*@FileTitle : M.G.Set Inventory Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.09.09 조재성
* 1.0 Creation
* 2012.10.04 [CHM-201220356-01] 2011514 조경완 M.G.Set의 General Inventory 조회 주건에 Disposal Candidate 조회 조건 추가
* 2015.06.22 [CHM-201536277] Chang Young Kim @FileTitle 변경 ( General Inventory -> M.G.Set Inventory Summary )
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2076Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2076Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strOfc_id   = "";
    
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_id = account.getOfc_cd();
        
		event = (EesCgm2076Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>General Inventory</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="yd_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" >
<!-- radio에서 combo로 대체됨. 
<input type="hidden" name="atch_bare">
<input type="hidden" name="dmg_snd">
 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Location</td>
					<td width="200" style="padding-left:2">
					<script language="javascript">ComComboObject('location', 1, 67, 0, 1, 1, true);</script>&nbsp;<input type="text" name="crnt_loc_cd" dataformat="engup" maxlength="5" style="width:60;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_crnt_loc_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
                    <td width="78">Yard</td>
					<td width="215"><input type="text" name="crnt_yd_cd" dataformat="engup" style="width:150;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_crnt_yd_cd" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="100">Active Status</td>
					<td width="150"><script language="javascript">ComComboObject('aciac_div_cd', 1, 100, 0, 0, 1, true);</script></td>
					<td width="90">Disposal</td>
                    <td width="" style="padding-left:2"><script language="javascript">ComComboObject('disp_cd', 1, 70, 0, 0, 1, true);</script>&nbsp;</td>
				</tr>
                </table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Group By</td>
                    <td width="200" style="padding-left:2"><script language="javascript">ComComboObject('group1', 1, 131, 0, 0, 1, true);</script></td>
                    
                    <td width="80">Attach/Bare</td>
                    <td width="213" ><script language="javascript">ComComboObject('atch_bare', 1, 100, 1, 0, 1, true);</script></td>
                    <td width="100">Damage/Sound</td>
                    <td width="150"><script language="javascript">ComComboObject('dmg_snd', 1, 100, 1, 0, 1, true);</script></td>
                    
                    <!-- 
                    <td width="50"></td>
                    <td width="150"><input type="radio" name="rdo_atch_bare" value="ATTACHED" class="trans" >Attached&nbsp;&nbsp;&nbsp;<input type="radio" name="rdo_atch_bare" value="BARE" class="trans" checked>Bare</td>
                    
                    <td width="88"></td>
                    <td width="150"><input type="radio" name="rdo_dmg_snd" value="DAMAGE" class="trans" >Damage&nbsp;&nbsp;&nbsp;<input type="radio" name="rdo_dmg_snd" value="SOUND" class="trans" checked>Sound</td>
                    -->
                    <td width="90">M.G.Set Type</td>
                    <td width="" style="padding-left:2"><script language="javascript">ComComboObject('eq_tpsz_cd', 1, 70, 0, 0, 1, true);</script>&nbsp;</td>
               
                    <td></td>
                                        			
			    </tr>
				</table>
			</td></tr>
			</table>	
				
		
		<!-- Tab BG Box  (S) -->
			<table class="height_8"><tr><td></td></tr></table>
	<!-- Tab (S) -->
     	
	<!-- Tab (E) -->
	<table class="search"> 
       	<tr><td class="bg">
	
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				

			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->

			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			
			
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
		</td>
				</tr>
			</table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
		</td></tr>
</table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>