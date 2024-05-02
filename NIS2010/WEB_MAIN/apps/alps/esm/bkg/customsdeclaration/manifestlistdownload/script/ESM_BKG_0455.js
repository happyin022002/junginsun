/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0455.js
 *@FileTitle : ESM_BKG-0455
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.06.03 김승민
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
 * @class ESM_BKG-0455 : ESM_BKG-0455 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0455() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    /** **************************************************** */
    var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

       switch(srcName) {

	          case "btn_save":
	        	  doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	        	  break; 
         
	          case "btn_close":
	        	  doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	        	  break;

	          case "btn_add":
	        	  doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
					break;

	          case "btn_delete":
	        	  doActionIBSheet(sheetObjects[0], document.form, IBDELETE);      	
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
}
doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

}




/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
			var sheetID = sheetObj.id;
			
    switch(sheetID) {
			case "sheet1":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 205;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(17, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle1 = "|Sel.|Seq.||CONTAINER|Type|SEAL No1|SEAL No2|SEAL No3|SEAL No4|SEAL No5|SEAL No6|P|R / D|R / D|Empty/Full|Supplied";
                
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
				// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
				// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,		true,	"ibflag");
                InitDataProperty(0, cnt++ , dtCheckBox,		40, 	daCenterTop,	true,	"del_chk");
                InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,		true,   "seq");       
                InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,		true,   "bl_no");
                InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		true,   "cntr_no",			true,		"",      dfNone,	0,     true,	true, 14);
                InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,   "cntr_tpsz_cd",		false,		"",      dfNone,	0,     true,	true, 2);
                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,   "cntr_seal_no",		false,		"",      dfNone,	0,     true,	true, 20);
                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,   "cntr_seal_no2",		false,		"",      dfNone,	0,     true,	true, 20);
                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,   "cntr_seal_no3",		false,		"",      dfNone,	0,     true,	true, 20);
                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,   "cntr_seal_no4",		false,		"",      dfNone,	0,     true,	true, 20);
                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,   "cntr_seal_no5",		false,		"",      dfNone,	0,     true,	true, 20);
                InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,   "cntr_seal_no6",		false,		"",      dfNone,	0,     true,	true, 20);
                                                                                                                                           	
                InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,		true,   "prt_flg",			false,		"",      dfNone,   	0,     true,	true);
                InitDataProperty(0, cnt++ , dtData,			25,		daCenter,		true,   "rcv_term_cd",		false,		"",      dfNone,   	0,     true,	true, 1);
                InitDataProperty(0, cnt++ , dtData,			25,		daCenter,		true,   "de_term_cd",		false,		"",      dfNone,	0,     true,	true, 1);
                InitDataProperty(0, cnt++ , dtCombo,		110,	daCenter,		true,   "full_mty_cd",		false,		"",      dfNone,   	0,     true,	true); 
                InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,		true,   "jp_cntr_ownr_cd",	false,		"",      dfNone,   	0,     true,	true);                    
                                                        
                InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789"); 	
                InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789"); 
                InitDataValid(0, "cntr_seal_no", vtEngUpOther, "0123456789"); 
                InitDataValid(0, "rcv_term_cd", vtEngUpOther); 
                InitDataValid(0, "de_term_cd", vtEngUpOther); 
				// InitDataCombo(0, "prt_flg", "N\tN|Y\tY", "N|Y", "N", "N", 1);
				InitDataCombo(0, "prt_flg", "N|Y", "N|Y", "N", "N", 0);
				// InitDataCombo(0, "full_mty_cd", "E\t[E]Empty|F\t[F]Full",
				// "E|F", "[E]Empty", "E", 1);
				InitDataCombo(0, "full_mty_cd", "Empty|Full", "M|F", "Empty", "M", 0);
				// InitDataCombo(0, "jp_cntr_ownr_cd",
				// "1\t[1]Shipper|2\t[2]Carrier", "1|2", "[1]Shipper", "1", 1);
				InitDataCombo(0, "jp_cntr_ownr_cd", "Shipper|Carrier", "1|2", "Shipper", "1", 0);
														
				CountPosition = 0;

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
	
		case IBSAVE: // 조회
			if (validateForm(sheetObj, formObj, sAction))
			{
				//alert("test");
				formObj.f_cmd.value = MULTI;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.DoAllSave("ESM_BKG_0455GS.do", FormQueryString(formObj));
				
				state = sheetObj.EtcData("TRANS_RESULT_KEY");

				if (state == "S") {
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}	
				ComOpenWait(false);
			}
			break;			
			
		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction))
			{
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				// alert(sheetObj.cellValue(1,"bl_no"));
				// alert(sheetObj.cellValue(1,"vvd_cd"));
				// alert(sheetObj.cellValue(1,"pod_cd"));
				sheetObj.DoSearch("ESM_BKG_0455GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}			
			break;
		case COMMAND01: // 입력
			var vIsCheck = true
			for(var i=1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.RowStatus(i) == "I"||
					sheetObj.RowStatus(i) == "U"||
					sheetObj.RowStatus(i) == "D") {
					vIsCheck = false;
					break;
				}
			}
			if (vIsCheck) {
				opener.retrieve();
        		window.close();
        		break;
			}			
			
			if (!validateForm(sheetObj, formObj, sAction))
			{			
				opener.retrieve();
        		window.close();
			} else {
				formObj.f_cmd.value = MULTI;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.DoAllSave("ESM_BKG_0455GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
			break;	
		case IBDELETE: // 입력
			if (validateForm(sheetObj, formObj, sAction))
			{			
				//alert("test1");
				var delrows = sheetObj.FindCheckedRow("del_chk");
				// alert("test2");
				var arrRow = delrows.split("|");
				// alert("test3");
				for ( var i = 0; i < arrRow.length - 1; i++) {
					sheetObj.RowHidden(arrRow[i]) = true;
					sheetObj.RowStatus(arrRow[i]) = "D";
				}	
			}	
			break;	
		case IBINSERT: // 입력
			sheetObj.DataInsert(-1);
			break;			
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	case IBSAVE:
		var vIsCheck = false;
		
		vIsCheck = validCheck(sheetObj);

		if (!vIsCheck) {
			ComShowCodeMessage('BKG00260','');
			// alert("1111There is no contents to save");
			return false;
		}		
		return true;
		break;	
	case COMMAND01:
		var vIsCheck = false;
		vIsCheck = validCheck(sheetObj);

		if (!vIsCheck) {
			//ComShowCodeMessage('BKG00265','');
			if ( !ComShowCodeConfirm("BKG00350") )
			{
				return false;
			}
		}		
		return true;
		break;	
	case IBDELETE: // 조회
		var vIsCheck = false;
		// alert(sheetObj.RowCount);
		for(var i=1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249','');
			return false;
		}			
		
		if (!ComShowCodeConfirm("COM12188")) {
			return false;
		}		
		return true;
		break;		
	case IBSEARCH:
		return true;
		break;			
	}
}

/**
* Sheet 에서 변경여부 체크
* @param sheetObj Sheet
*/
function validCheck(sheetObj)
{
	for(var i=1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.RowStatus(i) == "I"||
			sheetObj.RowStatus(i) == "U"||
			sheetObj.RowStatus(i) == "D") {
			return true;
		}
	}
	return false;
}

/**
* Sheet 에서 필수 컬럼 체크
* @param sheetObj Sheet
* @param Row Row
* @param Col Col
* @param Value Value
*/
function sheet1_OnValidation(sheetObj,Row,Col,Value)
{
	//alert(Col+":"+Value);
	switch(Col)
	{
		case 4:
			if ( sheetObj.RowStatus(Row) != "D" )
			{
				if ( Value=="" )
				{
					ComShowCodeMessage('BKG01028');
					sheetObj.ValidateFail = true;
					sheetObj.SelectCell(Row, Col);
					return false;
				}		
			}
			break;
	}
}
/* 개발자 작업 끝 */