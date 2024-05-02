/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0362.js
*@FileTitle : VIN no input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 조정민
*@LastVersion : 1.0

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
     * @class esm_bkg_0362 : esm_bkg_0362 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0362() {
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
	var opener = (!opener) ? window.dialogArguments : opener;
	
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

				case "btn_add":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
				
				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					
				break;														
								
				case "btn_close":
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
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
        }
		
		
		// do init action
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		
		if(document.form.ui_id.value=="ESM_BKG_0229"){
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_save");
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
				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 250;
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
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "|Sel.|bkg no|VIN No.";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN, COLMERGE,  SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,     "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,     40,     daCenter,  false,    "sel");
                    InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,  false,    "bkg_no",         false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,  false,    "vin_no",         false,    "",         dfNone,     0,          true,        true);

                    
               }
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;


        switch(sAction) {
			case IBSEARCH:      //조회
				if (formObj.vin_no_list.value != undefined && formObj.vin_no_list.value != '') {
						var sRowArr = formObj.vin_no_list.value.split(",");
						for (var i = 0; i < sRowArr.length; i ++) {
							if(sRowArr[i] != "") {
								var newRow = sheetObj.DataInsert(-1);
								sheetObj.CellValue(newRow, "bkg_no") = formObj.bkg_no.value;
								sheetObj.CellValue(newRow, "vin_no") = sRowArr[i];
								
							}
							
						}
					}
			break;
			
			case IBSAVE:        //저장

				if(!validateForm(sheetObjects[0],formObj,sAction)) return false;
				sheetObj.ColumnSort("vin_no", "ASC")

				var vinList = "";
				for (var i = sheetObj.HeaderRows  ; i < sheetObj.RowCount +1 ; i++){
					if(ComTrim(sheetObj.CellValue(i, "vin_no"))!=""){
						if(i ==sheetObj.HeaderRows){
							vinList = sheetObj.CellValue(i, "vin_no");
						}else{
							vinList = vinList + "," + sheetObj.CellValue(i, "vin_no");
						}
						
					}
				}
				if(formObj.ui_id.value=="ESM_BKG_0361"){
					opener.document.form.exp_vin_ctnt.value = vinList;
					if(ComTrim(vinList)==""){
						opener.document.form.vin_exist_flg.checked = false;
					}else{
						opener.document.form.vin_exist_flg.checked = true;
					}
					
				}

				window.close();

			break;

			case IBINSERT:      // 입력
				var newRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue(newRow, "bkg_no") = formObj.bkg_no.value;

			break;
			
			case IBDELETE:      // 삭제
				//alert (" Delete .. ");
				//opener.ComRowDelete(sheetObj, 'sel', 1);
				var arrRow = opener.ComFindText(sheetObj, 'sel', 1);
				for (ir = 0; ir < arrRow.length; ir++) {
					if(arrRow[arrRow.length-1-ir]=='') continue;
					sheetObj.RowDelete(arrRow[arrRow.length-1-ir], false);
				}
	
			break;

        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        switch(sAction) {
			case IBSAVE:        //저장
				with(formObj){
					if(sheetObj.ColValueDup("vin_no") != -1){
						ComShowMessage(ComGetMsg("BKG00764", "VIN No"));
						return false;
					}

				}
			break;
		}

        return true;
    }
    
    
    

	/* 개발자 작업  끝 */