<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ees_lse_0102.jsp
*@FileTitle : Interest calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.08 박명신
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>	
	
<%
	EesLse0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_off_cd    = "";
	String strCntrTpSzCd    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id     = account.getUsr_id();
		strUsr_nm     = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();

		event = (EesLse0102Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>	
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
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr>
	    <td valign="top">	
	    <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->	
		  <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr>
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Calculation">Calculation</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
	        </tr>
		    </table>
		     </td>
        </tr>
        </table>
        <!--Button (E) -->
	   
	    </td>
	</tr>
	<tr>
	    <td valign="top">	       
	        <!-- : ( Search Options ) (S) -->
            <table class="search"> 
       		<tr>
       		    <td class="bg">
			   
			    <table class="search" border="0" style="width:979;"> 
					<tr class="h23">	
					<td width="110">Contract Period</td>
					<td width="150">	
						<select name='contract_period' style='width:100;' dataformat='int'>
						<option value="3" selected>3 year</option>	
						<option value="5">5 year</option>	
						<option value="8">8 year</option>
						<option value="10">10 year</option>
						<option value="1">1 year</option>
						<option value="2">2 year</option>
						<option value="4">4 year</option>
						<option value="6">6 year</option>
						<option value="7">7 year</option>
						<option value="9">9 year</option>
						<option value="11">11 year</option>
						<option value="12">12 year</option>
						<option value="13">13 year</option>
						<option value="14">14 year</option>
						<option value="15">15 year</option>
						<option value="16">16 year</option>
						<option value="17">17 year</option>
						<option value="18">18 year</option>
						<option value="19">19 year</option>
						<option value="20">20 year</option>
						</select>
					</td>				
					<td width="">
						<table class="search" border="0" style="width:260;"> 
						<tr>			
						<td width="100"><strong>Payment Term</strong></td>		
						<td width=""><input name="payment_term" type="radio" value="4" class="trans" dataformat="int" checked>&nbsp;Quarterly&nbsp;&nbsp;&nbsp;<input name="payment_term" type="radio" value="12" class="trans" dataformat="int">&nbsp;Monthly</td> 
						</tr>						
						</table>
					</td>
					<td width="">
						<table class="search" border="0" style="width:360;"> 
						<tr>			
						<td width="120"><strong>Payment Method</strong></td>		
						<td width=""><input name="payment_method" type="radio" value="1" class="trans" dataformat="int" >&nbsp;Advance&nbsp;&nbsp;&nbsp;<input name="payment_method" type="radio" value="0" class="trans" dataformat="int" checked>&nbsp;Later</td> 
						</tr>						
						</table>
					</td>
					</tr>	
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0" style="width:579;"> 
					<tr class="h23">
						<td width="80">Principal</td>	
						<td width="200"><input name="principal" type="text" style="width:130; text-align:right;" readOnly="true" class="input2" dataformat="float" maxlength="30" pointcount="2"></td>
						<td width="60">Quantity</td>	
						<td width="100"><input required name="quantity" type="text" style="width:100; text-align:right;" class="input1" dataformat="int" maxlength="7">&nbsp;Unit</td></tr>
					<tr class="h23">		
						<td width="">Interest Rates </td>	
						<td width=""><input required name="i_rate" type="text" style="width:130; text-align:right;" class="input1" dataformat="float" maxlength="5" pointcount="2">&nbsp;%</td>
						<td width="">Unit Price</td>
						<td width=""><input required name="u_price" type="text" style="width:100; text-align:right;" class="input1" dataformat="float" maxlength="10" pointcount="2"></td></tr>
					<tr class="h23">	
						<td width="">Number of Payment </td>	
						<td width=""><input name="n_payment" type="text" style="width:130; text-align:right;" readOnly="true" class="input2" dataformat="int"></td>
						<td width="">PMT</td>
						<td width=""><input name="pmt" type="text" style="width:100; text-align:right;" class="input2"  dataformat="float" readOnly="true" pointcount="2">
						<input name="pmt_diem" type="text" style="width:80; text-align:right;" class="input2"  dataformat="float" readOnly="true" pointcount="2">	
						</td>
					</tr>
				</table>	
			    <!-- : ( Search Options ) (E) -->
 
			    </td>
      	    </tr>
		</table>		
	    <table class="height_8"><tr><td></td></tr></table>
	    <table class="search" id="mainTable"> 
       	   <tr>
       	       <td class="bg">			
				   <!-- Grid  (S) -->
				   <table width="100%"  id="mainTable"  border="0">
				       <tr>
					       <td width="100%">
					           <script language="javascript">ComSheetObject('sheet1');</script>
					       </td>
					       <td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
						   </td>
				       </tr>
				   </table>
				   <!-- Grid  (e) -->		
				   <!--  Button_Sub (S) -->
			       <table width="100%" class="button"> 
	       	           <tr>
	       	               <td class="btn2_bg">
		                       <table border="0" cellpadding="0" cellspacing="0">
		                          <tr>
		                              <td>
		                              </td>
				                      <td>
				                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                      <tr>
						                          <td class="btn2_left"></td>
						                          <td class="btn2" name="btn_DownExcel">Down Excel</td>
						                          <td class="btn2_right"></td>
						                      </tr>
						                  </table>
				                      </td>
				                  </tr>
			                   </table>
			               </td>
			           </tr>
			       </table>
	    	       <!-- Button_Sub (E) -->	   
			   </td>
			</tr>
		</table>
        </td>
    </tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>