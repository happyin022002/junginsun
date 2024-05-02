/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0237.js
*@FileTitle : Agreement Confirm Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.21
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
=========================================================*/
/**
 * @extends Trs
 * @class ESD_TRS_0237 : invoice office authority management
 */
 function ESD_TRS_0237(){
 	this.processButtonClick     = processButtonClick;
 	this.setSheetObject         = setSheetObject;
 	this.setComboObject         = setComboObject;
 	this.setTabObject           = setTabObject;
 	this.loadPage               = loadPage;
 	this.initSheet              = initSheet;        
 	this.initControl            = initControl;
 	this.initTab                = initTab;
 	this.doActionIBSheet        = doActionIBSheet;
 	this.validateForm           = validateForm;
 }
 /*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var	ofcSelected = "";
var	invOfcCdSelected = "";
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName){
			case "btng_save":    
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			    break;

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case 'btng_rowadd':
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;

			case 'btng_delete':
				doActionIBSheet(sheetObject,formObject, IBDELETE);
				break;	
				// 엑셀다운로드 버튼
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;		
			case "btn_close":
				window.close();
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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

 function loadPage() {
	 for(i=0;i<sheetObjects.length;i++){
		 //-시작 환경 설정 함수 이름 변경
		 ComConfigSheet(sheetObjects[i]);
		 initSheet(sheetObjects[i],i+1);
		 //-마지막 환경 설정 함수 추가
		 ComEndConfigSheet(sheetObjects[i]);
	 }

	 var sheetObject = sheetObjects[0];
	 var formObject = document.form;
	 doActionIBSheet(sheetObject,formObject,IBSEARCH);
	 //html컨트롤 이벤트초기화
	 //initControl();
 }

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
 function initSheet(sheetObj,sheetNo) {

 	var cnt = 0;

 	switch(sheetNo) {
    	case 1:      //sheet1 init
	    	with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(20) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
			    Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(9, 1 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				var HeadTitle1 = "|status|Confirm User|Confirm User|Confirm Office|Create Office|Creation User|Creation User|Creation Date";
				HeadTitle2 = "|status|ID|Name|Confirm Office|Create Office|Creation User|Creation User|Creation Date";
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,	   50,	daCenter,   true,	"sel", 			  false,    "",      dfNone,          0,         true,        true);
				InitDataProperty(0, cnt++ , dtStatus,      75,  daCenter,   true,   "ibflag",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);				
				InitDataProperty(0, cnt++ , dtData,       100,	daCenter,   true,	"cfm_usr_id",     false,    "",      dfNone,          0,         false,       true, 20);
				InitDataProperty(0, cnt++ , dtData,       200,	daLeft,     true,	"cfm_usr_nm", false,    "",      dfNone,          0,         false,       false);
				InitDataProperty(0, cnt++ , dtData,       100,	daCenter,   true,	"cfm_ofc_cd",         false,    "",      dfNone,          0,         false,       true,6);
				InitDataProperty(0, cnt++ , dtData,       100,	daCenter,   true,	"cre_ofc_cd",         false,    "",      dfNone,          0,         false,       false,6);
				InitDataProperty(0, cnt++ , dtData,       100,	daCenter,   true,	"cre_usr_id",     false,    "",      dfNone,          0,         false,       false);
				InitDataProperty(0, cnt++ , dtData,       200,	daCenter,   true,	"cre_usr_nm",     false,    "",      dfNone,          0,         false,       false);
				InitDataProperty(0, cnt++ , dtData,       150,	daCenter,   true,	"locl_cre_dt",         false,    "",    dfDateYmd,         0,         false,       false);	

				ColHidden('ibflag')= true;
				ColHidden('cre_usr_id')= true;
			}
			break;
		}
	}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
	        //Office Code조회 
	        case IBSEARCH:                      
		        formObj.f_cmd.value = SEARCH01;
		        sheetObj.DoSearch("ESD_TRS_0237GS.do", TrsFrmQryString(formObj));
		        break;
			//입력
			case IBINSERT:      
				//생성 후 기본값 설정하기
				var Row = sheetObj.DataInsert(-1);

				sheetObj.CellValue2(Row, "cre_ofc_cd") = ComGetObjValue(formObj.fm_account_ofc_cd);
				sheetObj.CellValue2(Row, "cre_usr_id") = ComGetObjValue(formObj.fm_account_usr_id);
				sheetObj.CellValue2(Row, "cre_usr_nm") = ComGetObjValue(formObj.fm_account_usr_nm);
				sheetObj.CellValue2(Row, "locl_cre_dt") = ComGetObjValue(formObj.fm_today);
				sheetObj.SelectCell(Row, "cfm_usr_id");
				break;	
	        //저장
	        case IBSAVE:        
		        if(!validateForm(sheetObj, formObj, sAction)) return false;
		        formObj.f_cmd.value = MULTI01;
				sheetObjects[0].DoSave("ESD_TRS_0237GS.do", TrsFrmQryString(formObj),-1,false);
				break;
			//row선택 후 삭제 
			case IBDELETE:
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				} else {
					if(!confirm(ComGetMsg('COM12165', 'Agreement Confirm Authority')) )
					{
						return false;
					}	
					formObj.f_cmd.value = REMOVE;
	            	sheetObj.DoSave("ESD_TRS_0237GS.do",TrsFrmQryString(formObj),'sel',false);
				}
				break;
			case IBDOWNEXCEL:
				sheetObj.Down2Excel(-1, false, false, true);    	   
				break;
			}	
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
 function validateForm(sheetObj,formObj,sAction){
 	return true;
 }

 function sheet1_OnChange(sheetObj, row, col, value) {

 	var colName = sheetObj.ColSaveName(col);
 	var formObj = document.form;
 	switch(colName)
 	{
 		case ('cfm_usr_id'):
 		 	formObj.f_cmd.value = SEARCH02;
 		
			if( sheetObj.cellValue(row, 'cfm_usr_id') != '' )
			{
				var cfm_usr_id = sheetObj.cellValue(row, 'cfm_usr_id');
		 		var urlStr = 'cfm_usr_id='+cfm_usr_id;
				sheetObj.DoRowSearch('ESD_TRS_0237GS.do',urlStr+'&'+TrsFrmQryString(formObj));
				var cfmUsrNm = sheetObj.EtcData('cfmUsrNm');
				var cfmOfcCd = sheetObj.EtcData('cfmOfcCd');
				
		 		if(cfmUsrNm=="null"||cfmUsrNm==""){
		 			sheetObj.CellValue2(row, 'cfm_usr_id') = "";
		 			sheetObj.CellValue2(row, 'cfm_usr_nm') = "";
		 			sheetObj.CellValue2(row, 'cfm_ofc_cd') = "";
		 		}else{
		 			sheetObj.CellValue2(row, 'cfm_usr_nm') = cfmUsrNm;
		 			sheetObj.CellValue2(row, 'cfm_ofc_cd') = cfmOfcCd;
		 		}
			}
	 		break; 				
 	}
 }

 /**
  * 저장후 발생하는 이벤트를 처리
  */
  function sheet1_OnSaveEnd(sheetObj, errMsg) {
  	var formObj = document.form;
  	if( errMsg != null && errMsg != '' ) {
		 //ComShowMessage(errMsg);
		} else {
			if(formObj.f_cmd.value == MULTI01){
				ComShowCodeMessage('COM130102', 'Agreement Confirm Authority');
			}else if(formObj.f_cmd.value == REMOVE){			
				var checkList = sheetObj.FindCheckedRow('sel');
				var checkArray = checkList.split('|');
				for(var k=checkArray.length-2; k>=0; k--)
				{
					sheetObj.RowDelete(checkArray[k], false);
				}
				
				ComShowCodeMessage('COM12167', 'Agreement Confirm Authority');
			}
		}
	}