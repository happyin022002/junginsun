/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_PPL_0001.js
*@FileTitle : paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.09.01 차상영
* 1.0 Creation
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
     * @class COM_PPL_0001 : COM_PPL_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function COM_PPL_0001() {
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
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;

    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    		 var sheetObject = sheetObjects[0];

    		 /*******************************************************/
    		 var formObject = document.form;

//    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

                	case "btn_calendar": //달력버튼
                		var cal = new ComCalendarFromTo();
                		cal.select(formObject.fr_cre_dt, formObject.to_cre_dt, 'yyyy-MM-dd');                		
                		break;
                		
                	case "btn_office" :
                		ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:ofc_cd", "1,0,1,1,1,1,1,1", true);
                		break;
                		
    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    			} // end switch
//    		}catch(e) {
//        		if( e == "[object Error]") {
//        		    ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//    		}
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
        	comboObjects[comboCnt++] = combo_obj;
        }

    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {
    		var formObj = document.form;
    		
    		for(i=0;i<sheetObjects.length;i++){

    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		    	            
            for(k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }    		
    		
    		// period 초기 조건 설정 (5일)
    		var today = ComGetNowInfo("ymd","-");
    		//formObj.to_cre_dt.value = today;
    		//formObj.fr_cre_dt.value = ComGetDateAdd(today,"D",-5,"-");
    		
    		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
   		
    	}

        function initCombo(comboObj, comboNo) {
            switch(comboObj.id) {   	 			
    	 		case "pprl_eml_rcv_cd" :	
    	            var i = 0;
    	            with (comboObj) {
    	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
    	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
    	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
    	 				UseAutoComplete = true;  
    	                InsertItem(i++, "ALL", " ");
    	                InsertItem(i++, "User Mail", "NOR");
    	                InsertItem(i++, "DPCS Mail", "DPC");
    	                InsertItem(i++, "N-DPCS Mail", "NPC");
    	                Index = 1; //로딩시 "User Mail" 기본으로 선택함
    	            }
    	            break;
            }       	
        }
        
       	/**
    	 * Key-Down Event 처리
    	 */
       	function obj_keydown() {
       		var obj      = event.srcElement;
       		var vKeyCode = event.keyCode;
       		var formObj  = document.form;       		
       		if ( vKeyCode == 13 ) {
       			switch(obj.name) {
       				case "bkg_no":
       				case "to_cre_dt":
    	  				if ( ComTrim(obj.value) != "" ) {
    						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    					}
    					break;

    				default :
    					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    			}
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
    				with (sheetObj) {
    					// 높이 설정
    					//style.height = 300 ;
    					style.height = GetSheetHeight(19) ;
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;
    					
    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msNone;

    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = true;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(17, 0, 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
    					InitHeadMode(true, false, false, true, false, false);

    					var HeadTitle = "|Booking No|Lane|T/VVD|POL|POD|Office|Customer|User ID|E-Mail|Type|Subject|Content|Attached\nFile|Date||";    					

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtHiddenStatus,      80,    daCenter,  true,    "",        			false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		90,    daCenter,  true,    "bkg_no",        	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);    					
    					InitDataProperty(0, cnt++, dtData,       		40,    daCenter,  true,    "slan_cd",       	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		70,    daCenter,  true,    "t_vvd",         	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		60,    daCenter,  true,    "pol_cd",        	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		60,    daCenter,  false,    "pod_cd",        	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		70,    daCenter,  false,    "ofc_cd",        	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		70,    daCenter,  false,    "shpr",        		false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		70,    daCenter,  false,    "snd_usr_id",   	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    					InitDataProperty(0, cnt++, dtData,       		130,    daLeft,   false,   "sndr_eml",      	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);    				
    					InitDataProperty(0, cnt++, dtCombo,	    		80,		daCenter, true,		"pprl_eml_rcv_cd",	false,			 "",		dfNone,	0,	true,		true);
    					InitDataProperty(0, cnt++, dtData,       		180,    daLeft,   false,   "eml_tit_nm", 		false,          "",      	dfNone,    0,     true,       true, 	0,		false,		false);    					
    					InitDataProperty(0, cnt++, dtImageText,			120,	daLeft,	  true,		"pprl_eml_ctnt",	false,			"",			dfNone,		0,	false,	false);    					
    					InitDataProperty(0, cnt++, dtData,       		60,    daCenter,  false,   "atch_file_yn", 		false,			"",       dfNone,    0,     true,       true, 		0,		false,		false);    					
    					InitDataProperty(0, cnt++, dtData,       		120,    daRight,  false,    "cre_dt",        	false,          "",       dfNone,    0,     true,       true, 		0,		false,		false);
    		            InitDataProperty(0, cnt++, dtHidden,	    	0,		daCenter, true,		"org_file_nm",		false,      	"",			dfNone,		0,	false,		false);    		                		           
    		            InitDataProperty(0, cnt++, dtHidden,       		60,    daCenter,  false,   	"atch_file_path_ctnt", false,        "",       dfNone,    0,     true,       true, 	0,		false,		false);
    		                		            
    		            InitDataCombo(0, "pprl_eml_rcv_cd",  " |User Mail|DPCS Mail|N-DPCS Mail",       " |NOR|DPC|NPC",    ""); //type 콤보 설정
    		            
    		            
    					DataLinkMouse("pprl_eml_ctnt") = true; //메모장 마우스 포인트 링크로 변경
    					ImageList(0) = "img/btns_note.gif"; //메모장 이미지 지정
    					InitDataImage(0, "pprl_eml_ctnt", daRight); //메모장 이미지 위치 지정(우측 위치)
    					ShowButtonImage = 2; //메모장 버튼 표시 옵션(항상표시)   					
    		            AutoRowHeight = false;//메모장을 이용해 줄바뀜이 되어 내용이 길어져도 Row의 높이가 늘어나지 않게 함.
    		            
    			   }
    				break;
    		}
    	}


      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:      //조회
    						   				
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }  
                    	
    				sheetObj.RemoveAll();
    				
    				formObj.f_cmd.value = SEARCH;
    				//sheetObj.DoSearch4Post("COM_PPL_0001GS.do", FormQueryString(formObj));
    				var sXml = sheetObj.GetSearchXml("COM_PPL_0001GS.do", FormQueryString(formObj));
    				sheetObj.LoadSearchXml(sXml);
    				
    				break;			

    		   case IBDOWNEXCEL:        //엑셀 다운로드
    				//sheetObj.Down2Excel(-1, false, false, true);    			
    				//sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
    			    // 2014.12.04 신 로직
    			   sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "12");
    			   //sheetObj.Down2Text("Header", "\t", "1|2|3|4|5|6|7|8|9|10|11|13|14", "AllData.txt");

    				break;

    		}
    	}	
      	
    	
       /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		var formObj = document.form;
    		
    		if(sAction == IBSEARCH) {
    			//bkg_no 나 period 조건중에 한가지는 입력되어야 함.
    			if(formObj.bkg_no.value == "" && (formObj.fr_cre_dt.value == "" || formObj.to_cre_dt.value == "")) {
    				ComShowMessage(ComGetMsg("COM12138","Booking No", "Period"));
    				return false;
    			}   
    			    		
    			if(formObj.fr_cre_dt.value != "" && formObj.to_cre_dt.value != "") {   
    				//날짜 포맷 유효성 체크
    				if(ComIsDate(formObj.fr_cre_dt.value, "ymd") == false || ComIsDate(formObj.to_cre_dt.value, "ymd") == false) {
    					ComShowMessage(ComGetMsg("COM12134","Period"));
    					return false;
    				}
    				
    				//period 조건은 5일내에서만 검색 가능
    				if(parseInt(ComGetDateAdd(formObj.fr_cre_dt.value,"D",5,""), 10) < parseInt(ComReplaceStr(formObj.to_cre_dt.value,"-",""), 10)) {
    					ComShowMessage(ComGetMsg("COM12114","Period that must be between 5 days."));
    					return false;
    				}    				
    			}    			
    		}
    		
    		return true;
    	}

    	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    		for(var i=1; i<sheetObj.Rows; i++) {
    			if(sheetObj.CellValue(i,"org_file_nm") != "") {
    				sheetObj.CellValue2(i, "atch_file_yn") = "O";    //첨부파일이 있으면 셀에 "O" 표시			    				
    			}
    			else {
    				sheetObj.CellValue2(i, "atch_file_yn") = "X";    //첨부파일이 있으면 셀에 "X" 표시		
    			}
    			
    			//Content에 메모 이미지 표시
    			sheetObj.CellImage(i, "pprl_eml_ctnt") = 0; 			
    		}
    	}
    	
    	/**
    	 * sheet1 클릭 이벤트 <br>
    	 * @param {ibsheet} sheet    	IBSheet Object
    	 * @param {ibsheet} row     	sheet 선택된 row
    	 * @param {ibsheet} col     	sheet 선택된 col
    	 * @param {String} 	value     	파일명
    	 **/
    	function sheet1_OnClick(sheetObj,row,col,value){

    	    switch (sheetObj.ColSaveName(col)) {
	            case "pprl_eml_ctnt":
	            	//content 클릭시 메모장 오픈
	                sheetObj.CellEditable(row, col) = false;
	                ComShowMemoPad(sheetObj, row, col, true, 300, 250);
	                break;
	                
	            case "atch_file_yn" :	        		
	        		if(sheetObj.CellText(row, "org_file_nm") == "") {
	        			return;
	        		}
	        		else {
	            		//var frm1 = document.form1;
	            		//frm1.action = "/hanjin/FileDownload?key="+sheet.CellText(row, "org_file_nm");
	            		//frm1.submit();	        			
	        			
	        			if(sheetObj.CellValue(row, "pprl_eml_rcv_cd") == "NOR") {	        				
	        				location.href = "/hanjin/FileDownload?key="+sheetObj.CellValue(row, "org_file_nm"); //"NOR" 시 file key 로 다운로드
	        			}
	        			else {	        				
	        				location.href = "/hanjin/FileDownload?downloadLocation="+sheetObj.CellValue(row, "atch_file_path_ctnt") + "&downloadFileName=" + sheetObj.CellValue(row, "org_file_nm"); //"DPC" 시  file 경로로 다운로드
	        			}
	        			
	            		return;	        			
	        		}
	        		
	            	break;
    	    }

    	}    	
	/* 개발자 작업  끝 */