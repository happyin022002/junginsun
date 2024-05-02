/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1101.js
*@FileTitle : Copy Basic Tariff
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
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
     * @class ees_dmt_1101 : ees_dmt_1101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_dmt_1101() {
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

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	 
	//  업무전역변수
	var CONTINENT 	= "CONTI";
	var COUNTRY 	= "CNT";
	var REGION 		= "RGN";
	var STATE 		= "STE";
	var LOCATION 	= "LOC";

	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	var ORIGIN 		= "Origin";
	var DESTINATION = "Destination";

	/*
	 * 콤보에 선택된 항목을 변경할 경우 OnChange 이벤트 발생으로 조회된 결과를 
	 * 상위나 하위 콤보박스에  넣어줄 때 의도적이지 않게 재차발생되어지는 OnChange 이벤트를 막기 위한 변수
	 */
	var isNoChangeActive = false;

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
					initControl();
					break;

				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;

				case "btn_close":
					window.close();
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

	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
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
    	
		for(var i=0;i<sheetObjects.length;i++){
			initSheet(sheetObjects[i],i+1);
		}
		
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
    	//cvrg region, state 셋팅
    	if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_ste_cd));
    	} else {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_rgn_cd));
    	}
    	//org_dest region, state 셋팅
    	if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_ste_cd));
    	} else {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_rgn_cd));
    	}
    	//org_dest region, state 셋팅
    	if(ComGetObjValue(formObj.to_cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.to_cvrg_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.to_cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_ste_cd));
    	} else {
    		ComSetObjValue(formObj.to_cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_rgn_cd));
    	}

	    //Axon 이벤트 처리
	    initAxonControl();
	    doEnableBkgTerm();
    }

	function initAxonControl() { 
	    //Axon 이벤트 처리1. 이벤트catch 
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); //- 키보드 입력할때
//		axon_event.addListener('keydown', 'ComKeyEnter',  'form');	//Enter시 자동Retrieve
		axon_event.addListener('keydown', 'obj_keydown',  'to_org_dest_location');	//Enter시 자동Retrieve
	}

	//Axon 이벤트 처리2. 이벤트처리함수  
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
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    }
	
    //포커스가 나갈 때
    function obj_blur(){
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		
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

    // BKG Term 사용 여부를 첵크한다.
    function doEnableBkgTerm() {
    	var formObj = document.form;
    	
    	if ( (ComGetObjValue(formObj.dmdt_trf_cd) == "DTOC" || ComGetObjValue(formObj.dmdt_trf_cd) == "DTIC") &&
    	     (ComGetObjValue(formObj.to_cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.to_cvrg_cnt_cd) == "CA") ){
    		comboObjects[0].Enable = true;
    	} else {
    		comboObjects[0].Enable = false;
    		ComSetObjValue(formObj.combo1, "N");
    	}
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        switch(sheetNo) {
            case 1:
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
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
   		var formObj = document.form
   		var	i = 0;
   		
	    switch(comboNo) {
		  	// Dem/det Delivery Term Code
	    	case 1:
	    		var arrDmdtDeTermCdCode = f_dmdt_de_term_cdCode.split("|");
            	var arrDmdtDeTermCdText = f_dmdt_de_term_cdText.split("|");
            	
            	
            	with (comboObj) {
	                MultiSelect = false; 
	                UseAutoComplete = false;    
	                SetColAlign("left");
	                SetColWidth("50");
	                DropHeight = 60;
	                ValidChar(2,1);     //영문 대문자, 숫자
	                MaxLength = 2;

	                for (var j=0; j<arrDmdtDeTermCdText.length; j++){
						InsertItem(i++,  arrDmdtDeTermCdText[j],  arrDmdtDeTermCdCode[j]);
					}
	                
	                comboObjects[0].Code = "N";	// Default로 초기화.
            	}
	    		
	    		break;
	    		
	    	//Continent
	    	case 2:
	    		with (comboObj) { 
	    			MultiSelect = false; 
					UseAutoComplete = false;	
	    			SetColAlign("left|left");
	    			SetColWidth("30|100");
					DropHeight = 160;
					UseEdit = true;
					//ColBackColor(0) = "#CCFFFD";	//modal popup ComComboObject 오류로 인하여 색상 강제 지정
					//BackColor = "#CCFFFD";
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 1;
	    		}
	   	    

				//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT);
	    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
				break;
				
			//Country
	    	case 3:
	    		with (comboObj) {
	    			MultiSelect = false;
	    			UseAutoComplet = false;
					SetColAlign("left|left");        
					SetColWidth("30|200");
	    			DropHeight = 160;
	    			UseEdit = true;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 2;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY);
	    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
	    		break;
	    		
	    	//Region
	    	case 4:
	    		with (comboObj) {
  					MultiSelect = false; 
  					UseAutoComplete = false;	
	    			SetColAlign("left|left");
	    			SetColWidth("40|200");
  					DropHeight = 160;
  					UseEdit = true;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 3;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION);
	    		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
	    		break;
	    		
	     }    		
   	}

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	        case IBSAVE:	//저장

	        	ComSetObjValue(formObj.f_cmd, MULTI);
	        	setParameters(MULTI);

	        	if(!validateForm(sheetObj,formObj,sAction)) return;

		 		//ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                
		 		var sXml = sheetObj.GetSaveXml("EES_DMT_1101GS.do", FormQueryString(formObj));
	            var startMsg = sXml.indexOf("<MESSAGE>") + 9;
	            var endMsg   = sXml.indexOf("</MESSAGE>");
	            
	            var msg = sXml.substring(startMsg,endMsg);
	            msg = ComReplaceStr(msg, "<![CDATA[", "");
	            msg = ComReplaceStr(msg, "]]>", "");
	            ComShowMessage(msg);
	            
                //ComOpenWait End
                ComOpenWait(false);
	            
	            break;
        }
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
						//1. CONTINENT LIST
						case SEARCH08:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH08);
							setComboParameters(sComboAction, sObj);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							index_1 = 1;
							
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								//선태가능한 상태로 변경
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
							}
	
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setComboParameters(sComboAction, sObj);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							index_1 = 2;
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code = "-1";
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
							}
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code = "-1";
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
							
							if(sObj.name == "combo2" || sObj.name == "combo4" || sObj.name == "to_org_dest_location" ) {
								index_1 = 2;
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
							
							
							if(sObj.name == "combo3" || sObj.name == "combo4" || sObj.name == "to_org_dest_location") {
								index_1 = 2;
								index_2 = 3;
								clearLocation();
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
								comboObjects[index_2].Code = "-1";
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
								index_2 = 2;	//Location 초기화
								index_3 = 3;
								clearLocation();
							}
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[index_2].Code = "-1";
								comboObjects[index_2].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[index_3].Code = "-1";
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
								index_2 = 2;	//Location 초기화
								index_3 = 3;
								clearLocation();
							}
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[index_2].Code = "-1";
								comboObjects[index_2].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[index_3].Code = "-1";
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

							if(sObj.name == "to_org_dest_location") {
								index_1 = 1;
								index_2 = 2;	//Location 초기화
								index_3 = 3;
								clearLocation();
							} 
							//Continent 조회
							comboDatas = ComGetEtcData(sXml, CONTINENT);
	
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								//Continent Setting
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[index_2].Code = "-1";
								comboObjects[index_2].RemoveAll();					//Country		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									
									//Region/State List 조회
									comboObjects[index_3].Code = "-1";
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
                                ComShowCodeMessage("DMT00110", "Location")
								ComClearObject(sObj);
								ComSetFocus(sObj);
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
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);		
    	}   		
	}

	/*
	 * Combo 공통 코드를 조회한다.
	 */
	function setComboParameters(sComboAction) {
		var formObj = document.form;

		//Origin/Dest ComboSettion

		ComSetObjValue(formObj.conti_cd, comboObjects[1].Text);
		ComSetObjValue(formObj.cnt_cd, comboObjects[2].Text);
		ComSetObjValue(formObj.rgn_cd, comboObjects[3].Text);
		ComSetObjValue(formObj.ste_cd, comboObjects[3].Text);
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.to_org_dest_location));
	}

	/**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem = comboItems[0].split(FIELDMARK);
		comboObj.Text = checkedItem[0];
	}	
	
	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.to_org_dest_location, "");
	}
	
	
	function clearObjectValue(obj) {
		switch(obj.name) {
			case "to_org_dest_location":
				obj.value = "";
				break;
			default:
				obj.Text = "";
				break;
		}
	}	
	/*
	 * Continent 조회필드가 변경될 경우 그 소속의 Country, Region or State 정보를 조회해주는 함수
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		
		//1. Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		//2. 영문 대문자 체크
		var ret = ComIsAlphabet(comboObj.Text, "u");
		
		if(!ret) {
			comboObj.Text = "";
			ComSetFocus(document.form.combo3);
			return;
		}
		
		//3. 자릿수 체크
		if(comboObj.Text.length != 1) {
			comboObj.Text = "";
			ComSetFocus(comboObj);
			return;
		}
		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location 초기화
		clearLocation();
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location 초기화
		clearLocation();
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
		clearLocation();
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
	function checkLocation(obj) {
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
	
   	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		
    		switch(sAction) {
    			case IBSAVE:

    				if(ComGetObjValue(formObj.to_org_dest_conti_cd) == "") {
    					ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Continent"));
						return false;
    				}

    				//From Tariff와 To Tariff 동일할 경우
    				if(ComGetObjValue(formObj.cvrg_conti_cd) 		== ComGetObjValue(formObj.to_cvrg_conti_cd) &&
    					ComGetObjValue(formObj.cvrg_cnt_cd) 		== ComGetObjValue(formObj.to_cvrg_cnt_cd) &&
    					ComGetObjValue(formObj.cvrg_rgn_cd) 		== ComGetObjValue(formObj.to_cvrg_rgn_cd) &&
    					ComGetObjValue(formObj.cvrg_ste_cd) 		== ComGetObjValue(formObj.to_cvrg_ste_cd) &&
    					ComGetObjValue(formObj.cvrg_loc_cd) 		== ComGetObjValue(formObj.to_cvrg_loc_cd) &&
    					ComGetObjValue(formObj.cvrg_yd_cd) 			== ComGetObjValue(formObj.to_cvrg_yd_cd) &&
    					ComGetObjValue(formObj.dmdt_de_term_cd) 	== ComGetObjValue(formObj.to_dmdt_de_term_cd) &&
    					ComGetObjValue(formObj.org_dest_conti_cd) 	== ComGetObjValue(formObj.to_org_dest_conti_cd) &&
    					ComGetObjValue(formObj.org_dest_cnt_cd) 	== ComGetObjValue(formObj.to_org_dest_cnt_cd) &&
    					ComGetObjValue(formObj.org_dest_rgn_cd) 	== ComGetObjValue(formObj.to_org_dest_rgn_cd) &&
    					ComGetObjValue(formObj.org_dest_ste_cd) 	== ComGetObjValue(formObj.to_org_dest_ste_cd) &&
    					ComGetObjValue(formObj.org_dest_loc_cd) 	== ComGetObjValue(formObj.to_org_dest_loc_cd)
    				) {
    					ComAlertFocus(formObj.combo2, ComGetMsg('DMT00153', "Continent"));
    					return false;
    				}
    				
    				break;
    		}
        }
        return true;
    }
    
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.to_dmdt_de_term_cd, comboObjects[0].Code);	// 저장 전에 To Dem/Det Delivery Term Code 를 Form 객체에 할당한다. 
		
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.to_org_dest_conti_cd, comboObjects[1].Text);
		ComSetObjValue(formObj.to_org_dest_cnt_cd, 	 comboObjects[2].Text);
		
		//TO CVRG
		if(ComGetObjValue(formObj.to_cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.to_cvrg_cnt_cd) == "CA") {
			ComSetObjValue(formObj.to_cvrg_rgn_cd, "");
			ComSetObjValue(formObj.to_cvrg_ste_cd, ComGetObjValue(formObj.to_cvrg_rgn_ste_cd));
		}else{
			ComSetObjValue(formObj.to_cvrg_rgn_cd, ComGetObjValue(formObj.to_cvrg_rgn_ste_cd));
			ComSetObjValue(formObj.to_cvrg_ste_cd, "");
		}
		
		//TO ORG_DEST
		if(ComGetObjValue(formObj.to_org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.to_org_dest_cnt_cd) == "CA") {
			ComSetObjValue(formObj.to_org_dest_rgn_cd, "");
			ComSetObjValue(formObj.to_org_dest_ste_cd, comboObjects[3].Text);
		}else{
			ComSetObjValue(formObj.to_org_dest_rgn_cd, comboObjects[3].Text);
			ComSetObjValue(formObj.to_org_dest_ste_cd, "");
		}
		ComSetObjValue(formObj.to_org_dest_loc_cd, ComGetObjValue(formObj.to_org_dest_location));
	}	

	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		comboObjects[1].Code = -1;
		comboObjects[1].RemoveAll();
		comboObjects[2].Code = -1;
		comboObjects[2].RemoveAll();
		comboObjects[3].Code = -1;
		comboObjects[3].RemoveAll();
		
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");
		ComSetObjValue(formObj.loc_cd, "");

		ComSetObjValue(formObj.to_org_dest_conti_cd, "");
		ComSetObjValue(formObj.to_org_dest_cnt_cd, "");
		ComSetObjValue(formObj.to_org_dest_rgn_cd, "");
		ComSetObjValue(formObj.to_org_dest_ste_cd, "");
		ComSetObjValue(formObj.to_org_dest_location, "");
		
		Region.innerHTML = "Region";
	}	    
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
	 	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	}	
	 
	 function unLoadPage() {
		 window.returnValue="Y";
	 }

