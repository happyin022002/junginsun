/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0106.js
*@FileTitle : (KOR) DOD Tariff Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-17
*@LastModifier : songji
*@LastVersion : 1.0
* 2016-03-15 songji
* 1.0 Creation
* =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0106 : 
	 */
	function ESD_EAS_0106() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	}	

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var shtObj = null ;
	var sheetrow = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var ROWMARK = "|";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
	 var sheetObject = sheetObjects[0];
	 /******************************************************/
	 var formObject = document.form;
		
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_add":
			   doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			case "btn_del":

				if(!validateForm(sheetObject,formObject,IBDELETE)) {
    				return false;
    			}
				var delNum = ComRowHideDelete(sheetObject, "r_chk");
				break;					
			case "btn_save":
		
				if(!validateForm(sheetObject,formObject,IBSAVE)) {
    				return ;
    			}
				//zu_openRunning(false); //레이어형 대기 이미지 표시
				sheetObject.WaitImageVisible = false;
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_retrieve":
				if(!validateForm(sheetObject,formObject,IBSEARCH)) {
    				return false;
    			}
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				getEffDate(document.form);
				break;
            case "btn_calendar":
    			var cal = new ComCalendar();
    			cal.select(formObject.new_eff_dt, 'yyyy-MM-dd');
    			break;
            case "btn_aply_new_eff_dt":
            	applyNewEffDt();
    			break;
    			
		} // end switch
		
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("COM12111" );
			ComShowMessage(errMsg);
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
function loadPage() {
 	for(i=0;i<sheetObjects.length;i++){
 		//khlee-시작 환경 설정 함수 이름 변경
 		ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
	//html컨트롤 이벤트초기화
	initControl();
	getEffDate(document.form);
	//fun_getEUROffcd();		
}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start


	//Axon 이벤트 처리2. 이벤트처리함수 --- end
	

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = GetSheetHeight(15) ;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					//var HeadTitle = "Del.|Sts.|Eff_dt|Loc|Customer|Origin|T/S|Currency|Amount|User ID|Remark|Cre_Offce";
					var HeadTitle = "Del.|Sts.|Origin|T/S|Currency|Amount|Effective|User ID|User Name|Date";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
				   
					//데이터속성               [ROW, COL,  DATATYPE,   WIDTH,     DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC,    DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtDummyCheck,   40,    daCenter, true,    "r_chk");
                    InitDataProperty(0, cnt++, dtStatus, 	   30,    daCenter, true,    "ibflag",		      false,         "",       dfNone,    0,     		false,   	false);					
					InitDataProperty(0, cnt++, dtCombo,       120,    daCenter, true,    "pol_conti_cd",     true,         "",        dfNone,    0,     		false,    	true);       // readonly for update
					
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, true,    "cntr_tpsz_cd",	  true,          "",       dfNone,	  0,     		false,    	true,    2); // readonly for update
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, true,    "curr_cd",          true,          "",       dfNone,    0,     		false,   	false,   3); // readonly all
					InitDataProperty(0, cnt++, dtData,        120,    daRight,  true,    "drp_off_chg_trf_amt", true,      "",        dfInteger,  0,     		true,    	true,   15); 
					InitDataProperty(0, cnt++, dtPopupEditFormat,        120,    daCenter, true,    "eff_dt",            true,         "",       dfDateYmd, 0,     		false,    	true);       // readonly for update
					
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, true,    "upd_usr_id",       false,         "",       dfNone,    0,     		false,   	false); // readonly
					InitDataProperty(0, cnt++, dtData,        100,    daCenter, true,    "upd_usr_nm",       false,         "",       dfNone,    0,     		false,   	false); // readonly					
					InitDataProperty(0, cnt++, dtData,        120,    daCenter, true,    "upd_dt",           false,         "",       dfNone, 0,     		false,    	false);       // readonly for update					
					
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, true,    "ofc_cd",           false,         "",       dfNone,    0,     		false,   	false);      // readonly  ( dtHidden )
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, true,    "cre_usr_id",       false,         "",       dfNone,    0,     		false,   	false,  20); // readonly  ( dtHidden )				
					
					InitDataProperty(0, cnt++, dtHidden,      100,    daCenter, true,    "pol_cnt_cd",       false,         "",       dfNone,    0,     		false,   	false,   2); // readonly all
				
					InitDataCombo(0, "pol_conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
					
					InitDataValid(0, "cntr_tpsz_cd",   vtEngUpOther, "1234567890");
					
					ImageList(0) = "img/btns_calendar.gif";
					PopupButtonImage(0, "eff_dt") = 0;
					
					//sheetObj.MinimumValue(0, "drp_off_chg_trf_amt") = "1"; 
				}
				break;
				
		}
	}


