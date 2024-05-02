/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0001.js
 *@FileTitle : Default Setting 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.14
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.05.22 박명종
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
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
 * @class VOP_PSO_0001 : VOP_PSO_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0001() {
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
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var usrOfcCd = "";/*SSO 유저의 office cd를 저장 */
var isDup    = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		case "btn_Add":

			var temp = sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_yd_cd1")+sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_yd_cd2");
			var Row = -1;
			for( var i=sheetObjects[0].HeaderRows ; i < sheetObjects[0].LastRow ; i++ ) {
				if( temp == sheetObjects[0].CellValue( i, "sheet1_yd_cd1")+sheetObjects[0].CellValue(i, "sheet1_yd_cd2") && sheetObjects[0].CellValue( i, "sheet1_ibflag") != "D" )
					Row = i;
			}	

			if( sheetObject1.LastRow > 0 ) {
				if(sheetObject1.CellValue(sheetObject1.LastRow, 0) == "R" && sheetObject1.CellValue(sheetObject1.LastRow, 3) == "" ){
					sheetObject1.RemoveAll();
				}	
				if(sheetObject1.CellValue(sheetObject1.LastRow, 3) == "" ){
					ComShowCodeMessage('PSO00001','');
					return;    	  		
				} else if ( Row != "" && Row != "-1" ){
					ComShowCodeMessage('PSO00002','');
					return;    	  		
				}
			}	

			sheetObject1.DataInsert(-1);
			//var vals = comboItems2.split("|");
			sheetObject1.CellComboItem(sheetObject1.LastRow, 3 , " |", " |", 0);
			break;
		case "btn_Add2":
			var temp = sheetObjects[1].CellValue(sheetObjects[1].LastRow, 2);
			var Row = -1;
			for( var i=sheetObjects[1].HeaderRows ; i < sheetObjects[1].LastRow ; i++ ) {
				if( temp == sheetObjects[1].CellValue( i, 2) && sheetObjects[1].CellValue( i, "sheet2_ibflag") != "D" )
					Row = i;
			}	

//			var Row = sheetObject2.ColValueDup("2");

			if( sheetObject2.LastRow > 0 ) {
				if(sheetObject2.CellValue(sheetObject2.LastRow, 0) == "R" && sheetObject2.CellValue(sheetObject2.LastRow, 3) == "" ){
					sheetObject2.RemoveAll();
				}	

				if(sheetObject2.CellValue(sheetObject2.LastRow, 3) == "" ){
					ComShowCodeMessage('PSO00001','');
					return;    	  		
				} else if ( Row != "-1" ){
					ComShowCodeMessage('PSO00002','');
					return;    	  		
				}
			}	

			sheetObject2.DataInsert(-1);
			break;
		case "btn_Del":
			ComRowHideDelete(sheetObject1, "sheet1_del_chk");
			break;
		case "btn_Del2":
			ComRowHideDelete(sheetObject2, "sheet2_del_chk");
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1,formObject,IBSAVE);

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
	var formObject = document.form;
	formObject.ofc_cd.value = usrOfcCd; //ofc cd 설정.
	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}

}





