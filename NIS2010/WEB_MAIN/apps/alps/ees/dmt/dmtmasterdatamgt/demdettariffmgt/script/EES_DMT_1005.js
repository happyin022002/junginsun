/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1005.js
*@FileTitle : Commodity Exception Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.26 김태균
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
     * @class EES_DMT_1005 : EES_DMT_1005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_1005() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
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

	
	//  업무전역변수
    var CONTINENT   = "CONTI";
    var COUNTRY     = "CNT";
    var REGION      = "RGN";
    var STATE       = "STE";
    var LOCATION    = "LOC";
	
    var COMMON_TARIFF_CD 	= "common_tariff_cd"; 
    
	var ORIGIN 		= "Origin";
	var DESTINATION = "Destination";

	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	var Mincount = 0 ;
	
	var IBUPDATE = 51;
	var IBEXPIRE = 52;
	var IBNOTIUPDATE = 53;
	
	
	/*
	 * 콤보에 선택된 항목을 변경할 경우 OnChange 이벤트 발생으로 조회된 결과를 
	 * 상위나 하위 콤보박스에  넣어줄 때 의도적이지 않게 재차발생되어지는 OnChange 이벤트를 막기 위한 변수
	 */
	var isNoChangeActive = false;
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObject1 = sheetObjects[0];
			 	 
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

				case "btn_RowAdd":
	        		doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
	
				case "btn_RowCopy":
					
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;
	
				case "btn_Delete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;
					
				case "btn_Update":
					doActionIBSheet(sheetObject1,formObject,IBUPDATE);
					break;
	
				case "btn_Expire":
					doActionIBSheet(sheetObject1,formObject,IBEXPIRE);
					break;
					
				case "btn_Noti_Update":
					doActionIBSheet(sheetObject1,formObject,IBNOTIUPDATE);
					break;
					
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
	
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
     	//현재일자 초기화 셋팅
    	var formObj = document.form;
    	var data = getDefaultDate(0).split("|");
     	ComSetObjValue(formObj.today, data[1].substring(0,4)+data[0].substring(5,7)+data[0].substring(8,10));
		
        //Axon 이벤트 처리
        initAxonControl();
        
        DisableControls();
    }
    
    // 화면 깜빡임때문에 sheet1_OnLoadFinish 이벤트 적용
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;

    	doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
    	
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

            case "sheet1":      // sheet4 init
                with (sheetObj) {
					// 높이 설정
                	style.height = 382;
					SheetWidth = mainTable.clientWidth;

				 	// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//MergeSheet = msPrevColumnMerge + msHeaderOnly;
					

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||Seq.|Commodity|Commodity|Commodity|EFF DT|EXP DT|Tariff\nRule No.|Free Time|Free Time|F/T Exclusion|F/T Exclusion|F/T Exclusion|Update|Update|Update|PIC Team|Notification User|Notification User|svr_id|trf_seq|cmdt_trf_seq|dmdt_trf_cd|org_cmdt_cd|org_eff_dt|org_exp_dt|org_cmdt_add_dys|org_cmdt_ttl_dys|org_xcld_sat_flg|org_xcld_sun_flg|org_xcld_hol_flg|org_trf_rule_no|org_trf_mng_usr_id";
					var HeadTitle2 = "||Seq.|Code|Description|Rep.|EFF DT|EXP DT|Tariff\nRule No.|Add|Total|SAT|SUN|H/day|Date|Office|Name|PIC Team|MGR+PIC ID|MGR+PIC NM|svr_id|trf_seq|cmdt_trf_seq|ddmt_trf_cd|org_cmdt_cd|org_eff_dt|org_exp_dt|org_cmdt_add_dys|org_cmdt_ttl_dys|org_xcld_sat_flg|org_xcld_sun_flg|org_xcld_hol_flg|org_trf_rule_no|org_trf_mng_usr_id";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, 	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		0,		daCenter,		true,		"check");
                    InitDataProperty(0,	cnt++ ,	dtSeq,			35,		daCenter,		true,		"seq",					false,		"",			dfNone,			0,			false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,	70,		daCenter,		true,		"cmdt_cd",				true,		"",			dfNone,			0,			false, 		true , 8)  ;
                    InitDataProperty(0, cnt++ , dtData,			260,	daLeft,			true,		"cmdt_nm",				false,		"",			dfNone,			0,			false, 		false);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"rep_cmdt_cd",			false,		"",			dfNone,			0,			false, 		false);//EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP

                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		"eff_dt",				true,		"",			dfDateYmd,		0,			false, 		true,		10, 	false,		true,	"Effective Date");
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		"exp_dt",				false,		"",			dfDateYmd,		0,			false, 		true,		10,		false,		true,	"Expiration Date");
                    InitDataProperty(0, cnt++ , dtHidden,		75,		daCenter,		true,		"trf_rule_no",			false,		"",			dfNone,			0,			false, 		true,		10,		false,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		"cmdt_add_dys",			false,		"",			dfNullInteger,	0,			false, 		true,		2);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"cmdt_ttl_dys",			false,		"",			dfNullInteger,	0,			false, 		true,		2);
                    InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,		true,		"xcld_sat_flg",			false,		"",			dfNone,			0,			false, 		true,		-1,		false,		true,	"",	false);

                    InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,		true,		"xcld_sun_flg",			false,		"",			dfNone,			0,			false, 		true,		-1,		false,		true,	"",	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,		true,		"xcld_hol_flg",			false,		"",			dfNone,			0,			false, 		true,		-1,		false,		true,	"",	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		true,		"upd_dt",				false,		"",			dfNone,			0,			false, 		false);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		"upd_ofc_cd",			false,		"",			dfNone,			0,			false, 		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"upd_name",				false,		"",			dfNone,			0,			false, 		false,		20);

                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"pic_team",				false,		"",			dfNone,			0,			false, 		false, 		-1);
                    InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,		true,		"trf_mng_usr_id",		false,		"",			dfNone,			0,			false,  	true,  		20,		false,		true,	"",	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"trf_mng_usr_nm",		false,		"",			dfNone,			0,			false, 		false, 		-1);
                    
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"svr_id");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"trf_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"cmdt_trf_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"dmdt_trf_cd");

                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_cmdt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_eff_dt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_exp_dt");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_cmdt_add_dys");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_cmdt_ttl_dys");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_xcld_sat_flg");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_xcld_sun_flg");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_xcld_hol_flg");
                    
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_trf_rule_no");
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,			true,		"org_trf_mng_usr_id");
                    
