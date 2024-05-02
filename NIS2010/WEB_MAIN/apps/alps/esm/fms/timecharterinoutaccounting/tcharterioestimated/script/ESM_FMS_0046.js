/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0046.js
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.24 윤세영
* 1.0 Creation
* --------------------------------------------------------------------------------
* 2016.02.01 손진환 [CHM-201639985] Inquiry 화면 불필요 Validation정리 
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
     * @class esm_fms_0046 : esm_fms_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0046() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
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

	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	var tmp_fr_duration = "";
	var tmp_to_duration = "";
	
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
				case "btn_retrieve":
					sheetObject.RemoveAll();
					
	             	if (!duration_change()) return;	  
					document.form.seach_tp_cd.value = "R";           	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
					sheetObject.ColHidden("flet_accl_amt") = false;	//retrieve인 경우에만 "Accrual2"컬럼 보이게 처리					
					for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++){						
						sheetObject.CellEditable(i, "acc_amt") = false;			
					}
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_del");					
                break;

            	case "btn_create":	             	
	             	if (!duration_change()) return;	         
					document.form.seach_tp_cd.value = "C";    	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
					
	             	sheetObject.ColHidden("flet_accl_amt") = true;	//retrieve아닌경우에는 "Accrual2"컬럼 안보이게 처리
					
					for(var i=sheetObject.HeaderRows; i<=sheetObject.LastRow; i++){
						sheetObject.CellEditable(i, "acc_amt") = true;	
					}					
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_del");
                break;
				
				case "btn_new":					
					ComResetAll();
					inputReadOnly("New");
                break;
                
				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                break;

				case "btn_save":
					
					if (ComIsBtnEnable("btn_save")) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
					}	
                break;
                
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;

     			case "btn_fr_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('month');
					cal.select(form.fr_duration, 'yyyy-MM');
     				
					sheetObject.RemoveAll();
					break;					

     			case "btn_to_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('month');
					cal.select(form.to_duration, 'yyyy-MM');

					sheetObject.RemoveAll();
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
     * Print Button 클릭시 필요한 파라미터 생성 <br>
     * @param {Form Object} formObject     	form name
     **/
    function getPrintParam(formObject) {
/*
		var fr_duration = parseFloat(formObject.fr_duration.value);
		var to_duration = parseFloat(formObject.to_duration.value);
		if (fr_duration < to_duration) {
			formObject.snd_year.value = (fr_duration+1);
		} else {
			formObject.snd_year.value = '';
		}
		if (fr_duration+2 == to_duration) {
			formObject.trd_year.value = to_duration;
		} else {
			formObject.trd_year.value = '';
		}
		formObject.flet_dck_svey_tp_nm.value = formObject.flet_dck_svey_tp_cd.options[formObject.flet_dck_svey_tp_cd.selectedIndex].text;
		formObject.reflection_nm.value = formObject.reflection_cd.options[formObject.reflection_cd.selectedIndex].text;
*/		
	}
    
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	var cursor = "default";
    	var img = "no_";
    	
    	if(flag == "New") {
    		readOnly = false;
    		cursor = "hand";
    		img = "";
    	}

		form.fr_duration.readOnly = readOnly;
		form.to_duration.readOnly = readOnly;
    	form.flet_ctrt_tp_cd.disabled = readOnly;
    	
    	document.images["btn_fr_duration"].name = img+"btn_fr_duration";
    	document.images["btn_to_duration"].name = img+"btn_to_duration";
    	
    	form.btn_fr_duration.style.cursor = cursor;
    	form.btn_to_duration.style.cursor = cursor;

		ComBtnEnable("btn_save");
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

	    obj = event.srcElement;

	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        //ComKeyOnlyNumber(event.srcElement);
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


        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
    	
    	//Contract Type의 OW 삭제
        removeContractTP();
		
		sheetObj.WaitImageVisible = true;   
    }

	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'				, 'obj_blur', 		document.form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , document.form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        
        axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Duration 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Duration 입력 후 From~To 비교

        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
        
        //Contract Type의 OW 삭제
        //removeContractTP();

    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
	    ComChkObjValid(event.srcElement);
    }


	/**
     * Duration 입력 후 From~To 비교
     **/
    function duration_change() {
    	
		var formObj = document.form;
		var fr_duration = ComReplaceStr(formObj.fr_duration.value,'-');
		var to_duration = ComReplaceStr(formObj.to_duration.value,'-');
		if (fr_duration != '' && to_duration != '') {
			if (parseFloat(fr_duration) > parseFloat(to_duration)) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
				return false;
			}

		}

		return true;

	}	

	/**
     * Contract Type의 TO 삭제
     **/
    function removeContractTP() {
		for (i=0;i<document.form.flet_ctrt_tp_cd.length;i++) {
			if (document.form.flet_ctrt_tp_cd.options[i].value == "OW") {
				document.form.flet_ctrt_tp_cd.remove(i);
				break;
			}
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
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel|Seq|Period|Type|F.Lane|VVD Code|Hire|From Date|To Date|Days|Estimated|Actual|Accrual|Accrual 2|";
					var headCount = ComCountHeadTitle(HeadTitle)+7;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,     daCenter,   false,   "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,    		35,    	daCenter,  	true,   "Seq");
                    InitDataProperty(0, cnt++ , dtData,      	65,   	daCenter,  	true,   "rev_yrmon",    	true,          "",      								dfDateYm, 	0,     false,      	false);
					InitDataProperty(0, cnt++ , dtCombo,		65,		daCenter,	false,  "flet_ctrt_tp_cd",  false,         "",      								dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "rlane_cd",     	false,         "",      								dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,  "vvd_cd",     		false,         "",      								dfNone,     0,     false,       false);
					                                   					
					InitDataProperty(0, cnt++ , dtData,			75,  	daRight,	false,	"hire_amt",     	false,         "",      								dfFloat,    2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,   	   	87,   	daCenter,	true,   "vst_dt",   		true,          "",      								dfDateYmd,	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	87,   	daCenter,	true,   "ved_dt",   		true,          "",      								dfDateYmd,	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	60,     daCenter,	false,  "days",     		true,          "DateDiff(d, |vst_dt|, |ved_dt|)+1",     dfNone,     0,     false,      	false);
					InitDataProperty(0, cnt++ , dtData,			100,  	daRight,	false,  "est_amt", 			false,         "",      								dfFloat, 	2,     false,       false);
					
					InitDataProperty(0, cnt++ , dtData,			95,  	daRight,	false,  "act_amt", 			false,         "",      								dfFloat, 	2,     false,       false);
					
					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,	false,  "acc_amt", 			false,         "",      								dfFloat, 	2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,	false,  "flet_accl_amt", 	false,         "",      								dfNumber, 	2,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,			100,   	daRight,	false,  "acc_old_amt", 		false,         "",      								dfNone, 	2,     false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "rev_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "subsumcol");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "exe_yrmon");
					
					InitDataProperty(0, cnt++ , dtHidden,		 100,		daCenter,   true,   "saved_acc_amt", 			false,         "",      								dfFloat, 	2,     false,       false);
					
					
               }

                break;

        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){

	        		formObj.f_cmd.value = SEARCH;
	        	   	
	        	   	sheetObj.DoSearch("ESM_FMS_0046GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));

//       	   	  		inputReadOnly("Search");
	  	   	  	}	

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			
	 			doCheckSavedDate();
	 			
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0046GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					CoFmsGetCombo("FORM", formObj, sheetObj, "CD01513","flet_ctrt_tp_cd", "flet_ctrt_tp_cdText");
					//Type
					getTypeCombo(sheetObj);

				}	
        	   
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        return true;
    }

	/**
     * Type의 Combo 정보 구하기
     **/
    function getTypeCombo(sheetObj) {
    	var obj = document.form.flet_ctrt_tp_cd;

		var comboCode = '';
		var comboText = '';
		
		for (i=0;i<obj.length;i++) {
			if (obj.options[i].value != "") {
				comboCode += obj.options[i].value + "|"
				comboText += obj.options[i].text + "|"
			}
		}
        sheetObj.InitDataCombo(0, "flet_ctrt_tp_cd", comboText.substring(0,comboText.length-1), comboCode.substring(0,comboCode.length-1));
	}	

     /**
      * IBSheet를 조회 후 실행되는 이벤트
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
 		ComColFontName(sheetObj, "rlane_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "vvd_cd", "Courier New"); 	
		sheetObj.ShowSubSum("subsumcol", "est_amt|act_amt|acc_amt", -1, false, false, 9, "ved_dt=Total Amount");

		//acc_amt값 수정 전값 저장용 셋팅
	    for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){		
			sheetObj.Cellvalue(i,"acc_old_amt")   = sheetObj.Cellvalue(i,"flet_accl_amt");
			sheetObj.Cellvalue(i,"saved_acc_amt") = sheetObj.Cellvalue(i,"acc_amt");
		}
	    
	    tmp_fr_duration = document.form.fr_duration.value;
	    tmp_to_duration = document.form.to_duration.value;

    }
	
	function sheet1_OnClick(sheetObj,Row, Col, Value) {
 		var colName = sheetObj.ColSaveName(Col);
		
     }

     /**
      * IBSheet를 저장 후 실행되는 이벤트
      */
    function sheet1_OnSaveEnd(sheetObj,ErrMsg){

		//Interface to ERP Button Disable 하기
		ComBtnDisable("btn_save");
	}

    
    function doCheckSavedDate(){
    	 for(var Row=sheetObjects[0].HeaderRows; Row<=sheetObjects[0].LastRow; Row++){		
   			  				
    				if ( sheetObjects[0].Cellvalue(Row,"acc_amt") != sheetObjects[0].Cellvalue(Row,"saved_acc_amt")) {
    					 sheetObjects[0].Cellvalue(Row,"acc_old_amt") = sheetObjects[0].Cellvalue(Row,"saved_acc_amt");				
    				}    			
    		 
   		}
    	   
    }
    
    
	/* 개발자 작업  끝 */ 