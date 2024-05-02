/*=========================================================
*copyright(c) 2006 cyberlogitec
*@filename : ESD_PRD_0088.js
*@filetitle : yardmanage
*open issues :
*change history :
*@lastmodifydate : 2014-12-08
*@lastmodifier : 
*@lastversion : 1.0 
* 2014-12-08 kimseungman
* 1.0 최초 생성
=========================================================*/

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var nodeCd = "";
var comboObjects = new Array();
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /** **************************************************** */
    var formObject = document.form;
    var param ;
    var sheetRowCnt = sheetObjects[0].RowCount;
    var change = 0;
    try {
        var srcName = window.event.srcElement.getAttribute("name");
        switch (srcName) {

        case "btn_retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;

        case "btn_New":
        	clear_form();
        	formObject.os_cd.Text = "";
        	sheetObject.RemoveAll();
            break;
        
        case "btn_excel":
        	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
        	break;
        	
        case "btn_save":
        	for(var i=1; i <= sheetRowCnt; i++) {
				if(sheetObject.CellValue(i+1,"ibflag")!='U'){
					change = change+1;
				}
			}
        	if(change == sheetRowCnt){
				ComShowMessage("Data was not changed!");
				break;
			}
        	
//        	if(validateForm(sheetObj,formObj,srcName)){
				if(ComShowCodeConfirm('COM130504')){
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				}
//			}
        	break;
        	
        	
        } // end switch
      
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('COM12111'));
        } else {
            ComShowMessage(e);
        }
    }
    
}

var cntGb = '';
function selectCountry(cnt) {
    cntGb = cnt;
    var frm = document.form;
    var param = '?classId=' + "COM_ENS_051"
    // var sheetObj = sheetObjects[0];
    if (cntGb == 'cnt') {
        param = param + '&cnt_cd=' + frm.country_code.value;
    }

    ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);

}
function getCountry(rowArray) {
    //alertComPopupData(rowArray);

    var colArray = rowArray[0];
    // var sheetObj = sheetObjects[0];
    var frm = document.form;
    if (cntGb == 'cnt') {
        frm.country_code.value = colArray[3];
    }
}

function getLoc(rowArray) {
    //alertComPopupData('3:'+rowArray);

    var colArray = rowArray[0];

    document.all.location_code_top.value = colArray[3];

}

