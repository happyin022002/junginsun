<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EES_MNR_TESTSUB.jsp
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

	String loginType = request.getParameter("loginType");   
	String vseq = JSPUtil.getParameter(request, "vseq");      
	String ofcCd = JSPUtil.getParameter(request, "ofcCd");    
	String userId = request.getParameter("user_id");    
	String userNm = "SPP_TESTER";  
	
	//2014-05-28 Justin Han recovered R4J defects.
	StringBuffer userNm_tmp = new StringBuffer();
	userNm_tmp.append(userNm);
	
	vseq = vseq.toUpperCase();      
	ofcCd = ofcCd.toUpperCase(); 
	
	if(userId != null && !userId.equals("")){    
//		userNm =  userNm + "(" + userId + ")"; 
		userNm_tmp.append("(").append(userId).append(")");
		userNm = userNm_tmp.toString();
		
	} else {
		userId = "SPP_TESTER(DEF)";   
		userNm = "SPP_TESTER(DEF)";  
	}
						
	if(loginType.equals("SPP")){      
		SignOnUserAccount sppAccount 
		= new SignOnUserAccount(  
				//usr_id 
				userId,     
				//usr_nm
				userNm ,  
				//usr_pwd
				"", 
				//use_flg
				"", 
				//mphn_no
				"", 
				//usr_eml
				"", 
				//cnt_cd
				"", 
				//lang_tp_cd
				"", 
				//cre_usr_id
				"", 
				//cre_dt
				"", 
				//upd_usr_id
				"", 
				//upd_dt
				"", 
				//ofc_cd
				ofcCd, 
				//ofc_eng_nm
				vseq,    
				//ofc_krn_nm
				"VENDER NAME",      
				//usr_auth_tp_cd
				"", 
				//usr_locl_nm
				userNm,  
				//mn_scrn_opt_id
				"", 
				//rhq_ofc_cd
				"", 
				//xtn_phn_no
				"", 
				//fax_no
				"", 
				//srep_cd
				"");				 
		sppAccount.setAccess_system("SPP");         
		session.removeAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		session.setAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT,sppAccount);   
	} else {      	
		SignOnUserAccount mnrAccount = (SignOnUserAccount) session.getAttribute("MNR_ACCOUNT");	
		mnrAccount.setAccess_system("ALP");       
		session.removeAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);   
		session.setAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT,mnrAccount);  	
	}     	      
%>  	   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MNR_LOGIN</title> 
</head>
<script language="javascript">  
	alert('<%=loginType%>' + ' logging successed');  
 	history.go(-2);              
</script>

<body>

</body>
</html>  