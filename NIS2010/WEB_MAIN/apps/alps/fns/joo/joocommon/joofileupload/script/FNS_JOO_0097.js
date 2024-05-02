/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0097.js
 *@FileTitle : [FNS_JOO_0097] File Upload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.08
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2010.11.08 이준범
 * 1.0 Creation
=========================================================*/

/**
 * [FNS_JOO_0097] File Upload
 * @extends
 * @class File Upload 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function FNS_JOO_0097() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}


// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

var uploadObjects = new Array();
var uploadCnt = 0;
var upload1 = null;
// html form
var frm = null;


/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
 * @param {ibupload} uploadObj    IBUpload Object
 **/
function setUploadObject(uploadObj) {
	uploadObjects[uploadCnt++] = uploadObj;
}

// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage() {

	//전역 변수 설정 
    frm = document.form;
//    sheet1 = sheetObjects[0];    
//    sheetCnt = sheetObjects.length ;   
    upload1 = uploadObjects[0];
    //시트 초기화 
    for(var i=0 ; i < sheetObjects.length ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //UPLOAD 환경 설정
    for(var i=0; i < uploadObjects.length ; i++){
	    //1. 기본 환경 설정
	    ComConfigUpload(uploadObjects[i], "/hanjin/FNS_JOO_0097GS.do");	
	}    

     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
            // 높이 설정
			style.height = 240;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Sel.|Seq.|File Name|ID|Date|Download|jo_crr_cd|crr_cntc_seq|file_path|file_sav_id";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다					
			InitHeadMode(true, true, true, true, false,false);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");         
            InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	false,      "del_chk");
            InitDataProperty(0, cnt++ , dtDataSeq,	    40,		daCenter,	true,		"");			
			InitDataProperty(0, cnt++ , dtPopup,      	360,    daLeft,     false,      "file_nm",     	 true,       "",      dfNone,       0,          false,		true,	50);						
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"upd_usr_id",	 false,      "",	  dfNone,		0,			false,		false);			
			InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,		"upd_dt",		 false,      "",	  dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtImage,		40,		daCenter,	true,		"file_download", false,      "",	  dfNone,		0,			false,		false);
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,		"jo_crr_cd");
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,		"crr_cntc_seq");
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,		"file_path");
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,	    "file_save_id",	 false,      "",	  dfNone,		0,			false,		false);
            ImageList(0)= "/hanjin/img/ico_attach.gif";
            ShowButtonImage = 1;
            break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================





// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	var sheetObject = sheetObjects[0];
	
	switch (srcName) {	
        case "btn2_Row_Add":
        	var rCount = sheetObject.RowCount + sheetObject.RowCount("D");
        	if (rCount == 0) {
    			var row = sheetObject.DataInsert();		
    			sheetObject.SelectCell(row,"",true);	
        	} else {
        		ComShowCodeMessage("COM132202","Inserting more than one row ");
        	}
			break;

        case "btn2_Row_Delete":
        	
        	var row = sheetObject.FindCheckedRow("del_chk");
        	if (row == "") {
        		ComShowCodeMessage("COM12189");
        		return;
        	}
        	
        	ComRowHideDelete(sheetObject, "del_chk"); 
        	
            break; 

        case "btn2_Save":   
        	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
            break;
            
		case "btn1_Close":
			self.close();
            break; 
	}
}


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================


/**
 * 파일 선택하기 <br>
 * @param {ibsheet} sheet    IBSheet Object
 * @param {ibsheet} row     	sheet 선택된 row
 * @param {ibsheet} col     	sheet 선택된 col
 **/
function sheet1_OnPopupClick(sheet,row,col){
	var fileName = sheet.OpenFileDialog(ComGetMsg("JOO00115","file."));	
	if(fileName.indexOf("\\") !=-1) {
		sheet.CellValue2(row, "file_path")= fileName;
		fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
		sheet.CellValue2(row, "file_nm")= fileName;
	}
}

/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheet    IBSheet Object
 * @param {ibsheet} row     	sheet 선택된 row
 * @param {ibsheet} col     	sheet 선택된 col
 * @param {String} 	value     	파일명
 **/
