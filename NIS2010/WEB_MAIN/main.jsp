<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/com_main.tld" prefix="mainpage"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil"%>
<%@ page import="com.tobesoft.iam.utility.TBStringUtil"%>
<%@ page import="com.tobesoft.iam.utility.TBHttpUtil"%>
<%@ page import="com.tobesoft.iam.virtualagent.TBVirtualAgent"%>
<%@ page import="com.tobesoft.iam.virtualagent.TBVirtualConfig"%>
 
<%
  /**
   * SSO로그인 폼 페이지  
   *
   * Parameter
   *  - TARGET : 인증(SSO,내부)완료후 이동할 URL.
   *             TB_LOGINPOST_URL페이지로 값을 전달한다.
   * Desc
   *   SSO 로그인 페이지.
   */

  /**1. VirtualAgent 초기화 */
  TBVirtualAgent  VA = new TBVirtualAgent();
  TBVirtualConfig VC = VA.getConfig();

  /**2. TARGET 재 정의 */
  String SMPREFIX = "-SM-";
  String TARGET = TBStringUtil.nullString(request.getParameter("TARGET"));
  //out.print(TARGET);
  int sp = TARGET.indexOf(SMPREFIX);
  if( sp != -1 ) TARGET = TARGET.substring(SMPREFIX.length());
  if( TARGET.indexOf(VC.getLoginPostUrl()) == -1 ) {
    TARGET = TBHttpUtil.appendQueryString(VC.getLoginPostUrl(), "TARGET", TARGET);
  }

  /**3. SMSESSION이 존재한다면, TB_LOGINPOST_URL 페이지로 이동한다. */
  String SMSESSION   = TBHttpUtil.getCookie(VC.getSessionName(), request);
  //String TB_RETRY_NO = TBHttpUtil.getCookie("TB_RETRY_NO", request);

  SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
  if(account != null){
  	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("com.hanjin.logincnt");
  	log.info("LoginCnt; " + account.getUsr_id() +"; " + request.getRemoteAddr() + "; " + SiteConfigFactory.get(SiteConfigFactory.SYSTEM_TYPE));
  }
  
//SSO Enable 여부(site-config.properties 파일)
  String ssoEnabled = SiteConfigFactory.get(SiteConfigFactory.SSO_ENABLED);
  String smAgentName = SiteConfigFactory.get("COM.HANJIN.SSO.SM.AGENT.NAME");
  String ssoTargetUrl = SiteConfigFactory.get("COM.HANJIN.SSO.TARGET");
  String adminPgmNo = SiteConfigFactory.get("COM.HANJIN.MENU.ADMIN.PROGRAM.CODE");
  String comPopupEnabled = SiteConfigFactory.get("COM.HANJIN.COMMON.POPUP.ENABLED");
  String loginSkipWhenSSO = SiteConfigFactory.get("COM.HANJIN.SSO.LOGIN.SKIP");
  String message    = request.getParameter("FORM_MESSAGE");
 // String SSLPORT    = SiteConfigFactory.get("COM.SSL.PORT");
  
 boolean skipFlag = false;
  if ( !(( message!=null )&&( message.length()>0 )) && !TBStringUtil.isNullOrZero(SMSESSION) && !SMSESSION.equals("LOGGEDOFF")
		  && account == null && ssoEnabled.equals("TRUE") && loginSkipWhenSSO.equals("TRUE") )
	  skipFlag = true;
%>
<% if( skipFlag ) { %>
  <script>
    document.location.href = '<%=TARGET%>';
  </script>
<%
  }
  //out.print(TARGET);
%>

<% 
//2015.06.18 partner.hanjin.com security essue
String sppDomain = SiteConfigFactory.get("COM.SPP.DOMAIN");
String sppLoginJsp = SiteConfigFactory.get("COM.SPP.LOGIN.JSP");
  
if(sppDomain != null && request.getHeader("host").contains(sppDomain)){%>
  <script>
    document.location.href = '<%=sppLoginJsp%>';
  </script>
<%
	return;
  }
%>

