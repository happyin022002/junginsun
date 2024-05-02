/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0004.js
*@FileTitle : Initial Allocation Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.23 이현주
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
     * @class ESM_SPC_0004 : ESM_SPC_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0004() {
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

 // data의 반복 횟수
 var REPEAT_DATA_CNT = 0;                    
 //반복이 시작 되는 Col 위치(index 0부터 시작 )
 var REPEAT_START_COL = 0;
 //저장된 row의 index(;로 구분된 index)
 var saveRepeatDataRows;    

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
     	        	doActionIBSheet(sheetObject, formObject, IBSEARCH);
         	        break;
         	    case "btn_downexcel":
         	        doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
         	        break;
         	    case "btn_save":
 	    	        doActionIBSheet(sheetObject, formObject, IBSAVE);
         	        break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
     function setSheetObject(sheet_obj) {
     	sheetObjects[sheetCnt++] = sheet_obj;
     }

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         for(i = 0; i < sheetObjects.length; i++) {
         	//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet(sheetObjects[i]);
             initSheet(sheetObjects[i], i+1);
         	//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }

    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
 		var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {
                 	// 높이 설정
                     style.height = getSheetHeight(23) ;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     //SheetWidth = 800;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") {
                         InitHostInfo(location.hostname, location.port, page_path);
                     }
                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false] edit상태 공통으로 변경
                     Editable = true;
 					 FocusEditMode = default_edit_mode;
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 9, 100);
                                     

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(16, 0 , 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false, false);
                     //FitColWidth("30|50|60|60|50|50|50|50|50|50|50|50|50|50|50|50");

                     var HeadTitle = "STS|SEQ|Trade|Bound|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtStatus,  30,    daCenter,   true,     "FLG");
                     InitDataProperty(0, cnt++, dtDataSeq, 40,    daCenter,   false,    "",      	  false,         "",       dfNone,   		0,     false,      true);
                     InitDataProperty(0, cnt++, dtData ,   90,    daCenter,   false,    "rep_trd_cd", true,      	 "",       dfNone,   		0,     false,      true, 		3, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    90,    daCenter,   false,    "dir_cd",     true,     	 "",       dfNone,      	0,     false,      true, 		1, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_01",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_02",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_03",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_04",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_05",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_06",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_07",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_08",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_09",     true,          "",       dfFloat,       1,     true,       true, 		5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_10",     true,          "",       dfFloat,       1,     true,       true,        5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_11",     true,          "",       dfFloat,       1,     true,       true,        5, 					false, 			false);
                     InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,    "mon_12",     true,          "",       dfFloat,       1,     true,       true,        5, 					false, 			false);
                    	
