<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EES_MNR_TESTMAIN.jsp
*@FileTitle : SPP-MNR LOGIN FOR TEST
*Open Issues :     
*Change history :   
*@LastModifyDate : 2009.11.17    
*@LastModifier : 박명신  
*@LastVersion : 1.0 
* 2009.07.01 박명신		   		
* 1.0 Creation 	 	   
=========================================================*/
%>
  
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	//ALP or SPP
	if(account.getAccess_system().equals("ALP")){      
		session.removeAttribute("MNR_ACCOUNT");     
		account.setAccess_system("ALP");       
		session.setAttribute("MNR_ACCOUNT",account);       
	}  	
			       
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>SPP-MNR LOGIN FOR TEST</title>  
<script language="javascript"> 
	function spp_login(){ 
		var loginType = "SPP";   
	    var vseq = document.form.vender_seq.value;
	    var ofcCd = document.form.ofc_cd.value;    
	    var user_id = document.form.user_id.value;      
		if(document.form.vender_seq.value == ""){  
			alert("SPP Login need VENDER_SEQ");   
			return;    
		}
		if(document.form.ofc_cd.value == ""){   
			alert("SPP Login need OFC CD");      
			return;       
		} 				  	        
		document.location.href = 'apps/alps/ees/mnr/spplogin/EES_MNR_TESTSUB.jsp?loginType=' + loginType + '&vseq=' + vseq + '&ofcCd=' + ofcCd + '&user_id=' + user_id;
	}   	      
			   
	function mnr_login(){   
		var loginType = "MNR";
		document.location.href = 'apps/alps/ees/mnr/spplogin/EES_MNR_TESTSUB.jsp?loginType=' + loginType;
	}
</script> 
</head>    
<body> 
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">  
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SPP-MNR LOGIN FOR TEST</td></tr>
</table> 
<table style="width:700;" border="0" cellspacing="0" cellpadding="0">
<tr>  
	<td style="width:65; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 13;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">VENDER SEQ</td>
	<td width="110"><input type="text" name="vender_seq" style="ime-mode:disabled;text-transform:uppercase;" class="input"></td>  
	<td>&nbsp;</td>    
</tr>    
<tr> 
	<td style="width:65; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 13;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">OFC CD</td>
	<td width="110"><input type="text" name="ofc_cd" style="ime-mode:disabled;text-transform:uppercase;" class="input"></td>
	<td>&nbsp;</td>    
</tr>   
<tr> 		 
	<td style="width:100; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 13;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">SPP POTAL ID(Bidding only)</td>
	<td width="110"><input type="text" name="user_id" class="input"></td>
	<td>&nbsp;</td>  	       
</tr>   
<tr>    	  
	<input type="button" value="SPP_LOGIN" style="cursor:hand;" onclick="javascript:spp_login();">       
	<input type="button" value="MNR_LOGIN" style="cursor:hand;" onclick="javascript:mnr_login();">    
</tr>  
</table>
</form>  
</body> 
</html>  