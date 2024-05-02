/**
===============================================================================
프로그램  명  : UI관련 공통 함수 정의 Script
프로그램개요  :
작   성   자  :
작   성   일  :
===============================================================================
* 2008-03-04 김원섭 - Summarize 기능 개선
* 2008-10-28 임옥영 CSRNO=N200810240577 - 단축키 설정으로 인해 추가된 FUNCTION line 1494이후부터 끝까지
* 2008-11-06 서관영,임옥영  CSR : N200810270009,N200810270015 - Space Control Module상 단축키 반영 요청
* 2008-11-13 임옥영 CSR:N200811120012 -단축키 추가사항 반영(toggle 및 적용 화면추가)
* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019  - 단축키 추가(ESM_SPC_0022, 0024, 0028, 0056, 0070)
* 2008-11-25 임옥영 CSR:N200811250003 Alt+S오류 수정
* 2009-07-29 최윤성 CSR:R200907300001 - IBSheet Update에 따른 scrollToCurRow, toggleSheetSize수정
* 2009-12-28 최윤성 - IBSheet Class ID 248HJ 버전으로 변경
* 2010-02-24 CHOI.Y.S  - Sheet Hidden 관련하여 eval 함수가 제대로 작동하지 않아 switch 문으로 변경
* 2010.06.22 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - [프로젝트] 53FT 관련 필드 추가
* 2011.03.08 원종규 - ComXml2Array : IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array 형태로 변환
* 2011.04.11 김종준 - SpcSearchOptionContiCd ContiCd Combo 추가 
* 2011.05.19 최성민 - getSpcXmlToCombo, getSpcTextToCombo 추가 
* 2011.05.16 이석준 - SpcSearchRevLane Revenue Lane Combo 추가- SpcSearchOptionRHQCombo RHQ Combo 추가
* 2011.06.07 김종준 - SpcSearchOptionTradeCombo Trade Combo,SpcSearchOptionSubTradeCombo Sub Trade Combo 추가
* 2011.07.05 이석준 [CHM-201111880] control by HO 화면 보완 - IPC, TS 관련     
* 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 - 주차별 CMB 항목 조회되도록 수정
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2012.01.02 김종준 [CHM-201110709-01] OP/OC/VL  추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - TTL 라인 COA 팝업 연결
* 2013.05.03 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - Save 후 상위 grid에 aloc 반영되도록 수정
* 2013.06.25 진마리아 [선처리] CRM Customer Flag 정보 개편에 따른 작업
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Lane 공통 팝업 추가
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대-SpcXml2ComboItem 오류 수정
* 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청 ->메시지추가
* 2015.03.18 김성욱, [CHM-201533908] Control Option 보완 -기능추가, 메시지 추가
* 2015.03.24 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가(Control option 과 동일하게 적용 시켜줌)
* 2015.06.03 김성욱 Allocation By HO/RHQ 의 Edit 기능에 Async 기능 추가 => 체크 되면 현 VVD만 Control Option Reg 에 세팅된 By Aloc, SMP, MST 를 Reset 함.
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청
* 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결 MSG추가)
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청
* 2016.03.28 이혜민 [CHM-201640572] F"cast input(loading) Duration 제한 관련
* 2016.04.01 이혜민 [CHM-201640539] ALPS Live Out Of Memory Error 확인 및 조치 요청(Sales Rep이 몇 개의 Account를 체크했는지 개수 조회)
* 2016.05.03 이혜민 [CHM-201640928] Daily Forecast Status 모든 조회 옵션 및 탭 > 그리드 화면에 SELCS, TYOSC 독립 RHQ 분리 요청
===============================================================================
*/

// 조정에서 사용되는 remark text style
document.write("<style>.remark01 {color:#005374; text-align:left; font-weight:bold; line-height:15px; padding-top: 2px; padding-bottom: 3px;}</style> ");


var checkTargetSheet = new Array();

var sheetObjects = new Array();
var sheetResizeFull = false;
var sheetResizeCount = 1;
var resizeTargetObject = new Array();
var popupCodeInfoClosed=true; 

/*
 * ESM_SPC_0103.js(Sales Rep&Account Input )에서 사용함
 * loadPage()마지막에서 호출
 */
function document_onresize(){
	if(!sheetResizeFull) return;
	var mainObj = document.body.children.tags("TABLE");
	if(mainObj.length == 0){
		mainObj = document.body.children.tags("FORM")[0].children.tags("TABLE")[0];
	}
	var subObj = mainObj.rows(0).cells(0).children.tags("TABLE")[0];
	var subObjs = subObj.rows(0).cells(0).children;
	var height = 0;
	for(var j = 0 ; j < subObjs.length ; j++){
		if("!LINK".indexOf(subObjs[j].tagName) >= 0) continue;
		height = height + subObjs[j].offsetHeight;
	}
	height = height + mainObj.rows(1).offsetHeight;
	var cHeight = document.body.clientHeight;
	var dHeight = cHeight - height;
	for(var i = 0 ; i < sheetObjects.length ; i++){
		var h = sheetObjects[i].style.height;
		var pos = h.indexOf("px");
		if(pos >= 0){
			h = h.substring(0, pos)*1;
		}
		var minHeight = 13 + sheetObjects[i].DataRowHeight * 2 + ((sheetObjects[i].CountPosition==0)?0:(sheetObjects[i].SheetFontSize*2));
		var rowHeight = 0;
		for(var r = 0 ; r < sheetObjects[i].HeaderRows ; r++){
			sheetObjects[i].CellText(r, 0) = sheetObjects[i].CellText(r, 0);
			rowHeight = rowHeight + sheetObjects[i].RowHeight(r);
		}
		minHeight = minHeight + rowHeight;
		if(h + (dHeight / sheetResizeCount) < minHeight){
			sheetObjects[i].style.height = minHeight;
		}
		else{
			sheetObjects[i].style.height = h + dHeight / sheetResizeCount - 20;
		}
	}
	for(var k = 0 ; k < resizeTargetObject.length ; k++){
		var obj = document.getElementById(resizeTargetObject[k]);
		var h = obj.style.height;
		var pos = h.indexOf("px");
		if(pos >= 0){
			h = h.substring(0, pos)*1;
		}
		var minHeight = 10;
		if(h + (dHeight / sheetResizeCount) - 20 < minHeight){
			obj.style.height = minHeight;
		}
		else{
			obj.style.height = h + dHeight / sheetResizeCount - 20;
		}
	}
}

/*
 * 페이지를 벗어날때 변경된 값이 있으면 경고 메시지
 * There is modified data.\n\n Do you want to process?
 */
function document_onbeforeunload(){
	if(sheetObjects == undefined){
		return;
	}
	var cnt = sheetObjects.length;
	var idx = 0;
	for(var i = 0 ; i < cnt ; i++){
		if(sheetObjects[i].Editable){
			checkTargetSheet[idx] = sheetObjects[i];
			idx = idx + 1;
		}
	}
	
	if(checkModifiedSheet(checkTargetSheet)){
//		if(ComShowConfirm (getMsg("SPC90001")) != 1){
			event.returnValue = getMsg("SPC90001");
			return false;
//		}
	}
	return;
}

// Sheet의 Edit Mode를 공통으로 설정할 수 있는 변수
// Sheet의 Edit Mode를 Edit상태로 할 경우 true로 변경
var default_edit_mode = false;
var isDevMode = false;
var hostname = location.hostname;
var ip = hostname.split(".");
/*
if(hostname == "localhost" || hostname == "127.0.0.1" || hostname.indexOf("203.246.152.") >= 0){
	isDevMode = true;
}*/

/*
 * 개발자 모드 설정, 개발자 모드는 로그/기본값 세팅등이 되어 있다.
 */
if(hostname == "127.0.0.1"){
	isDevMode = true;
}
/*
 * ip가 Number가 아닌지 확인해서 개발자 모드 세팅 변경
 */
if(ip.length >= 2 && isNaN(ip[ip.length-1])){
//	isDevMode = false;
}

/**
 * function 추가
 * IBMulticombo생성시 CustomTag쪽 코드에서 사용했음
 */
function funcAdd(func1, func2){
var func = "";
var t1 = "";
var t2 = "";
try{t1 = eval(func1);}catch(e){t1="";}
try{t2 = eval(func2);}catch(e){t2="";}
    func = function(arg1, arg2, arg3, arg4, arg5, arg6){
               try{
                   t1(arg1, arg2, arg3, arg4, arg5, arg6);
	    	    }catch(e){}
                try{
                    t2(arg1, arg2, arg3, arg4, arg5, arg6);
	    	    }catch(e){}
	        };
	return func;
}

var codeSheet = null;
/*
 * 
 */
function createCodeSheetObject(){
    if(codeSheet != null){
        return;
    }
    var objs = document.getElementsByTagName("OBJECT");
    var baseCode = "";
    for(var i = 0 ; i < objs.length ; i++){
//    	if(objs[i].classid == "CLSID:DAA95791-7150-47BD-BF09-E8EC04798D2D"){
    	  if(objs[i].classid == CLSID_IBSHEET){ //바뀐 사용자환경
//        if(objs[i].classid == "CLSID:341FBC5F-2AE4-41B8-BFE5-A03170569A27"){ //기존 사용자환경
//        if(objs[i].classid == "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423"){
            baseCode = "";
            break;
        }
    }
    var sTag = "";
    var id = "codeSheet";
    sTag = ComGetSheetObjectTag(id);
    var divElement = document.createElement("DIV");
    divElement.style.display = "none";
    divElement.innerHTML = sTag;
    document.body.appendChild(divElement);
//    document.write(sTag);
    codeSheet = divElement.children(0);
    ComConfigSheet(codeSheet);
    with(codeSheet){
        style.height = 150 ;
        //전체 너비 설정
        SheetWidth = 300;
    
        //Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
        //전체Merge 종류 [선택, Default msNone]
        MergeSheet = msPrevColumnMerge;
    
       //전체Edit 허용 여부 [선택, Default false]
        Editable = true;
    
        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        InitRowInfo( 1, 1, 9, 100);
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(4, 0 , 0, true);
    
         var HeadTitle = "Status|Seq.|Code|Name";
    
        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        InitHeadRow(0, HeadTitle);
        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        InitColumnInfo(10, 1 , 0, false);
       var cnt = 0;
        InitDataProperty(0, cnt++ , dtStatus, 50, daCenter,   true,    "FLG",                 false,    "",         dfNone,   0,          false,       false);
        InitDataProperty(0, cnt++ , dtSeq,       50,    daCenter,   true,    "SEQ",                 false,    "",         dfNone,   0,          false,       false);
        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "CODE",                 false,    "",         dfNone,   0,          true,       true);
        InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,    "TEXT",                 false,    "",         dfNone,   0,          true,       true);
    }
    ComEndConfigSheet(codeSheet);
    
}

