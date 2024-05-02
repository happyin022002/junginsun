/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0037.js
*@FileTitle : Revenue VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.01 윤세영
* --------------------------------------------------------------
* History
* 2010.10.11 원종규 [CHM-201006364-01] FMS SYSTEM 변경 적용 - 추정 결산 항차 관련 NE4와 같이 Lane 숫자 포함되어지므로 숫자 혼용 가능하게 수정
* 2011.01.19 이준범 [CHM-201108373-01] Revenuse VVD Creation 관련
* 작업내용 : 1) ERP Target VVD 선정 I/F 시 FMS에 임의로 생성된 VVD 삭제
*          2) finalizing_flg 로 제어
* 2011.06.27 [CHM-201111750-01]
* 개발자 : 이준범
* 제   목 : Revenue VVD Creation 화면 ALL SEL 기능 추가 요청
* 내   용 : All 체크 할 수 있도록 InitHeadMode()옵션 변경
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
     * @class esm_fms_0037 : esm_fms_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0037() {
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
	
	//html form
	var frm = null;

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
	             	frm.finalizing_flg.value = "N"; // VVD CD Finalizing From ERP 해제
	             	frm.processing_flg.value = "N"; // VVD CD Processing From ERP 해제
                break;

				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					
					ComResetAll();
					inputReadOnly('New');
                break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                break;
	
				case "btn_vvdcreation":
					if (form.created_type[0].checked) {//Creation
						
		             	if(!CoFmsInitConfirm(sheetObject)) return;
						frm.finalizing_flg.value = "N"; // VVD CD Finalizing From ERP 해제
						frm.processing_flg.value = "N"; // VVD CD Processing From ERP 해제
		             	doActionIBSheet(sheetObject,formObject,IBSEARCH, "vvdcreation");

					}
                break;
	
				case "btn_vvdfinalizing":

					if (form.created_type[0].checked) {//Creation
		             	if(!CoFmsInitConfirm(sheetObject)) return;
						frm.finalizing_flg.value = "Y"; // VVD CD Finalizing From ERP 설정
		             	doActionIBSheet(sheetObject,formObject,IBSEARCH, "vvdfinalizing");

					}
                break;

				case "btn_vvdprocessing":

					if (form.created_type[0].checked) {//Creation
		             	if(!CoFmsInitConfirm(sheetObject)) return;
						frm.processing_flg.value = "Y"; // VVD CD Process ing From ERP 설정
		             	doActionIBSheet(sheetObject,formObject,IBSEARCH, "vvdprocessing");

					}
                break;
                
				case "btn_add":
					
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert(-1);
					sheetObject.Cellvalue(row, "rev_yrmon") = formObject.rev_yrmon.value;
					
                break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert();
					sheetObject.Cellvalue(row, "rev_yrmon") = formObject.rev_yrmon.value;
					
					break;

				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;

     			case "btn_period":
     				var cal = new ComCalendar();

 					cal.setDisplayType('month');
					cal.select(form.rev_yrmon, 'yyyy-MM');
					
					sheetObject.RemoveAll();
					break;					
                    
				case "btn_lanepop":
					ComOpenPopup("ESM_FMS_0036.do", 620, 428,"setLaneCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0036");
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

   		frm = document.form;
   		
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
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListener      ('keypress',        'engnum_keypress' , 'slan_cd', 'rlane_cd');  // 영문 대문자/숫자만 입력하기 
    	axon_event.addListenerForm  ('blur'				, 'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리

        axon_event.addListener  ('keypress', 'obj_keypress' , form);					//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('change'  , 'lane_cd_change', 'slan_cd');				//- Service Lane Code 입력 후 코드 검증
        axon_event.addListener  ('change'  , 'rlane_cd_change', 'rlane_cd');			//- Revenue Lane Code 입력 후 코드 검증
        axon_event.addListener  ('click'   , 'created_type_click', 'created_type');		//- Created Type 클릭시 검색 조건 및 버튼 제어
        axon_event.addListener  ('click'   , 'condition_click', 'condition');			//- Condition 클릭시 Lane Code 종류 제어

		//Created Type에 따라 검색 조건 및 버튼 제어
		created_type_click();
		
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function engnum_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
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
	        case "engup":
	        	switch(event.srcElement.name){
		        	case "slan_cd":
		            	ComKeyOnlyAlphabet('uppernum');
		        	    break;	 
		        	case "rlane_cd":
	            		ComKeyOnlyAlphabet('uppernum');
	        	    	break; 
		        	default:
		        		ComKeyOnlyAlphabet('upper');
		        	  	break;	
	        	}
	        	break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
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

    	form.rev_yrmon.readOnly = readOnly;
    	
    	document.images["btn_period"].name = img+"btn_period";
    	
    	form.btn_period.style.cursor = cursor;
    	
		//Created Type에 따라 검색 조건 및 버튼 제어
		created_type_click();


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
					style.height = 303;
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
					InitColumnInfo(13, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "|Sel|Seq|Revenue Month|Service Lane|Revenue Lane|Service Lane Direction|VVD Code|Start Date|End Date";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	 40,    daCenter,   false,  "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,    		 40,    daCenter,  	true,   "Seq");
                    InitDataProperty(0, cnt++ , dtData,      	 130,   daCenter,  	true,   "rev_yrmon",    	true,          "",      dfDateYm, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 130,   daCenter,  	true,   "slan_cd", 			true,          "",      dfNone,     0,     false,      true, 3);
					InitDataProperty(0, cnt++ , dtData,      	 130,   daCenter,  	false,  "rlane_cd",	 		true,          "",      dfNone,   	0,     false,      true, 5);
					InitDataProperty(0, cnt++ , dtData,       	 170,   daCenter,  	false,  "skd_dir_cd",  		true,          "",      dfNone, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,   daCenter,  	true,   "vvd_cd",     		true,          "",      dfNone, 	0,     false,      true, 10);
					InitDataProperty(0, cnt++ , dtData,   	   	 100,   daCenter,  	true,   "vst_dt",   		true,          "",      dfDateYmd,	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      	 100,   daCenter,  	true,   "ved_dt",   		true,          "",      dfDateYmd,	0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "rev_dir_cd");
				
					InitDataValid(0, "slan_cd", 	vtEngUpOther, "0123456789");
					InitDataValid(0, "rlane_cd", 	vtEngUpOther, "0123456789");
					InitDataValid(0, "vvd_cd", 		vtEngUpOther, "0123456789"); 

                }
                break;

         }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
         	
	 			if(!validateForm(sheetObj,formObj,sAction))return;

         		if (Col == "vvdcreation") {//VVD CD Creation In FMS
	        		formObj.f_cmd.value = SEARCH01;
         		} else if (Col == "vvdfinalizing") {//VVD CD Finalizing From ERP 
	        		formObj.f_cmd.value = SEARCH02;
         		} else if (Col == "vvdprocessing") {//VVD CD Processing From ERP 
	        		formObj.f_cmd.value = SEARCH03;	
         		} else {//Retrieve
	        		formObj.f_cmd.value = SEARCH;
         		}

        	   	sheetObj.DoSearch("ESM_FMS_0037GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
//        	   	inputReadOnly('');
        	   
                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0037GS.do", FormQueryString(formObj));
	 			frm.finalizing_flg.value = "N"; // VVD CD Finalizing From ERP 해제
	 			frm.processing_flg.value = "N"; // VVD CD Processing From ERP 해제
                break;

			case IBROWSEARCH:   

	    		if (Col == "slan_cd") {//Service Lane 코드 체크
					
					var param = 'f_cmd='+SEARCH05;
					if(typeof Row == "undefined" || Row == "" ) {
						param += "&lane_cd="+formObj.slan_cd.value;		//form에서 호출하는 경우
					} else {
						param += "&lane_cd="+sheetObj.CellValue(Row, Col);//grid에서 호출하는 경우
					}

		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			
		   			if(typeof cdName == "undefined" || cdName == "" ) {

						if(typeof Row == "undefined" || Row == "" ) {
							formObj.slan_cd.value = "";
							ComAlertFocus(formObj.slan_cd, ComGetMsg("FMS01237"));
						} else {
							ComShowCodeMessage("FMS01237");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
						}
						
					}
		   			
	 				//sheetObjects[0].RemoveAll();
	 				
	    		} else if (Col == "rlane_cd") {//Revenue Lane 코드 체크
					
					var param = 'f_cmd='+SEARCH07;
					if(typeof Row == "undefined" || Row == "" ) {
						param += "&rlane_cd="+formObj.rlane_cd.value;		//form에서 호출하는 경우
					} else {
						param += "&rlane_cd="+sheetObj.CellValue(Row, Col);//grid에서 호출하는 경우
					}
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			
		   			if(typeof cdName == "undefined" || cdName == "" ) {

						if(typeof Row == "undefined" || Row == "" ) {
							formObj.rlane_cd.value = "";
							ComAlertFocus(formObj.rlane_cd, ComGetMsg("FMS01237"));
						} else {
							ComShowCodeMessage("FMS01237");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
						}
						
					}
		   			
	 				//sheetObjects[0].RemoveAll();
	 				
	    		} else if (Col == "vvd_cd") {
					
					var param = 'f_cmd='+SEARCH06 + "&vvd_cd="+sheetObj.CellValue(Row, Col);//grid에서 호출하는 경우

		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		
		   			var cdName = ComGetEtcData(sXml, "vslCd");

		   			if(typeof cdName == "undefined" || cdName == "" ) {

						ComShowCodeMessage("FMS01144");
						sheetObj.CellValue2(Row, Col) = "";
						sheetObj.SelectCell(Row, Col);

					} else {
		   				cdName = sheetObj.CellValue(Row, Col);
		   				sheetObj.CellValue2(Row, "vsl_cd") = cdName.substring(0,4);
		   				sheetObj.CellValue2(Row, "skd_voy_no") = cdName.substring(4,8);
		   				sheetObj.CellValue2(Row, "skd_dir_cd") = cdName.substring(8,9);
		   				sheetObj.CellValue2(Row, "rev_dir_cd") = cdName.substring(9,10);
						
					}
				}	
        	   
                break;
        }
    }

    /**
	 * Lane Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setLaneCd(aryPopupData){
		form.slan_cd.value = aryPopupData[0][3];
	}
    
    /**
     * Service LaneCd 변경 시 해당 Lane Code 체크. <br>
     **/
    function lane_cd_change() {
    	if (form.slan_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'slan_cd');
    	}
    }
    
    /**
     * Revenue LaneCd 변경 시 해당 Lane Code 체크. <br>
     **/
    function rlane_cd_change() {
    	if (form.rlane_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'rlane_cd');
    	}
    }
    
    /**
     * Created Type 클릭 시 검색 조건 및 버튼 제어. <br>
     **/
    function created_type_click() {   
   	  
    	 if (form.created_type[0].checked) {//Creation
   			form.slan_cd.disabled = true;
   			form.slan_cd.value = '';
   			form.slan_cd.className = "input2";
   			form.rlane_cd.disabled = true;
   			form.rlane_cd.value = '';
   			form.rlane_cd.className = "input2";
	    	form.condition[0].disabled = true;
	    	form.condition[1].disabled = true;
	    	form.condition[0].checked = true;
    		document.images["btn_lanepop"].name = "no_btn_lanepop";
	    	form.btn_lanepop.style.cursor = "default";
    		
    		ComBtnEnable("btn_vvdcreation");
    		ComBtnEnable("btn_vvdfinalizing");
    		ComBtnEnable("btn_vvdprocessing");
    	} else {//Amend
    		frm.finalizing_flg.value = "N"; // VVD CD Finalizing From ERP 해제
    		frm.processing_flg.value = "N"; // VVD CD Processing From ERP 해제
   			form.slan_cd.disabled = false;
   			form.slan_cd.className = "input";
   			form.rlane_cd.disabled = false;
   			form.rlane_cd.className = "input";
	    	form.condition[0].disabled = false;
	    	form.condition[1].disabled = false;
	    	//form.condition[1].checked = true;
    		document.images["btn_lanepop"].name = "btn_lanepop";
	    	form.btn_lanepop.style.cursor = "hand";
    		
    		ComBtnDisable("btn_vvdcreation");
    		ComBtnDisable("btn_vvdfinalizing");
    		ComBtnDisable("btn_vvdprocessing");
    		
    		condition_click();
    	}
    	 
    	 sheetObjects[0].RemoveAll();
    }

    /**
     * Condition 클릭시 Lane Code 종류 제어 <br>
     **/
    function condition_click() {

    	if (form.condition[0].checked) {//Service
   			form.slan_cd.disabled = false;
   			form.slan_cd.className = "input";
   			form.rlane_cd.disabled = true;
   			form.rlane_cd.value = '';
   			form.rlane_cd.className = "input2";
    		document.images["btn_lanepop"].name = "btn_lanepop";
	    	form.btn_lanepop.style.cursor = "hand";
	    	document.form.slan_cd.focus();
    	} else {//Revenue
   			form.slan_cd.disabled = true;
   			form.slan_cd.value = '';
   			form.slan_cd.className = "input2";
   			form.rlane_cd.disabled = false;
   			form.rlane_cd.className = "input";
    		document.images["btn_lanepop"].name = "no_btn_lanepop";
	    	form.btn_lanepop.style.cursor = "default";
	    	document.form.rlane_cd.focus();
    	}
    	
    	sheetObjects[0].RemoveAll();
    }

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
	
		if (!ComChkValid(formObj)) return false;
	
	 return true;
	}


     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "slan_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "rlane_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "skd_dir_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "vvd_cd", "Courier New"); 	
	}	

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value)
 		{

 			if (sheetObj.ColSaveName(Col) == "slan_cd") {
 				
        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", Row);

 			} else if (sheetObj.ColSaveName(Col) == "rlane_cd") {
 				
        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "rlane_cd", Row);

 			} else if (sheetObj.ColSaveName(Col) == "vvd_cd") {

        		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vvd_cd", Row);

 			} else if  (sheetObj.ColSaveName(Col) == "vst_dt") {
 				
 				var endDt = sheetObj.CellValue(Row, "ved_dt");
 				if (endDt != "" && Value > endDt) {
 					ComShowCodeMessage("FMS01093");
 					sheetObj.CellValue2(Row, Col) = "";
 					sheetObj.SelectCell(Row, Col);
 				}
 			
 			} else if  (sheetObj.ColSaveName(Col) == "ved_dt") {
 				
 				var startDt = sheetObj.CellValue(Row, "vst_dt");
 				if (startDt != "" && Value < startDt) {
 					ComShowCodeMessage("FMS01094");
					sheetObj.CellValue2(Row, Col) = '';
					sheetObj.SelectCell(Row, Col);
 				}
 			}
 			
 		}
    
	/* 개발자 작업  끝 */