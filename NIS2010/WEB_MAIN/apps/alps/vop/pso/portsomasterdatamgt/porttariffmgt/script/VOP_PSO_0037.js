/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0037.js
 *@FileTitle : Tariff Value Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.31
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.12.23 정명훈
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
 * 2011.06.07 진마리아 CHM-201111397-01 Compulsory Flag Check 보완
 * 2011.07.11 진마리아 CHM-201112149-01 Compulsory Flag 의 checking/unchecking이 모든 Tariff에 대해 변경/저장이 가능하도록 로직 변경
 * 2011.10.31 진마리아 선처리(SRM-201121014) [VOP-PSO] Tariff Value Management 화면 로직 변경
 * 2011.11.23 진마리아 CHM-201114406-01 Tariff Value Management 화면 로직 변경(EDIT_ENBL_FLG 추가)
 * 2014.03.12 박다은   CHM-201429104 	   [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class VOP_PSO_0037 : VOP_PSO_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0037() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;  
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

﻿// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var LANE = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
var ACCOUNT_AND_COST = "";		//[Global Variable] Account & Cost 
var CALENDAR_SELECTED_ROW = "";	//[Global Variable] Popup Calendar 用
var CALENDAR_SELECTED_VAL = "";	//[Global Variable] Popup Calendar 用
var SELECTED_ROW = false;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			
			case "btn_Save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);	
			break;

			case "btn_Delete":
				doActionIBSheet(sheetObject1,formObject,MULTI);	
			break;
			
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
			break;
			
			case "btns_Calendar1" :		// Agreement Date (From Date)
				var cal = new ComCalendar();
				cal.select(formObject.from_date, 'yyyy-MM-dd');
			break;
	
			case "btns_Calendar2" :		// Agreement Date (To Date)
				var cal = new ComCalendar();
				cal.select(formObject.to_date, 'yyyy-MM-dd');
			break;
				
			case "btn_port_cd":
				var sUrl = "/hanjin/VOP_VSK_0043.do?op=0043";
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 490, "", "0,0", true);
				if(rVal){
					formObject.port_cd.value = rVal;
					loadTerminal();				//COMBO YARD
					formObject.yard_cd.focus();
				}
			break;	
			
			case "btn_Copy":
				var checkedRow = sheetObjects[0].FindCheckedRow("sheet1_copy").split("|");
				var acctcd = "";
				var all_info = "";
				var vndrseq = "";
		        var old_ydcd = "";
		        var err      = "";
	
			
		        if	(checkedRow ==""){
				    alert("Please select tariff!!"); 
			      }
			    else {
			   	  for (var idx=checkedRow.length-2; idx>=0; idx--){
			 		   var row = checkedRow[idx];
					   acctcd      = sheetObjects[0].CellValue(row, "sheet1_acct_cd");
				       vndrseq     = sheetObjects[0].CellValue(row, "sheet1_vndr_seq");
				       ydcd        = sheetObjects[0].CellValue(row, "sheet1_yd_cd");
				       ydchgno     = sheetObjects[0].CellValue(row, "sheet1_yd_chg_no");
				       ydchgseq    = sheetObjects[0].CellValue(row, "sheet1_yd_chg_ver_seq");
				       
				       if(old_ydcd != ydcd && old_ydcd != "") {
				    	  alert("Different Yard code!!");
				    	  err = "Y";
				         }

				       all_info    =  acctcd + rpad(vndrseq,6,"*") + rpad(ydchgno,10,"*") + rpad(ydchgseq,3,"*") +','+ all_info;
				       old_ydcd    =  ydcd;
			    	}

 				   if(err==""){
			     	  var theURL = "VOP_PSO_0237.do?yd_cd="+ ydcd +"&all_info=" + all_info;
                      var winName  = "Tariff Copy";
                      var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:900px;dialogHeight:500px";

                      ComOpenWindow(theURL,winName,features,true);
 		   		  }
			    }
			break;

		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);		//alert(e.description);
		} else {
			ComShowMessage(e);
		}
	}
}

