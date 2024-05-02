/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0206.js
 *@FileTitle : Formula Condition
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.02
 *@LastModifier : 박명종
 *@LastVersion : 1.0
 * 2009.06.02 박명종
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
 * @class Service Provider Help : Service Provider Help 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0206() {
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
var sheetObjects = new Array();
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var gXml = "";	//조회시
var afterSearch = false;	//조회시

var sheetObjects = new Array();
var sheetCnt = 0;
var usrOfcCd = "";/*SSO 유저의 office cd를 저장 */

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_RowAdd":
				f_AddRow();
				
				break;
				
			case "btn_Delete":
				
				//var selectRow = eval(sheetObject1.SelectRow);
				//sheetObject1.RowDelete( selectRow, false );
	
				//체크된 행 삭제
				for( var i=sheetObject1.LastRow; i>=sheetObject1.HeaderRows; i-- ) {
					if(sheetObject1.CellValue(i, "hiddencheck") == 1){
						sheetObject1.RowDelete( i, false );
					}
				}
				
				setFirstRow();
				
				
				break;

			case "btn1_Close":
				self.close();
				break;
				
			case "btn1_OK":		//저장 and 코드선택
				var aryPrefix = new Array( "sheet1_");
				formObject.f_cmd.value = MULTI;
				if(!validateForm(sheetObjects[0], formObject, IBSAVE)) return;
				/*
			     * @param {ibsheet,array} 	sheetObjs    필수,IBSheet Object 하나 또는 IBSheet Object 배열
			     * @param {string} 			bUrlEncode   선택,QueryString 인코딩여부, default=true
			     * @param {bool}    		allSave      선택,sheet 전체를 xml string으로 만들지 여부, default=false
			     * @param {int,string}  	col          선택,대상이 되는 기준 컬럼의 인덱스 또는 SaveName, default=-1
				 */
				var sParam = ComGetSaveString(sheetObjects, true, true);	//모든 rows를 전송한다.
				if (sParam == "") return;
				
				sParam += "&" + FormQueryString(formObject) + "&origin=1&" + ComGetPrefixParam(aryPrefix);	//origin: 이화면에서 생성된 condition은 1, 쌀집서 생성되면 2
				var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0206GS.do", sParam);
				var retVal = ComGetEtcData(sXml, "new_condition");
				var resultMsg = ComPsoGetMessageFromXml(sXml);
				
				if(resultMsg != ""){
					ComShowMessage(resultMsg);
					return;
				}
				
				window.returnValue = retVal;
				self.close();
	
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
			style.height = 102;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "||Condition|Object|UOM|Comparison Operator|Value|Condition ID|Condition DES|||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = "sheet1_";

			//데이터속성    [ROW, COL,  	DATATYPE,   	WIDTH, 	DATAALIGN, COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag" );
			InitDataProperty(0, cnt++,  dtCheckBox,      0,    	daCenter,  	true,   	"hiddencheck"   );
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,		prefix+"condition");
			InitDataProperty(0, cnt++ , dtCombo,	   150,		daCenter,	true,		prefix+"obj_list_no",	true);
			InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,		prefix+"uom",		true,		"",			dfNone,			0,		false,  false);
			InitDataProperty(0, cnt++ , dtCombo,	   150,		daCenter,	true,		prefix+"operator",	true);
			InitDataProperty(0, cnt++ , dtCombo,	   100,		daCenter,	true,		prefix+"obj_value",	true);
			InitDataProperty(0, cnt++ , dtHidden,	   100,		daCenter,	false,		prefix+"condid");
			InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,		prefix+"conddes");
			InitDataProperty(0, cnt++ , dtHidden,	   100,		daCenter,	true,		prefix+"obj_name");
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"line_num");
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"seq");

			InitDataCombo   (0, prefix+"obj_value", "Y|N", "Y|N");
			CountPosition=0;
			ShowButtonImage = 1