/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 82;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel.|Terminal|Terminal";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN,    COLMERGE, SAVENAME,  	KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix+"ibflag"  );
			InitDataProperty(0, cnt++ , dtCheckBox,		60,	daCenter,	true,	prefix+"del_chk" );
			InitDataProperty(0, cnt++ , dtPopupEdit,	90,	daCenter,	true,	prefix+"yd_cd1"  , 	false,	"", dfEngUpKey, 0,	false,	true,5);
			InitDataProperty(0, cnt++ , dtCombo,		40,	daCenter,	true, 	prefix+"yd_cd2"  , 	false,	"", dfNone, 0,	false,	true);
			InitDataValid(0, prefix+"yd_cd1", vtEngUpOther, "0123456789");

			CountPosition = 0;
			ShowButtonImage = 1;
			ShowMsgMode=false;

		}
		break;

	case "sheet2":

		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel.|Service Provider Code|Service Provider Name";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet2_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, 			SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	prefix+"ibflag"   );
			InitDataProperty(0, cnt++ , dtCheckBox,		60,	daCenter,	true,	prefix+"del_chk"  );
			InitDataProperty(0, cnt++ , dtPopupEdit,	150,	daCenter,	true,	prefix+"vndr_seq" , 	false,	"", 		dfNone, 		0,			false,		true, 6);
			InitDataProperty(0, cnt++ ,  dtData,		50,	daLeft,		true, 	prefix+"vndr_lgl_eng_nm"  , 	false,	"", 		dfNone, 		0,	false,	false); 
			InitDataValid(0, prefix+"vndr_seq", vtNumericOnly);
			CountPosition = 0;
			ShowButtonImage = 1;
			ShowMsgMode=false;
		}
		break;

	case "sheet3":
		with (sheetObj) {
			// 높이 설정
			style.height = 326;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "Status|Seq.|Account Code|ST|Cost Code|Description|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet3_";

			//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtSeq,		50,	daCenter,	true,		"" );
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	prefix+"acct_cd", 	false,	"", dfNone, 0,	false,	true);
			InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	true,	prefix+"chk" );
			InitDataProperty(0, cnt++ , dtData,		155,	daLeft,		true,	prefix+"lgs_cost_cd", 	false,	"", dfNone, 0,	false,	true);
			InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,	prefix+"lgs_cost_full_nm", 	false,	"", dfNone, 0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,	100,	daLeft,		true,	prefix+"charge_type", 	false,	"", dfNone, 0,	false,	false);


			CountPosition = 0;
			ShowMsgMode=false;

		}
		break;

	}
}

function doSearch(){
	var formObject = document.form;
	doActionIBSheet( sheetObjects[0], formObject,IBSEARCH);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet3_" );
	
	switch(sAction) {
		case IBSEARCH:      //조회
			sheetObjects[0].WaitImageVisible = false;
			sheetObjects[1].WaitImageVisible = false;
			sheetObjects[2].WaitImageVisible = false;
			ComOpenWait(true);
		
			formObj.f_cmd.value = SEARCH02;//2번으로 .. 
			var sXml = sheetObjects[2].GetSearchXml("VOP_PSO_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		
			var comboItems = ComGetEtcData(sXml, "lane");
			var comboItems1= "";
			var comboItems2= "";
		
			if ( !comboItems.length ) {
				var comboItem = comboItems.split(",");
				comboItems1 = comboItem[0];
				comboItems2 = comboItem[1]; 		
			} else {
				comboItems = comboItems.split("|");
				for (var i = 0 ; i < comboItems.length ; i++) {
					var comboItem = comboItems[i].split(",");
					if( i == 0 ){
						comboItems1 = comboItem[0];
						comboItems2 = comboItem[1]; 
					} else {
						comboItems1 = comboItems1 + "|" +comboItem[0];
						comboItems2 = comboItems2 + "|" +comboItem[1]; 
					}	
				}   		
			}
		
			sheetObj.InitDataCombo(0,aryPrefix[0]+"yd_cd2", comboItems1, comboItems2);
		
			formObj.f_cmd.value = SEARCH;//COMBO
			var sXml = sheetObjects[2].GetSearchXml("VOP_PSO_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			for(var i = 0; i < arrXml.length; i++){ 
				//					sheetObjects[i].Redraw = false;    
				if(i < 2) {
					sheetObjects[i].WaitImageVisible = false;	
				}  
				sheetObjects[i].LoadSearchXml(arrXml[i]); 
		
		//		sheetObjects[i].Redraw = true; 
			}
			ComOpenWait(false);
			
			gf_SetHeadCheck(sheetObjects[2], "0", "sheet3_chk");
		break;
		
		case IBSAVE:        //저장
			sheetObj.ShowDebugMsg = false;
			formObj.f_cmd.value = MULTI;
		
			isDup = validateForm(sheetObj,formObj,sAction);
		
			if( !isDup ) return;
			
			ComOpenWait(true);
			sheetObjects[0].WaitImageVisible = false;
			sheetObjects[1].WaitImageVisible = false;
			sheetObjects[2].WaitImageVisible = false;
			
			//[2009.08.17:jmh] : ComGetSaveString(sheetObjs, bUrlEncode, allSave, col) default ComGetSaveString(sheetObjs, true, false, -1)
			//var sParam = ComGetSaveString(sheetObjects);
			//모든 데이터를 서버로 전송한다.
			var sParam = ComGetSaveString(sheetObjects, true, true, -1);
		
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			var sXml = sheetObjects[2].GetSaveXml("VOP_PSO_0001GS.do", sParam);
			sheetObjects[2].LoadSaveXml(sXml);
			
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);	//재조회
			
			sheetObjects[0].Redraw = true; 
			sheetObjects[1].Redraw = true; 
			sheetObjects[2].Redraw = true; 
			ComOpenWait(false);
			
		break;

	}
} 



