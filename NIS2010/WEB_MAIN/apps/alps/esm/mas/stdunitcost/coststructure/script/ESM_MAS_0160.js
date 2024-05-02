/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0160.js
*@FileTitle : Route Management for Agreement Restricion
*Open Issues :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.22 장영석
* 1.0 Creation
*Change history :
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
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
     * @class ESM_MAS_0160 : ESM_MAS_0160 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0160() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.sheet1_OnChange        = sheet1_OnChange;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.doActionIBSheet2 		= doActionIBSheet2;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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

    				case "btng_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    				case "btng_RowAdd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
    					break;

    			} // end switch
    		}catch(e) {
    			if( e == "[object Error]") {
    				ComShowMessage(getMsg(OBJECT_ERROR));
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
    	function loadPage(hdCode, hdText) {
    		for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet(sheetObjects[i]);//khlee-시작 환경 설정 함수 이름 변경
    			initSheet(sheetObjects[i],i+1, hdCode, hdText);
    			ComEndConfigSheet(sheetObjects[i]);//khlee-마지막 환경 설정 함수 추가
    		}
    	}

    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo, hdCode, hdText, row, col, value) {

    		var cnt = 0;
    		switch(sheetNo) {
    			case 1:
    				with (sheetObj) {
    				style.height = GetSheetHeight(23) ;
    				SheetWidth = mainTable.clientWidth;													//전체 너비 설정
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msHeaderOnly;															//전체Merge 종류 [선택, Default msNone]
    				Editable = true;																	//전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo(2, 1, 9, 100);															//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]

    				var HeadTitle0 = "Del.|STS|Location\nHierachy|Route|Route|Route|Route|ALL|" +
    						"SCFURD|SCFURT|SCFUTD|SCFUWD|SCFUWR|SCFUWT|TRLSRD|TRLCRD|TRTSRD|TRTSRT|" +
    						"TRDRRD|TRTCRD|TRLSRT|TRLCRT|TRDRRT|TRTCRT|TRLSTD|TRTSTD|TRTCTD|TRDRTD|" +
    						"TRLCTD|TRTCWD|TRLSWT|TRTSWD|TRLSWD|TRDRWD|TRLCWD|TRTSWR|TRTSWT|TRLSWR|" +
    						"TRLCWR|TRDRWR|TRTCWR|TRDRWT|TRTCWT|TRLCWT" ;
    						
    				var HeadTitle1 = "Del.|STS|Location\nHierachy|1st Node|2nd Node|3rd Node|4th Node|ALL|" +
    						"Other Transport Expense|Other Transport Expense|Other Transport Expense|Other Transport Expense|Other Transport Expense|Other Transport Expense|Rail Direct|Rail Direct|Rail Direct|Rail Direct|" +
    						"Rail Direct|Rail Direct|Rail Direct|Rail Truck|Rail Truck|Rail Truck|Truck Direct|Truck Direct|Truck Direct|" +
    						"Truck Direct|Truck Direct|Water Direct|Water Direct|Water Direct|Water Direct|Water Direct|Water Direct|Water Direct|Water DirectWater Direct|" +
    						"Water Rail|Water Rail|Water Rail|Water Truck|Water Truck|Water Truck" ;

    				var aryNm = null;
    				var aryCd = null;
    				var aryCnt = 0;

    				//가변헤더의 헤더정보 세팅
    				///*
    				if(hdCode != '' && hdText != ''){
    					aryNm = hdText.split("|");
    					aryCd = hdCode.split("|");
    					aryCnt = aryNm.length;
                               
    					HeadTitle0 = "Del.|STS|Location\nHierachy|Route|Route|Route|Route|All|";
    					HeadTitle1 = "Del.|STS|Location\nHierachy|1st Node|2nd Node|3rd Node|4th Node|All|";

    					for(var k=0; k<aryCnt; k++) {
    						HeadTitle0 = HeadTitle0 + aryCd[k]+ "|";
    						HeadTitle1 = HeadTitle1 + aryNm[k]+ "|";
    					}
    					
    				HeadTitle0 += "H" ;
    				HeadTitle1 += "H" ;
    					
    				}
    				//*/
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				if(aryCnt>0) InitColumnInfo(9+aryCnt, 8, 0, true);
    				else InitColumnInfo(44, 8, 0, true);
    				
    				//해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle0, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//데이터속성[ROW,COL,	DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,	KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,
    				//	EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
    				InitDataProperty(0,cnt++,	dtCheckBox,	30,	daCenter,	true,	"loc_delt_flg",			false,	"",	dfNone,		0,	true,	true,	-1,	false,	false);
    				InitDataProperty(0,cnt++,	dtStatus,	30,	daCenter,	true,	"ibflag",				false,	"",	dfNone,		0,	false,	false,	-1,	false,	false);
    				InitDataProperty(0,cnt++,	dtCombo,	80, daLeft,		true,	"loc_grp_tp_cd",	    true,	"",	dfNone,		0,	true,	true);

    			    InitDataProperty(0,cnt++,	dtData,		100,daCenter,	true,	"n1st_nod_cd",	        false,	"",	dfNone,		0,	true,	true,	2,	false,	false);
    				InitDataProperty(0,cnt++,	dtData,		100,daCenter,	true,	"n2nd_nod_cd",	        false,	"",	dfNone,		0,	true,	true,	2,	false,	false);
    				InitDataProperty(0,cnt++,	dtData,		100,daCenter,	true,	"n3rd_nod_cd",	        false,	"",	dfNone,		0,	true,	true,	2,	false,	false);
    				InitDataProperty(0,cnt++,	dtData,		100,daCenter,	true,	"n4th_nod_cd",	        false,	"",	dfNone,		0,	true,	true,	2,	false,	false);

                    InitDataProperty(0,cnt++,	dtCheckBox,	30,daCenter,	true,	"all_flg",	            false,	"",	dfNone,		0,	true,	true,	-1,	false,	false);
    				//otd dtCombo
    				//가변헤어의 데이터 속성 Setting
    				if(hdCode != '' && hdText != ''){
    					for(var k=0; k<aryCnt; k++) {
    						InitDataProperty(0,	cnt++,	dtCheckBox,	100,	daCenter,	true,	aryCd[k],	false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
    					}
    				} else {
    					for(var k=1; k<36; k++){
    						InitDataProperty(0,	cnt++,	dtCheckBox,	100,	daCenter,	true,	"code"+k,	false,	"",	dfNone,	0,	true,	true,	-1,	false,	false);
    					}
    				}
    				InitDataProperty(0,cnt++,	dtHidden,	30,	daCenter,	true,	"cost_src_usr_flg",	    false,	"",	dfNone,	0,	false,	false,	-1,	false,	false);
    				
    				InitDataCombo(0, "loc_grp_tp_cd", "|Country|Location|Yard", "|C|L|Y");
    				
    				RangeBackColor(1, 3, 1, 7) = RgbColor(222, 251, 248);	// ENIS
    				CountPosition	= 0
    				RangeBackColor(1, 8, 1, 44) = RgbColor(222, 251, 248);	// ENIS
    			}
    			break;
    		}
    	}
    	
       	// Location Hierachy(LOC_GRP_TP_CD)가 변경되었을때 Node 입력자리수를 변경
    	function sheet1_OnChange(sheetObj, row, col, value){
    		var formObj = document.form;
    		var tmpSN = sheetObj.ColSaveName(col);
    		formObj.sRow.value = row;
    		var sLen = 0;
    		if(tmpSN == "loc_grp_tp_cd"){
    		    sheetObj.CellValue2(row,"loc_grp_tp_cd") = value;

    			formObj.changeValue.value = value;
    		    if(value=="C") {
    		       sLen = 2;
    		    }else if (value=="L"){
    		       sLen = 5; 
    		    }else if (value=="Y"){
    		       sLen = 7; 
    		    }   
    			
    			sheetObj.InitCellProperty(row, "n1st_nod_cd", dtData, daCenter, "n1st_nod_cd", "", dfNone, 0, sLen); 
    			sheetObj.InitCellProperty(row, "n2nd_nod_cd", dtData, daCenter, "n2nd_nod_cd", "", dfNone, 0, sLen); 
    			sheetObj.InitCellProperty(row, "n3rd_nod_cd", dtData, daCenter, "n3rd_nod_cd", "", dfNone, 0, sLen); 
    			sheetObj.InitCellProperty(row, "n4th_nod_cd", dtData, daCenter, "n4th_nod_cd", "", dfNone, 0, sLen); 
    		}

    	}

    	// Location Hierachy(LOC_GRP_TP_CD)가 변경되었을때 Node 입력자리수를 변경
    	function sheet1_OnClick(sheetObj, row, col, value){
    		var formObj = document.form;
    		var tmpSN = sheetObj.ColSaveName(col);
    		formObj.sRow.value = row;

    		if(tmpSN == "all_flg" && value == "1"){
    		    for(k=1; k<row+1; k++){
        		    if (tmpSN == "all_flg" && k==row){
            		    for(i=8; i<44; i++) {
            		       sheetObj.CellValue(k, i) = 0;
            		       //sheetObj.CheckAll(i) = 1;
            		    } 
        		    }
    		    }
    		}else{
    		    for(k=1; k<row+1; k++){
        		    if (tmpSN == "all_flg" && k==row){
            		    for(i=8; i<44; i++) {
            		       sheetObj.CellValue(k, i) = 1;      		       
            		       //sheetObj.CheckAll(i) = 0;
            		    }
        		    }    
    		    }    
    		}
    	}


    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {

    			case IBSEARCH:	//조회
    				if(validateForm(sheetObj,formObj,sAction)){
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch4Post("ESM_MAS_0160GS.do", masFormQueryString(formObj));
    					ComOpenWait(false);
    				}
    				break;

    			case IBSAVE:		//저장
    				if(validateForm(sheetObj,formObj,sAction)){
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = MULTI;
    					sheetObj.DoSave("ESM_MAS_0160GS.do", masFormQueryString(formObj));
    					//sheetObj.DoAllSave("ESM_MAS_160GS.do", FormQueryString(formObj));
    					ComOpenWait(false);
    				}
    				break;

    			case IBINSERT:	// 입력
    				sheetObj.DataInsert(-1); // 마지막행에 행삽입
    				//sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
    				break;
    		}
    	}

    	// Sheet관련 프로세스 처리
    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    			case IBROWSEARCH: //행내용 업데이트
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				var formObj2 = document.hiddenF;
    				formObj2.f_cmd.value = COMMAND01;    				
    				ComOpenWait(false);
    				break;
    		}
    	}
 	
       	/**
    	* 유효성 체크
    	*/

    	function chkValidSearch(sheetObj, row, col, value){
    		var tmpSN = sheetObj.ColSaveName(col);  	
    	    		
    		return true;
    	}
    	
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    		}            
    		return true;
    	}

 

	/* 개발자 작업  끝 */