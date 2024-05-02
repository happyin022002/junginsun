/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ees_cim_1062.js
 *@FileTitle : Location M/B by COA BKG(로케이션 팝업)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.17
 *@LastModifier : 박명신	
 *@LastVersion : 1.0		
 * 2011.03.17	
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
 * @class EES_CIM_1062 : EES_CIM_1062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_CIM_1062() {
	this.processButtonClick		= tprocessButtonClick;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.setSheetObject 		= setSheetObject;
	this.sheet1_OnChange        = sheet1_OnChange;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];


     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

    	    case "btn_Retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;

    	    case "btn_Ok":	
				doActionIBSheet(sheetObject,formObject,IBSAVE);
	            window.close();	
    	        break;
				
    	    case "btn_Close":					
	            window.close();			
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {	
    for(i=0;i<sheetObjects.length;i++){	
	    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i + 1);	
	    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);	
    }	
				
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
}	
	
/**	
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */	
function initSheet(sheetObj,sheetNo) {	

    var cnt = 0;
		
    switch(sheetNo) {
        case 1:      //sheet2 init
            with (sheetObj) {	
                SheetWidth = mainTable.clientWidth; //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);  //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msAll; //전체Merge 종류 [선택, Default msNone]
                Editable = true; //전체Edit 허용 여부 [선택, Default false]      
                InitRowInfo(2, 1, 9, 100); //행정보설정[필수] [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]     
                InitColumnInfo(6, 0, 0, true); //컬럼정보설정[필수]  [COLS,FROZENCOL,LEFTHEADCOLS=0,	FROZENMOVE=false]                     
                InitHeadMode(true, true, true, true, false,	false) // 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
                var HeadTitle  = "|Sel.|RCC|ECC|tree";	
                var HeadTitle1 = "||RCC|ECC|tree";   
                //해더행정보[필수] [ROW,HEADTEXT,	ROWMERGE=false, HIDDEN=false]
         															 									 																												 			    
            	InitHeadRow(0,  HeadTitle,  false);		
                InitHeadRow(1,  HeadTitle1, false);			
																			
                //데이터속성    [ROW, COL,  	    DATATYPE,    WIDTH,    DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, 	   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, 	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, 	cnt++ , dtHiddenStatus,	30,    daCenter,   false,    "ibflag");		
                InitDataProperty(0, 	cnt++ , dtCheckBox,   	30,    daCenter,   false,    "use_flg", 	false,          "",       	dfNone,       0,     		true,       	true);
                InitDataProperty(0, 	cnt++ , dtData,       	70,    daCenter,   true,    "rcc_cd",       false,         	"",      	dfNone,       0,     		false,       	true);
                InitDataProperty(0, 	cnt++ , dtData,       	70,    daCenter,   true,    "ecc_cd",       false,         	"",      	dfNone,       0,     		false,       	true);
                InitDataProperty(0,     cnt++ , dtHidden,       50,    daCenter,   true,    "ecc_lvl",      false,          "",        dfNone,       0,            false,         false);
                InitDataProperty(0,     cnt++ , dtHidden,       50,    daCenter,   true,    "usr_id",      false,          "",        dfNone,       0,            false,         false);
																																																		
                InitTreeInfo("ecc_cd", "ecc_lvl", RgbColor(0,0,255), false);	 		 		
                CountPosition  = 0;															
                style.height = GetSheetHeight(12);	
           }	
           break;	
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
 * Level에 따른 체크 즉, 상위 레벨 체크 시 자동으로 하위 레벨 체크
 */		
function sheet1_OnChange (sheetObj, row , col, value ){
	if(sheetObj.ColSaveName(col)  == "use_flg"){	
	    if(sheetObj.CellValue(row,"ecc_lvl") == 0) {
	        row++;		
	        while(sheetObj.CellValue(row,"ecc_lvl") == 1){		
	            sheetObj.CellValue2(row,"use_flg") = value;
	            row++;				
	        }	
	    }
	}	
}
	
/**
 * Sheet 관 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);					
			formObj.f_cmd.value = SEARCH;			
			sheetObj.DoSearch4Post("EES_CIM_1062GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;
			
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction))return false;
			// 업무처리중 버튼사용 금지 처리		
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);	
			formObj.f_cmd.value = MULTI;				
			var sParam = getSaveStringCustom(sheetObj);			
																						
	    	if(sParam == "" && sheetObj.IsDataModified){
				return;	
			}	
												
			if(!sheetObj.IsDataModified){
				return;	
			}				
			sParam += "&" + FormQueryString(formObj);	
			var sXml = sheetObj.GetSaveXml("EES_CIM_1062GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);	
			ComOpenWait(false);						
			break;		
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
    }
    return true;
}

/**
 * GetSaveString 구현 트리로 구현시 데이타가 이상하게 나옴
 */	
function getSaveStringCustom(sheetObj){
	var queryStr = "";
	for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
		
		if(sheetObj.RowStatus(i)=="U"){	
			queryStr += "ibflag=" + sheetObj.UrlEncoding(sheetObj.CellValue(i,"ibflag")) + "&";						
			queryStr += "use_flg=" + sheetObj.UrlEncoding(sheetObj.CellValue(i,"use_flg")) + "&";						
			queryStr += "rcc_cd=" + sheetObj.UrlEncoding(sheetObj.CellValue(i,"rcc_cd")) + "&";						
			queryStr += "ecc_cd=" + sheetObj.UrlEncoding(sheetObj.CellValue(i,"ecc_cd")) + "&";						
			queryStr += "ecc_lvl=" + sheetObj.UrlEncoding(sheetObj.CellValue(i,"ecc_lvl")) + "&";						
			queryStr += "usr_id=" + sheetObj.UrlEncoding(sheetObj.CellValue(i,"usr_id")) + "&";					
		}							
	}			
									
	if (queryStr != ""){
		 queryStr = queryStr.substr(0, queryStr.length - 1);
	}		    			
	return queryStr;				
} 

