/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1101.js
*@FileTitle : EQ Forecast Summary Filter
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
     * @class EES_EQR_1101 : EES_EQR_1101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_eqr_1101() {
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
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    formObject.reset();
                break;
                case "btn_save":
                	doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
                case "btn_downExcel":
                    sheetObject.Down2Excel(-1, false, false, true);
                break;
                case "btn_row_add":
            		var addRow = sheetObjects[0].DataInsert();
            		sheetObjects[0].CellEditable(addRow, "rcc_cd") = true;
            		if(addRow > 2){
            			sheetObjects[0].CellValue(addRow, "rcc_cd") = sheetObjects[0].CellValue(addRow-1, "rcc_cd") 
            		}
            		sheetObjects[0].CellEditable(addRow, "loc_grp_cd") = true;
            		sheetObjects[0].CellEditable(addRow, "loc_cd") = true;
            		sheetObjects[0].CellEditable(addRow, "hul_bnd_cd") = true;
                break;
                case "btn_row_del":
                	var countRows = sheetObjects[0].CheckedRows("chk");
                	if(countRows == 0) {
                		ComShowCodeMessage("EQR90214");
                		return;
                	} else {
                    	var checkedRows = sheetObjects[0].FindCheckedRow("chk");
                    	var arrRows = checkedRows.split("|");
                    	for(i=0; i<arrRows.length; i++){
                    		if(arrRows[i]==""){
                    			continue;
                    		}
                        	if(sheetObjects[0].CellValue(arrRows[i],"ibflag")=="I"){ // 신규 입력 건
                        		sheetObjects[0].RowDelete(arrRows[i], false);
                        	} else {
                        		sheetObjects[0].CellValue(arrRows[i],"ibflag") = "D";
                        		sheetObjects[0].CellValue(arrRows[i],"delt_ftr_flg") = "Y";
        						sheetObjects[0].RowHidden(arrRows[i]) = true;
                        	}
                    	}
                	}
                break;
                case "btn_loc_cd":
        			//if(formObj.loc_cd.value != "") {	
					var code_type = formObject.s_loc_grp_cd.value;
					var tmp_rcc_cd = formObject.s_rcc_cd.value;

					if(code_type.substr(0,1) == "E") {
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?rcc_cd='+tmp_rcc_cd, 1000, 457, "ecc_cd:s_loc_cd", "0,1,1,1,1,1", true);
					}else if(code_type.substr(0,1) == "L") {	
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?rcc_cd='+tmp_rcc_cd, 1000, 457, "lcc_cd:s_loc_cd", "0,1,1,1,1,1", true);
				    }else if(code_type.substr(0,1) == "S"){
				    	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do?rcc_cd='+tmp_rcc_cd, 1000, 457, "scc_cd:s_loc_cd", "0,1,1,1,1,1", true);
				    }
    			//}
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
                    style.height = 440;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   	InitRowInfo(2, 1, 22, 100);

                    var HeadTitle1 = "||RCC|Location|Type|DIV|Final Volume|Final Volume|Serious\nSurplus|Surplus|Balance|Shortage|Serious\nShortage|DELT_FTR_FLG";
                    var HeadTitle2 = "||RCC|Location|Type|DIV|Increase|Decrease|Serious\nSurplus|Surplus|Balance|Shortage|Serious\nShortage|DELT_FTR_FLG";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(false, false, false, true, false,false)
                    InitHeadMode(false, true, true, true, false,false)
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, false);

                    var rowCnt = 0;

                    //데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                    
                	cnt = 0;
                	rowCnt = 0;
                	
					InitDataProperty( rowCnt , cnt++ , dtHiddenStatus , 0   , daCenter    , false  , "ibflag"   );
