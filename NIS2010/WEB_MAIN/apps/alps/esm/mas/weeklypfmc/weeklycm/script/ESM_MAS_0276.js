/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0276.js
*@FileTitle : DEM/DET Cost Report by BKG
*Open Issues :
*@LastModifyDate : 2015-05-18
*@LastModifier : Young-Heon Lee
*@LastVersion :
*  2015-03-24 Je Ryang Yoo
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
	 * @class ESM_MAS_0276 : ESM_MAS_0276 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0276() {
	    this.processButtonClick    = processButtonClick;
	    this.loadPage              = loadPage          ;
	    this.initSheet             = initSheet         ;
	    this.initCombo 			   = initCombo;
	    this.initControl            = initControl;
	    this.setSheetObject        = setSheetObject    ;
	    this.doActionIBSheet       = doActionIBSheet   ;
	    this.validateForm          = validateForm      ;
	    this.setPeriod = setPeriod;
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
                	doActionIBSheet(sheetObject, formObject, IBSEARCH);                    
                    break;
                    
                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
     * Axon 이벤트를 처리하기 위하여 EVENT를 CATCH 한다. <br>
     */
    function initControl() {
        //Axon 이벤트 처리1. 이벤트 catch
        axon_event.addListenerForm('focus', 'obj_focus', form);
    }
    
    function chkWM(param1, param2) {
    	var formObj = document.form;
    	if (formObj.f_chkprd[1].checked) {
    		formObj.f_loc_cd.className = "input1";
    	} else if (formObj.f_chkprd[0].checked) {
    		formObj.f_loc_cd.className = "input";
    	}
    	if (param1 == 'W') {
            document.all.div_week.style.display = "inline";
            document.all.div_month.style.display = "none";
            setPeriod(document.form.f_to_wk);
        } else {
            document.all.div_week.style.display = "none";
            document.all.div_month.style.display = "inline";
            if (param2 == '1') {
                setPeriod(document.form.f_to_mon);
            } else {
                setPeriod(document.form.f_mon);
            }
        }
    }
    
    /**
     * OnFocus 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     */
   	function obj_focus() {
   		var formObj = document.form;
   		if (event.srcElement.name == "f_year" || event.srcElement.name == "f_fm_mon" || event.srcElement.name == "f_to_mon" || 
   				event.srcElement.name == "f_sls_mon" || event.srcElement.name == "f_fm_wk" || event.srcElement.name == "f_to_wk" || event.srcElement.name == "f_loc_cd") {
   	        formObj.f_bkg_no.className = "input";
   	        formObj.f_year.className = "input1";
   	        formObj.f_fm_mon.className = "input1";
   	        formObj.f_to_mon.className = "input1";
   	        formObj.f_fm_wk.className = "input1";
   	        formObj.f_to_wk.className = "input1";
   	    	if (formObj.f_chkprd[1].checked) {
   	    		formObj.f_loc_cd.className = "input1";
   	    	} else if (formObj.f_chkprd[0].checked) {
   	    		formObj.f_loc_cd.className = "input";
   	    	}
   		} else if (event.srcElement.name == "f_bkg_no") {
   			formObj.f_bkg_no.className = "input1";
   			formObj.f_year.className = "input";
   	        formObj.f_fm_mon.className = "input";
   	        formObj.f_to_mon.className = "input";
   	        formObj.f_fm_wk.className = "input";
   	        formObj.f_to_wk.className = "input";
   	        formObj.f_loc_cd.className = "input";
   	        formObj.f_year.value = "";
	        formObj.f_fm_mon.value = "";
	        formObj.f_to_mon.value = "";
	        formObj.f_fm_wk.value = "";
	        formObj.f_to_wk.value = "";
	        document.getElementById("div_period").innerHTML = "";
   		}
   	}

    /**
     * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
     */
    function setPeriod(obj) {
    	ComMasSetPeriod(obj);
    }
    
    function changeCostYrmon(val){
        //if(val != '') chgOffice(document.form.f_ofc_lvl);
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	loadingMode = true;      	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        
        for(k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],comboObjects[k].id);
    	}
        initControl();
        loadingMode = false;
    }
    
    /**
	 * 멀티콤보 항목을 설정한다.
	 */
 	function initCombo(comboObj, comboId) {
 		with (comboObj) {
 			switch(comboObj.id) {
	 			case "f_cntr_tpsz_cd":
					DropHeight = 430;
					SetColWidth("60");
					ValidChar(2, 1);	//영문대문자+숫자
					InsertItem(0, "All");
					MaxLength = 2;
					Index = 0;					
					break;
				
	 			case "f_status":
					InsertItem(0, "All", "");
					InsertItem(1, "Finished", "F");
					InsertItem(2, "Unfinished", "U");
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
            case 1:      //sheet1 init
                with (sheetObj) {
            		//style.height = 202;
                    SheetWidth = sheetTable.clientWidth; //전체 너비 설정
            		//SheetWidth = 400; //전체 너비 설정
                    
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(2, 1, 1, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle1  = "R.MONTH|Week|BKG|CNTR|TPSZ|S/C|RFA|From Yard|Bound|Revenue Date|Revenue Date|Staying Day|Staying Day|Staying Day|DEM/DET Revenue ($)|DEM/DET Revenue ($)|DEM/DET Revenue ($)|Cost within F/T ($)|Cost within F/T ($)|Cost within F/T ($)|Cost within F/T ($)|Cost within F/T ($)|Cost within F/T ($)|Cost within F/T ($)|Cost after F/T($)|Cost after F/T($)|Cost after F/T($)|Cost after F/T($)|Cost after F/T($)|Cost after F/T($)|Cost after F/T($)|Status|Status|Status|Status";
                    var HeadTitle2  = "R.MONTH|Week|BKG|CNTR|TPSZ|S/C|RFA|From Yard|Bound|FROM|TO|S.Day|F/T\nEnd|Over\nDay|Incurred|Billable|Invoiced|Marine\nStorage|Rail\nStorage|CNTR\nPDM|CHZ\nOn-Street|CHZ\nCommon|RF\nMonitor|Cost\nTTL|Marine\nStorage|Rail\nStorage|CNTR\nPDM|CHZ\nOn-Street|CHZ\nCommon|RF\nMonitor|Cost\nTTL|Storage|CNTR|Chassis|Total";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cost_yrmon",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daCenter,   true,    "cost_wk",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daCenter,   true,    "bkg_no",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cntr_no",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "cntr_tpsz_cd",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daCenter,   true,    "sc_no",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daCenter,   true,    "rfa_no",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "cntr_fm_nod_cd",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "io_bnd_cd",       		false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cntr_fm_dt",      false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cntr_to_dt",      false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "cntr_stay_dys", false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "ft_end_dt", false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "over_dys",       	false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         100,     daRight,   true,    "inc_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         100,     daRight,   true,    "bil_amt",       		false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         100,     daRight,   true,    "inv_chg_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "mrn_sto_wthn",       		false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "rail_sto_wthn",       	false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "cntr_eq_wthn",       		false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "chss_st_wthn",       	false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "chss_com_wthn",    false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "rf_hndl_wthn",     false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "cost_ttl_wthn",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "mrn_sto_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "rail_sto_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "cntr_eq_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "chss_st_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "chss_com_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "rf_hndl_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtAutoSum,         110,     daRight,   true,    "cost_ttl_aft",        false,   "",   dfFloatOrg,     2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "sto_status",       	false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "cntr_status",       	false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "chss_status",       	false,   "",   dfNone,     0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,    "ttl_status",       	false,   "",   dfNone,     0,  false,  false);
                    
                    sheetObj.ColHidden("mrn_sto_wthn") = true;
            		sheetObj.ColHidden("rail_sto_wthn") = true;	
            		sheetObj.ColHidden("cntr_eq_wthn") = true;
            		sheetObj.ColHidden("chss_st_wthn") = true;
            		sheetObj.ColHidden("chss_com_wthn") = true;
            		sheetObj.ColHidden("rf_hndl_wthn") = true;
            		sheetObj.ColHidden("mrn_sto_aft") = true;
            		sheetObj.ColHidden("rail_sto_aft") = true;	
            		sheetObj.ColHidden("cntr_eq_aft") = true;
            		sheetObj.ColHidden("chss_st_aft") = true;
            		sheetObj.ColHidden("chss_com_aft") = true;
            		sheetObj.ColHidden("rf_hndl_aft") = true;
            		sheetObj.ColHidden("sto_status") = true;
            		sheetObj.ColHidden("cntr_status") = true;
            		sheetObj.ColHidden("chss_status") = true;
                    
                    CountPosition = 0;
                    
                    sheetObj.style.height = 430; //sheetObj.GetSheetHeight(13);                    
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
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {        
			case IBCLEAR:          //조회
				formObj.f_year.value = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
				
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = document.form.sXml.value;
				var arrXml = sXml.split("|$$|");
				
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear");
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
		        
		        document.form.sXml.value="";
		        ComOpenWait(false);
		        
				break;

			case IBSEARCH:              //조회
				formObj.f_cmd.value = SEARCH;
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                sheetObj.Redraw = false;
                //alert(masFormQueryString(formObj));
                sheetObj.DoSearch("ESM_MAS_0276GS.do", masFormQueryString(formObj));
                sheetObj.Redraw = true;
                ComOpenWait(false);
                formObj.f_cmd.value = "";
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
        }
    }
    
    /**
     * 검색시 필수입력사항 체크  <br>
     * <br><b>Example :</b>
     * <pre>
     *     chkValidSearch()
     * </pre>
     */
	function chkValidSearch(){
		var formObj = document.form;
		var checkFlg = true;

 		with(formObj){
 			if (f_year.value == "") {
 				if (f_bkg_no.value == "") {
 					ComShowCodeMessage("COM12114", "Year");
 	 			    f_year.focus();
 	 			    checkFlg = false;
 				}
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
     			if (f_fm_mon.value == ""){
     				ComShowCodeMessage("MAS12114", "Month")
     			    f_fm_mon.focus();
     			    checkFlg = false;
     			} else if (f_to_mon.value == ""){
     				ComShowCodeMessage("MAS12114", "Month")
     			    f_to_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_fm_mon)){
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('MAS10009', 'Month', 'MM');
     				f_fm_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_to_mon)) {
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('MAS10009', 'Month', 'MM');
     				f_to_mon.focus();
     			    checkFlg = false;
     			} else if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("MAS10011", "Month", "From", "To");
     			    f_to_mon.focus();
     			    checkFlg = false;
     			}
 			}
 			
 			if (f_year.value != "") {
  				if (formObj.f_chkprd[1].checked && f_loc_cd.value == "" && f_cmd.value == SEARCH) {
  					ComShowCodeMessage("COM12114", "Location");
  	 				f_loc_cd.focus();
  	 				checkFlg = false;
  	 				f_cmd.value = SEARCH;
  				}
  			}
 		}
 		return checkFlg;
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//버튼별 체크
        switch (sAction) {
	        case IBSEARCH: // 조회
	        	if(!chkValidSearch()) {
	 				return false;
	 			}
				break;
        }
        
        return true;
    }
    
    function changeViewColumn() {
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	if (formObj.f_sheet_form[0].checked) {
    		sheetObj.ColHidden("mrn_sto_wthn") = true;
    		sheetObj.ColHidden("rail_sto_wthn") = true;	
    		sheetObj.ColHidden("cntr_eq_wthn") = true;
    		sheetObj.ColHidden("chss_st_wthn") = true;
    		sheetObj.ColHidden("chss_com_wthn") = true;
    		sheetObj.ColHidden("rf_hndl_wthn") = true;
    		sheetObj.ColHidden("mrn_sto_aft") = true;
    		sheetObj.ColHidden("rail_sto_aft") = true;	
    		sheetObj.ColHidden("cntr_eq_aft") = true;
    		sheetObj.ColHidden("chss_st_aft") = true;
    		sheetObj.ColHidden("chss_com_aft") = true;
    		sheetObj.ColHidden("rf_hndl_aft") = true;
    		sheetObj.ColHidden("sto_status") = true;
    		sheetObj.ColHidden("cntr_status") = true;
    		sheetObj.ColHidden("chss_status") = true;
    	} else {
    		sheetObj.ColHidden("mrn_sto_wthn") = false;
    		sheetObj.ColHidden("rail_sto_wthn") = false;	
    		sheetObj.ColHidden("cntr_eq_wthn") = false;
    		sheetObj.ColHidden("chss_st_wthn") = false;
    		sheetObj.ColHidden("chss_com_wthn") = false;
    		sheetObj.ColHidden("rf_hndl_wthn") = false;
    		sheetObj.ColHidden("mrn_sto_aft") = false;
    		sheetObj.ColHidden("rail_sto_aft") = false;	
    		sheetObj.ColHidden("cntr_eq_aft") = false;
    		sheetObj.ColHidden("chss_st_aft") = false;
    		sheetObj.ColHidden("chss_com_aft") = false;
    		sheetObj.ColHidden("rf_hndl_aft") = false;
    		sheetObj.ColHidden("sto_status") = false;
    		sheetObj.ColHidden("cntr_status") = false;
    		sheetObj.ColHidden("chss_status") = false;
    	}
    }