function getNode(rowArray) {

    var colArray = rowArray[0];
    document.all.node_code_top.value = colArray[3];
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

    sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObject = document.form;
    //ComShowMessage(nodeCd );
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }
    formObject.incl_sub_ofc_flg.value ="N";
    initControl();
    
    formObject.chk_os_all.value='ALL'
    
	for(var p=0;p< comboObjects.length;p++){
       		initCombo (comboObjects[0],1);
	}
    
}
function initControl() {
	var formObject = document.form;
//	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
//	axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    switch (sheetNo) {
    case 1: //IBSheet1 init
        with (sheetObj) {
            //전체 너비 설정
            style.height = 400;
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge + msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            FocusEditMode = false;
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 13, 100);

            var HeadTitle1 = "Node\nCode|Node Name|Control\nOffice|MAT|BAT|CY|CFS|RR|PY|Yard\nCharacter|Operation Service|Default Service Provider|Default Service Provider||";
            var HeadTitle2 = "Node\nCode|Node Name|Control\nOffice|MAT|BAT|CY|CFS|RR|PY|Yard\nCharacter|Operation Service|S/P Code|S/P Name||";

            var headCount = ComCountHeadTitle(HeadTitle1);
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
         // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, false, true, false,false)
            
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            
            InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "yd_cd",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 160, daLeft,   true, "yd_nm",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "ofc_cd",   false, "", dfNone,     0, false, false);            

            InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "yd_fcty_tp_mrn_tml_flg",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "yd_fcty_tp_brg_rmp_flg",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "yd_fcty_tp_cy_flg",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "yd_fcty_tp_cfs_flg",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "yd_fcty_tp_rail_rmp_flg",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "yd_fcty_tp_psdo_yd_flg",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "yd_chr_cd",   false, "", dfNone,     0, false, false);   

            InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "os",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++, dtPopupEdit, 55, daCenter, false, "sp_code",   false, "", dfNone,     0, true, true,6);
            InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "sp_name",   false, "", dfNone,     0, false, false);
            InitDataProperty(0, cnt++,  dtHidden,			100,	daCenter,	false,	"country_code",		false,	"",	dfNone,			0, false, false, 20);
            InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag" ,false);
            
            InitDataValid(0, "sp_code", vtNumericOnly);
            FrozenCols = 3;
        }
        break;
    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid ;
	var sXml ;
	sheetObj.ShowDebugMsg = false;

    switch (sAction) {

    case IBSEARCH: //조회
    	
        if (validateForm(sheetObj, formObj, sAction))
            formObj.f_cmd.value = SEARCH;
        
	        var sParam = FormQueryString(formObj);
//	        alert(sParam);
			var sXml = sheetObj.GetSearchXml("ESD_PRD_0088GS.do", sParam);
			if(sXml.length>0){
				sheetObj.LoadSearchXml(sXml);
			}
			
        break;

    case IBSAVE: //저장
        if (validateForm(sheetObj, formObj, sAction))
        	formObj.f_cmd.value = MULTI;
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObj.GetSaveXml("ESD_PRD_0088GS.do", "f_cmd=" + MULTI + "&" +sParam);
			sheetObj.LoadSaveXml(sXml);
//			ComShowMessage("Save success");
            break;



    case IBDOWNEXCEL: //엑셀 다운로드
//        sheetObj.Down2Excel(-1, false, false, true);
    	sheetObj.SpeedDown2Excel(-1);
        break;


    case SEARCH02:
        formObj.f_cmd.value = SEARCH11;
        var sParam = FormQueryString(formObj);
        var sXml = sheetObj.GetSearchXml("ESD_PRD_0088GS.do", sParam);
        break;
        
    case SEARCH03:
        formObj.f_cmd.value = SEARCH03;
        var sParam = FormQueryString(formObj);
        var sXml = sheetObj.GetSearchXml("ESD_PRD_0088GS.do", sParam);
        
        var valResult = ComGetEtcData(sXml, "vndr_Nm");
        var VndrCntCd = ComGetEtcData(sXml, "VndrCntCd");
        var VndrSeq =ComGetEtcData(sXml, "VndrSeq");
        
        var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
        
        if(valResult == "" || State != "S"){
        	ComShowMessage('S/P_Code doesn\'t exist.');//경고창
			formObj.vndr_Nm.value = "";
			formObj.VndrCntCd.value = "";
			formObj.VndrSeq.value = "";
			break;
		}else{
			formObj.vndr_Nm.value = valResult;
			formObj.VndrCntCd.value = VndrCntCd;
			formObj.VndrSeq.value = VndrSeq;
		}
        
        break;


    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	 var sheet1RowCnt = sheetObj.RowCount;
	 switch(sAction) {
		 
	 } // end switch()
	 return true;
}
function initCombo (comboObj, comboNo) {
	switch(comboObj.id) {
	 
		case "os_cd":
			DropHeight = 150;
			MultiSelect = true;
			UseAutoComplete = true;
			MultiSeparator = ",";
			Style = 0;
			ValidChar(2,2);
	}
}
function sheet1_OnDblClick(sheetObj, row, col, value) {
//    clear_form();
}


function clear_form() {

    Form = document.form;
    
    Form.yd_cd.value='';
    Form.yd_nm.value='';
    Form.ofc_cd.value='';
    
    Form.country.value='';
    Form.loc_cd.value='';
    
    Form.yd_chr_cd.options[0].selected=true;
    Form.chk_office.checked = false;
    
    Form.chk_os_all.value='ALL';
    Form.chk_os_a.value='';
    Form.chk_os_b.value='';
    Form.chk_os_c.value='';
    Form.chk_os_d.value='';
    Form.chk_os_e.value='';
    Form.chk_os_f.value='';

}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) { 
		//조회후 팝업특정셀 팝업기능 비활성화
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if (CellValue(i,SaveNameCol("os")) == "Terminal/CY Handling" ||CellValue(i,SaveNameCol("os")) == "Stevedoring"||CellValue(i,SaveNameCol("os")) == "Security" ){
				sheetObj.CellEditable(i, "sp_code")=false;
			}
		}
		
	}
}
//팝업 열기 
function sheet1_OnPopupClick(sheetObj, Row, Col, value) {
	if (sheetObj.ColSaveName(Col) == "sp_code") {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
	}
}