function getCodeList(cmd, param){
    var rtn = new Array();
    rtn[0] = "";
    rtn[1] = "";
    createCodeSheetObject();
    with(codeSheet){
        ShowDebugMsg = false;
        DoSearch4Post("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST01+"&mcode="+cmd+"&"+param);
        var rowCnt = RowCount;
        for(var i = 1 ; i <= rowCnt ; i++){
            rtn[0] += CellText(i, "CODE") + "|";
            txt = CellText(i, "TEXT").split("|");
            for(var t = 0 ; t < txt.length ; t++){
            	if(rtn[t+1] == undefined){
            		rtn[t+1] = "";
            	}
	            rtn[t+1] += txt[t] + "|";
			}
        }
    }
    return rtn;
}

/**
 * <select> 에 <option> 이 동적으로 변경되는 경우에 사용한다.
 * getCodeList()를 수정하여 추가함.
 *
 * @date 2006-12-26 byyoo
 * @param obj - select tab object
 * @param cmd - 조회할 코드명 ( DAO에 method name으로 사용됨)
 * @param param - 코드 조회시 필요한 조건 parameter string
 * @param reload - 코드정보 재조회 여부. default=true (2007.03.06 추가)
 * @param addOption - Option object 추가  (2007.04.03 추가)
 * @see ESM_SPC_0129 참조
 **/
var getSelectCodeList_oldParam = "";
function getSelectCodeList(obj, cmd, param, reload, addOption){
	if(reload == undefined){
		reload = true;
	}
	// select tag options remove
	var opts = obj.options;
	for (i = (opts == null ? -1 : (opts.length - 1)); i >= 0; i--) {
		opts.remove(i);
	}
	// code search 
    createCodeSheetObject();
    with(codeSheet){
        ShowDebugMsg = false;
        var newParam = "f_cmd="+SEARCHLIST01+"&mcode="+cmd+"&"+param;
        if(reload || getSelectCodeList_oldParam != newParam){
       		DoSearch4Post("ESM_SPC_CODGS.do", newParam);
        }
        getSelectCodeList_oldParam = newParam;
        
        var idx = 0; // option index
        // addOption 추가 
        if (addOption != undefined && addOption.nodeName == "OPTION") {
        	obj.options[idx++] = addOption;
        }
        
		// select tag options add
        for(var j = 1 ; j <= RowCount ; j++){
        	obj.options[idx++] = new Option(CellText(j, "TEXT"), CellText(j, "CODE"));
        }
    }
}

function getSheetComboText(){
    var sheetObj, row, col, idx, name, value;
    sheetObj = arguments[0];
    row = arguments[1];
    col = arguments[2];
    if(arguments.length < 4){
        idx = -1;
    }
    else{
    	idx = arguments[3];
    }
    var selectedIndex = sheetObj.GetComboInfo(row, col, "SelectedIndex") * 1;
    var texts = sheetObj.GetComboInfo(row, col, "Text").split("|");
    
    if(selectedIndex < 0){
    	return "";
    }
    if(idx < 0){
    	return texts[selectedIndex].split("\t");
    }
    return texts[selectedIndex].split("\t")[idx];
}

function getFunctionName(){
	if(getFunctionName.caller == null){
		return "top";
	}
	else{
		var f = getFunctionName.caller;
		f = f + "";
		var pos = f.indexOf("(");
		var fname = f.substring(8, pos);
		pos = 0;
		while(fname.charAt(pos) == ' ' || fname.charAt(pos) == '	'){
			pos++;
		}
		return fname.substring(pos);
	}
}

//============================================
// log 관련 변수 및 함수
// 시작
var messageDiv = null;
var message = null;
var debuglog = "";
var sheetlog = "";

function logEvent(obj, fname, arguments){
	if(!isDevMode) return;
    if(!sheetlog.checked) return;
    if(fname == "OnMouseMove" || fname == "OnDebugMsg1" || fname == "OnResize") return;
    var msg = "["+obj.id + "] {" + fname + "} (Param)";
    for(i = 0 ; i < arguments.length ; i++){
        msg += " - " + arguments[i];
    }
    writeLog(msg);
}
function log(msg){
	if(!isDevMode) return;
    if(message == null || !debuglog.checked) return;
    writeLog(msg);
}
function writeLog(msg){
	msg = msg + "";
    var tr = message.insertRow();
    var td = tr.insertCell();
    td.style.border = "1 solid gray";
    var msg = msg.replace(/</g, "&lt").replace(/>/g, "&gt").replace(/\t/g, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").replace(/ /g, "&nbsp;").replace(/\n/g, "<BR>");
    td.innerHTML = msg;
    var div = message.parentElement;
	div.scrollTop = message.offsetHeight;
}
function createMessagePart(){
	if(!isDevMode) return;
	messageDiv = document.createElement("DIV");
	messageDiv.style.width = "100%";
	
    var path = location.pathname;
    path = path.substring(path.lastIndexOf("/") + 1).substring(0, 11);
    var subsystem = path.substring(4, 7).toLowerCase();;
    url = "apps/enis/esm/html/"+subsystem+"/jsp/UI_"+path+".html";

	msgStr = '<TABLE style="WIDTH: 100%;" boder="1">' +
			 '<TR height=20>' +
			 '	<TD>Log</TD>' +
			 '	<TD style="TEXT-ALIGN: right">' +
			 '		&nbsp;<SPAN><A href="'+url+'" target=_blank>UI</A></SPAN>' +
			 '		&nbsp;&nbsp;&nbsp;<LAVEL>Log</LAVEL><INPUT type=checkbox id="debuglog">' +
			 '		&nbsp;&nbsp;<LAVEL>SysLog</LAVEL><INPUT type=checkbox id="sheetlog">' +
			 '		&nbsp;&nbsp;<BUTTON style="CURSOR: hand" onClick="var rows=message.rows;while(rows.length>0)message.deleteRow();">Clear</BUTTON>' +
			 '		&nbsp;&nbsp;<BUTTON style="CURSOR: hand" onClick="if(this.innerText==\'LogHide\'){messageBlock.style.display=\'none\';this.innerText=\'LogShow\';}else{messageBlock.style.display=\'block\';this.innerText=\'LogHide\';}">LogShow</BUTTON>' +
			 '		&nbsp;&nbsp;<BUTTON style="CURSOR: hand" onClick="if(this.innerText==\'ScriptHide\'){ScriptBlock.style.display=\'none\';this.innerText=\'ScriptShow\';}else{ScriptBlock.style.display=\'block\';this.innerText=\'ScriptHide\';}">ScriptShow</BUTTON>' +
			 '		&nbsp;&nbsp;<BUTTON style="CURSOR: hand" onClick="messageDiv.removeNode(true);">X</BUTTON>' +
			 '	</TD>' +
			 '</TR>' +
			 '<TR id="messageBlock" style="display:none" height="250">' +
			 '	<TD colSpan=2>' +
			 '		<DIV style="OVERFLOW-Y: scroll; OVERFLOW-X: scroll; WIDTH: 100%; HEIGHT: 100%">' +
			 '			<TABLE width="100%" id="message" style="font-size:9pt;" cellspacing="0"></TABLE>' +
			 '		</DIV>' +
			 '	</TD>' +
			 '</TR>' +
			 '<TR id="ScriptBlock" style="display:none" height="500">' +
			 '	<TD colSpan=2>' +
			 'Script Editor'+
			 '<button onClick="eval(scriptEdit.value);">Execute</button>'+
			 '		<textarea id="scriptEdit" style="font-size:9pt;width:100%;height:100%"></textarea>' +
			 '	</TD>' +
			 '</TR>' +
			 '</TABLE>';

	messageDiv.innerHTML = msgStr;
}

var dlog = false;
var slog = false;
var search = location.search;
var slist = search.substring(1).split("&");
for(i = 0 ; i < slist.length ; i++){
    tlist = slist[i].split("=");
    if(tlist[0] == "debug"){
        dlog = (tlist[1] == "true");
    }
    if(tlist[0] == "debugmode"){
        isDevMode = (tlist[1] == "true");
    }
    if(tlist[0] == "systemdebug"){
        slog = (tlist[1] == "true");
    }
}
createMessagePart();

function init(){
    if(document.readyState != "complete"){
        setTimeout("init()", 10);
        return;
    }
    var path = location.pathname;
    var span = document.createElement("SPAN");
    path = path.substring(path.lastIndexOf("/")+1, path.indexOf("."));
	document_onresize();
	document.body.onbeforeunload = document_onbeforeunload;
	if(sheetResizeFull){
		document.body.onresize = document_onresize;
	}
	if(!isDevMode) return;

	
	//아래의 내용은 개발 환경에서만 수행됨
	setUITitle(path);
	document.title = path;
	var tobj = document.getElementsByTagName("TABLE")[0];
	if(tobj != undefined){
		tobj.height = "";
		
		tobj.rows(0).cells(0).children[0].height = "";
	}
    document.body.appendChild(messageDiv);
    debuglog = document.getElementById("debuglog");
    sheetlog = document.getElementById("sheetlog");
    message = document.getElementById("message");
	debuglog.checked = dlog;
	sheetlog.checked = slog;
	//Title에 UI ID를 붙인다.
    var obj = document.getElementsByTagName("IMG");
    var span = document.createElement("SPAN");
    span.innerHTML = "("+path+")";
    for(var i = 0 ; i < obj.length ; i++){
        if(obj[i].src.indexOf("ico_t1.gif") >= 0){
            obj = obj[i];
    		obj.parentElement.appendChild(span);
            break;
        }
    }
	initEventLog();
}

init();

var testPage = false;
function logComEvent(obj, eventName, args){
    var path = location.pathname;
    path = path.substring(path.lastIndexOf("/") + 1).substring(0, 11);
    if(path.substring(0, 3) == "ESM" || testPage == true){
    	logEvent(obj, eventName, args);
    }
}

function initEventLog(){
	var scripts = document.getElementsByTagName("SCRIPT");
	var scriptsCnt = scripts.length;
	var scriptText = "";
    objs = document.getElementsByTagName("OBJECT");
    var st
    for(var i = 0 ; i < objs.length ; i++){
  	  switch(objs[i].classid){
  	    case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
			break;
  	    case CLSID_IBMCOMBO: // IBMultiCombo 경우
//  	    case "CLSID:0B0683AE-1FB7-438f-AA3C-087E11C8AE2D": // IBMultiCombo 경우
			var sheetID = objs[i].id;
			for(var s = 0 ; s < scriptsCnt ; s++){
				var scriptTag = scripts[s].outerHTML;
				if(scriptTag.indexOf(sheetID) > 0){
					var script = scripts[s].innerHTML;
					var pos1 = scriptTag.indexOf("event=\"");
					if(pos1 < 0){
						pos1 = scriptTag.indexOf("event=");
					}
					if(pos1 > 0){
						pos1 = scriptTag.indexOf("On", pos1);
						var pos2 = scriptTag.indexOf("(", pos1);
						var eventName = scriptTag.substring(pos1, pos2);
						scripts[s].text = 'logComEvent(this, "'+eventName+'", arguments);'+script;
					}
				}
			}
    		break;
  	    case "CLSID:9CD77D36-9A9F-4CF8-86C5-18AE5B8CA118": // IBChart 경우
			var sheetID = objs[i].id;
			for(var s = 0 ; s < scriptsCnt ; s++){
				var scriptTag = scripts[s].outerHTML;
				if(scriptTag.indexOf(sheetID) > 0){
					var script = scripts[s].innerHTML;
					var pos1 = scriptTag.indexOf("event=\"");
					if(pos1 < 0){
						pos1 = scriptTag.indexOf("event=");
					}
					if(pos1 > 0){
						pos1 = scriptTag.indexOf("On", pos1);
						var pos2 = scriptTag.indexOf("(", pos1);
						var eventName = scriptTag.substring(pos1, pos2);
						scripts[s].text = 'logComEvent(this, "'+eventName+'", arguments);'+script;
					}
				}
			}
    		break;
  	    case CLSID_IBSHEET: // IBSheet 경우
//  	    case "CLSID:341FBC5F-2AE4-41B8-BFE5-A03170569A27": // IBSheet 경우
//  	    case "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423": // IBSheet 경우
			var sheetID = objs[i].id;
			for(var s = 0 ; s < scriptsCnt ; s++){
				var scriptTag = scripts[s].outerHTML;
				if(scriptTag.indexOf(sheetID) > 0){
					var script = scripts[s].innerHTML;
					var pos1 = scriptTag.indexOf("event=\"");
					if(pos1 < 0){
						pos1 = scriptTag.indexOf("event=");
					}
					if(pos1 > 0){
						pos1 = scriptTag.indexOf("On", pos1);
						var pos2 = scriptTag.indexOf("(", pos1);
						var eventName = scriptTag.substring(pos1, pos2);
						scripts[s].text = 'logComEvent(this, "'+eventName+'", arguments);'+script;
					}
				}
			}
    		break;
  	    case "CLSID:B4019746-931F-4116-912C-8A11406BDE80": // IBTab 경우
			var sheetID = objs[i].id;
			for(var s = 0 ; s < scriptsCnt ; s++){
				var scriptTag = scripts[s].outerHTML;
				if(scriptTag.indexOf(sheetID) > 0){
					var script = scripts[s].innerHTML;
					var pos1 = scriptTag.indexOf("event=\"");
					if(pos1 < 0){
						pos1 = scriptTag.indexOf("event=");
					}
					if(pos1 > 0){
						pos1 = scriptTag.indexOf("On", pos1);
						var pos2 = scriptTag.indexOf("(", pos1);
						var eventName = scriptTag.substring(pos1, pos2);
						scripts[s].text = 'logComEvent(this, "'+eventName+'", arguments);'+script;
					}
				}
			}
    		break;
  	  }
    }
}
// log 관련 변수 및 함수
// 끝
//============================================

function initObjectTag(){
	debuglog.checked = true;
    objs = document.getElementsByTagName("OBJECT");
    for(var i = 0 ; i < objs.length ; i++){
  	  switch(objs[i].classid){
  	    case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
			break;
  	    case CLSID_IBMCOMBO: // IBMultiCombo 경우
//  	    case "CLSID:0B0683AE-1FB7-438f-AA3C-087E11C8AE2D": // IBMultiCombo 경우
  	    	objs[i].style.imeMode = "disabled";
  	    	log(objs[i].id + " : " + objs[i].style.imeMode);
    		break;
  	    case CLSID_IBSHEET: // IBSheet 경우
//  	    case "CLSID:341FBC5F-2AE4-41B8-BFE5-A03170569A27": // IBSheet 경우
//  	    case "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423": // IBSheet 경우
  	    	objs[i].style.imeMode = "disabled";
  	    	log(objs[i].id + " : " + objs[i].style.imeMode);
    		break;
  	    case "CLSID:B4019746-931F-4116-912C-8A11406BDE80": // IBTab 경우
    		break;
  	  }
    }
}

/*
 * Period의 기간의 주차를 계산한다.
 * @param yr1 시작년도
 * @param wk1 시작주차 
 * @param yr1 끝년도
 * @param wk1 끝주차 
 * @return -1 : 잘못된 데이터, 계산된 주차
 * @author 송민석
 */
function calcPeriod(yr1,wk1,yr2,wk2){
    var weeks = -1;
    var sign = 1;
    try{
//        var iYr1 = parseInt2(yr1);
//        var iWk1 = parseInt2(wk1);
//        var iYr2 = parseInt2(yr2);
//        var iWk2 = parseInt2(wk2);
        var iYr1 = parseInt(yr1);
        var iWk1 = parseInt(wk1);
        var iYr2 = parseInt(yr2, 10);
        var iWk2 = parseInt(wk2, 10);
        var currWk = 0;
        
        if( iYr1 > iYr2 ){
            sign = -1;
            var tmp = iYr1;
            iYr1 = iYr2;
            iYr2 = tmp;
        }else if( iYr1 == iYr2 && iWk1 > iWk2 ){
            sign = -1;
            var tmp = iWk1;
            iWk1 = iWk2;
            iWk2 = tmp;            
        }
        var calWeeks = 0;        
        if(iYr1 == iYr2 ){
            calWeeks += iWk2 - iWk1 + 1 ;  
        }else{
	        // TODO: 차후에는 년도별로 차수가 다르게 계산해서 차수를 구해야함
	        // 그래서 loop를 돌렸음
	        for(var i = 0  ; iYr1+i <= iYr2 ; i++){
	            //TODO: 해당년도의 주차를 구해야함.
	            currWk = 54;
	            //시작년도
	            if( i == 0 ){
    	            calWeeks += currWk - iWk1 + 1;
    	        //종료년도 
	            }else if(iYr1+i == iYr2 ){
	                calWeeks +=  iWk2;
	            }else{
	                calWeeks += currWk;
	            }
	        }
        }
        weeks = calWeeks*sign;
    }catch(e){

        
    }
    return weeks
}	
	
function doSaveSheet(sheetObj, url, subParam, col, sAlert, f_callback){
	if(sAlert == undefined){sAlert = true;}
	if( col != undefined && col != null && col.length != 0){
		var oRows = sheetObj.FindCheckedRow(col);
		if( oRows.length == 0 ){			
			ComShowMessage("There is no data to save");
			return "NODATA";
		}
    }else if(sheetObj.isDataModified == false){
        ComShowMessage("There is no data to save");
        return "NODATA";
    }
    if(sAlert && ComShowConfirm (getMsg("SPC90010")) != 1){
         return "CANCEL";
    }
    if(f_callback != undefined && f_callback != null){
	    var funcExist = true;
	    var func;
		try{
			func = eval(f_callback);
		}catch(e){
			funcExist = false;
		}
		if(funcExist){
			func(sheetObj);
		}
    }    
    if(col == undefined) col = -1;
    if(sheetObj.DoSave(url, subParam, col, false)){
    	var r = sheetObj.EtcData("result");
        return( sheetObj.EtcData("status")+":"+r);
    }
    else{
    	return "ERR";
    }
}

/*
 * 두개 이상의 Sheet에서 하나라도 수정된 Sheet가 존재하는지 체크
 */
function checkModifiedSheet(sheetObjs){
    var modified = false;
    if(sheetObjs.constructor == Array){
       for(var i = 0 ; i < sheetObjs.length ; i++){
           modified = modified || sheetObjs[i].isDataModified;
       }
    }
    else{
        modified = sheetObjs.isDataModified;
    }
    return modified;
}

/*
 * sheet안에서 name에 해당하는 combo에 value값이 있는지 체크
 */
function containsSheetCombo(name, value){
    var data = null;
    eval("data = getSheetCombo_"+name+"()");
    if(data == null) return false;
    var data = "|"+data[0]+"|";
    return (data.indexOf("|"+value+"|") >= 0);
}

/**
 * func수행을 1ms waiting
 */
var objectState = new Array();
function wait(func, bOpenLayer){
	zu_openRunning(true, bOpenLayer);
	setTimeout(func+";zu_openRunning(false);", 1);
}

/*
 * 팝업창 띄우기
 */
var popupList = new Array();
popupList["SalesOffice"] = new Array("/hanjin/COM_ENS_071.do", 770, 452);
popupList["SalesOffice1"] = new Array("/hanjin/COM_ENS_071.do", 770, 452);
popupList["ContractOffice"] = new Array("/hanjin/COM_ENS_071.do", 770, 452);
popupList["Customer"] = new Array("/hanjin/COM_ENS_041.do", 770, 475);
popupList["CustomerGroup"] = new Array("/hanjin/COM_ENS_051.do", 770, 475);
popupList["POL"] = new Array("/hanjin/COM_ENS_051.do", 770, 475);
popupList["POD"] = new Array("/hanjin/COM_ENS_051.do", 770, 475);
popupList["Port"] = new Array("/hanjin/COM_ENS_051.do", 770, 475);
popupList["UserID"] = new Array("/hanjin/COM_ENS_091.do", 770, 577);
//popupList["VVD"] = new Array("/hanjin/COM_ENS_0B1.do", 620, 455); -- ALPS 에서 삭제됨
popupList["VVD"] = new Array("/hanjin/COM_ENS_0B2.do", 770, 455);
popupList["Yard"] = new Array("/hanjin/COM_ENS_061.do", 770, 475);
popupList["Lane"] = new Array("/hanjin/COM_ENS_081.do", 770, 475);

function spcPopup(module, param, width, height, callback, option, row, col){
    if(row != undefined && col != undefined){
        return ComOpenPopup(popupList[module][0]+"?"+param, popupList[module][1], popupList[module][2], callback, option, true, false, row, col);
    }
    else{
        return ComOpenPopup(popupList[module][0]+"?"+param, popupList[module][1], popupList[module][2], callback, option, true);
    }
}


/*
 * sheet의 필터링 -  sheetObj의 cols 컬럼의 값과 oriValues의 값과 일치 하는 row만 display한다.
 * **주의** sheetObj에는 hiddencheck 라는 컬럼이 존재해야만 한다.
 * 
 * @param sheetObj 필터링 하고자 하는 sheet
 * @param oriValues 찾고자 하는 값(Array) 
 * @param cols sheetObj에서 찾고자 하는 컬럼
 * @param isOrder 현재 sheetObj가 cols의 값 순서대로 정렬 되어 있는지 여부( true :정렬되어 있음, false:정렬되어 있지 않음) 
 * @param isRowSumable hidden되는 AutoSum 컬럼의 row를  합계에 포함시킬지 여부(default=false)
 *                    ( true :hidden row도 포함시킴, false:hidden row를 포함시키지 않음) 
 * @return  display된 row의 갯수
 * @author 송민석
 */
function processFilterSheet(sheetObj, oriValues , cols, isOrder, isRowSumable ){
     var filterCnt= 0;
     var preStatus;
     sheetObj.ReDraw=false;
     // clear
     var sRow  = sheetObj.FindCheckedRow("hiddencheck") ;
     var arrRow = sRow.split("|");
     for (var idx=0; idx<arrRow.length-1; idx++){ 
         sheetObj.RowHidden(arrRow[idx]) = true;
         preStatus = sheetObj.RowStatus(arrRow[idx]);
         sheetObj.CellValue2(arrRow[idx],"hiddencheck")="0";  
         if(isRowSumable != true )
           sheetObj.RowSumable(arrRow[idx])=false; 
         sheetObj.RowStatus(arrRow[idx]) = preStatus;   
                      
 
     }         
     if( oriValues == undefined || oriValues.length == 0){
         return;
     }else if( !(oriValues instanceof Array)){
         var arr = Array(1);
         arr[0] = oriValues;
         oriValues = arr;
     }   
              
     if( !(cols instanceof Array)){
         var arr = Array(1);
         arr[0] = cols;
         cols = arr;
     }
  

     if( !isOrder ){//정렬 안되어 있을때

         for(var i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++){
             var flg = false;
             for(var j = 0 ; j < cols.length ; j++ ){
                 var subValue = sheetObj.CellValue(i,cols[(j)]);
                 if(oriValues[j] != subValue  ){
                     flg = true;
                     break;
                 }
             }
             if(flg == false  ){
                  filterCnt++;  
                  sheetObj.RowHidden(i) = flg;
                  preStatus = sheetObj.RowStatus(i);
                  sheetObj.CellValue2(i,"hiddencheck")="1";   
                  if(isRowSumable != true)                  
                       sheetObj.RowSumable(i)=true;
                  sheetObj.RowStatus(i) = preStatus;
                      
             }               
             
              
         }
     }else{//데이터가 정렬되어 있을때

         var selRow = 0;
         for(var j = 0 ; j < cols.length ; j++ ){
             selRow = sheetObj.FindText(cols[j],oriValues[j],selRow);
             if( selRow < 0 ){//찾는 값이 없다..
                 break;
             }
         }   
         if( selRow >= 0 ){      
            
             for(var i=selRow ; i <= sheetObj.LastRow ; i++){
                 var flg = false;
                 for(var j = 0 ; j < cols.length ; j++ ){
                     var subValue = sheetObj.CellValue(i,cols[(j)]);
                     if(oriValues[j] != subValue  ){
                         flg = true;
                         break;
                     }
                 }
                 if(flg == false  ){
                     filterCnt++;                 
                     sheetObj.RowHidden(i) = flg;
                     preStatus = sheetObj.RowStatus(i);
                     sheetObj.CellValue2(i,"hiddencheck")="1"; 
                     if(isRowSumable != true)  
                        sheetObj.RowSumable(i)=true;
                     sheetObj.RowStatus(i) = preStatus;                             
                 }else{//sort되어 있기 때문에 더이상 loop를 돌필요 없다.
                     break;
                 }
                  
             }      
         }           

    }

     sheetObj.ReDraw=true; 
     return filterCnt;
}

/*
 * 대소문자 전환
 */
var UPPER_CASE = 1;
var LOWER_CASE = -1;
function eventKeyChangeChar(flag){

    var key = event.keyCode;
    if(key >= (81 + (flag * 16)) && key <= (106 + (flag * 16))){
        event.keyCode = key - (flag * 32);
    }
}


/*
 * IBCombo에서 code값으로 text값을 알아내기
 */
function getIBCodeComboText(){
    var  name, value;
    if(arguments.length == 2){
        name = arguments[0];
        value = arguments[1];
        var codes;
        var texts;
        eval("codes = "+name+"Code");
        eval("texts = "+name+"Text");
        codes = codes.split("|");
        texts = texts.split("|");
        var code = "";
        var text = "";
        for(var i = 0 ; i < codes.length ; i++){
            if(codes[i] == value){
                return texts[i];
            }
        }
    }
    return "";
}

/*
 * 초기화
 */
function resetAll(){
    
    if(arguments[0] == undefined || arguments[0]){
        document.form.reset();
    }
    var objs = document.getElementsByTagName("OBJECT");
    for(var i = 0 ; i < objs.length ; i++){
        switch(objs[i].classid){
        case CLSID_IBSHEET: // IBSheet
//        case "CLSID:341FBC5F-2AE4-41B8-BFE5-A03170569A27": //IBSheet
//        case "CLSID:C838E9DA-1625-4E14-8B37-C6706B43C423": //IBSheet
            if(arguments[2] != undefined && !arguments[2]) continue;
            log(objs[i].id);
            objs[i].RemoveAll();
            break;
        case CLSID_IBMCOMBO: //IBMultiCombo
            if(arguments[1] != undefined && !arguments[1]) continue;
            var id = objs[i].id;
            if(eval("initDataValue_" + id)){
                log("initDataValue_" + id + "()");
                eval("initDataValue_" + id + "()");
            }
            break;
        }
    }
}


/*
 * len만큼 ch를 뒤에서 채우기
 */
function rpad(newValue, len, ch){
     var strlen = ComTrim(newValue).length;
     var ret = "";
     var alen = len - strlen;
     var astr = ""; 
     
     //부족한 숫자만큼  len 크기로 ch 문자로 채우기
     for (i=0; i<alen; ++i)
     {
      astr = astr + ch;
     }
     ret = ComTrim(newValue) + astr; //뒤에서 채우기
     return ret;
}

/*
 * len만큼 ch를 앞에서 채우기
 */
function lpad(newValue, len, ch){
 
    // 왼쪽에 ch 문자 채우기
     var strlen = ComTrim(newValue).length;
     var ret = "";
     var alen = len - strlen;
     var astr = ""; 
     
     //부족한 숫자만큼  len 크기로 ch 문자로 채우기
     for (i=0; i<alen; ++i)
     {
      astr = astr + ch;
     }
     
     ret = astr + ComTrim(newValue); //앞에서 채우기
     return ret;
}

/*
 * 버튼 활성화/비활성화
 */
function btnImgEnable(obj, gb) {
	if(obj.constructor == String){
		obj = document.getElementsByName(obj)[0];
	}
	var btnStyle = obj.style;
	if (gb){
		obj.Enable = true;
		btnStyle.cursor = "hand";
		btnStyle.filter="";
	} else {
		obj.Enable = false;
		btnStyle.cursor = "auto";
		btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
	}
}

var KEY_0 = 48;
var KEY_9 = 57;
var KEY_A = 65;
var KEY_Z = 90;
var KEY_a = 97;
var KEY_z = 122;
var KEY_CONTROL = 31;
var KEY_SPACE = 32;
var KEY_MINUL = 45;
var KEY_PLUS = 43;

/*
 * ComIsDate:입력값을 일자 Format 인지 확인
 * 날짜데이터 확인 후 Focus를 준다.
 */
function checkDate(){
	var obj = event.srcElement;
	var value = obj.value;
	if(value.length == 0){
		return;
	}
	else if(!ComIsDate(obj)){//
		ComShowCodeMessage("COM12179");
		obj.select();
		obj.focus();
		event.returnValue = false;
		return false;
	}
}

/*
 * 키값이 0-9사이 즉 숫자인지 확인
 */
function checkDateFormat(){
	var key = event.keyCode;
	if((key >= KEY_0 && key <= KEY_9)){
		event.returnValue = true;
	}
	else{
		event.returnValue = false;
	}
}

/*
 * 날짜를 'YYYYmmDD' 포맷으로 변경해서 값을 세팅한다.
 */
function initDate(){
	var obj = event.srcElement;
	var valueo = obj.value;
	var valuen = valueo.replace(/\/|\-|\./g,"");//정규식
	if(valueo != valuen)
	{
		obj.value = valuen;
		obj.focus();
		obj.select();
	}
}

/*
 * 날짜를 'YYYY-mm-DD'형식으로 변경한다.
 */
function convertDateFnc(){
	var obj = event.srcElement;
	var value = obj.value;
	if(value.length == 8){
		value = value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6);
		obj.value = value;
	}
}

/*
 * Sheet 확대/축소시 사이즈 변경
 */
function toggleSheetSize(){
	var obj = event.srcElement;
	var status = "N";
	if(obj.maxStatus == undefined || obj.maxStatus == "N"){
		status = "M";
	}
	var sheetId = obj.sheetId;
	var type = obj.type;
	if(sheetId == undefined || type == undefined) return;
	var sheetObj = document.getElementById(sheetId);
	var isSheet = (sheetObj.tagName == "OBJECT");
	var curRow = 0;
	if(isSheet){
		curRow = sheetObj.SelectRow;
	}
	var area = obj;
	while((area.tagName != "TABLE" || area.className != "search") && area != document){
		area = area.parentElement;
	}
	if(area.parentElement.tagName == "DIV"){
		area = area.parentElement;
	}
	var main = area.parentElement;
	var tables = main.children;
	var titleArea = tables[1];
	var posTop = 0;//titleArea.offsetTop + titleArea.offsetHeight;
	for(var i = 0 ; i < tables.length ; i++){
		if(tables[i].className == "title" || tables[i].className == "button"){
			posTop = posTop + tables[i].offsetHeight;
			continue;
		}
		if(tables[i] == area){
			continue;
		}		
		if(status == "M"){
			tables[i].orgDisplay = tables[i].style.display;
			tables[i].style.display = "none";
		}
		else{
			tables[i].style.display = tables[i].orgDisplay;
		}
        //setTimeout("dummy_fuction()", 10);
	}
	if(status == "M"){
		var etcHeight = area.offsetHeight - sheetObj.offsetHeight;
		var copyArea = main.parentElement.parentElement.parentElement;
		var sizeHeight = document.body.clientHeight - posTop - etcHeight - 20;
		area.sheetHeight = sheetObj.style.height;
		sheetObj.style.height = sizeHeight;
		obj.maxStatus = "M";
		obj.src = "/hanjin/img/bu_prev01.gif";
	}
	else{
		sheetObj.style.height = area.sheetHeight;
		obj.maxStatus = "N";
		obj.src = "/hanjin/img/bu_next01.gif";
	}	currSheet = sheetObj;
		
	if(isSheet){
		setTimeout("scrollToCurRow()", 1);
	}
}

/*
 * 최상단 데이터 행 Setting
 */
var currSheet = null;
function scrollToCurRow(){
	if(currSheet != null){
		if(currSheet.SelectRow != -1) currSheet.TopRow = currSheet.SelectRow * 1;
		currSheet = null;
	}
}

/*
 * 0값을 NullString으로 리턴:0->String전환
 */
function getZeroToNullString(vl) {
	return vl == 0 ? "" : vl;
}

/*
 * NullString값을 0으로 리턴:String->0전환
 */
function getNullStringToZero(vl) {
	return vl == "" ? 0 : vl;
}

/*
 * RGB값 
 */
function getRGBColor(r, g, b){
	return (b * 256 + g) * 256 + r;
}

var colors = new Array(
		getRGBColor(225,244,226), getRGBColor(237,255,168), getRGBColor(235,240,255)
	);
	
function getColors(i){
	if(i == undefined){
		return colors;
	}
	var size = colors.length;
	var arrs = new Array();
	for(var c = 0 ; c < i ; c++){
		arrs[c] = colors[c % size];
	}
	return arrs;
}
function getColor(i){
	var size = colors.length;
	var arrs = new Array();
	if(i < 0){
		i = 0;
	}
	return colors[i % size];
}

function setUITitle(UI_ID){
	var UI_TITLE = "";
	switch(UI_ID){
	case 'ESM_SPC_XLS': UI_TITLE = 'EXCEL Download Method';break;
	case 'ESM_SPC_0002': UI_TITLE = 'Space alloc level creation';break;
	case 'ESM_SPC_0003': UI_TITLE = 'Space alloc level inquiry';break;
	case 'ESM_SPC_0004': UI_TITLE = 'Initial Space Allocation Ratio Creation';break;
	case 'ESM_SPC_0005': UI_TITLE = 'Initial Space Allocation Ratio Inquiry';break;
	case 'ESM_SPC_0011': UI_TITLE = 'Constraints List Creation';break;
	case 'ESM_SPC_0012': UI_TITLE = 'Constraints List Inquiry';break;
	case 'ESM_SPC_0013': UI_TITLE = 'Pre-alloc creation';break;
	case 'ESM_SPC_0014': UI_TITLE = 'Pre-alloc inquiry';break;
	case 'ESM_SPC_0015': UI_TITLE = 'No-show Ratio Reflection Creation';break;
	case 'ESM_SPC_0016': UI_TITLE = 'No-show Ratio Reflection Inquiry';break;
	case 'ESM_SPC_0017': UI_TITLE = 'Space Guarantee for Customer Inquiry';break;
	case 'ESM_SPC_0018': UI_TITLE = 'Temparary T/S G/L inquiry';break;
	case 'ESM_SPC_0019': UI_TITLE = 'Maximum L/F Creation';break;
	case 'ESM_SPC_0020': UI_TITLE = 'Maximun L/F Inquiry';break;
	case 'ESM_SPC_0021': UI_TITLE = 'Performance Summary by RHQ';break;
	case 'ESM_SPC_0022': UI_TITLE = 'Performance Summary by Trade';break;
	case 'ESM_SPC_0023': UI_TITLE = 'Space Util Status';break;
	case 'ESM_SPC_0024': UI_TITLE = 'No-show Summary';break;
	case 'ESM_SPC_0025': UI_TITLE = 'Model Result Summary';break;
	case 'ESM_SPC_0026': UI_TITLE = 'Allocation History Summary';break;
	case 'ESM_SPC_0028': UI_TITLE = 'Performance Summary by Office';break;
	case 'ESM_SPC_0041': UI_TITLE = 'Space-Reallocation Model Check & Run';break;
	case 'ESM_SPC_0042': UI_TITLE = '1st Allocation Control - Asia HO';break;
	case 'ESM_SPC_0043': UI_TITLE = 'Alloc update-RHQ';break;
	case 'ESM_SPC_0044': UI_TITLE = '3rd Allocation Control - Asia Office';break;
	case 'ESM_SPC_0045': UI_TITLE = 'Bottleneck Check';break;
	case 'ESM_SPC_0047': UI_TITLE = '1st Allocation Control - USA / EUR HQ';break;
	case 'ESM_SPC_0049': UI_TITLE = '2nd Allocation Control - USA / EUR HQ';break;
	case 'ESM_SPC_0050': UI_TITLE = '3rd Allocation Control - USA / EUR Office';break;
	case 'ESM_SPC_0051': UI_TITLE = 'Space Usage Creation';break;
	case 'ESM_SPC_0052': UI_TITLE = 'Space Usage Inquiry';break;
	case 'ESM_SPC_0053': UI_TITLE = 'Control Option Inquiry';break;
	case 'ESM_SPC_0054': UI_TITLE = 'Model Run Log Inquiry';break;
	case 'ESM_SPC_0055': UI_TITLE = 'Additional Allocation Control';break;
	case 'ESM_SPC_0056': UI_TITLE = 'T/S Volume Inquiry';break;
	case 'ESM_SPC_0057': UI_TITLE = 'Customer Allocation Inquiry';break;
	case 'ESM_SPC_0058': UI_TITLE = 'Space Utilization Inquiry VVD';break;
	case 'ESM_SPC_0062': UI_TITLE = 'Allocation Contract Terms Management';break;
	}
    var obj = document.getElementsByTagName("IMG");
    var span = document.createElement("SPAN");
    span.innerHTML = UI_TITLE;
    for(var i = 0 ; i < obj.length ; i++){
        if(obj[i].src.indexOf("ico_t1.gif") >= 0){
            obj = obj[i];
            obj = obj.parentElement;
            if(obj.innerText == ""){
    			obj.appendChild(span);
    			obj.parentElement.parentElement.parentElement.deleteRow(0);
    		}
            break;
        }
    }
	
}

/*
return value : String
	NODATA - 처리할 데이터가 없는 경우
	AY - 전체 데이터를 Format 적용해서 down 받는 경우
	DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
	AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
	DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
	CANCEL - Close버튼이나 창을 바로 닫은 경우
예
	var rtn = selectDownExcelMethod(sheetObj);

*/
function selectDownExcelMethod(sheetObj){
    var rowCnt = sheetObj.RowCount ;
	if(rowCnt == 0){
		sheetObj.Down2Excel(-1, false, false, true);
		return "NODATA";
	}
	var flg ;
	
	with(sheetObj){
	    rowCnt = LastRow;
    	for(var i=HeaderRows ; i <=  rowCnt; i++ ){
            flg = IsHaveChild (i, true) 	;   
            if( flg == true){
                break;
            } 
    	}
	}
	var sFeature = "";
	sFeature = sFeature + "dialogHeight:230px;"
	sFeature = sFeature + "dialogWidth:300px;"
	sFeature = sFeature + "center:yes;"
	sFeature = sFeature + "resizable:no;"
	sFeature = sFeature + "scroll:no;"
	sFeature = sFeature + "status:no;"
	var rtn = window.showModalDialog("ESM_SPC_XLS.do?sysCommUiTitle=Excel Download&sysCommUiNavigation=Excel Download", flg, sFeature);
	return rtn;
}

/*
 * @param msg 보여질 메시지
 * @param 0 : 단순 alert창 (default),
 *        1 : return 값을 요하는 confirm
 * @param width : msg창의 width (default 400 )
 * @param height : msg창의 height  (default 300 )
 * @return value : String( windowType이 1 일경우에만 값이 유효함 )
    0 - CANCEL
	1 - YES 버튼을 눌렀음.
*/
function showMsgWindow(msg,windowType,width,height){

	var sFeature = "";

	if(width == undefined ){
	    width = "400"; 
	}
	if(height == undefined ){
	    height = "300"; 
	}	
	sFeature = sFeature + "dialogHeight:"+height+"px;"
	sFeature = sFeature + "dialogWidth:"+width+"px;"
	sFeature = sFeature + "center:yes;"
	sFeature = sFeature + "resizable:no;"
	sFeature = sFeature + "scroll:no;"
	sFeature = sFeature + "status:no;"
	if( windowType == undefined ){
	    windowType = "0";
	}
	var msgArr = new Array();
	var tmpArr = "";
	var idx = 0;
	if(msg.constructor == String){
		msgArr = getStringToArray(msg,1024);
	}
	else{
   		idx = 0;
	    for(var msgIdx=0 ; msgIdx < msg.length ; msgIdx++){
    		tmpArr = getStringToArray(msg[msgIdx],1024);
    		for(var i = 0 ; i < tmpArr.length ; i++){
    		    msgArr[idx] = tmpArr[i];
    		    idx++;
    		}
    		msgArr[idx] = "\r\n\r\n";
    		idx++;
	    }
	}
	var rtn = window.showModalDialog("/hanjin/ESM_SPC_MSG.do?windowType="+windowType, msgArr, sFeature);
	return rtn;
}

function getStringToArray(msg,size){
	var len = msg.length;
	var msgArr = new Array();
	if(len > size ){
		for(var i = 0 ; i < len / size + 1 ; i++){
			msgArr[i] = msg.substring(i*size, (i+1)*size);
		}
	}
	else{
	    msgArr[0] = msg;	
	}   
	return msgArr;	 
}

/**
 * tgtOrzCd Combo 를 초기 설정한다.
 * @date 2007-04-04 mslee
 **/
function tgtOrzCdCombo_init() {
	var comboObj = document.getElementById("tgtOrzCd");
	comboObj.SetTitle("Status|Created Date");		
	comboObj.SetColWidth("180|110");
}

/**
 * tgtOrzCd Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
 * @date 2007-04-04 mslee
 * @param comboObj - Combo object
 * @param param - 코드 조회시 필요한 조건 parameter string
 **/	
function getTgtOrzCdComboList(comboObj, param) {
	comboObj.RemoveAll();
	
	var cmd = "TgtOrzCd";

	// code search 
    createCodeSheetObject();
    with(codeSheet){
        ShowDebugMsg = false;
        var newParam = "f_cmd="+SEARCHLIST01+"&mcode="+cmd+"&"+param;
   		DoSearch4Post("ESM_SPC_CODGS.do", newParam);
        
        for(var i = 1 ; i <= RowCount ; i++){
        	var cellText = CellText(i, "TEXT");
        	var arr = cellText.split("||");
        	var desc = arr[0];
        	var dt = arr[1];
        	comboObj.InsertItem(-1, desc+"|"+dt, CellText(i, "CODE"));
        }
    }
}
 
 /**
  * ContiCd Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
  * @date 2011-04-11 
  * @param comboObj - Combo object
  * @param param - 코드 조회시 필요한 조건 parameter string
  **/	
 function SpcSearchOptionContiCd(elemName, isAll, isRepTrade, del) {
	if(isAll == undefined || isAll == null){
		isAll = true;
	}
	
	if(isRepTrade == undefined || isRepTrade == null){
		isRepTrade = false;
	}
	
	if(del == undefined || del == null){
		del = '';
	}
	var obj = document.getElementById(elemName);
	
	var rtn = getCodeXmlList("ContiCdCombo", "isRepTrade=" + isRepTrade + "&del=" + del);
	
	obj.setTitle("conti_cd|conti_nm");
	obj.SetColWidth("65|100");
	
	ComXml2ComboItem(rtn, obj, "conti_cd", "conti_cd|conti_nm");
	
	if(isAll)
		obj.InsertItem(0, "|ALL");
	
	
 } 

function getCodeXmlList(cmd, param){
	var rtn = new Array();
    rtn[0] = "";
    rtn[1] = "";
    
    createCodeSheetObject();
    
    with(codeSheet){
        ShowDebugMsg = false;
        var sXml = GetSearchXml("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
        var xml  = sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
    }
    return xml;
}  
  
/**
 * 전체 Child 를 조회하기 위해 사용
 * @date 2007-04-05 mslee
 * @param sheetObj - Sheet object
 **/
function retrieveAllChilren(sheetObj) {
	
	if (haveChildLevels[currentTabIndex] == 0) {
		return;
	}
	
	var sheetId = sheetObj.id;
	var rowCnt = sheetObj.RowCount;
	var rowLevel;

	var retrieveCnt = 0;
	var i = rowCnt;
	while (i >= 0) {
		i--;
		
		rowLevel = sheetObj.RowLevel(i);

		var childKey = "";
		for (var j=0; j<rowLevel-1; j++) {
			childKey += sheetObj.CellValue(i, j);
		}
		
		var retrievedChild = false;
		for (key in retrievedChildKeysObj[sheetObj.id]) {
			if (key == childKey) {
				retrievedChild = true;
				break;
			}
		}
		
		if (retrievedChild == false) { //이미 조회된 Child가 아닐 경우
		
			if (rowLevel == haveChildLevels[currentTabIndex]) {
				
				var cellValue = sheetObj.CellValue(i, rowLevel-1);
				var endRow;
				if (cellValue.indexOf( "TOTAL" ) == 0) {
					
					var prevCellValue = sheetObj.CellValue(i, rowLevel-2); //이전 컬럼 값
					cellValue = prevCellValue + cellValue;
					endRow = i;
					var currentCellValue;
					
					do {
						endRow--;
						currentCellValue = sheetObj.CellValue(endRow, rowLevel-1);
						var currentPrevCellValue = sheetObj.CellValue(endRow, rowLevel-2); //이전 컬럼 값
						currentCellValue = currentPrevCellValue + currentCellValue;
					}
					while (cellValue == currentCellValue)

					eval(sheetId+"_OnTreeChild(sheetObj, null, i)");
					retrieveCnt++;

					i = endRow+1;
				}
			} 
		}
	}
}

/**
 * 전체 Child 를 조회하기 위해 사용 : 조회된 Child의 key를 기록한다.
 * @date 2007-04-05 mslee
 * @param sheetObj - Sheet object
 * @param Row - 기록할 row index
 **/
function recordChildKey(sheetObj, Row) {
	var childKey = "";
	for (var i=0; i<haveChildLevels[currentTabIndex]-1; i++) {
		childKey += sheetObj.CellValue(Row, i);
	}
	retrievedChildKeysObj[sheetObj.id][childKey] = childKey;		
}

function convertAqCd(aqCd) {
	if (aqCd == "  ") {
		aqCd = "000000";
	} 
	
	return aqCd;
}	

function common_tree_DblClick(sheetObj, Row, Col) {	
	with(sheetObj) {
		//클릭 한 위치에 텍스트를 가져온다.
		var text = CellValue(Row,Col);
		if (text.indexOf('TOTAL') == -1) return;

		var end_row = Row;
		//var end_row = FindText(Col, text, Row, false);
		
		var end_text = "";
		// 루프 돌면서 아래쪽으로 내려가면서 자기와 다른 텍스트가 나올때까지 검사한다.
		do {
			end_row++;
		//	end_text = CellText(end_row,Col);
		//} while (text == end_text );
		} while (!IsHaveChild(end_row));

		//다른 텍스트 한칸 위가 트리의 자식 노드를 갖는 노드이다.
		//	end_row = end_row-1;
		log("find end-row=" + end_row);
		//펼치거나 접기에 앞서서 그 노드가 보여지고 있는 노드인가 점검한다.
		if(!(RowHidden(end_row))){
			//보여지고 있는 노드라면 접어져 있으면 펼치고, 펼쳐져 있으면 접는다.
			RowExpanded(end_row) = !(RowExpanded(end_row));
		}
	}
}

function spc_IBC_fetchUrlData(ibchart, url, param){
	var paramObj=ibchart.CreateHttpParameters();
	var params = param.split("&");
	for(var i = 0 ; param != "" && i < params.length ; i++){
		var p = params[i].split("=");
		paramObj.AddValue(p[0], p[1]);
	}
	ibchart.FetchDataUrl(H_getAbsoluteUrl(url),paramObj);
}

function getEtcData(xml, key){
	var xmlDoc = document.createElement("XML");
	xmlDoc.async = false;
	xmlDoc.loadXML(xml);
	var nodes = xmlDoc.selectNodes("SHEET/ETC-DATA/ETC");
	var etcs = new Array();
	for(var i = 0 ; i < nodes.length ; i++){
		var node = nodes.nextNode();
		etcs[node.attributes[0].value] = node.text;
	}
	return etcs;
}


/**
 * 월간 화면 조회조건의 Year Month 값 +2개월로 setting
 **/
function setYearMonthObject(yearObj, monthObj) {
	var month = ["01","02","03","04","05","06","07","08","09","10","11","12","01","02"];

    var initDate = new Date();    
	
	if (initDate.getMonth() < 10) {
		yearObj.value = initDate.getYear();
	} else {
		yearObj.value = initDate.getYear()+1;
	}

	monthObj.value = month[initDate.getMonth() + 2];
}


/**
 * 월간 확정 화면 조회조건의 Year Month 값 Release 월로 setting
 **/
function setYearMonthObjectByRelease(yearObj, monthObj) {
	// Release Year Month 
	var rtn = getCodeList("SAQMonthlyQuotaReleaseYearMonth", "");
	
	yearObj.value = rtn[0].substring(0,4);
	monthObj.value = rtn[0].substring(4,6);
}

/**
 * 조정 화면의 상태 도움말 팝업
 **/
function popupCodeInfo(screenX,screenY,offsetX,offsetY){
	var popup_marginLeft= screenX - offsetX - 170;
	var popup_marginTop= screenY - offsetY + 30;
	var arg = 'menubar=no,width=190,height=290,status=no,left='+popup_marginLeft+',top='+popup_marginTop;

	if(popupCodeInfoClosed.closed==true || popupCodeInfoClosed==true){
		popupCodeInfoClosed = window.open('ESM_SPC_117.do','',arg);
	}else{
		popupCodeInfoClosed.focus();
	}
}

function messagePopup(){
	var msg = "";
	for(var i = 0 ; i < arguments.length ; i++){
		msg = msg + " - " + arguments[i];
	}
	msg = msg.substring(3);
	ComShowConfirm(msg);
}
function makeMessageString(){
	var msg = "";
	for(var i = 0 ; i < arguments.length ; i++){
		msg = msg + " - " + arguments[i];
	}
	msg = msg.substring(3);
	return msg;
}

/*======================== 단축키 설정으로 인해 추가된 FUNCTION ========================*/
function spcKeyAction(uiname){    
    //KeyNo = (document.layers) ? e.which : event.keyCode; 
    //alert("ASCII 코드 : " + KeyNo + "ASCII 문자 : " + String.fromCharCode(KeyNo)); 
    //alert(event.keyCode);
    //Short Cut을 적용할 UI, 화면별로 적용할 shortKey를 설정한다.
    
	if(document.form.uiname != undefined){
		//Enter:13 일반적인 Enter는 onShortKeyEnter()에서 처리하지만 IBMultiCombo의 Enter는 각 화면단 .js에서 Object별로 따로 처리한다.
	    if(event.keyCode==13) {onShortKeyEnter();} 
	      
	    //Tab처리
	    if(uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0028') if(event.keyCode==9) {search_OnKeyDownTab();} 
	    
	    //Sheet간 이동 1:49 - 7:55
	    if(event.altKey && event.keyCode==49) onShortKeyAlt1();
	    if(uiname !='ESM_SPC_0102' || uiname !='ESM_SPC_0056') if(event.altKey && event.keyCode==50) onShortKeyAlt2();
	    if(uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0028' || uiname=='ESM_SPC_0024'){
	        if(event.altKey && event.keyCode==51) onShortKeyAlt3();
	        if(event.altKey && event.keyCode==52) onShortKeyAlt4();
	    }
	    if(uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0024') if(event.altKey && event.keyCode==53) onShortKeyAlt5();    
	    //if(event.altKey && event.keyCode==54) onShortKeyAlt6();
	    //if(event.altKey && event.keyCode==55) onShortKeyAlt7();

	    //조건간 이동 ,(<):188, .(>):190
	    if(event.altKey && event.keyCode==188) onShortKeyAltComma();
	    if(uiname !='ESM_SPC_0070') if(event.altKey && event.keyCode==190) onShortKeyAltPeriod();

	    //화면 확대/축소 38:방향키 위(sheet1 toggle), 40:방향키 아래(sheet2 toggle)
	    if(uiname != 'ESM_SPC_0045'|| uiname != 'ESM_SPC_0058'|| uiname !='ESM_SPC_0056' || uiname !='ESM_SPC_0024' || uiname !='ESM_SPC_0070') {
	        //bottleneck화면, Inquiry by T/S Port, NoShow화면 Toggle없음
	       if(event.altKey && event.keyCode==38) onShortKeyAltUp(); //sheet1 toggle
	       if(event.altKey && event.keyCode==40) onShortKeyAltDown(); //sheet2 toggle
	    }
	    
	    //o:79 (Confirm), r:82(Retrieve), n:78(New), s:83(Save, control option save)
	    //i:73(Edit), x:88(control option cancel)
	    //b:66(Bottle neck), k:75(SKD Inquiry), m:77(BSA Management)
	    if(event.altKey && event.keyCode==82) onShortKeyAltR(); //Retrieve
	    if(event.altKey && event.keyCode==78) onShortKeyAltN(); //New
	    if(uiname == 'ESM_SPC_0042' ||uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047' 
	      || uiname == 'ESM_SPC_0070' || uiname == 'ESM_SPC_0102') {
	        if(event.altKey && event.keyCode==83) onShortKeyAltS(); //Save, control option save
	    }
	    if(uiname == 'ESM_SPC_0042' ||uiname == 'ESM_SPC_0047'){ //Allocation화면에만 적용
	        if(event.altKey && event.keyCode==73) onShortKeyAltI(); //Edit
	        if(event.altKey && event.keyCode==66) onShortKeyAltB(); //Bottle neck
	        if(event.altKey && event.keyCode==77) onShortKeyAltM(); //BSA Management
	        if(event.altKey && event.keyCode==88) onShortKeyAltX(); //control option cancel           
	    }
	    if(uiname == 'ESM_SPC_0102'){//Forecast화면에만 적용
	        if(event.altKey && event.keyCode==79) onShortKeyAltO(); //Confirm
	    }
	    if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047') {
	        if(event.altKey && event.keyCode==75) onShortKeyAltK();//SKD Inquiry
	    }
	    
	    //+plus:187
	}
}

//---------------------------------------------------------------------------------------------
//Enter처리:MultiCombo내에서 혹은 검색조건에서 Enter키를 누른 경우
//trade선택 부분에서 Enter를 누른경우
function trade_OnKeyDown_t(comObj, KeyCode, Shift){ 
    if(KeyCode == 13) { //Enter키의 경우
        alarmMessage("trade_OnKeyDown_t Enter");
        comboEnterKeyAction(comObj);
    }
}

//subtrade선택 부분에서 Enter를 누른경우
function subtrade_OnKeyDown_t(comObj, KeyCode, Shift){
    if(KeyCode == 13) { //Enter키의 경우
        alarmMessage("subtrade_OnKeyDown_t Enter");
        comboEnterKeyAction(comObj, KeyCode, Shift);
    }
}

//lane선택 부분에서 Enter를 누른경우
function lane_OnKeyDown_t(comObj, KeyCode, Shift){
    if(KeyCode == 13) { //Enter키의 경우
        alarmMessage("lane_OnKeyDown_t Enter");
        comboEnterKeyAction(comObj, KeyCode, Shift);
    }
}

//salesOffice선택 부분에서 Enter를 누른경우
function salesOffice_OnKeyDown(comObj, KeyCode, Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 13) { //Enter키의 경우
	        alarmMessage("salesOffice_OnKeyDown Enter");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0102') comboEnterKeyAction(comObj, KeyCode, Shift);
	    }
	}
}

//subOffice선택 부분에서 Enter를 누른경우
function subOffice_OnKeyDown(comObj, KeyCode, Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 13) { //Enter키의 경우
	        alarmMessage("subOffice_OnKeyDown Enter");
	        var uiname = document.form.uiname.value;
	        if( uiname == 'ESM_SPC_0102') comboEnterKeyAction(comObj, KeyCode, Shift);
	    }
	}
}

