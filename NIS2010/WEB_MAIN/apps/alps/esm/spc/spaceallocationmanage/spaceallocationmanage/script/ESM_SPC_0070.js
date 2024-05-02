/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0070.js
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.01 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================*/
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
     * @class ESM_SPC_0070 : ESM_SPC_0070 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0070() {
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
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';
    var init_month = ''; 
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             var sheetObject1 = sheetObjects[1];
             /*******************************************************/
             var formObject = document.form;

        	//try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
       	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
        	            break;
        	            
    				case "btn_new":
    					if(checkModifiedSheet(sheetObjects)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//공통함수사용: 화면을 초기화
    					resetAll();

    					formObject.year.value = init_year;
    					formObject.week.value = init_week;
    		    		formObject.month.value = init_month;
    		    		SpcSearchOptionWeek("week",true,document.form.year.value);
    		    		
						SpcSearchOptionTrade("trade", true, true);
        				SpcSearchOptionLane("lane"); // 0207 SHKIM    
    					break;
    					
            	    case "btn_save":
            	    	doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
            	        break;
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
            	        break;

    			} // end switch
        	//}catch(e) {
        	//	if( e == "[object Error]") {
        	//		ComShowCodeMessage("COM12111");
        	//	} else {
        	//		ComShowMessage(e);
        	//	}
        	//}
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
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
    		comObjects[comboCnt++] = combo_obj;
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
         * tab1_OnChange 
         * 
         */
        function tab1_OnChange(tabObj , nItem)
        {
    	    var formObj = document.form;
    	   
            var objs = document.all.item("tabLayer");
        	objs[nItem].style.display = "Inline";
        	objs[beforetab].style.display = "none";

        	//--------------- 여기가 중요--------------------------//
        	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab= nItem;
    		//if(!check_retrive) 
    		return;
            if(beforetab==0){
            	searchSummary(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
            }else if(beforetab==1){
            	searchByTrade(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
            }        
        }
        
    	/*
    	 * 입력한 Office값 체크
    	 */
    	 function office_onchange() {
    	 	var obj = event.srcElement;
        	var value = obj.value;
        	value = value.trim();
        	
        	if(value.length>0){
    			if(value.length<5){
    				ComShowMessage(getMsg("SPC90116", "Office"));
    				obj.focus();
    				return false;
    			}else{
    				var rtn = getCodeList("Office", "ofc_cd="+value);
    		    	if(rtn[0] == ""){    		
    		    		ComShowMessage(getMsg("SPC90106", value));
    		    		obj.focus();
    		    		return false;
    		    	}	
    			}
        	}
        	return true;
        }
    	
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	SpcSearchOptionYear("year");
        	SpcSearchOptionMonth("month", true);
        	SpcSearchOptionWeek("week",true);
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionLane("lane");
        	
            tab_retrives = new Array(sheetObjects.length);
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetResizeFull = true;
    		document_onresize();

    		for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            var formObject = document.form;
        	formObject.year.focus();

        	init_year = formObject.year.value;	//년 초기화용
        	init_week = formObject.week.value;	//주차 초기화용
    		init_month = formObject.month.value;	//월 초기화용

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
                        InsertTab( cnt++ , "Adjustment" , -1 );
                        InsertTab( cnt++ , "Download Date" , -1 );
                    }
                 break;

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

                case 1:      //sheet1 init
    				initSheet1(sheetObj);
                    break;
                case 2:      //sheet1 init
    				initSheet2(sheetObj);
                    break;
            }
        }
        
    	/**
         * TabSheet1에서 조회후 타이틀 변경
         */
    	function initSheet1(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	            //style.height = 300 ;
    	            style.height = getSheetHeight(18);

    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msAll;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = true;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 2, 1, 9, 100);
    				
    	            var columnCount = 28;
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(columnCount, 0 , 0, false);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;

    	            var HeadTitle1 = "Trade|Lane|Week|VVD|RHQ/Area|Office|POL|F'cast|F'cast|BKG|Alloc|Alloc|Diff/Shortfall|Ratio";
    	            var HeadTitle2 = "Trade|Lane|Week|VVD|RHQ/Area|Office|POL|Original|Revised|BKG|Original|Revised|Diff/Shortfall|Ratio";

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
    	            InitHeadRow(1, HeadTitle2, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    45,    daCenterTop,   true,    "trade",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    55,    daCenterTop,   true,    "rlane_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "week",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "vvd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "area",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    52,    daCenterTop,   true,    "sls_ofc_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    52,    daCenter,   true,    "pol_yd_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    78,    daRight ,   true,    "Fcast",     false,          "",       dfInteger,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    78,    daRight ,   false,    "fcast_lod_qty",     false,          "",       dfInteger,       0,     true,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    78,    daRight ,   true,    "BKG",     false,          "",       dfInteger,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    78,    daRight ,   true,    "Alloc",     false,          "",       dfInteger,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    78,    daRight ,   false,    "aloc_lod_qty",     false,          "",       dfInteger,       0,     true,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    80,    daRight ,   true,    "NoShow",     false,          "",       dfInteger,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    60,    daRight ,   true,    "Ratio",     false,          "",       dfNone,       2,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daCenter,   true,    "aloc_ddct_bse_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daCenter,   true,    "ofc_knd_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daCenter,   true,    "dir_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daCenter,   true,    "vsl_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daCenter,   true,    "skd_voy_no",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    1,    daCenter,   true,    "skd_dir_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHiddenStatus ,    1,    daCenter,   true,    "ibflag",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    20,    daCenter,   true,    "lvl1",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    20,    daCenter,   true,    "lvl2",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    20,    daCenter,   true,    "lvl3",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    20,    daCenter,   true,    "lvl4",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    20,    daCenter,   true,    "lvl5",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,   50,    daLeft,   true,    "lvl",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     false,       false);
    				

    	            EditableColor         = RgbColor(255,255,128);    //Default:255,255,255, 흰색 Edit 가능 데이터 배경색
    	            UnEditableColor       = RgbColor(255,255,255);   //Default:239,235,239, 회색 Edit 불가능 데이터 배경색

    				InitTreeInfo(columnCount - 2, "sLevel", RgbColor(0,0,255), false);
    	            var color = RgbColor(222, 251, 248);
                    RangeBackColor(1, 7, 1, 8) = color;
                    RangeBackColor(1, 10, 1, 11) = color;
                   	MinimumValue(0, "fcast_lod_qty") = 0;
                   	MinimumValue(0, "aloc_lod_qty") = 0;
    	       }
    	}
    	
        /**
         * TabSheet2에서 조회후 타이틀 변경
         */
    	function initSheet2(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	            if(!check_retrive){
    	            	//style.height = 322 ;
    	            	style.height = getSheetHeight(18) + 18;
    	            }
    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    				CountPosition = 0;
    				
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msPrevColumnMerge;
    	
    	          //전체Edit 허용 여부 [선택, Default false]
    	            Editable = true;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 1, 1, 9, 100);
    				
    	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(8, 0 , 0, false);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;
    	
    	            var HeadTitle1 = "Month|Date|Day|Last Exe Date";

    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, HeadTitle1, true);
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtData ,    150,    daCenter,   true,    "month",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtComboEdit ,    150,    daCenter,   true,    "dwn_lod_dy",     false,          "",       dfNone,       0,     true,       false);
    	            InitDataProperty(0, cnt++ , dtCombo ,    150,    daCenter,   true,    "week",     false,          "",       dfInteger,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    150,    daCenter,   true,    "exe_dt",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    150,    daCenter,   true,    "sweek",     false,          "",       dfInteger,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHidden ,    150,    daCenter,   true,    "bse_yrmon",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtHiddenStatus ,    150,    daCenter,   true,    "ibflag",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "",     false,          "",       dfNone,       0,     false,       false);
    				InitDataCombo(0, 2, "SUN|MON|TUE|WED|THU|FRI|SAT", "0|1|2|3|4|5|6");
    	       }
    	}
        
    	function t1sheet1_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "rlane_cd":
        	case "week":
        	case "area":
        	case "sls_ofc_cd":
        	case "pol_yd_cd":
    			var mark = sheetObj.CellValue(row, col);
    			if(mark == "+" || mark == "-"){
    				toggleExpand(sheetObj, row, col);
    			}
    			break;
    		}
       	}
       	
       	function toggleExpand(sheetObj, row, col){
    		var mark = sheetObj.CellValue(row, col);
    		if(sheetObj.RowExpanded(row)){
    			sheetObj.RowExpanded(row) = false;
    			cellChangeValue(sheetObj, row, col, "+");
    		}
    		else{
    			sheetObj.RowExpanded(row) = true;
    			cellChangeValue(sheetObj, row, col, "-");
    		}
       	}

    	function cellChangeValue(sheetObj, row, col, value){
    		var status = sheetObj.RowStatus(row);
    		sheetObj.CellValue2(row, col) = value;
    		sheetObj.RowStatus(row) = status;
    	}

    	function changePeriod(){
    		var obj = event.srcElement;
    		if(obj.selectedIndex == 0) return;
    		switch(obj.name){
    		case "month":
    			obj.form.week.selectedIndex = 0;
    			break;
    		case "week":
    			obj.form.month.selectedIndex = 0;
    			break;
    		}
    	}
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;		
    		
            switch(sAction) {
    			
               case IBSEARCH:      //조회
                    var sheetObj = sheetObjects[beforetab];
    				
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  

                    if(beforetab==0){
                    	searchAdjustment(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                    }else if(beforetab==1){
                    	searchDownloadDate(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                    }

    				break;

                case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
//                    var rtn = doSaveSheet(sheetObj, "ESM_SPC_0070GS.do", "f_cmd="+(MULTI01 + beforetab)+"&"+FormQueryString(formObj));
    				  var rtn = doSaveSheet(sheetObj, "ESM_SPC_0070GS.do", "f_cmd="+(MULTI01 + beforetab));
    				break;
               case IBDOWNEXCEL:        //엑셀 다운로드              
                  sheetObj.Down2Excel(-1, false, false, true);
                  break;
            }
        }
    	
    	function searchAdjustment(sheetObj, formObj, command){
    		var param = SpcFormString(formObj,'type,year,month,week,rhq,office,trade,lane,vvd');
//    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+FormQueryString(formObj));
    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+ param );
    		
    	}

    	function searchDownloadDate(sheetObj, formObj, command){
    		var param = SpcFormString(formObj,'type,year,month,week,rhq,office,trade,lane,vvd');
//    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+FormQueryString(formObj));
    		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0070GS.do", "f_cmd="+command+"&"+ param );
    	}
    	
    	var selectedCell_OldValue = 0;
        function t1sheet1_OnSelectCell(sheetObj, orow, ocol, row, col){
        	selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
        }
      	function t1sheet1_OnChange(sheetObj, row, col, value){
      		var rlvl = sheetObj.CellValue(row, "lvl") * 1;
      		var bkg = sheetObj.CellValue(row, "BKG") * 1;
      		var fct = sheetObj.CellValue(row, "fcast_lod_qty") * 1;
      		var alc = sheetObj.CellValue(row, "aloc_lod_qty") * 1;
      		var sf = 0;
      		var rt = 0;
      		if(fct < alc){
      			alc = fct;
      		}
      		if(bkg <= alc){
      			sf = alc - bkg;
      			if(fct == 0){
      				rt = "000%";
      			}
      			else{
    	  			rt = Math.round(sf / fct * 10000) + "%";
    	  		}
      			var len = rt.length;
      			rt = rt.substring(0, len-3)+"."+rt.substring(len-3, len);
      			sheetObj.CellValue2(row, "NoShow") = sf;
      			sheetObj.CellValue2(row, "Ratio") = rt;
      		}
      		//if(rlvl < 6) 
      			return;
      		var dif = value * 1 - selectedCell_OldValue;
      		for(var i = 1 ; i <= 5 ; i++){
      			var rrow = row - sheetObj.CellValue(row, "lvl"+i) * 1;
      			var rlvl = sheetObj.CellValue(rrow, "lvl") * 1;
//    			alert(i + ":" + rlvl + ":" + rrow + ":" + dif);
      			if(rlvl == i){
      				sheetObj.CellValue(rrow, col) = sheetObj.CellValue(rrow, col) * 1 + dif;
      			}
      		}
      		selectedCell_OldValue = value;
      	}
      	function t1sheet2_OnChange(sheetObj, row, col, value){
      		var sweek = sheetObj.CellValue(row, "sweek") * 1;
      		var d = (value * 1 + sweek - 1) % 7;
      		sheetObj.CellValue2(row, "week") = d;
      	}
      	/*
    	 * trade변경시
    	 */
    	function trade_OnChange(comObj,value,text ){
    	    //lane value change
    	    comObjects[1].Index2 = 0;        
    	    SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
      	} 
        	
        
        /*
    	 * lane변경시
    	 */
       	function lane_OnChange(comObj,value,text ){
    	    var trade = comObj.GetText(value,0);
    	    if(value != "" ){    	
    		   	comObjects[0].Code2 = trade;
    	    }
       	}  
        
         
        
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){

            switch(sAction) {
    			
               case IBSEARCH:      //조회
    		    	if(beforetab != 0) return true;
    				var month = formObj.month.value;
    				var week = formObj.week.value;
//    				var rhq = comObjects[0].Code;
    				var rhq = formObj.rhq.value;
    				var vvd = formObj.vvd.value;
    				if(vvd == "" && month == "" && week == ""){
    					ComShowCodeMessage("COM12139", "Month", "Week");
    					formObj.month.focus();
    					return false;
    				}
    				if(rhq == ""){
    					ComShowCodeMessage("COM12113", "RHQ");
    					formObj.rhq.focus();
    					return false;
    				}
    				if(vvd != "" && vvd.length < 9){
    					ComShowCodeMessage("COM12174", "VVD", "9");
    					formObj.vvd.focus();
    					return false;
    				}
    		        return true;
    		    break;
    		}
    		return true;
        }


    	function initDataValue_trade(){
        	var sheetObj = document.getElementById("trade");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        
        function initDataValue_rhq(){
        	var sheetObj = document.getElementById("rhq");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        
        function initDataValue_lane(){
        	var sheetObj = document.getElementById("lane");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }  
        
        /**
         * Start Week 의 year 변경시
         * Start Week 의 year 변경시 주차 변경
         */
        function checkWeek(){
        	SpcSearchOptionWeek("week",true,document.form.year.value);
        }        
	/* 개발자 작업  끝 */
        