/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1157.js
*@FileTitle : T/S Booking Closing Bayplan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.18 나상보
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
     * @class esm_bkg_1157 : esm_bkg_1157 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1157() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
//    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
//    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
    		var srcName = window.event.srcElement.getAttribute("name");
           
			switch(srcName) {				 
				case "btn_Retrieve": 
					doActionIBSheet(sheetObject,document.form,IBSEARCH);
					break;

				case "btn_Booking_Close":    
				    if(sheetObject.CheckedRows(prefix1+"del_chk")<1){ 
						ComShowCodeMessage("BKG00155");
//				    }else if(sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_ofc_cd").toUpperCase().indexOf(formObject.userOfc_cd.value.toUpperCase())<0){
//						ComShowCodeMessage("BKG00875");
					}else if(sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("C".toUpperCase())>-1){
						ComShowCodeMessage("BKG00233");
					}else{
						formObject.f_cmd.value = MULTI01; 
						doActionIBSheet(sheetObject,document.form,MULTI01); 
					} 
				    doActionIBSheet(sheetObject,document.form,IBSEARCH);
					break;
				
				case "btn_Re_Open": 
				    if(sheetObject.CheckedRows(prefix1+"del_chk")<1){  
						ComShowCodeMessage("BKG00155");
//				    }else if(sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_ofc_cd").toUpperCase().indexOf(formObject.userOfc_cd.value.toUpperCase())<0){
//						ComShowCodeMessage("BKG00875"); 
					}else if(sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("R".toUpperCase())>-1
						  || sheetObject.CellValue(sheetObject.SelectRow,prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("O".toUpperCase())>-1){
						ComShowCodeMessage("BKG00233"); 
					}else{ 
						formObject.f_cmd.value = MULTI02; 
						doActionIBSheet(sheetObject,document.form,MULTI01); 
					}
				    doActionIBSheet(sheetObject,document.form,IBSEARCH);
					break;
					
				case "btn_Excel":
					if(sheetObject.RowCount>0){
						doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
					}else{
						ComShowCodeMessage("BKG00155");
					}
					break; 
				case "btn_Close":
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

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(flag) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
			if (flag){
				doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
			}            
        }

		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress', 'bkg1157_keypress',formObject);
//		axon_event.addListener('keyup', 'pol_cd_keyup', 'pol_cd');
    	axon_event.addListenerForm  ("change", 			"form_onChange", 		formObject);

		ComSetFocus(document.form.vsl_cd);
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
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "|Sel.|VVD|POL|POL|Calling seq.|Booking Office|Status|Office|User ID|Date";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(16, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++ , dtHiddenStatus,	60,			daCenter,	true,	prefix1+"ibflag");
					InitDataProperty(0, 	cnt++ , dtRadioCheck,	30,			daCenter,	false,	prefix1+"del_chk",			false,		"",     dfNone,		0,		true,		true);
					InitDataProperty(0,		cnt++ , dtData,	    	120,		daCenter,	false,	prefix1+"vvd",				false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,			60,			daCenter,	false,	prefix1+"pol_cd",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,			70,			daCenter,	false,	prefix1+"yd_cd",			false,		"",		dfNone,		0,		false,		true);
					
					InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,	false,	prefix1+"clpt_ind_seq",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,	false,	prefix1+"bkg_ofc_cd",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,	false,	prefix1+"bkg_clz_sts_nm",	false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,	false,	prefix1+"ofc_cd",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,	false,	prefix1+"upd_usr_id",		false,		"",		dfNone,		0,		false,		true);
					
					InitDataProperty(0,		cnt++ , dtData,			100,		daCenter,	false,	prefix1+"upd_dt",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtHidden,		100,		daCenter,	false,	prefix1+"usr_nm",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtHidden,		100,		daCenter,	false,	prefix1+"vsl_cd",			false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtHidden,		100,		daCenter,	false,	prefix1+"skd_voy_no",		false,		"",		dfNone,		0,		false,		true);
					InitDataProperty(0,		cnt++ , dtHidden,		100,		daCenter,	false,	prefix1+"skd_dir_cd",		false,		"",		dfNone,		0,		false,		true);
					
					InitDataProperty(0,		cnt++ , dtHidden,		100,		daCenter,	false,	prefix1+"bkg_clz_sts_cd",	false,		"",		dfNone,		0,		true,		true);
				}
				break;
		}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) { 
		var arrPreFix = new Array("sheet1_");
        sheetObj.ShowDebugMsg = false;	  
        switch(sAction) {
          	case IBSEARCH:      //조회
			  	if (ComChkLen(ComTrim(formObj.vsl_cd),9)!=2 ||ComChkLen(ComTrim(formObj.pol_cd),5)!=2){
			  		ComShowCodeMessage("BKG00213");
			  		return false;
			  	}
	          	formObj.f_cmd.value = SEARCH; 
	          	var sXml = sheetObj.GetSearchXml("ESM_BKG_1157GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
	          	var arrXml = sXml.split("|$$|");
				
	          	for(var i = 0; i < arrXml.length; i++){ 
					sheetObjects[i].Redraw = false;    
					if(i > 0) {
						sheetObjects[i].WaitImageVisible = false;	
					}  
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
					sheetObjects[i].Redraw = true; 
				}	
				ComSetFocus(formObj.vsl_cd);
				break;
          	case MULTI01:        //sheet1 저장  
				if (sheetObj.CellValue(sheetObj.SelectRow,prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("O".toUpperCase())>-1) {
					sheetObj.CellValue(sheetObj.SelectRow,prefix1+"ibflag") ="I";
				}else{
					sheetObj.CellValue(sheetObj.SelectRow,prefix1+"ibflag") ="U";
				}
				
				if (formObj.f_cmd.value==MULTI01){
					sheetObj.CellValue(sheetObj.SelectRow,prefix1+"bkg_clz_sts_nm") = "Closed";
					sheetObj.CellValue(sheetObj.SelectRow,prefix1+"bkg_clz_sts_cd") = "C";
				}else{ 
					sheetObj.CellValue(sheetObj.SelectRow,prefix1+"bkg_clz_sts_nm") = "Re-open";
					sheetObj.CellValue(sheetObj.SelectRow,prefix1+"bkg_clz_sts_cd") = "R";
				}
                sheetObj.CellValue(sheetObj.SelectRow,prefix1+"ofc_cd") = formObj.userOfc_cd.value;
				sheetObj.CellValue(sheetObj.SelectRow,prefix1+"upd_usr_id") = formObj.user_id.value;
				sheetObj.CellValue(sheetObj.SelectRow,prefix1+"upd_dt") = ComGetNowInfo();

				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return; 
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1157GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
                break;

          	case IBDOWNEXCEL:      // 엑셀다운 
			    sheetObj.SpeedDown2Excel(-1);
				break; 
        } 
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
//        }

//        return true;
//    }
	
	/*
	* 대문자 변환
	*/
	function bkg1157_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) { 
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum');
	            break; 
	    }

//		var btnObj=null;
//		
//		switch(obj.name){  
//			case "pol_cd": 
//				if(ComIsEmpty(obj.value)) { 
//					return; 
//				}
//				if(event.keyCode == 13){
//					btnObj = document.getElementById("btn_retrieve");
//					if (btnObj) { 
//						btnObj.fireEvent("onclick"); 
//					}
//				}
//				break;
//			 case "yd_cd": 	  
//				if(event.keyCode == 13){
//					
//					btnObj = document.getElementById("btn_retrieve");
//					if (btnObj) { 
//						btnObj.fireEvent("onclick");
//					}
//				}
//				break;
//		}
	}
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;
   		
   		if ( vKeyCode == 13 ) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
   		}

   	}
    
	/*
	* Booking Office 조회
	*/
	function form_onChange(){ 
	  	var srcName = window.event.srcElement.getAttribute("name");
	  	var srcValue = window.event.srcElement.getAttribute("value");
		var formObject = document.form; 
	
	 	if(srcName == "pol_cd"||srcName=='vsl_cd'){
			if (ComChkLen(ComTrim(formObject.vsl_cd),9)!=2){
				ComShowCodeMessage("BKG00213");
				ComSetFocus(formObject.vsl_cd);
			}
	 	}
	}
    
	/*
	* 콤보박스 초기화
	*/
	function clearComboList(objCbo){
		var option = objCbo.getElementsByTagName("option");
	  	for(var i=option.length-1; i>-1 ; i--) {
	  		option[i].parentNode.removeChild(option[i]);
	  	}  
	}
	
	/*
	* ToolTip
	*/
	function sheet1_OnMouseMove(sheet1,Button, Shift, X, Y){  
		if (sheet1.MouseCol==sheet1.SaveNameCol(prefix1+"upd_usr_id")){
			sheet1.MousePointer = "Hand";
			sheet1.MouseToolTipText =sheet1.CellText(sheet1.MouseRow,prefix1+"usr_nm");
			//sheet1.ToolTipText(sheet1.MouseRow,prefix1+"upd_usr_id")=sheet1.CellText(sheet1.MouseRow,prefix1+"usr_nm");
		}else{
			sheet1.MousePointer = "Default";
			if (sheet1.MouseToolTipText != ""){ 
				sheet1.MouseToolTipText = "";
			} 
		}
	}

	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		for(i=1;i<sheetObj.Rows;i++){
//			if (sheetObj.CellValue(i,prefix1+"bkg_clz_sts_cd")=="O"
//			    || sheetObj.CellValue(i,prefix1+"bkg_clz_sts_cd")=="M"){
//				//
//			}
			sheetObj.CellFontColor(i, prefix1+"bkg_clz_sts_nm") =sheetObj.RgbColor(0, 0,255);
		}
	}

	/* 개발자 작업  끝 */