//salesRep선택 부분에서 Enter를 누른경우
function salesRep_OnKeyDown(comObj, KeyCode, Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 13) { //Enter키의 경우
	        alarmMessage("salesRep_OnKeyDown Enter");
	        var uiname = document.form.uiname.value;   
	        if(uiname == 'ESM_SPC_0102') comboEnterKeyAction(comObj, KeyCode, Shift);
	    }
	}
}

//RHQ선택 부분에서 Enter를 누른경우
function rhq_txt_OnKeyDown_t(comObj, KeyCode, Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 13) { //Enter키의 경우
	        alarmMessage("rhq_txt_OnKeyDown_t Enter");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0022') comboEnterKeyAction(comObj, KeyCode, Shift);
	    }
	}
}

//RHQ선택 부분에서 Enter를 누른경우2
function rhq_OnKeyDown_t(comObj, KeyCode, Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 13) { //Enter키의 경우
	        alarmMessage("rhq_onKeyDown_t Enter");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') comboEnterKeyAction(comObj, KeyCode, Shift);
	    }
	}
}

//IBMultiCombo를 사용한 Combobox에서 Enter키를 Retrieve로 사용
function comboEnterKeyAction(comObj, KeyCode, Shift){
    alarmMessage("press comboEnterKeyAction");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var obj = sheetObjects[0];
        //102번은 첫번째 Sheet를 사용하지 않게 되어 있음
        
        //////////////////////////////////////////////////////////////////////////////////////////
        if(onShortKeyAltR() == false){
            //onShortKeyAltR의 return값이 false이거나 undifined라서 이리처리함. 
            //validation검사후 Focus를 자동으로 갖는다.
        } else if(obj.Rows > obj.HeaderRows) {
            //조회가 완료된경우 데이터가 있으면 sheet에, 조회된 데이터가 없으면 해당 Object에 Focus를 준다.
            if(obj.RowCount>0) {
                if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows, "qta");
                else if(uiname == 'ESM_SPC_0102') obj.SelectCell(obj.HeaderRows + 2, "fcast_ttl_qty");
                else obj.SelectCell(obj.HeaderRows, "VVD");//첫번째 데이터 행을 Select함
            }
            else comObj.focus();
        }
        //////////////////////////////////////////////////////////////////////////////////////////
    }
}

/*
 * 단축키 기능 Enter:sheet조회
 */
function onShortKeyEnter(){
    alarmMessage("press onShortKeyEnter");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var eventSrc = window.event.srcElement;
        var srcName = eventSrc.getAttribute("name");
        var obj = sheetObjects[0]; 
        //102번은 첫번째 Sheet를 사용하지 않게 되어 있음
        //////////////////////////////////////////////////////////////////////////////////////////
        //상단 검색 조건에 Focus가 있는 경우 sheet1 데이터 조회
        if(srcName == 'vvd' || srcName == 'year' || srcName=='month' || srcName == 'week' || srcName == 'duration' 
              || srcName == 'fcast' || srcName == 'bound' || srcName == 'office' || srcName == 'year1' 
              || srcName == 'week1' || srcName == 'year2' || srcName == 'week2' || srcName == 'rhq_txt' 
              || srcName == 'only_vvd' || srcName == 'onc_ipc' || srcName == 'sales_office' 
              || srcName == 'sDate' || srcName == 'eDate' || srcName == 'port' || srcName == 'org'
              || srcName == 'type') {
            if(onShortKeyAltR() == false) {
               //onShortKeyAltR의 return값이 false이거나 undifined라서 이리처리함. 
               //validation검사후 Focus를 자동으로 갖는다.
            } else if(obj.RowCount<1 && obj.Rows > obj.HeaderRows) {
                //조회는 완료되었으나 데이터가 없는 경우 이벤트가 발생한 곳으로 다시 Focus를 준다.
                eventSrc.focus();
            }         
        }
        ////////////////////////////////////////////////////////////////////////////////////////// 
        //나머지의 경우는 상단 Sheet에 조회된 데이터가 있는 경우 하단 Sheet조회
        else if(obj.RowCount>0 && 
            (uiname=='ESM_SPC_0042' || uiname=='ESM_SPC_0044' || uiname=='ESM_SPC_0047' 
                || uiname=='ESM_SPC_0022' || uiname=='ESM_SPC_0028')){
            //sheet1에 조회된 데이터가 있는 경우 sheet2의 데이터 조회
            sheet1_OnDblClick(obj, obj.SelectRow, obj.SelectCol);
            obj = sheetObjects[1];
            obj.SelectCell(obj.HeaderRows, "asgn_ttl_qty");
        }  
        //////////////////////////////////////////////////////////////////////////////////////////
    }
}
//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
//Tab처리
//sheet1에서 Tab을 누르면 하단 검색조건으로 이동한다.
function sheet1_OnKeyDown(sheetObj, Row,Col, KeyCode, Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("sheet1_OnKeyDown Tab");
	        var uiname = null;
	        uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0045'|| uiname == 'ESM_SPC_0058') document.form.year1.focus();
	        else if(uiname == 'ESM_SPC_0022') {
	            var selIndex = tabObjects[0].SelectedIndex;
	            if(selIndex == 0) document.form.rhq_gso1[0].focus();
	            else if(selIndex == 1) document.form.rhq_gso2[0].focus();
	            else if(selIndex == 2) document.form.rhq_gso3[0].focus();
	            else if(selIndex == 3) document.form.rhq_gso4[0].focus();
	            else if(selIndex == 4) document.form.rhq_gso5[0].focus();
	        } else if(uiname == 'ESM_SPC_0028'){
	            var selIndex = tabObjects[0].SelectedIndex;
	            if(selIndex == 0) document.form.chkPol.focus();
	            else if(selIndex == 1) document.form.chkPolPodS[0].focus();
	            else if(selIndex == 2) document.form.chkPolPodC[0].focus();
	        }        
	        else if(uiname == 'ESM_SPC_0056') document.form.sDate.focus();
	        else if(document.form.chkOfc != undefined) document.form.chkOfc.focus();
	    }
	}
}

//sheet2에서 Tab을 누르면 상단 검색조건으로 이동한다.
function sheet2_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("sheet2_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') document.form.type.focus();
	        if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0045'|| uiname == 'ESM_SPC_0058') document.form.year1.focus();
//	        if(uiname == 'ESM_SPC_0042') return false;
	        else return false; //document.form.year.focus();
	    }/* else if(KeyCode == 187){ //+
	        alarmMessage("sheet2_OnKeyDown +");    
	        sheet2_OnClick(sheetObj, Row, Col);
	    }*/
	}
}

function search_OnKeyDownTab(){
	if(document.form.uiname != undefined){
		var uiname = document.form.uiname.value;
	    var eventSrc = window.event.srcElement;
	    var srcName = eventSrc.getAttribute("name");
	    if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028' || uiname == 'ESM_SPC_0056'){
	        if(srcName == 'type1'||srcName == 'type2'||srcName == 'type3'||srcName == 'type4'){
	            alarmMessage("search_OnKeyDownTab");
	            var selIndex = tabObjects[0].SelectedIndex;//선택된 Tab
	            if(selIndex == 0 && srcName == 'type1') sheetObjects[0].SelectCell(sheetObjects[0].HeaderRows, "qta");
	            else if(selIndex == 1 && srcName == 'type2') sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows, "qta");
	            else if(selIndex == 2 && srcName == 'type3') sheetObjects[2].SelectCell(sheetObjects[2].HeaderRows, "qta");
	            else if(selIndex == 3 && srcName == 'type4') sheetObjects[3].SelectCell(sheetObjects[3].HeaderRows, "qta");
	        }
	    } else if(uiname == 'ESM_SPC_0024'){
	        if(srcName == 'ofcCheck'){
	            alarmMessage("search_OnKeyDownTab");
	            var selIndex = tabObjects[0].SelectedIndex;//선택된 Tab
	            if(selIndex == 1) sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows, "Fcast");
	        }
	        //
	    }	
	}
}

//ESM_SPC_0022, ESM_SPC_0028번화면의 하단Tab의 1번째 sheet에서 Tab키 누른 경우
//ESM_SPC_0024, ESM_SPC_0070번화면의 1번째 sheet에서 Tab키 누른 경우
function t1sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t1sheet1_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') document.form.year.focus();
	        else document.form.year1.focus();
	    }
	}
}

//ESM_SPC_0022번화면의 하단Tab의 2번째 sheet에서 Tab키 누른 경우
function t2sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t2sheet1_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        document.form.year1.focus();
	    }
	}
}

//ESM_SPC_0022번화면의 하단Tab의 3번째 sheet에서 Tab키 누른 경우
function t3sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t3sheet1_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        document.form.year1.focus();
	    }
	}
}

//ESM_SPC_0022번화면의 하단Tab의 4번째 sheet에서 Tab키 누른 경우
function t4sheet1_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t4sheet1_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        document.form.year1.focus();
	    }
	}
}

//ESM_SPC_0102, ESM_SPC_0028화면 sheet에서 Tab키 누르면 상단 검색조건으로 이동한다.
//ESM_SPC_0024, ESM_SPC_0070번화면의 2번째 sheet에서 Tab키 누른 경우
function t1sheet2_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		var uiname = document.form.uiname.value;
	    if(KeyCode == 9) {
	        alarmMessage("t1sheet2_OnKeyDown Tab");
	        if( uiname == 'ESM_SPC_0102' || uiname == 'ESM_SPC_0024'|| uiname == 'ESM_SPC_0070') document.form.year.focus();
	        else if(uiname == 'ESM_SPC_0028') document.form.year1.focus();
	    }
	}
}

//ESM_SPC_0028번화면의 하단Tab의 2번째 sheet에서 Tab키 누른 경우
//ESM_SPC_0024번화면의 3번째 sheet에서 Tab키 누른 경우
function t1sheet3_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t1sheet3_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0024') document.form.year.focus();
	        else document.form.year1.focus();
	    }
	}
}

