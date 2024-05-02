/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0031.js
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.04.28 이도형
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
     * @class vop_scg_0031 : vop_scg_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0031() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

     			case "btn_RowAdd":
					var row = sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, 2);
					break;
				
				case "btn_RowInsert":
					var row = sheetObject.DataInsert();
					sheetObject.SelectCell(row, 2);
					break; 
				
				case "btn_RowCopy":
					var row = sheetObject.DataCopy();
					sheetObject.SelectCell(row, 2);
					break;
					
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject, "del_chk");
					break;	
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
     }

     function sheet1_OnLoadFinish(sheetObj) {
         //html컨트롤 이벤트초기화
         initControl();
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
    	 	case 1:      //t1sheet1 init
    	 		with (sheetObj) {

    	 			// 높이 설정
    	 			style.height = 420;
    	 			//전체 너비 설정
    	 			SheetWidth = mainTable.clientWidth;

    	 			//Host정보 설정[필수][HostIp, Port, PagePath]
    	 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    	 			//전체Merge 종류 [선택, Default msNone]
    	 			MergeSheet = msNone;

    	 			//전체Edit 허용 여부 [선택, Default false]
    	 			Editable = true;

    	 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	 			InitRowInfo( 1, 1, 3, 100);

    	 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	 			InitColumnInfo(6, 0, 0, true);

    	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    	 			InitHeadMode(true, true, false, true, false,false)

    	 			var HeadTitle = "|Sel.|No.|Code|Description|";

    	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	 			InitHeadRow(0, HeadTitle, true);

    	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
    	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   "del_chk",					false,  "",      dfNone,	0,     true,    	true);
                    InitDataProperty(0, cnt++ , dtDataSeq,   	 30, 	daCenter);
    	 			InitDataProperty(0, cnt++ , dtData,        	140,	daCenter,   true,   "spcl_cgo_lod_rjct_rsn_cd", true,	"",      dfNone,	0,     false,		true, 	3,	true);
    	 			InitDataProperty(0, cnt++ , dtData,        	540,    daLeft,	   	true,   "rjct_rsn_cd_desc",  		false,  "",      dfNone,    0,     true,    	true,	1000);
    	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daLeft,	   	true,   "delt_flg",  				false,  "",      dfNone,    0,     true,    	true);

    	 			InitDataValid(0, "spcl_cgo_lod_rjct_rsn_cd", vtEngUpOnly);

    	 		}
    	 		break;

    	 }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
    	 
    	 //파라미터 생성
    	 var sParams = "";
         switch(sAction) {
         
         	case IBSEARCH:      //조회
         		if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
		        		formObj.f_cmd.value = SEARCH;
		        		sParams = "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&pagerows="+ComGetObjValue(formObj.pagerows)+"&spcl_cgo_cate_cd="+ComGetObjValue(formObj.spcl_cgo_cate_cd);
		        	   	sheetObj.DoSearch("VOP_SCG_0031GS.do", sParams);
					}
				}			
        	   	break;
			
			case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
        		formObj.f_cmd.value = MULTI;
        		sParams = "f_cmd="+ComGetObjValue(formObj.f_cmd)+"&pagerows="+ComGetObjValue(formObj.pagerows)+"&spcl_cgo_cate_cd="+ComGetObjValue(formObj.spcl_cgo_cate_cd);
				sheetObj.DoSave("VOP_SCG_0031GS.do", sParams, '-1', false);
				break;
			
         }
     }

 	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {    	
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListener ('keydown', 'ComKeyEnter', 		'form');
    	 axon_event.addListener('change', 	'combo_OnChange', 	'spcl_cgo_cate_cd');         
     }

     /**
      * 업무 자바스크립트 OnChange 이벤트 처리
      */
     function combo_OnChange(comboObj, code, text) {
    	 var formObj = document.form;
    	 if(code != "") {
             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	 }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (sAction == IBSAVE) {
  			var dupRow = sheetObj.ColValueDupRows("spcl_cgo_lod_rjct_rsn_cd", false, true);
 			if(dupRow != "") {
				ComShowCodeMessage('SCG50005', 'Data');
				if (sheetObj.RowStatus(dupRow.split("|")[0])=="R") {
					sheetObj.SelectCell(dupRow.split("|")[1], 2);
				}else{
					sheetObj.SelectCell(dupRow.split("|")[0], 2);					
				}
				return;
 			}    		 
    	 }
         return true;
     }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function sheet1_OnChange(sheetObj,Row, Col, Value){

    	 if (sheetObj.ColSaveName(Col) == "spcl_cgo_lod_rjct_rsn_cd") {
    		 var bfCode = sheetObj.CellValue(Row,"spcl_cgo_lod_rjct_rsn_cd");
    		 if (bfCode != "" && bfCode.length != 3) { 
    			 ComShowCodeMessage('SCG50006', 'Code', '3');
    			 sheetObj.SelectCell(Row, Col);
    		 }
    	 }
     }
     
     /* 개발자 작업  끝 */