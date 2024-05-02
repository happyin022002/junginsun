/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1509.js
*@FileTitle : Customer Code Setup for B/L Image
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2013.10.07 신규정
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
     * @class ESM_BKG_1509 : ESM_BKG_1509 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1509() {
    	this.processButtonClick		= processButtonClick;
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
	//var comboObjects = new Array();
	//var comboCnt = 0;
	
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

				case "btn_retrieve":
					if(sheetObject1.IsDataModified == true && confirm(ComGetMsg("BKG00254"))){
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				
				case "btn_rowadd":
					if(ComIsBtnEnable("btn_rowadd")){
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
					}
				break;																	
	
				case "btn_rowdel":
					if(ComIsBtnEnable("btn_rowdel")){
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					}

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
		
		// IBSheet 초기화
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initControl();
	}
	
    /**
    * Form 이벤트 등록
    */
    function initControl() {
       axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
       axon_event.addListenerForm ('keydown', 'obj_keydown', document.form);       
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
                    InitRowInfo(1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

					var HeadTitle1 = "|Sel.|Customer Code|BL Type|Rated|User ID|Date ";		
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //InitHeadRow(1, HeadTitle2, true);
                                        
                    //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,		dtHiddenStatus,			20,			daCenter,		true,     "ibflag");
                    InitDataProperty(0, cnt++,		dtCheckBox,				30,			daCenter,		true,     "chk");
                    InitDataProperty(0, cnt++,		dtPopupEdit,			150,		daCenter,		true,     "cust_code",				false,		"",      	dfEngUpKey,		0,			false,		true);
                    InitDataProperty(0, cnt++,		dtCombo,				100,		daCenter,		true,     "bl_img_file_tp_cd",		false,		"",         dfNone,     	0,          false,      false);
                    InitDataProperty(0, cnt++,		dtCheckBox,				80,			daCenter,		true,     "rat_flg",				false,		"",         dfNone,     	0,          true,       true);
                    InitDataProperty(0, cnt++,		dtData,					130,		daCenter,		true,     "upd_usr_id",				false,		"",         dfNone,     	0,          false,      false);
                    InitDataProperty(0, cnt++,		dtData,					110,		daCenter,		true,     "upd_dt",					false,		"",         dfNone,     	0,          false,      false);

                    InitDataCombo(0, "bl_img_file_tp_cd",  "SWB",       "W",    "");
            	}
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {        	
			case IBSEARCH:      //조회				
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;					
					sheetObj.DoSearch("ESM_BKG_1509GS.do", FormQueryString(formObj));
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					/**					
					sheetObj.DoSave("ESM_BKG_1509GS.do", FormQueryString(formObj), -1, false, true);
					**/
					
	            	var sParam = ComGetSaveString(sheetObj, false);
				    sParam += "&" + FormQueryString(formObj);
				               	
	            	var sXml = sheetObj.GetSaveXml("ESM_BKG_1509GS.do", sParam);
	            	
	            	//조회 후 결과처리
					var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					sheetObj.LoadSaveXml(sXml);
					
					if ( svcResult == "S" ) {
						// 저장 성공시에만 재조회 실행.
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}					
					
                }else{
					return false;					
				}
			break;

			case IBINSERT:     
				var newRow = sheetObj.DataInsert(-1);
				
				sheetObj.CellValue2(newRow, "upd_usr_id") = formObj.usr_id.value;
													
			break;
			
			case IBDELETE:        //row delete
				
	 			if (sheetObj.RowCount == 0){
	 				ComShowMessage(ComGetMsg("BKG03054")); //There is no data to delete.
	 				return false;
	 			}
	        		        	
	        	ComRowHideDelete(sheetObj, "chk");					
				
			break;
			
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {

			case IBSEARCH:

				break;

            case IBSAVE:

				if(sheetObj.IsDataModified == false){
					ComShowMessage(ComGetMsg("BKG00737")); //Nothing Changed!!!
					return false;
				}
				            	
				var hrows = sheetObj.HeaderRows;
				var rows = sheetObj.RowCount;		
			
				for(i=hrows; i<=rows; i++) {
					if(sheetObj.CellValue(i,"cust_code") == "") {
						ComShowMessage(ComGetMsg("COM12114", "customer code")); //Please check {?msg1}
						return false;
					}
				}							
				
				if(sheetObj.ColValueDup("cust_code",false) > -1) {
					ComShowMessage(ComGetMsg("COM131302","customer code")); //{?msg1} is duplicated.
					return false;
				}
								
				
			break;
        }

        return true;
    }
     
    /**
     * sheet1 Popup Click Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> row, 선택한 Col ==> col
     * 
     */
    function sheet1_OnPopupClick(sheetObj, row, col) {
		with(sheetObj) { 
			switch (sheetObj.ColSaveName(col)) {
				case "cust_code" :
					//Customer Code 선택팝업 열기					
					comBkgCallPop0652('callBack0652',row + "|" + col,"","", "");
		        	break;

			}
 		}
 	}
      
    /**
     * Customer Code 선택 팝업 callback 함수
     */    
    function callBack0652(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[0];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], sheetObj.ColSaveName(sp[1])) = rArray1[0][4];    	
    }
    
    /**
     * grid cell 데이터 변경시
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     * @return
     */
 	function sheet1_OnChange (sheetObj, Row, Col, Value) {
 		var formObj 		= document.form;
		var colName 		= sheetObj.ColSaveName(Col);
 		
		if(colName == "cust_code") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    
			    //customer code 유효성 검사
		 	    var sXml = sheetObj.GetSearchXml("ESM_BKG_1509GS.do?f_cmd="+SEARCH02+"&cust_code="+Value);
		 	    
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//조회 후 결과처리
				var cust_code_yn = ComGetEtcData(sXml, "cust_code_yn");	
				if(cust_code_yn == "N") {
					ComShowMessage(ComGetMsg("COM12114", "customer code")); //Please check {?msg1}
					sheetObj.CellValue2(Row, Col) = "";
					sheetObj.SelectCell(Row, Col);
				}
			}
		}
		
			
 	}
       
    
	/* 개발자 작업  끝 */