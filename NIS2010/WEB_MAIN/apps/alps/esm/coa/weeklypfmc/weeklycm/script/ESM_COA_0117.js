/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_117.js
*@FileTitle : SMU Cost(RA)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-07
*@LastModifier : Kim Jong Beom
*              : 박수훈
*@LastVersion : 1.0
=========================================================
* History
* 2006-12-07 Kim Jong Beom  1.0 최초 생성 
* 2008.07.23 전성진 CSR No.N200807230006
*                   - 조회 조건 및 저장 기능 추가
* 2009.09.17 박수훈 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리 
* 2010.04.14 이행지 FormQueryString =>coaFormQueryString 변경
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] COA Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2012.07.17 이석준 [CHM-201218919-01] SMU Cost (RA) 화면 Create 기능 추가      
* 2013.05.07 성미영 [SRM-201334889] SMU Cost (RA) 전월 copy 기능 추가 
* 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
*/
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
     * @class ESM_COA_0117 : ESM_COA_0117 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0117() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.f_trd_cd_OnChange 		= f_trd_cd_OnChange;
    	this.f_sub_trd_cd_OnChange 	= setTabObject;
    	this.validateCond 			= validateCond;
    	this.validateForm 			= validateForm;
    }
    
 // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;

				case "btn_DownExcel":
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
						break;
				
				case "btn_save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;		
    			    
    			case "bu_zoom_in":
				    if(sheetObject.Rows>17){
					   sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows);
					   div_zoom_out.style.display = "inline";
					   div_zoom_in.style.display = "none";
					   parent.syncHeight();
				    }
    				break;
    
    			case "bu_zoom_out":
    				if(sheetObject.Rows>17){
    					sheetObject.style.height = sheetObject.GetSheetHeight(17);
    					div_zoom_in.style.display = "inline";
    					div_zoom_out.style.display = "none";
						parent.syncHeight();
    				}
    				break;
                case "btn_create":
                	doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;   
    			case "btn_Month_Copy":		//팝업창(Month Copy)
	  	            var display = "0,1";
	  	            ComOpenPopup("ESM_COA_0173.do?classId=ESM_COA_0117", 250, 200, "SMU Cost (RA)", display, true, false);
	  	            break;	
                    

			} // end switch
		} catch(e) {
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
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        
    	//SELCDA일 경우만 Create 버튼 활성화  
    	
    	if (document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'CLTCO'){
//    		ComBtnEnable("btn_create");
//    		ComBtnEnable("btn_save");
    	} else {
//    		ComBtnDisable("btn_create");
//    		ComBtnDisable("btn_save");
    	}
    	
        loadingMode = false;
        
        ComSetFocus(document.form.f_cost_yrmon);
        
	}
	 /**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 300;
	    	 comboObj.InsertItem(0, 'All' ,''); 
	    	 switch(comboObj.id) {
	    	 	case "f_trd_cd":
	    	 		IMEMode = 0;
	    	 		ValidChar(2, 0);
	    	 		MaxLength = 3;
	    	 		break;
	    	 	case "f_sub_trd_cd":
	    	 		IMEMode = 0;
	    	 		ValidChar(2, 0);
	    	 		MaxLength = 2;
	    	 		break;
	    	 	case "f_rlane_cd":
	    	 		IMEMode = 0;
	    	 		ValidChar(2, 1);
	    	 		MaxLength = 5;
	    	 		break;
	    	 	case "f_dir_cd":
	    	 		IMEMode = 0;
	    	 		ValidChar(2, 0);
	    	 		MaxLength = 1;
	    	 		break;
	    	 }
	    	 Index = 0;
	    	 
    	 }
     }
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		switch(sheetNo) {
			case 1:			//sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(14) ;
					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = true;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo(1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(10, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false, false);// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
					var HeadTitle = "|YYYY-MM|Trade|Sub Trade|Lane|Bound|Lane Type|Lane Type|Base Unit Cost|Policy Price";
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					//데이터속성	DataRow, Col, [DataType], [Width], [DataAlign],
					//					[ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//					[PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//					[ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					var cnt = 0; 
					InitDataProperty(0, cnt++, dtStatus,  1, daCenter,   false, "ibflag");
					InitDataProperty(0, cnt++, dtData,	100, daCenter,   false, "cost_yrmon",		true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtData,	100, daCenter,   false, "trd_cd",			true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtData,	100, daCenter,   false, "sub_trd_cd",		true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtData,	100, daCenter,   false, "rlane_cd",			true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtData,	100, daCenter,   false, "vsl_slan_dir_cd",	true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtHidden, 90, daCenter,   false, "cost_lane_tp_cd",	true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtData,	 90, daCenter,   false, "cost_lane_tp_nm",	true, "", dfNone,		    0, false,   false);
					InitDataProperty(0, cnt++, dtData,	110, daRight,	 false, "bse_uc_amt",		false, "", dfNullFloatOrg,	2, true,    true);
					InitDataProperty(0, cnt++, dtData,	110, daRight,	 false, "plcy_prc_ut_amt",	false, "", dfNullFloatOrg,	2, true,    true);

					//HeadRowHeight = 10;
					CountPosition = 0;
				}
				break;
		}
	}
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		 sheetObjects[sheetCnt++] = sheet_obj;
	}
	 /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
	/**
	* 컬럼의 값이 0인 값을 찾아 검정색으로 표시
	*/
	
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	    //plcy_prc_ut_amt 검사
    	var row1 = sheetObj.FindText("plcy_prc_ut_amt", "", 0);        
        while(row1 != -1)
        {
            sheetObj.CellBackColor(row1, "plcy_prc_ut_amt") = sheetObj.RgbColor(222, 251, 248);            
            row1 = sheetObj.FindText("plcy_prc_ut_amt", "", row1 + 1);
        }
        
        //bse_uc_amt 검사
        row1 = sheetObj.FindText("bse_uc_amt", "", 0);        
        while(row1 != -1)
        {
            sheetObj.CellBackColor(row1, "bse_uc_amt") = sheetObj.RgbColor(222, 251, 248);            
            row1 = sheetObj.FindText("bse_uc_amt", "", row1 + 1);
        }
    }

	
	/**
	* Sheet관련 프로세스 처리
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {				
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = document.form.sXml.value; 
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				if(State == "S"){ 
					ComShowMessage(OBJECT_ERROR);
					ComOpenWait(false);
					return;
				}	
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_rlane_cd, "code", "code");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_dir_cd, "code", "code");
				
				document.form.sXml.value = "";
				ComOpenWait(false);
				break;
				
			case IBSEARCH:			//조회
				if (!validateCond(formObj)) {
					return false;
				}
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_COA_0117GS.do", coaFormQueryString(formObj,'param1|param2|param3|param4'));
				ComOpenWait(false);
				break;
			
			case IBSAVE:	//저장
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESM_COA_0117GS.do", coaFormQueryString(formObj,'f_cmd',true));
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:	 //엑셀 다운로드
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
            case IBCREATE:        //SAQ로부터 SMU 단가 I/F
               if(validateForm(sheetObj,formObj,sAction)){
               	if (ComShowConfirm(ComGetMsg('COA10020')) == true) {
                   	ComOpenWait(true);
                       formObj.f_cmd.value = MULTI01;
                       var sXml = sheetObj.GetSearchXml("ESM_COA_0117GS.do",coaFormQueryString(formObj));
                       
                       if (sXml != "") sheetObj.LoadSearchXml(sXml);
                  
                       var rtn_rslt = ComGetEtcData(sXml, "TRANS_RESULT_KEY" );
                       
                       if (rtn_rslt == "S"){                       
                    	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
                       }
                       ComOpenWait(false);
               	}

               }
               break;			

		}
	}

	/**
	* ifram을 이용하여 R.Lane 표시
	*/
	function f_trd_cd_OnChange(obj) {
		if (loadingMode == true)
			return;
		
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST10;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0117GS.do", coaFormQueryString(formObj));
	
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "code");
			formObj.f_sub_trd_cd.Index = 0;
		}
	}
	
	/**
	* ifram을 이용하여 R.Lane 표시
    */
	function f_sub_trd_cd_OnChange(obj) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST11;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0117GS.do", coaFormQueryString(formObj));
	
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
			formObj.f_rlane_cd.InsertItem(0, 'All' ,''); 
			formObj.f_rlane_cd.Index = 0;
		}
	}
	
	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리
	 */
	function validateCond(formObj) {

		var rt = false;
		with(formObj){
			if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
				ComShowCodeMessage('COA10002','YYYY-MM');
    			ComSetFocus(formObj.f_cost_yrmon);
			} else {
				rt = true;
			}
		}
          
		if (ComParseInt(formObj.f_cost_yrmon.value.replace("-","")) < 200707) {
		    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
			ComShowCodeMessage('COA10037');
		    return false;
		}

		return rt;
	}
		
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		var rt = false;
		with(formObj){
			if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
				ComShowCodeMessage('COA10002','YYYY-MM');
    			ComSetFocus(formObj.f_cost_yrmon);
			} else {
				rt = true;
			}
		}
		return rt;
	}	
	
