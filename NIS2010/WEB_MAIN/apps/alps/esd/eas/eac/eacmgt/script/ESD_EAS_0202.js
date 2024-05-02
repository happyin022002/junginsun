/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0202.js
*@FileTitle : Contact point config
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
     * @class ESD_EAS_0202 : ESD_EAS_0202 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0202() {
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
	var usdRt ="";  // 환율
	var chkFlag = ""; //sheet1 의 chk 컬럼 선택여부
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	
	// offce_level 설정
	// 1 : 본부, 2:RQH, 3: 기타
	var ofcLevel="";
	
	    
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
	 	var sheetObj1    = sheetObjects[1];

	 	/*******************************************************/
	 
	 	var change = 0;

	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				frm.g_vndr_seq.value="";
	 				chkFlag = "";
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
//	 				if(validateForm(sheetObjects[0],frm,srcName)){
//	 				}
	 				break;
	 	

	 				
	 			case "btn_save":
 					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
	 				break;
	 				
	 			case "btn_RowAdd":
	 				if(sheetObj.RowCount<1 || chkFlag == "") return;
	 				sheetObj1.DataInsert(-1);
	 				break;
	 				
	 			case "btn_RowDel":
	 				if(sheetObj.RowCount<1) return;
	 				if(sheetObj1.FindCheckedRow("chk") == ""){
	 					ComShowCodeMessage("EAS90073");
	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObj1, frm, IBDELETE);
	 				}
	 				break;
	 				
	 			case "btn_downexcel":
	 				doActionIBSheet(sheetObjects[1],frm,"btn_downexcel","","");
	 				break;
	     		case "btn_vndr_seq":
	     			rep_OnPopupClick();
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
	    
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }        
	    initControl();
   
	}



    
 	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
//      axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
		axon_event.addListenerFormat('keypress', 'keypressFormat', document.form);
//		axon_event.addListener('keydown', 'ComKeyEnter', 'form');  //jsp name 옆에 id 추가 예)name="btn_retrieve" id="btn_Retrieve"
//		axon_event.addListenerForm( 'beforedeactivate', 'obj_deactivate',frm  );
	}    
 	
 	
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	
    	 switch(comboObj.id) {
   	  		case "contact_point_exists":  
   	  		        comboObj.InsertItem(0, "", "");	  
   	  			    comboObj.InsertItem(1, "Y", "Y");
   	  		    	comboObj.InsertItem(2, "N", "N");
   	  		    	comboObj.Index=0;
  			break;  
   	  	}
    	
    }	
    
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
		case "s_vndr_seq":
			vender_change();
			break;
		
		}
	} 	 	
	
  /**
   * S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
   */
   function  vender_change(){

	   if(frm.s_vndr_seq.value==""){
		   frm.s_vndr_nm.value="";
		   return;
	   }
	   frm.f_cmd.value = SEARCH05;
	   	var sXml=sheetObjects[2].GetSearchXml("ESD_EAS_0201GS.do", FormQueryString(frm));
	   	var vndrNm = EasXmlString(sXml,"vndr_nm");
	   	if(vndrNm==0){
	   		ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code
	   		frm.s_vndr_nm.value="";
	   		return;
	   	}
	   	frm.s_vndr_nm.value = vndrNm; 

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
					style.height = GetSheetHeight(8);
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
					InitColumnInfo(11, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|Seq.||S/P Code|S/P Name|ZIP Code|Address|State|TEL|FAX|E-mail";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
					InitDataProperty(0,	cnt++,	dtRadioCheck,   30,		daCenter,	false,	"chk");
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,   "vndr_seq",         	false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         170,  	daLeft,     true,   "vndr_lgl_eng_nm",      false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         80,  	daLeft,     true,   "zip_cd",               false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         170,  	daLeft,     true,   "eng_addr",         	false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "ste_cd",         	    false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "phn_no",         	    false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "fax_no",         	    false,    "",      dfNone,          0,          false,        true,   10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "vndr_eml",         	false,    "",      dfNone,          0,          false,        true,   10);
					
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
					
				}
				break;
	    	case 2:      //sheet2 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = GetSheetHeight(9);
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
	    		InitColumnInfo(14, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag||Name|Job Title|Job Description|Phone|Fax|Fax send|E-mail|E-mail send|Creation User|Creation Date|VENDOR CONTACT POINT SEQUENCE";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
	    		InitDataProperty(0,	cnt++,	dtCheckBox,	    30,		daCenter,	false,	"chk");
	    		InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "vndr_cntc_pnt_nm",       true,    "",      dfNone,          0,          true,        true,   100);
	    		InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "psn_nm",                 false,    "",      dfNone,          0,          true,        true,   100);
	    		InitDataProperty(0, cnt++ , dtData,         120,  	daLeft,     true,   "psn_desc",               false,    "",      dfNone,          0,          true,        true,   1000);
	    		InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "phn_no",         	      false,    "",      dfNone,          0,          true,        true,   20);
	    		InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "fax_no",         		  false,    "",      dfNone,          0,          true,        true,   20);
	    		InitDataProperty(0, cnt++ , dtCheckBox,     100,  	daLeft,     true,   "eac_fax_use_flg",        false,    "",      dfNone,          0,          true,        true,   10);
	    		InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "vndr_eml",         	  false,    "",      dfNone,          0,          true,        true,   200);
	    		InitDataProperty(0, cnt++ , dtCheckBox,     100,  	daLeft,     true,   "eac_eml_use_flg",        false,    "",      dfNone,          0,          true,        true,   10);
	    		InitDataProperty(0, cnt++ , dtData,         150,  	daLeft,     true,   "cre_usr_nm",         	  false,    "",      dfNone,          0,          false,       false,  10);
	    		InitDataProperty(0, cnt++ , dtData,         100,  	daLeft,     true,   "cre_dt",         	      false,    "",      dfNone,          0,          false,       false,  10);
	    		InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "vndr_cntc_pnt_seq",      false,    "",      dfNone,          0,          false,       false,  10);
	    		InitDataProperty(0, cnt++ , dtHidden,       100,  	daLeft,     true,   "vndr_seq",               false,    "",      dfNone,          0,          false,       false,  10);
	    		
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
	    		
	    		}
	    		break;
	    	case 3:      //sheet2 init
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
					sheetObjects[1].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
