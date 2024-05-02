/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_COM_0010.js
*@FileTitle  : Movement Status Code Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1=sheetObjects[0];   
	/*******************************************************/
	var formObject=document.form;

	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
			case "btn_select":
				doActionIBSheet(sheetObject1,document.form,COMMAND01);
				break;
			case "btn_close":
				self.close(); 
				break;
			case "btn_New":
				sheetObject1.RemoveAll();
				formObject.reset();
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
//     	 axon_event.addListenerFormat('keypress', 'obj_keypress', form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
//       axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
 
function initControl() {
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
}

//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat) {
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
		case "number":
			ComKeyOnlyNumber(obj);
			break;
	}
}

function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1" :
			with (sheetObj) {
            	// 높이 설정			
				style.height = 261;
				
                //전체 너비 설정				
                SheetWidth = mainTable.clientWidth;			
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 5000);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                var HeadTitle="Sel|Sel|Code|Name|I/O Bound|Status||";
				var headCount=ComCountHeadTitle(HeadTitle);
				
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				
				//데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   	KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtRadioCheck,	30,    	daCenter,  	false,    	"radio",        	false,          "",       dfNone,	    0,     		true,       true);
            	InitDataProperty(0, cnt++ , dtCheckBox,  	30,    	daCenter,  	false,    	"checkbox",     	false,          "",       dfNone,   	0,     		true,       true);
            	InitDataProperty(0, cnt++ , dtData,      	80,    	daCenter,  	false,    	"mvmt_sts_cd",      false,          "",       dfNone,     	0,     		false,      true);
            	InitDataProperty(0, cnt++ , dtData,        330,    	daCenter,  	false,    	"mvmt_sts_nm",      false,          "",       dfNone,     	0,     		false,      true);
            	InitDataProperty(0, cnt++ , dtData,         80,    	daCenter,  	false,    	"io_bnd_cd",       	false,          "",       dfNone,     	0,     		false,      true);
            	InitDataProperty(0, cnt++ , dtData,         80,    	daCenter,  	false,    	"delt_flg",       	false,          "",       dfNone,     	0,     		false,      true);
            	InitDataProperty(0, cnt++ , dtHidden,       80,    	daCenter,  	false,    	"pagerows",       	false,          "",       dfNone,     	0,     		false,      true);
            	InitDataProperty(0, cnt++ , dtHidden,       80,    	daCenter,  	false,    	"ibflag",       	false,          "",       dfNone,     	0,     		false,      true);

            	CountFormat = "[SELECTDATAROW / TOTALROWS]";
			}
			break;
	} // end switch
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
		case IBSEARCH:      //조회
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("COM_COM_0010GS.do", FormQueryString(formObj) );
			}
			break;
		case COMMAND01:     // select 버튼 클릭시 처리
			comPopupOK();      // 호출자에게 매개변수값 전달.
			break;
	}
}