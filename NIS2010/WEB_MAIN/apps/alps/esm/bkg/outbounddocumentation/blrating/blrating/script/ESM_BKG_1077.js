/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1077.jsp
*@FileTitle : Rating Application Date Search
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.23 김태경
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
 * @class esm_bkg_1076 : esm_bkg_1076 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1077() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn1_Apply":
                	
                	if(ComGetObjValue(form.apply_dt) == ''){
                		ComShowCodeMessage("BKG00442");
                	}else{
                		var rApply_dt = ComGetObjValue(form.apply_dt);
                		// BDR 이전이거나 C/A 일 경우만 Date 를 셋팅 할수 있도록 한다 
                		if((formObject.bdrflag.value =="N")|(formObject.bdrflag.value =="Y" && formObject.caflag.value == "Y")){
                			window.returnValue = rApply_dt ;//retVal 변수값 설정.
                		}
                	}
                	self.close();
					break;

                case "btn1_Close":
                	self.close();
                    break; 

                case "btn1_New":
					alert(srcName);
                    break;

                case "btn1_Close":
					alert(srcName);
                    break; 

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			alert(e);
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
        options.innerHTML = "Application Date - CRD : From or to US, CA, MX via US bookings";
//        options1.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From Asia to UY, AR, BR bookings";
        options2.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ETD of 1st VVD : The other bookings";
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
    	var sheetID = sheetObj.id;
    	switch (sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
					style.height = 42;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Booking No.|1st VVD|POL|ETB|ETD";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	              			  InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
                    
					InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	true,		"bkg_no",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"first_vvd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"pol_cd",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	110,		daCenter,	true,		"etb",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	110,		daCenter,	true,		"etd",	false,	"",	dfNone,		0,	false,	false);
					
					CountPosition = 0;
               }
                break;
                
                
                case "sheet2":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
					style.height = 162;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
//					MergeSheet = msHeaderOnly;
					MergeSheet = msPrevColumnMerge ;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Container No|1st OC CY|1st OC Date(CRD)";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
       			  	InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
                    
					InitDataProperty(0, cnt++ , dtData,	150,		daCenter,	true,		"cntr_no",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	130,		daCenter,	true,		"oc_cy",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	100,		daCenter,	true,		"oc_date",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"bkg_no",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"first_vvd",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"pol_cd",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"etb",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"etd",	false,  "",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,	100,		daCenter,	false,		"apply_dt",	false,  "",	dfNone,		0,	false,	false);
					
					
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
			
				ComSetObjValue(formObj.f_cmd, SEARCH);
				// 2.조회조건으로 조회실행
//				var sXml = sheetObj.GetSearchXml("ESM_BKG_1077GS.do", FormQueryString(formObj));
				sheetObj.DoSearch("ESM_BKG_1077GS.do",FormQueryString(formObj));
				pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
				
			break;

			case IBSAVE:        //저장
          		if(validateForm(sheetObj,formObj,sAction))
			break;

			case IBINSERT:      // 입력

			break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }
    /**
     * sheet2에 조회 후 sheet1에 값을 넣는다
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
      	  with(sheetObj)
      	    var formObj = document.form;
      	  
      	  	var cnt_row = sheetObj.TotalRows;
      	  	
      	  	
      	  	
      	  	var sheetObj1 = sheetObjects[0];
      	  	var sheetObj2 = sheetObjects[1];
      	  	var newRow = sheetObj1.DataInsert(-1); // IBSheet 에 추가시 맨아랫줄로 추가
      	  	if(cnt_row > 0){
      	  		sheetObj1.CellValue(newRow,"bkg_no") = sheetObj2.CellValue(1,"bkg_no");
      	  		sheetObj1.CellValue(newRow,"first_vvd") = sheetObj2.CellValue(1,"first_vvd");
      	  		sheetObj1.CellValue(newRow,"pol_cd") = sheetObj2.CellValue(1,"pol_cd");
      	  		sheetObj1.CellValue(newRow,"etb") = sheetObj2.CellValue(1,"etb");
      	  		sheetObj1.CellValue(newRow,"etd") = sheetObj2.CellValue(1,"etd");
      	  		ComSetObjValue(formObj.apply_dt,sheetObj2.CellValue(1,"apply_dt"));
      	  	}
      	  	if(sheetObj2.CellValue(newRow,"cntr_no") ==''){
      	  	
      	  		sheetObj2.CellValue(newRow,"cntr_no") = 'There is no data search';
      	  		sheetObj2.CellValue(newRow,"oc_cy") = 'There is no data search';
      	  		sheetObj2.CellValue(newRow,"oc_date") = 'There is no data search';
//      	  	mySheet.SetMergeCell(Row, Col, Rows, Cols);  
      	  		sheetObj2.SetMergeCell(1,1,1,3);
      	  
      	  		
      	  		
      	  	}
        }        
	
	
/* 개발자 작업  끝 */