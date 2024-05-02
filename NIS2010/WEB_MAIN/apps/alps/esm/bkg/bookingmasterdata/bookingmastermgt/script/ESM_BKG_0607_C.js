/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0607.js
 *@FileTitle : Harmonized Tariff Code(HT Code 조회 화면)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.05.08 김기종
 * 1.0 Creation
 * 2012.01.18 박성호[CHM-201215711-01] BKG HS Code 최신화 작업
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
	 * @class esm_bkg_0607 : esm_bkg_0607 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_0607() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var iPage =1 ;
	var hdrGubun = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
	
			case "btn_DownExcel":
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
			
			case "btn_save":                                              
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);                                                       //save추가
				break;	
				
			case "btn_add":
				
				 var newRow = setDataInsert(sheetObject, 1);
				
				
			break;
				
			case "btn_del":                                                                                                   
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);												     //del 추가
				break;	
			
			case "btn_Print":
				//doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
	
			case "btn_confirm":
				comPopupOK();
				break;
				
			case "btn_confirm_6digit":
				
				chkCallPopupOK(sheetObjects[0]);
				break;
				
			case "btn_close":
				window.close();
				break;	
				
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
	function setSheetObject(sheet_obj) {
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		if (document.form.hamo_trf_cd.value !="" || document.form.hamo_cd_desc.value !="" ){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		
	
	
		
	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		var formObject = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
	    axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); //- 키보드 입력할때
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	/*
	    axon_event.addListener('keypress', 'eng_keypress', 'hamo_cd_desc');
	    axon_event.addListener('keypress', 'obj_keypress', 'hamo_trf_cd');
		*/
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetId = sheetObj.id;
	
		switch (sheetId) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 322;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 4999);
	
				var HeadTitle1 = "||Del|Seq.|HTS Code|Description|Category|FDA P/N|User ID|Office|Update Date";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				var prefix="sheet1_";
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				//InitDataProperty(0, cnt++, dtRadioCheck, 40, daCenter, false,
						//"radio", false, "", dfNone, 0, true, true);
				
				//InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false,
						//"check", false, "", dfNone, 0, true, true);
				
				
				
				//InitDataProperty(0, cnt++, dtRadioCheck, 40, daCenter, false,       
					//	"Sel", false, "", dfNone, 0, true, true);                ///////////////
				
				InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	 	false,  	prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtDelCheck,		30,		daCenter,		false,		prefix + "Sel", false, 	"",true );
				//InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,		false,		prefix + "Sel", false, 	"",true );
				InitDataProperty(0, cnt++, dtCombo, 30, daCenter, false,		prefix + "delt_flg",false,"",dfEngUpKey,0,true,true);//2. 추가 - DEL
				InitDataProperty(0, cnt++, dtSeq, 50, daCenter, false,		prefix + "Seq");
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		prefix + "hamo_trf_cd", false, "", dfNone, 0,false,true,10);
				InitDataProperty(0, cnt++, dtData, 350, daLeft, false,		prefix + "hamo_cd_desc", false, "", dfEngUpKey, 0, true);
				
				InitDataProperty(0, cnt++, dtData, 80, daLeft, false,		prefix + "hamo_cate_ctnt", false, "", dfNone, 0, true);
				InitDataProperty(0, cnt++ , dtCombo, 80, daCenter,true,    prefix + "fda_decl_flg", false,"", dfNone,0,true, true);
				//InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		prefix + "fda_decl_flg", false, "", dfEngUpKey, 0, true,true,1);
				
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false,		prefix + "upd_usr_id", false, "", dfNone, 0, false,false);   //3. 추가 - User id
				InitDataProperty(0, cnt++, dtData, 75, daCenter, false,		prefix + "ofc_cd", false, "", dfNone, 0, false,false); //4. 추가 - Office cd
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false,		prefix + "upd_dt", false, "", dfNone, 0, false,false); //5. 추가 - Update date
				
				
				
				InitDataCombo(0,	prefix + "fda_decl_flg",	"Y|N","Y|N");
				InitDataCombo(0,	prefix + "delt_flg",	"Y|N","Y|N");
				ColHidden("check") = true;
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				
			}
			break;
	
		}
		
	}
	 
	 function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
	        // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
	        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, PageNo);
	     } 

	 /**
	  * setDataInsert 호출 .<br>
	  * DELT FLG를 'N'으로셋팅 
	  * @param sheetObj, sNo
	  */
		function setDataInsert(sheetObj, sNo) {
			var formObj = document.form;
			// 기본셋트는 상황에 따라 어떻게 변경될지 몰라서 switch 문으로 동일하게 분리시킴
			switch (sNo) {

			case 1:
				var prefix="sheet1_";
				var nRow = sheetObj.DataInsert(-1); // 맨하위에 삽입
				
				sheetObj.CellValue(nRow, prefix + "delt_flg") = 'N';
			
				break;
			}
			return nRow;
		}

	
		
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
		case IBCLEAR: // 화면 로딩시 코드 조회
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0607GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], formObj.hamo_tp_cd, "val", "name|val");
			
			ComSetObjValue(formObj.hamo_tp_cd,ComGetObjValue(formObj.sel_hamo_tp_cd));
	
			break;
			
		case IBSEARCH: //조회
		
			if (validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_BKG_0607GS.do", FormQueryString(formObj)
						+ "&" + ComGetPrefixParam("sheet1_"));
			}		
	
			break;
			
		case IBSEARCHAPPEND:  // 페이징 조회
        
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch4Post("ESM_BKG_0607GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), "iPage=" + PageNo, true);
	    break; 
	    
		case IBSAVE:        //저장
			
			if(!validateForm(sheetObj,formObj,sAction)) {
				return;
			}//end if
        
	        formObj.f_cmd.value = MULTI;		        
	        sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
	        var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
		        sheetObj.DoSave("ESM_BKG_0607GS.do", sParam);

        
		break;
		
		case IBDELETE:      // 삭제	 		
		
        					
			ComRowHideDelete(sheetObj, "sheet1_Sel");
		    ComBtnEnable("btn_Save");
//			ComRowHideDelete(sheetObj,"Sel");
		break;
		
			
		case IBDOWNEXCEL:      // 입력
			sheetObj.SpeedDown2Excel(-1);
			break;	
		}	
 		ComOpenWait(false);
		
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			var color1 = RgbColor(204, 255, 253);
			ColBackColor("HJSCode") = color1;
			ColBackColor("MFCode") = color1;
		}
	}
	
	

	/**
	 * 팝업에서 check 선택시 부모창으로 값을 전달. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {String}
	 *            value sheetObj의 입력값
	 */
	function chkCallPopupOK(sheetObj) {
		var formObj = document.form;
		var calllFunc;
		var rArray = null; // 행데이터를 담고 있는 배열
		// 단일선택(Radio) 또는 다중선택(CheckBox) 일 때..
		rArray = chkGetLocalCheckedRows(sheetObj);
		
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		
		calllFunc = formObj.calllFunc.value;
		opener.eval(calllFunc)(rArray);
		window.close();
	}
	 

	
	function chkGetLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		
		var rArray = null; // 행데이터를 담고 있는 배열
		var cArray = null; // 열데이터를 담고 있는 배열
		
		checkRows = sheetObj.CheckedRows('radio');
		
		if(checkRows == 0) {  			
				return null;
			}
			else {
				var idx = 0;
	  		rArray = new Array(checkRows);
			for(var i = 0; i < rows; i++) {
				
				if(sheetObj.CellValue(i, "radio") == 1) {					
		  			cArray = null;
		  			// 특정 컬럼명이 지정된 경우
		  			if(colName != null && colName != "") {
		  				cArray = sheetObj.CellValue(i, colName);
		  			} else {
		  				cArray = new Array(colsCnt);
		  				
			  			for(var j=0; j<cArray.length; j++) {
			  				var iCol = sheetObj.SaveNameCol("hamo_trf_cd");
				        	if (j == iCol) {
				        		cArray[j] = (sheetObj.CellValue(i, j)).substr(0,6);
				        	}else{
				        		cArray[j] = sheetObj.CellValue(i, j);
				        	}
	                    }
	                } 
	                rArray[idx++] = cArray;
	     		}
	  		}
	  	}
	  	return rArray;
	}

	/**
	  * hamo_tp_cd Combo Change Event
     */
	 function hamo_tp_cd_OnChange(comboObj,value,text){
		 var formObj  = document.form;
		 var arrText = text.split("|");
		
		 if (arrText[0]=='HS'||arrText[0]=='HTS'){
			 cd_title.innerHTML = arrText[0];
			 hdrGubun = cd_title.innerHTML;
		 }else{
			 if (ComGetObjValue(formObj.sel_hamo_tp_cd)=="H"){
				 cd_title.innerHTML = "HS";
			 }
		 }
		 
		formObj.hamo_trf_cd.focus();
		 
		var	HeadTitle1 = "";
			
		if(hdrGubun == "HS"){
			HeadTitle1 = "||Del|Seq.|HS Code|Description|Category|FDA P/N|User ID|Office|Update Date";
		}else{
			HeadTitle1 = "||Del|Seq.|HTS Code|Description|Category|FDA P/N|User ID|Office|Update Date";
		}
		
		sheetObjects[0].InitHeadRow(0, HeadTitle1, true);
		 
	 }
	 /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		
		}
		return true;
	}
/* 개발자 작업  끝 */