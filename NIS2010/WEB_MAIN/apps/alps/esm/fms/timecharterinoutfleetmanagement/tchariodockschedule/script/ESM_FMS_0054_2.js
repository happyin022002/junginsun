/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0054_2.js
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.29 윤세영
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
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
     * @class esm_fms_0054_2 : esm_fms_0054_2 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0054_2() {
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

       /*******************************************************/
       var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {

            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					
					ComResetAll();
					inputReadOnly("New");
                break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                break;

				case "btn_add":
					
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "dck_fm_dt");
					sheetObject.CellValue(row, "dck_dur_dys_days") = "Days";
					
					sheetObject.CellValue(row,"vsl_cd") = formObject.vsl_cd.value;
					sheetObject.CellValue(row,"dck_sel_cd") = formObject.dck_sel_cd.value;
					
                break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert();
					sheetObject.SelectCell(row, "dck_fm_dt");
					sheetObject.CellValue(row, "dck_dur_dys_days") = "Days";
					
					sheetObject.CellValue(row,"vsl_cd") = formObject.vsl_cd.value;
					sheetObject.CellValue(row,"dck_sel_cd") = formObject.dck_sel_cd.value;
					
					break;

				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;
                    
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0022");
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
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
	}
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value = "";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
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
		
		sheetObj.WaitImageVisible = true;   
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
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
      //2010.11.24 이상민 vsl_cd 는 eng_press -> engnum_press
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Vessel Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Vessel Code 입력 후 Name 정보 가져오기

        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:     //sheet1 init
                with (sheetObj) {

					// 높이 설정
					style.height = 360;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 
					InitHeadMode(true, true, false, true, false,false)
					
                    var HeadTitle = "|Sel|Seq|From D/Dock Date|To D/Dock Date|Duration|Duration|Class Recommendation Type";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  	true,    "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    daCenter,  	false,   "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	40,    daCenter,  	false,   "Seq");
					
					InitDataProperty(0, cnt++ , dtData,      	130,   daCenter,  	false,   "dck_fm_dt",     			true,          "",      dfDateYmd,  	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	130,   daCenter,  	false,   "dck_to_dt",     			true,          "",      dfDateYmd,  	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  	false,   "dck_dur_dys",     		true,          "DateDiff(d, |3|, |4|)",      dfNone,      		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  	false,   "dck_dur_dys_days",     	false,         "",      dfNone,      	0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      	200,   daLeft,  	false,   "flet_dck_svey_tp_cd",		true,          "",      dfNone,      	0,     true,       true);				
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    daCenter,  	false,   "vsl_cd",   				false,         "",      dfNone,      	0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    daCenter,  	false,   "dck_sel_cd",      		false,         "",      dfNone,      	0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    daCenter,  	false,   "dck_seq",      			false,         "",      dfNone,      	0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    daLeft,  	false,   "flet_dck_sts_cd",      	false,         "",      dfNone,      	0,     true,       false);

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
	        	   	sheetObj.DoSearch("ESM_FMS_0054_2GS.do", FormQueryString(formObj));
	        	   
	  	   	  		inputReadOnly("Search");
	  	   	  	}	

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction),true,true,false)return;
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0054_2GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					formObj.f_cmd.value = SEARCH02;
					
		   			var param = "&cd_id=CD01748"+"&com_code=flet_dck_svey_tp_cd"
		   						+"&com_text=flet_dck_svey_tp_cdText";
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0006GS.do" , FormQueryString(formObj)+param);
		
	    			setMakeCombo(sheetObj, ComGetEtcData(sXml, "flet_dck_svey_tp_cdText"), ComGetEtcData(sXml, "flet_dck_svey_tp_cd"), "flet_dck_svey_tp_cd");

	    		} else if (Col == "vsl_cd") {
					
					formObj.f_cmd.value = SEARCH01;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
				}	

        }
    }

    
    /**
     * Type Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboCode   Type 의 코드값
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  col   		column name
     **/
    function setMakeCombo(sheetObj, comboText, comboCode, Col) {
		if(typeof comboCode != "undefined" && comboCode != "") {
        	sheetObj.InitDataCombo(0, Col, comboText.substring(0,comboText.length-1), comboCode.substring(0,comboCode.length-1));
    	}
    }
    
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly = false;
	    	
	    	document.images["btn_vslpop"].name = "btn_vslpop";
	    	
	    	form.btn_vslpop.style.cursor = "hand";
	    	
    	} else {
	    	if(sheetObjects[0].RowCount == 1 || flag == "Search") {
		    	form.vsl_cd.readOnly = true;
		    	
		    	document.images["btn_vslpop"].name = "no_btn_vslpop";
		    	
		    	form.btn_vslpop.style.cursor = "default";
	    	}
    	}
    }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value) {

 			if (sheetObj.ColSaveName(Col) == "dck_fm_dt") {
 			
 				if (sheetObj.CellValue(Row, "dck_to_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "dck_to_dt") < Value) {
 						ComShowCodeMessage("FMS01709");
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}

 			} else if (sheetObj.ColSaveName(Col) == "dck_to_dt") {
 			
 				if (sheetObj.CellValue(Row, "dck_fm_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "dck_fm_dt") > Value) {
 						ComShowCodeMessage("FMS01711");
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			
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


	/* 개발자 작업  끝 */