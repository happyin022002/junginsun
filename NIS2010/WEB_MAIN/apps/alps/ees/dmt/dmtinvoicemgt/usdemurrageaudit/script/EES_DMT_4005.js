/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4005.js
*@FileTitle : 3rd Party DEM/DET Collection Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.08.25 최성환
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class EES_DMT_4005 : EES_DMT_4005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4005() {
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
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0; 
	
	var comboObjects = new Array();
	var comboCnt = 0;	

	// 버튼 기능 구분을 위한  Action 변수 정의
	var IBLOADEXCEL = 10000;
	var IBAUDIT		= 10001;
	var IBCONFIRM	= 97;
	 
    var COMMON_TARIFF_CD = "common_tariff_cd"; 
    var ROWMARK 		 = "|";
    var FIELDMARK 		 = "=";


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
		var sheetObject1 = sheetObjects[0];
          
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

 				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break; 					
 					
 				case "btn_loadexcel":
 					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
 					break;
 					
 				case "btn_audit":
 					doActionIBSheet(sheetObject1, formObject, IBAUDIT);
					break;
 				
 				case "btn_downexcel":
 					//alert("[btn_downexcel]"+sheetObject1.RowCount);
 					
 					if(sheetObject1.RowCount == 0){
 						//SAMPLE SHEET
 						sheetObject1.DataInsert();
 						var loadOpt = formObject.load_opt_input.value;
 						if(loadOpt == '1'){
 							sheetObject1.Down2Excel(true,false,false,true,'','',false,false,'',false,
							"seq|audit_result|cntr_tpsz_cd|cal_from_dt|cal_to_dt|cal_ft_end|cal_over|cal_from_dt|curr_cd|cal_collection|fm_mvmt_yd_cd|ft_cmnc_dt|ft_dys|sc_no|rfa_no|exception_amt|aft_expt_amt|bkg_no|bl_no|dmdt_chg_sts_cd");
 						} else if(loadOpt == '2'){
 							sheetObject1.Down2Excel(true,false,false,true,'','',false,false,'',false,
							"seq|audit_result|cntr_tpsz_cd|cal_from_dt|cal_to_dt|cal_ft_end|cal_over|cal_from_dt|curr_cd|cal_collection|fm_mvmt_yd_cd|ft_cmnc_dt|ft_dys|sc_no|rfa_no|exception_amt|aft_expt_amt|vvd|bkg_no|dmdt_chg_sts_cd");
 						} else if(loadOpt == '3'){
 							sheetObject1.Down2Excel(true,false,false,true,'','',false,false,'',false,
							"seq|audit_result|cntr_tpsz_cd|cal_from_dt|cal_to_dt|cal_ft_end|cal_over|cal_from_dt|curr_cd|cal_collection|fm_mvmt_yd_cd|ft_cmnc_dt|ft_dys|sc_no|rfa_no|exception_amt|aft_expt_amt|vvd|bl_no|dmdt_chg_sts_cd");
 						}
 						sheetObject1.RemoveAll();
 					} else {
 						//데이터 엑셀 다운
 						sheetObject1.Down2Excel(true);
 					}
 					break;		

 				case "btn_ofc":
 					openPopup('by_ofc');
 					break;	
 					
 				case "btn_bkg":
 					openPopup('by_bkg');
 					break;
 					
 				case "btn_cntr":
 					openPopup('by_cntr');
 					break;
 					
 				case "btn_mvmt":
 					openPopup('mvmt_inq');
 					break;
 					
 				case "btn_Confirm":
 					doActionIBSheet(sheetObject1,formObject,IBCONFIRM);
 					result_opt_change();
 					break;

 				case "btn_group_billing":
 					if(ComIsBtnEnable(srcName)) {
 						openPopupWindow(sheetObject1, formObject, srcName);
 					}
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
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
	function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++] = sheet_obj;
	}

    /** 
   	 * IBCombo Object를 배열로 등록
   	 * param : combo_obj ==> 콤보오브젝트
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
    	  
    	for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
		
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
    	  
  		// IBMultiCombo초기화 
  		for(var k=0;k<comboObjects.length;k++){
  			initCombo(comboObjects[k],k+1);
  		}
  		
  	    //html컨트롤 이벤트초기화
		initControl();
  		
		//초기시 button mode 
  		buttonMode("NEW");
//  		comboObjects[1].Enable = false;
  		
	}

    function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListener('mouseover', 'obj_mouseover',	'btn_ofc');	// 말풍선 표시
		axon_event.addListener('mouseout',	'obj_mouseout',		'btn_ofc');	// 말풍선 숨김

		
	}  
	// 'by office' onMouseover 이벤트  (버튼 말풍선 표시)
	function obj_mouseover() {
 		var msg = '';
 		var x = event.x+document.body.scrollLeft;
 		var y = event.y+document.body.scrollTop;
 		
     	switch(event.srcElement.id){
      		case 'btn_ofc':
      			msg = "Retrieve Coincidence only in Charge Calculation by Office/VVD";
      			x = x;
      			y = y-20;
      			break;
     	}
 		
 		var bak = 'lightyellow';
 		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
 						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
 		var skn = document.all("topdeck").style;
	 		skn.left = x;
	 		skn.top  = y;
	 		document.all("topdeck").innerHTML = content;
	 		skn.visibility = 'visible';
	}
	// 'by office' onMouseout 이벤트  (버튼 말풍선 숨김)
	function obj_mouseout() {
		var skn = document.all("topdeck").style;
		skn.visibility = 'hidden';
	}
	
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// 영문대, 숫자
         		ComKeyOnlyAlphabet('uppernum');
		        break;
         	case "engup2":
		    	// 영문대+숫자+예외문자
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
      
	/**
	  * 시트 초기설정값, 헤더 정의
	  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	  */
	function initSheet(sheetObj,sheetNo) {
		
	    var cnt = 0;
		var sheetID = sheetObj.id;
	
	    switch(sheetID) {
	
	    	case "sheet1":
	        with (sheetObj) {
	             // 높이 설정
	             style.height = 430;
	             // 전체 너비 설정
	             SheetWidth = mainTable.clientWidth;
	
	             //Host정보 설정[필수][HostIp, Port, PagePath]
	             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	             //전체Merge 종류 [선택, Default msNone]
//	             MergeSheet = msHeaderOnly;
	             MergeSheet = msNone;
	
	            //전체Edit 허용 여부 [선택, Default false]
	             Editable = false;
	
	             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	             InitRowInfo( 1, 1, 2, 100);
	
	             var HeadTitle  = "||Seq.|Audit Result|CNTR No.|T/S|T From DT|T To DT|T F/Time End|T Over|Collection|From Date|To Date|F/Time End|Over|Cur.|Billable AMT|From Yard|F/Time CMNC|F/T|S/C No.|RFA No.|Exception AMT|Discount AMT|VVD CD|BKG No.|B/L No.|STS";
	             HeadTitle += "|svr_id|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq";
	             HeadTitle += "|p_load_opt_input|p_ofc_cd|p_dmdt_trf_cd|p_fm_mvmt_yd_cd|delt_rqst|ofc_cd";
	             
	             var headCount = ComCountHeadTitle(HeadTitle);
	             
	             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	             InitColumnInfo(headCount, 0, 0, true);
	
	             // 해더에서 처리할 수 있는 각종 기능을 설정한다
	             InitHeadMode(true, true, true, true, false,false);
	
	             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	             InitHeadRow(0, HeadTitle, true);
	
	             //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,				KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter, 	true,   	"ibflag");
	             InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	true,		"CheckBox");
	             InitDataProperty(0, cnt++ , dtSeq,				30,		daCenter,	true,		"seq");
	             InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		"audit_result",			false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"cntr_no",				false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"cntr_tpsz_cd",			false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"t_from_dt",			false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"t_to_dt",				false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"t_ft_end",				false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"t_over",				false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		"t_collection",			false,		"",			dfNullFloat,	2,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cal_from_dt",			false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cal_to_dt",			false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"cal_ft_end",			false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"cal_over",				false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,		"curr_cd",				false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"cal_collection",		false,		"",			dfNullFloat,	2,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"fm_mvmt_yd_cd",		false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"ft_cmnc_dt",			false,		"",			dfDateYmd,		0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"ft_dys",				false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"sc_no",				false,		"",			dfNone,			0,		false,		false);
	            
				 InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"rfa_no",				false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"exception_amt",		false,		"",			dfNullFloat,	2,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,		"aft_expt_amt",			false,		"",			dfNullFloat,	2,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"vvd",					false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bkg_no",				false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"bl_no",				false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"dmdt_chg_sts_cd",		false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"svr_id",				false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"cntr_cyc_no",			false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"dmdt_trf_cd",			false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"dmdt_chg_loc_div_cd", 	false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"chg_seq",				false,		"",			dfNone,			0,		false,		false);
	             
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"p_load_opt_input",		false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"p_ofc_cd",				false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"p_dmdt_trf_cd",		false,		"",			dfNone,			0,		false,		false);
	             InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	true,		"p_fm_mvmt_yd_cd",		false,		"",			dfNone,			0,		false,		false);
				 InitDataProperty(0, cnt++ , dtHidden,		    80,		daCenter,	true,		"dmdt_delt_rqst_sts_cd");
				 InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,	true,		"ofc_cd");
					
				
	             FrozenCols = SaveNameCol("cntr_tpsz_cd");
	             
	             var color_show = RgbColor(79, 147, 232);
				
	             CellBackColor(0, "cntr_no") 		= color_show;
