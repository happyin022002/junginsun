/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0207.js
*@FileTitle : COD Tariff Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥
* 1.0 Creation
*=========================================================
* History
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
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
     * @class VOP_OPF_0207 : VOP_OPF_0207 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_OPF_0207() {
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
	var sheet1_Editable_Flg = true;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  = sheetObjects[0];   //sheet1
      
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			
				case "btn_close":
					window.close();
					break;
				
				case "btn_ok":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
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

		//COD Request Information 조회
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();
	}
	
	/**
     * Sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
	function sheet2_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
	
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
        axon_event.addListenerFormat('focus',     'obj_activate',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',  'obj_keypress',   form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
    		case "numonly":
    			ComKeyOnlyNumber(event.srcElement);	//숫자입력하기
    			break;
    		default:    	    	
    			ComKeyOnlyAlphabet("num");					//공통기준:영문, 숫자만을 인식
	    		break;
    	}
    }
    
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 
         var cnt = 0;
 		 var sheetID = sheetObj.id;
 		 var formObject = document.form;
 				
         switch(sheetID) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 200;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(5, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "|conti_cd|dvs_fee_tp_cd|dir_cd|dvs_fee_amt";
                   
 					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"conti_cd",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"dvs_fee_tp_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"dir_cd",				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"dvs_fee_amt",		false,	"",		dfNone,		0,	true,	true);
                    
                    CountPosition = 0;
				   }
                 break;                 

             case "sheet2":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 150;;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     //Editable = true;
                     if(formObject.isPop.value == "R"){
                    	 Editable = false;
                     }else{
                    	 Editable = true;
                     }                     

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 3, 1, 2, 100);

 					 var HeadTitle1 = "||Region|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff|COD MIN. Tariff";
					 var HeadTitle2 = "||Region|20Ft|40Ft|Inter Port|Per Box|Per Box|Per B/L|Per B/L";
					 var HeadTitle3 = "||Region|20Ft|40Ft|Inter Port|W|E|W|E";
					 var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, false);
                    
                    var prefix="sheet2_";
                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,		true,	prefix+"conti_cd",	false,	"",		dfNone,		0,	false,	true);
                    InitDataProperty(0, cnt++ , dtData,		80,	daCenter,		true,	prefix+"conti_nm",	false,	"",		dfNone,		0,	false,	true);
                    InitDataProperty(0, cnt++ , dtData,		80,	daRight,		true,	prefix+"t20ft",		false,	"",		dfNumber,	0,	true,	true, 5);
                    InitDataProperty(0, cnt++ , dtData,		80,	daRight,		true,	prefix+"t40ft",		false,	"",		dfNumber,	0,	true,	true, 5);
                    InitDataProperty(0, cnt++ , dtData,		80,	daRight,		true,	prefix+"tport",		false,	"",		dfNumber,	0,	true,	true, 5);
//                    InitDataProperty(0, cnt++ , dtData,		90,	daRight,		false,	prefix+"tbox",		false,	"",		dfNumber,	0,	true,	true, 5);
//                    InitDataProperty(0, cnt++ , dtData,		90,	daRight,		false,	prefix+"tbl",		false,	"",		dfNumber,	0,	true,	true, 5);
                    InitDataProperty(0, cnt++ , dtData,		60,	daRight,		false,	prefix+"tbox_w",		false,	"",		dfNumber,	0,	true,	true, 5);
                    InitDataProperty(0, cnt++ , dtData,		60,	daRight,		false,	prefix+"tbox_e",		false,	"",		dfNumber,	0,	true,	true, 5);
                    InitDataProperty(0, cnt++ , dtData,		60,	daRight,		false,	prefix+"tbl_w",		false,	"",		dfNumber,	0,	true,	true, 5);
                    InitDataProperty(0, cnt++ , dtData,		60,	daRight,		false,	prefix+"tbl_e",		false,	"",		dfNumber,	0,	true,	true, 5);
                    
                    CountPosition = 0;
				   }
                 break;                 
         }
     }
     
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
				if ( sheetObj.id == "sheet1"){
					formObj.f_cmd.value = SEARCH;
					
					var arr = new Array("sheet1_", "sheet2_");
					var sXml = sheetObj.GetSearchXml("VOP_OPF_0207GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
					var arrXml = sXml.split("|$$|");
					for(var i = 0; i<arrXml.length; i++){ 
						sheetObjects[i].LoadSearchXml(arrXml[i]); 
					}
					break;				
				}
			case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("VOP_OPF_0207GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),-1,false,true);
				break;
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }

         return true;
     }

 	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			
			//if("TES_SELBB" == sUserId){
			if("9703393" == sUserId){
				sheetObj.CellEditable(3, "sheet2_tbl_w")   = true;
				sheetObj.CellEditable(3, "sheet2_tbl_e")   = true;
				sheetObj.CellEditable(4, "sheet2_tbl_w")   = true;
				sheetObj.CellEditable(4, "sheet2_tbl_e")   = true;
				sheetObj.CellEditable(5, "sheet2_t20ft") = true;
				sheetObj.CellEditable(5, "sheet2_t40ft") = true;
				sheetObj.CellEditable(5, "sheet2_tbox_w")  = true;
				sheetObj.CellEditable(5, "sheet2_tbox_e")  = true;
				sheetObj.CellEditable(5, "sheet2_tport") = true;
			}else{
				sheetObj.CellEditable(3, "sheet2_tbl_w")   = false;
				sheetObj.CellEditable(3, "sheet2_tbl_e")   = false;
				sheetObj.CellEditable(4, "sheet2_tbl_w")   = false;
				sheetObj.CellEditable(4, "sheet2_tbl_e")   = false;
				sheetObj.CellEditable(5, "sheet2_t20ft") = false;
				sheetObj.CellEditable(5, "sheet2_t40ft") = false;
				sheetObj.CellEditable(5, "sheet2_tbox_w")  = false;
				sheetObj.CellEditable(5, "sheet2_tbox_e")  = false;
				sheetObj.CellEditable(5, "sheet2_tport") = false;
			}
		}
 	}
 	
 	// sheet2 변경에 따라 sheet1 변경
 	function sheet2_OnChange(sheetObj, Row, Col, Value){
 		
 		if(Row == 3){ //Asia
 			if(Col == 3){ // 20Ft
 				sheetObjects[0].CellValue(1, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(2, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 4){ // 40Ft
 				sheetObjects[0].CellValue(3, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(4, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 5){ // Inter Port
 				sheetObjects[0].CellValue(7, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(8, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 6){ // Per Box - W
 				sheetObjects[0].CellValue(6, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 7){ // Per Box - E
 				sheetObjects[0].CellValue(5, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 8){ // Per B/L - W
 				sheetObjects[0].CellValue(10, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 9){ // Per B/L - E
 				sheetObjects[0].CellValue(9, "sheet1_dvs_fee_amt") = Value;
 			}
 		}else if(Row == 4){ //Europe
 			if(Col == 3){ // 20Ft
 				sheetObjects[0].CellValue(11, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(12, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 4){ // 40Ft
 				sheetObjects[0].CellValue(13, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(14, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 5){ // Inter Port
 				sheetObjects[0].CellValue(17, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(18, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 6){ // Per Box - W
 				sheetObjects[0].CellValue(16, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 7){ // Per Box - E
 				sheetObjects[0].CellValue(15, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 8){ // Per B/L - W
 				sheetObjects[0].CellValue(20, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 9){ // Per B/L - E
 				sheetObjects[0].CellValue(19, "sheet1_dvs_fee_amt") = Value;
 			}
 		}else if(Row == 5){ //USA
 			if(Col == 3){ // 20Ft
 				sheetObjects[0].CellValue(21, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(22, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 4){ // 40Ft
 				sheetObjects[0].CellValue(23, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(24, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 5){ // Inter Port
 				sheetObjects[0].CellValue(27, "sheet1_dvs_fee_amt") = Value;
 				sheetObjects[0].CellValue(28, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 6){ // Per Box - W
 				sheetObjects[0].CellValue(26, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 7){ // Per Box - E
 				sheetObjects[0].CellValue(25, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 8){ // Per B/L - W
 				sheetObjects[0].CellValue(30, "sheet1_dvs_fee_amt") = Value;
 			}else if(Col == 9){ // Per B/L - E
 				sheetObjects[0].CellValue(29, "sheet1_dvs_fee_amt") = Value;
 			}
 			
 		}
 	}

 	function sheet1_OnSaveEnd(ErrMsg){
 		window.close();
 	}
 	
	/* 개발자 작업  끝 */