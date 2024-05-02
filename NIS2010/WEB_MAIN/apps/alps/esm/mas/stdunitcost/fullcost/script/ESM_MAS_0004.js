/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0004.js
*@FileTitle : Node Cost (PA/RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 이중환
*@LastVersion : 1.1
* 2009.07.24 박수훈
* 1.0 Creation
=========================================================
* History
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이중환 FormQueryString -> masFormQueryString 변경
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
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
     * @class ESM_MAS_0004 : ESM_MAS_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
      function ESM_MAS_0004() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initSheet2Condition    = initSheet2Condition;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	this.sheet2_OnSearchEnd     = sheet2_OnSearchEnd;    	
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.doActionIBSheet2 		= doActionIBSheet2;
    	this.validateForm 			= validateForm;
    	this.hideActGrpCombo 	    = hideActGrpCombo;
    	this.showActGrpCombo 	    = showActGrpCombo;
    }

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		var sheetObject = sheetObjects[0];
    		var sheetObject1 = sheetObjects[1];

    		/*******************************************************/
    		var formObject = document.form;
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			switch(srcName) {
    				case "btn_new":
    					formObject.reset();
    					sheetObject.RemoveAll();
    					break;

    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_Retrieve3":
    					if(initSheet2Condition(formObject))	doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    					break;
    					
    				case "btn_Downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
    					break;

    				case "bu_zoom_in":
    					if(sheetObject1.RowCount>10){
    						sheetObject1.style.height = sheetObject1.GetSheetHeight(sheetObject1.RowCount+2);
    						div_zoom_out.style.display = "inline";
    						div_zoom_in.style.display = "none";
    						parent.syncHeight();
    					}
    					break;

    				case "bu_zoom_out":
    					if(sheetObject1.RowCount>10){
    						sheetObject1.style.height = sheetObject1.GetSheetHeight(10);
    						div_zoom_in.style.display = "inline";
    						div_zoom_out.style.display = "none";
    						parent.syncHeight();
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
    		
    		loadingMode = true;
    		
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            // 멀티콤보 처리
            //---------------------------------------------
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            loadingMode = false;
            
    		ComSetFocus(document.form.f_loc_cd);
    	}

    	/**
         * 멀티콤보 항목을 설정한다.
         */
         function initCombo(comboObj, comboId) {
        	 with (comboObj) {
    	    	 DropHeight = 300;
    	    	 switch(comboObj.id) {
    	    	 	case "f_cntr_tpsz_cd":
	    	    		IMEMode = 0;
	    	    		ValidChar(2, 1);
	    	    		MaxLength = 4;
	    	    		break;
    	    	 	case "f_act_grp_cd":
    	    	 		comboObj.InsertItem(0, 'All' ,'');
    	    	 		break;	
    	    	 }
    	    	 Index = 0;
    	    	 
        	 }
         }	
    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
    		if(sheetNo==1) {
    			with (sheetObj) {
    				SheetWidth = mainTable.clientWidth;//전체 너비 설정
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    				Editable = false;//전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo( 1, 1,1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitColumnInfo(5, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
    				//var HeadTitle = "Yard|Yard Name|H_YM|Lane|B/D|Select" ;
    				var HeadTitle = "Yard|Yard Name|Lane|B/D|Select" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		false,	"nod_cd",		false,"",dfNone, 0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,		350,	daLeft,		false,	"yd_nm",		false,"",dfNone, 0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"slan_cd",		false,"",dfNone, 0,	false,	false);
    				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"skd_dir_cd",	false,"",dfNone, 0,	false,	false);
    				InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	false,	"sel_check",	false,"",dfNone, 0,	true,	true,-1, true, true);

    				CountPosition	= 0 ;
    				style.height = GetSheetHeight(8) ;
    			}
    		} else if(sheetNo==2) {
    			with (sheetObj) {

    				SheetWidth = mainTable.clientWidth;//전체 너비 설정
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    				MergeSheet = msAll;//전체Merge 종류 [선택, Default msNone]
    				Editable = false;//전체Edit 허용 여부 [선택, Default false]
    				InitRowInfo( 1, 1,1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitColumnInfo(7, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
    				var HeadTitle = "A/G|Cost Element/Cost Code|Ctrt/Avg|Curr.|Cost|Speical|Location\nHierarchy" ;

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ ,	dtData,		100,	daLeft,		true,	"grp",				false,"",dfNone, 	0,	true,true); 
    				InitDataProperty(0, cnt++ ,	dtData,		250,	daLeft,		false,	"cost_nm",		    false,"",dfNone, 	0,	true,true);
    				InitDataProperty(0, cnt++ ,	dtData,		60,		daCenter,	false,	"cost_ass_bse_cd",	false,"",dfNone, 	0,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtData,		60,		daCenter,	false,	"locl_curr_cd",		false,"",dfNone, 	0,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtAutoSum,	120,	daRight,	false,	"cost",				false,"",dfNullFloatOrg, 2,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtData,		80,		daCenter,	false,	"spcl",				false,"",dfNone, 	0,	true,true, -1, false, false);
    				InitDataProperty(0, cnt++ ,	dtData,		60,		daCenter,	false,	"loc_type",			false,"",dfNone, 	0,	true,true, -1, false, false);

    				InitTreeInfo(1, "", RgbColor(0,0,255), false);
    				CountPosition	= 0 ;
    				style.height = GetSheetHeight(10) ;
    			}
    		}
    	}
    	
    	/**
    	* 하단 tab의 search condition을 default로 세팅
    	* fobj:폼객체
    	*/
    	function initSheet2Condition(fobj){
    	    var rt = true;
    		if(fobj.f_cost_yrmon.value == "") {
    			ComShowCodeMessage('MAS10002','YYYY-MM');
    			ComSetFocus(fobj.f_cost_yrmon);
    			rt = false;
    		} else {

    		}		
            
    		if (ComParseInt(fobj.f_cost_yrmon.value.replace("-","")) < 200707) {
    		    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    			ComShowCodeMessage('MAS10037');
    		    rt = false;
    		}
    		return rt;
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
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }
    	/**
    	* sheet1을 더블클릭하여 상세조회한다
    	*/
    	function sheet1_OnDblClick(sheetObj , row, col){
    		var sheetObject1 = sheetObjects[1];
    		
    		//현재날짜 세팅
    		var formObject = document.form;
    		formObject.f_cost_yrmon.value = ComGetNowInfo("ym");
    		
    		sheetObj.CellValue2(row,"sel_check") = 1;
    		
    		//해당행을 제외한 다른 check 삭제
    		var crCnt = sheetObj.CheckedRows("sel_check");
    		if(crCnt>0){
    			var chRow = sheetObj.FindCheckedRow("sel_check");
     			var ckArr = chRow.split("|");
    			for(var k=0; k<ckArr.length-1; k++) {
    				if(ckArr[k] != row) {
    					sheetObj.CellValue2(ckArr[k],"sel_check") = 0;
    				}
     			}
    		}
    		if(initSheet2Condition(formObject))	doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    	}
    	
    	
    	/**
    	* sheet1 상세 조회 후 그룹 당 하위 cost 값을 합해서 표현
    	*/
    	function sheet2_OnSearchEnd(sheetObj, errMessge) {

    		//소계 표현하기1 sub-total
    		//style.height = GetSheetHeight(100) ;
    		//if(sheetObj.RowCount>7){
    		//	sheetObj.style.height = sheetObj.GetSheetHeight(sheetObj.RowCount) ;
    		//}
    		sheetObj.ShowSubSum( "grp", "cost", 0);
    		sheetObj.ShowTreeLevel(0, 1);

    	}

    	
    	/**
    	* Sheet 관련 프로세스 처리 1
    	*/
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    			case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0004GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
					if (arrXml.length > 1)
						ComXml2ComboItem(arrXml[1], formObj.f_act_grp_cd, "code", "name");
					
					ComOpenWait(false);
					break;
    			case IBSEARCH:		//조회
    				if(validateForm(sheetObj,formObj,sAction)){
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH01;
    					//initSheet2Condition(formObj);
    	    		    //20100415 이중환, FormQueryString -> masFormQueryString 변경
    					sheetObj.DoSearch4Post("ESM_MAS_0004GS.do", masFormQueryString(formObj));
    					sheetObjects[1].RemoveAll();
    					ComOpenWait(false);
    				}
    				break;

    			case IBDOWNEXCEL:	//엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;
    		}
    	}


    	/**
    	* Sheet 관련 프로세스 처리 2
    	*/
    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    			case IBSEARCH:		//조회
    				if(validateForm(sheetObj,formObj,sAction)){
    					if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
    						if(sheetObjects[0].CheckedRows("sel_check")>0){//체크된행이 있는경우
    							// 업무처리중 버튼사용 금지 처리
    							sheetObj.WaitImageVisible = false;
    							ComOpenWait(true);
    							formObj.f_cmd.value = SEARCH02;    							
    							//선택된 행들을 쿼리로
    			    		    //20100415 이중환, FormQueryString -> masFormQueryString 변경
    							sheetObj.DoSearch4Post("ESM_MAS_0004GS2.do", masFormQueryString(formObj) +"&" +sheetObjects[0].GetSaveString(false, true, "sel_check"));
    							ComOpenWait(false);
    						} else {
    							ComShowCodeMessage('COM12113', 'Sheet1 Select CheckBox');
    						}
    					} else {
    						ComShowCodeMessage('MAS10005', 'Sheet1');
    					}
    				}
    				break;

    			case IBDOWNEXCEL:	//엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;
    		}
    	}
    	

    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){    		
    		var rt = false;    		
    		if(formObj.f_loc_cd.value == "") {
    			ComShowCodeMessage('MAS10002', 'Location');    			
    			ComSetFocus(formObj.f_loc_cd);
    			rt = false;
    		} else {
    			rt = true;
    		}
    		return rt;
    	}


 

    	/**
    	* Empty 선택시 Activity Group Combo를 비활성화 시킨다.
    	*/
    	function hideActGrpCombo(){
    		document.form.f_act_grp_cd.disabled = true;
    	}

    	/**
    	* Full 선택시 Activity Group Combo를 활성화 시킨다.
    	*/
    	function showActGrpCombo(){
    		document.form.f_act_grp_cd.disabled = false;
    	}