function sheet1_OnClick(sheet,row,col,value){

	if (sheet.ColSaveName(col)!= "file_download" || 
			sheet.RowStatus(row)=="I") {
		return;
	}
	
	if(sheet.CellText(row, "file_sav_id") == "") {
		return;
	}
	
	var frm1 = document.form1;
//	alert(sheet.CellText(row, "file_save_id")); 
	frm1.action = "/hanjin/FileDownload?key="+sheet.CellText(row, "file_save_id");
	frm1.submit();
	return;
}

 
/**
 * 파일 다운받기 
 * sheet1 doubleClick후 이벤트 
 * @param {ibsheet} sheet 해당 시트   
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */
function sheet1_OnDblClick(sheet, row, col) {

 	if (sheet.ColSaveName(col)!= "file_nm" || 
 			sheet.RowStatus(row)=="I") {
 		return;
 	}
 	
 	if(sheet.CellText(row, "file_sav_id") == "") {
 		return;
 	}
 	
 	var frm1 = document.form1;
 	frm1.action = "/hanjin/FileDownload?key="+sheet.CellText(row, "file_sav_id");
 	frm1.submit();
 	return;
 }


/**
 * 마우스 포인터 이동시 발생하는 이벤트 <br>
 * @param {ibsheet} sheet    IBSheet Object
 * @param {ibsheet} Button     	sheet 선택된 Button
 * @param {ibsheet} Shift     	sheet 선택된 Shift
 * @param {int} 	X     		X좌표값
 * @param {int} 	Y     		Y좌표값
 **/
function sheet1_OnMouseMove(sheet, Button, Shift, X, Y){
	var row = sheet.MouseRow;
	var col = sheet.MouseCol;
	if (row < sheet.HeaderRows || col < 0) {
		return;
	}
	
	var saveName=sheet.ColSaveName(col);
	
	
	if (saveName!= "file_nm" && saveName!="file_download") {
		return;
	}
	
	var status = sheet.RowStatus(row);
		
	if (saveName=="file_nm") {
		sheet.MousePointer = (status=="I")?"Hand":"Default";
	} else if (saveName=="file_download") {
		sheet.MousePointer = (status=="I")?"Default":"Hand";
	}
		
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {	
	
	 switch (sAction) {

	 	case IBSEARCH: //조회
			frm.f_cmd.value = SEARCH01;	
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0097GS.do", FormQueryString(frm));
			sheetObj.LoadSearchXml(sXml);		
			break;
	 
	 	case IBSAVE: 

	 		frm.f_cmd.value = MULTI;		
	 		//파일 저장시 인코딩 주의
	 		var saveString = sheetObj.GetSaveString(false,true);
	 		if (sheetObj.IsDataModified && ComIsNull(saveString))  {	
	 			return;
	 		}	
	 		if (ComIsNull(saveString))  {			
	 			//msgs["JOO00036"] = "There is no data to save.";
	 			ComShowCodeMessage("JOO00036");
	 			return;
	 		}

	 		var sRow = sheetObj.FindStatusRow("I");		
	 		var arrRow = sRow.split(";");

	 		//기존파일 초기화
	 		upload1.Files = "";
		
	 		for(var i = 0 ; i < arrRow.length - 1 ; i++) {
	 			var row = arrRow[i];			
	 			//파일 경로 가져오기
	 			var sFile = sheetObj.CellValue(row , "file_path");
	 			upload1.AddFile(sFile);
	 		}
		
	 		var param = FormQueryString(frm) + "&" + saveString;
		
//	 		alert(param);
	 		// Upload
	 		if (!ComIsNull(upload1.LocalFiles)) {			
	 			upload1.ExtendParam = param;
	 			upload1.ParamDecoding = true;
	 			sheetObj.WaitImageVisible = false; 
	 			ComOpenWait(true);	
	 			var sXml = upload1.DoUpload(true);	
//	 			alert(sXml);
	 			sheetObj.LoadSaveXml(sXml);
	 			ComOpenWait(false);
	 			sheetObj.WaitImageVisible = true;
	 			var errorYn = ComGetEtcData( sXml, "ERROR_YN");
	 			var fSaveId =  ComGetEtcData( sXml, "SAVE_ID");
	 			document.form.file_save_id.value = fSaveId;
	 			var opener = window.dialogArguments
	 			opener.get_Child(fSaveId);
	 			if (errorYn == "N") {
	 				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	 			}
			
		// 일반
	 		} else {			
	 			param = FormQueryString(frm) + "&" + sheetObj.GetSaveString();			
	 			var sXml = sheetObj.GetSaveXml("FNS_JOO_0097GS.do",  param);			
	 			sheetObj.LoadSaveXml(sXml);
	 			var errorYn = ComGetEtcData( sXml, "ERROR_YN");
	 			var fSaveId =  ComGetEtcData( sXml, "SAVE_ID");
	 			document.form.file_save_id.value = fSaveId;
	 			var opener = window.dialogArguments
	 			opener.get_Child("");
	 			if (errorYn == "N") {
	 				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	 			}			
	 		}
	 		break;
	 	}
}