//					InitDataProperty( rowCnt , cnt++ , dtRadioCheck   , 30  , daCenter    , false , "chk"                  , false , ""      , dfNone );
					InitDataProperty( rowCnt , cnt++ , dtDelCheck     , 30  , daCenter    , true , "chk"                  );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 75  , daCenterTop , true  , "rcc_cd"               , true  , ""      , dfNone , 0, false, false );
                    InitDataProperty( rowCnt , cnt++ , dtData         , 85 , daCenter    , true  , "loc_cd"               , true  , ""      , dfEngUpKey , 0, false, false );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 80  , daCenter    , true  , "loc_grp_cd"           , true  , ""      , dfNone , 0, false, false );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 80 , daCenter    , true  , "hul_bnd_cd"           ,  true  , ""      , dfNone , 0, false, false );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , false , "stk_icrz_ftr_flg"     , false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , false , "stk_dcrz_ftr_flg"     , false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , true  , "sros_spls_ftr_flg"    , false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , true  , "norm_spls_ftr_flg"    , false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , true  , "bal_ftr_flg"    ,       false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , true  , "norm_shtg_ftr_flg"    , false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtCombo        , 85  , daCenter    , true  , "sros_shtg_ftr_flg"    , false , ""      , dfNone );
                    InitDataProperty( rowCnt , cnt++ , dtHidden       , 30  , daCenter    , true  , "delt_ftr_flg"         , false , ""      , dfNone );

					InitDataCombo(0, 'rcc_cd', rcc_cdText, rcc_cdCode);
					InitDataCombo(0, 'loc_grp_cd', loc_grp_cdText, loc_grp_cdCode);
					InitDataCombo(0, 'hul_bnd_cd', hul_bnd_cdText, hul_bnd_cdCode);
					InitDataCombo(0, 'stk_icrz_ftr_flg', "Y| ", "Y|N");
					InitDataCombo(0, 'stk_dcrz_ftr_flg', "Y| ", "Y|N");
					InitDataCombo(0, 'sros_spls_ftr_flg', "Y| ", "Y|N");
					InitDataCombo(0, 'norm_spls_ftr_flg', "Y| ", "Y|N");
					InitDataCombo(0, 'bal_ftr_flg', "Y| ", "Y|N");					
					InitDataCombo(0, 'norm_shtg_ftr_flg', "Y| ", "Y|N");
					InitDataCombo(0, 'sros_shtg_ftr_flg', "Y| ", "Y|N");
					
	                HeadRowHeight = 10;

                   // SetSumColMerge();           // 합계의 세로 머지를 설정한다.

                    //CountPosition = 0;

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
                        sheetObj.doSearch4Post("EES_EQR_1101GS.do",FormQueryString(formObj));
                		sheetObj.WaitImageVisible = true;
            			ComOpenWait(false);
                } else {
                    return;
                }
            break;
            case IBSAVE:  // 저장
                if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
	            	var isSuccess = sheetObj.DoSave("EES_EQR_1101GS.do",eqrFormQryStr(formObj));
					
		    		if(!isSuccess){
		    			return false;
		    		} else {
		    			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		    		}

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
        return true;
    }

    function obj_activate() {
    }    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 
         } // end of with
         return true;
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
     * Sheet내에서 Audit Status(Select Flg) 변경시
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     */
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
		
	 	switch(colName) {
	 		case("stk_icrz_ftr_flg"):
	 		case("stk_dcrz_ftr_flg"):
	 		case("sros_spls_ftr_flg"):
	 		case("norm_spls_ftr_flg"):
	 		case("bal_ftr_flg"):
	 		case("norm_shtg_ftr_flg"):
	 		case("sros_shtg_ftr_flg"):
	 			// Select 값을 변경시 confirm위해 자동으로 Select Check box 표시
	 			if(sheetObj.CellValue(row, "chk") == "0") {
//	 				sheetObj.CellValue2(row, "chk") = "1";
	 			}
	 		break;
	 		case("loc_cd"):
	 			sheetObj.CellValue2(row, col)=value.toUpperCase();
	 			var tmp_rcc_cd = sheetObj.CellValue(row, "rcc_cd"); 
	 			var tmp_loc_grp_cd = sheetObj.CellValue(row, "loc_grp_cd");
	 			validLocationCode(row, tmp_rcc_cd, tmp_loc_grp_cd, value.toUpperCase());
	 		break;
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

