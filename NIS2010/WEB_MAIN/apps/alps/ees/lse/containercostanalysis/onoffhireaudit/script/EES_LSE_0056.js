/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0056.js
 *@FileTitle : Invoice File import
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.22
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.06.22 진준성
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
 * @class EES_LSE_0056 :EES_LSE_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_LSE_0056() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* 개발자 작업  */

//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var vLeaseTermCd = "";
var vCntrTpszCd  = "";
var arryLeaseTermCd = new Array();
var arryCntrTpszCd  = new Array();

var verifyYN = "";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.	
	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
}

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var srcObj  = window.event.srcElement;
		switch(srcName) {

		case "btn_LoadFile":
			sheetObject1.RemoveAll();
			sheetObject2.RemoveAll();
			loadFile();
			break;

		case "btn_DownExcel":			
			sheetObject1.Down2Excel();
			break;

		case "btn_Save":			
			//ComBtnDisable("btn_Save");
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;

		case "btn_Close":
			window.close();
			break;

		case "btn_New": 
			//ComBtnEnable("btn_Save"); 
			verifyYN = "";
			sheetObject1.RemoveAll();
			break;
		case "btn_LoadExcel":
			if ( srcObj.style.filter == "" ) {				
				//sheetObject1.RemoveAll();
				//sheetObject2.RemoveAll();
				loadExcelFile();
			}
			break;			
		case "btn_verify":			
			if(sheetObjects[0].RowCount <= 0){
                ComShowCodeMessage("LSE01048");
                break;
                return;
            }
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
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
function loadPage() {	
	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();		
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 248;
		//전체 너비 설정
		SheetWidth = 750;//mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		var HeadTitle1 = "Seq.|AGMT No.|Contract No.|CNTR No.|TP/SZ|Lease Term|On Hire Date|On Hire LOC|Off Hire Date|Off Hire LOC|agmt_cty_cd|agmt_seq|vndr_seq|";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		
		InitDataProperty(0, cnt++ , dtSeq,            35, daCenter, true,   "seq");
		InitDataProperty(0, cnt++ , dtData,           85, daCenter, true,   "agmt_no",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           85, daCenter, true,   "contract_no",    false, "",   dfNone,   0,  false,    false);		
		InitDataProperty(0, cnt++ , dtData,           85, daCenter, true,   "cntr_no",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           45, daCenter, true,   "cntr_tpsz_cd",   false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           75, daCenter, true,   "lstm_cd",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_onh_dt",      false, "",   dfDateYmd,0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_onh_loc_cd",  false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_offh_dt",     false, "",   dfDateYmd,0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,           80, daCenter, true,   "lr_offh_loc_cd", false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, true,   "agmt_cty_cd",    false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, true,   "agmt_seq",       false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0,  daCenter, true,   "vndr_seq",       false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHiddenStatus,   0,  daCenter, true,   "ibflag");
		SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;

	case "sheet2":  
		with (sheetObj) {

			// 높이 설정
			style.height = 318;
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

			var HeadTitle1 = "txt";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++ , dtData,           35, daLeft, true,   "txt");
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch(sAction) {
	case IBSEARCH:      //verify
	formObj.f_cmd.value = SEARCH;
	sheetObj.WaitImageVisible = false;
	ComOpenWait(true);
	var sXml2 = sheetObj.GetSearchXml("EES_LSE_0056GS.do", FormQueryString(formObj));
	var contract_no    = ComGetEtcData(sXml2, "contract_no")
    
	if(contract_no == "F" || sXml2 == "" || sXml2 == null){    	
    	ComShowCodeMessage("LSE01096");   	    	
    }else{
    	loadFileVerify();
    }
	ComOpenWait(false);
	sheetObj.WaitImageVisible = true;
	break;

	case IBSAVE:        //저장	  
	
	if(validateForm(sheetObj,formObj,sAction)){
		formObj.f_cmd.value = MULTI;	
		var sParam = sheetObj.GetSaveString(true);			
		sParam += "&" + FormQueryString(formObj);	
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml   = sheetObj.GetSaveXml("EES_LSE_0056GS.do", sParam);	
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		var strAudVerSeq = "";
		if(sXml != null && sXml != ""){			
			strAudVerSeq = ComGetEtcData(sXml, "aud_ver_seq");
			opener.document.form.aud_ver_seq.InsertItem(0 , strAudVerSeq ,strAudVerSeq);	
			ComSetObjValue(opener.document.form.aud_ver_seq , strAudVerSeq);
			opener.searchForSave();			
			window.close();
		}
	}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH01;		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		if ( sXml != "" ) {
			vLeaseTermCd = ComGetEtcData(sXml, "lease_term_cd");
			arryLeaseTermCd =  vLeaseTermCd.split("|");
		}

		sXml = "";
		formObj.f_cmd.value = SEARCH02;
		sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));		

		if ( sXml != "" ) {
			vCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
			arryCntrTpszCd = vCntrTpszCd.split("|");
		}
		break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
    with(sheetObj){
        with(formObj){
            switch(sAction){
            case IBSAVE:      //저장
                if(sheetObjects[0].RowCount == 0 ){                	
                	ComShowCodeMessage("LSE01048"); 
                	return false;
                }else if(verifyYN == "" || verifyYN == "N" ){
                	ComShowCodeMessage("LSE01084"); 
                	return false;
                }            
                return true;
            break; // case end
            }
        }        
    }
}            

/**
* file import 처리
*/
function loadFile(){
	
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var strFilePath = sheetObject2.OpenFileDialog("*.txt");	
	if(strFilePath == "<USER_CANCEL>"){		
		return;
	}	
	var strIdx = strFilePath.lastIndexOf("\\");
	var strFileName = strFilePath.substr(strIdx + 1 );

	var arryFileName = strFileName.split(".");
	if(arryFileName != null){
		strFileName = arryFileName[0];
	}
	sheetObject1.RemoveAll();
	sheetObject2.RemoveAll();
	sheetObject2.LoadText(false , "" , strFilePath);

	var itmTxt = "";
	var contractNo = "";
	ComOpenWait(true);
	for (var i = 1 ; i <= sheetObject2.RowCount; i++ ){

		if(i == 1){			    	
			itmTxt = sheetObject2.CellValue(i,0);
			itmTxt.substr(0 , 3);  //vendor Code
			itmTxt.substr(3 ,14);  //Invoce No
			itmTxt.substr(17,15);  //Contract Reference Number

		}else{
			sheetObject1.DataInsert(-1);
			itmTxt = sheetObject2.CellValue(i,0);
			sheetObject1.CellValue2( i-1 , "contract_no" ) = strFileName;          //contract_no
			sheetObject1.CellValue2( i-1 , "cntr_no" )     = itmTxt.substr(0,11);  //Container No			    	
			sheetObject1.CellValue2( i-1 , "onh_dt" )      = itmTxt.substr(30,8);  //On-hire date
			sheetObject1.CellValue2( i-1 , "onh_loc_cd" )  = itmTxt.substr(38,5);  //onh_loc_cd
			sheetObject1.CellValue2( i-1 , "offh_dt" )     = itmTxt.substr(43,8);  //offh_dt
			sheetObject1.CellValue2( i-1 , "offh_loc_cd" ) = itmTxt.substr(51,5);  //offh_loc_cd

		}
	}
	document.form.ref_no.value = strFileName;
	ComOpenWait(false);
}

function loadExcelFile(){
	verifyYN = "";
	var sheetObject1 = sheetObjects[0];
	var lRow = 1
	if(sheetObject1.RowCount > 0){
	    lRow = sheetObject1.LastRow + 1;
	}
	var strFilePath = sheetObject1.OpenFileDialog("" , "");	
	if(strFilePath == "<USER_CANCEL>"){		
		return;
	}		
	var strIdx = strFilePath.lastIndexOf("\\");
	var strFileName = strFilePath.substr(strIdx + 1 );		
	var strNameIdx = strFileName.lastIndexOf(".");				
	strFileName = strFileName.substr(0 , strNameIdx );			
	var vAppendFlag = sheetObject1.LoadExcel(1, 1, strFilePath);		
	ComOpenWait(true);
	var strAgmtSeq  = "";
	var strAgmtSeqs = "";
	var iAgmtSeq    = 0;
	
 	for(var i = lRow  ; i <= sheetObject1.LastRow ; i++){
		sheetObject1.CellValue( i , "contract_no" ) = strFileName;	
		if(sheetObject1.CellValue( i , "agmt_no" ) != null && sheetObject1.CellValue( i , "agmt_no" ) != ""){
		   sheetObject1.CellValue( i , "agmt_cty_cd" ) = sheetObject1.CellValue( i , "agmt_no" ).substr(0,3);
		   strAgmtSeq  = sheetObject1.CellValue( i , "agmt_no" ).substr(3);
		   strAgmtSeq  = strAgmtSeq.trim(); 
           if(strAgmtSeq.length > 6){
        	   iAgmtSeq = Number(strAgmtSeq.substr(0,6));
           }else{
        	   iAgmtSeq = Number(strAgmtSeq);
           }
           
           sheetObject1.CellValue( i , "agmt_seq" )  = iAgmtSeq;
	    }
      
		if( strAgmtSeqs.indexOf(iAgmtSeq + "")  < 0 ){		
		    if(i == 1){
				strAgmtSeqs = iAgmtSeq + "";
		    }else{
				strAgmtSeqs = strAgmtSeqs + "," + iAgmtSeq;	    	
		    }
	    }
		sheetObject1.CellValue( i , "vndr_seq" ) = opener.document.form.vndr_seq.value;
	}
	document.form.ref_no.value      = strAgmtSeqs;	
	document.form.contract_no.value = sheetObject1.CellValue( 1 , "contract_no" );
	document.form.vndr_seq.value    = sheetObject1.CellValue( 1 , "vndr_seq" );
	ComOpenWait(false);
}

function loadFileVerify(){
	var cntrNo      = "";
	var cntrNo2     = "";
	var onhDt       = "";
	var onhLocCd    = "";
	var lstmCd      = "";
	var cntrTpszCd  = "";
	var lrOffhLocCd = "";
	var agmtNo      = "";

	//cntr_no 중복체크
	var returnMsg = sheetObjects[0].ColValueDupRows("cntr_no");
	var arryIdx =  returnMsg.split(",");
	
	if(returnMsg != ""){
		ComShowCodeMessage("LSE01092");
		sheetObjects[0].SelectCell(arryIdx[0],"cntr_no");
		return;
	}
	
	for(var i = 1 ; i <= sheetObjects[0].LastRow ; i++){
		cntrNo      = sheetObjects[0].CellValue( i , "cntr_no" );
		onhDt       = sheetObjects[0].CellValue( i , "lr_onh_dt" );
		onhLocCd    = sheetObjects[0].CellValue( i , "lr_onh_loc_cd" );
		lstmCd      = sheetObjects[0].CellValue( i , "lstm_cd" );
		cntrTpszCd  = sheetObjects[0].CellValue( i , "cntr_tpsz_cd" );
		lrOffhLocCd = sheetObjects[0].CellValue( i , "lr_offh_loc_cd" );
		agmtNo      = sheetObjects[0].CellValue( i , "agmt_no" );				
		
		if(agmtNo.length == ""){
		    ComShowCodeMessage("LSE01006");
		    verifyYN = "N";
		    sheetObjects[0].SelectCell(i , "agmt_no");	
		    return ;
		}else if(agmtNo.length < 4){
			ComShowCodeMessage("LSE01039");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "agmt_no");	
			return ;
		
		}else if(lstmCd.length == ""){
			ComShowCodeMessage("LSE01009");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "lstm_cd");	
			return ;
		}else if(lstmCd.length > 2){
		    ComShowCodeMessage("LSE01056");
		    verifyYN = "N";
		    sheetObjects[0].SelectCell(i , "lstm_cd");	
		    return ;
	    }else if( cntrNo == null || cntrNo == "" ){
			ComShowCodeMessage("LSE01064");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_no");	
			return ;
		}else if(cntrNo.length != 11){
			ComShowCodeMessage("LSE01074");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_no");	
			return ;
		}else if(cntrTpszCd.length == ""){
			ComShowCodeMessage("LSE01015");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_tpsz_cd");	
			return ;				
		}else if(cntrTpszCd.length > 2){
			ComShowCodeMessage("LSE01038");
			verifyYN = "N";
			sheetObjects[0].SelectCell(i , "cntr_tpsz_cd");	
			return ;
		}else if( onhDt == null || ComGetMaskedValue(onhDt, "ymd") == "" ){
			ComShowCodeMessage("LSE01020");
        	verifyYN = "N";
        	sheetObjects[0].SelectCell(i , "lr_onh_dt");	
        	return;        
		}else if( onhLocCd == null || onhLocCd == "" ){ //DB입력시 5자리 이상일 경우 5자리로 substring 해서 넣으므로 null 체크만 한다.
        	ComShowCodeMessage("LSE01037");                
            verifyYN = "N";
            sheetObjects[0].SelectCell(i , "lr_onh_loc_cd");	
            return;       
     
        }
	}	
	
	verifyYN = "Y";
	ComShowCodeMessage("LSE01083");  
}

/* 개발자 작업  끝 */