//ESM_SPC_0024번화면의 4번째 sheet에서 Tab키 누른 경우
function t1sheet4_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t1sheet4_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        if(uiname == 'ESM_SPC_0024') document.form.year.focus();
	    }
	}
}

//ESM_SPC_0024번화면의 5번째 sheet에서 Tab키 누른 경우
function t1sheet5_OnKeyDown(sheetObj, Row,Col,KeyCode,Shift){
	if(document.form.uiname != undefined){
		if(KeyCode == 9) {
	        alarmMessage("t1sheet5_OnKeyDown Tab");
	        var uiname = document.form.uiname.value;
	        document.form.year.focus();
	    }
	}
}

//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
//sheet간 이동 1, 2, 3, 4, 5
/*
 * Sheet1
 */
function onShortKeyAlt1(){
    alarmMessage("press onShortKeyAlt1");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var obj = sheetObjects[0];
        if(uiname == 'ESM_SPC_0024'){
            tabObjects[0].SelectedIndex = 0; //Tab 1번째 Sheet활성화
            obj.SelectCell(obj.HeaderRows, "Fcast");        
        } else if(uiname == 'ESM_SPC_0070'){
            tabObjects[0].SelectedIndex = 0; //Tab 1번째 Sheet활성화
            obj.SelectCell(obj.HeaderRows, "vvd");        
        } else if(uiname == 'ESM_SPC_0045'||uiname == 'ESM_SPC_0058') {
            if(obj.RowCount>0) {
                tabObjects[0].SelectedIndex = 0; //첫번째 Tab 활성화
                var viewFirstRow = 0;
                for(var k=1; k<obj.RowCount; k++) {
                    if(!obj.RowHidden(k)) {
                      viewFirstRow = k;
                      break;
                    }
                }
                obj.focus();
                obj.SelectCell(viewFirstRow, "lod_cur_teu_qty"); //첫행에 Focus
            }
        } else if(  uiname == 'ESM_SPC_0102') {
            obj = sheetObjects[0];//두번째 Sheet(102번은 이렇게 되어 있음)
            obj.SelectCell(obj.HeaderRows, "fcast_ttl_qty");//sheet의 첫번째 row의 fcast물량에 Focus를 둔다
        } else {
            if(obj.RowCount>0){//조회된 데이터가 있는 경우
               obj.SelectCell(obj.HeaderRows, "VVD");//sheet의 첫번째 row의 vvd에 focus
            } //else {ComShowMessage(getMsg('COA10005', 'First Sheet'));}
        }
    }
}
/*
 * Sheet2
 */
function onShortKeyAlt2(){
    alarmMessage("onShortKeyAlt2");
    if(document.form.uiname != undefined){
    	var obj = sheetObjects[1];
        var uiname = document.form.uiname.value;
        
        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0028'|| uiname == 'ESM_SPC_0024' || uiname == 'ESM_SPC_0070') {
            //if(obj.RowCount>0){
                var selIdx = (uiname=='ESM_SPC_0024'||uiname=='ESM_SPC_0070')?1:0;
                tabObjects[0].SelectedIndex = selIdx; //Sheet활성화
                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows, "qta");
                else if(uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows, "proj_teu");
                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows, "Fcast");
                else if(uiname == 'ESM_SPC_0070') obj.SelectCell(obj.HeaderRows, "month");
            //}
        } else if(uiname == 'ESM_SPC_0045'||uiname == 'ESM_SPC_0058') {
            //setTimeout("dummy_fuction()", 100);
            //if(obj.RowCount>0) {
                tabObjects[0].SelectedIndex = 1; //첫번째 Tab 활성화
                var viewFirstRow = 0;
                for(var k=1; k<obj.RowCount; k++) {
                    if(!obj.RowHidden(k)) {
                      viewFirstRow = k;
                      break;
                    }
                }
                obj.focus();          
                obj.SelectCell(viewFirstRow, "lod_cur_teu_qty"); //첫행에 Focus
            //}
        } else {
            if(sheetCnt>1) {
                if(obj.RowCount>0){ //조회된 데이터가 있는 경우
                    obj.SelectCell(obj.HeaderRows, "asgn_ttl_qty");//sheet의 첫번째 row의 aloc에 focus
                }
            }
        }
    }
}

//ESM_SPC_0022,ESM_SPC_0028,ESM_SPC_0024
function onShortKeyAlt3(){
    alarmMessage("onShortKeyAlt3");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0028'||uiname == 'ESM_SPC_0024') {
            var obj = sheetObjects[2];
            //if(obj.RowCount>0){//데이터 없어도 탭은 이동되어야 하므로 조건 주석처리
                var selIdx = uiname == 'ESM_SPC_0024'?2:1;
                tabObjects[0].SelectedIndex = selIdx; //Sheet활성화
                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows, "qta");
                else if(uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows, "proj_teu");
                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows, "Fcast");
            //}
        }
    } 
}

//ESM_SPC_0022,ESM_SPC_0028,ESM_SPC_0024
function onShortKeyAlt4(){
    alarmMessage("onShortKeyAlt4");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0028'||uiname == 'ESM_SPC_0024') {
            var obj = sheetObjects[3];
            //if(obj.RowCount>0){//데이터 없어도 탭은 이동되어야 하므로 조건 주석처리
                var selIdx = uiname == 'ESM_SPC_0024'?3:2;
                tabObjects[0].SelectedIndex = selIdx; //Tab 3번째 Sheet활성화
                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows, "qta");
                else if(uiname == 'ESM_SPC_0028') obj.SelectCell(obj.HeaderRows, "proj_teu");
                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows, "Fcast");
            //}
        }
    } 
}

//ESM_SPC_0022,ESM_SPC_0024
function onShortKeyAlt5(){
    alarmMessage("onShortKeyAlt5");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        if(uiname == 'ESM_SPC_0022'||uiname == 'ESM_SPC_0024') {
            var obj = sheetObjects[4];
            //if(obj.RowCount>0){//데이터 없어도 탭은 이동되어야 하므로 조건 주석처리
                var selIdx = uiname == 'ESM_SPC_0024'?4:3;
                tabObjects[0].SelectedIndex = selIdx; //Tab 4번째 Sheet활성화
                if(uiname == 'ESM_SPC_0022') obj.SelectCell(obj.HeaderRows, "qta");
                else if(uiname == 'ESM_SPC_0024') obj.SelectCell(obj.HeaderRows, "Fcast");
            //}
        }
    }
}
//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
//,(<) .(>)키로 상단 하단 간 검색 조건 이동
/*
 * 단축키 기능 Alt+,: 첫번째 검색 조건 영역으로 이동
 */
function onShortKeyAltComma(){
    alarmMessage("press onShortKeyAltComma");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        if(uiname == 'ESM_SPC_0056') document.form.sDate.focus();
        else if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028' || uiname == 'ESM_SPC_0045'|| uiname == 'ESM_SPC_0058') {
            document.form.year1.focus();
        }
        else document.form.year.focus();
    }
}

/*
 * 단축키 기능 Alt+.: 두번째 검색 조건 영역으로 이동
 */
function onShortKeyAltPeriod(){
    alarmMessage("press onShortKeyAltPeriod");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        if(uiname == 'ESM_SPC_0045'||uiname == 'ESM_SPC_0058') {      
            if(tabObjects[0].SelectedIndex == 0) document.form.dataSelect[0].focus();
            else document.form.dataSelect1[0].focus();
        }
        else if(uiname == 'ESM_SPC_0056') document.form.chkTYP.focus();
        else if(uiname == 'ESM_SPC_0102') document.form.chkDs2LaneInfo.focus();
        else if(uiname == 'ESM_SPC_0022') {
            var selIndex = tabObjects[0].SelectedIndex;
            if(selIndex == 0) document.form.rhq_gso1[0].focus();
            else if(selIndex == 1) document.form.rhq_gso2[0].focus();
            else if(selIndex == 2) document.form.rhq_gso3[0].focus();
            else if(selIndex == 3) document.form.rhq_gso4[0].focus();
            else if(selIndex == 4) document.form.rhq_gso5[0].focus();
        } else if(uiname == 'ESM_SPC_0028') {
            var selIndex = tabObjects[0].SelectedIndex;
            if(selIndex == 0) document.form.chkPol.focus();
            else if(selIndex == 1) document.form.chkPolPodS[0].focus();
            else if(selIndex == 2) document.form.chkPolPodC[0].focus();
        } else if(uiname == 'ESM_SPC_0024') {
            var selIndex = tabObjects[0].SelectedIndex;
            if(selIndex == 1) document.form.ofcCheck.focus();
        } else document.form.chkOfc.focus();
    }
}
//---------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------
//방향키 위, 아래로 상단 하단 Toggle기능 구현
/*
 * 단축키 기능 Alt+방향키↑: Sheet1확대/축소
 */
function onShortKeyAltUp(){
    alarmMessage("onShortKeyAltUp");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var obj = sheetObjects[0];
        
        if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047'
           || uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028'|| uiname == 'ESM_SPC_0056'){
            //sheet1에 조회된 데이터가 존재하고, sheet1이 활성화 되어 있을때
            if(document.form.maxi[1].maxStatus != 'M') {//sheet2가 Toggle되지 않은 상태
                //처음에 포커스가 있었던 곳으로 Focus이동
                obj.SelectCell(obj.SelectRow, obj.SelectCol);
                document.form.maxi[0].focus();
                //click이벤트 발생
                document.form.maxi[0].click();
                //처음에 포커스가 있었던 곳으로 Focus이동
                obj.SelectCell(obj.SelectRow, obj.SelectCol);
            }
        } else {//ESM_SPC_0102의 경우 sheet가 하나임
            //처음에 포커스가 있었던 곳으로 Focus이동
            obj.SelectCell(obj.SelectRow, obj.SelectCol);
            document.form.maxi.focus();
            //click이벤트 발생
            document.form.maxi.click();
            //처음에 포커스가 있었던 곳으로 Focus이동
            obj.SelectCell(obj.SelectRow, obj.SelectCol);
        }
    }
}

/*
 * 단축키 기능 창축소:Alt+방향키↓: Sheet2확대/축소
 */
function onShortKeyAltDown(){
    alarmMessage("onShortKeyAltDown");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var obj = sheetObjects[1];
        var selIndex = 0; 
        //sheet2에 조회된 데이터가 존재하고, sheet2가 활성화 되어 있을때
        if(document.form.maxi[0].maxStatus != 'M') { //sheet1이 Toggle되지 않은 상태
            if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028'){
                selIndex = tabObjects[0].SelectedIndex;
                if(selIndex == 0) obj = sheetObjects[1];
                else if(selIndex == 1) obj = sheetObjects[2];
                else if(selIndex == 2) obj = sheetObjects[3];
                else if(selIndex == 3) obj = sheetObjects[4];
                else if(selIndex == 4) obj = sheetObjects[5];
            }

            //sheet2 포커스 이동
            obj.SelectCell(obj.SelectRow, obj.SelectCol);
            document.form.maxi[selIndex+1].focus();
            //click이벤트 발생
            document.form.maxi[selIndex+1].click();
            //처음에 포커스가 있었던 곳으로 Focus이동
            obj.SelectCell(obj.SelectRow, obj.SelectCol);
        }
    }
}
//---------------------------------------------------------------------------------------------


//---------------------------------------------------------------------------------------------
//버튼에 대한 단축키
/*
 * 단축키 기능 Alt+R :상단 sheet조회
 */
function onShortKeyAltR(){
    alarmMessage("press onShortKeyAltR");  
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var obj = sheetObjects[0];
        var rtn = null;
        
    	if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0047') {
    	    cancelControlOption(obj);
            enableButtons(false);
    	} else if(uiname == 'ESM_SPC_0044'){
    		enableButtons(false);
    	}
    	
    	rtn = doActionIBSheet(obj, document.form, IBSEARCH);
        
        if(obj.RowCount>0) {
            if( uiname == 'ESM_SPC_0102') obj.SelectCell(obj.HeaderRows + 2, "fcast_ttl_qty");
            else obj.SelectCell(obj.HeaderRows, "VVD");//첫번째 데이터 행을 Select함
        }
        return rtn;
    }
}

/*
 * 단축키 기능 Alt+N :검색조건 초기화
 */
function onShortKeyAltN(){
    alarmMessage("press onShortKeyAltN");
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        document.form.btn_new.click();
        if(uiname == 'ESM_SPC_0022' || uiname == 'ESM_SPC_0028' || uiname == 'ESM_SPC_0045'|| uiname == 'ESM_SPC_0058') document.form.year1.focus();
        else if(uiname == 'ESM_SPC_0056') document.form.sDate.focus();
        else {
        	//기존 New버튼기능에 focus추가함
        	document.form.year.focus();
        }
    }
}

/*
 * 단축키 기능 Alt+S: Save --Edit의 Save일경우와 일반 Save를 구분한다.
 */
