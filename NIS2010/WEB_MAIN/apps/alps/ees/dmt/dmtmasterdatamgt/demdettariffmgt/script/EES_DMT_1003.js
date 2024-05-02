/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1003.js
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
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
     * @class EES_DMT_1003 : EES_DMT_1003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_1003() {
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
	
	// 업무전역변수
	var RHQ 		= "RHQ";
	var COUNTRY 	= "CNT";
	var CONTINENT 	= "CONTI";
    var ALL_TARIFF_CD = "all_tariff_cd"; 
	
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";

	var Mincount = 0 ;
	
	
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

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_new":
					initControl();
					initComboSearch();
					break;
					
 				case "btn_minimize":
                    Mincount = (Mincount+1)%2 ;
                    Minimize(Mincount);
                    break;

 				case "btn_downexcel":
					//alert("excel down");
 					//sheetObject1.Down2Excel(-1);
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

            //시작 환경 설정 함수 이름 변경
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
            //마지막 환경 설정 함수 추가
        	ComEndConfigSheet(sheetObjects[i]);
        }
		
        //Axon 이벤트 처리
        initControl();
	    
    }

    // 화면 깜빡임때문에 sheet1_OnLoadFinish 이벤트 적용
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,"",SEARCHLIST09,"");	
    }
    

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	//alert("initSheet");

        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {

            case "sheet1":      // sheet4 init
                with (sheetObj) {
					// 높이 설정
                	style.height = 370;
					SheetWidth = mainTable.clientWidth;

				 	// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge;
					//MergeSheet = msPrevColumnMerge + msHeaderOnly;
					MergeSheet = msAll;	
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Country|Coverage|Tariff\nType|Origin/\nDest.|dmdt_de_term_cd|BKG\nTerm||Tariff Group Name|Effective Date|Expiration Date|No.of CNTR &\n Cargo Type|Confirmation|Confirmation|Confirmation|Expiration|Expiration|Expiration|expire_chk";
					var HeadTitle2 = "|Country|Coverage|Tariff\nType|Origin/\nDest.|dmdt_de_term_cd|BKG\nTerm||Tariff Group Name|Effective Date|Expiration Date|No.of CNTR &\n Cargo Type|Confirmation|Confirmation|Confirmation|Date|Office|Name|expire_chk";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //헤더 중 (Tariff Group Name, Effective Date, Expiration Date, No. of CNTR & Cargo Type) Merge
//                    SetMergeCell (0, 5, 2, 1);  
//                    SetMergeCell (0, 6, 2, 1);  
//                    SetMergeCell (0, 7, 2, 1);  
//                    SetMergeCell (0, 8, 2, 1);  

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"hdnStatus");
                    InitDataProperty(0,	cnt++ ,	dtData,			70,		daCenter,		true,		"cvrg_cnt_cd",		false,		"",		dfNone,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,		daCenter,		true,		"covrg",			false,		"",		dfNone,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenter,		true,		"dmdt_trf_cd",		false,		"",		dfNone,		0,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		"org_dest",			false,		"",		dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,		true,		"dmdt_de_term_cd",	false,		"",		dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"dmdt_de_term_nm",	false,		"",		dfNone,		0,	false);
                    
                    InitDataProperty(0,	cnt++ ,	dtSeq,	30,		daCenter,		true,		"seq");
                    
                    InitDataProperty(0, cnt++ , dtData,			200,	daCenter,		true,		"dmdt_bzc_trf_grp_nm",	false,		"",		dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"eff_dt",			false,		"",		dfDateYmd,	0,	false);
                    InitDataProperty(0, cnt++ , dtData,			110,	daCenter,		true,		"exp_dt",			false,		"",		dfDateYmd,	0,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,		"cntr_cgo_cnt",		false,		"",		dfNone,		0,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		false,		"cre_dt",			false,		"",		dfDateYmd,	0,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		false,		"cre_ofc_cd",		false,		"",		dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		"cre_usr_nm",		false,		"",		dfNone,		0,	false);

                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		false,		"upd_dt",			false,		"",		dfDateYmd,	0,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		false,		"upd_ofc_cd",		false,		"",		dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		    false,		"upd_usr_nm",		false,		"",		dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,		false,		"expire_chk",		false,		"",		dfNone,		0,	false);
                    
                    CountPosition = 0;		// 건수 정보를 표시하지 않음.
                    ColHidden("seq") = true;
                    FrozenCols = SaveNameCol("eff_dt");
			  	}
				break;         	
         	


        }
    }
	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						ComSetObjValue(formObj.f_cmd, SEARCH);
						setParameters(SEARCH);
						
						//2.조회전 결과필드들을 Empty 시킨다.
						initResultControls();
						
	                    //ComOpenWait Start
	                    sheetObj.WaitImageVisible=false;
	                    ComOpenWait(true);

	                    //2.조회조건으로 조회실행
						sheetObj.DoSearch("EES_DMT_1003GS.do", FormQueryString(formObj));

	                    //ComOpenWait End
	                    ComOpenWait(false);
						
						//4.조회필드를 비활성화시킨다.
						//disableSearchControls();
						
						//3.Expired Validity
						for(var i=0; i<= sheetObj.RowCount+1; i++) {
							
							if(sheetObj.CellValue(i, "expire_chk") == "Y") {
								sheetObj.CellFontColor(i, 5) = sheetObj.RgbColor(255,0,0); 
								sheetObj.CellFontColor(i, 6) = sheetObj.RgbColor(255,0,0); 
								sheetObj.CellFontColor(i, 7) = sheetObj.RgbColor(255,0,0); 
								sheetObj.CellFontColor(i, 8) = sheetObj.RgbColor(255,0,0); 
							}
						}
					}
				}
				break;	

