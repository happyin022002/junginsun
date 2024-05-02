/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1146.js
 *@FileTitle : ESM_BKG_1146
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.24
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.05.24 김보배
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
 * @class ESM_BKG_1146 : ESM_BKG_1146 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1146() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI02);
			break;
			
		case "btn_Select":
			doActionIBSheet(sheetObject, formObject, MULTI01);
			break;

		case "btn_Close":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;

		case "btn_RowAdd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
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
 * @param sheet_obj IBSheet Object
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

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

		// exs b/l inquiry화면이 부모일 경우만 save , row add 버튼 보이게
		if(form.pgm_no.value == "") {
			form.document.getElementById("tb_RowAdd").style.display="none";
			form.document.getElementById("td_save").style.display="none";
		} else {
			form.document.getElementById("tb_RowAdd").style.display="inline";
			form.document.getElementById("td_save").style.display="inline";
		}
	}
	initControl();

}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;

	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 250;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = " |Sel.|bl_no|RCV DT|STATUS|mf_no|ref_gds_itm_nm|PREV_DOC_NO|SubPlace|FIXED";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,	"ibflag")
			InitDataProperty(0, cnt++, dtDummyCheck,	 30, daCenter, false,	"chk",			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	100, daCenter, false,	"bl_no", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		150, daCenter, false,	"cre_dt", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		 60, daCenter, false,	"msg_func_id", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	100, daCenter, false,	"mf_no", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	100, daCenter, false,	"ref_gds_itm_nm", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		150, daCenter, false,	"prev_doc_nos", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,		150, daCenter, false,	"pre_vsl_dchg_yd_nm",false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,	100, daCenter, false,	"fixed",			false, "", dfNone, 0, true, true);
			
			SelectHighLight= false;
		}
		break;

	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBINSERT: // 입력
		
		sheetObj.DataInsert(-1);
		var nowRow = sheetObj.SelectRow;
      	sheetObj.CellValue2(nowRow, "msg_func_id") = "M";
      	sheetObj.CellEditable(nowRow, "msg_func_id") = false;
      	sheetObj.CellEditable(nowRow, "cre_dt") = false;
		break;

		
	case IBSEARCH: // 조회

		formObj.f_cmd.value = SEARCH;
		formObj.cnt_cd.value = formObj.pol_cd.value.substr(0,2);
		
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		

		sheetObj.DoSearch("ESM_BKG_1146GS.do", FormQueryString(formObj));

		ComOpenWait(false);
		break;

		
	case MULTI01: // SELECT
		
		if (!validateForm(sheetObj, formObj, sAction))	return;

		if(form.pgm_no.value == "") {
			// 부모가 EXS 가 아닌 경우
			var obj = new Object(); 
			
			for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i,"chk") == "1" || sheetObj.CellValue(i,"chk") == "Y") {
					obj.cd = sheetObj.CellValue(i, "mf_no");
					obj.nm = sheetObj.CellValue(i, "ref_gds_itm_nm");
					break;
				}
			}
			
			if(obj.cd != "") {
				window.returnValue = obj;
				self.close();
			}
			
		} else {
			// 부모가 EXS
			for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i,"chk") == "1" || sheetObj.CellValue(i,"chk") == "Y") {
					sheetObj.RowStatus(i) = "I";
				} else {
					sheetObj.RowStatus(i) = "";
				}
			}
			
			formObj.f_cmd.value = MULTI01;
			
			if(!ComShowCodeConfirm("COM12158", "[Prev. Doc No]")) {
	        	return false;
	        }
			
			var sParam = sheetObjects[0].GetSaveString();
	//		alert("sParam : " + sParam);
			
			sParam += "&" + FormQueryString(formObj);  
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_1146GS.do", sParam);
			var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	
			if (state == "S") {
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
//				ComShowCodeConfirm("BKG00102");
				ComShowCodeMessage("BKG00102");
				
				
			}	
			ComOpenWait(false);
		}

		break;
		
		
	case MULTI02: // SAVE (Prev. Doc Append)
		
		if (!validateForm(sheetObj, formObj, sAction))	return;
		
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			if(sheetObj.RowStatus(i) == "I"){
				if (sheetObj.CellValue(i,"prev_doc_nos") != "") {
					sheetObj.CellValue(i, "mf_no") = sheetObj.CellValue(i,"prev_doc_nos").substring(0, 11);
					sheetObj.CellValue(i, "ref_gds_itm_nm") = sheetObj.CellValue(i,"prev_doc_nos").substring(11);
					sheetObj.CellValue(i, "bl_no") = formObj.bl_no.value;
				}else {
					sheetObj.RowStatus(i) = "";
				}
			} else {
				sheetObj.RowStatus(i) = "";
			}
		}

		// 1. Prev. Doc 수신 테이블에 insert 작업
		formObj.f_cmd.value = MULTI02;

        if(!ComShowCodeConfirm("BKG00498", "[Prev. Doc No]")) {
        	return false;
        }
		var sParam = sheetObjects[0].GetSaveString();
