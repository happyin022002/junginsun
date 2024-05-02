/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0099.js
 *@FileTitle : [FNS_JOO_0099] GW Contract Link
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.27
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2014.10.27 민정호
 * 1.0 Creation
=========================================================*/

/**
 * [FNS_JOO_0099] FGW Contract Link
 * @extends
 * @class GW Contract Link 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function FNS_JOO_0099() {
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
var prefix = "sheet1_";


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
function loadPage() {    
    //시트 초기화 
    for(var i=0 ; i < sheetObjects.length ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
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

			var HeadTitle1 = "|Sel.|Seq.|AGMT DOC NO|AGMT DOC DESC|ID|Date|csr_no|csr_agmt_doc_seq";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다					
			InitHeadMode(true, true, true, true, false,false);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		prefix+"ibflag");         
            InitDataProperty(0, cnt++ , dtDummyCheck,  40,    daCenter, 	false,   prefix+"del_chk");
            InitDataProperty(0, cnt++ , dtDataSeq,	    	40,	daCenter,	true,		prefix+"");		
            InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"agmt_doc_no",	 		    false,     "",	  dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtPopup,      		300,  daLeft,      false,   prefix+"agmt_doc_desc",     	 	true,       "",    dfNone,       0,         false,		true,	50);            
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix+"upd_usr_id",	 			    false,      "",	  dfNone,		0,			false,		false);			
			InitDataProperty(0, cnt++ , dtData,				200,	daCenter,	true,		prefix+"upd_dt",		 					false,      "",	  dfNone,		0,			false,		false);
            InitDataProperty(0, cnt++ , dtHidden,	    	50,	daCenter,	true,		prefix+"csr_no");
            InitDataProperty(0, cnt++ , dtHidden,	    	50,	daCenter,	true,		prefix+"csr_agmt_doc_seq");
            
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
        case "btn_Row_Add":
			var row = sheetObject.DataInsert(-1);		
			sheetObject.SelectCell(row,prefix+"agmt_doc_desc",false);		
			break;

        case "btn_Row_Delete":
        	
        	var row = sheetObject.FindCheckedRow(prefix+"del_chk");
        	if (row == "") {
        		ComShowCodeMessage("COM12189");
        		return;
        	}
        	
        	ComRowHideDelete(sheetObject, prefix+"del_chk"); 
        	
            break; 

        case "btn_Save":   
        	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
            break;
            
		case "btn_Close":
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
	var saveName=sheet.ColSaveName(col);	
	
	if(saveName == prefix+"agmt_doc_desc"){
		form.agmt_doc_row.value = row;
		fnDocOpen("item");		
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
    var sheetObject = sheetObjects[0];	
	var saveName=sheet.ColSaveName(col);
			
	if(saveName == prefix+"agmt_doc_desc"){	
		form.agmt_doc_no.value = sheetObject.CellValue(row,col-1);			
		fnDocOpen("detail");		
	}		
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
	
	
	if (saveName!= prefix+"agmt_doc_no" && saveName!=prefix+"agmt_doc_desc") {
		return;
	}
	
	var status = sheet.RowStatus(row);
		
	if (saveName==prefix+"agmt_doc_no") {
		sheet.MousePointer = (status=="I")?"Hand":"Default";
	} else if (saveName==prefix+"agmt_doc_desc") {
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
	 		formObj.f_cmd.value = SEARCH;									
			var sXml = sheetObj.DoSearch("FNS_JOO_0099GS.do", FormQueryString(formObj)+"&" + ComGetPrefixParam("sheet1_"));		
			break;
	 
	 	case IBSAVE: 		
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
			
	 		formObj.f_cmd.value = MULTI;
	 			 		
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);			
 			sheetObj.DoSave("FNS_JOO_0099GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), -1, false);  			
			ComOpenWait(false); 			
	 		break;
	 	}
}

/**
 * 저장 함수를 이용하여 저장이 완료되면 실행 <br>
 * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

//#######################################################

/**
 * GW return 함수 <br>
 * @param {String}	msg
 * @return {없음}
 **/	
var returnGwLink = function(msg){				
	msg = msg.split(",");
    var formObj = document.form;
    var gw_no = msg[0];
    var gw_desc = msg[1];
    var sheetObject = sheetObjects[0];    
       
    sheetObject.CellValue2(formObj.agmt_doc_row.value, prefix+"agmt_doc_no") = gw_no;
    sheetObject.CellValue2(formObj.agmt_doc_row.value, prefix+"agmt_doc_desc") = gw_desc;        
}

/**
 * GW문서 오픈 <br>
 **/
function fnDocOpen(sw){
	var formObj = document.form;
	
    var iframeObj = document.getElementsByTagName("IFRAME");

    for (var i = 0; i < iframeObj.length; i++) {
           if(iframeObj[i].id == "gwrequest")
               iframeObj[i].parentNode.removeChild(iframeObj[i]);
    }
    
	ifrm = document.createElement("IFRAME");
	ifrm.setAttribute("id", "gwrequest");
	ifrm.style.width = 0+"px";
	ifrm.style.height = 0+"px";		
	
	var csrGwUrl = document.form.csr_gw_url.value;
	var url = "";
			
	if(sw == 'item'){		
		url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS||SELCTS");
		ifrm.setAttribute("src", url);
		document.body.appendChild(ifrm);			
	}else{
		var assetcd = document.form.agmt_doc_no.value;
		if(assetcd != ''){
			url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+assetcd);
			ifrm.setAttribute("src", url);
			document.body.appendChild(ifrm);				
		}			
	}
}


// return 처리를 위한 함수 (필수)
function receiveMessage(event) {
       // 리턴 처리 방법
      returnGwLink(event.data)
}

if(window.addEventListener) {
      window.addEventListener("message", receiveMessage, false);
}

if(window.attachEvent) {
    window.attachEvent("onmessage", receiveMessage);
}

if(document.attachEvent) {
    document.attachEvent("onmessage", receiveMessage);
}		

