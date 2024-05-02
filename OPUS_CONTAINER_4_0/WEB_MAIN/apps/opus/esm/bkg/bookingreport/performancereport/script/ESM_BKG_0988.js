/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0988.js
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.11 강동윤
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
     * @author CLT
     */

    /**
     * @extends 
     * @class esm_bkg_0988 : esm_bkg_0988 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

	document.onclick=processButtonClick;
    function esm_bkg_0988() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	var opener = parent;
    	var sheetIdx = ComGetObjValue(formObj.sheet_idx);
    	var sheetRow = ComGetObjValue(formObj.sheet_row);
    	var sheetCol = ComGetObjValue(formObj.sheet_col);
    	var pgmId	 = ComGetObjValue(formObj.pgm_id);
    	var opener_sheet = parent.sheetObjects[sheetIdx];
    	
    	var text	 = "";
    	var sSaveName = opener_sheet.ColSaveName(sheetCol);

    	if(sSaveName == "dtl"){
    		if(pgmId == "0269"){
    			var rt_data=opener.detail_info1(opener_sheet, sheetRow, sheetCol);
    			var id=rt_data.lastIndexOf('$$');  
    			var sc_data=rt_data.substring(id+2,rt_data.length);
    			text = sc_data;
    		}else{
    			var rt_data=opener.detail_info(opener_sheet, sheetRow, sheetCol);
    			var id=rt_data.lastIndexOf('$$');
    			var rfa_data=rt_data.substring(id+2,rt_data.length);
        		text = rfa_data; 
    		}
    	}else{
    		if (sSaveName =="note"){
				text = opener_sheet.GetCellValue(sheetRow, "note_ctnt"); 
			}else if (sSaveName =="cnote"){
				text = opener_sheet.GetCellValue(sheetRow, "cnote_ctnt"); 
			}else if (sSaveName =="snote"){
				text = opener_sheet.GetCellValue(sheetRow, "snote_ctnt"); 
			}else if (sSaveName =="arb_note"){
				text = opener_sheet.GetCellValue(sheetRow, "arb_note_ctnt");
			}else if (sSaveName =="cmdt_nm"){
				text = opener_sheet.GetCellValue(sheetRow, "cmdt_nm");
			}
			
    	}
    	ComSetObjValue(formObj.text2, text);
    }
    
    

//    // 공통전역변수
//
//    var sheetObjects = new Array();
//    var sheetCnt = 0;
//    
//    var searchXml = "";
//
//    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
//    document.onclick = processButtonClick;
//
//    
//
//        /**
//         * IBSheet Object를 배열로 등록
//         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
//         * 배열은 소스 상단에 정의
//         */
//        function setSheetObject(sheet_obj){
//
//           sheetObjects[sheetCnt++] = sheet_obj;
//
//        }
//
//
//
//        /**
//         * Sheet 기본 설정 및 초기화
//         * body 태그의 onLoad 이벤트핸들러 구현
//         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
//         */
//        function loadPage() {
//
//            for(i=0;i<sheetObjects.length;i++){
//
//            //khlee-시작 환경 설정 함수 이름 변경
//                ComConfigSheet (sheetObjects[i] );
//            	
//                sheetObjects[i].isible = false;
//                
//                initSheet(sheetObjects[i],i+1);
//             
//            //khlee-마지막 환경 설정 함수 추가
//                ComEndConfigSheet(sheetObjects[i]);
//            }
//    			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//    			
//    			initControl();
//        }
//
//         /**
//       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
//       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
//       * 
//       * @param {ibsheet}
//       *            sheetObj IBSheet Object
//       * @param {int}
//       *            sheetNo sheetObjects 배열에서 순번
//       */
//      function initControl() {
//      	var formObject = document.form;
//      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
//          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
//          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
//          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
//
//      }
//      
//     /**
//	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
//	 **/
//     function obj_keypress(){
//		switch(event.srcElement.dataformat){
//	    	case "int":
//		        //숫자만입력하기
//		        ComKeyOnlyNumber(event.srcElement);
//		        break;
//	        case "float":
//	            //숫자+"."입력하기
//	            ComKeyOnlyNumber(event.srcElement, ".");
//	            break;
//	        case "eng":
//	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engdn":
//	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "engupnum":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        default:
//	            //숫자만입력하기(정수,날짜,시간)
//	            ComKeyOnlyNumber(event.srcElement);
//	    }
//	}
//
//      /**
//         * 시트 초기설정값, 헤더 정의
//         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
//         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
//         */
//        function initSheet(sheetObj,sheetNo) {
//
//            var cnt = 0;
//    				var sheetID = sheetObj.id;
//            switch(sheetID) {
//    				case "sheet1":      //sheet1 init
//                    with (sheetObj) {
//                        // 높이 설정
//                        style.height = 0;
//                        //전체 너비 설정
//                        SheetWidth = 0;
//
//                        //Host정보 설정[필수][HostIp, Port, PagePath]
//                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                        //전체Merge 종류 [선택, Default msNone]
//                        MergeSheet = msNone;
//
//                       //전체Edit 허용 여부 [선택, Default false]
//                        Editable = true;
//
//                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                        InitRowInfo( 1, 1, 3, 100);
//
//                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                        InitColumnInfo(7, 0, 0, true);
//
//                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                        InitHeadMode(true, true, true, true, false,false)
//
//                        var HeadTitle = "";
//
//                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                        InitHeadRow(0, HeadTitle, true);
//
//
//                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                        InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 	40,    daCenter,  true,    "ibflag");
//                        InitDataProperty(0, cnt++ , dtHidden,  		 		25,    daCenter,  false,   "sr_no",     	 	 	false,          "",      dfNone,      0,     true,       true);
//                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "sr_knd_cd", 			false,          "",      dfNone,      0,     true,       true);
//                        InitDataProperty(0, cnt++ , dtHidden,      		 	80,    daCenter,  false,   "rcv_rmk", 				false,          "",      dfNone,      0,     true,       true);
//                       
//                   }
//                    break;
//
//            }
//        }
//      	//Event handler processing by button name */
	function processButtonClick() {
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_Close":
				ComClosePopup(); 
     		    	 break;
     		    	 

                 } // end switch
    		} catch (e) {
    			if (e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    				bkg_error_ComShowMessage(e.message);
    			} else {
    				ComShowMessage(e.message);
    				bkg_error_ComShowMessage(e.message);
    			}
    		}
    	}
