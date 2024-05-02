<%--
==============================================================================
'주  시 스 템  :
'서브  시스템  :
'프로그램 ID  :
'프로그램 명   :
'프로그램개요  : screen화면을 구성하는 기본 조합 문서이다.
'문서 특이사항 : 자바스크립트 공통함수및 공통 CSS는 이곳에서 include 한다.
'수정 사항     : 프로토타이핑 중으로 메뉴정책이 미결정되어 스크립트만 정의된 기본템플릿으로 수정 
==============================================================================
--%>
<%@ taglib uri="/WEB-INF/template.tld" prefix="template"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.view.template.Parameter"%>
<%@ page import="com.hanjin.syscommon.common.menu.MenuProcessor"%>

<%
	Screen screen = (Screen) request
			.getAttribute(WebKeys.CURRENT_SCREEN);
	Parameter param = (Parameter) screen.getParameter("body");
	String jsPath = param.getValue();
	//System.out.println("jsPath=" + jsPath);

	jsPath = jsPath.replaceAll("\\.jsp", "\\.js");
	//System.out.println("jsPath2=" + jsPath);
	String pgmNo = "";
	String title = "";
	String description = "";
	String navigation = "";
	try {
		pgmNo = (String) request.getAttribute("UI_NUMBER");
		title = (String) request.getAttribute("UI_TITLE");
		description = (String) request.getAttribute("UI_DESCRIPTION");
		navigation = ((String) request.getAttribute("UI_NAVIGATION")).substring(10);
	} catch (Exception e) {
		try{
			pgmNo = request.getParameter("pgmNo");
			MenuProcessor menuProcessor = new MenuProcessor();
			menuProcessor.init(null);
			menuProcessor.processEventNavigation(request);
			menuProcessor.doEnd();
			HashMap menu = (HashMap) request.getAttribute("MenuInformation");
			title = (String) menu.get("title");
			description = (String) menu.get("description");
			navigation = ((String) menu.get("navigation")).substring(10);
		}catch(Exception ee) {;}
	}
	
		
		%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8, requiresActiveX=true"/>
<!-- <template:insert parameter="title" /> -->

<%@page import="java.util.HashMap"%>

<link href="css/alps_contents.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="js/jquery.js" ></script>
<script language="javascript" type="text/javascript" src="js/CoMessage.js"></script>
<script language="javascript" type="text/javascript" src="js/CoAxon.js" path="<%=jsPath%>"  msgkey="<%=WebKeys.TRANS_RESULT_KEY%>"></script>
<script language="javascript" type="text/javascript" src="js/CoCommon.js"></script>
<script language="javascript" type="text/javascript" src="js/CoFormControl.js"></script>
<script language="javascript" type="text/javascript" src="js/CoPopup.js?version=U1"></script>
<script language="javascript" type="text/javascript" src="js/CoCalendar.js"></script>
<script language="javascript" type="text/javascript" src="js/CoObject.js?version=U15"></script>
<script language="javascript" type="text/javascript" src="js/IBSheetInfo.js?version=multi"></script>
<script language="javascript" type="text/javascript" src="js/CoWait.js?version=U12"></script>
<script language="javascript" type="text/javascript" src="js/CoBiz.js"></script>
<script language="javascript" type="text/javascript" src="js/CoMail.js?version=U2"></script>
<script language="javascript" type="text/javascript" src="js/CoUpload.js?version=U2"></script>
<script language="javascript" type="text/javascript" src="js/jquery.js" ></script>
<script language="javascript" type="text/javascript">

// program no, program name, program navigation
var curPgmNo = '<%=pgmNo%>';
var curTitle = '<%=title%>';
var curDescription = "<%=description%>";
var curNavigation = '<%=navigation%>';
</script>
<!-- body 시작 -->
<template:insert parameter="body" />
<!-- body 끝 -->
<iframe id="_iFrameWait_" src="/hanjin/img/waiting.gif" frameborder="0" marginHeight="0" marginWidth="0" width="249" height="76" style="position:absolute;visibility:hidden;z-index:999;display:none;" ></iframe>

<script language="javascript">
	//khlee-ie6와 ie7의 단축키로 Backspace를 누르면  자동으로 페이지 뒤로 가기 되어 버리는 문제를 해결하기 위함 
	document.onkeydown = new Function(
			"if(event.keyCode!=8) return; if(!event.srcElement.isTextEdit || event.srcElement.readOnly) event.keyCode=0;");

	//khlee-form안에 편집가능한 input="text", input="password"가 하나만 존재할때 input 필드에서 Enter키를 누르면 페이지 리로드되는 문제를 해결하기 위함
	for ( var i = 0; i < document.forms.length; i++) {
		document.forms[i].onsubmit = new Function("return false;");
	}
	// desis-타이틀과 네비게이션 세팅
	
	try {
	 var appName = navigator.appName;
	 if (appName.indexOf("Netscape") == -1) {
		//document.all.navigation.innerHTML = curNavigation;
	 	document.all.title.innerHTML = '&nbsp; '+curDescription;
	  	if(document.getElementById('navigation_icon_popup_hidden') != undefined && document.getElementById('navigation_icon_popup_hidden') != null){
			document.getElementById('navigation_icon_popup_hidden').style.display = "none";
		}
		document.title = curDescription;
	 } else {
	  	//document.getElementById("navigation").innerHTML = curNavigation;
	  	document.getElementById("title").innerHTML = '&nbsp; '+curDescription;
		document.title = curDescription;
	 }
	 
	}catch(err) {
	 	;
	}

//    document.write("<IFRAME id='"+WAIT_FRAME_NAME+"' src='"+waitImage +"' frameborder=0 marginHeight=0 marginWidth=0 width="+waitW+" height="+waitH+" style='position:absolute;visibility:hidden;z-index:999' />");

</script>
