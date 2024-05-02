/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0124.js
*@FileTitle : Bottleneck Input
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.10.21 함대성
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESM_SAQ_0034 : ESM_SAQ_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SAQ_0034() {
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
    var comObjects   = new Array();
    var sheetCnt     = 0;
    var comboCnt     = 0;
    // sheet선택한 값
    // 조회조건에서 선택한 lane값 addRow할때 셋팅
    var set_lane     = "";
    //var st = 0;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObject  = sheetObjects [0];
    	var formObject = document.form;
    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    					doActionIBSheet(sheetObject , formObject, IBSEARCH);
    				break;
    			
    			case "btn_save":
    				doActionIBSheet(sheetObject , formObject, IBSAVE);
    				break;
    			
    			case "btng_rowadd1":
    				doActionIBSheet(sheetObject, formObject, IBINSERT);
    				break;
    				
				case "btng_ok":  
					window.close();
					break;
    			
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg("COM12111"));
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
    	sheetObjects [sheetCnt++] = sheet_obj;
    }
    
     /** 
      * IBCombo Object를 배열로 등록
      * param : combo_obj ==> 콤보오브젝트
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */ 
     function setComboObject(combo_obj) {  
         comboObjects[comboCnt++] = combo_obj;  
     }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(rlaneSheetList, rlaneNmSheetList) {
    	for(i = 0; i < sheetObjects .length; i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects [i]);
    		initSheet(sheetObjects [i], i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects [i]);
    	}
    	 
    	var sheetResizeFull = true;
    	
    	////////////////////////////Multi-Combo////////////////////////////////
    	
 		var comboList = new Array();
 		comboList1 =  rlaneSheetList.split("|");
 	 	comboList2 =  rlaneNmSheetList.split("|");
        
 	 	currencyKindCode  = "";
 	 	currencyKindDesc  = "";
 	 	
 	 	for(var i = 0; i < comboList1.length;i++){
	 	 	currencyKindCode = currencyKindCode + comboList1[i].split("|") + "|";
	 	 	currencyKindDesc = currencyKindDesc + comboList1[i].split("|")+"\t"+comboList2[i].split("|") + "|";
 	 	}
 	 	sheetObjects[0].InitDataCombo(0, sheetObjects[0].SaveNameCol("slan_cd"),  currencyKindDesc,  currencyKindCode, currencyKindCode.substring(0,currencyKindCode.indexOf("|")) );
 	 	
    }
     
     function sheet1_OnLoadFinish(sheetObj) {
         //doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
   	   //if(st == 0){
 		   var formObject = document.form;
		   doActionIBSheet(sheetObjects[0] , formObject, IBSEARCH);
	   //}
	   //st++;
     }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj, sheetNo) {
     	var cnt = 0;

     	switch (sheetNo) {
     	case 1: 
     		with (sheetObj) {
             // 높이 설정
             style.height = 260;
             //전체 너비 설정
             SheetWidth = mainTable1.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msNone;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = true;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 1, 1, 3, 100);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(7, 0, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(true, true, false, true, false,false)

             var HeadTitle = "STS|Del.|Lane|Name";

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle, true);

             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++ , dtHiddenStatus,0,    daCenter,  true,    "ibflag");
             InitDataProperty(0, cnt++ , dtDelCheck,    80,   daCenter,  true,    "dtDelCheck",    false,    "",      dfNone);

             InitDataProperty(0, cnt++ , dtComboEdit,   120,  daCenter,  true,    "slan_cd",       false,    "",      dfEngUpKey,    0,     false,      true,          3 );
             InitDataProperty(0, cnt++ , dtData,        160,  daLeft,    true,    "vsl_slan_nm",   false,    "",      dfNone,		 0,     false,      true,          7 );
             
             InitDataProperty(0, cnt++ , dtHidden,        160,  daLeft,    true,  "rout_rcv_dt",   false,    "",      dfNone,		 0,     false,      true,          7 );
             InitDataProperty(0, cnt++ , dtHidden,        160,  daLeft,    true,  "rout_seq",      false,    "",      dfNone,		 0,     false,      true,          7 );
             InitDataProperty(0, cnt++ , dtHidden,        160,  daLeft,    true,  "blck_seq",      false,    "",      dfNone,		 0,     false,      true,          7 );
     		}
     		break;

     	}
     }
     
    /*
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(validateForm(sheetObj, formObj, sAction)) {
    				formObj.f_cmd.value = SEARCHLIST01;
    				sheetObj.DoSearch4Post("ESD_SCE_0124GS.do", SceFrmQryString(formObj));
    			}
    			break;
    		
    		case IBSAVE:        //save
    			var SaveStr = ComGetSaveString(sheetObj);
    			formObj.f_cmd.value = MULTI;
    			var sXml  = sheetObj.GetSaveXml("ESD_SCE_0124GS.do", SaveStr + "&" + SceFrmQryString(formObj));
    			sheetObj.LoadSaveXml(sXml);
    			//for parent window 
    			var blockSel = "";
    	        for(var i=0; i<sheetObj.RowCount; i++) {
    	        	if(i<0) break;
    	            blockSel += sheetObj.CellValue(i + 1, "slan_cd");
    	            if(i != sheetObj.RowCount-1) {
    	            	blockSel += ",";
    	            }
    	        }
    	        // 모달창인 경우는 window 객체로부터 opener를 획득
    			if(!opener)
    				opener = window.dialogArguments;
    			
    			var gubun = formObj.gubun.value;
    			opener.popOk(gubun, blockSel);
    			window.close();
	    		break;
    		
    		case IBINSERT:      // row insert
    			var Row = sheetObj.DataInsert();
				// 조회조건에 lane 의 값이 있으면 그 값으로 셋팅하여 row추가
				sheetObj.CellValue2(Row, 2) = " ";
				
    			sheetObj.CellValue(Row,  sheetObj.SaveNameCol("rout_seq")) = formObj.rout_seq.value;
    			sheetObj.CellValue(Row,  sheetObj.SaveNameCol("rout_rcv_dt")) = formObj.rout_rcv_dt.value;
    			break;
    		 
    	}
    }
    
    /*
     * lane chage 
     */ 
    function sheet1_OnChange(sheetObj, row, col, value) {
    	with(sheetObj){
    		switch(ColSaveName(col)) {
    			case "slan_cd":
    	            // Duplication(중복) 체크
    				var dup = 0;
    	            for(var i=0; i<sheetObj.RowCount; i++) {
    	                if(sheetObj.CellValue(i + 1, "slan_cd") == value) {
    	                	dup++;
    	                }
    	                if(dup > 1){
    	                    ComShowMessage(value + " is already added");
    	                    sheetObj.CellValue(i + 1, "slan_cd") = "";
    	                    return;
    	                }
    	            }
    				
    				var sText = sheetObj.GetComboInfo(row, col, "Text");
    				var arrText = sText.split("|");
    				var idx = sheetObj.GetComboInfo(row, col, "SelectedIndex");
    				if(idx >= 0){
	    				var vText = arrText[idx].split("\t");
	    				sheetObj.CellValue(row, "vsl_slan_nm") = vText;
    				}
    			break;
    		}
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
    	with(formObj){
//    		if (!isNumber(iPage)) {
//    			return false;
//    		}
    	}
    	return true;
    }
     
   function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	   //
   }

    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
     
    
	/* 개발자 작업  끝 */