/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : esm_bkg_0244.js
 *@FileTitle :  Also Notify Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.16
 *@LastModifier : 김수현
 *@LastVersion : 1.0
 * 2016.02.16 김수현
 * 1.0 Creation
 =========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt	 = 0;

var codeMaxLength = 6;	//Customer Code값 체크 시 국가코드 제외한 코드 6자리
var chars 		  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";	//문자 체크

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	var formObject = document.form;

	var sheetObject1 = sheetObjects[0];

	try {

		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;

			case "btn_RowAdd":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;

			case "btn_Delete":
				if(ComShowCodeConfirm('BKG95003', 'delete')){
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
				}
				break;

			case "btn_New":
				document.form.reset();
				sheetObject1.RemoveAll();
				break;

			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
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

function setSheetObject(sheet_obj){

	sheetObjects[sheetCnt++] = sheet_obj;

}

function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);

		ComEndConfigSheet(sheetObjects[i]);

	}

	//form 컨트롤
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

		case "sheet1":
			with (sheetObj) {

				// 높이 설정
				style.height = 402;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);

				var HeadTitle1 =  "|sel. |S/C Number|Customer code|POD";
					HeadTitle1 += "|A.Notify #1|A.Notify #1" ;
					HeadTitle1 += "|A.Notify #2|A.Notify #2" ;
					HeadTitle1 += "|Last Updated By";

				var HeadTitle2 =  "|sel. |S/C Number|Customer code|POD";
					HeadTitle2 += "|Fax|Email Address";
					HeadTitle2 += "|Fax|Email Address";
					HeadTitle2 += "|Last Updated By";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW,   COL,    DATATYPE,		WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,		cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
				InitDataProperty(0,		cnt++ , dtCheckBox,		50,		daCenter,		true,		"Sel",				false,		"",			dfNone,		0,			true,		true,   0);	// sel
				InitDataProperty(0,		cnt++ , dtData,			105,	daCenter,		true,		"sc_no",			true,		"",			dfNone,		0,			false,		true,	9);	// s/c number
				InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"antfy_cust_cd",	false,		"",			dfNone,		0,			false,		true,	8);	// customer code
				InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"pod_cd",			false,		"",			dfNone,		0,			false,		true,	5);	// pod
				InitDataProperty(0,		cnt++ , dtData,			95,		daLeft,			true,		"a1_fax_no",		false,		"",			dfNone,		0,			true,		true,	13);// a1.fax
				InitDataProperty(0,		cnt++ , dtData,			140,	daLeft,			true,		"a1_cntc_eml",		false,		"",			dfNone,		0,			true,		true,	50);// a1.email
				InitDataProperty(0,		cnt++ , dtData,			95,		daLeft,			true,		"a2_fax_no",		false,		"",			dfNone,		0,			true,		true,	13);// a2.fax
				InitDataProperty(0,		cnt++ , dtData,			140,	daLeft,			true,		"a2_cntc_eml",		false,		"",			dfNone,		0,			true,		true,	50);// a2.email
				InitDataProperty(0,		cnt++ , dtData,			100,	daCenter,		true,		"upd_usr_id",		false,		"",			dfNone,		0,			false,		false,	0);	// last updated by

				CountPosition = 0;

				InitDataValid(0, "sc_no",  vtEngUpOther, "1234567890");			//입력제한 : 영어대문자+숫자
				InitDataValid(0, "antfy_cust_cd",  vtEngUpOther, "1234567890");	//입력제한 : 영어대문자+숫자
				InitDataValid(0, "pod_cd", vtEngUpOther);						//입력제한 : 영어대문자

				InitDataValid(0,  "a1_fax_no", vtNumericOther, "-,");
				InitDataValid(0,  "a2_fax_no", vtNumericOther, "-,");

			}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		//조회
		case IBSEARCH:

			if(validateForm(sheetObj,formObj,sAction)) {

				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0244GS.do",  FormQueryString(formObj));
				ComOpenWait(false);

			}

			break;

		//등록
		case IBINSERT:

			if(validateForm(sheetObj,formObj,sAction)) {

				var vRow = sheetObj.DataInsert(-1);

				var fScNo		 = formObj.sc_no.value;
				var fCustomerCd  = formObj.antfy_cust_cd.value;
				var fPod 		 = formObj.pod_cd.value;

				sheetObj.CellValue2(vRow, "sc_no")			= fScNo;
				sheetObj.CellValue2(vRow, "antfy_cust_cd")	= (fCustomerCd == "" ? "*" : fCustomerCd);
				sheetObj.CellValue2(vRow, "pod_cd") 		= (fPod == "" ? "*" : fPod);
				sheetObj.CellValue2(vRow, "upd_usr_id") 	= formObj.usr_id.value;

			}

			break;

		//삭제
		case IBDELETE:
			ComRowHideDelete(sheetObj,"Sel");

			break;

		//저장
		case IBSAVE:

			if(!validateForm(sheetObj,formObj,sAction)) break;

			var sParamSheet = sheetObj.GetSaveString();
			if (sParamSheet == "") return;


			ComOpenWait(true);

			formObj.f_cmd.value = MULTI;

			var sParam = ComSetPrifix(sParamSheet, "sheet1_");
			sParam += "&" + FormQueryString(formObj);

			var sXml = sheetObj.GetSaveXml("ESM_BKG_0244GS.do", sParam);

			if (ComGetEtcData(sXml, "dupFlag") == "Y") {

				var rtnScNum	= ComGetEtcData(sXml, "scNo");
				var rtnCustCd	= ComGetEtcData(sXml, "antfyCustCd");
				var rtnPodCd	= ComGetEtcData(sXml, "podCd");

				ComShowCodeMessage("BKG95106","S/C No:"+rtnScNum+" ,Cutomer Code:"+rtnCustCd+" ,POD:"+rtnPodCd);

				ComOpenWait(false);
				break;
			}

			sheetObj.LoadSaveXml(sXml);
			ComOpenWait(false);

			break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	//조회조건 값
	var scNo 	= formObj.sc_no.value;
	var custCd	= formObj.antfy_cust_cd.value;
	var dupKey  = "0";

	with(formObj){

		//공통 체크
		/*if (scNo.length == 0) {
			ComShowCodeMessage("BKG00104","S/C Number");
			ComSetFocus(formObj.sc_no);
			return false;
		}*/

		switch(sAction) {

			case IBINSERT:

				/*if (scNo.length == 0) {
					ComShowCodeMessage("BKG00104","S/C Number");
					ComSetFocus(formObj.sc_no);
					return false;
				}*/

			break;

			case IBSAVE:

				//sheet에서 수정된값이 없는경우
				if (ComIsModifiedSheets(sheetObj) == false) {
					ComShowCodeMessage("BKG00743");
					return false;
				}

				//수정, 입력 시 데이터 체크
				for (var i=0; i <= sheetObj.RowCount; i++) {

					if (sheetObj.RowStatus(i+1) == "U" || sheetObj.RowStatus(i+1) == "I") {

						var chkScNo		   = sheetObj.CellValue(i+1,"sc_no");
						var chkAntfyCustCd = sheetObj.CellValue(i+1,"antfy_cust_cd");
						var chkPodCd	   = sheetObj.CellValue(i+1,"pod_cd");
						var chkA1CntcEml   = sheetObj.CellValue(i+1,"a1_cntc_eml");
						var chkA2CntcEml   = sheetObj.CellValue(i+1,"a2_cntc_eml");

						//---------------------------------------------------------------
						// S/C No 체크
						//---------------------------------------------------------------
						if(chkScNo == "" || chkScNo == null || chkScNo.length == 0){
							ComShowCodeMessage("BKG00104","S/C Number");
							sheetObj.SelectCell(i+1,"sc_no");
							return false;
						}else if(chkScNo.length < 9){
							ComShowCodeMessage("BKG40105", "S/C Number");
							sheetObj.SelectCell(i+1,"sc_no");
							return false;
						}

						//---------------------------------------------------------------
						// Customer Code 코드 포맷 체크
						//---------------------------------------------------------------
						if (chkAntfyCustCd != "*" && chkAntfyCustCd.length == 8) {

							var countryCd  = chkAntfyCustCd.substring(0,2);
							var etcCd	   = chkAntfyCustCd.substring(2,chkAntfyCustCd.length);

							//국가코드는 문자열인지 체크
							for (var inx = 0; inx < countryCd.length; inx++) {
								if (chars.indexOf(countryCd.charAt(inx)) == -1){
									ComShowCodeMessage("BKG00187");
									sheetObj.SelectCell(i+1,"antfy_cust_cd");
									return false;
								}
							}

							//숫자인지 체크
							if(isNaN(etcCd) == true){
								ComShowCodeMessage("BKG00187");
								sheetObj.SelectCell(i+1,"antfy_cust_cd");
								return false;
							}

						}

						//---------------------------------------------------------------
						// Customer Code 자릿수 체크
						//---------------------------------------------------------------
						if (chkAntfyCustCd != "*" && chkAntfyCustCd.length < 8) {
							ComShowCodeMessage("BKG40105", "antfy_cust_cd");
							sheetObj.SelectCell(i+1,"antfy_cust_cd");
							return false;
						}

						//---------------------------------------------------------------
						// POD 자릿수 체크
						//---------------------------------------------------------------
						if (chkPodCd != "*" && chkPodCd.length < 5) {
							ComShowCodeMessage("BKG40105", "pod_cd");
							sheetObj.SelectCell(i+1,"pod_cd");
							return false;
						}

						//---------------------------------------------------------------
						// 키값 중복 체크 (S/C No, Cutomer Code, POD)
						//---------------------------------------------------------------
						dupKey = sheetObj.ColValueDup("sc_no|antfy_cust_cd|pod_cd",false);

						var keyScNo			= sheetObj.CellValue(i+1,"sc_no");
						var keyAntfyCustCd	= sheetObj.CellValue(i+1,"antfy_cust_cd");
						var keyPodCd		= sheetObj.CellValue(i+1,"pod_cd");

						if(dupKey >= 0){
							ComShowCodeMessage("BKG00764","'S/C No:"+keyScNo+" ,Cutomer Code:"+keyAntfyCustCd+" ,POD:"+keyPodCd+"'");
							sheetObj.SelectCell(i+1,"pod_cd");
							return;
						}

						//---------------------------------------------------------------
						// A1 Email 입력시 포맷 체크
						//---------------------------------------------------------------
						if (chkA1CntcEml.length > 0){
							if(!BkgIsEmailAddr(chkA1CntcEml)){
								ComShowCodeMessage("BKG00366");
								sheetObj.SelectCell(i+1,"a1_cntc_eml");
								return;
							}
						}

						//---------------------------------------------------------------
						// A2 Email 입력시 포맷 체크
						//---------------------------------------------------------------
						if (chkA2CntcEml.length > 0){
							if(!BkgIsEmailAddr(chkA2CntcEml)){
								ComShowCodeMessage("BKG00366");
								sheetObj.SelectCell(i+1,"a2_cntc_eml");
								return;
							}
						}
					}
				}

				break;
		}
	}

	return true;
}

