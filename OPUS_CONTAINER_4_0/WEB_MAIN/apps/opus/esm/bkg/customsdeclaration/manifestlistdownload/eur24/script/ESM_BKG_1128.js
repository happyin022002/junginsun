/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1128.js
*@FileTitle  : esm_bkg_1128
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/18
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
     * @class esm_bkg_1128 : esm_bkg_1128 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1128(){
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* 개발자 작업	*/
    var comboObjects=new Array();
    var comboCnt=0;
	// 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj; 
    }
    /**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo){
}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "btn_Close":
				ComClosePopup(); 
			break;						
        } // end switch
	}catch(e){
		if( e == "[object Error]"){
			ComShowMessage(OBJECT_ERROR);
		} else{
			ComShowMessage(e.message);
		}
	}
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(){
	var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
   doActionIBSheet(sheetObjects[0],document.form,SEARCH);
}
/**
 * 화면 로딩 완료 후 이벤트
 * @param sheetObj
 * @return
 */
 function sheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	//initSheetData(sheetObjects[0], formObj);
   	//ComSetFocus(formObj.form1_vvd_cd);
}   
/**
 * Sheet DblClick 처리
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet1_OnClick(sheetObj, row, col) {
       var colSaveName=sheetObj.ColSaveName(col);
       switch(colSaveName) {
       	case "err_img" :
       		if(sheetObj.GetCellValue(row, "err_img") == "img/btns_search.gif"){
       			ComOpenWindowCenter("/opuscntr/ESM_BKG_1115.do?pgmNo=ESM_BKG_1115&err_id=" + sheetObj.GetCellValue(row,"err_id")+"&cnt_cd="+ComGetObjValue(form.cnt_cd), "1115", 870,500, false);
       		}
	    	break;
       } // end switch
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	
	switch(sheetID) {
		case "sheet1":
			
			with(sheetObj) {
		
				var HeadTitle1="|Status|Message||err_id";
				var headCount=ComCountHeadTitle(HeadTitle1);
			
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
			
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",   Wrap:1 },
				{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"column1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				{Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"remark1",  MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				{Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"err_img",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"err_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
			
				        
				InitColumns(cols);
			
				SetEditable(1);
				SetImageList(0, "img/btns_search.gif");
				SetImageList(1, "img/blank.gif");
				SetCountPosition(0);
				SetRowHidden(0, 1);
				SetSheetHeight(500);
			}
		break;
	}
 }
/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj,formObj,sAction){
	sheetObj.ShowDebugMsg(false);
	switch(sAction){
		case SEARCH :	//조회
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
 			var sXml=sheetObj.GetSearchData("ESM_BKG_1128GS.do", FormQueryString(formObj));
			var valResult=ComGetEtcData(sXml, "data");
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			if(sheetObj.RowCount()== 0){
				ComOpenWait(false);
				ComShowCodeMessage('BKG00095', "Ack Message");
				//initSheetData(sheetObj, formObj);
			}
            ComOpenWait(false);
		break;
	}
}
/* 개발자 작업  끝 */