function onShortKeyAltS(){
    alarmMessage("press onShortKeyAltS"); 
    if(document.form.uiname != undefined){
    	var uiname = document.form.uiname.value;
        var srcName = window.event.srcElement.getAttribute("name");
        
        //control option 저장
        if((uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0044' || uiname == 'ESM_SPC_0047') &&
            (srcName == 'chkPort' || srcName == 'chkHC' || srcName == 'chk45' || srcName == 'chk53' || srcName == 'chkRFR' || srcName == 'chkWGT')){
                document.form.btng_controlSave.click();
        } else {
            //document.form.btn_save.click();
            var sobj = null; 
            if(sheetCnt>1) sobj = sheetObjects[1];
            else if(sheetCnt == 1) sobj = sheetObjects[0];
            if(sobj != null) {
                //SelectCell을하면 OnSelectCell()을 호출하므로 강제 발생시켜준다.
                sobj.SelectCell(sobj.SelectRow, sobj.SelectCol);
                //buttonAction("btn_save");
                document.form.btn_save.click();
            }
        }
    }
}

/*
 * 단축키 기능 Alt+O: Confirm단축키.
 */
function onShortKeyAltO(){
    alarmMessage("press onShortKeyAltO"); 
    document.form.btn_confirm.click();
}

/*
 * 단축키 기능 Alt+I: Control Option이 활성화 되고 Combobox에 Focus
 */
function onShortKeyAltI(){
    alarmMessage("press onShortKeyAltI"); 
   //buttonAction("btng_controlEdit");
   document.form.btng_controlEdit.click();
   document.form.chkPort.focus();
}

function onShortKeyAltX(){
    alarmMessage("press onShortKeyAltX");
    //cancelControlOption(sheetObjects[0]);
    document.form.btng_controlCancel.click();
}

/*
 * 단축키 기능 Alt+B: Bottle Neck화면 팝업
 */
function onShortKeyAltB(){
    alarmMessage("press onShortKeyAltB"); 
    document.form.btng_bottleneck.click();
}

/*
 * 단축키 기능 Alt+K: VSL SKD 화면 팝업
 */
function onShortKeyAltK(){
    alarmMessage("press onShortKeyAltK"); 
    document.form.btng_skd.click();
}

/*
 * 단축키 기능 Alt+M: BSA Management 화면 팝업
 */
function onShortKeyAltM(){
    alarmMessage("press onShortKeyAltM"); 
    document.form.btng_bsa.click();
}
//---------------------------------------------------------------------------------------------

/*
 * 디코딩용 메시지
 */
function alarmMessage(msg){
    //ComShowMessage(msg);    
}
/*======================== 단축키 설정으로 인해 추가된 FUNCTION ========================*/

/**
* 오류 메세지 가져오기
* 
* @param msgNo 오류 번호
* @param msg1 출력 변수1
* @param msg2 출력 변수2
* @param msg3 출력 변수3
* @return 오류메세지
*/

function  getMsg(msgNo,msg1,msg2,msg3)
{
	var msgs = new Array();
	// SPC - Transaction
	msgs['SPC90001'] = 'There is modified data.\n\n Do you want to process?';  
	msgs['SPC90010'] = 'Do you want to save?';    
	msgs['SPC90020'] = 'Do you want to delete?';    
	msgs['SPC90030'] = 'Existing data will be deleted and saved.\n\n Do you want to save?';    
	
	// SPC - Validation     
	msgs['SPC90100'] = 'Trade (' + msg1 + ') code is invalid.';    
	msgs['SPC90101'] = 'Rep. Trade (' + msg1 + ') code is invalid.';    
	msgs['SPC90102'] = 'Sub Trade (' + msg1 + ') code is invalid.';   
	msgs['SPC90103'] = 'Rev. Lane (' + msg1 + ') code is invalid.';   
	msgs['SPC90104'] = 'Service Lane (' + msg1 + ') code is invalid.';   
	msgs['SPC90105'] = 'Bound (' + msg1 + ') code is invalid.';   
	msgs['SPC90106'] = 'Sales Office (' + msg1 + ') code is invalid.';   
	msgs['SPC90107'] = 'Contract Office (' + msg1 + ') code is invalid.';   
	msgs['SPC90108'] = 'Port (' + msg1 + ') code is invalid.';   
	msgs['SPC90109'] = msg1 + ' Port (' + msg2 + ') code is invalid.';   
	msgs['SPC90110'] = 'POL (' + msg1 + ') code is invalid.';   
	
	msgs['SPC90111'] = 'POD (' + msg1 + ') code is invalid.';   
	msgs['SPC90112'] = 'Retrieving period should be under ' + msg1 + ' weeks.'; 
	msgs['SPC90113'] = msg1 + ' long must be combination of English characters under ' + msg2 + ' digits and numbers ' + msg3 + 'digits.'; 
	msgs['SPC90114'] = msg1 + ' is mandatory item to retrieve.'; 
	msgs['SPC90115'] = msg1 + ' end condition must be later than start condition';
	msgs['SPC90116'] = 'Entered characters long of ' + msg1 + ' is short.';  
	msgs['SPC90117'] = 'Please enter ' + msg1 + '.';   
	msgs['SPC90118'] = 'Please enter numbers between 0 and 100.';        
	msgs['SPC90119'] = msg1 + ' must be greater than 0.';  
	msgs['SPC90120'] = msg1 + ' must be equal to or greater than ' + msg2 + '.'; 
	
	msgs['SPC90121'] = 'Please select or enter one item among ' + msg1 + ', ' + msg2 + ' and ' + msg3 + '.';
	msgs['SPC90122'] = 'Engine is running.\n\n Do you want to process?'; 
	msgs['SPC90123'] = 'If there is no data retrieved, can not add row.'; 
	msgs['SPC90124'] = 'Can add row after retrieve.'; 
	msgs['SPC90125'] = 'Retrieving period must be under 1 year.';     
	msgs['SPC90126'] = 'Modifying Control Option.\n\n It will be processed after complete the work.';
	msgs['SPC90127'] = 'Engine(Ver. No - ' + msg1 + ') execution has been completed ' + ((msg2=="S")?"successfully":"unsuccessfully") + '.'; 
	msgs['SPC90128'] = 'Allocation exceeds loadable space.'; 
	msgs['SPC90129'] = 'Allocation exceeds sub allocation.'; 
	
	msgs['SPC90130'] = 'Allocation exceeds loadable weight.'; 
	msgs['SPC90131'] = 'Allocation exceeds allocated volume.'; 
	msgs['SPC90132'] = 'Allocation exceeds allocated weight.'; 
	msgs['SPC90133'] = 'Lane list has been saved successfully.'; 
	msgs['SPC90134'] = 'The total ratio of Quota should be 100(%).'; 
	msgs['SPC90135'] = 'There is duplicated data.';
	msgs['SPC90136'] = 'The VVD (' + msg1 + ') does not call [KRPUS].\nPlease check it.';
	msgs['SPC90137'] = "1. Update FCST for your newly added/deleted account.\n2. After updating FCST, go to 'ACCT. ADD / DELETE' and 'save' to confirm newly added/deleted account.\n";
	msgs['SPC90138'] = 'There are some invalid data. Please check Customer code and SC no.';
	msgs['SPC90139'] = msg1 + ' is mandatory item to save.';
	msgs['SPC90140'] = msg2 + ' of ' + msg1 + ' should be equal to or less than ' + msg3 + '.';
	msgs['SPC90141'] = 'Please enter a valid date format for ( ' + msg1 + ' ) : YYYY-WW';
	msgs['SPC90142'] = 'There is no data to save.';
	msgs['SPC90143'] = "Mandatory field is missing. Please enter " + msg1 + " or " + msg2 + ".";
	msgs['SPC90144'] = "As there is no result retrieved, it's impossible to download in the [EXCEL] format.";
	msgs['SPC90145'] = 'Please check Customer code and RFA#.';
	msgs['SPC90146'] = 'Please click and check the cell to input Registration Option.';
	msgs['SPC90147'] = 'Please input Ratio.';
	msgs['SPC90148'] = 'Please input Code.';
	msgs['SPC90149'] = 'Saved successfully.';
	msgs['SPC90150'] = 'Allocation Confirm Success!';
	
	msgs['SPC90199'] = msg1 + ' code is invalid.';
	msgs['SPC90200'] = msg1 + ' condition is invalid.';

	msgs['SPC90202'] = 'Please check ' + msg1 + ' or ' + msg2 + '. (Yellow Cell)';
	msgs['SPC90203'] = 'Please check ' + msg1 + ', ' +  msg2 + ' or ' + msg3 + '. (Yellow Cell)';
	
	msgs['SPC10254'] = "Data Changed. Do you want to save it ?";
	msgs['SPC10535'] = "Are you sure to delete?";
	msgs['SPC10593'] = "Data Deleted Successfully";
	msgs['SPC10737'] = "Nothing Changed!!!";
	msgs['SPC10887'] = 'Mandatory field is missing. Please enter '+msg1;
	msgs['SPC11107'] = "Office Code is invalid.";
	msgs['SPC10145'] = "Please! Check your VVD.";
	msgs['SPC10163'] = "VVD is NOT Registered";
	msgs['SPC10993'] = msg1+" is not available.";
	msgs['SPC13055'] = "There is no data.";
	msgs['SPC13056'] = 'Please enter group name to save.';
	//	msgs['SPC13057'] = 'Duplication occurred.' + msg1;
	msgs['SPC13057'] = 'Please, input VVD!';
	msgs['SPC13058'] = 'Document is not selected.';
	msgs['SPC13059'] = 'Data Firm Successfully.';
	msgs['SPC13060'] = 'Job is starting.';
	
	msgs['SPC90301'] = 'Please check S/C No or RFA No ' + msg1;
	msgs['SPC90302'] = 'Do you want to Reprocess?';
	msgs['SPC90303'] = 'Job is starting.';
	msgs['SPC90304'] = 'Can not select a SMP Group' + msg1;
	msgs['SPC90305'] = 'Please enter at least 5 characters at' + msg1;
	msgs['SPC90306'] = 'Contract No (' + msg1 + ') is invalid.'; 
	msgs['SPC90307'] = 'BKG NO does not exist for retrival.'; 
	msgs['SPC90308'] = 'Reprocess is running with same condition.';
	msgs['SPC90309'] = 'Please select one Account.';
	msgs['SPC90310'] = 'For applying By Lane condition, please save [Booking Control Option] sheet.';
	msgs['SPC90311'] = "Your account has forecast data.\nIf you want to delete this account, delete forecast data.\n" + msg1;
	msgs['SPC90312'] = "In case of checking Sub Office, Office is mandatory item.\nPlease input Office.";
	msgs['SPC90313'] = "In case of Trade:IAS, Sales Office:SELSC,\nDuration can't be over 1Week.";
	msgs['SPC90314'] = "In case that Sales Rep checks over 50 accounts on Acct.Add/Del,\nDuration can't be over 1Week.";
	
	msgs['SPC90400'] = "Attached File is deleted due to storage server capacity."
	msgs['SPC90401'] = "No Selected Row."
	msgs['SPC90402'] = "Please select data to save."
	msgs['SPC90403'] = "Please select one port."
	msgs['SPC90404'] = "In case of Cancel Status, Remark is mandatory item."
	msgs['SPC90405'] = "Please input "+ msg1 + ".";
	msgs['SPC90406'] = "Please save first."
	msgs['SPC90407'] = "IRRE Case Duplicated."
	msgs['SPC90408'] = "Please retrieve TS plan first."
	msgs['SPC90409'] = "TS plan confirmed exists. Please cancel or delete that TS plan."

	if (msgs[msgNo.toUpperCase()])
		return msgs[msgNo.toUpperCase()];
	return "";
}

var txtTypeSize = new Array("|TEU", "|HC", "|45'", "|53'", "|Reefer", "|WT\n(M/T)");
var HeadTypeSize1 = new Array(0, 1, 2, 3, 4, 5);
var HeadTypeSize2 = new Array(0, 1, 2, 3, 4, 5);
var sizeColNameT = "";
if(sizeColName == undefined){
	sizeColNameT = new Array("_ttl_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt");
}
else{
	sizeColNameT = sizeColName;
}
var sizeColName = sizeColNameT;
var txtHeadVolume = "Volume";
var txtDelem = "|";
var sizeColType1 = new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger");
var sizeColType2 = new Array("dfFloat", "dfFloat", "dfFloat", "dfFloat", "dfFloat", "dfInteger");

var defaultWidth = 45;
var wideWidth = 90;
var cmbWidth = 50;

//시트의 해당 셀에 값을 기존 셀의 값에 더하여 설정한다.
function addCellValue(sheetObj, row, col, value, forceTrigger){
	if(forceTrigger == undefined){
		forceTrigger = true;
	}
	
	log("addCellValue : " + row + " - " + col + " - " + sheetObj.CellValue(row, col));
	var curValue = sheetObj.CellValue(row, col)*1;
	var newValue = curValue + value;
	if(newValue < 0){
		newValue = 0;
	}
	log("addCellValue : " + row + " - " + curValue + " - " + value + " - " + newValue + " - " + forceTrigger);
	if(forceTrigger){
		selectedCell_OldValue = curValue;
		sheetObj.CellValue(row, col) = newValue;
	}
	else{
		sheetObj.CellValue2(row, col) = newValue;
	}
}

function setInitValue(sheetObj, rows, cols, val){
	if(rows.constructor == String){
		rows = toArray(rows);
	}
	if(cols.constructor == String){
		cols = toArray(cols);
	}
	for(var r = 0 ; r < rows.length ; r++){
		for(var c = 0 ; c < cols.length ;c++){
			sheetObj.CellValue2(rows[r], cols[c]) = val;
		}
	}
}
function toArray(str){
	var arr = new Array();
	if(str.indexOf("..") >= 0){
		str = str.split("..");
		var s = str[0]*1;
		var e = str[1]*1;
		for(var i = s ; i <= e ; i++){
			arr[i - s] = i;
		}
	}
	else{
		arr = str.split("|");
	}
	return arr;
}

// 42 에서  삭제
//function copyData(sheetObj, sRow, eRow, frCols, toCols, trigger){
//	var fCols = frCols.split("|");
//	var tCols = toCols.split("|");
//	var cols = (fCols.length > tCols.length)?tCols.length:fCols.length;
//	if(trigger){
//    	for(var r = sRow ; r <= eRow ; r++){
//    		for(var c = 0 ; c < cols ; c++){
//    			sheetObj.CellValue(r, tCols[c]) = sheetObj.CellValue(r, fCols[c]);
//    		}
//    	}
//    }
//    else{
//    	for(var r = sRow ; r <= eRow ; r++){
//    		for(var c = 0 ; c < cols ; c++){
//    			sheetObj.CellValue2(r, tCols[c]) = sheetObj.CellValue(r, fCols[c]);
//    		}
//    	}
//    }
//}

function allocate(rowData, value, baseValue, isAdd){
	if(isAdd == undefined) isAdd = false;
	var size = rowData.length;
	var total = value;
	var unitValue = total / baseValue;
	
	for(var i = 0 ; i < size ; i++){
		var rVal = Math.round((unitValue * rowData[i][2]));
		
		if(total < rVal){
			rVal = total;
		}
		total = total - rVal;
		rowData[i][1] = (isAdd?rowData[i][1]:0) + rVal;
	}
	
	if(total > 0){
		if(total <= size){
			unitValue = total / baseValue;
			for(var j = 0 ; j < size ; j++){
				var rVal = Math.ceil((unitValue * rowData[j][2]));
				rowData[j][1] = rowData[j][1] + rVal;
				total = total - rVal;
				if(total <= 0){
					return;
				}
			}
		}
		else{
			allocate(rowData, total, baseValue, true);
		}
	}
}
function compareRowInfo(o1, o2){
	return o2[2] - o1[2];
}
var targetCellOrgValue = 0;
function setCellValues(sheetObj, rowData, col, trigger){
	var size = rowData.length;
	if(trigger){
		for(var i = 0 ; i < size ; i++){
			selectedCell_OldValue = rowData[i][3];
			sheetObj.CellValue(rowData[i][0], col) = rowData[i][1];
		}
	}
	else{
		for(var i = 0 ; i < size ; i++){
			sheetObj.CellValue2(rowData[i][0], col) = rowData[i][1];
		}
	}
}
function filterTree(sheetObj, col, value, flag, childCntCol){
	var row = 0;
	var childCnt = 0;
	row = sheetObj.FindText(col, value, row + 1);
	while(row > 0){
		sheetObj.RowHidden(row) = flag;
		if(sheetObj.RowExpanded(row)){
			childCnt = 0;
		}
		else{
			childCnt = sheetObj.CellValue(row, childCntCol)*1;
		}
		row = sheetObj.FindText(col, value, row + 1 + childCnt);
	}
}
function controlRowFilter(sheetObj){
	var formObj = document.form;
	var tstatus = formObj.chkOCN.checked || formObj.chkIPC.checked || formObj.chkTS.checked || formObj.chkEQ.checked|| formObj.chkDest.checked;
	if(!tstatus) return false;
	controlTree(sheetObj);
	controlIOC(sheetObj);
	return true;
}
/**
 * 화면의 POL/POD 선택 체크박스에 따라 데이터의 Visiable을 control한다.
 */
function controlTree(sheetObj){
	var formObj = document.form;
	var uiname = document.form.uiname.value;
//	var sts1 = formObj.chkOfc.checked;
	var sts2 = formObj.chkPol.checked;
	if(!sts2) formObj.chkPod.checked = false;
	var sts3 = formObj.chkPod.checked;
	var sts4 = formObj.chkDest.checked;
	
	// 이 두개의 경우 완전 분리 별도로 로직 check 박스 연동 없이 함
	// US mod : sts5  / Account : sts6
	var sts5 = formObj.chkIPI.checked;
	var sts6 = formObj.chkAccount.checked
	
	// checkbox로 다시 setting한다. 
	var sts5 = formObj.chkIPI_O.checked;
	var sts6 = formObj.chkAccount_O.checked

	if(sts4){
		formObj.chkPod.checked = true;
		formObj.chkPol.checked = true;
		sts3 = formObj.chkPod.checked;
		sts2 = formObj.chkPol.checked;
	}
	with(sheetObj){
		ShowTreeLevel(sts4?6:(sts3?5:(sts2?4:(sts6?3:(sts5?2:6)))));
		//ShowTreeLevel(sts4?6:(sts3?6:(sts2?4:(sts6?3:(sts5?2:6)))));
		//ShowTreeLevel(sts3?5:(sts2?5:(sts4?6:3)));
		// 우선 다 연후 조절
		ShowTreeLevel(6);

		if(sts5){
			ChangeValue(sheetObj, "lvl", "1", "us_mod", "1", " >= 0");
		}
		if(sts6){
			ChangeValue(sheetObj, "lvl", "2", "account_cd", "1", " >= 0");
			ChangeValue(sheetObj, "lvl", "2", "account_nm", "1", " >= 0");
		}
		if(sts2){
			ChangeValue(sheetObj, "lvl", "3", "pol_cd", "1", " >= 0");
		}
		if(sts3){
			ChangeValue(sheetObj, "lvl", "4", "pod_cd", "1", " >= 0");
		}
		if(sts4){
			ChangeValue(sheetObj, "lvl", "5", "del_cd", "1", " >= 0");
		}

		ShowRow(sheetObj, "lvl", 6);
		// 처음에 row를 모두 펼처둔 다음 하나씩 확인하여 닫음
		// checkbox상태 sts2:POL sts3:POD sts4:DEST sts5:IPI sts6:Account
		if(!sts4)HideRow(sheetObj, "lvl", 6);
		if(!sts3)HideRow(sheetObj, "lvl", 5);
		if(!sts2)HideRow(sheetObj, "lvl", 4);
		if(!sts6)HideRow(sheetObj, "lvl", 3);
		if(!sts5)HideRow(sheetObj, "lvl", 2);
//		//DEST가 check되면 DEST별 sum 보여줌 (control by Main Office는 제외)
		if(uiname == 'ESM_SPC_0042' || uiname == 'ESM_SPC_0047'){
			if(!sts4)HideRow(sheetObj, "rowDest", "true");
			if(sts4)ShowRow(sheetObj, "rowDest", "true");
		}

		ColHidden("pol_cd") = !sts2&&!sts3;
		ColHidden("pod_cd") = !sts3;
		ColHidden("del_cd") = !sts4||!sts3;
		//ColHidden("account_cd") = !sts6;
		ColHidden("account_nm") = !sts6;
		ColHidden("us_mod") = !sts5;
	}
	return true;
}

function controlIOC(sheetObj){
	var formObj = document.form;
	var stsOCN = formObj.chkOCN.checked;
	var stsIPC = formObj.chkIPC.checked;
	var stsTS = formObj.chkTS.checked;
	var stsMT = formObj.chkEQ.checked;
	if(!stsOCN){
		filterTree(sheetObj, "ioc_cd", "OCN", !stsOCN, "child_cnt");
	}
	else{
		sheetObj.RowHidden(totalRows["OCN"]) = false;
	}
	if(!stsIPC){
		filterTree(sheetObj, "ioc_cd", "IPC", !stsIPC, "child_cnt");
	}
	else{
		sheetObj.RowHidden(totalRows["IPC"]) = false;
	}
	if(!stsTS){
		filterTree(sheetObj, "ioc_cd", "T/S", !stsTS, "child_cnt");
	}
	else{
		sheetObj.RowHidden(totalRows["T/S"]) = false;
	}
	if(!stsMT){
		filterTree(sheetObj, "ioc_cd", "EQ", !stsMT, "child_cnt");
	}
	else{
		sheetObj.RowHidden(totalRows["EQ"]) = false;
	}
	return true;
}

/**
 * col 컬럼의 값이 val과 일치한 행을 보이도록 한다.
 */
function ShowRow(sheetObj, col, val){
	with(sheetObj){
		var frow = -1;
		
		while((frow = FindText(col, val, frow + 1)) >= 0){
			RowHidden(frow) = false;
		}
	}
}
/**
 * col 컬럼의 값이 val과 일치한 행을 Hidden 시킨다.
 */
function HideRow(sheetObj, col, val){
	with(sheetObj){
		var frow = -1;
		
		while((frow = FindText(col, val, frow + 1)) >= 0){
			RowHidden(frow) = true;
		}
	}
}

/**
 * col 컬럼의 값이 val과 일치한 행의 sCol컬럼의 값을 sVal로 변경한다.
 * sCol컬럼의 값이 cond 조건을 만족하는 경우에만 값을 변경
 */
function ChangeValue(sheetObj, col, val, sCol, sVal, cond){
	 with(sheetObj){
		var frow = -1;
		while((frow = FindText(col, val, frow + 1)) >= 0){
			if(eval("CellValue(frow, sCol)" + cond)){
				var status = sheetObj.RowStatus(frow);
				CellValue2(frow, sCol) = sVal;
				sheetObj.RowStatus(frow) = status;
			}
		}
	}
}

function changeSelection(){
	if(editingControlOption){
		ComShowMessage(getMsg("SPC90126"));
		return false;
	}
	var obj = event.srcElement;
	return changeSelectionEx(obj.name);
}
function changeSelectionEx(obj_name){
	var sheetObj = sheetObjects[1];
	switch(obj_name){
		case "chkOfc":
		case "chkPol":
		case "chkPod":
		case "chkDest":
		case "chkIPI":
		case "chkAccount":
		case "chkIPI_O":
		case "chkAccount_O":
		case "chkTS":
			hiddenMasterCols(sheetObjects[0], document.form);
		case "chkEQ":
			if(!controlRowFilter(sheetObj)) return false;
			break;
		case "chkOCN":
		case "chkIPC":
			if(!controlRowFilter(sheetObj)) return false;
		case "chkWT":
			hiddenMasterCols(sheetObjects[0], document.form);
		case "chkTYP":
		case "chkTYP_BKG":
		case "chkTYP_ALL":
		case "chkUSG":
		case "chkMDL":
		case "chkBKGF":
		case "chkCUS":
		case "chkTREND":
		case "chkWKCMB":
		case "chkCNTRMOVE":	   //op,oc,vl 추가
			hiddenSelectionField(sheetObj);
			break;
	}
	return true;
}

function allocateByOffice(sheetObj, row, pre, sizeName, base, value, orgValue){
	with(sheetObj){
		//RowStatus(row) = "I";
		var rowsData = new Array();
		//새로 입력된 값이 0일때 
		if(value == 0){
			var size = CellValue(row, "pol_cnt")*1;
			// pol count만큼  level 4 찾아서 0으로 바꾼다
			var r = row + 1;
			//r = next_row + 1;
    		for(var i = 0 ; i < size ; i++){
    			var next_row = sheetObj.FindText("lvl", "4", r );
//    			selectedCell_OldValue = CellValue(r, pre + sizeName);
//    			CellValue(r, pre + sizeName) = 0;
//    			var c = CellValue(r, "child_cnt")*1;
//    			r = r + c + 1;

				CellValue(next_row, pre + sizeName) = 0;
				// pod count만큼 돌면서 pod를 변경해준다
				r = next_row + 1;
    		}
		}
		else{
			
			var r = row + 1;
			var baseValue = 0;
			var size = CellValue(row, "pol_cnt")*1;
			
			if(orgValue == 0){
	    		for(var i = 0 ; i < size ; i++){
//	    			var c = CellValue(r, "child_cnt")*1;
//	    			var v = CellValue(r, pre + sizeName)*100;
//	    			rowsData[i] = new Array(r, 0, c, v);
//	    			r = r + c + 1;
	    			var next_row = sheetObj.FindText("lvl", "4", r ); // r부터 다음 레벨 4를 찾는다.
	    			var c = CellValue(r, "child_cnt")*1;
	    			var v = CellValue(next_row, pre + sizeName)*100;
	    			rowsData[i] = new Array(next_row, 0, c, v);
	    			r = next_row + 1;
	    		}
				var leaf = CellValue(row, "leaf_cnt")*1;
	    		baseValue = leaf;
    		}
    		else{
    			// 0이 아닌 값에서 0이 아닌 값으로 변할 때
	    		for(var i = 0 ; i < size ; i++){
	    			// orinal 로직 DEL추가에 따른 변경작업
//	    			var c = CellValue(r, "child_cnt")*1;
//	    			var t = CellValue(r, base + sizeName)*10;
//	    			var v = CellValue(r, pre + sizeName)*100;
//	    			rowsData[i] = new Array(r, 0, t, v);
//	    			r = r + c + 1;
	    			var next_row = sheetObj.FindText("lvl", "4", r ); // r부터 다음 레벨 4를 찾는다.
	    			var c = CellValue(r, "child_cnt")*1;
	    			var t = CellValue(next_row, base + sizeName)*10;
	    			var v = CellValue(next_row, pre + sizeName)*100;
	    			rowsData[i] = new Array(next_row, 0, t, v);
	    			r = next_row + 1;
	    		}
	    		baseValue = orgValue* 10;
    		}
			rowsData.sort(compareRowInfo);
			allocate(rowsData, value, baseValue);
    		for(var i = 0 ; i < rowsData.length ; i++){
    			rowsData[i][3] = rowsData[i][3] / 100;
    		}
			setCellValues(sheetObj, rowsData, pre + sizeName, true);
		}
	}
	
}

function allocateByPol(sheetObj, row, pre, sizeName, base, value, orgValue){
	with(sheetObj){
		//RowStatus(row) = "R";
		var childs = CellValue(row, "child_cnt")*1;
//		alert(childs);
		var rowsData = new Array();
		if(value == 0){
			var r = row + 1;
			for(var i = 1 ; i <= childs ; i++){
				//selectedCell_OldValue = CellValue(row + r, pre + sizeName);
				var next_row = sheetObj.FindText("lvl", "5", r );

    			
				CellValue(next_row, pre + sizeName) = 0;
				// pod count만큼 돌면서 pod를 변경해준다
				r = next_row + 1;
			}
		}
		else{
			var r = row + 1;
			var baseValue = 0;
			
			if(orgValue == 0){
	    		for(var i = 0 ; i < childs ; i++){
	    			//alert(" rooping i " + i);
	    			//var cur_6level_row = sheetObj.CellValue(r, "lvl");
	    			var next_row = sheetObj.FindText("lvl", "5", r ); // r부터 다음 레벨 5를 찾는다. 
	    			// 다음 6 level은 next_row
	    			var v = CellValue(next_row, pre + sizeName)*100;
	    			rowsData[i] = new Array(next_row, 0, 1, v);
	    			r = next_row + 1;
	    			//rowData[i][0] 이 컬럼 row 
	    		}
	    		baseValue = childs;
    		}
    		else{
	    		for(var i = 0 ; i < childs ; i++){
	    			var next_row = sheetObj.FindText("lvl", "5", r ); // r부터 다음 레벨 5를 찾는다.
	    			var t = CellValue(next_row, base + sizeName)*10;
	    			var v = CellValue(next_row, pre + sizeName)*100;
	    			rowsData[i] = new Array(next_row, 0, t, v);
	    			r = next_row + 1;
	    		}
	    		baseValue = orgValue*10;
    		}
			
			rowsData.sort(compareRowInfo);
			allocate(rowsData, value, baseValue);
    		for(var i = 0 ; i < rowsData.length ; i++){
    			rowsData[i][3] = rowsData[i][3] / 100;
    		}
			setCellValues(sheetObj, rowsData, pre + sizeName,  true);
		}
	}
}


function allocateByPod(sheetObj, row, pre, sizeName, base, value, orgValue){
	with(sheetObj){
		//RowStatus(row) = "R";
		var childs = CellValue(row, "child_cnt")*1;
		//POD에 의해서 변경이 되므로 아래 2개만 숫자 변경하면 됨
		var rowsData = new Array();
		//alert("value " + value +"orgValue " + orgValue);
		var difValue = value - orgValue;
		var next_row = sheetObj.FindText("lvl", "1", row );
//		childs = next_row - row - 1;
//		alert("childs " + childs);
		// 값에 0을 입력 했을 때
		// 하단에 child 모두 0 으로 
		if(value == 0){
			for(var r = 1 ; r <= childs ; r++){
				selectedCell_OldValue = CellValue(row + r, pre + sizeName);
				CellValue(row + r, pre + sizeName) = 0;
				row = row + 1;
			}
		}
		else{
			var r = row + 1;
			var baseValue = 0;
			
			if(orgValue == 0){
				//alert("difValue" + difValue);
				addCellValue(sheetObj, r, pre + sizeName, difValue, true);
	    		//sheetObj.CellValue(r, pre + sizeName) = value + orgValue;
				//setCellValues(sheetObj, rowsData, pre + sizeName,  true);
    		}
    		else{

		    //alert("difValue" + difValue);
    		// 0에서 다른 값을 변할때 POD에 의한 DEL값 변경 
    		// DEL이 없는 경우 무조건 하나 아래에 값 setting
    			addCellValue(sheetObj, r, pre + sizeName, difValue, true);
    	    	sheetObj.CellValue(r, pre + sizeName) = value;
    		}
//			rowsData.sort(compareRowInfo);
//			allocate(rowsData, value, baseValue);
//    		for(var i = 0 ; i < rowsData.length ; i++){
//    			rowsData[i][3] = rowsData[i][3] / 100;
//    		}
			setCellValues(sheetObj, rowsData, pre + sizeName,  true);
		}
	}
}



function checkControlOption(){
	var formObj = document.form;
	getControlOption();
	formObj.chkWT.checked = formObj.chkWGT.checked;
	formObj.chkTYP.checked = formObj.chkHC.checked || formObj.chk45.checked || formObj.chk53.checked || formObj.chkRFR.checked
	||formObj.chkD2.checked||formObj.chkD4.checked||formObj.chkDFR.checked;
	
	formObj.chkOfc.checked = true;
	formObj.chkPol.checked = formObj.chkPort.value == "L" || formObj.chkPort.value == "D";
	formObj.chkPod.checked = formObj.chkPort.value == "D";
	formObj.chkDest.checked = formObj.chkPort.value == "T";
	if(!isDevMode){
		//divChkPOD.style.display = (formObj.chkPort.value != "D")?"none":"";
	} 
}

var totalRows = new Array();
var totalIOC = new Array();
var iocCnt = 0;
var Flags = new Array("OCN", "IPC", "T/S", "T-OCN", "T-IPC", "T-T/S");
// IOC구분별 Total 행을 지정하고
// Data Selection의 IOC 구분별 check box를 선택 체크 하고
// 검색되지 않은 항목에 대한 체크박스를 보이지 않게 한다
function checkSelectionOption(sheetObj, acctFlg){
	totalIOC = new Array();
	iocCnt = 0;
	totalRows = new Array();
	var formObj = document.form;
	var checkedCount
	var frow = -1;
	var row = sheetObj.FindText("ioc_cd", "OCN");
	var rowCnt = sheetObj.RowCount + (acctFlg=="Y"?5:3);
	
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["OCN"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "OCN";
			iocCnt = iocCnt + 10;
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkOCN.style.display = (row >= 0)?"":"none";
	row = sheetObj.FindText("ioc_cd", "IPC");
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["IPC"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "IPC";
			iocCnt = iocCnt + 1;
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkIPC.style.display = (row >= 0)?"":"none";
	row = sheetObj.FindText("ioc_cd", "T/S");
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["T/S"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "T/S";
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkTS.style.display = (row >= 0)?"":"none";
	row = sheetObj.FindText("ioc_cd", "EQ");
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["EQ"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "EQ";
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkMT.style.display = (row >= 0)?"":"none";
	row = sheetObj.FindText("ioc_cd", "T-OCN");
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["T-OCN"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "T-OCN";
			iocCnt = iocCnt + 10;
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkOCN.style.display = (row >= 0 || divChkOCN.style.display=="")?"":"none";
	row = sheetObj.FindText("ioc_cd", "T-IPC");
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["T-IPC"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "T-IPC";
			iocCnt = iocCnt + 1;
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkIPC.style.display = (row >= 0 || divChkIPC.style.display=="")?"":"none";
	row = sheetObj.FindText("ioc_cd", "T-T/S");
	if(row >= 0){
		frow  = sheetObj.FindText("rowIoc", "true", row + 1);
		if(frow > 0){
			totalRows["T-T/S"] = frow;
			setTotalRowColor(sheetObj, frow);
			totalIOC[totalIOC.length] = "T-T/S";
			
			if(acctFlg == "Y") checkAcctTotal(sheetObj, acctFlg, frow);
		}
	}
	divChkTS.style.display = (row >= 0 || divChkTS.style.display=="")?"":"none";
	var checkedCount = 0;
	checkedCount += (divChkOCN.style.display=="")?1:0;
	checkedCount += (divChkIPC.style.display=="")?1:0;
	checkedCount += (divChkTS.style.display=="")?1:0;
	checkedCount += (divChkMT.style.display=="")?1:0;
	formObj.chkOCN.checked = divChkOCN.style.display=="";
	formObj.chkIPC.checked = divChkIPC.style.display=="";
	formObj.chkTS.checked = divChkTS.style.display=="";
	formObj.chkEQ.checked = divChkMT.style.display=="";
	if(checkedCount == 1){
		divChkOCN.style.display="none";
		divChkIPC.style.display="none";
		divChkTS.style.display="none";
		divChkMT.style.display="none";
	}
}

// SMP 이면서  A, B, C 의 TTL Row 에 대한 Color 처리
function checkAcctTotal(sheetObj, acctFlg, row){
	var frow = row;
	var erow = "";
	erow = sheetObj.FindText("rowIoc", "false", row + 1);
	
//	var acctLvlA = "false";
//	var acctLvlB = "false";
//	var acctLvlC = "false";
//	var rowCnt = sheetObj.RowCount + (acctFlg=="Y"?5:3);
	
//	if(rowCnt > frow+1) acctLvlA = sheetObj.CellValue(frow + 1, "rowIoc");
//	if(rowCnt > frow+2) acctLvlB = sheetObj.CellValue(frow + 2, "rowIoc");
//	if(rowCnt > frow+3) acctLvlC = sheetObj.CellValue(frow + 3, "rowIoc");
//	
//	if(acctLvlA == "true") setTotalRowColor(sheetObj, frow + 1);
//	if(acctLvlB == "true") setTotalRowColor(sheetObj, frow + 2);
//	if(acctLvlC == "true") setTotalRowColor(sheetObj, frow + 3);

	for(var i=frow; i < erow; i++){
		setTotalRowColor(sheetObj, i);
	}
}

//var weightCols = new Array();
//var ocnCols = new Array();
//var ipcCols = new Array();
//var controlWeightCols = new Array();
//var controlSizeHCCols = new Array();
//var controlSize45Cols = new Array();
//var controlSizeRFCols = new Array();
//// trade 종류에 따라 상단 sheet의 OCN/IPC 선택 display
//function hiddenMasterCols(sheetObj, formObj, trade){
////	if(trade != undefined){
////		if(trade == "I"){
////			formObj.chkOCN.checked = false;
////		}
////		else if(trade != "INIT"){
////			formObj.chkIPC.checked = false;
////		}
////	}
//// alert(
////' weightCols=' + weightCols.length
////+ '<\n> ocnCols=' + ocnCols.length
////+ '<\n> ipcCols=' + ipcCols.length
////+ '<\n> controlWeightCols=' + controlWeightCols.length
////+ '<\n> controlSizeHCCols=' + controlSizeHCCo ls.length
////+ '<\n> controlSize45Cols=' + controlSize45Cols.length
////+ '<\n> controlSizeRFCols=' + controlSizeRFCols.length
////+ '<\n> chkWT=' + formObj.chkWT.checked
////+ '<\n> chkOCN=' + formObj.chkOCN.checked
////+ '<\n> chkIPC=' + formObj.chkIPC.checked
////+ '<\n> chkOCN=' + formObj.chkOCN.checked
////+ '<\n> chkWGT=' + formObj.chkWGT.checked
////+ '<\n> chkHC=' + formObj.chkHC.checked
////+ '<\n> chk45=' + formObj.chk45.checked
////+ '<\n> chkRFR=' + formObj.chkRFR.checked
////);
//	
//	var checked = formObj.chkWT.checked || trade == "INIT";
//	for(var i = 0 ; checked && i < weightCols.length ; i++){
//		sheetObj.ColHidden(weightCols[i]) = !checked;
//	}
//	checked = formObj.chkOCN.checked || trade == "INIT";
//	for(var i = 0 ; i < ocnCols.length ; i++){
//		sheetObj.ColHidden(ocnCols[i]) = !checked;
//	}
//	checked = formObj.chkIPC.checked || trade == "INIT";
//	for(var i = 0 ; i < ipcCols.length ; i++){
//		sheetObj.ColHidden(ipcCols[i]) = !checked;
//	}
//	checked = formObj.chkWT.checked || trade == "INIT";
//	for(var i = 0 ; !checked && i < weightCols.length ; i++){
//		sheetObj.ColHidden(weightCols[i]) = !checked;
//	}
//	
//	checked = formObj.chkWGT.checked || trade == "INIT";
//	for(var i = 0 ; i < controlWeightCols.length ; i++){
//		sheetObj.ColHidden(controlWeightCols[i]) = !checked;
//	}
//	checked = formObj.chkHC.checked || trade == "INIT";
//	for(var i = 0 ; i < controlSizeHCCols.length ; i++){
//		sheetObj.ColHidden(controlSizeHCCols[i]) = !checked;
//	}
//	checked = formObj.chk45.checked || trade == "INIT";
//	for(var i = 0 ; i < controlSize45Cols.length ; i++){
//		sheetObj.ColHidden(controlSize45Cols[i]) = !checked;
//	}
//	checked = formObj.chkRFR.checked || trade == "INIT";
//	for(var i = 0 ; i < controlSizeRFCols.length ; i++){
//		sheetObj.ColHidden(controlSizeRFCols[i]) = !checked;
//	}
//}


var totalRowColor = getColor(0);
function setTotalRowColor(sheetObj, row){
	sheetObj.RowBackColor(row) = totalRowColor;
}
// control option에 따라 syncTarget에 대한 항목의 Type/Size별 컬럼 display 설정 
function hiddenSelectionField(sheetObj){
	var formObj = document.form;
	var chCOItemHC    = formObj.chkHC.checked;
	var chCOItem45    = formObj.chk45.checked;
	var chCOItem53    = formObj.chk53.checked;
	var chCOItemRFR   = formObj.chkRFR.checked;
	var chCOItemWGT   = formObj.chkWGT.checked;
	var chDSItemWT    = formObj.chkWT.checked;
	var chDSItemTYP   = formObj.chkTYP.checked;
	var chCOItemD2    = formObj.chkD2.checked;
	var chCOItemD4    = formObj.chkD4.checked;
	var chCSItemDFR   = formObj.chkDFR.checked;
	var chDSItemTYPBKG;
	if( formObj.chkTYP_BKG != null ){
		chDSItemTYPBKG = formObj.chkTYP_BKG.checked; //2015.03.18 TP/SZ(BKG) 추가 BKG의 TP/SZ 만 보임
	}
	var chDSItemTYPALL = formObj.chkTYP_ALL.checked; //Forecast, BKG 의 TP/SZ 보임
	var isCmb = false;
	//chDSItemTYPALL 가 checked면 chDSItemTYPBKG는 unchecked 로 변경시킴.
	if( chDSItemTYPALL ) {
		chDSItemTYPBKG = false;
		if( formObj.chkTYP_BKG != undefined )
			formObj.chkTYP_BKG.checked=false;
	}
	if( chDSItemTYPBKG ) {
		chDSItemTYPALL = false;
		if( formObj.chkTYP_BKG != undefined )
			formObj.chkTYP_ALL.checked=false;
	}

	for(var c = 0 ; c < controlCols.length ; c++){
		var pre = preColName[c];
		var colNames = sizeColName[colSizeIdx[c]];
		if(controlCols[c]){
//			alert(colNames + syncTarget[c]);
			// 2010.02.24 아래 eval 함수가 제대로 작동하지 않아 switch 문으로 변경
			// var itemChecked = (dataSelectionItemName[c]=="")?true:eval("formObj."+dataSelectionItemName[c]+".checked");
			var checked = false;
			switch(dataSelectionItemName[c]) {
			    case "chkUSG":
			    	checked = formObj.chkUSG.checked;
			    	break;
			    case "chkMDL":
			    	checked = formObj.chkMDL.checked;
			    	break;
			    case "chkBKGF":
			    	checked = formObj.chkBKGF.checked;
			    	break;
			    case "chkCUS":
			    	checked = formObj.chkCUS.checked;
			    	break;
			    default:
			    	checked = false;
			}
			
			var itemChecked = (dataSelectionItemName[c]=="")?true:checked;
			//control option sync 대상이면
			if(syncTarget[c]){
				switch(colSizeIdx[c]){
					case 0:
						sheetObj.ColHidden(pre + colNames[0]) = !itemChecked;
						sheetObj.ColHidden(pre + colNames[1]) = !(chCOItemD2  && chDSItemTYP && itemChecked);
						sheetObj.ColHidden(pre + colNames[2]) = !(chCOItemD4  && chDSItemTYP && itemChecked);
						sheetObj.ColHidden(pre + colNames[3]) = !(chCOItemHC  && chDSItemTYP && itemChecked);
						sheetObj.ColHidden(pre + colNames[4]) = !(chCOItem45  && chDSItemTYP && itemChecked);
						sheetObj.ColHidden(pre + colNames[5]) = !(chCOItem53  && chDSItemTYP && itemChecked);
						sheetObj.ColHidden(pre + colNames[6]) = !(chCOItemRFR && chDSItemTYP && itemChecked);
						sheetObj.ColHidden(pre + colNames[7]) = !(chCSItemDFR && chDSItemTYP && itemChecked);
						//sheetObj.ColHidden(pre + colNames[8]) = !(chCOItemWGT && chDSItemWT  && itemChecked);
						sheetObj.ColHidden(pre + colNames[8]) = !chCOItemWGT && !chDSItemWT;
						break;
						
					case 1: // booking type size 컬럼 감추기
						
						sheetObj.ColHidden(pre + colNames[0]) = !chDSItemTYPALL && !itemChecked;
						//sheetObj.ColHidden(pre + colNames[1]) = true;
						// 2014.08.23 신혜성 부장님 요청에 따라 hidden 처리
						//sheetObj.ColHidden(pre + colNames[1]) = !chDSItemTYPALL && !(chCOItemD2  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[1]) = !chDSItemTYPALL;
						sheetObj.ColHidden(pre + colNames[2]) = !chDSItemTYPALL && !(chCOItemD2  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[3]) = !chDSItemTYPALL;
						//sheetObj.ColHidden(pre + colNames[3]) = true;
						sheetObj.ColHidden(pre + colNames[4]) = !chDSItemTYPALL && !(chCOItemD4  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[5]) = !chDSItemTYPALL && !(chCOItemHC  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[6]) = !chDSItemTYPALL && !(chCOItem45  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[7]) = !chDSItemTYPALL && !(chCOItem53  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[8]) = !chDSItemTYPALL && !(chCOItemRFR && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[9]) = !chDSItemTYPALL && !(chCSItemDFR && chDSItemTYP);
						//sheetObj.ColHidden(pre + colNames[10]) = !chDSItemTYPALL && !(chCOItemWGT && chDSItemWT);
						sheetObj.ColHidden(pre + colNames[10]) = !chCOItemWGT && !chDSItemWT;
						break;
					case 2: // forecast type size 컬럼 감추기
						if( chDSItemTYPBKG ) // 참인 경우 BKG만 보여주기 위해서 forecast는 동작하지 않게 함.
							chDSItemTYPALL = false;
						
						sheetObj.ColHidden(pre + colNames[0]) = !chDSItemTYPALL && !itemChecked;
						//sheetObj.ColHidden(pre + colNames[1]) = !chDSItemTYPALL && !(chDSItemTYP && itemChecked);
						// 2014.08.19 TTL TEU와의 혼재로 인해 teu 숨김처리
						sheetObj.ColHidden(pre + colNames[1]) = true;
						sheetObj.ColHidden(pre + colNames[2]) = !chDSItemTYPALL && !(chCOItemD2  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[3]) = !chDSItemTYPALL && !(chCOItemD4  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[4]) = !chDSItemTYPALL && !(chCOItemHC  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[5]) = !chDSItemTYPALL && !(chCOItem45  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[6]) = !chDSItemTYPALL && !(chCOItem53  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[7]) = !chDSItemTYPALL && !(chCOItemRFR && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[8]) = !chDSItemTYPALL && !(chCSItemDFR && chDSItemTYP);
						//sheetObj.ColHidden(pre + colNames[9]) = !chDSItemTYPALL && !(chCOItemWGT && chDSItemWT);
						sheetObj.ColHidden(pre + colNames[9]) = !chCOItemWGT && !chDSItemWT;
						
						if( chDSItemTYPBKG )// 참인 경우 BKG만 보여주기 위해서 forecast는 동작하지 않게 한것 원복 시킴
							chDSItemTYPALL = true;
						break;
					case 6: // forecast type size 컬럼 감추기
						sheetObj.ColHidden(pre + colNames[0]) = !chDSItemTYPALL && !itemChecked;
						// sheetObj.ColHidden(pre + colNames[1]) = !chDSItemTYPALL && !(chDSItemTYP && itemChecked);
						// 2014.08.19 TTL TEU와의 혼재로 인해 teu 숨김처리
						sheetObj.ColHidden(pre + colNames[1]) = true;
						sheetObj.ColHidden(pre + colNames[2]) = !chDSItemTYPALL && !(chCOItemD2  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[3]) = !chDSItemTYPALL && !(chCOItemD4  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[4]) = !chDSItemTYPALL && !(chCOItemHC  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[5]) = !chDSItemTYPALL && !(chCOItem45  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[6]) = !chDSItemTYPALL && !(chCOItem53  && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[7]) = !chDSItemTYPALL && !(chCOItemRFR && chDSItemTYP);
						sheetObj.ColHidden(pre + colNames[8]) = !chDSItemTYPALL && !(chCSItemDFR && chDSItemTYP);
						//sheetObj.ColHidden(pre + colNames[9]) = !chDSItemTYPALL && !(chCOItemWGT && chDSItemWT);
						sheetObj.ColHidden(pre + colNames[9]) = !chCOItemWGT && !chDSItemWT;
						break;
					case 7: // vgm
						sheetObj.ColHidden(pre + colNames[1]) = !chCOItemWGT && !chDSItemWT;
						break;
					case 8: // standby 
						sheetObj.ColHidden(pre + colNames[1]) = !chCOItemWGT && !chDSItemWT;						
						break;	
				}
				if(itemChecked){
					// Tp/Sz가 보이지 않으면 컬럼의 크기를 wide로 보이도록 하기위한 width 설정
					var w = (!chDSItemTYP || !(chCOItemHC || chCOItem45 || chCOItem53 || chCOItemRFR))?wideWidth:defaultWidth;
					sheetObj.ColWidth(pre+ colNames[0]) = w;
					sheetObj.ColWidth(pre+ colNames[colNames.length - 1]) = w;
				}
			}
			//control option sync 대상이 아니면
			else{
				sheetObj.ColHidden(pre + colNames[0]) = !itemChecked;
				for(var i = 1 ; i < colNames.length - 1 ; i++){
					sheetObj.ColHidden(pre + colNames[i]) = !(chDSItemTYP && itemChecked);
				}
				sheetObj.ColHidden(pre + colNames[colNames.length - 1]) = !(chDSItemWT && itemChecked);
				if(itemChecked){
					// DataSelection에 View by Tp/Sz가 선택되지 않으면 컬럼의 크기를 wide로 보이도록 하기위한 width 설정
					var w = chDSItemTYP?defaultWidth:wideWidth;
					sheetObj.ColWidth(pre+ colNames[0]) = w;
					sheetObj.ColWidth(pre+ colNames[colNames.length - 1]) = w;
				}
			}
		} else {
			if(pre == "cmb"){
				var chDSItemWKCMB = formObj.chkWKCMB.checked;
				isCmb = true;
				
				for(var j=0; j<8; j++){
					// 1~4번째:TEU는 Weekly CMB 체크여부에 따라 5~8번째 WGT는 Weekly CMB && Weight 체크에 따라 바퀴도록 수정.
					sheetObj.ColHidden(pre + colNames[j]) = (j%8) < 4 ? !chDSItemWKCMB: !(chDSItemWKCMB && chDSItemWT);
					sheetObj.ColWidth (pre + colNames[j]) = cmbWidth;					
				}
			}else if(pre == "cm"){
				var chkMvmt = formObj.chkCNTRMOVE.checked;
				
				sheetObj.ColHidden(pre + colNames[0]) = !chkMvmt;
				sheetObj.ColHidden(pre + colNames[1]) = !chkMvmt;
				sheetObj.ColHidden(pre + colNames[2]) = !chkMvmt;
			}else if(pre == "trend"){
				var chDSItemTrend = formObj.chkTREND.checked;
				
				sheetObj.ColHidden(pre + colNames[0]) = !chDSItemTrend;
				sheetObj.ColHidden(pre + colNames[1]) = !chDSItemTrend;
			}
		}
	}
	if (isCmb != true){
	    //Total TEU추가에 따른 TUE컬럼 처리
		if(chDSItemTYP) sheetObj.ColHidden(MasterCnt+1) = false;
		else sheetObj.ColHidden(MasterCnt+1) = true;
		//Total TEU 컬럼크기 조절
		sheetObj.ColWidth(MasterCnt) = chDSItemTYP?defaultWidth:wideWidth;
	}
}
function getPrefixIndex(prefix){
	for(var i = 0 ; i < preColName.length ; i++){
		if(preColName[i] == prefix) return i;
	}
}
function getPolPodList(sheetObj, div_grp, ofc, prefix){
	var arr = new Array();
	var arrKey = new Array();
	var frow = -1;
	var idx = -1;
	var prefixIdx = getPrefixIndex(prefix);
	var colNames = sizeColName[colSizeIdx[prefixIdx]];
	while((frow = sheetObj.FindText("lvl", "3", frow + 1)) >= 0){
		var oi = sheetObj.CellValue(frow, "ioc_cd");
		if(div_grp.indexOf(":"+oi+":") < 0){
			break;
		}
		var pol = sheetObj.CellValue(frow, "pol_cd");
		var pod = sheetObj.CellValue(frow, "pod_cd");
		var vofc = sheetObj.CellValue(frow, "sls_ofc_cd");
		var key = oi+"-"+pol+"-"+pod;
		if(arrKey[key] == undefined){
			idx = idx + 1;
			arrKey[key] = idx;
			if(ofc == vofc){
				arr[idx] = new Array(
										new Array(oi, pol, pod, frow),
										new Array(	sheetObj.CellValue(frow, prefix+colNames[0])*1, 
													sheetObj.CellValue(frow, prefix+colNames[1])*1, 
													sheetObj.CellValue(frow, prefix+colNames[2])*1, 
													sheetObj.CellValue(frow, prefix+colNames[3])*1, 
													sheetObj.CellValue(frow, prefix+colNames[4])*1
												)
									);
			}
			else{
				arr[idx] = new Array(new Array(oi, pol, pod, -1), new Array(0, 0, 0, 0, 0));
			}
		}
	}
	return arr;
}

//수정된 행의 상위 레벨의 값에 주어진 값(value - oldValue)을 더한다.
function changeSuperiorValue(sheetObj, row, col, pre, value, oldValue, level){
	var difValue = value - oldValue;
	//alert(" difValue " + difValue);
	var rows = new Array();
	//var frow = row - sheetObj.CellValue(row, "lvl2")*1;
	//level down으로 변경
	if(level > 5 ){
		//alert("1_5");
		var frow = row - sheetObj.CellValue(row, "lvl5")*1;
		if(frow < row){
			addCellValue(sheetObj, frow, col, difValue, false);
			//setSumValue(sheetObj, frow, pre);
			//sheetObj.RowStatus(frow) = "R";
			rows[0] = frow;
		}
	}	
	

	if(level > 4 ){
		var frow = row - sheetObj.CellValue(row, "lvl4")*1;
		if(frow < row){
			addCellValue(sheetObj, frow, col, difValue, false);
			//setSumValue(sheetObj, frow, pre);
			//sheetObj.RowStatus(frow) = "R";
			rows[0] = frow;
		}
	}	
	if(level > 3 ){
		var frow = row - sheetObj.CellValue(row, "lvl3")*1;
		if(frow < row){
			addCellValue(sheetObj, frow, col, difValue, false);
			//setSumValue(sheetObj, frow, pre);
			//sheetObj.RowStatus(frow) = "R";
			rows[0] = frow;
		}
	}
	if(level > 2 ){
		var frow = row - sheetObj.CellValue(row, "lvl2")*1;
		if(frow < row){
			addCellValue(sheetObj, frow, col, difValue, false);
			//setSumValue(sheetObj, frow, pre);
			//sheetObj.RowStatus(frow) = "R";
			rows[0] = frow;
		}
	}
	frow = row - sheetObj.CellValue(row, "lvl1")*1;
	if(frow < row){
		//alert("1_1");
		addCellValue(sheetObj, frow, col, difValue, false);
		//setSumValue(sheetObj, frow, pre);		
		//sheetObj.RowStatus(frow) = "R";
		rows[rows.length] = frow;
	}
	return rows;
}
//IOC Type별 Total 행의 값을 변경 한다.
function changeTotalValue(sheetObj, ioc_cd, col, pre, value, oldValue){
//	alert( "changeTotalValue " + "ioc_cd " + ioc_cd + " col " + col+ " pre " + pre+ " value " + value+ " oldValue " + oldValue );
	var row = totalRows[ioc_cd];
	addCellValue(sheetObj, row, col, value - oldValue);
	//setSumValue(sheetObj, row, pre);
	sheetObj.RowStatus(row) = "R";
	return row;
}

// Office 행의 값을 변경 한다.
function changeOfcTotalValue(sheetObj, row_ofc, col, pre, value, oldValue){
	addCellValue(sheetObj, row_ofc, col, value - oldValue, false);
	sheetObj.RowStatus(row_ofc) = "R";
	return row_ofc;
}

//IOC Type별 Group Total 행의 값을 변경 한다.
function changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre, value, oldValue){
	var row = totalRows[ioc_cd];
	var iocRow = sheetObj.FindText("cust_ctrl_cd", cust_ctrl_cd, row);
	
	// IOC 별 Group Total 이 존재 하는지 확인한 후 행의 값 변경
	if(iocRow > row && sheetObj.CellValue(iocRow, "ioc_cd") == ioc_cd) {
		addCellValue(sheetObj, iocRow, col, value - oldValue, false);
//		sheetObj.RowStatus(row) = "R";
		sheetObj.RowStatus(iocRow) = "R";
	}
	return row;
}

//DEST별 Group Total 행의 값을 변경 한다.
function changeDestTotalValue(sheetObj, ioc_cd, del_cd, col, pre, value, oldValue){
	var row = totalRows[ioc_cd];
	var iocRow = sheetObj.FindText("del_cd", del_cd, row);
	// IOC 별 Group Total 이 존재 하는지 확인한 후 행의 값 변경
	if(iocRow > row && sheetObj.CellValue(iocRow, "ioc_cd") == ioc_cd) {
		addCellValue(sheetObj, iocRow, col, value - oldValue, false);
//		sheetObj.RowStatus(row) = "R";
		sheetObj.RowStatus(iocRow) = "R";
	}
	return row;
} 

var sheet1_SelectedRow = -1;
function setSelectetRow(sheetObj, row){
	var frow = sheetObj.FindText("dataSeq", sheet1_SelectedRow);
	setColorSelectedRow(sheetObj, frow, false);
	setColorSelectedRow(sheetObj, row, true);
	sheet1_SelectedRow = sheetObj.CellValue(row, "dataSeq");
}

function setColorSelectedRow(sheetObj, row, select){
	if(row > 0){
		sheetObj.RowBackColor(row) = select?sheetObj.RgbColor(255, 230, 230):sheetObj.DataBackColor;
	}
}

//미사용
function checkPolPodSum(sheetObj, vol, wgt, prefix){
	var list = getPolPodSum(sheetObj, ":OCN:IPC:T/S:T-OCN:T-IPC:T-T/S:", prefix);
	var volList = new Array();
	var wgtList = new Array();
	var cnt = list.length;
	var volCol = 0;
	var prefixIdx = getPrefixIndex(prefix);
	var colNames = sizeColName[colSizeIdx[prefixIdx]];
	var wgtCol = colNames.length-1;
	for(var i = 0 ; i < cnt ; i++){
		var tArr = list[i];
		if(tArr[1][volCol] > (vol+10)){
			volList[volList.length] = tArr[0][0] + "-" + tArr[0][1];
		}
		if(tArr[1][wgtCol] > (wgt+10)){
			wgtList[wgtList.length] = tArr[0][0] + "-" + tArr[0][1];
		}
	}
	if((volList.length + wgtList.length) == 0){
		return true;
	}
	var msg = "다음의 Port 목록이 Loadable을 초과하였습니다.\n";
	if(volList.length > 0){
		msg += "\nSpace : "+volList;
	}
	if(wgtList.length > 0){
		msg += "\nWeight : "+wgtList;
	}
	ComShowMessage(msg);
	return false;
}

//미사용
function checkOcnSum(sheetObj, vol, wgt, prefix){
	var list = getPolPodSum(sheetObj, ":OCN:T-OCN:", prefix);
	var volSum = 0;
	var wgtSum = 0;
	var cnt = list.length;
	var errorRange = 10;
	var volCol = 0;
	vol = vol + errorRange;
	wgt = wgt + errorRange;
	var prefixIdx = getPrefixIndex(prefix);
	var colNames = sizeColName[colSizeIdx[prefixIdx]];
	var wgtCol = colNames.length-1;
	for(var i = 0 ; i < cnt ; i++){
		var tArr = list[i];
		volSum += tArr[1][volCol];
		wgtSum += tArr[1][wgtCol];
	}
	if(volSum <= vol &&  wgtSum <= wgt){
		return true;
	}
	var msg = "";
	if(volSum > vol){
		msg += "Space" + (isDevMode?"("+volSum+"-"+(vol-errorRange)+")":"");
	}
	if(wgtSum > wgt){
		if(msg != ""){
			msg += "와 ";
		}
		msg += "Weight" + (isDevMode?"("+wgtSum+"-"+(wgt-errorRange)+")":"");
	}
	msg += "가 Loadable을 초과하였습니다.";
	ComShowMessage(msg);
	return false;
}

function getSum(sheetObj, div_grp, prefix, formObj){
    var acctCtrl = formObj.acctCtrl.value;
	var arrs = getPolPodSum(sheetObj, div_grp, prefix, "3", acctCtrl);
    var sumArr = new Array();
	var prefixIdx = getPrefixIndex(prefix);
	var colNames = sizeColName[colSizeIdx[prefixIdx]];
	var cnt = colNames.length;
    for(var c = 0 ; c < cnt ; c++){
    	sumArr[c] = 0;
    }
    for(var i = 0 ; i < arrs.length ; i++){
	    for(var c = 0 ; c < cnt ; c++){
	    	sumArr[c] += arrs[i][1][c];
	    }
    }
	return sumArr;
}
function getPolPodSum(sheetObj, div_grp, prefix, level, acctCtrl){
	if(level == undefined){
		level = "3";
	}
	var arr = new Array();
	var arrKey = new Array();
	var frow = -1;
	var idx = -1;
	var prefixIdx = getPrefixIndex(prefix);
	var colNames = sizeColName[colSizeIdx[prefixIdx]];
	var cnt = colNames.length;
	
	while((frow = sheetObj.FindText("lvl", level, frow + 1)) >= 0){
		
		var oi = sheetObj.CellValue(frow, "ioc_cd");
		if(div_grp.indexOf(":"+oi+":") < 0){
			continue;
		}
		var pol = sheetObj.CellValue(frow, "pol_cd");
		var pod = sheetObj.CellValue(frow, "pod_cd");
		var key = pol+"-"+pod;

if((ComTrim(sheetObj.CellValue(frow, "sls_ofc_cd")) != "TTL" && (ComTrim(sheetObj.CellValue(frow, "sls_ofc_cd")) != "DEST TTL" &&  acctCtrl == "Y"))
|| (ComTrim(sheetObj.CellValue(frow, "sls_ofc_cd")) != "DEST TTL" && acctCtrl == "N")){ 
			if(arrKey[key] == undefined){
				idx = idx + 1;
				arrKey[key] = idx;
				var cArr = new Array();
				for(var t = 0 ; t < cnt ; t++){
					cArr[t] = sheetObj.CellValue(frow, prefix+colNames[t])*1;
				}
				arr[idx] = new Array(new Array(pol, pod), cArr);
			}
			else{
				var cIdx = arrKey[key];
				var cArr = arr[cIdx][1];
				for(var t = 0 ; t < cnt ; t++){
					cArr[t] += sheetObj.CellValue(frow, prefix+colNames[t])*1;
				}
				arr[cIdx][1] = cArr;
			}
		}
	}
	return arr;
}


var editingControlOption = false;
function editControlOption(sheetObj){
	changeControlOptionButtonStatus(true);
	changeControlOptionStatus(true);
}

/**
 * Control Option을 변경 후 저장시 아래 메소드를 호출함
 * 
 * @param sheetObj
 * @returns
 */
function saveControlOption(sheetObj){
	var frow = sheetObj.FindText("dataSeq", sheet1_SelectedRow);
	// 화면의 변경된 사항을 sheet에 반영한다.
	setControlOption(sheetObj);
	changeControlOptionButtonStatus(false);
	changeControlOptionStatus(false);
	
	if(sheetObj.CellValue(frow, "flag") == "I"){
		sheetObj.RowStatus(frow) = "I";
	}
	var rtn = sheetObj.DoSave("ESM_SPC_0042GS.do", "f_cmd="+MULTI01, -1, false);

	if(rtn || rtn == "OK"){
		// 특정 컬럼에 대해서 값을 초기화 해준다. doRowSearch 같은 효과
//		var html = "<SHEET><DATA TOTAL='1'><TR ROW='"+frow+"'><TD COL='flag'>R</TD><TD COL='mnl_flg'>Y</TD></TR></DATA></SHEET>"
		var param = "";
		param = param + "f_cmd="     + SEARCHLIST03;
		param = param + "&pagerows=" + frow;
		param = param + "&trade="    + sheetObj.CellValue(frow, "TRADE");
		param = param + "&lane="     + sheetObj.CellValue(frow, "rlane_cd");
		param = param + "&bound="    + sheetObj.CellValue(frow, "dir_cd");
		param = param + "&vvd="      + sheetObj.CellValue(frow, "VVD");
		
//		sheetObj.LoadSearchXml(html, false, -1, true); 
		sheetObj.DoRowSearch("ESM_SPC_0042GS3.do", param, false);
//		sheetObj.CellValue(frow, "mnl_flg") = "Y";
//		sheetObj.CellValue(frow, "flag")    = "R";
//		sheetObj.RowStatus(frow)            = "R";
		rtn = "OK";
	}
	return rtn;
}

function cancelControlOption(){
	getControlOption();
	changeControlOptionButtonStatus(false);
	changeControlOptionStatus(false);
}

/**
 * VVD별 Control Option을 값을 화면에 표시해 준다.
 */
function getControlOption(){
	var sheetObj  = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var frow = sheetObj.FindText("dataSeq", sheet1_SelectedRow);
	if(frow < 0) return;
	var formObj = document.form;
	formObj.chkVolume.checked    = sheetObj1.EtcData("volume") == "Y";
	formObj.chkPort.value        = sheetObj1.EtcData("pol_pod");
	formObj.chkHC.checked        = sheetObj1.EtcData("hc40") == "Y";
	formObj.chk45.checked        = sheetObj1.EtcData("hc45") == "Y";
	formObj.chk53.checked        = sheetObj1.EtcData("53ft") == "Y";
	formObj.chkRFR.checked       = sheetObj1.EtcData("reefer") == "Y";
	formObj.chkWGT.checked       = sheetObj1.EtcData("weight") == "Y";
	// allocation 세분화에 따른 D2, D4, RD type추가 2014.07.31
	formObj.chkD2.checked        = sheetObj1.EtcData("d2") == "Y";
	formObj.chkD4.checked        = sheetObj1.EtcData("d4") == "Y";
	formObj.chkDFR.checked       = sheetObj1.EtcData("rd") == "Y";
	formObj.chkIPI.checked       = sheetObj1.EtcData("usa") == "Y";
	formObj.chkAccount.checked   = sheetObj1.EtcData("account") == "Y";	
	
	formObj.chkYG.checked        = sheetObj1.EtcData("acctCtrl") == "Y"; //YieldGroup	
	formObj.chkFX.checked        = sheetObj1.EtcData("fixed") == "Y";	 //fixed
	
	//추가 CHECK BOX
	formObj.chkIPI_O.checked     = sheetObj1.EtcData("usa") == "Y";
	formObj.chkAccount_O.checked = sheetObj1.EtcData("account") == "Y";	
	
//	if (formObj.chkSync != undefined) formObj.chkSync.checked     = false;// 2015.03.18 Control option과 일치 시켜 주는 기능 추가	
//	if (formObj.chkDesync != undefined) formObj.chkDesync.checked     = false;//20150603 김성욱	
}

/**
 * Control Option을 편집 후 저장할때 
 * 상단 sheet에 변경된 정보를 넣어준다.
 */
function setControlOption(sheetObj){
	var frow = sheetObj.FindText("dataSeq", sheet1_SelectedRow);
	var formObj = document.form;
	sheetObj.CellValue(frow, "ctrl_spc_flg")     = formObj.chkVolume.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_lvl_cd")      = formObj.chkPort.value;
	sheetObj.CellValue(frow, "ctrl_40ft_hc_flg") = formObj.chkHC.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_45ft_hc_flg") = formObj.chk45.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_53ft_flg")    = formObj.chk53.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_rf_flg")      = formObj.chkRFR.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_wgt_flg")     = formObj.chkWGT.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_d2_flg")      = formObj.chkD2.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_d4_flg")      = formObj.chkD4.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_rd_flg")      = formObj.chkDFR.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_usa_svc_mod_flg")  = formObj.chkIPI.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_acct_flg")    = formObj.chkAccount.checked?"Y":"N";
	sheetObj.CellValue(frow, "acct_grp_ctrl_flg")= formObj.chkYG.checked?"Y":"N";
	sheetObj.CellValue(frow, "ctrl_fx_rt_flg")   = formObj.chkFX.checked?"Y":"N";

//	// 2015.03.18 Control option과 일치 시켜 주는 기능 추가
//	if (formObj.chkSync != undefined) sheetObj.CellValue(frow, "mnl_flg")          = formObj.chkSync.checked?"N":"Y"; // sync가 체크되면 mnl_flg=N 이 되면서 Lane contorl option 과 동일하게 세팅된다.
//	//2016.06.03 Desync 기능 추가, 
//	if (formObj.chkDesync != undefined) sheetObj.CellValue(frow, "desync_flg")          = formObj.chkDesync.checked?"Y":"N"; // Desync가 체크되면 mnl_flg=Y 이 되면서 Control Optoin에 적용된 ByAloc등 9개 기능 reset
	
	// allocation 세분화에 따른 D2, D4, RD type추가 2014.07.31


}
function changeControlOptionButtonStatus(edit){
	editingControlOption = edit;
	if(controlOptionButton1.display == undefined || controlOptionButton1.display != "none"){
		controlOptionButton1.style.display = edit?"none":"block";
	}
	controlOptionButton2.style.display = edit?"block":"none";
}

/**
 * Control Option의 편집 유무를 컨트롤 한다.
 * @param edit
 */
function changeControlOptionStatus(edit){
	var formObj = document.form;
	formObj.chkVolume.disabled = !edit;
	formObj.chkPort.disabled = !edit;
	formObj.chkHC.disabled = !edit;
	formObj.chk45.disabled = !edit;
	formObj.chk53.disabled = !edit;
	formObj.chkRFR.disabled = !edit;
	formObj.chkWGT.disabled = !edit;
	// allocation 세분화에 따른 D2, D4, RD type추가 2014.07.31
	formObj.chkD2.disabled = !edit;
	formObj.chkD4.disabled = !edit;
	formObj.chkDFR.disabled = !edit;
	// 2014.08.13 IPI/LOCAL, US MOD 끌어올림
	formObj.chkIPI.disabled = !edit;
	formObj.chkAccount.disabled = !edit;
	if(formObj.uiname.value == 'ESM_SPC_0042') {
		formObj.chkYG.disabled = !edit; //RHQ화면에서는 Edit 불가, HO에서만 Edit가능(uiname)
	}
	formObj.chkFX.disabled = !edit;
	//[CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
//	if (formObj.chkSync != undefined) formObj.chkSync.disabled = !edit;// 2015.03.18 Control option과 일치 시켜 주는 기능 추가
//	if (formObj.chkDesync != undefined) formObj.chkDesync.disabled = !edit;//2015.06.03 해당 항차의 Contol Option 의 By Aloc등 9개 기능 제거.
}
function makeDetailParam(sheetObj, row){
	var formObj = document.form;
	var param = "";
	param = param + "f_cmd="+SEARCHLIST02+"&office="+formObj.office.value;
	param = param + "&lane="+sheetObj.CellValue(row, "rlane_cd")+"&bound="+sheetObj.CellValue(row, "dir_cd");
	param = param + "&vvd="+sheetObj.CellValue(row, "VVD");
	param = param + "&trade="+sheetObj.CellValue(row, "TRADE");
	param = param + "&subtrade="+sheetObj.CellValue(row, "STRADE");
	param = param + "&year="+sheetObj.CellValue(row, "WEEK").substring(0, 4);
	param = param + "&week="+sheetObj.CellValue(row, "WEEK").substring(4);
	param = param + "&office="+formObj.office.value;
	return param;
}

function checkByVVD(){
	var obj = event.srcElement;
	var status = obj.checked;
	var formObject = document.form;
	formObject.year.disabled = status;
	formObject.week.disabled = status;
	formObject.duration.disabled = status;
	if(!status){
		//formObject.vvd.value = "";
		//formObject.vvd.style.filter = "progid:DXImageTransform.Microsoft.BasicImage(grayscale=1)";
	}
	else{
		//formObject.vvd.style.filter = "";
	}
	formObject.vvd.disabled = !status;
	formObject.vvd.readOnly = !status;
	formObject.bound.disabled = status;
	comObjects[0].Enable = !status;
	comObjects[1].Enable = !status;
	comObjects[2].Enable = !status;
	//sheetObjects[0].ColHidden("TWEEK") = !status;
	
}

function validAllocation(sheetObj, formObj, group, onlyTpSz){
	log("validAllocation");
	if(onlyTpSz == undefined){
		onlyTpSz = false;
	}
	var colNames = new Array("TEU", "D2", "D4", "HC", "45", "53'", "Reefer", "RD", "Weight");

	var level = formObj.chkPort.selectedIndex;
	if(onlyTpSz){
		level = "0";
	}
	var acctCtrl = formObj.acctCtrl.value;
	
	var allocs = getPolPodSum(sheetObj, group, preColName[alocIdx], level, acctCtrl);
	var models = getPolPodSum(sheetObj, group, preColName[modelIdx], level, acctCtrl);
	log("allocs : " + allocs);
	var cols = new Array();
	var idx = 0;
	if(!onlyTpSz){
		cols[idx++] = 0;
	}
	if(formObj.chkHC.checked){
		cols[idx++] = 3;
	}
	if(formObj.chk45.checked){
		cols[idx++] = 4;
	}
	if(formObj.chk53.checked){
		cols[idx++] = 5;
	}
	if(formObj.chkRFR.checked){
		cols[idx++] = 6;
	}
	if(!onlyTpSz && formObj.chkWT.checked){
		cols[idx++] = 8;
	}
	log("cols : " + cols);
	for(var i = 0 ; i < allocs.length ; i++){
		for(var c = 0 ; c < cols.length ; c++){
			log("validAllocation : " + i + " - " + c + " - " + cols[c] + " - " + allocs[i][1][cols[c]]);
			if(allocs[i][1][cols[c]] > models[i][1][cols[c]]){
				var msg = "";
				if(level > 0){
					msg = allocs[i][0][0] + "-" + allocs[i][0][1];
				}
				switch(cols[c]){
				case 0:
//				case 1:
//				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					msg = getMsg("SPC90131") + "[" + msg + (msg==""?"":"/") + colNames[cols[c]] + "]";
					break;
				case 8:
					msg = getMsg("SPC90132") + "[" + msg + "]";
					break;
				}
				ComShowMessage(msg);
				return cols[c];
			}
		}
	}
	return -1;
}

function validAllocationLoadable(sheetObj, formObj, group, models, onlyTpSz){
	if(onlyTpSz == undefined){
		onlyTpSz = false;
	}
	var columnNames = new Array("TEU", "D2", "D4", "HC", "45", "53", "Reefer", "RD", "Weight");
	var acctCtrl = formObj.acctCtrl.value;
	var level = "0";
	var allocs = getPolPodSum(sheetObj, group, preColName[alocIdx], level, acctCtrl);
	var cols = new Array();
	
	var idx = 0;
	if(!onlyTpSz){
		cols[idx++] = 0;
	}
//	if(formObj.chkHC.checked && models[1] > 0){
//		cols[idx++] = 1;
//	}
//	if(formObj.chk45.checked && models[2] > 0){
//		cols[idx++] = 2;
//	}
	if(formObj.chkHC.checked && models[1] > 0){
		cols[idx++] = 3;
	}
	if(formObj.chk45.checked && models[2] > 0){
		cols[idx++] = 4;
	}
	if(formObj.chk53.checked && models[3] > 0){
		cols[idx++] = 5;
	}
	if(formObj.chkRFR.checked && models[4] > 0){
		cols[idx++] = 6;
	}
	if(!onlyTpSz && formObj.chkWT.checked){
		cols[idx++] = 8;
	}
	for(var i = 0 ; i < allocs.length ; i++){
		for(var c = 0 ; c < cols.length ; c++){
			if(allocs[i][1][cols[c]] > models[cols[c]]){
				var msg = "";
				switch(cols[c]){
				case 0:
					msg = getMsg("SPC90128");
					break;
//				case 1:
//				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
					msg = getMsg("SPC90129") + "[" + columnNames[cols[c]] + "]";
					break;
				case 8:
					msg = getMsg("SPC90130");
					break;
				}
				ComShowMessage(msg);
				return cols[c];
			}
		}
	}
	return -1;
}
//ALO 내용 끝

/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
 * @param{form} str  Form 객체  
 * @param{chkElmNms} str   chkElmNms값들만 form elemente name으로 구성한다. ALL 일경우 모든 elemente 로 구성.
 */  
function SpcFormString(form, chkElmNms) {
	if (typeof form != "object" || form.tagName != "FORM") {
		//Msg : Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag. <== 모듈별 Error Msg 등록하여 사용
		showMsg("");
		return "";
	}
	
	var name  = new Array(form.elements.length);
	var value = new Array(form.elements.length);
	var j = 0;
	var plain_text="";
	
	//사용가능한 컨트롤을 배열로 생성한다.
	len = form.elements.length;
	
	for (i = 0; i < len; i++) {
		//클래스 아이디로 제품을 구분함-아래는 HTMl제품
		if(form.elements[i].classid==undefined && checkExcludeElements(form.elements[i].name, chkElmNms)){
			
			switch (form.elements[i].type) {
				case "button":
				case "reset":
				case "submit":
					break;
				
				case "radio":
				case "checkbox":
					if (form.elements[i].checked == true) {
						name[j]  = form.elements[i].name;
						value[j] = form.elements[i].value;
						j++;
					}
					break;
				
				case "select-one":
					name[j] = form.elements[i].name;
					var ind = form.elements[i].selectedIndex;
					
					if(ind >= 0) {
						if (form.elements[i].options[ind].value != '')
							value[j] = form.elements[i].options[ind].value;
						else
							value[j] = '';
					} else {
						value[j] = "";
					}
					j++;
					break;
				
				case "select-multiple":
					name[j] = form.elements[i].name;
					var llen = form.elements[i].length;
					var increased = 0;
					
					for( k = 0; k < llen; k++ ) {
						if (form.elements[i].options[k].selected) {
							name[j] = form.elements[i].name;
							
							if (form.elements[i].options[k].value != '')
								value[j] = form.elements[i].options[k].value;
							else
								value[j] = '';
							
							j++;
							increased++;
						}
					}
					
					if(increased > 0) {
						j--;
					} else {
						value[j] = "";
					}
					
					j++;
					break;
				
				default :
					if(form.elements[i].value.length >0 ) {
						if(chkElmNms!=null && chkElmNms!='' && chkElmNms!=undefined){
							if(checkExcludeElements(form.elements[i].name, chkElmNms)) {
								name[j]  = form.elements[i].name;
								value[j] = form.elements[i].value;
								j++;
							}
						} else {
							name[j]  = form.elements[i].name;
							value[j] = form.elements[i].value;
							j++;
						}
					}
			}
			
		//IB에서 제공하는 컨트롤의 값을 조합한다.
		} else {
			switch(form.elements[i].classid){
				case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":          // IBMaskEdit 경우
					if((checkExcludeElements(form.elements[i].name, chkElmNms)) && (form.elements[i].Code.length >0)) {
						name[j]  = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
						value[j] = form.elements[i].Value;
						j++;
					}
					break;
				
				case CLSID_IBMCOMBO: // IBMultiCombo 경우
					if((checkExcludeElements(form.elements[i].name, chkElmNms)) && (form.elements[i].Code.length >0)) {
						name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
						
						if(form.elements[i].UseCode)
							value[j] = form.elements[i].Code;
						else
							value[j] = form.elements[i].Text;
						
						j++;
					}
					break;
			}
		}
	}
	
	// QueryString을 조합한다.
	//   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
	//   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
	var webBrowserName = navigator.appName;
	var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
			                                            navigator.appVersion.indexOf("MSIE") + 8)
	
	if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
		for (i = 0; i < j; i++) {
			// if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
			if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
		}
	} else {
		var tmpUrlEncodeSheet    = document.getElementById("formquerystring");
		
		if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '') {
			//인코딩을 위해 숨겨진IBSheet를 만든다.
			var sTag = ComGetSheetObjectTag("formquerystring");
			form.insertAdjacentHTML('afterEnd', sTag);
		}
		
		for (i = 0; i < j; i++) {
			// if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
			if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
		}
	}
	
	//마지막에 &를 없애기 위함
	if (plain_text != "")
		plain_text = plain_text.substr(0, plain_text.length -1);
	
	return plain_text;
}

