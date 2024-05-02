/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0070.js
*@FileTitle : Segregation Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
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
     * @class vop_scg_0070 : vop_scg_0070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0070() {
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
    var sheetCnt     = 0;
    var prefixs      = new Array("sheet1_","sheet2_");  

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
				case "btn2_Row_Add":
					sheetObject1.DataInsert(-1,0);								//마지막행에 생성[Sheet1]
					initCell(sheetObject1, sheetObject1.selectRow, 2, false);	//선택Cell 초기화
					break;
				case "btn2_Row_Add2":
					sheetObject2.DataInsert(-1,0);								//마지막행에 생성[Sheet2]
					copySheetCell();											//선택된 그룹NO 복사
					initCell(sheetObject2, sheetObject2.selectRow, 4, false);	//선택Cell 초기화
					break;
				case "btn2_Row_Insert":
					sheetObject1.DataInsert();									//선택행아래 생성[Sheet1]
					initCell(sheetObject1, sheetObject1.selectRow, 2, false);	//선택Cell 초기화
					break;
				case "btn2_Row_Insert2":
					sheetObject2.DataInsert();									//선택행아래 생성[Sheet2]
					copySheetCell();											//선택된 그룹NO 복사
					initCell(sheetObject2, sheetObject2.selectRow, 4, false);	//선택Cell 초기화
					break;
				case "btn2_Row_Copy":
					sheetObject1.DataCopy();									//선택행아래 복사[Sheet1]
					initCell(sheetObject1, sheetObject1.selectRow, 2, false);	//선택Cell 초기화
					break;
				case "btn2_Row_Copy2":
					sheetObject2.DataCopy();									//선택행아래 복사[Sheet2]
					initCell(sheetObject2, sheetObject2.selectRow, 4, false);	//선택Cell 초기화
					break;
				case "btn2_Row_Delete":
					//Row 삭제하기전 선택여부 확인 후 하위목록 지우기
					deletRowCheck(formObj, sheetObject1, sheetObject2, prefixs[0]+"del_chk");
					ComRowHideDelete(sheetObject1, prefixs[0]+"del_chk");					
					break;
				case "btn2_Row_Delete2":
					ComRowHideDelete(sheetObject2, prefixs[1]+"del_chk");
					break;
				case "btn1_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn1_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
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
     * 선택된 Segregation Group No 복사[Sheet1 --> Sheet2]
     */
    function copySheetCell() {
    	var groupNo = sheetObjects[0].CellValue(sheetObjects[0].selectRow, prefixs[0]+"imdg_segr_grp_no");
    	
    	if(groupNo == '') {
    		ComShowCodeMessage('SCG50013');	//'You have to add a new segregation group first.'
    		sheetObjects[1].RowDelete(sheetObjects[1].selectRow,false);	//Heavy metals and their salts 을 생성하기 위해서는 Segregation Group No 입력이 선행되어야 한다.
    	} else {
    		//Segregation Group No 복사
    		sheetObjects[1].CellValue2(sheetObjects[1].selectRow, prefixs[1]+"imdg_segr_grp_no") = groupNo;
    	}
    }
    
    /**
     * 선택된 Cell의 초기화와 포커스 이동
     */
    function initCell(sheetObj, Row, Col, valDel) {
    	if(valDel) sheetObj.CellValue2(Row,Col) = "";	//서동호(2009.06.08) 기능 삭제요청
		sheetObj.SelectCell(Row,Col);
    }
    
    /**
     * Row 삭제시 선택 포커스 이동
     */
    function deletRowCheck(formObj, sheetObj1, sheetObj2, col) {
    	//SaveName  -> Index
		col = ComIsNumber(col)?ComParseInt(col):sheetObj1.SaveNameCol(col);
		
		var sRow = sheetObj1.FindCheckedRow(col);
		var arrRow = sRow.split("|");

    	var idxStr;
    	for(var idx=0; idx<arrRow.length; idx++) {
    		idxStr = arrRow[idx];
    		if(idxStr == sheetObj1.selectRow) {
    			
    			var ibflag, nearRow, continueYn;	    			
    			for(var rowIdx=sheetObj1.HeaderRows; rowIdx<=sheetObj1.LastRow; rowIdx++) {
    				ibflag = sheetObj1.cellValue(rowIdx,prefixs[0]+"ibflag");	
    				if(ibflag != 'D') {
    					var grpNo = sheetObj1.cellValue(rowIdx,prefixs[0]+"imdg_segr_grp_no");	
    					if(idxStr == rowIdx) {
    						if(nearRow != undefined) {
    							break;
    						} else {
    							continueYn = 'Y';
    							continue;
    						}
    					} else if(continueYn != undefined) {
    						if(nearRow != undefined) {
    							break;
    						}
    					}
    					if(sRow.indexOf(rowIdx+"|") == -1) {
    						nearRow = rowIdx;
    					}
    				}
    			}
    			
    			if(nearRow != undefined) {
    				sheetObj1.SelectCell(nearRow,prefixs[0]+"imdg_segr_grp_nm");
					setSubMaterial(formObj, sheetObj1, sheetObj2, nearRow);
    			} else {
	    			//Heavy metals and their salts의 Title 지우기
	    			setSubTitle("");
					sheetObj2.RemoveAll();
    			}
				
				return;
    		}
    	}
    }
    
    /**
     * 하위목록 타이틀 셋팅
     */
    function setSubTitle(val) {
    	document.getElementById("subTitle").innerText = val;
    }
    
    /**
     * Group Key 셋팅 - 하위 목록 조회시 사용
     */
    function setGroupKey(sheetObj, Row) {
    	document.form.imdg_segr_grp_no.value = sheetObj.cellValue(Row,prefixs[0]+"imdg_segr_grp_no");
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
    }

    /**
     * sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
    	//초기 Segregation Group List 조회
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
        	case "sheet1":      //sheet1 init
               with (sheetObj) {
                    //높이 설정
					style.height = 440;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Sel.|No.|Segregation Groups";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefixs[0]+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		prefixs[0]+"del_chk",		   false,	  "",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		prefixs[0]+"imdg_segr_grp_no", true,      "",				dfNone,     0,			false,		true,	4);
					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		false,		prefixs[0]+"imdg_segr_grp_nm", false,     "",				dfNone,		0,			true,		true,	100);
					
					InitDataValid(0, prefixs[0]+"imdg_segr_grp_no", vtNumericOnly);
					
					//CountPosition = 0;

				}
                break;

			case "sheet2":      //sheet2 init
               with (sheetObj) {
                    //높이 설정
					style.height = 430;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "||Sel.|No.|UN No.";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefixs[1]+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		prefixs[1]+"imdg_segr_grp_no",  true,       "");					
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		prefixs[1]+"del_chk",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	false,		prefixs[1]+"dtSeq",			    false,      "",				dfNumber,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			0,		daLeft,		false,		prefixs[1]+"imdg_un_no",		true,       "",				dfNone,		0,			false,		true,	4, true);
					
					InitDataValid(0, prefixs[1]+"imdg_un_no", vtNumericOnly);
					
					CountPosition = 0;

				}
                break;
        }
    }
    
    /**
     * Sheet1 Grid Change Event 처리
     * param : sheetObj ==> 시트오브젝트, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	//codeDupCheck(sheetObj,Row, Col, Value, "2");	//imdg_segr_grp_no Value Duplication Check - //서동호(2009.06.08) 기능 삭제요청
   	}
    
    /**
     * Sheet1 Grid AfterEdit Event 처리
     * param : sheetObj ==> 시트오브젝트, Row ==> Grid Row, Col ==> Grid Col
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {    	
    	if(Col == "3") {
    		//Heavy metals and their salts의 Title을 셋팅한다.
    		setSubTitle(sheetObj.cellValue(Row,prefixs[0]+"imdg_segr_grp_nm"));    		
    	} else if(Col == "2") {
    		//Segregation Group 에 따른 Heavy metals and their salts 을 조회한다.
    		setGroupKey(sheetObj, Row);
    	}
   	}
    
    /**
     * Sheet2 Grid Change Event 처리
     * param : sheetObj ==> 시트오브젝트, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
    	//codeDupCheck(sheetObj,Row, Col, Value, "4");	//imdg_un_no Value Duplication Check - //서동호(2009.06.08) 기능 삭제요청
    	if(Col == "4") codeValidCheck(sheetObj,Row, Col, Value);
   	}
    
    /**
     * Sheet1, Sheet2 Duplication 처리
     * param : sheetObj ==> 시트오브젝트, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value, chkCol ==> Duplication Check Col
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function codeDupCheck(sheetObj, Row, Col, Value, chkCol) {
    	
    	//체크할 Col의 Cell이 변경되었을 경우에만 수행
    	if(Col == chkCol) {
	    	var dupRow = sheetObj.ColValueDup(chkCol,true);
	    	//중복여부를 체크하되 공백인 셀은 제외
	    	if(dupRow != -1 && sheetObj.CellValue(dupRow,chkCol) != '') {
	    		ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'
	    		initCell(sheetObj, Row, Col, false);
	    		return false;
	    	} else {
	    		//Sheet2의 경우에는 SCG_IMDG_UN_NO 테이블의 코드 유효성까지 체크한다.
	    		if(sheetObj.id == 'sheet2') {
	    			if(!codeValidCheck(sheetObj,Row, Col, Value)) return false;
	    		}
	    	} 
    	}
    	return true;
    }
    
    /**
     * Sheet2 UN No. Validation 처리
     * param : sheetObj ==> 시트오브젝트, Row ==> Grid Row, Col ==> Grid Col, Value ==> Grid Cell Value
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function codeValidCheck(sheetObj, Row, Col, Value) {
    	
    	var unData = checkValidUN(sheetObj, Value);
		
		if(unData == null) {
			ComShowCodeMessage('SCG50010', 'Data');	//'{?msg1} is invalid.'
			initCell(sheetObj, Row, Col, true);
			return false;
		}
    	return true;
    }
    
    /**
     * United Nations(UN) Number 유효성 체크
     */
    function checkValidUN(sheetObj, Value)  {
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCH03;						
		var sXml = sheetObj.GetSearchXml("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") + "&imdg_un_no=" + Value, false);
		var unData = ComScgXml2Array(sXml, prefixs[1]+"imdg_un_no");
		
		return unData;
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
    var isCallBack = false;	//이전 Row 선택상태로 돌릴지의 여부
 	function doRowChange(sheet1, sheet2, OldRow, NewRow, OldCol) {
 		var formObj = document.form;
 		//CallBack 이 아니고 다른 Row를 선택했을 경우에만 수행
		if (!isCallBack && OldRow != NewRow) {
				
			var valTrue = true;
			if (OldRow != 0 && sheet2.IsDataModified) {
				if (ComShowCodeConfirm("SCG50003")) {	//'Data was changed. Do you want to save it?'
					valTrue = doActionIBSheet(sheet1, formObj, IBSAVE);
					//Sheet2의 수정,추가된 Row가 Validation하지 않을 경우 이전상태로 복귀시킨다.
					if(valTrue != null && !valTrue) {
						isCallBack = true;
						sheet1.SelectCell(OldRow, OldCol, false);							
						return;
					}
				}
			}
			
			//Heavy metals and their salts의 하위목록 구성
			setSubMaterial(formObj, sheet1, sheet2, NewRow);
		}
		isCallBack = false;
		
		return;
	}
 	
 	/**
     * Heavy metals and their salts의 하위목록 구성
     */
    function setSubMaterial(formObj, sheet1, sheet2, NewRow) {
    	//Heavy metals and their salts의 Title을 셋팅한다.
		setSubTitle(sheet1.cellValue(NewRow,prefixs[0]+"imdg_segr_grp_nm"));
		
		//Segregation Group 에 따른 Heavy metals and their salts 을 조회한다.
		setGroupKey(sheet1, NewRow);
		
		//신규 Row의 경우 초기화
		var ibflag = sheet1.cellValue(NewRow,prefixs[0]+"ibflag");	
		if(ibflag != 'I') {	
			doActionIBSheet(sheet2,formObj,IBSEARCH);
		} else {
			sheet2.RemoveAll();
		}
    }

 	/**
     * Sheet관련 Transaction Event 처리
     * param : sheetObj ==> 시트오브젝트, formObj ==> 폼오브젝트, sAction ==> 수행할 Event
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				//Segregation Group 조회
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value = SEARCH01;						
					sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(new Array("sheet1_","sheet2_")));
				}
				//Heavy metals and their salts 조회
				else if ( sheetObj.id == "sheet2") {
					formObj.f_cmd.value = SEARCH02;
				  	sheetObj.DoSearch("VOP_SCG_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
			    }				
                break;
			
			case IBSAVE:        //저장				
				if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
        			return false;
        		}
				if(!validateForm(sheetObjects[0],formObj,sAction)) {
            		return false;
            	}				
            	if(!validateForm(sheetObjects[1],formObj,sAction)) {
            		return false;
            	}
            	
            	if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
            	
            	formObj.f_cmd.value = MULTI;
            	
            	var sParam = ComGetSaveString(sheetObjects);
            	
			    if (sParam == "") return false;
			   
			    sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(new Array("sheet1_","sheet2_"));
			    var sXml = sheetObjects[0].GetSaveXml("VOP_SCG_0070GS.do", sParam);
			    
			    //sheetObjects[0].LoadSaveXml(sXml); 
			    
			    ComScgSaveCompleted();
			    
			    //저장후 상세목록 재조회
			    doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
			    
                break;

        }
		return true;
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
    	var dupChkIdx = "2";
    	if(sheetObj.id == 'sheet2') dupChkIdx = "4";
    	
    	var ibflag;
    	var sVal1;
    	var sVal2;
    	for(var rowIdx1=1; rowIdx1<sheetObj.RowCount; rowIdx1++) {
    		ibflag = sheetObj.cellValue(rowIdx1,0);			
    		sVal1 = sheetObj.CellValue(rowIdx1, dupChkIdx);
			if(ibflag != 'D' && sVal1 != '') {				
	    		for(var rowIdx2=rowIdx1+1; rowIdx2<=sheetObj.RowCount; rowIdx2++) {
	    			ibflag = sheetObj.cellValue(rowIdx1,0);	
					sVal2 = sheetObj.CellValue(rowIdx2, dupChkIdx);
					if(ibflag != 'D' && sVal2 != '') {
		    			if(sVal1 == sVal2) {
		    				ComShowCodeMessage('SCG50005', 'Data');   //'{?msg1} is duplicated.'    				
		    				initCell(sheetObj, rowIdx2, dupChkIdx, false);
		    				return false;
		    			}
		    		}
				}
			}
    	}

        return true;
    }

	/* 개발자 작업  끝 */