function rpad(s, padLength, padString){
    while(s.length < padLength)
        s += padString;
    return s;
}


/**
* IBSheet Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* IBCombo Object를 배열로 등록
* param : combo_obj ==> 콤보오브젝트
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
}

/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

	initControl(sheetObjects[0]);  
	xsheet1_OnLoadFinish(sheetObjects[0]);
}

/**
* Form의 Conrol 를 초기화 시킨다. <br>
*/
function initControl(sheetObj){
	// Form 객체 선언
	formObj = document.form;
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
	axon_event.addListenerForm  ('drop', 'obj_drop', form); 
}

/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
*/ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	var comboId = comboObj.id;
	switch(comboId) {  
		case "yard_cd":		//Yard 
			with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				UseCode = true;
				SetColAlign("center|left");        
				SetColWidth("40|300");
				DropHeight = 190;
				ValidChar(2,3);	//영문대문자,숫자+특수문자
				MaxLength = 100;
			}
		break; 
		
		case "acct_cd":		//Account 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
				MaxLength = 6;
			}
		break; 	
	
		case "cost_cd":		//Cost 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 6;
			}
		break; 			
	} 
}

function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 430;
	
				MultiSelection = false;
	
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
	
				var HeadTitle1 = "|Sel|Del|Yard|Account\nCode|Cost\nCode|Service Provider|Service Provider|Effective Date|Effective Date|Ver.|Compulsory|YD_CHG_NO|lst_flg|max_seq";
				var HeadTitle2 = "|Sel|Del|Yard|Account\nCode|Cost\nCode|Code|Name|From|To|Ver.|Compulsory|YD_CHG_NO|lst_flg|max_seq";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				var prefix = "sheet1_";
	
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
				InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		prefix+"copy",  			false,	"",			   0,		0,		true,  true);
				InitDataProperty(0, cnt++ , dtRadioCheck,	25,		daCenter,	true,		prefix+"del_chk" );
				InitDataProperty(0, cnt++ , dtData,		    70,		daCenter,	true,		prefix+"yd_cd",				false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"acct_cd",  			false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"cost_cd",  			false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"vndr_seq",  		false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,		prefix+"vndr_nm",  			false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"eff_dt",  			false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtPopupEditFormat,		90,			daCenter,	true,		prefix+"exp_dt",  			false,	"",			dfDateYmd,		0,		true,  true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"yd_chg_ver_seq",  	false,	"",			dfNone,			0,		false,  true);
				InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,		prefix+"cpls_flg",  		false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"yd_chg_no",  		false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"lst_flg",  			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"yd_chg_max_seq",  	false,	"",			dfNone,			0,		false,  true);
				
				
				CountPosition = 2;
				ImageList(0)  = "img/btng_condition.gif";			// seq2
				ShowButtonImage = 1;
				
				HeadRowHeight = DataRowHeight + 5;

			}
		break; 
		
		case "sheet2":
			with (sheetObj) {
				// 높이 설정
				style.height = 430;
				
				MultiSelection = false;
	
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "IBFLAG|OBJ_LIST_NO|Object|Regular Value|edit_enbl_flg|FLAG|YD_CHG_NO|YD_CHG_VER_SEQ";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "sheet2_";
	
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
				InitDataProperty(0, cnt++ , dtHidden,		10,		daCenter,	true,		prefix+"obj_list_no",		false);
				InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		prefix+"obj_list_nm", 		false,		"",			dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		prefix+"regular_value",		false,		"",			dfNumber,	4,		true,  		true, 		14);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"edit_enbl_flg",				false,		"",			dfNone,		4,		true,  		true);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"flag",				false,		"",			dfNone,		4,		true,  		true, 		14);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"yd_chg_no",				false,		"",			dfNone,		4,		true,  		true, 		14);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"yd_chg_ver_seq",				false,		"",			dfNone,		4,		true,  		true, 		14);
	
				CountPosition = 2;
				HeadRowHeight = (DataRowHeight + 5) * 2;
			}
		break;
	}
}	

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // Main 조회
			SELECTED_ROW = false;
			var aryPrefix = new Array("sheet1_");   
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;
						
			ComOpenWait(true);
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[0].WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].Redraw = false;
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[0].Redraw = true;
			ComOpenWait(false);
			for(i=2;i<sheetObj.LastRow;i++) {
				if(sheetObj.CellValue(i,"sheet1_lst_flg") != 'Y') {
					 sheetObj.CellEditable(i,"sheet1_exp_dt")= false;
//					 sheetObj.CellEditable(i,"sheet1_cpls_flg")= false; // CHM-201111397-01 : Last Flag 여부 검증 제거
				}
			}
			
		break;
		
		case SEARCH01:      // Detail 조회
			var aryPrefix = new Array("sheet2_");   
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			
			var yd_chg_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_yd_chg_no");
			var yd_chg_ver_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_yd_chg_ver_seq");
			var param = "yd_chg_no=" + yd_chg_no + "&" + "yd_chg_ver_seq=" + yd_chg_ver_seq; 
			var lst_flg = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_lst_flg");
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0037GS.do", param + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			sheetObjects[1].Redraw = false;
			sheetObjects[1].WaitImageVisible = true;
			sheetObjects[1].LoadSearchXml(arrXml[0]);
			sheetObjects[1].Redraw = true;
			sheetObjects[1].WaitImageVisible = false;
			//last version이 아닌 경우에도 입력 가능하도록 수정
