/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MST_0025.js
 *@FileTitle : Container Status Creation-LST and FND
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.30
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.07.30 민정호
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
 * @class EES_MST_0025 : EES_MST_0025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MST_0025() {
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
var IBSEARCH02  = 30;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
		case "btn_master":
			if (sheetObjects[0].rowCount != 0 ) {
				var cntr_no = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cntr_no");
				if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"){
					var cntr_no_len =cntr_no.length;
					if ( cntr_no_len > 10 ) {
						cntr_no = cntr_no.substring(0,10);
					} 
					ComOpenPopup("/hanjin/EES_MST_0019.do?popup_mode=Y&cntr_no="+cntr_no,1100, 630, "", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;  		

    	case "btns_calendar1": //달력버튼    		
    		if(!formObject.input_cntr_sts_evnt_dt2.disabled){
				var cal = new ComCalendar();
				cal.select(formObject.input_cntr_sts_evnt_dt2, 'yyyy-MM-dd');
    		}
			break;
  	 	
		case "ComOpenPopupWithTarget1":
    		if(!formObject.input_onh_yd_cd.disabled){			
 		        ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 500, "3:input_onh_yd_cd", "0,0,1,1,1,1,1", true);
 		        
   		        if (formObject.input_onh_yd_cd.value == ""){
   		        	formObject.yd_cd_nm.value = "";
   		        }
   		        
            	if (formObject.input_onh_yd_cd.value.length > 0 && formObject.input_onh_yd_cd.value.length != 7){
            		ComShowCodeMessage("MST01019", formObject.input_onh_yd_cd.value);
            		formObject.input_onh_yd_cd.value = "";
            		formObject.yd_cd_nm.value = "";
            		ComSetFocus(formObject.input_onh_yd_cd);
            		return;
            	} else {
            		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
            	} 	    			
    		}
			break;   			
			
		case "btn_add":
//			if(!formObject.input_cntr_sts_cd.disabled){
				sheetObject1.DataInsert(-1);
				sheetObject1.SelectCell(sheetObject1.SelectRow,"cntr_no", true);				
//			}
			
			break;

		case "btn_delete":
			
			if(sheetObject1.FindCheckedRow("Sel")=="")
			{
				ComShowCodeMessage("MST00010");
			}
			else if(ComShowCodeConfirm("MST00005")) 
			{ 
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
			}
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			ComBtnEnable("btn_add");
			break;

		case "btn_new":
			formObject.input_cntr_sts_cd.disabled = false;
			formObject.input_cntr_sts_evnt_dt2.disabled = false;
			formObject.input_onh_yd_cd.disabled = false;
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_loadexcel");			
			
			formObject.input_cntr_sts_cd.value = "LST";
			formObject.input_cntr_sts_evnt_dt.value = "";
			formObject.input_cntr_sts_evnt_dt2.value = "";
			formObject.input_onh_yd_cd.value = "";
			formObject.yd_cd_nm.value = "";
			formObject.input_cntr_sts_cd.value = "";
			sheetObject1.RemoveAll();
			sheetObject1.HeadCheck(0,"Sel") = false;
			ComSetFocus(formObject.input_cntr_sts_cd);			
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_loadexcel":	
			sheetObject1.RemoveAll();
			if (validateForm(sheetObject1, formObject, "")){
				var aa = sheetObject1.LoadExcel(-1,1,"","-1","-1","",false);
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break; 
		case "btn_downexcel":
			sheetObject2.DataInsert(-1);
			sheetObject2.Down2Excel();
			sheetObject2.RowDelete(sheetObject2.LastRow, false);
		break;
		
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) { 
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj  = document.form;
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	formObj.input_cntr_sts_cd.value = "";
	ComSetFocus(formObj.input_cntr_sts_cd);
	initControl(); 
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 390;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(24, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(false, true, false, true, false,false);
            InitHeadMode(true, true, true, true, false,false);
            
			var HeadTitle = "|CNTR No.|TP/SZ|Term|Lessor|Lessor Name|EQ\nStatus|EQ Status\nDate|EQ Status\nYard|F/M|MVMT\nStatus|MVMT Yard|MVMT Date|Remark(s)";			

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]			
			InitDataProperty(0, cnt++, dtDummyCheck, 0, daCenter, false, "Sel");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_no",			true,  "", dfNone, 0, true, true, 11);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cntr_tpsz_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "lstm_cd",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vndr_seq",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "vndr_lgl_eng_nm",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cntr_sts_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_sts_evnt_dt",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "lst_sts_yd_cd",	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "full_flg",			false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cnmv_sts_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "crnt_yd_cd",		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cnmv_dt",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "cntr_rmk",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++ ,dtHiddenStatus,	 0,   daCenter,  false,   	 "ibflag");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_onh_yd_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_cntr_sts_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_cnmv_evnt_dt");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_lst_sts_yd_cd");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_lst_sts_seq");	
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_chk1");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_chk2");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_chk3");
			InitDataProperty(0, cnt++ , dtHidden,  0,   daCenter,  false,   "h_save");	
			
			sheetObj.InitDataValid(0, "cntr_no", vtEngUpOther,'0123456789');
			sheetObj.InitDataValid(0, "cntr_rmk", vtEngOther,'0123456789-~[]{}_|*&^%$#@!,<>.?/-=\+ ');					
						
			CountPosition = 0;			
            SelectFontBold = true;
            SelectHighLight = false;    			
		}
		break;
		
	case 2: //sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 390;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msNone;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(2, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
