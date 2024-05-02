/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FNS_JOO_0093.js
*@FileTitle : Add BSA Carriers POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.13
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.13 김영오
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @extends 
     * @class fns_joo_0093 : fns_joo_0093 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0093() {
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
// var comboObjects = new Array();
// var comboCnt = 0;
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var prefix = "sheet1_";
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

             case "btn_Close":
			 	 //selectCntrTp(sheetObject, formObject);
            	 self.close();
                 break;		 

			 case "btn_save": //저장
				doActionIBSheet(sheetObject, formObject, IBSAVE);			
//				selectCntrTp(sheetObject, formObject);
				break;
				
				}
     	}catch(e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
/* 2012.06.04		 
		 for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		 }
*/
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
                    style.height = 42;
					//style.height = 180;
                    
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

					var HeadTitle = "|Sel|||Carrier1|Carrier2|Carrier3|Carrier4|Carrier5|Carrier6|Carrier7|Carrier8|Carrier9|Carrier10|||||||||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다.
					InitHeadMode(true, false, true, false, false, false);
					//InitHeadMode(true, true, true, false, true, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++,  dtHidden, 	30, 	daCenter, 	false, 	"del_chk");
					InitDataProperty(0, cnt++ , dtData,	   180,  	daCenter,	true,  "vvd_port", 		false,    "",      	dfNone, 	0,  false,  false);
					
					InitDataProperty(0, cnt++ , dtData,	   110,  	daCenter,	false,  "text01", 	false,    "",      	dfNone, 	0,  false,  false);
					
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,  "jo_add_crr_cd1",  		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,  "jo_add_crr_cd2",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,  "jo_add_crr_cd3",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,  	daCenter,	false,  "jo_add_crr_cd4",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,  	daCenter,	false,  "jo_add_crr_cd5", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					InitDataProperty(0, cnt++ , dtData,		60,  	daCenter,	false,  "jo_add_crr_cd6", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,   	daCenter,	false,  "jo_add_crr_cd7", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,   	daCenter,	false,  "jo_add_crr_cd8", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,  	daCenter,	false,  "jo_add_crr_cd9", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,  	daCenter,	false,  "jo_add_crr_cd10", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtData,		60,  	daCenter,	false,  "total", 			false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  "old_jo_add_crr_cd1",  		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  "old_jo_add_crr_cd2",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  "old_jo_add_crr_cd3",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "old_jo_add_crr_cd4",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "old_jo_add_crr_cd5", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "old_jo_add_crr_cd6", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,   	daCenter,	false,  "old_jo_add_crr_cd7", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,   	daCenter,	false,  "old_jo_add_crr_cd8", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "old_jo_add_crr_cd9", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "old_jo_add_crr_cd10", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					
					InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  "vvd_port1",  		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  "vvd_port2",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,		daCenter,	false,  "vvd_port3",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "vvd_port4",     	false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "vvd_port5", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "vvd_port6", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,   	daCenter,	false,  "vvd_port7", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,   	daCenter,	false,  "vvd_port8", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "vvd_port9", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					InitDataProperty(0, cnt++ , dtHidden,	65,  	daCenter,	false,  "vvd_port10", 		false,    "",      	dfNone, 0,  false,  true, 3, true);
					
					
					InitDataValid(0, "jo_add_crr_cd1",  vtEngUpOnly); //영문대문자   
					InitDataValid(0, "jo_add_crr_cd2",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd3",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd4",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd5",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd6",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd7",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd8",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd9",  vtEngUpOnly); //영문대문자
					InitDataValid(0, "jo_add_crr_cd10", vtEngUpOnly); //영문대문자
										
            		//RowHidden(0) = true;
					// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    CountPosition = 0;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

              		}
                break;
				
				case 2:      //sheet2 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 23;
                    
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

					var HeadTitle = "|Rep.\nCarrier|Carrier|||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtData,	   		180,  	daCenter,	true,  "vvd_port", 		false,    "",      	dfNone, 	0,  false,  false);
					
					InitDataProperty(0, cnt++ , dtData,	   		110,  	daCenter,	false,  "text01", 	false,    "",      	dfNone, 	0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa1",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa2",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa3",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa4",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa5",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa6",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa7",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa8",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa9",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,  "bsa10",  			false,         "",      								dfNone, 0,  false,  true, 9, true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,  "total",  			false,         "",      								dfInteger,  0,  false,  false, 999, false);
					
					InitDataValid(0, "bsa1",  vtNumericOther, '-');    			// 숫자만   //2013.01.24 LSJ (-)값이 들어가도록 수정 by 오미랑 과장 요청
					InitDataValid(0, "bsa2",  vtNumericOther, '-');   			// 숫자만
					InitDataValid(0, "bsa3",  vtNumericOther, '-');   	   	    // 숫자만
					InitDataValid(0, "bsa4",  vtNumericOther, '-');   	        // 숫자만
					InitDataValid(0, "bsa5",  vtNumericOther, '-');   			// 숫자만
					InitDataValid(0, "bsa6",  vtNumericOther, '-');    			// 숫자만
					InitDataValid(0, "bsa7",  vtNumericOther, '-');      		// 숫자만
					InitDataValid(0, "bsa8",  vtNumericOther, '-');   			// 숫자만
					InitDataValid(0, "bsa9",  vtNumericOther, '-');   			// 숫자만
					InitDataValid(0, "bsa10", vtNumericOther, '-');   			// 숫자만
												
            		RowHidden(0) = true;
					// Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    CountPosition = 0;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;
			   }
                break;
				
				case 3:      //sheet3 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 200;
                    
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

					var HeadTitle = "|Rep.\nCarrier|Carrier||||";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtData,			65,  	daCenter,	false,  "vvd_port", 		false,         "",      								dfNone, 	2,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "jo_add_crr_cd",  			false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "old_jo_add_crr_cd",  		false,         "",      								dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "bsa",  				false,         "",      								dfNone,   	9,     false,       true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,  "udp_flg",  			false,         "",      								dfNone,   	9,     false,       true);
					
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
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
	        		formObj.f_cmd.value = SEARCH;
					formObj.save_chk.value = "";
					formObj.add_chk.value = "";
					var xmlArr = sheetObj.GetSearchXml("FNS_JOO_0093GS.do", FormQueryString(formObj));
					sheetObjects[0].LoadSearchXml(xmlArr);
					sheetObjects[1].LoadSearchXml(xmlArr);					
	  	   	  	}	
                break;
				
           	case IBSAVE:       //저장
				sheetObjects[2].RemoveAll();
				var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
				if (SaveStr == ""){
					ComShowCodeMessage("JOO00036");
					return false;
				}
				if (!ComShowCodeConfirm("JOO00046")){
					return false;
				}
				
				//저장 시 Sheet1, Sheet2 데이터 Sheet3으로 셋팅 (가로 데이터 세로 데이터로 피벗)			
				//사용자가 입력한 값들	
				var joAddCrrCd1 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd1")," ");
				var joAddCrrCd2 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd2")," ");
				var joAddCrrCd3 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd3")," ");
				var joAddCrrCd4 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd4")," ");
				var joAddCrrCd5 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd5")," ");
				var joAddCrrCd6 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd6")," ");
				var joAddCrrCd7 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd7")," ");
				var joAddCrrCd8 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd8")," ");
				var joAddCrrCd9 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd9")," ");
				var joAddCrrCd10 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd10")," ");
				
				//조회 시 가져오는 Carrier 값들
				var oldJoAddCrrCd1 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd1")," ");
				var oldJoAddCrrCd2 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd2")," ");
				var oldJoAddCrrCd3 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd3")," ");
				var oldJoAddCrrCd4 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd4")," ");
				var oldJoAddCrrCd5 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd5")," ");
				var oldJoAddCrrCd6 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd6")," ");
				var oldJoAddCrrCd7 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd7")," ");
				var oldJoAddCrrCd8 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd8")," ");
				var oldJoAddCrrCd9 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd9")," ");
				var oldJoAddCrrCd10 =ComTrimAll(sheetObj.CellValue(1, "old_jo_add_crr_cd10")," ");
				
				//데이터 수정 시 사용할 업데이트 키값중 하나
				var vvdPort1 =ComTrimAll(sheetObj.CellValue(1, "vvd_port1")," ");
				var vvdPort2 =ComTrimAll(sheetObj.CellValue(1, "vvd_port2")," ");
				var vvdPort3 =ComTrimAll(sheetObj.CellValue(1, "vvd_port3")," ");
				var vvdPort4 =ComTrimAll(sheetObj.CellValue(1, "vvd_port4")," ");
				var vvdPort5 =ComTrimAll(sheetObj.CellValue(1, "vvd_port5")," ");
				var vvdPort6 =ComTrimAll(sheetObj.CellValue(1, "vvd_port6")," ");
				var vvdPort7 =ComTrimAll(sheetObj.CellValue(1, "vvd_port7")," ");
				var vvdPort8 =ComTrimAll(sheetObj.CellValue(1, "vvd_port8")," ");
				var vvdPort9 =ComTrimAll(sheetObj.CellValue(1, "vvd_port9")," ");
				var vvdPort10 =ComTrimAll(sheetObj.CellValue(1, "vvd_port10")," ");
				
				var bsa1 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa1")," ");
				var bsa2 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa2")," ");
				var bsa3 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa3")," ");
				var bsa4 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa4")," ");
				var bsa5 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa5")," ");
				var bsa6 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa6")," ");
				var bsa7 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa7")," ");
				var bsa8 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa8")," ");
				var bsa9 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa9")," ");
				var bsa10 =ComTrimAll(sheetObjects[1].CellValue(1, "bsa10")," ");
				
				var vvdPort  =ComTrimAll(sheetObjects[1].CellValue(1, "vvd_port")," ");
				
				/* 2013.01.29 이수진 Carrier는 존재하지 않고 BSA에만 존재하는 경우 저장되지 않도록 메세지 처리
				 * (오미랑 과장님 요청사항) 
				 */
							
				if ( ( bsa1 == "" && joAddCrrCd1 != "") || ( bsa1 != "" && joAddCrrCd1 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
					
				}
				
				if ( ( bsa2 == "" && joAddCrrCd2 != "") || ( bsa2 != "" && joAddCrrCd2 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa3 == "" && joAddCrrCd3 != "") || ( bsa3 != "" && joAddCrrCd3 == "") ){
					ComShowCodeMessage("JOO00207");
					return ;
				}
				
				if ( ( bsa4 == "" && joAddCrrCd4 != "") || ( bsa4 != "" && joAddCrrCd4 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa5 == "" && joAddCrrCd5 != "") || ( bsa5 != "" && joAddCrrCd5 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa6 == "" && joAddCrrCd6 != "") || ( bsa6 != "" && joAddCrrCd6 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa7 == "" && joAddCrrCd7 != "") || ( bsa7 != "" && joAddCrrCd7 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa8 == "" && joAddCrrCd8 != "") || ( bsa8 != "" && joAddCrrCd8 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa9 == "" && joAddCrrCd9 != "") || ( bsa9 != "" && joAddCrrCd9 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				if ( ( bsa10 == "" && joAddCrrCd10 != "") || ( bsa10 != "" && joAddCrrCd10 == "") ){
					ComShowCodeMessage("JOO00207");
					return;
				}
				
				
				if(joAddCrrCd1 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd1;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa1;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd2 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd2;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa2;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd3 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd3;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa3;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd4 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd4;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa4;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd5 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd5;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa5;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd6 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd6;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa6;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd7 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd7;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa7;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd8 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd8;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa8;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd9 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd9;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa9;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				if(joAddCrrCd10 != "")
				{
					var addRow = sheetObjects[2].DataInsert();
					sheetObjects[2].cellValue(addRow,"jo_add_crr_cd") = joAddCrrCd10;
					sheetObjects[2].cellValue(addRow,"bsa") = bsa10;
					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
					sheetObjects[2].cellValue(addRow,"udp_flg") = "I";
				}
				
				
//				if(oldjoAddCrrCd1 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd1;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;	
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd2 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd2;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd3 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd3;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd4 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd4;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd5 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd5;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd6 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd6;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd7 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd7;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd8 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd8;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd9 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd9;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
//				if(oldjoAddCrrCd10 != "")
//				{
//					var addRow = sheetObjects[2].DataInsert();
//					sheetObjects[2].cellValue(addRow,"old_jo_add_crr_cd") = oldjoAddCrrCd10;
//					sheetObjects[2].cellValue(addRow,"vvd_port") = vvdPort;
//					sheetObjects[2].cellValue(addRow,"udp_flg") = "U";
//				}
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				
				var sParam = ComGetSaveString(sheetObjects[2]);
     			if (sParam == "") {
                	ComOpenWait(false);
					return;
				}
     			
     			sheetObjects[2].LoadSaveXml(sheetObjects[2].GetSaveXml("FNS_JOO_0093GS.do", "f_cmd=" + MULTI +"&" + FormQueryString(formObj) +"&" + sheetObjects[2].GetSaveString()));                 
                
                                
                ///////////////////////
                var opener = window.dialogArguments;    // MODAL창에서 부모창 javascript호출
        	    var opnr_sheet1 = opener.document.form.sheet1;
        		opnr_sheet1.CellValue(opnr_sheet1.SelectRow, prefix+"jo_bsa_add_teu_qty")  =  sheetObjects[1].cellValue(1,"total");
        		window.close();
        		        		        		
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				ComOpenWait(false);
                break;
                
   
                

        }
    }
  	
  	
     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
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
	 * 조회 후 처리
	 * @param {Object} sheetObj
	 * @param {Object} ErrMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			var formObj = document.form;
			if (RowCount > 0) {
				sheetObj.cellValue(1,"text01") = "ADD BSA Carrier";
				sheetObj.cellValue(1,"vvd_port") = "VVD+Port+Seq+Crr.";
				
				formObj.save_chk.value = "Y";
			
			} else {//RowCount에따른 처리 데이터가 0건인 경우
				var addRow = sheetObj.DataInsert();
				sheetObj.cellValue(addRow,"text01") = "ADD BSA Carrier";
				sheetObj.cellValue(addRow,"vvd_port") = "VVD+Port+Seq+Crr.";
			}
				sheetObj.CellEditable(1, "jo_add_crr_cd1") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd2") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd3") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd4") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd5") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd6") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd7") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd8") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd9") = true;
				sheetObj.CellEditable(1, "jo_add_crr_cd10") = true;
				
				RangeFontBold(TopRow, SaveNameCol("vvd_port"), LastRow, SaveNameCol("text01")) = true;
                RangeFontColor(TopRow, SaveNameCol("vvd_port"), LastRow, SaveNameCol("text01")) = RgbColor(39,95,101);
                RangeBackColor(TopRow, SaveNameCol("vvd_port"), LastRow, SaveNameCol("text01")) = RgbColor(193,196,232);
								
				RangeFontBold(TopRow, SaveNameCol("total"), LastRow, SaveNameCol("total")) = true;
                RangeFontColor(TopRow, SaveNameCol("total"), LastRow, SaveNameCol("total")) = RgbColor(39,95,101);
                RangeBackColor(TopRow, SaveNameCol("total"), LastRow, SaveNameCol("total")) = RgbColor(193,196,232);
				
				sheetObj.cellValue(1,"total") = "Total";
		}
	}
	
	/**
	 * 조회 후 처리
	 * @param {Object} sheetObj
	 * @param {Object} ErrMsg
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj)
		{
			var formObj = document.form;
			var bsa1 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa1")));
			var bsa2 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa2")));
			var bsa3 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa3")));
			var bsa4 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa4")));
			var bsa5 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa5")));
			var bsa6 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa6")));
			var bsa7 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa7")));
			var bsa8 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa8")));
			var bsa9 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa9")));
			var bsa10 = parseInt(ComNullToZero(sheetObj.CellValue(1, "bsa10")));
			if (RowCount > 0) {
				sheetObj.cellValue(1,"text01") = "ADD BSA";
				sheetObj.cellValue(1,"total") = bsa1+bsa2+bsa3+bsa4+bsa5+bsa6+bsa7+bsa8+bsa9+bsa10;
			} else {//RowCount에따른 처리 데이터가 0건인 경우
				var addRow = sheetObj.DataInsert();
				sheetObj.cellValue(addRow,"vvd_port") = document.form.vvd_port.value;
			}
			
			sheetObj.CellEditable(1, "bsa1") = true;
			sheetObj.CellEditable(1, "bsa2") = true;
			sheetObj.CellEditable(1, "bsa3") = true;
			sheetObj.CellEditable(1, "bsa4") = true;
			sheetObj.CellEditable(1, "bsa5") = true;
			sheetObj.CellEditable(1, "bsa6") = true;
			sheetObj.CellEditable(1, "bsa7") = true;
			sheetObj.CellEditable(1, "bsa8") = true;
			sheetObj.CellEditable(1, "bsa9") = true;
			sheetObj.CellEditable(1, "bsa10") = true;

			RangeFontBold(TopRow, SaveNameCol("text01"), LastRow, SaveNameCol("text01")) = true;
            RangeFontColor(TopRow, SaveNameCol("text01"), LastRow, SaveNameCol("text01")) = RgbColor(39,95,101);
            RangeBackColor(TopRow, SaveNameCol("text01"), LastRow, SaveNameCol("text01")) = RgbColor(193,196,232);
			
			sheetObj.cellValue(1,"text01") = "ADD BSA";
		}
	}
	
	
	/**
	 * Carrier 실시간 조회 체크
	 * @param {Object} sheetObj
	 * @param {Object} Row
	 * @param {Object} Col
	 * @param {Object} Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var sName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		var joAddCrrCd1 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd1")," ");
		var joAddCrrCd2 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd2")," ");
		var joAddCrrCd3 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd3")," ");
		var joAddCrrCd4 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd4")," ");
		var joAddCrrCd5 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd5")," ");
		var joAddCrrCd6 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd6")," ");
		var joAddCrrCd7 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd7")," ");
		var joAddCrrCd8 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd8")," ");
		var joAddCrrCd9 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd9")," ");
		var joAddCrrCd10 =ComTrimAll(sheetObj.CellValue(1, "jo_add_crr_cd10")," ");
		
		
		if (sName == "jo_add_crr_cd1"){	
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd1", "", joAddCrrCd1, joAddCrrCd1) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd2"){			
			if (joAddCrrCd2 != '' && (joAddCrrCd2 == joAddCrrCd1 || joAddCrrCd2 == joAddCrrCd3 || joAddCrrCd2 == joAddCrrCd4 || joAddCrrCd2 == joAddCrrCd5 || joAddCrrCd2 == joAddCrrCd6
				 || joAddCrrCd2 == joAddCrrCd7 || joAddCrrCd2 == joAddCrrCd8 || joAddCrrCd2 == joAddCrrCd9 || joAddCrrCd2 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd2");
				return;
			}		
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd2", "", joAddCrrCd2, joAddCrrCd2) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd3"){	
			if (joAddCrrCd3 != '' && (joAddCrrCd3 == joAddCrrCd1 || joAddCrrCd3 == joAddCrrCd2 || joAddCrrCd3 == joAddCrrCd4 || joAddCrrCd3 == joAddCrrCd5 || joAddCrrCd3 == joAddCrrCd6
				 || joAddCrrCd3 == joAddCrrCd7 || joAddCrrCd3 == joAddCrrCd8 || joAddCrrCd3 == joAddCrrCd9 || joAddCrrCd3 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd3");
				return;
			}		
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd3", "", joAddCrrCd3, joAddCrrCd3) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd4"){		
			if (joAddCrrCd4 != '' && (joAddCrrCd4 == joAddCrrCd1 || joAddCrrCd4 == joAddCrrCd2 || joAddCrrCd4 == joAddCrrCd3 || joAddCrrCd4 == joAddCrrCd5 || joAddCrrCd4 == joAddCrrCd6
				 || joAddCrrCd4 == joAddCrrCd7 || joAddCrrCd4 == joAddCrrCd8 || joAddCrrCd4 == joAddCrrCd9 || joAddCrrCd4 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd4");
				return;
			}	
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd4", "", joAddCrrCd4, joAddCrrCd4) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd5"){		
			if (joAddCrrCd5 != '' && (joAddCrrCd5 == joAddCrrCd1 || joAddCrrCd5 == joAddCrrCd2 || joAddCrrCd5 == joAddCrrCd3 || joAddCrrCd5 == joAddCrrCd4 || joAddCrrCd5 == joAddCrrCd6
				 || joAddCrrCd5 == joAddCrrCd7 || joAddCrrCd5 == joAddCrrCd8 || joAddCrrCd5 == joAddCrrCd9 || joAddCrrCd5 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd5");
				return;
			}	
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd5", "", joAddCrrCd5, joAddCrrCd5) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd6"){		
			if (joAddCrrCd6 != '' && (joAddCrrCd6 == joAddCrrCd1 || joAddCrrCd6 == joAddCrrCd2 || joAddCrrCd6 == joAddCrrCd3 || joAddCrrCd6 == joAddCrrCd4 || joAddCrrCd6 == joAddCrrCd5
				 || joAddCrrCd6 == joAddCrrCd7 || joAddCrrCd6 == joAddCrrCd8 || joAddCrrCd6 == joAddCrrCd9 || joAddCrrCd6 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd6");
				return;
			}	
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd6", "", joAddCrrCd6, joAddCrrCd6) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd7"){			
			if (joAddCrrCd7 != '' && (joAddCrrCd7 == joAddCrrCd1 || joAddCrrCd7 == joAddCrrCd2 || joAddCrrCd7 == joAddCrrCd3 || joAddCrrCd7 == joAddCrrCd4 || joAddCrrCd7 == joAddCrrCd5
				 || joAddCrrCd7 == joAddCrrCd6 || joAddCrrCd7 == joAddCrrCd8 || joAddCrrCd7 == joAddCrrCd9 || joAddCrrCd7 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd7");
				return;
			}
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd7", "", joAddCrrCd7, joAddCrrCd7) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd8"){		
			if (joAddCrrCd8 != '' && (joAddCrrCd8 == joAddCrrCd1 || joAddCrrCd8 == joAddCrrCd2 || joAddCrrCd8 == joAddCrrCd3 || joAddCrrCd8 == joAddCrrCd4 || joAddCrrCd8 == joAddCrrCd5
				 || joAddCrrCd8 == joAddCrrCd6 || joAddCrrCd8 == joAddCrrCd7 || joAddCrrCd8 == joAddCrrCd9 || joAddCrrCd8 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd8");
				return;
			}	
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd8", "", joAddCrrCd8, joAddCrrCd8) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd9"){		
			if (joAddCrrCd9 != '' && (joAddCrrCd9 == joAddCrrCd1 || joAddCrrCd9 == joAddCrrCd2 || joAddCrrCd9 == joAddCrrCd3 || joAddCrrCd9 == joAddCrrCd4 || joAddCrrCd9 == joAddCrrCd5
				 || joAddCrrCd9 == joAddCrrCd6 || joAddCrrCd9 == joAddCrrCd7 || joAddCrrCd9 == joAddCrrCd8 || joAddCrrCd9 == joAddCrrCd10)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd9");
				return;
			}	
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd9", "", joAddCrrCd9, joAddCrrCd9) ) {
				return;
			}
		}
		if (sName == "jo_add_crr_cd10"){	
			if (joAddCrrCd10 != '' && (joAddCrrCd10 == joAddCrrCd1 || joAddCrrCd10 == joAddCrrCd2 || joAddCrrCd10 == joAddCrrCd3 || joAddCrrCd10 == joAddCrrCd4 || joAddCrrCd10 == joAddCrrCd5
				 || joAddCrrCd10 == joAddCrrCd6 || joAddCrrCd10 == joAddCrrCd7 || joAddCrrCd10 == joAddCrrCd8 || joAddCrrCd10 == joAddCrrCd9)) {
				ComShowCodeMessage("JOO00191");
				sheetObj.SelectCell(Row, "jo_add_crr_cd10");
				return;
			}		
			if( !validationCarrier(sheetObj, formObj, 1, "joAddCrrCd10", "", joAddCrrCd10, joAddCrrCd10) ) {
				return;
			}
		}
	}
	
	
	/**
	 * Total 처리 실시간
	 * @param {Object} sheetObj
	 * @param {Object} Row
	 * @param {Object} Col
	 * @param {Object} Value
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var bsa1 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa1")));
		var bsa2 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa2")));
		var bsa3 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa3")));
		var bsa4 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa4")));
		var bsa5 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa5")));
		var bsa6 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa6")));
		var bsa7 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa7")));
		var bsa8 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa8")));
		var bsa9 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa9")));
		var bsa10 = parseInt(ComNullToZero(sheetObj.CellValue(Row, "bsa10")));
		
		sheetObj.cellValue(Row,"total") = bsa1+bsa2+bsa3+bsa4+bsa5+bsa6+bsa7+bsa8+bsa9+bsa10;
	}
	
	function validationCarrier(sheetObj, formObj, Row, Col, flgCol, newValue, oldValue) {
		if( newValue.length == 3 ) {
			formObj.f_cmd.value = SEARCHLIST12;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code="+newValue);
			var outValue = ComGetEtcData(sXml,"CHECK");
			if( outValue == "E" ) {
				if(!ComShowCodeConfirm("JOO00193")) {
					sheetObj.CellValue2(Row, Col) = "";
					sheetObj.SelectCell(Row, Col);
					return false;
				}
			}
		} else {
			if( newValue != "" ) {
				ComShowCodeMessage("JOO00194");
				sheetObj.SelectCell(Row, Col);
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 사용자가 선택한 값을 부모 창의 그리드로 값 셋팅
	 * @param {Object} sheetObject
	 * @param {Object} formObject
	 */
//	function selectCntrTp(sheetObject, formObject) {
//		var opener = window.dialogArguments;    // MODAL창에서 부모창 javascript호출
//	    var opnr_sheet1 = opener.document.form.sheet1;
//		opnr_sheet1.CellValue(opnr_sheet1.SelectRow, prefix+"jo_bsa_add_teu_qty")  =  sheetObjects[1].cellValue(1,"total");
//		window.close();
//	}
	/* 개발자 작업  끝 */