//                     //data의 반복 횟수
//                     REPEAT_DATA_CNT = 12;
//                     //반복이 시작 되는 Col 위치(index 0부터 시작 )
//                     REPEAT_START_COL = 6;
//                     
//                     for(var i = 0; i < REPEAT_DATA_CNT; i++) {
//                        	InitDataProperty(0, cnt++, dtHidden,       0,    daCenter,   false,  "hidden_init_aloc_rto",        true,          "",      dfNone,      0,     false,       true,           2);
//                     }
//                      
//                     for(var i = 0; i < REPEAT_DATA_CNT; i++) {
//                        	InitDataProperty(0, cnt++, dtHidden,      0,    daCenter,  true,    "ibflag",       true);                      			
//                     }
//                     
//                     for(var i = 0; i < REPEAT_DATA_CNT; i++){
//                     	InitDataProperty(0, cnt++, dtHidden,       0,    daCenter,   false,   "rep_trd_cd",     true,      "",      dfNone,      0,     false,       true,          3);
//                     	InitDataProperty(0, cnt++, dtHidden,       0,    daCenter,   false,   "dir_cd",     true,          "",      dfNone,      0,     false,       true,          1);
//                    	InitDataProperty(0, cnt++, dtHidden,       0,    daCenter,   false,   "bse_mon",    true,          "",      dfNone,      0,     false,       true,          2);
//                     }      
  					
                     //Allo rto 최소값/최대값 셋팅
 	  		    	 for(var j = 4; j < 16; j++){
 		  		    	sheetObj.MinimumValue(0, j) = "0.1"; 
 		  		    	sheetObj.MaximumValue(0, j) = "200";         
 	  		    	}     
    
                 }
                 break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
     	sheetObj.ShowDebugMsg = false;

       	switch(sAction) {
 	        case IBSEARCH:      //조회
 				if(checkModifiedSheet(sheetObj)) {
 					//두개 이상의 Sheet를 동시에 체크해야 하여 하나라도 수정된 Sheet가 존재하는 경우를 체크하고자 하는경우 사용
 					if(ComShowConfirm (getMsg("SPC90001")) != 1) {
 						return;
 					}
 				}	
               	formObj.f_cmd.value = SEARCHLIST; 
//               	sheetObj.DoSearch("ESM_SPC_0004GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
//                sheetObj.DoSearch4Post("ESM_SPC_0004GS.do", "f_cmd="+(SEARCHLIST) + "&" + FormQueryString(formObj));
                sheetObj.DoSearch4Post("ESM_SPC_0004GS.do", "f_cmd="+(SEARCHLIST));
               	break;
           	case IBSAVE:        //저장
               	var tran_rows = sheetObj.FindStatusRow("U");
              	if(!validateLimit(sheetObj,tran_rows)) {
              	    return false;   
              	}            
	            formObj.f_cmd.value = MULTI;
 	            saveRepeatDataRows = tran_rows;
 	            
// 	            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0004GS.do","f_cmd="+(MULTI) + "&" + FormQueryString(formObj));
 	            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0004GS.do","f_cmd="+(MULTI));
 	           
 	            break;
          	case IBINSERT:      // 입력
          		sheetObj.DataInsert();
                	break;
          	case IBCOPYROW:        //행 복사
 		        sheetObj.DataCopy();
 		        break;
          	case IBDOWNEXCEL:        //엑셀 다운로드
 		        sheetObj.Down2Excel(-1, false, false, true);
 		        break;
          	case IBLOADEXCEL:        //엑셀 업로드
 		        sheetObj.LoadExcel();
 		        break;

       	}
     }
 				
 	/*validation check
 	 * 
 	 */
 	function validateLimit(sheetObj,trans_rows) {
      	var arrRow = trans_rows.split(";");
        	for (var idx = 0; idx < arrRow.length-1; idx++) {
          		for(var lCnt = 0; lCnt < REPEAT_DATA_CNT; lCnt++) {
            		var oridata_col = 4 + lCnt ;
            		var oridata = sheetObj.CellValue(arrRow[idx], oridata_col);          
  		          	if(oridata<0 || oridata==0|| oridata > 200 ) {            
  		          		ComShowMessage(ComGetMsg("SPC90118"));
  		            	sheetObj.SelectCell(arrRow[idx], oridata_col, true);
  		            	return false;   
  		          	} 
          		}
        	}
        	return true;
      }    
     
     /* sheet onChange이벤트
      * 
      */
     function sheet_OnChange(sheetObj, row, col, val) {		
//     	cellChange(sheetObj, row, col, val); 
     }
          
     
     /* 변경된 컬럼의 값만 저장되도록 
      * 변경된 FLAG만 HIDDEN FLAG에서 변경 I/U로 변경 
      * 다른 FLAG는 R로 변경 체크*/
     function complateRepeatSave(sheetObj){
 	    var arrRow = saveRepeatDataRows.split(";");
       	
       	for (var idx = 0; idx < arrRow.length-1; idx++){
         	for(var lCnt = 0; lCnt < REPEAT_DATA_CNT ; lCnt++) {
            	var flg_col = REPEAT_START_COL + (REPEAT_DATA_CNT * 2) + lCnt ;
            	var flg = sheetObj.CellValue(arrRow[idx], flg_col);
 	           	if(flg != "R") {
 	            	var hidden_col = REPEAT_START_COL + REPEAT_DATA_CNT + lCnt ;
 	             	var oridata_col = REPEAT_START_COL + lCnt ;
 	             	var oridata = sheetObj.CellValue(arrRow[idx], oridata_col);       
 	             	sheetObj.CellValue2(arrRow[idx], flg_col) = "R";
 	             	sheetObj.CellValue2(arrRow[idx], hidden_col ) = oridata;
 	          	}
         	}
         	sheetObj.RowStatus(arrRow[idx]) = "R";
       	}
     }
     
  
    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj, formObj, sAction){
     	with(formObj){
 			if ( sheetObj.ColSaveName(col) == "tt_init_aloc_rto" ) {
//    						 var init_rot = sheetObj.CellValue(row,col);
//    						 	if(init_rot>100.0){
//    						 			showErrMessage("100보다 큰수는 입력할 수 없습니다.");
//    						 			showErrMessage(getMsg("COM12144"));
//    						 	}
  			}
       	}
       	return true;
     }
     
     function sheet_OnSaveEnd(sheetObj, errMsg) {
    	 if(sheetObj.EtcData("status") == "OK"){
    		 ComShowMessage("saved successfully.");
    	 } else if(sheetObj.EtcData("status") != "OK"){
    		 ComShowMessage(errMsg);
    	 } else {
 //          complateRepeatSave(sheetObj);
    	 }
    	 saveRepeatDataRows = "";
     }


	/* 개발자 작업  끝 */