/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	   case IBSEARCH:	  //조회
		    
		    formObj.new_eff_dt.value= "";
		    
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_EAS_0106GS.do", FormQueryString(formObj));
			break;

		case IBCLEAR:	   //Clear
			sheetObj.RemoveAll();
			break;

		case IBDOWNEXCEL:  //엑셀내려받기
			sheetObj.SpeedDown2Excel(true);
			break;
        		
		case IBINSERT:
		      var Row = sheetObj.DataInsert();
		      
			  sheetObj.CellValue(Row, "pol_conti_cd") = formObj.sel_pol_conti_cd.value;
			  sheetObj.CellValue(Row, "pol_cnt_cd") = "XX";
			  sheetObj.CellValue(Row, "curr_cd") = "KRW";
			  
			  sheetObj.CellValue(Row, "cre_usr_id") = formObj.ctrl_user_id.value;
			  sheetObj.CellValue(Row, "ofc_cd") = formObj.sel_ofc_cd.value; // formObj.ctrl_ofc_cd.value;
			  sheetObj.CellValue(Row, "upd_usr_id") = formObj.ctrl_user_id.value;		      
		  	  
			  if( ComIsEmpty(formObj.new_eff_dt.value) ) {
		  		sheetObj.CellValue(Row, "eff_dt") = formObj.sel_eff_dt.Code;
		  	  }else {
		  		sheetObj.CellValue(Row, "eff_dt") = formObj.new_eff_dt.value;  
		  	  }
		  	
		      break;		
		
		case IBDELETE:
			  var delNum = ComRowHideDelete(sheetObj, "r_chk");
		      break;			

		case IBSAVE:        //저장

			for(i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ){
				  if(sheetObj.RowStatus(i) == 'U'){ 
					 sheetObj.CellValue(i, "upd_usr_id") = formObj.ctrl_user_id.value;
					 sheetObj.CellValue(i, "upd_usr_nm") = "";	
				  }
			}
			formObj.f_cmd.value = MULTI;
            var retVal = sheetObj.DoSave("ESD_EAS_0106GS.do" ,FormQueryString(formObj));
            
            if(retVal){
            	var nEffDt = formObj.new_eff_dt.value;    
            	if(nEffDt != "") {
	            	getEffDate(formObj);
	            	var itemIndex = comboObjects[0].FindIndex(nEffDt,0);
	            	if (itemIndex != -1) {
	            		nEffDt = ComReplaceStr(nEffDt, "-", "");
	            		comboObjects[0].Code = nEffDt;
	            	}
	               //	formObj.f_cmd.value = SEARCH;
	               //	sheetObj.DoSearch4Post("ESD_EAS_0106GS.do", FormQueryString(formObj));

            	}
               	doActionIBSheet(sheetObj,formObj,IBSEARCH);
            }
            
	}
}


