/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1011.js
*@FileTitle : KPI Target Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
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
     * @class ESD_SPE_1011 : ESD_SPE_1011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1011() {
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

	// 조회여부 
	var hasSerched = false;
	var temYear = "";
	// HEADER ROW
	var HEADROWS = 2;
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
				case "btn_audit_month":
					temYear = frm.s_ev_yr.value;
					var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.setEndFunction('calEndFunction');
						cal.select(frm.s_ev_yr, 'yyyy');
					break;        	
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
	 				if(hasSerched){
	 					var Row = sheetObj.DataInsert(-1);
	 					if(sheetObjects[0].RowCount == 1){
	 						var yr = document.form.s_ev_yr.value;
		 					sheetObjects[0].CellValue2(Row, "ev_yr") = yr;
	 					}else{
	 						sheetObjects[0].CellValue2(Row, "ev_yr") = sheetObjects[0].CellValue(HEADROWS,"ev_yr");
	 						sheetObjects[0].CellValue2(Row, "eg_id") = sheetObjects[0].CellValue(HEADROWS,"eg_id");
	 						sheetObjects[0].CellValue2(Row, "eg_nm") = sheetObjects[0].CellValue(HEADROWS,"eg_nm");
	 					}
	 					
	 				}else{
	 					ComShowCodeMessage('SPE10008', ''); //조회후 추가하세요
	 				}
	 				
	 				break;
	 				
	 			case "btn_RowDel":
	 				if(sheetObjects[0].FindCheckedRow("chk") == ""){

	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObjects[0], frm, IBDELETE);
	 				}
	 				break;
	 			case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],frm,IBDOWNEXCEL);
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
     // 달력에서 값이 변경되면 그리드를 초기화 한다.
	 function calEndFunction(){ 
		 if(temYear != frm.s_ev_yr.value){
			 sheetObjects[0].RemoveAll();
			 temYear = frm.s_ev_yr.value; 
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
         
         initControl();
         sheet1_OnLoadFinishLoad(sheetObjects[0]);
         
         var today = new Date();
         var year = today.getYear();
         frm.s_ev_yr.value = year;
	}

	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/	
	function initControl() {
		axon_event.addListenerForm('keypress',   'obj_keypress',      frm); //- 키 눌렸을때
		axon_event.addListenerForm( 'blur'   ,   'obj_blur'    ,      frm ); //- 포커스 나갈때
		axon_event.addListenerForm('change',     'obj_change', frm);		
		axon_event.addListener ('keydown', 'keydownEnter', 'form');
	}

	 /**
	  * HTML Control KeyDown 이벤트 호출
	  */
	 function keydownEnter() {
	 	if (event.keyCode != 13) {
	 		return;
	 	}
	 	var obj = event.srcElement;
	    switch (obj.name) {    
	    case "s_eg_rhq_cd":
	    case "s_eg_ofc_cd":
	    case "s_ev_svc_cate_cd":
	    case "s_ev_yr":
	    	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
			focusOut();

	    	break;          	
		}	  
	 } 
	 
	/**
	* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	**/
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
        		comboObj.Index=0;
  			break;  
   	  		case "s_eg_ofc_cd":
   	  			comboObj.DropHeight = 250;
   	  			break;  
   	  		case "s_ev_svc_cate_cd":
   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 300;
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
				style.height = GetSheetHeight(20);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
			    Editable = true;
			    
			    var HeadTitle1 = "ibflag||Year|EG ID|EG Name|KPI|Prior Year|Prior Year|Prior Year|Prior Year|Type Code|Type Code|Target(%)|Weight(%)|USEFLAG";
				var HeadTitle2 = "ibflag||Year|EG ID|EG Name|KPI|Performance(%)|Target(%)|Weight(%)|Score|Type Code|Type Code|Target(%)|Weight(%)|USEFLAG";
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(HEADROWS, 1, 24, 100);
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 6, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
				InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	true,	"chk");
				InitDataProperty(0, cnt++ , dtData,         50,  	daCenter,   true,  "ev_yr",            false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,  "eg_id",            false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         110,  	daCenter,   true,  "eg_nm",            false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtComboEdit,	150,  	daLeft,     true,  "sp_kpi_id",        false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         120,  	daCenter,   false, "pre_per_avg",      false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   false, "pre_tgt_rto",	   false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   false, "pre_wgt_rto",	   false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   false, "pre_rslt_scre",	   false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtHidden, 		60,  	daCenter,   true,  "sp_kpi_tp_cd",     false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData, 		90,  	daCenter,   true,  "sp_kpi_tp_nm",     false,   "",      dfNone,          0,          false,        false,   10);
				InitDataProperty(0, cnt++ , dtData,         90,  	daCenter,   true,  "kpi_tgt_rto",      false,    "",     dfNullFloat,     2,          true,         false,   5);
				InitDataProperty(0, cnt++ , dtAutoSum,	    100,  	daCenter,   true,  "kpi_wgt_rto",      true,    "",      dfInteger,       0,          true,         true,    3);
				InitDataProperty(0, cnt++ , dtHidden,	    100,  	daCenter,   true,  "useflag",          true,    "",      dfNone,          0,          false,        false,    3);

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
	    		
