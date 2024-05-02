/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0062.js
*@FileTitle : TEU Range Target
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
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
     * @class TEU Range Target : TEU Range Target 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0062() {
    	this.processButtonClick		= processButtonClick;
    	this.inputReadOnly			= inputReadOnly;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.obj_keypress		    = obj_keypress;
    	this.validateForm 			= validateForm;
    	this.initConfirm			= initConfirm;
    	this.obj_deactivate			= obj_deactivate;
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
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];

    	/*******************************************************/
    	var formObject = document.form;
          
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
             
    		switch(srcName) {
    			case "btn_retrieve":
    				if(!initConfirm()) return;
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    		 		break;
    		 		
    		 	case "btn_new":
    		 		if(!initConfirm()) return;
    		 		ComResetAll();
    		 		inputReadOnly("0");
                    break;
                    
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_dataerase":
					// 정말로 삭제하시겠습니까?
					if(ComShowCodeConfirm("FMS00003")) {
						doActionIBSheet(sheetObject,formObject,IBDELETE);
					}
					break;

				case "btn_add":
					if(validateForm(sheetObject,formObject)) {
						var row = sheetObject.DataInsert(-1);
						sheetObject.CellText(row, "rng_yr") = form.rngYr.value;
						inputReadOnly("1");
					}
					break;

				case "btn_ins":
					if(validateForm(sheetObject,formObject)) {
						var row = sheetObject.DataInsert();
						sheetObject.CellText(row, "rng_yr") = form.rngYr.value;
						inputReadOnly("1");
					}
					break;

				case "btn_del":
					ComRowHideDelete(sheetObject, "DelChk");
					break;

				case "rng_yr_cal":
					var cal = new ComCalendar();
					cal.setDisplayType('year');
					cal.select(form.rngYr, 'yyyy');
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
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
    function inputReadOnly(flag) {
    	if(flag == "1") {
    		form.rngYr.readOnly = true;
    		form.rng_yr_cal.style.cursor = "default";
    		document.images["rng_yr_cal"].name = "no_rng_yr_cal";
    	} else {
    		form.rngYr.readOnly = false;
    		form.rng_yr_cal.style.cursor = "hand";
    		document.images["rng_yr_cal"].name = "rng_yr_cal";
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
            
            sheetObjects[i].ExtendLastCol = false;
    	}
        
        // html컨트롤 이벤트초기화
        initControl();
    }
     
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
     	DATE_SEPARATOR = "/";
     	
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerFormat('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerFormat('blur', 'obj_deactivate',  form);
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
                    style.height = 382;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Sel|Seq|rng_yr|rng_seq|TEU Range|TEU Range|Hire Apply|Market rate Apply";
                    var HeadTitle2 = "|Sel|Seq|rng_yr|rng_seq|From Size|To Size|Hire Apply|Market rate Apply";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  true,    "ibflag");
 					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  true,   	"DelChk");
					InitDataProperty(0, cnt++ , dtDataSeq,      40,    	daCenter,  true,   	"Seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,    	daRight,   false,   "rng_yr",			false,	"",	dfInteger,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		30,    	daRight,   false,   "rng_seq",			false,	"",	dfInteger,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,			100,    daRight,   false,   "rng_fm_qty",		false,	"",	dfInteger,	0,	true,	true, 6);
 					InitDataProperty(0, cnt++ , dtData,  		100,    daRight,   false,   "rng_to_qty",    	false,  "", dfInteger,  0,  true,   true, 6);
 					InitDataProperty(0, cnt++ , dtCheckBox,   	150,    daCenter,  true,   	"hir_aply_flg",     false,  "", dfNone,     0,  true,   true);
                    InitDataProperty(0, cnt++ , dtHidden,   	150,    daCenter,  true,   	"mkt_rt_aply_flg",  false,  "", dfNone,   	0,  true,   true);
         		}
        		break;
        }
    }

	/**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
		  
    	switch(sAction) {
    		case IBSEARCH:      // 조회
    			if(validateForm(sheetObj,formObj,sAction)) {
    				formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_FMS_0062GS.do", FormQueryString(formObj));
					inputReadOnly("1");
    			}
    			break;

    		case IBSAVE:        // 저장
		  	  	if(validateForm(sheetObj,formObj,sAction)) {
		  	  		formObj.f_cmd.value = MULTI;
		  	  		sheetObj.DoSave("ESM_FMS_0062GS.do", FormQueryString(formObj)); 
		  	  	}
		  	  	break;
		  
    		case IBDELETE:      // 전체삭제
    			if(validateForm(sheetObj,formObj,sAction)) {
    				for(var row=2; row<=sheetObj.LastRow; row++) {
    					sheetObj.RowStatus(row)= "D";
    				}
		    		formObj.f_cmd.value = REMOVE;
		  	  		sheetObj.DoSave("ESM_FMS_0062GS.do", FormQueryString(formObj));
		  	  		inputReadOnly("0");
    			}
          	  	break;
    	}
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	var	fromSize;
  		var toSize;

  		if (!ComChkValid(formObj)) return false;
  		
    	with(formObj){		
    		if (sAction == IBSAVE) {
		    	if(sheetObj.RowCount == 0) {
		  			ComShowCodeMessage("FMS00007");
		  			return false;
		  		}
    			
	    		for(var row=2; row<=sheetObj.LastRow; row++) {
	    			if(sheetObj.CellValue(row, "ibflag") == "D") {
	    				continue;
	    			}
	    			
	    			fromSize = sheetObj.CellValue(row, "rng_fm_qty");
	    			toSize = sheetObj.CellValue(row, "rng_to_qty");
	    			
	    			if(parseInt(fromSize) >= parseInt(toSize)) {
	    				// To Size는 From Size보다 커야 합니다
	    				ComShowCodeMessage("FMS00010", "To Size", "From Size");
	    				sheetObj.SelectCell(row, "rng_to_qty");
	    				return false;
	    			}
	    			
	    			for(var currRow=2; currRow<=sheetObj.LastRow; currRow++) {
	    				if(sheetObj.CellValue(currRow, "ibflag") == "D") {
		    				continue;
		    			}

	    				currFromSize = sheetObj.CellValue(currRow, "rng_fm_qty");
		    			currToSize = sheetObj.CellValue(currRow, "rng_to_qty");
	    				if(currRow != row) {
	    					if((parseInt(fromSize) >= parseInt(currFromSize)) && 
	    					   (parseInt(fromSize) <= parseInt(currToSize))) {
	    						
	    						if(currRow < row) {
		    						ComShowCodeMessage("FMS00014", "'" + fromSize + "'");
		    						sheetObj.CellValue2(row, "rng_fm_qty") = "";
		    						sheetObj.SelectCell(row, "rng_fm_qty");
	    						} else {
	    							ComShowCodeMessage("FMS00014", "'" + currFromSize + "'");
		    						sheetObj.CellValue2(currRow, "rng_fm_qty") = "";
		    						sheetObj.SelectCell(currRow, "rng_fm_qty");
	    						}
	    						return false;
	    					}
	    	    		}
	    			}
	    		}
    		}
    	}

    	return true;
    }

    /**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
    	if(sheetObjects[0].isDataModified) {
    		var okYn = ComShowCodeConfirm("FMS00002");
    	}
    	
    	return okYn;
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
    }
	/* 개발자 작업  끝 */