//팝업값가져오기 
function callBackLocation(aryPopupData, row, col, sheetIdx){
	   var sheetObj = sheetObjects[0];
	   var vndrSeq = "";
	   var vndrNm = "";
	   var vndrCntCd="";
	   var i = 0;
	   
	   for(i = 0; i < aryPopupData.length; i++){
		   vndrSeq = vndrSeq + aryPopupData[i][2];
		   vndrNm = vndrNm + aryPopupData[i][4];
		   vndrCntCd = vndrCntCd + aryPopupData[i][7];
		   
	   }
	   sheetObj.CellValue2(row, "sp_code") = vndrSeq;
	   sheetObj.CellValue2(row, "sp_name") = vndrNm;
	   sheetObj.CellValue2(row, "country_code") = vndrCntCd;
	}

function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    //풍선도움말 만들기
    sheetObj.ToolTipOption="balloon:true;width:100;icon:0;title:";
    var msgStr = "[Relevant Cost Code]\nTerminal /CY Handling : TMNDFL, TMNDTS, TMNDRF, TMFDFL\nStevedoring : TPNDFS, TPNDTS, SVLDFL, SVLDTS\nSecurity : SVSSFL, SVSSTS\nWharfage : SVWFFL, SVWFLC, SVWFTS\nAssessment : SVALFL, SVALTS\nStorage : SRNDFL, SRNDTS, SRFDFL";
    Row = sheetObj.MouseRow;
    
    if (sheetObj.MouseCol==sheetObj.SaveNameCol("os") && Row=="1"){
  	  sheetObj.MousePointer = "Hand";
  	  sheetObj.MouseToolTipText = msgStr;
    }else{
  	  sheetObj.MousePointer = "Default";
  	  if (sheetObj.MouseToolTipText != ""){ 
  		  sheetObj.MouseToolTipText = "";
  	  } 
    }
}

//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	
	var doc_office = document.form.chk_office;
	var formObj = document.form;
	var prm_office = doSepRemove(document.form.ofc_cd.value.toUpperCase(), " ");
    
	if(doc_office.checked == true){
		document.form.incl_sub_ofc_flg.value="Y";
		document.form.old_ofc_cd.value = document.form.ofc_cd.value;
	}else{
		document.form.incl_sub_ofc_flg.value="N";
		document.form.old_ofc_cd.value = "";
	}
	
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.ofc_cd.value = "";
		ComShowMessage("Please input the 'Control Office'!!" );
		return false;
	}
	
    if( doc_office.checked == true ) {
    	formObj.f_cmd.value = SEARCH11;
        var sParam = FormQueryString(formObj);
    	var sXml = sheetObjects[0].GetSearchXml("ESD_PRD_0088GS.do","",FormQueryString(formObj),true);
        var arrResult = XmlToArray(sXml);
        
        if(typeof arrResult=="undefined"){
        	return false;
        }else{
        	formObj.ofc_cd.value=arrResult;
        }
        
	} else {
		document.form.ofc_cd.value = "";
	}
    
}


function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}


//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}


function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	var os = sheetObj.CellValue(Row,"os");
	
	
	
	if(sheetObj.ColSaveName(Col) == "sp_code" && sheetObj.CellValue(Row,"sp_code") != ""){
 		formObj.f_cmd.value = SEARCH03;
 		formObj.chk_vndr_seq.value = sheetObj.CellValue(Row, "sp_code");
 		doActionIBSheet(sheetObj, formObj, SEARCH03);
 		if(formObj.vndr_Nm.value != ""){
 			sheetObj.CellValue2(Row,"sp_name") = formObj.vndr_Nm.value;
 			sheetObj.CellValue2(Row,"country_code") = formObj.VndrCntCd.value;
 			sheetObj.CellValue2(Row,"sp_code") = formObj.VndrSeq.value;
		}else{
			sheetObj.CellValue2(Row,"sp_name") = "";
			sheetObj.CellValue2(Row,"country_code") = "";
			sheetObj.CellValue2(Row,"sp_code") = formObj.VndrSeq.value;
		}
 	}
	if(sheetObj.ColSaveName(Col) == "sp_code" && sheetObj.CellValue(Row,"sp_code") == ""){
		sheetObj.CellValue2(Row,"sp_name") = "";
		sheetObj.CellValue2(Row,"country_code") = "";
	}
