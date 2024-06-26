/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0203.js
 *@FileTitle : Tire Purchase Report by Supplier
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.10.05 민정호
 * 1.0 Creation
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
 * @class EES_MNR_0203 : EES_MNR_0203 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0203() {
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
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		
		case "btn_retrieve":
			doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			break;

		case "btn_new":
			doActionIBSheet(sheetObject1,formObject,IBCLEAR);
			break;

		case "btn_downexcel":
			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;

		case "btn_ofc_cd":
			ComOpenPopup("COM_ENS_071.do", 720, 450, 'setPopUpParam_COM_ENS_071', '1,0,1,1,1,1,1,1', true);
			break;				

		case "btn_sup_cd":
			ComOpenPopup("COM_ENS_0C1.do", 700, 450, 'setPopUpParam_COM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
			break;	   					

		case "cre_dt_cal":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
			break;					

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	initControl();
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}                   
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

function initControl() {       
	//Axon 이벤트 처리1. 이벤트catch  
	var formObject = document.form;       
	axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
}             

//Axon 이벤트 처리2. 이벤트처리함수   
function obj_deactivate(){      
	ComChkObjValid(event.srcElement); 
} 

function obj_activate(){   
	ComClearSeparator(event.srcElement);
}        

function obj_change(){	     
	var obj      = event.srcElement; 
	var formObj  = document.form; 
	var sheetObj = sheetObjects[0]; 

	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) {      
		case "ofc_cd":   
			doCheckOffice();
			break;   
		}       
	} 
}    

function obj_keypress(){   
	obj = event.srcElement;    
	keys = event.keyCode;
	if(obj.dataformat == null) return; 
	window.defaultStatus = obj.dataformat;
	var formObj  = document.form; 
	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) {      
		case "none":   

			break;   
		}       
	}				 			              
	
	switch(obj.dataformat) {   
	
	case "ymd":   
	case "int":       
		ComKeyOnlyNumber(obj); 
		break;     
	case "float":    
		ComKeyOnlyNumber(obj, "-.");
		break; 
	case "eng":   
		ComKeyOnlyAlphabet();
		break;   
	case "engup":  
		ComKeyOnlyAlphabet('uppernum');           
		break; 
	}         
}     

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
	
	case 1:      // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 380;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 3, 10, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(21, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)

			var HeadTitle = "|RHQ|Office|Supplier\nCode|Supplier\nName|Brand\nName|Curr||||||||||||";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,	"Status");
			InitDataProperty(0, cnt++ , dtData,				45,		daCenter,		false,	"rhq",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				45,		daCenter,		false,	"ofc",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,		daCenter,		false,	"sup_cd",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,		daLeft,			false,	"sup_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				60,		daLeft,			false,	"brand_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				35,		daCenter,		false,	"cur",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,				30,		daCenter,		false,	"type",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd01",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd02",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd03",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd04",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd05",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd06",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd07",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd08",		false,	"",		dfNumber,		0,			true,		true);   					
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd09",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd10",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd11",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd12",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd13",		false,	"",		dfNumber,		0,			true,		true);

			cnt = 0;
			InitDataProperty(1, cnt++ , dtHiddenStatus,		30,		daCenter,		false,	"Status");
			InitDataProperty(1, cnt++ , dtData,				45,		daCenter,		false,	"rhq",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtData,				45,		daCenter,		false,	"ofc",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtData,				60,		daCenter,		false,	"sup_cd",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtData,				60,		daLeft,			false,	"sup_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtData,				60,		daLeft,			false,	"brand_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtData,				35,		daCenter,		false,	"cur",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtData,				30,		daCenter,		false,	"type",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd01",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd02",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd03",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd04",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd05",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd06",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd07",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd08",		false,	"",		dfNumber,		0,			true,		true);   					
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd09",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd10",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd11",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd12",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(1, cnt++ , dtAutoSum,			100,	daRight,		false,	"cd13",		false,	"",		dfNumber,		0,			true,		true);

			cnt = 0;
			InitDataProperty(2, cnt++ , dtHiddenStatus,		30,		daCenter,		false,	"Status");
			InitDataProperty(2, cnt++ , dtData,				45,		daCenter,		false,	"rhq",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				45,		daCenter,		false,	"ofc",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				60,		daCenter,		false,	"sup_cd",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				60,		daLeft,			false,	"sup_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				60,		daLeft,			false,	"brand_nm",	false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				35,		daCenter,		false,	"cur",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				30,		daCenter,		false,	"type",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd01",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd02",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd03",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd04",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd05",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd06",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd07",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd08",		false,	"",		dfNumber,		0,			true,		true);   					
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd09",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd10",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd11",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd12",		false,	"",		dfNumber,		0,			true,		true);
			InitDataProperty(2, cnt++ , dtData,				100,	daRight,		false,	"cd13",		false,	"",		dfNumber,		0,			true,		true);
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	
	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction))
			if ( sheetObj.id == "sheet1"){
				formObj.f_cmd.value = SEARCH;     						
				sheetObj.DoSearch("EES_MNR_0203GS.do",FormQueryString(formObj));
			}
		break;

	case IBCLEAR:        //초기화
		MnrWaitControl(true);
		sheetObj.WaitImageVisible = false;

		//쉬트 초기화   
		for(i=0;i<sheetObjects.length;i++){   
			sheetObjects[i].RemoveAll();    
		}  			    

		formObj.ofc_cd.value = "";
		formObj.sup_cd.value = "";   
		formObj.sup_nm.value = "";   				

		formObj.from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
		MnrSetFromDate(formObj.from_dt,"TIRE");
		formObj.to_dt.value = ComGetNowInfo();

		sheetObj.WaitImageVisible = true;
		MnrWaitControl(false);   			    
		break;

	case IBDOWNEXCEL:
		sheetObj.SpeedDown2Excel(-1);   
		break;			    
	}
}

