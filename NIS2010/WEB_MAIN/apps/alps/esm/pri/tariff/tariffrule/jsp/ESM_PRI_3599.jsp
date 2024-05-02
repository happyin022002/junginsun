<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3599.jsp
*@FileTitle : Tariff Rule Compare
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.10.19 송민석
* 1.0 Creation
=========================================================
* History
* 2012.08.09 원종규 [CHM-201219434] ALPS XSS 보완 관련 Pricing 부분 진행
*					- StringUtil.xssFilter 적용
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3599Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.diff.DiffList" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri3599Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.TariffRule");
	DiffList diffList = null;
	String trfPfxCd 		= JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
	String trfNo 			= JSPUtil.getNull(request.getParameter("trf_no"));
	String trfRuleNo		= JSPUtil.getNull(request.getParameter("trf_rule_no"));
	String amdtSeq1		= JSPUtil.getNull(request.getParameter("amdt_seq1"));
	String amdtSeq2		= JSPUtil.getNull(request.getParameter("amdt_seq2"));	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3599Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		diffList = (DiffList)eventResponse.getCustomData("DIFF_LIST");
 
		
		//svcScpCombo = PRIUtil.getValueObject2StringArray(comboData);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Rule Amend Detail Comparison</title>
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

<style> 
 
body{
	font-family:Tahoma; font-size: 10px;
	margin: 0px;}
	
 
table {border-collapse:collapse;}
 
TD			{font-family:Lucida Console; font-size: 12px; color: #333333;}
 
img {border : 0;}
input, select, textarea {font-family:Tahoma; font-size: 10px; }
 
#table_back { background:#FFFFFF; border:2px solid #bcdbf5;}
#table_back_tit { background:#FFFFFF; }
.table_td_tit {text-decoration: blink;font-family:Tahoma; font-size: 10px;font-weight:bold; vertical-align:top; padding-left:10px; padding-top:3px;padding-bottom:3px;background:#bbf0fb; border-right:2px solid #bcdbf5;border-bottom:2px solid #bcdbf5;}
.table_td_r_tit {text-decoration: blink;font-family:Tahoma; font-size: 10px;font-weight:bold;vertical-align:top; padding-left:10px; padding-top:3px;padding-bottom:3px;background:#bbf0fb; border-left:2px solid #bcdbf5;border-bottom:2px solid #bcdbf5;}

.table_td {vertical-align:top; padding:10px; border-right:1px solid #e0e0e0;}
.table_td_r {vertical-align:top; padding:10px; border-left:1px solid #e0e0e0;}
.table_td_a {vertical-align:top; padding:10px; background:#d9e9fb; border-right:1px solid #d9e9fb;}
.table_td_ar {vertical-align:top; padding:10px; background:#d9e9fb; border-left:1px solid #d9e9fb;}
.table_td_b {vertical-align:top; padding:10px; background:#e0f0bd; border-right:1px solid #e0f0bd;}
.table_td_br {vertical-align:top; padding:10px; background:#e0f0bd; border-left:1px solid #e0f0bd;}
.table_td_c {vertical-align:top; padding:10px; background:#f8edd3; border-right:1px solid #f8edd3;}
.table_td_cr {vertical-align:top; padding:10px; background:#f8edd3; border-left:1px solid #f8edd3;} 
.editNewInline { background-color: yellow ; padding:1px  }
.editOldInline { background-color: red ; padding:1px  }
</style>
 

</head>

<body  onLoad="setupPage();">
<!-- OUTER - POPUP (S)tart -->
<table width="979" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="979" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Tariff Rule Amend Detail Comparison
		</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
 

<table width="979" border="0" cellspacing="0" cellpadding="0" id="table_back">
  <tr>
    <td>
	    <table width="979" border="0" cellspacing="0" cellpadding="0" id="table_back_tit">
	    <tr>
	    <td width="475" class="table_td_tit"><%=trfPfxCd+"-"+trfNo %>, Rule No : <%= trfRuleNo%> , Amend No. : <font color=red><%= amdtSeq1 %></font></td>
	    <td width="29"></td>
	    <td width="475" class="table_td_r_tit">Amend No. : <font color=red><%= amdtSeq2 %></font></td>
	    </tr>
	    </table>
    
    <table width="979" border="0" cellspacing="0" cellpadding="0">
<%     
    int size = diffList.size();
	for(int i = 0 ; i < size ; i++){
//					log.debug(" Tag      :"+diffList.getTag(i));
//					log.debug(" Old Line :"+diffList.getOldLine(i));
//					log.debug(" New Line :"+diffList.getNewLine(i));
	
		// Line이 시작됨 현재는 변경된 tr과 변경되지 않은 tr이 같기 때문에 이렇게 코딩 됐음
		if( diffList.getTag(i) == DiffList.OPEN_TAG || diffList.getTag(i) == DiffList.OPEN_CHANGE_TAG){			
%>    
      		<tr>
<%		} %>     

<%
		// Line이 시작되는데 변경된 내용이 없는 Line의 Old Text를 찍는 column(TD)임
		if( diffList.getTag(i) == DiffList.OPEN_TAG ){ 
%>
        <td width="475" class="table_td">
         	<%= StringUtil.xssFilter(diffList.getOldLine(i))%>
 		</td>
        
<%
		//Line이 시작되는데 변경된 내용이 있을때  Line의 Old Text를 찍는 column(TD)임
		}else if( diffList.getTag(i) == DiffList.OPEN_CHANGE_TAG ){
%>     
		<td width="475" class="table_td_c">
 			<%= StringUtil.xssFilter(diffList.getOldLine(i))%>          
 		</td>
<%
		}
%>      

 		

<%
		//변경된 내용이 없을경우는 양 Text(TD) 사이가 빈 상태가 되도록 함.
		if( diffList.getTag(i) == DiffList.OPEN_TAG ){ 
%>
        <td width="29">&nbsp;</td>
<%
      	//변경된 내용이 없을경우는 양 Text(TD) 사이에 빨간 Bar를 그려줌.
		}else if( diffList.getTag(i) == DiffList.OPEN_CHANGE_TAG ){ 
%> 
		<td width="29">

 		<table width="29" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="4" style="background-color:#f8edd3;"></td>
          </tr>
        </table>
        </td>
 		

<%		} %>     



<%
		//Line이 시작되는데 변경된 내용이 없는 Line의 New Text를 찍는 column(TD)임
		if( diffList.getTag(i) == DiffList.OPEN_TAG ){ 
%>
        <td width="475" class="table_td_r">
 			<%= StringUtil.xssFilter(diffList.getNewLine(i))%>
 		</td>

<%
		//Line이 시작되는데 변경된 내용이 있을때 Line의 New Text를 찍는 column(TD)임
		}else if( diffList.getTag(i) == DiffList.OPEN_CHANGE_TAG ){ 
%>     
		<td width="475" class="table_td_cr">
 			<%= StringUtil.xssFilter(diffList.getNewLine(i))%>
 		</td>

<%
		} 
%>             

<% 
		//Line의 종료
		if( diffList.getTag(i) == DiffList.CLOSE_TAG || diffList.getTag(i) == DiffList.CLOSE_CHANGE_TAG){			
%>    
      		</tr>
<%		} %>     


<%	} %>    
      
    </table>
    </td>
  </tr>
</table>

	</td>
</tr>
</table>


<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td></tr>
			</table>
		</td></tr>
		</table>
	</td></tr>
</table>	
<!--Button (E) -->

</body>
</html>