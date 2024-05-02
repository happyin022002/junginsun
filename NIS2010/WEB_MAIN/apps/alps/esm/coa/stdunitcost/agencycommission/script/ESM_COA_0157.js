/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0157.js
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.18 장영석
* 1.0 Creation
*=========================================================
* History
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
*=========================================================*/
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
     * @class ESM_COA_0157 : ESM_COA_0157 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0157() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.sheet1_OnChange        = sheet1_OnChange;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.f_loc_cd_OnChange   	= f_loc_cd_OnChange;
    	this.divideCheckZero     	= divideCheckZero;
    	this.validateForm 			= validateForm;
    }

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet_height = 20; // sheet의 height
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
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

    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_DownExcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    			    case "btng_RowAdd":
        				doActionIBSheet(sheetObject,formObject,IBINSERT);
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
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
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
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		loadingMode = true;
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            loadingMode = false;
    	}
    	/**
         * 멀티콤보 항목을 설정한다.
         */
         function initCombo(comboObj, comboId) {
        	 with (comboObj) {
                MaxLength = 5;
                ValidChar(2, 1);
                IMEMode = 0;
                DropHeight = 300;
                Index = 0;

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
    			case 1:	//sheet2 init
    				with (sheetObj) {
    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    					Editable = true;//전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitColumnInfo(10, 3, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

    					var HeadTitle = "Del.|STS|YYYY-MM|Location|SO Code|SO Code|UOM|Total AMT|QTY|Per Unit" ;
    					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

    					//데이터속성	    [ROW, COL,	 DATATYPE,	 WIDTH, DATAALIGN,  COLMERGE, SAVENAME,	            KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,   cnt++, dtDelCheck, 30,	daCenter,	false,	  "");
    					InitDataProperty(0,   cnt++, dtStatus,	 30,	daCenter,	false,	  "ibflag");
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "cost_yrmon",         true,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "comm_loc_cd",        true,	  "",	      dfNone,		0,	        false,	    true,    5);
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "coa_cost_src_cd_nm", false,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "coa_cost_src_cd",    true,	  "",	      dfNone,		0,	        false,	    true);
    					InitDataProperty(0,   cnt++, dtData,	 70,	daCenter,	false,	  "cntr_tpsz_cd",		true,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtData,	 100,	daRight,	false,	  "otr_comm_ttl_amt",	false,	  "",	      dfFloatOrg,	2,	        true,	    true);
    					InitDataProperty(0,   cnt++, dtData,	 70,	daRight,	false,	  "bkg_ttl_qty",		false,	  "",	      dfInteger,	0,	        true,	    true);
    					InitDataProperty(0,   cnt++, dtData,	 70,	daRight,	false,	  "stnd_cost_usd_amt",	false,	  "",	      dfFloatOrg,	2,	        false,	    false);

    					// 영문자 또는 숫자만 입력
    					InitDataValid(0, "comm_loc_cd", vtEngUpOther, "1234567890");

    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(sheet_height) ;
    				}
    				break;
    		}
    	}


    	function sheet1_OnChange(sheetObj, Row,Col, Value) {
    		var sName = sheetObj.ColSaveName(Col);

    		if ( sName == "bkg_ttl_qty") {
    		    sheetObj.CellValue2(Row, "stnd_cost_usd_amt") = divideCheckZero(sheetObj.CellValue(Row,"otr_comm_ttl_amt") , Value);
    		} else if( sName == "otr_comm_ttl_amt"){
    		    sheetObj.CellValue2(Row, "stnd_cost_usd_amt") = divideCheckZero(Value, sheetObj.CellValue(Row, "bkg_ttl_qty"));
    		}
    	}

    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_COA_0157GS.do", coaFormQueryString(formObj));

					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_comm_loc_cd, "code", "code");

					ComOpenWait(false);
					break
    			case IBSEARCH:	//조회
    				if(validateForm(sheetObj,formObj,sAction)){
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch4Post("ESM_COA_0157GS.do", coaFormQueryString(formObj));
    					ComOpenWait(false);
    				}
    				break;

    			case IBSAVE:	//저장
    				if(validateForm(sheetObj,formObj,sAction)){
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = MULTI;
	    				sheetObj.DoSave("ESM_COA_0157GS.do", coaFormQueryString(formObj));
	    				ComOpenWait(false);
    				}
    				break;

    			case IBINSERT:	//행 추가
    			    if(formObj.f_cost_yrmon.value == "") {
    			        ComShowCodeMessage('COA10039');
    			    } else {
        				var row = sheetObj.DataInsert(-1);
        				if(row > 1) {
        				    sheetObj.CellValue2(row, "cost_yrmon") = sheetObj.CellValue(row-1, "cost_yrmon");
        				} else {
        				    sheetObj.CellValue2(row, "cost_yrmon") = formObj.f_cost_yrmon.value.replace("-","");
        			    }
        			    sheetObj.CellValue2(row, "cntr_tpsz_cd") = "TEU";
    			    }
    				break;

    			case IBDOWNEXCEL:	//엑셀 다운로드
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

       	function f_comm_loc_cd_OnChange(obj) {
    	    sheetObjects[0].RemoveAll();
    	}

        function divideCheckZero(vNum, vDen) {
            var vRtn = 0;

            if(parseFloat(vDen) == 0) {
                vRtn = 0;
            } else {
                vRtn = parseFloat(vNum) / parseFloat(vDen);
            }

            return vRtn;
        }

    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		var rt = false;
    		with(formObj){
    			if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
    			} else {
    				rt = true;
    			}
    		}
    		return rt;
    	}
