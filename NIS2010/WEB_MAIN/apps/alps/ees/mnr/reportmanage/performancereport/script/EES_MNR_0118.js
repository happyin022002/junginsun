/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0118.js
 *@FileTitle : MNR PFMC by EQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.12
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.10.12 민정호
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
 * @class EES_MNR_0118 : EES_MNR_0118 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0118() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// TS타입일 경우 타입사이즈 배열 eq_type 별 3가지 모두 틀림
var uTpSz = new Array();
var gTpSz = new Array();
var zTpSz = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_New":
			doActionIBSheet(sheetObject, formObject, IBCLEAR);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_calendar":  
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
			break;
		case "btn_provider_popup":
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp','1,0,1,1,1,1,1,1', true);
			break;
			
		//Calendar From PopUP
		case "manu_yr_fr_cal":
			var cal = new ComCalendar();
			cal.setDisplayType('year');
			cal.select(formObject.manu_yr_fr, 'yyyy');
            break;

		//Calendar To PopUP
		case "manu_yr_to_cal":
			var cal = new ComCalendar();
			cal.setDisplayType('year');
			cal.select(formObject.manu_yr_to, 'yyyy');
            break;
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
 * IBCombo Object를 배열로 등록
 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj){    
	comboObjects[comboCnt++] = combo_obj;  
} 

/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	initControl();  	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1, '');   
		ComEndConfigSheet(sheetObjects[i]);
	}
   
   //IBMultiCombo초기화 
   for(var k=0;k<comboObjects.length;k++){ 
       initCombo(comboObjects[k],k + 1);  
   }			
   
   //타입사이즈는 처음 한번만 가져온다.		
   setTpSzArray(sheetObjects[0]); 	 
   doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
 

/**   
 * Combo 기본 설정    
 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */     