function valid() {
	var Row = sheetObjects[0].ColValueDup(2);

	if( Row != -1 || sheetObjects[0].CellValue(sheetObjects[0].LastRow, 3) == "" ){
		//alert("중복된 코드가 있습니다.");
		return false;    	  		
	}	
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	with(formObj){
		var temp = sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_yd_cd1")+sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_yd_cd2");
		var Row = -1;

		for( var i=sheetObjects[0].HeaderRows ; i < sheetObjects[0].LastRow ; i++ ) {
			if( temp == sheetObjects[0].CellValue( i, "sheet1_yd_cd1")+sheetObjects[0].CellValue(i, "sheet1_yd_cd2") && sheetObjects[0].CellValue( i, "sheet1_ibflag") != "D" )
				Row = i;
		}	

		if( sheetObjects[0].RowCount > 0 ) {
			if(sheetObjects[0].CellValue(sheetObjects[0].LastRow, 3) == "" ){
				ComShowCodeMessage('PSO00001','');
				return false;    	  		
			} else if ( Row != "" && Row != "-1" ){
				ComShowCodeMessage('PSO00002','');
				return false;       	  		
			}
		}	

		//Service Provider Code 중복체크
		temp = sheetObjects[1].CellValue(sheetObjects[1].LastRow, 2);
		for( var i=sheetObjects[1].HeaderRows ; i < sheetObjects[1].LastRow ; i++ ) {
			if( temp == sheetObjects[1].CellValue( i, 2) && sheetObjects[1].CellValue( i, "sheet2_ibflag") != "D" )
				Row = i;
		}	

		//Service Provider Name 입력체크
		if( sheetObjects[1].RowCount > 0 ) {
			if(sheetObjects[1].CellValue(sheetObjects[1].LastRow, 3) == "" && sheetObjects[1].CellValue(sheetObjects[1].LastRow, 0) != "D"  ){
				ComShowCodeMessage('PSO00001','');
				return false;       	  		
			} else if ( Row != "" && Row != "-1" ){
				ComShowCodeMessage('PSO00002','');
				return false;      	  		
			}
		}	
	}
	return true;
}

/**[2009.08.17:jmh]
 * 화면 로딩시 조회 
 */
function sheet1_OnLoadFinish(sheetObj){
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet1_";

	switch (sheetObj.ColSaveName(Col)) {
	case prefix + "yd_cd1" :
		var sUrl = "/hanjin/VOP_VSK_0043.do?op=0043";
		var rVal = ComOpenPopupWithTarget(sUrl, 422, 490, "", "0,0", true);
		if(rVal != undefined){
			if(rVal != "EGSUZ" && rVal != "PAPAC"){	
				sheetObj.CellValue2(sheetObj.SelectRow, 2) = rVal;
				selectYard( Row,Col , rVal);
			} else{
				ComShowCodeMessage("PSO00040", "[EGSUZ or PAPAC]");	//It is not permitted to input 'EGSUZ' or 'PAPAC'.
			}
		}
		break;
	}
}


/**
 * IBSheet Popup Event
 */
function sheet2_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet2_";

	switch (sheetObj.ColSaveName(Col)) {
	case prefix + "vndr_seq" :
		ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 420, 'setPrntUsrRoleCd', '0,0', true, false, Row, Col, 0);
		break;
	}
}


function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
	var sheetObject = sheetObjects[1];
	var prefix = "sheet2_"
		sheetObject.CellValue(row,prefix+"vndr_seq")= aryPopupData[0][1];
	sheetObject.CellValue(row,prefix+"vndr_lgl_eng_nm")= aryPopupData[0][2];
}





/**
 * IBSheet OnAfterEdit Event
 */
