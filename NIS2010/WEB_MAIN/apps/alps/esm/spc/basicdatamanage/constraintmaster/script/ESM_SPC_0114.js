/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0114.js
*@FileTitle : Import Control Option Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
* 
* 2015.01.02 [CHM-201433401]Control Option Registration - Upload기능 추가 요청
* 2015.01.12 [CHM-201533666] Control Registration 보완요청 - SC/RFA PK로 변경
* 2015.01.30 신자영 [CHM-201533908] Control Option 보완 - SC/RFA컬럼 제거
* 2015.02.17 Arie Im [CHM-201534437]Control Option Registration 기능 보완 - del all check, 상단 검색조건 추가
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
* 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완 - 패키지 이동
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
     * @class ESM_SPC_0114 : ESM_SPC_0114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0114() {
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
    
    
    var dupDataColor = null;
    var errDataColor = null;
    var disableColor = null;
    var enableColor = null;
    var validUploadSave = false;

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
    				
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    				
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;
    					

    			case "btn_close":
    				window.close();
    				break;

//    			case "btn_add":
//    				doActionIBSheet(sheetObject,formObject,IBINSERT);
//    				break;
    				
	    	    case "btn_template_down":
   					//template down
       				var codeCombo = sheetObjects[0].GetComboInfo(0,"aloc_ctrl_tp_cd","Code");
   					var arrCode = codeCombo.split("|");
   					
   					for(var i=0; i<arrCode.length; i++){
   						var row = sheetObjects[1].DataInsert(-1);
   						sheetObjects[1].CellValue(row, "aloc_ctrl_tp_cd") = arrCode[i];
   					}
   					sheetObjects[1].SpeedDown2Excel(-1);
   					sheetObjects[1].RemoveAll();
       				break;
       				
	    	    case "btn_upload":
	    	    	sheetObjects[0].RemoveAll();
	    	    	sheetObjects[0].LoadExcel(true, 1, "", 1, -1, "", false);   					
	    	    	break;

    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    		      ComShowCodeMessage(OBJECT_ERROR);
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
    	
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionLane("lane");
    	SpcSearchOptionBound("bound",false,true,false);
    	
    	for(var i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
		
		//
        dupDataColor = sheetObjects[1].RgbColor(204, 255, 253);//blue
        errDataColor = sheetObjects[1].RgbColor(255, 255, 128);//yellow
        disableColor = sheetObjects[1].RgbColor(239, 240, 243);//grey
        enableColor = sheetObjects[1].RgbColor(255, 255, 255);//white
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
   			 case 1:      //sheet1 init
 				with (sheetObj) {
   				        				 
 					style.height = GetSheetHeight(19) ;// 높이 설정 					
 					SheetWidth = mainTable.clientWidth;//전체 너비 설정
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
 					MergeSheet = msNone;//msPrevColumnMerge + msHeaderOnly;//전체Merge 종류 [선택, Default msNone] 
 					Editable = true; //전체Edit 허용 여부 [선택, Default false]
 					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitColumnInfo(14, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
 					InitHeadMode(true, false, true, true, false, false);     					
 					var HeadTitle  = "Del.|Fixed\nFlag|Sts|Rep. Trade|Sub Trade|Lane|Bound|Control|ECC/Contract|Office|Account/Commodidy|Valid|UploadFlag|";
 					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++,	dtDelCheck,		40,	  daCenter,		true,	"delt_flg");
					InitDataProperty(0, cnt++,  dtCheckBox,   	50,   daCenter,  	true,   "ctrl_fx_rt_flg",   	false,  "",  dfNone,    	0, 		true,  false); 		//Fixed Rate Apply
 					InitDataProperty(0, cnt++, 	dtHiddenStatus, 20,   daCenter,  	true,   "ibflag",     			false,  "",  dfNone,    	0,     	false, false);     					
// 					InitDataProperty(0, cnt++, 	dtStatus, 		30,   daCenter,  	true,   "ibflag",     			false,  "",  dfNone,    	0,     	false, false);

 					InitDataProperty(0, cnt++ , dtData,  		80,  daCenter,  	true,	"trd_cd",  				true,   "",  dfNone,   		0, 		false, false);	//	Rep Trade
 					InitDataProperty(0, cnt++ , dtData,  		80,  daCenter,  	true,	"sub_trd_cd",  			true,   "",  dfNone,   		0, 		false, false);	//	Sub Trade
 					InitDataProperty(0, cnt++ , dtData,  		70,  daCenter,  	true,	"rlane_cd",  			true,   "",  dfNone,   		0, 		false, false);	//	Lane
 					InitDataProperty(0, cnt++ , dtData,  		60,  daCenter,  	true,	"dir_cd",  				true,   "",  dfNone,   		0, 		false, false);	//	Bound
 					
 					InitDataProperty(0, cnt++ , dtCombo,  		100,  daCenter,  	false,	"aloc_ctrl_tp_cd",   	true,   "",  dfNone,   		0, false, true);	//	Control   					
 					InitDataProperty(0, cnt++ , dtPopup,  		100,  daCenter,  	false,	"ctrl_loc_acct_cd",  	true,   "",  dfNone,   		0, false, true, 10);	//	Code
 					InitDataProperty(0, cnt++ , dtData,  		90,  daCenter,  	false,	"ofc_cd",  			 	false,  "",  dfNone,   		0, false, true);	//	Code
 					InitDataProperty(0, cnt++ , dtData,  		130,  daCenter,  	false,	"aloc_ctrl_dtl_cd",  	false,  "",  dfNone,   		0, false, true);	//	Code
// 					InitDataProperty(0, cnt++ , dtData,  		100,  daCenter,  	false,	"rfa_no",  			 	false,  "",  dfNone,   		0, false, true);	//	Code
 					InitDataProperty(0, cnt++ , dtHidden,  		50,  daCenter,  	false,	"isValid",  		 	false,  "",  dfNone,   		0, false, false);	//	valid check
 					InitDataProperty(0, cnt++ , dtHidden,  		30,  daCenter,  	false,	"is_upload",  		 	false,  "",  dfNone,   		0, false, false);	//	upload
 					InitDataProperty(0, cnt++ , dtData,  		10,  daCenter,  	false,	"t",  		 			false,  "",  dfNone,   		0, false, false);	//	padding

 					InitDataCombo (0, "aloc_ctrl_tp_cd", "ECC|Loc Group|Contract(I/Acct)|Contract(A/Acct)|Contract(Commodity)|Contract(Fixed)", "E|G|A|B|C|F");
 					
 					HeadRowHeight = 20 ;    					
					
 			   	}
 				break;
 				
   			 case 2:      //sheet2 init
  				with (sheetObj) {
    				        				 
  					style.height = GetSheetHeight(9) ;// 높이 설정      					
  					SheetWidth = mainTable2.clientWidth;//전체 너비 설정      					
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]

  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(10, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다 ([SortEnable], [ColumnMove], [AllCheckEnable],  [UserResize], [RowMove],[Head3D]) 
  					InitHeadMode(false, false, false, false, false, false);     					
  					var HeadTitle  = "Fixed\nFlag|Rep. Trade|Sub Trade|Lane|Bound|Control|ECC/Contract|Office|Account/Commodidy";
  					InitHeadRow(0, HeadTitle, false);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					
  					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtCheckBox,   	50,   daCenter,  	true,   "ctrl_fx_rt_flg",   	false,  "",  dfNone,    	0, 		true,  false); 		//Fixed Rate Apply
  					InitDataProperty(0, cnt++ , dtData,  		100,  daCenter,  	true,	"trd_cd",  		true,  "",  dfNone,   		0, 		false, false);	//	Rep Trade
 					InitDataProperty(0, cnt++ , dtData,  		80,  daCenter,  	true,	"sub_trd_cd",  	true,  "",  dfNone,   		0, 		false, false);	//	Sub Trade
 					InitDataProperty(0, cnt++ , dtData,  		100,  daCenter,  	true,	"rlane_cd",  	true,  "",  dfNone,   		0, 		false, false);	//	Lane
 					InitDataProperty(0, cnt++ , dtData,  		80,  daCenter,  	true,	"dir_cd",  		true,  "",  dfNone,   		0, 		false, false);	//	Bound
 					InitDataProperty(0, cnt++ , dtCombo,  		100,  daCenter,  	false,	"aloc_ctrl_tp_cd",   true,  "",  dfNone,   		0, false, true);	//	Control   					
 					InitDataProperty(0, cnt++ , dtPopup,  		120,  daCenter,  	false,	"ctrl_loc_acct_cd",  true,  "",  dfNone,   		0, false, true);	//	Code
 					InitDataProperty(0, cnt++ , dtData,  		100,  daCenter,  	false,	"ofc_cd",  			 false,  "",  dfNone,   		0, false, true);	//	Code
 					InitDataProperty(0, cnt++ , dtData,  		120,  daCenter,  	false,	"aloc_ctrl_dtl_cd",  			 false,  "",  dfNone,   		0, false, true);	//	Code
 					InitDataProperty(0, cnt++ , dtData,  		120,  daCenter,  	false,	"dest_grp",  		 false,  "",  dfNone,   		0, false, true);	//	Code

  					InitDataCombo (0, "aloc_ctrl_tp_cd", "ECC|Loc Group|Contract(I/Acct)|Contract(A/Acct)|Contract(Commodity)|Contract(Fixed)", "E|G|A|B|C|F");
 					HeadRowHeight = 20 ;    					
						
  			   	}
  				break;
		}

    }

    /*화면이 로드 되면서 바로 retrieve 되도록 */
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
     * Sheet관련 프로세스 처리
     */ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

    		case IBSEARCH:		//조회
    			// 업무처리중 버튼사용 금지 처리
    			sheetObj.WaitImageVisible = false;
    			ComOpenWait(true);
    			formObj.f_cmd.value = SEARCHLIST;
    			sheetObj.DoSearch4Post("ESM_SPC_0114GS.do", FormQueryString(formObj));
    			ComOpenWait(false);
    			break;

    		case IBSAVE:				//저장
    			if(validateUpload(sheetObj,formObj)){

	    			// 업무처리중 버튼사용 금지 처리
	    			sheetObj.WaitImageVisible = false;
	    			ComOpenWait(true);
	    			formObj.f_cmd.value = MULTI;
	    			var rslt = sheetObj.DoAllSave("ESM_SPC_0114GS.do", FormQueryString(formObj));
	    			
	    			sheetObj.CheckAll("delt_flg") = false;
	    			if(rslt) {
	    				ComShowCodeMessage("COM130102", "Data");
	    				formObj.f_cmd.value = SEARCHLIST;
	        			sheetObj.DoSearch4Post("ESM_SPC_0114GS.do", FormQueryString(formObj));
	    			}
	    			ComOpenWait(false);
    			}
    			break;

