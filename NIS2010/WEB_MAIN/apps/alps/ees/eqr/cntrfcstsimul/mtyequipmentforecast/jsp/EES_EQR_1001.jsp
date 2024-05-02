<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1001.jsp
*@FileTitle : OP/MG Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String optionStr = "";	
	String locSelectBox = JSPUtil.getCodeCombo("loc_grp_cd","L","","CD03052",0,optionStr);		

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
%>
<html>
<head>
<title>OP/MG Forecast Input</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="init_flag">
<input type="hidden" name="search_flag">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
	    <!--Button (E) -->
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50"><%= locSelectBox %></td>
					<td width="120">
						<input type="text" class="input" name="loc_cd" required style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill  style="width:50;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="120">Balance Report ID</td>
					<td width="160" class="sm"><input type="text" name="fcast_yrwk" required maxlength="7" style="width:60;" dataformat="yw"  class="input1" value=""> (YYYY-WW)</td>
					
                    <td>TP/SZ</td>
                    <td width="70"><%= cntrTpsz %></td>
                    <td colspan=8>&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 280, 1 )</script></td>
          
          
                    
<!--                    <td>-->
<!--						<table border="0" style="width:260;" class="search_sm2"> -->
<!--						<tr class="h23">-->
<!--							<td width="">-->
<!--								<input type="radio" name="viewFlag" class="trans" checked>&nbsp;DRY&nbsp;&nbsp;&nbsp;&nbsp;-->
<!--								<input type="radio" name="viewFlag" class="trans">&nbsp;SPCL(RF, OT, FR)-->
<!--								<input type="radio" name="viewFlag" class="trans">&nbsp;ALL-->
<!--							</td>-->
<!--						</tr>-->
<!--					    </table>-->
<!--					</td>-->
				</tr> 
				</table>
				<!--  biz_1   (E) -->
		<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		
			<!-- grid box (S) -->
			<table class="search" width="979" border="0">
			<tr><td valign="top" width="100%">	
					<!-- Grid - 1 (S) -->
					<table width="100%" height="" id="mainTable1" border="0"> 
						<tr>
							<td><script language="javascript">ComSheetObject('sheet1');</script></td>
						</tr>
					</table> 					 
					<!-- Grid - 1 (E) -->
				</td>
            </tr>
            </table>
            
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
            
            <table class="search" width="979" border="0">
              <tr><td width="352">
                    <table class="search" border="0">
                      <td class="title_h"></td>
                      <td class="title_s">Reference 1</td>
                      <td id="cntr_save_id" align="right"></td>
                    </table>
                  </td>
                  <td width="10"></td>
                  <td width="">
                    <table class="search" border="0">
                      <td class="title_h"></td>
                      <td class="title_s">Reference 2</td>
                    </table>
                  </td>
              </tr>
            
              <tr><td>  
                    <!-- Grid - 1 (S) -->
                    <table width="100%" height="" id="mainTable2" border="0"> 
                        <tr>
                            <td><script language="javascript">ComSheetObject('sheet2');</script></td>
                        </tr>
                    </table>                     
                    <!-- Grid - 1 (E) -->
                </td>
				<td></td>
				<td>
					<!-- Grid - 4 (S) -->
					 <table width="100%" height="" id="mainTable3" border="0">
						<tr><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
					</table> 
					<!-- Grid - 3 (E) -->	
				</td>
              </tr>
			</table>
      
			<!-- grid box (E) -->
		    <div id="tabLayer" style="display:none">
				<!-- Tab BG Box  (S) -->
  		   	<table class="search"> 
   	    	<tr><td class="bg">

				<!--  Grid_button (S) -->
				</td></tr>
			</table>

			</div>
			
			
		</td></tr>
		</table>			
		<!-- 2 (E) -->
		<!--biz page (E)-->
	
	
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>