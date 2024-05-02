/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0054_1.js
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 유재민
*@LastVersion : 1.0
* 2009.04.24 윤세영
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 
* 2011.03.18 유재민 [CHM-201109295-01] Location 조회불가건 수정 보완 요청
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
     * @class esm_fms_0054_1 : esm_fms_0054_1 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0054_1() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnValidation	= sheet1_OnValidation;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
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
					sheetObject.SelectCell(row, "phs_out_dt");
					sheetObject.CellValue(row, "dck_dur_dys_days") = "Days";
					sheetObject.CellValue(row, "dck_fm_dt_time") = "0000";
					sheetObject.CellValue(row, "dck_to_dt_time") = "0000";
					
					sheetObject.CellValue(row,"vsl_cd") = formObject.vsl_cd.value;
					sheetObject.CellValue(row,"dck_sel_cd") = formObject.dck_sel_cd.value;
					
                break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert();
					sheetObject.SelectCell(row, "phs_out_dt");
					sheetObject.CellValue(row, "dck_dur_dys_days") = "Days";
					sheetObject.CellValue(row, "dck_fm_dt_time") = "0000";
					sheetObject.CellValue(row, "dck_to_dt_time") = "0000";
					
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
					InitColumnInfo(21, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 
					InitHeadMode(true, true, false, true, false,false)
					
                    var HeadTitle = "|Sel|Seq|Status|Phased Out|PO Port|From D/Dock Date|From D/Dock Date|To D/Dock Date|To D/Dock Date|Dock LOC|Duration|Duration|Yard|Phased In|PI Port|Dry Dock Type|Yd Seq";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,    "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	30,    	daCenter,  	false,   "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,        	30,    	daCenter,  	false,   "Seq");
					InitDataProperty(0, cnt++ , dtCombo,       	71,    	daCenter,  	false,   "flet_dck_sts_cd",		true,          "",      dfNone,      		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	95,    	daCenter,  	false,   "phs_out_dt",      	false,         "",      dfDateYmd,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,    66,    	daCenter,  	false,   "phs_out_port_cd",   	false,         "",      dfEngUpKey,      	0,     true,       true, 5);
					
					InitDataProperty(0, cnt++ , dtData,      	95,   	daCenter,  	false,   "dck_fm_dt",     		true,          "",      dfDateYmd,  		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	40,   	daCenter,  	false,   "dck_fm_dt_time",     	true,          "",      dfTimeHm,  			0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	85,   	daCenter,  	false,   "dck_to_dt",     		true,          "",      dfDateYmd,  		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	40,   	daCenter,  	false,   "dck_to_dt_time",     	true,          "",      dfTimeHm,  			0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopupEdit,    75,    	daCenter,  	false,   "dck_loc_cd",     		false,         "",      dfEngUpKey,     	0,     true,       true, 5);
					InitDataProperty(0, cnt++ , dtData,      	35,    	daCenter,  	false,   "dck_dur_dys",     	true,          "DateDiff(d, |6|, |8|)",      dfNone,      		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	false,   "dck_dur_dys_days",    false,         "",      dfNone,      		0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,   		115,   	daLeft,  	false,   "shp_yd_nm",     		false,         "",      dfNone,  			0,	   true,	   true);
					InitDataProperty(0, cnt++ , dtData,      	85,    	daCenter,  	false,   "phs_in_dt",     		false,         "",      dfDateYmd,			2,     true,       true);
					
					InitDataProperty(0, cnt++ , dtPopupEdit,    63,    	daCenter,  	false,   "phs_in_port_cd",    	false,         "",      dfEngUpKey,      	0,     true,       true, 5);
					InitDataProperty(0, cnt++ , dtCombo,      	120,   	daLeft,  	false,   "flet_dck_svey_tp_cd",	true,          "",      dfNone,      		0,     true,       true);				
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    	daCenter,  	false,   "vsl_cd",   			false,         "",      dfNone,      		0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    	daCenter,  	false,   "dck_sel_cd",      	false,         "",      dfNone,      		0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   	30,    	daCenter,  	false,   "dck_seq",      		false,         "",      dfNone,      		0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden, 		30,    	daCenter,  	false,   "yd_seq",     	 		false,         "",      dfNone,     		0,	   true,	   true);
					
					InitDataValid(0, "phs_out_port_cd", vtEngUpOther,"0123456789");
					InitDataValid(0, "dck_loc_cd", vtEngUpOther,"0123456789");
					InitDataValid(0, "phs_in_port_cd", vtEngUpOther,"0123456789");
					
					DataLinkMouse("phs_out_port_cd") = true;
					DataLinkMouse("dck_loc_cd") = true;
					DataLinkMouse("phs_in_port_cd") = true;
					DataLinkMouse("shp_yd_nm") = true;

					UseDefaultTime = false;//현재 시간을 표시하지 않고 공백의 마스크 상태 표시
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
	        	   	sheetObj.DoSearch("ESM_FMS_0054_1GS.do", FormQueryString(formObj));
	        	   
	  	   	  		inputReadOnly("Search");
	  	   	  	}	

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction)) return;
           		
	           	var arrSheets = new Array(sheetObj);
				var sParam = ComGetSaveString(arrSheets);
				
				if (sheetObj.IsDataModified && sParam == "") {
					return; 
				}
			
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0054_1GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					formObj.f_cmd.value = SEARCH02;
					
		   			CoFmsGetCombo("GRID", formObj, sheetObj, "CD01747:CD01748","flet_dck_sts_cd:flet_dck_svey_tp_cd", "flet_dck_sts_cdText:flet_dck_svey_tp_cdText");
		
	    		} else if (Col == "phs_out_port_cd" || Col == "dck_loc_cd" || Col == "phs_in_port_cd") {

					formObj.f_cmd.value = SEARCH04;
					
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj)+"&loc_cd="+sheetObj.CellValue(Row,Col));
		
	    			chkPortCode(sheetObj, sXml, Row, Col);

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

 			if (sheetObj.ColSaveName(Col) == "phs_out_port_cd" || sheetObj.ColSaveName(Col) == "dck_loc_cd" 
 				|| sheetObj.ColSaveName(Col) == "phs_in_port_cd") {
 				
        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, sheetObj.ColSaveName(Col), Row);

 			} else if (sheetObj.ColSaveName(Col) == "flet_dck_sts_cd") {

 				if (Value == 'E') {
					sheetObj.CellEditable(Row, "dck_fm_dt_time")= false;
					sheetObj.CellEditable(Row, "dck_to_dt_time")= false;
					sheetObj.CellValue(Row, "dck_fm_dt_time") = "0000";
					sheetObj.CellValue(Row, "dck_to_dt_time") = "0000";

 				} else {
					sheetObj.CellEditable(Row, "dck_fm_dt_time")= true;
					sheetObj.CellEditable(Row, "dck_to_dt_time")= true;
					sheetObj.CellValue(Row, "dck_fm_dt_time") = "";
					sheetObj.CellValue(Row, "dck_to_dt_time") = "";
 				}
					 				
 			} else if (sheetObj.ColSaveName(Col) == "phs_out_dt") {
 			
 				if (sheetObj.CellValue(Row, "dck_fm_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "dck_fm_dt") < Value) {
 						ComShowCodeMessage('FMS01708');
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			} else if (sheetObj.ColSaveName(Col) == "dck_fm_dt") {
 			
 				if (sheetObj.CellValue(Row, "dck_to_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "dck_to_dt") < Value) {
 						ComShowCodeMessage('FMS01709');
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}

 				if (sheetObj.CellValue(Row, "phs_out_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "phs_out_dt") > Value) {
 						ComShowCodeMessage('FMS01710');
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}

 			} else if (sheetObj.ColSaveName(Col) == "dck_to_dt") {
 			
 				if (sheetObj.CellValue(Row, "dck_fm_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "dck_fm_dt") > Value) {
 						ComShowCodeMessage('FMS01711');
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			
 				if (sheetObj.CellValue(Row, "phs_in_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "phs_in_dt") < Value) {
 						ComShowCodeMessage('FMS01712');
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			} else if (sheetObj.ColSaveName(Col) == "phs_in_dt") {
 			
 				if (sheetObj.CellValue(Row, "dck_to_dt") != '') {
 				
 					if (sheetObj.CellValue(Row, "dck_to_dt") > Value) {
 						ComShowCodeMessage('FMS01713');
 						sheetObj.CellValue2(Row, Col) = '';
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			}
 			
	}

	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow,NewCol) {
	
		if (sheetObj.ColSaveName(NewCol) == "dck_fm_dt_time" || sheetObj.ColSaveName(NewCol) == "dck_to_dt_time") {

			if (sheetObj.CellValue(NewRow, "flet_dck_sts_cd") == 'E') {
				sheetObj.CellEditable(NewRow, "dck_fm_dt_time")= false;
				sheetObj.CellEditable(NewRow, "dck_to_dt_time")= false;

			} else {
				sheetObj.CellEditable(NewRow, "dck_fm_dt_time")= true;
				sheetObj.CellEditable(NewRow, "dck_to_dt_time")= true;
			}
					 				
 		} 
	}
	
    /**
     * Port 코드를 체크한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 명칭
     * @param {String}  comboCode   Type 의 코드값
     * @param {int}  	col   		column index
     **/
    function chkPortCode(sheetObj, sXml, Row, Col) {
    	if (sXml != "" ) {
			if (ComGetEtcData(sXml, "cdName") != undefined) {
				

	    	} else {
				
				sheetObj.CellValue2(Row,Col) = '';
				ComShowCodeMessage("FMS01079");
				sheetObj.SelectCell(Row, Col);
	    	}
	    }		
    }


     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnPopupClick(sheetObj, Row,Col)
	{
	
		if (sheetObj.ColSaveName(Col) == "phs_out_port_cd") {
			ComOpenPopup("COM_ENS_051.do", 720, 480, "setPortCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_051");
		} else if (sheetObj.ColSaveName(Col) == "dck_loc_cd") {
			ComOpenPopup("COM_ENS_051.do", 720, 480, "setPortCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_051");
		} else if (sheetObj.ColSaveName(Col) == "phs_in_port_cd") {
			ComOpenPopup("COM_ENS_051.do", 720, 480, "setPortCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_051");
		} else if(sheetObj.ColSaveName(Col) == "shp_yd_nm") {
			ComOpenPopup("ESM_FMS_0082.do", 300, 340, "setSheetYardName", "1,0,1,1,1,1", false, false, Row, Col, 0, "esm_fms_0082");
		}
		
	}

	/**
	* Port/Location 입력부분.<br>
	* @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	*/
	function setPortCd(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].CellValue2(Row, Col) = aryPopupData[0][3];
	}
     
	/**
	 * Vendor Code 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVendorCode(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[0].CellValue2(Row,Col) = aryPopupData[0][5];
		sheetObjects[0].CellValue2(Row,"vndr_lgl_eng_nm") = aryPopupData[0][3];
		if (aryPopupData[0][4] == 'KR') {
			sheetObjects[0].CellValue2(Row,"tax_required") = 'Mandatory';
		} else {
			sheetObjects[0].CellValue2(Row,"tax_required") = '';
		}	
	}
	
	/**
	 * Yard 팝업창에서 선택한 Ship Yard Name과 시퀀스를 Sheet에 설정한다.<br>
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 */
    function setSheetYardName(aryPopupData, Row, Col, sheetIdx){
		 sheetObjects[0].CellValue2(Row, "shp_yd_nm") = aryPopupData[0][4];
		 sheetObjects[0].CellValue2(Row, "yd_seq") = aryPopupData[0][3];
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        if (sAction == IBSAVE) {

			// 수정, 삭제인 행을 알아오기
			//인자->U|D, 결과->1;3;4;5;6;
			var sRow = sheetObj.FindStatusRow("I|U");
			
			//받은 결과를 배열로 생성한다.
			var arrRow = sRow.split(";");
			var arrLen = arrRow.length-1;

			for (idx=0; idx<arrLen; idx++) { 

				//Completed인 경우 필수입력사항 체크
				if (sheetObj.CellValue(arrRow[idx], "flet_dck_sts_cd") == "C") {
					
					//Phased Out
					if (sheetObj.CellValue(arrRow[idx], "phs_out_dt") == "") {
						ComShowCodeMessage("FMS00004", "Phased Out");
						sheetObj.SelectCell(arrRow[idx], "phs_out_dt");
						return false;
					}
					//PO Port
					if (sheetObj.CellValue(arrRow[idx], "phs_out_port_cd") == "") {
						ComShowCodeMessage("FMS00004", "PO Port");
						sheetObj.SelectCell(arrRow[idx], "phs_out_port_cd");
						return false;
					}
					//Dock LOC
					if (sheetObj.CellValue(arrRow[idx], "dck_loc_cd") == "") {
						ComShowCodeMessage("FMS00004", "Dock LOC");
						sheetObj.SelectCell(arrRow[idx], "dck_loc_cd");
						return false;
					}
					//Phased In
					if (sheetObj.CellValue(arrRow[idx], "phs_in_dt") == "") {
						ComShowCodeMessage("FMS00004", "Phased In");
						sheetObj.SelectCell(arrRow[idx], "phs_in_dt");
						return false;
					}
					//PI Port
					if (sheetObj.CellValue(arrRow[idx], "phs_in_port_cd") == "") {
						ComShowCodeMessage("FMS00004", "PI Port");
						sheetObj.SelectCell(arrRow[idx], "phs_in_port_cd");
						return false;
					}

				}
			}

        }
        
        return true;
    }
    
    /**
     * 저장함수에서 저장직전에 Vlidation을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
 	function sheet1_OnValidation(sheetObj,row,col,value) {
 		
 		var fromDate = "";
 		var toDate = "";

 		var dckFmDtCol = sheetObj.SaveNameCol("dck_fm_dt");
		var dckFmDtValue = sheetObj.CellValue(row,dckFmDtCol);
		
		var dckFmDtTimeCol = sheetObj.SaveNameCol("dck_fm_dt_time");
		var dckFmDtTimeValue = sheetObj.CellValue(row,dckFmDtTimeCol);
		
		var dckToDtCol = sheetObj.SaveNameCol("dck_to_dt");
		var dckToDtValue = sheetObj.CellValue(row,dckToDtCol);
		
		var dckToDtTimeCol = sheetObj.SaveNameCol("dck_to_dt_time");
		var dckToDtTimeValue = sheetObj.CellValue(row,dckToDtTimeCol);
		

		// To D/Dock Date 가 From D/Dock Date 크거나 같은지 체크한다
		if(dckFmDtTimeValue != "" && dckToDtTimeValue != "") {

			fromDate = dckFmDtValue + dckFmDtTimeValue;
			toDate = dckToDtValue + dckToDtTimeValue;
			
			if(parseInt(fromDate) > parseInt(toDate)) {

				ComShowCodeMessage('FMS01709');

				sheetObj.CellValue2(row,"dck_to_dt") = "";
				sheetObj.CellValue2(row,"dck_to_dt_time") = "";
				sheetObj.SelectCell(row,"dck_to_dt");
				sheetObj.ValidateFail = true;
				return;
			}
		}
 	}
     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "phs_out_port_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "dck_loc_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "phs_in_port_cd", "Courier New"); 	
	}	

	/* 개발자 작업  끝 */ 	