/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0071.js
*@FileTitle : Segregation Group (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.19 김현욱
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
     * @class vop_scg_0071 : vop_scg_0071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0071() {
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
    var prefixs = new Array("sheet1_","sheet2_");  

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObj      = document.form; 
		/*******************************************************/
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn1_Retrieve":
					doActionIBSheet(sheetObject1, formObj,IBSEARCH);
					break;
				case "btn1_Down_Excel":
                    var paramObj = new Object();
                    paramObj.title = "Segregation Group";
                    paramObj.orientation = "Portrait";
                    paramObj.columnwidth = "2:80";
                    var url = ComScgGetPgmTitle(sheetObject1, paramObj); 
                    sheetObject1.SpeedDown2Excel(-1, false, false, "", url, false,false,"Segregation Group",false);

                    if(sheetObject2.RowCount > 0) {
	                    var paramObj = new Object();
	                    paramObj.title = document.getElementById("subTitle").innerText;
	                    paramObj.orientation = "Portrait";
	                    paramObj.columnwidth = "2:80";
	                    var url = ComScgGetPgmTitle(sheetObject2, paramObj); 
	                    sheetObject2.SpeedDown2Excel(-1, true, true, "", url, false, false,"Heavy metals and their salts",false);
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
    function setSheetObject(sheet_obj) {
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
        //초기 Segregation Group List 조회
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
        	case "sheet1":      //t2sheet1 init
               with (sheetObj) {
                    //높이 설정
					style.height = 464;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|No.|Segregation Groups";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefixs[0]+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		prefixs[0]+"imdg_segr_grp_no", false,     "",				dfNumber,   0,			false,		true,	4);
					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		false,		prefixs[0]+"imdg_segr_grp_nm", false,     "",				dfNone,		0,			true,		true,	100);
					
					//CountPosition = 0;

				}
                break;

			case "sheet2":      //t2sheet1 init
               with (sheetObj) {
                    //높이 설정
					style.height = 444;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "||No.|UN No.";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefixs[1]+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefixs[1]+"imdg_segr_grp_no",  false,       "");					
                    InitDataProperty(0, cnt++ , dtDataSeq,      40,    daCenter);
					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		false,		prefixs[1]+"imdg_un_no",		false,       "",				dfNone,		0,			true,		true,	4);
					
					CountPosition = 0;

				}
                break;
        }
    }
    
    /**
     * Sheet1 Cell Select Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 Row ==> NewRow, 선택한 Col ==> NewCol
     * 
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObj, sheetObjects[1], OldRow, NewRow, OldCol);
	} 	
    
    /**
     * Sheet1 Cell Select Event 처리
     * param : sheet1 ==> 시트오브젝트, sheet2 ==> 시트오브젝트, OldRow ==> 선택전 Row, 선택한 Row ==> NewRow, OldCol ==> 선택전 Col
     */
    function doRowChange(sheet1, sheet2, OldRow, NewRow, OldCol) {		
 		var formObj = document.form;
 		
		if (OldRow != NewRow) {
			//Heavy metals and their salts의 Title을 셋팅한다.
			document.getElementById("subTitle").innerText = sheet1.cellValue(NewRow,prefixs[0]+"imdg_segr_grp_nm");
			
			//Segregation Group 에 따른 Heavy metals and their salts 을 조회한다.
			formObj.imdg_segr_grp_no.value = sheet1.cellValue(NewRow,prefixs[0]+"imdg_segr_grp_no");				
			doActionIBSheet(sheet2,formObj,IBSEARCH);
		}
		
		return;
	}

 	/**
     * Sheet관련 Transaction Event 처리
     * param : sheetObj ==> 시트오브젝트, formObj ==> 폼오브젝트, sAction ==> 수행할 Event
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					//Segregation Group 조회
					if (sheetObj.id == "sheet1"){
						formObj.f_cmd.value = SEARCH01;						
						sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(new Array(prefixs[0],prefixs[1])));
					}
					//Heavy metals and their salts 조회
					else if ( sheetObj.id == "sheet2") {
						formObj.f_cmd.value = SEARCH02;
					  	sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[1]));
				   }	
				}					
                break;
        }
		return true;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }

        return true;
    }

	/* 개발자 작업  끝 */