//			MultiSeletion = true;
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_");
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			param = param + "&types=" + "0206"; 
			gXml = sheetObj.GetSearchXml("VOP_PSO_0206GS.do", param );
		
			//Condition
			var comboItems = ComGetEtcData(gXml, "operator");
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
			sheetObj.InitDataCombo(0,aryPrefix[0]+"condition", comboItems2, comboItems1);
			
			//Object
			//(PSO_OBJ_CD, PSO_OBJ_CD_DSP, PSO_MEAS_UT_CD, PSO_MEAS_UT_CD_DSP, OBJ_LIST_NO)
			comboItems1 = "";	//Code -> OBJ_LIST_NO
			comboItems2 = "";	//Text -> 
			comboItems = ComGetEtcData(gXml, "objlist").split("|");
			for (var i = 0 ; i < comboItems.length ; i++) {
				var comboItem = comboItems[i].split(",");

				comboItems1 += "|" +comboItem[4];
				comboItems2 += "|" +comboItem[1] + "\t" + comboItem[3];
				
			}   		
			sheetObj.InitDataCombo(0, aryPrefix[0]+"obj_list_no", comboItems2, comboItems1);
			
			//Comparison Operator
			comboItems = ComGetEtcData(gXml, "complist");
			comboItems1= "";
			comboItems2= "";
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
			sheetObj.InitDataCombo(0,aryPrefix[0]+"operator", comboItems2, comboItems1);
			
			//조회
			if(document.form.cond_no.value != ""){
				sheetObj.LoadSearchXml(gXml);
				for(j=0; j<sheetObj.RowCount; j++){
					//[Before 2009.11.11]///
					///sheet1_OnChange(sheetObj, j+1, sheetObj.SaveNameCol("sheet1_object"));		//UOM, 정확히는 OBJ_LIST_NO를 가져오기 위해 
					///var objListNo = f_GetValueFromXMLData(gXml, j+1, "sheet1_uom");
					///sheetObj.CellValue2(j+1, "sheet1_uom") = objListNo;
					///sheet1_OnChange(sheetObj, j+1, sheetObj.SaveNameCol("sheet1_operator"));	//VALUE의 formatting을 위해
					////////////////////////
					
					//[After 2009.11.11]
					sheet1_OnChange(sheetObj, j+1, sheetObj.SaveNameCol("sheet1_obj_list_no"));		//
					sheet1_OnChange(sheetObj, j+1, sheetObj.SaveNameCol("sheet1_operator"));	//VALUE의 formatting을 위해
					
				}
				setFirstRow();
			} else{	//Add Row
				f_AddRow();
			}
			afterSearch = true;
	
		break; 
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		
			case IBSAVE:
				//
				for(i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){		
					if(i != sheetObj.HeaderRows){
						if(sheetObj.CellValue(i, "sheet1_condition") == ""){
							sheetObj.SelectCell(i, "sheet1_condition");
							ComShowCodeMessage('PSO00003', "[Condition]");
							return false;
						}
					}
				}

			break;
		}
	}

	return true;
}

/**
 * 화면 로딩시
 */
function sheet1_OnLoadFinish(sheetObj){
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);	
}


/**
* IBSheet OnAfterEdit Event
*/
function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;

	switch (sheetObj.ColSaveName(Col)) {
			
		case prefix + "obj_list_no" :	
			var arrComboText = sheetObj.GetComboInfo(Row, Col, "Text").split("|"); 
			var idx   		 = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			
			if(idx == -1){
				return;
			}
			sheetObj.CellValue2(Row, prefix + "uom") = arrComboText[idx].split("\t")[1];
			
			break;
			
		case prefix + "operator" :
			
			var opt = sheetObj.CellValue(Row, Col); 
			var code = ComTrim(f_GetValueFromXMLData(gXml, Row, prefix+"obj_value"), "'");
			sheetObj.CellValue2(Row, prefix+"obj_value") = "";
			if( opt == "=" || opt == "!="){		//Combo ('Y' or 'N')
				sheetObj.InitCellProperty(Row, prefix+"obj_value", dtCombo, daCenter,	prefix+"obj_value" , "");
				if(!afterSearch){
					sheetObj.CellValue2(Row, prefix+"obj_value") = code;
				} else{
					
				}
			} else{
				sheetObj.InitCellProperty(Row, prefix+"obj_value", dtData, daCenter,	prefix+"obj_value" , "" , dfNullFloat);
				if(!afterSearch){
					sheetObj.CellValue2(Row, prefix+"obj_value") = code;
				} else{
					sheetObj.CellValue2(Row, prefix+"obj_value") = "";
				}
			}
			break;
	}
}


/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var turl = "/hanjin/VOP_PSO_0209.do?formcond=2";

	ComOpenPopup( turl, 800, 400, 'setCondition', '0,0', true, false, Row, Col, 0);
}
 
function sheet1_OnClick(sheetObj,Row,Col,Value) {
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
			 
	switch (sheetObj.ColSaveName(Col)) {
		case "hiddencheck" :
			//Data영역이 체크해제되면 헤더도 체크해제된다.
			ComSyncAllCheck(sheetObj, Col, sheetObj.CellValue(Row, "hiddencheck"));			
		break;
	}
}

