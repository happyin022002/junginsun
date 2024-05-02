/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_MAS_0339.js
*@FileTitle : Allocation by Agreement
*Open Issues :
*@LastModifyDate : 2017-07-25
*@LastModifier : SONG Min Seok
*@LastVersion :
*  2017-07-25 SONG Min Seok
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
 * @class ESM_MAS_0339 : ESM_MAS_0339 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0339() {
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
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle0  = "STS|From VVD|From VVD|From VVD|From VVD|From VVD|From VVD|From VVD|From VVD|From VVD|To VVD|To VVD|To VVD|To VVD|To VVD|To VVD|Agreement type|Agreement type|Agreement type|Allocation condition|Allocation condition|Allocation condition|Allocation condition|Allocation condition|Allocation condition|Allocation condition|Allocation condition|Allocation Result ( Apply to P/L )|Allocation Result ( Apply to P/L )|Allocation Result ( Apply to P/L )";
                    var HeadTitle1  = "STS|Month|Week|Trade|Lane|IOC|VVD|Unit Cost\nPer Slot|SML Sales AMT|Cht out AMT|Week|Trade|Lane|IOC|VVD|Status| Ratio|Fixed\nAmt|Over Used\nSlot|BSA| Ratio|Agreed Teu|Teu(T/S)|Over Teu|Over(%)|Over Slot\nPrice |Fixed\nAmount|Agreement\nexpense|Over used\nexpense|Fixed\nexpense";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    InitColumnInfo(headCount, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtStatus,      40,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,     cnt++,  dtData,        70,     daCenter,   true,      "cost_yrmon"           ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "fm_cost_wk"           ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "fm_trd_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "fm_rlane_cd"          ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "fm_ioc_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    //InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,      "fm_vsl_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    //InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,      "fm_skd_voy_no"        ,         false,     "",    dfNone,       0,  false,  false);
                    //InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,      "fm_dir_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        80,     daCenter,   true,      "fm_vvd"               ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        70,     daRight,   true,      "ts_uc_amt"            ,         false,     "",    dfFloat,       2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,   true,      "sml_sls_amt"          ,         false,     "",    dfFloat,       2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,   true,      "cht_out_amt"          ,         false,     "",    dfFloat,       2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "to_cost_wk"           ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "to_trd_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "to_rlane_cd"          ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "to_ioc_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    //InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,      "to_vsl_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    //InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,      "to_skd_voy_no"        ,         false,     "",    dfNone,       0,  false,  false);
                    //InitDataProperty(0,     cnt++,  dtData,        150,     daCenter,   true,      "to_dir_cd"            ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        80,     daCenter,   true,      "to_vvd"               ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "locl_ts_sts_cd"       ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "rat_flg"              ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        50,     daCenter,   true,      "fx_amt_flg"           ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        70,     daCenter,   true,      "ovr_usd_aloc_chg_flg" ,         false,     "",    dfNone,       0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "bsa"                  ,             false,     "",    dfInteger,    0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "rto"                  ,             false,     "",    dfInteger,    0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "agrd_teu"             ,             false,     "",    dfInteger,    0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "ts_teu"               ,             false,     "",    dfInteger,    0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "ovr_teu"              ,             false,     "",    dfInteger,    0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "ovr_usd_aloc_chg_rto" ,             false,     "",    dfFloat,    2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        60,      daRight,   true,      "ovr_slt_prc"          ,             false,     "",    dfFloat,    2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        80,      daRight,   true,      "bzc_aloc_fx_amt"      ,             false,     "",    dfInteger,    2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        80,      daRight,   true,      "agrd_expn_amt"        ,             false,     "",    dfFloat,    2,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        80,      daRight,   true,      "ovr_usd_amt"          ,             false,     "",    dfFloat,    2,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        80,      daRight,   true,      "fx_expn_amt"          ,             false,     "",    dfFloat,    2,  true,  true);

                    
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
    	var formObj = document.form;
        if (formObj.f_chkprd[0].checked){
        	formObj.fm_cost_wk.value=formObj.f_fm_wk.value ;
        	formObj.to_cost_wk.value=formObj.f_to_wk.value;
        }else{
            formObj.fm_cost_wk.value="" ;
            formObj.to_cost_wk.value="";
        }
    	formObj.cost_yrmon.value=formObj.f_year.value+formObj.f_mon.value;
  
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {        
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	        case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				initPeriod(formObj);
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0339GS.do", masFormQueryString(formObj));
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
 
		
		        ///setYrMon();  // 월/주 입력 창에 금월 셋팅
 				
		        ComOpenWait(false);
				break;	

            case IBSEARCH:      //조회
                //ComAddSeparator_Local(formObj.f_cost_yrmon, "-");
                if(validateForm(sheetObj,formObj,sAction)){
                	// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCH01;                    
                    
                    sheetObj.DoSearch("ESM_MAS_0339GS.do", masFormQueryString(formObj));

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
                //sheetObj.DoSearch("ESM_MAS_0339GS.do", FormQueryString(formObj));        
                
                sXml = sheetObj.GetSaveXml("ESM_MAS_0339GS.do", FormQueryString(formObj));
                //alert(sXml)
                if( ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
                    ComShowCodeMessage("MAS10006");
                }
  

                sheetObj.LoadSaveXml(sXml);
                
                
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                                 
                sheetObj.Redraw = true;
                break;
                
           case IBSAVE:      //저장
               if(validateForm(sheetObj,formObj,sAction)){
                   // 업무처리중 버튼사용 금지 처리
                   sheetObj.WaitImageVisible = false;
                   ComOpenWait(true);
                   formObj.f_cmd.value = MULTI01;                    
                   
                   sheetObj.DoSave("ESM_MAS_0339GS.do", masFormQueryString(formObj));

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
 

            if(!chkValidSearch()) {
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
    
    /**
     *  설  명 :  month, week가 변경되었을때 Period를 변경한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     setPeriod(obj)
     * </pre>
     * @param (object) obj - Document Object
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function setPeriod(obj){
        var formObj = document.form;
        if (formObj.f_chkprd[0].checked){
            formObj.fm_cost_wk.value=formObj.f_fm_wk.value ;
            formObj.to_cost_wk.value=formObj.f_to_wk.value;
        }else{
            formObj.fm_cost_wk.value="" ;
            formObj.to_cost_wk.value="";
        }
        formObj.cost_yrmon.value=formObj.f_year.value+formObj.f_mon.value;
         ComMasSetPeriod(obj);
    }
    
    function initPeriod(formObj){
        formObj.f_year.value = ComGetNowInfo("yy");
        formObj.f_mon.value = ComGetNowInfo("mm").lpad(2, "0");
 
         var sXml = document.form.sXml.value;
 
 
        var arrXml = sXml.split("|$$|");
 
        formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
 
    }

    
    /*
     * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
     */
    function changeCostYrmon(val){
        //if(val != '') fOfcLvlOnChange(document.form.f_ofc_lvl);
    }
    /**
     * 검색시 필수입력사항 체크  <br>
     * <br><b>Example :</b>
     * <pre>
     *     chkValidSearch()
     * </pre>
     * @returns 없음
     * @author 최성민
     * @version 2011.02.07
     */
    function chkValidSearch(){
        var formObj = document.form;
        var checkFlg = true;

        with(formObj){
            if (f_year.value == "") {
                ComShowCodeMessage("COM12114", "Year");
                f_year.focus();
                checkFlg = false;
            } else if(!ComIsDate(f_year, "yyyy")){
                ComShowCodeMessage("MAS10009", "Year", "YYYY");
                f_year.focus();
                checkFlg = false;
            } else if (f_chkprd[0].checked){
                if (f_fm_wk.value == ""){
                    ComShowCodeMessage("COM12114", "Week");
                    f_fm_wk.focus();
                    checkFlg = false;
                } else if (f_to_wk.value == ""){
                    ComShowCodeMessage("COM12114", "Week");
                    f_to_wk.focus();
                    checkFlg = false;
                } else if(!ComIsWeek(f_fm_wk)){
                    //Please enter Week correctly.\n\n Format : WW
                    ComShowCodeMessage('MAS10009', 'Week', 'WW');
                    f_fm_wk.focus();
                    checkFlg = false;
                } else if(!ComIsWeek(f_to_wk)) {
                    //Please enter Week correctly.\n\n Format : WW
                    ComShowCodeMessage('MAS10009', 'Week', 'WW');
                    f_to_wk.focus();
                    checkFlg = false;
                } else if (f_fm_wk.value > f_to_wk.value) {
                    //Month의 From는(은) To보다 적거나 같아야 합니다.
                    ComShowCodeMessage("MAS10011", "Week", "From", "To");
                    f_to_wk.focus();
                    checkFlg = false;
                }
            } else if (f_chkprd[1].checked){
                if (f_mon.value == ""){
                    ComShowCodeMessage("MAS12114", "Month")
                    f_mon.focus();
                    checkFlg = false;
                 
                } else if(!ComIsMonth(f_mon)){
                    //Please enter Month correctly.\n\n Format : MM
                    ComShowCodeMessage('MAS10009', 'Month', 'MM');
                    f_mon.focus();
                    checkFlg = false;
                } 
                formObj.f_fm_mon.value = f_mon.value;
                formObj.f_to_mon.value = f_mon.value;
                
            }
        }
        return checkFlg;
     }
    
