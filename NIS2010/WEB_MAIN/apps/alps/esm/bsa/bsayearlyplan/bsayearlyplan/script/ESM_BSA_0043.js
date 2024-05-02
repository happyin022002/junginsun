/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0043.js
*@FileTitle : Target VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.01.24 최성민
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
     * @class ESM_BSA_0043 : ESM_BSA_0043 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0043() {
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
	var loadingMode = false;
	var sheet_height = 20; // sheet의 height
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
   	 * @author 최성민
   	 * @version 2011.01.25
     */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_Downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btn_Auto":
					doActionIBSheet(sheetObject,formObject,IBBATCH);
					break;

				case "bu_zoom_in":
					sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
					sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
					div_zoom_in.style.display = "none";
					div_zoom_out.style.display = "inline";					
					parent.syncHeight();					
					break;
				
				case "bu_zoom_out":
					sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
					sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
					div_zoom_in.style.display = "inline";
					div_zoom_out.style.display = "none";
					parent.syncHeight();
					break;				
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111"));
			} else {
				ComShowMessage(e);
			}
		}
	}
	
   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 최성민
    * @version 2011.01.25
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
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

        loadingMode = false;
	}
	
   /**
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 최성민
    * @version 2011.01.25
    */ 
     function initCombo(comboObj, comboId) {
    	 switch(comboObj.id) {
	        case "f_seltrade":
	            with(comboObj) {
	            	DropHeight = 300;	            	
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 3;
	            	UseAutoComplete = false;
	            	ValidChar(2, 1);	//영문대문자+숫자
	            }
	            break;
	        case "f_selrlane":
	            with(comboObj) {
	            	DropHeight = 300;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 5;
	            	UseAutoComplete = false;
	            	ValidChar(2, 1);	//영문대문자+숫자
	            }
	            break;	 
	        case "f_selslane":
	            with(comboObj) {
	            	DropHeight = 300;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 3;
	            	UseAutoComplete = false;
	            	ValidChar(2, 1);	//영문대문자+숫자
	            }
	            break;	      
	        case "f_seldir":
	            with(comboObj) {
	            	DropHeight = 300;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 1;
	            	UseAutoComplete = false;
	            	ValidChar(2, 0);	//영문만 입력
	            }
	            break;   
	        case "f_selioc":
	            with(comboObj) {
	            	DropHeight = 300;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 1;
	            	UseAutoComplete = false;
	            	ValidChar(2, 0);	//영문만 입력
	            }
	            break;	      	      
	    }
     }	
     
     /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj,1);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 최성민
      * @version 2011.01.25
      */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var formObj = document.form;
		
		switch(sheetNo) {
         	case 1:
         		with (sheetObj) {
                     // 높이 설정
                     //style.height = 300;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 9, 100);
                     
                     var HeadTitle1 = "STS|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD" ;
 					 var HeadTitle2 = "STS|SEQ|Revenue\nYYYY-MM|Sales\nYYYY-MM|Week|Trade|Sub Trade|S. Lane|Lane|Type|Vessel|Voy.|BND|IOC|Port|ETD|S.Lane\n 1st Port ETD" ;
 					
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++,  dtHiddenStatus,	30,	daCenter,	true,	 "ibflag");
				     InitDataProperty(0, cnt++,  dtSeq,          	30,	daCenter,   true,    "seq",              		false,	"",	dfNone,         0,  false,	false);
				     InitDataProperty(0, cnt++,  dtData,         	70, daCenter,   true,    "cost_yrmon",       		false,	"", dfDateYm,       0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,         	70, daCenter,   true,    "sls_yrmon",        		false,	"", dfDateYm,       0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,         	40, daCenter,   true,    "cost_wk",          		false,	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,         	50, daCenter,   true,    "trd_cd",          		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,     		70, daCenter,   true,    "sub_trd_cd",       		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	50, daCenter,   true,    "slan_cd",          		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	50, daCenter,   true,    "rlane_cd",         		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	40, daCenter,   true,    "vsl_lane_tp_cd",   		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,         	60, daCenter,   true,    "vsl_cd",           		false,  "", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,         	50, daCenter,   true,    "skd_voy_no",       		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	40, daCenter,   true,    "dir_cd",           		false,  "", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	40, daCenter,   true,    "ioc_cd",           		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,         	60, daCenter,   true,    "lst_lodg_port_cd", 		false, 	"", dfNone,         0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	120,daCenter,   true,    "lst_lodg_port_etd_dt",	false, 	"", dfUserFormat2,	0,  false,  false);
				     InitDataProperty(0, cnt++,  dtData,        	120,daCenter,   true,    "n1st_lodg_port_etd_dt",	false,  "", dfUserFormat2,	0,	false,  false);
				                  
					 HeadRowHeight  = 10;
					 CountPosition  = 0 ;
					 style.height = GetSheetHeight(sheet_height) ;
					 InitUserFormat2(0, "lst_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );
					 InitUserFormat2(0, "n1st_lodg_port_etd_dt", "####-##-## ##:##:##", "-|:" );
	                 WaitImageVisible = false;	               	 
         		}
              	break;
		}
	}

  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
   	* @author 최성민
   	* @version 2011.01.25
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
  /**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
   	* @author 최성민
   	* @version 2011.01.25
	*/
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 최성민
     * @version 2011.01.25
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		try {
			sheetObj.ShowDebugMsg = false;
			switch(sAction) {			
				case IBCLEAR:
		        	formObj.f_year.value = ComGetNowInfo("yy");
			        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
			        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
			        
					ComOpenWait(true);
					var sXml = formObj.sXml.value; 
					
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
					if(State == "S"){ 
						ComShowMessage(OBJECT_ERROR);
						ComOpenWait(false);
						return;
					}	
					var arrXml = sXml.split("|$$|");
					
					formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
			        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
			        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
			        
					if (arrXml.length > 0) {
						ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "code");
						comboObjects[0].InsertItem(0, 'All');
						comboObjects[0].Index = 0;
					}
					if (arrXml.length > 1) {
						ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "code");
						comboObjects[1].InsertItem(0, 'All');
						comboObjects[1].Index = 0;
					}
					if (arrXml.length > 2) {
						ComXml2ComboItem(arrXml[2], formObj.f_selslane, "code", "code");
						comboObjects[2].InsertItem(0, 'All');
						comboObjects[2].Index = 0;
					}
					if (arrXml.length > 3) {
						ComXml2ComboItem(arrXml[3], formObj.f_seldir, "code", "code");
						comboObjects[3].InsertItem(0, 'All');
						comboObjects[3].Index = 0;
					}
					if (arrXml.length > 4) {
						ComXml2ComboItem(arrXml[4], formObj.f_selioc, "code", "code");
						comboObjects[4].InsertItem(0, 'All');
						comboObjects[4].Index = 0;
					}				
					ComSetObjValue(formObj.sXml, "");
					break;
				
				case IBSEARCH:      //조회
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
				
					ComOpenWait(true);					
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_BSA_0043GS.do", bsaFormQueryString(formObj));
					break;
				
	        	case IBDOWNEXCEL:
	        		if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}	        		
	        		ComOpenWait(true);
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					break;
				
				case IBBATCH:      //배치
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
									
					if (!ComShowCodeConfirm("BSA10020")) {
						return false;
					}
					
					ComOpenWait(true);
					
					formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObj.GetSearchXml("ESM_BSA_0043GS.do", bsaFormQueryString(formObj));
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
					
					if (backendJobKey != null && backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 7200; //초 - 2시간
						backEndJobTimer = setInterval(getBackEndJobStatus, 10000);	//밀리초  - 10초
					}
					
					break;
			}
		} catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		} finally {
 			//배치 실행을 위해 별도 처리
 			if(sAction != IBBATCH) {
 				ComOpenWait(false);
 			}
 		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
   	 * @author 최성민
   	 * @version 2011.01.25
     */
	function validateForm(sheetObj,formObj,sAction){		
		switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if(!chkValidSearch()) {
	 				return false;
	 			}
	  		 break;
	  		 
	 		case IBDOWNEXCEL: //엑셀다운로드
	  		 break;
	  		 
	 		case IBBATCH: // batch
	 			if(!formObj.f_chkprd[0].checked){
					// [COM12114] : W/M 를(을) 확인하세요.
					ComShowCodeMessage("COM12114", "W/M");
					return false;
				}
	 			
	 			if(!chkValidSearch()) {
	 				return false;
	 			}
	  		 break;  		 
		}	   
		return true;
	}
 	
    /**
     * 검색시 필수입력사항 체크  <br>
     * <br><b>Example :</b>
     * <pre>
     *     chkValidSearch()
     * </pre>
     * @returns 없음
   	 * @author 최성민
   	 * @version 2011.01.25
     */
	function chkValidSearch(){
		var formObj = document.form;
		var checkFlg = true;

 		with(formObj){
 			if (f_year.value == "") {
 				ComShowCodeMessage("COM12114", "Year");
 			    f_year.focus();
 			    checkFlg = false;
 			} else if(!ComIsDate(f_year, "yyyy")){
  		    	ComShowCodeMessage("BSA10009","Year","YYYY");
 			    f_year.focus();
 			    checkFlg = false;
  		    } else if (f_chkprd[0].checked){	     			
     			if (f_fm_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     			    f_fm_wk.focus();
     			    checkFlg = false;
     			} else if (f_to_wk.value == ""){
     				ComShowCodeMessage("COM12114", "Week");
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_fm_wk)){
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('BSA10009','Week','WW');
     				f_fm_wk.focus();
     			    checkFlg = false;
     			} else if(!ComIsWeek(f_to_wk)) {
      		    	//Please enter Week correctly.\n\n Format : WW
     				ComShowCodeMessage('BSA10009','Week','WW');
     				f_to_wk.focus();
     			    checkFlg = false;
     			} else if (f_fm_wk.value > f_to_wk.value) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("BSA10011","Week","From","To");
     			    f_to_wk.focus();
     			    checkFlg = false;
     			}
 			} else if (f_chkprd[1].checked){
     			if (f_fm_mon.value == ""){
     				ComShowCodeMessage("COM12114", "Month")
     			    f_fm_mon.focus();
     			    checkFlg = false;
     			} else if (f_to_mon.value == ""){
     				ComShowCodeMessage("COM12114", "Month")
     			    f_to_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_fm_mon)){
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('BSA10009','Month','MM');
     				f_fm_mon.focus();
     			    checkFlg = false;
     			} else if(!ComIsMonth(f_to_mon)) {
     				//Please enter Month correctly.\n\n Format : MM
     				ComShowCodeMessage('BSA10009','Month','MM');
     				f_to_mon.focus();
     			    checkFlg = false;
     			} else if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
     			    //Month의 From는(은) To보다 적거나 같아야 합니다.
     				ComShowCodeMessage("BSA10011","Month","From","To");
     			    f_to_mon.focus();
     			    checkFlg = false;
     			}			
 			}	
 		}
 		return checkFlg;
     }
	
    /**
     * 배치용 From~To Date 계산  <br>
     * <br><b>Example :</b>
     * <pre>
     *     setFmToDate()
     * </pre>
     * @returns 없음
   	 * @author 최성민
   	 * @version 2011.01.25
     */
	function setFmToDate() {
		var formObj = document.form;
		var period = div_period.innerHTML;
		
		with(formObj) {
			period = div_period.innerHTML.replace(/-|\(|\)/g,'').split('~');
			fm_date.value = ComTrim(period[0]);
			to_date.value = ComTrim(period[1]);
		}	
	}

    /**
     * trade코드 변경시 rLane 리스트를 리플래쉬 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param (object) obj - combo object
     * @returns 없음
   	 * @author 최성민
   	 * @version 2011.01.25
     */
    function f_seltrade_OnChange(obj) {
    	if (loadingMode == true) return; 
    	var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(obj.Text != ""){
        	formObj.f_cmd.value = SEARCHLIST10;
			var sXml = sheetObj.GetSearchXml("ESM_BSA_0043GS.do", FormQueryString(formObj));
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_selslane, "code", "code");
			formObj.f_selslane.Index = 0;
			formObj.f_selrlane.Index = 0;
			
        }	
    }	
	
	/**
	 *  설  명 :  month, week가 변경되었을때 Period를 변경한다. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setPeriod(obj)
	 * </pre>
	 * @param (object) obj - Document Object
	 * @see #링크연결
	 * @author 최성민
	 * @version 2011.01.25
	 */
	function setPeriod(obj){
    	 ComBsaSetPeriod(obj); 
	}
	
	/**
	 *  설  명 :  month, week가 변경되었을때 Period를 변경한다. <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     ComBsaSetPeriod(obj)
	 * </pre>
	 * @param (object) obj - form Object
	 * @see #링크연결
	 * @author 최성민
	 * @version 2011.01.25
	 */
    function ComBsaSetPeriod(obj){
        var formObj = document.form;

        if(obj == null){
            return;
        }
        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if(obj.name == "f_to_mon" ){
                formObj.f_fm_mon.value = "";
            } else if (obj.name == "f_to_wk"){
                formObj.f_fm_wk.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "f_fm_mon") return false;
            if(obj.name == "f_fm_wk") return false;
        }

        if(!chkValidSearch()){
        	return false;
        }
        var sheetObj = sheetObjects[0];
    	formObj.f_cmd.value = SEARCH02;
    	
		var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		}
    } 
 
    
    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobStatus();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2011.01.28
     */     
    function getBackEndJobStatus() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	ComOpenWait(true);
    	formObj.f_cmd.value = SEARCH02;
    	var sXml = sheetObj.GetSearchXml("ESM_BSA_0043GS.do", bsaFormQueryString(formObj));
    	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
    	
    	if (jobState == "3") {
    		getBackEndJobSearch();
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "4") {
    		ComShowCodeMessage("BSA00001");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	} else if (jobState == "5") {
    		ComShowCodeMessage("BSA00002");
    		ComOpenWait(false);
    		clearInterval(backEndJobTimer);
    	}
    }   
    
    /**
     * BackEndJob의 결과가 완료되면 결과를 조회하여 메세지를 출력한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getBackEndJobSearch();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2011.01.28
     */       
    function getBackEndJobSearch() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	formObj.f_cmd.value = SEARCH03;
    	
    	var sXml = sheetObj.GetSearchXml("ESM_BSA_0043GS.do", bsaFormQueryString(formObj));
    	var vslCd = ComGetEtcData(sXml, "vsl_cd");
		
		ComOpenWait(false);
		
		if(vslCd == ""){
			// [BSA10006] : 작업이 완료되었습니다.
			ComShowCodeMessage("BSA10006");
		}else{
			// [BSA10022] : 저장된 Vessel정보에 [vessel 정보] 데이터가 있습니다. 확인하여 주시기 바랍니다.
			ComShowCodeMessage("BSA10022", vslCd);
		} 
    }     
    
    
    
    
	/* 개발자 작업  끝 */