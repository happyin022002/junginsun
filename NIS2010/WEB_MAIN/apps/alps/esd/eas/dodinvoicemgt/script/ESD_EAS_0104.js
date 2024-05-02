/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0104.js
*@FileTitle : (KOR) DOD Collection List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10
* 1.0 최초 생성 
* 2015.08.24 [CHM-201537151] 조직코드변경작업
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
     * @class ESD_EAS_0104 : ESD_EAS_0100 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0104() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
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
	//RD
    var rdObjects = new Array();
	var rdCnt = 0;
	
	//Action 정의
	var IBSEARCH_ATTL 			= 108;
	
	//업무전역변수
	var ROWMARK 				= "|";
	var FIELDMARK 				= "=";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0]; //sheet1
         var sheetObject2 = sheetObjects[1]; //sheet2
		 var rdObject = rdObjects[0];

         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1, formObject, IBSEARCH, true);   //tab1
						break;

					case "btn_new":
						sheetObject1.RemoveAll();
						formObject.reset();
						ComBtnDisable("btn_print");
						ComBtnDisable("btn_DownExcel");
						break;
						
					case "btn_print":
						//rdObject.PrintDialog();
						rdOpen(rdObject, formObject);
						break;								
						
					case "btn_DownExcel":
						doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
						break;
						
		            case "btn_Calendar": //달력버튼
			            var cal = new ComCalendarFromTo();
			            cal.select(formObject.fm_ar_if_dt, formObject.to_ar_if_dt, 'yyyy-MM-dd');
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
     * IBSheet Object 를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
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
        
        for(var k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],comboObjects[k].id);
	    }

		initControl();
		//RD
		initRdConfig(rdObjects[0]);
		ComBtnDisable("btn_print");
		ComBtnDisable("btn_DownExcel");  
		var formObj = document.form;
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
//	function initCombo(comboObj, comboNo) {
//		var i=0;
//	}

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
        	case "sheet1":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					//var HeadTitle1 = "Flag|Seq|DATE|INV NO.|B/L NO.|CNTR NO.|T/S|D.O.LOC|BIL AMT|TAX AMT|POR|POL|POD|DEL|CNEE|NTFY|PAYER";
					var HeadTitle1 = "Flag|Seq|DATE|INV NO.|B/L NO.|CNTR NO.|T/S|INV OFC|D.O.LOC|BIL AMT|ADD AMT|TOT AMT|TAX AMT|POR|POL|POD|DEL|CNEE|NTFY|PAYER";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(false, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,	 daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++, dtSeq,			35,	 daCenter,	true,	"seq",		    false,	"",	dfNone,	   0, false, false);
					InitDataProperty(0, cnt++, dtData,     	    65,  daCenter,  true,  	"ar_if_dt",     false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        80, daCenter,  true,	"dod_inv_no",   false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        90, daCenter,  true,	"bl_no",        false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        90, daCenter,  true,	"cntr_no",      false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        45,  daCenter,  true,	"cntr_tpsz_cd", false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        55,  daCenter,  true,	"cre_ofc_cd",   false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        55,  daCenter,  true,	"dod_loc_cd",   false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        65,  daCenter,  true,	"bil_amt",      false,  "", dfInteger, 3, false, false);
					InitDataProperty(0, cnt++, dtData,	        65,  daCenter,  true,	"add_amt",      false,  "", dfInteger, 3, false, false);
					InitDataProperty(0, cnt++, dtHidden,	    65,  daCenter,  true,	"tot_bil_amt",  false,  "", dfInteger, 3, false, false);
					InitDataProperty(0, cnt++, dtData,	        65,  daCenter,  true,	"tax_amt",      false,  "", dfInteger, 3, false, false);
					InitDataProperty(0, cnt++, dtData,	        55,  daCenter,  true,	"por_cd",       false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        55,  daCenter,  true,	"pol_cd",       false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        55,  daCenter,  true,	"pod_cd",       false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        55,  daCenter,  true,	"del_cd",       false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        65,  daLeft,    true,	"cnee",         false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        65,  daLeft,    true,	"nfty",         false,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtData,	        65,  daLeft,    true,	"payer",        false,  "", dfNone,    0, false, false);

					
				}
				break;
        }
    }

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		
		var rowCnt = sheetObj.RowCount;

		if (rowCnt == 0) {
			ComBtnDisable("btn_print");
			ComBtnDisable("btn_DownExcel");
		}else {
		   ComBtnEnable("btn_print");
		   ComBtnEnable("btn_DownExcel");
		}
	}
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, msgFlg) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					sheetObjects[0].RemoveAll();
					sheetObjects[0].RemoveEtcData();  

					formObj.f_cmd.value = SEARCH;
					var inv_ofc_cd	= ComGetObjValue(formObj.inv_ofc_cd);
					ComSetObjValue(formObj.cre_ofc_cd, inv_ofc_cd);					
		        	var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0104GS.do", sParam);
					var arrXml = sXml.split("|$$|");
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					ComEtcDataToForm(formObj,sheetObjects[0]);
					ComSetObjValue(formObj.sum_bil_amt, ComAddCommaRun(formObj.sum_bil_amt.value));
					ComSetObjValue(formObj.sum_tax_amt, ComAddCommaRun(formObj.sum_tax_amt.value));
					ComSetObjValue(formObj.tot_amt, ComAddCommaRun(formObj.tot_amt.value));
				}	
				break;
			case IBDOWNEXCEL:		// 엑셀 다운로드
				ComOpenWait(true);
				sheetObj.Down2Excel(-1, false, false, true);
				ComOpenWait(false);
				break;	
				
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, msgFlg){
//		var cboAttention = comboObjects[0];
		switch (sAction) {
			case IBSEARCH:
        		if( ComIsEmpty(formObj.fm_ar_if_dt) ||  ComIsEmpty(formObj.to_ar_if_dt) )
        		{
        			ComShowCodeMessage("COM130201", "A/R I/F DATE");
        			ComAlertFocus(formObj.fm_ar_if_dt, "");
        			return false;
        		}
				break;

 				

		}
        return true;
    }
		
    /* initControl() */
    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
    	axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
    	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat("change", "frmObj_OnChange", formObj);
	    axon_event.addListener('keydown', 'frmObj_EnterKey', 'form');
    }

    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engup":
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
			case "engup2":
				ComKeyOnlyAlphabet('upper');
				break;				
     	}
    }    

    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
		var formObj = document.form;
        var elementName = window.event.srcElement.getAttribute("name");