function initCombo (comboObj, comboNo) {        
    var formObject = document.form
    switch(comboNo) {          	    
        case 1: 
			with (comboObj) { 
   	   			SetColAlign("left");        
	       		SetColWidth("80");      
		   		DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
        case 2: 
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Period|Amount");	
				SetColAlign("left|left");		        
				SetColWidth("100|100");			     
				DropHeight = 160;		         
				UseAutoComplete = true;
			}      
        	break;	
        case 3:
           	with (comboObj) { 
           		MultiSelect = true; 
   	   			SetColAlign("left");        
	       		SetColWidth("80");      
		   		DropHeight = 160;  
				UseAutoComplete = true;
	    	}	
        	break;
        case 4: 
           	with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				SetColAlign("left");
				SetColWidth("100");  
				DropHeight = 200;
		    }          
        	break;     	        	
        case 5: 
           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
	   	   		SetColAlign("left|left");        
				//SetColWidth("100|150"); 
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;    
        case 6: 
           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
	   	   		SetColAlign("left|left");        
				//SetColWidth("100|150");
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
		 case 7:	
		 	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("180");  
					DropHeight = 200;
					ValidChar(2,3);   
			}	
			break;	
      } 
}     

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,sheetHeadTitle) {
    var cnt = 0;
	var sheetID = sheetObj.id;
							
    switch(sheetID) {   	 	
        case "sheet1":
            with (sheetObj) {	
                // 높이 설정
                style.height = 380;	
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 3, 10, 100);
					
                var HeadTitle1 = "|RHQ|Office|S/P Code|S/P Name|||||||||||||||||||||||||||||||";                        

				if(MnrNullToBlank(sheetHeadTitle) != ""){ 
					HeadTitle1 = sheetHeadTitle; 
				} 
				 
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(37, 7, 0, true);
 				
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"iflag");                
                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"rhq");
                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd");
                InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"sp_cd");                        
				InitDataProperty(0, cnt++ , dtData,		    230,	daLeft,		true,		"sp_nm");
				InitDataProperty(0, cnt++ , dtData,			40, 	daCenter,	true,		"curr_cd");
				InitDataProperty(0, cnt++ , dtData,			40, 	daCenter,	true,		"dcol");
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts01",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts02",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts03",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts04",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts05",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts06",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts07",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts08",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts09",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts10",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts11",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts12",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts13",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts14",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts15",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts16",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts17",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts18",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts19",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts20",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts21",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts22",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts23",		 	false,		"",			dfNullFloat,		2,		true,		true);    												
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts24",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts25",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts26",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts27",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts28",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts29",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(0, cnt++ , dtAutoSum,60,	daRight,	false,		"ts30",		 	false,		"",			dfNullFloat,		2,		true,		true);
				
				cnt = 0;
                InitDataProperty(1, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"iflag");
                InitDataProperty(1, cnt++ , dtData,			60,		daCenter,	true,		"rhq");
                InitDataProperty(1, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd");
                InitDataProperty(1, cnt++ , dtData,			60,		daCenter,	true,		"sp_cd");                        
				InitDataProperty(1, cnt++ , dtData,		    230,	daLeft,		true,		"sp_nm");
				InitDataProperty(1, cnt++ , dtData,			40, 	daCenter,	true,		"curr_cd");
				InitDataProperty(1, cnt++ , dtData,			40, 	daCenter,	true,		"dcol");
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts01",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts02",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts03",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts04",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts05",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts06",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts07",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts08",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts09",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts10",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts11",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts12",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts13",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts14",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts15",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts16",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts17",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts18",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts19",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts20",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts21",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts22",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts23",		 	false,		"",			dfNullFloat,		2,		true,		true);  
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts24",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts25",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts26",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts27",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts28",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts29",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(1, cnt++ , dtAutoSum,60,	daRight,	false,		"ts30",		 	false,		"",			dfNullFloat,		2,		true,		true);				

				cnt = 0;
                InitDataProperty(2, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"iflag");
                InitDataProperty(2, cnt++ , dtData,			60,		daCenter,	true,		"rhq");
                InitDataProperty(2, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd");
                InitDataProperty(2, cnt++ , dtData,			60,		daCenter,	true,		"sp_cd");                        
				InitDataProperty(2, cnt++ , dtData,		    230,	daLeft,		true,		"sp_nm");
				InitDataProperty(2, cnt++ , dtData,			40, 	daCenter,	true,		"curr_cd");
				InitDataProperty(2, cnt++ , dtData,			40, 	daCenter,	true,		"dcol");
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts01",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts02",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts03",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts04",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts05",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts06",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts07",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts08",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts09",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts10",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts11",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts12",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts13",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts14",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts15",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts16",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts17",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts18",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts19",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts20",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts21",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts22",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts23",		 	false,		"",			dfNullFloat,		2,		true,		true);
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts24",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts25",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts26",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts27",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts28",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts29",		 	false,		"",			dfNullFloat,		2,		true,		true);    					
				InitDataProperty(2, cnt++ , dtAutoSum,60,	daRight,	false,		"ts30",		 	false,		"",			dfNullFloat,		2,		true,		true);									
			}				
            break;
    }
}

//Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj, formObj, sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
 		case IBSEARCH:      //조회
 			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = SEARCH;
				//USD Only
				if(formObj.check_usd_only.checked){
					formObj.curr_cd.value = "Y"; 
				} else {	
					formObj.curr_cd.value = "N";  
				}
				//Warranty
				if(formObj.check_warranty.checked){
					formObj.mnr_warr_flg.value = "Y"; 
				} else {	
					formObj.mnr_warr_flg.value = "N";  
				}	
				var sXml = sheetObj.GetSearchXml("EES_MNR_0118GS.do",FormQueryString(formObj));
				var headTitle1 = ComGetEtcData(sXml,"TITLE"); 
				headTitle1 = "|RHQ|Office|S/P Code|S/P Name|Curr||" + headTitle1;
				
				sheetObj.Reset(); 
				initSheet(sheetObj,1,headTitle1); 						
						 
				sheetObj.LoadSearchXml(sXml);									     
			    	           
				if(formObj.report_type.Code == "OF"){ 
					sheetObj.ColHidden("sp_cd") =  true;  	
					sheetObj.ColHidden("sp_nm") =  true;  	
				} else {   
					sheetObj.ColHidden("sp_cd") =  false; 	
					sheetObj.ColHidden("sp_nm") =  false; 
				}			
	 
				  					 									
				for(var i = 0; i < 37; i++){
					if(sheetObj.CellValue(0,i) == 'N'){ 
						sheetObj.ColHidden(i) = true;
					}				
				}		
					
				var row = sheetObj.RowCount;		
				var col = 3;						
	
				if(sheetObj.RowCount > 0){ 
					//USD Only checked
					if(formObj.check_usd_only.checked){
						sheetObj.RowHidden(row + 1) = false;
						sheetObj.RowHidden(row + 2) = false;
						sheetObj.RowHidden(row + 3) = false;

						sheetObj.CellValue2(row + 1,6) = "QTY";
						sheetObj.CellValue2(row + 2,6) = "AMT";
						sheetObj.CellValue2(row + 3,6) = "AVG";        		
						
						//AVG구한다.
						var j = 7;
						for(var j = 7; j < 37; j++){        			
							if(sheetObj.CellValue(row + 1,j) == 0){ 
								sheetObj.CellValue2(row + 3,j) = 0;         				
							}else{
								//sheetObj.CellValue2(row + 3,j) = sheetObj.CellValue(row + 3,j) / sheetObj.CellValue(row + 2,j);        				
								//sheetObj.CellValue2(row + 3,j) = Math.round(sheetObj.CellValue(row + 4,j)*100)/100;
								
								//2010-02-02 : (TOTAL)AVG 값이 모두 0  으로 나와 재계산함.
								var avg1 = sheetObj.CellValue(row + 2,j) / sheetObj.CellValue(row + 1,j);	// (TOTAL)AMT / (TOTAL)QTY
								var avg2 = Math.round(avg1*100)/100;										// 소수2자리까지 반올림
								sheetObj.CellValue2(row + 3,j) =  avg2; 				
							} 	      			
						}
					} else {
						sheetObj.RowHidden(row + 1) = true;
						sheetObj.RowHidden(row + 2) = true;
						sheetObj.RowHidden(row + 3) = true;
					}
					
				} 		
				//sheetObj.DoSearch("EES_MNR_0118GS.do",FormQueryString(formObj));
 			}		
 			break;

 		case IBCLEAR:        //초기화
 			MnrWaitControl(true);
 		    sheetObj.WaitImageVisible = false;
			
			//쉬트 초기화   
 			for(i=0;i<sheetObjects.length;i++){   
 				sheetObjects[i].RemoveAll();    
 	        }  
			
			//콤보 초기화 
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].RemoveAll();       
			}  			
			
			//공통콤보 정보를 가져온다.    
			var sCondition = new Array ( 
				new Array("MnrGenCd","","CUSTOM9"), 
				new Array("MnrGenCd","CD00057", "COMMON"),
				new Array("MnrGenCd","CD00055", "COMMON"),
				new Array("MdmOrganization","RHQ","FALSE"),
				new Array("MnrGenCd","CD00084", "COMMON")
			)
				
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
			
			//EQ Type   
			formObj.eq_type.InsertItem(0,"ALL","A");
			
			var defEqType = "";
			if(comboList[0] != null){	       
				for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|");   
					formObj.eq_type.InsertItem(j + 1, tempText[1] ,tempText[0]);
//					if(j == 0){
//						defEqType = tempText[0];
//					}
				} 			    	    
			}	 	    		
			formObj.eq_type.Code = "A"; 	
			
			//Report Type
			if(comboList[1] != null){	       
				for(var j = 0; j < comboList[1].length;j++){ 
					var tempText = comboList[1][j].split("|");   
					formObj.report_type.InsertItem(j, tempText[1] ,tempText[0]);
				}     	    
			}     
			formObj.report_type.Code = "SP"; 
			 
			//Report Type Period
			if(comboList[2] != null){	       
				for(var j = 0; j < comboList[2].length;j++){ 
					var tempText = comboList[2][j].split("|");  
					tempText[1] =  tempText[1] + '|' + 'WO Amt';
					   
					formObj.report_period_type.InsertItem(j, tempText[1] ,tempText[0]);
				}     	    
			}     
			formObj.report_period_type.Code = "WI";	
								
			//Regional HQ  
			formObj.rhq.InsertItem(0,"ALL","A");	
			if(comboList[3] != null){		       
				for(var j = 0; j < comboList[3].length;j++){	 
					var tempText = comboList[3][j].split("|"); 	 
					formObj.rhq.InsertItem(j + 1, comboList[3][j] ,tempText[0]);
				}     	    
			}	
			formObj.rhq.Code = "A"; 
						
			//EQ Term	 
			formObj.lstm_cd.InsertItem(0,"ALL","A");			
			if(comboList[4] != null){		       
				for(var j = 0; j < comboList[4].length;j++){	 
					var tempText = comboList[4][j].split("|"); 	 
					formObj.lstm_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}     	    
			}	
			
            var HeadTitle1 = "|RHQ|Office|S/P Code|S/P Name|Curr|||||||||||||||||||||||||||||||";  	
 		  	sheetObj.InitHeadRow(0, HeadTitle1, true); 			
 			
			//초기값 세팅 		
			formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
			MnrSetFromDate(formObj.fm_dt);	
 			formObj.to_dt.value = ComGetNowInfo(); 
 			formObj.vndr_seq.value = "";
 			formObj.vndr_lgl_eng_nm.value = "";
 			formObj.check_usd_only.checked = true;
 			formObj.check_warranty.checked = false;
 			
 			sheetObj.WaitImageVisible = true;	
 			MnrWaitControl(false); 	 				
 			break;
			
		case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				if(Number(formObj.vndr_seq.value)){
					//서비스 프로바이더 조회     		
					var sCondition = new Array ( 		 
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
					)  	                           
					//조회 값이 있다면 세팅	
					var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
					if(comboList[0] != null){  	
						var tempText = comboList[0][0].split("|");  
						formObj.vndr_lgl_eng_nm.value  = tempText[1];   
					} else {        
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
						ComSetObjValue(formObj.vndr_seq, "");   
						ComSetFocus(formObj.vndr_seq); 	 
					} 	 
				} else {        
					ComShowCodeMessage("MNR00005", "Service Provider");              
					ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
					ComSetObjValue(formObj.vndr_seq, "");   
					ComSetFocus(formObj.vndr_seq); 	 
				} 	 
			}		
			break;
			
 		case IBDOWNEXCEL:
 		    sheetObj.Down2Excel(-1);   
 			break;	  				
     }
 }
  
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		//조회시
		if(sAction==IBSEARCH){
			if(!MnrChkFromDate(formObj.fm_dt)) return false;
			//EQ ManuFacturing Period
			var manuYrFr = formObj.manu_yr_fr.value;
			var manuYrTo = formObj.manu_yr_to.value;
			var manuYrFrLen = manuYrFr.length;
			var manuYrToLen = manuYrTo.length;
			if((manuYrFrLen==0 && manuYrToLen!=0) || (manuYrFrLen!=0 && manuYrToLen==0)) {
				ComShowCodeMessage("MNR00162");
				formObj.manu_yr_fr.focus();
				return false;
			}
			if(manuYrTo - manuYrFr < 0){
				ComShowCodeMessage("MNR00162");
				formObj.manu_yr_fr.focus();
				return false;
			}
		}
	}
	return true;
}

 
 /**  
 * rhq Change 이벤트		      
 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  	
function rhq_OnChange(comboObj,Index_Code, Text){
	sheetObjects[0].WaitImageVisible = false;
	
	var formObj  = document.form;
	formObj.ofc_cd.RemoveAll();	
	var sCondition = new Array ( 
		new Array("MdmOrganization","SEARCH",Index_Code) 
	)
	var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
	if(comboList[0] != null){      
		for(var j = 0; j < comboList[0].length;j++){  
			var tempText = comboList[0][j].split("|");  
			formObj.ofc_cd.InsertItem(j,comboList[0][j] ,tempText[0]);
		}             
	}    
	formObj.ofc_cd.InsertItem(0,"ALL","A");     
	formObj.ofc_cd.Code = "A";
	
	sheetObjects[0].WaitImageVisible = true;  
} 	
	        		        
/**  
 * combo_eq_type_cd Change 이벤트      
 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  
function eq_type_OnChange(comboObj,Index_Code, Text){ 
	var formObj  = document.form;        
	//--------------------------------------
	var comboValue = comboObj.Code; 		   
		
	formObj.tp_sz_cd.RemoveAll();	
	var selTpSz = new Array();	
	if(comboValue == "U"){	
		selTpSz = uTpSz;	  	
	} else if(comboValue == "G"){
		selTpSz = gTpSz; 
	} else if(comboValue == "Z"){
		selTpSz = zTpSz;   
	}  		
	
	//디폴트로 올삽입
	if(selTpSz.length == 0){
		formObj.tp_sz_cd.Enable = false;		//tp_sz_cd
	}else{
		formObj.tp_sz_cd.Enable = true;			//tp_sz_cd 	 		
		formObj.tp_sz_cd.InsertItem(0,"ALL","A");   		
		for(var i = 1;i < (selTpSz.length + 1);i++){               
			formObj.tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
		}
	}
} 
 
//멀티콤보 클릭 이벤트	
function eq_type_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);    		  
}
	
//멀티콤보 클릭 이벤트
function tp_sz_cd_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);    		  
}	

//멀티콤보 클릭 이벤트
function lstm_cd_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);	    		  
}	 
	
function setTpSzArray(sheetObj){ 
	var arrXml = MnrComSearchGrid2(sheetObj,"ACTTypeSize");
		 
	if(arrXml != null){          
	    for(var i = 0; i < arrXml.length; i++){   
			if(i == 0){	       
				uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
			} else if(i == 1){	  
				zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");  
			} else if(i == 2){	    
				gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
			}	  	 
	    }	  	 
	}						
}	 		   	

/**
 * (Service Provider) Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index 
 */
