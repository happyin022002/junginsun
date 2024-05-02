/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0155.js
*@FileTitle : RMK PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.29 송호진
* 1.0 Creation
* History
* 2008-05-16 Ari
* 1.0 최초 생성       
* 2009-03-05 Ari CSR No.N200902250060 DEM/DET, MRI MISC Rev 추가
* 2009-03-05 Ari CSR No.N200902250060 MRI 쿼리 변경
* 2009-03-06 Ari CSR No.N200902250060 MRI 쿼리 변경
* 2009-03-10 Ari CSR No.N200903040140 MAS COST SOURCE CODE 보이도록 처리
* 2009-04-20 Ari CSR No.N200904070080 CM/OP 변경에 따른 dem/det처리
* 2009-10-08 송호진 ALPS 전환
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2011.12.21 최윤성 [CHM-201115260-01] [MAS] Pre CM/OP Simulation화면 U.I 변경요청 - avg_lvl_chk 추가 하여 값에 따라 색상 및 Bold 처리
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
     * @class ESM_MAS_0155 : ESM_MAS_0155 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0155() {
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
    var sheet1_maxRows = 25; //최대로우수

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

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;
    				
    				case "bu_zoom_in1":
    					if(sheetObject.Rows>sheet1_maxRows){
    						sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows+2);
    						div_zoom_out1.style.display = "inline";
    						div_zoom_in1.style.display = "none";
    					}
    					break;

    				case "bu_zoom_out1":
    					if(sheetObject.Rows>sheet1_maxRows){
    						sheetObject.style.height = sheetObject.GetSheetHeight(sheet1_maxRows);
    						div_zoom_in1.style.display = "inline";
    						div_zoom_out1.style.display = "none";
    					}
    					break;
    					
    				case "btn_close":
    					self.close();
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
    		var formObject = document.form;
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
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
    			case 1:	 //sheet1 init
    				with (sheetObj) {
                        
                        SheetWidth = mainTable.clientWidth;//전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
                        Editable = false;//전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(12, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(true, true, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                        
                        var HeadTitle = "Node/Link|Activity Group|H|Cost Element|Source Code|Source Code Description|Amount|Ctrt/Avg|S/P|Remark|avg_lvl_chk|SEQ" ;                   
                        InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++, dtData,		150,daCenter,	true,   "nod_cd", 			false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,		85, daLeft,		true,   "grp", 				false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtHidden,	70,	daCenter,	true,   "stnd_cost_cd", 	false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,		135,daLeft,		true,   "stnd_cost_nm", 	false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,   "mas_cost_src_cd", 	false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,		200,daLeft,		true,   "mas_cost_src_nm", 	false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,		60,	daRight,	true,	"amt",				false,	"",	dfNullFloatOrg,	2);
                        InitDataProperty(0, cnt++, dtData,	    60,	daCenter,	true,   "ctrt_rtn_flg", 	false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,	    60,	daCenter,	true,   "vndr", 			false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtData,	    180,daLeft,		true,   "cost_calc_rmk",    false,  "",	dfNone);
                        InitDataProperty(0, cnt++ ,dtHidden,	70,	daCenter,	true,	"avg_lvl_chk",		false,  "",	dfNone);
                        InitDataProperty(0, cnt++, dtHidden,	30,	daCenter,	true,   "acct_dp_seq",		false,  "",	dfNone);                        

                        HeadRowHeight = "10" ;
             		    style.height = GetSheetHeight(sheet1_maxRows) ;
             		    CountPosition	= 0 ;
    				}
    				break;
    		}
    	}

//    	/*화면이 로드 되면서 바로 retrieve 되도록 */
    	function setRetrieveAction(){
    		sheetObject = sheetObjects[0];
    		formObject = document.form;
    
    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
    	 * sheet row size 조절
    	 */
    	
    	function changeSheetRows(){
    	    var windowHeight = 0;
    	    var calcuRows = 0;
    	    sheetObj = sheetObjects[0];
    	    
    	    
            if (parseInt(navigator.appVersion)>3) { 
              if (navigator.appName=="Netscape") { 
                //windowWidth = window.innerWidth-16; 
                windowHeight = window.innerHeight-16; 
            
              } 
              if (navigator.appName.indexOf("Microsoft")!=-1) { 
                //windowWidth = document.body.offsetWidth-20; 
                windowHeight = document.body.offsetHeight-20; 
              } 
            }     	
           	calcuRows = Math.round(windowHeight/sheetObj.RowHeight(2)) - 7; 
           	//기본 크기에서 이정도 차이남
           	  	
           	if(sheet1_maxRows < calcuRows) 
           	    sheetObj.style.height = sheetObj.GetSheetHeight(calcuRows);
     
    	}
    	
    	/**
    	* sheet 로딩이 완료되면
    	*/
    	function sheet1_OnSearchEnd(sheetObj, errMessge) {
    	    //DEM/DET, MISC OP Rev를 노랑으로 표시
    	    if(sheetObj.CellValue(1, "grp") == '') sheetObj.RowBackColor(1) = sheetObj.RgbColor(255,255,180);
    	    if(sheetObj.CellValue(2, "grp") == '') sheetObj.RowBackColor(2) = sheetObj.RgbColor(255,255,180);
    	    sheetObj.SelectCell(3, 0);//비용 첫번째 부분에 Focus
    	    //OP가 아닌경우 DEM/DET hidden
//    	    if(document.form.f_cob_profit_lv.value!='O')  sheetObj.RowHidden(1) = true;
    	} 
    	
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		switch(sAction) {
    			case IBSEARCH:	 //조회
    				if(validateForm(sheetObj,formObj,sAction)) {
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCHLIST01;
    					sheetObj.DoSearch4Post("ESM_MAS_0155GS.do", masFormQueryString(formObj));
    					ComOpenWait(false);
    				}
    				break;

    			case IBCOPYROW:		//행 복사
    			 sheetObj.DataCopy();
    			 break;

    			case IBDOWNEXCEL:		//엑셀 다운로드
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
    		return true;
    	}
    	
    	 
    	
    	
     	
    	


	/* 개발자 작업  끝 */