//        var sheetObj = sheetObjects[1];
        with (document.form) {
            switch (elementName) {
//                case "payer_cd":
//					getPayerInfo();
//                    break;
//				case "pol_cd":
//				alert('pol_cd');
//				break;
//				case "conti_cd":
//					alert('conti_cd');
//				break;            
            }
        }
    }
	
    /**
     * Form Element의 EnterKey 이벤트
     */
    function frmObj_EnterKey() {
		if (13!=event.keyCode) return;
		var formObj = document.form;
        var elementName = window.event.srcElement.getAttribute("name");
        var sheetObj = sheetObjects[0];
		var sheetObj1 = sheetObjects[1];
        with (document.form) {
            switch (elementName) {
                case "to_ar_if_dt":
					if(ComIsBtnEnable("btn_retrieve")){
						doActionIBSheet(sheetObj, formObj, IBSEARCH, true);	
					}
                    break;
            }
        }
    }
	
	
	//입력 값 활성화 처리
	function object_enable(){
		var formObj = document.form;
		//payer
//		ComEnableObject(formObj.payer_cd, true);
//		ComEnableObject(formObj.btn_payer_cd, true);
//		formObj.payer_cd.className	= "input1";
//		
//		formObj.cboAttention.Enable = true;				
	}
	//입력 값 비활성화 처리
	function object_disable(){
		var formObj = document.form;
		//payer
//		ComEnableObject(formObj.payer_cd, false);
//		ComEnableObject(formObj.btn_payer_cd, false);
//		formObj.payer_cd.className 	= "input2";

//		formObj.cboAttention.Enable = false;
	}

 
 	
	/** 
	 * RD 초기설정값<br>
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
		
 	/** 
	 * Rd 오픈 <br>
	 */

	function rdOpen(rdObject, formObj){
		var Rdviewer = rdObject;	
		//review 창 오픈
		ComSetObjValue(formObj.com_mrdPath, ComGetObjValue(formObj.mrd));
		var rdParm = "/rv fm_ar_if_dt[" + ComGetObjValue(formObj.fm_ar_if_dt)
		             + "] to_ar_if_dt["+ ComGetObjValue(formObj.to_ar_if_dt) 
		             + "] f_do_loc["+ ComGetObjValue(formObj.do_loc)
		             + "] f_por_cd["+ ComGetObjValue(formObj.por_cd)
		             + "] f_pol_cd["+ ComGetObjValue(formObj.pol_cd)
		             + "] f_pod_cd["+ ComGetObjValue(formObj.pod_cd)
		             + "] f_del_cd["+ ComGetObjValue(formObj.del_cd)
		             + "] f_conti_cd["+ ComGetObjValue(formObj.conti_cd)
		             + "]";
		ComSetObjValue(formObj.com_mrdArguments, rdParm);
		var feature = "resizable=yes,width=1000,height=650";
		ComOpenRDPopup(feature);
	}
	
	function obj_activate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "fm_ar_if_dt":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			case "to_ar_if_dt":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
		}
	}	
	
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "fm_ar_if_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_ar_if_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
//			case "pol_cd":
//				alert('pol_cd');
//			break;
//			case "conti_cd":
//				alert('conti_cd');
//			break;
		}
	}

	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "fm_ar_if_dt":
				var fromCreDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromCreDt.length == 8) {
					formObject.to_ar_if_dt.focus();
				}
	 		break;

			}
	}
	
	function pointAutoMove(val) {
		if ( val.length == 8  ) {
			document.form.to_ar_if_dt.focus();
		}
	}

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboId) {

	   var formObject = document.form
	   
	   with (comboObj) { 
		   if(comboId=="do_loc"){
			   
			   MultiSelect = true;
			   
			   comboObj.InsertItem(0, "ALL", "A");
			   comboObj.InsertItem(1, "KREIW", "KREIW");
			   comboObj.InsertItem(2, "KRPTK", "KRPTK");
			   comboObj.InsertItem(3, "KRINC", "KRINC");
			   comboObj.InsertItem(4, "KRKAN", "KRKAN");
			   comboObj.index = 0;
	   }else if(comboId=="inv_ofc_cd"){
			   
//			   MultiSelect = true;
			   
			   comboObj.InsertItem(0, "ALL", "A");
			   comboObj.InsertItem(1, "INCKS", "INCKS"); // INCBO
			   comboObj.InsertItem(2, "KANKS", "KANKS"); // KANBO 
			   comboObj.InsertItem(3, "PUSSC", "PUSSC"); 
//			   comboObj.index = 0; 
			   if(ComGetObjValue(formObject.cre_ofc_cd)=="INCKS"){ //INCBO
				   comboObj.index = 1;
			   }else if(ComGetObjValue(formObject.cre_ofc_cd)=="KANKS"){
				   comboObj.index = 2;
			   }else if(ComGetObjValue(formObject.cre_ofc_cd)=="PUSSC"){
				   comboObj.index = 3;
			   }else {
			       comboObj.index = 0;
			   }

		   }	

	   }
	           

	}     

	/**
	 * rgnCdCombo의 MultiSelection OnCheckClick 이벤트 처리
	 */
	function do_loc_OnCheckClick(comboObj, index, code) {
	    var doLoc = document.form.dod_loc_cd;
	    // 선택된 Index가 없을 경우는 0번 Index 강제 선택
	    if (comboObj.Text == null || comboObj.Text == "") {
	        comboObj.CheckIndex(0) = true;

	    } else {
	        // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
	        if (index == 0) {
	            for(var i=1; i<comboObj.GetCount(); i++) {
	                comboObj.CheckIndex(i) = false;
	            }
	            doLoc.value = "";

	        // 다른Index가 선택된 경우는 Index 0을 해제
	        } else {
	            comboObj.CheckIndex(0) = false;
	            doLoc.value = "'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'";
	        }
	    }
	}
	
	/* 개발자 작업  끝 */ 