function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
	var formObj  = document.form;   
		
	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value = aryPopupData[0][2];
		formObj.vndr_lgl_eng_nm.value  = aryPopupData[0][4];
	}
}	
  
/**
* 조회후 처리
*/		
function sheet1_OnSearchEnd(sheetObj,ErrMsg){                  
	if (ErrMsg != "") {    
		ComShowCodeMessage("MNR00057","MNR PFMC by EQ");	
	}				     	        	                	
} 	
  
function initControl() { 	      
    //Axon 이벤트 처리1. 이벤트catch  
    axon_event.addListenerForm  ('blur', 'obj_deactivate',  	form); 			      //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_activate',     form);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListenerFormat('change',	 'obj_change',		form); 	  //- 변경될때.
}           
									    
/**
 * HTML Control의 deactivate 이벤트 <br>
 **/
function obj_deactivate(){  	  		
	obj = event.srcElement;      		 
    ComChkObjValid(event.srcElement);	 
} 
	
/**
 * HTML Control의 activate 이벤트 <br>
 **/
function obj_activate(){   				
    ComClearSeparator(event.srcElement);
}  
 	 
function obj_change(){	    			 
	var obj      = event.srcElement; 
	var formObj  = document.form; 	
	var sheetObj = sheetObjects[0]; 
	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) { 	      
    		case "vndr_seq":	 	 
				formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");  
        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
			   	break;	       
		}       
    } else {	
		switch(obj.name) {      
    		case "vndr_seq":     
				ComSetObjValue(formObj.vndr_lgl_eng_nm,"") 
			   	break;   	
		}  		
	}
} 
	 
/**
 * HTML Control의 keypress 이벤트 <br>
 **/     
function obj_keypress(){     
    obj = event.srcElement;    
    if(obj.dataformat == null) return; 
    window.defaultStatus = obj.dataformat;
		              
    switch(obj.dataformat) {  
        case "ymd":   
        case "int":    
        case "yyyy":   
			ComKeyOnlyNumber(obj); 
            break;     
        case "float":   
            ComKeyOnlyNumber(obj, ".");
            break; 
        case "eng":   
            ComKeyOnlyAlphabet();
			break;   
        case "engup": 
			ComKeyOnlyAlphabet('uppernum');  
	        break;	  
    }
} 
/* 개발자 작업  끝 */