<%
/*
=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : ESM_SAM_0306.jsp
*@FileTitle  : Customer
*@author     : Hipluscard
*@version    : 1.0
*@since      : 2017/06/07 
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sam.custmanage.custgroup.event.EsmSam0306Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0306Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.custmanage.custmain");
	// 승인처리용 정보
	String custGrpId	= JSPUtil.getParameter(request, "cust_grp_id");
	String procTpCd		= JSPUtil.getParameter(request, "proc_tp_cd");
	String mainPage 		= "";
    mainPage = request.getParameter("main_page");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmSam0306Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>MDM Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if		
		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
	
</script>
</head>


<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName" value="<%=screenName %>">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="creflag" value="N">
<input type="hidden" name="saveflag" value="N">
<input type="hidden" name="ibflag" value="">
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd %>">


<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; Group Customer</span></td></tr>
		</table>
		
		<!--Page Title, Historical (E)-->

			
		<!-- : ( Grid ) (S) -->
		<table width="100%" class="search"  id="leftTable"> 
            <tr>
                <td width="120">
                	<script language="javascript">ComSheetObject('sheet1');</script>
            	</td>
        	</tr>
        </table>
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
			
				<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="140">Group Customer Code</td>
							<td width="160">
								<input id="cust_grp_id" style="width: 100px; text-align: center; ime-mode:disabled;" class="input1" name="cust_grp_id" value="<%=custGrpId%>" maxlength="10" dataformat="uppernum" type="text" tabindex=1>
								<img src="img/btns_search.gif" name="btn_esm_sam_0301" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="480"><div style="display:none;width:480;color:red;" id="user_mdm_auth"></div></td>
						</tr>
					</table>				
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">	
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Group Cust Name</td>
							<td width="10" >
								<input id="cust_grp_nm" style="width: 280px;" class="input1" value="" name="cust_grp_nm" maxlength="50" dataformat="uppernum" otherchar="!@&()_/\- " type="text"  >
							</td>
							<td> </td>
							<td width="50"></td>
							<td width="50">No Use</td>
							    <td><input type="checkbox" name="delt_flg" value="" class="trans"></td> 
							<td width="150">Primary Customer Code</td>
							<td width="">
								<input id="cust_cd" style="width: 80px; text-align: center; ime-mode:disabled;" class="input1" name="cust_cd" maxlength="8" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_041" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<!-- <td width="90"></td> -->
						</tr>
						
					</table>	
			
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

			
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">REP. Office</td>
							<td width="150" >
								<input id="ofc_cd" style="width: 80px; text-align:center;" class="input1" value="" name="ofc_cd" maxlength="6" dataformat="engup" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_071" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="150">Sales Rep Code</td>
							<td width="150" >
								<input id="srep_cd" style="width: 100px; text-align:center;" class="input2" value="" name="srep_cd" maxlength="5" dataformat="uppernum" type="text" readonly >
							</td>
							<td width="">Value Base Seg. Class</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('vbs_clss_cd', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
							<td width="90"></td>
						</tr>
						<tr class="h23">
							<td width="">Need Base Seg. Class1</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('nbs_clss_cd1', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
							<td width="">Need Base Seg. Class2</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('nbs_clss_cd2', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
							<td width="">Need Base Seg. Class3</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('nbs_clss_cd3', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
						</tr>
					</table>
			
					<!-- <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Delete Flag</td>
							<td width="150" >
								<select style="width: 100px;" class="input" name="delt_flg" id="delt_flg" onChange="obj_change()";><option value="N">N</option><option value="Y" >Y</option></select>
							</td>
							<td width="150"></td>
							<td width="150" >
								
							</td>
							<td width="150"></td>
							<td width="150" >
								
							</td>
							<td width="150"></td>
							<td width="150" >
								
							</td>
					</table>	 -->
			
					
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:979;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab3')</script>
				</td></tr>
		</table>
		<!-- Tab ) (E) -->
		
		<!--TAB Mapping Customer -->
		<div id="tabLayer_customer" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
		        <tr class="h23">
	    	    	<td class="bg">
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2bsheet1_customer');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					
			            <!--  Button_Sub (S) -->
						<table width="100%" class="button"table border="0"> 
					       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td id="bth_cust_row_add"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t1bAdd" id="t2_btn_t1bAdd">Row Add</td>
									        <td class="btn2_right"></td>
									    </tr>
									    </table></td>
									<td id="bth_cust_row_del"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t1bDel" id="t2_btn_t1bDel">Row Delete</td>
									        <td class="btn2_right"></td>
									    </tr>
									</table></td>
								</tr>
								</table>
								
							</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
			    	</td>
		    	</tr>
	    	</table>
		</div>

		
<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CheckDup" id="btn_CheckDup">Check Duplicate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td id="btn_Save1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_Create1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Create">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td width="20" id="bottom_space"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
						</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
		
	</td></tr>
		</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
