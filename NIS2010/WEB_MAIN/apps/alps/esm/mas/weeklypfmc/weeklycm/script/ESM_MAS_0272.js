/*=======================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0272.js
*@FileTitle : Full Storage Daily Calculation
*Open Issues :
*@LastModifyDate : 2015.02.11
*@LastModifier : 김종옥
@LastVersion : 1.0   
=========================================================
* History
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
     * @class ESM_MAS_0272 : ESM_MAS_0272 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0272() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo 				= initCombo;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
    }
    
    // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 pass */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcObj = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
	           	case "btns_calendar": //달력 버튼
	         		if(srcObj.style.cursor == "hand") {
						var cal = new ComCalendarFromTo();
						cal.select(formObject.sto_fm_dt, formObject.sto_to_dt, 'yyyy-MM-dd');
	         		}
					break;
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
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

        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
        
		//html컨트롤 이벤트초기화
		initControl();
		
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}	

	function initControl() {
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
						style.height = GetSheetHeight(18) ;
						SheetWidth = mainTable.clientWidth;//전체 너비 설정
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
						MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
						Editable = false;//전체Edit 허용 여부 [선택, Default false]
						InitRowInfo(2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]

						var HeadTitle1= "Seq.|STS|CNTR No.|TP/SZ|Control\nOffice|BKG\nBound|From\nMVMT|To\nMVMT|From\nNode|To\nNode|From Date|To Date|Free\nTime|Staying\nDay|Excluded\nDay|Over\nDay";
						HeadTitle1 += "|Node\nType|Yard\nCharacter|SC Free Time|SC Free Time|Local\n/TS|DG Class|Default\nS/P|Cost\nCode|Cur.|Amount|USD AMT|Rev.\nMonth|BKG No.|POR|POL|POD|DEL|R|D";
						HeadTitle1 += "|Shipper|Consignee|Notify|S/C No.|S/C Cust.\nCode|RFA No.|RFA Cust.\nCode|Cal. Result|Cal. Update\nDate";

						var HeadTitle2= "Seq.|STS|CNTR No.|TP/SZ|Control\nOffice|BKG\nBound|From\nMVMT|To\nMVMT|From\nNode|To\nNode|From Date|To Date|Free\nTime|Staying\nDay|Excluded\nDay|Over\nDay";
						HeadTitle2 += "|Node\nType|Yard\nCharacter|Add|Total|Local\n/TS|DG Class|Default\nS/P|Cost\nCode|Cur.|Amount|USD AMT|Rev.\nMonth|BKG No.|POR|POL|POD|DEL|R|D";
						HeadTitle2 += "|Shipper|Consignee|Notify|S/C No.|S/C Cust.\nCode|RFA No.|RFA Cust.\nCode|Cal. Result|Cal. Update\nDate";
						
						var headCount = ComCountHeadTitle(HeadTitle1);
						InitColumnInfo(headCount, 6, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitHeadMode(true, false, false, true, false, false)// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]

						//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//						InitHeadRow(0, HeadTitle, true);
	                    InitHeadRow(0, HeadTitle1, true);
	    				InitHeadRow(1, HeadTitle2, true);
						//데이터속성	DataRow, Col, [DataType], [Width], [DataAlign],
						//					[ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
						//					[PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
						//					[ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
						var cnt = 0;
						InitDataProperty(0, cnt++, dtDataSeq,	30, daCenter,	true, "Seq",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		30, daCenter,	true, "sto_calc_sts",		false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		80, daCenter,	true, "cntr_no",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		45, daCenter,	true, "cntr_tpsz_cd",		false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "ofc_cd",				false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "bkg_bnd",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "sto_fm_mvmt",		false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "sto_to_mvmt",		false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "sto_fm_nod",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "sto_to_nod",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		70, daCenter,	true, "sto_fm_dt",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		70, daCenter,	true, "sto_to_dt",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "free_dys",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "stay_dys",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "free_xcld_dys",		false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "ovr_dys",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		50, daCenter,	true, "nod_tp",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "yd_chr",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "ft_add_dys",				false, "", dfNone,		    0, false, false);	// SC FT_ADD
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "ft_ttl_dys",				false, "", dfNone,		    0, false, false);	// SC_FT_TTL
						InitDataProperty(0, cnt++, dtData,		45, daCenter,	true, "locl_ts",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "dg_clss",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "dflt_vndr_seq",		false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "cost_cd",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "curr_cd",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daRight,	true, "sto_ttl_amt",		false, "", dfNullFloat,		2, false, false);
//						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "cal_src",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daRight,	true, "usd_amt",			false, "", dfNullFloat,		2, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "rev_mon",			false, "", dfDateYm,	    0, false, false);
						InitDataProperty(0, cnt++, dtData,		90, daCenter,	true, "bkg_no",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "por_cd",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "pol_cd",				false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "pod_cd",				false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "del_cd",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "rcv_term_cd",		false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		55, daCenter,	true, "de_term_cd",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "shpr_cd",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "cnee_cd",			false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		70, daCenter,	true, "ntfy_cd",			false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "sc_no",				false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "sc_cust_seq",		false, "", dfNone,		    0, false, false);
						InitDataProperty(0, cnt++, dtData,		75, daCenter,	true, "rfa_no",				false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		60, daCenter,	true, "rfa_cust_seq",		false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		110, daCenter,	true, "tes_calc",		false, "", dfNone,		    0, false, true);
						InitDataProperty(0, cnt++, dtData,		65, daCenter,	true, "cal_upd_dt",		false, "", dfDateYmd,		    0, false, true);
//						InitDataProperty(0, cnt++, dtHidden,    60, daCenter,	true, "mnl_rqst_flg");

						HeadRowHeight = 20;
						CountPosition = 2 ;
					}
					break;

		}
	}
	
	/**
     * 콤보 항목을 설정한다. 
     */
    function initCombo (comboObj, comboId) {
    	with (comboObj) {
    		switch(comboObj.id) {
				case "f_sto_type":
					InsertItem(0, "All", "");
					InsertItem(1, "Port Storage", "P");
					InsertItem(2, "Rail Ramp Storage", "R");						
					Index = 0;
					break;
					
				case "f_sto_sts":
					InsertItem(0, "All", "");
					InsertItem(1, "Finished|To Date", "Y");
					InsertItem(2, "Unfinished|From Date", "N");						
					Index = 0;
					break;
					
				case "f_cal_rslt":
					InsertItem(0, "All", "");
					InsertItem(1, "Pass", "Y");
					InsertItem(2, "Fail", "N");		
					InsertItem(3, "Exception Node", "E");		
					InsertItem(4, "No SC FT for RR", "C");	
					InsertItem(5, "No Default S/P", "V");					
					Index = 0;
					break;
    		}
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
     * 배열은 소스 상단에 정의 by.yjjeon
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
	
	/**
	* 시트 색상 바꾸기
	*/
	function sheet1_OnSearchEnd(sheetObj,errMsg){	   
	}

	/**
	* Sheet1관련 프로세스 처리 pass
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.reset();
				comboObjects[0].Index = 0;
				comboObjects[1].Index = 0;
				doEnableCondObj("date");
				ComOpenWait(false);
				break;
			case IBSEARCH:			//조회
	            if (!validateForm(sheetObj,formObj,sAction)) {
	                return false;
	            }
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_MAS_0272GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
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

		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		//공통 체크	       
		with(formObj){
			if(sAction==IBSEARCH) {
				if(ComGetObjValue(formObj.cond_type) == "date"){
					if(ComIsNull(formObj.ofc_cd)){
						ComAlertFocus(formObj.ofc_cd, ComGetMsg("COM130201", "Control Office"));
						return false;
					}else if(ComIsNull(formObj.sto_fm_dt)){
						ComAlertFocus(formObj.sto_fm_dt, ComGetMsg("COM130201", "MVMT Date"));
						return false;
					}else if(ComIsNull(formObj.sto_to_dt)){
						ComAlertFocus(formObj.sto_to_dt, ComGetMsg("COM130201", "MVMT Date"));
						return false;
//					}else if(ComIsNull(formObj.sto_fm_nod)){
//						ComAlertFocus(formObj.sto_fm_nod, ComGetMsg("COM130201", "Node"));
//						return false;
//					}else if(ComIsNull(formObj.sto_to_nod)){
//						ComAlertFocus(formObj.sto_to_nod, ComGetMsg("COM130201", "Node"));
//						return false;
					}
				}else if(ComGetObjValue(formObj.cond_type) == "bkg_cntr"){
					//MAS10075
					if( ComIsNull(formObj.bkg_no) && ComIsNull(formObj.cntr_no) ){
						ComAlertFocus(formObj.bkg_no, ComGetMsg("MAS10075"));
						return false;
					}
				}
			}
	    } 
	    return true;
	}
	
	function fnYearSet(obj){
	    obj.value = ComGetMaskedValue(obj.value,"ymd");
	}

    function condType_click() {
    	doEnableCondObj(event.srcElement.value);
    }
    
    function doEnableCondObj(condType) {
    	var formObj = document.form;
    	with (formObj) {
	    	 switch(condType){
	    	 	case "date":
	    	 		ComEnableManyObjects(true, sto_fm_dt, sto_to_dt, btns_calendar, sto_fm_nod, sto_to_nod);
	    	 		ComEnableManyObjects(false, bkg_no, cntr_no);
	    	 		ComClearManyObjects(bkg_no, cntr_no);
//	    	 		MasComSetClassManyObjects('input1', sto_fm_dt, sto_to_dt, sto_fm_nod); 
	    	 		MasComSetClassManyObjects('input1', sto_fm_dt, sto_to_dt, ofc_cd); 
	    	 		break;
	    	 	case "bkg_cntr":
	    	 		ComEnableManyObjects(true, bkg_no, cntr_no);
	    	 		ComEnableManyObjects(false, sto_fm_dt, sto_to_dt, btns_calendar, sto_fm_nod, sto_to_nod);
	    	 		ComClearManyObjects(sto_fm_dt, sto_to_dt, btns_calendar, sto_fm_nod, sto_to_nod, ofc_cd);
	    	 		MasComSetClassManyObjects('input', ofc_cd); 
	    	 		break;
	    	 }
    	}
	}

    function chkSubOfc(obj) {
    	var formObj = document.form;
    	var ofcCd = "";
    	var objOfc;
    	if( obj.checked == true ){
   			if(ComIsNull(formObj.ofc_cd)){
				obj.checked = false;
    			ComAlertFocus(formObj.ofc_cd, ComGetMsg("COM130201", "Control Office"));
    			return false;
   			} 
   			var param = "f_cmd=" + SEARCH01;
			param = param + "&f_ofc_cd=" + ComGetObjValue(formObj.ofc_cd);
			var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0272GS.do", param);
			ComSetObjValue(formObj.ofc_cd, ComGetEtcData(sXml, "subOfcCd").substr(1,ComGetEtcData(sXml, "subOfcCd").length));
    	} else {
    		objOfc = formObj.ofc_cd;
    		if( objOfc.value.length >= 5 ){
    			objOfc.value = objOfc.value.substr(0,objOfc.value.indexOf(","));
    		}
    	}
    }