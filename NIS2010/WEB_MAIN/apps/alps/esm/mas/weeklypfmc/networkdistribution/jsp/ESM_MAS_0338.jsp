<%
/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_MAS_0338.jsp
*@FileTitle : Agreed Network Cost Ratio Table
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.19 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event.EsmMas0338Event"%>
<%
	EsmMas0338Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmMas0338Event)request.getAttribute("Event");

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
<title>Surcharge Location Group Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="grp_loc_seq" value="">
<input type="hidden" name="max_seq" value="0">
<input name="cd" type="hidden" value="">
<input name="etc1" type="hidden" value="">


<input name="saved_cost_yrmon" type="hidden" value="">

<!-- 개발자 작업	-->

 
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
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </table></td>

                <td class="btn1_line"></td>
                    <td><table width="98%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                </table></td>
 
                 <td class="btn1_line"></td>
                    <td><table width="98%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_month_copy">Month Copy</td>
                    <td class="btn1_right"></td>
                </table></td>               
            </tr>
            </table>
        </td></tr>
                </table>
        
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
      	
            <table class="search_in" width="990" border="0">
              <tr class="h23">                
                <td width="75">YYYY-MM</td>
                <td width="70"><input type="text" style="width:60" class="input1" name="f_cost_yrmon" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;</td>
                <td width="*">&nbsp;</td>
 
              </tr>
            </table>
				
				
				<!--  biz_2  (S) -->
		<table class="search"> 
       	<tr><td class="" width="40%">		
				<!-- Grid 1 (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
				<!-- Grid 1 (E) -->		
				
                 <!--Button (S) -->              
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_del">Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!--Button (S) -->   				

			
			</td>
			<td class="" width="2%"></td>
			<td class="" width="">			
				
			<!-- Grid 2 (S) -->	
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
				<!-- Grid 2 (E) -->		
				
				
					<!--Button (S) -->				
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_add2">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_del2">Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
						</table>
					</td></tr>
					</table>
				<!--Button (S) -->	
							
						
						
						 
						<!-- Grid (E) -->
						</td>
					</tr>
				</table>	
						
	
			
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
    </td></tr>
            </table>
</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>