//			if(lst_flg!='Y') {
//				for(var i=sheetObj.HeaderRows;i<sheetObj.HeaderRows+sheetObj.RowCount;i++) {
//					sheetObj.CellEditable(i,"sheet2_regular_value")= false;
//				}
//			}
		break;
		
		case MULTI:		// Delete
			formObj.f_cmd.value = SEARCH02; // Delete 전 Invoice 존재 여부 확인
			var checkedRow = sheetObjects[0].FindCheckedRow("sheet1_del_chk").split("|");
			checkedRow.pop();
			if(checkedRow == "")return;
			
			var yd_chg_no = sheetObjects[0].CellValue(checkedRow, "sheet1_yd_chg_no");
			var yd_chg_ver_seq = sheetObjects[0].CellValue(checkedRow, "sheet1_yd_chg_ver_seq");
			var param = "yd_chg_no=" + yd_chg_no + "&" + "yd_chg_ver_seq=" + yd_chg_ver_seq; 
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0037GS.do", param + "&" + FormQueryString(formObj));
			var invCnt = ComGetEtcData(sXml, "invCnt");
			
			if(invCnt != "0"){
				var chkDel = ComShowCodeConfirm("PSO09013", invCnt);
				if (chkDel == true ) {
					sheetObjects[0].RowHidden(checkedRow)= true;
					sheetObjects[0].RowStatus(checkedRow) = "D";
                    doActionIBSheet(sheetObjects[0],formObj, MULTI01);
				}break;
			}else{
				var chkDel2 = ComShowCodeConfirm("PSO00020");
				if (chkDel2 == true ) {
					doActionIBSheet(sheetObjects[0],formObj, MULTI01);
				}break;
			}
			break;
		
		case MULTI01:
            ComOpenWait(true);
            formObj.f_cmd.value = MULTI01;
			var checkedRow = sheetObjects[0].FindCheckedRow("sheet1_del_chk").split("|");
			checkedRow.pop();
			if(checkedRow == "")return;
			
			var yd_chg_no = sheetObjects[0].CellValue(checkedRow, "sheet1_yd_chg_no");
			var yd_chg_ver_seq = sheetObjects[0].CellValue(checkedRow, "sheet1_yd_chg_ver_seq");
			var param = "yd_chg_no=" + yd_chg_no + "&" + "yd_chg_ver_seq=" + yd_chg_ver_seq; 
			var sXml = sheetObj.GetSaveXml("VOP_PSO_0037GS.do", param + "&" + FormQueryString(formObj));
			sheetObjects[0].LoadSaveXml(sXml);
			sheetObjects[0].Redraw = true; 
			sheetObjects[1].Redraw = true;
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
			
            ComOpenWait(false);
            break;
			
		case IBSAVE:        //저장
			var aryPrefix = new Array( "sheet1_", "sheet2_"); 
			formObj.f_cmd.value = MULTI;
		
			/*
		     * @param {ibsheet,array} 	sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
		     * @param {string} 			bUrlEncode   선택,QueryString 인코딩여부, default=true
		     * @param {bool}    		allSave      선택,sheet 전체를 xml string으로 만들지 여부, default=false
		     * @param {int,string}  	col          선택,대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
			 */
			if(ComGetSaveString(sheetObjects, true, false) == ""){
				ComShowCodeMessage("PSO00034", "[Port]");
				return;
			}
			
			ComOpenWait(true);
			sheetObjects[0].WaitImageVisible = false;
			
			/*
			 * @param {ibsheet,array} 	sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
		     * @param {string} 			bUrlEncode   선택,QueryString 인코딩여부, default=true
		     * @param {bool}    		allSave      선택,sheet 전체를 xml string으로 만들지 여부, default=false
		     * @param {int,string}  	col          선택,대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
		     */			
			var sParam = ComGetSaveString(sheetObjects[0], true, false);	//Master
			    sParam = sParam + "&" + ComGetSaveString(sheetObjects[1], true, true);	//Detail
	
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			
			var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0037GS.do", sParam);
		
			sheetObjects[0].LoadSaveXml(sXml);
			sheetObjects[0].Redraw = true; 
			sheetObjects[1].Redraw = true; 
			
			doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
			ComOpenWait(false);
		
		break;

		case IBCLEAR:  

			//Port
			formObj.port_cd.value = "";
			formObj.yard_cd.RemoveAll();
			
			//Account
			formObj.acct_cd.Code = " ";
			formObj.acct_nm.value = "";
			
			//Cost
			formObj.cost_cd.Code = " ";
			formObj.cost_nm.value = "";
			
			//Date
			setToday(formObj.from_date);
			setToday(formObj.to_date);

			//Sheets	
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();

		break;   
		
		case COMMAND05:	//Port Code [keyup:5자리]  
		    formObj.f_cmd.value = COMMAND05;	//
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal = formObj.port_cd.value;
				loadTerminal();
				//f_SetComboAccount(rVal);
				formObj.yard_cd.focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
		break;
		
		case COMMAND01:     // Account Combo
			var aryPrefix = new Array("sheet1_");
			formObj.f_cmd.value = sAction;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			ACCOUNT_AND_COST = ComGetEtcData(sXml, "accountAndCost");	//global
			createComboAccount();	//Account & Cost 초기화
		break;

		case COMMAND02:     // Calendar in Sheet
			var aryPrefix = new Array("sheet1_");
			var param = "f_cmd="           + sAction
					  + "&yd_chg_no="      + sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_yd_chg_no")	
					  + "&yd_chg_ver_seq=" + sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_yd_chg_ver_seq")	
					  + "&port_cd="        + sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_yd_cd")	
					  + "&vndr_seq="       + sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_vndr_seq")	
					  + "&cost_cd="        + sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_cost_cd")	
					  + "&exp_dt="         + sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_exp_dt");	
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0037GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var checkExpDate = ComGetEtcData(sXml, "checkExpDate");
			if(checkExpDate == "X"){
				//Please input date that is less than the date of the next tariff data.
				ComShowCodeMessage("PSO00035");
				sheetObjects[0].CellValue2(CALENDAR_SELECTED_ROW, "sheet1_exp_dt") = CALENDAR_SELECTED_VAL;
				return;
			}
		break;
	}
}	

