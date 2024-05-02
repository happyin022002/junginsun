/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_7003.js
*@FileTitle : Calculation Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근
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
     * @class ees_dmt_7003 : ees_dmt_7003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_7003() {
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
	var sheetCnt = 0;
 
	var comboObjects = new Array();
	var comboCnt = 0;

	var prefix = "sheet1_";
	
	var COUNTRY = "CNT";
	var REGION = "RGN";
	var STATE = "STE";
	var LOCATION = "LOC";
	
	//DATA 구분자 정의
	var ROWMARK = "|";
	var FIELDMARK = "=";
	
	//Field 컬럼순서 정의
	var HOL_DT_IN = 3;
	var HOL_DESC = 4;
	var HOL_YR = 5;
	var CNT_CD = 6;
	var RGN_CD = 7;
	var STE_CD = 8;
	var LOC_CD = 9;
	var HOL_DT = 10;
	var UPD_DT = 11;
	var UPD_OFC_CD = 12;
	var UPD_USR_NM = 13;	
	
	
	//onChange 함수의 중복호출을 방지하기 위한 변수
	var duplicateCaller = 0;
	
	/*
	 * 콤보에 선택된 항목을 변경할 경우 OnChange 이벤트 발생으로 조회된 결과를 
	 * 상위나 하위 콤보박스에  넣어줄 때 의도적이지 않게 재차발생되어지는 OnChange 이벤트를 막기 위한 변수
	 */
	var isNoChangeActive = false;
	
	/*
	 * Region 콤보에 있는 데이터가 초기데이터가 아닌 Country 나 Location 을 통해서 조회된 데이터라면 
	 * Region 콤보 데이터에 선택된 항목을 변경할지라도 상위 Country 조회를 실행하지 않도록 막기 위한 변수
	 */	
	var isNoInitActive = false;	
 
	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;
	

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

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;

 				case "btn_New":
 					initSearchControls();
 					break;
 					
 				case "btn_Minimize":
 					var schCondDiv = document.getElementById("sch_cond_div");
 					
 					if(schCondDiv.style.display == 'block') {
 						schCondDiv.style.display = 'none';
 						sheetObject1.style.height = 400;
 					} else {
 						schCondDiv.style.display = 'block';
 						sheetObject1.style.height = 308;
 					}
 					break;

 				case "btn_DownExcel":
 					sheetObject1.Down2Excel(-1);
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         // IBMultiCombo초기화 
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],k+1);
         }
        
         //Axon 이벤트 처리
         initControl();
     }
     
      
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
 	function sheet1_OnLoadFinish() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		//sheetObj.WaitImageVisible = false;
		
		// Country
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
		// Region
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
		
		
		// New 버튼 이벤트 실행
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
        
        //Country 조회필드에 포커스를 준다.
        comboObjects[0].focus();
        
	    //sheetObj.WaitImageVisible = true; 
 	} 
      

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 308;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "Seq.|Country|Region|State|Location|Bound|Calculation Type|Effective Date|Expiration Date|Creation Date|User Office|User Name";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,	40,		daCenter,	false,	prefix + "seq");
					InitDataProperty(0, cnt++ , dtData,	65,		daCenter,	false,	prefix + "cnt_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	65,		daCenter,	false,	prefix + "rgn_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	65,		daCenter,	false,	prefix + "ste_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	65,		daCenter,	false,	prefix + "loc_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	65,		daCenter,	false,	prefix + "io_bnd_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	110,	daCenter,	false,	prefix + "dmdt_calc_tp_cd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix + "eff_dt",			false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix + "exp_dt",			false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix + "cre_dt",			false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	false,	prefix + "cre_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,	prefix + "cre_usr_id",		false,	"",	dfNone,		0,	false,	false,	20);

 					CountPosition = 0;
 			   }
                 break;

         }
     }
     

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

            case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = SEARCH;
				formObj.cnt_cd.value = comboObjects[0].Text;
				
				if(Region.innerHTML == "Region")
					formObj.rgn_cd.value = comboObjects[1].Text;
				else
					formObj.ste_cd.value = comboObjects[1].Text;
				
				formObj.loc_cd.value = ComTrimAll(formObj.location.value);
				sheetObj.DoSearch("EES_DMT_7003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				break;
         }
     }

     
	// 조회조건필드인 Country, Region Combo 데이터 조회
     function doActionIBCombo(sheetObj,formObj,sAction,sComboAction) {
         sheetObj.ShowDebugMsg = false;
         sheetObj.WaitImageVisible = false;
 		
         switch(sAction) {
 			case IBSEARCH:      // 조회
 				if (sheetObj.id == "sheet1") {
 					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
 					setParameters(sComboAction);
 					
 					//2.조회조건으로 조회실행
 					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
 					
 					//3.조회후 결과처리
 					var comboDatas;
 					var comboItems;
 					var comboItem;
 					switch(sComboAction) {
 						
 						//3-1.Region 조회(모든 Region 목록)
 						case SEARCH01:
     						comboItems = ComGetEtcData(sXml, REGION).split(ROWMARK);
 							addComboItem(comboObjects[1],comboItems);						
 							break;
 						
 						//3-2.Country 조회(모든 Country 목록)
 						case SEARCH02:
     						comboItems = ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
 							addComboItem(comboObjects[0],comboItems);						
 							break;
 													
 						//3-3.Country 항목 선택에 따른 해당 Region 조회
 						case SEARCH03:
 							//Region 콤보 Empty 상태로 초기화
 							comboObjects[1].RemoveAll();						
 							//Location 초기화
 							clearLocation();

 							if (comboObjects[0].Text == "CA" || comboObjects[0].Text == "US") {
 								comboDatas = ComGetEtcData(sXml, STATE);
 							} else {
 								comboDatas = ComGetEtcData(sXml, REGION);
 							}
 							if (comboDatas != undefined) {
 								comboItems = comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems);	
 							}
 							break;
 													
 						//3-4.Location 항목 입력에 따른 상위 Country, Region 조회
 						case SEARCH04:
 							//Country 콤보 조회된 데이터로 선택
 							comboDatas = ComGetEtcData(sXml, COUNTRY);
 							if (comboDatas != undefined) {
 								comboItems = comboDatas.split(ROWMARK);
 								setComboItem(comboObjects[0],comboItems);
 							} 
 							
 							if (comboObjects[0].Text == "CA" || comboObjects[0].Text == "US") {
 								Region.innerHTML = "State";
 								comboDatas = ComGetEtcData(sXml, STATE);
 							} else {
 								Region.innerHTML = "Region";
 								comboDatas = ComGetEtcData(sXml, REGION);
 							}
 							
 							if (comboDatas != undefined) {
 								//Region 콤보 Empty 상태로 초기화
 								comboObjects[1].RemoveAll();
 								comboItems = comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems,true);
 								isClearLocation = true;
 							} else {
 								ComShowCodeMessage('DMT00110','Location');
 								ComClearObject(formObj.location);
 								formObj.location.focus();
 							}
 							break;
 													
 						//3-5.Region 항목 선택에 따른 상위 Country 조회
 						case SEARCH07:
 							//Country 콤보 조회된 데이터로 선택
 							comboDatas = ComGetEtcData(sXml, COUNTRY);
 							if (comboDatas != undefined) {
 								comboItems = comboDatas.split(ROWMARK);
 								setComboItem(comboObjects[0],comboItems);
 							}
 							//Location 초기화
 							clearLocation();
 							//Region 콤보 재설정
 							comboObjects[1].RemoveAll();
 							comboDatas = ComGetEtcData(sXml, REGION);
 							if (comboDatas != undefined) {
 								comboItems = comboDatas.split(ROWMARK);
 								addComboItem(comboObjects[1],comboItems,true);
 							}
 							break;
 							
 						//3-5.Region 항목코드로 상위(Country) 정보를 조회한다.
						case SEARCH13:						
						//3-6.State 항목코드로 상위(Country) 정보를 조회한다.
						case SEARCH17:
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = ComGetEtcData(sXml, COUNTRY);
							
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[0],comboItems);
								
								//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
								if (comboObjects[0].Text == "US" || comboObjects[0].Text == "CA") {
									comboDatas = ComGetEtcData(sXml, STATE);
								}
								else {
									comboDatas = ComGetEtcData(sXml, REGION);
								}
								
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[1],comboItems);
								}							
							}
							else {
								ComShowCodeMessage("DMT00110", "Region");
								comboObjects[1].Text = "";
							}
							break;	
 							
 					}						
 				};
                 break;
         }
 		sheetObj.WaitImageVisible = true;
     }
     
	
     /**
      * 콤보필드에 첫번째 항목을 선택해준다.
      */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem = comboItems[0].split(FIELDMARK);
 		comboObj.Text = checkedItem[0];
 	}	
 	
 	
 	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj,comboItems,checked) {
		var checkedItem = "";
    	for (var i = 0 ; i < comboItems.length ; i++) {
			if (ComTrim(comboItems[i]) != "") {
    			var comboItem = comboItems[i].split(FIELDMARK);
				if (i == 0) checkedItem = comboItem[0];
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			}		
    	}
		if (checked) comboObj.Text = checkedItem;
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
	    var formObject = document.form
	    var comboKey = COUNTRY;
		
	    switch(comboNo) {
    		//Country 콤보  초기화
			case 1: 
			   with (comboObj) { 
				   	MultiSelect = false; 
					UseAutoComplete = false;	
					SetColAlign("left|left");
					SetColWidth("30|200");
					FontColor = "#606060";
					DropHeight = 160;
					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 2;
			   }
			   break;
		
			//Region 콤보 초기화
			case 2: 
				with (comboObj) { 		
					MultiSelect = false; 
					UseAutoComplete = false;
					SetColAlign("left|left");        
					SetColWidth("40|190");
					FontColor = "#606060";
					DropHeight = 160;
					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 3;
				}
				break;	
	     }
	} 	
		
	/*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function combo1_OnChange(comboObj, Index_Code, Text) {
		
		if (isNoChangeActive) return;
		
		var formObj = document.form;
		//var cntCd = ComTrim(comboObj.GetText(Index_Code, 0));
		var cntCd	= comboObj.Text;
		
		//Country 가 Empty 라면 하위필드조회는 하지 않는다.				
		if (cntCd.length == 0) return;
		
		//Country 가 CA or US 이라면 Region 의 네임을 State 로 그 이외에는 Region 으로 변경한다.
		if (cntCd == "CA" || cntCd == "US") {
			Region.innerHTML = "State";
		}
		else {
			Region.innerHTML = "Region";
		}
		
		isNoChangeActive = true;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03);
		isNoInitActive = true;
		isNoChangeActive = false;
	}
	
	/*
	 * Country 콤보에서 값을 입력후 FocusOut 될 경우 다음 포커스를 지정해 준다.
	 */		
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 9)	//Tab 키가 눌릴경우
			comboObjects[0].focus();
		else if (KeyCode == 13)	//Enter 키가 눌릴경우
			comboObjects[1].focus();
	}	

	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	/*function combo2_OnChange(comboObj, Index_Code, Text) {
		
		if (isNoChangeActive || isNoInitActive) return;
				
		var formObj = document.form;
		var rgnCd = ComTrim(comboObj.GetText(Index_Code, 0));
		
		//Region 이 Empty 라면 상위필드조회는 하지 않는다.
		if (rgnCd.length == 0) return;
		
		//Region or State 에 해당되는 Country 정보를 선택해주고
		//Region or State 는 선택된 항목으로만 채워져 있어야 하다.(나머지 항목은 삭제)
		isNoChangeActive = true;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH07);
		isNoChangeActive = false;
	}*/
	 
	 
	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo2_OnChange(comboObj, Index_Code, Text) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[0];
		var rgnCd 		= comboObj.Text;
		
		switch(rgnCd.length) {
			case 2: //State Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.ste_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17);
				break;
				
			case 3:	//Region Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13);
				break;
		}
		
		//Region 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
		
	}
	 
	 
	 
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation() {
		var formObj = document.form;
		var locCd = ComTrim(ComGetObjValue(formObj.location));
    	if (locCd.length == 5) {
			isClearLocation = false;
			isNoChangeActive = true;
			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, SEARCH04);
			isNoInitActive = true;
			isNoChangeActive = false;
    	}		
	}
	
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		ComSetObjValue(formObj.cnt_cd, comboObjects[0].Text);			//Country
		
