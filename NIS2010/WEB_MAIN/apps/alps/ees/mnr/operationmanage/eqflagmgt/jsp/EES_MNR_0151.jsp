<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0151.jsp
*@FileTitle : M&R Disposal Candidate Selection
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.08.05
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.08.05 권영법   
* 1.0 Creation    
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0151Event" %>
<%@ page import="org.apache.log4j.Logger" %>



<%

	EesMnr0151Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.EQFlagMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		
		event = (EesMnr0151Event)request.getAttribute("Event"); 
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
<title>M&R Disposal Candidate Selection</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
<script type="text/javascript">
//<![CDATA[
self.onerror = function() { return false; }
//]]>
</script> 

</head>
    
<body  onLoad="setupPage();" style="overflow:hidden">
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="cost_ofc_cd"> 
<input type="hidden" name="self_ofc_cd" value="<%=currOfcCd%>">  
<input type="hidden" name="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" value="RFS">
<input type="hidden" name="sel_type" value="S">
<input type="hidden" name="rqst_eq_no">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">  
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table> 
		<!--Page Title, Historical (E)-->      
	
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:995;" id="mainKeyName"> 
				<tr class="h23">
					<td width="130">Selection Type</td>
					<td width="100"><script language="javascript">ComComboObject('combo_select_cd',1, 80 , 1, 1,0,false,0);</script> 
					<input type="hidden" name="select_cd"></td>
					<td width="80">EQ KIND</td>
					<td width="100"><script language="javascript">ComComboObject('combo_eq_knd_cd',1, 80, 1, 1,0,false,0);</script> 
					<input type="hidden" name="eq_knd_cd"></td>
					<td width="90" align=right>EQ TP/SZ&nbsp;</td>
					<td width="20"><script language="javascript">ComComboObject('combo_eq_tpsz_cd', 2, 120 ,0)</script>
					<input type="hidden" name="eq_tpsz_cd"></td>   
					<td width="220" align=right>EQ Manufactured Year</td>
					<td width="320"><input type="text" maxlength=4 style="width:40;text-align:center;" class="input" name="fryear" dataformat="int" required fullfill>
					<img name ="btn_fryear" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;<input type="text" maxlength=4 style="width:40;text-align:center;" class="input" name="toyear" dataformat="int" required fullfill> <img name ="btn_toyear" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="80">EQ No.</td>
					<td width="140"><input name="rqst_eq_no_multi" type="text" style="width:80" class="input" dataformat="engup" disabled=true value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" disabled=true class="cursor">
					</td>  
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
		<td width="979">
			<table class="search" border="0" id="titleChangedName">
				<tr><td class="title_h"></td>
					<td class="title_s">Disposal Candidate Selection by Serial Range</td></tr>
			</table><!-- Disposal Candidate Selection by EQ No-->
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						<script language="javascript">ComSheetObject('sheet2');</script>
						<script language="javascript">ComSheetObject('sheet4');</script></td>
					</tr>
				</table >		
				<table> <!-- style="visibility:hidden;"> -->
				<tr><td>
				<script language="javascript">ComSheetObject('sheet5');</script>
				</td></tr>
				</table>		
				<!-- Grid (E) -->	
				
				
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_loadexcel_id">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_loadexcel">Load Excel<!--2--></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_rowadd_id">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_rowadd">Row Add<!--2--></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_rowdel_id">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_rowdel">Row Del<!-- 2 --></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_downexcel_id">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downexcel">Down Excel<!-- 1 --></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td></tr>
		</table>
		<!--biz page (E)-->

	<script language="javascript">ComSheetObject('sheet3');</script> 
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</td></tr>
		</table>
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
