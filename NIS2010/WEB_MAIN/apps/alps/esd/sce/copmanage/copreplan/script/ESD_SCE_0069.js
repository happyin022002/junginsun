var sheetObjects = new Array();
var sheetCnt = 0;

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
			case "btn_new":
				doActionIBSheet(sheetObj,formObj,IBCLEAR);
				break;
    	    case "btns_calendar":
				//var cal = new calendarPopupFromTo();
        		//cal.select(formObj.act_dt1, 'act_dt1',formObj.act_dt2, 'act_dt2', 'yyyy-MM-dd');
				var cal = new ComCalendarFromTo();
				cal.displayType = "date";
				cal.select(formObj.act_dt1, formObj.act_dt2, 'yyyy-MM-dd');	
				
    	        break;
	        case "btn_so_rep":
				doActionIBSheet(sheetObj,formObj,IBDELETE);
				break;
			case "btn_man_rep":
				doActionIBSheet(sheetObj,formObj,IBBATCH);
				break;
			case "btn_cnfm":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;	
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
                InitColumnInfo(16, 7, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle0 = "|Replan Date|BKG No.|Bound|COP No.|Container No.|TP/SZ|COP Status|Sub Status|Office|Status|Pended|Replaned|Confirmed|Current Activity" ;
                var HeadTitle1 = "|Replan Date|BKG No.|Bound|COP No.|Container No.|TP/SZ|COP Status|Sub Status|Office|Status|Pended|Replaned|Confirmed|Current Activity" ;
			
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
                

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 30, 	  daCenter,  true, 	  "chk", 			false, 			"", 	  dfNone, 		0, 	   true, 		true);//check box
                InitDataProperty(0, cnt++ , dtData,	   90,    daCenter,  true,    "bkg_rcv_dt",     false,          "",       dfNone,		0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,	   90,    daCenter,  true,    "bkg_no",     	false,          "",       dfNone,     	0,     false,       true);
                //InitDataProperty(0, cnt++ , dtData,	   45,    daCenter,  true,    "BKG_NO_SPLIT",	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    50,    daCenter,  true,    "umch",     		false,          "",       dfNone,     	0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,	  100,    daCenter,  true,    "cop_no",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    90,    daCenter,  true,    "cntr_no",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    60,    daCenter,  true,    "cntr_tpsz_cd", 	false,          "",       dfNone, 		0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "cop_sts_cd",     false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "cop_sub_sts_cd", false,      	"",       dfNone,     	0,     false,       true);
                
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "bkg_ofc_cd",     false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "status",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "pnd",     		false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "rep_man",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,    "cfm_flg",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,    "cur_act",     	false,          "",       dfNone,     	0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,  10,    daCenter,  true,    "bkg_rcv_no",     false,          "",       dfNone,     	0,     true,       true);

                style.height = GetSheetHeight(16) ;
                
           }
            break;

    }
}

function sheet_OnDblClick(sheetObj, row, col, value) {
	openESD_SCE_0070(sheetObj);
}
function openESD_SCE_0070(sheetObj){

	var row = sheetObj.SelectRow  ;
	var r_copNo = sheetObj.CellValue(row, "cop_no") ;
	var r_bkgRcvNo = sheetObj.CellValue(row, "bkg_rcv_no") ;
	var r_bkgRcvDt = sheetObj.CellValue(row, "bkg_rcv_dt") ;
	var newWin  = window.open("ESD_SCE_0070.do?f_cmd=3&cop_no="+r_copNo+"&bkg_rcv_no="+r_bkgRcvNo+"&bkg_rcv_dt="+r_bkgRcvDt,"aaa", "width=960,height=350" );
}
 
  
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:	  //조회
            formObj.f_cmd.value = SEARCHLIST;
            formObj.target = "_self" ;
            sheetObj.DoSearch4Post("ESD_SCE_0069GS.do", SceFrmQryString(formObj));           
			break;
		case IBDOWNEXCEL:		// excel down
				sheetObj.SpeedDown2Excel();
			break;
		case IBCLEAR:	
				sheetObj.RemoveAll();
				formObj.reset();
			break;
		case IBDELETE:
			var ctrl_usr = formObj.ctrl_user_id.value;
			if ( ctrl_usr=="system1" || 
			ctrl_usr=="0110062" || ctrl_usr=="0210120" ){
					if( sheetObj.CheckedRows("chk") < 1 ) {
						ComShowMessage("Please select at least one.");
						return false;
					} else {
						if( confirm("Are you sure you want to proceed?") ) {
							formObj.f_cmd.value = MODIFY03;
							sheetObj.DoSave("ESD_SCE_0069GS.do", SceFrmQryString(formObj), "chk", false, true);
				            formObj.f_cmd.value = SEARCHLIST;
				            formObj.target = "_self" ;
				            sheetObj.DoSearch4Post("ESD_SCE_0069GS.do", SceFrmQryString(formObj));           							
						}
					}
			}			
			break;
		case IBBATCH:
			var ctrl_usr = formObj.ctrl_user_id.value;
			if ( ctrl_usr=="system1" || ctrl_usr=="0110062" || ctrl_usr=="0210120" ){
				if( sheetObj.CheckedRows("chk") < 1 ) {
					ComShowMessage("Please select at least one.");
					return false;
				} else {
					if( confirm("Are you sure you want to proceed?") ) {
						formObj.f_cmd.value = MODIFY01;
						sheetObj.DoSave("ESD_SCE_0069GS.do", SceFrmQryString(formObj), "chk", false, true);
						formObj.f_cmd.value = SEARCHLIST;
			            formObj.target = "_self" ;
			            sheetObj.DoSearch4Post("ESD_SCE_0069GS.do", SceFrmQryString(formObj));           						
					}
				}
			}			
			break;	
		case IBSAVE:
			var ctrl_usr = formObj.ctrl_user_id.value;
			if ( ctrl_usr=="system1" || ctrl_usr=="0110062" || ctrl_usr=="0210120" ){
				if( sheetObj.CheckedRows("chk") < 1 ) {
					ComShowMessage("Please select at least one.");
					return false;
				} else {
					if( confirm("Are you sure you want to proceed?") ) {
						formObj.f_cmd.value = MODIFY02;
						sheetObj.DoSave("ESD_SCE_0069GS.do", SceFrmQryString(formObj), "chk", false, true);
						formObj.f_cmd.value = SEARCHLIST;
			            formObj.target = "_self" ;
			            sheetObj.DoSearch4Post("ESD_SCE_0069GS.do", SceFrmQryString(formObj));           
					}
				}
			}			
			break;				
	}
}

function validateForm(formObj){
	var result = true ;
	
	with(formObj){
		if(!ComIsDate(formObj.act_dt1)){
	        ComShowMessage(ComGetMsg('SCE90003','Duration')) ;
	        formObj.act_dt1.focus() ;
	        result = false ;
	    }
	    else if(!ComIsDate(formObj.act_dt2)){
	        ComShowMessage(ComGetMsg('SCE90003','Duration')) ;
	        formObj.act_dt2.focus() ;
	        result = false ;
	    }
	}

	return result;
}

function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0046GS.do", selectVal, "cur_page=" + PageNo, true);
}
