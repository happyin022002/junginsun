/*=========================================================
*Copyright(c) 2383 CyberLogitec
*@FileName       : ESM_SQM_0509.js
*@FileTitle      : Reefer/Special Type/Size Master
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.11.13
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND38=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0509 : ESM_SQM_0509 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0509() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, IBSAVE);
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObject, formObj, IBINSERT);
				break;
			case "btn_Downexcel":
				sheetObject.SpeedDown2Excel(-1);   
				break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObj = document.form;
	loadingMode = true;
	
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	loadingMode = false;
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle =  "DEL|STS|SEQ|Container|Container Type|Danger Flag|Reefer Dry Excluded Flag|Active";
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(18);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtDelCheck,		30, 	daCenter,	true,	"",			    	false,	"",	dfNone,	0,	false,	true,	-1,	false,	true,	"",	false);
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",	    	false,	"",	dfNone,	0,	false,	false);	
				InitDataProperty(0,	cnt++,	dtSeq,			50,  	daCenter,	true,	"seq",		    	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,    		150,	daCenter,	true,	"cntr_tpsz_cd",		true,	"",	dfNone,	0,	false,	true, 3);
				InitDataProperty(0,	cnt++,	dtCombo,		150,	daCenter,	true,	"spcl_tgt_cd",  	true,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCombo,		180,	daCenter,	true,	"spcl_dg_cgo_flg",	false,	"",	dfNone,	0,	true,	true);	
				InitDataProperty(0,	cnt++,	dtCombo,		180,	daCenter,	true,	"rd_flg",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCheckBox,		190,	daCenter,	true,	"sqm_act_flg",  	false,	"",	dfNone,	0,	true,	true);
				
				InitDataCombo(0, "spcl_tgt_cd", "Dry|Special|Reefer", "D|S|R");
				InitDataCombo(0, "spcl_dg_cgo_flg", " |Y", "N|Y");
				InitDataCombo(0, "rd_flg", " |Y", "N|Y");
				
				InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789" );
			}
			break;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
		case IBSEARCH:          // 화면 조회 시
			sheetObj.WaitImageVisible = false;			
			ComOpenWait(true);
	
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_SQM_0509GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;
			
		case IBSAVE:          // 화면 저장 시 
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006"); //There is no data to save.
			    return false;
			} else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) { //Do you want to save?"
				return false;
			}
			ComOpenWait(true);
			
			formObj.f_cmd.value = MULTI;
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0509GS.do",FormQueryString(formObj) + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			
			ComOpenWait(false);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;
			
		case IBINSERT:          // Row Add 시
			var row = sheetObj.DataInsert();
			break;
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
        case IBSAVE:
            for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            	if ( sheetObj.CellValue(i , "cntr_tpsz_cd") == "" ) {
	                ComShowCodeMessage("SQM00013", "Container");
	                return false;
	            }
            }
            break;
    }
    return true;
}

/**
   * sheet1_onChange event
   */  
function sheet1_OnChange(sheetObj, row, col, value){
	sheetObj.WaitImageVisible = false;
	with(sheetObj){
		switch(ColSaveName(col)){
			case "rd_flg":
			case "spcl_tgt_cd":	
				if(CellValue(row, "rd_flg") == "Y" && CellValue(row, "spcl_tgt_cd") != "R"){
					ComShowCodeMessage("SQM00051");
					CellValue(row, "rd_flg") = "N";
				}

    		break;  
		}
	}
}

   
    

/* 개발자 작업  끝 */