//					ShowButtonImage = 2;		// 항상 팝업 이미지 표시
                    InitDataCombo(0, "trf_rule_no", "", "");
					CountPosition = 0;			// 건수 정보를 표시하지 않음
					ToolTipOption = "balloon:true;width:50;";
					SpaceDupCheck = false;
					
			  	}
				break;         	
        }
    }    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        		ComSetObjValue(formObj.f_cmd, SEARCH);
				setParameters(SEARCH);

				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {

	                    //ComOpenWait Start
	                    //sheetObj.WaitImageVisible=false;	//sheet1_OnSearchEnd event 충돌로 인하여 삭제
	                    //ComOpenWait(true);

	                    //2.조회조건으로 조회실행
						sheetObj.DoSearch("EES_DMT_1005GS.do", FormQueryString(formObj));

	                    //ComOpenWait End
	                    //ComOpenWait(false);
	                    
					}
				}
				break;	

        	case IBINSERT:
        		sheetObj.DataInsert(-1);
        		break;
        	case IBCOPYROW:
        		var row = sheetObj.DataCopy();
        		sheetObj.CellValue2(row, "upd_ofc_cd") = "";
        		sheetObj.CellValue2(row, "upd_name") = "";
        		
        		break;
        	case IBDELETE:
        		var checkcnt = 0;
    			for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
    				if(sheetObj.CellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			//체크를 하나도 하지 않은 경우
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    			
    			if ( sheetObj.CellValue(sheetObj.SelectRow,0) != "I" ) {
    			
            		if(ComShowCodeConfirm("DMT00145")){
            			for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
            		    	var sValue = sheetObj.CellValue(i, "eff_dt");
            		    	
            		    	//삭제 체크 로직
            		    	if(sheetObj.CellValue(i, "check") == "1") {
            		    		//신규등록은 무조건 삭제함.
            		    		if(sheetObj.RowStatus(i) == "I") {
            		    			ComRowHideDelete(sheetObj, "check");
            		    		}else{
    	        		    		if(ComIsDate(sValue, "ymd")) {
    	        		    			var iDay = ComGetDaysBetween(ComReplaceStr(ComGetObjValue(formObj.today),"-",""), sValue);
    	        		    			if(iDay <= 0 ) {
    	        		    				ComShowCodeMessage("DMT00146","Row Delete["+sheetObj.CellValue(i, "cmdt_cd")+"]");//Effective Date must be later than today for {msg1}!
    	        		    				sheetObj.SelectCell(i, "eff_dt");
    	        		        			return;
    	        		    			}else{
    	        		    				ComRowHideDelete(sheetObj, "check");
    	        		    			}
    	        		    		}else{
    	        		    			ComShowCodeMessage("COM12132");
    	        		    			sheetObj.SelectCell(i, "eff_dt");
    	    		        			return;
    	        		    		}
            		    		}
            		    	}
    
            			}
            		}
        		
    			} else {
                    ComRowHideDelete(sheetObj, "check");
                }        		
        		break;
        	case IBUPDATE:
        		var checkcnt = 0;
    			for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
    				if(sheetObj.CellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    			

        		//if(ComShowCodeConfirm("DMT00145")){
        			for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
        		    	var sValue = sheetObj.CellValue(i, "eff_dt");
        		    	
        		    	//수정 체크 로직
        		    	if(sheetObj.CellValue(i, "check") == "1") {
        		    		//신규 수정일 경우는 제외
        		    		if(sheetObj.RowStatus(i) == "I") {
								sheetObj.CellEditable(i,"eff_dt") = true;
    		    				sheetObj.CellEditable(i,"exp_dt") = true;
    		    				sheetObj.CellEditable(i,"cmdt_add_dys") = true;
    		    				sheetObj.CellEditable(i,"cmdt_ttl_dys") = true;
    		    				sheetObj.CellEditable(i,"xcld_sat_flg") = true;
    		    				sheetObj.CellEditable(i,"xcld_sun_flg") = true;
    		    				sheetObj.CellEditable(i,"xcld_hol_flg") = true;
        		    		}else{
	        		    		if(ComIsDate(sValue, "ymd")) {
	        		    			var iDay = ComGetDaysBetween(ComReplaceStr(ComGetObjValue(formObj.today),"-",""), sValue);
	        		    			if(iDay <= 0 ) {
	        		    				ComShowCodeMessage("DMT00146","Update["+sheetObj.CellValue(i, "cmdt_cd")+"]");//Effective Date must be later than today for {msg1}!
	        		    				sheetObj.SelectCell(i, "eff_dt");
	        		        			return;
	        		        			
	        		    			}else{
										sheetObj.CellEditable(i,"eff_dt") = true;
	        		    				sheetObj.CellEditable(i,"exp_dt") = true;
	        		    				sheetObj.CellEditable(i,"cmdt_add_dys") = true;
	        		    				sheetObj.CellEditable(i,"cmdt_ttl_dys") = true;
	        		    				sheetObj.CellEditable(i,"xcld_sat_flg") = true;
	        		    				sheetObj.CellEditable(i,"xcld_sun_flg") = true;
	        		    				sheetObj.CellEditable(i,"xcld_hol_flg") = true;
	        		    			}
	        		    		}else{
	        		    			ComShowCodeMessage("COM12132");
	        		    			sheetObj.SelectCell(i, "eff_dt");
	    		        			return;
	        		    		}
        		    		}
        		    	}
        			}
        		//}
        		break;
        	case IBEXPIRE:
        		var checkcnt = 0;
    			for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
    				if(sheetObj.CellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    		

				var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
				
        		for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
    		    	var sValue = sheetObj.CellValue(i, "exp_dt");
    		    	
    		    	//Expire 체크 로직
    		    	if(sheetObj.CellValue(i, "check") == "1") {
    		    		//신규 수정일 경우는 제외
    		    		if(sheetObj.RowStatus(i) == "I") {
    		    			sheetObj.CellEditable(i,"exp_dt") = true;
    		    		}else{
	    		    		if(sValue != "" ) {
	    		    			if (ofcCurrDate >= sValue) {
		    		    			//ComShowCodeMessage("DMT00125");
		    		    			ComShowMessage(ComGetMsg("DMT00125")+" ["+sheetObj.CellValue(i,"cmdt_cd")+"]");      
		    		    			sheetObj.SelectCell(i, "exp_dt");
				        			return false;
	    		    			} else {
	    		    				sheetObj.CellEditable(i,"exp_dt") = true;
	    		    			}
	    		    		}else{
			    				sheetObj.CellEditable(i,"exp_dt") = true;
	    		    		}
    		    		}
    		    	}
    			}
        		break;
        	case IBNOTIUPDATE:
        		var checkcnt = 0;
    			for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
    				if(sheetObj.CellValue(i, "check") == "1") {
    					checkcnt++;
    				}
    			}
    			if(checkcnt == 0) {
    				ComShowCodeMessage("COM12114", "Commodity");
    				return;
    			}    		

				var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
				
        		for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
    		    	var sValue = sheetObj.CellValue(i, "trf_mng_usr_id");
    		    	
    		    	//Expire 체크 로직
    		    	if(sheetObj.CellValue(i, "check") == "1") {
    		    		//신규 수정일 경우는 제외
    		    		if(sheetObj.RowStatus(i) == "I") {
		    				sheetObj.CellEditable(i,"trf_mng_usr_id") = true;
    		    		}else{
    		    			sheetObj.CellEditable(i,"trf_mng_usr_id") = true;
    		    		}
    		    	}
    			}
        		break;
	   		case IBCLEAR:       //초기화 
	   			initControl();
	   			DisableControls();
				break;
	   		case IBSAVE:
	   			ComSetObjValue(formObj.f_cmd, MULTI);
				setParameters(MULTI);
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                
                sheetObj.DoSave("EES_DMT_1005GS.do", FormQueryString(formObj), -1, false);
				
                //ComOpenWait End
                ComOpenWait(false);
                
				//재조회
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;		
	   		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					sheetObj.SpeedDown2Excel(-1, false, false, "","",false,false,false,false,"check","",true,"");
				}; 
				break;
	   		case IBSEARCH_ASYNC01:         // 조회

                formObj.f_cmd.value = COMMAND15; 

           		//ComOpenWait Start
	   			sheetObj.WaitImageVisible=false;
	   			ComOpenWait(true);

                var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do",FormQueryString(formObj));
                
                //ComOpenWait End
                ComOpenWait(false);
                
           
                var rtnName = ComGetEtcData(sXml, "rtnName");
                var selRow = document.form.cmdt_row.value;
                if ( rtnName != undefined && rtnName != '') {
                    var rtnNameArr = rtnName.split("|");
                    sheetObjects[0].CellValue2( selRow , 4 ) = rtnNameArr[1];
                    sheetObjects[0].CellValue2( selRow , 5 ) = rtnNameArr[2];                   
                } else {
                    ComShowCodeMessage( "DMT00165" , "Commodity code" );
                    sheetObjects[0].CellValue2( selRow , 3 ) = "";
                    sheetObjects[0].CellValue2( selRow , 4 ) = "";
                    sheetObjects[0].CellValue2( selRow , 5 ) = "";
                }
              
           break;				

	 	   case SEARCH03: //페이지 로딩시 콤보데이터 설정
				ComSetObjValue(formObj.f_cmd,      				SEARCH03);
	 			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************

			    var sXml = sheetObj.GetSearchXml("EES_DMT_7013GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.조회후 결과처리
				return handleNullString(ComGetEtcData(sXml, "USR_NM"));
				
			break;		

	 	   case SEARCH01: //페이지 로딩시 콤보데이터 설정
				ComSetObjValue(formObj.f_cmd,      				SEARCH01);
	 			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
			    var sXml = sheetObj.GetSearchXml("EES_DMT_1005GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				var trf_rule_no_list = ComGetEtcData(sXml, "TRF_RULE_NO_LIST");
				addCellComboItem(sheetObj, trf_rule_no_list, "trf_rule_no", false, true);

			break;
		}			
    }    
    
	function initAxonControl() {  
	    //Axon 이벤트 처리1. 이벤트catch 
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); //- 키보드 입력할때
		axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'org_dest_location');	//Enter시 자동Retrieve

	}
		   
	//Axon 이벤트 처리2. 이벤트처리함수  
	/*
	 * Location 필드 입력문자 대문자로 변환 
	 */		
	function obj_keypress(){ 
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	         
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}
	
	/*
	 * Location FocusOut시 입력값 자리수에 대한 Validation Check
	 */
	function obj_blur() {
		obj = event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110','Location');
			ComClearObject(obj);
			ComSetFocus(obj);
		}
	}
	
	function obj_keydown() {
		if(event.keyCode == 13) {
			//obj = event.srcElement;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var msg ="";
    	
    	with(formObj) {
    		
    		switch(sAction) {
				case IBSEARCH:      //조회
			    	//Tariff Type Valid check
					if(ComTrim(ComGetObjValue(formObj.sel_dmdt_trf_cd)) == "") {
		        		ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Tariff Type"));
		        		return false;
		        	}

			    	//Coverage Continent Valid check
			    	if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
			    		ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Continent"));
			    		return false;
			    	}
			    	
			    	//Coverage Country Valid check
			    	if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
			    		ComAlertFocus(formObj.combo3, ComGetMsg('COM12113', "Coverage Country"));
			    		return false;
			    	}
			    	
			    	//Coverage Country Valid check
			    	if(ComTrim(ComGetObjValue(formObj.org_dest_conti_cd)) == "") {
			    		ComAlertFocus(formObj.combo3, ComGetMsg('COM12113', "Origin Continent"));
			    		return false;
			    	}
		    	
			    	break;
    	
				case IBSAVE:      //저장
			    	//필수입력값 체크
					for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
						
						if(sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U" || sheetObj.RowStatus(i) == "D") {
						
							//Commodity
							if(sheetObj.CellValue(i, "cmdt_cd") == "") {
								ComShowCodeMessage('DMT02002', "Commodity");
								sheetObj.SelectCell(i, "cmdt_cd");
								return false;
							}
							//EFF DT
							if(sheetObj.CellValue(i, "eff_dt") == "") {
								ComShowCodeMessage('DMT02002', "Effective Date");
								sheetObj.SelectCell(i, "eff_dt");
								return false;
							}
							//FREE TIME
							if(sheetObj.CellValue(i, "cmdt_add_dys") == 0 && sheetObj.CellValue(i, "cmdt_ttl_dys") == 0) {
								ComShowCodeMessage('DMT02002', "["+sheetObj.CellValue(i, "cmdt_cd")+"] Free Time");
								sheetObj.SelectCell(i, "cmdt_add_dys");
								return false;
							}
							
                            if(sheetObj.CellValue(i, "cmdt_add_dys") > 0 && sheetObj.CellValue(i, "cmdt_ttl_dys") > 0) {
                                ComShowCodeMessage('DMT02004', "["+sheetObj.CellValue(i, "seq")+"]");
                                sheetObj.SelectCell(i, "cmdt_add_dys");
                                return false;
                            }
							
							//EXP DT, EFF DT보다 이후 날짜인지 체크
							if(sheetObj.CellValue(i, "exp_dt") != "") {
								var ret = ComChkPeriod(sheetObj.CellValue(i, "eff_dt"), sheetObj.CellValue(i, "exp_dt"));	//ret = ComChkPeriod("20080909", "20080908") // 결과 = 0
							     																							//ret = ComChkPeriod("20080909", "20080909") // 결과 = 2
							     																							//ret = ComChkPeriod("20080909", "20080910") // 결과 = 1
							     																							//ret = ComChkPeriod("20080909", "2008")     // 결과 = -1
								//eff_dt > exp_dt
								if(ret < 1) {
				    				ComShowMessage(ComGetMsg("DMT01089", "Expiration Date", "Effective Date"));
				        			sheetObj.SelectCell(i, "exp_dt");
//				        			sheetObj.CellValue2(i, "eff_dt") = "";
									
									return false;
								}
							}
						}
					}
					// data변경없이 check만 했을 경우 체크 박스를 풀어 주는 로직
					for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
						if(sheetObj.RowStatus(i) == "U") {
							if(sheetObj.CellValue(i, "cmdt_cd") == sheetObj.CellValue(i, "org_cmdt_cd")
								&& sheetObj.CellValue(i, "eff_dt") == sheetObj.CellValue(i, "org_eff_dt")
								&& sheetObj.CellValue(i, "exp_dt") == sheetObj.CellValue(i, "org_exp_dt")
								&& sheetObj.CellValue(i, "cmdt_add_dys") == sheetObj.CellValue(i, "org_cmdt_add_dys")
								&& sheetObj.CellValue(i, "cmdt_ttl_dys") == sheetObj.CellValue(i, "org_cmdt_ttl_dys")
								&& sheetObj.CellValue(i, "xcld_sat_flg") == sheetObj.CellValue(i, "org_xcld_sat_flg")
								&& sheetObj.CellValue(i, "xcld_sun_flg") == sheetObj.CellValue(i, "org_xcld_sun_flg")
								&& sheetObj.CellValue(i, "xcld_hol_flg") == sheetObj.CellValue(i, "org_xcld_hol_flg")
								&& sheetObj.CellValue(i, "trf_rule_no") == sheetObj.CellValue(i, "org_trf_rule_no")
								&& sheetObj.CellValue(i, "trf_mng_usr_id") == sheetObj.CellValue(i, "org_trf_mng_usr_id")) 
							{
								sheetObj.CellValue2(i, "check") = 0;
								sheetObj.RowStatus(i) = "R";
							}
						}
					}
					
