/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0235.js
*@FileTitle : Agreement Rate Inquiry Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-17
*@LastModifier : pjy
*@LastVersion : 1.0
* 2010-05-17 pjy
* 1.0 최초 생성
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 구주 S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject   = sheetObjects[0]; 
  var cnt = 0;
  
  switch(sheetNo) {
  	case 1: //sheet0 init ( Child S/P )
	  with (sheetObj) {
		  // 높이 설정
		  style.height = GetSheetHeight(14);
		  //전체 너비 설정
		  SheetWidth = mainTable.clientWidth;
	
		  //Host정보 설정[필수][HostIp, Port, PagePath]
		  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
		  //전체Merge 종류 [선택, Default msNone]
		  MergeSheet = msHeaderOnly;
	
		  //전체Edit 허용 여부 [선택, Default false]
		  Editable = true;
	
		  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		  InitRowInfo( 2, 1, 9, 100);
	
		  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		  InitColumnInfo(6, 0, 0, true);
	
		  // 해더에서 처리할 수 있는 각종 기능을 설정한다
		  InitHeadMode(true, true, false, true, false,false)
	
		  var HeadTitle1 = "Equipment\nTYPE/SIZE|Basic Rate|Surchage|Surchage|Surchage|Surchage" ;
		  var HeadTitle2 = "Equipment\nTYPE/SIZE|Basic Rate|Fuel|Over Weight|Hazmat|Etc Total" ;
		  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		  InitHeadRow(0, HeadTitle1, true);
		  InitHeadRow(1, HeadTitle2, true);
	
		  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		  InitDataProperty(0, cnt++ , dtData,     70,  daCenter, true, "eq_tp_sz",    false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     80,  daRight, true, "bzc_rt",      false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     80,  daRight, true, "fuel_scg_rt", false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     80,  daRight,   true, "ow_scg_rt",   false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     80,  daRight,   true, "dg_scg_rt",   false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     80,  daRight, true, "ttl_scg_rt",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
	  }
  break;
  }
}

/**
* Sheet 기본 설정 및 초기화 
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
	}
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
}

/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var sheetObjects     = new Array();
var sheetCnt         = 0;

document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObject = sheetObjects[0];

    /*******************************************************/
    var formObject = document.form;

   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {
			case "btng_close":
    	        window.close();
    	        break;
			break;
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
       } else {
			ComShowMessage(e);
       }
   }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
	var formObject = document.form;

    switch(sAction) {       
       case IBSEARCH:
	   	    formObj.f_cmd.value = SEARCH01;
	   	    sheetObj.DoSearch4Post("ESD_TRS_0235GS.do", TrsFrmQryString(formObj));
			break;
    }
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}