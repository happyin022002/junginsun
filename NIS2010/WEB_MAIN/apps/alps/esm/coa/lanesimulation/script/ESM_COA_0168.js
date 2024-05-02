/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0168.js
*@FileTitle : LaneSimulation >> Step4 >> Creation (Variant Change) POPUP
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.1
* 2009-03-12 Ari
* 1.0 최초 생성
* =========================================================
* History
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.07.20 윤진영 Alps전환작업
* 2009.09.30 [CHM-200900907]신규REPORT 등록 시 AA001로 등록불가 처리
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
=========================================================*/

// 공통전역변수
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

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

			case "btn_creation":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;

			case "btn_close":
			    opener.setVal_f_sim();
				window.close();
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/*화면이 로드 되면서 바로 retrieve 되도록 */
function setRetrieveAction(){
	sheetObject = sheetObjects[0];
	formObject = document.form;
	var rptCnt = parseInt(formObject.f_reportMasterCount.value);

	if(rptCnt > 0) {//기존 레포트가 있는 경우 조회
	   doActionIBSheet(sheetObject,formObject,IBSEARCH);
	} else { //없는 경우 생성 후 조회
	    doActionIBSheet(sheetObject,formObject,COMMAND01);
	    //조회 후 부모창의 Report No.새로 세팅
	    //opener.setVal_f_sim();
	    sheetObject.focus();
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
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i]);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, cnTS) {
	var cnt = 0;
	with (sheetObj) {

	SheetWidth = mainTable.clientWidth;						        //전체 너비 설정
	if (location.hostname != "")
		InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
	MergeSheet = msPrevColumnMerge;									//전체Merge 종류 [선택, Default msNone]
	Editable = true;												//전체Edit 허용 여부 [선택, Default false]
	InitRowInfo( 1, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	InitColumnInfo(12, 0, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	InitHeadMode(false, false, false, true, false,false)		    //([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

	var HeadTitle0 = "H|H|Simulation No|H|Report No.|R.Lane|Dir|L/F (%)|RPB (USD)|Bunker  \n(USD/Ton)|Remark|" ;
	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	InitHeadRow(0, HeadTitle0, true);

	//sim_dt, sim_no, sect_no, sim_rpt_no, trd_cd, rlane_cd, skd_dir_cd, ldf_rto, grs_rpb_rev, bnk_cost_amt, sim_rmk
	//데이터속성[row,col,			datatype,	   width,	dataalign,	colmerge,  savename,			keyfield,	calculogic,	dataformat,	pointcount,	 updateedit,	insertedit,	editlen,fullinput,sortenable,tooltip,allcheck,savestatus,formatfix]
	InitDataProperty(0,cnt++,	dtHidden,	      70,	daCenter,	  true,      "sim_dt",  false,		"",		dfNone,		0,		true,		true);
	InitDataProperty(0,cnt++,	dtHidden,	      70,	daCenter,	  true,      "sim_no",  false,		"",		dfNone,		0,		true,		true);
	InitDataProperty(0,cnt++,	dtData,			   140, daCenter,	  true,      "simulation_no",true,	"",		dfNone,		0,		false,		false);
	InitDataProperty(0,cnt++,	dtHidden,		    50,	daCenter,	  true,      "sect_no",  false,	"",		dfNone,		0,		false,		false);
	InitDataProperty(0,cnt++,	dtData,		      70,	daCenter,	  true,      "sim_rpt_no",  false,	"",		dfNone,		0,		true,		true);
	InitDataProperty(0,cnt++,	dtData,		      50,	daCenter,	  true,      "rlane_cd",  false,	"",		dfNone,		0,		false,		false);
	InitDataProperty(0,cnt++,	dtData,		      30,	daCenter,	  true,      "skd_dir_cd",  false,	"",		dfNone,		0,		false,		false);
	InitDataProperty(0,cnt++,	dtData,		      60,	daCenter,	  true,      "ldf_rto",  false,	"",		dfFloatOrg,	2,		true,		true);
	InitDataProperty(0,cnt++,	dtData,		      60,	daCenter,	  true,      "grs_rpb_rev",  false,"",		dfFloatOrg,	2,		true,		true);
	InitDataProperty(0,cnt++,	dtData,		      60,	daCenter,	  true,      "bnk_cost_amt",  false,"",	dfFloatOrg,	2,		true,		true);
	InitDataProperty(0,cnt++,	dtData,		     120, daLeft,	    true,      "sim_rmk",  false,	"",		dfNone,		0,		true,		true);
	InitDataProperty(0,cnt++,	dtHiddenStatus,	30,	daCenter,	  true,	     "ibFlag", false);

	CountPosition  = 0 ;
	RangeBackColor(1, 4, 1, 11) = RgbColor(222, 251, 248);// ENIS
	style.height = GetSheetHeight(12) ;
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSEARCH:		//조회
			if(validateForm(sheetObj,formObj,sAction)) {
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			formObj.f_cmd.value = SEARCHLIST;
    			sheetObj.DoSearch4Post("ESM_COA_0168GS.do", coaFormQueryString(formObj));
    			ComOpenWait(false);
			}
			break;

		case COMMAND01:// 최초 생성
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI02;
			    sheetObj.DoSearch4Post("ESM_COA_0168GS.do", coaFormQueryString(formObj));//
			    ComOpenWait(false);
			    opener.setVal_f_sim();

			}
			break;

		case IBSAVE://저장
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
			    sheetObj.DoSave("ESM_COA_0168GS.do", coaFormQueryString(formObj));//
			    opener.setVal_f_sim();
			    ComOpenWait(false);
			}
			break;

		case IBINSERT:			// 입력
			sheetObj.DataInsert();
			break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
			if (sAction==IBSAVE) {
			    var idx = sheetObj.FindText("sim_rpt_no", "");
                if(idx > 0) {
                    ComShowMessage(ComGetMsg("COA10002","Simulation No"));
                    sheetObj.SelectCell(idx, "sim_rpt_no");
                    return false;
                }
			}
	}

	return true;
}