function validateForm(sheetObj, formObj, sAction) {
	with(formObj){
		switch(sAction) {
			case IBSEARCH:
				if(from_date.value.length != 10){
					ComShowCodeMessage('PSO00009');
					from_date.focus();
					return false;
				}

				if(to_date.value.length != 10){
					ComShowCodeMessage('PSO00009');
					to_date.focus();
					return false;
				}	
				
				if(port_cd.value != ''){
					if(port_cd.value.length != 5){
						ComShowCodeMessage('PSO00001', "[Port]");
						port_cd.focus();
						return false;
					}
				}
			break;
			
			case SEARCH01:
				
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_yd_chg_no")  == ""){
					sheetObjects[1].RemoveAll();
					return false;
				}

			break;
		}
	}	
	return true;
}

function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	//var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			if(obj.name=="vndr_seq"){
				//ComKeyOnlyNumber(obj,",");
				ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
			} else {
				ComKeyOnlyNumber(obj);
			}
			break;
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			if(obj.name=="vsl_slan_cd"){
				ComKeyOnlyAlphabet('uppernum');
			} else {
				ComKeyOnlyAlphabet('upper');
			}
			
			break;
		case "engdn":
			if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
			else ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

function obj_keyup(){
	 var eleObj = event.srcElement;
	 var formObj = document.form;
	 //var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

	 switch (eleObj.name) {
		 case "port_cd":
			 if(eleObj.value.length == 5){
				 doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			 } else{
				 formObj.yard_cd.RemoveAll();
			 }
			 break;

		 case "from_date":
			 if(eleObj.value.length == 8){
				 //formObj.to_date.focus();
			 }
			 break; 
		 case "to_date":
			 if(eleObj.value.length == 8){
				 //formObj.port_cd.focus();
			 }
			 break;
	 }
}

