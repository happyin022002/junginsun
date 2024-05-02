/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1102.js
*@FileTitle : EQ Forecast Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.12.15 박정민
* 1.0 Creation
* ======================================================
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
     * @class EES_EQR_1102 : EES_EQR_1102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1102() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var enterSwitch = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];


        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_Retrieve":
                	obj_click();
                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
                    sheetObjects[0].SelectRow = 0;
                break;
                case "btn_pfmc_rule":
    				ComOpenPopupWithTarget('apps/alps/ees/eqr/cntrfcstsimul/forecastsummary/jsp/EES_EQR_1102_POP.jsp', 600, 160,"", "0,1,1,1,1,1", true);
                break;
                
                case "btn_inv_sts":
    				ComOpenPopupWithTarget('apps/alps/ees/eqr/cntrfcstsimul/forecastsummary/jsp/EES_EQR_1102_POP_INV.jsp', 850, 180,"", "0,1,1,1,1,1", true);
                break;
                
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    formObject.reset();
                break;
                        
                case "btn_downExcel":
                    sheetObject.Down2Excel(-1, false, false, true);
                break;
                case "btn_row_add":
                    alert();
                break;
                case "btn_row_del":
                    alert("row_del");
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

    function nextFocusOut(){
        document.form.location.focus();
    }     
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    function initControl(){
        axon_event.addListener      ( 'blur'     , 'obj_blur'       , document.form );
        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'   , document.form ); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        
        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- form OnBeforeDeactivate이벤트에 코드 처리

    }    
    
    function obj_click(){
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,"D");
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initControl();
        
	    // MAS에서 호출하는 부분과 관련하여 로직 추가(2016.04.22)
		// [CHM-201641102] [테마제안 캠페인]Pre CM/OP 화면에서 EQ Status 조회 컬럼 추가
		if(document.form.mas_loc.value != "" && document.form.mas_loc.value != "null" && document.form.mas_loc.value != "NULL" ) {
			document.form.s_loc_grp_cd[2].selected = true;
			document.form.s_rcc_cd.value = document.form.mas_rcc.value;
			document.form.s_loc_cd.value = document.form.mas_loc.value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		// MAS 작업 끝        
    }


    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,option) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
        
            case "sheet1":

                with (sheetObj) {

                    // 높이 설정
                    style.height = 460;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msHeaderOnly;
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                   	InitRowInfo(2, 1, 22, 100);

                    var HeadTitle1 = "|RCC|Division|TP/SZ|Optimum\nStock\n(Final)|Inventory Forecast|Inventory Forecast|Inventory Forecast|Inventory Forecast|Inventory Forecast|OP Forecast|OP Forecast|OP Forecast|OP Forecast|OP Forecast|PFMC(Inventory vs OP)|PFMC(Inventory vs OP)|PFMC(Inventory vs OP)|PFMC(Inventory vs OP)|PFMC(Inventory vs OP)|Inventory Status\nin the Upcoming 4weeks|Inventory Status\nin the Upcoming 4weeks|Inventory Status\nin the Upcoming 4weeks|Full M/B|Full M/B|||||||";
                    var HeadTitle2 = "|RCC|Division|TP/SZ|Optimum\nStock\n(Final)|Current\nWeek|+1 week|+2 week|+3 week|Average|Current\nWeek|+1 week|+2 week|+3 week|Average|Current\nWeek|+1 week|+2 week|+3 week|Average|Increase|Decrease|Status|Average|Status|||||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, false, false, true, false,false)
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var rowCnt = 0;

                    //데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                    
                	cnt = 0;
                	rowCnt = 0;
                	
					InitDataProperty( rowCnt , cnt++ , dtHiddenStatus , 0   , daCenter    , true  , "ibflag"        , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 50  , daCenterTop , true  , "rcc_cd"        , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 65  , daCenterTop , true  , "division"      , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 45  , daCenter    , true  , "cntr_tpsz_cd"  , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 60 , daRight     , true , "opt_vol"       , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , true , "iv_w0"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , true , "iv_w1"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , true , "iv_w2"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , true , "iv_w3"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , true , "iv_avg"        , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "op_w0"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "op_w1"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "op_w2"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "op_w3"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "op_avg"        , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "pr_w0"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "pr_w1"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "pr_w2"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "pr_w3"         , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 55  , daRight     , false , "pr_avg"        , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtImage        , 65  , daCenter    , false , "stk_icrz_img"  , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtImage        , 65  , daCenter    , false , "stk_dcrz_img"  , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtImage        , 60  , daCenter    , false , "status_img"    , false , ""      , dfNone , 0 , false, false );

                    InitDataProperty( rowCnt , cnt++ , dtData         , 65  , daRight     , false , "mb_value"        , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 65  , daCenter     , false, "mb_status"        , false , ""      , dfNone , 0 , false, false );

                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "sros_spls_flg" , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "norm_spls_flg" , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "norm_shtg_flg" , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "sros_shtg_flg" , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "bal_flg" ,       false , ""      , dfNone , 0 , false, false );

                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "stk_icrz_flg"  , false , ""      , dfNone , 0 , false, false );
                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 0  , daCenter    , false , "stk_dcrz_flg"  , false , ""      , dfNone , 0 , false, false );
                    

                   // SetSumColMerge();           // 합계의 세로 머지를 설정한다.
	                HeadRowHeight = 35; //35

                    //CountPosition = 0;

	                ImageList(0) = "img/icon_dot_blue.gif";  // 1, Decrease - blue color, down
	                ImageList(1) = "img/icon_dot_red.gif";   // 2, Increase - red color, up
	                
	                
	                ImageList(2) = "img/btng_icon_b.gif";      // 3, Serious Shortage , blue 
	                ImageList(3) = "img/btng_icon_f.gif";      // 4, Shortage , slow blue  
	                ImageList(4) = "img/btng_icon_y.gif";      // 5, Surplus , yellow 
	                ImageList(5) = "img/btng_icon_r.gif";      // 6, Serious Surplus , red 
	                ImageList(6) = "img/btng_icon_green.gif";  // 3, Balance , green
	                   
                    AutoRowHeight = false; 

	                SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
	                SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
	                SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
                }
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:  // 조회
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == "sheet1")
                		sheetObj.WaitImageVisible = false;
            			ComOpenWait(true);
                        formObj.f_cmd.value = SEARCH;
                        sheetObj.doSearch4Post("EES_EQR_1102GS2.do",FormQueryString(formObj));
                		sheetObj.WaitImageVisible = true;
            			ComOpenWait(false);
                } else {
                    return;
                }
            break;
        }
    }

    function form_keyup() {
        var obj = null;
        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
                : event.charCode;
        if (keyValue != 13) {
            ComKeyEnter('lengthnextfocus');
        } else {
            if (obj_deactivate()) {
              //  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    
    function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "num":
				if(obj.name=="vndr_seq"){
					//ComKeyOnlyNumber(obj,",");
					ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
				} else {
					ComKeyOnlyNumber(obj);
				}
				break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdn":
				if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
				else ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
		}
	}    
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate() {
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
		case"yw":
	    	var w = document.getElementById("fcast_yrwk");
	    	if (ComChkObjValid(event.srcElement, false)) {
	    		// 주별로 조회
	    		sVal1 = w.value.replace(/\/|\-|\./g, "");
	
	    		document.form.fcast_yrwk.value = sVal1;
	    		ComAddSeparator(event.srcElement);
	    	} else {
	    		// 주별로 조회
	    		sVal1 = w.value.replace(/\/|\-|\./g, "");
	
	    		if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
	    			event.srcElement.value = "";
	    			ComShowCodeMessage("EQR90211", "YYYYWW");
	    			document.form.fcast_yrwk.focus();
	    			return false;
	    		}
	    	}

    	return true;
		}
    }

    function obj_activate() {
    	ComClearSeparator(event.srcElement);
    	ComSetFocus(event.srcElement);
    }    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				if(formObj.fcast_yrwk.value == ""){
					ComShowCodeMessage('EQR90001', 'Week'); 
					return false;
				}

			break;
		}
		
		return result;
    }
    
    // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

    }

    function obj_change(){
		var obj = event.srcElement;
		var formObjects=document.form;
		switch(obj.name) {
			case "s_loc_cd":			// RCC, LCC, ECC, SCC, YARD, VALIDATION
				var formObjects = document.form;
				if(obj.value.trim() == ""){
					return;
				}
				
				var rccCd = formObjects.s_rcc_cd.value;
				var locGrpCd = formObjects.s_loc_grp_cd.value;
				var value = obj.value;
				
				if(rccCd == ""){
					ComShowCodeMessage("EQR90016", "RCC");
					document.form.s_loc_cd.value = "";
					return;
				}
				
				validLocationCode(-1, rccCd, locGrpCd, value);
					
			break;
			case "fcast_week":
		    	var w = document.getElementById("fcast_yrwk");
		    	if (ComChkObjValid(event.srcElement, false)) {
		    		// 주별로 조회
		    		sVal1 = w.value.replace(/\/|\-|\./g, "");
		
		    		document.form.fcast_yrwk.value = sVal1;
		    		ComAddSeparator(event.srcElement);
		    	} else {
		    		// 주별로 조회
		    		sVal1 = w.value.replace(/\/|\-|\./g, "");
		
		    		if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6))) {
		    			event.srcElement.value = "";
		    			ComShowCodeMessage("EQR90211", "YYYYWW");
		    			document.form.fcast_yrwk.focus();
		    			return false;
		    		}
		    	}
			break;
		}
    }    
    function obj_blur() {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }
    
    /**
     * RCC Combo code 변경시 
     * Loc code초기화
     */
    function change_rcc(){
    	var formObj = document.form;
    	if(formObj.s_rcc_cd.value !=""){
    		formObj.s_loc_grp_cd.value = "";
    		formObj.s_loc_cd.value = "";
    	}
    }

    
	/**
	 * @param row
	 * @param rccCd
	 * @param locGrpCd
	 * @param locCd
	 */
	function validLocationCode(row, rccCd, locGrpCd, locCd){
		var param = new Array();
		param[0] = "f_cmd=" + SEARCH01;
		param[1] = "s_rcc_cd=" + rccCd;
		param[2] = "s_loc_grp_cd=" + locGrpCd;
		param[3] = "s_loc_cd=" + locCd;
		var sXml = sheetObjects[0].GetSearchXml("EES_EQR_1101GS.do",param.join("&"));
		var count = ComGetEtcData(sXml, "count");
		var err_msg = "";
		if(count == "0"){
			if(row==-1){
				document.form.s_loc_cd.value = "";
				document.form.s_loc_cd.focus();
			} else {
				sheetObjects[0].CellValue2(row, "loc_cd") = "";
			}
			if(locGrpCd == "L"){
				ComShowCodeMessage("EQR01005");
			} else if(locGrpCd == "E") {
				ComShowCodeMessage("EQR01006");
			} else if(locGrpCd == "S") {
				ComShowCodeMessage("EQR01007");
			} else {
				ComShowCodeMessage("EQR01103", "Location");
			}
			return;
		}
	}
	
	/**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	//alert("R : " + sheetObj.RowCount("R"));
    	var count_read = sheetObj.RowCount+2;
    	        
        for(var i=2; i<count_read; i++) {
        	if(sheetObj.CellValue(i,"stk_dcrz_flg")=="Y")  sheetObj.CellImage(i,"stk_dcrz_img") = 0; // decrease, blue
        	if(sheetObj.CellValue(i,"stk_icrz_flg")=="Y")  sheetObj.CellImage(i,"stk_icrz_img") = 1; // increase, red 
        	
        	// Status
        	if     (sheetObj.CellValue(i,"sros_shtg_flg")=="Y") sheetObj.CellImage(i,"status_img") = 2; // serious shortage, blue 
        	else if(sheetObj.CellValue(i,"norm_shtg_flg")=="Y") sheetObj.CellImage(i,"status_img") = 3; // normal shortage, green 
        	else if(sheetObj.CellValue(i,"norm_spls_flg")=="Y") sheetObj.CellImage(i,"status_img") = 4; // normal surplus, yellow 
        	else if(sheetObj.CellValue(i,"sros_spls_flg")=="Y") sheetObj.CellImage(i,"status_img") = 5; // serious surplus, red 
        	else if(sheetObj.CellValue(i,"bal_flg")=="Y")       sheetObj.CellImage(i,"status_img") = 6; // balance, 옅은 파랑 
        			
        	if     (sheetObj.CellValue(i,"mb_status")=="") sheetObj.CellValue2(i,"mb_value") = "%"; // 조회된 값이 없으면 0 제거
        	else                                           sheetObj.CellValue2(i,"mb_value") = sheetObj.CellValue(i,"mb_value")+"%";
        }               
        
    }	

