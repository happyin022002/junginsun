﻿var sheetObjects = new Array();
var sheetCnt = 0;
var PageNo = 1 ;
document.onclick = processButtonClick;
function remoteOperation(r_row_size,r_cntr_no,r_toDate,r_fmDate){
	
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	
	loadPage();
	
	formObj.row_size.value = r_row_size;
	formObj.cntr_no.value  = r_cntr_no;
	formObj.arr_dt1.value  = r_toDate;
	formObj.arr_dt2.value  = r_fmDate;
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	try {

		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			/*2009-11-27 추가 전병석*/	
            case "btn_new":
            	sheetObj.removeAll();
            	formObj.reset();
            	//수동으로 리셋을 한다
            	formObj.arr_dt1.value  = "";
            	formObj.arr_dt2.value  = "";
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
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 2, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 10, 50);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "SEQ|F/M|Event|Current|Current|Current|Carrier|MD|Rail Origin|Rail Origin|Rail Destination|Rail Destination|Rail Destination|Train/Truck|Flat Car" ;
				var HeadTitle1 = "SEQ|F/M|Event|Location|State|Event Date|Carrier|MD|Location|State|Location|State|Description|Train/Truck|Flat Car" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				/*
				InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,  true,	"",	 false,		  "",	   dfNone,   		0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"",	 false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"",	 false,		  "",	   dfTimeHm,   	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
*/

				InitDataProperty(0, cnt++ , dtSeq,     30,	daCenter,  true,	"seq",	         false,		  "",	   dfNone,      0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"full_mty_cd",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"clm_sght_abbr_nm",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"loc_cd",	         false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"arr_ste_cd",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   120,	daCenter,  true,	"arr_date",	         false,		  "",	   dfNone,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"clm_crr_nm",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"trsp_mod_tp_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"fm_nod_cd",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"fm_ste_cd",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"to_nod_cd",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"to_ste_cd",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   150,	daCenter,  true,	"dep_loc_nm",	     false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"trn_no",	         false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"fcar_no",	         false,		  "",	   dfNone,	 	0,	 true,	   true);
				
				style.height = GetSheetHeight(16) ;
				RangeBackColor(1, 3, 1, 13) = RgbColor(222, 251, 248);   // ENIS
                //CountPosition = 0;
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
				sheetObj.DoSearch4Post("ESD_SCE_0043GS.do",  SceFrmQryString(formObj)+"&i_page=1");	
			
		        ComEtcDataToForm(formObj, sheetObj);//만들어진 ETC-DATA 를 화면단으로 불러 붙인다.				
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
			if(ComIsEmpty(formObj.cntr_no)){
				ComShowMessage(ComGetMsg('COM12114', "Container No"));
				formObj.cntr_no.focus() ;
				result = false ;
			}
			else if(!ComChkLenByByte(formObj.cntr_no, 14)){
				ComShowMessage(ComGetMsg('COM12142', "Container No", 14));
				result = false ;
			}
			else if(!ComIsDate(formObj.arr_dt1)){
		        ComShowMessage(ComGetMsg('COM12132','Duration')) ;
		        formObj.arr_dt1.focus() ;
		        result = false ;
		    }
		    else if(!ComIsDate(formObj.arr_dt2)){
		        ComShowMessage(ComGetMsg('COM12132','Duration')) ;
		        formObj.arr_dt2.focus() ;
		        result = false ;
		    }
			
	   		break ;
		default :
			break ; 
	}
	return result;
}


function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0043GS.do", selectVal, "i_page=" + PageNo, true);
}

function chkLenth(obj, len, msg) {
	var result = true ;
	
	if(ComGetLenByByte(obj.value)!= len){
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus() ;
        result = false ;
	}
	
	return result ;
}


function CheckDigit(obj){
    var rtnval = cntrCheckDigit(obj);
    obj.value  = rtnval;
}
