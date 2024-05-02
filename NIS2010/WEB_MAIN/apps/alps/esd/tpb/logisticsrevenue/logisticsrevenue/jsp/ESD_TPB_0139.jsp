<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_TPB_0139.jsp
*@FileTitle : Logistics Revenue Registration - Single
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-15
*@LastModifier : Kim Hyun Ju
*@LastVersion : 1.2
* 2015-02-26  불필요한주석 소스 정리-Kim Hyun Hwa
* 2015-03-10 [CHM-201534706] KIM HYUN HWA- Logistics(Operational) Revenue 에서 통화 관련 수정
=========================================================*/
%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.event.EsdTpb0139Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0139Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StatusInquiry.PerformanceInquiry");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String cnt_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	int p_state = 0;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		ofc_cd = account.getOfc_cd();
		cnt_cd = account.getCnt_cd();

		event = (EsdTpb0139Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String p_sdate = "";
	String p_edate = "";
	
	p_sdate = DateTime.addMonths(currentDay, -1, "yyyy-MM-dd");
	p_edate = currentDay;
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd, true ); // 0:Office Level / 1:Office Code / 2:RHQ Code / 3:HO Code
	String ofc_top_lvl = JSPUtil.getNull( TPBUtils.getOfficeTopLevel( ofc_cd ) );
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		
		var errMessage = "<%=strErrMsg%>";
		var p_state = "<%=p_state%>";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
		_text_ChangeUpperCase();
	}
</script>
</head>	
</head>
<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="p_state" value="<%=p_state%>">
<input type="hidden" name="s_usr_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_usr_id" 	  value="<%=strUsr_id%>" >
<input type="hidden" name="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_if_ctrl_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_vat_xch_rt" value="0">
<input type="hidden" name="s_ofc_cd" value="">
<input type="hidden" name="s_rhq_cd" value="">
<input type="hidden" name="s_cnt_cd" value="">
<input type="hidden" name="s_cust_cnt_cd" value="">
<input type="hidden" name="s_cust_seq" value="">
<input type="hidden" name="s_vndr_cnt_cd" value="">
<input type="hidden" name="s_vndr_seq" value="">
<input type="hidden" name="s_n3pty_ofc_cd" value="">
<input type="hidden" name="c_date" value="<%=currentDay%>" >

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
   		<td valign="top"><!--Page Title, Historical (S)-->
     		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
     		<%//@include file="/sys/common/menu/jsp/commonHeader.jsp"%>
      
			<!--Page Title, Historical (E)--> 
 			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_new_t">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new" id="btn_new">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_save_t" >
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save" id="btn_save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>			
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
      
      		<!--biz page (S)-->
			<table class="search">
        		<tr>
          			<td class="bg"><!-- biz_1  (S) -->
						<table width="100%" border="0" class="search">
							<tr class="h23">
                				<td class="title_h">&nbsp;</td>
                				<td class="title_s">Single Case Registration and Confirmation</td>
              				</tr>
            			</table>
            			<table class="search" border="0" style="width:979;">
             				<colgroup>
                				<col width="90px" >
                				<col width="170px" >
                				<col width="85px" >
                				<col width="200px" >
                				<col width="120px" >
                				<col width="140px" >
                				<col width="30px" >
                				<col width="" >
            				</colgroup>
              				<tr class="h23">
                				<td>TPB No</td>
								<td><input type="text" name = "s_n3pty_no" style="width:120px;" class="input2" value="" readonly></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>          
             				</tr>
              				<tr class="h23">
                				<td>Interface Type</td>
                				<td><%=TPBUtils.getCodeCombo("s_n3pty_if_tp_cd", "", "style='width:120', class='input1' required caption='Interface Type'", "CD00581", 0, "0:R:Logistics Revenue", "X")%></td>
                				<td>Expense Type</td>
                				<td width="230px;"><%=TPBUtils.getCodeCombo("s_n3pty_expn_tp_cd", "", "style='width:162'", "CD00580", 0, "001: :&lt;&lt;Select&gt;&gt;|", "")%></td>
                				<td>Logistics Rev. Code</td>
								<td>
									<select class="input1" name="s_n3pty_bil_tp_cd" style="width:110;" >
										<option value=''>&lt;&lt;Select&gt;&gt;</option> 
									</select>
								</td>
								<td>Yard</td>
		    					<td><input class="input1" name="s_re_yd_cd" type="text" maxlength="7" tabindex="1" style="width:70" style="text-transform:uppercase">
			        				<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yd">
			    				</td>	              
              				</tr>
              				<tr class="h23">
                				<td>Cost Office</td>
                				<td><script language="javascript">ComComboObject('s_if_ofc_cd',1,120,0,1);</script></td>
                				<td>Cost Period</td>
                				<td>
                					<table  border="0" class="search_sm2">
                  						<tr >
                    						<td><input type="text" name="s_sdate" maxlength="10" style="width:70;text-align:center" value="<%=p_sdate%>" caption="Date" dataformat="ymd">
                      							<img src="img/btns_calendar.gif" width="19" height="20" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;
                      							<input type="text" name="s_edate" maxlength="10" style="width:70;text-align:center" value="<%=p_edate%>" caption="Date" dataformat="ymd" >
                      							<img src="img/btns_calendar.gif" width="19" height="20" align="absmiddle" name="btns_calendar2">
                      						</td>
                  						</tr>
                					</table>
                				</td>
                				<td>Currency</td>
                				<td><select name="s_curr" class="input1" style="width:110px"></select></td>  
                				<td>Amount</td>
                				<td><input type="text" name = "s_dtl_amt" style="width:90px;text-align:right" class="input1" value="" dataformat="float" maxlength="14" pointcount="2" maxnum="99999999999.99"></td>
              				</tr>
              				<tr class="h23">
                   				<td>3rd Party</td>
				   				<td colspan="2">
				   					<select name="s_vndr_cust_div_cd" class="input1" style="width:120px">
										<option value=''>&lt;&lt;Select&gt;&gt;</option>
									  	<option value='C'>Customer</option>
									  	<option value='V'>S/P</option>
									</select>
					   				<input type="text" style="width:100;" name="s_trd_party_val" maxlength="8">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_3rdParty">
					   			</td>
				   				<td colspan="3">&nbsp;<input type="text" style="width:210px;" class="input2" value="" name = "s_trd_party_nm" readonly/></td>
				   				<td></td>
				   				<td></td>
	          				</tr>
               				<tr class="h23">
                				<td>Detail</td>
                				<td colspan="7"><textarea name="s_dtl_rmk" class="input" style="width:99.5%;height=70"  ></textarea></td>
              				</tr>
            			</table>
            			<div id='div_processing' name='div_processing' style='position: absolute; left: 0; top: 30; z-index: 100; display: none; width: 100%; height: 100%'>
						<table border='0' bordercolor='red' cellpadding='0' cellspacing='0' width='100%' height='100%'>
							<tr>
								<td align='center' height='10'>&nbsp;</td>
							</tr>
							<tr>
								<td align='center' height='100'><img src="/hanjin/img/alps/processing.gif"></td>
							</tr>
							<tr>
								<td align='center' height='*'>&nbsp;</td>
							</tr>
						</table>
						</div>
           			</td>     
        		</tr>
      		</table>
      		<!--biz page (E)-->
      	</td>
  	</tr>
</table>
<table class="height_5">
	<tr>
   		<td></td>
	</tr>
</table>

<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table> 
<!-- Grid (E) -->

</body>
</html>

