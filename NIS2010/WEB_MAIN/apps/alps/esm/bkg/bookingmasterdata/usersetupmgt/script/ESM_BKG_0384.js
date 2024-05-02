/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0384.js
*@FileTitle : Booking Notice Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.07 김기종
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
     * @class ESM_BKG_0384 : ESM_BKG_0384 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0384() {
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                	
	                case "btn_AddRow":
						doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
	                break;
	
					case "btn_DeleteRow":
						doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
	                break;
	
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
	                break;

		    		case "btn_Select":
		    			//comPopupOK();
		    			callPopupOK(sheetObjects[0]);
		    			break;
						
					case "btn_Close":
						window.close();
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
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		var sXml = document.form.sXml.value; 

    		//화면으로 전송하는 Task 성공여부를 ETCDATA에서 꺼내올 수있습니다. 성공 : S, 실패 : F 입니다. 
    		var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 

    		if(State == "S"){ 
	    		sheetObjects[0].Redraw = false; 
	    		sheetObjects[0].WaitImageVisible = false; 
	    		sheetObjects[0].LoadSearchXml(sXml); 
	    		sheetObjects[0].Redraw = true; 
    		} 

    		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    style.height = 222;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(0, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "Sel||tp cd|Template Seq.|User Id|Title|Remark(s)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0,		cnt++,	dtDummyCheck  	,	27, 	daCenter,	false,		"check",      	false,	"",	dfNone,		0,		true);
                    
                    InitDataProperty(0, 	cnt++ , dtHiddenStatus,		30,		daCenter,	true,		"ibflag");
    				InitDataProperty(0, 	cnt++ , dtHidden,       	90,     daCenter,   false,      "tmplt_tp_cd",  false,		"",        dfNone,     0,          true,       true,      10);
    				InitDataProperty(0, 	cnt++ , dtHidden,       	90,     daCenter,   false,      "tmplt_seq",    false,		"",        dfNone,     0,          true,       true,      10);
    				InitDataProperty(0, 	cnt++ , dtHidden,       	90,     daCenter,   false,      "usr_id",    false,		"",        dfNone,     0,          true,       true,      10);
    				
    				InitDataProperty(0, 	cnt++ , dtData,	       		140,     daLeft,     false,      "tmplt_hdr_nm", true,		"",        dfEngUpKey,     0,          true,       true,      100);
    				InitDataProperty(0, 	cnt++ , dtData,	       		200,     daLeftTop,  false,      "tmplt_ctnt",   true,		"",        dfEngUpKey,     0,          true,       true,      2000);
    				
    				FocusEditMode = -1;
    				//WordWrap = true;
    				//CountPosition = 0;
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

	            case IBSEARCH:      //조회
	    			if(validateForm(sheetObj, formObj, sAction)) {
	    				formObj.f_cmd.value = SEARCH;
	    				sheetObj.DoSearch("ESM_BKG_0384GS.do", FormQueryString(formObj));
	    			}
	    		break;
	    		
	    		case IBINSERT:      // 입력
	    			var newRow = sheetObj.DataInsert(-1);
	    			sheetObj.cellValue2(newRow, "tmplt_tp_cd") = "R";
	    		break;
	    		
	    		case IBDELETE:      // 삭제
	    			ComRowHideDelete(sheetObj, "check");
	    			sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";

	    		break;
	    		
	    		case IBSAVE:        //저장
	    			if(validateForm(sheetObj,formObj,sAction)) {
	    				formObj.f_cmd.value = MULTI;
	    				sheetObj.DoSave("ESM_BKG_0384GS.do", FormQueryString(formObj));
	    			}
	    			
	    		break;
            }
        }
        
        function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
   	 	 	if (ErrMsg == "") {
    	 		ComBkgSaveCompleted();  //서버메세지 처리
    	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		} 	 	
        }
        
        function sheet1_OnClick(sheetObj, Row, Col, Value) {
    		var formObj = document.form;
    		var colName = sheetObj.ColSaveName(Col);
    		if (colName == "check"){
	    		for (i = 1; i<= sheetObj.LastRow; i++) {  //sheetObj.LastRow
	    			if (sheetObj.CellValue(i, Col) == true){
	    				sheetObj.CellValue2(i, Col) = 0;
	    			}
	    		}
        	}
    	}
        
        /**
    	 * 팝업에서 check 선택시 부모창으로 값을 전달. <br>
    	 * 
    	 * @param {ibsheet}
    	 *            sheetObj IBSheet Object
    	 * @param {String}
    	 *            value sheetObj의 입력값
    	 */
    	function callPopupOK(sheetObj) {
    		var formObj = document.form;
    		var calllFunc;
    		var rArray = null; // 행데이터를 담고 있는 배열
    		
    		// 단일선택(Radio) 또는 다중선택(CheckBox) 일 때..
    		rArray = getLocalCheckedRows(sheetObj);
    		
    		if(rArray == null) {
    			ComShowCodeMessage("COM12114", "row");
    			return;
    		}
    		calllFunc = formObj.calllFunc.value;
            if (!opener) opener = window.dialogArguments;  // 모달창인 경우는 window 객체로부터 opener를 획득
    		opener.eval(calllFunc)(rArray);
    		window.close();
    	}
    	function getLocalCheckedRows(sheetObj,colName) {
    		
    		var checkRows;
    		var colsCnt = sheetObj.LastCol + 1;
    		
    		var rows = sheetObj.Rows;
    		
    		var rArray = null; // 행데이터를 담고 있는 배열
    		var cArray = null; // 열데이터를 담고 있는 배열
    		
    		checkRows = sheetObj.CheckedRows('check');
    		if(checkRows == 0) {  			
    				return null;
    			}
    			else {
    				var idx = 0;
    	  		rArray = new Array(checkRows);
    	  		
    			for(var i = 0; i < rows; i++) {
    				if(sheetObj.CellValue(i, 'check') == 1) {					
    		  			cArray = null;
    		  			
    		  			// 특정 컬럼명이 지정된 경우
    		  			if(colName != null && colName != "") {
    		  				cArray = sheetObj.CellValue(i, colName);
    		  			} else {
    		  				cArray = new Array(colsCnt);
    		  				
    			  			for(var j=0; j<cArray.length; j++) {
    	                    	cArray[j] = sheetObj.CellValue(i, j);
    	                    }
    	                }
    	                rArray[idx++] = cArray;
    	     		}
    	  		}
    	  	}
    	  	return rArray;
    	}
    	
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	for (i = 1; i<= sheetObj.LastRow; i++) {  //sheetObj.LastRow
	    			if (sheetObj.CellValue(i, "tmplt_hdr_nm").length < 3){
	    				alert(ComGetMsg('COM12143',"Title", 3));
	    				sheetObj.SelectCell(i, "tmplt_hdr_nm");
	    				return false;	
	    			}
	    		}

            }

            return true;
        }

    
	/* 개발자 작업  끝 */