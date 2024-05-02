/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DMT_7017.js
*@FileTitle : Inactive Authority Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2015.01.27 이성훈
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
     * @class EES_DMT_7017 : EES_DMT_7017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7017() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
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

	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
    
	// combo 조회 코드
	var IBSEARCH_RHQ_CMB = 1001;
	var IBSEARCH_OFC_CMB = 1002;
	var IBSEARCH_OFC_CD_CMB = 1003;
	
	var rhqCd = '';
	var chgRow = 0;	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;	
	
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
	        		doActionRowAdd();
				break;
		
				case "btn_Delete":
					doActionRowDelete();
				break;
					
				case "btn_Retrieve":
					doActionRetrieve();
				break;
	
				case "btn_New":					
					doActionNew();
				break;
				
				case "btn_Save":
					doActionSave();
				break;
					
				case "btn_DownExcel":
					doActionDownExcel();
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
        for (i=0; i<sheetObjects.length; i++) {
            //khlee-시작 환경 설정 함수 이름 변경
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
        	ComEndConfigSheet(sheetObjects[i]);
        }
        // IBMultiCombo초기화 
	    for (var k=0; k<comboObjects.length; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
     	
	    //Axon 이벤트 처리
	    initAxonControl();
	    
	    // 각종 콤보박스의 데이터를 페이지 로딩시 입괄조회 후 한번에 설정 
	    // 조회조건 및 그리드 콤보 데이터 셋팅
	    doActionLoadComboData(IBSEARCH_RHQ_CMB);
	    
	    // 로그인 사용자의 RHQ 로 설정해준다.
		comboObjects[0].Code = getUserRhqOfcCd();

	    // Tab Object 초기화
	    for(var j=0;j<tabObjects.length;j++){
            initTab(tabObjects[j],j+1);
        }
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
                    InsertTab( cnt++ , "Inactivation",	-1 );
                    InsertTab( cnt++ , "After BKG",		-1 );
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
		var sheetID = sheetObj.id;
				
        switch(sheetID) {

            case "sheet1":	// sheet1 init
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
    				InitRowInfo(1, 1, 3, 100);

    				var HeadTitle = "|Sel|Eff DT|Exp DT|RHQ|OFC|OFC O.Manager|SCG/BAG|RHQ|SELHO|Update DT|Update User|Update User Office";
    				
    				var headCount = ComCountHeadTitle(HeadTitle) + 1;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 		COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, 	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	 30,	daCenter,		true,		"ibflag");   
                    InitDataProperty(0, cnt++,	dtCheckBox,		 30,	daCenter,		true,     	"chk");
                    InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,		true,		"eff_dt",					true,		"",			dfDateYmd,		0,			false, 		true);  //eff dt - from
                    InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,		true,		"exp_dt",					false,		"",			dfDateYmd,		0,			true, 		true);  //eff dt - to
                    InitDataProperty(0, cnt++ , dtCombo,		 70,	daCenter,		true,		"chg_delt_rhq_cd",			true,		"",			dfNone,			0,			false, 		true);  //RHQ
                    InitDataProperty(0, cnt++ , dtPopup,		220,	daLeft,			true,		"chg_delt_ofc_cd",			true,		"",			dfNone,			0,			false, 		true);  //OFC
                    InitDataProperty(0, cnt++ , dtCheckBox,		100,	daCenter,		true,		"dmdt_brnc_ofc_op_mgr_flg",	false,		"",			dfNone,			0,			true, 		true);  //OFFICE OPERATION MANAGER
                    InitDataProperty(0, cnt++ , dtCheckBox,		 60,	daCenter,		true,		"dmdt_brnc_flg",			false,		"",			dfNone,			0,			true, 		true);  //BBG
                    InitDataProperty(0, cnt++ , dtCheckBox,		 60,	daCenter,		true,		"dmdt_rhq_flg",				false,		"",			dfNone,			0,			true, 		true);  //RHQ
                    InitDataProperty(0, cnt++ , dtCheckBox,		 60,	daCenter,		true,		"dmdt_ho_flg",				false,		"",			dfNone,			0,			true, 		true);  //SELHO
                    InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,		true,		"upd_dt",					false,		"",			dfNone,			0,			false, 		false); //UPDATE DATE
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"upd_usr_id",				false,		"",			dfNone,			0,			false, 		false); //UPDATE USER ID
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"upd_ofc_cd",				false,		"",			dfNone,			0,			false, 		false); //UPDATE USER OFFICE CODE						
                    InitDataProperty(0, cnt++ , dtHidden,		  0,	daCenter,		true,		"chg_delt_path_stup_seq"); //승인경로시퀀스
                    
                    ShowButtonImage = 2;
            	}
            	break;
            	
            case "sheet2":      // sheet2 init
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

					var HeadTitle = "|Sel|RHQ|DMT_DFC|Eff DT|Exp DT|USD Amount|USD Amount|SCO/BAO PIC|OFC O.Manager|SCG/BAG|RHQ DMT PIC|RHQ O. Mgr|HO DMT PIC|HO Team MGR";
					var HeadTitle1 = "|Sel|RHQ|DMT_DFC|Eff DT|Exp DT|Fm|To|SCO/BAO PIC|OFC O.Manager|SCG/BAG|RHQ DMT PIC|RHQ O. Mgr|HO DMT PIC|HO Team MGR";
					
					var headCount = ComCountHeadTitle(HeadTitle) + 1; // dtHidden 컬럼 seq 추가

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 		DATAALIGN, 		COLMERGE, 	SAVENAME,					KEYFIELD, CALCULOGIC, 	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	0,			daCenter,		true,		"ibflag");  
                    InitDataProperty(0, cnt++,	dtCheckBox,		30,			daCenter,		true,     	"chk");
                    InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,		true,		"rhq_cd",					true,		"",			dfNone,			0,			false, 		true);  //RHQ
                    InitDataProperty(0, cnt++ , dtComboEdit,	80,			daCenter,		true,		"ofc_cd",					false,		"",			dfNone,			0,			false, 		true);  //OFC
                    InitDataProperty(0, cnt++ , dtData,			90,			daCenter,		true,		"eff_dt",					true,		"",			dfDateYmd,		0,			true, 		true);  //eff dt - from
                    InitDataProperty(0, cnt++ , dtData,			90,			daCenter,		true,		"exp_dt",					false,		"",			dfDateYmd,		0,			true, 		true);  //eff dt - to
                    InitDataProperty(0, cnt++ , dtData,			70,			daCenter,		true,		"fm_dc_amt",				false,		"",			dfNumber,		0,			true, 		true);  //from DC Amount
                    InitDataProperty(0, cnt++ , dtData,			70,			daCenter,		true,		"to_dc_amt",				false,		"",			dfNumber,		0,			true, 		true);  //to DC Amount
                    InitDataProperty(0, cnt++ , dtCheckBox,		80,			daCenter,		true,		"brnc_ofc_pic_chk_flg",		false,		"",			dfNone,			0,			true, 		true);  //BOG
                    InitDataProperty(0, cnt++ , dtCheckBox,	   100,			daCenter,		true,		"brnc_ofc_op_mgr_apro_flg",	false,		"",			dfNone,			0,			true, 		true);  //OFFICE OPERATION MANAGER
                    InitDataProperty(0, cnt++ , dtCheckBox,		75,			daCenter,		true,		"brnc_ofc_mgr_apro_flg",	false,		"",			dfNone,			0,			true, 		true);  //BBG
                    InitDataProperty(0, cnt++ , dtCheckBox,		80,			daCenter,		true,		"rhq_pic_chk_flg",			false,		"",			dfNone,			0,			true, 		true);  //RHQ PIC
                    InitDataProperty(0, cnt++ , dtCheckBox,		80,			daCenter,		true,		"rhq_mgr_apro_flg",			false,		"",			dfNone,			0,			true, 		true);  //RHQ MGR
                    InitDataProperty(0, cnt++ , dtCheckBox,		80,			daCenter,		true,		"ho_pic_chk_flg",			false,		"",			dfNone,			0,			true, 		true);  //HO PIC
                    InitDataProperty(0, cnt++ , dtCheckBox,		80,			daCenter,		true,		"ho_mgr_apro_flg",			false,		"",			dfNone,			0,			true, 		true);  //HO MGR
                    InitDataProperty(0, cnt++ , dtHidden,		0,			daCenter,		true,		"aft_bkg_path_stup_seq"); //승인경로시퀀스
                    
                    ShowButtonImage = 2;
            	}                
                break;
        }
    }    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	
    	sheetObj.ShowDebugMsg = false;    	
    	
        switch(sAction) {
        	
        	case IBSEARCH: //조회
				// 1.조회 전처리 작업을 실행한다.
				sheetObj.RemoveAll();
				
				var tab_order = ComGetObjValue(formObj.tab_order); //0 : Inactivation, 1 : After BKG
				// 2.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				// [2015-10-20. 김기태] Tab 구분에 따른 조회 조건 추가
				ComSetObjValue(formObj.f_cmd, (tab_order == 0) ? SEARCH : SEARCH01);
				ComSetObjValue(formObj.chg_delt_ofc_cd, comboObjects[1].Code);
				ComSetObjValue(formObj.aft_bkg_ofc_cd, comboObjects[1].Code);
		
				// 3.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_7017GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				// 4. 조회결과 처리
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
					sheetObj.LoadSearchXml(sXml);				
				}
			break;	

	   		case IBSAVE: //저장
				if (validateForm(sheetObj,formObj,sAction)) {
					
					ComSetObjValue(formObj.f_cmd, (beforetab == 0) ? MULTI : MULTI01); // 탭에 따른 다른 로직 호출
					
	            	var sParam = ComGetSaveString(sheetObj, false);
				    sParam += "&" + FormQueryString(formObj);
			    
	            	var sXml = sheetObj.GetSaveXml("EES_DMT_7017GS.do", sParam);
	            	
					var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					sheetObj.LoadSaveXml(sXml);
					
					if (svcResult == "S") {
						// 저장 성공시에만 재조회 실행.
						doActionRetrieve();
					}					
                }
			break;
			
			//######################################## 콤보 데이터 조회 영역 [S] ####################################################
        	case IBSEARCH_RHQ_CMB:
				//1. [RHQ] 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, COMMAND06); // DMTCommonSC.searchRHQOfficeList
	
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
            	//1.RHQ Combo - setting
				rhqList = handleNullString(ComGetEtcData(sXml, "common_cd")); // After BKG 탭에서 사용하기 위한 전역변수 설정
				var rhqList2 = FIELDMARK + ROWMARK + rhqList;	// 빈공백추가
				
            	initComboItem(comboObjects[0], rhqList2.split(ROWMARK));
            	initGridComboItem(sheetObjects[0], rhqList, "chg_delt_rhq_cd");	
        	break;
        	
        	case IBSEARCH_OFC_CMB:
        		//0. 선택한 RHQ 의 SubOffice 를 조회하기 전, Office 콤보의 모든 데이터를 삭제한다.
        		comboObjects[1].RemoveAll();
        		
				//1. [RHQ] 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd,  COMMAND21); // DMTCommonSC.searchSubOfficeListByRHQ
				ComSetObjValue(formObj.rhq_ofc_cd, comboObjects[0].Code);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
            	//1.Office Combo - setting
				var ofcList = handleNullString(ComGetEtcData(sXml, "OFC_CD"));				
				var ofcList2 = addComboDefaultItem(ofcList);
            	initComboItem(comboObjects[1], ofcList2.split(ROWMARK));
            	// After BKG에서 Row add 시 기본 리스트에 보여질 콤보 설정