//					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0202GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
//					ComOpenWait(false);
				}
				break;
			case "IBSEARCH02":
//				if(validateForm(sheetObj,frm,sAction)){
				sheetObj.RemoveAll();
				frm.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(frm);
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0202GS.do", sParam);
				sheetObj.loadSearchXml(sXml);
//				}
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;

				
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
            	
				
	 			for(var i=0;i<=sheetObj.RowCount;i++){
	 				if(sheetObj.RowStatus(i)!="R"){
	 					sheetObj.CellValue2(i,"vndr_seq") =frm.g_vndr_seq.value;
	 				}
	 			}
	 			
//				var sParam = ComGetSaveString(sheetObj);
//				var sParam = "";
            	frm.f_cmd.value = MULTI01;
            	if(sheetObj.GetSaveString(false, true)==""){
            		return;
            	}
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		    		ComOpenWait(true);
            	
			        var sXml = sheetObjects[2].GetSaveXml("ESD_EAS_0202GS.do", sParam);

			        
					var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					if (State != "S") {
						ComShowCodeMessage('COM130103', 'Data');
						ComOpenWait(false);
						return false;
					} else if (State == "S") {
						ComShowCodeMessage('COM130102', 'Data');
					}
					ComOpenWait(false);
					doActionIBSheet(sheetObjects[1], frm, "IBSEARCH02");
		    				
				break;
			case IBDELETE :
				if (sheetObj.id == 'sheet2') {  
		   	   		if(sheetObj.FindCheckedRow("chk") != ""){
						ComRowHideDelete(sheetObj,"chk"); 
					}
				}
			    break;		
			case "btn_downexcel":	// EXCEL DOWNLOAD