//   		case IBCLEAR:       //초기화 
//			initSearchControls();
//			//buttonMode("IBCLEAR");
//			break;
	
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.id == "sheet1") {
				sheetObj.SpeedDown2Excel(-1);
			}; 
			break;
		}			
    }
    
	
	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
           case IBSEARCH:      // 조회
				if (sheetObj.id == "sheet1") {
					if(sComboAction == SEARCHLIST09 ) {
					
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						ComSetObjValue(formObj.f_cmd, SEARCHLIST09); 
						
						//2.조회조건으로 조회실행
						var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
						
						var comboItem;
						var comboItems;
						
						// Country
						comboDatas = ComGetEtcData(sXml, COUNTRY);
				        if (comboDatas != undefined) {
				            comboItems = comboDatas.split(ROWMARK);
				            comboObjects[0].Code = "-1";
				            comboObjects[0].RemoveAll();
				            addComboItem(comboObjects[0],comboItems); //COUNTRY
				        }
				        
				        // Continent
				        comboDatas = ComGetEtcData(sXml, CONTINENT);
						if (comboDatas != undefined) {
				            comboItems = comboDatas.split(ROWMARK);
				            //선태가능한 상태로 변경
				            comboObjects[1].Code="-1";
				            comboObjects[1].RemoveAll();
				            addComboItem(comboObjects[1],comboItems);
				        }
						
						//TARIFF LIST
						comboItems = ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);	
			            //선태가능한 상태로 변경
			            comboObjects[3].Code="-1";
			            comboObjects[3].RemoveAll();
						addComboItem(comboObjects[3], comboItems);
						
						//default multi check
						for (var i = 0 ; i < comboItems.length ; i++) {
							comboObjects[3].CheckIndex(i) = true; 
				    	}  						
					} else if (sComboAction == SEARCH02 ) {
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						ComSetObjValue(formObj.f_cmd, SEARCH02); 
						setParameters(sComboAction);
						
						//2.조회조건으로 조회실행
						var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
						
						var comboItem;
						var comboItems;
						
						// Country
						comboDatas = ComGetEtcData(sXml, COUNTRY);
				        if (comboDatas != undefined) {
				            comboItems = comboDatas.split(ROWMARK);
				            comboObjects[0].Code = "-1";
				            comboObjects[0].RemoveAll();
				            addComboItem(comboObjects[0],comboItems); //COUNTRY
				        }
					} else if (sComboAction == SEARCH05 ) {
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						ComSetObjValue(formObj.f_cmd, SEARCH05); 
						setParameters(sComboAction);
						
						//2.조회조건으로 조회실행
						var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
						
						var comboItem;
						var comboItems;
						
						// Country
						comboDatas = ComGetEtcData(sXml, COUNTRY);
				        if (comboDatas != undefined) {
				            comboItems = comboDatas.split(ROWMARK);
				            comboObjects[0].Code = "-1";
				            comboObjects[0].RemoveAll();
				            addComboItem(comboObjects[0],comboItems); //COUNTRY
				        }
					}
				};
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj,comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	
	//멀티콤보 클릭 이벤트
	function combo4_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//Group Type check
    	if(!formObj.dmdt_trf_grp_tp_cd1.checked && !formObj.dmdt_trf_grp_tp_cd2.checked) {
    		//alert("Charge Group Type");
    		ComShowCodeMessage('COM12114', "Group Type");
    		return false;
    	}
    	//Validity check
    	if(!formObj.validity1.checked && !formObj.validity2.checked && !formObj.validity3.checked) {
    		//alert("Check Validity");
    		ComShowCodeMessage('COM12114', "Validity");
    		return false;
    	}
    	var checkCnt = 0;
    	for(var i = 0 ; i < comboObjects[3].GetCount () ; i++) {
			if(comboObjects[3].checkIndex(i)) {
				checkCnt++;
			}
		}
    	if(checkCnt==0) {
    		ComShowCodeMessage('COM12114', "Tariff Type");
    		return false;
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
		var	i=0;
	    
	    switch(comboNo) {
	    	//Country
	    	case 1: 
	           with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;	
					SetColAlign("left|left");        
					SetColWidth("30|200");
					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 2;
		    	}

				//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObj,SEARCH02,COUNTRY);
				break;
				
			//Origin/Destination
	    	case 2:
	    		with (comboObj) {
	    			MultiSelect = false;
	    			UseAutoComplet = true;
	    			SetColAlign("left|left");
	    			SetColWidth("30|100");
	    			DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 1;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObj,SEARCH08,CONTINET);
	    		break;
	    		
	    		//Dem/Det Delivery Term Code
	    	case 3:
	            	var arrDmdtDeTermCdCode = f_dmdt_de_term_cdCode.split("|");
	            	var arrDmdtDeTermCdText = f_dmdt_de_term_cdText.split("|");
	            	
	            	with (comboObj) {
		                MultiSelect = false; 
		                UseAutoComplete = false;    
		                SetColAlign("left");
		                SetColWidth("50");
		                DropHeight = 80;
		                ValidChar(2,1);     //영문 대문자, 숫자
		                MaxLength = 2;

		                InsertItem(0,  "All",  "A");
		                i++;
		                
		                for (var j=0; j<arrDmdtDeTermCdText.length; j++){
							InsertItem(i++,  arrDmdtDeTermCdText[j],  arrDmdtDeTermCdCode[j]);
						}
		                
		                comboObjects[2].Code = "A";	// Default로 초기화.
	            	}
	            	
	            	break;
	            	
	    	//Tariff Type
	    	case 4:
	    		with (comboObj) {
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left|left");        
  					SetColWidth("55|330");
  					DropHeight = 160;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObj,SEARCH09,ALL_TARIFF_CD);
	     } 
	} 	
	
	/*
	 * RHQ 조회필드가 변경될 경우  그 소속의 Country 정보를 조회해주는 함수
	 */		
	function searchCountryByRHQ() {
		//alert("searchCountryByRHQ()");
		var formObj = document.form;
		
		//하위의 모든 조회필드를 지운다.
		//1.Country 콤보를 지운다.
		comboObjects[0].RemoveAll();
		
		if(ComGetObjValue(formObj.rhqCd)=="") {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0],SEARCH02,COUNTRY);
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,comboObjects[0],SEARCH05,COUNTRY);
		}
	}	

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";
    	    sheetObjects[0].style.height = 480;
    	}
    	else
    	{
    	    objs.style.display = "inline";
    	    sheetObjects[0].style.height = 370;
    	}
    }

	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.svr_id, ComGetObjValue(formObj.rhqCd));			//RHQ
		ComSetObjValue(formObj.cnt_cd, comboObjects[0].Text);					//cnt_cd
		ComSetObjValue(formObj.conti_cd, comboObjects[1].Text);					//conti_cd
		//Dem/Det Delivery Term Code Setting
		ComSetObjValue(formObj.dmdt_de_term_cd, comboObjects[2].Code);
		ComSetObjValue(formObj.dmdt_de_term_nm, comboObjects[2].Text);
		
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[3].Text);			//dmdt_trf_cd_list
		
	}

		
	/*
	 *  초기화 
	 */		
	function initSearchControls() {

		var formObj = document.form;
		comboObjects[0].RemoveAll();
		comboObjects[1].RemoveAll();
		comboObjects[3].RemoveAll();
		ComSetObjValue(formObj.rhqCd, "");			//RHQ
		ComSetObjValue(formObj.svr_id, "");			//RHQ
		ComSetObjValue(formObj.cnt_cd, "");			//Coverage Country
		ComSetObjValue(formObj.conti_cd, "");		//Origin/Destination
		ComSetObjValue(formObj.dmdt_trf_cd_list, "");		//Tariff Type
		ComSetObjValue(formObj.dmdt_trf_grp_tp_cd1, "Y");	//Group Type
		ComSetObjValue(formObj.dmdt_trf_grp_tp_cd2, "Y");		//Group Type
		ComSetObjValue(formObj.validity1, "Y");		//Validity
		ComSetObjValue(formObj.validity2, "Y");		//Validity
		ComSetObjValue(formObj.validity3, "");		//Validity
	}		
	/*
	 * 조회필드 비활성화 
	 */		
	function disableSearchControls() {
		var formObj = document.form;
		formObj.rhqCd.disabled = true;
		comboObjects[0].Enable = false;
		comboObjects[1].Enable = false;
		comboObjects[3].Enable = false;
		formObj.dmdt_trf_grp_tp_cd1.disabled = true;
		formObj.dmdt_trf_grp_tp_cd2.disabled = true;		
		formObj.validity1.disabled = true;		
		formObj.validity2.disabled = true;		
		formObj.validity3.disabled = true;		
	}
		
	/*
	 * 조회필드 활성화 
	 */		
	function enableSearchControls() {
		var formObj = document.form;
		formObj.rhqCd.disabled = false;
		comboObjects[0].Enable = true;
		comboObjects[1].Enable = true;
		comboObjects[3].Enable = true;
		formObj.dmdt_trf_grp_tp_cd1.disabled = false;
		formObj.dmdt_trf_grp_tp_cd2.disabled = false;		
		formObj.validity1.disabled = false;		
		formObj.validity2.disabled = false;		
		formObj.validity3.disabled = false;		
	}
	/*
	 * 조회결과 정보 초기화
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		initResultControls();
		//조회필드 활성화
		enableSearchControls();
		
	 	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    
	    //Axon 이벤트 처리1. 이벤트catch 
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}	
	/*
	 * combo박스 데이터 초기화
	 */
	function initComboSearch() {

	    // 데이터 초기화
    	var formObj = document.form;
    	
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,"",SEARCHLIST09,"");	
	}

	/* 개발자 작업  끝 */