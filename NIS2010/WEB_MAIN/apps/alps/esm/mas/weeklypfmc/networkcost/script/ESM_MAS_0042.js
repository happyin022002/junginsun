/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0042.js
*@FileTitle : Dailyhire by Cht-VSL (PA) : 일당용선료관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.10.23 김기대 New FrameWork 적용
* 2010.04.14 이행지 FormQueryString =>masFormQueryString 변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
* 2013.05.07 성미영 [SRM-201334889] Dailyhire by Cht-VSL (PA) 전월 copy 기능 추가
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================
*/
 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0042 : ESM_MAS_0042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0042() {
    this.processButtonClick    = processButtonClick   ;
    this.setYrWk               = setYrWk              ;
    this.setYrMon              = setYrMon             ;
    this.fnYearWeekSet         = fnYearWeekSet        ;
    this.setPeriod             = setPeriod            ;
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd   ;
    this.sheet3_OnSearchEnd    = sheet3_OnSearchEnd   ;
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateForm          = validateForm         ;
    this.ComAddSeparator_Local = ComAddSeparator_Local;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab1 = 1;



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
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];
        var sheetObject4 = sheetObjects[4];
        
        /*******************************************************/
        var formObject = document.form;
        var objs = document.all.item("tabLayer");
        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Retrieve":
                	if( objs[0].style.display == "inline" ){
                		doActionIBSheet(sheetObject,formObject,IBSEARCH);
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBSEARCH);
					}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBSEARCH);
					}
                    break;

                case "btn_Save":
                    //doActionIBSheet(sheetObject,formObject,IBSAVE);
                	if( objs[0].style.display == "inline" ){
                		doActionIBSheet(sheetObject,formObject,IBSAVE);
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC01);
					}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBSEARCH_ASYNC01);
					}
                    break;

                case "btn_Downexcel":
                    //doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    if( objs[0].style.display == "inline" ){
                    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
					}
                    break;

                case "btns_calendar1":
                    var cal = new ComCalendar();
                    cal.select(formObject.f_yearweek, 'yyyyMM');
                    break;
                    
                case "btn_create":
                	//doActionIBSheet(sheetObject,formObject,IBCREATE);
                	if( objs[0].style.display == "inline" ){
                		doActionIBSheet(sheetObject,formObject,IBCREATE);
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC02);
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC02);
					}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBSEARCH_ASYNC02);
					}
                    break;
                    
    			case "btn_Month_Copy":		//팝업창(Month Copy)
      	            var display = "0,1";
      	            ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0042", 250, 200, "Daily Hire by Cht-VSL", display, true, false);
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
            //isValidYYYYWW(f_yearweek,true,'-',true);
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
 		var formObj = document.form;
		if ( formObj.f_yrtype[0].checked ) {
			sheetObjects[0].ColHidden("cost_wk") = true;
		}
        ComMasSetPeriod2(obj);
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
        // 텝 처리
    	for(k=0;k<tabObjects.length;k++){
  	  		initTab(tabObjects[k],k+1);
        }
    		
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
        
    	//SELCDA일 경우만 Create 버튼 활성화 
    	
    	if ( document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'SELAPM' || document.form.v_ofc_cd.value == 'CLTCO'){
    		ComBtnEnable("btn_create");
    	} else {
    		ComBtnDisable("btn_create");
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

			case "f_dur":
				for(var i=1; i<=12; i++)
					InsertItem(i-1,  i, i);
				DropHeight = 300;
				MaxLength = 2;
				Index = 5;
				break;
				
			}
		}
	}
	
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++, " Time Charterage " , -1 );
                    InsertTab( cnt++, " Other Charterage " , -1 );
                    InsertTab( cnt++, " Insurance_CHT Vessel " , -1 );
                    InsertTab( cnt++, " M&R_CHT Vessel " , -1 );
                    InsertTab( cnt++, " LASHING GEAR " , -1 );
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
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
                    InitRowInfo(1 , 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(13, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle   = "STS|YYYY-MM|Week|VSL Code|CTRT No.|From|To|Hire SEQ|Hire Rate1|Hire Curr1|Hire Rate2|Hire Curr2|Daily Hire";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,   30, daCenter,   false,  "sStatus");
                    InitDataProperty(0, cnt++,  dtData,     70, daCenter,   true,   "sYM",      false,      "",     dfDateYm,       0,      false,      true);
                    InitDataProperty(0, cnt++,  dtData,     50, daCenter,   true,   "cost_week",false,      "",     dfNone,         0,      false,      true, 2, true);

                    InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "sVslCd",   false,      "",     dfEngUpKey,     0,      false,      true, 4, true);
                    InitDataProperty(0, cnt++ , dtData,     110,daCenter,   false,  "",         false,      "",     dfEngUpKey,     0,      false,      true, 15, true);
                    InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "",         false,      "",     dfDateYmd,      0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "",         false,      "",     dfDateYmd,      0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,     60, daCenter,   false,  "",         false,      "",     dfNone,         0,      false,      true);

                    InitDataProperty(0, cnt++ , dtAutoSum,  70, daRight ,   false,  "",         false,      "",     dfNullInteger,  0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "",         false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtAutoSum,  70, daRight ,   false,  "",         false,      "",     dfNullInteger,  0,      false,      true);
                    InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "",         false,      "",     dfNone,         0,      false,      true);
                    InitDataProperty(0, cnt++ , dtAutoSum,  70, daRight ,   false,  "sDlyHireAmt",false,    "",     dfNullInteger,  0,      true,       true);

                    InitDataValid(0, "cost_week", vtNumericOnly);
                    InitDataValid(0, "sVslCd", vtEngUpOnly);

                    CountPosition   = 0 ;
                    style.height = GetSheetHeight(18) ;
                }
                break;
            case 2:     //t2sheet1 init
            case 3:     //t3sheet1 init
            case 4:     //t4sheet1 init
            case 5:     //t5sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;//전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                    Editable = true;//전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1 , 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(10, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle   = "STS|YYYY-MM|Week|VSL Code|VSL Class|Ratio(%)|Weekly Cost By VSL|ttl_amt|ttl_wk_amt|stnd_cost_cd";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,   30, daCenter,    false,  "ibflag");
                    InitDataProperty(0, cnt++,  dtData,     150, daCenter,   false,  "cost_yrmon",    false,     "",     dfDateYm,      0,  false,  false);
                    InitDataProperty(0, cnt++,  dtData,     100, daCenter,   false,  "cost_wk",       false,     "",     dfDateYm,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     160, daCenter,   false,  "vsl_cd",        false,     "",     dfEngUpKey,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     170, daRight,    false,  "vsl_clss_capa", false,     "",     dfNullInteger, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,   160, daCenter ,  false,  "chrg_rt",       false,     "",     dfFloatOrg,    2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  160, daRight ,   false,  "vsl_cost_amt",  false,     "",     dfFloatOrg,    2,  true,   false);
                    InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "ttl_amt",       false,     "",     dfFloatOrg,    2,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "ttl_wk_amt",    false,     "",     dfFloatOrg,    2,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "stnd_cost_cd",  false,     "",     dfNone,        0,  false,  false);
                    CountPosition   = 0 ;
                    style.height = GetSheetHeight(18) ;
                }
                break;
        }
    }

 	/**
 	 * Tab 클릭시 이벤트 관련
 	 * 선택한 탭의 요소가 활성화 된다.
 	 */
	function tab1_OnChange(tabObj , nItem){
		var objs = document.all.item("tabLayer");
		var formObj = document.form;

		objs[nItem].style.display = "inline";
		objs[beforetab1].style.display = "none";
		//--------------- 요기가 중요 --------------------------//
		var pre_idx =  objs[nItem].style.zIndex;
		pre_idx--;
		objs[beforetab1].style.zIndex = pre_idx ;
		//------------------------------------------------------//

		beforetab1= nItem;
		var drdTable = document.getElementById("drd_table");
		if ( nItem == 0 ) {
			formObj.f_yrtype[0].disabled = false;
            formObj.f_yrtype[0].checked = true;
            boolYyyyWw = true;
            setYrMon();
            ComSetObjValue(formObj.f_cobcost, "");
            ComBtnEnable("btn_Month_Copy");
			drdTable.style.display = "none";
		} else {
			formObj.f_yrtype[0].disabled = true;
			formObj.f_yrtype[1].disabled = false
			formObj.f_yrtype[0].checked = false;
			formObj.f_yrtype[1].checked = true;   
            
			if(boolYyyyWw)
				setYrWk(fYear,prevWeek);
			boolYyyyWw = false;
			
			var arr_f_cobcost = ["54350009","54250009","54150009","54200009"];
            ComSetObjValue(formObj.f_cobcost, arr_f_cobcost[nItem-1]);                	
            ComBtnDisable("btn_Month_Copy");
			drdTable.style.display = "inline";
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

    function sheet1_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"sYM") = "TOTAL";

        // YYYY-MM 선택시 WEEK정보가 보이지 않도록 변경 2010.03.11
        var formObj = document.form;
        if ( formObj.f_yrtype[0].checked ) {
        	sheetObjects[0].ColHidden("cost_week") = true;
        } else if ( formObj.f_yrtype[1].checked ) {
        	sheetObjects[0].ColHidden("cost_week") = false;
        }
    }

    function sheet3_OnSearchEnd(sheetObj) {
        for(i=0;i<sheetObj.Rows;i++){
            if(sheetObj.CellValue(i, "sStatus") == "I"){
                for(var j=1; j<=12; j++){
                    if(j == 12){
                        sheetObj.CellEditable(i,j) = true;
                    }
                    else{
                        sheetObj.CellEditable(i,j) = false;
                    }
                }
                
                //sheetObj.CellEditable(i,"sDlyHireAmt") = false;
            }
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

        switch(sAction) {

        case IBCLEAR:          //조회
	        sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0042GS2.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				ComXml2ComboItem(arrXml[0], formObj.select1, "code", "name");
				fYear = ComGetEtcData(arrXml[0], "fYear");				
				prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
				formObj.f_yrtype[1].onclick = function(){setYrWk(fYear,prevWeek)};
				//formObj.f_yrtype[1].onclick = function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"), ComGetEtcData(arrXml[0],"prevWeek"))};
			}
	
	        setYrMon();  // 월/주 입력 창에 금월 셋팅
	        ComSetObjValue(formObj.f_sweek, ComGetDateAdd(null, "M", -2).substr(0,7)); //  Start Week
			ComOpenWait(false);
			break;	

		case IBSEARCH:      //조회
                ComAddSeparator_Local(formObj.f_yearweek, "-");
                if ( sheetObj.id == "sheet1")
				{
	                if(validateForm(sheetObj,formObj,sAction)){
	                	ComOpenWait(true);
	                	formObj.f_cmd.value = SEARCH;
	                    //addDash(formObj.f_yearweek,4);
	
	                    formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,formObj.f_yrtype[0].checked?"ym":"yw");
	                    formObj.f_vsl_cd.value = "All"==formObj.select1.Code?"":formObj.select1.Code;
	
	                    sheetObj.DoSearch4Post("ESM_MAS_0042GS.do", masFormQueryString(formObj));
	
	                    sheet3_OnSearchEnd(sheetObj);
	                    ComOpenWait(false);
	                }
				} else if ( sheetObj.id == "t2sheet1" 
					        || sheetObj.id == "t3sheet1"
					        || sheetObj.id == "t4sheet1"
					        || sheetObj.id == "t5sheet1") {
	                if(validateForm(sheetObj,formObj,sAction)){
	                	ComOpenWait(true);
	                	formObj.f_cmd.value = SEARCH01;
	                    formObj.f_yearweek.value = ComGetMaskedValue(formObj.f_yearweek.value,formObj.f_yrtype[0].checked?"ym":"yw");
	                    formObj.f_vsl_cd.value = "All"==formObj.select1.Code?"":formObj.select1.Code;
	                    sheetObj.DoSearch4Post("ESM_MAS_0042GS2.do", masFormQueryString(formObj));
	                    ComOpenWait(false);
	                }					
				}
                break;

        case IBSAVE:        //저장
            ComAddSeparator_Local(formObj.f_yearweek, "-");

            if(validateForm(sheetObj,formObj,sAction)){
            	ComOpenWait(true);
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_MAS_0042GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
                ComOpenWait(false);
            }
            break;
            
        case IBSEARCH_ASYNC01:        //저장
            ComAddSeparator_Local(formObj.f_yearweek, "-");

            if(validateForm(sheetObj,formObj,sAction)){
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI02;
//					var sParam =  sheetObjects[1].GetSaveString(false, true);
//					alert(sParam);
//					if( sParam == ""){ return;}
//                  sheetObjects[1].DoSave("ESM_MAS_0042GS2.do", masFormQueryString(formObj,'f_cmd',true) + "&" + sParam, -1, false);
                sheetObj.DoSave("ESM_MAS_0042GS2.do", masFormQueryString(formObj), -1, false);
                ComOpenWait(false);
            }
            break;                
            
        case IBCREATE:        //FMS로부터 데이터 생성
        	ComAddSeparator_Local(formObj.f_yearweek, "-");
            if(validateForm(sheetObj,formObj,sAction)){
            	if (ComShowConfirm(ComGetMsg('MAS10020')) == true) {
                	ComOpenWait(true);
                    formObj.f_cmd.value = MULTI01;
                    var sXml = sheetObj.GetSearchXml("ESM_MAS_0042GS.do",masFormQueryString(formObj));
                    
                    if (sXml != "") sheetObj.LoadSearchXml(sXml);
                    
                    var XrateCnt = ComGetEtcData(sXml, "XrateCnt" );
                    
                    if (XrateCnt == "X") {
                    	ComShowMessage(ComGetMsg("MAS10015","Accounting Exchange Rate",""));
                    	ComOpenWait(false);
                    	return;
                    }
                    doActionIBSheet(sheetObj,formObj,IBSEARCH);
                    ComOpenWait(false);
            	}

            }
            break;
            
        case IBSEARCH_ASYNC02:
        	ComAddSeparator_Local(formObj.f_yearweek, "-");
        	if(!validateForm(sheetObj,formObj,sAction)) {
            	return false;
            }

        	if (!ComShowCodeConfirm("MAS10020")) {
        		return false;
        	}
        	
            ComOpenWait(true);
            sheetObj.Redraw = false;
            
            formObj.f_cmd.value = COMMAND01;                
            sheetObj.DoSearch("ESM_MAS_0042GS.do", FormQueryString(formObj));          
            doActionIBSheet(sheetObj, formObj, IBSEARCH);                 
            sheetObj.Redraw = true;
            break;                
            
        case IBINSERT:      // 입력
            sheetObj.DataInsert();
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
                if(f_yrtype[0].checked){
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
                }
            }
            if(f_yearweek.value.replace("-","").length != 6) {
                if(f_yrtype[0].checked){
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
                }
            }
            //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
            //if(!ComAddSeparator(f_yearweek)) return false;

            if(f_yrtype[0].checked == true){
               //if(!isValidYYYYMM(f_yearweek, false, '-', false)) return false;
               //if(ComIsDate(f_yearweek)) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "ym")) return false;
            }else{
               //if(!isValidYYYYWW(f_yearweek, false, '-', false)) return false;
              //if(ComIsDate(f_yearweek, "yw")) return false;
               if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            }

            if (sAction == IBCREATE){
            	if(f_yrtype[1].checked == true) { //Week Option이 켜져 있으면
            		ComShowCodeMessage('MAS10003','Creation','YYYY-MM');
            		return false;
            	}
            } else if (sAction == IBSEARCH_ASYNC02){
            	if(ComIsNull(formObj.f_sweek)) {
      				ComShowMessage(ComGetMsg('MAS10002', 'Start Month'));
      	            ComSetFocus(formObj.f_sweek);
    				return false;
    			}            	
            }
        }
        return true;
    }

    function ComAddSeparator_Local(obj, sFormat) {
        try {
            obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	setTtlCostInfo(sheetObj, 2);
    }

    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	setTtlCostInfo(sheetObj, 3);
    }
    
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	setTtlCostInfo(sheetObj, 4);
    }
    
    function t5sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	setTtlCostInfo(sheetObj, 5);
    }
    
    function setTtlCostInfo(sheetObj, no){
    	var formObj = document.form;
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"cost_yrmon") = "TOTAL";
    	if(sheetObj.RowCount > 0){
    		eval("formObj.ttl_amt"+no).value = sheetObj.CellText(sheetObj.SelectRow, "ttl_amt");
    		eval("formObj.ttl_wk_amt"+no).value = sheetObj.CellText(sheetObj.SelectRow, "ttl_wk_amt");
    	}else{
    		eval("formObj.ttl_amt"+no).value = "";
    		eval("formObj.ttl_wk_amt"+no).value = "";
    	}
    }    