/**
 * 그리드 편집 상태 전에 호출
 */
function sheet1_OnBeforeEdit(sheetObj, row, col, Value){

	with (sheetObj) {

		var sheet1CustCd = CellValue(row ,"antfy_cust_cd");	//sheet1 Customer Code
		var sheet1Pod	 = CellValue(row ,"pod_cd");		//sheet1 POD

		if (ColSaveName(col) == "antfy_cust_cd"){
			if(sheet1CustCd == "*" && sheet1CustCd.length == 1){
				CellValue2(row ,"antfy_cust_cd") = "";
			}
		}

		if (ColSaveName(col) == "pod_cd"){

			if(sheet1Pod == "*" && sheet1Pod.length == 1){
				CellValue2(row ,"pod_cd") = "";
			}
		}

	}
}

/**
 * 그리드 편집 상태 후에 호출
 */
function sheet1_OnAfterEdit(sheetObj, row, col){

	with(sheetObj){

		var sheet1CustCd = CellValue(row ,"antfy_cust_cd");	//sheet1 Customer Code
		var sheet1Pod	 = CellValue(row ,"pod_cd");		//sheet1 POD

		if (ColSaveName(col) == "antfy_cust_cd"){
			if(sheet1CustCd == "" && sheet1CustCd.length == 0){
				CellValue2(row ,"antfy_cust_cd") = "*";
			}
		}

		if (ColSaveName(col) == "pod_cd"){
			if(sheet1Pod == "" && sheet1Pod.length == 0){
				CellValue2(row ,"pod_cd") = "*";
			}
		}

	}
}
/**
 * Sheet1 변경 이벤트 발생 처리<br>
 *
 * @param {ibsheet} sheetObj 필수. Sheet ID
 * @param {int}     Row      필수. Sheet Row
 * @param {int}     Col      필수. Sheet Col
 * @param {string}  Value    필수. Sheet 셀값
 * @return 없음
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {

	with(sheetObj) {

		var dupKey = "0";

		//---------------------------------------------------------------
		// Customer Code 입력시 키값 중복 체크
		//---------------------------------------------------------------
		if (ColSaveName(Col) == "antfy_cust_cd"){

			if(Value.length > 2){

				var customerCd = "";
				var countryCd  = Value.substring(0,2);
				var etcCd	   = Value.substring(2,Value.length);

				//국가코드는 문자열인지 체크
				for (var inx = 0; inx < countryCd.length; inx++) {
					if (chars.indexOf(countryCd.charAt(inx)) == -1){
						ComShowCodeMessage("BKG00187");
						SelectCell(Row,Col);
						return;
					}
				}

				//국가코드제외한 코드가 6자리가아닐경우 자릿수 셋팅
				if(etcCd.length < codeMaxLength){

					//숫자인지 체크
					if(isNaN(etcCd) == true){
						ComShowCodeMessage("BKG00187");
						SelectCell(Row,Col);
						return;
					}

					var tmpCd = "";

					for(var i = 0; i < codeMaxLength - etcCd.length; i++ ){
						tmpCd += "0";
					}

					etcCd = tmpCd + etcCd;
				}

				customerCd = countryCd + etcCd;

				CellValue2(Row, "antfy_cust_cd") = customerCd;

			}

			//key값 중복 체크
			dupKey = ColValueDup("sc_no|antfy_cust_cd|pod_cd",false);

			var keyScNo			= CellValue(Row, "sc_no");
			var keyAntfyCustCd	= CellValue(Row, "antfy_cust_cd");
			var keyPodCd		= CellValue(Row, "pod_cd");

			if(dupKey >= 0){
				ComShowCodeMessage("BKG00764","'S/C No:"+keyScNo+" ,Cutomer Code:"+keyAntfyCustCd+" ,POD:"+keyPodCd+"'");
				SelectCell(Row,Col);
				return;
			}

		}

		//---------------------------------------------------------------
		// POD 입력시 키값 중복 체크
		//---------------------------------------------------------------
		if (ColSaveName(Col) == "pod_cd"){

			//key값 중복 체크
			dupKey = ColValueDup("sc_no|antfy_cust_cd|pod_cd",false);

			var keyScNo			= CellValue(Row, "sc_no");
			var keyAntfyCustCd	= CellValue(Row, "antfy_cust_cd");
			var keyPodCd		= CellValue(Row, "pod_cd");

			if(dupKey >= 0){
				ComShowCodeMessage("BKG00764","'S/C No:"+keyScNo+" ,Cutomer Code:"+keyAntfyCustCd+" ,POD:"+keyPodCd+"'");
				SelectCell(Row,Col);
				return;
			}

		}

		//---------------------------------------------------------------
		// A1 Email 입력시 포맷 체크
		//---------------------------------------------------------------
		if (ColSaveName(Col) == "a1_cntc_eml"){
			if(CellValue(Row,Col).length > 0 && !BkgIsEmailAddr(CellValue(Row,Col))){
				ComShowCodeMessage("BKG00366");
				SelectCell(Row, Col);
				return;
			}
		}

		//---------------------------------------------------------------
		// A2 Email 입력시 포맷 체크
		//---------------------------------------------------------------
		if (ColSaveName(Col) == "a2_cntc_eml"){
			if(CellValue(Row,Col).length > 0 && !BkgIsEmailAddr(CellValue(Row,Col))){
				ComShowCodeMessage("BKG00366");
				SelectCell(Row, Col);
				return;
			}
		}

	}
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){

	with(sheetObj){

		// "Delete"키 입력 시
		if(KeyCode == '46'){
			var sheet1CustCd = CellValue(Row ,"antfy_cust_cd");	//sheet1 Customer Code
			var sheet1Pod	 = CellValue(Row ,"pod_cd");		//sheet1 POD

			if (ColSaveName(Col) == "antfy_cust_cd"){
				if(sheet1CustCd == "" && sheet1CustCd.length == 0){
					CellValue2(Row ,"antfy_cust_cd") = "*";
				}
			}

			if (ColSaveName(Col) == "pod_cd"){
				if(sheet1Pod == "" && sheet1Pod.length == 0){
					CellValue2(Row ,"pod_cd") = "*";
				}
			}
		}
	}

}

/**
 * 초기화 작업 : 이벤트를 등록
 */
function initControl() {

	axon_event.addListenerForm('keypress', 'objKeyPress', form);

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

}

function objKeyPress() {

	var objName = event.srcElement.name;
	var formObj = document.form;

	switch(objName) {
		case "sc_no":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "antfy_cust_cd":
			ComKeyOnlyAlphabet('uppernum','42');
			break;
		case "pod_cd":
			ComKeyOnlyAlphabet('uppernum','42');
			break;

    }
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {

	if (ErrMsg == "") {

		ComBkgSaveCompleted();

		doActionIBSheet(sheetObj,document.form,IBSEARCH);
  	}
}
