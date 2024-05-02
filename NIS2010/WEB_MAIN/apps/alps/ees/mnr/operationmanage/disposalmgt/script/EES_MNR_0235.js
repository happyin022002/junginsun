/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0235.js 
*@FileTitle : MNR Release Order Transmission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.01.14 김완규
* 1.0 Creation  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * 
     * @author 한진해운  
     */ 
										
    /**
     * @extends  
     * @class EES_MNR_0235 : EES_MNR_0235 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0235() {
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

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];

		var rdObject = rdObjects[0];

		/*******************************************************/
		var formObject = document.form;

    	try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Print":
					printRd(rdObjects[0]);
					break;

				case "btn_DOCSend":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                	break;

				case "btn_Close":
					window.close();
                	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true);

    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	
    	// IBSheet초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
        // RD 초기화
		initRdConfig(rdObjects[0]);
		
		// 초기화설정
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        
		//Axon 이벤트 초기화
		initControl();
		
        MnrWaitControl(false);
    }
    
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); //- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); //- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	//- 키입력 할때
    }

  	/**
     * RD 초기설정값
     * @param	{RdObject}	rdObject	프로세스 처리될 RD오브젝트 
     */
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = true;
		Rdviewer.HideToolbar();
		Rdviewer.HideStatusBar();
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	   
	    switch(comboNo) {
	    	case 1: 
	            with (comboObj) { 
				       SetColAlign("left");         
					   DropHeight = 160;  
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
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    
					//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle = "|||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	"ibflag");
                   
					CountPosition = 0;
          		}
                break;
        }
    }

    /**
     * IBCombo Object를 배열로 등록
     * 
     * @param {IBCombo}
     *            combo_obj 배열로 등록될 IBCombo Object
     */
    function setComboObject(combo_obj) {
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "engup":
				ComKeyOnlyNumber(event.srcElement,"-,");
				break;
	    } 
	}
    
    /**
     * Transmission Type 콤보변경시 발생하는 이벤트
     * 콤보변경시 FAX, EMail 박스 를 번갈아 보여고, 값초기화 
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */
    function trsm_mod_cd_OnChange(comboObj,Index_Code, Text){
    	if(Index_Code=="F") {
			document.getElementById("iFax_no").style.display 		= "inline";
			document.getElementById("iMnr_prnr_eml").style.display	= "none";
    	} else if(Index_Code=="M") {
			document.getElementById("iFax_no").style.display 		= "none";
			document.getElementById("iMnr_prnr_eml").style.display 	= "inline";
    	}
    	document.form.fax_no.value 			= faxNo;
    	document.form.mnr_prnr_eml.value	= mnrPrnrEml;
    }
	
   /**
    * sheet1에서 SaveEnd이벤트를 처리한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 		   
			ComShowCodeMessage("MNR00321"); 
			window.close(); 
		} else { 
			ComShowCodeMessage("MNR00076",ErrMsg);
		}			       
	}

  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        	//초기화
			case IBCLEAR:
				//콤보 조회 
				var sCondition = new Array (
					new Array("MnrGenCd","CD00016", "COMMON")	//Transmission Type
				); 
				var comboList = MnrComSearchCombo(sheetObj,sCondition);   
				//콤보 설정        
				for(var i=0; i<comboList.length ; i++){
					if(comboList[i] != null){
						var rowCnt = 0;
						//Display[CODE_NAME]:Transmission Type 
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");
							if(tempText[0]=="F" || tempText[0]=="M") {
								comboObjects[i].InsertItem(rowCnt, tempText[1] ,tempText[0]);
								rowCnt++;
							}
						}
					}
				}
				//초기값 설정
				formObj.trsm_mod_cd.Code	= "F";  		//Transmission Type
				formObj.fax_no.value		= faxNo;		//FAX
				formObj.mnr_prnr_eml.value	= mnrPrnrEml;	//E-Mail
				//RD Display
				rdView(sheetObjects[0]);
	            break;

			//저장
			case IBSAVE:        
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					sheetObjects[0].DataInsert(-1); //저장이벤트 발생을 위한 
					sheetObj.DoSave("EES_MNR_0235GS.do", FormQueryString(formObj),-1,false); 
				}
				break;
        }
    }
		
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) { 	
				case IBSAVE: 
					var trsmModCd	= ComGetObjValue(formObj.trsm_mod_cd);
					var faxNo		= ComGetObjValue(formObj.fax_no);
					var mnrPrnrEml	= ComGetObjValue(formObj.mnr_prnr_eml);
					if(trsmModCd=="F" && (faxNo=="" || faxNo==null)) {
						ComShowCodeMessage("MNR00003");
						formObj.fax_no.focus();
						return false;
					} else if(trsmModCd=="M" && (mnrPrnrEml=="" || mnrPrnrEml==null)) {
						ComShowCodeMessage("MNR00003");
						formObj.mnr_prnr_eml.focus();
						return false;
					}
				 	break;	
			}		
        }
        return true;
    }

   /**
    * rd를 open한다
    * @param sheetObj
    * @param Row
    * @return
    */
	function rdView(sheetObj,Row) {
		var Rdviewer = rdObjects[0] ;
		var rdParam = '/rv disp_no['+ dispNo +'] user_nm['+ userNm +'] mnr_prnr_cnt_cd['+ mnrPrnrCntCd +'] mnr_prnr_seq['+mnrPrnrSeq+']';
		Rdviewer.FileOpen(RD_path+'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0184.mrd', RDServer + rdParam);
	}
  	/**
     * RD 인쇄 처리
     * @param	{RdObject}	rdObject	프로세스 처리될 RD오브젝트 
     */
	function printRd(rdObject){
	    var Rdviewer = rdObject ;
	    Rdviewer.PrintDialog (); //인쇄 대화상자 띄우고 인쇄
	}	