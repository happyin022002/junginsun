/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESD_TRS_0086.js
 *@FileTitle : CNT(Customer Nominated Trucker) Registration.
 *Open Issues :
 *Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
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
	 * @class ESD_TRS_0086 : ESD_TRS_0086 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TRS_0086() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	 /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;
	
    /**
     * 초기 이벤트 등록 
     */
    function initControl() {
		axon_event.addListenerForm  ( 'blur'     ,'obj_blur'      ,document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    ,'obj_focus'     ,document.form ); //- 포커스 들어갈때
		axon_event.addListenerForm  ( 'change'   ,'obj_change'    ,document.form );
		axon_event.addListenerFormat( 'keypress' ,'obj_keypress'  ,document.form); //- 키보드 입력할때
    } 
	
	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
 		
        switch(sheetNo) {
            case 1:
 				with (sheetObj) {
	                // 높이 설정
            		style.height = GetSheetHeight(18) ;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	                
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);
                    
                    var HeadTitle1 = "|status|Seq.|Contract |Contract |Sales Office|Sales Person|Sales Person|Customer|Customer|Contract Effective Date|Contract Effective Date|MQC|Name of Preferred Trucker|Name of Preferred Trucker|SCAC Code|Route|Route|Route|Route|Route|Route|Destination|CNTR Type|CNT Rate|CNT Rate|CNT Rate|CNT Rate|Comments|Status|Date|Date|Date|Date|Registration User|Registration User|||Approval Number";
                    var HeadTitle2 = "|status|Seq.|Type|Number|Sales Office|Rep|Name|Code|Name|From|To|MQC|Code|Name|SCAC Code|Bound|Origin|Origin|Dest|Dest|Empty Pick Up / Return|Destination|CNTR Type|Basic|Fixed/Ratio|%|Fuel|Comments|Status|Saved|Requested|Rejected|Approved|ID|Name|||Approval Number";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    HeadRowHeight = 12;
                    //데이터속성    [ROW, COL,  DATATYPE,   			WIDTH, 	DATAALIGN, 		COLMERGE, SAVENAME,  				 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,		true,	"sel", 			  				false,    "",      dfNone,          0,         true,        true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		75,		daCenter,		true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,			50,		daCenter,		true,	"Seq");
                    InitDataProperty(0, cnt++ , dtCombo,			40,		daCenter,		true,	"prc_ctrt_tp_cd",     			false, "",  dfNone,   		0,   true,  	true);
                    InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"prc_ctrt_no",     				false, "",  dfNone,   		0,   true,  	true, 20);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"sls_ofc_cd",     				false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				50,		daCenter,		true,	"ctrt_cust_srep_cd",     		false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				150,	daLeft,			true,	"ctrt_cust_srep_nm",     		false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"ctrt_cust_cd",     			false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				150,	daLeft,			true,	"ctrt_cust_nm",     			false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"ctrt_eff_dt",     				false, "",  dfUserFormat2,  0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"ctrt_exp_dt",     				false, "",  dfUserFormat2,  0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daCenter,		true,	"fnl_mqc_desc",     			false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,		60,		daCenter,		true,	"vndr_seq",     				false, "",  dfNone,   		0,   true,  	true, 6);
                    InitDataProperty(0, cnt++ , dtData,				180,	daLeft,			true,	"vndr_nm",     					false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"usa_edi_cd",     				false, "",  dfNone,   		0,   true, 		true, 4);
                    InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,		true,	"io_bnd_cd",     				false, "",  dfNone,   		0,   true,  	true,    7,   false,  false,     "",    false);
                    InitDataProperty(0, cnt++ , dtData,				60,		daCenter,		true,	"org_nod_cd",     				false, "",  dfNone,   		0,   true,  	true, 5);
                    InitDataProperty(0, cnt++ , dtCombo,			40,		daCenter,		true,	"org_nod_yard",     			false, "",  dfNone,   		0,   true,  	true);
                    InitDataProperty(0, cnt++ , dtData,				60,		daCenter,		true,	"dest_nod_cd",     				false, "",  dfNone,   		0,   true,  	true, 5);
                    InitDataProperty(0, cnt++ , dtCombo,			40,		daCenter,		true,	"dest_nod_yard",     			false, "",  dfNone,   		0,   true,  	true);
                    InitDataProperty(0, cnt++ , dtHidden,			140,	daCenter,		true,	"mty_pkup_rtn_yd_cd",     		false, "",  dfNone,   		0,   true,  	true, 7);
                    InitDataProperty(0, cnt++ , dtHidden,		   	200,	daLeft,			true,	"mty_pkup_rtn_yd_nm",     		false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,		true,	"cntr_tpsz_cd",     			false, "",  dfNone,   		0,   true,  	true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daRight,		true,	"cust_nomi_trkr_bzc_amt",     	false, "",  dfFloat,   		2,   true,  	true, 18);
                    InitDataProperty(0, cnt++ , dtCombo,			80,		daRight,		true,	"cust_nomi_trkr_fuel_div_cd",   false, "",  dfFloat,   		2,   true,  	true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daRight,		true,	"cust_nomi_trkr_fuel_rto",     	false, "",  dfFloat,   		-1,  true,  	true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daRight,		true,	"cust_nomi_trkr_fuel_amt",     	false, "",  dfFloat,   		2,   true,  	true, 13);
                    InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			true,	"cost_desc",     				false, "",  dfNone,   		0,   true,  	true);
                    InitDataProperty(0, cnt++ , dtCombo,			100,	daCenter,		true,	"disp_sts_cd",     				false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"cust_nomi_trkr_sav_dt",     	false, "",  dfDateYmd,   	0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"cust_nomi_trkr_rqst_dt",     	false, "",  dfDateYmd,   	0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"cust_nomi_trkr_rjct_dt",     	false, "",  dfDateYmd,   	0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				80,		daCenter,		true,	"cust_nomi_trkr_apro_dt",    	false, "",  dfDateYmd,   	0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				90,		daCenter,		true,	"rgst_usr_id",     				false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtData,				120,	daLeft,			true,	"rgst_usr_nm",     				false, "",  dfNone,   		0,   false,  	false);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		false,	"org_nod_yard2",     			false, "",  dfNone,   		1,   false,  	false);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		false,	"dest_nod_yard2",     			false, "",  dfNone,   		1,   false,  	false);
                    InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,		true,	"apro_no");
                    
                    InitDataCombo(0, "prc_ctrt_tp_cd",  " |S/C|RFA",  " |S|R");
                    InitDataCombo(0, "cntr_tpsz_cd", " |Dry|Reefer", " |D4|R5");
                    
                    InitUserFormat2(0, "ctrt_eff_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "ctrt_exp_dt", "####-##-##", "-|:" );
                    
                    InitDataCombo(0, 'io_bnd_cd', " |"		+io_bnd_cdText,	" |"+io_bnd_cdCode);
                    InitDataCombo(0, 'disp_sts_cd', " |"		+disp_sts_cdText,	" |"+disp_sts_cdCode);
                    InitDataCombo(0, 'cust_nomi_trkr_fuel_div_cd', " |"		+cust_nomi_trkr_fuel_div_cdText,	" |"+cust_nomi_trkr_fuel_div_cdCode);
                    
                    InitDataValid(0, "vndr_seq", vtNumericOnly);
                    DataLinkMouse("vndr_seq") = true;
                    
                    InitDataValid(0, "usa_edi_cd", vtEngUpOnly);
			}
 		}
    }
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

    	/* IBMultiCombo 초기화 */
    	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
    		initCombo(comboObjects[k], k+1);
    	}

    	/* Date/Status Combo 호출 */
    	getStatusListCombo();
    	initControl();
    	
	   	formObject.s_eff_dt.value = ComGetNowInfo("ymd");
    }

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
				case "btng_save":
					doActionIBSheet(sheetObject, formObj, IBSAVE);
					break;
				
				case "btn_retrieve":
					if(validateFormSearch(formObj)){
						doActionIBSheet(sheetObject,formObj,IBSEARCH);
					}
					break;
				
				case 'btng_rowadd':
					doActionIBSheet(sheetObject,formObj,IBINSERT);
					break;
					
				case 'btng_delete':
					doActionIBSheet(sheetObject,formObj, IBDELETE);
					break;	
					
				case 'btng_approvalrequest':
					doActionIBSheet(sheetObject,formObj, MULTI);
					break;
					
				/* [Date] */	
				case "btns_calendar":
					getCalendar();
					break;
					
				/* [Effective Date] */
				case "btns_onecalendar":
					var cal = new ComCalendar();
	        		cal.select(formObj.s_eff_dt, 'yyyyMMdd');
	        		break;
	        		
				/* [Customer] */
				case 'btng_customer':
					popCustomer();
					break;
					
				/* [Trucker] */
				case "btn_serviceprovider":
					rep_OnPopupClick();
					break;
					
				case "btng_downexcel":
					sheetObject.Down2Excel(-1, false, false, true);
					break;
								
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		try {
			sheetObj.ShowDebugMsg = false;
			
			switch(sAction) {
				case IBSEARCH:	// 조회
					sheetObj.RemoveAll();
					
					formObj.f_cmd.value = SEARCH03;
					var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj));
					if( sXml.length > 0 ) {
						sheetObj.LoadSearchXml(sXml);
					}
					break;
					
				case IBINSERT:
					//생성 후 기본값 설정하기
					var Row = sheetObj.DataInsert(-1);
					
					sheetObj.CellValue2(Row, 'disp_sts_cd') = "00";
					sheetObj.CellValue2(Row, 'rgst_usr_id') = formObj.fm_account_usr_id.value;
					sheetObj.CellValue2(Row, 'rgst_usr_nm') = formObj.fm_account_usr_nm.value;
					break;
					
				// 저장
				case IBSAVE:
					if( validateForm(sheetObj,formObj,sAction) ) {
						formObj.f_cmd.value = MULTI01;
						
						var sParam = ComGetSaveString(sheetObj, true, false);
						if( sParam == "" ){ return; }
						
						var sXml = sheetObj.GetSaveXml("ESD_TRS_0086GS.do", FormQueryString(formObj) + "&" + sParam, true);	
		    			var vCnt = ComGetEtcData(sXml, "cnt");
		    			if(vCnt > 0) {
							ComShowCodeMessage("TRS90419");
						} else {
							sheetObj.LoadSaveXml(sXml);
						}
					}
					break;
					
				// row선택 후 삭제
				case IBDELETE:
					if( sheetObj.CheckedRows("sel") < 1 ) {
						ComShowMessage(ComGetMsg("TRS90036"));
						return false;
					} else {
						if( !confirm(ComGetMsg('TRS90535', 'Delete')) ) {
							return false;
						}
						
						var checkedRow = sheetObj.FindCheckedRow("sel");
						var rowArr = checkedRow.split("|"); 
						
						for(i=0; i < rowArr.length-1; i++) {
							var disp_sts_cd = sheetObj.CellValue( rowArr[i], "disp_sts_cd");
							if( disp_sts_cd == '00' || disp_sts_cd == '02' ) {
							} else {
								ComShowCodeMessage('TRS90534', 'deleted');
								return false;
							}
						}
						
						formObj.f_cmd.value = REMOVE01;
		            	sheetObj.DoSave("ESD_TRS_0086GS.do",TrsFrmQryString(formObj),'sel',false);
					}
					break;
					
				// Request to Approval
				case MULTI:
					if( validateForm(sheetObj,formObj,sAction) ) {
						formObj.f_cmd.value = MODIFY01;
						
						sheetObj.DoSave("ESD_TRS_0086GS.do", FormQueryString(formObj), -1, false);
					}
					break;
					
			}
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	 function validateForm(sheetObj,formObj,sAction) {
		 switch (sAction) {
		 	case IBSAVE:
				if( sheetObj.RowCount("I") == 0 && sheetObj.RowCount("U") == 0 ) {
					ComShowCodeMessage("TRS90381");
					return false;
				}
				
				// 가져온 행을 배열로 반든다.
				var rowCnt = sheetObj.RowCount;
				
				for(i=0; i<rowCnt; i++) {
					if( sheetObj.CellValue(i+2, "ibflag") == "I" || sheetObj.CellValue(i+2, "ibflag") == "U" ) {
						if(sheetObj.CellValue(i+2, "ibflag") == "U") {
							// save & reject 상태만 update 가능
							if( sheetObj.CellValue(i+2, "disp_sts_cd") != "00" && sheetObj.CellValue(i+2, "disp_sts_cd") != "02" ) {
								ComShowCodeMessage('TRS90534', 'updated');
								return false;
							}
						}
						
						if(sheetObj.CellValue(i+2, "prc_ctrt_tp_cd")=="") {
							ComShowCodeMessage("COM130201", "Contract Type");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "prc_ctrt_no")=="") {
							ComShowCodeMessage("COM130201", "Contract Number");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "vndr_seq")=="") {
							ComShowCodeMessage("COM130201", "Name of Preferred Trucker Code");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "io_bnd_cd")=="") {
							ComShowCodeMessage("COM130201", "Route Bound");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "org_nod_cd")=="") {
							ComShowCodeMessage("COM130201", "Route Origin");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "org_nod_yard")=="" && sheetObj.CellValue(i+2, "org_nod_yard2")!="") {
							sheetObj.CellValue2(i+2, "org_nod_yard") = sheetObj.CellValue(i+2, "org_nod_yard2");
						}
						
						if(sheetObj.CellValue(i+2, "dest_nod_cd")=="") {
							ComShowCodeMessage("COM130201", "Route Dest");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "dest_nod_yard")=="" && sheetObj.CellValue(i+2, "dest_nod_yard2")!="") {
							sheetObj.CellValue2(i+2, "dest_nod_yard") = sheetObj.CellValue(i+2, "dest_nod_yard2");
						}
						
						if( (sheetObj.CellValue(i+2, "org_nod_cd") == sheetObj.CellValue(i+2, "dest_nod_cd")) && 
							(sheetObj.CellValue(i+2, "org_nod_yard") == sheetObj.CellValue(i+2, "dest_nod_yard")) ) {
							ComShowCodeMessage("TRS90536");
							return false;
						}
						
						if(sheetObj.CellValue(i+2, "cntr_tpsz_cd")=="") {
							ComShowCodeMessage("COM130201", "CNTR Type");
							return false;
						}

						if(sheetObj.CellValue(i+2, "cust_nomi_trkr_bzc_amt")=="" || sheetObj.CellValue(i+2, "cust_nomi_trkr_bzc_amt") == "0" ) {
							ComShowCodeMessage("COM130201", "CNT Rate(Basic)");
							return false;
						}
					
					}
				
				}
				return true;
				
		 		break;
		 		
		 	case MULTI:
		 		if( sheetObj.CheckedRows("sel") < 1 ) {
		 			ComShowMessage(ComGetMsg("TRS90036"));
		 			return false;
		   		// status check
				} else {
					var checkedRow = sheetObj.FindCheckedRow("sel");
					var rowArr = checkedRow.split("|");
					
					for(i=0; i < rowArr.length-1; i++) {
						if( sheetObj.CellValue( rowArr[i], "disp_sts_cd") != '00' && sheetObj.CellValue( rowArr[i], "disp_sts_cd") != '02') {
							ComShowMessage('selected item have already been approved.');
							return false;
						}
					}
					
					if( !ComShowCodeConfirm("TRS90535", "Request to Approval") ){
						return false;
					}
				}
		 		return true;
		 		
		 		break;
		 }
	 	return true;
	 }
	
	 /**
	  * Sheet1 의 Change 이벤트를 정의한다.
	  * @param SheetObj
	  * @param Row
	  * @param Col
	  * @param Value
	  */
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
		
	 	switch(colName) {
	 		
	 		case('prc_ctrt_tp_cd'):
	 			var prc_ctrt_tp_cd = sheetObj.cellValue(row, 'prc_ctrt_tp_cd');
	 			
	 			if( prc_ctrt_tp_cd != '' && formObj.fm_prc_ctrt_tp_cd.value != prc_ctrt_tp_cd) {
		 			sheetObj.CellValue2(row, 'prc_ctrt_no') = "";
		 			sheetObj.CellValue2(row, 'sls_ofc_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_srep_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_srep_nm') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_nm') = "";
		 			sheetObj.CellValue2(row, 'ctrt_eff_dt') = "";
		 			sheetObj.CellValue2(row, 'ctrt_exp_dt') = "";
		 			sheetObj.CellValue2(row, 'fnl_mqc_desc') = "";
		 			
	 			} else {
	 				formObj.fm_prc_ctrt_tp_cd.value = prc_ctrt_tp_cd;
	 			}
	 			break;
	 			
	 		case ('prc_ctrt_no'):
		 		if( sheetObj.cellValue(row, 'prc_ctrt_no') != '' ) {
	 				if(sheetObj.cellValue(row, 'prc_ctrt_tp_cd') == '') {
	 					ComShowCodeMessage("COM130201", "Route Bound Contract Type");
	 					sheetObj.CellValue2(row, "prc_ctrt_no") = "";
	 					break;
	 				}
	 				
		 			formObj.f_cmd.value = SEARCH07;
		 			
		 			var prc_ctrt_tp_cd = sheetObj.cellValue(row, 'prc_ctrt_tp_cd');
		 			var prc_ctrt_no = doSepRemove(sheetObj.CellValue(row,"prc_ctrt_no").toUpperCase(), " ");
		 			sheetObj.CellValue2(row,"prc_ctrt_no") = prc_ctrt_no;
		 			
		 			var urlStr = 'prc_ctrt_tp_cd=' + prc_ctrt_tp_cd + '&prc_ctrt_no='+prc_ctrt_no+'&Row='+row;
		 			
		 			var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj)+ "&" + urlStr);
		 			var arrXml = sXml.split("|$$|");
		 			
			 		if( ComGetTotalRows(sXml) == 0 ) {
			 			sheetObj.CellValue2(row, 'prc_ctrt_no') = "";
			 			sheetObj.CellValue2(row, 'sls_ofc_cd') = "";
			 			sheetObj.CellValue2(row, 'ctrt_cust_srep_cd') = "";
			 			sheetObj.CellValue2(row, 'ctrt_cust_srep_nm') = "";
			 			sheetObj.CellValue2(row, 'ctrt_cust_cd') = "";
			 			sheetObj.CellValue2(row, 'ctrt_cust_nm') = "";
			 			sheetObj.CellValue2(row, 'ctrt_eff_dt') = "";
			 			sheetObj.CellValue2(row, 'ctrt_exp_dt') = "";
			 			sheetObj.CellValue2(row, 'fnl_mqc_desc') = "";
			 			
			 		} else if( ComGetTotalRows(sXml) > 0 ) {
		 				var list = TrsXmlToListMap(arrXml);
		 				
		 				if( list.length > 0 ) {
		 					sheetObj.CellValue2(row, 'sls_ofc_cd')				= list[0]["sls_ofc_cd"];
		 					sheetObj.CellValue2(row, 'ctrt_cust_srep_cd')		= list[0]["ctrt_cust_srep_cd"];
		 					sheetObj.CellValue2(row, 'ctrt_cust_srep_nm')		= list[0]["ctrt_cust_srep_nm"];
		 					sheetObj.CellValue2(row, 'ctrt_cust_cd')			= list[0]["ctrt_cust_cd"];
		 					sheetObj.CellValue2(row, 'ctrt_cust_nm')			= list[0]["ctrt_cust_nm"];
		 					sheetObj.CellValue2(row, 'ctrt_eff_dt')				= list[0]["ctrt_eff_dt"];
		 					sheetObj.CellValue2(row, 'ctrt_exp_dt')				= list[0]["ctrt_exp_dt"];
		 					sheetObj.CellValue2(row, 'fnl_mqc_desc')			= list[0]["fnl_mqc_desc"];
		 				}
			 		}
		 		}
		 		break;
	 	
	 		case ('vndr_seq'):
	 			if( sheetObj.cellValue(row, 'vndr_seq') != '' ) {
	 				getUsaEdiCd(sheetObj, row, 'input');
	 			} else if( sheetObj.cellValue(row, 'vndr_seq') == '') {
					sheetObj.CellValue2(row, 'vndr_nm') = "";
					sheetObj.CellValue2(row, 'usa_edi_cd') = "";
	 			}
	 		break;
				
	 		case ('usa_edi_cd'):
	 			if( sheetObj.cellValue(row, 'usa_edi_cd') != '' ) {
	 				getSpNameByScacCd(sheetObj,row,sheetObj.cellValue(row, 'usa_edi_cd'));
	 			}
	 		break;	
			case('io_bnd_cd'):
				sheetObj.CellComboItem(row, "org_nod_yard", "", "");
				sheetObj.CellValue2(row, "org_nod_yard") = "";
				sheetObj.CellComboItem(row, "dest_nod_yard", "", "");
				sheetObj.CellValue2(row, "dest_nod_yard") = "";
		 	break;	
			case('org_nod_cd'):
				if( sheetObj.cellValue(row, 'org_nod_cd') != '' ) {
					var lvdor = doSepRemove(sheetObj.CellValue(row,"org_nod_cd").toUpperCase(), " ");
					sheetObj.CellValue2(row,"org_nod_cd") = lvdor;
					
					if( doengnumcheck(lvdor) ) {
						if( lvdor.length == 5 ) {
							getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "org_nod_yard", lvdor);
						} else {
 							sheetObj.CellComboItem(row, "org_nod_yard", "", "");
 							sheetObj.CellValue2(row, "org_nod_yard") = "";
						}
					} else {
						sheetObj.CellValue2(row,"org_nod_cd") = "";
						sheetObj.SelectCell(row,"org_nod_cd");
						sheetObj.CellComboItem(row, "org_nod_yard", "", "");
						sheetObj.CellValue2(row, "org_nod_yard") = "";
					}
	 			} else {
 					sheetObj.CellValue2(row,"org_nod_cd") = "";
 					sheetObj.SelectCell(row,"org_nod_cd");
 					sheetObj.CellComboItem(row, "org_nod_yard", "", "");
 					sheetObj.CellValue2(row, "org_nod_yard") = "";
	 			}
	 			
	 			getMtPickupRetrunYd(sheetObj, row);
	 			break;
	 		
	 		// 콤보
	 		case('org_nod_yard'):
 				if( sheetObj.cellValue(row, 'io_bnd_cd') == '' ) {
 					ComShowCodeMessage("COM130201", "Origin Route Bound");
 					sheetObj.CellValue2(row, "org_nod_yard") = "";
 					break;
 				}
	 			if( sheetObj.cellValue(row, 'org_nod_yard') != '' && sheetObj.cellValue(row, 'io_bnd_cd') == 'O') {
	 				getMtPickupRetrunYd(sheetObj, row);
	 			}
	 			break;
	 		
			case('dest_nod_cd'):
				if( sheetObj.cellValue(row, 'dest_nod_cd') != '' ) {
					var dest_nod_cd = sheetObj.cellValue(row, 'dest_nod_cd');
					var lvdor = doSepRemove(sheetObj.CellValue(row,"dest_nod_cd").toUpperCase(), " ");
					sheetObj.CellValue2(row,"dest_nod_cd") = lvdor;
					
					if( doengnumcheck(lvdor) ) {
						if( lvdor.length == 5 ) {
							getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "dest_nod_yard", lvdor);
						} else {
							if( lvdor.length == 0 ) {
								sheetObj.CellComboItem(row, "dest_nod_yard", "", "");
								sheetObj.CellValue2(row, "dest_nod_yard") = "";
							} else {
								errMsg = ComGetMsg("TRS90122");
								ComShowMessage(errMsg);
								sheetObj.CellValue2(row,"dest_nod_cd") = "";
								sheetObj.SelectCell(row,"dest_nod_cd");
								sheetObj.CellComboItem(row, "dest_nod_yard", "", "");
								sheetObj.CellValue2(row, "dest_nod_yard") = "";
							}
						}
					} else {
						sheetObj.CellValue2(row,"dest_nod_cd") = "";
						sheetObj.SelectCell(row,"dest_nod_cd");
						sheetObj.CellComboItem(row, "dest_nod_yard", "", "");
						sheetObj.CellValue2(row, "dest_nod_yard") = "";
					}
				} else {
					sheetObj.CellValue2(row,"dest_nod_cd") = "";
 					sheetObj.SelectCell(row,"dest_nod_cd");
 					sheetObj.CellComboItem(row, "dest_nod_yard", "", "");
 					sheetObj.CellValue2(row, "dest_nod_yard") = "";
				}
				
				getMtPickupRetrunYd(sheetObj, row);
				break;
			
			// 콤보
			case('dest_nod_yard'):
 				if( sheetObj.cellValue(row, 'io_bnd_cd') == '' ) {
 					ComShowCodeMessage("COM130201", "Dest Route Bound");
 					sheetObj.CellValue2(row, "dest_nod_yard") = "";
 					break;
 				}
	 			if( sheetObj.cellValue(row, 'dest_nod_yard') != '' && sheetObj.cellValue(row, 'io_bnd_cd') == 'I' ) {
	 				getMtPickupRetrunYd(sheetObj, row);
	 				break;
	 			}
	 			break;
	 			
			case('mty_pkup_rtn_yd_cd') :
				var rtn_td_cd = sheetObj.cellValue(row,"mty_pkup_rtn_yd_cd");
				
				if(!doengnumcheckNoMsg( rtn_td_cd )) {
					sheetObj.cellValue(row, 'mty_pkup_rtn_yd_cd') = '';
				} else {
					sheetObj.CellValue2(row,"mty_pkup_rtn_yd_cd") = rtn_td_cd.toUpperCase();
					
					if( rtn_td_cd.length == 7 ) {
						var sParam = "f_cmd=" + SEARCH04 + "&mty_pkup_rtn_yd_cd=" + sheetObj.cellValue(row, 'mty_pkup_rtn_yd_cd');
						
						var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do", sParam);
						var arrXml = sXml.split("|$$|");
						
						if( ComGetTotalRows(sXml) == 0) {
							sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
							
						} else if( ComGetTotalRows(sXml) > 0) {
							var list = TrsXmlToListMap(arrXml);
							
							if( list.length > 0 ) {
								sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm')	= list[0]["yd_nm"];
							}
						}
					} else {
						errMsg = ComGetMsg("TRS90122");
						ComShowMessage(errMsg);
						
						sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_cd') = "";
						sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
					}
				}
				break;
	 			
			case('cust_nomi_trkr_bzc_amt'):
				if(sheetObj.cellValue(row, 'cust_nomi_trkr_fuel_div_cd') == 'R') {
					setCustNomiFuelAmt(sheetObj, row);
				}
				break;
	 			
			case('cust_nomi_trkr_fuel_div_cd'):
				if(value != '' && value == 'R') {
					setCustNomiFuelAmt(sheetObj, row);
					
				} else {
					sheetObj.cellValue(row, 'cust_nomi_trkr_fuel_rto') = 0;
					sheetObj.CellEditable(row, "cust_nomi_trkr_fuel_rto") = false;
					sheetObj.CellEditable(row, "cust_nomi_trkr_fuel_amt") = true;
				}
				
				break;
				
			case('cust_nomi_trkr_fuel_rto'):
				if(sheetObj.cellValue(row, 'cust_nomi_trkr_fuel_div_cd') == 'R') {
					setCustNomiFuelAmt(sheetObj, row);
				}
				
				break;
	 	}
	}
	
	/**
	 * CNT Rate가 Ratio일 경우 ratio에 따른 AMT 입력
	 **/
	function setCustNomiFuelAmt(sheetObj, row) {
		// 활성화
		sheetObj.CellEditable(row, "cust_nomi_trkr_fuel_rto") = true;
		sheetObj.CellEditable(row, "cust_nomi_trkr_fuel_amt") = false;
		
		var basic = sheetObj.cellValue(row, 'cust_nomi_trkr_bzc_amt');
		var rto = sheetObj.cellValue(row, 'cust_nomi_trkr_fuel_rto');
		
		sheetObj.cellValue(row, 'cust_nomi_trkr_fuel_amt') = ComRound(basic*rto/100);
	}
	
	function sheet1_OnPopupClick(sheetObj, Row, Col, value) {
		if (sheetObj.ColSaveName(Col) == "vndr_seq") {
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
		}
	}
	
	/**
	* 콜백 함수. <br>
	* @param  {Array} aryPopupData	필수	 Array Object
	* @param  {Int} row				필수 선택한 Row
	* @param  {Int} col				필수 선택한 Column
	* @param  {Int} sheetIdx			필수 Sheet Index
	* @return 없음
	* @author 
	* @version 2013.03.21
	*/   
	function callBackLocation(aryPopupData, row, col, sheetIdx){
	   var sheetObj = sheetObjects[0];
	   var vndrSeq = "";
	   var vndrNm = "";
	   var i = 0;
	   
	   for(i = 0; i < aryPopupData.length; i++){
		   vndrSeq = vndrSeq + aryPopupData[i][2];
		   vndrNm = vndrNm + aryPopupData[i][4];
	   }
	   sheetObj.CellValue2(row, "vndr_seq") = vndrSeq;
	   sheetObj.CellValue2(row, "vndr_nm") = vndrNm;
	   
	   if(vndrSeq != '') {
		   getUsaEdiCd(sheetObj, row, 'pop');
	   }
	}
	
	/**
	 * vndr seq 정로를 통해 SCAC code 취득
	 */
	function getUsaEdiCd(sheetObj, row, type) {
		var vndr_seq = sheetObj.cellValue(row, 'vndr_seq');
		var sParam = "f_cmd=" + SEARCH05 + "&vndr_seq=" + vndr_seq;
		
		var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do",  sParam);
		var arrXml = sXml.split("|$$|");
		
		// 데이터가 있으면 입력
		if( ComGetTotalRows(sXml) > 0 ) {
			var list = TrsXmlToListMap(arrXml);
			if( list.length > 0 ) {
				sheetObj.CellValue2(row, 'vndr_nm')		= list[0]["vndr_nm"];
				sheetObj.CellValue2(row, 'usa_edi_cd')	= list[0]["usa_edi_cd"];
			}
		} else {
			// 일반 검색에서 취득한 vndr_seq로 취득한 정보가 없으면 공백 
			if(type != 'pop') {
				sheetObj.CellValue2(row, 'vndr_seq') = "";
				sheetObj.CellValue2(row, 'vndr_nm') = "";
				sheetObj.CellValue2(row, 'usa_edi_cd') = "";
			} else {
				sheetObj.CellValue2(row, 'usa_edi_cd') = "";
			}
		}
	}
	
	
	/**
	 * SCAC CD로 VENDOR 정보 조회
	 * SHEET1 ONCHANGE EVENT
	 */
	function getSpNameByScacCd(sheetObj,row,val) {

		var sParam = "f_cmd=" + SEARCH08 + "&usa_edi_cd=" + val;
		var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do",  sParam);

		if(ComGetEtcData(sXml,'dup_cd')=="Y"){
			ComShowCodeMessage("TRS90387","This SCAC code has more than one S/P.\nPlease contact NOA to check valid S/P code");
		}else if(ComGetEtcData(sXml,'dup_cd')=="A"){
			ComShowCodeMessage("TRS90387","SCAC Code");
			
		};
		// 일반 검색에서 취득한 vndr_seq로 취득한 정보가 없으면 공백 
		sheetObj.CellValue2(row, 'vndr_seq') 	= ComGetEtcData(sXml,'vndr_seq');
		sheetObj.CellValue2(row, 'vndr_nm') 	= ComGetEtcData(sXml,'vndr_nm');
		sheetObj.CellValue2(row, 'usa_edi_cd') 	= ComGetEtcData(sXml,'usa_edi_cd');
	}
	
	// 조회 후 콤보박스를 클릭 시 대응
	function sheet1_OnClick(sheetObj, row , col , value) {
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
		var disp_sts_cd = sheetObj.CellValue(row,"disp_sts_cd");
		
		// status 가 Request saved이거나 Reject상태만 수정 가능
		if(disp_sts_cd == '00' || disp_sts_cd == '02') {
			switch(colName){
			case('org_nod_yard'):
				var org_nod_cd = sheetObj.CellValue(row,"org_nod_cd");
			if(org_nod_cd != '') {
				getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "org_nod_yard", org_nod_cd);
			} else {
				sheetObj.CellValue(row,"org_nod_cd") = "";
			}
			
			break;
			
			case('dest_nod_yard'):
				var dest_nod_cd = sheetObj.CellValue(row,"dest_nod_cd");
			if(dest_nod_cd != '') {
				getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "dest_nod_yard", dest_nod_cd);
			} else {
				sheetObj.CellValue(row,"dest_nod_cd") = "";
			}
			
			break;
			}
		}
		
	}
	
	// Bound와 Dest 정보를 통해 PRD에서 MT p/up이나 rtn CY를 자동으로 I/F
	function getMtPickupRetrunYd(sheetObj, row) {
		var io_bnd_cd		= sheetObj.cellValue(row, 'io_bnd_cd');
		var org_nod_cd		= sheetObj.cellValue(row, 'org_nod_cd');
		var org_nod_yard	= sheetObj.cellValue(row, 'org_nod_yard');
		var dest_nod_cd		= sheetObj.cellValue(row, 'dest_nod_cd');
		var dest_nod_yard	= sheetObj.cellValue(row, 'dest_nod_yard');
		
		var sParam = "f_cmd=" + SEARCH04 + "&io_bnd_cd=" + io_bnd_cd + "&org_nod_cd=" + org_nod_cd + "&org_nod_yard=" + org_nod_yard
							+ "&dest_nod_cd=" + dest_nod_cd + "&dest_nod_yard=" + dest_nod_yard;
		
		var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do", sParam);
		var arrXml = sXml.split("|$$|");
		
		if( ComGetTotalRows(sXml) == 0) {
			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_cd') = "";
			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
			
		} else if( ComGetTotalRows(sXml) > 0) {
			var list = TrsXmlToListMap(arrXml);
			
			if( list.length > 0 ) {
				sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_cd')	= list[0]["rep_yd_cd"];
				sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm')	= list[0]["rep_yd_nm"];
			}
		}
	}
	
	
	/**
	 * 저장후 발생하는 이벤트를 처리
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
	  	var formObj = document.form;
	  	
	  	if( errMsg != null && errMsg != '' ) {
//	  		ComShowCodeMessage("TRS90416");		// 시스템 오류 등, 예기치 않은 서버오류에 의한 메시지가 왔을 경우 해당에서 처리한다.
	  	} else {
	  		// save&update
	  		if( formObj.f_cmd.value == MULTI01 ) {
	  			// save sucess
	  			ComShowCodeMessage("TRS90511");
		  		
		  		// 재조회
		  		doActionIBSheet(sheetObj,form,IBSEARCH);
	  		// approve
	  		} else if( formObj.f_cmd.value == MODIFY01 ) {
	  			// request to approval
	  			ComShowCodeMessage('COM130102', 'Request to Approval');
		  		// 재조회
		  		doActionIBSheet(sheetObj,form,IBSEARCH);
	  			
	  		// remove
	  		} else if( formObj.f_cmd.value == REMOVE01 ) {
				var checkList = sheetObj.FindCheckedRow('sel');
				var checkArray = checkList.split('|');
				
				for(var k=checkArray.length-2; k>=0; k--) {
					sheetObj.RowDelete(checkArray[k], false);
				}
				
				ComShowCodeMessage('COM12167', 'selected row');
	  		}
	  	}
	}

    /**
	 * Status Date 멀티 달력 입력 Pop-Up
	 */
	function getCalendar() {
		var cal = new ComCalendarFromTo();
		cal.displayType = "date";
		cal.select(document.form.s_fm_dt, document.form.s_to_dt, 'yyyyMMdd');
	}
	/**
	 * Status Date 멀티 달력 입력 Pop-Up - 일자에 더하기를 한다.
	 */
	function getDateBetween(obj) {
		document.form.s_to_dt.value = ComGetDateAdd(obj.value,'d', 14, '');
	}
	/**
	 * Status Date 멀티 달력 입력 Pop-Up - Enter Key시 지연대리 요청 20070115
	 */
	function doSearchEnter() {
		if( event.keyCode == 13 ) {
			var sheetObject = sheetObjects[0];
			var sheetObject1 = sheetObjects[1];
			var sheetObject2 = sheetObjects[2];
			var formObject = document.form;
			if(validateFormSearch(formObject) ) {
				sheetObject.RemoveAll(); //Single Transportation의 쉬트 내용을 제거
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
			}
		}
	}
	
  	/**
  	 * date 체크
  	 */
	function validateFormSearch(formObj) {
		var sFmDate = doSepRemove(doSepRemove(formObj.s_fm_dt.value, " "), "-");
		var sToDate = doSepRemove(doSepRemove(formObj.s_to_dt.value, " "), "-");
		var sEffDt = doSepRemove(doSepRemove(formObj.s_eff_dt.value, " "), "-");
		
		// from date
		if( sFmDate == "" ) {
			formObj.s_fm_dt.value = "";
		} else {
			if(!ComIsDate(formObj.s_fm_dt.value)){
				formObj.s_fm_dt.value = '';
				formObj.s_fm_dt.focus();
				return false;
			}
		}
		// to date
		if( sToDate == "" ) {
			formObj.s_to_dt.value = "";
		} else {
			if(!ComIsDate(formObj.s_to_dt.value)){
				formObj.s_to_dt.value = '';
				formObj.s_to_dt.focus();
				return false;
			}
		}
		// Effective Date
		if( sEffDt == "" ){
			formObj.s_eff_dt.value = "";
		} else {
			if(!ComIsDate(formObj.s_eff_dt.value)){
				formObj.s_eff_dt.value = '';
				formObj.s_eff_dt.focus();
			}
		}
		
		if( sFmDate != "" && sToDate != "" ) { //날짜 체크하는 부분
			if( dateCalcuration(sFmDate, sToDate) < 0 ) {
				errMsg = ComGetMsg("TRS90118");
				ComShowMessage(errMsg);
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Customer Popup
	 */
	function popCustomer() {
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'setCustomerPop', '1,0,1,1,1,1,1,1');
	}
	
	/**
	 * customer or Trucker name Search as code
	 */
	function setSearchName(div, cost) {
		var formObj = document.form;
			// Customer
			if(div == 'cust') {
					formObj.f_cmd.value = SEARCH06;
					var s_cust_seq = doSepRemove(cost.toUpperCase(), " ");
					formObj.s_cust_seq.value = s_cust_seq;
					
					var sXml = sheetObjects[0].GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					var list = TrsXmlToListMap(arrXml);
					
					if(list.length > 0) {
						formObj.s_cust_seq_nm.value = list[0]['cust_lgl_eng_nm'];
					} else {
						formObj.s_cust_seq_nm.value = "";
					}
			// Trucker
			} else {
				formObj.f_cmd.value = SEARCH05;
				var s_vndr_seq = doSepRemove(cost.toUpperCase(), " ");
				formObj.s_vndr_seq.value = s_vndr_seq;
				
				var sXml = sheetObjects[0].GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var list = TrsXmlToListMap(arrXml);
				
				if(list.length > 0) {
					formObj.s_vndr_seq_nm.value = list[0]['vndr_nm'];
				} else {
					formObj.s_vndr_seq_nm.value = "";
				}
			}
	}
	
	/**
	 * customer Popup
	 */
	function setCustomerPop(rowArray){
		var formObj = document.form;
		var colArray = '';
		
		if(rowArray.length>0) {
			formObj.s_cust_seq.value = rowArray[0][3];
			formObj.s_cust_seq_nm.value = rowArray[0][4];
		}
	}
	  
	/**
	 * Trucker Popup
	 */
	function rep_OnPopupClick() {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	/**
	 * Trucker 팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_rep(rowArray) {
		var formObj = document.form;
		for(var i=0; i<rowArray.length; i++)  {
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			formObj.s_vndr_seq.value =colArray2;
			formObj.s_vndr_seq_nm.value =colArray4;
		}
	}
	
	/**
	 * Date/Status Combo 셋팅
	 **/  
	function getStatusListCombo() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObjects[0].GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		var list = TrsXmlToListMap(arrXml);
		
		document.divcombo.RemoveAll();
		document.stscombo.RemoveAll();
		
		for(var i=0; i<list.length; i++) {
			document.divcombo.InsertItem(i, list[i]['intg_cd_val_dp_desc'], list[i]['intg_cd_val_ctnt']);
			document.stscombo.InsertItem(i, list[i]['intg_cd_val_dp_desc'], list[i]['intg_cd_val_ctnt']);
		}
		document.divcombo.Index=0;
	}
	 
	/**
	 * Date/Status Combo 속성 설정
	 **/
	function initCombo (comboObj, comboNo) {
		switch(comboObj.id) {
			case "divcombo":
					with(comboObj) {
						DropHeight = 150;
						MultiSelect = false;
						UseAutoComplete = true;
						MultiSeparator = ",";
						Style = 0;
						ValidChar(2,3);
					}
				break;
			case "stscombo":
					with(comboObj) {
						//BackColor = "cyan";
						DropHeight = 150;
						MultiSelect = true;
						UseAutoComplete = true;
						MultiSeparator = ",";
						Style = 0;
					}
				break;
		 }
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
	 * Date/Status Combo 속성 설정 - divcombo_OnBlur
	 **/
	function divcombo_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.s_dt_div_cd.value = ComGetObjValue(comboObj);
	}
	
	/**
	 * Date/Status Combo 속성 설정 - stscombo_OnBlur
	 **/
	function stscombo_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.s_disp_sts_cd.value = ComGetObjValue(comboObj);
	}

	/**
	 * HTML Control의 onkeypress이벤트 처리<br>
	 **/
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	}
	
	/**
	 * HTML Control의 onchange이벤트 처리<br>
	 **/
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_fm_dt":
			case "s_to_dt":
			case "s_eff_dt":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();
				};
			break;
		}
	} 
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_eff_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_eff_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}

	/**
	 * sheet내의 combo를 가져와서 등록한다.(셀단위)
	 * @param sheetObj - sheet객체
	 * @param formObject - 검색조건이 되는 form 객체
	 * @param row - combo가 세팅될 row
	 * @param colName - combo가 세팅될 컬럼alias
	 * @param value - 조회조건 location값
	 **/
	function getCntYardOriginDestSheetCombo(sheetObj, formObject, row, col, colName, value)
	{
		var srcValue = sheetObj.CellValue(row, colName);
		sheetObj.InitCellProperty(row, colName, dtCombo);
		
		var io_bnd_cd = sheetObj.cellValue(row, 'io_bnd_cd');
		var is_zone = "";
		if (io_bnd_cd == "I" && colName == "org_nod_yard") {
			is_zone = "";
		}else if (io_bnd_cd == "O" && colName == "org_nod_yard") {
			is_zone = "Y";
		}else if (io_bnd_cd == "I" && colName == "dest_nod_yard") {
			is_zone = "Y";
		}else if (io_bnd_cd == "O" && colName == "dest_nod_yard") {
			is_zone = "";
		}
		
		if (io_bnd_cd != "") {
			formObject.f_cmd.value = SEARCH01;
			var queryString = "isZone="+is_zone+"&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
			sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
			
			fm_yard_value = sheetObj.EtcData('nod');
			sheetObj.RemoveEtcData();
			sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value);
	
			if(fm_yard_value == '')
			{
				ComShowMessage(ComGetMsg('COM12161', value));
				sheetObj.CellValue2(row, col)="";
				sheetObj.SelectCell(row, col);
			}
		}else{
			sheetObj.CellComboItem(row, colName, " |", " |");
		}
	}