function obj_paste(){
	var eleObj = event.srcElement;
	var formObj = document.form;
		
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");		//영대문자
			break;		

		case "from_date":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;			

		case "to_date":
			gf_SetControlPastePattern(event, "0");		//숫자
			break;			
	}
}

//Drag & Drop으로 값을 입력하는 것은 배제함
function obj_drop(){
	event.returnValue = false;
}

function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_blur(){

	var formObj = document.form;
	obj = event.srcElement;      	

	with(formObj){
		if(obj.name=="from_date" || obj.name=="to_date"){
			var creDtFr = ComReplaceStr(from_date.value,"-","");
			var creDtTo = ComReplaceStr(to_date.value,"-","");

			switch(obj.name) {
				case "from_date":	// Agreement From Date
					if(creDtFr != '' && creDtTo != ''){
						if(creDtFr > creDtTo){
							ComShowCodeMessage('COM12133','To date','From date','greater');
							from_date.value='';
							from_date.focus();
						}
					}
				break;
	
				case "to_date":	// Agreement To Date
					if(creDtFr != '' && creDtTo != ''){
						if(creDtFr > creDtTo){
							ComShowCodeMessage('COM12133','To date','From date','greater');
							to_date.value='';
							to_date.focus();
						}
					}
				break;	
			}

			ComChkObjValid(event.srcElement);
		}

//		switch(obj.name) {
//
//			case "port_cd":		//영문대문자가 아니면 Clear
//				var val = obj.value; 
//				for(var i=0; i<val.length; i++) {
//					if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
//						formObj.port_cd.value = "";
//						formObj.port_cd.focus();
//						break;
//					}
//				}
//			break;
//
//		}	
	}
}

/**
 * 화면 로딩시 콤보조회 
 */
function xsheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);

	//Date
	setToday(formObj.from_date);
	setToday(formObj.to_date);
}
 
/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "exp_dt" :				//to_date 팝업
		
			var cal = new ComCalendarGrid("myCal"); 
			CALENDAR_SELECTED_ROW = sheetObj.SelectRow;
			CALENDAR_SELECTED_VAL = sheetObj.CellValue(sheetObj.SelectRow, prefix + "exp_dt");
			CALENDAR_SELECTED_VAL = ComReplaceStr(CALENDAR_SELECTED_VAL, "-", "");
			cal.setEndFunction("setExpDate");	//Callback Function
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		
		break;	 
		
		
	}
	

}


