/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0055.js
*@FileTitle : D/Dock Schedule Review - Graph
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.30 윤세영
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
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
     * @class esm_fms_0055 : esm_fms_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0055() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
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

	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":
	             	
	             	if (!duration_change()) return;
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
					
					ComResetAll();
					inputReadOnly("New");

                break;
                
				case "btn_SavetoFile":
					var strColSkipList = getColumnSkipList(formObject);
					sheetObject.Down2Excel(0,false,false,true,'','',false,false,'',false,strColSkipList);
                break;
	
				case "btn_Print":
					if(validateForm(sheetObject,formObject)){

						//Print Button 클릭시 필요한 파라미터 생성
						getPrintParam(formObject);
						//RD Open
						rdOpen(rdObjects[0],formObject);

					}
					
                break;
                    
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0022");
					break;
                    
				case "btn_lanepop":
					ComOpenPopup("ESM_FMS_0036.do", 620, 430,"setLaneCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0036");
					break;
                    
				case "btn_ownerpop":
					ComOpenPopup("ESM_FMS_0083.do", 500, 375,"setOwner", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0083");
					break;

     			case "btn_fr_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('year');
					cal.select(form.fr_duration, 'yyyy');
     				
					break;					

     			case "btn_to_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('year');
					cal.select(form.to_duration, 'yyyy');

					break;

     			case "btn_ownrclr":
     				form.ownr_nm.value = "";
     				form.ownr_seq.value = "";
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
     * Excel Download시 Skip할 Column List 생성
     **/
    function getColumnSkipList(formObject) {

		var fr_duration = parseFloat(formObject.fr_duration.value);
		var to_duration = parseFloat(formObject.to_duration.value);
		var k = (to_duration - fr_duration)+2;
		var strColSkipList = '';

		for (ii=k;ii<4;ii++) {
			for (j=1;j<13;j++) {
				if (j<10) {
			        strColSkipList = strColSkipList + "ym"+ii+"_0"+j+"|";
				} else {
			        strColSkipList = strColSkipList + "ym"+ii+"_"+j+"|";
				}
			}
		}

		return strColSkipList;
		
	}	

    /**
     * Print Button 클릭시 필요한 파라미터 생성 <br>
     * @param {Form Object} formObject     	form name
     **/
    function getPrintParam(formObject) {

		var fr_duration = parseFloat(formObject.fr_duration.value);
		var to_duration = parseFloat(formObject.to_duration.value);
		if (fr_duration < to_duration) {
			formObject.snd_year.value = (fr_duration+1);
		} else {
			formObject.snd_year.value = '';
		}
		if (fr_duration+2 == to_duration) {
			formObject.trd_year.value = to_duration;
		} else {
			formObject.trd_year.value = '';
		}
		formObject.flet_dck_svey_tp_nm.value = formObject.flet_dck_svey_tp_cd.options[formObject.flet_dck_svey_tp_cd.selectedIndex].text;
		formObject.reflection_nm.value = formObject.reflection_cd.options[formObject.reflection_cd.selectedIndex].text;
		
	}
    
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	var cursor = "default";
    	var img = "no_";
    	
    	if(flag == "New") {
    		readOnly = false;
    		cursor = "hand";
    		img = "";
    	}

    	form.vsl_cd.readOnly = readOnly;
    	form.lane_cd.readOnly = readOnly;
    	form.flet_ctrt_tp_cd.disabled = readOnly;
    	form.vsl_dznd_capa_fr.readOnly = readOnly;
    	form.vsl_dznd_capa_to.readOnly = readOnly;
    	form.flet_dck_svey_tp_cd.disabled = readOnly;
		form.fr_duration.readOnly = readOnly;
		form.to_duration.readOnly = readOnly;
    	form.reflection_cd.disabled = readOnly;
    	
    	document.images["btn_vslpop"].name = img+"btn_vslpop";
    	document.images["btn_lanepop"].name = img+"btn_lanepop";
    	document.images["btn_ownerpop"].name = img+"btn_ownerpop";
    	document.images["btn_fr_duration"].name = img+"btn_fr_duration";
    	document.images["btn_to_duration"].name = img+"btn_to_duration";
    	
    	form.btn_vslpop.style.cursor = cursor;
    	form.btn_lanepop.style.cursor = cursor;
    	form.btn_ownerpop.style.cursor = cursor;
    	form.btn_fr_duration.style.cursor = cursor;
    	form.btn_to_duration.style.cursor = cursor;

    }
    
	/**
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
	}

    /**
	 * Lane Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setLaneCd(aryPopupData){
		form.lane_cd.value = aryPopupData[0][3];
	}
    
    /**
	 * Owner 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setOwner(aryPopupData){
		form.ownr_seq.value = aryPopupData[0][3];
		form.ownr_nm.value = aryPopupData[0][4];
        form.btn_ownrclr.checked = true;
	}
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

	    obj = event.srcElement;

	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        //ComKeyOnlyNumber(event.srcElement);
		        ComKeyOnlyNumber(event.srcElement);

				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     }
    
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value = "";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    
    /**
     * LaneCd변경 시 해당 Lane Code 체크. <br>
     **/
    function lane_cd_change() {
    	if (form.lane_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'lane_cd');
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


        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();

		//RD
		initRdConfig(rdObjects[0]);

    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
        
        //Contract Type의 TO 삭제
        removeContractTP();
		
		sheetObj.WaitImageVisible = true;   
    }

	
	/**
     * 페이지에 있는 RD Object를 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
     * @param {rdObject} rdObject    RD Object
     **/
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
//		Rdviewer.AutoAdjust = true;
//		Rdviewer.ViewShowMode(0);
		Rdviewer.style.height = 0;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
      //2010.11.24 이상민 vsl_cd 는 eng_press -> engnum_press
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Vessel Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Vessel Code 입력 후 Name 정보 가져오기
        
        axon_event.addListener  ('keypress', 'eng_keypress' , 'lane_cd');			//- Lane Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'lane_cd_change', 'lane_cd');			//- Lane Code 입력 후 Name 정보 가져오기

        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_fr');	//- Vessel Size 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_to');	//- Vessel Size 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Duration 입력 후 From~To 비교
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Duration 입력 후 From~To 비교

        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
        
        //Contract Type의 TO 삭제
        //removeContractTP();

    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;

        //입력Validation 확인하기
    	switch(event.srcElement.name){
    			
			case "fr_duration":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			case "to_duration":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;

			case "vsl_dznd_capa_fr":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			case "vsl_dznd_capa_to":
				//숫자이면서 천단위 구분을 하지 않는다.
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			
			default:
				//ComAddSeparator(event.srcElement);
				ComChkObjValid(event.srcElement);
    	}
    }

	/**
     * Vessel Size 입력 후 From~To 비교
     **/
    function vsl_size_change() {

		var formObj = document.form;
		var vsl_dznd_capa_fr = formObj.vsl_dznd_capa_fr.value;
		var vsl_dznd_capa_to = formObj.vsl_dznd_capa_to.value;
		
		if (vsl_dznd_capa_fr != '' && vsl_dznd_capa_to != '') {
			if (parseFloat(vsl_dznd_capa_fr) > parseFloat(vsl_dznd_capa_to)) {
				ComAlertFocus(formObj.vsl_dznd_capa_fr, ComGetMsg('FMS01714'));
				formObj.vsl_dznd_capa_to.value = '';
			}
		}
	}	

	/**
     * Duration 입력 후 From~To 비교
     **/
    function duration_change() {

		var formObj = document.form;
		var fr_duration = formObj.fr_duration.value;
		var to_duration = formObj.to_duration.value;
		
		if (fr_duration != '' && to_duration != '') {
			if (parseFloat(fr_duration) > parseFloat(to_duration)) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
				return false;
			}
			
			if (parseFloat(to_duration) - parseFloat(fr_duration) >= 3) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01716'));
				return false;
			}
		}

		return true;

	}	

	/**
     * Contract Type의 TO 삭제
     **/
    function removeContractTP() {
		for (i=0;i<document.form.flet_ctrt_tp_cd.length;i++) {
			if (document.form.flet_ctrt_tp_cd.options[i].value == "TO") {
				document.form.flet_ctrt_tp_cd.remove(i);
				break;
			}
		}
		
	}	

	/**
     * 조회시 Head Title과 Column 정보 세팅, 조회년도 세팅
     **/
    function setColumnInfo(formObj) {

		var fr_duration = parseFloat(formObj.fr_duration.value);
		var to_duration = parseFloat(formObj.to_duration.value);
		var k = 1;

		for (i=fr_duration;i<=to_duration;i++) {
			
			for (j=1;j<13;j++) {

				if (j<10) {
					sheetObjects[0].CellValue(1,"ym"+k+"_0"+j) = i;
					sheetObjects[0].CellValue(2,"ym"+k+"_0"+j) = i.toString().substr(2)+"0"+j;
		        	sheetObjects[0].ColHidden("ym"+k+"_0"+j) = false;
				} else {
					sheetObjects[0].CellValue(1,"ym"+k+"_"+j) = i;
					sheetObjects[0].CellValue(2,"ym"+k+"_"+j) = i.toString().substr(2)+j;
		        	sheetObjects[0].ColHidden("ym"+k+"_"+j) = false;
				}

			}
			
			k++;
		}
		
		for (ii=k;ii<4;ii++) {
			for (j=1;j<13;j++) {
				if (j<10) {
			        sheetObjects[0].ColHidden("ym"+ii+"_0"+j) = true;
				} else {
			        sheetObjects[0].ColHidden("ym"+ii+"_"+j) = true;
				}
			}
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
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 350;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 7, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "Seq|TEU|Vessel\nCode|Lane";
                    var HeadTitle2 = "Seq|TEU|Vessel\nCode|Lane";
                    var HeadTitle3 = "Seq|TEU|Vessel\nCode|Lane";
                    
                	var arrMonth = new Array(13);
                    
                    //해더행에 표시할 글자 만들기
                    for (var iYear = 1; iYear < 4; iYear++){
                    	HeadTitle1 += arrMonth.join("|Duration(Year/Month)");
                    	HeadTitle2 += arrMonth.join("|Year");
                    	
                    	for(var iMon = 1; iMon < 13; iMon++) {
                    		if (iMon<10) {
	                    		HeadTitle3 += "|" + "0" + iMon;
                    		} else {
	                    		HeadTitle3 += "|" + iMon;
                    		}                    		
                    	}
                    }
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 4, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,      40,    	daCenter,  true,   	"Seq");
                    InitDataProperty(0, cnt++ , dtData,		40,		daCenter,  true,    "vsl_dznd_capa");
					InitDataProperty(0, cnt++ , dtData,		60,    	daCenter,  true,    "vsl_cd");
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,  true,    "slan_cd");

					//각 컬럼 기본 속성 설정하기
                    for (var iYear = 1; iYear < 2; iYear++){
                    	for(var iMon = 1; iMon < 13; iMon++) {
                    		if (iMon<10) {
	                    		sName = "ym"+iYear.toString() + "_" + "0" + iMon;
                    		} else {
	                    		sName = "ym"+iYear.toString() + "_" + iMon;
                    		}                    		
                    		InitDataProperty(0, cnt++ , dtData,		0,		daCenter,  true,   sName);
                    	}
                    }
                    for (var iYear = 2; iYear < 4; iYear++){
                    	for(var iMon = 1; iMon < 13; iMon++) {
                    		if (iMon<10) {
	                    		sName = "ym"+iYear.toString() + "_" + "0" + iMon;
                    		} else {
	                    		sName = "ym"+iYear.toString() + "_" + iMon;
                    		}                    		
                    		InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,  true,   sName);
                    	}
                    }
                    
                    SelectionMode = 0;//선택시 반전 안되도록 처리
					
               }

                break;

        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){

	        		formObj.f_cmd.value = SEARCH;

					sheetObj.DataFontColor = sheetObj.RgbColor(255,255,255); 
	        	   	
	        	   	sheetObj.DoSearch("ESM_FMS_0055GS.do", FormQueryString(formObj));
	        	   
       	   	  		setColumnInfo(formObj);

       	   	  		//inputReadOnly("Search");
	  	   	  	}	

                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					CoFmsGetCombo("FORM", formObj, sheetObj, "CD01748:CD01513","flet_dck_svey_tp_cd:flet_ctrt_tp_cd", "flet_dck_svey_tp_cdText:flet_ctrt_tp_cdText");
					

	    		} else if (Col == "vsl_cd") {
					
					formObj.f_cmd.value = SEARCH01;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
	    		} else if (Col == "lane_cd") {
					
					formObj.f_cmd.value = SEARCH05;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			
		   			if(typeof cdName != "undefined" && cdName != "" ) {
					} else {
						formObj.lane_cd.value = "";
						ComAlertFocus(formObj.lane_cd, ComGetMsg("FMS01237"));
						return;
					}
				}	
        	   
                break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        return true;
    }

     /**
      * IBSheet를 조회 후 실행되는 이벤트
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){

 		/*
		S = Special Class Survey		연노랑	FFFF00
		I = Intermediate Class Survey	연하늘	99CCFF
		D = Docking Survey				연보라	CC99FF
		P = Propeller Shaft Survey		연살색	FFCC99
		T = Temporary Class Survey		연초록	CCFFFF
 		*/
    	var arrColor = new Array(4);
    	arrColor[0] = sheetObj.WebColor("FFFF00");
    	arrColor[1] = sheetObj.WebColor("FFFF00");//255,255,0
    	arrColor[2] = sheetObj.WebColor("99CCFF");//153,204,204
    	arrColor[3] = sheetObj.WebColor("CC99FF");//204,153,255
    	arrColor[4] = sheetObj.WebColor("FFCC99");//255,204,153
    	arrColor[5] = sheetObj.WebColor("CCFFFF");//204,255,255
    	    	
		var formObj = document.form;
		var fr_duration = formObj.fr_duration.value;
		var to_duration = formObj.to_duration.value;
		
		var lastCol = (parseFloat(to_duration) - parseFloat(fr_duration)+1)*12+3
           		sheetObj.CellFontColor(4,2) = arrColor[iColor];

    	for (var ir=sheetObj.HeaderRows; ir<=sheetObj.LastRow; ir++) {
	    	for (var ic=4; ic<=lastCol; ic++) {
	    		var TypeCd = sheetObj.CellText(ir,ic);
	    		if (TypeCd=="") continue;
	    		var iColor = getDockTP(TypeCd);
	    		sheetObj.CellBackColor(ir,ic) = arrColor[iColor];
           		sheetObj.CellFontColor(ir,ic) = arrColor[iColor];
	    	}
	    }
	    
	    sheetObj.DataFontColor = sheetObj.RgbColor(0,0,0);

 		ComColFontName(sheetObj, "vsl_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "slan_cd", "Courier New"); 	

    }

     /**
      * IBSheet를 마우스 오버하는 경우 실행되는 이벤트
      */
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
	
		//앞의 4컬럼 이후부터
		if (sheetObj.MouseRow > 2 && sheetObj.MouseCol > 3) {
			//마우스 위치를 행과 컬럼과 값 가져오기
			var sText = sheetObj.CellText(sheetObj.MouseRow,sheetObj.MouseCol);
			if (sText != "") {
				sheetObj.MouseToolTipText = document.form.flet_dck_svey_tp_cd.options[getDockTP(sText)].text;
			}
		}
	}


	/**
     * D/Dock TP의 위치 정보 구하기
     **/
    function getDockTP(TypeCd) {
    	var obj = document.form.flet_dck_svey_tp_cd;

		for (i=0;i<obj.length;i++) {
			if (obj.options[i].value == TypeCd) {
				return i;
			}
		}
		
		return -1;
		
	}	

	function rdOpen(rdObject,formObject){
		var Rdviewer = rdObject ;

		queryStr = RD_FormQueryString(formObject,1);
		
		var rdParam = '/rv '+queryStr;

		rdParam += " sqlQuery["+getSqlQuery(formObject)+"]";

		var rdFile = 'ESM_FMS_056_3.mrd';
		if (formObject.snd_year.value == '') {
			rdFile = 'ESM_FMS_056_1.mrd';
		} else if (formObject.trd_year.value == '') {
			rdFile = 'ESM_FMS_056_2.mrd';
		}

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutfleetmanagement/tchariodockschedule/report/'+rdFile, RDServer + rdParam + " /rop /rprintnexit ");
		
	}	
    /**
     * Print Button 클릭시 필요한 파라미터 생성 <br>
     * @param {Form Object} formObject     	form name
     **/
    function getSqlQuery(formObject) {

		var sqlStr =  " select vsl_cd,slan_cd,vsl_dznd_capa																																								"
					+ " ,ym1_01                                                                                                                                                             							"
					+ " ,ym1_02                                                                                                                                                             							"
					+ " ,ym1_03                                                                                                                                                             							"
					+ " ,ym1_04                                                                                                                                                             							"
					+ " ,ym1_05                                                                                                                                                             							"
					+ " ,ym1_06                                                                                                                                                             							"
					+ " ,ym1_07                                                                                                                                                             							"
					+ " ,ym1_08                                                                                                                                                             							"
					+ " ,ym1_09                                                                                                                                                             							"
					+ " ,ym1_10                                                                                                                                                             							"
					+ " ,ym1_11                                                                                                                                                             							"
					+ " ,ym1_12                                                                                                                                                             							";

				if (formObject.snd_year.value != "") {
					sqlStr = sqlStr +"	,ym2_01                                                                                                                                                             							"
					+ " ,ym2_02                                                                                                                                                             							"
					+ " ,ym2_03                                                                                                                                                             							"
					+ " ,ym2_04                                                                                                                                                             							"
					+ " ,ym2_05                                                                                                                                                             							"
					+ " ,ym2_06                                                                                                                                                             							"
					+ " ,ym2_07                                                                                                                                                             							"
					+ " ,ym2_08                                                                                                                                                             							"
					+ " ,ym2_09                                                                                                                                                             							"
					+ " ,ym2_10                                                                                                                                                             							"
					+ " ,ym2_11                                                                                                                                                             							"
					+ " ,ym2_12                                                                                                                                                             							";
				}

				if (formObject.trd_year.value != "") {
					sqlStr = sqlStr +"	,ym3_01                                                                                                                                                             							"
					+ " ,ym3_02                                                                                                                                                             							"
					+ " ,ym3_03                                                                                                                                                             							"
					+ " ,ym3_04                                                                                                                                                             							"
					+ " ,ym3_05                                                                                                                                                             							"
					+ " ,ym3_06                                                                                                                                                             							"
					+ " ,ym3_07                                                                                                                                                             							"
					+ " ,ym3_08                                                                                                                                                             							"
					+ " ,ym3_09                                                                                                                                                             							"
					+ " ,ym3_10                                                                                                                                                             							"
					+ " ,ym3_11                                                                                                                                                             							"
					+ " ,ym3_12                                                                                                                                                             							";
				}

				sqlStr = sqlStr + " "
					+" from (                                                                                                                                                              							"
					+ "	select a.vsl_cd,																																												"
					+ "			d.slan_cd,                                                                                                                                                                              "
					+ "			b.vsl_dznd_capa                                                                                                                                                                         ";

		if (formObject.reflection_cd.value == "I") {
				sqlStr = sqlStr +"	,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0131' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0101' then a.flet_dck_svey_tp_cd else '' end) ym1_01                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0231' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0201' then a.flet_dck_svey_tp_cd else '' end) ym1_02                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0331' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0301' then a.flet_dck_svey_tp_cd else '' end) ym1_03                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0431' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0401' then a.flet_dck_svey_tp_cd else '' end) ym1_04                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0531' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0501' then a.flet_dck_svey_tp_cd else '' end) ym1_05                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0631' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0601' then a.flet_dck_svey_tp_cd else '' end) ym1_06                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0731' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0701' then a.flet_dck_svey_tp_cd else '' end) ym1_07                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0831' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0801' then a.flet_dck_svey_tp_cd else '' end) ym1_08                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0931' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0901' then a.flet_dck_svey_tp_cd else '' end) ym1_09                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'1031' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'1001' then a.flet_dck_svey_tp_cd else '' end) ym1_10                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'1131' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'1101' then a.flet_dck_svey_tp_cd else '' end) ym1_11                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'1231' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'1201' then a.flet_dck_svey_tp_cd else '' end) ym1_12                                                ";

				if (formObject.snd_year.value != "") {
					sqlStr = sqlStr +"	,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0131' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0101' then a.flet_dck_svey_tp_cd else '' end) ym2_01                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0231' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0201' then a.flet_dck_svey_tp_cd else '' end) ym2_02                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0331' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0301' then a.flet_dck_svey_tp_cd else '' end) ym2_03                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0431' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0401' then a.flet_dck_svey_tp_cd else '' end) ym2_04                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0531' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0501' then a.flet_dck_svey_tp_cd else '' end) ym2_05                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0631' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0601' then a.flet_dck_svey_tp_cd else '' end) ym2_06                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0731' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0701' then a.flet_dck_svey_tp_cd else '' end) ym2_07                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0831' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0801' then a.flet_dck_svey_tp_cd else '' end) ym2_08                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0931' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0901' then a.flet_dck_svey_tp_cd else '' end) ym2_09                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'1031' and phs_in_dt >= '"+formObject.snd_year.value+"'||'1001' then a.flet_dck_svey_tp_cd else '' end) ym2_10                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'1131' and phs_in_dt >= '"+formObject.snd_year.value+"'||'1101' then a.flet_dck_svey_tp_cd else '' end) ym2_11                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'1231' and phs_in_dt >= '"+formObject.snd_year.value+"'||'1201' then a.flet_dck_svey_tp_cd else '' end) ym2_12                                                ";
				}
				if (formObject.trd_year.value != "") {
					sqlStr = sqlStr +"	,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0131' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0101' then a.flet_dck_svey_tp_cd else '' end) ym3_01                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0231' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0201' then a.flet_dck_svey_tp_cd else '' end) ym3_02                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0331' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0301' then a.flet_dck_svey_tp_cd else '' end) ym3_03                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0431' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0401' then a.flet_dck_svey_tp_cd else '' end) ym3_04                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0531' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0501' then a.flet_dck_svey_tp_cd else '' end) ym3_05                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0631' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0601' then a.flet_dck_svey_tp_cd else '' end) ym3_06                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0731' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0701' then a.flet_dck_svey_tp_cd else '' end) ym3_07                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0831' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0801' then a.flet_dck_svey_tp_cd else '' end) ym3_08                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0931' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0901' then a.flet_dck_svey_tp_cd else '' end) ym3_09                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'1031' and phs_in_dt >= '"+formObject.trd_year.value+"'||'1001' then a.flet_dck_svey_tp_cd else '' end) ym3_10                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'1131' and phs_in_dt >= '"+formObject.trd_year.value+"'||'1101' then a.flet_dck_svey_tp_cd else '' end) ym3_11                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'1231' and phs_in_dt >= '"+formObject.trd_year.value+"'||'1201' then a.flet_dck_svey_tp_cd else '' end) ym3_12                                                ";
				}

			} else {
				sqlStr = sqlStr +"	,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'01','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_01	"
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'02','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_02   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'03','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_03   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'04','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_04   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'05','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_05   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'06','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_06   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'07','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_07   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'08','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_08   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'09','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_09   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'10','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_10   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'11','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_11   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'12','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_12   ";
				
				if (formObject.snd_year.value != "") {
					sqlStr = sqlStr +"	,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'01','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_01   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'02','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_02   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'03','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_03   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'04','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_04   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'05','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_05   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'06','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_06   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'07','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_07   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'08','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_08   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'09','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_09   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'10','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_10   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'11','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_11   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'12','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_12   ";
				}
				if (formObject.trd_year.value != "") {
					sqlStr = sqlStr +"	,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'01','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_01   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'02','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_02   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'03','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_03   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'04','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_04   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'05','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_05   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'06','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_06   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'07','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_07   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'08','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_08   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'09','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_09   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'10','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_10   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'11','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_11   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'12','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_12   ";
				}


		}

			sqlStr += "			from fms_dck_skd a, fms_contract b,                                                                                                                                                     "
					+ "				(select vsl_cd, flet_ctrt_no                                                                                                                                                        "
					+ "				from (                                                                                                                                                                              "
					+ "						select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                                                      "
					+ "						from fms_contract                                                                                                                                                           "
					+ "						where flet_ctrt_tp_cd <> 'TO'                                                                                                                                               "
					+ "					)                                                                                                                                                                               "
					+ "				where row_num = 1                                                                                                                                                                   "
					+ "				union all                                                                                                                                                                           "
					+ "				select vsl_cd, flet_ctrt_no                                                                                                                                                         "
					+ "				from (                                                                                                                                                                              "
					+ "						select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                                                      "
					+ "						from fms_id_vsl a                                                                                                                                                           "
					+ "						where not exists (select null from fms_contract where vsl_cd = a.vsl_cd)                                                                                                    "
					+ "					)                                                                                                                                                                               "
					+ "				where row_num = 1                                                                                                                                                                   "
					+ "				) c,                                                                                                                                                                                "
					+ "				(select vsl_cd, slan_cd                                                                                                                                                             "
					+ "				 from (                                                                                                                                                                             "
					+ "						select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num                                                                "
					+ "						from vsk_vsl_port_skd                                                                                                                                                       "
					+ "						where vps_eta_dt between to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') and to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd')                      "
					+ "					)                                                                                                                                                                               "
					+ "				 where lane_num = 1) d                                                                                                                                                              ";

			if (formObject.ownr_seq.value != "") { 
				sqlStr += "			 ,(select vndr_seq from mdm_vendor                                                                                                                                                  "
						+ "				where flet_mgmt_ownr_vndr_seq = "+formObject.ownr_seq.value+") e                                                                                                                ";
			} 

			sqlStr += "			where a.vsl_cd = c.vsl_cd(+)                                                                                                                                                            "
					+ "			and   a.vsl_cd = d.vsl_cd(+)                                                                                                                                                            "
					+ "			and   b.flet_ctrt_no(+) = c.flet_ctrt_no                                                                                                                                                ";
			
			if (formObject.flet_ctrt_tp_cd.value != "") {
				sqlStr += "		and   b.flet_ctrt_tp_cd like '"+formObject.flet_ctrt_tp_cd.value+"'||'%'                                                                                                                  ";
			}

			if (formObject.vsl_dznd_capa_fr.value != "") { 
				sqlStr += "		and   b.vsl_dznd_capa >= "+formObject.vsl_dznd_capa_fr.value+"                                                                                                                          ";
			}  

			if (formObject.vsl_dznd_capa_to.value != "") {
				sqlStr += "		and   b.vsl_dznd_capa <= "+formObject.vsl_dznd_capa_to.value+"                                                                                                                          ";
			}

			if (formObject.lane_cd.value != "") {  
				sqlStr += "		and   d.slan_cd like '"+formObject.lane_cd.value+"'||'%'                                                                                                                                  ";
			} 

			if (formObject.ownr_seq.value != "") {
				sqlStr += "		and   b.vndr_seq = e.vndr_seq                                                                                                                                                           ";
			}
			
			sqlStr += "			and	  a.vsl_cd like '"+formObject.vsl_cd.value+"'||'%'                                                                                                                                    "
					+ "			and   a.dck_sel_cd = 'E'                                                                                                                                                                "
					+ "			and   a.flet_dck_svey_tp_cd like '"+formObject.flet_dck_svey_tp_cd.value+"'||'%'                                                                                                          ";

			if (formObject.reflection_cd.value == "I") { 
				sqlStr += "		and a.phs_out_dt <= '"+formObject.to_duration.value+"'||'1231' and a.phs_in_dt >= '"+formObject.fr_duration.value+"'                                                           ";
			} else {
				sqlStr += "		and a.dck_fm_dt <= to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd') and a.dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd')            ";
			}

			sqlStr += "	group by a.vsl_cd,                                                                                                                                                                              "
					+ "			d.slan_cd,                                                                                                                                                                              "
					+ "			b.vsl_dznd_capa )                                                                                                                                                                       ";    

		return sqlStr;
		
	}

	/* 개발자 작업  끝 */