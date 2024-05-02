/*=========================================================
 * History
 * 2008.02.26 PEJ N200802220016 MAS 조회 기간 관련 수정 요청
 *                2007.07, 2007.27 이전 데이터를 조회 할수 없도록 함
 * 2008.02.21 PEJ N200802280015 MAS_Report 관련 수정 요청_1,2번항목  
 *                1. Monthly Average U/C[057] 
 *                - RA 기준 추가, Term 조건 추가
 *                - Sheet 각각에 Total 값추가
 *                - Profit Level을 OP를 선택했을때 OP항목에 해당하는 컬럼을 보여줌(동적으로)
 * 
 * 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]
 * 2009.10.12 김기식 Alps전환작업
 * 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
 * 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
 * 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
=========================================================*/

   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_MAS_0057 : ESM_MAS_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0057() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		var sheetObject = sheetObjects[0];
    		var sheetObject1 = sheetObjects[1];


    		/*******************************************************/
    		var formObject = document.form;

    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			
    			switch(srcName) {
    				
    				case "btn_retrieve":
    					//origin-dest선택시(por-del)    					
    					if(formObject.f_kind[1].checked) {    					
    						doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    					} else {    						
    						doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					}
    					break;

    				case "btn_new":
    					sheetObject.RemoveAll();
    					sheetObject1.RemoveAll();
    					formObject.reset();
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_routedetail":
    					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
    					break;

    				case "btng_bkgdetail":
    					location.href="./UI_ESM_MAS_032.html" ;
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

    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {
    		loadingMode = true; 
	    	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    	 
	        // 멀티콤보 처리 (시작) ---------------------------------------------
	        for(k=0;k<comboObjects.length;k++){
	            initCombo(comboObjects[k], k+1);
	        }
	        // 멀티콤보 처리 (종료) ---------------------------------------------
	     
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
	        loadingMode = false;
    	}
    	 /**
	     * 멀티콤보 처리
	     * - Tab 기본 설정
	     * - 탭의 항목을 설정한다.
	     */
	    function initCombo (comboObj, comboNo) {
	    	 with (comboObj) {
		    	 switch(comboObj.id) {
		    	 	case "f_cntr_tpsz_cd":
		    	 		IMEMode = 0;
		    	 		ValidChar(2, 1);
		    	 		MaxLength = 4;
		    	 		break;
		    	 }
	        	DropHeight = 300;
	        	Index = 0;
	        }
	    } 
	     
    	/**
    	* 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {

    		var cnt = 0;

    		switch(sheetNo) {
    			case 1:		//sheet1 init
    				with (sheetObj) {

    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    					Editable = false;//전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitColumnInfo(16, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(false, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

    					var HeadTitle = "Grouped By|Revenue POL - POD|Revenue POL - POD|Revenue POL - POD|TP/SZ|CM Per Box|CM Per Box|CM Per Box|OP Per Box|OP Per Box|Vol.|CM Performance|CM Performance|CM Performance|OP Performance|OP Performance" ;
    					var HeadTitle1 = "Grouped By|POL|POD|R.Lane|TP/SZ|G.RPB|Cost|CMB|Cost|OPB|Vol.|G.Rev|Cost|CM|Cost|OP" ;

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, false);

    					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"",				false,	"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"rev_pol_cd",	false,	"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"rev_pod_cd",	false,	"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"rlane_cd",		false,	"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"tpsz_code",	false,	"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"grpb",			false,	"|rev|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"cmcost",		false,	"|cm_cost|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"cmb",			false,	"|cm|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"opcost",		false,	"|op_cost|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"opb",			false,	"(|cm|-|op_cost|)/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"load",			false,	"",				dfFloatOrg,	0);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"rev",			false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"cm_cost",		false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"cm",			false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"op_cost",		false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	100,daRight,	true,	"op",			false,	"",				dfFloatOrg,	2);

    					RangeBackColor(1, 1, 1, 3) = RgbColor(222, 251, 248);  // ENIS
    					RangeBackColor(1, 5, 1, 9) = RgbColor(222, 251, 248);
    					RangeBackColor(1, 11, 1, 15) = RgbColor(222, 251, 248);

    					HeadRowHeight = 10 ;
    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(7) ;
    					changeViewColumn();
    				}
    				break;
    			case 2:		//sheet2 init
    				with (sheetObj) {

    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    					Editable = false;//전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitColumnInfo(27, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(true, true, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

    					var HeadTitle = "Group By|Origin|Dest.|1st Lane|1st Lane|1st Lane|2nd Lane|2nd Lane|2nd Lane|3rd Lane|3rd Lane|3rd Lane|4th Lane|4th Lane|4th Lane|TP / SZ|CM Per Box|CM Per Box|CM Per Box|OP Per Box|OP Per Box|Vol.|CM Performance|CM Performance|CM Performance|OP Performance|OP Performance" ;
    					var HeadTitle1 = "Group By|Origin|Dest.|Lane|POL|POD|Lane|POL|POD|Lane|POL|POD|Lane|POL|POD|TP / SZ|G.RPB|Cost|CMB|Cost|OPB|Vol.|G.Rev|Cost|CM|Cost|OP" ;

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, false);

    					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtHidden,		90,	daCenter,	true,	"",					false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"bkg_por_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"bkg_del_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n1st_rlane_cd",	false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n1st_pol_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n1st_pod_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n2nd_rlane_cd",	false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n2nd_pol_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n2nd_pod_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n3rd_rlane_cd",	false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n3rd_pol_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n3rd_pod_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n4th_rlane_cd",	false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n4th_pol_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"n4th_pod_cd",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"tpsz_code",		false,			"",				dfNone,		0);
    					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"grpb",			false,	"|rev|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"cmcost",		false,	"|cm_cost|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"cmb",			false,	"|cm|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"opcost",		false,	"|op_cost|/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"opb",			false,	"(|cm|-|op_cost|)/|load|",	dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"load",			false,	"",				dfFloatOrg,	0);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"rev",			false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"cm_cost",		false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"cm",			false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"op_cost",		false,	"",				dfFloatOrg,	2);
    					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"op",			false,	"",				dfFloatOrg,	2);

    					RangeBackColor(1, 3, 1, 14) = RgbColor(222, 251, 248);  // ENIS
    					RangeBackColor(1, 16, 1, 20) = RgbColor(222, 251, 248);  // ENIS
    					RangeBackColor(1, 21, 1, 26) = RgbColor(222, 251, 248);  // ENIS

    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(9) ;
    					changeViewColumn();
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
	     * IBCombo Object를 배열로 등록
	     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	     * 배열은 소스 상단에 정의
	     */
	    function setComboObject(combo_obj){
	        comboObjects[comboCnt++] = combo_obj;
	    } 
    	function InvOnChange( dst , mod_sheet, mod_term){
    		//sheet1, sheet2 remove
    		sheetObjects[0].RemoveAll();
    		sheetObjects[1].RemoveAll();
    		document.getElementById(dst).style.display = mod_sheet;
    		document.getElementById("term_div").style.display = mod_term;
    	}

        /**
         * sheet1을 조회하고 나서 마지막에 Total 항목을 다시 계산한다
         */
        function sheet1_OnSearchEnd(sheetObj, errMsg){
            if(eval(sheetObj.SumValue(0, "load")) > 0){
                sheetObj.SumValue(0, "grpb")   = eval(sheetObj.SumValue(0, "rev")       + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmcost") = eval(sheetObj.SumValue(0, "cm_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmb")    = eval(sheetObj.SumValue(0, "cm")        + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opcost") = eval(sheetObj.SumValue(0, "op_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opb")     = eval("("  + sheetObj.SumValue(0, "cm") + "-" + sheetObj.SumValue(0, "op_cost")+ ")/" + sheetObj.SumValue(0, "load")).toFixed(2);
            } else {
                sheetObj.SumValue(0, "grpb")   = "0";
                sheetObj.SumValue(0, "cmcost") = "0";
                sheetObj.SumValue(0, "cmb")    = "0";
                sheetObj.SumValue(0, "opcost") = "0";
                sheetObj.SumValue(0, "opb")    = "0";
            }
        }

        /**
         * sheet2을 조회하고 나서 마지막에 Total 항목을 다시 계산한다
         */
        function sheet2_OnSearchEnd(sheetObj, errMsg){
            if(eval(sheetObj.SumValue(0, "load")) > 0){
                sheetObj.SumValue(0, "grpb")   = eval(sheetObj.SumValue(0, "rev")       + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmcost") = eval(sheetObj.SumValue(0, "cm_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmb")    = eval(sheetObj.SumValue(0, "cm")        + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opcost") = eval(sheetObj.SumValue(0, "op_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opb")    = eval("("  + sheetObj.SumValue(0, "cm") + "-" + sheetObj.SumValue(0, "op_cost")+ ")/" + sheetObj.SumValue(0, "load")).toFixed(2);
            } else {
                sheetObj.SumValue(0, "grpb")   = "0";
                sheetObj.SumValue(0, "cmcost") = "0";
                sheetObj.SumValue(0, "cmb")    = "0";
                sheetObj.SumValue(0, "opcost") = "0";
                sheetObj.SumValue(0, "opb")    = "0";
            }
        }

    	/**
    	* location code 공통 팝업 오픈
    	*/
    	function openLocationCode(funtionNm){
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490,	funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1', true);
    	}

    	//from 팝업화면(Location)에서 사용
    	function getF_from(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_from.value = colArray[3];
    		document.form.f_to.focus();
    	}

    	//to 팝업화면(Locaton)에서 사용
    	function getF_to(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_to.value = colArray[3];
    		document.form.f_cntr_tpsz_cd.focus();
    	}

    	/**
    	* sheet1을 더블클릭하여 상세조회한다
    	*/
    	function sheet1_OnDblClick(sheetObj , row, col){
    		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
    	}
    	
    	function f_pro_vw_OnChange(obj, code){
   	   	 	if (loadingMode == true) return; 
   	   	 	changeViewColumn();
	   	   	if (code == "R") {
				document.form.f_pro_lvl.DeleteItem("O");
				document.form.f_pro_lvl.Code = "C";
			} else {
				document.form.f_pro_lvl.InsertItem(-1, "OP", "O");
			}
    	}
    	function f_pro_lvl_OnChange(obj, code){
   	   	 	if (loadingMode == true) return; 
   	   	 	changeViewColumn();
    	}
        /**
         * Profit Level에 따라서 컬럼을 보여준다
         */
        function changeViewColumn(){
            var sheetObj = sheetObjects[0];
            var sheetObj2 = sheetObjects[1];
            var formObj = document.form;
            
        	if (ComGetObjValue(formObj.f_pro_lvl) == "O" && ComGetObjValue(formObj.f_pro_vw) == "P"){
                sheetObj.ColHidden("opcost")  = false;
                sheetObj.ColHidden("opb")     = false;
                sheetObj.ColHidden("op_cost") = false;
                sheetObj.ColHidden("op")      = false;
                
                sheetObj2.ColHidden("opcost")  = false;
                sheetObj2.ColHidden("opb")     = false;
                sheetObj2.ColHidden("op_cost") = false;
                sheetObj2.ColHidden("op")      = false;
            } else {
                sheetObj.ColHidden("opcost")  = true;
                sheetObj.ColHidden("opb")     = true;
                sheetObj.ColHidden("op_cost") = true;
                sheetObj.ColHidden("op")      = true;
                
                sheetObj2.ColHidden("opcost")  = true;
                sheetObj2.ColHidden("opb")     = true;
                sheetObj2.ColHidden("op_cost") = true;
                sheetObj2.ColHidden("op")      = true;
            }
                
        }
        
        // Sheet관련 프로세스 처리
		function doActionIBSheet(sheetObj, formObj, sAction) {
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
				case IBCLEAR: //조회
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0057GS.do", masFormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
					if (arrXml.length > 1)
						ComXml2ComboItem(arrXml[1], formObj.f_pro_vw, "code", "name");
					if (arrXml.length > 2)
						ComXml2ComboItem(arrXml[2], formObj.f_pro_lvl, "code", "name");
					if (arrXml.length > 3)
						ComXml2ComboItem(arrXml[3], formObj.f_rcv_term, "code", "name");
					if (arrXml.length > 4)
						ComXml2ComboItem(arrXml[4], formObj.f_de_term, "code", "name");
					ComOpenWait(false);
					break;
				case IBSEARCH: //조회
					if (validateForm(sheetObj, formObj, sAction)) {
						// 업무처리중 버튼사용 금지 처리
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCHLIST01;
						sheetObj.DoSearch4Post("ESM_MAS_0057GS.do", masFormQueryString(formObj));
						ComOpenWait(false);
						break;
					}
					break;
		
				case IBDOWNEXCEL: //엑셀 다운로드
					sheetObj.Down2Excel(-1, false, false, true);
					break;
		
			}
		}

    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    			case IBSEARCH:		//조회
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = SEARCHLIST02;
    				if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
    					var cond = '';
    					var row = sheetObjects[0].SelectRow;
    					cond = cond + "&f_pol=" +sheetObjects[0].CellValue(row, "rev_pol_cd")
    							+ "&f_pod=" +sheetObjects[0].CellValue(row, "rev_pod_cd")
    							+ "&f_rlane=" +sheetObjects[0].CellValue(row, "rlane_cd")
    							+ "&f_tpsz=" +sheetObjects[0].CellValue(row, "tpsz_code");
    					sheetObj.DoSearch4Post("ESM_MAS_0057GS.do",masFormQueryString(formObj)+ cond);
    				} else {
    					sheetObj.DoSearch4Post("ESM_MAS_0057GS.do",masFormQueryString(formObj));
    				}
    				ComOpenWait(false);
    				break;

    			case IBDOWNEXCEL:		//엑셀 다운로드
    				sheetObj.Down2Excel(-1, false, false, true);
    				break;
    		}
    	}
    	
    	/**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		var rt = false;
    		
    		if(ComIsNull(formObj.f_from)) {
    			ComShowCodeMessage('COM12113', 'From');
    			ComSetFocus(formObj.f_from);
    		} else if(ComIsNull(formObj.f_to)) {
    			ComShowCodeMessage('COM12113', 'To');
    			ComSetFocus(formObj.f_to);
    		} else if(ComIsNull(formObj.f_cost_yrmon )){
    			ComShowCodeMessage('COM12113', 'YYYY-MM');
    			ComSetFocus(formObj.f_cost_yrmon);    			
    		} else {
    			rt = true;
    		}
    		
    		if(ComParseInt(ComReplaceStr(formObj.f_cost_yrmon.value,"-","")) < 200707){
    		    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
    		    ComShowCodeMessage("MAS10037");
    		    return false;
    		}
    		return rt;
    	}
       
               
	/* 개발자 작업  끝 */