//		InitHeadMode(false, true, false, true, false,false);
        InitHeadMode(true, true, true, true, false,false);
        
		var HeadTitle = "CNTR No.|Remark(s)";			

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]			
		InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_no",			true,  "", dfNone, 0, true, true, 11);
		InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "cntr_rmk",			false, "", dfNone, 0, true, true);
	}
	break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)){
			for(var i=1; i<sheetObjects[0].RowCount+1; i++){
				sheetObjects[0].CellValue2(i,"h_save") = "0";
//				sheetObjects[0].CellValue2(i,"cntr_rmk") = "";
			}
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);			
			formObj.f_cmd.value = SEARCH;
			
			var sParam1 = sheetObj.GetSaveString(); 
			if (sheetObj.IsDataModified && sParam1 == "") return;
			
			form.input_cntr_sts_evnt_dt.value = ComReplaceStr(ComGetObjValue(form.input_cntr_sts_evnt_dt2), "-", "");
			sheetObj.DoSearch("EES_MST_0025GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString(true));
			ComOpenWait(false);
			
			var cntrnochk = false;
			for (var i = 1; i <= sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "cntr_tpsz_cd") == ""){
					cntrnochk = true;
					sheetObj.CellFontColor(i,"cntr_no") = sheetObj.RgbColor(255, 0, 0);
					sheetObj.CellEditable(i, "cntr_no") = true;
				} else {
					sheetObj.CellEditable(i, "cntr_no") = false;
				}
			}
		    if (cntrnochk == true)
		    	ComShowCodeMessage("MST02014");			
		}
		break;

	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction)){
						
			for(var i = 0; i <= sheetObj.RowCount; i++){
				if (sheetObj.CellEditable(i, "cntr_no") == true){
					ComShowCodeMessage("MST02015");
					sheetObj.SelectCell(i, "cntr_no", true);
					return;
				}			
			}
			
			for(var i=1; i<sheetObjects[0].RowCount+1; i++){
				sheetObjects[0].CellValue2(i,"h_save") = "1";
			}
			
			formObj.f_cmd.value = MULTI;
			
			if(ComShowCodeConfirm("COM130101")){
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				sheetObj.DoSave("EES_MST_0025GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			}
		}
		break;
		
	case IBDELETE:      // 삭제
	
	    var iCheckRow = sheetObj.FindCheckedRow("Sel");
		if(iCheckRow != ""){
			  var arrRow = iCheckRow.split("|");
			  for (idx=0; idx<arrRow.length-1; idx++){ 
				   sheetObj.RowDelete(arrRow[idx], false); 
			  }
		      //ComRowHideDelete(sheetObj,"Sel");
		}	
	   	break;	
	
	case IBSEARCH02 :
		if (formObj.input_onh_yd_cd.value != ""){
			formObj.f_cmd.value = SEARCH06;
	    	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.input_onh_yd_cd.value+"&yd_chk_flg=N");
			var chk = sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR")!= -1 || sXml.indexOf("Error")!= -1){
			   sheetObj.LoadSearchXml(sXml);
			   return;
			}
	    	var codestr = ComXmlString(sXml, "code_nm");
	    	if (codestr == "" && formObj.input_onh_yd_cd.value != ""){
	    		ComShowCodeMessage("MST01019", formObj.input_onh_yd_cd.value);
	    		formObj.input_onh_yd_cd.value = "";
	    		formObj.yd_cd_nm.value = "";
	    		ComSetFocus(formObj.input_onh_yd_cd);
	    		return;
	    	} else {
	    		formObj.yd_cd_nm.value = codestr;
	    	}
		}
		break;	
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if(ComIsEmpty(formObj.input_cntr_sts_cd)){
			ComShowCodeMessage("MST00001", "Status Code");			
			return false;
		}
		
		if(ComIsEmpty(formObj.input_cntr_sts_evnt_dt2)){
			ComShowCodeMessage("MST00001", "Date");			
			return false;			
		}
				
		if(ComGetDaysBetween(ComGetNowInfo(), formObj.input_cntr_sts_evnt_dt2) > 0){			
			ComShowCodeMessage("MST01006", "Date");			
			formObj.input_cntr_sts_evnt_dt2.value = "";
			formObj.input_cntr_sts_evnt_dt.value = "";
			return false;
		}
				
		if(ComIsEmpty(formObj.input_onh_yd_cd)){
			ComShowCodeMessage("MST00001", "Yard");			
			return false;
		}	
		
		// 동일한  cntr_no 있으면  첫번째 중복행에 대해서  메세지 출력
		var dupRows = sheetObj.ColValueDupRows("cntr_no");
		var arrRow = dupRows.split(",");
        if (dupRows != ""){
   			 //오류메시지 : 데이터가 중복됩니다.
   			 ComShowCodeMessage("MST00002", sheetObj.CellValue(arrRow[0],1));
             for (var i = 1; i <= sheetObj.RowCount+1; i++){
            	 if (sheetObj.CellValue(i,"cntr_no")   == sheetObj.CellValue(arrRow[0],"cntr_no")){
       			     sheetObj.SelectCell(i, "cntr_no", true);
            	 }
             }
   			 return false;			        	
        }  		
		
	}
	return true;
}

 function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form; 
	var sheetObj  = sheetObjects[0];		
	var rowCount = sheetObj.RowCount;

	if(rowCount > 0){
		formObj.input_cntr_sts_cd.disabled = true;
		formObj.input_cntr_sts_evnt_dt2.disabled = true;
		formObj.btns_calendar1.readonly = true;
		formObj.input_onh_yd_cd.disabled = true;
		formObj.ComOpenPopupWithTarget1.readonly = true;
	}
 }
 
