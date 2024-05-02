/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1001.js
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.20 백형인
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
     * @class ESD_SPE_1001 : ESD_SPE_1001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1001() {
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
    
	//공통전역변수
    var frm = null;
    var rhqXml = null;
    var ofcXml = null;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	

	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
//	 				if(validateForm(sheetObjects[0],frm,srcName)){
//	 				}
	 				break;
	 	

	 				
	 			case "btn_save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	 				break;
	 				
	 			case "btn_RowCopy":
	 				doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
	 				break;
	 				
	 			case "btn_RowAdd":
	 				var row = sheetObj.DataInsert(-1);
	 				sheetObj.InitCellProperty(row,"eg_ofc_cd",dtCombo)
	 				sheetObj.CellValue2(row, 'ev_svc_cate_cd')    = "";
	 				break;
	 				
	 			case "btn_RowDel":
	 				if(sheetObjects[0].FindCheckedRow("chk") == ""){

	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObjects[0], frm, IBDELETE);
	 				}
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	     // combo 생성
	     doActionIBCombo(frm.s_eg_rhq_cd); // Level1
	     doActionIBCombo(frm.s_ev_svc_cate_cd); // Level3
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }
         sheet1_OnLoadFinishLoad(sheetObjects[0])
         initControl() 
	}



    
 	function initControl() {
 		axon_event.addListener ('keydown', 'keydownEnter', 'form');
	}    
 	
 	 /**
 	  * HTML Control KeyDown 이벤트 호출
 	  */
	 function keydownEnter() {
	 	if (event.keyCode != 13) {
	 		return;
	 	}
	 	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
	 }
 	
 	
 	
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	comboObj.ValidChar(2,0);
    	comboObj.UseAutoComplete = true;    	
    	 switch(comboObj.id) {
   	  		case "s_eg_rhq_cd":
        		comboObj.DropHeight = 250;
  			break;  
   	  		case "s_eg_ofc_cd":
   	  			comboObj.DropHeight = 250;
   	  			break;  
   	  		case "s_ev_svc_cate_cd":
   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 350;
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

	 	switch(sheetNo) {
	    	case 1:      //sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(21);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|Seq.|Chk|EG ID|EG Name|Level1(RHQ)|Level2(Office)|CODE|Level3(Service Category)|Contract Office";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
					InitDataProperty(0,	cnt++,	dtCheckBox,     50,		daCenter,	false,	"chk");
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "eg_id",         	false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "eg_nm",            false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtCombo,        100,  	daCenter,   true,   "eg_rhq_cd",        true,     "",     dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "eg_ofc_cd",        true,     "",     dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,   "ev_svc_cate_code", false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtCombo,        170,  	daLeft,     true,   "ev_svc_cate_cd",   true,     "",     dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daCenter,   true,   "ctrt_ofc_cd",      true,     "",     dfNone,          0,          false,        true,   10);
//					InitDataValid(0, 9, vtEngUpOnly);
					
				}
				break;
	    	case 2:      //sheet2 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = 0;
	    		//전체 너비 설정
	    		SheetWidth = mainTable.clientWidth;
	    		
	    		//Host정보 설정[필수][HostIp, Port, PagePath]
	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    		
	    		//전체Merge 종류 [선택, Default msNone]
	    		MergeSheet = msHeaderOnly;
	    		
	    		//전체Edit 허용 여부 [선택, Default false]
	    		Editable = true;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(2, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag|";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
	    		InitDataProperty(0,	cnt++,	dtCheckBox,	    30,		daCenter,	false,	"chk");
	    		
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
	    		
	    	    }
	    		break;				

			}
		}	
	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
				sheetObj.ShowDebugMsg = false;
				if(validateForm(sheetObj,frm,sAction)){
					sheetObjects[0].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
//					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1001GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
//					ComOpenWait(false);
				}
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
            	frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		    		ComOpenWait(true);
            	
			        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1001GS.do", sParam);
					var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					if (State != "S") {
						ComShowCodeMessage('COM130103', 'Data');
						ComOpenWait(false);
						return false;
					} else if (State == "S") {
						ComShowCodeMessage('COM130102', 'Data');
						doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
					}
					
					ComOpenWait(false);
		    				
				break;
			case IBDELETE :
	   	   		if(sheetObj.FindCheckedRow("chk") != ""){
					ComRowHideDelete(sheetObj,"chk"); 
				}
			    break;			
			case "btn_downexcel":	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
			case IBCOPYROW:	// Copy Row
				if (sheetObj.RowCount == 0 || sheetObj.RowStatus(sheetObj.SelectRow)=="D") {
					ComShowCodeMessage("COM12113","Row");
					return false;
				}
				var Row = sheetObj.DataCopy();
				sheetObj.InitCellProperty(Row,"eg_ofc_cd",dtCombo);
				sheetObj.CellValue2(Row, 'eg_id')    = "";
				sheetObj.CellValue2(Row, 'eg_nm')    = "";
				sheetObj.CellValue2(Row, 'ev_svc_cate_cd')    = "";
				sheetObj.CellValue2(Row, 'ev_svc_cate_code')    = "";
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.WaitImageVisible = false;
        switch(comboObj.id) {
	    case "s_eg_rhq_cd":  
//	        frm.f_cmd.value = COMMAND01;
//
//	        rhqXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//	        frm.s_eg_rhq_cd.RemoveAll();
//	    	ComXml2ComboItem(rhqXml, frm.s_eg_rhq_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj); 
	    	comboObj.InsertItem(0, "", "");
//	    	frm.s_eg_rhq_cd.Code2=frm.eg_rhq_cd.value;
	    	doActionIBCombo(frm.s_eg_ofc_cd)
	    	break;  
	    case "s_eg_ofc_cd":  
	    	frm.f_cmd.value = COMMAND02;
	        // eg_rhq_cd 에 값이 있으면 GRID office 값이 변경이 된다.
	        frm.eg_rhq_cd.value = "";
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	comboObj.InsertItem(0, "", "");
//	    	frm.s_eg_ofc_cd.Index=0;
	    	break;  
	  	case "s_ev_svc_cate_cd":  
	  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd,sheetObj); 
	  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
        sheetObj.WaitImageVisible = true;
    }
    
    
    
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
//	 	 case IBSEARCH : 
//	 		 break;
	 	 case IBSAVE :
			if(sheetObj.RowCount<1){
				ComShowCodeMessage('COM130201', 'Grid'); //Grid 값을 입력하셔야 합니다
				return false;
			}
			
			// 그리드에 필수값 입력 했는지 체크
         	if(sheetObj.GetSaveString(false, true)==""){
        		return false;
        	}	 	
         	

			
			
	 		 break;	 		 
	 	 } // end switch()
	 	 return true;
	  }	 

      //업무 자바스크립트 OnKeyPress 이벤트 처리
      function keypressFormat() {
      	obj = event.srcElement;
    	    if(obj.dataformat == null) return;
    	    window.defaultStatus = obj.dataformat;
    	    switch(obj.dataformat) {
    	        case "engup":
    	        	ComKeyOnlyAlphabet('upper');
    	            break;
    	            
    	        case "number":
    	        	ComKeyOnlyNumber(obj);
    	            break;
    	    }
      }	  
	  
	  function s_eg_rhq_cd_OnChange(comboObj,Index_Code, Text){
		sheetObjects[0].RemoveAll();
		doActionIBCombo(frm.s_eg_ofc_cd); // RHQ
	  }
	  
	  function s_eg_ofc_cd_OnChange(comboObj,Index_Code, Text){
		  sheetObjects[0].RemoveAll();
	  }
	  function s_ev_svc_cate_cd_OnChange(comboObj,Index_Code, Text){
		  sheetObjects[0].RemoveAll();
	  }
	  
      /**
      * Sheet 로딩 후 이벤트 <br>
      * body 태그의 onLoadFinish 이벤트핸들러 구현 <br>
      * @param  sheetObj
      * @return 없음
      * @author 
      * @version 2013.03.21
      */ 	  
	  function sheet1_OnLoadFinishLoad(sheetObj){
		  // RHQ 생성
		  var rhqOfcCd = ComXml2ComboString(rhqXml,  "code_cd", "code_cd");
		  sheetObj.InitDataCombo(0, "eg_rhq_cd", " |" + rhqOfcCd[1], " |" + rhqOfcCd[0]);    // IBSheet내 Combo 초기화
		  
//		  // RHQ 따라 지역오피스 조회
//	      frm.f_cmd.value = COMMAND02;
//	      frm.eg_rhq_cd.value = rhqOfcCd[1].split("|")[0]; 
//	      var sXml = sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//	      var ofcCd = ComXml2ComboString(sXml,  "eg_ofc_cd", "eg_ofc_cd");
//	      sheetObj.InitDataCombo(0, "eg_ofc_cd", " |" + ofcCd[1], " |" + ofcCd[0]);    // IBSheet내 Combo 초기화
	      
	      
		  frm.f_cmd.value = SEARCH02;
		  // 공통 테이블에서 조회할 키
		  frm.code_key.value = "CD03377"
//		  sheetObj.WaitImageVisible = false;
		  var sXml = sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//		  sheetObj.WaitImageVisible = true;
		  var spCateCd = ComXml2ComboString(sXml,  "code_cd", "code_nm");
		  
		  
	      sheetObj.InitDataCombo(0, "ev_svc_cate_cd", "|"+spCateCd[1] , "|"+spCateCd[0], "", "", 1);    // IBSheet내 Combo 초기화
		  
	  }
	  
      /**
      * sheet1 OnChange 이벤트
      * @param {ibsheet} sheet 해당 시트   
      * @param {long} row 해당 셀의 Row Index
      * @param {long} col 해당 셀의 Column Index
      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      */
	  function sheet1_OnChange(sheetObj,Row, Col, Value) {
		  switch(Col){
		    case sheetObj.SaveNameCol("eg_rhq_cd") :
				  // RHQ 따라 지역오피스 조회
			      frm.f_cmd.value = COMMAND02;
			      frm.eg_rhq_cd.value = Value; 
			      var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			      var ofcCd = ComXml2ComboString(sXml,  "eg_ofc_cd", "eg_ofc_cd");
			      sheetObj.CellComboItem(Row, "eg_ofc_cd", "|" + ofcCd[1], "|" + ofcCd[0]);    // IBSheet내 Combo 초기화
			     break;
		    case sheetObj.SaveNameCol("ctrt_ofc_cd") : 
			    	ctrt_office_change(sheetObj,Row, Col, Value)
			     break;
		    case sheetObj.SaveNameCol("eg_rhq_cd") :		    
		    case sheetObj.SaveNameCol("eg_ofc_cd") :		    
		    case sheetObj.SaveNameCol("ev_svc_cate_cd") :	
		    	 
		    	if(sheetObj.CellValue(Row, "eg_rhq_cd") !="" && sheetObj.CellValue(Row, "eg_ofc_cd") !="" && sheetObj.CellValue(Row, "ev_svc_cate_cd") !=""  ){
		    		
		    		
		    		for(var i=0;i<sheetObj.RowCount;i++){
		    			if(i != Row && (sheetObj.CellValue(Row, "eg_rhq_cd") == sheetObj.CellValue(i, "eg_rhq_cd") && 
		    					        sheetObj.CellValue(Row, "eg_ofc_cd") == sheetObj.CellValue(i, "eg_ofc_cd") &&
		    					        sheetObj.CellValue(Row, "ev_svc_cate_cd") == sheetObj.CellValue(i, "ev_svc_cate_cd")    )){
		    				ComShowCodeMessage('COM12115','EG DATA');
 						    if(Col == sheetObj.SaveNameCol("eg_rhq_cd")){
							   sheetObj.CellValue2(Row,"eg_rhq_cd") = "";
							}else if(Col == sheetObj.SaveNameCol("eg_ofc_cd")){
							   sheetObj.CellValue2(Row,"eg_ofc_cd") = "";
							}else if(Col == sheetObj.SaveNameCol("ev_svc_cate_cd")){
							   sheetObj.CellValue2(Row,"ev_svc_cate_cd") = "";
							   sheetObj.CellValue2(Row,"ev_svc_cate_code") = "";
							}
 						    return;
		    			}
		    		}

		    		frm.f_cmd.value = SEARCH02;
		    		frm.g_eg_rhq_cd.value = sheetObj.CellValue(Row, "eg_rhq_cd") ;
		    		frm.g_eg_ofc_cd.value = sheetObj.CellValue(Row, "eg_ofc_cd") ;
		    		
		    		frm.g_ev_svc_cate_cd.value = sheetObj.CellValue(Row, "ev_svc_cate_cd") ;
		    		var sParam = FormQueryString(frm);
		    		var sXml = sheetObj.GetSearchXml("ESD_SPE_1001GS.do", sParam);
		    		var isflag = SpeXmlString(sXml,"isflag");
		    		
		    		// 등록된 데이터가 있으면 마지막으로 입력한 COL 을 초기화 한다.
		 		    if(isflag != 0){
		 		    	
					   ComShowCodeMessage('COM12115','EG DATA');
					   
					   if(Col == sheetObj.SaveNameCol("eg_rhq_cd")){
						   sheetObj.CellValue2(Row,"eg_rhq_cd") = "";
					   }else if(Col == sheetObj.SaveNameCol("eg_ofc_cd")){
						   sheetObj.CellValue2(Row,"eg_ofc_cd") = "";
					   }else if(Col == sheetObj.SaveNameCol("ev_svc_cate_cd")){
						   sheetObj.CellValue2(Row,"ev_svc_cate_cd") = "";
						   sheetObj.CellValue2(Row,"ev_svc_cate_code") = "";
					   }
				    }
		    		
		    	}
		    
		        if(sheetObj.SaveNameCol("ev_svc_cate_cd") == Col){
		    		sheetObj.CellValue2(Row,"ev_svc_cate_code") = Value;
		        }
		    	
		    	 break;
		    
			    		
		  }
	  }
	  
	  
		/**
	 	 * sheet1의 OnPopupClick Event 처리부분.<br>
	 	 * @param sheetObj
	 	 * @param Row
	 	 * @param Col
	 	 */
	    function sheet1_OnPopupClick(sheetObj,Row,Col) {
	 		with(sheetObj) {
				var sName = ColSaveName(Col);

				switch(sName) {
					case "ctrt_ofc_cd":		//Yard Code No Pop-up
						ComOpenPopup("/hanjin/COM_ENS_071.do", 770, 450, 'setESD_SPE_1001', '1,0,1,1,1',true); 
						break;
				}
	 		}
	    }
	    
	    function sheet1_OnClick(sheetObj, row, col, value) {
	         switch(sheetObj.ColSaveName(col)) {
		   	    case "eg_ofc_cd":  
		   	    	sheetObj.InitCellProperty(row,col,dtCombo)
  			        frm.f_cmd.value = COMMAND02;
		   	    	var rhqCd = sheetObj.CellValue(row,"eg_rhq_cd");
		   	    	if(rhqCd==""){
		   	    		return;
		   	    	}
				    frm.eg_rhq_cd.value = sheetObj.CellValue(row,"eg_rhq_cd"); 
				    var sXml = sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
				    var ofcCd = ComXml2ComboString(sXml,  "eg_ofc_cd", "eg_ofc_cd");
				    sheetObjects[0].CellComboItem(row, "eg_ofc_cd", "|" + ofcCd[1], "|" + ofcCd[0]);    // IBSheet내 Combo 초기화		
		   	    	break;  
	         }
	    }
	  
	 	/**
		 * COM_ENS_071 의 값을 받은 함수      
		 */
		function setESD_SPE_1001(aryPopupData){
	    	 var Row=sheetObjects[0].SelectRow;
			 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
				sheetObjects[0].CellValue(Row, "ctrt_ofc_cd") 		= aryPopupData[0][3];
			 }      
	    } 	 	    
	  
		/**
		* 사용자가 입력한 Control Office 코드가 존재하는 값인지 조회한다..
		*/
		function  ctrt_office_change(sheet, row, col ,value){
		   if(value ==""){
			   return;
		   }
		   frm.f_cmd.value = COMMAND03;
		   frm.s_ctrt_ofc_cd.value = value;
		   var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
		   var isflag = SpeXmlString(sXml,"isflag");
		   if(isflag==0){
			   ComShowCodeMessage('COM132202', 'Control Office'); //사용할수 없는 Control Office 
			   sheet.CellValue2(row,"ctrt_ofc_cd") = "";
		   }
		}		



		
	/* 개발자 작업  끝 */