﻿var sheetObjects = new Array();
var sheetCnt = 0;
var PageNo = 1 ;
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
			case "btns_calendar":
	            var cal = new ComCalendarFromTo();
	            cal.displayType = "date";
	            cal.select(form.arr_dt1,  form.arr_dt2,  'yyyy-MM-dd');
				break ;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
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
        case 1:      //IBSheet1 init
            with (sheetObj) {
            	//서버와의 연결시간이 초과하여 10분으로 설정을 한다.
            	sheetObj.RequestTimeOut = 600;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 50);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(5, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, true, false,false)

                var HeadTitle = "SEQ|Container|T/S|Train|Flat Car" ;

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,    "seq",     false,          "",       dfNone,   		0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,      250,    daCenter,  true,    "cntr_no",     false,          "",       dfNone,     	0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "cntr_tpsz_cd",     false,          "",       dfNone,     	0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,      150,    daCenter,  true,    "trn_no",     false,          "",       dfNone,     	0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "fcar_no",     false,          "",       dfNone,     	0,     true,       true);

                style.height = GetSheetHeight(16) ;
           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:	  //조회
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = SEARCHLIST ;
				sheetObj.DoSearch4Post("ESD_SCE_0046GS.do",  SceFrmQryString(formObj)+"&i_page=1");
				//IBS_EtcDataToForm2(formObj,sheetObj);
				}

			break;
		case IBDOWNEXCEL:		// excel down
			if(validateForm(sheetObj,formObj,sAction))
				sheetObj.SpeedDown2Excel();
				break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	var result = true ;
	
	switch(sAction) {
		case IBSEARCH:
			if(!ComIsDate(formObj.arr_dt1)){
		        ComShowMessage(ComGetMsg('SCE90003','Duration')) ;
		        formObj.arr_dt1.focus() ;
		        result = false ;
		    }
		    else if(!ComIsDate(formObj.arr_dt2)){
		        ComShowMessage(ComGetMsg('SCE90003','Duration')) ;
		        formObj.arr_dt2.focus() ;
		        result = false ;
		    }
		    else if(ComIsEmpty(formObj.trn_no) && ComIsEmpty(formObj.fcar_no)){
		    	ComShowMessage(ComGetMsg('COM12139','Train', 'Flat Car')) ;
		        formObj.trn_no.focus() ;
		        result = false ;
		    }
		    else if(!ComChkLenByByte(formObj.trn_no, 12)){
				ComShowMessage(ComGetMsg('COM12142', "Train", 12));
				result = false ;
			}
			else if(!ComChkLenByByte(formObj.fcar_no, 10)){
				ComShowMessage(ComGetMsg('COM12142', "Flat Car", 10));
				result = false ;
			}
			
	   		break ;
		default :
			break ; 
	}

	return result;
}


function sheet_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0046GS.do", selectVal, "i_page=" + PageNo, true);
    
}