<%
Exception piex   =null;                           //서버에서 발생한 에러
String strErrMsg ="";                             //에러메세지
try {
	piex=(Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	if (piex !=null) {
		strErrMsg =new ErrorHandler(piex).loadPopupMessage();
	}
}catch(Exception exx) {
	 out.println(exx.getMessage());
}

String error_kind = request.getParameter("FORM_ERR_KIND");

String cookieUserId="";
String cookieUserName="";
Cookie[] cookies = request.getCookies();

if (cookies != null) {
		for (int loop = 0; loop < cookies.length; loop++) {
			//System.out.println(loop + ")" + cookies[loop].getName() + "=" + cookies[loop].getValue());
				if (cookies[loop].getName().equals("bp_signon")) {
						 cookieUserId=cookies[loop].getValue();
				}
				if (cookies[loop].getName().equals("bp_signon_user_name")) {
						 cookieUserName=cookies[loop].getValue();
				}
		}
}

// Office  Change
	String changeOffice = request.getParameter("usr_chg_ofc_cd");
	
	if(changeOffice!=null && account != null ){
		org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("com.hanjin.logincnt");
		account.setOfc_cd(changeOffice);		
		log.info(">> Change User Office ; " + account.getOfc_cd() );
	}

	
    /////////////////////// SSL start /////////////////////////////////
    String SSLPORT    = SiteConfigFactory.get("COM.SSL.PORT","");
    String SSLUSE    = SiteConfigFactory.get("COM.SSL.USE","");
    String SSLURL = "";

    if(SSLUSE.equalsIgnoreCase("0"))
  	{
  		if(SSLPORT != "")
  			SSLPORT = ":" + SSLPORT;
  		
		
		if(request.getHeader("host").indexOf(":") < 0)
			SSLURL = "https://" + request.getHeader("host");	
		else
  			SSLURL = "https://" + request.getHeader("host").substring(0, request.getHeader("host").indexOf(":", 1))  + SSLPORT;

  	}
  /////////////////////// SSL end /////////////////////////////////
 if(request.getParameter("redirectURL")!=null)
  	ssoTargetUrl = ssoTargetUrl +"&redirectURL=" + request.getParameter("redirectURL");

  /////////////////////// non-SSo LINK  /////////////////////////////////
  String nonSsoLinkEnabled = "FALSE";
	  if(request.getHeader("host").indexOf("alpsdev") > -1)
	  {
		  nonSsoLinkEnabled = "TRUE";	
	  }
%>

<html>
<head>
<title>ALPS</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8, requiresActiveX=true"/>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel="shortcut icon" href="/hanjin/img/favicon.ico" type="image/x-icon" />

<style type="text/css">
.button {
    background-color: 2px solid #999999;
    border: none;
    color: white;
	font-family: "Lucida Grande", Geneva, Verdana, Arial, Helvetica, sans-serif;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 11px;
    margin: 4px 2px;
/*     -webkit-transition-duration: 0.4s; /* Safari */ */
    cursor: pointer;
}

.button4 {
    background-color: #999;
    border-radius: 12px;
    color: white;
    border: 2px solid #e7e7e7;
}

</style>

</head>
<script language="javascript" src="/hanjin/js/swfobject.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript">

var xmlHttp;
// 2011 3 29 hyunsu added 
var openWindowsCount = new Array();

function createXMLHttpRequest() {
    if (window.ActiveXObject) {
      xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
      xmlHttp = new XMLHttpRequest();
    } else {
      alert("XMLHttpRequest create failed.");
    }
}

function encryptCallback() {
  fm = document.forms[0];
  if (xmlHttp.readyState == 4) {
    if (xmlHttp.status == 200) {
        var passwords = xmlHttp.responseXML.getElementsByTagName("password");
        fm.PASSWORD.value = passwords[0].firstChild.data;
      fm.submit();
      } else if (xmlHttp.status == 204){
          alert("password service error");
      }
  }
}


function goSubmit() {
  var fm = document.existingcustomer;
  fm.action = "<%=SSLURL%>/siteminderagent/forms/login.fcc";
  if( document.all("s_username").value == "") {
    alert("Enter UserId !");
    document.all("s_username").focus();
  } else if(document.all("s_password").value == "") {
    alert("Enter Password !");
    document.all("s_password").focus();
  } else {
    // Save ID
    //if(document.all("CheckSaveUserID").checked){
    //  setCookie("Login", document.all("USER").value, 365); 
    //}
    fm.USER.value = document.all("s_username").value;
    createXMLHttpRequest();
    
    try {	
    	var url = "<%=SSLURL%>/hanjin/sso/encryptpwd.jsp";
    	xmlHttp.open("POST", url, true);
		xmlHttp.onreadystatechange = encryptCallback;
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send("pwd=" + encodeURIComponent(document.all("s_password").value));
    } catch(e) {
    	window.open("noticeSSL.jsp","_blank","toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width=425, height=690");
    }
  }
}
function SSO_GUIDFindID()
{
	var url = "http://im.hanjin.com/jsp/find_guid.jsp?system=GW";
	
	if(document.location.hostname.lastIndexOf("dev") > -1) 
	{
		url = "http://imdev.hanjin.com:8090/jsp/find_guid.jsp?system=GW";
	}
	 
	window.showModalDialog(url, self, "dialogLeft:400px; dialogTop:400px; dialogWidth:400px; dialogHeight:500px");

}
function SSO_GUIDForget()
{
	var uname = document.all("s_username");
	if (uname.value == "")
	{
		alert( "Input your Global ID" );
		uname.focus();
	}
	else
	{
		var url = "http://im.hanjin.com/jsp/forgotten_password.jsp?guid="+uname.value;
		
		if(document.location.hostname.lastIndexOf("dev") > -1) 
		{
			url = "http://imdev.hanjin.com:8090/jsp/forgotten_password.jsp?guid="+uname.value;
		}
	
		var retval = window.showModalDialog(url, self, "dialogLeft:400px; dialogTop:400px; dialogWidth:400px; dialogHeight:500px");
		if(retval != null) document.all("s_password").value  = retval;
		//window.open(url,'_blank','width=200,height=200,scroll=auto')
	}
}

function module_pop(id) {
<% if (account == null) { %>
	alert('The requested web page requires that you sign in first. \nPlease enter your alps.smlines.com USER GID(Global ID) and password');
<% } else { %>
    try {
    	 
    	//if (id=='VOP_OPF_M001') alert('The menu of terminal operation (TOR creation, Port time Performance, Cargo handling Performance and Terminal Productivity) has been dually running in "Terminal Operation and Operation&PFMC", but the releated menu of terminal operation will be completely transfered to Terminal Operation moudle by May15, 2012. So, from now on, we suggest you to use the TOR moudle for your terminal operation jobs.');
    	
        var iWidth = 1024;
        var iHeight = 700;
        var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
        var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
        var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos+", resizable=yes, scrollbars=yes";
        //document.getElementById("ifr_option").src = "UserManagementGS.do?f_cmd=11&mn_scrn_opt_id="+joinDisplayAtt();
        var winObj = window.open("alpsMain.screen?parentPgmNo="+id,"",sFeatures);
        winObj.focus();
        //return winObj;

        // 2011 3. 29 hyunsu 
        // Add Windows count
        openWindowsCount[openWindowsCount.length] = winObj;
        
    } catch(err) { alert(err.message); }
<% } %>
}
function bookmark_icon_select(){}
function program_load(pgmNo, pgmUrl) {
	var modulePgmNo = pgmNo.substring(0, 8)+'M001';
	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;
	if ( pgmNo.indexOf("COM_ENS") > -1 ) modulePgmNo = "ESM_BKG_M001";
	if ( modulePgmNo.substring(0,3) == 'ADM' ) modulePgmNo = '<%=adminPgmNo %>';
	module_pop(modulePgmNo+src);
}
function submitForm() {
	
	with(document.existingcustomer)
	{
		//	action = "j_signon_check.do";
		action = "<%=SSLURL%>"+"/hanjin/j_signon_check.do";
		if(document.all("t_username").value.length < 1){
			return ComAlertFocus(document.all("t_username"), "Enter UserId !");
		}
		if(document.all("t_password").value.length < 1){
			return ComAlertFocus(document.all("t_password"), "Enter Password !");
		}
		j_username.value = document.getElementById("t_username").value;
		j_password.value = document.getElementById("t_password").value;
		submit();
	}
}
function toggleSSOLoginForm(flag) {
	if (flag) {
		document.getElementById("ssoDIV").style.display = "block";
		document.getElementById("localDIV").style.display = "none";
		document.all.s_username.focus();
	} else {
		var confirmFlag=confirm("Please use non-SSO mode for emergency.\nPress OK to continue.")
		if (confirmFlag) {
			document.getElementById("ssoDIV").style.display = "none";
			document.getElementById("localDIV").style.display = "block";
			document.all.t_username.value = "<%= cookieUserId %>";
			document.all.t_password.focus();
		} else {
			toggleSSOLoginForm(true);
		}
	}
}

//기존에 시트가 설치 되었는지 확인함.
//신규버전인지 버전정보를 확인 설치가 필요할경우 'true'를 리턴한다.
function isInstall(){
	var obj = document.getElementById('sheet');
	if(obj == null || obj.Version == undefined)
		return true;
    else if(obj.Version != SHEET_VERSION.replace(/\,/gi, "\.")){
		var arrOld = obj.Version.split("\.");
		var arrNew = SHEET_VERSION.split("\,");
		for(var i in arrOld){
			arrOld[i] = ComLpad(arrOld[i], 3, "0");
			arrNew[i] = ComLpad(arrNew[i], 3, "0");
		}
		if(arrOld.join("") < arrNew.join(""))
			return true;
		else
			return false;
	}else
		return false;
}
function setupPage(){

 	// Alert Message !
 	showAlertMessage();
 	
 	
	//IBSheet의 설치나 버전 상태에 따라 인스톨 페이지로 넘어간다.
	//Windows7의 보안 관련 강화에 따라 팝업에서 화면 전환 방식으로 수정함.
//		location.href = "noticeIbsheet.jsp";

	if(isInstall()){
		location.href = "noticeIbsheet.jsp";
	}else{
<% if(( message!=null )&&( message.length()>0 )){ %>
	ComShowMessage(   "<%= JSPUtil.replace(JSPUtil.replace(message,"\n",""),"\"","'") %>" );
<% } else if(( message!=null )&&( message.length()>0 )){ %>
	ComShowMessage(   "<%= JSPUtil.replace(JSPUtil.replace(message,"\n",""),"\"","'") %>" );
<% }  %>

<% if(account == null && ssoEnabled.equals("FALSE")) { %>
	with(document.all)
	{
			eval("t_username      " ).value="<%= cookieUserId %>";
			if ("<%=cookieUserId%>".length>0) {
					eval("t_password      " ).focus();
			}else{
					eval("t_username      " ).focus();
			}
	}
<% } %>
	}
	
}
function manageBookmark(){
	<% if(account != null) { %>
	var tmp =window.showModalDialog("BOOKMARK.do", window, "scroll:no;status:no;help:no;dialogWidth:600px;dialogHeight:400px");
	refreshBookmark();		
	<% } %>
}

function refreshBookmark(){
	document.getElementById("ifbookmark").src="mainBookmark.screen";
}

function common_pop() {
	window.open('/hanjin/sample/bizcommon/index.html','');
}

function signature(on_off) {
	try {

		//2014.11.06 logout message
		if(on_off=="Off")
			{
				if (!ComShowConfirm("Do you want to really logout? All systems will be disconnected.")){
					return;
				}
			}

		if ( window.opener && !window.opener.closed ) {
			if ( window.opener.parent ) {
				window.opener.top.signature(on_off);
			} else {
				window.opener.signature(on_off);
			}
			self.close();
		} else {
			document.location.href = "/hanjin/Sign"+on_off+".do";
		}
	} catch(e) {
		document.location.href = "/hanjin/Sign"+on_off+".do";
	}
}


function signature2(on_off) {
	try {

		if ( window.opener && !window.opener.closed ) {
			if ( window.opener.parent ) {
				window.opener.top.signature(on_off);
			} else {
				window.opener.signature(on_off);
			}
			self.close();
		} else {
			document.location.href = "/hanjin/Sign"+on_off+".do";
		}
	} catch(e) {
		document.location.href = "/hanjin/Sign"+on_off+".do";
	}
}

function ComIsSheetTag(sheetid){
    try {
       var sTag = "";
       sTag += '<OBJECT ID="'+sheetid+'"\n';
       sTag += ' CLASSID="'+CLSID_IBSHEET+'" \n';
       sTag += ' CODEBASE="'+CODEBASE+'"> \n';
       sTag += ' <param name="Visible" value="false"> \n';
       sTag += '</OBJECT>';
       document.write(sTag);
    } catch(err) { ComFuncErrMsg(err.message); }
}	

 //////////////////////2010.11.16 imsi ////////////////////////
 
    function installComboTag(){
//		location.href = "noticeIbsheet.jsp";
	     try {
	       var sTag = "";
  		   var COMBO_VERSION = "1,5,10,11";
 		   var CLSID_IBMCOMBO = "CLSID:D9FA9278-6363-4906-A14E-0AFB460CEA90";
      	   var CODEBASECOMBO = "/hanjin/sheet/IBMultiComboU.CAB#version="+COMBO_VERSION;
           sTag += '<OBJECT id="ibCombo" \n';
           sTag += '        CLASSID="'+CLSID_IBMCOMBO+'" \n';
           sTag += '        CODEBASE="' + CODEBASECOMBO + '" > \n';
           sTag += ' <param name="Visible" value="false"> \n';
           sTag += '</OBJECT> \n';
	        document.write(sTag);
	     } catch(err) { ComFuncErrMsg(err.message); }
	    
	 }
 
 //////////////////////2010.11.16 END ////////////////////////
 
 // ----------------- Alert Message Check -----------------------------

	function showAlertMessage()
	{
		if ( getCookie( "alertMessage" ) != 'done' ) {
			// document.getElementById("alert01").style.visibility = 'visible';
			
			// 공지사항 중지
			document.getElementById("alert01").style.visibility = 'hidden';
		}else{
			document.getElementById("alert01").style.visibility = 'hidden';
		}
	}

	function messageConfirm() {
		var no_more = document.getElementById("no_more").checked;
		if ( no_more )
		{ 
			setCookie('alertMessage', 'done', 1);
		}
		document.getElementById("alert01").style.visibility = 'hidden';
	}

	function setCookie( name, value, expiredays )
	{
		var todayDate = new Date();
		todayDate.setDate( todayDate.getDate() + expiredays );
		document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";";
	} 
 
	function getCookie(name) {
		var nameOfCookie = name + "=";
		var x = 0;
		while (x <= document.cookie.length) {
			var y = (x + nameOfCookie.length);
			
			if (document.cookie.substring(x, y) == nameOfCookie) {
				if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
				{
					endOfCookie = document.cookie.length;
				}
				return unescape(document.cookie.substring(y, endOfCookie));
			}
			x = document.cookie.indexOf(" ", x) + 1;
			if (x == 0)
				break;
		}
		return "";
	}

 // ----------------- Alert Message Check -----------------------------

 	function changeOffice(obj){
 	 	if(openWindowsCount.length != 0 ){
 	 	 	if(confirm("To login to another office, all open ALPS windows must be closed.   \nPlease make sure that you completed your job with the ALPS windows. \nIs it ok to close all open windows?"))
 	 	 	{
 	 	 		submitChangeOffice(obj);
 		 	 	for( var i = 0; i < openWindowsCount.length; i++)
 		 	 	{
 					var windowsopen = openWindowsCount[i];
 					windowsopen.CloseAllChild();
 		 	 	}
 	 	 	 		
 	 	 	}else{
 	 	 	 	obj.value = '<%= account != null ? account.getOfc_cd() : "" %>';
 	 	 	}
 	 	}else{
 	 		submitChangeOffice(obj);
 	 	}
	}

	function submitChangeOffice(obj){
	 		signature('On');
	 		document.forms[0].action="MainPage.do";
	 		document.forms[0].usr_chg_ofc_cd.value = obj.value
	 	 	document.forms[0].submit();
	}


</script>
<SCRIPT LANGUAGE="javascript" FOR="document" EVENT="onkeyup">
<!--
		/****************************
		 enterKey 처리
		*****************************/
		try {
			if (window.event.keyCode!=13) return;
			var srcName=window.event.srcElement.getAttribute("name");
			with(document.all)
			{
				switch(srcName)
				{
					case "t_password":
						 submitForm();
						 break;
					case "t_username":
						 eval("t_password").focus();
						 break;
		            case "s_password":
		            	goSubmit();
		            	break;
					case "s_username":
						 eval("s_password").focus();
						 break;
				}// end switch
			}// end with
		}catch(e) {
		}
//-->
</SCRIPT>

<style type="text/css">
.2d     { padding:0; font-family: Arial,dotum; font-size: 10px; vertical-align: middle; line-height:15px; }
.2d A:link    	{ color:#737A81; text-decoration:none; }
.2d A:visited 	{ color:#737A81; text-decoration:none; }
.2d A:hover   	{ color:#C238E5; text-decoration:underline; }
</style>
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css">

<form  name="existingcustomer" action="j_signon_check.do" method="POST">
<input type="hidden" name="j_remember_username" value="Y">
<input type="hidden" name="FORM_ACTION_TYPE"    value="">
<input type="hidden" name="FORM_ERR_KIND"       value="<%= error_kind %>">
<input type="hidden" name="annNo"    value="">
<input type="hidden" name="j_username">
<input type="hidden" name="j_password">
<!-- SSO관련 변경 INPUT 추가 -->
<input type="hidden" name="USER">
<input type="hidden" name="PASSWORD">
<input type="hidden" name="smagentname" value="<%=smAgentName %>">
<input type="hidden" name="TARGET" value="<%=ssoTargetUrl %>">
<input type="hidden" name="smauthreason" value="0">
<input type="hidden" name="usr_chg_ofc_cd" value="0">
<input type="hidden" name="redirectURL" value="<%=request.getParameter("redirectURL") %>">
</form>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage()">
<table width="963" height="100%" border="0" cellspacing="0" cellpadding="0" align="center">
<tr>
<td valign="middle">
		<table width="963" height="540" border="0" cellspacing="0" cellpadding="0" background="/hanjin/img/main_img/main_bg.gif">
		<tr>
			<td valign="top">
				<table width="742" height="495" border="0" cellspacing="0" cellpadding="0"">
				<tr>
					<td style="padding:92 0 0 177;" valign="top">
						<!-- 메뉴 생성 스크립트 (S) -->
						<div id="alpsMenuDiv" style=" height:100%; top:27px; left:12px; z-index:1;">
                           <p><a href="https://www.adobe.com/go/getflashplayer"><img src="https://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" border="0"/></a></p>                       
						</div>
						<!-- 메뉴 생성 스크립트 (E) -->
					</td>
				
					<td valign="top">
						<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td style="padding:163 0 5 80;" valign="top">
							<img src="/hanjin/img/main_img/main_my2.gif" width="20" height="23" alt="" border="0" class="cursor" onclick="manageBookmark();">
							</td>
						</tr>
						<tr>
							<td style="padding:0 0 0 3;" valign="top">
							<!--IB tree (s)-->
<% if (account != null) { %>
						<iframe id="ifbookmark" width="180" height="170" frameborder="0" scrolling="yes" src="mainBookmark.screen"></iframe>
<% } %>						
							<!--IB tree (e)-->
							</td>
						</tr>
						</table>
				</td>
			</tr>
			</table>
<% 
if (account != null) { 
	boolean adminAuth = false;
	// SELHO이외의 지역 Super 유저는   Administer는 접속못하고 무조건 Security로만 들어가서 Role 부여만 가능하다.
	// 2009.08.24 by desis
	// super user 관리 화면에서  admin flag 가 Yes 인 사용자만 admin 버튼이 활성화 됨
	// 2010.05.06 updated by desis
	//String RHQ = (new OrganizationUtil()).getHeadQuaterCode(account.getUsr_id());
	String adminFlag = (new UserRoleUtil()).getUserAdminFlag(account.getUsr_id());
	if ( account.getUsr_auth_tp_cd().equals("A") ) adminAuth = true;
	else if ( account.getUsr_auth_tp_cd().equals("E") ) adminAuth = true;
	else if ( account.getUsr_auth_tp_cd().equals("S") ) {
		if ( adminFlag.equals("Y") ) adminAuth = true;
		else adminAuth = false;
	} else adminAuth = false;
%>
	<!--Logout (s)-->
			<table style="width:700;" border="0" cellspacing="0" cellpadding="0" class="search">
			<tr class="id">
				<td style="padding:0 0 0 13; width: 57%">
					<img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;ID&nbsp;&nbsp;<font style="color:gray"><%=account.getUsr_id() %></font>&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;Name&nbsp;&nbsp;<font style="color:gray"><%=account.getUsr_nm() %></font>&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;Office&nbsp;&nbsp;
<%
	if(account!=null){
%>

	<mainpage:OfficeChangeList 
			userId="<%=account.getUsr_id() %>" 
			usrNm="<%=account.getUsr_nm() %>" 
			ofcCd="<%= account.getOfc_cd() %>" 
			styleValue=""
			classValue=""
			nameValue="s_usr_chg_ofc_cd"
			functionValue="onChange='changeOffice(this)'" 
	/>
	&nbsp;&nbsp;&nbsp;
<%
	}
%>
</td>
<td>
<img src="/hanjin/img/main_img/main_logout.gif" width="47" height="16" alt="" border="0" align="absmiddle" style="cursor:hand;" onClick="javascript:signature('Off');">
<% if (adminAuth) { %>
<img src="/hanjin/img/main_img/main_admin.gif" width="57" height="16" alt="" border="0" align="absmiddle" style="cursor:hand;" onClick="module_pop('<%=adminPgmNo %>')">
<% } %>	
<% if (comPopupEnabled.equals("TRUE")) { %>
<img src="/hanjin/img/main_img/main_commpopup.gif" height="16" alt="" border="0" align="absmiddle" style="cursor:hand;" onClick="common_pop()">
<% } %>	
<br>
</td>
			</tr>
			<tr><td></td><td><button type="button" class="button button4" style="margin: 2 2 2 0;" onClick="module_pop('BCM_000_M000')">Master Code</button></td></tr>
			</table>
	<!--Logout (e)-->
<% } else { %>
	<div id="localDIV" style="display: <%= (ssoEnabled.equals("TRUE")?"none":"block") %>">
	<!--Login (s)--> 
			<table style="width:700;" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td style="width:25; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 13;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;ID</td>
				<td width="110"><input type="text" name="t_username" style="width:100;ime-mode:disabled;" class="input"></td>
				<td style="width:65; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 0;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;Password</td>
				<td width="105"><input type="password" name="t_password" style="width:100;" class="input"></td>
				<td width="55"><img src="/hanjin/img/main_img/main_login.gif" width="47" height="16" alt="" border="0" align="absmiddle" style="cursor:hand;" onClick="submitForm();"></td>
				<td class="2d">
<% if( ssoEnabled.equals("TRUE") ) {%>
				<a href="javascript:toggleSSOLoginForm(true)">Go to <font color="FA6124">SSO</font> MODE.</a>
<% } else {%>
				&nbsp;
<% } %>
				</td>
			</tr>
			</table>
	<!--Login (e)-->
	</div>
	<div id="ssoDIV" style="display: <%= (ssoEnabled.equals("TRUE")?"block":"none") %>">
	<!--Login SSO (s)-->
			<table style="width:700;" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td style="width:25; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 13;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;ID</td>
				<td width="110"><input type="text" name="s_username" style="width:100;ime-mode:disabled;" class="input"></td>
				<td style="width:65; font-family: tahoma; font-size: 12px; vertical-align: middle; padding:0 0 0 0;"><img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;Password</td>
				<td width="105"><input type="password" name="s_password" style="width:100;" class="input" ></td>
				<td width="52"><img src="/hanjin/img/main_img/main_login.gif" width="47" height="16" alt="" border="0" align="absmiddle" style="cursor:hand;" onClick="goSubmit();"></td>
				<td width="135"><a href="http://im.hanjin.com/jsp/login_user.jsp" target="_blank"><img src="/hanjin/img/main_img/main_login_global.gif" width="132" height="16" alt="" border="0"></a></td>
				<td width=""><a href="http://im.hanjin.com/about_guid.html" target="_blank"><img src="/hanjin/img/main_img/main_login_global_1.gif" width="114" height="16" alt="" border="0"></a></td>
			</tr>
			</table>
			<table style="width:700;" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="2d" style="width:310;"  style="padding-left:6">&nbsp;&nbsp;<img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;<a href="javascript:SSO_GUIDForget()">Forgot your Password? Input Grobal ID and<font color="FA6124"> Click here. </font> </a></td>
				<td width="" class="2d">&nbsp;&nbsp;<img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;<a href="javascript:SSO_GUIDFindID()">Find Global ID</a></td>
			</tr>
			</table>
			<div id="NONssoLinkDIV" style="display: <%= (nonSsoLinkEnabled.equals("TRUE")?"block":"none") %>">
			<table style="width:700;" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="2d" style="padding-left:6">&nbsp;&nbsp;<img src="/hanjin/img/main_img/main_dot.gif" width="3" height="9" alt="" border="0" align="absmiddle">&nbsp;&nbsp;<a href="javascript:toggleSSOLoginForm(false)">Go to <font color="FA6124">NON-SSO</font> MODE.</a></td>
			</tr>
			</table>
			</div>
	<!--Login SSO (e)-->
	</div>
<% } %>
		</td>
	</tr>
	</table>

</td></tr>
</table>

<table style="width:0;height:0;" border="0" cellspacing="0" cellpadding="0">
<tr>
	<td >
	     <script language="javascript">ComIsSheetTag('sheet');</script>
		<div id="base" style="display:none">
	     <script language="javascript">installComboTag();</script>
		</div>
	</td>
</tr>
</table>

<!-- 메뉴 생성 스크립트 (S) -->
<script type="text/javascript">
//window["alpsMenu"] = new Object();
		var so = new SWFObject("/hanjin/img/main_img/main.swf?v=20100105", "alpsMenu", "565", "394", "8", "#ffffff");
		so.addParam("id","alpsMenu");
		so.addParam("allowscriptaccess","always");                                
		so.addParam("wmode", "transparent");
		so.addParam("scale", "noscale");
		so.addParam("salign", "TL");
		so.write("alpsMenuDiv");
</script>
<!-- 메뉴 생성 스크립트 (E) -->


<!-------------------- Alert Layer -------------------->

<div id="alert01" style="position: absolute; Z-INDEX: 2; top: 30px; left: 130px; width: 600px; height: 400px; visibility: hidden;">
<style>
/* Grid Type2 ( Table Style 2 ) */
TABLE.Grid7		 		{ border-collapse: collapse; background-color: #A6C3CB; color: #272727; border: 1px solid #E8EFF9; }
TABLE.Grid7 TD			{ padding:0px; text-indent: 3px; height:23; word-break : 
						break-all; font-family: Tahoma,verdana,Arial,dotum,gulim; font-size: 11px; padding-right:3px; }
	 .align_r			{ text-align:right;}
	 .tr7_head			{ background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; border: 1px solid #E8EFF9; width:100%;}
	 .tr7_head_l		{ background-color: #E8EFF9; color: #313131; text-align : left; font-weight:bold; border: 1px solid #E8EFF9; width:100%;}
	 .tr7_head2			{ background-color: #EBF6F9; text-align:center; color: #313131; font-weight:normal; border: 1px solid #E8EFF9; width:100%;}
	 .tr7_head3			{ background-color: #F7E1EC; font-weight:normal; border: 1px solid #E8EFF9; width:100%;}
	 .tr7_head4			{ background-color: #FAD26B; font-weight:normal; border: 1px solid #E8EFF9; width:100%;}
</style>
<table align="center" width="600" style="background-color: #9999cc;">
<tr>
	<td valign="top"><!-- : ( Search Options ) (S) -->
		<table class="search" style="width: 100%; border: 1px solid #E8EFF9;" align="center">
		<tr>
			<td class="bg">
				<table class="search" border="0">
				<tr class="h23">
					<td style="font-size: 14px; color: #871DEB;font-weight:bold;"> ALPS Go-Live on April 5th  </td>
				</tr>
				<tr class="h23">
					<td colspan="2">
						<table cellpadding="0" cellspacing="0"> 
						<tr> 
							<td width="56%">
							 	<img src="/hanjin/img/announcements/pop_up_attention.jpg" width="600" height="500" ></img>	
							</td>
						</tr> 
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- : ( Button : pop ) (S) -->
		<table width="100%" class="sbutton">
		<tr>
			<td height="" class="popup">
				<table width="100%" class="search" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; , padding-bottom: 0;">
				
				<tr>
					<td><input class="Trans" type="checkbox" name="no_more" /> Today, Message window will not be opened any more.</td>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="72">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" onClick="messageConfirm('NO','NO');">OK</td>
									<td class="btn1_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>

</div>
<!-------------------- Alert Layer -------------------->




</body>
</html>

