<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String linkType = JSPUtil.getParameter(request, "linkType".trim(), "0");
	String flag = JSPUtil.getParameter(request, "flag");
	String navigation_text = JSPUtil.getParameter(request, "navigation_text");
    String title_text = JSPUtil.getParameter(request, "title_text");
	if(flag == null) {
		flag = "0003";
	}
	// EES_EQR_138화면 8번째 추가
	String[] arrTab = {"0017","0085","0086","0020","0021","0090","0022","0138", "0003","0025","0079","0007","0009","0111","0014","0060","0026"};
	// 이미지 명 17 추가
	String[] arrGif = {"01","02","03","04","05","06","07","17","09","10","11","12","13","14","15","16","08"};

	String[] gifSize = {"130","117","121","127","131","126","120","125","114","123","126","107","104","122","81","110","110"};

	String[] strArrTab = new String[17];
	StringBuffer sb = new StringBuffer();

	// Constraint textarea 길이값을 조정합니다.
	String textareaWidth = "0";
	if(flag.equals(arrTab[6])) textareaWidth = "400";  // 022- 400
	else if(flag.equals(arrTab[11])) textareaWidth = "250";  // 011 - 250
	else if(flag.equals(arrTab[12])) textareaWidth = "675";   // 009 - 675
	else					   textareaWidth = "688";  // 나머지는 454 입니다.

	sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">  \n");
	sb.append("<tr>  \n");
	for(int i = 0; i < arrTab.length; i++){

		if(flag.equals(arrTab[i])){//
			strArrTab[i] = "<td><img src=\"/hanjin/img/tab1_"+arrGif[i]+"on.gif\" width="+gifSize[i]+" height=\"19\" border=\"0\" name=\"tab_"+arrGif[i]+"\"></td>";
		}else{
			strArrTab[i] = "<td><img src=\"/hanjin/img/tab1_"+arrGif[i]+"off.gif\" onClick=\"javascript:clickTabBtn('"+arrTab[i]+"')\" onMouseOver=\"document.tab_"+arrGif[i]+".src='/hanjin/img/tab1_"+arrGif[i]+"on.gif' \" onMouseOut=\"document.tab_"+arrGif[i]+".src='/hanjin/img/tab1_"+arrGif[i]+"off.gif' \" width="+gifSize[i]+" height=\"19\" border=\"0\" name=\"tab_"+arrGif[i]+"\"></td>";
		}

		sb.append(strArrTab[i] + "  \n");

		if(i == 7){
			sb.append("</tr>  \n");
			sb.append("</table>  \n");
			sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">  \n");
			sb.append("<tr>  \n");
		}

	}
	sb.append("</tr>  \n");
	sb.append("</table>  \n");
%>
<script language="javascript">

	function clickTabBtn(flag) {
		var frmObj = document.form;
		var yyyyww = frmObj.yyyyww.value;
		var seq = frmObj.seq.value;
		var navigation_text = document.all.hidden_navigation.value;
        var title_text = document.all.hidden_title.value;

		if('<%=linkType%>' == "1" && !chkScenarioId(frmObj,'yyyyww','seq')) {
			return;
		}
		frmObj.f_cmd.value = "";
        frmObj.target="_self";
        frmObj.action ='EES_EQR_'+flag+'.do?yyyyww='+yyyyww+'&seq='+seq+'&flag='+flag+'&linkType=<%=linkType%>'+'&navigation_text='+navigation_text+'&title_text='+title_text;
        frmObj.method = "post";
	    frmObj.submit();
	}

	function setParam() {
		if('<%=navigation_text%>' == null || '<%=navigation_text%>' == 'null' || '<%=navigation_text%>' == ""){
			document.all.hidden_navigation.value = document.all.navigation.innerText;
		} else {
			document.all.navigation.innerHTML= '<%=navigation_text%>';
			document.all.hidden_navigation.value = '<%=navigation_text%>';
		}
		if('<%=title_text%>' == null || '<%=title_text%>' == 'null' || '<%=title_text%>' == ""){
            document.all.hidden_title.value = document.all.title.innerText;
            document.title = document.all.title.innerText;
        } else {
            document.all.title.innerHTML= "&nbsp;<%=title_text%>";
            document.all.hidden_title.value = "<%=title_text%>";
        	document.title = document.all.title.innerText;
        }

		if('<%=linkType%>' == "1") {
			//document.all.title.innerHTML="&nbsp;&nbsp;Create/Update Scenario Data</td>";
			if('<%=flag%>' == "0111") {
				document.all.cond1.innerHTML="<input type='text' style='width:38' value='SCEN' class='noinput2' readOnly>&nbsp;<input type='text' style='width:50' name='yyyyww' maxlength='6' readOnly>&nbsp;<input type='text' style='width:20' value='W' class='noinput2' readOnly>&nbsp;<input type='text' style='width:30' name='seq' maxlength='3' readOnly> <img class='cursor' src='/hanjin/img/btns_search.gif' width='19' height='20' border='0' align='absmiddle' name='btn_scnrlist'> <textarea class='input1' name='scnr_rmk' rows='1' style='width:600;' style='overflow:hidden' readOnly  title=''></textarea>";
			} else {
				document.all.cond1.innerHTML="<input type='text' style='width:38' value='SCEN' class='noinput2' readOnly>&nbsp;<input class='input1' type='text' style='width:50' name='yyyyww' maxlength='6' readOnly>&nbsp;<input type='text' style='width:20' value='W' class='noinput2' readOnly>&nbsp;<input class='input1' type='text' style='width:30' name='seq' maxlength='3' readOnly> <img class='cursor' src='/hanjin/img/btns_search.gif' width='19' height='20' border='0' align='absmiddle' name='btn_scnrlist'>	<textarea class='input1' name='scnr_rmk' rows='1' style='width:<%= textareaWidth%>;' style='overflow:hidden' readOnly title=''></textarea>";

			}
			ComBtnEnable("btn_scnrlist");
			if(document.all.item("btn_save") != null) {
				ComBtnEnable("btn_save");
			}
		} else {
			//document.all.title.innerHTML="&nbsp;&nbsp;Inquire Scenario Data</td>";
			if(document.all.item("btn_save") != null) {
				ComBtnDisable("btn_save");
			}
		}

		document.form.yyyyww.value = '<%=JSPUtil.getParameter(request, "yyyyww".trim(), "")%>';
		document.form.seq.value = '<%=JSPUtil.getParameter(request, "seq".trim(), "")%>';

		document.form.linkType.value = '<%=linkType%>';

		goSearchSncrid();

	}
</script>

		<!-- TABLE '#D' : ( Tab ) (S) -->
    <table class="search"><tr><td height="5"></td></tr></table>
<%
out.println(sb.toString());
%>
		<table class="search"><tr><td height="1" bgcolor="#8385D9"></td></tr></table>
		<!-- TABLE '#D' : ( Tab ) (E) -->