/** 
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj : 시트오브젝트  
 * @param  {object} formObj : 폼 오브젝트
 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
 * @return true, false
 * @see #
 * @author 한동훈
 * @version 2009.10.19
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
	case IBSEARCH:
		if( ComIsEmpty(formObj.sel_eff_dt.Code)  ) {
			ComShowCodeMessage("EAS90019");
			return false;
		}

		break;
		
	case IBDELETE:
		if (sheetObj.CheckedRows("r_chk") == 0) {
			ComShowMessage(msgs["COM12189"]);
			return false;
		}/* else if (sheetObj.CheckedRows("r_chk") > 0) {
			if(!ComShowCodeConfirm("COM12188")) return;
		}*/
		break;
	case IBSAVE:
		
		var verifyCheck = 'N';
		for(i=sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ){
			  if(sheetObj.RowStatus(i) != 'R'){ // 조회 상태가 아닌 Row 만 체크
				  verifyCheck = 'Y';
			  }
		}
		// Check T/S is null, duplication in Row, duplication in DB
		if(verifyCheck =='Y') {
			//if(!verifyTpszCd(sheetObj) || !chkKeyFiled(sheetObj) || !chkDupRow(sheetObj) || !checkDupDB(sheetObj)){
			if(!chkKeyFiled(sheetObj) || !chkDupRow(sheetObj) || !checkDupDB(sheetObj)){				
				return false;            	
			}
		}
 
		break;
		
	case IBINSERT:
		
		break;			
	}
    return true;
}

/**
 * Open Calendar  
 * @param sheetObj
 * @param row
 * @param col
 */
function sheet1_OnPopupClick(sheetObj, row, col){
	
	var colName = sheetObj.ColSaveName(col) ;
	switch(colName)
	{
    	case "eff_dt":
	    	cal = new ComCalendarGrid();
	    	cal.select(sheetObj, row, "eff_dt", 'yyyy-MM-dd');
	    	break; 
			
	}
}


function sheet1_OnClick(sheetObj, Row,Col,Value){

}
/**
 * Check T/S, AMT on Change
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @returns {Boolean}
 */
function sheet1_OnChange(sheetObj, Row,Col,Value){

	if ( Col == 3) { // cntr_tpsz_cd check !
		var tpszCnt = "";
		var formObj = document.form;
		var tmpCntrTpszCds = "";

		tmpCntrTpszCds = sheetObj.CellValue(Row, "cntr_tpsz_cd");

		formObj.sel_cntr_tpsz_cds.value 		= tmpCntrTpszCds;
		formObj.f_cmd.value = SEARCH02;

		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0106GS.do", sParam);
		tpszCnt = ComGetEtcData(sXml, "TPSZ_CNT") ;

		if(tpszCnt > 0){
			sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0,0,0);
			return true;
		}else{
			ComShowCodeMessage("EAS90017");
			sheetObj.RowFontColor(Row) = sheetObj.RgbColor(255,0,0);
			sheetObj.CellValue2(Row, "cntr_tpsz_cd") ="";
			sheetObj.SelectCell(Row, "cntr_tpsz_cd");
			return false;	
		}
	}
	if ( Col == 5) { // drp_off_chg_trf_amt check !
		var tmpAmt = "";

		tmpAmt = sheetObj.CellValue(Row, "drp_off_chg_trf_amt");
		
		if(tmpAmt <= 0 ){
			ComShowCodeMessage("COM130404", "Amount", "a value greater than 0");
			sheetObj.RowFontColor(Row) = sheetObj.RgbColor(255,0,0);
			sheetObj.SelectCell(Row, "drp_off_chg_trf_amt");
			return false;
		}else{ 
			sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0,0,0);
		}
	}

	
}
/**
 * Check Duplication in Row
 * @param sheetObj
 * @returns {Boolean}
 */
function chkDupRow(sheetObj){

	var Rows = sheetObj.ColValueDupRows("ofc_cd|pol_conti_cd|pol_cnt_Cd|cntr_tpsz_cd|eff_dt", false); // true : delete item 포함
	var arr_rows = null;
	var dupRow = "";
	if (Rows!=null && Rows.trim()!=''){
		arr_rows = Rows.split(',');
	}
	
	for (var i=0; arr_rows != null && i < arr_rows.length; i++){

		if(i == 0 ){
			dupRow = dupRow + arr_rows[i];
		} else {
			dupRow = dupRow + ',' + arr_rows[i];
		}
        sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255,0,0);
    }
	
	if (Rows!=null && Rows.trim()!=''){
    	ComShowCodeMessage("COM131302", "Office, Continent, Country, T/S, Effective Date in ["+dupRow+"] Row"); 
        return false;
    }else{
        return true;
        
    }
}
/**
 * Check Duplication in DB
 * @param sheetObj
 * @returns {Boolean}
 */