function checkExcludeElements(elmNm, chkElmNms) {
	var arr_chkElmNms = '';
	var rstTF = false;
	
	try {
		if(chkElmNms != null && chkElmNms != '' && chkElmNms != undefined) {
			arr_chkElmNms = chkElmNms.split(',');
			
			for(var i =0; i < arr_chkElmNms.length; i++) {
				if(arr_chkElmNms[i] != "") {
					if(elmNm==null || elmNm=='' || elmNm==undefined) {
						rstTF = true;
						break;
					} else if(elmNm == arr_chkElmNms[i]) {
						rstTF = true;
						break;
					}
				}
			}
		}
	} catch(e) {
		rstTF = true;
	}
	
	
	if(chkElmNms == 'ALL')
		rstTF = true;
	
	return rstTF;
}

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComOPFXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
 * 
 * 결과: 35X 3 크기의 결과 Array.
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
 * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
 * @return array   [조회된row수 X 컬럼수] 크기의 string array.
 */
function ComXml2Array(xmlStr, colList) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChileNodes = dataNode.childNodes;
		if (dataChileNodes == null) {
			return;
		}

		var colListArr = colList.split("|");
		var colListIdx = Array();
		for ( var i = 0; i < colListArr.length; i++) {
			for ( var j = 0; j < colArr.length; j++) {
				if (colListArr[i] == colArr[j]) {
					colListIdx[i] = j;
					break;
				}
			}
		}

		for ( var i = 0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

			var subDataArr = new Array();
			for ( var j = 0; j < colListIdx.length; j++) {
				subDataArr[j] = arrData[colListIdx[j]];
			}
			rtnArr[i] = (subDataArr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////


/**
 *   jsp에서 페이지 최초 로딩시 아래와 같이 combo를 위한 값을 구성하고 script에서 multi combo에 값을 assign 하고자 할경우
 *   그 값을 파싱해 multi combo에 assign 해준다.
 *   JSP의 Value 예시)
 *    var arrTarGrpComboCd = "TP";
 *    var arrTarGrpComboNm = "TP	Trans-pacific Trade Team";
 *
 *    var arrUnitComboCd = "T|F";
 *    var arrUnitComboNm = "TEU|FEU";

 *  사용 예시
 * <pre>
 *    getSpcTextToCombo(arrYearComboCd, arrYearComboNm, getComboObject(comboObjects, 'year') ,"|","\t" );
 *    getSpcTextToCombo(arrYearComboCd, arrYearComboNm, getComboObject(comboObjects, 'year'));
		
 * </pre>
 *
 * @param {string} codeStr MultiCombo에 assign될 rowSeparator(아래 예제에서는 '|')로 구분된 Code String
 * @param {string} textStr MultiCombo에 assign될 rowSeparator과 colSeparator로 구분된 Text String
 * @param {object} cmbObj 해당 ComboObject
 * @param (stirng) rowSeparator code,text에서 공통으로 쓰이는 구분자로 combo의 row를 구분하는 구분자 default : '|'
 * @param (stirng) colSeparator combo의 text에서만 사용하는 구분자로 다중컬럼을 보여줄때 각 컬럼의 값을 구분하는 구분자다 default : '\t'
 * @param (stirng) showCellIdx  textStr의 값은 colSeparator로 구분된 여러 값이 들어 있으나 다중컬럼으로 보여주지 않고
 *                 <BR>  showCellIdx번째 cell을 보여주고자 할때 사용한다., 0부터 시작,  default : 넘어온 textStr의 컬럼 갯수만큼 컬럼을 보여줌
 * @author 최성민
 * @version 2011.04.01
 */
function getSpcTextToCombo(codeStr,textStr, cmbObj,rowSeparator,colSeparator,showCellIdx ){
    if( rowSeparator  == undefined ){
        rowSeparator = "|"
    }
    if( colSeparator  == undefined ){
        colSeparator = /\t/gi;
    }
    
    var isSplit = true;
    var isShowSpclCol = false;
    var arrCode = codeStr.split(rowSeparator);
    var arrText = textStr.split(rowSeparator);
    if( colSeparator == "|"){
        isSplit = false;
    }
   
    if( showCellIdx != undefined && ( ComIsNumber(showCellIdx) ||  showCellIdx == "0")
            && showCellIdx < (arrText[0].split(colSeparator)).length ){
        isShowSpclCol = true;
    }
    for(var idx=0;idx < arrCode.length; idx++ ){
        var text = arrText[idx];            
        //특정 Text값을 보여준다.
        if( isShowSpclCol ){
            text =  text.split(colSeparator)[showCellIdx];
        }else if( isSplit ){
                text=text.replace(colSeparator,"|");
        }
       
        cmbObj.InsertItem(-1, text, arrCode[idx]);
    }
}


/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * IBMultiCombo의 item으로 insert 해준다.<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = getSpcXmlToCombo(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
 * 
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
 * @param {string} codeCol 선택, Combo의 Code컬럼명.
 * @param {string} textCol 선택, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
 * @return 없음.
 * @author 최성민
 * @version 2011.04.01
 */
function getSpcXmlToCombo(xmlStr, cmbObj, codeCol, textCol) {
	if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
		return;
	}
	
	if (codeCol == null || codeCol == "") {
		codeCol = "code";
	}
	
	if (textCol == null || textCol == "") {
		textCol = "name";
	}

	try {
		cmbObj.RemoveAll();
		
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		
		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		
		var colListIdx = Array();
		var arrText = textCol.split("|");
		for (var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			for (var j = 0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j+1] = i;
				}
			}
		}
		
		for (var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
			
			var item = "";
			for (var j = 1; j < colListIdx.length; j++) {
				item += arrData[colListIdx[j]];
				if (j < colListIdx.length - 1) {
					item += "|";
				}
			}
			cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
/**
 * RHQ Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
 * @date 2011-05-17 
 * @param{String} RHQ Combo 이름
 * @param{Boolean} SINRS,SHARC를 한번에 보여주는지 여부,multi 선택 여부 적용
 **/	
function SpcSearchOptionRHQCombo(elemName,isMulti,isAll) {	  
	if(isMulti == undefined || isMulti == null){
		isMulti = true;
	}
	if(isAll == undefined || isAll == null){
		isAll = false;
	}		
	var mrhq = (isMulti == true? 'Y':'N') 
	var obj = document.getElementById(elemName);
	var rtn = getCodeXmlList("RhqCombo","mrhq="+mrhq); //mrhq : sinwa+shasa의 값을 보여주는지 여부
	obj.setTitle("RHQ|Description");
	if (isMulti == true) {
		obj.SetColWidth("100|240");
		obj.MultiSelect = true;
	} else {
		obj.SetColWidth("50|180");
		obj.MultiSelect = false;
	}
	
	
	ComXml2ComboItem(rtn, obj, "ofc_cd", "ofc_cd|ofc_eng_nm");	
	
	if(isAll)
		obj.InsertItem(0, "ALL|ALL");	
		
}
 
 
 /**
  * Trade Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
  * @date 2011-06-07 
  * @param{String} Trade Combo 이름
  **/	
 function SpcSearchOptionTradeCombo(elemName,isMulti,isAll,trdCd) {	
	if(trdCd == undefined || trdCd == null){
		trdCd = '';
	} 
  
	if(isMulti == undefined || isMulti == null){
		isMulti = true;
	}
 	var mrhq = (isMulti == true? 'Y':'N') 
 	var obj = document.getElementById(elemName);
 	var rtn = getCodeXmlList("TradeCombo","");
 	
 	obj.setTitle("Trade|Description");
 	if (isMulti == true) {
 		obj.SetColWidth("100|240");
 		obj.MultiSelect = true;
 	} else {
 		obj.SetColWidth("50|180");
 		obj.MultiSelect = false;
 	}
 	
 	
 	ComXml2ComboItem(rtn, obj, "trd_cd", "trd_cd|trd_nm");	
 	
	if(isAll)
		obj.InsertItem(0, "ALL|ALL");
 }

  /**
   * Sub Trade Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
   * @date 2011-06-07 
   * @param{String} Sub Trade Combo 이름
   **/	
  function SpcSearchOptionSubTradeCombo(elemName,ipc, del,flg,trdCd,subTrdCd) {
	    var rtn;
		if(ipc == undefined || ipc == null){
			ipc = false;
		}
		
		if(del == undefined || del == null){
			del = '';
		}
		if(trdCd == undefined || trdCd == null){
			trdCd = '';
		} 	
		if(subTrdCd == undefined || subTrdCd == null){
			subTrdCd = '';
		} 		
		var obj = document.getElementById(elemName);
		obj.ShowCol = 1;
		if (flg == true){ 		
		 	rtn = getCodeXmlList("SubTradeCombo", "del=" + del + "&ipc=" + ipc+"&trdCd="+trdCd+"&subTrdCd="+subTrdCd);
		 	obj.setTitle("Trade|SubTrade|Description");
		 	obj.DropHeight = 300;
		 	obj.MultiSelect = true;
		 	obj.SetColWidth("50|60|240");
		} else { 	
			obj.setTitle("Trade|SubTrade|Description");
		 	obj.DropHeight = 300;
		 	obj.MultiSelect = false;
		 	obj.SetColWidth("50|60|240");
		}
		return rtn;
	}  
  
/**
 * 조회 조건의 Lane 설정.
 * @param{eleName} RevenueLane Combo 이름
 * @param{ipc}		Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep Trade 조건 제외. Default = false.
 * @param{del} 		str  	선택, 삭제 플레그 조건 추가 여부
 * @param{flg} 		str  	getCodeXmlList 함수 호출 여부
 * @param{trdCd} 		str  	Trade Code
 */  
function SpcSearchRevLane(elemName,ipc, del,flg,trdCd,subTrdCd,multi, isPus) {
	 var rtn;
	if(ipc == undefined || ipc == null){
		ipc = false;
	}
	
	if(del == undefined || del == null){
		del = '';
	}
	if(trdCd == undefined || trdCd == null){
		trdCd = '';
	} 	
	if(subTrdCd == undefined || subTrdCd == null){
		subTrdCd = '';
	} 
	
	if(multi == undefined || multi == null){
		multi = true;
	} 	
	
	if(isPus == undefined || isPus == null){
		isPus = false;
	} 	
	
	var obj = document.getElementById(elemName);
	if (flg == true){ 		
		
	 	rtn = getCodeXmlList("RevLaneCombo", "del=" + del + "&ipc=" + ipc+"&trdCd="+trdCd+"&subTrdCd="+subTrdCd+"&isPus="+isPus);
	 	
	 	obj.setTitle("Trade|SubTrade|Rev.Lane|Description");
	 	obj.DropHeight = 300;
	 	obj.MultiSelect = multi;
	 	obj.SetColWidth("50|60|60|250");
	 	obj.ShowCol(2);
	} else { 	
	 	obj.setTitle("Trade|SubTrade|Rev.Lane|Description");
	 	obj.DropHeight = 300;
	 	obj.MultiSelect = multi;
	 	obj.SetColWidth("50|60|60|250");
	 	obj.ShowCol(2); 		
	}
	return rtn;
}
 
 
 /*
 * spc 태그 라이브러리용 function
 */

/**
 * 조회 조건의 Year 설정.
 * 
 * @param{elemName} str 필수, Object Name
 */  
function SpcSearchOptionYear(elemName) {
	var obj   = document.getElementById(elemName);
	
	var today = new	Date();
	var year  = today.getFullYear();
	
	var pre  = 1;
	var post = 5;
	
	for (var i = year + pre; i > year - pre - post; i--) {
		newOpt = document.createElement("OPTION");
		newOpt.text  = i;
		newOpt.value = i;
		obj.add(newOpt);
	}
	
	// default 값 현재 년도 setting
	obj.value = year;
}  

/**
 * 조회 조건의 Week 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
 */
function SpcSearchOptionWeek(elemName, isAll,chgYearValue) {

	if(isAll == undefined || isAll == null){
		isAll = false;
	}
	if(chgYearValue == undefined || chgYearValue == ''){
		chgYearValue = '';
	}
	var today = new	Date();
	
	var year;
	if ( chgYearValue !='' ) {
		year = chgYearValue;
	} else {
		year = today.getFullYear();
	}
	var mon  = today.getMonth() + 1;
	var day  = today.getDate();
	mon = (mon < 10 ? "0" : "") + mon;
	day = (day < 10 ? "0" : "") + day;
	
	var rtn  = getCodeList("WeekCombo", "year=" + year);
	var code = rtn[0].split("|");
	var text = rtn[1].split("|");
	
	var obj  = document.getElementById(elemName);
	obj.options.length = 0;	//초기화
	
	if(isAll) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = "ALL";
		newOpt.value = "";
		obj.add(newOpt);
	}
	
	for (var i = 0; i < code.length - 1; i++) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = text[i];
		newOpt.value = code[i];
		obj.add(newOpt);
	}
	if(!isAll) {
		var rtn2  = getCodeList("CurrWeek", "date=" + year + mon + day);
		var code2 = rtn2[0].split("|");
		
		// default 값 현재 주차 setting
		obj.value = code2[0];
	}
}   

/**
 * 조회 조건의 Duration 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{dur} int 선택, Duration 주차의 길이 설정, Default = 5
 * @param{def} int 선택, Duration 의 초기값 설정, Default = 1
 */
function SpcSearchOptionDuration(elemName, dur, def) {
	if(dur == undefined || dur == null){
		dur = 5;
	}
	
	if(def == undefined || def == null){
		def = 1;
	}
	
	var obj  = document.getElementById(elemName);
	
	for (var i = 1; i < dur + 1; i++) {
		newOpt = document.createElement("OPTION");
		newOpt.text  = i;
		newOpt.value = i;
		obj.add(newOpt);
	}
	
	obj.value = def;
}   

/**
 * 조회 조건의 Trade 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, 모든 Trade 조건 추가 여부, default = true.
 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */  
function SpcSearchOptionTrade(elemName, isAll, isRepTrade, del, isSelect, isPus, isMulti) {
	if(isAll == undefined || isAll == null){
		isAll = true;
	}
	
	if(isRepTrade == undefined || isRepTrade == null){
		isRepTrade = false;
	}
	
	if(del == undefined || del == null){
		del = '';
	}
	
	if(isSelect == undefined || isSelect == null){
		isSelect = false;
	}
	
	if(isPus == undefined || isPus == null){
		isPus = false;
	}
	
	if(isMulti == undefined || isMulti == null){
		isMulti = false;
	}
	
	var obj = document.getElementById(elemName);
	
	var rtn = getCodeXmlList("TradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isPus=" + isPus);
	
	obj.setTitle("Trade|Description");
	obj.SetColWidth("50|200");
	obj.MultiSelect = isMulti;
	obj.DropHeight = 190;
	
	ComXml2ComboItem(rtn, obj, "trd_cd", "trd_cd|trd_nm");
	if(isAll) {
		if ( isSelect ) {
	 		obj.InsertItem(0, "|Select");
		} else {
	 		obj.InsertItem(0, "|ALL");
		}
	}
} 


/**
 * 조회 조건의 Trade 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, 모든 Trade 조건 추가 여부, default = true.
 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */  
function SpcSearchOptionSvcLane(elemName, isAll, isRepTrade, del, isSelect, isPus, isMulti) {
	if(isAll == undefined || isAll == null){
		isAll = true;
	}
	
	if(isRepTrade == undefined || isRepTrade == null){
		isRepTrade = false;
	}
	
	if(del == undefined || del == null){
		del = '';
	}
	
	if(isSelect == undefined || isSelect == null){
		isSelect = false;
	}
	
	if(isPus == undefined || isPus == null){
		isPus = false;
	}
	
	if(isMulti == undefined || isMulti == null){
		isMulti = false;
	}
	
	var obj = document.getElementById(elemName);
	var rtn = getCodeXmlList("SvcLaneCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isPus=" + isPus);

	obj.setTitle("Lane|Description");
	obj.SetColWidth("50|200");
	obj.MultiSelect = isMulti;
	obj.DropHeight = 190;
	
	ComXml2ComboItem(rtn, obj, "slan_cd", "slan_cd|slan_nm");
	if(isAll) {
		if ( isSelect ) {
	 		obj.InsertItem(0, "|Select");
		} else {
	 		obj.InsertItem(0, "|ALL");
		}
	}
} 

/**
 * 조회 조건의 Sub Trade 설정. 
 * 		 0207 SHKIM trdCd를 추가.
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, 모든 Sub Trade 조건 추가 여부, default = true.
 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */  
function SpcSearchOptionSubTrade(elemName, isAll, isRepTrade, del, ipc ,trdCd, isPus) {
	if(isAll == undefined || isAll == null){
		isAll = true;
	}
	
	if(isRepTrade == undefined || isRepTrade == null){
		isRepTrade = false;
	}
	
	if(del == undefined || del == null){
		del = '';
	}
	
	if(isPus == undefined || isPus == null){
		isPus = false;
	}
	var obj = document.getElementById(elemName);
	if(trdCd == null || trdCd == ""){
		var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&ipc=" + ipc + "&isPus=" + isPus);
	}else{
		var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&ipc=" + ipc+ "&trdCd=" + trdCd + "&isPus=" + isPus);
	}
	obj.setTitle("Trade|SubTrade|Description");
	obj.SetColWidth("50|60|200");
	obj.DropHeight = 190;
	obj.ShowCol(1);
	
	ComXml2ComboItem(rtn, obj, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
	if(isAll)
		obj.InsertItem(0, "||ALL");
}    
 
/**
 * 조회 조건의 Lane 설정.
 * 		0209 SHKIM locTrdCd,locSubTrdCd,reCdValue 추가.
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = true
 * @param{ipc} Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep Trade 조건
 *             제외. Default = false.
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 */  
function SpcSearchOptionLane(elemName, isAll, ipc, del,locTrdCd,locSubTrdCd,reCdValue, isPus, isMulti) {
	 if(isAll == undefined || isAll == null){
		isAll = true;
	}
	
	if(ipc == undefined || ipc == null){
		ipc = false;
	}
	
	if(del == undefined || del == null){
		del = '';
	}
	
	if(isPus == undefined || isPus == null){
		isPus = false;
	}
	
	if(isMulti == undefined || isMulti == null){
		isMulti = false;
	}
	
	var obj = document.getElementById(elemName);
	if(reCdValue == null || reCdValue == ''){
		var rtn = getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc + "&isPus="+isPus);
	}else{
		var rtn = getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc+ "&locTrdCd=" + locTrdCd+ "&locSubTrdCd=" + locSubTrdCd+ "&reCdValue="+reCdValue + "&isPus="+isPus);
	}
	
	obj.setTitle("Trade|SubTrade|Rev.Lane|Description");
	obj.SetColWidth("50|60|60|250");
	obj.MultiSelect = isMulti;
	obj.DropHeight = 190;
	obj.ShowCol(2);
	
	ComXml2ComboItem(rtn, obj, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
	
	if(isAll)
		obj.InsertItem(0, "|||ALL");
}
 
/**
 * 조회 조건의 Bound 설정.
 * 
 * @param{elemName} str 필수, Object Name
 */
function SpcSearchOptionBound(elemName,isMulti,isAll,multiCombo,txtAll) {
	if(isMulti == undefined || isMulti == null){
		isMulti = true;
	}	  
	if(multiCombo == undefined || multiCombo == null){
		multiCombo = true;
	}	  
	if(txtAll == undefined || txtAll == null){
		txtAll = false;
	}
	var obj   = document.getElementById(elemName);
	
	if ( multiCombo ) {
		var bound = "|E|W|S|N";
	} else {
		if ( txtAll ) {
			var bound = "ALL|E|W|S|N";
			var boundVal = "|E|W|S|N";
			var arrBoundVal = boundVal.split("|");
		} else {
			var bound = "|E|W|S|N";
			var boundVal = "|E|W|S|N";
			var arrBoundVal = boundVal.split("|");
		}
	}
	
	
	var arrBound = bound.split("|");
	if ( multiCombo ) {	   // 멀티 콤보라면
		obj.SetColWidth("80");
	 	if (isMulti == true) {
	 		obj.MultiSelect = true;
	 	} else {
	 		obj.MultiSelect = false;
	 	}
	 	if(isAll) { 
			obj.InsertItem(0 , 'ALL','');
		}
		with (form.bound) {
			DropHeight = 330;
			if(isAll) {
				for ( var i=1; i<arrBound.length; i++) {
					InsertItem(i, arrBound[i], arrBound[i]);
				}			
			} else {
				for ( var i=0; i<arrBound.length-1; i++) {
					obj.InsertItem(i, arrBound[i+1], arrBound[i+1]);
				}
			}
		}
	} else {	// html combo
		for (var i = 0; arrBound.length > i; i++) {
			newOpt       = document.createElement("OPTION");
			newOpt.text  = arrBound[i];
			newOpt.value = arrBoundVal[i];
			obj.add(newOpt);
		}		
	}
} 

/**
 * 조회 조건의 RHQ 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
 * @param{code} str 선택, Option 의 Code 값을 직접 설정, 구분자 "|", ComComboObject 사용
 *              안할시만 가능
 * @param{text} str 선택, Option 의 Text 값을 직접 설정, 구분자 "|", ComComboObject 사용
 *              안할시만 가능
 */  
function SpcSearchOptionRhq(elemName, del, code, text,isAll) {
	   	if(del == undefined || del == null){
	   		del = '';
	   	}
	   	
	   	if(code == undefined || code == null){
	   		code = '';
	   	}
	   	
	   	if(text == undefined || text == null){
	   		text = '';
	   	}
	   	
	   	var obj = document.getElementById(elemName);
	   	
	   	if(code != '' && text != '') {
	   		var arrCode = code.split("|");
	   		var arrText = text.split("|");
	   		
	   		if(arrCode.length == arrText.length) {
	   			for (var i = 0; i < arrCode.length; i++) {
	   				newOpt       = document.createElement("OPTION");
	   				newOpt.text  = arrText[i];
	   				newOpt.value = arrCode[i];
	   				obj.add(newOpt);
	   			}
	   		}
	   		
	   	} else {
	   		var rtn = getCodeXmlList("RhqCombo", "del=" + del);
	   		
	   		obj.setTitle("RHQ|Description");
	   		obj.SetColWidth("70|220");
	   		
	   		ComXml2ComboItem(rtn, obj, "ofc_cd", "ofc_cd|ofc_eng_nm");
	   	}

	 	if(isAll) { 
			obj.InsertItem(0 , '|ALL','');
		}

}  

/**
 * RHQ Combo 의 내용이 동적으로 변경되는 경우에 사용한다.
 * 
 * @date 2011-05-17
 * @param{String} RHQ Combo 이름
 * @param{Boolean} SINRS,SHARC를 한번에 보여주는지 여부,multi 선택 여부 적용
 */	
function SpcSearchOptionRHQCombo(elemName,isMulti,isAll,isSELTYO) {	  
	if(isMulti == undefined || isMulti == null){
		isMulti = true;
	}
	if(isAll == undefined || isAll == null){
		isAll = false;
	}	
	if(isSELTYO == undefined || isSELTYO == null){
		isSELTYO = false;
	}
	var mrhq = (isMulti == true? 'Y':'N'); 
	var mrhq1 = (isSELTYO == true? 'Y':'N');
	var obj = document.getElementById(elemName);
	var rtn = getCodeXmlList("RhqCombo","mrhq="+mrhq+"&mrhq1="+mrhq1); // mrhq : sinwa+shasa의
														// 값을 보여주는지 여부
	obj.setTitle("RHQ|Description");
	if (isMulti == true) {
		obj.SetColWidth("100|240");
		obj.MultiSelect = true;
	} else if (isSELTYO == true) {
		obj.SetColWidth("180|240");
		obj.MultiSelect = true;
		obj.DropHeight = 200;
	} else {
		obj.SetColWidth("50|180");
		obj.MultiSelect = false;
	}
	
	
	ComXml2ComboItem(rtn, obj, "ofc_cd", "ofc_cd|ofc_eng_nm");	
	
	if(isAll)
		obj.InsertItem(0, "ALL|ALL");	
		
} 

/**
 * 조회 조건의 Month 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
 */
function SpcSearchOptionMonth(elemName, isAll) {
	if(isAll == undefined || isAll == null){
		isAll = false;
	}
	
	var mon = "01|02|03|04|05|06|07|08|09|10|11|12";
	
	var code = mon.split("|");
	var text = mon.split("|");
	
	var obj  = document.getElementById(elemName);
	
	if(isAll) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = "ALL";
		newOpt.value = "";
		obj.add(newOpt);
	}
	
	for (var i = 0; i < code.length; i++) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = text[i];
		newOpt.value = code[i];
		obj.add(newOpt);
	}
	
	var today = new	Date();
	var mon   = today.getMonth() + 1;
	
	mon = (mon < 10 ? "0" : "") + mon;
	
	// default 값 현재 월 setting
	obj.value = mon;
}    