function doCheckOffice(){
	var checkOffice = document.form.ofc_cd.value;               

	retArray = MnrGeneralCodeCheck(sheetObjects[0],"OFC",checkOffice);      
	if(retArray == null){           
		ComShowCodeMessage("MNR00165",checkOffice,"OFFICE");       	
		document.form.ofc_cd.focus();
		document.form.ofc_cd.value="";                  
	}		
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if(sAction==IBSEARCH) {	  	    
			if(!MnrChkFromDate(formObj.from_dt,"TIRE")) return false;
		}  	 
	}
	return true;
}

function setPopUpParam_COM_ENS_071(array) {
	if(array == null)return;
	var formObj = document.form;
	var str = array + "";	
	var arr = str.split(',');

	formObj.ofc_cd.value = arr[3];
}   

/**
 * (Service Provider) Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index 
 */
function setPopUpParam_COM_ENS_0C1(aryPopupData, Row, Col, SheetIdx) {
	var formObj  = document.form;   

	if ( aryPopupData.length > 0 ) {
		formObj.sup_cd.value = aryPopupData[0][2];
		formObj.sup_nm.value  = aryPopupData[0][4];
	}
}    

/**
 * 조회후 처리
 */	
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	var row = sheetObj.RowCount;

	var HeadTitle1 = sheetObj.EtcData("TITLE");      
	HeadTitle1 = "|RHQ|Office|Supplier\nCode|Supplier\nName|Brand\nName|Curr||" + HeadTitle1;    	
	sheetObj.InitHeadRow(0, HeadTitle1, true);    	

	if(sheetObj.RowCount > 0){        		
		for(var i=0; i<21; i++){
			if(sheetObj.CellValue(0,i) == 'N'){
				sheetObj.ColHidden(i) = true;
			}
		}
		sheetObj.CellValue2(row+1,7) = "QTY";
		sheetObj.CellValue2(row+2,7) = "AMT";
		sheetObj.CellValue2(row+3,7) = "AVG";

		//AVG구한다.
		for(var j=8; j<21; j++){        			
			if(sheetObj.CellValue(row+1,j == 0)){
				sheetObj.CellValue2(row+3,j) = 0;        				
			}else{
				sheetObj.CellValue2(row+3,j) = sheetObj.CellValue(row+2,j) / sheetObj.CellValue(row+1,j);        				
				sheetObj.CellValue2(row+3,j) = Math.round(sheetObj.CellValue(row+3,j)*100)/100;
			}       			
		}    		
	}	    	    	
}
/* 개발자 작업  끝 */