//					//var dupRows = sheetObj.ColValueDupRows("cmdt_cd",false,true);
//	        		var dupRows = sheetObj.ColValueDupRows("cmdt_cd", false, false);
//	        		alert(dupRows);
//	        		if(dupRows != '') {		
//		        		var arrRow = dupRows.split(",");
//		        		for( var i = 1; i < arrRow.length; i++) {
//		        			alert(i+":"+sheetObj.CellValue(arrRow[i], "cmdt_cd"));
//		        		}
//		        		
//		        		var dupCmdtCd = sheetObj.CellValue(arrRow[0], "cmdt_cd");
//		        		var dupEffDt = sheetObj.CellValue(arrRow[0], "eff_dt");
//			        			        			
//			        	ComShowCodeMessage('DMT00144', "Commodity["+dupCmdtCd+"]");
//			        	sheetObj.SelectRow = arrRow[0];
//			        	return false;
//	        		}
//	        		return false;
	        		
					var temp_code = "";
					var temp_row  = "";
					
	        		// Duplicated Commodity - 동일한 commodity인 경우 eff_dt와 exp_dt 에 포함되면 안됨
	        		for(var i = 2 ; i < sheetObj.RowCount+2 ; i++) {
	        			
	        			for(var j = i+1 ; j < sheetObj.RowCount+2 ; j++) {
		        			// 입력, 수정된 데이터만 체크 한다.
		        			if(sheetObj.RowStatus(j) == "R" || sheetObj.RowStatus(j) == "D")	continue;
		        			
		        			if(sheetObj.CellValue(i, "cmdt_cd") == sheetObj.CellValue(j, "cmdt_cd")){
		        				temp_code   += sheetObj.CellValue(i, "cmdt_cd") + ",";
		        				temp_row	+= j + ",";
		        			}
	        			}
	        		}
	        		var arrData = temp_code.split(",");
	        		var arrRow  = temp_row.split(",");
	        		
	        		for(var i = 0 ; i < arrData.length - 1 ; i++) {
	        			
	        			for(var j = 2 ; j < sheetObj.RowCount+2 ; j++) {
	        				if(j == arrRow[i])	continue;
	        				
	        				if(sheetObj.CellValue(j, "cmdt_cd") != arrData[i])	continue;
	        				
	        				var start_dt = sheetObj.CellValue(j, "eff_dt");
	        				var end_dt   = sheetObj.CellValue(j, "exp_dt");
	        				
	        				if(end_dt == "") 
	        					end_dt = "99991231";
	        				
	        				var temp_eff_dt	= sheetObj.CellValue(arrRow[i], "eff_dt");
	        				var temp_exp_dt	= sheetObj.CellValue(arrRow[i], "exp_dt");
	        				
	        				//eff_dt
	        				if( start_dt <= temp_eff_dt	&& temp_eff_dt <= end_dt) {
	        					ComShowCodeMessage('DMT00144', "Commodity["+sheetObj.CellValue(j, "cmdt_cd")+"]");
	        					return false;
	        				}
	        				if(temp_exp_dt != "") {
		        				if( start_dt <= temp_exp_dt && temp_exp_dt <= end_dt) {
		        					ComShowCodeMessage('DMT00144', "Commodity["+sheetObj.CellValue(j, "cmdt_cd")+"]");
		        					return false;
		        				}
	        				}
	        			}
	        		}
			    	break;
    		}
    	
    	}
		//필수항목에 데이터가 입력되었는지 확인한다.
        return true;
    }
	/** 
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
	} 
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj = document.form
	    
	    switch(comboNo) { 
    	//Tariff Type
    	case 1:
    		with (comboObj) {
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left|left");        
				SetColWidth("55|330");
				DropHeight = 160;
				ValidChar(2,0);		//영문 대문자
				IMEMode = 0;
				MaxLength = 4;
				
    		}
    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObj);
    		break;
    	
    	//Continent
    	case 2: 
    	case 5:
    		with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = false;	
    			SetColAlign("left|left");
    			SetColWidth("30|100");
				DropHeight = 160;
				ValidChar(2,0);		//영문 대문자
				IMEMode = 0;
				MaxLength = 1;
				
	    	}
    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
			break;
    	
    	//Country
    	case 3:
    	case 6:
    		with (comboObj) {
    			MultiSelect = false;
    			UseAutoComplet = false;
				SetColAlign("left|left");        
				SetColWidth("30|200");
    			DropHeight = 160;
				ValidChar(2,0);		//영문 대문자
				IMEMode = 0;
				MaxLength = 2;
    			
    		}
    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
    		break;
    		
    	//Region
    	case 4:
    	case 7:
    		with (comboObj) {
				MultiSelect = false; 
				UseAutoComplete = false;	
    			SetColAlign("left|left");
    			SetColWidth("40|200");
				DropHeight = 160;
				ValidChar(2,0);		//영문 대문자
				IMEMode = 0;
				MaxLength = 3;
				
    		}
    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
    		break;
	    }
	    
	} 	
	//Tariff Type 선택 이벤트
	function combo1_OnChange(comboObj, Index_Code, Text) {
		if(comboObj.Text.length < 4) {
			comboObj.Text = "";
			ComSetFocus(comboObj);
			return;
		}
		search_combo1(comboObj, Index_Code, Text);
	}
	function combo1_OnBlur(comboObj) {
		var formObj = document.form;
		var sIndexCode 	= comboObj.Index;
		var sText 		= comboObj.Text;
		
		if(sIndexCode == -1) {
			comboObj.Text = "";
			ComSetObjValue(formObj.dmdt_trf_nm, "");
		}
	}	
	function search_combo1(comboObj, searchIndex, searchText) {
		var formObj = document.form;
		if (comboObj.Text.length == 0 ){
			ComSetObjValue(formObj.dmdt_trf_nm, "");
			comboObj.Text = "";
			ComSetFocus(comboObj);
			return;
		}
		ComSetObjValue(formObj.dmdt_trf_nm, comboObj.GetText(searchIndex,1));	//텍스트 컬럼 보여주기
		
		var tariffType = ComTrim(comboObj.GetText(searchIndex, 0));

		if (tariffType == "DMOF" || tariffType == "DTOC" || tariffType == "CTOC" ) {
			OriginDest.innerHTML = DESTINATION;
		}
		else if (tariffType == "DMIF" || tariffType == "DTIC" || tariffType == "CTIC" || tariffType == ""){
			OriginDest.innerHTML = ORIGIN;
		}
	}
	
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo1(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Continent 조회필드가 변경될 경우 그 소속의 Country, Region or State 정보를 조회해주는 함수
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		search_combo2(comboObj, Index_Code, Text);
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location 초기화
		clearLocation1();
	}
	
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo2(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function combo3_OnChange(comboObj, Index_Code, Text) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		//Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive)	return;

		if (comboObj.Text == "CA" || comboObj.Text == 'US') {
			Region.innerHTML = "State";
		} else {
			Region.innerHTML = "Region";
		}
		
		var formObj = document.form;
		
		isNoChangeActive = true;
		//Continent 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive = false;

		//Location 초기화
		clearLocation1();
	}
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo3(comboObj, sIndexCode, sText);
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
		
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		var region_len = comboObj.Text.length ;
		
		if (region_len == 0)	return;
		
		if (isNoChangeActive)	return;
		
		var formObj = document.form;

		isNoChangeActive = true;
		
		//US, CA인 STATE 코드 자리수가 2인 경우
		if(region_len == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		
		isNoChangeActive = false;
	}
	function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo4(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation1(obj) {
		
		if(isAlphaNum()) {
			if (isNoChangeActive) return;

			var formObj = document.form;
			var locCd = ComTrim(ComGetObjValue(obj));
	    	if (locCd.length == 5) {
	    		
    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
    				Region.innerHTML = "State";
    			}else{
    				Region.innerHTML = "Region";
    			}
    			
    			isNoChangeActive = true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
    			isNoChangeActive = false;
	    	}		
		}
	}
	
	/*
	 * Continent 조회필드가 변경될 경우 그 소속의 Country, Region or State 정보를 조회해주는 함수
	 */		
	function combo5_OnChange(comboObj, Index_Code, Text) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
		//1. Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
	}
	
	function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo5(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function combo6_OnChange(comboObj, Index_Code, Text) {
		search_combo6(comboObj, Index_Code, Text);
	}
	function search_combo6(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) 			return;
		
		//Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
	
		if (comboObj.Text == "CA" || comboObj.Text == 'US') {
			Region2.innerHTML = "State";
		} else {
			Region2.innerHTML = "Region";
		}
		
		var formObj = document.form;
		
		isNoChangeActive = true;
		//Continent 조회- 셋팅
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive = false;
		
	}
	function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo6(comboObj, sIndexCode, sText);
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo7_OnChange(comboObj, Index_Code, Text) {
		search_combo7(comboObj, Index_Code, Text);
	}
	function search_combo7(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) 			return;
		
		if (comboObj.Text.length == 0)	return;

		var formObj = document.form;

		isNoChangeActive = true;
		//US, CA인 STATE 코드 자리수가 2인 경우
		if(comboObj.Text.length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		
		isNoChangeActive = false;
	}
	function combo7_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo7(comboObj, sIndexCode, sText);
			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation2(obj) {
		
		if(isAlphaNum()) {
			if (isNoChangeActive) return;

			var formObj = document.form;
			var locCd = ComTrim(ComGetObjValue(obj));
	    	if (locCd.length == 5) {
	    		
    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
    				Region2.innerHTML = "State";
    			}else{
    				Region2.innerHTML = "Region";
    			}
    			isNoChangeActive = true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
    			isNoChangeActive = false;
	    	}		
		}
	}
	
	function clearObjectValue(obj) {
		switch(obj.name) {
			case "cvrg_location":
			case "org_dest_location":
				obj.value = "";
				break;
			default:
				obj.Text = "";
				break;
		}
	}
	
    /**
     * 시트네 팝업 클릭
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnPopupClick(sheetObj, row, col){
  		switch (sheetObj.ColSaveName(col)) {
      		case "cmdt_cd" :
  				var param = "?cmdt_cd=" + sheetObj.CellValue(row, col);
  				param += "&cmdt_nm=" + sheetObj.CellValue(row, col+1);
  				param += "&rep_cmdt_cd=" + sheetObj.CellValue(row, col+2);
  				param += "&rep_imdg_lvl_cd=" 
      			ComOpenPopup("/hanjin/COM_ENS_011.do" + param, 780, 470, "getCOM_ENS_011",'1,0,1,1,1', true, false, row, col, 0);

  			    break;
  			    
      		case "trf_mng_usr_id":
      			ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
      			break;
  		}
  	}
    
    //말풍선
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){ 
    	 
    	with(sheetObj)
    	{
    		//마우스 위치를 행과 컬럼과 값 가져오기
    		var Row = MouseRow;
    		var Col = MouseCol;

    		if(Row==0 || Row==1){
    			if(Col == 6){
    				MouseToolTipText = "Effective Date";
    			}else if(Col == 7){
    				MouseToolTipText = "Expiration Date";
    			}else{
    				MouseToolTipText = "";
    			}
    		}else{
    			MouseToolTipText = "";
    		}
    	}
    }
    
    /**
     * Rep. Commodity 팝업창 선택값 Return
     */
    function getCOM_ENS_011(aryPopupData, row, col, sheetIdx){
    	var sheetObject = sheetObjects[0];
    	
		sheetObject.CellValue2(row, "cmdt_cd") 		= aryPopupData[0][3];
		sheetObject.CellValue2(row, "cmdt_nm") 		= aryPopupData[0][4];
		sheetObject.CellValue2(row, "rep_cmdt_cd") 	= aryPopupData[0][5];
    	
    }

    /**
     * User ID
    */
    function setUsrNm(aryPopupData) {
    	 var selectRow = sheetObjects[0].SelectRow ;
    	 sheetObjects[0].CellValue2(selectRow,"trf_mng_usr_id") = aryPopupData[0][4];
    	 sheetObjects[0].CellValue2(selectRow,"trf_mng_usr_nm") = aryPopupData[0][5];
    }
    
    function sheet1_OnAfterEdit(sheetObj, row, col) {
    	var formObj = document.form;
    	
    	var sName = sheetObj.ColSaveName(col);
    	var sValue = sheetObj.CellValue(row, col);
    	
    	if(sName == "eff_dt") {
    		if(ComIsDate(sValue, "ymd")) {
//    			var iDay = ComGetDaysBetween(ComGetObjValue(formObj.today), sValue);
//    			if(iDay <= 0 ) {
//    				ComShowMessage(ComGetMsg("COM12133", "Effective Date", "greater", "Today"));
//    				sheetObj.SelectCell(row, col);
//        			sheetObj.CellValue2(row, col) = "";
//    			}
    		}else{
    			ComShowMessage(ComGetMsg("COM12132"));
    			sheetObj.SelectCell(row, col);
    			sheetObj.CellValue2(row, col) = "";
    		}
    	} else if(sName == "exp_dt") {
    		if(sValue != "") {
    			var iDay;
    			//exp_dt validation check
    			if(ComIsDate(sValue, "ymd")) {
//        			iDay = ComGetDaysBetween(ComGetObjValue(formObj.today), sValue);
//        			if(iDay <= 0 ) {
//        				ComShowMessage(ComGetMsg("COM12133", "Expiration Date", "greater", "Today"));
//        				sheetObj.SelectCell(row, col);
//            			sheetObj.CellValue2(row, col) = "";
//            			return;
//        			}
        		}else{
        			ComShowMessage(ComGetMsg("COM12132"));
        			sheetObj.SelectCell(row, col);
        			sheetObj.CellValue2(row, col) = "";
        			return;
        		}
    			//eff_dt, exp_dt validation check
    			iDay = ComGetDaysBetween(sheetObj.CellValue(row, "eff_dt"), sheetObj.CellValue(row, "exp_dt"));		
    			
    			if(iDay < 0 ) {
    			    ComShowMessage(ComGetMsg("DMT01089", "Expiration Date", "Effective Date"));
        			sheetObj.SelectCell(row, col);
        			sheetObj.CellValue2(row, col) = "";
        			return;
    			}
    		}
    	} else if(sName == "cmdt_ttl_dys") {
    		if(sValue== "" && sheetObj.CellValue(row, "cmdt_add_dys") == "") {
				ComShowMessage(ComGetMsg("COM12138", "cmdt_add_dys", "cmdt_ttl_dys"));
    			sheetObj.SelectCell(row, col);
    			sheetObj.CellValue2(row, col) = "";
    		}
    	}
    }
    
    /**
     * 조회 후 이벤트 처리
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	if(ErrMsg != "") {
    		DisableControls();
    	}else{
    		EnableControls();
    		//Org Data Copy
    		for(var i = sheetObj.HeaderRows ; i < sheetObj.LastRow; i++) {
    			sheetObj.CellValue2(i, "org_cmdt_cd") 		= sheetObj.CellValue(i, "cmdt_cd");
    			sheetObj.CellValue2(i, "org_eff_dt") 		= sheetObj.CellValue(i, "eff_dt");
     			sheetObj.CellValue2(i, "org_exp_dt") 		= sheetObj.CellValue(i, "exp_dt");
    			sheetObj.CellValue2(i, "org_cmdt_add_dys") 	= sheetObj.CellValue(i, "cmdt_add_dys");
    			sheetObj.CellValue2(i, "org_cmdt_ttl_dys") 	= sheetObj.CellValue(i, "cmdt_ttl_dys");
    			sheetObj.CellValue2(i, "org_xcld_sat_flg") 	= sheetObj.CellValue(i, "xcld_sat_flg");
    			sheetObj.CellValue2(i, "org_xcld_sun_flg") 	= sheetObj.CellValue(i, "xcld_sun_flg");
    			sheetObj.CellValue2(i, "org_xcld_hol_flg") 	= sheetObj.CellValue(i, "xcld_hol_flg");

    			sheetObj.CellValue2(i, "org_trf_rule_no") 	= sheetObj.CellValue(i, "trf_rule_no");
    			sheetObj.CellValue2(i, "org_trf_mng_usr_id") 	= sheetObj.CellValue(i, "trf_mng_usr_id");
    			    			
    			sheetObj.RowStatus(i) = "R";
    		}
    	}
    }

    /**
     * 버튼 사용 가능
     * @return
     */
    function EnableControls() {
		var formObj = document.form;
		ComEnableObject(formObj.cvrg_location, false);
		ComEnableObject(formObj.org_dest_location, false);
		
		formObj.cvrg_location.className 	= "input2";
		formObj.org_dest_location.className = "input2";
		
		for(var i = 0 ; i < comboObjects.length ; i++) {
			comboObjects[i].Enable = false;
		}
    	ComBtnEnable("btn_RowAdd");
    	ComBtnEnable("btn_RowCopy");
    	ComBtnEnable("btn_Delete");
    	ComBtnEnable("btn_Update");
    	ComBtnEnable("btn_Expire");
    	ComBtnEnable("btn_Noti_Update");
    	ComBtnEnable("btn_Save");
    	ComBtnEnable("btn_DownExcel");
    }
    
    /**
     * 버튼 사용 불가능
     * @return
     */
    function DisableControls() {
		var formObj = document.form;
		ComEnableObject(formObj.cvrg_location, true);
		ComEnableObject(formObj.org_dest_location, true);
		
		formObj.cvrg_location.className 	= "input";
		formObj.org_dest_location.className = "input";
		
		for(var i = 0 ; i < comboObjects.length ; i++) {
			comboObjects[i].Enable = true;
		}
    	ComBtnDisable("btn_RowAdd");
    	ComBtnDisable("btn_RowCopy");
    	ComBtnDisable("btn_Delete");
    	ComBtnDisable("btn_Update");
    	ComBtnDisable("btn_Expire");
    	ComBtnDisable("btn_Noti_Update");
    	ComBtnDisable("btn_Save");
    	ComBtnDisable("btn_DownExcel");
    }

	
	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		var index_1 = 0;
		var index_2 = 0;
		var index_3 = 0;
		
		switch(sAction) {
           case IBSEARCH:      // 조회
        	   if (sheetObj.id == "sheet1") {
        		   //3.조회후 결과처리
        		   var comboDatas;
        		   var comboItems;
					
        		   switch(sComboAction) {
		        		 //0. 화면로딩시 전체 조회(Tariff, Continent, Country, Region)
		               	case SEARCHLIST07:
		               		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		               		ComSetObjValue(formObj.f_cmd, SEARCHLIST07); 
		               		//2.조회조건으로 조회실행                 
		               		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		
		               		//TARIFF LIST
		               		comboItems = ComGetEtcData(sXml, COMMON_TARIFF_CD).split(ROWMARK);	
		               		addComboItem(comboObjects[0], comboItems);
		               		
		               		//Coverage Continent
		               		comboDatas = ComGetEtcData(sXml, CONTINENT);
		               		if (comboDatas != undefined) {
		               			comboItems = comboDatas.split(ROWMARK);
		               			//선태가능한 상태로 변경
		               			comboObjects[1].Code="-1";
		               			comboObjects[1].RemoveAll();
		               			addComboItem(comboObjects[1],comboItems);
		               		}
		               		
		               		//Coverage Country 
		               		comboDatas = ComGetEtcData(sXml, COUNTRY);
		               		if (comboDatas != undefined) {
		               			comboItems = comboDatas.split(ROWMARK);
		               			comboObjects[2].Code = "-1";
		               			comboObjects[2].RemoveAll();
		               			addComboItem(comboObjects[2],comboItems); //COUNTRY
		               		}
		                       
		               		//Coverage Region
		               		comboDatas = ComGetEtcData(sXml, REGION);
		               		if (comboDatas != undefined) {
		               			comboItems = comboDatas.split(ROWMARK);
		               			comboObjects[3].Code = "-1";
		               			comboObjects[3].RemoveAll();
		               			addComboItem(comboObjects[3],comboItems); //Region
		               		}
		                       
		               		//Coverage Continent
		               		comboDatas = ComGetEtcData(sXml, CONTINENT);
		               		if (comboDatas != undefined) {
		               			comboItems = comboDatas.split(ROWMARK);
		               			//선태가능한 상태로 변경
		               			comboObjects[4].Code="-1";
		               			comboObjects[4].RemoveAll();
		               			addComboItem(comboObjects[4],comboItems);
	                        }
		               		
		               		//Coverage Country 
		               		comboDatas = ComGetEtcData(sXml, COUNTRY);
	                        if (comboDatas != undefined) {
	                        	comboItems = comboDatas.split(ROWMARK);
	                        	comboObjects[5].Code = "-1";
	                        	comboObjects[5].RemoveAll();
	                        	addComboItem(comboObjects[5],comboItems); //COUNTRY
	                        }
	                       
	                        //Coverage Region
	                        comboDatas = ComGetEtcData(sXml, REGION);
	                        if (comboDatas != undefined) {
	                        	comboItems = comboDatas.split(ROWMARK);
	                        	comboObjects[6].Code = "-1";
	                        	comboObjects[6].RemoveAll();
	                        	addComboItem(comboObjects[6],comboItems); //Region
	                        }
		               		break;
        		   
        		   		//1. Tariff Type
						case SEARCHLIST:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
								
							comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
							break;							
							
						//1. CONTINENT LIST
						case SEARCH08:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH08);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo2") {
								index_1 = 1;
							} else {
								index_1 = 4;
							}
							
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo3") {
								index_1 = 2;
							} else {
								index_1 = 5;
							}
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo4" || sObj.name == "combo2") {
								index_1 = 3;
							} else {
								index_1 = 6;
							} 
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//REGION
								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
							
						//4. Continent에 해당되는 CONTRY 정보 조회
						case SEARCH06:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH06);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo2" || sObj.name == "combo4" || sObj.name == "cvrg_location") {
								index_1 = 2;
							}else{
								index_1 = 5;
							}
							comboDatas = ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									comboObjects[index_1].Code = "-1";
									comboObjects[index_1].RemoveAll();
									addComboItem(comboObjects[index_1],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
	
						//5. Country에 해당 하는 CONTINENT 정보 조회
						case SEARCH12:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH12);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo3") {
								index_1 = 1;
							} else {
								index_1 = 4;
							}
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if( comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
								
						//5. Country가 변경시에 해당 하는 Region 정보 조회
						case SEARCH03:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo3" || sObj.name == "combo4" || sObj.name == "cvrg_location") {
								index_1 = 2;
								index_2 = 3;
								clearLocation1();
							} else {
								index_1 = 5;
								index_2 = 6;
								clearLocation2();
							}
							
							if(comboObjects[index_1].Text == "CA" || comboObjects[index_1].Text == "US" ) {
								//State
								comboDatas = ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							
							if(comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();				//Region						
								addComboItem(comboObjects[index_2],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
							
						//6. State,Region를 변경시에 해당 하는 Continet, Country, State 정보 조회
						case SEARCH17:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH17);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo4") {
								index_1 = 1;
								index_2 = 2;
								index_3 = 3;
								clearLocation1();
							} else {
								index_1 = 4;
								index_2 = 5;
								index_3 = 6;
								clearLocation2();
							}
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[index_3].Code="-1";
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									comboDatas = ComGetEtcData(sXml, sComboKey);
									
									if (comboDatas != undefined) {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
									
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							
							break;
						case SEARCH13:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH13);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "combo4") {
								index_1 = 1;
								index_2 = 2;
								index_3 = 3;
								clearLocation1();
							} else {
								index_1 = 4;
								index_2 = 5;
								index_3 = 6;
								clearLocation2();
							}
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[index_3].Code="-1";
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									comboDatas = ComGetEtcData(sXml, sComboKey);
									
									if (comboDatas != undefined) {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
									
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							
							break;
	
						//4. Location을 입력시 조회
						case SEARCH10:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH10);
							setComboParameters(sComboAction, sObj);
	
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							var location = ComGetObjValue(sObj);

							if(sObj.name == "cvrg_location") {
								index_1 = 1;
								index_2 = 2;	//Location 초기화
								index_3 = 3;
								clearLocation1();
							} else {
								index_1 = 4;
								index_2 = 5;
								index_3 = 6;
								clearLocation2();
							}
							//Continent 조회
							comboDatas = ComGetEtcData(sXml, CONTINENT);
	
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								//Continent Setting
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();					//Country		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									
									//Region/State List 조회
									comboObjects[index_3].Code="-1";
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
										comboDatas = ComGetEtcData(sXml, STATE);
					    			}else{
										comboDatas = ComGetEtcData(sXml, REGION);
					    			}
	
									if (comboDatas != undefined) {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
										
										//location setting
										ComSetObjValue(sObj, location);
										
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage('DMT00110','Location');
								ComClearObject(obj);
								ComSetFocus(obj);
							}
							
							break;
					}
	
				};
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			//comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
    	}   		
	}
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem2(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
    		comboObj.InsertItem(i, ComReplaceStr(comboItem[1],"^"," - ") , comboItem[0]);
    	}   		
	}
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
    	}   		
	}
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		var cvrg_cnt_cd = comboObjects[2].Text;
		var org_dest_cnt_cd = comboObjects[5].Text;

		//Tariff Type
		ComSetObjValue(formObj.sel_dmdt_trf_cd, comboObjects[0].Text);
		
		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, comboObjects[1].Text);
		ComSetObjValue(formObj.cvrg_cnt_cd, comboObjects[2].Text);
		//ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[3].Text);
		//2012.04.25 cnt_cd가 US, CA 인 경우 ste_cd 로 되도록 수정함.
	    if(cvrg_cnt_cd == "US" || cvrg_cnt_cd == "CA") {
	         ComSetObjValue(formObj.cvrg_ste_cd, comboObjects[3].Text);
	         ComSetObjValue(formObj.cvrg_rgn_cd, "");
	        }
	        else
	        {
	         ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[3].Text);
	         ComSetObjValue(formObj.cvrg_ste_cd, "");
	        }        
		
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[4].Text);
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[5].Text);
		//ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[6].Code);
		//2012.04.25 cnt_cd가 US, CA 인 경우 ste_cd 로 되도록 수정함.
	    if(org_dest_cnt_cd == "US" || org_dest_cnt_cd == "CA") {
	         ComSetObjValue(formObj.org_dest_ste_cd, comboObjects[6].Text);
	         ComSetObjValue(formObj.org_dest_rgn_cd, "");
	        }
	        else
	        {
	         ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[6].Text);
	         ComSetObjValue(formObj.org_dest_ste_cd, "");
	        }        

			ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		
		//cnt_cd 
		ComSetObjValue(formObj.cnt_cd, comboObjects[2].Text);
		
	}
	/*
	 * Combo 공통 코드를 조회한다.
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj = document.form;

		switch(sObj.name) {
			case "combo2":
			case "combo3":
			case "combo4":
			case "cvrg_location":
				//Coverage ComboSetting
				ComSetObjValue(formObj.conti_cd, comboObjects[1].Text);
				ComSetObjValue(formObj.cnt_cd, comboObjects[2].Text);
				ComSetObjValue(formObj.rgn_cd, comboObjects[3].Text);
				ComSetObjValue(formObj.ste_cd, comboObjects[3].Text);
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				break;

			case "combo5":
			case "combo6":
			case "combo7":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[4].Text);
				ComSetObjValue(formObj.cnt_cd, comboObjects[5].Text);
				ComSetObjValue(formObj.rgn_cd, comboObjects[6].Text);
				ComSetObjValue(formObj.ste_cd, comboObjects[6].Text);
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_location));

				break;	
				
		}
	}

    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem = comboItems[0].split(FIELDMARK);
		comboObj.Text = checkedItem[0];
	}	
	
	/*
	 * 조회결과 정보 초기화
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation1() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}

	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation2() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.org_dest_location, "");
	}

	
	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		comboObjects[0].Code="-1";
		comboObjects[0].RemoveAll();
		comboObjects[1].Code="-1";
		comboObjects[1].RemoveAll();
		comboObjects[2].Code="-1";
		comboObjects[2].RemoveAll();
		comboObjects[3].Code="-1";
		comboObjects[3].RemoveAll();
		comboObjects[4].Code="-1";
		comboObjects[4].RemoveAll();
		comboObjects[5].Code="-1";
		comboObjects[5].RemoveAll();
		comboObjects[6].Code="-1";
		comboObjects[6].RemoveAll();
		
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");

		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		
		ComSetObjValue(formObj.sel_dmdt_trf_cd, "");
		ComSetObjValue(formObj.dmdt_trf_nm, "");

		Region.innerHTML = "Region";
		Region2.innerHTML = "Region";
	}		
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		initResultControls();
	 	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
 
	    //데이터 초기화
	    var formObj = document.form;
	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");

//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);		//1
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[1]);		//2
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[2]);			//3
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[3]);		//4
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[4]);		//5
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[5]);			//6
//	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[6]);	//7	    
	}	
	
    function sheet1_OnChange( sheetObj , Row , Col , Value ) {
        if ( Col == 3 ) {
//        alert("Row [" + Row + "] Col [" + Col + "] Value [" + Value + "]");
            if ( Value == "" ) {
                sheetObjects[0].CellValue2( Row, 3 ) = "";
                sheetObjects[0].CellValue2( Row, 4 ) = "";
                sheetObjects[0].CellValue2( Row, 5 ) = "";
                return false;
            } else {
                document.form.cmdt_cd.value = Value;
                document.form.cmdt_row.value = Row;
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);                
            }
        }
        
        var formObj = document.form;
    	
    	with(sheetObj) {
    		var colName = ColSaveName(Col);
    		
    		switch(colName) {
    			case "trf_mng_usr_id":  
	    				formObj.srch_apro_usr_id.value = Value;
	    				var nameVal = doActionIBSheet(sheetObj, formObj, SEARCH03);
	    				if ( nameVal != '' ){
		    				CellValue2(Row, 'trf_mng_usr_nm') = nameVal;
	    				} else {
		    				CellValue2(Row, 'trf_mng_usr_nm') = '';
		    				CellValue2(Row, Col) = '';
	    				}
	    				formObj.srch_apro_usr_id.value = '';
    		 	break;		
    			case "eff_dt":
    				var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
    				var exp_dt = ComGetDateAdd(Value, "D", 365);
    				if ( ofcCurrDate >= exp_dt ){
    					exp_dt = ComGetDateAdd(ofcCurrDate, "D", 365);
    				}
    				CellValue2(Row, 'exp_dt') = exp_dt;
    			break;
    		}
    	}
    }
    

    /**
     * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
     */
    function handleNullString(sVal) {
    	
         if (typeof(sVal) == "undefined" || sVal == "null" || sVal.length == 0) return "";

         return ComTrim(sVal);
    }   
    

    /**
     * 그리드내 콤보필드에 데이터를 추가해준다.
     */		
	function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
     	var formObj			= document.form;
		var comboItems;
		var comboItem;
		var comboTxt 		= "";
		var comboVal 		= "";		
		var comboInitTxt 	= "";
		var comboInitVal 	= "";
	
		if (typeof(comboDatas) != "undefined" && ComTrim(comboDatas).length > 0) {
			comboItems = comboDatas.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				
				//InitDataCombo 메소드를 태울 경우 선택값을 주지 않을 경우
				//Code, Value 가 콤보에 나타나 글자가 밀리는 현상을 방지하기 위함.
				if (!isCellCombo && i == 0) {
					comboInitTxt = comboItem[0];
					comboInitVal = comboItem[0];
				}
				
				if (ComTrim(comboItem[0]) != "") {
					//Text 만 보여줘야 할 때
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					}
					//Text 가 '^' 을 구분자로 해서 내려올 때
					else if (comboItem[1].indexOf("\^") != -1) {
						comboTxt += comboItem[1].replace("^", " - ");
					}
					//Text 와 Code 를 둘 다 보여줘야 할 때
					else {
						comboTxt += comboItem[0] + "\t" + comboItem[1];
					}
					comboVal += comboItem[0];
				}
				else {
					comboTxt += " \t ";
					comboVal += " ";
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		else {
			comboTxt += " \t ";
			comboVal += " ";			
		}
		
		var colName = sComboKey;
		
		if (isCellCombo) {
			sheetObj.CellComboItem(sheetObj.SelectRow,colName,comboTxt,comboVal);
			sheetObj.CellValue2(sheetObj.SelectRow,colName) = "";
		} else if (isOnlyTextView) {
			sheetObj.InitDataCombo(0,colName,comboVal,comboVal,comboInitVal,comboInitVal);
		} else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal,comboInitTxt,comboInitVal);
		}
	}
	
	/* 개발자 작업  끝 */