/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0068.js
*@FileTitle : Pre-Allocation Inquiry
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
     * @class ESM_SPC_0068 : ESM_SPC_0068 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

    function ESM_SPC_0068() {
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
    					//공통함수사용: 화면을 초기화
    					resetAll();

    					formObject.year.value = init_year;
    		    		formObject.month.value = init_month;    	
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_rowadd":
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
    					Editable = false;
                        FocusEditMode = default_edit_mode;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 10, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(11, 0 , 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "SEQ|Year|Month|Rep. Trade|Lane|Bound|Vessel Size|Port|Allocation(TEU)|To Trade|To Bound";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtDataSeq,  35,    daCenter,   true,    "",             false,"",    dfNone,          0,       true,       true      );
    					InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter,   true,    "bse_yr",       false, "",   dfNone,          0,       false,      true,	4);
    					InitDataProperty(0, cnt++ , dtData,     70,    daCenter,   true,    "bse_mon",      false, "",   dfNone,          0,       false,      true,	2);
    					InitDataProperty(0, cnt++ , dtData,     80,    daCenter,   true,    "rep_trd_cd",   false,"",    dfNone,          0,       false,      false,	3);
    					InitDataProperty(0, cnt++ , dtData,     70,    daCenter,   true,    "rlane_cd",     false, "",   dfNone,          0,       false,      true,	5);
    					InitDataProperty(0, cnt++ , dtData,     60,    daCenter,   true,    "dir_cd",       false, "",   dfNone,          0,       false,      true,	1);
    					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,   true,    "vsl_clss_capa",false, "",   dfInteger,       0,       false,      true      );
    					InitDataProperty(0, cnt++ , dtData,     60,    daCenter,   true,    "port_cd",      false, "",   dfNone,          0,       false,      true,	5);
    					InitDataProperty(0, cnt++ , dtData,     120,   daCenter,   true,    "spc_aloc_qty", false, "",   dfInteger,       0,       true,       true      );
    					InitDataProperty(0, cnt++ , dtData,     80,    daCenter,   true,    "to_trd_cd",    false, "",   dfNone,          0,       false,      true,	6);
    					InitDataProperty(0, cnt++ , dtData,     50,    daCenter,   true,    "to_dir_cd",    false, "",   dfNone,          0,       false,      true,	3);

    					HeadRowHeight = 10 ;
    			   }
    			   break;

    		}
    	}

      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:      //조회
    				if(validateForm(sheetObj,formObj,sAction)){
                    	formObj.f_cmd.value = SEARCHLIST;
                    	
                    	var param = "f_cmd=" + formObj.f_cmd.value;
                    	param = param + "&year="     + formObj.year.value;
                    	param = param + "&month="    + formObj.month.value;
                    	param = param + "&trade="    + comObjects[0].Code;
                    	param = param + "&toTrade="  + comObjects[1].Code;
                    	param = param + "&bound="    + formObj.bound.value;
                    	
                   		//sheetObj.DoSearch4Post("ESM_SPC_0068GS.do", FormQueryString(formObj));
                   		sheetObj.DoSearch4Post("ESM_SPC_0068GS.do", param);
                 		
                   		if(sheetObj.EtcData("status") == "OK"){
                   			retrieved = true;
                   		}
    				}
    				break;

    		   case IBINSERT:      // 입력
    		   
    				var row = sheetObj.DataInsert();
    				sheetObj.CellValue2(row, "bse_yr") = formObj.year.value;
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
    	if ( sheetObj.ColSaveName(col) == "pol_cd" )
    	{
    	   var port_cd = sheetObj.CellValue(row, col);
    	   spcPopup("POL", "loc_cd="+port_cd+"&loc_port_ind=Y", 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    	}
    	if ( sheetObj.ColSaveName(col) == "pod_cd" )
    	{
    	   var port_cd = sheetObj.CellValue(row, col);
    		 spcPopup("POD", "loc_cd="+port_cd+"&loc_port_ind=Y", 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    	}
    }
        function getLeg(rowArray, row, col){
            var colArray = rowArray[0];	
        	sheetObjects[0].CellValue2(row, col) = colArray[3];
            
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
        function sheet1_OnChange(sheetObj, row, col, value){
           // log("sheet1_OnChange : " + row + "-" + col + "-" + value);
            with(sheetObj){
                switch(ColSaveName(col)){
                    case "rlane_cd":
                        var rtn = getCodeList("VesselSize", "lane="+value);
                        CellComboItem(row, "vsl_clss_capa", " |"+rtn[1], " |"+rtn[0]);
                        CellValue2(row, col) = value + " ";
                        var text = getSheetComboText(sheetObj, row, col, 0);
                        CellValue2(row, "rep_trd_cd") = text;
                }
            }
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