/**
 * 조회 조건의 Month 설정.
 * 
 * @param{elemName} str 필수, Object Name
 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
 */
function SpcSearchOptionOcnipc(elemName, isAll) {
	if(isAll == undefined || isAll == null){
		isAll = false;
	}
	
	var ocnIpc = "OCN|IPC|T/S";
	
	var code = ocnIpc.split("|");
	var text = ocnIpc.split("|");
	
	var obj  = document.getElementById(elemName);
	
	if(isAll) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = "ALL";
		newOpt.value = "";
		obj.add(newOpt);
	}
	
	for (var i = 0; i < code.length; i++) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = text[i];
		newOpt.value = code[i];
		obj.add(newOpt);
	}
	
}
 
 /**
  * 조회 조건의 ACCT Classification 설정.
  * 
  * @param{elemName} str 필수, Object Name
  * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
  */
 function SpcSearchOptionAcctClss(elemName, isAll) {
	 if(isAll == undefined || isAll == null){
		 isAll = false;
	 }
	 
	 var acctClss = "|CC|RC|LC";
	 
	 var code = acctClss.split("|");
	 var text = acctClss.split("|");
	 
	 var obj  = document.getElementById(elemName);
	 
	 if(isAll) {
		 newOpt       = document.createElement("OPTION");
		 newOpt.text  = "ALL";
		 newOpt.value = "";
		 obj.add(newOpt);
	 }
	 
	 for (var i = 0; i < code.length; i++) {
		 newOpt       = document.createElement("OPTION");
		 newOpt.text  = text[i];
		 newOpt.value = code[i];
		 obj.add(newOpt);
	 }
	 
 }