function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
	var prefix = "sheet1_";
	if(OldRow == NewRow){
		return;
	}
	
	//alert("OldRow : " + OldRow + "\nNewRow : " + NewRow);
	
	//선택된 Tariff의 Object가 수정되었다면, 확인 후 저장
	if(f_IsModified(OldRow, NewRow)) return;
	
	doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
	sheetObjects[0].SelectCell(NewRow, "sheet1_exp_dt");
}

function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet1_";
	
	sheetObj.ShowDebugMsg = false;
	
	switch (sheetObj.ColSaveName(Col)) {
//		case prefix + "exp_dtxxx" :
//
//		break;
		
		case prefix + "exp_dt":
			CALENDAR_SELECTED_ROW = Row
			CALENDAR_SELECTED_VAL = sheetObj.CellSearchValue(Row, Col);
			CALENDAR_SELECTED_VAL = ComReplaceStr(CALENDAR_SELECTED_VAL, "-", "");
			setExpDate();
		break;
		
		case prefix + "copy":
			var copy = sheetObjects[0].CellValue(Row, "sheet1_copy");
			var seq  = sheetObjects[0].CellValue(Row, "sheet1_yd_chg_ver_seq");
			var seq2 = sheetObjects[0].CellValue(Row, "sheet1_yd_chg_max_seq");
						
			if(copy=="1" && seq != seq2){
				alert("It is not last version.");
				sheetObjects[0].CellValue2(Row, "sheet1_copy") = 0;
			}
		break;
		
	}
}

function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;
	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "regular_value" :
			var val = sheetObj.CellValue(Row, Col);
			if(!f_SetCipherLess(val, 10, 10)){	//정수부분 10자리 이하, 소수부분 10자리 이하
				sheetObj.CellValue2(Row, Col) = "";
			}

		break;
	}	
}

/*
* 조회 후처리
*/
function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	//Object Sheet의 Column Type을 바꾼다.
	for(var i=sheetObj.HeaderRows;i<sheetObj.HeaderRows+sheetObj.RowCount;i++) {
		if(sheetObj.CellEditable(i,"sheet2_regular_value")){
			if(sheetObj.CellValue(i, "sheet2_edit_enbl_flg") == "Y"){
				sheetObj.CellEditable(i,"sheet2_regular_value")= true;
			}else{
				sheetObj.CellEditable(i,"sheet2_regular_value")= false;
			}
		}
	}
}


/**
 * Combo Key-In or Copy&Paste 시, 입력문자제한 설정
 */ 
function yard_cd_OnKeyDown(comboObj, KeyCode, Shift){
}

/**
 * Account Combo
 */
function acct_cd_OnChange(comboObj, Index_Code, Text){
	var formObj = document.form;
	formObj.acct_nm.value = formObj.acct_cd.GetIndexText(formObj.acct_cd.Index, 1);
	
	//Cost Combo
	formObj.cost_cd.RemoveAll();
	createComboCost(ComTrim(formObj.acct_cd.Code));
}

/**
 * Combo Key-In or Copy&Paste 시, 입력문자제한 설정
 */ 
function acct_cd_OnKeyDown(comboObj, KeyCode, Shift){
	var formObj = document.form;
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");	//숫자만 입력 가능
}

/**
 * Cost Combo
 */
function cost_cd_OnChange(){
	var formObj = document.form;
	formObj.cost_nm.value = formObj.cost_cd.GetIndexText(formObj.cost_cd.Index, 1);
} 
 
/**
 * Combo Key-In or Copy&Paste 시, 입력문자제한 설정
 */ 
function cost_cd_OnKeyDown(comboObj, KeyCode, Shift){
	//if(KeyCode == 8 || KeyCode == 46 || KeyCode == 16){	//Back Space, Delete, Shift
	//alert("KeyCode : " + KeyCode);
	var formObj = document.form;
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");	//영대문자만 입력 가능
} 
 
function loadTerminal() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	//콤보필드를 초기화시킨다.
	formObj.yard_cd.RemoveAll();
	formObj.f_cmd.value = COMMAND01;
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", FormQueryString(formObj));
	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
	addComboItem(formObj.yard_cd, comboItems);
} 

