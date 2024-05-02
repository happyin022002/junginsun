/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0046.js
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
* 2012.08.29 전상화 [CHM-201219578-01] Control by HO / RHQ 화면에 Alloc Copy & Paste 버튼 추가
* 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
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
     * @class ESM_SPC_0046 : ESM_SPC_0046 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0046() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	this.sheet1_OnSearchEnd	= sheet1_OnSearchEnd;
    }
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
  
    
   	/* 개발자 작업	*/


    // 공통전역변수
       var sheetObjects = new Array();
       var comObjects = new Array();
       var sheetCnt = 0;
       var comboCnt = 0;

       //var sheetResizeFull = true;
       var sheetResizeCount = 2;

       /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
       document.onclick = processButtonClick;
       
       var sheet1_selRow = 0;

       var init_year = ''; 
       var init_week = '';
       var init_duration= '';
	
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){ 
    		
    		var sheetObject = sheetObjects[0];    		
    		var formObject = document.form;
   			var srcName = window.event.srcElement.getAttribute("name");
    		
   				if(srcName == "" || 
    				(document.getElementsByName(srcName) == null || 
    				(window.event.srcElement.tagName == "IMG" && 
    					document.getElementsByName(srcName)[0].Enable != undefined && 
    					!document.getElementsByName(srcName)[0].Enable))){
    				return;
    			}

    			switch(srcName) {
    				
    				case "btn_new":  
    				case "btn_retrieve":
    					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    					 
    					break;
    				case "btn_confirm":
    					/* 변경을 반영할지 물어보고 복제를 시작한다.*/
    					if(ComShowConfirm (getMsg("SPC90030")) != 1) 
    					  {
                              return;
                          }
    					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
    					   					
    					break;
    				   				

    			} // end switch
    	}



    	/**
    	 * IBSheet Object를 배열로 등록
    	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	 * 배열은 소스 상단에 정의
    	 */
    	function setSheetObject(sheet_obj){

    	   sheetObjects[sheetCnt++] = sheet_obj;


    	}
    	function setComboObject(combo_obj){

    	   comObjects[comboCnt++] = combo_obj;


    	}

    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {

        	SpcSearchOptionDuration("duration", 15, 5);
        	
    		ComConfigSheet(sheetObjects[0]);
    		initSheet(sheetObjects[0],1);    	
    		ComEndConfigSheet(sheetObjects[0]);
    		    		
    		var sheetResizeFull = true;
    		document_onresize();    		
    	
    		var formObject = document.form;   	
    		
    		init_year = formObject.yearText.value;	//년 초기화용
    		init_week = formObject.weekText.value;	//주차 초기화용
    		init_duration = formObject.duration.value;	//Duration 초기화용
    		
    		//  화면 로드시 자동조회하되록함.
    		//-----------------------------------------------------
    	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		//-----------------------------------------------------
    	}	
	
    	/**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
            with (sheetObj) {
            	// 높이 설정
				style.height = getSheetHeight(10) ;
				//전체 너비 설정
				SheetWidth = mainTable1.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;
                FocusEditMode = default_edit_mode;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 3, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(46, 8 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				
				InitHeadMode(false, true, false, true, false,false) ;

			
				var Head1 = "|Chk|Rep.\nTrade|Sub\nTrade|Lane|BD|Week|VVD||||";
				
				var HeadTitle0 = Head1+"BSA|BSA|" + //BSA
									   //"Loadable|Loadable|Loadable|Loadable|Loadable|" + //Loadable
									   "Load|Load|" +		//load
									   "F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|" +
									   "L/F\n(%)|" +
									   "Empty\nPlan|" +
									   "Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|" +
									   "BKG|BKG|BKG|BKG|BKG|BKG|USABLE|";
									   //"Un\nAllocated\nSpace|" +
									   //"Un\nAllocated\nWeight";
				
				var HeadTitle1 = Head1+"VOL|WGT|" +//BSA
										//"VOL|WGT|HC|45|RF|" +//Loadable
										"QTA|QTA|" +		//load
										"OCN|OCN|IPC|IPC|TS|TS|" +		//F'Cast
										"L/F\n(%)|" +	//L/F(%)
										"Empty\nPlan|" +// Empty Plan
										"OCN|OCN|IPC|IPC|TS|TS|" +		//Allocation
										"OCN|OCN|IPC|IPC|TS|TS|USABLE|";
										//"Un\nAllocated\nSpace|" +
										//"Un\nAllocated\nWeight";
				
				var HeadTitle2 = Head1+"VOL|WGT|" +				//BSA
									   //"VOL|WGT|HC|45|RF|" +	//Loadable
									   "OCN|IPC|" +				//load
									   "VOL|WGT|VOL|WGT|VOL|WGT|" +  			//F'Cast
									   "L/F\n(%)|" + 		//L/F(%)
									   "Empty\nPlan|" + 	// Empty Plan
									   "VOL|WGT|VOL|WGT|VOL|WGT|" +  			//Allocation
									   "VOL|WGT|VOL|WGT|VOL|WGT|USABLE|"; 			//Booking
									   //"Un\nAllocated\nSpace|" +
									   //"Un\nAllocated\nWeight|";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, false);
				
                        // 데이터속성        [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
						InitDataProperty(0, cnt++ , dtHiddenStatus,    40,    daCenter,   true,   "ibflag",     false,          "",       dfNone,       0,     true,       true);
						 
						InitDataProperty(0, cnt++ , dtCheckBox ,30,    daCenter,   true,    "Check");
                                           	
                        
                        InitDataProperty(0, cnt++ , dtData,    40,    daCenter,   true,    "trd_cd",    false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daCenter,   true,    "STRADE",   false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    45,    daCenter,   true,    "rlane_cd", false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    45,    daCenter,   true,    "dir_cd",   false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    80,    daCenter,   true,    "WEEK",     false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    100,    daCenter,   true,    "VVD",      false,          "",       dfNone,       0,     false,       true);
              
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "newVslVd",      false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "newSkdVoyNo",      false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "newSkdDirCd",      false,          "",       dfNone,       0,     false,       true);
                                              
                        //BSA
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        
                        //load
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        
                        //F'Cast
                        InitDataProperty(0, cnt++ , dtData,    50,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    50,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        
                        //L/F(%)
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfNullFloat,       1,     false,       true);
                        
                        // Empty Plan
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        
                        
                        //Allocation
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "alloc_ocn_vol",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "alloc_ocn_wgt",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "alloc_ipc_vol",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "alloc_ipc_wgt",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "alloc_ts_vol",      false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "alloc_ts_wgt",      false,          "",       dfInteger,       0,     false,       true);
                        
            			
                        //Booking
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtData,    40,    daRight,   true,   "",     false,          "",       dfInteger,       1,     false,       true);

                        //Copy Usable
                        InitDataProperty(0, cnt++ , dtHidden,    40,    daRight,   true,   "usable",     false,          "",       dfNone,       0,     false,       true);
                        
    					// Last Col
    					InitDataProperty(0, cnt++ , dtData, 	10,	daRight,   true,   "",	 false,		  "",	   dfNone,	   0,	 false,	   true);
    					
    					// Standard VVD 정보
    					InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "year",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "week",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "office",      false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "lane",        false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "bound",       false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "fcast",       false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "vsl_cd",      false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "skd_voy_no",  false,          "",       dfNone,       0,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,   true,    "skd_dir_cd",  false,          "",       dfNone,       0,     false,       true);
                        
    					  
    					
    					sheetObj.CellEditable(0,"Check") = true;
    					
                    	HeadRowHeight  = 10;
    					var backColor = RgbColor(222, 251, 248);
    					RangeBackColor(1, 7, 2, 13) = backColor;
    					RangeBackColor(2, 14, 2, 17) = backColor;
    					RangeBackColor(1, 18, 2, 21) = backColor;
    					RangeBackColor(1, 24, 2, 31) = backColor;
            }        
        }
        

      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:	  //조회
    				
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				 
    				var param = "";

    				param = param + "f_cmd="	+SEARCHLIST01;
    				param = param + "&year="	+formObj.yearText.value;
    				param = param + "&week="	+formObj.weekText.value;
    				param = param + "&bound="	+formObj.boundText.value;    		
    				param = param + "&trade="	+formObj.tradeText.value;
    				param = param + "&subtrade="+formObj.subtradeText.value;
    				param = param + "&lane="	+formObj.laneText.value;
    				param = param + "&fcast="	+formObj.fcastCode.value;    		
    				param = param + "&skd_voy_no="+formObj.skdVoyNoText.value;
    				param = param + "&skd_dir_cd="+formObj.skdDirCdText.value;
    				param = param + "&duration="+formObj.duration.value;
    				param = param + "&grp_acct="+formObj.acctCtrl.value;
    				
    				if( formObj.copyDiv.value == "VVD" )
    					param = param + "&vvd="		+formObj.vvdText.value;
    				else 
    					param = param + "&vsl_cd="	 +formObj.vslCdText.value;	
    				    param = param + "&vvd="		+formObj.vvdText.value;
    				
    				param = param + "&office="+formObj.officeText.value; 
    				
    				//첫번째 시트 조회 후 검색조건의 주차를 이용하여 하단 분의 Weekly CMB 4주차를 표현하기 위해 ETC로 담아오는 부분을 위해 GetSearchXml로 변경
    				var sXml = sheetObj.GetSearchXml("ESM_SPC_0046GS.do", param);
    				if (sXml != ""){
    					sheetObj.LoadSearchXml(sXml);
    					headWeek = ComGetEtcData(sXml, "headerWeek");
    				}
    				
    				sheetObj.ReDraw=true;
    				break; 

    			case IBSAVE:		//저장
    				
    				var param = "";
    				
    				if( formObj.openUI.value == "HO" )
    					param = param + "f_cmd="	+MULTI01;	
    				else
    					param = param + "f_cmd="	+MULTI;
    				
    				param = param + "&grp_acct="+formObj.acctCtrl.value;
    				
    				var rows     = sheetObj.RowCount;    				
    				for(var i = 0 ; i < rows ; i++){
    					 sheetObj.cellValue2(i+3, "year") = formObj.yearText.value;
    					 sheetObj.cellValue2(i+3, "week") = formObj.weekText.value;
    					 sheetObj.cellValue2(i+3, "office") =formObj.officeText.value;
    					 sheetObj.cellValue2(i+3, "lane") = formObj.laneText.value;
    					 sheetObj.cellValue2(i+3, "bound") =formObj.boundText.value;;
    					 sheetObj.cellValue2(i+3, "fcast") = formObj.fcastCode.value;      					 
    					 sheetObj.cellValue2(i+3, "vsl_cd") = formObj.vslCdText.value;
    					 sheetObj.cellValue2(i+3, "skd_voy_no") = formObj.skdVoyNoText.value;
    					 sheetObj.cellValue2(i+3, "skd_dir_cd") = formObj.skdDirCdText.value;
    				}    
    				
    				var rtn = doSaveSheet(sheetObj, "ESM_SPC_0046GS.do",param, "Check", false);    				
    				if(rtn == "OK"){
    					//self.close();
    				}else{
//    				  alert(rtn);
    				  ComShowMessage( rtn )
    				}
    				
    				break;
    				
    		}
    	}
    	
    	function changeCopy(copyDiv){
    		document.form.copyDiv.value = copyDiv;
    	}
    

function sheet1_OnChange(sheetObj, row, col, value){
	switch(sheetObj.ColSaveName(col)){
	case "Check":
		if(sheetObj.CellValue(row, col)=="1" && sheetObj.CellValue(row, "usable")=="N"){
//			alert("Applied Season is different from the Season for Standard VVD");
			ComShowMessage("Applied Season is different from the Season for Standard VVD");
			sheetObj.CellValue2(row, col)="0";	
		}
		break;
	}
}
   
    
	/* 개발자 작업  끝 */