//		if (Region.innerHTML == "Region") {
//			ComSetObjValue(formObj.rgn_cd, comboObjects[1].Text);		//Region
//			ComSetObjValue(formObj.ste_cd, "");							//State
//		}
//		else {
//			ComSetObjValue(formObj.ste_cd, comboObjects[1].Text);		//State
//			ComSetObjValue(formObj.rgn_cd, "");							//Region
//		}
		
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));//Location		
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
	
	
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch 
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', form);    
	    axon_event.addListener('beforedeactivate', 'obj_deactivate', 'location');
	    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	
	
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
	function obj_deactivate() {
		obj = event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110','Location');
			ComClearObject(obj);
			ComSetFocus(obj);
		}
	}
	
	
	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}

	
	/*
	 * 조회필드 초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		comboObjects[0].Text = "";		//Country ComboBox
		comboObjects[1].RemoveAll();	//Region or State ComboBox
		Region.innerHTML = "Region";	//Region Caption
		ComSetObjValue(formObj.cnt_cd, "");
		ComSetObjValue(formObj.rgn_cd, "");
		ComSetObjValue(formObj.ste_cd, "");
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
		
		isNoInitActive = false;	
	}
	
	
	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
	
	
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initSearchControls() {
		var formObj = document.form;
		
		isNoInitActive = false;	
		ComResetAll();
		
		// New 버튼 컨트롤 호출
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		
		//Region 콤보를 초기화 시켜준다.(모든 Region 정보 조회)
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01);
	}

	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
       	 
	       	 if(sAction == IBSEARCH) {
	       		 if(!formObj.val_curr.checked && !formObj.val_tobe.checked && !formObj.val_exp.checked) {
	       			 ComShowCodeMessage('COM12114', "Validity");
	       			 return false;
	       		 }
	       		 
	       		 if(location.value != '' && location.value.length < 5) {
					ComShowCodeMessage('DMT00110','Location');
					ComClearObject(location);
					return false;
	       		 }
	       	 }
        }
        return true;
    }


	/* 개발자 작업  끝 */