/**
 * 콤보필드에 데이터를 추가해준다. (Yard)
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}

/**
 * Create Account Combo
 */
function createComboAccount(){
	var formObj = document.form;
	arrComboItems = ACCOUNT_AND_COST.split("↔");

	var preCode = "";
	formObj.acct_cd.InsertItem(-1, "ALL|", " ");	//ALL
	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		var comboItem = arrComboItems[i].split("↕");
		//comboItem[] : ACCT_CD, ACCT_NM, COST_CD, COST_NM                      
		
		if(preCode != comboItem[0]){
			formObj.acct_cd.InsertItem(-1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		}
		preCode = comboItem[0];
	}  
	formObj.acct_cd.Index = 0;
}

/**
 * Create Cost Combo
 */
function createComboCost(account){
	var formObj = document.form;
	
	if(account == "511911" || account == "962111" || account == ""){
		formObj.cost_cd.InsertItem(-1, "ALL|", " ");	//ALL
	}
	
	arrComboItems = ACCOUNT_AND_COST.split("↔");
	for (i = 0 ; i < arrComboItems.length && arrComboItems != "" ; i++) {
		var comboItem = arrComboItems[i].split("↕");
		//comboItem[] : ACCT_CD, ACCT_NM, COST_CD, COST_NM 
		
		if(account == ""){
			formObj.cost_cd.InsertItem(-1, comboItem[2] + "|" + comboItem[3], comboItem[2]);			
		} else{
			if(account == comboItem[0]){
				formObj.cost_cd.InsertItem(-1, comboItem[2] + "|" + comboItem[3], comboItem[2]);
			}
		}
	}
	formObj.cost_cd.Index = 0;
}
 
/*
 * Sheet의 EXP_DT 선택후 CallBack
 */ 
function setExpDate(){
	var formObj = document.form;
	var eff_dt     = sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_eff_dt");
	    eff_dt     = ComReplaceStr(eff_dt, "-", "");
	var new_exp_dt = sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "sheet1_exp_dt");
	    new_exp_dt = ComReplaceStr(new_exp_dt, "-", "");
	
	if(new_exp_dt < eff_dt){
		ComShowCodeMessage('COM12133','To date','From date','greater');
		sheetObjects[0].CellValue2(CALENDAR_SELECTED_ROW, "sheet1_exp_dt") = CALENDAR_SELECTED_VAL;
		return;
	}
	
	//EXP_DT Validation
	doActionIBSheet(sheetObjects[0], formObj, COMMAND02);
}
 
/*
 *  정수부분, 소수부분 자리수 이하 설정
 */
function f_SetCipherLess(val, integerPlace, decimalPlace){
	var arrVal = val.split(".");
		
	if(arrVal.length == 1){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
	} else if(arrVal.length == 2){
		if(arrVal[0].length > integerPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
			return false;
		}
		if(arrVal[1].length > decimalPlace){
			ComShowCodeMessage("PSO00023", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
			return false;
		}
	}	
	return true;
} 

/*
 * 
 */ 
function f_SetComboAccount(portCd){ 
	//GLOBAL conditionXML
	if( portCd == 'EGSUZ' ||  portCd == 'PAPAC' ){
		//Account
		//formObj.acct_cd.GetIndexText(formObj.acct_cd.Index, 1);
		formObj.acct_cd.Code = "511911";
		formObj.acct_cd.Enable = false;
		//...
	} else {
		//Account
		formObj.acct_cd.Enable = true;
		//...
	}			
}
 
/*
 * sheet2 Modified 확인후 저장
 */ 
function f_IsModified(OldRow, NewRow){
	var formObj = document.form;
	
	if(OldRow == 1) return false;
	
	if(sheetObjects[1].IsDataModified){
		if(!confirm(msgs["PSO00037"])){	//There are changed data. Would you save them?
			return false;
		} else{
			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
			return true;
		}
	}
	return false;
}
	