/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_168.jsp
*@FileTitle  : Creation (Variant Change)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			case "btn_creation":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;
			case "btn_close":
			    opener.setVal_f_sim();
			    ComClosePopup(); 
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/*화면이 로드 되면서 바로 retrieve 되도록 */
function setRetrieveAction(){
	sheetObject=sheetObjects[0];
	formObject=document.form;
	var rptCnt=parseInt(formObject.f_reportMasterCount.value);
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
	sheetObjects[sheetCnt++]=sheet_obj;
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
	var cnt=0;
    with(sheetObj){
      var HeadTitle0="H|H|Simulation No|H|Report No.|R.Lane|Dir|L/F (%)|RPB (USD)|Bunker  \n(USD/Ton)|Remark|" ;

      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle0, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sim_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sim_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"simulation_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sect_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sim_rpt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ldf_rto",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"grs_rpb_rev",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bnk_cost_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"sim_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibFlag",         KeyField:0 } ];
       
      InitColumns(cols);

      SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
      SetRangeBackColor(1, 4, 1, 11,"#DEFBF8");// ENIS
      SetSheetHeight(ComGetSheetHeight(sheetObj, 12));

	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:		//조회
			if(validateForm(sheetObj,formObj,sAction)) {
				// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
    			formObj.f_cmd.value=SEARCHLIST;
     			sheetObj.DoSearch("ESM_COA_0168GS.do", coaFormQueryString(formObj) );
    			ComOpenWait(false);
			}
			break;
		case COMMAND01:// 최초 생성
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI02;
 			    sheetObj.DoSearch("ESM_COA_0168GS.do", coaFormQueryString(formObj) );
			    ComOpenWait(false);
			    opener.setVal_f_sim();
			}
			break;
		case IBSAVE://저장
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
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
			    var idx=sheetObj.FindText("sim_rpt_no", "");
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
    var rptNoCnt=0;
    for(var i=sheetObj.HeaderRows();i<=sheetObj.RowCount();i++) {
if(sheetObj.GetCellValue(i, "sim_rpt_no")==value) {
            rptNoCnt++;
        }
    }
    if(rptNoCnt > 2) {
        sheetObj.SetCellValue(row, "sim_rpt_no","");
    }
    return;
}
function sheet_OnSearchEnd(sheetObj, errMessge){
    var before_sim_rpt_no="";
    var current_sim_rpt_no="";
    var exist_rpt="";
    var add_cnt=0;
    var start_idx=sheetObj.HeaderRows()
    var total_idx=sheetObj.RowCount();
    //동일한 sim_rpt_no를 가진 ROW 수를 센다.
    for(var m=start_idx; m<=total_idx; m++){
current_sim_rpt_no=sheetObj.GetCellValue(m, "sim_rpt_no");
        if((before_sim_rpt_no == current_sim_rpt_no
            || before_sim_rpt_no == "")) {
            before_sim_rpt_no=current_sim_rpt_no;
            ++add_cnt;
        }
        //else break;
        sheetObj.SetCellEditable(m, "sim_rpt_no",0);//기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.SetCellEditable(m, "ldf_rto",0);//기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.SetCellEditable(m, "grs_rpb_rev",0);//기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.SetCellEditable(m, "bnk_cost_amt",0);//기존 데이터의 ReportNo는 바꾸지 못하게 처리
        sheetObj.SetCellEditable(m, "sim_rmk",0);//기존 데이터의 ReportNo는 바꾸지 못하게 처리
    }
    //ROW를 INSERT한 후 sim_rpt_no를 제외하고 값을 복사해서 넣어준다.
    for(var m=start_idx; m<=add_cnt; m++){
        sheetObj.DataInsert(-1);
        for(k=0; k<12; k++){
if(k != 4) sheetObj.SetCellValue(-1, k,sheetObj.GetCellValue(m, k),0);
        }
    }
}