//         
//      // Sheet관련 프로세스 처리
//        function doActionIBSheet(sheetObj,formObj,sAction) {
//            sheetObj.ShowDebugMsg = false;
//            switch(sAction) {
//
//    						case IBSAVE:        //저장
//    						
//    							if(!validateForm(sheetObj,formObj,sAction)) return;
//    							
//    							sheetObj.DataInsert();
//    							
//    							sheetObj.CellValue2(1,0) = "U";
//    							sheetObj.CellValue2(1,1) = formObj.sr_no.value;
//    							sheetObj.CellValue2(1,2) = "U";
//    							sheetObj.CellValue2(1,3) = formObj.rcv_rmk.value;
//    							
//    							formObj.f_cmd.value = MULTI;   
//    							
//    							var sParam = ComGetSaveString(sheetObj);
//    			                    
//    			                sParam += "&" + FormQueryString(formObj);
// 
//    			        	    var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0988GS.do", sParam);
//
//    			        	    sheetObj.LoadSaveXml(SaveXml);
//    			        	    
//    			        	    opener.reSearch();
//    			        	
//    			        	    self.close();
//    							
//    						break;
//
//            }
//        }
//
//
//        function validateForm(sheetObject1,formObject,sAction){
//        	
//        	ComShowCodeConfirm("BKG95006");
//        	
//        	return true;
//        }
    
	/* 개발자 작업  끝 */