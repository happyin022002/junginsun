/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : menumanagement.js
*@FileTitle : Menu Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.04
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.03.04 김경범
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
     * @class Menu Management : Menu Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function menumanagement() {
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
	
	var initRoad = true;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_Add":
            		doActionIBSheetAdd(sheetObject1,sheetObject2,ComGetObjValue(formObject.add_type));
            		break;
            		
            	case "btn_Retrieve":
            		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            		break;

            	case "btn_Save":
            		doActionIBSheet(sheetObject1,formObject,IBSAVE);
            		break;

            	case "btn_DownExcel":
            		doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
            		sheetObject2.SpeedDown2Excel(0);
            		sheetObject3.SpeedDown2Excel(-1, true, true);
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
     * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
     * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
     * @param {ibsheet} sheet_obj    IBSheet Object
     **/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
	}
     function initControl() {
       	var formObject = document.form;
           //Axon 이벤트 처리1. 이벤트catch(개발자변경)
           axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
           axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
       }
       
       //업무 자바스크립트 OnKeyPress 이벤트 처리
       function keypressFormat() {
       	obj = event.srcElement;
     	    if(obj.dataformat == null) return;
     	    window.defaultStatus = obj.dataformat;
     	    switch(obj.name) {
     	        case "pgm_no":
     	        	ComKeyOnlyAlphabet('uppernum',"95");
     	            break;
   	            
     	    }
       }
    /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 322;
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
                var HeadTitle = "Division|Program No|Program Name|Program Url" ;
				var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                
                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCombo,    60,  daCenter,  false,   "pgm_mnu_div_cd",    false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    120,  daCenter,  false,   "pgm_no",     false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    180,  daLeft,    false,   "pgm_nm",     false,        "",     dfNone,       0,        false,       false);
                InitDataProperty(0, cnt++ , dtData,    130,  daLeft,    false,   "pgm_url",     false,        "",     dfNone,       0,        false,       false);

                InitDataCombo(0, "pgm_mnu_div_cd", "Menu|Program", "01|02");
                CountPosition = 0;
                WaitImageVisible = false;

            }
            break;

        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 322;
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
                var HeadTitle = "|Del|Level|Menu No|Menu Name|Order|Program Url|Pgm_Level|Cfg Cd|Parent No|access level" ;
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                
                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");	
				InitDataProperty(0, cnt++ , dtDelCheck,		30,		daCenter,		true,		"DEL",			false,			"",      dfNone,		0,		true,		true);
                InitDataProperty(0, cnt++ , dtData,          70,  daCenter,  false,   "level",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,          120,  daCenter,  false,   "chd_pgm_no", false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,         180,  daLeft,    false,   "pgm_nm",     false,        "",       dfNone,	      0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,          40,  daCenter,  false,   "dp_seq",     false,        "",       dfNone,        0,        true,       true);
                InitDataProperty(0, cnt++ , dtData,          180,  daLeft,  false,   "pgm_url",     false,        "",       dfNone,        0,        true,       true);
                InitDataProperty(0, cnt++ , dtHidden,        50,  daCenter,  false,   "pgm_lvl_val",false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtHidden,        50,  daCenter,  false,   "mnu_cfg_cd", false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtHidden,        80,  daCenter,  false,   "prnt_pgm_no",false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtHidden,        80,  daCenter,  false,   "access_lvl",false,        "",       dfNone,        0,       false,       true);
                
                InitTreeInfo(2, "level");
                CountPosition = 0;
                WaitImageVisible = false;
            }
            break;

        case "sheet3":
            with (sheetObj) {
                // 높이 설정
                style.height = 0;
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
                var HeadTitle = "Level1|Level2|Level3|Level4|Level5|Level6|Program No|Menu Name|Program Url" ;
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(9, 0, 0, true);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                
                //데이터속성    	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,		false,		"lvl1",      false,        "",       dfNone,        0,       false,       true);
				InitDataProperty(0, cnt++ , dtData,		100,		daCenter,		false,		"lvl2",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  false,   "lvl3",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  false,   "lvl4",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  false,   "lvl5",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  false,   "lvl6",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        100,  daCenter,  false,   "pgm_no",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        150,  daCenter,  false,   "pgm_desc",      false,        "",       dfNone,        0,       false,       true);
                InitDataProperty(0, cnt++ , dtData,        150,  daCenter,  false,   "pgm_url",      false,        "",       dfNone,        0,       false,       true);
                CountPosition = 0;
                WaitImageVisible = false;
            }
            break;

        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){				
						
					if (sheetObj.id == "sheet1"){
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCH;
						var sXml = sheetObj.GetSearchXml("MenuManagementGS.do" , FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");
						if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[1]);
						if (arrXml.length > 1 && initRoad) {
							sheetObjects[1].LoadSearchXml(arrXml[0]);
							sheetObjects[1].ShowTreeLevel(1,1);
						}
						ComOpenWait(false);
					}
					if(initRoad)	initRoad = false;
				}
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
            	formObj.f_cmd.value = MULTI;
                //저장처리
                var formparam = FormQueryString(formObj);
                sheetObjects[1].DoSave("MenuManagementGS.do", formparam);
				//sheetObjects[1].ShowTreeLevel(1,1);
				break;

			case IBINSERT:      // 입력
				row = sheetObj.DataInsert(-1);
				break;
				
			case IBDOWNEXCEL:		// Excel download
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("MenuManagementGS.do" , FormQueryString(formObj));
				sheetObjects[2].LoadSearchXml(sXml);
				break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    
    // sheet click
    function sheet2_OnClick(sheetObj, Row, Col) {
    	var boxes = document.getElementsByTagName("input");
    	var access_level = sheetObj.CellValue(Row,"access_lvl");
    	for ( var i = 0 ; i < boxes.length ; i++ ) 
    		if ( boxes[i].getAttribute("type") == "checkbox" ) 
    			boxes[i].checked = false;
    	if ( access_level.charAt(0) == '1' )	document.all.SHO.checked = true;
    	if ( access_level.charAt(1) == '1' )	document.all.RHQ.checked = true;
    	if ( access_level.charAt(2) == '1' )	document.all.GOF.checked = true;
    	if ( access_level.charAt(3) == '1' )	document.all.SOF.checked = true;
    	if ( access_level.charAt(4) == '1' )	document.all.LOF.checked = true;
    	if ( access_level.charAt(5) == '1' )	document.all.AGT.checked = true;
    	if ( access_level.charAt(6) == '1' )	document.all.OTH.checked = true;
      }
        
    // Sheet관련 프로세스 처리
    function doActionIBSheetAdd(srcSheetObj,tgtSheetObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        var sRowStr = srcSheetObj.GetSelectionRows();
        var arr = sRowStr.split("|");
        
        /*
        0 : Child 
        1 : Previous Sibling 
        2 : Next Sibling 
		*/
        switch(sAction) {
           case "0":      //as last child
                var newRowLevel = tgtSheetObj.RowLevel(tgtSheetObj.SelectRow)+1;
                var prnt_pgm_no = tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"chd_pgm_no");
                
                for (i=0; i<arr.length; i++) {
                    // If insert same program numbers to child of itself, do not work and alert to user !   
                    if( prnt_pgm_no == srcSheetObj.CellValue(arr[i],"pgm_no") )
                    {
                    	ComShowMessage("Can not insert program_no into a child of itself !\n[" + 
                    			srcSheetObj.CellValue(arr[i],"pgm_no") + "]");  
                    	return;
                    }
                }
                
                for (i=0; i<arr.length; i++) {
                    tgtSheetObj.DataInsert(tgtSheetObj.SelectRow,newRowLevel);
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"chd_pgm_no") = srcSheetObj.CellValue(arr[i],"pgm_no");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_nm") = srcSheetObj.CellValue(arr[i],"pgm_nm");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"dp_seq") = "1";
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_lvl_val") = tgtSheetObj.RowLevel(tgtSheetObj.SelectRow);
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"mnu_cfg_cd") = tgtSheetObj.CellValue(tgtSheetObj.SelectRow-1,"mnu_cfg_cd");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no") = prnt_pgm_no;
                    //tgtSheetObj.showTreeLevel(-1);
                }
                setMenuOrder(tgtSheetObj,tgtSheetObj.SelectRow);
                break;
            case "1":     //as previous sibling

            	//2015.01.07 Heo: parent node check
                var prnt_pgm_no = tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no");
                
                for (i=0; i<arr.length; i++) {
                    // If insert same program numbers to child of itself, do not work and alert to user !   
                    if( prnt_pgm_no == srcSheetObj.CellValue(arr[i],"pgm_no") )
                    {
                    	ComShowMessage("Can not insert program_no into a child of itself !\n[" + 
                    			srcSheetObj.CellValue(arr[i],"pgm_no") + "]");  
                    	return;
                    }
                }
               	//2015.01.07 Heo: End

                //var prnt_pgm_no = tgtSheetObj.CellValue(tgtSheetObj.SelectRow-1,"chd_pgm_no");
                for (i=arr.length-1; i>-1; i--) {
                    tgtSheetObj.DataInsert(tgtSheetObj.SelectRow-1,tgtSheetObj.RowLevel(tgtSheetObj.SelectRow));
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"chd_pgm_no") = srcSheetObj.CellValue(arr[i],"pgm_no");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_nm") = srcSheetObj.CellValue(arr[i],"pgm_nm");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"dp_seq") = "1";
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_lvl_val") = tgtSheetObj.RowLevel(tgtSheetObj.SelectRow);
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"mnu_cfg_cd") = tgtSheetObj.CellValue(tgtSheetObj.SelectRow+1,"mnu_cfg_cd");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no") = tgtSheetObj.CellValue(tgtSheetObj.SelectRow+1,"prnt_pgm_no");
                    //tgtSheetObj.showTreeLevel(-1);
                }
                setMenuOrder(tgtSheetObj,tgtSheetObj.SelectRow);
                break;
           case "2":      //as next sibling

           	//2015.01.07 Heo: parent node check
               var prnt_pgm_no = tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no");
               
               for (i=0; i<arr.length; i++) {
                   // If insert same program numbers to child of itself, do not work and alert to user !   
                   if( prnt_pgm_no == srcSheetObj.CellValue(arr[i],"pgm_no") )
                   {
                   	ComShowMessage("Can not insert program_no into a child of itself !\n[" + 
                   			srcSheetObj.CellValue(arr[i],"pgm_no") + "]");  
                   	return;
                   }
               }
           	//2015.01.07 Heo: End

               if(tgtSheetObj.IsHaveChild(tgtSheetObj.SelectRow)){  // Node인 경우
               var rowLevel = tgtSheetObj.RowLevel(tgtSheetObj.SelectRow);
               var currOrder = eval(tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"dp_seq"));
               var prntPgm = tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no");
               var currRow = tgtSheetObj.RowCount;
               for(i=tgtSheetObj.SelectRow+1;i<=tgtSheetObj.RowCount;i++){
                 if(tgtSheetObj.RowLevel(i)<=tgtSheetObj.RowLevel(tgtSheetObj.SelectRow)){
                   currRow = i-1;
                   break;
                 }
                 //else if(i==tgtSheetObj.RowCount){
                 //  currRow = i;
                 //}
               }
                tgtSheetObj.SelectRow = currRow;
                //ComShowMessage(rowLevel);
                for (i=0; i<arr.length; i++) {
                    tgtSheetObj.DataInsert(tgtSheetObj.SelectRow,rowLevel);
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"chd_pgm_no") = srcSheetObj.CellValue(arr[i],"pgm_no");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_nm") = srcSheetObj.CellValue(arr[i],"pgm_nm");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"dp_seq") = currOrder+1;
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_lvl_val") = rowLevel;
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"mnu_cfg_cd") = tgtSheetObj.CellValue(tgtSheetObj.SelectRow-1,"mnu_cfg_cd");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no") = prntPgm;
                }
                setMenuOrder(tgtSheetObj,tgtSheetObj.SelectRow);
                break;
             }else{// || tgtSheetObj.SelectRow == tgtSheetObj.RowCount // Leaf인 경우
                for (i=0; i<arr.length; i++) {
                    tgtSheetObj.DataInsert(tgtSheetObj.SelectRow,tgtSheetObj.RowLevel(tgtSheetObj.SelectRow));
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"chd_pgm_no") = srcSheetObj.CellValue(arr[i],"pgm_no");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_nm") = srcSheetObj.CellValue(arr[i],"pgm_nm");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"dp_seq") = eval(tgtSheetObj.CellValue(tgtSheetObj.SelectRow-1,"dp_seq"))+1;
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"pgm_lvl_val") = tgtSheetObj.RowLevel(tgtSheetObj.SelectRow);
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"mnu_cfg_cd") = tgtSheetObj.CellValue(tgtSheetObj.SelectRow-1,"mnu_cfg_cd");
                    tgtSheetObj.CellValue(tgtSheetObj.SelectRow,"prnt_pgm_no") = tgtSheetObj.CellValue(tgtSheetObj.SelectRow-1,"prnt_pgm_no");
                    //tgtSheetObj.showTreeLevel(-1);
                }
                setMenuOrder(tgtSheetObj,tgtSheetObj.SelectRow);
                break;
             }
        }
    }

    /**
     * 추가/변경된 메뉴의 메뉴순번을 재정렬한다.
     */
    function setMenuOrder(sheetObj,currRow){
      //ComShowMessage(currRow);
      var nodes = getSiblingNodes(sheetObj,currRow);
      //ComShowMessage(nodes.join(","));
      for(k=0;k<nodes.length;k++){
        sheetObj.CellValue2(nodes[k],"dp_seq") = k+1;
      }
    }
    
    /**
     * 파라메터로 받은 행번호의 데이터와 동일한 부모노드를 가진 자식노드들의 배열을 넘긴다.
     */
    function getSiblingNodes(sheetObj,currRow){
      //부모노드의 트리레벨
      var parentRowLevel = sheetObj.RowLevel(currRow)-1;
      //부모노드의 프로그램번호
      var parentPgmNo = sheetObj.CellValue(currRow,"prnt_pgm_no");
      //부모노드의 행번호
      var parentRow = 0;
      //자식노드 배열
      var childNodes = new Array();
      //자식노드 배열인덱스
      var arrIndex = 0;
      //ComShowMessage("변수선언 완료");
      //부모노드 찾기
      for(i=currRow-1;i>-1;i--){
        if(sheetObj.CellValue(i,"chd_pgm_no")==parentPgmNo){
          parentRow = i;
          break;
        }
      }
      //ComShowMessage("부모노드 찾기 완료 :" + parentRow);
      
      //자식노드 찾기
      for(j=parentRow+1;j<=sheetObj.RowCount;j++){
        if(sheetObj.RowLevel(j)<=parentRowLevel){
          //ComShowMessage("자식노드 찾기 if :" + j);
          break;
        }else if(sheetObj.CellValue(j,"prnt_pgm_no")==parentPgmNo){
          //ComShowMessage("자식노드 찾기 else if :" + j + " 메뉴번호 :" + sheetObj.CellValue(j,"chd_pgm_no"));
          childNodes[arrIndex++] = j;
        }
      }
      //ComShowMessage("자식노드 찾기 완료");
      
      return childNodes;
    }

	/* 개발자 작업  끝 */