/** 
* Sheet1 의 OnSearchEnd 이벤트에 대한 처리  <br>
* @param  sheetObj
* @param  ErrMsg
* @return 없음
*/ 
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		
	var sheetObj  = sheetObjects[0];		
	var rowCount = sheetObj.RowCount;
	var failcnt = 0;		
	var failcnt2 = 0;	
	
	if(ErrMsg != '' && ErrMsg.length > 0) return;
	
	for(var i=1; i<rowCount+1; i++){
		if(sheetObj.CellValue(i,"h_chk1") == "E"){
			sheetObj.CellFontColor(i, "cntr_sts_cd") = sheetObj.RgbColor(255, 0, 0);
			failcnt++;
		}
		
		if(sheetObj.CellValue(i,"h_chk2") == "E"){
			sheetObj.CellFontColor(i, "crnt_yd_cd") = sheetObj.RgbColor(255, 0, 0);
			failcnt++;			
		}
		
		if(sheetObj.CellValue(i,"h_chk3") == "E"){
			sheetObj.CellFontColor(i, "cnmv_dt") = sheetObj.RgbColor(255, 0, 0);
			failcnt++;			
		}		
		
		if(sheetObj.CellValue(i,"h_chk1") == "" &&	sheetObj.CellValue(i,"h_chk2") == "" &&
		   sheetObj.CellValue(i,"h_chk3") == ""){
			sheetObj.CellFontColor(i, "cntr_no") = sheetObj.RgbColor(255, 0, 0);			
			failcnt++;	
		}
		
		if(failcnt > 0){
			failcnt2++;
		}
		
		failcnt = 0;
	}	
		
	var succCount = rowCount - failcnt2;
	var sMsg = "";
	
	if(rowCount >0){		
		if (succCount > 0 && failcnt2 == 0 ){
			sMsg = ComGetMsg("MST01025", "", "", "");
		}
		if (succCount > 0 && failcnt2 > 0 ){
			sMsg = sMsg + ComGetMsg("MST01027", "", "", "");
		}
		if (succCount == 0 && failcnt2 > 0){
			sMsg = sMsg + ComGetMsg("MST01026", "", "", "");
		}
	
		ComShowMessage (sMsg);
	}			
}

