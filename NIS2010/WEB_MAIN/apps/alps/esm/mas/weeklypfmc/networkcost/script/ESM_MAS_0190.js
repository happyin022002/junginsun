/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0190.js
*@FileTitle : Network Cost Exception List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 유제량
*@LastVersion : 1.0
=========================================================
* History
=========================================================
*/
 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0190 : ESM_MAS_0190 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0190() {
    this.processButtonClick    = processButtonClick   ;
    this.setYrWk               = setYrWk              ;
    //this.setYrMon              = setYrMon             ;
    this.fnYearWeekSet         = fnYearWeekSet        ;
    this.setPeriod             = setPeriod            ;
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd   ;
    //this.sheet3_OnSearchEnd    = sheet3_OnSearchEnd   ;
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateForm          = validateForm         ;
    this.ComAddSeparator_Local = ComAddSeparator_Local;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

var boolYyyyWw = true;
var prevWeek = "";
var fYear = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        
        /*******************************************************/
        var formObject = document.form;
        var objs = document.all.item("tabLayer");
        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Retrieve":
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                	
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                	
                    break;

                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    
                    break;
                    
                case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg(OBJECT_ERROR));
            } else {
                ComShowMessage(e);
            }
        }
    }

    /**
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013','25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */
    function setYrWk(fYear, prevWeek){
        var formObj = document.form;
        with(formObj){
            var nowYear = fYear;
            f_yearweek.value = nowYear+prevWeek;
            if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            // 기간 표시
            setPeriod(f_yearweek);
        }
        fnYearWeekSet(document.getElementById("f_yearweek"));
    }   

    function fnYearWeekSet(obj){     
        obj.value = ComGetMaskedValue(obj.value,"yw");
        setPeriod(obj);
    }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){ 		
        ComMasSetPeriod2(obj);
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	        	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
            	
        loadingMode = false;
    }

   	/**
     * 멀티콤보 항목을 설정한다.
     */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			
			switch(comboObj.id) {
			
			case "select1":
				DropHeight = 300;
				ValidChar(2, 1);	//영문대문자+숫자
				MaxLength = 4;
				Index = 0;
				break;
			
			case "f_selcost":
				DropHeight = 300;
				ValidChar(2, 1);	//영문대문자+숫자
				MaxLength = 15;
				Index = 0;
				break;
			}
		}
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
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:     //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;//전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                    Editable = true;//전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1, 1, 1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle   = "STS|Sel|Seq|Cost Code|Cost Name|Vessel code|From YYYY-WW|To YYYY-WW|Del.|Org Cost Code|Org From YYYY-WW|Org To YYYY-WW|Org Vessel code|cre_usr_id|upd_usr_id";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                                        
                    InitColumnInfo(headCount, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    
                    InitHeadMode(true, true, true, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]                    
                    InitHeadRow(0, HeadTitle, true);
                    //InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [   ROW, COL,   DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,   daCenter,   false,   "ibflag");
                    InitDataProperty(0, cnt++,  dtDelCheck,      40,   daCenter,   false,   "sel_chk",       false,      "",     dfNone,         0,   true,   true);
                    InitDataProperty(0, cnt++,  dtSeq,           40,   daRight,    false,   "seq_no",        false,      "",     dfNone,         0,   true,   true);
                    InitDataProperty(0, cnt++ , dtCombo,         80,   daCenter,   false,   "stnd_cost_cd",  false,      "",     dfNone,         0,   true,   true);
                    InitDataProperty(0, cnt++ , dtData,         110,   daLeft,     false,   "stnd_cost_nm",  false,      "",     dfNone,         0,   true,   true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daCenter,   false,   "vsl_cd",        false,      "",     dfNone,         0,   true,   true,  4);
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   false,   "eff_fm_yrwk",   false,      "",     dfUserFormat,   0,   true,   true);
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   false,   "eff_to_yrwk",   false,      "",     dfUserFormat,   0,   true,   true);
                                        
                    InitDataProperty(0, cnt++ , dtData,          70,   daCenter,   false,   "delt_flg",          false,      "",     dfNone,   0,   true,    true);
                    InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter,   false,   "stnd_cost_cd_org",  false,      "",     dfNone,   0,   false,   false);
                    InitDataProperty(0, cnt++ , dtHidden,       120,   daCenter,   false,   "eff_fm_yrwk_org",   false,      "",     dfNone,   0,   false,   false);
                    InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,   false,   "eff_to_yrwk_org",   false,      "",     dfNone,   0,   false,   false);
                    InitDataProperty(0, cnt++ , dtHidden,       100,   daCenter,   false,   "vsl_cd_org",        false,      "",     dfNone,   0,   false,   false);
                    InitDataProperty(0, cnt++ , dtHidden,        80,   daCenter,   false,   "cre_usr_id_org",    false,      "",     dfNone,   0,   false,   false);
                    InitDataProperty(0, cnt++ , dtHidden,        80,   daCenter,   false,   "upd_usr_id_org",    false,      "",     dfNone,   0,   false,   false);
                    //dtHidden
                    //InitDataValid(0, "cost_week", vtNumericOnly);
                    InitDataValid(0, "vsl_cd", vtEngUpOther, "1234567890");
                    InitDataValid(0, "delt_flg", vtEngUpOnly);
                    sheetObj.InitUserFormat(0, "eff_fm_yrwk", "####-##", "-" );
                    sheetObj.InitUserFormat(0, "eff_to_yrwk", "####-##", "-" );

                    CountPosition   = 0 ;
                    sheetObj.style.height = 420; //style.height = GetSheetHeight(18) ;
                }
                break;           
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
    
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;        
        if(sheetObj.ColSavename(col) == "stnd_cost_cd"){
            if(sheetObj.CellValue(row,"stnd_cost_cd") != ""){				
				formObj.f_cmd.value = COMMAND01;                        
				formObj.f_stnd_cost_cd.value = sheetObj.CellValue(row, "stnd_cost_cd");
	        	var sXml = sheetObj.GetSearchXml("ESM_MAS_0190GS.do","",masFormQueryString(formObj),true);
	        	var etcStndCostNm = ComGetEtcData(sXml, "etcStndCostNm");
	        	sheetObj.CellValue(row, "stnd_cost_nm") = etcStndCostNm;
            }
        }
    }

    /*function sheet1_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"sYM") = "TOTAL";
    }*/

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

        switch(sAction) {

        case IBCLEAR:          //조회
	        sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0190GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				ComXml2ComboItem(arrXml[0], formObj.select1, "code", "name");
				fYear = ComGetEtcData(arrXml[0], "fYear");				
				prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
				function(){setYrWk(fYear,prevWeek)};
			}
			if (arrXml.length > 1) {
				ComXml2ComboItem(arrXml[1], formObj.f_selcost, "code", "name|code");
			}
			if (arrXml.length > 2){				
				var arrCombo = ComXml2ComboString(arrXml[2], "code", "name");
				var sCode = arrCombo[0];
				var sName = arrCombo[1];
				var sCodeItems = sCode.split("|");
				var sNameItems = sName.split("|");
				var sComboItems = "";
				for (var i = 0 ; i < sCodeItems.length ; i++) {					
					sComboItems += sCodeItems[i] + "\t" + sNameItems[i] + "|";
				}				
				sheetObj.InitDataCombo(0,"stnd_cost_cd", sComboItems, sCode, "", "");
			}
			setYrWk(fYear,prevWeek);	

			ComOpenWait(false);
			break;	

		case IBSEARCH:      //조회
				ComAddSeparator_Local(formObj.f_yearweek, "-");
                //if(!validateForm(sheetObj,formObj,sAction)) return false;
                ComOpenWait(true); // 업무처리중 버튼사용 금지 처리
                sheetObj.Redraw = false;                           
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_MAS_0190GS.do", masFormQueryString(formObj));
                sheetObj.Redraw = true;                                
                ComOpenWait(false);
                break;
                
        case IBSAVE: //저장        	
        	// 트랜잭션 상태 코드 "R","I","U","D" 문자열을 "|"로 연결하여
        	// sStatus 인자에 설정하면 해당하는 트랜잭션상태의 행의 Index를 ";"로 조합하여 반환한다.        	 
        	var insRow = sheetObj.FindStatusRow("I"); //sheetObj.FindStatusRow("I|U");
        	var updRow = sheetObj.FindStatusRow("U"); //'U'는 (몇)주차 비교가 필요없음. 'I'는 필요함.
        	var arrInsRow = insRow.split(";");
        	var arrUpdRow = updRow.split(";");
        	if (insRow == "" && updRow == ""){
        		ComShowMessage(ComGetMsg('MAS10002','insert data or update data')); // Please enter {?msg1}.
        		return false;
        	}
        	
        	if (insRow != ""){
        		for (idx=0; idx<arrInsRow.length-1; idx++) {
        			
        			if (sheetObj.CellValue(arrInsRow[idx], "stnd_cost_cd") == "All"){
                		ComShowMessage(ComGetMsg('COM12114','Cost Code.\nPlease select something other than (All).')); // Please check {?msg1}
                		return false;
                	}

//            		var sccdRow01 = sheetObj.CellValue(arrInsRow[idx]-1, "stnd_cost_cd");
            		var sccdRow02 = sheetObj.CellValue(arrInsRow[idx], "stnd_cost_cd");
            		
//            		var vslcdRow01 = sheetObj.CellValue(arrInsRow[idx]-1, "vsl_cd");
            		var vslcdRow02 = sheetObj.CellValue(arrInsRow[idx], "vsl_cd");
            		
        			//var fmRow01 = sheetObj.CellValue(arrInsRow[idx]-1, "eff_fm_yrwk");
//        			var toRow01 = sheetObj.CellValue(arrInsRow[idx]-1, "eff_to_yrwk");
        			
            		var fmRow02 = sheetObj.CellValue(arrInsRow[idx], "eff_fm_yrwk");
            		var toRow02 = sheetObj.CellValue(arrInsRow[idx], "eff_to_yrwk");

            		var seqNo = sheetObj.CellValue(arrInsRow[idx], "seq_no");
            		if (ComParseInt(fmRow02) > ComParseInt(toRow02)){
                		ComShowMessage(ComGetMsg('COM12114','period.')); // Please check {?msg1}
                		return false;
                	}

            		if (sccdRow02 != "") {
                		for(i=0; i < sheetObj.RowCount; i++){
                			if(sccdRow02 == sheetObj.CellValue(i, "stnd_cost_cd")){
                				
                				if(vslcdRow02 == sheetObj.CellValue(i, "vsl_cd")){
                					/*
                        			if (ComParseInt(fmRow02) > ComParseInt(sheetObj.CellValue(i, "eff_to_yrwk"))){
                            		} else {                      			
                            			alert(ComParseInt(fmRow02) + " | " + ComParseInt(sheetObj.CellValue(i, "eff_to_yrwk")));
                            			ComShowMessage(ComGetMsg('COM12115','Period')); // Please check {?msg1}
                            			return false;
                            		}
                            		*/

                					if (ComParseInt(fmRow02) < ComParseInt(sheetObj.CellValue(i, "eff_to_yrwk")) && seqNo != sheetObj.CellValue(i, "seq_no")){

//                            			alert(ComParseInt(fmRow02) + " | " + ComParseInt(sheetObj.CellValue(i, "eff_to_yrwk")));
                            			ComShowMessage(ComGetMsg('COM12115','Period')); // Please check {?msg1}
                            			return false;
                            		}
                				} // vsl_cd
                			} // stnd_cost_cd
                				
                		}
/*
            			if (ComParseInt(fmRow02) > ComParseInt(toRow01)){
                		} else {
                			ComShowMessage(ComGetMsg('COM12114','YYYY-WW(From).')); // Please check {?msg1}
                			return false;
                		}
*/
            			if (toRow02 == ""){
            				ComShowMessage(ComGetMsg('COM12114','YYYY-WW(To).')); // Please check {?msg1}
                			return false;
            			}
            			
            		}
            		
            	} // for end
        	}
        	if (updRow != "") {
        		for (idx=0; idx<arrUpdRow.length-1; idx++) {
        			if (sheetObj.CellValue(arrUpdRow[idx], "stnd_cost_cd") == "All"){
        				ComShowMessage(ComGetMsg('COM12114','Cost Code.\nPlease select something other than (All).')); // Please check {?msg1}
                		return false;
                	}
        			var fmRow02 = sheetObj.CellValue(arrUpdRow[idx], "eff_fm_yrwk");
            		var toRow02 = sheetObj.CellValue(arrUpdRow[idx], "eff_to_yrwk");
            		if (ComParseInt(fmRow02) > ComParseInt(toRow02)){
                		ComShowMessage(ComGetMsg('COM12114','period.')); // Please check {?msg1}
                		return false;
                	}
        		}
        	}
        	
        	sheetObj.Redraw = false;
	        ComOpenWait(true);
	        formObj.f_cmd.value = MULTI;	        
	        sheetObj.DoSave("ESM_MAS_0190GS.do", masFormQueryString(formObj), -1, true);	        
	        ComOpenWait(false);
	        sheetObj.Redraw = true;
	        
	        sheetObj.Redraw = false;                           
            ComOpenWait(true);
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_MAS_0190GS.do", masFormQueryString(formObj));                                                
            ComOpenWait(false);
            sheetObj.Redraw = true;
        	
            break;
                   
        case IBINSERT:      // 입력        	
        	if(sheetObj.rowCount == 0){        		
        		var inRow = sheetObj.DataInsert();
        		sheetObj.CellValue2(inRow, "stnd_cost_cd") = "53101000";
        		sheetObj.CellValue2(inRow, "stnd_cost_nm") = "Port Expense";
            	sheetObj.CellValue2(inRow, "vsl_cd")       = "ACCD";
            	sheetObj.CellValue2(inRow, "delt_flg")     = "N";
        	} else {
        		var inRow = sheetObj.DataInsert();
        		sheetObj.CellValue2(inRow, "stnd_cost_cd") = sheetObj.CellValue(inRow-1, "stnd_cost_cd");
        		sheetObj.CellValue2(inRow, "stnd_cost_nm") = sheetObj.CellValue(inRow-1, "stnd_cost_nm");
            	sheetObj.CellValue2(inRow, "vsl_cd") = sheetObj.CellValue(inRow-1, "vsl_cd");
            	sheetObj.CellValue2(inRow, "delt_flg") = sheetObj.CellValue(inRow-1, "delt_flg");
        	}            
          //sheetObj.DataCopy(); //행복사
		  //sheetObj.DataInsert(-1); // 마지막행에 행삽입
		            
            break;
            
        case IBDELETE: // 삭제
        	var iCheckRow  = sheetObj.FindCheckedRow("sel_chk"); // 체크된 행번호를 "|"로 연결하여 반환한다        	
        	var arrRow = iCheckRow.split("|");
        	if (iCheckRow != ""){
        		if (ComShowConfirm(ComGetMsg('MAS10028'))) {        		
        			for(var i=arrRow.length-2;i>-1;i--){
     	    			//alert(i);
    	    			//alert(arrRow[i]);
     	    			sheetObj.RowHidden(arrRow[i]) = true;
     	    		}
                	sheetObj.Redraw = false;
        	        ComOpenWait(true);
        	        formObj.f_cmd.value = MULTI01;	        
        	        sheetObj.DoSave("ESM_MAS_0190GS.do", masFormQueryString(formObj), -1, false);	        
        	        ComOpenWait(false);
        	        sheetObj.Redraw = true;
        	            	        
                    sheetObj.Redraw = false;                           
                    ComOpenWait(true);
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("ESM_MAS_0190GS.do", masFormQueryString(formObj));                                                
                    ComOpenWait(false);
                    sheetObj.Redraw = true;
            	} else {
            		return;
            	}        		
        	} else {        		
        		ComShowMessage(ComGetMsg('MAS10026','row')); // Please select {?msg1}.
        	}
            break;

        case IBCOPYROW:     //행 복사
            sheetObj.DataCopy();
            break;

        case IBDOWNEXCEL:       //엑셀 다운로드
            //sheetObj.SpeedDown2Excel(-1);
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
        with(formObj){
            if (f_yearweek.value == "") {
                /*if(f_yrtype[0].checked){
                    // [COM12114] : YYYY-MM 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : YYYY-WW 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }*/
            }
            if(f_yearweek.value.replace("-","").length != 6) {
                /*if(f_yrtype[0].checked){
                    // [COM12114] : YYYY-MM 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                    f_yearweek.focus();
                    return false;
                }
                else{
                    // [COM12114] : YYYY-WW 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114","YYYY-WW",""));
                    f_yearweek.focus();
                    return false;
                }*/
            }
            //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
            //if(!ComAddSeparator(f_yearweek)) return false;

            /*if(f_yrtype[0].checked == true){
               //if(!isValidYYYYMM(f_yearweek, false, '-', false)) return false;
               //if(ComIsDate(f_yearweek)) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "ym")) return false;
            }else{
               //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
              //if(ComIsDate(f_yearweek, "yw")) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            }*/

//            if (sAction == IBCREATE){
//            	/*if(f_yrtype[1].checked == true) { //Week Option이 켜져 있으면
//            		ComShowCodeMessage('MAS10003','Creation','YYYY-MM');
//            		return false;
//            	}*/
//            } else if (sAction == IBSEARCH_ASYNC02){
//            	/*if(ComIsNull(formObj.f_sweek)) {
//      				ComShowMessage(ComGetMsg('MAS10002', 'Start Month'));
//      	            ComSetFocus(formObj.f_sweek);
//    				return false;
//    			}*/            	
//            }
        }
        return true;
    }

    function ComAddSeparator_Local(obj, sFormat) {
        try {
            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    