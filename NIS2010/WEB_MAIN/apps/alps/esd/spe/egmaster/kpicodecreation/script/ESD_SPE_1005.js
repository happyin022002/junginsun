/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1005.js
*@FileTitle : KPI Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.22 백형인
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
     * @class ESD_SPE_1005 : ESD_SPE_1005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1005() {
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
	 				
	 			case "btn_RowAdd":
	 				var row = sheetObj.DataInsert(-1);
	 				sheetObj.CellValue2(row, 'ev_svc_cate_cd')    = "";
	 				break;
	 				
	 			case "btn_RowDel":
	 				if(sheetObjects[0].FindCheckedRow("chk") == ""){

	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObjects[0], frm, IBDELETE);
	 				}
	 				break;
				case "btn_downexcel":	// EXCEL DOWNLOAD
//					sheetObj.SpeedDown2Excel(1);
					sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
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
	     doActionIBCombo(frm.s_ev_svc_cate_cd); // SVC Category
	     
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }
         sheet1_OnLoadFinishLoad(sheetObjects[0])
         initControl()
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
	  		case "s_ev_svc_cate_cd":
   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 300;
   	  			break;  
   	  	}
    	
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
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|Chk|CODE|SVC Category|KPI Code|KPI Name|Description|KPI Type|Creation Date|Create User|Update Date|Update User";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT,  POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtCheckBox,     50,		daCenter,	false,	"chk");
					InitDataProperty(0, cnt++ , dtCombo,        50,  	daCenter,   true,   "ev_svc_cate_code", false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtCombo,        150,  	daLeft,     true,   "ev_svc_cate_cd",   true,     "",      dfNone,          0,          false,        true,    10);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "sp_kpi_id",        false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "sp_kpi_nm",        true,     "",      dfNone,          0,          false,        true,    200);
					InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     false,  "sp_kpi_desc",      true,     "",      dfNone,          0,          false,        true,    500);
					InitDataProperty(0, cnt++ , dtCombo,        100,  	daLeft,     true,   "sp_kpi_tp_cd",     true,     "",      dfNone,          0,          false,        true,    10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "cre_dt",           false,    "",      dfDateYmd,       0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "cre_usr_id",       false,    "",      dfNone,          0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "upd_dt",           false,    "",      dfDateYmd,       0,          false,        false,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "upd_usr_id",       false,    "",      dfNone,          0,          false,        false,   10);
					
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
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1005GS.do", sParam);
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
            	
			        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1005GS.do", sParam);
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
//				sheetObj.SpeedDown2Excel(1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
        switch(comboObj.id) {
	  	case "s_ev_svc_cate_cd":  
		  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd,sheetObj); 
   		  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
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
         	if(sheetObj.GetSaveString(false, true)==""){
        		return false;
        	}	 		 
	 		 break;	 		 
	 	 } // end switch()
	 	 return true;
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
		  
			var sheetObjs = sheetObjects[1];
			
			frm.f_cmd.value = SEARCH02;
			// 공통 테이블에서 조회할 키
			frm.code_key.value = "CD03377";
			var svcCateSXml = sheetObjs.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
		    var svcCateCd = ComXml2ComboString(svcCateSXml,  "code_cd", "code_nm");
		    sheetObj.InitDataCombo(0, "ev_svc_cate_cd", "|" + svcCateCd[1], "|" + svcCateCd[0], "", "", 1 );    // IBSheet내 Combo 초기화
	      
	      
		    frm.f_cmd.value = SEARCH03;
		    // 공통 테이블에서 조회할 키
		    frm.code_key.value = "CD03370";
		    var spKpiTpCdXml = sheetObjs.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
		    var spKpiTpCd = ComXml2ComboString(spKpiTpCdXml,  "code_cd", "code_nm");
		    sheetObj.InitDataCombo(0, "sp_kpi_tp_cd", " |" + spKpiTpCd[1], " |" + spKpiTpCd[0]);    // IBSheet내 Combo 초기화
	      
		  
	  }

	  function s_ev_svc_cate_cd_OnChange(comboObj,Index_Code, Text){
			sheetObjects[0].RemoveAll();
	  }
	  

      /**
	      * sheet1 OnChange 이벤트
	      * @param {ibsheet} sheet 해당 시트   
	      * @param {long} row 해당 셀의 Row Index
	      * @param {long} col 해당 셀의 Column Index
	      * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	      */
		  function sheet1_OnChange(sheetObj,row, col, value) {
			  switch(col){
			    case sheetObj.SaveNameCol("ev_svc_cate_cd") :	
			    		sheetObj.CellValue2(row,"ev_svc_cate_code") = value;
			    	 break;
			    
				    		
			  }
		  }	  

	/* 개발자 작업  끝 */