//						InitDataValid(0, "sp_cd", vtEngUpOnly);
	    		
	    	    }
	    		break;				

			}
		}	
		 
		function obj_change(){
			var obj = event.srcElement;
			switch(obj.name) {
				case "s_ev_yr":
					if(!ComChkObjValid(obj))obj.value="" ;
					sheetObjects[0].RemoveAll();
					
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
//					alert(sParam);
//						ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1010GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
//						ComOpenWait(false);
				}
				hasSerched = true;
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
            	frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
//		    	alert(sParam);
		        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1010GS.do", sParam);
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State != "S") {
					ComShowCodeMessage('COM130103', 'Data');
					ComOpenWait(false);
					return false;
				} else if (State == "S") {
					ComShowCodeMessage('COM130102', 'Data');
					doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
				}
							
				break;
			case IBDELETE :
				
	   	   		if(sheetObj.FindCheckedRow("chk") != ""){
	   	   			var delRow = sheetObj.FindCheckedRow("chk").split("|");
	   	   			for(var i =0;i< delRow.length-1;i++){
	   	   				sheetObj.CellValue2(delRow[i],"kpi_wgt_rto") = 0
	   	   				
	   	   			}
					ComRowHideDelete(sheetObj,"chk");
				}
			    break;	
			case IBDOWNEXCEL :	// EXCEL DOWNLOAD