//	             CellBackColor(0, "t_from_dt") 		= color_show;
//	             CellBackColor(0, "t_to_dt") 		= color_show;
//	             CellBackColor(0, "t_ft_end") 		= color_show;
//	             CellBackColor(0, "t_over") 		= color_show;
	             CellBackColor(0, "t_collection")	= color_show;
	             CellBackColor(0, "vvd")			= color_show;
				
	             CountPosition = 2;					
	         }
	       
	         break;
	         
	     }
	}
	  
	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
	function initCombo(comboObj, comboNo) {
  	    var formObject = document.form
  		
  	    switch(comboNo) { 
  	    	case 1: 
	        	with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					SetColAlign("left|left");   
					SetColWidth("60|300");				
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
		    	}  	        	  
	        	//alert("[office comboList]"+comboNo+comboObj.id);
				//doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
				break;   	    
  	    	case 2: 
  	        	with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = false;
					SetColAlign("left|left");   
					SetColWidth("50|300");				
					ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
  		    	}
  	        	//alert("[tariff comboList]"+comboNo+comboObj.id);
  	        	//doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObj);
  	        	break;
  	    	case 3:
   	    		with (comboObj) { 
   	    			MultiSelect = false; 
  					UseAutoComplete = false;
	    			SetColAlign("left");
	    			SetColWidth("50");
	    			ColBackColor(0) = "#CCFFFD";
  					ColBackColor(1) = "#CCFFFD";
  					DropHeight = 160;
					IMEMode = 0;
					ValidChar(2,1);	//영문 대문자, 숫자
					MaxLength = 2;
   		    	}
   	    		break;
  	     } 
  	    
	}	

     //쉬트 로드 후에 콤보리스트 콜. 깜빡임 방지 방안
	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		sheetObjects[0].WaitImageVisible = false;   
  		
  		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
  		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);

        sheetObjects[0].WaitImageVisible = true;   
  	}   
    	

    function sheet1_OnMouseDown( sheetObj , Button , Shift , X , Y ) {
  		var formObj = document.form    	
    	var result_opt = formObj.result_opt.value

        with (sheetObj) {
            if ( MouseRow == 0 && MouseCol == 1 && Button == 1 ) {
            	if ( CheckAll( 1 ) == 0 ) {
                	for ( var x = 1 ; x < LastRow + 1 ; x++ ) {
                		if( result_opt == "All" ){
                			CellValue( x , "CheckBox" ) = 1;
                		} else if ( result_opt == CellValue( x , 3 ) ){
                			CellValue( x , "CheckBox" ) = 1;
                		} else {
                			CellValue( x , "CheckBox" ) = 0;
                		}
                    }
            	} else if ( CheckAll( 1 ) == 1 ) {
                	for ( var x = 1 ; x < LastRow + 1 ; x++ ) {
                		if( result_opt == "All" ){
                			CellValue( x , "CheckBox" ) = 0;
                		} else if ( result_opt == CellValue( x , 3 ) ){
                			CellValue( x , "CheckBox" ) = 0;
                		} else {
                			CellValue( x , "CheckBox" ) = 0;
                		}
                    }
            	}
            }
        }
    }
    
    function sheet1_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            if ( Row > 0 && Col == 1 ) {
                var vChk = sheetObjects[0].CellValue(Row,1);
                if ( vChk == 1 ) { // 선택해제
                	CellValue( Row ,"CheckBox" ) = 0;
                }
                else if ( vChk == 0 ) { // 선택해제
                	CellValue( Row ,"CheckBox" ) = 1;
                }
            	
            }
        }
    }
 	/**
 	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation을 위한 KeyUp 이벤트 처리 함수
 	 */
 	function obj_keyup() {
 		var srcObj = event.srcElement;
 		checkLocYdCd(srcObj);
 	}
 	
 	/**
 	 * Yard, Port(Location) 필드에   입력한 코드값의  Validation 처리 함수
 	 */
 	
	function checkLocYdCd(srcObj) {
 		var formObj = document.form;
 		var cd = ComTrim(ComGetObjValue(srcObj));
 		
 		if (cd.length == 5) {
 			var comboObj = comboObjects[2];
 			formObj.yd_cd1.value = cd;
// 			alert("5자리:"+formObj.yd_cd1.value);
 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03, comboObj);
 		}
 	}
 	 
  	/**
	 * Combo 관련 프로세스 처리
	 */	
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

		var loadOptInput = formObj.load_opt_input.value;
        switch(sAction) {
		      	
    		//Office comboList	
    		case IBSEARCH_ASYNC01:    
				
				formObj.f_cmd.value = SEARCHLIST02;
	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    sComboObj.RemoveAll();
	    	    if (sXml != undefined && sXml != '') {
		    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
		    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
	
		    	    var comboCodeArr = ofc_cds.split("|");			    	    
		    	    var comboTextArr = ofc_nms.split("|");
		    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
		         	}
	    	    }
	    	    
	    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
	    	    if(loadOptInput == '1'){
	    	  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
	    	  		sComboObj.Code = usr_ofc_cd;
	    	  		
	    	  		if(sComboObj.Code != usr_ofc_cd) {
	    	  			sComboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
	    	  			sComboObj.Code = usr_ofc_cd;
	    	  		}
	    	    }
	    	    break;
    		
	    	//Tariff type comboList
    		case IBSEARCH_ASYNC02:     
		 		
				formObj.f_cmd.value = SEARCHLIST;
				var xmlStr = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				sComboObj.RemoveAll();
				var data = ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(sComboObj,comboItems);
					comboItem = comboItems[0].split(FIELDMARK);
				}	
				
				// VVD CD일 경우 Default를 DMIF로 셋팅
				// Default를 DMIF로 셋팅
				sComboObj.Text = 'DMIF';
				break;	

			//From Yard Code comboList
    		case IBSEARCH_ASYNC03:  
    			formObj.f_cmd.value = SEARCH14;
	    	    var xmlStr = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
    			sComboObj.RemoveAll();			
    			var comboDatas = ComGetEtcData(xmlStr, "YD");
 	        	if (comboDatas != undefined && comboDatas != '') {
					comboItems = comboDatas.split(ROWMARK);
					addComboItem(sComboObj, comboItems);
				} else {
					sheetObj.WaitImageVisible = true;
					ComShowCodeMessage('DMT00110', "Yard");
					formObj.yd_cd.focus();
					return;
				}
    			break;
        }
		sheetObj.WaitImageVisible = true;
    }	
	
	
   /**
    * 콤보필드에 데이터를 추가해준다.
    */	
	function addComboItem(comboObj,comboItems) {
		var comboID = comboObj.id;
		switch(comboID) {		
			case "combo2":
			   	for (var i = 0 ; i < comboItems.length ; i++) {
			   		var comboItem = comboItems[i].split(FIELDMARK);
					comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			   	}   
			   	break;
			   	
			case "combo3":
				for (var i = 0 ; i < comboItems.length ; i++) {
  		    		var comboItem = comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
  		    	}
  				break;			   	
		}			   	
	}			
	
   /**
    * Sheet관련 프로세스 처리 
    */		
	function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction){
    		case IBCLEAR:       //초기화 
    			initSearchControls("NEW");
				buttonMode("NEW");
				break;

    		case IBLOADEXCEL:        
    			if(!validateForm(sheetObj,formObj,sAction)) return;
    			
    			//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);
    			
		        sheetObj.RemoveAll();
    			sheetObj.LoadExcel();
    			
    			//ComOpenWait End
				ComOpenWait(false);
				
    			//엑셀로딩 취소시에 버튼 유지 [2009.09.10 수정요청]
    			var totRowCnt = sheetObj.RowCount;
    			if(totRowCnt > 0){
    				buttonMode("LOAD_EXCEL");
    			} 
				break;
			
    		case IBAUDIT:
    			if(!validateForm(sheetObj,formObj,sAction)) return;
    			
    			//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);

    			formObj.f_cmd.value = MULTI;
    			//sheetObj.ShowDebugMsg = true;
				sheetObj.DoAllSave("EES_DMT_4005GS.do", FormQueryString(formObj));
	   			//sheetObj.ShowDebugMsg = false;
				
				//ComOpenWait End
				ComOpenWait(false);
				
				buttonMode("AUDIT");
				break;

         	case IBCONFIRM:		// Confirm
         		if(!validateForm(sheetObj,formObj,sAction)) return;
 				
	         	sheetObj.WaitImageVisible=false;
	     		ComOpenWait(true);
     		
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("EES_DMT_4005GS.do", FormQueryString(formObj),"CheckBox");				
				doActionIBSheet(sheetObj, formObj, IBAUDIT);
//				result_opt_change();
				ComOpenWait(false);
				break;

    	}
	}

    
   /**
	* 초기값 SETTING
	*/
	function initSearchControls(mode) {
		var formObj = document.form;
		if(mode == "NEW"){
			formObj.tot_cntr.value 	= "";
			formObj.tot_amt.value 	= "";
			formObj.c_cntr.value 	= "";
			formObj.c_amt.value 	= "";
			formObj.d_cntr.value 	= "";
			formObj.d_amt.value		= "";
			sheetObjects[0].RemoveAll();
			formObj.load_opt.value = '1';
			load_change();
		}
		
	}    
	
	/**
	 * BUTTON MODE
	 */
	function buttonMode(mode) {
		 var formObj = document.form;
		 if(mode == "NEW"){
			with (formObj) {
				ComEnableManyObjects(true, load_opt, yd_cd);
				ComEnableManyObjects(false, result_opt);
				comboObjects[0].Enable = true;
				comboObjects[1].Enable = true;
				comboObjects[2].Enable = true;
				DmtComEnableManyBtns(true,  "btn_new", "btn_loadexcel", "btn_downexcel");
				DmtComEnableManyBtns(false, "btn_audit", "btn_ofc", "btn_bkg", "btn_cntr", "btn_mvmt","btn_group_billing","btn_Confirm");
				ComSetObjValue(button_mode, "NEW");
				ComSetObjValue(result_opt,  "All");
				
				formObj.load_opt.className 	= 'input1';
				formObj.yd_cd.className 	= 'input';
			}
		 } else if(mode == "LOAD_EXCEL"){
			 with (formObj) {
					ComEnableManyObjects(false, load_opt, yd_cd, result_opt);
					comboObjects[0].Enable = false;
					comboObjects[1].Enable = false;
					comboObjects[2].Enable = false;
					
					DmtComEnableManyBtns(true, 	 "btn_new", "btn_audit", "btn_downexcel");	
					DmtComEnableManyBtns(false,  "btn_loadexcel", "btn_downexcel", "btn_ofc", "btn_bkg", "btn_cntr", "btn_mvmt","btn_group_billing","btn_Confirm");
					ComSetObjValue(button_mode, "LOAD_EXCEL");
					
					formObj.load_opt.className 	= 'input1';
					//회색바탕 readOnly
					formObj.yd_cd.className 	= 'input2';
				}
		 } else if(mode == "AUDIT"){
			 with (formObj) {
					ComEnableManyObjects(false, load_opt, yd_cd);
					ComEnableManyObjects(true, result_opt);
					comboObjects[0].Enable = false;
					comboObjects[1].Enable = false;
					comboObjects[2].Enable = false;
					
					DmtComEnableManyBtns(true, 	 "btn_new", "btn_downexcel", "btn_ofc", "btn_bkg", "btn_cntr", "btn_mvmt","btn_group_billing","btn_Confirm");	
					DmtComEnableManyBtns(false,  "btn_audit", "btn_loadexcel");
					ComSetObjValue(button_mode, "AUDIT");

					formObj.load_opt.className 	= 'input1';
					//회색바탕 readOnly
					formObj.yd_cd.className 	= 'input2';
					formObj.result_opt.className= 'input';    
				}
		 }
	} 
	
	/**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
	function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
			//필수 검색어 조건을 먼저 확인한다. 속도 때문에 아래 그리드 데이터의 VALIDATION은 별도로 한다.  
			ComSetObjValue(ofc_cd, 			comboObjects[0].Code);
			ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].Text);
			ComSetObjValue(fm_mvmt_yd_cd, 	ComGetObjValue(yd_cd)+comboObjects[2].Text);

			var ofcCd 			= ComGetObjValue(ofc_cd);
			var dmdtTrfCd 		= ComGetObjValue(dmdt_trf_cd);
			var fmMvmtYdCd 		= ComGetObjValue(fm_mvmt_yd_cd);
			
			var loadOptInput	= ComGetObjValue(load_opt_input);
			
			if(loadOptInput == 1 || loadOptInput == 2 || loadOptInput == 3){
				if(ofcCd == ''){
					ComShowCodeMessage('DMT02002', 'Office');
					//에러 발생시 조건은 그대로 두고 그리드만 reset
					sheetObjects[0].RemoveAll();
					buttonMode("NEW");
					return false;
				}
				if(dmdtTrfCd == ''){
					ComShowCodeMessage('DMT02002', 'Tariff Type');
					//에러 발생시 조건은 그대로 두고 그리드만 reset
					sheetObjects[0].RemoveAll();
					buttonMode("NEW");
					return false;
				}
			} 
			//[수정][9/10] From Yard가 항상 Optional 입력사항으로 변경
//			if(loadOptInput == 1){
//				if(fmMvmtYdCd == ''){
//					ComShowCodeMessage('DMT02002', 'From Yard');
//					//에러 발생시 조건은 그대로 두고 그리드만 reset
//					sheetObjects[0].RemoveAll();
//					buttonMode("NEW");
//					return false;
//				}
//			} 
			
			switch(sAction) {
				case IBAUDIT:
					//alert("전체 건수 는 " + sheetObj.RowCount + " 건입니다.");
					var totRowCnt = sheetObj.RowCount;
					//데이터가 없을 경우 처리안함.
					if(totRowCnt == 0) return false;
					ComOpenWait(true);
					//[주석] 엑셀에서 데이터를 로딩하여  입력한  값을 확인한다.
					for(var i=1; i <= totRowCnt; i++) {
						
//						if( sheetObj.CellValue(i, "t_ft_end")      == '' ){
//							ComOpenWait(false);
//							ComShowCodeMessage('DMT03033', 'T F/Time End');
//							//에러 발생시 조건은 그대로 두고 그리드만 reset
//							sheetObjects[0].RemoveAll();
//							buttonMode("NEW");
//							return false; 
//						}
//						if( sheetObj.CellValue(i, "t_over")      == '' ){
//							ComOpenWait(false);
//							ComShowCodeMessage('DMT03033', 'T Over');
//							//에러 발생시 조건은 그대로 두고 그리드만 reset
//							sheetObjects[0].RemoveAll();
//							buttonMode("NEW");
//							return false; 
//						}
						
						if( sheetObj.CellValue(i, "t_collection")      == '' ){
							ComOpenWait(false);
							ComShowCodeMessage('DMT03033', 'Collection');
							//에러 발생시 조건은 그대로 두고 그리드만 reset
							sheetObjects[0].RemoveAll();
							buttonMode("NEW");
							return false; 
						}
						
						if(loadOptInput == 1){
							if( sheetObj.CellValue(i, "cntr_no")      == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'Container No');
								//에러 발생시 조건은 그대로 두고 그리드만 reset
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
//							if( sheetObj.CellValue(i, "t_collection")      == '' ){
//								ComShowCodeMessage('DMT03033', 'Collection');
//								//에러 발생시 조건은 그대로 두고 그리드만 reset
//								sheetObjects[0].RemoveAll();
//								buttonMode("NEW");
//								return false; 
//							}
							if( sheetObj.CellValue(i, "vvd")      == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'VVD');
								//에러 발생시 조건은 그대로 두고 그리드만 reset
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
 
						} else if(loadOptInput == 2){
							if( sheetObj.CellValue(i, "cntr_no")      == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'Container No');
								//에러 발생시 조건은 그대로 두고 그리드만 reset
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
//							if( sheetObj.CellValue(i, "t_collection")      == '' ){
//								ComShowCodeMessage('DMT03033', 'Collection');
//								//에러 발생시 조건은 그대로 두고 그리드만 reset
//								sheetObjects[0].RemoveAll();
//								buttonMode("NEW");
//								return false; 
//							}
							if( sheetObj.CellValue(i, "bl_no")      == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'B/L No');
								//에러 발생시 조건은 그대로 두고 그리드만 reset
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}

						} else if(loadOptInput == 3){
							if( sheetObj.CellValue(i, "cntr_no")      == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'Container No');
								//에러 발생시 조건은 그대로 두고 그리드만 reset
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}
//							if( sheetObj.CellValue(i, "t_collection")      == '' ){
//								ComShowCodeMessage('DMT03033', 'Collection');
//								//에러 발생시 조건은 그대로 두고 그리드만 reset
//								sheetObjects[0].RemoveAll();
//								buttonMode("NEW");
//								return false; 
//							}
							if( sheetObj.CellValue(i, "bkg_no")      == '' ){
								ComOpenWait(false);
								ComShowCodeMessage('DMT03033', 'BKG No');
								//에러 발생시 조건은 그대로 두고 그리드만 reset
								sheetObjects[0].RemoveAll();
								buttonMode("NEW");
								return false; 
							}

						}
						
						//조회 조건을 그리드에 담아 넘기기.
						sheetObj.CellValue(i, "p_load_opt_input") 	= loadOptInput;
						sheetObj.CellValue(i, "p_ofc_cd") 			= ofcCd;
						sheetObj.CellValue(i, "p_dmdt_trf_cd") 		= dmdtTrfCd;
						sheetObj.CellValue(i, "p_fm_mvmt_yd_cd") 	= fmMvmtYdCd;
					} //End of for Loop
					ComOpenWait(false);
					
					break;	
					
          		case IBCONFIRM:      //Confirm
             		if(sheetObj.CheckedRows("CheckBox") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Confirm');
             			return false;
             		}
             		
             		var chkRows = sheetObj.FindCheckedRow("CheckBox").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chgStsCd = sheetObj.CellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chgStsCd != 'F') {
         					ComShowCodeMessage('DMT03018');
         					sheetObj.SelectRow = chkRows[i];
         					return false;
         				}
         				
         				var auditResult = sheetObj.CellValue(chkRows[i], "audit_result");
         				if(auditResult != 'Coincidence') {
         					ComShowCodeMessage('DMT01169',sheetObj.CellValue(chkRows[i], "cntr_no"));
         					sheetObj.SelectRow = chkRows[i];
         					return false;
         				}
             		}
             		break;
					
			} // End of the switch
    	  } // End of the with clause
    	  return true;
	}
	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)
	{
		if(ErrMsg != '') return;
		
		ComOpenWait(true);
		
		var formObject = document.form;
		var totCntr = 0;
		var totAmt  = 0;
		var cCntr 	= 0;
		var cAmt  	= 0;
		var dCntr 	= 0;
		var dAmt  	= 0;
		
		with(sheetObj)
		{
			var color_show = RgbColor(79, 147, 232);
			for(var i=sheetObj.TopRow; i <= sheetObj.SearchRows; i++) {
				var auditResult = "";
				
				//[로직] 비교대상의 데이터가 다를 경우 색상을 적용 
				//[로직] 비교대상의 데이터가 다를 경우 Discrepancy, 같을 경우 Coincidence로  필드(audit_result)에 삽입
				
//				if(sheetObj.CellValue(i, "t_from_dt") != ''){
//					if(sheetObj.CellValue(i, "t_from_dt") != sheetObj.CellValue(i, "cal_from_dt")){
//						CellBackColor(i, "t_from_dt") 	= color_show;
//						if(auditResult == ''){
//							auditResult = "Discrepancy";
//						}
//						
//					}
//				}
//				if(sheetObj.CellValue(i, "t_to_dt") != ''){
//					if(sheetObj.CellValue(i, "t_to_dt") != sheetObj.CellValue(i, "cal_to_dt")){
//						CellBackColor(i, "t_to_dt") 	= color_show;
//						if(auditResult == ''){
//							auditResult = "Discrepancy";
//						}
//					}
//				}
//				if(sheetObj.CellValue(i, "t_from_dt") != ''){
//					if(sheetObj.CellValue(i, "t_from_dt") != sheetObj.CellValue(i, "cal_from_dt")){
//						CellBackColor(i, "t_from_dt") 	= color_show;
//						if(auditResult == ''){
//							auditResult = "Discrepancy";
//						}
//					}
//				}
				if(sheetObj.CellValue(i, "t_ft_end") != ''){
					if(sheetObj.CellValue(i, "t_ft_end") != sheetObj.CellValue(i, "cal_ft_end")){
						CellBackColor(i, "t_ft_end") 	= color_show;
						if(auditResult == ''){
							auditResult = "Discrepancy";
						}
					}
				}
				if(sheetObj.CellValue(i, "t_over") != ''){
					if(sheetObj.CellValue(i, "t_over") != sheetObj.CellValue(i, "cal_over")){
						CellBackColor(i, "t_over") 	= color_show;
						if(auditResult == ''){
							auditResult = "Discrepancy";
						}
					}
				}
//				if(sheetObj.CellValue(i, "t_collection") != ''){
					if(sheetObj.CellValue(i, "t_collection") != sheetObj.CellValue(i, "cal_collection")){
						CellBackColor(i, "t_collection") 	= color_show;
						if(auditResult == ''){
							auditResult = "Discrepancy";
						}
					}
//				}
				if(auditResult == ''){
					auditResult = "Coincidence";
				}
				
				//Discrepancy OR Coincidence로 셋팅
				sheetObj.CellValue(i, "audit_result") = auditResult;
				
				//[로직] 각각의 Coincidence와 Discrepancy의 cntr의 갯수와 amt의 총계를 구함
				if(sheetObj.CellValue(i, "audit_result") == "Coincidence" ){
					totAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
					cAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
					totCntr	+= 1;
					cCntr 	+= 1;
				}else if(sheetObj.CellValue(i, "audit_result") == "Discrepancy" ){
					totAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
					dAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
					totCntr	+= 1;
					dCntr 	+= 1;
				}
				
				formObject.tot_amt.value	= ComAddComma2(ComRound(totAmt, 2)+'', "#,###.00");
				formObject.tot_cntr.value	= totCntr;
				formObject.c_amt.value 		= ComAddComma2(ComRound(cAmt, 2)+'', "#,###.00");
				formObject.c_cntr.value 	= cCntr;
				formObject.d_amt.value 		= ComAddComma2(ComRound(dAmt, 2)+'', "#,###.00");
				formObject.d_cntr.value 	= dCntr;
				
			} //End of the for loop
		}
		ComOpenWait(false);
	}

	//[설명] select시 변경 되는 child를 처리하는 로직
	function sub_load_opt01() {
	    // OPTION이라는 Element를 생성합니다
	    var optColor=document.createElement("OPTION");
	    optColor.text="VVD CD";
	    optColor.value="1";
	    // 생성한 Element를 콤보 박스에 추가 시킵니다
	    document.form.load_opt.add(optColor);
	}
	function sub_load_opt02() {	
	    // OPTION이라는 Element를 생성합니다
	    var optColor=document.createElement("OPTION");
	    optColor.text="B/L No";
	    optColor.value="2";	    
	    // 생성한 Element를 콤보 박스에 추가 시킵니다	
	    document.form.load_opt.add(optColor);	
	}
	function sub_load_opt03() {	
	    // OPTION이라는 Element를 생성합니다
	    var optColor=document.createElement("OPTION");
	    optColor.text="BKG No";
	    optColor.value="3";	    
	    // 생성한 Element를 콤보 박스에 추가 시킵니다	
	    document.form.load_opt.add(optColor);	
	}

	function sub_load_delAll() {
	    // 콤보 박스에 내용이 있을 때만 실행 합니다
	    if ( eval(document.form.load_opt.options.length) > 0 ) {
	    // 콤보 박스의 크기만큼 for 를 돕니다
	        for (i=0 ; eval(document.form.load_opt.options.length) ; i++)
	        {
	            // 맨 위에 있는 목록을 갖고 옵니다
	            var selCh=document.form.load_opt.children(0);
	            // 갖고온 목록을 삭제 합니다
	            document.form.load_opt.removeChild(selCh);
	        }
	    }
	}
	//두번째 select에 해당하는 데이터를 호출
    function load_change(){   
    	var formObj = document.form;
    	var loadOpt = formObj.load_opt.value;
    	if(loadOpt == '1'){
    		//VVD CD일경우 SELECT OPTION 값과 GRID 정의 필드 셋팅 
    		sheetObjects[0].RemoveAll();
			load_option_grid('1');
			formObj.load_opt_input.value = "1";
			resetSearchControls(loadOpt);
		} 
    } 
    
	//조회상태를 RESET으로 셋팅
    function resetSearchControls(load_status){   
    	var formObj = document.form;
    	
    	//office code reset
    	formObj.ofc_cd.value 		= "";
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
		
		//tariff type code reset
		formObj.dmdt_trf_cd.value 	= "";
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
		
		//yard code reset
		formObj.yd_cd.value 		= "";
		formObj.yd_cd1.value		= "";
		formObj.fm_mvmt_yd_cd.value	= "";
		comboObjects[2].RemoveAll();	
    }

    //전체 조회결과에서 부분 조회 처리(All/Coincidence/Discrepancy)
    function result_opt_change(){   
    	var formObj 	= document.form;
    	var result_opt 	= formObj.result_opt.value;
    	var totCntr 	= 0;
		var totAmt  	= 0;
		var cCntr 		= 0;
		var cAmt  		= 0;
		var dCntr 		= 0;
		var dAmt  		= 0;
    	var sheetObj 	= sheetObjects[0];
    	
		with(sheetObj)
		{
			for(var i=1; i <= sheetObj.RowCount; i++) {

				//[로직] 조회 대상과 다를 경우 rowHidden으로 로우를 숨긴다. 
				if(result_opt == 'All'){
					//alert(result_opt);
					sheetObj.RowHidden(i) = false;
					//[로직] 각각의 Coincidence와 Discrepancy의 cntr의 갯수와 amt의 총계를 구함
					if(sheetObj.CellValue(i, "audit_result") == "Coincidence" ){
						totAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						cAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						totCntr	+= 1;
						cCntr 	+= 1;
					}else if(sheetObj.CellValue(i, "audit_result") == "Discrepancy" ){
						totAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						dAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						totCntr	+= 1;
						dCntr 	+= 1;
					}
				} else if(sheetObj.CellValue(i, "audit_result") != result_opt){
					//[로직] 로우를 숨김 -> 계산 대상에서 제외
					//alert(result_opt);
					sheetObj.RowHidden(i) = true;
					totAmt 	+= 0;
					cAmt 	+= 0;
					totCntr	+= 0;
					cCntr 	+= 0;
				} else {
					//alert(result_opt);
					sheetObj.RowHidden(i) = false;
					//[로직] 각각의 Coincidence와 Discrepancy의 cntr의 갯수와 amt의 총계를 구함
					if(sheetObj.CellValue(i, "audit_result") == "Coincidence" ){
						totAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						cAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						totCntr	+= 1;
						cCntr 	+= 1;
					}else if(sheetObj.CellValue(i, "audit_result") == "Discrepancy" ){
						totAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						dAmt 	+= parseFloat(sheetObj.CellValue(i, "t_collection"));
						totCntr	+= 1;
						dCntr 	+= 1;
					}
				} 

				formObj.tot_amt.value	= ComAddComma2(ComRound(totAmt, 2)+'', "#,###.00");
				formObj.tot_cntr.value	= totCntr;
				formObj.c_amt.value 	= ComAddComma2(ComRound(cAmt, 2)+'', "#,###.00");
				formObj.c_cntr.value 	= cCntr;
				formObj.d_amt.value 	= ComAddComma2(ComRound(dAmt, 2)+'', "#,###.00");
				formObj.d_cntr.value 	= dCntr;
				
				sheetObj.CellValue(i,"CheckBox") = 0;
			} //End of the for loop

            CheckAll( "CheckBox" ) = 0;
		}
    } 	
	
	
	// load option 선택시 해당하는 grid로 변경.
    function load_opt_change(){   
    	sheetObjects[0].RemoveAll();
    	var formObj 	= document.form;
        var loadOption 	= formObj.load_opt.value;   
        formObj.load_opt_input.value = loadOption;
        
        //해당 그리드에 필요한  값들 셋팅.
        load_option_grid(loadOption);
    }    
    
    // load option 선택시 해당하는 grid의 필드값을 셋팅
    function load_option_grid(loadOption){   
    	var color_show = sheetObjects[0].RgbColor(79, 147, 232);
    	var color_hide = sheetObjects[0].RgbColor(0, 0, 0);
    	if(loadOption == '1'){
    		//alert("load_option_grid01");
    		//grid01에 VVD에 COLOR 넣기
    		sheetObjects[0].CellBackColor(0, "vvd") 	= color_show;
			sheetObjects[0].CellBackColor(0, "bl_no") 	= color_hide;
			sheetObjects[0].CellBackColor(0, "bkg_no") 	= color_hide;
    		
    	} else if(loadOption == '2'){
    		//alert("load_option_grid02");
    		//grid02에 B/L NO COLOR 넣기
    		sheetObjects[0].CellBackColor(0, "vvd") 	= color_hide;
			sheetObjects[0].CellBackColor(0, "bl_no") 	= color_show;
			sheetObjects[0].CellBackColor(0, "bkg_no") 	= color_hide;
    	} else if(loadOption == '3'){
    		//alert("load_option_grid03");
    		//grid03에BKG_NO COLOR 넣기  
    		sheetObjects[0].CellBackColor(0, "vvd") 	= color_hide;
			sheetObjects[0].CellBackColor(0, "bl_no") 	= color_hide;
			sheetObjects[0].CellBackColor(0, "bkg_no") 	= color_show;
    	}
		
    } 
    
    
    /*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		var fStatusCnt = 0;
  		var cntr_nos = '';
  		
  		with(sheetObj) {
	  		switch(flag) {

	  		case 'by_ofc':
	  			//cntr_nos값을 reset
	  			formObj.cntr_nos.value = "";
	  			var sheetObj 	= sheetObjects[0];
	  			with(sheetObj)
	  			{
	  				for(var i=1; i <= sheetObj.RowCount; i++) {
	  					var cntrNo		= CellValue(i, "cntr_no");
  						var chgStsCd	= CellValue(i, "dmdt_chg_sts_cd");
  						var auditResult = CellValue(i, "audit_result");
  						
	  					//[로직] 조회 대상중 Coincidence + F상태만을 대상으로 함
	  					if(auditResult == "Coincidence" && chgStsCd == 'F'){
	  						fStatusCnt 	+= 1;
	  						if(i == sheetObj.RowCount){
	  							cntr_nos	+= cntrNo;
	  						} else {
	  							cntr_nos	+= cntrNo +",";	  							
	  						}
	  					}
	  				} //End of the for loop
	  			}
	  			
	  			//EES_DMT_3001을 팝업으로 호출하기 위해서 HIDDEN으로  처리. 데이터는  팝업화면에서 가져감.
	  			//방법: var opener = window.dialogArguments;
				//      ComSetObjValue(formObj.cntr_no, opener.document.form.cntr_nos.value);
	  			formObj.cntr_nos.value = cntr_nos;
	  			
	  			if(fStatusCnt == 0) {
	  				ComShowCodeMessage('DMT00156');
	  				return;
	  			}
	  			
	  			if(fStatusCnt > 1000) {
	  				ComShowCodeMessage('DMT00157');
	  				return;
	  			}
	  			
	  			var trfCd		= formObj.dmdt_trf_cd.value;
	  			var ofcCd		= formObj.ofc_cd.value;
	  
	  			var paramVal = "?call_flag=P&cntr_no=&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=F&ofc_cd=" + ofcCd;
	  			sUrl = 'EES_DMT_3001P.do' + paramVal
	  			
          		sWidth	= '1010';
          		sHeight	= '680';
  				break;
  				
	  			case 'by_bkg':
	  				var chkRow = 0;
	  				if(SelectRow > 0) {
	  					chkRow = SelectRow;
	  				}
	  				
		  			var bkgNo		= CellValue(chkRow , "bkg_no");
		  			var blNo		= CellValue(chkRow , "bl_no");
		  			var trfCd		= formObj.dmdt_trf_cd.value;
		  			var chgStsCd	= CellValue(chkRow , "dmdt_chg_sts_cd");
		  			if(bkgNo == '' && blNo == ''){
		  				ComShowCodeMessage('DMT02030');
		  				return;
		  			}
		  			  			
		  			var paramVal	= "?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
	  				sUrl	= 'EES_DMT_3002P.do' + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  			
	  			case 'by_cntr':
	  				var chkRow = 0;
	  				if(SelectRow > 0) {
	  					// 체크된 Row가 없으면, 포커스가 위치한 Row의 팝업 호출
	  					chkRow = SelectRow;
	  				}
		  			
		  			var svrId		= CellValue(chkRow , "svr_id");
		  			var cntrNo		= CellValue(chkRow , "cntr_no");
		  			var cntrCycNo	= CellValue(chkRow , "cntr_cyc_no");
		  			var trfCd		= CellValue(chkRow , "dmdt_trf_cd");
		  			var chgLocDivCd	= CellValue(chkRow , "dmdt_chg_loc_div_cd");
		  			var chgSeq		= CellValue(chkRow , "chg_seq");
		  			if(svrId == '' || cntrNo == '' || cntrCycNo == '' || trfCd == '' 
		  				|| chgLocDivCd == '' || chgSeq == '' ){
		  				ComShowCodeMessage('DMT02029');
		  				return;
		  			}
		  			
		  			var paramVal	= "?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
		  			
	  				sUrl	= 'EES_DMT_3003P.do' + paramVal;
	          		sWidth	= '1010';
	          		sHeight	= '680';
	  				break;
	  				
	  			case 'mvmt_inq':
	  				if(SearchRows == 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				
	  				var inqRow = 0;
	  				if(SelectRow > 0) {
	  					inqRow = SelectRow;
	  				}
	  				
	  				var cntrNo = CellValue(inqRow , "cntr_no");
	  				var cntrTpszCd = CellValue(inqRow , "cntr_tpsz_cd");
	  				
	  				if(cntrNo == ''){
		  				ComShowCodeMessage('DMT02002', 'Cntr No');
		  				return;
		  			}
	  				if(cntrTpszCd == ''){
		  				ComShowCodeMessage('DMT02002', 'Tariff Type Size Code');
		  				return;
		  			}
		  			
	  				var paramVal =	"?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl	= 'EES_CTM_0408.do' + paramVal;
					sWidth	= '1020';
					sHeight	= '680';
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
  		if(sUrl.indexOf('.do') != -1) {
  			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} else if(sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
  		}
  	}
  	

	/**
	 * EES_DMT_4013, EES_DMT_4002 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
	
		if(sheetObj.CheckedRows("CheckBox") == 0) {
 			ComShowCodeMessage('COM12114', 'BKG No');
 			return;
 		}
		
		var ret = fnc_delt_rqst_sts_cd(sheetObj, -1);
		 if (ret =='R'){
			 return;
		 }
			
		var url = "EES_DMT_4013.do"
			+"?s_group_by=2"
			+"&s_chg_type="
			+"&jspno=4005"
			;

		var returnValue = ComOpenWindowCenter(url, "EES_DMT_4013", "1020","645", true);
		if(returnValue == "Y") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	

	 /*
	  * Billing 시 delt_rqst_sts_cd Check
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return ret
     * @author KIM HYUN HWA
     * @version 2011.10.14
	 */
	function fnc_delt_rqst_sts_cd(sheetObj, Row) {
		 if ( Row < 0 ) {	 
				//2011.10.14 KHH [CHM-201113639-01]			
	     		var chkRows = sheetObj.FindCheckedRow("CheckBox").split("|");

         		var chk_curr_cd = "";
         		var chg_dmdt_trf_cd = "";
         		
				for(var i=0; i < chkRows.length-1; i++) {
     			    var delt_rqst_sts = sheetObj.CellValue(chkRows[i], "dmdt_delt_rqst_sts_cd"); 
  					var trfCd         = sheetObj.CellValue(chkRows[i], "dmdt_trf_cd");  
  					var currCd        = sheetObj.CellValue(chkRows[i], "bzc_trf_curr_cd");
     			 
					if(delt_rqst_sts=='R'){
						ComShowCodeMessage('DMT01154');
						return "R";
					}

               		if( i == 0 ){
               			chg_dmdt_trf_cd = trfCd;
               			chk_curr_cd = currCd;
               		} else {
               			if( chg_dmdt_trf_cd != trfCd){
            					ComShowCodeMessage('DMT02002', 'Tariff');
            					return "R";
               			}
               			if( chk_curr_cd != currCd ){
            					ComShowCodeMessage('DMT02002', 'Curr.');
            					return "R";
               			}
               		}
				}
	       }else{	
	    	   var delt_rqst_sts = sheetObj.CellValue(Row, "dmdt_delt_rqst_sts_cd"); 
	    	   if(delt_rqst_sts=='R'){
   				  ComShowCodeMessage('DMT01154');
   				 return "R";
   			   }
	       }
			return "N";
	   }
	/* 개발자 작업  끝 */