function selectYard( Row,Col , yardValue) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var prefix = "sheet1_";

	formObj.f_cmd.value = SEARCHLIST;//2번으로 .. 
	var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
	param = param + "&yd_cd1=" + yardValue; 

	//2번으로 .. 
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0001GS.do", param );

	var comboItems = ComGetEtcData(sXml, "lane");
	comboItems1= "";
	comboItems2= "";

	//존재하지 않는 콤보코드
	if( comboItems == "" ){
		sheetObj.CellComboItem( Row, Col+1 , " |", " |", 0);
		ComShowCodeMessage('PSO00014','');
		sheetObj.CellValue2(Row, prefix+"yd_cd1") = "";
		sheetObj.CellValue2(Row, prefix+"yd_cd2") = "";
		sheetObj.SelectCell( Row , prefix+"yd_cd1" , true);
		return;
	}

	if ( !comboItems.length ) {
		var comboItem = comboItems.split(",");
		comboItems1 = comboItem[0];
		comboItems2 = comboItem[0]+"\t"+comboItem[1]; 		
	} else {
		comboItems = comboItems.split("|");
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(",");
			if( i == 0 ){
				comboItems1 = comboItem[0];
				comboItems2 = comboItem[0]+"\t"+comboItem[1]; 
			} else {
				comboItems1 = comboItems1 + "|" +comboItem[0];
				comboItems2 = comboItems2 + "|" +comboItem[0]+"\t"+comboItem[1]; 
			}	
		}   		
	}

	if( comboItems1.trim() == undefined )
		comboItems1 = "";

	if( comboItems2.trim() == undefined )
		comboItems2 = "";

	sheetObj.CellComboItem(Row, Col+1 , comboItems2, comboItems1, 0);
	sheetObj.SelectCell( Row , Col+1 , true);
}	

/**
 * IBSheet OnKeyUp Event
 */
function sheet1_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){
	var prefix = sheetObj.id + "_";
	var formObj = document.form;

	if(Col == 2){
		var isEditableCell = sheetObj.CellEditable(Row, Col);
		if(!isEditableCell){
			return;
		}
		
		var tempVal = sheetObj.EditValue;

		if(tempVal.length == 5){
			if(tempVal == "EGSUZ" || tempVal == "PAPAC"){
				ComShowCodeMessage("PSO00040", "[EGSUZ or PAPAC]");	//It is not permitted to input 'EGSUZ' or 'PAPAC'.
				//Code 에 따른 Name 초기화
				sheetObj.CellComboItem( Row, Col+1 , " |", " |", 0);
				sheetObj.CellValue(Row, prefix + "yd_cd2") = "";	
				sheetObj.CellValue(Row, prefix + "yd_cd1") = "";
				sheetObj.SelectCell(Row, Col); 
			} else{
				selectYard(Row, Col,tempVal);
			}
		} else{
			//Code 에 따른 Name 초기화
			sheetObj.CellComboItem( Row, Col+1 , " |", " |", 0);
			sheetObj.CellValue(Row, prefix + "yd_cd2") = "";
		}
	}
}		
 
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
			 	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :
			//Data영역이 체크해제되면 헤더도 체크해제된다.
 	        ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
		break;
	}
}

/**
 * IBSheet OnChange Event
 */
function sheet2_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet2_";
	switch (sheetObj.ColSaveName(Col)) {
	case prefix + "vndr_seq" :   
		formObj.f_cmd.value = SEARCHLIST01;//2번으로 .. 
		var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
		param = param + "&vndr_seq=" + sheetObj.CellValue(Row, Col); 
		var sXml = sheetObj.GetSearchXml("VOP_PSO_0001GS.do", param );

		var items = ComGetEtcData(sXml, "vendor");
		sheetObj.CellValue2(Row,Col+1) = items;

		if( items == "" || items == undefined ){
			ComShowCodeMessage('PSO00014','');
			//alert(Row + " : " + Col + " : " + prefix+"vndr_seq" + " : " + sheetObj.ColSaveName(Col));
			//sheetObj.SelectRow = Row;
			//sheetObj.SelectCell( Row , prefix+"vndr_seq" , true);
			sheetObj.CellValue2(Row,Col) = "";    				
			sheetObj.SelectCell( Row , prefix+"vndr_seq", true  );

		}

		break;
	}
}	
 
function sheet2_OnClick(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var prefix = "sheet2_";
	sheetObj.ShowDebugMsg = false;
					 	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "del_chk" :
			//Data영역이 체크해제되면 헤더도 체크해제된다.
			ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "del_chk"));
		break;
	}
} 
 
function sheet3_OnClick(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var prefix = "sheet3_";
	sheetObj.ShowDebugMsg = false;
			 	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "chk" :
			//Data영역이 체크해제되면 헤더도 체크해제된다.
			ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, prefix + "chk"));
		break;
	}
}

/* 개발자 작업  끝 */ 