//            	initGridComboItem(sheetObjects[1], getOfficeCode(ofcList), "ofc_cd");
            	sheetObjects[1].InitDataCombo(0, "rhq_cd", rhqList, rhqList, comboObjects[0].Code);
        	break;	
        	
        	case IBSEARCH_OFC_CD_CMB:

        		//1. [RHQ] 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        		ComSetObjValue(formObj.f_cmd,  COMMAND21); // DMTCommonSC.searchSubOfficeListByRHQ
        		ComSetObjValue(formObj.rhq_ofc_cd, rhqCd); // Cell 내부 선택한 RHQ
        		
        		//2.조회조건으로 조회실행
        		//*********************************************************************************
        		ComOpenWait(true);
        		sheetObj.WaitImageVisible = false;
        		//*********************************************************************************
        		
        		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        		
        		//*********************************************************************************
        		ComOpenWait(false);
        		//*********************************************************************************
        		
        		//1.Office Combo - setting
        		var ofcList = getOfficeCode(handleNullString(ComGetEtcData(sXml, "OFC_CD")));
        		
        		// 하위 오피스 선택 Combo 리스트를 선택한 RHQ에 맞는 목록으로 갱신한다.
        		sheetObjects[1].CellComboItem(chgRow, "ofc_cd", ofcList, ofcList);           	
        		break;	
        		
        	//######################################## 콤보 데이터 조회 영역 [E] ####################################################
		}			
    }    
    
	function initAxonControl() {
		axon_event.addListenerFormat('focus', 'obj_focus', document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('blur',  'obj_blur',  document.form); //- 포커스 나갈때
	}
	
	/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
	function tab1_OnChange(tabObj , nItem){

    	 var objs = document.all.item("tabLayer");
    	 var formObj = document.form;
    	 objs[nItem].style.display = "Inline";
    	 objs[beforetab].style.display = "none";
	
	 	 //--------------- 요기가 중요 --------------------------//
    	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	 	 //------------------------------------------------------//
    	 beforetab= nItem;
    	 
	 	 //[설명]TAB 선택시 tab_order에 값 셋팅하기
	 	 //1. Inactivation : 0, After BKG : 1
    	 formObj.tab_order.value = beforetab;
        
    	 //tab1:Detail 버튼 생성, tab2: Detail 버튼 삭제
//    	 var schCondDiv = document.getElementById("sch_cond_div");
//    	 if (ComGetObjValue(formObj.tab_order) == 0) {
//    		 schCondDiv.style.display = 'block';
//	 	 } 
//    	 else {
//	 		 schCondDiv.style.display = 'none';
//	 	 }
    	 
	}
	
    /**
     * Row Add 버튼 클릭시 행을 추가해준다.
     */
    function doActionRowAdd() {
    	    	
    	if(beforetab == 1) { // After BKG 탭인 경우 DMT_OFC 콤보 생성을 위한 셀값 추가    		
    		// Row insert 시 삽입시킬 Row INDEX (Default : -1 마지막 행)
        	var insertRowIndex = -1;
        	
        	// 체크된 행이 있는지 확인하고 있다면 첫 체크행의 인덱스를 삽입 위치로 지정한다.
        	for(var i = 0; i < sheetObjects[beforetab].Rows ; i++) {	 
        		if (sheetObjects[beforetab].CellValue(i, 'chk') == '1') {
        			if (insertRowIndex == -1) {
        				insertRowIndex = i	
        			}    			
        		}
        	}
        	// 새로운 행 삽입
			chgRow = sheetObjects[beforetab].DataInsert(insertRowIndex);
			
			// 체크된 행이 있었다면 추가된 행에서 RHQ, OFC, EFF_DT, EXP_DT 컬럼의 값을 복사하고 수정 금지상태로 만든다.
			if(insertRowIndex != -1) {	
	    		for(var i = 2; i <= 5; i++) {
	    			sheetObjects[beforetab].CellEditable(chgRow, i) = false;	
	    			sheetObjects[beforetab].CellValue(chgRow, i) = sheetObjects[beforetab].CellValue(insertRowIndex, i);
	    		}
			} else {
				// 체크된 행이 없다면 OFC 컬럼에 콤보박스를 추가한다.
				rhqCd = sheetObjects[beforetab].CellValue(chgRow, 'rhq_cd');
    			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_OFC_CD_CMB);
			} 		
    	} else {
    		sheetObjects[beforetab].DataInsert(-1);
    	}
    }
    /**
     * Row Delete 버튼 클릭시 체크선택된 항목을 삭제해준다.
     */
    function doActionRowDelete() {
    	
		if (sheetObjects[beforetab].RowCount == 0) {
			ComShowMessage(ComGetMsg("DMT01117", "delete.")); //There is no data for delete.
			return false;
		}
		
		ComRowHideDelete(sheetObjects[beforetab], "chk");
    }
    /**
     * Retrieve 버튼 클릭시 입력된 조건에 알맞는 데이터를 조회한다.
     */
    function doActionRetrieve() {
    	
    	if (validateForm(sheetObjects[beforetab], document.form, IBSEARCH)) {
    		doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
    	}
    }
    /**
     * NEW 버튼 클릭시 화면 초기상태로 설정해준다.
     */
    function doActionNew() {
    	var formObj = document.form;
    	
    	// 1. 입력조건을 초기화 시킨다.
    	comboObjects[0].Index = -1;		// RHQ
    	comboObjects[1].RemoveAll();	// Office
    	
    	formObj.crnt_flg.checked = true;	// Validity - Current
    	formObj.tobe_flg.checked = true;	// Validity - To-be
    	formObj.exp_flg.checked  = false;	// Validity - Expired
    	
    	// 2. 모든 조회결과를 삭제해준다.
    	sheetObjects[beforetab].RemoveAll();
    	
	    // 3. 로그인 사용자의 RHQ 로 설정해준다.
	    comboObjects[0].Code = getUserRhqOfcCd();    	
    }
    /**
     * Save 버튼 클릭시 화면에 입력, 수정, 삭제된 결과를 반영한다.
     */
    function doActionSave() {
    	
		if (validateForm(sheetObjects[beforetab], document.form, IBSAVE)) {
			if (ComShowCodeConfirm("DMT00135", "Save")) {
				doActionIBSheet(sheetObjects[beforetab], document.form, IBSAVE);
			}
		}
    }
    /**
     * Down Excel 버튼 클릭시 조회결과 데이터를 엑셀파일로 다운로드 시켜준다.
     */
    function doActionDownExcel() {
    	
    	sheetObjects[beforetab].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
    }
    /**
     * 콤보코드데이터를 조회해서 초기화한다.
     */
    function doActionLoadComboData(sActionName) {
    	
    	doActionIBSheet(sheetObjects[beforetab], document.form, sActionName);
    }
    
    
    
    

    /**
     * RHQ 변경시 SUB Office 항목을 조회해서 Office 콤보를 설정해준다.
     */
	function comboRHQ_OnChange(comboObj, Index_Code, Text) {

		if (Index_Code != "") {

			// 조회조건 및 그리드 콤보 데이터 셋팅
		    doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH_OFC_CMB);
		    
		    // 해당 RHQ 의 Sub Office 항목을 전체선택해준다.
		    selectAllOfficeByRHQ();
		}
		else {
			comboObjects[1].RemoveAll();
		}
	}
	
	// Office 멀티콤보 클릭 이벤트
 	function comboOffice_OnCheckClick(comboObj, index, code) {

 		setMultiCombo(comboObj, index, code);
 	}
	/**
     * Cell 내부의 Combo RHQ 변경시 하위 Office 리스트를 갱신한다.
     */
	function sheet2_OnChange(sheetObj, Row, Col, Value) { 
		if(Col == 2) { // RHQ CD
			rhqCd = Value;
			chgRow = Row;
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_OFC_CD_CMB);
		}		
	}
 	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	var msg ="";
    	
    	with(formObj) {
    		
    		switch(sAction) {
				case IBSEARCH:    //조회
					//1. 필수입력조건을 체크한다.
					if (comboObjects[0].Code == "") {
						ComShowMessage(ComGetMsg("DMT00102", "RHQ")); //Please enter {?msg1}
						return false;
					}
					else if (comboObjects[1].Code == "") {
						ComShowMessage(ComGetMsg("DMT00102", "OFC")); //Please enter {?msg1}
						return false;
					}
		    	break;
    	
				case IBSAVE:      //저장
					//변경여부 체크
					with(sheetObj) {
						if (IsDataModified == false) {
							ComShowMessage(ComGetMsg("DMT01113")); //There is no changed data.
							return false;
						}
						// 중복 체크
//						var sRow = ColValueDupRows("rhq_cd|ofc_cd|eff_dt||fm_dc_amt|to_dc_amt|brnc_ofc_pic_chk_flg|brnc_ofc_mgr_apro_flg|rhq_pic_chk_flg|rhq_mgr_apro_flg|ho_pic_chk_flg|ho_mgr_apro_flg");
//						alert(sRow);
//						return false;

						switch(beforetab) {
						case 0:	// Inactivation
							//필수입력값 체크
							for (var i=HeaderRows; i<Rows; i++) {	
								
								// 입력일 경우, 체크 로직
								if (RowStatus(i) == "I") {
									//Eff DT 체크
									if (CellValue(i,"eff_dt") == "") {
										ComShowMessage(ComGetMsg("DMT00102", "Eff DT")); //Please enter {?msg1}
										return false;
									}
									//RHQ 체크
									if (CellValue(i,"chg_delt_rhq_cd") == "") {
										ComShowMessage(ComGetMsg("DMT00102", "RHQ")); //Please enter {?msg1}
										return false;
									}
									//OFC 체크
									if (CellValue(i,"chg_delt_ofc_cd") == "") {
										ComShowMessage(ComGetMsg("DMT00102", "OFC")); //Please enter {?msg1}
										return false;
									}							
								}
								
								// 입력 및 수정일 경우, 체크 로직					
								if (RowStatus(i) == "I" || RowStatus(i) == "U") {
									//승인경로 체크
									if (   CellValue(i,"dmdt_brnc_flg") == 0 
										&& CellValue(i,"dmdt_rhq_flg")  == 0 
										&& CellValue(i,"dmdt_ho_flg")   == 0) {
											ComShowMessage(ComGetMsg("DMT00171", "for approval target.")); //Pls check {?msg1}								
											return false;	
									}
								}
							}
						case 1: // After BKG
							//필수입력값 체크
							for (var i=HeaderRows; i<Rows; i++) {	
								// 입력일 경우, 체크 로직
								if (RowStatus(i) == "I") {
									//Eff DT 체크
									if (CellValue(i,"eff_dt") == "") {
										ComShowMessage(ComGetMsg("DMT00102", "Eff DT")); //Please enter {?msg1}
										return false;
									}
								}
								
								// 입력 및 수정일 경우, 체크 로직					
								if (RowStatus(i) == "I" || RowStatus(i) == "U") {
									//승인경로 체크
									if (   CellValue(i,"brnc_ofc_pic_chk_flg") == 0 
										&& CellValue(i,"brnc_ofc_mgr_apro_flg")  == 0 
										&& CellValue(i,"rhq_pic_chk_flg")  == 0 
										&& CellValue(i,"rhq_mgr_apro_flg")  == 0 
										&& CellValue(i,"ho_pic_chk_flg")  == 0 
										&& CellValue(i,"ho_mgr_apro_flg")   == 0) {
											ComShowMessage(ComGetMsg("DMT00171", "for approval target.")); //Pls check {?msg1}								
											return false;	
									}
								}
							}
						}							
					}
			    break;
    		}
    	
    	}
		
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form

   	    switch(comboNo) {		
 				
		    //RHQ Combo
		   	case 1:
		   		with(comboObj) {
					MultiSelect = false; 
					UseAutoComplete = true;	
					SetColAlign("left");        
					SetColWidth("70");
					ColBackColor(0) = "#CCFFFD";
					ColBackColor(1) = "#CCFFFD";
					DropHeight = 160;
		   		}
		   	break;	
		   	
			//Office Combo
		   	case 2:
		   		with(comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
   					SetColAlign("left|left");        
   					SetColWidth("55|360");					
					ColBackColor(0) = "#CCFFFD";
					ColBackColor(1) = "#CCFFFD";
					DropHeight = 160;
		   		}
		   	break; 
   	    }
	} 
	
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} SheetObj    IBSheet Object
     * @param {ibsheet} Row         sheetObj의 선택된 Row
     * @param {ibsheet} Col         sheetObj의 선택된 Col
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            var colName = ColSaveName(Col);
        }
    }	
    
    /**
     * sheet1 OnSearchEnd 이벤트 처리  
     * @param sheetObj
     * @param ErrMsg
     * @return
     */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {

    	}
    }	
    
	/**
	 * Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {
				if (colName == "chg_delt_ofc_cd") {
					MouseToolTipText = CellValue(MouseRow, MouseCol);
				}
			}
		}
	}
	
    /**
     * Sheet1 OnPopupClick 이벤트 처리  
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName = sheetObj.ColSaveName(Col);
    	
        if (colName == "chg_delt_ofc_cd") { //ofc-code 공통팝업 호출
        	var param = "?";
        	param += "ofc_cd=" + sheetObj.CellValue(Row, "chg_delt_rhq_cd");
        	ComOpenPopup('EES_DMT_7018P.do' + param , 600, 480, "getChgDeltOfcCdOnGrid", "0,1,1,1,1,1,1,1", true);
        }
 	} 
    
    /**
     * 팝업에서 선택한 조회결과값을 받아서 OFC 필드에 설정해준다.
    */
    function getChgDeltOfcCdOnGrid(aryPopupData) {

	   	with(sheetObjects[0]) {
	   		var chgDeltOfcCd = "";
	   		for (var i=0; i<aryPopupData.length; i++) {
	   			if (chgDeltOfcCd != "") chgDeltOfcCd += ",";
	   			chgDeltOfcCd += aryPopupData[i][3];
	   		}
	   		CellValue2(SelectRow, "chg_delt_ofc_cd") = chgDeltOfcCd;
	   	}
    }
    
 	/**
     * 멀티콤보필드에 데이터를 추가해준다.
     */	
	function initComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
    	}
	}      
    
 	/**
     * 멀티콤보필드에 데이터를 추가해준다.
     */	
	function addComboDefaultItem(comboXml) {
		var comboItemCode  = "All";
		var comboItemValue = "All";
		
		return comboItemCode + FIELDMARK + comboItemValue + ROWMARK + comboXml;
	}
	
    /**
     * 그리드내 콤보필드에 데이터를 추가해준다.
     */		
	function initGridComboItem(sheetObj, comboXml, columnName) {
		
    	sheetObj.InitDataCombo(0, columnName, comboXml, comboXml);
	} 
	
     /**	 
	 * RHQ 선택항목에 대한 Sub Office 를 모두 선택해준다.
	 */		
	function selectAllOfficeByRHQ() {
		var comboObj = comboObjects[1];
		for (var i = 0 ; i < comboObj.GetCount; i++) {
			comboObj.CheckIndex(i) = true; 
    	} 		
	}
	
    /**
     * 로그인 사용자의 RHQ Office Code 를 가져온다.
     */
    function getUserRhqOfcCd() {
    	var formObj = document.form;
	    
	    var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	    switch (usrRhqOfcCd) {
	    	case "SELHO": usrRhqOfcCd = "SELIB"; break;
	    }
	    
	    return usrRhqOfcCd;
    }
    
    /**
     * RHQ 하위 Office Code Combo Cell 등록용 리스트 수정 함수.
     */
    function getOfficeCode(ofc_cd) {
    	// 하위 오피스 등록이 필수가 아니기에 공백용 첫 리스트를 추가한다
    	var ofc_arr = (' |' + ofc_cd).split('|');
    	var temp = '';
    	for(var i in ofc_arr) {
    		var cd = ofc_arr[i].split('=');
//    		alert(cd);
    		temp += (cd[0] + '|');
    	}
    	return temp;
    }
    
    /**
     * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
     */
    function handleNullString(sVal) {
    	
         if (typeof(sVal) == "undefined" || sVal == "null" || sVal.length == 0) return "";

         return ComTrim(sVal);
    } 

	/* 개발자 작업  끝 */