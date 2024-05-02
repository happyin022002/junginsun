/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0041.js
*@FileTitle : Bunker Fee (PA)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2011.03.23 최성민 [CHM-201109616-01] * Bunker Fee (PA)화면에서 사용하는 COA_BNK_TRF 테이블에 COST_WK 컬럼이 추가
*                                    * Load Excel, Create 기능 추가
* 2011.04.18 최윤성 [CHM-201110236-01] Bunker Fee 메뉴 컬럼 추가
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
=========================================================
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0041 : ESM_COA_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0041() {
    this.processButtonClick    = processButtonClick;  
    this.setYrWk               = setYrWk            ;
    this.setYrMon              = setYrMon          ;
    this.fnYearWeekSet         = fnYearWeekSet     ;
    this.setPeriod             = setPeriod         ;
    this.loadPage              = loadPage          ;
    this.initSheet             = initSheet         ;
    this.setSheetObject        = setSheetObject    ;
    this.sheet1_OnChange       = sheet1_OnChange   ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd;
    this.doActionIBSheet       = doActionIBSheet   ;
    this.validateForm          = validateForm      ;
    this.isValidSlane          = isValidSlane      ;
    this.isValidRLane          = isValidRLane      ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

var EXCEL_LOAD_FLG = false;	//엑셀 로드 실행체크
var sRow = 0;

/** 
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  
 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
        
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                
                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                
                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                
                case "btn_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                    
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                
                case "btng_copyfrompast":
                    break;
                                        
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;

                case "btn_Create":
                    doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;
        
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
        
    }

    /**
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013', '25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */    
    function setYrWk(fYear,prevWeek){
    	var formObj = document.form;
    	with(formObj){
    		var nowYear = fYear;
            f_yearweek.value = nowYear+prevWeek;	
            //if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            //if(!ComAddSeparator(f_yearweek)) return false;
            if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
    		f_yearweek.select();
    		// 기간 표시     		
            setPeriod(f_yearweek);    		
    	}

        fnYearWeekSet(document.getElementById("f_yearweek"));
    }	
    
    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */        
    function setYrMon(){
    	var formObj = document.form;
    	with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm"); 
            if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
    		var nowYrMon = nowYear + nowMon;
            f_yearweek.value = nowYrMon;	
    		//isValidYYYYMM(f_yearweek,true,'-',true);
            if(!ComAddSeparator(f_yearweek)) return false;
    		f_yearweek.select();
    		// 기간 표시 
            setPeriod(f_yearweek);
    	}

        fnYearWeekSet(document.getElementById("f_yearweek"));
    }	

    function fnYearWeekSet(obj){
        if ( document.form.f_yrtype[0].checked ) {
            obj.value = ComGetMaskedValue(obj.value,"ym");
        } else {
            obj.value = ComGetMaskedValue(obj.value,"yw");
        }

        setPeriod(obj);

    }

    /**
	 * month, week가 변경되었을때 Period를 변경한다.
	 */
	function setPeriod(obj){	
        ComCoaSetPeriod2(obj);
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
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
     * IBCOMBO를 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @author 최성민
     * @version 2011.03.22
     */ 
	function initCombo(comboObj, comboId) {
     	 switch(comboObj.id) {
 	        case "f_selslane":
 	            with(comboObj) {
 	            	DropHeight = 300;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	MaxLength = 3;
 	            	UseAutoComplete = false;
 	            	ValidChar(2, 1);	//영문대문자+숫자
 	            	Index = 0;
 	            }
 	            break;
 	        case "f_selrlane":
 	            with(comboObj) {
 	            	DropHeight = 300;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	MaxLength = 5;
 	            	UseAutoComplete = false;
 	            	ValidChar(2, 1);	//영문대문자+숫자
 	            	Index = 0;
 	            }
 	            break;
 	       case "f_selclass":
	            with(comboObj) {
            		DropHeight = 300;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 5;
	            	UseAutoComplete = false;
	            	ValidChar(2, 1);	//영문대문자+숫자
	            	Index = 0;
	            }
	            break;	
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
            case 1:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;
                //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(2 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(13, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle0  = "STS|YYYY-MM|Week|S. Lane|R. Lane|Class|Dir.|Trade Dir.|Vessel code|FO (Total Days Basis)|FO (Total Days Basis)|DO (Total Days Basis)|DO (Total Days Basis)";
                    var HeadTitle1  = "STS|YYYY-MM|Week|S. Lane|R. Lane|Class|Dir.|Trade Dir.|Vessel code|Cons.|Unit Cost|Cons.|Unit Cost";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);
                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtStatus, 		30,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,       "cost_yrmon",       true,      "",         dfDateYm,       0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,       "cost_wk",        	true,      "",         dfNone,         0,  false,  true, 2, true);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,       "slan_cd",          true,      "",         dfNone,     0,  false,  true, 3, true);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,       "rlane_cd",         true,      "",         dfNone,     0,  false,  true, 5, true);
                    InitDataProperty(0,     cnt++,  dtCombo,        60,     daCenter,   true,       "vsl_clss_capa",    true,      "",         dfNone,         0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtCombo,        40,     daCenter,   true,       "slan_dir_cd",      true,      "",         dfNone,         0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtCombo,        75,     daCenter,   true,       "hul_bnd_cd",      false,      "",         dfNone,         0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,       "vsl_info",		    false,      "",         dfNone,         0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,      85,     daRight,    true,       "foil_csm",         false,      "",         dfFloatOrg,  2,  true,   true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,      85,     daRight,    true,       "foil_uc_amt",      false,      "",         dfFloatOrg,  6,  true,   true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,      85,     daRight,    true,       "doil_csm",         false,      "",         dfFloatOrg,  2,  true,   true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,      50,     daRight,    true,       "doil_uc_amt",      false,      "",         dfFloatOrg,  6,  true,   true);
                    
                    RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);
                    InitDataValid(0, "cost_wk", vtNumericOnly);
                    InitDataValid(0, "slan_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "rlane_cd", vtEngUpOther, "0123456789");

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(13) ;
                    //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                    EditableColorDiff = true;
                    WaitImageVisible = false;
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

    /**
     * S.Lane code의 유효성 체크
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        if(sheetObj.ColSavename(col) == "slan_cd"){
            if(sheetObj.CellValue(row,"slan_cd") != ""){
           	 	var param = "f_cmd="+SEARCH02;
         		param = param + "&f_slan_cd="+value;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0041GS.do", param);
				var arrXml = sXml.split("|$$|");
				isValidSlane(row,ComCoaGetEtcData(arrXml[0], "rtnValue"));
            }
        } else if(sheetObj.ColSavename(col) == "rlane_cd"){
            if(sheetObj.CellValue(row, "rlane_cd") != ""){
            	var param = "f_cmd="+SEARCH03;
         		param = param + "&f_rlane_cd="+value;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0041GS.do", param);
				var arrXml = sXml.split("|$$|");
				isValidRLane(row,ComCoaGetEtcData(arrXml[0], "rtnValue"));
            }
        }
    }

    function sheet1_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"cost_yrmon") = "TOTAL";        
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {        
			case IBCLEAR:          //조회
				//ComOpenWait(true);
				var sXml = document.form.sXml.value;
				var arrXml = sXml.split("|$$|");
				fYear = ComGetEtcData(arrXml[0], "fYear"); 
				
				if (arrXml.length > 0) {
					ComXml2ComboItem(arrXml[0], formObj.f_selslane, "code", "name");
					formObj.f_yrtype[1].onclick = function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"), ComGetEtcData(arrXml[0],"prevWeek"))};
				}
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_selclass, "code", "name");
				if (arrXml.length > 3)
					ComCoaSetIBCombo(sheetObj, arrXml[3], "slan_dir_cd", true, 0);
				if (arrXml.length > 4)
					ComCoaSetIBCombo(sheetObj, arrXml[4], "vsl_clss_capa", true, 0);				
				document.form.sXml.value = "";
				setYrMon();  // 월/주 입력 창에 금월 셋팅
				break;

			case IBSEARCH:              //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                if(formObj.f_yrtype[0].checked) {
                	ComAddSeparator(formObj.f_yearweek, "ym");
                } else {
                	ComAddSeparator(formObj.f_yearweek, "yw");
                }
                
                formObj.f_cmd.value = SEARCHLIST01; 
                sheetObj.DoSearch4Post("ESM_COA_0041GS.do", coaFormQueryString(formObj));
                
  	            initVariable(); //초기값 세팅
                break;
 
            case IBSAVE:                //저장
                if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }
                
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                if(formObj.f_yrtype[0].checked) {
                	ComAddSeparator(formObj.f_yearweek, "ym");
                } else {
                	ComAddSeparator(formObj.f_yearweek, "yw");
                }
                sheetObj.DoSave("ESM_COA_0041GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
                
                //Load Excel 사용시
                if(EXCEL_LOAD_FLG) {
                	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
  						initVariable(); //저장이 완료되면 전역변수 초기화
  					}
                }
                break;
            
            case IBINSERT:      // 입력
                //sheetObj.DataCopy();  //행 복사
                sheetObj.DataInsert();
                sheetObj.SumText(0,1) = "";
                sheetObj.SumText(0,2) = "Total";
                break;

            case IBDELETE:      // 입력
            	sheetObj.RowDelete(sheetObj.SelectRow, false);
                break;
            
            case IBDOWNEXCEL:           //엑셀 다운로드
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
             	
        	case IBLOADEXCEL:
	        	ComOpenWait(true);
	        	sheetObj.RemoveAll();	        	
	        	EXCEL_LOAD_FLG = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);	     
	        	
	        	if(EXCEL_LOAD_FLG) {
	        		ComShowObject(document.getElementById("btn_Rowdelete"),  true);
	        	}
				break;	

            case IBCREATE:
            	if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }
            	            	
            	if (!ComShowCodeConfirm("COA10020")) {
            		return false;
            	}
            	
            	initVariable(); //초기값 세팅
                ComOpenWait(true);
                sheetObj.Redraw = false;
                
                formObj.f_cmd.value = COMMAND02;                
                sheetObj.DoSearch("ESM_COA_0041GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                 
                sheetObj.Redraw = true;
                break;    
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//공통 체크	       
    	with(formObj){        	
            if(f_yrtype[0].checked) {
            	if(!ComIsDate(f_yearweek, "ym")){
            		ComShowMessage(ComGetMsg("COM12114", "Month"));
    				f_yearweek.focus();
    				return false;
            	}
            } else if(f_yrtype[1].checked) {
            	if(!ComIsDate(f_yearweek, "yw")){
            		ComShowMessage(ComGetMsg("COM12114", "Week"));
    				f_yearweek.focus();
    				return false;
            	}
            }
        } 
        
    	//버튼별 체크
        switch (sAction) {    			
	  		case IBSAVE:
	  			if(EXCEL_LOAD_FLG) {
//	  				if(!checkValidationAllData(sheetObj)) {  					
//	  					return false;
//	  				}
	  			}    	  			
				break;
	  	
	  		case IBCREATE:
	  			if ( formObj.f_yrtype[0].checked ) {
	  				ComShowCodeMessage('COA10003','Creation','YYYY-WW');
	  				return false;
	  			}
				break;
				
	  		case IBDELETE:
	  			if(sheetObj.RowCount < 1) {
	  				return false;
	  			}
				break;
        }
        
        return true;
    }
    
    
   /**
 	* 업로드한 데이터를 저장할때 체크하는 function<br>
 	* <br><b>Example :</b>
 	* <pre>
 	* 
 	* </pre>
 	* @param {ibsheet} sheetObj 필수 IBSheet Object
 	* @return 없음
 	* @author 최성민
 	* @version 2011.03.22
 	*/
 	function checkValidationAllData(sheetObj) {
 		var formObj = document.form;
 		var check = 0;

		// 오류셀 색지정
		var color = sheetObj.RgbColor(255, 255, 0); // 노랑
		
		ComOpenWait(true);
		// 오류색 초기화
		for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
			if(color == sheetObj.RowBackColor(i)) {
				sheetObj.RowBackColor(i) = 0;
			}
		}

		
		formObj.f_cmd.value = COMMAND01;
		var sParam = FormQueryString(formObj);
		var sParamSheet = sheetObj.GetSaveString();
			
		if (sParamSheet != "") {
			sParam = sParam + "&" + sParamSheet;
		} else {
			return false;
		}

		var sXml = sheetObj.GetSearchXml("ESM_COA_0041GS.do", sParam);
		var errData = ComGetEtcData(sXml, "key"); //ROW INDEX
		alert(errData);
		if(errData != "") {
			var errArr = errData.split("|");
			
			for (var i=0; i<errArr.length; i++) { 
        		sheetObj.RowBackColor(parseInt(errArr[i]) + sheetObj.HeaderRows) = color;
        		check ++;
        	}
			
			//focus 이동
			sheetObj.SelectCell(parseInt(errArr[0]) + sheetObj.HeaderRows, 1, false);
		}
		
 		if(check > 0) {
 			ComShowCodeMessage('COA10015', 'month VVD, vessel class');
 			return false;
 		} else {
 			return true;
 		}
 	}
 	
	
	/**
	 * 전역변수를 초기화 하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		initVariable();
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2011.02.28
	 */
	function initVariable() {
		EXCEL_LOAD_FLG = false;		
		ComShowObject(document.getElementById("btn_Rowdelete"),  false);
	}
        
    /**
     * S.Lane code의 유효성 반환 (ESM_COA_5128.jsp에서 호출)
     */
    function isValidSlane(sRow,result){
        var sheetObj = sheetObjects[0];
        
        if(result == "false"){
            ComShowMessage(ComGetMsg("COM12114","S.Lane",""));
            sheetObj.CellValue(sRow, "slan_cd") = "";
            sheetObj.SelectCell(sRow, "slan_cd");
        }
    }
    
    /**
     * RLane code의 유효성 반환 (ESM_COA_5125.jsp에서 호출)
     */
    function isValidRLane(sRow,result){
        var sheetObj = sheetObjects[0];
        
        if(result == "false"){
            ComShowMessage(ComGetMsg("COM12114","RLane",""));
            sheetObj.CellValue(sRow, "rlane_cd") = "";
            sheetObj.SelectCell(sRow, "rlane_cd");
        }
    }
