/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_MAS_0337.js
*@FileTitle : G&A Expense Assignment
*Open Issues :
*@LastModifyDate : 2017-06-12
*@LastModifier : SONG Min Seok
*@LastVersion :
*  2017-06-12 SONG Min Seok
*  1.0 최초 생성!
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0337 : ESM_MAS_0337 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0337() {
    this.processButtonClick    = processButtonClick   ;
    this.ComAddSeparator_Local = ComAddSeparator_Local;
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd   ;    
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateForm          = validateForm         ;
    this.setPeriod             = setPeriod;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
                	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
                	                     
                    break;

                case "btn_Downexcel":
                	doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
                	                      
                    break;
                    
                case "btn_Save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                                          
                    break;
                    
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObjects[1], formObject, IBLOADEXCEL);
                                          
                    break;
    			   
    		    case "btn_Creation":
    		    	doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
    		    	    		    	
    		        break;
 
                    
 

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111","",""));
            } else {
                ComShowMessage(e);
            }
        }
    }


    function ComAddSeparator_Local(obj, sFormat) {
        try {
            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
        } catch(err) { ComFuncErrMsg(err.message); }
    }

 
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
	function loadPage(header, headerNM) {		
		loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		for(i=0;i<sheetObjects.length;i++) {
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	
		loadingMode = false;
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
    function initSheet(sheetObj,sheetNo, header, headerNM) {
        var cnt = 0;
        
        if(sheetNo == 1 || sheetNo == 2) { // sheet 1 과 2는 동일해야해서 이렇게 함.(View 용과 Load 용 1쌍)
            with (sheetObj) {
                SheetWidth = mainTable.clientWidth;
                //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(2 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(21, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle0  = "STS|YYYYMM|Week|Trade|Sub\nTrade|Rev Lane|IOC||||VVD|H/B|Office|Quota|Quota Ratio|Quota Ratio|G&A Expense Assignment|G&A Expense Assignment|G&A Expense Assignment|G&A Expense Assignment|";
                var HeadTitle1  = "STS|YYYYMM|Week|Trade|Sub\nTrade|Rev Lane|IOC||||VVD|H/B|Office|Quota|HO Expense|Own Expense|HO Expense\n(A)|Own Expense\n(B)|G&A Expense\n(A + B)|G&A Expense\n(Adjusted)|";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, true);
                
                
                //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,     cnt++,  dtStatus,      50,      daCenter,   true,       "ibflag");
                InitDataProperty(0,     cnt++,  dtData,        60,      daCenter,   true,       "cost_yrmon",       false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        50,      daCenter,   true,       "cost_wk",          false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        60,      daCenter,   true,       "trd_cd",           false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        60,      daCenter,   true,       "sub_trd_cd",       false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        60,      daCenter,   true,       "rlane_cd",         false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        50,      daCenter,   true,       "ioc_cd",           false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtHidden,      60,      daCenter,   true,       "vsl_cd",           false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtHidden,      60,      daCenter,   true,       "skd_voy_no",       false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtHidden,      60,      daCenter,   true,       "dir_cd",           false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        80,      daCenter,   true,       "vvd",              false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        30,      daCenter,   true,       "hul_bnd_cd",       false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        60,      daCenter,   true,       "ofc_cd",           false,     "",    dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        60,      daRight,    true,       "lod_qta",          false,     "",    dfInteger,    0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,       "ho_qta_rto",       false,     "",    dfFloat,      5,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,       "own_qta_rto",      false,     "",    dfFloat,      5,  false,  false);
                InitDataProperty(0,     cnt++,  dtAutoSum,     100,     daRight,    true,       "ho_expn_amt",      false,     "",    dfFloat,      2,  false,  false);
                InitDataProperty(0,     cnt++,  dtAutoSum,     100,     daRight,    true,       "own_expn_amt",     false,     "",    dfFloat,      2,  false,  false);
                InitDataProperty(0,     cnt++,  dtAutoSum,     100,     daRight,    true,       "expn_ttl",         false,     "",    dfFloat,      2,  false,  false);
                InitDataProperty(0,     cnt++,  dtAutoSum,     100,     daRight,    true,       "adj_expn_ttl",     false,     "",    dfFloat,      2,  true,   true );
                InitDataProperty(0,     cnt++,  dtHidden,      60,      daCenter,   true,       "compare_key",      false,     "",    dfNone,       0,  false,  false);

                CountPosition  = 0 ;
                sheetObj.style.height = 400;    //style.height = GetSheetHeight(16) ;                    
                //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                EditableColorDiff = true;
                WaitImageVisible = false;
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
     *
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	sheetObj.SumText(0,1) = "";
        //sheetObj.SumText(0,"trd_cd") = "TOTAL";
        sheetObj.CellAlign(sheetObj.LastRow,"trd_cd") = daCenter;
//        sheetObj.SumText(0,1) = "TOTAL";
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {        
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	        case IBCLEAR:          //초기화
	            formObj.f_mon.value = ComGetNowInfo("mm").lpad(2, "0");

                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = INIT;
                
                var sXml = sheetObj.GetSearchXml("ESM_MAS_0337GS.do", masFormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                
                formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
                formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
                formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
                
                document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
                
                ComOpenWait(false);
                break;
                
            case IBSEARCH:      //조회
                //ComAddSeparator_Local(formObj.f_cost_yrmon, "-");
                if(validateForm(sheetObj,formObj,sAction)){
                	// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCHLIST01;                    
                    
                    sheetObj.DoSearch("ESM_MAS_0337GS.do", masFormQueryString(formObj));

                    ComOpenWait(false);
                }
                break;
                
            case IBSAVE:      //저장
                if(validateForm(sheetObj,formObj,sAction)){
                    // 업무처리중 버튼사용 금지 처리
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    formObj.f_cmd.value = MULTI01;                    
                    
                    sheetObj.DoSave("ESM_MAS_0337GS.do", masFormQueryString(formObj));

                    ComOpenWait(false);
                }
                break;
 

            case IBDOWNEXCEL:        //엑셀 다운로드
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;
				
 
               
           case IBLOADEXCEL:   // 엑셀로드 (sheetObjects[1]  ---> sheetObjects[0] 으로)
               var sheet1 = sheetObjects[0];
               var sheet2 = sheetObjects[1];
               var sheet1_rowCount = sheet1.SearchRows;
               var sheet2_rowCount = 0;
               
               if(sheet1_rowCount == 0) {
                   alert("Please Retrieve first.\nIf not exists data, click the Creation button.");
                   return false;
               }
               
               sheet1.WaitImageVisible = false;
               ComOpenWait(true);
               sheet2.RemoveAll();
               sheet2.LoadExcel(-1, 1, "", -1, -1, "",false);
               
               sheet2_rowCount = sheet2.RowCount + 1;
               
               if(sheet2_rowCount - sheet2.HeaderRows <= 0) {
                   alert("There is no data in loaded excel file.");
                   ComOpenWait(false);
                   return false;
               }

               for(var sheet2_row = sheet2.HeaderRows; sheet2_row <= sheet2_rowCount; sheet2_row++) {
                   var compare_key = "" 
                                   + sheet2.CellValue(sheet2_row, "trd_cd") 
                                   + sheet2.CellValue(sheet2_row, "rlane_cd")
                                   + sheet2.CellValue(sheet2_row, "ioc_cd")
                                   + sheet2.CellValue(sheet2_row, "vvd")
                                   + sheet2.CellValue(sheet2_row, "ofc_cd");
                                      
                   var sheet1_row = sheet1.FindText("compare_key", compare_key);
                   
                   if(sheet1_row > -1) {
                       var sheet2_amount = sheet2.CellValue(sheet2_row, "adj_expn_ttl");
                       sheet1.CellValue(sheet1_row, "adj_expn_ttl") = sheet2_amount;
                   }
               }
               
               ComOpenWait(false);
               
               if(sheet1.RowCount("U") == 0) {
                   alert("No data changed.\n\n"
                           + "1. Excel file data does not match retrieved data.\n   (TRD/RLANE/IOC/VVD/OFC)\n"
                           + "2. Wrong format file.\n"
                           + "3. G&A Expense(Adjusted) column doesn't changed in excel file.");
                   return false;
               }
               
               break;
				
           case IBCREATE:
 
        	   	
	           	if(!validateForm(sheetObj,formObj,sAction)) {
	               	return false;
	            }	           	            	
	           	if (!ComShowCodeConfirm("MAS10020")) {
	           		return false;
	           	}           	
                ComOpenWait(true);
                sheetObj.Redraw = false;                
                formObj.f_cmd.value = COMMAND01;                
                //alert(FormQueryString(formObj));                
                sheetObj.DoSearch("ESM_MAS_0337GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                                 
                sheetObj.Redraw = true;
                break;
 
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (f_year.value == "") {
                // [COM12114] : Year 를(을) 확인하세요.
                ComShowMessage(ComGetMsg("COM12114", "Year"));
                f_year.focus();
                return false;
            }
            if(formObj.f_chkprd[0].checked){


                if (f_fm_wk.value != "" && f_to_wk.value == ""){
                    // [COM12114] : Week 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114", "Week"));
                    f_to_wk.focus();
                    return false;
                }
                if (f_fm_wk.value == "" && f_to_wk.value != ""){
                    // [COM12114] : Week 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114", "Week"));
                    f_fm_wk.focus();
                    return false;
                }

                if (f_fm_wk.value == "" && f_to_wk.value == ""){
                    // [COM12114] : Week 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114", "Week"));
                    f_fm_wk.focus();
                    return false;
                }

                if (f_fm_wk.value > f_to_wk.value) {
                    // [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
                    ComShowMessage(ComGetMsg("MAS10011","Week","From","To"));
                    f_to_wk.focus();
                    return false;
                }

                if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
                if(!ComChkObjValid(f_sls_mon, null, null, "ym")) return false;
                if(!ComChkObjValid(f_fm_wk, null, null, "yw")) return false;
                if(!ComChkObjValid(f_to_wk, null, null, "yw")) return false;
            }else{
                if (f_mon.value == "") {
                    // [COM12114] : Month 를(을) 확인하세요.
                    ComShowMessage(ComGetMsg("COM12114", "Month"));
                    f_mon.focus();
                    return false;
                }
                if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
                if(!ComChkObjValid(f_mon, null, null, "ym")) return false;
            }
            
            if(sAction == IBCREATE) {
                if(formObj.f_chkprd[0].checked) {
                    ComShowMessage(ComGetMsg("MAS10026", "Month radio button for Creation."));
                    return false;
                }
            }
        }

        return true;
    }
    
    /**
     * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
     */
    function setPeriod(obj) {
         ComMasSetPeriod4(obj);
    }
    
    