//	if((sheetObj.CellValue(Row,"yd_cd")
	if(os== "Wharfage"){
		sheetObj.CellValue2(Row+1,"ibflag") = "U";
		sheetObj.CellValue2(Row+2,"ibflag") = "U";
	}else if(os== "Assessment"){
		sheetObj.CellValue2(Row-1,"ibflag") = "U";
		sheetObj.CellValue2(Row+1,"ibflag") = "U";
	}else if(os== "Storage"){
		sheetObj.CellValue2(Row-1,"ibflag") = "U";
		sheetObj.CellValue2(Row-2,"ibflag") = "U";
	}
	
}

function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObject = document.form;
	if(errMsg == "") {   
		ComShowMessage("Data was saved successfully");
		// 조회
		doActionIBSheet(sheetObj, formObject, IBSEARCH);
	}
}
function sheet1_OnLoadFinish(sheetObj) {
	var formObject = document.form;     	
    
    
    with (form.os_cd) {
      	 MultiSelect = true;
        MultiSeparator = ",";
      	 DropHeight = 270;
       	 InsertItem(0 , 'ALL','ALL');
       	 InsertItem(1 , 'Terminal/CY Handling','A');
       	 InsertItem(2 , 'Stevedoring','B');
       	 InsertItem(3 , 'Security','C');
       	 InsertItem(4 , 'Wharfage','D');
       	InsertItem(5 , 'Assessment','E');
       	InsertItem(6 , 'Storage','F');
    }    
}
function os_cd_OnCheckClick(comboObj, index, code) {
	
	var formObject = document.form;  
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
			formObject.chk_os_all.value='ALL';
			formObject.chk_os_a.value='';
			formObject.chk_os_b.value='';
			formObject.chk_os_c.value='';
			formObject.chk_os_d.value='';
			formObject.chk_os_e.value='';
			formObject.chk_os_f.value='';
		
	} else {
		comboObj.CheckIndex(0) = false;
		
		if(code=='A'){
			if(formObject.chk_os_a.value=='Y'){
				formObject.chk_os_a.value='';
			}else{
				formObject.chk_os_a.value='Y';
			}
		}else if(code=='B'){
			if(formObject.chk_os_b.value=='Y'){
				formObject.chk_os_b.value='';
			}else{
				formObject.chk_os_b.value='Y';
			}
		}else if(code=='C'){
			if(formObject.chk_os_c.value=='Y'){
				formObject.chk_os_c.value='';
			}else{
				formObject.chk_os_c.value='Y';
			}
		}else if(code=='D'){
			if(formObject.chk_os_d.value=='Y'){
				formObject.chk_os_d.value='';
			}else{
				formObject.chk_os_d.value='Y';
			}
		}else if(code=='E'){
			if(formObject.chk_os_e.value=='Y'){
				formObject.chk_os_e.value='';
			}else{
				formObject.chk_os_e.value='Y';
			}
		}else if(code=='F'){
			if(formObject.chk_os_f.value=='Y'){
				formObject.chk_os_f.value='';
				
			}else{
				formObject.chk_os_f.value='Y';
			}
		}
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			if(comboObj.CheckIndex(i) == true){
				formObject.chk_os_all.value='';
				return true;
			}else if(comboObj.CheckIndex(i) == false){
				formObject.chk_os_all.value='ALL';
			}
		}
		
	}
}    

function XmlToArray(xmlStr) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
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

		var retStr = "";

		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep).join("");
			rtnArr.push(arrData);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}