//		alert("sParam : " + sParam);
		
		sParam += "&" + FormQueryString(formObj);  
		
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1146GS.do", sParam);
		var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		ComOpenWait(false);
		
		if (state == "S") {
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		
		doActionIBSheet(sheetObj, document.form, IBSEARCH);

		break;
		
	case COMMAND01:
		if(form.pgm_no.value == "") {
			self.close();
		}
		
		if(!comPopupOK(sheetObj, formObj, sAction)) return false;
		
		break;
	}
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {

	case IBSEARCH: // 조회

		break;
	
		
	case MULTI01: // Prev. Doc Select
		
		// empty row 삭제
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			
			if (sheetObj.CellValue(i,"prev_doc_nos") == "") {
				sheetObj.RowHidden(i) = "true";
			} 
		} 
		
		// 중복 체크
		var allListPreDoc = "";
		var addListPreDoc = "";
		var sameFlag = false;
		
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
	     	if(sheetObj.CellValue(i,"prev_doc_nos") == "") continue;
			
			allListPreDoc = sheetObj.CellValue(i, "prev_doc_nos")+ sheetObj.CellValue(i, "pre_vsl_dchg_yd_nm");
			if(sameFlag) break;
			
			for(var j= sheetObj.HeaderRows; j<= sheetObj.LastRow; j++) {
				if(sheetObj.CellValue(j,"prev_doc_nos") == "") continue;
				
				if(sheetObj.RowStatus(j) == "I"){
					addListPreDoc = sheetObj.CellValue(j, "prev_doc_nos")+sheetObj.CellValue(j, "pre_vsl_dchg_yd_nm");
					
					
					if(i!=j && allListPreDoc == addListPreDoc) {
						//ComShowMessage("Duplicated value exists.");
						ComShowCodeMessage("BKG06134");
						sameFlag = true;
						sheetObj.RowBackColor(j) = sheetObj.RgbColor(255,255,192);
						break;
					}
				}
			} // end for(j)
			
		} // end for(i)
		
		if(sameFlag) return false;

		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			
			if(form.pgm_no.value == "") break;
			
			if(sheetObj.CellValue(i, "cre_dt") == "") {
				//ComShowMessage("Prev. Doc No is created. SAVE please!");
				ComShowCodeMessage("BKG06137", "created", "SAVE");
				return false;
			}
			if (sheetObj.CellValue(i,"chk") == "1" || sheetObj.CellValue(i,"chk") == "Y") {
				if(sheetObj.CellValue(i, "fixed") == sheetObj.CellValue(i,"prev_doc_nos")+sheetObj.CellValue(i,"pre_vsl_dchg_yd_nm")){
//					ComShowMessage("Nothing Changed!!!");
					ComShowCodeMessage("BKG00737");
					return false;
				}
			}
		}
		return true;
		
		break;
		
		
	case MULTI02: // Prev. Doc Save
		
		// empty row 삭제
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			
			if (sheetObj.CellValue(i,"prev_doc_nos") == "") {
				sheetObj.RowHidden(i) = "true";
			} 
		} 

		// 중복 체크
		var allListPreDoc = "";
		var addListPreDoc = "";
		var sameFlag = false;
		
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
	     	if(sheetObj.CellValue(i,"prev_doc_nos") == "") continue;
			
			allListPreDoc = sheetObj.CellValue(i, "prev_doc_nos")+ sheetObj.CellValue(i, "pre_vsl_dchg_yd_nm");
			if(sameFlag) break;
			
			for(var j= sheetObj.HeaderRows; j<= sheetObj.LastRow; j++) {
				if(sheetObj.CellValue(j,"prev_doc_nos") == "") continue;
				
				if(sheetObj.RowStatus(j) == "I"){
					addListPreDoc = sheetObj.CellValue(j, "prev_doc_nos")+sheetObj.CellValue(j, "pre_vsl_dchg_yd_nm");
					
					if(i!=j && allListPreDoc == addListPreDoc) {
						//ComShowMessage("Duplicated value exists.");
						ComShowCodeMessage("BKG06134");
						sameFlag = true;
						sheetObj.RowBackColor(j) = sheetObj.RgbColor(255,255,192);
						break;
					}
				}
			} // end for(j)
			
		} // end for(i)
		
		if(sameFlag) return false;
		
		
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			if(sheetObj.CellValue(i,"prev_doc_nos") == "") continue;
			if(formObj.pol_cd.value.indexOf("ES") > -1 && sheetObj.CellValue(i, "prev_doc_nos").length < 12) {
				//ComShowMessage("Length of Prev.DocNo must be greater than 11 digit.");
				ComShowCodeMessage("BKG06135");
				return false;
			}
			
			if(formObj.pol_cd.value.indexOf("PT") > -1 && sheetObj.CellValue(i, "prev_doc_nos").length != 23) {
				//ComShowMessage("Length of Prev.DocNo must be  23 digit.");
				ComShowCodeMessage("BKG06136");
				return false;
			}
		}
		return true;
		
		break;
		
	case COMMAND01:
		
		for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
			if(sheetObj.CellValue(i, "cre_dt") == "") {
				//ComShowMessage("Prev. Doc No is created. SAVE please!");
				ComShowCodeMessage("BKG06137", "created", "SAVE");
				return false;
			} 
			if (sheetObj.CellValue(i,"chk") == "1" || sheetObj.CellValue(i,"chk") == "Y") {
				if(sheetObj.CellValue(i, "fixed") != sheetObj.CellValue(i,"prev_doc_nos")+sheetObj.CellValue(i,"pre_vsl_dchg_yd_nm")){
					//ComShowMessage("Prev. Doc No is changed. SELECT please!");
					ComShowCodeMessage("BKG06137", "changed", "SELECT");
					return false;
				}
			}
		}
		return true;
		
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		
		// 현재 check 되어있는 fixed 값에 대한 row 를 pink 컬러로 표시
		for(var i= HeaderRows; i<= LastRow; i++) {
			if (CellValue(i,"chk") == "1" || CellValue(i,"chk") == "Y") {
				RowBackColor(i) = RgbColor(255, 220, 241); // pink
			}
			
			CellEditable(i,"cre_dt") = false;
			CellEditable(i,"msg_func_id") = false;
			CellEditable(i,"prev_doc_nos") = false;
			CellEditable(i,"pre_vsl_dchg_yd_nm") = false;
			
        }
    }//end with
}	