// Axon 이벤트 처리
// 1. 이벤트catch
function initControl() {
	var formObj = document.form;
	
	axon_event.addListenerFormat('beforedeactivate',    'obj_blur',     form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- 키 눌렸을때
	axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- 키 눌렸을때
	axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
	axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- 키 눌렸을때  
	ComBtnEnable("btn_add");
}  	

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
	var formObj = document.form;
	var obj = event.srcElement;
		
    if (event.srcElement.name == "input_cntr_sts_evnt_dt2"){
    	ComAddSeparator(formObj.input_cntr_sts_evnt_dt2);
    	if (ComGetNowInfo("ymd") < formObj.input_cntr_sts_evnt_dt2.value){
    		formObj.input_cntr_sts_evnt_dt2.value = ComGetNowInfo("ymd");
    		ComAlertFocus(formObj.input_cntr_sts_evnt_dt2,ComGetMsg("MST01006", "", "", ""));
    	} else {
    		ComAddSeparator(formObj.input_cntr_sts_evnt_dt2, "ymd");
    	}
    }
    else if(event.srcElement.name == "input_onh_yd_cd"){	
    	if (formObj.input_onh_yd_cd.value.length > 0 && formObj.input_onh_yd_cd.value.length != 7){
    		ComShowCodeMessage("MST01019", formObj.input_onh_yd_cd.value);
    		formObj.input_onh_yd_cd.value = "";
    		formObj.yd_cd_nm.value = "";
    		ComSetFocus(formObj.input_onh_yd_cd);
    		formObj.input_onh_yd_cd.focus();
    	} 	
    }    
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_focus(){
	var formObj = document.form;
	var obj = event.srcElement;
	
    if (event.srcElement.name == "input_cntr_sts_evnt_dt2"){		
    	ComClearSeparator(formObj.input_cntr_sts_evnt_dt2, "ymd");
    	ComSetFocus(formObj.input_cntr_sts_evnt_dt2);
    }	
}

function obj_keypress(){
    
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    
    switch(obj.dataformat) {
        case "ymd":
            if(obj.name=="input_cntr_sts_evnt_dt2") ComKeyOnlyNumber(this, "-");
            break;
        case "engup":
        	if(obj.name=="input_onh_yd_cd") ComKeyOnlyAlphabet('uppernum');
            break;
    }        
}

function obj_keyup() {
	
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;

	switch (obj.name) {
		case "input_onh_yd_cd":
	    	if (formObj.input_onh_yd_cd.value.trim().length == 7){
	    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	    	} 			
	    	else if (vKeyCode == 13 || vKeyCode == 9 && (formObj.input_onh_yd_cd.value.length > 0)){
	    		ComShowCodeMessage("MST01019", formObj.input_onh_yd_cd.value);
	    		formObj.input_onh_yd_cd.value = "";
	    		formObj.yd_cd_nm.value = "";
	    		ComSetFocus(formObj.input_onh_yd_cd);
	    		formObj.input_onh_yd_cd.focus();				
			}
	    break;	
	}
}	

// Container No를 입력후 조회
function sheet1_OnChange(sheetObj, Row,Col, Value){
	var sName = sheetObj.ColSaveName(Col);
	
	if(sName == "cntr_no"){	
		if(Value.length == 11){				
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
}

function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
	var formObj = document.form;
	var sName = SheetObj.ColSaveName(Col);
	
 	 var celltxt  = SheetObj.EditValue;
   	 var celltxt1 = SheetObj.CellValue(Row, "cntr_no");
   	 if (celltxt == "" && celltxt1 != ""){
   		 celltxt = celltxt1;
   	 } 

    if (sName == "cntr_no" && (celltxt.length == 11 || KeyCode == 13)){
    	
    	SheetObj.CellValue2(Row,"cntr_no") = celltxt;
		if (formObj.input_cntr_sts_cd.value == "") {
			ComShowCodeMessage("MST00001", "Status Code");
			ComSetFocus(formObj.input_cntr_sts_cd);
			return;
		} 
		if (formObj.input_cntr_sts_evnt_dt2.value == "") {
			ComShowCodeMessage("MST00001", "Date");
			ComSetFocus(formObj.input_cntr_sts_evnt_dt2);
			return;
		}
		if (formObj.input_onh_yd_cd.value == "") {
			ComShowCodeMessage("MST00001", "Yard");
			ComSetFocus(formObj.input_onh_yd_cd);
			return;
		}
		
    	doActionIBSheet(SheetObj,formObj,IBSEARCH);
    }
}

/* 개발자 작업  끝 */