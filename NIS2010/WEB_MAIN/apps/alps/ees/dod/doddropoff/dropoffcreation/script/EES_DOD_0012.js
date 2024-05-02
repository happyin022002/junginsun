/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0012.js
*@FileTitle : Discount Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
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
     * @class EES_DOD_0012 : EES_DOD_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DOD_0012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var loadingMode = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject	 = sheetObjects[0];
    	
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

          	switch(srcName) {
	          	case "btn_close":
	          		self.close();
	          		break;
	          	case "btn_confirm":
    	            doActionIBSheet(sheetObject, formObject, MULTI01);
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
    	loadingMode = true;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = false;
		
		//html컨트롤 이벤트초기화
		initControl();
		
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {    	
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListener('keypress', 'obj_keypress', form);	//- form 전체 컨트롤 중 keypress 이벤트 발생시
		
    }

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress() {

    	switch(event.srcElement.dataformat) {
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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
					style.height = 280;
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
					InitColumnInfo(26, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "|Office|BKG No.|TRO Date|CNTR No.|TP/SZ|BKG DEL|RTN CY|RTN Date|Cust Code|Cust Name|Special Cust Code|Special Cust Name|RFA No.|S/C No.|CUR|General Tariff|Special Tariff|Discount|Final AMT|File|Remark|";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		 50,	daCenter,  	false,	"tro_ib_cfm_ofc_cd",	false,          "",      dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"bkg_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"tro_ib_cfm_dt",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"cntr_no",	 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 40,	daCenter,  	false,	"cntr_tpsz_cd",			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"del_cd", 				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"cntr_rtn_yd_cd", 		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"cntr_rtn_dt", 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 70,	daCenter,  	false,	"customer",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 150,	daLeft,  	false,	"customer_nm", 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 110,	daCenter,  	false,	"spcl_customer",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 150,	daLeft,  	false,	"spcl_customer_nm",		false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"rfa_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"sc_no",				false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 40,	daCenter,  	false,	"curr_cd",	 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"gen_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 90,	daCenter,  	false,	"spcl_trf_amt",			false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 60,	daCenter,  	false,	"dc_amt",	 			false,          "",      dfFloat,	 2,     true,       false);
					InitDataProperty(0, cnt++ , dtData,      	 70,	daCenter,  	false,	"ttl_amt", 				false,          "",      dfFloat,	 2,     false,      false);
					InitDataProperty(0, cnt++ , dtPopupEdit,     60,	daCenter,  	false,	"atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 180,	daLeft,  	false,	"dc_rmk",				false,          "",      dfNone,     0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	 180,	daLeft,  	false,	"temp",					false,          "",      dfNone,     0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	 190,   daCenter,   true,   "auth_apro_rqst_no",    false,          "",      dfNone,	 0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,        0,     daLeft,     false,  "auth_apro_rqst_no_seq",false,          "",      dfNone,   	 0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,        40,	daCenter,  	false,	"atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
					
					ShowButtonImage = 2;
               }
               break;
                       	   
        }
    }
   
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, Col, Row) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH:      //Retrieve
				/*
				if(!validateForm(sheetObj, formObj, sAction)) {
					return;	
				}
				*/
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_DOD_0012GS.do", FormQueryString(formObj));
				break;
           case MULTI01:
        	   // 동일한 AUTH_APRO_RQST_NO가 넘어가지않도록
        	   for(var i = 1; i <= sheetObj.RowCount; i++) {
        		   if(sheetObj.CellValue(1, "auth_apro_rqst_no_seq") == 1){
        			   sheetObj.CellValue2(i, "ibflag") = "U";
        		   }else{
        			   sheetObj.CellValue2(i, "ibflag") = "R";
        		   }
               }

        	   formObj.f_cmd.value = COMMAND02;
        	   selectVal = FormQueryString(formObj);

        	   sheetObj.DoSave("COM_ENS_0U1GS_AUTH.do", selectVal, -1, false);
        	   break;
				
		}
	}

    /** 
    * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {int} x 필수, X 좌표
    * @param {int} y 필수, Y 좌표
    * @return 없음
    */   
 	function sheet1_OnMouseMove(sheetObj, button, shift, x, y){
 		with(sheetObj){

 			if(ColSaveName(MouseCol) == "atch_file_lnk_cnt" || ColSaveName(MouseCol) == "cust_cd_seq") {
 				sheetObj.MousePointer = "Hand";
 			} else {
 				MousePointer = "Default";
 			} 	
 		}
 	}
 	
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		switch (sheetObj.ColSaveName(Col)) {
			case "atch_file_lnk_cnt":
				dodFileUploadPopUp(sheetObj, Row, "CHG", "N", "");
				break;
				
			default:
				break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {

		sheetObj.CellValue2(1, "auth_apro_rqst_no_seq") = 1;
		for(var i = 1; i <= sheetObj.LastRow; i++){
			if(sheetObj.CellValue(1, "auth_apro_rqst_no") != sheetObj.CellValue(i, "auth_apro_rqst_no")){
				sheetObj.CellValue2(i, "auth_apro_rqst_no_seq") = 1;
			}
		}

	}
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	//공통 체크	       
    	with(formObj){        	
        } 

        return true;
    }

	/* 개발자 작업  끝 */