/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1156.js
*@FileTitle : Multi Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.04 조정민
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
     * @class esm_bkg_1156 : esm_bkg_0976 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1156() {
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
					case "btn_Retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					case "btn_RowAdd":
    						doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
					case "btn_Delete":
						if(!validateForm(sheetObject,formObject,"btn_Delete")) {
							return false;
						}
						doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;
					case "btn_Select":
						if(!validateForm(sheetObject,formObject,"btn_Select")) {
							return false;
						}
    					comPopupOK();
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
    	initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

 	function initControl() {
		var formObject = document.form;
		axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); // -
		// 키보드
		// 입력할때
		axon_event.addListenerForm('beforedeactivate', 'bkg_deactivate', formObject); // -
		// 포커스
		// 나갈때
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); // -
		// 포커스
		// 들어갈때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}

 	function bkg_keypress() {
		switch (event.srcElement.dataformat) {
			case "ymd":
				// number
				ComKeyOnlyNumber(event.srcElement, "-");
				break;
			case "engup":
				// 영문대문자
				ComKeyOnlyAlphabet('upper');
				break;
			case "engupnum":
				// 숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "num":
				// 숫자 입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			default:
		}
	}
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 170;
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

					var HeadTitle1 = "|Sel.|Office";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    			//var prefix="sheet1_";
					//InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"hdnStatus");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,		"checkbox",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"bkg_ofc",		false,		"",		dfEngUpKey,			5,		true,		true,  5);

			}
			break;
        }
    }

 	
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //조회

            	formObj.f_cmd.value = SEARCH;
         		sheetObj.WaitImageVisible = true;
      			var sXml = sheetObj.GetSaveXml("ESM_BKG_1156GS.do", FormQueryString(formObj));  
      			sheetObj.WaitImageVisible = false;
    			var arrXml = sXml.split("|$$|");
    	       	if(arrXml.length > 0) {
    	       		sheetObj.LoadSearchXml(arrXml[0]); 
    	       	}
                break;

          case IBDELETE:      // 삭제
			for(i=0;i<sheetObj.RowCount+1;i++){
				if(sheetObj.RowStatus(i) == 'U'){
					sheetObj.RowStatus(i) = "D";
					sheetObj.RowHidden(i) = true;
				}
			}
	            break;

          case IBINSERT:      // 입력
       	         sheetObj.DataInsert(-1);
       	         break;

        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		switch(sAction) {

		case "btn_Delete":
			if (sheetObj.CheckedRows("checkbox") == 0) {
				ComShowMessage(msgs['COM12189']);
				return false;
			} 
			break;


		case "btn_Select":
			var rowNum = 0;
			for(var i = 1 ; i < sheetObj.Rows ; i++ ){
				if(sheetObj.RowStatus(i) != "D" && sheetObj.CellValue(i, "checkbox") == 1)
					rowNum++;
			}
			if(rowNum < 1){

				ComShowMessage(msgs['COM12189']);
				return false;
		
			}
			break;

		}
        }

        return true;
    }
     
     function doSelectSheet(sheetObject, col) {
     	var sRow = sheetObject.FindCheckedRow(col);
     	var checkRow = sRow.split("|");
     	if (checkRow.length-1 == 1) {
//     		alert(checkRow[0]);
//     		window.close();
     	}
     }

	/* 개발자 작업  끝 */