//    		case IBINSERT:			// 입력
//    			sheetObj.DataInsert();
//    			break;
    			
 		   case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;	
    			
// 		   case COMMAND02: //sheet2 save for upolad
//
//			   var cR = sheetObj.FindText("isValid", "N");
//			   if(cR > 0){
//				   ComShowCodeMessage("COM12114", "Data");
//				   sheetObj.SelectCell(cR,2);
//                   return false;
//               } else {
//    			   formObj.f_cmd.value = COMMAND02;
//    			   var param = SpcFormString(formObj,"f_cmd");
//    			   var rtn = sheetObj.DoAllSave("ESM_SPC_0052GS.do", param);	    				
//               }
//				
//			   break;	
    			
    	}
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	//	if (!isNumber(iPage)) {
    	//
    	//		return false;
    	//	}
    	}

    	return true;
    }
    
    
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	if(sheetObj.ColSaveName(Col) == "ctrl_loc_acct_cd") {
    		// 2014.12.10 Actual/Individual Customer 모두 contract code base로 
    		// 2014.12.12 A: Individual (Booking의 계약 화주) B: Actual (실제화주) C:Booking commodity
    		if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "A") {
    			url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no=&sc_no=&rfa_no=&svc_scp_cd=&app_dt=&type=A";
    		} else if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "B") {
    			url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no=&sc_no=&rfa_no=&svc_scp_cd=&app_dt=&type=B";
    		} else if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "C") {
    			url = "ESM_SPC_0073.do?pgmNo=ESM_SPC_0073&bkg_no&sc_no=&rfa_no=&svc_scp_cd=&app_dt=&type=C";
    		} else {
    			url = "COM_ENS_051.do?pgmNo=COM_ENS_051";
    		}// Control 콤보를 Ecc, Loc 선택시    			
    		ComOpenPopup(url, 800, 420, "callBackPopup", "0,1,1,1,1,1", true, false, Row, Col, 1);	
    	}
    }
    
    
    function callBackPopup(aryPopupData, Row, Col, ShtIdx) {	
    	var mainRow = sheetObjects[0].SelectRow;
    	var aloc_ctrl_tp_cd = sheetObjects[0].CellValue(Row, "aloc_ctrl_tp_cd");
    	for(var i=0; i<aryPopupData.length; i++) {	    			    		
    		if(i == 0) { // 팜업에서 1개만 선택시
    			if(aloc_ctrl_tp_cd == "E") { //ECC 선택시
    				sheetObjects[0].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][10];
    			}
    			else if(aloc_ctrl_tp_cd == "L") { //Loc 선택시
    				sheetObjects[0].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][3];
    			}
    			else {
    				sheetObjects[0].CellValue2(Row, "ctrl_loc_acct_cd") = aryPopupData[i][4];
    				sheetObjects[0].CellValue2(Row, "aloc_ctrl_dtl_cd") = aryPopupData[i][3];

    			}
    		}
    		else { // 팝업에서 2개 이상 선택시	    			
				var detailRow = sheetObjects[1].DataInsert(-1);
				sheetObjects[0].CellValue2(detailRow, "trd_cd") = sheetObjects[0].CellValue(mainRow, "trd_cd");
				sheetObjects[0].CellValue2(detailRow, "sub_trd_cd") = sheetObjects[0].CellValue(mainRow, "sub_trd_cd");
				sheetObjects[0].CellValue2(detailRow, "rlane_cd") = sheetObjects[0].CellValue(mainRow, "rlane_cd");
				sheetObjects[0].CellValue2(detailRow, "dir_cd") = sheetObjects[0].CellValue(mainRow, "dir_cd");
				sheetObjects[0].CellValue2(detailRow, "aloc_ctrl_tp_cd") = aloc_ctrl_tp_cd;
				if(aloc_ctrl_tp_cd == "E") { //ECC 선택시
					sheetObjects[0].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][10];	   
				}
				else if(aloc_ctrl_tp_cd == "L") {  //Loc 선택시
					sheetObjects[0].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][3];	
				}
				else {
    				sheetObjects[0].CellValue2(detailRow, "ctrl_loc_acct_cd") = aryPopupData[i][4];
    				sheetObjects[0].CellValue2(detailRow, "aloc_ctrl_dtl_cd") = aryPopupData[i][3];

				}
    		}
    	}
    		    	
    }
    
    
	/**
     * Up Load 값의 유효성 체크
     */
    function validateUpload(sheetObj, formObj) {
    	//code
    	//trd_cd, sub_trd_cd, rlane_cd, dir_cd, aloc_ctrl_tp_cd, ctrl_loc_acct_cd, sc_no, rfa_no
    	//SMP의 Validation	    	 
//    	TPS 제외한 경우, individual customer 가 필수	   
//    	AES Customer별 Yield Group별 RFA 중복체크	   
//    	TPS 제외한 경우 Individual Customer로 중복체크	   
//    	TPS는 SC로 중복체크	 
    	var curRlane = '';
    	var curTrade = '';
    	var curSubTrade = '';
    	var searchIndexR = -1;
    	var ctrlTp = '';
    	var isValid = true;
    	var validLane = true;
    	var validAgmt = true;   	
    	
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++) {
    		var sts = sheetObj.CellValue(i, "ibflag");
    		if(sts != 'D') {
	    		//TRADE, SUB TRADE, LANE정보 체크
	    		curRlane = sheetObj.CellValue(i, "rlane_cd");
	    		curTrade = sheetObj.CellValue(i, "trd_cd");
	    		curSubTrade = sheetObj.CellValue(i, "sub_trd_cd");
	    		ctrlTp = sheetObj.CellValue(i, "aloc_ctrl_tp_cd");
	    		var tmpValL = true;
	    		var tmpValAg = true;
	    		
	    		//초기화
	    		sheetObj.CellValue2(i, "isValid") = '';
	    		sheetObj.CellValue2(i, "is_upload") = 'Y';
	    		sheetObj.RowBackColor(i) = enableColor;
				sheetObj.CellBackColor(i, "trd_cd") = disableColor;
				sheetObj.CellBackColor(i, "sub_trd_cd") = disableColor;
				sheetObj.CellBackColor(i, "rlane_cd") = disableColor;
				
	    		searchIndexR = comObjects[2].FindIndex(curRlane, 2);
	    		if(searchIndexR < 0 || comObjects[2].GetText(searchIndexR,0) !=  curTrade || comObjects[2].GetText(searchIndexR,1) !=  curSubTrade){
	    			sheetObj.CellBackColor(i, "trd_cd") = errDataColor;
	    			sheetObj.CellBackColor(i, "sub_trd_cd") = errDataColor;
	    			sheetObj.CellBackColor(i, "rlane_cd") = errDataColor;
	    			validLane = false;
	    			tmpValL = false;
	    		}
	
	    		if(ctrlTp == 'A' || ctrlTp == 'B' || ctrlTp == 'C' ) {
//	    			if(sheetObj.CellValue(i, "sc_no").length < 2 && sheetObj.CellValue(i, "rfa_no").length < 2) {
//	    				sheetObj.CellBackColor(i, "sc_no") = errDataColor;
//	    				sheetObj.CellBackColor(i, "rfa_no") = errDataColor;
//	    				validAgmt = false;
//	    				tmpValAg = false;
//	    			}
	    			if(sheetObj.CellValue(i, "aloc_ctrl_dtl_cd").length < 2 ) {
	    				sheetObj.CellBackColor(i, "aloc_ctrl_dtl_cd") = errDataColor;
	    				validAgmt = false;
	    				tmpValAg = false;
	    			}
	    			//Fixed가 아닐경우 Fixed Flag 컬럼 비활성화
	    			sheetObj.CellEditable(i, "ctrl_fx_rt_flg") = false;

	    		}else if(ctrlTp == 'F'){
	    			sheetObj.InitCellProperty ( i , "ctrl_loc_acct_cd" , dtData , daCenter , "ctrl_loc_acct_cd" , "" , dfNone );
    	    		sheetObj.InitCellProperty ( i , "aloc_ctrl_dtl_cd" , dtData , daCenter , "aloc_ctrl_dtl_cd" , "" , dfNone );
    	    		//aloc_ctrl_dtl_cd는 값없으며 입력 불가 (저장될때 ECC/Loc Group/Contract와 동일하게 저장)
    	    		sheetObj.CellValue2(i, "aloc_ctrl_dtl_cd") = "";
    	    		sheetObj.CellEditable(i, "aloc_ctrl_dtl_cd") = false;
	    			
	    		}else{
	    			//Fixed가 아닐경우 Fixed Flag 컬럼 비활성화
	    			sheetObj.CellEditable(i, "ctrl_fx_rt_flg") = false;
	    		}
	    		
	    		sheetObj.CellValue2(i, "isValid") = tmpValL&&tmpValAg?"Y":"N";    
    		}
    	}
    	
		//모든 중복
		var duprows = sheetObj.ColValueDupRows("trd_cd|sub_trd_cd|rlane_cd|dir_cd|aloc_ctrl_tp_cd|ctrl_loc_acct_cd|aloc_ctrl_dtl_cd",false,true);
		var arrRow  = duprows.split(",");
		
		for (var idx=0; idx<arrRow.length; idx++){ 
			var tmpArr = arrRow[idx].split("|");
			for(var j=0; j < tmpArr.length; j++) {
				if(tmpArr[j] != '') {
					var tmpVal = sheetObj.CellValue(tmpArr[j], "isValid");
					if(isValid) isValid = false;
	    			sheetObj.RowBackColor(tmpArr[j]) = dupDataColor;
	    			if(tmpVal == 'Y' || tmpVal == '') sheetObj.CellValue2(tmpArr[j], "isValid") = "N";
				}
			}

		}
		

		//TPS의 SC 중복
