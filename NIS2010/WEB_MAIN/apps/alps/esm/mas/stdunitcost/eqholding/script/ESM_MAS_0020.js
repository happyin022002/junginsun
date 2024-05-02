/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0020.js
*@FileTitle : Network Cost Exception List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
=========================================================
* History
=========================================================
*/
 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0020 : ESM_MAS_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0020() {
    this.processButtonClick    = processButtonClick   ;
    this.setYrMon               = setYrMon              ;
    this.setPeriod             = setPeriod            ;
    this.loadPage              = loadPage             ;
    this.initSheet             = initSheet            ;
    this.setSheetObject        = setSheetObject       ;
    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd   ;
    //this.sheet3_OnSearchEnd    = sheet3_OnSearchEnd   ;
    this.doActionIBSheet       = doActionIBSheet      ;
    this.validateForm          = validateForm         ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

var sheet_selno = "1"; //현재 선택된 SHEET

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
                	if (formObject.code[0].checked){
                		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                	} else if (formObject.code[1].checked) {
                		doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                	}
                	
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
                	
                    break;

                case "btn_Downexcel":
                	if (formObject.code[0].checked){
                		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                	} else if (formObject.code[1].checked) {
                		doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
                	}
                    
                    break;
                    
                case "btn_Rowadd":
    	            doActionIBSheet(sheetObjects[1],formObject,IBINSERT);
        	        break;
        	        
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
                    break;

        		case "btn_loc_cd_por": //Location 조회 팝업

        			var cnt_cd = "";
        			var loc_cd = "";
        			cnt_cd = formObject.location_by_por.value;
        			loc_cd = formObject.location_por.value;
        			if (formObject.location_by_por.value != 'AR' && formObject.location_by_por.value != 'AC') {
        				if (formObject.location_by_por.value == 'CC') { //Country
//        					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;			// location은 해당 팝업 사용안함(팝업은 국가코드용)
//        					ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 650, "popupFinishPor", "1,0,1,1,1,1,1,1", true);
//        				} else if (formObject.location_by_por.value == 'YY') { //Yard
//        					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
//        					ComOpenPopup("/hanjin/COM_ENS_061.do", 755, 650, "popupFinish2Por", "1,0,1,1,1,1,1,1", true);
        				} else {
        					var loc_code = "";

        					if (formObject.location_by_por.value == "RL" || formObject.location_by_por.value == "RE") {
        						loc_code = "rcc_cd";
        					} else if (formObject.location_by_por.value == "LE") {
        						loc_code = "lcc_cd";
        					} else if (formObject.location_by_por.value == "LS") {
        						loc_code = "lcc_cd";
        					} else if (formObject.location_by_por.value == "ES") {
        						loc_code = "ecc_cd";
        					} else if (formObject.location_by_por.value == "SS") {
        						loc_code = "scc_cd";
        					}
        					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
        					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location_por", "1,0,1,1,1,1,1,1", true);
        				}
        			}

        			break;

        		case "btn_loc_cd_del": //Location 조회 팝업

        			var cnt_cd = "";
        			var loc_cd = "";
        			cnt_cd = formObject.location_by_del.value;
        			loc_cd = formObject.location_del.value;
        			if (formObject.location_by_del.value != 'AR' && formObject.location_by_del.value != 'AC') {
        				if (formObject.location_by_del.value == 'CC') { //Country
//        					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;			// location은 해당 팝업 사용안함(팝업은 국가코드용)
//        					ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 650, "popupFinishDel", "1,0,1,1,1,1,1,1", true);
//        				} else if (formObject.location_by_del.value == 'YY') { //Yard
//        					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
//        					ComOpenPopup("/hanjin/COM_ENS_061.do", 755, 650, "popupFinish2Del", "1,0,1,1,1,1,1,1", true);
        				} else {
        					var loc_code = "";

        					if (formObject.location_by_del.value == "RL" || formObject.location_by_del.value == "RE") {
        						loc_code = "rcc_cd";
        					} else if (formObject.location_by_del.value == "LE") {
        						loc_code = "lcc_cd";
        					} else if (formObject.location_by_del.value == "LS") {
        						loc_code = "lcc_cd";
        					} else if (formObject.location_by_del.value == "ES") {
        						loc_code = "ecc_cd";
        					} else if (formObject.location_by_del.value == "SS") {
        						loc_code = "scc_cd";
        					}
        					var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
        					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location_del", "1,0,1,1,1,1,1,1", true);
        				}
        			}

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

        ComSetFocus(document.form.f_cost_yrmon);
		
        ComBtnDisable("btn_Save");
        ComBtnDisable("btn_Rowadd");
        ComBtnDisable("btn_Rowdelete");
        
    	axon_event.addListenerForm('change', 'obj_change', form);
    	axon_event.addListener('blur', 'obj_blur_por', 'location_por');
    	axon_event.addListener('blur', 'obj_blur_del', 'location_del');
    	
    	tabLayer1.style.display = "inline";
    	tabLayer2.style.display = "none";

    	tabObjects[0].SelectedIndex = 1;
    	
        loadingMode = false;
    }


    function obj_keypress() {
    	switch (event.srcElement.name) {
    	case "location_por":
    		if (document.form.location_by_por.value == "Y") {
    			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
    		} else {
    			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
    		}
    		break;

    	case "location_del":
    		if (document.form.location_by_del.value == "Y") {
    			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
    		} else {
    			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
    		}
    		break;
    	
    	}
    }

    function setCode(code){
    	if (code == "0") {
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_Rowadd");
            ComBtnDisable("btn_Rowdelete");

            tabLayer1.style.display = "inline";
            tabLayer2.style.display = "none";
            
    	} else if (code == "1") {   
	        ComBtnEnable("btn_Save");
	        ComBtnEnable("btn_Rowadd");
	        ComBtnEnable("btn_Rowdelete");	    

            tabLayer1.style.display = "none";
            tabLayer2.style.display = "inline";
        }
    	
    }
   
    function obj_change() {
    	obj = event.srcElement;
    	if (obj.name == "location_by_por") {
    		if (obj.value == "AR" || obj.value == "AC" || obj.value == "AP") {
    			document.getElementById("location_por").disabled = true;
    			document.getElementById("location_por").value = "";
    			document.getElementById("location_por").className = "input2";
    		} else {
    			document.getElementById("location_por").disabled = false;
    		//	document.getElementById("location").value = "";
    			document.getElementById("location_por").className = "input";
    			document.getElementById("location_por").focus();
    		}
    		if (obj.value == "CC") {
    			document.getElementById("location_por").setAttribute("maxLength", 5);
//    		} else if (obj.value == "YY") {
//    				document.getElementById("location_por").setAttribute("maxLength", 7);	
    		} else {
    			document.getElementById("location_por").setAttribute("maxLength", 5);
    		}

    	} else 	if (obj.name == "location_by_del") {
        		if (obj.value == "AR" || obj.value == "AC" || obj.value == "AP") {
        			document.getElementById("location_del").disabled = true;
        			document.getElementById("location_del").value = "";
        			document.getElementById("location_del").className = "input2";
        		} else {
        			document.getElementById("location_del").disabled = false;
        		//	document.getElementById("location").value = "";
        			document.getElementById("location_del").className = "input";
        			document.getElementById("location_del").focus();
        		}
        		if (obj.value == "CC") {
        			document.getElementById("location_del").setAttribute("maxLength", 5);
//        		} else if (obj.value == "YY") {
//        				document.getElementById("location_del").setAttribute("maxLength", 7);	
        		} else {
        			document.getElementById("location_del").setAttribute("maxLength", 5);
        		}

        	}
    }
   	/**
     * 멀티콤보 항목을 설정한다.
     */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			
			switch(comboObj.id) {				
				case "f_cntr_tpsz_cd" :
				   	MultiSelect = true;
	            	MultiSeparator = ",";
	                ValidChar(2, 1);
	                InsertItem(0, 'All' ,'');
	                CheckIndex(0) = true;
	                break;
	                
				case "f_eq_itm" :
	                InsertItem(0, '' ,'');
					InsertItem(1, "Full Sea", "sea_dys");
					InsertItem(2, "Origin Rail", "org_rail_dys");
					InsertItem(3, "Dest Rail", "dest_rail_dys");
					InsertItem(4, "Full Land", "full_dmt");
					InsertItem(5, "MT POR", "org_mty_land_dys");
					InsertItem(6, "MT DEL", "dest_mty_land_dys");
					InsertItem(7, "MT SeaDay", "mt_sea_dys");
					Index(0);
					break;
			}
		}
	}

	/**
	 * Location by loc_cd 팝업에서 선택한 값 Setting.
	 */
	function popupFinishPor(aryPopupData, row, col, sheetIdx) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		formObject.location_por.value = aryPopupData[0][3]
	}

	/**
	 * Location by loc_cd 팝업에서 선택한 값 Setting.
	 */
	function popupFinishDel(aryPopupData, row, col, sheetIdx) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		formObject.location_del.value = aryPopupData[0][3]
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
//                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                Editable = true;//전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(1, 1, 1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                
                var HeadTitle   = "STS|TPSZ|POR|DEL|Full Land (Avg)|MT Land (Avg)|MT LAND ORG(Avg)|MT LAND DEST(Avg)";
                
                var headCount = ComCountHeadTitle(HeadTitle);
                                    
                InitColumnInfo(headCount, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                
                InitHeadMode(true, true, true, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]                    
                InitHeadRow(0, HeadTitle, true);
                //InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [   ROW, COL,   DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,  30,   daCenter,   false,   "ibflag");
                InitDataProperty(0, cnt++,  dtData,           80,   daCenter,    false,   "tpsz_cd",        false,      "",     dfNone,         0,   false,   false, 3);
                InitDataProperty(0, cnt++ , dtData,         150,   daCenter,   false,   "por_cd",  false,      "",     dfNone,         0,   false,   false, 5);
                InitDataProperty(0, cnt++ , dtData,         150,   daCenter,   false,   "del_cd",   false,      "",     dfNone,   0,   false,   false, 5);
                InitDataProperty(0, cnt++ , dtData,          150,   daRight,   false,   "full_dmt",          false,      "",     dfFloat,   2,   false,    false);
                InitDataProperty(0, cnt++ , dtData,          150,   daRight,   false,   "mt_land",          false,      "",    dfFloat,   2,   false,    false);
                InitDataProperty(0, cnt++ , dtData,          150,   daRight,   false,   "org_mty_land_dys",          false,      "",    dfFloat,   2,   false,    false);
                InitDataProperty(0, cnt++ , dtData,          150,   daRight,   false,   "dest_mty_land_dys",          false,      "",    dfFloat,   2,   false,    false);
                //dtHidden
                InitDataValid(0, "tpsz_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "por_cd", vtEngUpOnly);
                InitDataValid(0, "del_cd", vtEngUpOnly);

                CountPosition   = 0 ;
                sheetObj.style.height = 420; //style.height = GetSheetHeight(18) ;
            }
            break;   
            
            case 2:     //sheet1 init
                with (sheetObj) {
                    SheetWidth = mainTable.clientWidth;//전체 너비 설정
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                    Editable = true;//전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(1, 1, 1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle   = "STS|DEL|COST YRMON|TPSZ|POR|POL|POD|DEL|TS ROUTE|Lane|Full SEA|Origin Rail|Dest Rail|Full Land|MT Land|MT LAND\nORG|MT LAND\nDEST|MT SeaDay|DMT EXPT";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                                        
                    InitColumnInfo(headCount, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    
                    InitHeadMode(true, true, true, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]                    
                    InitHeadRow(0, HeadTitle, true);
                    //InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [   ROW, COL,   DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,   daCenter,   false,   "ibflag");
                    InitDataProperty(0,     cnt++ , dtDelCheck,	    40,	    daCenter,	false,	 "del_chk");
                    InitDataProperty(0, cnt++,  dtData,      100,   daCenter,   false,   "cost_yrmon",       true,      "",     dfDateYm,         0,   false,   true);
                    InitDataProperty(0, cnt++,  dtData,           50,   daCenter,    false,   "tpsz_cd",        true,      "",     dfNone,         0,   false,   true, 3);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false,   "por_cd",  true,      "",     dfNone,         0,   false,   true, 5);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,     false,   "pol_cd",  true,      "",     dfNone,         0,   false,   true, 5);
                    InitDataProperty(0, cnt++ , dtData,          60,   daCenter,   false,   "pod_cd",        true,      "",     dfNone,         0,   false,   true, 5);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,   false,   "del_cd",   true,      "",     dfNone,   0,   false,   true, 5);
                    InitDataProperty(0, cnt++ , dtData,         250,   daCenter,   false,   "ts_rout",   true,      "",     dfNone,   0,   false,   true);                                        
                    InitDataProperty(0, cnt++ , dtData,          60,   daCenter,   false,   "lane_cd",          false,      "",     dfNone,   0,   true,    true, 3);
                    InitDataProperty(0, cnt++ , dtData,          60,   daRight,   false,   "sea_dys",          false,      "",     dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "org_rail_dys",          false,      "",     dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "dest_rail_dys",          false,      "",     dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "full_dmt",          false,      "",     dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "mt_land",          false,      "",    dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "org_mty_land_dys",          false,      "",     dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "dest_mty_land_dys",          false,      "",    dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          90,   daRight,   false,   "mt_sea_dys",          false,      "",    dfFloat,   2,   true,    true);
                    InitDataProperty(0, cnt++ , dtData,          80,   daRight,   false,   "dys_dmt_expt_sea",          false,      "",    dfFloat,   2,   true,    true);
                    //dtHidden
                    InitDataValid(0, "tpsz_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "por_cd", vtEngUpOnly);
                    InitDataValid(0, "pol_cd", vtEngUpOnly);
                    InitDataValid(0, "pod_cd", vtEngUpOnly);
                    InitDataValid(0, "del_cd", vtEngUpOnly);
                    InitDataValid(0, "ts_rout", vtEngUpOther, "0123456789()-");
                    InitDataValid(0, "lane_cd", vtEngUpOther, "0123456789");

                    CellFontColor(0,"mt_land") = RgbColor(255,0,0);
                    CellFontColor(0,"full_dmt") = RgbColor(255,0,0);
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
    
    function sheet2_OnChange(sheetObj, row, col, value){
        var formObj = document.form;     
        
        if(sheetObj.ColSavename(col) == "org_mty_land_dys" || sheetObj.ColSavename(col) == "dest_mty_land_dys"){
        	sheetObj.CellValue2(row,"mt_land") = eval(sheetObj.CellValue(row, "org_mty_land_dys")) + eval(sheetObj.CellValue(row, "dest_mty_land_dys"));
        	sheetObj.CellValue2(row,"dys_dmt_expt_sea") = eval(sheetObj.CellValue(row, "sea_dys")) + eval(sheetObj.CellValue(row, "org_rail_dys")) + eval(sheetObj.CellValue(row, "dest_rail_dys")) + eval(sheetObj.CellValue(row, "mt_land"));        	
        } else if (sheetObj.ColSavename(col) == "sea_dys" || sheetObj.ColSavename(col) == "org_rail_dys" || sheetObj.ColSavename(col) == "dest_rail_dys" || sheetObj.ColSavename(col) == "mt_land") {
        	sheetObj.CellValue2(row,"dys_dmt_expt_sea") = eval(sheetObj.CellValue(row, "sea_dys")) + eval(sheetObj.CellValue(row, "org_rail_dys")) + eval(sheetObj.CellValue(row, "dest_rail_dys")) + eval(sheetObj.CellValue(row, "mt_land"));        	
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, loc) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

        switch(sAction) {

        case IBCLEAR:          //조회
	        sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0020GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");				
			}
			
			ComOpenWait(false);
			break;	

		case IBSEARCH:      //조회
				if(!validateForm(sheetObj, formObj, sAction)) return false;
	
	            // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				// Retrieve
	            formObj.f_cmd.value = SEARCH01;
	            var sParam = masFormQueryString(formObj);
	            sheetObj.DoSearch("ESM_MAS_0020GS.do", masFormQueryString(formObj));
	            ComOpenWait(false);
	            break;
                
        case IBSAVE: //저장           	
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_MAS_0020GS.do", masFormQueryString(formObj), -1, true);
			ComOpenWait(false);
			break;
                   
        case IBINSERT:      // 입력     
			sheetObj.DataInsert(-1);  
            break;
            
        case IBDELETE: // 삭제
//        	sheetObj.RowDelete(sheetObj.SelectRow, false);
        	var checkRow = sheetObj.FindCheckedRow("del_chk");            	
        	var checkRowArr = checkRow.split("|");
	    		if(checkRow!=null && checkRowArr.length>1){
	    			for(var i=checkRowArr.length-2;i>-1;i--){
 	    			sheetObj.RowHidden(checkRowArr[i]) = true;	 	    		
 	    		}
	    		}            	
            break;

    	case IBSEARCH_ASYNC02: //location focusOut
    		//if (validateForm(sheetObj, formObj, sAction)) {
    		if (loc == "por") {
	    		formObj.f_cmd.value = SEARCH02;
	    		document.form.inquiryLevel.value = document.getElementById("location_by_por").value.substring(0, 1);
	    		if (formObj.location_por.value == "") {
	    			return true;
	    		}
	    		if (formObj.inquiryLevel.value == "") {
	    			return false;
	    		}
	    		sheetObj.WaitImageVisible = false;
	    		formObj.location.value = formObj.location_por.value;
	    		var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
	    		var sCheck = ComGetEtcData(sXml, "check");
	    		
	    		if (sCheck != "OK") {
	    			var xLocationByPor = document.getElementById("location_by_por").value.substring(0, 1);
	    			if (document.form.location_por.value != "") {
	    				if (xLocationByPor == "R") {
	    					ComShowCodeMessage("MAS29031");
	    					document.form.location_por.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_por);
	    					return false;
	    				} else if (xLocationByPor == "L") {
	    					ComShowCodeMessage("MAS29032");
	    					document.form.location_por.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_por);
	    					return false;
	    				} else if (xLocationByPor == "E") {
	    					ComShowCodeMessage("MAS29033");
	    					document.form.location_por.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_por);
	    					return false;
//	    				} else if (xLocationByPor == "P") {
//	    					ComShowCodeMessage("MAS29010");
//	    					document.form.location_por.value = "";
//	    					sheetObj.WaitImageVisible = true;
//	    					ComSetFocus(document.form.location_por);
//	    					return false;
	    				} else if (xLocationByPor == "C") {
	    					ComShowCodeMessage("MAS29037");
	    					document.form.location_por.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_por);
	    					return false;
//	    				} else if (xLocationByPor == "S") {
//	    					ComShowCodeMessage("MAS29034");
//	    					document.form.location_por.value = "";
//	    					sheetObj.WaitImageVisible = true;
//	    					ComSetFocus(document.form.location_por);
//	    					return false;
//	    				} else if (xLocationByPor == "Y") {
//	    					ComShowCodeMessage("MAS29036");
//	    					document.form.location_por.value = "";
//	    					sheetObj.WaitImageVisible = true;
//	    					ComSetFocus(document.form.location_por);
//	    					return false;	
	    				}
	    			} else {
	    				return true;
	    			} // end if (document.form.location.value != "") {
	    		} // end if (sCheck != "OK") {
    		} else if (loc == "del") {
	    		formObj.f_cmd.value = SEARCH02;
	    		document.form.inquiryLevel.value = document.getElementById("location_by_del").value.substring(0, 1);
	    		if (formObj.location_del.value == "") {
	    			return true;
	    		}
	    		if (formObj.inquiryLevel.value == "") {
	    			return false;
	    		}
	    		sheetObj.WaitImageVisible = false;
	    		formObj.location.value = formObj.location_del.value;
	    		var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
	    		var sCheck = ComGetEtcData(sXml, "check");
	
	    		if (sCheck != "OK") {
	    			var xLocationByDel = document.getElementById("location_by_del").value.substring(0, 1);
	    			if (document.form.location_del.value != "") {
	    				if (xLocationByDel == "R") {
	    					ComShowCodeMessage("MAS29031");
	    					document.form.location_del.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_del);
	    					return false;
	    				} else if (xLocationByDel == "L") {
	    					ComShowCodeMessage("MAS29032");
	    					document.form.location_del.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_del);
	    					return false;
	    				} else if (xLocationByDel == "E") {
	    					ComShowCodeMessage("MAS29033");
	    					document.form.location_del.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_del);
	    					return false;
//	    				} else if (xLocationByDel == "P") {
//	    					ComShowCodeMessage("MAS29010");
//	    					document.form.location_del.value = "";
//	    					sheetObj.WaitImageVisible = true;
//	    					ComSetFocus(document.form.location_del);
//	    					return false;
	    				} else if (xLocationByDel == "C") {
	    					ComShowCodeMessage("MAS29037");
	    					document.form.location_del.value = "";
	    					sheetObj.WaitImageVisible = true;
	    					ComSetFocus(document.form.location_del);
	    					return false;
//	    				} else if (xLocationByDel == "S") {
//	    					ComShowCodeMessage("MAS29034");
//	    					document.form.location_del.value = "";
//	    					sheetObj.WaitImageVisible = true;
//	    					ComSetFocus(document.form.location_del);
//	    					return false;
//	    				} else if (xLocationByDel == "Y") {
//	    					ComShowCodeMessage("MAS29036");
//	    					document.form.location_del.value = "";
//	    					sheetObj.WaitImageVisible = true;
//	    					ComSetFocus(document.form.location_del);
//	    					return false;	
	    				}
	    			} else {
	    				return true;
	    			} // end if (document.form.location.value != "") {
	    		} // end if (sCheck != "OK") {    		    			
    		}
    		sheetObj.WaitImageVisible = true;
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
    	//버튼별 체크
        switch (sAction) {	  		
	        case IBSEARCH: // 조회 
		        with(formObj){
		      		if (!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
		      			return;
		  	  		}
		      		
		      		if (location_por.value == "") {
		      			ComShowCodeMessage("MAS00013","POR"); //Location by는 필수입력
//		      			ComShowMessage(ComGetMsg("MAS00013"),"(POR)"); //Location by는 필수입력
	      				ComSetFocus(document.form.location_por);
		      			return;
		      		}
		      		if (location_del.value == "") {
		      			ComShowCodeMessage("MAS00013","DEL"); //Location by는 필수입력
	      				ComSetFocus(document.form.location_del);
		      			return;
		      		}		      		
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

    function obj_blur_por() {
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02,"por");
    }

    function obj_blur_del() {
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02,"del");
    }
    
    /**
     * Type/Size 콤보를 클릭할 때 전체체크
     * @param comboObj
     * @param index
     * @param code
     * @return
     */
    function f_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if (code == "" || code == "All") {
    		var bChk = comboObj.CheckIndex(index);
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = bChk;
        	}
       }else{
       	comboObj.CheckIndex(0) = false;
       }
    }
    
    function f_eq_itm_OnChange(){
    	if (document.form.f_eq_itm.Text == "") {
    		document.form.f_eq_days.value = "";
    	}
    }