//					sheetObj.SpeedDown2Excel(1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	switch(comboObj.id) {
        case "s_eg_rhq_cd":
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj);
	    	comboObj.InsertItem(0, "", "");
	    	break;  
	    case "s_eg_ofc_cd": 
	    	frm.f_cmd.value = COMMAND02;
	        // eg_rhq_cd 에 값이 있으면 GRID office 값이 변경이 된다.
	        frm.eg_rhq_cd.value = "";	    	
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	comboObj.InsertItem(0, "", "");
	    	
	    	//frm.s_eg_ofc_cd.Index=0;
	    	break;  
	  	case "s_ev_svc_cate_cd":  
	  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd,sheetObj); 
	  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
        sheetObj.WaitImageVisible = true;
        
    	
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
    	
    }

    function getGridCombo(sheetObj){
    	frm.f_cmd.value = SEARCH02;
//    	var cateCd = frm.s_ev_svc_cate_cd.value;
    	var sParam = FormQueryString(frm);
		
		var sXml = sheetObj.GetSearchXml("ESD_SPE_1010GS.do", sParam);
		
	    var spKpi = ComXml2ComboString(sXml,  "sp_kpi_id", "sp_kpi_nm");
	    if( spKpi != undefined){
	    	sheetObj.InitDataCombo(0, "sp_kpi_id", " |" + spKpi[1], " |" + spKpi[0]);    // IBSheet내 Combo 초기화
	    }
	    
    }
    /**
     * Cell 선택시
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
//    	var kpiTpCd = sheetObj.CellText(NewRow, 'sp_kpi_tp_cd');
//    	var colName = sheetObj.ColSaveName(NewCol);
//    	if(colName == 'kpi_tgt_rto'){
//    		if(kpiTpCd != 'P' && kpiTpCd != 'S'){
//    			sheetObj.CellEditable(NewRow, NewCol) = true;
//    			//OrgValue = sheetObj.CellText(NewRow, NewCol);
//    		}else{
//    			sheetObj.CellEditable(NewRow, NewCol) = false;
//    		}
//    	}else{
//    		
//    	}
        
    }
    
    /**
     * sheet1 편집처리후 이벤트
     * @param {long} row 해당 셀의 Row Index
     * @param {long} col 해당 셀의 Column Index
     * @param {string} col 해당 셀의 value 
     * 
     */
    function sheet1_OnChange(sheetObj, row, col ,value) {
    	//if (col == sheetObj.SaveNameCol("kpi_tgt_rto")) {
    	if (col == sheetObj.SaveNameCol("kpi_tgt_rto") || col == sheetObj.SaveNameCol("kpi_wgt_rto")) {
    		var rtoValue = sheetObj.CellValue(row, col);
			if( value > 100){
				ComShowCodeMessage('SPE10010', ''); //100이하여야 합니다.
    			sheetObj.CellValue2(row, col) = "0";
    		}
			
			if( col == sheetObj.SaveNameCol("kpi_wgt_rto")){
				var wgtRtoSum = calRtoSum(sheetObj);
				if( wgtRtoSum > 100){
//					alert("Weight의 합계는 100이하여야 합니다.");
					ComShowCodeMessage('SPE10010', ''); //100이하여야 합니다.
					sheetObj.CellValue2(row, col) = "0";
				}
			}
    	}
    }
	// 공통테이블에 등록된 코드값을 조회 한다.
    /*
	function searchCommonCombo(codeKey,comboObj){
		var sheetObj = sheetObjects[1];
			frm.f_cmd.value = SEARCH01;
			// 공통 테이블에서 조회할 키
			frm.code_key.value = codeKey
//				sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("ESD_SPE_1001GS.do", FormQueryString(frm));
//				sheetObj.WaitImageVisible = true;
			ComXml2ComboItem(sXml, comboObj, "code_cd", "code_nm");	
	}        
	*/    

		 
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,frm,sAction){
		switch(sAction) {
			case IBSEARCH :
				var evYr = frm.s_ev_yr.value;
				var egRhqCe = frm.s_eg_rhq_cd.Text;
				var egOfcCd = frm.s_eg_ofc_cd.Text;
				var egSvcCateCd = frm.s_ev_svc_cate_cd.Text;
				
				var chkAll = frm.s_chk_all.checked;
				var chkMap = frm.s_chk_map.checked;
//				var chkUnmap = frm.s_chk_unmap.checked;
				if( chkAll == false && chkMap == false){
					ComShowCodeMessage('COM130201', 'Mapped or All'); //Map 값을 입력하셔야 합니다
					return false;
				}
				//alert(evYr + ":" + egRhqCe + ":" + egOfcCd + ":" + egSvcCateCd);
				if( evYr == ""){
					ComShowCodeMessage('COM130201', 'Year'); //Year 값을 입력하셔야 합니다
					return false;
				}
				if( egRhqCe == ""){
					ComShowCodeMessage('COM130201', 'Level 1'); //Level 1 값을 입력하셔야 합니다
					return false;
				}
				if( egOfcCd == ""){
					ComShowCodeMessage('COM130201', 'Level 2'); //Level 2 값을 입력하셔야 합니다
					return false;
				}
				if( egSvcCateCd == ""){
					ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
					return false;
				}
				break;
			case IBSAVE :
				if(sheetObj.RowCount<1){
					ComShowCodeMessage('COM130201', 'Grid'); //Grid 값을 입력하셔야 합니다
					return false;
				}
				if(sheetObj.GetSaveString(false, true)==""){
					return false;
				}

				// 합계는 100 이하
				if( calRtoSum(sheetObj) != 100){
					ComShowCodeMessage('SPE10012', 'weights '); //100이하여야 합니다.
//					ComShowCodeMessage('SPE10010', ''); //100이하여야 합니다.
					return false;
				}
				
				sheetObj.SpaceDupCheck = false;
				var idxDub = sheetObj.ColValueDup("eg_id|sp_kpi_id");
            	if(idxDub > -1){
            		ComShowCodeMessage("COM12115","[EG ID / KPI]");
            		sheetObj.SelectCell(idxDub, "sp_kpi_id", true);
            		return false;
            	}
				break;
			case IBDOWNEXCEL:
				//그리드 데이터 없을 경우
				if( sheetObj.RowCount < 1 ){
					return false;
				}
				break;
		} // end switch()
		return true;
	}	 

	
	  
	function s_eg_rhq_cd_OnChange(comboObj,Index_Code, Text){   
		doActionIBCombo(frm.s_eg_ofc_cd); // RHQ
	}
	// cate cd가 바뀌면 조회를 먼저 해야한다.
	function s_ev_svc_cate_cd_OnChange(comboObj,Index_Code, Text){
		hasSerched = false;
		sheetObjects[0].RemoveAll();
		initSheet(sheetObjects[0],1);
		//
		getGridCombo(sheetObjects[0]);
		
		frm.s_ev_svc_cate_cd.focus();
	}
		  
    
    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트
     */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		sheetObj.ShowSum();
		if (sheetObj.RowCount("R") > 0) {
			sheetObj.SumText(0, "ev_yr") = "Total Cost";
		}
		
		setCellProperty(sheetObj);
	}
	
	/**
	 * 셀 속성 변경
	 * Productivity, S/Q 일때 입력 불가
	 */ 
	function setCellProperty(sheetObj){
		// CELL format변경
		for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow-1; idx++ ){			
			var kpiTpCd = sheetObj.CellValue(idx,"sp_kpi_tp_cd");

//			if(kpiTpCd == 'P' || kpiTpCd == 'S'){
			if(kpiTpCd == 'P'){
				sheetObj.CellEditable(idx, "kpi_tgt_rto") = false;				
//				sheetObj.InitCellProperty (idx, "kpi_tgt_rto", dtData, daCenter, "kpi_tgt_rto", "", dfNone, 0, 0);
//				
				//sheetObj.CellValue2(idx, "pre_tgt_rto") = "";
				//sheetObj.CellValue2(idx, "kpi_tgt_rto") = "";
			}else{
				sheetObj.CellEditable(idx, "kpi_tgt_rto") = true;
				sheetObj.InitCellProperty (idx, "kpi_tgt_rto", dtData, daCenter, "kpi_tgt_rto", "", dfFloat, 2, 5);
			}
		}		
	}
	
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function vender_change(sheet, row, col ,value){
		var sheetObj = sheet;
		if(sheetObj.CellValue(row,"sp_code") =="" ){
			sheetObj.CellValue2(row,"sp_code") = "";
			sheetObj.CellValue2(row,"sp_name") = "";
			return;
		}else {
			frm.f_cmd.value = COMMAND01;
			frm.vndr_seq.value = value;
			var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_1003GS.do", FormQueryString(frm));
			var vndrNm = SpeXmlString(sXml,"vndr_nm");
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				sheetObj.CellValue2(row,"sp_code") = "";
				sheetObj.CellValue2(row,"sp_name") = "";
				return;
			}else{
				sheetObj.CellValue2(row,"sp_name") = vndrNm;
			}
		}
			
	}
	
	/**
	 * 숫자의 합은 100 이하
	 * @param sheetObj
	 * @returns {Boolean}
	 */
	function calRtoSum(sheetObj){
		var dsum = 0;
		for( var idx = parseInt(sheetObj.HeaderRows); idx < sheetObj.SearchRows+parseInt(sheetObj.HeaderRows) ; idx++ ){
			var ibflag = sheetObj.CellValue(idx,"ibflag");
			if(ibflag != 'D'){
//				alert(Number(sheetObj.CellValue(idx,"kpi_wgt_rto"))+"     i : "+i)
				dsum = Number(dsum) + Number(sheetObj.CellValue(idx,"kpi_wgt_rto"));			
			}
			
		}
		
		return dsum;
	}
			
	function checkType(obj){
		if(obj.name=="s_chk_all"){
			document.form.s_chk_map.checked=false;
//			document.form.s_chk_unmap.checked=false;
		}else if( obj.name == "s_chk_map"){
			document.form.s_chk_all.checked=false;
//			document.form.s_chk_unmap.checked=false;
		}
		
	}
	/* 개발자 작업  끝 */