//		var duprows1 = sheetObj.ColValueDupRows("trd_cd|sub_trd_cd|rlane_cd|dir_cd|aloc_ctrl_tp_cd|ctrl_loc_acct_cd|sc_no",false,true);
//		var arrRow1  = duprows1.split(",");
//
//		for (var idx=0; idx<arrRow1.length; idx++){ 
//			var tmpArr = arrRow1[idx].split("|");
//			for(var j=0; j < tmpArr.length; j++) {
//				if(tmpArr[j] != '') {
//					if(sheetObj.CellValue(tmpArr[j], "trd_cd") == 'TPS') {
//						var tmpVal = sheetObj.CellValue(tmpArr[j], "isValid");
//						if(isValid) isValid = false;
//						sheetObj.RowBackColor(tmpArr[j]) = dupDataColor;
//						if(tmpVal == 'Y' || tmpVal == '') sheetObj.CellValue2(tmpArr[j], "isValid") = "N";
//					}
//				}
//			}
//			
//		}
		

//		//TPS가 아닌노선의 RFA중복
//		var duprows2 = sheetObj.ColValueDupRows("trd_cd|sub_trd_cd|rlane_cd|dir_cd|aloc_ctrl_tp_cd|ctrl_loc_acct_cd|rfa_no",false,true);
//		var arrRow2  = duprows2.split(",");
//
//		for (var idx=0; idx<arrRow2.length-1; idx++){ 
//			var tmpArr = arrRow2[idx].split("|");
//			for(var j=0; j < tmpArr.length; j++) {
//				if(tmpArr[j] != '') {
//	    			if(sheetObj.CellValue(tmpArr[j], "trd_cd") != 'TPS') {
//						var tmpVal = sheetObj.CellValue(tmpArr[j], "isValid");
//						if(isValid) isValid = false;
//						sheetObj.RowBackColor(tmpArr[j]) = dupDataColor;
//						if(tmpVal == 'Y' || tmpVal == '') sheetObj.CellValue2(tmpArr[j], "isValid") = "N";
//	    			}
//				}
//			}
//		}	

		var msg = '';
		
		if(!isValid) { 
			msg = getMsg("SPC90135");
		}
    	
		if(!validAgmt) { 
			msg = msg + '\n' + getMsg("SPC90202", "SC NO", "RFA NO");
		}
		
		if(!validLane) { 
			msg = msg + '\n' + getMsg("SPC90203", "Rep. Trade", "Sub Trade", "Lane");
		}
	
		if(!isValid||!validAgmt||!validLane) ComShowMessage(msg);
		
		return (isValid && validLane && validAgmt);
    }	
    
    
    function sheet1_OnLoadExcel(){
    	var sObj = sheetObjects[0];
    	var curRlane = "";
    	for(var i = sObj.RowCount+1;  i > 1; i--) {
			curRlane = ComTrim(sObj.CellValue(i, "rlane_cd"));
			if(curRlane == '') {
				sObj.CellValue2(i, "ibflag") = 'D';
				sObj.RowDelete(i, false);
			}
		}  	
     	validateUpload(sObj, document.form);
    }
    
    
	function initDataValue_trade(){
    	var sheetObj = document.getElementById("trade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_subtrade(){
    	var sheetObj = document.getElementById("subtrade");
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
    
    
	/*
	 *  trade변경시
	 */
	function trade_OnChange(comObj,value,text){		
//		if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
    	//sub_trade value change  
    	comObjects[1].Index2 = 0; 
    	//lane value change
    	comObjects[2].Index2 = 0;
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
	}
				
	/*
	 * sub_trade변경시
	 */
	function subtrade_OnChange(comObj,value,text ){
		SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    	if(value == "" ) return;
     	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    	}     	    
	    //lane value change
	    comObjects[2].Index2 = 0;        
  	} 
   
   	/*
	 * lane변경시
	 */
   	function lane_OnChange(comObj,value,text ){
		var repTrade = comObj.GetText(value,0);  
	    var subTrade = comObj.GetText(value,1);
	    if(value != "" ){  
		   	comObjects[0].Code2 = repTrade;		   	
		   	comObjects[1].Code2 = subTrade;
	 	}else{
	 		comObjects[0].Code2 = "";
			comObjects[1].Code2 = "";
	    }
   	} 
   	
    function sheet1_OnChange(sheetObj, Row, Col, Value){
		var sName = sheetObj.ColSaveName(Col);
		var formObject = document.form;
		switch(sName){
		    //입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
		    case "ctrl_loc_acct_cd":
		    	if(sheetObj.CellValue(Row, "aloc_ctrl_tp_cd") == "F" && sheetObj.CellValue(Row, "ctrl_loc_acct_cd") != ""){
		    		var param = "f_cmd=" + SEARCHLIST07 + "&scNo="+Value;
		            var sXml = sheetObj.GetSearchXml("ESM_SPC_0052GS.do", param);
					var ScNoCnt = ComGetEtcData(sXml, "ScNoCnt");
					if(ScNoCnt == 0){
	    				ComShowMessage(getMsg("SPC90306", Value)); //'Contract No (' + msg1 + ') is invalid.'
	    				sheetObj.CellValue(Row, "ctrl_loc_acct_cd") = "";
					}
		    	}
		   break;
		}    	
	}
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    		if(sheetObj.CellValue(i, "aloc_ctrl_tp_cd") != "F") {
    			sheetObj.CellEditable(i, "ctrl_fx_rt_flg") = false;
    		}
    	}
    } 
    
	/* 개발자 작업  끝 */