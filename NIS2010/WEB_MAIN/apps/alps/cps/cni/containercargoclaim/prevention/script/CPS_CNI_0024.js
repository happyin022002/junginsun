/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0024.js
 *@FileTitle : [CPS_CNI_0024] Prevention
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0024] Prevention
 * @extends
 * @class Prevention 대상 검색 및 금액 입력화면
 */
function cps_cni_0024() {
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

// html form
var frm = null;
// Main Code Inquiry 팝업 타입
var type = "";

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
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
function loadPage(year) {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
 
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //Form 이벤트 등록
    initControl();
		
	
	var clmPrveNo = frm.clm_prve_no.value;		
	if (!ComIsNull(clmPrveNo) && clmPrveNo.length > 10) {
		doActionIBSheet(SEARCHLIST02);		
	} 

	var usrId = frm.usr_id.value;
	setRollBtnCtlPrevention(usrId, "btn1_Print");
	
    //초기 focus();
	frm.clm_prve_no.focus();
}


/**
* Form 이벤트 등록
*/
function initControl() {
	axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
	axon_event.addListener('keyup', 'keypressClmPrveNo', 'clm_prve_no');	
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
			style.height = 120;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|File Name|Contents|ID|Date|Download|clm_file_seq|file_path|file_sav_id";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다					
			InitHeadMode(true, true, true, true, false,false);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
            InitDataProperty(0, cnt++ , dtDataSeq,	    50,		daCenter,	true,		"clm_file_dp_seq");			
			InitDataProperty(0, cnt++ , dtData,      	250,    daLeft,     false,      "file_nm",     	false,           "",      dfNone,      0,     false,		true,	50);
			InitDataProperty(0, cnt++ , dtData,			250,	daLeft,	    true,		"file_desc",			false,      "",				dfNone,		0,			true,		true);			
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"upd_usr_id",			false,      "",				dfNone,		0,			false,		false);			
			InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"upd_dt",			false,      "",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtImage,		40,		daCenter,	true,		"file_download",			false,      "",				dfNone,		0,			false,		false);
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,		"clm_file_seq");
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,		"file_path");
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,	"file_sav_id",			false,      "",				dfNone,		0,			false,		false);
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
	
	switch (srcName) {
		case "btn1_Retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST02);			
			}
			break;
		case "btn1_close":
			self.close();
			break;		
		case "btn1_Print":
			var clmPrveNo = frm.clm_prve_no.value;
			if (!ComIsNull(clmPrveNo)) {
				doActionIBSheet(PRINT);
			} 
			break;			
	    case "btn1_New":	    	
    		ComResetAll();
    		frm.clm_prve_no.value = "";    		
	    	break;				
	}

}


/**
 * HTML Control KeyPress 이벤트 호출
 */
function keypressClmPrveNo() {
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "clm_prve_no":
    	if (obj.value.length == 11) {
    		doActionIBSheet(SEARCHLIST02);    		
    	}
    	break;
	}
}

  
//업무 자바스크립트 OnKeyPress 이벤트 처리
function keypressFormat() {
	obj = event.srcElement;
   if(obj.dataformat == null) return;
   window.defaultStatus = obj.dataformat;
   switch(obj.name) {
       case "clm_prve_no":
       	ComKeyOnlyAlphabet('uppernum');
    	break;          	
            
   }
}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
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
	frm1.action = "/hanjin/FileDownload?key="+sheet.CellText(row, "file_sav_id");
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
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST02) {		
		frm.f_cmd.value = SEARCHLIST02;
		var sXml = sheet1.GetSearchXml("CPS_CNI_0023GS.do", FormQueryString(frm));
		
		var arrXml = sXml.split("|$$|");
		
		if (arrXml.length > 0 ) {
			
			var list = SheetXml2ListMap(arrXml[0]);			
			if (list.length == 0) {
				//msgs["CNI00013"] = "There is no related data!";
				ComShowCodeMessage("CNI00013");
				ComResetAll();
	    		frm.clm_prve_no.value = "";
				frm.clm_prve_no.focus();
				return;
			}
			
			if (list.length > 0) {
				
				var vo = list[0];
				
				frm.clm_prve_no.value = vo["clm_prve_no"];							
				var effDt = vo["eff_dt"];
				frm.eff_dt.value = fmDate(vo["eff_dt"]);
				frm.exp_dt.value = fmDate(vo["exp_dt"]);
				frm.clm_prve_div_nm.value = vo["clm_prve_div_nm"];
				frm.cre_ofc_cd.value           = vo["cre_ofc_cd"];
				frm.clm_prve_subj_nm.value     = vo["clm_prve_subj_nm"];
				frm.clm_prve_desc.value        = vo["clm_prve_desc"];			
				frm.cre_usr_id.value           = vo["cre_usr_id"];			
				frm.clm_area_cd.value          = vo["clm_area_cd"];
			}
			
					
		}
		
		if (arrXml.length > 1 ) {
			sheet1.LoadSearchXml(arrXml[1]);
		}
		
	} else if (sAction == PRINT) {		
		frm.f_cmd.value = PRINT;		
		
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0093.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]";
		var rpaper = "/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		var rv =  "";
		frm.com_mrdArguments.value = rf + " " + rv + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value = "Prevention-Print";		
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaim/prevention/report/CPS_CNI_0093.mrd";
		var feature = "resizable=yes,width=1000,height=600"
		popupRd(1000,600);
		
	} 
}

