/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0336.js
*@FileTitle : G&A Expense Creation by Office
*Open Issues :
*@LastModifyDate : 2017-06-12
*@LastModifier : SONG Min Seok
*@LastVersion :
*  2017-06-12 SONG Min Seok
*  1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0336 : ESM_MAS_0336 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0336() {
    this.processButtonClick    = processButtonClick   ;
    this.setYrWk               = setYrWk              ;
    this.setYrMon              = setYrMon             ;
    this.fnYearWeekSet         = fnYearWeekSet        ;
    this.ComAddSeparator_Local = ComAddSeparator_Local;
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd   ;    
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateForm          = validateForm         ;
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

 
    			   
    		     case "btn_Creation":
    		    	doActionIBSheet(sheetObjects[0], formObject, IBCREATE);
    		    	    		    	
    		        break;
                 case "btn_Save":
                     doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                                         
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
            f_cost_yrmon.value = nowYear+prevWeek;
            if(!ComChkObjValid(f_cost_yrmon, null, null, "yw")) return false;
 
        }
        fnYearWeekSet(document.getElementById("f_cost_yrmon"));
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
            f_cost_yrmon.value = nowYrMon;
            if(!ComAddSeparator(f_cost_yrmon)) return false;
      
        }
        fnYearWeekSet(document.getElementById("f_cost_yrmon"));
        
    }

    function fnYearWeekSet(obj){        
        obj.value = ComGetMaskedValue(obj.value,"ym");
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
		
		/*for (i=0;i<sheetObjects.length;i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1, ComGetEtcData(arrXml[0],"headerCD"), ComGetEtcData(arrXml[0],"headerNM"));
			ComEndConfigSheet(sheetObjects[i]);
		}*/		
		for(i=0;i<sheetObjects.length;i++){
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
        
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;
                    //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(2 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(8, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle0  = "STS|YYYY-MM|Office|GEM Budget|GEM Budget|GEM Budget|GEM Budget|G&A Expense";
                    var HeadTitle1  = "STS|YYYY-MM|Office|CUR|LCL Amount|Ex.rate|USD Amount|(USD)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHiddenStatus, 60,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "cost_yrmon",       false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        80,      daCenter,   true,       "ofc_cd",           false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,       "locl_curr_cd",		    false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        150,      daRight,   true,       "bud_locl_amt",          	false,     "",    dfInteger,   	0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        150,     daRight,   true,       "usd_locl_xch_rt",  false,     "",    dfFloat,   	0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,     150,     daRight,    true,       "bud_usd_amt",     	false,     "",    dfInteger,    0,  false,  true);
                    InitDataProperty(0,     cnt++,  dtAutoSum,     150,     daRight,    true,       "expn_usd_amt",         false,     "",    dfInteger,    0,  true,  true);
                    
                    CountPosition  = 0 ;
                    sheetObj.style.height = 400;    //style.height = GetSheetHeight(16) ;                    
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
     *
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	sheetObj.SumText(0,1) = "";
        sheetObj.SumText(0,"trd_cd") = "TOTAL";
        sheetObj.CellAlign(sheetObj.LastRow,"trd_cd") = daCenter;
//        sheetObj.SumText(0,1) = "TOTAL";
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {        
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	        case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0336GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					for (i=0;i<sheetObjects.length;i++) {
						ComConfigSheet(sheetObjects[i]);
						initSheet(sheetObjects[i],i+1, ComGetEtcData(arrXml[0],"headerCD"), ComGetEtcData(arrXml[0],"headerNM"));
						ComEndConfigSheet(sheetObjects[i]);
					}
					//ComSetObjValue(formObj.f_header, ComGetEtcData(arrXml[0],"headerCD"));
					//ComXml2ComboItem(arrXml[0], formObj.f_selvessel, "code", "name");
					//formObj.f_yrtype[1].onclick = function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"), ComGetEtcData(arrXml[0],"prevWeek"))};
					function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"), ComGetEtcData(arrXml[0],"prevWeek"))};
				}
 
		
		        setYrMon();  // 월/주 입력 창에 금월 셋팅
 				
		        ComOpenWait(false);
				break;	

            case IBSEARCH:      //조회
                //ComAddSeparator_Local(formObj.f_cost_yrmon, "-");
                if(validateForm(sheetObj,formObj,sAction)){
                	// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCHLIST01;                    
                    
                    sheetObj.DoSearch("ESM_MAS_0336GS.do", masFormQueryString(formObj));

                    ComOpenWait(false);
                }
                break;

 

            case IBDOWNEXCEL:        //엑셀 다운로드
            	var sheetObj = "";            	
            	sheetObj = sheetObjects[0];
            	
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
				
 
               
           case IBLOADEXCEL:   // 엑셀로드
				ComAddSeparator_Local(formObj.f_cost_yrmon, "-");
				if(validateForm(sheetObj,formObj,sAction)){
					
					sheetObj.RemoveAll()
					//  sheetObj2.RemoveAll()
					sheetObj.LoadExcel(-1, 1, "", -1, -1, "",false);
                 
	  				//Data Load이후에 Sheet내에 YYYY-MM의 값을 조회 조건의 연월 값으로 다시 Setting한다  				
	                for (var i=1;i<=sheetObj.rowcount;i++){	                	
	              	   	sheetObj.CellValue(i,1) = formObj.f_cost_yrmon.value;
	                }
	                //YYYY-MM,VSL CODE,VSL CLASS값에 중복이 있는지 조회한다.
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
                sheetObj.DoSearch("ESM_MAS_0336GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                                 
                sheetObj.Redraw = true;
                break;
           case IBSAVE:        //저장
               ComAddSeparator_Local(formObj.f_cost_yrmon, "-");

               if(validateForm(sheetObj,formObj,sAction)){
                   // 업무처리중 버튼사용 금지 처리
                   sheetObj.WaitImageVisible = false;
                   ComOpenWait(true);
                   formObj.f_cmd.value = MULTI01;
                   
                   //sheetObj.DoSave("ESM_MAS_0336GS.do", FormQueryString(formObj), -1, true);                    
                   var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                   var sParam = FormQueryString(formObj);
                   sParam = sParam +"&"+sParamSheet1

                   var sXml = sheetObj.GetSaveXml("ESM_MAS_0336GS.do", sParam);    
                   
                    
                   var need_creation_flg = ComGetEtcData(sXml, "need_creation_flg");

                   if( need_creation_flg == "Y"){
                       //G&A Expense Assignment재생성하라는 경고
                   }
                   
                   doActionIBSheet(sheetObj,formObj,IBSEARCH); // 저장 후 재조회
                   ComOpenWait(false);
               }
               break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(f_cost_yrmon.value == "") {
                ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                f_cost_yrmon.focus();
                return false;
            }
            /*if(f_cost_yrmon.value.replace("-","").length != 6) {                
                ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
                f_cost_yrmon.focus();
                return false;
            }*/

            //if(!ComChkObjValid(f_cost_yrmon, null, null, "ym")) return false;
        }

        return true;
    }
    
    
