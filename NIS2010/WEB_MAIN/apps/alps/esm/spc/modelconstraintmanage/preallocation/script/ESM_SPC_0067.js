/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0067.js
*@FileTitle : Pre-Allocation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
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
     * @class ESM_SPC_0067 : ESM_SPC_0067 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0067() {
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
    
    
    var retrieved = false;

    var init_year = ''; 
    var init_month = ''; 
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		 var sheetObject = sheetObjects[0];

    		 /*******************************************************/
    		 var formObject = document.form;

    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btn_retrieve":
     					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)){
    						if(ComShowConfirm (getMsg("SPC90001")) != 1){
    						   return;
    						}
    	    			}
    					//공통함수사용: 화면을 초기화
    					resetAll();
    					retrieved = false;
    					
    					formObject.year.value = init_year;
    		    		formObject.month.value = init_month;    					
    					break;

    				case "btn_save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    				case "btn_rowadd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
    					break;


    			} // end switch
    		}catch(e) {
    			if( e == "[object Error]") {
    				ComShowCodeMessage("COM12111");
    			} else {
    				ComShowMessage(e);
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
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){

           comObjects[comboCnt++] = combo_obj;


        }

    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {
        	SpcSearchOptionYear("year");
        	SpcSearchOptionMonth("month", true);
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionTrade("toTrade", true, true);
        	SpcSearchOptionBound("bound",false,true,false);

        	
    		for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		var sheetResizeFull = true;
    		document.form.year.focus();

        	init_year = document.form.year.value;	//년 초기화용
    		init_month = document.form.month.value;	//주차 초기화용
    		
    		initSheetCombo();	//시트 콤보 초기 세팅
    	}
    	
    	/* Sheet Combo Setting Start */
    	function initSheetCombo() {
    		initSheetCombo_month();
    		initSheetCombo_rep_trade();
    		initSheetCombo_lane();
    		initSheetCombo_bound("dir_cd");
    		initSheetCombo_bound("to_dir_cd");
    	}  
    	
    	function initSheetCombo_month() {
    		var sheetObject  = sheetObjects[0];
            
            var mon = " |01|02|03|04|05|06|07|08|09|10|11|12";
            sheetObject.InitDataCombo(0, "bse_mon", mon, mon);
    	}
    	
    	function initSheetCombo_rep_trade() {
    		var sheetObject  = sheetObjects[0];
            var rtn = getCodeXmlList("TradeCombo", "isRepTrade=false&del=");
            
            var arrData = ComXml2ComboString(rtn, "trd_cd", "trd_nm");
            
            if (arrData != null){
                var arrCode = arrData[0].split("|");
                var arrName = arrData[1].split("|");
                var conData = "";
                for(i=0; i < arrName.length;i++){
                    if(i==0){
                        arrName[i] = arrCode[i]+"\t"+arrName[i];
                    }else{
                        arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                    }
                    conData = conData.concat(arrName[i]);
                }
                arrData[1] = conData;
            }
            arrData[0] = " |" + arrData[0];
            arrData[1] = " |" + arrData[1];
            sheetObject.InitDataCombo(0, "to_trd_cd", arrData[1], arrData[0]);
    	}
    	
        var rlaneCdData0;
        var rlaneCdData1;
    	function initSheetCombo_lane() {
    		var sheetObject  = sheetObjects[0];
            
            var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=");
            
            var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
            arrData[0] = "00000|" + arrData[0];
            arrData[1] = "\t\tALL\t|" + arrData[1];

            rlaneCdData0 =arrData[0];
            rlaneCdData1 =arrData[1];
            
            sheetObject.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
    	}

    	function initSheetCombo_bound(strDirCd) {
    		var sheetObject  = sheetObjects[0];
            
            var bound = " |E|W|S|N";
            sheetObject.InitDataCombo(0, strDirCd, bound, bound);
    	}    	
    	
    	function getSheetCombo_lane(){
    		var data = new Array();
    		data[0] = rlaneCdData0;
    		data[1] = rlaneCdData1;
    		return data
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
    					// 높이 설정
    					//style.height = 330 ;
    					style.height = GetSheetHeight(22) ;
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = true;
                        FocusEditMode = default_edit_mode;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 10, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(13, 0 , 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "Del.|STS|SEQ|Year|Month|Rep Trade|Lane|Bound|Vessel Size|Port|Allocation(TEU)|To Trade|To Bound";
//    					var HeadTitle1 = "Del.|STS|SEQ|Year|Month|Rep\nTrade|Lane|Bound|Vessel\nSize|From|To|Allocation(TEU)|To\nTrade|To\nBound";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
//    					InitHeadRow(1, HeadTitle1, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true );
    					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",        false,"",   dfNone,          0,       true,       true);
    					InitDataProperty(0, cnt++ , dtDataSeq,    35,    daCenter,   true,    "",              false,"",   dfNone,          0,       true,       true);
    					InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,   true,    "bse_yr",        true, "",   dfNone,          0,       false,       true,	4);
    					InitDataProperty(0, cnt++ , dtComboEdit,  60,    daCenter,   true,    "bse_mon",       true, "",   dfNone,          0,       false,       true,	2);
    					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   true,    "rep_trd_cd",    false,"",   dfNone,          0,       false,       false,	3);
    					InitDataProperty(0, cnt++ , dtComboEdit,  80,    daCenter,   true,    "rlane_cd",      true, "",   dfNone,          0,       false,      true,	5);
    					InitDataProperty(0, cnt++ , dtComboEdit,  80,    daCenter,   true,    "dir_cd",        true, "",   dfNone,          0,       false,       true,	1);
    					InitDataProperty(0, cnt++ , dtComboEdit,  100,    daCenter,   true,    "vsl_clss_capa", true, "",   dfInteger,       0,       false,       true);
    					InitDataProperty(0, cnt++ , dtPopupEdit,  60,    daCenter,   true,    "port_cd",       true, "",   dfNone,          0,       false,       true,	5);
    					InitDataProperty(0, cnt++ , dtData,       110,   daCenter,   true,    "spc_aloc_qty",  true, "",   dfInteger,       0,       true,       true);
    					InitDataProperty(0, cnt++ , dtComboEdit,  80,    daCenter,   true,    "to_trd_cd",     true, "",   dfNone,          0,       false,       true,	6);
    					InitDataProperty(0, cnt++ , dtComboEdit,  50,    daCenter,   true,    "to_dir_cd",     true, "",   dfNone,          0,       false,       true,	3);

    					HeadRowHeight = 10 ;

    					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
    					initSheetCombo_month(sheetObj, 0, "bse_mon");
//    					initSheetCombo_lane(sheetObj, 0, "rlane_cd");
//    					initSheetCombo_bound(sheetObj, 0, "dir_cd");
//    					initSheetCombo_rep_trade(sheetObj, 0, "to_trd_cd");
//    					initSheetCombo_bound(sheetObj, 0, "to_dir_cd");
    					//Allocation 최소값 셋팅
      		            sheetObj.MinimumValue(0, 10) = "1"; 
      		            
      		            InitDataValid(0,"rlane_cd",vtEngUpOnly );
                        InitDataValid(0,"dir_cd",vtEngUpOnly );
                        InitDataValid(0,"port_cd",vtEngUpOnly );
      		            InitDataValid(0,"to_trd_cd",vtEngUpOnly );
                        InitDataValid(0,"to_dir_cd",vtEngUpOnly );

    			   }
    			   break;

    		}
    	}

      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:      //조회
    		       
                  if(checkModifiedSheet(sheetObj)){
                      if(ComShowConfirm (getMsg("SPC90001")) != 1){
                          return;
                      }
                  }
    				if(validateForm(sheetObj,formObj,sAction)){
                    	formObj.f_cmd.value = SEARCHLIST;
                    	
                    	var param = "f_cmd=" + formObj.f_cmd.value;
                    	param = param + "&year="     + formObj.year.value;
                    	param = param + "&month="    + formObj.month.value;
                    	param = param + "&trade="    + comObjects[0].Code;
                    	param = param + "&toTrade="  + comObjects[1].Code;
                    	param = param + "&bound="    + formObj.bound.value;
                    	
                   		//sheetObj.DoSearch4Post("ESM_SPC_0067GS.do", FormQueryString(formObj));
                    	sheetObj.DoSearch4Post("ESM_SPC_0067GS.do", param);
                   		
                   		if(sheetObj.EtcData("status") == "OK"){
                   			retrieved = true;
                   		}
                   		
     				}
    				break;
    				
    			case IBSAVE:        //저장
    				//allocation 값체크
    				var save_rows = sheetObj.FindStatusRow("I|U|D");
    				if(!validate_check(sheetObj,save_rows)) return false;  
    				formObj.f_cmd.value = MULTI;
    				
    				var param = "f_cmd=" + formObj.f_cmd.value;
    				
    				//var rtn = doSaveSheet(sheetObj, "ESM_SPC_0067GS.do", FormQueryString(formObj));
    				var rtn = doSaveSheet(sheetObj, "ESM_SPC_0067GS.do", param);
    				
    				break;

    		   case IBINSERT:      // 입력
  
    		        if(!retrieved){
     					ComShowMessage(getMsg("SPC90124", ""));
    					return;
    		   		}
    				var row = sheetObj.DataInsert();
    				sheetObj.CellValue2(row, "bse_yr") = formObj.year.value;
    				//행추가시 Month로 선택컬럼
    				sheetObj.SelectCell(row, 4, true, ""); 
    				break;

    		   case IBCOPYROW:        //행 복사
    			  sheetObj.DataCopy();
    			  break;

    		   case IBDOWNEXCEL:        //엑셀 다운로드
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
        			  	default:
    			    }     

    			  break;

    		   case IBLOADEXCEL:        //엑셀 업로드
    			  sheetObj.LoadExcel();
    			  break;

    		}
    	}

    function sheet1_OnPopupClick(sheetObj, row, col)
    {
    	if ( sheetObj.ColSaveName(col) == "port_cd" )
    	{
    	   var port_cd = sheetObj.CellValue(row, col);
    	   spcPopup("POL", "loc_cd="+port_cd+"&loc_port_ind=Y", 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    	}
    }
        function getLeg(rowArray, row, col){
            var colArray = rowArray[0];	
        	sheetObjects[0].CellValue2(row, col) = colArray[3];
            
        }

      /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validate_check(sheetObj,save_row){
    		var arrRow = save_row.split(";");
    		for (var idx=0; idx<arrRow.length-1; idx++){
    			var allocation = sheetObj.CellValue(arrRow[idx], "spc_aloc_qty");
    			
    			if(allocation<1){              	
    				ComShowMessage(getMsg("SPC90119", "Allocation"));
    				sheetObj.SelectCell(arrRow[idx] , "spc_aloc_qty", true);
    				return false;   
    			}
    		}
    		return true;	
    	}
    		
        function sheet1_OnChange(sheetObj, row, col, value){
            with(sheetObj){
                switch(ColSaveName(col)){
                    case "rlane_cd":
                        var rtn = containsSheetCombo("lane", value);
                        if(rtn){
                            var rtn2 = getCodeList("VesselSize", "lane="+value);
                            CellComboItem(row, "vsl_clss_capa", " |"+rtn2[1], " |"+rtn2[0]);
                            CellValue2(row, col) = value + " ";
                            var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                            CellValue2(row, "rep_trd_cd") = text;
                            text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                            CellText(row, col) = text;
                        }
                        else{
                            CellValue2(row, col) = "";
                        }
                        break;
                    case "port_cd":
                    	var rtn = getCodeList("Port", "port_cd="+value);
                    	if(rtn[0] == ""){
                    		CellValue2(row, col) = "";
                    		ComShowMessage(getMsg("SPC90108", value));
                    		SelectCell(row, col);
                    		return;
                    	}
                    	else if(rtn[0].split("|").length > 2){
                    		sheet_OnPopupClick(sheetObj, row, col);
                    		CellValue2(row, col) = "";
                    	}
                    	else{
                    		CellValue2(row, col) = rtn[0].split("|")[0];
                    	}
                    	break;
                }
            }
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
//
//                    return false;
//                }
    										
            }

            return true;
        }
        
        function initDataValue_trade(){
        	var sheetObj = document.getElementById("trade");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        
        function initDataValue_toTrade(){
        	var sheetObj = document.getElementById("toTrade");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        

	/* 개발자 작업  끝 */