function checkDupDB(sheetObj){
	var dupCnt = '';
	var formObj = document.form;
	
	with(sheetObj) {
	   for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++ ) {  
	            if(sheetObj.RowStatus(i) == 'I'){
					var qStr =   "f_cmd=" + SEARCH03
					        + "&c_ofc_cd=" + CellValue(i, "ofc_cd")
					        + "&c_pol_conti_cd=" + CellValue(i, "pol_conti_cd")
					        + "&c_pol_cnt_cd=" + CellValue(i, "pol_cnt_cd")
					        + "&c_cntr_tpsz_cd=" + CellValue(i, "cntr_tpsz_cd")
					        + "&c_eff_dt=" + CellValue(i, "eff_dt")
					        + "&c_curr_cd=" + CellValue(i, "curr_cd");                                        
				
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0106GS.do", qStr);
					dupCnt = ComGetEtcData(sXml, "DUP_CNT");
					if(dupCnt > 0){
						
						ComShowCodeMessage("COM131302", "Office, Continent, Country, T/S, Effective Date "); 
						sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
					    return false;
				    }
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(0,0,0);
	            }
	   }      
   }
   return true;
}

function chkAmt(sheetObj){

	var amtArr = ComGetColumnData(sheetObj, "drp_off_chg_trf_amt"); // Rowstatus = I, U, D

	for(i = 0; i< amtArr.length; i++){

		if(amtArr[i] <= 0 ){
			ComShowCodeMessage("COM12133", "Amount", "0", "greater");
			sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0);
			sheetObj.SelectCell(i+1, "drp_off_chg_trf_amt");
			return false;
		} 
		sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(0,0,0);
	}
	return true;
}

function chkKeyFiled(sheetObj){

	var rarr = new Array();
	for(i=sheetObj.HeaderRows ;i<=sheetObj.LastRow ;i++ ){
		if(sheetObj.RowStatus(i) != 'R' || sheetObj.RowStatus(i) != 'D'){
			if ( sheetObj.CellValue(i, "cntr_tpsz_cd") == "" ){
				ComShowCodeMessage("EAS90045", i+" Row T/S"); 
				sheetObj.SelectCell(i, "cntr_tpsz_cd");
				return false; 
			}
			if ( sheetObj.CellValue(i, "drp_off_chg_trf_amt") <= 0 ){
				ComShowCodeMessage("COM12133", "Amount", "0", "greater");
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255,0,0);
				sheetObj.SelectCell(i, "drp_off_chg_trf_amt");
				return false; 
			}
		}
	}
	return true;
}
/**
 * sheetObject의 특정 Column 값을 배열로 반환하는 함수.
 *
 * @param sheetObject, RowNumber, 해당Coloumn  <br>
 * @returns Array <br>
 * @author 김영출
 */
function ComGetColumnData(sheetObj, colName){
	var rarr = new Array();
	for(yn=sheetObj.HeaderRows ;yn<=sheetObj.LastRow ;yn++ ){
	  if(sheetObj.RowStatus(yn) != 'R' || sheetObj.RowStatus(yn) != 'D'){
	    rarr.push(sheetObj.CellValue(yn, colName));
	  }
	}
	return rarr;
}

function verifyTpszCd(sheetObj){
	var tpszCnt = "";
	var formObj = document.form;
	
	var tpszArr = ComGetColumnData(sheetObj, "cntr_tpsz_cd");
	var tmpCntrTpszCds ='';
	for(i = 0; i< tpszArr.length; i++){

		if(i == 0 ){
			tmpCntrTpszCds = tmpCntrTpszCds + tpszArr[i];
		} else {
			tmpCntrTpszCds = tmpCntrTpszCds + ',' + tpszArr[i];
		}
	}

	formObj.sel_cntr_tpsz_cds.value 		= tmpCntrTpszCds;
	
	
	formObj.f_cmd.value = SEARCH02;

	var sParam = FormQueryString(formObj);
	var sXml = sheetObj.GetSearchXml("ESD_EAS_0106GS.do", sParam);

	tpszCnt = ComGetEtcData(sXml, "TPSZ_CNT") ;

	if(tpszCnt > 0){
		return true;
	}else{
		ComShowCodeMessage("EAS90017");
		return false;	
	}
}