/**
 * 조회 조건의 Common Code 설정.
 * 
 * @param{elemName} str		필수, Object Name
 * @param{codeNo}	str		필수, 조회할 CodeNo
 * @param{isOpt}	Boolean	선택, 첫 번째 Option 추가 여부. default = true.
 * @param{optStr}	str		선택, 첫 번째 Option 추가 할 "code|text". default = " |ALL".
 */
function SpcSearchOptionComCode(elemName, codeNo, isOpt, optStr) {
	if(isOpt == undefined || isOpt == null){
		isOpt = true;
	}
	
	if(optStr == undefined || optStr == null){
		optStr = " |ALL";
	}
	
	var rtn  = getCodeList("CommonCode", "codeNo=" + codeNo);
	
	var code = rtn[0].split("|");
	var text = rtn[1].split("|");
	
	var obj  = document.getElementById(elemName);
	
	if(isOpt) {
		var opt = optStr.split("|");
		
		newOpt       = document.createElement("OPTION");
		newOpt.text  = opt[1];
		newOpt.value = opt[0];
		obj.add(newOpt);
	}
	
	for (var i = 0; i < code.length - 1; i++) {
		newOpt       = document.createElement("OPTION");
		newOpt.text  = text[i];
		newOpt.value = code[i];
		obj.add(newOpt);
	}
}

/**
* IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
* IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.<br>
* 
* CoObject 참조.
* 
* @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
* @param {string} codeCol 필수, Combo의 Code컬럼명.
* @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
* @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
*/
function SpcXml2ComboItem(xmlStr, codeCol, textCol) {
	var rtnArr  = Array();
	var rtnArr1;
	var rtnArr2;
	
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	
	try {
		
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		
		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		if(dataChildNodes.length==0){
			return;
		}
		var colListIdx = Array();
		var arrText = textCol.split("|");
		for (var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			for (var j = 0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j+1] = i;
				}
			}
		}
		for (var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
			
			var item = "";
			for (var j = 1; j < colListIdx.length; j++) {
				item += arrData[colListIdx[j]];
				if (j < colListIdx.length - 1) {
					item += "\t";
				}
			}
			
			if ( i == 0 ) {
				rtnArr1 = arrData[colListIdx[0]];
				rtnArr2 = item;
			} else {
				rtnArr1 = rtnArr1 + "|" + arrData[colListIdx[0]];
				rtnArr2 = rtnArr2 + "|" + item;
			}
		}
		rtnArr.push(rtnArr1);
		rtnArr.push(rtnArr2);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
} 
/**
* 조회 조건 TRADE, SUBTRADE, [LANE]를 초기화
* 2012.02.07 SHKIM ALL RESET
* @param{elemName} gubun 필수, value CODE
* @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
* @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false , subtrade = isRepTrade 존재여부 
*/
function optionAllReset(gubun,value,isRepTrade){
	if(isRepTrade == null || isRepTrade == ''){ isRepTrade = false;}
	if("trade" == gubun){
		SpcSearchOptionTrade("trade", true, true);
		SpcSearchOptionSubTrade("subtrade");
		SpcSearchOptionLane("lane",true,true);
	}else if( "subtrade" == gubun){     			
		SpcSearchOptionSubTrade("subtrade",true,isRepTrade,"","",value);			// 0207 SHKIM
		if(isRepTrade == 'true'){
			SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
		}else{
			SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
		}
    	     			
	}
}
/**
* 조회 조건 TRADE, LANE를 초기화
* 2012.02.07 SHKIM ALL RESET
* @param{elemName} gubun 필수, value CODE
* @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
*/
function optionAllResetTwo(gubun,value){
	if("trade" == gubun){
		SpcSearchOptionTrade("trade", true, true);
		SpcSearchOptionSubTrade("subtrade");
		SpcSearchOptionLane("lane",true,true);
	}
}
/**
* 조회 조건 TRADE, SUBTRADE, [RLANE_CD]를 초기화
* 2012.02.07 SHKIM ALL RESET
* @param{elemName} gubun 필수, value CODE
* @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
*/
function optionAllReset2(gubun,value,isRepTrade){
	if("trade" == gubun){
		SpcSearchOptionTrade("trade", true, true);
		SpcSearchOptionSubTrade("subtrade",true,isRepTrade,"","",value);
		SpcSearchOptionLane("rlane_cd",true,true);
	}else if( "subtrade" == gubun){     			
		SpcSearchOptionSubTrade("subtrade",true,isRepTrade,"","",value);			// 0207 SHKIM
		if(isRepTrade == 'true'){
			SpcSearchOptionLane("rlane_cd",true,false,'',value,'',true);	// 0207 SHKIM
		}else{
			SpcSearchOptionLane("rlane_cd",true,true,'',value,'',true);	// 0207 SHKIM
		}
	}
}
/**
* 조회 조건 [REP_TRADE], [SUB_TRADE], LANE를 초기화
* 2012.02.07 SHKIM ALL RESET
* @param{elemName} gubun 필수, value CODE
* @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = false
*/
function optionAllReset3(gubun,value,isRepTrade){
	if("rep_trade" == gubun){
		SpcSearchOptionTrade("rep_trade", true, true);
		SpcSearchOptionSubTrade("sub_trade",true,isRepTrade,"","",value);
		SpcSearchOptionLane("lane",true,true);
	}else if( "sub_trade" == gubun){     
		SpcSearchOptionSubTrade("sub_trade",true,isRepTrade,"","",value);
		if(isRepTrade == 'true'){
			SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
		}else{
			SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
		}
	}
}

function SpcGetDateIntervals(pStartDate, pEndDate, pType) {
	//param : pStartDate - 시작일
	//param : pEndDate  - 마지막일
	//param : pType       - 'D':일수, 'M':개월수

		var strSDT = new Date(pStartDate.substring(0,4),pStartDate.substring(4,6)-1,pStartDate.substring(6,8));
		var strEDT = new Date(pEndDate.substring(0,4),pEndDate.substring(4,6)-1,pEndDate.substring(6,8));
		var strGapDT = 0;
		if(pType == 'D') {  //일수 차이
			strGapDT = (strEDT.getTime()-strSDT.getTime())/(1000*60*60*24);
		} else {            //개월수 차이
			//년도가 같으면 단순히 월을 마이너스 한다.
			// => 20090301-20090201 의 경우 아래 else의 로직으로는 정상적인 1이 리턴되지 않는다.
			if(pEndDate.substring(0,4) == pStartDate.substring(0,4)) {
			    strGapDT = pEndDate.substring(4,6) * 1 - pStartDate.substring(4,6) * 1;
			} else {
			    strGapDT = Math.floor((strEDT.getTime()-strSDT.getTime())/(1000*60*60*24*365.25/12));
			}
		}

		return strGapDT;
	}
