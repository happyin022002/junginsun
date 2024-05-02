/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0176.js
*@FileTitle  :  Copy C/M by Container
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
* @author CLT
     */
    /**
     * @extends
     * @class esm_bkg_0176 : esm_bkg_0176 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var localopener = (opener || parent);
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_CheckAll":
					sheetObject1.CheckAll("sel",1,1);
				break;
				case "btn_UncheckAll":
					sheetObject1.CheckAll("sel",0,1);
				break;
				case "btn_OK":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					ComClosePopup(); 
				break;
				case "btn_Close":
					ComClosePopup(); 
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
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
			ComConfigSheet (sheetObjects[i] );
			//init sheet
			initSheet(sheetObjects[i],i+1);
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
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
                
			              var HeadTitle1="|Sel.|Container No.|TP/SZ|C/M";
			
			              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			              InitHeaders(headers, info);
			
			              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			               
			              InitColumns(cols);
			
			              SetEditable(1);
			              SetSheetHeight(120);
                    }


            break;
        }
    }
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		
		switch(sAction) {
			case IBSEARCH:
				
				var fmSheetObj=localopener.sheetObjects[0];
				var fmCntr=formObj.cntr_no.value;
				var tmCntr='';
				var tmTpsz='';
				var tmCfrm='';
				var rCnt=fmSheetObj.RowCount();
				for (ix=1; ix <= rCnt; ix++) {
					tmCntr=fmSheetObj.GetCellValue(ix, "cntr_no");
					tmTpsz=fmSheetObj.GetCellValue(ix, "cntr_tpsz_cd");
					tmCfrm=fmSheetObj.GetCellValue(ix, "cntr_mf_flag");
					if(fmSheetObj.GetRowStatus(ix) != 'D' && tmCntr != fmCntr && fmSheetObj.GetCellValue(ix, "mf_cfm_flg") == 0){
						var nRow=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(nRow, "cntr_no",tmCntr,0);
						sheetObj.SetCellValue(nRow, "cntr_tpsz_cd",tmTpsz,0);
						sheetObj.SetCellValue(nRow, "cntr_mf_flag",tmCfrm,0);
					}
				}
			break;
			case IBSAVE:
				var toCntrArr=localopener.ComFindText(sheetObjects[0], "sel", 1);
				if(toCntrArr.length == 0){
					ComShowMessage(ComGetMsg("BKG00188"));
				}else{
					var cntrs=new Array();
					for(ir=0;ir<toCntrArr.length;ir++) {
						cntrs.push(sheetObj.GetCellValue(toCntrArr[ir], "cntr_no"));
					}
					localopener.copyCm(formObj.cntr_no.value, cntrs);
				}
			break;
		}
	}
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:        //저장
			break;
		}
        return true;
    }
	/* 개발자 작업  끝 */