function sheet_OnChange(sheetObj, row, col, value){
    var rptNoCnt = 0;
    for(var i=sheetObj.HeaderRows;i<=sheetObj.RowCount;i++) {
        if(sheetObj.CellValue(i, "sim_rpt_no")==value) {
            rptNoCnt++;
        }
    }
    if(rptNoCnt > 2) {
        sheetObj.CellValue(row, "sim_rpt_no")="";
    }
    return;
}

function sheet_OnSearchEnd(sheetObj, errMessge){
    var before_sim_rpt_no = "";
    var current_sim_rpt_no = "";
    var exist_rpt = "";
    var add_cnt = 0;
    var start_idx = sheetObj.HeaderRows
    var total_idx = sheetObj.RowCount;

    //동일한 sim_rpt_no를 가진 ROW 수를 센다.
    for(var m=start_idx; m<=total_idx; m++){
        current_sim_rpt_no = sheetObj.CellValue(m, "sim_rpt_no");
        if((before_sim_rpt_no == current_sim_rpt_no
            || before_sim_rpt_no == "")) {
            before_sim_rpt_no = current_sim_rpt_no;
            ++add_cnt;
        }
        //else break;
        sheetObj.CellEditable(m, "sim_rpt_no") = false;  //기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.CellEditable(m, "ldf_rto") = false;  //기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.CellEditable(m, "grs_rpb_rev") = false;  //기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.CellEditable(m, "bnk_cost_amt") = false;  //기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.CellEditable(m, "sim_rmk") = false;  //기존 데이터의 ReportNo는 바꾸지 못하게 처리
    }

    //ROW를 INSERT한 후 sim_rpt_no를 제외하고 값을 복사해서 넣어준다.
    for(var m=start_idx; m<=add_cnt; m++){
        sheetObj.DataInsert(-1);
        for(k=0; k<12; k++){
            if(k != 4) sheetObj.CellValue2(-1, k) = sheetObj.CellValue(m, k);
        }
    }


}