//				sheetObj.SpeedDown2Excel(1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
		}
	}


	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case IBSEARCH : 
	 		 if(frm.s_cnt_cd.value == "" && frm.s_ofc_cd.value == "" && frm.s_vndr_seq.value == ""){
	 			ComShowCodeMessage('COM130201', 'Country or Control Office or S/P Code'); // Country or Control Office or S/P Code 에 값을 입력하셔야 합니다;
	 			 return false;
	 		 }
	 		 break;
	 	 case IBSAVE :
	 		 if(chkFlag!="1"){
	 			 ComShowCodeMessage('COM12113', 'MDM S/P Information Grid'); //MDM S/P Information Grid 에 선택하세요
	 			 return false;
	 		 }
	 		 
	 		 if(sheetObj.RowCount<1){
	 			ComShowCodeMessage('COM130201', 'Contact point Grid'); // Grid에 값을 입력하셔야 합니다;
	 			return false;
	 		 }
	 		 
	 		 
	 		 for(var i=1;i<=sheetObj.RowCount;i++){
	 			 // chk 되면 1이 된다.
	 			 if(sheetObj.CellValue(i,"eac_fax_use_flg")==1 && sheetObj.CellValue(i,"fax_no")=="") {
	 				ComShowCodeMessage('COM130201', 'Fax'); // Grid에 값을 입력하셔야 합니다;
	 				return false;
	 			 } 
	 			 if(sheetObj.CellValue(i,"eac_eml_use_flg")==1 && sheetObj.CellValue(i,"vndr_eml")=="") {
	 				 ComShowCodeMessage('COM130201', 'E-mail'); // Grid에 값을 입력하셔야 합니다;
	 				return false;
	 			 }
	 			 
	 			 if(!EasIsEmailAddr(sheetObj.CellValue(i,"vndr_eml"))){
	 				ComShowCodeMessage("EAS90074"); // E-mail address check
					return false;
	 			 }
	 		 }
	 		 break;	 		 
	 	 } // end switch()
	 	 return true;
	  }	 

	  /**
	  * sheet1 OnChange 이벤트
	  * @param {ibsheet} sheet 해당 시트   
	  * @param {long} row 해당 셀의 Row Index
	  * @param {long} col 해당 셀의 Column Index
	  * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	  */
	  function sheet1_OnChange(sheetObj,Row, Col, Value) {
		  
		  
		  chkFlag = sheetObj.CellValue(Row , "chk");
		  frm.g_vndr_seq.value = sheetObj.CellValue(Row , "vndr_seq");
		  doActionIBSheet(sheetObjects[1], frm, "IBSEARCH02");
		  
	  }
	  
	  
	  /**
	   * sheet2 OnChange 이벤트
	   * @param {ibsheet} sheet 해당 시트   
	   * @param {long} row 해당 셀의 Row Index
	   * @param {long} col 해당 셀의 Column Index
	   * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	   */
	  function sheet2_OnChange(sheetObj,Row, Col, Value) {
		  if(sheetObj.ColSaveName(Col)=="vndr_eml"){
			  if(!EasIsEmailAddr(Value)){
				  // 메일주소를 확인하세요
				  ComShowCodeMessage("EAS90074"); // E-mail address check
				  return;
			  }
		  }
	  }
	  
	  
	  function rep_OnPopupClick() {
		  	 var cmdt_cd_val ="";   //향후 사용가능 예정변수
		  	 var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		  	 var cmdt_desc_val ="";   //향후 사용가능 예정변수
		  	 var classId ="getCOM_ENS_rep";
		  	 var xx1="";  //CONTI
		  	 var xx2="";  //SUB CONTI
		  	 var xx3="";  //COUNTRY
		  	 var xx4="";  //STATE
		  	 var xx5="";  //CONTROL OFFIC
		  	 var xx6="";  //LOC CODE
		  	 var xx7="";  //LOC NAME
		  	 var xx8="";
		  	 var xx9="";

		  	 var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		  	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
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
	  /**
		  * S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
	  */
	  function getCOM_ENS_rep(rowArray) {
	  	for(var i=0; i<rowArray.length; i++) 
	  	{
	  		var colArray = rowArray[0];
	  		var colArray2 = colArray[2];
	  		var colArray3 = colArray[3];
	  		var colArray4 = colArray[4];
	  		frm.s_vndr_seq.value =colArray2;
	  		frm.s_vndr_nm.value =colArray4;
	  	}
	  }	  	  
	/* 개발자 작업  끝 */