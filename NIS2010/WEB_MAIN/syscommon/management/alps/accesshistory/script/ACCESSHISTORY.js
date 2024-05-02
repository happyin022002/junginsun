/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ACCESSHISTORY.js
*@FileTitle : AccessHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.02.01 김경범
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
     * @class ACCESSHISTORY : ACCESSHISTORY 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ACCESSHISTORY() {
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
    var timer;
    var sheetObjects = new Array();
    var sheetCnt = 0;
	document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_New":
				    form.dateFrom.value = ComGetDateAdd(ComGetDateAdd(null,"M",-1),"D",-1);
				    form.dateTo.value = ComGetDateAdd(null,"D",0);
				    formObject.hourFrom.value = "00";
				    formObject.hourTo.value = "23";
				    formObject.level.value = "6";
				    formObject.kind.value = "";
				    formObject.rhq.value = "";
				    formObject.ofcCd.value = "";
				    formObject.pgmNo.value = "";
				    formObject.usrId.value = "";
					break;

				case "btn_DownExcel":
            		doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					break;

				case "btn_ofc_cd":
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL', 700, 500, "ofc_cd:ofcCd", '0,0,1,1,1,1,1,1', true);
					break;
					
				case "btn_pgm_no":
					ComOpenPopup("/hanjin/ESM_HJS_0101.do", 500, 465, "setPgmNo", "0,1,1");
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
				ComConfigSheet (sheetObjects[i]);

				initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
			initControl();
			sheetObjects[0].ColHidden("rhq") = true;
			sheetObjects[0].ColHidden("ofc_cd") = true;
			sheetObjects[0].ColHidden("usr_id") = true;
		}
    
    function initControl() {
      	var formObject = document.form;
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)
   	  	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObject); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
   	  	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }

    function obj_deactivate(){
    	 ComChkObjValid(event.srcElement);
   }

   function obj_activate(){
    	 ComClearSeparator(event.srcElement);
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
	        case "skd_id":
	        	ComKeyOnlyNumber(obj);
	            break;
		    case "dateFrom":
		        ComKeyOnlyNumber(obj, "-"); 
	            break;
		    case "dateTo":
		        ComKeyOnlyNumber(obj, "-"); 
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

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 400;
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

                    var HeadTitle1 = "Level||Menu No|Menu Name|Total Count|Menu Count|CUD Count|R Count|ETC Count|RHQ|Office|User ID";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"level",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,	true,		"hlvl",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	true,		"pgm_no",			false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		true,		"pgm_nm",		false,			"",      dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_total",			false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_load",		false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_cud",		false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_rrr",					false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_etc",			false,			"",      dfNullInteger,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,		"rhq",				false,			"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,		"ofc_cd",				false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,		"usr_id",			false,			"",      dfNone,				0,		false,		false);

	                InitTreeInfo(0, "level");
					CountPosition = 0;
			}
            break;
            case "sheet2":
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
                    var HeadTitle = "Level1|Level2|Level3|Level4|Level5|Level6|Menu No|Menu Name|Total Count|Menu Count|CUD Count|R Count|ETC Count|RHQ|Office|User ID" ;
                    var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
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
                    InitDataProperty(0, cnt++ , dtData,        150,  daCenter,  false,   "pgm_nm",      false,        "",       dfNone,        0,       false,       true);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_total",			false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_load",		false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_cud",		false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_rrr",					false,			"",      dfNullInteger,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	true,		"cnt_etc",			false,			"",      dfNullInteger,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,		"rhq",				false,			"",      dfNone,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,		"ofc_cd",				false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,	true,		"usr_id",			false,			"",      dfNone,				0,		false,		false);
                    CountPosition = 0;
                    WaitImageVisible = false;
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
			    	ComOpenWait(true);
			        sheetObj.WaitImageVisible = false;
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ADM_ACS_0001GS.do", FormQueryString(formObj));
					var key = "";
					if (sXml != "") key = ComGetEtcData(sXml,"key");
					timer = setInterval('checkHistoryData(0,'+key+');', '5000');
			    	ComOpenWait(false);
				}
				break;
			
			case IBDOWNEXCEL:		// Excel download
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ADM_ACS_0001GS.do" , FormQueryString(formObj));
				var key = "";
				if (sXml != "") key = ComGetEtcData(sXml,"key");
				timer = setInterval('checkHistoryData(1,'+key+');', '5000');
				break;

        }
    }
    function checkHistoryData(sheetNum,key) {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[sheetNum];
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("ADM_ACS_0001GS.do?key="+key, FormQueryString(formObj));
		if (sXml != "") {
			if ( sheetNum == 0 ) {
				if ( ComGetEtcData(sXml,"key") == key )
					document.all.btn_Retrieve.innerHTML = '<font color=red>Retrieving</font>';
				else {
					sheetObj.LoadSearchXml(sXml);
					sheetObj.ShowTreeLevel(formObj.level.value,1);
					clearInterval(timer);
					document.all.btn_Retrieve.innerHTML = 'Retrieve';
				}
			} else {
				if ( ComGetEtcData(sXml,"key") == key )
					document.all.btn_DownExcel.innerHTML = '<font color=red>Downloading</font>';
				else {
					sheetObj.LoadSearchXml(sXml);
            		sheetColHidden(sheetObj);
            		sheetObjects[0].Down2Excel(-1);
            		sheetObj.SpeedDown2Excel(-1, true, true);
					clearInterval(timer);
					document.all.btn_DownExcel.innerHTML = 'Down Excel';
				}
			}
		}
    }

    function sheet1_OnSearchEnd(sheetObj){
    	sheetObj.ReDraw = false;
    	calculateSubSum(sheetObj, "4", "5", "#CCFFCC")
    	calculateSubSum(sheetObj, "3", "4", "#99FF99")
    	calculateSubSum(sheetObj, "2", "3", "#33FF33")
    	calculateSubSum(sheetObj, "1", "2", "#33CC33")
    	sheetColHidden(sheetObj);
    	sheetObj.CellValue2(0, "level") = "Level (-)";
    	sheetObj.ReDraw = true;
    }
    
    function sheet1_OnSort(sheetObj, Col, SortArrow) {
    	if ( Col == 0 ) {
    		if ( sheetObj.CellValue(Col, "level") == "Level (-)" ) {
    			sheetObj.ShowTreeLevel(0,1);
    			sheetObj.CellValue2(Col, "level") = "Level (+)";
    		} else {
    			sheetObj.ShowTreeLevel(-1);
    			sheetObj.CellValue2(Col, "level") = "Level (-)";
    		}
    	}
    }

    function calculateSubSum(sheetObj, plvl, clvl, color){
    	//alert(plvl+' '+clvl+' '+color);
    	var preColNum = 0;
    	var totTOT = 0;
    	var totLOAD = 0;
    	var totCUD = 0;
    	var totREAD = 0;
    	var totETC = 0;
		for(var i=1; i<sheetObj.rowCount+1; i++) {
    		if(sheetObj.CellValue(i, "hlvl") == plvl) {
    			if ( preColNum > 0 ) {
    				sheetObj.CellValue2(preColNum, "cnt_total") = totTOT;
        			sheetObj.CellBackColor(preColNum,"cnt_total") = sheetObj.WebColor(color);	   				
    				sheetObj.CellValue2(preColNum, "cnt_load") = totLOAD;
        			sheetObj.CellBackColor(preColNum,"cnt_load") = sheetObj.WebColor(color);	   				
    				sheetObj.CellValue2(preColNum, "cnt_cud") = totCUD;
        			sheetObj.CellBackColor(preColNum,"cnt_cud") = sheetObj.WebColor(color);	   				
    				sheetObj.CellValue2(preColNum, "cnt_rrr") = totREAD;
        			sheetObj.CellBackColor(preColNum,"cnt_rrr") = sheetObj.WebColor(color);	   				
    				sheetObj.CellValue2(preColNum, "cnt_etc") = totETC;
        			sheetObj.CellBackColor(preColNum,"cnt_etc") = sheetObj.WebColor(color);	   				
        			totTOT = 0; totLOAD = 0; totCUD = 0; totREAD = 0; totETC = 0;
    			}
    			if (sheetObj.CellValue(i, "cnt_total") == "") preColNum = i;
    			else preColNum = 0;
   			}
    		if(sheetObj.CellValue(i, "hlvl") == clvl) {
    	    	var tmpTOT = 0;
    	    	var tmpLOAD = 0;
    	    	var tmpCUD = 0;
    	    	var tmpREAD = 0;
    	    	var tmpETC = 0;
    			if ( sheetObj.CellValue(i, "cnt_total") == "" ) sheetObj.CellValue2(i, "cnt_total") = 0;
    			else tmpTOT = sheetObj.CellValue(i, "cnt_total");
    			if ( sheetObj.CellValue(i, "cnt_load") == "" ) sheetObj.CellValue2(i, "cnt_load") = 0;
    			else tmpLOAD = sheetObj.CellValue(i, "cnt_load");
    			if ( sheetObj.CellValue(i, "cnt_cud") == "" ) sheetObj.CellValue2(i, "cnt_cud") = 0;
    			else tmpCUD = sheetObj.CellValue(i, "cnt_cud");
    			if ( sheetObj.CellValue(i, "cnt_rrr") == "" ) sheetObj.CellValue2(i, "cnt_rrr") = 0;
    			else tmpREAD = sheetObj.CellValue(i, "cnt_rrr");
    			if ( sheetObj.CellValue(i, "cnt_etc") == "" ) sheetObj.CellValue2(i, "cnt_etc") = 0;
    			else tmpETC = sheetObj.CellValue(i, "cnt_etc");
    			totTOT = totTOT + parseInt(tmpTOT,10);
    			totLOAD = totLOAD + parseInt(tmpLOAD,10);
    			totCUD = totCUD + parseInt(tmpCUD,10);
    			totREAD = totREAD + parseInt(tmpREAD,10);
    			totETC = totETC + parseInt(tmpETC,10);
    		}
   		}
		if ( preColNum > 0 ) {
			//alert(sheetObj.CellValue(preColNum, "pgm_nm")+"::"+totTOT+"::"+totLOAD+"::"+totCUD+"::"+totREAD+"::"+totETC)
			sheetObj.CellValue2(preColNum, "cnt_total") = totTOT;
			sheetObj.CellBackColor(preColNum,"cnt_total") = sheetObj.WebColor(color);	   				
			sheetObj.CellValue2(preColNum, "cnt_load") = totLOAD;
			sheetObj.CellBackColor(preColNum,"cnt_load") = sheetObj.WebColor(color);	   				
			sheetObj.CellValue2(preColNum, "cnt_cud") = totCUD;
			sheetObj.CellBackColor(preColNum,"cnt_cud") = sheetObj.WebColor(color);	   				
			sheetObj.CellValue2(preColNum, "cnt_rrr") = totREAD;
			sheetObj.CellBackColor(preColNum,"cnt_rrr") = sheetObj.WebColor(color);	   				
			sheetObj.CellValue2(preColNum, "cnt_etc") = totETC;
			sheetObj.CellBackColor(preColNum,"cnt_etc") = sheetObj.WebColor(color);
			preColNum = 0;
		}
    }
    
    function sheetColHidden(sheetObj){
    	var kind = document.form.kind.value;
    	var rhq = document.form.rhq.value;
    	var ofcCd = document.form.ofcCd.value;
    	var usrId = document.form.usrId.value;
    	if (kind == "") {
    		sheetObj.ColHidden("cnt_total") = false;
    		sheetObj.ColHidden("cnt_load") = false;
    		sheetObj.ColHidden("cnt_cud") = false;
    		sheetObj.ColHidden("cnt_rrr") = false;
    		sheetObj.ColHidden("cnt_etc") = false;
    	} else if (kind == "M") {
    		sheetObj.ColHidden("cnt_total") = false;
    		sheetObj.ColHidden("cnt_load") = false;
    		sheetObj.ColHidden("cnt_cud") = true;
    		sheetObj.ColHidden("cnt_rrr") = true;
    		sheetObj.ColHidden("cnt_etc") = true;
		} else if (kind == "C") {
			sheetObj.ColHidden("cnt_total") = false;
			sheetObj.ColHidden("cnt_load") = true;
			sheetObj.ColHidden("cnt_cud") = false;
			sheetObj.ColHidden("cnt_rrr") = true;
			sheetObj.ColHidden("cnt_etc") = true;
		} else if (kind == "R") {
			sheetObj.ColHidden("cnt_total") = false;
			sheetObj.ColHidden("cnt_load") = true;
			sheetObj.ColHidden("cnt_cud") = true;
			sheetObj.ColHidden("cnt_rrr") = false;
			sheetObj.ColHidden("cnt_etc") = true;
		} else if (kind == "E") {
			sheetObj.ColHidden("cnt_total") = false;
			sheetObj.ColHidden("cnt_load") = true;
			sheetObj.ColHidden("cnt_cud") = true;
			sheetObj.ColHidden("cnt_rrr") = true;
			sheetObj.ColHidden("cnt_etc") = false;
		}
    	if (rhq == "") {
    		sheetObj.ColHidden("rhq") = true;
    	} else {
    		sheetObj.ColHidden("rhq") = false;
    	}
    	if (ofcCd == "") {
    		sheetObj.ColHidden("ofc_cd") = true;
    	} else {
    		sheetObj.ColHidden("ofc_cd") = false;
    	}
    	if (usrId == "") {
    		sheetObj.ColHidden("usr_id") = true;
    	} else {
    		sheetObj.ColHidden("usr_id") = false;
    	}

    }

    /**
     * 팝업에서 Check로 멀티 선택을 한경우..
     */
    function setPgmNo(rowArray) {
    	var form = document.form;
    	form.pgmNo.value = "";
    	var gubun = ',';
    	
    	for(var i=0; i<rowArray.length; i++)
    	{
    		if(i == rowArray.length-1) gubun = '';
    		
    		colArray = rowArray[i];
    		form.pgmNo.value += colArray[2] + gubun;
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
	/* 개발자 작업  끝 */