function getEffDate(formObj){
	formObj.f_cmd.value = SEARCH01;
	var sParam = FormQueryString(formObj);
	var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0106GS.do", sParam);

	//조회후 결과처리
	var cboItems = ComGetEtcData(sXml, "TRF_EFFDT");

    comboObjects[0].RemoveAll();

    
    if (cboItems != undefined && cboItems.length > 0) {

    	addComboItemEffbyDesc(comboObjects[0], cboItems.split(ROWMARK));
    	
    	sheetObjects[0].RemoveAll();
    	formObj.new_eff_dt.value ="";
		
	}
}

function addComboItemEffbyDesc(comboObj, comboItems) {
	var defaultCode = "";
 	for (var i = comboItems.length-1, j=0 ; i >= 0 ; i--,j++) { 
 		var eff_dt = comboItems[i].substring(0,4)+"-"+comboItems[i].substring(4,6)+"-"+comboItems[i].substring(6,8);
	    comboObj.InsertItem( j, eff_dt, comboItems[i]);
	    if (i == comboItems.length-1){
	    	defaultCode = comboItems[i] ;
	     }
	}
 	comboObj.Code = defaultCode;
 }

function applyNewEffDt(){

	var formObj = document.form;
	
	if(sheetObjects[0].LastRow == 0){
		ComShowCodeMessage("COM130401");
		return false; 
	}
	
	if( ComIsEmpty(formObj.new_eff_dt.value) || !chkEffDateValue(ComReplaceStr(formObj.new_eff_dt.value, "-", ""))) {
		ComShowCodeMessage("COM130201","New Effecitve");
		formObj.new_eff_dt.value = "";
		formObj.new_eff_dt.focus() ;
		return false;	
	}
	
	// Check the Effective Date in the ComComboObject
	var nEffDt = formObj.new_eff_dt.value;
	var itemIndex = comboObjects[0].FindIndex(nEffDt,0);
	if (itemIndex != -1) {
		ComShowCodeMessage("EAS80012");
		nEffDt = ComReplaceStr(nEffDt, "-", "");
		comboObjects[0].Code = nEffDt;
		formObj.new_eff_dt.value = "";
 		return false;
	}

	if(!ComShowConfirm("Are you sure to apply to all? Then, click 'save' button ")) return;
	
	with(sheetObjects[0]) {
	   for(var i = sheetObjects[0].HeaderRows; i < sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++ ) {
		   CellValue(i, "eff_dt") = formObj.new_eff_dt.value;
		   CellValue(i, "upd_usr_id") = formObj.ctrl_user_id.value;
		   CellValue(i, "cre_usr_id") = formObj.ctrl_user_id.value;
		   sheetObjects[0].RowStatus(i) = "I";
	   }      
   }
}

function chkEffDateValue(value){
	var yyyy = value.substring(0,4) ;
	var mm   = value.substring(4,6) ;
	var dd   = value.substring(6) ;

	var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;
	
	// 월체크
	if(mm>12) {
		return false ;
	}
	
	// 윤달
	if(mm==2){
		daysInMonth[1] = yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
	}
	if(dd==0) {
		return false ;
	}
	
	// 일체크
	if(dd !=0 && dd!="" && mm!="" && dd>daysInMonth[mm-1]){
		return false ;
	}
	
	return true ;
}


function sel_eff_dt_OnChange(cboObj) {
	 sheetObjects[0].RemoveAll();
	 document.form.new_eff_dt.value ="";
}


function sel_ofc_cd_OnChange(value) {
	 sheetObjects[0].RemoveAll();
	 getEffDate(document.form);
}
	