function setCondition(aryPopupData, row, col, sheetIdx){
	var sheetObject = sheetObjects[sheetIdx];

	var prefix = "sheet"+(sheetIdx+1)+"_";

	sheetObject.CellValue2(row,prefix+"condid")= aryPopupData[0][1];
	sheetObject.CellValue2(row,prefix+"conddes")= aryPopupData[0][2];
}

function setFirstRow(){
	if(sheetObjects[0].LastRow >= sheetObjects[0].HeaderRows){	//Rows가 존재하면
		//sheetObjects[0].InitCellProperty(Row, Col, [DataType], [DataAlign], [SaveName], [CalcuLogic], [DataFormat], [PointCount], [EditLen]) 
		sheetObjects[0].InitCellProperty(sheetObjects[0].HeaderRows, "sheet1_condition", dtData);
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_condition") = "";
		sheetObjects[0].CellEditable(sheetObjects[0].HeaderRows, "sheet1_condition") = false; 
	}	
}

function f_AddRow(){
	var formObject = document.form;
	
	if( sheetObjects[0].RowCount > 0 ) {
		if( sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_obj_list_no") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow , "sheet1_obj_list_no" , true);
			return;
		} else if( sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_uom") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow , "sheet1_uom" , true);
			return;
		} else if (sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_operator") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow , "sheet1_operator" , true);
			return;						
		} else if (sheetObjects[0].CellValue(sheetObjects[0].LastRow, "sheet1_obj_value") == "" ) {
			ComShowCodeMessage('PSO00003');
			sheetObjects[0].SelectCell(sheetObjects[0].LastRow , "sheet1_obj_value" , true);
			return;						
		}	
		
	}

	sheetObjects[0].DataInsert(-1);
	var selectRow = eval(sheetObjects[0].SelectRow);
	sheetObjects[0].CellValue2(sheetObjects[0].LastRow, "sheet1_line_num") = eval(sheetObjects[0].LastRow)*10;   
	sheetObjects[0].CellValue2(sheetObjects[0].LastRow, "sheet1_seq") = formObject.seq.value; 
	sheetObjects[0].CellValue2(sheetObjects[0].LastRow, "sheet1_condition") = ""; 
	sheetObjects[0].CellValue2(sheetObjects[0].LastRow, "sheet1_operator") = ""; 
	sheetObjects[0].CellValue2(sheetObjects[0].LastRow, "sheet1_obj_value") = ""; 

	sheetObjects[0].CellValue2(sheetObjects[0].LastRow, "sheet1_obj_list_no") = "";

	setFirstRow();	
}

/**
*  Xml에서 데이타 가져오기 
*    savename 복수일경우 | 사용.
* @param xmlStr
* @param cRow : from 1
* @param savename
* @return value   ex)복수시 리턴값  aaa|dddd
* @author jkc
*/
function f_GetValueFromXMLData(xmlStr, cRow, savename)  {
	if (xmlStr == null || xmlStr == ""  ) {
		return;
	}
	if (savename  == null || savename == ""  ) {
		return;
	}
	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);

		if (dataNode == null || dataNode.attributes.length < 3) {
			return "";
		}
		var TOTAL_ROWS = eval( dataNode.getAttribute("TOTAL") );

		if( TOTAL_ROWS == "0" ){
			return "";
		}
		var col = dataNode.getAttribute("COLORDER");

		var colArr = col.split("|");

		var sep = dataNode.getAttribute("COLSEPARATOR");
		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var colListIdx = Array();
		var arrText = savename.split("|");

		for (var i = 0; i < colArr.length; i++) {
			for (var j = 0; j < arrText.length; j++) {
				if ( colArr[i] == arrText[j] && colArr[i] != "" ) {
					colListIdx[j] = i;
				}
			}
		}

		if(  cRow   >  TOTAL_ROWS ){
			return "";
		}
		var arrData = dataChildNodes[cRow-1].firstChild.nodeValue.split(sep);

		var trData = "";
		for (var j = 0; j < colListIdx.length; j++) {
			if( j < colListIdx.length-1){
				trData += arrData[colListIdx[j]]+"|";
			}else{
				trData += arrData[colListIdx[j]];   
			}

		}
		return trData;
	} catch (err) {
		ComFuncErrMsg(err.message);
	}               
} 


/**
 *  sXml에서 MESSAGE 내용을 추출 
 * @param sXml
 * @return Sring MESSAGE
 * @author jkc
 */
function ComPsoGetMessageFromXml(sXml){
    if ( sXml == null  || sXml == "" ) return;

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(sXml);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
      
        if(msgNode == null) return "";

        return msgNode.firstChild.nodeValue;
    } catch(err) { ComFuncErrMsg(err.message); }
} 

/* 개발자 작업  끝 */