function sheet1_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "chk");
	var colSaveName = sheetObj.ColSaveName(col);

	switch(colSaveName) {
		/* Check Box 클릭시 머리클릭 처리*/
		case "chk" :
			for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i,"chk") == "1" || sheetObj.CellValue(i,"chk") == "Y") {
					sheetObj.CellValue2(i, "chk") = 0;
				} 
			} // end for(i)
			break;
			
	} // end switch
}



function comPopupOK(sheetObj, formObj, sAction) {
	
	//if (!validateForm(sheetObj, formObj, sAction))	return false;
	
	if(!opener){
	  opener = window.dialogArguments;
	}
	
	for(var i= sheetObj.HeaderRows; i<= sheetObj.LastRow; i++) {
		if (sheetObj.CellValue(i,"chk") == "1" || sheetObj.CellValue(i,"chk") == "Y") {
			if(sheetObj.CellValue(i, "fixed") == sheetObj.CellValue(i,"prev_doc_nos")+sheetObj.CellValue(i,"pre_vsl_dchg_yd_nm")){
				opener.document.form.prev_doc_no.value = sheetObj.CellValue(i, "prev_doc_nos");
				opener.document.form.prev_doc_yd.value = sheetObj.CellValue(i, "pre_vsl_dchg_yd_nm");
			}
		} 
	} // end for(i)
	window.close();
}


/* 개발자 작업 끝 */